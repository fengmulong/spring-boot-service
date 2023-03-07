package com.lyd.config;

import com.lyd.config.annotation.Auth;
import com.lyd.exception.NoAuthException;
import com.lyd.exception.UnauthorizedException;
import com.lyd.service.AccountService;
import com.lyd.util.Constant;
import com.lyd.util.JwtUtil;
import com.lyd.vo.MyScope;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;

@Slf4j
@AllArgsConstructor
@Aspect
@Component
public class AuthAspect {

    private final AccountService accountService;

    @Before("execution(* com.lyd.controller..*.*(..))")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            HttpServletRequest request = attributes.getRequest();
            String content = "收到请求 | URL:" + request.getRequestURL() +
                    " | HTTP_METHOD:" + request.getMethod() +
                    " | IP:" + request.getRemoteAddr() +
                    " | CLASS_METHOD:" + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName() +
                    " | ARGS:" + Arrays.toString(joinPoint.getArgs());
            log.info(content);
        }
    }

    @Around("execution(* com.lyd.controller..*.*(..)) && !@annotation(com.lyd.config.annotation.NoAuth)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();
        String token = request.getHeader(Constant.AUTHORIZATION);
        if (StringUtils.isEmpty(token)) {
            throw new UnauthorizedException();
        }
        int userId;
        try {
            userId = JwtUtil.getUserId(token);
        } catch (Exception e) {
            throw new UnauthorizedException();
        }
        MyScope scope = accountService.cacheScope(userId);
        request.setAttribute(Constant.SCOPE, scope);
        //admin有所有权限
        if (Constant.ADMIN_ID.equals(scope.getUserId())) {
            return joinPoint.proceed();
        }
        MethodSignature methodSignature = (MethodSignature) joinPoint.getStaticPart().getSignature();
        Method method = methodSignature.getMethod();
        Auth auth = method.getAnnotation(Auth.class);
        if (auth != null) {
            String[] authNames = auth.value();
            Set<String> permissions = scope.getPermissions();
            boolean hasAuth = false;
            for (String authName : authNames) {
                if (permissions.contains(authName)) {
                    hasAuth = true;
                    break;
                }
            }
            if (!hasAuth) {
                throw new NoAuthException();
            }
        }
        return joinPoint.proceed();
    }
}

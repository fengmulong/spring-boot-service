package com.lyd.util;

import com.lyd.exception.UnauthorizedException;
import com.lyd.vo.MyScope;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 获取当前用户
 */
public class ScopeUtil {

    public static MyScope getScope() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (requestAttributes != null) {
            return (MyScope) requestAttributes.getAttribute(Constant.SCOPE, RequestAttributes.SCOPE_REQUEST);
        }
        throw new UnauthorizedException();
    }

    public static Integer getUserId() {
        return getScope().getUserId();
    }

    public static String getPhone() {
        return getScope().getPhone();
    }

}

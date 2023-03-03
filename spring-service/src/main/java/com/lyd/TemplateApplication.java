package com.lyd;

import com.lyd.entity.Ssq;
import com.lyd.service.Test;
import com.lyd.util.SSQUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.ansi.AnsiColor;
import org.springframework.boot.ansi.AnsiOutput;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@Slf4j
@AllArgsConstructor
@EnableCaching
@EnableScheduling
@MapperScan("com.lyd.mapper")
@SpringBootApplication
public class TemplateApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(TemplateApplication.class, args);
    }

    @Override
    public void run(String... strings) {
        log.info(AnsiOutput.toString(AnsiColor.GREEN, "-------------------平台启动成功-------------------"));
    }

}

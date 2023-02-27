package com.step.template.main;

import com.step.template.main.util.SSQUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@SpringBootApplication
public class TemplateApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TemplateApplication.class, args);
        StringBuilder stringBuilder=new StringBuilder("abcdsd");
        System.out.println(stringBuilder.reverse());
    }

    @Override
    public void run(String... strings) {
        log.info(AnsiOutput.toString(AnsiColor.GREEN, "-------------------平台启动成功-------------------"));
    }

}

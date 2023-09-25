package com.barclays.repohack.Barclaysrepohack.io.swagger;


import com.barclays.repohack.Barclaysrepohack.io.swagger.configuration.LocalDateConverter;
import com.barclays.repohack.Barclaysrepohack.io.swagger.configuration.LocalDateTimeConverter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.oas.annotations.EnableOpenApi;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;


@SpringBootApplication
@EnableOpenApi
@ComponentScan(basePackages = { "io.swagger.*"})
@ComponentScan({"com.barclays.repohack.Barclaysrepohack.io.swagger","com.barclays.repohack.Barclaysrepohack.io.swagger.api", "com.barclays.repohack.Barclaysrepohack.io.swagger.configuration","com.barclays.repohack.Barclaysrepohack.io.swagger.service",
"com.barclays.repohack.Barclaysrepohack.io.swagger.entities", "com.barclays.repohack.Barclaysrepohack.io.swagger.repo"})
public class Swagger2SpringBoot implements CommandLineRunner {

    @Override
    public void run(String... arg0) throws Exception {
        if (arg0.length > 0 && arg0[0].equals("exitcode")) {
            throw new ExitException();
        }
    }

    public static void main(String[] args) throws Exception {
        new SpringApplication(Swagger2SpringBoot.class).run(args);
    }

    @Configuration
    static class CustomDateConfig extends WebMvcConfigurationSupport {
        @Override
        public void addFormatters(FormatterRegistry registry) {
            registry.addConverter(new LocalDateConverter("yyyy-MM-dd"));
            registry.addConverter(new LocalDateTimeConverter("yyyy-MM-dd'T'HH:mm:ss.SSS"));
        }
    }

    class ExitException extends RuntimeException implements ExitCodeGenerator {
        private static final long serialVersionUID = 1L;

        @Override
        public int getExitCode() {
            return 10;
        }

    }
}

package com.example.SchoolLunchReport.global.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(apiInfo())
            .components(createComponents())
            .addSecurityItem(createSecurityRequirement());
    }

    private static SecurityRequirement createSecurityRequirement() {
        return new SecurityRequirement().addList("Authorization");
    }

    private static Components createComponents() {
        return new Components()
            .addSecuritySchemes("Authorization", new SecurityScheme()
                .type(SecurityScheme.Type.APIKEY)
                .in(SecurityScheme.In.HEADER)
                .name("Authorization")
            );
    }


    private static Info apiInfo() {
        return new Info().title("팀프로젝트 보고서 API")
            .version("1.0")
            .description("My API Description");
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
            .group("전체")
            .pathsToMatch("/**")
            .build();
    }


}
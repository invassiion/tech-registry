package com.example.techregistry.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    public OpenAPI customOpenAPI() {
        return  new OpenAPI()
                .info(new Info()
                        .title("Tech Registry API")
                        .version("1.0")
                        .description("API для управления реестром техники"));


    }

    public OpenApiCustomiser sortOperationsAlphabetically() {
        return openApi -> openApi.getPaths().values().forEach(pathItem -> {
            pathItem.readOperations().sort(((o1, o2) -> o1.getOperationId().compareTo(o2.getOperationId())));
        });
    }
}

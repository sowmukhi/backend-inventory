package com.neoteric.avoota_inventory.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI()
                .info(new Info()
                        .title("Avoota Inventory API")
                        .description("APIs for managing hotel room availability and rate plan prices")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Support Team")
                                .email("support@avoota.com")
                        )
                );
    }
}

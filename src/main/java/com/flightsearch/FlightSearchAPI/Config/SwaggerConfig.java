package com.flightsearch.FlightSearchAPI.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("FlightSearchAPI")
                        .version("1.0")
                        .description("FlightSearchAPI is an API used to display flight information.")
                        .termsOfService("http://swagger.io/terms/")
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org")
                        )
                        .contact(new Contact()
                                .email("furkannkck@outlook.com")
                                .name("Full Stack Developer")
                                .url("https://github.com/kucukfurkan")
                        )
                );
    }
}

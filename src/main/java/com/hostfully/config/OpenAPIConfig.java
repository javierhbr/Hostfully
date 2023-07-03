package com.hostfully.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI myOpenAPI() {

        Contact contact = new Contact();
        contact.setEmail("javierhbr@gmail.com");
        contact.setName("Javier Benavides");
        contact.setUrl("http://localhost:8080");

        Info info = new Info()
                .title("Booking Test API")
                .version("1.0")
                .contact(contact)
                .description("This API exposes endpoints to manage Bookings.");

        return new OpenAPI().info(info);
    }
}

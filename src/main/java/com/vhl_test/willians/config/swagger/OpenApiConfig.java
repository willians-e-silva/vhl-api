package com.vhl_test.willians.config.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "VHL - Fullstack Developer Test | TJSC API",
                version = "1.0.0",
                description = "Documentation for the vhl fullstack developer challenge",
                contact = @Contact(
                        name = "Willians Eduardo Da Silva",
                        email = "willians.silva0620@gmail.com",
                        url = "https://github.com/willians-e-silva"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.apache.org/licenses/LICENSE-2.0.html"
                )
        ),
        servers = {
                @Server(url = "/", description = "Default Server URL")
        }
)
public class OpenApiConfig {
}
package com.raphael.investControlApi.config;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info; 
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springdoc.core.models.GroupedOpenApi;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("InvestControl API")
                        .version("1.0")
                        .description("API for GF Test")
                        .contact(new Contact()
                                .name("Raphael"))); 


                                 
}


@Bean
public GroupedOpenApi publicApi() {
    return GroupedOpenApi.builder()
            .group("investments")
            .pathsToMatch("/**")
            .build();


}

}
package com.barclays.repohack.Barclaysrepohack.io.swagger.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

//@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-09-15T12:53:09.143146271Z[GMT]")
@Configuration
public class SwaggerDocumentationConfig {

    @Bean
    public Docket customImplementation(){
        return new Docket(DocumentationType.OAS_30)
                .select()
                    .apis(RequestHandlerSelectors.basePackage("io.swagger.api"))
                    .build()
                .directModelSubstitute(org.threeten.bp.LocalDate.class, java.sql.Date.class)
                .directModelSubstitute(org.threeten.bp.OffsetDateTime.class, java.util.Date.class)
                .apiInfo(apiInfo());
    }

    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("Barclays RepoHack 2023 API")
            .description("APIs for the dealers’ and clients’ interactions with financial market infrastructure services (Trade matching middleware, CCPs, CSDs) for the Barclays 2023 Repo Hackathon.<br>Please ensure you include your API key in the `x-api-key` header of your requests.")
            .license("")
            .licenseUrl("http://unlicense.org")
            .termsOfServiceUrl("")
            .version("0.12")
            .contact(new Contact("","", ""))
            .build();
    }

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
            .info(new Info()
                .title("Barclays RepoHack 2023 API")
                .description("APIs for the dealers’ and clients’ interactions with financial market infrastructure services (Trade matching middleware, CCPs, CSDs) for the Barclays 2023 Repo Hackathon.<br>Please ensure you include your API key in the `x-api-key` header of your requests.")
                .termsOfService("")
                .version("0.12")
                .license(new License()
                    .name("")
                    .url("http://unlicense.org"))
                .contact(new io.swagger.v3.oas.models.info.Contact()
                    .email("")));
    }

}

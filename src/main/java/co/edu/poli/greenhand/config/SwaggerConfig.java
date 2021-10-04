package co.edu.poli.greenhand.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket customerApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("co.edu.poli.greenhand.controller")) //Specific package
				.paths(PathSelectors.any())
				.build()
				.apiInfo(greenHandApiInfo())
				.tags(new Tag("Class: CustomerController", "*** Customer Controller ***"));
	}

	private ApiInfo greenHandApiInfo() {
		return new ApiInfoBuilder()
				.title("Green Hand Aplication")
				.description("Backend of green hand aplication")
				.contact(new Contact("Web App Green Hand", "", "jsangel@poligran.edu.co"))
				.version("0.0.1")
				.build();
	}
}
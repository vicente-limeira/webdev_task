package rn.gov.webdev_task;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@EnableSwagger2
*/
@SpringBootApplication
public class Webdev_taskApplication {

    public static void main(String[] args) {
        SpringApplication.run(Webdev_taskApplication.class, args);
    }

    /*
    @Bean
	public Docket productApi(){
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("rn.gov.webdev_task.controller"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo( new ApiInfoBuilder().version("1.0").title("API Loja").description("Uma API para minha loja").build());
	}    
*/
}

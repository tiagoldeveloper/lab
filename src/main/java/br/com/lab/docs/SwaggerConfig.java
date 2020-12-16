package br.com.lab.docs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import static springfox.documentation.builders.PathSelectors.regex;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {

    public List<Parameter> operationParameters(){
        var parameters = new ArrayList<Parameter>();
        var parameter = new ParameterBuilder()
                .name("Authorization")
                .description("Bearer token")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .build();
        parameters.add(parameter);
        return parameters;
    }

    private List<ResponseMessage> responseMensages(){
        return List.of(new ResponseMessageBuilder()
                .code(500)
                .message("Ocorreu erro no servidor, verifique se as informações estão corretas e tente novamente.")
                .responseModel(new ModelRef("Ocorreu erro."))
                .build(),
                 new ResponseMessageBuilder()
                .code(403)
                .message("Acesso negado, verifique se seu token está correto e tente novamente.")
                .build());
    }

    @Bean
    public Docket apiDoc() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.lab.controller"))
                .paths(regex("/v1.*"))
                .build()
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET, responseMensages())
                .globalOperationParameters(operationParameters())
                .apiInfo(metaData());
    }

    private ApiInfo metaData(){
        return new ApiInfoBuilder()
                .title("Controle de Permissões")
                .description("Api de controle de permissão por grupo de usuário.")
                .version("1.0")
                .contact(new Contact("Tiago Lima", "https://github.com/tiagoldeveloper", "tiago.ldeveloper@gmail.com"))
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/license/LICENSE-2.0")
                .build();
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
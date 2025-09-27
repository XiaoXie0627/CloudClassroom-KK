package com.ymcc.scommon.conifg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Light xhh032533@163.com
 * @text Passion！无他,唯手熟尔！More Code & Thinking Why, 每一行代码但是你进步的基石！理解大于记忆
 * @time 2025/9/26 05:46
 */
@Configuration
@EnableSwagger2
public class ServiceSystemSwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //对外暴露服务的包,以controller的方式暴露,所以就是controller的包.
                .apis(RequestHandlerSelectors.basePackage("com.ymcc.service.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("管理系统")
                .description("管理系统接口文档说明")
                .contact(new Contact("whale.chen", "", "whale.chen@cjc.cn"))
                .version("1.0")
                .build();
    }

}

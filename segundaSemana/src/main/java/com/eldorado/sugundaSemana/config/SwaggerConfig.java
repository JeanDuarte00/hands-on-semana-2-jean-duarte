package com.eldorado.sugundaSemana.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaData());
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("Academias HHZZE REST API")
                .description(String.join("A rede de academias HHZZE, possui cadastrado no Brasil mais de 100 mil usuários,"
                        ,"visando manter a fidelidade de seus clientes, a empresa resolveu oferecer"
                        ,"gratuitamente acompanhamento nutricional, porém os cadastros, são"
                        ,"descentralizados, cada academia mante sua lista própria de cliente, então a"
                        ,"HHZZE deseja fornecer um sistema único que concentre o cadastro de todos os"
                        ,"clientes em uma base de dados noSql e colete algumas informações, e escreveu as"
                        ,"seguintes histórias de usuário"))
                .version("0.1.0")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .build();
    }

}
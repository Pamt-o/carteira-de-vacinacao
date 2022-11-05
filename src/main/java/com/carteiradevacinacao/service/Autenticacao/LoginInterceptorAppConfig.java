package com.carteiradevacinacao.service.Autenticacao;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class LoginInterceptorAppConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .excludePathPatterns(
                        "/login",
                        "/erros",
                        "/logar",
                        "/js/**",
                        "/css/**",
                        "/img/**",
                        "/lib/**",
                        "/assets/**"
                        );

    }

}

package com.greedy.bookshop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer
{

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        registry.addResourceHandler("static/image/**")
                .addResourceLocations("classpath:/image/");
        registry.addResourceHandler("static/css/**")
                .addResourceLocations("classpath:/css/");
        registry.addResourceHandler("static/js/**")
                .addResourceLocations("classpath:/js/");
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }
}

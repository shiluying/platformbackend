package com.shiluying.platformbackend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ImageConfig implements WebMvcConfigurer {
    @Override
//      请求拦截
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/commodities/**").addResourceLocations("file:E:/test/commodities/");
        registry.addResourceHandler("/images/usercomment/**").addResourceLocations("file:E:/test/usercomment/");
    }
}

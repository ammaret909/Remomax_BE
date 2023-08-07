package com.example.RemomaxBE.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer{
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000","http://3.144.19.48/rmxtest")
                .allowedMethods("GET", "POST","PUT","DELETE")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}

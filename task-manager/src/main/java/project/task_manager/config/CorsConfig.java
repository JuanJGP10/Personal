package project.task_manager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**")
                        .allowedOrigins("http://localhost:5173")
                        .allowedMethods("GET", "POST", "PUT", "DELETE");
                registry.addMapping("/api/**")
                        .allowedOrigins("http://172.18.184.121:5173")
                        .allowedMethods("GET", "POST", "PUT", "DELETE");
                registry.addMapping("/api/**")
                        .allowedOrigins("http://192.168.56.1:5173")
                        .allowedMethods("GET", "POST", "PUT", "DELETE");
            }
        };
    }
}

package ai.north.thought.configs;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Конфигурация для WebMvc
 */
@Component
public class WebConfig implements WebMvcConfigurer {
    /**
     * Конфигурация CORS
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:5173")
                .allowedMethods("POST", "GET", "PATCH", "DELETE")
                .allowCredentials(true);
    }
}

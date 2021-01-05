package our.example.furniture.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 이미지 외부경로 매핑 Configuration

@Configuration
public class ResourceHandlers implements WebMvcConfigurer {
    @Value("${resources.location}")
    private String resourcesLocation;
    @Value("${resources.urlPath}")
    private String resourcesUrlPath;


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(resourcesUrlPath + "/**")
                .addResourceLocations("file:///C:" + resourcesLocation);
    }
}

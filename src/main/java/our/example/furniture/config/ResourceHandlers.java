package our.example.furniture.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 이미지 외부경로 매핑 Configuration
@Configuration
public class ResourceHandlers implements WebMvcConfigurer {
    @Value("${resources.location_Main}")
    private String resourcesLocation_Main;
    @Value("${resources.urlPath_Main}")
    private String resourcesUrlPath_Main;
    @Value("${resources.location_Inner}")
    private String resourcesLocation_Inner;
    @Value("${resources.urlPath_Inner}")
    private String resourcesUrlPath_Inner;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(resourcesUrlPath_Main + "/**")
                .addResourceLocations("file:///C:" + resourcesLocation_Main);
        registry.addResourceHandler(resourcesUrlPath_Inner + "/**")
                .addResourceLocations("file:///C:" + resourcesLocation_Inner);
    }
}

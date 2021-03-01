package our.example.furniture.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import our.example.furniture.filter.LoginFilter;

// 서블릿 필터 Bean 등록
@Configuration
public class FilterRegister{
    @Bean
    public FilterRegistrationBean firstFilterRegister() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new LoginFilter());
        return registrationBean;
    }
}
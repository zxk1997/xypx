package manage.xypx.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import manage.xypx.AOP.UserAuth;

@Configuration
public class MVCConfig implements WebMvcConfigurer {
	@Value("${spring.mvc.alloworigin}")
	String allowOrigin;
	
	@Autowired
	UserAuth auth;
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		
		registry.addMapping("/**").
		allowedOrigins(allowOrigin).
		allowCredentials(true).
		allowedMethods("GET","POST","OPTIONS","PUT","DELETE").
		maxAge(1728000)
		;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(auth).excludePathPatterns("/manage/login");
	}
	

}

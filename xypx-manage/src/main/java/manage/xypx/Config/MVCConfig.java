package manage.xypx.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MVCConfig implements WebMvcConfigurer {
	
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		
		registry.addMapping("/**").
		allowedOrigins("*").
		allowCredentials(true).
		allowedMethods("GET","POST","OPTIONS","PUT","DELETE").
		maxAge(1728000)
		;
	}

}

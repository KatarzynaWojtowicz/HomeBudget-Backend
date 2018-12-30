package pl.katarzynawojtowicz.BudgetPlanner.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/api/**")
				.allowedOrigins("http://localhost")
				.allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH")
				.allowedHeaders("User-Agent,Referer,Origin,Host,Connection,Access-Control-Request-Method,"
						+ "Access-Control-Request-Headers,Cache-Control,Origin,X-Requested-With,Content-Type,"
						+ "content-type,Accept,Accept-Encoding,Accept-Language")
				.allowCredentials(true);
	}
}
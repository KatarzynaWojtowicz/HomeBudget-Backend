package pl.katarzynawojtowicz.BudgetPlanner.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

public class CustomCorsFilter extends CorsFilter {

	public CustomCorsFilter(CorsConfigurationSource configSource) {
		super(configSource);
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
		response.setHeader("Access-Control-Allow-Methods", "HEAD, GET, PUT, POST, DELETE, PATCH");
		response.setHeader("Access-Control-Allow-Headers", "User-Agent,Referer,Origin,Host,Connection,"
				+ "Access-Control-Request-Method,Access-Control-Request-Headers,Cache-Control,Origin,"
				+ "X-Requested-With,Content-Type,content-type,Accept,Accept-Encoding,Accept-Language");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		super.doFilterInternal(request, response, filterChain);
	}
}

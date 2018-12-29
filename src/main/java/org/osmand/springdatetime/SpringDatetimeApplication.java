package org.osmand.springdatetime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@SpringBootApplication
public class SpringDatetimeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDatetimeApplication.class, args);
	}
	
	
}

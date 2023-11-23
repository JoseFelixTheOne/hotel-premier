package com.hotelpremier.Hotel.Premier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class HotelPremierApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelPremierApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://192.168.3.39:4200", "http://localhost:4200")
						.allowedMethods("*")
						.allowedHeaders("*");
			}
		};
	}

}

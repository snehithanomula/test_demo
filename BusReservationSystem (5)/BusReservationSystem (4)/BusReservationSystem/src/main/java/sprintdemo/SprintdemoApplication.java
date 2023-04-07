package sprintdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SprintdemoApplication {
	
	
	@Bean
	
	public WebMvcConfigurer crosConfigurer()
			
	{
	return new WebMvcConfigurer() {
					
	public void addCrosMappings(CorsRegistry registry)
	{
	registry.addMapping("/*").allowedHeaders("*").allowedOrigins("*").allowedMethods("*").allowCredentials(true);
	}
					
	};
	}	

	public static void main(String[] args) {
		SpringApplication.run(SprintdemoApplication.class, args);
	}

}

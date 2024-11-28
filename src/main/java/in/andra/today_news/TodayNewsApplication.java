package in.andra.today_news;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;



@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Today News API", version = "1.0", description = "API for Today News application"))
public class TodayNewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodayNewsApplication.class, args);
	}

}

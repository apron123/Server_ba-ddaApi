package com.ziumks.badda;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@OpenAPIDefinition(
		info = @Info(
				title = "ba-dda API",
				version = "1.0",
				description = "체계 데이터 및 어플리케이션 상태 수신 api"
		)
)
@EnableScheduling
@SpringBootApplication
public class BaDdaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaDdaApiApplication.class, args);
	}

}

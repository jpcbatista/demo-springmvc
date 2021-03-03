package br.com.alura.mvc.mvcdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class MvcDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MvcDemoApplication.class, args);
	}

}

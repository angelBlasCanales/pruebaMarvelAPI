package mx.com.angeldev.marvelapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"mx.com.angeldev.marveljar.*", "mx.com.angeldev.marvelapi.*"})
public class MarvelApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarvelApiApplication.class, args);
	}

}

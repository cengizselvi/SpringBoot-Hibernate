package com.crud.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	//İşlevsel bir arabirim, yalnızca bir soyut yöntemi olan bir Java arabirimidir (yani, yönergeleri olmayan, yalnızca bir adı olan bir yöntem).
	//İşlevsel arayüzler, lambda işlevleriyle birlikte kullanılır.
	@Bean
	public CommandLineRunner commandLineRunner(String[] args) {
		// Spring beans yüklendikten sonra çalıştırılacak ve bunu verilen bu yöntem içinde kullanabileceğiz.
		return runner -> {
			System.out.println("Hello World");
		};
	}

}

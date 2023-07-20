package com.crud.cruddemo;

import com.crud.cruddemo.dao.StudentDAO;
import com.crud.cruddemo.entity.Student;
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
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		// Spring beans yüklendikten sonra çalıştırılacak ve bunu verilen bu yöntem içinde kullanabileceğiz.
		return runner -> {
			createStudent(studentDAO);
			readStudent(studentDAO);

		};
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("sorgulama id: 2 "  );
		Student myStudent=studentDAO.findById(2);
		System.out.println(myStudent);
	}

	private void createStudent(StudentDAO studentDAO) {

		//öğrenci nesnesini oluşturma
		System.out.println("Yeni öğrenci oluşturuluyor..");
		Student tempStudent = new Student("Cengiz","Selvi","cengizselvi@gmail.com");

		//öğrenci nesnesini kaydetme
		System.out.println("Öğrenci Kaydediliyor");
		studentDAO.save(tempStudent);

		//kaydedilen öğrenci kimliğini görüntüleme
		System.out.println("Öğrenci Kaydedildi. İD:  " + tempStudent.getId());



	}

}

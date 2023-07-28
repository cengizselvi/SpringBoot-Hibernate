package com.crud.cruddemo;

import com.crud.cruddemo.dao.StudentDAO;
import com.crud.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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
			//createStudent(studentDAO);
			//readStudent(studentDAO);
			//queryForStudent(studentDAO);
			//queryForStudentsByLastName(studentDAO);
			updateStudent(studentDAO);




		};
	}

	private void updateStudent(StudentDAO studentDAO) {

		//primery key'e göre öğrenciyi güncelleme
		int studentId=1;
		System.out.println("Ogrencinin ID'si: " + studentId);
		Student myStudent= studentDAO.findById(studentId);

		//öğrenci adını değiştirme
		System.out.println("Ogrenci adı degistiriliyor...");
		myStudent.setFirstName("Murat");

		//öğrenciyi güncelle
		studentDAO.update(myStudent);

		//güncellenen öğrenciyi göster
		System.out.println("Guncellendi: " + myStudent);

	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student>  theStudents= studentDAO.findbyLastName("Selvi");
		for (Student tempStudent : theStudents )
			System.out.println(tempStudent);
	}

	private void queryForStudent(StudentDAO studentDAO) {
		// öğrencilerin listesini almak
		List<Student> theStudents = studentDAO.findAll();

		for (Student tempStudent : theStudents)
			System.out.println(tempStudent);

	}

	private void readStudent(StudentDAO studentDAO) {

		Student myStudent=studentDAO.findById(2);
		System.out.println("sorgulama id:  " + myStudent.getId()   );
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

package net.javaguides.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.javaguides.sms.entity.Student;
import net.javaguides.sms.repository.StudentRepository;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}
	
	@Autowired 
	private StudentRepository studentRepository;

	@Override
	public void run(String... args) throws Exception {
		/*Student std1 = new Student("Adam", "Boufouss", "adamBfs@gmail.Com");
		studentRepository.save(std1);

		Student std2 = new Student("Jamal", "Boufouss", "JamalBfs@gmail.Com");
		studentRepository.save(std2);
		
		Student std3 = new Student("Kamal", "Boufouss", "Kamalmail.Com");
		studentRepository.save(std3);*/
		
	}

}

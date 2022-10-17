package net.javaguides.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaguides.sms.entity.Student;
import net.javaguides.sms.service.StudentService;

import java.util.Objects;

@Controller
public class StudentsController {
	private StudentService studentService;

	public StudentsController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	/* 
	 * Handler method to handle list students requests and return model and view
	 * @param Model
	 * @return String students
	 */
	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", studentService.getallStudents());
		return "students";
	}

	/*
	 * parse view create_student
	 */
	@GetMapping("/students/new")
	public String createNewStudentForm(Model model) {

		Student student = new Student();
		model.addAttribute("student", student);

		return "create_student";
	}

	/*
	 * save a student to DB (repository) by calling StudentService =>StudentServiceImpl => studentRepository
	 * @return redirect to students page after saving a student
	 */
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";
	}

	@GetMapping("/students/edit/{id}")
	public String editStudent(@PathVariable Long id, Model model){
		Student std = this.studentService.getStudentById(id);

		model.addAttribute("student", std);

		if (!Objects.isNull(std)){
			return "edit_student";
			//this.studentService.updateStudent((Student) model);
		}
		return null;
	}

	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student){

		Student std = this.studentService.getStudentById(id);

		if(!Objects.isNull(std)){
			this.studentService.updateStudent(student);
			return "redirect:/students";
		}else{
			return "redirect:/students?error=student%unavailable";
		}

	}
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id){
		this.studentService.deleteStudentById(id);
		return "redirect:/students";
	}
}

package net.javaguides.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaguides.sms.entity.Teacher;
import net.javaguides.sms.service.TeacherService;

@Controller
public class TeachersController {
	private TeacherService teacherService;
	 
	public TeachersController(TeacherService teacherService) {
		super();
		this.teacherService = teacherService;
	}

	@GetMapping("/teachers")
	public String listTeachers(Model model) {

		model.addAttribute("teachers", teacherService.getAllTeachers());

		return "teachers";
	}

	@GetMapping("/teachers/new")
	public String createNewTeacherForm(Model model) {

		Teacher teacher = new Teacher();
		model.addAttribute("teacher", teacher);

		return "create_teacher";
	}

	@PostMapping("/teachers")
	public String saveTeacher(@ModelAttribute("teacher") Teacher teacher) {

		teacherService.saveTeacher(teacher);
		
		return "redirect:/teachers";
	}

}

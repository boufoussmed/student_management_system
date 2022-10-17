package net.javaguides.sms.service.imlp;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.sms.entity.Teacher;
import net.javaguides.sms.repository.TeacherRepository;
import net.javaguides.sms.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService{
	
	private TeacherRepository teacherRepository;
	
	public TeacherServiceImpl(TeacherRepository teacherRepository) {
		super();
		this.teacherRepository = teacherRepository;
	}

	@Override
	public List<Teacher> getAllTeachers() {
		return this.teacherRepository.findAll();
	}

	@Override
	public Teacher saveTeacher(Teacher teacher) {
		return this.teacherRepository.save(teacher);
	}

}

package com.college.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.college.entity.Student;
import com.college.services.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/list")
	public String findAllStudent(Map<String, List<Student>> map) {
		List<Student> students= studentService.findAllStudent();
		map.put("student", students);
		return "studentlist";
	}
	
	@PostMapping("/save")
	public String saveOrUpdate(Student student) {
		System.out.println("inserting...");
		System.out.println(student);
		Student savedstudent=null;
		System.out.println(student);
		if(student.getId()!=0) {
			savedstudent=studentService.findStudentById(student.getId());	
			savedstudent.setName(student.getName());
			savedstudent.setCountry(student.getCountry());
			savedstudent.setDepartment(student.getDepartment());
		}
		else
			savedstudent= student;
			
		this.studentService.saveOrupdate(savedstudent);
		return "redirect:/student/list";
	}
	
	@GetMapping("/{id}")
	public String delete(@PathVariable int id) 
	{
		this.studentService.delete(id);
		return "redirect:/student/list";
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("student", new Student());
		return "studentform";
	}
	
	@GetMapping("/update/{id}")
	public String update(Model model,@PathVariable int id) {
		Student student= this.studentService.findStudentById(id);
		model.addAttribute(student);
		return "studentform";
		
		
	}

}

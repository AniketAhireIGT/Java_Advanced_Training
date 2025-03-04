package com.example.igtDemo.Interface;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.igtDemo.Entity.Student;


public interface StudentInterface 
{
	public List<Student> getAllStudent();
	
	public Student getStudentbyid(@PathVariable int id);
	
	public Student createStudent(@RequestBody Student std);
	
	public Student updatebyid(@PathVariable int id);
	
	public void deletebyid(@PathVariable int id);

	public List<Student> searchStudentByName(String name);
	
	public List<Student> searchStudentByBranch(@PathVariable String branch);
	
	public List<Student> searchStudentByPercentageRange(@RequestParam double minPercent, @RequestParam double maxPercent);
	
	
}

package com.example.igtDemo.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.igtDemo.Entity.Student;
import com.example.igtDemo.Interface.StudentInterface;

import jakarta.validation.Valid;


@RestController
public class MyController 
{
	@Autowired
	StudentInterface studentinterface;
	
	@GetMapping("/getAllStudent")
	public List<Student> getAllStudent()
	{ 
		List<Student> students=studentinterface.getAllStudent();
		
		return students;
	}
	
	@GetMapping("/getStudentById/{id}")
	public Student getStudentbyid(@PathVariable int id)
	{
		return studentinterface.getStudentbyid(id);
	}
	
	@PostMapping("/createStudent")
	public Student createStudent(@Valid @RequestBody Student std)
	{

		Student ct= studentinterface.createStudent(std);
		
		return ct;
		
	}
	
	@PutMapping("/updateStudentById/{id}")
	public Student updatebyid(@PathVariable int id)
	{
		return 	studentinterface.updatebyid(id);
			
	}
	
	@DeleteMapping("/deleteStudentById/{id}")
	public void deletebyid(@PathVariable int id)
	{
		 studentinterface.deletebyid(id);
	}
// =============================Named Queries==========================================
	
	@GetMapping("/searchStudentByName/{name}")
	public List<Student> searchStudentByName(@PathVariable String name) 
	{
	    return studentinterface.searchStudentByName(name);
	}

	@GetMapping("/searchStudentByBranch/{branch}")
	public List<Student> searchStudentByBranch(@PathVariable String branch) 
	{
		return studentinterface.searchStudentByBranch(branch);
	}	
	
	@GetMapping("/getStudentByPercentageRange")

	public List<Student> searchStudentByPercentageRange(@RequestParam double minPercent, @RequestParam double maxPercent) {

	    return studentinterface.searchStudentByPercentageRange(minPercent,maxPercent);

	}

	
	
	
}

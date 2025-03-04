package com.example.igtDemo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.igtDemo.Entity.Student;
import com.example.igtDemo.Exception.StudentNotFoundException;
import com.example.igtDemo.Interface.StudentInterface;
import com.example.igtDemo.Repository.StudentRepo;

@Service
public class StudentService implements StudentInterface
{
	@Autowired
     StudentRepo studentrepo;
	
	public List<Student> getAllStudent()
	{ 
		List<Student> students=studentrepo.findAll();
		
		return students;
	}
	
	public Student getStudentbyid(@PathVariable int id)
	{
		return studentrepo.findById(id).orElseThrow(() -> new StudentNotFoundException("Student with ID " + id + " not found"));
	}
	
	public Student createStudent(@RequestBody Student std)
	{
		
 		if(std == null || std.getName()==null)
		{
			throw new IllegalArgumentException("student details cannot be null");
		}
		try
		{
		    return studentrepo.save(std);
		}
		catch(DataIntegrityViolationException e)
		{
			 throw new DataIntegrityViolationException("Duplicate entry or data integrity issue");
		}
		
	}
	
	public Student updatebyid(@PathVariable int id)
	{
		
		Student res =studentrepo.findById(id).get();
		
		if(res!=null)
		{
			res.setName("Tejas");
			res.setPercentage(1000);
			res.setBranch("ITI");
			
			studentrepo.save(res);
			
		}
		return res;
	}	
	
	public void deletebyid(@PathVariable int id)
	{
		if(!studentrepo.existsById(id))
		{
			throw new StudentNotFoundException("Product with ID " + id + " not found. Cannot delete.");
		}
		
		studentrepo.deleteById(id);
	}

//======================================Named Queries===========================================
	
	public List<Student> searchStudentByName(String name) 
	{
		List<Student> std = studentrepo.searchStudentByName(name);
		return std;
	}
	
	public List<Student> searchStudentByBranch(String branch) 
	{
				
		List<Student> std = studentrepo.searchStudentByBranch(branch);
		return std;
	}
	
	public List<Student> searchStudentByPercentageRange(double minPercent, double maxPercent) 	
	{
				
		List<Student> std = studentrepo.searchStudentByPercentageRange(minPercent,maxPercent);
		return std;
	}

}

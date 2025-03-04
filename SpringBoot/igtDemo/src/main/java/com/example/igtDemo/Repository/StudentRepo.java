package com.example.igtDemo.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import com.example.igtDemo.Entity.Student;


public interface StudentRepo extends JpaRepository<Student, Integer> 
{
	 List<Student> searchStudentByName(@Param("name") String name);
	 List<Student> searchStudentByBranch(@Param("branch") String branch);
	 List<Student> searchStudentByPercentageRange(@Param("minPercent") double minPercent, 
	                                              @Param("maxPercent") double maxPercent);
}

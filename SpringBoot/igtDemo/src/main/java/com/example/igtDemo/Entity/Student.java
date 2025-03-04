package com.example.igtDemo.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@NamedQuery(name = "Student.searchStudentByName", query = "SELECT u FROM Student u WHERE u.name = :name")
@NamedQuery(name = "Student.searchStudentByBranch", query = "SELECT u FROM Student u WHERE u.branch = :branch")
@NamedQuery(name = "Student.searchStudentByPercentageRange",
			query = "SELECT u FROM Student u WHERE u.percentage BETWEEN :minPercent AND :maxPercent")

@Data
@Entity
@Table(name = "student")
public class Student 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int rollNo;
	
	
	@Size(min = 2, max = 10, message = "Name must be between 2 and 10 characters")
	@Column
	private String name;
	 
	@Min(value = 0, message = "Percentage must be at least 0")
	@Max(value = 100,message = "Percentage must be At most 100")
	@Column
	private float percentage;
	
	@NotNull(message = "Branch is required")
	@Column
	private String branch;
}

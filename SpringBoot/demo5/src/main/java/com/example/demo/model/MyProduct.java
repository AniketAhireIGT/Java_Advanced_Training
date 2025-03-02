package com.example.demo.model;


import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Data

public class MyProduct{
	
	@Id
	private int id;
	private String name;
	private int price;
	private String description;
	
	
	
	
	
	
}

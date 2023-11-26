package com.icress.empcrud.entity;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "EMPLOYEE", schema="public")
@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@NotNull(message="Date field is mandatory")
	@Past(message="Invalid Date")
	@Column(name = "dob")
	private Date dob;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "salary")
	private double salary;
	
	@Column(name = "status")
	private boolean status;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "gender")
	private String gender;
}
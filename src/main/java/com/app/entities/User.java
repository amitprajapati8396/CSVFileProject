package com.app.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.validation.annotation.Validated;
@Validated
@Entity
public class User {
 
	
  @Id 
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "USER_ID")
  private int id;
  
//  @Pattern(regexp = "[a-zA-Z ]" , message ="First Name only Alphabate acceptable")
//  @Size(max = 20)
  @Column(name="First_Name")
  private String fname;
  
//  @Pattern(regexp = "[a-zA-Z ]" , message ="Last Name only Alphabate acceptable")
//  @Size(max = 20)
  @Column(name="Last_Name")
  private String lname;

  //@Size(min = 24 ,max = 70)
  @Column(name="AGE")
  private int age;
  @OneToMany(mappedBy="user", targetEntity = Address.class,fetch = FetchType.LAZY,
		                           cascade = CascadeType.PERSIST)
  private List<Address> address;
  //All setters and getters methods  
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
	}	
	
	
	
}

package com.springboot.reader.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="readers")
public class Reader {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer readerid;
	private String name;
	private String email;
	//private String publishername;
	//private String category;
	//private Integer bookid;

//	private LocalDate publishedDate;
//	private Boolean status;
	
	public Reader() {
		super();
	}
	public Reader(Integer readerid, String name, String email) {
		super();
		this.readerid = readerid;
		this.name = name;
		this.email = email;
	}
	public Integer getReaderid() {
		return readerid;
	}
	public void setReaderid(Integer readerid) {
		this.readerid = readerid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Reader [readerid=" + readerid + ", name=" + name + ", email=" + email + "]";
	}

	
	
	
	
	
	
}

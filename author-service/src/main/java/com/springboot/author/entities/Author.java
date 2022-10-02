package com.springboot.author.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="authors")
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer authorid;
	
	private String name;
	private String email;
	//private Set<Book>books=new HashSet<>();
	public Author() {
		super();
	}
	public Author(Integer authorid, String name, String email) {
		super();
		this.authorid = authorid;
		this.name = name;
		this.email = email;
	}
	public Integer getAuthorid() {
		return authorid;
	}
	public void setAuthorid(Integer authorid) {
		this.authorid = authorid;
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
		return "Author [authorid=" + authorid + ", name=" + name + ", email=" + email + "]";
	}
	
	
	
	
}

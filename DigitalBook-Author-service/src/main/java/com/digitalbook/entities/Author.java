package com.digitalbook.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Author {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int authorid;
    private String authorName;
    private String emailId;
    private String password;
    //private LocalDate date;
	public Author() {
		super();
	}
	
	public Author(int authorid, String authorName, String emailId, String password) {
		super();
		this.authorid = authorid;
		this.authorName = authorName;
		this.emailId = emailId;
		this.password = password;
		
		
	}

	@Override
	public String toString() {
		return "Author [authorid=" + authorid + ", authorName=" + authorName + ", emailId=" + emailId + ", password="
				+ password + "]";
	}

	public int getAuthorid() {
		return authorid;
	}

	public void setAuthorid(int authorid) {
		this.authorid = authorid;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

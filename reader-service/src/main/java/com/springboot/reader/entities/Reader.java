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
    private int readerid;
	private int bookid;
	private long paymentid;
	private String name;
	private String email;
	private String subscriptionstatus;
	
	public Reader() {
		super();
	}
	public Reader(int readerid, int bookid, long paymentid, String name, String email,
			String subscriptionstatus) {
		super();
		this.readerid = readerid;
		this.bookid = bookid;
		this.paymentid = paymentid;
		this.name = name;
		this.email = email;
		this.subscriptionstatus = subscriptionstatus;
	}
	public Integer getReaderid() {
		return readerid;
	}
	public void setReaderid(int readerid) {
		this.readerid = readerid;
	}
	public Integer getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public long getPaymentid() {
		return paymentid;
	}
	public void setPaymentid(long paymentid) {
		this.paymentid = paymentid;
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
	public String getSubscriptionstatus() {
		return subscriptionstatus;
	}
	public void setSubscriptionstatus(String subscriptionstatus) {
		this.subscriptionstatus = subscriptionstatus;
	}
	@Override
	public String toString() {
		return "Reader [readerid=" + readerid + ", bookid=" + bookid + ", paymentid=" + paymentid + ", name=" + name
				+ ", email=" + email + ", subscriptionstatus=" + subscriptionstatus + "]";
	}
	


	
	
	
	
	
}

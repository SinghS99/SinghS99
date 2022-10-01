package com.springboot.digitalbook.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="Books")

public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookid;
	
	@Column(name = "category", length = 50, nullable = false, unique = true)
	private String category;
	@Column(name = "title", length = 50, nullable = false, unique = true)
	private String title;
	@Column(name = "publishername", length = 50, nullable = false, unique = true)
	private String publishername;
	

		//private Set<Reader> readers = new HashSet<Reader>();
//	private LocalDate publishedDate;
//	private Boolean status;
	public Integer getBookid() {
		return bookid;
	}
	public void setBookid(Integer bookid) {
		this.bookid = bookid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPublishername() {
		return publishername;
	}
	public void setPublishername(String publishername) {
		this.publishername = publishername;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Book(Integer bookid, String title, String publishername, String category) {
		super();
		this.bookid = bookid;
		this.title = title;
		this.publishername = publishername;
		this.category = category;
	}
	public Book() {
		super();
	}
	@Override
	public String toString() {
		return "Book [bookid=" + bookid + ", title=" + title + ", publishername=" + publishername + ", category="
				+ category + "]";
	}
	
//	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
//	@JoinTable(name = "books_authors", joinColumns = { @JoinColumn(name = "book_id") }, inverseJoinColumns = {
//			@JoinColumn(name = "author_id") })
//	private Set<Author> authors = new HashSet<Author>();
	
//	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
//	@JoinTable(name = "books_readers", joinColumns = { @JoinColumn(name = "book_id") }, inverseJoinColumns = {
//			@JoinColumn(name = "reader_id") })
//	private Set<Reader> readers = new HashSet<Reader>();
	
	
}

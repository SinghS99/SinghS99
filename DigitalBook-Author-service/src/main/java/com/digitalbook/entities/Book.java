package com.digitalbook.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer bookId;

    @Column(name = "title")
    private String title;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "releaseDate")
    private Date releaseDate;

    @Column(name = "category")
    private String category;

    @Column(name = "price")
    private Long price;

    @Column(name = "activeFlag")
    private Boolean activeFlag;

    @Column(name = "content")
    private String content;
    
    private int authorid;
    
	public Book() {
		super();
	}

	public Book(Integer bookId, String title, String publisher, Date releaseDate, String category, Long price,
			Boolean activeFlag, String content, int authorid) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.publisher = publisher;
		this.releaseDate = releaseDate;
		this.category = category;
		this.price = price;
		this.activeFlag = activeFlag;
		this.content = content;
		this.authorid = authorid;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Boolean getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(Boolean activeFlag) {
		this.activeFlag = activeFlag;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getAuthorid() {
		return authorid;
	}

	public void setAuthorid(int authorid) {
		this.authorid = authorid;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", publisher=" + publisher + ", releaseDate="
				+ releaseDate + ", category=" + category + ", price=" + price + ", activeFlag=" + activeFlag
				+ ", content=" + content + ", authorid=" + authorid + "]";
	}


//    @ManyToOne
//    private User user;

	
    
    
}
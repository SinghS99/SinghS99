package com.springboot.digitalbook.payloads;

public class BookDto {

	private Integer bookid;
	private String title;
	private String publishername;
	private String category;
//	private String publisher;
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
	public BookDto(Integer bookid, String title, String publishername, String category) {
		super();
		this.bookid = bookid;
		this.title = title;
		this.publishername = publishername;
		this.category = category;
	}
	public BookDto() {
		super();
	}
	@Override
	public String toString() {
		return "BookDto [bookid=" + bookid + ", title=" + title + ", publishername=" + publishername + ", category="
				+ category + "]";
	}
	
}

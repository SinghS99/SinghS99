package com.digitalbook.models;

import java.time.LocalDate;

public class Show {

	private int id;
    private String title;
    private double rating;
    private LocalDate releasedDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public LocalDate getReleasedDate() {
		return releasedDate;
	}
	public void setReleasedDate(LocalDate releasedDate) {
		this.releasedDate = releasedDate;
	}
	public Show(int id, String title, double rating, LocalDate releasedDate) {
		this.id = id;
		this.title = title;
		this.rating = rating;
		this.releasedDate = releasedDate;
	}
	public Show(int id, String title) {
		this.id = id;
		this.title = title;
	}
	public Show() {
	}
	@Override
	public String toString() {
		return "Show [id=" + id + ", title=" + title + ", rating=" + rating + ", releasedDate=" + releasedDate + "]";
	}
    
}
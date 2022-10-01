package com.springboot.digitalbook.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("book-service")
public class Configuration {

	 private Integer bookid;
		
		private String title;
		private String publishername;
		private String category;
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
		
		
	
}

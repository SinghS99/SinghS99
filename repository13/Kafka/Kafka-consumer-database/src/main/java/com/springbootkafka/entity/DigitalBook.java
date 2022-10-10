package com.springbootkafka.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="ChangesInBook")
@Getter
@Setter
public class DigitalBook {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String name;



public String getDigitalBookEventData() {
	return digitalBookEventData;
}



public void setDigitalBookEventData(String digitalBookEventData) {
	this.digitalBookEventData = digitalBookEventData;
}



public Long getId() {
	return id;
}



public void setId(Long id) {
	this.id = id;
}



public String getName() {
	return name;
}



public void setName(String name) {
	this.name = name;
}



@Lob
public String digitalBookEventData;




}

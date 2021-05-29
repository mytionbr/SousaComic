package com.mytion.sousacomics.model.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Type;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String author;
	private String image;
	private Float price;
	private String desc;
	@Column(insertable= false)
	private Date dateCreated;
	@Type(type="timestamp")
	private Date lastUpdated;
	private Integer stock;
	private	Integer sellCount;
	private Integer rating;
	private Integer numberPages;
	@OneToMany
	private List<BookCategory> categories;
	
	
}

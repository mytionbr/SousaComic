package com.mytion.sousacomics.model.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Table(name = "order_entity")
@Entity
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	@ManyToOne(optional = false)
	private User user;
	@OneToMany(mappedBy="order", cascade=CascadeType.ALL)
	private List<OrderDetail> orderDetailList;
	private String address;
	private Float totalPrice;
	@Type(type = "timestamp")
	private Date date;
	
}

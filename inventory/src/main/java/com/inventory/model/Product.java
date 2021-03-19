/**
 * 
 */
package com.inventory.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Probook
 *
 */
@Entity
public class Product {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long id;
private String name;
@ManyToOne
@JoinColumn(name="colorId")
private Color color;

//private Long colorId;
//private Long price;
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
public Color getColor() {
	return color;
}
public void setColor(Color color) {
	this.color = color;
}
//public Long getPrice() {
//	return price;
//}
//public void setPrice(Long price) {
//	this.price = price;
//}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
private String status;
}

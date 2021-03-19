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
public class Purchase {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private String status;
	private Double unitPrice;
	private Double totalPrice;
	
	@ManyToOne
	@JoinColumn(name="productId")
	private Product product;
private Long purchaseQty;
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
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public Product getProduct() {
	return product;
}
public void setProduct(Product product) {
	this.product = product;
}
public Long getPurchaseQty() {
	return purchaseQty;
}
public void setPurchaseQty(Long purchaseQty) {
	this.purchaseQty = purchaseQty;
}

public Double getUnitPrice() {
	return unitPrice;
}
public void setUnitPrice(Double unitPrice) {
	this.unitPrice = unitPrice;
}
public Double getTotalPrice() {
	return totalPrice;
}
public void setTotalPrice(Double totalPrice) {
	this.totalPrice = totalPrice;
}
}

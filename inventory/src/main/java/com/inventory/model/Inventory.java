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
public class Inventory {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="purchaseId")
	private Purchase purchase;
	
//	private Long purchaseId;
	
//	@ManyToOne
//	@JoinColumn(name="saleId")
//	private Sales sales;
	
	private Long availableQty;
	private String status;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Purchase getPurchase() {
		return purchase;
	}
	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}
//	public Sales getSales() {
//		return sales;
//	}
//	public void setSales(Sales sales) {
//		this.sales = sales;
//	}
	public Long getAvailableQty() {
		return availableQty;
	}
	public void setAvailableQty(Long availableQty) {
		this.availableQty = availableQty;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
//	public Long getPurchaseId() {
//		return purchaseId;
//	}
//	public void setPurchaseId(Long purchaseId) {
//		this.purchaseId = purchaseId;
//	}
//	

}

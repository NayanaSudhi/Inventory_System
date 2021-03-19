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
public class Sales {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="purchaseId")
	private Purchase purchase;
	
	private String status;
	private Long salesQty;
	
	private Double saleUnitPrice;
	private Double saleProfit;

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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getSalesQty() {
		return salesQty;
	}
	public void setSalesQty(Long salesQty) {
		this.salesQty = salesQty;
	}
	public Double getSaleProfit() {
		return saleProfit;
	}
	public void setSaleProfit(Double saleProfit) {
		this.saleProfit = saleProfit;
	}
	public Double getSaleUnitPrice() {
		return saleUnitPrice;
	}
	public void setSaleUnitPrice(Double saleUnitPrice) {
		this.saleUnitPrice = saleUnitPrice;
	}
}

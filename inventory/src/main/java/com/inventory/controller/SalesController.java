/**
 * 
 */
package com.inventory.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.inventory.model.Inventory;
import com.inventory.model.Purchase;
import com.inventory.model.Sales;
import com.inventory.repository.InventoryRepository;
import com.inventory.repository.PurchaseRepository;
import com.inventory.repository.SalesRepository;

/**
 * @author Probook
 *
 */
@RestController
public class SalesController {

	@Autowired
	SalesRepository salesRepository;
	@Autowired
	InventoryRepository inventoryRepository;
	
	@Autowired
	PurchaseRepository purchaseRepository;
	
	@GetMapping("/getsales")
	public ArrayList<Sales> getAllSales()
	{
		return (ArrayList<Sales>) salesRepository.findAll();
	}
	
	@PostMapping("/saveSales")
	public String saveSales(@RequestBody Sales sale)
	{
		Boolean isSave = true;
		if(null != sale.getId())
		{
			isSave=false;
		}
		Inventory inventoryObj=inventoryRepository.findByPurchaseId(sale.getPurchase().getId());
		ArrayList<Sales>salesList=salesRepository.findByPurchaseId(sale.getPurchase().getId());
		Optional<Purchase> purchaseObjList=purchaseRepository.findById(sale.getPurchase().getId());
		Purchase purchaseObj = purchaseObjList.get();
		
		Long totalSaleQty=0l;
		for(Sales saleObj:salesList)
		{
			if(!saleObj.getId().equals(sale.getId()))
			{
				totalSaleQty=totalSaleQty+saleObj.getSalesQty();
			}
		}
		if((purchaseObj.getPurchaseQty() - totalSaleQty - sale.getSalesQty())>=0l)
		{
			sale.setSaleProfit((sale.getSalesQty()*sale.getSaleUnitPrice())-(purchaseObj.getUnitPrice()*sale.getSalesQty()));
			salesRepository.save(sale);
			inventoryObj.setAvailableQty(purchaseObj.getPurchaseQty() - totalSaleQty - sale.getSalesQty());
			inventoryRepository.save(inventoryObj);
			
			if(isSave)
			{
			return "New record Saved Successfully";
			}
			else {
				return "Record Updated Successfully";
			}
		}
		else {
			return "Requested number of quantity not available";
		}
	}
	@DeleteMapping("/deleteSales/{id}")
	public String deleteSales(@PathVariable Long id)
	{
		Optional<Sales> saleObjList=salesRepository.findById(id);
		Sales saleObj=saleObjList.get();
		Inventory inventoryObj=inventoryRepository.findByPurchaseId(saleObj.getPurchase().getId());
		inventoryObj.setAvailableQty(inventoryObj.getAvailableQty()+saleObj.getSalesQty());
		salesRepository.deleteById(id);
		inventoryRepository.save(inventoryObj);
		return "Record deleted successfully";
	}
	@GetMapping("/findSalesById/{id}")
	public Sales findSalesById(@PathVariable Long id)
	{
		Optional<Sales> sales = salesRepository.findById(id);
		return sales.get();
	}
	

}

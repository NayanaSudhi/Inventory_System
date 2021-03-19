
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
public class PurchaseController {
	@Autowired
	PurchaseRepository purchaseRepository;

	@Autowired
	SalesRepository salesRepository;
	
	@Autowired
	InventoryRepository inventoryRepository;
	

	@GetMapping("/getPurchases")
	public ArrayList<Purchase> getAllPurchases()
	{
		return (ArrayList<Purchase>) purchaseRepository.findAll();
	}
	
	@PostMapping("/savePurchase")
	public String savePurchase(@RequestBody Purchase purchase)
	{
		Boolean isSave = true;
		Inventory inventoryObj = new Inventory();
		if(null != purchase.getId())
		{
			isSave=false;
			inventoryObj = inventoryRepository.findByPurchaseId(purchase.getId());
		}
		
		ArrayList<Sales> salesList=salesRepository.findByPurchaseId(purchase.getId());
		if(null != salesList && ! salesList.isEmpty())
		{
			return "Sale Exists,Record can not be updated";
		}
		else {
			
		purchase.setTotalPrice(purchase.getUnitPrice()*purchase.getPurchaseQty());
		purchaseRepository.save(purchase);
		
		
		inventoryObj.setAvailableQty(purchase.getPurchaseQty());
		inventoryObj.setStatus(purchase.getStatus());
		inventoryObj.setPurchase(purchase);
//		inventory.getPurchase().setId(purchase.getId());
		inventoryRepository.save(inventoryObj);
		
		
		if(isSave)
		{
		return "New record Saved Successfully";
		}
		else {
			return "Record Updated Successfully";
		}
		}
	}

	@DeleteMapping("/deletePurchase/{id}")
	public String deletePurchase(@PathVariable Long id)
	{
		ArrayList<Sales> salesList=salesRepository.findByPurchaseId(id);
		if(null != salesList && ! salesList.isEmpty())
		{
			return "Sale Exists,Record can not be deleted";
		}
		
		else
		{
			Inventory inventoryObj = inventoryRepository.findByPurchaseId(id);
			inventoryRepository.deleteById(inventoryObj.getId());
			purchaseRepository.deleteById(id);
			return "Record deleted successfully";
		}
	}
	
	@GetMapping("/findPurchaseById/{id}")
	public Purchase findPurchaseById(@PathVariable Long id)
	{
		Optional<Purchase> purchase = purchaseRepository.findById(id);
		return purchase.get();
	}
	
}

/**
 * 
 */
package com.inventory.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.inventory.model.Inventory;
import com.inventory.repository.InventoryRepository;


/**
 * @author Probook
 *
 */
public class InventoryController {
	
//	@Autowired
//	PurchaseRepository purchaseRepository;
//	
//	@Autowired
//	SalesRepository salesRepository;
	
	@Autowired
	InventoryRepository inventoryRepository;
	
	
	@GetMapping("/getInvetory")
	public ArrayList<Inventory> getAllInvetories()
	{
		return (ArrayList<Inventory>) inventoryRepository.findAll();
	}
	
	@PostMapping("/saveInventory")
	public String saveInventory(@RequestBody Inventory inventory)
	{
		inventoryRepository.save(inventory);
		return "New inventory Saved Successfully";
	}
	

}

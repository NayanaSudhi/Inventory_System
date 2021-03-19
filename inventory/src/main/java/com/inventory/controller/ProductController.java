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


import com.inventory.model.Product;
import com.inventory.model.Purchase;
import com.inventory.repository.ProductRepository;
import com.inventory.repository.PurchaseRepository;



/**
 * @author Probook
 *
 */
@RestController
public class ProductController {

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	PurchaseRepository purchaseRepository;
	
	@GetMapping("/getProduct")
	public ArrayList<Product> getAllProduct()
	{
		return (ArrayList<Product>) productRepository.findAll();
	}
	
	@PostMapping("/saveProduct")
	public String saveProduct(@RequestBody Product product)
	{
//		
//		productRepository.save(product);
//		return "New Product Saved Successfully";
//	}
		Boolean isSave = true;
		if(null != product.getId())
		{
			isSave=false;
		}
		productRepository.save(product);
		if(isSave)
		{
		return "New record Saved Successfully";
		}
		else {
			return "Record Updated Successfully";
		}
	}

	@DeleteMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable Long id)
	{
		ArrayList<Purchase> purchaseList=purchaseRepository.findByProductId(id);
		if(null != purchaseList && ! purchaseList.isEmpty())
		{
			return "Purchase Exists,Record can not be deleted";
		}
		else
		{
		productRepository.deleteById(id);
		return "Record deleted successfully";
		}
	}
	
	@GetMapping("/findProductById/{id}")
	public Product findProductById(@PathVariable Long id)
	{
		Optional<Product> product = productRepository.findById(id);
		return product.get();
	}
	
	
}

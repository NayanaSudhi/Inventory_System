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

import com.inventory.model.Color;
import com.inventory.model.Product;

import com.inventory.repository.ColorRepository;
import com.inventory.repository.ProductRepository;

@RestController
public class ColorController {
	@Autowired
	ColorRepository colorRepository;
	@Autowired
	ProductRepository productRepository;

	@GetMapping("/getColors")
	public ArrayList<Color> getAllColors() {
		return (ArrayList<Color>) colorRepository.findAll();
	}

	@PostMapping("/saveColor")
	public String saveColor(@RequestBody Color color) {
		Boolean isSave = true;
		if(null != color.getId())
		{
			isSave=false;
		}
		colorRepository.save(color);
		if(isSave)
		{
		return "New record Saved Successfully";
		}
		else {
			return "Record Updated Successfully";
		}
	}

	@DeleteMapping("/deleteColor/{id}")
	public String deleteColor(@PathVariable Long id)
	{
		ArrayList<Product> productList=productRepository.findByColorId(id);
		if(null != productList && ! productList.isEmpty())
		{
			return "Product Exists,Record can not be deleted";
		}
		else
		{
		colorRepository.deleteById(id);
		return "Record deleted successfully";
		}
		
	}
	
	@GetMapping("/findColorById/{id}")
	public Color findColorById(@PathVariable Long id)
	{
		Optional<Color> color = colorRepository.findById(id);
		return color.get();
	}
	

}

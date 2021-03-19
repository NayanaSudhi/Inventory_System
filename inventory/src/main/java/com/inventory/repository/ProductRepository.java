/**
 * 
 */
package com.inventory.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.inventory.model.Product;

/**
 * @author Probook
 *
 */
public interface ProductRepository extends CrudRepository<Product, Long>{
public ArrayList<Product> findByColorId(Long colorId);
}

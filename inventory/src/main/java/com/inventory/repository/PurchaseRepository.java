/**
 * 
 */
package com.inventory.repository;

import java.util.ArrayList;


import org.springframework.data.repository.CrudRepository;

import com.inventory.model.Purchase;

/**
 * @author Probook
 *
 */
public interface PurchaseRepository  extends CrudRepository<Purchase, Long>{
public ArrayList<Purchase> findByProductId(Long product);
}

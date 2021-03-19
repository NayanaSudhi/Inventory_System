/**
 * 
 */
package com.inventory.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.inventory.model.Sales;

/**
 * @author Probook
 *
 */
public interface SalesRepository extends CrudRepository<Sales, Long>{
	public ArrayList<Sales> findByPurchaseId(Long purchaseId);

}

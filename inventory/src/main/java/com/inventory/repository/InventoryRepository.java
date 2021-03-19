/**
 * 
 */
package com.inventory.repository;

import org.springframework.data.repository.CrudRepository;

import com.inventory.model.Inventory;

/**
 * @author Probook
 *
 */
public interface InventoryRepository extends CrudRepository<Inventory, Long>{

	Inventory findByPurchaseId(Long purcahseId);
}

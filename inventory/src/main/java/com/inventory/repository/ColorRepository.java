/**
 * 
 */
package com.inventory.repository;

import org.springframework.data.repository.CrudRepository;

import com.inventory.model.Color;

/**
 * @author Probook
 *
 */
public interface ColorRepository extends CrudRepository<Color, Long>{

//	void updateColor(Color color);
//public void deleteColor(Color color);
	
}

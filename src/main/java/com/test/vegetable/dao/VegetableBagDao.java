package com.test.vegetable.dao;
/**
 * This interface having CURD functionalities related to vegetable bag.
 * 
 * @author apparao
 *
 */

import java.util.List;

import com.test.vegetable.dto.VegetableBagDetails;

public interface VegetableBagDao {

	/**
	 * This method fetches the vegetable bags based on page number and page size.
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<VegetableBagDetails> getVegetableBags(Integer pageNo, Integer pageSize);

	/**
	 * This method persists the vegetable bag.
	 * 
	 * @param vegetableBagDetails
	 * @return
	 */
	VegetableBagDetails saveVegetableBag(VegetableBagDetails vegetableBagDetails);
}

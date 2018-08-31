package com.test.vegetable.business;

import java.util.List;

import com.test.vegetable.dto.VegetableBagDetails;
import com.test.vegetable.exception.ApplicationException;

/**
 * This interface having functionality related to vegetable bag.
 * 
 * @author apparao
 *
 */
public interface VegetableBagBusiness {

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
	VegetableBagDetails saveVegetableBag(VegetableBagDetails vegetableBagDetails) throws ApplicationException;

}

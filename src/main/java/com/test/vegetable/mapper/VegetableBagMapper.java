package com.test.vegetable.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.test.vegetable.dao.entity.VegetableBag;
import com.test.vegetable.dto.VegetableBagDetails;

/**
 * Mapper class for vegetable bag.
 * 
 * @author apparao
 *
 */
@Component
public class VegetableBagMapper implements Converter<VegetableBag, VegetableBagDetails> {

	/**
	 * This method converts VegetableBag to VegetableBagDetails object.
	 */
	public VegetableBagDetails convert(VegetableBag vegetableBag) {

		VegetableBagDetails vegetableBagDetails = new VegetableBagDetails();

		BeanUtils.copyProperties(vegetableBag, vegetableBagDetails);

		return vegetableBagDetails;
	}

}

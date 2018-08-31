package com.test.vegetable.dao.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.test.vegetable.dao.VegetableBagDao;
import com.test.vegetable.dao.entity.VegetableBag;
import com.test.vegetable.dao.repository.VegetableBagRepository;
import com.test.vegetable.dto.VegetableBagDetails;
import com.test.vegetable.mapper.VegetableBagMapper;

/**
 * This class having CURD functionalities related to vegetable bag.
 * 
 * @author apparao
 *
 */

@Repository
public class VegetableBagDaoImpl implements VegetableBagDao {
	
	private static final Logger logger = Logger.getLogger(VegetableBagDaoImpl.class);

	@Autowired
	private VegetableBagRepository vegetableBagRepository;

	@Autowired
	private VegetableBagMapper vegetableBagMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.test.vegetable.dao.VegetableBagDao#getVegetableBags(java.lang.Integer,
	 * java.lang.Integer)
	 */
	@Override
	public List<VegetableBagDetails> getVegetableBags(Integer pageNo, Integer pageSize) {
		
		logger.info("pageNo::"+pageNo+"::pageSize::"+pageSize);

		Pageable pageable = PageRequest.of(pageNo, pageSize);

		Page<VegetableBag> vegetableBags = vegetableBagRepository.findAll(pageable);

		List<VegetableBag> vegetableBagList = vegetableBags.getContent();

		List<VegetableBagDetails> vegetableBagDetailsList = vegetableBagList.stream().map(vegetableBagMapper::convert)
				.collect(Collectors.toList());

		return vegetableBagDetailsList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.test.vegetable.dao.VegetableBagDao#saveVegetableBag(com.test.vegetable.
	 * dto.VegetableBagDetails)
	 */
	@Override
	public VegetableBagDetails saveVegetableBag(VegetableBagDetails vegetableBagDetails) {

		VegetableBag vegetableBag = new VegetableBag();

		BeanUtils.copyProperties(vegetableBagDetails, vegetableBag);

		vegetableBag = vegetableBagRepository.save(vegetableBag);

		return vegetableBagMapper.convert(vegetableBag);
	}

}

package com.test.vegetable;

import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.test.vegetable.dao.VegetableBagDao;
import com.test.vegetable.dto.VegetableBagDetails;

@RunWith(SpringRunner.class)
@SpringBootTest
@SpringBootApplication
@TestPropertySource(locations = "classpath:application.properties")
public class VegetableBagDaoImplTest {
	
	@Autowired
	private VegetableBagDao  vegetableBagDao;
	
	@Test
	public void testgetVegetableBagsWithNoBags() {
		
		Integer pageNo = 0;
		
		Integer pageSize = 3;
		
		List<VegetableBagDetails> vegBagList = vegetableBagDao.getVegetableBags(pageNo, pageSize);
		
		assertNotNull(vegBagList);
		
	}
	
	@Test
	public void testSaveVegetableBag() {
		
		VegetableBagDetails bagDetails = new VegetableBagDetails();
		
		bagDetails.setPackageDate(new Date());
		bagDetails.setPrice(new Double(10));
		bagDetails.setQuantity(new Integer(1));
		bagDetails.setSupplierName("Aldi");
		VegetableBagDetails vegetableBagDetails = vegetableBagDao.saveVegetableBag(bagDetails);
		assertNotNull(vegetableBagDetails.getId());
	}
	
	@Test
	public void testgetVegetableBagsWithBags() {
		
		Integer pageNo = 0;
		
		Integer pageSize = 5;
		
		List<VegetableBagDetails> vegBagList = vegetableBagDao.getVegetableBags(pageNo, pageSize);
		
		assertNotNull(vegBagList);
		
	}

}

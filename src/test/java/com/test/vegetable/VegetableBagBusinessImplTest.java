package com.test.vegetable;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.test.vegetable.business.VegetableBagBusiness;
import com.test.vegetable.dto.VegetableBagDetails;
import com.test.vegetable.exception.ApplicationException;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class VegetableBagBusinessImplTest {
	
	@Autowired
	private VegetableBagBusiness  vegetableBagBusiness;
	
	@Test(expected = ApplicationException.class)
	public void testgetVegetableBagsWithNoBags() {
		
		Integer pageNo = 1;
		
		Integer pageSize = 5;
		
		vegetableBagBusiness.getVegetableBags(pageNo, pageSize);
		
		assertThatExceptionOfType(ApplicationException.class);
		
	}
	
	@Test(expected = ApplicationException.class)
	public void testgetVegetableBagsWithNullPageNumber() {
		
		Integer pageNo = null;
		
		Integer pageSize = 5;
		
		List<VegetableBagDetails> vegBagList = vegetableBagBusiness.getVegetableBags(pageNo, pageSize);
		
		assertNotNull(vegBagList);
		
	}
	
	@Test(expected = ApplicationException.class)
	public void testgetVegetableBagsWithNullPageSize() {
		
		Integer pageNo = 1;
		
		Integer pageSize = null;
		
		List<VegetableBagDetails> vegBagList = vegetableBagBusiness.getVegetableBags(pageNo, pageSize);
		
		assertNotNull(vegBagList);
		
	}
	
	@Test
	public void testSaveVegetableBag() {
		
		VegetableBagDetails bagDetails = new VegetableBagDetails();
		
		bagDetails.setPackageDate(new Date());
		bagDetails.setPrice(new Double(10));
		bagDetails.setQuantity(new Integer(1));
		bagDetails.setSupplierName("Aldi");
		VegetableBagDetails vegetableBagDetails = vegetableBagBusiness.saveVegetableBag(bagDetails);
		assertNotNull(vegetableBagDetails.getId());
		assertTrue(vegetableBagDetails.getPrice().equals(bagDetails.getPrice()));
		assertTrue(vegetableBagDetails.getQuantity().equals(bagDetails.getQuantity()));
		assertTrue(vegetableBagDetails.getSupplierName().equals(bagDetails.getSupplierName()));
	}
	
	@Test(expected = ApplicationException.class)
	public void testSaveVegetableBagWithZeroQuantity() {
		
		VegetableBagDetails bagDetails = new VegetableBagDetails();
		
		bagDetails.setPackageDate(new Date());
		bagDetails.setPrice(1d);
		bagDetails.setQuantity(0);
		bagDetails.setSupplierName("Aldi");
		VegetableBagDetails vegetableBagDetails = vegetableBagBusiness.saveVegetableBag(bagDetails);
		assertNotNull(vegetableBagDetails.getId());
	}
	
	@Test(expected = ApplicationException.class)
	public void testSaveVegetableBagWithZeroPrice() {
		
		VegetableBagDetails bagDetails = new VegetableBagDetails();
		
		bagDetails.setPackageDate(new Date());
		bagDetails.setPrice(0d);
		bagDetails.setQuantity(10);
		bagDetails.setSupplierName("Aldi");
		VegetableBagDetails vegetableBagDetails = vegetableBagBusiness.saveVegetableBag(bagDetails);
		assertNotNull(vegetableBagDetails.getId());
	}
	
	@Test(expected = ApplicationException.class)
	public void testSaveVegetableBagInvalidSupplierName() {
		
		VegetableBagDetails bagDetails = new VegetableBagDetails();
		
		bagDetails.setPackageDate(new Date());
		bagDetails.setPrice(20d);
		bagDetails.setQuantity(10);
		bagDetails.setSupplierName("test");
		VegetableBagDetails vegetableBagDetails = vegetableBagBusiness.saveVegetableBag(bagDetails);
		assertNotNull(vegetableBagDetails.getId());
	}
}

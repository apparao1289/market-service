package com.test.vegetable;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.test.vegetable.dto.Response;
import com.test.vegetable.dto.VegetableBagDetails;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class VegetableBagIntegerationTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testSaveVegetableBag() {

		VegetableBagDetails vegetableBagDetails = new VegetableBagDetails();
		vegetableBagDetails.setPackageDate(new Date());
		vegetableBagDetails.setPrice(new Double(10));
		vegetableBagDetails.setQuantity(new Integer(1));
		vegetableBagDetails.setSupplierName("Aldi");

		ResponseEntity<Response> responseEntity = restTemplate.postForEntity("/v1/vegetableBag", vegetableBagDetails,
				Response.class);

		Response response = responseEntity.getBody();

		assertNotNull(response);

	}
	
	@Test
	public void testGetVegetableBags() {

		ResponseEntity<Response> responseEntity = restTemplate.getForEntity("/v1/vegetableBag",Response.class);

		Response response = responseEntity.getBody();

		assertNotNull(response);

	}

}

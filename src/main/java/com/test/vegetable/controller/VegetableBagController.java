package com.test.vegetable.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.vegetable.business.VegetableBagBusiness;
import com.test.vegetable.common.VegetableBagConstant;
import com.test.vegetable.dto.MetaData;
import com.test.vegetable.dto.Response;
import com.test.vegetable.dto.VegetableBagDetails;
import com.test.vegetable.util.ExceptionUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * This class having functionality related vegetable bag.
 * 
 * @author apparao
 *
 */
@RestController
@Api(value = "Vegetable Bag")
public class VegetableBagController {

	private static final Logger logger = Logger.getLogger(VegetableBagController.class);

	@Autowired
	private VegetableBagBusiness vegetableBagBusiness;
	
	@Autowired
	private ExceptionUtil exceptionUtil;
	
	/**
	 * 
	 * @param vegetableBagDetails
	 * @return
	 */
	@RequestMapping(value = "/v1/vegetableBag", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Save Vegetable Bag", response = Response.class)
	public Response<VegetableBagDetails> saveVegetableBag(@Valid @RequestBody VegetableBagDetails vegetableBagDetails) {

		Response<VegetableBagDetails> response = new Response<VegetableBagDetails>();

		try {

			logger.info("saveVegetableBag request::" + vegetableBagDetails.toString());

			VegetableBagDetails vegetableBag = vegetableBagBusiness.saveVegetableBag(vegetableBagDetails);

			response.setResult(vegetableBag);

			response.setMetaData(new MetaData(200, VegetableBagConstant.SUCCESS));

		} catch (Exception e) {

			logger.error("Exception occurred while saveVegetableBag::" + e.getMessage());

			response.setErrorData(exceptionUtil.getErrorData(e));

			response.setMetaData(new MetaData(500, VegetableBagConstant.FAILURE));

		}

		return response;
	}
	
	/**
	 * 
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "/v1/vegetableBag", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Fetching Vegetable Bags", response = Response.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "pageNumber", value = "Page Number", required = false, dataType = "Integer", paramType = "query"),
			@ApiImplicitParam(name = "pageSize", value = "Page Size", required = false, dataType = "Integer", paramType = "query") })
	public Response<List<VegetableBagDetails>> getVegetableBags(
			@RequestParam(value = "pageNumber", required = false) final Integer pageNumber,
			@RequestParam(value = "pageSize", required = false) final Integer pageSize) {

		Response<List<VegetableBagDetails>> response = new Response<List<VegetableBagDetails>>();

		try {

			logger.info("getVegetableBags with pageNumber::" + pageNumber + "::pageSize::" + pageSize);

			List<VegetableBagDetails> vegetableBagDetailsList = vegetableBagBusiness.getVegetableBags(pageNumber,
					pageSize);

			response.setResult(vegetableBagDetailsList);

			response.setMetaData(new MetaData(200, VegetableBagConstant.SUCCESS));

		} catch (Exception e) {

			logger.error("Exception occurred while getVegetableBags::" + e.getMessage());

			response.setErrorData(exceptionUtil.getErrorData(e));

			response.setMetaData(new MetaData(500, VegetableBagConstant.FAILURE));

		}

		return response;
	}

}

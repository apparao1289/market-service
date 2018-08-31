package com.test.vegetable.util;

import org.springframework.stereotype.Component;

import com.test.vegetable.common.VegetableBagConstant;
import com.test.vegetable.dto.ErrorData;
import com.test.vegetable.exception.ApplicationException;

@Component
public class ExceptionUtil {

	public ErrorData getErrorData(Exception e) {

		ErrorData errorData = new ErrorData();

		if (e instanceof ApplicationException) {
			errorData.setErrorCode(((ApplicationException) e).getErrorCode().getCode());
			errorData.setErrorDescription(((ApplicationException) e).getErrorCode().getErrorDetail());
		} else {
			errorData.setErrorCode(VegetableBagConstant.EXCEPTION);
			errorData.setErrorDescription(e.getMessage());
		}
		return errorData;
	}

}

package com.test.vegetable.enums;

/**
 * This enum used for Error codes.
 * 
 * @author apparao
 *
 */
public enum ErrorCodeEnum {

	INTERNAL_SERVER_ERROR("system.error", "System error occurred"),

	INVALID_QUANITITY("quanitity.invalid", "Quantity should be between 1 and 100"),

	INVALID_PRICE("price.invalid", "Price should be between 1 and 50"),

	INVALID_SUPPLIER("supplier.invalid", "Supplier should be either of De Costa, Dirk, Albert Heign,Aldi"),

	NO_BAG_FOUND("no.bag.found", "No bags found");

	/** error code. */
	private String code;

	/** error detail. */
	private String errorDetail;

	/**
	 * Parameterized constructor.
	 *
	 * @param errorCode   the error code
	 * @param errorDetail the error detail
	 */
	private ErrorCodeEnum(final String errorCode, final String errorDetail) {
		this.code = errorCode;
		this.errorDetail = errorDetail;

	}

	/**
	 * This method returns the error code.
	 *
	 * @return error code.
	 */
	public String getCode() {
		return code;
	}

	/**
	 * This method returns the error detail.
	 *
	 * @return error detail.
	 */
	public String getErrorDetail() {
		return errorDetail;
	}

}

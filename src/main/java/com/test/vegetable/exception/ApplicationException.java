package com.test.vegetable.exception;

import static com.test.vegetable.enums.ErrorCodeEnum.INTERNAL_SERVER_ERROR;

import com.test.vegetable.enums.ErrorCodeEnum;

public class ApplicationException extends RuntimeException {

	private static final long serialVersionUID = 2837508888552870730L;

	/** Error code. */
	private final ErrorCodeEnum errorCode;

	/**
	 * Constructor to set error message.
	 *
	 * @param message   - error message
	 * @param errorCode - error error code
	 */
	public ApplicationException(final String message, final ErrorCodeEnum errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	/**
	 * Constructor to set error message and Throwable instance.
	 *
	 * @param message   - error message
	 * @param exception - Throwable instance
	 */
	public ApplicationException(final String message, final Throwable exception) {
		super(message, exception);
		this.errorCode = INTERNAL_SERVER_ERROR;
	}

	/**
	 * Constructor to set error message and Throwable instance.
	 *
	 * @param message   - error message
	 * @param exception - Throwable instance
	 * @param errorCode - error error code
	 */
	public ApplicationException(final String message, final Throwable exception, final ErrorCodeEnum errorCode) {
		super(message, exception);
		this.errorCode = errorCode;
	}

	/**
	 * Return the error code.
	 *
	 * @return the errorCode
	 */
	public ErrorCodeEnum getErrorCode() {
		return errorCode;
	}

}

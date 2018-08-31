package com.test.vegetable.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Response<T> {

	private MetaData metaData;

	private T result;

	private ErrorData errorData;

	/**
	 * @return the metaData
	 */
	public MetaData getMetaData() {
		return metaData;
	}

	/**
	 * @param metaData the metaData to set
	 */
	public void setMetaData(MetaData metaData) {
		this.metaData = metaData;
	}

	/**
	 * @return the result
	 */
	public T getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(T result) {
		this.result = result;
	}

	/**
	 * @return the errorData
	 */
	public ErrorData getErrorData() {
		return errorData;
	}

	/**
	 * @param errorData the errorData to set
	 */
	public void setErrorData(ErrorData errorData) {
		this.errorData = errorData;
	}

}

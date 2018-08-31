package com.test.vegetable.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MetaData implements Serializable {

	private static final long serialVersionUID = 1L;

	private int responseCode;

	private String responseDesciption;

	public MetaData() {

	}

	public MetaData(int responseCode, String responseDesciption) {
		this.responseCode = responseCode;
		this.responseDesciption = responseDesciption;
	}

	/**
	 * @return the responseCode
	 */
	public int getResponseCode() {
		return responseCode;
	}

	/**
	 * @param responseCode the responseCode to set
	 */
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	/**
	 * @return the responseDesciption
	 */
	public String getResponseDesciption() {
		return responseDesciption;
	}

	/**
	 * @param responseDesciption the responseDesciption to set
	 */
	public void setResponseDesciption(String responseDesciption) {
		this.responseDesciption = responseDesciption;
	}

}

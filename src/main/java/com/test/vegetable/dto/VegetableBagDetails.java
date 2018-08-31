package com.test.vegetable.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VegetableBagDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	/** id **/
	private String id;

	/** quantity **/
	@NotNull(message = "Quantity cannot be null")
	private Integer quantity;

	/** Supplier name **/
	@NotNull(message = "Supplier Name cannot be null")
	private String supplierName;

	/** Packed date **/
	private Date packageDate;

	/** price **/
	@NotNull(message = "Price cannot be null")
	private Double price;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the supplierName
	 */
	public String getSupplierName() {
		return supplierName;
	}

	/**
	 * @param supplierName the supplierName to set
	 */
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	/**
	 * @return the packageDate
	 */
	public Date getPackageDate() {
		return packageDate;
	}

	/**
	 * @param packageDate the packageDate to set
	 */
	public void setPackageDate(Date packageDate) {
		this.packageDate = packageDate;
	}

	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VegetableBagDetails [id=");
		builder.append(id);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append(", supplierName=");
		builder.append(supplierName);
		builder.append(", packageDate=");
		builder.append(packageDate);
		builder.append(", price=");
		builder.append(price);
		builder.append("]");
		return builder.toString();
	}

}

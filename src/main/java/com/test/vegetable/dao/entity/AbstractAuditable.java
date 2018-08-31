package com.test.vegetable.dao.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.test.vegetable.common.VegetableBagConstant;

/**
 * Abstract base class for audit fields. Stores the audit values in
 * persistent fields. like created date, update date, createdBy, modifiedBy.
 *
 * @author
 */
@MappedSuperclass
public abstract class AbstractAuditable {

	/** Created date. */
	@Column(name = "created_on", updatable = false)
	private Date createdDate;

	/** Created BY. */
	@Column(name = "created_by", updatable = false)
	private String createdBy;

	/** Last modified date. */
	@Column(name = "last_updated_on")
	private Date lastModifiedDate;

	/** Last modified By. */
	@Column(name = "last_updated_by")
	private String lastModifiedBy;

	/**
	 * This method returns the created date.
	 *
	 * @return <code>DateTime</code> object of created date.
	 */
	public Date getCreatedDate() {
		return (createdDate == null) ? null : new Date(createdDate.getTime());
	}

	/**
	 * This method sets the created date.
	 *
	 * @param createdDate is the created date of object.
	 */
	public void setCreatedDate(final Date createdDate) {
		this.createdDate = (createdDate == null) ? null : new Date(createdDate.getTime());
	}

	/**
	 * This method returns the last modified date.
	 *
	 * @return <code>DateTime</code> object of last modified date.
	 */
	public Date getLastModifiedDate() {
		return (lastModifiedDate == null) ? null : new Date(lastModifiedDate.getTime());
	}

	/**
	 * This method sets the last modified date.
	 *
	 * @param lastModifiedDate is the last modified By.
	 */
	public void setLastModifiedDate(final Date lastModifiedDate) {
		this.lastModifiedDate = (lastModifiedDate == null) ? null : new Date(lastModifiedDate.getTime());
	}

	/**
	 * This method returns the created By.
	 *
	 * @return <code>String</code> of created date.
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * This method sets the created By.
	 *
	 * @param createdBy is the created date of object.
	 */
	public void setCreatedBy(final String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * This method returns the last modified By.
	 *
	 * @return <code>String</code> of last modified By.
	 */
	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	/**
	 * This method sets the last modified By.
	 *
	 * @param lastModifiedBy is the last modified By.
	 */
	public void setLastModifiedBy(final String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	/**
	 * This method sets the created date and created by for given object. This
	 * operation gets before persisting the object.
	 */
	@PrePersist
	public void persistAuditInfo() {
		final Date currentDateTime = new Date();
		if (createdDate == null) {
			setCreatedDate(currentDateTime);
		}
		if (null == createdBy) {
			setCreatedBy(VegetableBagConstant.APPLICATION_NAME);
		}
	}

	/**
	 * This method sets the last modified date and last modified by for given
	 * object. This operation gets before updating the object.
	 */
	@PreUpdate
	public void updateAuditInfo() {
		final Date currentDateTime = new Date();
		if (lastModifiedDate == null) {
			setLastModifiedDate(currentDateTime);
		}
		if (null == lastModifiedBy) {
			setLastModifiedBy(VegetableBagConstant.APPLICATION_NAME);
		}
	}
}

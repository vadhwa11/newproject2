package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the uom table. Do not modify
 * this class because it will be overwritten if the configuration file related
 * to this class is modified.
 * 
 * @hibernate.class table="uom"
 */

public abstract class BaseUom implements Serializable {

	public static String REF = "Uom";
	public static String PROP_FROMUOM = "Fromuom";
	public static String PROP_STATUS_ID = "StatusId";
	public static String PROP_ADD_EDIT_DATE_TIME = "AddEditDateTime";
	public static String PROP_ADD_EDIT_BY_ID = "AddEditById";
	public static String PROP_TOUOM = "Touom";
	public static String PROP_CONVERSION_FACTOR = "ConversionFactor";
	public static String PROP_ID = "Id";

	// constructors
	public BaseUom() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseUom(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String conversionFactor;
	private java.lang.Integer addEditById;
	private java.util.Date addEditDateTime;
	private java.lang.Integer statusId;

	// many to one
	private jkt.hms.masters.business.CodeTypeDetails touom;
	private jkt.hms.masters.business.CodeTypeDetails fromuom;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="uom_id"
	 */
	public java.lang.Integer getId() {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * 
	 * @param id
	 *            the new ID
	 */
	public void setId(java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}

	/**
	 * Return the value associated with the column: conversion_factor
	 */
	public java.lang.String getConversionFactor() {
		return conversionFactor;
	}

	/**
	 * Set the value related to the column: conversion_factor
	 * 
	 * @param conversionFactor
	 *            the conversion_factor value
	 */
	public void setConversionFactor(java.lang.String conversionFactor) {
		this.conversionFactor = conversionFactor;
	}

	/**
	 * Return the value associated with the column: add_edit_by_id
	 */
	public java.lang.Integer getAddEditById() {
		return addEditById;
	}

	/**
	 * Set the value related to the column: add_edit_by_id
	 * 
	 * @param addEditById
	 *            the add_edit_by_id value
	 */
	public void setAddEditById(java.lang.Integer addEditById) {
		this.addEditById = addEditById;
	}

	/**
	 * Return the value associated with the column: add_edit_date_time
	 */
	public java.util.Date getAddEditDateTime() {
		return addEditDateTime;
	}

	/**
	 * Set the value related to the column: add_edit_date_time
	 * 
	 * @param addEditDateTime
	 *            the add_edit_date_time value
	 */
	public void setAddEditDateTime(java.util.Date addEditDateTime) {
		this.addEditDateTime = addEditDateTime;
	}

	/**
	 * Return the value associated with the column: status_id
	 */
	public java.lang.Integer getStatusId() {
		return statusId;
	}

	/**
	 * Set the value related to the column: status_id
	 * 
	 * @param statusId
	 *            the status_id value
	 */
	public void setStatusId(java.lang.Integer statusId) {
		this.statusId = statusId;
	}

	/**
	 * Return the value associated with the column: touom_id
	 */
	public jkt.hms.masters.business.CodeTypeDetails getTouom() {
		return touom;
	}

	/**
	 * Set the value related to the column: touom_id
	 * 
	 * @param touom
	 *            the touom_id value
	 */
	public void setTouom(jkt.hms.masters.business.CodeTypeDetails touom) {
		this.touom = touom;
	}

	/**
	 * Return the value associated with the column: fromuom_id
	 */
	public jkt.hms.masters.business.CodeTypeDetails getFromuom() {
		return fromuom;
	}

	/**
	 * Set the value related to the column: fromuom_id
	 * 
	 * @param fromuom
	 *            the fromuom_id value
	 */
	public void setFromuom(jkt.hms.masters.business.CodeTypeDetails fromuom) {
		this.fromuom = fromuom;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.Uom))
			return false;
		else {
			jkt.hms.masters.business.Uom uom = (jkt.hms.masters.business.Uom) obj;
			if (null == this.getId() || null == uom.getId())
				return false;
			else
				return (this.getId().equals(uom.getId()));
		}
	}

	public int hashCode() {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId())
				return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":"
						+ this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}

	public String toString() {
		return super.toString();
	}

}
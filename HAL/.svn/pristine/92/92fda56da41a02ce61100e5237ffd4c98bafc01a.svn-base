package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_store_item_conversion
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="mas_store_item_conversion"
 */

public abstract class BaseMasStoreItemConversion implements Serializable {

	public static String REF = "MasStoreItemConversion";
	public static String PROP_STATUS = "Status";
	public static String PROP_FORMULA = "Formula";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_INTERMEDIATE_UNIT = "IntermediateUnit";
	public static String PROP_PURCHASE_UNIT = "PurchaseUnit";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_CONVERSION_FACTOR2 = "ConversionFactor2";
	public static String PROP_CONVERSION_FACTOR1 = "ConversionFactor1";
	public static String PROP_ID = "Id";
	public static String PROP_ITEM_UNIT_NAME = "ItemUnitName";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ISSUE_UNIT = "IssueUnit";

	// constructors
	public BaseMasStoreItemConversion() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasStoreItemConversion(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String itemUnitName;
	private java.lang.Integer conversionFactor1;
	private java.lang.Integer conversionFactor2;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String formula;

	// many to one
	private jkt.hms.masters.business.MasStoreUnit purchaseUnit;
	private jkt.hms.masters.business.MasStoreUnit issueUnit;
	private jkt.hms.masters.business.MasStoreUnit intermediateUnit;

	// collections
	private java.util.Set<jkt.hms.masters.business.MasStoreItem> masStoreItems;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="item_conversion_id"
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
	 * Return the value associated with the column: item_unit_name
	 */
	public java.lang.String getItemUnitName() {
		return itemUnitName;
	}

	/**
	 * Set the value related to the column: item_unit_name
	 * 
	 * @param itemUnitName
	 *            the item_unit_name value
	 */
	public void setItemUnitName(java.lang.String itemUnitName) {
		this.itemUnitName = itemUnitName;
	}

	/**
	 * Return the value associated with the column: conversion_factor1
	 */
	public java.lang.Integer getConversionFactor1() {
		return conversionFactor1;
	}

	/**
	 * Set the value related to the column: conversion_factor1
	 * 
	 * @param conversionFactor1
	 *            the conversion_factor1 value
	 */
	public void setConversionFactor1(java.lang.Integer conversionFactor1) {
		this.conversionFactor1 = conversionFactor1;
	}

	/**
	 * Return the value associated with the column: conversion_factor2
	 */
	public java.lang.Integer getConversionFactor2() {
		return conversionFactor2;
	}

	/**
	 * Set the value related to the column: conversion_factor2
	 * 
	 * @param conversionFactor2
	 *            the conversion_factor2 value
	 */
	public void setConversionFactor2(java.lang.Integer conversionFactor2) {
		this.conversionFactor2 = conversionFactor2;
	}

	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus() {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * 
	 * @param status
	 *            the status value
	 */
	public void setStatus(java.lang.String status) {
		this.status = status;
	}

	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.String getLastChgBy() {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * 
	 * @param lastChgBy
	 *            the last_chg_by value
	 */
	public void setLastChgBy(java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
	}

	/**
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate() {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * 
	 * @param lastChgDate
	 *            the last_chg_date value
	 */
	public void setLastChgDate(java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}

	/**
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime() {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * 
	 * @param lastChgTime
	 *            the last_chg_time value
	 */
	public void setLastChgTime(java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}

	/**
	 * Return the value associated with the column: formula
	 */
	public java.lang.String getFormula() {
		return formula;
	}

	/**
	 * Set the value related to the column: formula
	 * 
	 * @param formula
	 *            the formula value
	 */
	public void setFormula(java.lang.String formula) {
		this.formula = formula;
	}

	/**
	 * Return the value associated with the column: purchase_unit_id
	 */
	public jkt.hms.masters.business.MasStoreUnit getPurchaseUnit() {
		return purchaseUnit;
	}

	/**
	 * Set the value related to the column: purchase_unit_id
	 * 
	 * @param purchaseUnit
	 *            the purchase_unit_id value
	 */
	public void setPurchaseUnit(
			jkt.hms.masters.business.MasStoreUnit purchaseUnit) {
		this.purchaseUnit = purchaseUnit;
	}

	/**
	 * Return the value associated with the column: issue_unit_id
	 */
	public jkt.hms.masters.business.MasStoreUnit getIssueUnit() {
		return issueUnit;
	}

	/**
	 * Set the value related to the column: issue_unit_id
	 * 
	 * @param issueUnit
	 *            the issue_unit_id value
	 */
	public void setIssueUnit(jkt.hms.masters.business.MasStoreUnit issueUnit) {
		this.issueUnit = issueUnit;
	}

	/**
	 * Return the value associated with the column: intermediate_unit_id
	 */
	public jkt.hms.masters.business.MasStoreUnit getIntermediateUnit() {
		return intermediateUnit;
	}

	/**
	 * Set the value related to the column: intermediate_unit_id
	 * 
	 * @param intermediateUnit
	 *            the intermediate_unit_id value
	 */
	public void setIntermediateUnit(
			jkt.hms.masters.business.MasStoreUnit intermediateUnit) {
		this.intermediateUnit = intermediateUnit;
	}

	/**
	 * Return the value associated with the column: MasStoreItems
	 */
	public java.util.Set<jkt.hms.masters.business.MasStoreItem> getMasStoreItems() {
		return masStoreItems;
	}

	/**
	 * Set the value related to the column: MasStoreItems
	 * 
	 * @param masStoreItems
	 *            the MasStoreItems value
	 */
	public void setMasStoreItems(
			java.util.Set<jkt.hms.masters.business.MasStoreItem> masStoreItems) {
		this.masStoreItems = masStoreItems;
	}

	public void addToMasStoreItems(
			jkt.hms.masters.business.MasStoreItem masStoreItem) {
		if (null == getMasStoreItems())
			setMasStoreItems(new java.util.TreeSet<jkt.hms.masters.business.MasStoreItem>());
		getMasStoreItems().add(masStoreItem);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MasStoreItemConversion))
			return false;
		else {
			jkt.hms.masters.business.MasStoreItemConversion masStoreItemConversion = (jkt.hms.masters.business.MasStoreItemConversion) obj;
			if (null == this.getId() || null == masStoreItemConversion.getId())
				return false;
			else
				return (this.getId().equals(masStoreItemConversion.getId()));
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
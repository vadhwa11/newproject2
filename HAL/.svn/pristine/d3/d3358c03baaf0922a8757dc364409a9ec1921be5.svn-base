package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the discharge_items table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="discharge_items"
 */

public abstract class BaseDischargeItems implements Serializable {

	public static String REF = "DischargeItems";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ITEM_CODE = "ItemCode";
	public static String PROP_ITEM_DESC = "ItemDesc";
	public static String PROP_ID = "Id";

	// constructors
	public BaseDischargeItems() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDischargeItems(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String itemCode;
	private java.lang.String itemDesc;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// collections
	private java.util.Set<jkt.hms.masters.business.DischargeItemsCategory> dischargeItemsCategories;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="id"
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
	 * Return the value associated with the column: item_code
	 */
	public java.lang.String getItemCode() {
		return itemCode;
	}

	/**
	 * Set the value related to the column: item_code
	 * 
	 * @param itemCode
	 *            the item_code value
	 */
	public void setItemCode(java.lang.String itemCode) {
		this.itemCode = itemCode;
	}

	/**
	 * Return the value associated with the column: item_desc
	 */
	public java.lang.String getItemDesc() {
		return itemDesc;
	}

	/**
	 * Set the value related to the column: item_desc
	 * 
	 * @param itemDesc
	 *            the item_desc value
	 */
	public void setItemDesc(java.lang.String itemDesc) {
		this.itemDesc = itemDesc;
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
	 * Return the value associated with the column: DischargeItemsCategories
	 */
	public java.util.Set<jkt.hms.masters.business.DischargeItemsCategory> getDischargeItemsCategories() {
		return dischargeItemsCategories;
	}

	/**
	 * Set the value related to the column: DischargeItemsCategories
	 * 
	 * @param dischargeItemsCategories
	 *            the DischargeItemsCategories value
	 */
	public void setDischargeItemsCategories(
			java.util.Set<jkt.hms.masters.business.DischargeItemsCategory> dischargeItemsCategories) {
		this.dischargeItemsCategories = dischargeItemsCategories;
	}

	public void addToDischargeItemsCategories(
			jkt.hms.masters.business.DischargeItemsCategory dischargeItemsCategory) {
		if (null == getDischargeItemsCategories())
			setDischargeItemsCategories(new java.util.TreeSet<jkt.hms.masters.business.DischargeItemsCategory>());
		getDischargeItemsCategories().add(dischargeItemsCategory);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.DischargeItems))
			return false;
		else {
			jkt.hms.masters.business.DischargeItems dischargeItems = (jkt.hms.masters.business.DischargeItems) obj;
			if (null == this.getId() || null == dischargeItems.getId())
				return false;
			else
				return (this.getId().equals(dischargeItems.getId()));
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
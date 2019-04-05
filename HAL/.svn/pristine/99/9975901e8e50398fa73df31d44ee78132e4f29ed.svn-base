package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the discharge_items_category
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="discharge_items_category"
 */

public abstract class BaseDischargeItemsCategory implements Serializable {

	public static String REF = "DischargeItemsCategory";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LABEL_DATA_TYPE = "LabelDataType";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ORDERNO = "Orderno";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ITEM_CODE = "ItemCode";
	public static String PROP_LABEL = "Label";
	public static String PROP_CATEGORY_NAME = "CategoryName";
	public static String PROP_ID = "Id";

	// constructors
	public BaseDischargeItemsCategory() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDischargeItemsCategory(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String categoryName;
	private java.lang.String label;
	private java.lang.Integer orderno;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String labelDataType;

	// many to one
	private jkt.hms.masters.business.DischargeItems itemCode;

	// collections
	private java.util.Set<jkt.hms.masters.business.DischargeSummary> dischargeSummaries;

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
	 * Return the value associated with the column: category_name
	 */
	public java.lang.String getCategoryName() {
		return categoryName;
	}

	/**
	 * Set the value related to the column: category_name
	 * 
	 * @param categoryName
	 *            the category_name value
	 */
	public void setCategoryName(java.lang.String categoryName) {
		this.categoryName = categoryName;
	}

	/**
	 * Return the value associated with the column: label
	 */
	public java.lang.String getLabel() {
		return label;
	}

	/**
	 * Set the value related to the column: label
	 * 
	 * @param label
	 *            the label value
	 */
	public void setLabel(java.lang.String label) {
		this.label = label;
	}

	/**
	 * Return the value associated with the column: orderno
	 */
	public java.lang.Integer getOrderno() {
		return orderno;
	}

	/**
	 * Set the value related to the column: orderno
	 * 
	 * @param orderno
	 *            the orderno value
	 */
	public void setOrderno(java.lang.Integer orderno) {
		this.orderno = orderno;
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
	 * Return the value associated with the column: label_data_type
	 */
	public java.lang.String getLabelDataType() {
		return labelDataType;
	}

	/**
	 * Set the value related to the column: label_data_type
	 * 
	 * @param labelDataType
	 *            the label_data_type value
	 */
	public void setLabelDataType(java.lang.String labelDataType) {
		this.labelDataType = labelDataType;
	}

	/**
	 * Return the value associated with the column: item_code
	 */
	public jkt.hms.masters.business.DischargeItems getItemCode() {
		return itemCode;
	}

	/**
	 * Set the value related to the column: item_code
	 * 
	 * @param itemCode
	 *            the item_code value
	 */
	public void setItemCode(jkt.hms.masters.business.DischargeItems itemCode) {
		this.itemCode = itemCode;
	}

	/**
	 * Return the value associated with the column: DischargeSummaries
	 */
	public java.util.Set<jkt.hms.masters.business.DischargeSummary> getDischargeSummaries() {
		return dischargeSummaries;
	}

	/**
	 * Set the value related to the column: DischargeSummaries
	 * 
	 * @param dischargeSummaries
	 *            the DischargeSummaries value
	 */
	public void setDischargeSummaries(
			java.util.Set<jkt.hms.masters.business.DischargeSummary> dischargeSummaries) {
		this.dischargeSummaries = dischargeSummaries;
	}

	public void addToDischargeSummaries(
			jkt.hms.masters.business.DischargeSummary dischargeSummary) {
		if (null == getDischargeSummaries())
			setDischargeSummaries(new java.util.TreeSet<jkt.hms.masters.business.DischargeSummary>());
		getDischargeSummaries().add(dischargeSummary);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.DischargeItemsCategory))
			return false;
		else {
			jkt.hms.masters.business.DischargeItemsCategory dischargeItemsCategory = (jkt.hms.masters.business.DischargeItemsCategory) obj;
			if (null == this.getId() || null == dischargeItemsCategory.getId())
				return false;
			else
				return (this.getId().equals(dischargeItemsCategory.getId()));
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
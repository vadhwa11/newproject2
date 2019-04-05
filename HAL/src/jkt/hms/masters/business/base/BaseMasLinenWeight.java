package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_linen_weight table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="mas_linen_weight"
 */

public abstract class BaseMasLinenWeight implements Serializable {

	public static String REF = "MasLinenWeight";
	public static String PROP_STATUS = "Status";
	public static String PROP_WEIGHT = "Weight";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ITEM_NAME = "ItemName";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ITEM_CODE = "ItemCode";
	public static String PROP_ID = "Id";

	// constructors
	public BaseMasLinenWeight() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasLinenWeight(java.lang.Integer id) {
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
	private java.lang.String itemName;
	private java.lang.String status;
	private java.math.BigDecimal weight;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// collections
	private java.util.Set<jkt.hms.masters.business.WorkLoadEntryDetail> workLoadEntryDetails;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="linen_weight_id"
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
	 * Return the value associated with the column: item_name
	 */
	public java.lang.String getItemName() {
		return itemName;
	}

	/**
	 * Set the value related to the column: item_name
	 * 
	 * @param itemName
	 *            the item_name value
	 */
	public void setItemName(java.lang.String itemName) {
		this.itemName = itemName;
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
	 * Return the value associated with the column: weight
	 */
	public java.math.BigDecimal getWeight() {
		return weight;
	}

	/**
	 * Set the value related to the column: weight
	 * 
	 * @param weight
	 *            the weight value
	 */
	public void setWeight(java.math.BigDecimal weight) {
		this.weight = weight;
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
	 * Return the value associated with the column: WorkLoadEntryDetails
	 */
	public java.util.Set<jkt.hms.masters.business.WorkLoadEntryDetail> getWorkLoadEntryDetails() {
		return workLoadEntryDetails;
	}

	/**
	 * Set the value related to the column: WorkLoadEntryDetails
	 * 
	 * @param workLoadEntryDetails
	 *            the WorkLoadEntryDetails value
	 */
	public void setWorkLoadEntryDetails(
			java.util.Set<jkt.hms.masters.business.WorkLoadEntryDetail> workLoadEntryDetails) {
		this.workLoadEntryDetails = workLoadEntryDetails;
	}

	public void addToWorkLoadEntryDetails(
			jkt.hms.masters.business.WorkLoadEntryDetail workLoadEntryDetail) {
		if (null == getWorkLoadEntryDetails())
			setWorkLoadEntryDetails(new java.util.TreeSet<jkt.hms.masters.business.WorkLoadEntryDetail>());
		getWorkLoadEntryDetails().add(workLoadEntryDetail);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MasLinenWeight))
			return false;
		else {
			jkt.hms.masters.business.MasLinenWeight masLinenWeight = (jkt.hms.masters.business.MasLinenWeight) obj;
			if (null == this.getId() || null == masLinenWeight.getId())
				return false;
			else
				return (this.getId().equals(masLinenWeight.getId()));
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
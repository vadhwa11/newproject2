package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the discharge_summary table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="discharge_summary"
 */

public abstract class BaseDischargeSummary implements Serializable {

	public static String REF = "DischargeSummary";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ITEM_REPLY = "ItemReply";
	public static String PROP_AD_NO = "AdNo";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ITEM_CODE = "ItemCode";
	public static String PROP_HIN = "Hin";
	public static String PROP_LABEL = "Label";
	public static String PROP_ID = "Id";

	// constructors
	public BaseDischargeSummary() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDischargeSummary(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String adNo;
	private java.lang.String label;
	private java.lang.String itemReply;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.DischargeItemsCategory itemCode;
	private jkt.hms.masters.business.Patient hin;

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
	 * Return the value associated with the column: ad_no
	 */
	public java.lang.String getAdNo() {
		return adNo;
	}

	/**
	 * Set the value related to the column: ad_no
	 * 
	 * @param adNo
	 *            the ad_no value
	 */
	public void setAdNo(java.lang.String adNo) {
		this.adNo = adNo;
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
	 * Return the value associated with the column: item_reply
	 */
	public java.lang.String getItemReply() {
		return itemReply;
	}

	/**
	 * Set the value related to the column: item_reply
	 * 
	 * @param itemReply
	 *            the item_reply value
	 */
	public void setItemReply(java.lang.String itemReply) {
		this.itemReply = itemReply;
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
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital() {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * 
	 * @param hospital
	 *            the hospital_id value
	 */
	public void setHospital(jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}

	/**
	 * Return the value associated with the column: item_code
	 */
	public jkt.hms.masters.business.DischargeItemsCategory getItemCode() {
		return itemCode;
	}

	/**
	 * Set the value related to the column: item_code
	 * 
	 * @param itemCode
	 *            the item_code value
	 */
	public void setItemCode(
			jkt.hms.masters.business.DischargeItemsCategory itemCode) {
		this.itemCode = itemCode;
	}

	/**
	 * Return the value associated with the column: hin_id
	 */
	public jkt.hms.masters.business.Patient getHin() {
		return hin;
	}

	/**
	 * Set the value related to the column: hin_id
	 * 
	 * @param hin
	 *            the hin_id value
	 */
	public void setHin(jkt.hms.masters.business.Patient hin) {
		this.hin = hin;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.DischargeSummary))
			return false;
		else {
			jkt.hms.masters.business.DischargeSummary dischargeSummary = (jkt.hms.masters.business.DischargeSummary) obj;
			if (null == this.getId() || null == dischargeSummary.getId())
				return false;
			else
				return (this.getId().equals(dischargeSummary.getId()));
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
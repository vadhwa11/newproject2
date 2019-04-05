package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_blood_bank_status
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="mas_blood_bank_status"
 */

public abstract class BaseMasBloodBankStatus implements Serializable {

	public static String REF = "MasBloodBankStatus";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_BLOOD_BANK_STATUS_NAME = "BloodBankStatusName";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_BLOOD_BANK_STATUS_CODE = "BloodBankStatusCode";
	public static String PROP_ID = "Id";

	// constructors
	public BaseMasBloodBankStatus() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasBloodBankStatus(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String bloodBankStatusCode;
	private java.lang.String bloodBankStatusName;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="blood_bank_status_id"
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
	 * Return the value associated with the column: blood_bank_status_code
	 */
	public java.lang.String getBloodBankStatusCode() {
		return bloodBankStatusCode;
	}

	/**
	 * Set the value related to the column: blood_bank_status_code
	 * 
	 * @param bloodBankStatusCode
	 *            the blood_bank_status_code value
	 */
	public void setBloodBankStatusCode(java.lang.String bloodBankStatusCode) {
		this.bloodBankStatusCode = bloodBankStatusCode;
	}

	/**
	 * Return the value associated with the column: blood_bank_status_name
	 */
	public java.lang.String getBloodBankStatusName() {
		return bloodBankStatusName;
	}

	/**
	 * Set the value related to the column: blood_bank_status_name
	 * 
	 * @param bloodBankStatusName
	 *            the blood_bank_status_name value
	 */
	public void setBloodBankStatusName(java.lang.String bloodBankStatusName) {
		this.bloodBankStatusName = bloodBankStatusName;
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

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MasBloodBankStatus))
			return false;
		else {
			jkt.hms.masters.business.MasBloodBankStatus masBloodBankStatus = (jkt.hms.masters.business.MasBloodBankStatus) obj;
			if (null == this.getId() || null == masBloodBankStatus.getId())
				return false;
			else
				return (this.getId().equals(masBloodBankStatus.getId()));
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
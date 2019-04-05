package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_account_type table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="mas_account_type"
 */

public abstract class BaseMasAccountType implements Serializable {

	public static String REF = "MasAccountType";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ACCOUNT_TYPE_NAME = "AccountTypeName";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ACCOUNT_TYPE_CODE = "AccountTypeCode";
	public static String PROP_ID = "Id";

	// constructors
	public BaseMasAccountType() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasAccountType(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String accountTypeCode;
	private java.lang.String accountTypeName;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// collections
	private java.util.Set<jkt.hms.masters.business.MasChargeCode> masChargeCodes;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="account_id"
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
	 * Return the value associated with the column: account_type_code
	 */
	public java.lang.String getAccountTypeCode() {
		return accountTypeCode;
	}

	/**
	 * Set the value related to the column: account_type_code
	 * 
	 * @param accountTypeCode
	 *            the account_type_code value
	 */
	public void setAccountTypeCode(java.lang.String accountTypeCode) {
		this.accountTypeCode = accountTypeCode;
	}

	/**
	 * Return the value associated with the column: account_type_name
	 */
	public java.lang.String getAccountTypeName() {
		return accountTypeName;
	}

	/**
	 * Set the value related to the column: account_type_name
	 * 
	 * @param accountTypeName
	 *            the account_type_name value
	 */
	public void setAccountTypeName(java.lang.String accountTypeName) {
		this.accountTypeName = accountTypeName;
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
	 * Return the value associated with the column: MasChargeCodes
	 */
	public java.util.Set<jkt.hms.masters.business.MasChargeCode> getMasChargeCodes() {
		return masChargeCodes;
	}

	/**
	 * Set the value related to the column: MasChargeCodes
	 * 
	 * @param masChargeCodes
	 *            the MasChargeCodes value
	 */
	public void setMasChargeCodes(
			java.util.Set<jkt.hms.masters.business.MasChargeCode> masChargeCodes) {
		this.masChargeCodes = masChargeCodes;
	}

	public void addToMasChargeCodes(
			jkt.hms.masters.business.MasChargeCode masChargeCode) {
		if (null == getMasChargeCodes())
			setMasChargeCodes(new java.util.TreeSet<jkt.hms.masters.business.MasChargeCode>());
		getMasChargeCodes().add(masChargeCode);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MasAccountType))
			return false;
		else {
			jkt.hms.masters.business.MasAccountType masAccountType = (jkt.hms.masters.business.MasAccountType) obj;
			if (null == this.getId() || null == masAccountType.getId())
				return false;
			else
				return (this.getId().equals(masAccountType.getId()));
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
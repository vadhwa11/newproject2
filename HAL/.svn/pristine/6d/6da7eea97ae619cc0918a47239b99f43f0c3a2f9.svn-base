package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_account table. Do not
 * modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * 
 * @hibernate.class table="mas_account"
 */

public abstract class BaseMasAccount implements Serializable {

	public static String REF = "MasAccount";
	public static String PROP_ACC_DESC = "AccDesc";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ACC_CODE = "AccCode";
	public static String PROP_ACC_TYPE = "AccType";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ID = "Id";
	public static String PROP_STAUS = "Staus";
	public static String PROP_BALANCE = "Balance";

	// constructors
	public BaseMasAccount() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasAccount(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String accCode;
	private java.lang.String accDesc;
	private java.lang.String accType;
	private java.math.BigDecimal balance;
	private java.lang.String staus;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;

	// collections
	private java.util.Set<jkt.hms.masters.business.BlVoucherDetails> blVoucherDetails;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="acc_id"
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
	 * Return the value associated with the column: acc_code
	 */
	public java.lang.String getAccCode() {
		return accCode;
	}

	/**
	 * Set the value related to the column: acc_code
	 * 
	 * @param accCode
	 *            the acc_code value
	 */
	public void setAccCode(java.lang.String accCode) {
		this.accCode = accCode;
	}

	/**
	 * Return the value associated with the column: acc_desc
	 */
	public java.lang.String getAccDesc() {
		return accDesc;
	}

	/**
	 * Set the value related to the column: acc_desc
	 * 
	 * @param accDesc
	 *            the acc_desc value
	 */
	public void setAccDesc(java.lang.String accDesc) {
		this.accDesc = accDesc;
	}

	/**
	 * Return the value associated with the column: acc_type
	 */
	public java.lang.String getAccType() {
		return accType;
	}

	/**
	 * Set the value related to the column: acc_type
	 * 
	 * @param accType
	 *            the acc_type value
	 */
	public void setAccType(java.lang.String accType) {
		this.accType = accType;
	}

	/**
	 * Return the value associated with the column: balance
	 */
	public java.math.BigDecimal getBalance() {
		return balance;
	}

	/**
	 * Set the value related to the column: balance
	 * 
	 * @param balance
	 *            the balance value
	 */
	public void setBalance(java.math.BigDecimal balance) {
		this.balance = balance;
	}

	/**
	 * Return the value associated with the column: staus
	 */
	public java.lang.String getStaus() {
		return staus;
	}

	/**
	 * Set the value related to the column: staus
	 * 
	 * @param staus
	 *            the staus value
	 */
	public void setStaus(java.lang.String staus) {
		this.staus = staus;
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
	 * Return the value associated with the column: BlVoucherDetails
	 */
	public java.util.Set<jkt.hms.masters.business.BlVoucherDetails> getBlVoucherDetails() {
		return blVoucherDetails;
	}

	/**
	 * Set the value related to the column: BlVoucherDetails
	 * 
	 * @param blVoucherDetails
	 *            the BlVoucherDetails value
	 */
	public void setBlVoucherDetails(
			java.util.Set<jkt.hms.masters.business.BlVoucherDetails> blVoucherDetails) {
		this.blVoucherDetails = blVoucherDetails;
	}

	public void addToBlVoucherDetails(
			jkt.hms.masters.business.BlVoucherDetails blVoucherDetails) {
		if (null == getBlVoucherDetails())
			setBlVoucherDetails(new java.util.TreeSet<jkt.hms.masters.business.BlVoucherDetails>());
		getBlVoucherDetails().add(blVoucherDetails);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MasAccount))
			return false;
		else {
			jkt.hms.masters.business.MasAccount masAccount = (jkt.hms.masters.business.MasAccount) obj;
			if (null == this.getId() || null == masAccount.getId())
				return false;
			else
				return (this.getId().equals(masAccount.getId()));
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
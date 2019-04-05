package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_reimb_detail table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_reimb_detail"
 */

public abstract class BaseHrReimbDetail  implements Serializable {

	public static String REF = "HrReimbDetail";
	public static String PROP_REIMB_AMOUNT = "ReimbAmount";
	public static String PROP_REIMB_DATE = "ReimbDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_REIMB_HEADER = "ReimbHeader";
	public static String PROP_PAID = "Paid";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_CLAIM_DATE = "ClaimDate";
	public static String PROP_ID = "Id";
	public static String PROP_CLAIM_AMOUNT = "ClaimAmount";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseHrReimbDetail () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrReimbDetail (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date claimDate;
	private java.math.BigDecimal claimAmount;
	private java.lang.String paid;
	private java.util.Date reimbDate;
	private java.math.BigDecimal reimbAmount;
	private java.lang.String remarks;
	private java.lang.String lastChgTime;
	private java.util.Date lastChgDate;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.HrReimbHeader reimbHeader;
	private jkt.hms.masters.business.Users lastChgBy;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="reimb_detail_id"
     */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: claim_date
	 */
	public java.util.Date getClaimDate () {
		return claimDate;
	}

	/**
	 * Set the value related to the column: claim_date
	 * @param claimDate the claim_date value
	 */
	public void setClaimDate (java.util.Date claimDate) {
		this.claimDate = claimDate;
	}



	/**
	 * Return the value associated with the column: claim_amount
	 */
	public java.math.BigDecimal getClaimAmount () {
		return claimAmount;
	}

	/**
	 * Set the value related to the column: claim_amount
	 * @param claimAmount the claim_amount value
	 */
	public void setClaimAmount (java.math.BigDecimal claimAmount) {
		this.claimAmount = claimAmount;
	}



	/**
	 * Return the value associated with the column: paid
	 */
	public java.lang.String getPaid () {
		return paid;
	}

	/**
	 * Set the value related to the column: paid
	 * @param paid the paid value
	 */
	public void setPaid (java.lang.String paid) {
		this.paid = paid;
	}



	/**
	 * Return the value associated with the column: reimb_date
	 */
	public java.util.Date getReimbDate () {
		return reimbDate;
	}

	/**
	 * Set the value related to the column: reimb_date
	 * @param reimbDate the reimb_date value
	 */
	public void setReimbDate (java.util.Date reimbDate) {
		this.reimbDate = reimbDate;
	}



	/**
	 * Return the value associated with the column: reimb_amount
	 */
	public java.math.BigDecimal getReimbAmount () {
		return reimbAmount;
	}

	/**
	 * Set the value related to the column: reimb_amount
	 * @param reimbAmount the reimb_amount value
	 */
	public void setReimbAmount (java.math.BigDecimal reimbAmount) {
		this.reimbAmount = reimbAmount;
	}



	/**
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * @param remarks the remarks value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
	}



	/**
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime () {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * @param lastChgTime the last_chg_time value
	 */
	public void setLastChgTime (java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}



	/**
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate () {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * @param lastChgDate the last_chg_date value
	 */
	public void setLastChgDate (java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}



	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * @param status the status value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
	}



	/**
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital () {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * @param hospital the hospital_id value
	 */
	public void setHospital (jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}



	/**
	 * Return the value associated with the column: reimb_header_id
	 */
	public jkt.hms.masters.business.HrReimbHeader getReimbHeader () {
		return reimbHeader;
	}

	/**
	 * Set the value related to the column: reimb_header_id
	 * @param reimbHeader the reimb_header_id value
	 */
	public void setReimbHeader (jkt.hms.masters.business.HrReimbHeader reimbHeader) {
		this.reimbHeader = reimbHeader;
	}



	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public jkt.hms.masters.business.Users getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (jkt.hms.masters.business.Users lastChgBy) {
		this.lastChgBy = lastChgBy;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HrReimbDetail)) return false;
		else {
			jkt.hms.masters.business.HrReimbDetail hrReimbDetail = (jkt.hms.masters.business.HrReimbDetail) obj;
			if (null == this.getId() || null == hrReimbDetail.getId()) return false;
			else return (this.getId().equals(hrReimbDetail.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}
package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_advance_detail table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_advance_detail"
 */

public abstract class BaseHrAdvanceDetail  implements Serializable {

	public static String REF = "HrAdvanceDetail";
	public static String PROP_RECOVERED_AMOUNT = "RecoveredAmount";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_REMARK = "Remark";
	public static String PROP_ADVANCE = "Advance";
	public static String PROP_RECOVERY_DATE = "RecoveryDate";


	// constructors
	public BaseHrAdvanceDetail () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrAdvanceDetail (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.math.BigDecimal recoveredAmount;
	private java.util.Date recoveryDate;
	private java.lang.String remark;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.HrAdvance advance;
	private jkt.hms.masters.business.Users lastChgBy;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="advance_detail_id"
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
	 * Return the value associated with the column: recovered_amount
	 */
	public java.math.BigDecimal getRecoveredAmount () {
		return recoveredAmount;
	}

	/**
	 * Set the value related to the column: recovered_amount
	 * @param recoveredAmount the recovered_amount value
	 */
	public void setRecoveredAmount (java.math.BigDecimal recoveredAmount) {
		this.recoveredAmount = recoveredAmount;
	}



	/**
	 * Return the value associated with the column: recovery_date
	 */
	public java.util.Date getRecoveryDate () {
		return recoveryDate;
	}

	/**
	 * Set the value related to the column: recovery_date
	 * @param recoveryDate the recovery_date value
	 */
	public void setRecoveryDate (java.util.Date recoveryDate) {
		this.recoveryDate = recoveryDate;
	}



	/**
	 * Return the value associated with the column: remark
	 */
	public java.lang.String getRemark () {
		return remark;
	}

	/**
	 * Set the value related to the column: remark
	 * @param remark the remark value
	 */
	public void setRemark (java.lang.String remark) {
		this.remark = remark;
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
	 * Return the value associated with the column: advance_id
	 */
	public jkt.hms.masters.business.HrAdvance getAdvance () {
		return advance;
	}

	/**
	 * Set the value related to the column: advance_id
	 * @param advance the advance_id value
	 */
	public void setAdvance (jkt.hms.masters.business.HrAdvance advance) {
		this.advance = advance;
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
		if (!(obj instanceof jkt.hms.masters.business.HrAdvanceDetail)) return false;
		else {
			jkt.hms.masters.business.HrAdvanceDetail hrAdvanceDetail = (jkt.hms.masters.business.HrAdvanceDetail) obj;
			if (null == this.getId() || null == hrAdvanceDetail.getId()) return false;
			else return (this.getId().equals(hrAdvanceDetail.getId()));
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
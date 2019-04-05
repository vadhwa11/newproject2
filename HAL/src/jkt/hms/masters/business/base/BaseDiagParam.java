package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the diag_param table. Do not
 * modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * 
 * @hibernate.class table="diag_param"
 */

public abstract class BaseDiagParam implements Serializable {

	public static String REF = "DiagParam";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_SUB_CHARGE = "SubCharge";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_MAIN_CHARGE = "MainCharge";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_PREFIX = "Prefix";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_CRITERIA = "Criteria";
	public static String PROP_SEQ_NO = "SeqNo";
	public static String PROP_ID = "Id";

	// constructors
	public BaseDiagParam() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDiagParam(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer seqNo;
	private java.lang.String prefix;
	private java.lang.String criteria;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasSubChargecode subCharge;
	private jkt.hms.masters.business.MasMainChargecode mainCharge;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="dp_id"
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
	 * Return the value associated with the column: seq_no
	 */
	public java.lang.Integer getSeqNo() {
		return seqNo;
	}

	/**
	 * Set the value related to the column: seq_no
	 * 
	 * @param seqNo
	 *            the seq_no value
	 */
	public void setSeqNo(java.lang.Integer seqNo) {
		this.seqNo = seqNo;
	}

	/**
	 * Return the value associated with the column: prefix
	 */
	public java.lang.String getPrefix() {
		return prefix;
	}

	/**
	 * Set the value related to the column: prefix
	 * 
	 * @param prefix
	 *            the prefix value
	 */
	public void setPrefix(java.lang.String prefix) {
		this.prefix = prefix;
	}

	/**
	 * Return the value associated with the column: criteria
	 */
	public java.lang.String getCriteria() {
		return criteria;
	}

	/**
	 * Set the value related to the column: criteria
	 * 
	 * @param criteria
	 *            the criteria value
	 */
	public void setCriteria(java.lang.String criteria) {
		this.criteria = criteria;
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
	 * Return the value associated with the column: sub_charge_id
	 */
	public jkt.hms.masters.business.MasSubChargecode getSubCharge() {
		return subCharge;
	}

	/**
	 * Set the value related to the column: sub_charge_id
	 * 
	 * @param subCharge
	 *            the sub_charge_id value
	 */
	public void setSubCharge(jkt.hms.masters.business.MasSubChargecode subCharge) {
		this.subCharge = subCharge;
	}

	/**
	 * Return the value associated with the column: main_charge_id
	 */
	public jkt.hms.masters.business.MasMainChargecode getMainCharge() {
		return mainCharge;
	}

	/**
	 * Set the value related to the column: main_charge_id
	 * 
	 * @param mainCharge
	 *            the main_charge_id value
	 */
	public void setMainCharge(
			jkt.hms.masters.business.MasMainChargecode mainCharge) {
		this.mainCharge = mainCharge;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.DiagParam))
			return false;
		else {
			jkt.hms.masters.business.DiagParam diagParam = (jkt.hms.masters.business.DiagParam) obj;
			if (null == this.getId() || null == diagParam.getId())
				return false;
			else
				return (this.getId().equals(diagParam.getId()));
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
package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the ap_block table. Do not
 * modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * 
 * @hibernate.class table="ap_block"
 */

public abstract class BaseApBlock implements Serializable {

	public static String REF = "ApBlock";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_BLOCK_TO_DATE = "BlockToDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_BLOCK_FROM_DATE = "BlockFromDate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_ID = "Id";
	public static String PROP_REASON = "Reason";

	// constructors
	public BaseApBlock() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseApBlock(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date blockFromDate;
	private java.util.Date blockToDate;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String reason;

	// many to one
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasHospital hospital;

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
	 * Return the value associated with the column: block_from_date
	 */
	public java.util.Date getBlockFromDate() {
		return blockFromDate;
	}

	/**
	 * Set the value related to the column: block_from_date
	 * 
	 * @param blockFromDate
	 *            the block_from_date value
	 */
	public void setBlockFromDate(java.util.Date blockFromDate) {
		this.blockFromDate = blockFromDate;
	}

	/**
	 * Return the value associated with the column: block_to_date
	 */
	public java.util.Date getBlockToDate() {
		return blockToDate;
	}

	/**
	 * Set the value related to the column: block_to_date
	 * 
	 * @param blockToDate
	 *            the block_to_date value
	 */
	public void setBlockToDate(java.util.Date blockToDate) {
		this.blockToDate = blockToDate;
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
	 * Return the value associated with the column: reason
	 */
	public java.lang.String getReason() {
		return reason;
	}

	/**
	 * Set the value related to the column: reason
	 * 
	 * @param reason
	 *            the reason value
	 */
	public void setReason(java.lang.String reason) {
		this.reason = reason;
	}

	/**
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment() {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * 
	 * @param department
	 *            the department_id value
	 */
	public void setDepartment(jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
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

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.ApBlock))
			return false;
		else {
			jkt.hms.masters.business.ApBlock apBlock = (jkt.hms.masters.business.ApBlock) obj;
			if (null == this.getId() || null == apBlock.getId())
				return false;
			else
				return (this.getId().equals(apBlock.getId()));
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
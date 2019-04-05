package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the commutation_weightage
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="commutation_weightage"
 */

public abstract class BaseCommutationWeightage implements Serializable {

	public static String REF = "CommutationWeightage";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_COMMUTATION_WEIGHTAGE_CODE = "CommutationWeightageCode";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_CM_VALUE = "CmValue";
	public static String PROP_AGE = "Age";
	public static String PROP_ID = "Id";

	// constructors
	public BaseCommutationWeightage() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCommutationWeightage(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String commutationWeightageCode;
	private java.lang.Integer age;
	private java.math.BigDecimal cmValue;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

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
	 * Return the value associated with the column: commutation_weightage_code
	 */
	public java.lang.String getCommutationWeightageCode() {
		return commutationWeightageCode;
	}

	/**
	 * Set the value related to the column: commutation_weightage_code
	 * 
	 * @param commutationWeightageCode
	 *            the commutation_weightage_code value
	 */
	public void setCommutationWeightageCode(
			java.lang.String commutationWeightageCode) {
		this.commutationWeightageCode = commutationWeightageCode;
	}

	/**
	 * Return the value associated with the column: age
	 */
	public java.lang.Integer getAge() {
		return age;
	}

	/**
	 * Set the value related to the column: age
	 * 
	 * @param age
	 *            the age value
	 */
	public void setAge(java.lang.Integer age) {
		this.age = age;
	}

	/**
	 * Return the value associated with the column: cmValue
	 */
	public java.math.BigDecimal getCmValue() {
		return cmValue;
	}

	/**
	 * Set the value related to the column: cmValue
	 * 
	 * @param cmValue
	 *            the cmValue value
	 */
	public void setCmValue(java.math.BigDecimal cmValue) {
		this.cmValue = cmValue;
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
		if (!(obj instanceof jkt.hms.masters.business.CommutationWeightage))
			return false;
		else {
			jkt.hms.masters.business.CommutationWeightage commutationWeightage = (jkt.hms.masters.business.CommutationWeightage) obj;
			if (null == this.getId() || null == commutationWeightage.getId())
				return false;
			else
				return (this.getId().equals(commutationWeightage.getId()));
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
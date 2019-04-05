package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_care_type table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="mas_care_type"
 */

public abstract class BaseMasCareType implements Serializable {

	public static String REF = "MasCareType";
	public static String PROP_STATUS = "Status";
	public static String PROP_CARE_TYPE_CODE = "CareTypeCode";
	public static String PROP_CARE_TYPE_NAME = "CareTypeName";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ID = "Id";

	// constructors
	public BaseMasCareType() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasCareType(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String careTypeCode;
	private java.lang.String careTypeName;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// collections
	private java.util.Set<jkt.hms.masters.business.Discharge> discharges;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="care_type_id"
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
	 * Return the value associated with the column: care_type_code
	 */
	public java.lang.String getCareTypeCode() {
		return careTypeCode;
	}

	/**
	 * Set the value related to the column: care_type_code
	 * 
	 * @param careTypeCode
	 *            the care_type_code value
	 */
	public void setCareTypeCode(java.lang.String careTypeCode) {
		this.careTypeCode = careTypeCode;
	}

	/**
	 * Return the value associated with the column: care_type_name
	 */
	public java.lang.String getCareTypeName() {
		return careTypeName;
	}

	/**
	 * Set the value related to the column: care_type_name
	 * 
	 * @param careTypeName
	 *            the care_type_name value
	 */
	public void setCareTypeName(java.lang.String careTypeName) {
		this.careTypeName = careTypeName;
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
	 * Return the value associated with the column: Discharges
	 */
	public java.util.Set<jkt.hms.masters.business.Discharge> getDischarges() {
		return discharges;
	}

	/**
	 * Set the value related to the column: Discharges
	 * 
	 * @param discharges
	 *            the Discharges value
	 */
	public void setDischarges(
			java.util.Set<jkt.hms.masters.business.Discharge> discharges) {
		this.discharges = discharges;
	}

	public void addToDischarges(jkt.hms.masters.business.Discharge discharge) {
		if (null == getDischarges())
			setDischarges(new java.util.TreeSet<jkt.hms.masters.business.Discharge>());
		getDischarges().add(discharge);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MasCareType))
			return false;
		else {
			jkt.hms.masters.business.MasCareType masCareType = (jkt.hms.masters.business.MasCareType) obj;
			if (null == this.getId() || null == masCareType.getId())
				return false;
			else
				return (this.getId().equals(masCareType.getId()));
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
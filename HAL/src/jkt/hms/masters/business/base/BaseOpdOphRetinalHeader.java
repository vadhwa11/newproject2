package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the opd_oph_retinal_header
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="opd_oph_retinal_header"
 */

public abstract class BaseOpdOphRetinalHeader implements Serializable {

	public static String REF = "OpdOphRetinalHeader";
	public static String PROP_VISIT = "Visit";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LEFT_EYE = "LeftEye";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_RETINAL_LASER_DATE = "RetinalLaserDate";
	public static String PROP_HIN = "Hin";
	public static String PROP_RIGHT_EYE = "RightEye";
	public static String PROP_ID = "Id";

	// constructors
	public BaseOpdOphRetinalHeader() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdOphRetinalHeader(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String rightEye;
	private java.lang.String leftEye;
	private java.util.Date retinalLaserDate;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.Patient hin;

	// collections
	private java.util.Set<jkt.hms.masters.business.OpdOphRetinalDetails> opdOphRetinalDetails;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="oph_retinal_header_id"
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
	 * Return the value associated with the column: right_eye
	 */
	public java.lang.String getRightEye() {
		return rightEye;
	}

	/**
	 * Set the value related to the column: right_eye
	 * 
	 * @param rightEye
	 *            the right_eye value
	 */
	public void setRightEye(java.lang.String rightEye) {
		this.rightEye = rightEye;
	}

	/**
	 * Return the value associated with the column: left_eye
	 */
	public java.lang.String getLeftEye() {
		return leftEye;
	}

	/**
	 * Set the value related to the column: left_eye
	 * 
	 * @param leftEye
	 *            the left_eye value
	 */
	public void setLeftEye(java.lang.String leftEye) {
		this.leftEye = leftEye;
	}

	/**
	 * Return the value associated with the column: retinal_laser_date
	 */
	public java.util.Date getRetinalLaserDate() {
		return retinalLaserDate;
	}

	/**
	 * Set the value related to the column: retinal_laser_date
	 * 
	 * @param retinalLaserDate
	 *            the retinal_laser_date value
	 */
	public void setRetinalLaserDate(java.util.Date retinalLaserDate) {
		this.retinalLaserDate = retinalLaserDate;
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
	 * Return the value associated with the column: visit_id
	 */
	public jkt.hms.masters.business.Visit getVisit() {
		return visit;
	}

	/**
	 * Set the value related to the column: visit_id
	 * 
	 * @param visit
	 *            the visit_id value
	 */
	public void setVisit(jkt.hms.masters.business.Visit visit) {
		this.visit = visit;
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

	/**
	 * Return the value associated with the column: OpdOphRetinalDetails
	 */
	public java.util.Set<jkt.hms.masters.business.OpdOphRetinalDetails> getOpdOphRetinalDetails() {
		return opdOphRetinalDetails;
	}

	/**
	 * Set the value related to the column: OpdOphRetinalDetails
	 * 
	 * @param opdOphRetinalDetails
	 *            the OpdOphRetinalDetails value
	 */
	public void setOpdOphRetinalDetails(
			java.util.Set<jkt.hms.masters.business.OpdOphRetinalDetails> opdOphRetinalDetails) {
		this.opdOphRetinalDetails = opdOphRetinalDetails;
	}

	public void addToOpdOphRetinalDetails(
			jkt.hms.masters.business.OpdOphRetinalDetails opdOphRetinalDetails) {
		if (null == getOpdOphRetinalDetails())
			setOpdOphRetinalDetails(new java.util.TreeSet<jkt.hms.masters.business.OpdOphRetinalDetails>());
		getOpdOphRetinalDetails().add(opdOphRetinalDetails);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.OpdOphRetinalHeader))
			return false;
		else {
			jkt.hms.masters.business.OpdOphRetinalHeader opdOphRetinalHeader = (jkt.hms.masters.business.OpdOphRetinalHeader) obj;
			if (null == this.getId() || null == opdOphRetinalHeader.getId())
				return false;
			else
				return (this.getId().equals(opdOphRetinalHeader.getId()));
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
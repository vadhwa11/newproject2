package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the opd_oph_retinal_details
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="opd_oph_retinal_details"
 */

public abstract class BaseOpdOphRetinalDetails implements Serializable {

	public static String REF = "OpdOphRetinalDetails";
	public static String PROP_NO_OF_SPOTS = "NoOfSpots";
	public static String PROP_LASER_TYPE = "LaserType";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_EYE = "Eye";
	public static String PROP_SIGN = "Sign";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_POWER = "Power";
	public static String PROP_DOCTOR_NAME = "DoctorName";
	public static String PROP_OPH_RETINAL_HEADER = "OphRetinalHeader";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DURATION = "Duration";
	public static String PROP_ID = "Id";

	// constructors
	public BaseOpdOphRetinalDetails() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdOphRetinalDetails(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String eye;
	private java.lang.String power;
	private java.lang.String duration;
	private java.lang.String noOfSpots;
	private java.lang.String laserType;
	private java.lang.String doctorName;
	private java.lang.String sign;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.OpdOphRetinalHeader ophRetinalHeader;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="oph_retinal_details_id"
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
	 * Return the value associated with the column: eye
	 */
	public java.lang.String getEye() {
		return eye;
	}

	/**
	 * Set the value related to the column: eye
	 * 
	 * @param eye
	 *            the eye value
	 */
	public void setEye(java.lang.String eye) {
		this.eye = eye;
	}

	/**
	 * Return the value associated with the column: power
	 */
	public java.lang.String getPower() {
		return power;
	}

	/**
	 * Set the value related to the column: power
	 * 
	 * @param power
	 *            the power value
	 */
	public void setPower(java.lang.String power) {
		this.power = power;
	}

	/**
	 * Return the value associated with the column: duration
	 */
	public java.lang.String getDuration() {
		return duration;
	}

	/**
	 * Set the value related to the column: duration
	 * 
	 * @param duration
	 *            the duration value
	 */
	public void setDuration(java.lang.String duration) {
		this.duration = duration;
	}

	/**
	 * Return the value associated with the column: no_of_spots
	 */
	public java.lang.String getNoOfSpots() {
		return noOfSpots;
	}

	/**
	 * Set the value related to the column: no_of_spots
	 * 
	 * @param noOfSpots
	 *            the no_of_spots value
	 */
	public void setNoOfSpots(java.lang.String noOfSpots) {
		this.noOfSpots = noOfSpots;
	}

	/**
	 * Return the value associated with the column: laser_type
	 */
	public java.lang.String getLaserType() {
		return laserType;
	}

	/**
	 * Set the value related to the column: laser_type
	 * 
	 * @param laserType
	 *            the laser_type value
	 */
	public void setLaserType(java.lang.String laserType) {
		this.laserType = laserType;
	}

	/**
	 * Return the value associated with the column: doctor_name
	 */
	public java.lang.String getDoctorName() {
		return doctorName;
	}

	/**
	 * Set the value related to the column: doctor_name
	 * 
	 * @param doctorName
	 *            the doctor_name value
	 */
	public void setDoctorName(java.lang.String doctorName) {
		this.doctorName = doctorName;
	}

	/**
	 * Return the value associated with the column: sign
	 */
	public java.lang.String getSign() {
		return sign;
	}

	/**
	 * Set the value related to the column: sign
	 * 
	 * @param sign
	 *            the sign value
	 */
	public void setSign(java.lang.String sign) {
		this.sign = sign;
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
	 * Return the value associated with the column: oph_retinal_header_id
	 */
	public jkt.hms.masters.business.OpdOphRetinalHeader getOphRetinalHeader() {
		return ophRetinalHeader;
	}

	/**
	 * Set the value related to the column: oph_retinal_header_id
	 * 
	 * @param ophRetinalHeader
	 *            the oph_retinal_header_id value
	 */
	public void setOphRetinalHeader(
			jkt.hms.masters.business.OpdOphRetinalHeader ophRetinalHeader) {
		this.ophRetinalHeader = ophRetinalHeader;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.OpdOphRetinalDetails))
			return false;
		else {
			jkt.hms.masters.business.OpdOphRetinalDetails opdOphRetinalDetails = (jkt.hms.masters.business.OpdOphRetinalDetails) obj;
			if (null == this.getId() || null == opdOphRetinalDetails.getId())
				return false;
			else
				return (this.getId().equals(opdOphRetinalDetails.getId()));
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
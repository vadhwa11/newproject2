package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the AVI_AIRCREW_MEDICAL_LECTURES table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="AVI_AIRCREW_MEDICAL_LECTURES"
 */

public abstract class BaseAviAircrewMedicalLectures  implements Serializable {

	public static String REF = "AviAircrewMedicalLectures";
	public static String PROP_MO_NAME = "MoName";
	public static String PROP_PLACE_OF_LECTURE = "PlaceOfLecture";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_TIME_STARTED = "TimeStarted";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_LECTURE_SUBJECT = "LectureSubject";
	public static String PROP_NUMBER_ATTENDED = "NumberAttended";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_AIRCREW_DATE = "AircrewDate";
	public static String PROP_DURATION = "Duration";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseAviAircrewMedicalLectures () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAviAircrewMedicalLectures (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseAviAircrewMedicalLectures (
		java.lang.Integer id,
		java.lang.String status) {

		this.setId(id);
		this.setStatus(status);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date aircrewDate;
	private java.lang.String timeStarted;
	private java.lang.Integer duration;
	private java.lang.String lectureSubject;
	private java.lang.Integer numberAttended;
	private java.lang.String remarks;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasUnit placeOfLecture;
	private jkt.hms.masters.business.MasEmployee moName;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="AIRCREW_ID"
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
	 * Return the value associated with the column: AIRCREW_DATE
	 */
	public java.util.Date getAircrewDate () {
		return aircrewDate;
	}

	/**
	 * Set the value related to the column: AIRCREW_DATE
	 * @param aircrewDate the AIRCREW_DATE value
	 */
	public void setAircrewDate (java.util.Date aircrewDate) {
		this.aircrewDate = aircrewDate;
	}



	/**
	 * Return the value associated with the column: TIME_STARTED
	 */
	public java.lang.String getTimeStarted () {
		return timeStarted;
	}

	/**
	 * Set the value related to the column: TIME_STARTED
	 * @param timeStarted the TIME_STARTED value
	 */
	public void setTimeStarted (java.lang.String timeStarted) {
		this.timeStarted = timeStarted;
	}



	/**
	 * Return the value associated with the column: DURATION
	 */
	public java.lang.Integer getDuration () {
		return duration;
	}

	/**
	 * Set the value related to the column: DURATION
	 * @param duration the DURATION value
	 */
	public void setDuration (java.lang.Integer duration) {
		this.duration = duration;
	}



	/**
	 * Return the value associated with the column: LECTURE_SUBJECT
	 */
	public java.lang.String getLectureSubject () {
		return lectureSubject;
	}

	/**
	 * Set the value related to the column: LECTURE_SUBJECT
	 * @param lectureSubject the LECTURE_SUBJECT value
	 */
	public void setLectureSubject (java.lang.String lectureSubject) {
		this.lectureSubject = lectureSubject;
	}



	/**
	 * Return the value associated with the column: NUMBER_ATTENDED
	 */
	public java.lang.Integer getNumberAttended () {
		return numberAttended;
	}

	/**
	 * Set the value related to the column: NUMBER_ATTENDED
	 * @param numberAttended the NUMBER_ATTENDED value
	 */
	public void setNumberAttended (java.lang.Integer numberAttended) {
		this.numberAttended = numberAttended;
	}



	/**
	 * Return the value associated with the column: REMARKS
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: REMARKS
	 * @param remarks the REMARKS value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
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
	 * Return the value associated with the column: LAST_CHG_BY
	 */
	public java.lang.String getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: LAST_CHG_BY
	 * @param lastChgBy the LAST_CHG_BY value
	 */
	public void setLastChgBy (java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
	}



	/**
	 * Return the value associated with the column: LAST_CHG_DATE
	 */
	public java.util.Date getLastChgDate () {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: LAST_CHG_DATE
	 * @param lastChgDate the LAST_CHG_DATE value
	 */
	public void setLastChgDate (java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}



	/**
	 * Return the value associated with the column: LAST_CHG_TIME
	 */
	public java.lang.String getLastChgTime () {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: LAST_CHG_TIME
	 * @param lastChgTime the LAST_CHG_TIME value
	 */
	public void setLastChgTime (java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}



	/**
	 * Return the value associated with the column: PLACE_OF_LECTURE
	 */
	public jkt.hms.masters.business.MasUnit getPlaceOfLecture () {
		return placeOfLecture;
	}

	/**
	 * Set the value related to the column: PLACE_OF_LECTURE
	 * @param placeOfLecture the PLACE_OF_LECTURE value
	 */
	public void setPlaceOfLecture (jkt.hms.masters.business.MasUnit placeOfLecture) {
		this.placeOfLecture = placeOfLecture;
	}



	/**
	 * Return the value associated with the column: MO_NAME
	 */
	public jkt.hms.masters.business.MasEmployee getMoName () {
		return moName;
	}

	/**
	 * Set the value related to the column: MO_NAME
	 * @param moName the MO_NAME value
	 */
	public void setMoName (jkt.hms.masters.business.MasEmployee moName) {
		this.moName = moName;
	}



	/**
	 * Return the value associated with the column: HOSPITAL_ID
	 */
	public jkt.hms.masters.business.MasHospital getHospital () {
		return hospital;
	}

	/**
	 * Set the value related to the column: HOSPITAL_ID
	 * @param hospital the HOSPITAL_ID value
	 */
	public void setHospital (jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}



	/**
	 * Return the value associated with the column: DEPARTMENT_ID
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment () {
		return department;
	}

	/**
	 * Set the value related to the column: DEPARTMENT_ID
	 * @param department the DEPARTMENT_ID value
	 */
	public void setDepartment (jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.AviAircrewMedicalLectures)) return false;
		else {
			jkt.hms.masters.business.AviAircrewMedicalLectures aviAircrewMedicalLectures = (jkt.hms.masters.business.AviAircrewMedicalLectures) obj;
			if (null == this.getId() || null == aviAircrewMedicalLectures.getId()) return false;
			else return (this.getId().equals(aviAircrewMedicalLectures.getId()));
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
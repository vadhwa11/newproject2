package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the hr_medical_course_master
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="hr_medical_course_master"
 */

public abstract class BaseHrMedicalCourseMaster implements Serializable {

	public static String REF = "HrMedicalCourseMaster";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_COURSE_CODE = "CourseCode";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_COURSE_NAME = "CourseName";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_COURSE_TYPE = "CourseType";

	// constructors
	public BaseHrMedicalCourseMaster() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrMedicalCourseMaster(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String courseCode;
	private java.lang.String courseName;
	private java.lang.String courseType;
	private java.lang.Integer hospitalId;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

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
	 * Return the value associated with the column: course_code
	 */
	public java.lang.String getCourseCode() {
		return courseCode;
	}

	/**
	 * Set the value related to the column: course_code
	 * 
	 * @param courseCode
	 *            the course_code value
	 */
	public void setCourseCode(java.lang.String courseCode) {
		this.courseCode = courseCode;
	}

	/**
	 * Return the value associated with the column: course_name
	 */
	public java.lang.String getCourseName() {
		return courseName;
	}

	/**
	 * Set the value related to the column: course_name
	 * 
	 * @param courseName
	 *            the course_name value
	 */
	public void setCourseName(java.lang.String courseName) {
		this.courseName = courseName;
	}

	/**
	 * Return the value associated with the column: course_type
	 */
	public java.lang.String getCourseType() {
		return courseType;
	}

	/**
	 * Set the value related to the column: course_type
	 * 
	 * @param courseType
	 *            the course_type value
	 */
	public void setCourseType(java.lang.String courseType) {
		this.courseType = courseType;
	}

	/**
	 * Return the value associated with the column: hospital_id
	 */
	public java.lang.Integer getHospitalId() {
		return hospitalId;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * 
	 * @param hospitalId
	 *            the hospital_id value
	 */
	public void setHospitalId(java.lang.Integer hospitalId) {
		this.hospitalId = hospitalId;
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

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.HrMedicalCourseMaster))
			return false;
		else {
			jkt.hms.masters.business.HrMedicalCourseMaster hrMedicalCourseMaster = (jkt.hms.masters.business.HrMedicalCourseMaster) obj;
			if (null == this.getId() || null == hrMedicalCourseMaster.getId())
				return false;
			else
				return (this.getId().equals(hrMedicalCourseMaster.getId()));
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
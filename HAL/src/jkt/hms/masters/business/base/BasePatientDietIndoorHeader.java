package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the patient_diet_indoor_header table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="patient_diet_indoor_header"
 */

public abstract class BasePatientDietIndoorHeader  implements Serializable {

	public static String REF = "PatientDietIndoorHeader";
	public static String PROP_STATUS = "Status";
	public static String PROP_PREPAREDBY = "Preparedby";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_TIME = "Time";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_DATEOFCREATION = "Dateofcreation";
	public static String PROP_DEPARTMENTS = "Departments";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BasePatientDietIndoorHeader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePatientDietIndoorHeader (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date dateofcreation;
	private java.lang.Integer preparedby;
	private java.lang.String time;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasDepartment departments;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="id"
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
	 * Return the value associated with the column: dateofcreation
	 */
	public java.util.Date getDateofcreation () {
		return dateofcreation;
	}

	/**
	 * Set the value related to the column: dateofcreation
	 * @param dateofcreation the dateofcreation value
	 */
	public void setDateofcreation (java.util.Date dateofcreation) {
		this.dateofcreation = dateofcreation;
	}



	/**
	 * Return the value associated with the column: preparedby
	 */
	public java.lang.Integer getPreparedby () {
		return preparedby;
	}

	/**
	 * Set the value related to the column: preparedby
	 * @param preparedby the preparedby value
	 */
	public void setPreparedby (java.lang.Integer preparedby) {
		this.preparedby = preparedby;
	}



	/**
	 * Return the value associated with the column: time
	 */
	public java.lang.String getTime () {
		return time;
	}

	/**
	 * Set the value related to the column: time
	 * @param time the time value
	 */
	public void setTime (java.lang.String time) {
		this.time = time;
	}



	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.String getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
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
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartments () {
		return departments;
	}

	/**
	 * Set the value related to the column: department_id
	 * @param departments the department_id value
	 */
	public void setDepartments (jkt.hms.masters.business.MasDepartment departments) {
		this.departments = departments;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PatientDietIndoorHeader)) return false;
		else {
			jkt.hms.masters.business.PatientDietIndoorHeader patientDietIndoorHeader = (jkt.hms.masters.business.PatientDietIndoorHeader) obj;
			if (null == this.getId() || null == patientDietIndoorHeader.getId()) return false;
			else return (this.getId().equals(patientDietIndoorHeader.getId()));
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
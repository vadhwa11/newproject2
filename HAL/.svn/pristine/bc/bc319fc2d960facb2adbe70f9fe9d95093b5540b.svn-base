package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the doctor_roaster table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="doctor_roaster"
 */

public abstract class BaseDoctorRoaster  implements Serializable {

	public static String REF = "DoctorRoaster";
	public static String PROP_CHG_BY = "ChgBy";
	public static String PROP_ROASTER_DATE = "RoasterDate";
	public static String PROP_CHG_TIME = "ChgTime";
	public static String PROP_CHG_DATE = "ChgDate";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_ROASTER_VALUE = "RoasterValue";
	public static String PROP_DOCTOR = "Doctor";


	// constructors
	public BaseDoctorRoaster () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDoctorRoaster (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date roasterDate;
	private java.lang.String roasterValue;
	private java.util.Date chgDate;
	private java.lang.String chgTime;

	// many to one
	private jkt.hms.masters.business.Users chgBy;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasEmployee doctor;



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
	 * Return the value associated with the column: roaster_date
	 */
	public java.util.Date getRoasterDate () {
		return roasterDate;
	}

	/**
	 * Set the value related to the column: roaster_date
	 * @param roasterDate the roaster_date value
	 */
	public void setRoasterDate (java.util.Date roasterDate) {
		this.roasterDate = roasterDate;
	}



	/**
	 * Return the value associated with the column: roaster_value
	 */
	public java.lang.String getRoasterValue () {
		return roasterValue;
	}

	/**
	 * Set the value related to the column: roaster_value
	 * @param roasterValue the roaster_value value
	 */
	public void setRoasterValue (java.lang.String roasterValue) {
		this.roasterValue = roasterValue;
	}



	/**
	 * Return the value associated with the column: chg_date
	 */
	public java.util.Date getChgDate () {
		return chgDate;
	}

	/**
	 * Set the value related to the column: chg_date
	 * @param chgDate the chg_date value
	 */
	public void setChgDate (java.util.Date chgDate) {
		this.chgDate = chgDate;
	}



	/**
	 * Return the value associated with the column: chg_time
	 */
	public java.lang.String getChgTime () {
		return chgTime;
	}

	/**
	 * Set the value related to the column: chg_time
	 * @param chgTime the chg_time value
	 */
	public void setChgTime (java.lang.String chgTime) {
		this.chgTime = chgTime;
	}



	/**
	 * Return the value associated with the column: chg_by
	 */
	public jkt.hms.masters.business.Users getChgBy () {
		return chgBy;
	}

	/**
	 * Set the value related to the column: chg_by
	 * @param chgBy the chg_by value
	 */
	public void setChgBy (jkt.hms.masters.business.Users chgBy) {
		this.chgBy = chgBy;
	}



	/**
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment () {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * @param department the department_id value
	 */
	public void setDepartment (jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}



	/**
	 * Return the value associated with the column: doctor_id
	 */
	public jkt.hms.masters.business.MasEmployee getDoctor () {
		return doctor;
	}

	/**
	 * Set the value related to the column: doctor_id
	 * @param doctor the doctor_id value
	 */
	public void setDoctor (jkt.hms.masters.business.MasEmployee doctor) {
		this.doctor = doctor;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.DoctorRoaster)) return false;
		else {
			jkt.hms.masters.business.DoctorRoaster doctorRoaster = (jkt.hms.masters.business.DoctorRoaster) obj;
			if (null == this.getId() || null == doctorRoaster.getId()) return false;
			else return (this.getId().equals(doctorRoaster.getId()));
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
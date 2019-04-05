package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ACTIVITY_DETAILS table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ACTIVITY_DETAILS"
 */

public abstract class BaseActivityDetails  implements Serializable {

	public static String REF = "ActivityDetails";
	public static String PROP_ACTIVITY_OFFICERS = "ActivityOfficers";
	public static String PROP_ACTIVITY_DETAILS = "ActivityDetails";
	public static String PROP_ACTIVITY_AIRMEN = "ActivityAirmen";
	public static String PROP_ACTIVITY_FAMILIES = "ActivityFamilies";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT_ID = "DepartmentId";
	public static String PROP_HOSPITAL_ID = "Hospital_id";
	public static String PROP_ACTIVITY_DATE = "ActivityDate";
	public static String PROP_ACTIVITY_REMARKS = "ActivityRemarks";


	// constructors
	public BaseActivityDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseActivityDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date activityDate;
	private java.lang.String activityDetails;
	private java.lang.String activityOfficers;
	private java.lang.String activityAirmen;
	private java.lang.String activityFamilies;
	private java.lang.String activityRemarks;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital_id;
	private jkt.hms.masters.business.MasDepartment departmentId;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="ID"
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
	 * Return the value associated with the column: ACTIVITY_DATE
	 */
	public java.util.Date getActivityDate () {
		return activityDate;
	}

	/**
	 * Set the value related to the column: ACTIVITY_DATE
	 * @param activityDate the ACTIVITY_DATE value
	 */
	public void setActivityDate (java.util.Date activityDate) {
		this.activityDate = activityDate;
	}



	/**
	 * Return the value associated with the column: ACTIVITY_DETAILS
	 */
	public java.lang.String getActivityDetails () {
		return activityDetails;
	}

	/**
	 * Set the value related to the column: ACTIVITY_DETAILS
	 * @param activityDetails the ACTIVITY_DETAILS value
	 */
	public void setActivityDetails (java.lang.String activityDetails) {
		this.activityDetails = activityDetails;
	}



	/**
	 * Return the value associated with the column: ACTIVITY_OFFICERS
	 */
	public java.lang.String getActivityOfficers () {
		return activityOfficers;
	}

	/**
	 * Set the value related to the column: ACTIVITY_OFFICERS
	 * @param activityOfficers the ACTIVITY_OFFICERS value
	 */
	public void setActivityOfficers (java.lang.String activityOfficers) {
		this.activityOfficers = activityOfficers;
	}



	/**
	 * Return the value associated with the column: ACTIVITY_AIRMEN
	 */
	public java.lang.String getActivityAirmen () {
		return activityAirmen;
	}

	/**
	 * Set the value related to the column: ACTIVITY_AIRMEN
	 * @param activityAirmen the ACTIVITY_AIRMEN value
	 */
	public void setActivityAirmen (java.lang.String activityAirmen) {
		this.activityAirmen = activityAirmen;
	}



	/**
	 * Return the value associated with the column: ACTIVITY_FAMILIES
	 */
	public java.lang.String getActivityFamilies () {
		return activityFamilies;
	}

	/**
	 * Set the value related to the column: ACTIVITY_FAMILIES
	 * @param activityFamilies the ACTIVITY_FAMILIES value
	 */
	public void setActivityFamilies (java.lang.String activityFamilies) {
		this.activityFamilies = activityFamilies;
	}



	/**
	 * Return the value associated with the column: ACTIVITY_REMARKS
	 */
	public java.lang.String getActivityRemarks () {
		return activityRemarks;
	}

	/**
	 * Set the value related to the column: ACTIVITY_REMARKS
	 * @param activityRemarks the ACTIVITY_REMARKS value
	 */
	public void setActivityRemarks (java.lang.String activityRemarks) {
		this.activityRemarks = activityRemarks;
	}



	/**
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital_id () {
		return hospital_id;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * @param hospital_id the hospital_id value
	 */
	public void setHospital_id (jkt.hms.masters.business.MasHospital hospital_id) {
		this.hospital_id = hospital_id;
	}



	/**
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartmentId () {
		return departmentId;
	}

	/**
	 * Set the value related to the column: department_id
	 * @param departmentId the department_id value
	 */
	public void setDepartmentId (jkt.hms.masters.business.MasDepartment departmentId) {
		this.departmentId = departmentId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.ActivityDetails)) return false;
		else {
			jkt.hms.masters.business.ActivityDetails activityDetails = (jkt.hms.masters.business.ActivityDetails) obj;
			if (null == this.getId() || null == activityDetails.getId()) return false;
			else return (this.getId().equals(activityDetails.getId()));
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
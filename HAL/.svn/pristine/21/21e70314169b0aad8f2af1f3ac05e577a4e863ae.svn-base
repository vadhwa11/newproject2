package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the FREE_FROM_INFECTION table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="FREE_FROM_INFECTION"
 */

public abstract class BaseFreeFromInfection  implements Serializable {

	public static String REF = "FreeFromInfection";
	public static String PROP_INFECTION_DATE = "InfectionDate";
	public static String PROP_LAST_CHANGE_BY = "LastChangeBy";
	public static String PROP_INF_PURPOSE = "InfPurpose";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHANGE_DATE = "LastChangeDate";
	public static String PROP_INF_PARTICULAR = "InfParticular";
	public static String PROP_DEPARTMENT_ID = "DepartmentId";
	public static String PROP_INF_PLACE = "InfPlace";
	public static String PROP_LAST_CHANGE_TIME = "LastChangeTime";
	public static String PROP_INF_FIT_UNFIT = "InfFitUnfit";


	// constructors
	public BaseFreeFromInfection () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFreeFromInfection (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date infectionDate;
	private java.lang.String infPurpose;
	private java.lang.String infPlace;
	private java.lang.String infParticular;
	private java.lang.String infFitUnfit;
	private java.lang.String lastChangeBy;
	private java.util.Date lastChangeDate;
	private java.lang.String lastChangeTime;

	// many to one
	private jkt.hms.masters.business.MasDepartment departmentId;
	private jkt.hms.masters.business.MasHospital hospitalId;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="INFECTION_ID"
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
	 * Return the value associated with the column: INFECTION_DATE
	 */
	public java.util.Date getInfectionDate () {
		return infectionDate;
	}

	/**
	 * Set the value related to the column: INFECTION_DATE
	 * @param infectionDate the INFECTION_DATE value
	 */
	public void setInfectionDate (java.util.Date infectionDate) {
		this.infectionDate = infectionDate;
	}



	/**
	 * Return the value associated with the column: INF_PURPOSE
	 */
	public java.lang.String getInfPurpose () {
		return infPurpose;
	}

	/**
	 * Set the value related to the column: INF_PURPOSE
	 * @param infPurpose the INF_PURPOSE value
	 */
	public void setInfPurpose (java.lang.String infPurpose) {
		this.infPurpose = infPurpose;
	}



	/**
	 * Return the value associated with the column: INF_PLACE
	 */
	public java.lang.String getInfPlace () {
		return infPlace;
	}

	/**
	 * Set the value related to the column: INF_PLACE
	 * @param infPlace the INF_PLACE value
	 */
	public void setInfPlace (java.lang.String infPlace) {
		this.infPlace = infPlace;
	}



	/**
	 * Return the value associated with the column: INF_PARTICULAR
	 */
	public java.lang.String getInfParticular () {
		return infParticular;
	}

	/**
	 * Set the value related to the column: INF_PARTICULAR
	 * @param infParticular the INF_PARTICULAR value
	 */
	public void setInfParticular (java.lang.String infParticular) {
		this.infParticular = infParticular;
	}



	/**
	 * Return the value associated with the column: INF_FIT_UNFIT
	 */
	public java.lang.String getInfFitUnfit () {
		return infFitUnfit;
	}

	/**
	 * Set the value related to the column: INF_FIT_UNFIT
	 * @param infFitUnfit the INF_FIT_UNFIT value
	 */
	public void setInfFitUnfit (java.lang.String infFitUnfit) {
		this.infFitUnfit = infFitUnfit;
	}



	/**
	 * Return the value associated with the column: LAST_CHANGE_BY
	 */
	public java.lang.String getLastChangeBy () {
		return lastChangeBy;
	}

	/**
	 * Set the value related to the column: LAST_CHANGE_BY
	 * @param lastChangeBy the LAST_CHANGE_BY value
	 */
	public void setLastChangeBy (java.lang.String lastChangeBy) {
		this.lastChangeBy = lastChangeBy;
	}



	/**
	 * Return the value associated with the column: LAST_CHANGE_DATE
	 */
	public java.util.Date getLastChangeDate () {
		return lastChangeDate;
	}

	/**
	 * Set the value related to the column: LAST_CHANGE_DATE
	 * @param lastChangeDate the LAST_CHANGE_DATE value
	 */
	public void setLastChangeDate (java.util.Date lastChangeDate) {
		this.lastChangeDate = lastChangeDate;
	}



	/**
	 * Return the value associated with the column: LAST_CHANGE_TIME
	 */
	public java.lang.String getLastChangeTime () {
		return lastChangeTime;
	}

	/**
	 * Set the value related to the column: LAST_CHANGE_TIME
	 * @param lastChangeTime the LAST_CHANGE_TIME value
	 */
	public void setLastChangeTime (java.lang.String lastChangeTime) {
		this.lastChangeTime = lastChangeTime;
	}



	/**
	 * Return the value associated with the column: DEPARTMENT_ID
	 */
	public jkt.hms.masters.business.MasDepartment getDepartmentId () {
		return departmentId;
	}

	/**
	 * Set the value related to the column: DEPARTMENT_ID
	 * @param departmentId the DEPARTMENT_ID value
	 */
	public void setDepartmentId (jkt.hms.masters.business.MasDepartment departmentId) {
		this.departmentId = departmentId;
	}



	/**
	 * Return the value associated with the column: HOSPITAL_ID
	 */
	public jkt.hms.masters.business.MasHospital getHospitalId () {
		return hospitalId;
	}

	/**
	 * Set the value related to the column: HOSPITAL_ID
	 * @param hospitalId the HOSPITAL_ID value
	 */
	public void setHospitalId (jkt.hms.masters.business.MasHospital hospitalId) {
		this.hospitalId = hospitalId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.FreeFromInfection)) return false;
		else {
			jkt.hms.masters.business.FreeFromInfection freeFromInfection = (jkt.hms.masters.business.FreeFromInfection) obj;
			if (null == this.getId() || null == freeFromInfection.getId()) return false;
			else return (this.getId().equals(freeFromInfection.getId()));
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
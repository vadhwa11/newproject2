package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the TOKEN_DISPLAY table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="TOKEN_DISPLAY"
 */

public abstract class BaseTokenDisplay  implements Serializable {

	public static String REF = "TokenDisplay";
	public static String PROP_VISIT_ID = "VisitId";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_ID = "Id";
	public static String PROP_VISIT_DATE = "VisitDate";
	public static String PROP_EMPLOYEE_ID = "EmployeeId";


	// constructors
	public BaseTokenDisplay () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTokenDisplay (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer employeeId;
	private java.lang.Integer visitId;
	private java.lang.Integer hospitalId;
	private java.util.Date visitDate;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="TOKEN_DISPALY_ID"
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
	 * Return the value associated with the column: EMPLOYEE_ID
	 */
	public java.lang.Integer getEmployeeId () {
		return employeeId;
	}

	/**
	 * Set the value related to the column: EMPLOYEE_ID
	 * @param employeeId the EMPLOYEE_ID value
	 */
	public void setEmployeeId (java.lang.Integer employeeId) {
		this.employeeId = employeeId;
	}



	/**
	 * Return the value associated with the column: VISIT_ID
	 */
	public java.lang.Integer getVisitId () {
		return visitId;
	}

	/**
	 * Set the value related to the column: VISIT_ID
	 * @param visitId the VISIT_ID value
	 */
	public void setVisitId (java.lang.Integer visitId) {
		this.visitId = visitId;
	}



	/**
	 * Return the value associated with the column: HOSPITAL_ID
	 */
	public java.lang.Integer getHospitalId () {
		return hospitalId;
	}

	/**
	 * Set the value related to the column: HOSPITAL_ID
	 * @param hospitalId the HOSPITAL_ID value
	 */
	public void setHospitalId (java.lang.Integer hospitalId) {
		this.hospitalId = hospitalId;
	}



	/**
	 * Return the value associated with the column: VISIT_DATE
	 */
	public java.util.Date getVisitDate () {
		return visitDate;
	}

	/**
	 * Set the value related to the column: VISIT_DATE
	 * @param visitDate the VISIT_DATE value
	 */
	public void setVisitDate (java.util.Date visitDate) {
		this.visitDate = visitDate;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.TokenDisplay)) return false;
		else {
			jkt.hms.masters.business.TokenDisplay tokenDisplay = (jkt.hms.masters.business.TokenDisplay) obj;
			if (null == this.getId() || null == tokenDisplay.getId()) return false;
			else return (this.getId().equals(tokenDisplay.getId()));
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
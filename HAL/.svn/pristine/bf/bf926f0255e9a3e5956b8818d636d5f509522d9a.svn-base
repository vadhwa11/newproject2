package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the PATIENT_IMMUNIZATION_DETAILS table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="PATIENT_IMMUNIZATION_DETAILS"
 */

public abstract class BasePatientImmunizationDetails  implements Serializable {

	public static String REF = "PatientImmunizationDetails";
	public static String PROP_DOE = "Doe";
	public static String PROP_DOSE = "Dose";
	public static String PROP_IMMUNIZATION_DATE = "ImmunizationDate";
	public static String PROP_FLAG = "Flag";
	public static String PROP_DUE_DATE = "DueDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_IMMUNIZATION = "Immunization";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ID = "Id";
	public static String PROP_DOM = "Dom";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_BATCH_NO = "BatchNo";
	public static String PROP_HIN = "Hin";
	public static String PROP_ROUTE = "Route";
	public static String PROP_IMMUNIZATION_DETAIL = "ImmunizationDetail";


	// constructors
	public BasePatientImmunizationDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePatientImmunizationDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date immunizationDate;
	private java.lang.String remarks;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String dose;
	private java.lang.String route;
	private java.lang.String batchNo;
	private java.util.Date doe;
	private java.util.Date dom;
	private java.lang.String immunizationDetail;
	private java.util.Date dueDate;
	private java.lang.String flag;

	// many to one
	private jkt.hms.masters.business.MasImmunization immunization;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Users lastChgBy;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="patient_immunization_detail_id"
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
	 * Return the value associated with the column: immunization_date
	 */
	public java.util.Date getImmunizationDate () {
		return immunizationDate;
	}

	/**
	 * Set the value related to the column: immunization_date
	 * @param immunizationDate the immunization_date value
	 */
	public void setImmunizationDate (java.util.Date immunizationDate) {
		this.immunizationDate = immunizationDate;
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
	 * Return the value associated with the column: dose
	 */
	public java.lang.String getDose () {
		return dose;
	}

	/**
	 * Set the value related to the column: dose
	 * @param dose the dose value
	 */
	public void setDose (java.lang.String dose) {
		this.dose = dose;
	}



	/**
	 * Return the value associated with the column: route
	 */
	public java.lang.String getRoute () {
		return route;
	}

	/**
	 * Set the value related to the column: route
	 * @param route the route value
	 */
	public void setRoute (java.lang.String route) {
		this.route = route;
	}



	/**
	 * Return the value associated with the column: batch_no
	 */
	public java.lang.String getBatchNo () {
		return batchNo;
	}

	/**
	 * Set the value related to the column: batch_no
	 * @param batchNo the batch_no value
	 */
	public void setBatchNo (java.lang.String batchNo) {
		this.batchNo = batchNo;
	}



	/**
	 * Return the value associated with the column: Doe
	 */
	public java.util.Date getDoe () {
		return doe;
	}

	/**
	 * Set the value related to the column: Doe
	 * @param doe the Doe value
	 */
	public void setDoe (java.util.Date doe) {
		this.doe = doe;
	}



	/**
	 * Return the value associated with the column: dom
	 */
	public java.util.Date getDom () {
		return dom;
	}

	/**
	 * Set the value related to the column: dom
	 * @param dom the dom value
	 */
	public void setDom (java.util.Date dom) {
		this.dom = dom;
	}



	/**
	 * Return the value associated with the column: IMMUNIZATION_DETAIL
	 */
	public java.lang.String getImmunizationDetail () {
		return immunizationDetail;
	}

	/**
	 * Set the value related to the column: IMMUNIZATION_DETAIL
	 * @param immunizationDetail the IMMUNIZATION_DETAIL value
	 */
	public void setImmunizationDetail (java.lang.String immunizationDetail) {
		this.immunizationDetail = immunizationDetail;
	}



	/**
	 * Return the value associated with the column: DUE_DATE
	 */
	public java.util.Date getDueDate () {
		return dueDate;
	}

	/**
	 * Set the value related to the column: DUE_DATE
	 * @param dueDate the DUE_DATE value
	 */
	public void setDueDate (java.util.Date dueDate) {
		this.dueDate = dueDate;
	}



	/**
	 * Return the value associated with the column: FLAG
	 */
	public java.lang.String getFlag () {
		return flag;
	}

	/**
	 * Set the value related to the column: FLAG
	 * @param flag the FLAG value
	 */
	public void setFlag (java.lang.String flag) {
		this.flag = flag;
	}



	/**
	 * Return the value associated with the column: immunization_id
	 */
	public jkt.hms.masters.business.MasImmunization getImmunization () {
		return immunization;
	}

	/**
	 * Set the value related to the column: immunization_id
	 * @param immunization the immunization_id value
	 */
	public void setImmunization (jkt.hms.masters.business.MasImmunization immunization) {
		this.immunization = immunization;
	}



	/**
	 * Return the value associated with the column: HIN_ID
	 */
	public jkt.hms.masters.business.Patient getHin () {
		return hin;
	}

	/**
	 * Set the value related to the column: HIN_ID
	 * @param hin the HIN_ID value
	 */
	public void setHin (jkt.hms.masters.business.Patient hin) {
		this.hin = hin;
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
	 * Return the value associated with the column: LAST_CHG_BY
	 */
	public jkt.hms.masters.business.Users getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: LAST_CHG_BY
	 * @param lastChgBy the LAST_CHG_BY value
	 */
	public void setLastChgBy (jkt.hms.masters.business.Users lastChgBy) {
		this.lastChgBy = lastChgBy;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PatientImmunizationDetails)) return false;
		else {
			jkt.hms.masters.business.PatientImmunizationDetails patientImmunizationDetails = (jkt.hms.masters.business.PatientImmunizationDetails) obj;
			if (null == this.getId() || null == patientImmunizationDetails.getId()) return false;
			else return (this.getId().equals(patientImmunizationDetails.getId()));
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
package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the DENTAL_TREATMENT_HEADER table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="DENTAL_TREATMENT_HEADER"
 */

public abstract class BaseDentalTreatmentHeader  implements Serializable {

	public static String REF = "DentalTreatmentHeader";
	public static String PROP_OPD_PATIENT_DETAIL = "OpdPatientDetail";
	public static String PROP_STATUS = "Status";
	public static String PROP_TREATMENT_TIME = "TreatmentTime";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_TREATMENT_DATE = "TreatmentDate";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_VISIT = "Visit";
	public static String PROP_HIN = "Hin";


	// constructors
	public BaseDentalTreatmentHeader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDentalTreatmentHeader (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date treatmentDate;
	private java.lang.String treatmentTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.OpdPatientDetails opdPatientDetail;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.MasHospital hospital;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="DENTAL_TREATMENT_HEADER_ID"
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
	 * Return the value associated with the column: TREATMENT_DATE
	 */
	public java.util.Date getTreatmentDate () {
		return treatmentDate;
	}

	/**
	 * Set the value related to the column: TREATMENT_DATE
	 * @param treatmentDate the TREATMENT_DATE value
	 */
	public void setTreatmentDate (java.util.Date treatmentDate) {
		this.treatmentDate = treatmentDate;
	}



	/**
	 * Return the value associated with the column: TREATMENT_TIME
	 */
	public java.lang.String getTreatmentTime () {
		return treatmentTime;
	}

	/**
	 * Set the value related to the column: TREATMENT_TIME
	 * @param treatmentTime the TREATMENT_TIME value
	 */
	public void setTreatmentTime (java.lang.String treatmentTime) {
		this.treatmentTime = treatmentTime;
	}



	/**
	 * Return the value associated with the column: STATUS
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: STATUS
	 * @param status the STATUS value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
	}



	/**
	 * Return the value associated with the column: VISIT_ID
	 */
	public jkt.hms.masters.business.Visit getVisit () {
		return visit;
	}

	/**
	 * Set the value related to the column: VISIT_ID
	 * @param visit the VISIT_ID value
	 */
	public void setVisit (jkt.hms.masters.business.Visit visit) {
		this.visit = visit;
	}



	/**
	 * Return the value associated with the column: OPD_PATIENT_DETAIL_ID
	 */
	public jkt.hms.masters.business.OpdPatientDetails getOpdPatientDetail () {
		return opdPatientDetail;
	}

	/**
	 * Set the value related to the column: OPD_PATIENT_DETAIL_ID
	 * @param opdPatientDetail the OPD_PATIENT_DETAIL_ID value
	 */
	public void setOpdPatientDetail (jkt.hms.masters.business.OpdPatientDetails opdPatientDetail) {
		this.opdPatientDetail = opdPatientDetail;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.DentalTreatmentHeader)) return false;
		else {
			jkt.hms.masters.business.DentalTreatmentHeader dentalTreatmentHeader = (jkt.hms.masters.business.DentalTreatmentHeader) obj;
			if (null == this.getId() || null == dentalTreatmentHeader.getId()) return false;
			else return (this.getId().equals(dentalTreatmentHeader.getId()));
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
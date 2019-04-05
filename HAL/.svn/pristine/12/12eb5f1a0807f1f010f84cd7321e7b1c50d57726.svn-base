package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the MALARIA_CASE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="MALARIA_CASE"
 */

public abstract class BaseMalariaCase  implements Serializable {

	public static String REF = "MalariaCase";
	public static String PROP_SERVICE_NO = "ServiceNo";
	public static String PROP_TRANSMISSION = "Transmission";
	public static String PROP_TYPE = "Type";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_PATIENT_NAME = "PatientName";
	public static String PROP_STATUS = "Status";
	public static String PROP_DATE_OF_ONSET = "DateOfOnset";
	public static String PROP_DATE_OF_ADMISSION = "DateOfAdmission";
	public static String PROP_ID = "Id";
	public static String PROP_FORWARD_TO = "ForwardTo";
	public static String PROP_DEPARTMENT_ID = "DepartmentId";
	public static String PROP_SPECIES = "Species";
	public static String PROP_HIN_ID = "HinId";


	// constructors
	public BaseMalariaCase () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMalariaCase (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String serviceNo;
	private java.lang.String patientName;
	private java.util.Date dateOfOnset;
	private java.util.Date dateOfAdmission;
	private java.lang.String species;
	private java.lang.String type;
	private java.lang.String transmission;
	private java.lang.String forwardTo;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.Patient hinId;
	private jkt.hms.masters.business.MasHospital hospitalId;
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
	 * Return the value associated with the column: SERVICE_NO
	 */
	public java.lang.String getServiceNo () {
		return serviceNo;
	}

	/**
	 * Set the value related to the column: SERVICE_NO
	 * @param serviceNo the SERVICE_NO value
	 */
	public void setServiceNo (java.lang.String serviceNo) {
		this.serviceNo = serviceNo;
	}



	/**
	 * Return the value associated with the column: PATIENT_NAME
	 */
	public java.lang.String getPatientName () {
		return patientName;
	}

	/**
	 * Set the value related to the column: PATIENT_NAME
	 * @param patientName the PATIENT_NAME value
	 */
	public void setPatientName (java.lang.String patientName) {
		this.patientName = patientName;
	}



	/**
	 * Return the value associated with the column: DATE_OF_ONSET
	 */
	public java.util.Date getDateOfOnset () {
		return dateOfOnset;
	}

	/**
	 * Set the value related to the column: DATE_OF_ONSET
	 * @param dateOfOnset the DATE_OF_ONSET value
	 */
	public void setDateOfOnset (java.util.Date dateOfOnset) {
		this.dateOfOnset = dateOfOnset;
	}



	/**
	 * Return the value associated with the column: DATE_OF_ADMISSION
	 */
	public java.util.Date getDateOfAdmission () {
		return dateOfAdmission;
	}

	/**
	 * Set the value related to the column: DATE_OF_ADMISSION
	 * @param dateOfAdmission the DATE_OF_ADMISSION value
	 */
	public void setDateOfAdmission (java.util.Date dateOfAdmission) {
		this.dateOfAdmission = dateOfAdmission;
	}



	/**
	 * Return the value associated with the column: SPECIES
	 */
	public java.lang.String getSpecies () {
		return species;
	}

	/**
	 * Set the value related to the column: SPECIES
	 * @param species the SPECIES value
	 */
	public void setSpecies (java.lang.String species) {
		this.species = species;
	}



	/**
	 * Return the value associated with the column: TYPE
	 */
	public java.lang.String getType () {
		return type;
	}

	/**
	 * Set the value related to the column: TYPE
	 * @param type the TYPE value
	 */
	public void setType (java.lang.String type) {
		this.type = type;
	}



	/**
	 * Return the value associated with the column: TRANSMISSION
	 */
	public java.lang.String getTransmission () {
		return transmission;
	}

	/**
	 * Set the value related to the column: TRANSMISSION
	 * @param transmission the TRANSMISSION value
	 */
	public void setTransmission (java.lang.String transmission) {
		this.transmission = transmission;
	}



	/**
	 * Return the value associated with the column: FORWARD_TO
	 */
	public java.lang.String getForwardTo () {
		return forwardTo;
	}

	/**
	 * Set the value related to the column: FORWARD_TO
	 * @param forwardTo the FORWARD_TO value
	 */
	public void setForwardTo (java.lang.String forwardTo) {
		this.forwardTo = forwardTo;
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
	 * Return the value associated with the column: HIN_ID
	 */
	public jkt.hms.masters.business.Patient getHinId () {
		return hinId;
	}

	/**
	 * Set the value related to the column: HIN_ID
	 * @param hinId the HIN_ID value
	 */
	public void setHinId (jkt.hms.masters.business.Patient hinId) {
		this.hinId = hinId;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MalariaCase)) return false;
		else {
			jkt.hms.masters.business.MalariaCase malariaCase = (jkt.hms.masters.business.MalariaCase) obj;
			if (null == this.getId() || null == malariaCase.getId()) return false;
			else return (this.getId().equals(malariaCase.getId()));
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
package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the NOTIFIABLE_DISEASE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="NOTIFIABLE_DISEASE"
 */

public abstract class BaseNotifiableDisease  implements Serializable {

	public static String REF = "NotifiableDisease";
	public static String PROP_DISINFECTION = "Disinfection";
	public static String PROP_CLINICAL = "Clinical";
	public static String PROP_CONTACT = "Contact";
	public static String PROP_HIN_ID = "Hin_id";
	public static String PROP_DATE_OF_PREVENTIVE = "DateOfPreventive";
	public static String PROP_SUSPECTED_SOURCE_OF_INFECTION = "SuspectedSourceOfInfection";
	public static String PROP_GENERAL_REMARKS = "GeneralRemarks";
	public static String PROP_DETAILS_OF_CASE = "DetailsOfCase";
	public static String PROP_HOSPITAL_ID = "Hospital_Id";
	public static String PROP_BACTERIOLOGICAL = "Bacteriological";
	public static String PROP_DATE_OF_ONSET = "DateOfOnset";
	public static String PROP_DATE_OF_ADMISSION = "DateOfAdmission";
	public static String PROP_SERVICE_NO = "Service_No";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT_ID = "DepartmentId";
	public static String PROP_DATE_OF_REPORTING_SICK = "DateOfReportingSick";


	// constructors
	public BaseNotifiableDisease () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseNotifiableDisease (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date dateOfOnset;
	private java.util.Date dateOfReportingSick;
	private java.util.Date dateOfAdmission;
	private java.lang.String detailsOfCase;
	private java.lang.String clinical;
	private java.lang.String bacteriological;
	private java.lang.String suspectedSourceOfInfection;
	private java.lang.String disinfection;
	private java.lang.String contact;
	private java.lang.String dateOfPreventive;
	private java.lang.String generalRemarks;
	private java.lang.String service_No;

	// many to one
	private jkt.hms.masters.business.Patient hin_id;
	private jkt.hms.masters.business.MasHospital hospital_Id;
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
	 * Return the value associated with the column: DATE_OF_REPORTING_SICK
	 */
	public java.util.Date getDateOfReportingSick () {
		return dateOfReportingSick;
	}

	/**
	 * Set the value related to the column: DATE_OF_REPORTING_SICK
	 * @param dateOfReportingSick the DATE_OF_REPORTING_SICK value
	 */
	public void setDateOfReportingSick (java.util.Date dateOfReportingSick) {
		this.dateOfReportingSick = dateOfReportingSick;
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
	 * Return the value associated with the column: DETAILS_OF_CASE
	 */
	public java.lang.String getDetailsOfCase () {
		return detailsOfCase;
	}

	/**
	 * Set the value related to the column: DETAILS_OF_CASE
	 * @param detailsOfCase the DETAILS_OF_CASE value
	 */
	public void setDetailsOfCase (java.lang.String detailsOfCase) {
		this.detailsOfCase = detailsOfCase;
	}



	/**
	 * Return the value associated with the column: CLINICAL
	 */
	public java.lang.String getClinical () {
		return clinical;
	}

	/**
	 * Set the value related to the column: CLINICAL
	 * @param clinical the CLINICAL value
	 */
	public void setClinical (java.lang.String clinical) {
		this.clinical = clinical;
	}



	/**
	 * Return the value associated with the column: BACTERIOLOGICAL
	 */
	public java.lang.String getBacteriological () {
		return bacteriological;
	}

	/**
	 * Set the value related to the column: BACTERIOLOGICAL
	 * @param bacteriological the BACTERIOLOGICAL value
	 */
	public void setBacteriological (java.lang.String bacteriological) {
		this.bacteriological = bacteriological;
	}



	/**
	 * Return the value associated with the column: SUSPECTED_SOURCE_OF_INFECTION
	 */
	public java.lang.String getSuspectedSourceOfInfection () {
		return suspectedSourceOfInfection;
	}

	/**
	 * Set the value related to the column: SUSPECTED_SOURCE_OF_INFECTION
	 * @param suspectedSourceOfInfection the SUSPECTED_SOURCE_OF_INFECTION value
	 */
	public void setSuspectedSourceOfInfection (java.lang.String suspectedSourceOfInfection) {
		this.suspectedSourceOfInfection = suspectedSourceOfInfection;
	}



	/**
	 * Return the value associated with the column: DISINFECTION
	 */
	public java.lang.String getDisinfection () {
		return disinfection;
	}

	/**
	 * Set the value related to the column: DISINFECTION
	 * @param disinfection the DISINFECTION value
	 */
	public void setDisinfection (java.lang.String disinfection) {
		this.disinfection = disinfection;
	}



	/**
	 * Return the value associated with the column: CONTACT
	 */
	public java.lang.String getContact () {
		return contact;
	}

	/**
	 * Set the value related to the column: CONTACT
	 * @param contact the CONTACT value
	 */
	public void setContact (java.lang.String contact) {
		this.contact = contact;
	}



	/**
	 * Return the value associated with the column: DATE_OF_PREVENTIVE
	 */
	public java.lang.String getDateOfPreventive () {
		return dateOfPreventive;
	}

	/**
	 * Set the value related to the column: DATE_OF_PREVENTIVE
	 * @param dateOfPreventive the DATE_OF_PREVENTIVE value
	 */
	public void setDateOfPreventive (java.lang.String dateOfPreventive) {
		this.dateOfPreventive = dateOfPreventive;
	}



	/**
	 * Return the value associated with the column: GENERAL_REMARKS
	 */
	public java.lang.String getGeneralRemarks () {
		return generalRemarks;
	}

	/**
	 * Set the value related to the column: GENERAL_REMARKS
	 * @param generalRemarks the GENERAL_REMARKS value
	 */
	public void setGeneralRemarks (java.lang.String generalRemarks) {
		this.generalRemarks = generalRemarks;
	}



	/**
	 * Return the value associated with the column: service_no
	 */
	public java.lang.String getService_No () {
		return service_No;
	}

	/**
	 * Set the value related to the column: service_no
	 * @param service_No the service_no value
	 */
	public void setService_No (java.lang.String service_No) {
		this.service_No = service_No;
	}



	/**
	 * Return the value associated with the column: hin_id
	 */
	public jkt.hms.masters.business.Patient getHin_id () {
		return hin_id;
	}

	/**
	 * Set the value related to the column: hin_id
	 * @param hin_id the hin_id value
	 */
	public void setHin_id (jkt.hms.masters.business.Patient hin_id) {
		this.hin_id = hin_id;
	}



	/**
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital_Id () {
		return hospital_Id;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * @param hospital_Id the hospital_id value
	 */
	public void setHospital_Id (jkt.hms.masters.business.MasHospital hospital_Id) {
		this.hospital_Id = hospital_Id;
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
		if (!(obj instanceof jkt.hms.masters.business.NotifiableDisease)) return false;
		else {
			jkt.hms.masters.business.NotifiableDisease notifiableDisease = (jkt.hms.masters.business.NotifiableDisease) obj;
			if (null == this.getId() || null == notifiableDisease.getId()) return false;
			else return (this.getId().equals(notifiableDisease.getId()));
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
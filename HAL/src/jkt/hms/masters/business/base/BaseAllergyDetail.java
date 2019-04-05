package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ALLERGY_DETAIL table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ALLERGY_DETAIL"
 */

public abstract class BaseAllergyDetail  implements Serializable {

	public static String REF = "AllergyDetail";
	public static String PROP_DESCRIPTION = "Description";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_MEDICAL_OFFICER = "MedicalOfficer";
	public static String PROP_REACTIONS = "Reactions";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_ALLERGY_TYPE = "AllergyType";
	public static String PROP_VISIT = "Visit";
	public static String PROP_SINCE = "Since";
	public static String PROP_ALLERGY_NAME = "AllergyName";
	public static String PROP_STATUS = "Status";
	public static String PROP_SEVERITY = "Severity";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_HIN = "Hin";
	public static String PROP_INPATIENT = "Inpatient";


	// constructors
	public BaseAllergyDetail () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAllergyDetail (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String description;
	private java.lang.String severity;
	private java.lang.String reactions;
	private java.lang.String since;
	private java.lang.String remarks;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;
	private java.lang.String allergyName;

	// many to one
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.MasEmployee medicalOfficer;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.MasAllergyType allergyType;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="ALLERGY_DETAIL_ID"
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
	 * Return the value associated with the column: description
	 */
	public java.lang.String getDescription () {
		return description;
	}

	/**
	 * Set the value related to the column: description
	 * @param description the description value
	 */
	public void setDescription (java.lang.String description) {
		this.description = description;
	}



	/**
	 * Return the value associated with the column: severity
	 */
	public java.lang.String getSeverity () {
		return severity;
	}

	/**
	 * Set the value related to the column: severity
	 * @param severity the severity value
	 */
	public void setSeverity (java.lang.String severity) {
		this.severity = severity;
	}



	/**
	 * Return the value associated with the column: reactions
	 */
	public java.lang.String getReactions () {
		return reactions;
	}

	/**
	 * Set the value related to the column: reactions
	 * @param reactions the reactions value
	 */
	public void setReactions (java.lang.String reactions) {
		this.reactions = reactions;
	}



	/**
	 * Return the value associated with the column: since
	 */
	public java.lang.String getSince () {
		return since;
	}

	/**
	 * Set the value related to the column: since
	 * @param since the since value
	 */
	public void setSince (java.lang.String since) {
		this.since = since;
	}



	/**
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * @param remarks the remarks value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
	}



	/**
	 * Return the value associated with the column: LASt_CHG_DATE
	 */
	public java.util.Date getLastChgDate () {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: LASt_CHG_DATE
	 * @param lastChgDate the LASt_CHG_DATE value
	 */
	public void setLastChgDate (java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}



	/**
	 * Return the value associated with the column: LASt_CHG_TIME
	 */
	public java.lang.String getLastChgTime () {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: LASt_CHG_TIME
	 * @param lastChgTime the LASt_CHG_TIME value
	 */
	public void setLastChgTime (java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
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
	 * Return the value associated with the column: ALLERGY_NAME
	 */
	public java.lang.String getAllergyName () {
		return allergyName;
	}

	/**
	 * Set the value related to the column: ALLERGY_NAME
	 * @param allergyName the ALLERGY_NAME value
	 */
	public void setAllergyName (java.lang.String allergyName) {
		this.allergyName = allergyName;
	}



	/**
	 * Return the value associated with the column: hin_id
	 */
	public jkt.hms.masters.business.Patient getHin () {
		return hin;
	}

	/**
	 * Set the value related to the column: hin_id
	 * @param hin the hin_id value
	 */
	public void setHin (jkt.hms.masters.business.Patient hin) {
		this.hin = hin;
	}



	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public jkt.hms.masters.business.Users getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (jkt.hms.masters.business.Users lastChgBy) {
		this.lastChgBy = lastChgBy;
	}



	/**
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital () {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * @param hospital the hospital_id value
	 */
	public void setHospital (jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}



	/**
	 * Return the value associated with the column: inpatient_id
	 */
	public jkt.hms.masters.business.Inpatient getInpatient () {
		return inpatient;
	}

	/**
	 * Set the value related to the column: inpatient_id
	 * @param inpatient the inpatient_id value
	 */
	public void setInpatient (jkt.hms.masters.business.Inpatient inpatient) {
		this.inpatient = inpatient;
	}



	/**
	 * Return the value associated with the column: medical_officer_id
	 */
	public jkt.hms.masters.business.MasEmployee getMedicalOfficer () {
		return medicalOfficer;
	}

	/**
	 * Set the value related to the column: medical_officer_id
	 * @param medicalOfficer the medical_officer_id value
	 */
	public void setMedicalOfficer (jkt.hms.masters.business.MasEmployee medicalOfficer) {
		this.medicalOfficer = medicalOfficer;
	}



	/**
	 * Return the value associated with the column: visit_id
	 */
	public jkt.hms.masters.business.Visit getVisit () {
		return visit;
	}

	/**
	 * Set the value related to the column: visit_id
	 * @param visit the visit_id value
	 */
	public void setVisit (jkt.hms.masters.business.Visit visit) {
		this.visit = visit;
	}



	/**
	 * Return the value associated with the column: allergy_type_id
	 */
	public jkt.hms.masters.business.MasAllergyType getAllergyType () {
		return allergyType;
	}

	/**
	 * Set the value related to the column: allergy_type_id
	 * @param allergyType the allergy_type_id value
	 */
	public void setAllergyType (jkt.hms.masters.business.MasAllergyType allergyType) {
		this.allergyType = allergyType;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.AllergyDetail)) return false;
		else {
			jkt.hms.masters.business.AllergyDetail allergyDetail = (jkt.hms.masters.business.AllergyDetail) obj;
			if (null == this.getId() || null == allergyDetail.getId()) return false;
			else return (this.getId().equals(allergyDetail.getId()));
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
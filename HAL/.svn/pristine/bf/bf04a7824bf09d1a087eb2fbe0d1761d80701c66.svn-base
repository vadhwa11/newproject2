package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the MIS_CONFIRMED_H1N1 table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="MIS_CONFIRMED_H1N1"
 */

public abstract class BaseMisConfirmedH1n1  implements Serializable {

	public static String REF = "MisConfirmedH1n1";
	public static String PROP_RESULT = "Result";
	public static String PROP_PRESENT_CONDITION = "PresentCondition";
	public static String PROP_SERVICE_NO = "ServiceNo";
	public static String PROP_TESTING_LABORATORY = "TestingLaboratory";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_MED_FACILITY_FIRST = "MedFacilityFirst";
	public static String PROP_TREATMENT = "Treatment";
	public static String PROP_DATE_SAMPLE_SENT = "DateSampleSent";
	public static String PROP_DATE_OF_REPORT = "DateOfReport";
	public static String PROP_STATUS = "Status";
	public static String PROP_RESPIRATORY = "Respiratory";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_MED_UNIT_FIRST_ADMITTED = "MedUnitFirstAdmitted";
	public static String PROP_DATE_OF_ONSET = "DateOfOnset";
	public static String PROP_DATE_OF_ADMISSION = "DateOfAdmission";
	public static String PROP_CONTACT_WITH_CASE = "ContactWithCase";
	public static String PROP_CLINICAL_FEATURES = "ClinicalFeatures";
	public static String PROP_ID = "Id";
	public static String PROP_TRAVELL = "Travell";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_HIN = "Hin";


	// constructors
	public BaseMisConfirmedH1n1 () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMisConfirmedH1n1 (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String serviceNo;
	private java.lang.String medFacilityFirst;
	private java.lang.String medUnitFirstAdmitted;
	private java.util.Date dateOfOnset;
	private java.util.Date dateOfAdmission;
	private java.lang.String contactWithCase;
	private java.lang.String travell;
	private java.lang.String clinicalFeatures;
	private java.lang.String respiratory;
	private java.util.Date dateSampleSent;
	private java.lang.String testingLaboratory;
	private java.util.Date dateOfReport;
	private java.lang.String result;
	private java.lang.String treatment;
	private java.lang.String presentCondition;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Patient hin;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="H1N1_ID"
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
	 * Return the value associated with the column: MED_FACILITY_FIRST
	 */
	public java.lang.String getMedFacilityFirst () {
		return medFacilityFirst;
	}

	/**
	 * Set the value related to the column: MED_FACILITY_FIRST
	 * @param medFacilityFirst the MED_FACILITY_FIRST value
	 */
	public void setMedFacilityFirst (java.lang.String medFacilityFirst) {
		this.medFacilityFirst = medFacilityFirst;
	}



	/**
	 * Return the value associated with the column: MED_UNIT_FIRST_ADMITTED
	 */
	public java.lang.String getMedUnitFirstAdmitted () {
		return medUnitFirstAdmitted;
	}

	/**
	 * Set the value related to the column: MED_UNIT_FIRST_ADMITTED
	 * @param medUnitFirstAdmitted the MED_UNIT_FIRST_ADMITTED value
	 */
	public void setMedUnitFirstAdmitted (java.lang.String medUnitFirstAdmitted) {
		this.medUnitFirstAdmitted = medUnitFirstAdmitted;
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
	 * Return the value associated with the column: CONTACT_WITH_CASE
	 */
	public java.lang.String getContactWithCase () {
		return contactWithCase;
	}

	/**
	 * Set the value related to the column: CONTACT_WITH_CASE
	 * @param contactWithCase the CONTACT_WITH_CASE value
	 */
	public void setContactWithCase (java.lang.String contactWithCase) {
		this.contactWithCase = contactWithCase;
	}



	/**
	 * Return the value associated with the column: TRAVELL
	 */
	public java.lang.String getTravell () {
		return travell;
	}

	/**
	 * Set the value related to the column: TRAVELL
	 * @param travell the TRAVELL value
	 */
	public void setTravell (java.lang.String travell) {
		this.travell = travell;
	}



	/**
	 * Return the value associated with the column: CLINICAL_FEATURES
	 */
	public java.lang.String getClinicalFeatures () {
		return clinicalFeatures;
	}

	/**
	 * Set the value related to the column: CLINICAL_FEATURES
	 * @param clinicalFeatures the CLINICAL_FEATURES value
	 */
	public void setClinicalFeatures (java.lang.String clinicalFeatures) {
		this.clinicalFeatures = clinicalFeatures;
	}



	/**
	 * Return the value associated with the column: RESPIRATORY
	 */
	public java.lang.String getRespiratory () {
		return respiratory;
	}

	/**
	 * Set the value related to the column: RESPIRATORY
	 * @param respiratory the RESPIRATORY value
	 */
	public void setRespiratory (java.lang.String respiratory) {
		this.respiratory = respiratory;
	}



	/**
	 * Return the value associated with the column: DATE_SAMPLE_SENT
	 */
	public java.util.Date getDateSampleSent () {
		return dateSampleSent;
	}

	/**
	 * Set the value related to the column: DATE_SAMPLE_SENT
	 * @param dateSampleSent the DATE_SAMPLE_SENT value
	 */
	public void setDateSampleSent (java.util.Date dateSampleSent) {
		this.dateSampleSent = dateSampleSent;
	}



	/**
	 * Return the value associated with the column: TESTING_LABORATORY
	 */
	public java.lang.String getTestingLaboratory () {
		return testingLaboratory;
	}

	/**
	 * Set the value related to the column: TESTING_LABORATORY
	 * @param testingLaboratory the TESTING_LABORATORY value
	 */
	public void setTestingLaboratory (java.lang.String testingLaboratory) {
		this.testingLaboratory = testingLaboratory;
	}



	/**
	 * Return the value associated with the column: DATE_OF_REPORT
	 */
	public java.util.Date getDateOfReport () {
		return dateOfReport;
	}

	/**
	 * Set the value related to the column: DATE_OF_REPORT
	 * @param dateOfReport the DATE_OF_REPORT value
	 */
	public void setDateOfReport (java.util.Date dateOfReport) {
		this.dateOfReport = dateOfReport;
	}



	/**
	 * Return the value associated with the column: RESULT
	 */
	public java.lang.String getResult () {
		return result;
	}

	/**
	 * Set the value related to the column: RESULT
	 * @param result the RESULT value
	 */
	public void setResult (java.lang.String result) {
		this.result = result;
	}



	/**
	 * Return the value associated with the column: TREATMENT
	 */
	public java.lang.String getTreatment () {
		return treatment;
	}

	/**
	 * Set the value related to the column: TREATMENT
	 * @param treatment the TREATMENT value
	 */
	public void setTreatment (java.lang.String treatment) {
		this.treatment = treatment;
	}



	/**
	 * Return the value associated with the column: PRESENT_CONDITION
	 */
	public java.lang.String getPresentCondition () {
		return presentCondition;
	}

	/**
	 * Set the value related to the column: PRESENT_CONDITION
	 * @param presentCondition the PRESENT_CONDITION value
	 */
	public void setPresentCondition (java.lang.String presentCondition) {
		this.presentCondition = presentCondition;
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
	 * Return the value associated with the column: LAST_CHG_BY
	 */
	public java.lang.String getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: LAST_CHG_BY
	 * @param lastChgBy the LAST_CHG_BY value
	 */
	public void setLastChgBy (java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MisConfirmedH1n1)) return false;
		else {
			jkt.hms.masters.business.MisConfirmedH1n1 misConfirmedH1n1 = (jkt.hms.masters.business.MisConfirmedH1n1) obj;
			if (null == this.getId() || null == misConfirmedH1n1.getId()) return false;
			else return (this.getId().equals(misConfirmedH1n1.getId()));
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
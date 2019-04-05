package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the opd_oph_diagnosis_header
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="opd_oph_diagnosis_header"
 */

public abstract class BaseOpdOphDiagnosisHeader implements Serializable {

	public static String REF = "OpdOphDiagnosisHeader";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_OCULAR = "Ocular";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_HIN = "Hin";
	public static String PROP_VISIT = "Visit";
	public static String PROP_RIGHT_EYE_SURGERY = "RightEyeSurgery";
	public static String PROP_LEFT_EYE_SURGERY = "LeftEyeSurgery";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ANESTHESIA = "Anesthesia";
	public static String PROP_NEXT_REVIEW_DATE = "NextReviewDate";
	public static String PROP_SYSTEMIC = "Systemic";
	public static String PROP_PLAN = "Plan";
	public static String PROP_ID = "Id";

	// constructors
	public BaseOpdOphDiagnosisHeader() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdOphDiagnosisHeader(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String ocular;
	private java.lang.String systemic;
	private java.lang.String plan;
	private java.lang.String rightEyeSurgery;
	private java.lang.String leftEyeSurgery;
	private java.util.Date nextReviewDate;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasAnesthesia anesthesia;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.Patient hin;

	// collections
	private java.util.Set<jkt.hms.masters.business.OpdOphDiagnosisDetails> opdOphDiagnosisDetails;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="oph_diagnosis_header_id"
	 */
	public java.lang.Integer getId() {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * 
	 * @param id
	 *            the new ID
	 */
	public void setId(java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}

	/**
	 * Return the value associated with the column: ocular
	 */
	public java.lang.String getOcular() {
		return ocular;
	}

	/**
	 * Set the value related to the column: ocular
	 * 
	 * @param ocular
	 *            the ocular value
	 */
	public void setOcular(java.lang.String ocular) {
		this.ocular = ocular;
	}

	/**
	 * Return the value associated with the column: systemic
	 */
	public java.lang.String getSystemic() {
		return systemic;
	}

	/**
	 * Set the value related to the column: systemic
	 * 
	 * @param systemic
	 *            the systemic value
	 */
	public void setSystemic(java.lang.String systemic) {
		this.systemic = systemic;
	}

	/**
	 * Return the value associated with the column: plan
	 */
	public java.lang.String getPlan() {
		return plan;
	}

	/**
	 * Set the value related to the column: plan
	 * 
	 * @param plan
	 *            the plan value
	 */
	public void setPlan(java.lang.String plan) {
		this.plan = plan;
	}

	/**
	 * Return the value associated with the column: right_eye_surgery
	 */
	public java.lang.String getRightEyeSurgery() {
		return rightEyeSurgery;
	}

	/**
	 * Set the value related to the column: right_eye_surgery
	 * 
	 * @param rightEyeSurgery
	 *            the right_eye_surgery value
	 */
	public void setRightEyeSurgery(java.lang.String rightEyeSurgery) {
		this.rightEyeSurgery = rightEyeSurgery;
	}

	/**
	 * Return the value associated with the column: left_eye_surgery
	 */
	public java.lang.String getLeftEyeSurgery() {
		return leftEyeSurgery;
	}

	/**
	 * Set the value related to the column: left_eye_surgery
	 * 
	 * @param leftEyeSurgery
	 *            the left_eye_surgery value
	 */
	public void setLeftEyeSurgery(java.lang.String leftEyeSurgery) {
		this.leftEyeSurgery = leftEyeSurgery;
	}

	/**
	 * Return the value associated with the column: next_review_date
	 */
	public java.util.Date getNextReviewDate() {
		return nextReviewDate;
	}

	/**
	 * Set the value related to the column: next_review_date
	 * 
	 * @param nextReviewDate
	 *            the next_review_date value
	 */
	public void setNextReviewDate(java.util.Date nextReviewDate) {
		this.nextReviewDate = nextReviewDate;
	}

	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.String getLastChgBy() {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * 
	 * @param lastChgBy
	 *            the last_chg_by value
	 */
	public void setLastChgBy(java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
	}

	/**
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate() {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * 
	 * @param lastChgDate
	 *            the last_chg_date value
	 */
	public void setLastChgDate(java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}

	/**
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime() {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * 
	 * @param lastChgTime
	 *            the last_chg_time value
	 */
	public void setLastChgTime(java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}

	/**
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital() {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * 
	 * @param hospital
	 *            the hospital_id value
	 */
	public void setHospital(jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}

	/**
	 * Return the value associated with the column: anesthesia_id
	 */
	public jkt.hms.masters.business.MasAnesthesia getAnesthesia() {
		return anesthesia;
	}

	/**
	 * Set the value related to the column: anesthesia_id
	 * 
	 * @param anesthesia
	 *            the anesthesia_id value
	 */
	public void setAnesthesia(jkt.hms.masters.business.MasAnesthesia anesthesia) {
		this.anesthesia = anesthesia;
	}

	/**
	 * Return the value associated with the column: visit_id
	 */
	public jkt.hms.masters.business.Visit getVisit() {
		return visit;
	}

	/**
	 * Set the value related to the column: visit_id
	 * 
	 * @param visit
	 *            the visit_id value
	 */
	public void setVisit(jkt.hms.masters.business.Visit visit) {
		this.visit = visit;
	}

	/**
	 * Return the value associated with the column: hin_id
	 */
	public jkt.hms.masters.business.Patient getHin() {
		return hin;
	}

	/**
	 * Set the value related to the column: hin_id
	 * 
	 * @param hin
	 *            the hin_id value
	 */
	public void setHin(jkt.hms.masters.business.Patient hin) {
		this.hin = hin;
	}

	/**
	 * Return the value associated with the column: OpdOphDiagnosisDetails
	 */
	public java.util.Set<jkt.hms.masters.business.OpdOphDiagnosisDetails> getOpdOphDiagnosisDetails() {
		return opdOphDiagnosisDetails;
	}

	/**
	 * Set the value related to the column: OpdOphDiagnosisDetails
	 * 
	 * @param opdOphDiagnosisDetails
	 *            the OpdOphDiagnosisDetails value
	 */
	public void setOpdOphDiagnosisDetails(
			java.util.Set<jkt.hms.masters.business.OpdOphDiagnosisDetails> opdOphDiagnosisDetails) {
		this.opdOphDiagnosisDetails = opdOphDiagnosisDetails;
	}

	public void addToOpdOphDiagnosisDetails(
			jkt.hms.masters.business.OpdOphDiagnosisDetails opdOphDiagnosisDetails) {
		if (null == getOpdOphDiagnosisDetails())
			setOpdOphDiagnosisDetails(new java.util.TreeSet<jkt.hms.masters.business.OpdOphDiagnosisDetails>());
		getOpdOphDiagnosisDetails().add(opdOphDiagnosisDetails);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.OpdOphDiagnosisHeader))
			return false;
		else {
			jkt.hms.masters.business.OpdOphDiagnosisHeader opdOphDiagnosisHeader = (jkt.hms.masters.business.OpdOphDiagnosisHeader) obj;
			if (null == this.getId() || null == opdOphDiagnosisHeader.getId())
				return false;
			else
				return (this.getId().equals(opdOphDiagnosisHeader.getId()));
		}
	}

	public int hashCode() {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId())
				return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":"
						+ this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}

	public String toString() {
		return super.toString();
	}

}
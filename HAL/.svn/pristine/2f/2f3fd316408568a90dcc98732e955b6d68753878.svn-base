package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the patient_remarks table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="patient_remarks"
 */

public abstract class BasePatientRemarks implements Serializable {

	public static String REF = "PatientRemarks";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_POST_OP_CASE = "PostOpCase";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_PATIENT_CONDITION = "PatientCondition";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_TREATMENT = "Treatment";

	// constructors
	public BasePatientRemarks() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePatientRemarks(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String remarks;
	private java.lang.String treatment;
	private java.lang.String patientCondition;
	private java.lang.String postOpCase;
	private java.lang.String lastChgBy;
	private java.lang.String lastChgTime;
	private java.util.Date lastChgDate;

	// many to one
	private jkt.hms.masters.business.Inpatient inpatient;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="id"
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
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks() {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * 
	 * @param remarks
	 *            the remarks value
	 */
	public void setRemarks(java.lang.String remarks) {
		this.remarks = remarks;
	}

	/**
	 * Return the value associated with the column: treatment
	 */
	public java.lang.String getTreatment() {
		return treatment;
	}

	/**
	 * Set the value related to the column: treatment
	 * 
	 * @param treatment
	 *            the treatment value
	 */
	public void setTreatment(java.lang.String treatment) {
		this.treatment = treatment;
	}

	/**
	 * Return the value associated with the column: patient_condition
	 */
	public java.lang.String getPatientCondition() {
		return patientCondition;
	}

	/**
	 * Set the value related to the column: patient_condition
	 * 
	 * @param patientCondition
	 *            the patient_condition value
	 */
	public void setPatientCondition(java.lang.String patientCondition) {
		this.patientCondition = patientCondition;
	}

	/**
	 * Return the value associated with the column: post_op_case
	 */
	public java.lang.String getPostOpCase() {
		return postOpCase;
	}

	/**
	 * Set the value related to the column: post_op_case
	 * 
	 * @param postOpCase
	 *            the post_op_case value
	 */
	public void setPostOpCase(java.lang.String postOpCase) {
		this.postOpCase = postOpCase;
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
	 * Return the value associated with the column: inpatient_id
	 */
	public jkt.hms.masters.business.Inpatient getInpatient() {
		return inpatient;
	}

	/**
	 * Set the value related to the column: inpatient_id
	 * 
	 * @param inpatient
	 *            the inpatient_id value
	 */
	public void setInpatient(jkt.hms.masters.business.Inpatient inpatient) {
		this.inpatient = inpatient;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.PatientRemarks))
			return false;
		else {
			jkt.hms.masters.business.PatientRemarks patientRemarks = (jkt.hms.masters.business.PatientRemarks) obj;
			if (null == this.getId() || null == patientRemarks.getId())
				return false;
			else
				return (this.getId().equals(patientRemarks.getId()));
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
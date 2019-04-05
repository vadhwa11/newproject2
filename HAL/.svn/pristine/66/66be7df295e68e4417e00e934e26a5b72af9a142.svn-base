package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * blood_sample_screening_header table. Do not modify this class because it will
 * be overwritten if the configuration file related to this class is modified.
 * 
 * @hibernate.class table="blood_sample_screening_header"
 */

public abstract class BaseBloodSampleScreeningHeader implements Serializable {

	public static String REF = "BloodSampleScreeningHeader";
	public static String PROP_FIT_BLOOD_ISSUE = "FitBloodIssue";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_MINOR_RS_DC = "MinorRsDc";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_BLOOD_ISSUE = "BloodIssue";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_HIN = "Hin";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_SAMPLE_TEST_BY = "SampleTestBy";
	public static String PROP_CROSS_MATCH_BY = "CrossMatchBy";
	public static String PROP_SAMPLE_TEST_NO = "SampleTestNo";
	public static String PROP_SAMPLE_TEST_TIME = "SampleTestTime";
	public static String PROP_MAJOR_RS_DC = "MajorRsDc";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_SAMPLE_COLLECTION = "SampleCollection";
	public static String PROP_SAMPLE_TEST_DATE = "SampleTestDate";
	public static String PROP_COMPATIBILITY = "Compatibility";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_ID = "Id";

	// constructors
	public BaseBloodSampleScreeningHeader() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBloodSampleScreeningHeader(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String sampleTestNo;
	private java.util.Date sampleTestDate;
	private java.lang.String sampleTestTime;
	private java.lang.String fitBloodIssue;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String bloodIssue;
	private java.lang.String compatibility;
	private java.lang.String majorRsDc;
	private java.lang.String minorRsDc;

	// many to one
	private jkt.hms.masters.business.MasEmployee crossMatchBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.BloodSampleCollection sampleCollection;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.MasEmployee sampleTestBy;

	// collections
	private java.util.Set<jkt.hms.masters.business.BloodSampleScreeningDetail> bloodSampleScreeningDetails;
	private java.util.Set<jkt.hms.masters.business.BloodIssueHeader> bloodIssueHeaders;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="screening_test_id"
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
	 * Return the value associated with the column: sample_test_no
	 */
	public java.lang.String getSampleTestNo() {
		return sampleTestNo;
	}

	/**
	 * Set the value related to the column: sample_test_no
	 * 
	 * @param sampleTestNo
	 *            the sample_test_no value
	 */
	public void setSampleTestNo(java.lang.String sampleTestNo) {
		this.sampleTestNo = sampleTestNo;
	}

	/**
	 * Return the value associated with the column: sample_test_date
	 */
	public java.util.Date getSampleTestDate() {
		return sampleTestDate;
	}

	/**
	 * Set the value related to the column: sample_test_date
	 * 
	 * @param sampleTestDate
	 *            the sample_test_date value
	 */
	public void setSampleTestDate(java.util.Date sampleTestDate) {
		this.sampleTestDate = sampleTestDate;
	}

	/**
	 * Return the value associated with the column: sample_test_time
	 */
	public java.lang.String getSampleTestTime() {
		return sampleTestTime;
	}

	/**
	 * Set the value related to the column: sample_test_time
	 * 
	 * @param sampleTestTime
	 *            the sample_test_time value
	 */
	public void setSampleTestTime(java.lang.String sampleTestTime) {
		this.sampleTestTime = sampleTestTime;
	}

	/**
	 * Return the value associated with the column: fit_blood_issue
	 */
	public java.lang.String getFitBloodIssue() {
		return fitBloodIssue;
	}

	/**
	 * Set the value related to the column: fit_blood_issue
	 * 
	 * @param fitBloodIssue
	 *            the fit_blood_issue value
	 */
	public void setFitBloodIssue(java.lang.String fitBloodIssue) {
		this.fitBloodIssue = fitBloodIssue;
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
	 * Return the value associated with the column: blood_issue
	 */
	public java.lang.String getBloodIssue() {
		return bloodIssue;
	}

	/**
	 * Set the value related to the column: blood_issue
	 * 
	 * @param bloodIssue
	 *            the blood_issue value
	 */
	public void setBloodIssue(java.lang.String bloodIssue) {
		this.bloodIssue = bloodIssue;
	}

	/**
	 * Return the value associated with the column: compatibility
	 */
	public java.lang.String getCompatibility() {
		return compatibility;
	}

	/**
	 * Set the value related to the column: compatibility
	 * 
	 * @param compatibility
	 *            the compatibility value
	 */
	public void setCompatibility(java.lang.String compatibility) {
		this.compatibility = compatibility;
	}

	/**
	 * Return the value associated with the column: major_rs_dc
	 */
	public java.lang.String getMajorRsDc() {
		return majorRsDc;
	}

	/**
	 * Set the value related to the column: major_rs_dc
	 * 
	 * @param majorRsDc
	 *            the major_rs_dc value
	 */
	public void setMajorRsDc(java.lang.String majorRsDc) {
		this.majorRsDc = majorRsDc;
	}

	/**
	 * Return the value associated with the column: minor_rs_dc
	 */
	public java.lang.String getMinorRsDc() {
		return minorRsDc;
	}

	/**
	 * Set the value related to the column: minor_rs_dc
	 * 
	 * @param minorRsDc
	 *            the minor_rs_dc value
	 */
	public void setMinorRsDc(java.lang.String minorRsDc) {
		this.minorRsDc = minorRsDc;
	}

	/**
	 * Return the value associated with the column: cross_match_by
	 */
	public jkt.hms.masters.business.MasEmployee getCrossMatchBy() {
		return crossMatchBy;
	}

	/**
	 * Set the value related to the column: cross_match_by
	 * 
	 * @param crossMatchBy
	 *            the cross_match_by value
	 */
	public void setCrossMatchBy(
			jkt.hms.masters.business.MasEmployee crossMatchBy) {
		this.crossMatchBy = crossMatchBy;
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
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment() {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * 
	 * @param department
	 *            the department_id value
	 */
	public void setDepartment(jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
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

	/**
	 * Return the value associated with the column: sample_collection_id
	 */
	public jkt.hms.masters.business.BloodSampleCollection getSampleCollection() {
		return sampleCollection;
	}

	/**
	 * Set the value related to the column: sample_collection_id
	 * 
	 * @param sampleCollection
	 *            the sample_collection_id value
	 */
	public void setSampleCollection(
			jkt.hms.masters.business.BloodSampleCollection sampleCollection) {
		this.sampleCollection = sampleCollection;
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
	 * Return the value associated with the column: sample_test_by
	 */
	public jkt.hms.masters.business.MasEmployee getSampleTestBy() {
		return sampleTestBy;
	}

	/**
	 * Set the value related to the column: sample_test_by
	 * 
	 * @param sampleTestBy
	 *            the sample_test_by value
	 */
	public void setSampleTestBy(
			jkt.hms.masters.business.MasEmployee sampleTestBy) {
		this.sampleTestBy = sampleTestBy;
	}

	/**
	 * Return the value associated with the column: BloodSampleScreeningDetails
	 */
	public java.util.Set<jkt.hms.masters.business.BloodSampleScreeningDetail> getBloodSampleScreeningDetails() {
		return bloodSampleScreeningDetails;
	}

	/**
	 * Set the value related to the column: BloodSampleScreeningDetails
	 * 
	 * @param bloodSampleScreeningDetails
	 *            the BloodSampleScreeningDetails value
	 */
	public void setBloodSampleScreeningDetails(
			java.util.Set<jkt.hms.masters.business.BloodSampleScreeningDetail> bloodSampleScreeningDetails) {
		this.bloodSampleScreeningDetails = bloodSampleScreeningDetails;
	}

	public void addToBloodSampleScreeningDetails(
			jkt.hms.masters.business.BloodSampleScreeningDetail bloodSampleScreeningDetail) {
		if (null == getBloodSampleScreeningDetails())
			setBloodSampleScreeningDetails(new java.util.TreeSet<jkt.hms.masters.business.BloodSampleScreeningDetail>());
		getBloodSampleScreeningDetails().add(bloodSampleScreeningDetail);
	}

	/**
	 * Return the value associated with the column: BloodIssueHeaders
	 */
	public java.util.Set<jkt.hms.masters.business.BloodIssueHeader> getBloodIssueHeaders() {
		return bloodIssueHeaders;
	}

	/**
	 * Set the value related to the column: BloodIssueHeaders
	 * 
	 * @param bloodIssueHeaders
	 *            the BloodIssueHeaders value
	 */
	public void setBloodIssueHeaders(
			java.util.Set<jkt.hms.masters.business.BloodIssueHeader> bloodIssueHeaders) {
		this.bloodIssueHeaders = bloodIssueHeaders;
	}

	public void addToBloodIssueHeaders(
			jkt.hms.masters.business.BloodIssueHeader bloodIssueHeader) {
		if (null == getBloodIssueHeaders())
			setBloodIssueHeaders(new java.util.TreeSet<jkt.hms.masters.business.BloodIssueHeader>());
		getBloodIssueHeaders().add(bloodIssueHeader);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.BloodSampleScreeningHeader))
			return false;
		else {
			jkt.hms.masters.business.BloodSampleScreeningHeader bloodSampleScreeningHeader = (jkt.hms.masters.business.BloodSampleScreeningHeader) obj;
			if (null == this.getId()
					|| null == bloodSampleScreeningHeader.getId())
				return false;
			else
				return (this.getId().equals(bloodSampleScreeningHeader.getId()));
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
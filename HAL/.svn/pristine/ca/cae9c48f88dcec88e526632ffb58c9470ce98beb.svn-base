package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * blood_donor_sample_screening_header table. Do not modify this class because
 * it will be overwritten if the configuration file related to this class is
 * modified.
 * 
 * @hibernate.class table="blood_donor_sample_screening_header"
 */

public abstract class BaseBloodDonorSampleScreeningHeader implements
		Serializable {

	public static String REF = "BloodDonorSampleScreeningHeader";
	public static String PROP_SAMPLE_TEST_NO = "SampleTestNo";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_DONATION_DETAIL = "DonationDetail";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_BLOOD_ISSUE = "BloodIssue";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_SAMPLE_TEST_DATE = "SampleTestDate";
	public static String PROP_HIN = "Hin";
	public static String PROP_SAMPLE_TEST_BY = "SampleTestBy";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_ID = "Id";

	// constructors
	public BaseBloodDonorSampleScreeningHeader() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBloodDonorSampleScreeningHeader(java.lang.Integer id) {
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
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String bloodIssue;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.BloodDonationEntryDetail donationDetail;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.MasEmployee sampleTestBy;

	// collections
	private java.util.Set<jkt.hms.masters.business.BloodDonorSampleScreeningDetail> bloodDonorSampleScreeningDetails;

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
	 * Return the value associated with the column: donation_detail_id
	 */
	public jkt.hms.masters.business.BloodDonationEntryDetail getDonationDetail() {
		return donationDetail;
	}

	/**
	 * Set the value related to the column: donation_detail_id
	 * 
	 * @param donationDetail
	 *            the donation_detail_id value
	 */
	public void setDonationDetail(
			jkt.hms.masters.business.BloodDonationEntryDetail donationDetail) {
		this.donationDetail = donationDetail;
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
	 * Return the value associated with the column:
	 * BloodDonorSampleScreeningDetails
	 */
	public java.util.Set<jkt.hms.masters.business.BloodDonorSampleScreeningDetail> getBloodDonorSampleScreeningDetails() {
		return bloodDonorSampleScreeningDetails;
	}

	/**
	 * Set the value related to the column: BloodDonorSampleScreeningDetails
	 * 
	 * @param bloodDonorSampleScreeningDetails
	 *            the BloodDonorSampleScreeningDetails value
	 */
	public void setBloodDonorSampleScreeningDetails(
			java.util.Set<jkt.hms.masters.business.BloodDonorSampleScreeningDetail> bloodDonorSampleScreeningDetails) {
		this.bloodDonorSampleScreeningDetails = bloodDonorSampleScreeningDetails;
	}

	public void addToBloodDonorSampleScreeningDetails(
			jkt.hms.masters.business.BloodDonorSampleScreeningDetail bloodDonorSampleScreeningDetail) {
		if (null == getBloodDonorSampleScreeningDetails())
			setBloodDonorSampleScreeningDetails(new java.util.TreeSet<jkt.hms.masters.business.BloodDonorSampleScreeningDetail>());
		getBloodDonorSampleScreeningDetails().add(
				bloodDonorSampleScreeningDetail);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.BloodDonorSampleScreeningHeader))
			return false;
		else {
			jkt.hms.masters.business.BloodDonorSampleScreeningHeader bloodDonorSampleScreeningHeader = (jkt.hms.masters.business.BloodDonorSampleScreeningHeader) obj;
			if (null == this.getId()
					|| null == bloodDonorSampleScreeningHeader.getId())
				return false;
			else
				return (this.getId().equals(bloodDonorSampleScreeningHeader
						.getId()));
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
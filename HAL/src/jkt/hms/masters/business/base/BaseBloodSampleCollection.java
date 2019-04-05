package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the blood_sample_collection
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="blood_sample_collection"
 */

public abstract class BaseBloodSampleCollection implements Serializable {

	public static String REF = "BloodSampleCollection";
	public static String PROP_SAMPLE_COLLECTION_TIME = "SampleCollectionTime";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_SAMPLE_STATUS = "SampleStatus";
	public static String PROP_VALIDATED_BY = "ValidatedBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_HIN = "Hin";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_SAMPLE_VALIDATION_DATE = "SampleValidationDate";
	public static String PROP_COLLECTED_BY = "CollectedBy";
	public static String PROP_SAMPLE_COLLECTION_NO = "SampleCollectionNo";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_SAMPLE_COLLECTION_DATE = "SampleCollectionDate";
	public static String PROP_SAMPLE_VALIDATION_TIME = "SampleValidationTime";
	public static String PROP_ID = "Id";
	public static String PROP_ACCEPTED_REJECTED = "AcceptedRejected";
	public static String PROP_REQUEST = "Request";

	// constructors
	public BaseBloodSampleCollection() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBloodSampleCollection(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String sampleCollectionNo;
	private java.util.Date sampleCollectionDate;
	private java.lang.String sampleCollectionTime;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String sampleStatus;
	private java.lang.String remarks;
	private java.util.Date sampleValidationDate;
	private java.lang.String sampleValidationTime;
	private java.lang.String acceptedRejected;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasEmployee validatedBy;
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.BloodRequestEntryHeader request;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.MasEmployee collectedBy;

	// collections
	private java.util.Set<jkt.hms.masters.business.BloodSampleScreeningHeader> bloodSampleScreeningHeaders;

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
	 * Return the value associated with the column: sample_collection_no
	 */
	public java.lang.String getSampleCollectionNo() {
		return sampleCollectionNo;
	}

	/**
	 * Set the value related to the column: sample_collection_no
	 * 
	 * @param sampleCollectionNo
	 *            the sample_collection_no value
	 */
	public void setSampleCollectionNo(java.lang.String sampleCollectionNo) {
		this.sampleCollectionNo = sampleCollectionNo;
	}

	/**
	 * Return the value associated with the column: sample_collection_date
	 */
	public java.util.Date getSampleCollectionDate() {
		return sampleCollectionDate;
	}

	/**
	 * Set the value related to the column: sample_collection_date
	 * 
	 * @param sampleCollectionDate
	 *            the sample_collection_date value
	 */
	public void setSampleCollectionDate(java.util.Date sampleCollectionDate) {
		this.sampleCollectionDate = sampleCollectionDate;
	}

	/**
	 * Return the value associated with the column: sample_collection_time
	 */
	public java.lang.String getSampleCollectionTime() {
		return sampleCollectionTime;
	}

	/**
	 * Set the value related to the column: sample_collection_time
	 * 
	 * @param sampleCollectionTime
	 *            the sample_collection_time value
	 */
	public void setSampleCollectionTime(java.lang.String sampleCollectionTime) {
		this.sampleCollectionTime = sampleCollectionTime;
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
	 * Return the value associated with the column: sample_status
	 */
	public java.lang.String getSampleStatus() {
		return sampleStatus;
	}

	/**
	 * Set the value related to the column: sample_status
	 * 
	 * @param sampleStatus
	 *            the sample_status value
	 */
	public void setSampleStatus(java.lang.String sampleStatus) {
		this.sampleStatus = sampleStatus;
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
	 * Return the value associated with the column: sample_validation_date
	 */
	public java.util.Date getSampleValidationDate() {
		return sampleValidationDate;
	}

	/**
	 * Set the value related to the column: sample_validation_date
	 * 
	 * @param sampleValidationDate
	 *            the sample_validation_date value
	 */
	public void setSampleValidationDate(java.util.Date sampleValidationDate) {
		this.sampleValidationDate = sampleValidationDate;
	}

	/**
	 * Return the value associated with the column: sample_validation_time
	 */
	public java.lang.String getSampleValidationTime() {
		return sampleValidationTime;
	}

	/**
	 * Set the value related to the column: sample_validation_time
	 * 
	 * @param sampleValidationTime
	 *            the sample_validation_time value
	 */
	public void setSampleValidationTime(java.lang.String sampleValidationTime) {
		this.sampleValidationTime = sampleValidationTime;
	}

	/**
	 * Return the value associated with the column: accepted_rejected
	 */
	public java.lang.String getAcceptedRejected() {
		return acceptedRejected;
	}

	/**
	 * Set the value related to the column: accepted_rejected
	 * 
	 * @param acceptedRejected
	 *            the accepted_rejected value
	 */
	public void setAcceptedRejected(java.lang.String acceptedRejected) {
		this.acceptedRejected = acceptedRejected;
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
	 * Return the value associated with the column: validated_by
	 */
	public jkt.hms.masters.business.MasEmployee getValidatedBy() {
		return validatedBy;
	}

	/**
	 * Set the value related to the column: validated_by
	 * 
	 * @param validatedBy
	 *            the validated_by value
	 */
	public void setValidatedBy(jkt.hms.masters.business.MasEmployee validatedBy) {
		this.validatedBy = validatedBy;
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
	 * Return the value associated with the column: request_id
	 */
	public jkt.hms.masters.business.BloodRequestEntryHeader getRequest() {
		return request;
	}

	/**
	 * Set the value related to the column: request_id
	 * 
	 * @param request
	 *            the request_id value
	 */
	public void setRequest(
			jkt.hms.masters.business.BloodRequestEntryHeader request) {
		this.request = request;
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
	 * Return the value associated with the column: collected_by
	 */
	public jkt.hms.masters.business.MasEmployee getCollectedBy() {
		return collectedBy;
	}

	/**
	 * Set the value related to the column: collected_by
	 * 
	 * @param collectedBy
	 *            the collected_by value
	 */
	public void setCollectedBy(jkt.hms.masters.business.MasEmployee collectedBy) {
		this.collectedBy = collectedBy;
	}

	/**
	 * Return the value associated with the column: BloodSampleScreeningHeaders
	 */
	public java.util.Set<jkt.hms.masters.business.BloodSampleScreeningHeader> getBloodSampleScreeningHeaders() {
		return bloodSampleScreeningHeaders;
	}

	/**
	 * Set the value related to the column: BloodSampleScreeningHeaders
	 * 
	 * @param bloodSampleScreeningHeaders
	 *            the BloodSampleScreeningHeaders value
	 */
	public void setBloodSampleScreeningHeaders(
			java.util.Set<jkt.hms.masters.business.BloodSampleScreeningHeader> bloodSampleScreeningHeaders) {
		this.bloodSampleScreeningHeaders = bloodSampleScreeningHeaders;
	}

	public void addToBloodSampleScreeningHeaders(
			jkt.hms.masters.business.BloodSampleScreeningHeader bloodSampleScreeningHeader) {
		if (null == getBloodSampleScreeningHeaders())
			setBloodSampleScreeningHeaders(new java.util.TreeSet<jkt.hms.masters.business.BloodSampleScreeningHeader>());
		getBloodSampleScreeningHeaders().add(bloodSampleScreeningHeader);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.BloodSampleCollection))
			return false;
		else {
			jkt.hms.masters.business.BloodSampleCollection bloodSampleCollection = (jkt.hms.masters.business.BloodSampleCollection) obj;
			if (null == this.getId() || null == bloodSampleCollection.getId())
				return false;
			else
				return (this.getId().equals(bloodSampleCollection.getId()));
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
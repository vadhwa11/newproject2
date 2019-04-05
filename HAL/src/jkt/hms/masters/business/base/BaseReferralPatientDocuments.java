package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the referral_patient_documents table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="referral_patient_documents"
 */

public abstract class BaseReferralPatientDocuments  implements Serializable {

	public static String REF = "ReferralPatientDocuments";
	public static String PROP_UPLOAD_DATE = "UploadDate";
	public static String PROP_DESCRIPTION = "Description";
	public static String PROP_REFERRAL_DETAILS = "ReferralDetails";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_FILE_EXTENSION = "FileExtension";
	public static String PROP_FILE_NAME = "FileName";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_PATIENT_DOCUMENT = "PatientDocument";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseReferralPatientDocuments () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseReferralPatientDocuments (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String fileName;
	private java.lang.String fileExtension;
	private java.lang.String description;
	private java.util.Date uploadDate;
	private java.lang.Integer lastChgBy;
	private java.lang.String lastChgTime;
	private java.util.Date lastChgDate;
	private byte[] patientDocument;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.ReferralPatientDetails referralDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="org.hibernate.id.IncrementGenerator"
     *  column="id"
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
	 * Return the value associated with the column: file_name
	 */
	public java.lang.String getFileName () {
		return fileName;
	}

	/**
	 * Set the value related to the column: file_name
	 * @param fileName the file_name value
	 */
	public void setFileName (java.lang.String fileName) {
		this.fileName = fileName;
	}



	/**
	 * Return the value associated with the column: file_extension
	 */
	public java.lang.String getFileExtension () {
		return fileExtension;
	}

	/**
	 * Set the value related to the column: file_extension
	 * @param fileExtension the file_extension value
	 */
	public void setFileExtension (java.lang.String fileExtension) {
		this.fileExtension = fileExtension;
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
	 * Return the value associated with the column: upload_date
	 */
	public java.util.Date getUploadDate () {
		return uploadDate;
	}

	/**
	 * Set the value related to the column: upload_date
	 * @param uploadDate the upload_date value
	 */
	public void setUploadDate (java.util.Date uploadDate) {
		this.uploadDate = uploadDate;
	}



	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.Integer getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (java.lang.Integer lastChgBy) {
		this.lastChgBy = lastChgBy;
	}



	/**
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime () {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * @param lastChgTime the last_chg_time value
	 */
	public void setLastChgTime (java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}



	/**
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate () {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * @param lastChgDate the last_chg_date value
	 */
	public void setLastChgDate (java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}



	/**
	 * Return the value associated with the column: patient_document
	 */
	public byte[] getPatientDocument () {
		return patientDocument;
	}

	/**
	 * Set the value related to the column: patient_document
	 * @param patientDocument the patient_document value
	 */
	public void setPatientDocument (byte[] patientDocument) {
		this.patientDocument = patientDocument;
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
	 * Return the value associated with the column: referral_details_id
	 */
	public jkt.hms.masters.business.ReferralPatientDetails getReferralDetails () {
		return referralDetails;
	}

	/**
	 * Set the value related to the column: referral_details_id
	 * @param referralDetails the referral_details_id value
	 */
	public void setReferralDetails (jkt.hms.masters.business.ReferralPatientDetails referralDetails) {
		this.referralDetails = referralDetails;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.ReferralPatientDocuments)) return false;
		else {
			jkt.hms.masters.business.ReferralPatientDocuments referralPatientDocuments = (jkt.hms.masters.business.ReferralPatientDocuments) obj;
			if (null == this.getId() || null == referralPatientDocuments.getId()) return false;
			else return (this.getId().equals(referralPatientDocuments.getId()));
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
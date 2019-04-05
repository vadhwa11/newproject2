package jkt.hms.masters.business.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasWardImpanneledHospital;
import jkt.hms.masters.business.Users;


/**
 * This is an object that contains data related to the referral_patient_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="referral_patient_details"
 */

public abstract class BaseReferralPatientDetails  implements Serializable {

	public BaseReferralPatientDetails(BaseReferralPatientDetails baseReferralPatientDetails) {
		super();
		this.referralExtensionDate = baseReferralPatientDetails.referralExtensionDate;
		this.treatmentType = baseReferralPatientDetails.treatmentType;
		this.referredFor = baseReferralPatientDetails.referredFor;
		this.noOfDays = baseReferralPatientDetails.noOfDays;
		this.referralNote = baseReferralPatientDetails.referralNote;
		this.doctorRemarks = baseReferralPatientDetails.doctorRemarks;
		this.letterValidityPeriod = baseReferralPatientDetails.letterValidityPeriod;
		this.subject = baseReferralPatientDetails.subject;
		this.lastChgDate = baseReferralPatientDetails.lastChgDate;
		this.lastChgTime = baseReferralPatientDetails.lastChgTime;
		this.referralNo = baseReferralPatientDetails.referralNo;
		this.totalBillAmt = baseReferralPatientDetails.totalBillAmt;
		this.adminBillAmt = baseReferralPatientDetails.adminBillAmt;
		this.lastChgBy = baseReferralPatientDetails.lastChgBy;
		this.doctor = baseReferralPatientDetails.doctor;
		this.ward = baseReferralPatientDetails.ward;
	}



	public static String REF = "ReferralPatientDetails";
	public static String PROP_REFERRAL_NOTE = "ReferralNote";
	public static String PROP_REFERRAL_NO = "ReferralNo";
	public static String PROP_SUBJECT = "Subject";
	public static String PROP_WARD = "Ward";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_REFERRAL_PATIENT_HEADER = "ReferralPatientHeader";
	public static String PROP_TREATMENT_TYPE = "TreatmentType";
	public static String PROP_NO_OF_DAYS = "NoOfDays";
	public static String PROP_REFERRAL_EXTENSION_DATE = "ReferralExtensionDate";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_TOTAL_BILL_AMT = "TotalBillAmt";
	public static String PROP_REFERRED_FOR = "ReferredFor";
	public static String PROP_LETTER_VALIDITY_PERIOD = "LetterValidityPeriod";
	public static String PROP_ID = "Id";
	public static String PROP_DOCTOR_REMARKS = "DoctorRemarks";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ADMIN_BILL_AMT = "AdminBillAmt";
	public static String PROP_DOCTOR = "Doctor";


	// constructors
	public BaseReferralPatientDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseReferralPatientDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date referralExtensionDate;
	private java.lang.String treatmentType;
	private java.lang.String referredFor;
	private java.lang.Integer noOfDays;
	private java.lang.String referralNote;
	private java.lang.String doctorRemarks;
	private java.lang.Integer letterValidityPeriod;
	private java.lang.String subject;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String referralNo;
	private java.math.BigDecimal totalBillAmt;
	private java.math.BigDecimal adminBillAmt;

	// many to one
	private jkt.hms.masters.business.ReferralPatientHeader referralPatientHeader;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasEmployee doctor;
	private jkt.hms.masters.business.MasWardImpanneledHospital ward;

	// collections
	private java.util.Set<jkt.hms.masters.business.ReferralPatientDocuments> referralPatientDocuments;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="referral_patient_details_id"
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
	 * Return the value associated with the column: referral_extension_date
	 */
	public java.util.Date getReferralExtensionDate () {
		return referralExtensionDate;
	}

	/**
	 * Set the value related to the column: referral_extension_date
	 * @param referralExtensionDate the referral_extension_date value
	 */
	public void setReferralExtensionDate (java.util.Date referralExtensionDate) {
		this.referralExtensionDate = referralExtensionDate;
	}



	/**
	 * Return the value associated with the column: treatment_type
	 */
	public java.lang.String getTreatmentType () {
		return treatmentType;
	}

	/**
	 * Set the value related to the column: treatment_type
	 * @param treatmentType the treatment_type value
	 */
	public void setTreatmentType (java.lang.String treatmentType) {
		this.treatmentType = treatmentType;
	}



	/**
	 * Return the value associated with the column: referred_for
	 */
	public java.lang.String getReferredFor () {
		return referredFor;
	}

	/**
	 * Set the value related to the column: referred_for
	 * @param referredFor the referred_for value
	 */
	public void setReferredFor (java.lang.String referredFor) {
		this.referredFor = referredFor;
	}



	/**
	 * Return the value associated with the column: no_of_days
	 */
	public java.lang.Integer getNoOfDays () {
		return noOfDays;
	}

	/**
	 * Set the value related to the column: no_of_days
	 * @param noOfDays the no_of_days value
	 */
	public void setNoOfDays (java.lang.Integer noOfDays) {
		this.noOfDays = noOfDays;
	}



	/**
	 * Return the value associated with the column: referral_note
	 */
	public java.lang.String getReferralNote () {
		return referralNote;
	}

	/**
	 * Set the value related to the column: referral_note
	 * @param referralNote the referral_note value
	 */
	public void setReferralNote (java.lang.String referralNote) {
		this.referralNote = referralNote;
	}



	/**
	 * Return the value associated with the column: doctor_remarks
	 */
	public java.lang.String getDoctorRemarks () {
		return doctorRemarks;
	}

	/**
	 * Set the value related to the column: doctor_remarks
	 * @param doctorRemarks the doctor_remarks value
	 */
	public void setDoctorRemarks (java.lang.String doctorRemarks) {
		this.doctorRemarks = doctorRemarks;
	}



	/**
	 * Return the value associated with the column: letter_validity_period
	 */
	public java.lang.Integer getLetterValidityPeriod () {
		return letterValidityPeriod;
	}

	/**
	 * Set the value related to the column: letter_validity_period
	 * @param letterValidityPeriod the letter_validity_period value
	 */
	public void setLetterValidityPeriod (java.lang.Integer letterValidityPeriod) {
		this.letterValidityPeriod = letterValidityPeriod;
	}



	/**
	 * Return the value associated with the column: subject
	 */
	public java.lang.String getSubject () {
		return subject;
	}

	/**
	 * Set the value related to the column: subject
	 * @param subject the subject value
	 */
	public void setSubject (java.lang.String subject) {
		this.subject = subject;
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
	 * Return the value associated with the column: referral_no
	 */
	public java.lang.String getReferralNo () {
		return referralNo;
	}

	/**
	 * Set the value related to the column: referral_no
	 * @param referralNo the referral_no value
	 */
	public void setReferralNo (java.lang.String referralNo) {
		this.referralNo = referralNo;
	}



	/**
	 * Return the value associated with the column: total_bill_amt
	 */
	public java.math.BigDecimal getTotalBillAmt () {
		return totalBillAmt;
	}

	/**
	 * Set the value related to the column: total_bill_amt
	 * @param totalBillAmt the total_bill_amt value
	 */
	public void setTotalBillAmt (java.math.BigDecimal totalBillAmt) {
		this.totalBillAmt = totalBillAmt;
	}



	/**
	 * Return the value associated with the column: admin_bill_amt
	 */
	public java.math.BigDecimal getAdminBillAmt () {
		return adminBillAmt;
	}

	/**
	 * Set the value related to the column: admin_bill_amt
	 * @param adminBillAmt the admin_bill_amt value
	 */
	public void setAdminBillAmt (java.math.BigDecimal adminBillAmt) {
		this.adminBillAmt = adminBillAmt;
	}



	/**
	 * Return the value associated with the column: referral_patient_header_id
	 */
	public jkt.hms.masters.business.ReferralPatientHeader getReferralPatientHeader () {
		return referralPatientHeader;
	}

	/**
	 * Set the value related to the column: referral_patient_header_id
	 * @param referralPatientHeader the referral_patient_header_id value
	 */
	public void setReferralPatientHeader (jkt.hms.masters.business.ReferralPatientHeader referralPatientHeader) {
		this.referralPatientHeader = referralPatientHeader;
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
	 * Return the value associated with the column: doctor_id
	 */
	public jkt.hms.masters.business.MasEmployee getDoctor () {
		return doctor;
	}

	/**
	 * Set the value related to the column: doctor_id
	 * @param doctor the doctor_id value
	 */
	public void setDoctor (jkt.hms.masters.business.MasEmployee doctor) {
		this.doctor = doctor;
	}



	/**
	 * Return the value associated with the column: ward_id
	 */
	public jkt.hms.masters.business.MasWardImpanneledHospital getWard () {
		return ward;
	}

	/**
	 * Set the value related to the column: ward_id
	 * @param ward the ward_id value
	 */
	public void setWard (jkt.hms.masters.business.MasWardImpanneledHospital ward) {
		this.ward = ward;
	}



	/**
	 * Return the value associated with the column: ReferralPatientDocuments
	 */
	public java.util.Set<jkt.hms.masters.business.ReferralPatientDocuments> getReferralPatientDocuments () {
		return referralPatientDocuments;
	}

	/**
	 * Set the value related to the column: ReferralPatientDocuments
	 * @param referralPatientDocuments the ReferralPatientDocuments value
	 */
	public void setReferralPatientDocuments (java.util.Set<jkt.hms.masters.business.ReferralPatientDocuments> referralPatientDocuments) {
		this.referralPatientDocuments = referralPatientDocuments;
	}

	public void addToReferralPatientDocuments (jkt.hms.masters.business.ReferralPatientDocuments referralPatientDocuments) {
		if (null == getReferralPatientDocuments()) setReferralPatientDocuments(new java.util.TreeSet<jkt.hms.masters.business.ReferralPatientDocuments>());
		getReferralPatientDocuments().add(referralPatientDocuments);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.ReferralPatientDetails)) return false;
		else {
			jkt.hms.masters.business.ReferralPatientDetails referralPatientDetails = (jkt.hms.masters.business.ReferralPatientDetails) obj;
			if (null == this.getId() || null == referralPatientDetails.getId()) return false;
			else return (this.getId().equals(referralPatientDetails.getId()));
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
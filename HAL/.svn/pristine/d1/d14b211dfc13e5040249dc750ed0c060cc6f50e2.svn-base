package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mh_referral table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mh_referral"
 */

public abstract class BaseMhReferral  implements Serializable {

	public static String REF = "MhReferral";
	public static String PROP_AGE = "Age";
	public static String PROP_RANK = "Rank";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_REFERRAL_DATE = "ReferralDate";
	public static String PROP_REFER_TO = "ReferTo";
	public static String PROP_MOBILE_NO = "MobileNo";
	public static String PROP_MH_NAME = "MhName";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_DIAGNOSIS = "Diagnosis";
	public static String PROP_S_FIRST_NAME = "SFirstName";
	public static String PROP_REFERRED_BY = "ReferredBy";
	public static String PROP_S_LAST_NAME = "SLastName";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_S_MIDDLE_NAME = "SMiddleName";
	public static String PROP_SEX = "Sex";
	public static String PROP_RELATION = "Relation";
	public static String PROP_SERVICE_NO = "ServiceNo";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_PATIENT_NAME = "PatientName";
	public static String PROP_SERVICE_PERSON_NAME = "ServicePersonName";
	public static String PROP_RUN_DATE = "RunDate";
	public static String PROP_REFERRED_FOR = "ReferredFor";
	public static String PROP_BLOOD_GROUP = "BloodGroup";
	public static String PROP_DISPOSAL = "Disposal";
	public static String PROP_ID = "Id";
	public static String PROP_HIN = "Hin";


	// constructors
	public BaseMhReferral () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMhReferral (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date referralDate;
	private java.lang.String serviceNo;
	private java.lang.String sFirstName;
	private java.lang.String sMiddleName;
	private java.lang.String sLastName;
	private java.lang.String age;
	private java.lang.String diagnosis;
	private java.lang.String referTo;
	private java.lang.String mhName;
	private java.lang.String referredFor;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String patientName;
	private java.lang.String servicePersonName;
	private java.util.Date runDate;
	private java.lang.String mobileNo;

	// many to one
	private jkt.hms.masters.business.MasRank rank;
	private jkt.hms.masters.business.MasBloodGroup bloodGroup;
	private jkt.hms.masters.business.MasAdministrativeSex sex;
	private jkt.hms.masters.business.MasRelation relation;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDisposedTo disposal;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.MasEmployee referredBy;
	private jkt.hms.masters.business.Users lastChgBy;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="MH_REFERRAL_ID"
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
	 * Return the value associated with the column: REFERRAL_DATE
	 */
	public java.util.Date getReferralDate () {
		return referralDate;
	}

	/**
	 * Set the value related to the column: REFERRAL_DATE
	 * @param referralDate the REFERRAL_DATE value
	 */
	public void setReferralDate (java.util.Date referralDate) {
		this.referralDate = referralDate;
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
	 * Return the value associated with the column: S_FIRST_NAME
	 */
	public java.lang.String getSFirstName () {
		return sFirstName;
	}

	/**
	 * Set the value related to the column: S_FIRST_NAME
	 * @param sFirstName the S_FIRST_NAME value
	 */
	public void setSFirstName (java.lang.String sFirstName) {
		this.sFirstName = sFirstName;
	}



	/**
	 * Return the value associated with the column: S_MIDDLE_NAME
	 */
	public java.lang.String getSMiddleName () {
		return sMiddleName;
	}

	/**
	 * Set the value related to the column: S_MIDDLE_NAME
	 * @param sMiddleName the S_MIDDLE_NAME value
	 */
	public void setSMiddleName (java.lang.String sMiddleName) {
		this.sMiddleName = sMiddleName;
	}



	/**
	 * Return the value associated with the column: S_LAST_NAME
	 */
	public java.lang.String getSLastName () {
		return sLastName;
	}

	/**
	 * Set the value related to the column: S_LAST_NAME
	 * @param sLastName the S_LAST_NAME value
	 */
	public void setSLastName (java.lang.String sLastName) {
		this.sLastName = sLastName;
	}



	/**
	 * Return the value associated with the column: AGE
	 */
	public java.lang.String getAge () {
		return age;
	}

	/**
	 * Set the value related to the column: AGE
	 * @param age the AGE value
	 */
	public void setAge (java.lang.String age) {
		this.age = age;
	}



	/**
	 * Return the value associated with the column: DIAGNOSIS
	 */
	public java.lang.String getDiagnosis () {
		return diagnosis;
	}

	/**
	 * Set the value related to the column: DIAGNOSIS
	 * @param diagnosis the DIAGNOSIS value
	 */
	public void setDiagnosis (java.lang.String diagnosis) {
		this.diagnosis = diagnosis;
	}



	/**
	 * Return the value associated with the column: REFER_TO
	 */
	public java.lang.String getReferTo () {
		return referTo;
	}

	/**
	 * Set the value related to the column: REFER_TO
	 * @param referTo the REFER_TO value
	 */
	public void setReferTo (java.lang.String referTo) {
		this.referTo = referTo;
	}



	/**
	 * Return the value associated with the column: MH_NAME
	 */
	public java.lang.String getMhName () {
		return mhName;
	}

	/**
	 * Set the value related to the column: MH_NAME
	 * @param mhName the MH_NAME value
	 */
	public void setMhName (java.lang.String mhName) {
		this.mhName = mhName;
	}



	/**
	 * Return the value associated with the column: REFERRED_FOR
	 */
	public java.lang.String getReferredFor () {
		return referredFor;
	}

	/**
	 * Set the value related to the column: REFERRED_FOR
	 * @param referredFor the REFERRED_FOR value
	 */
	public void setReferredFor (java.lang.String referredFor) {
		this.referredFor = referredFor;
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
	 * Return the value associated with the column: PATIENT_NAME
	 */
	public java.lang.String getPatientName () {
		return patientName;
	}

	/**
	 * Set the value related to the column: PATIENT_NAME
	 * @param patientName the PATIENT_NAME value
	 */
	public void setPatientName (java.lang.String patientName) {
		this.patientName = patientName;
	}



	/**
	 * Return the value associated with the column: SERVICE_PERSON_NAME
	 */
	public java.lang.String getServicePersonName () {
		return servicePersonName;
	}

	/**
	 * Set the value related to the column: SERVICE_PERSON_NAME
	 * @param servicePersonName the SERVICE_PERSON_NAME value
	 */
	public void setServicePersonName (java.lang.String servicePersonName) {
		this.servicePersonName = servicePersonName;
	}



	/**
	 * Return the value associated with the column: RUN_DATE
	 */
	public java.util.Date getRunDate () {
		return runDate;
	}

	/**
	 * Set the value related to the column: RUN_DATE
	 * @param runDate the RUN_DATE value
	 */
	public void setRunDate (java.util.Date runDate) {
		this.runDate = runDate;
	}



	/**
	 * Return the value associated with the column: mobile_no
	 */
	public java.lang.String getMobileNo () {
		return mobileNo;
	}

	/**
	 * Set the value related to the column: mobile_no
	 * @param mobileNo the mobile_no value
	 */
	public void setMobileNo (java.lang.String mobileNo) {
		this.mobileNo = mobileNo;
	}



	/**
	 * Return the value associated with the column: rank_id
	 */
	public jkt.hms.masters.business.MasRank getRank () {
		return rank;
	}

	/**
	 * Set the value related to the column: rank_id
	 * @param rank the rank_id value
	 */
	public void setRank (jkt.hms.masters.business.MasRank rank) {
		this.rank = rank;
	}



	/**
	 * Return the value associated with the column: blood_group_id
	 */
	public jkt.hms.masters.business.MasBloodGroup getBloodGroup () {
		return bloodGroup;
	}

	/**
	 * Set the value related to the column: blood_group_id
	 * @param bloodGroup the blood_group_id value
	 */
	public void setBloodGroup (jkt.hms.masters.business.MasBloodGroup bloodGroup) {
		this.bloodGroup = bloodGroup;
	}



	/**
	 * Return the value associated with the column: sex_id
	 */
	public jkt.hms.masters.business.MasAdministrativeSex getSex () {
		return sex;
	}

	/**
	 * Set the value related to the column: sex_id
	 * @param sex the sex_id value
	 */
	public void setSex (jkt.hms.masters.business.MasAdministrativeSex sex) {
		this.sex = sex;
	}



	/**
	 * Return the value associated with the column: relation_id
	 */
	public jkt.hms.masters.business.MasRelation getRelation () {
		return relation;
	}

	/**
	 * Set the value related to the column: relation_id
	 * @param relation the relation_id value
	 */
	public void setRelation (jkt.hms.masters.business.MasRelation relation) {
		this.relation = relation;
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
	 * Return the value associated with the column: disposal_id
	 */
	public jkt.hms.masters.business.MasDisposedTo getDisposal () {
		return disposal;
	}

	/**
	 * Set the value related to the column: disposal_id
	 * @param disposal the disposal_id value
	 */
	public void setDisposal (jkt.hms.masters.business.MasDisposedTo disposal) {
		this.disposal = disposal;
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
	 * Return the value associated with the column: referred_by_id
	 */
	public jkt.hms.masters.business.MasEmployee getReferredBy () {
		return referredBy;
	}

	/**
	 * Set the value related to the column: referred_by_id
	 * @param referredBy the referred_by_id value
	 */
	public void setReferredBy (jkt.hms.masters.business.MasEmployee referredBy) {
		this.referredBy = referredBy;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MhReferral)) return false;
		else {
			jkt.hms.masters.business.MhReferral mhReferral = (jkt.hms.masters.business.MhReferral) obj;
			if (null == this.getId() || null == mhReferral.getId()) return false;
			else return (this.getId().equals(mhReferral.getId()));
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
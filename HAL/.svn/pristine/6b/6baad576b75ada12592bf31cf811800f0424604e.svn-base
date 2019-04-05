package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the MIS_LMC_PSYCHIATRIC table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="MIS_LMC_PSYCHIATRIC"
 */

public abstract class BaseMisLmcPsychiatric  implements Serializable {

	public static String REF = "MisLmcPsychiatric";
	public static String PROP_RANK = "Rank";
	public static String PROP_TRADE = "Trade";
	public static String PROP_WARNING_LETTER = "WarningLetter";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_UNIT = "Unit";
	public static String PROP_DIAGNOSIS = "Diagnosis";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_S_FIRST_NAME = "SFirstName";
	public static String PROP_NEXT_MB_DATE = "NextMbDate";
	public static String PROP_S_LAST_NAME = "SLastName";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_CATEGORY_NAME = "CategoryName";
	public static String PROP_SERVICE_NO = "ServiceNo";
	public static String PROP_MEDICAL_CATEGORY = "MedicalCategory";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_DATE_OF_POSTING_IN = "DateOfPostingIn";
	public static String PROP_RETENTION_SERVICE = "RetentionService";
	public static String PROP_STATUS = "Status";
	public static String PROP_COUNSELING_DATE = "CounselingDate";
	public static String PROP_ENTRY_FLAG = "EntryFlag";
	public static String PROP_LAST_MB_DATE = "LastMbDate";
	public static String PROP_PATIENT = "Patient";
	public static String PROP_ID = "Id";
	public static String PROP_DIAGNOSIS_DATE = "DiagnosisDate";


	// constructors
	public BaseMisLmcPsychiatric () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMisLmcPsychiatric (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String serviceNo;
	private java.lang.String status;
	private java.util.Date lastMbDate;
	private java.util.Date nextMbDate;
	private java.util.Date dateOfPostingIn;
	private java.lang.String diagnosis;
	private java.lang.String retentionService;
	private java.lang.String warningLetter;
	private java.lang.String categoryName;
	private java.lang.String entryFlag;
	private java.util.Date counselingDate;
	private java.util.Date diagnosisDate;
	private java.lang.String remarks;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String sFirstName;
	private java.lang.String sLastName;

	// many to one
	private jkt.hms.masters.business.Patient patient;
	private jkt.hms.masters.business.MasMedicalCategory medicalCategory;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasUnit unit;
	private jkt.hms.masters.business.MasRank rank;
	private jkt.hms.masters.business.MasTrade trade;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="LMC_ID"
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
	 * Return the value associated with the column: LAST_MB_DATE
	 */
	public java.util.Date getLastMbDate () {
		return lastMbDate;
	}

	/**
	 * Set the value related to the column: LAST_MB_DATE
	 * @param lastMbDate the LAST_MB_DATE value
	 */
	public void setLastMbDate (java.util.Date lastMbDate) {
		this.lastMbDate = lastMbDate;
	}



	/**
	 * Return the value associated with the column: NEXT_MB_DATE
	 */
	public java.util.Date getNextMbDate () {
		return nextMbDate;
	}

	/**
	 * Set the value related to the column: NEXT_MB_DATE
	 * @param nextMbDate the NEXT_MB_DATE value
	 */
	public void setNextMbDate (java.util.Date nextMbDate) {
		this.nextMbDate = nextMbDate;
	}



	/**
	 * Return the value associated with the column: DATE_OF_POSTING_IN
	 */
	public java.util.Date getDateOfPostingIn () {
		return dateOfPostingIn;
	}

	/**
	 * Set the value related to the column: DATE_OF_POSTING_IN
	 * @param dateOfPostingIn the DATE_OF_POSTING_IN value
	 */
	public void setDateOfPostingIn (java.util.Date dateOfPostingIn) {
		this.dateOfPostingIn = dateOfPostingIn;
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
	 * Return the value associated with the column: RETENTION_SERVICE
	 */
	public java.lang.String getRetentionService () {
		return retentionService;
	}

	/**
	 * Set the value related to the column: RETENTION_SERVICE
	 * @param retentionService the RETENTION_SERVICE value
	 */
	public void setRetentionService (java.lang.String retentionService) {
		this.retentionService = retentionService;
	}



	/**
	 * Return the value associated with the column: WARNING_LETTER
	 */
	public java.lang.String getWarningLetter () {
		return warningLetter;
	}

	/**
	 * Set the value related to the column: WARNING_LETTER
	 * @param warningLetter the WARNING_LETTER value
	 */
	public void setWarningLetter (java.lang.String warningLetter) {
		this.warningLetter = warningLetter;
	}



	/**
	 * Return the value associated with the column: CATEGORY_NAME
	 */
	public java.lang.String getCategoryName () {
		return categoryName;
	}

	/**
	 * Set the value related to the column: CATEGORY_NAME
	 * @param categoryName the CATEGORY_NAME value
	 */
	public void setCategoryName (java.lang.String categoryName) {
		this.categoryName = categoryName;
	}



	/**
	 * Return the value associated with the column: ENTRY_FLAG
	 */
	public java.lang.String getEntryFlag () {
		return entryFlag;
	}

	/**
	 * Set the value related to the column: ENTRY_FLAG
	 * @param entryFlag the ENTRY_FLAG value
	 */
	public void setEntryFlag (java.lang.String entryFlag) {
		this.entryFlag = entryFlag;
	}



	/**
	 * Return the value associated with the column: COUNSELING_DATE
	 */
	public java.util.Date getCounselingDate () {
		return counselingDate;
	}

	/**
	 * Set the value related to the column: COUNSELING_DATE
	 * @param counselingDate the COUNSELING_DATE value
	 */
	public void setCounselingDate (java.util.Date counselingDate) {
		this.counselingDate = counselingDate;
	}



	/**
	 * Return the value associated with the column: DIAGNOSIS_DATE
	 */
	public java.util.Date getDiagnosisDate () {
		return diagnosisDate;
	}

	/**
	 * Set the value related to the column: DIAGNOSIS_DATE
	 * @param diagnosisDate the DIAGNOSIS_DATE value
	 */
	public void setDiagnosisDate (java.util.Date diagnosisDate) {
		this.diagnosisDate = diagnosisDate;
	}



	/**
	 * Return the value associated with the column: REMARKS
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: REMARKS
	 * @param remarks the REMARKS value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
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
	 * Return the value associated with the column: HIN_ID
	 */
	public jkt.hms.masters.business.Patient getPatient () {
		return patient;
	}

	/**
	 * Set the value related to the column: HIN_ID
	 * @param patient the HIN_ID value
	 */
	public void setPatient (jkt.hms.masters.business.Patient patient) {
		this.patient = patient;
	}



	/**
	 * Return the value associated with the column: MEDICAL_CATEGORY_ID
	 */
	public jkt.hms.masters.business.MasMedicalCategory getMedicalCategory () {
		return medicalCategory;
	}

	/**
	 * Set the value related to the column: MEDICAL_CATEGORY_ID
	 * @param medicalCategory the MEDICAL_CATEGORY_ID value
	 */
	public void setMedicalCategory (jkt.hms.masters.business.MasMedicalCategory medicalCategory) {
		this.medicalCategory = medicalCategory;
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
	 * Return the value associated with the column: UNIT_ID
	 */
	public jkt.hms.masters.business.MasUnit getUnit () {
		return unit;
	}

	/**
	 * Set the value related to the column: UNIT_ID
	 * @param unit the UNIT_ID value
	 */
	public void setUnit (jkt.hms.masters.business.MasUnit unit) {
		this.unit = unit;
	}



	/**
	 * Return the value associated with the column: RANK_ID
	 */
	public jkt.hms.masters.business.MasRank getRank () {
		return rank;
	}

	/**
	 * Set the value related to the column: RANK_ID
	 * @param rank the RANK_ID value
	 */
	public void setRank (jkt.hms.masters.business.MasRank rank) {
		this.rank = rank;
	}



	/**
	 * Return the value associated with the column: TRADE_ID
	 */
	public jkt.hms.masters.business.MasTrade getTrade () {
		return trade;
	}

	/**
	 * Set the value related to the column: TRADE_ID
	 * @param trade the TRADE_ID value
	 */
	public void setTrade (jkt.hms.masters.business.MasTrade trade) {
		this.trade = trade;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MisLmcPsychiatric)) return false;
		else {
			jkt.hms.masters.business.MisLmcPsychiatric misLmcPsychiatric = (jkt.hms.masters.business.MisLmcPsychiatric) obj;
			if (null == this.getId() || null == misLmcPsychiatric.getId()) return false;
			else return (this.getId().equals(misLmcPsychiatric.getId()));
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
package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the FATAL_DOCUMENT_HEADER table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="FATAL_DOCUMENT_HEADER"
 */

public abstract class BaseFatalDocumentHeader  implements Serializable {

	public static String REF = "FatalDocumentHeader";
	public static String PROP_PREV_MED_HISTORY = "PrevMedHistory";
	public static String PROP_S_PERSON_NAME = "SPersonName";
	public static String PROP_AGE = "Age";
	public static String PROP_AD_NO = "AdNo";
	public static String PROP_MLC_NO = "MlcNo";
	public static String PROP_TIME_OF_ADMISSION = "TimeOfAdmission";
	public static String PROP_DATE_OF_DEATH = "DateOfDeath";
	public static String PROP_MEDICAL_CATEGORY_ID = "MedicalCategoryId";
	public static String PROP_OTHER_CONDITION = "OtherCondition";
	public static String PROP_RANK_ID = "RankId";
	public static String PROP_TRADE_ID = "TradeId";
	public static String PROP_DIAGNOSIS = "Diagnosis";
	public static String PROP_DATE_OF_ADMISSION = "DateOfAdmission";
	public static String PROP_DATE_OF_COMM = "DateOfComm";
	public static String PROP_DUE_CONSEQUENCE = "DueConsequence";
	public static String PROP_UNIT_ID = "UnitId";
	public static String PROP_HIN_ID = "HinId";
	public static String PROP_TYPE_OD_DEATH = "TypeOdDeath";
	public static String PROP_SERVICE_NO = "ServiceNo";
	public static String PROP_SEX_ID = "SexId";
	public static String PROP_TIME_OF_DEATH = "TimeOfDeath";
	public static String PROP_CONDITION_TO_DEATH = "ConditionToDeath";
	public static String PROP_DATE_OF_BIRTH = "DateOfBirth";
	public static String PROP_STATUS = "Status";
	public static String PROP_HOSPITAL_NAME = "HospitalName";
	public static String PROP_LOCATION_OF_DEATH = "LocationOfDeath";
	public static String PROP_ID = "Id";
	public static String PROP_TOTAL_SERVICE = "TotalService";


	// constructors
	public BaseFatalDocumentHeader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFatalDocumentHeader (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String serviceNo;
	private java.lang.String adNo;
	private java.lang.String sPersonName;
	private java.util.Date dateOfBirth;
	private java.lang.String age;
	private java.util.Date dateOfComm;
	private java.lang.String totalService;
	private java.lang.String prevMedHistory;
	private java.lang.String diagnosis;
	private java.lang.String hospitalName;
	private java.util.Date dateOfAdmission;
	private java.lang.String timeOfAdmission;
	private java.lang.String typeOdDeath;
	private java.util.Date dateOfDeath;
	private java.lang.String timeOfDeath;
	private java.lang.String locationOfDeath;
	private java.lang.String status;
	private java.lang.String conditionToDeath;
	private java.lang.String dueConsequence;
	private java.lang.String otherCondition;
	private java.lang.String mlcNo;

	// many to one
	private jkt.hms.masters.business.Patient hinId;
	private jkt.hms.masters.business.MasRank rankId;
	private jkt.hms.masters.business.MasUnit unitId;
	private jkt.hms.masters.business.MasTrade tradeId;
	private jkt.hms.masters.business.MasAdministrativeSex sexId;
	private jkt.hms.masters.business.MasMedicalCategory medicalCategoryId;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="ID"
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
	 * Return the value associated with the column: service_no
	 */
	public java.lang.String getServiceNo () {
		return serviceNo;
	}

	/**
	 * Set the value related to the column: service_no
	 * @param serviceNo the service_no value
	 */
	public void setServiceNo (java.lang.String serviceNo) {
		this.serviceNo = serviceNo;
	}



	/**
	 * Return the value associated with the column: AD_NO
	 */
	public java.lang.String getAdNo () {
		return adNo;
	}

	/**
	 * Set the value related to the column: AD_NO
	 * @param adNo the AD_NO value
	 */
	public void setAdNo (java.lang.String adNo) {
		this.adNo = adNo;
	}



	/**
	 * Return the value associated with the column: S_PERSON_NAME
	 */
	public java.lang.String getSPersonName () {
		return sPersonName;
	}

	/**
	 * Set the value related to the column: S_PERSON_NAME
	 * @param sPersonName the S_PERSON_NAME value
	 */
	public void setSPersonName (java.lang.String sPersonName) {
		this.sPersonName = sPersonName;
	}



	/**
	 * Return the value associated with the column: DATE_OF_BIRTH
	 */
	public java.util.Date getDateOfBirth () {
		return dateOfBirth;
	}

	/**
	 * Set the value related to the column: DATE_OF_BIRTH
	 * @param dateOfBirth the DATE_OF_BIRTH value
	 */
	public void setDateOfBirth (java.util.Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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
	 * Return the value associated with the column: DATE_OF_COMM
	 */
	public java.util.Date getDateOfComm () {
		return dateOfComm;
	}

	/**
	 * Set the value related to the column: DATE_OF_COMM
	 * @param dateOfComm the DATE_OF_COMM value
	 */
	public void setDateOfComm (java.util.Date dateOfComm) {
		this.dateOfComm = dateOfComm;
	}



	/**
	 * Return the value associated with the column: TOTAL_SERVICE
	 */
	public java.lang.String getTotalService () {
		return totalService;
	}

	/**
	 * Set the value related to the column: TOTAL_SERVICE
	 * @param totalService the TOTAL_SERVICE value
	 */
	public void setTotalService (java.lang.String totalService) {
		this.totalService = totalService;
	}



	/**
	 * Return the value associated with the column: PREV_MED_HISTORY
	 */
	public java.lang.String getPrevMedHistory () {
		return prevMedHistory;
	}

	/**
	 * Set the value related to the column: PREV_MED_HISTORY
	 * @param prevMedHistory the PREV_MED_HISTORY value
	 */
	public void setPrevMedHistory (java.lang.String prevMedHistory) {
		this.prevMedHistory = prevMedHistory;
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
	 * Return the value associated with the column: HOSPITAL_NAME
	 */
	public java.lang.String getHospitalName () {
		return hospitalName;
	}

	/**
	 * Set the value related to the column: HOSPITAL_NAME
	 * @param hospitalName the HOSPITAL_NAME value
	 */
	public void setHospitalName (java.lang.String hospitalName) {
		this.hospitalName = hospitalName;
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
	 * Return the value associated with the column: TIME_OF_ADMISSION
	 */
	public java.lang.String getTimeOfAdmission () {
		return timeOfAdmission;
	}

	/**
	 * Set the value related to the column: TIME_OF_ADMISSION
	 * @param timeOfAdmission the TIME_OF_ADMISSION value
	 */
	public void setTimeOfAdmission (java.lang.String timeOfAdmission) {
		this.timeOfAdmission = timeOfAdmission;
	}



	/**
	 * Return the value associated with the column: TYPE_OD_DEATH
	 */
	public java.lang.String getTypeOdDeath () {
		return typeOdDeath;
	}

	/**
	 * Set the value related to the column: TYPE_OD_DEATH
	 * @param typeOdDeath the TYPE_OD_DEATH value
	 */
	public void setTypeOdDeath (java.lang.String typeOdDeath) {
		this.typeOdDeath = typeOdDeath;
	}



	/**
	 * Return the value associated with the column: DATE_OF_DEATH
	 */
	public java.util.Date getDateOfDeath () {
		return dateOfDeath;
	}

	/**
	 * Set the value related to the column: DATE_OF_DEATH
	 * @param dateOfDeath the DATE_OF_DEATH value
	 */
	public void setDateOfDeath (java.util.Date dateOfDeath) {
		this.dateOfDeath = dateOfDeath;
	}



	/**
	 * Return the value associated with the column: TIME_OF_DEATH
	 */
	public java.lang.String getTimeOfDeath () {
		return timeOfDeath;
	}

	/**
	 * Set the value related to the column: TIME_OF_DEATH
	 * @param timeOfDeath the TIME_OF_DEATH value
	 */
	public void setTimeOfDeath (java.lang.String timeOfDeath) {
		this.timeOfDeath = timeOfDeath;
	}



	/**
	 * Return the value associated with the column: LOCATION_OF_DEATH
	 */
	public java.lang.String getLocationOfDeath () {
		return locationOfDeath;
	}

	/**
	 * Set the value related to the column: LOCATION_OF_DEATH
	 * @param locationOfDeath the LOCATION_OF_DEATH value
	 */
	public void setLocationOfDeath (java.lang.String locationOfDeath) {
		this.locationOfDeath = locationOfDeath;
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
	 * Return the value associated with the column: condition_to_death
	 */
	public java.lang.String getConditionToDeath () {
		return conditionToDeath;
	}

	/**
	 * Set the value related to the column: condition_to_death
	 * @param conditionToDeath the condition_to_death value
	 */
	public void setConditionToDeath (java.lang.String conditionToDeath) {
		this.conditionToDeath = conditionToDeath;
	}



	/**
	 * Return the value associated with the column: due_consequence
	 */
	public java.lang.String getDueConsequence () {
		return dueConsequence;
	}

	/**
	 * Set the value related to the column: due_consequence
	 * @param dueConsequence the due_consequence value
	 */
	public void setDueConsequence (java.lang.String dueConsequence) {
		this.dueConsequence = dueConsequence;
	}



	/**
	 * Return the value associated with the column: other_condition
	 */
	public java.lang.String getOtherCondition () {
		return otherCondition;
	}

	/**
	 * Set the value related to the column: other_condition
	 * @param otherCondition the other_condition value
	 */
	public void setOtherCondition (java.lang.String otherCondition) {
		this.otherCondition = otherCondition;
	}



	/**
	 * Return the value associated with the column: MLC_NO
	 */
	public java.lang.String getMlcNo () {
		return mlcNo;
	}

	/**
	 * Set the value related to the column: MLC_NO
	 * @param mlcNo the MLC_NO value
	 */
	public void setMlcNo (java.lang.String mlcNo) {
		this.mlcNo = mlcNo;
	}



	/**
	 * Return the value associated with the column: HIN_ID
	 */
	public jkt.hms.masters.business.Patient getHinId () {
		return hinId;
	}

	/**
	 * Set the value related to the column: HIN_ID
	 * @param hinId the HIN_ID value
	 */
	public void setHinId (jkt.hms.masters.business.Patient hinId) {
		this.hinId = hinId;
	}



	/**
	 * Return the value associated with the column: RANK_ID
	 */
	public jkt.hms.masters.business.MasRank getRankId () {
		return rankId;
	}

	/**
	 * Set the value related to the column: RANK_ID
	 * @param rankId the RANK_ID value
	 */
	public void setRankId (jkt.hms.masters.business.MasRank rankId) {
		this.rankId = rankId;
	}



	/**
	 * Return the value associated with the column: UNIT_ID
	 */
	public jkt.hms.masters.business.MasUnit getUnitId () {
		return unitId;
	}

	/**
	 * Set the value related to the column: UNIT_ID
	 * @param unitId the UNIT_ID value
	 */
	public void setUnitId (jkt.hms.masters.business.MasUnit unitId) {
		this.unitId = unitId;
	}



	/**
	 * Return the value associated with the column: TRADE_ID
	 */
	public jkt.hms.masters.business.MasTrade getTradeId () {
		return tradeId;
	}

	/**
	 * Set the value related to the column: TRADE_ID
	 * @param tradeId the TRADE_ID value
	 */
	public void setTradeId (jkt.hms.masters.business.MasTrade tradeId) {
		this.tradeId = tradeId;
	}



	/**
	 * Return the value associated with the column: SEX_ID
	 */
	public jkt.hms.masters.business.MasAdministrativeSex getSexId () {
		return sexId;
	}

	/**
	 * Set the value related to the column: SEX_ID
	 * @param sexId the SEX_ID value
	 */
	public void setSexId (jkt.hms.masters.business.MasAdministrativeSex sexId) {
		this.sexId = sexId;
	}



	/**
	 * Return the value associated with the column: MEDICAL_CATEGORY_ID
	 */
	public jkt.hms.masters.business.MasMedicalCategory getMedicalCategoryId () {
		return medicalCategoryId;
	}

	/**
	 * Set the value related to the column: MEDICAL_CATEGORY_ID
	 * @param medicalCategoryId the MEDICAL_CATEGORY_ID value
	 */
	public void setMedicalCategoryId (jkt.hms.masters.business.MasMedicalCategory medicalCategoryId) {
		this.medicalCategoryId = medicalCategoryId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.FatalDocumentHeader)) return false;
		else {
			jkt.hms.masters.business.FatalDocumentHeader fatalDocumentHeader = (jkt.hms.masters.business.FatalDocumentHeader) obj;
			if (null == this.getId() || null == fatalDocumentHeader.getId()) return false;
			else return (this.getId().equals(fatalDocumentHeader.getId()));
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
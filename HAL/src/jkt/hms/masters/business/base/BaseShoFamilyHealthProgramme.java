package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SHO_FAMILY_HEALTH_PROGRAMME table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="SHO_FAMILY_HEALTH_PROGRAMME"
 */

public abstract class BaseShoFamilyHealthProgramme  implements Serializable {

	public static String REF = "ShoFamilyHealthProgramme";
	public static String PROP_HEALTH_DATE = "HealthDate";
	public static String PROP_BLOOD_LAPID = "BloodLapid";
	public static String PROP_DENTAL_CARIES = "DentalCaries";
	public static String PROP_OVER_WEIGHT = "OverWeight";
	public static String PROP_OBESE = "Obese";
	public static String PROP_UNIT = "Unit";
	public static String PROP_HEALTH_ID = "HealthId";
	public static String PROP_BLOOD_SUGAR = "BloodSugar";
	public static String PROP_YEAR = "Year";
	public static String PROP_NUMBER_EXAMINED = "NumberExamined";
	public static String PROP_ECG_ABNORMALITY = "EcgAbnormality";
	public static String PROP_SPOUSE_EXAMINED_HALF_YEAR = "SpouseExaminedHalfYear";
	public static String PROP_NIDDM = "Niddm";
	public static String PROP_HALF_YEAR = "halfYear";
	public static String PROP_BLOOD_ANAEMIA = "BloodAnaemia";
	public static String PROP_BLOOD_THYROID = "BloodThyroid";
	public static String PROP_ABDOMEN_EXAM = "AbdomenExam";
	public static String PROP_BREAST_EXAM = "BreastExam";
	public static String PROP_HTN = "Htn";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_AGE_GROUP = "AgeGroup";
	public static String PROP_REFRACTORY_ERROR = "RefractoryError";
	public static String PROP_CARDIC_MURMUR = "CardicMurmur";
	public static String PROP_TOTAL_STRENGTH = "TotalStrength";
	public static String PROP_HIN = "Hin";


	// constructors
	public BaseShoFamilyHealthProgramme () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseShoFamilyHealthProgramme (java.lang.Integer healthId) {
		this.setHealthId(healthId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer healthId;

	// fields
	private java.lang.String ageGroup;
	private java.lang.String halfYear;
	private java.lang.Integer year;
	private java.lang.Integer totalStrength;
	private java.lang.Integer spouseExaminedHalfYear;
	private java.lang.Integer numberExamined;
	private java.lang.String overWeight;
	private java.lang.String obese;
	private java.lang.String abdomenExam;
	private java.lang.String breastExam;
	private java.lang.String htn;
	private java.lang.String cardicMurmur;
	private java.lang.String ecgAbnormality;
	private java.lang.String refractoryError;
	private java.lang.String bloodAnaemia;
	private java.lang.String bloodSugar;
	private java.lang.String bloodThyroid;
	private java.lang.String bloodLapid;
	private java.lang.String niddm;
	private java.lang.String dentalCaries;
	private java.util.Date healthDate;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.MasUnit unit;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="HEALTH_ID"
     */
	public java.lang.Integer getHealthId () {
		return healthId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param healthId the new ID
	 */
	public void setHealthId (java.lang.Integer healthId) {
		this.healthId = healthId;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: AGE_GROUP
	 */
	public java.lang.String getAgeGroup () {
		return ageGroup;
	}

	/**
	 * Set the value related to the column: AGE_GROUP
	 * @param ageGroup the AGE_GROUP value
	 */
	public void setAgeGroup (java.lang.String ageGroup) {
		this.ageGroup = ageGroup;
	}



	/**
	 * Return the value associated with the column: Half_Year
	 */
	public java.lang.String getHalfYear () {
		return halfYear;
	}

	/**
	 * Set the value related to the column: Half_Year
	 * @param halfYear the Half_Year value
	 */
	public void setHalfYear (java.lang.String halfYear) {
		this.halfYear = halfYear;
	}



	/**
	 * Return the value associated with the column: YEAR
	 */
	public java.lang.Integer getYear () {
		return year;
	}

	/**
	 * Set the value related to the column: YEAR
	 * @param year the YEAR value
	 */
	public void setYear (java.lang.Integer year) {
		this.year = year;
	}



	/**
	 * Return the value associated with the column: TOTAL_STRENGTH
	 */
	public java.lang.Integer getTotalStrength () {
		return totalStrength;
	}

	/**
	 * Set the value related to the column: TOTAL_STRENGTH
	 * @param totalStrength the TOTAL_STRENGTH value
	 */
	public void setTotalStrength (java.lang.Integer totalStrength) {
		this.totalStrength = totalStrength;
	}



	/**
	 * Return the value associated with the column: SPOUSE_EXAMINED_HALF_YEAR
	 */
	public java.lang.Integer getSpouseExaminedHalfYear () {
		return spouseExaminedHalfYear;
	}

	/**
	 * Set the value related to the column: SPOUSE_EXAMINED_HALF_YEAR
	 * @param spouseExaminedHalfYear the SPOUSE_EXAMINED_HALF_YEAR value
	 */
	public void setSpouseExaminedHalfYear (java.lang.Integer spouseExaminedHalfYear) {
		this.spouseExaminedHalfYear = spouseExaminedHalfYear;
	}



	/**
	 * Return the value associated with the column: NUMBER_EXAMINED
	 */
	public java.lang.Integer getNumberExamined () {
		return numberExamined;
	}

	/**
	 * Set the value related to the column: NUMBER_EXAMINED
	 * @param numberExamined the NUMBER_EXAMINED value
	 */
	public void setNumberExamined (java.lang.Integer numberExamined) {
		this.numberExamined = numberExamined;
	}



	/**
	 * Return the value associated with the column: OVER_WEIGHT
	 */
	public java.lang.String getOverWeight () {
		return overWeight;
	}

	/**
	 * Set the value related to the column: OVER_WEIGHT
	 * @param overWeight the OVER_WEIGHT value
	 */
	public void setOverWeight (java.lang.String overWeight) {
		this.overWeight = overWeight;
	}



	/**
	 * Return the value associated with the column: OBESE
	 */
	public java.lang.String getObese () {
		return obese;
	}

	/**
	 * Set the value related to the column: OBESE
	 * @param obese the OBESE value
	 */
	public void setObese (java.lang.String obese) {
		this.obese = obese;
	}



	/**
	 * Return the value associated with the column: ABDOMEN_EXAM
	 */
	public java.lang.String getAbdomenExam () {
		return abdomenExam;
	}

	/**
	 * Set the value related to the column: ABDOMEN_EXAM
	 * @param abdomenExam the ABDOMEN_EXAM value
	 */
	public void setAbdomenExam (java.lang.String abdomenExam) {
		this.abdomenExam = abdomenExam;
	}



	/**
	 * Return the value associated with the column: BREAST_EXAM
	 */
	public java.lang.String getBreastExam () {
		return breastExam;
	}

	/**
	 * Set the value related to the column: BREAST_EXAM
	 * @param breastExam the BREAST_EXAM value
	 */
	public void setBreastExam (java.lang.String breastExam) {
		this.breastExam = breastExam;
	}



	/**
	 * Return the value associated with the column: HTN
	 */
	public java.lang.String getHtn () {
		return htn;
	}

	/**
	 * Set the value related to the column: HTN
	 * @param htn the HTN value
	 */
	public void setHtn (java.lang.String htn) {
		this.htn = htn;
	}



	/**
	 * Return the value associated with the column: CARDIC_MURMUR
	 */
	public java.lang.String getCardicMurmur () {
		return cardicMurmur;
	}

	/**
	 * Set the value related to the column: CARDIC_MURMUR
	 * @param cardicMurmur the CARDIC_MURMUR value
	 */
	public void setCardicMurmur (java.lang.String cardicMurmur) {
		this.cardicMurmur = cardicMurmur;
	}



	/**
	 * Return the value associated with the column: ECG_ABNORMALITY
	 */
	public java.lang.String getEcgAbnormality () {
		return ecgAbnormality;
	}

	/**
	 * Set the value related to the column: ECG_ABNORMALITY
	 * @param ecgAbnormality the ECG_ABNORMALITY value
	 */
	public void setEcgAbnormality (java.lang.String ecgAbnormality) {
		this.ecgAbnormality = ecgAbnormality;
	}



	/**
	 * Return the value associated with the column: REFRACTORY_ERROR
	 */
	public java.lang.String getRefractoryError () {
		return refractoryError;
	}

	/**
	 * Set the value related to the column: REFRACTORY_ERROR
	 * @param refractoryError the REFRACTORY_ERROR value
	 */
	public void setRefractoryError (java.lang.String refractoryError) {
		this.refractoryError = refractoryError;
	}



	/**
	 * Return the value associated with the column: BLOOD_ANAEMIA
	 */
	public java.lang.String getBloodAnaemia () {
		return bloodAnaemia;
	}

	/**
	 * Set the value related to the column: BLOOD_ANAEMIA
	 * @param bloodAnaemia the BLOOD_ANAEMIA value
	 */
	public void setBloodAnaemia (java.lang.String bloodAnaemia) {
		this.bloodAnaemia = bloodAnaemia;
	}



	/**
	 * Return the value associated with the column: BLOOD_SUGAR
	 */
	public java.lang.String getBloodSugar () {
		return bloodSugar;
	}

	/**
	 * Set the value related to the column: BLOOD_SUGAR
	 * @param bloodSugar the BLOOD_SUGAR value
	 */
	public void setBloodSugar (java.lang.String bloodSugar) {
		this.bloodSugar = bloodSugar;
	}



	/**
	 * Return the value associated with the column: BLOOD_THYROID
	 */
	public java.lang.String getBloodThyroid () {
		return bloodThyroid;
	}

	/**
	 * Set the value related to the column: BLOOD_THYROID
	 * @param bloodThyroid the BLOOD_THYROID value
	 */
	public void setBloodThyroid (java.lang.String bloodThyroid) {
		this.bloodThyroid = bloodThyroid;
	}



	/**
	 * Return the value associated with the column: BLOOD_LAPID
	 */
	public java.lang.String getBloodLapid () {
		return bloodLapid;
	}

	/**
	 * Set the value related to the column: BLOOD_LAPID
	 * @param bloodLapid the BLOOD_LAPID value
	 */
	public void setBloodLapid (java.lang.String bloodLapid) {
		this.bloodLapid = bloodLapid;
	}



	/**
	 * Return the value associated with the column: NIDDM
	 */
	public java.lang.String getNiddm () {
		return niddm;
	}

	/**
	 * Set the value related to the column: NIDDM
	 * @param niddm the NIDDM value
	 */
	public void setNiddm (java.lang.String niddm) {
		this.niddm = niddm;
	}



	/**
	 * Return the value associated with the column: DENTAL_CARIES
	 */
	public java.lang.String getDentalCaries () {
		return dentalCaries;
	}

	/**
	 * Set the value related to the column: DENTAL_CARIES
	 * @param dentalCaries the DENTAL_CARIES value
	 */
	public void setDentalCaries (java.lang.String dentalCaries) {
		this.dentalCaries = dentalCaries;
	}



	/**
	 * Return the value associated with the column: HEALTH_DATE
	 */
	public java.util.Date getHealthDate () {
		return healthDate;
	}

	/**
	 * Set the value related to the column: HEALTH_DATE
	 * @param healthDate the HEALTH_DATE value
	 */
	public void setHealthDate (java.util.Date healthDate) {
		this.healthDate = healthDate;
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
	 * Return the value associated with the column: HIN_ID
	 */
	public jkt.hms.masters.business.Patient getHin () {
		return hin;
	}

	/**
	 * Set the value related to the column: HIN_ID
	 * @param hin the HIN_ID value
	 */
	public void setHin (jkt.hms.masters.business.Patient hin) {
		this.hin = hin;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.ShoFamilyHealthProgramme)) return false;
		else {
			jkt.hms.masters.business.ShoFamilyHealthProgramme shoFamilyHealthProgramme = (jkt.hms.masters.business.ShoFamilyHealthProgramme) obj;
			if (null == this.getHealthId() || null == shoFamilyHealthProgramme.getHealthId()) return false;
			else return (this.getHealthId().equals(shoFamilyHealthProgramme.getHealthId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getHealthId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getHealthId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}
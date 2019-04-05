package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the AV_TRAINING_STATUS_AIRCREW table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="AV_TRAINING_STATUS_AIRCREW"
 */

public abstract class BaseAvTrainingStatusAircrew  implements Serializable {

	public static String REF = "AvTrainingStatusAircrew";
	public static String PROP_CURRENT_ON_TYPE = "CurrentOnType";
	public static String PROP_AGE = "Age";
	public static String PROP_RANK = "Rank";
	public static String PROP_EXP_ON_TYPE = "ExpOnType";
	public static String PROP_TRAINING_DATE = "TrainingDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_EJECTION_TRAINER = "EjectionTrainer";
	public static String PROP_UNIT = "Unit";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_CONTENT = "Content";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_CURRENT_RATING = "CurrentRating";
	public static String PROP_SEX = "Sex";
	public static String PROP_SERVICE_NO = "ServiceNo";
	public static String PROP_FLYING_EXP = "FlyingExp";
	public static String PROP_AIRCRAFT_FLOWN = "AircraftFlown";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LOCAL_LECTURE = "LocalLecture";
	public static String PROP_DISO = "Diso";
	public static String PROP_AIRCREW_NAME = "AircrewName";
	public static String PROP_OPTRAM = "Optram";
	public static String PROP_ID = "Id";
	public static String PROP_BASIC_INTRODUCTION = "BasicIntroduction";
	public static String PROP_NVG = "Nvg";
	public static String PROP_HIN = "Hin";


	// constructors
	public BaseAvTrainingStatusAircrew () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAvTrainingStatusAircrew (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String aircrewName;
	private java.lang.String age;
	private java.lang.String aircraftFlown;
	private java.lang.String expOnType;
	private java.lang.String currentOnType;
	private java.lang.String basicIntroduction;
	private java.lang.String ejectionTrainer;
	private java.lang.String diso;
	private java.lang.String optram;
	private java.lang.String nvg;
	private java.lang.String localLecture;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String serviceNo;
	private java.lang.String content;
	private java.util.Date trainingDate;
	private java.lang.String currentRating;
	private java.lang.String flyingExp;

	// many to one
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasUnit unit;
	private jkt.hms.masters.business.MasRank rank;
	private jkt.hms.masters.business.MasAdministrativeSex sex;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="AV_TRAINING_ID"
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
	 * Return the value associated with the column: AIRCREW_NAME
	 */
	public java.lang.String getAircrewName () {
		return aircrewName;
	}

	/**
	 * Set the value related to the column: AIRCREW_NAME
	 * @param aircrewName the AIRCREW_NAME value
	 */
	public void setAircrewName (java.lang.String aircrewName) {
		this.aircrewName = aircrewName;
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
	 * Return the value associated with the column: AIRCRAFT_FLOWN
	 */
	public java.lang.String getAircraftFlown () {
		return aircraftFlown;
	}

	/**
	 * Set the value related to the column: AIRCRAFT_FLOWN
	 * @param aircraftFlown the AIRCRAFT_FLOWN value
	 */
	public void setAircraftFlown (java.lang.String aircraftFlown) {
		this.aircraftFlown = aircraftFlown;
	}



	/**
	 * Return the value associated with the column: EXP_ON_TYPE
	 */
	public java.lang.String getExpOnType () {
		return expOnType;
	}

	/**
	 * Set the value related to the column: EXP_ON_TYPE
	 * @param expOnType the EXP_ON_TYPE value
	 */
	public void setExpOnType (java.lang.String expOnType) {
		this.expOnType = expOnType;
	}



	/**
	 * Return the value associated with the column: CURRENT_ON_TYPE
	 */
	public java.lang.String getCurrentOnType () {
		return currentOnType;
	}

	/**
	 * Set the value related to the column: CURRENT_ON_TYPE
	 * @param currentOnType the CURRENT_ON_TYPE value
	 */
	public void setCurrentOnType (java.lang.String currentOnType) {
		this.currentOnType = currentOnType;
	}



	/**
	 * Return the value associated with the column: BASIC_INTRODUCTION
	 */
	public java.lang.String getBasicIntroduction () {
		return basicIntroduction;
	}

	/**
	 * Set the value related to the column: BASIC_INTRODUCTION
	 * @param basicIntroduction the BASIC_INTRODUCTION value
	 */
	public void setBasicIntroduction (java.lang.String basicIntroduction) {
		this.basicIntroduction = basicIntroduction;
	}



	/**
	 * Return the value associated with the column: EJECTION_TRAINER
	 */
	public java.lang.String getEjectionTrainer () {
		return ejectionTrainer;
	}

	/**
	 * Set the value related to the column: EJECTION_TRAINER
	 * @param ejectionTrainer the EJECTION_TRAINER value
	 */
	public void setEjectionTrainer (java.lang.String ejectionTrainer) {
		this.ejectionTrainer = ejectionTrainer;
	}



	/**
	 * Return the value associated with the column: DISO
	 */
	public java.lang.String getDiso () {
		return diso;
	}

	/**
	 * Set the value related to the column: DISO
	 * @param diso the DISO value
	 */
	public void setDiso (java.lang.String diso) {
		this.diso = diso;
	}



	/**
	 * Return the value associated with the column: OPTRAM
	 */
	public java.lang.String getOptram () {
		return optram;
	}

	/**
	 * Set the value related to the column: OPTRAM
	 * @param optram the OPTRAM value
	 */
	public void setOptram (java.lang.String optram) {
		this.optram = optram;
	}



	/**
	 * Return the value associated with the column: NVG
	 */
	public java.lang.String getNvg () {
		return nvg;
	}

	/**
	 * Set the value related to the column: NVG
	 * @param nvg the NVG value
	 */
	public void setNvg (java.lang.String nvg) {
		this.nvg = nvg;
	}



	/**
	 * Return the value associated with the column: LOCAL_LECTURE
	 */
	public java.lang.String getLocalLecture () {
		return localLecture;
	}

	/**
	 * Set the value related to the column: LOCAL_LECTURE
	 * @param localLecture the LOCAL_LECTURE value
	 */
	public void setLocalLecture (java.lang.String localLecture) {
		this.localLecture = localLecture;
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
	 * Return the value associated with the column: CONTENT
	 */
	public java.lang.String getContent () {
		return content;
	}

	/**
	 * Set the value related to the column: CONTENT
	 * @param content the CONTENT value
	 */
	public void setContent (java.lang.String content) {
		this.content = content;
	}



	/**
	 * Return the value associated with the column: TRAINING_DATE
	 */
	public java.util.Date getTrainingDate () {
		return trainingDate;
	}

	/**
	 * Set the value related to the column: TRAINING_DATE
	 * @param trainingDate the TRAINING_DATE value
	 */
	public void setTrainingDate (java.util.Date trainingDate) {
		this.trainingDate = trainingDate;
	}



	/**
	 * Return the value associated with the column: CURRENT_RATING
	 */
	public java.lang.String getCurrentRating () {
		return currentRating;
	}

	/**
	 * Set the value related to the column: CURRENT_RATING
	 * @param currentRating the CURRENT_RATING value
	 */
	public void setCurrentRating (java.lang.String currentRating) {
		this.currentRating = currentRating;
	}



	/**
	 * Return the value associated with the column: FLYING_EXP
	 */
	public java.lang.String getFlyingExp () {
		return flyingExp;
	}

	/**
	 * Set the value related to the column: FLYING_EXP
	 * @param flyingExp the FLYING_EXP value
	 */
	public void setFlyingExp (java.lang.String flyingExp) {
		this.flyingExp = flyingExp;
	}



	/**
	 * Return the value associated with the column: DEPARTMENT_ID
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment () {
		return department;
	}

	/**
	 * Set the value related to the column: DEPARTMENT_ID
	 * @param department the DEPARTMENT_ID value
	 */
	public void setDepartment (jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
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
	 * Return the value associated with the column: unit_id
	 */
	public jkt.hms.masters.business.MasUnit getUnit () {
		return unit;
	}

	/**
	 * Set the value related to the column: unit_id
	 * @param unit the unit_id value
	 */
	public void setUnit (jkt.hms.masters.business.MasUnit unit) {
		this.unit = unit;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.AvTrainingStatusAircrew)) return false;
		else {
			jkt.hms.masters.business.AvTrainingStatusAircrew avTrainingStatusAircrew = (jkt.hms.masters.business.AvTrainingStatusAircrew) obj;
			if (null == this.getId() || null == avTrainingStatusAircrew.getId()) return false;
			else return (this.getId().equals(avTrainingStatusAircrew.getId()));
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
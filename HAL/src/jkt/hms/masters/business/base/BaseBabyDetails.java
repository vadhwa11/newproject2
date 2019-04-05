package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the baby_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="baby_details"
 */

public abstract class BaseBabyDetails  implements Serializable {

	public static String REF = "BabyDetails";
	public static String PROP_BABY_HIN = "BabyHin";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LIVE_STILL_BORN = "LiveStillBorn";
	public static String PROP_BABY_NO = "BabyNo";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_BIRTH_CERTIFICATION_DATE = "BirthCertificationDate";
	public static String PROP_WEIGHT = "Weight";
	public static String PROP_GESTATION_AGE = "GestationAge";
	public static String PROP_GESTATION = "Gestation";
	public static String PROP_APGAR_SCORE = "ApgarScore";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_SEX = "Sex";
	public static String PROP_MAS_NEONATAL_PROBLEM = "MasNeonatalProblem";
	public static String PROP_DELIVERY = "Delivery";
	public static String PROP_COMPLICATIONS = "Complications";
	public static String PROP_CS_INDICATION = "CsIndication";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_TIME_OF_BIRTH = "TimeOfBirth";
	public static String PROP_OUTCOME = "Outcome";
	public static String PROP_CS_NO = "CsNo";
	public static String PROP_EST_GEST_AGE = "EstGestAge";
	public static String PROP_BIRTH_CERTIFICATION_NO = "BirthCertificationNo";
	public static String PROP_DATE_OF_BIRTH = "DateOfBirth";
	public static String PROP_DELIVERY_TYPE = "DeliveryType";
	public static String PROP_PRESENTATION = "Presentation";
	public static String PROP_APGAR_AT1 = "ApgarAt1";
	public static String PROP_LENGTH = "Length";
	public static String PROP_ANOMALIES = "Anomalies";
	public static String PROP_BABY_CRY = "BabyCry";
	public static String PROP_ID = "Id";
	public static String PROP_HEAD_CIRCUMFERANCE = "HeadCircumferance";
	public static String PROP_APGAR_AT5 = "ApgarAt5";
	public static String PROP_BABY_FEEDING = "BabyFeeding";
	public static String PROP_BABY_STATUS = "BabyStatus";


	// constructors
	public BaseBabyDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBabyDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer babyNo;
	private java.util.Date dateOfBirth;
	private java.lang.String birthCertificationNo;
	private java.lang.String timeOfBirth;
	private java.util.Date birthCertificationDate;
	private java.lang.Integer csIndication;
	private java.lang.Integer gestation;
	private java.lang.Float headCircumferance;
	private java.lang.String csNo;
	private java.lang.String gestationAge;
	private java.lang.Float length;
	private java.lang.Float apgarScore;
	private java.lang.String estGestAge;
	private java.lang.String weight;
	private java.lang.Integer masNeonatalProblem;
	private java.lang.Integer babyStatus;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String outcome;
	private java.lang.String liveStillBorn;
	private java.lang.String presentation;
	private java.lang.String babyCry;
	private java.lang.Integer apgarAt1;
	private java.lang.Integer apgarAt5;
	private java.lang.String complications;
	private java.lang.String anomalies;
	private java.lang.String babyFeeding;

	// many to one
	private jkt.hms.masters.business.DeliveryDetails delivery;
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasAdministrativeSex sex;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Patient babyHin;
	private jkt.hms.masters.business.MasDeliveryType deliveryType;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="baby_id"
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
	 * Return the value associated with the column: baby_no
	 */
	public java.lang.Integer getBabyNo () {
		return babyNo;
	}

	/**
	 * Set the value related to the column: baby_no
	 * @param babyNo the baby_no value
	 */
	public void setBabyNo (java.lang.Integer babyNo) {
		this.babyNo = babyNo;
	}



	/**
	 * Return the value associated with the column: date_of_birth
	 */
	public java.util.Date getDateOfBirth () {
		return dateOfBirth;
	}

	/**
	 * Set the value related to the column: date_of_birth
	 * @param dateOfBirth the date_of_birth value
	 */
	public void setDateOfBirth (java.util.Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}



	/**
	 * Return the value associated with the column: birth_certification_no
	 */
	public java.lang.String getBirthCertificationNo () {
		return birthCertificationNo;
	}

	/**
	 * Set the value related to the column: birth_certification_no
	 * @param birthCertificationNo the birth_certification_no value
	 */
	public void setBirthCertificationNo (java.lang.String birthCertificationNo) {
		this.birthCertificationNo = birthCertificationNo;
	}



	/**
	 * Return the value associated with the column: time_of_birth
	 */
	public java.lang.String getTimeOfBirth () {
		return timeOfBirth;
	}

	/**
	 * Set the value related to the column: time_of_birth
	 * @param timeOfBirth the time_of_birth value
	 */
	public void setTimeOfBirth (java.lang.String timeOfBirth) {
		this.timeOfBirth = timeOfBirth;
	}



	/**
	 * Return the value associated with the column: birth_certification_date
	 */
	public java.util.Date getBirthCertificationDate () {
		return birthCertificationDate;
	}

	/**
	 * Set the value related to the column: birth_certification_date
	 * @param birthCertificationDate the birth_certification_date value
	 */
	public void setBirthCertificationDate (java.util.Date birthCertificationDate) {
		this.birthCertificationDate = birthCertificationDate;
	}



	/**
	 * Return the value associated with the column: cs_indication
	 */
	public java.lang.Integer getCsIndication () {
		return csIndication;
	}

	/**
	 * Set the value related to the column: cs_indication
	 * @param csIndication the cs_indication value
	 */
	public void setCsIndication (java.lang.Integer csIndication) {
		this.csIndication = csIndication;
	}



	/**
	 * Return the value associated with the column: gestation
	 */
	public java.lang.Integer getGestation () {
		return gestation;
	}

	/**
	 * Set the value related to the column: gestation
	 * @param gestation the gestation value
	 */
	public void setGestation (java.lang.Integer gestation) {
		this.gestation = gestation;
	}



	/**
	 * Return the value associated with the column: head_circumferance
	 */
	public java.lang.Float getHeadCircumferance () {
		return headCircumferance;
	}

	/**
	 * Set the value related to the column: head_circumferance
	 * @param headCircumferance the head_circumferance value
	 */
	public void setHeadCircumferance (java.lang.Float headCircumferance) {
		this.headCircumferance = headCircumferance;
	}



	/**
	 * Return the value associated with the column: cs_no
	 */
	public java.lang.String getCsNo () {
		return csNo;
	}

	/**
	 * Set the value related to the column: cs_no
	 * @param csNo the cs_no value
	 */
	public void setCsNo (java.lang.String csNo) {
		this.csNo = csNo;
	}



	/**
	 * Return the value associated with the column: gestation_age
	 */
	public java.lang.String getGestationAge () {
		return gestationAge;
	}

	/**
	 * Set the value related to the column: gestation_age
	 * @param gestationAge the gestation_age value
	 */
	public void setGestationAge (java.lang.String gestationAge) {
		this.gestationAge = gestationAge;
	}



	/**
	 * Return the value associated with the column: length
	 */
	public java.lang.Float getLength () {
		return length;
	}

	/**
	 * Set the value related to the column: length
	 * @param length the length value
	 */
	public void setLength (java.lang.Float length) {
		this.length = length;
	}



	/**
	 * Return the value associated with the column: apgar_score
	 */
	public java.lang.Float getApgarScore () {
		return apgarScore;
	}

	/**
	 * Set the value related to the column: apgar_score
	 * @param apgarScore the apgar_score value
	 */
	public void setApgarScore (java.lang.Float apgarScore) {
		this.apgarScore = apgarScore;
	}



	/**
	 * Return the value associated with the column: est_gest_age
	 */
	public java.lang.String getEstGestAge () {
		return estGestAge;
	}

	/**
	 * Set the value related to the column: est_gest_age
	 * @param estGestAge the est_gest_age value
	 */
	public void setEstGestAge (java.lang.String estGestAge) {
		this.estGestAge = estGestAge;
	}



	/**
	 * Return the value associated with the column: weight
	 */
	public java.lang.String getWeight () {
		return weight;
	}

	/**
	 * Set the value related to the column: weight
	 * @param weight the weight value
	 */
	public void setWeight (java.lang.String weight) {
		this.weight = weight;
	}



	/**
	 * Return the value associated with the column: mas_neonatal_problem
	 */
	public java.lang.Integer getMasNeonatalProblem () {
		return masNeonatalProblem;
	}

	/**
	 * Set the value related to the column: mas_neonatal_problem
	 * @param masNeonatalProblem the mas_neonatal_problem value
	 */
	public void setMasNeonatalProblem (java.lang.Integer masNeonatalProblem) {
		this.masNeonatalProblem = masNeonatalProblem;
	}



	/**
	 * Return the value associated with the column: baby_status
	 */
	public java.lang.Integer getBabyStatus () {
		return babyStatus;
	}

	/**
	 * Set the value related to the column: baby_status
	 * @param babyStatus the baby_status value
	 */
	public void setBabyStatus (java.lang.Integer babyStatus) {
		this.babyStatus = babyStatus;
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
	 * Return the value associated with the column: outcome
	 */
	public java.lang.String getOutcome () {
		return outcome;
	}

	/**
	 * Set the value related to the column: outcome
	 * @param outcome the outcome value
	 */
	public void setOutcome (java.lang.String outcome) {
		this.outcome = outcome;
	}



	/**
	 * Return the value associated with the column: live_still_born
	 */
	public java.lang.String getLiveStillBorn () {
		return liveStillBorn;
	}

	/**
	 * Set the value related to the column: live_still_born
	 * @param liveStillBorn the live_still_born value
	 */
	public void setLiveStillBorn (java.lang.String liveStillBorn) {
		this.liveStillBorn = liveStillBorn;
	}



	/**
	 * Return the value associated with the column: presentation
	 */
	public java.lang.String getPresentation () {
		return presentation;
	}

	/**
	 * Set the value related to the column: presentation
	 * @param presentation the presentation value
	 */
	public void setPresentation (java.lang.String presentation) {
		this.presentation = presentation;
	}



	/**
	 * Return the value associated with the column: baby_cry
	 */
	public java.lang.String getBabyCry () {
		return babyCry;
	}

	/**
	 * Set the value related to the column: baby_cry
	 * @param babyCry the baby_cry value
	 */
	public void setBabyCry (java.lang.String babyCry) {
		this.babyCry = babyCry;
	}



	/**
	 * Return the value associated with the column: apgar_at_1
	 */
	public java.lang.Integer getApgarAt1 () {
		return apgarAt1;
	}

	/**
	 * Set the value related to the column: apgar_at_1
	 * @param apgarAt1 the apgar_at_1 value
	 */
	public void setApgarAt1 (java.lang.Integer apgarAt1) {
		this.apgarAt1 = apgarAt1;
	}



	/**
	 * Return the value associated with the column: apgar_at_5
	 */
	public java.lang.Integer getApgarAt5 () {
		return apgarAt5;
	}

	/**
	 * Set the value related to the column: apgar_at_5
	 * @param apgarAt5 the apgar_at_5 value
	 */
	public void setApgarAt5 (java.lang.Integer apgarAt5) {
		this.apgarAt5 = apgarAt5;
	}



	/**
	 * Return the value associated with the column: complications
	 */
	public java.lang.String getComplications () {
		return complications;
	}

	/**
	 * Set the value related to the column: complications
	 * @param complications the complications value
	 */
	public void setComplications (java.lang.String complications) {
		this.complications = complications;
	}



	/**
	 * Return the value associated with the column: anomalies
	 */
	public java.lang.String getAnomalies () {
		return anomalies;
	}

	/**
	 * Set the value related to the column: anomalies
	 * @param anomalies the anomalies value
	 */
	public void setAnomalies (java.lang.String anomalies) {
		this.anomalies = anomalies;
	}



	/**
	 * Return the value associated with the column: baby_feeding
	 */
	public java.lang.String getBabyFeeding () {
		return babyFeeding;
	}

	/**
	 * Set the value related to the column: baby_feeding
	 * @param babyFeeding the baby_feeding value
	 */
	public void setBabyFeeding (java.lang.String babyFeeding) {
		this.babyFeeding = babyFeeding;
	}



	/**
	 * Return the value associated with the column: delivery_id
	 */
	public jkt.hms.masters.business.DeliveryDetails getDelivery () {
		return delivery;
	}

	/**
	 * Set the value related to the column: delivery_id
	 * @param delivery the delivery_id value
	 */
	public void setDelivery (jkt.hms.masters.business.DeliveryDetails delivery) {
		this.delivery = delivery;
	}



	/**
	 * Return the value associated with the column: inpatient_id
	 */
	public jkt.hms.masters.business.Inpatient getInpatient () {
		return inpatient;
	}

	/**
	 * Set the value related to the column: inpatient_id
	 * @param inpatient the inpatient_id value
	 */
	public void setInpatient (jkt.hms.masters.business.Inpatient inpatient) {
		this.inpatient = inpatient;
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
	 * Return the value associated with the column: baby_hin_id
	 */
	public jkt.hms.masters.business.Patient getBabyHin () {
		return babyHin;
	}

	/**
	 * Set the value related to the column: baby_hin_id
	 * @param babyHin the baby_hin_id value
	 */
	public void setBabyHin (jkt.hms.masters.business.Patient babyHin) {
		this.babyHin = babyHin;
	}



	/**
	 * Return the value associated with the column: delivery_type_id
	 */
	public jkt.hms.masters.business.MasDeliveryType getDeliveryType () {
		return deliveryType;
	}

	/**
	 * Set the value related to the column: delivery_type_id
	 * @param deliveryType the delivery_type_id value
	 */
	public void setDeliveryType (jkt.hms.masters.business.MasDeliveryType deliveryType) {
		this.deliveryType = deliveryType;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.BabyDetails)) return false;
		else {
			jkt.hms.masters.business.BabyDetails babyDetails = (jkt.hms.masters.business.BabyDetails) obj;
			if (null == this.getId() || null == babyDetails.getId()) return false;
			else return (this.getId().equals(babyDetails.getId()));
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
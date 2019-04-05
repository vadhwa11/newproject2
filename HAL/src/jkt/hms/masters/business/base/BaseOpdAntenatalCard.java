package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the opd_antenatal_card table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="opd_antenatal_card"
 */

public abstract class BaseOpdAntenatalCard implements Serializable {

	public static String REF = "OpdAntenatalCard";
	public static String PROP_DIETARY_HABIT = "DietaryHabit";
	public static String PROP_MEDICAL_HISTORY = "MedicalHistory";
	public static String PROP_CYCLE = "Cycle";
	public static String PROP_HEIGHT = "Height";
	public static String PROP_TWO_HR = "TwoHr";
	public static String PROP_EXAMINATION_DATE = "ExaminationDate";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_GYNECOLOGICAL = "Gynecological";
	public static String PROP_MENARCHE = "Menarche";
	public static String PROP_PARA = "Para";
	public static String PROP_TETANUS_ONEST_DOSE_DATE = "TetanusOnestDoseDate";
	public static String PROP_COMPLICATIONS = "Complications";
	public static String PROP_YEAR = "Year";
	public static String PROP_SMOKING = "Smoking";
	public static String PROP_VISIT = "Visit";
	public static String PROP_LIVE = "Live";
	public static String PROP_SURGICAL = "Surgical";
	public static String PROP_OGTT_DATE = "OgttDate";
	public static String PROP_FASTING = "Fasting";
	public static String PROP_FOETAL_ABNORMALITY = "FoetalAbnormality";
	public static String PROP_LUNGS = "Lungs";
	public static String PROP_PARLLOR = "Parllor";
	public static String PROP_NEXT_VISIT_ON = "NextVisitOn";
	public static String PROP_BP = "Bp";
	public static String PROP_BUILD = "Build";
	public static String PROP_LMP = "Lmp";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_NUTRITION = "Nutrition";
	public static String PROP_UTERINE_SIZE = "UterineSize";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_BREAST_FEEDING = "BreastFeeding";
	public static String PROP_PRESENTATION_POSITION = "PresentationPosition";
	public static String PROP_WEIGHT_ANTENATAL = "WeightAntenatal";
	public static String PROP_ONE_HR = "OneHr";
	public static String PROP_DAYS = "Days";
	public static String PROP_HIN = "Hin";
	public static String PROP_MULTIPLE_PREGNANCY = "MultiplePregnancy";
	public static String PROP_AGE = "Age";
	public static String PROP_HIGH_RISK_FACTORS = "HighRiskFactors";
	public static String PROP_ENGAGEMENT = "Engagement";
	public static String PROP_THREE_HR = "ThreeHr";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_TETANUS_TWOND_DOSE_DATE = "TetanusTwondDoseDate";
	public static String PROP_HEART = "Heart";
	public static String PROP_WILLING_FOR_TUBECTOMY = "WillingForTubectomy";
	public static String PROP_BIRTH_WEIGHT = "BirthWeight";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_GRAVIDA = "Gravida";
	public static String PROP_PREGNANCY_OUTCOME = "PregnancyOutcome";
	public static String PROP_HB_GMS = "HbGms";
	public static String PROP_BLOOD_GROUP_HUSBAND = "BloodGroupHusband";
	public static String PROP_ANY_COMPLIANT = "AnyCompliant";
	public static String PROP_ECTOPIC = "Ectopic";
	public static String PROP_MEDICAL = "Medical";
	public static String PROP_BLOOD_GROUP_WIFE = "BloodGroupWife";
	public static String PROP_NIPPLE = "Nipple";
	public static String PROP_HBSAG = "Hbsag";
	public static String PROP_ADVICE = "Advice";
	public static String PROP_BREAST = "Breast";
	public static String PROP_SEX = "Sex";
	public static String PROP_GENERAL_HEALTH = "GeneralHealth";
	public static String PROP_ABORTIONS = "Abortions";
	public static String PROP_HIV = "Hiv";
	public static String PROP_OGTT = "Ogtt";
	public static String PROP_OEDEMA = "Oedema";
	public static String PROP_GCT = "Gct";
	public static String PROP_WEIGHT = "Weight";
	public static String PROP_ANTENATAL_DATE = "AntenatalDate";
	public static String PROP_URINE = "Urine";
	public static String PROP_FHS_FM = "FhsFm";
	public static String PROP_EDD = "Edd";
	public static String PROP_ID = "Id";
	public static String PROP_STS = "Sts";

	// constructors
	public BaseOpdAntenatalCard() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdAntenatalCard(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer menarche;
	private java.lang.String cycle;
	private java.lang.String days;
	private java.util.Date lmp;
	private java.util.Date edd;
	private java.lang.Integer gravida;
	private java.lang.Integer para;
	private java.lang.Integer abortions;
	private java.lang.Integer live;
	private java.lang.Integer ectopic;
	private java.lang.String year;
	private java.lang.String pregnancyOutcome;
	private java.lang.String complications;
	private java.lang.Integer age;
	private java.lang.String sex;
	private java.lang.Integer birthWeight;
	private java.lang.String breastFeeding;
	private java.lang.String generalHealth;
	private java.lang.String medical;
	private java.lang.String surgical;
	private java.lang.String gynecological;
	private java.lang.String medicalHistory;
	private java.lang.String multiplePregnancy;
	private java.lang.String foetalAbnormality;
	private java.lang.String dietaryHabit;
	private java.lang.String smoking;
	private java.lang.String build;
	private java.lang.String nutrition;
	private java.lang.String height;
	private java.lang.String weight;
	private java.lang.String breast;
	private java.lang.String nipple;
	private java.lang.String heart;
	private java.lang.String lungs;
	private java.lang.String bloodGroupWife;
	private java.lang.String bloodGroupHusband;
	private java.lang.String sts;
	private java.lang.String hbsag;
	private java.lang.String hiv;
	private java.lang.String gct;
	private java.util.Date examinationDate;
	private java.lang.String ogtt;
	private java.util.Date ogttDate;
	private java.lang.String fasting;
	private java.lang.String oneHr;
	private java.lang.String twoHr;
	private java.lang.String threeHr;
	private java.lang.String highRiskFactors;
	private java.util.Date tetanusOnestDoseDate;
	private java.util.Date tetanusTwondDoseDate;
	private java.lang.String willingForTubectomy;
	private java.util.Date antenatalDate;
	private java.lang.String weightAntenatal;
	private java.lang.String anyCompliant;
	private java.lang.String parllor;
	private java.lang.String oedema;
	private java.lang.String bp;
	private java.lang.String uterineSize;
	private java.lang.String presentationPosition;
	private java.lang.String engagement;
	private java.lang.String fhsFm;
	private java.lang.String urine;
	private java.lang.String hbGms;
	private java.util.Date nextVisitOn;
	private java.lang.String advice;
	private java.lang.Integer lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.Patient hin;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="opd_antenatal_card_id"
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
	 * Return the value associated with the column: menarche
	 */
	public java.lang.Integer getMenarche() {
		return menarche;
	}

	/**
	 * Set the value related to the column: menarche
	 * 
	 * @param menarche
	 *            the menarche value
	 */
	public void setMenarche(java.lang.Integer menarche) {
		this.menarche = menarche;
	}

	/**
	 * Return the value associated with the column: cycle
	 */
	public java.lang.String getCycle() {
		return cycle;
	}

	/**
	 * Set the value related to the column: cycle
	 * 
	 * @param cycle
	 *            the cycle value
	 */
	public void setCycle(java.lang.String cycle) {
		this.cycle = cycle;
	}

	/**
	 * Return the value associated with the column: days
	 */
	public java.lang.String getDays() {
		return days;
	}

	/**
	 * Set the value related to the column: days
	 * 
	 * @param days
	 *            the days value
	 */
	public void setDays(java.lang.String days) {
		this.days = days;
	}

	/**
	 * Return the value associated with the column: lmp
	 */
	public java.util.Date getLmp() {
		return lmp;
	}

	/**
	 * Set the value related to the column: lmp
	 * 
	 * @param lmp
	 *            the lmp value
	 */
	public void setLmp(java.util.Date lmp) {
		this.lmp = lmp;
	}

	/**
	 * Return the value associated with the column: edd
	 */
	public java.util.Date getEdd() {
		return edd;
	}

	/**
	 * Set the value related to the column: edd
	 * 
	 * @param edd
	 *            the edd value
	 */
	public void setEdd(java.util.Date edd) {
		this.edd = edd;
	}

	/**
	 * Return the value associated with the column: gravida
	 */
	public java.lang.Integer getGravida() {
		return gravida;
	}

	/**
	 * Set the value related to the column: gravida
	 * 
	 * @param gravida
	 *            the gravida value
	 */
	public void setGravida(java.lang.Integer gravida) {
		this.gravida = gravida;
	}

	/**
	 * Return the value associated with the column: para
	 */
	public java.lang.Integer getPara() {
		return para;
	}

	/**
	 * Set the value related to the column: para
	 * 
	 * @param para
	 *            the para value
	 */
	public void setPara(java.lang.Integer para) {
		this.para = para;
	}

	/**
	 * Return the value associated with the column: abortions
	 */
	public java.lang.Integer getAbortions() {
		return abortions;
	}

	/**
	 * Set the value related to the column: abortions
	 * 
	 * @param abortions
	 *            the abortions value
	 */
	public void setAbortions(java.lang.Integer abortions) {
		this.abortions = abortions;
	}

	/**
	 * Return the value associated with the column: live
	 */
	public java.lang.Integer getLive() {
		return live;
	}

	/**
	 * Set the value related to the column: live
	 * 
	 * @param live
	 *            the live value
	 */
	public void setLive(java.lang.Integer live) {
		this.live = live;
	}

	/**
	 * Return the value associated with the column: ectopic
	 */
	public java.lang.Integer getEctopic() {
		return ectopic;
	}

	/**
	 * Set the value related to the column: ectopic
	 * 
	 * @param ectopic
	 *            the ectopic value
	 */
	public void setEctopic(java.lang.Integer ectopic) {
		this.ectopic = ectopic;
	}

	/**
	 * Return the value associated with the column: year
	 */
	public java.lang.String getYear() {
		return year;
	}

	/**
	 * Set the value related to the column: year
	 * 
	 * @param year
	 *            the year value
	 */
	public void setYear(java.lang.String year) {
		this.year = year;
	}

	/**
	 * Return the value associated with the column: pregnancy_outcome
	 */
	public java.lang.String getPregnancyOutcome() {
		return pregnancyOutcome;
	}

	/**
	 * Set the value related to the column: pregnancy_outcome
	 * 
	 * @param pregnancyOutcome
	 *            the pregnancy_outcome value
	 */
	public void setPregnancyOutcome(java.lang.String pregnancyOutcome) {
		this.pregnancyOutcome = pregnancyOutcome;
	}

	/**
	 * Return the value associated with the column: complications
	 */
	public java.lang.String getComplications() {
		return complications;
	}

	/**
	 * Set the value related to the column: complications
	 * 
	 * @param complications
	 *            the complications value
	 */
	public void setComplications(java.lang.String complications) {
		this.complications = complications;
	}

	/**
	 * Return the value associated with the column: age
	 */
	public java.lang.Integer getAge() {
		return age;
	}

	/**
	 * Set the value related to the column: age
	 * 
	 * @param age
	 *            the age value
	 */
	public void setAge(java.lang.Integer age) {
		this.age = age;
	}

	/**
	 * Return the value associated with the column: sex
	 */
	public java.lang.String getSex() {
		return sex;
	}

	/**
	 * Set the value related to the column: sex
	 * 
	 * @param sex
	 *            the sex value
	 */
	public void setSex(java.lang.String sex) {
		this.sex = sex;
	}

	/**
	 * Return the value associated with the column: birth_weight
	 */
	public java.lang.Integer getBirthWeight() {
		return birthWeight;
	}

	/**
	 * Set the value related to the column: birth_weight
	 * 
	 * @param birthWeight
	 *            the birth_weight value
	 */
	public void setBirthWeight(java.lang.Integer birthWeight) {
		this.birthWeight = birthWeight;
	}

	/**
	 * Return the value associated with the column: breast_feeding
	 */
	public java.lang.String getBreastFeeding() {
		return breastFeeding;
	}

	/**
	 * Set the value related to the column: breast_feeding
	 * 
	 * @param breastFeeding
	 *            the breast_feeding value
	 */
	public void setBreastFeeding(java.lang.String breastFeeding) {
		this.breastFeeding = breastFeeding;
	}

	/**
	 * Return the value associated with the column: general_health
	 */
	public java.lang.String getGeneralHealth() {
		return generalHealth;
	}

	/**
	 * Set the value related to the column: general_health
	 * 
	 * @param generalHealth
	 *            the general_health value
	 */
	public void setGeneralHealth(java.lang.String generalHealth) {
		this.generalHealth = generalHealth;
	}

	/**
	 * Return the value associated with the column: medical
	 */
	public java.lang.String getMedical() {
		return medical;
	}

	/**
	 * Set the value related to the column: medical
	 * 
	 * @param medical
	 *            the medical value
	 */
	public void setMedical(java.lang.String medical) {
		this.medical = medical;
	}

	/**
	 * Return the value associated with the column: surgical
	 */
	public java.lang.String getSurgical() {
		return surgical;
	}

	/**
	 * Set the value related to the column: surgical
	 * 
	 * @param surgical
	 *            the surgical value
	 */
	public void setSurgical(java.lang.String surgical) {
		this.surgical = surgical;
	}

	/**
	 * Return the value associated with the column: gynecological
	 */
	public java.lang.String getGynecological() {
		return gynecological;
	}

	/**
	 * Set the value related to the column: gynecological
	 * 
	 * @param gynecological
	 *            the gynecological value
	 */
	public void setGynecological(java.lang.String gynecological) {
		this.gynecological = gynecological;
	}

	/**
	 * Return the value associated with the column: medical_history
	 */
	public java.lang.String getMedicalHistory() {
		return medicalHistory;
	}

	/**
	 * Set the value related to the column: medical_history
	 * 
	 * @param medicalHistory
	 *            the medical_history value
	 */
	public void setMedicalHistory(java.lang.String medicalHistory) {
		this.medicalHistory = medicalHistory;
	}

	/**
	 * Return the value associated with the column: multiple_pregnancy
	 */
	public java.lang.String getMultiplePregnancy() {
		return multiplePregnancy;
	}

	/**
	 * Set the value related to the column: multiple_pregnancy
	 * 
	 * @param multiplePregnancy
	 *            the multiple_pregnancy value
	 */
	public void setMultiplePregnancy(java.lang.String multiplePregnancy) {
		this.multiplePregnancy = multiplePregnancy;
	}

	/**
	 * Return the value associated with the column: foetal_abnormality
	 */
	public java.lang.String getFoetalAbnormality() {
		return foetalAbnormality;
	}

	/**
	 * Set the value related to the column: foetal_abnormality
	 * 
	 * @param foetalAbnormality
	 *            the foetal_abnormality value
	 */
	public void setFoetalAbnormality(java.lang.String foetalAbnormality) {
		this.foetalAbnormality = foetalAbnormality;
	}

	/**
	 * Return the value associated with the column: dietary_habit
	 */
	public java.lang.String getDietaryHabit() {
		return dietaryHabit;
	}

	/**
	 * Set the value related to the column: dietary_habit
	 * 
	 * @param dietaryHabit
	 *            the dietary_habit value
	 */
	public void setDietaryHabit(java.lang.String dietaryHabit) {
		this.dietaryHabit = dietaryHabit;
	}

	/**
	 * Return the value associated with the column: smoking
	 */
	public java.lang.String getSmoking() {
		return smoking;
	}

	/**
	 * Set the value related to the column: smoking
	 * 
	 * @param smoking
	 *            the smoking value
	 */
	public void setSmoking(java.lang.String smoking) {
		this.smoking = smoking;
	}

	/**
	 * Return the value associated with the column: build
	 */
	public java.lang.String getBuild() {
		return build;
	}

	/**
	 * Set the value related to the column: build
	 * 
	 * @param build
	 *            the build value
	 */
	public void setBuild(java.lang.String build) {
		this.build = build;
	}

	/**
	 * Return the value associated with the column: nutrition
	 */
	public java.lang.String getNutrition() {
		return nutrition;
	}

	/**
	 * Set the value related to the column: nutrition
	 * 
	 * @param nutrition
	 *            the nutrition value
	 */
	public void setNutrition(java.lang.String nutrition) {
		this.nutrition = nutrition;
	}

	/**
	 * Return the value associated with the column: height
	 */
	public java.lang.String getHeight() {
		return height;
	}

	/**
	 * Set the value related to the column: height
	 * 
	 * @param height
	 *            the height value
	 */
	public void setHeight(java.lang.String height) {
		this.height = height;
	}

	/**
	 * Return the value associated with the column: weight
	 */
	public java.lang.String getWeight() {
		return weight;
	}

	/**
	 * Set the value related to the column: weight
	 * 
	 * @param weight
	 *            the weight value
	 */
	public void setWeight(java.lang.String weight) {
		this.weight = weight;
	}

	/**
	 * Return the value associated with the column: breast
	 */
	public java.lang.String getBreast() {
		return breast;
	}

	/**
	 * Set the value related to the column: breast
	 * 
	 * @param breast
	 *            the breast value
	 */
	public void setBreast(java.lang.String breast) {
		this.breast = breast;
	}

	/**
	 * Return the value associated with the column: nipple
	 */
	public java.lang.String getNipple() {
		return nipple;
	}

	/**
	 * Set the value related to the column: nipple
	 * 
	 * @param nipple
	 *            the nipple value
	 */
	public void setNipple(java.lang.String nipple) {
		this.nipple = nipple;
	}

	/**
	 * Return the value associated with the column: heart
	 */
	public java.lang.String getHeart() {
		return heart;
	}

	/**
	 * Set the value related to the column: heart
	 * 
	 * @param heart
	 *            the heart value
	 */
	public void setHeart(java.lang.String heart) {
		this.heart = heart;
	}

	/**
	 * Return the value associated with the column: lungs
	 */
	public java.lang.String getLungs() {
		return lungs;
	}

	/**
	 * Set the value related to the column: lungs
	 * 
	 * @param lungs
	 *            the lungs value
	 */
	public void setLungs(java.lang.String lungs) {
		this.lungs = lungs;
	}

	/**
	 * Return the value associated with the column: blood_group_wife
	 */
	public java.lang.String getBloodGroupWife() {
		return bloodGroupWife;
	}

	/**
	 * Set the value related to the column: blood_group_wife
	 * 
	 * @param bloodGroupWife
	 *            the blood_group_wife value
	 */
	public void setBloodGroupWife(java.lang.String bloodGroupWife) {
		this.bloodGroupWife = bloodGroupWife;
	}

	/**
	 * Return the value associated with the column: blood_group_husband
	 */
	public java.lang.String getBloodGroupHusband() {
		return bloodGroupHusband;
	}

	/**
	 * Set the value related to the column: blood_group_husband
	 * 
	 * @param bloodGroupHusband
	 *            the blood_group_husband value
	 */
	public void setBloodGroupHusband(java.lang.String bloodGroupHusband) {
		this.bloodGroupHusband = bloodGroupHusband;
	}

	/**
	 * Return the value associated with the column: sts
	 */
	public java.lang.String getSts() {
		return sts;
	}

	/**
	 * Set the value related to the column: sts
	 * 
	 * @param sts
	 *            the sts value
	 */
	public void setSts(java.lang.String sts) {
		this.sts = sts;
	}

	/**
	 * Return the value associated with the column: hbsag
	 */
	public java.lang.String getHbsag() {
		return hbsag;
	}

	/**
	 * Set the value related to the column: hbsag
	 * 
	 * @param hbsag
	 *            the hbsag value
	 */
	public void setHbsag(java.lang.String hbsag) {
		this.hbsag = hbsag;
	}

	/**
	 * Return the value associated with the column: hiv
	 */
	public java.lang.String getHiv() {
		return hiv;
	}

	/**
	 * Set the value related to the column: hiv
	 * 
	 * @param hiv
	 *            the hiv value
	 */
	public void setHiv(java.lang.String hiv) {
		this.hiv = hiv;
	}

	/**
	 * Return the value associated with the column: gct
	 */
	public java.lang.String getGct() {
		return gct;
	}

	/**
	 * Set the value related to the column: gct
	 * 
	 * @param gct
	 *            the gct value
	 */
	public void setGct(java.lang.String gct) {
		this.gct = gct;
	}

	/**
	 * Return the value associated with the column: examination_date
	 */
	public java.util.Date getExaminationDate() {
		return examinationDate;
	}

	/**
	 * Set the value related to the column: examination_date
	 * 
	 * @param examinationDate
	 *            the examination_date value
	 */
	public void setExaminationDate(java.util.Date examinationDate) {
		this.examinationDate = examinationDate;
	}

	/**
	 * Return the value associated with the column: ogtt
	 */
	public java.lang.String getOgtt() {
		return ogtt;
	}

	/**
	 * Set the value related to the column: ogtt
	 * 
	 * @param ogtt
	 *            the ogtt value
	 */
	public void setOgtt(java.lang.String ogtt) {
		this.ogtt = ogtt;
	}

	/**
	 * Return the value associated with the column: ogtt_date
	 */
	public java.util.Date getOgttDate() {
		return ogttDate;
	}

	/**
	 * Set the value related to the column: ogtt_date
	 * 
	 * @param ogttDate
	 *            the ogtt_date value
	 */
	public void setOgttDate(java.util.Date ogttDate) {
		this.ogttDate = ogttDate;
	}

	/**
	 * Return the value associated with the column: fasting
	 */
	public java.lang.String getFasting() {
		return fasting;
	}

	/**
	 * Set the value related to the column: fasting
	 * 
	 * @param fasting
	 *            the fasting value
	 */
	public void setFasting(java.lang.String fasting) {
		this.fasting = fasting;
	}

	/**
	 * Return the value associated with the column: one_Hr
	 */
	public java.lang.String getOneHr() {
		return oneHr;
	}

	/**
	 * Set the value related to the column: one_Hr
	 * 
	 * @param oneHr
	 *            the one_Hr value
	 */
	public void setOneHr(java.lang.String oneHr) {
		this.oneHr = oneHr;
	}

	/**
	 * Return the value associated with the column: two_Hr
	 */
	public java.lang.String getTwoHr() {
		return twoHr;
	}

	/**
	 * Set the value related to the column: two_Hr
	 * 
	 * @param twoHr
	 *            the two_Hr value
	 */
	public void setTwoHr(java.lang.String twoHr) {
		this.twoHr = twoHr;
	}

	/**
	 * Return the value associated with the column: three_hr
	 */
	public java.lang.String getThreeHr() {
		return threeHr;
	}

	/**
	 * Set the value related to the column: three_hr
	 * 
	 * @param threeHr
	 *            the three_hr value
	 */
	public void setThreeHr(java.lang.String threeHr) {
		this.threeHr = threeHr;
	}

	/**
	 * Return the value associated with the column: high_risk_factors
	 */
	public java.lang.String getHighRiskFactors() {
		return highRiskFactors;
	}

	/**
	 * Set the value related to the column: high_risk_factors
	 * 
	 * @param highRiskFactors
	 *            the high_risk_factors value
	 */
	public void setHighRiskFactors(java.lang.String highRiskFactors) {
		this.highRiskFactors = highRiskFactors;
	}

	/**
	 * Return the value associated with the column: tetanus_onest_dose_date
	 */
	public java.util.Date getTetanusOnestDoseDate() {
		return tetanusOnestDoseDate;
	}

	/**
	 * Set the value related to the column: tetanus_onest_dose_date
	 * 
	 * @param tetanusOnestDoseDate
	 *            the tetanus_onest_dose_date value
	 */
	public void setTetanusOnestDoseDate(java.util.Date tetanusOnestDoseDate) {
		this.tetanusOnestDoseDate = tetanusOnestDoseDate;
	}

	/**
	 * Return the value associated with the column: tetanus_twond_dose_date
	 */
	public java.util.Date getTetanusTwondDoseDate() {
		return tetanusTwondDoseDate;
	}

	/**
	 * Set the value related to the column: tetanus_twond_dose_date
	 * 
	 * @param tetanusTwondDoseDate
	 *            the tetanus_twond_dose_date value
	 */
	public void setTetanusTwondDoseDate(java.util.Date tetanusTwondDoseDate) {
		this.tetanusTwondDoseDate = tetanusTwondDoseDate;
	}

	/**
	 * Return the value associated with the column: willing_for_tubectomy
	 */
	public java.lang.String getWillingForTubectomy() {
		return willingForTubectomy;
	}

	/**
	 * Set the value related to the column: willing_for_tubectomy
	 * 
	 * @param willingForTubectomy
	 *            the willing_for_tubectomy value
	 */
	public void setWillingForTubectomy(java.lang.String willingForTubectomy) {
		this.willingForTubectomy = willingForTubectomy;
	}

	/**
	 * Return the value associated with the column: antenatal_date
	 */
	public java.util.Date getAntenatalDate() {
		return antenatalDate;
	}

	/**
	 * Set the value related to the column: antenatal_date
	 * 
	 * @param antenatalDate
	 *            the antenatal_date value
	 */
	public void setAntenatalDate(java.util.Date antenatalDate) {
		this.antenatalDate = antenatalDate;
	}

	/**
	 * Return the value associated with the column: weight_antenatal
	 */
	public java.lang.String getWeightAntenatal() {
		return weightAntenatal;
	}

	/**
	 * Set the value related to the column: weight_antenatal
	 * 
	 * @param weightAntenatal
	 *            the weight_antenatal value
	 */
	public void setWeightAntenatal(java.lang.String weightAntenatal) {
		this.weightAntenatal = weightAntenatal;
	}

	/**
	 * Return the value associated with the column: any_compliant
	 */
	public java.lang.String getAnyCompliant() {
		return anyCompliant;
	}

	/**
	 * Set the value related to the column: any_compliant
	 * 
	 * @param anyCompliant
	 *            the any_compliant value
	 */
	public void setAnyCompliant(java.lang.String anyCompliant) {
		this.anyCompliant = anyCompliant;
	}

	/**
	 * Return the value associated with the column: parllor
	 */
	public java.lang.String getParllor() {
		return parllor;
	}

	/**
	 * Set the value related to the column: parllor
	 * 
	 * @param parllor
	 *            the parllor value
	 */
	public void setParllor(java.lang.String parllor) {
		this.parllor = parllor;
	}

	/**
	 * Return the value associated with the column: oedema
	 */
	public java.lang.String getOedema() {
		return oedema;
	}

	/**
	 * Set the value related to the column: oedema
	 * 
	 * @param oedema
	 *            the oedema value
	 */
	public void setOedema(java.lang.String oedema) {
		this.oedema = oedema;
	}

	/**
	 * Return the value associated with the column: bp
	 */
	public java.lang.String getBp() {
		return bp;
	}

	/**
	 * Set the value related to the column: bp
	 * 
	 * @param bp
	 *            the bp value
	 */
	public void setBp(java.lang.String bp) {
		this.bp = bp;
	}

	/**
	 * Return the value associated with the column: uterine_size
	 */
	public java.lang.String getUterineSize() {
		return uterineSize;
	}

	/**
	 * Set the value related to the column: uterine_size
	 * 
	 * @param uterineSize
	 *            the uterine_size value
	 */
	public void setUterineSize(java.lang.String uterineSize) {
		this.uterineSize = uterineSize;
	}

	/**
	 * Return the value associated with the column: presentation_position
	 */
	public java.lang.String getPresentationPosition() {
		return presentationPosition;
	}

	/**
	 * Set the value related to the column: presentation_position
	 * 
	 * @param presentationPosition
	 *            the presentation_position value
	 */
	public void setPresentationPosition(java.lang.String presentationPosition) {
		this.presentationPosition = presentationPosition;
	}

	/**
	 * Return the value associated with the column: engagement
	 */
	public java.lang.String getEngagement() {
		return engagement;
	}

	/**
	 * Set the value related to the column: engagement
	 * 
	 * @param engagement
	 *            the engagement value
	 */
	public void setEngagement(java.lang.String engagement) {
		this.engagement = engagement;
	}

	/**
	 * Return the value associated with the column: fhs_fm
	 */
	public java.lang.String getFhsFm() {
		return fhsFm;
	}

	/**
	 * Set the value related to the column: fhs_fm
	 * 
	 * @param fhsFm
	 *            the fhs_fm value
	 */
	public void setFhsFm(java.lang.String fhsFm) {
		this.fhsFm = fhsFm;
	}

	/**
	 * Return the value associated with the column: urine
	 */
	public java.lang.String getUrine() {
		return urine;
	}

	/**
	 * Set the value related to the column: urine
	 * 
	 * @param urine
	 *            the urine value
	 */
	public void setUrine(java.lang.String urine) {
		this.urine = urine;
	}

	/**
	 * Return the value associated with the column: hb_gms
	 */
	public java.lang.String getHbGms() {
		return hbGms;
	}

	/**
	 * Set the value related to the column: hb_gms
	 * 
	 * @param hbGms
	 *            the hb_gms value
	 */
	public void setHbGms(java.lang.String hbGms) {
		this.hbGms = hbGms;
	}

	/**
	 * Return the value associated with the column: next_visit_on
	 */
	public java.util.Date getNextVisitOn() {
		return nextVisitOn;
	}

	/**
	 * Set the value related to the column: next_visit_on
	 * 
	 * @param nextVisitOn
	 *            the next_visit_on value
	 */
	public void setNextVisitOn(java.util.Date nextVisitOn) {
		this.nextVisitOn = nextVisitOn;
	}

	/**
	 * Return the value associated with the column: advice
	 */
	public java.lang.String getAdvice() {
		return advice;
	}

	/**
	 * Set the value related to the column: advice
	 * 
	 * @param advice
	 *            the advice value
	 */
	public void setAdvice(java.lang.String advice) {
		this.advice = advice;
	}

	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.Integer getLastChgBy() {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * 
	 * @param lastChgBy
	 *            the last_chg_by value
	 */
	public void setLastChgBy(java.lang.Integer lastChgBy) {
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
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus() {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * 
	 * @param status
	 *            the status value
	 */
	public void setStatus(java.lang.String status) {
		this.status = status;
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
	 * Return the value associated with the column: visit_id
	 */
	public jkt.hms.masters.business.Visit getVisit() {
		return visit;
	}

	/**
	 * Set the value related to the column: visit_id
	 * 
	 * @param visit
	 *            the visit_id value
	 */
	public void setVisit(jkt.hms.masters.business.Visit visit) {
		this.visit = visit;
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

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.OpdAntenatalCard))
			return false;
		else {
			jkt.hms.masters.business.OpdAntenatalCard opdAntenatalCard = (jkt.hms.masters.business.OpdAntenatalCard) obj;
			if (null == this.getId() || null == opdAntenatalCard.getId())
				return false;
			else
				return (this.getId().equals(opdAntenatalCard.getId()));
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
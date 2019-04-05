package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ot_pre_anesthesia_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ot_pre_anesthesia_details"
 */

public abstract class BaseOtPreAnesthesiaDetails  implements Serializable {

	public static String REF = "OtPreAnesthesiaDetails";
	public static String PROP_REVIEW_BP = "ReviewBp";
	public static String PROP_PHOSPHORUS = "Phosphorus";
	public static String PROP_CT = "Ct";
	public static String PROP_LDL = "Ldl";
	public static String PROP_SGPT = "Sgpt";
	public static String PROP_LDH = "Ldh";
	public static String PROP_CL = "Cl";
	public static String PROP_PAST_PARENTAL = "PastParental";
	public static String PROP_REVIEW_RS = "ReviewRs";
	public static String PROP_ANASHTEIC_DETAILS = "AnashteicDetails";
	public static String PROP_CHANGED_TIME = "ChangedTime";
	public static String PROP_ECG_DONE_ON = "EcgDoneOn";
	public static String PROP_DIET_CATEGORY = "DietCategory";
	public static String PROP_CHOLESTEROL = "Cholesterol";
	public static String PROP_RADIOGRAPHY_CHEST = "RadiographyChest";
	public static String PROP_PCV = "Pcv";
	public static String PROP_ADV_SOUND = "AdvSound";
	public static String PROP_SGOT = "Sgot";
	public static String PROP_CONSENT_STATUS = "ConsentStatus";
	public static String PROP_INSTRUCTIONS = "Instructions";
	public static String PROP_PULSE = "Pulse";
	public static String PROP_HCO = "Hco";
	public static String PROP_REVIEW_OTHER = "ReviewOther";
	public static String PROP_ASA_GRADE = "AsaGrade";
	public static String PROP_TEETH = "Teeth";
	public static String PROP_ESR = "Esr";
	public static String PROP_E = "E";
	public static String PROP_B = "B";
	public static String PROP_S_CREATINENE = "SCreatinene";
	public static String PROP_L = "L";
	public static String PROP_SR_ELECTROLYTE = "SrElectrolyte";
	public static String PROP_M = "M";
	public static String PROP_N = "N";
	public static String PROP_MO = "Mo";
	public static String PROP_CLUBBING = "Clubbing";
	public static String PROP_CONTROL = "Control";
	public static String PROP_K = "K";
	public static String PROP_BLOOD_UREA = "BloodUrea";
	public static String PROP_ASA_GRADE_ACCEPTANCE = "AsaGradeAcceptance";
	public static String PROP_CONSULT_DEPT = "ConsultDept";
	public static String PROP_HDL = "Hdl";
	public static String PROP_PENDING_DEPT = "PendingDept";
	public static String PROP_FIT_FOR_SURGERY = "FitForSurgery";
	public static String PROP_SL_NO = "SlNo";
	public static String PROP_PREV_TREATMENT_SURGERY = "PrevTreatmentSurgery";
	public static String PROP_NA = "Na";
	public static String PROP_URINE_RE_ME = "UrineReMe";
	public static String PROP_ADDTIONAL_REMARKS = "AddtionalRemarks";
	public static String PROP_SPLEEN = "Spleen";
	public static String PROP_ASA_RISK = "AsaRisk";
	public static String PROP_AMYLASE = "Amylase";
	public static String PROP_DRUG_TREATMENT = "DrugTreatment";
	public static String PROP_LYMPHADENOPATHY = "Lymphadenopathy";
	public static String PROP_REVIEW_QP = "ReviewQp";
	public static String PROP_SPINE = "Spine";
	public static String PROP_PALLOR = "Pallor";
	public static String PROP_PATIENT_STATUS = "PatientStatus";
	public static String PROP_LIVER = "Liver";
	public static String PROP_PLATELETS = "Platelets";
	public static String PROP_CONSULT_OTHER_DOCTOR = "ConsultOtherDoctor";
	public static String PROP_INORGANIC = "Inorganic";
	public static String PROP_RADIOGRAPHY_CHEST_DONE_ON = "RadiographyChestDoneOn";
	public static String PROP_AEC = "Aec";
	public static String PROP_S2 = "S2";
	public static String PROP_S1 = "S1";
	public static String PROP_PENDING_DOCTOR = "PendingDoctor";
	public static String PROP_ALP = "Alp";
	public static String PROP_ECG = "Ecg";
	public static String PROP_URIC_ACID = "UricAcid";
	public static String PROP_CHANGED_BY = "ChangedBy";
	public static String PROP_VLDL = "Vldl";
	public static String PROP_ORDER_NO = "OrderNo";
	public static String PROP_CYANOSIS = "Cyanosis";
	public static String PROP_HB = "Hb";
	public static String PROP_TRYGLYCERIDE = "Tryglyceride";
	public static String PROP_REVIEW_CVS = "ReviewCvs";
	public static String PROP_NOURISHMENT = "Nourishment";
	public static String PROP_OEDEMA = "Oedema";
	public static String PROP_ABDOMEN = "Abdomen";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_AG_RADIO = "AgRadio";
	public static String PROP_OTHER = "Other";
	public static String PROP_THYROID = "Thyroid";
	public static String PROP_INVESTIGATION_PATIENT = "InvestigationPatient";
	public static String PROP_ICETRUS = "Icetrus";
	public static String PROP_PATIENT_TYPE = "PatientType";
	public static String PROP_VISIT = "Visit";
	public static String PROP_SMOKING_ALCOHOL = "SmokingAlcohol";
	public static String PROP_BLOOD_GROUP = "BloodGroup";
	public static String PROP_TSH = "Tsh";
	public static String PROP_ID = "Id";
	public static String PROP_MPC = "Mpc";
	public static String PROP_BLOOD_SUGAR_FASTING = "BloodSugarFasting";
	public static String PROP_GLOBULIN = "Globulin";
	public static String PROP_TLC = "Tlc";
	public static String PROP_BREATH_SOUND = "BreathSound";
	public static String PROP_H_BS_A_G = "HBsAG";
	public static String PROP_KOILONYCHIA = "Koilonychia";
	public static String PROP_T4 = "T4";
	public static String PROP_RS = "Rs";
	public static String PROP_TOTAL_PROTEIN = "TotalProtein";
	public static String PROP_BILIRUBIN = "Bilirubin";
	public static String PROP_AIRWAY = "Airway";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_CNS = "Cns";
	public static String PROP_CONSULT_DOCTOR = "ConsultDoctor";
	public static String PROP_CVS = "Cvs";
	public static String PROP_TMD = "Tmd";
	public static String PROP_HIV = "Hiv";
	public static String PROP_BT = "Bt";
	public static String PROP_OPD_SURGERY_HEADER = "OpdSurgeryHeader";
	public static String PROP_ANESTHTIC_TECHNIQUE = "AnesthticTechnique";
	public static String PROP_CA = "Ca";
	public static String PROP_REVIEW_COMPLAINTS = "ReviewComplaints";
	public static String PROP_T3 = "T3";
	public static String PROP_CHANGED_DATE = "ChangedDate";
	public static String PROP_S3 = "S3";
	public static String PROP_S4 = "S4";
	public static String PROP_BLOOD = "Blood";
	public static String PROP_VENOUS_ACCESS = "VenousAccess";
	public static String PROP_ALBUMIN = "Albumin";
	public static String PROP_BP = "Bp";
	public static String PROP_TMJ = "Tmj";
	public static String PROP_VDKL = "Vdkl";
	public static String PROP_PAC_DATE = "PacDate";
	public static String PROP_REMARK = "Remark";
	public static String PROP_RANDOM = "Random";
	public static String PROP_LFT = "Lft";
	public static String PROP_HIN = "Hin";


	// constructors
	public BaseOtPreAnesthesiaDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOtPreAnesthesiaDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer slNo;
	private java.lang.String smokingAlcohol;
	private java.lang.String prevTreatmentSurgery;
	private java.lang.String pulse;
	private java.lang.String pallor;
	private java.lang.String cyanosis;
	private java.lang.String clubbing;
	private java.lang.String icetrus;
	private java.lang.String oedema;
	private java.lang.String spine;
	private java.lang.String thyroid;
	private java.lang.String nourishment;
	private java.lang.String bp;
	private java.lang.String airway;
	private java.lang.String venousAccess;
	private java.lang.String breathSound;
	private java.lang.String advSound;
	private java.lang.String abdomen;
	private java.lang.String liver;
	private java.lang.String spleen;
	private java.lang.String asaGrade;
	private java.lang.String blood;
	private java.lang.String instructions;
	private java.lang.String s1;
	private java.lang.String s2;
	private java.lang.String s3;
	private java.lang.String s4;
	private java.lang.Integer orderNo;
	private java.util.Date pacDate;
	private java.util.Date changedBy;
	private java.util.Date changedDate;
	private java.lang.String changedTime;
	private java.lang.String patientType;
	private java.lang.String anesthticTechnique;
	private java.lang.String drugTreatment;
	private java.lang.String dietCategory;
	private java.lang.String asaGradeAcceptance;
	private java.lang.String patientStatus;
	private java.lang.String ecg;
	private java.util.Date ecgDoneOn;
	private java.lang.String radiographyChest;
	private java.util.Date radiographyChestDoneOn;
	private java.lang.String hb;
	private java.lang.String tlc;
	private java.lang.String n;
	private java.lang.String e;
	private java.lang.String b;
	private java.lang.String m;
	private java.lang.String l;
	private java.lang.String esr;
	private java.lang.String bt;
	private java.lang.String ct;
	private java.lang.String pcv;
	private java.lang.String platelets;
	private java.lang.String aec;
	private java.lang.String control;
	private java.lang.String investigationPatient;
	private java.lang.String bloodGroup;
	private java.lang.String bloodSugarFasting;
	private java.lang.String bloodUrea;
	private java.lang.String pastParental;
	private java.lang.String sCreatinene;
	private java.lang.String random;
	private java.lang.String uricAcid;
	private java.lang.String t3;
	private java.lang.String cholesterol;
	private java.lang.String na;
	private java.lang.String t4;
	private java.lang.String tsh;
	private java.lang.String tryglyceride;
	private java.lang.String k;
	private java.lang.String hBsAG;
	private java.lang.String hdl;
	private java.lang.String cl;
	private java.lang.String hiv;
	private java.lang.String ldl;
	private java.lang.String hco;
	private java.lang.String vdkl;
	private java.lang.String vldl;
	private java.lang.String srElectrolyte;
	private java.lang.String lft;
	private java.lang.String bilirubin;
	private java.lang.String sgot;
	private java.lang.String ca;
	private java.lang.String totalProtein;
	private java.lang.String sgpt;
	private java.lang.String inorganic;
	private java.lang.String albumin;
	private java.lang.String alp;
	private java.lang.String phosphorus;
	private java.lang.String globulin;
	private java.lang.String amylase;
	private java.lang.String agRadio;
	private java.lang.String ldh;
	private java.lang.String urineReMe;
	private java.lang.String anashteicDetails;
	private java.lang.String mpc;
	private java.lang.String tmd;
	private java.lang.String tmj;
	private java.lang.String mo;
	private java.lang.String teeth;
	private java.lang.String cvs;
	private java.lang.String rs;
	private java.lang.String cns;
	private java.lang.String reviewComplaints;
	private java.lang.String reviewQp;
	private java.lang.String reviewBp;
	private java.lang.String reviewCvs;
	private java.lang.String reviewRs;
	private java.lang.String reviewOther;
	private java.lang.String asaRisk;
	private java.lang.String remark;
	private java.lang.String consentStatus;
	private java.lang.String fitForSurgery;
	private java.lang.String koilonychia;
	private java.lang.String lymphadenopathy;
	private java.lang.String addtionalRemarks;
	private java.lang.String consultOtherDoctor;
	private java.lang.String other;

	// many to one
	private jkt.hms.masters.business.OpdSurgeryHeader opdSurgeryHeader;
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasEmployee pendingDoctor;
	private jkt.hms.masters.business.MasDepartment consultDept;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.MasEmployee consultDoctor;
	private jkt.hms.masters.business.MasDepartment pendingDept;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
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
	 * Return the value associated with the column: sl_no
	 */
	public java.lang.Integer getSlNo () {
		return slNo;
	}

	/**
	 * Set the value related to the column: sl_no
	 * @param slNo the sl_no value
	 */
	public void setSlNo (java.lang.Integer slNo) {
		this.slNo = slNo;
	}



	/**
	 * Return the value associated with the column: smoking_alcohol
	 */
	public java.lang.String getSmokingAlcohol () {
		return smokingAlcohol;
	}

	/**
	 * Set the value related to the column: smoking_alcohol
	 * @param smokingAlcohol the smoking_alcohol value
	 */
	public void setSmokingAlcohol (java.lang.String smokingAlcohol) {
		this.smokingAlcohol = smokingAlcohol;
	}



	/**
	 * Return the value associated with the column: prev_treatment_surgery
	 */
	public java.lang.String getPrevTreatmentSurgery () {
		return prevTreatmentSurgery;
	}

	/**
	 * Set the value related to the column: prev_treatment_surgery
	 * @param prevTreatmentSurgery the prev_treatment_surgery value
	 */
	public void setPrevTreatmentSurgery (java.lang.String prevTreatmentSurgery) {
		this.prevTreatmentSurgery = prevTreatmentSurgery;
	}



	/**
	 * Return the value associated with the column: pulse
	 */
	public java.lang.String getPulse () {
		return pulse;
	}

	/**
	 * Set the value related to the column: pulse
	 * @param pulse the pulse value
	 */
	public void setPulse (java.lang.String pulse) {
		this.pulse = pulse;
	}



	/**
	 * Return the value associated with the column: pallor
	 */
	public java.lang.String getPallor () {
		return pallor;
	}

	/**
	 * Set the value related to the column: pallor
	 * @param pallor the pallor value
	 */
	public void setPallor (java.lang.String pallor) {
		this.pallor = pallor;
	}



	/**
	 * Return the value associated with the column: cyanosis
	 */
	public java.lang.String getCyanosis () {
		return cyanosis;
	}

	/**
	 * Set the value related to the column: cyanosis
	 * @param cyanosis the cyanosis value
	 */
	public void setCyanosis (java.lang.String cyanosis) {
		this.cyanosis = cyanosis;
	}



	/**
	 * Return the value associated with the column: clubbing
	 */
	public java.lang.String getClubbing () {
		return clubbing;
	}

	/**
	 * Set the value related to the column: clubbing
	 * @param clubbing the clubbing value
	 */
	public void setClubbing (java.lang.String clubbing) {
		this.clubbing = clubbing;
	}



	/**
	 * Return the value associated with the column: icetrus
	 */
	public java.lang.String getIcetrus () {
		return icetrus;
	}

	/**
	 * Set the value related to the column: icetrus
	 * @param icetrus the icetrus value
	 */
	public void setIcetrus (java.lang.String icetrus) {
		this.icetrus = icetrus;
	}



	/**
	 * Return the value associated with the column: oedema
	 */
	public java.lang.String getOedema () {
		return oedema;
	}

	/**
	 * Set the value related to the column: oedema
	 * @param oedema the oedema value
	 */
	public void setOedema (java.lang.String oedema) {
		this.oedema = oedema;
	}



	/**
	 * Return the value associated with the column: spine
	 */
	public java.lang.String getSpine () {
		return spine;
	}

	/**
	 * Set the value related to the column: spine
	 * @param spine the spine value
	 */
	public void setSpine (java.lang.String spine) {
		this.spine = spine;
	}



	/**
	 * Return the value associated with the column: thyroid
	 */
	public java.lang.String getThyroid () {
		return thyroid;
	}

	/**
	 * Set the value related to the column: thyroid
	 * @param thyroid the thyroid value
	 */
	public void setThyroid (java.lang.String thyroid) {
		this.thyroid = thyroid;
	}



	/**
	 * Return the value associated with the column: nourishment
	 */
	public java.lang.String getNourishment () {
		return nourishment;
	}

	/**
	 * Set the value related to the column: nourishment
	 * @param nourishment the nourishment value
	 */
	public void setNourishment (java.lang.String nourishment) {
		this.nourishment = nourishment;
	}



	/**
	 * Return the value associated with the column: bp
	 */
	public java.lang.String getBp () {
		return bp;
	}

	/**
	 * Set the value related to the column: bp
	 * @param bp the bp value
	 */
	public void setBp (java.lang.String bp) {
		this.bp = bp;
	}



	/**
	 * Return the value associated with the column: airway
	 */
	public java.lang.String getAirway () {
		return airway;
	}

	/**
	 * Set the value related to the column: airway
	 * @param airway the airway value
	 */
	public void setAirway (java.lang.String airway) {
		this.airway = airway;
	}



	/**
	 * Return the value associated with the column: venous_access
	 */
	public java.lang.String getVenousAccess () {
		return venousAccess;
	}

	/**
	 * Set the value related to the column: venous_access
	 * @param venousAccess the venous_access value
	 */
	public void setVenousAccess (java.lang.String venousAccess) {
		this.venousAccess = venousAccess;
	}



	/**
	 * Return the value associated with the column: breath_sound
	 */
	public java.lang.String getBreathSound () {
		return breathSound;
	}

	/**
	 * Set the value related to the column: breath_sound
	 * @param breathSound the breath_sound value
	 */
	public void setBreathSound (java.lang.String breathSound) {
		this.breathSound = breathSound;
	}



	/**
	 * Return the value associated with the column: adv_sound
	 */
	public java.lang.String getAdvSound () {
		return advSound;
	}

	/**
	 * Set the value related to the column: adv_sound
	 * @param advSound the adv_sound value
	 */
	public void setAdvSound (java.lang.String advSound) {
		this.advSound = advSound;
	}



	/**
	 * Return the value associated with the column: abdomen
	 */
	public java.lang.String getAbdomen () {
		return abdomen;
	}

	/**
	 * Set the value related to the column: abdomen
	 * @param abdomen the abdomen value
	 */
	public void setAbdomen (java.lang.String abdomen) {
		this.abdomen = abdomen;
	}



	/**
	 * Return the value associated with the column: liver
	 */
	public java.lang.String getLiver () {
		return liver;
	}

	/**
	 * Set the value related to the column: liver
	 * @param liver the liver value
	 */
	public void setLiver (java.lang.String liver) {
		this.liver = liver;
	}



	/**
	 * Return the value associated with the column: spleen
	 */
	public java.lang.String getSpleen () {
		return spleen;
	}

	/**
	 * Set the value related to the column: spleen
	 * @param spleen the spleen value
	 */
	public void setSpleen (java.lang.String spleen) {
		this.spleen = spleen;
	}



	/**
	 * Return the value associated with the column: asa_grade
	 */
	public java.lang.String getAsaGrade () {
		return asaGrade;
	}

	/**
	 * Set the value related to the column: asa_grade
	 * @param asaGrade the asa_grade value
	 */
	public void setAsaGrade (java.lang.String asaGrade) {
		this.asaGrade = asaGrade;
	}



	/**
	 * Return the value associated with the column: blood
	 */
	public java.lang.String getBlood () {
		return blood;
	}

	/**
	 * Set the value related to the column: blood
	 * @param blood the blood value
	 */
	public void setBlood (java.lang.String blood) {
		this.blood = blood;
	}



	/**
	 * Return the value associated with the column: instructions
	 */
	public java.lang.String getInstructions () {
		return instructions;
	}

	/**
	 * Set the value related to the column: instructions
	 * @param instructions the instructions value
	 */
	public void setInstructions (java.lang.String instructions) {
		this.instructions = instructions;
	}



	/**
	 * Return the value associated with the column: s1
	 */
	public java.lang.String getS1 () {
		return s1;
	}

	/**
	 * Set the value related to the column: s1
	 * @param s1 the s1 value
	 */
	public void setS1 (java.lang.String s1) {
		this.s1 = s1;
	}



	/**
	 * Return the value associated with the column: s2
	 */
	public java.lang.String getS2 () {
		return s2;
	}

	/**
	 * Set the value related to the column: s2
	 * @param s2 the s2 value
	 */
	public void setS2 (java.lang.String s2) {
		this.s2 = s2;
	}



	/**
	 * Return the value associated with the column: s3
	 */
	public java.lang.String getS3 () {
		return s3;
	}

	/**
	 * Set the value related to the column: s3
	 * @param s3 the s3 value
	 */
	public void setS3 (java.lang.String s3) {
		this.s3 = s3;
	}



	/**
	 * Return the value associated with the column: s4
	 */
	public java.lang.String getS4 () {
		return s4;
	}

	/**
	 * Set the value related to the column: s4
	 * @param s4 the s4 value
	 */
	public void setS4 (java.lang.String s4) {
		this.s4 = s4;
	}



	/**
	 * Return the value associated with the column: order_no
	 */
	public java.lang.Integer getOrderNo () {
		return orderNo;
	}

	/**
	 * Set the value related to the column: order_no
	 * @param orderNo the order_no value
	 */
	public void setOrderNo (java.lang.Integer orderNo) {
		this.orderNo = orderNo;
	}



	/**
	 * Return the value associated with the column: pac_date
	 */
	public java.util.Date getPacDate () {
		return pacDate;
	}

	/**
	 * Set the value related to the column: pac_date
	 * @param pacDate the pac_date value
	 */
	public void setPacDate (java.util.Date pacDate) {
		this.pacDate = pacDate;
	}



	/**
	 * Return the value associated with the column: changed_by
	 */
	public java.util.Date getChangedBy () {
		return changedBy;
	}

	/**
	 * Set the value related to the column: changed_by
	 * @param changedBy the changed_by value
	 */
	public void setChangedBy (java.util.Date changedBy) {
		this.changedBy = changedBy;
	}



	/**
	 * Return the value associated with the column: changed_date
	 */
	public java.util.Date getChangedDate () {
		return changedDate;
	}

	/**
	 * Set the value related to the column: changed_date
	 * @param changedDate the changed_date value
	 */
	public void setChangedDate (java.util.Date changedDate) {
		this.changedDate = changedDate;
	}



	/**
	 * Return the value associated with the column: changed_time
	 */
	public java.lang.String getChangedTime () {
		return changedTime;
	}

	/**
	 * Set the value related to the column: changed_time
	 * @param changedTime the changed_time value
	 */
	public void setChangedTime (java.lang.String changedTime) {
		this.changedTime = changedTime;
	}



	/**
	 * Return the value associated with the column: patient_type
	 */
	public java.lang.String getPatientType () {
		return patientType;
	}

	/**
	 * Set the value related to the column: patient_type
	 * @param patientType the patient_type value
	 */
	public void setPatientType (java.lang.String patientType) {
		this.patientType = patientType;
	}



	/**
	 * Return the value associated with the column: Anesthtic_technique
	 */
	public java.lang.String getAnesthticTechnique () {
		return anesthticTechnique;
	}

	/**
	 * Set the value related to the column: Anesthtic_technique
	 * @param anesthticTechnique the Anesthtic_technique value
	 */
	public void setAnesthticTechnique (java.lang.String anesthticTechnique) {
		this.anesthticTechnique = anesthticTechnique;
	}



	/**
	 * Return the value associated with the column: drug_treatment
	 */
	public java.lang.String getDrugTreatment () {
		return drugTreatment;
	}

	/**
	 * Set the value related to the column: drug_treatment
	 * @param drugTreatment the drug_treatment value
	 */
	public void setDrugTreatment (java.lang.String drugTreatment) {
		this.drugTreatment = drugTreatment;
	}



	/**
	 * Return the value associated with the column: diet_category
	 */
	public java.lang.String getDietCategory () {
		return dietCategory;
	}

	/**
	 * Set the value related to the column: diet_category
	 * @param dietCategory the diet_category value
	 */
	public void setDietCategory (java.lang.String dietCategory) {
		this.dietCategory = dietCategory;
	}



	/**
	 * Return the value associated with the column: asa_grade_acceptance
	 */
	public java.lang.String getAsaGradeAcceptance () {
		return asaGradeAcceptance;
	}

	/**
	 * Set the value related to the column: asa_grade_acceptance
	 * @param asaGradeAcceptance the asa_grade_acceptance value
	 */
	public void setAsaGradeAcceptance (java.lang.String asaGradeAcceptance) {
		this.asaGradeAcceptance = asaGradeAcceptance;
	}



	/**
	 * Return the value associated with the column: patient_status
	 */
	public java.lang.String getPatientStatus () {
		return patientStatus;
	}

	/**
	 * Set the value related to the column: patient_status
	 * @param patientStatus the patient_status value
	 */
	public void setPatientStatus (java.lang.String patientStatus) {
		this.patientStatus = patientStatus;
	}



	/**
	 * Return the value associated with the column: ecg
	 */
	public java.lang.String getEcg () {
		return ecg;
	}

	/**
	 * Set the value related to the column: ecg
	 * @param ecg the ecg value
	 */
	public void setEcg (java.lang.String ecg) {
		this.ecg = ecg;
	}



	/**
	 * Return the value associated with the column: ecg_done_on
	 */
	public java.util.Date getEcgDoneOn () {
		return ecgDoneOn;
	}

	/**
	 * Set the value related to the column: ecg_done_on
	 * @param ecgDoneOn the ecg_done_on value
	 */
	public void setEcgDoneOn (java.util.Date ecgDoneOn) {
		this.ecgDoneOn = ecgDoneOn;
	}



	/**
	 * Return the value associated with the column: radiography_chest
	 */
	public java.lang.String getRadiographyChest () {
		return radiographyChest;
	}

	/**
	 * Set the value related to the column: radiography_chest
	 * @param radiographyChest the radiography_chest value
	 */
	public void setRadiographyChest (java.lang.String radiographyChest) {
		this.radiographyChest = radiographyChest;
	}



	/**
	 * Return the value associated with the column: radiography_chest_done_on
	 */
	public java.util.Date getRadiographyChestDoneOn () {
		return radiographyChestDoneOn;
	}

	/**
	 * Set the value related to the column: radiography_chest_done_on
	 * @param radiographyChestDoneOn the radiography_chest_done_on value
	 */
	public void setRadiographyChestDoneOn (java.util.Date radiographyChestDoneOn) {
		this.radiographyChestDoneOn = radiographyChestDoneOn;
	}



	/**
	 * Return the value associated with the column: hb
	 */
	public java.lang.String getHb () {
		return hb;
	}

	/**
	 * Set the value related to the column: hb
	 * @param hb the hb value
	 */
	public void setHb (java.lang.String hb) {
		this.hb = hb;
	}



	/**
	 * Return the value associated with the column: tlc
	 */
	public java.lang.String getTlc () {
		return tlc;
	}

	/**
	 * Set the value related to the column: tlc
	 * @param tlc the tlc value
	 */
	public void setTlc (java.lang.String tlc) {
		this.tlc = tlc;
	}



	/**
	 * Return the value associated with the column: n
	 */
	public java.lang.String getN () {
		return n;
	}

	/**
	 * Set the value related to the column: n
	 * @param n the n value
	 */
	public void setN (java.lang.String n) {
		this.n = n;
	}



	/**
	 * Return the value associated with the column: e
	 */
	public java.lang.String getE () {
		return e;
	}

	/**
	 * Set the value related to the column: e
	 * @param e the e value
	 */
	public void setE (java.lang.String e) {
		this.e = e;
	}



	/**
	 * Return the value associated with the column: b
	 */
	public java.lang.String getB () {
		return b;
	}

	/**
	 * Set the value related to the column: b
	 * @param b the b value
	 */
	public void setB (java.lang.String b) {
		this.b = b;
	}



	/**
	 * Return the value associated with the column: m
	 */
	public java.lang.String getM () {
		return m;
	}

	/**
	 * Set the value related to the column: m
	 * @param m the m value
	 */
	public void setM (java.lang.String m) {
		this.m = m;
	}



	/**
	 * Return the value associated with the column: l
	 */
	public java.lang.String getL () {
		return l;
	}

	/**
	 * Set the value related to the column: l
	 * @param l the l value
	 */
	public void setL (java.lang.String l) {
		this.l = l;
	}



	/**
	 * Return the value associated with the column: esr
	 */
	public java.lang.String getEsr () {
		return esr;
	}

	/**
	 * Set the value related to the column: esr
	 * @param esr the esr value
	 */
	public void setEsr (java.lang.String esr) {
		this.esr = esr;
	}



	/**
	 * Return the value associated with the column: bt
	 */
	public java.lang.String getBt () {
		return bt;
	}

	/**
	 * Set the value related to the column: bt
	 * @param bt the bt value
	 */
	public void setBt (java.lang.String bt) {
		this.bt = bt;
	}



	/**
	 * Return the value associated with the column: ct
	 */
	public java.lang.String getCt () {
		return ct;
	}

	/**
	 * Set the value related to the column: ct
	 * @param ct the ct value
	 */
	public void setCt (java.lang.String ct) {
		this.ct = ct;
	}



	/**
	 * Return the value associated with the column: pcv
	 */
	public java.lang.String getPcv () {
		return pcv;
	}

	/**
	 * Set the value related to the column: pcv
	 * @param pcv the pcv value
	 */
	public void setPcv (java.lang.String pcv) {
		this.pcv = pcv;
	}



	/**
	 * Return the value associated with the column: platelets
	 */
	public java.lang.String getPlatelets () {
		return platelets;
	}

	/**
	 * Set the value related to the column: platelets
	 * @param platelets the platelets value
	 */
	public void setPlatelets (java.lang.String platelets) {
		this.platelets = platelets;
	}



	/**
	 * Return the value associated with the column: aec
	 */
	public java.lang.String getAec () {
		return aec;
	}

	/**
	 * Set the value related to the column: aec
	 * @param aec the aec value
	 */
	public void setAec (java.lang.String aec) {
		this.aec = aec;
	}



	/**
	 * Return the value associated with the column: control
	 */
	public java.lang.String getControl () {
		return control;
	}

	/**
	 * Set the value related to the column: control
	 * @param control the control value
	 */
	public void setControl (java.lang.String control) {
		this.control = control;
	}



	/**
	 * Return the value associated with the column: investigation_patient
	 */
	public java.lang.String getInvestigationPatient () {
		return investigationPatient;
	}

	/**
	 * Set the value related to the column: investigation_patient
	 * @param investigationPatient the investigation_patient value
	 */
	public void setInvestigationPatient (java.lang.String investigationPatient) {
		this.investigationPatient = investigationPatient;
	}



	/**
	 * Return the value associated with the column: blood_group
	 */
	public java.lang.String getBloodGroup () {
		return bloodGroup;
	}

	/**
	 * Set the value related to the column: blood_group
	 * @param bloodGroup the blood_group value
	 */
	public void setBloodGroup (java.lang.String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}



	/**
	 * Return the value associated with the column: blood_sugar_fasting
	 */
	public java.lang.String getBloodSugarFasting () {
		return bloodSugarFasting;
	}

	/**
	 * Set the value related to the column: blood_sugar_fasting
	 * @param bloodSugarFasting the blood_sugar_fasting value
	 */
	public void setBloodSugarFasting (java.lang.String bloodSugarFasting) {
		this.bloodSugarFasting = bloodSugarFasting;
	}



	/**
	 * Return the value associated with the column: blood_urea
	 */
	public java.lang.String getBloodUrea () {
		return bloodUrea;
	}

	/**
	 * Set the value related to the column: blood_urea
	 * @param bloodUrea the blood_urea value
	 */
	public void setBloodUrea (java.lang.String bloodUrea) {
		this.bloodUrea = bloodUrea;
	}



	/**
	 * Return the value associated with the column: past_parental
	 */
	public java.lang.String getPastParental () {
		return pastParental;
	}

	/**
	 * Set the value related to the column: past_parental
	 * @param pastParental the past_parental value
	 */
	public void setPastParental (java.lang.String pastParental) {
		this.pastParental = pastParental;
	}



	/**
	 * Return the value associated with the column: s_creatinene
	 */
	public java.lang.String getSCreatinene () {
		return sCreatinene;
	}

	/**
	 * Set the value related to the column: s_creatinene
	 * @param sCreatinene the s_creatinene value
	 */
	public void setSCreatinene (java.lang.String sCreatinene) {
		this.sCreatinene = sCreatinene;
	}



	/**
	 * Return the value associated with the column: random
	 */
	public java.lang.String getRandom () {
		return random;
	}

	/**
	 * Set the value related to the column: random
	 * @param random the random value
	 */
	public void setRandom (java.lang.String random) {
		this.random = random;
	}



	/**
	 * Return the value associated with the column: uric_acid
	 */
	public java.lang.String getUricAcid () {
		return uricAcid;
	}

	/**
	 * Set the value related to the column: uric_acid
	 * @param uricAcid the uric_acid value
	 */
	public void setUricAcid (java.lang.String uricAcid) {
		this.uricAcid = uricAcid;
	}



	/**
	 * Return the value associated with the column: t3
	 */
	public java.lang.String getT3 () {
		return t3;
	}

	/**
	 * Set the value related to the column: t3
	 * @param t3 the t3 value
	 */
	public void setT3 (java.lang.String t3) {
		this.t3 = t3;
	}



	/**
	 * Return the value associated with the column: cholesterol
	 */
	public java.lang.String getCholesterol () {
		return cholesterol;
	}

	/**
	 * Set the value related to the column: cholesterol
	 * @param cholesterol the cholesterol value
	 */
	public void setCholesterol (java.lang.String cholesterol) {
		this.cholesterol = cholesterol;
	}



	/**
	 * Return the value associated with the column: Na
	 */
	public java.lang.String getNa () {
		return na;
	}

	/**
	 * Set the value related to the column: Na
	 * @param na the Na value
	 */
	public void setNa (java.lang.String na) {
		this.na = na;
	}



	/**
	 * Return the value associated with the column: t4
	 */
	public java.lang.String getT4 () {
		return t4;
	}

	/**
	 * Set the value related to the column: t4
	 * @param t4 the t4 value
	 */
	public void setT4 (java.lang.String t4) {
		this.t4 = t4;
	}



	/**
	 * Return the value associated with the column: tsh
	 */
	public java.lang.String getTsh () {
		return tsh;
	}

	/**
	 * Set the value related to the column: tsh
	 * @param tsh the tsh value
	 */
	public void setTsh (java.lang.String tsh) {
		this.tsh = tsh;
	}



	/**
	 * Return the value associated with the column: tryglyceride
	 */
	public java.lang.String getTryglyceride () {
		return tryglyceride;
	}

	/**
	 * Set the value related to the column: tryglyceride
	 * @param tryglyceride the tryglyceride value
	 */
	public void setTryglyceride (java.lang.String tryglyceride) {
		this.tryglyceride = tryglyceride;
	}



	/**
	 * Return the value associated with the column: K
	 */
	public java.lang.String getK () {
		return k;
	}

	/**
	 * Set the value related to the column: K
	 * @param k the K value
	 */
	public void setK (java.lang.String k) {
		this.k = k;
	}



	/**
	 * Return the value associated with the column: HBsAG
	 */
	public java.lang.String getHBsAG () {
		return hBsAG;
	}

	/**
	 * Set the value related to the column: HBsAG
	 * @param hBsAG the HBsAG value
	 */
	public void setHBsAG (java.lang.String hBsAG) {
		this.hBsAG = hBsAG;
	}



	/**
	 * Return the value associated with the column: hdl
	 */
	public java.lang.String getHdl () {
		return hdl;
	}

	/**
	 * Set the value related to the column: hdl
	 * @param hdl the hdl value
	 */
	public void setHdl (java.lang.String hdl) {
		this.hdl = hdl;
	}



	/**
	 * Return the value associated with the column: cl
	 */
	public java.lang.String getCl () {
		return cl;
	}

	/**
	 * Set the value related to the column: cl
	 * @param cl the cl value
	 */
	public void setCl (java.lang.String cl) {
		this.cl = cl;
	}



	/**
	 * Return the value associated with the column: hiv
	 */
	public java.lang.String getHiv () {
		return hiv;
	}

	/**
	 * Set the value related to the column: hiv
	 * @param hiv the hiv value
	 */
	public void setHiv (java.lang.String hiv) {
		this.hiv = hiv;
	}



	/**
	 * Return the value associated with the column: ldl
	 */
	public java.lang.String getLdl () {
		return ldl;
	}

	/**
	 * Set the value related to the column: ldl
	 * @param ldl the ldl value
	 */
	public void setLdl (java.lang.String ldl) {
		this.ldl = ldl;
	}



	/**
	 * Return the value associated with the column: hco
	 */
	public java.lang.String getHco () {
		return hco;
	}

	/**
	 * Set the value related to the column: hco
	 * @param hco the hco value
	 */
	public void setHco (java.lang.String hco) {
		this.hco = hco;
	}



	/**
	 * Return the value associated with the column: vdkl
	 */
	public java.lang.String getVdkl () {
		return vdkl;
	}

	/**
	 * Set the value related to the column: vdkl
	 * @param vdkl the vdkl value
	 */
	public void setVdkl (java.lang.String vdkl) {
		this.vdkl = vdkl;
	}



	/**
	 * Return the value associated with the column: vldl
	 */
	public java.lang.String getVldl () {
		return vldl;
	}

	/**
	 * Set the value related to the column: vldl
	 * @param vldl the vldl value
	 */
	public void setVldl (java.lang.String vldl) {
		this.vldl = vldl;
	}



	/**
	 * Return the value associated with the column: sr_electrolyte
	 */
	public java.lang.String getSrElectrolyte () {
		return srElectrolyte;
	}

	/**
	 * Set the value related to the column: sr_electrolyte
	 * @param srElectrolyte the sr_electrolyte value
	 */
	public void setSrElectrolyte (java.lang.String srElectrolyte) {
		this.srElectrolyte = srElectrolyte;
	}



	/**
	 * Return the value associated with the column: lft
	 */
	public java.lang.String getLft () {
		return lft;
	}

	/**
	 * Set the value related to the column: lft
	 * @param lft the lft value
	 */
	public void setLft (java.lang.String lft) {
		this.lft = lft;
	}



	/**
	 * Return the value associated with the column: bilirubin
	 */
	public java.lang.String getBilirubin () {
		return bilirubin;
	}

	/**
	 * Set the value related to the column: bilirubin
	 * @param bilirubin the bilirubin value
	 */
	public void setBilirubin (java.lang.String bilirubin) {
		this.bilirubin = bilirubin;
	}



	/**
	 * Return the value associated with the column: sgot
	 */
	public java.lang.String getSgot () {
		return sgot;
	}

	/**
	 * Set the value related to the column: sgot
	 * @param sgot the sgot value
	 */
	public void setSgot (java.lang.String sgot) {
		this.sgot = sgot;
	}



	/**
	 * Return the value associated with the column: Ca
	 */
	public java.lang.String getCa () {
		return ca;
	}

	/**
	 * Set the value related to the column: Ca
	 * @param ca the Ca value
	 */
	public void setCa (java.lang.String ca) {
		this.ca = ca;
	}



	/**
	 * Return the value associated with the column: total_protein
	 */
	public java.lang.String getTotalProtein () {
		return totalProtein;
	}

	/**
	 * Set the value related to the column: total_protein
	 * @param totalProtein the total_protein value
	 */
	public void setTotalProtein (java.lang.String totalProtein) {
		this.totalProtein = totalProtein;
	}



	/**
	 * Return the value associated with the column: sgpt
	 */
	public java.lang.String getSgpt () {
		return sgpt;
	}

	/**
	 * Set the value related to the column: sgpt
	 * @param sgpt the sgpt value
	 */
	public void setSgpt (java.lang.String sgpt) {
		this.sgpt = sgpt;
	}



	/**
	 * Return the value associated with the column: inorganic
	 */
	public java.lang.String getInorganic () {
		return inorganic;
	}

	/**
	 * Set the value related to the column: inorganic
	 * @param inorganic the inorganic value
	 */
	public void setInorganic (java.lang.String inorganic) {
		this.inorganic = inorganic;
	}



	/**
	 * Return the value associated with the column: albumin
	 */
	public java.lang.String getAlbumin () {
		return albumin;
	}

	/**
	 * Set the value related to the column: albumin
	 * @param albumin the albumin value
	 */
	public void setAlbumin (java.lang.String albumin) {
		this.albumin = albumin;
	}



	/**
	 * Return the value associated with the column: alp
	 */
	public java.lang.String getAlp () {
		return alp;
	}

	/**
	 * Set the value related to the column: alp
	 * @param alp the alp value
	 */
	public void setAlp (java.lang.String alp) {
		this.alp = alp;
	}



	/**
	 * Return the value associated with the column: phosphorus
	 */
	public java.lang.String getPhosphorus () {
		return phosphorus;
	}

	/**
	 * Set the value related to the column: phosphorus
	 * @param phosphorus the phosphorus value
	 */
	public void setPhosphorus (java.lang.String phosphorus) {
		this.phosphorus = phosphorus;
	}



	/**
	 * Return the value associated with the column: globulin
	 */
	public java.lang.String getGlobulin () {
		return globulin;
	}

	/**
	 * Set the value related to the column: globulin
	 * @param globulin the globulin value
	 */
	public void setGlobulin (java.lang.String globulin) {
		this.globulin = globulin;
	}



	/**
	 * Return the value associated with the column: amylase
	 */
	public java.lang.String getAmylase () {
		return amylase;
	}

	/**
	 * Set the value related to the column: amylase
	 * @param amylase the amylase value
	 */
	public void setAmylase (java.lang.String amylase) {
		this.amylase = amylase;
	}



	/**
	 * Return the value associated with the column: ag_radio
	 */
	public java.lang.String getAgRadio () {
		return agRadio;
	}

	/**
	 * Set the value related to the column: ag_radio
	 * @param agRadio the ag_radio value
	 */
	public void setAgRadio (java.lang.String agRadio) {
		this.agRadio = agRadio;
	}



	/**
	 * Return the value associated with the column: ldh
	 */
	public java.lang.String getLdh () {
		return ldh;
	}

	/**
	 * Set the value related to the column: ldh
	 * @param ldh the ldh value
	 */
	public void setLdh (java.lang.String ldh) {
		this.ldh = ldh;
	}



	/**
	 * Return the value associated with the column: urine_re_me
	 */
	public java.lang.String getUrineReMe () {
		return urineReMe;
	}

	/**
	 * Set the value related to the column: urine_re_me
	 * @param urineReMe the urine_re_me value
	 */
	public void setUrineReMe (java.lang.String urineReMe) {
		this.urineReMe = urineReMe;
	}



	/**
	 * Return the value associated with the column: anashteic_details
	 */
	public java.lang.String getAnashteicDetails () {
		return anashteicDetails;
	}

	/**
	 * Set the value related to the column: anashteic_details
	 * @param anashteicDetails the anashteic_details value
	 */
	public void setAnashteicDetails (java.lang.String anashteicDetails) {
		this.anashteicDetails = anashteicDetails;
	}



	/**
	 * Return the value associated with the column: mpc
	 */
	public java.lang.String getMpc () {
		return mpc;
	}

	/**
	 * Set the value related to the column: mpc
	 * @param mpc the mpc value
	 */
	public void setMpc (java.lang.String mpc) {
		this.mpc = mpc;
	}



	/**
	 * Return the value associated with the column: tmd
	 */
	public java.lang.String getTmd () {
		return tmd;
	}

	/**
	 * Set the value related to the column: tmd
	 * @param tmd the tmd value
	 */
	public void setTmd (java.lang.String tmd) {
		this.tmd = tmd;
	}



	/**
	 * Return the value associated with the column: tmj
	 */
	public java.lang.String getTmj () {
		return tmj;
	}

	/**
	 * Set the value related to the column: tmj
	 * @param tmj the tmj value
	 */
	public void setTmj (java.lang.String tmj) {
		this.tmj = tmj;
	}



	/**
	 * Return the value associated with the column: mo
	 */
	public java.lang.String getMo () {
		return mo;
	}

	/**
	 * Set the value related to the column: mo
	 * @param mo the mo value
	 */
	public void setMo (java.lang.String mo) {
		this.mo = mo;
	}



	/**
	 * Return the value associated with the column: teeth
	 */
	public java.lang.String getTeeth () {
		return teeth;
	}

	/**
	 * Set the value related to the column: teeth
	 * @param teeth the teeth value
	 */
	public void setTeeth (java.lang.String teeth) {
		this.teeth = teeth;
	}



	/**
	 * Return the value associated with the column: cvs
	 */
	public java.lang.String getCvs () {
		return cvs;
	}

	/**
	 * Set the value related to the column: cvs
	 * @param cvs the cvs value
	 */
	public void setCvs (java.lang.String cvs) {
		this.cvs = cvs;
	}



	/**
	 * Return the value associated with the column: rs
	 */
	public java.lang.String getRs () {
		return rs;
	}

	/**
	 * Set the value related to the column: rs
	 * @param rs the rs value
	 */
	public void setRs (java.lang.String rs) {
		this.rs = rs;
	}



	/**
	 * Return the value associated with the column: cns
	 */
	public java.lang.String getCns () {
		return cns;
	}

	/**
	 * Set the value related to the column: cns
	 * @param cns the cns value
	 */
	public void setCns (java.lang.String cns) {
		this.cns = cns;
	}



	/**
	 * Return the value associated with the column: review_complaints
	 */
	public java.lang.String getReviewComplaints () {
		return reviewComplaints;
	}

	/**
	 * Set the value related to the column: review_complaints
	 * @param reviewComplaints the review_complaints value
	 */
	public void setReviewComplaints (java.lang.String reviewComplaints) {
		this.reviewComplaints = reviewComplaints;
	}



	/**
	 * Return the value associated with the column: review_qp
	 */
	public java.lang.String getReviewQp () {
		return reviewQp;
	}

	/**
	 * Set the value related to the column: review_qp
	 * @param reviewQp the review_qp value
	 */
	public void setReviewQp (java.lang.String reviewQp) {
		this.reviewQp = reviewQp;
	}



	/**
	 * Return the value associated with the column: review_bp
	 */
	public java.lang.String getReviewBp () {
		return reviewBp;
	}

	/**
	 * Set the value related to the column: review_bp
	 * @param reviewBp the review_bp value
	 */
	public void setReviewBp (java.lang.String reviewBp) {
		this.reviewBp = reviewBp;
	}



	/**
	 * Return the value associated with the column: review_cvs
	 */
	public java.lang.String getReviewCvs () {
		return reviewCvs;
	}

	/**
	 * Set the value related to the column: review_cvs
	 * @param reviewCvs the review_cvs value
	 */
	public void setReviewCvs (java.lang.String reviewCvs) {
		this.reviewCvs = reviewCvs;
	}



	/**
	 * Return the value associated with the column: review_rs
	 */
	public java.lang.String getReviewRs () {
		return reviewRs;
	}

	/**
	 * Set the value related to the column: review_rs
	 * @param reviewRs the review_rs value
	 */
	public void setReviewRs (java.lang.String reviewRs) {
		this.reviewRs = reviewRs;
	}



	/**
	 * Return the value associated with the column: review_other
	 */
	public java.lang.String getReviewOther () {
		return reviewOther;
	}

	/**
	 * Set the value related to the column: review_other
	 * @param reviewOther the review_other value
	 */
	public void setReviewOther (java.lang.String reviewOther) {
		this.reviewOther = reviewOther;
	}



	/**
	 * Return the value associated with the column: asa_risk
	 */
	public java.lang.String getAsaRisk () {
		return asaRisk;
	}

	/**
	 * Set the value related to the column: asa_risk
	 * @param asaRisk the asa_risk value
	 */
	public void setAsaRisk (java.lang.String asaRisk) {
		this.asaRisk = asaRisk;
	}



	/**
	 * Return the value associated with the column: remark
	 */
	public java.lang.String getRemark () {
		return remark;
	}

	/**
	 * Set the value related to the column: remark
	 * @param remark the remark value
	 */
	public void setRemark (java.lang.String remark) {
		this.remark = remark;
	}



	/**
	 * Return the value associated with the column: consent_status
	 */
	public java.lang.String getConsentStatus () {
		return consentStatus;
	}

	/**
	 * Set the value related to the column: consent_status
	 * @param consentStatus the consent_status value
	 */
	public void setConsentStatus (java.lang.String consentStatus) {
		this.consentStatus = consentStatus;
	}



	/**
	 * Return the value associated with the column: fit_for_surgery
	 */
	public java.lang.String getFitForSurgery () {
		return fitForSurgery;
	}

	/**
	 * Set the value related to the column: fit_for_surgery
	 * @param fitForSurgery the fit_for_surgery value
	 */
	public void setFitForSurgery (java.lang.String fitForSurgery) {
		this.fitForSurgery = fitForSurgery;
	}



	/**
	 * Return the value associated with the column: Koilonychia
	 */
	public java.lang.String getKoilonychia () {
		return koilonychia;
	}

	/**
	 * Set the value related to the column: Koilonychia
	 * @param koilonychia the Koilonychia value
	 */
	public void setKoilonychia (java.lang.String koilonychia) {
		this.koilonychia = koilonychia;
	}



	/**
	 * Return the value associated with the column: Lymphadenopathy
	 */
	public java.lang.String getLymphadenopathy () {
		return lymphadenopathy;
	}

	/**
	 * Set the value related to the column: Lymphadenopathy
	 * @param lymphadenopathy the Lymphadenopathy value
	 */
	public void setLymphadenopathy (java.lang.String lymphadenopathy) {
		this.lymphadenopathy = lymphadenopathy;
	}



	/**
	 * Return the value associated with the column: addtional_Remarks
	 */
	public java.lang.String getAddtionalRemarks () {
		return addtionalRemarks;
	}

	/**
	 * Set the value related to the column: addtional_Remarks
	 * @param addtionalRemarks the addtional_Remarks value
	 */
	public void setAddtionalRemarks (java.lang.String addtionalRemarks) {
		this.addtionalRemarks = addtionalRemarks;
	}



	/**
	 * Return the value associated with the column: consult_other_doctor
	 */
	public java.lang.String getConsultOtherDoctor () {
		return consultOtherDoctor;
	}

	/**
	 * Set the value related to the column: consult_other_doctor
	 * @param consultOtherDoctor the consult_other_doctor value
	 */
	public void setConsultOtherDoctor (java.lang.String consultOtherDoctor) {
		this.consultOtherDoctor = consultOtherDoctor;
	}



	/**
	 * Return the value associated with the column: other
	 */
	public java.lang.String getOther () {
		return other;
	}

	/**
	 * Set the value related to the column: other
	 * @param other the other value
	 */
	public void setOther (java.lang.String other) {
		this.other = other;
	}



	/**
	 * Return the value associated with the column: opd_surgery_header
	 */
	public jkt.hms.masters.business.OpdSurgeryHeader getOpdSurgeryHeader () {
		return opdSurgeryHeader;
	}

	/**
	 * Set the value related to the column: opd_surgery_header
	 * @param opdSurgeryHeader the opd_surgery_header value
	 */
	public void setOpdSurgeryHeader (jkt.hms.masters.business.OpdSurgeryHeader opdSurgeryHeader) {
		this.opdSurgeryHeader = opdSurgeryHeader;
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
	 * Return the value associated with the column: pending_doctor_id
	 */
	public jkt.hms.masters.business.MasEmployee getPendingDoctor () {
		return pendingDoctor;
	}

	/**
	 * Set the value related to the column: pending_doctor_id
	 * @param pendingDoctor the pending_doctor_id value
	 */
	public void setPendingDoctor (jkt.hms.masters.business.MasEmployee pendingDoctor) {
		this.pendingDoctor = pendingDoctor;
	}



	/**
	 * Return the value associated with the column: consult_dept_id
	 */
	public jkt.hms.masters.business.MasDepartment getConsultDept () {
		return consultDept;
	}

	/**
	 * Set the value related to the column: consult_dept_id
	 * @param consultDept the consult_dept_id value
	 */
	public void setConsultDept (jkt.hms.masters.business.MasDepartment consultDept) {
		this.consultDept = consultDept;
	}



	/**
	 * Return the value associated with the column: visit_id
	 */
	public jkt.hms.masters.business.Visit getVisit () {
		return visit;
	}

	/**
	 * Set the value related to the column: visit_id
	 * @param visit the visit_id value
	 */
	public void setVisit (jkt.hms.masters.business.Visit visit) {
		this.visit = visit;
	}



	/**
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment () {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * @param department the department_id value
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
	 * Return the value associated with the column: consult_doctor_id
	 */
	public jkt.hms.masters.business.MasEmployee getConsultDoctor () {
		return consultDoctor;
	}

	/**
	 * Set the value related to the column: consult_doctor_id
	 * @param consultDoctor the consult_doctor_id value
	 */
	public void setConsultDoctor (jkt.hms.masters.business.MasEmployee consultDoctor) {
		this.consultDoctor = consultDoctor;
	}



	/**
	 * Return the value associated with the column: pending_dept_id
	 */
	public jkt.hms.masters.business.MasDepartment getPendingDept () {
		return pendingDept;
	}

	/**
	 * Set the value related to the column: pending_dept_id
	 * @param pendingDept the pending_dept_id value
	 */
	public void setPendingDept (jkt.hms.masters.business.MasDepartment pendingDept) {
		this.pendingDept = pendingDept;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OtPreAnesthesiaDetails)) return false;
		else {
			jkt.hms.masters.business.OtPreAnesthesiaDetails otPreAnesthesiaDetails = (jkt.hms.masters.business.OtPreAnesthesiaDetails) obj;
			if (null == this.getId() || null == otPreAnesthesiaDetails.getId()) return false;
			else return (this.getId().equals(otPreAnesthesiaDetails.getId()));
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
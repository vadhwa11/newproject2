package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the av_medical_exam_ma_mo table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="av_medical_exam_ma_mo"
 */

public abstract class BaseAvMedicalExamMaMo  implements Serializable {

	public static String REF = "AvMedicalExamMaMo";
	public static String PROP_ENT_NOSE_PARANASAL = "EntNoseParanasal";
	public static String PROP_EYE_PSEUDOISCHROMATIC = "EyePseudoischromatic";
	public static String PROP_REMARKS_SPINE_MUSCULO = "RemarksSpineMusculo";
	public static String PROP_EXTERNAL_EUSTACHEAN_TUBE = "ExternalEustacheanTube";
	public static String PROP_DISTANT_LEFT_A = "DistantLeftA";
	public static String PROP_DISTANT_LEFT_C = "DistantLeftC";
	public static String PROP_EXTERNAL_MASTOID = "ExternalMastoid";
	public static String PROP_NEAR_RIGHT_S = "NearRightS";
	public static String PROP_BMI = "Bmi";
	public static String PROP_WEIGHT = "Weight";
	public static String PROP_REMARKS_CHEST_LUNGS = "RemarksChestLungs";
	public static String PROP_SYSTEM_ABDOMEN_VISCERA = "SystemAbdomenViscera";
	public static String PROP_SYSTEM_CHEST_LUNGS = "SystemChestLungs";
	public static String PROP_REMARKS_SKIN = "RemarksSkin";
	public static String PROP_NEAR_RIGHT_C = "NearRightC";
	public static String PROP_REMARKS_LYMPHNODE_LYMPHATIC = "RemarksLymphnodeLymphatic";
	public static String PROP_REMARKS_EAR = "RemarksEar";
	public static String PROP_NEAR_RIGHT_A = "NearRightA";
	public static String PROP_AV_STATUS = "AvStatus";
	public static String PROP_MADDOX_ROD_AT33 = "MaddoxRodAt33";
	public static String PROP_DISTANT_RIGHT_S = "DistantRightS";
	public static String PROP_PELVIC_EXAMINATION = "PelvicExamination";
	public static String PROP_AUDIO_LT3000 = "AudioLt3000";
	public static String PROP_SPEECH_INTELLIGIBL_RT = "SpeechIntelligiblRt";
	public static String PROP_ACOMODATION_WITHGLASS = "AcomodationWithglass";
	public static String PROP_SYSTEM_GENITOURINARY = "SystemGenitourinary";
	public static String PROP_WTHOUT_GLASSES_L_DISTANT = "WthoutGlassesLDistant";
	public static String PROP_TUNNING_RT_ABC = "TunningRtAbc";
	public static String PROP_TUNNING_LT_WEBE = "TunningLtWebe";
	public static String PROP_DISTANT_RIGHT_C = "DistantRightC";
	public static String PROP_SYSTEM_HEART = "SystemHeart";
	public static String PROP_ENT_MASTOID = "EntMastoid";
	public static String PROP_EYE_REMARKS = "EyeRemarks";
	public static String PROP_DISTANT_RIGHT_A = "DistantRightA";
	public static String PROP_HEAR_RT_CV = "HearRtCv";
	public static String PROP_ELECTROCARDIOGRAM = "Electrocardiogram";
	public static String PROP_EYE_VISUAL_ACUITY = "EyeVisualAcuity";
	public static String PROP_SPEECH = "Speech";
	public static String PROP_SYSTEM_LYMPHNODE_LYMPHATIC = "SystemLymphnodeLymphatic";
	public static String PROP_HEAR_LT_BOTH = "HearLtBoth";
	public static String PROP_MA_DATE = "MaDate";
	public static String PROP_MENSTRUATION_DATE = "MenstruationDate";
	public static String PROP_TUNNING_RT_WEBE = "TunningRtWebe";
	public static String PROP_REMARKS_ABDOMEN_VISCERA = "RemarksAbdomenViscera";
	public static String PROP_MO_NAME = "MoName";
	public static String PROP_AUDIO_RT500 = "AudioRt500";
	public static String PROP_ENT_COCHLEAR = "EntCochlear";
	public static String PROP_ENT_MIDDLE_TYMPANUM = "EntMiddleTympanum";
	public static String PROP_XRAY_CHEST = "XrayChest";
	public static String PROP_TUNNING_RT_RINNIE = "TunningRtRinnie";
	public static String PROP_REMARKS_PSYCHIARTRIC = "RemarksPsychiartric";
	public static String PROP_HEAR_RT_FWV = "HearRtFwv";
	public static String PROP_AUDIO_LT250 = "AudioLt250";
	public static String PROP_CHEST_CIRCUMFERENCE = "ChestCircumference";
	public static String PROP_SYSTEM_SPINE_MUSCULO = "SystemSpineMusculo";
	public static String PROP_MIN_PULSE_NORMAL = "MinPulseNormal";
	public static String PROP_DLC = "Dlc";
	public static String PROP_EXAMINATION_BREASTS = "ExaminationBreasts";
	public static String PROP_DISTANT_LEFT_S = "DistantLeftS";
	public static String PROP_SYSTEM_ENDOCRINE = "SystemEndocrine";
	public static String PROP_ENT_EXTERNAL_TYMPANUM = "EntExternalTympanum";
	public static String PROP_SYSTEM_HEAD_FACE_NECK = "SystemHeadFaceNeck";
	public static String PROP_REMARKS_HEAD_FACE_NECK = "RemarksHeadFaceNeck";
	public static String PROP_CANDIDATE_POSSES_GLASSES = "CandidatePossesGlasses";
	public static String PROP_MOUTH_TEETH_THROAT = "MouthTeethThroat";
	public static String PROP_WTHOUT_GLASSES_BOTH_DISTANT = "WthoutGlassesBothDistant";
	public static String PROP_SYSTEM_NEUROLOGIC = "SystemNeurologic";
	public static String PROP_AUDIO_RT250 = "AudioRt250";
	public static String PROP_N14_READ = "N14Read";
	public static String PROP_REMARKS_VASCULAR = "RemarksVascular";
	public static String PROP_ENT_VESTIBULAR = "EntVestibular";
	public static String PROP_REMARKS_HEART = "RemarksHeart";
	public static String PROP_AUDIO_RT3000 = "AudioRt3000";
	public static String PROP_NEAR_LEFT_C = "NearLeftC";
	public static String PROP_PHYSICAL_MENTAL_REMARKS = "PhysicalMentalRemarks";
	public static String PROP_NEAR_LEFT_A = "NearLeftA";
	public static String PROP_HEAR_LT_FWV = "HearLtFwv";
	public static String PROP_REMARKS_ENDOCRINE = "RemarksEndocrine";
	public static String PROP_SPEECH_INTELLIGIBL_LT = "SpeechIntelligiblLt";
	public static String PROP_HB = "Hb";
	public static String PROP_PULSE_EXERCISE = "PulseExercise";
	public static String PROP_AVI_CA34 = "AviCa34";
	public static String PROP_NEAR_VISION = "NearVision";
	public static String PROP_AUDIO_LT1000 = "AudioLt1000";
	public static String PROP_INTERMEDIATE_VISION = "IntermediateVision";
	public static String PROP_AUDIO_LT2000 = "AudioLt2000";
	public static String PROP_RESULT_COVER_TEST_AT33 = "ResultCoverTestAt33";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_TUNNING_LT_RINNIE = "TunningLtRinnie";
	public static String PROP_HEIGHT = "Height";
	public static String PROP_VISIT = "Visit";
	public static String PROP_MO_DATE = "MoDate";
	public static String PROP_REMARKS_PERINCUM_ANUS = "RemarksPerincumAnus";
	public static String PROP_RESULT_COVER_TEST_AT6 = "ResultCoverTestAt6";
	public static String PROP_WITH_GLASSES_R_DISTANT = "WithGlassesRDistant";
	public static String PROP_EYE_LIDS_LACHRYMAL = "EyeLidsLachrymal";
	public static String PROP_N5_READ = "N5Read";
	public static String PROP_EYE_OCULAR_MOTILITY = "EyeOcularMotility";
	public static String PROP_ID = "Id";
	public static String PROP_POWER_CONVERGENCE_SC = "PowerConvergenceSc";
	public static String PROP_URINALYSIS = "Urinalysis";
	public static String PROP_SPEECH_LT_RESULT = "SpeechLtResult";
	public static String PROP_REMARKS_GENITOURINARY = "RemarksGenitourinary";
	public static String PROP_SYSTEM_PSYCHIARTRIC = "SystemPsychiartric";
	public static String PROP_TLC = "Tlc";
	public static String PROP_PULSE_SEATED = "PulseSeated";
	public static String PROP_HEAR_RT_BOTH = "HearRtBoth";
	public static String PROP_MIDDLE_EUSTACHEAN_TUBE = "MiddleEustacheanTube";
	public static String PROP_WITH_GLASSES_L_DISTANT = "WithGlassesLDistant";
	public static String PROP_AUDIO_RT2000 = "AudioRt2000";
	public static String PROP_EYE_DISTINGUISHING_READILY = "EyeDistinguishingReadily";
	public static String PROP_REMARKS_NEUROLOGIC = "RemarksNeurologic";
	public static String PROP_MADDOX_ROD_AT6 = "MaddoxRodAt6";
	public static String PROP_HEAR_LT_CV = "HearLtCv";
	public static String PROP_WTHOUT_GLASSES_R_DISTANT = "WthoutGlassesRDistant";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_SPEECH_RT_RESULT = "SpeechRtResult";
	public static String PROP_POWER_CONVERGENCE_C = "PowerConvergenceC";
	public static String PROP_SYSTEMIC_SKIN = "SystemicSkin";
	public static String PROP_NEAR_LEFT_S = "NearLeftS";
	public static String PROP_SYSTEM_PERINCUM_ANUS = "SystemPerincumAnus";
	public static String PROP_EXPIRATION = "Expiration";
	public static String PROP_SYSTEM_UPER_LOWER_EXTREMITIE = "SystemUperLowerExtremitie";
	public static String PROP_WITH_GLASSES_BOTH_DISTANT = "WithGlassesBothDistant";
	public static String PROP_AUDIO_RT1000 = "AudioRt1000";
	public static String PROP_EYE_VISUAL_FIELDS = "EyeVisualFields";
	public static String PROP_REMARKS_UPER_LOWER_EXTREMITIE = "RemarksUperLowerExtremitie";
	public static String PROP_ACOMODATION_WITHOUTGLASS = "AcomodationWithoutglass";
	public static String PROP_SYSTEM_VASCULAR = "SystemVascular";
	public static String PROP_BP = "Bp";
	public static String PROP_TUNNING_LT_ABC = "TunningLtAbc";
	public static String PROP_HIN = "Hin";
	public static String PROP_AUDIO_LT500 = "AudioLt500";


	// constructors
	public BaseAvMedicalExamMaMo () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAvMedicalExamMaMo (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String eyePseudoischromatic;
	private java.lang.String eyeDistinguishingReadily;
	private java.lang.String eyeRemarks;
	private java.lang.String entExternalTympanum;
	private java.lang.String externalEustacheanTube;
	private java.lang.String externalMastoid;
	private java.lang.String entMiddleTympanum;
	private java.lang.String middleEustacheanTube;
	private java.lang.String entMastoid;
	private java.lang.String entCochlear;
	private java.lang.String entVestibular;
	private java.lang.String entNoseParanasal;
	private java.lang.String mouthTeethThroat;
	private java.lang.String speech;
	private java.lang.String remarksEar;
	private java.math.BigDecimal height;
	private java.math.BigDecimal acomodationWithoutglass;
	private java.math.BigDecimal acomodationWithglass;
	private java.lang.String n14Read;
	private java.lang.String n5Read;
	private java.math.BigDecimal intermediateVision;
	private java.math.BigDecimal nearVision;
	private java.lang.String withGlassesBothDistant;
	private java.lang.String withGlassesLDistant;
	private java.lang.String withGlassesRDistant;
	private java.lang.String wthoutGlassesBothDistant;
	private java.lang.String wthoutGlassesLDistant;
	private java.lang.String wthoutGlassesRDistant;
	private java.lang.String eyeVisualAcuity;
	private java.lang.String eyeOcularMotility;
	private java.lang.String eyeVisualFields;
	private java.lang.String eyeLidsLachrymal;
	private java.lang.String physicalMentalRemarks;
	private java.lang.String electrocardiogram;
	private java.lang.String bp;
	private java.lang.String minPulseNormal;
	private java.lang.String pulseExercise;
	private java.lang.String pulseSeated;
	private java.math.BigDecimal expiration;
	private java.math.BigDecimal chestCircumference;
	private java.math.BigDecimal bmi;
	private java.math.BigDecimal weight;
	private java.math.BigDecimal resultCoverTestAt6;
	private java.math.BigDecimal resultCoverTestAt33;
	private java.math.BigDecimal maddoxRodAt6;
	private java.math.BigDecimal maddoxRodAt33;
	private java.math.BigDecimal powerConvergenceC;
	private java.math.BigDecimal powerConvergenceSc;
	private java.lang.String candidatePossesGlasses;
	private java.math.BigDecimal distantRightS;
	private java.math.BigDecimal distantRightC;
	private java.math.BigDecimal distantRightA;
	private java.math.BigDecimal distantLeftS;
	private java.math.BigDecimal distantLeftC;
	private java.math.BigDecimal distantLeftA;
	private java.math.BigDecimal nearRightS;
	private java.math.BigDecimal nearRightC;
	private java.math.BigDecimal nearRightA;
	private java.math.BigDecimal nearLeftS;
	private java.math.BigDecimal nearLeftC;
	private java.math.BigDecimal nearLeftA;
	private java.lang.String tunningRtRinnie;
	private java.lang.String tunningRtWebe;
	private java.lang.String tunningRtAbc;
	private java.lang.String tunningLtRinnie;
	private java.lang.String tunningLtWebe;
	private java.lang.String tunningLtAbc;
	private java.lang.String speechIntelligiblRt;
	private java.lang.String speechIntelligiblLt;
	private java.lang.String speechRtResult;
	private java.lang.String speechLtResult;
	private java.lang.String systemicSkin;
	private java.lang.String systemLymphnodeLymphatic;
	private java.lang.String systemHeadFaceNeck;
	private java.lang.String systemUperLowerExtremitie;
	private java.lang.String systemSpineMusculo;
	private java.lang.String systemChestLungs;
	private java.lang.String systemHeart;
	private java.lang.String systemVascular;
	private java.lang.String systemAbdomenViscera;
	private java.lang.String systemPerincumAnus;
	private java.lang.String systemGenitourinary;
	private java.lang.String systemEndocrine;
	private java.lang.String systemNeurologic;
	private java.lang.String systemPsychiartric;
	private java.lang.String remarksSkin;
	private java.lang.String remarksLymphnodeLymphatic;
	private java.lang.String remarksHeadFaceNeck;
	private java.lang.String remarksUperLowerExtremitie;
	private java.lang.String remarksSpineMusculo;
	private java.lang.String remarksChestLungs;
	private java.lang.String remarksHeart;
	private java.lang.String remarksVascular;
	private java.lang.String remarksAbdomenViscera;
	private java.lang.String remarksPerincumAnus;
	private java.lang.String remarksGenitourinary;
	private java.lang.String remarksEndocrine;
	private java.lang.String remarksNeurologic;
	private java.lang.String remarksPsychiartric;
	private java.math.BigDecimal hearRtCv;
	private java.math.BigDecimal hearRtFwv;
	private java.math.BigDecimal hearRtBoth;
	private java.math.BigDecimal hearLtCv;
	private java.math.BigDecimal hearLtFwv;
	private java.math.BigDecimal hearLtBoth;
	private java.math.BigDecimal audioRt250;
	private java.math.BigDecimal audioLt250;
	private java.math.BigDecimal audioRt500;
	private java.math.BigDecimal audioLt500;
	private java.math.BigDecimal audioRt1000;
	private java.math.BigDecimal audioLt1000;
	private java.math.BigDecimal audioRt2000;
	private java.math.BigDecimal audioLt2000;
	private java.math.BigDecimal audioRt3000;
	private java.math.BigDecimal audioLt3000;
	private java.lang.String avStatus;
	private java.lang.String examinationBreasts;
	private java.util.Date menstruationDate;
	private java.lang.String pelvicExamination;
	private java.util.Date maDate;
	private java.util.Date moDate;
	private java.lang.String moName;
	private java.lang.String xrayChest;
	private java.lang.String urinalysis;
	private java.lang.String hb;
	private java.lang.String tlc;
	private java.lang.String dlc;

	// many to one
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.AviCa34 aviCa34;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="AV_MEDICAL_EXAM_ID"
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
	 * Return the value associated with the column: EYE_PSEUDOISCHROMATIC
	 */
	public java.lang.String getEyePseudoischromatic () {
		return eyePseudoischromatic;
	}

	/**
	 * Set the value related to the column: EYE_PSEUDOISCHROMATIC
	 * @param eyePseudoischromatic the EYE_PSEUDOISCHROMATIC value
	 */
	public void setEyePseudoischromatic (java.lang.String eyePseudoischromatic) {
		this.eyePseudoischromatic = eyePseudoischromatic;
	}



	/**
	 * Return the value associated with the column: EYE_DISTINGUISHING_READILY
	 */
	public java.lang.String getEyeDistinguishingReadily () {
		return eyeDistinguishingReadily;
	}

	/**
	 * Set the value related to the column: EYE_DISTINGUISHING_READILY
	 * @param eyeDistinguishingReadily the EYE_DISTINGUISHING_READILY value
	 */
	public void setEyeDistinguishingReadily (java.lang.String eyeDistinguishingReadily) {
		this.eyeDistinguishingReadily = eyeDistinguishingReadily;
	}



	/**
	 * Return the value associated with the column: EYE_REMARKS
	 */
	public java.lang.String getEyeRemarks () {
		return eyeRemarks;
	}

	/**
	 * Set the value related to the column: EYE_REMARKS
	 * @param eyeRemarks the EYE_REMARKS value
	 */
	public void setEyeRemarks (java.lang.String eyeRemarks) {
		this.eyeRemarks = eyeRemarks;
	}



	/**
	 * Return the value associated with the column: ENT_EXTERNAL_YMPANUM
	 */
	public java.lang.String getEntExternalTympanum () {
		return entExternalTympanum;
	}

	/**
	 * Set the value related to the column: ENT_EXTERNAL_YMPANUM
	 * @param entExternalTympanum the ENT_EXTERNAL_YMPANUM value
	 */
	public void setEntExternalTympanum (java.lang.String entExternalTympanum) {
		this.entExternalTympanum = entExternalTympanum;
	}



	/**
	 * Return the value associated with the column: external_eustachean_tube
	 */
	public java.lang.String getExternalEustacheanTube () {
		return externalEustacheanTube;
	}

	/**
	 * Set the value related to the column: external_eustachean_tube
	 * @param externalEustacheanTube the external_eustachean_tube value
	 */
	public void setExternalEustacheanTube (java.lang.String externalEustacheanTube) {
		this.externalEustacheanTube = externalEustacheanTube;
	}



	/**
	 * Return the value associated with the column: EXTERNAL_ENT_MASTOID
	 */
	public java.lang.String getExternalMastoid () {
		return externalMastoid;
	}

	/**
	 * Set the value related to the column: EXTERNAL_ENT_MASTOID
	 * @param externalMastoid the EXTERNAL_ENT_MASTOID value
	 */
	public void setExternalMastoid (java.lang.String externalMastoid) {
		this.externalMastoid = externalMastoid;
	}



	/**
	 * Return the value associated with the column: ENT_MIDDLE_TYMPANUM
	 */
	public java.lang.String getEntMiddleTympanum () {
		return entMiddleTympanum;
	}

	/**
	 * Set the value related to the column: ENT_MIDDLE_TYMPANUM
	 * @param entMiddleTympanum the ENT_MIDDLE_TYMPANUM value
	 */
	public void setEntMiddleTympanum (java.lang.String entMiddleTympanum) {
		this.entMiddleTympanum = entMiddleTympanum;
	}



	/**
	 * Return the value associated with the column: MIDDLE_EUSTACHEAN_TUBE
	 */
	public java.lang.String getMiddleEustacheanTube () {
		return middleEustacheanTube;
	}

	/**
	 * Set the value related to the column: MIDDLE_EUSTACHEAN_TUBE
	 * @param middleEustacheanTube the MIDDLE_EUSTACHEAN_TUBE value
	 */
	public void setMiddleEustacheanTube (java.lang.String middleEustacheanTube) {
		this.middleEustacheanTube = middleEustacheanTube;
	}



	/**
	 * Return the value associated with the column: ENT_MASTOID
	 */
	public java.lang.String getEntMastoid () {
		return entMastoid;
	}

	/**
	 * Set the value related to the column: ENT_MASTOID
	 * @param entMastoid the ENT_MASTOID value
	 */
	public void setEntMastoid (java.lang.String entMastoid) {
		this.entMastoid = entMastoid;
	}



	/**
	 * Return the value associated with the column: ENT_COCHLEAR
	 */
	public java.lang.String getEntCochlear () {
		return entCochlear;
	}

	/**
	 * Set the value related to the column: ENT_COCHLEAR
	 * @param entCochlear the ENT_COCHLEAR value
	 */
	public void setEntCochlear (java.lang.String entCochlear) {
		this.entCochlear = entCochlear;
	}



	/**
	 * Return the value associated with the column: ENT_VESTIBULAR
	 */
	public java.lang.String getEntVestibular () {
		return entVestibular;
	}

	/**
	 * Set the value related to the column: ENT_VESTIBULAR
	 * @param entVestibular the ENT_VESTIBULAR value
	 */
	public void setEntVestibular (java.lang.String entVestibular) {
		this.entVestibular = entVestibular;
	}



	/**
	 * Return the value associated with the column: ENT_NOSE_PARANASAL
	 */
	public java.lang.String getEntNoseParanasal () {
		return entNoseParanasal;
	}

	/**
	 * Set the value related to the column: ENT_NOSE_PARANASAL
	 * @param entNoseParanasal the ENT_NOSE_PARANASAL value
	 */
	public void setEntNoseParanasal (java.lang.String entNoseParanasal) {
		this.entNoseParanasal = entNoseParanasal;
	}



	/**
	 * Return the value associated with the column: MOUTH_TEETH_THROAT
	 */
	public java.lang.String getMouthTeethThroat () {
		return mouthTeethThroat;
	}

	/**
	 * Set the value related to the column: MOUTH_TEETH_THROAT
	 * @param mouthTeethThroat the MOUTH_TEETH_THROAT value
	 */
	public void setMouthTeethThroat (java.lang.String mouthTeethThroat) {
		this.mouthTeethThroat = mouthTeethThroat;
	}



	/**
	 * Return the value associated with the column: SPEECH
	 */
	public java.lang.String getSpeech () {
		return speech;
	}

	/**
	 * Set the value related to the column: SPEECH
	 * @param speech the SPEECH value
	 */
	public void setSpeech (java.lang.String speech) {
		this.speech = speech;
	}



	/**
	 * Return the value associated with the column: REMARKS_EAR
	 */
	public java.lang.String getRemarksEar () {
		return remarksEar;
	}

	/**
	 * Set the value related to the column: REMARKS_EAR
	 * @param remarksEar the REMARKS_EAR value
	 */
	public void setRemarksEar (java.lang.String remarksEar) {
		this.remarksEar = remarksEar;
	}



	/**
	 * Return the value associated with the column: HEIGHT
	 */
	public java.math.BigDecimal getHeight () {
		return height;
	}

	/**
	 * Set the value related to the column: HEIGHT
	 * @param height the HEIGHT value
	 */
	public void setHeight (java.math.BigDecimal height) {
		this.height = height;
	}



	/**
	 * Return the value associated with the column: ACOMODATION_WITHOUTGLASS
	 */
	public java.math.BigDecimal getAcomodationWithoutglass () {
		return acomodationWithoutglass;
	}

	/**
	 * Set the value related to the column: ACOMODATION_WITHOUTGLASS
	 * @param acomodationWithoutglass the ACOMODATION_WITHOUTGLASS value
	 */
	public void setAcomodationWithoutglass (java.math.BigDecimal acomodationWithoutglass) {
		this.acomodationWithoutglass = acomodationWithoutglass;
	}



	/**
	 * Return the value associated with the column: ACOMODATION_WITHGLASS
	 */
	public java.math.BigDecimal getAcomodationWithglass () {
		return acomodationWithglass;
	}

	/**
	 * Set the value related to the column: ACOMODATION_WITHGLASS
	 * @param acomodationWithglass the ACOMODATION_WITHGLASS value
	 */
	public void setAcomodationWithglass (java.math.BigDecimal acomodationWithglass) {
		this.acomodationWithglass = acomodationWithglass;
	}



	/**
	 * Return the value associated with the column: N14_READ
	 */
	public java.lang.String getN14Read () {
		return n14Read;
	}

	/**
	 * Set the value related to the column: N14_READ
	 * @param n14Read the N14_READ value
	 */
	public void setN14Read (java.lang.String n14Read) {
		this.n14Read = n14Read;
	}



	/**
	 * Return the value associated with the column: N5_READ
	 */
	public java.lang.String getN5Read () {
		return n5Read;
	}

	/**
	 * Set the value related to the column: N5_READ
	 * @param n5Read the N5_READ value
	 */
	public void setN5Read (java.lang.String n5Read) {
		this.n5Read = n5Read;
	}



	/**
	 * Return the value associated with the column: INTERMEDIATE_VISION
	 */
	public java.math.BigDecimal getIntermediateVision () {
		return intermediateVision;
	}

	/**
	 * Set the value related to the column: INTERMEDIATE_VISION
	 * @param intermediateVision the INTERMEDIATE_VISION value
	 */
	public void setIntermediateVision (java.math.BigDecimal intermediateVision) {
		this.intermediateVision = intermediateVision;
	}



	/**
	 * Return the value associated with the column: NEAR_VISION
	 */
	public java.math.BigDecimal getNearVision () {
		return nearVision;
	}

	/**
	 * Set the value related to the column: NEAR_VISION
	 * @param nearVision the NEAR_VISION value
	 */
	public void setNearVision (java.math.BigDecimal nearVision) {
		this.nearVision = nearVision;
	}



	/**
	 * Return the value associated with the column: WITH_GLASSES_BOTH_DISTANT
	 */
	public java.lang.String getWithGlassesBothDistant () {
		return withGlassesBothDistant;
	}

	/**
	 * Set the value related to the column: WITH_GLASSES_BOTH_DISTANT
	 * @param withGlassesBothDistant the WITH_GLASSES_BOTH_DISTANT value
	 */
	public void setWithGlassesBothDistant (java.lang.String withGlassesBothDistant) {
		this.withGlassesBothDistant = withGlassesBothDistant;
	}



	/**
	 * Return the value associated with the column: WITH_GLASSES_L_DISTANT
	 */
	public java.lang.String getWithGlassesLDistant () {
		return withGlassesLDistant;
	}

	/**
	 * Set the value related to the column: WITH_GLASSES_L_DISTANT
	 * @param withGlassesLDistant the WITH_GLASSES_L_DISTANT value
	 */
	public void setWithGlassesLDistant (java.lang.String withGlassesLDistant) {
		this.withGlassesLDistant = withGlassesLDistant;
	}



	/**
	 * Return the value associated with the column: WITH_GLASSES_R_DISTANT
	 */
	public java.lang.String getWithGlassesRDistant () {
		return withGlassesRDistant;
	}

	/**
	 * Set the value related to the column: WITH_GLASSES_R_DISTANT
	 * @param withGlassesRDistant the WITH_GLASSES_R_DISTANT value
	 */
	public void setWithGlassesRDistant (java.lang.String withGlassesRDistant) {
		this.withGlassesRDistant = withGlassesRDistant;
	}



	/**
	 * Return the value associated with the column: WTHOUT_GLASSES_BOTH_DISTANT
	 */
	public java.lang.String getWthoutGlassesBothDistant () {
		return wthoutGlassesBothDistant;
	}

	/**
	 * Set the value related to the column: WTHOUT_GLASSES_BOTH_DISTANT
	 * @param wthoutGlassesBothDistant the WTHOUT_GLASSES_BOTH_DISTANT value
	 */
	public void setWthoutGlassesBothDistant (java.lang.String wthoutGlassesBothDistant) {
		this.wthoutGlassesBothDistant = wthoutGlassesBothDistant;
	}



	/**
	 * Return the value associated with the column: WTHOUT_GLASSES_L_DISTANT
	 */
	public java.lang.String getWthoutGlassesLDistant () {
		return wthoutGlassesLDistant;
	}

	/**
	 * Set the value related to the column: WTHOUT_GLASSES_L_DISTANT
	 * @param wthoutGlassesLDistant the WTHOUT_GLASSES_L_DISTANT value
	 */
	public void setWthoutGlassesLDistant (java.lang.String wthoutGlassesLDistant) {
		this.wthoutGlassesLDistant = wthoutGlassesLDistant;
	}



	/**
	 * Return the value associated with the column: WTHOUT_GLASSES_R_DISTANT
	 */
	public java.lang.String getWthoutGlassesRDistant () {
		return wthoutGlassesRDistant;
	}

	/**
	 * Set the value related to the column: WTHOUT_GLASSES_R_DISTANT
	 * @param wthoutGlassesRDistant the WTHOUT_GLASSES_R_DISTANT value
	 */
	public void setWthoutGlassesRDistant (java.lang.String wthoutGlassesRDistant) {
		this.wthoutGlassesRDistant = wthoutGlassesRDistant;
	}



	/**
	 * Return the value associated with the column: EYE_VISUAL_ACUITY
	 */
	public java.lang.String getEyeVisualAcuity () {
		return eyeVisualAcuity;
	}

	/**
	 * Set the value related to the column: EYE_VISUAL_ACUITY
	 * @param eyeVisualAcuity the EYE_VISUAL_ACUITY value
	 */
	public void setEyeVisualAcuity (java.lang.String eyeVisualAcuity) {
		this.eyeVisualAcuity = eyeVisualAcuity;
	}



	/**
	 * Return the value associated with the column: EYE_OCULAR_MOTILITY
	 */
	public java.lang.String getEyeOcularMotility () {
		return eyeOcularMotility;
	}

	/**
	 * Set the value related to the column: EYE_OCULAR_MOTILITY
	 * @param eyeOcularMotility the EYE_OCULAR_MOTILITY value
	 */
	public void setEyeOcularMotility (java.lang.String eyeOcularMotility) {
		this.eyeOcularMotility = eyeOcularMotility;
	}



	/**
	 * Return the value associated with the column: EYE_VISUAL_FIELDS
	 */
	public java.lang.String getEyeVisualFields () {
		return eyeVisualFields;
	}

	/**
	 * Set the value related to the column: EYE_VISUAL_FIELDS
	 * @param eyeVisualFields the EYE_VISUAL_FIELDS value
	 */
	public void setEyeVisualFields (java.lang.String eyeVisualFields) {
		this.eyeVisualFields = eyeVisualFields;
	}



	/**
	 * Return the value associated with the column: EYE_DIDS_LACHRYMAL
	 */
	public java.lang.String getEyeLidsLachrymal () {
		return eyeLidsLachrymal;
	}

	/**
	 * Set the value related to the column: EYE_DIDS_LACHRYMAL
	 * @param eyeLidsLachrymal the EYE_DIDS_LACHRYMAL value
	 */
	public void setEyeLidsLachrymal (java.lang.String eyeLidsLachrymal) {
		this.eyeLidsLachrymal = eyeLidsLachrymal;
	}



	/**
	 * Return the value associated with the column: PHYSICAL_MENTAL_REMARKS
	 */
	public java.lang.String getPhysicalMentalRemarks () {
		return physicalMentalRemarks;
	}

	/**
	 * Set the value related to the column: PHYSICAL_MENTAL_REMARKS
	 * @param physicalMentalRemarks the PHYSICAL_MENTAL_REMARKS value
	 */
	public void setPhysicalMentalRemarks (java.lang.String physicalMentalRemarks) {
		this.physicalMentalRemarks = physicalMentalRemarks;
	}



	/**
	 * Return the value associated with the column: ELECTROCARDIOGRAM
	 */
	public java.lang.String getElectrocardiogram () {
		return electrocardiogram;
	}

	/**
	 * Set the value related to the column: ELECTROCARDIOGRAM
	 * @param electrocardiogram the ELECTROCARDIOGRAM value
	 */
	public void setElectrocardiogram (java.lang.String electrocardiogram) {
		this.electrocardiogram = electrocardiogram;
	}



	/**
	 * Return the value associated with the column: BP
	 */
	public java.lang.String getBp () {
		return bp;
	}

	/**
	 * Set the value related to the column: BP
	 * @param bp the BP value
	 */
	public void setBp (java.lang.String bp) {
		this.bp = bp;
	}



	/**
	 * Return the value associated with the column: MIN_PULSE_NORMAL
	 */
	public java.lang.String getMinPulseNormal () {
		return minPulseNormal;
	}

	/**
	 * Set the value related to the column: MIN_PULSE_NORMAL
	 * @param minPulseNormal the MIN_PULSE_NORMAL value
	 */
	public void setMinPulseNormal (java.lang.String minPulseNormal) {
		this.minPulseNormal = minPulseNormal;
	}



	/**
	 * Return the value associated with the column: PULSE_EXERCISE
	 */
	public java.lang.String getPulseExercise () {
		return pulseExercise;
	}

	/**
	 * Set the value related to the column: PULSE_EXERCISE
	 * @param pulseExercise the PULSE_EXERCISE value
	 */
	public void setPulseExercise (java.lang.String pulseExercise) {
		this.pulseExercise = pulseExercise;
	}



	/**
	 * Return the value associated with the column: PULSE_SEATED
	 */
	public java.lang.String getPulseSeated () {
		return pulseSeated;
	}

	/**
	 * Set the value related to the column: PULSE_SEATED
	 * @param pulseSeated the PULSE_SEATED value
	 */
	public void setPulseSeated (java.lang.String pulseSeated) {
		this.pulseSeated = pulseSeated;
	}



	/**
	 * Return the value associated with the column: EXPIRATION
	 */
	public java.math.BigDecimal getExpiration () {
		return expiration;
	}

	/**
	 * Set the value related to the column: EXPIRATION
	 * @param expiration the EXPIRATION value
	 */
	public void setExpiration (java.math.BigDecimal expiration) {
		this.expiration = expiration;
	}



	/**
	 * Return the value associated with the column: CHEST_CIRCUMFERENCE
	 */
	public java.math.BigDecimal getChestCircumference () {
		return chestCircumference;
	}

	/**
	 * Set the value related to the column: CHEST_CIRCUMFERENCE
	 * @param chestCircumference the CHEST_CIRCUMFERENCE value
	 */
	public void setChestCircumference (java.math.BigDecimal chestCircumference) {
		this.chestCircumference = chestCircumference;
	}



	/**
	 * Return the value associated with the column: BMI
	 */
	public java.math.BigDecimal getBmi () {
		return bmi;
	}

	/**
	 * Set the value related to the column: BMI
	 * @param bmi the BMI value
	 */
	public void setBmi (java.math.BigDecimal bmi) {
		this.bmi = bmi;
	}



	/**
	 * Return the value associated with the column: WEIGHT
	 */
	public java.math.BigDecimal getWeight () {
		return weight;
	}

	/**
	 * Set the value related to the column: WEIGHT
	 * @param weight the WEIGHT value
	 */
	public void setWeight (java.math.BigDecimal weight) {
		this.weight = weight;
	}



	/**
	 * Return the value associated with the column: RESULT_COVER_TEST_AT6
	 */
	public java.math.BigDecimal getResultCoverTestAt6 () {
		return resultCoverTestAt6;
	}

	/**
	 * Set the value related to the column: RESULT_COVER_TEST_AT6
	 * @param resultCoverTestAt6 the RESULT_COVER_TEST_AT6 value
	 */
	public void setResultCoverTestAt6 (java.math.BigDecimal resultCoverTestAt6) {
		this.resultCoverTestAt6 = resultCoverTestAt6;
	}



	/**
	 * Return the value associated with the column: RESULT_COVER_TEST_AT33
	 */
	public java.math.BigDecimal getResultCoverTestAt33 () {
		return resultCoverTestAt33;
	}

	/**
	 * Set the value related to the column: RESULT_COVER_TEST_AT33
	 * @param resultCoverTestAt33 the RESULT_COVER_TEST_AT33 value
	 */
	public void setResultCoverTestAt33 (java.math.BigDecimal resultCoverTestAt33) {
		this.resultCoverTestAt33 = resultCoverTestAt33;
	}



	/**
	 * Return the value associated with the column: MADDOX_ROD_AT6
	 */
	public java.math.BigDecimal getMaddoxRodAt6 () {
		return maddoxRodAt6;
	}

	/**
	 * Set the value related to the column: MADDOX_ROD_AT6
	 * @param maddoxRodAt6 the MADDOX_ROD_AT6 value
	 */
	public void setMaddoxRodAt6 (java.math.BigDecimal maddoxRodAt6) {
		this.maddoxRodAt6 = maddoxRodAt6;
	}



	/**
	 * Return the value associated with the column: MADDOX_ROD_AT33
	 */
	public java.math.BigDecimal getMaddoxRodAt33 () {
		return maddoxRodAt33;
	}

	/**
	 * Set the value related to the column: MADDOX_ROD_AT33
	 * @param maddoxRodAt33 the MADDOX_ROD_AT33 value
	 */
	public void setMaddoxRodAt33 (java.math.BigDecimal maddoxRodAt33) {
		this.maddoxRodAt33 = maddoxRodAt33;
	}



	/**
	 * Return the value associated with the column: POWER_CONVERGENCE_C
	 */
	public java.math.BigDecimal getPowerConvergenceC () {
		return powerConvergenceC;
	}

	/**
	 * Set the value related to the column: POWER_CONVERGENCE_C
	 * @param powerConvergenceC the POWER_CONVERGENCE_C value
	 */
	public void setPowerConvergenceC (java.math.BigDecimal powerConvergenceC) {
		this.powerConvergenceC = powerConvergenceC;
	}



	/**
	 * Return the value associated with the column: POWER_CONVERGENCE_SC
	 */
	public java.math.BigDecimal getPowerConvergenceSc () {
		return powerConvergenceSc;
	}

	/**
	 * Set the value related to the column: POWER_CONVERGENCE_SC
	 * @param powerConvergenceSc the POWER_CONVERGENCE_SC value
	 */
	public void setPowerConvergenceSc (java.math.BigDecimal powerConvergenceSc) {
		this.powerConvergenceSc = powerConvergenceSc;
	}



	/**
	 * Return the value associated with the column: CANDIDATE_POSSES_GLASSES
	 */
	public java.lang.String getCandidatePossesGlasses () {
		return candidatePossesGlasses;
	}

	/**
	 * Set the value related to the column: CANDIDATE_POSSES_GLASSES
	 * @param candidatePossesGlasses the CANDIDATE_POSSES_GLASSES value
	 */
	public void setCandidatePossesGlasses (java.lang.String candidatePossesGlasses) {
		this.candidatePossesGlasses = candidatePossesGlasses;
	}



	/**
	 * Return the value associated with the column: DISTANT_RIGHT_S
	 */
	public java.math.BigDecimal getDistantRightS () {
		return distantRightS;
	}

	/**
	 * Set the value related to the column: DISTANT_RIGHT_S
	 * @param distantRightS the DISTANT_RIGHT_S value
	 */
	public void setDistantRightS (java.math.BigDecimal distantRightS) {
		this.distantRightS = distantRightS;
	}



	/**
	 * Return the value associated with the column: DISTANT_RIGHT_C
	 */
	public java.math.BigDecimal getDistantRightC () {
		return distantRightC;
	}

	/**
	 * Set the value related to the column: DISTANT_RIGHT_C
	 * @param distantRightC the DISTANT_RIGHT_C value
	 */
	public void setDistantRightC (java.math.BigDecimal distantRightC) {
		this.distantRightC = distantRightC;
	}



	/**
	 * Return the value associated with the column: DISTANT_RIGHT_A
	 */
	public java.math.BigDecimal getDistantRightA () {
		return distantRightA;
	}

	/**
	 * Set the value related to the column: DISTANT_RIGHT_A
	 * @param distantRightA the DISTANT_RIGHT_A value
	 */
	public void setDistantRightA (java.math.BigDecimal distantRightA) {
		this.distantRightA = distantRightA;
	}



	/**
	 * Return the value associated with the column: DISTANT_LEFT_S
	 */
	public java.math.BigDecimal getDistantLeftS () {
		return distantLeftS;
	}

	/**
	 * Set the value related to the column: DISTANT_LEFT_S
	 * @param distantLeftS the DISTANT_LEFT_S value
	 */
	public void setDistantLeftS (java.math.BigDecimal distantLeftS) {
		this.distantLeftS = distantLeftS;
	}



	/**
	 * Return the value associated with the column: DISTANT_LEFT_C
	 */
	public java.math.BigDecimal getDistantLeftC () {
		return distantLeftC;
	}

	/**
	 * Set the value related to the column: DISTANT_LEFT_C
	 * @param distantLeftC the DISTANT_LEFT_C value
	 */
	public void setDistantLeftC (java.math.BigDecimal distantLeftC) {
		this.distantLeftC = distantLeftC;
	}



	/**
	 * Return the value associated with the column: DISTANT_LEFT_A
	 */
	public java.math.BigDecimal getDistantLeftA () {
		return distantLeftA;
	}

	/**
	 * Set the value related to the column: DISTANT_LEFT_A
	 * @param distantLeftA the DISTANT_LEFT_A value
	 */
	public void setDistantLeftA (java.math.BigDecimal distantLeftA) {
		this.distantLeftA = distantLeftA;
	}



	/**
	 * Return the value associated with the column: NEAR_RIGHT_S
	 */
	public java.math.BigDecimal getNearRightS () {
		return nearRightS;
	}

	/**
	 * Set the value related to the column: NEAR_RIGHT_S
	 * @param nearRightS the NEAR_RIGHT_S value
	 */
	public void setNearRightS (java.math.BigDecimal nearRightS) {
		this.nearRightS = nearRightS;
	}



	/**
	 * Return the value associated with the column: NEAR_RIGHT_C
	 */
	public java.math.BigDecimal getNearRightC () {
		return nearRightC;
	}

	/**
	 * Set the value related to the column: NEAR_RIGHT_C
	 * @param nearRightC the NEAR_RIGHT_C value
	 */
	public void setNearRightC (java.math.BigDecimal nearRightC) {
		this.nearRightC = nearRightC;
	}



	/**
	 * Return the value associated with the column: NEAR_RIGHT_A
	 */
	public java.math.BigDecimal getNearRightA () {
		return nearRightA;
	}

	/**
	 * Set the value related to the column: NEAR_RIGHT_A
	 * @param nearRightA the NEAR_RIGHT_A value
	 */
	public void setNearRightA (java.math.BigDecimal nearRightA) {
		this.nearRightA = nearRightA;
	}



	/**
	 * Return the value associated with the column: NEAR_LEFT_S
	 */
	public java.math.BigDecimal getNearLeftS () {
		return nearLeftS;
	}

	/**
	 * Set the value related to the column: NEAR_LEFT_S
	 * @param nearLeftS the NEAR_LEFT_S value
	 */
	public void setNearLeftS (java.math.BigDecimal nearLeftS) {
		this.nearLeftS = nearLeftS;
	}



	/**
	 * Return the value associated with the column: NEAR_LEFT_C
	 */
	public java.math.BigDecimal getNearLeftC () {
		return nearLeftC;
	}

	/**
	 * Set the value related to the column: NEAR_LEFT_C
	 * @param nearLeftC the NEAR_LEFT_C value
	 */
	public void setNearLeftC (java.math.BigDecimal nearLeftC) {
		this.nearLeftC = nearLeftC;
	}



	/**
	 * Return the value associated with the column: NEAR_LEFT_A
	 */
	public java.math.BigDecimal getNearLeftA () {
		return nearLeftA;
	}

	/**
	 * Set the value related to the column: NEAR_LEFT_A
	 * @param nearLeftA the NEAR_LEFT_A value
	 */
	public void setNearLeftA (java.math.BigDecimal nearLeftA) {
		this.nearLeftA = nearLeftA;
	}



	/**
	 * Return the value associated with the column: TUNNING_RT_RINNIE
	 */
	public java.lang.String getTunningRtRinnie () {
		return tunningRtRinnie;
	}

	/**
	 * Set the value related to the column: TUNNING_RT_RINNIE
	 * @param tunningRtRinnie the TUNNING_RT_RINNIE value
	 */
	public void setTunningRtRinnie (java.lang.String tunningRtRinnie) {
		this.tunningRtRinnie = tunningRtRinnie;
	}



	/**
	 * Return the value associated with the column: TUNNING_RT_WEBE
	 */
	public java.lang.String getTunningRtWebe () {
		return tunningRtWebe;
	}

	/**
	 * Set the value related to the column: TUNNING_RT_WEBE
	 * @param tunningRtWebe the TUNNING_RT_WEBE value
	 */
	public void setTunningRtWebe (java.lang.String tunningRtWebe) {
		this.tunningRtWebe = tunningRtWebe;
	}



	/**
	 * Return the value associated with the column: TUNNING_RT_ABC
	 */
	public java.lang.String getTunningRtAbc () {
		return tunningRtAbc;
	}

	/**
	 * Set the value related to the column: TUNNING_RT_ABC
	 * @param tunningRtAbc the TUNNING_RT_ABC value
	 */
	public void setTunningRtAbc (java.lang.String tunningRtAbc) {
		this.tunningRtAbc = tunningRtAbc;
	}



	/**
	 * Return the value associated with the column: TUNNING_LT_RINNIE
	 */
	public java.lang.String getTunningLtRinnie () {
		return tunningLtRinnie;
	}

	/**
	 * Set the value related to the column: TUNNING_LT_RINNIE
	 * @param tunningLtRinnie the TUNNING_LT_RINNIE value
	 */
	public void setTunningLtRinnie (java.lang.String tunningLtRinnie) {
		this.tunningLtRinnie = tunningLtRinnie;
	}



	/**
	 * Return the value associated with the column: TUNNING_LT_WEBE
	 */
	public java.lang.String getTunningLtWebe () {
		return tunningLtWebe;
	}

	/**
	 * Set the value related to the column: TUNNING_LT_WEBE
	 * @param tunningLtWebe the TUNNING_LT_WEBE value
	 */
	public void setTunningLtWebe (java.lang.String tunningLtWebe) {
		this.tunningLtWebe = tunningLtWebe;
	}



	/**
	 * Return the value associated with the column: TUNNING_LT_ABC
	 */
	public java.lang.String getTunningLtAbc () {
		return tunningLtAbc;
	}

	/**
	 * Set the value related to the column: TUNNING_LT_ABC
	 * @param tunningLtAbc the TUNNING_LT_ABC value
	 */
	public void setTunningLtAbc (java.lang.String tunningLtAbc) {
		this.tunningLtAbc = tunningLtAbc;
	}



	/**
	 * Return the value associated with the column: SPEECH_INTELLIGIBL_RT
	 */
	public java.lang.String getSpeechIntelligiblRt () {
		return speechIntelligiblRt;
	}

	/**
	 * Set the value related to the column: SPEECH_INTELLIGIBL_RT
	 * @param speechIntelligiblRt the SPEECH_INTELLIGIBL_RT value
	 */
	public void setSpeechIntelligiblRt (java.lang.String speechIntelligiblRt) {
		this.speechIntelligiblRt = speechIntelligiblRt;
	}



	/**
	 * Return the value associated with the column: SPEECH_INTELLIGIBL_LT
	 */
	public java.lang.String getSpeechIntelligiblLt () {
		return speechIntelligiblLt;
	}

	/**
	 * Set the value related to the column: SPEECH_INTELLIGIBL_LT
	 * @param speechIntelligiblLt the SPEECH_INTELLIGIBL_LT value
	 */
	public void setSpeechIntelligiblLt (java.lang.String speechIntelligiblLt) {
		this.speechIntelligiblLt = speechIntelligiblLt;
	}



	/**
	 * Return the value associated with the column: SPEECH_RT_RESULT
	 */
	public java.lang.String getSpeechRtResult () {
		return speechRtResult;
	}

	/**
	 * Set the value related to the column: SPEECH_RT_RESULT
	 * @param speechRtResult the SPEECH_RT_RESULT value
	 */
	public void setSpeechRtResult (java.lang.String speechRtResult) {
		this.speechRtResult = speechRtResult;
	}



	/**
	 * Return the value associated with the column: SPEECH_LT_RESULT
	 */
	public java.lang.String getSpeechLtResult () {
		return speechLtResult;
	}

	/**
	 * Set the value related to the column: SPEECH_LT_RESULT
	 * @param speechLtResult the SPEECH_LT_RESULT value
	 */
	public void setSpeechLtResult (java.lang.String speechLtResult) {
		this.speechLtResult = speechLtResult;
	}



	/**
	 * Return the value associated with the column: SYSTEMIC_SKIN
	 */
	public java.lang.String getSystemicSkin () {
		return systemicSkin;
	}

	/**
	 * Set the value related to the column: SYSTEMIC_SKIN
	 * @param systemicSkin the SYSTEMIC_SKIN value
	 */
	public void setSystemicSkin (java.lang.String systemicSkin) {
		this.systemicSkin = systemicSkin;
	}



	/**
	 * Return the value associated with the column: SYSTEM_LYMPHNODE_LYMPHATIC
	 */
	public java.lang.String getSystemLymphnodeLymphatic () {
		return systemLymphnodeLymphatic;
	}

	/**
	 * Set the value related to the column: SYSTEM_LYMPHNODE_LYMPHATIC
	 * @param systemLymphnodeLymphatic the SYSTEM_LYMPHNODE_LYMPHATIC value
	 */
	public void setSystemLymphnodeLymphatic (java.lang.String systemLymphnodeLymphatic) {
		this.systemLymphnodeLymphatic = systemLymphnodeLymphatic;
	}



	/**
	 * Return the value associated with the column: SYSTEM_HEAD_FACE_NECK
	 */
	public java.lang.String getSystemHeadFaceNeck () {
		return systemHeadFaceNeck;
	}

	/**
	 * Set the value related to the column: SYSTEM_HEAD_FACE_NECK
	 * @param systemHeadFaceNeck the SYSTEM_HEAD_FACE_NECK value
	 */
	public void setSystemHeadFaceNeck (java.lang.String systemHeadFaceNeck) {
		this.systemHeadFaceNeck = systemHeadFaceNeck;
	}



	/**
	 * Return the value associated with the column: SYSTEM_UPER_LOWER_EXTREMITIE
	 */
	public java.lang.String getSystemUperLowerExtremitie () {
		return systemUperLowerExtremitie;
	}

	/**
	 * Set the value related to the column: SYSTEM_UPER_LOWER_EXTREMITIE
	 * @param systemUperLowerExtremitie the SYSTEM_UPER_LOWER_EXTREMITIE value
	 */
	public void setSystemUperLowerExtremitie (java.lang.String systemUperLowerExtremitie) {
		this.systemUperLowerExtremitie = systemUperLowerExtremitie;
	}



	/**
	 * Return the value associated with the column: SYSTEM_SPINE_MUSCULO
	 */
	public java.lang.String getSystemSpineMusculo () {
		return systemSpineMusculo;
	}

	/**
	 * Set the value related to the column: SYSTEM_SPINE_MUSCULO
	 * @param systemSpineMusculo the SYSTEM_SPINE_MUSCULO value
	 */
	public void setSystemSpineMusculo (java.lang.String systemSpineMusculo) {
		this.systemSpineMusculo = systemSpineMusculo;
	}



	/**
	 * Return the value associated with the column: SYSTEM_CHEST_LUNGS
	 */
	public java.lang.String getSystemChestLungs () {
		return systemChestLungs;
	}

	/**
	 * Set the value related to the column: SYSTEM_CHEST_LUNGS
	 * @param systemChestLungs the SYSTEM_CHEST_LUNGS value
	 */
	public void setSystemChestLungs (java.lang.String systemChestLungs) {
		this.systemChestLungs = systemChestLungs;
	}



	/**
	 * Return the value associated with the column: SYSTEM_HEART
	 */
	public java.lang.String getSystemHeart () {
		return systemHeart;
	}

	/**
	 * Set the value related to the column: SYSTEM_HEART
	 * @param systemHeart the SYSTEM_HEART value
	 */
	public void setSystemHeart (java.lang.String systemHeart) {
		this.systemHeart = systemHeart;
	}



	/**
	 * Return the value associated with the column: SYSTEM_VASCULAR
	 */
	public java.lang.String getSystemVascular () {
		return systemVascular;
	}

	/**
	 * Set the value related to the column: SYSTEM_VASCULAR
	 * @param systemVascular the SYSTEM_VASCULAR value
	 */
	public void setSystemVascular (java.lang.String systemVascular) {
		this.systemVascular = systemVascular;
	}



	/**
	 * Return the value associated with the column: SYSTEM_ABDOMEN_VISCERA
	 */
	public java.lang.String getSystemAbdomenViscera () {
		return systemAbdomenViscera;
	}

	/**
	 * Set the value related to the column: SYSTEM_ABDOMEN_VISCERA
	 * @param systemAbdomenViscera the SYSTEM_ABDOMEN_VISCERA value
	 */
	public void setSystemAbdomenViscera (java.lang.String systemAbdomenViscera) {
		this.systemAbdomenViscera = systemAbdomenViscera;
	}



	/**
	 * Return the value associated with the column: SYSTEM_PERINCUM_ANUS
	 */
	public java.lang.String getSystemPerincumAnus () {
		return systemPerincumAnus;
	}

	/**
	 * Set the value related to the column: SYSTEM_PERINCUM_ANUS
	 * @param systemPerincumAnus the SYSTEM_PERINCUM_ANUS value
	 */
	public void setSystemPerincumAnus (java.lang.String systemPerincumAnus) {
		this.systemPerincumAnus = systemPerincumAnus;
	}



	/**
	 * Return the value associated with the column: SYSTEM_GENITOURINARY
	 */
	public java.lang.String getSystemGenitourinary () {
		return systemGenitourinary;
	}

	/**
	 * Set the value related to the column: SYSTEM_GENITOURINARY
	 * @param systemGenitourinary the SYSTEM_GENITOURINARY value
	 */
	public void setSystemGenitourinary (java.lang.String systemGenitourinary) {
		this.systemGenitourinary = systemGenitourinary;
	}



	/**
	 * Return the value associated with the column: SYSTEM_ENDOCRINE
	 */
	public java.lang.String getSystemEndocrine () {
		return systemEndocrine;
	}

	/**
	 * Set the value related to the column: SYSTEM_ENDOCRINE
	 * @param systemEndocrine the SYSTEM_ENDOCRINE value
	 */
	public void setSystemEndocrine (java.lang.String systemEndocrine) {
		this.systemEndocrine = systemEndocrine;
	}



	/**
	 * Return the value associated with the column: SYSTEM_NEUROLOGIC
	 */
	public java.lang.String getSystemNeurologic () {
		return systemNeurologic;
	}

	/**
	 * Set the value related to the column: SYSTEM_NEUROLOGIC
	 * @param systemNeurologic the SYSTEM_NEUROLOGIC value
	 */
	public void setSystemNeurologic (java.lang.String systemNeurologic) {
		this.systemNeurologic = systemNeurologic;
	}



	/**
	 * Return the value associated with the column: SYSTEM_PSYCHIARTRIC
	 */
	public java.lang.String getSystemPsychiartric () {
		return systemPsychiartric;
	}

	/**
	 * Set the value related to the column: SYSTEM_PSYCHIARTRIC
	 * @param systemPsychiartric the SYSTEM_PSYCHIARTRIC value
	 */
	public void setSystemPsychiartric (java.lang.String systemPsychiartric) {
		this.systemPsychiartric = systemPsychiartric;
	}



	/**
	 * Return the value associated with the column: REMARKS_SKIN
	 */
	public java.lang.String getRemarksSkin () {
		return remarksSkin;
	}

	/**
	 * Set the value related to the column: REMARKS_SKIN
	 * @param remarksSkin the REMARKS_SKIN value
	 */
	public void setRemarksSkin (java.lang.String remarksSkin) {
		this.remarksSkin = remarksSkin;
	}



	/**
	 * Return the value associated with the column: REMARKS_LYMPHNODE_LYMPHATIC
	 */
	public java.lang.String getRemarksLymphnodeLymphatic () {
		return remarksLymphnodeLymphatic;
	}

	/**
	 * Set the value related to the column: REMARKS_LYMPHNODE_LYMPHATIC
	 * @param remarksLymphnodeLymphatic the REMARKS_LYMPHNODE_LYMPHATIC value
	 */
	public void setRemarksLymphnodeLymphatic (java.lang.String remarksLymphnodeLymphatic) {
		this.remarksLymphnodeLymphatic = remarksLymphnodeLymphatic;
	}



	/**
	 * Return the value associated with the column: REMARKS_HEAD_FACE_NECK
	 */
	public java.lang.String getRemarksHeadFaceNeck () {
		return remarksHeadFaceNeck;
	}

	/**
	 * Set the value related to the column: REMARKS_HEAD_FACE_NECK
	 * @param remarksHeadFaceNeck the REMARKS_HEAD_FACE_NECK value
	 */
	public void setRemarksHeadFaceNeck (java.lang.String remarksHeadFaceNeck) {
		this.remarksHeadFaceNeck = remarksHeadFaceNeck;
	}



	/**
	 * Return the value associated with the column: REMARKS_UPER_LOWER_EXTREMITIE
	 */
	public java.lang.String getRemarksUperLowerExtremitie () {
		return remarksUperLowerExtremitie;
	}

	/**
	 * Set the value related to the column: REMARKS_UPER_LOWER_EXTREMITIE
	 * @param remarksUperLowerExtremitie the REMARKS_UPER_LOWER_EXTREMITIE value
	 */
	public void setRemarksUperLowerExtremitie (java.lang.String remarksUperLowerExtremitie) {
		this.remarksUperLowerExtremitie = remarksUperLowerExtremitie;
	}



	/**
	 * Return the value associated with the column: REMARKS_SPINE_MUSCULO
	 */
	public java.lang.String getRemarksSpineMusculo () {
		return remarksSpineMusculo;
	}

	/**
	 * Set the value related to the column: REMARKS_SPINE_MUSCULO
	 * @param remarksSpineMusculo the REMARKS_SPINE_MUSCULO value
	 */
	public void setRemarksSpineMusculo (java.lang.String remarksSpineMusculo) {
		this.remarksSpineMusculo = remarksSpineMusculo;
	}



	/**
	 * Return the value associated with the column: REMARKS_CHEST_LUNGS
	 */
	public java.lang.String getRemarksChestLungs () {
		return remarksChestLungs;
	}

	/**
	 * Set the value related to the column: REMARKS_CHEST_LUNGS
	 * @param remarksChestLungs the REMARKS_CHEST_LUNGS value
	 */
	public void setRemarksChestLungs (java.lang.String remarksChestLungs) {
		this.remarksChestLungs = remarksChestLungs;
	}



	/**
	 * Return the value associated with the column: REMARKS_HEART
	 */
	public java.lang.String getRemarksHeart () {
		return remarksHeart;
	}

	/**
	 * Set the value related to the column: REMARKS_HEART
	 * @param remarksHeart the REMARKS_HEART value
	 */
	public void setRemarksHeart (java.lang.String remarksHeart) {
		this.remarksHeart = remarksHeart;
	}



	/**
	 * Return the value associated with the column: REMARKS_VASCULAR
	 */
	public java.lang.String getRemarksVascular () {
		return remarksVascular;
	}

	/**
	 * Set the value related to the column: REMARKS_VASCULAR
	 * @param remarksVascular the REMARKS_VASCULAR value
	 */
	public void setRemarksVascular (java.lang.String remarksVascular) {
		this.remarksVascular = remarksVascular;
	}



	/**
	 * Return the value associated with the column: REMARKS_ABDOMEN_VISCERA
	 */
	public java.lang.String getRemarksAbdomenViscera () {
		return remarksAbdomenViscera;
	}

	/**
	 * Set the value related to the column: REMARKS_ABDOMEN_VISCERA
	 * @param remarksAbdomenViscera the REMARKS_ABDOMEN_VISCERA value
	 */
	public void setRemarksAbdomenViscera (java.lang.String remarksAbdomenViscera) {
		this.remarksAbdomenViscera = remarksAbdomenViscera;
	}



	/**
	 * Return the value associated with the column: REMARKS_PERINCUM_ANUS
	 */
	public java.lang.String getRemarksPerincumAnus () {
		return remarksPerincumAnus;
	}

	/**
	 * Set the value related to the column: REMARKS_PERINCUM_ANUS
	 * @param remarksPerincumAnus the REMARKS_PERINCUM_ANUS value
	 */
	public void setRemarksPerincumAnus (java.lang.String remarksPerincumAnus) {
		this.remarksPerincumAnus = remarksPerincumAnus;
	}



	/**
	 * Return the value associated with the column: REMARKS_GENITOURINARY
	 */
	public java.lang.String getRemarksGenitourinary () {
		return remarksGenitourinary;
	}

	/**
	 * Set the value related to the column: REMARKS_GENITOURINARY
	 * @param remarksGenitourinary the REMARKS_GENITOURINARY value
	 */
	public void setRemarksGenitourinary (java.lang.String remarksGenitourinary) {
		this.remarksGenitourinary = remarksGenitourinary;
	}



	/**
	 * Return the value associated with the column: REMARKS_ENDOCRINE
	 */
	public java.lang.String getRemarksEndocrine () {
		return remarksEndocrine;
	}

	/**
	 * Set the value related to the column: REMARKS_ENDOCRINE
	 * @param remarksEndocrine the REMARKS_ENDOCRINE value
	 */
	public void setRemarksEndocrine (java.lang.String remarksEndocrine) {
		this.remarksEndocrine = remarksEndocrine;
	}



	/**
	 * Return the value associated with the column: REMARKS_NEUROLOGIC
	 */
	public java.lang.String getRemarksNeurologic () {
		return remarksNeurologic;
	}

	/**
	 * Set the value related to the column: REMARKS_NEUROLOGIC
	 * @param remarksNeurologic the REMARKS_NEUROLOGIC value
	 */
	public void setRemarksNeurologic (java.lang.String remarksNeurologic) {
		this.remarksNeurologic = remarksNeurologic;
	}



	/**
	 * Return the value associated with the column: REMARKS_PSYCHIARTRIC
	 */
	public java.lang.String getRemarksPsychiartric () {
		return remarksPsychiartric;
	}

	/**
	 * Set the value related to the column: REMARKS_PSYCHIARTRIC
	 * @param remarksPsychiartric the REMARKS_PSYCHIARTRIC value
	 */
	public void setRemarksPsychiartric (java.lang.String remarksPsychiartric) {
		this.remarksPsychiartric = remarksPsychiartric;
	}



	/**
	 * Return the value associated with the column: hear_rt_cv
	 */
	public java.math.BigDecimal getHearRtCv () {
		return hearRtCv;
	}

	/**
	 * Set the value related to the column: hear_rt_cv
	 * @param hearRtCv the hear_rt_cv value
	 */
	public void setHearRtCv (java.math.BigDecimal hearRtCv) {
		this.hearRtCv = hearRtCv;
	}



	/**
	 * Return the value associated with the column: hear_rt_fwv
	 */
	public java.math.BigDecimal getHearRtFwv () {
		return hearRtFwv;
	}

	/**
	 * Set the value related to the column: hear_rt_fwv
	 * @param hearRtFwv the hear_rt_fwv value
	 */
	public void setHearRtFwv (java.math.BigDecimal hearRtFwv) {
		this.hearRtFwv = hearRtFwv;
	}



	/**
	 * Return the value associated with the column: hear_rt_both
	 */
	public java.math.BigDecimal getHearRtBoth () {
		return hearRtBoth;
	}

	/**
	 * Set the value related to the column: hear_rt_both
	 * @param hearRtBoth the hear_rt_both value
	 */
	public void setHearRtBoth (java.math.BigDecimal hearRtBoth) {
		this.hearRtBoth = hearRtBoth;
	}



	/**
	 * Return the value associated with the column: hear_lt_cv
	 */
	public java.math.BigDecimal getHearLtCv () {
		return hearLtCv;
	}

	/**
	 * Set the value related to the column: hear_lt_cv
	 * @param hearLtCv the hear_lt_cv value
	 */
	public void setHearLtCv (java.math.BigDecimal hearLtCv) {
		this.hearLtCv = hearLtCv;
	}



	/**
	 * Return the value associated with the column: hear_lt_fwv
	 */
	public java.math.BigDecimal getHearLtFwv () {
		return hearLtFwv;
	}

	/**
	 * Set the value related to the column: hear_lt_fwv
	 * @param hearLtFwv the hear_lt_fwv value
	 */
	public void setHearLtFwv (java.math.BigDecimal hearLtFwv) {
		this.hearLtFwv = hearLtFwv;
	}



	/**
	 * Return the value associated with the column: hear_lt_both
	 */
	public java.math.BigDecimal getHearLtBoth () {
		return hearLtBoth;
	}

	/**
	 * Set the value related to the column: hear_lt_both
	 * @param hearLtBoth the hear_lt_both value
	 */
	public void setHearLtBoth (java.math.BigDecimal hearLtBoth) {
		this.hearLtBoth = hearLtBoth;
	}



	/**
	 * Return the value associated with the column: audio_rt_250
	 */
	public java.math.BigDecimal getAudioRt250 () {
		return audioRt250;
	}

	/**
	 * Set the value related to the column: audio_rt_250
	 * @param audioRt250 the audio_rt_250 value
	 */
	public void setAudioRt250 (java.math.BigDecimal audioRt250) {
		this.audioRt250 = audioRt250;
	}



	/**
	 * Return the value associated with the column: audio_lt_250
	 */
	public java.math.BigDecimal getAudioLt250 () {
		return audioLt250;
	}

	/**
	 * Set the value related to the column: audio_lt_250
	 * @param audioLt250 the audio_lt_250 value
	 */
	public void setAudioLt250 (java.math.BigDecimal audioLt250) {
		this.audioLt250 = audioLt250;
	}



	/**
	 * Return the value associated with the column: audio_rt_500
	 */
	public java.math.BigDecimal getAudioRt500 () {
		return audioRt500;
	}

	/**
	 * Set the value related to the column: audio_rt_500
	 * @param audioRt500 the audio_rt_500 value
	 */
	public void setAudioRt500 (java.math.BigDecimal audioRt500) {
		this.audioRt500 = audioRt500;
	}



	/**
	 * Return the value associated with the column: audio_lt_500
	 */
	public java.math.BigDecimal getAudioLt500 () {
		return audioLt500;
	}

	/**
	 * Set the value related to the column: audio_lt_500
	 * @param audioLt500 the audio_lt_500 value
	 */
	public void setAudioLt500 (java.math.BigDecimal audioLt500) {
		this.audioLt500 = audioLt500;
	}



	/**
	 * Return the value associated with the column: audio_rt_1000
	 */
	public java.math.BigDecimal getAudioRt1000 () {
		return audioRt1000;
	}

	/**
	 * Set the value related to the column: audio_rt_1000
	 * @param audioRt1000 the audio_rt_1000 value
	 */
	public void setAudioRt1000 (java.math.BigDecimal audioRt1000) {
		this.audioRt1000 = audioRt1000;
	}



	/**
	 * Return the value associated with the column: audio_lt_1000
	 */
	public java.math.BigDecimal getAudioLt1000 () {
		return audioLt1000;
	}

	/**
	 * Set the value related to the column: audio_lt_1000
	 * @param audioLt1000 the audio_lt_1000 value
	 */
	public void setAudioLt1000 (java.math.BigDecimal audioLt1000) {
		this.audioLt1000 = audioLt1000;
	}



	/**
	 * Return the value associated with the column: audio_rt_2000
	 */
	public java.math.BigDecimal getAudioRt2000 () {
		return audioRt2000;
	}

	/**
	 * Set the value related to the column: audio_rt_2000
	 * @param audioRt2000 the audio_rt_2000 value
	 */
	public void setAudioRt2000 (java.math.BigDecimal audioRt2000) {
		this.audioRt2000 = audioRt2000;
	}



	/**
	 * Return the value associated with the column: audio_lt_2000
	 */
	public java.math.BigDecimal getAudioLt2000 () {
		return audioLt2000;
	}

	/**
	 * Set the value related to the column: audio_lt_2000
	 * @param audioLt2000 the audio_lt_2000 value
	 */
	public void setAudioLt2000 (java.math.BigDecimal audioLt2000) {
		this.audioLt2000 = audioLt2000;
	}



	/**
	 * Return the value associated with the column: audio_rt_3000
	 */
	public java.math.BigDecimal getAudioRt3000 () {
		return audioRt3000;
	}

	/**
	 * Set the value related to the column: audio_rt_3000
	 * @param audioRt3000 the audio_rt_3000 value
	 */
	public void setAudioRt3000 (java.math.BigDecimal audioRt3000) {
		this.audioRt3000 = audioRt3000;
	}



	/**
	 * Return the value associated with the column: audio_lt_3000
	 */
	public java.math.BigDecimal getAudioLt3000 () {
		return audioLt3000;
	}

	/**
	 * Set the value related to the column: audio_lt_3000
	 * @param audioLt3000 the audio_lt_3000 value
	 */
	public void setAudioLt3000 (java.math.BigDecimal audioLt3000) {
		this.audioLt3000 = audioLt3000;
	}



	/**
	 * Return the value associated with the column: av_status
	 */
	public java.lang.String getAvStatus () {
		return avStatus;
	}

	/**
	 * Set the value related to the column: av_status
	 * @param avStatus the av_status value
	 */
	public void setAvStatus (java.lang.String avStatus) {
		this.avStatus = avStatus;
	}



	/**
	 * Return the value associated with the column: EXAMINATION_BREASTS
	 */
	public java.lang.String getExaminationBreasts () {
		return examinationBreasts;
	}

	/**
	 * Set the value related to the column: EXAMINATION_BREASTS
	 * @param examinationBreasts the EXAMINATION_BREASTS value
	 */
	public void setExaminationBreasts (java.lang.String examinationBreasts) {
		this.examinationBreasts = examinationBreasts;
	}



	/**
	 * Return the value associated with the column: menstruation_date
	 */
	public java.util.Date getMenstruationDate () {
		return menstruationDate;
	}

	/**
	 * Set the value related to the column: menstruation_date
	 * @param menstruationDate the menstruation_date value
	 */
	public void setMenstruationDate (java.util.Date menstruationDate) {
		this.menstruationDate = menstruationDate;
	}



	/**
	 * Return the value associated with the column: pelvic_examination
	 */
	public java.lang.String getPelvicExamination () {
		return pelvicExamination;
	}

	/**
	 * Set the value related to the column: pelvic_examination
	 * @param pelvicExamination the pelvic_examination value
	 */
	public void setPelvicExamination (java.lang.String pelvicExamination) {
		this.pelvicExamination = pelvicExamination;
	}



	/**
	 * Return the value associated with the column: ma_date
	 */
	public java.util.Date getMaDate () {
		return maDate;
	}

	/**
	 * Set the value related to the column: ma_date
	 * @param maDate the ma_date value
	 */
	public void setMaDate (java.util.Date maDate) {
		this.maDate = maDate;
	}



	/**
	 * Return the value associated with the column: mo_date
	 */
	public java.util.Date getMoDate () {
		return moDate;
	}

	/**
	 * Set the value related to the column: mo_date
	 * @param moDate the mo_date value
	 */
	public void setMoDate (java.util.Date moDate) {
		this.moDate = moDate;
	}



	/**
	 * Return the value associated with the column: mo_name
	 */
	public java.lang.String getMoName () {
		return moName;
	}

	/**
	 * Set the value related to the column: mo_name
	 * @param moName the mo_name value
	 */
	public void setMoName (java.lang.String moName) {
		this.moName = moName;
	}



	/**
	 * Return the value associated with the column: XRAY_CHEST
	 */
	public java.lang.String getXrayChest () {
		return xrayChest;
	}

	/**
	 * Set the value related to the column: XRAY_CHEST
	 * @param xrayChest the XRAY_CHEST value
	 */
	public void setXrayChest (java.lang.String xrayChest) {
		this.xrayChest = xrayChest;
	}



	/**
	 * Return the value associated with the column: URINALYSIS
	 */
	public java.lang.String getUrinalysis () {
		return urinalysis;
	}

	/**
	 * Set the value related to the column: URINALYSIS
	 * @param urinalysis the URINALYSIS value
	 */
	public void setUrinalysis (java.lang.String urinalysis) {
		this.urinalysis = urinalysis;
	}



	/**
	 * Return the value associated with the column: HB
	 */
	public java.lang.String getHb () {
		return hb;
	}

	/**
	 * Set the value related to the column: HB
	 * @param hb the HB value
	 */
	public void setHb (java.lang.String hb) {
		this.hb = hb;
	}



	/**
	 * Return the value associated with the column: TLC
	 */
	public java.lang.String getTlc () {
		return tlc;
	}

	/**
	 * Set the value related to the column: TLC
	 * @param tlc the TLC value
	 */
	public void setTlc (java.lang.String tlc) {
		this.tlc = tlc;
	}



	/**
	 * Return the value associated with the column: DLC
	 */
	public java.lang.String getDlc () {
		return dlc;
	}

	/**
	 * Set the value related to the column: DLC
	 * @param dlc the DLC value
	 */
	public void setDlc (java.lang.String dlc) {
		this.dlc = dlc;
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
	 * Return the value associated with the column: aviCa34_id
	 */
	public jkt.hms.masters.business.AviCa34 getAviCa34 () {
		return aviCa34;
	}

	/**
	 * Set the value related to the column: aviCa34_id
	 * @param aviCa34 the aviCa34_id value
	 */
	public void setAviCa34 (jkt.hms.masters.business.AviCa34 aviCa34) {
		this.aviCa34 = aviCa34;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.AvMedicalExamMaMo)) return false;
		else {
			jkt.hms.masters.business.AvMedicalExamMaMo avMedicalExamMaMo = (jkt.hms.masters.business.AvMedicalExamMaMo) obj;
			if (null == this.getId() || null == avMedicalExamMaMo.getId()) return false;
			else return (this.getId().equals(avMedicalExamMaMo.getId()));
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
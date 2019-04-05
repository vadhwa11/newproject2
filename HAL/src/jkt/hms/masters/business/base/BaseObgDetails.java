package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the obg_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="obg_details"
 */

public abstract class BaseObgDetails  implements Serializable {

	public static String REF = "ObgDetails";
	public static String PROP_GYN_ABDOMEN_INSPECTION = "GynAbdomenInspection";
	public static String PROP_MASS_POSITION = "MassPosition";
	public static String PROP_LENGTH_OF_CERVIX = "LengthOfCervix";
	public static String PROP_S2 = "S2";
	public static String PROP_S1 = "S1";
	public static String PROP_GYN_LOCAL_EXAMINATION = "GynLocalExamination";
	public static String PROP_LIQUOR = "Liquor";
	public static String PROP_DILATATION_OF_CERVIX = "DilatationOfCervix";
	public static String PROP_PV = "Pv";
	public static String PROP_MENSTRUAL_PATTERN2 = "MenstrualPattern2";
	public static String PROP_MENSTRUAL_PATTERN1 = "MenstrualPattern1";
	public static String PROP_OPD_PATIENT_DETAILS = "OpdPatientDetails";
	public static String PROP_DYSMENORRHEA = "Dysmenorrhea";
	public static String PROP_RESPIRATORY_SYSTEM = "RespiratorySystem";
	public static String PROP_UTERUS_FORNESS = "UterusForness";
	public static String PROP_LOWER_POLE = "LowerPole";
	public static String PROP_IMMUNISED = "Immunised";
	public static String PROP_CONSAN_GUINITY = "ConsanGuinity";
	public static String PROP_TRIMISTERS = "Trimisters";
	public static String PROP_PAP_SMEAR = "PapSmear";
	public static String PROP_TT = "Tt";
	public static String PROP_PE = "Pe";
	public static String PROP_CYCLES = "Cycles";
	public static String PROP_PA = "Pa";
	public static String PROP_INSPECTION_SCAR = "InspectionScar";
	public static String PROP_HEAD = "Head";
	public static String PROP_MENSTRUAL_PAUSE = "MenstrualPause";
	public static String PROP_HOPI = "Hopi";
	public static String PROP_EXTERNAL_GENITALIA_OTHER = "ExternalGenitaliaOther";
	public static String PROP_OBSTRETIC_HISTORY = "ObstreticHistory";
	public static String PROP_INSPECTION_UMBILICUS = "InspectionUmbilicus";
	public static String PROP_BREADTH_ADDED_SOUNDS = "BreadthAddedSounds";
	public static String PROP_RANGE_VALUE = "RangeValue";
	public static String PROP_PELVIS = "Pelvis";
	public static String PROP_MURMURS = "Murmurs";
	public static String PROP_SURGICAL_HISTORY = "SurgicalHistory";
	public static String PROP_OBSTRETIC_SCORE_L = "ObstreticScoreL";
	public static String PROP_POSITION_OF_CERVIX = "PositionOfCervix";
	public static String PROP_OBSTRETIC_SCORE_P = "ObstreticScoreP";
	public static String PROP_ID = "Id";
	public static String PROP_PERSONAL_HISTORY = "PersonalHistory";
	public static String PROP_GYN_OBSTETRIC_HISTORY = "GynObstetricHistory";
	public static String PROP_GYN_AGE_OF_MENARCHE = "GynAgeOfMenarche";
	public static String PROP_BOOKED = "Booked";
	public static String PROP_STERILISATION = "Sterilisation";
	public static String PROP_SPECULUM_VAGINA = "SpeculumVagina";
	public static String PROP_GYN_INTERNAL_EXAMINATION = "GynInternalExamination";
	public static String PROP_MARRIED_LIFE = "MarriedLife";
	public static String PROP_OBG_REMARKS = "ObgRemarks";
	public static String PROP_EFFACEMENT_OF_CERVIX = "EffacementOfCervix";
	public static String PROP_FLOW = "Flow";
	public static String PROP_OBSTRETIC_SCORE_A = "ObstreticScoreA";
	public static String PROP_MASS_CONSISTENCY = "MassConsistency";
	public static String PROP_CONSISTENCY_OF_CERVIX = "ConsistencyOfCervix";
	public static String PROP_MASS_SHAPE = "MassShape";
	public static String PROP_HEIGHT_OF_UTERUS = "HeightOfUterus";
	public static String PROP_SPECIFY = "Specify";
	public static String PROP_CYCLE_TEXT = "CycleText";
	public static String PROP_LAST_MENSTRUAL = "LastMenstrual";
	public static String PROP_GYN_PALPATION = "GynPalpation";
	public static String PROP_OBSTRETIC_SCORE_G = "ObstreticScoreG";
	public static String PROP_GYN_BIMANUAL_EXAMINATION = "GynBimanualExamination";
	public static String PROP_INSPECTION_HERNIA = "InspectionHernia";
	public static String PROP_INSPECTION_ABDOMEN = "InspectionAbdomen";
	public static String PROP_MASS_SIZE = "MassSize";
	public static String PROP_SPECULUM_DECENT = "SpeculumDecent";
	public static String PROP_LOWER_GRIP = "LowerGrip";
	public static String PROP_FHR = "Fhr";
	public static String PROP_SPECULUM_CERVIX = "SpeculumCervix";
	public static String PROP_PALPATION = "Palpation";
	public static String PROP_GC = "Gc";
	public static String PROP_EXTERNAL_GENITALIA = "ExternalGenitalia";
	public static String PROP_UTERUS_CERVICAL_MOVEMENT = "UterusCervicalMovement";
	public static String PROP_OTHER_COMPLAINTS = "OtherComplaints";
	public static String PROP_CLINICAL_HSIRORY = "ClinicalHsirory";
	public static String PROP_MASS_PALPABLE = "MassPalpable";
	public static String PROP_MEMBRANE = "Membrane";
	public static String PROP_CONCEPTION = "Conception";
	public static String PROP_GYN_FLOW = "GynFlow";
	public static String PROP_SPECULUM_DISCHARGE = "SpeculumDischarge";
	public static String PROP_ASICITIS = "Asicitis";
	public static String PROP_PRESENTATION = "Presentation";
	public static String PROP_AGE_OF_MENARCHE = "AgeOfMenarche";
	public static String PROP_STATION_OF_PRESENTING_PART = "StationOfPresentingPart";
	public static String PROP_RANGE_INTERVAL = "RangeInterval";
	public static String PROP_MASS_TEMP = "MassTemp";
	public static String PROP_GYN_PER_SPECULUM = "GynPerSpeculum";
	public static String PROP_HEART_RATE_ABSENT = "HeartRateAbsent";
	public static String PROP_HEART_RATE_REGULAR = "HeartRateRegular";
	public static String PROP_UTERUS_SIZE = "UterusSize";


	// constructors
	public BaseObgDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseObgDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String otherComplaints;
	private java.lang.String hopi;
	private java.lang.String obstreticHistory;
	private java.lang.String conception;
	private java.lang.String marriedLife;
	private java.lang.String consanGuinity;
	private java.lang.String booked;
	private java.lang.String immunised;
	private java.lang.String trimisters;
	private java.lang.String specify;
	private java.lang.Integer ageOfMenarche;
	private java.lang.String cycles;
	private java.lang.String respiratorySystem;
	private java.lang.String breadthAddedSounds;
	private java.lang.String s1;
	private java.lang.String s2;
	private java.lang.String heightOfUterus;
	private java.lang.String lowerPole;
	private java.lang.String lowerGrip;
	private java.lang.Integer heartRateRegular;
	private java.lang.Integer heartRateAbsent;
	private java.lang.Integer dilatationOfCervix;
	private java.lang.String effacementOfCervix;
	private java.lang.String membrane;
	private java.lang.String liquor;
	private java.lang.String consistencyOfCervix;
	private java.lang.String positionOfCervix;
	private java.lang.Integer lengthOfCervix;
	private java.lang.Integer stationOfPresentingPart;
	private java.lang.String head;
	private java.lang.String pelvis;
	private java.lang.String flow;
	private java.lang.String rangeValue;
	private java.lang.Integer obstreticScoreG;
	private java.lang.Integer obstreticScoreP;
	private java.lang.Integer obstreticScoreA;
	private java.lang.Integer obstreticScoreL;
	private java.lang.String murmurs;
	private java.lang.String personalHistory;
	private java.lang.String clinicalHsirory;
	private java.lang.String surgicalHistory;
	private java.lang.String rangeInterval;
	private java.lang.String cycleText;
	private java.lang.String dysmenorrhea;
	private java.util.Date lastMenstrual;
	private java.lang.String inspectionAbdomen;
	private java.lang.String inspectionUmbilicus;
	private java.lang.String inspectionHernia;
	private java.lang.String inspectionScar;
	private java.lang.String massPalpable;
	private java.lang.String massSize;
	private java.lang.String massShape;
	private java.lang.String massPosition;
	private java.lang.String massConsistency;
	private java.lang.String massTemp;
	private java.lang.String asicitis;
	private java.lang.String externalGenitalia;
	private java.lang.String externalGenitaliaOther;
	private java.lang.String speculumVagina;
	private java.lang.String speculumDischarge;
	private java.lang.String speculumCervix;
	private java.lang.String speculumDecent;
	private java.lang.String uterusSize;
	private java.lang.String uterusForness;
	private java.lang.String uterusCervicalMovement;
	private java.lang.String gynObstetricHistory;
	private java.lang.String gynPalpation;
	private java.lang.String gynAbdomenInspection;
	private java.lang.String gynLocalExamination;
	private java.lang.String gynInternalExamination;
	private java.lang.String gynPerSpeculum;
	private java.lang.String gynBimanualExamination;
	private java.lang.String menstrualPattern1;
	private java.lang.String menstrualPattern2;
	private java.lang.Integer gynAgeOfMenarche;
	private java.lang.String gynFlow;
	private java.lang.String gc;
	private java.lang.String pa;
	private java.lang.String pe;
	private java.lang.String fhr;
	private java.lang.String presentation;
	private java.lang.String pv;
	private java.lang.Integer tt;
	private java.lang.String menstrualPause;
	private java.lang.String obgRemarks;
	private java.lang.String sterilisation;
	private java.lang.String papSmear;
	private java.lang.String palpation;

	// many to one
	private jkt.hms.masters.business.OpdPatientDetails opdPatientDetails;



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
	 * Return the value associated with the column: Other_Complaints
	 */
	public java.lang.String getOtherComplaints () {
		return otherComplaints;
	}

	/**
	 * Set the value related to the column: Other_Complaints
	 * @param otherComplaints the Other_Complaints value
	 */
	public void setOtherComplaints (java.lang.String otherComplaints) {
		this.otherComplaints = otherComplaints;
	}



	/**
	 * Return the value associated with the column: HOPI
	 */
	public java.lang.String getHopi () {
		return hopi;
	}

	/**
	 * Set the value related to the column: HOPI
	 * @param hopi the HOPI value
	 */
	public void setHopi (java.lang.String hopi) {
		this.hopi = hopi;
	}



	/**
	 * Return the value associated with the column: OBSTRETIC_HISTORY
	 */
	public java.lang.String getObstreticHistory () {
		return obstreticHistory;
	}

	/**
	 * Set the value related to the column: OBSTRETIC_HISTORY
	 * @param obstreticHistory the OBSTRETIC_HISTORY value
	 */
	public void setObstreticHistory (java.lang.String obstreticHistory) {
		this.obstreticHistory = obstreticHistory;
	}



	/**
	 * Return the value associated with the column: Conception
	 */
	public java.lang.String getConception () {
		return conception;
	}

	/**
	 * Set the value related to the column: Conception
	 * @param conception the Conception value
	 */
	public void setConception (java.lang.String conception) {
		this.conception = conception;
	}



	/**
	 * Return the value associated with the column: Married_Life
	 */
	public java.lang.String getMarriedLife () {
		return marriedLife;
	}

	/**
	 * Set the value related to the column: Married_Life
	 * @param marriedLife the Married_Life value
	 */
	public void setMarriedLife (java.lang.String marriedLife) {
		this.marriedLife = marriedLife;
	}



	/**
	 * Return the value associated with the column: Consan_Guinity
	 */
	public java.lang.String getConsanGuinity () {
		return consanGuinity;
	}

	/**
	 * Set the value related to the column: Consan_Guinity
	 * @param consanGuinity the Consan_Guinity value
	 */
	public void setConsanGuinity (java.lang.String consanGuinity) {
		this.consanGuinity = consanGuinity;
	}



	/**
	 * Return the value associated with the column: Booked
	 */
	public java.lang.String getBooked () {
		return booked;
	}

	/**
	 * Set the value related to the column: Booked
	 * @param booked the Booked value
	 */
	public void setBooked (java.lang.String booked) {
		this.booked = booked;
	}



	/**
	 * Return the value associated with the column: Immunised
	 */
	public java.lang.String getImmunised () {
		return immunised;
	}

	/**
	 * Set the value related to the column: Immunised
	 * @param immunised the Immunised value
	 */
	public void setImmunised (java.lang.String immunised) {
		this.immunised = immunised;
	}



	/**
	 * Return the value associated with the column: Trimisters
	 */
	public java.lang.String getTrimisters () {
		return trimisters;
	}

	/**
	 * Set the value related to the column: Trimisters
	 * @param trimisters the Trimisters value
	 */
	public void setTrimisters (java.lang.String trimisters) {
		this.trimisters = trimisters;
	}



	/**
	 * Return the value associated with the column: Specify
	 */
	public java.lang.String getSpecify () {
		return specify;
	}

	/**
	 * Set the value related to the column: Specify
	 * @param specify the Specify value
	 */
	public void setSpecify (java.lang.String specify) {
		this.specify = specify;
	}



	/**
	 * Return the value associated with the column: Age_Of_Menarche
	 */
	public java.lang.Integer getAgeOfMenarche () {
		return ageOfMenarche;
	}

	/**
	 * Set the value related to the column: Age_Of_Menarche
	 * @param ageOfMenarche the Age_Of_Menarche value
	 */
	public void setAgeOfMenarche (java.lang.Integer ageOfMenarche) {
		this.ageOfMenarche = ageOfMenarche;
	}



	/**
	 * Return the value associated with the column: Cycles
	 */
	public java.lang.String getCycles () {
		return cycles;
	}

	/**
	 * Set the value related to the column: Cycles
	 * @param cycles the Cycles value
	 */
	public void setCycles (java.lang.String cycles) {
		this.cycles = cycles;
	}



	/**
	 * Return the value associated with the column: Respiratory_System
	 */
	public java.lang.String getRespiratorySystem () {
		return respiratorySystem;
	}

	/**
	 * Set the value related to the column: Respiratory_System
	 * @param respiratorySystem the Respiratory_System value
	 */
	public void setRespiratorySystem (java.lang.String respiratorySystem) {
		this.respiratorySystem = respiratorySystem;
	}



	/**
	 * Return the value associated with the column: Breadth_Added_Sounds
	 */
	public java.lang.String getBreadthAddedSounds () {
		return breadthAddedSounds;
	}

	/**
	 * Set the value related to the column: Breadth_Added_Sounds
	 * @param breadthAddedSounds the Breadth_Added_Sounds value
	 */
	public void setBreadthAddedSounds (java.lang.String breadthAddedSounds) {
		this.breadthAddedSounds = breadthAddedSounds;
	}



	/**
	 * Return the value associated with the column: S1
	 */
	public java.lang.String getS1 () {
		return s1;
	}

	/**
	 * Set the value related to the column: S1
	 * @param s1 the S1 value
	 */
	public void setS1 (java.lang.String s1) {
		this.s1 = s1;
	}



	/**
	 * Return the value associated with the column: S2
	 */
	public java.lang.String getS2 () {
		return s2;
	}

	/**
	 * Set the value related to the column: S2
	 * @param s2 the S2 value
	 */
	public void setS2 (java.lang.String s2) {
		this.s2 = s2;
	}



	/**
	 * Return the value associated with the column: Height_Of_Uterus
	 */
	public java.lang.String getHeightOfUterus () {
		return heightOfUterus;
	}

	/**
	 * Set the value related to the column: Height_Of_Uterus
	 * @param heightOfUterus the Height_Of_Uterus value
	 */
	public void setHeightOfUterus (java.lang.String heightOfUterus) {
		this.heightOfUterus = heightOfUterus;
	}



	/**
	 * Return the value associated with the column: Lower_Pole
	 */
	public java.lang.String getLowerPole () {
		return lowerPole;
	}

	/**
	 * Set the value related to the column: Lower_Pole
	 * @param lowerPole the Lower_Pole value
	 */
	public void setLowerPole (java.lang.String lowerPole) {
		this.lowerPole = lowerPole;
	}



	/**
	 * Return the value associated with the column: Lower_Grip
	 */
	public java.lang.String getLowerGrip () {
		return lowerGrip;
	}

	/**
	 * Set the value related to the column: Lower_Grip
	 * @param lowerGrip the Lower_Grip value
	 */
	public void setLowerGrip (java.lang.String lowerGrip) {
		this.lowerGrip = lowerGrip;
	}



	/**
	 * Return the value associated with the column: Heart_Rate_Regular
	 */
	public java.lang.Integer getHeartRateRegular () {
		return heartRateRegular;
	}

	/**
	 * Set the value related to the column: Heart_Rate_Regular
	 * @param heartRateRegular the Heart_Rate_Regular value
	 */
	public void setHeartRateRegular (java.lang.Integer heartRateRegular) {
		this.heartRateRegular = heartRateRegular;
	}



	/**
	 * Return the value associated with the column: Heart_Rate_Absent
	 */
	public java.lang.Integer getHeartRateAbsent () {
		return heartRateAbsent;
	}

	/**
	 * Set the value related to the column: Heart_Rate_Absent
	 * @param heartRateAbsent the Heart_Rate_Absent value
	 */
	public void setHeartRateAbsent (java.lang.Integer heartRateAbsent) {
		this.heartRateAbsent = heartRateAbsent;
	}



	/**
	 * Return the value associated with the column: Dilatation_Of_Cervix
	 */
	public java.lang.Integer getDilatationOfCervix () {
		return dilatationOfCervix;
	}

	/**
	 * Set the value related to the column: Dilatation_Of_Cervix
	 * @param dilatationOfCervix the Dilatation_Of_Cervix value
	 */
	public void setDilatationOfCervix (java.lang.Integer dilatationOfCervix) {
		this.dilatationOfCervix = dilatationOfCervix;
	}



	/**
	 * Return the value associated with the column: Effacement_Of_Cervix
	 */
	public java.lang.String getEffacementOfCervix () {
		return effacementOfCervix;
	}

	/**
	 * Set the value related to the column: Effacement_Of_Cervix
	 * @param effacementOfCervix the Effacement_Of_Cervix value
	 */
	public void setEffacementOfCervix (java.lang.String effacementOfCervix) {
		this.effacementOfCervix = effacementOfCervix;
	}



	/**
	 * Return the value associated with the column: Membrane
	 */
	public java.lang.String getMembrane () {
		return membrane;
	}

	/**
	 * Set the value related to the column: Membrane
	 * @param membrane the Membrane value
	 */
	public void setMembrane (java.lang.String membrane) {
		this.membrane = membrane;
	}



	/**
	 * Return the value associated with the column: Liquor
	 */
	public java.lang.String getLiquor () {
		return liquor;
	}

	/**
	 * Set the value related to the column: Liquor
	 * @param liquor the Liquor value
	 */
	public void setLiquor (java.lang.String liquor) {
		this.liquor = liquor;
	}



	/**
	 * Return the value associated with the column: Consistency_Of_Cervix
	 */
	public java.lang.String getConsistencyOfCervix () {
		return consistencyOfCervix;
	}

	/**
	 * Set the value related to the column: Consistency_Of_Cervix
	 * @param consistencyOfCervix the Consistency_Of_Cervix value
	 */
	public void setConsistencyOfCervix (java.lang.String consistencyOfCervix) {
		this.consistencyOfCervix = consistencyOfCervix;
	}



	/**
	 * Return the value associated with the column: Position_Of_Cervix
	 */
	public java.lang.String getPositionOfCervix () {
		return positionOfCervix;
	}

	/**
	 * Set the value related to the column: Position_Of_Cervix
	 * @param positionOfCervix the Position_Of_Cervix value
	 */
	public void setPositionOfCervix (java.lang.String positionOfCervix) {
		this.positionOfCervix = positionOfCervix;
	}



	/**
	 * Return the value associated with the column: Length_Of_Cervix
	 */
	public java.lang.Integer getLengthOfCervix () {
		return lengthOfCervix;
	}

	/**
	 * Set the value related to the column: Length_Of_Cervix
	 * @param lengthOfCervix the Length_Of_Cervix value
	 */
	public void setLengthOfCervix (java.lang.Integer lengthOfCervix) {
		this.lengthOfCervix = lengthOfCervix;
	}



	/**
	 * Return the value associated with the column: Station_of_Presenting_Part
	 */
	public java.lang.Integer getStationOfPresentingPart () {
		return stationOfPresentingPart;
	}

	/**
	 * Set the value related to the column: Station_of_Presenting_Part
	 * @param stationOfPresentingPart the Station_of_Presenting_Part value
	 */
	public void setStationOfPresentingPart (java.lang.Integer stationOfPresentingPart) {
		this.stationOfPresentingPart = stationOfPresentingPart;
	}



	/**
	 * Return the value associated with the column: head
	 */
	public java.lang.String getHead () {
		return head;
	}

	/**
	 * Set the value related to the column: head
	 * @param head the head value
	 */
	public void setHead (java.lang.String head) {
		this.head = head;
	}



	/**
	 * Return the value associated with the column: pelvis
	 */
	public java.lang.String getPelvis () {
		return pelvis;
	}

	/**
	 * Set the value related to the column: pelvis
	 * @param pelvis the pelvis value
	 */
	public void setPelvis (java.lang.String pelvis) {
		this.pelvis = pelvis;
	}



	/**
	 * Return the value associated with the column: flow
	 */
	public java.lang.String getFlow () {
		return flow;
	}

	/**
	 * Set the value related to the column: flow
	 * @param flow the flow value
	 */
	public void setFlow (java.lang.String flow) {
		this.flow = flow;
	}



	/**
	 * Return the value associated with the column: range_value
	 */
	public java.lang.String getRangeValue () {
		return rangeValue;
	}

	/**
	 * Set the value related to the column: range_value
	 * @param rangeValue the range_value value
	 */
	public void setRangeValue (java.lang.String rangeValue) {
		this.rangeValue = rangeValue;
	}



	/**
	 * Return the value associated with the column: obstretic_score_g
	 */
	public java.lang.Integer getObstreticScoreG () {
		return obstreticScoreG;
	}

	/**
	 * Set the value related to the column: obstretic_score_g
	 * @param obstreticScoreG the obstretic_score_g value
	 */
	public void setObstreticScoreG (java.lang.Integer obstreticScoreG) {
		this.obstreticScoreG = obstreticScoreG;
	}



	/**
	 * Return the value associated with the column: obstretic_score_p
	 */
	public java.lang.Integer getObstreticScoreP () {
		return obstreticScoreP;
	}

	/**
	 * Set the value related to the column: obstretic_score_p
	 * @param obstreticScoreP the obstretic_score_p value
	 */
	public void setObstreticScoreP (java.lang.Integer obstreticScoreP) {
		this.obstreticScoreP = obstreticScoreP;
	}



	/**
	 * Return the value associated with the column: obstretic_score_a
	 */
	public java.lang.Integer getObstreticScoreA () {
		return obstreticScoreA;
	}

	/**
	 * Set the value related to the column: obstretic_score_a
	 * @param obstreticScoreA the obstretic_score_a value
	 */
	public void setObstreticScoreA (java.lang.Integer obstreticScoreA) {
		this.obstreticScoreA = obstreticScoreA;
	}



	/**
	 * Return the value associated with the column: obstretic_score_l
	 */
	public java.lang.Integer getObstreticScoreL () {
		return obstreticScoreL;
	}

	/**
	 * Set the value related to the column: obstretic_score_l
	 * @param obstreticScoreL the obstretic_score_l value
	 */
	public void setObstreticScoreL (java.lang.Integer obstreticScoreL) {
		this.obstreticScoreL = obstreticScoreL;
	}



	/**
	 * Return the value associated with the column: murmurs
	 */
	public java.lang.String getMurmurs () {
		return murmurs;
	}

	/**
	 * Set the value related to the column: murmurs
	 * @param murmurs the murmurs value
	 */
	public void setMurmurs (java.lang.String murmurs) {
		this.murmurs = murmurs;
	}



	/**
	 * Return the value associated with the column: personal_history
	 */
	public java.lang.String getPersonalHistory () {
		return personalHistory;
	}

	/**
	 * Set the value related to the column: personal_history
	 * @param personalHistory the personal_history value
	 */
	public void setPersonalHistory (java.lang.String personalHistory) {
		this.personalHistory = personalHistory;
	}



	/**
	 * Return the value associated with the column: clinical_hsirory
	 */
	public java.lang.String getClinicalHsirory () {
		return clinicalHsirory;
	}

	/**
	 * Set the value related to the column: clinical_hsirory
	 * @param clinicalHsirory the clinical_hsirory value
	 */
	public void setClinicalHsirory (java.lang.String clinicalHsirory) {
		this.clinicalHsirory = clinicalHsirory;
	}



	/**
	 * Return the value associated with the column: surgical_history
	 */
	public java.lang.String getSurgicalHistory () {
		return surgicalHistory;
	}

	/**
	 * Set the value related to the column: surgical_history
	 * @param surgicalHistory the surgical_history value
	 */
	public void setSurgicalHistory (java.lang.String surgicalHistory) {
		this.surgicalHistory = surgicalHistory;
	}



	/**
	 * Return the value associated with the column: range_interval
	 */
	public java.lang.String getRangeInterval () {
		return rangeInterval;
	}

	/**
	 * Set the value related to the column: range_interval
	 * @param rangeInterval the range_interval value
	 */
	public void setRangeInterval (java.lang.String rangeInterval) {
		this.rangeInterval = rangeInterval;
	}



	/**
	 * Return the value associated with the column: cycle_text
	 */
	public java.lang.String getCycleText () {
		return cycleText;
	}

	/**
	 * Set the value related to the column: cycle_text
	 * @param cycleText the cycle_text value
	 */
	public void setCycleText (java.lang.String cycleText) {
		this.cycleText = cycleText;
	}



	/**
	 * Return the value associated with the column: dysmenorrhea
	 */
	public java.lang.String getDysmenorrhea () {
		return dysmenorrhea;
	}

	/**
	 * Set the value related to the column: dysmenorrhea
	 * @param dysmenorrhea the dysmenorrhea value
	 */
	public void setDysmenorrhea (java.lang.String dysmenorrhea) {
		this.dysmenorrhea = dysmenorrhea;
	}



	/**
	 * Return the value associated with the column: last_menstrual
	 */
	public java.util.Date getLastMenstrual () {
		return lastMenstrual;
	}

	/**
	 * Set the value related to the column: last_menstrual
	 * @param lastMenstrual the last_menstrual value
	 */
	public void setLastMenstrual (java.util.Date lastMenstrual) {
		this.lastMenstrual = lastMenstrual;
	}



	/**
	 * Return the value associated with the column: inspection_abdomen
	 */
	public java.lang.String getInspectionAbdomen () {
		return inspectionAbdomen;
	}

	/**
	 * Set the value related to the column: inspection_abdomen
	 * @param inspectionAbdomen the inspection_abdomen value
	 */
	public void setInspectionAbdomen (java.lang.String inspectionAbdomen) {
		this.inspectionAbdomen = inspectionAbdomen;
	}



	/**
	 * Return the value associated with the column: inspection_umbilicus
	 */
	public java.lang.String getInspectionUmbilicus () {
		return inspectionUmbilicus;
	}

	/**
	 * Set the value related to the column: inspection_umbilicus
	 * @param inspectionUmbilicus the inspection_umbilicus value
	 */
	public void setInspectionUmbilicus (java.lang.String inspectionUmbilicus) {
		this.inspectionUmbilicus = inspectionUmbilicus;
	}



	/**
	 * Return the value associated with the column: inspection_hernia
	 */
	public java.lang.String getInspectionHernia () {
		return inspectionHernia;
	}

	/**
	 * Set the value related to the column: inspection_hernia
	 * @param inspectionHernia the inspection_hernia value
	 */
	public void setInspectionHernia (java.lang.String inspectionHernia) {
		this.inspectionHernia = inspectionHernia;
	}



	/**
	 * Return the value associated with the column: inspection_scar
	 */
	public java.lang.String getInspectionScar () {
		return inspectionScar;
	}

	/**
	 * Set the value related to the column: inspection_scar
	 * @param inspectionScar the inspection_scar value
	 */
	public void setInspectionScar (java.lang.String inspectionScar) {
		this.inspectionScar = inspectionScar;
	}



	/**
	 * Return the value associated with the column: mass_palpable
	 */
	public java.lang.String getMassPalpable () {
		return massPalpable;
	}

	/**
	 * Set the value related to the column: mass_palpable
	 * @param massPalpable the mass_palpable value
	 */
	public void setMassPalpable (java.lang.String massPalpable) {
		this.massPalpable = massPalpable;
	}



	/**
	 * Return the value associated with the column: mass_size
	 */
	public java.lang.String getMassSize () {
		return massSize;
	}

	/**
	 * Set the value related to the column: mass_size
	 * @param massSize the mass_size value
	 */
	public void setMassSize (java.lang.String massSize) {
		this.massSize = massSize;
	}



	/**
	 * Return the value associated with the column: mass_shape
	 */
	public java.lang.String getMassShape () {
		return massShape;
	}

	/**
	 * Set the value related to the column: mass_shape
	 * @param massShape the mass_shape value
	 */
	public void setMassShape (java.lang.String massShape) {
		this.massShape = massShape;
	}



	/**
	 * Return the value associated with the column: mass_position
	 */
	public java.lang.String getMassPosition () {
		return massPosition;
	}

	/**
	 * Set the value related to the column: mass_position
	 * @param massPosition the mass_position value
	 */
	public void setMassPosition (java.lang.String massPosition) {
		this.massPosition = massPosition;
	}



	/**
	 * Return the value associated with the column: mass_consistency
	 */
	public java.lang.String getMassConsistency () {
		return massConsistency;
	}

	/**
	 * Set the value related to the column: mass_consistency
	 * @param massConsistency the mass_consistency value
	 */
	public void setMassConsistency (java.lang.String massConsistency) {
		this.massConsistency = massConsistency;
	}



	/**
	 * Return the value associated with the column: mass_temp
	 */
	public java.lang.String getMassTemp () {
		return massTemp;
	}

	/**
	 * Set the value related to the column: mass_temp
	 * @param massTemp the mass_temp value
	 */
	public void setMassTemp (java.lang.String massTemp) {
		this.massTemp = massTemp;
	}



	/**
	 * Return the value associated with the column: asicitis
	 */
	public java.lang.String getAsicitis () {
		return asicitis;
	}

	/**
	 * Set the value related to the column: asicitis
	 * @param asicitis the asicitis value
	 */
	public void setAsicitis (java.lang.String asicitis) {
		this.asicitis = asicitis;
	}



	/**
	 * Return the value associated with the column: external_genitalia
	 */
	public java.lang.String getExternalGenitalia () {
		return externalGenitalia;
	}

	/**
	 * Set the value related to the column: external_genitalia
	 * @param externalGenitalia the external_genitalia value
	 */
	public void setExternalGenitalia (java.lang.String externalGenitalia) {
		this.externalGenitalia = externalGenitalia;
	}



	/**
	 * Return the value associated with the column: external_genitalia_other
	 */
	public java.lang.String getExternalGenitaliaOther () {
		return externalGenitaliaOther;
	}

	/**
	 * Set the value related to the column: external_genitalia_other
	 * @param externalGenitaliaOther the external_genitalia_other value
	 */
	public void setExternalGenitaliaOther (java.lang.String externalGenitaliaOther) {
		this.externalGenitaliaOther = externalGenitaliaOther;
	}



	/**
	 * Return the value associated with the column: speculum_vagina
	 */
	public java.lang.String getSpeculumVagina () {
		return speculumVagina;
	}

	/**
	 * Set the value related to the column: speculum_vagina
	 * @param speculumVagina the speculum_vagina value
	 */
	public void setSpeculumVagina (java.lang.String speculumVagina) {
		this.speculumVagina = speculumVagina;
	}



	/**
	 * Return the value associated with the column: speculum_discharge
	 */
	public java.lang.String getSpeculumDischarge () {
		return speculumDischarge;
	}

	/**
	 * Set the value related to the column: speculum_discharge
	 * @param speculumDischarge the speculum_discharge value
	 */
	public void setSpeculumDischarge (java.lang.String speculumDischarge) {
		this.speculumDischarge = speculumDischarge;
	}



	/**
	 * Return the value associated with the column: speculum_cervix
	 */
	public java.lang.String getSpeculumCervix () {
		return speculumCervix;
	}

	/**
	 * Set the value related to the column: speculum_cervix
	 * @param speculumCervix the speculum_cervix value
	 */
	public void setSpeculumCervix (java.lang.String speculumCervix) {
		this.speculumCervix = speculumCervix;
	}



	/**
	 * Return the value associated with the column: speculum_decent
	 */
	public java.lang.String getSpeculumDecent () {
		return speculumDecent;
	}

	/**
	 * Set the value related to the column: speculum_decent
	 * @param speculumDecent the speculum_decent value
	 */
	public void setSpeculumDecent (java.lang.String speculumDecent) {
		this.speculumDecent = speculumDecent;
	}



	/**
	 * Return the value associated with the column: uterus_size
	 */
	public java.lang.String getUterusSize () {
		return uterusSize;
	}

	/**
	 * Set the value related to the column: uterus_size
	 * @param uterusSize the uterus_size value
	 */
	public void setUterusSize (java.lang.String uterusSize) {
		this.uterusSize = uterusSize;
	}



	/**
	 * Return the value associated with the column: uterus_forness
	 */
	public java.lang.String getUterusForness () {
		return uterusForness;
	}

	/**
	 * Set the value related to the column: uterus_forness
	 * @param uterusForness the uterus_forness value
	 */
	public void setUterusForness (java.lang.String uterusForness) {
		this.uterusForness = uterusForness;
	}



	/**
	 * Return the value associated with the column: uterus_cervical_movement
	 */
	public java.lang.String getUterusCervicalMovement () {
		return uterusCervicalMovement;
	}

	/**
	 * Set the value related to the column: uterus_cervical_movement
	 * @param uterusCervicalMovement the uterus_cervical_movement value
	 */
	public void setUterusCervicalMovement (java.lang.String uterusCervicalMovement) {
		this.uterusCervicalMovement = uterusCervicalMovement;
	}



	/**
	 * Return the value associated with the column: gyn_obstetric_history
	 */
	public java.lang.String getGynObstetricHistory () {
		return gynObstetricHistory;
	}

	/**
	 * Set the value related to the column: gyn_obstetric_history
	 * @param gynObstetricHistory the gyn_obstetric_history value
	 */
	public void setGynObstetricHistory (java.lang.String gynObstetricHistory) {
		this.gynObstetricHistory = gynObstetricHistory;
	}



	/**
	 * Return the value associated with the column: gyn_palpation
	 */
	public java.lang.String getGynPalpation () {
		return gynPalpation;
	}

	/**
	 * Set the value related to the column: gyn_palpation
	 * @param gynPalpation the gyn_palpation value
	 */
	public void setGynPalpation (java.lang.String gynPalpation) {
		this.gynPalpation = gynPalpation;
	}



	/**
	 * Return the value associated with the column: gyn_abdomen_inspection
	 */
	public java.lang.String getGynAbdomenInspection () {
		return gynAbdomenInspection;
	}

	/**
	 * Set the value related to the column: gyn_abdomen_inspection
	 * @param gynAbdomenInspection the gyn_abdomen_inspection value
	 */
	public void setGynAbdomenInspection (java.lang.String gynAbdomenInspection) {
		this.gynAbdomenInspection = gynAbdomenInspection;
	}



	/**
	 * Return the value associated with the column: gyn_local_examination
	 */
	public java.lang.String getGynLocalExamination () {
		return gynLocalExamination;
	}

	/**
	 * Set the value related to the column: gyn_local_examination
	 * @param gynLocalExamination the gyn_local_examination value
	 */
	public void setGynLocalExamination (java.lang.String gynLocalExamination) {
		this.gynLocalExamination = gynLocalExamination;
	}



	/**
	 * Return the value associated with the column: gyn_internal_examination
	 */
	public java.lang.String getGynInternalExamination () {
		return gynInternalExamination;
	}

	/**
	 * Set the value related to the column: gyn_internal_examination
	 * @param gynInternalExamination the gyn_internal_examination value
	 */
	public void setGynInternalExamination (java.lang.String gynInternalExamination) {
		this.gynInternalExamination = gynInternalExamination;
	}



	/**
	 * Return the value associated with the column: gyn_per_speculum
	 */
	public java.lang.String getGynPerSpeculum () {
		return gynPerSpeculum;
	}

	/**
	 * Set the value related to the column: gyn_per_speculum
	 * @param gynPerSpeculum the gyn_per_speculum value
	 */
	public void setGynPerSpeculum (java.lang.String gynPerSpeculum) {
		this.gynPerSpeculum = gynPerSpeculum;
	}



	/**
	 * Return the value associated with the column: gyn_bimanual_examination
	 */
	public java.lang.String getGynBimanualExamination () {
		return gynBimanualExamination;
	}

	/**
	 * Set the value related to the column: gyn_bimanual_examination
	 * @param gynBimanualExamination the gyn_bimanual_examination value
	 */
	public void setGynBimanualExamination (java.lang.String gynBimanualExamination) {
		this.gynBimanualExamination = gynBimanualExamination;
	}



	/**
	 * Return the value associated with the column: menstrual_pattern1
	 */
	public java.lang.String getMenstrualPattern1 () {
		return menstrualPattern1;
	}

	/**
	 * Set the value related to the column: menstrual_pattern1
	 * @param menstrualPattern1 the menstrual_pattern1 value
	 */
	public void setMenstrualPattern1 (java.lang.String menstrualPattern1) {
		this.menstrualPattern1 = menstrualPattern1;
	}



	/**
	 * Return the value associated with the column: menstrual_pattern2
	 */
	public java.lang.String getMenstrualPattern2 () {
		return menstrualPattern2;
	}

	/**
	 * Set the value related to the column: menstrual_pattern2
	 * @param menstrualPattern2 the menstrual_pattern2 value
	 */
	public void setMenstrualPattern2 (java.lang.String menstrualPattern2) {
		this.menstrualPattern2 = menstrualPattern2;
	}



	/**
	 * Return the value associated with the column: gyn_age_of_menarche
	 */
	public java.lang.Integer getGynAgeOfMenarche () {
		return gynAgeOfMenarche;
	}

	/**
	 * Set the value related to the column: gyn_age_of_menarche
	 * @param gynAgeOfMenarche the gyn_age_of_menarche value
	 */
	public void setGynAgeOfMenarche (java.lang.Integer gynAgeOfMenarche) {
		this.gynAgeOfMenarche = gynAgeOfMenarche;
	}



	/**
	 * Return the value associated with the column: gyn_flow
	 */
	public java.lang.String getGynFlow () {
		return gynFlow;
	}

	/**
	 * Set the value related to the column: gyn_flow
	 * @param gynFlow the gyn_flow value
	 */
	public void setGynFlow (java.lang.String gynFlow) {
		this.gynFlow = gynFlow;
	}



	/**
	 * Return the value associated with the column: gc
	 */
	public java.lang.String getGc () {
		return gc;
	}

	/**
	 * Set the value related to the column: gc
	 * @param gc the gc value
	 */
	public void setGc (java.lang.String gc) {
		this.gc = gc;
	}



	/**
	 * Return the value associated with the column: pa
	 */
	public java.lang.String getPa () {
		return pa;
	}

	/**
	 * Set the value related to the column: pa
	 * @param pa the pa value
	 */
	public void setPa (java.lang.String pa) {
		this.pa = pa;
	}



	/**
	 * Return the value associated with the column: pe
	 */
	public java.lang.String getPe () {
		return pe;
	}

	/**
	 * Set the value related to the column: pe
	 * @param pe the pe value
	 */
	public void setPe (java.lang.String pe) {
		this.pe = pe;
	}



	/**
	 * Return the value associated with the column: fhr
	 */
	public java.lang.String getFhr () {
		return fhr;
	}

	/**
	 * Set the value related to the column: fhr
	 * @param fhr the fhr value
	 */
	public void setFhr (java.lang.String fhr) {
		this.fhr = fhr;
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
	 * Return the value associated with the column: pv
	 */
	public java.lang.String getPv () {
		return pv;
	}

	/**
	 * Set the value related to the column: pv
	 * @param pv the pv value
	 */
	public void setPv (java.lang.String pv) {
		this.pv = pv;
	}



	/**
	 * Return the value associated with the column: tt
	 */
	public java.lang.Integer getTt () {
		return tt;
	}

	/**
	 * Set the value related to the column: tt
	 * @param tt the tt value
	 */
	public void setTt (java.lang.Integer tt) {
		this.tt = tt;
	}



	/**
	 * Return the value associated with the column: menstrual_pause
	 */
	public java.lang.String getMenstrualPause () {
		return menstrualPause;
	}

	/**
	 * Set the value related to the column: menstrual_pause
	 * @param menstrualPause the menstrual_pause value
	 */
	public void setMenstrualPause (java.lang.String menstrualPause) {
		this.menstrualPause = menstrualPause;
	}



	/**
	 * Return the value associated with the column: obg_remarks
	 */
	public java.lang.String getObgRemarks () {
		return obgRemarks;
	}

	/**
	 * Set the value related to the column: obg_remarks
	 * @param obgRemarks the obg_remarks value
	 */
	public void setObgRemarks (java.lang.String obgRemarks) {
		this.obgRemarks = obgRemarks;
	}



	/**
	 * Return the value associated with the column: sterilisation
	 */
	public java.lang.String getSterilisation () {
		return sterilisation;
	}

	/**
	 * Set the value related to the column: sterilisation
	 * @param sterilisation the sterilisation value
	 */
	public void setSterilisation (java.lang.String sterilisation) {
		this.sterilisation = sterilisation;
	}



	/**
	 * Return the value associated with the column: pap_smear
	 */
	public java.lang.String getPapSmear () {
		return papSmear;
	}

	/**
	 * Set the value related to the column: pap_smear
	 * @param papSmear the pap_smear value
	 */
	public void setPapSmear (java.lang.String papSmear) {
		this.papSmear = papSmear;
	}



	/**
	 * Return the value associated with the column: palpation
	 */
	public java.lang.String getPalpation () {
		return palpation;
	}

	/**
	 * Set the value related to the column: palpation
	 * @param palpation the palpation value
	 */
	public void setPalpation (java.lang.String palpation) {
		this.palpation = palpation;
	}



	/**
	 * Return the value associated with the column: opd_patient_details_id
	 */
	public jkt.hms.masters.business.OpdPatientDetails getOpdPatientDetails () {
		return opdPatientDetails;
	}

	/**
	 * Set the value related to the column: opd_patient_details_id
	 * @param opdPatientDetails the opd_patient_details_id value
	 */
	public void setOpdPatientDetails (jkt.hms.masters.business.OpdPatientDetails opdPatientDetails) {
		this.opdPatientDetails = opdPatientDetails;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.ObgDetails)) return false;
		else {
			jkt.hms.masters.business.ObgDetails obgDetails = (jkt.hms.masters.business.ObgDetails) obj;
			if (null == this.getId() || null == obgDetails.getId()) return false;
			else return (this.getId().equals(obgDetails.getId()));
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
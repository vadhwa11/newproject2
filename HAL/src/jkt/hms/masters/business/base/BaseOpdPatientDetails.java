package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_patient_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_patient_details"
 */

public abstract class BaseOpdPatientDetails  implements Serializable {

	public static String REF = "OpdPatientDetails";
	public static String PROP_ADMISSION_WARD = "AdmissionWard";
	public static String PROP_PULSES = "Pulses";
	public static String PROP_DOMESTIC = "Domestic";
	public static String PROP_EXPECTED_WEIGHT = "ExpectedWeight";
	public static String PROP_AFMS_DESC = "AfmsDesc";
	public static String PROP_NEAR_L_SPH = "NearLSph";
	public static String PROP_REFERRAL_NOTES = "ReferralNotes";
	public static String PROP_TYPE_OF_DELIVERY = "TypeOfDelivery";
	public static String PROP_NO_OF_DEFECTIVE_TEETH = "NoOfDefectiveTeeth";
	public static String PROP_EYE_IPD = "EyeIpd";
	public static String PROP_A_CHILD_YEAR = "AChildYear";
	public static String PROP_OPERATION_PERIOD_TODAY = "OperationPeriodToday";
	public static String PROP_ISSUE_TO = "IssueTo";
	public static String PROP_B_CHILD_REMARK = "BChildRemark";
	public static String PROP_D_REMARKS2 = "DRemarks2";
	public static String PROP_D_REMARKS1 = "DRemarks1";
	public static String PROP_TIME_OF_BIRTH = "TimeOfBirth";
	public static String PROP_WHR = "Whr";
	public static String PROP_MH_DEPARTMENT = "MhDepartment";
	public static String PROP_DISPOSED_OFF = "DisposedOff";
	public static String PROP_MH_RUN = "MhRun";
	public static String PROP_PULSE = "Pulse";
	public static String PROP_IMPANNELED_HOSPITAL = "ImpanneledHospital";
	public static String PROP_CHILD_HEAD_CIRCUMFERENCE = "ChildHeadCircumference";
	public static String PROP_LENS_TYPE = "LensType";
	public static String PROP_REFERRED_STATUS = "ReferredStatus";
	public static String PROP_C_CHILD_FROM_PERIOD = "CChildFromPeriod";
	public static String PROP_L = "L";
	public static String PROP_ADMISSION_NOTES = "AdmissionNotes";
	public static String PROP_DIST_L_SPH = "DistLSph";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_D_SINCE2 = "DSince2";
	public static String PROP_DENTAL_REFER_TO_M_H = "DentalReferToMH";
	public static String PROP_D_SINCE1 = "DSince1";
	public static String PROP_EYE_USE = "EyeUse";
	public static String PROP_HEART_RATE = "HeartRate";
	public static String PROP_S = "S";
	public static String PROP_NEAR_R_CYL = "NearRCyl";
	public static String PROP_DURATION_OF_CYCLE = "DurationOfCycle";
	public static String PROP_DENTURES_FITTED_REPAIRS = "DenturesFittedRepairs";
	public static String PROP_BST = "Bst";
	public static String PROP_A_CHILD_FROM_PERIOD = "AChildFromPeriod";
	public static String PROP_OTHER_FINDING = "OtherFinding";
	public static String PROP_SYSTEMIC_DISORDER = "SystemicDisorder";
	public static String PROP_NEAR_R_SPH = "NearRSph";
	public static String PROP_SPLEEN = "Spleen";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_DIST_R_CYL = "DistRCyl";
	public static String PROP_SPINE = "Spine";
	public static String PROP_REFER_TILL_DATE = "ReferTillDate";
	public static String PROP_CHILD_HEIGHT = "ChildHeight";
	public static String PROP_REFERRED_DOCTOR_INT = "ReferredDoctorInt";
	public static String PROP_HEAD_CIRUM = "HeadCirum";
	public static String PROP_UL1 = "UL1";
	public static String PROP_UL2 = "UL2";
	public static String PROP_CASE_NOTES = "CaseNotes";
	public static String PROP_TEETH_CONSERVES_WITHOUT_RT = "TeethConservesWithoutRt";
	public static String PROP_UL5 = "UL5";
	public static String PROP_UL6 = "UL6";
	public static String PROP_UL3 = "UL3";
	public static String PROP_UL4 = "UL4";
	public static String PROP_FIRST_TRIMESTER = "FirstTrimester";
	public static String PROP_TREATABLE_TOOTH = "TreatableTooth";
	public static String PROP_LL5 = "LL5";
	public static String PROP_LL4 = "LL4";
	public static String PROP_SPECIAL_ADVISE_FOLLOWUP = "SpecialAdviseFollowup";
	public static String PROP_LL7 = "LL7";
	public static String PROP_LL6 = "LL6";
	public static String PROP_LL1 = "LL1";
	public static String PROP_D_MAIN_COMPLAINT = "DMainComplaint";
	public static String PROP_LL3 = "LL3";
	public static String PROP_LL2 = "LL2";
	public static String PROP_CHILD_AGE = "ChildAge";
	public static String PROP_UL7 = "UL7";
	public static String PROP_LL8 = "LL8";
	public static String PROP_UL8 = "UL8";
	public static String PROP_POLLOR = "Pollor";
	public static String PROP_ENT_REMARK = "EntRemark";
	public static String PROP_NO_OF_CHILD = "NoOfChild";
	public static String PROP_GENERAL = "General";
	public static String PROP_A_CHILD_NO_OF_PRAG = "AChildNoOfPrag";
	public static String PROP_PR = "Pr";
	public static String PROP_PP = "Pp";
	public static String PROP_EDD_DATE = "EddDate";
	public static String PROP_PARA = "PARA";
	public static String PROP_PA = "Pa";
	public static String PROP_REFERRAL_PRIORITY = "ReferralPriority";
	public static String PROP_BREAST_EXAM = "BreastExam";
	public static String PROP_OEDEMA = "oedema";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_VISIT = "Visit";
	public static String PROP_B_CHILD_FROM_PERIOD = "BChildFromPeriod";
	public static String PROP_ANESTHESIA = "Anesthesia";
	public static String PROP_A_CHILD_REMARK = "AChildRemark";
	public static String PROP_A_CHILD_WEIGHT = "AChildWeight";
	public static String PROP_DIST_R_AXIS = "DistRAxis";
	public static String PROP_GENDER = "Gender";
	public static String PROP_DIST_L_CYL = "DistLCyl";
	public static String PROP_C_CHILD_REMARK = "CChildRemark";
	public static String PROP_REFERRAL_VISIT = "ReferralVisit";
	public static String PROP_M_NO_OF_DAYS = "MNoOfDays";
	public static String PROP_SYSTEM_DIAGNOSIS = "SystemDiagnosis";
	public static String PROP_EXPECTED_BMI = "ExpectedBmi";
	public static String PROP_B_CHILD_TO_PERIOD = "BChildToPeriod";
	public static String PROP_AGE = "Age";
	public static String PROP_DAYS_PHY = "DaysPhy";
	public static String PROP_C_CHILD_NO_OF_PRAG = "CChildNoOfPrag";
	public static String PROP_ADMISSION_DATE = "AdmissionDate";
	public static String PROP_CHILD_RR = "ChildRr";
	public static String PROP_DIST_R_SPH = "DistRSph";
	public static String PROP_ADVICE_ON_DISCHARGE = "AdviceOnDischarge";
	public static String PROP_A_CHILD_ANTENATAL = "AChildAntenatal";
	public static String PROP_SP = "Sp";
	public static String PROP_OPD_TIME = "OpdTime";
	public static String PROP_CHILD_CHEST = "ChildChest";
	public static String PROP_RR = "Rr";
	public static String PROP_C_CHILD_ANTENATAL = "CChildAntenatal";
	public static String PROP_NERVOUS_SYSTEM = "NervousSystem";
	public static String PROP_OBSCURE = "Obscure";
	public static String PROP_AB = "Ab";
	public static String PROP_B_CHILD_WEIGHT = "BChildWeight";
	public static String PROP_DAYS = "Days";
	public static String PROP_B_CHILD_LABOUR_AND_DELIVERY = "BChildLabourAndDelivery";
	public static String PROP_FHS = "Fhs";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_EXPECTED_HEIGHT = "ExpectedHeight";
	public static String PROP_CVS = "Cvs";
	public static String PROP_SUGAR = "sugar";
	public static String PROP_NAME_OF_CONTRAC = "NameOfContrac";
	public static String PROP_OTHERS_VISION = "OthersVision";
	public static String PROP_EMPANEL_STATUS = "EmpanelStatus";
	public static String PROP_PHY_STATUS = "PhyStatus";
	public static String PROP_STATUS = "Status";
	public static String PROP_BP = "Bp";
	public static String PROP_TOTAL_MISSING_TEETH = "TotalMissingTeeth";
	public static String PROP_M_REGULARITY = "MRegularity";
	public static String PROP_NEAR_R_AXIS = "NearRAxis";
	public static String PROP_CONDITION_OF_GUMS = "ConditionOfGums";
	public static String PROP_B_CHILD_GENDER = "BChildGender";
	public static String PROP_THERAPY_TYPE = "TherapyType";
	public static String PROP_DISPOSAL_DAYS = "DisposalDays";
	public static String PROP_INITIAL_DIAGNOSIS = "InitialDiagnosis";
	public static String PROP_D_ASSOCIATED_COMPLAINT = "DAssociatedComplaint";
	public static String PROP_NO_OF_TEETH = "NoOfTeeth";
	public static String PROP_PAST_DIAGNOSIS = "pastDiagnosis";
	public static String PROP_OPD_DATE = "OpdDate";
	public static String PROP_DENTURES_FITTED_NEW = "DenturesFittedNew";
	public static String PROP_C_CHILD_WEIGHT = "CChildWeight";
	public static String PROP_DATE_ANC = "DateAnc";
	public static String PROP_BMI = "bmi";
	public static String PROP_ADMISSION_ADVISED = "AdmissionAdvised";
	public static String PROP_UNSAVEABLE_TEETH_REMARK = "UnsaveableTeethRemark";
	public static String PROP_M_FLOW = "MFlow";
	public static String PROP_DR_NAME = "DrName";
	public static String PROP_CONSULTATION_TIME = "ConsultationTime";
	public static String PROP_M_PAIN = "MPain";
	public static String PROP_DIST_L_AXIS = "DistLAxis";
	public static String PROP_REFERRED_TYPE = "ReferredType";
	public static String PROP_UR1 = "UR1";
	public static String PROP_UR2 = "UR2";
	public static String PROP_GESTATIONAL_AGE = "GestationalAge";
	public static String PROP_UR3 = "UR3";
	public static String PROP_UR4 = "UR4";
	public static String PROP_VWEIGHT = "Vweight";
	public static String PROP_UR5 = "UR5";
	public static String PROP_D_TREATMENT_REMARK = "DTreatmentRemark";
	public static String PROP_UR6 = "UR6";
	public static String PROP_UR7 = "UR7";
	public static String PROP_PREGNANCY = "Pregnancy";
	public static String PROP_UR8 = "UR8";
	public static String PROP_REFLEXES = "Reflexes";
	public static String PROP_MH = "Mh";
	public static String PROP_EYE_REMARK = "EyeRemark";
	public static String PROP_SECOND_TRIMESTER = "SecondTrimester";
	public static String PROP_C_CHILD_LABOUR_AND_DELIVERY = "CChildLabourAndDelivery";
	public static String PROP_PLAN = "Plan";
	public static String PROP_LR1 = "LR1";
	public static String PROP_CONSULTATION_DATE = "ConsultationDate";
	public static String PROP_C_CHILD_TO_PERIOD = "CChildToPeriod";
	public static String PROP_LR5 = "LR5";
	public static String PROP_LR4 = "LR4";
	public static String PROP_LR3 = "LR3";
	public static String PROP_LR2 = "LR2";
	public static String PROP_DENTURES_FITTED_REMODELS = "DenturesFittedRemodels";
	public static String PROP_FOETAL_HEART = "FoetalHeart";
	public static String PROP_PATIENT_ADVISE = "PatientAdvise";
	public static String PROP_UN_SAVEABLE_TEETH = "UnSaveableTeeth";
	public static String PROP_REFERED_DOCTARS = "ReferedDoctars";
	public static String PROP_SPECIALISED_TREATMENT = "SpecialisedTreatment";
	public static String PROP_CRY = "Cry";
	public static String PROP_REFERRAL_TREATMENT_TYPE = "ReferralTreatmentType";
	public static String PROP_NOTIFIABLE_STATUS = "NotifiableStatus";
	public static String PROP_DURATION_PHY = "DurationPhy";
	public static String PROP_LR8 = "LR8";
	public static String PROP_LR6 = "LR6";
	public static String PROP_LR7 = "LR7";
	public static String PROP_DENTAL_VALUE = "DentalValue";
	public static String PROP_ON_EXAMINATION = "OnExamination";
	public static String PROP_GPE_EXAMINATION = "Gpe_examination";
	public static String PROP_SKIN_COLOR = "SkinColor";
	public static String PROP_TEETH_EXTRACTED = "TeethExtracted";
	public static String PROP_TEMPERATURE = "Temperature";
	public static String PROP_RESPIRATORY = "Respiratory";
	public static String PROP_ALB = "alb";
	public static String PROP_REFERRED_FOR = "ReferredFor";
	public static String PROP_DISPOSAL = "Disposal";
	public static String PROP_LMP_DATE = "LmpDate";
	public static String PROP_A_CHILD_GENDER = "AChildGender";
	public static String PROP_LIVER = "Liver";
	public static String PROP_B_CHILD_ANTENATAL = "BChildAntenatal";
	public static String PROP_CLINICAL_EXAMINATION = "ClinicalExamination";
	public static String PROP_REFERRAL_DAYS = "ReferralDays";
	public static String PROP_MISSING_TEETH = "MissingTeeth";
	public static String PROP_REFERRED_DATE = "ReferredDate";
	public static String PROP_MISSING_TEETH_REMARK = "MissingTeethRemark";
	public static String PROP_GR = "Gr";
	public static String PROP_FOETAL_HEAD_ENGAGED = "FoetalHeadEngaged";
	public static String PROP_D_DTC = "DDtc";
	public static String PROP_MH_REFERRED_FOR = "MhReferredFor";
	public static String PROP_HB = "hb";
	public static String PROP_HOSP_NAME = "HospName";
	public static String PROP_NEAR_VISION = "NearVision";
	public static String PROP_PAP_SMEAR = "PapSmear";
	public static String PROP_ICD = "Icd";
	public static String PROP_DATE_NEXT_VISIT = "DateNextVisit";
	public static String PROP_DISTANT_VISION = "DistantVision";
	public static String PROP_THYROID = "Thyroid";
	public static String PROP_D_TREATMENT = "DTreatment";
	public static String PROP_HEIGHT = "Height";
	public static String PROP_B_CHILD_NO_OF_PRAG = "BChildNoOfPrag";
	public static String PROP_NO_OF_DENTAL_POINTS = "NoOfDentalPoints";
	public static String PROP_A_CHILD_LABOUR_AND_DELIVERY = "AChildLabourAndDelivery";
	public static String PROP_ID = "id";
	public static String PROP_C_CHILD_YEAR = "CChildYear";
	public static String PROP_CURRENT_EDD = "CurrentEdd";
	public static String PROP_PASTDISPOSAL = "Pastdisposal";
	public static String PROP_NEAR_L_CYL = "NearLCyl";
	public static String PROP_DOD = "Dod";
	public static String PROP_FUNDAL = "Fundal";
	public static String PROP_A_CHILD_TO_PERIOD = "AChildToPeriod";
	public static String PROP_NEAR_L_AXIS = "NearLAxis";
	public static String PROP_DENTAL_REMARK = "DentalRemark";
	public static String PROP_CHEST = "Chest";
	public static String PROP_DOA = "Doa";
	public static String PROP_IDEAL_WEIGHT = "IdealWeight";
	public static String PROP_RETURNFROM_HOSPITAL = "ReturnfromHospital";
	public static String PROP_THIRD_TRIMESTER = "ThirdTrimester";
	public static String PROP_C_CHILD_GENDER = "CChildGender";
	public static String PROP_TOTAL_UNSAVEABLE_TEETH = "TotalUnsaveableTeeth";
	public static String PROP_REFERRED_DEPT = "ReferredDept";
	public static String PROP_QUANTITY = "Quantity";
	public static String PROP_BREAST = "Breast";
	public static String PROP_DATE_OF_NEXT_REVIEW = "DateOfNextReview";
	public static String PROP_B_CHILD_YEAR = "BChildYear";
	public static String PROP_LOCATION = "Location";
	public static String PROP_POG = "Pog";
	public static String PROP_MEDICAL_SURGICAL_HISTORY = "MedicalSurgicalHistory";
	public static String PROP_ANESTHESIA_REMARK = "AnesthesiaRemark";
	public static String PROP_SYSTAMIC_EXAM = "SystamicExam";
	public static String PROP_OTHER_OBSERVATION = "OtherObservation";
	public static String PROP_URINE = "Urine";
	public static String PROP_REFERRED_DEPT_INT = "ReferredDeptInt";
	public static String PROP_NEXT_VISIT_DATE = "NextVisitDate";
	public static String PROP_TEETH_CONSERVES_WITH_RT = "TeethConservesWithRt";


	// constructors
	public BaseOpdPatientDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdPatientDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String age;
	private java.lang.String expectedHeight;
	private java.lang.String expectedWeight;
	private java.lang.String expectedBmi;
	private java.lang.String height;
	private java.lang.String whr;
	private java.lang.String idealWeight;
	private java.lang.String vweight;
	private java.lang.String pulse;
	private java.lang.String bp;
	private java.lang.String plan;
	private java.lang.String afmsDesc;
	private java.lang.String temperature;
	private java.util.Date nextVisitDate;
	private java.util.Date consultationDate;
	private java.lang.String consultationTime;
	private java.lang.String referredDept;
	private java.lang.String initialDiagnosis;
	private java.util.Date opdDate;
	private java.lang.String opdTime;
	private java.lang.String referedDoctars;
	private java.lang.String onExamination;
	private java.lang.String disposal;
	private java.lang.String days;
	private java.lang.String returnfromHospital;
	private java.lang.String hospName;
	private java.lang.String gpe_examination;
	private java.lang.String rr;
	private java.lang.String systamicExam;
	private java.lang.String doa;
	private java.lang.String dod;
	private java.lang.String bmi;
	private java.lang.String phyStatus;
	private java.lang.String adviceOnDischarge;
	private java.lang.String pastDiagnosis;
	private java.lang.String pastdisposal;
	private java.lang.String daysPhy;
	private java.lang.String durationPhy;
	private java.lang.String mhRun;
	private java.lang.String caseNotes;
	private java.lang.String mh;
	private java.lang.String mhDepartment;
	private java.lang.String mhReferredFor;
	private java.lang.String disposalDays;
	private java.lang.String dMainComplaint;
	private java.lang.String dSince1;
	private java.lang.String dAssociatedComplaint;
	private java.lang.String dSince2;
	private java.lang.String dRemarks1;
	private java.lang.String dRemarks2;
	private java.lang.Integer noOfTeeth;
	private java.lang.Integer noOfDefectiveTeeth;
	private java.lang.Integer noOfDentalPoints;
	private java.lang.Integer missingTeeth;
	private java.lang.Integer unSaveableTeeth;
	private java.lang.String dentalReferToMH;
	private java.lang.String conditionOfGums;
	private java.lang.String uR8;
	private java.lang.String uR7;
	private java.lang.String uR6;
	private java.lang.String uR5;
	private java.lang.String uR4;
	private java.lang.String uR3;
	private java.lang.String uR2;
	private java.lang.String uR1;
	private java.lang.String uL1;
	private java.lang.String uL2;
	private java.lang.String uL3;
	private java.lang.String uL4;
	private java.lang.String uL5;
	private java.lang.String uL6;
	private java.lang.String uL7;
	private java.lang.String uL8;
	private java.lang.String lR8;
	private java.lang.String lR7;
	private java.lang.String lR6;
	private java.lang.String lR5;
	private java.lang.String lR4;
	private java.lang.String lR3;
	private java.lang.String lR2;
	private java.lang.String lR1;
	private java.lang.String lL1;
	private java.lang.String lL2;
	private java.lang.String lL3;
	private java.lang.String lL4;
	private java.lang.String lL5;
	private java.lang.String lL6;
	private java.lang.String lL7;
	private java.lang.String lL8;
	private java.lang.String missingTeethRemark;
	private java.lang.String unsaveableTeethRemark;
	private java.lang.String dTreatment;
	private java.lang.String dDtc;
	private java.lang.String dTreatmentRemark;
	private java.lang.String anesthesiaRemark;
	private java.lang.Integer teethExtracted;
	private java.lang.Integer teethConservesWithRt;
	private java.lang.Integer teethConservesWithoutRt;
	private java.lang.Integer denturesFittedNew;
	private java.lang.Integer denturesFittedRemodels;
	private java.lang.Integer denturesFittedRepairs;
	private java.lang.String medicalSurgicalHistory;
	private java.lang.String specialisedTreatment;
	private java.lang.String totalMissingTeeth;
	private java.lang.String totalUnsaveableTeeth;
	private java.lang.Integer gr;
	private java.lang.Integer pARA;
	private java.util.Date lmpDate;
	private java.util.Date eddDate;
	private java.lang.Integer pog;
	private java.lang.String cvs;
	private java.lang.String respiratory;
	private java.lang.String thyroid;
	private java.lang.String breast;
	private java.lang.String general;
	private java.lang.String fhs;
	private java.lang.String otherFinding;
	private java.lang.String pa;
	private java.util.Date dateOfNextReview;
	private java.lang.String firstTrimester;
	private java.lang.String secondTrimester;
	private java.lang.String thirdTrimester;
	private java.lang.Integer aChildNoOfPrag;
	private java.lang.Integer aChildYear;
	private java.util.Date aChildFromPeriod;
	private java.util.Date aChildToPeriod;
	private java.lang.String aChildAntenatal;
	private java.lang.String aChildLabourAndDelivery;
	private java.lang.String aChildWeight;
	private java.lang.String aChildRemark;
	private java.lang.Integer bChildNoOfPrag;
	private java.lang.Integer bChildYear;
	private java.util.Date bChildFromPeriod;
	private java.util.Date bChildToPeriod;
	private java.lang.String bChildAntenatal;
	private java.lang.String bChildLabourAndDelivery;
	private java.lang.String bChildWeight;
	private java.lang.String bChildRemark;
	private java.lang.Integer cChildNoOfPrag;
	private java.lang.Integer cChildYear;
	private java.util.Date cChildFromPeriod;
	private java.util.Date cChildToPeriod;
	private java.lang.String cChildAntenatal;
	private java.lang.String cChildLabourAndDelivery;
	private java.lang.String cChildWeight;
	private java.lang.String cChildRemark;
	private java.lang.String mNoOfDays;
	private java.lang.String durationOfCycle;
	private java.lang.String mFlow;
	private java.lang.String mPain;
	private java.lang.String mRegularity;
	private java.lang.Integer ab;
	private java.lang.Integer l;
	private java.lang.Integer s;
	private java.lang.String aChildGender;
	private java.lang.String bChildGender;
	private java.lang.String cChildGender;
	private java.lang.String distantVision;
	private java.lang.String nearVision;
	private java.lang.String othersVision;
	private java.lang.String breastExam;
	private java.lang.String papSmear;
	private java.lang.String otherObservation;
	private java.lang.String systemicDisorder;
	private java.lang.String specialAdviseFollowup;
	private java.lang.String childAge;
	private java.lang.String childHeight;
	private java.lang.String childHeadCircumference;
	private java.lang.String childChest;
	private java.lang.String childRr;
	private java.lang.String dentalValue;
	private java.util.Date dateAnc;
	private java.util.Date dateNextVisit;
	private java.lang.String fundal;
	private java.lang.String pp;
	private java.lang.String foetalHeart;
	private java.lang.String foetalHeadEngaged;
	private java.lang.String oedema;
	private java.lang.String alb;
	private java.lang.String sugar;
	private java.lang.String hb;
	private java.lang.String remarks;
	private java.lang.String pollor;
	private java.lang.String clinicalExamination;
	private java.lang.String eyeRemark;
	private java.lang.String entRemark;
	private java.lang.String dentalRemark;
	private java.lang.String timeOfBirth;
	private java.lang.String typeOfDelivery;
	private java.lang.String gestationalAge;
	private java.lang.String urine;
	private java.lang.String disposedOff;
	private java.lang.String treatableTooth;
	private java.lang.String nameOfContrac;
	private java.lang.Integer quantity;
	private java.lang.String location;
	private java.lang.String notifiableStatus;
	private java.lang.Integer noOfChild;
	private java.lang.String gender;
	private java.lang.String drName;
	private java.lang.String domestic;
	private java.lang.String headCirum;
	private java.lang.String chest;
	private java.lang.String cry;
	private java.lang.String reflexes;
	private java.lang.String obscure;
	private java.lang.String skinColor;
	private java.lang.String heartRate;
	private java.lang.Integer pulses;
	private java.lang.String liver;
	private java.lang.String spleen;
	private java.lang.String nervousSystem;
	private java.lang.String status;
	private java.lang.String referredStatus;
	private java.lang.String referredType;
	private java.util.Date referredDate;
	private java.lang.String referralNotes;
	private java.lang.String patientAdvise;
	private java.lang.String admissionAdvised;
	private java.util.Date admissionDate;
	private java.util.Date referTillDate;
	private java.lang.Integer referralDays;
	private java.lang.String empanelStatus;
	private java.lang.Integer referralPriority;
	private java.lang.String referralTreatmentType;
	private java.lang.String referredFor;
	private java.lang.String pregnancy;
	private java.lang.Integer eyeIpd;
	private java.lang.String eyeUse;
	private java.lang.Integer distRSph;
	private java.lang.Integer distRCyl;
	private java.lang.Integer distRAxis;
	private java.lang.Integer distLSph;
	private java.lang.Integer distLCyl;
	private java.lang.Integer distLAxis;
	private java.lang.Integer nearRSph;
	private java.lang.Integer nearRCyl;
	private java.lang.Integer nearRAxis;
	private java.lang.Integer nearLSph;
	private java.lang.Integer nearLCyl;
	private java.lang.Integer nearLAxis;
	private java.lang.String lensType;
	private java.lang.Integer pr;
	private java.lang.String sp;
	private java.lang.String spine;
	private java.lang.String bst;
	private java.lang.String admissionNotes;
	private java.util.Date currentEdd;
	private java.lang.String operationPeriodToday;
	private java.lang.String icd;

	// many to one
	private jkt.hms.masters.business.MasEmployee issueTo;
	private jkt.hms.masters.business.MasEmployee referredDoctorInt;
	private jkt.hms.masters.business.MasImpanneledHospital impanneledHospital;
	private jkt.hms.masters.business.MasDepartment referredDeptInt;
	private jkt.hms.masters.business.Visit referralVisit;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasDepartment admissionWard;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.MasEmployee employee;
	private jkt.hms.masters.business.MasTherapyType therapyType;
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.MasSystemDiagnosis systemDiagnosis;
	private jkt.hms.masters.business.MasAnesthesia anesthesia;

	// collections
	private java.util.Set<jkt.hms.masters.business.PatientPrescriptionHeader> patientPrescriptionHeaders;
	private java.util.Set<jkt.hms.masters.business.ProcedureHeader> procedureHeaders;
	private java.util.Set<jkt.hms.masters.business.PhysioRequisitionHeader> physioRequisitionHeaders;
	private java.util.Set<jkt.hms.masters.business.OpdPatientHistory> opdPatientHistorys;
	private java.util.Set<jkt.hms.masters.business.DischargeIcdCode> dischargeIcdCodes;
	private java.util.Set<jkt.hms.masters.business.ObgDetails> obgDetails;
	private java.util.Set<jkt.hms.masters.business.Visit> visits;



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
	 * Return the value associated with the column: age
	 */
	public java.lang.String getAge () {
		return age;
	}

	/**
	 * Set the value related to the column: age
	 * @param age the age value
	 */
	public void setAge (java.lang.String age) {
		this.age = age;
	}



	/**
	 * Return the value associated with the column: EXPECTED_HEIGHT
	 */
	public java.lang.String getExpectedHeight () {
		return expectedHeight;
	}

	/**
	 * Set the value related to the column: EXPECTED_HEIGHT
	 * @param expectedHeight the EXPECTED_HEIGHT value
	 */
	public void setExpectedHeight (java.lang.String expectedHeight) {
		this.expectedHeight = expectedHeight;
	}



	/**
	 * Return the value associated with the column: EXPECTED_WEIGHT
	 */
	public java.lang.String getExpectedWeight () {
		return expectedWeight;
	}

	/**
	 * Set the value related to the column: EXPECTED_WEIGHT
	 * @param expectedWeight the EXPECTED_WEIGHT value
	 */
	public void setExpectedWeight (java.lang.String expectedWeight) {
		this.expectedWeight = expectedWeight;
	}



	/**
	 * Return the value associated with the column: EXPECTED_BMI
	 */
	public java.lang.String getExpectedBmi () {
		return expectedBmi;
	}

	/**
	 * Set the value related to the column: EXPECTED_BMI
	 * @param expectedBmi the EXPECTED_BMI value
	 */
	public void setExpectedBmi (java.lang.String expectedBmi) {
		this.expectedBmi = expectedBmi;
	}



	/**
	 * Return the value associated with the column: height
	 */
	public java.lang.String getHeight () {
		return height;
	}

	/**
	 * Set the value related to the column: height
	 * @param height the height value
	 */
	public void setHeight (java.lang.String height) {
		this.height = height;
	}



	/**
	 * Return the value associated with the column: whr
	 */
	public java.lang.String getWhr () {
		return whr;
	}

	/**
	 * Set the value related to the column: whr
	 * @param whr the whr value
	 */
	public void setWhr (java.lang.String whr) {
		this.whr = whr;
	}



	/**
	 * Return the value associated with the column: ideal_weight
	 */
	public java.lang.String getIdealWeight () {
		return idealWeight;
	}

	/**
	 * Set the value related to the column: ideal_weight
	 * @param idealWeight the ideal_weight value
	 */
	public void setIdealWeight (java.lang.String idealWeight) {
		this.idealWeight = idealWeight;
	}



	/**
	 * Return the value associated with the column: weight
	 */
	public java.lang.String getVweight () {
		return vweight;
	}

	/**
	 * Set the value related to the column: weight
	 * @param vweight the weight value
	 */
	public void setVweight (java.lang.String vweight) {
		this.vweight = vweight;
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
	 * Return the value associated with the column: plans
	 */
	public java.lang.String getPlan () {
		return plan;
	}

	/**
	 * Set the value related to the column: plans
	 * @param plan the plans value
	 */
	public void setPlan (java.lang.String plan) {
		this.plan = plan;
	}



	/**
	 * Return the value associated with the column: AFMS_desc
	 */
	public java.lang.String getAfmsDesc () {
		return afmsDesc;
	}

	/**
	 * Set the value related to the column: AFMS_desc
	 * @param afmsDesc the AFMS_desc value
	 */
	public void setAfmsDesc (java.lang.String afmsDesc) {
		this.afmsDesc = afmsDesc;
	}



	/**
	 * Return the value associated with the column: temperature
	 */
	public java.lang.String getTemperature () {
		return temperature;
	}

	/**
	 * Set the value related to the column: temperature
	 * @param temperature the temperature value
	 */
	public void setTemperature (java.lang.String temperature) {
		this.temperature = temperature;
	}



	/**
	 * Return the value associated with the column: next_visit_date
	 */
	public java.util.Date getNextVisitDate () {
		return nextVisitDate;
	}

	/**
	 * Set the value related to the column: next_visit_date
	 * @param nextVisitDate the next_visit_date value
	 */
	public void setNextVisitDate (java.util.Date nextVisitDate) {
		this.nextVisitDate = nextVisitDate;
	}



	/**
	 * Return the value associated with the column: consultation_date
	 */
	public java.util.Date getConsultationDate () {
		return consultationDate;
	}

	/**
	 * Set the value related to the column: consultation_date
	 * @param consultationDate the consultation_date value
	 */
	public void setConsultationDate (java.util.Date consultationDate) {
		this.consultationDate = consultationDate;
	}



	/**
	 * Return the value associated with the column: consultation_time
	 */
	public java.lang.String getConsultationTime () {
		return consultationTime;
	}

	/**
	 * Set the value related to the column: consultation_time
	 * @param consultationTime the consultation_time value
	 */
	public void setConsultationTime (java.lang.String consultationTime) {
		this.consultationTime = consultationTime;
	}



	/**
	 * Return the value associated with the column: referred_dept
	 */
	public java.lang.String getReferredDept () {
		return referredDept;
	}

	/**
	 * Set the value related to the column: referred_dept
	 * @param referredDept the referred_dept value
	 */
	public void setReferredDept (java.lang.String referredDept) {
		this.referredDept = referredDept;
	}



	/**
	 * Return the value associated with the column: initial_diagnosis
	 */
	public java.lang.String getInitialDiagnosis () {
		return initialDiagnosis;
	}

	/**
	 * Set the value related to the column: initial_diagnosis
	 * @param initialDiagnosis the initial_diagnosis value
	 */
	public void setInitialDiagnosis (java.lang.String initialDiagnosis) {
		this.initialDiagnosis = initialDiagnosis;
	}



	/**
	 * Return the value associated with the column: opd_date
	 */
	public java.util.Date getOpdDate () {
		return opdDate;
	}

	/**
	 * Set the value related to the column: opd_date
	 * @param opdDate the opd_date value
	 */
	public void setOpdDate (java.util.Date opdDate) {
		this.opdDate = opdDate;
	}



	/**
	 * Return the value associated with the column: opd_time
	 */
	public java.lang.String getOpdTime () {
		return opdTime;
	}

	/**
	 * Set the value related to the column: opd_time
	 * @param opdTime the opd_time value
	 */
	public void setOpdTime (java.lang.String opdTime) {
		this.opdTime = opdTime;
	}



	/**
	 * Return the value associated with the column: refered_doctars
	 */
	public java.lang.String getReferedDoctars () {
		return referedDoctars;
	}

	/**
	 * Set the value related to the column: refered_doctars
	 * @param referedDoctars the refered_doctars value
	 */
	public void setReferedDoctars (java.lang.String referedDoctars) {
		this.referedDoctars = referedDoctars;
	}



	/**
	 * Return the value associated with the column: on_examination
	 */
	public java.lang.String getOnExamination () {
		return onExamination;
	}

	/**
	 * Set the value related to the column: on_examination
	 * @param onExamination the on_examination value
	 */
	public void setOnExamination (java.lang.String onExamination) {
		this.onExamination = onExamination;
	}



	/**
	 * Return the value associated with the column: disposal
	 */
	public java.lang.String getDisposal () {
		return disposal;
	}

	/**
	 * Set the value related to the column: disposal
	 * @param disposal the disposal value
	 */
	public void setDisposal (java.lang.String disposal) {
		this.disposal = disposal;
	}



	/**
	 * Return the value associated with the column: days
	 */
	public java.lang.String getDays () {
		return days;
	}

	/**
	 * Set the value related to the column: days
	 * @param days the days value
	 */
	public void setDays (java.lang.String days) {
		this.days = days;
	}



	/**
	 * Return the value associated with the column: returnfromHospital
	 */
	public java.lang.String getReturnfromHospital () {
		return returnfromHospital;
	}

	/**
	 * Set the value related to the column: returnfromHospital
	 * @param returnfromHospital the returnfromHospital value
	 */
	public void setReturnfromHospital (java.lang.String returnfromHospital) {
		this.returnfromHospital = returnfromHospital;
	}



	/**
	 * Return the value associated with the column: hospName
	 */
	public java.lang.String getHospName () {
		return hospName;
	}

	/**
	 * Set the value related to the column: hospName
	 * @param hospName the hospName value
	 */
	public void setHospName (java.lang.String hospName) {
		this.hospName = hospName;
	}



	/**
	 * Return the value associated with the column: gpe_examination
	 */
	public java.lang.String getGpe_examination () {
		return gpe_examination;
	}

	/**
	 * Set the value related to the column: gpe_examination
	 * @param gpe_examination the gpe_examination value
	 */
	public void setGpe_examination (java.lang.String gpe_examination) {
		this.gpe_examination = gpe_examination;
	}



	/**
	 * Return the value associated with the column: rr
	 */
	public java.lang.String getRr () {
		return rr;
	}

	/**
	 * Set the value related to the column: rr
	 * @param rr the rr value
	 */
	public void setRr (java.lang.String rr) {
		this.rr = rr;
	}



	/**
	 * Return the value associated with the column: systamicExam
	 */
	public java.lang.String getSystamicExam () {
		return systamicExam;
	}

	/**
	 * Set the value related to the column: systamicExam
	 * @param systamicExam the systamicExam value
	 */
	public void setSystamicExam (java.lang.String systamicExam) {
		this.systamicExam = systamicExam;
	}



	/**
	 * Return the value associated with the column: doa
	 */
	public java.lang.String getDoa () {
		return doa;
	}

	/**
	 * Set the value related to the column: doa
	 * @param doa the doa value
	 */
	public void setDoa (java.lang.String doa) {
		this.doa = doa;
	}



	/**
	 * Return the value associated with the column: dod
	 */
	public java.lang.String getDod () {
		return dod;
	}

	/**
	 * Set the value related to the column: dod
	 * @param dod the dod value
	 */
	public void setDod (java.lang.String dod) {
		this.dod = dod;
	}



	/**
	 * Return the value associated with the column: bmi
	 */
	public java.lang.String getBmi () {
		return bmi;
	}

	/**
	 * Set the value related to the column: bmi
	 * @param bmi the bmi value
	 */
	public void setBmi (java.lang.String bmi) {
		this.bmi = bmi;
	}



	/**
	 * Return the value associated with the column: phy_status
	 */
	public java.lang.String getPhyStatus () {
		return phyStatus;
	}

	/**
	 * Set the value related to the column: phy_status
	 * @param phyStatus the phy_status value
	 */
	public void setPhyStatus (java.lang.String phyStatus) {
		this.phyStatus = phyStatus;
	}



	/**
	 * Return the value associated with the column: adviceOnDischarge
	 */
	public java.lang.String getAdviceOnDischarge () {
		return adviceOnDischarge;
	}

	/**
	 * Set the value related to the column: adviceOnDischarge
	 * @param adviceOnDischarge the adviceOnDischarge value
	 */
	public void setAdviceOnDischarge (java.lang.String adviceOnDischarge) {
		this.adviceOnDischarge = adviceOnDischarge;
	}



	/**
	 * Return the value associated with the column: pastDiagnosis
	 */
	public java.lang.String getPastDiagnosis () {
		return pastDiagnosis;
	}

	/**
	 * Set the value related to the column: pastDiagnosis
	 * @param pastDiagnosis the pastDiagnosis value
	 */
	public void setPastDiagnosis (java.lang.String pastDiagnosis) {
		this.pastDiagnosis = pastDiagnosis;
	}



	/**
	 * Return the value associated with the column: pastdisposal
	 */
	public java.lang.String getPastdisposal () {
		return pastdisposal;
	}

	/**
	 * Set the value related to the column: pastdisposal
	 * @param pastdisposal the pastdisposal value
	 */
	public void setPastdisposal (java.lang.String pastdisposal) {
		this.pastdisposal = pastdisposal;
	}



	/**
	 * Return the value associated with the column: DaysPhy
	 */
	public java.lang.String getDaysPhy () {
		return daysPhy;
	}

	/**
	 * Set the value related to the column: DaysPhy
	 * @param daysPhy the DaysPhy value
	 */
	public void setDaysPhy (java.lang.String daysPhy) {
		this.daysPhy = daysPhy;
	}



	/**
	 * Return the value associated with the column: DurationPhy
	 */
	public java.lang.String getDurationPhy () {
		return durationPhy;
	}

	/**
	 * Set the value related to the column: DurationPhy
	 * @param durationPhy the DurationPhy value
	 */
	public void setDurationPhy (java.lang.String durationPhy) {
		this.durationPhy = durationPhy;
	}



	/**
	 * Return the value associated with the column: mh_run
	 */
	public java.lang.String getMhRun () {
		return mhRun;
	}

	/**
	 * Set the value related to the column: mh_run
	 * @param mhRun the mh_run value
	 */
	public void setMhRun (java.lang.String mhRun) {
		this.mhRun = mhRun;
	}



	/**
	 * Return the value associated with the column: case_notes
	 */
	public java.lang.String getCaseNotes () {
		return caseNotes;
	}

	/**
	 * Set the value related to the column: case_notes
	 * @param caseNotes the case_notes value
	 */
	public void setCaseNotes (java.lang.String caseNotes) {
		this.caseNotes = caseNotes;
	}



	/**
	 * Return the value associated with the column: mh
	 */
	public java.lang.String getMh () {
		return mh;
	}

	/**
	 * Set the value related to the column: mh
	 * @param mh the mh value
	 */
	public void setMh (java.lang.String mh) {
		this.mh = mh;
	}



	/**
	 * Return the value associated with the column: MH_DEPARTMENT
	 */
	public java.lang.String getMhDepartment () {
		return mhDepartment;
	}

	/**
	 * Set the value related to the column: MH_DEPARTMENT
	 * @param mhDepartment the MH_DEPARTMENT value
	 */
	public void setMhDepartment (java.lang.String mhDepartment) {
		this.mhDepartment = mhDepartment;
	}



	/**
	 * Return the value associated with the column: MH_REFERRED_FOR
	 */
	public java.lang.String getMhReferredFor () {
		return mhReferredFor;
	}

	/**
	 * Set the value related to the column: MH_REFERRED_FOR
	 * @param mhReferredFor the MH_REFERRED_FOR value
	 */
	public void setMhReferredFor (java.lang.String mhReferredFor) {
		this.mhReferredFor = mhReferredFor;
	}



	/**
	 * Return the value associated with the column: DISPOSAL_DAYS
	 */
	public java.lang.String getDisposalDays () {
		return disposalDays;
	}

	/**
	 * Set the value related to the column: DISPOSAL_DAYS
	 * @param disposalDays the DISPOSAL_DAYS value
	 */
	public void setDisposalDays (java.lang.String disposalDays) {
		this.disposalDays = disposalDays;
	}



	/**
	 * Return the value associated with the column: D_MAIN_COMPLAINT
	 */
	public java.lang.String getDMainComplaint () {
		return dMainComplaint;
	}

	/**
	 * Set the value related to the column: D_MAIN_COMPLAINT
	 * @param dMainComplaint the D_MAIN_COMPLAINT value
	 */
	public void setDMainComplaint (java.lang.String dMainComplaint) {
		this.dMainComplaint = dMainComplaint;
	}



	/**
	 * Return the value associated with the column: D_SINCE1
	 */
	public java.lang.String getDSince1 () {
		return dSince1;
	}

	/**
	 * Set the value related to the column: D_SINCE1
	 * @param dSince1 the D_SINCE1 value
	 */
	public void setDSince1 (java.lang.String dSince1) {
		this.dSince1 = dSince1;
	}



	/**
	 * Return the value associated with the column: D_ASSOCIATED_COMPLAINT
	 */
	public java.lang.String getDAssociatedComplaint () {
		return dAssociatedComplaint;
	}

	/**
	 * Set the value related to the column: D_ASSOCIATED_COMPLAINT
	 * @param dAssociatedComplaint the D_ASSOCIATED_COMPLAINT value
	 */
	public void setDAssociatedComplaint (java.lang.String dAssociatedComplaint) {
		this.dAssociatedComplaint = dAssociatedComplaint;
	}



	/**
	 * Return the value associated with the column: D_SINCE2
	 */
	public java.lang.String getDSince2 () {
		return dSince2;
	}

	/**
	 * Set the value related to the column: D_SINCE2
	 * @param dSince2 the D_SINCE2 value
	 */
	public void setDSince2 (java.lang.String dSince2) {
		this.dSince2 = dSince2;
	}



	/**
	 * Return the value associated with the column: D_REMARKS1
	 */
	public java.lang.String getDRemarks1 () {
		return dRemarks1;
	}

	/**
	 * Set the value related to the column: D_REMARKS1
	 * @param dRemarks1 the D_REMARKS1 value
	 */
	public void setDRemarks1 (java.lang.String dRemarks1) {
		this.dRemarks1 = dRemarks1;
	}



	/**
	 * Return the value associated with the column: D_REMARKS2
	 */
	public java.lang.String getDRemarks2 () {
		return dRemarks2;
	}

	/**
	 * Set the value related to the column: D_REMARKS2
	 * @param dRemarks2 the D_REMARKS2 value
	 */
	public void setDRemarks2 (java.lang.String dRemarks2) {
		this.dRemarks2 = dRemarks2;
	}



	/**
	 * Return the value associated with the column: NO_OF_TEETH
	 */
	public java.lang.Integer getNoOfTeeth () {
		return noOfTeeth;
	}

	/**
	 * Set the value related to the column: NO_OF_TEETH
	 * @param noOfTeeth the NO_OF_TEETH value
	 */
	public void setNoOfTeeth (java.lang.Integer noOfTeeth) {
		this.noOfTeeth = noOfTeeth;
	}



	/**
	 * Return the value associated with the column: NO_OF_DEFECTIVE_TEETH
	 */
	public java.lang.Integer getNoOfDefectiveTeeth () {
		return noOfDefectiveTeeth;
	}

	/**
	 * Set the value related to the column: NO_OF_DEFECTIVE_TEETH
	 * @param noOfDefectiveTeeth the NO_OF_DEFECTIVE_TEETH value
	 */
	public void setNoOfDefectiveTeeth (java.lang.Integer noOfDefectiveTeeth) {
		this.noOfDefectiveTeeth = noOfDefectiveTeeth;
	}



	/**
	 * Return the value associated with the column: NO_OF_DENTAL_POINTS
	 */
	public java.lang.Integer getNoOfDentalPoints () {
		return noOfDentalPoints;
	}

	/**
	 * Set the value related to the column: NO_OF_DENTAL_POINTS
	 * @param noOfDentalPoints the NO_OF_DENTAL_POINTS value
	 */
	public void setNoOfDentalPoints (java.lang.Integer noOfDentalPoints) {
		this.noOfDentalPoints = noOfDentalPoints;
	}



	/**
	 * Return the value associated with the column: MISSING_TEETH
	 */
	public java.lang.Integer getMissingTeeth () {
		return missingTeeth;
	}

	/**
	 * Set the value related to the column: MISSING_TEETH
	 * @param missingTeeth the MISSING_TEETH value
	 */
	public void setMissingTeeth (java.lang.Integer missingTeeth) {
		this.missingTeeth = missingTeeth;
	}



	/**
	 * Return the value associated with the column: UN_SAVEABLE_TEETH
	 */
	public java.lang.Integer getUnSaveableTeeth () {
		return unSaveableTeeth;
	}

	/**
	 * Set the value related to the column: UN_SAVEABLE_TEETH
	 * @param unSaveableTeeth the UN_SAVEABLE_TEETH value
	 */
	public void setUnSaveableTeeth (java.lang.Integer unSaveableTeeth) {
		this.unSaveableTeeth = unSaveableTeeth;
	}



	/**
	 * Return the value associated with the column: dental_refer_to_mh
	 */
	public java.lang.String getDentalReferToMH () {
		return dentalReferToMH;
	}

	/**
	 * Set the value related to the column: dental_refer_to_mh
	 * @param dentalReferToMH the dental_refer_to_mh value
	 */
	public void setDentalReferToMH (java.lang.String dentalReferToMH) {
		this.dentalReferToMH = dentalReferToMH;
	}



	/**
	 * Return the value associated with the column: CONDITION_OF_GUMS
	 */
	public java.lang.String getConditionOfGums () {
		return conditionOfGums;
	}

	/**
	 * Set the value related to the column: CONDITION_OF_GUMS
	 * @param conditionOfGums the CONDITION_OF_GUMS value
	 */
	public void setConditionOfGums (java.lang.String conditionOfGums) {
		this.conditionOfGums = conditionOfGums;
	}



	/**
	 * Return the value associated with the column: u_r_8
	 */
	public java.lang.String getUR8 () {
		return uR8;
	}

	/**
	 * Set the value related to the column: u_r_8
	 * @param uR8 the u_r_8 value
	 */
	public void setUR8 (java.lang.String uR8) {
		this.uR8 = uR8;
	}



	/**
	 * Return the value associated with the column: u_r_7
	 */
	public java.lang.String getUR7 () {
		return uR7;
	}

	/**
	 * Set the value related to the column: u_r_7
	 * @param uR7 the u_r_7 value
	 */
	public void setUR7 (java.lang.String uR7) {
		this.uR7 = uR7;
	}



	/**
	 * Return the value associated with the column: u_r_6
	 */
	public java.lang.String getUR6 () {
		return uR6;
	}

	/**
	 * Set the value related to the column: u_r_6
	 * @param uR6 the u_r_6 value
	 */
	public void setUR6 (java.lang.String uR6) {
		this.uR6 = uR6;
	}



	/**
	 * Return the value associated with the column: u_r_5
	 */
	public java.lang.String getUR5 () {
		return uR5;
	}

	/**
	 * Set the value related to the column: u_r_5
	 * @param uR5 the u_r_5 value
	 */
	public void setUR5 (java.lang.String uR5) {
		this.uR5 = uR5;
	}



	/**
	 * Return the value associated with the column: u_r_4
	 */
	public java.lang.String getUR4 () {
		return uR4;
	}

	/**
	 * Set the value related to the column: u_r_4
	 * @param uR4 the u_r_4 value
	 */
	public void setUR4 (java.lang.String uR4) {
		this.uR4 = uR4;
	}



	/**
	 * Return the value associated with the column: u_r_3
	 */
	public java.lang.String getUR3 () {
		return uR3;
	}

	/**
	 * Set the value related to the column: u_r_3
	 * @param uR3 the u_r_3 value
	 */
	public void setUR3 (java.lang.String uR3) {
		this.uR3 = uR3;
	}



	/**
	 * Return the value associated with the column: u_r_2
	 */
	public java.lang.String getUR2 () {
		return uR2;
	}

	/**
	 * Set the value related to the column: u_r_2
	 * @param uR2 the u_r_2 value
	 */
	public void setUR2 (java.lang.String uR2) {
		this.uR2 = uR2;
	}



	/**
	 * Return the value associated with the column: u_r_1
	 */
	public java.lang.String getUR1 () {
		return uR1;
	}

	/**
	 * Set the value related to the column: u_r_1
	 * @param uR1 the u_r_1 value
	 */
	public void setUR1 (java.lang.String uR1) {
		this.uR1 = uR1;
	}



	/**
	 * Return the value associated with the column: u_l_1
	 */
	public java.lang.String getUL1 () {
		return uL1;
	}

	/**
	 * Set the value related to the column: u_l_1
	 * @param uL1 the u_l_1 value
	 */
	public void setUL1 (java.lang.String uL1) {
		this.uL1 = uL1;
	}



	/**
	 * Return the value associated with the column: u_l_2
	 */
	public java.lang.String getUL2 () {
		return uL2;
	}

	/**
	 * Set the value related to the column: u_l_2
	 * @param uL2 the u_l_2 value
	 */
	public void setUL2 (java.lang.String uL2) {
		this.uL2 = uL2;
	}



	/**
	 * Return the value associated with the column: u_l_3
	 */
	public java.lang.String getUL3 () {
		return uL3;
	}

	/**
	 * Set the value related to the column: u_l_3
	 * @param uL3 the u_l_3 value
	 */
	public void setUL3 (java.lang.String uL3) {
		this.uL3 = uL3;
	}



	/**
	 * Return the value associated with the column: u_l_4
	 */
	public java.lang.String getUL4 () {
		return uL4;
	}

	/**
	 * Set the value related to the column: u_l_4
	 * @param uL4 the u_l_4 value
	 */
	public void setUL4 (java.lang.String uL4) {
		this.uL4 = uL4;
	}



	/**
	 * Return the value associated with the column: u_l_5
	 */
	public java.lang.String getUL5 () {
		return uL5;
	}

	/**
	 * Set the value related to the column: u_l_5
	 * @param uL5 the u_l_5 value
	 */
	public void setUL5 (java.lang.String uL5) {
		this.uL5 = uL5;
	}



	/**
	 * Return the value associated with the column: u_l_6
	 */
	public java.lang.String getUL6 () {
		return uL6;
	}

	/**
	 * Set the value related to the column: u_l_6
	 * @param uL6 the u_l_6 value
	 */
	public void setUL6 (java.lang.String uL6) {
		this.uL6 = uL6;
	}



	/**
	 * Return the value associated with the column: u_l_7
	 */
	public java.lang.String getUL7 () {
		return uL7;
	}

	/**
	 * Set the value related to the column: u_l_7
	 * @param uL7 the u_l_7 value
	 */
	public void setUL7 (java.lang.String uL7) {
		this.uL7 = uL7;
	}



	/**
	 * Return the value associated with the column: u_l_8
	 */
	public java.lang.String getUL8 () {
		return uL8;
	}

	/**
	 * Set the value related to the column: u_l_8
	 * @param uL8 the u_l_8 value
	 */
	public void setUL8 (java.lang.String uL8) {
		this.uL8 = uL8;
	}



	/**
	 * Return the value associated with the column: l_r_8
	 */
	public java.lang.String getLR8 () {
		return lR8;
	}

	/**
	 * Set the value related to the column: l_r_8
	 * @param lR8 the l_r_8 value
	 */
	public void setLR8 (java.lang.String lR8) {
		this.lR8 = lR8;
	}



	/**
	 * Return the value associated with the column: l_r_7
	 */
	public java.lang.String getLR7 () {
		return lR7;
	}

	/**
	 * Set the value related to the column: l_r_7
	 * @param lR7 the l_r_7 value
	 */
	public void setLR7 (java.lang.String lR7) {
		this.lR7 = lR7;
	}



	/**
	 * Return the value associated with the column: l_r_6
	 */
	public java.lang.String getLR6 () {
		return lR6;
	}

	/**
	 * Set the value related to the column: l_r_6
	 * @param lR6 the l_r_6 value
	 */
	public void setLR6 (java.lang.String lR6) {
		this.lR6 = lR6;
	}



	/**
	 * Return the value associated with the column: l_r_5
	 */
	public java.lang.String getLR5 () {
		return lR5;
	}

	/**
	 * Set the value related to the column: l_r_5
	 * @param lR5 the l_r_5 value
	 */
	public void setLR5 (java.lang.String lR5) {
		this.lR5 = lR5;
	}



	/**
	 * Return the value associated with the column: l_r_4
	 */
	public java.lang.String getLR4 () {
		return lR4;
	}

	/**
	 * Set the value related to the column: l_r_4
	 * @param lR4 the l_r_4 value
	 */
	public void setLR4 (java.lang.String lR4) {
		this.lR4 = lR4;
	}



	/**
	 * Return the value associated with the column: l_r_3
	 */
	public java.lang.String getLR3 () {
		return lR3;
	}

	/**
	 * Set the value related to the column: l_r_3
	 * @param lR3 the l_r_3 value
	 */
	public void setLR3 (java.lang.String lR3) {
		this.lR3 = lR3;
	}



	/**
	 * Return the value associated with the column: l_r_2
	 */
	public java.lang.String getLR2 () {
		return lR2;
	}

	/**
	 * Set the value related to the column: l_r_2
	 * @param lR2 the l_r_2 value
	 */
	public void setLR2 (java.lang.String lR2) {
		this.lR2 = lR2;
	}



	/**
	 * Return the value associated with the column: l_r_1
	 */
	public java.lang.String getLR1 () {
		return lR1;
	}

	/**
	 * Set the value related to the column: l_r_1
	 * @param lR1 the l_r_1 value
	 */
	public void setLR1 (java.lang.String lR1) {
		this.lR1 = lR1;
	}



	/**
	 * Return the value associated with the column: l_l_1
	 */
	public java.lang.String getLL1 () {
		return lL1;
	}

	/**
	 * Set the value related to the column: l_l_1
	 * @param lL1 the l_l_1 value
	 */
	public void setLL1 (java.lang.String lL1) {
		this.lL1 = lL1;
	}



	/**
	 * Return the value associated with the column: l_l_2
	 */
	public java.lang.String getLL2 () {
		return lL2;
	}

	/**
	 * Set the value related to the column: l_l_2
	 * @param lL2 the l_l_2 value
	 */
	public void setLL2 (java.lang.String lL2) {
		this.lL2 = lL2;
	}



	/**
	 * Return the value associated with the column: l_l_3
	 */
	public java.lang.String getLL3 () {
		return lL3;
	}

	/**
	 * Set the value related to the column: l_l_3
	 * @param lL3 the l_l_3 value
	 */
	public void setLL3 (java.lang.String lL3) {
		this.lL3 = lL3;
	}



	/**
	 * Return the value associated with the column: l_l_4
	 */
	public java.lang.String getLL4 () {
		return lL4;
	}

	/**
	 * Set the value related to the column: l_l_4
	 * @param lL4 the l_l_4 value
	 */
	public void setLL4 (java.lang.String lL4) {
		this.lL4 = lL4;
	}



	/**
	 * Return the value associated with the column: l_l_5
	 */
	public java.lang.String getLL5 () {
		return lL5;
	}

	/**
	 * Set the value related to the column: l_l_5
	 * @param lL5 the l_l_5 value
	 */
	public void setLL5 (java.lang.String lL5) {
		this.lL5 = lL5;
	}



	/**
	 * Return the value associated with the column: l_l_6
	 */
	public java.lang.String getLL6 () {
		return lL6;
	}

	/**
	 * Set the value related to the column: l_l_6
	 * @param lL6 the l_l_6 value
	 */
	public void setLL6 (java.lang.String lL6) {
		this.lL6 = lL6;
	}



	/**
	 * Return the value associated with the column: l_l_7
	 */
	public java.lang.String getLL7 () {
		return lL7;
	}

	/**
	 * Set the value related to the column: l_l_7
	 * @param lL7 the l_l_7 value
	 */
	public void setLL7 (java.lang.String lL7) {
		this.lL7 = lL7;
	}



	/**
	 * Return the value associated with the column: l_l_8
	 */
	public java.lang.String getLL8 () {
		return lL8;
	}

	/**
	 * Set the value related to the column: l_l_8
	 * @param lL8 the l_l_8 value
	 */
	public void setLL8 (java.lang.String lL8) {
		this.lL8 = lL8;
	}



	/**
	 * Return the value associated with the column: MISSING_TEETH_REMARK
	 */
	public java.lang.String getMissingTeethRemark () {
		return missingTeethRemark;
	}

	/**
	 * Set the value related to the column: MISSING_TEETH_REMARK
	 * @param missingTeethRemark the MISSING_TEETH_REMARK value
	 */
	public void setMissingTeethRemark (java.lang.String missingTeethRemark) {
		this.missingTeethRemark = missingTeethRemark;
	}



	/**
	 * Return the value associated with the column: UNSAVEABLE_TEETH_REMARK
	 */
	public java.lang.String getUnsaveableTeethRemark () {
		return unsaveableTeethRemark;
	}

	/**
	 * Set the value related to the column: UNSAVEABLE_TEETH_REMARK
	 * @param unsaveableTeethRemark the UNSAVEABLE_TEETH_REMARK value
	 */
	public void setUnsaveableTeethRemark (java.lang.String unsaveableTeethRemark) {
		this.unsaveableTeethRemark = unsaveableTeethRemark;
	}



	/**
	 * Return the value associated with the column: D_TREATMENT
	 */
	public java.lang.String getDTreatment () {
		return dTreatment;
	}

	/**
	 * Set the value related to the column: D_TREATMENT
	 * @param dTreatment the D_TREATMENT value
	 */
	public void setDTreatment (java.lang.String dTreatment) {
		this.dTreatment = dTreatment;
	}



	/**
	 * Return the value associated with the column: D_DTC
	 */
	public java.lang.String getDDtc () {
		return dDtc;
	}

	/**
	 * Set the value related to the column: D_DTC
	 * @param dDtc the D_DTC value
	 */
	public void setDDtc (java.lang.String dDtc) {
		this.dDtc = dDtc;
	}



	/**
	 * Return the value associated with the column: D_TREATMENT_REMARK
	 */
	public java.lang.String getDTreatmentRemark () {
		return dTreatmentRemark;
	}

	/**
	 * Set the value related to the column: D_TREATMENT_REMARK
	 * @param dTreatmentRemark the D_TREATMENT_REMARK value
	 */
	public void setDTreatmentRemark (java.lang.String dTreatmentRemark) {
		this.dTreatmentRemark = dTreatmentRemark;
	}



	/**
	 * Return the value associated with the column: ANESTHESIA_REMARK
	 */
	public java.lang.String getAnesthesiaRemark () {
		return anesthesiaRemark;
	}

	/**
	 * Set the value related to the column: ANESTHESIA_REMARK
	 * @param anesthesiaRemark the ANESTHESIA_REMARK value
	 */
	public void setAnesthesiaRemark (java.lang.String anesthesiaRemark) {
		this.anesthesiaRemark = anesthesiaRemark;
	}



	/**
	 * Return the value associated with the column: TEETH_EXTRACTED
	 */
	public java.lang.Integer getTeethExtracted () {
		return teethExtracted;
	}

	/**
	 * Set the value related to the column: TEETH_EXTRACTED
	 * @param teethExtracted the TEETH_EXTRACTED value
	 */
	public void setTeethExtracted (java.lang.Integer teethExtracted) {
		this.teethExtracted = teethExtracted;
	}



	/**
	 * Return the value associated with the column: TEETH_CONSERVES_WITH_RT
	 */
	public java.lang.Integer getTeethConservesWithRt () {
		return teethConservesWithRt;
	}

	/**
	 * Set the value related to the column: TEETH_CONSERVES_WITH_RT
	 * @param teethConservesWithRt the TEETH_CONSERVES_WITH_RT value
	 */
	public void setTeethConservesWithRt (java.lang.Integer teethConservesWithRt) {
		this.teethConservesWithRt = teethConservesWithRt;
	}



	/**
	 * Return the value associated with the column: TEETH_CONSERVES_WITHOUT_RT
	 */
	public java.lang.Integer getTeethConservesWithoutRt () {
		return teethConservesWithoutRt;
	}

	/**
	 * Set the value related to the column: TEETH_CONSERVES_WITHOUT_RT
	 * @param teethConservesWithoutRt the TEETH_CONSERVES_WITHOUT_RT value
	 */
	public void setTeethConservesWithoutRt (java.lang.Integer teethConservesWithoutRt) {
		this.teethConservesWithoutRt = teethConservesWithoutRt;
	}



	/**
	 * Return the value associated with the column: DENTURES_FITTED_NEW
	 */
	public java.lang.Integer getDenturesFittedNew () {
		return denturesFittedNew;
	}

	/**
	 * Set the value related to the column: DENTURES_FITTED_NEW
	 * @param denturesFittedNew the DENTURES_FITTED_NEW value
	 */
	public void setDenturesFittedNew (java.lang.Integer denturesFittedNew) {
		this.denturesFittedNew = denturesFittedNew;
	}



	/**
	 * Return the value associated with the column: DENTURES_FITTED_REMODELS
	 */
	public java.lang.Integer getDenturesFittedRemodels () {
		return denturesFittedRemodels;
	}

	/**
	 * Set the value related to the column: DENTURES_FITTED_REMODELS
	 * @param denturesFittedRemodels the DENTURES_FITTED_REMODELS value
	 */
	public void setDenturesFittedRemodels (java.lang.Integer denturesFittedRemodels) {
		this.denturesFittedRemodels = denturesFittedRemodels;
	}



	/**
	 * Return the value associated with the column: DENTURES_FITTED_REPAIRS
	 */
	public java.lang.Integer getDenturesFittedRepairs () {
		return denturesFittedRepairs;
	}

	/**
	 * Set the value related to the column: DENTURES_FITTED_REPAIRS
	 * @param denturesFittedRepairs the DENTURES_FITTED_REPAIRS value
	 */
	public void setDenturesFittedRepairs (java.lang.Integer denturesFittedRepairs) {
		this.denturesFittedRepairs = denturesFittedRepairs;
	}



	/**
	 * Return the value associated with the column: MEDICAL_SURGICAL_HISTORY
	 */
	public java.lang.String getMedicalSurgicalHistory () {
		return medicalSurgicalHistory;
	}

	/**
	 * Set the value related to the column: MEDICAL_SURGICAL_HISTORY
	 * @param medicalSurgicalHistory the MEDICAL_SURGICAL_HISTORY value
	 */
	public void setMedicalSurgicalHistory (java.lang.String medicalSurgicalHistory) {
		this.medicalSurgicalHistory = medicalSurgicalHistory;
	}



	/**
	 * Return the value associated with the column: SPECIALISED_TREATMENT
	 */
	public java.lang.String getSpecialisedTreatment () {
		return specialisedTreatment;
	}

	/**
	 * Set the value related to the column: SPECIALISED_TREATMENT
	 * @param specialisedTreatment the SPECIALISED_TREATMENT value
	 */
	public void setSpecialisedTreatment (java.lang.String specialisedTreatment) {
		this.specialisedTreatment = specialisedTreatment;
	}



	/**
	 * Return the value associated with the column: TOTAL_MISSING_TEETH
	 */
	public java.lang.String getTotalMissingTeeth () {
		return totalMissingTeeth;
	}

	/**
	 * Set the value related to the column: TOTAL_MISSING_TEETH
	 * @param totalMissingTeeth the TOTAL_MISSING_TEETH value
	 */
	public void setTotalMissingTeeth (java.lang.String totalMissingTeeth) {
		this.totalMissingTeeth = totalMissingTeeth;
	}



	/**
	 * Return the value associated with the column: TOTAL_UNSAVEABLE_TEETH
	 */
	public java.lang.String getTotalUnsaveableTeeth () {
		return totalUnsaveableTeeth;
	}

	/**
	 * Set the value related to the column: TOTAL_UNSAVEABLE_TEETH
	 * @param totalUnsaveableTeeth the TOTAL_UNSAVEABLE_TEETH value
	 */
	public void setTotalUnsaveableTeeth (java.lang.String totalUnsaveableTeeth) {
		this.totalUnsaveableTeeth = totalUnsaveableTeeth;
	}



	/**
	 * Return the value associated with the column: GR
	 */
	public java.lang.Integer getGr () {
		return gr;
	}

	/**
	 * Set the value related to the column: GR
	 * @param gr the GR value
	 */
	public void setGr (java.lang.Integer gr) {
		this.gr = gr;
	}



	/**
	 * Return the value associated with the column: Para
	 */
	public java.lang.Integer getPARA () {
		return pARA;
	}

	/**
	 * Set the value related to the column: Para
	 * @param pARA the Para value
	 */
	public void setPARA (java.lang.Integer pARA) {
		this.pARA = pARA;
	}



	/**
	 * Return the value associated with the column: LMP_DATE
	 */
	public java.util.Date getLmpDate () {
		return lmpDate;
	}

	/**
	 * Set the value related to the column: LMP_DATE
	 * @param lmpDate the LMP_DATE value
	 */
	public void setLmpDate (java.util.Date lmpDate) {
		this.lmpDate = lmpDate;
	}



	/**
	 * Return the value associated with the column: EDD_DATE
	 */
	public java.util.Date getEddDate () {
		return eddDate;
	}

	/**
	 * Set the value related to the column: EDD_DATE
	 * @param eddDate the EDD_DATE value
	 */
	public void setEddDate (java.util.Date eddDate) {
		this.eddDate = eddDate;
	}



	/**
	 * Return the value associated with the column: pog
	 */
	public java.lang.Integer getPog () {
		return pog;
	}

	/**
	 * Set the value related to the column: pog
	 * @param pog the pog value
	 */
	public void setPog (java.lang.Integer pog) {
		this.pog = pog;
	}



	/**
	 * Return the value associated with the column: CVS
	 */
	public java.lang.String getCvs () {
		return cvs;
	}

	/**
	 * Set the value related to the column: CVS
	 * @param cvs the CVS value
	 */
	public void setCvs (java.lang.String cvs) {
		this.cvs = cvs;
	}



	/**
	 * Return the value associated with the column: RESPIRATORY
	 */
	public java.lang.String getRespiratory () {
		return respiratory;
	}

	/**
	 * Set the value related to the column: RESPIRATORY
	 * @param respiratory the RESPIRATORY value
	 */
	public void setRespiratory (java.lang.String respiratory) {
		this.respiratory = respiratory;
	}



	/**
	 * Return the value associated with the column: THYROID
	 */
	public java.lang.String getThyroid () {
		return thyroid;
	}

	/**
	 * Set the value related to the column: THYROID
	 * @param thyroid the THYROID value
	 */
	public void setThyroid (java.lang.String thyroid) {
		this.thyroid = thyroid;
	}



	/**
	 * Return the value associated with the column: BREAST
	 */
	public java.lang.String getBreast () {
		return breast;
	}

	/**
	 * Set the value related to the column: BREAST
	 * @param breast the BREAST value
	 */
	public void setBreast (java.lang.String breast) {
		this.breast = breast;
	}



	/**
	 * Return the value associated with the column: GENERAL
	 */
	public java.lang.String getGeneral () {
		return general;
	}

	/**
	 * Set the value related to the column: GENERAL
	 * @param general the GENERAL value
	 */
	public void setGeneral (java.lang.String general) {
		this.general = general;
	}



	/**
	 * Return the value associated with the column: FHS
	 */
	public java.lang.String getFhs () {
		return fhs;
	}

	/**
	 * Set the value related to the column: FHS
	 * @param fhs the FHS value
	 */
	public void setFhs (java.lang.String fhs) {
		this.fhs = fhs;
	}



	/**
	 * Return the value associated with the column: OTHER_FINDING
	 */
	public java.lang.String getOtherFinding () {
		return otherFinding;
	}

	/**
	 * Set the value related to the column: OTHER_FINDING
	 * @param otherFinding the OTHER_FINDING value
	 */
	public void setOtherFinding (java.lang.String otherFinding) {
		this.otherFinding = otherFinding;
	}



	/**
	 * Return the value associated with the column: PA
	 */
	public java.lang.String getPa () {
		return pa;
	}

	/**
	 * Set the value related to the column: PA
	 * @param pa the PA value
	 */
	public void setPa (java.lang.String pa) {
		this.pa = pa;
	}



	/**
	 * Return the value associated with the column: DATE_OF_NEXT_REVIEW
	 */
	public java.util.Date getDateOfNextReview () {
		return dateOfNextReview;
	}

	/**
	 * Set the value related to the column: DATE_OF_NEXT_REVIEW
	 * @param dateOfNextReview the DATE_OF_NEXT_REVIEW value
	 */
	public void setDateOfNextReview (java.util.Date dateOfNextReview) {
		this.dateOfNextReview = dateOfNextReview;
	}



	/**
	 * Return the value associated with the column: FIRST_TRIMESTER
	 */
	public java.lang.String getFirstTrimester () {
		return firstTrimester;
	}

	/**
	 * Set the value related to the column: FIRST_TRIMESTER
	 * @param firstTrimester the FIRST_TRIMESTER value
	 */
	public void setFirstTrimester (java.lang.String firstTrimester) {
		this.firstTrimester = firstTrimester;
	}



	/**
	 * Return the value associated with the column: SECOND_TRIMESTER
	 */
	public java.lang.String getSecondTrimester () {
		return secondTrimester;
	}

	/**
	 * Set the value related to the column: SECOND_TRIMESTER
	 * @param secondTrimester the SECOND_TRIMESTER value
	 */
	public void setSecondTrimester (java.lang.String secondTrimester) {
		this.secondTrimester = secondTrimester;
	}



	/**
	 * Return the value associated with the column: THIRD_TRIMESTER
	 */
	public java.lang.String getThirdTrimester () {
		return thirdTrimester;
	}

	/**
	 * Set the value related to the column: THIRD_TRIMESTER
	 * @param thirdTrimester the THIRD_TRIMESTER value
	 */
	public void setThirdTrimester (java.lang.String thirdTrimester) {
		this.thirdTrimester = thirdTrimester;
	}



	/**
	 * Return the value associated with the column: A_CHILD_NO_OF_PRAG
	 */
	public java.lang.Integer getAChildNoOfPrag () {
		return aChildNoOfPrag;
	}

	/**
	 * Set the value related to the column: A_CHILD_NO_OF_PRAG
	 * @param aChildNoOfPrag the A_CHILD_NO_OF_PRAG value
	 */
	public void setAChildNoOfPrag (java.lang.Integer aChildNoOfPrag) {
		this.aChildNoOfPrag = aChildNoOfPrag;
	}



	/**
	 * Return the value associated with the column: A_CHILD_YEAR
	 */
	public java.lang.Integer getAChildYear () {
		return aChildYear;
	}

	/**
	 * Set the value related to the column: A_CHILD_YEAR
	 * @param aChildYear the A_CHILD_YEAR value
	 */
	public void setAChildYear (java.lang.Integer aChildYear) {
		this.aChildYear = aChildYear;
	}



	/**
	 * Return the value associated with the column: A_CHILD_FROM_PERIOD
	 */
	public java.util.Date getAChildFromPeriod () {
		return aChildFromPeriod;
	}

	/**
	 * Set the value related to the column: A_CHILD_FROM_PERIOD
	 * @param aChildFromPeriod the A_CHILD_FROM_PERIOD value
	 */
	public void setAChildFromPeriod (java.util.Date aChildFromPeriod) {
		this.aChildFromPeriod = aChildFromPeriod;
	}



	/**
	 * Return the value associated with the column: A_CHILD_TO_PERIOD
	 */
	public java.util.Date getAChildToPeriod () {
		return aChildToPeriod;
	}

	/**
	 * Set the value related to the column: A_CHILD_TO_PERIOD
	 * @param aChildToPeriod the A_CHILD_TO_PERIOD value
	 */
	public void setAChildToPeriod (java.util.Date aChildToPeriod) {
		this.aChildToPeriod = aChildToPeriod;
	}



	/**
	 * Return the value associated with the column: A_CHILD_ANTENATAL
	 */
	public java.lang.String getAChildAntenatal () {
		return aChildAntenatal;
	}

	/**
	 * Set the value related to the column: A_CHILD_ANTENATAL
	 * @param aChildAntenatal the A_CHILD_ANTENATAL value
	 */
	public void setAChildAntenatal (java.lang.String aChildAntenatal) {
		this.aChildAntenatal = aChildAntenatal;
	}



	/**
	 * Return the value associated with the column: A_CHILD_LABOUR_AND_DELIVERY
	 */
	public java.lang.String getAChildLabourAndDelivery () {
		return aChildLabourAndDelivery;
	}

	/**
	 * Set the value related to the column: A_CHILD_LABOUR_AND_DELIVERY
	 * @param aChildLabourAndDelivery the A_CHILD_LABOUR_AND_DELIVERY value
	 */
	public void setAChildLabourAndDelivery (java.lang.String aChildLabourAndDelivery) {
		this.aChildLabourAndDelivery = aChildLabourAndDelivery;
	}



	/**
	 * Return the value associated with the column: A_CHILD_WEIGHT
	 */
	public java.lang.String getAChildWeight () {
		return aChildWeight;
	}

	/**
	 * Set the value related to the column: A_CHILD_WEIGHT
	 * @param aChildWeight the A_CHILD_WEIGHT value
	 */
	public void setAChildWeight (java.lang.String aChildWeight) {
		this.aChildWeight = aChildWeight;
	}



	/**
	 * Return the value associated with the column: A_CHILD_REMARK
	 */
	public java.lang.String getAChildRemark () {
		return aChildRemark;
	}

	/**
	 * Set the value related to the column: A_CHILD_REMARK
	 * @param aChildRemark the A_CHILD_REMARK value
	 */
	public void setAChildRemark (java.lang.String aChildRemark) {
		this.aChildRemark = aChildRemark;
	}



	/**
	 * Return the value associated with the column: B_CHILD_NO_OF_PRAG
	 */
	public java.lang.Integer getBChildNoOfPrag () {
		return bChildNoOfPrag;
	}

	/**
	 * Set the value related to the column: B_CHILD_NO_OF_PRAG
	 * @param bChildNoOfPrag the B_CHILD_NO_OF_PRAG value
	 */
	public void setBChildNoOfPrag (java.lang.Integer bChildNoOfPrag) {
		this.bChildNoOfPrag = bChildNoOfPrag;
	}



	/**
	 * Return the value associated with the column: B_CHILD_YEAR
	 */
	public java.lang.Integer getBChildYear () {
		return bChildYear;
	}

	/**
	 * Set the value related to the column: B_CHILD_YEAR
	 * @param bChildYear the B_CHILD_YEAR value
	 */
	public void setBChildYear (java.lang.Integer bChildYear) {
		this.bChildYear = bChildYear;
	}



	/**
	 * Return the value associated with the column: B_CHILD_FROM_PERIOD
	 */
	public java.util.Date getBChildFromPeriod () {
		return bChildFromPeriod;
	}

	/**
	 * Set the value related to the column: B_CHILD_FROM_PERIOD
	 * @param bChildFromPeriod the B_CHILD_FROM_PERIOD value
	 */
	public void setBChildFromPeriod (java.util.Date bChildFromPeriod) {
		this.bChildFromPeriod = bChildFromPeriod;
	}



	/**
	 * Return the value associated with the column: B_CHILD_TO_PERIOD
	 */
	public java.util.Date getBChildToPeriod () {
		return bChildToPeriod;
	}

	/**
	 * Set the value related to the column: B_CHILD_TO_PERIOD
	 * @param bChildToPeriod the B_CHILD_TO_PERIOD value
	 */
	public void setBChildToPeriod (java.util.Date bChildToPeriod) {
		this.bChildToPeriod = bChildToPeriod;
	}



	/**
	 * Return the value associated with the column: B_CHILD_ANTENATAL
	 */
	public java.lang.String getBChildAntenatal () {
		return bChildAntenatal;
	}

	/**
	 * Set the value related to the column: B_CHILD_ANTENATAL
	 * @param bChildAntenatal the B_CHILD_ANTENATAL value
	 */
	public void setBChildAntenatal (java.lang.String bChildAntenatal) {
		this.bChildAntenatal = bChildAntenatal;
	}



	/**
	 * Return the value associated with the column: B_CHILD_LABOUR_AND_DELIVERY
	 */
	public java.lang.String getBChildLabourAndDelivery () {
		return bChildLabourAndDelivery;
	}

	/**
	 * Set the value related to the column: B_CHILD_LABOUR_AND_DELIVERY
	 * @param bChildLabourAndDelivery the B_CHILD_LABOUR_AND_DELIVERY value
	 */
	public void setBChildLabourAndDelivery (java.lang.String bChildLabourAndDelivery) {
		this.bChildLabourAndDelivery = bChildLabourAndDelivery;
	}



	/**
	 * Return the value associated with the column: B_CHILD_WEIGHT
	 */
	public java.lang.String getBChildWeight () {
		return bChildWeight;
	}

	/**
	 * Set the value related to the column: B_CHILD_WEIGHT
	 * @param bChildWeight the B_CHILD_WEIGHT value
	 */
	public void setBChildWeight (java.lang.String bChildWeight) {
		this.bChildWeight = bChildWeight;
	}



	/**
	 * Return the value associated with the column: B_CHILD_REMARK
	 */
	public java.lang.String getBChildRemark () {
		return bChildRemark;
	}

	/**
	 * Set the value related to the column: B_CHILD_REMARK
	 * @param bChildRemark the B_CHILD_REMARK value
	 */
	public void setBChildRemark (java.lang.String bChildRemark) {
		this.bChildRemark = bChildRemark;
	}



	/**
	 * Return the value associated with the column: C_CHILD_NO_OF_PRAG
	 */
	public java.lang.Integer getCChildNoOfPrag () {
		return cChildNoOfPrag;
	}

	/**
	 * Set the value related to the column: C_CHILD_NO_OF_PRAG
	 * @param cChildNoOfPrag the C_CHILD_NO_OF_PRAG value
	 */
	public void setCChildNoOfPrag (java.lang.Integer cChildNoOfPrag) {
		this.cChildNoOfPrag = cChildNoOfPrag;
	}



	/**
	 * Return the value associated with the column: C_CHILD_YEAR
	 */
	public java.lang.Integer getCChildYear () {
		return cChildYear;
	}

	/**
	 * Set the value related to the column: C_CHILD_YEAR
	 * @param cChildYear the C_CHILD_YEAR value
	 */
	public void setCChildYear (java.lang.Integer cChildYear) {
		this.cChildYear = cChildYear;
	}



	/**
	 * Return the value associated with the column: C_CHILD_FROM_PERIOD
	 */
	public java.util.Date getCChildFromPeriod () {
		return cChildFromPeriod;
	}

	/**
	 * Set the value related to the column: C_CHILD_FROM_PERIOD
	 * @param cChildFromPeriod the C_CHILD_FROM_PERIOD value
	 */
	public void setCChildFromPeriod (java.util.Date cChildFromPeriod) {
		this.cChildFromPeriod = cChildFromPeriod;
	}



	/**
	 * Return the value associated with the column: C_CHILD_TO_PERIOD
	 */
	public java.util.Date getCChildToPeriod () {
		return cChildToPeriod;
	}

	/**
	 * Set the value related to the column: C_CHILD_TO_PERIOD
	 * @param cChildToPeriod the C_CHILD_TO_PERIOD value
	 */
	public void setCChildToPeriod (java.util.Date cChildToPeriod) {
		this.cChildToPeriod = cChildToPeriod;
	}



	/**
	 * Return the value associated with the column: C_CHILD_ANTENATAL
	 */
	public java.lang.String getCChildAntenatal () {
		return cChildAntenatal;
	}

	/**
	 * Set the value related to the column: C_CHILD_ANTENATAL
	 * @param cChildAntenatal the C_CHILD_ANTENATAL value
	 */
	public void setCChildAntenatal (java.lang.String cChildAntenatal) {
		this.cChildAntenatal = cChildAntenatal;
	}



	/**
	 * Return the value associated with the column: C_CHILD_LABOUR_AND_DELIVERY
	 */
	public java.lang.String getCChildLabourAndDelivery () {
		return cChildLabourAndDelivery;
	}

	/**
	 * Set the value related to the column: C_CHILD_LABOUR_AND_DELIVERY
	 * @param cChildLabourAndDelivery the C_CHILD_LABOUR_AND_DELIVERY value
	 */
	public void setCChildLabourAndDelivery (java.lang.String cChildLabourAndDelivery) {
		this.cChildLabourAndDelivery = cChildLabourAndDelivery;
	}



	/**
	 * Return the value associated with the column: C_CHILD_WEIGHT
	 */
	public java.lang.String getCChildWeight () {
		return cChildWeight;
	}

	/**
	 * Set the value related to the column: C_CHILD_WEIGHT
	 * @param cChildWeight the C_CHILD_WEIGHT value
	 */
	public void setCChildWeight (java.lang.String cChildWeight) {
		this.cChildWeight = cChildWeight;
	}



	/**
	 * Return the value associated with the column: C_CHILD_REMARK
	 */
	public java.lang.String getCChildRemark () {
		return cChildRemark;
	}

	/**
	 * Set the value related to the column: C_CHILD_REMARK
	 * @param cChildRemark the C_CHILD_REMARK value
	 */
	public void setCChildRemark (java.lang.String cChildRemark) {
		this.cChildRemark = cChildRemark;
	}



	/**
	 * Return the value associated with the column: M_NO_OF_DAYS
	 */
	public java.lang.String getMNoOfDays () {
		return mNoOfDays;
	}

	/**
	 * Set the value related to the column: M_NO_OF_DAYS
	 * @param mNoOfDays the M_NO_OF_DAYS value
	 */
	public void setMNoOfDays (java.lang.String mNoOfDays) {
		this.mNoOfDays = mNoOfDays;
	}



	/**
	 * Return the value associated with the column: DURATION_OF_CYCLE
	 */
	public java.lang.String getDurationOfCycle () {
		return durationOfCycle;
	}

	/**
	 * Set the value related to the column: DURATION_OF_CYCLE
	 * @param durationOfCycle the DURATION_OF_CYCLE value
	 */
	public void setDurationOfCycle (java.lang.String durationOfCycle) {
		this.durationOfCycle = durationOfCycle;
	}



	/**
	 * Return the value associated with the column: M_FLOW
	 */
	public java.lang.String getMFlow () {
		return mFlow;
	}

	/**
	 * Set the value related to the column: M_FLOW
	 * @param mFlow the M_FLOW value
	 */
	public void setMFlow (java.lang.String mFlow) {
		this.mFlow = mFlow;
	}



	/**
	 * Return the value associated with the column: M_PAIN
	 */
	public java.lang.String getMPain () {
		return mPain;
	}

	/**
	 * Set the value related to the column: M_PAIN
	 * @param mPain the M_PAIN value
	 */
	public void setMPain (java.lang.String mPain) {
		this.mPain = mPain;
	}



	/**
	 * Return the value associated with the column: M_REGULARITY
	 */
	public java.lang.String getMRegularity () {
		return mRegularity;
	}

	/**
	 * Set the value related to the column: M_REGULARITY
	 * @param mRegularity the M_REGULARITY value
	 */
	public void setMRegularity (java.lang.String mRegularity) {
		this.mRegularity = mRegularity;
	}



	/**
	 * Return the value associated with the column: AB
	 */
	public java.lang.Integer getAb () {
		return ab;
	}

	/**
	 * Set the value related to the column: AB
	 * @param ab the AB value
	 */
	public void setAb (java.lang.Integer ab) {
		this.ab = ab;
	}



	/**
	 * Return the value associated with the column: l
	 */
	public java.lang.Integer getL () {
		return l;
	}

	/**
	 * Set the value related to the column: l
	 * @param l the l value
	 */
	public void setL (java.lang.Integer l) {
		this.l = l;
	}



	/**
	 * Return the value associated with the column: s
	 */
	public java.lang.Integer getS () {
		return s;
	}

	/**
	 * Set the value related to the column: s
	 * @param s the s value
	 */
	public void setS (java.lang.Integer s) {
		this.s = s;
	}



	/**
	 * Return the value associated with the column: a_child_gender
	 */
	public java.lang.String getAChildGender () {
		return aChildGender;
	}

	/**
	 * Set the value related to the column: a_child_gender
	 * @param aChildGender the a_child_gender value
	 */
	public void setAChildGender (java.lang.String aChildGender) {
		this.aChildGender = aChildGender;
	}



	/**
	 * Return the value associated with the column: b_child_gender
	 */
	public java.lang.String getBChildGender () {
		return bChildGender;
	}

	/**
	 * Set the value related to the column: b_child_gender
	 * @param bChildGender the b_child_gender value
	 */
	public void setBChildGender (java.lang.String bChildGender) {
		this.bChildGender = bChildGender;
	}



	/**
	 * Return the value associated with the column: c_child_gender
	 */
	public java.lang.String getCChildGender () {
		return cChildGender;
	}

	/**
	 * Set the value related to the column: c_child_gender
	 * @param cChildGender the c_child_gender value
	 */
	public void setCChildGender (java.lang.String cChildGender) {
		this.cChildGender = cChildGender;
	}



	/**
	 * Return the value associated with the column: distant_vision
	 */
	public java.lang.String getDistantVision () {
		return distantVision;
	}

	/**
	 * Set the value related to the column: distant_vision
	 * @param distantVision the distant_vision value
	 */
	public void setDistantVision (java.lang.String distantVision) {
		this.distantVision = distantVision;
	}



	/**
	 * Return the value associated with the column: near_vision
	 */
	public java.lang.String getNearVision () {
		return nearVision;
	}

	/**
	 * Set the value related to the column: near_vision
	 * @param nearVision the near_vision value
	 */
	public void setNearVision (java.lang.String nearVision) {
		this.nearVision = nearVision;
	}



	/**
	 * Return the value associated with the column: others_vision
	 */
	public java.lang.String getOthersVision () {
		return othersVision;
	}

	/**
	 * Set the value related to the column: others_vision
	 * @param othersVision the others_vision value
	 */
	public void setOthersVision (java.lang.String othersVision) {
		this.othersVision = othersVision;
	}



	/**
	 * Return the value associated with the column: breast_exam
	 */
	public java.lang.String getBreastExam () {
		return breastExam;
	}

	/**
	 * Set the value related to the column: breast_exam
	 * @param breastExam the breast_exam value
	 */
	public void setBreastExam (java.lang.String breastExam) {
		this.breastExam = breastExam;
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
	 * Return the value associated with the column: other_observation
	 */
	public java.lang.String getOtherObservation () {
		return otherObservation;
	}

	/**
	 * Set the value related to the column: other_observation
	 * @param otherObservation the other_observation value
	 */
	public void setOtherObservation (java.lang.String otherObservation) {
		this.otherObservation = otherObservation;
	}



	/**
	 * Return the value associated with the column: systemic_disorder
	 */
	public java.lang.String getSystemicDisorder () {
		return systemicDisorder;
	}

	/**
	 * Set the value related to the column: systemic_disorder
	 * @param systemicDisorder the systemic_disorder value
	 */
	public void setSystemicDisorder (java.lang.String systemicDisorder) {
		this.systemicDisorder = systemicDisorder;
	}



	/**
	 * Return the value associated with the column: special_advise_followup
	 */
	public java.lang.String getSpecialAdviseFollowup () {
		return specialAdviseFollowup;
	}

	/**
	 * Set the value related to the column: special_advise_followup
	 * @param specialAdviseFollowup the special_advise_followup value
	 */
	public void setSpecialAdviseFollowup (java.lang.String specialAdviseFollowup) {
		this.specialAdviseFollowup = specialAdviseFollowup;
	}



	/**
	 * Return the value associated with the column: child_age
	 */
	public java.lang.String getChildAge () {
		return childAge;
	}

	/**
	 * Set the value related to the column: child_age
	 * @param childAge the child_age value
	 */
	public void setChildAge (java.lang.String childAge) {
		this.childAge = childAge;
	}



	/**
	 * Return the value associated with the column: child_height
	 */
	public java.lang.String getChildHeight () {
		return childHeight;
	}

	/**
	 * Set the value related to the column: child_height
	 * @param childHeight the child_height value
	 */
	public void setChildHeight (java.lang.String childHeight) {
		this.childHeight = childHeight;
	}



	/**
	 * Return the value associated with the column: child_head_circumference
	 */
	public java.lang.String getChildHeadCircumference () {
		return childHeadCircumference;
	}

	/**
	 * Set the value related to the column: child_head_circumference
	 * @param childHeadCircumference the child_head_circumference value
	 */
	public void setChildHeadCircumference (java.lang.String childHeadCircumference) {
		this.childHeadCircumference = childHeadCircumference;
	}



	/**
	 * Return the value associated with the column: child_chest
	 */
	public java.lang.String getChildChest () {
		return childChest;
	}

	/**
	 * Set the value related to the column: child_chest
	 * @param childChest the child_chest value
	 */
	public void setChildChest (java.lang.String childChest) {
		this.childChest = childChest;
	}



	/**
	 * Return the value associated with the column: child_rr
	 */
	public java.lang.String getChildRr () {
		return childRr;
	}

	/**
	 * Set the value related to the column: child_rr
	 * @param childRr the child_rr value
	 */
	public void setChildRr (java.lang.String childRr) {
		this.childRr = childRr;
	}



	/**
	 * Return the value associated with the column: dental_value
	 */
	public java.lang.String getDentalValue () {
		return dentalValue;
	}

	/**
	 * Set the value related to the column: dental_value
	 * @param dentalValue the dental_value value
	 */
	public void setDentalValue (java.lang.String dentalValue) {
		this.dentalValue = dentalValue;
	}



	/**
	 * Return the value associated with the column: date_anc
	 */
	public java.util.Date getDateAnc () {
		return dateAnc;
	}

	/**
	 * Set the value related to the column: date_anc
	 * @param dateAnc the date_anc value
	 */
	public void setDateAnc (java.util.Date dateAnc) {
		this.dateAnc = dateAnc;
	}



	/**
	 * Return the value associated with the column: date_next_visit
	 */
	public java.util.Date getDateNextVisit () {
		return dateNextVisit;
	}

	/**
	 * Set the value related to the column: date_next_visit
	 * @param dateNextVisit the date_next_visit value
	 */
	public void setDateNextVisit (java.util.Date dateNextVisit) {
		this.dateNextVisit = dateNextVisit;
	}



	/**
	 * Return the value associated with the column: fundal
	 */
	public java.lang.String getFundal () {
		return fundal;
	}

	/**
	 * Set the value related to the column: fundal
	 * @param fundal the fundal value
	 */
	public void setFundal (java.lang.String fundal) {
		this.fundal = fundal;
	}



	/**
	 * Return the value associated with the column: pp
	 */
	public java.lang.String getPp () {
		return pp;
	}

	/**
	 * Set the value related to the column: pp
	 * @param pp the pp value
	 */
	public void setPp (java.lang.String pp) {
		this.pp = pp;
	}



	/**
	 * Return the value associated with the column: foetal_heart
	 */
	public java.lang.String getFoetalHeart () {
		return foetalHeart;
	}

	/**
	 * Set the value related to the column: foetal_heart
	 * @param foetalHeart the foetal_heart value
	 */
	public void setFoetalHeart (java.lang.String foetalHeart) {
		this.foetalHeart = foetalHeart;
	}



	/**
	 * Return the value associated with the column: foetal_head_engaged
	 */
	public java.lang.String getFoetalHeadEngaged () {
		return foetalHeadEngaged;
	}

	/**
	 * Set the value related to the column: foetal_head_engaged
	 * @param foetalHeadEngaged the foetal_head_engaged value
	 */
	public void setFoetalHeadEngaged (java.lang.String foetalHeadEngaged) {
		this.foetalHeadEngaged = foetalHeadEngaged;
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
	 * Return the value associated with the column: alb
	 */
	public java.lang.String getAlb () {
		return alb;
	}

	/**
	 * Set the value related to the column: alb
	 * @param alb the alb value
	 */
	public void setAlb (java.lang.String alb) {
		this.alb = alb;
	}



	/**
	 * Return the value associated with the column: sugar
	 */
	public java.lang.String getSugar () {
		return sugar;
	}

	/**
	 * Set the value related to the column: sugar
	 * @param sugar the sugar value
	 */
	public void setSugar (java.lang.String sugar) {
		this.sugar = sugar;
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
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * @param remarks the remarks value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
	}



	/**
	 * Return the value associated with the column: pollor
	 */
	public java.lang.String getPollor () {
		return pollor;
	}

	/**
	 * Set the value related to the column: pollor
	 * @param pollor the pollor value
	 */
	public void setPollor (java.lang.String pollor) {
		this.pollor = pollor;
	}



	/**
	 * Return the value associated with the column: clinical_examination
	 */
	public java.lang.String getClinicalExamination () {
		return clinicalExamination;
	}

	/**
	 * Set the value related to the column: clinical_examination
	 * @param clinicalExamination the clinical_examination value
	 */
	public void setClinicalExamination (java.lang.String clinicalExamination) {
		this.clinicalExamination = clinicalExamination;
	}



	/**
	 * Return the value associated with the column: eye_remark
	 */
	public java.lang.String getEyeRemark () {
		return eyeRemark;
	}

	/**
	 * Set the value related to the column: eye_remark
	 * @param eyeRemark the eye_remark value
	 */
	public void setEyeRemark (java.lang.String eyeRemark) {
		this.eyeRemark = eyeRemark;
	}



	/**
	 * Return the value associated with the column: ent_remark
	 */
	public java.lang.String getEntRemark () {
		return entRemark;
	}

	/**
	 * Set the value related to the column: ent_remark
	 * @param entRemark the ent_remark value
	 */
	public void setEntRemark (java.lang.String entRemark) {
		this.entRemark = entRemark;
	}



	/**
	 * Return the value associated with the column: dental_remark
	 */
	public java.lang.String getDentalRemark () {
		return dentalRemark;
	}

	/**
	 * Set the value related to the column: dental_remark
	 * @param dentalRemark the dental_remark value
	 */
	public void setDentalRemark (java.lang.String dentalRemark) {
		this.dentalRemark = dentalRemark;
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
	 * Return the value associated with the column: type_of_delivery
	 */
	public java.lang.String getTypeOfDelivery () {
		return typeOfDelivery;
	}

	/**
	 * Set the value related to the column: type_of_delivery
	 * @param typeOfDelivery the type_of_delivery value
	 */
	public void setTypeOfDelivery (java.lang.String typeOfDelivery) {
		this.typeOfDelivery = typeOfDelivery;
	}



	/**
	 * Return the value associated with the column: gestational_age
	 */
	public java.lang.String getGestationalAge () {
		return gestationalAge;
	}

	/**
	 * Set the value related to the column: gestational_age
	 * @param gestationalAge the gestational_age value
	 */
	public void setGestationalAge (java.lang.String gestationalAge) {
		this.gestationalAge = gestationalAge;
	}



	/**
	 * Return the value associated with the column: urine
	 */
	public java.lang.String getUrine () {
		return urine;
	}

	/**
	 * Set the value related to the column: urine
	 * @param urine the urine value
	 */
	public void setUrine (java.lang.String urine) {
		this.urine = urine;
	}



	/**
	 * Return the value associated with the column: disposed_off
	 */
	public java.lang.String getDisposedOff () {
		return disposedOff;
	}

	/**
	 * Set the value related to the column: disposed_off
	 * @param disposedOff the disposed_off value
	 */
	public void setDisposedOff (java.lang.String disposedOff) {
		this.disposedOff = disposedOff;
	}



	/**
	 * Return the value associated with the column: TREATABLE_TOOTH
	 */
	public java.lang.String getTreatableTooth () {
		return treatableTooth;
	}

	/**
	 * Set the value related to the column: TREATABLE_TOOTH
	 * @param treatableTooth the TREATABLE_TOOTH value
	 */
	public void setTreatableTooth (java.lang.String treatableTooth) {
		this.treatableTooth = treatableTooth;
	}



	/**
	 * Return the value associated with the column: NAME_OF_CONSTRAC
	 */
	public java.lang.String getNameOfContrac () {
		return nameOfContrac;
	}

	/**
	 * Set the value related to the column: NAME_OF_CONSTRAC
	 * @param nameOfContrac the NAME_OF_CONSTRAC value
	 */
	public void setNameOfContrac (java.lang.String nameOfContrac) {
		this.nameOfContrac = nameOfContrac;
	}



	/**
	 * Return the value associated with the column: QUANTITY
	 */
	public java.lang.Integer getQuantity () {
		return quantity;
	}

	/**
	 * Set the value related to the column: QUANTITY
	 * @param quantity the QUANTITY value
	 */
	public void setQuantity (java.lang.Integer quantity) {
		this.quantity = quantity;
	}



	/**
	 * Return the value associated with the column: LOCATION
	 */
	public java.lang.String getLocation () {
		return location;
	}

	/**
	 * Set the value related to the column: LOCATION
	 * @param location the LOCATION value
	 */
	public void setLocation (java.lang.String location) {
		this.location = location;
	}



	/**
	 * Return the value associated with the column: NOTIFIABLE_STATUS
	 */
	public java.lang.String getNotifiableStatus () {
		return notifiableStatus;
	}

	/**
	 * Set the value related to the column: NOTIFIABLE_STATUS
	 * @param notifiableStatus the NOTIFIABLE_STATUS value
	 */
	public void setNotifiableStatus (java.lang.String notifiableStatus) {
		this.notifiableStatus = notifiableStatus;
	}



	/**
	 * Return the value associated with the column: NO_OF_CHILD
	 */
	public java.lang.Integer getNoOfChild () {
		return noOfChild;
	}

	/**
	 * Set the value related to the column: NO_OF_CHILD
	 * @param noOfChild the NO_OF_CHILD value
	 */
	public void setNoOfChild (java.lang.Integer noOfChild) {
		this.noOfChild = noOfChild;
	}



	/**
	 * Return the value associated with the column: gender
	 */
	public java.lang.String getGender () {
		return gender;
	}

	/**
	 * Set the value related to the column: gender
	 * @param gender the gender value
	 */
	public void setGender (java.lang.String gender) {
		this.gender = gender;
	}



	/**
	 * Return the value associated with the column: DR_NAME
	 */
	public java.lang.String getDrName () {
		return drName;
	}

	/**
	 * Set the value related to the column: DR_NAME
	 * @param drName the DR_NAME value
	 */
	public void setDrName (java.lang.String drName) {
		this.drName = drName;
	}



	/**
	 * Return the value associated with the column: DOMESTIC
	 */
	public java.lang.String getDomestic () {
		return domestic;
	}

	/**
	 * Set the value related to the column: DOMESTIC
	 * @param domestic the DOMESTIC value
	 */
	public void setDomestic (java.lang.String domestic) {
		this.domestic = domestic;
	}



	/**
	 * Return the value associated with the column: HEAD_CIRUM
	 */
	public java.lang.String getHeadCirum () {
		return headCirum;
	}

	/**
	 * Set the value related to the column: HEAD_CIRUM
	 * @param headCirum the HEAD_CIRUM value
	 */
	public void setHeadCirum (java.lang.String headCirum) {
		this.headCirum = headCirum;
	}



	/**
	 * Return the value associated with the column: CHEST
	 */
	public java.lang.String getChest () {
		return chest;
	}

	/**
	 * Set the value related to the column: CHEST
	 * @param chest the CHEST value
	 */
	public void setChest (java.lang.String chest) {
		this.chest = chest;
	}



	/**
	 * Return the value associated with the column: CRY
	 */
	public java.lang.String getCry () {
		return cry;
	}

	/**
	 * Set the value related to the column: CRY
	 * @param cry the CRY value
	 */
	public void setCry (java.lang.String cry) {
		this.cry = cry;
	}



	/**
	 * Return the value associated with the column: REFLEXES
	 */
	public java.lang.String getReflexes () {
		return reflexes;
	}

	/**
	 * Set the value related to the column: REFLEXES
	 * @param reflexes the REFLEXES value
	 */
	public void setReflexes (java.lang.String reflexes) {
		this.reflexes = reflexes;
	}



	/**
	 * Return the value associated with the column: OBSCURE
	 */
	public java.lang.String getObscure () {
		return obscure;
	}

	/**
	 * Set the value related to the column: OBSCURE
	 * @param obscure the OBSCURE value
	 */
	public void setObscure (java.lang.String obscure) {
		this.obscure = obscure;
	}



	/**
	 * Return the value associated with the column: SKIN_COLOR
	 */
	public java.lang.String getSkinColor () {
		return skinColor;
	}

	/**
	 * Set the value related to the column: SKIN_COLOR
	 * @param skinColor the SKIN_COLOR value
	 */
	public void setSkinColor (java.lang.String skinColor) {
		this.skinColor = skinColor;
	}



	/**
	 * Return the value associated with the column: HEART_RATE
	 */
	public java.lang.String getHeartRate () {
		return heartRate;
	}

	/**
	 * Set the value related to the column: HEART_RATE
	 * @param heartRate the HEART_RATE value
	 */
	public void setHeartRate (java.lang.String heartRate) {
		this.heartRate = heartRate;
	}



	/**
	 * Return the value associated with the column: PULSES
	 */
	public java.lang.Integer getPulses () {
		return pulses;
	}

	/**
	 * Set the value related to the column: PULSES
	 * @param pulses the PULSES value
	 */
	public void setPulses (java.lang.Integer pulses) {
		this.pulses = pulses;
	}



	/**
	 * Return the value associated with the column: LIVER
	 */
	public java.lang.String getLiver () {
		return liver;
	}

	/**
	 * Set the value related to the column: LIVER
	 * @param liver the LIVER value
	 */
	public void setLiver (java.lang.String liver) {
		this.liver = liver;
	}



	/**
	 * Return the value associated with the column: SPLEEN
	 */
	public java.lang.String getSpleen () {
		return spleen;
	}

	/**
	 * Set the value related to the column: SPLEEN
	 * @param spleen the SPLEEN value
	 */
	public void setSpleen (java.lang.String spleen) {
		this.spleen = spleen;
	}



	/**
	 * Return the value associated with the column: NERVOUS_SYSTEM
	 */
	public java.lang.String getNervousSystem () {
		return nervousSystem;
	}

	/**
	 * Set the value related to the column: NERVOUS_SYSTEM
	 * @param nervousSystem the NERVOUS_SYSTEM value
	 */
	public void setNervousSystem (java.lang.String nervousSystem) {
		this.nervousSystem = nervousSystem;
	}



	/**
	 * Return the value associated with the column: Status
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: Status
	 * @param status the Status value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
	}



	/**
	 * Return the value associated with the column: referred_status
	 */
	public java.lang.String getReferredStatus () {
		return referredStatus;
	}

	/**
	 * Set the value related to the column: referred_status
	 * @param referredStatus the referred_status value
	 */
	public void setReferredStatus (java.lang.String referredStatus) {
		this.referredStatus = referredStatus;
	}



	/**
	 * Return the value associated with the column: referred_type
	 */
	public java.lang.String getReferredType () {
		return referredType;
	}

	/**
	 * Set the value related to the column: referred_type
	 * @param referredType the referred_type value
	 */
	public void setReferredType (java.lang.String referredType) {
		this.referredType = referredType;
	}



	/**
	 * Return the value associated with the column: referred_date
	 */
	public java.util.Date getReferredDate () {
		return referredDate;
	}

	/**
	 * Set the value related to the column: referred_date
	 * @param referredDate the referred_date value
	 */
	public void setReferredDate (java.util.Date referredDate) {
		this.referredDate = referredDate;
	}



	/**
	 * Return the value associated with the column: referral_notes
	 */
	public java.lang.String getReferralNotes () {
		return referralNotes;
	}

	/**
	 * Set the value related to the column: referral_notes
	 * @param referralNotes the referral_notes value
	 */
	public void setReferralNotes (java.lang.String referralNotes) {
		this.referralNotes = referralNotes;
	}



	/**
	 * Return the value associated with the column: patient_advise
	 */
	public java.lang.String getPatientAdvise () {
		return patientAdvise;
	}

	/**
	 * Set the value related to the column: patient_advise
	 * @param patientAdvise the patient_advise value
	 */
	public void setPatientAdvise (java.lang.String patientAdvise) {
		this.patientAdvise = patientAdvise;
	}



	/**
	 * Return the value associated with the column: admission_advised
	 */
	public java.lang.String getAdmissionAdvised () {
		return admissionAdvised;
	}

	/**
	 * Set the value related to the column: admission_advised
	 * @param admissionAdvised the admission_advised value
	 */
	public void setAdmissionAdvised (java.lang.String admissionAdvised) {
		this.admissionAdvised = admissionAdvised;
	}



	/**
	 * Return the value associated with the column: admission_date
	 */
	public java.util.Date getAdmissionDate () {
		return admissionDate;
	}

	/**
	 * Set the value related to the column: admission_date
	 * @param admissionDate the admission_date value
	 */
	public void setAdmissionDate (java.util.Date admissionDate) {
		this.admissionDate = admissionDate;
	}



	/**
	 * Return the value associated with the column: refer_till_date
	 */
	public java.util.Date getReferTillDate () {
		return referTillDate;
	}

	/**
	 * Set the value related to the column: refer_till_date
	 * @param referTillDate the refer_till_date value
	 */
	public void setReferTillDate (java.util.Date referTillDate) {
		this.referTillDate = referTillDate;
	}



	/**
	 * Return the value associated with the column: referral_days
	 */
	public java.lang.Integer getReferralDays () {
		return referralDays;
	}

	/**
	 * Set the value related to the column: referral_days
	 * @param referralDays the referral_days value
	 */
	public void setReferralDays (java.lang.Integer referralDays) {
		this.referralDays = referralDays;
	}



	/**
	 * Return the value associated with the column: empanel_status
	 */
	public java.lang.String getEmpanelStatus () {
		return empanelStatus;
	}

	/**
	 * Set the value related to the column: empanel_status
	 * @param empanelStatus the empanel_status value
	 */
	public void setEmpanelStatus (java.lang.String empanelStatus) {
		this.empanelStatus = empanelStatus;
	}



	/**
	 * Return the value associated with the column: referral_priority
	 */
	public java.lang.Integer getReferralPriority () {
		return referralPriority;
	}

	/**
	 * Set the value related to the column: referral_priority
	 * @param referralPriority the referral_priority value
	 */
	public void setReferralPriority (java.lang.Integer referralPriority) {
		this.referralPriority = referralPriority;
	}



	/**
	 * Return the value associated with the column: referral_treatment_type
	 */
	public java.lang.String getReferralTreatmentType () {
		return referralTreatmentType;
	}

	/**
	 * Set the value related to the column: referral_treatment_type
	 * @param referralTreatmentType the referral_treatment_type value
	 */
	public void setReferralTreatmentType (java.lang.String referralTreatmentType) {
		this.referralTreatmentType = referralTreatmentType;
	}



	/**
	 * Return the value associated with the column: referred_for
	 */
	public java.lang.String getReferredFor () {
		return referredFor;
	}

	/**
	 * Set the value related to the column: referred_for
	 * @param referredFor the referred_for value
	 */
	public void setReferredFor (java.lang.String referredFor) {
		this.referredFor = referredFor;
	}



	/**
	 * Return the value associated with the column: pregnancy
	 */
	public java.lang.String getPregnancy () {
		return pregnancy;
	}

	/**
	 * Set the value related to the column: pregnancy
	 * @param pregnancy the pregnancy value
	 */
	public void setPregnancy (java.lang.String pregnancy) {
		this.pregnancy = pregnancy;
	}



	/**
	 * Return the value associated with the column: eye_ipd
	 */
	public java.lang.Integer getEyeIpd () {
		return eyeIpd;
	}

	/**
	 * Set the value related to the column: eye_ipd
	 * @param eyeIpd the eye_ipd value
	 */
	public void setEyeIpd (java.lang.Integer eyeIpd) {
		this.eyeIpd = eyeIpd;
	}



	/**
	 * Return the value associated with the column: eye_use
	 */
	public java.lang.String getEyeUse () {
		return eyeUse;
	}

	/**
	 * Set the value related to the column: eye_use
	 * @param eyeUse the eye_use value
	 */
	public void setEyeUse (java.lang.String eyeUse) {
		this.eyeUse = eyeUse;
	}



	/**
	 * Return the value associated with the column: dist_r_sph
	 */
	public java.lang.Integer getDistRSph () {
		return distRSph;
	}

	/**
	 * Set the value related to the column: dist_r_sph
	 * @param distRSph the dist_r_sph value
	 */
	public void setDistRSph (java.lang.Integer distRSph) {
		this.distRSph = distRSph;
	}



	/**
	 * Return the value associated with the column: dist_r_cyl
	 */
	public java.lang.Integer getDistRCyl () {
		return distRCyl;
	}

	/**
	 * Set the value related to the column: dist_r_cyl
	 * @param distRCyl the dist_r_cyl value
	 */
	public void setDistRCyl (java.lang.Integer distRCyl) {
		this.distRCyl = distRCyl;
	}



	/**
	 * Return the value associated with the column: dist_r_axis
	 */
	public java.lang.Integer getDistRAxis () {
		return distRAxis;
	}

	/**
	 * Set the value related to the column: dist_r_axis
	 * @param distRAxis the dist_r_axis value
	 */
	public void setDistRAxis (java.lang.Integer distRAxis) {
		this.distRAxis = distRAxis;
	}



	/**
	 * Return the value associated with the column: dist_l_sph
	 */
	public java.lang.Integer getDistLSph () {
		return distLSph;
	}

	/**
	 * Set the value related to the column: dist_l_sph
	 * @param distLSph the dist_l_sph value
	 */
	public void setDistLSph (java.lang.Integer distLSph) {
		this.distLSph = distLSph;
	}



	/**
	 * Return the value associated with the column: dist_l_cyl
	 */
	public java.lang.Integer getDistLCyl () {
		return distLCyl;
	}

	/**
	 * Set the value related to the column: dist_l_cyl
	 * @param distLCyl the dist_l_cyl value
	 */
	public void setDistLCyl (java.lang.Integer distLCyl) {
		this.distLCyl = distLCyl;
	}



	/**
	 * Return the value associated with the column: dist_l_axis
	 */
	public java.lang.Integer getDistLAxis () {
		return distLAxis;
	}

	/**
	 * Set the value related to the column: dist_l_axis
	 * @param distLAxis the dist_l_axis value
	 */
	public void setDistLAxis (java.lang.Integer distLAxis) {
		this.distLAxis = distLAxis;
	}



	/**
	 * Return the value associated with the column: near_r_sph
	 */
	public java.lang.Integer getNearRSph () {
		return nearRSph;
	}

	/**
	 * Set the value related to the column: near_r_sph
	 * @param nearRSph the near_r_sph value
	 */
	public void setNearRSph (java.lang.Integer nearRSph) {
		this.nearRSph = nearRSph;
	}



	/**
	 * Return the value associated with the column: near_r_cyl
	 */
	public java.lang.Integer getNearRCyl () {
		return nearRCyl;
	}

	/**
	 * Set the value related to the column: near_r_cyl
	 * @param nearRCyl the near_r_cyl value
	 */
	public void setNearRCyl (java.lang.Integer nearRCyl) {
		this.nearRCyl = nearRCyl;
	}



	/**
	 * Return the value associated with the column: near_r_axis
	 */
	public java.lang.Integer getNearRAxis () {
		return nearRAxis;
	}

	/**
	 * Set the value related to the column: near_r_axis
	 * @param nearRAxis the near_r_axis value
	 */
	public void setNearRAxis (java.lang.Integer nearRAxis) {
		this.nearRAxis = nearRAxis;
	}



	/**
	 * Return the value associated with the column: near_l_sph
	 */
	public java.lang.Integer getNearLSph () {
		return nearLSph;
	}

	/**
	 * Set the value related to the column: near_l_sph
	 * @param nearLSph the near_l_sph value
	 */
	public void setNearLSph (java.lang.Integer nearLSph) {
		this.nearLSph = nearLSph;
	}



	/**
	 * Return the value associated with the column: near_l_cyl
	 */
	public java.lang.Integer getNearLCyl () {
		return nearLCyl;
	}

	/**
	 * Set the value related to the column: near_l_cyl
	 * @param nearLCyl the near_l_cyl value
	 */
	public void setNearLCyl (java.lang.Integer nearLCyl) {
		this.nearLCyl = nearLCyl;
	}



	/**
	 * Return the value associated with the column: near_l_axis
	 */
	public java.lang.Integer getNearLAxis () {
		return nearLAxis;
	}

	/**
	 * Set the value related to the column: near_l_axis
	 * @param nearLAxis the near_l_axis value
	 */
	public void setNearLAxis (java.lang.Integer nearLAxis) {
		this.nearLAxis = nearLAxis;
	}



	/**
	 * Return the value associated with the column: lens_type
	 */
	public java.lang.String getLensType () {
		return lensType;
	}

	/**
	 * Set the value related to the column: lens_type
	 * @param lensType the lens_type value
	 */
	public void setLensType (java.lang.String lensType) {
		this.lensType = lensType;
	}



	/**
	 * Return the value associated with the column: pr
	 */
	public java.lang.Integer getPr () {
		return pr;
	}

	/**
	 * Set the value related to the column: pr
	 * @param pr the pr value
	 */
	public void setPr (java.lang.Integer pr) {
		this.pr = pr;
	}



	/**
	 * Return the value associated with the column: sp
	 */
	public java.lang.String getSp () {
		return sp;
	}

	/**
	 * Set the value related to the column: sp
	 * @param sp the sp value
	 */
	public void setSp (java.lang.String sp) {
		this.sp = sp;
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
	 * Return the value associated with the column: bst
	 */
	public java.lang.String getBst () {
		return bst;
	}

	/**
	 * Set the value related to the column: bst
	 * @param bst the bst value
	 */
	public void setBst (java.lang.String bst) {
		this.bst = bst;
	}



	/**
	 * Return the value associated with the column: admission_notes
	 */
	public java.lang.String getAdmissionNotes () {
		return admissionNotes;
	}

	/**
	 * Set the value related to the column: admission_notes
	 * @param admissionNotes the admission_notes value
	 */
	public void setAdmissionNotes (java.lang.String admissionNotes) {
		this.admissionNotes = admissionNotes;
	}



	/**
	 * Return the value associated with the column: current_edd
	 */
	public java.util.Date getCurrentEdd () {
		return currentEdd;
	}

	/**
	 * Set the value related to the column: current_edd
	 * @param currentEdd the current_edd value
	 */
	public void setCurrentEdd (java.util.Date currentEdd) {
		this.currentEdd = currentEdd;
	}



	/**
	 * Return the value associated with the column: operation_period_today
	 */
	public java.lang.String getOperationPeriodToday () {
		return operationPeriodToday;
	}

	/**
	 * Set the value related to the column: operation_period_today
	 * @param operationPeriodToday the operation_period_today value
	 */
	public void setOperationPeriodToday (java.lang.String operationPeriodToday) {
		this.operationPeriodToday = operationPeriodToday;
	}



	/**
	 * Return the value associated with the column: icd
	 */
	public java.lang.String getIcd () {
		return icd;
	}

	/**
	 * Set the value related to the column: icd
	 * @param icd the icd value
	 */
	public void setIcd (java.lang.String icd) {
		this.icd = icd;
	}



	/**
	 * Return the value associated with the column: ISSUE_TO
	 */
	public jkt.hms.masters.business.MasEmployee getIssueTo () {
		return issueTo;
	}

	/**
	 * Set the value related to the column: ISSUE_TO
	 * @param issueTo the ISSUE_TO value
	 */
	public void setIssueTo (jkt.hms.masters.business.MasEmployee issueTo) {
		this.issueTo = issueTo;
	}



	/**
	 * Return the value associated with the column: referred_doctor_int
	 */
	public jkt.hms.masters.business.MasEmployee getReferredDoctorInt () {
		return referredDoctorInt;
	}

	/**
	 * Set the value related to the column: referred_doctor_int
	 * @param referredDoctorInt the referred_doctor_int value
	 */
	public void setReferredDoctorInt (jkt.hms.masters.business.MasEmployee referredDoctorInt) {
		this.referredDoctorInt = referredDoctorInt;
	}



	/**
	 * Return the value associated with the column: impanneled_hospital_id
	 */
	public jkt.hms.masters.business.MasImpanneledHospital getImpanneledHospital () {
		return impanneledHospital;
	}

	/**
	 * Set the value related to the column: impanneled_hospital_id
	 * @param impanneledHospital the impanneled_hospital_id value
	 */
	public void setImpanneledHospital (jkt.hms.masters.business.MasImpanneledHospital impanneledHospital) {
		this.impanneledHospital = impanneledHospital;
	}



	/**
	 * Return the value associated with the column: referred_dept_int
	 */
	public jkt.hms.masters.business.MasDepartment getReferredDeptInt () {
		return referredDeptInt;
	}

	/**
	 * Set the value related to the column: referred_dept_int
	 * @param referredDeptInt the referred_dept_int value
	 */
	public void setReferredDeptInt (jkt.hms.masters.business.MasDepartment referredDeptInt) {
		this.referredDeptInt = referredDeptInt;
	}



	/**
	 * Return the value associated with the column: referral_visit_id
	 */
	public jkt.hms.masters.business.Visit getReferralVisit () {
		return referralVisit;
	}

	/**
	 * Set the value related to the column: referral_visit_id
	 * @param referralVisit the referral_visit_id value
	 */
	public void setReferralVisit (jkt.hms.masters.business.Visit referralVisit) {
		this.referralVisit = referralVisit;
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
	 * Return the value associated with the column: admission_ward
	 */
	public jkt.hms.masters.business.MasDepartment getAdmissionWard () {
		return admissionWard;
	}

	/**
	 * Set the value related to the column: admission_ward
	 * @param admissionWard the admission_ward value
	 */
	public void setAdmissionWard (jkt.hms.masters.business.MasDepartment admissionWard) {
		this.admissionWard = admissionWard;
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
	 * Return the value associated with the column: employee_id
	 */
	public jkt.hms.masters.business.MasEmployee getEmployee () {
		return employee;
	}

	/**
	 * Set the value related to the column: employee_id
	 * @param employee the employee_id value
	 */
	public void setEmployee (jkt.hms.masters.business.MasEmployee employee) {
		this.employee = employee;
	}



	/**
	 * Return the value associated with the column: threpytypeId
	 */
	public jkt.hms.masters.business.MasTherapyType getTherapyType () {
		return therapyType;
	}

	/**
	 * Set the value related to the column: threpytypeId
	 * @param therapyType the threpytypeId value
	 */
	public void setTherapyType (jkt.hms.masters.business.MasTherapyType therapyType) {
		this.therapyType = therapyType;
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
	 * Return the value associated with the column: SYSTEM_DIAGNOSIS_ID
	 */
	public jkt.hms.masters.business.MasSystemDiagnosis getSystemDiagnosis () {
		return systemDiagnosis;
	}

	/**
	 * Set the value related to the column: SYSTEM_DIAGNOSIS_ID
	 * @param systemDiagnosis the SYSTEM_DIAGNOSIS_ID value
	 */
	public void setSystemDiagnosis (jkt.hms.masters.business.MasSystemDiagnosis systemDiagnosis) {
		this.systemDiagnosis = systemDiagnosis;
	}



	/**
	 * Return the value associated with the column: ANESTHESIA_ID
	 */
	public jkt.hms.masters.business.MasAnesthesia getAnesthesia () {
		return anesthesia;
	}

	/**
	 * Set the value related to the column: ANESTHESIA_ID
	 * @param anesthesia the ANESTHESIA_ID value
	 */
	public void setAnesthesia (jkt.hms.masters.business.MasAnesthesia anesthesia) {
		this.anesthesia = anesthesia;
	}



	/**
	 * Return the value associated with the column: PatientPrescriptionHeaders
	 */
	public java.util.Set<jkt.hms.masters.business.PatientPrescriptionHeader> getPatientPrescriptionHeaders () {
		return patientPrescriptionHeaders;
	}

	/**
	 * Set the value related to the column: PatientPrescriptionHeaders
	 * @param patientPrescriptionHeaders the PatientPrescriptionHeaders value
	 */
	public void setPatientPrescriptionHeaders (java.util.Set<jkt.hms.masters.business.PatientPrescriptionHeader> patientPrescriptionHeaders) {
		this.patientPrescriptionHeaders = patientPrescriptionHeaders;
	}

	public void addToPatientPrescriptionHeaders (jkt.hms.masters.business.PatientPrescriptionHeader patientPrescriptionHeader) {
		if (null == getPatientPrescriptionHeaders()) setPatientPrescriptionHeaders(new java.util.TreeSet<jkt.hms.masters.business.PatientPrescriptionHeader>());
		getPatientPrescriptionHeaders().add(patientPrescriptionHeader);
	}



	/**
	 * Return the value associated with the column: ProcedureHeaders
	 */
	public java.util.Set<jkt.hms.masters.business.ProcedureHeader> getProcedureHeaders () {
		return procedureHeaders;
	}

	/**
	 * Set the value related to the column: ProcedureHeaders
	 * @param procedureHeaders the ProcedureHeaders value
	 */
	public void setProcedureHeaders (java.util.Set<jkt.hms.masters.business.ProcedureHeader> procedureHeaders) {
		this.procedureHeaders = procedureHeaders;
	}

	public void addToProcedureHeaders (jkt.hms.masters.business.ProcedureHeader procedureHeader) {
		if (null == getProcedureHeaders()) setProcedureHeaders(new java.util.TreeSet<jkt.hms.masters.business.ProcedureHeader>());
		getProcedureHeaders().add(procedureHeader);
	}



	/**
	 * Return the value associated with the column: PhysioRequisitionHeaders
	 */
	public java.util.Set<jkt.hms.masters.business.PhysioRequisitionHeader> getPhysioRequisitionHeaders () {
		return physioRequisitionHeaders;
	}

	/**
	 * Set the value related to the column: PhysioRequisitionHeaders
	 * @param physioRequisitionHeaders the PhysioRequisitionHeaders value
	 */
	public void setPhysioRequisitionHeaders (java.util.Set<jkt.hms.masters.business.PhysioRequisitionHeader> physioRequisitionHeaders) {
		this.physioRequisitionHeaders = physioRequisitionHeaders;
	}

	public void addToPhysioRequisitionHeaders (jkt.hms.masters.business.PhysioRequisitionHeader physioRequisitionHeader) {
		if (null == getPhysioRequisitionHeaders()) setPhysioRequisitionHeaders(new java.util.TreeSet<jkt.hms.masters.business.PhysioRequisitionHeader>());
		getPhysioRequisitionHeaders().add(physioRequisitionHeader);
	}



	/**
	 * Return the value associated with the column: OpdPatientHistorys
	 */
	public java.util.Set<jkt.hms.masters.business.OpdPatientHistory> getOpdPatientHistorys () {
		return opdPatientHistorys;
	}

	/**
	 * Set the value related to the column: OpdPatientHistorys
	 * @param opdPatientHistorys the OpdPatientHistorys value
	 */
	public void setOpdPatientHistorys (java.util.Set<jkt.hms.masters.business.OpdPatientHistory> opdPatientHistorys) {
		this.opdPatientHistorys = opdPatientHistorys;
	}

	public void addToOpdPatientHistorys (jkt.hms.masters.business.OpdPatientHistory opdPatientHistory) {
		if (null == getOpdPatientHistorys()) setOpdPatientHistorys(new java.util.TreeSet<jkt.hms.masters.business.OpdPatientHistory>());
		getOpdPatientHistorys().add(opdPatientHistory);
	}



	/**
	 * Return the value associated with the column: DischargeIcdCodes
	 */
	public java.util.Set<jkt.hms.masters.business.DischargeIcdCode> getDischargeIcdCodes () {
		return dischargeIcdCodes;
	}

	/**
	 * Set the value related to the column: DischargeIcdCodes
	 * @param dischargeIcdCodes the DischargeIcdCodes value
	 */
	public void setDischargeIcdCodes (java.util.Set<jkt.hms.masters.business.DischargeIcdCode> dischargeIcdCodes) {
		this.dischargeIcdCodes = dischargeIcdCodes;
	}

	public void addToDischargeIcdCodes (jkt.hms.masters.business.DischargeIcdCode dischargeIcdCode) {
		if (null == getDischargeIcdCodes()) setDischargeIcdCodes(new java.util.TreeSet<jkt.hms.masters.business.DischargeIcdCode>());
		getDischargeIcdCodes().add(dischargeIcdCode);
	}



	/**
	 * Return the value associated with the column: ObgDetails
	 */
	public java.util.Set<jkt.hms.masters.business.ObgDetails> getObgDetails () {
		return obgDetails;
	}

	/**
	 * Set the value related to the column: ObgDetails
	 * @param obgDetails the ObgDetails value
	 */
	public void setObgDetails (java.util.Set<jkt.hms.masters.business.ObgDetails> obgDetails) {
		this.obgDetails = obgDetails;
	}

	public void addToObgDetails (jkt.hms.masters.business.ObgDetails obgDetails) {
		if (null == getObgDetails()) setObgDetails(new java.util.TreeSet<jkt.hms.masters.business.ObgDetails>());
		getObgDetails().add(obgDetails);
	}



	/**
	 * Return the value associated with the column: Visits
	 */
	public java.util.Set<jkt.hms.masters.business.Visit> getVisits () {
		return visits;
	}

	/**
	 * Set the value related to the column: Visits
	 * @param visits the Visits value
	 */
	public void setVisits (java.util.Set<jkt.hms.masters.business.Visit> visits) {
		this.visits = visits;
	}

	public void addToVisits (jkt.hms.masters.business.Visit visit) {
		if (null == getVisits()) setVisits(new java.util.TreeSet<jkt.hms.masters.business.Visit>());
		getVisits().add(visit);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OpdPatientDetails)) return false;
		else {
			jkt.hms.masters.business.OpdPatientDetails opdPatientDetails = (jkt.hms.masters.business.OpdPatientDetails) obj;
			if (null == this.getId() || null == opdPatientDetails.getId()) return false;
			else return (this.getId().equals(opdPatientDetails.getId()));
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
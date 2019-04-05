package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the FEEDBACK_OF_COUNSELOR table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="FEEDBACK_OF_COUNSELOR"
 */

public abstract class BaseFeedbackOfCounselor  implements Serializable {

	public static String REF = "FeedbackOfCounselor";
	public static String PROP_PH_NO = "PhNo";
	public static String PROP_QUALIFICATION = "Qualification";
	public static String PROP_SERVICE_RELATED_ISSUE = "ServiceRelatedIssue";
	public static String PROP_ANALYSIS_OF_PSYCHOLOGICAL = "AnalysisOfPsychological";
	public static String PROP_REMARKS = "REMARKS";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_DOMESTIC_PROBLEMS = "DomesticProblems";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_OTHER_SPECIFY = "OtherSpecify";
	public static String PROP_COUNSELING_AFTER_WORKING = "CounselingAfterWorking";
	public static String PROP_SIGNATURE = "Signature";
	public static String PROP_NAME_OF_COUNSELOR = "NameOfCounselor";
	public static String PROP_INTER_PERSONAL_PROBLEM = "InterPersonalProblem";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_EDUCATIONAL_ISSUE = "EducationalIssue";
	public static String PROP_SMOREMARKS = "SMOREMARKS";
	public static String PROP_DEPARTMENT_ID = "DepartmentId";
	public static String PROP_NO_OF_CASES_PER_MONTH = "NoOfCasesPerMonth";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_NO_LECTURE_PERSONEL = "NoLecturePersonel";
	public static String PROP_HONORARIUM_PER_MONTH = "HonorariumPerMonth";
	public static String PROP_ADMINISTRATIVE_ACTIONS = "AdministrativeActions";
	public static String PROP_ALCOHOL_DEPENDENCE = "AlcoholDependence";
	public static String PROP_HOURS_OF_WORKS = "HoursOfWorks";
	public static String PROP_EMPLOYMENT_COUNSELOR_BENF = "EmploymentCounselorBenf";
	public static String PROP_MO_STATUS = "MoStatus";
	public static String PROP_AVG_NO_PERSON_COUNSELED = "AvgNoPersonCounseled";
	public static String PROP_FINANCIAL_ISSUE = "FinancialIssue";
	public static String PROP_COUNSELING_AFTER_WORKING_HOUR = "CounselingAfterWorkingHour";
	public static String PROP_NO_OF_VISIT_PER_WEEK = "NoOfVisitPerWeek";
	public static String PROP_PLACE_OF_COUNSELING = "PlaceOfCounseling";
	public static String PROP_CASES_COUNSELED = "CasesCounseled";
	public static String PROP_EMPLOYED_DATE = "EmployedDate";
	public static String PROP_ID = "Id";
	public static String PROP_TYPE_CASES_COUNSELED = "TypeCasesCounseled";
	public static String PROP_FOR_WARDED_TO = "ForWardedTo";
	public static String PROP_PROBLEM_FACED = "ProblemFaced";


	// constructors
	public BaseFeedbackOfCounselor () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFeedbackOfCounselor (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String nameOfCounselor;
	private java.lang.String qualification;
	private java.lang.String honorariumPerMonth;
	private java.lang.String noOfVisitPerWeek;
	private java.util.Date employedDate;
	private java.lang.String hoursOfWorks;
	private java.lang.String placeOfCounseling;
	private java.lang.String avgNoPersonCounseled;
	private java.lang.String typeCasesCounseled;
	private java.lang.String noLecturePersonel;
	private java.lang.String counselingAfterWorking;
	private java.lang.String alcoholDependence;
	private java.lang.String casesCounseled;
	private java.lang.String administrativeActions;
	private java.lang.String employmentCounselorBenf;
	private java.lang.String problemFaced;
	private java.lang.String analysisOfPsychological;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String moStatus;
	private java.lang.String rEMARKS;
	private java.lang.String sMOREMARKS;
	private java.lang.String domesticProblems;
	private java.lang.String educationalIssue;
	private java.lang.String financialIssue;
	private java.lang.String interPersonalProblem;
	private java.lang.String serviceRelatedIssue;
	private java.lang.String otherSpecify;
	private java.lang.String counselingAfterWorkingHour;
	private java.lang.String noOfCasesPerMonth;
	private java.lang.String phNo;
	private java.lang.String signature;

	// many to one
	private jkt.hms.masters.business.MasEmployee forWardedTo;
	private jkt.hms.masters.business.MasDepartment departmentId;
	private jkt.hms.masters.business.MasHospital hospitalId;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
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
	 * Return the value associated with the column: NAME_OF_COUNSELOR
	 */
	public java.lang.String getNameOfCounselor () {
		return nameOfCounselor;
	}

	/**
	 * Set the value related to the column: NAME_OF_COUNSELOR
	 * @param nameOfCounselor the NAME_OF_COUNSELOR value
	 */
	public void setNameOfCounselor (java.lang.String nameOfCounselor) {
		this.nameOfCounselor = nameOfCounselor;
	}



	/**
	 * Return the value associated with the column: QUALIFICATION
	 */
	public java.lang.String getQualification () {
		return qualification;
	}

	/**
	 * Set the value related to the column: QUALIFICATION
	 * @param qualification the QUALIFICATION value
	 */
	public void setQualification (java.lang.String qualification) {
		this.qualification = qualification;
	}



	/**
	 * Return the value associated with the column: HONORARIUM_PER_MONTH
	 */
	public java.lang.String getHonorariumPerMonth () {
		return honorariumPerMonth;
	}

	/**
	 * Set the value related to the column: HONORARIUM_PER_MONTH
	 * @param honorariumPerMonth the HONORARIUM_PER_MONTH value
	 */
	public void setHonorariumPerMonth (java.lang.String honorariumPerMonth) {
		this.honorariumPerMonth = honorariumPerMonth;
	}



	/**
	 * Return the value associated with the column: NO_OF_VISIT_PER_WEEK
	 */
	public java.lang.String getNoOfVisitPerWeek () {
		return noOfVisitPerWeek;
	}

	/**
	 * Set the value related to the column: NO_OF_VISIT_PER_WEEK
	 * @param noOfVisitPerWeek the NO_OF_VISIT_PER_WEEK value
	 */
	public void setNoOfVisitPerWeek (java.lang.String noOfVisitPerWeek) {
		this.noOfVisitPerWeek = noOfVisitPerWeek;
	}



	/**
	 * Return the value associated with the column: EMPLOYED_DATE
	 */
	public java.util.Date getEmployedDate () {
		return employedDate;
	}

	/**
	 * Set the value related to the column: EMPLOYED_DATE
	 * @param employedDate the EMPLOYED_DATE value
	 */
	public void setEmployedDate (java.util.Date employedDate) {
		this.employedDate = employedDate;
	}



	/**
	 * Return the value associated with the column: HOURS_OF_WORKS
	 */
	public java.lang.String getHoursOfWorks () {
		return hoursOfWorks;
	}

	/**
	 * Set the value related to the column: HOURS_OF_WORKS
	 * @param hoursOfWorks the HOURS_OF_WORKS value
	 */
	public void setHoursOfWorks (java.lang.String hoursOfWorks) {
		this.hoursOfWorks = hoursOfWorks;
	}



	/**
	 * Return the value associated with the column: PLACE_OF_COUNSELING
	 */
	public java.lang.String getPlaceOfCounseling () {
		return placeOfCounseling;
	}

	/**
	 * Set the value related to the column: PLACE_OF_COUNSELING
	 * @param placeOfCounseling the PLACE_OF_COUNSELING value
	 */
	public void setPlaceOfCounseling (java.lang.String placeOfCounseling) {
		this.placeOfCounseling = placeOfCounseling;
	}



	/**
	 * Return the value associated with the column: AVG_NO_PERSON_COUNSELED
	 */
	public java.lang.String getAvgNoPersonCounseled () {
		return avgNoPersonCounseled;
	}

	/**
	 * Set the value related to the column: AVG_NO_PERSON_COUNSELED
	 * @param avgNoPersonCounseled the AVG_NO_PERSON_COUNSELED value
	 */
	public void setAvgNoPersonCounseled (java.lang.String avgNoPersonCounseled) {
		this.avgNoPersonCounseled = avgNoPersonCounseled;
	}



	/**
	 * Return the value associated with the column: TYPE_CASES_COUNSELED
	 */
	public java.lang.String getTypeCasesCounseled () {
		return typeCasesCounseled;
	}

	/**
	 * Set the value related to the column: TYPE_CASES_COUNSELED
	 * @param typeCasesCounseled the TYPE_CASES_COUNSELED value
	 */
	public void setTypeCasesCounseled (java.lang.String typeCasesCounseled) {
		this.typeCasesCounseled = typeCasesCounseled;
	}



	/**
	 * Return the value associated with the column: NO_LECTURE_PERSONEL
	 */
	public java.lang.String getNoLecturePersonel () {
		return noLecturePersonel;
	}

	/**
	 * Set the value related to the column: NO_LECTURE_PERSONEL
	 * @param noLecturePersonel the NO_LECTURE_PERSONEL value
	 */
	public void setNoLecturePersonel (java.lang.String noLecturePersonel) {
		this.noLecturePersonel = noLecturePersonel;
	}



	/**
	 * Return the value associated with the column: COUNSELING_AFTER_WORKING
	 */
	public java.lang.String getCounselingAfterWorking () {
		return counselingAfterWorking;
	}

	/**
	 * Set the value related to the column: COUNSELING_AFTER_WORKING
	 * @param counselingAfterWorking the COUNSELING_AFTER_WORKING value
	 */
	public void setCounselingAfterWorking (java.lang.String counselingAfterWorking) {
		this.counselingAfterWorking = counselingAfterWorking;
	}



	/**
	 * Return the value associated with the column: ALCOHOL_DEPENDENCE
	 */
	public java.lang.String getAlcoholDependence () {
		return alcoholDependence;
	}

	/**
	 * Set the value related to the column: ALCOHOL_DEPENDENCE
	 * @param alcoholDependence the ALCOHOL_DEPENDENCE value
	 */
	public void setAlcoholDependence (java.lang.String alcoholDependence) {
		this.alcoholDependence = alcoholDependence;
	}



	/**
	 * Return the value associated with the column: CASES_COUNSELED
	 */
	public java.lang.String getCasesCounseled () {
		return casesCounseled;
	}

	/**
	 * Set the value related to the column: CASES_COUNSELED
	 * @param casesCounseled the CASES_COUNSELED value
	 */
	public void setCasesCounseled (java.lang.String casesCounseled) {
		this.casesCounseled = casesCounseled;
	}



	/**
	 * Return the value associated with the column: ADMINISTRATIVE_ACTIONS
	 */
	public java.lang.String getAdministrativeActions () {
		return administrativeActions;
	}

	/**
	 * Set the value related to the column: ADMINISTRATIVE_ACTIONS
	 * @param administrativeActions the ADMINISTRATIVE_ACTIONS value
	 */
	public void setAdministrativeActions (java.lang.String administrativeActions) {
		this.administrativeActions = administrativeActions;
	}



	/**
	 * Return the value associated with the column: EMPLOYMENT_COUNSELOR_BENF
	 */
	public java.lang.String getEmploymentCounselorBenf () {
		return employmentCounselorBenf;
	}

	/**
	 * Set the value related to the column: EMPLOYMENT_COUNSELOR_BENF
	 * @param employmentCounselorBenf the EMPLOYMENT_COUNSELOR_BENF value
	 */
	public void setEmploymentCounselorBenf (java.lang.String employmentCounselorBenf) {
		this.employmentCounselorBenf = employmentCounselorBenf;
	}



	/**
	 * Return the value associated with the column: PROBLEM_FACED
	 */
	public java.lang.String getProblemFaced () {
		return problemFaced;
	}

	/**
	 * Set the value related to the column: PROBLEM_FACED
	 * @param problemFaced the PROBLEM_FACED value
	 */
	public void setProblemFaced (java.lang.String problemFaced) {
		this.problemFaced = problemFaced;
	}



	/**
	 * Return the value associated with the column: ANALYSIS_OF_PSYCHOLOGICAL
	 */
	public java.lang.String getAnalysisOfPsychological () {
		return analysisOfPsychological;
	}

	/**
	 * Set the value related to the column: ANALYSIS_OF_PSYCHOLOGICAL
	 * @param analysisOfPsychological the ANALYSIS_OF_PSYCHOLOGICAL value
	 */
	public void setAnalysisOfPsychological (java.lang.String analysisOfPsychological) {
		this.analysisOfPsychological = analysisOfPsychological;
	}



	/**
	 * Return the value associated with the column: change_by
	 */
	public java.lang.String getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: change_by
	 * @param lastChgBy the change_by value
	 */
	public void setLastChgBy (java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
	}



	/**
	 * Return the value associated with the column: change_date
	 */
	public java.util.Date getLastChgDate () {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: change_date
	 * @param lastChgDate the change_date value
	 */
	public void setLastChgDate (java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}



	/**
	 * Return the value associated with the column: change_time
	 */
	public java.lang.String getLastChgTime () {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: change_time
	 * @param lastChgTime the change_time value
	 */
	public void setLastChgTime (java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}



	/**
	 * Return the value associated with the column: MO_STATUS
	 */
	public java.lang.String getMoStatus () {
		return moStatus;
	}

	/**
	 * Set the value related to the column: MO_STATUS
	 * @param moStatus the MO_STATUS value
	 */
	public void setMoStatus (java.lang.String moStatus) {
		this.moStatus = moStatus;
	}



	/**
	 * Return the value associated with the column: REMARKS
	 */
	public java.lang.String getREMARKS () {
		return rEMARKS;
	}

	/**
	 * Set the value related to the column: REMARKS
	 * @param rEMARKS the REMARKS value
	 */
	public void setREMARKS (java.lang.String rEMARKS) {
		this.rEMARKS = rEMARKS;
	}



	/**
	 * Return the value associated with the column: SMO_REMARKS
	 */
	public java.lang.String getSMOREMARKS () {
		return sMOREMARKS;
	}

	/**
	 * Set the value related to the column: SMO_REMARKS
	 * @param sMOREMARKS the SMO_REMARKS value
	 */
	public void setSMOREMARKS (java.lang.String sMOREMARKS) {
		this.sMOREMARKS = sMOREMARKS;
	}



	/**
	 * Return the value associated with the column: DOMESTIC_PROBLEMS
	 */
	public java.lang.String getDomesticProblems () {
		return domesticProblems;
	}

	/**
	 * Set the value related to the column: DOMESTIC_PROBLEMS
	 * @param domesticProblems the DOMESTIC_PROBLEMS value
	 */
	public void setDomesticProblems (java.lang.String domesticProblems) {
		this.domesticProblems = domesticProblems;
	}



	/**
	 * Return the value associated with the column: EDUCATIONAL_ISSUE
	 */
	public java.lang.String getEducationalIssue () {
		return educationalIssue;
	}

	/**
	 * Set the value related to the column: EDUCATIONAL_ISSUE
	 * @param educationalIssue the EDUCATIONAL_ISSUE value
	 */
	public void setEducationalIssue (java.lang.String educationalIssue) {
		this.educationalIssue = educationalIssue;
	}



	/**
	 * Return the value associated with the column: FINANCIAL_ISSUE
	 */
	public java.lang.String getFinancialIssue () {
		return financialIssue;
	}

	/**
	 * Set the value related to the column: FINANCIAL_ISSUE
	 * @param financialIssue the FINANCIAL_ISSUE value
	 */
	public void setFinancialIssue (java.lang.String financialIssue) {
		this.financialIssue = financialIssue;
	}



	/**
	 * Return the value associated with the column: INTER_PERSONAL_PROBLEM
	 */
	public java.lang.String getInterPersonalProblem () {
		return interPersonalProblem;
	}

	/**
	 * Set the value related to the column: INTER_PERSONAL_PROBLEM
	 * @param interPersonalProblem the INTER_PERSONAL_PROBLEM value
	 */
	public void setInterPersonalProblem (java.lang.String interPersonalProblem) {
		this.interPersonalProblem = interPersonalProblem;
	}



	/**
	 * Return the value associated with the column: SERVICE_RELATED_ISSUE
	 */
	public java.lang.String getServiceRelatedIssue () {
		return serviceRelatedIssue;
	}

	/**
	 * Set the value related to the column: SERVICE_RELATED_ISSUE
	 * @param serviceRelatedIssue the SERVICE_RELATED_ISSUE value
	 */
	public void setServiceRelatedIssue (java.lang.String serviceRelatedIssue) {
		this.serviceRelatedIssue = serviceRelatedIssue;
	}



	/**
	 * Return the value associated with the column: OTHER_SPECIFY
	 */
	public java.lang.String getOtherSpecify () {
		return otherSpecify;
	}

	/**
	 * Set the value related to the column: OTHER_SPECIFY
	 * @param otherSpecify the OTHER_SPECIFY value
	 */
	public void setOtherSpecify (java.lang.String otherSpecify) {
		this.otherSpecify = otherSpecify;
	}



	/**
	 * Return the value associated with the column: COUNSELING_AFTER_WORKING_HOUR
	 */
	public java.lang.String getCounselingAfterWorkingHour () {
		return counselingAfterWorkingHour;
	}

	/**
	 * Set the value related to the column: COUNSELING_AFTER_WORKING_HOUR
	 * @param counselingAfterWorkingHour the COUNSELING_AFTER_WORKING_HOUR value
	 */
	public void setCounselingAfterWorkingHour (java.lang.String counselingAfterWorkingHour) {
		this.counselingAfterWorkingHour = counselingAfterWorkingHour;
	}



	/**
	 * Return the value associated with the column: NO_OF_CASES_PER_MONTH
	 */
	public java.lang.String getNoOfCasesPerMonth () {
		return noOfCasesPerMonth;
	}

	/**
	 * Set the value related to the column: NO_OF_CASES_PER_MONTH
	 * @param noOfCasesPerMonth the NO_OF_CASES_PER_MONTH value
	 */
	public void setNoOfCasesPerMonth (java.lang.String noOfCasesPerMonth) {
		this.noOfCasesPerMonth = noOfCasesPerMonth;
	}



	/**
	 * Return the value associated with the column: PH_NO_AFTER_WORKING_HOUR
	 */
	public java.lang.String getPhNo () {
		return phNo;
	}

	/**
	 * Set the value related to the column: PH_NO_AFTER_WORKING_HOUR
	 * @param phNo the PH_NO_AFTER_WORKING_HOUR value
	 */
	public void setPhNo (java.lang.String phNo) {
		this.phNo = phNo;
	}



	/**
	 * Return the value associated with the column: SIGNATURE
	 */
	public java.lang.String getSignature () {
		return signature;
	}

	/**
	 * Set the value related to the column: SIGNATURE
	 * @param signature the SIGNATURE value
	 */
	public void setSignature (java.lang.String signature) {
		this.signature = signature;
	}



	/**
	 * Return the value associated with the column: FOWARD_TO
	 */
	public jkt.hms.masters.business.MasEmployee getForWardedTo () {
		return forWardedTo;
	}

	/**
	 * Set the value related to the column: FOWARD_TO
	 * @param forWardedTo the FOWARD_TO value
	 */
	public void setForWardedTo (jkt.hms.masters.business.MasEmployee forWardedTo) {
		this.forWardedTo = forWardedTo;
	}



	/**
	 * Return the value associated with the column: DEPARTMENT_ID
	 */
	public jkt.hms.masters.business.MasDepartment getDepartmentId () {
		return departmentId;
	}

	/**
	 * Set the value related to the column: DEPARTMENT_ID
	 * @param departmentId the DEPARTMENT_ID value
	 */
	public void setDepartmentId (jkt.hms.masters.business.MasDepartment departmentId) {
		this.departmentId = departmentId;
	}



	/**
	 * Return the value associated with the column: HOSPITAL_ID
	 */
	public jkt.hms.masters.business.MasHospital getHospitalId () {
		return hospitalId;
	}

	/**
	 * Set the value related to the column: HOSPITAL_ID
	 * @param hospitalId the HOSPITAL_ID value
	 */
	public void setHospitalId (jkt.hms.masters.business.MasHospital hospitalId) {
		this.hospitalId = hospitalId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.FeedbackOfCounselor)) return false;
		else {
			jkt.hms.masters.business.FeedbackOfCounselor feedbackOfCounselor = (jkt.hms.masters.business.FeedbackOfCounselor) obj;
			if (null == this.getId() || null == feedbackOfCounselor.getId()) return false;
			else return (this.getId().equals(feedbackOfCounselor.getId()));
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
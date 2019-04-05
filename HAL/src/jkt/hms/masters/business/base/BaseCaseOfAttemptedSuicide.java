package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the CASE_OF_ATTEMPTED_SUICIDE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="CASE_OF_ATTEMPTED_SUICIDE"
 */

public abstract class BaseCaseOfAttemptedSuicide  implements Serializable {

	public static String REF = "CaseOfAttemptedSuicide";
	public static String PROP_SECOND_INDIVIDUAL = "SecondIndividual";
	public static String PROP_RESPONSE_PERSON = "ResponsePerson";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_AFWWA_COUNSELLED = "AfwwaCounselled";
	public static String PROP_REFERRAL_PSYCHIATRIST = "ReferralPsychiatrist";
	public static String PROP_THIRD_INDIVIDUAL = "ThirdIndividual";
	public static String PROP_PREVIOUS_ATTEMPT_HISTORY = "PreviousAttemptHistory";
	public static String PROP_INDIVIDUAL_PROPOSE_DEAL_PROB = "IndividualProposeDealProb";
	public static String PROP_ENUMERATE_ACTION_TAK_SUICIDE = "EnumerateActionTakSuicide";
	public static String PROP_DATE_OF_ATTEMPTED = "DateOfAttempted";
	public static String PROP_DATE_OF_DEATH = "DateOfDeath";
	public static String PROP_RESPONSE_PERSON_YES = "ResponsePersonYes";
	public static String PROP_PRE_EVENT_SOCIAL_BEHAVIOUR = "PreEventSocialBehaviour";
	public static String PROP_STATE_OUTCOME_CASE = "StateOutcomeCase";
	public static String PROP_SECOND_FAMILY = "SecondFamily";
	public static String PROP_DEPARTMENT_ID = "DepartmentId";
	public static String PROP_FIRST_INDIVIDUAL = "FirstIndividual";
	public static String PROP_RELEVANT_DETAILS_ATTEMPT_INFO = "RelevantDetailsAttemptInfo";
	public static String PROP_HIN_ID = "HinId";
	public static String PROP_PRESENCE_SIGNOF_DEPRESSION = "PresenceSignofDepression";
	public static String PROP_PERSONALITY_INDIV_ASSESS_MO = "PersonalityIndivAssessMo";
	public static String PROP_REASON = "Reason";
	public static String PROP_WEATHER_INDIVIDUAL_COUNSELLED = "WeatherIndividualCounselled";
	public static String PROP_DURATION_SECOND_PROB_INDV = "DurationSecondProbIndv";
	public static String PROP_RESULT_COUNSELLING_PERSON = "ResultCounsellingPerson";
	public static String PROP_FIRST_FAMILY = "FirstFamily";
	public static String PROP_INFO_FAMILY_NEIGHBOUR_COLLEAG = "InfoFamilyNeighbourColleag";
	public static String PROP_YES_BY_WHOM = "YesByWhom";
	public static String PROP_MARRIED_WEATHER_FAMILY_COUN = "MarriedWeatherFamilyCoun";
	public static String PROP_TIME_OF_ATTEMPTED = "TimeOfAttempted";
	public static String PROP_BACHELOR_INFORMATED_ATTEMPT = "BachelorInformatedAttempt";
	public static String PROP_THIRD_FAMILY = "ThirdFamily";
	public static String PROP_CO_UNIT_INFORM_EFFECTIVE_MONIT = "CoUnitInformEffectiveMonit";
	public static String PROP_ID = "Id";
	public static String PROP_HISTORY_PROBLEM = "HistoryProblem";
	public static String PROP_DURATION_FIRST_PROB_INDV = "DurationFirstProbIndv";


	// constructors
	public BaseCaseOfAttemptedSuicide () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCaseOfAttemptedSuicide (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date dateOfAttempted;
	private java.util.Date dateOfDeath;
	private java.lang.String timeOfAttempted;
	private java.lang.String previousAttemptHistory;
	private java.lang.String relevantDetailsAttemptInfo;
	private java.lang.String infoFamilyNeighbourColleag;
	private java.lang.String firstIndividual;
	private java.lang.String secondIndividual;
	private java.lang.String thirdIndividual;
	private java.lang.String firstFamily;
	private java.lang.String secondFamily;
	private java.lang.String thirdFamily;
	private java.lang.String historyProblem;
	private java.lang.String durationFirstProbIndv;
	private java.lang.String durationSecondProbIndv;
	private java.lang.String reason;
	private java.lang.String responsePerson;
	private java.lang.String responsePersonYes;
	private java.lang.String individualProposeDealProb;
	private java.lang.String weatherIndividualCounselled;
	private java.lang.String yesByWhom;
	private java.lang.String resultCounsellingPerson;
	private java.lang.String coUnitInformEffectiveMonit;
	private java.lang.String marriedWeatherFamilyCoun;
	private java.lang.String afwwaCounselled;
	private java.lang.String bachelorInformatedAttempt;
	private java.lang.String preEventSocialBehaviour;
	private java.lang.String personalityIndivAssessMo;
	private java.lang.String presenceSignofDepression;
	private java.lang.String referralPsychiatrist;
	private java.lang.String stateOutcomeCase;
	private java.lang.String enumerateActionTakSuicide;

	// many to one
	private jkt.hms.masters.business.MasDepartment departmentId;
	private jkt.hms.masters.business.MasHospital hospitalId;
	private jkt.hms.masters.business.Patient hinId;



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
	 * Return the value associated with the column: DATE_OF_ATTEMPTED
	 */
	public java.util.Date getDateOfAttempted () {
		return dateOfAttempted;
	}
	
	


	/**
	 * Set the value related to the column: DATE_OF_ATTEMPTED
	 * @param dateOfAttempted the DATE_OF_ATTEMPTED value
	 */
	public void setDateOfAttempted (java.util.Date dateOfAttempted) {
		this.dateOfAttempted = dateOfAttempted;
	}

	
	public java.util.Date getDateOfDeath () {
		return dateOfDeath;
	}
	
	
	
	public void setDateOfDeath (java.util.Date dateOfDeath) {
		this.dateOfDeath = dateOfDeath;
	}

	/**
	 * Return the value associated with the column: TIME_OF_ATTEMPTED
	 */
	public java.lang.String getTimeOfAttempted () {
		return timeOfAttempted;
	}

	/**
	 * Set the value related to the column: TIME_OF_ATTEMPTED
	 * @param timeOfAttempted the TIME_OF_ATTEMPTED value
	 */
	public void setTimeOfAttempted (java.lang.String timeOfAttempted) {
		this.timeOfAttempted = timeOfAttempted;
	}



	/**
	 * Return the value associated with the column: PREVIOUS_ATTEMPT_HISTORY
	 */
	public java.lang.String getPreviousAttemptHistory () {
		return previousAttemptHistory;
	}

	/**
	 * Set the value related to the column: PREVIOUS_ATTEMPT_HISTORY
	 * @param previousAttemptHistory the PREVIOUS_ATTEMPT_HISTORY value
	 */
	public void setPreviousAttemptHistory (java.lang.String previousAttemptHistory) {
		this.previousAttemptHistory = previousAttemptHistory;
	}



	/**
	 * Return the value associated with the column: RELEVANT_DETAILS_ATTEMPT_INFO
	 */
	public java.lang.String getRelevantDetailsAttemptInfo () {
		return relevantDetailsAttemptInfo;
	}

	/**
	 * Set the value related to the column: RELEVANT_DETAILS_ATTEMPT_INFO
	 * @param relevantDetailsAttemptInfo the RELEVANT_DETAILS_ATTEMPT_INFO value
	 */
	public void setRelevantDetailsAttemptInfo (java.lang.String relevantDetailsAttemptInfo) {
		this.relevantDetailsAttemptInfo = relevantDetailsAttemptInfo;
	}



	/**
	 * Return the value associated with the column: INFO_FAMILY_NEIGHBOUR_COLLEAG
	 */
	public java.lang.String getInfoFamilyNeighbourColleag () {
		return infoFamilyNeighbourColleag;
	}

	/**
	 * Set the value related to the column: INFO_FAMILY_NEIGHBOUR_COLLEAG
	 * @param infoFamilyNeighbourColleag the INFO_FAMILY_NEIGHBOUR_COLLEAG value
	 */
	public void setInfoFamilyNeighbourColleag (java.lang.String infoFamilyNeighbourColleag) {
		this.infoFamilyNeighbourColleag = infoFamilyNeighbourColleag;
	}



	/**
	 * Return the value associated with the column: FIRST_INDIVIDUAL
	 */
	public java.lang.String getFirstIndividual () {
		return firstIndividual;
	}

	/**
	 * Set the value related to the column: FIRST_INDIVIDUAL
	 * @param firstIndividual the FIRST_INDIVIDUAL value
	 */
	public void setFirstIndividual (java.lang.String firstIndividual) {
		this.firstIndividual = firstIndividual;
	}



	/**
	 * Return the value associated with the column: SECOND_INDIVIDUAL
	 */
	public java.lang.String getSecondIndividual () {
		return secondIndividual;
	}

	/**
	 * Set the value related to the column: SECOND_INDIVIDUAL
	 * @param secondIndividual the SECOND_INDIVIDUAL value
	 */
	public void setSecondIndividual (java.lang.String secondIndividual) {
		this.secondIndividual = secondIndividual;
	}



	/**
	 * Return the value associated with the column: THIRD_INDIVIDUAL
	 */
	public java.lang.String getThirdIndividual () {
		return thirdIndividual;
	}

	/**
	 * Set the value related to the column: THIRD_INDIVIDUAL
	 * @param thirdIndividual the THIRD_INDIVIDUAL value
	 */
	public void setThirdIndividual (java.lang.String thirdIndividual) {
		this.thirdIndividual = thirdIndividual;
	}



	/**
	 * Return the value associated with the column: FIRST_FAMILY
	 */
	public java.lang.String getFirstFamily () {
		return firstFamily;
	}

	/**
	 * Set the value related to the column: FIRST_FAMILY
	 * @param firstFamily the FIRST_FAMILY value
	 */
	public void setFirstFamily (java.lang.String firstFamily) {
		this.firstFamily = firstFamily;
	}



	/**
	 * Return the value associated with the column: SECOND_FAMILY
	 */
	public java.lang.String getSecondFamily () {
		return secondFamily;
	}

	/**
	 * Set the value related to the column: SECOND_FAMILY
	 * @param secondFamily the SECOND_FAMILY value
	 */
	public void setSecondFamily (java.lang.String secondFamily) {
		this.secondFamily = secondFamily;
	}



	/**
	 * Return the value associated with the column: THIRD_FAMILY
	 */
	public java.lang.String getThirdFamily () {
		return thirdFamily;
	}

	/**
	 * Set the value related to the column: THIRD_FAMILY
	 * @param thirdFamily the THIRD_FAMILY value
	 */
	public void setThirdFamily (java.lang.String thirdFamily) {
		this.thirdFamily = thirdFamily;
	}



	/**
	 * Return the value associated with the column: HISTORY_PROBLEM
	 */
	public java.lang.String getHistoryProblem () {
		return historyProblem;
	}

	/**
	 * Set the value related to the column: HISTORY_PROBLEM
	 * @param historyProblem the HISTORY_PROBLEM value
	 */
	public void setHistoryProblem (java.lang.String historyProblem) {
		this.historyProblem = historyProblem;
	}



	/**
	 * Return the value associated with the column: DURATION_FIRST_PROB_INDV
	 */
	public java.lang.String getDurationFirstProbIndv () {
		return durationFirstProbIndv;
	}

	/**
	 * Set the value related to the column: DURATION_FIRST_PROB_INDV
	 * @param durationFirstProbIndv the DURATION_FIRST_PROB_INDV value
	 */
	public void setDurationFirstProbIndv (java.lang.String durationFirstProbIndv) {
		this.durationFirstProbIndv = durationFirstProbIndv;
	}



	/**
	 * Return the value associated with the column: DURATION_SECOND_PROB_INDV
	 */
	public java.lang.String getDurationSecondProbIndv () {
		return durationSecondProbIndv;
	}

	/**
	 * Set the value related to the column: DURATION_SECOND_PROB_INDV
	 * @param durationSecondProbIndv the DURATION_SECOND_PROB_INDV value
	 */
	public void setDurationSecondProbIndv (java.lang.String durationSecondProbIndv) {
		this.durationSecondProbIndv = durationSecondProbIndv;
	}



	/**
	 * Return the value associated with the column: REASON
	 */
	public java.lang.String getReason () {
		return reason;
	}

	/**
	 * Set the value related to the column: REASON
	 * @param reason the REASON value
	 */
	public void setReason (java.lang.String reason) {
		this.reason = reason;
	}



	/**
	 * Return the value associated with the column: RESPONSE_PERSON
	 */
	public java.lang.String getResponsePerson () {
		return responsePerson;
	}

	/**
	 * Set the value related to the column: RESPONSE_PERSON
	 * @param responsePerson the RESPONSE_PERSON value
	 */
	public void setResponsePerson (java.lang.String responsePerson) {
		this.responsePerson = responsePerson;
	}



	/**
	 * Return the value associated with the column: RESPONSE_PERSON_YES
	 */
	public java.lang.String getResponsePersonYes () {
		return responsePersonYes;
	}

	/**
	 * Set the value related to the column: RESPONSE_PERSON_YES
	 * @param responsePersonYes the RESPONSE_PERSON_YES value
	 */
	public void setResponsePersonYes (java.lang.String responsePersonYes) {
		this.responsePersonYes = responsePersonYes;
	}



	/**
	 * Return the value associated with the column: INDIVIDUAL_PROPOSE_DEAL_PROB
	 */
	public java.lang.String getIndividualProposeDealProb () {
		return individualProposeDealProb;
	}

	/**
	 * Set the value related to the column: INDIVIDUAL_PROPOSE_DEAL_PROB
	 * @param individualProposeDealProb the INDIVIDUAL_PROPOSE_DEAL_PROB value
	 */
	public void setIndividualProposeDealProb (java.lang.String individualProposeDealProb) {
		this.individualProposeDealProb = individualProposeDealProb;
	}



	/**
	 * Return the value associated with the column: WEATHER_INDIVIDUAL_COUNSELLED
	 */
	public java.lang.String getWeatherIndividualCounselled () {
		return weatherIndividualCounselled;
	}

	/**
	 * Set the value related to the column: WEATHER_INDIVIDUAL_COUNSELLED
	 * @param weatherIndividualCounselled the WEATHER_INDIVIDUAL_COUNSELLED value
	 */
	public void setWeatherIndividualCounselled (java.lang.String weatherIndividualCounselled) {
		this.weatherIndividualCounselled = weatherIndividualCounselled;
	}



	/**
	 * Return the value associated with the column: YES_BY_WHOM
	 */
	public java.lang.String getYesByWhom () {
		return yesByWhom;
	}

	/**
	 * Set the value related to the column: YES_BY_WHOM
	 * @param yesByWhom the YES_BY_WHOM value
	 */
	public void setYesByWhom (java.lang.String yesByWhom) {
		this.yesByWhom = yesByWhom;
	}



	/**
	 * Return the value associated with the column: RESULT_COUNSELLING_PERSON
	 */
	public java.lang.String getResultCounsellingPerson () {
		return resultCounsellingPerson;
	}

	/**
	 * Set the value related to the column: RESULT_COUNSELLING_PERSON
	 * @param resultCounsellingPerson the RESULT_COUNSELLING_PERSON value
	 */
	public void setResultCounsellingPerson (java.lang.String resultCounsellingPerson) {
		this.resultCounsellingPerson = resultCounsellingPerson;
	}



	/**
	 * Return the value associated with the column: CO_UNIT_INFORM_EFFECTIVE_MONIT
	 */
	public java.lang.String getCoUnitInformEffectiveMonit () {
		return coUnitInformEffectiveMonit;
	}

	/**
	 * Set the value related to the column: CO_UNIT_INFORM_EFFECTIVE_MONIT
	 * @param coUnitInformEffectiveMonit the CO_UNIT_INFORM_EFFECTIVE_MONIT value
	 */
	public void setCoUnitInformEffectiveMonit (java.lang.String coUnitInformEffectiveMonit) {
		this.coUnitInformEffectiveMonit = coUnitInformEffectiveMonit;
	}



	/**
	 * Return the value associated with the column: MARRIED_WEATHER_FAMILY_COUN
	 */
	public java.lang.String getMarriedWeatherFamilyCoun () {
		return marriedWeatherFamilyCoun;
	}

	/**
	 * Set the value related to the column: MARRIED_WEATHER_FAMILY_COUN
	 * @param marriedWeatherFamilyCoun the MARRIED_WEATHER_FAMILY_COUN value
	 */
	public void setMarriedWeatherFamilyCoun (java.lang.String marriedWeatherFamilyCoun) {
		this.marriedWeatherFamilyCoun = marriedWeatherFamilyCoun;
	}



	/**
	 * Return the value associated with the column: AFWWA_COUNSELLED
	 */
	public java.lang.String getAfwwaCounselled () {
		return afwwaCounselled;
	}

	/**
	 * Set the value related to the column: AFWWA_COUNSELLED
	 * @param afwwaCounselled the AFWWA_COUNSELLED value
	 */
	public void setAfwwaCounselled (java.lang.String afwwaCounselled) {
		this.afwwaCounselled = afwwaCounselled;
	}



	/**
	 * Return the value associated with the column: BACHELOR_INFORMATED_ATTEMPT
	 */
	public java.lang.String getBachelorInformatedAttempt () {
		return bachelorInformatedAttempt;
	}

	/**
	 * Set the value related to the column: BACHELOR_INFORMATED_ATTEMPT
	 * @param bachelorInformatedAttempt the BACHELOR_INFORMATED_ATTEMPT value
	 */
	public void setBachelorInformatedAttempt (java.lang.String bachelorInformatedAttempt) {
		this.bachelorInformatedAttempt = bachelorInformatedAttempt;
	}



	/**
	 * Return the value associated with the column: PRE_EVENT_SOCIAL_BEHAVIOUR
	 */
	public java.lang.String getPreEventSocialBehaviour () {
		return preEventSocialBehaviour;
	}

	/**
	 * Set the value related to the column: PRE_EVENT_SOCIAL_BEHAVIOUR
	 * @param preEventSocialBehaviour the PRE_EVENT_SOCIAL_BEHAVIOUR value
	 */
	public void setPreEventSocialBehaviour (java.lang.String preEventSocialBehaviour) {
		this.preEventSocialBehaviour = preEventSocialBehaviour;
	}



	/**
	 * Return the value associated with the column: PERSONALITY_INDIV_ASSESS_MO
	 */
	public java.lang.String getPersonalityIndivAssessMo () {
		return personalityIndivAssessMo;
	}

	/**
	 * Set the value related to the column: PERSONALITY_INDIV_ASSESS_MO
	 * @param personalityIndivAssessMo the PERSONALITY_INDIV_ASSESS_MO value
	 */
	public void setPersonalityIndivAssessMo (java.lang.String personalityIndivAssessMo) {
		this.personalityIndivAssessMo = personalityIndivAssessMo;
	}



	/**
	 * Return the value associated with the column: PRESENCE_SIGNOF_DEPRESSION
	 */
	public java.lang.String getPresenceSignofDepression () {
		return presenceSignofDepression;
	}

	/**
	 * Set the value related to the column: PRESENCE_SIGNOF_DEPRESSION
	 * @param presenceSignofDepression the PRESENCE_SIGNOF_DEPRESSION value
	 */
	public void setPresenceSignofDepression (java.lang.String presenceSignofDepression) {
		this.presenceSignofDepression = presenceSignofDepression;
	}



	/**
	 * Return the value associated with the column: REFERRAL_PSYCHIATRIST
	 */
	public java.lang.String getReferralPsychiatrist () {
		return referralPsychiatrist;
	}

	/**
	 * Set the value related to the column: REFERRAL_PSYCHIATRIST
	 * @param referralPsychiatrist the REFERRAL_PSYCHIATRIST value
	 */
	public void setReferralPsychiatrist (java.lang.String referralPsychiatrist) {
		this.referralPsychiatrist = referralPsychiatrist;
	}



	/**
	 * Return the value associated with the column: STATE_OUTCOME_CASE
	 */
	public java.lang.String getStateOutcomeCase () {
		return stateOutcomeCase;
	}

	/**
	 * Set the value related to the column: STATE_OUTCOME_CASE
	 * @param stateOutcomeCase the STATE_OUTCOME_CASE value
	 */
	public void setStateOutcomeCase (java.lang.String stateOutcomeCase) {
		this.stateOutcomeCase = stateOutcomeCase;
	}



	/**
	 * Return the value associated with the column: ENUMERATE_ACTION_TAK_SUICIDE
	 */
	public java.lang.String getEnumerateActionTakSuicide () {
		return enumerateActionTakSuicide;
	}

	/**
	 * Set the value related to the column: ENUMERATE_ACTION_TAK_SUICIDE
	 * @param enumerateActionTakSuicide the ENUMERATE_ACTION_TAK_SUICIDE value
	 */
	public void setEnumerateActionTakSuicide (java.lang.String enumerateActionTakSuicide) {
		this.enumerateActionTakSuicide = enumerateActionTakSuicide;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.CaseOfAttemptedSuicide)) return false;
		else {
			jkt.hms.masters.business.CaseOfAttemptedSuicide caseOfAttemptedSuicide = (jkt.hms.masters.business.CaseOfAttemptedSuicide) obj;
			if (null == this.getId() || null == caseOfAttemptedSuicide.getId()) return false;
			else return (this.getId().equals(caseOfAttemptedSuicide.getId()));
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
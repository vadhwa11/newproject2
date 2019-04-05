package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_medical_board_proceedings table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_medical_board_proceedings"
 */

public abstract class BaseMasMedicalBoardProceedings  implements Serializable {

	public static String REF = "MasMedicalBoardProceedings";
	public static String PROP_X_RAY = "XRay";
	public static String PROP_PREVIOUS_DISABLEMENT = "PreviousDisablement";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HIN_NO = "HinNo";
	public static String PROP_LAST_NAME = "LastName";
	public static String PROP_RESTRICTION_REGARDING_EMPLOYMENT = "RestrictionRegardingEmployment";
	public static String PROP_ECG = "Ecg";
	public static String PROP_WEIGHT = "Weight";
	public static String PROP_AGGRAVATED_SERVICE_STATUS = "AggravatedServiceStatus";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_BOARD_PRESIDENT = "BoardPresident";
	public static String PROP_SEX = "Sex";
	public static String PROP_TRADE_NAME = "TradeName";
	public static String PROP_CLINICAL_SUMMARY = "ClinicalSummary";
	public static String PROP_MEDICAL_CATEGORY = "MedicalCategory";
	public static String PROP_SICK_WEEK = "SickWeek";
	public static String PROP_SICK_DATE = "SickDate";
	public static String PROP_HEIGHT = "Height";
	public static String PROP_MEMBER1_NAME = "Member1Name";
	public static String PROP_DISABILITY_ATTRIBUTABLE_DESC = "DisabilityAttributableDesc";
	public static String PROP_CEASED_DUTY_ON = "CeasedDutyOn";
	public static String PROP_PLUSE = "Pluse";
	public static String PROP_ID = "Id";
	public static String PROP_DATE_OF_RECATEGORIZATION = "DateOfRecategorization";
	public static String PROP_PLACE_OF_RECATEGORIZATION = "PlaceOfRecategorization";
	public static String PROP_UNIT_NAME = "UnitName";
	public static String PROP_AGE = "Age";
	public static String PROP_DATE_OF_COMMISSIONING = "DateOfCommissioning";
	public static String PROP_AD_NO = "AdNo";
	public static String PROP_MEMBER2_NAME = "Member2Name";
	public static String PROP_INSTRUCTION_BY_PRESIDENT = "InstructionByPresident";
	public static String PROP_PAST_MEDICAL_HISTORY = "PastMedicalHistory";
	public static String PROP_MEDICAL_CATEGORY_DURATION = "MedicalCategoryDuration";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_SERVICE_NAME = "ServiceName";
	public static String PROP_MEDICAL_TYPE = "MedicalType";
	public static String PROP_AGGRAVATED_SERVICE_DESC = "AggravatedServiceDesc";
	public static String PROP_FIRST_NAME = "FirstName";
	public static String PROP_PRESENT_DISABLEMENT = "PresentDisablement";
	public static String PROP_RANK_NAME = "RankName";
	public static String PROP_SERVICE_NO = "ServiceNo";
	public static String PROP_ENTRY_NO = "EntryNo";
	public static String PROP_ENTRY_DATE = "EntryDate";
	public static String PROP_MEDICAL_CATEGORY_WITH_DURATION = "MedicalCategoryWithDuration";
	public static String PROP_CITY = "City";
	public static String PROP_ADDRESS_ON_LEAVE = "AddressOnLeave";
	public static String PROP_STATUS = "Status";
	public static String PROP_STATE = "State";
	public static String PROP_LOCAL_EXAM = "LocalExam";
	public static String PROP_REASONS_FOR_VARIATION = "ReasonsForVariation";
	public static String PROP_ADDRESS = "Address";
	public static String PROP_BP = "Bp";
	public static String PROP_DISABILITY_ATTRIBUTABLE_STATUS = "DisabilityAttributableStatus";


	// constructors
	public BaseMasMedicalBoardProceedings () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasMedicalBoardProceedings (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String medicalType;
	private java.util.Date dateOfCommissioning;
	private java.lang.String address;
	private java.lang.String pastMedicalHistory;
	private java.lang.String medicalCategory;
	private java.lang.String addressOnLeave;
	private java.lang.String medicalCategoryDuration;
	private java.util.Date dateOfRecategorization;
	private java.lang.String placeOfRecategorization;
	private java.lang.Integer previousDisablement;
	private java.lang.Integer presentDisablement;
	private java.lang.String reasonsForVariation;
	private java.lang.String restrictionRegardingEmployment;
	private java.lang.String medicalCategoryWithDuration;
	private java.lang.String instructionByPresident;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;
	private java.lang.String disabilityAttributableStatus;
	private java.lang.String disabilityAttributableDesc;
	private java.lang.String aggravatedServiceStatus;
	private java.lang.String aggravatedServiceDesc;
	private java.lang.String entryNo;
	private java.util.Date entryDate;
	private java.lang.String firstName;
	private java.lang.String serviceNo;
	private java.lang.String tradeName;
	private java.lang.String age;
	private java.lang.String sex;
	private java.lang.String weight;
	private java.lang.String height;
	private java.lang.String unitName;
	private java.lang.String rankName;
	private java.lang.String clinicalSummary;
	private java.lang.String hinNo;
	private java.lang.String adNo;
	private java.lang.String serviceName;
	private java.lang.String lastName;
	private java.util.Date ceasedDutyOn;
	private java.lang.String pluse;
	private java.lang.String bp;
	private java.lang.String localExam;
	private java.lang.String ecg;
	private java.lang.String xRay;
	private java.lang.Integer sickWeek;
	private java.util.Date sickDate;

	// many to one
	private jkt.hms.masters.business.MasDistrict city;
	private jkt.hms.masters.business.MasState state;
	private jkt.hms.masters.business.MasEmployee boardPresident;
	private jkt.hms.masters.business.MasEmployee member1Name;
	private jkt.hms.masters.business.MasEmployee member2Name;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="medical_board_id"
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
	 * Return the value associated with the column: medical_type
	 */
	public java.lang.String getMedicalType () {
		return medicalType;
	}

	/**
	 * Set the value related to the column: medical_type
	 * @param medicalType the medical_type value
	 */
	public void setMedicalType (java.lang.String medicalType) {
		this.medicalType = medicalType;
	}



	/**
	 * Return the value associated with the column: date_of_commissioning
	 */
	public java.util.Date getDateOfCommissioning () {
		return dateOfCommissioning;
	}

	/**
	 * Set the value related to the column: date_of_commissioning
	 * @param dateOfCommissioning the date_of_commissioning value
	 */
	public void setDateOfCommissioning (java.util.Date dateOfCommissioning) {
		this.dateOfCommissioning = dateOfCommissioning;
	}



	/**
	 * Return the value associated with the column: address
	 */
	public java.lang.String getAddress () {
		return address;
	}

	/**
	 * Set the value related to the column: address
	 * @param address the address value
	 */
	public void setAddress (java.lang.String address) {
		this.address = address;
	}



	/**
	 * Return the value associated with the column: past_medical_history
	 */
	public java.lang.String getPastMedicalHistory () {
		return pastMedicalHistory;
	}

	/**
	 * Set the value related to the column: past_medical_history
	 * @param pastMedicalHistory the past_medical_history value
	 */
	public void setPastMedicalHistory (java.lang.String pastMedicalHistory) {
		this.pastMedicalHistory = pastMedicalHistory;
	}



	/**
	 * Return the value associated with the column: medical_category
	 */
	public java.lang.String getMedicalCategory () {
		return medicalCategory;
	}

	/**
	 * Set the value related to the column: medical_category
	 * @param medicalCategory the medical_category value
	 */
	public void setMedicalCategory (java.lang.String medicalCategory) {
		this.medicalCategory = medicalCategory;
	}



	/**
	 * Return the value associated with the column: address_on_leave
	 */
	public java.lang.String getAddressOnLeave () {
		return addressOnLeave;
	}

	/**
	 * Set the value related to the column: address_on_leave
	 * @param addressOnLeave the address_on_leave value
	 */
	public void setAddressOnLeave (java.lang.String addressOnLeave) {
		this.addressOnLeave = addressOnLeave;
	}



	/**
	 * Return the value associated with the column: medical_category_duration
	 */
	public java.lang.String getMedicalCategoryDuration () {
		return medicalCategoryDuration;
	}

	/**
	 * Set the value related to the column: medical_category_duration
	 * @param medicalCategoryDuration the medical_category_duration value
	 */
	public void setMedicalCategoryDuration (java.lang.String medicalCategoryDuration) {
		this.medicalCategoryDuration = medicalCategoryDuration;
	}



	/**
	 * Return the value associated with the column: date_of_recategorization
	 */
	public java.util.Date getDateOfRecategorization () {
		return dateOfRecategorization;
	}

	/**
	 * Set the value related to the column: date_of_recategorization
	 * @param dateOfRecategorization the date_of_recategorization value
	 */
	public void setDateOfRecategorization (java.util.Date dateOfRecategorization) {
		this.dateOfRecategorization = dateOfRecategorization;
	}



	/**
	 * Return the value associated with the column: place_of_recategorization
	 */
	public java.lang.String getPlaceOfRecategorization () {
		return placeOfRecategorization;
	}

	/**
	 * Set the value related to the column: place_of_recategorization
	 * @param placeOfRecategorization the place_of_recategorization value
	 */
	public void setPlaceOfRecategorization (java.lang.String placeOfRecategorization) {
		this.placeOfRecategorization = placeOfRecategorization;
	}



	/**
	 * Return the value associated with the column: previous_disablement
	 */
	public java.lang.Integer getPreviousDisablement () {
		return previousDisablement;
	}

	/**
	 * Set the value related to the column: previous_disablement
	 * @param previousDisablement the previous_disablement value
	 */
	public void setPreviousDisablement (java.lang.Integer previousDisablement) {
		this.previousDisablement = previousDisablement;
	}



	/**
	 * Return the value associated with the column: present_disablement
	 */
	public java.lang.Integer getPresentDisablement () {
		return presentDisablement;
	}

	/**
	 * Set the value related to the column: present_disablement
	 * @param presentDisablement the present_disablement value
	 */
	public void setPresentDisablement (java.lang.Integer presentDisablement) {
		this.presentDisablement = presentDisablement;
	}



	/**
	 * Return the value associated with the column: reasons_for_variation
	 */
	public java.lang.String getReasonsForVariation () {
		return reasonsForVariation;
	}

	/**
	 * Set the value related to the column: reasons_for_variation
	 * @param reasonsForVariation the reasons_for_variation value
	 */
	public void setReasonsForVariation (java.lang.String reasonsForVariation) {
		this.reasonsForVariation = reasonsForVariation;
	}



	/**
	 * Return the value associated with the column: restriction_regarding_employment
	 */
	public java.lang.String getRestrictionRegardingEmployment () {
		return restrictionRegardingEmployment;
	}

	/**
	 * Set the value related to the column: restriction_regarding_employment
	 * @param restrictionRegardingEmployment the restriction_regarding_employment value
	 */
	public void setRestrictionRegardingEmployment (java.lang.String restrictionRegardingEmployment) {
		this.restrictionRegardingEmployment = restrictionRegardingEmployment;
	}



	/**
	 * Return the value associated with the column: medical_category_with_duration
	 */
	public java.lang.String getMedicalCategoryWithDuration () {
		return medicalCategoryWithDuration;
	}

	/**
	 * Set the value related to the column: medical_category_with_duration
	 * @param medicalCategoryWithDuration the medical_category_with_duration value
	 */
	public void setMedicalCategoryWithDuration (java.lang.String medicalCategoryWithDuration) {
		this.medicalCategoryWithDuration = medicalCategoryWithDuration;
	}



	/**
	 * Return the value associated with the column: instruction_by_president
	 */
	public java.lang.String getInstructionByPresident () {
		return instructionByPresident;
	}

	/**
	 * Set the value related to the column: instruction_by_president
	 * @param instructionByPresident the instruction_by_president value
	 */
	public void setInstructionByPresident (java.lang.String instructionByPresident) {
		this.instructionByPresident = instructionByPresident;
	}



	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.String getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
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
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * @param status the status value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
	}



	/**
	 * Return the value associated with the column: disability_attributable_status
	 */
	public java.lang.String getDisabilityAttributableStatus () {
		return disabilityAttributableStatus;
	}

	/**
	 * Set the value related to the column: disability_attributable_status
	 * @param disabilityAttributableStatus the disability_attributable_status value
	 */
	public void setDisabilityAttributableStatus (java.lang.String disabilityAttributableStatus) {
		this.disabilityAttributableStatus = disabilityAttributableStatus;
	}



	/**
	 * Return the value associated with the column: disability_attributable_desc
	 */
	public java.lang.String getDisabilityAttributableDesc () {
		return disabilityAttributableDesc;
	}

	/**
	 * Set the value related to the column: disability_attributable_desc
	 * @param disabilityAttributableDesc the disability_attributable_desc value
	 */
	public void setDisabilityAttributableDesc (java.lang.String disabilityAttributableDesc) {
		this.disabilityAttributableDesc = disabilityAttributableDesc;
	}



	/**
	 * Return the value associated with the column: aggravated_service_status
	 */
	public java.lang.String getAggravatedServiceStatus () {
		return aggravatedServiceStatus;
	}

	/**
	 * Set the value related to the column: aggravated_service_status
	 * @param aggravatedServiceStatus the aggravated_service_status value
	 */
	public void setAggravatedServiceStatus (java.lang.String aggravatedServiceStatus) {
		this.aggravatedServiceStatus = aggravatedServiceStatus;
	}



	/**
	 * Return the value associated with the column: aggravated_service_desc
	 */
	public java.lang.String getAggravatedServiceDesc () {
		return aggravatedServiceDesc;
	}

	/**
	 * Set the value related to the column: aggravated_service_desc
	 * @param aggravatedServiceDesc the aggravated_service_desc value
	 */
	public void setAggravatedServiceDesc (java.lang.String aggravatedServiceDesc) {
		this.aggravatedServiceDesc = aggravatedServiceDesc;
	}



	/**
	 * Return the value associated with the column: entry_no
	 */
	public java.lang.String getEntryNo () {
		return entryNo;
	}

	/**
	 * Set the value related to the column: entry_no
	 * @param entryNo the entry_no value
	 */
	public void setEntryNo (java.lang.String entryNo) {
		this.entryNo = entryNo;
	}



	/**
	 * Return the value associated with the column: entry_date
	 */
	public java.util.Date getEntryDate () {
		return entryDate;
	}

	/**
	 * Set the value related to the column: entry_date
	 * @param entryDate the entry_date value
	 */
	public void setEntryDate (java.util.Date entryDate) {
		this.entryDate = entryDate;
	}



	/**
	 * Return the value associated with the column: first_name
	 */
	public java.lang.String getFirstName () {
		return firstName;
	}

	/**
	 * Set the value related to the column: first_name
	 * @param firstName the first_name value
	 */
	public void setFirstName (java.lang.String firstName) {
		this.firstName = firstName;
	}



	/**
	 * Return the value associated with the column: service_no
	 */
	public java.lang.String getServiceNo () {
		return serviceNo;
	}

	/**
	 * Set the value related to the column: service_no
	 * @param serviceNo the service_no value
	 */
	public void setServiceNo (java.lang.String serviceNo) {
		this.serviceNo = serviceNo;
	}



	/**
	 * Return the value associated with the column: trade_name
	 */
	public java.lang.String getTradeName () {
		return tradeName;
	}

	/**
	 * Set the value related to the column: trade_name
	 * @param tradeName the trade_name value
	 */
	public void setTradeName (java.lang.String tradeName) {
		this.tradeName = tradeName;
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
	 * Return the value associated with the column: sex
	 */
	public java.lang.String getSex () {
		return sex;
	}

	/**
	 * Set the value related to the column: sex
	 * @param sex the sex value
	 */
	public void setSex (java.lang.String sex) {
		this.sex = sex;
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
	 * Return the value associated with the column: unit_name
	 */
	public java.lang.String getUnitName () {
		return unitName;
	}

	/**
	 * Set the value related to the column: unit_name
	 * @param unitName the unit_name value
	 */
	public void setUnitName (java.lang.String unitName) {
		this.unitName = unitName;
	}



	/**
	 * Return the value associated with the column: rank_name
	 */
	public java.lang.String getRankName () {
		return rankName;
	}

	/**
	 * Set the value related to the column: rank_name
	 * @param rankName the rank_name value
	 */
	public void setRankName (java.lang.String rankName) {
		this.rankName = rankName;
	}



	/**
	 * Return the value associated with the column: clinical_summary
	 */
	public java.lang.String getClinicalSummary () {
		return clinicalSummary;
	}

	/**
	 * Set the value related to the column: clinical_summary
	 * @param clinicalSummary the clinical_summary value
	 */
	public void setClinicalSummary (java.lang.String clinicalSummary) {
		this.clinicalSummary = clinicalSummary;
	}



	/**
	 * Return the value associated with the column: hin_no
	 */
	public java.lang.String getHinNo () {
		return hinNo;
	}

	/**
	 * Set the value related to the column: hin_no
	 * @param hinNo the hin_no value
	 */
	public void setHinNo (java.lang.String hinNo) {
		this.hinNo = hinNo;
	}



	/**
	 * Return the value associated with the column: ad_no
	 */
	public java.lang.String getAdNo () {
		return adNo;
	}

	/**
	 * Set the value related to the column: ad_no
	 * @param adNo the ad_no value
	 */
	public void setAdNo (java.lang.String adNo) {
		this.adNo = adNo;
	}



	/**
	 * Return the value associated with the column: service_name
	 */
	public java.lang.String getServiceName () {
		return serviceName;
	}

	/**
	 * Set the value related to the column: service_name
	 * @param serviceName the service_name value
	 */
	public void setServiceName (java.lang.String serviceName) {
		this.serviceName = serviceName;
	}



	/**
	 * Return the value associated with the column: last_name
	 */
	public java.lang.String getLastName () {
		return lastName;
	}

	/**
	 * Set the value related to the column: last_name
	 * @param lastName the last_name value
	 */
	public void setLastName (java.lang.String lastName) {
		this.lastName = lastName;
	}



	/**
	 * Return the value associated with the column: ceased_duty_on
	 */
	public java.util.Date getCeasedDutyOn () {
		return ceasedDutyOn;
	}

	/**
	 * Set the value related to the column: ceased_duty_on
	 * @param ceasedDutyOn the ceased_duty_on value
	 */
	public void setCeasedDutyOn (java.util.Date ceasedDutyOn) {
		this.ceasedDutyOn = ceasedDutyOn;
	}



	/**
	 * Return the value associated with the column: pulse
	 */
	public java.lang.String getPluse () {
		return pluse;
	}

	/**
	 * Set the value related to the column: pulse
	 * @param pluse the pulse value
	 */
	public void setPluse (java.lang.String pluse) {
		this.pluse = pluse;
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
	 * Return the value associated with the column: local_exam
	 */
	public java.lang.String getLocalExam () {
		return localExam;
	}

	/**
	 * Set the value related to the column: local_exam
	 * @param localExam the local_exam value
	 */
	public void setLocalExam (java.lang.String localExam) {
		this.localExam = localExam;
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
	 * Return the value associated with the column: x_ray
	 */
	public java.lang.String getXRay () {
		return xRay;
	}

	/**
	 * Set the value related to the column: x_ray
	 * @param xRay the x_ray value
	 */
	public void setXRay (java.lang.String xRay) {
		this.xRay = xRay;
	}



	/**
	 * Return the value associated with the column: sick_leave_in_week
	 */
	public java.lang.Integer getSickWeek () {
		return sickWeek;
	}

	/**
	 * Set the value related to the column: sick_leave_in_week
	 * @param sickWeek the sick_leave_in_week value
	 */
	public void setSickWeek (java.lang.Integer sickWeek) {
		this.sickWeek = sickWeek;
	}



	/**
	 * Return the value associated with the column: sick_leave_date
	 */
	public java.util.Date getSickDate () {
		return sickDate;
	}

	/**
	 * Set the value related to the column: sick_leave_date
	 * @param sickDate the sick_leave_date value
	 */
	public void setSickDate (java.util.Date sickDate) {
		this.sickDate = sickDate;
	}



	/**
	 * Return the value associated with the column: city
	 */
	public jkt.hms.masters.business.MasDistrict getCity () {
		return city;
	}

	/**
	 * Set the value related to the column: city
	 * @param city the city value
	 */
	public void setCity (jkt.hms.masters.business.MasDistrict city) {
		this.city = city;
	}



	/**
	 * Return the value associated with the column: state
	 */
	public jkt.hms.masters.business.MasState getState () {
		return state;
	}

	/**
	 * Set the value related to the column: state
	 * @param state the state value
	 */
	public void setState (jkt.hms.masters.business.MasState state) {
		this.state = state;
	}



	/**
	 * Return the value associated with the column: board_president
	 */
	public jkt.hms.masters.business.MasEmployee getBoardPresident () {
		return boardPresident;
	}

	/**
	 * Set the value related to the column: board_president
	 * @param boardPresident the board_president value
	 */
	public void setBoardPresident (jkt.hms.masters.business.MasEmployee boardPresident) {
		this.boardPresident = boardPresident;
	}



	/**
	 * Return the value associated with the column: member1_name
	 */
	public jkt.hms.masters.business.MasEmployee getMember1Name () {
		return member1Name;
	}

	/**
	 * Set the value related to the column: member1_name
	 * @param member1Name the member1_name value
	 */
	public void setMember1Name (jkt.hms.masters.business.MasEmployee member1Name) {
		this.member1Name = member1Name;
	}



	/**
	 * Return the value associated with the column: member2_name
	 */
	public jkt.hms.masters.business.MasEmployee getMember2Name () {
		return member2Name;
	}

	/**
	 * Set the value related to the column: member2_name
	 * @param member2Name the member2_name value
	 */
	public void setMember2Name (jkt.hms.masters.business.MasEmployee member2Name) {
		this.member2Name = member2Name;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasMedicalBoardProceedings)) return false;
		else {
			jkt.hms.masters.business.MasMedicalBoardProceedings masMedicalBoardProceedings = (jkt.hms.masters.business.MasMedicalBoardProceedings) obj;
			if (null == this.getId() || null == masMedicalBoardProceedings.getId()) return false;
			else return (this.getId().equals(masMedicalBoardProceedings.getId()));
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
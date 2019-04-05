package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the patient table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="patient"
 */

public abstract class BasePatient  implements Serializable {

	public static String REF = "Patient";
	public static String PROP_USER = "User";
	public static String PROP_DEP_MARRIAGE_DATE = "DepMarriageDate";
	public static String PROP_NEXT_OF_KIN_ADDRESS = "NextOfKinAddress";
	public static String PROP_NEXT_OF_KIN_NAME = "NextOfKinName";
	public static String PROP_TRADE = "Trade";
	public static String PROP_PATIENT_IMAGE_TIME = "PatientImageTime";
	public static String PROP_CDA_ACCOUNT_NO = "CdaAccountNo";
	public static String PROP_NOK2_CONTACT_NO = "Nok2ContactNo";
	public static String PROP_NEXT_OF_KIN_RELATION = "NextOfKinRelation";
	public static String PROP_OTHER_FAMILY_HISTORY = "OtherFamilyHistory";
	public static String PROP_SR_BLOOD_GROUP = "SrBloodGroup";
	public static String PROP_PATIENT_DISTRICT = "PatientDistrict";
	public static String PROP_AFNET_NO = "AfnetNo";
	public static String PROP_PATIENT_IMAGE_DATE = "PatientImageDate";
	public static String PROP_OLD_HIN_NO = "OldHinNo";
	public static String PROP_POLICE_STATION = "PoliceStation";
	public static String PROP_P_LAST_NAME = "PLastName";
	public static String PROP_SR_SEX = "SrSex";
	public static String PROP_RELIGION = "Religion";
	public static String PROP_REG_DATE = "RegDate";
	public static String PROP_DEPENDENCY_DATE = "DependencyDate";
	public static String PROP_SMOKER_MORE10 = "SmokerMore10";
	public static String PROP_PHONE_NUMBER = "PhoneNumber";
	public static String PROP_MED_CAT_DATE = "MedCatDate";
	public static String PROP_COUNTRY = "Country";
	public static String PROP_DATE_OF_BIRTH = "DateOfBirth";
	public static String PROP_NOK2_POLICE_STATION = "Nok2PoliceStation";
	public static String PROP_DISTRICT = "District";
	public static String PROP_P_FIRST_NAME = "PFirstName";
	public static String PROP_DEP_IDENTIFICATION_MARK2 = "DepIdentificationMark2";
	public static String PROP_DEP_IDENTIFICATION_MARK1 = "DepIdentificationMark1";
	public static String PROP_INPATIENT_NO = "InpatientNo";
	public static String PROP_PIN_CODE = "PinCode";
	public static String PROP_DRUG_ALLERGIES = "DrugAllergies";
	public static String PROP_REG_TIME = "RegTime";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_FORMATION = "Formation";
	public static String PROP_UNIT = "Unit";
	public static String PROP_ADD_EDIT_DATE = "AddEditDate";
	public static String PROP_STATION = "Station";
	public static String PROP_TELEPHONE_NO_PERM = "TelephoneNoPerm";
	public static String PROP_SERVICE_CARD_VALIDITY_DATE = "ServiceCardValidityDate";
	public static String PROP_S_FIRST_NAME = "SFirstName";
	public static String PROP_OCCUPATION = "Occupation";
	public static String PROP_SR_DOB = "SrDob";
	public static String PROP_BLOCK = "Block";
	public static String PROP_S_MIDDLE_NAME = "SMiddleName";
	public static String PROP_OTHER_CONTACT_NO = "OtherContactNo";
	public static String PROP_TOTAL_SERVICE_PERIOD = "TotalServicePeriod";
	public static String PROP_ALCOHOL = "Alcohol";
	public static String PROP_PREVIOUS_HIN_NO = "PreviousHinNo";
	public static String PROP_NOK2_NAME = "Nok2Name";
	public static String PROP_NOK1_PIN_CODE = "Nok1PinCode";
	public static String PROP_PERMANENT_ADDRESS = "PermanentAddress";
	public static String PROP_CURRENT_VISIT_NO = "CurrentVisitNo";
	public static String PROP_ECHS_NO = "EchsNo";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_TITLE = "Title";
	public static String PROP_CITY = "City";
	public static String PROP_NEW_BORN_BABY = "NewBornBaby";
	public static String PROP_SMOKER_LESS10 = "SmokerLess10";
	public static String PROP_POST_CODE = "PostCode";
	public static String PROP_PATIENT_STATUS = "PatientStatus";
	public static String PROP_ADDRESS = "Address";
	public static String PROP_IMAGE_FILE_EXTENSION = "ImageFileExtension";
	public static String PROP_SERVICE_YEARS = "ServiceYears";
	public static String PROP_BILLABLE = "Billable";
	public static String PROP_RANK = "Rank";
	public static String PROP_SERVICE_TYPE = "ServiceType";
	public static String PROP_HIN_NO = "HinNo";
	public static String PROP_PATIENT_IMAGE = "PatientImage";
	public static String PROP_NOK1_POLICE_STATION = "Nok1PoliceStation";
	public static String PROP_MOTHER_HIN_NO = "MotherHinNo";
	public static String PROP_NOK2_RELATION = "Nok2Relation";
	public static String PROP_ADD_EDIT_BY = "AddEditBy";
	public static String PROP_S_LAST_NAME = "SLastName";
	public static String PROP_SR_MARITAL_STATUS = "SrMaritalStatus";
	public static String PROP_POST_OFFICE = "PostOffice";
	public static String PROP_SEX = "Sex";
	public static String PROP_TRADE_NAME = "TradeName";
	public static String PROP_VISIT_CREATED = "VisitCreated";
	public static String PROP_RECORD_OFFICE_ADDRESS = "RecordOfficeAddress";
	public static String PROP_SUFFIX = "Suffix";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_DEPENDENT_CARD_ISSUE_DATE = "DependentCardIssueDate";
	public static String PROP_PERMANENT_STATE = "PermanentState";
	public static String PROP_PATIENT_TYPE = "PatientType";
	public static String PROP_PREFIX = "Prefix";
	public static String PROP_CONTACT_NO = "ContactNo";
	public static String PROP_COMMISSION_DATE = "CommissionDate";
	public static String PROP_PAYMENT_STATUS = "PaymentStatus";
	public static String PROP_SERVICE_STATUS = "ServiceStatus";
	public static String PROP_NOK2_PIN_CODE = "Nok2PinCode";
	public static String PROP_BLOOD_GROUP = "BloodGroup";
	public static String PROP_AB64_AVAILABLE = "Ab64Available";
	public static String PROP_SR_AGE = "SrAge";
	public static String PROP_SERVICE_CARD_STATUS = "ServiceCardStatus";
	public static String PROP_ID = "Id";
	public static String PROP_REFERENCE = "Reference";
	public static String PROP_ADMINISTRATIVE_SEX = "AdministrativeSex";
	public static String PROP_TELEPHONE_RESI = "TelephoneResi";
	public static String PROP_COMMAND = "Command";
	public static String PROP_AGE = "Age";
	public static String PROP_NEXT_OF_KIN_MOBILE_NUMBER = "NextOfKinMobileNumber";
	public static String PROP_APPROVED_BY = "ApprovedBy";
	public static String PROP_PERMANENT_CITY = "PermanentCity";
	public static String PROP_INCOME = "Income";
	public static String PROP_OTHERS_CATEGORY = "OthersCategory";
	public static String PROP_NOK2_ADDRESS = "Nok2Address";
	public static String PROP_SR_IDENTIFICATION_MARK2 = "SrIdentificationMark2";
	public static String PROP_AUTHORITY = "Authority";
	public static String PROP_SR_IDENTIFICATION_MARK1 = "SrIdentificationMark1";
	public static String PROP_MARITAL_STATUS = "MaritalStatus";
	public static String PROP_ADD_EDIT_TIME = "AddEditTime";
	public static String PROP_EMAIL_ID = "EmailId";
	public static String PROP_MOBILE_NUMBER = "MobileNumber";
	public static String PROP_RELATION = "Relation";
	public static String PROP_NEXT_OF_KIN_PHONE_NUMBER = "NextOfKinPhoneNumber";
	public static String PROP_SERVICE_NO = "ServiceNo";
	public static String PROP_FAMILY_HISTORY = "FamilyHistory";
	public static String PROP_MED_CAT_PERIOD = "MedCatPeriod";
	public static String PROP_SR_MARRIAGE_DATE = "SrMarriageDate";
	public static String PROP_DEPENDENCY_REMOVAL_DATE = "DependencyRemovalDate";
	public static String PROP_HL7_FLAG = "Hl7Flag";
	public static String PROP_SECTION = "Section";
	public static String PROP_STATUS = "Status";
	public static String PROP_CATEGORY = "Category";
	public static String PROP_STATE = "State";
	public static String PROP_FILE_NAME = "FileName";
	public static String PROP_P_MIDDLE_NAME = "PMiddleName";


	// constructors
	public BasePatient () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePatient (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String serviceNo;
	private java.lang.String hinNo;
	private java.lang.String pFirstName;
	private java.lang.String pMiddleName;
	private java.lang.String pLastName;
	private java.lang.String sFirstName;
	private java.lang.String sMiddleName;
	private java.lang.String sLastName;
	private java.util.Date dateOfBirth;
	private java.lang.Float serviceYears;
	private java.lang.String station;
	private java.lang.String formation;
	private java.lang.String ab64Available;
	private java.lang.String cdaAccountNo;
	private java.lang.String patientDistrict;
	private java.lang.Integer currentVisitNo;
	private java.lang.Integer inpatientNo;
	private java.lang.String city;
	private java.lang.String policeStation;
	private java.lang.String postOffice;
	private java.lang.String pinCode;
	private java.lang.String emailId;
	private java.lang.String phoneNumber;
	private java.lang.String mobileNumber;
	private java.lang.String nextOfKinName;
	private java.lang.String nextOfKinAddress;
	private java.lang.String nextOfKinPhoneNumber;
	private java.lang.String nextOfKinMobileNumber;
	private java.lang.String remarks;
	private java.util.Date addEditDate;
	private java.lang.String addEditTime;
	private java.lang.String patientStatus;
	private java.lang.String status;
	private java.lang.String motherHinNo;
	private java.util.Date serviceCardValidityDate;
	private java.util.Date dependentCardIssueDate;
	private java.lang.String serviceCardStatus;
	private java.lang.String address;
	private java.util.Date regDate;
	private java.lang.String regTime;
	private java.lang.String suffix;
	private java.lang.String oldHinNo;
	private java.lang.String age;
	private java.lang.String totalServicePeriod;
	private java.lang.String prefix;
	private java.lang.String echsNo;
	private java.lang.String tradeName;
	private java.util.Date srDob;
	private java.lang.String srAge;
	private java.lang.String contactNo;
	private java.util.Date commissionDate;
	private java.lang.String income;
	private java.util.Date dependencyDate;
	private java.lang.String authority;
	private java.util.Date dependencyRemovalDate;
	private java.lang.String afnetNo;
	private java.lang.String drugAllergies;
	private java.lang.String smokerLess10;
	private java.lang.String alcohol;
	private java.lang.String permanentAddress;
	private java.lang.String telephoneResi;
	private java.lang.String otherContactNo;
	private java.lang.String telephoneNoPerm;
	private java.lang.String nok2Name;
	private java.lang.String nok2Address;
	private java.lang.String nok2ContactNo;
	private java.lang.String smokerMore10;
	private java.lang.String nok1PoliceStation;
	private java.lang.String nok1PinCode;
	private java.lang.String nok2PoliceStation;
	private java.lang.String nok2PinCode;
	private byte[] patientImage;
	private java.lang.String imageFileExtension;
	private java.lang.String fileName;
	private java.lang.String medCatPeriod;
	private java.util.Date medCatDate;
	private java.util.Date patientImageDate;
	private java.lang.String patientImageTime;
	private java.lang.String otherFamilyHistory;
	private java.util.Date srMarriageDate;
	private java.util.Date depMarriageDate;
	private java.lang.String srIdentificationMark1;
	private java.lang.String srIdentificationMark2;
	private java.lang.String depIdentificationMark1;
	private java.lang.String depIdentificationMark2;
	private java.lang.String hl7Flag;
	private java.lang.String previousHinNo;
	private java.lang.String billable;
	private java.lang.String paymentStatus;
	private java.lang.String visitCreated;
	private java.lang.String newBornBaby;

	// many to one
	private jkt.hms.masters.business.MasServiceStatus serviceStatus;
	private jkt.hms.masters.business.MasBloodGroup srBloodGroup;
	private jkt.hms.masters.business.MasEmployee employee;
	private jkt.hms.masters.business.MasMaritalStatus maritalStatus;
	private jkt.hms.masters.business.MasRelation nextOfKinRelation;
	private jkt.hms.masters.business.Users addEditBy;
	private jkt.hms.masters.business.MasUnit unit;
	private jkt.hms.masters.business.MasCommand command;
	private jkt.hms.masters.business.MasAdministrativeSex administrativeSex;
	private jkt.hms.masters.business.MasState state;
	private jkt.hms.masters.business.MasPatientType patientType;
	private jkt.hms.masters.business.MasReligion religion;
	private jkt.hms.masters.business.MasRecordOfficeAddress recordOfficeAddress;
	private jkt.hms.masters.business.MasState permanentState;
	private jkt.hms.masters.business.MasOccupation occupation;
	private jkt.hms.masters.business.MasReference reference;
	private jkt.hms.masters.business.MasDistrict permanentCity;
	private jkt.hms.masters.business.Users user;
	private jkt.hms.masters.business.MasAdministrativeSex srSex;
	private jkt.hms.masters.business.MasBloodGroup bloodGroup;
	private jkt.hms.masters.business.MasCountry country;
	private jkt.hms.masters.business.MasMaritalStatus srMaritalStatus;
	private jkt.hms.masters.business.MasDistrict district;
	private jkt.hms.masters.business.Category category;
	private jkt.hms.masters.business.MasSection section;
	private jkt.hms.masters.business.MasPostCode postCode;
	private jkt.hms.masters.business.MasServiceType serviceType;
	private jkt.hms.masters.business.MasRelation relation;
	private jkt.hms.masters.business.MasEmployee approvedBy;
	private jkt.hms.masters.business.PatientFamilyHistory familyHistory;
	private jkt.hms.masters.business.MasTitle title;
	private jkt.hms.masters.business.MasAdministrativeSex sex;
	private jkt.hms.masters.business.MasRank rank;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasTrade trade;
	private jkt.hms.masters.business.MasRelation nok2Relation;
	private jkt.hms.masters.business.MasBlock block;
	private jkt.hms.masters.business.MasOthersCategory othersCategory;

	// collections
	private java.util.Set<jkt.hms.masters.business.Discharge> discharges;
	private java.util.Set<jkt.hms.masters.business.IpdIntakeOutput> ipdIntakeOutputs;
	private java.util.Set<jkt.hms.masters.business.MlcCase> mlcCases;
	private java.util.Set<jkt.hms.masters.business.DischargeSummary> dischargeSummaries;
	private java.util.Set<jkt.hms.masters.business.DischargeIcdCode> dischargeIcdCodes;
	private java.util.Set<jkt.hms.masters.business.AppPatientAppointments> appPatientAppointments;
	private java.util.Set<jkt.hms.masters.business.Birthdeathreg> birthdeathregs;
	private java.util.Set<jkt.hms.masters.business.MisFrw> misFrws;
	private java.util.Set<jkt.hms.masters.business.StoreIssueM> storeIssueMs;
	private java.util.Set<jkt.hms.masters.business.Ipdcaredetail> ipdcaredetails;
	private java.util.Set<jkt.hms.masters.business.BlReceipt> blReceipts;
	private java.util.Set<jkt.hms.masters.business.MisNotifiable> misNotifiables;
	private java.util.Set<jkt.hms.masters.business.StoreIpIssueM> storeIpIssueMs;
	private java.util.Set<jkt.hms.masters.business.NursingcareSetup> nursingcareSetups;
	private java.util.Set<jkt.hms.masters.business.StoreOpPatientIssueM> storeOpPatientIssueMs;
	private java.util.Set<jkt.hms.masters.business.DgOrderhd> dgOrderhds;
	private java.util.Set<jkt.hms.masters.business.IpdIntakeOutputChart> ipdIntakeOutputCharts;
	private java.util.Set<jkt.hms.masters.business.IpdClinicalChart> ipdClinicalCharts;
	private java.util.Set<jkt.hms.masters.business.Ipdclinical> ipdclinicals;
	private java.util.Set<jkt.hms.masters.business.AttachInpatient> attachInpatients;
	private java.util.Set<jkt.hms.masters.business.Inpatient> inpatients;
	private java.util.Set<jkt.hms.masters.business.Visit> visits;
	private java.util.Set<jkt.hms.masters.business.BlOpBillMain> blOpBillMains;
	private java.util.Set<jkt.hms.masters.business.MisFatalTracking> misFatalTrackings;
	private java.util.Set<jkt.hms.masters.business.Transfer> transfers;
	private java.util.Set<jkt.hms.masters.business.ExpiryDetails> expiryDetails;
	private java.util.Set<jkt.hms.masters.business.AllergyDetail> allergyDetails;
	private java.util.Set<jkt.hms.masters.business.MasMedicalExamFamilyHis> masMedicalExamFamilyHis;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="hin_id"
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
	 * Return the value associated with the column: p_first_name
	 */
	public java.lang.String getPFirstName () {
		return pFirstName;
	}

	/**
	 * Set the value related to the column: p_first_name
	 * @param pFirstName the p_first_name value
	 */
	public void setPFirstName (java.lang.String pFirstName) {
		this.pFirstName = pFirstName;
	}



	/**
	 * Return the value associated with the column: p_middle_name
	 */
	public java.lang.String getPMiddleName () {
		return pMiddleName;
	}

	/**
	 * Set the value related to the column: p_middle_name
	 * @param pMiddleName the p_middle_name value
	 */
	public void setPMiddleName (java.lang.String pMiddleName) {
		this.pMiddleName = pMiddleName;
	}



	/**
	 * Return the value associated with the column: p_last_name
	 */
	public java.lang.String getPLastName () {
		return pLastName;
	}

	/**
	 * Set the value related to the column: p_last_name
	 * @param pLastName the p_last_name value
	 */
	public void setPLastName (java.lang.String pLastName) {
		this.pLastName = pLastName;
	}



	/**
	 * Return the value associated with the column: s_first_name
	 */
	public java.lang.String getSFirstName () {
		return sFirstName;
	}

	/**
	 * Set the value related to the column: s_first_name
	 * @param sFirstName the s_first_name value
	 */
	public void setSFirstName (java.lang.String sFirstName) {
		this.sFirstName = sFirstName;
	}



	/**
	 * Return the value associated with the column: s_middle_name
	 */
	public java.lang.String getSMiddleName () {
		return sMiddleName;
	}

	/**
	 * Set the value related to the column: s_middle_name
	 * @param sMiddleName the s_middle_name value
	 */
	public void setSMiddleName (java.lang.String sMiddleName) {
		this.sMiddleName = sMiddleName;
	}



	/**
	 * Return the value associated with the column: s_last_name
	 */
	public java.lang.String getSLastName () {
		return sLastName;
	}

	/**
	 * Set the value related to the column: s_last_name
	 * @param sLastName the s_last_name value
	 */
	public void setSLastName (java.lang.String sLastName) {
		this.sLastName = sLastName;
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
	 * Return the value associated with the column: service_years
	 */
	public java.lang.Float getServiceYears () {
		return serviceYears;
	}

	/**
	 * Set the value related to the column: service_years
	 * @param serviceYears the service_years value
	 */
	public void setServiceYears (java.lang.Float serviceYears) {
		this.serviceYears = serviceYears;
	}



	/**
	 * Return the value associated with the column: station
	 */
	public java.lang.String getStation () {
		return station;
	}

	/**
	 * Set the value related to the column: station
	 * @param station the station value
	 */
	public void setStation (java.lang.String station) {
		this.station = station;
	}



	/**
	 * Return the value associated with the column: formation
	 */
	public java.lang.String getFormation () {
		return formation;
	}

	/**
	 * Set the value related to the column: formation
	 * @param formation the formation value
	 */
	public void setFormation (java.lang.String formation) {
		this.formation = formation;
	}



	/**
	 * Return the value associated with the column: AB_64_available
	 */
	public java.lang.String getAb64Available () {
		return ab64Available;
	}

	/**
	 * Set the value related to the column: AB_64_available
	 * @param ab64Available the AB_64_available value
	 */
	public void setAb64Available (java.lang.String ab64Available) {
		this.ab64Available = ab64Available;
	}



	/**
	 * Return the value associated with the column: cda_account_no
	 */
	public java.lang.String getCdaAccountNo () {
		return cdaAccountNo;
	}

	/**
	 * Set the value related to the column: cda_account_no
	 * @param cdaAccountNo the cda_account_no value
	 */
	public void setCdaAccountNo (java.lang.String cdaAccountNo) {
		this.cdaAccountNo = cdaAccountNo;
	}



	/**
	 * Return the value associated with the column: patient_district
	 */
	public java.lang.String getPatientDistrict () {
		return patientDistrict;
	}

	/**
	 * Set the value related to the column: patient_district
	 * @param patientDistrict the patient_district value
	 */
	public void setPatientDistrict (java.lang.String patientDistrict) {
		this.patientDistrict = patientDistrict;
	}



	/**
	 * Return the value associated with the column: current_visit_no
	 */
	public java.lang.Integer getCurrentVisitNo () {
		return currentVisitNo;
	}

	/**
	 * Set the value related to the column: current_visit_no
	 * @param currentVisitNo the current_visit_no value
	 */
	public void setCurrentVisitNo (java.lang.Integer currentVisitNo) {
		this.currentVisitNo = currentVisitNo;
	}



	/**
	 * Return the value associated with the column: inpatient_no
	 */
	public java.lang.Integer getInpatientNo () {
		return inpatientNo;
	}

	/**
	 * Set the value related to the column: inpatient_no
	 * @param inpatientNo the inpatient_no value
	 */
	public void setInpatientNo (java.lang.Integer inpatientNo) {
		this.inpatientNo = inpatientNo;
	}



	/**
	 * Return the value associated with the column: city
	 */
	public java.lang.String getCity () {
		return city;
	}

	/**
	 * Set the value related to the column: city
	 * @param city the city value
	 */
	public void setCity (java.lang.String city) {
		this.city = city;
	}



	/**
	 * Return the value associated with the column: police_station
	 */
	public java.lang.String getPoliceStation () {
		return policeStation;
	}

	/**
	 * Set the value related to the column: police_station
	 * @param policeStation the police_station value
	 */
	public void setPoliceStation (java.lang.String policeStation) {
		this.policeStation = policeStation;
	}



	/**
	 * Return the value associated with the column: post_office
	 */
	public java.lang.String getPostOffice () {
		return postOffice;
	}

	/**
	 * Set the value related to the column: post_office
	 * @param postOffice the post_office value
	 */
	public void setPostOffice (java.lang.String postOffice) {
		this.postOffice = postOffice;
	}



	/**
	 * Return the value associated with the column: pin_code
	 */
	public java.lang.String getPinCode () {
		return pinCode;
	}

	/**
	 * Set the value related to the column: pin_code
	 * @param pinCode the pin_code value
	 */
	public void setPinCode (java.lang.String pinCode) {
		this.pinCode = pinCode;
	}



	/**
	 * Return the value associated with the column: email_id
	 */
	public java.lang.String getEmailId () {
		return emailId;
	}

	/**
	 * Set the value related to the column: email_id
	 * @param emailId the email_id value
	 */
	public void setEmailId (java.lang.String emailId) {
		this.emailId = emailId;
	}



	/**
	 * Return the value associated with the column: phone_number
	 */
	public java.lang.String getPhoneNumber () {
		return phoneNumber;
	}

	/**
	 * Set the value related to the column: phone_number
	 * @param phoneNumber the phone_number value
	 */
	public void setPhoneNumber (java.lang.String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	/**
	 * Return the value associated with the column: mobile_number
	 */
	public java.lang.String getMobileNumber () {
		return mobileNumber;
	}

	/**
	 * Set the value related to the column: mobile_number
	 * @param mobileNumber the mobile_number value
	 */
	public void setMobileNumber (java.lang.String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}



	/**
	 * Return the value associated with the column: next_of_kin_name
	 */
	public java.lang.String getNextOfKinName () {
		return nextOfKinName;
	}

	/**
	 * Set the value related to the column: next_of_kin_name
	 * @param nextOfKinName the next_of_kin_name value
	 */
	public void setNextOfKinName (java.lang.String nextOfKinName) {
		this.nextOfKinName = nextOfKinName;
	}



	/**
	 * Return the value associated with the column: next_of_kin_address
	 */
	public java.lang.String getNextOfKinAddress () {
		return nextOfKinAddress;
	}

	/**
	 * Set the value related to the column: next_of_kin_address
	 * @param nextOfKinAddress the next_of_kin_address value
	 */
	public void setNextOfKinAddress (java.lang.String nextOfKinAddress) {
		this.nextOfKinAddress = nextOfKinAddress;
	}



	/**
	 * Return the value associated with the column: next_of_kin_phone_number
	 */
	public java.lang.String getNextOfKinPhoneNumber () {
		return nextOfKinPhoneNumber;
	}

	/**
	 * Set the value related to the column: next_of_kin_phone_number
	 * @param nextOfKinPhoneNumber the next_of_kin_phone_number value
	 */
	public void setNextOfKinPhoneNumber (java.lang.String nextOfKinPhoneNumber) {
		this.nextOfKinPhoneNumber = nextOfKinPhoneNumber;
	}



	/**
	 * Return the value associated with the column: next_of_kin_mobile_number
	 */
	public java.lang.String getNextOfKinMobileNumber () {
		return nextOfKinMobileNumber;
	}

	/**
	 * Set the value related to the column: next_of_kin_mobile_number
	 * @param nextOfKinMobileNumber the next_of_kin_mobile_number value
	 */
	public void setNextOfKinMobileNumber (java.lang.String nextOfKinMobileNumber) {
		this.nextOfKinMobileNumber = nextOfKinMobileNumber;
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
	 * Return the value associated with the column: add_edit_date
	 */
	public java.util.Date getAddEditDate () {
		return addEditDate;
	}

	/**
	 * Set the value related to the column: add_edit_date
	 * @param addEditDate the add_edit_date value
	 */
	public void setAddEditDate (java.util.Date addEditDate) {
		this.addEditDate = addEditDate;
	}



	/**
	 * Return the value associated with the column: add_edit_time
	 */
	public java.lang.String getAddEditTime () {
		return addEditTime;
	}

	/**
	 * Set the value related to the column: add_edit_time
	 * @param addEditTime the add_edit_time value
	 */
	public void setAddEditTime (java.lang.String addEditTime) {
		this.addEditTime = addEditTime;
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
	 * Return the value associated with the column: mother_hin_no
	 */
	public java.lang.String getMotherHinNo () {
		return motherHinNo;
	}

	/**
	 * Set the value related to the column: mother_hin_no
	 * @param motherHinNo the mother_hin_no value
	 */
	public void setMotherHinNo (java.lang.String motherHinNo) {
		this.motherHinNo = motherHinNo;
	}



	/**
	 * Return the value associated with the column: service_card_validity_date
	 */
	public java.util.Date getServiceCardValidityDate () {
		return serviceCardValidityDate;
	}

	/**
	 * Set the value related to the column: service_card_validity_date
	 * @param serviceCardValidityDate the service_card_validity_date value
	 */
	public void setServiceCardValidityDate (java.util.Date serviceCardValidityDate) {
		this.serviceCardValidityDate = serviceCardValidityDate;
	}



	/**
	 * Return the value associated with the column: dependent_card_issue_date
	 */
	public java.util.Date getDependentCardIssueDate () {
		return dependentCardIssueDate;
	}

	/**
	 * Set the value related to the column: dependent_card_issue_date
	 * @param dependentCardIssueDate the dependent_card_issue_date value
	 */
	public void setDependentCardIssueDate (java.util.Date dependentCardIssueDate) {
		this.dependentCardIssueDate = dependentCardIssueDate;
	}



	/**
	 * Return the value associated with the column: service_card_status
	 */
	public java.lang.String getServiceCardStatus () {
		return serviceCardStatus;
	}

	/**
	 * Set the value related to the column: service_card_status
	 * @param serviceCardStatus the service_card_status value
	 */
	public void setServiceCardStatus (java.lang.String serviceCardStatus) {
		this.serviceCardStatus = serviceCardStatus;
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
	 * Return the value associated with the column: reg_date
	 */
	public java.util.Date getRegDate () {
		return regDate;
	}

	/**
	 * Set the value related to the column: reg_date
	 * @param regDate the reg_date value
	 */
	public void setRegDate (java.util.Date regDate) {
		this.regDate = regDate;
	}



	/**
	 * Return the value associated with the column: reg_time
	 */
	public java.lang.String getRegTime () {
		return regTime;
	}

	/**
	 * Set the value related to the column: reg_time
	 * @param regTime the reg_time value
	 */
	public void setRegTime (java.lang.String regTime) {
		this.regTime = regTime;
	}



	/**
	 * Return the value associated with the column: suffix
	 */
	public java.lang.String getSuffix () {
		return suffix;
	}

	/**
	 * Set the value related to the column: suffix
	 * @param suffix the suffix value
	 */
	public void setSuffix (java.lang.String suffix) {
		this.suffix = suffix;
	}



	/**
	 * Return the value associated with the column: old_hin_no
	 */
	public java.lang.String getOldHinNo () {
		return oldHinNo;
	}

	/**
	 * Set the value related to the column: old_hin_no
	 * @param oldHinNo the old_hin_no value
	 */
	public void setOldHinNo (java.lang.String oldHinNo) {
		this.oldHinNo = oldHinNo;
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
	 * Return the value associated with the column: total_service_period
	 */
	public java.lang.String getTotalServicePeriod () {
		return totalServicePeriod;
	}

	/**
	 * Set the value related to the column: total_service_period
	 * @param totalServicePeriod the total_service_period value
	 */
	public void setTotalServicePeriod (java.lang.String totalServicePeriod) {
		this.totalServicePeriod = totalServicePeriod;
	}



	/**
	 * Return the value associated with the column: prefix
	 */
	public java.lang.String getPrefix () {
		return prefix;
	}

	/**
	 * Set the value related to the column: prefix
	 * @param prefix the prefix value
	 */
	public void setPrefix (java.lang.String prefix) {
		this.prefix = prefix;
	}



	/**
	 * Return the value associated with the column: echs_no
	 */
	public java.lang.String getEchsNo () {
		return echsNo;
	}

	/**
	 * Set the value related to the column: echs_no
	 * @param echsNo the echs_no value
	 */
	public void setEchsNo (java.lang.String echsNo) {
		this.echsNo = echsNo;
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
	 * Return the value associated with the column: sr_dob
	 */
	public java.util.Date getSrDob () {
		return srDob;
	}

	/**
	 * Set the value related to the column: sr_dob
	 * @param srDob the sr_dob value
	 */
	public void setSrDob (java.util.Date srDob) {
		this.srDob = srDob;
	}



	/**
	 * Return the value associated with the column: sr_age
	 */
	public java.lang.String getSrAge () {
		return srAge;
	}

	/**
	 * Set the value related to the column: sr_age
	 * @param srAge the sr_age value
	 */
	public void setSrAge (java.lang.String srAge) {
		this.srAge = srAge;
	}



	/**
	 * Return the value associated with the column: contact_no
	 */
	public java.lang.String getContactNo () {
		return contactNo;
	}

	/**
	 * Set the value related to the column: contact_no
	 * @param contactNo the contact_no value
	 */
	public void setContactNo (java.lang.String contactNo) {
		this.contactNo = contactNo;
	}



	/**
	 * Return the value associated with the column: commission_date
	 */
	public java.util.Date getCommissionDate () {
		return commissionDate;
	}

	/**
	 * Set the value related to the column: commission_date
	 * @param commissionDate the commission_date value
	 */
	public void setCommissionDate (java.util.Date commissionDate) {
		this.commissionDate = commissionDate;
	}



	/**
	 * Return the value associated with the column: income
	 */
	public java.lang.String getIncome () {
		return income;
	}

	/**
	 * Set the value related to the column: income
	 * @param income the income value
	 */
	public void setIncome (java.lang.String income) {
		this.income = income;
	}



	/**
	 * Return the value associated with the column: dependency_date
	 */
	public java.util.Date getDependencyDate () {
		return dependencyDate;
	}

	/**
	 * Set the value related to the column: dependency_date
	 * @param dependencyDate the dependency_date value
	 */
	public void setDependencyDate (java.util.Date dependencyDate) {
		this.dependencyDate = dependencyDate;
	}



	/**
	 * Return the value associated with the column: authority
	 */
	public java.lang.String getAuthority () {
		return authority;
	}

	/**
	 * Set the value related to the column: authority
	 * @param authority the authority value
	 */
	public void setAuthority (java.lang.String authority) {
		this.authority = authority;
	}



	/**
	 * Return the value associated with the column: dependency_removal_date
	 */
	public java.util.Date getDependencyRemovalDate () {
		return dependencyRemovalDate;
	}

	/**
	 * Set the value related to the column: dependency_removal_date
	 * @param dependencyRemovalDate the dependency_removal_date value
	 */
	public void setDependencyRemovalDate (java.util.Date dependencyRemovalDate) {
		this.dependencyRemovalDate = dependencyRemovalDate;
	}



	/**
	 * Return the value associated with the column: afnet_no
	 */
	public java.lang.String getAfnetNo () {
		return afnetNo;
	}

	/**
	 * Set the value related to the column: afnet_no
	 * @param afnetNo the afnet_no value
	 */
	public void setAfnetNo (java.lang.String afnetNo) {
		this.afnetNo = afnetNo;
	}



	/**
	 * Return the value associated with the column: drug_allergies
	 */
	public java.lang.String getDrugAllergies () {
		return drugAllergies;
	}

	/**
	 * Set the value related to the column: drug_allergies
	 * @param drugAllergies the drug_allergies value
	 */
	public void setDrugAllergies (java.lang.String drugAllergies) {
		this.drugAllergies = drugAllergies;
	}



	/**
	 * Return the value associated with the column: smoker_less_10
	 */
	public java.lang.String getSmokerLess10 () {
		return smokerLess10;
	}

	/**
	 * Set the value related to the column: smoker_less_10
	 * @param smokerLess10 the smoker_less_10 value
	 */
	public void setSmokerLess10 (java.lang.String smokerLess10) {
		this.smokerLess10 = smokerLess10;
	}



	/**
	 * Return the value associated with the column: alcohol
	 */
	public java.lang.String getAlcohol () {
		return alcohol;
	}

	/**
	 * Set the value related to the column: alcohol
	 * @param alcohol the alcohol value
	 */
	public void setAlcohol (java.lang.String alcohol) {
		this.alcohol = alcohol;
	}



	/**
	 * Return the value associated with the column: permanent_address
	 */
	public java.lang.String getPermanentAddress () {
		return permanentAddress;
	}

	/**
	 * Set the value related to the column: permanent_address
	 * @param permanentAddress the permanent_address value
	 */
	public void setPermanentAddress (java.lang.String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}



	/**
	 * Return the value associated with the column: telephone_resi
	 */
	public java.lang.String getTelephoneResi () {
		return telephoneResi;
	}

	/**
	 * Set the value related to the column: telephone_resi
	 * @param telephoneResi the telephone_resi value
	 */
	public void setTelephoneResi (java.lang.String telephoneResi) {
		this.telephoneResi = telephoneResi;
	}



	/**
	 * Return the value associated with the column: other_contact_no
	 */
	public java.lang.String getOtherContactNo () {
		return otherContactNo;
	}

	/**
	 * Set the value related to the column: other_contact_no
	 * @param otherContactNo the other_contact_no value
	 */
	public void setOtherContactNo (java.lang.String otherContactNo) {
		this.otherContactNo = otherContactNo;
	}



	/**
	 * Return the value associated with the column: telephone_no_perm
	 */
	public java.lang.String getTelephoneNoPerm () {
		return telephoneNoPerm;
	}

	/**
	 * Set the value related to the column: telephone_no_perm
	 * @param telephoneNoPerm the telephone_no_perm value
	 */
	public void setTelephoneNoPerm (java.lang.String telephoneNoPerm) {
		this.telephoneNoPerm = telephoneNoPerm;
	}



	/**
	 * Return the value associated with the column: nok2_name
	 */
	public java.lang.String getNok2Name () {
		return nok2Name;
	}

	/**
	 * Set the value related to the column: nok2_name
	 * @param nok2Name the nok2_name value
	 */
	public void setNok2Name (java.lang.String nok2Name) {
		this.nok2Name = nok2Name;
	}



	/**
	 * Return the value associated with the column: nok2_address
	 */
	public java.lang.String getNok2Address () {
		return nok2Address;
	}

	/**
	 * Set the value related to the column: nok2_address
	 * @param nok2Address the nok2_address value
	 */
	public void setNok2Address (java.lang.String nok2Address) {
		this.nok2Address = nok2Address;
	}



	/**
	 * Return the value associated with the column: nok2_contact_no
	 */
	public java.lang.String getNok2ContactNo () {
		return nok2ContactNo;
	}

	/**
	 * Set the value related to the column: nok2_contact_no
	 * @param nok2ContactNo the nok2_contact_no value
	 */
	public void setNok2ContactNo (java.lang.String nok2ContactNo) {
		this.nok2ContactNo = nok2ContactNo;
	}



	/**
	 * Return the value associated with the column: smoker_more_10
	 */
	public java.lang.String getSmokerMore10 () {
		return smokerMore10;
	}

	/**
	 * Set the value related to the column: smoker_more_10
	 * @param smokerMore10 the smoker_more_10 value
	 */
	public void setSmokerMore10 (java.lang.String smokerMore10) {
		this.smokerMore10 = smokerMore10;
	}



	/**
	 * Return the value associated with the column: nok1_police_station
	 */
	public java.lang.String getNok1PoliceStation () {
		return nok1PoliceStation;
	}

	/**
	 * Set the value related to the column: nok1_police_station
	 * @param nok1PoliceStation the nok1_police_station value
	 */
	public void setNok1PoliceStation (java.lang.String nok1PoliceStation) {
		this.nok1PoliceStation = nok1PoliceStation;
	}



	/**
	 * Return the value associated with the column: nok1_pin_code
	 */
	public java.lang.String getNok1PinCode () {
		return nok1PinCode;
	}

	/**
	 * Set the value related to the column: nok1_pin_code
	 * @param nok1PinCode the nok1_pin_code value
	 */
	public void setNok1PinCode (java.lang.String nok1PinCode) {
		this.nok1PinCode = nok1PinCode;
	}



	/**
	 * Return the value associated with the column: nok2_police_station
	 */
	public java.lang.String getNok2PoliceStation () {
		return nok2PoliceStation;
	}

	/**
	 * Set the value related to the column: nok2_police_station
	 * @param nok2PoliceStation the nok2_police_station value
	 */
	public void setNok2PoliceStation (java.lang.String nok2PoliceStation) {
		this.nok2PoliceStation = nok2PoliceStation;
	}



	/**
	 * Return the value associated with the column: nok2_pin_code
	 */
	public java.lang.String getNok2PinCode () {
		return nok2PinCode;
	}

	/**
	 * Set the value related to the column: nok2_pin_code
	 * @param nok2PinCode the nok2_pin_code value
	 */
	public void setNok2PinCode (java.lang.String nok2PinCode) {
		this.nok2PinCode = nok2PinCode;
	}



	/**
	 * Return the value associated with the column: patient_image
	 */
	public byte[] getPatientImage () {
		return patientImage;
	}

	/**
	 * Set the value related to the column: patient_image
	 * @param patientImage the patient_image value
	 */
	public void setPatientImage (byte[] patientImage) {
		this.patientImage = patientImage;
	}



	/**
	 * Return the value associated with the column: image_file_extension
	 */
	public java.lang.String getImageFileExtension () {
		return imageFileExtension;
	}

	/**
	 * Set the value related to the column: image_file_extension
	 * @param imageFileExtension the image_file_extension value
	 */
	public void setImageFileExtension (java.lang.String imageFileExtension) {
		this.imageFileExtension = imageFileExtension;
	}



	/**
	 * Return the value associated with the column: file_name
	 */
	public java.lang.String getFileName () {
		return fileName;
	}

	/**
	 * Set the value related to the column: file_name
	 * @param fileName the file_name value
	 */
	public void setFileName (java.lang.String fileName) {
		this.fileName = fileName;
	}



	/**
	 * Return the value associated with the column: med_cat_period
	 */
	public java.lang.String getMedCatPeriod () {
		return medCatPeriod;
	}

	/**
	 * Set the value related to the column: med_cat_period
	 * @param medCatPeriod the med_cat_period value
	 */
	public void setMedCatPeriod (java.lang.String medCatPeriod) {
		this.medCatPeriod = medCatPeriod;
	}



	/**
	 * Return the value associated with the column: med_cat_date
	 */
	public java.util.Date getMedCatDate () {
		return medCatDate;
	}

	/**
	 * Set the value related to the column: med_cat_date
	 * @param medCatDate the med_cat_date value
	 */
	public void setMedCatDate (java.util.Date medCatDate) {
		this.medCatDate = medCatDate;
	}



	/**
	 * Return the value associated with the column: patient_image_date
	 */
	public java.util.Date getPatientImageDate () {
		return patientImageDate;
	}

	/**
	 * Set the value related to the column: patient_image_date
	 * @param patientImageDate the patient_image_date value
	 */
	public void setPatientImageDate (java.util.Date patientImageDate) {
		this.patientImageDate = patientImageDate;
	}



	/**
	 * Return the value associated with the column: patient_image_time
	 */
	public java.lang.String getPatientImageTime () {
		return patientImageTime;
	}

	/**
	 * Set the value related to the column: patient_image_time
	 * @param patientImageTime the patient_image_time value
	 */
	public void setPatientImageTime (java.lang.String patientImageTime) {
		this.patientImageTime = patientImageTime;
	}



	/**
	 * Return the value associated with the column: other_family_history
	 */
	public java.lang.String getOtherFamilyHistory () {
		return otherFamilyHistory;
	}

	/**
	 * Set the value related to the column: other_family_history
	 * @param otherFamilyHistory the other_family_history value
	 */
	public void setOtherFamilyHistory (java.lang.String otherFamilyHistory) {
		this.otherFamilyHistory = otherFamilyHistory;
	}



	/**
	 * Return the value associated with the column: sr_marriage_date
	 */
	public java.util.Date getSrMarriageDate () {
		return srMarriageDate;
	}

	/**
	 * Set the value related to the column: sr_marriage_date
	 * @param srMarriageDate the sr_marriage_date value
	 */
	public void setSrMarriageDate (java.util.Date srMarriageDate) {
		this.srMarriageDate = srMarriageDate;
	}



	/**
	 * Return the value associated with the column: dep_marriage_date
	 */
	public java.util.Date getDepMarriageDate () {
		return depMarriageDate;
	}

	/**
	 * Set the value related to the column: dep_marriage_date
	 * @param depMarriageDate the dep_marriage_date value
	 */
	public void setDepMarriageDate (java.util.Date depMarriageDate) {
		this.depMarriageDate = depMarriageDate;
	}



	/**
	 * Return the value associated with the column: sr_identification_mark1
	 */
	public java.lang.String getSrIdentificationMark1 () {
		return srIdentificationMark1;
	}

	/**
	 * Set the value related to the column: sr_identification_mark1
	 * @param srIdentificationMark1 the sr_identification_mark1 value
	 */
	public void setSrIdentificationMark1 (java.lang.String srIdentificationMark1) {
		this.srIdentificationMark1 = srIdentificationMark1;
	}



	/**
	 * Return the value associated with the column: sr_identification_mark2
	 */
	public java.lang.String getSrIdentificationMark2 () {
		return srIdentificationMark2;
	}

	/**
	 * Set the value related to the column: sr_identification_mark2
	 * @param srIdentificationMark2 the sr_identification_mark2 value
	 */
	public void setSrIdentificationMark2 (java.lang.String srIdentificationMark2) {
		this.srIdentificationMark2 = srIdentificationMark2;
	}



	/**
	 * Return the value associated with the column: dep_identification_mark1
	 */
	public java.lang.String getDepIdentificationMark1 () {
		return depIdentificationMark1;
	}

	/**
	 * Set the value related to the column: dep_identification_mark1
	 * @param depIdentificationMark1 the dep_identification_mark1 value
	 */
	public void setDepIdentificationMark1 (java.lang.String depIdentificationMark1) {
		this.depIdentificationMark1 = depIdentificationMark1;
	}



	/**
	 * Return the value associated with the column: dep_identification_mark2
	 */
	public java.lang.String getDepIdentificationMark2 () {
		return depIdentificationMark2;
	}

	/**
	 * Set the value related to the column: dep_identification_mark2
	 * @param depIdentificationMark2 the dep_identification_mark2 value
	 */
	public void setDepIdentificationMark2 (java.lang.String depIdentificationMark2) {
		this.depIdentificationMark2 = depIdentificationMark2;
	}



	/**
	 * Return the value associated with the column: HL7_flag
	 */
	public java.lang.String getHl7Flag () {
		return hl7Flag;
	}

	/**
	 * Set the value related to the column: HL7_flag
	 * @param hl7Flag the HL7_flag value
	 */
	public void setHl7Flag (java.lang.String hl7Flag) {
		this.hl7Flag = hl7Flag;
	}



	/**
	 * Return the value associated with the column: previous_hin_no
	 */
	public java.lang.String getPreviousHinNo () {
		return previousHinNo;
	}

	/**
	 * Set the value related to the column: previous_hin_no
	 * @param previousHinNo the previous_hin_no value
	 */
	public void setPreviousHinNo (java.lang.String previousHinNo) {
		this.previousHinNo = previousHinNo;
	}



	/**
	 * Return the value associated with the column: billable
	 */
	public java.lang.String getBillable () {
		return billable;
	}

	/**
	 * Set the value related to the column: billable
	 * @param billable the billable value
	 */
	public void setBillable (java.lang.String billable) {
		this.billable = billable;
	}



	/**
	 * Return the value associated with the column: payment_status
	 */
	public java.lang.String getPaymentStatus () {
		return paymentStatus;
	}

	/**
	 * Set the value related to the column: payment_status
	 * @param paymentStatus the payment_status value
	 */
	public void setPaymentStatus (java.lang.String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}



	/**
	 * Return the value associated with the column: visit_created
	 */
	public java.lang.String getVisitCreated () {
		return visitCreated;
	}

	/**
	 * Set the value related to the column: visit_created
	 * @param visitCreated the visit_created value
	 */
	public void setVisitCreated (java.lang.String visitCreated) {
		this.visitCreated = visitCreated;
	}



	/**
	 * Return the value associated with the column: newBornBaby
	 */
	public java.lang.String getNewBornBaby () {
		return newBornBaby;
	}

	/**
	 * Set the value related to the column: newBornBaby
	 * @param newBornBaby the newBornBaby value
	 */
	public void setNewBornBaby (java.lang.String newBornBaby) {
		this.newBornBaby = newBornBaby;
	}



	/**
	 * Return the value associated with the column: service_status_id
	 */
	public jkt.hms.masters.business.MasServiceStatus getServiceStatus () {
		return serviceStatus;
	}

	/**
	 * Set the value related to the column: service_status_id
	 * @param serviceStatus the service_status_id value
	 */
	public void setServiceStatus (jkt.hms.masters.business.MasServiceStatus serviceStatus) {
		this.serviceStatus = serviceStatus;
	}



	/**
	 * Return the value associated with the column: sr_blood_group_id
	 */
	public jkt.hms.masters.business.MasBloodGroup getSrBloodGroup () {
		return srBloodGroup;
	}

	/**
	 * Set the value related to the column: sr_blood_group_id
	 * @param srBloodGroup the sr_blood_group_id value
	 */
	public void setSrBloodGroup (jkt.hms.masters.business.MasBloodGroup srBloodGroup) {
		this.srBloodGroup = srBloodGroup;
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
	 * Return the value associated with the column: marital_status_id
	 */
	public jkt.hms.masters.business.MasMaritalStatus getMaritalStatus () {
		return maritalStatus;
	}

	/**
	 * Set the value related to the column: marital_status_id
	 * @param maritalStatus the marital_status_id value
	 */
	public void setMaritalStatus (jkt.hms.masters.business.MasMaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}



	/**
	 * Return the value associated with the column: next_of_kin_relation_id
	 */
	public jkt.hms.masters.business.MasRelation getNextOfKinRelation () {
		return nextOfKinRelation;
	}

	/**
	 * Set the value related to the column: next_of_kin_relation_id
	 * @param nextOfKinRelation the next_of_kin_relation_id value
	 */
	public void setNextOfKinRelation (jkt.hms.masters.business.MasRelation nextOfKinRelation) {
		this.nextOfKinRelation = nextOfKinRelation;
	}



	/**
	 * Return the value associated with the column: add_edit_by_id
	 */
	public jkt.hms.masters.business.Users getAddEditBy () {
		return addEditBy;
	}

	/**
	 * Set the value related to the column: add_edit_by_id
	 * @param addEditBy the add_edit_by_id value
	 */
	public void setAddEditBy (jkt.hms.masters.business.Users addEditBy) {
		this.addEditBy = addEditBy;
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
	 * Return the value associated with the column: command_id
	 */
	public jkt.hms.masters.business.MasCommand getCommand () {
		return command;
	}

	/**
	 * Set the value related to the column: command_id
	 * @param command the command_id value
	 */
	public void setCommand (jkt.hms.masters.business.MasCommand command) {
		this.command = command;
	}



	/**
	 * Return the value associated with the column: administrative_sex_id
	 */
	public jkt.hms.masters.business.MasAdministrativeSex getAdministrativeSex () {
		return administrativeSex;
	}

	/**
	 * Set the value related to the column: administrative_sex_id
	 * @param administrativeSex the administrative_sex_id value
	 */
	public void setAdministrativeSex (jkt.hms.masters.business.MasAdministrativeSex administrativeSex) {
		this.administrativeSex = administrativeSex;
	}



	/**
	 * Return the value associated with the column: state_id
	 */
	public jkt.hms.masters.business.MasState getState () {
		return state;
	}

	/**
	 * Set the value related to the column: state_id
	 * @param state the state_id value
	 */
	public void setState (jkt.hms.masters.business.MasState state) {
		this.state = state;
	}



	/**
	 * Return the value associated with the column: patient_type_id
	 */
	public jkt.hms.masters.business.MasPatientType getPatientType () {
		return patientType;
	}

	/**
	 * Set the value related to the column: patient_type_id
	 * @param patientType the patient_type_id value
	 */
	public void setPatientType (jkt.hms.masters.business.MasPatientType patientType) {
		this.patientType = patientType;
	}



	/**
	 * Return the value associated with the column: religion_id
	 */
	public jkt.hms.masters.business.MasReligion getReligion () {
		return religion;
	}

	/**
	 * Set the value related to the column: religion_id
	 * @param religion the religion_id value
	 */
	public void setReligion (jkt.hms.masters.business.MasReligion religion) {
		this.religion = religion;
	}



	/**
	 * Return the value associated with the column: record_office_address_id
	 */
	public jkt.hms.masters.business.MasRecordOfficeAddress getRecordOfficeAddress () {
		return recordOfficeAddress;
	}

	/**
	 * Set the value related to the column: record_office_address_id
	 * @param recordOfficeAddress the record_office_address_id value
	 */
	public void setRecordOfficeAddress (jkt.hms.masters.business.MasRecordOfficeAddress recordOfficeAddress) {
		this.recordOfficeAddress = recordOfficeAddress;
	}



	/**
	 * Return the value associated with the column: permanent_state_id
	 */
	public jkt.hms.masters.business.MasState getPermanentState () {
		return permanentState;
	}

	/**
	 * Set the value related to the column: permanent_state_id
	 * @param permanentState the permanent_state_id value
	 */
	public void setPermanentState (jkt.hms.masters.business.MasState permanentState) {
		this.permanentState = permanentState;
	}



	/**
	 * Return the value associated with the column: occupation_id
	 */
	public jkt.hms.masters.business.MasOccupation getOccupation () {
		return occupation;
	}

	/**
	 * Set the value related to the column: occupation_id
	 * @param occupation the occupation_id value
	 */
	public void setOccupation (jkt.hms.masters.business.MasOccupation occupation) {
		this.occupation = occupation;
	}



	/**
	 * Return the value associated with the column: reference_id
	 */
	public jkt.hms.masters.business.MasReference getReference () {
		return reference;
	}

	/**
	 * Set the value related to the column: reference_id
	 * @param reference the reference_id value
	 */
	public void setReference (jkt.hms.masters.business.MasReference reference) {
		this.reference = reference;
	}



	/**
	 * Return the value associated with the column: permanent_city
	 */
	public jkt.hms.masters.business.MasDistrict getPermanentCity () {
		return permanentCity;
	}

	/**
	 * Set the value related to the column: permanent_city
	 * @param permanentCity the permanent_city value
	 */
	public void setPermanentCity (jkt.hms.masters.business.MasDistrict permanentCity) {
		this.permanentCity = permanentCity;
	}



	/**
	 * Return the value associated with the column: user_id
	 */
	public jkt.hms.masters.business.Users getUser () {
		return user;
	}

	/**
	 * Set the value related to the column: user_id
	 * @param user the user_id value
	 */
	public void setUser (jkt.hms.masters.business.Users user) {
		this.user = user;
	}



	/**
	 * Return the value associated with the column: sr_sex
	 */
	public jkt.hms.masters.business.MasAdministrativeSex getSrSex () {
		return srSex;
	}

	/**
	 * Set the value related to the column: sr_sex
	 * @param srSex the sr_sex value
	 */
	public void setSrSex (jkt.hms.masters.business.MasAdministrativeSex srSex) {
		this.srSex = srSex;
	}



	/**
	 * Return the value associated with the column: blood_group_id
	 */
	public jkt.hms.masters.business.MasBloodGroup getBloodGroup () {
		return bloodGroup;
	}

	/**
	 * Set the value related to the column: blood_group_id
	 * @param bloodGroup the blood_group_id value
	 */
	public void setBloodGroup (jkt.hms.masters.business.MasBloodGroup bloodGroup) {
		this.bloodGroup = bloodGroup;
	}



	/**
	 * Return the value associated with the column: country_id
	 */
	public jkt.hms.masters.business.MasCountry getCountry () {
		return country;
	}

	/**
	 * Set the value related to the column: country_id
	 * @param country the country_id value
	 */
	public void setCountry (jkt.hms.masters.business.MasCountry country) {
		this.country = country;
	}



	/**
	 * Return the value associated with the column: sr_marital_status_id
	 */
	public jkt.hms.masters.business.MasMaritalStatus getSrMaritalStatus () {
		return srMaritalStatus;
	}

	/**
	 * Set the value related to the column: sr_marital_status_id
	 * @param srMaritalStatus the sr_marital_status_id value
	 */
	public void setSrMaritalStatus (jkt.hms.masters.business.MasMaritalStatus srMaritalStatus) {
		this.srMaritalStatus = srMaritalStatus;
	}



	/**
	 * Return the value associated with the column: district_id
	 */
	public jkt.hms.masters.business.MasDistrict getDistrict () {
		return district;
	}

	/**
	 * Set the value related to the column: district_id
	 * @param district the district_id value
	 */
	public void setDistrict (jkt.hms.masters.business.MasDistrict district) {
		this.district = district;
	}



	/**
	 * Return the value associated with the column: category_id
	 */
	public jkt.hms.masters.business.Category getCategory () {
		return category;
	}

	/**
	 * Set the value related to the column: category_id
	 * @param category the category_id value
	 */
	public void setCategory (jkt.hms.masters.business.Category category) {
		this.category = category;
	}



	/**
	 * Return the value associated with the column: section_id
	 */
	public jkt.hms.masters.business.MasSection getSection () {
		return section;
	}

	/**
	 * Set the value related to the column: section_id
	 * @param section the section_id value
	 */
	public void setSection (jkt.hms.masters.business.MasSection section) {
		this.section = section;
	}



	/**
	 * Return the value associated with the column: post_code_id
	 */
	public jkt.hms.masters.business.MasPostCode getPostCode () {
		return postCode;
	}

	/**
	 * Set the value related to the column: post_code_id
	 * @param postCode the post_code_id value
	 */
	public void setPostCode (jkt.hms.masters.business.MasPostCode postCode) {
		this.postCode = postCode;
	}



	/**
	 * Return the value associated with the column: service_type_id
	 */
	public jkt.hms.masters.business.MasServiceType getServiceType () {
		return serviceType;
	}

	/**
	 * Set the value related to the column: service_type_id
	 * @param serviceType the service_type_id value
	 */
	public void setServiceType (jkt.hms.masters.business.MasServiceType serviceType) {
		this.serviceType = serviceType;
	}



	/**
	 * Return the value associated with the column: relation_id
	 */
	public jkt.hms.masters.business.MasRelation getRelation () {
		return relation;
	}

	/**
	 * Set the value related to the column: relation_id
	 * @param relation the relation_id value
	 */
	public void setRelation (jkt.hms.masters.business.MasRelation relation) {
		this.relation = relation;
	}



	/**
	 * Return the value associated with the column: approved_by
	 */
	public jkt.hms.masters.business.MasEmployee getApprovedBy () {
		return approvedBy;
	}

	/**
	 * Set the value related to the column: approved_by
	 * @param approvedBy the approved_by value
	 */
	public void setApprovedBy (jkt.hms.masters.business.MasEmployee approvedBy) {
		this.approvedBy = approvedBy;
	}



	/**
	 * Return the value associated with the column: family_history_id
	 */
	public jkt.hms.masters.business.PatientFamilyHistory getFamilyHistory () {
		return familyHistory;
	}

	/**
	 * Set the value related to the column: family_history_id
	 * @param familyHistory the family_history_id value
	 */
	public void setFamilyHistory (jkt.hms.masters.business.PatientFamilyHistory familyHistory) {
		this.familyHistory = familyHistory;
	}



	/**
	 * Return the value associated with the column: title_id
	 */
	public jkt.hms.masters.business.MasTitle getTitle () {
		return title;
	}

	/**
	 * Set the value related to the column: title_id
	 * @param title the title_id value
	 */
	public void setTitle (jkt.hms.masters.business.MasTitle title) {
		this.title = title;
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
	 * Return the value associated with the column: trade_id
	 */
	public jkt.hms.masters.business.MasTrade getTrade () {
		return trade;
	}

	/**
	 * Set the value related to the column: trade_id
	 * @param trade the trade_id value
	 */
	public void setTrade (jkt.hms.masters.business.MasTrade trade) {
		this.trade = trade;
	}



	/**
	 * Return the value associated with the column: nok2_relation_id
	 */
	public jkt.hms.masters.business.MasRelation getNok2Relation () {
		return nok2Relation;
	}

	/**
	 * Set the value related to the column: nok2_relation_id
	 * @param nok2Relation the nok2_relation_id value
	 */
	public void setNok2Relation (jkt.hms.masters.business.MasRelation nok2Relation) {
		this.nok2Relation = nok2Relation;
	}



	/**
	 * Return the value associated with the column: block_id
	 */
	public jkt.hms.masters.business.MasBlock getBlock () {
		return block;
	}

	/**
	 * Set the value related to the column: block_id
	 * @param block the block_id value
	 */
	public void setBlock (jkt.hms.masters.business.MasBlock block) {
		this.block = block;
	}



	/**
	 * Return the value associated with the column: others_category_id
	 */
	public jkt.hms.masters.business.MasOthersCategory getOthersCategory () {
		return othersCategory;
	}

	/**
	 * Set the value related to the column: others_category_id
	 * @param othersCategory the others_category_id value
	 */
	public void setOthersCategory (jkt.hms.masters.business.MasOthersCategory othersCategory) {
		this.othersCategory = othersCategory;
	}



	/**
	 * Return the value associated with the column: Discharges
	 */
	public java.util.Set<jkt.hms.masters.business.Discharge> getDischarges () {
		return discharges;
	}

	/**
	 * Set the value related to the column: Discharges
	 * @param discharges the Discharges value
	 */
	public void setDischarges (java.util.Set<jkt.hms.masters.business.Discharge> discharges) {
		this.discharges = discharges;
	}

	public void addToDischarges (jkt.hms.masters.business.Discharge discharge) {
		if (null == getDischarges()) setDischarges(new java.util.TreeSet<jkt.hms.masters.business.Discharge>());
		getDischarges().add(discharge);
	}



	/**
	 * Return the value associated with the column: IpdIntakeOutputs
	 */
	public java.util.Set<jkt.hms.masters.business.IpdIntakeOutput> getIpdIntakeOutputs () {
		return ipdIntakeOutputs;
	}

	/**
	 * Set the value related to the column: IpdIntakeOutputs
	 * @param ipdIntakeOutputs the IpdIntakeOutputs value
	 */
	public void setIpdIntakeOutputs (java.util.Set<jkt.hms.masters.business.IpdIntakeOutput> ipdIntakeOutputs) {
		this.ipdIntakeOutputs = ipdIntakeOutputs;
	}

	public void addToIpdIntakeOutputs (jkt.hms.masters.business.IpdIntakeOutput ipdIntakeOutput) {
		if (null == getIpdIntakeOutputs()) setIpdIntakeOutputs(new java.util.TreeSet<jkt.hms.masters.business.IpdIntakeOutput>());
		getIpdIntakeOutputs().add(ipdIntakeOutput);
	}



	/**
	 * Return the value associated with the column: MlcCases
	 */
	public java.util.Set<jkt.hms.masters.business.MlcCase> getMlcCases () {
		return mlcCases;
	}

	/**
	 * Set the value related to the column: MlcCases
	 * @param mlcCases the MlcCases value
	 */
	public void setMlcCases (java.util.Set<jkt.hms.masters.business.MlcCase> mlcCases) {
		this.mlcCases = mlcCases;
	}

	public void addToMlcCases (jkt.hms.masters.business.MlcCase mlcCase) {
		if (null == getMlcCases()) setMlcCases(new java.util.TreeSet<jkt.hms.masters.business.MlcCase>());
		getMlcCases().add(mlcCase);
	}



	/**
	 * Return the value associated with the column: DischargeSummaries
	 */
	public java.util.Set<jkt.hms.masters.business.DischargeSummary> getDischargeSummaries () {
		return dischargeSummaries;
	}

	/**
	 * Set the value related to the column: DischargeSummaries
	 * @param dischargeSummaries the DischargeSummaries value
	 */
	public void setDischargeSummaries (java.util.Set<jkt.hms.masters.business.DischargeSummary> dischargeSummaries) {
		this.dischargeSummaries = dischargeSummaries;
	}

	public void addToDischargeSummaries (jkt.hms.masters.business.DischargeSummary dischargeSummary) {
		if (null == getDischargeSummaries()) setDischargeSummaries(new java.util.TreeSet<jkt.hms.masters.business.DischargeSummary>());
		getDischargeSummaries().add(dischargeSummary);
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
	 * Return the value associated with the column: AppPatientAppointments
	 */
	public java.util.Set<jkt.hms.masters.business.AppPatientAppointments> getAppPatientAppointments () {
		return appPatientAppointments;
	}

	/**
	 * Set the value related to the column: AppPatientAppointments
	 * @param appPatientAppointments the AppPatientAppointments value
	 */
	public void setAppPatientAppointments (java.util.Set<jkt.hms.masters.business.AppPatientAppointments> appPatientAppointments) {
		this.appPatientAppointments = appPatientAppointments;
	}

	public void addToAppPatientAppointments (jkt.hms.masters.business.AppPatientAppointments appPatientAppointments) {
		if (null == getAppPatientAppointments()) setAppPatientAppointments(new java.util.TreeSet<jkt.hms.masters.business.AppPatientAppointments>());
		getAppPatientAppointments().add(appPatientAppointments);
	}



	/**
	 * Return the value associated with the column: Birthdeathregs
	 */
	public java.util.Set<jkt.hms.masters.business.Birthdeathreg> getBirthdeathregs () {
		return birthdeathregs;
	}

	/**
	 * Set the value related to the column: Birthdeathregs
	 * @param birthdeathregs the Birthdeathregs value
	 */
	public void setBirthdeathregs (java.util.Set<jkt.hms.masters.business.Birthdeathreg> birthdeathregs) {
		this.birthdeathregs = birthdeathregs;
	}

	public void addToBirthdeathregs (jkt.hms.masters.business.Birthdeathreg birthdeathreg) {
		if (null == getBirthdeathregs()) setBirthdeathregs(new java.util.TreeSet<jkt.hms.masters.business.Birthdeathreg>());
		getBirthdeathregs().add(birthdeathreg);
	}



	/**
	 * Return the value associated with the column: MisFrws
	 */
	public java.util.Set<jkt.hms.masters.business.MisFrw> getMisFrws () {
		return misFrws;
	}

	/**
	 * Set the value related to the column: MisFrws
	 * @param misFrws the MisFrws value
	 */
	public void setMisFrws (java.util.Set<jkt.hms.masters.business.MisFrw> misFrws) {
		this.misFrws = misFrws;
	}

	public void addToMisFrws (jkt.hms.masters.business.MisFrw misFrw) {
		if (null == getMisFrws()) setMisFrws(new java.util.TreeSet<jkt.hms.masters.business.MisFrw>());
		getMisFrws().add(misFrw);
	}



	/**
	 * Return the value associated with the column: StoreIssueMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreIssueM> getStoreIssueMs () {
		return storeIssueMs;
	}

	/**
	 * Set the value related to the column: StoreIssueMs
	 * @param storeIssueMs the StoreIssueMs value
	 */
	public void setStoreIssueMs (java.util.Set<jkt.hms.masters.business.StoreIssueM> storeIssueMs) {
		this.storeIssueMs = storeIssueMs;
	}

	public void addToStoreIssueMs (jkt.hms.masters.business.StoreIssueM storeIssueM) {
		if (null == getStoreIssueMs()) setStoreIssueMs(new java.util.TreeSet<jkt.hms.masters.business.StoreIssueM>());
		getStoreIssueMs().add(storeIssueM);
	}



	/**
	 * Return the value associated with the column: Ipdcaredetails
	 */
	public java.util.Set<jkt.hms.masters.business.Ipdcaredetail> getIpdcaredetails () {
		return ipdcaredetails;
	}

	/**
	 * Set the value related to the column: Ipdcaredetails
	 * @param ipdcaredetails the Ipdcaredetails value
	 */
	public void setIpdcaredetails (java.util.Set<jkt.hms.masters.business.Ipdcaredetail> ipdcaredetails) {
		this.ipdcaredetails = ipdcaredetails;
	}

	public void addToIpdcaredetails (jkt.hms.masters.business.Ipdcaredetail ipdcaredetail) {
		if (null == getIpdcaredetails()) setIpdcaredetails(new java.util.TreeSet<jkt.hms.masters.business.Ipdcaredetail>());
		getIpdcaredetails().add(ipdcaredetail);
	}



	/**
	 * Return the value associated with the column: BlReceipts
	 */
	public java.util.Set<jkt.hms.masters.business.BlReceipt> getBlReceipts () {
		return blReceipts;
	}

	/**
	 * Set the value related to the column: BlReceipts
	 * @param blReceipts the BlReceipts value
	 */
	public void setBlReceipts (java.util.Set<jkt.hms.masters.business.BlReceipt> blReceipts) {
		this.blReceipts = blReceipts;
	}

	public void addToBlReceipts (jkt.hms.masters.business.BlReceipt blReceipt) {
		if (null == getBlReceipts()) setBlReceipts(new java.util.TreeSet<jkt.hms.masters.business.BlReceipt>());
		getBlReceipts().add(blReceipt);
	}



	/**
	 * Return the value associated with the column: MisNotifiables
	 */
	public java.util.Set<jkt.hms.masters.business.MisNotifiable> getMisNotifiables () {
		return misNotifiables;
	}

	/**
	 * Set the value related to the column: MisNotifiables
	 * @param misNotifiables the MisNotifiables value
	 */
	public void setMisNotifiables (java.util.Set<jkt.hms.masters.business.MisNotifiable> misNotifiables) {
		this.misNotifiables = misNotifiables;
	}

	public void addToMisNotifiables (jkt.hms.masters.business.MisNotifiable misNotifiable) {
		if (null == getMisNotifiables()) setMisNotifiables(new java.util.TreeSet<jkt.hms.masters.business.MisNotifiable>());
		getMisNotifiables().add(misNotifiable);
	}



	/**
	 * Return the value associated with the column: StoreIpIssueMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreIpIssueM> getStoreIpIssueMs () {
		return storeIpIssueMs;
	}

	/**
	 * Set the value related to the column: StoreIpIssueMs
	 * @param storeIpIssueMs the StoreIpIssueMs value
	 */
	public void setStoreIpIssueMs (java.util.Set<jkt.hms.masters.business.StoreIpIssueM> storeIpIssueMs) {
		this.storeIpIssueMs = storeIpIssueMs;
	}

	public void addToStoreIpIssueMs (jkt.hms.masters.business.StoreIpIssueM storeIpIssueM) {
		if (null == getStoreIpIssueMs()) setStoreIpIssueMs(new java.util.TreeSet<jkt.hms.masters.business.StoreIpIssueM>());
		getStoreIpIssueMs().add(storeIpIssueM);
	}



	/**
	 * Return the value associated with the column: NursingcareSetups
	 */
	public java.util.Set<jkt.hms.masters.business.NursingcareSetup> getNursingcareSetups () {
		return nursingcareSetups;
	}

	/**
	 * Set the value related to the column: NursingcareSetups
	 * @param nursingcareSetups the NursingcareSetups value
	 */
	public void setNursingcareSetups (java.util.Set<jkt.hms.masters.business.NursingcareSetup> nursingcareSetups) {
		this.nursingcareSetups = nursingcareSetups;
	}

	public void addToNursingcareSetups (jkt.hms.masters.business.NursingcareSetup nursingcareSetup) {
		if (null == getNursingcareSetups()) setNursingcareSetups(new java.util.TreeSet<jkt.hms.masters.business.NursingcareSetup>());
		getNursingcareSetups().add(nursingcareSetup);
	}



	/**
	 * Return the value associated with the column: StoreOpPatientIssueMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreOpPatientIssueM> getStoreOpPatientIssueMs () {
		return storeOpPatientIssueMs;
	}

	/**
	 * Set the value related to the column: StoreOpPatientIssueMs
	 * @param storeOpPatientIssueMs the StoreOpPatientIssueMs value
	 */
	public void setStoreOpPatientIssueMs (java.util.Set<jkt.hms.masters.business.StoreOpPatientIssueM> storeOpPatientIssueMs) {
		this.storeOpPatientIssueMs = storeOpPatientIssueMs;
	}

	public void addToStoreOpPatientIssueMs (jkt.hms.masters.business.StoreOpPatientIssueM storeOpPatientIssueM) {
		if (null == getStoreOpPatientIssueMs()) setStoreOpPatientIssueMs(new java.util.TreeSet<jkt.hms.masters.business.StoreOpPatientIssueM>());
		getStoreOpPatientIssueMs().add(storeOpPatientIssueM);
	}



	/**
	 * Return the value associated with the column: DgOrderhds
	 */
	public java.util.Set<jkt.hms.masters.business.DgOrderhd> getDgOrderhds () {
		return dgOrderhds;
	}

	/**
	 * Set the value related to the column: DgOrderhds
	 * @param dgOrderhds the DgOrderhds value
	 */
	public void setDgOrderhds (java.util.Set<jkt.hms.masters.business.DgOrderhd> dgOrderhds) {
		this.dgOrderhds = dgOrderhds;
	}

	public void addToDgOrderhds (jkt.hms.masters.business.DgOrderhd dgOrderhd) {
		if (null == getDgOrderhds()) setDgOrderhds(new java.util.TreeSet<jkt.hms.masters.business.DgOrderhd>());
		getDgOrderhds().add(dgOrderhd);
	}



	/**
	 * Return the value associated with the column: IpdIntakeOutputCharts
	 */
	public java.util.Set<jkt.hms.masters.business.IpdIntakeOutputChart> getIpdIntakeOutputCharts () {
		return ipdIntakeOutputCharts;
	}

	/**
	 * Set the value related to the column: IpdIntakeOutputCharts
	 * @param ipdIntakeOutputCharts the IpdIntakeOutputCharts value
	 */
	public void setIpdIntakeOutputCharts (java.util.Set<jkt.hms.masters.business.IpdIntakeOutputChart> ipdIntakeOutputCharts) {
		this.ipdIntakeOutputCharts = ipdIntakeOutputCharts;
	}

	public void addToIpdIntakeOutputCharts (jkt.hms.masters.business.IpdIntakeOutputChart ipdIntakeOutputChart) {
		if (null == getIpdIntakeOutputCharts()) setIpdIntakeOutputCharts(new java.util.TreeSet<jkt.hms.masters.business.IpdIntakeOutputChart>());
		getIpdIntakeOutputCharts().add(ipdIntakeOutputChart);
	}



	/**
	 * Return the value associated with the column: IpdClinicalCharts
	 */
	public java.util.Set<jkt.hms.masters.business.IpdClinicalChart> getIpdClinicalCharts () {
		return ipdClinicalCharts;
	}

	/**
	 * Set the value related to the column: IpdClinicalCharts
	 * @param ipdClinicalCharts the IpdClinicalCharts value
	 */
	public void setIpdClinicalCharts (java.util.Set<jkt.hms.masters.business.IpdClinicalChart> ipdClinicalCharts) {
		this.ipdClinicalCharts = ipdClinicalCharts;
	}

	public void addToIpdClinicalCharts (jkt.hms.masters.business.IpdClinicalChart ipdClinicalChart) {
		if (null == getIpdClinicalCharts()) setIpdClinicalCharts(new java.util.TreeSet<jkt.hms.masters.business.IpdClinicalChart>());
		getIpdClinicalCharts().add(ipdClinicalChart);
	}



	/**
	 * Return the value associated with the column: Ipdclinicals
	 */
	public java.util.Set<jkt.hms.masters.business.Ipdclinical> getIpdclinicals () {
		return ipdclinicals;
	}

	/**
	 * Set the value related to the column: Ipdclinicals
	 * @param ipdclinicals the Ipdclinicals value
	 */
	public void setIpdclinicals (java.util.Set<jkt.hms.masters.business.Ipdclinical> ipdclinicals) {
		this.ipdclinicals = ipdclinicals;
	}

	public void addToIpdclinicals (jkt.hms.masters.business.Ipdclinical ipdclinical) {
		if (null == getIpdclinicals()) setIpdclinicals(new java.util.TreeSet<jkt.hms.masters.business.Ipdclinical>());
		getIpdclinicals().add(ipdclinical);
	}



	/**
	 * Return the value associated with the column: AttachInpatients
	 */
	public java.util.Set<jkt.hms.masters.business.AttachInpatient> getAttachInpatients () {
		return attachInpatients;
	}

	/**
	 * Set the value related to the column: AttachInpatients
	 * @param attachInpatients the AttachInpatients value
	 */
	public void setAttachInpatients (java.util.Set<jkt.hms.masters.business.AttachInpatient> attachInpatients) {
		this.attachInpatients = attachInpatients;
	}

	public void addToAttachInpatients (jkt.hms.masters.business.AttachInpatient attachInpatient) {
		if (null == getAttachInpatients()) setAttachInpatients(new java.util.TreeSet<jkt.hms.masters.business.AttachInpatient>());
		getAttachInpatients().add(attachInpatient);
	}



	/**
	 * Return the value associated with the column: Inpatients
	 */
	public java.util.Set<jkt.hms.masters.business.Inpatient> getInpatients () {
		return inpatients;
	}

	/**
	 * Set the value related to the column: Inpatients
	 * @param inpatients the Inpatients value
	 */
	public void setInpatients (java.util.Set<jkt.hms.masters.business.Inpatient> inpatients) {
		this.inpatients = inpatients;
	}

	public void addToInpatients (jkt.hms.masters.business.Inpatient inpatient) {
		if (null == getInpatients()) setInpatients(new java.util.TreeSet<jkt.hms.masters.business.Inpatient>());
		getInpatients().add(inpatient);
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



	/**
	 * Return the value associated with the column: BlOpBillMains
	 */
	public java.util.Set<jkt.hms.masters.business.BlOpBillMain> getBlOpBillMains () {
		return blOpBillMains;
	}

	/**
	 * Set the value related to the column: BlOpBillMains
	 * @param blOpBillMains the BlOpBillMains value
	 */
	public void setBlOpBillMains (java.util.Set<jkt.hms.masters.business.BlOpBillMain> blOpBillMains) {
		this.blOpBillMains = blOpBillMains;
	}

	public void addToBlOpBillMains (jkt.hms.masters.business.BlOpBillMain blOpBillMain) {
		if (null == getBlOpBillMains()) setBlOpBillMains(new java.util.TreeSet<jkt.hms.masters.business.BlOpBillMain>());
		getBlOpBillMains().add(blOpBillMain);
	}



	/**
	 * Return the value associated with the column: MisFatalTrackings
	 */
	public java.util.Set<jkt.hms.masters.business.MisFatalTracking> getMisFatalTrackings () {
		return misFatalTrackings;
	}

	/**
	 * Set the value related to the column: MisFatalTrackings
	 * @param misFatalTrackings the MisFatalTrackings value
	 */
	public void setMisFatalTrackings (java.util.Set<jkt.hms.masters.business.MisFatalTracking> misFatalTrackings) {
		this.misFatalTrackings = misFatalTrackings;
	}

	public void addToMisFatalTrackings (jkt.hms.masters.business.MisFatalTracking misFatalTracking) {
		if (null == getMisFatalTrackings()) setMisFatalTrackings(new java.util.TreeSet<jkt.hms.masters.business.MisFatalTracking>());
		getMisFatalTrackings().add(misFatalTracking);
	}



	/**
	 * Return the value associated with the column: Transfers
	 */
	public java.util.Set<jkt.hms.masters.business.Transfer> getTransfers () {
		return transfers;
	}

	/**
	 * Set the value related to the column: Transfers
	 * @param transfers the Transfers value
	 */
	public void setTransfers (java.util.Set<jkt.hms.masters.business.Transfer> transfers) {
		this.transfers = transfers;
	}

	public void addToTransfers (jkt.hms.masters.business.Transfer transfer) {
		if (null == getTransfers()) setTransfers(new java.util.TreeSet<jkt.hms.masters.business.Transfer>());
		getTransfers().add(transfer);
	}



	/**
	 * Return the value associated with the column: ExpiryDetails
	 */
	public java.util.Set<jkt.hms.masters.business.ExpiryDetails> getExpiryDetails () {
		return expiryDetails;
	}

	/**
	 * Set the value related to the column: ExpiryDetails
	 * @param expiryDetails the ExpiryDetails value
	 */
	public void setExpiryDetails (java.util.Set<jkt.hms.masters.business.ExpiryDetails> expiryDetails) {
		this.expiryDetails = expiryDetails;
	}

	public void addToExpiryDetails (jkt.hms.masters.business.ExpiryDetails expiryDetails) {
		if (null == getExpiryDetails()) setExpiryDetails(new java.util.TreeSet<jkt.hms.masters.business.ExpiryDetails>());
		getExpiryDetails().add(expiryDetails);
	}



	/**
	 * Return the value associated with the column: AllergyDetails
	 */
	public java.util.Set<jkt.hms.masters.business.AllergyDetail> getAllergyDetails () {
		return allergyDetails;
	}

	/**
	 * Set the value related to the column: AllergyDetails
	 * @param allergyDetails the AllergyDetails value
	 */
	public void setAllergyDetails (java.util.Set<jkt.hms.masters.business.AllergyDetail> allergyDetails) {
		this.allergyDetails = allergyDetails;
	}

	public void addToAllergyDetails (jkt.hms.masters.business.AllergyDetail allergyDetail) {
		if (null == getAllergyDetails()) setAllergyDetails(new java.util.TreeSet<jkt.hms.masters.business.AllergyDetail>());
		getAllergyDetails().add(allergyDetail);
	}



	/**
	 * Return the value associated with the column: MasMedicalExamFamilyHis
	 */
	public java.util.Set<jkt.hms.masters.business.MasMedicalExamFamilyHis> getMasMedicalExamFamilyHis () {
		return masMedicalExamFamilyHis;
	}

	/**
	 * Set the value related to the column: MasMedicalExamFamilyHis
	 * @param masMedicalExamFamilyHis the MasMedicalExamFamilyHis value
	 */
	public void setMasMedicalExamFamilyHis (java.util.Set<jkt.hms.masters.business.MasMedicalExamFamilyHis> masMedicalExamFamilyHis) {
		this.masMedicalExamFamilyHis = masMedicalExamFamilyHis;
	}

	public void addToMasMedicalExamFamilyHis (jkt.hms.masters.business.MasMedicalExamFamilyHis masMedicalExamFamilyHis) {
		if (null == getMasMedicalExamFamilyHis()) setMasMedicalExamFamilyHis(new java.util.TreeSet<jkt.hms.masters.business.MasMedicalExamFamilyHis>());
		getMasMedicalExamFamilyHis().add(masMedicalExamFamilyHis);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.Patient)) return false;
		else {
			jkt.hms.masters.business.Patient patient = (jkt.hms.masters.business.Patient) obj;
			if (null == this.getId() || null == patient.getId()) return false;
			else return (this.getId().equals(patient.getId()));
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
package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the store_indent_m table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="store_indent_m"
 */

public abstract class BaseStoreIndentM  implements Serializable {

	public static String REF = "StoreIndentM";
	public static String PROP_INSTALLATION_BY_FIRM_REQUIRED = "InstallationByFirmRequired";
	public static String PROP_PAC_JUSTIFICATION = "PacJustification";
	public static String PROP_REQUIRED_FORM = "RequiredForm";
	public static String PROP_INDENT_NO = "IndentNo";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_QTY = "Qty";
	public static String PROP_INDENT_CREATION_DATE = "IndentCreationDate";
	public static String PROP_EXISTING_FACILITIES = "ExistingFacilities";
	public static String PROP_CONSUMABLES_REQUIRED = "ConsumablesRequired";
	public static String PROP_SUPPLIED_BY = "SuppliedBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_MUST_ACCESSORIES = "MustAccessories";
	public static String PROP_STD_CODE = "StdCode";
	public static String PROP_COUNTRY_OF_ORIGIN = "CountryOfOrigin";
	public static String PROP_DOSE = "Dose";
	public static String PROP_INDENT_OPTION = "IndentOption";
	public static String PROP_LOCAL_FAX_NO = "LocalFaxNo";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_CODE_HEAD = "CodeHead";
	public static String PROP_PAC_FOREIGN_ADD = "PacForeignAdd";
	public static String PROP_MANUFACTURER_FULL_ADDRESS = "ManufacturerFullAddress";
	public static String PROP_CLINICAL_TRAIL = "ClinicalTrail";
	public static String PROP_FEEDBACK_ABOUT_THE_PERFORMANC = "FeedbackAboutThePerformanc";
	public static String PROP_PO = "Po";
	public static String PROP_ESSENTIAL_ACCESSORIES = "EssentialAccessories";
	public static String PROP_MMF_FOR_THE_YEAR = "MmfForTheYear";
	public static String PROP_ENCODED_DATE = "EncodedDate";
	public static String PROP_COST = "Cost";
	public static String PROP_INDENT_TYPE = "IndentType";
	public static String PROP_EMAIL = "Email";
	public static String PROP_ANNUAL_MAINT_CONTRACT_REQD = "AnnualMaintContractReqd";
	public static String PROP_IMPORTED = "Imported";
	public static String PROP_ITEM_REQ_DEPT = "ItemReqDept";
	public static String PROP_ID = "Id";
	public static String PROP_TELL_NO = "TellNo";
	public static String PROP_APPROXIMATE_TOTAL = "ApproximateTotal";
	public static String PROP_NO_OF_PATIENTS_WILL_BE_BENEFI = "NoOfPatientsWillBeBenefi";
	public static String PROP_LOCAL_ADDRESS = "LocalAddress";
	public static String PROP_AT_SO_NUMBER = "AtSoNumber";
	public static String PROP_DURATION_FOR_WHICH_REQD = "DurationForWhichReqd";
	public static String PROP_NRS = "Nrs";
	public static String PROP_DAY = "Day";
	public static String PROP_SELF_LIFE = "SelfLife";
	public static String PROP_INDIAN_AGENT_DELHI_ADDRESS = "IndianAgentDelhiAddress";
	public static String PROP_COURSE = "Course";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_PAC_EQPT = "PacEqpt";
	public static String PROP_AUTHORITY = "Authority";
	public static String PROP_DURATION = "Duration";
	public static String PROP_JUSTIFICATION_NIV = "JustificationNiv";
	public static String PROP_BRIEF_MENTION_OF_FUNCTIONS = "BriefMentionOfFunctions";
	public static String PROP_USERTRIALREQUIRED = "Usertrialrequired";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_PATIENT_DETAILS = "PatientDetails";
	public static String PROP_TURNKEY_REQUIRED = "TurnkeyRequired";
	public static String PROP_INDENT_RECEIVED_STATUS = "IndentReceivedStatus";
	public static String PROP_TRAINING_REQUIRED = "TrainingRequired";
	public static String PROP_PAC_SPECIFIC = "PacSpecific";
	public static String PROP_DURATION_TYPE = "DurationType";
	public static String PROP_FAX_NO = "FaxNo";
	public static String PROP_REFERENCE_OF_INDENTS = "ReferenceOfIndents";
	public static String PROP_LOCAL_EMAIL = "LocalEmail";
	public static String PROP_ENCODED_BY = "EncodedBy";
	public static String PROP_PAC_ATTACH_CERTIFICATE = "PacAttachCertificate";
	public static String PROP_SECTION = "Section";
	public static String PROP_STATUS = "Status";
	public static String PROP_JUSTIFICATION = "Justification";
	public static String PROP_LOCAL_STD_CODE = "LocalStdCode";
	public static String PROP_HOW_WAS_THE_WORK = "HowWasTheWork";
	public static String PROP_PVMS_ALREADY_PRESCRIBED = "PvmsAlreadyPrescribed";
	public static String PROP_CREATED_BY = "CreatedBy";
	public static String PROP_LOCAL_TELL_NO = "LocalTellNo";
	public static String PROP_DESIRABILITY_OF_OUT_SOURCING = "DesirabilityOfOutSourcing";
	public static String PROP_IF_YES_QTY = "IfYesQty";
	public static String PROP_INDENT_DATE = "IndentDate";


	// constructors
	public BaseStoreIndentM () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreIndentM (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseStoreIndentM (
		java.lang.Integer id,
		jkt.hms.masters.business.MasHospital hospital,
		jkt.hms.masters.business.MasDepartment department,
		java.lang.String indentNo,
		java.util.Date indentDate,
		java.lang.String indentType,
		java.lang.String status,
		java.lang.String imported) {

		this.setId(id);
		this.setHospital(hospital);
		this.setDepartment(department);
		this.setIndentNo(indentNo);
		this.setIndentDate(indentDate);
		this.setIndentType(indentType);
		this.setStatus(status);
		this.setImported(imported);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String indentNo;
	private java.util.Date indentDate;
	private java.lang.String requiredForm;
	private java.lang.String nrs;
	private java.lang.String indentType;
	private java.lang.String status;
	private java.lang.String encodedBy;
	private java.util.Date encodedDate;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String indentOption;
	private java.lang.String patientDetails;
	private java.lang.String justificationNiv;
	private java.lang.String pacJustification;
	private java.lang.String pacForeignAdd;
	private java.lang.String authority;
	private java.lang.Integer mmfForTheYear;
	private java.lang.String imported;
	private java.lang.String clinicalTrail;
	private java.lang.String pvmsAlreadyPrescribed;
	private java.math.BigDecimal cost;
	private java.math.BigDecimal qty;
	private java.lang.Integer dose;
	private java.lang.Integer day;
	private java.lang.String course;
	private java.lang.Integer duration;
	private java.lang.String durationType;
	private java.lang.String justification;
	private java.lang.String pacSpecific;
	private java.lang.String pacEqpt;
	private java.lang.String briefMentionOfFunctions;
	private java.lang.String existingFacilities;
	private java.lang.String howWasTheWork;
	private java.lang.String feedbackAboutThePerformanc;
	private java.lang.String noOfPatientsWillBeBenefi;
	private java.lang.String desirabilityOfOutSourcing;
	private java.lang.String manufacturerFullAddress;
	private java.lang.String countryOfOrigin;
	private java.lang.String indianAgentDelhiAddress;
	private java.lang.String stdCode;
	private java.lang.String mustAccessories;
	private java.lang.String essentialAccessories;
	private java.lang.String atSoNumber;
	private java.lang.String referenceOfIndents;
	private java.math.BigDecimal approximateTotal;
	private java.lang.String pacAttachCertificate;
	private java.lang.String consumablesRequired;
	private java.lang.String usertrialrequired;
	private java.lang.String installationByFirmRequired;
	private java.lang.String turnkeyRequired;
	private java.lang.String annualMaintContractReqd;
	private java.lang.String trainingRequired;
	private java.lang.Integer faxNo;
	private java.lang.String email;
	private java.lang.String localAddress;
	private java.lang.String localStdCode;
	private java.lang.Integer localFaxNo;
	private java.lang.String localEmail;
	private java.math.BigDecimal ifYesQty;
	private java.lang.Integer durationForWhichReqd;
	private java.lang.String tellNo;
	private java.lang.Integer localTellNo;
	private java.lang.String codeHead;
	private java.lang.String selfLife;
	private java.util.Date indentCreationDate;
	private java.lang.String indentReceivedStatus;

	// many to one
	private jkt.hms.masters.business.Users createdBy;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.StorePoHeader po;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment itemReqDept;
	private jkt.hms.masters.business.MasStoreAirForceDepot suppliedBy;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasStoreSection section;

	// collections
	private java.util.Set<jkt.hms.masters.business.StoreSupplyOrderEntry> storeSupplyOrderEntries;
	private java.util.Set<jkt.hms.masters.business.StoreIndentSocTracker> storeIndentSocTrackers;
	private java.util.Set<jkt.hms.masters.business.StoreGrnM> storeGrnMs;
	private java.util.Set<jkt.hms.masters.business.StoreIndentT> storeIndentTs;
	private java.util.Set<jkt.hms.masters.business.StoreDisposalM> storeDisposalMs;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="indent_id"
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
	 * Return the value associated with the column: indent_no
	 */
	public java.lang.String getIndentNo () {
		return indentNo;
	}

	/**
	 * Set the value related to the column: indent_no
	 * @param indentNo the indent_no value
	 */
	public void setIndentNo (java.lang.String indentNo) {
		this.indentNo = indentNo;
	}



	/**
	 * Return the value associated with the column: indent_date
	 */
	public java.util.Date getIndentDate () {
		return indentDate;
	}

	/**
	 * Set the value related to the column: indent_date
	 * @param indentDate the indent_date value
	 */
	public void setIndentDate (java.util.Date indentDate) {
		this.indentDate = indentDate;
	}



	/**
	 * Return the value associated with the column: required_form
	 */
	public java.lang.String getRequiredForm () {
		return requiredForm;
	}

	/**
	 * Set the value related to the column: required_form
	 * @param requiredForm the required_form value
	 */
	public void setRequiredForm (java.lang.String requiredForm) {
		this.requiredForm = requiredForm;
	}



	/**
	 * Return the value associated with the column: nrs
	 */
	public java.lang.String getNrs () {
		return nrs;
	}

	/**
	 * Set the value related to the column: nrs
	 * @param nrs the nrs value
	 */
	public void setNrs (java.lang.String nrs) {
		this.nrs = nrs;
	}



	/**
	 * Return the value associated with the column: indent_type
	 */
	public java.lang.String getIndentType () {
		return indentType;
	}

	/**
	 * Set the value related to the column: indent_type
	 * @param indentType the indent_type value
	 */
	public void setIndentType (java.lang.String indentType) {
		this.indentType = indentType;
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
	 * Return the value associated with the column: encoded_by
	 */
	public java.lang.String getEncodedBy () {
		return encodedBy;
	}

	/**
	 * Set the value related to the column: encoded_by
	 * @param encodedBy the encoded_by value
	 */
	public void setEncodedBy (java.lang.String encodedBy) {
		this.encodedBy = encodedBy;
	}



	/**
	 * Return the value associated with the column: encoded_date
	 */
	public java.util.Date getEncodedDate () {
		return encodedDate;
	}

	/**
	 * Set the value related to the column: encoded_date
	 * @param encodedDate the encoded_date value
	 */
	public void setEncodedDate (java.util.Date encodedDate) {
		this.encodedDate = encodedDate;
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
	 * Return the value associated with the column: indent_option
	 */
	public java.lang.String getIndentOption () {
		return indentOption;
	}

	/**
	 * Set the value related to the column: indent_option
	 * @param indentOption the indent_option value
	 */
	public void setIndentOption (java.lang.String indentOption) {
		this.indentOption = indentOption;
	}



	/**
	 * Return the value associated with the column: patient_details
	 */
	public java.lang.String getPatientDetails () {
		return patientDetails;
	}

	/**
	 * Set the value related to the column: patient_details
	 * @param patientDetails the patient_details value
	 */
	public void setPatientDetails (java.lang.String patientDetails) {
		this.patientDetails = patientDetails;
	}



	/**
	 * Return the value associated with the column: justification_niv
	 */
	public java.lang.String getJustificationNiv () {
		return justificationNiv;
	}

	/**
	 * Set the value related to the column: justification_niv
	 * @param justificationNiv the justification_niv value
	 */
	public void setJustificationNiv (java.lang.String justificationNiv) {
		this.justificationNiv = justificationNiv;
	}



	/**
	 * Return the value associated with the column: pac_justification
	 */
	public java.lang.String getPacJustification () {
		return pacJustification;
	}

	/**
	 * Set the value related to the column: pac_justification
	 * @param pacJustification the pac_justification value
	 */
	public void setPacJustification (java.lang.String pacJustification) {
		this.pacJustification = pacJustification;
	}



	/**
	 * Return the value associated with the column: pac_foreign_add
	 */
	public java.lang.String getPacForeignAdd () {
		return pacForeignAdd;
	}

	/**
	 * Set the value related to the column: pac_foreign_add
	 * @param pacForeignAdd the pac_foreign_add value
	 */
	public void setPacForeignAdd (java.lang.String pacForeignAdd) {
		this.pacForeignAdd = pacForeignAdd;
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
	 * Return the value associated with the column: mmf_for_the_year
	 */
	public java.lang.Integer getMmfForTheYear () {
		return mmfForTheYear;
	}

	/**
	 * Set the value related to the column: mmf_for_the_year
	 * @param mmfForTheYear the mmf_for_the_year value
	 */
	public void setMmfForTheYear (java.lang.Integer mmfForTheYear) {
		this.mmfForTheYear = mmfForTheYear;
	}



	/**
	 * Return the value associated with the column: imported
	 */
	public java.lang.String getImported () {
		return imported;
	}

	/**
	 * Set the value related to the column: imported
	 * @param imported the imported value
	 */
	public void setImported (java.lang.String imported) {
		this.imported = imported;
	}



	/**
	 * Return the value associated with the column: clinical_trail
	 */
	public java.lang.String getClinicalTrail () {
		return clinicalTrail;
	}

	/**
	 * Set the value related to the column: clinical_trail
	 * @param clinicalTrail the clinical_trail value
	 */
	public void setClinicalTrail (java.lang.String clinicalTrail) {
		this.clinicalTrail = clinicalTrail;
	}



	/**
	 * Return the value associated with the column: pvms_already_prescribed
	 */
	public java.lang.String getPvmsAlreadyPrescribed () {
		return pvmsAlreadyPrescribed;
	}

	/**
	 * Set the value related to the column: pvms_already_prescribed
	 * @param pvmsAlreadyPrescribed the pvms_already_prescribed value
	 */
	public void setPvmsAlreadyPrescribed (java.lang.String pvmsAlreadyPrescribed) {
		this.pvmsAlreadyPrescribed = pvmsAlreadyPrescribed;
	}



	/**
	 * Return the value associated with the column: cost
	 */
	public java.math.BigDecimal getCost () {
		return cost;
	}

	/**
	 * Set the value related to the column: cost
	 * @param cost the cost value
	 */
	public void setCost (java.math.BigDecimal cost) {
		this.cost = cost;
	}



	/**
	 * Return the value associated with the column: qty
	 */
	public java.math.BigDecimal getQty () {
		return qty;
	}

	/**
	 * Set the value related to the column: qty
	 * @param qty the qty value
	 */
	public void setQty (java.math.BigDecimal qty) {
		this.qty = qty;
	}



	/**
	 * Return the value associated with the column: dose
	 */
	public java.lang.Integer getDose () {
		return dose;
	}

	/**
	 * Set the value related to the column: dose
	 * @param dose the dose value
	 */
	public void setDose (java.lang.Integer dose) {
		this.dose = dose;
	}



	/**
	 * Return the value associated with the column: day
	 */
	public java.lang.Integer getDay () {
		return day;
	}

	/**
	 * Set the value related to the column: day
	 * @param day the day value
	 */
	public void setDay (java.lang.Integer day) {
		this.day = day;
	}



	/**
	 * Return the value associated with the column: course
	 */
	public java.lang.String getCourse () {
		return course;
	}

	/**
	 * Set the value related to the column: course
	 * @param course the course value
	 */
	public void setCourse (java.lang.String course) {
		this.course = course;
	}



	/**
	 * Return the value associated with the column: duration
	 */
	public java.lang.Integer getDuration () {
		return duration;
	}

	/**
	 * Set the value related to the column: duration
	 * @param duration the duration value
	 */
	public void setDuration (java.lang.Integer duration) {
		this.duration = duration;
	}



	/**
	 * Return the value associated with the column: duration_type
	 */
	public java.lang.String getDurationType () {
		return durationType;
	}

	/**
	 * Set the value related to the column: duration_type
	 * @param durationType the duration_type value
	 */
	public void setDurationType (java.lang.String durationType) {
		this.durationType = durationType;
	}



	/**
	 * Return the value associated with the column: justification
	 */
	public java.lang.String getJustification () {
		return justification;
	}

	/**
	 * Set the value related to the column: justification
	 * @param justification the justification value
	 */
	public void setJustification (java.lang.String justification) {
		this.justification = justification;
	}



	/**
	 * Return the value associated with the column: pac_specific
	 */
	public java.lang.String getPacSpecific () {
		return pacSpecific;
	}

	/**
	 * Set the value related to the column: pac_specific
	 * @param pacSpecific the pac_specific value
	 */
	public void setPacSpecific (java.lang.String pacSpecific) {
		this.pacSpecific = pacSpecific;
	}



	/**
	 * Return the value associated with the column: pac_eqpt
	 */
	public java.lang.String getPacEqpt () {
		return pacEqpt;
	}

	/**
	 * Set the value related to the column: pac_eqpt
	 * @param pacEqpt the pac_eqpt value
	 */
	public void setPacEqpt (java.lang.String pacEqpt) {
		this.pacEqpt = pacEqpt;
	}



	/**
	 * Return the value associated with the column: brief_mention_of_functions
	 */
	public java.lang.String getBriefMentionOfFunctions () {
		return briefMentionOfFunctions;
	}

	/**
	 * Set the value related to the column: brief_mention_of_functions
	 * @param briefMentionOfFunctions the brief_mention_of_functions value
	 */
	public void setBriefMentionOfFunctions (java.lang.String briefMentionOfFunctions) {
		this.briefMentionOfFunctions = briefMentionOfFunctions;
	}



	/**
	 * Return the value associated with the column: existing_facilities
	 */
	public java.lang.String getExistingFacilities () {
		return existingFacilities;
	}

	/**
	 * Set the value related to the column: existing_facilities
	 * @param existingFacilities the existing_facilities value
	 */
	public void setExistingFacilities (java.lang.String existingFacilities) {
		this.existingFacilities = existingFacilities;
	}



	/**
	 * Return the value associated with the column: how_was_the_work
	 */
	public java.lang.String getHowWasTheWork () {
		return howWasTheWork;
	}

	/**
	 * Set the value related to the column: how_was_the_work
	 * @param howWasTheWork the how_was_the_work value
	 */
	public void setHowWasTheWork (java.lang.String howWasTheWork) {
		this.howWasTheWork = howWasTheWork;
	}



	/**
	 * Return the value associated with the column: feedback_about_the_performanc
	 */
	public java.lang.String getFeedbackAboutThePerformanc () {
		return feedbackAboutThePerformanc;
	}

	/**
	 * Set the value related to the column: feedback_about_the_performanc
	 * @param feedbackAboutThePerformanc the feedback_about_the_performanc value
	 */
	public void setFeedbackAboutThePerformanc (java.lang.String feedbackAboutThePerformanc) {
		this.feedbackAboutThePerformanc = feedbackAboutThePerformanc;
	}



	/**
	 * Return the value associated with the column: no_of_patients_will_be_benefi
	 */
	public java.lang.String getNoOfPatientsWillBeBenefi () {
		return noOfPatientsWillBeBenefi;
	}

	/**
	 * Set the value related to the column: no_of_patients_will_be_benefi
	 * @param noOfPatientsWillBeBenefi the no_of_patients_will_be_benefi value
	 */
	public void setNoOfPatientsWillBeBenefi (java.lang.String noOfPatientsWillBeBenefi) {
		this.noOfPatientsWillBeBenefi = noOfPatientsWillBeBenefi;
	}



	/**
	 * Return the value associated with the column: desirability_of_out_sourcing
	 */
	public java.lang.String getDesirabilityOfOutSourcing () {
		return desirabilityOfOutSourcing;
	}

	/**
	 * Set the value related to the column: desirability_of_out_sourcing
	 * @param desirabilityOfOutSourcing the desirability_of_out_sourcing value
	 */
	public void setDesirabilityOfOutSourcing (java.lang.String desirabilityOfOutSourcing) {
		this.desirabilityOfOutSourcing = desirabilityOfOutSourcing;
	}



	/**
	 * Return the value associated with the column: manufacturer_Full_Address
	 */
	public java.lang.String getManufacturerFullAddress () {
		return manufacturerFullAddress;
	}

	/**
	 * Set the value related to the column: manufacturer_Full_Address
	 * @param manufacturerFullAddress the manufacturer_Full_Address value
	 */
	public void setManufacturerFullAddress (java.lang.String manufacturerFullAddress) {
		this.manufacturerFullAddress = manufacturerFullAddress;
	}



	/**
	 * Return the value associated with the column: country_of_origin
	 */
	public java.lang.String getCountryOfOrigin () {
		return countryOfOrigin;
	}

	/**
	 * Set the value related to the column: country_of_origin
	 * @param countryOfOrigin the country_of_origin value
	 */
	public void setCountryOfOrigin (java.lang.String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}



	/**
	 * Return the value associated with the column: indian_agent_delhi_address
	 */
	public java.lang.String getIndianAgentDelhiAddress () {
		return indianAgentDelhiAddress;
	}

	/**
	 * Set the value related to the column: indian_agent_delhi_address
	 * @param indianAgentDelhiAddress the indian_agent_delhi_address value
	 */
	public void setIndianAgentDelhiAddress (java.lang.String indianAgentDelhiAddress) {
		this.indianAgentDelhiAddress = indianAgentDelhiAddress;
	}



	/**
	 * Return the value associated with the column: std_code
	 */
	public java.lang.String getStdCode () {
		return stdCode;
	}

	/**
	 * Set the value related to the column: std_code
	 * @param stdCode the std_code value
	 */
	public void setStdCode (java.lang.String stdCode) {
		this.stdCode = stdCode;
	}



	/**
	 * Return the value associated with the column: must_accessories
	 */
	public java.lang.String getMustAccessories () {
		return mustAccessories;
	}

	/**
	 * Set the value related to the column: must_accessories
	 * @param mustAccessories the must_accessories value
	 */
	public void setMustAccessories (java.lang.String mustAccessories) {
		this.mustAccessories = mustAccessories;
	}



	/**
	 * Return the value associated with the column: essential_accessories
	 */
	public java.lang.String getEssentialAccessories () {
		return essentialAccessories;
	}

	/**
	 * Set the value related to the column: essential_accessories
	 * @param essentialAccessories the essential_accessories value
	 */
	public void setEssentialAccessories (java.lang.String essentialAccessories) {
		this.essentialAccessories = essentialAccessories;
	}



	/**
	 * Return the value associated with the column: at_so_number
	 */
	public java.lang.String getAtSoNumber () {
		return atSoNumber;
	}

	/**
	 * Set the value related to the column: at_so_number
	 * @param atSoNumber the at_so_number value
	 */
	public void setAtSoNumber (java.lang.String atSoNumber) {
		this.atSoNumber = atSoNumber;
	}



	/**
	 * Return the value associated with the column: reference_of_indents
	 */
	public java.lang.String getReferenceOfIndents () {
		return referenceOfIndents;
	}

	/**
	 * Set the value related to the column: reference_of_indents
	 * @param referenceOfIndents the reference_of_indents value
	 */
	public void setReferenceOfIndents (java.lang.String referenceOfIndents) {
		this.referenceOfIndents = referenceOfIndents;
	}



	/**
	 * Return the value associated with the column: approximate_total
	 */
	public java.math.BigDecimal getApproximateTotal () {
		return approximateTotal;
	}

	/**
	 * Set the value related to the column: approximate_total
	 * @param approximateTotal the approximate_total value
	 */
	public void setApproximateTotal (java.math.BigDecimal approximateTotal) {
		this.approximateTotal = approximateTotal;
	}



	/**
	 * Return the value associated with the column: pac_attach_certificate
	 */
	public java.lang.String getPacAttachCertificate () {
		return pacAttachCertificate;
	}

	/**
	 * Set the value related to the column: pac_attach_certificate
	 * @param pacAttachCertificate the pac_attach_certificate value
	 */
	public void setPacAttachCertificate (java.lang.String pacAttachCertificate) {
		this.pacAttachCertificate = pacAttachCertificate;
	}



	/**
	 * Return the value associated with the column: consumables_required
	 */
	public java.lang.String getConsumablesRequired () {
		return consumablesRequired;
	}

	/**
	 * Set the value related to the column: consumables_required
	 * @param consumablesRequired the consumables_required value
	 */
	public void setConsumablesRequired (java.lang.String consumablesRequired) {
		this.consumablesRequired = consumablesRequired;
	}



	/**
	 * Return the value associated with the column: usertrialrequired
	 */
	public java.lang.String getUsertrialrequired () {
		return usertrialrequired;
	}

	/**
	 * Set the value related to the column: usertrialrequired
	 * @param usertrialrequired the usertrialrequired value
	 */
	public void setUsertrialrequired (java.lang.String usertrialrequired) {
		this.usertrialrequired = usertrialrequired;
	}



	/**
	 * Return the value associated with the column: installation_by_firm_required
	 */
	public java.lang.String getInstallationByFirmRequired () {
		return installationByFirmRequired;
	}

	/**
	 * Set the value related to the column: installation_by_firm_required
	 * @param installationByFirmRequired the installation_by_firm_required value
	 */
	public void setInstallationByFirmRequired (java.lang.String installationByFirmRequired) {
		this.installationByFirmRequired = installationByFirmRequired;
	}



	/**
	 * Return the value associated with the column: turnkey_required
	 */
	public java.lang.String getTurnkeyRequired () {
		return turnkeyRequired;
	}

	/**
	 * Set the value related to the column: turnkey_required
	 * @param turnkeyRequired the turnkey_required value
	 */
	public void setTurnkeyRequired (java.lang.String turnkeyRequired) {
		this.turnkeyRequired = turnkeyRequired;
	}



	/**
	 * Return the value associated with the column: annual_maint_contract_reqd
	 */
	public java.lang.String getAnnualMaintContractReqd () {
		return annualMaintContractReqd;
	}

	/**
	 * Set the value related to the column: annual_maint_contract_reqd
	 * @param annualMaintContractReqd the annual_maint_contract_reqd value
	 */
	public void setAnnualMaintContractReqd (java.lang.String annualMaintContractReqd) {
		this.annualMaintContractReqd = annualMaintContractReqd;
	}



	/**
	 * Return the value associated with the column: training_required
	 */
	public java.lang.String getTrainingRequired () {
		return trainingRequired;
	}

	/**
	 * Set the value related to the column: training_required
	 * @param trainingRequired the training_required value
	 */
	public void setTrainingRequired (java.lang.String trainingRequired) {
		this.trainingRequired = trainingRequired;
	}



	/**
	 * Return the value associated with the column: fax_no
	 */
	public java.lang.Integer getFaxNo () {
		return faxNo;
	}

	/**
	 * Set the value related to the column: fax_no
	 * @param faxNo the fax_no value
	 */
	public void setFaxNo (java.lang.Integer faxNo) {
		this.faxNo = faxNo;
	}



	/**
	 * Return the value associated with the column: email
	 */
	public java.lang.String getEmail () {
		return email;
	}

	/**
	 * Set the value related to the column: email
	 * @param email the email value
	 */
	public void setEmail (java.lang.String email) {
		this.email = email;
	}



	/**
	 * Return the value associated with the column: local_address
	 */
	public java.lang.String getLocalAddress () {
		return localAddress;
	}

	/**
	 * Set the value related to the column: local_address
	 * @param localAddress the local_address value
	 */
	public void setLocalAddress (java.lang.String localAddress) {
		this.localAddress = localAddress;
	}



	/**
	 * Return the value associated with the column: local_std_code
	 */
	public java.lang.String getLocalStdCode () {
		return localStdCode;
	}

	/**
	 * Set the value related to the column: local_std_code
	 * @param localStdCode the local_std_code value
	 */
	public void setLocalStdCode (java.lang.String localStdCode) {
		this.localStdCode = localStdCode;
	}



	/**
	 * Return the value associated with the column: local_fax_no
	 */
	public java.lang.Integer getLocalFaxNo () {
		return localFaxNo;
	}

	/**
	 * Set the value related to the column: local_fax_no
	 * @param localFaxNo the local_fax_no value
	 */
	public void setLocalFaxNo (java.lang.Integer localFaxNo) {
		this.localFaxNo = localFaxNo;
	}



	/**
	 * Return the value associated with the column: local_email
	 */
	public java.lang.String getLocalEmail () {
		return localEmail;
	}

	/**
	 * Set the value related to the column: local_email
	 * @param localEmail the local_email value
	 */
	public void setLocalEmail (java.lang.String localEmail) {
		this.localEmail = localEmail;
	}



	/**
	 * Return the value associated with the column: if_yes_qty
	 */
	public java.math.BigDecimal getIfYesQty () {
		return ifYesQty;
	}

	/**
	 * Set the value related to the column: if_yes_qty
	 * @param ifYesQty the if_yes_qty value
	 */
	public void setIfYesQty (java.math.BigDecimal ifYesQty) {
		this.ifYesQty = ifYesQty;
	}



	/**
	 * Return the value associated with the column: duration_for_which_reqd
	 */
	public java.lang.Integer getDurationForWhichReqd () {
		return durationForWhichReqd;
	}

	/**
	 * Set the value related to the column: duration_for_which_reqd
	 * @param durationForWhichReqd the duration_for_which_reqd value
	 */
	public void setDurationForWhichReqd (java.lang.Integer durationForWhichReqd) {
		this.durationForWhichReqd = durationForWhichReqd;
	}



	/**
	 * Return the value associated with the column: tell_no
	 */
	public java.lang.String getTellNo () {
		return tellNo;
	}

	/**
	 * Set the value related to the column: tell_no
	 * @param tellNo the tell_no value
	 */
	public void setTellNo (java.lang.String tellNo) {
		this.tellNo = tellNo;
	}



	/**
	 * Return the value associated with the column: local_tell_no
	 */
	public java.lang.Integer getLocalTellNo () {
		return localTellNo;
	}

	/**
	 * Set the value related to the column: local_tell_no
	 * @param localTellNo the local_tell_no value
	 */
	public void setLocalTellNo (java.lang.Integer localTellNo) {
		this.localTellNo = localTellNo;
	}



	/**
	 * Return the value associated with the column: CODE_HEAD
	 */
	public java.lang.String getCodeHead () {
		return codeHead;
	}

	/**
	 * Set the value related to the column: CODE_HEAD
	 * @param codeHead the CODE_HEAD value
	 */
	public void setCodeHead (java.lang.String codeHead) {
		this.codeHead = codeHead;
	}



	/**
	 * Return the value associated with the column: self_life
	 */
	public java.lang.String getSelfLife () {
		return selfLife;
	}

	/**
	 * Set the value related to the column: self_life
	 * @param selfLife the self_life value
	 */
	public void setSelfLife (java.lang.String selfLife) {
		this.selfLife = selfLife;
	}



	/**
	 * Return the value associated with the column: indent_creation_date
	 */
	public java.util.Date getIndentCreationDate () {
		return indentCreationDate;
	}

	/**
	 * Set the value related to the column: indent_creation_date
	 * @param indentCreationDate the indent_creation_date value
	 */
	public void setIndentCreationDate (java.util.Date indentCreationDate) {
		this.indentCreationDate = indentCreationDate;
	}



	/**
	 * Return the value associated with the column: indent_received_status
	 */
	public java.lang.String getIndentReceivedStatus () {
		return indentReceivedStatus;
	}

	/**
	 * Set the value related to the column: indent_received_status
	 * @param indentReceivedStatus the indent_received_status value
	 */
	public void setIndentReceivedStatus (java.lang.String indentReceivedStatus) {
		this.indentReceivedStatus = indentReceivedStatus;
	}



	/**
	 * Return the value associated with the column: created_by
	 */
	public jkt.hms.masters.business.Users getCreatedBy () {
		return createdBy;
	}

	/**
	 * Set the value related to the column: created_by
	 * @param createdBy the created_by value
	 */
	public void setCreatedBy (jkt.hms.masters.business.Users createdBy) {
		this.createdBy = createdBy;
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
	 * Return the value associated with the column: po_id
	 */
	public jkt.hms.masters.business.StorePoHeader getPo () {
		return po;
	}

	/**
	 * Set the value related to the column: po_id
	 * @param po the po_id value
	 */
	public void setPo (jkt.hms.masters.business.StorePoHeader po) {
		this.po = po;
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
	 * Return the value associated with the column: item_req_dept
	 */
	public jkt.hms.masters.business.MasDepartment getItemReqDept () {
		return itemReqDept;
	}

	/**
	 * Set the value related to the column: item_req_dept
	 * @param itemReqDept the item_req_dept value
	 */
	public void setItemReqDept (jkt.hms.masters.business.MasDepartment itemReqDept) {
		this.itemReqDept = itemReqDept;
	}



	/**
	 * Return the value associated with the column: supplied_by
	 */
	public jkt.hms.masters.business.MasStoreAirForceDepot getSuppliedBy () {
		return suppliedBy;
	}

	/**
	 * Set the value related to the column: supplied_by
	 * @param suppliedBy the supplied_by value
	 */
	public void setSuppliedBy (jkt.hms.masters.business.MasStoreAirForceDepot suppliedBy) {
		this.suppliedBy = suppliedBy;
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
	 * Return the value associated with the column: section
	 */
	public jkt.hms.masters.business.MasStoreSection getSection () {
		return section;
	}

	/**
	 * Set the value related to the column: section
	 * @param section the section value
	 */
	public void setSection (jkt.hms.masters.business.MasStoreSection section) {
		this.section = section;
	}



	/**
	 * Return the value associated with the column: StoreSupplyOrderEntries
	 */
	public java.util.Set<jkt.hms.masters.business.StoreSupplyOrderEntry> getStoreSupplyOrderEntries () {
		return storeSupplyOrderEntries;
	}

	/**
	 * Set the value related to the column: StoreSupplyOrderEntries
	 * @param storeSupplyOrderEntries the StoreSupplyOrderEntries value
	 */
	public void setStoreSupplyOrderEntries (java.util.Set<jkt.hms.masters.business.StoreSupplyOrderEntry> storeSupplyOrderEntries) {
		this.storeSupplyOrderEntries = storeSupplyOrderEntries;
	}



	/**
	 * Return the value associated with the column: StoreIndentSocTrackers
	 */
	public java.util.Set<jkt.hms.masters.business.StoreIndentSocTracker> getStoreIndentSocTrackers () {
		return storeIndentSocTrackers;
	}

	/**
	 * Set the value related to the column: StoreIndentSocTrackers
	 * @param storeIndentSocTrackers the StoreIndentSocTrackers value
	 */
	public void setStoreIndentSocTrackers (java.util.Set<jkt.hms.masters.business.StoreIndentSocTracker> storeIndentSocTrackers) {
		this.storeIndentSocTrackers = storeIndentSocTrackers;
	}



	/**
	 * Return the value associated with the column: StoreGrnMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreGrnM> getStoreGrnMs () {
		return storeGrnMs;
	}

	/**
	 * Set the value related to the column: StoreGrnMs
	 * @param storeGrnMs the StoreGrnMs value
	 */
	public void setStoreGrnMs (java.util.Set<jkt.hms.masters.business.StoreGrnM> storeGrnMs) {
		this.storeGrnMs = storeGrnMs;
	}



	/**
	 * Return the value associated with the column: StoreIndentTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreIndentT> getStoreIndentTs () {
		return storeIndentTs;
	}

	/**
	 * Set the value related to the column: StoreIndentTs
	 * @param storeIndentTs the StoreIndentTs value
	 */
	public void setStoreIndentTs (java.util.Set<jkt.hms.masters.business.StoreIndentT> storeIndentTs) {
		this.storeIndentTs = storeIndentTs;
	}



	/**
	 * Return the value associated with the column: StoreDisposalMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreDisposalM> getStoreDisposalMs () {
		return storeDisposalMs;
	}

	/**
	 * Set the value related to the column: StoreDisposalMs
	 * @param storeDisposalMs the StoreDisposalMs value
	 */
	public void setStoreDisposalMs (java.util.Set<jkt.hms.masters.business.StoreDisposalM> storeDisposalMs) {
		this.storeDisposalMs = storeDisposalMs;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreIndentM)) return false;
		else {
			jkt.hms.masters.business.StoreIndentM storeIndentM = (jkt.hms.masters.business.StoreIndentM) obj;
			if (null == this.getId() || null == storeIndentM.getId()) return false;
			else return (this.getId().equals(storeIndentM.getId()));
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
package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_personnel_details
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="mas_personnel_details"
 */

public abstract class BaseMasPersonnelDetails implements Serializable {

	public static String REF = "MasPersonnelDetails";
	public static String PROP_PRESENT_PIN = "PresentPin";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_DESIGNATION = "Designation";
	public static String PROP_HEIGHT = "Height";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_SFX = "Sfx";
	public static String PROP_TOTAL_SERVICE_WITHOUT_EOL_MONTHS = "TotalServiceWithoutEolMonths";
	public static String PROP_PASS_NO = "PassNo";
	public static String PROP_IDENTIFICATION_MARK = "IdentificationMark";
	public static String PROP_RETIREMENT_DATE = "RetirementDate";
	public static String PROP_RELIGION = "Religion";
	public static String PROP_APPOINTMENT_DATE = "AppointmentDate";
	public static String PROP_POSTED_OUT = "PostedOut";
	public static String PROP_PERMANENT_PIN = "PermanentPin";
	public static String PROP_POSTING_IN = "PostingIn";
	public static String PROP_PRESENT_ADDRESS = "PresentAddress";
	public static String PROP_PERSONNEL_NAME = "PersonnelName";
	public static String PROP_DATA_SHEET_STATUS = "DataSheetStatus";
	public static String PROP_FORM7_STATUS = "Form7Status";
	public static String PROP_DATE_OF_BIRTH = "DateOfBirth";
	public static String PROP_RETIREMENT_ENTRY_STATUS = "RetirementEntryStatus";
	public static String PROP_UNIT = "Unit";
	public static String PROP_PAY_SCALE = "PayScale";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_PERMANENT_ADDRESS = "PermanentAddress";
	public static String PROP_INCREMENT_DATE = "IncrementDate";
	public static String PROP_TOTAL_SERVICE_WITHOUT_EOL_DAYS = "TotalServiceWithoutEolDays";
	public static String PROP_TOTAL_SERVICE_WITHOUT_EOL_YEARS = "TotalServiceWithoutEolYears";
	public static String PROP_FORM8_STATUS = "Form8Status";
	public static String PROP_ADMINISTRATIVE_SEX = "AdministrativeSex";
	public static String PROP_BANK_ADDRESS = "BankAddress";
	public static String PROP_MARRIAGE_DATE = "MarriageDate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_FATHER_HUSBAND_NAME = "FatherHusbandName";
	public static String PROP_BANK_AC_NO = "BankAcNo";
	public static String PROP_ID = "Id";
	public static String PROP_CALCULATION_SHEET_STATUS = "CalculationSheetStatus";

	// constructors
	public BaseMasPersonnelDetails() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasPersonnelDetails(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String personnelName;
	private java.lang.Integer passNo;
	private java.lang.String bankAcNo;
	private java.lang.String identificationMark;
	private java.lang.Integer height;
	private java.lang.String sfx;
	private java.lang.String presentAddress;
	private java.lang.Integer presentPin;
	private java.lang.String permanentAddress;
	private java.lang.Integer permanentPin;
	private java.lang.String bankAddress;
	private java.lang.String fatherHusbandName;
	private java.lang.String payScale;
	private java.util.Date dateOfBirth;
	private java.util.Date appointmentDate;
	private java.util.Date postingIn;
	private java.util.Date incrementDate;
	private java.util.Date marriageDate;
	private java.util.Date retirementDate;
	private java.util.Date postedOut;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.Integer totalServiceWithoutEolYears;
	private java.lang.String dataSheetStatus;
	private java.lang.String calculationSheetStatus;
	private java.lang.String form7Status;
	private java.lang.String form8Status;
	private java.lang.String retirementEntryStatus;
	private java.lang.Integer totalServiceWithoutEolMonths;
	private java.lang.Integer totalServiceWithoutEolDays;

	// many to one
	private jkt.hms.masters.business.MasDesignation designation;
	private jkt.hms.masters.business.MasUnit unit;
	private jkt.hms.masters.business.MasAdministrativeSex administrativeSex;
	private jkt.hms.masters.business.MasReligion religion;
	private jkt.hms.masters.business.MasHospital hospital;

	// collections
	private java.util.Set<jkt.hms.masters.business.PensionForm7EmolumentsDetail> pensionForm7EmolumentsDetails;
	private java.util.Set<jkt.hms.masters.business.PensionEmoluments> pensionEmoluments;
	private java.util.Set<jkt.hms.masters.business.MasPersonnelFamilyDetails> masPersonnelFamilyDetails;
	private java.util.Set<jkt.hms.masters.business.PensionDataSheet> pensionDataSheets;
	private java.util.Set<jkt.hms.masters.business.PensionForm8Entry> pensionForm8Entries;
	private java.util.Set<jkt.hms.masters.business.PensionEol> pensionEols;
	private java.util.Set<jkt.hms.masters.business.PensionRetirementEntry> pensionRetirementEntries;
	private java.util.Set<jkt.hms.masters.business.PensionForm7Details> pensionForm7Details;
	private java.util.Set<jkt.hms.masters.business.PensionOtherServices> pensionOtherServices;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="personnel_id"
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
	 * Return the value associated with the column: personnel_name
	 */
	public java.lang.String getPersonnelName() {
		return personnelName;
	}

	/**
	 * Set the value related to the column: personnel_name
	 * 
	 * @param personnelName
	 *            the personnel_name value
	 */
	public void setPersonnelName(java.lang.String personnelName) {
		this.personnelName = personnelName;
	}

	/**
	 * Return the value associated with the column: pass_no
	 */
	public java.lang.Integer getPassNo() {
		return passNo;
	}

	/**
	 * Set the value related to the column: pass_no
	 * 
	 * @param passNo
	 *            the pass_no value
	 */
	public void setPassNo(java.lang.Integer passNo) {
		this.passNo = passNo;
	}

	/**
	 * Return the value associated with the column: bank_ac_no
	 */
	public java.lang.String getBankAcNo() {
		return bankAcNo;
	}

	/**
	 * Set the value related to the column: bank_ac_no
	 * 
	 * @param bankAcNo
	 *            the bank_ac_no value
	 */
	public void setBankAcNo(java.lang.String bankAcNo) {
		this.bankAcNo = bankAcNo;
	}

	/**
	 * Return the value associated with the column: identification_mark
	 */
	public java.lang.String getIdentificationMark() {
		return identificationMark;
	}

	/**
	 * Set the value related to the column: identification_mark
	 * 
	 * @param identificationMark
	 *            the identification_mark value
	 */
	public void setIdentificationMark(java.lang.String identificationMark) {
		this.identificationMark = identificationMark;
	}

	/**
	 * Return the value associated with the column: height
	 */
	public java.lang.Integer getHeight() {
		return height;
	}

	/**
	 * Set the value related to the column: height
	 * 
	 * @param height
	 *            the height value
	 */
	public void setHeight(java.lang.Integer height) {
		this.height = height;
	}

	/**
	 * Return the value associated with the column: sfx
	 */
	public java.lang.String getSfx() {
		return sfx;
	}

	/**
	 * Set the value related to the column: sfx
	 * 
	 * @param sfx
	 *            the sfx value
	 */
	public void setSfx(java.lang.String sfx) {
		this.sfx = sfx;
	}

	/**
	 * Return the value associated with the column: present_address
	 */
	public java.lang.String getPresentAddress() {
		return presentAddress;
	}

	/**
	 * Set the value related to the column: present_address
	 * 
	 * @param presentAddress
	 *            the present_address value
	 */
	public void setPresentAddress(java.lang.String presentAddress) {
		this.presentAddress = presentAddress;
	}

	/**
	 * Return the value associated with the column: present_pin
	 */
	public java.lang.Integer getPresentPin() {
		return presentPin;
	}

	/**
	 * Set the value related to the column: present_pin
	 * 
	 * @param presentPin
	 *            the present_pin value
	 */
	public void setPresentPin(java.lang.Integer presentPin) {
		this.presentPin = presentPin;
	}

	/**
	 * Return the value associated with the column: permanent_address
	 */
	public java.lang.String getPermanentAddress() {
		return permanentAddress;
	}

	/**
	 * Set the value related to the column: permanent_address
	 * 
	 * @param permanentAddress
	 *            the permanent_address value
	 */
	public void setPermanentAddress(java.lang.String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	/**
	 * Return the value associated with the column: permanent_pin
	 */
	public java.lang.Integer getPermanentPin() {
		return permanentPin;
	}

	/**
	 * Set the value related to the column: permanent_pin
	 * 
	 * @param permanentPin
	 *            the permanent_pin value
	 */
	public void setPermanentPin(java.lang.Integer permanentPin) {
		this.permanentPin = permanentPin;
	}

	/**
	 * Return the value associated with the column: bank_address
	 */
	public java.lang.String getBankAddress() {
		return bankAddress;
	}

	/**
	 * Set the value related to the column: bank_address
	 * 
	 * @param bankAddress
	 *            the bank_address value
	 */
	public void setBankAddress(java.lang.String bankAddress) {
		this.bankAddress = bankAddress;
	}

	/**
	 * Return the value associated with the column: father_husband_name
	 */
	public java.lang.String getFatherHusbandName() {
		return fatherHusbandName;
	}

	/**
	 * Set the value related to the column: father_husband_name
	 * 
	 * @param fatherHusbandName
	 *            the father_husband_name value
	 */
	public void setFatherHusbandName(java.lang.String fatherHusbandName) {
		this.fatherHusbandName = fatherHusbandName;
	}

	/**
	 * Return the value associated with the column: pay_scale
	 */
	public java.lang.String getPayScale() {
		return payScale;
	}

	/**
	 * Set the value related to the column: pay_scale
	 * 
	 * @param payScale
	 *            the pay_scale value
	 */
	public void setPayScale(java.lang.String payScale) {
		this.payScale = payScale;
	}

	/**
	 * Return the value associated with the column: date_of_birth
	 */
	public java.util.Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * Set the value related to the column: date_of_birth
	 * 
	 * @param dateOfBirth
	 *            the date_of_birth value
	 */
	public void setDateOfBirth(java.util.Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * Return the value associated with the column: appointment_date
	 */
	public java.util.Date getAppointmentDate() {
		return appointmentDate;
	}

	/**
	 * Set the value related to the column: appointment_date
	 * 
	 * @param appointmentDate
	 *            the appointment_date value
	 */
	public void setAppointmentDate(java.util.Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	/**
	 * Return the value associated with the column: posting_in
	 */
	public java.util.Date getPostingIn() {
		return postingIn;
	}

	/**
	 * Set the value related to the column: posting_in
	 * 
	 * @param postingIn
	 *            the posting_in value
	 */
	public void setPostingIn(java.util.Date postingIn) {
		this.postingIn = postingIn;
	}

	/**
	 * Return the value associated with the column: increment_date
	 */
	public java.util.Date getIncrementDate() {
		return incrementDate;
	}

	/**
	 * Set the value related to the column: increment_date
	 * 
	 * @param incrementDate
	 *            the increment_date value
	 */
	public void setIncrementDate(java.util.Date incrementDate) {
		this.incrementDate = incrementDate;
	}

	/**
	 * Return the value associated with the column: marriage_date
	 */
	public java.util.Date getMarriageDate() {
		return marriageDate;
	}

	/**
	 * Set the value related to the column: marriage_date
	 * 
	 * @param marriageDate
	 *            the marriage_date value
	 */
	public void setMarriageDate(java.util.Date marriageDate) {
		this.marriageDate = marriageDate;
	}

	/**
	 * Return the value associated with the column: retirement_date
	 */
	public java.util.Date getRetirementDate() {
		return retirementDate;
	}

	/**
	 * Set the value related to the column: retirement_date
	 * 
	 * @param retirementDate
	 *            the retirement_date value
	 */
	public void setRetirementDate(java.util.Date retirementDate) {
		this.retirementDate = retirementDate;
	}

	/**
	 * Return the value associated with the column: posted_out
	 */
	public java.util.Date getPostedOut() {
		return postedOut;
	}

	/**
	 * Set the value related to the column: posted_out
	 * 
	 * @param postedOut
	 *            the posted_out value
	 */
	public void setPostedOut(java.util.Date postedOut) {
		this.postedOut = postedOut;
	}

	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.String getLastChgBy() {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * 
	 * @param lastChgBy
	 *            the last_chg_by value
	 */
	public void setLastChgBy(java.lang.String lastChgBy) {
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
	 * Return the value associated with the column:
	 * total_service_without_eol_years
	 */
	public java.lang.Integer getTotalServiceWithoutEolYears() {
		return totalServiceWithoutEolYears;
	}

	/**
	 * Set the value related to the column: total_service_without_eol_years
	 * 
	 * @param totalServiceWithoutEolYears
	 *            the total_service_without_eol_years value
	 */
	public void setTotalServiceWithoutEolYears(
			java.lang.Integer totalServiceWithoutEolYears) {
		this.totalServiceWithoutEolYears = totalServiceWithoutEolYears;
	}

	/**
	 * Return the value associated with the column: data_sheet_status
	 */
	public java.lang.String getDataSheetStatus() {
		return dataSheetStatus;
	}

	/**
	 * Set the value related to the column: data_sheet_status
	 * 
	 * @param dataSheetStatus
	 *            the data_sheet_status value
	 */
	public void setDataSheetStatus(java.lang.String dataSheetStatus) {
		this.dataSheetStatus = dataSheetStatus;
	}

	/**
	 * Return the value associated with the column: calculation_sheet_status
	 */
	public java.lang.String getCalculationSheetStatus() {
		return calculationSheetStatus;
	}

	/**
	 * Set the value related to the column: calculation_sheet_status
	 * 
	 * @param calculationSheetStatus
	 *            the calculation_sheet_status value
	 */
	public void setCalculationSheetStatus(
			java.lang.String calculationSheetStatus) {
		this.calculationSheetStatus = calculationSheetStatus;
	}

	/**
	 * Return the value associated with the column: form7_status
	 */
	public java.lang.String getForm7Status() {
		return form7Status;
	}

	/**
	 * Set the value related to the column: form7_status
	 * 
	 * @param form7Status
	 *            the form7_status value
	 */
	public void setForm7Status(java.lang.String form7Status) {
		this.form7Status = form7Status;
	}

	/**
	 * Return the value associated with the column: form8_status
	 */
	public java.lang.String getForm8Status() {
		return form8Status;
	}

	/**
	 * Set the value related to the column: form8_status
	 * 
	 * @param form8Status
	 *            the form8_status value
	 */
	public void setForm8Status(java.lang.String form8Status) {
		this.form8Status = form8Status;
	}

	/**
	 * Return the value associated with the column: retirement_entry_status
	 */
	public java.lang.String getRetirementEntryStatus() {
		return retirementEntryStatus;
	}

	/**
	 * Set the value related to the column: retirement_entry_status
	 * 
	 * @param retirementEntryStatus
	 *            the retirement_entry_status value
	 */
	public void setRetirementEntryStatus(java.lang.String retirementEntryStatus) {
		this.retirementEntryStatus = retirementEntryStatus;
	}

	/**
	 * Return the value associated with the column:
	 * total_service_without_eol_months
	 */
	public java.lang.Integer getTotalServiceWithoutEolMonths() {
		return totalServiceWithoutEolMonths;
	}

	/**
	 * Set the value related to the column: total_service_without_eol_months
	 * 
	 * @param totalServiceWithoutEolMonths
	 *            the total_service_without_eol_months value
	 */
	public void setTotalServiceWithoutEolMonths(
			java.lang.Integer totalServiceWithoutEolMonths) {
		this.totalServiceWithoutEolMonths = totalServiceWithoutEolMonths;
	}

	/**
	 * Return the value associated with the column:
	 * total_service_without_eol_days
	 */
	public java.lang.Integer getTotalServiceWithoutEolDays() {
		return totalServiceWithoutEolDays;
	}

	/**
	 * Set the value related to the column: total_service_without_eol_days
	 * 
	 * @param totalServiceWithoutEolDays
	 *            the total_service_without_eol_days value
	 */
	public void setTotalServiceWithoutEolDays(
			java.lang.Integer totalServiceWithoutEolDays) {
		this.totalServiceWithoutEolDays = totalServiceWithoutEolDays;
	}

	/**
	 * Return the value associated with the column: designation_id
	 */
	public jkt.hms.masters.business.MasDesignation getDesignation() {
		return designation;
	}

	/**
	 * Set the value related to the column: designation_id
	 * 
	 * @param designation
	 *            the designation_id value
	 */
	public void setDesignation(
			jkt.hms.masters.business.MasDesignation designation) {
		this.designation = designation;
	}

	/**
	 * Return the value associated with the column: unit_id
	 */
	public jkt.hms.masters.business.MasUnit getUnit() {
		return unit;
	}

	/**
	 * Set the value related to the column: unit_id
	 * 
	 * @param unit
	 *            the unit_id value
	 */
	public void setUnit(jkt.hms.masters.business.MasUnit unit) {
		this.unit = unit;
	}

	/**
	 * Return the value associated with the column: administrative_sex_id
	 */
	public jkt.hms.masters.business.MasAdministrativeSex getAdministrativeSex() {
		return administrativeSex;
	}

	/**
	 * Set the value related to the column: administrative_sex_id
	 * 
	 * @param administrativeSex
	 *            the administrative_sex_id value
	 */
	public void setAdministrativeSex(
			jkt.hms.masters.business.MasAdministrativeSex administrativeSex) {
		this.administrativeSex = administrativeSex;
	}

	/**
	 * Return the value associated with the column: religion_id
	 */
	public jkt.hms.masters.business.MasReligion getReligion() {
		return religion;
	}

	/**
	 * Set the value related to the column: religion_id
	 * 
	 * @param religion
	 *            the religion_id value
	 */
	public void setReligion(jkt.hms.masters.business.MasReligion religion) {
		this.religion = religion;
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
	 * Return the value associated with the column:
	 * PensionForm7EmolumentsDetails
	 */
	public java.util.Set<jkt.hms.masters.business.PensionForm7EmolumentsDetail> getPensionForm7EmolumentsDetails() {
		return pensionForm7EmolumentsDetails;
	}

	/**
	 * Set the value related to the column: PensionForm7EmolumentsDetails
	 * 
	 * @param pensionForm7EmolumentsDetails
	 *            the PensionForm7EmolumentsDetails value
	 */
	public void setPensionForm7EmolumentsDetails(
			java.util.Set<jkt.hms.masters.business.PensionForm7EmolumentsDetail> pensionForm7EmolumentsDetails) {
		this.pensionForm7EmolumentsDetails = pensionForm7EmolumentsDetails;
	}

	public void addToPensionForm7EmolumentsDetails(
			jkt.hms.masters.business.PensionForm7EmolumentsDetail pensionForm7EmolumentsDetail) {
		if (null == getPensionForm7EmolumentsDetails())
			setPensionForm7EmolumentsDetails(new java.util.TreeSet<jkt.hms.masters.business.PensionForm7EmolumentsDetail>());
		getPensionForm7EmolumentsDetails().add(pensionForm7EmolumentsDetail);
	}

	/**
	 * Return the value associated with the column: PensionEmoluments
	 */
	public java.util.Set<jkt.hms.masters.business.PensionEmoluments> getPensionEmoluments() {
		return pensionEmoluments;
	}

	/**
	 * Set the value related to the column: PensionEmoluments
	 * 
	 * @param pensionEmoluments
	 *            the PensionEmoluments value
	 */
	public void setPensionEmoluments(
			java.util.Set<jkt.hms.masters.business.PensionEmoluments> pensionEmoluments) {
		this.pensionEmoluments = pensionEmoluments;
	}

	public void addToPensionEmoluments(
			jkt.hms.masters.business.PensionEmoluments pensionEmoluments) {
		if (null == getPensionEmoluments())
			setPensionEmoluments(new java.util.TreeSet<jkt.hms.masters.business.PensionEmoluments>());
		getPensionEmoluments().add(pensionEmoluments);
	}

	/**
	 * Return the value associated with the column: MasPersonnelFamilyDetails
	 */
	public java.util.Set<jkt.hms.masters.business.MasPersonnelFamilyDetails> getMasPersonnelFamilyDetails() {
		return masPersonnelFamilyDetails;
	}

	/**
	 * Set the value related to the column: MasPersonnelFamilyDetails
	 * 
	 * @param masPersonnelFamilyDetails
	 *            the MasPersonnelFamilyDetails value
	 */
	public void setMasPersonnelFamilyDetails(
			java.util.Set<jkt.hms.masters.business.MasPersonnelFamilyDetails> masPersonnelFamilyDetails) {
		this.masPersonnelFamilyDetails = masPersonnelFamilyDetails;
	}

	public void addToMasPersonnelFamilyDetails(
			jkt.hms.masters.business.MasPersonnelFamilyDetails masPersonnelFamilyDetails) {
		if (null == getMasPersonnelFamilyDetails())
			setMasPersonnelFamilyDetails(new java.util.TreeSet<jkt.hms.masters.business.MasPersonnelFamilyDetails>());
		getMasPersonnelFamilyDetails().add(masPersonnelFamilyDetails);
	}

	/**
	 * Return the value associated with the column: PensionDataSheets
	 */
	public java.util.Set<jkt.hms.masters.business.PensionDataSheet> getPensionDataSheets() {
		return pensionDataSheets;
	}

	/**
	 * Set the value related to the column: PensionDataSheets
	 * 
	 * @param pensionDataSheets
	 *            the PensionDataSheets value
	 */
	public void setPensionDataSheets(
			java.util.Set<jkt.hms.masters.business.PensionDataSheet> pensionDataSheets) {
		this.pensionDataSheets = pensionDataSheets;
	}

	public void addToPensionDataSheets(
			jkt.hms.masters.business.PensionDataSheet pensionDataSheet) {
		if (null == getPensionDataSheets())
			setPensionDataSheets(new java.util.TreeSet<jkt.hms.masters.business.PensionDataSheet>());
		getPensionDataSheets().add(pensionDataSheet);
	}

	/**
	 * Return the value associated with the column: PensionForm8Entries
	 */
	public java.util.Set<jkt.hms.masters.business.PensionForm8Entry> getPensionForm8Entries() {
		return pensionForm8Entries;
	}

	/**
	 * Set the value related to the column: PensionForm8Entries
	 * 
	 * @param pensionForm8Entries
	 *            the PensionForm8Entries value
	 */
	public void setPensionForm8Entries(
			java.util.Set<jkt.hms.masters.business.PensionForm8Entry> pensionForm8Entries) {
		this.pensionForm8Entries = pensionForm8Entries;
	}

	public void addToPensionForm8Entries(
			jkt.hms.masters.business.PensionForm8Entry pensionForm8Entry) {
		if (null == getPensionForm8Entries())
			setPensionForm8Entries(new java.util.TreeSet<jkt.hms.masters.business.PensionForm8Entry>());
		getPensionForm8Entries().add(pensionForm8Entry);
	}

	/**
	 * Return the value associated with the column: PensionEols
	 */
	public java.util.Set<jkt.hms.masters.business.PensionEol> getPensionEols() {
		return pensionEols;
	}

	/**
	 * Set the value related to the column: PensionEols
	 * 
	 * @param pensionEols
	 *            the PensionEols value
	 */
	public void setPensionEols(
			java.util.Set<jkt.hms.masters.business.PensionEol> pensionEols) {
		this.pensionEols = pensionEols;
	}

	public void addToPensionEols(jkt.hms.masters.business.PensionEol pensionEol) {
		if (null == getPensionEols())
			setPensionEols(new java.util.TreeSet<jkt.hms.masters.business.PensionEol>());
		getPensionEols().add(pensionEol);
	}

	/**
	 * Return the value associated with the column: PensionRetirementEntries
	 */
	public java.util.Set<jkt.hms.masters.business.PensionRetirementEntry> getPensionRetirementEntries() {
		return pensionRetirementEntries;
	}

	/**
	 * Set the value related to the column: PensionRetirementEntries
	 * 
	 * @param pensionRetirementEntries
	 *            the PensionRetirementEntries value
	 */
	public void setPensionRetirementEntries(
			java.util.Set<jkt.hms.masters.business.PensionRetirementEntry> pensionRetirementEntries) {
		this.pensionRetirementEntries = pensionRetirementEntries;
	}

	public void addToPensionRetirementEntries(
			jkt.hms.masters.business.PensionRetirementEntry pensionRetirementEntry) {
		if (null == getPensionRetirementEntries())
			setPensionRetirementEntries(new java.util.TreeSet<jkt.hms.masters.business.PensionRetirementEntry>());
		getPensionRetirementEntries().add(pensionRetirementEntry);
	}

	/**
	 * Return the value associated with the column: PensionForm7Details
	 */
	public java.util.Set<jkt.hms.masters.business.PensionForm7Details> getPensionForm7Details() {
		return pensionForm7Details;
	}

	/**
	 * Set the value related to the column: PensionForm7Details
	 * 
	 * @param pensionForm7Details
	 *            the PensionForm7Details value
	 */
	public void setPensionForm7Details(
			java.util.Set<jkt.hms.masters.business.PensionForm7Details> pensionForm7Details) {
		this.pensionForm7Details = pensionForm7Details;
	}

	public void addToPensionForm7Details(
			jkt.hms.masters.business.PensionForm7Details pensionForm7Details) {
		if (null == getPensionForm7Details())
			setPensionForm7Details(new java.util.TreeSet<jkt.hms.masters.business.PensionForm7Details>());
		getPensionForm7Details().add(pensionForm7Details);
	}

	/**
	 * Return the value associated with the column: PensionOtherServices
	 */
	public java.util.Set<jkt.hms.masters.business.PensionOtherServices> getPensionOtherServices() {
		return pensionOtherServices;
	}

	/**
	 * Set the value related to the column: PensionOtherServices
	 * 
	 * @param pensionOtherServices
	 *            the PensionOtherServices value
	 */
	public void setPensionOtherServices(
			java.util.Set<jkt.hms.masters.business.PensionOtherServices> pensionOtherServices) {
		this.pensionOtherServices = pensionOtherServices;
	}

	public void addToPensionOtherServices(
			jkt.hms.masters.business.PensionOtherServices pensionOtherServices) {
		if (null == getPensionOtherServices())
			setPensionOtherServices(new java.util.TreeSet<jkt.hms.masters.business.PensionOtherServices>());
		getPensionOtherServices().add(pensionOtherServices);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MasPersonnelDetails))
			return false;
		else {
			jkt.hms.masters.business.MasPersonnelDetails masPersonnelDetails = (jkt.hms.masters.business.MasPersonnelDetails) obj;
			if (null == this.getId() || null == masPersonnelDetails.getId())
				return false;
			else
				return (this.getId().equals(masPersonnelDetails.getId()));
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
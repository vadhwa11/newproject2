package jkt.hms.masters.business.base;

import java.io.Serializable;

import jkt.hms.masters.business.MasChargeCode;

/**
 * This is an object that contains data related to the mas_charge_code table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="mas_charge_code"
 */

public abstract class BaseMasChargeCode implements Serializable, Comparable {

	public static String REF = "MasChargeCode";
	public static String PROP_ACCOUNT = "Account";
	public static String PROP_STATUS = "Status";
	public static String PROP_CHARGE = "Charge";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_DATE_EFFECTIVE_TO = "DateEffectiveTo";
	public static String PROP_NORMAL_VALUE = "NormalValue";
	public static String PROP_SUB_CHARGECODE = "SubChargecode";
	public static String PROP_UNIT_OF_MEASUREMENT = "UnitOfMeasurement";
	public static String PROP_CHARGE_TYPE = "ChargeType";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_SAMPLE = "Sample";
	public static String PROP_DATE_EFFECTIVE_FROM = "DateEffectiveFrom";
	public static String PROP_MAIN_CHARGECODE = "MainChargecode";
	public static String PROP_CONFIDENTIAL = "Confidential";
	public static String PROP_CHARGE_CODE_CODE = "ChargeCodeCode";
	public static String PROP_CHARGE_CODE_NAME = "ChargeCodeName";
	public static String PROP_APPEAR_IN_DISCHARGE_SUMMARY = "AppearInDischargeSummary";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_ID = "Id";

	// constructors
	public BaseMasChargeCode() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasChargeCode(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String chargeCodeCode;
	private java.lang.String chargeCodeName;
	private java.lang.Float charge;
	private java.lang.String normalValue;
	private java.lang.String confidential;
	private java.lang.String appearInDischargeSummary;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.util.Date dateEffectiveFrom;
	private java.util.Date dateEffectiveTo;

	// many to one
	private jkt.hms.masters.business.MasMainChargecode mainChargecode;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasChargeType chargeType;
	private jkt.hms.masters.business.MasUnitOfMeasurement unitOfMeasurement;
	private jkt.hms.masters.business.MasSubChargecode subChargecode;
	private jkt.hms.masters.business.MasSample sample;
	private jkt.hms.masters.business.MasAccountType account;

	// collections
	private java.util.Set<jkt.hms.masters.business.DgOrderdt> dgOrderdts;
	private java.util.Set<jkt.hms.masters.business.DgResultEntryDetail> dgResultEntryDetails;
	private java.util.Set<jkt.hms.masters.business.DgSubMasInvestigation> dgSubMasInvestigations;
	private java.util.Set<jkt.hms.masters.business.OpdTemplateInvestigation> opdTemplateInvestigations;
	private java.util.Set<jkt.hms.masters.business.DgMasInvestigation> dgMasInvestigations;
	private java.util.Set<jkt.hms.masters.business.MasDiscount> masDiscounts;
	private java.util.Set<jkt.hms.masters.business.MasSubTest> masSubTests;
	private java.util.Set<jkt.hms.masters.business.DgSampleCollectionDetails> dgSampleCollectionDetails;
	private java.util.Set<jkt.hms.masters.business.BlChargeSlipDetail> blChargeSlipDetails;
	private java.util.Set<jkt.hms.masters.business.OtMasChargeDetails> otMasChargeDetails;
	private java.util.Set<jkt.hms.masters.business.PatientInvestigationDetails> patientInvestigationDetails;
	private java.util.Set<jkt.hms.masters.business.OpdSurgeryDetail> opdSurgeryDetails;
	private java.util.Set<jkt.hms.masters.business.DgNormalValue> dgNormalValues;
	private java.util.Set<jkt.hms.masters.business.OtBooking> otBookings;
	private java.util.Set<jkt.hms.masters.business.DgTemplate> dgTemplates;
	private java.util.Set<jkt.hms.masters.business.OtSurgeyPaSurgeyDetail> otSurgeyPaSurgeyDetails;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="charge_code_id"
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
	 * Return the value associated with the column: charge_code_code
	 */
	public java.lang.String getChargeCodeCode() {
		return chargeCodeCode;
	}

	/**
	 * Set the value related to the column: charge_code_code
	 * 
	 * @param chargeCodeCode
	 *            the charge_code_code value
	 */
	public void setChargeCodeCode(java.lang.String chargeCodeCode) {
		this.chargeCodeCode = chargeCodeCode;
	}

	/**
	 * Return the value associated with the column: charge_code_name
	 */
	public java.lang.String getChargeCodeName() {
		return chargeCodeName;
	}

	/**
	 * Set the value related to the column: charge_code_name
	 * 
	 * @param chargeCodeName
	 *            the charge_code_name value
	 */
	public void setChargeCodeName(java.lang.String chargeCodeName) {
		this.chargeCodeName = chargeCodeName;
	}

	/**
	 * Return the value associated with the column: charge
	 */
	public java.lang.Float getCharge() {
		return charge;
	}

	/**
	 * Set the value related to the column: charge
	 * 
	 * @param charge
	 *            the charge value
	 */
	public void setCharge(java.lang.Float charge) {
		this.charge = charge;
	}

	/**
	 * Return the value associated with the column: normal_value
	 */
	public java.lang.String getNormalValue() {
		return normalValue;
	}

	/**
	 * Set the value related to the column: normal_value
	 * 
	 * @param normalValue
	 *            the normal_value value
	 */
	public void setNormalValue(java.lang.String normalValue) {
		this.normalValue = normalValue;
	}

	/**
	 * Return the value associated with the column: confidential
	 */
	public java.lang.String getConfidential() {
		return confidential;
	}

	/**
	 * Set the value related to the column: confidential
	 * 
	 * @param confidential
	 *            the confidential value
	 */
	public void setConfidential(java.lang.String confidential) {
		this.confidential = confidential;
	}

	/**
	 * Return the value associated with the column: appear_in_discharge_summary
	 */
	public java.lang.String getAppearInDischargeSummary() {
		return appearInDischargeSummary;
	}

	/**
	 * Set the value related to the column: appear_in_discharge_summary
	 * 
	 * @param appearInDischargeSummary
	 *            the appear_in_discharge_summary value
	 */
	public void setAppearInDischargeSummary(
			java.lang.String appearInDischargeSummary) {
		this.appearInDischargeSummary = appearInDischargeSummary;
	}

	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus() {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * 
	 * @param status
	 *            the status value
	 */
	public void setStatus(java.lang.String status) {
		this.status = status;
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
	 * Return the value associated with the column: date_effective_from
	 */
	public java.util.Date getDateEffectiveFrom() {
		return dateEffectiveFrom;
	}

	/**
	 * Set the value related to the column: date_effective_from
	 * 
	 * @param dateEffectiveFrom
	 *            the date_effective_from value
	 */
	public void setDateEffectiveFrom(java.util.Date dateEffectiveFrom) {
		this.dateEffectiveFrom = dateEffectiveFrom;
	}

	/**
	 * Return the value associated with the column: date_effective_to
	 */
	public java.util.Date getDateEffectiveTo() {
		return dateEffectiveTo;
	}

	/**
	 * Set the value related to the column: date_effective_to
	 * 
	 * @param dateEffectiveTo
	 *            the date_effective_to value
	 */
	public void setDateEffectiveTo(java.util.Date dateEffectiveTo) {
		this.dateEffectiveTo = dateEffectiveTo;
	}

	/**
	 * Return the value associated with the column: main_chargecode_id
	 */
	public jkt.hms.masters.business.MasMainChargecode getMainChargecode() {
		return mainChargecode;
	}

	/**
	 * Set the value related to the column: main_chargecode_id
	 * 
	 * @param mainChargecode
	 *            the main_chargecode_id value
	 */
	public void setMainChargecode(
			jkt.hms.masters.business.MasMainChargecode mainChargecode) {
		this.mainChargecode = mainChargecode;
	}

	/**
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment() {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * 
	 * @param department
	 *            the department_id value
	 */
	public void setDepartment(jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}

	/**
	 * Return the value associated with the column: charge_type_id
	 */
	public jkt.hms.masters.business.MasChargeType getChargeType() {
		return chargeType;
	}

	/**
	 * Set the value related to the column: charge_type_id
	 * 
	 * @param chargeType
	 *            the charge_type_id value
	 */
	public void setChargeType(jkt.hms.masters.business.MasChargeType chargeType) {
		this.chargeType = chargeType;
	}

	/**
	 * Return the value associated with the column: unit_of_measurement_id
	 */
	public jkt.hms.masters.business.MasUnitOfMeasurement getUnitOfMeasurement() {
		return unitOfMeasurement;
	}

	/**
	 * Set the value related to the column: unit_of_measurement_id
	 * 
	 * @param unitOfMeasurement
	 *            the unit_of_measurement_id value
	 */
	public void setUnitOfMeasurement(
			jkt.hms.masters.business.MasUnitOfMeasurement unitOfMeasurement) {
		this.unitOfMeasurement = unitOfMeasurement;
	}

	/**
	 * Return the value associated with the column: sub_chargecode_id
	 */
	public jkt.hms.masters.business.MasSubChargecode getSubChargecode() {
		return subChargecode;
	}

	/**
	 * Set the value related to the column: sub_chargecode_id
	 * 
	 * @param subChargecode
	 *            the sub_chargecode_id value
	 */
	public void setSubChargecode(
			jkt.hms.masters.business.MasSubChargecode subChargecode) {
		this.subChargecode = subChargecode;
	}

	/**
	 * Return the value associated with the column: sample_id
	 */
	public jkt.hms.masters.business.MasSample getSample() {
		return sample;
	}

	/**
	 * Set the value related to the column: sample_id
	 * 
	 * @param sample
	 *            the sample_id value
	 */
	public void setSample(jkt.hms.masters.business.MasSample sample) {
		this.sample = sample;
	}

	/**
	 * Return the value associated with the column: account_id
	 */
	public jkt.hms.masters.business.MasAccountType getAccount() {
		return account;
	}

	/**
	 * Set the value related to the column: account_id
	 * 
	 * @param account
	 *            the account_id value
	 */
	public void setAccount(jkt.hms.masters.business.MasAccountType account) {
		this.account = account;
	}

	/**
	 * Return the value associated with the column: DgOrderdts
	 */
	public java.util.Set<jkt.hms.masters.business.DgOrderdt> getDgOrderdts() {
		return dgOrderdts;
	}

	/**
	 * Set the value related to the column: DgOrderdts
	 * 
	 * @param dgOrderdts
	 *            the DgOrderdts value
	 */
	public void setDgOrderdts(
			java.util.Set<jkt.hms.masters.business.DgOrderdt> dgOrderdts) {
		this.dgOrderdts = dgOrderdts;
	}

	public void addToDgOrderdts(jkt.hms.masters.business.DgOrderdt dgOrderdt) {
		if (null == getDgOrderdts())
			setDgOrderdts(new java.util.TreeSet<jkt.hms.masters.business.DgOrderdt>());
		getDgOrderdts().add(dgOrderdt);
	}

	/**
	 * Return the value associated with the column: DgResultEntryDetails
	 */
	public java.util.Set<jkt.hms.masters.business.DgResultEntryDetail> getDgResultEntryDetails() {
		return dgResultEntryDetails;
	}

	/**
	 * Set the value related to the column: DgResultEntryDetails
	 * 
	 * @param dgResultEntryDetails
	 *            the DgResultEntryDetails value
	 */
	public void setDgResultEntryDetails(
			java.util.Set<jkt.hms.masters.business.DgResultEntryDetail> dgResultEntryDetails) {
		this.dgResultEntryDetails = dgResultEntryDetails;
	}

	public void addToDgResultEntryDetails(
			jkt.hms.masters.business.DgResultEntryDetail dgResultEntryDetail) {
		if (null == getDgResultEntryDetails())
			setDgResultEntryDetails(new java.util.TreeSet<jkt.hms.masters.business.DgResultEntryDetail>());
		getDgResultEntryDetails().add(dgResultEntryDetail);
	}

	/**
	 * Return the value associated with the column: DgSubMasInvestigations
	 */
	public java.util.Set<jkt.hms.masters.business.DgSubMasInvestigation> getDgSubMasInvestigations() {
		return dgSubMasInvestigations;
	}

	/**
	 * Set the value related to the column: DgSubMasInvestigations
	 * 
	 * @param dgSubMasInvestigations
	 *            the DgSubMasInvestigations value
	 */
	public void setDgSubMasInvestigations(
			java.util.Set<jkt.hms.masters.business.DgSubMasInvestigation> dgSubMasInvestigations) {
		this.dgSubMasInvestigations = dgSubMasInvestigations;
	}

	public void addToDgSubMasInvestigations(
			jkt.hms.masters.business.DgSubMasInvestigation dgSubMasInvestigation) {
		if (null == getDgSubMasInvestigations())
			setDgSubMasInvestigations(new java.util.TreeSet<jkt.hms.masters.business.DgSubMasInvestigation>());
		getDgSubMasInvestigations().add(dgSubMasInvestigation);
	}

	/**
	 * Return the value associated with the column: OpdTemplateInvestigations
	 */
	public java.util.Set<jkt.hms.masters.business.OpdTemplateInvestigation> getOpdTemplateInvestigations() {
		return opdTemplateInvestigations;
	}

	/**
	 * Set the value related to the column: OpdTemplateInvestigations
	 * 
	 * @param opdTemplateInvestigations
	 *            the OpdTemplateInvestigations value
	 */
	public void setOpdTemplateInvestigations(
			java.util.Set<jkt.hms.masters.business.OpdTemplateInvestigation> opdTemplateInvestigations) {
		this.opdTemplateInvestigations = opdTemplateInvestigations;
	}

	public void addToOpdTemplateInvestigations(
			jkt.hms.masters.business.OpdTemplateInvestigation opdTemplateInvestigation) {
		if (null == getOpdTemplateInvestigations())
			setOpdTemplateInvestigations(new java.util.TreeSet<jkt.hms.masters.business.OpdTemplateInvestigation>());
		getOpdTemplateInvestigations().add(opdTemplateInvestigation);
	}

	/**
	 * Return the value associated with the column: DgMasInvestigations
	 */
	public java.util.Set<jkt.hms.masters.business.DgMasInvestigation> getDgMasInvestigations() {
		return dgMasInvestigations;
	}

	/**
	 * Set the value related to the column: DgMasInvestigations
	 * 
	 * @param dgMasInvestigations
	 *            the DgMasInvestigations value
	 */
	public void setDgMasInvestigations(
			java.util.Set<jkt.hms.masters.business.DgMasInvestigation> dgMasInvestigations) {
		this.dgMasInvestigations = dgMasInvestigations;
	}

	public void addToDgMasInvestigations(
			jkt.hms.masters.business.DgMasInvestigation dgMasInvestigation) {
		if (null == getDgMasInvestigations())
			setDgMasInvestigations(new java.util.TreeSet<jkt.hms.masters.business.DgMasInvestigation>());
		getDgMasInvestigations().add(dgMasInvestigation);
	}

	/**
	 * Return the value associated with the column: MasDiscounts
	 */
	public java.util.Set<jkt.hms.masters.business.MasDiscount> getMasDiscounts() {
		return masDiscounts;
	}

	/**
	 * Set the value related to the column: MasDiscounts
	 * 
	 * @param masDiscounts
	 *            the MasDiscounts value
	 */
	public void setMasDiscounts(
			java.util.Set<jkt.hms.masters.business.MasDiscount> masDiscounts) {
		this.masDiscounts = masDiscounts;
	}

	public void addToMasDiscounts(
			jkt.hms.masters.business.MasDiscount masDiscount) {
		if (null == getMasDiscounts())
			setMasDiscounts(new java.util.TreeSet<jkt.hms.masters.business.MasDiscount>());
		getMasDiscounts().add(masDiscount);
	}

	/**
	 * Return the value associated with the column: MasSubTests
	 */
	public java.util.Set<jkt.hms.masters.business.MasSubTest> getMasSubTests() {
		return masSubTests;
	}

	/**
	 * Set the value related to the column: MasSubTests
	 * 
	 * @param masSubTests
	 *            the MasSubTests value
	 */
	public void setMasSubTests(
			java.util.Set<jkt.hms.masters.business.MasSubTest> masSubTests) {
		this.masSubTests = masSubTests;
	}

	public void addToMasSubTests(jkt.hms.masters.business.MasSubTest masSubTest) {
		if (null == getMasSubTests())
			setMasSubTests(new java.util.TreeSet<jkt.hms.masters.business.MasSubTest>());
		getMasSubTests().add(masSubTest);
	}

	/**
	 * Return the value associated with the column: DgSampleCollectionDetails
	 */
	public java.util.Set<jkt.hms.masters.business.DgSampleCollectionDetails> getDgSampleCollectionDetails() {
		return dgSampleCollectionDetails;
	}

	/**
	 * Set the value related to the column: DgSampleCollectionDetails
	 * 
	 * @param dgSampleCollectionDetails
	 *            the DgSampleCollectionDetails value
	 */
	public void setDgSampleCollectionDetails(
			java.util.Set<jkt.hms.masters.business.DgSampleCollectionDetails> dgSampleCollectionDetails) {
		this.dgSampleCollectionDetails = dgSampleCollectionDetails;
	}

	public void addToDgSampleCollectionDetails(
			jkt.hms.masters.business.DgSampleCollectionDetails dgSampleCollectionDetails) {
		if (null == getDgSampleCollectionDetails())
			setDgSampleCollectionDetails(new java.util.TreeSet<jkt.hms.masters.business.DgSampleCollectionDetails>());
		getDgSampleCollectionDetails().add(dgSampleCollectionDetails);
	}

	/**
	 * Return the value associated with the column: BlChargeSlipDetails
	 */
	public java.util.Set<jkt.hms.masters.business.BlChargeSlipDetail> getBlChargeSlipDetails() {
		return blChargeSlipDetails;
	}

	/**
	 * Set the value related to the column: BlChargeSlipDetails
	 * 
	 * @param blChargeSlipDetails
	 *            the BlChargeSlipDetails value
	 */
	public void setBlChargeSlipDetails(
			java.util.Set<jkt.hms.masters.business.BlChargeSlipDetail> blChargeSlipDetails) {
		this.blChargeSlipDetails = blChargeSlipDetails;
	}

	public void addToBlChargeSlipDetails(
			jkt.hms.masters.business.BlChargeSlipDetail blChargeSlipDetail) {
		if (null == getBlChargeSlipDetails())
			setBlChargeSlipDetails(new java.util.TreeSet<jkt.hms.masters.business.BlChargeSlipDetail>());
		getBlChargeSlipDetails().add(blChargeSlipDetail);
	}

	/**
	 * Return the value associated with the column: OtMasChargeDetails
	 */
	public java.util.Set<jkt.hms.masters.business.OtMasChargeDetails> getOtMasChargeDetails() {
		return otMasChargeDetails;
	}

	/**
	 * Set the value related to the column: OtMasChargeDetails
	 * 
	 * @param otMasChargeDetails
	 *            the OtMasChargeDetails value
	 */
	public void setOtMasChargeDetails(
			java.util.Set<jkt.hms.masters.business.OtMasChargeDetails> otMasChargeDetails) {
		this.otMasChargeDetails = otMasChargeDetails;
	}

	public void addToOtMasChargeDetails(
			jkt.hms.masters.business.OtMasChargeDetails otMasChargeDetails) {
		if (null == getOtMasChargeDetails())
			setOtMasChargeDetails(new java.util.TreeSet<jkt.hms.masters.business.OtMasChargeDetails>());
		getOtMasChargeDetails().add(otMasChargeDetails);
	}

	/**
	 * Return the value associated with the column: PatientInvestigationDetails
	 */
	public java.util.Set<jkt.hms.masters.business.PatientInvestigationDetails> getPatientInvestigationDetails() {
		return patientInvestigationDetails;
	}

	/**
	 * Set the value related to the column: PatientInvestigationDetails
	 * 
	 * @param patientInvestigationDetails
	 *            the PatientInvestigationDetails value
	 */
	public void setPatientInvestigationDetails(
			java.util.Set<jkt.hms.masters.business.PatientInvestigationDetails> patientInvestigationDetails) {
		this.patientInvestigationDetails = patientInvestigationDetails;
	}

	public void addToPatientInvestigationDetails(
			jkt.hms.masters.business.PatientInvestigationDetails patientInvestigationDetails) {
		if (null == getPatientInvestigationDetails())
			setPatientInvestigationDetails(new java.util.TreeSet<jkt.hms.masters.business.PatientInvestigationDetails>());
		getPatientInvestigationDetails().add(patientInvestigationDetails);
	}

	/**
	 * Return the value associated with the column: OpdSurgeryDetails
	 */
	public java.util.Set<jkt.hms.masters.business.OpdSurgeryDetail> getOpdSurgeryDetails() {
		return opdSurgeryDetails;
	}

	/**
	 * Set the value related to the column: OpdSurgeryDetails
	 * 
	 * @param opdSurgeryDetails
	 *            the OpdSurgeryDetails value
	 */
	public void setOpdSurgeryDetails(
			java.util.Set<jkt.hms.masters.business.OpdSurgeryDetail> opdSurgeryDetails) {
		this.opdSurgeryDetails = opdSurgeryDetails;
	}

	public void addToOpdSurgeryDetails(
			jkt.hms.masters.business.OpdSurgeryDetail opdSurgeryDetail) {
		if (null == getOpdSurgeryDetails())
			setOpdSurgeryDetails(new java.util.TreeSet<jkt.hms.masters.business.OpdSurgeryDetail>());
		getOpdSurgeryDetails().add(opdSurgeryDetail);
	}

	/**
	 * Return the value associated with the column: DgNormalValues
	 */
	public java.util.Set<jkt.hms.masters.business.DgNormalValue> getDgNormalValues() {
		return dgNormalValues;
	}

	/**
	 * Set the value related to the column: DgNormalValues
	 * 
	 * @param dgNormalValues
	 *            the DgNormalValues value
	 */
	public void setDgNormalValues(
			java.util.Set<jkt.hms.masters.business.DgNormalValue> dgNormalValues) {
		this.dgNormalValues = dgNormalValues;
	}

	public void addToDgNormalValues(
			jkt.hms.masters.business.DgNormalValue dgNormalValue) {
		if (null == getDgNormalValues())
			setDgNormalValues(new java.util.TreeSet<jkt.hms.masters.business.DgNormalValue>());
		getDgNormalValues().add(dgNormalValue);
	}

	/**
	 * Return the value associated with the column: OtBookings
	 */
	public java.util.Set<jkt.hms.masters.business.OtBooking> getOtBookings() {
		return otBookings;
	}

	/**
	 * Set the value related to the column: OtBookings
	 * 
	 * @param otBookings
	 *            the OtBookings value
	 */
	public void setOtBookings(
			java.util.Set<jkt.hms.masters.business.OtBooking> otBookings) {
		this.otBookings = otBookings;
	}

	public void addToOtBookings(jkt.hms.masters.business.OtBooking otBooking) {
		if (null == getOtBookings())
			setOtBookings(new java.util.TreeSet<jkt.hms.masters.business.OtBooking>());
		getOtBookings().add(otBooking);
	}

	/**
	 * Return the value associated with the column: DgTemplates
	 */
	public java.util.Set<jkt.hms.masters.business.DgTemplate> getDgTemplates() {
		return dgTemplates;
	}

	/**
	 * Set the value related to the column: DgTemplates
	 * 
	 * @param dgTemplates
	 *            the DgTemplates value
	 */
	public void setDgTemplates(
			java.util.Set<jkt.hms.masters.business.DgTemplate> dgTemplates) {
		this.dgTemplates = dgTemplates;
	}

	public void addToDgTemplates(jkt.hms.masters.business.DgTemplate dgTemplate) {
		if (null == getDgTemplates())
			setDgTemplates(new java.util.TreeSet<jkt.hms.masters.business.DgTemplate>());
		getDgTemplates().add(dgTemplate);
	}

	/**
	 * Return the value associated with the column: OtSurgeyPaSurgeyDetails
	 */
	public java.util.Set<jkt.hms.masters.business.OtSurgeyPaSurgeyDetail> getOtSurgeyPaSurgeyDetails() {
		return otSurgeyPaSurgeyDetails;
	}

	/**
	 * Set the value related to the column: OtSurgeyPaSurgeyDetails
	 * 
	 * @param otSurgeyPaSurgeyDetails
	 *            the OtSurgeyPaSurgeyDetails value
	 */
	public void setOtSurgeyPaSurgeyDetails(
			java.util.Set<jkt.hms.masters.business.OtSurgeyPaSurgeyDetail> otSurgeyPaSurgeyDetails) {
		this.otSurgeyPaSurgeyDetails = otSurgeyPaSurgeyDetails;
	}

	public void addToOtSurgeyPaSurgeyDetails(
			jkt.hms.masters.business.OtSurgeyPaSurgeyDetail otSurgeyPaSurgeyDetail) {
		if (null == getOtSurgeyPaSurgeyDetails())
			setOtSurgeyPaSurgeyDetails(new java.util.TreeSet<jkt.hms.masters.business.OtSurgeyPaSurgeyDetail>());
		getOtSurgeyPaSurgeyDetails().add(otSurgeyPaSurgeyDetail);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MasChargeCode))
			return false;
		else {
			jkt.hms.masters.business.MasChargeCode masChargeCode = (jkt.hms.masters.business.MasChargeCode) obj;
			if (null == this.getId() || null == masChargeCode.getId())
				return false;
			else
				return (this.getId().equals(masChargeCode.getId()));
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
	
	public int compareTo(MasChargeCode mcc)
	{
		return mcc.getId().compareTo(this.getId());
	}

	public String toString() {
		return super.toString();
	}

}
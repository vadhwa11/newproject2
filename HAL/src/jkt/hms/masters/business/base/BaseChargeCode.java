package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the charge_code table. Do not
 * modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * 
 * @hibernate.class table="charge_code"
 */

public abstract class BaseChargeCode implements Serializable {

	public static String REF = "ChargeCode";
	public static String PROP_CHARGE = "Charge";
	public static String PROP_MAIN_CHARGE_ID = "MainChargeId";
	public static String PROP_SUB_CHARGE_ID = "SubChargeId";
	public static String PROP_DATE_EFFECTIVE_TO = "DateEffectiveTo";
	public static String PROP_STATUS_ID = "StatusId";
	public static String PROP_NORMAL_VALUE = "NormalValue";
	public static String PROP_SAMPLE_ID = "SampleId";
	public static String PROP_ADD_EDIT_DATE_TIME = "AddEditDateTime";
	public static String PROP_ADD_EDIT_BY_ID = "AddEditById";
	public static String PROP_UNIT_OF_RESULT = "UnitOfResult";
	public static String PROP_CHARGE_CODE_DESCRIPTION = "ChargeCodeDescription";
	public static String PROP_DATE_EFFECTIVE_FROM = "DateEffectiveFrom";
	public static String PROP_CONFIDENTIAL = "Confidential";
	public static String PROP_CHARGE_CODE_CODE = "ChargeCodeCode";
	public static String PROP_DEPARTMENT_ID = "DepartmentId";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_APPEAR_IN_DISCHARGE_SUMMARY = "AppearInDischargeSummary";
	public static String PROP_ID = "Id";
	public static String PROP_CHARGE_TYPE_ID = "ChargeTypeId";

	// constructors
	public BaseChargeCode() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseChargeCode(java.lang.Integer id) {
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
	private java.lang.String chargeCodeDescription;
	private java.lang.Integer hospitalId;
	private java.lang.Integer addEditById;
	private java.util.Date addEditDateTime;
	private java.lang.Integer mainChargeId;
	private java.lang.Integer subChargeId;
	private java.lang.Integer chargeTypeId;
	private java.lang.Integer departmentId;
	private java.lang.String normalValue;
	private java.lang.String unitOfResult;
	private java.lang.Integer confidential;
	private java.lang.Integer appearInDischargeSummary;
	private java.lang.Integer sampleId;
	private java.lang.Integer statusId;
	private java.lang.Float charge;
	private java.util.Date dateEffectiveFrom;
	private java.util.Date dateEffectiveTo;

	// collections
	private java.util.Set<jkt.hms.masters.business.DiscountMaster> discountMasters;
	private java.util.Set<jkt.hms.masters.business.DiagnosticsOrderDetails> diagnosticsOrderDetails;

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
	 * Return the value associated with the column: charge_code_description
	 */
	public java.lang.String getChargeCodeDescription() {
		return chargeCodeDescription;
	}

	/**
	 * Set the value related to the column: charge_code_description
	 * 
	 * @param chargeCodeDescription
	 *            the charge_code_description value
	 */
	public void setChargeCodeDescription(java.lang.String chargeCodeDescription) {
		this.chargeCodeDescription = chargeCodeDescription;
	}

	/**
	 * Return the value associated with the column: hospital_id
	 */
	public java.lang.Integer getHospitalId() {
		return hospitalId;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * 
	 * @param hospitalId
	 *            the hospital_id value
	 */
	public void setHospitalId(java.lang.Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	/**
	 * Return the value associated with the column: add_edit_by_id
	 */
	public java.lang.Integer getAddEditById() {
		return addEditById;
	}

	/**
	 * Set the value related to the column: add_edit_by_id
	 * 
	 * @param addEditById
	 *            the add_edit_by_id value
	 */
	public void setAddEditById(java.lang.Integer addEditById) {
		this.addEditById = addEditById;
	}

	/**
	 * Return the value associated with the column: add_edit_date_time
	 */
	public java.util.Date getAddEditDateTime() {
		return addEditDateTime;
	}

	/**
	 * Set the value related to the column: add_edit_date_time
	 * 
	 * @param addEditDateTime
	 *            the add_edit_date_time value
	 */
	public void setAddEditDateTime(java.util.Date addEditDateTime) {
		this.addEditDateTime = addEditDateTime;
	}

	/**
	 * Return the value associated with the column: main_charge_id
	 */
	public java.lang.Integer getMainChargeId() {
		return mainChargeId;
	}

	/**
	 * Set the value related to the column: main_charge_id
	 * 
	 * @param mainChargeId
	 *            the main_charge_id value
	 */
	public void setMainChargeId(java.lang.Integer mainChargeId) {
		this.mainChargeId = mainChargeId;
	}

	/**
	 * Return the value associated with the column: sub_charge_id
	 */
	public java.lang.Integer getSubChargeId() {
		return subChargeId;
	}

	/**
	 * Set the value related to the column: sub_charge_id
	 * 
	 * @param subChargeId
	 *            the sub_charge_id value
	 */
	public void setSubChargeId(java.lang.Integer subChargeId) {
		this.subChargeId = subChargeId;
	}

	/**
	 * Return the value associated with the column: charge_type_id
	 */
	public java.lang.Integer getChargeTypeId() {
		return chargeTypeId;
	}

	/**
	 * Set the value related to the column: charge_type_id
	 * 
	 * @param chargeTypeId
	 *            the charge_type_id value
	 */
	public void setChargeTypeId(java.lang.Integer chargeTypeId) {
		this.chargeTypeId = chargeTypeId;
	}

	/**
	 * Return the value associated with the column: department_id
	 */
	public java.lang.Integer getDepartmentId() {
		return departmentId;
	}

	/**
	 * Set the value related to the column: department_id
	 * 
	 * @param departmentId
	 *            the department_id value
	 */
	public void setDepartmentId(java.lang.Integer departmentId) {
		this.departmentId = departmentId;
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
	 * Return the value associated with the column: unit_of_result
	 */
	public java.lang.String getUnitOfResult() {
		return unitOfResult;
	}

	/**
	 * Set the value related to the column: unit_of_result
	 * 
	 * @param unitOfResult
	 *            the unit_of_result value
	 */
	public void setUnitOfResult(java.lang.String unitOfResult) {
		this.unitOfResult = unitOfResult;
	}

	/**
	 * Return the value associated with the column: confidential
	 */
	public java.lang.Integer getConfidential() {
		return confidential;
	}

	/**
	 * Set the value related to the column: confidential
	 * 
	 * @param confidential
	 *            the confidential value
	 */
	public void setConfidential(java.lang.Integer confidential) {
		this.confidential = confidential;
	}

	/**
	 * Return the value associated with the column: appear_in_discharge_summary
	 */
	public java.lang.Integer getAppearInDischargeSummary() {
		return appearInDischargeSummary;
	}

	/**
	 * Set the value related to the column: appear_in_discharge_summary
	 * 
	 * @param appearInDischargeSummary
	 *            the appear_in_discharge_summary value
	 */
	public void setAppearInDischargeSummary(
			java.lang.Integer appearInDischargeSummary) {
		this.appearInDischargeSummary = appearInDischargeSummary;
	}

	/**
	 * Return the value associated with the column: sample_id
	 */
	public java.lang.Integer getSampleId() {
		return sampleId;
	}

	/**
	 * Set the value related to the column: sample_id
	 * 
	 * @param sampleId
	 *            the sample_id value
	 */
	public void setSampleId(java.lang.Integer sampleId) {
		this.sampleId = sampleId;
	}

	/**
	 * Return the value associated with the column: status_id
	 */
	public java.lang.Integer getStatusId() {
		return statusId;
	}

	/**
	 * Set the value related to the column: status_id
	 * 
	 * @param statusId
	 *            the status_id value
	 */
	public void setStatusId(java.lang.Integer statusId) {
		this.statusId = statusId;
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
	 * Return the value associated with the column: DiscountMasters
	 */
	public java.util.Set<jkt.hms.masters.business.DiscountMaster> getDiscountMasters() {
		return discountMasters;
	}

	/**
	 * Set the value related to the column: DiscountMasters
	 * 
	 * @param discountMasters
	 *            the DiscountMasters value
	 */
	public void setDiscountMasters(
			java.util.Set<jkt.hms.masters.business.DiscountMaster> discountMasters) {
		this.discountMasters = discountMasters;
	}

	public void addToDiscountMasters(
			jkt.hms.masters.business.DiscountMaster discountMaster) {
		if (null == getDiscountMasters())
			setDiscountMasters(new java.util.TreeSet<jkt.hms.masters.business.DiscountMaster>());
		getDiscountMasters().add(discountMaster);
	}

	/**
	 * Return the value associated with the column: DiagnosticsOrderDetails
	 */
	public java.util.Set<jkt.hms.masters.business.DiagnosticsOrderDetails> getDiagnosticsOrderDetails() {
		return diagnosticsOrderDetails;
	}

	/**
	 * Set the value related to the column: DiagnosticsOrderDetails
	 * 
	 * @param diagnosticsOrderDetails
	 *            the DiagnosticsOrderDetails value
	 */
	public void setDiagnosticsOrderDetails(
			java.util.Set<jkt.hms.masters.business.DiagnosticsOrderDetails> diagnosticsOrderDetails) {
		this.diagnosticsOrderDetails = diagnosticsOrderDetails;
	}

	public void addToDiagnosticsOrderDetails(
			jkt.hms.masters.business.DiagnosticsOrderDetails diagnosticsOrderDetails) {
		if (null == getDiagnosticsOrderDetails())
			setDiagnosticsOrderDetails(new java.util.TreeSet<jkt.hms.masters.business.DiagnosticsOrderDetails>());
		getDiagnosticsOrderDetails().add(diagnosticsOrderDetails);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.ChargeCode))
			return false;
		else {
			jkt.hms.masters.business.ChargeCode chargeCode = (jkt.hms.masters.business.ChargeCode) obj;
			if (null == this.getId() || null == chargeCode.getId())
				return false;
			else
				return (this.getId().equals(chargeCode.getId()));
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
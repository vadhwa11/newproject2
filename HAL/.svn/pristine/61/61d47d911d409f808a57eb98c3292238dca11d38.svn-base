package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the discount_master table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="discount_master"
 */

public abstract class BaseDiscountMaster implements Serializable {

	public static String REF = "DiscountMaster";
	public static String PROP_SUB_CHARGE_ID = "SubChargeId";
	public static String PROP_MAIN_CHARGE_ID = "MainChargeId";
	public static String PROP_ADD_EDIT_DATE_TIME = "AddEditDateTime";
	public static String PROP_EMPLOYEE_DEPENDENT_ID = "EmployeeDependentId";
	public static String PROP_EFFECTIVE_DATE_TO = "EffectiveDateTo";
	public static String PROP_PATIENT_TYPE_INSURANCE_ID = "PatientTypeInsuranceId";
	public static String PROP_ACCOUNT_CODE = "AccountCode";
	public static String PROP_EMPLOYEE_COMPANY_ID = "EmployeeCompanyId";
	public static String PROP_EMPLOYEE_ID = "EmployeeId";
	public static String PROP_DISCOUNT_PERCENTAGE = "DiscountPercentage";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_FIXED_VALUE = "FixedValue";
	public static String PROP_PATIENT_CATEGORY_ID = "PatientCategoryId";
	public static String PROP_ROOM_TYPE_ID = "RoomTypeId";
	public static String PROP_CHARGE_CODE = "ChargeCode";
	public static String PROP_STATUS_ID = "StatusId";
	public static String PROP_ADD_EDIT_BY_ID = "AddEditById";
	public static String PROP_EFFECTIVE_DATE_FROM = "EffectiveDateFrom";
	public static String PROP_RETIRED_STAFF_ID = "RetiredStaffId";
	public static String PROP_PATIENT_TYPE_ID = "PatientTypeId";
	public static String PROP_BILL_TYPE = "BillType";
	public static String PROP_DISCOUNT_VALUE = "DiscountValue";
	public static String PROP_PATIENT_TYPE_PROJECT_ID = "PatientTypeProjectId";
	public static String PROP_MARKUP = "Markup";
	public static String PROP_ID = "Id";

	// constructors
	public BaseDiscountMaster() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDiscountMaster(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer hospitalId;
	private java.lang.Integer patientCategoryId;
	private java.lang.Integer patientTypeId;
	private java.lang.Integer employeeCompanyId;
	private java.lang.Integer patientTypeProjectId;
	private java.lang.Integer patientTypeInsuranceId;
	private java.lang.Integer retiredStaffId;
	private java.lang.Integer employeeId;
	private java.lang.Integer employeeDependentId;
	private java.lang.String billType;
	private java.lang.Integer mainChargeId;
	private java.lang.Integer subChargeId;
	private java.lang.Integer roomTypeId;
	private java.lang.String accountCode;
	private java.util.Date effectiveDateFrom;
	private java.util.Date effectiveDateTo;
	private java.lang.Float discountPercentage;
	private java.lang.Float discountValue;
	private java.lang.Float fixedValue;
	private java.lang.Integer markup;
	private java.lang.Integer addEditById;
	private java.util.Date addEditDateTime;
	private java.lang.Integer statusId;

	// many to one
	private jkt.hms.masters.business.ChargeCode chargeCode;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="discount_master_id"
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
	 * Return the value associated with the column: patient_category_id
	 */
	public java.lang.Integer getPatientCategoryId() {
		return patientCategoryId;
	}

	/**
	 * Set the value related to the column: patient_category_id
	 * 
	 * @param patientCategoryId
	 *            the patient_category_id value
	 */
	public void setPatientCategoryId(java.lang.Integer patientCategoryId) {
		this.patientCategoryId = patientCategoryId;
	}

	/**
	 * Return the value associated with the column: patient_type_id
	 */
	public java.lang.Integer getPatientTypeId() {
		return patientTypeId;
	}

	/**
	 * Set the value related to the column: patient_type_id
	 * 
	 * @param patientTypeId
	 *            the patient_type_id value
	 */
	public void setPatientTypeId(java.lang.Integer patientTypeId) {
		this.patientTypeId = patientTypeId;
	}

	/**
	 * Return the value associated with the column: employee_company_id
	 */
	public java.lang.Integer getEmployeeCompanyId() {
		return employeeCompanyId;
	}

	/**
	 * Set the value related to the column: employee_company_id
	 * 
	 * @param employeeCompanyId
	 *            the employee_company_id value
	 */
	public void setEmployeeCompanyId(java.lang.Integer employeeCompanyId) {
		this.employeeCompanyId = employeeCompanyId;
	}

	/**
	 * Return the value associated with the column: patient_type_project_id
	 */
	public java.lang.Integer getPatientTypeProjectId() {
		return patientTypeProjectId;
	}

	/**
	 * Set the value related to the column: patient_type_project_id
	 * 
	 * @param patientTypeProjectId
	 *            the patient_type_project_id value
	 */
	public void setPatientTypeProjectId(java.lang.Integer patientTypeProjectId) {
		this.patientTypeProjectId = patientTypeProjectId;
	}

	/**
	 * Return the value associated with the column: patient_type_insurance_id
	 */
	public java.lang.Integer getPatientTypeInsuranceId() {
		return patientTypeInsuranceId;
	}

	/**
	 * Set the value related to the column: patient_type_insurance_id
	 * 
	 * @param patientTypeInsuranceId
	 *            the patient_type_insurance_id value
	 */
	public void setPatientTypeInsuranceId(
			java.lang.Integer patientTypeInsuranceId) {
		this.patientTypeInsuranceId = patientTypeInsuranceId;
	}

	/**
	 * Return the value associated with the column: retired_staff_id
	 */
	public java.lang.Integer getRetiredStaffId() {
		return retiredStaffId;
	}

	/**
	 * Set the value related to the column: retired_staff_id
	 * 
	 * @param retiredStaffId
	 *            the retired_staff_id value
	 */
	public void setRetiredStaffId(java.lang.Integer retiredStaffId) {
		this.retiredStaffId = retiredStaffId;
	}

	/**
	 * Return the value associated with the column: employee_id
	 */
	public java.lang.Integer getEmployeeId() {
		return employeeId;
	}

	/**
	 * Set the value related to the column: employee_id
	 * 
	 * @param employeeId
	 *            the employee_id value
	 */
	public void setEmployeeId(java.lang.Integer employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * Return the value associated with the column: employee_dependent_id
	 */
	public java.lang.Integer getEmployeeDependentId() {
		return employeeDependentId;
	}

	/**
	 * Set the value related to the column: employee_dependent_id
	 * 
	 * @param employeeDependentId
	 *            the employee_dependent_id value
	 */
	public void setEmployeeDependentId(java.lang.Integer employeeDependentId) {
		this.employeeDependentId = employeeDependentId;
	}

	/**
	 * Return the value associated with the column: bill_type
	 */
	public java.lang.String getBillType() {
		return billType;
	}

	/**
	 * Set the value related to the column: bill_type
	 * 
	 * @param billType
	 *            the bill_type value
	 */
	public void setBillType(java.lang.String billType) {
		this.billType = billType;
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
	 * Return the value associated with the column: room_type_id
	 */
	public java.lang.Integer getRoomTypeId() {
		return roomTypeId;
	}

	/**
	 * Set the value related to the column: room_type_id
	 * 
	 * @param roomTypeId
	 *            the room_type_id value
	 */
	public void setRoomTypeId(java.lang.Integer roomTypeId) {
		this.roomTypeId = roomTypeId;
	}

	/**
	 * Return the value associated with the column: account_code
	 */
	public java.lang.String getAccountCode() {
		return accountCode;
	}

	/**
	 * Set the value related to the column: account_code
	 * 
	 * @param accountCode
	 *            the account_code value
	 */
	public void setAccountCode(java.lang.String accountCode) {
		this.accountCode = accountCode;
	}

	/**
	 * Return the value associated with the column: effective_date_from
	 */
	public java.util.Date getEffectiveDateFrom() {
		return effectiveDateFrom;
	}

	/**
	 * Set the value related to the column: effective_date_from
	 * 
	 * @param effectiveDateFrom
	 *            the effective_date_from value
	 */
	public void setEffectiveDateFrom(java.util.Date effectiveDateFrom) {
		this.effectiveDateFrom = effectiveDateFrom;
	}

	/**
	 * Return the value associated with the column: effective_date_to
	 */
	public java.util.Date getEffectiveDateTo() {
		return effectiveDateTo;
	}

	/**
	 * Set the value related to the column: effective_date_to
	 * 
	 * @param effectiveDateTo
	 *            the effective_date_to value
	 */
	public void setEffectiveDateTo(java.util.Date effectiveDateTo) {
		this.effectiveDateTo = effectiveDateTo;
	}

	/**
	 * Return the value associated with the column: discount_percentage
	 */
	public java.lang.Float getDiscountPercentage() {
		return discountPercentage;
	}

	/**
	 * Set the value related to the column: discount_percentage
	 * 
	 * @param discountPercentage
	 *            the discount_percentage value
	 */
	public void setDiscountPercentage(java.lang.Float discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	/**
	 * Return the value associated with the column: discount_value
	 */
	public java.lang.Float getDiscountValue() {
		return discountValue;
	}

	/**
	 * Set the value related to the column: discount_value
	 * 
	 * @param discountValue
	 *            the discount_value value
	 */
	public void setDiscountValue(java.lang.Float discountValue) {
		this.discountValue = discountValue;
	}

	/**
	 * Return the value associated with the column: fixed_value
	 */
	public java.lang.Float getFixedValue() {
		return fixedValue;
	}

	/**
	 * Set the value related to the column: fixed_value
	 * 
	 * @param fixedValue
	 *            the fixed_value value
	 */
	public void setFixedValue(java.lang.Float fixedValue) {
		this.fixedValue = fixedValue;
	}

	/**
	 * Return the value associated with the column: markup
	 */
	public java.lang.Integer getMarkup() {
		return markup;
	}

	/**
	 * Set the value related to the column: markup
	 * 
	 * @param markup
	 *            the markup value
	 */
	public void setMarkup(java.lang.Integer markup) {
		this.markup = markup;
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
	 * Return the value associated with the column: charge_code_id
	 */
	public jkt.hms.masters.business.ChargeCode getChargeCode() {
		return chargeCode;
	}

	/**
	 * Set the value related to the column: charge_code_id
	 * 
	 * @param chargeCode
	 *            the charge_code_id value
	 */
	public void setChargeCode(jkt.hms.masters.business.ChargeCode chargeCode) {
		this.chargeCode = chargeCode;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.DiscountMaster))
			return false;
		else {
			jkt.hms.masters.business.DiscountMaster discountMaster = (jkt.hms.masters.business.DiscountMaster) obj;
			if (null == this.getId() || null == discountMaster.getId())
				return false;
			else
				return (this.getId().equals(discountMaster.getId()));
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
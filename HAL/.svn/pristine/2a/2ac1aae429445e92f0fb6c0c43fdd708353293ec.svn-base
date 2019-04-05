package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_discount table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="mas_discount"
 */

public abstract class BaseMasDiscount implements Serializable {

	public static String REF = "MasDiscount";
	public static String PROP_TYPE = "Type";
	public static String PROP_ROOM_TYPE_ID = "RoomTypeId";
	public static String PROP_STATUS = "Status";
	public static String PROP_CHARGE_CODE = "ChargeCode";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_SUB_CHARGECODE = "SubChargecode";
	public static String PROP_EMPLOYEE_DEPENDENT_ID = "EmployeeDependentId";
	public static String PROP_EFFECTIVE_DATE_TO = "EffectiveDateTo";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_EFFECTIVE_DATE_FROM = "EffectiveDateFrom";
	public static String PROP_RETIRED_STAFF_ID = "RetiredStaffId";
	public static String PROP_PATIENT_TYPE = "PatientType";
	public static String PROP_ACCOUNT_CODE = "AccountCode";
	public static String PROP_MAIN_CHARGCODE = "MainChargcode";
	public static String PROP_BILL_TYPE = "BillType";
	public static String PROP_DISCOUNT_VALUE = "DiscountValue";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_DISCOUNT_PERCENTAGE = "DiscountPercentage";
	public static String PROP_FIXED_VALUE = "FixedValue";
	public static String PROP_MARKUP = "Markup";
	public static String PROP_COMPANY = "Company";
	public static String PROP_ID = "Id";

	// constructors
	public BaseMasDiscount() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasDiscount(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String type;
	private java.lang.Integer retiredStaffId;
	private java.lang.Integer employeeDependentId;
	private java.lang.Integer roomTypeId;
	private java.lang.String accountCode;
	private java.util.Date effectiveDateFrom;
	private java.util.Date effectiveDateTo;
	private java.lang.Float discountPercentage;
	private java.lang.Float discountValue;
	private java.lang.Float fixedValue;
	private java.lang.Integer markup;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasPatientType patientType;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasBillType billType;
	private jkt.hms.masters.business.MasChargeCode chargeCode;
	private jkt.hms.masters.business.MasSubChargecode subChargecode;
	private jkt.hms.masters.business.MasEmployee employee;
	private jkt.hms.masters.business.MasCompany company;
	private jkt.hms.masters.business.MasMainChargecode mainChargcode;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="discount_id"
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
	 * Return the value associated with the column: type
	 */
	public java.lang.String getType() {
		return type;
	}

	/**
	 * Set the value related to the column: type
	 * 
	 * @param type
	 *            the type value
	 */
	public void setType(java.lang.String type) {
		this.type = type;
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
	 * Return the value associated with the column: patient_type_id
	 */
	public jkt.hms.masters.business.MasPatientType getPatientType() {
		return patientType;
	}

	/**
	 * Set the value related to the column: patient_type_id
	 * 
	 * @param patientType
	 *            the patient_type_id value
	 */
	public void setPatientType(
			jkt.hms.masters.business.MasPatientType patientType) {
		this.patientType = patientType;
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
	 * Return the value associated with the column: bill_type_id
	 */
	public jkt.hms.masters.business.MasBillType getBillType() {
		return billType;
	}

	/**
	 * Set the value related to the column: bill_type_id
	 * 
	 * @param billType
	 *            the bill_type_id value
	 */
	public void setBillType(jkt.hms.masters.business.MasBillType billType) {
		this.billType = billType;
	}

	/**
	 * Return the value associated with the column: charge_code_id
	 */
	public jkt.hms.masters.business.MasChargeCode getChargeCode() {
		return chargeCode;
	}

	/**
	 * Set the value related to the column: charge_code_id
	 * 
	 * @param chargeCode
	 *            the charge_code_id value
	 */
	public void setChargeCode(jkt.hms.masters.business.MasChargeCode chargeCode) {
		this.chargeCode = chargeCode;
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
	 * Return the value associated with the column: employee_id
	 */
	public jkt.hms.masters.business.MasEmployee getEmployee() {
		return employee;
	}

	/**
	 * Set the value related to the column: employee_id
	 * 
	 * @param employee
	 *            the employee_id value
	 */
	public void setEmployee(jkt.hms.masters.business.MasEmployee employee) {
		this.employee = employee;
	}

	/**
	 * Return the value associated with the column: company_id
	 */
	public jkt.hms.masters.business.MasCompany getCompany() {
		return company;
	}

	/**
	 * Set the value related to the column: company_id
	 * 
	 * @param company
	 *            the company_id value
	 */
	public void setCompany(jkt.hms.masters.business.MasCompany company) {
		this.company = company;
	}

	/**
	 * Return the value associated with the column: main_chargecode_id
	 */
	public jkt.hms.masters.business.MasMainChargecode getMainChargcode() {
		return mainChargcode;
	}

	/**
	 * Set the value related to the column: main_chargecode_id
	 * 
	 * @param mainChargcode
	 *            the main_chargecode_id value
	 */
	public void setMainChargcode(
			jkt.hms.masters.business.MasMainChargecode mainChargcode) {
		this.mainChargcode = mainChargcode;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MasDiscount))
			return false;
		else {
			jkt.hms.masters.business.MasDiscount masDiscount = (jkt.hms.masters.business.MasDiscount) obj;
			if (null == this.getId() || null == masDiscount.getId())
				return false;
			else
				return (this.getId().equals(masDiscount.getId()));
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
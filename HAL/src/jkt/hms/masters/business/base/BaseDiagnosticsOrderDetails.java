package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the diagnostics_order_details
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="diagnostics_order_details"
 */

public abstract class BaseDiagnosticsOrderDetails implements Serializable {

	public static String REF = "DiagnosticsOrderDetails";
	public static String PROP_CHARGE_CODE = "ChargeCode";
	public static String PROP_STATUS_ID = "StatusId";
	public static String PROP_ADD_EDIT_DATE_TIME = "AddEditDateTime";
	public static String PROP_SAMPLE_COLLECTION_DATE_TIME = "SampleCollectionDateTime";
	public static String PROP_REFUNDED = "Refunded";
	public static String PROP_DIAGNOSTICS_APPROVER_ID = "DiagnosticsApproverId";
	public static String PROP_ADD_EDIT_BY_ID = "AddEditById";
	public static String PROP_HIN_ID = "HinId";
	public static String PROP_RESULT_UNIT_OF_MEASUREMENT = "ResultUnitOfMeasurement";
	public static String PROP_LAB_TECH_CODE = "LabTechCode";
	public static String PROP_MULTIPLE_RESULT = "MultipleResult";
	public static String PROP_DOCTOR_CODE = "DoctorCode";
	public static String PROP_ADD_NOTES = "AddNotes";
	public static String PROP_CONDUCT_DATE_TIME = "ConductDateTime";
	public static String PROP_RESULT_VALUE = "ResultValue";
	public static String PROP_DIAGNOSTICS_ORDER_HEADER = "DiagnosticsOrderHeader";
	public static String PROP_BILL_NO = "BillNo";
	public static String PROP_CONFIDENTIAL = "Confidential";
	public static String PROP_DEPARTMENT_ID = "DepartmentId";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_APPEAR_IN_DISCHARGE_SUMMARY = "AppearInDischargeSummary";
	public static String PROP_ID = "Id";

	// constructors
	public BaseDiagnosticsOrderDetails() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDiagnosticsOrderDetails(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseDiagnosticsOrderDetails(java.lang.Integer id,
			jkt.hms.masters.business.ChargeCode chargeCode,
			java.lang.Integer hospitalId, java.lang.Integer hinId,
			java.lang.Integer addEditById) {

		this.setId(id);
		this.setChargeCode(chargeCode);
		this.setHospitalId(hospitalId);
		this.setHinId(hinId);
		this.setAddEditById(addEditById);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer hospitalId;
	private java.lang.Integer hinId;
	private java.lang.String resultValue;
	private java.lang.String resultUnitOfMeasurement;
	private java.lang.Integer billNo;
	private java.util.Date conductDateTime;
	private java.lang.String addNotes;
	private java.lang.Integer appearInDischargeSummary;
	private java.lang.Integer refunded;
	private java.util.Date sampleCollectionDateTime;
	private java.lang.Integer diagnosticsApproverId;
	private java.lang.Integer departmentId;
	private java.lang.Integer addEditById;
	private java.util.Date addEditDateTime;
	private java.lang.Integer multipleResult;
	private java.lang.Integer confidential;
	private java.lang.Integer labTechCode;
	private java.lang.Integer doctorCode;
	private java.lang.Integer statusId;

	// many to one
	private jkt.hms.masters.business.DiagnosticsOrderHeader diagnosticsOrderHeader;
	private jkt.hms.masters.business.ChargeCode chargeCode;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native"
	 *               column="diagnostics_order_details_id"
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
	 * Return the value associated with the column: hin_id
	 */
	public java.lang.Integer getHinId() {
		return hinId;
	}

	/**
	 * Set the value related to the column: hin_id
	 * 
	 * @param hinId
	 *            the hin_id value
	 */
	public void setHinId(java.lang.Integer hinId) {
		this.hinId = hinId;
	}

	/**
	 * Return the value associated with the column: result_value
	 */
	public java.lang.String getResultValue() {
		return resultValue;
	}

	/**
	 * Set the value related to the column: result_value
	 * 
	 * @param resultValue
	 *            the result_value value
	 */
	public void setResultValue(java.lang.String resultValue) {
		this.resultValue = resultValue;
	}

	/**
	 * Return the value associated with the column: result_unit_of_measurement
	 */
	public java.lang.String getResultUnitOfMeasurement() {
		return resultUnitOfMeasurement;
	}

	/**
	 * Set the value related to the column: result_unit_of_measurement
	 * 
	 * @param resultUnitOfMeasurement
	 *            the result_unit_of_measurement value
	 */
	public void setResultUnitOfMeasurement(
			java.lang.String resultUnitOfMeasurement) {
		this.resultUnitOfMeasurement = resultUnitOfMeasurement;
	}

	/**
	 * Return the value associated with the column: bill_no
	 */
	public java.lang.Integer getBillNo() {
		return billNo;
	}

	/**
	 * Set the value related to the column: bill_no
	 * 
	 * @param billNo
	 *            the bill_no value
	 */
	public void setBillNo(java.lang.Integer billNo) {
		this.billNo = billNo;
	}

	/**
	 * Return the value associated with the column: conduct_date_time
	 */
	public java.util.Date getConductDateTime() {
		return conductDateTime;
	}

	/**
	 * Set the value related to the column: conduct_date_time
	 * 
	 * @param conductDateTime
	 *            the conduct_date_time value
	 */
	public void setConductDateTime(java.util.Date conductDateTime) {
		this.conductDateTime = conductDateTime;
	}

	/**
	 * Return the value associated with the column: add_notes
	 */
	public java.lang.String getAddNotes() {
		return addNotes;
	}

	/**
	 * Set the value related to the column: add_notes
	 * 
	 * @param addNotes
	 *            the add_notes value
	 */
	public void setAddNotes(java.lang.String addNotes) {
		this.addNotes = addNotes;
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
	 * Return the value associated with the column: refunded
	 */
	public java.lang.Integer getRefunded() {
		return refunded;
	}

	/**
	 * Set the value related to the column: refunded
	 * 
	 * @param refunded
	 *            the refunded value
	 */
	public void setRefunded(java.lang.Integer refunded) {
		this.refunded = refunded;
	}

	/**
	 * Return the value associated with the column: sample_collection_date_time
	 */
	public java.util.Date getSampleCollectionDateTime() {
		return sampleCollectionDateTime;
	}

	/**
	 * Set the value related to the column: sample_collection_date_time
	 * 
	 * @param sampleCollectionDateTime
	 *            the sample_collection_date_time value
	 */
	public void setSampleCollectionDateTime(
			java.util.Date sampleCollectionDateTime) {
		this.sampleCollectionDateTime = sampleCollectionDateTime;
	}

	/**
	 * Return the value associated with the column: diagnostics_approver_id
	 */
	public java.lang.Integer getDiagnosticsApproverId() {
		return diagnosticsApproverId;
	}

	/**
	 * Set the value related to the column: diagnostics_approver_id
	 * 
	 * @param diagnosticsApproverId
	 *            the diagnostics_approver_id value
	 */
	public void setDiagnosticsApproverId(java.lang.Integer diagnosticsApproverId) {
		this.diagnosticsApproverId = diagnosticsApproverId;
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
	 * Return the value associated with the column: multiple_result
	 */
	public java.lang.Integer getMultipleResult() {
		return multipleResult;
	}

	/**
	 * Set the value related to the column: multiple_result
	 * 
	 * @param multipleResult
	 *            the multiple_result value
	 */
	public void setMultipleResult(java.lang.Integer multipleResult) {
		this.multipleResult = multipleResult;
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
	 * Return the value associated with the column: lab_tech_code
	 */
	public java.lang.Integer getLabTechCode() {
		return labTechCode;
	}

	/**
	 * Set the value related to the column: lab_tech_code
	 * 
	 * @param labTechCode
	 *            the lab_tech_code value
	 */
	public void setLabTechCode(java.lang.Integer labTechCode) {
		this.labTechCode = labTechCode;
	}

	/**
	 * Return the value associated with the column: doctor_code
	 */
	public java.lang.Integer getDoctorCode() {
		return doctorCode;
	}

	/**
	 * Set the value related to the column: doctor_code
	 * 
	 * @param doctorCode
	 *            the doctor_code value
	 */
	public void setDoctorCode(java.lang.Integer doctorCode) {
		this.doctorCode = doctorCode;
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
	 * Return the value associated with the column: diagnostics_order_header_id
	 */
	public jkt.hms.masters.business.DiagnosticsOrderHeader getDiagnosticsOrderHeader() {
		return diagnosticsOrderHeader;
	}

	/**
	 * Set the value related to the column: diagnostics_order_header_id
	 * 
	 * @param diagnosticsOrderHeader
	 *            the diagnostics_order_header_id value
	 */
	public void setDiagnosticsOrderHeader(
			jkt.hms.masters.business.DiagnosticsOrderHeader diagnosticsOrderHeader) {
		this.diagnosticsOrderHeader = diagnosticsOrderHeader;
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
		if (!(obj instanceof jkt.hms.masters.business.DiagnosticsOrderDetails))
			return false;
		else {
			jkt.hms.masters.business.DiagnosticsOrderDetails diagnosticsOrderDetails = (jkt.hms.masters.business.DiagnosticsOrderDetails) obj;
			if (null == this.getId() || null == diagnosticsOrderDetails.getId())
				return false;
			else
				return (this.getId().equals(diagnosticsOrderDetails.getId()));
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
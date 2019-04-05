package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the diagnostics_order_header
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="diagnostics_order_header"
 */

public abstract class BaseDiagnosticsOrderHeader implements Serializable {

	public static String REF = "DiagnosticsOrderHeader";
	public static String PROP_ORDER_NO = "OrderNo";
	public static String PROP_EMPLOYEE_SEQUENCE_ID = "EmployeeSequenceId";
	public static String PROP_INPATIENT_NO = "InpatientNo";
	public static String PROP_BILL_NO = "BillNo";
	public static String PROP_STATUS_ID = "StatusId";
	public static String PROP_ADD_EDIT_DATE_TIME = "AddEditDateTime";
	public static String PROP_ORDER_DATE_TIME = "OrderDateTime";
	public static String PROP_VISIT_NO = "VisitNo";
	public static String PROP_ADD_EDIT_BY_ID = "AddEditById";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_HIN = "Hin";
	public static String PROP_ID = "Id";

	// constructors
	public BaseDiagnosticsOrderHeader() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDiagnosticsOrderHeader(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseDiagnosticsOrderHeader(java.lang.Integer id,
			jkt.hms.masters.business.Patient hin, java.lang.Integer hospitalId,
			java.lang.Integer addEditById) {

		this.setId(id);
		this.setHin(hin);
		this.setHospitalId(hospitalId);
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
	private java.lang.Integer orderNo;
	private java.lang.Integer billNo;
	private java.lang.Integer visitNo;
	private java.lang.Integer inpatientNo;
	private java.lang.Integer employeeSequenceId;
	private java.util.Date orderDateTime;
	private java.lang.Integer addEditById;
	private java.util.Date addEditDateTime;
	private java.lang.Integer statusId;

	// many to one
	private jkt.hms.masters.business.Patient hin;

	// collections
	private java.util.Set<jkt.hms.masters.business.DiagnosticsOrderDetails> diagnosticsOrderDetails;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native"
	 *               column="diagnostics_order_header_id"
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
	 * Return the value associated with the column: order_no
	 */
	public java.lang.Integer getOrderNo() {
		return orderNo;
	}

	/**
	 * Set the value related to the column: order_no
	 * 
	 * @param orderNo
	 *            the order_no value
	 */
	public void setOrderNo(java.lang.Integer orderNo) {
		this.orderNo = orderNo;
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
	 * Return the value associated with the column: visit_no
	 */
	public java.lang.Integer getVisitNo() {
		return visitNo;
	}

	/**
	 * Set the value related to the column: visit_no
	 * 
	 * @param visitNo
	 *            the visit_no value
	 */
	public void setVisitNo(java.lang.Integer visitNo) {
		this.visitNo = visitNo;
	}

	/**
	 * Return the value associated with the column: inpatient_no
	 */
	public java.lang.Integer getInpatientNo() {
		return inpatientNo;
	}

	/**
	 * Set the value related to the column: inpatient_no
	 * 
	 * @param inpatientNo
	 *            the inpatient_no value
	 */
	public void setInpatientNo(java.lang.Integer inpatientNo) {
		this.inpatientNo = inpatientNo;
	}

	/**
	 * Return the value associated with the column: employee_sequence_id
	 */
	public java.lang.Integer getEmployeeSequenceId() {
		return employeeSequenceId;
	}

	/**
	 * Set the value related to the column: employee_sequence_id
	 * 
	 * @param employeeSequenceId
	 *            the employee_sequence_id value
	 */
	public void setEmployeeSequenceId(java.lang.Integer employeeSequenceId) {
		this.employeeSequenceId = employeeSequenceId;
	}

	/**
	 * Return the value associated with the column: order_date_time
	 */
	public java.util.Date getOrderDateTime() {
		return orderDateTime;
	}

	/**
	 * Set the value related to the column: order_date_time
	 * 
	 * @param orderDateTime
	 *            the order_date_time value
	 */
	public void setOrderDateTime(java.util.Date orderDateTime) {
		this.orderDateTime = orderDateTime;
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
	 * Return the value associated with the column: hin_id
	 */
	public jkt.hms.masters.business.Patient getHin() {
		return hin;
	}

	/**
	 * Set the value related to the column: hin_id
	 * 
	 * @param hin
	 *            the hin_id value
	 */
	public void setHin(jkt.hms.masters.business.Patient hin) {
		this.hin = hin;
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
		if (!(obj instanceof jkt.hms.masters.business.DiagnosticsOrderHeader))
			return false;
		else {
			jkt.hms.masters.business.DiagnosticsOrderHeader diagnosticsOrderHeader = (jkt.hms.masters.business.DiagnosticsOrderHeader) obj;
			if (null == this.getId() || null == diagnosticsOrderHeader.getId())
				return false;
			else
				return (this.getId().equals(diagnosticsOrderHeader.getId()));
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
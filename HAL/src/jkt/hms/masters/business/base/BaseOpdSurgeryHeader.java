package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_surgery_header table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_surgery_header"
 */

public abstract class BaseOpdSurgeryHeader  implements Serializable {

	public static String REF = "OpdSurgeryHeader";
	public static String PROP_REQUISITION_DATE = "RequisitionDate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_BOOKING_STATUS = "BookingStatus";
	public static String PROP_VISIT = "Visit";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_SURGICAL_DEPT = "SurgicalDept";
	public static String PROP_STATUS = "Status";
	public static String PROP_PAC_STATUS = "PacStatus";
	public static String PROP_REQUISITION_TIME = "RequisitionTime";
	public static String PROP_ORDER_NO = "OrderNo";
	public static String PROP_PATIENT_STATUS = "PatientStatus";
	public static String PROP_ID = "Id";
	public static String PROP_PRESCRIBED_DEPARTMENT = "PrescribedDepartment";
	public static String PROP_HIN = "Hin";
	public static String PROP_INPATIENT = "Inpatient";


	// constructors
	public BaseOpdSurgeryHeader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdSurgeryHeader (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String bookingStatus;
	private java.lang.Integer orderNo;
	private java.lang.String pacStatus;
	private java.lang.String patientStatus;
	private java.util.Date requisitionDate;
	private java.lang.String requisitionTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasEmployee employee;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.MasDepartment prescribedDepartment;
	private jkt.hms.masters.business.MasDepartment surgicalDept;
	private jkt.hms.masters.business.Visit visit;

	// collections
	private java.util.Set<jkt.hms.masters.business.OpdSurgeryDetail> opdSurgeryDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="org.hibernate.id.IncrementGenerator"
     *  column="opd_surgery_id"
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
	 * Return the value associated with the column: booking_status
	 */
	public java.lang.String getBookingStatus () {
		return bookingStatus;
	}

	/**
	 * Set the value related to the column: booking_status
	 * @param bookingStatus the booking_status value
	 */
	public void setBookingStatus (java.lang.String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}



	/**
	 * Return the value associated with the column: order_no
	 */
	public java.lang.Integer getOrderNo () {
		return orderNo;
	}

	/**
	 * Set the value related to the column: order_no
	 * @param orderNo the order_no value
	 */
	public void setOrderNo (java.lang.Integer orderNo) {
		this.orderNo = orderNo;
	}



	/**
	 * Return the value associated with the column: pac_status
	 */
	public java.lang.String getPacStatus () {
		return pacStatus;
	}

	/**
	 * Set the value related to the column: pac_status
	 * @param pacStatus the pac_status value
	 */
	public void setPacStatus (java.lang.String pacStatus) {
		this.pacStatus = pacStatus;
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
	 * Return the value associated with the column: requisition_date
	 */
	public java.util.Date getRequisitionDate () {
		return requisitionDate;
	}

	/**
	 * Set the value related to the column: requisition_date
	 * @param requisitionDate the requisition_date value
	 */
	public void setRequisitionDate (java.util.Date requisitionDate) {
		this.requisitionDate = requisitionDate;
	}



	/**
	 * Return the value associated with the column: requisition_time
	 */
	public java.lang.String getRequisitionTime () {
		return requisitionTime;
	}

	/**
	 * Set the value related to the column: requisition_time
	 * @param requisitionTime the requisition_time value
	 */
	public void setRequisitionTime (java.lang.String requisitionTime) {
		this.requisitionTime = requisitionTime;
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
	 * Return the value associated with the column: hin_id
	 */
	public jkt.hms.masters.business.Patient getHin () {
		return hin;
	}

	/**
	 * Set the value related to the column: hin_id
	 * @param hin the hin_id value
	 */
	public void setHin (jkt.hms.masters.business.Patient hin) {
		this.hin = hin;
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
	 * Return the value associated with the column: inpatient_id
	 */
	public jkt.hms.masters.business.Inpatient getInpatient () {
		return inpatient;
	}

	/**
	 * Set the value related to the column: inpatient_id
	 * @param inpatient the inpatient_id value
	 */
	public void setInpatient (jkt.hms.masters.business.Inpatient inpatient) {
		this.inpatient = inpatient;
	}



	/**
	 * Return the value associated with the column: prescribed_department_id
	 */
	public jkt.hms.masters.business.MasDepartment getPrescribedDepartment () {
		return prescribedDepartment;
	}

	/**
	 * Set the value related to the column: prescribed_department_id
	 * @param prescribedDepartment the prescribed_department_id value
	 */
	public void setPrescribedDepartment (jkt.hms.masters.business.MasDepartment prescribedDepartment) {
		this.prescribedDepartment = prescribedDepartment;
	}



	/**
	 * Return the value associated with the column: surgical_dept_id
	 */
	public jkt.hms.masters.business.MasDepartment getSurgicalDept () {
		return surgicalDept;
	}

	/**
	 * Set the value related to the column: surgical_dept_id
	 * @param surgicalDept the surgical_dept_id value
	 */
	public void setSurgicalDept (jkt.hms.masters.business.MasDepartment surgicalDept) {
		this.surgicalDept = surgicalDept;
	}



	/**
	 * Return the value associated with the column: visit_id
	 */
	public jkt.hms.masters.business.Visit getVisit () {
		return visit;
	}

	/**
	 * Set the value related to the column: visit_id
	 * @param visit the visit_id value
	 */
	public void setVisit (jkt.hms.masters.business.Visit visit) {
		this.visit = visit;
	}



	/**
	 * Return the value associated with the column: OpdSurgeryDetails
	 */
	public java.util.Set<jkt.hms.masters.business.OpdSurgeryDetail> getOpdSurgeryDetails () {
		return opdSurgeryDetails;
	}

	/**
	 * Set the value related to the column: OpdSurgeryDetails
	 * @param opdSurgeryDetails the OpdSurgeryDetails value
	 */
	public void setOpdSurgeryDetails (java.util.Set<jkt.hms.masters.business.OpdSurgeryDetail> opdSurgeryDetails) {
		this.opdSurgeryDetails = opdSurgeryDetails;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OpdSurgeryHeader)) return false;
		else {
			jkt.hms.masters.business.OpdSurgeryHeader opdSurgeryHeader = (jkt.hms.masters.business.OpdSurgeryHeader) obj;
			if (null == this.getId() || null == opdSurgeryHeader.getId()) return false;
			else return (this.getId().equals(opdSurgeryHeader.getId()));
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
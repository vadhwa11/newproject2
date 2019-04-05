package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the dg_orderhd table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="dg_orderhd"
 */

public abstract class BaseDgOrderhd  implements Serializable {

	public static String REF = "DgOrderhd";
	public static String PROP_ORDER_TIME = "OrderTime";
	public static String PROP_ORDER_DATE = "OrderDate";
	public static String PROP_ORDER_STATUS = "OrderStatus";
	public static String PROP_CREATEDBY = "Createdby";
	public static String PROP_OTHER_INVESTIGATION = "OtherInvestigation";
	public static String PROP_PROVISIONAL_DIAG = "ProvisionalDiag";
	public static String PROP_APPOINTMENT_DATE = "AppointmentDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_CREATEDON = "Createdon";
	public static String PROP_INVESTIGATION_REQUESTION_NO = "InvestigationRequestionNo";
	public static String PROP_BILLING_STATUS = "BillingStatus";
	public static String PROP_PATIENT_TYPE = "PatientType";
	public static String PROP_VISIT = "Visit";
	public static String PROP_CLINICAL_NOTE = "ClinicalNote";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAB_ORDER_STATUS = "LabOrderStatus";
	public static String PROP_ORDER_NO = "OrderNo";
	public static String PROP_SURGERY = "Surgery";
	public static String PROP_ID = "Id";
	public static String PROP_PRESCRIBED_BY = "PrescribedBy";
	public static String PROP_TEST_TYPE = "TestType";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_HIN = "Hin";
	public static String PROP_INPATIENT = "Inpatient";


	// constructors
	public BaseDgOrderhd () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDgOrderhd (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date orderDate;
	private java.lang.String orderTime;
	private java.lang.String testType;
	private java.lang.String clinicalNote;
	private java.lang.String provisionalDiag;
	private java.lang.String orderNo;
	private java.lang.String patientType;
	private java.lang.String orderStatus;
	private java.lang.String createdby;
	private java.util.Date createdon;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String labOrderStatus;
	private java.util.Date appointmentDate;
	private java.lang.String otherInvestigation;
	private java.lang.String billingStatus;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasEmployee prescribedBy;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.PatientInvestigationHeader investigationRequestionNo;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.OpdSurgeryHeader surgery;

	// collections
	private java.util.Set<jkt.hms.masters.business.DgOrderdt> dgOrderdts;
	private java.util.Set<jkt.hms.masters.business.DgSampleCollectionHeader> dgSampleCollectionHeaders;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="orderhd_id"
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
	 * Return the value associated with the column: order_date
	 */
	public java.util.Date getOrderDate () {
		return orderDate;
	}

	/**
	 * Set the value related to the column: order_date
	 * @param orderDate the order_date value
	 */
	public void setOrderDate (java.util.Date orderDate) {
		this.orderDate = orderDate;
	}



	/**
	 * Return the value associated with the column: order_time
	 */
	public java.lang.String getOrderTime () {
		return orderTime;
	}

	/**
	 * Set the value related to the column: order_time
	 * @param orderTime the order_time value
	 */
	public void setOrderTime (java.lang.String orderTime) {
		this.orderTime = orderTime;
	}



	/**
	 * Return the value associated with the column: test_type
	 */
	public java.lang.String getTestType () {
		return testType;
	}

	/**
	 * Set the value related to the column: test_type
	 * @param testType the test_type value
	 */
	public void setTestType (java.lang.String testType) {
		this.testType = testType;
	}



	/**
	 * Return the value associated with the column: clinical_note
	 */
	public java.lang.String getClinicalNote () {
		return clinicalNote;
	}

	/**
	 * Set the value related to the column: clinical_note
	 * @param clinicalNote the clinical_note value
	 */
	public void setClinicalNote (java.lang.String clinicalNote) {
		this.clinicalNote = clinicalNote;
	}



	/**
	 * Return the value associated with the column: provisional_diag
	 */
	public java.lang.String getProvisionalDiag () {
		return provisionalDiag;
	}

	/**
	 * Set the value related to the column: provisional_diag
	 * @param provisionalDiag the provisional_diag value
	 */
	public void setProvisionalDiag (java.lang.String provisionalDiag) {
		this.provisionalDiag = provisionalDiag;
	}



	/**
	 * Return the value associated with the column: order_no
	 */
	public java.lang.String getOrderNo () {
		return orderNo;
	}

	/**
	 * Set the value related to the column: order_no
	 * @param orderNo the order_no value
	 */
	public void setOrderNo (java.lang.String orderNo) {
		this.orderNo = orderNo;
	}



	/**
	 * Return the value associated with the column: patient_type
	 */
	public java.lang.String getPatientType () {
		return patientType;
	}

	/**
	 * Set the value related to the column: patient_type
	 * @param patientType the patient_type value
	 */
	public void setPatientType (java.lang.String patientType) {
		this.patientType = patientType;
	}



	/**
	 * Return the value associated with the column: order_status
	 */
	public java.lang.String getOrderStatus () {
		return orderStatus;
	}

	/**
	 * Set the value related to the column: order_status
	 * @param orderStatus the order_status value
	 */
	public void setOrderStatus (java.lang.String orderStatus) {
		this.orderStatus = orderStatus;
	}



	/**
	 * Return the value associated with the column: CREATEDBY
	 */
	public java.lang.String getCreatedby () {
		return createdby;
	}

	/**
	 * Set the value related to the column: CREATEDBY
	 * @param createdby the CREATEDBY value
	 */
	public void setCreatedby (java.lang.String createdby) {
		this.createdby = createdby;
	}



	/**
	 * Return the value associated with the column: CREATEDON
	 */
	public java.util.Date getCreatedon () {
		return createdon;
	}

	/**
	 * Set the value related to the column: CREATEDON
	 * @param createdon the CREATEDON value
	 */
	public void setCreatedon (java.util.Date createdon) {
		this.createdon = createdon;
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
	 * Return the value associated with the column: lab_order_status
	 */
	public java.lang.String getLabOrderStatus () {
		return labOrderStatus;
	}

	/**
	 * Set the value related to the column: lab_order_status
	 * @param labOrderStatus the lab_order_status value
	 */
	public void setLabOrderStatus (java.lang.String labOrderStatus) {
		this.labOrderStatus = labOrderStatus;
	}



	/**
	 * Return the value associated with the column: appointment_date
	 */
	public java.util.Date getAppointmentDate () {
		return appointmentDate;
	}

	/**
	 * Set the value related to the column: appointment_date
	 * @param appointmentDate the appointment_date value
	 */
	public void setAppointmentDate (java.util.Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}



	/**
	 * Return the value associated with the column: OTHER_INVESTIGATION
	 */
	public java.lang.String getOtherInvestigation () {
		return otherInvestigation;
	}

	/**
	 * Set the value related to the column: OTHER_INVESTIGATION
	 * @param otherInvestigation the OTHER_INVESTIGATION value
	 */
	public void setOtherInvestigation (java.lang.String otherInvestigation) {
		this.otherInvestigation = otherInvestigation;
	}



	/**
	 * Return the value associated with the column: billing_status
	 */
	public java.lang.String getBillingStatus () {
		return billingStatus;
	}

	/**
	 * Set the value related to the column: billing_status
	 * @param billingStatus the billing_status value
	 */
	public void setBillingStatus (java.lang.String billingStatus) {
		this.billingStatus = billingStatus;
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
	 * Return the value associated with the column: prescribed_by
	 */
	public jkt.hms.masters.business.MasEmployee getPrescribedBy () {
		return prescribedBy;
	}

	/**
	 * Set the value related to the column: prescribed_by
	 * @param prescribedBy the prescribed_by value
	 */
	public void setPrescribedBy (jkt.hms.masters.business.MasEmployee prescribedBy) {
		this.prescribedBy = prescribedBy;
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
	 * Return the value associated with the column: investigation_requestion_no
	 */
	public jkt.hms.masters.business.PatientInvestigationHeader getInvestigationRequestionNo () {
		return investigationRequestionNo;
	}

	/**
	 * Set the value related to the column: investigation_requestion_no
	 * @param investigationRequestionNo the investigation_requestion_no value
	 */
	public void setInvestigationRequestionNo (jkt.hms.masters.business.PatientInvestigationHeader investigationRequestionNo) {
		this.investigationRequestionNo = investigationRequestionNo;
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
	 * Return the value associated with the column: surgery_id
	 */
	public jkt.hms.masters.business.OpdSurgeryHeader getSurgery () {
		return surgery;
	}

	/**
	 * Set the value related to the column: surgery_id
	 * @param surgery the surgery_id value
	 */
	public void setSurgery (jkt.hms.masters.business.OpdSurgeryHeader surgery) {
		this.surgery = surgery;
	}



	/**
	 * Return the value associated with the column: DgOrderdts
	 */
	public java.util.Set<jkt.hms.masters.business.DgOrderdt> getDgOrderdts () {
		return dgOrderdts;
	}

	/**
	 * Set the value related to the column: DgOrderdts
	 * @param dgOrderdts the DgOrderdts value
	 */
	public void setDgOrderdts (java.util.Set<jkt.hms.masters.business.DgOrderdt> dgOrderdts) {
		this.dgOrderdts = dgOrderdts;
	}

	public void addToDgOrderdts (jkt.hms.masters.business.DgOrderdt dgOrderdt) {
		if (null == getDgOrderdts()) setDgOrderdts(new java.util.TreeSet<jkt.hms.masters.business.DgOrderdt>());
		getDgOrderdts().add(dgOrderdt);
	}



	/**
	 * Return the value associated with the column: DgSampleCollectionHeaders
	 */
	public java.util.Set<jkt.hms.masters.business.DgSampleCollectionHeader> getDgSampleCollectionHeaders () {
		return dgSampleCollectionHeaders;
	}

	/**
	 * Set the value related to the column: DgSampleCollectionHeaders
	 * @param dgSampleCollectionHeaders the DgSampleCollectionHeaders value
	 */
	public void setDgSampleCollectionHeaders (java.util.Set<jkt.hms.masters.business.DgSampleCollectionHeader> dgSampleCollectionHeaders) {
		this.dgSampleCollectionHeaders = dgSampleCollectionHeaders;
	}

	public void addToDgSampleCollectionHeaders (jkt.hms.masters.business.DgSampleCollectionHeader dgSampleCollectionHeader) {
		if (null == getDgSampleCollectionHeaders()) setDgSampleCollectionHeaders(new java.util.TreeSet<jkt.hms.masters.business.DgSampleCollectionHeader>());
		getDgSampleCollectionHeaders().add(dgSampleCollectionHeader);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.DgOrderhd)) return false;
		else {
			jkt.hms.masters.business.DgOrderhd dgOrderhd = (jkt.hms.masters.business.DgOrderhd) obj;
			if (null == this.getId() || null == dgOrderhd.getId()) return false;
			else return (this.getId().equals(dgOrderhd.getId()));
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
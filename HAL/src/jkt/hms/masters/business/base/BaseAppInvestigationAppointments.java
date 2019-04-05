package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * app_investigation_appointments table. Do not modify this class because it
 * will be overwritten if the configuration file related to this class is
 * modified.
 * 
 * @hibernate.class table="app_investigation_appointments"
 */

public abstract class BaseAppInvestigationAppointments implements Serializable {

	public static String REF = "AppInvestigationAppointments";
	public static String PROP_REGISTERED_STATUS = "RegisteredStatus";
	public static String PROP_AGE = "Age";
	public static String PROP_EQUIPMENT = "Equipment";
	public static String PROP_SERVICE_NO = "ServiceNo";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_INVESTIGATION_DATE = "InvestigationDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_INVESTIGATION_APPOINTMENT_NO = "InvestigationAppointmentNo";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_PATIENT_NAME = "PatientName";
	public static String PROP_MOBILE_NO = "MobileNo";
	public static String PROP_SERVICE_PERSON_NAME = "ServicePersonName";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_TO_TIME_SLOT = "ToTimeSlot";
	public static String PROP_INVESTIGATION_STATUS = "InvestigationStatus";
	public static String PROP_FROM_TIME_SLOT = "FromTimeSlot";
	public static String PROP_INVESTIGATION_CANCEL_DATE = "InvestigationCancelDate";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_HIN = "Hin";
	public static String PROP_SEX = "Sex";

	// constructors
	public BaseAppInvestigationAppointments() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAppInvestigationAppointments(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date investigationDate;
	private java.lang.String fromTimeSlot;
	private java.lang.String toTimeSlot;
	private java.lang.String serviceNo;
	private java.lang.String servicePersonName;
	private java.lang.String patientName;
	private java.lang.String sex;
	private java.lang.String age;
	private java.lang.String investigationStatus;
	private java.lang.String registeredStatus;
	private java.lang.String investigationAppointmentNo;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.util.Date investigationCancelDate;
	private java.lang.String mobileNo;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.AppEquipmentMaster equipment;
	private jkt.hms.masters.business.MasEmployee employee;
	private jkt.hms.masters.business.Inpatient inpatient;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native"
	 *               column="investigation_appointment_id"
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
	 * Return the value associated with the column: investigation_date
	 */
	public java.util.Date getInvestigationDate() {
		return investigationDate;
	}

	/**
	 * Set the value related to the column: investigation_date
	 * 
	 * @param investigationDate
	 *            the investigation_date value
	 */
	public void setInvestigationDate(java.util.Date investigationDate) {
		this.investigationDate = investigationDate;
	}

	/**
	 * Return the value associated with the column: from_time_slot
	 */
	public java.lang.String getFromTimeSlot() {
		return fromTimeSlot;
	}

	/**
	 * Set the value related to the column: from_time_slot
	 * 
	 * @param fromTimeSlot
	 *            the from_time_slot value
	 */
	public void setFromTimeSlot(java.lang.String fromTimeSlot) {
		this.fromTimeSlot = fromTimeSlot;
	}

	/**
	 * Return the value associated with the column: to_time_slot
	 */
	public java.lang.String getToTimeSlot() {
		return toTimeSlot;
	}

	/**
	 * Set the value related to the column: to_time_slot
	 * 
	 * @param toTimeSlot
	 *            the to_time_slot value
	 */
	public void setToTimeSlot(java.lang.String toTimeSlot) {
		this.toTimeSlot = toTimeSlot;
	}

	/**
	 * Return the value associated with the column: service_no
	 */
	public java.lang.String getServiceNo() {
		return serviceNo;
	}

	/**
	 * Set the value related to the column: service_no
	 * 
	 * @param serviceNo
	 *            the service_no value
	 */
	public void setServiceNo(java.lang.String serviceNo) {
		this.serviceNo = serviceNo;
	}

	/**
	 * Return the value associated with the column: service_person_name
	 */
	public java.lang.String getServicePersonName() {
		return servicePersonName;
	}

	/**
	 * Set the value related to the column: service_person_name
	 * 
	 * @param servicePersonName
	 *            the service_person_name value
	 */
	public void setServicePersonName(java.lang.String servicePersonName) {
		this.servicePersonName = servicePersonName;
	}

	/**
	 * Return the value associated with the column: patient_name
	 */
	public java.lang.String getPatientName() {
		return patientName;
	}

	/**
	 * Set the value related to the column: patient_name
	 * 
	 * @param patientName
	 *            the patient_name value
	 */
	public void setPatientName(java.lang.String patientName) {
		this.patientName = patientName;
	}

	/**
	 * Return the value associated with the column: sex
	 */
	public java.lang.String getSex() {
		return sex;
	}

	/**
	 * Set the value related to the column: sex
	 * 
	 * @param sex
	 *            the sex value
	 */
	public void setSex(java.lang.String sex) {
		this.sex = sex;
	}

	/**
	 * Return the value associated with the column: age
	 */
	public java.lang.String getAge() {
		return age;
	}

	/**
	 * Set the value related to the column: age
	 * 
	 * @param age
	 *            the age value
	 */
	public void setAge(java.lang.String age) {
		this.age = age;
	}

	/**
	 * Return the value associated with the column: investigation_status
	 */
	public java.lang.String getInvestigationStatus() {
		return investigationStatus;
	}

	/**
	 * Set the value related to the column: investigation_status
	 * 
	 * @param investigationStatus
	 *            the investigation_status value
	 */
	public void setInvestigationStatus(java.lang.String investigationStatus) {
		this.investigationStatus = investigationStatus;
	}

	/**
	 * Return the value associated with the column: registered_status
	 */
	public java.lang.String getRegisteredStatus() {
		return registeredStatus;
	}

	/**
	 * Set the value related to the column: registered_status
	 * 
	 * @param registeredStatus
	 *            the registered_status value
	 */
	public void setRegisteredStatus(java.lang.String registeredStatus) {
		this.registeredStatus = registeredStatus;
	}

	/**
	 * Return the value associated with the column: investigation_appointment_no
	 */
	public java.lang.String getInvestigationAppointmentNo() {
		return investigationAppointmentNo;
	}

	/**
	 * Set the value related to the column: investigation_appointment_no
	 * 
	 * @param investigationAppointmentNo
	 *            the investigation_appointment_no value
	 */
	public void setInvestigationAppointmentNo(
			java.lang.String investigationAppointmentNo) {
		this.investigationAppointmentNo = investigationAppointmentNo;
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
	 * Return the value associated with the column: investigation_cancel_date
	 */
	public java.util.Date getInvestigationCancelDate() {
		return investigationCancelDate;
	}

	/**
	 * Set the value related to the column: investigation_cancel_date
	 * 
	 * @param investigationCancelDate
	 *            the investigation_cancel_date value
	 */
	public void setInvestigationCancelDate(
			java.util.Date investigationCancelDate) {
		this.investigationCancelDate = investigationCancelDate;
	}

	/**
	 * Return the value associated with the column: mobile_no
	 */
	public java.lang.String getMobileNo() {
		return mobileNo;
	}

	/**
	 * Set the value related to the column: mobile_no
	 * 
	 * @param mobileNo
	 *            the mobile_no value
	 */
	public void setMobileNo(java.lang.String mobileNo) {
		this.mobileNo = mobileNo;
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
	 * Return the value associated with the column: equipment_id
	 */
	public jkt.hms.masters.business.AppEquipmentMaster getEquipment() {
		return equipment;
	}

	/**
	 * Set the value related to the column: equipment_id
	 * 
	 * @param equipment
	 *            the equipment_id value
	 */
	public void setEquipment(
			jkt.hms.masters.business.AppEquipmentMaster equipment) {
		this.equipment = equipment;
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
	 * Return the value associated with the column: inpatient_id
	 */
	public jkt.hms.masters.business.Inpatient getInpatient() {
		return inpatient;
	}

	/**
	 * Set the value related to the column: inpatient_id
	 * 
	 * @param inpatient
	 *            the inpatient_id value
	 */
	public void setInpatient(jkt.hms.masters.business.Inpatient inpatient) {
		this.inpatient = inpatient;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.AppInvestigationAppointments))
			return false;
		else {
			jkt.hms.masters.business.AppInvestigationAppointments appInvestigationAppointments = (jkt.hms.masters.business.AppInvestigationAppointments) obj;
			if (null == this.getId()
					|| null == appInvestigationAppointments.getId())
				return false;
			else
				return (this.getId().equals(appInvestigationAppointments
						.getId()));
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
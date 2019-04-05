package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the app_patient_appointments table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="app_patient_appointments"
 */

public abstract class BaseAppPatientAppointments  implements Serializable {

	public static String REF = "AppPatientAppointments";
	public static String PROP_REGISTERED_STATUS = "RegisteredStatus";
	public static String PROP_APPOINTMENT_NO = "AppointmentNo";
	public static String PROP_AGE = "Age";
	public static String PROP_SERVICE_NO = "ServiceNo";
	public static String PROP_APPOINTMENT_DATE = "AppointmentDate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_APPOINTMENT_CANCEL_DATE = "AppointmentCancelDate";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_PATIENT_NAME = "PatientName";
	public static String PROP_MOBILE_NO = "MobileNo";
	public static String PROP_SERVICE_PERSON_NAME = "ServicePersonName";
	public static String PROP_APP_SESSION = "AppSession";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_TO_TIME_SLOT = "ToTimeSlot";
	public static String PROP_APPOINTMENT_STATUS = "AppointmentStatus";
	public static String PROP_QUEUE_PRIORITY = "QueuePriority";
	public static String PROP_FROM_TIME_SLOT = "FromTimeSlot";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_HIN = "Hin";
	public static String PROP_SEX = "Sex";


	// constructors
	public BaseAppPatientAppointments () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAppPatientAppointments (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String fromTimeSlot;
	private java.lang.String serviceNo;
	private java.lang.String servicePersonName;
	private java.lang.String patientName;
	private java.lang.String sex;
	private java.lang.String age;
	private java.lang.String registeredStatus;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String toTimeSlot;
	private java.util.Date appointmentDate;
	private java.lang.String appointmentNo;
	private java.lang.String appointmentStatus;
	private java.util.Date appointmentCancelDate;
	private java.lang.String mobileNo;
	private java.lang.Integer queuePriority;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.MasSession appSession;
	private jkt.hms.masters.business.MasEmployee employee;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="org.hibernate.id.IncrementGenerator"
     *  column="appointment_id"
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
	 * Return the value associated with the column: from_time_slot
	 */
	public java.lang.String getFromTimeSlot () {
		return fromTimeSlot;
	}

	/**
	 * Set the value related to the column: from_time_slot
	 * @param fromTimeSlot the from_time_slot value
	 */
	public void setFromTimeSlot (java.lang.String fromTimeSlot) {
		this.fromTimeSlot = fromTimeSlot;
	}



	/**
	 * Return the value associated with the column: service_no
	 */
	public java.lang.String getServiceNo () {
		return serviceNo;
	}

	/**
	 * Set the value related to the column: service_no
	 * @param serviceNo the service_no value
	 */
	public void setServiceNo (java.lang.String serviceNo) {
		this.serviceNo = serviceNo;
	}



	/**
	 * Return the value associated with the column: service_person_name
	 */
	public java.lang.String getServicePersonName () {
		return servicePersonName;
	}

	/**
	 * Set the value related to the column: service_person_name
	 * @param servicePersonName the service_person_name value
	 */
	public void setServicePersonName (java.lang.String servicePersonName) {
		this.servicePersonName = servicePersonName;
	}



	/**
	 * Return the value associated with the column: patient_name
	 */
	public java.lang.String getPatientName () {
		return patientName;
	}

	/**
	 * Set the value related to the column: patient_name
	 * @param patientName the patient_name value
	 */
	public void setPatientName (java.lang.String patientName) {
		this.patientName = patientName;
	}



	/**
	 * Return the value associated with the column: sex
	 */
	public java.lang.String getSex () {
		return sex;
	}

	/**
	 * Set the value related to the column: sex
	 * @param sex the sex value
	 */
	public void setSex (java.lang.String sex) {
		this.sex = sex;
	}



	/**
	 * Return the value associated with the column: age
	 */
	public java.lang.String getAge () {
		return age;
	}

	/**
	 * Set the value related to the column: age
	 * @param age the age value
	 */
	public void setAge (java.lang.String age) {
		this.age = age;
	}



	/**
	 * Return the value associated with the column: registered_status
	 */
	public java.lang.String getRegisteredStatus () {
		return registeredStatus;
	}

	/**
	 * Set the value related to the column: registered_status
	 * @param registeredStatus the registered_status value
	 */
	public void setRegisteredStatus (java.lang.String registeredStatus) {
		this.registeredStatus = registeredStatus;
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
	 * Return the value associated with the column: to_time_slot
	 */
	public java.lang.String getToTimeSlot () {
		return toTimeSlot;
	}

	/**
	 * Set the value related to the column: to_time_slot
	 * @param toTimeSlot the to_time_slot value
	 */
	public void setToTimeSlot (java.lang.String toTimeSlot) {
		this.toTimeSlot = toTimeSlot;
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
	 * Return the value associated with the column: appointment_no
	 */
	public java.lang.String getAppointmentNo () {
		return appointmentNo;
	}

	/**
	 * Set the value related to the column: appointment_no
	 * @param appointmentNo the appointment_no value
	 */
	public void setAppointmentNo (java.lang.String appointmentNo) {
		this.appointmentNo = appointmentNo;
	}



	/**
	 * Return the value associated with the column: appointment_status
	 */
	public java.lang.String getAppointmentStatus () {
		return appointmentStatus;
	}

	/**
	 * Set the value related to the column: appointment_status
	 * @param appointmentStatus the appointment_status value
	 */
	public void setAppointmentStatus (java.lang.String appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}



	/**
	 * Return the value associated with the column: appointment_cancel_date
	 */
	public java.util.Date getAppointmentCancelDate () {
		return appointmentCancelDate;
	}

	/**
	 * Set the value related to the column: appointment_cancel_date
	 * @param appointmentCancelDate the appointment_cancel_date value
	 */
	public void setAppointmentCancelDate (java.util.Date appointmentCancelDate) {
		this.appointmentCancelDate = appointmentCancelDate;
	}



	/**
	 * Return the value associated with the column: mobile_no
	 */
	public java.lang.String getMobileNo () {
		return mobileNo;
	}

	/**
	 * Set the value related to the column: mobile_no
	 * @param mobileNo the mobile_no value
	 */
	public void setMobileNo (java.lang.String mobileNo) {
		this.mobileNo = mobileNo;
	}



	/**
	 * Return the value associated with the column: queue_priority
	 */
	public java.lang.Integer getQueuePriority () {
		return queuePriority;
	}

	/**
	 * Set the value related to the column: queue_priority
	 * @param queuePriority the queue_priority value
	 */
	public void setQueuePriority (java.lang.Integer queuePriority) {
		this.queuePriority = queuePriority;
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
	 * Return the value associated with the column: app_session
	 */
	public jkt.hms.masters.business.MasSession getAppSession () {
		return appSession;
	}

	/**
	 * Set the value related to the column: app_session
	 * @param appSession the app_session value
	 */
	public void setAppSession (jkt.hms.masters.business.MasSession appSession) {
		this.appSession = appSession;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.AppPatientAppointments)) return false;
		else {
			jkt.hms.masters.business.AppPatientAppointments appPatientAppointments = (jkt.hms.masters.business.AppPatientAppointments) obj;
			if (null == this.getId() || null == appPatientAppointments.getId()) return false;
			else return (this.getId().equals(appPatientAppointments.getId()));
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
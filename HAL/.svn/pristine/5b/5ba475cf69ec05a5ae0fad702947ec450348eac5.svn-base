package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the PATIENT_APPOINTMENT table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="PATIENT_APPOINTMENT"
 */

public abstract class BasePatientAppointment  implements Serializable {

	public static String REF = "PatientAppointment";
	public static String PROP_RELATION = "Relation";
	public static String PROP_AGE = "Age";
	public static String PROP_RANK = "Rank";
	public static String PROP_SERVICE_NO = "ServiceNo";
	public static String PROP_APPOINTMENT_DATE = "AppointmentDate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_MEDICAL_OFFICER = "MedicalOfficer";
	public static String PROP_SERV_PERS_NAME = "ServPersName";
	public static String PROP_PATIENT_NAME = "PatientName";
	public static String PROP_APPOINTMENT_TIME = "AppointmentTime";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_HIN = "Hin";
	public static String PROP_SEX = "Sex";


	// constructors
	public BasePatientAppointment () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePatientAppointment (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String serviceNo;
	private java.lang.String patientName;
	private java.lang.String servPersName;
	private java.lang.String age;
	private java.util.Date appointmentDate;
	private java.lang.String appointmentTime;
	private java.lang.String department;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.MasRelation relation;
	private jkt.hms.masters.business.MasRank rank;
	private jkt.hms.masters.business.MasAdministrativeSex sex;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasEmployee medicalOfficer;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="PATIENT_APPOINTMENT_ID"
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
	 * Return the value associated with the column: SERVICE_NO
	 */
	public java.lang.String getServiceNo () {
		return serviceNo;
	}

	/**
	 * Set the value related to the column: SERVICE_NO
	 * @param serviceNo the SERVICE_NO value
	 */
	public void setServiceNo (java.lang.String serviceNo) {
		this.serviceNo = serviceNo;
	}



	/**
	 * Return the value associated with the column: PATIENT_NAME
	 */
	public java.lang.String getPatientName () {
		return patientName;
	}

	/**
	 * Set the value related to the column: PATIENT_NAME
	 * @param patientName the PATIENT_NAME value
	 */
	public void setPatientName (java.lang.String patientName) {
		this.patientName = patientName;
	}



	/**
	 * Return the value associated with the column: SERV_PERS_NAME
	 */
	public java.lang.String getServPersName () {
		return servPersName;
	}

	/**
	 * Set the value related to the column: SERV_PERS_NAME
	 * @param servPersName the SERV_PERS_NAME value
	 */
	public void setServPersName (java.lang.String servPersName) {
		this.servPersName = servPersName;
	}



	/**
	 * Return the value associated with the column: AGE
	 */
	public java.lang.String getAge () {
		return age;
	}

	/**
	 * Set the value related to the column: AGE
	 * @param age the AGE value
	 */
	public void setAge (java.lang.String age) {
		this.age = age;
	}



	/**
	 * Return the value associated with the column: APPOINTMENT_DATE
	 */
	public java.util.Date getAppointmentDate () {
		return appointmentDate;
	}

	/**
	 * Set the value related to the column: APPOINTMENT_DATE
	 * @param appointmentDate the APPOINTMENT_DATE value
	 */
	public void setAppointmentDate (java.util.Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}



	/**
	 * Return the value associated with the column: APPOINTMENT_TIME
	 */
	public java.lang.String getAppointmentTime () {
		return appointmentTime;
	}

	/**
	 * Set the value related to the column: APPOINTMENT_TIME
	 * @param appointmentTime the APPOINTMENT_TIME value
	 */
	public void setAppointmentTime (java.lang.String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}



	/**
	 * Return the value associated with the column: DEPARTMENT
	 */
	public java.lang.String getDepartment () {
		return department;
	}

	/**
	 * Set the value related to the column: DEPARTMENT
	 * @param department the DEPARTMENT value
	 */
	public void setDepartment (java.lang.String department) {
		this.department = department;
	}



	/**
	 * Return the value associated with the column: STATUS
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: STATUS
	 * @param status the STATUS value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
	}



	/**
	 * Return the value associated with the column: LAST_CHG_DATE
	 */
	public java.util.Date getLastChgDate () {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: LAST_CHG_DATE
	 * @param lastChgDate the LAST_CHG_DATE value
	 */
	public void setLastChgDate (java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}



	/**
	 * Return the value associated with the column: LAST_CHG_TIME
	 */
	public java.lang.String getLastChgTime () {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: LAST_CHG_TIME
	 * @param lastChgTime the LAST_CHG_TIME value
	 */
	public void setLastChgTime (java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
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
	 * Return the value associated with the column: relation_id
	 */
	public jkt.hms.masters.business.MasRelation getRelation () {
		return relation;
	}

	/**
	 * Set the value related to the column: relation_id
	 * @param relation the relation_id value
	 */
	public void setRelation (jkt.hms.masters.business.MasRelation relation) {
		this.relation = relation;
	}



	/**
	 * Return the value associated with the column: rank_id
	 */
	public jkt.hms.masters.business.MasRank getRank () {
		return rank;
	}

	/**
	 * Set the value related to the column: rank_id
	 * @param rank the rank_id value
	 */
	public void setRank (jkt.hms.masters.business.MasRank rank) {
		this.rank = rank;
	}



	/**
	 * Return the value associated with the column: sex_id
	 */
	public jkt.hms.masters.business.MasAdministrativeSex getSex () {
		return sex;
	}

	/**
	 * Set the value related to the column: sex_id
	 * @param sex the sex_id value
	 */
	public void setSex (jkt.hms.masters.business.MasAdministrativeSex sex) {
		this.sex = sex;
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
	 * Return the value associated with the column: medical_officer_id
	 */
	public jkt.hms.masters.business.MasEmployee getMedicalOfficer () {
		return medicalOfficer;
	}

	/**
	 * Set the value related to the column: medical_officer_id
	 * @param medicalOfficer the medical_officer_id value
	 */
	public void setMedicalOfficer (jkt.hms.masters.business.MasEmployee medicalOfficer) {
		this.medicalOfficer = medicalOfficer;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PatientAppointment)) return false;
		else {
			jkt.hms.masters.business.PatientAppointment patientAppointment = (jkt.hms.masters.business.PatientAppointment) obj;
			if (null == this.getId() || null == patientAppointment.getId()) return false;
			else return (this.getId().equals(patientAppointment.getId()));
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
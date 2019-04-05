package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the AMBULANCE_RUN_REGISTER table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="AMBULANCE_RUN_REGISTER"
 */

public abstract class BaseAmbulanceRunRegister  implements Serializable {

	public static String REF = "AmbulanceRunRegister";
	public static String PROP_AGE = "Age";
	public static String PROP_RANK = "Rank";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_SERVICE_TYPE = "ServiceType";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_LAST_NAME = "LastName";
	public static String PROP_TO_DESTINATION = "ToDestination";
	public static String PROP_UNIT = "Unit";
	public static String PROP_DIAGNOSIS = "Diagnosis";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_FROM_SMC = "FromSmc";
	public static String PROP_FIRST_NAME = "FirstName";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_SEX = "Sex";
	public static String PROP_RELATION = "Relation";
	public static String PROP_SERVICE_NO = "ServiceNo";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_CHARGE = "Charge";
	public static String PROP_AMBULANCE_RUN_TIME = "AmbulanceRunTime";
	public static String PROP_PATIENT_NAME = "PatientName";
	public static String PROP_SERVICE_PERSON_NAME = "ServicePersonName";
	public static String PROP_SERVICE_STATUS = "ServiceStatus";
	public static String PROP_AMBULANCE_RUN_DATE = "AmbulanceRunDate";
	public static String PROP_MIDDLE_NAME = "MiddleName";
	public static String PROP_ID = "Id";
	public static String PROP_ATTENDANTS = "Attendants";
	public static String PROP_HIN = "Hin";


	// constructors
	public BaseAmbulanceRunRegister () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAmbulanceRunRegister (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date ambulanceRunDate;
	private java.lang.String ambulanceRunTime;
	private java.lang.String fromSmc;
	private java.lang.String toDestination;
	private java.lang.String serviceNo;
	private java.lang.String firstName;
	private java.lang.String middleName;
	private java.lang.String lastName;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String patientName;
	private java.lang.String servicePersonName;
	private java.lang.String diagnosis;
	private java.lang.String remarks;
	private java.lang.String age;
	private java.lang.String attendants;
	private java.math.BigDecimal charge;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasAdministrativeSex sex;
	private jkt.hms.masters.business.MasServiceType serviceType;
	private jkt.hms.masters.business.MasServiceStatus serviceStatus;
	private jkt.hms.masters.business.MasRank rank;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasRelation relation;
	private jkt.hms.masters.business.MasUnit unit;
	private jkt.hms.masters.business.Patient hin;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="AMBULANCE_RUN_REGISTER_ID"
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
	 * Return the value associated with the column: AMBULANCE_RUN_DATE
	 */
	public java.util.Date getAmbulanceRunDate () {
		return ambulanceRunDate;
	}

	/**
	 * Set the value related to the column: AMBULANCE_RUN_DATE
	 * @param ambulanceRunDate the AMBULANCE_RUN_DATE value
	 */
	public void setAmbulanceRunDate (java.util.Date ambulanceRunDate) {
		this.ambulanceRunDate = ambulanceRunDate;
	}



	/**
	 * Return the value associated with the column: AMBULANCE_RUN_TIME
	 */
	public java.lang.String getAmbulanceRunTime () {
		return ambulanceRunTime;
	}

	/**
	 * Set the value related to the column: AMBULANCE_RUN_TIME
	 * @param ambulanceRunTime the AMBULANCE_RUN_TIME value
	 */
	public void setAmbulanceRunTime (java.lang.String ambulanceRunTime) {
		this.ambulanceRunTime = ambulanceRunTime;
	}



	/**
	 * Return the value associated with the column: FROM_SMC
	 */
	public java.lang.String getFromSmc () {
		return fromSmc;
	}

	/**
	 * Set the value related to the column: FROM_SMC
	 * @param fromSmc the FROM_SMC value
	 */
	public void setFromSmc (java.lang.String fromSmc) {
		this.fromSmc = fromSmc;
	}



	/**
	 * Return the value associated with the column: TO_DESTINATION
	 */
	public java.lang.String getToDestination () {
		return toDestination;
	}

	/**
	 * Set the value related to the column: TO_DESTINATION
	 * @param toDestination the TO_DESTINATION value
	 */
	public void setToDestination (java.lang.String toDestination) {
		this.toDestination = toDestination;
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
	 * Return the value associated with the column: FIRST_NAME
	 */
	public java.lang.String getFirstName () {
		return firstName;
	}

	/**
	 * Set the value related to the column: FIRST_NAME
	 * @param firstName the FIRST_NAME value
	 */
	public void setFirstName (java.lang.String firstName) {
		this.firstName = firstName;
	}



	/**
	 * Return the value associated with the column: MIDDLE_NAME
	 */
	public java.lang.String getMiddleName () {
		return middleName;
	}

	/**
	 * Set the value related to the column: MIDDLE_NAME
	 * @param middleName the MIDDLE_NAME value
	 */
	public void setMiddleName (java.lang.String middleName) {
		this.middleName = middleName;
	}



	/**
	 * Return the value associated with the column: LAST_NAME
	 */
	public java.lang.String getLastName () {
		return lastName;
	}

	/**
	 * Set the value related to the column: LAST_NAME
	 * @param lastName the LAST_NAME value
	 */
	public void setLastName (java.lang.String lastName) {
		this.lastName = lastName;
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
	 * Return the value associated with the column: SERVICE_PERSON_NAME
	 */
	public java.lang.String getServicePersonName () {
		return servicePersonName;
	}

	/**
	 * Set the value related to the column: SERVICE_PERSON_NAME
	 * @param servicePersonName the SERVICE_PERSON_NAME value
	 */
	public void setServicePersonName (java.lang.String servicePersonName) {
		this.servicePersonName = servicePersonName;
	}



	/**
	 * Return the value associated with the column: DIAGNOSIS
	 */
	public java.lang.String getDiagnosis () {
		return diagnosis;
	}

	/**
	 * Set the value related to the column: DIAGNOSIS
	 * @param diagnosis the DIAGNOSIS value
	 */
	public void setDiagnosis (java.lang.String diagnosis) {
		this.diagnosis = diagnosis;
	}



	/**
	 * Return the value associated with the column: REMARKS
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: REMARKS
	 * @param remarks the REMARKS value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
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
	 * Return the value associated with the column: attendants
	 */
	public java.lang.String getAttendants () {
		return attendants;
	}

	/**
	 * Set the value related to the column: attendants
	 * @param attendants the attendants value
	 */
	public void setAttendants (java.lang.String attendants) {
		this.attendants = attendants;
	}



	/**
	 * Return the value associated with the column: charge
	 */
	public java.math.BigDecimal getCharge () {
		return charge;
	}

	/**
	 * Set the value related to the column: charge
	 * @param charge the charge value
	 */
	public void setCharge (java.math.BigDecimal charge) {
		this.charge = charge;
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
	 * Return the value associated with the column: service_type_id
	 */
	public jkt.hms.masters.business.MasServiceType getServiceType () {
		return serviceType;
	}

	/**
	 * Set the value related to the column: service_type_id
	 * @param serviceType the service_type_id value
	 */
	public void setServiceType (jkt.hms.masters.business.MasServiceType serviceType) {
		this.serviceType = serviceType;
	}



	/**
	 * Return the value associated with the column: service_status_id
	 */
	public jkt.hms.masters.business.MasServiceStatus getServiceStatus () {
		return serviceStatus;
	}

	/**
	 * Set the value related to the column: service_status_id
	 * @param serviceStatus the service_status_id value
	 */
	public void setServiceStatus (jkt.hms.masters.business.MasServiceStatus serviceStatus) {
		this.serviceStatus = serviceStatus;
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
	 * Return the value associated with the column: unit_id
	 */
	public jkt.hms.masters.business.MasUnit getUnit () {
		return unit;
	}

	/**
	 * Set the value related to the column: unit_id
	 * @param unit the unit_id value
	 */
	public void setUnit (jkt.hms.masters.business.MasUnit unit) {
		this.unit = unit;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.AmbulanceRunRegister)) return false;
		else {
			jkt.hms.masters.business.AmbulanceRunRegister ambulanceRunRegister = (jkt.hms.masters.business.AmbulanceRunRegister) obj;
			if (null == this.getId() || null == ambulanceRunRegister.getId()) return false;
			else return (this.getId().equals(ambulanceRunRegister.getId()));
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
package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the PHYSIOTHERAPY_DETAILS table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="PHYSIOTHERAPY_DETAILS"
 */

public abstract class BasePhysiotherapyDetails  implements Serializable {

	public static String REF = "PhysiotherapyDetails";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_MEDICAL_OFFICER = "MedicalOfficer";
	public static String PROP_SITTING_TIME = "SittingTime";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_TIME_BEGIN = "TimeBegin";
	public static String PROP_VISIT = "Visit";
	public static String PROP_TREATMENT = "Treatment";
	public static String PROP_NO_OF_DAYS = "NoOfDays";
	public static String PROP_DIAGNOSIS = "Diagnosis";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_NEXT_APPOINTMENT_DATE = "NextAppointmentDate";
	public static String PROP_NEXT_APPOINTMENT_TIME = "NextAppointmentTime";
	public static String PROP_DURATION = "Duration";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_PHY_VISIT_DATE = "PhyVisitDate";
	public static String PROP_TIME_COMPLETE = "TimeComplete";
	public static String PROP_HIN = "Hin";
	public static String PROP_PHY_VISIT_NO = "PhyVisitNo";
	public static String PROP_THERAPY_TYPE = "TherapyType";


	// constructors
	public BasePhysiotherapyDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePhysiotherapyDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String diagnosis;
	private java.lang.String sittingTime;
	private java.lang.String treatment;
	private java.lang.String remarks;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String duration;
	private java.lang.Integer noOfDays;
	private java.util.Date phyVisitDate;
	private java.lang.Integer phyVisitNo;
	private java.lang.String timeBegin;
	private java.lang.String timeComplete;
	private java.util.Date nextAppointmentDate;
	private java.lang.String nextAppointmentTime;

	// many to one
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasEmployee medicalOfficer;
	private jkt.hms.masters.business.MasTherapyType therapyType;
	private jkt.hms.masters.business.Users lastChgBy;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="PHYSIOTHERAPY_DETAILS_ID"
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
	 * Return the value associated with the column: SITTING_TIME
	 */
	public java.lang.String getSittingTime () {
		return sittingTime;
	}

	/**
	 * Set the value related to the column: SITTING_TIME
	 * @param sittingTime the SITTING_TIME value
	 */
	public void setSittingTime (java.lang.String sittingTime) {
		this.sittingTime = sittingTime;
	}



	/**
	 * Return the value associated with the column: TREATMENT
	 */
	public java.lang.String getTreatment () {
		return treatment;
	}

	/**
	 * Set the value related to the column: TREATMENT
	 * @param treatment the TREATMENT value
	 */
	public void setTreatment (java.lang.String treatment) {
		this.treatment = treatment;
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
	 * Return the value associated with the column: duration
	 */
	public java.lang.String getDuration () {
		return duration;
	}

	/**
	 * Set the value related to the column: duration
	 * @param duration the duration value
	 */
	public void setDuration (java.lang.String duration) {
		this.duration = duration;
	}



	/**
	 * Return the value associated with the column: no_of_days
	 */
	public java.lang.Integer getNoOfDays () {
		return noOfDays;
	}

	/**
	 * Set the value related to the column: no_of_days
	 * @param noOfDays the no_of_days value
	 */
	public void setNoOfDays (java.lang.Integer noOfDays) {
		this.noOfDays = noOfDays;
	}



	/**
	 * Return the value associated with the column: PHY_VISIT_DATE
	 */
	public java.util.Date getPhyVisitDate () {
		return phyVisitDate;
	}

	/**
	 * Set the value related to the column: PHY_VISIT_DATE
	 * @param phyVisitDate the PHY_VISIT_DATE value
	 */
	public void setPhyVisitDate (java.util.Date phyVisitDate) {
		this.phyVisitDate = phyVisitDate;
	}



	/**
	 * Return the value associated with the column: phy_visit_no
	 */
	public java.lang.Integer getPhyVisitNo () {
		return phyVisitNo;
	}

	/**
	 * Set the value related to the column: phy_visit_no
	 * @param phyVisitNo the phy_visit_no value
	 */
	public void setPhyVisitNo (java.lang.Integer phyVisitNo) {
		this.phyVisitNo = phyVisitNo;
	}



	/**
	 * Return the value associated with the column: time_begin
	 */
	public java.lang.String getTimeBegin () {
		return timeBegin;
	}

	/**
	 * Set the value related to the column: time_begin
	 * @param timeBegin the time_begin value
	 */
	public void setTimeBegin (java.lang.String timeBegin) {
		this.timeBegin = timeBegin;
	}



	/**
	 * Return the value associated with the column: time_complete
	 */
	public java.lang.String getTimeComplete () {
		return timeComplete;
	}

	/**
	 * Set the value related to the column: time_complete
	 * @param timeComplete the time_complete value
	 */
	public void setTimeComplete (java.lang.String timeComplete) {
		this.timeComplete = timeComplete;
	}



	/**
	 * Return the value associated with the column: next_appointment_date
	 */
	public java.util.Date getNextAppointmentDate () {
		return nextAppointmentDate;
	}

	/**
	 * Set the value related to the column: next_appointment_date
	 * @param nextAppointmentDate the next_appointment_date value
	 */
	public void setNextAppointmentDate (java.util.Date nextAppointmentDate) {
		this.nextAppointmentDate = nextAppointmentDate;
	}



	/**
	 * Return the value associated with the column: next_appointment_time
	 */
	public java.lang.String getNextAppointmentTime () {
		return nextAppointmentTime;
	}

	/**
	 * Set the value related to the column: next_appointment_time
	 * @param nextAppointmentTime the next_appointment_time value
	 */
	public void setNextAppointmentTime (java.lang.String nextAppointmentTime) {
		this.nextAppointmentTime = nextAppointmentTime;
	}



	/**
	 * Return the value associated with the column: VISIT_ID
	 */
	public jkt.hms.masters.business.Visit getVisit () {
		return visit;
	}

	/**
	 * Set the value related to the column: VISIT_ID
	 * @param visit the VISIT_ID value
	 */
	public void setVisit (jkt.hms.masters.business.Visit visit) {
		this.visit = visit;
	}



	/**
	 * Return the value associated with the column: HIN_ID
	 */
	public jkt.hms.masters.business.Patient getHin () {
		return hin;
	}

	/**
	 * Set the value related to the column: HIN_ID
	 * @param hin the HIN_ID value
	 */
	public void setHin (jkt.hms.masters.business.Patient hin) {
		this.hin = hin;
	}



	/**
	 * Return the value associated with the column: HOSPITAL_ID
	 */
	public jkt.hms.masters.business.MasHospital getHospital () {
		return hospital;
	}

	/**
	 * Set the value related to the column: HOSPITAL_ID
	 * @param hospital the HOSPITAL_ID value
	 */
	public void setHospital (jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}



	/**
	 * Return the value associated with the column: MEDICAL_OFFICER
	 */
	public jkt.hms.masters.business.MasEmployee getMedicalOfficer () {
		return medicalOfficer;
	}

	/**
	 * Set the value related to the column: MEDICAL_OFFICER
	 * @param medicalOfficer the MEDICAL_OFFICER value
	 */
	public void setMedicalOfficer (jkt.hms.masters.business.MasEmployee medicalOfficer) {
		this.medicalOfficer = medicalOfficer;
	}



	/**
	 * Return the value associated with the column: THERAPY_TYPE_ID
	 */
	public jkt.hms.masters.business.MasTherapyType getTherapyType () {
		return therapyType;
	}

	/**
	 * Set the value related to the column: THERAPY_TYPE_ID
	 * @param therapyType the THERAPY_TYPE_ID value
	 */
	public void setTherapyType (jkt.hms.masters.business.MasTherapyType therapyType) {
		this.therapyType = therapyType;
	}



	/**
	 * Return the value associated with the column: LAST_CHG_BY
	 */
	public jkt.hms.masters.business.Users getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: LAST_CHG_BY
	 * @param lastChgBy the LAST_CHG_BY value
	 */
	public void setLastChgBy (jkt.hms.masters.business.Users lastChgBy) {
		this.lastChgBy = lastChgBy;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PhysiotherapyDetails)) return false;
		else {
			jkt.hms.masters.business.PhysiotherapyDetails physiotherapyDetails = (jkt.hms.masters.business.PhysiotherapyDetails) obj;
			if (null == this.getId() || null == physiotherapyDetails.getId()) return false;
			else return (this.getId().equals(physiotherapyDetails.getId()));
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
package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the INJ_APPOINTMENT_DETAILS table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="INJ_APPOINTMENT_DETAILS"
 */

public abstract class BaseInjAppointmentDetails  implements Serializable {

	public static String REF = "InjAppointmentDetails";
	public static String PROP_DOSE = "Dose";
	public static String PROP_ADMINISTRATOR = "Administrator";
	public static String PROP_FINAL_STATUS = "FinalStatus";
	public static String PROP_PATIENT_PRESCRIPTION_DETAILS = "PatientPrescriptionDetails";
	public static String PROP_NO_OF_DAYS = "NoOfDays";
	public static String PROP_APPOINTMENT_TIME = "AppointmentTime";
	public static String PROP_STATUS = "Status";
	public static String PROP_INJ_APPOINTMENT_HEADER = "InjAppointmentHeader";
	public static String PROP_ITEM = "Item";
	public static String PROP_NEXT_APPOINTMENT_DATE = "NextAppointmentDate";
	public static String PROP_IMMUNIZATION_INJ = "ImmunizationInj";
	public static String PROP_INJ_APPOINTMENT_DATE = "InjAppointmentDate";
	public static String PROP_ID = "Id";
	public static String PROP_FREQUENCY = "Frequency";
	public static String PROP_NURSING_REMARK = "NursingRemark";
	public static String PROP_BATCH_NO = "BatchNo";
	public static String PROP_ROUTE = "Route";
	public static String PROP_ISSUE_STOCK = "IssueStock";
	public static String PROP_VACCIN_ID = "VaccinId";


	// constructors
	public BaseInjAppointmentDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseInjAppointmentDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String appointmentTime;
	private java.lang.String dose;
	private java.lang.String route;
	private java.lang.Integer noOfDays;
	private java.lang.String status;
	private java.util.Date injAppointmentDate;
	private java.lang.String finalStatus;
	private java.lang.String batchNo;
	private java.lang.String administrator;
	private java.lang.String nursingRemark;
	private java.util.Date nextAppointmentDate;
	private java.lang.Integer issueStock;
	private java.lang.String immunizationInj;
	private java.lang.Integer vaccinId;

	// many to one
	private jkt.hms.masters.business.MasStoreItem item;
	private jkt.hms.masters.business.MasFrequency frequency;
	private jkt.hms.masters.business.InjAppointmentHeader injAppointmentHeader;
	private jkt.hms.masters.business.PatientPrescriptionDetails patientPrescriptionDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="INJ_APPOINTMENT_DETAILS_ID"
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
	 * Return the value associated with the column: DOSE
	 */
	public java.lang.String getDose () {
		return dose;
	}

	/**
	 * Set the value related to the column: DOSE
	 * @param dose the DOSE value
	 */
	public void setDose (java.lang.String dose) {
		this.dose = dose;
	}



	/**
	 * Return the value associated with the column: ROUTE
	 */
	public java.lang.String getRoute () {
		return route;
	}

	/**
	 * Set the value related to the column: ROUTE
	 * @param route the ROUTE value
	 */
	public void setRoute (java.lang.String route) {
		this.route = route;
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
	 * Return the value associated with the column: inj_appointment_date
	 */
	public java.util.Date getInjAppointmentDate () {
		return injAppointmentDate;
	}

	/**
	 * Set the value related to the column: inj_appointment_date
	 * @param injAppointmentDate the inj_appointment_date value
	 */
	public void setInjAppointmentDate (java.util.Date injAppointmentDate) {
		this.injAppointmentDate = injAppointmentDate;
	}



	/**
	 * Return the value associated with the column: final_status
	 */
	public java.lang.String getFinalStatus () {
		return finalStatus;
	}

	/**
	 * Set the value related to the column: final_status
	 * @param finalStatus the final_status value
	 */
	public void setFinalStatus (java.lang.String finalStatus) {
		this.finalStatus = finalStatus;
	}



	/**
	 * Return the value associated with the column: batch_no
	 */
	public java.lang.String getBatchNo () {
		return batchNo;
	}

	/**
	 * Set the value related to the column: batch_no
	 * @param batchNo the batch_no value
	 */
	public void setBatchNo (java.lang.String batchNo) {
		this.batchNo = batchNo;
	}



	/**
	 * Return the value associated with the column: administrator
	 */
	public java.lang.String getAdministrator () {
		return administrator;
	}

	/**
	 * Set the value related to the column: administrator
	 * @param administrator the administrator value
	 */
	public void setAdministrator (java.lang.String administrator) {
		this.administrator = administrator;
	}



	/**
	 * Return the value associated with the column: nursing_remark
	 */
	public java.lang.String getNursingRemark () {
		return nursingRemark;
	}

	/**
	 * Set the value related to the column: nursing_remark
	 * @param nursingRemark the nursing_remark value
	 */
	public void setNursingRemark (java.lang.String nursingRemark) {
		this.nursingRemark = nursingRemark;
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
	 * Return the value associated with the column: issue_stock
	 */
	public java.lang.Integer getIssueStock () {
		return issueStock;
	}

	/**
	 * Set the value related to the column: issue_stock
	 * @param issueStock the issue_stock value
	 */
	public void setIssueStock (java.lang.Integer issueStock) {
		this.issueStock = issueStock;
	}



	/**
	 * Return the value associated with the column: immunization_inj
	 */
	public java.lang.String getImmunizationInj () {
		return immunizationInj;
	}

	/**
	 * Set the value related to the column: immunization_inj
	 * @param immunizationInj the immunization_inj value
	 */
	public void setImmunizationInj (java.lang.String immunizationInj) {
		this.immunizationInj = immunizationInj;
	}



	/**
	 * Return the value associated with the column: vaccin_id
	 */
	public java.lang.Integer getVaccinId () {
		return vaccinId;
	}

	/**
	 * Set the value related to the column: vaccin_id
	 * @param vaccinId the vaccin_id value
	 */
	public void setVaccinId (java.lang.Integer vaccinId) {
		this.vaccinId = vaccinId;
	}



	/**
	 * Return the value associated with the column: ITEM_ID
	 */
	public jkt.hms.masters.business.MasStoreItem getItem () {
		return item;
	}

	/**
	 * Set the value related to the column: ITEM_ID
	 * @param item the ITEM_ID value
	 */
	public void setItem (jkt.hms.masters.business.MasStoreItem item) {
		this.item = item;
	}



	/**
	 * Return the value associated with the column: FREQUENCY_ID
	 */
	public jkt.hms.masters.business.MasFrequency getFrequency () {
		return frequency;
	}

	/**
	 * Set the value related to the column: FREQUENCY_ID
	 * @param frequency the FREQUENCY_ID value
	 */
	public void setFrequency (jkt.hms.masters.business.MasFrequency frequency) {
		this.frequency = frequency;
	}



	/**
	 * Return the value associated with the column: INJ_APPOINTMENT_HEADER_ID
	 */
	public jkt.hms.masters.business.InjAppointmentHeader getInjAppointmentHeader () {
		return injAppointmentHeader;
	}

	/**
	 * Set the value related to the column: INJ_APPOINTMENT_HEADER_ID
	 * @param injAppointmentHeader the INJ_APPOINTMENT_HEADER_ID value
	 */
	public void setInjAppointmentHeader (jkt.hms.masters.business.InjAppointmentHeader injAppointmentHeader) {
		this.injAppointmentHeader = injAppointmentHeader;
	}



	/**
	 * Return the value associated with the column: PRESCRIPTION_DETAILS_ID
	 */
	public jkt.hms.masters.business.PatientPrescriptionDetails getPatientPrescriptionDetails () {
		return patientPrescriptionDetails;
	}

	/**
	 * Set the value related to the column: PRESCRIPTION_DETAILS_ID
	 * @param patientPrescriptionDetails the PRESCRIPTION_DETAILS_ID value
	 */
	public void setPatientPrescriptionDetails (jkt.hms.masters.business.PatientPrescriptionDetails patientPrescriptionDetails) {
		this.patientPrescriptionDetails = patientPrescriptionDetails;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.InjAppointmentDetails)) return false;
		else {
			jkt.hms.masters.business.InjAppointmentDetails injAppointmentDetails = (jkt.hms.masters.business.InjAppointmentDetails) obj;
			if (null == this.getId() || null == injAppointmentDetails.getId()) return false;
			else return (this.getId().equals(injAppointmentDetails.getId()));
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
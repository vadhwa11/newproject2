package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the therapy_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="therapy_details"
 */

public abstract class BaseTherapyDetails  implements Serializable {

	public static String REF = "TherapyDetails";
	public static String PROP_FINAL_PROCEDURE_STATUS = "FinalProcedureStatus";
	public static String PROP_PROCEDURE_TIME = "ProcedureTime";
	public static String PROP_OPD_REMARKS = "OpdRemarks";
	public static String PROP_APPOINTMENT_DATE = "AppointmentDate";
	public static String PROP_PROCEDURE = "Procedure";
	public static String PROP_TEETH_REQUIRED_TREATMENT = "TeethRequiredTreatment";
	public static String PROP_NO_OF_DAYS = "NoOfDays";
	public static String PROP_APPOINTMENT_TIME = "AppointmentTime";
	public static String PROP_STATUS = "Status";
	public static String PROP_NEXT_APPOINTMENT_DATE = "NextAppointmentDate";
	public static String PROP_PROCEDURE_HEADER = "ProcedureHeader";
	public static String PROP_THERAPY_REMARKS = "TherapyRemarks";
	public static String PROP_ID = "Id";
	public static String PROP_FREQUENCY = "Frequency";
	public static String PROP_NURSING_REMARK = "NursingRemark";
	public static String PROP_PROCEDURE_NAME = "ProcedureName";
	public static String PROP_PROCEDURE_DATE = "ProcedureDate";


	// constructors
	public BaseTherapyDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTherapyDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String opdRemarks;
	private java.lang.String therapyRemarks;
	private java.lang.String procedureName;
	private java.lang.String status;
	private java.lang.Integer noOfDays;
	private java.util.Date appointmentDate;
	private java.lang.String finalProcedureStatus;
	private java.lang.String nursingRemark;
	private java.util.Date nextAppointmentDate;
	private java.lang.String appointmentTime;
	private java.util.Date procedureDate;
	private java.lang.String procedureTime;
	private java.lang.String teethRequiredTreatment;

	// many to one
	private jkt.hms.masters.business.TherapyHeader procedureHeader;
	private jkt.hms.masters.business.MasNursingCare procedure;
	private jkt.hms.masters.business.MasFrequency frequency;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="PROCEDURE_DETAILS_ID"
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
	 * Return the value associated with the column: opd_remarks
	 */
	public java.lang.String getOpdRemarks () {
		return opdRemarks;
	}

	/**
	 * Set the value related to the column: opd_remarks
	 * @param opdRemarks the opd_remarks value
	 */
	public void setOpdRemarks (java.lang.String opdRemarks) {
		this.opdRemarks = opdRemarks;
	}



	/**
	 * Return the value associated with the column: therapy_remarks
	 */
	public java.lang.String getTherapyRemarks () {
		return therapyRemarks;
	}

	/**
	 * Set the value related to the column: therapy_remarks
	 * @param therapyRemarks the therapy_remarks value
	 */
	public void setTherapyRemarks (java.lang.String therapyRemarks) {
		this.therapyRemarks = therapyRemarks;
	}



	/**
	 * Return the value associated with the column: PROCEDURE_NAME
	 */
	public java.lang.String getProcedureName () {
		return procedureName;
	}

	/**
	 * Set the value related to the column: PROCEDURE_NAME
	 * @param procedureName the PROCEDURE_NAME value
	 */
	public void setProcedureName (java.lang.String procedureName) {
		this.procedureName = procedureName;
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
	 * Return the value associated with the column: final_procedure_status
	 */
	public java.lang.String getFinalProcedureStatus () {
		return finalProcedureStatus;
	}

	/**
	 * Set the value related to the column: final_procedure_status
	 * @param finalProcedureStatus the final_procedure_status value
	 */
	public void setFinalProcedureStatus (java.lang.String finalProcedureStatus) {
		this.finalProcedureStatus = finalProcedureStatus;
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
	 * Return the value associated with the column: appointment_time
	 */
	public java.lang.String getAppointmentTime () {
		return appointmentTime;
	}

	/**
	 * Set the value related to the column: appointment_time
	 * @param appointmentTime the appointment_time value
	 */
	public void setAppointmentTime (java.lang.String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}



	/**
	 * Return the value associated with the column: procedure_date
	 */
	public java.util.Date getProcedureDate () {
		return procedureDate;
	}

	/**
	 * Set the value related to the column: procedure_date
	 * @param procedureDate the procedure_date value
	 */
	public void setProcedureDate (java.util.Date procedureDate) {
		this.procedureDate = procedureDate;
	}



	/**
	 * Return the value associated with the column: procedure_time
	 */
	public java.lang.String getProcedureTime () {
		return procedureTime;
	}

	/**
	 * Set the value related to the column: procedure_time
	 * @param procedureTime the procedure_time value
	 */
	public void setProcedureTime (java.lang.String procedureTime) {
		this.procedureTime = procedureTime;
	}



	/**
	 * Return the value associated with the column: teeth_required_treatment
	 */
	public java.lang.String getTeethRequiredTreatment () {
		return teethRequiredTreatment;
	}

	/**
	 * Set the value related to the column: teeth_required_treatment
	 * @param teethRequiredTreatment the teeth_required_treatment value
	 */
	public void setTeethRequiredTreatment (java.lang.String teethRequiredTreatment) {
		this.teethRequiredTreatment = teethRequiredTreatment;
	}



	/**
	 * Return the value associated with the column: PROCEDURE_HEADER_ID
	 */
	public jkt.hms.masters.business.TherapyHeader getProcedureHeader () {
		return procedureHeader;
	}

	/**
	 * Set the value related to the column: PROCEDURE_HEADER_ID
	 * @param procedureHeader the PROCEDURE_HEADER_ID value
	 */
	public void setProcedureHeader (jkt.hms.masters.business.TherapyHeader procedureHeader) {
		this.procedureHeader = procedureHeader;
	}



	/**
	 * Return the value associated with the column: PROCEDURE_ID
	 */
	public jkt.hms.masters.business.MasNursingCare getProcedure () {
		return procedure;
	}

	/**
	 * Set the value related to the column: PROCEDURE_ID
	 * @param procedure the PROCEDURE_ID value
	 */
	public void setProcedure (jkt.hms.masters.business.MasNursingCare procedure) {
		this.procedure = procedure;
	}



	/**
	 * Return the value associated with the column: frequency_id
	 */
	public jkt.hms.masters.business.MasFrequency getFrequency () {
		return frequency;
	}

	/**
	 * Set the value related to the column: frequency_id
	 * @param frequency the frequency_id value
	 */
	public void setFrequency (jkt.hms.masters.business.MasFrequency frequency) {
		this.frequency = frequency;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.TherapyDetails)) return false;
		else {
			jkt.hms.masters.business.TherapyDetails therapyDetails = (jkt.hms.masters.business.TherapyDetails) obj;
			if (null == this.getId() || null == therapyDetails.getId()) return false;
			else return (this.getId().equals(therapyDetails.getId()));
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
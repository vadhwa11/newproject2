package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the PROCEDURE_DETAILS table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="PROCEDURE_DETAILS"
 */

public abstract class BaseProcedureDetails  implements Serializable {

	public static String REF = "ProcedureDetails";
	public static String PROP_FINAL_PROCEDURE_STATUS = "FinalProcedureStatus";
	public static String PROP_PROCEDURE_TIME = "ProcedureTime";
	public static String PROP_APPOINTMENT_DATE = "AppointmentDate";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_NURSING_CARE = "NursingCare";
	public static String PROP_NO_OF_DAYS = "NoOfDays";
	public static String PROP_APPOINTMENT_TIME = "AppointmentTime";
	public static String PROP_STATUS = "Status";
	public static String PROP_NEXT_APPOINTMENT_DATE = "NextAppointmentDate";
	public static String PROP_PROCEDURE_HEADER = "ProcedureHeader";
	public static String PROP_ID = "Id";
	public static String PROP_FREQUENCY = "Frequency";
	public static String PROP_NURSING_REMARK = "NursingRemark";
	public static String PROP_PROCEDURE_NAME = "ProcedureName";
	public static String PROP_PROCEDURE_DATE = "ProcedureDate";


	// constructors
	public BaseProcedureDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseProcedureDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String remarks;
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

	// many to one
	private jkt.hms.masters.business.ProcedureHeader procedureHeader;
	private jkt.hms.masters.business.MasNursingCare nursingCare;
	private jkt.hms.masters.business.MasFrequency frequency;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
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
	 * Return the value associated with the column: PROCEDURE_HEADER_ID
	 */
	public jkt.hms.masters.business.ProcedureHeader getProcedureHeader () {
		return procedureHeader;
	}

	/**
	 * Set the value related to the column: PROCEDURE_HEADER_ID
	 * @param procedureHeader the PROCEDURE_HEADER_ID value
	 */
	public void setProcedureHeader (jkt.hms.masters.business.ProcedureHeader procedureHeader) {
		this.procedureHeader = procedureHeader;
	}



	/**
	 * Return the value associated with the column: PROCEDURE_ID
	 */
	public jkt.hms.masters.business.MasNursingCare getNursingCare () {
		return nursingCare;
	}

	/**
	 * Set the value related to the column: PROCEDURE_ID
	 * @param nursingCare the PROCEDURE_ID value
	 */
	public void setNursingCare (jkt.hms.masters.business.MasNursingCare nursingCare) {
		this.nursingCare = nursingCare;
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
		if (!(obj instanceof jkt.hms.masters.business.ProcedureDetails)) return false;
		else {
			jkt.hms.masters.business.ProcedureDetails procedureDetails = (jkt.hms.masters.business.ProcedureDetails) obj;
			if (null == this.getId() || null == procedureDetails.getId()) return false;
			else return (this.getId().equals(procedureDetails.getId()));
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
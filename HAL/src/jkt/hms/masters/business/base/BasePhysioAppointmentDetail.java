package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the PHYSIO_APPOINTMENT_DETAIL table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="PHYSIO_APPOINTMENT_DETAIL"
 */

public abstract class BasePhysioAppointmentDetail  implements Serializable {

	public static String REF = "PhysioAppointmentDetail";
	public static String PROP_APPOINTMENT_HEADER = "AppointmentHeader";
	public static String PROP_VISIT_STATUS = "VisitStatus";
	public static String PROP_APPOINTMENT_TIME = "AppointmentTime";
	public static String PROP_APPOINTMENT_DATE = "AppointmentDate";
	public static String PROP_DURATION = "Duration";
	public static String PROP_THERAPY = "Therapy";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_ID = "Id";
	public static String PROP_FREQUENCY = "Frequency";
	public static String PROP_NO_OF_DAYS = "NoOfDays";


	// constructors
	public BasePhysioAppointmentDetail () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePhysioAppointmentDetail (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer noOfDays;
	private java.lang.String duration;
	private java.lang.String remarks;
	private java.lang.String appointmentTime;
	private java.util.Date appointmentDate;
	private java.lang.String visitStatus;

	// many to one
	private jkt.hms.masters.business.MasTherapyType therapy;
	private jkt.hms.masters.business.PhysioAppointmentHeader appointmentHeader;
	private jkt.hms.masters.business.MasFrequency frequency;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="APPOINTMENT_DETAIL_ID"
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
	 * Return the value associated with the column: NO_OF_DAYS
	 */
	public java.lang.Integer getNoOfDays () {
		return noOfDays;
	}

	/**
	 * Set the value related to the column: NO_OF_DAYS
	 * @param noOfDays the NO_OF_DAYS value
	 */
	public void setNoOfDays (java.lang.Integer noOfDays) {
		this.noOfDays = noOfDays;
	}



	/**
	 * Return the value associated with the column: DURATION
	 */
	public java.lang.String getDuration () {
		return duration;
	}

	/**
	 * Set the value related to the column: DURATION
	 * @param duration the DURATION value
	 */
	public void setDuration (java.lang.String duration) {
		this.duration = duration;
	}



	/**
	 * Return the value associated with the column: REMARKs
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: REMARKs
	 * @param remarks the REMARKs value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
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
	 * Return the value associated with the column: visit_status
	 */
	public java.lang.String getVisitStatus () {
		return visitStatus;
	}

	/**
	 * Set the value related to the column: visit_status
	 * @param visitStatus the visit_status value
	 */
	public void setVisitStatus (java.lang.String visitStatus) {
		this.visitStatus = visitStatus;
	}



	/**
	 * Return the value associated with the column: therapy_id
	 */
	public jkt.hms.masters.business.MasTherapyType getTherapy () {
		return therapy;
	}

	/**
	 * Set the value related to the column: therapy_id
	 * @param therapy the therapy_id value
	 */
	public void setTherapy (jkt.hms.masters.business.MasTherapyType therapy) {
		this.therapy = therapy;
	}



	/**
	 * Return the value associated with the column: APPOINTMENT_HEADER_ID
	 */
	public jkt.hms.masters.business.PhysioAppointmentHeader getAppointmentHeader () {
		return appointmentHeader;
	}

	/**
	 * Set the value related to the column: APPOINTMENT_HEADER_ID
	 * @param appointmentHeader the APPOINTMENT_HEADER_ID value
	 */
	public void setAppointmentHeader (jkt.hms.masters.business.PhysioAppointmentHeader appointmentHeader) {
		this.appointmentHeader = appointmentHeader;
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
		if (!(obj instanceof jkt.hms.masters.business.PhysioAppointmentDetail)) return false;
		else {
			jkt.hms.masters.business.PhysioAppointmentDetail physioAppointmentDetail = (jkt.hms.masters.business.PhysioAppointmentDetail) obj;
			if (null == this.getId() || null == physioAppointmentDetail.getId()) return false;
			else return (this.getId().equals(physioAppointmentDetail.getId()));
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
package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the PHYSIOTHERAPY_APPOINTMENT table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="PHYSIOTHERAPY_APPOINTMENT"
 */

public abstract class BasePhysiotherapyAppointment  implements Serializable {

	public static String REF = "PhysiotherapyAppointment";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_APPOINTMENT_DATE = "AppointmentDate";
	public static String PROP_TO_TIME = "ToTime";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_FROM_TIME = "FromTime";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_HIN = "Hin";
	public static String PROP_THERAPY_TYPE = "TherapyType";


	// constructors
	public BasePhysiotherapyAppointment () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePhysiotherapyAppointment (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String fromTime;
	private java.lang.String toTime;
	private java.util.Date appointmentDate;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasTherapyType therapyType;
	private jkt.hms.masters.business.MasHospital hospital;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="PHYSIOTHERAPY_APPOINTMENT_ID"
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
	 * Return the value associated with the column: FROM_TIME
	 */
	public java.lang.String getFromTime () {
		return fromTime;
	}

	/**
	 * Set the value related to the column: FROM_TIME
	 * @param fromTime the FROM_TIME value
	 */
	public void setFromTime (java.lang.String fromTime) {
		this.fromTime = fromTime;
	}



	/**
	 * Return the value associated with the column: TO_TIME
	 */
	public java.lang.String getToTime () {
		return toTime;
	}

	/**
	 * Set the value related to the column: TO_TIME
	 * @param toTime the TO_TIME value
	 */
	public void setToTime (java.lang.String toTime) {
		this.toTime = toTime;
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
	 * Return the value associated with the column: therapy_type_id
	 */
	public jkt.hms.masters.business.MasTherapyType getTherapyType () {
		return therapyType;
	}

	/**
	 * Set the value related to the column: therapy_type_id
	 * @param therapyType the therapy_type_id value
	 */
	public void setTherapyType (jkt.hms.masters.business.MasTherapyType therapyType) {
		this.therapyType = therapyType;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PhysiotherapyAppointment)) return false;
		else {
			jkt.hms.masters.business.PhysiotherapyAppointment physiotherapyAppointment = (jkt.hms.masters.business.PhysiotherapyAppointment) obj;
			if (null == this.getId() || null == physiotherapyAppointment.getId()) return false;
			else return (this.getId().equals(physiotherapyAppointment.getId()));
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
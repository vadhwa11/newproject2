package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the radiology_communication table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="radiology_communication"
 */

public abstract class BaseRadiologyCommunication  implements Serializable {

	public static String REF = "RadiologyCommunication";
	public static String PROP_FLAG = "Flag";
	public static String PROP_RADIO_DOCTOR_REMARKS = "RadioDoctorRemarks";
	public static String PROP_RADIO_REMARKS_TIME = "RadioRemarksTime";
	public static String PROP_FROM_DOCTOR = "FromDoctor";
	public static String PROP_OPD_REMARKS_TIME = "OpdRemarksTime";
	public static String PROP_ID = "Id";
	public static String PROP_OPD_REMARKS_DATE = "OpdRemarksDate";
	public static String PROP_OPD_DOCTOR_REMARKS = "OpdDoctorRemarks";
	public static String PROP_PATIENT_ID = "PatientId";
	public static String PROP_TO_RADIO_DOCTOR = "ToRadioDoctor";
	public static String PROP_RADIO_REMARKS_DATE = "RadioRemarksDate";


	// constructors
	public BaseRadiologyCommunication () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseRadiologyCommunication (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer patientId;
	private java.lang.String opdDoctorRemarks;
	private java.lang.String radioDoctorRemarks;
	private java.util.Date opdRemarksDate;
	private java.lang.String opdRemarksTime;
	private java.util.Date radioRemarksDate;
	private java.lang.String radioRemarksTime;
	private java.lang.String flag;

	// many to one
	private jkt.hms.masters.business.MasEmployee toRadioDoctor;
	private jkt.hms.masters.business.MasEmployee fromDoctor;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="id"
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
	 * Return the value associated with the column: patient_Id
	 */
	public java.lang.Integer getPatientId () {
		return patientId;
	}

	/**
	 * Set the value related to the column: patient_Id
	 * @param patientId the patient_Id value
	 */
	public void setPatientId (java.lang.Integer patientId) {
		this.patientId = patientId;
	}



	/**
	 * Return the value associated with the column: opd_doctor_remarks
	 */
	public java.lang.String getOpdDoctorRemarks () {
		return opdDoctorRemarks;
	}

	/**
	 * Set the value related to the column: opd_doctor_remarks
	 * @param opdDoctorRemarks the opd_doctor_remarks value
	 */
	public void setOpdDoctorRemarks (java.lang.String opdDoctorRemarks) {
		this.opdDoctorRemarks = opdDoctorRemarks;
	}



	/**
	 * Return the value associated with the column: radio_doctor_remarks
	 */
	public java.lang.String getRadioDoctorRemarks () {
		return radioDoctorRemarks;
	}

	/**
	 * Set the value related to the column: radio_doctor_remarks
	 * @param radioDoctorRemarks the radio_doctor_remarks value
	 */
	public void setRadioDoctorRemarks (java.lang.String radioDoctorRemarks) {
		this.radioDoctorRemarks = radioDoctorRemarks;
	}



	/**
	 * Return the value associated with the column: opd_remarks_date
	 */
	public java.util.Date getOpdRemarksDate () {
		return opdRemarksDate;
	}

	/**
	 * Set the value related to the column: opd_remarks_date
	 * @param opdRemarksDate the opd_remarks_date value
	 */
	public void setOpdRemarksDate (java.util.Date opdRemarksDate) {
		this.opdRemarksDate = opdRemarksDate;
	}



	/**
	 * Return the value associated with the column: opd_remarks_time
	 */
	public java.lang.String getOpdRemarksTime () {
		return opdRemarksTime;
	}

	/**
	 * Set the value related to the column: opd_remarks_time
	 * @param opdRemarksTime the opd_remarks_time value
	 */
	public void setOpdRemarksTime (java.lang.String opdRemarksTime) {
		this.opdRemarksTime = opdRemarksTime;
	}



	/**
	 * Return the value associated with the column: radio_remarks_date
	 */
	public java.util.Date getRadioRemarksDate () {
		return radioRemarksDate;
	}

	/**
	 * Set the value related to the column: radio_remarks_date
	 * @param radioRemarksDate the radio_remarks_date value
	 */
	public void setRadioRemarksDate (java.util.Date radioRemarksDate) {
		this.radioRemarksDate = radioRemarksDate;
	}



	/**
	 * Return the value associated with the column: radio_remarks_time
	 */
	public java.lang.String getRadioRemarksTime () {
		return radioRemarksTime;
	}

	/**
	 * Set the value related to the column: radio_remarks_time
	 * @param radioRemarksTime the radio_remarks_time value
	 */
	public void setRadioRemarksTime (java.lang.String radioRemarksTime) {
		this.radioRemarksTime = radioRemarksTime;
	}



	/**
	 * Return the value associated with the column: flag
	 */
	public java.lang.String getFlag () {
		return flag;
	}

	/**
	 * Set the value related to the column: flag
	 * @param flag the flag value
	 */
	public void setFlag (java.lang.String flag) {
		this.flag = flag;
	}



	/**
	 * Return the value associated with the column: to_radio_doctor
	 */
	public jkt.hms.masters.business.MasEmployee getToRadioDoctor () {
		return toRadioDoctor;
	}

	/**
	 * Set the value related to the column: to_radio_doctor
	 * @param toRadioDoctor the to_radio_doctor value
	 */
	public void setToRadioDoctor (jkt.hms.masters.business.MasEmployee toRadioDoctor) {
		this.toRadioDoctor = toRadioDoctor;
	}



	/**
	 * Return the value associated with the column: from_doctor
	 */
	public jkt.hms.masters.business.MasEmployee getFromDoctor () {
		return fromDoctor;
	}

	/**
	 * Set the value related to the column: from_doctor
	 * @param fromDoctor the from_doctor value
	 */
	public void setFromDoctor (jkt.hms.masters.business.MasEmployee fromDoctor) {
		this.fromDoctor = fromDoctor;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.RadiologyCommunication)) return false;
		else {
			jkt.hms.masters.business.RadiologyCommunication radiologyCommunication = (jkt.hms.masters.business.RadiologyCommunication) obj;
			if (null == this.getId() || null == radiologyCommunication.getId()) return false;
			else return (this.getId().equals(radiologyCommunication.getId()));
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
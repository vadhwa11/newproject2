package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the doctor_charge_config
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="doctor_charge_config"
 */

public abstract class BaseDoctorChargeConfig implements Serializable {

	public static String REF = "DoctorChargeConfig";
	public static String PROP_TIME_FROM = "TimeFrom";
	public static String PROP_DOCTOR_ID = "DoctorId";
	public static String PROP_DOC_CALL_ID = "DocCallId";
	public static String PROP_CHARGE = "Charge";
	public static String PROP_STATUS_ID = "StatusId";
	public static String PROP_AVAILABILITY_TYPE_ID = "AvailabilityTypeId";
	public static String PROP_RECORD = "Record";
	public static String PROP_TIME_TO = "TimeTo";
	public static String PROP_ID = "Id";

	// constructors
	public BaseDoctorChargeConfig() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDoctorChargeConfig(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseDoctorChargeConfig(java.lang.Integer id,
			java.lang.Integer doctorId) {

		this.setId(id);
		this.setDoctorId(doctorId);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer doctorId;
	private java.util.Date timeFrom;
	private java.util.Date timeTo;
	private java.lang.Integer availabilityTypeId;
	private java.lang.Float charge;
	private java.lang.Integer docCallId;
	private java.lang.Integer statusId;
	private java.lang.Integer record;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="doc_charge_config_id"
	 */
	public java.lang.Integer getId() {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * 
	 * @param id
	 *            the new ID
	 */
	public void setId(java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}

	/**
	 * Return the value associated with the column: doctor_id
	 */
	public java.lang.Integer getDoctorId() {
		return doctorId;
	}

	/**
	 * Set the value related to the column: doctor_id
	 * 
	 * @param doctorId
	 *            the doctor_id value
	 */
	public void setDoctorId(java.lang.Integer doctorId) {
		this.doctorId = doctorId;
	}

	/**
	 * Return the value associated with the column: time_from
	 */
	public java.util.Date getTimeFrom() {
		return timeFrom;
	}

	/**
	 * Set the value related to the column: time_from
	 * 
	 * @param timeFrom
	 *            the time_from value
	 */
	public void setTimeFrom(java.util.Date timeFrom) {
		this.timeFrom = timeFrom;
	}

	/**
	 * Return the value associated with the column: time_to
	 */
	public java.util.Date getTimeTo() {
		return timeTo;
	}

	/**
	 * Set the value related to the column: time_to
	 * 
	 * @param timeTo
	 *            the time_to value
	 */
	public void setTimeTo(java.util.Date timeTo) {
		this.timeTo = timeTo;
	}

	/**
	 * Return the value associated with the column: availability_type_id
	 */
	public java.lang.Integer getAvailabilityTypeId() {
		return availabilityTypeId;
	}

	/**
	 * Set the value related to the column: availability_type_id
	 * 
	 * @param availabilityTypeId
	 *            the availability_type_id value
	 */
	public void setAvailabilityTypeId(java.lang.Integer availabilityTypeId) {
		this.availabilityTypeId = availabilityTypeId;
	}

	/**
	 * Return the value associated with the column: charge
	 */
	public java.lang.Float getCharge() {
		return charge;
	}

	/**
	 * Set the value related to the column: charge
	 * 
	 * @param charge
	 *            the charge value
	 */
	public void setCharge(java.lang.Float charge) {
		this.charge = charge;
	}

	/**
	 * Return the value associated with the column: doc_call_id
	 */
	public java.lang.Integer getDocCallId() {
		return docCallId;
	}

	/**
	 * Set the value related to the column: doc_call_id
	 * 
	 * @param docCallId
	 *            the doc_call_id value
	 */
	public void setDocCallId(java.lang.Integer docCallId) {
		this.docCallId = docCallId;
	}

	/**
	 * Return the value associated with the column: status_id
	 */
	public java.lang.Integer getStatusId() {
		return statusId;
	}

	/**
	 * Set the value related to the column: status_id
	 * 
	 * @param statusId
	 *            the status_id value
	 */
	public void setStatusId(java.lang.Integer statusId) {
		this.statusId = statusId;
	}

	/**
	 * Return the value associated with the column: record
	 */
	public java.lang.Integer getRecord() {
		return record;
	}

	/**
	 * Set the value related to the column: record
	 * 
	 * @param record
	 *            the record value
	 */
	public void setRecord(java.lang.Integer record) {
		this.record = record;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.DoctorChargeConfig))
			return false;
		else {
			jkt.hms.masters.business.DoctorChargeConfig doctorChargeConfig = (jkt.hms.masters.business.DoctorChargeConfig) obj;
			if (null == this.getId() || null == doctorChargeConfig.getId())
				return false;
			else
				return (this.getId().equals(doctorChargeConfig.getId()));
		}
	}

	public int hashCode() {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId())
				return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":"
						+ this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}

	public String toString() {
		return super.toString();
	}

}
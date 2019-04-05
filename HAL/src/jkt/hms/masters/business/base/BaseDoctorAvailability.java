package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the doctor_availability
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="doctor_availability"
 */

public abstract class BaseDoctorAvailability implements Serializable {

	public static String REF = "DoctorAvailability";

	// constructors
	public BaseDoctorAvailability() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDoctorAvailability(java.lang.Integer dayId,
			java.lang.Integer docChargeConfigId) {

		this.setDayId(dayId);
		this.setDocChargeConfigId(docChargeConfigId);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key

	private java.lang.Integer dayId;

	private java.lang.Integer docChargeConfigId;

	/**
	 * @hibernate.property column=day_id not-null=true
	 */
	public java.lang.Integer getDayId() {
		return this.dayId;
	}

	/**
	 * Set the value related to the column: day_id
	 * 
	 * @param dayId
	 *            the day_id value
	 */
	public void setDayId(java.lang.Integer dayId) {
		this.dayId = dayId;
		this.hashCode = Integer.MIN_VALUE;
	}

	/**
	 * @hibernate.property column=doc_charge_config_id not-null=true
	 */
	public java.lang.Integer getDocChargeConfigId() {
		return this.docChargeConfigId;
	}

	/**
	 * Set the value related to the column: doc_charge_config_id
	 * 
	 * @param docChargeConfigId
	 *            the doc_charge_config_id value
	 */
	public void setDocChargeConfigId(java.lang.Integer docChargeConfigId) {
		this.docChargeConfigId = docChargeConfigId;
		this.hashCode = Integer.MIN_VALUE;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.DoctorAvailability))
			return false;
		else {
			jkt.hms.masters.business.DoctorAvailability doctorAvailability = (jkt.hms.masters.business.DoctorAvailability) obj;
			if (null != this.getDayId()
					&& null != doctorAvailability.getDayId()) {
				if (!this.getDayId().equals(doctorAvailability.getDayId())) {
					return false;
				}
			} else {
				return false;
			}
			if (null != this.getDocChargeConfigId()
					&& null != doctorAvailability.getDocChargeConfigId()) {
				if (!this.getDocChargeConfigId().equals(
						doctorAvailability.getDocChargeConfigId())) {
					return false;
				}
			} else {
				return false;
			}
			return true;
		}
	}

	public int hashCode() {
		if (Integer.MIN_VALUE == this.hashCode) {
			StringBuilder sb = new StringBuilder();
			if (null != this.getDayId()) {
				sb.append(this.getDayId().hashCode());
				sb.append(":");
			} else {
				return super.hashCode();
			}
			if (null != this.getDocChargeConfigId()) {
				sb.append(this.getDocChargeConfigId().hashCode());
				sb.append(":");
			} else {
				return super.hashCode();
			}
			this.hashCode = sb.toString().hashCode();
		}
		return this.hashCode;
	}

	public String toString() {
		return super.toString();
	}

}
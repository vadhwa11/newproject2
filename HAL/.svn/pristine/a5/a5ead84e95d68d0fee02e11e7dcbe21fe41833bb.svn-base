package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ipd_temperature table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ipd_temperature"
 */

public abstract class BaseIpdTemperature  implements Serializable {

	public static String REF = "IpdTemperature";
	public static String PROP_BOWEL = "Bowel";
	public static String PROP_RESPIRATION = "Respiration";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_TEMPERATURE = "Temperature";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_PAIN = "Pain";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_TIME = "Time";
	public static String PROP_BP = "Bp";
	public static String PROP_O2_SATURATION = "O2Saturation";
	public static String PROP_ID = "Id";
	public static String PROP_IPD_DATE = "IpdDate";
	public static String PROP_PULSE = "Pulse";
	public static String PROP_FHR = "Fhr";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_INTAKEOUTPUT = "Intakeoutput";


	// constructors
	public BaseIpdTemperature () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseIpdTemperature (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date ipdDate;
	private java.lang.String time;
	private java.lang.Float temperature;
	private java.lang.String bp;
	private java.lang.Integer pulse;
	private java.lang.Integer respiration;
	private java.lang.String bowel;
	private java.lang.String pain;
	private java.lang.String fhr;
	private java.lang.String o2Saturation;
	private java.lang.String remarks;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.IpdIntakeOutputChart intakeoutput;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="ipd_temperature_id"
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
	 * Return the value associated with the column: ipd_date
	 */
	public java.util.Date getIpdDate () {
		return ipdDate;
	}

	/**
	 * Set the value related to the column: ipd_date
	 * @param ipdDate the ipd_date value
	 */
	public void setIpdDate (java.util.Date ipdDate) {
		this.ipdDate = ipdDate;
	}



	/**
	 * Return the value associated with the column: time
	 */
	public java.lang.String getTime () {
		return time;
	}

	/**
	 * Set the value related to the column: time
	 * @param time the time value
	 */
	public void setTime (java.lang.String time) {
		this.time = time;
	}



	/**
	 * Return the value associated with the column: temperature
	 */
	public java.lang.Float getTemperature () {
		return temperature;
	}

	/**
	 * Set the value related to the column: temperature
	 * @param temperature the temperature value
	 */
	public void setTemperature (java.lang.Float temperature) {
		this.temperature = temperature;
	}



	/**
	 * Return the value associated with the column: bp
	 */
	public java.lang.String getBp () {
		return bp;
	}

	/**
	 * Set the value related to the column: bp
	 * @param bp the bp value
	 */
	public void setBp (java.lang.String bp) {
		this.bp = bp;
	}



	/**
	 * Return the value associated with the column: pulse
	 */
	public java.lang.Integer getPulse () {
		return pulse;
	}

	/**
	 * Set the value related to the column: pulse
	 * @param pulse the pulse value
	 */
	public void setPulse (java.lang.Integer pulse) {
		this.pulse = pulse;
	}



	/**
	 * Return the value associated with the column: respiration
	 */
	public java.lang.Integer getRespiration () {
		return respiration;
	}

	/**
	 * Set the value related to the column: respiration
	 * @param respiration the respiration value
	 */
	public void setRespiration (java.lang.Integer respiration) {
		this.respiration = respiration;
	}



	/**
	 * Return the value associated with the column: bowel
	 */
	public java.lang.String getBowel () {
		return bowel;
	}

	/**
	 * Set the value related to the column: bowel
	 * @param bowel the bowel value
	 */
	public void setBowel (java.lang.String bowel) {
		this.bowel = bowel;
	}



	/**
	 * Return the value associated with the column: pain
	 */
	public java.lang.String getPain () {
		return pain;
	}

	/**
	 * Set the value related to the column: pain
	 * @param pain the pain value
	 */
	public void setPain (java.lang.String pain) {
		this.pain = pain;
	}



	/**
	 * Return the value associated with the column: fhr
	 */
	public java.lang.String getFhr () {
		return fhr;
	}

	/**
	 * Set the value related to the column: fhr
	 * @param fhr the fhr value
	 */
	public void setFhr (java.lang.String fhr) {
		this.fhr = fhr;
	}



	/**
	 * Return the value associated with the column: o2_saturation
	 */
	public java.lang.String getO2Saturation () {
		return o2Saturation;
	}

	/**
	 * Set the value related to the column: o2_saturation
	 * @param o2Saturation the o2_saturation value
	 */
	public void setO2Saturation (java.lang.String o2Saturation) {
		this.o2Saturation = o2Saturation;
	}



	/**
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * @param remarks the remarks value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
	}



	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.String getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
	}



	/**
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate () {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * @param lastChgDate the last_chg_date value
	 */
	public void setLastChgDate (java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}



	/**
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime () {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * @param lastChgTime the last_chg_time value
	 */
	public void setLastChgTime (java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}



	/**
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment () {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * @param department the department_id value
	 */
	public void setDepartment (jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}



	/**
	 * Return the value associated with the column: intakeoutput_id
	 */
	public jkt.hms.masters.business.IpdIntakeOutputChart getIntakeoutput () {
		return intakeoutput;
	}

	/**
	 * Set the value related to the column: intakeoutput_id
	 * @param intakeoutput the intakeoutput_id value
	 */
	public void setIntakeoutput (jkt.hms.masters.business.IpdIntakeOutputChart intakeoutput) {
		this.intakeoutput = intakeoutput;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.IpdTemperature)) return false;
		else {
			jkt.hms.masters.business.IpdTemperature ipdTemperature = (jkt.hms.masters.business.IpdTemperature) obj;
			if (null == this.getId() || null == ipdTemperature.getId()) return false;
			else return (this.getId().equals(ipdTemperature.getId()));
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
package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the ipd_intake_output table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="ipd_intake_output"
 */
public abstract class BaseIpdIntakeOutput implements Serializable {

	public static String REF = "IpdIntakeOutput";
	public static String PROP_TIME = "Time";
	public static String PROP_DRAIN = "Drain";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_TEMPERATURE = "Temperature";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_VOM = "Vom";
	public static String PROP_INSULINE = "Insuline";
	public static String PROP_TREATMENT = "Treatment";
	public static String PROP_STOOL = "Stool";
	public static String PROP_ORAL = "Oral";
	public static String PROP_BP = "Bp";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_IV = "Iv";
	public static String PROP_ASP = "Asp";
	public static String PROP_AD_NO = "AdNo";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_RESPIRATION = "Respiration";
	public static String PROP_OUTPUT = "Output";
	public static String PROP_HIN = "Hin";
	public static String PROP_BLOOD_SUGAR = "BloodSugar";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_URINE = "Urine";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_INTAKE = "Intake";
	public static String PROP_PULSE = "Pulse";
	public static String PROP_GIRTH = "Girth";
	public static String PROP_ID = "Id";

	// constructors
	public BaseIpdIntakeOutput() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseIpdIntakeOutput(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String adNo;
	private java.lang.Integer temperature;
	private java.lang.Integer pulse;
	private java.lang.Integer respiration;
	private java.lang.Integer bp;
	private java.lang.String remarks;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String time;
	private java.lang.String intake;
	private java.lang.String oral;
	private java.lang.String iv;
	private java.lang.String output;
	private java.lang.String urine;
	private java.lang.String stool;
	private java.lang.String vom;
	private java.lang.String asp;
	private java.lang.String drain;
	private java.lang.String girth;
	private java.lang.String insuline;
	private java.lang.String bloodSugar;
	private java.lang.String treatment;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.Patient hin;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="intake_output_id"
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
	 * Return the value associated with the column: ad_no
	 */
	public java.lang.String getAdNo() {
		return adNo;
	}

	/**
	 * Set the value related to the column: ad_no
	 * 
	 * @param adNo
	 *            the ad_no value
	 */
	public void setAdNo(java.lang.String adNo) {
		this.adNo = adNo;
	}

	/**
	 * Return the value associated with the column: temperature
	 */
	public java.lang.Integer getTemperature() {
		return temperature;
	}

	/**
	 * Set the value related to the column: temperature
	 * 
	 * @param temperature
	 *            the temperature value
	 */
	public void setTemperature(java.lang.Integer temperature) {
		this.temperature = temperature;
	}

	/**
	 * Return the value associated with the column: pulse
	 */
	public java.lang.Integer getPulse() {
		return pulse;
	}

	/**
	 * Set the value related to the column: pulse
	 * 
	 * @param pulse
	 *            the pulse value
	 */
	public void setPulse(java.lang.Integer pulse) {
		this.pulse = pulse;
	}

	/**
	 * Return the value associated with the column: respiration
	 */
	public java.lang.Integer getRespiration() {
		return respiration;
	}

	/**
	 * Set the value related to the column: respiration
	 * 
	 * @param respiration
	 *            the respiration value
	 */
	public void setRespiration(java.lang.Integer respiration) {
		this.respiration = respiration;
	}

	/**
	 * Return the value associated with the column: bp
	 */
	public java.lang.Integer getBp() {
		return bp;
	}

	/**
	 * Set the value related to the column: bp
	 * 
	 * @param bp
	 *            the bp value
	 */
	public void setBp(java.lang.Integer bp) {
		this.bp = bp;
	}

	/**
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks() {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * 
	 * @param remarks
	 *            the remarks value
	 */
	public void setRemarks(java.lang.String remarks) {
		this.remarks = remarks;
	}

	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.String getLastChgBy() {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * 
	 * @param lastChgBy
	 *            the last_chg_by value
	 */
	public void setLastChgBy(java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
	}

	/**
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate() {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * 
	 * @param lastChgDate
	 *            the last_chg_date value
	 */
	public void setLastChgDate(java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}

	/**
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime() {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * 
	 * @param lastChgTime
	 *            the last_chg_time value
	 */
	public void setLastChgTime(java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}

	/**
	 * Return the value associated with the column: time
	 */
	public java.lang.String getTime() {
		return time;
	}

	/**
	 * Set the value related to the column: time
	 * 
	 * @param time
	 *            the time value
	 */
	public void setTime(java.lang.String time) {
		this.time = time;
	}

	/**
	 * Return the value associated with the column: intake
	 */
	public java.lang.String getIntake() {
		return intake;
	}

	/**
	 * Set the value related to the column: intake
	 * 
	 * @param intake
	 *            the intake value
	 */
	public void setIntake(java.lang.String intake) {
		this.intake = intake;
	}

	/**
	 * Return the value associated with the column: oral
	 */
	public java.lang.String getOral() {
		return oral;
	}

	/**
	 * Set the value related to the column: oral
	 * 
	 * @param oral
	 *            the oral value
	 */
	public void setOral(java.lang.String oral) {
		this.oral = oral;
	}

	/**
	 * Return the value associated with the column: iv
	 */
	public java.lang.String getIv() {
		return iv;
	}

	/**
	 * Set the value related to the column: iv
	 * 
	 * @param iv
	 *            the iv value
	 */
	public void setIv(java.lang.String iv) {
		this.iv = iv;
	}

	/**
	 * Return the value associated with the column: output
	 */
	public java.lang.String getOutput() {
		return output;
	}

	/**
	 * Set the value related to the column: output
	 * 
	 * @param output
	 *            the output value
	 */
	public void setOutput(java.lang.String output) {
		this.output = output;
	}

	/**
	 * Return the value associated with the column: urine
	 */
	public java.lang.String getUrine() {
		return urine;
	}

	/**
	 * Set the value related to the column: urine
	 * 
	 * @param urine
	 *            the urine value
	 */
	public void setUrine(java.lang.String urine) {
		this.urine = urine;
	}

	/**
	 * Return the value associated with the column: stool
	 */
	public java.lang.String getStool() {
		return stool;
	}

	/**
	 * Set the value related to the column: stool
	 * 
	 * @param stool
	 *            the stool value
	 */
	public void setStool(java.lang.String stool) {
		this.stool = stool;
	}

	/**
	 * Return the value associated with the column: vom
	 */
	public java.lang.String getVom() {
		return vom;
	}

	/**
	 * Set the value related to the column: vom
	 * 
	 * @param vom
	 *            the vom value
	 */
	public void setVom(java.lang.String vom) {
		this.vom = vom;
	}

	/**
	 * Return the value associated with the column: asp
	 */
	public java.lang.String getAsp() {
		return asp;
	}

	/**
	 * Set the value related to the column: asp
	 * 
	 * @param asp
	 *            the asp value
	 */
	public void setAsp(java.lang.String asp) {
		this.asp = asp;
	}

	/**
	 * Return the value associated with the column: drain
	 */
	public java.lang.String getDrain() {
		return drain;
	}

	/**
	 * Set the value related to the column: drain
	 * 
	 * @param drain
	 *            the drain value
	 */
	public void setDrain(java.lang.String drain) {
		this.drain = drain;
	}

	/**
	 * Return the value associated with the column: girth
	 */
	public java.lang.String getGirth() {
		return girth;
	}

	/**
	 * Set the value related to the column: girth
	 * 
	 * @param girth
	 *            the girth value
	 */
	public void setGirth(java.lang.String girth) {
		this.girth = girth;
	}

	/**
	 * Return the value associated with the column: insuline
	 */
	public java.lang.String getInsuline() {
		return insuline;
	}

	/**
	 * Set the value related to the column: insuline
	 * 
	 * @param insuline
	 *            the insuline value
	 */
	public void setInsuline(java.lang.String insuline) {
		this.insuline = insuline;
	}

	/**
	 * Return the value associated with the column: blood_sugar
	 */
	public java.lang.String getBloodSugar() {
		return bloodSugar;
	}

	/**
	 * Set the value related to the column: blood_sugar
	 * 
	 * @param bloodSugar
	 *            the blood_sugar value
	 */
	public void setBloodSugar(java.lang.String bloodSugar) {
		this.bloodSugar = bloodSugar;
	}

	/**
	 * Return the value associated with the column: treatment
	 */
	public java.lang.String getTreatment() {
		return treatment;
	}

	/**
	 * Set the value related to the column: treatment
	 * 
	 * @param treatment
	 *            the treatment value
	 */
	public void setTreatment(java.lang.String treatment) {
		this.treatment = treatment;
	}

	/**
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital() {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * 
	 * @param hospital
	 *            the hospital_id value
	 */
	public void setHospital(jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}

	/**
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment() {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * 
	 * @param department
	 *            the department_id value
	 */
	public void setDepartment(jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}

	/**
	 * Return the value associated with the column: hin_id
	 */
	public jkt.hms.masters.business.Patient getHin() {
		return hin;
	}

	/**
	 * Set the value related to the column: hin_id
	 * 
	 * @param hin
	 *            the hin_id value
	 */
	public void setHin(jkt.hms.masters.business.Patient hin) {
		this.hin = hin;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.IpdIntakeOutput))
			return false;
		else {
			jkt.hms.masters.business.IpdIntakeOutput ipdIntakeOutput = (jkt.hms.masters.business.IpdIntakeOutput) obj;
			if (null == this.getId() || null == ipdIntakeOutput.getId())
				return false;
			else
				return (this.getId().equals(ipdIntakeOutput.getId()));
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
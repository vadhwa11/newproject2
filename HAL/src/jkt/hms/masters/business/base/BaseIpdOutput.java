package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ipd_output table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ipd_output"
 */

public abstract class BaseIpdOutput  implements Serializable {

	public static String REF = "IpdOutput";
	public static String PROP_STOOL = "Stool";
	public static String PROP_INSULIN_TIME = "InsulinTime";
	public static String PROP_GIRTH_TIME = "GirthTime";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_OUTPUT = "Output";
	public static String PROP_VOM = "Vom";
	public static String PROP_INSULIN = "Insulin";
	public static String PROP_ASP = "Asp";
	public static String PROP_BLOOD_SUGAR = "BloodSugar";
	public static String PROP_DRAIN_TIME = "DrainTime";
	public static String PROP_GIRTH = "Girth";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_TIME = "Time";
	public static String PROP_URINE = "Urine";
	public static String PROP_DRAIN_REMARKS = "DrainRemarks";
	public static String PROP_IPD_OUTPUT_DATE = "IpdOutputDate";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_INTAKEOUTPUT = "Intakeoutput";
	public static String PROP_BLOOD_SUGAR_TIME = "BloodSugarTime";
	public static String PROP_DRAIN = "Drain";


	// constructors
	public BaseIpdOutput () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseIpdOutput (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date ipdOutputDate;
	private java.lang.String time;
	private java.lang.String output;
	private java.lang.String urine;
	private java.lang.String stool;
	private java.lang.String vom;
	private java.lang.String asp;
	private java.lang.String drainTime;
	private java.lang.String drain;
	private java.lang.String girthTime;
	private java.lang.String girth;
	private java.lang.String insulinTime;
	private java.lang.String insulin;
	private java.lang.String bloodSugarTime;
	private java.lang.String bloodSugar;
	private java.lang.String remarks;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String drainRemarks;

	// many to one
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.IpdIntakeOutputChart intakeoutput;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="ipd_output_id"
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
	 * Return the value associated with the column: ipd_output_date
	 */
	public java.util.Date getIpdOutputDate () {
		return ipdOutputDate;
	}

	/**
	 * Set the value related to the column: ipd_output_date
	 * @param ipdOutputDate the ipd_output_date value
	 */
	public void setIpdOutputDate (java.util.Date ipdOutputDate) {
		this.ipdOutputDate = ipdOutputDate;
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
	 * Return the value associated with the column: output
	 */
	public java.lang.String getOutput () {
		return output;
	}

	/**
	 * Set the value related to the column: output
	 * @param output the output value
	 */
	public void setOutput (java.lang.String output) {
		this.output = output;
	}



	/**
	 * Return the value associated with the column: urine
	 */
	public java.lang.String getUrine () {
		return urine;
	}

	/**
	 * Set the value related to the column: urine
	 * @param urine the urine value
	 */
	public void setUrine (java.lang.String urine) {
		this.urine = urine;
	}



	/**
	 * Return the value associated with the column: stool
	 */
	public java.lang.String getStool () {
		return stool;
	}

	/**
	 * Set the value related to the column: stool
	 * @param stool the stool value
	 */
	public void setStool (java.lang.String stool) {
		this.stool = stool;
	}



	/**
	 * Return the value associated with the column: vom
	 */
	public java.lang.String getVom () {
		return vom;
	}

	/**
	 * Set the value related to the column: vom
	 * @param vom the vom value
	 */
	public void setVom (java.lang.String vom) {
		this.vom = vom;
	}



	/**
	 * Return the value associated with the column: asp
	 */
	public java.lang.String getAsp () {
		return asp;
	}

	/**
	 * Set the value related to the column: asp
	 * @param asp the asp value
	 */
	public void setAsp (java.lang.String asp) {
		this.asp = asp;
	}



	/**
	 * Return the value associated with the column: drain_time
	 */
	public java.lang.String getDrainTime () {
		return drainTime;
	}

	/**
	 * Set the value related to the column: drain_time
	 * @param drainTime the drain_time value
	 */
	public void setDrainTime (java.lang.String drainTime) {
		this.drainTime = drainTime;
	}



	/**
	 * Return the value associated with the column: drain
	 */
	public java.lang.String getDrain () {
		return drain;
	}

	/**
	 * Set the value related to the column: drain
	 * @param drain the drain value
	 */
	public void setDrain (java.lang.String drain) {
		this.drain = drain;
	}



	/**
	 * Return the value associated with the column: girth_time
	 */
	public java.lang.String getGirthTime () {
		return girthTime;
	}

	/**
	 * Set the value related to the column: girth_time
	 * @param girthTime the girth_time value
	 */
	public void setGirthTime (java.lang.String girthTime) {
		this.girthTime = girthTime;
	}



	/**
	 * Return the value associated with the column: girth
	 */
	public java.lang.String getGirth () {
		return girth;
	}

	/**
	 * Set the value related to the column: girth
	 * @param girth the girth value
	 */
	public void setGirth (java.lang.String girth) {
		this.girth = girth;
	}



	/**
	 * Return the value associated with the column: insulin_time
	 */
	public java.lang.String getInsulinTime () {
		return insulinTime;
	}

	/**
	 * Set the value related to the column: insulin_time
	 * @param insulinTime the insulin_time value
	 */
	public void setInsulinTime (java.lang.String insulinTime) {
		this.insulinTime = insulinTime;
	}



	/**
	 * Return the value associated with the column: insulin
	 */
	public java.lang.String getInsulin () {
		return insulin;
	}

	/**
	 * Set the value related to the column: insulin
	 * @param insulin the insulin value
	 */
	public void setInsulin (java.lang.String insulin) {
		this.insulin = insulin;
	}



	/**
	 * Return the value associated with the column: blood_sugar_time
	 */
	public java.lang.String getBloodSugarTime () {
		return bloodSugarTime;
	}

	/**
	 * Set the value related to the column: blood_sugar_time
	 * @param bloodSugarTime the blood_sugar_time value
	 */
	public void setBloodSugarTime (java.lang.String bloodSugarTime) {
		this.bloodSugarTime = bloodSugarTime;
	}



	/**
	 * Return the value associated with the column: blood_sugar
	 */
	public java.lang.String getBloodSugar () {
		return bloodSugar;
	}

	/**
	 * Set the value related to the column: blood_sugar
	 * @param bloodSugar the blood_sugar value
	 */
	public void setBloodSugar (java.lang.String bloodSugar) {
		this.bloodSugar = bloodSugar;
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
	 * Return the value associated with the column: drain_remarks
	 */
	public java.lang.String getDrainRemarks () {
		return drainRemarks;
	}

	/**
	 * Set the value related to the column: drain_remarks
	 * @param drainRemarks the drain_remarks value
	 */
	public void setDrainRemarks (java.lang.String drainRemarks) {
		this.drainRemarks = drainRemarks;
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
		if (!(obj instanceof jkt.hms.masters.business.IpdOutput)) return false;
		else {
			jkt.hms.masters.business.IpdOutput ipdOutput = (jkt.hms.masters.business.IpdOutput) obj;
			if (null == this.getId() || null == ipdOutput.getId()) return false;
			else return (this.getId().equals(ipdOutput.getId()));
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
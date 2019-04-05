package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ipd_intake_output_chart table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ipd_intake_output_chart"
 */

public abstract class BaseIpdIntakeOutputChart  implements Serializable {

	public static String REF = "IpdIntakeOutputChart";
	public static String PROP_TIME = "Time";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_AD_NO = "AdNo";
	public static String PROP_INTAKE_DATE = "IntakeDate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_HIN = "Hin";
	public static String PROP_TREATMENT = "Treatment";


	// constructors
	public BaseIpdIntakeOutputChart () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseIpdIntakeOutputChart (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String adNo;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String treatment;
	private java.util.Date intakeDate;
	private java.lang.String time;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.Inpatient inpatient;

	// collections
	private java.util.Set<jkt.hms.masters.business.IpdIntake> ipdIntakes;
	private java.util.Set<jkt.hms.masters.business.IpdTemperature> ipdTemperatures;
	private java.util.Set<jkt.hms.masters.business.IpdOutput> ipdOutputs;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="intakeoutput_id"
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
	 * Return the value associated with the column: ad_no
	 */
	public java.lang.String getAdNo () {
		return adNo;
	}

	/**
	 * Set the value related to the column: ad_no
	 * @param adNo the ad_no value
	 */
	public void setAdNo (java.lang.String adNo) {
		this.adNo = adNo;
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
	 * Return the value associated with the column: treatment
	 */
	public java.lang.String getTreatment () {
		return treatment;
	}

	/**
	 * Set the value related to the column: treatment
	 * @param treatment the treatment value
	 */
	public void setTreatment (java.lang.String treatment) {
		this.treatment = treatment;
	}



	/**
	 * Return the value associated with the column: intake_date
	 */
	public java.util.Date getIntakeDate () {
		return intakeDate;
	}

	/**
	 * Set the value related to the column: intake_date
	 * @param intakeDate the intake_date value
	 */
	public void setIntakeDate (java.util.Date intakeDate) {
		this.intakeDate = intakeDate;
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
	 * Return the value associated with the column: inpatient_id
	 */
	public jkt.hms.masters.business.Inpatient getInpatient () {
		return inpatient;
	}

	/**
	 * Set the value related to the column: inpatient_id
	 * @param inpatient the inpatient_id value
	 */
	public void setInpatient (jkt.hms.masters.business.Inpatient inpatient) {
		this.inpatient = inpatient;
	}



	/**
	 * Return the value associated with the column: IpdIntakes
	 */
	public java.util.Set<jkt.hms.masters.business.IpdIntake> getIpdIntakes () {
		return ipdIntakes;
	}

	/**
	 * Set the value related to the column: IpdIntakes
	 * @param ipdIntakes the IpdIntakes value
	 */
	public void setIpdIntakes (java.util.Set<jkt.hms.masters.business.IpdIntake> ipdIntakes) {
		this.ipdIntakes = ipdIntakes;
	}

	public void addToIpdIntakes (jkt.hms.masters.business.IpdIntake ipdIntake) {
		if (null == getIpdIntakes()) setIpdIntakes(new java.util.TreeSet<jkt.hms.masters.business.IpdIntake>());
		getIpdIntakes().add(ipdIntake);
	}



	/**
	 * Return the value associated with the column: IpdTemperatures
	 */
	public java.util.Set<jkt.hms.masters.business.IpdTemperature> getIpdTemperatures () {
		return ipdTemperatures;
	}

	/**
	 * Set the value related to the column: IpdTemperatures
	 * @param ipdTemperatures the IpdTemperatures value
	 */
	public void setIpdTemperatures (java.util.Set<jkt.hms.masters.business.IpdTemperature> ipdTemperatures) {
		this.ipdTemperatures = ipdTemperatures;
	}

	public void addToIpdTemperatures (jkt.hms.masters.business.IpdTemperature ipdTemperature) {
		if (null == getIpdTemperatures()) setIpdTemperatures(new java.util.TreeSet<jkt.hms.masters.business.IpdTemperature>());
		getIpdTemperatures().add(ipdTemperature);
	}



	/**
	 * Return the value associated with the column: IpdOutputs
	 */
	public java.util.Set<jkt.hms.masters.business.IpdOutput> getIpdOutputs () {
		return ipdOutputs;
	}

	/**
	 * Set the value related to the column: IpdOutputs
	 * @param ipdOutputs the IpdOutputs value
	 */
	public void setIpdOutputs (java.util.Set<jkt.hms.masters.business.IpdOutput> ipdOutputs) {
		this.ipdOutputs = ipdOutputs;
	}

	public void addToIpdOutputs (jkt.hms.masters.business.IpdOutput ipdOutput) {
		if (null == getIpdOutputs()) setIpdOutputs(new java.util.TreeSet<jkt.hms.masters.business.IpdOutput>());
		getIpdOutputs().add(ipdOutput);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.IpdIntakeOutputChart)) return false;
		else {
			jkt.hms.masters.business.IpdIntakeOutputChart ipdIntakeOutputChart = (jkt.hms.masters.business.IpdIntakeOutputChart) obj;
			if (null == this.getId() || null == ipdIntakeOutputChart.getId()) return false;
			else return (this.getId().equals(ipdIntakeOutputChart.getId()));
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
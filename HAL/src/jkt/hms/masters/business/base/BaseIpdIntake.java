package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ipd_intake table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ipd_intake"
 */

public abstract class BaseIpdIntake  implements Serializable {

	public static String REF = "IpdIntake";
	public static String PROP_ORAL = "Oral";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_IV = "Iv";
	public static String PROP_INTAKE = "Intake";
	public static String PROP_INTAKE_TYPE = "IntakeType";
	public static String PROP_TIME = "Time";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_INTAKE_TOTAL = "IntakeTotal";
	public static String PROP_ID = "Id";
	public static String PROP_IV_COUNT = "IvCount";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_INTAKEOUTPUT = "Intakeoutput";
	public static String PROP_IPD_INTAKE_DATE = "IpdIntakeDate";


	// constructors
	public BaseIpdIntake () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseIpdIntake (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date ipdIntakeDate;
	private java.lang.String time;
	private java.lang.String intake;
	private java.lang.String oral;
	private java.lang.String iv;
	private java.lang.String remarks;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String ivCount;
	private java.math.BigDecimal intakeTotal;
	private java.lang.String intakeType;

	// many to one
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.IpdIntakeOutputChart intakeoutput;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="ipd_intake_id"
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
	 * Return the value associated with the column: ip_intake_date
	 */
	public java.util.Date getIpdIntakeDate () {
		return ipdIntakeDate;
	}

	/**
	 * Set the value related to the column: ip_intake_date
	 * @param ipdIntakeDate the ip_intake_date value
	 */
	public void setIpdIntakeDate (java.util.Date ipdIntakeDate) {
		this.ipdIntakeDate = ipdIntakeDate;
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
	 * Return the value associated with the column: intake
	 */
	public java.lang.String getIntake () {
		return intake;
	}

	/**
	 * Set the value related to the column: intake
	 * @param intake the intake value
	 */
	public void setIntake (java.lang.String intake) {
		this.intake = intake;
	}



	/**
	 * Return the value associated with the column: oral
	 */
	public java.lang.String getOral () {
		return oral;
	}

	/**
	 * Set the value related to the column: oral
	 * @param oral the oral value
	 */
	public void setOral (java.lang.String oral) {
		this.oral = oral;
	}



	/**
	 * Return the value associated with the column: iv
	 */
	public java.lang.String getIv () {
		return iv;
	}

	/**
	 * Set the value related to the column: iv
	 * @param iv the iv value
	 */
	public void setIv (java.lang.String iv) {
		this.iv = iv;
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
	 * Return the value associated with the column: iv_count
	 */
	public java.lang.String getIvCount () {
		return ivCount;
	}

	/**
	 * Set the value related to the column: iv_count
	 * @param ivCount the iv_count value
	 */
	public void setIvCount (java.lang.String ivCount) {
		this.ivCount = ivCount;
	}



	/**
	 * Return the value associated with the column: intake_total
	 */
	public java.math.BigDecimal getIntakeTotal () {
		return intakeTotal;
	}

	/**
	 * Set the value related to the column: intake_total
	 * @param intakeTotal the intake_total value
	 */
	public void setIntakeTotal (java.math.BigDecimal intakeTotal) {
		this.intakeTotal = intakeTotal;
	}



	/**
	 * Return the value associated with the column: intake_type
	 */
	public java.lang.String getIntakeType () {
		return intakeType;
	}

	/**
	 * Set the value related to the column: intake_type
	 * @param intakeType the intake_type value
	 */
	public void setIntakeType (java.lang.String intakeType) {
		this.intakeType = intakeType;
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
		if (!(obj instanceof jkt.hms.masters.business.IpdIntake)) return false;
		else {
			jkt.hms.masters.business.IpdIntake ipdIntake = (jkt.hms.masters.business.IpdIntake) obj;
			if (null == this.getId() || null == ipdIntake.getId()) return false;
			else return (this.getId().equals(ipdIntake.getId()));
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
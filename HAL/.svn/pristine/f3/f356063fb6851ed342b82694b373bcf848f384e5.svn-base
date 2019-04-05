package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_specialist_master table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_specialist_master"
 */

public abstract class BaseHrSpecialistMaster  implements Serializable {

	public static String REF = "HrSpecialistMaster";
	public static String PROP_STATUS = "Status";
	public static String PROP_TRADE_ID = "TradeId";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_SPECIALIST_NAME = "SpecialistName";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_ID = "Id";
	public static String PROP_SPECIALIST_CODE = "SpecialistCode";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseHrSpecialistMaster () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrSpecialistMaster (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String specialistCode;
	private java.lang.String specialistName;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.Integer hospitalId;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasTrade tradeId;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
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
	 * Return the value associated with the column: specialist_code
	 */
	public java.lang.String getSpecialistCode () {
		return specialistCode;
	}

	/**
	 * Set the value related to the column: specialist_code
	 * @param specialistCode the specialist_code value
	 */
	public void setSpecialistCode (java.lang.String specialistCode) {
		this.specialistCode = specialistCode;
	}



	/**
	 * Return the value associated with the column: specialist_name
	 */
	public java.lang.String getSpecialistName () {
		return specialistName;
	}

	/**
	 * Set the value related to the column: specialist_name
	 * @param specialistName the specialist_name value
	 */
	public void setSpecialistName (java.lang.String specialistName) {
		this.specialistName = specialistName;
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
	 * Return the value associated with the column: hospital_id
	 */
	public java.lang.Integer getHospitalId () {
		return hospitalId;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * @param hospitalId the hospital_id value
	 */
	public void setHospitalId (java.lang.Integer hospitalId) {
		this.hospitalId = hospitalId;
	}



	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * @param status the status value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
	}



	/**
	 * Return the value associated with the column: trade_id
	 */
	public jkt.hms.masters.business.MasTrade getTradeId () {
		return tradeId;
	}

	/**
	 * Set the value related to the column: trade_id
	 * @param tradeId the trade_id value
	 */
	public void setTradeId (jkt.hms.masters.business.MasTrade tradeId) {
		this.tradeId = tradeId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HrSpecialistMaster)) return false;
		else {
			jkt.hms.masters.business.HrSpecialistMaster hrSpecialistMaster = (jkt.hms.masters.business.HrSpecialistMaster) obj;
			if (null == this.getId() || null == hrSpecialistMaster.getId()) return false;
			else return (this.getId().equals(hrSpecialistMaster.getId()));
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
package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the MONTHLY_DISCHARGE_HD table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="MONTHLY_DISCHARGE_HD"
 */

public abstract class BaseMonthlyDischargeHd  implements Serializable {

	public static String REF = "MonthlyDischargeHd";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_MONTHLY_DIS_REPORT_DATE = "MonthlyDisReportDate";


	// constructors
	public BaseMonthlyDischargeHd () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMonthlyDischargeHd (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date monthlyDisReportDate;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Users lastChgBy;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="MONTHLY_DIS_HD_ID"
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
	 * Return the value associated with the column: MONTHLY_DIS_REPORT_DATE
	 */
	public java.util.Date getMonthlyDisReportDate () {
		return monthlyDisReportDate;
	}

	/**
	 * Set the value related to the column: MONTHLY_DIS_REPORT_DATE
	 * @param monthlyDisReportDate the MONTHLY_DIS_REPORT_DATE value
	 */
	public void setMonthlyDisReportDate (java.util.Date monthlyDisReportDate) {
		this.monthlyDisReportDate = monthlyDisReportDate;
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
	 * Return the value associated with the column: HOSPITAL_ID
	 */
	public jkt.hms.masters.business.MasHospital getHospital () {
		return hospital;
	}

	/**
	 * Set the value related to the column: HOSPITAL_ID
	 * @param hospital the HOSPITAL_ID value
	 */
	public void setHospital (jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}



	/**
	 * Return the value associated with the column: LAST_CHG_BY
	 */
	public jkt.hms.masters.business.Users getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: LAST_CHG_BY
	 * @param lastChgBy the LAST_CHG_BY value
	 */
	public void setLastChgBy (jkt.hms.masters.business.Users lastChgBy) {
		this.lastChgBy = lastChgBy;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MonthlyDischargeHd)) return false;
		else {
			jkt.hms.masters.business.MonthlyDischargeHd monthlyDischargeHd = (jkt.hms.masters.business.MonthlyDischargeHd) obj;
			if (null == this.getId() || null == monthlyDischargeHd.getId()) return false;
			else return (this.getId().equals(monthlyDischargeHd.getId()));
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
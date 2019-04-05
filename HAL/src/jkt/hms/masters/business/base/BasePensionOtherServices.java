package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the pension_other_services
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="pension_other_services"
 */

public abstract class BasePensionOtherServices implements Serializable {

	public static String REF = "PensionOtherServices";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_TOTAL_YEARS = "TotalYears";
	public static String PROP_TOTAL_DAYS = "TotalDays";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_TO_DATE = "ToDate";
	public static String PROP_TOTAL_MONTHS = "TotalMonths";
	public static String PROP_ID = "Id";
	public static String PROP_PERSONNEL = "Personnel";
	public static String PROP_FROM_DATE = "FromDate";

	// constructors
	public BasePensionOtherServices() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePensionOtherServices(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date fromDate;
	private java.util.Date toDate;
	private java.lang.Integer totalYears;
	private java.lang.Integer totalMonths;
	private java.lang.Integer totalDays;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasPersonnelDetails personnel;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="id"
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
	 * Return the value associated with the column: from_date
	 */
	public java.util.Date getFromDate() {
		return fromDate;
	}

	/**
	 * Set the value related to the column: from_date
	 * 
	 * @param fromDate
	 *            the from_date value
	 */
	public void setFromDate(java.util.Date fromDate) {
		this.fromDate = fromDate;
	}

	/**
	 * Return the value associated with the column: to_date
	 */
	public java.util.Date getToDate() {
		return toDate;
	}

	/**
	 * Set the value related to the column: to_date
	 * 
	 * @param toDate
	 *            the to_date value
	 */
	public void setToDate(java.util.Date toDate) {
		this.toDate = toDate;
	}

	/**
	 * Return the value associated with the column: total_years
	 */
	public java.lang.Integer getTotalYears() {
		return totalYears;
	}

	/**
	 * Set the value related to the column: total_years
	 * 
	 * @param totalYears
	 *            the total_years value
	 */
	public void setTotalYears(java.lang.Integer totalYears) {
		this.totalYears = totalYears;
	}

	/**
	 * Return the value associated with the column: total_months
	 */
	public java.lang.Integer getTotalMonths() {
		return totalMonths;
	}

	/**
	 * Set the value related to the column: total_months
	 * 
	 * @param totalMonths
	 *            the total_months value
	 */
	public void setTotalMonths(java.lang.Integer totalMonths) {
		this.totalMonths = totalMonths;
	}

	/**
	 * Return the value associated with the column: total_days
	 */
	public java.lang.Integer getTotalDays() {
		return totalDays;
	}

	/**
	 * Set the value related to the column: total_days
	 * 
	 * @param totalDays
	 *            the total_days value
	 */
	public void setTotalDays(java.lang.Integer totalDays) {
		this.totalDays = totalDays;
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
	 * Return the value associated with the column: personnel_id
	 */
	public jkt.hms.masters.business.MasPersonnelDetails getPersonnel() {
		return personnel;
	}

	/**
	 * Set the value related to the column: personnel_id
	 * 
	 * @param personnel
	 *            the personnel_id value
	 */
	public void setPersonnel(
			jkt.hms.masters.business.MasPersonnelDetails personnel) {
		this.personnel = personnel;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.PensionOtherServices))
			return false;
		else {
			jkt.hms.masters.business.PensionOtherServices pensionOtherServices = (jkt.hms.masters.business.PensionOtherServices) obj;
			if (null == this.getId() || null == pensionOtherServices.getId())
				return false;
			else
				return (this.getId().equals(pensionOtherServices.getId()));
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
package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the pension_calculation_sheet
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="pension_calculation_sheet"
 */

public abstract class BasePensionCalculationSheet implements Serializable {

	public static String REF = "PensionCalculationSheet";
	public static String PROP_NET_QUALIFYING_SERVICE_MONTHS = "NetQualifyingServiceMonths";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_PENSION_RULES = "PensionRules";
	public static String PROP_PENSION_CLASS = "PensionClass";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_NET_QUALIFYING_SERVICE_YEARS = "NetQualifyingServiceYears";
	public static String PROP_NET_QUALIFYING_SERVICE_DAYS = "NetQualifyingServiceDays";
	public static String PROP_ID = "Id";
	public static String PROP_PERSONNEL = "Personnel";

	// constructors
	public BasePensionCalculationSheet() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePensionCalculationSheet(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer netQualifyingServiceYears;
	private java.lang.Integer netQualifyingServiceMonths;
	private java.lang.Integer netQualifyingServiceDays;
	private java.lang.String pensionClass;
	private java.lang.String pensionRules;
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
	 * Return the value associated with the column: net_qualifying_service_years
	 */
	public java.lang.Integer getNetQualifyingServiceYears() {
		return netQualifyingServiceYears;
	}

	/**
	 * Set the value related to the column: net_qualifying_service_years
	 * 
	 * @param netQualifyingServiceYears
	 *            the net_qualifying_service_years value
	 */
	public void setNetQualifyingServiceYears(
			java.lang.Integer netQualifyingServiceYears) {
		this.netQualifyingServiceYears = netQualifyingServiceYears;
	}

	/**
	 * Return the value associated with the column:
	 * net_qualifying_service_months
	 */
	public java.lang.Integer getNetQualifyingServiceMonths() {
		return netQualifyingServiceMonths;
	}

	/**
	 * Set the value related to the column: net_qualifying_service_months
	 * 
	 * @param netQualifyingServiceMonths
	 *            the net_qualifying_service_months value
	 */
	public void setNetQualifyingServiceMonths(
			java.lang.Integer netQualifyingServiceMonths) {
		this.netQualifyingServiceMonths = netQualifyingServiceMonths;
	}

	/**
	 * Return the value associated with the column: net_qualifying_service_days
	 */
	public java.lang.Integer getNetQualifyingServiceDays() {
		return netQualifyingServiceDays;
	}

	/**
	 * Set the value related to the column: net_qualifying_service_days
	 * 
	 * @param netQualifyingServiceDays
	 *            the net_qualifying_service_days value
	 */
	public void setNetQualifyingServiceDays(
			java.lang.Integer netQualifyingServiceDays) {
		this.netQualifyingServiceDays = netQualifyingServiceDays;
	}

	/**
	 * Return the value associated with the column: pension_class
	 */
	public java.lang.String getPensionClass() {
		return pensionClass;
	}

	/**
	 * Set the value related to the column: pension_class
	 * 
	 * @param pensionClass
	 *            the pension_class value
	 */
	public void setPensionClass(java.lang.String pensionClass) {
		this.pensionClass = pensionClass;
	}

	/**
	 * Return the value associated with the column: pension_rules
	 */
	public java.lang.String getPensionRules() {
		return pensionRules;
	}

	/**
	 * Set the value related to the column: pension_rules
	 * 
	 * @param pensionRules
	 *            the pension_rules value
	 */
	public void setPensionRules(java.lang.String pensionRules) {
		this.pensionRules = pensionRules;
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
		if (!(obj instanceof jkt.hms.masters.business.PensionCalculationSheet))
			return false;
		else {
			jkt.hms.masters.business.PensionCalculationSheet pensionCalculationSheet = (jkt.hms.masters.business.PensionCalculationSheet) obj;
			if (null == this.getId() || null == pensionCalculationSheet.getId())
				return false;
			else
				return (this.getId().equals(pensionCalculationSheet.getId()));
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
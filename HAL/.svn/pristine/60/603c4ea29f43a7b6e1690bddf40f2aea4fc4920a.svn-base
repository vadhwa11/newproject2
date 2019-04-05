package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_mas_leave_type_backup table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_mas_leave_type_backup"
 */

public abstract class BaseHrMasLeaveTypeBackup  implements Serializable {

	public static String REF = "HrMasLeaveTypeBackup";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_VALID_TO_DATE = "ValidToDate";
	public static String PROP_COMPANY = "Company";
	public static String PROP_ENCH_FORMULA = "EnchFormula";
	public static String PROP_LEAVE_TYPE = "LeaveType";
	public static String PROP_ALLOWED_DAYS = "AllowedDays";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ENCASHABLE_PERCENT = "EncashablePercent";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_VALID_FROM_DATE = "ValidFromDate";
	public static String PROP_CR_FRDABLE = "CrFrdable";
	public static String PROP_MONTH_OR_YEAR = "MonthOrYear";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ENCASHABLE = "Encashable";


	// constructors
	public BaseHrMasLeaveTypeBackup () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrMasLeaveTypeBackup (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;
	private java.lang.String encashable;
	private java.lang.String allowedDays;
	private java.util.Date validFromDate;
	private java.util.Date validToDate;
	private java.lang.String remarks;
	private java.lang.Integer encashablePercent;
	private java.lang.String crFrdable;
	private java.lang.String enchFormula;
	private java.lang.String monthOrYear;

	// many to one
	private jkt.hms.masters.business.HrMasLeave leaveType;
	private jkt.hms.masters.business.MasHospital company;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
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
	 * Return the value associated with the column: encashable
	 */
	public java.lang.String getEncashable () {
		return encashable;
	}

	/**
	 * Set the value related to the column: encashable
	 * @param encashable the encashable value
	 */
	public void setEncashable (java.lang.String encashable) {
		this.encashable = encashable;
	}



	/**
	 * Return the value associated with the column: allowed_days
	 */
	public java.lang.String getAllowedDays () {
		return allowedDays;
	}

	/**
	 * Set the value related to the column: allowed_days
	 * @param allowedDays the allowed_days value
	 */
	public void setAllowedDays (java.lang.String allowedDays) {
		this.allowedDays = allowedDays;
	}



	/**
	 * Return the value associated with the column: valid_from_date
	 */
	public java.util.Date getValidFromDate () {
		return validFromDate;
	}

	/**
	 * Set the value related to the column: valid_from_date
	 * @param validFromDate the valid_from_date value
	 */
	public void setValidFromDate (java.util.Date validFromDate) {
		this.validFromDate = validFromDate;
	}



	/**
	 * Return the value associated with the column: valid_to_date
	 */
	public java.util.Date getValidToDate () {
		return validToDate;
	}

	/**
	 * Set the value related to the column: valid_to_date
	 * @param validToDate the valid_to_date value
	 */
	public void setValidToDate (java.util.Date validToDate) {
		this.validToDate = validToDate;
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
	 * Return the value associated with the column: encashable_percent
	 */
	public java.lang.Integer getEncashablePercent () {
		return encashablePercent;
	}

	/**
	 * Set the value related to the column: encashable_percent
	 * @param encashablePercent the encashable_percent value
	 */
	public void setEncashablePercent (java.lang.Integer encashablePercent) {
		this.encashablePercent = encashablePercent;
	}



	/**
	 * Return the value associated with the column: cr_frdable
	 */
	public java.lang.String getCrFrdable () {
		return crFrdable;
	}

	/**
	 * Set the value related to the column: cr_frdable
	 * @param crFrdable the cr_frdable value
	 */
	public void setCrFrdable (java.lang.String crFrdable) {
		this.crFrdable = crFrdable;
	}



	/**
	 * Return the value associated with the column: ench_formula
	 */
	public java.lang.String getEnchFormula () {
		return enchFormula;
	}

	/**
	 * Set the value related to the column: ench_formula
	 * @param enchFormula the ench_formula value
	 */
	public void setEnchFormula (java.lang.String enchFormula) {
		this.enchFormula = enchFormula;
	}



	/**
	 * Return the value associated with the column: month_or_year
	 */
	public java.lang.String getMonthOrYear () {
		return monthOrYear;
	}

	/**
	 * Set the value related to the column: month_or_year
	 * @param monthOrYear the month_or_year value
	 */
	public void setMonthOrYear (java.lang.String monthOrYear) {
		this.monthOrYear = monthOrYear;
	}



	/**
	 * Return the value associated with the column: leave_type
	 */
	public jkt.hms.masters.business.HrMasLeave getLeaveType () {
		return leaveType;
	}

	/**
	 * Set the value related to the column: leave_type
	 * @param leaveType the leave_type value
	 */
	public void setLeaveType (jkt.hms.masters.business.HrMasLeave leaveType) {
		this.leaveType = leaveType;
	}



	/**
	 * Return the value associated with the column: company_id
	 */
	public jkt.hms.masters.business.MasHospital getCompany () {
		return company;
	}

	/**
	 * Set the value related to the column: company_id
	 * @param company the company_id value
	 */
	public void setCompany (jkt.hms.masters.business.MasHospital company) {
		this.company = company;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HrMasLeaveTypeBackup)) return false;
		else {
			jkt.hms.masters.business.HrMasLeaveTypeBackup hrMasLeaveTypeBackup = (jkt.hms.masters.business.HrMasLeaveTypeBackup) obj;
			if (null == this.getId() || null == hrMasLeaveTypeBackup.getId()) return false;
			else return (this.getId().equals(hrMasLeaveTypeBackup.getId()));
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
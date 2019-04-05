package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_mas_leave_type_new table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_mas_leave_type_new"
 */

public abstract class BaseHrMasLeaveTypeNew  implements Serializable {

	public static String REF = "HrMasLeaveTypeNew";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_VALID_TO_DATE = "ValidToDate";
	public static String PROP_COMPANY = "Company";
	public static String PROP_ENCH_FORMULA = "EnchFormula";
	public static String PROP_LEAVE_TYPE = "LeaveType";
	public static String PROP_BUFFER_REQUIRED = "BufferRequired";
	public static String PROP_MONTHLY_OR_YEARLY = "MonthlyOrYearly";
	public static String PROP_HALF_DAY_ALLOW = "HalfDayAllow";
	public static String PROP_ALLOWED_DAYS = "AllowedDays";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ENCASHABLE_PERCENT = "EncashablePercent";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_VALID_FROM_DATE = "ValidFromDate";
	public static String PROP_CR_FRDABLE = "CrFrdable";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ENCASHABLE = "Encashable";


	// constructors
	public BaseHrMasLeaveTypeNew () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrMasLeaveTypeNew (java.lang.Integer id) {
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
	private java.lang.String monthlyOrYearly;
	private java.lang.String halfDayAllow;
	private java.lang.Integer bufferRequired;

	// many to one
	private jkt.hms.masters.business.MasHospital company;
	private jkt.hms.masters.business.HrMasLeave leaveType;

	// collections
	private java.util.Set<jkt.hms.masters.business.HrLeaveDetails> hrLeaveDetails;
	private java.util.Set<jkt.hms.masters.business.HrMasLeaveTypeMediatorHistory> hrMasLeaveTypeMediatorHistories;
	private java.util.Set<jkt.hms.masters.business.HrMasLeaveTypeMediator> hrMasLeaveTypeMediators;



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
	public java.lang.String getMonthlyOrYearly () {
		return monthlyOrYearly;
	}

	/**
	 * Set the value related to the column: month_or_year
	 * @param monthlyOrYearly the month_or_year value
	 */
	public void setMonthlyOrYearly (java.lang.String monthlyOrYearly) {
		this.monthlyOrYearly = monthlyOrYearly;
	}



	/**
	 * Return the value associated with the column: half_day_allow
	 */
	public java.lang.String getHalfDayAllow () {
		return halfDayAllow;
	}

	/**
	 * Set the value related to the column: half_day_allow
	 * @param halfDayAllow the half_day_allow value
	 */
	public void setHalfDayAllow (java.lang.String halfDayAllow) {
		this.halfDayAllow = halfDayAllow;
	}



	/**
	 * Return the value associated with the column: buffer_required
	 */
	public java.lang.Integer getBufferRequired () {
		return bufferRequired;
	}

	/**
	 * Set the value related to the column: buffer_required
	 * @param bufferRequired the buffer_required value
	 */
	public void setBufferRequired (java.lang.Integer bufferRequired) {
		this.bufferRequired = bufferRequired;
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
	 * Return the value associated with the column: HrLeaveDetails
	 */
	public java.util.Set<jkt.hms.masters.business.HrLeaveDetails> getHrLeaveDetails () {
		return hrLeaveDetails;
	}

	/**
	 * Set the value related to the column: HrLeaveDetails
	 * @param hrLeaveDetails the HrLeaveDetails value
	 */
	public void setHrLeaveDetails (java.util.Set<jkt.hms.masters.business.HrLeaveDetails> hrLeaveDetails) {
		this.hrLeaveDetails = hrLeaveDetails;
	}

	public void addToHrLeaveDetails (jkt.hms.masters.business.HrLeaveDetails hrLeaveDetails) {
		if (null == getHrLeaveDetails()) setHrLeaveDetails(new java.util.TreeSet<jkt.hms.masters.business.HrLeaveDetails>());
		getHrLeaveDetails().add(hrLeaveDetails);
	}



	/**
	 * Return the value associated with the column: HrMasLeaveTypeMediatorHistories
	 */
	public java.util.Set<jkt.hms.masters.business.HrMasLeaveTypeMediatorHistory> getHrMasLeaveTypeMediatorHistories () {
		return hrMasLeaveTypeMediatorHistories;
	}

	/**
	 * Set the value related to the column: HrMasLeaveTypeMediatorHistories
	 * @param hrMasLeaveTypeMediatorHistories the HrMasLeaveTypeMediatorHistories value
	 */
	public void setHrMasLeaveTypeMediatorHistories (java.util.Set<jkt.hms.masters.business.HrMasLeaveTypeMediatorHistory> hrMasLeaveTypeMediatorHistories) {
		this.hrMasLeaveTypeMediatorHistories = hrMasLeaveTypeMediatorHistories;
	}

	public void addToHrMasLeaveTypeMediatorHistories (jkt.hms.masters.business.HrMasLeaveTypeMediatorHistory hrMasLeaveTypeMediatorHistory) {
		if (null == getHrMasLeaveTypeMediatorHistories()) setHrMasLeaveTypeMediatorHistories(new java.util.TreeSet<jkt.hms.masters.business.HrMasLeaveTypeMediatorHistory>());
		getHrMasLeaveTypeMediatorHistories().add(hrMasLeaveTypeMediatorHistory);
	}



	/**
	 * Return the value associated with the column: HrMasLeaveTypeMediators
	 */
	public java.util.Set<jkt.hms.masters.business.HrMasLeaveTypeMediator> getHrMasLeaveTypeMediators () {
		return hrMasLeaveTypeMediators;
	}

	/**
	 * Set the value related to the column: HrMasLeaveTypeMediators
	 * @param hrMasLeaveTypeMediators the HrMasLeaveTypeMediators value
	 */
	public void setHrMasLeaveTypeMediators (java.util.Set<jkt.hms.masters.business.HrMasLeaveTypeMediator> hrMasLeaveTypeMediators) {
		this.hrMasLeaveTypeMediators = hrMasLeaveTypeMediators;
	}

	public void addToHrMasLeaveTypeMediators (jkt.hms.masters.business.HrMasLeaveTypeMediator hrMasLeaveTypeMediator) {
		if (null == getHrMasLeaveTypeMediators()) setHrMasLeaveTypeMediators(new java.util.TreeSet<jkt.hms.masters.business.HrMasLeaveTypeMediator>());
		getHrMasLeaveTypeMediators().add(hrMasLeaveTypeMediator);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HrMasLeaveTypeNew)) return false;
		else {
			jkt.hms.masters.business.HrMasLeaveTypeNew hrMasLeaveTypeNew = (jkt.hms.masters.business.HrMasLeaveTypeNew) obj;
			if (null == this.getId() || null == hrMasLeaveTypeNew.getId()) return false;
			else return (this.getId().equals(hrMasLeaveTypeNew.getId()));
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
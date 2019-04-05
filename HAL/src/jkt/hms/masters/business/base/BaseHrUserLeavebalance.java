package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_user_leavebalance table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_user_leavebalance"
 */

public abstract class BaseHrUserLeavebalance  implements Serializable {

	public static String REF = "HrUserLeavebalance";
	public static String PROP_LEAVECOUNTER = "Leavecounter";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_COMPANY = "Company";
	public static String PROP_ENCASHED_AMT = "EncashedAmt";
	public static String PROP_LEAVE_TYPE = "LeaveType";
	public static String PROP_ENCASHED_DAYS = "EncashedDays";
	public static String PROP_LEAVE_BALANCE = "LeaveBalance";
	public static String PROP_ID = "Id";
	public static String PROP_ONSITE_UK_BALANCE = "OnsiteUkBalance";
	public static String PROP_BAL_FLAG = "BalFlag";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";


	// constructors
	public BaseHrUserLeavebalance () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrUserLeavebalance (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String leaveBalance;
	private java.lang.String leavecounter;
	private java.lang.String onsiteUkBalance;
	private java.lang.Integer balFlag;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String encashedDays;
	private java.lang.Integer encashedAmt;

	// many to one
	private jkt.hms.masters.business.MasHospital company;
	private jkt.hms.masters.business.HrMasLeaveType leaveType;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="empid"
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
	 * Return the value associated with the column: leaveBalance
	 */
	public java.lang.String getLeaveBalance () {
		return leaveBalance;
	}

	/**
	 * Set the value related to the column: leaveBalance
	 * @param leaveBalance the leaveBalance value
	 */
	public void setLeaveBalance (java.lang.String leaveBalance) {
		this.leaveBalance = leaveBalance;
	}



	/**
	 * Return the value associated with the column: leavecounter
	 */
	public java.lang.String getLeavecounter () {
		return leavecounter;
	}

	/**
	 * Set the value related to the column: leavecounter
	 * @param leavecounter the leavecounter value
	 */
	public void setLeavecounter (java.lang.String leavecounter) {
		this.leavecounter = leavecounter;
	}



	/**
	 * Return the value associated with the column: onsite_uk_balance
	 */
	public java.lang.String getOnsiteUkBalance () {
		return onsiteUkBalance;
	}

	/**
	 * Set the value related to the column: onsite_uk_balance
	 * @param onsiteUkBalance the onsite_uk_balance value
	 */
	public void setOnsiteUkBalance (java.lang.String onsiteUkBalance) {
		this.onsiteUkBalance = onsiteUkBalance;
	}



	/**
	 * Return the value associated with the column: bal_flag
	 */
	public java.lang.Integer getBalFlag () {
		return balFlag;
	}

	/**
	 * Set the value related to the column: bal_flag
	 * @param balFlag the bal_flag value
	 */
	public void setBalFlag (java.lang.Integer balFlag) {
		this.balFlag = balFlag;
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
	 * Return the value associated with the column: encashed_days
	 */
	public java.lang.String getEncashedDays () {
		return encashedDays;
	}

	/**
	 * Set the value related to the column: encashed_days
	 * @param encashedDays the encashed_days value
	 */
	public void setEncashedDays (java.lang.String encashedDays) {
		this.encashedDays = encashedDays;
	}



	/**
	 * Return the value associated with the column: encashed_amt
	 */
	public java.lang.Integer getEncashedAmt () {
		return encashedAmt;
	}

	/**
	 * Set the value related to the column: encashed_amt
	 * @param encashedAmt the encashed_amt value
	 */
	public void setEncashedAmt (java.lang.Integer encashedAmt) {
		this.encashedAmt = encashedAmt;
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
	public jkt.hms.masters.business.HrMasLeaveType getLeaveType () {
		return leaveType;
	}

	/**
	 * Set the value related to the column: leave_type
	 * @param leaveType the leave_type value
	 */
	public void setLeaveType (jkt.hms.masters.business.HrMasLeaveType leaveType) {
		this.leaveType = leaveType;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HrUserLeavebalance)) return false;
		else {
			jkt.hms.masters.business.HrUserLeavebalance hrUserLeavebalance = (jkt.hms.masters.business.HrUserLeavebalance) obj;
			if (null == this.getId() || null == hrUserLeavebalance.getId()) return false;
			else return (this.getId().equals(hrUserLeavebalance.getId()));
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
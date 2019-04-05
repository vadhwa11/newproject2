package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the hrorderly_leave_account
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="hrorderly_leave_account"
 */

public abstract class BaseHrorderlyLeaveAccount implements Serializable {

	public static String REF = "HrorderlyLeaveAccount";
	public static String PROP_CHG_BY = "ChgBy";
	public static String PROP_YEAR = "Year";
	public static String PROP_STATUS = "Status";
	public static String PROP_C_LEAVE_BALANCE = "CLeaveBalance";
	public static String PROP_CHG_TIME = "ChgTime";
	public static String PROP_CHG_DATE = "ChgDate";
	public static String PROP_LEAVE_AVAILED = "LeaveAvailed";
	public static String PROP_LEAVE_TYPE_ID = "LeaveTypeId";
	public static String PROP_O_LEAVE_BALANCE = "OLeaveBalance";
	public static String PROP_ID = "Id";
	public static String PROP_ENTITLED_LEAVE = "EntitledLeave";
	public static String PROP_EMPLOYEE_ID = "EmployeeId";

	// constructors
	public BaseHrorderlyLeaveAccount() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrorderlyLeaveAccount(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer employeeId;
	private java.lang.Integer leaveTypeId;
	private java.lang.Integer oLeaveBalance;
	private java.lang.Integer entitledLeave;
	private java.lang.Integer leaveAvailed;
	private java.lang.Integer cLeaveBalance;
	private java.lang.String status;
	private java.lang.String chgBy;
	private java.util.Date chgDate;
	private java.lang.String chgTime;
	private java.lang.String year;

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
	 * Return the value associated with the column: employee_id
	 */
	public java.lang.Integer getEmployeeId() {
		return employeeId;
	}

	/**
	 * Set the value related to the column: employee_id
	 * 
	 * @param employeeId
	 *            the employee_id value
	 */
	public void setEmployeeId(java.lang.Integer employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * Return the value associated with the column: leave_type_id
	 */
	public java.lang.Integer getLeaveTypeId() {
		return leaveTypeId;
	}

	/**
	 * Set the value related to the column: leave_type_id
	 * 
	 * @param leaveTypeId
	 *            the leave_type_id value
	 */
	public void setLeaveTypeId(java.lang.Integer leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}

	/**
	 * Return the value associated with the column: o_leave_balance
	 */
	public java.lang.Integer getOLeaveBalance() {
		return oLeaveBalance;
	}

	/**
	 * Set the value related to the column: o_leave_balance
	 * 
	 * @param oLeaveBalance
	 *            the o_leave_balance value
	 */
	public void setOLeaveBalance(java.lang.Integer oLeaveBalance) {
		this.oLeaveBalance = oLeaveBalance;
	}

	/**
	 * Return the value associated with the column: entitled_leave
	 */
	public java.lang.Integer getEntitledLeave() {
		return entitledLeave;
	}

	/**
	 * Set the value related to the column: entitled_leave
	 * 
	 * @param entitledLeave
	 *            the entitled_leave value
	 */
	public void setEntitledLeave(java.lang.Integer entitledLeave) {
		this.entitledLeave = entitledLeave;
	}

	/**
	 * Return the value associated with the column: leave_availed
	 */
	public java.lang.Integer getLeaveAvailed() {
		return leaveAvailed;
	}

	/**
	 * Set the value related to the column: leave_availed
	 * 
	 * @param leaveAvailed
	 *            the leave_availed value
	 */
	public void setLeaveAvailed(java.lang.Integer leaveAvailed) {
		this.leaveAvailed = leaveAvailed;
	}

	/**
	 * Return the value associated with the column: c_leave_balance
	 */
	public java.lang.Integer getCLeaveBalance() {
		return cLeaveBalance;
	}

	/**
	 * Set the value related to the column: c_leave_balance
	 * 
	 * @param cLeaveBalance
	 *            the c_leave_balance value
	 */
	public void setCLeaveBalance(java.lang.Integer cLeaveBalance) {
		this.cLeaveBalance = cLeaveBalance;
	}

	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus() {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * 
	 * @param status
	 *            the status value
	 */
	public void setStatus(java.lang.String status) {
		this.status = status;
	}

	/**
	 * Return the value associated with the column: chg_by
	 */
	public java.lang.String getChgBy() {
		return chgBy;
	}

	/**
	 * Set the value related to the column: chg_by
	 * 
	 * @param chgBy
	 *            the chg_by value
	 */
	public void setChgBy(java.lang.String chgBy) {
		this.chgBy = chgBy;
	}

	/**
	 * Return the value associated with the column: chg_date
	 */
	public java.util.Date getChgDate() {
		return chgDate;
	}

	/**
	 * Set the value related to the column: chg_date
	 * 
	 * @param chgDate
	 *            the chg_date value
	 */
	public void setChgDate(java.util.Date chgDate) {
		this.chgDate = chgDate;
	}

	/**
	 * Return the value associated with the column: chg_time
	 */
	public java.lang.String getChgTime() {
		return chgTime;
	}

	/**
	 * Set the value related to the column: chg_time
	 * 
	 * @param chgTime
	 *            the chg_time value
	 */
	public void setChgTime(java.lang.String chgTime) {
		this.chgTime = chgTime;
	}

	/**
	 * Return the value associated with the column: year
	 */
	public java.lang.String getYear() {
		return year;
	}

	/**
	 * Set the value related to the column: year
	 * 
	 * @param year
	 *            the year value
	 */
	public void setYear(java.lang.String year) {
		this.year = year;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.HrorderlyLeaveAccount))
			return false;
		else {
			jkt.hms.masters.business.HrorderlyLeaveAccount hrorderlyLeaveAccount = (jkt.hms.masters.business.HrorderlyLeaveAccount) obj;
			if (null == this.getId() || null == hrorderlyLeaveAccount.getId())
				return false;
			else
				return (this.getId().equals(hrorderlyLeaveAccount.getId()));
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
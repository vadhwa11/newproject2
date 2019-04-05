package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_monthly_ration_accounting_leave_detail table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_monthly_ration_accounting_leave_detail"
 */

public abstract class BaseHrMonthlyRationAccountingLeaveDetail  implements Serializable {

	public static String REF = "HrMonthlyRationAccountingLeaveDetail";
	public static String PROP_YEAR = "Year";
	public static String PROP_LEAVE_FROM_DATE = "LeaveFromDate";
	public static String PROP_LEAVE_TOTAL_DAYS = "LeaveTotalDays";
	public static String PROP_EFF_TOTAL_DAYS ="EffTotalDays";
	public static String PROP_ID = "Id";
	public static String PROP_LEAVE_TO_DATE = "LeaveToDate";
	public static String PROP_MONTH = "Month";
	

	// constructors
	public BaseHrMonthlyRationAccountingLeaveDetail () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrMonthlyRationAccountingLeaveDetail (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	
	private java.lang.Integer year;
	private java.lang.Integer month;
	private java.util.Date leaveFromDate;
	private java.util.Date leaveToDate;
	private java.lang.Integer leaveTotalDays;
	private java.lang.Integer effTotalDays ;
	
	//many-to-one
	private jkt.hms.masters.business.MasEmployee employeeId ;
	private jkt.hms.masters.business.HrMonthlyRationAccounting rationId ;
	private jkt.hms.masters.business.HrorderlyLeaveApplication leaveId ;
	private jkt.hms.masters.business.HrLeaveTypeMaster leaveTypeId ;


	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="leave_detail_id"
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
	 * Return the value associated with the column: year
	 */
	public java.lang.Integer getYear () {
		return year;
	}

	/**
	 * Set the value related to the column: year
	 * @param year the year value
	 */
	public void setYear (java.lang.Integer year) {
		this.year = year;
	}



	/**
	 * Return the value associated with the column: month
	 */
	public java.lang.Integer getMonth () {
		return month;
	}

	/**
	 * Set the value related to the column: month
	 * @param month the month value
	 */
	public void setMonth (java.lang.Integer month) {
		this.month = month;
	}



	/**
	 * Return the value associated with the column: leave_from_date
	 */
	public java.util.Date getLeaveFromDate () {
		return leaveFromDate;
	}

	/**
	 * Set the value related to the column: leave_from_date
	 * @param leaveFromDate the leave_from_date value
	 */
	public void setLeaveFromDate (java.util.Date leaveFromDate) {
		this.leaveFromDate = leaveFromDate;
	}



	/**
	 * Return the value associated with the column: leave_to_date
	 */
	public java.util.Date getLeaveToDate () {
		return leaveToDate;
	}

	/**
	 * Set the value related to the column: leave_to_date
	 * @param leaveToDate the leave_to_date value
	 */
	public void setLeaveToDate (java.util.Date leaveToDate) {
		this.leaveToDate = leaveToDate;
	}



	/**
	 * Return the value associated with the column: leave_total_days
	 */
	public java.lang.Integer getLeaveTotalDays () {
		return leaveTotalDays;
	}

	/**
	 * Set the value related to the column: leave_total_days
	 * @param leaveTotalDays the leave_total_days value
	 */
	public void setLeaveTotalDays (java.lang.Integer leaveTotalDays) {
		this.leaveTotalDays = leaveTotalDays;
	}



	/**
	 * Return the value associated with the column: leave_type_id
	 */
	public jkt.hms.masters.business.HrLeaveTypeMaster getLeaveTypeId () {
		return leaveTypeId;
	}

	/**
	 * Set the value related to the column: leave_type_id
	 * @param leaveTypeId the leave_type_id value
	 */
	public void setLeaveTypeId (jkt.hms.masters.business.HrLeaveTypeMaster leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}
    
	/**
	 * Set the value related to the column: eff_total_days
	 * @param hospTotalDays the hosp_total_days value
	 */
	public void setEffTotalDays (java.lang.Integer effTotalDays) {
		this.effTotalDays = effTotalDays;
	}
	/**
	 * Return the value associated with the column: effTotalDays
	 */
	public java.lang.Integer getEffTotalDays () {
		return effTotalDays;
	}
	


	/**
	 * Return the value associated with the column: leave_id
	 */
	public jkt.hms.masters.business.HrorderlyLeaveApplication getLeaveId () {
		return leaveId;
	}

	/**
	 * Set the value related to the column: leave_id
	 * @param leaveId the leave_id value
	 */
	public void setLeaveId (jkt.hms.masters.business.HrorderlyLeaveApplication leaveId) {
		this.leaveId = leaveId;
	}
	/**
	 * Return the value associated with the column: ration_id
	 */
	public jkt.hms.masters.business.HrMonthlyRationAccounting getRationId () {
		return rationId;
	}

	/**
	 * Set the value related to the column: ration_id
	 * @param rationId the ration_id value
	 */
	public void setRationId (jkt.hms.masters.business.HrMonthlyRationAccounting rationId) {
		this.rationId = rationId;
	}



	/**
	 * Return the value associated with the column: employee_id
	 */
	public jkt.hms.masters.business.MasEmployee getEmployeeId () {
		return employeeId;
	}

	/**
	 * Set the value related to the column: employee_id
	 * @param employeeId the employee_id value
	 */
	public void setEmployeeId (jkt.hms.masters.business.MasEmployee employeeId) {
		this.employeeId = employeeId;
	}






	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HrMonthlyRationAccountingLeaveDetail)) return false;
		else {
			jkt.hms.masters.business.HrMonthlyRationAccountingLeaveDetail hrMonthlyRationAccountingLeaveDetail = (jkt.hms.masters.business.HrMonthlyRationAccountingLeaveDetail) obj;
			if (null == this.getId() || null == hrMonthlyRationAccountingLeaveDetail.getId()) return false;
			else return (this.getId().equals(hrMonthlyRationAccountingLeaveDetail.getId()));
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
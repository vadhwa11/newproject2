package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the emp_leave_balance table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="emp_leave_balance"
 */

public abstract class BaseEmpLeaveBalance implements Serializable {

	public static String REF = "EmpLeaveBalance";
	public static String PROP_APPLIED = "Applied";
	public static String PROP_LEAVE = "Leave";
	public static String PROP_EMP = "Emp";
	public static String PROP_APPROVED = "Approved";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_APPROVED_DATE = "ApprovedDate";
	public static String PROP_ID = "Id";
	public static String PROP_APPROVED_BY = "ApprovedBy";
	public static String PROP_LEAVE_APP = "LeaveApp";

	// constructors
	public BaseEmpLeaveBalance() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseEmpLeaveBalance(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String applied;
	private java.lang.String approved;
	private java.util.Date approvedDate;
	private java.lang.String remarks;

	// many to one
	private jkt.hms.masters.business.MasEmployee approvedBy;
	private jkt.hms.masters.business.HrorderlyLeaveApplication leaveApp;
	private jkt.hms.masters.business.MasEmployee emp;
	private jkt.hms.masters.business.HrLeaveTypeMaster leave;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="balance_id"
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
	 * Return the value associated with the column: applied
	 */
	public java.lang.String getApplied() {
		return applied;
	}

	/**
	 * Set the value related to the column: applied
	 * 
	 * @param applied
	 *            the applied value
	 */
	public void setApplied(java.lang.String applied) {
		this.applied = applied;
	}

	/**
	 * Return the value associated with the column: approved
	 */
	public java.lang.String getApproved() {
		return approved;
	}

	/**
	 * Set the value related to the column: approved
	 * 
	 * @param approved
	 *            the approved value
	 */
	public void setApproved(java.lang.String approved) {
		this.approved = approved;
	}

	/**
	 * Return the value associated with the column: approved_date
	 */
	public java.util.Date getApprovedDate() {
		return approvedDate;
	}

	/**
	 * Set the value related to the column: approved_date
	 * 
	 * @param approvedDate
	 *            the approved_date value
	 */
	public void setApprovedDate(java.util.Date approvedDate) {
		this.approvedDate = approvedDate;
	}

	/**
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks() {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * 
	 * @param remarks
	 *            the remarks value
	 */
	public void setRemarks(java.lang.String remarks) {
		this.remarks = remarks;
	}

	/**
	 * Return the value associated with the column: approved_by
	 */
	public jkt.hms.masters.business.MasEmployee getApprovedBy() {
		return approvedBy;
	}

	/**
	 * Set the value related to the column: approved_by
	 * 
	 * @param approvedBy
	 *            the approved_by value
	 */
	public void setApprovedBy(jkt.hms.masters.business.MasEmployee approvedBy) {
		this.approvedBy = approvedBy;
	}

	/**
	 * Return the value associated with the column: leave_app_id
	 */
	public jkt.hms.masters.business.HrorderlyLeaveApplication getLeaveApp() {
		return leaveApp;
	}

	/**
	 * Set the value related to the column: leave_app_id
	 * 
	 * @param leaveApp
	 *            the leave_app_id value
	 */
	public void setLeaveApp(
			jkt.hms.masters.business.HrorderlyLeaveApplication leaveApp) {
		this.leaveApp = leaveApp;
	}

	/**
	 * Return the value associated with the column: emp_id
	 */
	public jkt.hms.masters.business.MasEmployee getEmp() {
		return emp;
	}

	/**
	 * Set the value related to the column: emp_id
	 * 
	 * @param emp
	 *            the emp_id value
	 */
	public void setEmp(jkt.hms.masters.business.MasEmployee emp) {
		this.emp = emp;
	}

	/**
	 * Return the value associated with the column: leave_id
	 */
	public jkt.hms.masters.business.HrLeaveTypeMaster getLeave() {
		return leave;
	}

	/**
	 * Set the value related to the column: leave_id
	 * 
	 * @param leave
	 *            the leave_id value
	 */
	public void setLeave(jkt.hms.masters.business.HrLeaveTypeMaster leave) {
		this.leave = leave;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.EmpLeaveBalance))
			return false;
		else {
			jkt.hms.masters.business.EmpLeaveBalance empLeaveBalance = (jkt.hms.masters.business.EmpLeaveBalance) obj;
			if (null == this.getId() || null == empLeaveBalance.getId())
				return false;
			else
				return (this.getId().equals(empLeaveBalance.getId()));
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
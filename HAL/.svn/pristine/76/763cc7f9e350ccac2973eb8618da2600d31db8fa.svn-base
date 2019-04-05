package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * hrorderly_monthly_ration_accounting table. Do not modify this class because
 * it will be overwritten if the configuration file related to this class is
 * modified.
 * 
 * @hibernate.class table="hrorderly_monthly_ration_accounting"
 */

public abstract class BaseHrorderlyMonthlyRationAccounting implements
		Serializable {

	public static String REF = "HrorderlyMonthlyRationAccounting";
	public static String PROP_LST_CHANGED_TIME = "LstChangedTime";
	public static String PROP_STATUS = "Status";
	public static String PROP_YEAR = "Year";
	public static String PROP_LEAVE = "Leave";
	public static String PROP_OCCURENCE_NO = "OccurenceNo";
	public static String PROP_LST_CHANGED_BY = "LstChangedBy";
	public static String PROP_ID = "Id";
	public static String PROP_POR_NO = "PorNo";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_LST_CHANGED_DATE = "LstChangedDate";
	public static String PROP_MONTH = "Month";

	// constructors
	public BaseHrorderlyMonthlyRationAccounting() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrorderlyMonthlyRationAccounting(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String month;
	private java.lang.Integer year;
	private java.lang.String lstChangedBy;
	private java.util.Date lstChangedDate;
	private java.lang.String lstChangedTime;
	private java.lang.String status;
	private java.lang.String porNo;
	private java.lang.String occurenceNo;

	// many to one
	private jkt.hms.masters.business.MasEmployee employee;
	private jkt.hms.masters.business.HrorderlyLeaveApplication leave;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="monthly_ration_id"
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
	 * Return the value associated with the column: month
	 */
	public java.lang.String getMonth() {
		return month;
	}

	/**
	 * Set the value related to the column: month
	 * 
	 * @param month
	 *            the month value
	 */
	public void setMonth(java.lang.String month) {
		this.month = month;
	}

	/**
	 * Return the value associated with the column: year
	 */
	public java.lang.Integer getYear() {
		return year;
	}

	/**
	 * Set the value related to the column: year
	 * 
	 * @param year
	 *            the year value
	 */
	public void setYear(java.lang.Integer year) {
		this.year = year;
	}

	/**
	 * Return the value associated with the column: lst_changed_by
	 */
	public java.lang.String getLstChangedBy() {
		return lstChangedBy;
	}

	/**
	 * Set the value related to the column: lst_changed_by
	 * 
	 * @param lstChangedBy
	 *            the lst_changed_by value
	 */
	public void setLstChangedBy(java.lang.String lstChangedBy) {
		this.lstChangedBy = lstChangedBy;
	}

	/**
	 * Return the value associated with the column: lst_changed_date
	 */
	public java.util.Date getLstChangedDate() {
		return lstChangedDate;
	}

	/**
	 * Set the value related to the column: lst_changed_date
	 * 
	 * @param lstChangedDate
	 *            the lst_changed_date value
	 */
	public void setLstChangedDate(java.util.Date lstChangedDate) {
		this.lstChangedDate = lstChangedDate;
	}

	/**
	 * Return the value associated with the column: lst_changed_time
	 */
	public java.lang.String getLstChangedTime() {
		return lstChangedTime;
	}

	/**
	 * Set the value related to the column: lst_changed_time
	 * 
	 * @param lstChangedTime
	 *            the lst_changed_time value
	 */
	public void setLstChangedTime(java.lang.String lstChangedTime) {
		this.lstChangedTime = lstChangedTime;
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
	 * Return the value associated with the column: por_no
	 */
	public java.lang.String getPorNo() {
		return porNo;
	}

	/**
	 * Set the value related to the column: por_no
	 * 
	 * @param porNo
	 *            the por_no value
	 */
	public void setPorNo(java.lang.String porNo) {
		this.porNo = porNo;
	}

	/**
	 * Return the value associated with the column: occurence_no
	 */
	public java.lang.String getOccurenceNo() {
		return occurenceNo;
	}

	/**
	 * Set the value related to the column: occurence_no
	 * 
	 * @param occurenceNo
	 *            the occurence_no value
	 */
	public void setOccurenceNo(java.lang.String occurenceNo) {
		this.occurenceNo = occurenceNo;
	}

	/**
	 * Return the value associated with the column: employee_id
	 */
	public jkt.hms.masters.business.MasEmployee getEmployee() {
		return employee;
	}

	/**
	 * Set the value related to the column: employee_id
	 * 
	 * @param employee
	 *            the employee_id value
	 */
	public void setEmployee(jkt.hms.masters.business.MasEmployee employee) {
		this.employee = employee;
	}

	/**
	 * Return the value associated with the column: leave_id
	 */
	public jkt.hms.masters.business.HrorderlyLeaveApplication getLeave() {
		return leave;
	}

	/**
	 * Set the value related to the column: leave_id
	 * 
	 * @param leave
	 *            the leave_id value
	 */
	public void setLeave(
			jkt.hms.masters.business.HrorderlyLeaveApplication leave) {
		this.leave = leave;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.HrorderlyMonthlyRationAccounting))
			return false;
		else {
			jkt.hms.masters.business.HrorderlyMonthlyRationAccounting hrorderlyMonthlyRationAccounting = (jkt.hms.masters.business.HrorderlyMonthlyRationAccounting) obj;
			if (null == this.getId()
					|| null == hrorderlyMonthlyRationAccounting.getId())
				return false;
			else
				return (this.getId().equals(hrorderlyMonthlyRationAccounting
						.getId()));
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
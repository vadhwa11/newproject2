package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the movement_in_entry table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="movement_in_entry"
 */

public abstract class BaseMovementInEntry implements Serializable {

	public static String REF = "MovementInEntry";
	public static String PROP_LST_CHANGED_BY = "LstChangedBy";
	public static String PROP_FROM_UNIT = "FromUnit";
	public static String PROP_MOVEMENT_TYPE = "MovementType";
	public static String PROP_FROM_DATE = "FromDate";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_EMPLOYEE_CODE = "EmployeeCode";
	public static String PROP_LST_CHANGED_TIME = "LstChangedTime";
	public static String PROP_STATUS = "Status";
	public static String PROP_TO_DATE = "ToDate";
	public static String PROP_TO_TIME = "ToTime";
	public static String PROP_FROM_TIME = "FromTime";
	public static String PROP_ID = "Id";
	public static String PROP_LST_CHANGED_DATE = "LstChangedDate";

	// constructors
	public BaseMovementInEntry() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMovementInEntry(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String movementType;
	private java.util.Date fromDate;
	private java.util.Date toDate;
	private java.lang.String toTime;
	private java.lang.String remarks;
	private java.lang.String lstChangedBy;
	private java.util.Date lstChangedDate;
	private java.lang.String lstChangedTime;
	private java.lang.String status;
	private java.lang.String fromTime;
	private java.lang.Integer employee;
	private java.lang.String employeeCode;

	// many to one
	private jkt.hms.masters.business.MasUnit fromUnit;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="movement_in_id"
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
	 * Return the value associated with the column: movement_type
	 */
	public java.lang.String getMovementType() {
		return movementType;
	}

	/**
	 * Set the value related to the column: movement_type
	 * 
	 * @param movementType
	 *            the movement_type value
	 */
	public void setMovementType(java.lang.String movementType) {
		this.movementType = movementType;
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
	 * Return the value associated with the column: to_time
	 */
	public java.lang.String getToTime() {
		return toTime;
	}

	/**
	 * Set the value related to the column: to_time
	 * 
	 * @param toTime
	 *            the to_time value
	 */
	public void setToTime(java.lang.String toTime) {
		this.toTime = toTime;
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
	 * Return the value associated with the column: from_time
	 */
	public java.lang.String getFromTime() {
		return fromTime;
	}

	/**
	 * Set the value related to the column: from_time
	 * 
	 * @param fromTime
	 *            the from_time value
	 */
	public void setFromTime(java.lang.String fromTime) {
		this.fromTime = fromTime;
	}

	/**
	 * Return the value associated with the column: employee_id
	 */
	public java.lang.Integer getEmployee() {
		return employee;
	}

	/**
	 * Set the value related to the column: employee_id
	 * 
	 * @param employee
	 *            the employee_id value
	 */
	public void setEmployee(java.lang.Integer employee) {
		this.employee = employee;
	}

	/**
	 * Return the value associated with the column: employee_code
	 */
	public java.lang.String getEmployeeCode() {
		return employeeCode;
	}

	/**
	 * Set the value related to the column: employee_code
	 * 
	 * @param employeeCode
	 *            the employee_code value
	 */
	public void setEmployeeCode(java.lang.String employeeCode) {
		this.employeeCode = employeeCode;
	}

	/**
	 * Return the value associated with the column: from_unit
	 */
	public jkt.hms.masters.business.MasUnit getFromUnit() {
		return fromUnit;
	}

	/**
	 * Set the value related to the column: from_unit
	 * 
	 * @param fromUnit
	 *            the from_unit value
	 */
	public void setFromUnit(jkt.hms.masters.business.MasUnit fromUnit) {
		this.fromUnit = fromUnit;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MovementInEntry))
			return false;
		else {
			jkt.hms.masters.business.MovementInEntry movementInEntry = (jkt.hms.masters.business.MovementInEntry) obj;
			if (null == this.getId() || null == movementInEntry.getId())
				return false;
			else
				return (this.getId().equals(movementInEntry.getId()));
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
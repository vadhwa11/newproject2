package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the emp_groups table. Do not
 * modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * 
 * @hibernate.class table="emp_groups"
 */

public abstract class BaseEmpGroups implements Serializable {

	public static String REF = "EmpGroups";
	public static String PROP_STATUS = "Status";
	public static String PROP_EMP_GROUP_CODE = "EmpGroupCode";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_EMP_GROUP_NAME = "EmpGroupName";

	// constructors
	public BaseEmpGroups() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseEmpGroups(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String empGroupCode;
	private java.lang.String empGroupName;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// collections
	private java.util.Set<jkt.hms.masters.business.EmpGroups> empGroup;

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
	 * Return the value associated with the column: emp_group_code
	 */
	public java.lang.String getEmpGroupCode() {
		return empGroupCode;
	}

	/**
	 * Set the value related to the column: emp_group_code
	 * 
	 * @param empGroupCode
	 *            the emp_group_code value
	 */
	public void setEmpGroupCode(java.lang.String empGroupCode) {
		this.empGroupCode = empGroupCode;
	}

	/**
	 * Return the value associated with the column: emp_group_name
	 */
	public java.lang.String getEmpGroupName() {
		return empGroupName;
	}

	/**
	 * Set the value related to the column: emp_group_name
	 * 
	 * @param empGroupName
	 *            the emp_group_name value
	 */
	public void setEmpGroupName(java.lang.String empGroupName) {
		this.empGroupName = empGroupName;
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
	 * Return the value associated with the column: EmpGroup
	 */
	public java.util.Set<jkt.hms.masters.business.EmpGroups> getEmpGroup() {
		return empGroup;
	}

	/**
	 * Set the value related to the column: EmpGroup
	 * 
	 * @param empGroup
	 *            the EmpGroup value
	 */
	public void setEmpGroup(
			java.util.Set<jkt.hms.masters.business.EmpGroups> empGroup) {
		this.empGroup = empGroup;
	}

	public void addToEmpGroup(jkt.hms.masters.business.EmpGroups empGroups) {
		if (null == getEmpGroup())
			setEmpGroup(new java.util.TreeSet<jkt.hms.masters.business.EmpGroups>());
		getEmpGroup().add(empGroups);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.EmpGroups))
			return false;
		else {
			jkt.hms.masters.business.EmpGroups empGroups = (jkt.hms.masters.business.EmpGroups) obj;
			if (null == this.getId() || null == empGroups.getId())
				return false;
			else
				return (this.getId().equals(empGroups.getId()));
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
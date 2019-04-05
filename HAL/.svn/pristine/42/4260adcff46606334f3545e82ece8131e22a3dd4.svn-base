package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_department_type
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="mas_department_type"
 */

public abstract class BaseMasDepartmentType implements Serializable {

	public static String REF = "MasDepartmentType";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_DEPARTMENT_TYPE_NAME = "DepartmentTypeName";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DEPARTMENT_TYPE_CODE = "DepartmentTypeCode";
	public static String PROP_ID = "Id";

	// constructors
	public BaseMasDepartmentType() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasDepartmentType(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseMasDepartmentType(java.lang.Integer id, java.lang.String status) {

		this.setId(id);
		this.setStatus(status);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String departmentTypeCode;
	private java.lang.String departmentTypeName;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// collections
	private java.util.Set<jkt.hms.masters.business.MasDepartment> masDepartments;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="department_type_id"
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
	 * Return the value associated with the column: department_type_code
	 */
	public java.lang.String getDepartmentTypeCode() {
		return departmentTypeCode;
	}

	/**
	 * Set the value related to the column: department_type_code
	 * 
	 * @param departmentTypeCode
	 *            the department_type_code value
	 */
	public void setDepartmentTypeCode(java.lang.String departmentTypeCode) {
		this.departmentTypeCode = departmentTypeCode;
	}

	/**
	 * Return the value associated with the column: department_type_name
	 */
	public java.lang.String getDepartmentTypeName() {
		return departmentTypeName;
	}

	/**
	 * Set the value related to the column: department_type_name
	 * 
	 * @param departmentTypeName
	 *            the department_type_name value
	 */
	public void setDepartmentTypeName(java.lang.String departmentTypeName) {
		this.departmentTypeName = departmentTypeName;
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
	 * Return the value associated with the column: MasDepartments
	 */
	public java.util.Set<jkt.hms.masters.business.MasDepartment> getMasDepartments() {
		return masDepartments;
	}

	/**
	 * Set the value related to the column: MasDepartments
	 * 
	 * @param masDepartments
	 *            the MasDepartments value
	 */
	public void setMasDepartments(
			java.util.Set<jkt.hms.masters.business.MasDepartment> masDepartments) {
		this.masDepartments = masDepartments;
	}

	public void addToMasDepartments(
			jkt.hms.masters.business.MasDepartment masDepartment) {
		if (null == getMasDepartments())
			setMasDepartments(new java.util.TreeSet<jkt.hms.masters.business.MasDepartment>());
		getMasDepartments().add(masDepartment);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MasDepartmentType))
			return false;
		else {
			jkt.hms.masters.business.MasDepartmentType masDepartmentType = (jkt.hms.masters.business.MasDepartmentType) obj;
			if (null == this.getId() || null == masDepartmentType.getId())
				return false;
			else
				return (this.getId().equals(masDepartmentType.getId()));
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
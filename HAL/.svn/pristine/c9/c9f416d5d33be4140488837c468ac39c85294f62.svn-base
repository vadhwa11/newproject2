package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the employee_category table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="employee_category"
 */

public abstract class BaseEmployeeCategory implements Serializable {

	public static String REF = "EmployeeCategory";
	public static String PROP_STATUS_ID = "StatusId";
	public static String PROP_EMPLOYEE_CATEGORY_NAME = "EmployeeCategoryName";
	public static String PROP_ID = "Id";

	// constructors
	public BaseEmployeeCategory() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseEmployeeCategory(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String employeeCategoryName;
	private java.lang.Integer statusId;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="employee_category_id"
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
	 * Return the value associated with the column: employee_category_name
	 */
	public java.lang.String getEmployeeCategoryName() {
		return employeeCategoryName;
	}

	/**
	 * Set the value related to the column: employee_category_name
	 * 
	 * @param employeeCategoryName
	 *            the employee_category_name value
	 */
	public void setEmployeeCategoryName(java.lang.String employeeCategoryName) {
		this.employeeCategoryName = employeeCategoryName;
	}

	/**
	 * Return the value associated with the column: status_id
	 */
	public java.lang.Integer getStatusId() {
		return statusId;
	}

	/**
	 * Set the value related to the column: status_id
	 * 
	 * @param statusId
	 *            the status_id value
	 */
	public void setStatusId(java.lang.Integer statusId) {
		this.statusId = statusId;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.EmployeeCategory))
			return false;
		else {
			jkt.hms.masters.business.EmployeeCategory employeeCategory = (jkt.hms.masters.business.EmployeeCategory) obj;
			if (null == this.getId() || null == employeeCategory.getId())
				return false;
			else
				return (this.getId().equals(employeeCategory.getId()));
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
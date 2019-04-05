package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the work_no_department table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="work_no_department"
 */

public abstract class BaseWorkNoDepartment implements Serializable {

	public static String REF = "WorkNoDepartment";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_WORK_NO_TYPE = "WorkNoType";

	// constructors
	public BaseWorkNoDepartment() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseWorkNoDepartment(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseWorkNoDepartment(java.lang.Integer id,
			jkt.hms.masters.business.MasDepartmentType department,
			jkt.hms.masters.business.MasMinorWorkDetail workNoType) {

		this.setId(id);
		this.setDepartment(department);
		this.setWorkNoType(workNoType);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// many to one
	private jkt.hms.masters.business.MasDepartmentType department;
	private jkt.hms.masters.business.MasMinorWorkDetail workNoType;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="work_no_department_id"
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
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartmentType getDepartment() {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * 
	 * @param department
	 *            the department_id value
	 */
	public void setDepartment(
			jkt.hms.masters.business.MasDepartmentType department) {
		this.department = department;
	}

	/**
	 * Return the value associated with the column: work_no_type_id
	 */
	public jkt.hms.masters.business.MasMinorWorkDetail getWorkNoType() {
		return workNoType;
	}

	/**
	 * Set the value related to the column: work_no_type_id
	 * 
	 * @param workNoType
	 *            the work_no_type_id value
	 */
	public void setWorkNoType(
			jkt.hms.masters.business.MasMinorWorkDetail workNoType) {
		this.workNoType = workNoType;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.WorkNoDepartment))
			return false;
		else {
			jkt.hms.masters.business.WorkNoDepartment workNoDepartment = (jkt.hms.masters.business.WorkNoDepartment) obj;
			if (null == this.getId() || null == workNoDepartment.getId())
				return false;
			else
				return (this.getId().equals(workNoDepartment.getId()));
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
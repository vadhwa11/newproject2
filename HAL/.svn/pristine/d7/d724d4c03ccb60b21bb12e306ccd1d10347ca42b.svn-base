package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the user_department table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="user_department"
 */

public abstract class BaseUserDepartment implements Serializable {

	public static String REF = "UserDepartment";
	public static String PROP_USER = "User";
	public static String PROP_STATUS = "Status";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT = "Department";

	// constructors
	public BaseUserDepartment() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseUserDepartment(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.Users user;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="user_department_id"
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
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment() {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * 
	 * @param department
	 *            the department_id value
	 */
	public void setDepartment(jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}

	/**
	 * Return the value associated with the column: user_id
	 */
	public jkt.hms.masters.business.Users getUser() {
		return user;
	}

	/**
	 * Set the value related to the column: user_id
	 * 
	 * @param user
	 *            the user_id value
	 */
	public void setUser(jkt.hms.masters.business.Users user) {
		this.user = user;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.UserDepartment))
			return false;
		else {
			jkt.hms.masters.business.UserDepartment userDepartment = (jkt.hms.masters.business.UserDepartment) obj;
			if (null == this.getId() || null == userDepartment.getId())
				return false;
			else
				return (this.getId().equals(userDepartment.getId()));
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
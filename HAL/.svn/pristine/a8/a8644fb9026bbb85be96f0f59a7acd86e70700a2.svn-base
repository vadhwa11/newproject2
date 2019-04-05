package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the user_hospital_department
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="user_hospital_department"
 */

public abstract class BaseUserHospitalDepartment implements Serializable {

	public static String REF = "UserHospitalDepartment";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_USER = "User";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_ID = "Id";

	// constructors
	public BaseUserHospitalDepartment() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseUserHospitalDepartment(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Users user;
	private jkt.hms.masters.business.MasDepartment department;

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
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital() {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * 
	 * @param hospital
	 *            the hospital_id value
	 */
	public void setHospital(jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
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

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.UserHospitalDepartment))
			return false;
		else {
			jkt.hms.masters.business.UserHospitalDepartment userHospitalDepartment = (jkt.hms.masters.business.UserHospitalDepartment) obj;
			if (null == this.getId() || null == userHospitalDepartment.getId())
				return false;
			else
				return (this.getId().equals(userHospitalDepartment.getId()));
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
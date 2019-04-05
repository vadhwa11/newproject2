package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the user_hospital_role table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="user_hospital_role"
 */

public abstract class BaseUserHospitalRole implements Serializable {

	public static String REF = "UserHospitalRole";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_USER = "User";
	public static String PROP_ROLE = "Role";
	public static String PROP_ID = "Id";

	// constructors
	public BaseUserHospitalRole() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseUserHospitalRole(java.lang.Integer id) {
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
	private jkt.hms.masters.business.RoleMaster role;

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
	 * Return the value associated with the column: role_id
	 */
	public jkt.hms.masters.business.RoleMaster getRole() {
		return role;
	}

	/**
	 * Set the value related to the column: role_id
	 * 
	 * @param role
	 *            the role_id value
	 */
	public void setRole(jkt.hms.masters.business.RoleMaster role) {
		this.role = role;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.UserHospitalRole))
			return false;
		else {
			jkt.hms.masters.business.UserHospitalRole userHospitalRole = (jkt.hms.masters.business.UserHospitalRole) obj;
			if (null == this.getId() || null == userHospitalRole.getId())
				return false;
			else
				return (this.getId().equals(userHospitalRole.getId()));
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
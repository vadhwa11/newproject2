package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the role_master table. Do not
 * modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * 
 * @hibernate.class table="role_master"
 */

public abstract class BaseRoleMaster implements Serializable {

	public static String REF = "RoleMaster";
	public static String PROP_STATUS = "Status";
	public static String PROP_ROLE_NAME = "RoleName";
	public static String PROP_ID = "Id";

	// constructors
	public BaseRoleMaster() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseRoleMaster(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String roleName;
	private java.lang.String status;

	// collections
	private java.util.Set<jkt.hms.masters.business.UserHospitalRole> userHospitalRoles;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="role_id"
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
	 * Return the value associated with the column: role_name
	 */
	public java.lang.String getRoleName() {
		return roleName;
	}

	/**
	 * Set the value related to the column: role_name
	 * 
	 * @param roleName
	 *            the role_name value
	 */
	public void setRoleName(java.lang.String roleName) {
		this.roleName = roleName;
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
	 * Return the value associated with the column: UserHospitalRoles
	 */
	public java.util.Set<jkt.hms.masters.business.UserHospitalRole> getUserHospitalRoles() {
		return userHospitalRoles;
	}

	/**
	 * Set the value related to the column: UserHospitalRoles
	 * 
	 * @param userHospitalRoles
	 *            the UserHospitalRoles value
	 */
	public void setUserHospitalRoles(
			java.util.Set<jkt.hms.masters.business.UserHospitalRole> userHospitalRoles) {
		this.userHospitalRoles = userHospitalRoles;
	}

	public void addToUserHospitalRoles(
			jkt.hms.masters.business.UserHospitalRole userHospitalRole) {
		if (null == getUserHospitalRoles())
			setUserHospitalRoles(new java.util.TreeSet<jkt.hms.masters.business.UserHospitalRole>());
		getUserHospitalRoles().add(userHospitalRole);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.RoleMaster))
			return false;
		else {
			jkt.hms.masters.business.RoleMaster roleMaster = (jkt.hms.masters.business.RoleMaster) obj;
			if (null == this.getId() || null == roleMaster.getId())
				return false;
			else
				return (this.getId().equals(roleMaster.getId()));
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
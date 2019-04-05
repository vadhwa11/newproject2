package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * user_accessrights_hospital table. Do not modify this class because it will be
 * overwritten if the configuration file related to this class is modified.
 * 
 * @hibernate.class table="user_accessrights_hospital"
 */

public abstract class BaseUserAccessrightsHospital implements Serializable {

	public static String REF = "UserAccessrightsHospital";
	public static String PROP_ACCESS = "Access";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_USER = "User";
	public static String PROP_ID = "Id";

	// constructors
	public BaseUserAccessrightsHospital() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseUserAccessrightsHospital(java.lang.Integer id) {
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
	private jkt.hms.masters.business.AccessRights access;
	private jkt.hms.masters.business.Users user;

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
	 * Return the value associated with the column: access_id
	 */
	public jkt.hms.masters.business.AccessRights getAccess() {
		return access;
	}

	/**
	 * Set the value related to the column: access_id
	 * 
	 * @param access
	 *            the access_id value
	 */
	public void setAccess(jkt.hms.masters.business.AccessRights access) {
		this.access = access;
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
		if (!(obj instanceof jkt.hms.masters.business.UserAccessrightsHospital))
			return false;
		else {
			jkt.hms.masters.business.UserAccessrightsHospital userAccessrightsHospital = (jkt.hms.masters.business.UserAccessrightsHospital) obj;
			if (null == this.getId()
					|| null == userAccessrightsHospital.getId())
				return false;
			else
				return (this.getId().equals(userAccessrightsHospital.getId()));
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
package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * usergroup_accessrights_hospital table. Do not modify this class because it
 * will be overwritten if the configuration file related to this class is
 * modified.
 * 
 * @hibernate.class table="usergroup_accessrights_hospital"
 */

public abstract class BaseUsergroupAccessrightsHospital implements Serializable {

	public static String REF = "UsergroupAccessrightsHospital";
	public static String PROP_ACCESS = "Access";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ID = "Id";
	public static String PROP_GROUP = "Group";

	// constructors
	public BaseUsergroupAccessrightsHospital() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseUsergroupAccessrightsHospital(java.lang.Integer id) {
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
	private jkt.hms.masters.business.UserGroups group;

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
	 * Return the value associated with the column: group_id
	 */
	public jkt.hms.masters.business.UserGroups getGroup() {
		return group;
	}

	/**
	 * Set the value related to the column: group_id
	 * 
	 * @param group
	 *            the group_id value
	 */
	public void setGroup(jkt.hms.masters.business.UserGroups group) {
		this.group = group;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.UsergroupAccessrightsHospital))
			return false;
		else {
			jkt.hms.masters.business.UsergroupAccessrightsHospital usergroupAccessrightsHospital = (jkt.hms.masters.business.UsergroupAccessrightsHospital) obj;
			if (null == this.getId()
					|| null == usergroupAccessrightsHospital.getId())
				return false;
			else
				return (this.getId().equals(usergroupAccessrightsHospital
						.getId()));
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
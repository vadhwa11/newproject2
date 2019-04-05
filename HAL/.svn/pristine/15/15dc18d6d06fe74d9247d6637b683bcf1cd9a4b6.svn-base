package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the access_rights table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="access_rights"
 */

public abstract class BaseAccessRights implements Serializable {

	public static String REF = "AccessRights";
	public static String PROP_STATUS = "Status";
	public static String PROP_DESCRIPTION = "Description";
	public static String PROP_ID = "Id";

	// constructors
	public BaseAccessRights() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAccessRights(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String description;
	private java.lang.String status;

	// collections
	private java.util.Set<jkt.hms.masters.business.UsergroupAccessrightsHospital> usergroupAccessrightsHospitals;
	private java.util.Set<jkt.hms.masters.business.UserAccessrightsHospital> userAccessrightsHospitals;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="access_id"
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
	 * Return the value associated with the column: description
	 */
	public java.lang.String getDescription() {
		return description;
	}

	/**
	 * Set the value related to the column: description
	 * 
	 * @param description
	 *            the description value
	 */
	public void setDescription(java.lang.String description) {
		this.description = description;
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
	 * Return the value associated with the column:
	 * UsergroupAccessrightsHospitals
	 */
	public java.util.Set<jkt.hms.masters.business.UsergroupAccessrightsHospital> getUsergroupAccessrightsHospitals() {
		return usergroupAccessrightsHospitals;
	}

	/**
	 * Set the value related to the column: UsergroupAccessrightsHospitals
	 * 
	 * @param usergroupAccessrightsHospitals
	 *            the UsergroupAccessrightsHospitals value
	 */
	public void setUsergroupAccessrightsHospitals(
			java.util.Set<jkt.hms.masters.business.UsergroupAccessrightsHospital> usergroupAccessrightsHospitals) {
		this.usergroupAccessrightsHospitals = usergroupAccessrightsHospitals;
	}

	public void addToUsergroupAccessrightsHospitals(
			jkt.hms.masters.business.UsergroupAccessrightsHospital usergroupAccessrightsHospital) {
		if (null == getUsergroupAccessrightsHospitals())
			setUsergroupAccessrightsHospitals(new java.util.TreeSet<jkt.hms.masters.business.UsergroupAccessrightsHospital>());
		getUsergroupAccessrightsHospitals().add(usergroupAccessrightsHospital);
	}

	/**
	 * Return the value associated with the column: UserAccessrightsHospitals
	 */
	public java.util.Set<jkt.hms.masters.business.UserAccessrightsHospital> getUserAccessrightsHospitals() {
		return userAccessrightsHospitals;
	}

	/**
	 * Set the value related to the column: UserAccessrightsHospitals
	 * 
	 * @param userAccessrightsHospitals
	 *            the UserAccessrightsHospitals value
	 */
	public void setUserAccessrightsHospitals(
			java.util.Set<jkt.hms.masters.business.UserAccessrightsHospital> userAccessrightsHospitals) {
		this.userAccessrightsHospitals = userAccessrightsHospitals;
	}

	public void addToUserAccessrightsHospitals(
			jkt.hms.masters.business.UserAccessrightsHospital userAccessrightsHospital) {
		if (null == getUserAccessrightsHospitals())
			setUserAccessrightsHospitals(new java.util.TreeSet<jkt.hms.masters.business.UserAccessrightsHospital>());
		getUserAccessrightsHospitals().add(userAccessrightsHospital);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.AccessRights))
			return false;
		else {
			jkt.hms.masters.business.AccessRights accessRights = (jkt.hms.masters.business.AccessRights) obj;
			if (null == this.getId() || null == accessRights.getId())
				return false;
			else
				return (this.getId().equals(accessRights.getId()));
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
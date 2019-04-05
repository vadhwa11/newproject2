package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the user_button_rights table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="user_button_rights"
 */

public abstract class BaseUserButtonRights implements Serializable {

	public static String REF = "UserButtonRights";
	public static String PROP_USER = "User";
	public static String PROP_BUTTON = "Button";
	public static String PROP_EMP_GROUP = "EmpGroup";
	public static String PROP_ID = "Id";

	// constructors
	public BaseUserButtonRights() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseUserButtonRights(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// many to one
	private jkt.hms.masters.business.Users user;
	private jkt.hms.masters.business.EmpGroups empGroup;
	private jkt.hms.masters.business.MasButtonForm button;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="button_rights_id"
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
	 * Return the value associated with the column: emp_group_id
	 */
	public jkt.hms.masters.business.EmpGroups getEmpGroup() {
		return empGroup;
	}

	/**
	 * Set the value related to the column: emp_group_id
	 * 
	 * @param empGroup
	 *            the emp_group_id value
	 */
	public void setEmpGroup(jkt.hms.masters.business.EmpGroups empGroup) {
		this.empGroup = empGroup;
	}

	/**
	 * Return the value associated with the column: button_id
	 */
	public jkt.hms.masters.business.MasButtonForm getButton() {
		return button;
	}

	/**
	 * Set the value related to the column: button_id
	 * 
	 * @param button
	 *            the button_id value
	 */
	public void setButton(jkt.hms.masters.business.MasButtonForm button) {
		this.button = button;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.UserButtonRights))
			return false;
		else {
			jkt.hms.masters.business.UserButtonRights userButtonRights = (jkt.hms.masters.business.UserButtonRights) obj;
			if (null == this.getId() || null == userButtonRights.getId())
				return false;
			else
				return (this.getId().equals(userButtonRights.getId()));
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
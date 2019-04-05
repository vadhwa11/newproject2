package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_user_manager table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_user_manager"
 */

public abstract class BaseUserManager  implements Serializable {

	public static String REF = "UserManager";
	public static String PROP_MANAGERS = "managers";
	public static String PROP_USERS = "users";
	public static String PROP_ID = "Id";
	public static String PROP_EMP_ID = "EmpId";
	public static String PROP_MANAGER_ID = "ManagerId";


	// constructors
	public BaseUserManager () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseUserManager (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer empId;
	private java.lang.Integer managerId;

	// many to one
	private jkt.hms.masters.business.MasEmployee users;
	private jkt.hms.masters.business.MasEmployee managers;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="id"
     */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: emp_id
	 */
	public java.lang.Integer getEmpId () {
		return empId;
	}

	/**
	 * Set the value related to the column: emp_id
	 * @param empId the emp_id value
	 */
	public void setEmpId (java.lang.Integer empId) {
		this.empId = empId;
	}



	/**
	 * Return the value associated with the column: manager_id
	 */
	public java.lang.Integer getManagerId () {
		return managerId;
	}

	/**
	 * Set the value related to the column: manager_id
	 * @param managerId the manager_id value
	 */
	public void setManagerId (java.lang.Integer managerId) {
		this.managerId = managerId;
	}



	/**
	 * Return the value associated with the column: emp_id
	 */
	public jkt.hms.masters.business.MasEmployee getUsers () {
		return users;
	}

	/**
	 * Set the value related to the column: emp_id
	 * @param users the emp_id value
	 */
	public void setUsers (jkt.hms.masters.business.MasEmployee users) {
		this.users = users;
	}



	/**
	 * Return the value associated with the column: manager_id
	 */
	public jkt.hms.masters.business.MasEmployee getManagers () {
		return managers;
	}

	/**
	 * Set the value related to the column: manager_id
	 * @param managers the manager_id value
	 */
	public void setManagers (jkt.hms.masters.business.MasEmployee managers) {
		this.managers = managers;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.UserManager)) return false;
		else {
			jkt.hms.masters.business.UserManager userManager = (jkt.hms.masters.business.UserManager) obj;
			if (null == this.getId() || null == userManager.getId()) return false;
			else return (this.getId().equals(userManager.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}
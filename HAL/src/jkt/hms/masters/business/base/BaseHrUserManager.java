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

public abstract class BaseHrUserManager  implements Serializable {

	public static String REF = "HrUserManager";
	public static String PROP_EMP = "Emp";
	public static String PROP_ID = "Id";
	public static String PROP_MANAGER = "Manager";


	// constructors
	public BaseHrUserManager () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrUserManager (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// many to one
	private jkt.hms.masters.business.MasEmployee manager;
	private jkt.hms.masters.business.MasEmployee emp;



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
	 * Return the value associated with the column: manager_id
	 */
	public jkt.hms.masters.business.MasEmployee getManager () {
		return manager;
	}

	/**
	 * Set the value related to the column: manager_id
	 * @param manager the manager_id value
	 */
	public void setManager (jkt.hms.masters.business.MasEmployee manager) {
		this.manager = manager;
	}



	/**
	 * Return the value associated with the column: emp_id
	 */
	public jkt.hms.masters.business.MasEmployee getEmp () {
		return emp;
	}

	/**
	 * Set the value related to the column: emp_id
	 * @param emp the emp_id value
	 */
	public void setEmp (jkt.hms.masters.business.MasEmployee emp) {
		this.emp = emp;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HrUserManager)) return false;
		else {
			jkt.hms.masters.business.HrUserManager hrUserManager = (jkt.hms.masters.business.HrUserManager) obj;
			if (null == this.getId() || null == hrUserManager.getId()) return false;
			else return (this.getId().equals(hrUserManager.getId()));
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
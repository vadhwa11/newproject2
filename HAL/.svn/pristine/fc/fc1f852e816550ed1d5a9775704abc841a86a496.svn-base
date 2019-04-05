package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the complaint_department table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="complaint_department"
 */

public abstract class BaseComplaintDepartment  implements Serializable {

	public static String REF = "ComplaintDepartment";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_ID = "Id";


	// constructors
	public BaseComplaintDepartment () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseComplaintDepartment (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// many to one
	private jkt.hms.masters.business.MasDepartment department;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="complaint_dept_id"
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
	 * Return the value associated with the column: department_type_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment () {
		return department;
	}

	/**
	 * Set the value related to the column: department_type_id
	 * @param department the department_type_id value
	 */
	public void setDepartment (jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.ComplaintDepartment)) return false;
		else {
			jkt.hms.masters.business.ComplaintDepartment complaintDepartment = (jkt.hms.masters.business.ComplaintDepartment) obj;
			if (null == this.getId() || null == complaintDepartment.getId()) return false;
			else return (this.getId().equals(complaintDepartment.getId()));
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
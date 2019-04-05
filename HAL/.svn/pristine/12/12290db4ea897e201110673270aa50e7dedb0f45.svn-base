package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the family_details table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="family_details"
 */

public abstract class BaseFamilyDetails implements Serializable {

	public static String REF = "FamilyDetails";
	public static String PROP_AGE = "Age";
	public static String PROP_DEPENDENT_POR_NO = "DependentPorNo";
	public static String PROP_SELECT_FAMILY = "SelectFamily";
	public static String PROP_LEAVE_APPLICATION = "LeaveApplication";
	public static String PROP_ID = "Id";
	public static String PROP_DOB = "Dob";

	// constructors
	public BaseFamilyDetails() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFamilyDetails(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String selectFamily;
	private java.util.Date dob;
	private java.lang.Integer age;
	private java.lang.String dependentPorNo;
	private java.lang.Integer leaveApplication;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="family_id"
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
	 * Return the value associated with the column: select_family
	 */
	public java.lang.String getSelectFamily() {
		return selectFamily;
	}

	/**
	 * Set the value related to the column: select_family
	 * 
	 * @param selectFamily
	 *            the select_family value
	 */
	public void setSelectFamily(java.lang.String selectFamily) {
		this.selectFamily = selectFamily;
	}

	/**
	 * Return the value associated with the column: dob
	 */
	public java.util.Date getDob() {
		return dob;
	}

	/**
	 * Set the value related to the column: dob
	 * 
	 * @param dob
	 *            the dob value
	 */
	public void setDob(java.util.Date dob) {
		this.dob = dob;
	}

	/**
	 * Return the value associated with the column: age
	 */
	public java.lang.Integer getAge() {
		return age;
	}

	/**
	 * Set the value related to the column: age
	 * 
	 * @param age
	 *            the age value
	 */
	public void setAge(java.lang.Integer age) {
		this.age = age;
	}

	/**
	 * Return the value associated with the column: dependent_por_no
	 */
	public java.lang.String getDependentPorNo() {
		return dependentPorNo;
	}

	/**
	 * Set the value related to the column: dependent_por_no
	 * 
	 * @param dependentPorNo
	 *            the dependent_por_no value
	 */
	public void setDependentPorNo(java.lang.String dependentPorNo) {
		this.dependentPorNo = dependentPorNo;
	}

	/**
	 * Return the value associated with the column: leave_application_id
	 */
	public java.lang.Integer getLeaveApplication() {
		return leaveApplication;
	}

	/**
	 * Set the value related to the column: leave_application_id
	 * 
	 * @param leaveApplication
	 *            the leave_application_id value
	 */
	public void setLeaveApplication(java.lang.Integer leaveApplication) {
		this.leaveApplication = leaveApplication;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.FamilyDetails))
			return false;
		else {
			jkt.hms.masters.business.FamilyDetails familyDetails = (jkt.hms.masters.business.FamilyDetails) obj;
			if (null == this.getId() || null == familyDetails.getId())
				return false;
			else
				return (this.getId().equals(familyDetails.getId()));
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
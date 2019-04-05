package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_employee_dependent table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_employee_dependent"
 */

public abstract class BaseMasEmployeeDependent  implements Serializable {

	public static String REF = "MasEmployeeDependent";
	public static String PROP_DATE_OF_BIRTH = "DateOfBirth";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_EMPLOYEE_DEPENDENT_L_NAME = "EmployeeDependentLName";
	public static String PROP_BLOOD_GROUP = "BloodGroup";
	public static String PROP_ADDRESS = "Address";
	public static String PROP_AUTHORITY = "Authority";
	public static String PROP_EMPLOYEE_DEPENDENT_CODE = "EmployeeDependentCode";
	public static String PROP_DEPENDENCY_REMOVAL_DATE = "DependencyRemovalDate";
	public static String PROP_GENDER = "Gender";
	public static String PROP_EMPLOYEE_DEPENDENT_F_NAME = "EmployeeDependentFName";
	public static String PROP_CONTACT_NO = "ContactNo";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_RELATION = "Relation";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_EMPLOYEE_DEPENDENT_M_NAME = "EmployeeDependentMName";
	public static String PROP_DATE_OF_DEPENDENCY = "DateOfDependency";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_EPH_ISN = "EphIsn";


	// constructors
	public BaseMasEmployeeDependent () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasEmployeeDependent (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String employeeDependentCode;
	private java.lang.String employeeDependentFName;
	private java.lang.String employeeDependentMName;
	private java.lang.String employeeDependentLName;
	private java.util.Date dateOfBirth;
	private java.lang.String address;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.util.Date dateOfDependency;
	private java.util.Date dependencyRemovalDate;
	private java.lang.String authority;
	private java.lang.String contactNo;
	private java.lang.Integer ephIsn;

	// many to one
	private jkt.hms.masters.business.MasAdministrativeSex gender;
	private jkt.hms.masters.business.MasRelation relation;
	private jkt.hms.masters.business.MasEmployee employee;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasBloodGroup bloodGroup;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="employee_dependent_id"
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
	 * Return the value associated with the column: employee_dependent_code
	 */
	public java.lang.String getEmployeeDependentCode () {
		return employeeDependentCode;
	}

	/**
	 * Set the value related to the column: employee_dependent_code
	 * @param employeeDependentCode the employee_dependent_code value
	 */
	public void setEmployeeDependentCode (java.lang.String employeeDependentCode) {
		this.employeeDependentCode = employeeDependentCode;
	}



	/**
	 * Return the value associated with the column: EMPLOYEE_DEPENDENT_f_NAME
	 */
	public java.lang.String getEmployeeDependentFName () {
		return employeeDependentFName;
	}

	/**
	 * Set the value related to the column: EMPLOYEE_DEPENDENT_f_NAME
	 * @param employeeDependentFName the EMPLOYEE_DEPENDENT_f_NAME value
	 */
	public void setEmployeeDependentFName (java.lang.String employeeDependentFName) {
		this.employeeDependentFName = employeeDependentFName;
	}



	/**
	 * Return the value associated with the column: EMPLOYEE_DEPENDENT_m_NAME
	 */
	public java.lang.String getEmployeeDependentMName () {
		return employeeDependentMName;
	}

	/**
	 * Set the value related to the column: EMPLOYEE_DEPENDENT_m_NAME
	 * @param employeeDependentMName the EMPLOYEE_DEPENDENT_m_NAME value
	 */
	public void setEmployeeDependentMName (java.lang.String employeeDependentMName) {
		this.employeeDependentMName = employeeDependentMName;
	}



	/**
	 * Return the value associated with the column: EMPLOYEE_DEPENDENT_l_NAME
	 */
	public java.lang.String getEmployeeDependentLName () {
		return employeeDependentLName;
	}

	/**
	 * Set the value related to the column: EMPLOYEE_DEPENDENT_l_NAME
	 * @param employeeDependentLName the EMPLOYEE_DEPENDENT_l_NAME value
	 */
	public void setEmployeeDependentLName (java.lang.String employeeDependentLName) {
		this.employeeDependentLName = employeeDependentLName;
	}



	/**
	 * Return the value associated with the column: date_of_birth
	 */
	public java.util.Date getDateOfBirth () {
		return dateOfBirth;
	}

	/**
	 * Set the value related to the column: date_of_birth
	 * @param dateOfBirth the date_of_birth value
	 */
	public void setDateOfBirth (java.util.Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}



	/**
	 * Return the value associated with the column: address
	 */
	public java.lang.String getAddress () {
		return address;
	}

	/**
	 * Set the value related to the column: address
	 * @param address the address value
	 */
	public void setAddress (java.lang.String address) {
		this.address = address;
	}



	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * @param status the status value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
	}



	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.String getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
	}



	/**
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate () {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * @param lastChgDate the last_chg_date value
	 */
	public void setLastChgDate (java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}



	/**
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime () {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * @param lastChgTime the last_chg_time value
	 */
	public void setLastChgTime (java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}



	/**
	 * Return the value associated with the column: date_of_dependency
	 */
	public java.util.Date getDateOfDependency () {
		return dateOfDependency;
	}

	/**
	 * Set the value related to the column: date_of_dependency
	 * @param dateOfDependency the date_of_dependency value
	 */
	public void setDateOfDependency (java.util.Date dateOfDependency) {
		this.dateOfDependency = dateOfDependency;
	}



	/**
	 * Return the value associated with the column: dependency_removal_date
	 */
	public java.util.Date getDependencyRemovalDate () {
		return dependencyRemovalDate;
	}

	/**
	 * Set the value related to the column: dependency_removal_date
	 * @param dependencyRemovalDate the dependency_removal_date value
	 */
	public void setDependencyRemovalDate (java.util.Date dependencyRemovalDate) {
		this.dependencyRemovalDate = dependencyRemovalDate;
	}



	/**
	 * Return the value associated with the column: authority
	 */
	public java.lang.String getAuthority () {
		return authority;
	}

	/**
	 * Set the value related to the column: authority
	 * @param authority the authority value
	 */
	public void setAuthority (java.lang.String authority) {
		this.authority = authority;
	}



	/**
	 * Return the value associated with the column: contact_no
	 */
	public java.lang.String getContactNo () {
		return contactNo;
	}

	/**
	 * Set the value related to the column: contact_no
	 * @param contactNo the contact_no value
	 */
	public void setContactNo (java.lang.String contactNo) {
		this.contactNo = contactNo;
	}



	/**
	 * Return the value associated with the column: EPH_ISN
	 */
	public java.lang.Integer getEphIsn () {
		return ephIsn;
	}

	/**
	 * Set the value related to the column: EPH_ISN
	 * @param ephIsn the EPH_ISN value
	 */
	public void setEphIsn (java.lang.Integer ephIsn) {
		this.ephIsn = ephIsn;
	}



	/**
	 * Return the value associated with the column: gender_id
	 */
	public jkt.hms.masters.business.MasAdministrativeSex getGender () {
		return gender;
	}

	/**
	 * Set the value related to the column: gender_id
	 * @param gender the gender_id value
	 */
	public void setGender (jkt.hms.masters.business.MasAdministrativeSex gender) {
		this.gender = gender;
	}



	/**
	 * Return the value associated with the column: relation_id
	 */
	public jkt.hms.masters.business.MasRelation getRelation () {
		return relation;
	}

	/**
	 * Set the value related to the column: relation_id
	 * @param relation the relation_id value
	 */
	public void setRelation (jkt.hms.masters.business.MasRelation relation) {
		this.relation = relation;
	}



	/**
	 * Return the value associated with the column: employee_id
	 */
	public jkt.hms.masters.business.MasEmployee getEmployee () {
		return employee;
	}

	/**
	 * Set the value related to the column: employee_id
	 * @param employee the employee_id value
	 */
	public void setEmployee (jkt.hms.masters.business.MasEmployee employee) {
		this.employee = employee;
	}



	/**
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital () {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * @param hospital the hospital_id value
	 */
	public void setHospital (jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}



	/**
	 * Return the value associated with the column: blood_group_id
	 */
	public jkt.hms.masters.business.MasBloodGroup getBloodGroup () {
		return bloodGroup;
	}

	/**
	 * Set the value related to the column: blood_group_id
	 * @param bloodGroup the blood_group_id value
	 */
	public void setBloodGroup (jkt.hms.masters.business.MasBloodGroup bloodGroup) {
		this.bloodGroup = bloodGroup;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasEmployeeDependent)) return false;
		else {
			jkt.hms.masters.business.MasEmployeeDependent masEmployeeDependent = (jkt.hms.masters.business.MasEmployeeDependent) obj;
			if (null == this.getId() || null == masEmployeeDependent.getId()) return false;
			else return (this.getId().equals(masEmployeeDependent.getId()));
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
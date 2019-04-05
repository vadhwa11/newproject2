package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the department table. Do not
 * modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * 
 * @hibernate.class table="department"
 */

public abstract class BaseDepartment implements Serializable {

	public static String REF = "Department";
	public static String PROP_STATUS_ID = "StatusId";
	public static String PROP_AD_EDIT_DATE_TIME = "AdEditDateTime";
	public static String PROP_DEPARTMENT_TYPE_ID = "DepartmentTypeId";
	public static String PROP_DEPARTMENT_DESCRIPTION = "DepartmentDescription";
	public static String PROP_ADD_EDIT_BY_ID = "AddEditById";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_COST_CENTER_ID = "CostCenterId";
	public static String PROP_DEPARTMENT_CODE = "DepartmentCode";
	public static String PROP_ID = "Id";

	// constructors
	public BaseDepartment() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDepartment(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String departmentCode;
	private java.lang.String departmentDescription;
	private java.lang.Integer hospitalId;
	private java.lang.Integer departmentTypeId;
	private java.lang.Integer costCenterId;
	private java.lang.Integer addEditById;
	private java.util.Date adEditDateTime;
	private java.lang.Integer statusId;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="department_id"
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
	 * Return the value associated with the column: department_code
	 */
	public java.lang.String getDepartmentCode() {
		return departmentCode;
	}

	/**
	 * Set the value related to the column: department_code
	 * 
	 * @param departmentCode
	 *            the department_code value
	 */
	public void setDepartmentCode(java.lang.String departmentCode) {
		this.departmentCode = departmentCode;
	}

	/**
	 * Return the value associated with the column: department_description
	 */
	public java.lang.String getDepartmentDescription() {
		return departmentDescription;
	}

	/**
	 * Set the value related to the column: department_description
	 * 
	 * @param departmentDescription
	 *            the department_description value
	 */
	public void setDepartmentDescription(java.lang.String departmentDescription) {
		this.departmentDescription = departmentDescription;
	}

	/**
	 * Return the value associated with the column: hospital_id
	 */
	public java.lang.Integer getHospitalId() {
		return hospitalId;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * 
	 * @param hospitalId
	 *            the hospital_id value
	 */
	public void setHospitalId(java.lang.Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	/**
	 * Return the value associated with the column: department_type_id
	 */
	public java.lang.Integer getDepartmentTypeId() {
		return departmentTypeId;
	}

	/**
	 * Set the value related to the column: department_type_id
	 * 
	 * @param departmentTypeId
	 *            the department_type_id value
	 */
	public void setDepartmentTypeId(java.lang.Integer departmentTypeId) {
		this.departmentTypeId = departmentTypeId;
	}

	/**
	 * Return the value associated with the column: cost_center_id
	 */
	public java.lang.Integer getCostCenterId() {
		return costCenterId;
	}

	/**
	 * Set the value related to the column: cost_center_id
	 * 
	 * @param costCenterId
	 *            the cost_center_id value
	 */
	public void setCostCenterId(java.lang.Integer costCenterId) {
		this.costCenterId = costCenterId;
	}

	/**
	 * Return the value associated with the column: add_edit_by_id
	 */
	public java.lang.Integer getAddEditById() {
		return addEditById;
	}

	/**
	 * Set the value related to the column: add_edit_by_id
	 * 
	 * @param addEditById
	 *            the add_edit_by_id value
	 */
	public void setAddEditById(java.lang.Integer addEditById) {
		this.addEditById = addEditById;
	}

	/**
	 * Return the value associated with the column: ad_edit_date_time
	 */
	public java.util.Date getAdEditDateTime() {
		return adEditDateTime;
	}

	/**
	 * Set the value related to the column: ad_edit_date_time
	 * 
	 * @param adEditDateTime
	 *            the ad_edit_date_time value
	 */
	public void setAdEditDateTime(java.util.Date adEditDateTime) {
		this.adEditDateTime = adEditDateTime;
	}

	/**
	 * Return the value associated with the column: status_id
	 */
	public java.lang.Integer getStatusId() {
		return statusId;
	}

	/**
	 * Set the value related to the column: status_id
	 * 
	 * @param statusId
	 *            the status_id value
	 */
	public void setStatusId(java.lang.Integer statusId) {
		this.statusId = statusId;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.Department))
			return false;
		else {
			jkt.hms.masters.business.Department department = (jkt.hms.masters.business.Department) obj;
			if (null == this.getId() || null == department.getId())
				return false;
			else
				return (this.getId().equals(department.getId()));
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
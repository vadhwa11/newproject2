package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the code_type_master table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="code_type_master"
 */

public abstract class BaseCodeTypeMaster implements Serializable {

	public static String REF = "CodeTypeMaster";
	public static String PROP_VARIABLE_TYPE = "VariableType";
	public static String PROP_CODE_TYPE_MASTER_CODE = "CodeTypeMasterCode";
	public static String PROP_CODE_TYPE_MASTER_DESCRIPTION = "CodeTypeMasterDescription";
	public static String PROP_ADD_EDIT_DATE_TIME = "AddEditDateTime";
	public static String PROP_ADD_EDIT_BY_ID = "AddEditById";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_ID = "Id";

	// constructors
	public BaseCodeTypeMaster() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCodeTypeMaster(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer hospitalId;
	private java.lang.String codeTypeMasterCode;
	private java.lang.String codeTypeMasterDescription;
	private java.lang.String variableType;
	private java.lang.Integer addEditById;
	private java.util.Date addEditDateTime;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="code_type_master_id"
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
	 * Return the value associated with the column: code_type_master_code
	 */
	public java.lang.String getCodeTypeMasterCode() {
		return codeTypeMasterCode;
	}

	/**
	 * Set the value related to the column: code_type_master_code
	 * 
	 * @param codeTypeMasterCode
	 *            the code_type_master_code value
	 */
	public void setCodeTypeMasterCode(java.lang.String codeTypeMasterCode) {
		this.codeTypeMasterCode = codeTypeMasterCode;
	}

	/**
	 * Return the value associated with the column: code_type_master_description
	 */
	public java.lang.String getCodeTypeMasterDescription() {
		return codeTypeMasterDescription;
	}

	/**
	 * Set the value related to the column: code_type_master_description
	 * 
	 * @param codeTypeMasterDescription
	 *            the code_type_master_description value
	 */
	public void setCodeTypeMasterDescription(
			java.lang.String codeTypeMasterDescription) {
		this.codeTypeMasterDescription = codeTypeMasterDescription;
	}

	/**
	 * Return the value associated with the column: variable_type
	 */
	public java.lang.String getVariableType() {
		return variableType;
	}

	/**
	 * Set the value related to the column: variable_type
	 * 
	 * @param variableType
	 *            the variable_type value
	 */
	public void setVariableType(java.lang.String variableType) {
		this.variableType = variableType;
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
	 * Return the value associated with the column: add_edit_date_time
	 */
	public java.util.Date getAddEditDateTime() {
		return addEditDateTime;
	}

	/**
	 * Set the value related to the column: add_edit_date_time
	 * 
	 * @param addEditDateTime
	 *            the add_edit_date_time value
	 */
	public void setAddEditDateTime(java.util.Date addEditDateTime) {
		this.addEditDateTime = addEditDateTime;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.CodeTypeMaster))
			return false;
		else {
			jkt.hms.masters.business.CodeTypeMaster codeTypeMaster = (jkt.hms.masters.business.CodeTypeMaster) obj;
			if (null == this.getId() || null == codeTypeMaster.getId())
				return false;
			else
				return (this.getId().equals(codeTypeMaster.getId()));
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
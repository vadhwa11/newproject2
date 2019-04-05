package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the charge_type table. Do not
 * modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * 
 * @hibernate.class table="charge_type"
 */

public abstract class BaseChargeType implements Serializable {

	public static String REF = "ChargeType";
	public static String PROP_CHARGE_TYPE_DESCRIPTION = "ChargeTypeDescription";
	public static String PROP_CHARGE_TYPE_CODE = "ChargeTypeCode";
	public static String PROP_STATUS_ID = "StatusId";
	public static String PROP_ADD_EDIT_DATE_TIME = "AddEditDateTime";
	public static String PROP_ADD_EDIT_BY_ID = "AddEditById";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_ID = "Id";

	// constructors
	public BaseChargeType() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseChargeType(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String chargeTypeCode;
	private java.lang.String chargeTypeDescription;
	private java.lang.Integer hospitalId;
	private java.lang.Integer addEditById;
	private java.util.Date addEditDateTime;
	private java.lang.Integer statusId;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="charge_type_id"
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
	 * Return the value associated with the column: charge_type_code
	 */
	public java.lang.String getChargeTypeCode() {
		return chargeTypeCode;
	}

	/**
	 * Set the value related to the column: charge_type_code
	 * 
	 * @param chargeTypeCode
	 *            the charge_type_code value
	 */
	public void setChargeTypeCode(java.lang.String chargeTypeCode) {
		this.chargeTypeCode = chargeTypeCode;
	}

	/**
	 * Return the value associated with the column: charge_type_description
	 */
	public java.lang.String getChargeTypeDescription() {
		return chargeTypeDescription;
	}

	/**
	 * Set the value related to the column: charge_type_description
	 * 
	 * @param chargeTypeDescription
	 *            the charge_type_description value
	 */
	public void setChargeTypeDescription(java.lang.String chargeTypeDescription) {
		this.chargeTypeDescription = chargeTypeDescription;
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
		if (!(obj instanceof jkt.hms.masters.business.ChargeType))
			return false;
		else {
			jkt.hms.masters.business.ChargeType chargeType = (jkt.hms.masters.business.ChargeType) obj;
			if (null == this.getId() || null == chargeType.getId())
				return false;
			else
				return (this.getId().equals(chargeType.getId()));
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
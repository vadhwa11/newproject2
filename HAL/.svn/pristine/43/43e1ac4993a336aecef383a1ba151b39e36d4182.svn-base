package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the sub_charge table. Do not
 * modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * 
 * @hibernate.class table="sub_charge"
 */

public abstract class BaseSubCharge implements Serializable {

	public static String REF = "SubCharge";
	public static String PROP_MAIN_CHARGE_ID = "MainChargeId";
	public static String PROP_SUB_CHARGE_CODE = "SubChargeCode";
	public static String PROP_STATUS_ID = "StatusId";
	public static String PROP_ADD_EDIT_DATE_TIME = "AddEditDateTime";
	public static String PROP_ADD_EDIT_BY_ID = "AddEditById";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_SUB_CHARGE_DESCRIPTION = "SubChargeDescription";
	public static String PROP_ID = "Id";

	// constructors
	public BaseSubCharge() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSubCharge(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String subChargeCode;
	private java.lang.String subChargeDescription;
	private java.lang.Integer mainChargeId;
	private java.lang.Integer hospitalId;
	private java.lang.Integer addEditById;
	private java.util.Date addEditDateTime;
	private java.lang.Integer statusId;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="sub_charge_id"
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
	 * Return the value associated with the column: sub_charge_code
	 */
	public java.lang.String getSubChargeCode() {
		return subChargeCode;
	}

	/**
	 * Set the value related to the column: sub_charge_code
	 * 
	 * @param subChargeCode
	 *            the sub_charge_code value
	 */
	public void setSubChargeCode(java.lang.String subChargeCode) {
		this.subChargeCode = subChargeCode;
	}

	/**
	 * Return the value associated with the column: sub_charge_description
	 */
	public java.lang.String getSubChargeDescription() {
		return subChargeDescription;
	}

	/**
	 * Set the value related to the column: sub_charge_description
	 * 
	 * @param subChargeDescription
	 *            the sub_charge_description value
	 */
	public void setSubChargeDescription(java.lang.String subChargeDescription) {
		this.subChargeDescription = subChargeDescription;
	}

	/**
	 * Return the value associated with the column: main_charge_id
	 */
	public java.lang.Integer getMainChargeId() {
		return mainChargeId;
	}

	/**
	 * Set the value related to the column: main_charge_id
	 * 
	 * @param mainChargeId
	 *            the main_charge_id value
	 */
	public void setMainChargeId(java.lang.Integer mainChargeId) {
		this.mainChargeId = mainChargeId;
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
		if (!(obj instanceof jkt.hms.masters.business.SubCharge))
			return false;
		else {
			jkt.hms.masters.business.SubCharge subCharge = (jkt.hms.masters.business.SubCharge) obj;
			if (null == this.getId() || null == subCharge.getId())
				return false;
			else
				return (this.getId().equals(subCharge.getId()));
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
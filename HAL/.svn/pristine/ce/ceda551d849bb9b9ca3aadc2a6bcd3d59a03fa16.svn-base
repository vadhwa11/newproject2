package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the bed table. Do not modify
 * this class because it will be overwritten if the configuration file related
 * to this class is modified.
 * 
 * @hibernate.class table="bed"
 */

public abstract class BaseBed implements Serializable {

	public static String REF = "Bed";
	public static String PROP_STATUS_ID = "StatusId";
	public static String PROP_ADD_EDIT_DATE_TIME = "AddEditDateTime";
	public static String PROP_ADD_EDIT_BY_ID = "AddEditById";
	public static String PROP_CHARGE_CODE_ID = "ChargeCodeId";
	public static String PROP_DEPARTMENT_ID = "DepartmentId";
	public static String PROP_BED_NO = "BedNo";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_ROOM_ID = "RoomId";
	public static String PROP_ID = "Id";

	// constructors
	public BaseBed() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBed(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String bedNo;
	private java.lang.Integer roomId;
	private java.lang.Integer departmentId;
	private java.lang.Integer hospitalId;
	private java.lang.Integer chargeCodeId;
	private java.lang.Integer addEditById;
	private java.util.Date addEditDateTime;
	private java.lang.Integer statusId;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="bed_id"
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
	 * Return the value associated with the column: bed_no
	 */
	public java.lang.String getBedNo() {
		return bedNo;
	}

	/**
	 * Set the value related to the column: bed_no
	 * 
	 * @param bedNo
	 *            the bed_no value
	 */
	public void setBedNo(java.lang.String bedNo) {
		this.bedNo = bedNo;
	}

	/**
	 * Return the value associated with the column: room_id
	 */
	public java.lang.Integer getRoomId() {
		return roomId;
	}

	/**
	 * Set the value related to the column: room_id
	 * 
	 * @param roomId
	 *            the room_id value
	 */
	public void setRoomId(java.lang.Integer roomId) {
		this.roomId = roomId;
	}

	/**
	 * Return the value associated with the column: department_id
	 */
	public java.lang.Integer getDepartmentId() {
		return departmentId;
	}

	/**
	 * Set the value related to the column: department_id
	 * 
	 * @param departmentId
	 *            the department_id value
	 */
	public void setDepartmentId(java.lang.Integer departmentId) {
		this.departmentId = departmentId;
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
	 * Return the value associated with the column: charge_code_id
	 */
	public java.lang.Integer getChargeCodeId() {
		return chargeCodeId;
	}

	/**
	 * Set the value related to the column: charge_code_id
	 * 
	 * @param chargeCodeId
	 *            the charge_code_id value
	 */
	public void setChargeCodeId(java.lang.Integer chargeCodeId) {
		this.chargeCodeId = chargeCodeId;
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
		if (!(obj instanceof jkt.hms.masters.business.Bed))
			return false;
		else {
			jkt.hms.masters.business.Bed bed = (jkt.hms.masters.business.Bed) obj;
			if (null == this.getId() || null == bed.getId())
				return false;
			else
				return (this.getId().equals(bed.getId()));
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
package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hes_equipment_assessories table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hes_equipment_assessories"
 */

public abstract class BaseHesEquipmentAssessories  implements Serializable {

	public static String REF = "HesEquipmentAssessories";
	public static String PROP_WARRANTY_END_DATE = "WarrantyEndDate";
	public static String PROP_EQUIPMENT = "Equipment";
	public static String PROP_QUANTITY = "Quantity";
	public static String PROP_MODEL_NO = "ModelNo";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ITEM = "Item";
	public static String PROP_ASSESSORY_NAME = "AssessoryName";
	public static String PROP_WARRANTY_START_DATE = "WarrantyStartDate";
	public static String PROP_SERIAL_NO = "SerialNo";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseHesEquipmentAssessories () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHesEquipmentAssessories (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseHesEquipmentAssessories (
		java.lang.Integer id,
		jkt.hms.masters.business.HesEquipmentMaster equipment) {

		this.setId(id);
		this.setEquipment(equipment);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String assessoryName;
	private java.lang.String serialNo;
	private java.lang.Integer quantity;
	private java.lang.String remarks;
	private java.lang.String status;
	private java.lang.String modelNo;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.util.Date warrantyStartDate;
	private java.util.Date warrantyEndDate;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasStoreItem item;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.HesEquipmentMaster equipment;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="assessory_id"
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
	 * Return the value associated with the column: assessory_name
	 */
	public java.lang.String getAssessoryName () {
		return assessoryName;
	}

	/**
	 * Set the value related to the column: assessory_name
	 * @param assessoryName the assessory_name value
	 */
	public void setAssessoryName (java.lang.String assessoryName) {
		this.assessoryName = assessoryName;
	}



	/**
	 * Return the value associated with the column: serial_no
	 */
	public java.lang.String getSerialNo () {
		return serialNo;
	}

	/**
	 * Set the value related to the column: serial_no
	 * @param serialNo the serial_no value
	 */
	public void setSerialNo (java.lang.String serialNo) {
		this.serialNo = serialNo;
	}



	/**
	 * Return the value associated with the column: quantity
	 */
	public java.lang.Integer getQuantity () {
		return quantity;
	}

	/**
	 * Set the value related to the column: quantity
	 * @param quantity the quantity value
	 */
	public void setQuantity (java.lang.Integer quantity) {
		this.quantity = quantity;
	}



	/**
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * @param remarks the remarks value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
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
	 * Return the value associated with the column: model_no
	 */
	public java.lang.String getModelNo () {
		return modelNo;
	}

	/**
	 * Set the value related to the column: model_no
	 * @param modelNo the model_no value
	 */
	public void setModelNo (java.lang.String modelNo) {
		this.modelNo = modelNo;
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
	 * Return the value associated with the column: warranty_start_date
	 */
	public java.util.Date getWarrantyStartDate () {
		return warrantyStartDate;
	}

	/**
	 * Set the value related to the column: warranty_start_date
	 * @param warrantyStartDate the warranty_start_date value
	 */
	public void setWarrantyStartDate (java.util.Date warrantyStartDate) {
		this.warrantyStartDate = warrantyStartDate;
	}



	/**
	 * Return the value associated with the column: warranty_end_date
	 */
	public java.util.Date getWarrantyEndDate () {
		return warrantyEndDate;
	}

	/**
	 * Set the value related to the column: warranty_end_date
	 * @param warrantyEndDate the warranty_end_date value
	 */
	public void setWarrantyEndDate (java.util.Date warrantyEndDate) {
		this.warrantyEndDate = warrantyEndDate;
	}



	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public jkt.hms.masters.business.Users getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (jkt.hms.masters.business.Users lastChgBy) {
		this.lastChgBy = lastChgBy;
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
	 * Return the value associated with the column: item_id
	 */
	public jkt.hms.masters.business.MasStoreItem getItem () {
		return item;
	}

	/**
	 * Set the value related to the column: item_id
	 * @param item the item_id value
	 */
	public void setItem (jkt.hms.masters.business.MasStoreItem item) {
		this.item = item;
	}



	/**
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment () {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * @param department the department_id value
	 */
	public void setDepartment (jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}



	/**
	 * Return the value associated with the column: equipment_id
	 */
	public jkt.hms.masters.business.HesEquipmentMaster getEquipment () {
		return equipment;
	}

	/**
	 * Set the value related to the column: equipment_id
	 * @param equipment the equipment_id value
	 */
	public void setEquipment (jkt.hms.masters.business.HesEquipmentMaster equipment) {
		this.equipment = equipment;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HesEquipmentAssessories)) return false;
		else {
			jkt.hms.masters.business.HesEquipmentAssessories hesEquipmentAssessories = (jkt.hms.masters.business.HesEquipmentAssessories) obj;
			if (null == this.getId() || null == hesEquipmentAssessories.getId()) return false;
			else return (this.getId().equals(hesEquipmentAssessories.getId()));
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
package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the item_group table. Do not
 * modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * 
 * @hibernate.class table="item_group"
 */

public abstract class BaseItemGroup implements Serializable {

	public static String REF = "ItemGroup";
	public static String PROP_STATUS_ID = "StatusId";
	public static String PROP_ITEM_GROUP_DESCRIPTION = "ItemGroupDescription";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_ITEM_TYPE_CODE = "ItemTypeCode";
	public static String PROP_LAST_CHGD_DATETIME = "LastChgdDatetime";
	public static String PROP_ITEM_GROUP_CODE = "ItemGroupCode";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHGD_BY = "LastChgdBy";

	// constructors
	public BaseItemGroup() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseItemGroup(java.lang.Integer id) {
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
	private java.lang.String itemGroupCode;
	private java.lang.String itemGroupDescription;
	private java.lang.String itemTypeCode;
	private java.lang.String lastChgdBy;
	private java.util.Date lastChgdDatetime;
	private java.lang.Integer statusId;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="item_group_id"
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
	 * Return the value associated with the column: item_group_code
	 */
	public java.lang.String getItemGroupCode() {
		return itemGroupCode;
	}

	/**
	 * Set the value related to the column: item_group_code
	 * 
	 * @param itemGroupCode
	 *            the item_group_code value
	 */
	public void setItemGroupCode(java.lang.String itemGroupCode) {
		this.itemGroupCode = itemGroupCode;
	}

	/**
	 * Return the value associated with the column: item_group_description
	 */
	public java.lang.String getItemGroupDescription() {
		return itemGroupDescription;
	}

	/**
	 * Set the value related to the column: item_group_description
	 * 
	 * @param itemGroupDescription
	 *            the item_group_description value
	 */
	public void setItemGroupDescription(java.lang.String itemGroupDescription) {
		this.itemGroupDescription = itemGroupDescription;
	}

	/**
	 * Return the value associated with the column: item_type_code
	 */
	public java.lang.String getItemTypeCode() {
		return itemTypeCode;
	}

	/**
	 * Set the value related to the column: item_type_code
	 * 
	 * @param itemTypeCode
	 *            the item_type_code value
	 */
	public void setItemTypeCode(java.lang.String itemTypeCode) {
		this.itemTypeCode = itemTypeCode;
	}

	/**
	 * Return the value associated with the column: last_chgd_by
	 */
	public java.lang.String getLastChgdBy() {
		return lastChgdBy;
	}

	/**
	 * Set the value related to the column: last_chgd_by
	 * 
	 * @param lastChgdBy
	 *            the last_chgd_by value
	 */
	public void setLastChgdBy(java.lang.String lastChgdBy) {
		this.lastChgdBy = lastChgdBy;
	}

	/**
	 * Return the value associated with the column: last_chgd_datetime
	 */
	public java.util.Date getLastChgdDatetime() {
		return lastChgdDatetime;
	}

	/**
	 * Set the value related to the column: last_chgd_datetime
	 * 
	 * @param lastChgdDatetime
	 *            the last_chgd_datetime value
	 */
	public void setLastChgdDatetime(java.util.Date lastChgdDatetime) {
		this.lastChgdDatetime = lastChgdDatetime;
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
		if (!(obj instanceof jkt.hms.masters.business.ItemGroup))
			return false;
		else {
			jkt.hms.masters.business.ItemGroup itemGroup = (jkt.hms.masters.business.ItemGroup) obj;
			if (null == this.getId() || null == itemGroup.getId())
				return false;
			else
				return (this.getId().equals(itemGroup.getId()));
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
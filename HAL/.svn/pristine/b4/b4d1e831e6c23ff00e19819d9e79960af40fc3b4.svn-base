package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_designation table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="mas_designation"
 */

public abstract class BaseMasDesignation implements Serializable {

	public static String REF = "MasDesignation";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_DESIGNATION_CODE = "DesignationCode";
	public static String PROP_TYPE = "Type";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_GROUP = "Group";
	public static String PROP_DESIGNATION_NAME = "DesignationName";

	// constructors
	public BaseMasDesignation() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasDesignation(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String designationName;
	private java.lang.String designationCode;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.lang.String lastChgTime;
	private java.util.Date lastChgDate;
	private java.lang.String type;

	// many to one
	private jkt.hms.masters.business.GroupMaster group;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="designation_id"
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
	 * Return the value associated with the column: designation_name
	 */
	public java.lang.String getDesignationName() {
		return designationName;
	}

	/**
	 * Set the value related to the column: designation_name
	 * 
	 * @param designationName
	 *            the designation_name value
	 */
	public void setDesignationName(java.lang.String designationName) {
		this.designationName = designationName;
	}

	/**
	 * Return the value associated with the column: designation_code
	 */
	public java.lang.String getDesignationCode() {
		return designationCode;
	}

	/**
	 * Set the value related to the column: designation_code
	 * 
	 * @param designationCode
	 *            the designation_code value
	 */
	public void setDesignationCode(java.lang.String designationCode) {
		this.designationCode = designationCode;
	}

	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus() {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * 
	 * @param status
	 *            the status value
	 */
	public void setStatus(java.lang.String status) {
		this.status = status;
	}

	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.String getLastChgBy() {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * 
	 * @param lastChgBy
	 *            the last_chg_by value
	 */
	public void setLastChgBy(java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
	}

	/**
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime() {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * 
	 * @param lastChgTime
	 *            the last_chg_time value
	 */
	public void setLastChgTime(java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}

	/**
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate() {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * 
	 * @param lastChgDate
	 *            the last_chg_date value
	 */
	public void setLastChgDate(java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}

	/**
	 * Return the value associated with the column: type
	 */
	public java.lang.String getType() {
		return type;
	}

	/**
	 * Set the value related to the column: type
	 * 
	 * @param type
	 *            the type value
	 */
	public void setType(java.lang.String type) {
		this.type = type;
	}

	/**
	 * Return the value associated with the column: group_id
	 */
	public jkt.hms.masters.business.GroupMaster getGroup() {
		return group;
	}

	/**
	 * Set the value related to the column: group_id
	 * 
	 * @param group
	 *            the group_id value
	 */
	public void setGroup(jkt.hms.masters.business.GroupMaster group) {
		this.group = group;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MasDesignation))
			return false;
		else {
			jkt.hms.masters.business.MasDesignation masDesignation = (jkt.hms.masters.business.MasDesignation) obj;
			if (null == this.getId() || null == masDesignation.getId())
				return false;
			else
				return (this.getId().equals(masDesignation.getId()));
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
package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_work_type table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="mas_work_type"
 */

public abstract class BaseMasWorkType implements Serializable {

	public static String REF = "MasWorkType";
	public static String PROP_MAX_LIMIT = "MaxLimit";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_MIN_LIMIT = "MinLimit";
	public static String PROP_WORK_TYPE_CODE = "WorkTypeCode";
	public static String PROP_WORK_CATEGORY = "WorkCategory";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_WORK_TYPE_NAME = "WorkTypeName";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";

	// constructors
	public BaseMasWorkType() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasWorkType(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.math.BigDecimal maxLimit;
	private java.math.BigDecimal minLimit;
	private java.lang.String status;
	private java.lang.String workTypeCode;
	private java.lang.String workTypeName;

	// many to one
	private jkt.hms.masters.business.MasWorkCategory workCategory;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="work_type_id"
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
	 * Return the value associated with the column: max_limit
	 */
	public java.math.BigDecimal getMaxLimit() {
		return maxLimit;
	}

	/**
	 * Set the value related to the column: max_limit
	 * 
	 * @param maxLimit
	 *            the max_limit value
	 */
	public void setMaxLimit(java.math.BigDecimal maxLimit) {
		this.maxLimit = maxLimit;
	}

	/**
	 * Return the value associated with the column: min_limit
	 */
	public java.math.BigDecimal getMinLimit() {
		return minLimit;
	}

	/**
	 * Set the value related to the column: min_limit
	 * 
	 * @param minLimit
	 *            the min_limit value
	 */
	public void setMinLimit(java.math.BigDecimal minLimit) {
		this.minLimit = minLimit;
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
	 * Return the value associated with the column: work_type_code
	 */
	public java.lang.String getWorkTypeCode() {
		return workTypeCode;
	}

	/**
	 * Set the value related to the column: work_type_code
	 * 
	 * @param workTypeCode
	 *            the work_type_code value
	 */
	public void setWorkTypeCode(java.lang.String workTypeCode) {
		this.workTypeCode = workTypeCode;
	}

	/**
	 * Return the value associated with the column: work_type_name
	 */
	public java.lang.String getWorkTypeName() {
		return workTypeName;
	}

	/**
	 * Set the value related to the column: work_type_name
	 * 
	 * @param workTypeName
	 *            the work_type_name value
	 */
	public void setWorkTypeName(java.lang.String workTypeName) {
		this.workTypeName = workTypeName;
	}

	/**
	 * Return the value associated with the column: work_category_id
	 */
	public jkt.hms.masters.business.MasWorkCategory getWorkCategory() {
		return workCategory;
	}

	/**
	 * Set the value related to the column: work_category_id
	 * 
	 * @param workCategory
	 *            the work_category_id value
	 */
	public void setWorkCategory(
			jkt.hms.masters.business.MasWorkCategory workCategory) {
		this.workCategory = workCategory;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MasWorkType))
			return false;
		else {
			jkt.hms.masters.business.MasWorkType masWorkType = (jkt.hms.masters.business.MasWorkType) obj;
			if (null == this.getId() || null == masWorkType.getId())
				return false;
			else
				return (this.getId().equals(masWorkType.getId()));
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
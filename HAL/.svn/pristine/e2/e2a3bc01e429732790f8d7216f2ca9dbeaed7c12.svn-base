package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_sales_type table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="mas_sales_type"
 */

public abstract class BaseMasSalesType implements Serializable {

	public static String REF = "MasSalesType";
	public static String PROP_STATUS = "Status";
	public static String PROP_SALES_TYPE_NAME = "SalesTypeName";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_SALES_TYPE_CODE = "SalesTypeCode";
	public static String PROP_SALES_TYPE_VALUE = "SalesTypeValue";
	public static String PROP_ID = "Id";

	// constructors
	public BaseMasSalesType() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasSalesType(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseMasSalesType(java.lang.Integer id, java.lang.String status) {

		this.setId(id);
		this.setStatus(status);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String salesTypeCode;
	private java.lang.String salesTypeName;
	private java.lang.Integer salesTypeValue;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="sales_type_id"
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
	 * Return the value associated with the column: sales_type_code
	 */
	public java.lang.String getSalesTypeCode() {
		return salesTypeCode;
	}

	/**
	 * Set the value related to the column: sales_type_code
	 * 
	 * @param salesTypeCode
	 *            the sales_type_code value
	 */
	public void setSalesTypeCode(java.lang.String salesTypeCode) {
		this.salesTypeCode = salesTypeCode;
	}

	/**
	 * Return the value associated with the column: sales_type_name
	 */
	public java.lang.String getSalesTypeName() {
		return salesTypeName;
	}

	/**
	 * Set the value related to the column: sales_type_name
	 * 
	 * @param salesTypeName
	 *            the sales_type_name value
	 */
	public void setSalesTypeName(java.lang.String salesTypeName) {
		this.salesTypeName = salesTypeName;
	}

	/**
	 * Return the value associated with the column: sales_type_value
	 */
	public java.lang.Integer getSalesTypeValue() {
		return salesTypeValue;
	}

	/**
	 * Set the value related to the column: sales_type_value
	 * 
	 * @param salesTypeValue
	 *            the sales_type_value value
	 */
	public void setSalesTypeValue(java.lang.Integer salesTypeValue) {
		this.salesTypeValue = salesTypeValue;
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

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MasSalesType))
			return false;
		else {
			jkt.hms.masters.business.MasSalesType masSalesType = (jkt.hms.masters.business.MasSalesType) obj;
			if (null == this.getId() || null == masSalesType.getId())
				return false;
			else
				return (this.getId().equals(masSalesType.getId()));
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
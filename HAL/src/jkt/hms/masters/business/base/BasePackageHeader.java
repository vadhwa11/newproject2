package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the package_header table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="package_header"
 */

public abstract class BasePackageHeader implements Serializable {

	public static String REF = "PackageHeader";
	public static String PROP_DISCOUNTED_AMOUNT = "DiscountedAmount";
	public static String PROP_STATUS_ID = "StatusId";
	public static String PROP_PACKAGE_NAME = "PackageName";
	public static String PROP_ADD_EDIT_DATE_TIME = "AddEditDateTime";
	public static String PROP_ADD_EDIT_BY_ID = "AddEditById";
	public static String PROP_TOTAL_AMOUNT = "TotalAmount";
	public static String PROP_TO_DATE = "ToDate";
	public static String PROP_ID = "Id";
	public static String PROP_FROM_DATE = "FromDate";
	public static String PROP_PACKAGE_TYPE_ID = "PackageTypeId";

	// constructors
	public BasePackageHeader() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePackageHeader(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String packageName;
	private java.lang.Integer packageTypeId;
	private java.util.Date fromDate;
	private java.util.Date toDate;
	private java.lang.Integer totalAmount;
	private java.lang.Integer discountedAmount;
	private java.lang.Integer addEditById;
	private java.util.Date addEditDateTime;
	private java.lang.Integer statusId;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="package_header_id"
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
	 * Return the value associated with the column: package_name
	 */
	public java.lang.String getPackageName() {
		return packageName;
	}

	/**
	 * Set the value related to the column: package_name
	 * 
	 * @param packageName
	 *            the package_name value
	 */
	public void setPackageName(java.lang.String packageName) {
		this.packageName = packageName;
	}

	/**
	 * Return the value associated with the column: package_type_id
	 */
	public java.lang.Integer getPackageTypeId() {
		return packageTypeId;
	}

	/**
	 * Set the value related to the column: package_type_id
	 * 
	 * @param packageTypeId
	 *            the package_type_id value
	 */
	public void setPackageTypeId(java.lang.Integer packageTypeId) {
		this.packageTypeId = packageTypeId;
	}

	/**
	 * Return the value associated with the column: from_date
	 */
	public java.util.Date getFromDate() {
		return fromDate;
	}

	/**
	 * Set the value related to the column: from_date
	 * 
	 * @param fromDate
	 *            the from_date value
	 */
	public void setFromDate(java.util.Date fromDate) {
		this.fromDate = fromDate;
	}

	/**
	 * Return the value associated with the column: to_date
	 */
	public java.util.Date getToDate() {
		return toDate;
	}

	/**
	 * Set the value related to the column: to_date
	 * 
	 * @param toDate
	 *            the to_date value
	 */
	public void setToDate(java.util.Date toDate) {
		this.toDate = toDate;
	}

	/**
	 * Return the value associated with the column: total_amount
	 */
	public java.lang.Integer getTotalAmount() {
		return totalAmount;
	}

	/**
	 * Set the value related to the column: total_amount
	 * 
	 * @param totalAmount
	 *            the total_amount value
	 */
	public void setTotalAmount(java.lang.Integer totalAmount) {
		this.totalAmount = totalAmount;
	}

	/**
	 * Return the value associated with the column: discounted_amount
	 */
	public java.lang.Integer getDiscountedAmount() {
		return discountedAmount;
	}

	/**
	 * Set the value related to the column: discounted_amount
	 * 
	 * @param discountedAmount
	 *            the discounted_amount value
	 */
	public void setDiscountedAmount(java.lang.Integer discountedAmount) {
		this.discountedAmount = discountedAmount;
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
		if (!(obj instanceof jkt.hms.masters.business.PackageHeader))
			return false;
		else {
			jkt.hms.masters.business.PackageHeader packageHeader = (jkt.hms.masters.business.PackageHeader) obj;
			if (null == this.getId() || null == packageHeader.getId())
				return false;
			else
				return (this.getId().equals(packageHeader.getId()));
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
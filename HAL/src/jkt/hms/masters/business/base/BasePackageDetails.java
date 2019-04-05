package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the package_details table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="package_details"
 */

public abstract class BasePackageDetails implements Serializable {

	public static String REF = "PackageDetails";
	public static String PROP_AMOUNT = "Amount";
	public static String PROP_STATUS_ID = "StatusId";
	public static String PROP_ADD_EDIT_DATE_TIME = "AddEditDateTime";
	public static String PROP_PACKAGE_HEADER_ID = "PackageHeaderId";
	public static String PROP_ADD_EDIT_BY_ID = "AddEditById";
	public static String PROP_CHARGE_CODE_ID = "ChargeCodeId";
	public static String PROP_ID = "Id";
	public static String PROP_QUANTITY = "Quantity";

	// constructors
	public BasePackageDetails() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePackageDetails(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer packageHeaderId;
	private java.lang.Integer chargeCodeId;
	private java.lang.Integer quantity;
	private java.lang.Integer amount;
	private java.lang.Integer addEditById;
	private java.util.Date addEditDateTime;
	private java.lang.Integer statusId;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="package_details_id"
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
	 * Return the value associated with the column: package_header_id
	 */
	public java.lang.Integer getPackageHeaderId() {
		return packageHeaderId;
	}

	/**
	 * Set the value related to the column: package_header_id
	 * 
	 * @param packageHeaderId
	 *            the package_header_id value
	 */
	public void setPackageHeaderId(java.lang.Integer packageHeaderId) {
		this.packageHeaderId = packageHeaderId;
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
	 * Return the value associated with the column: quantity
	 */
	public java.lang.Integer getQuantity() {
		return quantity;
	}

	/**
	 * Set the value related to the column: quantity
	 * 
	 * @param quantity
	 *            the quantity value
	 */
	public void setQuantity(java.lang.Integer quantity) {
		this.quantity = quantity;
	}

	/**
	 * Return the value associated with the column: amount
	 */
	public java.lang.Integer getAmount() {
		return amount;
	}

	/**
	 * Set the value related to the column: amount
	 * 
	 * @param amount
	 *            the amount value
	 */
	public void setAmount(java.lang.Integer amount) {
		this.amount = amount;
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
		if (!(obj instanceof jkt.hms.masters.business.PackageDetails))
			return false;
		else {
			jkt.hms.masters.business.PackageDetails packageDetails = (jkt.hms.masters.business.PackageDetails) obj;
			if (null == this.getId() || null == packageDetails.getId())
				return false;
			else
				return (this.getId().equals(packageDetails.getId()));
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
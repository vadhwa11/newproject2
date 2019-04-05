package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the supplier_master table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="supplier_master"
 */

public abstract class BaseSupplierMaster implements Serializable {

	public static String REF = "SupplierMaster";
	public static String PROP_SUPPLIER_TYPE = "SupplierType";
	public static String PROP_STATUS_ID = "StatusId";
	public static String PROP_STATE_ID = "StateId";
	public static String PROP_ADD_EDIT_DATE_TIME = "AddEditDateTime";
	public static String PROP_GRAM = "Gram";
	public static String PROP_MOBILE_NUMBER = "MobileNumber";
	public static String PROP_COUNTRY_ID = "CountryId";
	public static String PROP_ADD_EDIT_BY_ID = "AddEditById";
	public static String PROP_SUPPLIER_CODE = "SupplierCode";
	public static String PROP_CITY = "City";
	public static String PROP_EMAIL_ID = "EmailId";
	public static String PROP_FAX_NUMBER = "FaxNumber";
	public static String PROP_PHONE_NUMBER = "PhoneNumber";
	public static String PROP_PIN_CODE = "PinCode";
	public static String PROP_SUPPLIER_ADDRESS = "SupplierAddress";
	public static String PROP_ID = "Id";
	public static String PROP_SUPPLIER_DESCRIPTION = "SupplierDescription";

	// constructors
	public BaseSupplierMaster() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSupplierMaster(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String supplierCode;
	private java.lang.String supplierDescription;
	private java.lang.String supplierType;
	private java.lang.String supplierAddress;
	private java.lang.String city;
	private java.lang.Integer stateId;
	private java.lang.Integer countryId;
	private java.lang.String pinCode;
	private java.lang.String gram;
	private java.lang.String emailId;
	private java.lang.String phoneNumber;
	private java.lang.String mobileNumber;
	private java.lang.String faxNumber;
	private java.lang.Integer addEditById;
	private java.util.Date addEditDateTime;
	private java.lang.Integer statusId;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="supplier_id"
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
	 * Return the value associated with the column: supplier_code
	 */
	public java.lang.String getSupplierCode() {
		return supplierCode;
	}

	/**
	 * Set the value related to the column: supplier_code
	 * 
	 * @param supplierCode
	 *            the supplier_code value
	 */
	public void setSupplierCode(java.lang.String supplierCode) {
		this.supplierCode = supplierCode;
	}

	/**
	 * Return the value associated with the column: supplier_description
	 */
	public java.lang.String getSupplierDescription() {
		return supplierDescription;
	}

	/**
	 * Set the value related to the column: supplier_description
	 * 
	 * @param supplierDescription
	 *            the supplier_description value
	 */
	public void setSupplierDescription(java.lang.String supplierDescription) {
		this.supplierDescription = supplierDescription;
	}

	/**
	 * Return the value associated with the column: supplier_type
	 */
	public java.lang.String getSupplierType() {
		return supplierType;
	}

	/**
	 * Set the value related to the column: supplier_type
	 * 
	 * @param supplierType
	 *            the supplier_type value
	 */
	public void setSupplierType(java.lang.String supplierType) {
		this.supplierType = supplierType;
	}

	/**
	 * Return the value associated with the column: supplier_address
	 */
	public java.lang.String getSupplierAddress() {
		return supplierAddress;
	}

	/**
	 * Set the value related to the column: supplier_address
	 * 
	 * @param supplierAddress
	 *            the supplier_address value
	 */
	public void setSupplierAddress(java.lang.String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}

	/**
	 * Return the value associated with the column: city
	 */
	public java.lang.String getCity() {
		return city;
	}

	/**
	 * Set the value related to the column: city
	 * 
	 * @param city
	 *            the city value
	 */
	public void setCity(java.lang.String city) {
		this.city = city;
	}

	/**
	 * Return the value associated with the column: state_id
	 */
	public java.lang.Integer getStateId() {
		return stateId;
	}

	/**
	 * Set the value related to the column: state_id
	 * 
	 * @param stateId
	 *            the state_id value
	 */
	public void setStateId(java.lang.Integer stateId) {
		this.stateId = stateId;
	}

	/**
	 * Return the value associated with the column: country_id
	 */
	public java.lang.Integer getCountryId() {
		return countryId;
	}

	/**
	 * Set the value related to the column: country_id
	 * 
	 * @param countryId
	 *            the country_id value
	 */
	public void setCountryId(java.lang.Integer countryId) {
		this.countryId = countryId;
	}

	/**
	 * Return the value associated with the column: pin_code
	 */
	public java.lang.String getPinCode() {
		return pinCode;
	}

	/**
	 * Set the value related to the column: pin_code
	 * 
	 * @param pinCode
	 *            the pin_code value
	 */
	public void setPinCode(java.lang.String pinCode) {
		this.pinCode = pinCode;
	}

	/**
	 * Return the value associated with the column: gram
	 */
	public java.lang.String getGram() {
		return gram;
	}

	/**
	 * Set the value related to the column: gram
	 * 
	 * @param gram
	 *            the gram value
	 */
	public void setGram(java.lang.String gram) {
		this.gram = gram;
	}

	/**
	 * Return the value associated with the column: email_id
	 */
	public java.lang.String getEmailId() {
		return emailId;
	}

	/**
	 * Set the value related to the column: email_id
	 * 
	 * @param emailId
	 *            the email_id value
	 */
	public void setEmailId(java.lang.String emailId) {
		this.emailId = emailId;
	}

	/**
	 * Return the value associated with the column: phone_number
	 */
	public java.lang.String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Set the value related to the column: phone_number
	 * 
	 * @param phoneNumber
	 *            the phone_number value
	 */
	public void setPhoneNumber(java.lang.String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Return the value associated with the column: mobile_number
	 */
	public java.lang.String getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * Set the value related to the column: mobile_number
	 * 
	 * @param mobileNumber
	 *            the mobile_number value
	 */
	public void setMobileNumber(java.lang.String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/**
	 * Return the value associated with the column: fax_number
	 */
	public java.lang.String getFaxNumber() {
		return faxNumber;
	}

	/**
	 * Set the value related to the column: fax_number
	 * 
	 * @param faxNumber
	 *            the fax_number value
	 */
	public void setFaxNumber(java.lang.String faxNumber) {
		this.faxNumber = faxNumber;
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
		if (!(obj instanceof jkt.hms.masters.business.SupplierMaster))
			return false;
		else {
			jkt.hms.masters.business.SupplierMaster supplierMaster = (jkt.hms.masters.business.SupplierMaster) obj;
			if (null == this.getId() || null == supplierMaster.getId())
				return false;
			else
				return (this.getId().equals(supplierMaster.getId()));
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
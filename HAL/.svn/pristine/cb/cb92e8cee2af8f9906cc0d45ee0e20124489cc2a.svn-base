package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_publisher table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="mas_publisher"
 */

public abstract class BaseMasPublisher implements Serializable {

	public static String REF = "MasPublisher";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_STATE = "State";
	public static String PROP_PUBLISHER_CODE = "PublisherCode";
	public static String PROP_ADDRESS1 = "Address1";
	public static String PROP_DISTRICT = "District";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_PUBLISHER_NAME = "PublisherName";
	public static String PROP_PINCODE = "Pincode";
	public static String PROP_ADDRESS3 = "Address3";
	public static String PROP_ADDRESS2 = "Address2";
	public static String PROP_ID = "Id";

	// constructors
	public BaseMasPublisher() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasPublisher(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String publisherCode;
	private java.lang.String publisherName;
	private java.lang.String address1;
	private java.lang.String address2;
	private java.lang.String address3;
	private java.lang.Integer pincode;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasState state;
	private jkt.hms.masters.business.MasDistrict district;

	// collections
	private java.util.Set<jkt.hms.masters.business.MasBook> masBooks;
	private java.util.Set<jkt.hms.masters.business.MlSupplyorderDetail> mlSupplyorderDetails;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="publisher_id"
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
	 * Return the value associated with the column: publisher_code
	 */
	public java.lang.String getPublisherCode() {
		return publisherCode;
	}

	/**
	 * Set the value related to the column: publisher_code
	 * 
	 * @param publisherCode
	 *            the publisher_code value
	 */
	public void setPublisherCode(java.lang.String publisherCode) {
		this.publisherCode = publisherCode;
	}

	/**
	 * Return the value associated with the column: publisher_name
	 */
	public java.lang.String getPublisherName() {
		return publisherName;
	}

	/**
	 * Set the value related to the column: publisher_name
	 * 
	 * @param publisherName
	 *            the publisher_name value
	 */
	public void setPublisherName(java.lang.String publisherName) {
		this.publisherName = publisherName;
	}

	/**
	 * Return the value associated with the column: address1
	 */
	public java.lang.String getAddress1() {
		return address1;
	}

	/**
	 * Set the value related to the column: address1
	 * 
	 * @param address1
	 *            the address1 value
	 */
	public void setAddress1(java.lang.String address1) {
		this.address1 = address1;
	}

	/**
	 * Return the value associated with the column: address2
	 */
	public java.lang.String getAddress2() {
		return address2;
	}

	/**
	 * Set the value related to the column: address2
	 * 
	 * @param address2
	 *            the address2 value
	 */
	public void setAddress2(java.lang.String address2) {
		this.address2 = address2;
	}

	/**
	 * Return the value associated with the column: address3
	 */
	public java.lang.String getAddress3() {
		return address3;
	}

	/**
	 * Set the value related to the column: address3
	 * 
	 * @param address3
	 *            the address3 value
	 */
	public void setAddress3(java.lang.String address3) {
		this.address3 = address3;
	}

	/**
	 * Return the value associated with the column: pincode
	 */
	public java.lang.Integer getPincode() {
		return pincode;
	}

	/**
	 * Set the value related to the column: pincode
	 * 
	 * @param pincode
	 *            the pincode value
	 */
	public void setPincode(java.lang.Integer pincode) {
		this.pincode = pincode;
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

	/**
	 * Return the value associated with the column: state_id
	 */
	public jkt.hms.masters.business.MasState getState() {
		return state;
	}

	/**
	 * Set the value related to the column: state_id
	 * 
	 * @param state
	 *            the state_id value
	 */
	public void setState(jkt.hms.masters.business.MasState state) {
		this.state = state;
	}

	/**
	 * Return the value associated with the column: district_id
	 */
	public jkt.hms.masters.business.MasDistrict getDistrict() {
		return district;
	}

	/**
	 * Set the value related to the column: district_id
	 * 
	 * @param district
	 *            the district_id value
	 */
	public void setDistrict(jkt.hms.masters.business.MasDistrict district) {
		this.district = district;
	}

	/**
	 * Return the value associated with the column: MasBooks
	 */
	public java.util.Set<jkt.hms.masters.business.MasBook> getMasBooks() {
		return masBooks;
	}

	/**
	 * Set the value related to the column: MasBooks
	 * 
	 * @param masBooks
	 *            the MasBooks value
	 */
	public void setMasBooks(
			java.util.Set<jkt.hms.masters.business.MasBook> masBooks) {
		this.masBooks = masBooks;
	}

	public void addToMasBooks(jkt.hms.masters.business.MasBook masBook) {
		if (null == getMasBooks())
			setMasBooks(new java.util.TreeSet<jkt.hms.masters.business.MasBook>());
		getMasBooks().add(masBook);
	}

	/**
	 * Return the value associated with the column: MlSupplyorderDetails
	 */
	public java.util.Set<jkt.hms.masters.business.MlSupplyorderDetail> getMlSupplyorderDetails() {
		return mlSupplyorderDetails;
	}

	/**
	 * Set the value related to the column: MlSupplyorderDetails
	 * 
	 * @param mlSupplyorderDetails
	 *            the MlSupplyorderDetails value
	 */
	public void setMlSupplyorderDetails(
			java.util.Set<jkt.hms.masters.business.MlSupplyorderDetail> mlSupplyorderDetails) {
		this.mlSupplyorderDetails = mlSupplyorderDetails;
	}

	public void addToMlSupplyorderDetails(
			jkt.hms.masters.business.MlSupplyorderDetail mlSupplyorderDetail) {
		if (null == getMlSupplyorderDetails())
			setMlSupplyorderDetails(new java.util.TreeSet<jkt.hms.masters.business.MlSupplyorderDetail>());
		getMlSupplyorderDetails().add(mlSupplyorderDetail);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MasPublisher))
			return false;
		else {
			jkt.hms.masters.business.MasPublisher masPublisher = (jkt.hms.masters.business.MasPublisher) obj;
			if (null == this.getId() || null == masPublisher.getId())
				return false;
			else
				return (this.getId().equals(masPublisher.getId()));
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
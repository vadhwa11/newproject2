package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the store_copy_address_list
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="store_copy_address_list"
 */

public abstract class BaseStoreCopyAddressList implements Serializable {

	public static String REF = "StoreCopyAddressList";
	public static String PROP_ADDRESS4 = "Address4";
	public static String PROP_DESCRIPTION = "Description";
	public static String PROP_ADDRESS3 = "Address3";
	public static String PROP_ADDRESS1 = "Address1";
	public static String PROP_ID = "Id";
	public static String PROP_ADDRESS2 = "Address2";

	// constructors
	public BaseStoreCopyAddressList() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreCopyAddressList(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseStoreCopyAddressList(java.lang.Integer id,
			java.lang.String description, java.lang.String address1) {

		this.setId(id);
		this.setDescription(description);
		this.setAddress1(address1);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String description;
	private java.lang.String address1;
	private java.lang.String address2;
	private java.lang.String address3;
	private java.lang.String address4;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="id"
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
	 * Return the value associated with the column: description
	 */
	public java.lang.String getDescription() {
		return description;
	}

	/**
	 * Set the value related to the column: description
	 * 
	 * @param description
	 *            the description value
	 */
	public void setDescription(java.lang.String description) {
		this.description = description;
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
	 * Return the value associated with the column: address4
	 */
	public java.lang.String getAddress4() {
		return address4;
	}

	/**
	 * Set the value related to the column: address4
	 * 
	 * @param address4
	 *            the address4 value
	 */
	public void setAddress4(java.lang.String address4) {
		this.address4 = address4;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreCopyAddressList))
			return false;
		else {
			jkt.hms.masters.business.StoreCopyAddressList storeCopyAddressList = (jkt.hms.masters.business.StoreCopyAddressList) obj;
			if (null == this.getId() || null == storeCopyAddressList.getId())
				return false;
			else
				return (this.getId().equals(storeCopyAddressList.getId()));
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
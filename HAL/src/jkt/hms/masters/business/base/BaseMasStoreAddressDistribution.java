package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * mas_store_address_distribution table. Do not modify this class because it
 * will be overwritten if the configuration file related to this class is
 * modified.
 * 
 * @hibernate.class table="mas_store_address_distribution"
 */

public abstract class BaseMasStoreAddressDistribution implements Serializable {

	public static String REF = "MasStoreAddressDistribution";
	public static String PROP_ADDRESS_DESCR = "AddressDescr";
	public static String PROP_ADDRESS_LINE3 = "AddressLine3";
	public static String PROP_ADDRESS_LINE1 = "AddressLine1";
	public static String PROP_ADDRESS_LINE2 = "AddressLine2";
	public static String PROP_ID = "Id";
	public static String PROP_ADDRESS_LINE4 = "AddressLine4";

	// constructors
	public BaseMasStoreAddressDistribution() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasStoreAddressDistribution(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String addressDescr;
	private java.lang.String addressLine1;
	private java.lang.String addressLine2;
	private java.lang.String addressLine3;
	private java.lang.String addressLine4;

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
	 * Return the value associated with the column: address_descr
	 */
	public java.lang.String getAddressDescr() {
		return addressDescr;
	}

	/**
	 * Set the value related to the column: address_descr
	 * 
	 * @param addressDescr
	 *            the address_descr value
	 */
	public void setAddressDescr(java.lang.String addressDescr) {
		this.addressDescr = addressDescr;
	}

	/**
	 * Return the value associated with the column: address_line_1
	 */
	public java.lang.String getAddressLine1() {
		return addressLine1;
	}

	/**
	 * Set the value related to the column: address_line_1
	 * 
	 * @param addressLine1
	 *            the address_line_1 value
	 */
	public void setAddressLine1(java.lang.String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	/**
	 * Return the value associated with the column: address_line_2
	 */
	public java.lang.String getAddressLine2() {
		return addressLine2;
	}

	/**
	 * Set the value related to the column: address_line_2
	 * 
	 * @param addressLine2
	 *            the address_line_2 value
	 */
	public void setAddressLine2(java.lang.String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	/**
	 * Return the value associated with the column: address_line_3
	 */
	public java.lang.String getAddressLine3() {
		return addressLine3;
	}

	/**
	 * Set the value related to the column: address_line_3
	 * 
	 * @param addressLine3
	 *            the address_line_3 value
	 */
	public void setAddressLine3(java.lang.String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	/**
	 * Return the value associated with the column: address_line_4
	 */
	public java.lang.String getAddressLine4() {
		return addressLine4;
	}

	/**
	 * Set the value related to the column: address_line_4
	 * 
	 * @param addressLine4
	 *            the address_line_4 value
	 */
	public void setAddressLine4(java.lang.String addressLine4) {
		this.addressLine4 = addressLine4;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MasStoreAddressDistribution))
			return false;
		else {
			jkt.hms.masters.business.MasStoreAddressDistribution masStoreAddressDistribution = (jkt.hms.masters.business.MasStoreAddressDistribution) obj;
			if (null == this.getId()
					|| null == masStoreAddressDistribution.getId())
				return false;
			else
				return (this.getId()
						.equals(masStoreAddressDistribution.getId()));
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
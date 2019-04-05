package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the address table. Do not
 * modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * 
 * @hibernate.class table="address"
 */

public abstract class BaseAddress implements Serializable {

	public static String REF = "Address";
	public static String PROP_STATE = "State";
	public static String PROP_COUNTRY = "Country";
	public static String PROP_CITY = "City";
	public static String PROP_ADD_CODE = "AddCode";
	public static String PROP_NAME = "Name";
	public static String PROP_ID = "Id";

	// constructors
	public BaseAddress() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAddress(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String addCode;
	private java.lang.String name;
	private java.lang.String city;
	private java.lang.String state;
	private java.lang.String country;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="add_pk"
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
	 * Return the value associated with the column: add_code
	 */
	public java.lang.String getAddCode() {
		return addCode;
	}

	/**
	 * Set the value related to the column: add_code
	 * 
	 * @param addCode
	 *            the add_code value
	 */
	public void setAddCode(java.lang.String addCode) {
		this.addCode = addCode;
	}

	/**
	 * Return the value associated with the column: name
	 */
	public java.lang.String getName() {
		return name;
	}

	/**
	 * Set the value related to the column: name
	 * 
	 * @param name
	 *            the name value
	 */
	public void setName(java.lang.String name) {
		this.name = name;
	}

	/**
	 * Return the value associated with the column: City
	 */
	public java.lang.String getCity() {
		return city;
	}

	/**
	 * Set the value related to the column: City
	 * 
	 * @param city
	 *            the City value
	 */
	public void setCity(java.lang.String city) {
		this.city = city;
	}

	/**
	 * Return the value associated with the column: state
	 */
	public java.lang.String getState() {
		return state;
	}

	/**
	 * Set the value related to the column: state
	 * 
	 * @param state
	 *            the state value
	 */
	public void setState(java.lang.String state) {
		this.state = state;
	}

	/**
	 * Return the value associated with the column: country
	 */
	public java.lang.String getCountry() {
		return country;
	}

	/**
	 * Set the value related to the column: country
	 * 
	 * @param country
	 *            the country value
	 */
	public void setCountry(java.lang.String country) {
		this.country = country;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.Address))
			return false;
		else {
			jkt.hms.masters.business.Address address = (jkt.hms.masters.business.Address) obj;
			if (null == this.getId() || null == address.getId())
				return false;
			else
				return (this.getId().equals(address.getId()));
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
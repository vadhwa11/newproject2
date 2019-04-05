package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the status table. Do not
 * modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * 
 * @hibernate.class table="status"
 */

public abstract class BaseStatus implements Serializable {

	public static String REF = "Status";
	public static String PROP_DESCRIPTION = "Description";
	public static String PROP_STATUS_CODE = "StatusCode";
	public static String PROP_ID = "Id";

	// constructors
	public BaseStatus() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStatus(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer statusCode;
	private java.lang.String description;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="status_id"
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
	 * Return the value associated with the column: status_code
	 */
	public java.lang.Integer getStatusCode() {
		return statusCode;
	}

	/**
	 * Set the value related to the column: status_code
	 * 
	 * @param statusCode
	 *            the status_code value
	 */
	public void setStatusCode(java.lang.Integer statusCode) {
		this.statusCode = statusCode;
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

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.Status))
			return false;
		else {
			jkt.hms.masters.business.Status status = (jkt.hms.masters.business.Status) obj;
			if (null == this.getId() || null == status.getId())
				return false;
			else
				return (this.getId().equals(status.getId()));
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
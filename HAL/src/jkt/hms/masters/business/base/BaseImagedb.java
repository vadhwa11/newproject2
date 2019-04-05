package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the imagedb table. Do not
 * modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * 
 * @hibernate.class table="imagedb"
 */

public abstract class BaseImagedb implements Serializable {

	public static String REF = "Imagedb";
	public static String PROP_DESCRIPTION = "Description";
	public static String PROP_CONTENT = "Content";
	public static String PROP_ID = "Id";

	// constructors
	public BaseImagedb() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseImagedb(java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private byte[] content;
	private java.lang.String description;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="image_name"
	 */
	public java.lang.String getId() {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * 
	 * @param id
	 *            the new ID
	 */
	public void setId(java.lang.String id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}

	/**
	 * Return the value associated with the column: content
	 */
	public byte[] getContent() {
		return content;
	}

	/**
	 * Set the value related to the column: content
	 * 
	 * @param content
	 *            the content value
	 */
	public void setContent(byte[] content) {
		this.content = content;
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
		if (!(obj instanceof jkt.hms.masters.business.Imagedb))
			return false;
		else {
			jkt.hms.masters.business.Imagedb imagedb = (jkt.hms.masters.business.Imagedb) obj;
			if (null == this.getId() || null == imagedb.getId())
				return false;
			else
				return (this.getId().equals(imagedb.getId()));
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
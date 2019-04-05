package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_post_code table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="mas_post_code"
 */

public abstract class BaseMasPostCode implements Serializable {

	public static String REF = "MasPostCode";
	public static String PROP_STATUS = "Status";
	public static String PROP_BLOCK = "Block";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_POST_CODE_NAME = "PostCodeName";
	public static String PROP_POST_CODE = "PostCode";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ID = "Id";

	// constructors
	public BaseMasPostCode() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasPostCode(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String postCode;
	private java.lang.String postCodeName;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasBlock block;

	// collections
	private java.util.Set<jkt.hms.masters.business.Patient> patients;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="post_code_id"
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
	 * Return the value associated with the column: post_code
	 */
	public java.lang.String getPostCode() {
		return postCode;
	}

	/**
	 * Set the value related to the column: post_code
	 * 
	 * @param postCode
	 *            the post_code value
	 */
	public void setPostCode(java.lang.String postCode) {
		this.postCode = postCode;
	}

	/**
	 * Return the value associated with the column: post_code_name
	 */
	public java.lang.String getPostCodeName() {
		return postCodeName;
	}

	/**
	 * Set the value related to the column: post_code_name
	 * 
	 * @param postCodeName
	 *            the post_code_name value
	 */
	public void setPostCodeName(java.lang.String postCodeName) {
		this.postCodeName = postCodeName;
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
	 * Return the value associated with the column: block_id
	 */
	public jkt.hms.masters.business.MasBlock getBlock() {
		return block;
	}

	/**
	 * Set the value related to the column: block_id
	 * 
	 * @param block
	 *            the block_id value
	 */
	public void setBlock(jkt.hms.masters.business.MasBlock block) {
		this.block = block;
	}

	/**
	 * Return the value associated with the column: Patients
	 */
	public java.util.Set<jkt.hms.masters.business.Patient> getPatients() {
		return patients;
	}

	/**
	 * Set the value related to the column: Patients
	 * 
	 * @param patients
	 *            the Patients value
	 */
	public void setPatients(
			java.util.Set<jkt.hms.masters.business.Patient> patients) {
		this.patients = patients;
	}

	public void addToPatients(jkt.hms.masters.business.Patient patient) {
		if (null == getPatients())
			setPatients(new java.util.TreeSet<jkt.hms.masters.business.Patient>());
		getPatients().add(patient);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MasPostCode))
			return false;
		else {
			jkt.hms.masters.business.MasPostCode masPostCode = (jkt.hms.masters.business.MasPostCode) obj;
			if (null == this.getId() || null == masPostCode.getId())
				return false;
			else
				return (this.getId().equals(masPostCode.getId()));
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
package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_body_part table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="mas_body_part"
 */

public abstract class BaseMasBodyPart implements Serializable {

	public static String REF = "MasBodyPart";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_BODY_PART_CODE = "BodyPartCode";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ID = "Id";
	public static String PROP_BODY_PART_NAME = "BodyPartName";

	// constructors
	public BaseMasBodyPart() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasBodyPart(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String bodyPartCode;
	private java.lang.String bodyPartName;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// collections
	private java.util.Set<jkt.hms.masters.business.MlcCase> mlcCases;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="body_part_id"
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
	 * Return the value associated with the column: body_part_code
	 */
	public java.lang.String getBodyPartCode() {
		return bodyPartCode;
	}

	/**
	 * Set the value related to the column: body_part_code
	 * 
	 * @param bodyPartCode
	 *            the body_part_code value
	 */
	public void setBodyPartCode(java.lang.String bodyPartCode) {
		this.bodyPartCode = bodyPartCode;
	}

	/**
	 * Return the value associated with the column: body_part_name
	 */
	public java.lang.String getBodyPartName() {
		return bodyPartName;
	}

	/**
	 * Set the value related to the column: body_part_name
	 * 
	 * @param bodyPartName
	 *            the body_part_name value
	 */
	public void setBodyPartName(java.lang.String bodyPartName) {
		this.bodyPartName = bodyPartName;
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
	 * Return the value associated with the column: MlcCases
	 */
	public java.util.Set<jkt.hms.masters.business.MlcCase> getMlcCases() {
		return mlcCases;
	}

	/**
	 * Set the value related to the column: MlcCases
	 * 
	 * @param mlcCases
	 *            the MlcCases value
	 */
	public void setMlcCases(
			java.util.Set<jkt.hms.masters.business.MlcCase> mlcCases) {
		this.mlcCases = mlcCases;
	}

	public void addToMlcCases(jkt.hms.masters.business.MlcCase mlcCase) {
		if (null == getMlcCases())
			setMlcCases(new java.util.TreeSet<jkt.hms.masters.business.MlcCase>());
		getMlcCases().add(mlcCase);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MasBodyPart))
			return false;
		else {
			jkt.hms.masters.business.MasBodyPart masBodyPart = (jkt.hms.masters.business.MasBodyPart) obj;
			if (null == this.getId() || null == masBodyPart.getId())
				return false;
			else
				return (this.getId().equals(masBodyPart.getId()));
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
package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_bed_status table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="mas_bed_status"
 */

public abstract class BaseMasBedStatus implements Serializable {

	public static String REF = "MasBedStatus";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_BED_STATUS_NAME = "BedStatusName";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_BED_STATUS_CODE = "BedStatusCode";
	public static String PROP_ID = "Id";

	// constructors
	public BaseMasBedStatus() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasBedStatus(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String bedStatusCode;
	private java.lang.String bedStatusName;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// collections
	private java.util.Set<jkt.hms.masters.business.MasBed> masBeds;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="bed_status_id"
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
	 * Return the value associated with the column: bed_status_code
	 */
	public java.lang.String getBedStatusCode() {
		return bedStatusCode;
	}

	/**
	 * Set the value related to the column: bed_status_code
	 * 
	 * @param bedStatusCode
	 *            the bed_status_code value
	 */
	public void setBedStatusCode(java.lang.String bedStatusCode) {
		this.bedStatusCode = bedStatusCode;
	}

	/**
	 * Return the value associated with the column: bed_status_name
	 */
	public java.lang.String getBedStatusName() {
		return bedStatusName;
	}

	/**
	 * Set the value related to the column: bed_status_name
	 * 
	 * @param bedStatusName
	 *            the bed_status_name value
	 */
	public void setBedStatusName(java.lang.String bedStatusName) {
		this.bedStatusName = bedStatusName;
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
	 * Return the value associated with the column: MasBeds
	 */
	public java.util.Set<jkt.hms.masters.business.MasBed> getMasBeds() {
		return masBeds;
	}

	/**
	 * Set the value related to the column: MasBeds
	 * 
	 * @param masBeds
	 *            the MasBeds value
	 */
	public void setMasBeds(
			java.util.Set<jkt.hms.masters.business.MasBed> masBeds) {
		this.masBeds = masBeds;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MasBedStatus))
			return false;
		else {
			jkt.hms.masters.business.MasBedStatus masBedStatus = (jkt.hms.masters.business.MasBedStatus) obj;
			if (null == this.getId() || null == masBedStatus.getId())
				return false;
			else
				return (this.getId().equals(masBedStatus.getId()));
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
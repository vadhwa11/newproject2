package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_antibiotic_lab table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="mas_antibiotic_lab"
 */

public abstract class BaseMasAntibioticLab implements Serializable {

	public static String REF = "MasAntibioticLab";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ANTIBIOTIC_LAB_NAME = "AntibioticLabName";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ANTIBIOTIC_LAB_CODE = "AntibioticLabCode";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ID = "Id";

	// constructors
	public BaseMasAntibioticLab() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasAntibioticLab(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String antibioticLabCode;
	private java.lang.String antibioticLabName;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="antibiotic_lab_id"
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
	 * Return the value associated with the column: antibiotic_lab_code
	 */
	public java.lang.String getAntibioticLabCode() {
		return antibioticLabCode;
	}

	/**
	 * Set the value related to the column: antibiotic_lab_code
	 * 
	 * @param antibioticLabCode
	 *            the antibiotic_lab_code value
	 */
	public void setAntibioticLabCode(java.lang.String antibioticLabCode) {
		this.antibioticLabCode = antibioticLabCode;
	}

	/**
	 * Return the value associated with the column: antibiotic_lab_name
	 */
	public java.lang.String getAntibioticLabName() {
		return antibioticLabName;
	}

	/**
	 * Set the value related to the column: antibiotic_lab_name
	 * 
	 * @param antibioticLabName
	 *            the antibiotic_lab_name value
	 */
	public void setAntibioticLabName(java.lang.String antibioticLabName) {
		this.antibioticLabName = antibioticLabName;
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

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MasAntibioticLab))
			return false;
		else {
			jkt.hms.masters.business.MasAntibioticLab masAntibioticLab = (jkt.hms.masters.business.MasAntibioticLab) obj;
			if (null == this.getId() || null == masAntibioticLab.getId())
				return false;
			else
				return (this.getId().equals(masAntibioticLab.getId()));
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
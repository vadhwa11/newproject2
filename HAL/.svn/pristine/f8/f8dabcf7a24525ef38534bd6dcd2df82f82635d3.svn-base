package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_organism_lab table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="mas_organism_lab"
 */

public abstract class BaseMasOrganismLab implements Serializable {

	public static String REF = "MasOrganismLab";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ORGANISM_LAB_CODE = "OrganismLabCode";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ORGANISM_LAB_NAME = "OrganismLabName";
	public static String PROP_ID = "Id";

	// constructors
	public BaseMasOrganismLab() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasOrganismLab(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String organismLabCode;
	private java.lang.String organismLabName;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// collections
	private java.util.Set<jkt.hms.masters.business.MasOrganismDescLab> masOrganismDescLabs;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="organism_lab_id"
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
	 * Return the value associated with the column: organism_lab_code
	 */
	public java.lang.String getOrganismLabCode() {
		return organismLabCode;
	}

	/**
	 * Set the value related to the column: organism_lab_code
	 * 
	 * @param organismLabCode
	 *            the organism_lab_code value
	 */
	public void setOrganismLabCode(java.lang.String organismLabCode) {
		this.organismLabCode = organismLabCode;
	}

	/**
	 * Return the value associated with the column: organism_lab_name
	 */
	public java.lang.String getOrganismLabName() {
		return organismLabName;
	}

	/**
	 * Set the value related to the column: organism_lab_name
	 * 
	 * @param organismLabName
	 *            the organism_lab_name value
	 */
	public void setOrganismLabName(java.lang.String organismLabName) {
		this.organismLabName = organismLabName;
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
	 * Return the value associated with the column: MasOrganismDescLabs
	 */
	public java.util.Set<jkt.hms.masters.business.MasOrganismDescLab> getMasOrganismDescLabs() {
		return masOrganismDescLabs;
	}

	/**
	 * Set the value related to the column: MasOrganismDescLabs
	 * 
	 * @param masOrganismDescLabs
	 *            the MasOrganismDescLabs value
	 */
	public void setMasOrganismDescLabs(
			java.util.Set<jkt.hms.masters.business.MasOrganismDescLab> masOrganismDescLabs) {
		this.masOrganismDescLabs = masOrganismDescLabs;
	}

	public void addToMasOrganismDescLabs(
			jkt.hms.masters.business.MasOrganismDescLab masOrganismDescLab) {
		if (null == getMasOrganismDescLabs())
			setMasOrganismDescLabs(new java.util.TreeSet<jkt.hms.masters.business.MasOrganismDescLab>());
		getMasOrganismDescLabs().add(masOrganismDescLab);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MasOrganismLab))
			return false;
		else {
			jkt.hms.masters.business.MasOrganismLab masOrganismLab = (jkt.hms.masters.business.MasOrganismLab) obj;
			if (null == this.getId() || null == masOrganismLab.getId())
				return false;
			else
				return (this.getId().equals(masOrganismLab.getId()));
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
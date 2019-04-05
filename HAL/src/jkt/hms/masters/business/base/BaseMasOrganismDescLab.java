package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_organism_desc_lab
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="mas_organism_desc_lab"
 */

public abstract class BaseMasOrganismDescLab implements Serializable {

	public static String REF = "MasOrganismDescLab";
	public static String PROP_STATUS = "Status";
	public static String PROP_ORGANISM_DESC_NAME = "OrganismDescName";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ORGANISM_GROUP = "OrganismGroup";
	public static String PROP_ORGANISM_DESC_CODE = "OrganismDescCode";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ID = "Id";

	// constructors
	public BaseMasOrganismDescLab() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasOrganismDescLab(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseMasOrganismDescLab(java.lang.Integer id,
			jkt.hms.masters.business.MasOrganismLab organismGroup) {

		this.setId(id);
		this.setOrganismGroup(organismGroup);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String organismDescCode;
	private java.lang.String organismDescName;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasOrganismLab organismGroup;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="organism_desc_id"
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
	 * Return the value associated with the column: organism_desc_code
	 */
	public java.lang.String getOrganismDescCode() {
		return organismDescCode;
	}

	/**
	 * Set the value related to the column: organism_desc_code
	 * 
	 * @param organismDescCode
	 *            the organism_desc_code value
	 */
	public void setOrganismDescCode(java.lang.String organismDescCode) {
		this.organismDescCode = organismDescCode;
	}

	/**
	 * Return the value associated with the column: organism_desc_name
	 */
	public java.lang.String getOrganismDescName() {
		return organismDescName;
	}

	/**
	 * Set the value related to the column: organism_desc_name
	 * 
	 * @param organismDescName
	 *            the organism_desc_name value
	 */
	public void setOrganismDescName(java.lang.String organismDescName) {
		this.organismDescName = organismDescName;
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
	 * Return the value associated with the column: organism_group_id
	 */
	public jkt.hms.masters.business.MasOrganismLab getOrganismGroup() {
		return organismGroup;
	}

	/**
	 * Set the value related to the column: organism_group_id
	 * 
	 * @param organismGroup
	 *            the organism_group_id value
	 */
	public void setOrganismGroup(
			jkt.hms.masters.business.MasOrganismLab organismGroup) {
		this.organismGroup = organismGroup;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MasOrganismDescLab))
			return false;
		else {
			jkt.hms.masters.business.MasOrganismDescLab masOrganismDescLab = (jkt.hms.masters.business.MasOrganismDescLab) obj;
			if (null == this.getId() || null == masOrganismDescLab.getId())
				return false;
			else
				return (this.getId().equals(masOrganismDescLab.getId()));
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
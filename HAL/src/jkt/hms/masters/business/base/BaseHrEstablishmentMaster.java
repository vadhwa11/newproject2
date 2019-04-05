package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the hr_establishment_master
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="hr_establishment_master"
 */

public abstract class BaseHrEstablishmentMaster implements Serializable {

	public static String REF = "HrEstablishmentMaster";
	public static String PROP_STATUS = "Status";
	public static String PROP_STRENGTH = "Strength";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_RANK = "Rank";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_SPECIALITY = "Speciality";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_UNIT = "Unit";
	public static String PROP_MANNING_LEVEL = "ManningLevel";

	// constructors
	public BaseHrEstablishmentMaster() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrEstablishmentMaster(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer strength;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.lang.String lastChgTime;
	private java.util.Date lastChgDate;
	private java.lang.Integer manningLevel;

	// many to one
	private jkt.hms.masters.business.MasRank rank;
	private jkt.hms.masters.business.MasUnit unit;
	private jkt.hms.masters.business.HrSpecialistMaster speciality;

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
	 * Return the value associated with the column: strength
	 */
	public java.lang.Integer getStrength() {
		return strength;
	}

	/**
	 * Set the value related to the column: strength
	 * 
	 * @param strength
	 *            the strength value
	 */
	public void setStrength(java.lang.Integer strength) {
		this.strength = strength;
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
	 * Return the value associated with the column: manning_level
	 */
	public java.lang.Integer getManningLevel() {
		return manningLevel;
	}

	/**
	 * Set the value related to the column: manning_level
	 * 
	 * @param manningLevel
	 *            the manning_level value
	 */
	public void setManningLevel(java.lang.Integer manningLevel) {
		this.manningLevel = manningLevel;
	}

	/**
	 * Return the value associated with the column: rank_id
	 */
	public jkt.hms.masters.business.MasRank getRank() {
		return rank;
	}

	/**
	 * Set the value related to the column: rank_id
	 * 
	 * @param rank
	 *            the rank_id value
	 */
	public void setRank(jkt.hms.masters.business.MasRank rank) {
		this.rank = rank;
	}

	/**
	 * Return the value associated with the column: unit_id
	 */
	public jkt.hms.masters.business.MasUnit getUnit() {
		return unit;
	}

	/**
	 * Set the value related to the column: unit_id
	 * 
	 * @param unit
	 *            the unit_id value
	 */
	public void setUnit(jkt.hms.masters.business.MasUnit unit) {
		this.unit = unit;
	}

	/**
	 * Return the value associated with the column: speciality_id
	 */
	public jkt.hms.masters.business.HrSpecialistMaster getSpeciality() {
		return speciality;
	}

	/**
	 * Set the value related to the column: speciality_id
	 * 
	 * @param speciality
	 *            the speciality_id value
	 */
	public void setSpeciality(
			jkt.hms.masters.business.HrSpecialistMaster speciality) {
		this.speciality = speciality;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.HrEstablishmentMaster))
			return false;
		else {
			jkt.hms.masters.business.HrEstablishmentMaster hrEstablishmentMaster = (jkt.hms.masters.business.HrEstablishmentMaster) obj;
			if (null == this.getId() || null == hrEstablishmentMaster.getId())
				return false;
			else
				return (this.getId().equals(hrEstablishmentMaster.getId()));
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
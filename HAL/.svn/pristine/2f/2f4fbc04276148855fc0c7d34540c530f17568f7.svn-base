package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_diet_type table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="mas_diet_type"
 */

public abstract class BaseMasDietType implements Serializable {

	public static String REF = "MasDietType";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_DIET_TYPE_NAME = "DietTypeName";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DIET_TYPE_CODE = "DietTypeCode";
	public static String PROP_ID = "Id";

	// constructors
	public BaseMasDietType() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasDietType(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String dietTypeCode;
	private java.lang.String dietTypeName;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// collections
	private java.util.Set<jkt.hms.masters.business.MasDietCombination> masDietCombinations;
	private java.util.Set<jkt.hms.masters.business.DietDetails> dietDetails;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="diet_type_id"
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
	 * Return the value associated with the column: diet_type_code
	 */
	public java.lang.String getDietTypeCode() {
		return dietTypeCode;
	}

	/**
	 * Set the value related to the column: diet_type_code
	 * 
	 * @param dietTypeCode
	 *            the diet_type_code value
	 */
	public void setDietTypeCode(java.lang.String dietTypeCode) {
		this.dietTypeCode = dietTypeCode;
	}

	/**
	 * Return the value associated with the column: diet_type_name
	 */
	public java.lang.String getDietTypeName() {
		return dietTypeName;
	}

	/**
	 * Set the value related to the column: diet_type_name
	 * 
	 * @param dietTypeName
	 *            the diet_type_name value
	 */
	public void setDietTypeName(java.lang.String dietTypeName) {
		this.dietTypeName = dietTypeName;
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
	 * Return the value associated with the column: MasDietCombinations
	 */
	public java.util.Set<jkt.hms.masters.business.MasDietCombination> getMasDietCombinations() {
		return masDietCombinations;
	}

	/**
	 * Set the value related to the column: MasDietCombinations
	 * 
	 * @param masDietCombinations
	 *            the MasDietCombinations value
	 */
	public void setMasDietCombinations(
			java.util.Set<jkt.hms.masters.business.MasDietCombination> masDietCombinations) {
		this.masDietCombinations = masDietCombinations;
	}

	public void addToMasDietCombinations(
			jkt.hms.masters.business.MasDietCombination masDietCombination) {
		if (null == getMasDietCombinations())
			setMasDietCombinations(new java.util.TreeSet<jkt.hms.masters.business.MasDietCombination>());
		getMasDietCombinations().add(masDietCombination);
	}

	/**
	 * Return the value associated with the column: DietDetails
	 */
	public java.util.Set<jkt.hms.masters.business.DietDetails> getDietDetails() {
		return dietDetails;
	}

	/**
	 * Set the value related to the column: DietDetails
	 * 
	 * @param dietDetails
	 *            the DietDetails value
	 */
	public void setDietDetails(
			java.util.Set<jkt.hms.masters.business.DietDetails> dietDetails) {
		this.dietDetails = dietDetails;
	}

	public void addToDietDetails(
			jkt.hms.masters.business.DietDetails dietDetails) {
		if (null == getDietDetails())
			setDietDetails(new java.util.TreeSet<jkt.hms.masters.business.DietDetails>());
		getDietDetails().add(dietDetails);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MasDietType))
			return false;
		else {
			jkt.hms.masters.business.MasDietType masDietType = (jkt.hms.masters.business.MasDietType) obj;
			if (null == this.getId() || null == masDietType.getId())
				return false;
			else
				return (this.getId().equals(masDietType.getId()));
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
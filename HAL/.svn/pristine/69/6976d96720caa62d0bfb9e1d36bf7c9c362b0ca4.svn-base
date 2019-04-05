package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * diet_demand_ration_strength table. Do not modify this class because it will
 * be overwritten if the configuration file related to this class is modified.
 * 
 * @hibernate.class table="diet_demand_ration_strength"
 */

public abstract class BaseDietDemandRationStrength implements Serializable {

	public static String REF = "DietDemandRationStrength";
	public static String PROP_DIET_COMBINATION = "DietCombination";
	public static String PROP_CHANGED_DATE = "ChangedDate";
	public static String PROP_DIET_DEMAND_RATION_HEADER = "DietDemandRationHeader";
	public static String PROP_CHANGED_TIME = "ChangedTime";
	public static String PROP_STRENGTH = "Strength";
	public static String PROP_ID = "Id";
	public static String PROP_CHANGED_BY = "ChangedBy";

	// constructors
	public BaseDietDemandRationStrength() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDietDemandRationStrength(java.lang.Integer id) {
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
	private java.lang.String changedBy;
	private java.util.Date changedDate;
	private java.lang.String changedTime;

	// many to one
	private jkt.hms.masters.business.DietDemandRationHeader dietDemandRationHeader;
	private jkt.hms.masters.business.MasDietCombination dietCombination;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native"
	 *               column="diet_demand_ration_strength_id"
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
	 * Return the value associated with the column: changed_by
	 */
	public java.lang.String getChangedBy() {
		return changedBy;
	}

	/**
	 * Set the value related to the column: changed_by
	 * 
	 * @param changedBy
	 *            the changed_by value
	 */
	public void setChangedBy(java.lang.String changedBy) {
		this.changedBy = changedBy;
	}

	/**
	 * Return the value associated with the column: changed_date
	 */
	public java.util.Date getChangedDate() {
		return changedDate;
	}

	/**
	 * Set the value related to the column: changed_date
	 * 
	 * @param changedDate
	 *            the changed_date value
	 */
	public void setChangedDate(java.util.Date changedDate) {
		this.changedDate = changedDate;
	}

	/**
	 * Return the value associated with the column: changed_time
	 */
	public java.lang.String getChangedTime() {
		return changedTime;
	}

	/**
	 * Set the value related to the column: changed_time
	 * 
	 * @param changedTime
	 *            the changed_time value
	 */
	public void setChangedTime(java.lang.String changedTime) {
		this.changedTime = changedTime;
	}

	/**
	 * Return the value associated with the column: diet_demand_ration_header_id
	 */
	public jkt.hms.masters.business.DietDemandRationHeader getDietDemandRationHeader() {
		return dietDemandRationHeader;
	}

	/**
	 * Set the value related to the column: diet_demand_ration_header_id
	 * 
	 * @param dietDemandRationHeader
	 *            the diet_demand_ration_header_id value
	 */
	public void setDietDemandRationHeader(
			jkt.hms.masters.business.DietDemandRationHeader dietDemandRationHeader) {
		this.dietDemandRationHeader = dietDemandRationHeader;
	}

	/**
	 * Return the value associated with the column: diet_combination_id
	 */
	public jkt.hms.masters.business.MasDietCombination getDietCombination() {
		return dietCombination;
	}

	/**
	 * Set the value related to the column: diet_combination_id
	 * 
	 * @param dietCombination
	 *            the diet_combination_id value
	 */
	public void setDietCombination(
			jkt.hms.masters.business.MasDietCombination dietCombination) {
		this.dietCombination = dietCombination;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.DietDemandRationStrength))
			return false;
		else {
			jkt.hms.masters.business.DietDemandRationStrength dietDemandRationStrength = (jkt.hms.masters.business.DietDemandRationStrength) obj;
			if (null == this.getId()
					|| null == dietDemandRationStrength.getId())
				return false;
			else
				return (this.getId().equals(dietDemandRationStrength.getId()));
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
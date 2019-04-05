package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the diet_demand_ration_header
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="diet_demand_ration_header"
 */

public abstract class BaseDietDemandRationHeader implements Serializable {

	public static String REF = "DietDemandRationHeader";
	public static String PROP_MESS_NAME = "MessName";
	public static String PROP_DEMAND_SR_NO = "DemandSrNo";
	public static String PROP_CHANGED_DATE = "ChangedDate";
	public static String PROP_UNIT = "Unit";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_DEMAND_FROM_DATE = "DemandFromDate";
	public static String PROP_CHANGED_TIME = "ChangedTime";
	public static String PROP_DEMAND_TO_DATE = "DemandToDate";
	public static String PROP_ID = "Id";
	public static String PROP_CHANGED_BY = "ChangedBy";
	public static String PROP_RATION_TYPE = "RationType";

	// constructors
	public BaseDietDemandRationHeader() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDietDemandRationHeader(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String rationType;
	private java.lang.String demandSrNo;
	private java.lang.String messName;
	private java.lang.String unit;
	private java.util.Date demandFromDate;
	private java.util.Date demandToDate;
	private java.lang.String changedBy;
	private java.util.Date changedDate;
	private java.lang.String changedTime;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;

	// collections
	private java.util.Set<jkt.hms.masters.business.DietDemandRationStrength> dietDemandRationStrengths;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native"
	 *               column="diet_demand_ration_header_id"
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
	 * Return the value associated with the column: ration_type
	 */
	public java.lang.String getRationType() {
		return rationType;
	}

	/**
	 * Set the value related to the column: ration_type
	 * 
	 * @param rationType
	 *            the ration_type value
	 */
	public void setRationType(java.lang.String rationType) {
		this.rationType = rationType;
	}

	/**
	 * Return the value associated with the column: demand_sr_no
	 */
	public java.lang.String getDemandSrNo() {
		return demandSrNo;
	}

	/**
	 * Set the value related to the column: demand_sr_no
	 * 
	 * @param demandSrNo
	 *            the demand_sr_no value
	 */
	public void setDemandSrNo(java.lang.String demandSrNo) {
		this.demandSrNo = demandSrNo;
	}

	/**
	 * Return the value associated with the column: mess_name
	 */
	public java.lang.String getMessName() {
		return messName;
	}

	/**
	 * Set the value related to the column: mess_name
	 * 
	 * @param messName
	 *            the mess_name value
	 */
	public void setMessName(java.lang.String messName) {
		this.messName = messName;
	}

	/**
	 * Return the value associated with the column: unit
	 */
	public java.lang.String getUnit() {
		return unit;
	}

	/**
	 * Set the value related to the column: unit
	 * 
	 * @param unit
	 *            the unit value
	 */
	public void setUnit(java.lang.String unit) {
		this.unit = unit;
	}

	/**
	 * Return the value associated with the column: demand_from_date
	 */
	public java.util.Date getDemandFromDate() {
		return demandFromDate;
	}

	/**
	 * Set the value related to the column: demand_from_date
	 * 
	 * @param demandFromDate
	 *            the demand_from_date value
	 */
	public void setDemandFromDate(java.util.Date demandFromDate) {
		this.demandFromDate = demandFromDate;
	}

	/**
	 * Return the value associated with the column: demand_to_date
	 */
	public java.util.Date getDemandToDate() {
		return demandToDate;
	}

	/**
	 * Set the value related to the column: demand_to_date
	 * 
	 * @param demandToDate
	 *            the demand_to_date value
	 */
	public void setDemandToDate(java.util.Date demandToDate) {
		this.demandToDate = demandToDate;
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
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital() {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * 
	 * @param hospital
	 *            the hospital_id value
	 */
	public void setHospital(jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}

	/**
	 * Return the value associated with the column: DietDemandRationStrengths
	 */
	public java.util.Set<jkt.hms.masters.business.DietDemandRationStrength> getDietDemandRationStrengths() {
		return dietDemandRationStrengths;
	}

	/**
	 * Set the value related to the column: DietDemandRationStrengths
	 * 
	 * @param dietDemandRationStrengths
	 *            the DietDemandRationStrengths value
	 */
	public void setDietDemandRationStrengths(
			java.util.Set<jkt.hms.masters.business.DietDemandRationStrength> dietDemandRationStrengths) {
		this.dietDemandRationStrengths = dietDemandRationStrengths;
	}

	public void addToDietDemandRationStrengths(
			jkt.hms.masters.business.DietDemandRationStrength dietDemandRationStrength) {
		if (null == getDietDemandRationStrengths())
			setDietDemandRationStrengths(new java.util.TreeSet<jkt.hms.masters.business.DietDemandRationStrength>());
		getDietDemandRationStrengths().add(dietDemandRationStrength);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.DietDemandRationHeader))
			return false;
		else {
			jkt.hms.masters.business.DietDemandRationHeader dietDemandRationHeader = (jkt.hms.masters.business.DietDemandRationHeader) obj;
			if (null == this.getId() || null == dietDemandRationHeader.getId())
				return false;
			else
				return (this.getId().equals(dietDemandRationHeader.getId()));
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
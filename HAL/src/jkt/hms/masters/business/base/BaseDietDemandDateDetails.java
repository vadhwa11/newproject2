package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the diet_demand_date_details
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="diet_demand_date_details"
 */

public abstract class BaseDietDemandDateDetails implements Serializable {

	public static String REF = "DietDemandDateDetails";
	public static String PROP_DIET_DEMAND_RATION_HEADER = "DietDemandRationHeader";
	public static String PROP_DEMAND_DATE = "DemandDate";
	public static String PROP_ID = "Id";

	// constructors
	public BaseDietDemandDateDetails() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDietDemandDateDetails(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date demandDate;

	// many to one
	private jkt.hms.masters.business.DietDemandRationHeader dietDemandRationHeader;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native"
	 *               column="diet_demand_date_details_id"
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
	 * Return the value associated with the column: demand_date
	 */
	public java.util.Date getDemandDate() {
		return demandDate;
	}

	/**
	 * Set the value related to the column: demand_date
	 * 
	 * @param demandDate
	 *            the demand_date value
	 */
	public void setDemandDate(java.util.Date demandDate) {
		this.demandDate = demandDate;
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

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.DietDemandDateDetails))
			return false;
		else {
			jkt.hms.masters.business.DietDemandDateDetails dietDemandDateDetails = (jkt.hms.masters.business.DietDemandDateDetails) obj;
			if (null == this.getId() || null == dietDemandDateDetails.getId())
				return false;
			else
				return (this.getId().equals(dietDemandDateDetails.getId()));
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
package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the diet_demand_ration_items
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="diet_demand_ration_items"
 */

public abstract class BaseDietDemandRationItems implements Serializable {

	public static String REF = "DietDemandRationItems";
	public static String PROP_DEMAND_QUANTITY = "DemandQuantity";
	public static String PROP_CHANGED_DATE = "ChangedDate";
	public static String PROP_ITEM = "Item";
	public static String PROP_DIET_DEMAND_RATION_HEADER = "DietDemandRationHeader";
	public static String PROP_CHANGED_TIME = "ChangedTime";
	public static String PROP_ID = "Id";
	public static String PROP_CHANGED_BY = "ChangedBy";
	public static String PROP_REMARKS = "Remarks";

	// constructors
	public BaseDietDemandRationItems() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDietDemandRationItems(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.math.BigDecimal demandQuantity;
	private java.lang.String remarks;
	private java.lang.String changedBy;
	private java.util.Date changedDate;
	private java.lang.String changedTime;

	// many to one
	private jkt.hms.masters.business.DietDemandRationHeader dietDemandRationHeader;
	private jkt.hms.masters.business.MasDietIndentItem item;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native"
	 *               column="diet_demand_ration_items_id"
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
	 * Return the value associated with the column: demand_quantity
	 */
	public java.math.BigDecimal getDemandQuantity() {
		return demandQuantity;
	}

	/**
	 * Set the value related to the column: demand_quantity
	 * 
	 * @param demandQuantity
	 *            the demand_quantity value
	 */
	public void setDemandQuantity(java.math.BigDecimal demandQuantity) {
		this.demandQuantity = demandQuantity;
	}

	/**
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks() {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * 
	 * @param remarks
	 *            the remarks value
	 */
	public void setRemarks(java.lang.String remarks) {
		this.remarks = remarks;
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
	 * Return the value associated with the column: item_id
	 */
	public jkt.hms.masters.business.MasDietIndentItem getItem() {
		return item;
	}

	/**
	 * Set the value related to the column: item_id
	 * 
	 * @param item
	 *            the item_id value
	 */
	public void setItem(jkt.hms.masters.business.MasDietIndentItem item) {
		this.item = item;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.DietDemandRationItems))
			return false;
		else {
			jkt.hms.masters.business.DietDemandRationItems dietDemandRationItems = (jkt.hms.masters.business.DietDemandRationItems) obj;
			if (null == this.getId() || null == dietDemandRationItems.getId())
				return false;
			else
				return (this.getId().equals(dietDemandRationItems.getId()));
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
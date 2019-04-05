package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the diet_breakfast_summary
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="diet_breakfast_summary"
 */

public abstract class BaseDietBreakfastSummary implements Serializable {

	public static String REF = "DietBreakfastSummary";
	public static String PROP_MESS_ITEM_QTY = "MessItemQty";
	public static String PROP_SUMMARY_DATE = "SummaryDate";
	public static String PROP_CHANGED_DATE = "ChangedDate";
	public static String PROP_ITEM = "Item";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_WARD_ITEM_QTY = "WardItemQty";
	public static String PROP_WARD_EGG_QTY = "WardEggQty";
	public static String PROP_CHANGED_TIME = "ChangedTime";
	public static String PROP_MESS_EGG_QTY = "MessEggQty";
	public static String PROP_ID = "Id";
	public static String PROP_CHANGED_BY = "ChangedBy";

	// constructors
	public BaseDietBreakfastSummary() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDietBreakfastSummary(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer messItemQty;
	private java.lang.Integer wardItemQty;
	private java.lang.Integer messEggQty;
	private java.lang.Integer wardEggQty;
	private java.util.Date summaryDate;
	private java.lang.String changedBy;
	private java.util.Date changedDate;
	private java.lang.String changedTime;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDietMenuItem item;

	// collections
	private java.util.Set<jkt.hms.masters.business.DietWardBreakfastSummary> dietWardBreakfastSummaries;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="breakfast_summary_id"
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
	 * Return the value associated with the column: mess_item_qty
	 */
	public java.lang.Integer getMessItemQty() {
		return messItemQty;
	}

	/**
	 * Set the value related to the column: mess_item_qty
	 * 
	 * @param messItemQty
	 *            the mess_item_qty value
	 */
	public void setMessItemQty(java.lang.Integer messItemQty) {
		this.messItemQty = messItemQty;
	}

	/**
	 * Return the value associated with the column: ward_item_qty
	 */
	public java.lang.Integer getWardItemQty() {
		return wardItemQty;
	}

	/**
	 * Set the value related to the column: ward_item_qty
	 * 
	 * @param wardItemQty
	 *            the ward_item_qty value
	 */
	public void setWardItemQty(java.lang.Integer wardItemQty) {
		this.wardItemQty = wardItemQty;
	}

	/**
	 * Return the value associated with the column: mess_egg_qty
	 */
	public java.lang.Integer getMessEggQty() {
		return messEggQty;
	}

	/**
	 * Set the value related to the column: mess_egg_qty
	 * 
	 * @param messEggQty
	 *            the mess_egg_qty value
	 */
	public void setMessEggQty(java.lang.Integer messEggQty) {
		this.messEggQty = messEggQty;
	}

	/**
	 * Return the value associated with the column: ward_egg_qty
	 */
	public java.lang.Integer getWardEggQty() {
		return wardEggQty;
	}

	/**
	 * Set the value related to the column: ward_egg_qty
	 * 
	 * @param wardEggQty
	 *            the ward_egg_qty value
	 */
	public void setWardEggQty(java.lang.Integer wardEggQty) {
		this.wardEggQty = wardEggQty;
	}

	/**
	 * Return the value associated with the column: summary_date
	 */
	public java.util.Date getSummaryDate() {
		return summaryDate;
	}

	/**
	 * Set the value related to the column: summary_date
	 * 
	 * @param summaryDate
	 *            the summary_date value
	 */
	public void setSummaryDate(java.util.Date summaryDate) {
		this.summaryDate = summaryDate;
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
	 * Return the value associated with the column: item_id
	 */
	public jkt.hms.masters.business.MasDietMenuItem getItem() {
		return item;
	}

	/**
	 * Set the value related to the column: item_id
	 * 
	 * @param item
	 *            the item_id value
	 */
	public void setItem(jkt.hms.masters.business.MasDietMenuItem item) {
		this.item = item;
	}

	/**
	 * Return the value associated with the column: DietWardBreakfastSummaries
	 */
	public java.util.Set<jkt.hms.masters.business.DietWardBreakfastSummary> getDietWardBreakfastSummaries() {
		return dietWardBreakfastSummaries;
	}

	/**
	 * Set the value related to the column: DietWardBreakfastSummaries
	 * 
	 * @param dietWardBreakfastSummaries
	 *            the DietWardBreakfastSummaries value
	 */
	public void setDietWardBreakfastSummaries(
			java.util.Set<jkt.hms.masters.business.DietWardBreakfastSummary> dietWardBreakfastSummaries) {
		this.dietWardBreakfastSummaries = dietWardBreakfastSummaries;
	}

	public void addToDietWardBreakfastSummaries(
			jkt.hms.masters.business.DietWardBreakfastSummary dietWardBreakfastSummary) {
		if (null == getDietWardBreakfastSummaries())
			setDietWardBreakfastSummaries(new java.util.TreeSet<jkt.hms.masters.business.DietWardBreakfastSummary>());
		getDietWardBreakfastSummaries().add(dietWardBreakfastSummary);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.DietBreakfastSummary))
			return false;
		else {
			jkt.hms.masters.business.DietBreakfastSummary dietBreakfastSummary = (jkt.hms.masters.business.DietBreakfastSummary) obj;
			if (null == this.getId() || null == dietBreakfastSummary.getId())
				return false;
			else
				return (this.getId().equals(dietBreakfastSummary.getId()));
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
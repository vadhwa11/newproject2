package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * diet_ward_breakfast_summary table. Do not modify this class because it will
 * be overwritten if the configuration file related to this class is modified.
 * 
 * @hibernate.class table="diet_ward_breakfast_summary"
 */

public abstract class BaseDietWardBreakfastSummary implements Serializable {

	public static String REF = "DietWardBreakfastSummary";
	public static String PROP_BREAKFAST_SUMMARY = "BreakfastSummary";
	public static String PROP_SUMMARY_DATE = "SummaryDate";
	public static String PROP_EGGS_QTY = "EggsQty";
	public static String PROP_CHANGED_DATE = "ChangedDate";
	public static String PROP_BREAD_QTY = "BreadQty";
	public static String PROP_CHANGED_TIME = "ChangedTime";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_ID = "Id";
	public static String PROP_CHANGED_BY = "ChangedBy";

	// constructors
	public BaseDietWardBreakfastSummary() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDietWardBreakfastSummary(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer breadQty;
	private java.lang.Integer eggsQty;
	private java.util.Date summaryDate;
	private java.lang.String changedBy;
	private java.util.Date changedDate;
	private java.lang.String changedTime;

	// many to one
	private jkt.hms.masters.business.DietBreakfastSummary breakfastSummary;
	private jkt.hms.masters.business.MasDepartment department;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="ward_breakfast_summary_id"
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
	 * Return the value associated with the column: bread_qty
	 */
	public java.lang.Integer getBreadQty() {
		return breadQty;
	}

	/**
	 * Set the value related to the column: bread_qty
	 * 
	 * @param breadQty
	 *            the bread_qty value
	 */
	public void setBreadQty(java.lang.Integer breadQty) {
		this.breadQty = breadQty;
	}

	/**
	 * Return the value associated with the column: eggs_qty
	 */
	public java.lang.Integer getEggsQty() {
		return eggsQty;
	}

	/**
	 * Set the value related to the column: eggs_qty
	 * 
	 * @param eggsQty
	 *            the eggs_qty value
	 */
	public void setEggsQty(java.lang.Integer eggsQty) {
		this.eggsQty = eggsQty;
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
	 * Return the value associated with the column: breakfast_summary_id
	 */
	public jkt.hms.masters.business.DietBreakfastSummary getBreakfastSummary() {
		return breakfastSummary;
	}

	/**
	 * Set the value related to the column: breakfast_summary_id
	 * 
	 * @param breakfastSummary
	 *            the breakfast_summary_id value
	 */
	public void setBreakfastSummary(
			jkt.hms.masters.business.DietBreakfastSummary breakfastSummary) {
		this.breakfastSummary = breakfastSummary;
	}

	/**
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment() {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * 
	 * @param department
	 *            the department_id value
	 */
	public void setDepartment(jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.DietWardBreakfastSummary))
			return false;
		else {
			jkt.hms.masters.business.DietWardBreakfastSummary dietWardBreakfastSummary = (jkt.hms.masters.business.DietWardBreakfastSummary) obj;
			if (null == this.getId()
					|| null == dietWardBreakfastSummary.getId())
				return false;
			else
				return (this.getId().equals(dietWardBreakfastSummary.getId()));
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
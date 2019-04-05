package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the diet_daily_extra_summary
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="diet_daily_extra_summary"
 */

public abstract class BaseDietDailyExtraSummary implements Serializable {

	public static String REF = "DietDailyExtraSummary";
	public static String PROP_DIET_SUMMARY_DATE = "DietSummaryDate";
	public static String PROP_INDENT_ITEM = "IndentItem";
	public static String PROP_EXTRA_ITEM_QTY = "ExtraItemQty";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_UNIT = "Unit";

	// constructors
	public BaseDietDailyExtraSummary() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDietDailyExtraSummary(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer extraItemQty;
	private java.util.Date dietSummaryDate;

	// many to one
	private jkt.hms.masters.business.MasDietIndentItem indentItem;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasStoreUnit unit;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="extra_diet_summary_id"
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
	 * Return the value associated with the column: extra_item_qty
	 */
	public java.lang.Integer getExtraItemQty() {
		return extraItemQty;
	}

	/**
	 * Set the value related to the column: extra_item_qty
	 * 
	 * @param extraItemQty
	 *            the extra_item_qty value
	 */
	public void setExtraItemQty(java.lang.Integer extraItemQty) {
		this.extraItemQty = extraItemQty;
	}

	/**
	 * Return the value associated with the column: diet_summary_date
	 */
	public java.util.Date getDietSummaryDate() {
		return dietSummaryDate;
	}

	/**
	 * Set the value related to the column: diet_summary_date
	 * 
	 * @param dietSummaryDate
	 *            the diet_summary_date value
	 */
	public void setDietSummaryDate(java.util.Date dietSummaryDate) {
		this.dietSummaryDate = dietSummaryDate;
	}

	/**
	 * Return the value associated with the column: indent_item_id
	 */
	public jkt.hms.masters.business.MasDietIndentItem getIndentItem() {
		return indentItem;
	}

	/**
	 * Set the value related to the column: indent_item_id
	 * 
	 * @param indentItem
	 *            the indent_item_id value
	 */
	public void setIndentItem(
			jkt.hms.masters.business.MasDietIndentItem indentItem) {
		this.indentItem = indentItem;
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

	/**
	 * Return the value associated with the column: unit_id
	 */
	public jkt.hms.masters.business.MasStoreUnit getUnit() {
		return unit;
	}

	/**
	 * Set the value related to the column: unit_id
	 * 
	 * @param unit
	 *            the unit_id value
	 */
	public void setUnit(jkt.hms.masters.business.MasStoreUnit unit) {
		this.unit = unit;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.DietDailyExtraSummary))
			return false;
		else {
			jkt.hms.masters.business.DietDailyExtraSummary dietDailyExtraSummary = (jkt.hms.masters.business.DietDailyExtraSummary) obj;
			if (null == this.getId() || null == dietDailyExtraSummary.getId())
				return false;
			else
				return (this.getId().equals(dietDailyExtraSummary.getId()));
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
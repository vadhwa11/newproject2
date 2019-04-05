package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the diet_extra_item_formula
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="diet_extra_item_formula"
 */

public abstract class BaseDietExtraItemFormula implements Serializable {

	public static String REF = "DietExtraItemFormula";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_VALIDITY_START_DATE = "ValidityStartDate";
	public static String PROP_EXTRA_SCALE = "ExtraScale";
	public static String PROP_UNIT = "Unit";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_INDENT_ITEM = "IndentItem";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ID = "Id";

	// constructors
	public BaseDietExtraItemFormula() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDietExtraItemFormula(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer extraScale;
	private java.util.Date validityStartDate;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasDietIndentItem indentItem;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasStoreUnit unit;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="extra_item_formula_id"
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
	 * Return the value associated with the column: extra_scale
	 */
	public java.lang.Integer getExtraScale() {
		return extraScale;
	}

	/**
	 * Set the value related to the column: extra_scale
	 * 
	 * @param extraScale
	 *            the extra_scale value
	 */
	public void setExtraScale(java.lang.Integer extraScale) {
		this.extraScale = extraScale;
	}

	/**
	 * Return the value associated with the column: validity_start_date
	 */
	public java.util.Date getValidityStartDate() {
		return validityStartDate;
	}

	/**
	 * Set the value related to the column: validity_start_date
	 * 
	 * @param validityStartDate
	 *            the validity_start_date value
	 */
	public void setValidityStartDate(java.util.Date validityStartDate) {
		this.validityStartDate = validityStartDate;
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
		if (!(obj instanceof jkt.hms.masters.business.DietExtraItemFormula))
			return false;
		else {
			jkt.hms.masters.business.DietExtraItemFormula dietExtraItemFormula = (jkt.hms.masters.business.DietExtraItemFormula) obj;
			if (null == this.getId() || null == dietExtraItemFormula.getId())
				return false;
			else
				return (this.getId().equals(dietExtraItemFormula.getId()));
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
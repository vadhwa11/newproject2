package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the diet_menu_item_formula
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="diet_menu_item_formula"
 */

public abstract class BaseDietMenuItemFormula implements Serializable {

	public static String REF = "DietMenuItemFormula";
	public static String PROP_STATUS = "Status";
	public static String PROP_VALIDITY_START_DATE = "ValidityStartDate";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_MENU_TYPE = "MenuType";
	public static String PROP_UNIT = "Unit";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DIET_ITEMS = "DietItems";
	public static String PROP_DIET_COMBINATION = "DietCombination";
	public static String PROP_PATIENT_CATEGORY = "PatientCategory";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_QUANTITY = "Quantity";
	public static String PROP_ID = "Id";

	// constructors
	public BaseDietMenuItemFormula() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDietMenuItemFormula(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String menuType;
	private java.math.BigDecimal quantity;
	private java.util.Date validityStartDate;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String patientCategory;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDietItems dietItems;
	private jkt.hms.masters.business.MasStoreUnit unit;
	private jkt.hms.masters.business.MasDietCombination dietCombination;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="menu_item_formula_id"
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
	 * Return the value associated with the column: menu_type
	 */
	public java.lang.String getMenuType() {
		return menuType;
	}

	/**
	 * Set the value related to the column: menu_type
	 * 
	 * @param menuType
	 *            the menu_type value
	 */
	public void setMenuType(java.lang.String menuType) {
		this.menuType = menuType;
	}

	/**
	 * Return the value associated with the column: quantity
	 */
	public java.math.BigDecimal getQuantity() {
		return quantity;
	}

	/**
	 * Set the value related to the column: quantity
	 * 
	 * @param quantity
	 *            the quantity value
	 */
	public void setQuantity(java.math.BigDecimal quantity) {
		this.quantity = quantity;
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
	 * Return the value associated with the column: patient_category
	 */
	public java.lang.String getPatientCategory() {
		return patientCategory;
	}

	/**
	 * Set the value related to the column: patient_category
	 * 
	 * @param patientCategory
	 *            the patient_category value
	 */
	public void setPatientCategory(java.lang.String patientCategory) {
		this.patientCategory = patientCategory;
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
	 * Return the value associated with the column: diet_items_id
	 */
	public jkt.hms.masters.business.MasDietItems getDietItems() {
		return dietItems;
	}

	/**
	 * Set the value related to the column: diet_items_id
	 * 
	 * @param dietItems
	 *            the diet_items_id value
	 */
	public void setDietItems(jkt.hms.masters.business.MasDietItems dietItems) {
		this.dietItems = dietItems;
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
		if (!(obj instanceof jkt.hms.masters.business.DietMenuItemFormula))
			return false;
		else {
			jkt.hms.masters.business.DietMenuItemFormula dietMenuItemFormula = (jkt.hms.masters.business.DietMenuItemFormula) obj;
			if (null == this.getId() || null == dietMenuItemFormula.getId())
				return false;
			else
				return (this.getId().equals(dietMenuItemFormula.getId()));
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
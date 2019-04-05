package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_icd_main_category
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="mas_icd_main_category"
 */

public abstract class BaseMasIcdMainCategory implements Serializable {

	public static String REF = "MasIcdMainCategory";
	public static String PROP_STATUS = "Status";
	public static String PROP_ICD_MAINCATEGORY_NAME = "IcdMaincategoryName";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ICD_MAINCATEGORY_CODE = "IcdMaincategoryCode";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ID = "Id";

	// constructors
	public BaseMasIcdMainCategory() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasIcdMainCategory(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String icdMaincategoryCode;
	private java.lang.String icdMaincategoryName;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// collections
	private java.util.Set<jkt.hms.masters.business.MasIcdSubCategory> masIcdSubCategories;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="icd_maincategory_id"
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
	 * Return the value associated with the column: icd_maincategory_code
	 */
	public java.lang.String getIcdMaincategoryCode() {
		return icdMaincategoryCode;
	}

	/**
	 * Set the value related to the column: icd_maincategory_code
	 * 
	 * @param icdMaincategoryCode
	 *            the icd_maincategory_code value
	 */
	public void setIcdMaincategoryCode(java.lang.String icdMaincategoryCode) {
		this.icdMaincategoryCode = icdMaincategoryCode;
	}

	/**
	 * Return the value associated with the column: icd_maincategory_name
	 */
	public java.lang.String getIcdMaincategoryName() {
		return icdMaincategoryName;
	}

	/**
	 * Set the value related to the column: icd_maincategory_name
	 * 
	 * @param icdMaincategoryName
	 *            the icd_maincategory_name value
	 */
	public void setIcdMaincategoryName(java.lang.String icdMaincategoryName) {
		this.icdMaincategoryName = icdMaincategoryName;
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
	 * Return the value associated with the column: MasIcdSubCategories
	 */
	public java.util.Set<jkt.hms.masters.business.MasIcdSubCategory> getMasIcdSubCategories() {
		return masIcdSubCategories;
	}

	/**
	 * Set the value related to the column: MasIcdSubCategories
	 * 
	 * @param masIcdSubCategories
	 *            the MasIcdSubCategories value
	 */
	public void setMasIcdSubCategories(
			java.util.Set<jkt.hms.masters.business.MasIcdSubCategory> masIcdSubCategories) {
		this.masIcdSubCategories = masIcdSubCategories;
	}

	public void addToMasIcdSubCategories(
			jkt.hms.masters.business.MasIcdSubCategory masIcdSubCategory) {
		if (null == getMasIcdSubCategories())
			setMasIcdSubCategories(new java.util.TreeSet<jkt.hms.masters.business.MasIcdSubCategory>());
		getMasIcdSubCategories().add(masIcdSubCategory);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MasIcdMainCategory))
			return false;
		else {
			jkt.hms.masters.business.MasIcdMainCategory masIcdMainCategory = (jkt.hms.masters.business.MasIcdMainCategory) obj;
			if (null == this.getId() || null == masIcdMainCategory.getId())
				return false;
			else
				return (this.getId().equals(masIcdMainCategory.getId()));
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
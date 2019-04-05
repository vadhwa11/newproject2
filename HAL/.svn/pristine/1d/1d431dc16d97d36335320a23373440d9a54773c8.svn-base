package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_icd_sub_category
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="mas_icd_sub_category"
 */

public abstract class BaseMasIcdSubCategory implements Serializable {

	public static String REF = "MasIcdSubCategory";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ICD_SUB_CATEGORY_CODE = "IcdSubCategoryCode";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ICD_SUB_CATEGORY_NAME = "IcdSubCategoryName";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ID = "Id";
	public static String PROP_ICD_MAINCATEGORY = "IcdMaincategory";

	// constructors
	public BaseMasIcdSubCategory() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasIcdSubCategory(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String icdSubCategoryCode;
	private java.lang.String icdSubCategoryName;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasIcdMainCategory icdMaincategory;

	// collections
	private java.util.Set<jkt.hms.masters.business.MasIcd> masIcds;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="icd_sub_category_id"
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
	 * Return the value associated with the column: icd_sub_category_code
	 */
	public java.lang.String getIcdSubCategoryCode() {
		return icdSubCategoryCode;
	}

	/**
	 * Set the value related to the column: icd_sub_category_code
	 * 
	 * @param icdSubCategoryCode
	 *            the icd_sub_category_code value
	 */
	public void setIcdSubCategoryCode(java.lang.String icdSubCategoryCode) {
		this.icdSubCategoryCode = icdSubCategoryCode;
	}

	/**
	 * Return the value associated with the column: icd_sub_category_name
	 */
	public java.lang.String getIcdSubCategoryName() {
		return icdSubCategoryName;
	}

	/**
	 * Set the value related to the column: icd_sub_category_name
	 * 
	 * @param icdSubCategoryName
	 *            the icd_sub_category_name value
	 */
	public void setIcdSubCategoryName(java.lang.String icdSubCategoryName) {
		this.icdSubCategoryName = icdSubCategoryName;
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
	 * Return the value associated with the column: icd_maincategory_id
	 */
	public jkt.hms.masters.business.MasIcdMainCategory getIcdMaincategory() {
		return icdMaincategory;
	}

	/**
	 * Set the value related to the column: icd_maincategory_id
	 * 
	 * @param icdMaincategory
	 *            the icd_maincategory_id value
	 */
	public void setIcdMaincategory(
			jkt.hms.masters.business.MasIcdMainCategory icdMaincategory) {
		this.icdMaincategory = icdMaincategory;
	}

	/**
	 * Return the value associated with the column: MasIcds
	 */
	public java.util.Set<jkt.hms.masters.business.MasIcd> getMasIcds() {
		return masIcds;
	}

	/**
	 * Set the value related to the column: MasIcds
	 * 
	 * @param masIcds
	 *            the MasIcds value
	 */
	public void setMasIcds(
			java.util.Set<jkt.hms.masters.business.MasIcd> masIcds) {
		this.masIcds = masIcds;
	}

	public void addToMasIcds(jkt.hms.masters.business.MasIcd masIcd) {
		if (null == getMasIcds())
			setMasIcds(new java.util.TreeSet<jkt.hms.masters.business.MasIcd>());
		getMasIcds().add(masIcd);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MasIcdSubCategory))
			return false;
		else {
			jkt.hms.masters.business.MasIcdSubCategory masIcdSubCategory = (jkt.hms.masters.business.MasIcdSubCategory) obj;
			if (null == this.getId() || null == masIcdSubCategory.getId())
				return false;
			else
				return (this.getId().equals(masIcdSubCategory.getId()));
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
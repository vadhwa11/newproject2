package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_item_category table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="mas_item_category"
 */

public abstract class BaseMasItemCategory implements Serializable {

	public static String REF = "MasItemCategory";
	public static String PROP_STATUS = "Status";
	public static String PROP_SECTION = "Section";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ITEM_CATEGORY_CODE = "ItemCategoryCode";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ITEM_CATEGORY_NAME = "ItemCategoryName";
	public static String PROP_ID = "Id";

	// constructors
	public BaseMasItemCategory() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasItemCategory(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseMasItemCategory(java.lang.Integer id, java.lang.String status) {

		this.setId(id);
		this.setStatus(status);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String itemCategoryCode;
	private java.lang.String itemCategoryName;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasStoreSection section;

	// collections
	private java.util.Set<jkt.hms.masters.business.MasStoreItem> masStoreItems;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="item_category_id"
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
	 * Return the value associated with the column: item_category_code
	 */
	public java.lang.String getItemCategoryCode() {
		return itemCategoryCode;
	}

	/**
	 * Set the value related to the column: item_category_code
	 * 
	 * @param itemCategoryCode
	 *            the item_category_code value
	 */
	public void setItemCategoryCode(java.lang.String itemCategoryCode) {
		this.itemCategoryCode = itemCategoryCode;
	}

	/**
	 * Return the value associated with the column: item_category_name
	 */
	public java.lang.String getItemCategoryName() {
		return itemCategoryName;
	}

	/**
	 * Set the value related to the column: item_category_name
	 * 
	 * @param itemCategoryName
	 *            the item_category_name value
	 */
	public void setItemCategoryName(java.lang.String itemCategoryName) {
		this.itemCategoryName = itemCategoryName;
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
	 * Return the value associated with the column: section_id
	 */
	public jkt.hms.masters.business.MasStoreSection getSection() {
		return section;
	}

	/**
	 * Set the value related to the column: section_id
	 * 
	 * @param section
	 *            the section_id value
	 */
	public void setSection(jkt.hms.masters.business.MasStoreSection section) {
		this.section = section;
	}

	/**
	 * Return the value associated with the column: MasStoreItems
	 */
	public java.util.Set<jkt.hms.masters.business.MasStoreItem> getMasStoreItems() {
		return masStoreItems;
	}

	/**
	 * Set the value related to the column: MasStoreItems
	 * 
	 * @param masStoreItems
	 *            the MasStoreItems value
	 */
	public void setMasStoreItems(
			java.util.Set<jkt.hms.masters.business.MasStoreItem> masStoreItems) {
		this.masStoreItems = masStoreItems;
	}

	public void addToMasStoreItems(
			jkt.hms.masters.business.MasStoreItem masStoreItem) {
		if (null == getMasStoreItems())
			setMasStoreItems(new java.util.TreeSet<jkt.hms.masters.business.MasStoreItem>());
		getMasStoreItems().add(masStoreItem);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MasItemCategory))
			return false;
		else {
			jkt.hms.masters.business.MasItemCategory masItemCategory = (jkt.hms.masters.business.MasItemCategory) obj;
			if (null == this.getId() || null == masItemCategory.getId())
				return false;
			else
				return (this.getId().equals(masItemCategory.getId()));
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
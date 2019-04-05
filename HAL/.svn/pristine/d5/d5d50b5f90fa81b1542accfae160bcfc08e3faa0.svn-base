package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the item_master table. Do not
 * modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * 
 * @hibernate.class table="item_master"
 */

public abstract class BaseItemMaster implements Serializable {

	public static String REF = "ItemMaster";
	public static String PROP_ITEM_DESCRIPTION = "ItemDescription";
	public static String PROP_STATUS_ID = "StatusId";
	public static String PROP_MAX_RETAIL_PRICE = "MaxRetailPrice";
	public static String PROP_UOM_ID = "UomId";
	public static String PROP_DISPLAY_PRICE = "DisplayPrice";
	public static String PROP_FIXED_ASSET = "FixedAsset";
	public static String PROP_ITEM_CODE = "ItemCode";
	public static String PROP_LEAD_TIME = "LeadTime";
	public static String PROP_LAST_CHGD_DATETIME = "LastChgdDatetime";
	public static String PROP_MANUFACTURER = "Manufacturer";
	public static String PROP_LAST_CHGD_BY = "LastChgdBy";
	public static String PROP_ST_GROUP_ID = "StGroupId";
	public static String PROP_ITEM_CATEGORY_ID = "ItemCategoryId";
	public static String PROP_RE_ORDER_QUANTITY = "ReOrderQuantity";
	public static String PROP_ITEM_CLASS_ID = "ItemClassId";
	public static String PROP_MAX_STOCK_LEVEL = "MaxStockLevel";
	public static String PROP_RE_ORDER_LEVEL = "ReOrderLevel";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_MARKUP_CATEGORY_ID = "MarkupCategoryId";
	public static String PROP_ITEM_TYPE_ID = "ItemTypeId";
	public static String PROP_UNIT_PRICE = "UnitPrice";
	public static String PROP_MIN_STOCK_LEVEL = "MinStockLevel";
	public static String PROP_ID = "Id";
	public static String PROP_ITEM_GROUP_ID = "ItemGroupId";

	// constructors
	public BaseItemMaster() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseItemMaster(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer hospitalId;
	private java.lang.String itemCode;
	private java.lang.String itemDescription;
	private java.lang.String itemTypeId;
	private java.lang.String itemGroupId;
	private java.lang.String uomId;
	private java.lang.String stGroupId;
	private java.lang.Float reOrderLevel;
	private java.lang.Float reOrderQuantity;
	private java.lang.Float maxStockLevel;
	private java.lang.Float minStockLevel;
	private java.lang.String markupCategoryId;
	private java.lang.Integer leadTime;
	private java.lang.Integer fixedAsset;
	private java.lang.String itemClassId;
	private java.lang.String itemCategoryId;
	private java.lang.Float unitPrice;
	private java.lang.Double maxRetailPrice;
	private java.lang.Double displayPrice;
	private java.lang.String manufacturer;
	private java.lang.String lastChgdBy;
	private java.util.Date lastChgdDatetime;
	private java.lang.Integer statusId;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="item_id"
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
	 * Return the value associated with the column: hospital_id
	 */
	public java.lang.Integer getHospitalId() {
		return hospitalId;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * 
	 * @param hospitalId
	 *            the hospital_id value
	 */
	public void setHospitalId(java.lang.Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	/**
	 * Return the value associated with the column: item_code
	 */
	public java.lang.String getItemCode() {
		return itemCode;
	}

	/**
	 * Set the value related to the column: item_code
	 * 
	 * @param itemCode
	 *            the item_code value
	 */
	public void setItemCode(java.lang.String itemCode) {
		this.itemCode = itemCode;
	}

	/**
	 * Return the value associated with the column: item_description
	 */
	public java.lang.String getItemDescription() {
		return itemDescription;
	}

	/**
	 * Set the value related to the column: item_description
	 * 
	 * @param itemDescription
	 *            the item_description value
	 */
	public void setItemDescription(java.lang.String itemDescription) {
		this.itemDescription = itemDescription;
	}

	/**
	 * Return the value associated with the column: item_type_id
	 */
	public java.lang.String getItemTypeId() {
		return itemTypeId;
	}

	/**
	 * Set the value related to the column: item_type_id
	 * 
	 * @param itemTypeId
	 *            the item_type_id value
	 */
	public void setItemTypeId(java.lang.String itemTypeId) {
		this.itemTypeId = itemTypeId;
	}

	/**
	 * Return the value associated with the column: item_group_id
	 */
	public java.lang.String getItemGroupId() {
		return itemGroupId;
	}

	/**
	 * Set the value related to the column: item_group_id
	 * 
	 * @param itemGroupId
	 *            the item_group_id value
	 */
	public void setItemGroupId(java.lang.String itemGroupId) {
		this.itemGroupId = itemGroupId;
	}

	/**
	 * Return the value associated with the column: uom_id
	 */
	public java.lang.String getUomId() {
		return uomId;
	}

	/**
	 * Set the value related to the column: uom_id
	 * 
	 * @param uomId
	 *            the uom_id value
	 */
	public void setUomId(java.lang.String uomId) {
		this.uomId = uomId;
	}

	/**
	 * Return the value associated with the column: st_group_id
	 */
	public java.lang.String getStGroupId() {
		return stGroupId;
	}

	/**
	 * Set the value related to the column: st_group_id
	 * 
	 * @param stGroupId
	 *            the st_group_id value
	 */
	public void setStGroupId(java.lang.String stGroupId) {
		this.stGroupId = stGroupId;
	}

	/**
	 * Return the value associated with the column: re_order_level
	 */
	public java.lang.Float getReOrderLevel() {
		return reOrderLevel;
	}

	/**
	 * Set the value related to the column: re_order_level
	 * 
	 * @param reOrderLevel
	 *            the re_order_level value
	 */
	public void setReOrderLevel(java.lang.Float reOrderLevel) {
		this.reOrderLevel = reOrderLevel;
	}

	/**
	 * Return the value associated with the column: re_order_quantity
	 */
	public java.lang.Float getReOrderQuantity() {
		return reOrderQuantity;
	}

	/**
	 * Set the value related to the column: re_order_quantity
	 * 
	 * @param reOrderQuantity
	 *            the re_order_quantity value
	 */
	public void setReOrderQuantity(java.lang.Float reOrderQuantity) {
		this.reOrderQuantity = reOrderQuantity;
	}

	/**
	 * Return the value associated with the column: max_stock_level
	 */
	public java.lang.Float getMaxStockLevel() {
		return maxStockLevel;
	}

	/**
	 * Set the value related to the column: max_stock_level
	 * 
	 * @param maxStockLevel
	 *            the max_stock_level value
	 */
	public void setMaxStockLevel(java.lang.Float maxStockLevel) {
		this.maxStockLevel = maxStockLevel;
	}

	/**
	 * Return the value associated with the column: min_stock_level
	 */
	public java.lang.Float getMinStockLevel() {
		return minStockLevel;
	}

	/**
	 * Set the value related to the column: min_stock_level
	 * 
	 * @param minStockLevel
	 *            the min_stock_level value
	 */
	public void setMinStockLevel(java.lang.Float minStockLevel) {
		this.minStockLevel = minStockLevel;
	}

	/**
	 * Return the value associated with the column: markup_category_id
	 */
	public java.lang.String getMarkupCategoryId() {
		return markupCategoryId;
	}

	/**
	 * Set the value related to the column: markup_category_id
	 * 
	 * @param markupCategoryId
	 *            the markup_category_id value
	 */
	public void setMarkupCategoryId(java.lang.String markupCategoryId) {
		this.markupCategoryId = markupCategoryId;
	}

	/**
	 * Return the value associated with the column: lead_time
	 */
	public java.lang.Integer getLeadTime() {
		return leadTime;
	}

	/**
	 * Set the value related to the column: lead_time
	 * 
	 * @param leadTime
	 *            the lead_time value
	 */
	public void setLeadTime(java.lang.Integer leadTime) {
		this.leadTime = leadTime;
	}

	/**
	 * Return the value associated with the column: fixed_asset
	 */
	public java.lang.Integer getFixedAsset() {
		return fixedAsset;
	}

	/**
	 * Set the value related to the column: fixed_asset
	 * 
	 * @param fixedAsset
	 *            the fixed_asset value
	 */
	public void setFixedAsset(java.lang.Integer fixedAsset) {
		this.fixedAsset = fixedAsset;
	}

	/**
	 * Return the value associated with the column: item_class_id
	 */
	public java.lang.String getItemClassId() {
		return itemClassId;
	}

	/**
	 * Set the value related to the column: item_class_id
	 * 
	 * @param itemClassId
	 *            the item_class_id value
	 */
	public void setItemClassId(java.lang.String itemClassId) {
		this.itemClassId = itemClassId;
	}

	/**
	 * Return the value associated with the column: item_category_id
	 */
	public java.lang.String getItemCategoryId() {
		return itemCategoryId;
	}

	/**
	 * Set the value related to the column: item_category_id
	 * 
	 * @param itemCategoryId
	 *            the item_category_id value
	 */
	public void setItemCategoryId(java.lang.String itemCategoryId) {
		this.itemCategoryId = itemCategoryId;
	}

	/**
	 * Return the value associated with the column: unit_price
	 */
	public java.lang.Float getUnitPrice() {
		return unitPrice;
	}

	/**
	 * Set the value related to the column: unit_price
	 * 
	 * @param unitPrice
	 *            the unit_price value
	 */
	public void setUnitPrice(java.lang.Float unitPrice) {
		this.unitPrice = unitPrice;
	}

	/**
	 * Return the value associated with the column: max_retail_price
	 */
	public java.lang.Double getMaxRetailPrice() {
		return maxRetailPrice;
	}

	/**
	 * Set the value related to the column: max_retail_price
	 * 
	 * @param maxRetailPrice
	 *            the max_retail_price value
	 */
	public void setMaxRetailPrice(java.lang.Double maxRetailPrice) {
		this.maxRetailPrice = maxRetailPrice;
	}

	/**
	 * Return the value associated with the column: display_price
	 */
	public java.lang.Double getDisplayPrice() {
		return displayPrice;
	}

	/**
	 * Set the value related to the column: display_price
	 * 
	 * @param displayPrice
	 *            the display_price value
	 */
	public void setDisplayPrice(java.lang.Double displayPrice) {
		this.displayPrice = displayPrice;
	}

	/**
	 * Return the value associated with the column: manufacturer
	 */
	public java.lang.String getManufacturer() {
		return manufacturer;
	}

	/**
	 * Set the value related to the column: manufacturer
	 * 
	 * @param manufacturer
	 *            the manufacturer value
	 */
	public void setManufacturer(java.lang.String manufacturer) {
		this.manufacturer = manufacturer;
	}

	/**
	 * Return the value associated with the column: last_chgd_by
	 */
	public java.lang.String getLastChgdBy() {
		return lastChgdBy;
	}

	/**
	 * Set the value related to the column: last_chgd_by
	 * 
	 * @param lastChgdBy
	 *            the last_chgd_by value
	 */
	public void setLastChgdBy(java.lang.String lastChgdBy) {
		this.lastChgdBy = lastChgdBy;
	}

	/**
	 * Return the value associated with the column: last_chgd_datetime
	 */
	public java.util.Date getLastChgdDatetime() {
		return lastChgdDatetime;
	}

	/**
	 * Set the value related to the column: last_chgd_datetime
	 * 
	 * @param lastChgdDatetime
	 *            the last_chgd_datetime value
	 */
	public void setLastChgdDatetime(java.util.Date lastChgdDatetime) {
		this.lastChgdDatetime = lastChgdDatetime;
	}

	/**
	 * Return the value associated with the column: status_id
	 */
	public java.lang.Integer getStatusId() {
		return statusId;
	}

	/**
	 * Set the value related to the column: status_id
	 * 
	 * @param statusId
	 *            the status_id value
	 */
	public void setStatusId(java.lang.Integer statusId) {
		this.statusId = statusId;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.ItemMaster))
			return false;
		else {
			jkt.hms.masters.business.ItemMaster itemMaster = (jkt.hms.masters.business.ItemMaster) obj;
			if (null == this.getId() || null == itemMaster.getId())
				return false;
			else
				return (this.getId().equals(itemMaster.getId()));
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
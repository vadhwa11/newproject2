package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_store_brand table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="mas_store_brand"
 */

public abstract class BaseMasStoreBrand implements Serializable {

	public static String REF = "MasStoreBrand";
	public static String PROP_ITEM_GENERIC = "ItemGeneric";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_BRAND_CODE = "BrandCode";
	public static String PROP_BRAND_NAME = "BrandName";
	public static String PROP_ITEM = "Item";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_MANUFACTURER = "Manufacturer";
	public static String PROP_ID = "Id";

	// constructors
	public BaseMasStoreBrand() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasStoreBrand(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String brandCode;
	private java.lang.String brandName;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasStoreItem item;
	private jkt.hms.masters.business.MasStoreItemGeneric itemGeneric;
	private jkt.hms.masters.business.MasManufacturer manufacturer;

	// collections
	private java.util.Set<jkt.hms.masters.business.MasStoreItem> masStoreItems;
	private java.util.Set<jkt.hms.masters.business.StoreAdjustmentT> storeAdjustmentTs;
	private java.util.Set<jkt.hms.masters.business.StoreBalanceT> storeBalanceTs;
	private java.util.Set<jkt.hms.masters.business.StoreDefectiveDrugT> storeDefectiveDrugTs;
	private java.util.Set<jkt.hms.masters.business.StoreGrnT> storeGrnTs;
	private java.util.Set<jkt.hms.masters.business.StoreIndentT> storeIndentTs;
	private java.util.Set<jkt.hms.masters.business.StoreInternalReturnT> storeInternalReturnTs;
	private java.util.Set<jkt.hms.masters.business.StoreIpIssueT> storeIpIssueTs;
	private java.util.Set<jkt.hms.masters.business.StoreIssueT> storeIssueTs;
	private java.util.Set<jkt.hms.masters.business.StoreItemBatchStock> storeItemBatchStocks;
	private java.util.Set<jkt.hms.masters.business.StoreLoaninT> storeLoaninTs;
	private java.util.Set<jkt.hms.masters.business.StoreOpPatientIssueT> storeOpPatientIssueTs;
	private java.util.Set<jkt.hms.masters.business.StorePoDetail> storePoDetails;
	private java.util.Set<jkt.hms.masters.business.StoreStockTakingT> storeStockTakingTs;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="brand_id"
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
	 * Return the value associated with the column: brand_code
	 */
	public java.lang.String getBrandCode() {
		return brandCode;
	}

	/**
	 * Set the value related to the column: brand_code
	 * 
	 * @param brandCode
	 *            the brand_code value
	 */
	public void setBrandCode(java.lang.String brandCode) {
		this.brandCode = brandCode;
	}

	/**
	 * Return the value associated with the column: brand_name
	 */
	public java.lang.String getBrandName() {
		return brandName;
	}

	/**
	 * Set the value related to the column: brand_name
	 * 
	 * @param brandName
	 *            the brand_name value
	 */
	public void setBrandName(java.lang.String brandName) {
		this.brandName = brandName;
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
	 * Return the value associated with the column: item_id
	 */
	public jkt.hms.masters.business.MasStoreItem getItem() {
		return item;
	}

	/**
	 * Set the value related to the column: item_id
	 * 
	 * @param item
	 *            the item_id value
	 */
	public void setItem(jkt.hms.masters.business.MasStoreItem item) {
		this.item = item;
	}

	/**
	 * Return the value associated with the column: item_generic_id
	 */
	public jkt.hms.masters.business.MasStoreItemGeneric getItemGeneric() {
		return itemGeneric;
	}

	/**
	 * Set the value related to the column: item_generic_id
	 * 
	 * @param itemGeneric
	 *            the item_generic_id value
	 */
	public void setItemGeneric(
			jkt.hms.masters.business.MasStoreItemGeneric itemGeneric) {
		this.itemGeneric = itemGeneric;
	}

	/**
	 * Return the value associated with the column: manufacturer_id
	 */
	public jkt.hms.masters.business.MasManufacturer getManufacturer() {
		return manufacturer;
	}

	/**
	 * Set the value related to the column: manufacturer_id
	 * 
	 * @param manufacturer
	 *            the manufacturer_id value
	 */
	public void setManufacturer(
			jkt.hms.masters.business.MasManufacturer manufacturer) {
		this.manufacturer = manufacturer;
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

	/**
	 * Return the value associated with the column: StoreAdjustmentTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreAdjustmentT> getStoreAdjustmentTs() {
		return storeAdjustmentTs;
	}

	/**
	 * Set the value related to the column: StoreAdjustmentTs
	 * 
	 * @param storeAdjustmentTs
	 *            the StoreAdjustmentTs value
	 */
	public void setStoreAdjustmentTs(
			java.util.Set<jkt.hms.masters.business.StoreAdjustmentT> storeAdjustmentTs) {
		this.storeAdjustmentTs = storeAdjustmentTs;
	}

	public void addToStoreAdjustmentTs(
			jkt.hms.masters.business.StoreAdjustmentT storeAdjustmentT) {
		if (null == getStoreAdjustmentTs())
			setStoreAdjustmentTs(new java.util.TreeSet<jkt.hms.masters.business.StoreAdjustmentT>());
		getStoreAdjustmentTs().add(storeAdjustmentT);
	}

	/**
	 * Return the value associated with the column: StoreBalanceTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreBalanceT> getStoreBalanceTs() {
		return storeBalanceTs;
	}

	/**
	 * Set the value related to the column: StoreBalanceTs
	 * 
	 * @param storeBalanceTs
	 *            the StoreBalanceTs value
	 */
	public void setStoreBalanceTs(
			java.util.Set<jkt.hms.masters.business.StoreBalanceT> storeBalanceTs) {
		this.storeBalanceTs = storeBalanceTs;
	}

	public void addToStoreBalanceTs(
			jkt.hms.masters.business.StoreBalanceT storeBalanceT) {
		if (null == getStoreBalanceTs())
			setStoreBalanceTs(new java.util.TreeSet<jkt.hms.masters.business.StoreBalanceT>());
		getStoreBalanceTs().add(storeBalanceT);
	}

	/**
	 * Return the value associated with the column: StoreDefectiveDrugTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreDefectiveDrugT> getStoreDefectiveDrugTs() {
		return storeDefectiveDrugTs;
	}

	/**
	 * Set the value related to the column: StoreDefectiveDrugTs
	 * 
	 * @param storeDefectiveDrugTs
	 *            the StoreDefectiveDrugTs value
	 */
	public void setStoreDefectiveDrugTs(
			java.util.Set<jkt.hms.masters.business.StoreDefectiveDrugT> storeDefectiveDrugTs) {
		this.storeDefectiveDrugTs = storeDefectiveDrugTs;
	}

	public void addToStoreDefectiveDrugTs(
			jkt.hms.masters.business.StoreDefectiveDrugT storeDefectiveDrugT) {
		if (null == getStoreDefectiveDrugTs())
			setStoreDefectiveDrugTs(new java.util.TreeSet<jkt.hms.masters.business.StoreDefectiveDrugT>());
		getStoreDefectiveDrugTs().add(storeDefectiveDrugT);
	}

	/**
	 * Return the value associated with the column: StoreGrnTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreGrnT> getStoreGrnTs() {
		return storeGrnTs;
	}

	/**
	 * Set the value related to the column: StoreGrnTs
	 * 
	 * @param storeGrnTs
	 *            the StoreGrnTs value
	 */
	public void setStoreGrnTs(
			java.util.Set<jkt.hms.masters.business.StoreGrnT> storeGrnTs) {
		this.storeGrnTs = storeGrnTs;
	}

	public void addToStoreGrnTs(jkt.hms.masters.business.StoreGrnT storeGrnT) {
		if (null == getStoreGrnTs())
			setStoreGrnTs(new java.util.TreeSet<jkt.hms.masters.business.StoreGrnT>());
		getStoreGrnTs().add(storeGrnT);
	}

	/**
	 * Return the value associated with the column: StoreIndentTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreIndentT> getStoreIndentTs() {
		return storeIndentTs;
	}

	/**
	 * Set the value related to the column: StoreIndentTs
	 * 
	 * @param storeIndentTs
	 *            the StoreIndentTs value
	 */
	public void setStoreIndentTs(
			java.util.Set<jkt.hms.masters.business.StoreIndentT> storeIndentTs) {
		this.storeIndentTs = storeIndentTs;
	}

	public void addToStoreIndentTs(
			jkt.hms.masters.business.StoreIndentT storeIndentT) {
		if (null == getStoreIndentTs())
			setStoreIndentTs(new java.util.TreeSet<jkt.hms.masters.business.StoreIndentT>());
		getStoreIndentTs().add(storeIndentT);
	}

	/**
	 * Return the value associated with the column: StoreInternalReturnTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreInternalReturnT> getStoreInternalReturnTs() {
		return storeInternalReturnTs;
	}

	/**
	 * Set the value related to the column: StoreInternalReturnTs
	 * 
	 * @param storeInternalReturnTs
	 *            the StoreInternalReturnTs value
	 */
	public void setStoreInternalReturnTs(
			java.util.Set<jkt.hms.masters.business.StoreInternalReturnT> storeInternalReturnTs) {
		this.storeInternalReturnTs = storeInternalReturnTs;
	}

	public void addToStoreInternalReturnTs(
			jkt.hms.masters.business.StoreInternalReturnT storeInternalReturnT) {
		if (null == getStoreInternalReturnTs())
			setStoreInternalReturnTs(new java.util.TreeSet<jkt.hms.masters.business.StoreInternalReturnT>());
		getStoreInternalReturnTs().add(storeInternalReturnT);
	}

	/**
	 * Return the value associated with the column: StoreIpIssueTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreIpIssueT> getStoreIpIssueTs() {
		return storeIpIssueTs;
	}

	/**
	 * Set the value related to the column: StoreIpIssueTs
	 * 
	 * @param storeIpIssueTs
	 *            the StoreIpIssueTs value
	 */
	public void setStoreIpIssueTs(
			java.util.Set<jkt.hms.masters.business.StoreIpIssueT> storeIpIssueTs) {
		this.storeIpIssueTs = storeIpIssueTs;
	}

	public void addToStoreIpIssueTs(
			jkt.hms.masters.business.StoreIpIssueT storeIpIssueT) {
		if (null == getStoreIpIssueTs())
			setStoreIpIssueTs(new java.util.TreeSet<jkt.hms.masters.business.StoreIpIssueT>());
		getStoreIpIssueTs().add(storeIpIssueT);
	}

	/**
	 * Return the value associated with the column: StoreIssueTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreIssueT> getStoreIssueTs() {
		return storeIssueTs;
	}

	/**
	 * Set the value related to the column: StoreIssueTs
	 * 
	 * @param storeIssueTs
	 *            the StoreIssueTs value
	 */
	public void setStoreIssueTs(
			java.util.Set<jkt.hms.masters.business.StoreIssueT> storeIssueTs) {
		this.storeIssueTs = storeIssueTs;
	}

	public void addToStoreIssueTs(
			jkt.hms.masters.business.StoreIssueT storeIssueT) {
		if (null == getStoreIssueTs())
			setStoreIssueTs(new java.util.TreeSet<jkt.hms.masters.business.StoreIssueT>());
		getStoreIssueTs().add(storeIssueT);
	}

	/**
	 * Return the value associated with the column: StoreItemBatchStocks
	 */
	public java.util.Set<jkt.hms.masters.business.StoreItemBatchStock> getStoreItemBatchStocks() {
		return storeItemBatchStocks;
	}

	/**
	 * Set the value related to the column: StoreItemBatchStocks
	 * 
	 * @param storeItemBatchStocks
	 *            the StoreItemBatchStocks value
	 */
	public void setStoreItemBatchStocks(
			java.util.Set<jkt.hms.masters.business.StoreItemBatchStock> storeItemBatchStocks) {
		this.storeItemBatchStocks = storeItemBatchStocks;
	}

	public void addToStoreItemBatchStocks(
			jkt.hms.masters.business.StoreItemBatchStock storeItemBatchStock) {
		if (null == getStoreItemBatchStocks())
			setStoreItemBatchStocks(new java.util.TreeSet<jkt.hms.masters.business.StoreItemBatchStock>());
		getStoreItemBatchStocks().add(storeItemBatchStock);
	}

	/**
	 * Return the value associated with the column: StoreLoaninTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreLoaninT> getStoreLoaninTs() {
		return storeLoaninTs;
	}

	/**
	 * Set the value related to the column: StoreLoaninTs
	 * 
	 * @param storeLoaninTs
	 *            the StoreLoaninTs value
	 */
	public void setStoreLoaninTs(
			java.util.Set<jkt.hms.masters.business.StoreLoaninT> storeLoaninTs) {
		this.storeLoaninTs = storeLoaninTs;
	}

	public void addToStoreLoaninTs(
			jkt.hms.masters.business.StoreLoaninT storeLoaninT) {
		if (null == getStoreLoaninTs())
			setStoreLoaninTs(new java.util.TreeSet<jkt.hms.masters.business.StoreLoaninT>());
		getStoreLoaninTs().add(storeLoaninT);
	}

	/**
	 * Return the value associated with the column: StoreOpPatientIssueTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreOpPatientIssueT> getStoreOpPatientIssueTs() {
		return storeOpPatientIssueTs;
	}

	/**
	 * Set the value related to the column: StoreOpPatientIssueTs
	 * 
	 * @param storeOpPatientIssueTs
	 *            the StoreOpPatientIssueTs value
	 */
	public void setStoreOpPatientIssueTs(
			java.util.Set<jkt.hms.masters.business.StoreOpPatientIssueT> storeOpPatientIssueTs) {
		this.storeOpPatientIssueTs = storeOpPatientIssueTs;
	}

	public void addToStoreOpPatientIssueTs(
			jkt.hms.masters.business.StoreOpPatientIssueT storeOpPatientIssueT) {
		if (null == getStoreOpPatientIssueTs())
			setStoreOpPatientIssueTs(new java.util.TreeSet<jkt.hms.masters.business.StoreOpPatientIssueT>());
		getStoreOpPatientIssueTs().add(storeOpPatientIssueT);
	}

	/**
	 * Return the value associated with the column: StorePoDetails
	 */
	public java.util.Set<jkt.hms.masters.business.StorePoDetail> getStorePoDetails() {
		return storePoDetails;
	}

	/**
	 * Set the value related to the column: StorePoDetails
	 * 
	 * @param storePoDetails
	 *            the StorePoDetails value
	 */
	public void setStorePoDetails(
			java.util.Set<jkt.hms.masters.business.StorePoDetail> storePoDetails) {
		this.storePoDetails = storePoDetails;
	}

	public void addToStorePoDetails(
			jkt.hms.masters.business.StorePoDetail storePoDetail) {
		if (null == getStorePoDetails())
			setStorePoDetails(new java.util.TreeSet<jkt.hms.masters.business.StorePoDetail>());
		getStorePoDetails().add(storePoDetail);
	}

	/**
	 * Return the value associated with the column: StoreStockTakingTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreStockTakingT> getStoreStockTakingTs() {
		return storeStockTakingTs;
	}

	/**
	 * Set the value related to the column: StoreStockTakingTs
	 * 
	 * @param storeStockTakingTs
	 *            the StoreStockTakingTs value
	 */
	public void setStoreStockTakingTs(
			java.util.Set<jkt.hms.masters.business.StoreStockTakingT> storeStockTakingTs) {
		this.storeStockTakingTs = storeStockTakingTs;
	}

	public void addToStoreStockTakingTs(
			jkt.hms.masters.business.StoreStockTakingT storeStockTakingT) {
		if (null == getStoreStockTakingTs())
			setStoreStockTakingTs(new java.util.TreeSet<jkt.hms.masters.business.StoreStockTakingT>());
		getStoreStockTakingTs().add(storeStockTakingT);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MasStoreBrand))
			return false;
		else {
			jkt.hms.masters.business.MasStoreBrand masStoreBrand = (jkt.hms.masters.business.MasStoreBrand) obj;
			if (null == this.getId() || null == masStoreBrand.getId())
				return false;
			else
				return (this.getId().equals(masStoreBrand.getId()));
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
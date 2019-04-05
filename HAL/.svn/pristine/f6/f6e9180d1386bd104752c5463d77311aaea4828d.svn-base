package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the store_item_adjustment_t table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="store_item_adjustment_t"
 */

public abstract class BaseStoreItemAdjustmentT  implements Serializable {

	public static String REF = "StoreItemAdjustmentT";
	public static String ID = "Id" ;
	public static String ITEM_TYPE="ItemType";
	public static String BATCH_NO="BatchNo";
	public static String ADJUSTED_QTY="AdjustedQty";
	public static String ADJUSTMENT_EXPIRY_DATE="AdjustmentExpiryDate";
	
    private int id;
    private String itemType ;
    private String batchNo;
    private java.math.BigDecimal adjustedQty ;
    private java.util.Date adjustmentExpiryDate ;
    
    private jkt.hms.masters.business.MasStoreItem itemId;
    private jkt.hms.masters.business.StoreItemAdjustmentM itemAdjustmentMId ;
    private jkt.hms.masters.business.StoreItemBatchStock itemBatchStockId ;
    private jkt.hms.masters.business.MasStoreBrand itemBrandId;
	


	/**
	 * @return the itemBrandId
	 */
	public jkt.hms.masters.business.MasStoreBrand getItemBrandId() {
		return itemBrandId;
	}

	/**
	 * @param itemBrandId the itemBrandId to set
	 */
	public void setItemBrandId(jkt.hms.masters.business.MasStoreBrand itemBrandId) {
		this.itemBrandId = itemBrandId;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the itemType
	 */
	public String getItemType() {
		return itemType;
	}

	/**
	 * @param itemType the itemType to set
	 */
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	/**
	 * @return the batchNo
	 */
	public String getBatchNo() {
		return batchNo;
	}

	/**
	 * @param batchNo the batchNo to set
	 */
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	/**
	 * @return the adjustedQty
	 */
	public java.math.BigDecimal getAdjustedQty() {
		return adjustedQty;
	}

	/**
	 * @param adjustedQty the adjustedQty to set
	 */
	public void setAdjustedQty(java.math.BigDecimal adjustedQty) {
		this.adjustedQty = adjustedQty;
	}

	/**
	 * @return the itemId
	 */
	public jkt.hms.masters.business.MasStoreItem getItemId() {
		return itemId;
	}

	/**
	 * @param itemId the itemId to set
	 */
	public void setItemId(jkt.hms.masters.business.MasStoreItem itemId) {
		this.itemId = itemId;
	}

	/**
	 * @return the itemAdjustmentMId
	 */
	public jkt.hms.masters.business.StoreItemAdjustmentM getItemAdjustmentMId() {
		return itemAdjustmentMId;
	}

	/**
	 * @param itemAdjustmentMId the itemAdjustmentMId to set
	 */
	public void setItemAdjustmentMId(
			jkt.hms.masters.business.StoreItemAdjustmentM itemAdjustmentMId) {
		this.itemAdjustmentMId = itemAdjustmentMId;
	}

	/**
	 * @return the itemBatchStockId
	 */
	public jkt.hms.masters.business.StoreItemBatchStock getItemBatchStockId() {
		return itemBatchStockId;
	}

	/**
	 * @param itemBatchStockId the itemBatchStockId to set
	 */
	public void setItemBatchStockId(
			jkt.hms.masters.business.StoreItemBatchStock itemBatchStockId) {
		this.itemBatchStockId = itemBatchStockId;
	}

	// constructors
	public BaseStoreItemAdjustmentT () {
		initialize();
	}

	protected void initialize () {}












	public String toString () {
		return super.toString();
	}

	/**
	 * @return the adjustmentExpiryDate
	 */
	public java.util.Date getAdjustmentExpiryDate() {
		return adjustmentExpiryDate;
	}

	/**
	 * @param adjustmentExpiryDate the adjustmentExpiryDate to set
	 */
	public void setAdjustmentExpiryDate(java.util.Date adjustmentExpiryDate) {
		this.adjustmentExpiryDate = adjustmentExpiryDate;
	}


}
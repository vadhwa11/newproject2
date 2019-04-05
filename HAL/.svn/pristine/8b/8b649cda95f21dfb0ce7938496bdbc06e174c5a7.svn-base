package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the store_stock_taking_t table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="store_stock_taking_t"
 */

public abstract class BaseStoreStockTakingT  implements Serializable {

	public static String REF = "StoreStockTakingT";
	public static String PROP_COMPUTED_STOCK = "ComputedStock";
	public static String PROP_STORE_STOCK_SERVICE = "StoreStockService";
	public static String PROP_BRAND = "Brand";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_STOCK_SURPLUS = "StockSurplus";
	public static String PROP_STORE_ITEM_BATCH_STOCK = "StoreItemBatchStock";
	public static String PROP_EXPIRY_DATE = "ExpiryDate";
	public static String PROP_ITEM = "Item";
	public static String PROP_STOCK_TAKING_M = "StockTakingM";
	public static String PROP_ID = "Id";
	public static String PROP_STORE_STOCK_DEFECTIVE = "StoreStockDefective";
	public static String PROP_STOCK_DEFICIENT = "StockDeficient";
	public static String PROP_BATCH_NO = "BatchNo";
	public static String PROP_SR_NO = "SrNo";
	public static String PROP_COST_PRICE = "CostPrice";


	// constructors
	public BaseStoreStockTakingT () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreStockTakingT (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String batchNo;
	private java.math.BigDecimal computedStock;
	private java.math.BigDecimal costPrice;
	private java.util.Date expiryDate;
	private java.lang.String remarks;
	private java.lang.Integer srNo;
	private java.math.BigDecimal stockDeficient;
	private java.math.BigDecimal stockSurplus;
	private java.math.BigDecimal storeStockDefective;
	private java.math.BigDecimal storeStockService;

	// many to one
	private jkt.hms.masters.business.MasStoreBrand brand;
	private jkt.hms.masters.business.MasStoreItem item;
	private jkt.hms.masters.business.StoreStockTakingM stockTakingM;
	private jkt.hms.masters.business.StoreItemBatchStock storeItemBatchStock;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="id"
     */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: batch_no
	 */
	public java.lang.String getBatchNo () {
		return batchNo;
	}

	/**
	 * Set the value related to the column: batch_no
	 * @param batchNo the batch_no value
	 */
	public void setBatchNo (java.lang.String batchNo) {
		this.batchNo = batchNo;
	}



	/**
	 * Return the value associated with the column: computed_stock
	 */
	public java.math.BigDecimal getComputedStock () {
		return computedStock;
	}

	/**
	 * Set the value related to the column: computed_stock
	 * @param computedStock the computed_stock value
	 */
	public void setComputedStock (java.math.BigDecimal computedStock) {
		this.computedStock = computedStock;
	}



	/**
	 * Return the value associated with the column: cost_price
	 */
	public java.math.BigDecimal getCostPrice () {
		return costPrice;
	}

	/**
	 * Set the value related to the column: cost_price
	 * @param costPrice the cost_price value
	 */
	public void setCostPrice (java.math.BigDecimal costPrice) {
		this.costPrice = costPrice;
	}



	/**
	 * Return the value associated with the column: expiry_date
	 */
	public java.util.Date getExpiryDate () {
		return expiryDate;
	}

	/**
	 * Set the value related to the column: expiry_date
	 * @param expiryDate the expiry_date value
	 */
	public void setExpiryDate (java.util.Date expiryDate) {
		this.expiryDate = expiryDate;
	}



	/**
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * @param remarks the remarks value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
	}



	/**
	 * Return the value associated with the column: sr_no
	 */
	public java.lang.Integer getSrNo () {
		return srNo;
	}

	/**
	 * Set the value related to the column: sr_no
	 * @param srNo the sr_no value
	 */
	public void setSrNo (java.lang.Integer srNo) {
		this.srNo = srNo;
	}



	/**
	 * Return the value associated with the column: stock_deficient
	 */
	public java.math.BigDecimal getStockDeficient () {
		return stockDeficient;
	}

	/**
	 * Set the value related to the column: stock_deficient
	 * @param stockDeficient the stock_deficient value
	 */
	public void setStockDeficient (java.math.BigDecimal stockDeficient) {
		this.stockDeficient = stockDeficient;
	}



	/**
	 * Return the value associated with the column: stock_surplus
	 */
	public java.math.BigDecimal getStockSurplus () {
		return stockSurplus;
	}

	/**
	 * Set the value related to the column: stock_surplus
	 * @param stockSurplus the stock_surplus value
	 */
	public void setStockSurplus (java.math.BigDecimal stockSurplus) {
		this.stockSurplus = stockSurplus;
	}



	/**
	 * Return the value associated with the column: store_stock_defective
	 */
	public java.math.BigDecimal getStoreStockDefective () {
		return storeStockDefective;
	}

	/**
	 * Set the value related to the column: store_stock_defective
	 * @param storeStockDefective the store_stock_defective value
	 */
	public void setStoreStockDefective (java.math.BigDecimal storeStockDefective) {
		this.storeStockDefective = storeStockDefective;
	}



	/**
	 * Return the value associated with the column: store_stock_service
	 */
	public java.math.BigDecimal getStoreStockService () {
		return storeStockService;
	}

	/**
	 * Set the value related to the column: store_stock_service
	 * @param storeStockService the store_stock_service value
	 */
	public void setStoreStockService (java.math.BigDecimal storeStockService) {
		this.storeStockService = storeStockService;
	}



	/**
	 * Return the value associated with the column: brand_id
	 */
	public jkt.hms.masters.business.MasStoreBrand getBrand () {
		return brand;
	}

	/**
	 * Set the value related to the column: brand_id
	 * @param brand the brand_id value
	 */
	public void setBrand (jkt.hms.masters.business.MasStoreBrand brand) {
		this.brand = brand;
	}



	/**
	 * Return the value associated with the column: item_id
	 */
	public jkt.hms.masters.business.MasStoreItem getItem () {
		return item;
	}

	/**
	 * Set the value related to the column: item_id
	 * @param item the item_id value
	 */
	public void setItem (jkt.hms.masters.business.MasStoreItem item) {
		this.item = item;
	}



	/**
	 * Return the value associated with the column: stock_taking_m_id
	 */
	public jkt.hms.masters.business.StoreStockTakingM getStockTakingM () {
		return stockTakingM;
	}

	/**
	 * Set the value related to the column: stock_taking_m_id
	 * @param stockTakingM the stock_taking_m_id value
	 */
	public void setStockTakingM (jkt.hms.masters.business.StoreStockTakingM stockTakingM) {
		this.stockTakingM = stockTakingM;
	}



	/**
	 * Return the value associated with the column: store_item_batch_stock_id
	 */
	public jkt.hms.masters.business.StoreItemBatchStock getStoreItemBatchStock () {
		return storeItemBatchStock;
	}

	/**
	 * Set the value related to the column: store_item_batch_stock_id
	 * @param storeItemBatchStock the store_item_batch_stock_id value
	 */
	public void setStoreItemBatchStock (jkt.hms.masters.business.StoreItemBatchStock storeItemBatchStock) {
		this.storeItemBatchStock = storeItemBatchStock;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreStockTakingT)) return false;
		else {
			jkt.hms.masters.business.StoreStockTakingT storeStockTakingT = (jkt.hms.masters.business.StoreStockTakingT) obj;
			if (null == this.getId() || null == storeStockTakingT.getId()) return false;
			else return (this.getId().equals(storeStockTakingT.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}
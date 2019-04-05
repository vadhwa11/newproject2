package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the store_internal_return_t table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="store_internal_return_t"
 */

public abstract class BaseStoreInternalReturnT  implements Serializable {

	public static String REF = "StoreInternalReturnT";
	public static String PROP_BRAND = "Brand";
	public static String PROP_ACTION_TAKEN = "ActionTaken";
	public static String PROP_STOCK = "Stock";
	public static String PROP_RETURN_MAIN = "ReturnMain";
	public static String PROP_ACTION_DATE = "ActionDate";
	public static String PROP_RECEIVED_QTY = "ReceivedQty";
	public static String PROP_DISCREPANCY_REMARKS = "DiscrepancyRemarks";
	public static String PROP_EXPIRY_DATE = "ExpiryDate";
	public static String PROP_RETURN_QTY = "ReturnQty";
	public static String PROP_ITEM_AMOUNT = "ItemAmount";
	public static String PROP_ITEM = "Item";
	public static String PROP_ID = "Id";
	public static String PROP_DISPOSAL_NO = "DisposalNo";
	public static String PROP_BATCH_NO = "BatchNo";
	public static String PROP_SR_NO = "SrNo";
	public static String PROP_RATE = "Rate";


	// constructors
	public BaseStoreInternalReturnT () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreInternalReturnT (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date actionDate;
	private java.lang.String actionTaken;
	private java.lang.String batchNo;
	private java.lang.String discrepancyRemarks;
	private java.lang.String disposalNo;
	private java.lang.String expiryDate;
	private java.math.BigDecimal itemAmount;
	private java.math.BigDecimal rate;
	private java.lang.Integer receivedQty;
	private java.math.BigDecimal returnQty;
	private java.lang.Short srNo;

	// many to one
	private jkt.hms.masters.business.MasStoreBrand brand;
	private jkt.hms.masters.business.MasStoreItem item;
	private jkt.hms.masters.business.StoreInternalReturnM returnMain;
	private jkt.hms.masters.business.StoreItemBatchStock stock;



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
	 * Return the value associated with the column: action_date
	 */
	public java.util.Date getActionDate () {
		return actionDate;
	}

	/**
	 * Set the value related to the column: action_date
	 * @param actionDate the action_date value
	 */
	public void setActionDate (java.util.Date actionDate) {
		this.actionDate = actionDate;
	}



	/**
	 * Return the value associated with the column: action_taken
	 */
	public java.lang.String getActionTaken () {
		return actionTaken;
	}

	/**
	 * Set the value related to the column: action_taken
	 * @param actionTaken the action_taken value
	 */
	public void setActionTaken (java.lang.String actionTaken) {
		this.actionTaken = actionTaken;
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
	 * Return the value associated with the column: discrepancy_remarks
	 */
	public java.lang.String getDiscrepancyRemarks () {
		return discrepancyRemarks;
	}

	/**
	 * Set the value related to the column: discrepancy_remarks
	 * @param discrepancyRemarks the discrepancy_remarks value
	 */
	public void setDiscrepancyRemarks (java.lang.String discrepancyRemarks) {
		this.discrepancyRemarks = discrepancyRemarks;
	}



	/**
	 * Return the value associated with the column: disposal_no
	 */
	public java.lang.String getDisposalNo () {
		return disposalNo;
	}

	/**
	 * Set the value related to the column: disposal_no
	 * @param disposalNo the disposal_no value
	 */
	public void setDisposalNo (java.lang.String disposalNo) {
		this.disposalNo = disposalNo;
	}



	/**
	 * Return the value associated with the column: expiry_date
	 */
	public java.lang.String getExpiryDate () {
		return expiryDate;
	}

	/**
	 * Set the value related to the column: expiry_date
	 * @param expiryDate the expiry_date value
	 */
	public void setExpiryDate (java.lang.String expiryDate) {
		this.expiryDate = expiryDate;
	}



	/**
	 * Return the value associated with the column: item_amount
	 */
	public java.math.BigDecimal getItemAmount () {
		return itemAmount;
	}

	/**
	 * Set the value related to the column: item_amount
	 * @param itemAmount the item_amount value
	 */
	public void setItemAmount (java.math.BigDecimal itemAmount) {
		this.itemAmount = itemAmount;
	}



	/**
	 * Return the value associated with the column: rate
	 */
	public java.math.BigDecimal getRate () {
		return rate;
	}

	/**
	 * Set the value related to the column: rate
	 * @param rate the rate value
	 */
	public void setRate (java.math.BigDecimal rate) {
		this.rate = rate;
	}



	/**
	 * Return the value associated with the column: received_qty
	 */
	public java.lang.Integer getReceivedQty () {
		return receivedQty;
	}

	/**
	 * Set the value related to the column: received_qty
	 * @param receivedQty the received_qty value
	 */
	public void setReceivedQty (java.lang.Integer receivedQty) {
		this.receivedQty = receivedQty;
	}



	/**
	 * Return the value associated with the column: return_qty
	 */
	public java.math.BigDecimal getReturnQty () {
		return returnQty;
	}

	/**
	 * Set the value related to the column: return_qty
	 * @param returnQty the return_qty value
	 */
	public void setReturnQty (java.math.BigDecimal returnQty) {
		this.returnQty = returnQty;
	}



	/**
	 * Return the value associated with the column: sr_no
	 */
	public java.lang.Short getSrNo () {
		return srNo;
	}

	/**
	 * Set the value related to the column: sr_no
	 * @param srNo the sr_no value
	 */
	public void setSrNo (java.lang.Short srNo) {
		this.srNo = srNo;
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
	 * Return the value associated with the column: return_main_id
	 */
	public jkt.hms.masters.business.StoreInternalReturnM getReturnMain () {
		return returnMain;
	}

	/**
	 * Set the value related to the column: return_main_id
	 * @param returnMain the return_main_id value
	 */
	public void setReturnMain (jkt.hms.masters.business.StoreInternalReturnM returnMain) {
		this.returnMain = returnMain;
	}



	/**
	 * Return the value associated with the column: stock_id
	 */
	public jkt.hms.masters.business.StoreItemBatchStock getStock () {
		return stock;
	}

	/**
	 * Set the value related to the column: stock_id
	 * @param stock the stock_id value
	 */
	public void setStock (jkt.hms.masters.business.StoreItemBatchStock stock) {
		this.stock = stock;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreInternalReturnT)) return false;
		else {
			jkt.hms.masters.business.StoreInternalReturnT storeInternalReturnT = (jkt.hms.masters.business.StoreInternalReturnT) obj;
			if (null == this.getId() || null == storeInternalReturnT.getId()) return false;
			else return (this.getId().equals(storeInternalReturnT.getId()));
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
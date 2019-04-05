package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the store_internal_indent_t table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="store_internal_indent_t"
 */

public abstract class BaseStoreInternalIndentT  implements Serializable {

	public static String REF = "StoreInternalIndentT";
	public static String PROP_ISSUED_BATCHID_AND_QTY = "IssuedBatchidAndQty";
	public static String PROP_QTY_REQUEST = "QtyRequest";
	public static String PROP_STOCK_IN_HAND = "StockInHand";
	public static String PROP_ITEM = "Item";
	public static String PROP_MMF_QTY = "MmfQty";
	public static String PROP_AVAILABLE_STOCK = "AvailableStock";
	public static String PROP_REASON_FOR_DEMAND = "ReasonForDemand";
	public static String PROP_STORES_STOCK = "StoresStock";
	public static String PROP_ID = "Id";
	public static String PROP_INTERNAL = "Internal";
	public static String PROP_QTY_ISSUED = "QtyIssued";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_SR_NO = "SrNo";
	public static String PROP_CD_STOCK = "CdStock";
	public static String PROP_WP_STOCK = "WpStock";


	// constructors
	public BaseStoreInternalIndentT () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreInternalIndentT (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.math.BigDecimal availableStock;
	private java.math.BigDecimal cdStock;
	private java.lang.String issuedBatchidAndQty;
	private java.lang.Integer mmfQty;
	private java.lang.Integer qtyIssued;
	private java.lang.Integer qtyRequest;
	private java.lang.String reasonForDemand;
	private java.lang.Integer srNo;
	private java.lang.Integer stockInHand;
	private java.math.BigDecimal storesStock;
	private java.math.BigDecimal wpStock;

	// many to one
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.StoreInternalIndentM internal;
	private jkt.hms.masters.business.MasStoreItem item;



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
	 * Return the value associated with the column: available_stock
	 */
	public java.math.BigDecimal getAvailableStock () {
		return availableStock;
	}

	/**
	 * Set the value related to the column: available_stock
	 * @param availableStock the available_stock value
	 */
	public void setAvailableStock (java.math.BigDecimal availableStock) {
		this.availableStock = availableStock;
	}



	/**
	 * Return the value associated with the column: cd_stock
	 */
	public java.math.BigDecimal getCdStock () {
		return cdStock;
	}

	/**
	 * Set the value related to the column: cd_stock
	 * @param cdStock the cd_stock value
	 */
	public void setCdStock (java.math.BigDecimal cdStock) {
		this.cdStock = cdStock;
	}



	/**
	 * Return the value associated with the column: issued_batchId_and_qty
	 */
	public java.lang.String getIssuedBatchidAndQty () {
		return issuedBatchidAndQty;
	}

	/**
	 * Set the value related to the column: issued_batchId_and_qty
	 * @param issuedBatchidAndQty the issued_batchId_and_qty value
	 */
	public void setIssuedBatchidAndQty (java.lang.String issuedBatchidAndQty) {
		this.issuedBatchidAndQty = issuedBatchidAndQty;
	}



	/**
	 * Return the value associated with the column: mmf_qty
	 */
	public java.lang.Integer getMmfQty () {
		return mmfQty;
	}

	/**
	 * Set the value related to the column: mmf_qty
	 * @param mmfQty the mmf_qty value
	 */
	public void setMmfQty (java.lang.Integer mmfQty) {
		this.mmfQty = mmfQty;
	}



	/**
	 * Return the value associated with the column: qty_issued
	 */
	public java.lang.Integer getQtyIssued () {
		return qtyIssued;
	}

	/**
	 * Set the value related to the column: qty_issued
	 * @param qtyIssued the qty_issued value
	 */
	public void setQtyIssued (java.lang.Integer qtyIssued) {
		this.qtyIssued = qtyIssued;
	}



	/**
	 * Return the value associated with the column: qty_request
	 */
	public java.lang.Integer getQtyRequest () {
		return qtyRequest;
	}

	/**
	 * Set the value related to the column: qty_request
	 * @param qtyRequest the qty_request value
	 */
	public void setQtyRequest (java.lang.Integer qtyRequest) {
		this.qtyRequest = qtyRequest;
	}



	/**
	 * Return the value associated with the column: REASON_FOR_DEMAND
	 */
	public java.lang.String getReasonForDemand () {
		return reasonForDemand;
	}

	/**
	 * Set the value related to the column: REASON_FOR_DEMAND
	 * @param reasonForDemand the REASON_FOR_DEMAND value
	 */
	public void setReasonForDemand (java.lang.String reasonForDemand) {
		this.reasonForDemand = reasonForDemand;
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
	 * Return the value associated with the column: stock_in_hand
	 */
	public java.lang.Integer getStockInHand () {
		return stockInHand;
	}

	/**
	 * Set the value related to the column: stock_in_hand
	 * @param stockInHand the stock_in_hand value
	 */
	public void setStockInHand (java.lang.Integer stockInHand) {
		this.stockInHand = stockInHand;
	}



	/**
	 * Return the value associated with the column: stores_stock
	 */
	public java.math.BigDecimal getStoresStock () {
		return storesStock;
	}

	/**
	 * Set the value related to the column: stores_stock
	 * @param storesStock the stores_stock value
	 */
	public void setStoresStock (java.math.BigDecimal storesStock) {
		this.storesStock = storesStock;
	}



	/**
	 * Return the value associated with the column: wp_stock
	 */
	public java.math.BigDecimal getWpStock () {
		return wpStock;
	}

	/**
	 * Set the value related to the column: wp_stock
	 * @param wpStock the wp_stock value
	 */
	public void setWpStock (java.math.BigDecimal wpStock) {
		this.wpStock = wpStock;
	}



	/**
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment () {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * @param department the department_id value
	 */
	public void setDepartment (jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}



	/**
	 * Return the value associated with the column: internal_id
	 */
	public jkt.hms.masters.business.StoreInternalIndentM getInternal () {
		return internal;
	}

	/**
	 * Set the value related to the column: internal_id
	 * @param internal the internal_id value
	 */
	public void setInternal (jkt.hms.masters.business.StoreInternalIndentM internal) {
		this.internal = internal;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreInternalIndentT)) return false;
		else {
			jkt.hms.masters.business.StoreInternalIndentT storeInternalIndentT = (jkt.hms.masters.business.StoreInternalIndentT) obj;
			if (null == this.getId() || null == storeInternalIndentT.getId()) return false;
			else return (this.getId().equals(storeInternalIndentT.getId()));
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
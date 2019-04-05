package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the store_loan_out_t table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="store_loan_out_t"
 */

public abstract class BaseStoreLoanOutT  implements Serializable {

	public static String REF = "StoreLoanOutT";
	public static String PROP_ISSUE_M = "IssueM";
	public static String PROP_ISSUED = "Issued";
	public static String PROP_ITEM_FROM_INDENT = "ItemFromIndent";
	public static String PROP_ITEM_ORDER = "ItemOrder";
	public static String PROP_BRAND = "Brand";
	public static String PROP_ITEM = "Item";
	public static String PROP_EXPIRY_DATE = "ExpiryDate";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_ACK_DATE = "AckDate";
	public static String PROP_BATCH_STOCK = "BatchStock";
	public static String PROP_BATCH_NO = "BatchNo";
	public static String PROP_QTY_ISSUED = "QtyIssued";
	public static String PROP_RECEIVED_BY = "ReceivedBy";
	public static String PROP_SR_NO = "SrNo";
	public static String PROP_COST_PRICE = "CostPrice";
	public static String PROP_ID = "Id";
	public static String PROP_QTY_REQUEST = "QtyRequest";
	public static String PROP_MANUFACTURE_DATE = "ManufactureDate";
	public static String PROP_ITEM_ISSUED = "ItemIssued";


	// constructors
	public BaseStoreLoanOutT () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreLoanOutT (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseStoreLoanOutT (
		java.lang.Integer id,
		jkt.hms.masters.business.StoreLoanOutM issueM,
		jkt.hms.masters.business.MasStoreItem item) {

		this.setId(id);
		this.setIssueM(issueM);
		this.setItem(item);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.math.BigDecimal qtyRequest;
	private java.lang.String batchNo;
	private java.math.BigDecimal qtyIssued;
	private java.lang.String remarks;
	private java.util.Date expiryDate;
	private java.lang.Integer srNo;
	private java.lang.String issued;
	private java.lang.String itemFromIndent;
	private java.lang.String itemOrder;
	private java.util.Date ackDate;
	private java.math.BigDecimal costPrice;
	private java.util.Date manufactureDate;

	// many to one
	private jkt.hms.masters.business.MasEmployee receivedBy;
	private jkt.hms.masters.business.MasStoreBrand brand;
	private jkt.hms.masters.business.MasStoreItem itemIssued;
	private jkt.hms.masters.business.StoreLoanOutM issueM;
	private jkt.hms.masters.business.MasStoreItem item;
	private jkt.hms.masters.business.StoreItemBatchStock batchStock;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
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
	 * Return the value associated with the column: qty_request
	 */
	public java.math.BigDecimal getQtyRequest () {
		return qtyRequest;
	}

	/**
	 * Set the value related to the column: qty_request
	 * @param qtyRequest the qty_request value
	 */
	public void setQtyRequest (java.math.BigDecimal qtyRequest) {
		this.qtyRequest = qtyRequest;
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
	 * Return the value associated with the column: qty_issued
	 */
	public java.math.BigDecimal getQtyIssued () {
		return qtyIssued;
	}

	/**
	 * Set the value related to the column: qty_issued
	 * @param qtyIssued the qty_issued value
	 */
	public void setQtyIssued (java.math.BigDecimal qtyIssued) {
		this.qtyIssued = qtyIssued;
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
	 * Return the value associated with the column: issued
	 */
	public java.lang.String getIssued () {
		return issued;
	}

	/**
	 * Set the value related to the column: issued
	 * @param issued the issued value
	 */
	public void setIssued (java.lang.String issued) {
		this.issued = issued;
	}



	/**
	 * Return the value associated with the column: item_from_indent
	 */
	public java.lang.String getItemFromIndent () {
		return itemFromIndent;
	}

	/**
	 * Set the value related to the column: item_from_indent
	 * @param itemFromIndent the item_from_indent value
	 */
	public void setItemFromIndent (java.lang.String itemFromIndent) {
		this.itemFromIndent = itemFromIndent;
	}



	/**
	 * Return the value associated with the column: item_order
	 */
	public java.lang.String getItemOrder () {
		return itemOrder;
	}

	/**
	 * Set the value related to the column: item_order
	 * @param itemOrder the item_order value
	 */
	public void setItemOrder (java.lang.String itemOrder) {
		this.itemOrder = itemOrder;
	}



	/**
	 * Return the value associated with the column: ack_date
	 */
	public java.util.Date getAckDate () {
		return ackDate;
	}

	/**
	 * Set the value related to the column: ack_date
	 * @param ackDate the ack_date value
	 */
	public void setAckDate (java.util.Date ackDate) {
		this.ackDate = ackDate;
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
	 * Return the value associated with the column: manufacture_date
	 */
	public java.util.Date getManufactureDate () {
		return manufactureDate;
	}

	/**
	 * Set the value related to the column: manufacture_date
	 * @param manufactureDate the manufacture_date value
	 */
	public void setManufactureDate (java.util.Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}



	/**
	 * Return the value associated with the column: received_by
	 */
	public jkt.hms.masters.business.MasEmployee getReceivedBy () {
		return receivedBy;
	}

	/**
	 * Set the value related to the column: received_by
	 * @param receivedBy the received_by value
	 */
	public void setReceivedBy (jkt.hms.masters.business.MasEmployee receivedBy) {
		this.receivedBy = receivedBy;
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
	 * Return the value associated with the column: item_issued
	 */
	public jkt.hms.masters.business.MasStoreItem getItemIssued () {
		return itemIssued;
	}

	/**
	 * Set the value related to the column: item_issued
	 * @param itemIssued the item_issued value
	 */
	public void setItemIssued (jkt.hms.masters.business.MasStoreItem itemIssued) {
		this.itemIssued = itemIssued;
	}



	/**
	 * Return the value associated with the column: issue_m_id
	 */
	public jkt.hms.masters.business.StoreLoanOutM getIssueM () {
		return issueM;
	}

	/**
	 * Set the value related to the column: issue_m_id
	 * @param issueM the issue_m_id value
	 */
	public void setIssueM (jkt.hms.masters.business.StoreLoanOutM issueM) {
		this.issueM = issueM;
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
	 * Return the value associated with the column: batch_stock_id
	 */
	public jkt.hms.masters.business.StoreItemBatchStock getBatchStock () {
		return batchStock;
	}

	/**
	 * Set the value related to the column: batch_stock_id
	 * @param batchStock the batch_stock_id value
	 */
	public void setBatchStock (jkt.hms.masters.business.StoreItemBatchStock batchStock) {
		this.batchStock = batchStock;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreLoanOutT)) return false;
		else {
			jkt.hms.masters.business.StoreLoanOutT storeLoanOutT = (jkt.hms.masters.business.StoreLoanOutT) obj;
			if (null == this.getId() || null == storeLoanOutT.getId()) return false;
			else return (this.getId().equals(storeLoanOutT.getId()));
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
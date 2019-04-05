package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the rc_request_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="rc_request_details"
 */

public abstract class BaseRcRequestDetails  implements Serializable {

	public static String REF = "RcRequestDetails";
	public static String PROP_ITEM = "Item";
	public static String PROP_HEADER = "Header";
	public static String PROP_AVAILABLE_STOCK = "AvailableStock";
	public static String PROP_FROM_DEPARTMENTS = "FromDepartments";
	public static String PROP_STORES_STOCK = "StoresStock";
	public static String PROP_REASON_FOR_DEMAND = "ReasonForDemand";
	public static String PROP_RC_HEADER = "RcHeader";
	public static String PROP_ID = "Id";
	public static String PROP_QTY_ISSUED = "QtyIssued";
	public static String PROP_REQ_QTY = "ReqQty";
	public static String PROP_WP_STOCK = "WpStock";
	public static String PROP_CD_STOCK = "CdStock";


	// constructors
	public BaseRcRequestDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseRcRequestDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.math.BigDecimal reqQty;
	private java.math.BigDecimal qtyIssued;
	private java.lang.String reasonForDemand;
	private java.math.BigDecimal availableStock;
	private java.math.BigDecimal cdStock;
	private java.math.BigDecimal wpStock;
	private java.math.BigDecimal storesStock;
	private java.lang.String fromDepartments;

	// many to one
	private jkt.hms.masters.business.RcRequestHeader header;
	private jkt.hms.masters.business.MasStoreItem item;
	private jkt.hms.masters.business.RcHeader rcHeader;



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
	 * Return the value associated with the column: req_qty
	 */
	public java.math.BigDecimal getReqQty () {
		return reqQty;
	}

	/**
	 * Set the value related to the column: req_qty
	 * @param reqQty the req_qty value
	 */
	public void setReqQty (java.math.BigDecimal reqQty) {
		this.reqQty = reqQty;
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
	 * Return the value associated with the column: reason_for_demand
	 */
	public java.lang.String getReasonForDemand () {
		return reasonForDemand;
	}

	/**
	 * Set the value related to the column: reason_for_demand
	 * @param reasonForDemand the reason_for_demand value
	 */
	public void setReasonForDemand (java.lang.String reasonForDemand) {
		this.reasonForDemand = reasonForDemand;
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
	 * Return the value associated with the column: from_departments
	 */
	public java.lang.String getFromDepartments () {
		return fromDepartments;
	}

	/**
	 * Set the value related to the column: from_departments
	 * @param fromDepartments the from_departments value
	 */
	public void setFromDepartments (java.lang.String fromDepartments) {
		this.fromDepartments = fromDepartments;
	}



	/**
	 * Return the value associated with the column: header_id
	 */
	public jkt.hms.masters.business.RcRequestHeader getHeader () {
		return header;
	}

	/**
	 * Set the value related to the column: header_id
	 * @param header the header_id value
	 */
	public void setHeader (jkt.hms.masters.business.RcRequestHeader header) {
		this.header = header;
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
	 * Return the value associated with the column: rc_header_id
	 */
	public jkt.hms.masters.business.RcHeader getRcHeader () {
		return rcHeader;
	}

	/**
	 * Set the value related to the column: rc_header_id
	 * @param rcHeader the rc_header_id value
	 */
	public void setRcHeader (jkt.hms.masters.business.RcHeader rcHeader) {
		this.rcHeader = rcHeader;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.RcRequestDetails)) return false;
		else {
			jkt.hms.masters.business.RcRequestDetails rcRequestDetails = (jkt.hms.masters.business.RcRequestDetails) obj;
			if (null == this.getId() || null == rcRequestDetails.getId()) return false;
			else return (this.getId().equals(rcRequestDetails.getId()));
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
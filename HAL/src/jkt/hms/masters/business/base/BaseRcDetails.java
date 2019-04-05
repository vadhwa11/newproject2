package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the rc_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="rc_details"
 */

public abstract class BaseRcDetails  implements Serializable {

	public static String REF = "RcDetails";
	public static String PROP_RECEIVED_QTY = "ReceivedQty";
	public static String PROP_BRAND = "Brand";
	public static String PROP_MANUFACTURER = "Manufacturer";
	public static String PROP_REJECTED_QTY = "RejectedQty";
	public static String PROP_ITEM = "Item";
	public static String PROP_RECOM_QTY = "RecomQty";
	public static String PROP_HEADER = "Header";
	public static String PROP_FROM_DEPARTMENTS = "FromDepartments";
	public static String PROP_RC_STATUS = "RcStatus";
	public static String PROP_ACCEPTED_QTY = "AcceptedQty";
	public static String PROP_FINAL_QTY = "FinalQty";
	public static String PROP_ID = "Id";
	public static String PROP_STOCK = "Stock";
	public static String PROP_REQUESTED_QTY = "RequestedQty";


	// constructors
	public BaseRcDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseRcDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.math.BigDecimal requestedQty;
	private java.math.BigDecimal recomQty;
	private java.math.BigDecimal finalQty;
	private java.math.BigDecimal receivedQty;
	private java.math.BigDecimal acceptedQty;
	private java.math.BigDecimal rejectedQty;
	private java.lang.String rcStatus;
	private java.lang.String fromDepartments;

	// many to one
	private jkt.hms.masters.business.RcHeader header;
	private jkt.hms.masters.business.MasStoreItem item;
	private jkt.hms.masters.business.StoreItemBatchStock stock;
	private jkt.hms.masters.business.MasStoreBrand brand;
	private jkt.hms.masters.business.MasManufacturer manufacturer;



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
	 * Return the value associated with the column: requested_qty
	 */
	public java.math.BigDecimal getRequestedQty () {
		return requestedQty;
	}

	/**
	 * Set the value related to the column: requested_qty
	 * @param requestedQty the requested_qty value
	 */
	public void setRequestedQty (java.math.BigDecimal requestedQty) {
		this.requestedQty = requestedQty;
	}



	/**
	 * Return the value associated with the column: recom_qty
	 */
	public java.math.BigDecimal getRecomQty () {
		return recomQty;
	}

	/**
	 * Set the value related to the column: recom_qty
	 * @param recomQty the recom_qty value
	 */
	public void setRecomQty (java.math.BigDecimal recomQty) {
		this.recomQty = recomQty;
	}



	/**
	 * Return the value associated with the column: final_qty
	 */
	public java.math.BigDecimal getFinalQty () {
		return finalQty;
	}

	/**
	 * Set the value related to the column: final_qty
	 * @param finalQty the final_qty value
	 */
	public void setFinalQty (java.math.BigDecimal finalQty) {
		this.finalQty = finalQty;
	}



	/**
	 * Return the value associated with the column: received_qty
	 */
	public java.math.BigDecimal getReceivedQty () {
		return receivedQty;
	}

	/**
	 * Set the value related to the column: received_qty
	 * @param receivedQty the received_qty value
	 */
	public void setReceivedQty (java.math.BigDecimal receivedQty) {
		this.receivedQty = receivedQty;
	}



	/**
	 * Return the value associated with the column: accepted_qty
	 */
	public java.math.BigDecimal getAcceptedQty () {
		return acceptedQty;
	}

	/**
	 * Set the value related to the column: accepted_qty
	 * @param acceptedQty the accepted_qty value
	 */
	public void setAcceptedQty (java.math.BigDecimal acceptedQty) {
		this.acceptedQty = acceptedQty;
	}



	/**
	 * Return the value associated with the column: rejected_qty
	 */
	public java.math.BigDecimal getRejectedQty () {
		return rejectedQty;
	}

	/**
	 * Set the value related to the column: rejected_qty
	 * @param rejectedQty the rejected_qty value
	 */
	public void setRejectedQty (java.math.BigDecimal rejectedQty) {
		this.rejectedQty = rejectedQty;
	}



	/**
	 * Return the value associated with the column: rc_status
	 */
	public java.lang.String getRcStatus () {
		return rcStatus;
	}

	/**
	 * Set the value related to the column: rc_status
	 * @param rcStatus the rc_status value
	 */
	public void setRcStatus (java.lang.String rcStatus) {
		this.rcStatus = rcStatus;
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
	public jkt.hms.masters.business.RcHeader getHeader () {
		return header;
	}

	/**
	 * Set the value related to the column: header_id
	 * @param header the header_id value
	 */
	public void setHeader (jkt.hms.masters.business.RcHeader header) {
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
	 * Return the value associated with the column: manufacturer_id
	 */
	public jkt.hms.masters.business.MasManufacturer getManufacturer () {
		return manufacturer;
	}

	/**
	 * Set the value related to the column: manufacturer_id
	 * @param manufacturer the manufacturer_id value
	 */
	public void setManufacturer (jkt.hms.masters.business.MasManufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.RcDetails)) return false;
		else {
			jkt.hms.masters.business.RcDetails rcDetails = (jkt.hms.masters.business.RcDetails) obj;
			if (null == this.getId() || null == rcDetails.getId()) return false;
			else return (this.getId().equals(rcDetails.getId()));
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
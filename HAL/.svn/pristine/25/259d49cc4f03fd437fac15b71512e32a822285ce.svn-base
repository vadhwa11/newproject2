package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the store_quotation_receipt_t
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="store_quotation_receipt_t"
 */

public abstract class BaseStoreQuotationReceiptT implements Serializable {

	public static String REF = "StoreQuotationReceiptT";
	public static String PROP_QUOTED_QTY = "QuotedQty";
	public static String PROP_STATUS = "Status";
	public static String PROP_FREE_QTY = "FreeQty";
	public static String PROP_UNIT_OF_MEASUREMENT = "UnitOfMeasurement";
	public static String PROP_ITEM = "Item";
	public static String PROP_TRADE_NAME = "TradeName";
	public static String PROP_FREE_ITEM = "FreeItem";
	public static String PROP_SERIAL_NO = "SerialNo";
	public static String PROP_MANUFACTURER = "Manufacturer";
	public static String PROP_NET_PRICE = "NetPrice";
	public static String PROP_DISCOUNT = "Discount";
	public static String PROP_MASTER = "Master";
	public static String PROP_UNIT_PRICE = "UnitPrice";
	public static String PROP_ID = "Id";
	public static String PROP_TAX = "Tax";

	// constructors
	public BaseStoreQuotationReceiptT() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreQuotationReceiptT(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer serialNo;
	private java.lang.String tradeName;
	private java.math.BigDecimal quotedQty;
	private java.math.BigDecimal freeQty;
	private java.math.BigDecimal unitPrice;
	private java.math.BigDecimal discount;
	private java.math.BigDecimal tax;
	private java.math.BigDecimal netPrice;
	private java.lang.String status;
	private java.lang.String freeItem;

	// many to one
	private jkt.hms.masters.business.StoreQuotationReceiptM master;
	private jkt.hms.masters.business.MasManufacturer manufacturer;
	private jkt.hms.masters.business.MasUnitOfMeasurement unitOfMeasurement;
	private jkt.hms.masters.business.MasStoreItem item;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="transaction_id"
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
	 * Return the value associated with the column: serial_no
	 */
	public java.lang.Integer getSerialNo() {
		return serialNo;
	}

	/**
	 * Set the value related to the column: serial_no
	 * 
	 * @param serialNo
	 *            the serial_no value
	 */
	public void setSerialNo(java.lang.Integer serialNo) {
		this.serialNo = serialNo;
	}

	/**
	 * Return the value associated with the column: trade_name
	 */
	public java.lang.String getTradeName() {
		return tradeName;
	}

	/**
	 * Set the value related to the column: trade_name
	 * 
	 * @param tradeName
	 *            the trade_name value
	 */
	public void setTradeName(java.lang.String tradeName) {
		this.tradeName = tradeName;
	}

	/**
	 * Return the value associated with the column: quoted_qty
	 */
	public java.math.BigDecimal getQuotedQty() {
		return quotedQty;
	}

	/**
	 * Set the value related to the column: quoted_qty
	 * 
	 * @param quotedQty
	 *            the quoted_qty value
	 */
	public void setQuotedQty(java.math.BigDecimal quotedQty) {
		this.quotedQty = quotedQty;
	}

	/**
	 * Return the value associated with the column: free_qty
	 */
	public java.math.BigDecimal getFreeQty() {
		return freeQty;
	}

	/**
	 * Set the value related to the column: free_qty
	 * 
	 * @param freeQty
	 *            the free_qty value
	 */
	public void setFreeQty(java.math.BigDecimal freeQty) {
		this.freeQty = freeQty;
	}

	/**
	 * Return the value associated with the column: unit_price
	 */
	public java.math.BigDecimal getUnitPrice() {
		return unitPrice;
	}

	/**
	 * Set the value related to the column: unit_price
	 * 
	 * @param unitPrice
	 *            the unit_price value
	 */
	public void setUnitPrice(java.math.BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	/**
	 * Return the value associated with the column: discount
	 */
	public java.math.BigDecimal getDiscount() {
		return discount;
	}

	/**
	 * Set the value related to the column: discount
	 * 
	 * @param discount
	 *            the discount value
	 */
	public void setDiscount(java.math.BigDecimal discount) {
		this.discount = discount;
	}

	/**
	 * Return the value associated with the column: tax
	 */
	public java.math.BigDecimal getTax() {
		return tax;
	}

	/**
	 * Set the value related to the column: tax
	 * 
	 * @param tax
	 *            the tax value
	 */
	public void setTax(java.math.BigDecimal tax) {
		this.tax = tax;
	}

	/**
	 * Return the value associated with the column: net_price
	 */
	public java.math.BigDecimal getNetPrice() {
		return netPrice;
	}

	/**
	 * Set the value related to the column: net_price
	 * 
	 * @param netPrice
	 *            the net_price value
	 */
	public void setNetPrice(java.math.BigDecimal netPrice) {
		this.netPrice = netPrice;
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
	 * Return the value associated with the column: free_item
	 */
	public java.lang.String getFreeItem() {
		return freeItem;
	}

	/**
	 * Set the value related to the column: free_item
	 * 
	 * @param freeItem
	 *            the free_item value
	 */
	public void setFreeItem(java.lang.String freeItem) {
		this.freeItem = freeItem;
	}

	/**
	 * Return the value associated with the column: master_id
	 */
	public jkt.hms.masters.business.StoreQuotationReceiptM getMaster() {
		return master;
	}

	/**
	 * Set the value related to the column: master_id
	 * 
	 * @param master
	 *            the master_id value
	 */
	public void setMaster(jkt.hms.masters.business.StoreQuotationReceiptM master) {
		this.master = master;
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
	 * Return the value associated with the column: unit_of_measurement_id
	 */
	public jkt.hms.masters.business.MasUnitOfMeasurement getUnitOfMeasurement() {
		return unitOfMeasurement;
	}

	/**
	 * Set the value related to the column: unit_of_measurement_id
	 * 
	 * @param unitOfMeasurement
	 *            the unit_of_measurement_id value
	 */
	public void setUnitOfMeasurement(
			jkt.hms.masters.business.MasUnitOfMeasurement unitOfMeasurement) {
		this.unitOfMeasurement = unitOfMeasurement;
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

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreQuotationReceiptT))
			return false;
		else {
			jkt.hms.masters.business.StoreQuotationReceiptT storeQuotationReceiptT = (jkt.hms.masters.business.StoreQuotationReceiptT) obj;
			if (null == this.getId() || null == storeQuotationReceiptT.getId())
				return false;
			else
				return (this.getId().equals(storeQuotationReceiptT.getId()));
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
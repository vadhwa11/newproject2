package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the store_indent_t table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="store_indent_t"
 */

public abstract class BaseStoreIndentT  implements Serializable {

	public static String REF = "StoreIndentT";
	public static String PROP_BRAND = "Brand";
	public static String PROP_PO_DETAIL = "PoDetail";
	public static String PROP_LAST_RECEIPT_DATE = "LastReceiptDate";
	public static String PROP_QTY_IN_MMF = "QtyInMmf";
	public static String PROP_TOTAL_COST = "TotalCost";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_MARKETED_BY = "MarketedBy";
	public static String PROP_UNIT_RATE = "UnitRate";
	public static String PROP_SECTION = "Section";
	public static String PROP_MANUFACTURE = "Manufacture";
	public static String PROP_MANUFACTURER = "Manufacturer";
	public static String PROP_QTY_IN_DEMAND = "QtyInDemand";
	public static String PROP_ITEM = "Item";
	public static String PROP_LAST_RECEIPT_QTY = "LastReceiptQty";
	public static String PROP_QTY_RECEIVED = "QtyReceived";
	public static String PROP_SERIAL_NO = "SerialNo";
	public static String PROP_ID = "Id";
	public static String PROP_STOCK_IN = "StockIn";
	public static String PROP_INDENT = "Indent";


	// constructors
	public BaseStoreIndentT () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreIndentT (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseStoreIndentT (
		java.lang.Integer id,
		jkt.hms.masters.business.MasStoreItem item,
		jkt.hms.masters.business.StoreIndentM indent) {

		this.setId(id);
		this.setItem(item);
		this.setIndent(indent);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date lastReceiptDate;
	private java.math.BigDecimal lastReceiptQty;
	private java.lang.String marketedBy;
	private java.math.BigDecimal qtyInDemand;
	private java.math.BigDecimal qtyInMmf;
	private java.math.BigDecimal qtyReceived;
	private java.lang.String remarks;
	private java.lang.Integer serialNo;
	private java.math.BigDecimal stockIn;
	private java.math.BigDecimal totalCost;
	private java.math.BigDecimal unitRate;

	// many to one
	private jkt.hms.masters.business.MasStoreBrand brand;
	private jkt.hms.masters.business.StoreIndentM indent;
	private jkt.hms.masters.business.MasStoreItem item;
	private jkt.hms.masters.business.MasManufacturer manufacture;
	private jkt.hms.masters.business.MasManufacturer manufacturer;
	private jkt.hms.masters.business.StorePoDetail poDetail;
	private jkt.hms.masters.business.MasStoreSection section;

	// collections
	private java.util.Set<jkt.hms.masters.business.StoreSupplyOrderEntry> storeSupplyOrderEntries;



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
	 * Return the value associated with the column: last_receipt_date
	 */
	public java.util.Date getLastReceiptDate () {
		return lastReceiptDate;
	}

	/**
	 * Set the value related to the column: last_receipt_date
	 * @param lastReceiptDate the last_receipt_date value
	 */
	public void setLastReceiptDate (java.util.Date lastReceiptDate) {
		this.lastReceiptDate = lastReceiptDate;
	}



	/**
	 * Return the value associated with the column: last_receipt_qty
	 */
	public java.math.BigDecimal getLastReceiptQty () {
		return lastReceiptQty;
	}

	/**
	 * Set the value related to the column: last_receipt_qty
	 * @param lastReceiptQty the last_receipt_qty value
	 */
	public void setLastReceiptQty (java.math.BigDecimal lastReceiptQty) {
		this.lastReceiptQty = lastReceiptQty;
	}



	/**
	 * Return the value associated with the column: marketed_by
	 */
	public java.lang.String getMarketedBy () {
		return marketedBy;
	}

	/**
	 * Set the value related to the column: marketed_by
	 * @param marketedBy the marketed_by value
	 */
	public void setMarketedBy (java.lang.String marketedBy) {
		this.marketedBy = marketedBy;
	}



	/**
	 * Return the value associated with the column: qty_in_demand
	 */
	public java.math.BigDecimal getQtyInDemand () {
		return qtyInDemand;
	}

	/**
	 * Set the value related to the column: qty_in_demand
	 * @param qtyInDemand the qty_in_demand value
	 */
	public void setQtyInDemand (java.math.BigDecimal qtyInDemand) {
		this.qtyInDemand = qtyInDemand;
	}



	/**
	 * Return the value associated with the column: qty_in_mmf
	 */
	public java.math.BigDecimal getQtyInMmf () {
		return qtyInMmf;
	}

	/**
	 * Set the value related to the column: qty_in_mmf
	 * @param qtyInMmf the qty_in_mmf value
	 */
	public void setQtyInMmf (java.math.BigDecimal qtyInMmf) {
		this.qtyInMmf = qtyInMmf;
	}



	/**
	 * Return the value associated with the column: qty_received
	 */
	public java.math.BigDecimal getQtyReceived () {
		return qtyReceived;
	}

	/**
	 * Set the value related to the column: qty_received
	 * @param qtyReceived the qty_received value
	 */
	public void setQtyReceived (java.math.BigDecimal qtyReceived) {
		this.qtyReceived = qtyReceived;
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
	 * Return the value associated with the column: serial_no
	 */
	public java.lang.Integer getSerialNo () {
		return serialNo;
	}

	/**
	 * Set the value related to the column: serial_no
	 * @param serialNo the serial_no value
	 */
	public void setSerialNo (java.lang.Integer serialNo) {
		this.serialNo = serialNo;
	}



	/**
	 * Return the value associated with the column: stock_in
	 */
	public java.math.BigDecimal getStockIn () {
		return stockIn;
	}

	/**
	 * Set the value related to the column: stock_in
	 * @param stockIn the stock_in value
	 */
	public void setStockIn (java.math.BigDecimal stockIn) {
		this.stockIn = stockIn;
	}



	/**
	 * Return the value associated with the column: total_cost
	 */
	public java.math.BigDecimal getTotalCost () {
		return totalCost;
	}

	/**
	 * Set the value related to the column: total_cost
	 * @param totalCost the total_cost value
	 */
	public void setTotalCost (java.math.BigDecimal totalCost) {
		this.totalCost = totalCost;
	}



	/**
	 * Return the value associated with the column: unit_rate
	 */
	public java.math.BigDecimal getUnitRate () {
		return unitRate;
	}

	/**
	 * Set the value related to the column: unit_rate
	 * @param unitRate the unit_rate value
	 */
	public void setUnitRate (java.math.BigDecimal unitRate) {
		this.unitRate = unitRate;
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
	 * Return the value associated with the column: indent_id
	 */
	public jkt.hms.masters.business.StoreIndentM getIndent () {
		return indent;
	}

	/**
	 * Set the value related to the column: indent_id
	 * @param indent the indent_id value
	 */
	public void setIndent (jkt.hms.masters.business.StoreIndentM indent) {
		this.indent = indent;
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
	 * Return the value associated with the column: manufacture_id
	 */
	public jkt.hms.masters.business.MasManufacturer getManufacture () {
		return manufacture;
	}

	/**
	 * Set the value related to the column: manufacture_id
	 * @param manufacture the manufacture_id value
	 */
	public void setManufacture (jkt.hms.masters.business.MasManufacturer manufacture) {
		this.manufacture = manufacture;
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



	/**
	 * Return the value associated with the column: po_detail_id
	 */
	public jkt.hms.masters.business.StorePoDetail getPoDetail () {
		return poDetail;
	}

	/**
	 * Set the value related to the column: po_detail_id
	 * @param poDetail the po_detail_id value
	 */
	public void setPoDetail (jkt.hms.masters.business.StorePoDetail poDetail) {
		this.poDetail = poDetail;
	}



	/**
	 * Return the value associated with the column: section_id
	 */
	public jkt.hms.masters.business.MasStoreSection getSection () {
		return section;
	}

	/**
	 * Set the value related to the column: section_id
	 * @param section the section_id value
	 */
	public void setSection (jkt.hms.masters.business.MasStoreSection section) {
		this.section = section;
	}



	/**
	 * Return the value associated with the column: StoreSupplyOrderEntries
	 */
	public java.util.Set<jkt.hms.masters.business.StoreSupplyOrderEntry> getStoreSupplyOrderEntries () {
		return storeSupplyOrderEntries;
	}

	/**
	 * Set the value related to the column: StoreSupplyOrderEntries
	 * @param storeSupplyOrderEntries the StoreSupplyOrderEntries value
	 */
	public void setStoreSupplyOrderEntries (java.util.Set<jkt.hms.masters.business.StoreSupplyOrderEntry> storeSupplyOrderEntries) {
		this.storeSupplyOrderEntries = storeSupplyOrderEntries;
	}

	public void addToStoreSupplyOrderEntries (jkt.hms.masters.business.StoreSupplyOrderEntry storeSupplyOrderEntry) {
		if (null == getStoreSupplyOrderEntries()) setStoreSupplyOrderEntries(new java.util.TreeSet<jkt.hms.masters.business.StoreSupplyOrderEntry>());
		getStoreSupplyOrderEntries().add(storeSupplyOrderEntry);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreIndentT)) return false;
		else {
			jkt.hms.masters.business.StoreIndentT storeIndentT = (jkt.hms.masters.business.StoreIndentT) obj;
			if (null == this.getId() || null == storeIndentT.getId()) return false;
			else return (this.getId().equals(storeIndentT.getId()));
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
package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the store_material_purchase_req_t table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="store_material_purchase_req_t"
 */

public abstract class BaseStoreMaterialPurchaseReqT  implements Serializable {

	public static String REF = "StoreMaterialPurchaseReqT";
	public static String PROP_MPR_NO = "MprNo";
	public static String PROP_MPR_QTY = "MprQty";
	public static String PROP_UNIT_RATE = "UnitRate";
	public static String PROP_PREVIOS_SUPPLIER = "PreviosSupplier";
	public static String PROP_SPECIFICATION = "Specification";
	public static String PROP_QTY_IN_STOCK = "QtyInStock";
	public static String PROP_TAX = "Tax";
	public static String PROP_DELIVERY_DATE = "DeliveryDate";
	public static String PROP_PO_DATE = "PoDate";
	public static String PROP_SOURCES = "Sources";
	public static String PROP_PO_DETAIL = "PoDetail";
	public static String PROP_ITEM = "Item";
	public static String PROP_QTY_REQUIRED = "QtyRequired";
	public static String PROP_PREVIOS_PO_NO = "PreviosPoNo";
	public static String PROP_ITEM_RANGE_CAPACITY = "ItemRangeCapacity";
	public static String PROP_HEADER = "Header";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_CURRENCY = "Currency";
	public static String PROP_ESTIMATED_VALUES = "EstimatedValues";
	public static String PROP_PO_RATE = "PoRate";
	public static String PROP_PENDING_QTY_LAST_PO = "PendingQtyLastPo";
	public static String PROP_PREVIOS_PO_QTY = "PreviosPoQty";
	public static String PROP_ID = "Id";
	public static String PROP_AVG_MONTLY_CONSUMPTION = "AvgMontlyConsumption";


	// constructors
	public BaseStoreMaterialPurchaseReqT () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreMaterialPurchaseReqT (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String specification;
	private java.math.BigDecimal qtyRequired;
	private java.math.BigDecimal estimatedValues;
	private java.util.Date deliveryDate;
	private java.math.BigDecimal qtyInStock;
	private java.math.BigDecimal avgMontlyConsumption;
	private java.math.BigDecimal pendingQtyLastPo;
	private java.lang.String mprNo;
	private java.lang.String remarks;
	private java.math.BigDecimal mprQty;
	private java.math.BigDecimal previosPoQty;
	private java.lang.String previosPoNo;
	private java.lang.String previosSupplier;
	private java.math.BigDecimal poRate;
	private java.util.Date poDate;
	private java.math.BigDecimal unitRate;
	private java.lang.String tax;
	private java.lang.String sources;
	private java.lang.String itemRangeCapacity;

	// many to one
	private jkt.hms.masters.business.StorePoDetail poDetail;
	private jkt.hms.masters.business.StoreMaterialPurchaseReqM header;
	private jkt.hms.masters.business.MasStoreItem item;
	private jkt.hms.masters.business.MasCurrency currency;

	// collections
	private java.util.Set<jkt.hms.masters.business.StoreQuotationRequestT> storeQuotationRequestTs;



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
	 * Return the value associated with the column: specification
	 */
	public java.lang.String getSpecification () {
		return specification;
	}

	/**
	 * Set the value related to the column: specification
	 * @param specification the specification value
	 */
	public void setSpecification (java.lang.String specification) {
		this.specification = specification;
	}



	/**
	 * Return the value associated with the column: qty_required
	 */
	public java.math.BigDecimal getQtyRequired () {
		return qtyRequired;
	}

	/**
	 * Set the value related to the column: qty_required
	 * @param qtyRequired the qty_required value
	 */
	public void setQtyRequired (java.math.BigDecimal qtyRequired) {
		this.qtyRequired = qtyRequired;
	}



	/**
	 * Return the value associated with the column: estimated_values
	 */
	public java.math.BigDecimal getEstimatedValues () {
		return estimatedValues;
	}

	/**
	 * Set the value related to the column: estimated_values
	 * @param estimatedValues the estimated_values value
	 */
	public void setEstimatedValues (java.math.BigDecimal estimatedValues) {
		this.estimatedValues = estimatedValues;
	}



	/**
	 * Return the value associated with the column: delivery_date
	 */
	public java.util.Date getDeliveryDate () {
		return deliveryDate;
	}

	/**
	 * Set the value related to the column: delivery_date
	 * @param deliveryDate the delivery_date value
	 */
	public void setDeliveryDate (java.util.Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}



	/**
	 * Return the value associated with the column: qty_in_stock
	 */
	public java.math.BigDecimal getQtyInStock () {
		return qtyInStock;
	}

	/**
	 * Set the value related to the column: qty_in_stock
	 * @param qtyInStock the qty_in_stock value
	 */
	public void setQtyInStock (java.math.BigDecimal qtyInStock) {
		this.qtyInStock = qtyInStock;
	}



	/**
	 * Return the value associated with the column: avg_montly_consumption
	 */
	public java.math.BigDecimal getAvgMontlyConsumption () {
		return avgMontlyConsumption;
	}

	/**
	 * Set the value related to the column: avg_montly_consumption
	 * @param avgMontlyConsumption the avg_montly_consumption value
	 */
	public void setAvgMontlyConsumption (java.math.BigDecimal avgMontlyConsumption) {
		this.avgMontlyConsumption = avgMontlyConsumption;
	}



	/**
	 * Return the value associated with the column: pending_qty_last_po
	 */
	public java.math.BigDecimal getPendingQtyLastPo () {
		return pendingQtyLastPo;
	}

	/**
	 * Set the value related to the column: pending_qty_last_po
	 * @param pendingQtyLastPo the pending_qty_last_po value
	 */
	public void setPendingQtyLastPo (java.math.BigDecimal pendingQtyLastPo) {
		this.pendingQtyLastPo = pendingQtyLastPo;
	}



	/**
	 * Return the value associated with the column: mpr_no
	 */
	public java.lang.String getMprNo () {
		return mprNo;
	}

	/**
	 * Set the value related to the column: mpr_no
	 * @param mprNo the mpr_no value
	 */
	public void setMprNo (java.lang.String mprNo) {
		this.mprNo = mprNo;
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
	 * Return the value associated with the column: mpr_qty
	 */
	public java.math.BigDecimal getMprQty () {
		return mprQty;
	}

	/**
	 * Set the value related to the column: mpr_qty
	 * @param mprQty the mpr_qty value
	 */
	public void setMprQty (java.math.BigDecimal mprQty) {
		this.mprQty = mprQty;
	}



	/**
	 * Return the value associated with the column: previos_po_qty
	 */
	public java.math.BigDecimal getPreviosPoQty () {
		return previosPoQty;
	}

	/**
	 * Set the value related to the column: previos_po_qty
	 * @param previosPoQty the previos_po_qty value
	 */
	public void setPreviosPoQty (java.math.BigDecimal previosPoQty) {
		this.previosPoQty = previosPoQty;
	}



	/**
	 * Return the value associated with the column: previos_po_no
	 */
	public java.lang.String getPreviosPoNo () {
		return previosPoNo;
	}

	/**
	 * Set the value related to the column: previos_po_no
	 * @param previosPoNo the previos_po_no value
	 */
	public void setPreviosPoNo (java.lang.String previosPoNo) {
		this.previosPoNo = previosPoNo;
	}



	/**
	 * Return the value associated with the column: previos_supplier
	 */
	public java.lang.String getPreviosSupplier () {
		return previosSupplier;
	}

	/**
	 * Set the value related to the column: previos_supplier
	 * @param previosSupplier the previos_supplier value
	 */
	public void setPreviosSupplier (java.lang.String previosSupplier) {
		this.previosSupplier = previosSupplier;
	}



	/**
	 * Return the value associated with the column: po_rate
	 */
	public java.math.BigDecimal getPoRate () {
		return poRate;
	}

	/**
	 * Set the value related to the column: po_rate
	 * @param poRate the po_rate value
	 */
	public void setPoRate (java.math.BigDecimal poRate) {
		this.poRate = poRate;
	}



	/**
	 * Return the value associated with the column: po_date
	 */
	public java.util.Date getPoDate () {
		return poDate;
	}

	/**
	 * Set the value related to the column: po_date
	 * @param poDate the po_date value
	 */
	public void setPoDate (java.util.Date poDate) {
		this.poDate = poDate;
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
	 * Return the value associated with the column: tax
	 */
	public java.lang.String getTax () {
		return tax;
	}

	/**
	 * Set the value related to the column: tax
	 * @param tax the tax value
	 */
	public void setTax (java.lang.String tax) {
		this.tax = tax;
	}



	/**
	 * Return the value associated with the column: sources
	 */
	public java.lang.String getSources () {
		return sources;
	}

	/**
	 * Set the value related to the column: sources
	 * @param sources the sources value
	 */
	public void setSources (java.lang.String sources) {
		this.sources = sources;
	}



	/**
	 * Return the value associated with the column: item_range_capacity
	 */
	public java.lang.String getItemRangeCapacity () {
		return itemRangeCapacity;
	}

	/**
	 * Set the value related to the column: item_range_capacity
	 * @param itemRangeCapacity the item_range_capacity value
	 */
	public void setItemRangeCapacity (java.lang.String itemRangeCapacity) {
		this.itemRangeCapacity = itemRangeCapacity;
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
	 * Return the value associated with the column: header_id
	 */
	public jkt.hms.masters.business.StoreMaterialPurchaseReqM getHeader () {
		return header;
	}

	/**
	 * Set the value related to the column: header_id
	 * @param header the header_id value
	 */
	public void setHeader (jkt.hms.masters.business.StoreMaterialPurchaseReqM header) {
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
	 * Return the value associated with the column: currency_id
	 */
	public jkt.hms.masters.business.MasCurrency getCurrency () {
		return currency;
	}

	/**
	 * Set the value related to the column: currency_id
	 * @param currency the currency_id value
	 */
	public void setCurrency (jkt.hms.masters.business.MasCurrency currency) {
		this.currency = currency;
	}



	/**
	 * Return the value associated with the column: StoreQuotationRequestTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreQuotationRequestT> getStoreQuotationRequestTs () {
		return storeQuotationRequestTs;
	}

	/**
	 * Set the value related to the column: StoreQuotationRequestTs
	 * @param storeQuotationRequestTs the StoreQuotationRequestTs value
	 */
	public void setStoreQuotationRequestTs (java.util.Set<jkt.hms.masters.business.StoreQuotationRequestT> storeQuotationRequestTs) {
		this.storeQuotationRequestTs = storeQuotationRequestTs;
	}

	public void addToStoreQuotationRequestTs (jkt.hms.masters.business.StoreQuotationRequestT storeQuotationRequestT) {
		if (null == getStoreQuotationRequestTs()) setStoreQuotationRequestTs(new java.util.TreeSet<jkt.hms.masters.business.StoreQuotationRequestT>());
		getStoreQuotationRequestTs().add(storeQuotationRequestT);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreMaterialPurchaseReqT)) return false;
		else {
			jkt.hms.masters.business.StoreMaterialPurchaseReqT storeMaterialPurchaseReqT = (jkt.hms.masters.business.StoreMaterialPurchaseReqT) obj;
			if (null == this.getId() || null == storeMaterialPurchaseReqT.getId()) return false;
			else return (this.getId().equals(storeMaterialPurchaseReqT.getId()));
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
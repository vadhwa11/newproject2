package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the store_po_detail table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="store_po_detail"
 */

public abstract class BaseStorePoDetail  implements Serializable {

	public static String REF = "StorePoDetail";
	public static String PROP_BRAND = "Brand";
	public static String PROP_CHEMICAL_COMPOSITION = "ChemicalComposition";
	public static String PROP_DISCOUNT_PERCENT = "DiscountPercent";
	public static String PROP_REJECTED_QTY = "RejectedQty";
	public static String PROP_QUANTITY_RECEIVED = "QuantityReceived";
	public static String PROP_EXCISEDUTY = "Exciseduty";
	public static String PROP_CANCELLED = "Cancelled";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_TAXAMT_MDQ = "TaxamtMdq";
	public static String PROP_DISCOUNT_AMOUNT = "DiscountAmount";
	public static String PROP_QTY_ADVISED = "QtyAdvised";
	public static String PROP_UNIT_RATE = "UnitRate";
	public static String PROP_TAX_OQ = "TaxOq";
	public static String PROP_MANUFACTURER = "Manufacturer";
	public static String PROP_ITEM = "Item";
	public static String PROP_MDQ_VALUE = "MdqValue";
	public static String PROP_SERIAL_NO = "SerialNo";
	public static String PROP_QUOTATION_DETAILS = "QuotationDetails";
	public static String PROP_RE_SUPPLIER = "ReSupplier";
	public static String PROP_TAX_PERCENT = "TaxPercent";
	public static String PROP_BRANDED_GENERIC = "BrandedGeneric";
	public static String PROP_AMOUNT = "Amount";
	public static String PROP_ACCEPTED_QTY = "AcceptedQty";
	public static String PROP_DISP_TYPE = "DispType";
	public static String PROP_CLOSED = "Closed";
	public static String PROP_RATE_PER_MDQ = "RatePerMdq";
	public static String PROP_PO = "Po";
	public static String PROP_RE_SUPPLY_ORDER = "ReSupplyOrder";
	public static String PROP_TAX_AMOUNT = "TaxAmount";
	public static String PROP_QUANTITY_ORDERED = "QuantityOrdered";
	public static String PROP_NOTES = "Notes";
	public static String PROP_MRP = "Mrp";
	public static String PROP_FREE_QUANTITY = "FreeQuantity";
	public static String PROP_FREE_ITEM = "FreeItem";
	public static String PROP_ID = "Id";
	public static String PROP_OTHER_TAXES = "OtherTaxes";
	public static String PROP_LSO_QTY = "LsoQty";


	// constructors
	public BaseStorePoDetail () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStorePoDetail (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.math.BigDecimal acceptedQty;
	private java.math.BigDecimal amount;
	private java.lang.String brandedGeneric;
	private java.lang.String cancelled;
	private java.lang.String chemicalComposition;
	private java.lang.String closed;
	private java.math.BigDecimal discountAmount;
	private java.math.BigDecimal discountPercent;
	private java.lang.String dispType;
	private java.math.BigDecimal exciseduty;
	private java.lang.String freeItem;
	private java.math.BigDecimal freeQuantity;
	private java.math.BigDecimal lsoQty;
	private java.math.BigDecimal mdqValue;
	private java.math.BigDecimal mrp;
	private java.lang.String notes;
	private java.lang.String otherTaxes;
	private java.math.BigDecimal qtyAdvised;
	private java.math.BigDecimal quantityOrdered;
	private java.math.BigDecimal quantityReceived;
	private java.math.BigDecimal ratePerMdq;
	private java.math.BigDecimal rejectedQty;
	private java.lang.String remarks;
	private java.lang.Integer serialNo;
	private java.math.BigDecimal taxAmount;
	private java.math.BigDecimal taxOq;
	private java.math.BigDecimal taxPercent;
	private java.math.BigDecimal taxamtMdq;
	private java.math.BigDecimal unitRate;

	// many to one
	private jkt.hms.masters.business.MasStoreBrand brand;
	private jkt.hms.masters.business.MasStoreItem item;
	private jkt.hms.masters.business.MasManufacturer manufacturer;
	private jkt.hms.masters.business.StorePoHeader po;
	private jkt.hms.masters.business.StoreQuotationRequestT quotationDetails;
	private jkt.hms.masters.business.MasStoreSupplier reSupplier;
	private jkt.hms.masters.business.StorePoHeader reSupplyOrder;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="po_detail_id"
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
	 * Return the value associated with the column: amount
	 */
	public java.math.BigDecimal getAmount () {
		return amount;
	}

	/**
	 * Set the value related to the column: amount
	 * @param amount the amount value
	 */
	public void setAmount (java.math.BigDecimal amount) {
		this.amount = amount;
	}



	/**
	 * Return the value associated with the column: BRANDED_GENERIC
	 */
	public java.lang.String getBrandedGeneric () {
		return brandedGeneric;
	}

	/**
	 * Set the value related to the column: BRANDED_GENERIC
	 * @param brandedGeneric the BRANDED_GENERIC value
	 */
	public void setBrandedGeneric (java.lang.String brandedGeneric) {
		this.brandedGeneric = brandedGeneric;
	}



	/**
	 * Return the value associated with the column: cancelled
	 */
	public java.lang.String getCancelled () {
		return cancelled;
	}

	/**
	 * Set the value related to the column: cancelled
	 * @param cancelled the cancelled value
	 */
	public void setCancelled (java.lang.String cancelled) {
		this.cancelled = cancelled;
	}



	/**
	 * Return the value associated with the column: chemical_composition
	 */
	public java.lang.String getChemicalComposition () {
		return chemicalComposition;
	}

	/**
	 * Set the value related to the column: chemical_composition
	 * @param chemicalComposition the chemical_composition value
	 */
	public void setChemicalComposition (java.lang.String chemicalComposition) {
		this.chemicalComposition = chemicalComposition;
	}



	/**
	 * Return the value associated with the column: closed
	 */
	public java.lang.String getClosed () {
		return closed;
	}

	/**
	 * Set the value related to the column: closed
	 * @param closed the closed value
	 */
	public void setClosed (java.lang.String closed) {
		this.closed = closed;
	}



	/**
	 * Return the value associated with the column: discount_amount
	 */
	public java.math.BigDecimal getDiscountAmount () {
		return discountAmount;
	}

	/**
	 * Set the value related to the column: discount_amount
	 * @param discountAmount the discount_amount value
	 */
	public void setDiscountAmount (java.math.BigDecimal discountAmount) {
		this.discountAmount = discountAmount;
	}



	/**
	 * Return the value associated with the column: discount_percent
	 */
	public java.math.BigDecimal getDiscountPercent () {
		return discountPercent;
	}

	/**
	 * Set the value related to the column: discount_percent
	 * @param discountPercent the discount_percent value
	 */
	public void setDiscountPercent (java.math.BigDecimal discountPercent) {
		this.discountPercent = discountPercent;
	}



	/**
	 * Return the value associated with the column: disp_type
	 */
	public java.lang.String getDispType () {
		return dispType;
	}

	/**
	 * Set the value related to the column: disp_type
	 * @param dispType the disp_type value
	 */
	public void setDispType (java.lang.String dispType) {
		this.dispType = dispType;
	}



	/**
	 * Return the value associated with the column: exciseduty
	 */
	public java.math.BigDecimal getExciseduty () {
		return exciseduty;
	}

	/**
	 * Set the value related to the column: exciseduty
	 * @param exciseduty the exciseduty value
	 */
	public void setExciseduty (java.math.BigDecimal exciseduty) {
		this.exciseduty = exciseduty;
	}



	/**
	 * Return the value associated with the column: free_item
	 */
	public java.lang.String getFreeItem () {
		return freeItem;
	}

	/**
	 * Set the value related to the column: free_item
	 * @param freeItem the free_item value
	 */
	public void setFreeItem (java.lang.String freeItem) {
		this.freeItem = freeItem;
	}



	/**
	 * Return the value associated with the column: free_quantity
	 */
	public java.math.BigDecimal getFreeQuantity () {
		return freeQuantity;
	}

	/**
	 * Set the value related to the column: free_quantity
	 * @param freeQuantity the free_quantity value
	 */
	public void setFreeQuantity (java.math.BigDecimal freeQuantity) {
		this.freeQuantity = freeQuantity;
	}



	/**
	 * Return the value associated with the column: lso_qty
	 */
	public java.math.BigDecimal getLsoQty () {
		return lsoQty;
	}

	/**
	 * Set the value related to the column: lso_qty
	 * @param lsoQty the lso_qty value
	 */
	public void setLsoQty (java.math.BigDecimal lsoQty) {
		this.lsoQty = lsoQty;
	}



	/**
	 * Return the value associated with the column: mdq_value
	 */
	public java.math.BigDecimal getMdqValue () {
		return mdqValue;
	}

	/**
	 * Set the value related to the column: mdq_value
	 * @param mdqValue the mdq_value value
	 */
	public void setMdqValue (java.math.BigDecimal mdqValue) {
		this.mdqValue = mdqValue;
	}



	/**
	 * Return the value associated with the column: mrp
	 */
	public java.math.BigDecimal getMrp () {
		return mrp;
	}

	/**
	 * Set the value related to the column: mrp
	 * @param mrp the mrp value
	 */
	public void setMrp (java.math.BigDecimal mrp) {
		this.mrp = mrp;
	}



	/**
	 * Return the value associated with the column: notes
	 */
	public java.lang.String getNotes () {
		return notes;
	}

	/**
	 * Set the value related to the column: notes
	 * @param notes the notes value
	 */
	public void setNotes (java.lang.String notes) {
		this.notes = notes;
	}



	/**
	 * Return the value associated with the column: other_taxes
	 */
	public java.lang.String getOtherTaxes () {
		return otherTaxes;
	}

	/**
	 * Set the value related to the column: other_taxes
	 * @param otherTaxes the other_taxes value
	 */
	public void setOtherTaxes (java.lang.String otherTaxes) {
		this.otherTaxes = otherTaxes;
	}



	/**
	 * Return the value associated with the column: qty_advised
	 */
	public java.math.BigDecimal getQtyAdvised () {
		return qtyAdvised;
	}

	/**
	 * Set the value related to the column: qty_advised
	 * @param qtyAdvised the qty_advised value
	 */
	public void setQtyAdvised (java.math.BigDecimal qtyAdvised) {
		this.qtyAdvised = qtyAdvised;
	}



	/**
	 * Return the value associated with the column: quantity_ordered
	 */
	public java.math.BigDecimal getQuantityOrdered () {
		return quantityOrdered;
	}

	/**
	 * Set the value related to the column: quantity_ordered
	 * @param quantityOrdered the quantity_ordered value
	 */
	public void setQuantityOrdered (java.math.BigDecimal quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}



	/**
	 * Return the value associated with the column: quantity_received
	 */
	public java.math.BigDecimal getQuantityReceived () {
		return quantityReceived;
	}

	/**
	 * Set the value related to the column: quantity_received
	 * @param quantityReceived the quantity_received value
	 */
	public void setQuantityReceived (java.math.BigDecimal quantityReceived) {
		this.quantityReceived = quantityReceived;
	}



	/**
	 * Return the value associated with the column: rate_per_mdq
	 */
	public java.math.BigDecimal getRatePerMdq () {
		return ratePerMdq;
	}

	/**
	 * Set the value related to the column: rate_per_mdq
	 * @param ratePerMdq the rate_per_mdq value
	 */
	public void setRatePerMdq (java.math.BigDecimal ratePerMdq) {
		this.ratePerMdq = ratePerMdq;
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
	 * Return the value associated with the column: tax_amount
	 */
	public java.math.BigDecimal getTaxAmount () {
		return taxAmount;
	}

	/**
	 * Set the value related to the column: tax_amount
	 * @param taxAmount the tax_amount value
	 */
	public void setTaxAmount (java.math.BigDecimal taxAmount) {
		this.taxAmount = taxAmount;
	}



	/**
	 * Return the value associated with the column: tax_oq
	 */
	public java.math.BigDecimal getTaxOq () {
		return taxOq;
	}

	/**
	 * Set the value related to the column: tax_oq
	 * @param taxOq the tax_oq value
	 */
	public void setTaxOq (java.math.BigDecimal taxOq) {
		this.taxOq = taxOq;
	}



	/**
	 * Return the value associated with the column: tax_percent
	 */
	public java.math.BigDecimal getTaxPercent () {
		return taxPercent;
	}

	/**
	 * Set the value related to the column: tax_percent
	 * @param taxPercent the tax_percent value
	 */
	public void setTaxPercent (java.math.BigDecimal taxPercent) {
		this.taxPercent = taxPercent;
	}



	/**
	 * Return the value associated with the column: taxamt_mdq
	 */
	public java.math.BigDecimal getTaxamtMdq () {
		return taxamtMdq;
	}

	/**
	 * Set the value related to the column: taxamt_mdq
	 * @param taxamtMdq the taxamt_mdq value
	 */
	public void setTaxamtMdq (java.math.BigDecimal taxamtMdq) {
		this.taxamtMdq = taxamtMdq;
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
	 * Return the value associated with the column: po_id
	 */
	public jkt.hms.masters.business.StorePoHeader getPo () {
		return po;
	}

	/**
	 * Set the value related to the column: po_id
	 * @param po the po_id value
	 */
	public void setPo (jkt.hms.masters.business.StorePoHeader po) {
		this.po = po;
	}



	/**
	 * Return the value associated with the column: quotation_details_id
	 */
	public jkt.hms.masters.business.StoreQuotationRequestT getQuotationDetails () {
		return quotationDetails;
	}

	/**
	 * Set the value related to the column: quotation_details_id
	 * @param quotationDetails the quotation_details_id value
	 */
	public void setQuotationDetails (jkt.hms.masters.business.StoreQuotationRequestT quotationDetails) {
		this.quotationDetails = quotationDetails;
	}



	/**
	 * Return the value associated with the column: re_supplier_id
	 */
	public jkt.hms.masters.business.MasStoreSupplier getReSupplier () {
		return reSupplier;
	}

	/**
	 * Set the value related to the column: re_supplier_id
	 * @param reSupplier the re_supplier_id value
	 */
	public void setReSupplier (jkt.hms.masters.business.MasStoreSupplier reSupplier) {
		this.reSupplier = reSupplier;
	}



	/**
	 * Return the value associated with the column: re_supply_order
	 */
	public jkt.hms.masters.business.StorePoHeader getReSupplyOrder () {
		return reSupplyOrder;
	}

	/**
	 * Set the value related to the column: re_supply_order
	 * @param reSupplyOrder the re_supply_order value
	 */
	public void setReSupplyOrder (jkt.hms.masters.business.StorePoHeader reSupplyOrder) {
		this.reSupplyOrder = reSupplyOrder;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.StorePoDetail)) return false;
		else {
			jkt.hms.masters.business.StorePoDetail storePoDetail = (jkt.hms.masters.business.StorePoDetail) obj;
			if (null == this.getId() || null == storePoDetail.getId()) return false;
			else return (this.getId().equals(storePoDetail.getId()));
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
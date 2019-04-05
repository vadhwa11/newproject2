package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the store_tender_local_purchase_t table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="store_tender_local_purchase_t"
 */

public abstract class BaseStoreTenderLocalPurchaseT  implements Serializable {

	public static String REF = "StoreTenderLocalPurchaseT";
	public static String PROP_AMOUNT = "Amount";
	public static String PROP_DISP_TYPE = "DispType";
	public static String PROP_PO = "Po";
	public static String PROP_NEW_RATE_MDQ = "NewRateMdq";
	public static String PROP_STORE_TENDER_LOCAL_PURCHASE_M = "StoreTenderLocalPurchaseM";
	public static String PROP_LCAT = "Lcat";
	public static String PROP_MANUFACTURER_NAME = "ManufacturerName";
	public static String PROP_FINAL_PRICE_PER_MDQ = "FinalPricePerMdq";
	public static String PROP_SUPPLIER = "Supplier";
	public static String PROP_ITEM = "Item";
	public static String PROP_QTY_RECD = "QtyRecd";
	public static String PROP_MDQ_VALUE = "MdqValue";
	public static String PROP_ACTUAL_QTY = "ActualQty";
	public static String PROP_ID = "Id";
	public static String PROP_SR_NO = "SrNo";
	public static String PROP_NEW_TAX_AMT_MDQ = "NewTaxAmtMdq";
	public static String PROP_BRAND_NAME = "BrandName";


	// constructors
	public BaseStoreTenderLocalPurchaseT () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreTenderLocalPurchaseT (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer srNo;
	private java.lang.String brandName;
	private java.lang.String manufacturerName;
	private java.lang.String lcat;
	private java.math.BigDecimal mdqValue;
	private java.math.BigDecimal finalPricePerMdq;
	private java.lang.Integer qtyRecd;
	private java.lang.Integer actualQty;
	private java.math.BigDecimal amount;
	private java.lang.String dispType;
	private java.math.BigDecimal newRateMdq;
	private java.math.BigDecimal newTaxAmtMdq;

	// many to one
	private jkt.hms.masters.business.MasStoreSupplier supplier;
	private jkt.hms.masters.business.MasStoreItem item;
	private jkt.hms.masters.business.StoreTenderLocalPurchaseM storeTenderLocalPurchaseM;
	private jkt.hms.masters.business.StorePoHeader po;



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
	 * Return the value associated with the column: brand_name
	 */
	public java.lang.String getBrandName () {
		return brandName;
	}

	/**
	 * Set the value related to the column: brand_name
	 * @param brandName the brand_name value
	 */
	public void setBrandName (java.lang.String brandName) {
		this.brandName = brandName;
	}



	/**
	 * Return the value associated with the column: manufacturer_name
	 */
	public java.lang.String getManufacturerName () {
		return manufacturerName;
	}

	/**
	 * Set the value related to the column: manufacturer_name
	 * @param manufacturerName the manufacturer_name value
	 */
	public void setManufacturerName (java.lang.String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}



	/**
	 * Return the value associated with the column: lcat
	 */
	public java.lang.String getLcat () {
		return lcat;
	}

	/**
	 * Set the value related to the column: lcat
	 * @param lcat the lcat value
	 */
	public void setLcat (java.lang.String lcat) {
		this.lcat = lcat;
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
	 * Return the value associated with the column: final_price_per_mdq
	 */
	public java.math.BigDecimal getFinalPricePerMdq () {
		return finalPricePerMdq;
	}

	/**
	 * Set the value related to the column: final_price_per_mdq
	 * @param finalPricePerMdq the final_price_per_mdq value
	 */
	public void setFinalPricePerMdq (java.math.BigDecimal finalPricePerMdq) {
		this.finalPricePerMdq = finalPricePerMdq;
	}



	/**
	 * Return the value associated with the column: qty_recd
	 */
	public java.lang.Integer getQtyRecd () {
		return qtyRecd;
	}

	/**
	 * Set the value related to the column: qty_recd
	 * @param qtyRecd the qty_recd value
	 */
	public void setQtyRecd (java.lang.Integer qtyRecd) {
		this.qtyRecd = qtyRecd;
	}



	/**
	 * Return the value associated with the column: actual_qty
	 */
	public java.lang.Integer getActualQty () {
		return actualQty;
	}

	/**
	 * Set the value related to the column: actual_qty
	 * @param actualQty the actual_qty value
	 */
	public void setActualQty (java.lang.Integer actualQty) {
		this.actualQty = actualQty;
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
	 * Return the value associated with the column: new_rate_mdq
	 */
	public java.math.BigDecimal getNewRateMdq () {
		return newRateMdq;
	}

	/**
	 * Set the value related to the column: new_rate_mdq
	 * @param newRateMdq the new_rate_mdq value
	 */
	public void setNewRateMdq (java.math.BigDecimal newRateMdq) {
		this.newRateMdq = newRateMdq;
	}



	/**
	 * Return the value associated with the column: new_taxamt_mdq
	 */
	public java.math.BigDecimal getNewTaxAmtMdq () {
		return newTaxAmtMdq;
	}

	/**
	 * Set the value related to the column: new_taxamt_mdq
	 * @param newTaxAmtMdq the new_taxamt_mdq value
	 */
	public void setNewTaxAmtMdq (java.math.BigDecimal newTaxAmtMdq) {
		this.newTaxAmtMdq = newTaxAmtMdq;
	}



	/**
	 * Return the value associated with the column: supplier_id
	 */
	public jkt.hms.masters.business.MasStoreSupplier getSupplier () {
		return supplier;
	}

	/**
	 * Set the value related to the column: supplier_id
	 * @param supplier the supplier_id value
	 */
	public void setSupplier (jkt.hms.masters.business.MasStoreSupplier supplier) {
		this.supplier = supplier;
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
	 * Return the value associated with the column: store_tender_local_purchase_m_id
	 */
	public jkt.hms.masters.business.StoreTenderLocalPurchaseM getStoreTenderLocalPurchaseM () {
		return storeTenderLocalPurchaseM;
	}

	/**
	 * Set the value related to the column: store_tender_local_purchase_m_id
	 * @param storeTenderLocalPurchaseM the store_tender_local_purchase_m_id value
	 */
	public void setStoreTenderLocalPurchaseM (jkt.hms.masters.business.StoreTenderLocalPurchaseM storeTenderLocalPurchaseM) {
		this.storeTenderLocalPurchaseM = storeTenderLocalPurchaseM;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreTenderLocalPurchaseT)) return false;
		else {
			jkt.hms.masters.business.StoreTenderLocalPurchaseT storeTenderLocalPurchaseT = (jkt.hms.masters.business.StoreTenderLocalPurchaseT) obj;
			if (null == this.getId() || null == storeTenderLocalPurchaseT.getId()) return false;
			else return (this.getId().equals(storeTenderLocalPurchaseT.getId()));
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
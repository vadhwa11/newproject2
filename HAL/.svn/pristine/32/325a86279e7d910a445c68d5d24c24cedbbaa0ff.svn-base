package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the store_tender_comm_bid_t
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="store_tender_comm_bid_t"
 */

public abstract class BaseStoreTenderCommBidT implements Serializable {

	public static String REF = "StoreTenderCommBidT";
	public static String PROP_NEW_RATE_PER_MDQ = "NewRatePerMdq";
	public static String PROP_COMM_BID = "CommBid";
	public static String PROP_DISP_TYPE = "DispType";
	public static String PROP_VAT_PERCENT = "VatPercent";
	public static String PROP_RATE_PER_MDQ = "RatePerMdq";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_TAX_AMOUNT_MDQ = "TaxAmountMdq";
	public static String PROP_LCAT = "Lcat";
	public static String PROP_QUALIFIED = "Qualified";
	public static String PROP_MANUFACTURER_NAME = "ManufacturerName";
	public static String PROP_MRP = "Mrp";
	public static String PROP_SUPPLIER = "Supplier";
	public static String PROP_FINAL_PRICE_PER_MDQ = "FinalPricePerMdq";
	public static String PROP_MDQ_VALUE = "MdqValue";
	public static String PROP_ID = "Id";
	public static String PROP_NEW_TOT_RATE_MDQ = "NewTotRateMdq";
	public static String PROP_NEW_TAX_AMT_PER_MDQ = "NewTaxAmtPerMdq";
	public static String PROP_COMP_RATE = "CompRate";
	public static String PROP_SR_NO = "SrNo";
	public static String PROP_TOT_RATE_MDQ = "TotRateMdq";
	public static String PROP_COMPOSITION = "Composition";
	public static String PROP_BRAND_NAME = "BrandName";

	// constructors
	public BaseStoreTenderCommBidT() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreTenderCommBidT(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseStoreTenderCommBidT(java.lang.Integer id,
			jkt.hms.masters.business.StoreTenderCommBidM commBid,
			jkt.hms.masters.business.MasStoreSupplier supplier,
			java.lang.Integer srNo, java.lang.String dispType,
			java.math.BigDecimal mdqValue, java.math.BigDecimal ratePerMdq,
			java.math.BigDecimal taxAmountMdq, java.math.BigDecimal totRateMdq,
			java.math.BigDecimal newRatePerMdq,
			java.math.BigDecimal newTaxAmtPerMdq,
			java.math.BigDecimal newTotRateMdq) {

		this.setId(id);
		this.setCommBid(commBid);
		this.setSupplier(supplier);
		this.setSrNo(srNo);
		this.setDispType(dispType);
		this.setMdqValue(mdqValue);
		this.setRatePerMdq(ratePerMdq);
		this.setTaxAmountMdq(taxAmountMdq);
		this.setTotRateMdq(totRateMdq);
		this.setNewRatePerMdq(newRatePerMdq);
		this.setNewTaxAmtPerMdq(newTaxAmtPerMdq);
		this.setNewTotRateMdq(newTotRateMdq);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer srNo;
	private java.lang.String brandName;
	private java.lang.String manufacturerName;
	private java.lang.String dispType;
	private java.math.BigDecimal mdqValue;
	private java.math.BigDecimal vatPercent;
	private java.math.BigDecimal ratePerMdq;
	private java.math.BigDecimal compRate;
	private java.lang.String lcat;
	private java.math.BigDecimal finalPricePerMdq;
	private java.lang.String remarks;
	private java.lang.String qualified;
	private java.math.BigDecimal mrp;
	private java.lang.String composition;
	private java.math.BigDecimal taxAmountMdq;
	private java.math.BigDecimal totRateMdq;
	private java.math.BigDecimal newRatePerMdq;
	private java.math.BigDecimal newTaxAmtPerMdq;
	private java.math.BigDecimal newTotRateMdq;

	// many to one
	private jkt.hms.masters.business.StoreTenderCommBidM commBid;
	private jkt.hms.masters.business.MasStoreSupplier supplier;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="id"
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
	 * Return the value associated with the column: sr_no
	 */
	public java.lang.Integer getSrNo() {
		return srNo;
	}

	/**
	 * Set the value related to the column: sr_no
	 * 
	 * @param srNo
	 *            the sr_no value
	 */
	public void setSrNo(java.lang.Integer srNo) {
		this.srNo = srNo;
	}

	/**
	 * Return the value associated with the column: brand_name
	 */
	public java.lang.String getBrandName() {
		return brandName;
	}

	/**
	 * Set the value related to the column: brand_name
	 * 
	 * @param brandName
	 *            the brand_name value
	 */
	public void setBrandName(java.lang.String brandName) {
		this.brandName = brandName;
	}

	/**
	 * Return the value associated with the column: manufacturer_name
	 */
	public java.lang.String getManufacturerName() {
		return manufacturerName;
	}

	/**
	 * Set the value related to the column: manufacturer_name
	 * 
	 * @param manufacturerName
	 *            the manufacturer_name value
	 */
	public void setManufacturerName(java.lang.String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	/**
	 * Return the value associated with the column: disp_type
	 */
	public java.lang.String getDispType() {
		return dispType;
	}

	/**
	 * Set the value related to the column: disp_type
	 * 
	 * @param dispType
	 *            the disp_type value
	 */
	public void setDispType(java.lang.String dispType) {
		this.dispType = dispType;
	}

	/**
	 * Return the value associated with the column: mdq_value
	 */
	public java.math.BigDecimal getMdqValue() {
		return mdqValue;
	}

	/**
	 * Set the value related to the column: mdq_value
	 * 
	 * @param mdqValue
	 *            the mdq_value value
	 */
	public void setMdqValue(java.math.BigDecimal mdqValue) {
		this.mdqValue = mdqValue;
	}

	/**
	 * Return the value associated with the column: vat_percent
	 */
	public java.math.BigDecimal getVatPercent() {
		return vatPercent;
	}

	/**
	 * Set the value related to the column: vat_percent
	 * 
	 * @param vatPercent
	 *            the vat_percent value
	 */
	public void setVatPercent(java.math.BigDecimal vatPercent) {
		this.vatPercent = vatPercent;
	}

	/**
	 * Return the value associated with the column: rate_per_mdq
	 */
	public java.math.BigDecimal getRatePerMdq() {
		return ratePerMdq;
	}

	/**
	 * Set the value related to the column: rate_per_mdq
	 * 
	 * @param ratePerMdq
	 *            the rate_per_mdq value
	 */
	public void setRatePerMdq(java.math.BigDecimal ratePerMdq) {
		this.ratePerMdq = ratePerMdq;
	}

	/**
	 * Return the value associated with the column: comp_rate
	 */
	public java.math.BigDecimal getCompRate() {
		return compRate;
	}

	/**
	 * Set the value related to the column: comp_rate
	 * 
	 * @param compRate
	 *            the comp_rate value
	 */
	public void setCompRate(java.math.BigDecimal compRate) {
		this.compRate = compRate;
	}

	/**
	 * Return the value associated with the column: lcat
	 */
	public java.lang.String getLcat() {
		return lcat;
	}

	/**
	 * Set the value related to the column: lcat
	 * 
	 * @param lcat
	 *            the lcat value
	 */
	public void setLcat(java.lang.String lcat) {
		this.lcat = lcat;
	}

	/**
	 * Return the value associated with the column: final_price_per_mdq
	 */
	public java.math.BigDecimal getFinalPricePerMdq() {
		return finalPricePerMdq;
	}

	/**
	 * Set the value related to the column: final_price_per_mdq
	 * 
	 * @param finalPricePerMdq
	 *            the final_price_per_mdq value
	 */
	public void setFinalPricePerMdq(java.math.BigDecimal finalPricePerMdq) {
		this.finalPricePerMdq = finalPricePerMdq;
	}

	/**
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks() {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * 
	 * @param remarks
	 *            the remarks value
	 */
	public void setRemarks(java.lang.String remarks) {
		this.remarks = remarks;
	}

	/**
	 * Return the value associated with the column: qualified
	 */
	public java.lang.String getQualified() {
		return qualified;
	}

	/**
	 * Set the value related to the column: qualified
	 * 
	 * @param qualified
	 *            the qualified value
	 */
	public void setQualified(java.lang.String qualified) {
		this.qualified = qualified;
	}

	/**
	 * Return the value associated with the column: mrp
	 */
	public java.math.BigDecimal getMrp() {
		return mrp;
	}

	/**
	 * Set the value related to the column: mrp
	 * 
	 * @param mrp
	 *            the mrp value
	 */
	public void setMrp(java.math.BigDecimal mrp) {
		this.mrp = mrp;
	}

	/**
	 * Return the value associated with the column: composition
	 */
	public java.lang.String getComposition() {
		return composition;
	}

	/**
	 * Set the value related to the column: composition
	 * 
	 * @param composition
	 *            the composition value
	 */
	public void setComposition(java.lang.String composition) {
		this.composition = composition;
	}

	/**
	 * Return the value associated with the column: tax_amount_mdq
	 */
	public java.math.BigDecimal getTaxAmountMdq() {
		return taxAmountMdq;
	}

	/**
	 * Set the value related to the column: tax_amount_mdq
	 * 
	 * @param taxAmountMdq
	 *            the tax_amount_mdq value
	 */
	public void setTaxAmountMdq(java.math.BigDecimal taxAmountMdq) {
		this.taxAmountMdq = taxAmountMdq;
	}

	/**
	 * Return the value associated with the column: tot_rate_mdq
	 */
	public java.math.BigDecimal getTotRateMdq() {
		return totRateMdq;
	}

	/**
	 * Set the value related to the column: tot_rate_mdq
	 * 
	 * @param totRateMdq
	 *            the tot_rate_mdq value
	 */
	public void setTotRateMdq(java.math.BigDecimal totRateMdq) {
		this.totRateMdq = totRateMdq;
	}

	/**
	 * Return the value associated with the column: new_rate_per_mdq
	 */
	public java.math.BigDecimal getNewRatePerMdq() {
		return newRatePerMdq;
	}

	/**
	 * Set the value related to the column: new_rate_per_mdq
	 * 
	 * @param newRatePerMdq
	 *            the new_rate_per_mdq value
	 */
	public void setNewRatePerMdq(java.math.BigDecimal newRatePerMdq) {
		this.newRatePerMdq = newRatePerMdq;
	}

	/**
	 * Return the value associated with the column: new_taxamt_per_mdq
	 */
	public java.math.BigDecimal getNewTaxAmtPerMdq() {
		return newTaxAmtPerMdq;
	}

	/**
	 * Set the value related to the column: new_taxamt_per_mdq
	 * 
	 * @param newTaxAmtPerMdq
	 *            the new_taxamt_per_mdq value
	 */
	public void setNewTaxAmtPerMdq(java.math.BigDecimal newTaxAmtPerMdq) {
		this.newTaxAmtPerMdq = newTaxAmtPerMdq;
	}

	/**
	 * Return the value associated with the column: new_totrate_mdq
	 */
	public java.math.BigDecimal getNewTotRateMdq() {
		return newTotRateMdq;
	}

	/**
	 * Set the value related to the column: new_totrate_mdq
	 * 
	 * @param newTotRateMdq
	 *            the new_totrate_mdq value
	 */
	public void setNewTotRateMdq(java.math.BigDecimal newTotRateMdq) {
		this.newTotRateMdq = newTotRateMdq;
	}

	/**
	 * Return the value associated with the column: comm_bid_id
	 */
	public jkt.hms.masters.business.StoreTenderCommBidM getCommBid() {
		return commBid;
	}

	/**
	 * Set the value related to the column: comm_bid_id
	 * 
	 * @param commBid
	 *            the comm_bid_id value
	 */
	public void setCommBid(jkt.hms.masters.business.StoreTenderCommBidM commBid) {
		this.commBid = commBid;
	}

	/**
	 * Return the value associated with the column: supplier_id
	 */
	public jkt.hms.masters.business.MasStoreSupplier getSupplier() {
		return supplier;
	}

	/**
	 * Set the value related to the column: supplier_id
	 * 
	 * @param supplier
	 *            the supplier_id value
	 */
	public void setSupplier(jkt.hms.masters.business.MasStoreSupplier supplier) {
		this.supplier = supplier;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreTenderCommBidT))
			return false;
		else {
			jkt.hms.masters.business.StoreTenderCommBidT storeTenderCommBidT = (jkt.hms.masters.business.StoreTenderCommBidT) obj;
			if (null == this.getId() || null == storeTenderCommBidT.getId())
				return false;
			else
				return (this.getId().equals(storeTenderCommBidT.getId()));
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
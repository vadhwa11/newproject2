package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the store_loanin_t table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="store_loanin_t"
 */

public abstract class BaseStoreLoaninT  implements Serializable {

	public static String REF = "StoreLoaninT";
	public static String PROP_BRAND = "Brand";
	public static String PROP_ACCEPTED_MODEL = "AcceptedModel";
	public static String PROP_PRE_ID = "preId";
	public static String PROP_MANUFACTURER_DATE = "ManufacturerDate";
	public static String PROP_UNIT_RATE = "UnitRate";
	public static String PROP_INSTALLATION_DATE = "InstallationDate";
	public static String PROP_MANUFACTURER = "Manufacturer";
	public static String PROP_ITEM = "Item";
	public static String PROP_FREE_QTY = "FreeQty";
	public static String PROP_R_QTY = "RQty";
	public static String PROP_BAR_CODE_NO = "BarCodeNo";
	public static String PROP_MDQ_VALUE = "MdqValue";
	public static String PROP_WARRANTY_DATE = "WarrantyDate";
	public static String PROP_SERIAL_NO = "SerialNo";
	public static String PROP_R_BRAND = "RBrand";
	public static String PROP_LOT_NO = "LotNo";
	public static String PROP_DIS_PRCENTAGE = "DisPrcentage";
	public static String PROP_DISCOUNT = "Discount";
	public static String PROP_R_BG = "RBg";
	public static String PROP_LOANIN_MASTER = "LoaninMaster";
	public static String PROP_DISP_TYPE = "DispType";
	public static String PROP_RATE_PER_MDQ = "RatePerMdq";
	public static String PROP_AMC_START_DATE = "AmcStartDate";
	public static String PROP_TAX = "Tax";
	public static String PROP_S_BG = "SBg";
	public static String PROP_PRO_STATUS = "ProStatus";
	public static String PROP_UNIT_OF_MEASUREMENT = "UnitOfMeasurement";
	public static String PROP_RECEIVED_QTY = "ReceivedQty";
	public static String PROP_EXPIRY_DATE = "ExpiryDate";
	public static String PROP_FINAL_COST_PRICE = "FinalCostPrice";
	public static String PROP_REASON_FOR_DEMAND = "ReasonForDemand";
	public static String PROP_FREE_ITEM = "FreeItem";
	public static String PROP_ID = "Id";
	public static String PROP_R_MANUFACTURER = "RManufacturer";
	public static String PROP_BATCH_NO = "BatchNo";
	public static String PROP_AMOUNT_VALUE = "AmountValue";
	public static String PROP_AMC_END_DATE = "AmcEndDate";


	// constructors
	public BaseStoreLoaninT () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreLoaninT (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseStoreLoaninT (
		java.lang.Integer id,
		jkt.hms.masters.business.StoreLoaninM loaninMaster,
		jkt.hms.masters.business.MasStoreItem item,
		java.math.BigDecimal receivedQty,
		java.math.BigDecimal rQty) {

		this.setId(id);
		this.setLoaninMaster(loaninMaster);
		this.setItem(item);
		this.setReceivedQty(receivedQty);
		this.setRQty(rQty);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.math.BigDecimal receivedQty;
	private java.lang.Integer freeQty;
	private java.math.BigDecimal unitRate;
	private java.math.BigDecimal discount;
	private java.math.BigDecimal disPrcentage;
	private java.math.BigDecimal tax;
	private java.math.BigDecimal amountValue;
	private java.lang.String batchNo;
	private java.lang.String barCodeNo;
	private java.lang.String reasonForDemand;
	private java.lang.String freeItem;
	private java.math.BigDecimal finalCostPrice;
	private java.lang.String amcStartDate;
	private java.lang.String amcEndDate;
	private java.lang.String warrantyDate;
	private java.lang.Integer serialNo;
	private java.lang.String manufacturerDate;
	private java.lang.String lotNo;
	private java.lang.String acceptedModel;
	private java.lang.String installationDate;
	private java.util.Date expiryDate;
	private java.lang.String dispType;
	private java.math.BigDecimal mdqValue;
	private java.math.BigDecimal ratePerMdq;
	private java.lang.String proStatus;
	private java.lang.String rBg;
	private java.lang.String sBg;
	private java.math.BigDecimal rQty;
	private java.lang.Integer preId;

	// many to one
	private jkt.hms.masters.business.MasManufacturer manufacturer;
	private jkt.hms.masters.business.MasStoreBrand brand;
	private jkt.hms.masters.business.MasUnitOfMeasurement unitOfMeasurement;
	private jkt.hms.masters.business.StoreLoaninM loaninMaster;
	private jkt.hms.masters.business.MasStoreItem item;
	private jkt.hms.masters.business.MasManufacturer rManufacturer;
	private jkt.hms.masters.business.MasStoreBrand rBrand;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="loanin_trans_id"
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
	 * Return the value associated with the column: free_qty
	 */
	public java.lang.Integer getFreeQty () {
		return freeQty;
	}

	/**
	 * Set the value related to the column: free_qty
	 * @param freeQty the free_qty value
	 */
	public void setFreeQty (java.lang.Integer freeQty) {
		this.freeQty = freeQty;
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
	 * Return the value associated with the column: discount
	 */
	public java.math.BigDecimal getDiscount () {
		return discount;
	}

	/**
	 * Set the value related to the column: discount
	 * @param discount the discount value
	 */
	public void setDiscount (java.math.BigDecimal discount) {
		this.discount = discount;
	}



	/**
	 * Return the value associated with the column: DISPERCENTAGE
	 */
	public java.math.BigDecimal getDisPrcentage () {
		return disPrcentage;
	}

	/**
	 * Set the value related to the column: DISPERCENTAGE
	 * @param disPrcentage the DISPERCENTAGE value
	 */
	public void setDisPrcentage (java.math.BigDecimal disPrcentage) {
		this.disPrcentage = disPrcentage;
	}



	/**
	 * Return the value associated with the column: tax
	 */
	public java.math.BigDecimal getTax () {
		return tax;
	}

	/**
	 * Set the value related to the column: tax
	 * @param tax the tax value
	 */
	public void setTax (java.math.BigDecimal tax) {
		this.tax = tax;
	}



	/**
	 * Return the value associated with the column: amount_value
	 */
	public java.math.BigDecimal getAmountValue () {
		return amountValue;
	}

	/**
	 * Set the value related to the column: amount_value
	 * @param amountValue the amount_value value
	 */
	public void setAmountValue (java.math.BigDecimal amountValue) {
		this.amountValue = amountValue;
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
	 * Return the value associated with the column: bar_code_no
	 */
	public java.lang.String getBarCodeNo () {
		return barCodeNo;
	}

	/**
	 * Set the value related to the column: bar_code_no
	 * @param barCodeNo the bar_code_no value
	 */
	public void setBarCodeNo (java.lang.String barCodeNo) {
		this.barCodeNo = barCodeNo;
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
	 * Return the value associated with the column: final_cost_price
	 */
	public java.math.BigDecimal getFinalCostPrice () {
		return finalCostPrice;
	}

	/**
	 * Set the value related to the column: final_cost_price
	 * @param finalCostPrice the final_cost_price value
	 */
	public void setFinalCostPrice (java.math.BigDecimal finalCostPrice) {
		this.finalCostPrice = finalCostPrice;
	}



	/**
	 * Return the value associated with the column: amc_start_date
	 */
	public java.lang.String getAmcStartDate () {
		return amcStartDate;
	}

	/**
	 * Set the value related to the column: amc_start_date
	 * @param amcStartDate the amc_start_date value
	 */
	public void setAmcStartDate (java.lang.String amcStartDate) {
		this.amcStartDate = amcStartDate;
	}



	/**
	 * Return the value associated with the column: amc_end_date
	 */
	public java.lang.String getAmcEndDate () {
		return amcEndDate;
	}

	/**
	 * Set the value related to the column: amc_end_date
	 * @param amcEndDate the amc_end_date value
	 */
	public void setAmcEndDate (java.lang.String amcEndDate) {
		this.amcEndDate = amcEndDate;
	}



	/**
	 * Return the value associated with the column: warranty_date
	 */
	public java.lang.String getWarrantyDate () {
		return warrantyDate;
	}

	/**
	 * Set the value related to the column: warranty_date
	 * @param warrantyDate the warranty_date value
	 */
	public void setWarrantyDate (java.lang.String warrantyDate) {
		this.warrantyDate = warrantyDate;
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
	 * Return the value associated with the column: manufacturer_date
	 */
	public java.lang.String getManufacturerDate () {
		return manufacturerDate;
	}

	/**
	 * Set the value related to the column: manufacturer_date
	 * @param manufacturerDate the manufacturer_date value
	 */
	public void setManufacturerDate (java.lang.String manufacturerDate) {
		this.manufacturerDate = manufacturerDate;
	}



	/**
	 * Return the value associated with the column: lot_no
	 */
	public java.lang.String getLotNo () {
		return lotNo;
	}

	/**
	 * Set the value related to the column: lot_no
	 * @param lotNo the lot_no value
	 */
	public void setLotNo (java.lang.String lotNo) {
		this.lotNo = lotNo;
	}



	/**
	 * Return the value associated with the column: accepted_model
	 */
	public java.lang.String getAcceptedModel () {
		return acceptedModel;
	}

	/**
	 * Set the value related to the column: accepted_model
	 * @param acceptedModel the accepted_model value
	 */
	public void setAcceptedModel (java.lang.String acceptedModel) {
		this.acceptedModel = acceptedModel;
	}



	/**
	 * Return the value associated with the column: installation_date
	 */
	public java.lang.String getInstallationDate () {
		return installationDate;
	}

	/**
	 * Set the value related to the column: installation_date
	 * @param installationDate the installation_date value
	 */
	public void setInstallationDate (java.lang.String installationDate) {
		this.installationDate = installationDate;
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
	 * Return the value associated with the column: PRO_STATUS
	 */
	public java.lang.String getProStatus () {
		return proStatus;
	}

	/**
	 * Set the value related to the column: PRO_STATUS
	 * @param proStatus the PRO_STATUS value
	 */
	public void setProStatus (java.lang.String proStatus) {
		this.proStatus = proStatus;
	}



	/**
	 * Return the value associated with the column: R_BG
	 */
	public java.lang.String getRBg () {
		return rBg;
	}

	/**
	 * Set the value related to the column: R_BG
	 * @param rBg the R_BG value
	 */
	public void setRBg (java.lang.String rBg) {
		this.rBg = rBg;
	}



	/**
	 * Return the value associated with the column: S_BG
	 */
	public java.lang.String getSBg () {
		return sBg;
	}

	/**
	 * Set the value related to the column: S_BG
	 * @param sBg the S_BG value
	 */
	public void setSBg (java.lang.String sBg) {
		this.sBg = sBg;
	}



	/**
	 * Return the value associated with the column: r_qty
	 */
	public java.math.BigDecimal getRQty () {
		return rQty;
	}

	/**
	 * Set the value related to the column: r_qty
	 * @param rQty the r_qty value
	 */
	public void setRQty (java.math.BigDecimal rQty) {
		this.rQty = rQty;
	}



	/**
	 * Return the value associated with the column: id
	 */
	public java.lang.Integer getPreId () {
		return preId;
	}

	/**
	 * Set the value related to the column: id
	 * @param preId the id value
	 */
	public void setPreId (java.lang.Integer preId) {
		this.preId = preId;
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
	 * Return the value associated with the column: unit_of_measurement_id
	 */
	public jkt.hms.masters.business.MasUnitOfMeasurement getUnitOfMeasurement () {
		return unitOfMeasurement;
	}

	/**
	 * Set the value related to the column: unit_of_measurement_id
	 * @param unitOfMeasurement the unit_of_measurement_id value
	 */
	public void setUnitOfMeasurement (jkt.hms.masters.business.MasUnitOfMeasurement unitOfMeasurement) {
		this.unitOfMeasurement = unitOfMeasurement;
	}



	/**
	 * Return the value associated with the column: loanin_master_id
	 */
	public jkt.hms.masters.business.StoreLoaninM getLoaninMaster () {
		return loaninMaster;
	}

	/**
	 * Set the value related to the column: loanin_master_id
	 * @param loaninMaster the loanin_master_id value
	 */
	public void setLoaninMaster (jkt.hms.masters.business.StoreLoaninM loaninMaster) {
		this.loaninMaster = loaninMaster;
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
	 * Return the value associated with the column: r_manufacturer_id
	 */
	public jkt.hms.masters.business.MasManufacturer getRManufacturer () {
		return rManufacturer;
	}

	/**
	 * Set the value related to the column: r_manufacturer_id
	 * @param rManufacturer the r_manufacturer_id value
	 */
	public void setRManufacturer (jkt.hms.masters.business.MasManufacturer rManufacturer) {
		this.rManufacturer = rManufacturer;
	}



	/**
	 * Return the value associated with the column: r_brand_id
	 */
	public jkt.hms.masters.business.MasStoreBrand getRBrand () {
		return rBrand;
	}

	/**
	 * Set the value related to the column: r_brand_id
	 * @param rBrand the r_brand_id value
	 */
	public void setRBrand (jkt.hms.masters.business.MasStoreBrand rBrand) {
		this.rBrand = rBrand;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreLoaninT)) return false;
		else {
			jkt.hms.masters.business.StoreLoaninT storeLoaninT = (jkt.hms.masters.business.StoreLoaninT) obj;
			if (null == this.getId() || null == storeLoaninT.getId()) return false;
			else return (this.getId().equals(storeLoaninT.getId()));
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
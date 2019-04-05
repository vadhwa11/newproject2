package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_store_item table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_store_item"
 */

public abstract class BaseMasStoreItem  implements Serializable {

	public static String REF = "MasStoreItem";
	public static String PROP_BRAND = "Brand";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_PVMS_NO = "PvmsNo";
	public static String PROP_GROUP123 = "Group123";
	public static String PROP_SPECIFICATION = "Specification";
	public static String PROP_VED = "Ved";
	public static String PROP_SALT = "Salt";
	public static String PROP_GROUP = "Group";
	public static String PROP_SLOW_MOVING_DAYS = "SlowMovingDays";
	public static String PROP_TYPE_OF_ITEM = "TypeOfItem";
	public static String PROP_PPP_ITEM = "PppItem";
	public static String PROP_CONTROLLED_DRUG = "ControlledDrug";
	public static String PROP_PAC = "Pac";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ROL = "Rol";
	public static String PROP_ALLERGY = "Allergy";
	public static String PROP_MIN_STOCK = "MinStock";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LEAD_TIME = "LeadTime";
	public static String PROP_ITEM_GENERIC = "ItemGeneric";
	public static String PROP_SOPHISTICATED_ITEM = "SophisticatedItem";
	public static String PROP_RATE_CONTRACT_ITEM = "RateContractItem";
	public static String PROP_PRESCRIBED_FROM = "PrescribedFrom";
	public static String PROP_ID = "Id";
	public static String PROP_NOMENCLATURE = "Nomenclature";
	public static String PROP_INSULIN_INJECTION = "InsulinInjection";
	public static String PROP_OLD_NIV_NO = "OldNivNo";
	public static String PROP_ITEM_CLASS = "ItemClass";
	public static String PROP_ITEM_CONVERSION = "ItemConversion";
	public static String PROP_DANGEROUS_DRUG = "DangerousDrug";
	public static String PROP_SALES_TAX = "SalesTax";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_SELF_LIFE = "SelfLife";
	public static String PROP_DISP_UNIT = "DispUnit";
	public static String PROP_SOURCE_OF_SUPPLY = "SourceOfSupply";
	public static String PROP_MANUFACTURER = "Manufacturer";
	public static String PROP_HIGH_RISK_MEDICNE = "HighRiskMedicne";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_A_DISP_QTY = "ADispQty";
	public static String PROP_ITEM_TYPE = "ItemType";
	public static String PROP_ABC = "Abc";
	public static String PROP_COMPANY = "Company";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_BRANDED_GENERIC = "BrandedGeneric";
	public static String PROP_ISSUE_FROM = "IssueFrom";
	public static String PROP_COMMON_NAME = "CommonName";
	public static String PROP_NON_PAC = "NonPac";
	public static String PROP_MAX_STOCK = "MaxStock";
	public static String PROP_TEMPERATURE = "Temperature";
	public static String PROP_LOCATION = "Location";
	public static String PROP_ITEM_CLASSIFICATION = "ItemClassification";
	public static String PROP_EXPIRY = "Expiry";
	public static String PROP_NON_MOVING_DAYS = "NonMovingDays";
	public static String PROP_SECTION = "Section";
	public static String PROP_STATUS = "Status";
	public static String PROP_STRENGTH = "Strength";
	public static String PROP_SUPPLIER = "Supplier";
	public static String PROP_FAST_MOVING_DAYS = "FastMovingDays";
	public static String PROP_INTERMEDIATE_UNIT = "IntermediateUnit";
	public static String PROP_ITEM_CATEGORY = "ItemCategory";
	public static String PROP_COST_PRICE = "CostPrice";
	public static String PROP_HIGH_VALUE_DRUG = "HighValueDrug";


	// constructors
	public BaseMasStoreItem () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasStoreItem (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String pvmsNo;
	private java.lang.String nomenclature;
	private java.lang.String costPrice;
	private java.lang.String dangerousDrug;
	private java.lang.String pac;
	private java.lang.String controlledDrug;
	private java.lang.String highValueDrug;
	private java.lang.Float salesTax;
	private java.lang.String rateContractItem;
	private java.lang.String rol;
	private java.lang.Float maxStock;
	private java.lang.Float minStock;
	private java.lang.String selfLife;
	private java.lang.String leadTime;
	private java.lang.String location;
	private java.lang.String specification;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String oldNivNo;
	private java.lang.String nonPac;
	private java.lang.String sourceOfSupply;
	private java.lang.Integer slowMovingDays;
	private java.lang.Integer fastMovingDays;
	private java.lang.Integer nonMovingDays;
	private java.lang.String strength;
	private java.lang.String expiry;
	private java.lang.String allergy;
	private java.lang.String sophisticatedItem;
	private java.lang.String pppItem;
	private java.lang.String commonName;
	private java.lang.String highRiskMedicne;
	private java.lang.String abc;
	private java.lang.String ved;
	private java.lang.String group123;
	private java.lang.String remarks;
	private java.lang.String brandedGeneric;
	private java.lang.String temperature;
	private java.lang.String salt;
	private java.lang.String dispUnit;
	private java.math.BigDecimal aDispQty;
	private java.lang.String typeOfItem;
	private java.lang.String insulinInjection;
	private java.lang.String issueFrom;
	private java.lang.String prescribedFrom;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasItemClassification itemClassification;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasManufacturer manufacturer;
	private jkt.hms.masters.business.MasStoreBrand brand;
	private jkt.hms.masters.business.MasStoreSupplier supplier;
	private jkt.hms.masters.business.MasStoreItemGeneric itemGeneric;
	private jkt.hms.masters.business.MasStoreItemConversion itemConversion;
	private jkt.hms.masters.business.MasStoreSection section;
	private jkt.hms.masters.business.MasItemCategory itemCategory;
	private jkt.hms.masters.business.MasItemType itemType;
	private jkt.hms.masters.business.MasStoreGroup group;
	private jkt.hms.masters.business.MasCompany company;
	private jkt.hms.masters.business.MasItemClass itemClass;
	private jkt.hms.masters.business.MasStoreUnit intermediateUnit;
	private jkt.hms.masters.business.Users lastChgBy;

	// collections
	private java.util.Set<jkt.hms.masters.business.StoreTenderTechnicalBidT> storeTenderTechnicalBidTs;
	private java.util.Set<jkt.hms.masters.business.StoreWorkOrderT> storeWorkOrderTs;
	private java.util.Set<jkt.hms.masters.business.StoreIndentT> storeIndentTs;
	private java.util.Set<jkt.hms.masters.business.StoreSupplyOrderEntry> storeSupplyOrderEntries;
	private java.util.Set<jkt.hms.masters.business.StoreInternalIndentT> storeInternalIndentTs;
	private java.util.Set<jkt.hms.masters.business.StoreIpIssueT> storeIpIssueTs;
	private java.util.Set<jkt.hms.masters.business.StoreIndentSocTracker> storeIndentSocTrackers;
	private java.util.Set<jkt.hms.masters.business.StoreGrnT> storeGrnTs;
	private java.util.Set<jkt.hms.masters.business.StoreInternalReturnT> storeInternalReturnTs;
	private java.util.Set<jkt.hms.masters.business.StoreTenderCommBidM> storeTenderCommBidMs;
	private java.util.Set<jkt.hms.masters.business.StoreSoc> storeSocs;
	private java.util.Set<jkt.hms.masters.business.StoreLoaninT> storeLoaninTs;
	private java.util.Set<jkt.hms.masters.business.StoreDefectiveDrugT> storeDefectiveDrugTs;
	private java.util.Set<jkt.hms.masters.business.StoreQuotationRequestT> storeQuotationRequestTs;
	private java.util.Set<jkt.hms.masters.business.StoreGrnReturnT> storeGrnReturnTs;
	private java.util.Set<jkt.hms.masters.business.StoreItemLogTransaction> storeItemLogTransactions;
	private java.util.Set<jkt.hms.masters.business.StoreOpPatientIssueT> storeOpPatientIssueTsByItemIdRequire;
	private java.util.Set<jkt.hms.masters.business.StoreOpPatientIssueT> storeOpPatientIssueTsByItemIdIssue;
	private java.util.Set<jkt.hms.masters.business.StoreQuotationReceiptT> storeQuotationReceiptTs;
	private java.util.Set<jkt.hms.masters.business.StoreMeScaleDetails> storeMeScaleDetails;
	private java.util.Set<jkt.hms.masters.business.MasStoreItemTemplate> masStoreItemTemplates;
	private java.util.Set<jkt.hms.masters.business.StoreItemBatchStock> storeItemBatchStocks;
	private java.util.Set<jkt.hms.masters.business.StoreMmfDepartmentT> storeMmfDepartmentTs;
	private java.util.Set<jkt.hms.masters.business.StorePoDetail> storePoDetails;
	private java.util.Set<jkt.hms.masters.business.StoreIssueT> storeIssueTsByItemIssued;
	private java.util.Set<jkt.hms.masters.business.StoreIssueT> storeIssueTsByItem;
	private java.util.Set<jkt.hms.masters.business.StoreBalanceT> storeBalanceTs;
	private java.util.Set<jkt.hms.masters.business.StoreStockTakingT> storeStockTakingTs;
	private java.util.Set<jkt.hms.masters.business.MasStoreBrand> masStoreBrands;
	private java.util.Set<jkt.hms.masters.business.StoreTenderT> storeTenderTs;
	private java.util.Set<jkt.hms.masters.business.StoreCondemnationT> storeCondemnationTs;
	private java.util.Set<jkt.hms.masters.business.StoreAdjustmentT> storeAdjustmentTs;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="item_id"
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
	 * Return the value associated with the column: pvms_no
	 */
	public java.lang.String getPvmsNo () {
		return pvmsNo;
	}

	/**
	 * Set the value related to the column: pvms_no
	 * @param pvmsNo the pvms_no value
	 */
	public void setPvmsNo (java.lang.String pvmsNo) {
		this.pvmsNo = pvmsNo;
	}



	/**
	 * Return the value associated with the column: nomenclature
	 */
	public java.lang.String getNomenclature () {
		return nomenclature;
	}

	/**
	 * Set the value related to the column: nomenclature
	 * @param nomenclature the nomenclature value
	 */
	public void setNomenclature (java.lang.String nomenclature) {
		this.nomenclature = nomenclature;
	}



	/**
	 * Return the value associated with the column: cost_price
	 */
	public java.lang.String getCostPrice () {
		return costPrice;
	}

	/**
	 * Set the value related to the column: cost_price
	 * @param costPrice the cost_price value
	 */
	public void setCostPrice (java.lang.String costPrice) {
		this.costPrice = costPrice;
	}



	/**
	 * Return the value associated with the column: dangerous_drug
	 */
	public java.lang.String getDangerousDrug () {
		return dangerousDrug;
	}

	/**
	 * Set the value related to the column: dangerous_drug
	 * @param dangerousDrug the dangerous_drug value
	 */
	public void setDangerousDrug (java.lang.String dangerousDrug) {
		this.dangerousDrug = dangerousDrug;
	}



	/**
	 * Return the value associated with the column: pac
	 */
	public java.lang.String getPac () {
		return pac;
	}

	/**
	 * Set the value related to the column: pac
	 * @param pac the pac value
	 */
	public void setPac (java.lang.String pac) {
		this.pac = pac;
	}



	/**
	 * Return the value associated with the column: controlled_drug
	 */
	public java.lang.String getControlledDrug () {
		return controlledDrug;
	}

	/**
	 * Set the value related to the column: controlled_drug
	 * @param controlledDrug the controlled_drug value
	 */
	public void setControlledDrug (java.lang.String controlledDrug) {
		this.controlledDrug = controlledDrug;
	}



	/**
	 * Return the value associated with the column: high_value_drug
	 */
	public java.lang.String getHighValueDrug () {
		return highValueDrug;
	}

	/**
	 * Set the value related to the column: high_value_drug
	 * @param highValueDrug the high_value_drug value
	 */
	public void setHighValueDrug (java.lang.String highValueDrug) {
		this.highValueDrug = highValueDrug;
	}



	/**
	 * Return the value associated with the column: sales_tax
	 */
	public java.lang.Float getSalesTax () {
		return salesTax;
	}

	/**
	 * Set the value related to the column: sales_tax
	 * @param salesTax the sales_tax value
	 */
	public void setSalesTax (java.lang.Float salesTax) {
		this.salesTax = salesTax;
	}



	/**
	 * Return the value associated with the column: rate_contract_item
	 */
	public java.lang.String getRateContractItem () {
		return rateContractItem;
	}

	/**
	 * Set the value related to the column: rate_contract_item
	 * @param rateContractItem the rate_contract_item value
	 */
	public void setRateContractItem (java.lang.String rateContractItem) {
		this.rateContractItem = rateContractItem;
	}



	/**
	 * Return the value associated with the column: rol
	 */
	public java.lang.String getRol () {
		return rol;
	}

	/**
	 * Set the value related to the column: rol
	 * @param rol the rol value
	 */
	public void setRol (java.lang.String rol) {
		this.rol = rol;
	}



	/**
	 * Return the value associated with the column: max_stock
	 */
	public java.lang.Float getMaxStock () {
		return maxStock;
	}

	/**
	 * Set the value related to the column: max_stock
	 * @param maxStock the max_stock value
	 */
	public void setMaxStock (java.lang.Float maxStock) {
		this.maxStock = maxStock;
	}



	/**
	 * Return the value associated with the column: min_stock
	 */
	public java.lang.Float getMinStock () {
		return minStock;
	}

	/**
	 * Set the value related to the column: min_stock
	 * @param minStock the min_stock value
	 */
	public void setMinStock (java.lang.Float minStock) {
		this.minStock = minStock;
	}



	/**
	 * Return the value associated with the column: self_life
	 */
	public java.lang.String getSelfLife () {
		return selfLife;
	}

	/**
	 * Set the value related to the column: self_life
	 * @param selfLife the self_life value
	 */
	public void setSelfLife (java.lang.String selfLife) {
		this.selfLife = selfLife;
	}



	/**
	 * Return the value associated with the column: lead_time
	 */
	public java.lang.String getLeadTime () {
		return leadTime;
	}

	/**
	 * Set the value related to the column: lead_time
	 * @param leadTime the lead_time value
	 */
	public void setLeadTime (java.lang.String leadTime) {
		this.leadTime = leadTime;
	}



	/**
	 * Return the value associated with the column: location
	 */
	public java.lang.String getLocation () {
		return location;
	}

	/**
	 * Set the value related to the column: location
	 * @param location the location value
	 */
	public void setLocation (java.lang.String location) {
		this.location = location;
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
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * @param status the status value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
	}



	/**
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate () {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * @param lastChgDate the last_chg_date value
	 */
	public void setLastChgDate (java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}



	/**
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime () {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * @param lastChgTime the last_chg_time value
	 */
	public void setLastChgTime (java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}



	/**
	 * Return the value associated with the column: old_niv_no
	 */
	public java.lang.String getOldNivNo () {
		return oldNivNo;
	}

	/**
	 * Set the value related to the column: old_niv_no
	 * @param oldNivNo the old_niv_no value
	 */
	public void setOldNivNo (java.lang.String oldNivNo) {
		this.oldNivNo = oldNivNo;
	}



	/**
	 * Return the value associated with the column: non_pac
	 */
	public java.lang.String getNonPac () {
		return nonPac;
	}

	/**
	 * Set the value related to the column: non_pac
	 * @param nonPac the non_pac value
	 */
	public void setNonPac (java.lang.String nonPac) {
		this.nonPac = nonPac;
	}



	/**
	 * Return the value associated with the column: source_of_supply
	 */
	public java.lang.String getSourceOfSupply () {
		return sourceOfSupply;
	}

	/**
	 * Set the value related to the column: source_of_supply
	 * @param sourceOfSupply the source_of_supply value
	 */
	public void setSourceOfSupply (java.lang.String sourceOfSupply) {
		this.sourceOfSupply = sourceOfSupply;
	}



	/**
	 * Return the value associated with the column: slow_moving_days
	 */
	public java.lang.Integer getSlowMovingDays () {
		return slowMovingDays;
	}

	/**
	 * Set the value related to the column: slow_moving_days
	 * @param slowMovingDays the slow_moving_days value
	 */
	public void setSlowMovingDays (java.lang.Integer slowMovingDays) {
		this.slowMovingDays = slowMovingDays;
	}



	/**
	 * Return the value associated with the column: fast_moving_days
	 */
	public java.lang.Integer getFastMovingDays () {
		return fastMovingDays;
	}

	/**
	 * Set the value related to the column: fast_moving_days
	 * @param fastMovingDays the fast_moving_days value
	 */
	public void setFastMovingDays (java.lang.Integer fastMovingDays) {
		this.fastMovingDays = fastMovingDays;
	}



	/**
	 * Return the value associated with the column: non_moving_days
	 */
	public java.lang.Integer getNonMovingDays () {
		return nonMovingDays;
	}

	/**
	 * Set the value related to the column: non_moving_days
	 * @param nonMovingDays the non_moving_days value
	 */
	public void setNonMovingDays (java.lang.Integer nonMovingDays) {
		this.nonMovingDays = nonMovingDays;
	}



	/**
	 * Return the value associated with the column: strength
	 */
	public java.lang.String getStrength () {
		return strength;
	}

	/**
	 * Set the value related to the column: strength
	 * @param strength the strength value
	 */
	public void setStrength (java.lang.String strength) {
		this.strength = strength;
	}



	/**
	 * Return the value associated with the column: expiry
	 */
	public java.lang.String getExpiry () {
		return expiry;
	}

	/**
	 * Set the value related to the column: expiry
	 * @param expiry the expiry value
	 */
	public void setExpiry (java.lang.String expiry) {
		this.expiry = expiry;
	}



	/**
	 * Return the value associated with the column: allergy
	 */
	public java.lang.String getAllergy () {
		return allergy;
	}

	/**
	 * Set the value related to the column: allergy
	 * @param allergy the allergy value
	 */
	public void setAllergy (java.lang.String allergy) {
		this.allergy = allergy;
	}



	/**
	 * Return the value associated with the column: sophisticated_item
	 */
	public java.lang.String getSophisticatedItem () {
		return sophisticatedItem;
	}

	/**
	 * Set the value related to the column: sophisticated_item
	 * @param sophisticatedItem the sophisticated_item value
	 */
	public void setSophisticatedItem (java.lang.String sophisticatedItem) {
		this.sophisticatedItem = sophisticatedItem;
	}



	/**
	 * Return the value associated with the column: ppp_item
	 */
	public java.lang.String getPppItem () {
		return pppItem;
	}

	/**
	 * Set the value related to the column: ppp_item
	 * @param pppItem the ppp_item value
	 */
	public void setPppItem (java.lang.String pppItem) {
		this.pppItem = pppItem;
	}



	/**
	 * Return the value associated with the column: common_name
	 */
	public java.lang.String getCommonName () {
		return commonName;
	}

	/**
	 * Set the value related to the column: common_name
	 * @param commonName the common_name value
	 */
	public void setCommonName (java.lang.String commonName) {
		this.commonName = commonName;
	}



	/**
	 * Return the value associated with the column: high_risk_medicne
	 */
	public java.lang.String getHighRiskMedicne () {
		return highRiskMedicne;
	}

	/**
	 * Set the value related to the column: high_risk_medicne
	 * @param highRiskMedicne the high_risk_medicne value
	 */
	public void setHighRiskMedicne (java.lang.String highRiskMedicne) {
		this.highRiskMedicne = highRiskMedicne;
	}



	/**
	 * Return the value associated with the column: abc
	 */
	public java.lang.String getAbc () {
		return abc;
	}

	/**
	 * Set the value related to the column: abc
	 * @param abc the abc value
	 */
	public void setAbc (java.lang.String abc) {
		this.abc = abc;
	}



	/**
	 * Return the value associated with the column: ved
	 */
	public java.lang.String getVed () {
		return ved;
	}

	/**
	 * Set the value related to the column: ved
	 * @param ved the ved value
	 */
	public void setVed (java.lang.String ved) {
		this.ved = ved;
	}



	/**
	 * Return the value associated with the column: group_123
	 */
	public java.lang.String getGroup123 () {
		return group123;
	}

	/**
	 * Set the value related to the column: group_123
	 * @param group123 the group_123 value
	 */
	public void setGroup123 (java.lang.String group123) {
		this.group123 = group123;
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
	 * Return the value associated with the column: branded_generic
	 */
	public java.lang.String getBrandedGeneric () {
		return brandedGeneric;
	}

	/**
	 * Set the value related to the column: branded_generic
	 * @param brandedGeneric the branded_generic value
	 */
	public void setBrandedGeneric (java.lang.String brandedGeneric) {
		this.brandedGeneric = brandedGeneric;
	}



	/**
	 * Return the value associated with the column: TEMPERATURE
	 */
	public java.lang.String getTemperature () {
		return temperature;
	}

	/**
	 * Set the value related to the column: TEMPERATURE
	 * @param temperature the TEMPERATURE value
	 */
	public void setTemperature (java.lang.String temperature) {
		this.temperature = temperature;
	}



	/**
	 * Return the value associated with the column: SALT
	 */
	public java.lang.String getSalt () {
		return salt;
	}

	/**
	 * Set the value related to the column: SALT
	 * @param salt the SALT value
	 */
	public void setSalt (java.lang.String salt) {
		this.salt = salt;
	}



	/**
	 * Return the value associated with the column: DISP_UNIT
	 */
	public java.lang.String getDispUnit () {
		return dispUnit;
	}

	/**
	 * Set the value related to the column: DISP_UNIT
	 * @param dispUnit the DISP_UNIT value
	 */
	public void setDispUnit (java.lang.String dispUnit) {
		this.dispUnit = dispUnit;
	}



	/**
	 * Return the value associated with the column: A_DISP_QTY
	 */
	public java.math.BigDecimal getADispQty () {
		return aDispQty;
	}

	/**
	 * Set the value related to the column: A_DISP_QTY
	 * @param aDispQty the A_DISP_QTY value
	 */
	public void setADispQty (java.math.BigDecimal aDispQty) {
		this.aDispQty = aDispQty;
	}



	/**
	 * Return the value associated with the column: Item_type
	 */
	public java.lang.String getTypeOfItem () {
		return typeOfItem;
	}

	/**
	 * Set the value related to the column: Item_type
	 * @param typeOfItem the Item_type value
	 */
	public void setTypeOfItem (java.lang.String typeOfItem) {
		this.typeOfItem = typeOfItem;
	}



	/**
	 * Return the value associated with the column: insulin_injection
	 */
	public java.lang.String getInsulinInjection () {
		return insulinInjection;
	}

	/**
	 * Set the value related to the column: insulin_injection
	 * @param insulinInjection the insulin_injection value
	 */
	public void setInsulinInjection (java.lang.String insulinInjection) {
		this.insulinInjection = insulinInjection;
	}



	/**
	 * Return the value associated with the column: issue_from
	 */
	public java.lang.String getIssueFrom () {
		return issueFrom;
	}

	/**
	 * Set the value related to the column: issue_from
	 * @param issueFrom the issue_from value
	 */
	public void setIssueFrom (java.lang.String issueFrom) {
		this.issueFrom = issueFrom;
	}



	/**
	 * Return the value associated with the column: prescribed_from
	 */
	public java.lang.String getPrescribedFrom () {
		return prescribedFrom;
	}

	/**
	 * Set the value related to the column: prescribed_from
	 * @param prescribedFrom the prescribed_from value
	 */
	public void setPrescribedFrom (java.lang.String prescribedFrom) {
		this.prescribedFrom = prescribedFrom;
	}



	/**
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital () {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * @param hospital the hospital_id value
	 */
	public void setHospital (jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}



	/**
	 * Return the value associated with the column: item_classification_id
	 */
	public jkt.hms.masters.business.MasItemClassification getItemClassification () {
		return itemClassification;
	}

	/**
	 * Set the value related to the column: item_classification_id
	 * @param itemClassification the item_classification_id value
	 */
	public void setItemClassification (jkt.hms.masters.business.MasItemClassification itemClassification) {
		this.itemClassification = itemClassification;
	}



	/**
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment () {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * @param department the department_id value
	 */
	public void setDepartment (jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
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
	 * Return the value associated with the column: item_generic_id
	 */
	public jkt.hms.masters.business.MasStoreItemGeneric getItemGeneric () {
		return itemGeneric;
	}

	/**
	 * Set the value related to the column: item_generic_id
	 * @param itemGeneric the item_generic_id value
	 */
	public void setItemGeneric (jkt.hms.masters.business.MasStoreItemGeneric itemGeneric) {
		this.itemGeneric = itemGeneric;
	}



	/**
	 * Return the value associated with the column: item_conversion_id
	 */
	public jkt.hms.masters.business.MasStoreItemConversion getItemConversion () {
		return itemConversion;
	}

	/**
	 * Set the value related to the column: item_conversion_id
	 * @param itemConversion the item_conversion_id value
	 */
	public void setItemConversion (jkt.hms.masters.business.MasStoreItemConversion itemConversion) {
		this.itemConversion = itemConversion;
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
	 * Return the value associated with the column: item_category_id
	 */
	public jkt.hms.masters.business.MasItemCategory getItemCategory () {
		return itemCategory;
	}

	/**
	 * Set the value related to the column: item_category_id
	 * @param itemCategory the item_category_id value
	 */
	public void setItemCategory (jkt.hms.masters.business.MasItemCategory itemCategory) {
		this.itemCategory = itemCategory;
	}



	/**
	 * Return the value associated with the column: item_type_id
	 */
	public jkt.hms.masters.business.MasItemType getItemType () {
		return itemType;
	}

	/**
	 * Set the value related to the column: item_type_id
	 * @param itemType the item_type_id value
	 */
	public void setItemType (jkt.hms.masters.business.MasItemType itemType) {
		this.itemType = itemType;
	}



	/**
	 * Return the value associated with the column: group_id
	 */
	public jkt.hms.masters.business.MasStoreGroup getGroup () {
		return group;
	}

	/**
	 * Set the value related to the column: group_id
	 * @param group the group_id value
	 */
	public void setGroup (jkt.hms.masters.business.MasStoreGroup group) {
		this.group = group;
	}



	/**
	 * Return the value associated with the column: company_id
	 */
	public jkt.hms.masters.business.MasCompany getCompany () {
		return company;
	}

	/**
	 * Set the value related to the column: company_id
	 * @param company the company_id value
	 */
	public void setCompany (jkt.hms.masters.business.MasCompany company) {
		this.company = company;
	}



	/**
	 * Return the value associated with the column: item_class_id
	 */
	public jkt.hms.masters.business.MasItemClass getItemClass () {
		return itemClass;
	}

	/**
	 * Set the value related to the column: item_class_id
	 * @param itemClass the item_class_id value
	 */
	public void setItemClass (jkt.hms.masters.business.MasItemClass itemClass) {
		this.itemClass = itemClass;
	}



	/**
	 * Return the value associated with the column: intermediate_unit_id
	 */
	public jkt.hms.masters.business.MasStoreUnit getIntermediateUnit () {
		return intermediateUnit;
	}

	/**
	 * Set the value related to the column: intermediate_unit_id
	 * @param intermediateUnit the intermediate_unit_id value
	 */
	public void setIntermediateUnit (jkt.hms.masters.business.MasStoreUnit intermediateUnit) {
		this.intermediateUnit = intermediateUnit;
	}



	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public jkt.hms.masters.business.Users getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (jkt.hms.masters.business.Users lastChgBy) {
		this.lastChgBy = lastChgBy;
	}



	/**
	 * Return the value associated with the column: StoreTenderTechnicalBidTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreTenderTechnicalBidT> getStoreTenderTechnicalBidTs () {
		return storeTenderTechnicalBidTs;
	}

	/**
	 * Set the value related to the column: StoreTenderTechnicalBidTs
	 * @param storeTenderTechnicalBidTs the StoreTenderTechnicalBidTs value
	 */
	public void setStoreTenderTechnicalBidTs (java.util.Set<jkt.hms.masters.business.StoreTenderTechnicalBidT> storeTenderTechnicalBidTs) {
		this.storeTenderTechnicalBidTs = storeTenderTechnicalBidTs;
	}

	public void addToStoreTenderTechnicalBidTs (jkt.hms.masters.business.StoreTenderTechnicalBidT storeTenderTechnicalBidT) {
		if (null == getStoreTenderTechnicalBidTs()) setStoreTenderTechnicalBidTs(new java.util.TreeSet<jkt.hms.masters.business.StoreTenderTechnicalBidT>());
		getStoreTenderTechnicalBidTs().add(storeTenderTechnicalBidT);
	}



	/**
	 * Return the value associated with the column: StoreWorkOrderTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreWorkOrderT> getStoreWorkOrderTs () {
		return storeWorkOrderTs;
	}

	/**
	 * Set the value related to the column: StoreWorkOrderTs
	 * @param storeWorkOrderTs the StoreWorkOrderTs value
	 */
	public void setStoreWorkOrderTs (java.util.Set<jkt.hms.masters.business.StoreWorkOrderT> storeWorkOrderTs) {
		this.storeWorkOrderTs = storeWorkOrderTs;
	}

	public void addToStoreWorkOrderTs (jkt.hms.masters.business.StoreWorkOrderT storeWorkOrderT) {
		if (null == getStoreWorkOrderTs()) setStoreWorkOrderTs(new java.util.TreeSet<jkt.hms.masters.business.StoreWorkOrderT>());
		getStoreWorkOrderTs().add(storeWorkOrderT);
	}



	/**
	 * Return the value associated with the column: StoreIndentTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreIndentT> getStoreIndentTs () {
		return storeIndentTs;
	}

	/**
	 * Set the value related to the column: StoreIndentTs
	 * @param storeIndentTs the StoreIndentTs value
	 */
	public void setStoreIndentTs (java.util.Set<jkt.hms.masters.business.StoreIndentT> storeIndentTs) {
		this.storeIndentTs = storeIndentTs;
	}

	public void addToStoreIndentTs (jkt.hms.masters.business.StoreIndentT storeIndentT) {
		if (null == getStoreIndentTs()) setStoreIndentTs(new java.util.TreeSet<jkt.hms.masters.business.StoreIndentT>());
		getStoreIndentTs().add(storeIndentT);
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



	/**
	 * Return the value associated with the column: StoreInternalIndentTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreInternalIndentT> getStoreInternalIndentTs () {
		return storeInternalIndentTs;
	}

	/**
	 * Set the value related to the column: StoreInternalIndentTs
	 * @param storeInternalIndentTs the StoreInternalIndentTs value
	 */
	public void setStoreInternalIndentTs (java.util.Set<jkt.hms.masters.business.StoreInternalIndentT> storeInternalIndentTs) {
		this.storeInternalIndentTs = storeInternalIndentTs;
	}

	public void addToStoreInternalIndentTs (jkt.hms.masters.business.StoreInternalIndentT storeInternalIndentT) {
		if (null == getStoreInternalIndentTs()) setStoreInternalIndentTs(new java.util.TreeSet<jkt.hms.masters.business.StoreInternalIndentT>());
		getStoreInternalIndentTs().add(storeInternalIndentT);
	}



	/**
	 * Return the value associated with the column: StoreIpIssueTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreIpIssueT> getStoreIpIssueTs () {
		return storeIpIssueTs;
	}

	/**
	 * Set the value related to the column: StoreIpIssueTs
	 * @param storeIpIssueTs the StoreIpIssueTs value
	 */
	public void setStoreIpIssueTs (java.util.Set<jkt.hms.masters.business.StoreIpIssueT> storeIpIssueTs) {
		this.storeIpIssueTs = storeIpIssueTs;
	}

	public void addToStoreIpIssueTs (jkt.hms.masters.business.StoreIpIssueT storeIpIssueT) {
		if (null == getStoreIpIssueTs()) setStoreIpIssueTs(new java.util.TreeSet<jkt.hms.masters.business.StoreIpIssueT>());
		getStoreIpIssueTs().add(storeIpIssueT);
	}



	/**
	 * Return the value associated with the column: StoreIndentSocTrackers
	 */
	public java.util.Set<jkt.hms.masters.business.StoreIndentSocTracker> getStoreIndentSocTrackers () {
		return storeIndentSocTrackers;
	}

	/**
	 * Set the value related to the column: StoreIndentSocTrackers
	 * @param storeIndentSocTrackers the StoreIndentSocTrackers value
	 */
	public void setStoreIndentSocTrackers (java.util.Set<jkt.hms.masters.business.StoreIndentSocTracker> storeIndentSocTrackers) {
		this.storeIndentSocTrackers = storeIndentSocTrackers;
	}

	public void addToStoreIndentSocTrackers (jkt.hms.masters.business.StoreIndentSocTracker storeIndentSocTracker) {
		if (null == getStoreIndentSocTrackers()) setStoreIndentSocTrackers(new java.util.TreeSet<jkt.hms.masters.business.StoreIndentSocTracker>());
		getStoreIndentSocTrackers().add(storeIndentSocTracker);
	}



	/**
	 * Return the value associated with the column: StoreGrnTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreGrnT> getStoreGrnTs () {
		return storeGrnTs;
	}

	/**
	 * Set the value related to the column: StoreGrnTs
	 * @param storeGrnTs the StoreGrnTs value
	 */
	public void setStoreGrnTs (java.util.Set<jkt.hms.masters.business.StoreGrnT> storeGrnTs) {
		this.storeGrnTs = storeGrnTs;
	}

	public void addToStoreGrnTs (jkt.hms.masters.business.StoreGrnT storeGrnT) {
		if (null == getStoreGrnTs()) setStoreGrnTs(new java.util.TreeSet<jkt.hms.masters.business.StoreGrnT>());
		getStoreGrnTs().add(storeGrnT);
	}



	/**
	 * Return the value associated with the column: StoreInternalReturnTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreInternalReturnT> getStoreInternalReturnTs () {
		return storeInternalReturnTs;
	}

	/**
	 * Set the value related to the column: StoreInternalReturnTs
	 * @param storeInternalReturnTs the StoreInternalReturnTs value
	 */
	public void setStoreInternalReturnTs (java.util.Set<jkt.hms.masters.business.StoreInternalReturnT> storeInternalReturnTs) {
		this.storeInternalReturnTs = storeInternalReturnTs;
	}

	public void addToStoreInternalReturnTs (jkt.hms.masters.business.StoreInternalReturnT storeInternalReturnT) {
		if (null == getStoreInternalReturnTs()) setStoreInternalReturnTs(new java.util.TreeSet<jkt.hms.masters.business.StoreInternalReturnT>());
		getStoreInternalReturnTs().add(storeInternalReturnT);
	}



	/**
	 * Return the value associated with the column: StoreTenderCommBidMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreTenderCommBidM> getStoreTenderCommBidMs () {
		return storeTenderCommBidMs;
	}

	/**
	 * Set the value related to the column: StoreTenderCommBidMs
	 * @param storeTenderCommBidMs the StoreTenderCommBidMs value
	 */
	public void setStoreTenderCommBidMs (java.util.Set<jkt.hms.masters.business.StoreTenderCommBidM> storeTenderCommBidMs) {
		this.storeTenderCommBidMs = storeTenderCommBidMs;
	}

	public void addToStoreTenderCommBidMs (jkt.hms.masters.business.StoreTenderCommBidM storeTenderCommBidM) {
		if (null == getStoreTenderCommBidMs()) setStoreTenderCommBidMs(new java.util.TreeSet<jkt.hms.masters.business.StoreTenderCommBidM>());
		getStoreTenderCommBidMs().add(storeTenderCommBidM);
	}



	/**
	 * Return the value associated with the column: StoreSocs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreSoc> getStoreSocs () {
		return storeSocs;
	}

	/**
	 * Set the value related to the column: StoreSocs
	 * @param storeSocs the StoreSocs value
	 */
	public void setStoreSocs (java.util.Set<jkt.hms.masters.business.StoreSoc> storeSocs) {
		this.storeSocs = storeSocs;
	}

	public void addToStoreSocs (jkt.hms.masters.business.StoreSoc storeSoc) {
		if (null == getStoreSocs()) setStoreSocs(new java.util.TreeSet<jkt.hms.masters.business.StoreSoc>());
		getStoreSocs().add(storeSoc);
	}



	/**
	 * Return the value associated with the column: StoreLoaninTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreLoaninT> getStoreLoaninTs () {
		return storeLoaninTs;
	}

	/**
	 * Set the value related to the column: StoreLoaninTs
	 * @param storeLoaninTs the StoreLoaninTs value
	 */
	public void setStoreLoaninTs (java.util.Set<jkt.hms.masters.business.StoreLoaninT> storeLoaninTs) {
		this.storeLoaninTs = storeLoaninTs;
	}

	public void addToStoreLoaninTs (jkt.hms.masters.business.StoreLoaninT storeLoaninT) {
		if (null == getStoreLoaninTs()) setStoreLoaninTs(new java.util.TreeSet<jkt.hms.masters.business.StoreLoaninT>());
		getStoreLoaninTs().add(storeLoaninT);
	}



	/**
	 * Return the value associated with the column: StoreDefectiveDrugTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreDefectiveDrugT> getStoreDefectiveDrugTs () {
		return storeDefectiveDrugTs;
	}

	/**
	 * Set the value related to the column: StoreDefectiveDrugTs
	 * @param storeDefectiveDrugTs the StoreDefectiveDrugTs value
	 */
	public void setStoreDefectiveDrugTs (java.util.Set<jkt.hms.masters.business.StoreDefectiveDrugT> storeDefectiveDrugTs) {
		this.storeDefectiveDrugTs = storeDefectiveDrugTs;
	}

	public void addToStoreDefectiveDrugTs (jkt.hms.masters.business.StoreDefectiveDrugT storeDefectiveDrugT) {
		if (null == getStoreDefectiveDrugTs()) setStoreDefectiveDrugTs(new java.util.TreeSet<jkt.hms.masters.business.StoreDefectiveDrugT>());
		getStoreDefectiveDrugTs().add(storeDefectiveDrugT);
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



	/**
	 * Return the value associated with the column: StoreGrnReturnTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreGrnReturnT> getStoreGrnReturnTs () {
		return storeGrnReturnTs;
	}

	/**
	 * Set the value related to the column: StoreGrnReturnTs
	 * @param storeGrnReturnTs the StoreGrnReturnTs value
	 */
	public void setStoreGrnReturnTs (java.util.Set<jkt.hms.masters.business.StoreGrnReturnT> storeGrnReturnTs) {
		this.storeGrnReturnTs = storeGrnReturnTs;
	}

	public void addToStoreGrnReturnTs (jkt.hms.masters.business.StoreGrnReturnT storeGrnReturnT) {
		if (null == getStoreGrnReturnTs()) setStoreGrnReturnTs(new java.util.TreeSet<jkt.hms.masters.business.StoreGrnReturnT>());
		getStoreGrnReturnTs().add(storeGrnReturnT);
	}



	/**
	 * Return the value associated with the column: StoreItemLogTransactions
	 */
	public java.util.Set<jkt.hms.masters.business.StoreItemLogTransaction> getStoreItemLogTransactions () {
		return storeItemLogTransactions;
	}

	/**
	 * Set the value related to the column: StoreItemLogTransactions
	 * @param storeItemLogTransactions the StoreItemLogTransactions value
	 */
	public void setStoreItemLogTransactions (java.util.Set<jkt.hms.masters.business.StoreItemLogTransaction> storeItemLogTransactions) {
		this.storeItemLogTransactions = storeItemLogTransactions;
	}

	public void addToStoreItemLogTransactions (jkt.hms.masters.business.StoreItemLogTransaction storeItemLogTransaction) {
		if (null == getStoreItemLogTransactions()) setStoreItemLogTransactions(new java.util.TreeSet<jkt.hms.masters.business.StoreItemLogTransaction>());
		getStoreItemLogTransactions().add(storeItemLogTransaction);
	}



	/**
	 * Return the value associated with the column: StoreOpPatientIssueTsByItemIdRequire
	 */
	public java.util.Set<jkt.hms.masters.business.StoreOpPatientIssueT> getStoreOpPatientIssueTsByItemIdRequire () {
		return storeOpPatientIssueTsByItemIdRequire;
	}

	/**
	 * Set the value related to the column: StoreOpPatientIssueTsByItemIdRequire
	 * @param storeOpPatientIssueTsByItemIdRequire the StoreOpPatientIssueTsByItemIdRequire value
	 */
	public void setStoreOpPatientIssueTsByItemIdRequire (java.util.Set<jkt.hms.masters.business.StoreOpPatientIssueT> storeOpPatientIssueTsByItemIdRequire) {
		this.storeOpPatientIssueTsByItemIdRequire = storeOpPatientIssueTsByItemIdRequire;
	}

	public void addToStoreOpPatientIssueTsByItemIdRequire (jkt.hms.masters.business.StoreOpPatientIssueT storeOpPatientIssueT) {
		if (null == getStoreOpPatientIssueTsByItemIdRequire()) setStoreOpPatientIssueTsByItemIdRequire(new java.util.TreeSet<jkt.hms.masters.business.StoreOpPatientIssueT>());
		getStoreOpPatientIssueTsByItemIdRequire().add(storeOpPatientIssueT);
	}



	/**
	 * Return the value associated with the column: StoreOpPatientIssueTsByItemIdIssue
	 */
	public java.util.Set<jkt.hms.masters.business.StoreOpPatientIssueT> getStoreOpPatientIssueTsByItemIdIssue () {
		return storeOpPatientIssueTsByItemIdIssue;
	}

	/**
	 * Set the value related to the column: StoreOpPatientIssueTsByItemIdIssue
	 * @param storeOpPatientIssueTsByItemIdIssue the StoreOpPatientIssueTsByItemIdIssue value
	 */
	public void setStoreOpPatientIssueTsByItemIdIssue (java.util.Set<jkt.hms.masters.business.StoreOpPatientIssueT> storeOpPatientIssueTsByItemIdIssue) {
		this.storeOpPatientIssueTsByItemIdIssue = storeOpPatientIssueTsByItemIdIssue;
	}

	public void addToStoreOpPatientIssueTsByItemIdIssue (jkt.hms.masters.business.StoreOpPatientIssueT storeOpPatientIssueT) {
		if (null == getStoreOpPatientIssueTsByItemIdIssue()) setStoreOpPatientIssueTsByItemIdIssue(new java.util.TreeSet<jkt.hms.masters.business.StoreOpPatientIssueT>());
		getStoreOpPatientIssueTsByItemIdIssue().add(storeOpPatientIssueT);
	}



	/**
	 * Return the value associated with the column: StoreQuotationReceiptTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreQuotationReceiptT> getStoreQuotationReceiptTs () {
		return storeQuotationReceiptTs;
	}

	/**
	 * Set the value related to the column: StoreQuotationReceiptTs
	 * @param storeQuotationReceiptTs the StoreQuotationReceiptTs value
	 */
	public void setStoreQuotationReceiptTs (java.util.Set<jkt.hms.masters.business.StoreQuotationReceiptT> storeQuotationReceiptTs) {
		this.storeQuotationReceiptTs = storeQuotationReceiptTs;
	}

	public void addToStoreQuotationReceiptTs (jkt.hms.masters.business.StoreQuotationReceiptT storeQuotationReceiptT) {
		if (null == getStoreQuotationReceiptTs()) setStoreQuotationReceiptTs(new java.util.TreeSet<jkt.hms.masters.business.StoreQuotationReceiptT>());
		getStoreQuotationReceiptTs().add(storeQuotationReceiptT);
	}



	/**
	 * Return the value associated with the column: StoreMeScaleDetails
	 */
	public java.util.Set<jkt.hms.masters.business.StoreMeScaleDetails> getStoreMeScaleDetails () {
		return storeMeScaleDetails;
	}

	/**
	 * Set the value related to the column: StoreMeScaleDetails
	 * @param storeMeScaleDetails the StoreMeScaleDetails value
	 */
	public void setStoreMeScaleDetails (java.util.Set<jkt.hms.masters.business.StoreMeScaleDetails> storeMeScaleDetails) {
		this.storeMeScaleDetails = storeMeScaleDetails;
	}

	public void addToStoreMeScaleDetails (jkt.hms.masters.business.StoreMeScaleDetails storeMeScaleDetails) {
		if (null == getStoreMeScaleDetails()) setStoreMeScaleDetails(new java.util.TreeSet<jkt.hms.masters.business.StoreMeScaleDetails>());
		getStoreMeScaleDetails().add(storeMeScaleDetails);
	}



	/**
	 * Return the value associated with the column: MasStoreItemTemplates
	 */
	public java.util.Set<jkt.hms.masters.business.MasStoreItemTemplate> getMasStoreItemTemplates () {
		return masStoreItemTemplates;
	}

	/**
	 * Set the value related to the column: MasStoreItemTemplates
	 * @param masStoreItemTemplates the MasStoreItemTemplates value
	 */
	public void setMasStoreItemTemplates (java.util.Set<jkt.hms.masters.business.MasStoreItemTemplate> masStoreItemTemplates) {
		this.masStoreItemTemplates = masStoreItemTemplates;
	}

	public void addToMasStoreItemTemplates (jkt.hms.masters.business.MasStoreItemTemplate masStoreItemTemplate) {
		if (null == getMasStoreItemTemplates()) setMasStoreItemTemplates(new java.util.TreeSet<jkt.hms.masters.business.MasStoreItemTemplate>());
		getMasStoreItemTemplates().add(masStoreItemTemplate);
	}



	/**
	 * Return the value associated with the column: StoreItemBatchStocks
	 */
	public java.util.Set<jkt.hms.masters.business.StoreItemBatchStock> getStoreItemBatchStocks () {
		return storeItemBatchStocks;
	}

	/**
	 * Set the value related to the column: StoreItemBatchStocks
	 * @param storeItemBatchStocks the StoreItemBatchStocks value
	 */
	public void setStoreItemBatchStocks (java.util.Set<jkt.hms.masters.business.StoreItemBatchStock> storeItemBatchStocks) {
		this.storeItemBatchStocks = storeItemBatchStocks;
	}

	public void addToStoreItemBatchStocks (jkt.hms.masters.business.StoreItemBatchStock storeItemBatchStock) {
		if (null == getStoreItemBatchStocks()) setStoreItemBatchStocks(new java.util.TreeSet<jkt.hms.masters.business.StoreItemBatchStock>());
		getStoreItemBatchStocks().add(storeItemBatchStock);
	}



	/**
	 * Return the value associated with the column: StoreMmfDepartmentTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreMmfDepartmentT> getStoreMmfDepartmentTs () {
		return storeMmfDepartmentTs;
	}

	/**
	 * Set the value related to the column: StoreMmfDepartmentTs
	 * @param storeMmfDepartmentTs the StoreMmfDepartmentTs value
	 */
	public void setStoreMmfDepartmentTs (java.util.Set<jkt.hms.masters.business.StoreMmfDepartmentT> storeMmfDepartmentTs) {
		this.storeMmfDepartmentTs = storeMmfDepartmentTs;
	}

	public void addToStoreMmfDepartmentTs (jkt.hms.masters.business.StoreMmfDepartmentT storeMmfDepartmentT) {
		if (null == getStoreMmfDepartmentTs()) setStoreMmfDepartmentTs(new java.util.TreeSet<jkt.hms.masters.business.StoreMmfDepartmentT>());
		getStoreMmfDepartmentTs().add(storeMmfDepartmentT);
	}



	/**
	 * Return the value associated with the column: StorePoDetails
	 */
	public java.util.Set<jkt.hms.masters.business.StorePoDetail> getStorePoDetails () {
		return storePoDetails;
	}

	/**
	 * Set the value related to the column: StorePoDetails
	 * @param storePoDetails the StorePoDetails value
	 */
	public void setStorePoDetails (java.util.Set<jkt.hms.masters.business.StorePoDetail> storePoDetails) {
		this.storePoDetails = storePoDetails;
	}

	public void addToStorePoDetails (jkt.hms.masters.business.StorePoDetail storePoDetail) {
		if (null == getStorePoDetails()) setStorePoDetails(new java.util.TreeSet<jkt.hms.masters.business.StorePoDetail>());
		getStorePoDetails().add(storePoDetail);
	}



	/**
	 * Return the value associated with the column: StoreIssueTsByItemIssued
	 */
	public java.util.Set<jkt.hms.masters.business.StoreIssueT> getStoreIssueTsByItemIssued () {
		return storeIssueTsByItemIssued;
	}

	/**
	 * Set the value related to the column: StoreIssueTsByItemIssued
	 * @param storeIssueTsByItemIssued the StoreIssueTsByItemIssued value
	 */
	public void setStoreIssueTsByItemIssued (java.util.Set<jkt.hms.masters.business.StoreIssueT> storeIssueTsByItemIssued) {
		this.storeIssueTsByItemIssued = storeIssueTsByItemIssued;
	}

	public void addToStoreIssueTsByItemIssued (jkt.hms.masters.business.StoreIssueT storeIssueT) {
		if (null == getStoreIssueTsByItemIssued()) setStoreIssueTsByItemIssued(new java.util.TreeSet<jkt.hms.masters.business.StoreIssueT>());
		getStoreIssueTsByItemIssued().add(storeIssueT);
	}



	/**
	 * Return the value associated with the column: StoreIssueTsByItem
	 */
	public java.util.Set<jkt.hms.masters.business.StoreIssueT> getStoreIssueTsByItem () {
		return storeIssueTsByItem;
	}

	/**
	 * Set the value related to the column: StoreIssueTsByItem
	 * @param storeIssueTsByItem the StoreIssueTsByItem value
	 */
	public void setStoreIssueTsByItem (java.util.Set<jkt.hms.masters.business.StoreIssueT> storeIssueTsByItem) {
		this.storeIssueTsByItem = storeIssueTsByItem;
	}

	public void addToStoreIssueTsByItem (jkt.hms.masters.business.StoreIssueT storeIssueT) {
		if (null == getStoreIssueTsByItem()) setStoreIssueTsByItem(new java.util.TreeSet<jkt.hms.masters.business.StoreIssueT>());
		getStoreIssueTsByItem().add(storeIssueT);
	}



	/**
	 * Return the value associated with the column: StoreBalanceTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreBalanceT> getStoreBalanceTs () {
		return storeBalanceTs;
	}

	/**
	 * Set the value related to the column: StoreBalanceTs
	 * @param storeBalanceTs the StoreBalanceTs value
	 */
	public void setStoreBalanceTs (java.util.Set<jkt.hms.masters.business.StoreBalanceT> storeBalanceTs) {
		this.storeBalanceTs = storeBalanceTs;
	}

	public void addToStoreBalanceTs (jkt.hms.masters.business.StoreBalanceT storeBalanceT) {
		if (null == getStoreBalanceTs()) setStoreBalanceTs(new java.util.TreeSet<jkt.hms.masters.business.StoreBalanceT>());
		getStoreBalanceTs().add(storeBalanceT);
	}



	/**
	 * Return the value associated with the column: StoreStockTakingTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreStockTakingT> getStoreStockTakingTs () {
		return storeStockTakingTs;
	}

	/**
	 * Set the value related to the column: StoreStockTakingTs
	 * @param storeStockTakingTs the StoreStockTakingTs value
	 */
	public void setStoreStockTakingTs (java.util.Set<jkt.hms.masters.business.StoreStockTakingT> storeStockTakingTs) {
		this.storeStockTakingTs = storeStockTakingTs;
	}

	public void addToStoreStockTakingTs (jkt.hms.masters.business.StoreStockTakingT storeStockTakingT) {
		if (null == getStoreStockTakingTs()) setStoreStockTakingTs(new java.util.TreeSet<jkt.hms.masters.business.StoreStockTakingT>());
		getStoreStockTakingTs().add(storeStockTakingT);
	}



	/**
	 * Return the value associated with the column: MasStoreBrands
	 */
	public java.util.Set<jkt.hms.masters.business.MasStoreBrand> getMasStoreBrands () {
		return masStoreBrands;
	}

	/**
	 * Set the value related to the column: MasStoreBrands
	 * @param masStoreBrands the MasStoreBrands value
	 */
	public void setMasStoreBrands (java.util.Set<jkt.hms.masters.business.MasStoreBrand> masStoreBrands) {
		this.masStoreBrands = masStoreBrands;
	}

	public void addToMasStoreBrands (jkt.hms.masters.business.MasStoreBrand masStoreBrand) {
		if (null == getMasStoreBrands()) setMasStoreBrands(new java.util.TreeSet<jkt.hms.masters.business.MasStoreBrand>());
		getMasStoreBrands().add(masStoreBrand);
	}



	/**
	 * Return the value associated with the column: StoreTenderTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreTenderT> getStoreTenderTs () {
		return storeTenderTs;
	}

	/**
	 * Set the value related to the column: StoreTenderTs
	 * @param storeTenderTs the StoreTenderTs value
	 */
	public void setStoreTenderTs (java.util.Set<jkt.hms.masters.business.StoreTenderT> storeTenderTs) {
		this.storeTenderTs = storeTenderTs;
	}

	public void addToStoreTenderTs (jkt.hms.masters.business.StoreTenderT storeTenderT) {
		if (null == getStoreTenderTs()) setStoreTenderTs(new java.util.TreeSet<jkt.hms.masters.business.StoreTenderT>());
		getStoreTenderTs().add(storeTenderT);
	}



	/**
	 * Return the value associated with the column: StoreCondemnationTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreCondemnationT> getStoreCondemnationTs () {
		return storeCondemnationTs;
	}

	/**
	 * Set the value related to the column: StoreCondemnationTs
	 * @param storeCondemnationTs the StoreCondemnationTs value
	 */
	public void setStoreCondemnationTs (java.util.Set<jkt.hms.masters.business.StoreCondemnationT> storeCondemnationTs) {
		this.storeCondemnationTs = storeCondemnationTs;
	}

	public void addToStoreCondemnationTs (jkt.hms.masters.business.StoreCondemnationT storeCondemnationT) {
		if (null == getStoreCondemnationTs()) setStoreCondemnationTs(new java.util.TreeSet<jkt.hms.masters.business.StoreCondemnationT>());
		getStoreCondemnationTs().add(storeCondemnationT);
	}



	/**
	 * Return the value associated with the column: StoreAdjustmentTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreAdjustmentT> getStoreAdjustmentTs () {
		return storeAdjustmentTs;
	}

	/**
	 * Set the value related to the column: StoreAdjustmentTs
	 * @param storeAdjustmentTs the StoreAdjustmentTs value
	 */
	public void setStoreAdjustmentTs (java.util.Set<jkt.hms.masters.business.StoreAdjustmentT> storeAdjustmentTs) {
		this.storeAdjustmentTs = storeAdjustmentTs;
	}

	public void addToStoreAdjustmentTs (jkt.hms.masters.business.StoreAdjustmentT storeAdjustmentT) {
		if (null == getStoreAdjustmentTs()) setStoreAdjustmentTs(new java.util.TreeSet<jkt.hms.masters.business.StoreAdjustmentT>());
		getStoreAdjustmentTs().add(storeAdjustmentT);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasStoreItem)) return false;
		else {
			jkt.hms.masters.business.MasStoreItem masStoreItem = (jkt.hms.masters.business.MasStoreItem) obj;
			if (null == this.getId() || null == masStoreItem.getId()) return false;
			else return (this.getId().equals(masStoreItem.getId()));
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
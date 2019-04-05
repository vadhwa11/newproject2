package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_store_supplier table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_store_supplier"
 */

public abstract class BaseMasStoreSupplier  implements Serializable {

	public static String REF = "MasStoreSupplier";
	public static String PROP_PIN_CODE = "PinCode";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_PIN_NO = "PinNo";
	public static String PROP_MOBILE_NO = "MobileNo";
	public static String PROP_PHONE_NO = "PhoneNo";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_URL = "Url";
	public static String PROP_ADDRESS2 = "Address2";
	public static String PROP_FAX_NUMBER = "FaxNumber";
	public static String PROP_ADDRESS1 = "Address1";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_EMAIL_ID = "EmailId";
	public static String PROP_SUPPLIER_CODE = "SupplierCode";
	public static String PROP_CF_LOCAL_DISTRIBUTOR_ADDRESS2 = "CfLocalDistributorAddress2";
	public static String PROP_CF_LOCAL_DISTRIBUTOR_ADDRESS1 = "CfLocalDistributorAddress1";
	public static String PROP_TYPE_OF_REG = "TypeOfReg";
	public static String PROP_LICENCE_NO = "LicenceNo";
	public static String PROP_LOCAL_STATE = "LocalState";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_CF_LOCAL_DISTRIBUTOR_NAME = "CfLocalDistributorName";
	public static String PROP_LOCAL_CITY = "LocalCity";
	public static String PROP_CITY = "City";
	public static String PROP_LOCAL_PHONE_NO = "LocalPhoneNo";
	public static String PROP_SALES_TAX_NO = "SalesTaxNo";
	public static String PROP_STATUS = "Status";
	public static String PROP_SUPPLIER_TYPE = "SupplierType";
	public static String PROP_STATE = "State";
	public static String PROP_FDR_RECEIPT_ATTACHED = "FdrReceiptAttached";
	public static String PROP_TIN_NO = "TinNo";
	public static String PROP_ID = "Id";
	public static String PROP_SUPPLIER_NAME = "SupplierName";
	public static String PROP_LOCAL_PIN_CODE = "LocalPinCode";
	public static String PROP_LOCAL_ADDRESS1 = "LocalAddress1";
	public static String PROP_LOCAL_ADDRESS2 = "LocalAddress2";


	// constructors
	public BaseMasStoreSupplier () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasStoreSupplier (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String supplierCode;
	private java.lang.String supplierName;
	private java.lang.String address1;
	private java.lang.String address2;
	private java.lang.String phoneNo;
	private java.lang.String mobileNo;
	private java.lang.String emailId;
	private java.lang.String faxNumber;
	private java.lang.String url;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;
	private java.lang.String tinNo;
	private java.lang.Integer pinCode;
	private java.lang.String localAddress1;
	private java.lang.String localAddress2;
	private java.lang.String typeOfReg;
	private java.lang.String salesTaxNo;
	private java.lang.Integer localPinCode;
	private java.lang.String localPhoneNo;
	private java.lang.String licenceNo;
	private java.lang.String pinNo;
	private java.lang.String cfLocalDistributorName;
	private java.lang.String cfLocalDistributorAddress1;
	private java.lang.String cfLocalDistributorAddress2;
	private java.lang.String fdrReceiptAttached;

	// many to one
	private jkt.hms.masters.business.MasStoreSupplierType supplierType;
	private jkt.hms.masters.business.MasDistrict localCity;
	private jkt.hms.masters.business.MasState localState;
	private jkt.hms.masters.business.MasState state;
	private jkt.hms.masters.business.MasDistrict city;
	private jkt.hms.masters.business.MasHospital hospital;

	// collections
	private java.util.Set<jkt.hms.masters.business.StoreSupplyOrderEntry> storeSupplyOrderEntries;
	private java.util.Set<jkt.hms.masters.business.StoreTenderInvitaLetterToVender> storeTenderInvitaLetterToVenders;
	private java.util.Set<jkt.hms.masters.business.StorePoHeader> storePoHeaders;
	private java.util.Set<jkt.hms.masters.business.StoreGrnReturnM> storeGrnReturnMs;
	private java.util.Set<jkt.hms.masters.business.MasStoreVendorWiseManufacturer> masStoreVendorWiseManufacturers;
	private java.util.Set<jkt.hms.masters.business.StoreItemLogTransaction> storeItemLogTransactions;
	private java.util.Set<jkt.hms.masters.business.StoreGrnM> storeGrnMs;
	private java.util.Set<jkt.hms.masters.business.MasStoreItem> masStoreItems;
	private java.util.Set<jkt.hms.masters.business.StoreQuotationReceiptM> storeQuotationReceiptMs;
	private java.util.Set<jkt.hms.masters.business.StoreQuotationRequestM> storeQuotationRequestMs;
	private java.util.Set<jkt.hms.masters.business.StoreLoaninM> storeLoaninMs;
	private java.util.Set<jkt.hms.masters.business.MasStoreSupplierGroup> masStoreSupplierGroups;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="supplier_id"
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
	 * Return the value associated with the column: supplier_code
	 */
	public java.lang.String getSupplierCode () {
		return supplierCode;
	}

	/**
	 * Set the value related to the column: supplier_code
	 * @param supplierCode the supplier_code value
	 */
	public void setSupplierCode (java.lang.String supplierCode) {
		this.supplierCode = supplierCode;
	}



	/**
	 * Return the value associated with the column: supplier_name
	 */
	public java.lang.String getSupplierName () {
		return supplierName;
	}

	/**
	 * Set the value related to the column: supplier_name
	 * @param supplierName the supplier_name value
	 */
	public void setSupplierName (java.lang.String supplierName) {
		this.supplierName = supplierName;
	}



	/**
	 * Return the value associated with the column: address1
	 */
	public java.lang.String getAddress1 () {
		return address1;
	}

	/**
	 * Set the value related to the column: address1
	 * @param address1 the address1 value
	 */
	public void setAddress1 (java.lang.String address1) {
		this.address1 = address1;
	}



	/**
	 * Return the value associated with the column: address2
	 */
	public java.lang.String getAddress2 () {
		return address2;
	}

	/**
	 * Set the value related to the column: address2
	 * @param address2 the address2 value
	 */
	public void setAddress2 (java.lang.String address2) {
		this.address2 = address2;
	}



	/**
	 * Return the value associated with the column: phoneNo
	 */
	public java.lang.String getPhoneNo () {
		return phoneNo;
	}

	/**
	 * Set the value related to the column: phoneNo
	 * @param phoneNo the phoneNo value
	 */
	public void setPhoneNo (java.lang.String phoneNo) {
		this.phoneNo = phoneNo;
	}



	/**
	 * Return the value associated with the column: mobileNo
	 */
	public java.lang.String getMobileNo () {
		return mobileNo;
	}

	/**
	 * Set the value related to the column: mobileNo
	 * @param mobileNo the mobileNo value
	 */
	public void setMobileNo (java.lang.String mobileNo) {
		this.mobileNo = mobileNo;
	}



	/**
	 * Return the value associated with the column: emailId
	 */
	public java.lang.String getEmailId () {
		return emailId;
	}

	/**
	 * Set the value related to the column: emailId
	 * @param emailId the emailId value
	 */
	public void setEmailId (java.lang.String emailId) {
		this.emailId = emailId;
	}



	/**
	 * Return the value associated with the column: faxNumber
	 */
	public java.lang.String getFaxNumber () {
		return faxNumber;
	}

	/**
	 * Set the value related to the column: faxNumber
	 * @param faxNumber the faxNumber value
	 */
	public void setFaxNumber (java.lang.String faxNumber) {
		this.faxNumber = faxNumber;
	}



	/**
	 * Return the value associated with the column: url
	 */
	public java.lang.String getUrl () {
		return url;
	}

	/**
	 * Set the value related to the column: url
	 * @param url the url value
	 */
	public void setUrl (java.lang.String url) {
		this.url = url;
	}



	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.String getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
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
	 * Return the value associated with the column: tin_no
	 */
	public java.lang.String getTinNo () {
		return tinNo;
	}

	/**
	 * Set the value related to the column: tin_no
	 * @param tinNo the tin_no value
	 */
	public void setTinNo (java.lang.String tinNo) {
		this.tinNo = tinNo;
	}



	/**
	 * Return the value associated with the column: pin_code
	 */
	public java.lang.Integer getPinCode () {
		return pinCode;
	}

	/**
	 * Set the value related to the column: pin_code
	 * @param pinCode the pin_code value
	 */
	public void setPinCode (java.lang.Integer pinCode) {
		this.pinCode = pinCode;
	}



	/**
	 * Return the value associated with the column: local_address1
	 */
	public java.lang.String getLocalAddress1 () {
		return localAddress1;
	}

	/**
	 * Set the value related to the column: local_address1
	 * @param localAddress1 the local_address1 value
	 */
	public void setLocalAddress1 (java.lang.String localAddress1) {
		this.localAddress1 = localAddress1;
	}



	/**
	 * Return the value associated with the column: local_address2
	 */
	public java.lang.String getLocalAddress2 () {
		return localAddress2;
	}

	/**
	 * Set the value related to the column: local_address2
	 * @param localAddress2 the local_address2 value
	 */
	public void setLocalAddress2 (java.lang.String localAddress2) {
		this.localAddress2 = localAddress2;
	}



	/**
	 * Return the value associated with the column: type_of_reg
	 */
	public java.lang.String getTypeOfReg () {
		return typeOfReg;
	}

	/**
	 * Set the value related to the column: type_of_reg
	 * @param typeOfReg the type_of_reg value
	 */
	public void setTypeOfReg (java.lang.String typeOfReg) {
		this.typeOfReg = typeOfReg;
	}



	/**
	 * Return the value associated with the column: sales_tax_no
	 */
	public java.lang.String getSalesTaxNo () {
		return salesTaxNo;
	}

	/**
	 * Set the value related to the column: sales_tax_no
	 * @param salesTaxNo the sales_tax_no value
	 */
	public void setSalesTaxNo (java.lang.String salesTaxNo) {
		this.salesTaxNo = salesTaxNo;
	}



	/**
	 * Return the value associated with the column: local_pin_code
	 */
	public java.lang.Integer getLocalPinCode () {
		return localPinCode;
	}

	/**
	 * Set the value related to the column: local_pin_code
	 * @param localPinCode the local_pin_code value
	 */
	public void setLocalPinCode (java.lang.Integer localPinCode) {
		this.localPinCode = localPinCode;
	}



	/**
	 * Return the value associated with the column: local_phone_no
	 */
	public java.lang.String getLocalPhoneNo () {
		return localPhoneNo;
	}

	/**
	 * Set the value related to the column: local_phone_no
	 * @param localPhoneNo the local_phone_no value
	 */
	public void setLocalPhoneNo (java.lang.String localPhoneNo) {
		this.localPhoneNo = localPhoneNo;
	}



	/**
	 * Return the value associated with the column: licence_no
	 */
	public java.lang.String getLicenceNo () {
		return licenceNo;
	}

	/**
	 * Set the value related to the column: licence_no
	 * @param licenceNo the licence_no value
	 */
	public void setLicenceNo (java.lang.String licenceNo) {
		this.licenceNo = licenceNo;
	}



	/**
	 * Return the value associated with the column: pin_no
	 */
	public java.lang.String getPinNo () {
		return pinNo;
	}

	/**
	 * Set the value related to the column: pin_no
	 * @param pinNo the pin_no value
	 */
	public void setPinNo (java.lang.String pinNo) {
		this.pinNo = pinNo;
	}



	/**
	 * Return the value associated with the column: cf_local_distributor_name
	 */
	public java.lang.String getCfLocalDistributorName () {
		return cfLocalDistributorName;
	}

	/**
	 * Set the value related to the column: cf_local_distributor_name
	 * @param cfLocalDistributorName the cf_local_distributor_name value
	 */
	public void setCfLocalDistributorName (java.lang.String cfLocalDistributorName) {
		this.cfLocalDistributorName = cfLocalDistributorName;
	}



	/**
	 * Return the value associated with the column: cf_local_distributor_address1
	 */
	public java.lang.String getCfLocalDistributorAddress1 () {
		return cfLocalDistributorAddress1;
	}

	/**
	 * Set the value related to the column: cf_local_distributor_address1
	 * @param cfLocalDistributorAddress1 the cf_local_distributor_address1 value
	 */
	public void setCfLocalDistributorAddress1 (java.lang.String cfLocalDistributorAddress1) {
		this.cfLocalDistributorAddress1 = cfLocalDistributorAddress1;
	}



	/**
	 * Return the value associated with the column: cf_local_distributor_address2
	 */
	public java.lang.String getCfLocalDistributorAddress2 () {
		return cfLocalDistributorAddress2;
	}

	/**
	 * Set the value related to the column: cf_local_distributor_address2
	 * @param cfLocalDistributorAddress2 the cf_local_distributor_address2 value
	 */
	public void setCfLocalDistributorAddress2 (java.lang.String cfLocalDistributorAddress2) {
		this.cfLocalDistributorAddress2 = cfLocalDistributorAddress2;
	}



	/**
	 * Return the value associated with the column: fdr_receipt_attached
	 */
	public java.lang.String getFdrReceiptAttached () {
		return fdrReceiptAttached;
	}

	/**
	 * Set the value related to the column: fdr_receipt_attached
	 * @param fdrReceiptAttached the fdr_receipt_attached value
	 */
	public void setFdrReceiptAttached (java.lang.String fdrReceiptAttached) {
		this.fdrReceiptAttached = fdrReceiptAttached;
	}



	/**
	 * Return the value associated with the column: supplier_type_id
	 */
	public jkt.hms.masters.business.MasStoreSupplierType getSupplierType () {
		return supplierType;
	}

	/**
	 * Set the value related to the column: supplier_type_id
	 * @param supplierType the supplier_type_id value
	 */
	public void setSupplierType (jkt.hms.masters.business.MasStoreSupplierType supplierType) {
		this.supplierType = supplierType;
	}



	/**
	 * Return the value associated with the column: local_city
	 */
	public jkt.hms.masters.business.MasDistrict getLocalCity () {
		return localCity;
	}

	/**
	 * Set the value related to the column: local_city
	 * @param localCity the local_city value
	 */
	public void setLocalCity (jkt.hms.masters.business.MasDistrict localCity) {
		this.localCity = localCity;
	}



	/**
	 * Return the value associated with the column: local_state
	 */
	public jkt.hms.masters.business.MasState getLocalState () {
		return localState;
	}

	/**
	 * Set the value related to the column: local_state
	 * @param localState the local_state value
	 */
	public void setLocalState (jkt.hms.masters.business.MasState localState) {
		this.localState = localState;
	}



	/**
	 * Return the value associated with the column: state
	 */
	public jkt.hms.masters.business.MasState getState () {
		return state;
	}

	/**
	 * Set the value related to the column: state
	 * @param state the state value
	 */
	public void setState (jkt.hms.masters.business.MasState state) {
		this.state = state;
	}



	/**
	 * Return the value associated with the column: city
	 */
	public jkt.hms.masters.business.MasDistrict getCity () {
		return city;
	}

	/**
	 * Set the value related to the column: city
	 * @param city the city value
	 */
	public void setCity (jkt.hms.masters.business.MasDistrict city) {
		this.city = city;
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
	 * Return the value associated with the column: StoreTenderInvitaLetterToVenders
	 */
	public java.util.Set<jkt.hms.masters.business.StoreTenderInvitaLetterToVender> getStoreTenderInvitaLetterToVenders () {
		return storeTenderInvitaLetterToVenders;
	}

	/**
	 * Set the value related to the column: StoreTenderInvitaLetterToVenders
	 * @param storeTenderInvitaLetterToVenders the StoreTenderInvitaLetterToVenders value
	 */
	public void setStoreTenderInvitaLetterToVenders (java.util.Set<jkt.hms.masters.business.StoreTenderInvitaLetterToVender> storeTenderInvitaLetterToVenders) {
		this.storeTenderInvitaLetterToVenders = storeTenderInvitaLetterToVenders;
	}

	public void addToStoreTenderInvitaLetterToVenders (jkt.hms.masters.business.StoreTenderInvitaLetterToVender storeTenderInvitaLetterToVender) {
		if (null == getStoreTenderInvitaLetterToVenders()) setStoreTenderInvitaLetterToVenders(new java.util.TreeSet<jkt.hms.masters.business.StoreTenderInvitaLetterToVender>());
		getStoreTenderInvitaLetterToVenders().add(storeTenderInvitaLetterToVender);
	}



	/**
	 * Return the value associated with the column: StorePoHeaders
	 */
	public java.util.Set<jkt.hms.masters.business.StorePoHeader> getStorePoHeaders () {
		return storePoHeaders;
	}

	/**
	 * Set the value related to the column: StorePoHeaders
	 * @param storePoHeaders the StorePoHeaders value
	 */
	public void setStorePoHeaders (java.util.Set<jkt.hms.masters.business.StorePoHeader> storePoHeaders) {
		this.storePoHeaders = storePoHeaders;
	}

	public void addToStorePoHeaders (jkt.hms.masters.business.StorePoHeader storePoHeader) {
		if (null == getStorePoHeaders()) setStorePoHeaders(new java.util.TreeSet<jkt.hms.masters.business.StorePoHeader>());
		getStorePoHeaders().add(storePoHeader);
	}



	/**
	 * Return the value associated with the column: StoreGrnReturnMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreGrnReturnM> getStoreGrnReturnMs () {
		return storeGrnReturnMs;
	}

	/**
	 * Set the value related to the column: StoreGrnReturnMs
	 * @param storeGrnReturnMs the StoreGrnReturnMs value
	 */
	public void setStoreGrnReturnMs (java.util.Set<jkt.hms.masters.business.StoreGrnReturnM> storeGrnReturnMs) {
		this.storeGrnReturnMs = storeGrnReturnMs;
	}

	public void addToStoreGrnReturnMs (jkt.hms.masters.business.StoreGrnReturnM storeGrnReturnM) {
		if (null == getStoreGrnReturnMs()) setStoreGrnReturnMs(new java.util.TreeSet<jkt.hms.masters.business.StoreGrnReturnM>());
		getStoreGrnReturnMs().add(storeGrnReturnM);
	}



	/**
	 * Return the value associated with the column: MasStoreVendorWiseManufacturers
	 */
	public java.util.Set<jkt.hms.masters.business.MasStoreVendorWiseManufacturer> getMasStoreVendorWiseManufacturers () {
		return masStoreVendorWiseManufacturers;
	}

	/**
	 * Set the value related to the column: MasStoreVendorWiseManufacturers
	 * @param masStoreVendorWiseManufacturers the MasStoreVendorWiseManufacturers value
	 */
	public void setMasStoreVendorWiseManufacturers (java.util.Set<jkt.hms.masters.business.MasStoreVendorWiseManufacturer> masStoreVendorWiseManufacturers) {
		this.masStoreVendorWiseManufacturers = masStoreVendorWiseManufacturers;
	}

	public void addToMasStoreVendorWiseManufacturers (jkt.hms.masters.business.MasStoreVendorWiseManufacturer masStoreVendorWiseManufacturer) {
		if (null == getMasStoreVendorWiseManufacturers()) setMasStoreVendorWiseManufacturers(new java.util.TreeSet<jkt.hms.masters.business.MasStoreVendorWiseManufacturer>());
		getMasStoreVendorWiseManufacturers().add(masStoreVendorWiseManufacturer);
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
	 * Return the value associated with the column: StoreGrnMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreGrnM> getStoreGrnMs () {
		return storeGrnMs;
	}

	/**
	 * Set the value related to the column: StoreGrnMs
	 * @param storeGrnMs the StoreGrnMs value
	 */
	public void setStoreGrnMs (java.util.Set<jkt.hms.masters.business.StoreGrnM> storeGrnMs) {
		this.storeGrnMs = storeGrnMs;
	}

	public void addToStoreGrnMs (jkt.hms.masters.business.StoreGrnM storeGrnM) {
		if (null == getStoreGrnMs()) setStoreGrnMs(new java.util.TreeSet<jkt.hms.masters.business.StoreGrnM>());
		getStoreGrnMs().add(storeGrnM);
	}



	/**
	 * Return the value associated with the column: MasStoreItems
	 */
	public java.util.Set<jkt.hms.masters.business.MasStoreItem> getMasStoreItems () {
		return masStoreItems;
	}

	/**
	 * Set the value related to the column: MasStoreItems
	 * @param masStoreItems the MasStoreItems value
	 */
	public void setMasStoreItems (java.util.Set<jkt.hms.masters.business.MasStoreItem> masStoreItems) {
		this.masStoreItems = masStoreItems;
	}

	public void addToMasStoreItems (jkt.hms.masters.business.MasStoreItem masStoreItem) {
		if (null == getMasStoreItems()) setMasStoreItems(new java.util.TreeSet<jkt.hms.masters.business.MasStoreItem>());
		getMasStoreItems().add(masStoreItem);
	}



	/**
	 * Return the value associated with the column: StoreQuotationReceiptMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreQuotationReceiptM> getStoreQuotationReceiptMs () {
		return storeQuotationReceiptMs;
	}

	/**
	 * Set the value related to the column: StoreQuotationReceiptMs
	 * @param storeQuotationReceiptMs the StoreQuotationReceiptMs value
	 */
	public void setStoreQuotationReceiptMs (java.util.Set<jkt.hms.masters.business.StoreQuotationReceiptM> storeQuotationReceiptMs) {
		this.storeQuotationReceiptMs = storeQuotationReceiptMs;
	}

	public void addToStoreQuotationReceiptMs (jkt.hms.masters.business.StoreQuotationReceiptM storeQuotationReceiptM) {
		if (null == getStoreQuotationReceiptMs()) setStoreQuotationReceiptMs(new java.util.TreeSet<jkt.hms.masters.business.StoreQuotationReceiptM>());
		getStoreQuotationReceiptMs().add(storeQuotationReceiptM);
	}



	/**
	 * Return the value associated with the column: StoreQuotationRequestMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreQuotationRequestM> getStoreQuotationRequestMs () {
		return storeQuotationRequestMs;
	}

	/**
	 * Set the value related to the column: StoreQuotationRequestMs
	 * @param storeQuotationRequestMs the StoreQuotationRequestMs value
	 */
	public void setStoreQuotationRequestMs (java.util.Set<jkt.hms.masters.business.StoreQuotationRequestM> storeQuotationRequestMs) {
		this.storeQuotationRequestMs = storeQuotationRequestMs;
	}

	public void addToStoreQuotationRequestMs (jkt.hms.masters.business.StoreQuotationRequestM storeQuotationRequestM) {
		if (null == getStoreQuotationRequestMs()) setStoreQuotationRequestMs(new java.util.TreeSet<jkt.hms.masters.business.StoreQuotationRequestM>());
		getStoreQuotationRequestMs().add(storeQuotationRequestM);
	}



	/**
	 * Return the value associated with the column: StoreLoaninMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreLoaninM> getStoreLoaninMs () {
		return storeLoaninMs;
	}

	/**
	 * Set the value related to the column: StoreLoaninMs
	 * @param storeLoaninMs the StoreLoaninMs value
	 */
	public void setStoreLoaninMs (java.util.Set<jkt.hms.masters.business.StoreLoaninM> storeLoaninMs) {
		this.storeLoaninMs = storeLoaninMs;
	}

	public void addToStoreLoaninMs (jkt.hms.masters.business.StoreLoaninM storeLoaninM) {
		if (null == getStoreLoaninMs()) setStoreLoaninMs(new java.util.TreeSet<jkt.hms.masters.business.StoreLoaninM>());
		getStoreLoaninMs().add(storeLoaninM);
	}



	/**
	 * Return the value associated with the column: MasStoreSupplierGroups
	 */
	public java.util.Set<jkt.hms.masters.business.MasStoreSupplierGroup> getMasStoreSupplierGroups () {
		return masStoreSupplierGroups;
	}

	/**
	 * Set the value related to the column: MasStoreSupplierGroups
	 * @param masStoreSupplierGroups the MasStoreSupplierGroups value
	 */
	public void setMasStoreSupplierGroups (java.util.Set<jkt.hms.masters.business.MasStoreSupplierGroup> masStoreSupplierGroups) {
		this.masStoreSupplierGroups = masStoreSupplierGroups;
	}

	public void addToMasStoreSupplierGroups (jkt.hms.masters.business.MasStoreSupplierGroup masStoreSupplierGroup) {
		if (null == getMasStoreSupplierGroups()) setMasStoreSupplierGroups(new java.util.TreeSet<jkt.hms.masters.business.MasStoreSupplierGroup>());
		getMasStoreSupplierGroups().add(masStoreSupplierGroup);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasStoreSupplier)) return false;
		else {
			jkt.hms.masters.business.MasStoreSupplier masStoreSupplier = (jkt.hms.masters.business.MasStoreSupplier) obj;
			if (null == this.getId() || null == masStoreSupplier.getId()) return false;
			else return (this.getId().equals(masStoreSupplier.getId()));
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
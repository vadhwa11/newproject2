package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_manufacturer table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_manufacturer"
 */

public abstract class BaseMasManufacturer  implements Serializable {

	public static String REF = "MasManufacturer";
	public static String PROP_PIN_CODE = "PinCode";
	public static String PROP_LICENCE_NO = "LicenceNo";
	public static String PROP_CONTACT_PERSON = "ContactPerson";
	public static String PROP_PHONENO = "Phoneno";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_CF_LOCAL_DISTRIBUTOR_NAME = "CfLocalDistributorName";
	public static String PROP_CITY = "City";
	public static String PROP_MANUFACTURER_CODE = "ManufacturerCode";
	public static String PROP_SALES_TAX_NO = "SalesTaxNo";
	public static String PROP_STATUS = "Status";
	public static String PROP_MANUFACTURER_NAME = "ManufacturerName";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_STATE = "State";
	public static String PROP_URL = "Url";
	public static String PROP_ADDRESS2 = "Address2";
	public static String PROP_ADDRESS1 = "Address1";
	public static String PROP_MOBILENO = "Mobileno";
	public static String PROP_FAX_NUMBER = "FaxNumber";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_EMAIL_ID = "EmailId";
	public static String PROP_CF_LOCAL_DISTRIBUTOR_ADDRESS2 = "CfLocalDistributorAddress2";
	public static String PROP_CF_LOCAL_DISTRIBUTOR_ADDRESS1 = "CfLocalDistributorAddress1";


	// constructors
	public BaseMasManufacturer () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasManufacturer (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String manufacturerCode;
	private java.lang.String manufacturerName;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String address1;
	private java.lang.String address2;
	private java.lang.String phoneno;
	private java.lang.String mobileno;
	private java.lang.String emailId;
	private java.lang.String faxNumber;
	private java.lang.String url;
	private java.lang.String contactPerson;
	private java.lang.Integer pinCode;
	private java.lang.String licenceNo;
	private java.lang.String salesTaxNo;
	private java.lang.String cfLocalDistributorName;
	private java.lang.String cfLocalDistributorAddress1;
	private java.lang.String cfLocalDistributorAddress2;

	// many to one
	private jkt.hms.masters.business.MasState state;
	private jkt.hms.masters.business.MasDistrict city;
	private jkt.hms.masters.business.MasHospital hospital;

	// collections
	private java.util.Set<jkt.hms.masters.business.StoreIndentT> storeIndentTs;
	private java.util.Set<jkt.hms.masters.business.StoreGrnT> storeGrnTs;
	private java.util.Set<jkt.hms.masters.business.MasStoreVendorWiseManufacturer> masStoreVendorWiseManufacturers;
	private java.util.Set<jkt.hms.masters.business.StoreLoaninT> storeLoaninTs;
	private java.util.Set<jkt.hms.masters.business.StoreDefectiveDrugT> storeDefectiveDrugTs;
	private java.util.Set<jkt.hms.masters.business.StoreQuotationRequestT> storeQuotationRequestTs;
	private java.util.Set<jkt.hms.masters.business.StoreQuotationReceiptT> storeQuotationReceiptTs;
	private java.util.Set<jkt.hms.masters.business.StorePoDetail> storePoDetails;
	private java.util.Set<jkt.hms.masters.business.MasStoreItem> masStoreItems;
	private java.util.Set<jkt.hms.masters.business.MasStoreBrand> masStoreBrands;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="manufacturer_id"
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
	 * Return the value associated with the column: manufacturer_code
	 */
	public java.lang.String getManufacturerCode () {
		return manufacturerCode;
	}

	/**
	 * Set the value related to the column: manufacturer_code
	 * @param manufacturerCode the manufacturer_code value
	 */
	public void setManufacturerCode (java.lang.String manufacturerCode) {
		this.manufacturerCode = manufacturerCode;
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
	 * Return the value associated with the column: phoneno
	 */
	public java.lang.String getPhoneno () {
		return phoneno;
	}

	/**
	 * Set the value related to the column: phoneno
	 * @param phoneno the phoneno value
	 */
	public void setPhoneno (java.lang.String phoneno) {
		this.phoneno = phoneno;
	}



	/**
	 * Return the value associated with the column: mobileno
	 */
	public java.lang.String getMobileno () {
		return mobileno;
	}

	/**
	 * Set the value related to the column: mobileno
	 * @param mobileno the mobileno value
	 */
	public void setMobileno (java.lang.String mobileno) {
		this.mobileno = mobileno;
	}



	/**
	 * Return the value associated with the column: email_id
	 */
	public java.lang.String getEmailId () {
		return emailId;
	}

	/**
	 * Set the value related to the column: email_id
	 * @param emailId the email_id value
	 */
	public void setEmailId (java.lang.String emailId) {
		this.emailId = emailId;
	}



	/**
	 * Return the value associated with the column: fax_number
	 */
	public java.lang.String getFaxNumber () {
		return faxNumber;
	}

	/**
	 * Set the value related to the column: fax_number
	 * @param faxNumber the fax_number value
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
	 * Return the value associated with the column: contact_person
	 */
	public java.lang.String getContactPerson () {
		return contactPerson;
	}

	/**
	 * Set the value related to the column: contact_person
	 * @param contactPerson the contact_person value
	 */
	public void setContactPerson (java.lang.String contactPerson) {
		this.contactPerson = contactPerson;
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
	 * Return the value associated with the column: state_id
	 */
	public jkt.hms.masters.business.MasState getState () {
		return state;
	}

	/**
	 * Set the value related to the column: state_id
	 * @param state the state_id value
	 */
	public void setState (jkt.hms.masters.business.MasState state) {
		this.state = state;
	}



	/**
	 * Return the value associated with the column: city_id
	 */
	public jkt.hms.masters.business.MasDistrict getCity () {
		return city;
	}

	/**
	 * Set the value related to the column: city_id
	 * @param city the city_id value
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasManufacturer)) return false;
		else {
			jkt.hms.masters.business.MasManufacturer masManufacturer = (jkt.hms.masters.business.MasManufacturer) obj;
			if (null == this.getId() || null == masManufacturer.getId()) return false;
			else return (this.getId().equals(masManufacturer.getId()));
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
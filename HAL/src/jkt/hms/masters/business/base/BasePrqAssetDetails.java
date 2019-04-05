package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the prq_asset_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="prq_asset_details"
 */

public abstract class BasePrqAssetDetails  implements Serializable {

	public static String REF = "PrqAssetDetails";
	public static String PROP_AUCTION_STATUS = "AuctionStatus";
	public static String PROP_LAND_MEASUREMENT_H = "LandMeasurementH";
	public static String PROP_BOOK_VALUE = "BookValue";
	public static String PROP_ASSET_TYPE = "AssetType";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_PARTY_NAME = "PartyName";
	public static String PROP_PARTY_CONTACT_NO = "PartyContactNo";
	public static String PROP_ASSET_CODE = "AssetCode";
	public static String PROP_PLOT_SURVEY_NO = "PlotSurveyNo";
	public static String PROP_MODAL_NO = "ModalNo";
	public static String PROP_ITEM = "Item";
	public static String PROP_PARTY_ADDRESS = "PartyAddress";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_AUCTION_AMOUNT = "AuctionAmount";
	public static String PROP_LEASE_PERIOD = "LeasePeriod";
	public static String PROP_REGISTRATION_OTHER_CHARGES = "RegistrationOtherCharges";
	public static String PROP_EST_COST = "EstCost";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_CONTACT_NO = "ContactNo";
	public static String PROP_ROAD_TAX = "RoadTax";
	public static String PROP_ASSET_DESC = "AssetDesc";
	public static String PROP_EMAIL = "Email";
	public static String PROP_DISTRICT = "District";
	public static String PROP_REGISTRATION_DATE = "RegistrationDate";
	public static String PROP_ID = "Id";
	public static String PROP_AGREEMENT_DATE = "AgreementDate";
	public static String PROP_PURCHASE_VALUE = "PurchaseValue";
	public static String PROP_AUCTION_DATE = "AuctionDate";
	public static String PROP_LEASE_COMPLETION_DATE = "LeaseCompletionDate";
	public static String PROP_SERVICE_OUTLET = "ServiceOutlet";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_TOTAL_COST = "TotalCost";
	public static String PROP_VEHICLE_TYPE = "VehicleType";
	public static String PROP_EFFECTIVE_FROM_DATE = "EffectiveFromDate";
	public static String PROP_REGISTRATION_NO = "RegistrationNo";
	public static String PROP_POSSESSION_DATE = "PossessionDate";
	public static String PROP_ASSET_NAME = "AssetName";
	public static String PROP_MANUFACTURER = "Manufacturer";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_WARRENTY_PERIOD = "WarrentyPeriod";
	public static String PROP_VALID_UPTO = "ValidUpto";
	public static String PROP_VEHICLE_NAME = "VehicleName";
	public static String PROP_DEPRECATION = "Deprecation";
	public static String PROP_REQUESTED_BY = "RequestedBy";
	public static String PROP_TAX = "Tax";
	public static String PROP_AUCTION_REMARKS = "AuctionRemarks";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAND_MEASUREMENT_W = "LandMeasurementW";
	public static String PROP_SOURCE_OF_VEHICLE = "SourceOfVehicle";
	public static String PROP_AUTHORISER_NAME = "AuthoriserName";
	public static String PROP_LEASEHOLD_FREEHOLD = "LeaseholdFreehold";
	public static String PROP_ADDRESS = "Address";
	public static String PROP_ACQUIRE_FROM = "AcquireFrom";


	// constructors
	public BasePrqAssetDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePrqAssetDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String assetType;
	private java.lang.String assetName;
	private java.lang.String assetDesc;
	private java.lang.String acquireFrom;
	private java.lang.String plotSurveyNo;
	private java.lang.String leaseholdFreehold;
	private java.math.BigDecimal landMeasurementW;
	private java.math.BigDecimal landMeasurementH;
	private java.util.Date possessionDate;
	private java.math.BigDecimal estCost;
	private java.math.BigDecimal bookValue;
	private java.math.BigDecimal registrationOtherCharges;
	private java.util.Date registrationDate;
	private java.math.BigDecimal totalCost;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String remarks;
	private java.lang.String registrationNo;
	private java.lang.String modalNo;
	private java.lang.String vehicleName;
	private java.lang.String vehicleType;
	private java.util.Date agreementDate;
	private java.lang.String serviceOutlet;
	private java.lang.String address;
	private java.lang.Long contactNo;
	private java.lang.String email;
	private java.lang.String warrentyPeriod;
	private java.util.Date effectiveFromDate;
	private java.math.BigDecimal purchaseValue;
	private java.math.BigDecimal tax;
	private java.math.BigDecimal roadTax;
	private java.util.Date validUpto;
	private java.lang.String auctionStatus;
	private java.lang.String partyName;
	private java.lang.String partyAddress;
	private java.lang.Long partyContactNo;
	private java.lang.String assetCode;
	private java.util.Date auctionDate;
	private java.lang.String auctionRemarks;
	private java.lang.String leasePeriod;
	private java.util.Date leaseCompletionDate;
	private java.lang.Integer deprecation;
	private java.math.BigDecimal auctionAmount;
	private java.lang.String sourceOfVehicle;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasStoreItem item;
	private jkt.hms.masters.business.MasManufacturer manufacturer;
	private jkt.hms.masters.business.MasEmployee authoriserName;
	private jkt.hms.masters.business.MasDistrict district;
	private jkt.hms.masters.business.MasEmployee requestedBy;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="org.hibernate.id.IncrementGenerator"
     *  column="asset_id"
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
	 * Return the value associated with the column: asset_type
	 */
	public java.lang.String getAssetType () {
		return assetType;
	}

	/**
	 * Set the value related to the column: asset_type
	 * @param assetType the asset_type value
	 */
	public void setAssetType (java.lang.String assetType) {
		this.assetType = assetType;
	}



	/**
	 * Return the value associated with the column: asset_name
	 */
	public java.lang.String getAssetName () {
		return assetName;
	}

	/**
	 * Set the value related to the column: asset_name
	 * @param assetName the asset_name value
	 */
	public void setAssetName (java.lang.String assetName) {
		this.assetName = assetName;
	}



	/**
	 * Return the value associated with the column: asset_desc
	 */
	public java.lang.String getAssetDesc () {
		return assetDesc;
	}

	/**
	 * Set the value related to the column: asset_desc
	 * @param assetDesc the asset_desc value
	 */
	public void setAssetDesc (java.lang.String assetDesc) {
		this.assetDesc = assetDesc;
	}



	/**
	 * Return the value associated with the column: acquire_from
	 */
	public java.lang.String getAcquireFrom () {
		return acquireFrom;
	}

	/**
	 * Set the value related to the column: acquire_from
	 * @param acquireFrom the acquire_from value
	 */
	public void setAcquireFrom (java.lang.String acquireFrom) {
		this.acquireFrom = acquireFrom;
	}



	/**
	 * Return the value associated with the column: plot_survey_no
	 */
	public java.lang.String getPlotSurveyNo () {
		return plotSurveyNo;
	}

	/**
	 * Set the value related to the column: plot_survey_no
	 * @param plotSurveyNo the plot_survey_no value
	 */
	public void setPlotSurveyNo (java.lang.String plotSurveyNo) {
		this.plotSurveyNo = plotSurveyNo;
	}



	/**
	 * Return the value associated with the column: leasehold_freehold
	 */
	public java.lang.String getLeaseholdFreehold () {
		return leaseholdFreehold;
	}

	/**
	 * Set the value related to the column: leasehold_freehold
	 * @param leaseholdFreehold the leasehold_freehold value
	 */
	public void setLeaseholdFreehold (java.lang.String leaseholdFreehold) {
		this.leaseholdFreehold = leaseholdFreehold;
	}



	/**
	 * Return the value associated with the column: land_measurement_w
	 */
	public java.math.BigDecimal getLandMeasurementW () {
		return landMeasurementW;
	}

	/**
	 * Set the value related to the column: land_measurement_w
	 * @param landMeasurementW the land_measurement_w value
	 */
	public void setLandMeasurementW (java.math.BigDecimal landMeasurementW) {
		this.landMeasurementW = landMeasurementW;
	}



	/**
	 * Return the value associated with the column: land_measurement_h
	 */
	public java.math.BigDecimal getLandMeasurementH () {
		return landMeasurementH;
	}

	/**
	 * Set the value related to the column: land_measurement_h
	 * @param landMeasurementH the land_measurement_h value
	 */
	public void setLandMeasurementH (java.math.BigDecimal landMeasurementH) {
		this.landMeasurementH = landMeasurementH;
	}



	/**
	 * Return the value associated with the column: possession_date
	 */
	public java.util.Date getPossessionDate () {
		return possessionDate;
	}

	/**
	 * Set the value related to the column: possession_date
	 * @param possessionDate the possession_date value
	 */
	public void setPossessionDate (java.util.Date possessionDate) {
		this.possessionDate = possessionDate;
	}



	/**
	 * Return the value associated with the column: est_cost
	 */
	public java.math.BigDecimal getEstCost () {
		return estCost;
	}

	/**
	 * Set the value related to the column: est_cost
	 * @param estCost the est_cost value
	 */
	public void setEstCost (java.math.BigDecimal estCost) {
		this.estCost = estCost;
	}



	/**
	 * Return the value associated with the column: book_value
	 */
	public java.math.BigDecimal getBookValue () {
		return bookValue;
	}

	/**
	 * Set the value related to the column: book_value
	 * @param bookValue the book_value value
	 */
	public void setBookValue (java.math.BigDecimal bookValue) {
		this.bookValue = bookValue;
	}



	/**
	 * Return the value associated with the column: registration_other_charges
	 */
	public java.math.BigDecimal getRegistrationOtherCharges () {
		return registrationOtherCharges;
	}

	/**
	 * Set the value related to the column: registration_other_charges
	 * @param registrationOtherCharges the registration_other_charges value
	 */
	public void setRegistrationOtherCharges (java.math.BigDecimal registrationOtherCharges) {
		this.registrationOtherCharges = registrationOtherCharges;
	}



	/**
	 * Return the value associated with the column: registration_date
	 */
	public java.util.Date getRegistrationDate () {
		return registrationDate;
	}

	/**
	 * Set the value related to the column: registration_date
	 * @param registrationDate the registration_date value
	 */
	public void setRegistrationDate (java.util.Date registrationDate) {
		this.registrationDate = registrationDate;
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
	 * Return the value associated with the column: registration_no
	 */
	public java.lang.String getRegistrationNo () {
		return registrationNo;
	}

	/**
	 * Set the value related to the column: registration_no
	 * @param registrationNo the registration_no value
	 */
	public void setRegistrationNo (java.lang.String registrationNo) {
		this.registrationNo = registrationNo;
	}



	/**
	 * Return the value associated with the column: modal_no
	 */
	public java.lang.String getModalNo () {
		return modalNo;
	}

	/**
	 * Set the value related to the column: modal_no
	 * @param modalNo the modal_no value
	 */
	public void setModalNo (java.lang.String modalNo) {
		this.modalNo = modalNo;
	}



	/**
	 * Return the value associated with the column: vehicle_name
	 */
	public java.lang.String getVehicleName () {
		return vehicleName;
	}

	/**
	 * Set the value related to the column: vehicle_name
	 * @param vehicleName the vehicle_name value
	 */
	public void setVehicleName (java.lang.String vehicleName) {
		this.vehicleName = vehicleName;
	}



	/**
	 * Return the value associated with the column: vehicle_type
	 */
	public java.lang.String getVehicleType () {
		return vehicleType;
	}

	/**
	 * Set the value related to the column: vehicle_type
	 * @param vehicleType the vehicle_type value
	 */
	public void setVehicleType (java.lang.String vehicleType) {
		this.vehicleType = vehicleType;
	}



	/**
	 * Return the value associated with the column: agreement_date
	 */
	public java.util.Date getAgreementDate () {
		return agreementDate;
	}

	/**
	 * Set the value related to the column: agreement_date
	 * @param agreementDate the agreement_date value
	 */
	public void setAgreementDate (java.util.Date agreementDate) {
		this.agreementDate = agreementDate;
	}



	/**
	 * Return the value associated with the column: service_outlet
	 */
	public java.lang.String getServiceOutlet () {
		return serviceOutlet;
	}

	/**
	 * Set the value related to the column: service_outlet
	 * @param serviceOutlet the service_outlet value
	 */
	public void setServiceOutlet (java.lang.String serviceOutlet) {
		this.serviceOutlet = serviceOutlet;
	}



	/**
	 * Return the value associated with the column: address
	 */
	public java.lang.String getAddress () {
		return address;
	}

	/**
	 * Set the value related to the column: address
	 * @param address the address value
	 */
	public void setAddress (java.lang.String address) {
		this.address = address;
	}



	/**
	 * Return the value associated with the column: contact_no
	 */
	public java.lang.Long getContactNo () {
		return contactNo;
	}

	/**
	 * Set the value related to the column: contact_no
	 * @param contactNo the contact_no value
	 */
	public void setContactNo (java.lang.Long contactNo) {
		this.contactNo = contactNo;
	}



	/**
	 * Return the value associated with the column: email
	 */
	public java.lang.String getEmail () {
		return email;
	}

	/**
	 * Set the value related to the column: email
	 * @param email the email value
	 */
	public void setEmail (java.lang.String email) {
		this.email = email;
	}



	/**
	 * Return the value associated with the column: warrenty_period
	 */
	public java.lang.String getWarrentyPeriod () {
		return warrentyPeriod;
	}

	/**
	 * Set the value related to the column: warrenty_period
	 * @param warrentyPeriod the warrenty_period value
	 */
	public void setWarrentyPeriod (java.lang.String warrentyPeriod) {
		this.warrentyPeriod = warrentyPeriod;
	}



	/**
	 * Return the value associated with the column: effective_from_date
	 */
	public java.util.Date getEffectiveFromDate () {
		return effectiveFromDate;
	}

	/**
	 * Set the value related to the column: effective_from_date
	 * @param effectiveFromDate the effective_from_date value
	 */
	public void setEffectiveFromDate (java.util.Date effectiveFromDate) {
		this.effectiveFromDate = effectiveFromDate;
	}



	/**
	 * Return the value associated with the column: purchase_value
	 */
	public java.math.BigDecimal getPurchaseValue () {
		return purchaseValue;
	}

	/**
	 * Set the value related to the column: purchase_value
	 * @param purchaseValue the purchase_value value
	 */
	public void setPurchaseValue (java.math.BigDecimal purchaseValue) {
		this.purchaseValue = purchaseValue;
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
	 * Return the value associated with the column: road_tax
	 */
	public java.math.BigDecimal getRoadTax () {
		return roadTax;
	}

	/**
	 * Set the value related to the column: road_tax
	 * @param roadTax the road_tax value
	 */
	public void setRoadTax (java.math.BigDecimal roadTax) {
		this.roadTax = roadTax;
	}



	/**
	 * Return the value associated with the column: valid_upto
	 */
	public java.util.Date getValidUpto () {
		return validUpto;
	}

	/**
	 * Set the value related to the column: valid_upto
	 * @param validUpto the valid_upto value
	 */
	public void setValidUpto (java.util.Date validUpto) {
		this.validUpto = validUpto;
	}



	/**
	 * Return the value associated with the column: auction_status
	 */
	public java.lang.String getAuctionStatus () {
		return auctionStatus;
	}

	/**
	 * Set the value related to the column: auction_status
	 * @param auctionStatus the auction_status value
	 */
	public void setAuctionStatus (java.lang.String auctionStatus) {
		this.auctionStatus = auctionStatus;
	}



	/**
	 * Return the value associated with the column: party_name
	 */
	public java.lang.String getPartyName () {
		return partyName;
	}

	/**
	 * Set the value related to the column: party_name
	 * @param partyName the party_name value
	 */
	public void setPartyName (java.lang.String partyName) {
		this.partyName = partyName;
	}



	/**
	 * Return the value associated with the column: party_address
	 */
	public java.lang.String getPartyAddress () {
		return partyAddress;
	}

	/**
	 * Set the value related to the column: party_address
	 * @param partyAddress the party_address value
	 */
	public void setPartyAddress (java.lang.String partyAddress) {
		this.partyAddress = partyAddress;
	}



	/**
	 * Return the value associated with the column: party_contact_no
	 */
	public java.lang.Long getPartyContactNo () {
		return partyContactNo;
	}

	/**
	 * Set the value related to the column: party_contact_no
	 * @param partyContactNo the party_contact_no value
	 */
	public void setPartyContactNo (java.lang.Long partyContactNo) {
		this.partyContactNo = partyContactNo;
	}



	/**
	 * Return the value associated with the column: asset_code
	 */
	public java.lang.String getAssetCode () {
		return assetCode;
	}

	/**
	 * Set the value related to the column: asset_code
	 * @param assetCode the asset_code value
	 */
	public void setAssetCode (java.lang.String assetCode) {
		this.assetCode = assetCode;
	}



	/**
	 * Return the value associated with the column: auction_date
	 */
	public java.util.Date getAuctionDate () {
		return auctionDate;
	}

	/**
	 * Set the value related to the column: auction_date
	 * @param auctionDate the auction_date value
	 */
	public void setAuctionDate (java.util.Date auctionDate) {
		this.auctionDate = auctionDate;
	}



	/**
	 * Return the value associated with the column: auction_remarks
	 */
	public java.lang.String getAuctionRemarks () {
		return auctionRemarks;
	}

	/**
	 * Set the value related to the column: auction_remarks
	 * @param auctionRemarks the auction_remarks value
	 */
	public void setAuctionRemarks (java.lang.String auctionRemarks) {
		this.auctionRemarks = auctionRemarks;
	}



	/**
	 * Return the value associated with the column: lease_period
	 */
	public java.lang.String getLeasePeriod () {
		return leasePeriod;
	}

	/**
	 * Set the value related to the column: lease_period
	 * @param leasePeriod the lease_period value
	 */
	public void setLeasePeriod (java.lang.String leasePeriod) {
		this.leasePeriod = leasePeriod;
	}



	/**
	 * Return the value associated with the column: lease_completion_date
	 */
	public java.util.Date getLeaseCompletionDate () {
		return leaseCompletionDate;
	}

	/**
	 * Set the value related to the column: lease_completion_date
	 * @param leaseCompletionDate the lease_completion_date value
	 */
	public void setLeaseCompletionDate (java.util.Date leaseCompletionDate) {
		this.leaseCompletionDate = leaseCompletionDate;
	}



	/**
	 * Return the value associated with the column: deprecation
	 */
	public java.lang.Integer getDeprecation () {
		return deprecation;
	}

	/**
	 * Set the value related to the column: deprecation
	 * @param deprecation the deprecation value
	 */
	public void setDeprecation (java.lang.Integer deprecation) {
		this.deprecation = deprecation;
	}



	/**
	 * Return the value associated with the column: auction_amount
	 */
	public java.math.BigDecimal getAuctionAmount () {
		return auctionAmount;
	}

	/**
	 * Set the value related to the column: auction_amount
	 * @param auctionAmount the auction_amount value
	 */
	public void setAuctionAmount (java.math.BigDecimal auctionAmount) {
		this.auctionAmount = auctionAmount;
	}



	/**
	 * Return the value associated with the column: source_of_vehicle
	 */
	public java.lang.String getSourceOfVehicle () {
		return sourceOfVehicle;
	}

	/**
	 * Set the value related to the column: source_of_vehicle
	 * @param sourceOfVehicle the source_of_vehicle value
	 */
	public void setSourceOfVehicle (java.lang.String sourceOfVehicle) {
		this.sourceOfVehicle = sourceOfVehicle;
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
	 * Return the value associated with the column: manufacturer
	 */
	public jkt.hms.masters.business.MasManufacturer getManufacturer () {
		return manufacturer;
	}

	/**
	 * Set the value related to the column: manufacturer
	 * @param manufacturer the manufacturer value
	 */
	public void setManufacturer (jkt.hms.masters.business.MasManufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}



	/**
	 * Return the value associated with the column: authoriser_name
	 */
	public jkt.hms.masters.business.MasEmployee getAuthoriserName () {
		return authoriserName;
	}

	/**
	 * Set the value related to the column: authoriser_name
	 * @param authoriserName the authoriser_name value
	 */
	public void setAuthoriserName (jkt.hms.masters.business.MasEmployee authoriserName) {
		this.authoriserName = authoriserName;
	}



	/**
	 * Return the value associated with the column: district_id
	 */
	public jkt.hms.masters.business.MasDistrict getDistrict () {
		return district;
	}

	/**
	 * Set the value related to the column: district_id
	 * @param district the district_id value
	 */
	public void setDistrict (jkt.hms.masters.business.MasDistrict district) {
		this.district = district;
	}



	/**
	 * Return the value associated with the column: requested_by
	 */
	public jkt.hms.masters.business.MasEmployee getRequestedBy () {
		return requestedBy;
	}

	/**
	 * Set the value related to the column: requested_by
	 * @param requestedBy the requested_by value
	 */
	public void setRequestedBy (jkt.hms.masters.business.MasEmployee requestedBy) {
		this.requestedBy = requestedBy;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PrqAssetDetails)) return false;
		else {
			jkt.hms.masters.business.PrqAssetDetails prqAssetDetails = (jkt.hms.masters.business.PrqAssetDetails) obj;
			if (null == this.getId() || null == prqAssetDetails.getId()) return false;
			else return (this.getId().equals(prqAssetDetails.getId()));
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
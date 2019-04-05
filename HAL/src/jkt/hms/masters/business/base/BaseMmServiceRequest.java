package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mm_service_request table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mm_service_request"
 */

public abstract class BaseMmServiceRequest  implements Serializable {

	public static String REF = "MmServiceRequest";
	public static String PROP_CLOSE_TIME = "CloseTime";
	public static String PROP_REQUEST_STATUS = "RequestStatus";
	public static String PROP_REQUEST_DATE = "RequestDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_REQUIRED_DATE = "RequiredDate";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_APPROVED_BY = "ApprovedBy";
	public static String PROP_FEEDBACK_REMARKS = "FeedbackRemarks";
	public static String PROP_EQUIP_RECEIVED_DATE = "EquipReceivedDate";
	public static String PROP_LAST_AUCTION_DETAILS = "LastAuctionDetails";
	public static String PROP_WARRENTY_STATUS = "WarrentyStatus";
	public static String PROP_FEEDBACK_CLOSER = "FeedbackCloser";
	public static String PROP_MANUFACTURER = "Manufacturer";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_TRANSFER_DETAIL = "TransferDetail";
	public static String PROP_RESOURCE_USER = "ResourceUser";
	public static String PROP_AMC = "Amc";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_SERVICE_REQUEST_NO = "ServiceRequestNo";
	public static String PROP_KFC_FORM_NO = "KfcFormNo";
	public static String PROP_FORWARD_DEPARTMENT = "ForwardDepartment";
	public static String PROP_DESCRIPTION = "Description";
	public static String PROP_MAX_BID_AMOUNT = "MaxBidAmount";
	public static String PROP_EQUIPMENT = "Equipment";
	public static String PROP_QUANTITY = "Quantity";
	public static String PROP_CONDEMN_APPROVEL_REMARKS = "CondemnApprovelRemarks";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_REQUEST_TIME = "RequestTime";
	public static String PROP_PRIORITY = "Priority";
	public static String PROP_RESOURCE_REMARKS = "ResourceRemarks";
	public static String PROP_CONDEMN_REMARKS = "CondemnRemarks";
	public static String PROP_TR_REQ_STATUS = "TrReqStatus";
	public static String PROP_APPROVED_DATE = "ApprovedDate";
	public static String PROP_ID = "Id";
	public static String PROP_CLOSE_DATE = "CloseDate";
	public static String PROP_FEEDBACK_SATISFACTION = "FeedbackSatisfaction";
	public static String PROP_REQUEST_TYPE = "RequestType";


	// constructors
	public BaseMmServiceRequest () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMmServiceRequest (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String serviceRequestNo;
	private java.lang.String warrentyStatus;
	private java.lang.String requestType;
	private java.lang.String description;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.util.Date requiredDate;
	private java.lang.String remarks;
	private java.util.Date requestDate;
	private java.util.Date approvedDate;
	private java.lang.String resourceRemarks;
	private java.lang.String transferDetail;
	private java.lang.String feedbackSatisfaction;
	private java.lang.String feedbackCloser;
	private java.lang.String feedbackRemarks;
	private java.lang.String condemnApprovelRemarks;
	private java.lang.String condemnRemarks;
	private java.lang.String requestTime;
	private java.util.Date closeDate;
	private java.lang.String closeTime;
	private java.lang.String kfcFormNo;
	private java.math.BigDecimal maxBidAmount;
	private java.lang.String lastAuctionDetails;
	private java.lang.Integer quantity;
	private java.util.Date equipReceivedDate;

	// many to one
	private jkt.hms.masters.business.Users approvedBy;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MmMasRequestStatus requestStatus;
	private jkt.hms.masters.business.MasPriorityCodes priority;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.HesEquipmentAmcDetailsEntry amc;
	private jkt.hms.masters.business.MasDepartment forwardDepartment;
	private jkt.hms.masters.business.MasManufacturer manufacturer;
	private jkt.hms.masters.business.MasEmployee resourceUser;
	private jkt.hms.masters.business.HesEquipmentMaster equipment;
	private jkt.hms.masters.business.MmMasRequestStatus trReqStatus;

	// collections
	private java.util.Set<jkt.hms.masters.business.MmInspectionReport> mmInspectionReports;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="request_id"
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
	 * Return the value associated with the column: service_request_no
	 */
	public java.lang.String getServiceRequestNo () {
		return serviceRequestNo;
	}

	/**
	 * Set the value related to the column: service_request_no
	 * @param serviceRequestNo the service_request_no value
	 */
	public void setServiceRequestNo (java.lang.String serviceRequestNo) {
		this.serviceRequestNo = serviceRequestNo;
	}



	/**
	 * Return the value associated with the column: warrenty_status
	 */
	public java.lang.String getWarrentyStatus () {
		return warrentyStatus;
	}

	/**
	 * Set the value related to the column: warrenty_status
	 * @param warrentyStatus the warrenty_status value
	 */
	public void setWarrentyStatus (java.lang.String warrentyStatus) {
		this.warrentyStatus = warrentyStatus;
	}



	/**
	 * Return the value associated with the column: request_type
	 */
	public java.lang.String getRequestType () {
		return requestType;
	}

	/**
	 * Set the value related to the column: request_type
	 * @param requestType the request_type value
	 */
	public void setRequestType (java.lang.String requestType) {
		this.requestType = requestType;
	}



	/**
	 * Return the value associated with the column: description
	 */
	public java.lang.String getDescription () {
		return description;
	}

	/**
	 * Set the value related to the column: description
	 * @param description the description value
	 */
	public void setDescription (java.lang.String description) {
		this.description = description;
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
	 * Return the value associated with the column: required_date
	 */
	public java.util.Date getRequiredDate () {
		return requiredDate;
	}

	/**
	 * Set the value related to the column: required_date
	 * @param requiredDate the required_date value
	 */
	public void setRequiredDate (java.util.Date requiredDate) {
		this.requiredDate = requiredDate;
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
	 * Return the value associated with the column: request_date
	 */
	public java.util.Date getRequestDate () {
		return requestDate;
	}

	/**
	 * Set the value related to the column: request_date
	 * @param requestDate the request_date value
	 */
	public void setRequestDate (java.util.Date requestDate) {
		this.requestDate = requestDate;
	}



	/**
	 * Return the value associated with the column: approved_date
	 */
	public java.util.Date getApprovedDate () {
		return approvedDate;
	}

	/**
	 * Set the value related to the column: approved_date
	 * @param approvedDate the approved_date value
	 */
	public void setApprovedDate (java.util.Date approvedDate) {
		this.approvedDate = approvedDate;
	}



	/**
	 * Return the value associated with the column: resource_remarks
	 */
	public java.lang.String getResourceRemarks () {
		return resourceRemarks;
	}

	/**
	 * Set the value related to the column: resource_remarks
	 * @param resourceRemarks the resource_remarks value
	 */
	public void setResourceRemarks (java.lang.String resourceRemarks) {
		this.resourceRemarks = resourceRemarks;
	}



	/**
	 * Return the value associated with the column: transfer_detail
	 */
	public java.lang.String getTransferDetail () {
		return transferDetail;
	}

	/**
	 * Set the value related to the column: transfer_detail
	 * @param transferDetail the transfer_detail value
	 */
	public void setTransferDetail (java.lang.String transferDetail) {
		this.transferDetail = transferDetail;
	}



	/**
	 * Return the value associated with the column: feedback_satisfaction
	 */
	public java.lang.String getFeedbackSatisfaction () {
		return feedbackSatisfaction;
	}

	/**
	 * Set the value related to the column: feedback_satisfaction
	 * @param feedbackSatisfaction the feedback_satisfaction value
	 */
	public void setFeedbackSatisfaction (java.lang.String feedbackSatisfaction) {
		this.feedbackSatisfaction = feedbackSatisfaction;
	}



	/**
	 * Return the value associated with the column: feedback_closer
	 */
	public java.lang.String getFeedbackCloser () {
		return feedbackCloser;
	}

	/**
	 * Set the value related to the column: feedback_closer
	 * @param feedbackCloser the feedback_closer value
	 */
	public void setFeedbackCloser (java.lang.String feedbackCloser) {
		this.feedbackCloser = feedbackCloser;
	}



	/**
	 * Return the value associated with the column: feedback_remarks
	 */
	public java.lang.String getFeedbackRemarks () {
		return feedbackRemarks;
	}

	/**
	 * Set the value related to the column: feedback_remarks
	 * @param feedbackRemarks the feedback_remarks value
	 */
	public void setFeedbackRemarks (java.lang.String feedbackRemarks) {
		this.feedbackRemarks = feedbackRemarks;
	}



	/**
	 * Return the value associated with the column: condemn_approvel_remarks
	 */
	public java.lang.String getCondemnApprovelRemarks () {
		return condemnApprovelRemarks;
	}

	/**
	 * Set the value related to the column: condemn_approvel_remarks
	 * @param condemnApprovelRemarks the condemn_approvel_remarks value
	 */
	public void setCondemnApprovelRemarks (java.lang.String condemnApprovelRemarks) {
		this.condemnApprovelRemarks = condemnApprovelRemarks;
	}



	/**
	 * Return the value associated with the column: condemn_remarks
	 */
	public java.lang.String getCondemnRemarks () {
		return condemnRemarks;
	}

	/**
	 * Set the value related to the column: condemn_remarks
	 * @param condemnRemarks the condemn_remarks value
	 */
	public void setCondemnRemarks (java.lang.String condemnRemarks) {
		this.condemnRemarks = condemnRemarks;
	}



	/**
	 * Return the value associated with the column: request_time
	 */
	public java.lang.String getRequestTime () {
		return requestTime;
	}

	/**
	 * Set the value related to the column: request_time
	 * @param requestTime the request_time value
	 */
	public void setRequestTime (java.lang.String requestTime) {
		this.requestTime = requestTime;
	}



	/**
	 * Return the value associated with the column: close_date
	 */
	public java.util.Date getCloseDate () {
		return closeDate;
	}

	/**
	 * Set the value related to the column: close_date
	 * @param closeDate the close_date value
	 */
	public void setCloseDate (java.util.Date closeDate) {
		this.closeDate = closeDate;
	}



	/**
	 * Return the value associated with the column: close_time
	 */
	public java.lang.String getCloseTime () {
		return closeTime;
	}

	/**
	 * Set the value related to the column: close_time
	 * @param closeTime the close_time value
	 */
	public void setCloseTime (java.lang.String closeTime) {
		this.closeTime = closeTime;
	}



	/**
	 * Return the value associated with the column: kfc_form_no
	 */
	public java.lang.String getKfcFormNo () {
		return kfcFormNo;
	}

	/**
	 * Set the value related to the column: kfc_form_no
	 * @param kfcFormNo the kfc_form_no value
	 */
	public void setKfcFormNo (java.lang.String kfcFormNo) {
		this.kfcFormNo = kfcFormNo;
	}



	/**
	 * Return the value associated with the column: max_bid_amount
	 */
	public java.math.BigDecimal getMaxBidAmount () {
		return maxBidAmount;
	}

	/**
	 * Set the value related to the column: max_bid_amount
	 * @param maxBidAmount the max_bid_amount value
	 */
	public void setMaxBidAmount (java.math.BigDecimal maxBidAmount) {
		this.maxBidAmount = maxBidAmount;
	}



	/**
	 * Return the value associated with the column: last_auction_details
	 */
	public java.lang.String getLastAuctionDetails () {
		return lastAuctionDetails;
	}

	/**
	 * Set the value related to the column: last_auction_details
	 * @param lastAuctionDetails the last_auction_details value
	 */
	public void setLastAuctionDetails (java.lang.String lastAuctionDetails) {
		this.lastAuctionDetails = lastAuctionDetails;
	}



	/**
	 * Return the value associated with the column: quantity
	 */
	public java.lang.Integer getQuantity () {
		return quantity;
	}

	/**
	 * Set the value related to the column: quantity
	 * @param quantity the quantity value
	 */
	public void setQuantity (java.lang.Integer quantity) {
		this.quantity = quantity;
	}



	/**
	 * Return the value associated with the column: equip_received_date
	 */
	public java.util.Date getEquipReceivedDate () {
		return equipReceivedDate;
	}

	/**
	 * Set the value related to the column: equip_received_date
	 * @param equipReceivedDate the equip_received_date value
	 */
	public void setEquipReceivedDate (java.util.Date equipReceivedDate) {
		this.equipReceivedDate = equipReceivedDate;
	}



	/**
	 * Return the value associated with the column: approved_by
	 */
	public jkt.hms.masters.business.Users getApprovedBy () {
		return approvedBy;
	}

	/**
	 * Set the value related to the column: approved_by
	 * @param approvedBy the approved_by value
	 */
	public void setApprovedBy (jkt.hms.masters.business.Users approvedBy) {
		this.approvedBy = approvedBy;
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
	 * Return the value associated with the column: request_status
	 */
	public jkt.hms.masters.business.MmMasRequestStatus getRequestStatus () {
		return requestStatus;
	}

	/**
	 * Set the value related to the column: request_status
	 * @param requestStatus the request_status value
	 */
	public void setRequestStatus (jkt.hms.masters.business.MmMasRequestStatus requestStatus) {
		this.requestStatus = requestStatus;
	}



	/**
	 * Return the value associated with the column: priority_id
	 */
	public jkt.hms.masters.business.MasPriorityCodes getPriority () {
		return priority;
	}

	/**
	 * Set the value related to the column: priority_id
	 * @param priority the priority_id value
	 */
	public void setPriority (jkt.hms.masters.business.MasPriorityCodes priority) {
		this.priority = priority;
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
	 * Return the value associated with the column: amc_id
	 */
	public jkt.hms.masters.business.HesEquipmentAmcDetailsEntry getAmc () {
		return amc;
	}

	/**
	 * Set the value related to the column: amc_id
	 * @param amc the amc_id value
	 */
	public void setAmc (jkt.hms.masters.business.HesEquipmentAmcDetailsEntry amc) {
		this.amc = amc;
	}



	/**
	 * Return the value associated with the column: forward_department
	 */
	public jkt.hms.masters.business.MasDepartment getForwardDepartment () {
		return forwardDepartment;
	}

	/**
	 * Set the value related to the column: forward_department
	 * @param forwardDepartment the forward_department value
	 */
	public void setForwardDepartment (jkt.hms.masters.business.MasDepartment forwardDepartment) {
		this.forwardDepartment = forwardDepartment;
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
	 * Return the value associated with the column: resource_user
	 */
	public jkt.hms.masters.business.MasEmployee getResourceUser () {
		return resourceUser;
	}

	/**
	 * Set the value related to the column: resource_user
	 * @param resourceUser the resource_user value
	 */
	public void setResourceUser (jkt.hms.masters.business.MasEmployee resourceUser) {
		this.resourceUser = resourceUser;
	}



	/**
	 * Return the value associated with the column: equipment_id
	 */
	public jkt.hms.masters.business.HesEquipmentMaster getEquipment () {
		return equipment;
	}

	/**
	 * Set the value related to the column: equipment_id
	 * @param equipment the equipment_id value
	 */
	public void setEquipment (jkt.hms.masters.business.HesEquipmentMaster equipment) {
		this.equipment = equipment;
	}



	/**
	 * Return the value associated with the column: tr_req_status
	 */
	public jkt.hms.masters.business.MmMasRequestStatus getTrReqStatus () {
		return trReqStatus;
	}

	/**
	 * Set the value related to the column: tr_req_status
	 * @param trReqStatus the tr_req_status value
	 */
	public void setTrReqStatus (jkt.hms.masters.business.MmMasRequestStatus trReqStatus) {
		this.trReqStatus = trReqStatus;
	}



	/**
	 * Return the value associated with the column: MmInspectionReports
	 */
	public java.util.Set<jkt.hms.masters.business.MmInspectionReport> getMmInspectionReports () {
		return mmInspectionReports;
	}

	/**
	 * Set the value related to the column: MmInspectionReports
	 * @param mmInspectionReports the MmInspectionReports value
	 */
	public void setMmInspectionReports (java.util.Set<jkt.hms.masters.business.MmInspectionReport> mmInspectionReports) {
		this.mmInspectionReports = mmInspectionReports;
	}

	public void addToMmInspectionReports (jkt.hms.masters.business.MmInspectionReport mmInspectionReport) {
		if (null == getMmInspectionReports()) setMmInspectionReports(new java.util.TreeSet<jkt.hms.masters.business.MmInspectionReport>());
		getMmInspectionReports().add(mmInspectionReport);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MmServiceRequest)) return false;
		else {
			jkt.hms.masters.business.MmServiceRequest mmServiceRequest = (jkt.hms.masters.business.MmServiceRequest) obj;
			if (null == this.getId() || null == mmServiceRequest.getId()) return false;
			else return (this.getId().equals(mmServiceRequest.getId()));
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
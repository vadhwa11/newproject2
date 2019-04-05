package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mm_inspection_report table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mm_inspection_report"
 */

public abstract class BaseMmInspectionReport  implements Serializable {

	public static String REF = "MmInspectionReport";
	public static String PROP_WO_CHALLAN_AMOUNT = "WoChallanAmount";
	public static String PROP_WO_CLOSE_DATE = "WoCloseDate";
	public static String PROP_SERVICE_REPORT_NO = "ServiceReportNo";
	public static String PROP_PLANNED_START_DATE = "PlannedStartDate";
	public static String PROP_REQUEST_STATUS = "RequestStatus";
	public static String PROP_OBSERVATION_REMARK = "ObservationRemark";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_OBSERVATION_DATE = "ObservationDate";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_PLANNED_COST = "PlannedCost";
	public static String PROP_REQUEST = "Request";
	public static String PROP_PREVENTIVE_DONE_ON = "PreventiveDoneOn";
	public static String PROP_SCHEDULED_TIME = "ScheduledTime";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_WO_CLOSE_TIME = "WoCloseTime";
	public static String PROP_DESCRIPTION_OF_WORK = "DescriptionOfWork";
	public static String PROP_WORKED_ON = "WorkedOn";
	public static String PROP_WORK_ORDER_REMARK = "WorkOrderRemark";
	public static String PROP_WO_REQ_DATE = "WoReqDate";
	public static String PROP_WO_CHALLAN_DATE = "WoChallanDate";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_REASON = "Reason";
	public static String PROP_WORK_ORDER_TYPE = "WorkOrderType";
	public static String PROP_EQUIPMENT = "Equipment";
	public static String PROP_EMERGENCY_INDENT = "EmergencyIndent";
	public static String PROP_SERVICE_REPORT_DATE = "ServiceReportDate";
	public static String PROP_PO_DETAIL = "PoDetail";
	public static String PROP_CONTACT_PERSON = "ContactPerson";
	public static String PROP_WO_STATUS = "WoStatus";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_SERVICE_COST = "ServiceCost";
	public static String PROP_SCHEDULED_DATE = "ScheduledDate";
	public static String PROP_WORK_ORDER_DATE = "WorkOrderDate";
	public static String PROP_WO_REMARKS = "WoRemarks";
	public static String PROP_WO_CHALLAN_NO = "WoChallanNo";
	public static String PROP_PLANNED_END_DATE = "PlannedEndDate";
	public static String PROP_MATERIAL_COST = "MaterialCost";
	public static String PROP_WORK_ORDER_NO = "WorkOrderNo";
	public static String PROP_STATUS = "Status";
	public static String PROP_RESOURCE_REQUIREMENT = "ResourceRequirement";
	public static String PROP_CLOSE_TYPE = "CloseType";
	public static String PROP_VENDOR = "Vendor";
	public static String PROP_ID = "Id";
	public static String PROP_OBSERVATION_TIME = "ObservationTime";


	// constructors
	public BaseMmInspectionReport () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMmInspectionReport (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String closeType;
	private java.lang.String contactPerson;
	private java.lang.String descriptionOfWork;
	private java.lang.String emergencyIndent;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.math.BigDecimal materialCost;
	private java.util.Date observationDate;
	private java.lang.String observationRemark;
	private java.lang.String observationTime;
	private java.math.BigDecimal plannedCost;
	private java.util.Date plannedEndDate;
	private java.util.Date plannedStartDate;
	private java.util.Date preventiveDoneOn;
	private java.lang.String reason;
	private java.lang.String remarks;
	private java.lang.String resourceRequirement;
	private java.util.Date scheduledDate;
	private java.lang.String scheduledTime;
	private java.math.BigDecimal serviceCost;
	private java.util.Date serviceReportDate;
	private java.lang.String serviceReportNo;
	private java.lang.String status;
	private java.math.BigDecimal woChallanAmount;
	private java.util.Date woChallanDate;
	private java.lang.String woChallanNo;
	private java.util.Date woCloseDate;
	private java.lang.String woCloseTime;
	private java.lang.String woRemarks;
	private java.util.Date woReqDate;
	private java.lang.String woStatus;
	private java.util.Date workOrderDate;
	private java.lang.String workOrderNo;
	private java.lang.String workOrderRemark;
	private java.lang.String workOrderType;
	private java.lang.String workedOn;

	// many to one
	private jkt.hms.masters.business.HesEquipmentMaster equipment;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.StorePoDetail poDetail;
	private jkt.hms.masters.business.MmServiceRequest request;
	private jkt.hms.masters.business.MmMasRequestStatus requestStatus;
	private jkt.hms.masters.business.MasStoreSupplier vendor;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="inspection_report_id"
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
	 * Return the value associated with the column: close_type
	 */
	public java.lang.String getCloseType () {
		return closeType;
	}

	/**
	 * Set the value related to the column: close_type
	 * @param closeType the close_type value
	 */
	public void setCloseType (java.lang.String closeType) {
		this.closeType = closeType;
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
	 * Return the value associated with the column: description_of_work
	 */
	public java.lang.String getDescriptionOfWork () {
		return descriptionOfWork;
	}

	/**
	 * Set the value related to the column: description_of_work
	 * @param descriptionOfWork the description_of_work value
	 */
	public void setDescriptionOfWork (java.lang.String descriptionOfWork) {
		this.descriptionOfWork = descriptionOfWork;
	}



	/**
	 * Return the value associated with the column: emergency_indent
	 */
	public java.lang.String getEmergencyIndent () {
		return emergencyIndent;
	}

	/**
	 * Set the value related to the column: emergency_indent
	 * @param emergencyIndent the emergency_indent value
	 */
	public void setEmergencyIndent (java.lang.String emergencyIndent) {
		this.emergencyIndent = emergencyIndent;
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
	 * Return the value associated with the column: material_cost
	 */
	public java.math.BigDecimal getMaterialCost () {
		return materialCost;
	}

	/**
	 * Set the value related to the column: material_cost
	 * @param materialCost the material_cost value
	 */
	public void setMaterialCost (java.math.BigDecimal materialCost) {
		this.materialCost = materialCost;
	}



	/**
	 * Return the value associated with the column: observation_date
	 */
	public java.util.Date getObservationDate () {
		return observationDate;
	}

	/**
	 * Set the value related to the column: observation_date
	 * @param observationDate the observation_date value
	 */
	public void setObservationDate (java.util.Date observationDate) {
		this.observationDate = observationDate;
	}



	/**
	 * Return the value associated with the column: observation_remark
	 */
	public java.lang.String getObservationRemark () {
		return observationRemark;
	}

	/**
	 * Set the value related to the column: observation_remark
	 * @param observationRemark the observation_remark value
	 */
	public void setObservationRemark (java.lang.String observationRemark) {
		this.observationRemark = observationRemark;
	}



	/**
	 * Return the value associated with the column: observation_time
	 */
	public java.lang.String getObservationTime () {
		return observationTime;
	}

	/**
	 * Set the value related to the column: observation_time
	 * @param observationTime the observation_time value
	 */
	public void setObservationTime (java.lang.String observationTime) {
		this.observationTime = observationTime;
	}



	/**
	 * Return the value associated with the column: planned_cost
	 */
	public java.math.BigDecimal getPlannedCost () {
		return plannedCost;
	}

	/**
	 * Set the value related to the column: planned_cost
	 * @param plannedCost the planned_cost value
	 */
	public void setPlannedCost (java.math.BigDecimal plannedCost) {
		this.plannedCost = plannedCost;
	}



	/**
	 * Return the value associated with the column: planned_end_date
	 */
	public java.util.Date getPlannedEndDate () {
		return plannedEndDate;
	}

	/**
	 * Set the value related to the column: planned_end_date
	 * @param plannedEndDate the planned_end_date value
	 */
	public void setPlannedEndDate (java.util.Date plannedEndDate) {
		this.plannedEndDate = plannedEndDate;
	}



	/**
	 * Return the value associated with the column: planned_start_date
	 */
	public java.util.Date getPlannedStartDate () {
		return plannedStartDate;
	}

	/**
	 * Set the value related to the column: planned_start_date
	 * @param plannedStartDate the planned_start_date value
	 */
	public void setPlannedStartDate (java.util.Date plannedStartDate) {
		this.plannedStartDate = plannedStartDate;
	}



	/**
	 * Return the value associated with the column: preventive_done_on
	 */
	public java.util.Date getPreventiveDoneOn () {
		return preventiveDoneOn;
	}

	/**
	 * Set the value related to the column: preventive_done_on
	 * @param preventiveDoneOn the preventive_done_on value
	 */
	public void setPreventiveDoneOn (java.util.Date preventiveDoneOn) {
		this.preventiveDoneOn = preventiveDoneOn;
	}



	/**
	 * Return the value associated with the column: reason
	 */
	public java.lang.String getReason () {
		return reason;
	}

	/**
	 * Set the value related to the column: reason
	 * @param reason the reason value
	 */
	public void setReason (java.lang.String reason) {
		this.reason = reason;
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
	 * Return the value associated with the column: resource_requirement
	 */
	public java.lang.String getResourceRequirement () {
		return resourceRequirement;
	}

	/**
	 * Set the value related to the column: resource_requirement
	 * @param resourceRequirement the resource_requirement value
	 */
	public void setResourceRequirement (java.lang.String resourceRequirement) {
		this.resourceRequirement = resourceRequirement;
	}



	/**
	 * Return the value associated with the column: scheduled_date
	 */
	public java.util.Date getScheduledDate () {
		return scheduledDate;
	}

	/**
	 * Set the value related to the column: scheduled_date
	 * @param scheduledDate the scheduled_date value
	 */
	public void setScheduledDate (java.util.Date scheduledDate) {
		this.scheduledDate = scheduledDate;
	}



	/**
	 * Return the value associated with the column: scheduled_time
	 */
	public java.lang.String getScheduledTime () {
		return scheduledTime;
	}

	/**
	 * Set the value related to the column: scheduled_time
	 * @param scheduledTime the scheduled_time value
	 */
	public void setScheduledTime (java.lang.String scheduledTime) {
		this.scheduledTime = scheduledTime;
	}



	/**
	 * Return the value associated with the column: service_cost
	 */
	public java.math.BigDecimal getServiceCost () {
		return serviceCost;
	}

	/**
	 * Set the value related to the column: service_cost
	 * @param serviceCost the service_cost value
	 */
	public void setServiceCost (java.math.BigDecimal serviceCost) {
		this.serviceCost = serviceCost;
	}



	/**
	 * Return the value associated with the column: service_report_date
	 */
	public java.util.Date getServiceReportDate () {
		return serviceReportDate;
	}

	/**
	 * Set the value related to the column: service_report_date
	 * @param serviceReportDate the service_report_date value
	 */
	public void setServiceReportDate (java.util.Date serviceReportDate) {
		this.serviceReportDate = serviceReportDate;
	}



	/**
	 * Return the value associated with the column: service_report_no
	 */
	public java.lang.String getServiceReportNo () {
		return serviceReportNo;
	}

	/**
	 * Set the value related to the column: service_report_no
	 * @param serviceReportNo the service_report_no value
	 */
	public void setServiceReportNo (java.lang.String serviceReportNo) {
		this.serviceReportNo = serviceReportNo;
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
	 * Return the value associated with the column: wo_challan_amount
	 */
	public java.math.BigDecimal getWoChallanAmount () {
		return woChallanAmount;
	}

	/**
	 * Set the value related to the column: wo_challan_amount
	 * @param woChallanAmount the wo_challan_amount value
	 */
	public void setWoChallanAmount (java.math.BigDecimal woChallanAmount) {
		this.woChallanAmount = woChallanAmount;
	}



	/**
	 * Return the value associated with the column: wo_challan_date
	 */
	public java.util.Date getWoChallanDate () {
		return woChallanDate;
	}

	/**
	 * Set the value related to the column: wo_challan_date
	 * @param woChallanDate the wo_challan_date value
	 */
	public void setWoChallanDate (java.util.Date woChallanDate) {
		this.woChallanDate = woChallanDate;
	}



	/**
	 * Return the value associated with the column: wo_challan_no
	 */
	public java.lang.String getWoChallanNo () {
		return woChallanNo;
	}

	/**
	 * Set the value related to the column: wo_challan_no
	 * @param woChallanNo the wo_challan_no value
	 */
	public void setWoChallanNo (java.lang.String woChallanNo) {
		this.woChallanNo = woChallanNo;
	}



	/**
	 * Return the value associated with the column: wo_close_date
	 */
	public java.util.Date getWoCloseDate () {
		return woCloseDate;
	}

	/**
	 * Set the value related to the column: wo_close_date
	 * @param woCloseDate the wo_close_date value
	 */
	public void setWoCloseDate (java.util.Date woCloseDate) {
		this.woCloseDate = woCloseDate;
	}



	/**
	 * Return the value associated with the column: wo_close_time
	 */
	public java.lang.String getWoCloseTime () {
		return woCloseTime;
	}

	/**
	 * Set the value related to the column: wo_close_time
	 * @param woCloseTime the wo_close_time value
	 */
	public void setWoCloseTime (java.lang.String woCloseTime) {
		this.woCloseTime = woCloseTime;
	}



	/**
	 * Return the value associated with the column: wo_remarks
	 */
	public java.lang.String getWoRemarks () {
		return woRemarks;
	}

	/**
	 * Set the value related to the column: wo_remarks
	 * @param woRemarks the wo_remarks value
	 */
	public void setWoRemarks (java.lang.String woRemarks) {
		this.woRemarks = woRemarks;
	}



	/**
	 * Return the value associated with the column: wo_req_date
	 */
	public java.util.Date getWoReqDate () {
		return woReqDate;
	}

	/**
	 * Set the value related to the column: wo_req_date
	 * @param woReqDate the wo_req_date value
	 */
	public void setWoReqDate (java.util.Date woReqDate) {
		this.woReqDate = woReqDate;
	}



	/**
	 * Return the value associated with the column: wo_status
	 */
	public java.lang.String getWoStatus () {
		return woStatus;
	}

	/**
	 * Set the value related to the column: wo_status
	 * @param woStatus the wo_status value
	 */
	public void setWoStatus (java.lang.String woStatus) {
		this.woStatus = woStatus;
	}



	/**
	 * Return the value associated with the column: work_order_date
	 */
	public java.util.Date getWorkOrderDate () {
		return workOrderDate;
	}

	/**
	 * Set the value related to the column: work_order_date
	 * @param workOrderDate the work_order_date value
	 */
	public void setWorkOrderDate (java.util.Date workOrderDate) {
		this.workOrderDate = workOrderDate;
	}



	/**
	 * Return the value associated with the column: work_order_no
	 */
	public java.lang.String getWorkOrderNo () {
		return workOrderNo;
	}

	/**
	 * Set the value related to the column: work_order_no
	 * @param workOrderNo the work_order_no value
	 */
	public void setWorkOrderNo (java.lang.String workOrderNo) {
		this.workOrderNo = workOrderNo;
	}



	/**
	 * Return the value associated with the column: work_order_remark
	 */
	public java.lang.String getWorkOrderRemark () {
		return workOrderRemark;
	}

	/**
	 * Set the value related to the column: work_order_remark
	 * @param workOrderRemark the work_order_remark value
	 */
	public void setWorkOrderRemark (java.lang.String workOrderRemark) {
		this.workOrderRemark = workOrderRemark;
	}



	/**
	 * Return the value associated with the column: work_order_type
	 */
	public java.lang.String getWorkOrderType () {
		return workOrderType;
	}

	/**
	 * Set the value related to the column: work_order_type
	 * @param workOrderType the work_order_type value
	 */
	public void setWorkOrderType (java.lang.String workOrderType) {
		this.workOrderType = workOrderType;
	}



	/**
	 * Return the value associated with the column: worked_on
	 */
	public java.lang.String getWorkedOn () {
		return workedOn;
	}

	/**
	 * Set the value related to the column: worked_on
	 * @param workedOn the worked_on value
	 */
	public void setWorkedOn (java.lang.String workedOn) {
		this.workedOn = workedOn;
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
	 * Return the value associated with the column: request_id
	 */
	public jkt.hms.masters.business.MmServiceRequest getRequest () {
		return request;
	}

	/**
	 * Set the value related to the column: request_id
	 * @param request the request_id value
	 */
	public void setRequest (jkt.hms.masters.business.MmServiceRequest request) {
		this.request = request;
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
	 * Return the value associated with the column: vendor_id
	 */
	public jkt.hms.masters.business.MasStoreSupplier getVendor () {
		return vendor;
	}

	/**
	 * Set the value related to the column: vendor_id
	 * @param vendor the vendor_id value
	 */
	public void setVendor (jkt.hms.masters.business.MasStoreSupplier vendor) {
		this.vendor = vendor;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MmInspectionReport)) return false;
		else {
			jkt.hms.masters.business.MmInspectionReport mmInspectionReport = (jkt.hms.masters.business.MmInspectionReport) obj;
			if (null == this.getId() || null == mmInspectionReport.getId()) return false;
			else return (this.getId().equals(mmInspectionReport.getId()));
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
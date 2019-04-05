package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hes_equipment_master table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hes_equipment_master"
 */

public abstract class BaseHesEquipmentMaster  implements Serializable {

	public static String REF = "HesEquipmentMaster";
	public static String PROP_CHECKLIST_STATUS = "ChecklistStatus";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_DATE_OF_INSTALLATION = "DateOfInstallation";
	public static String PROP_GRN_T = "GrnT";
	public static String PROP_WARRANTY_DETAILS = "WarrantyDetails";
	public static String PROP_REPLACEMENT_VALUE = "ReplacementValue";
	public static String PROP_REJECTION_DETAIL = "RejectionDetail";
	public static String PROP_TECHNICAL_SPECIFICATIONS = "TechnicalSpecifications";
	public static String PROP_WARRENTY_STATUS = "WarrentyStatus";
	public static String PROP_PREVENTIVE_CYCLE = "PreventiveCycle";
	public static String PROP_WARRENTY_END_DATE = "WarrentyEndDate";
	public static String PROP_SOURCE_OF_SUPPLY = "SourceOfSupply";
	public static String PROP_MANUFACTURER = "Manufacturer";
	public static String PROP_DEPRECIATION = "Depreciation";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ITEM = "Item";
	public static String PROP_EQUIP_STATUS = "EquipStatus";
	public static String PROP_EQUIPMENT_NAME = "EquipmentName";
	public static String PROP_ASSET = "Asset";
	public static String PROP_SERIAL_NO = "SerialNo";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_WARRANTY_TYPE = "WarrantyType";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_SUPPLY_ORDER_NO = "SupplyOrderNo";
	public static String PROP_PREVENTIVE_COMPLETED_CYCLE = "PreventiveCompletedCycle";
	public static String PROP_PREVENTIVE_STATUS = "PreventiveStatus";
	public static String PROP_CONTACT_NO_SALES_SERVICE = "ContactNoSalesService";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ENTRY_NO = "EntryNo";
	public static String PROP_EQUIPMENT_DETAIL_DATE = "EquipmentDetailDate";
	public static String PROP_WARRENTY_START_DATE = "WarrentyStartDate";
	public static String PROP_STATUS = "Status";
	public static String PROP_SUPPLIER = "Supplier";
	public static String PROP_MODEL_NAME = "ModelName";
	public static String PROP_ID = "Id";
	public static String PROP_MAKE = "Make";


	// constructors
	public BaseHesEquipmentMaster () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHesEquipmentMaster (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseHesEquipmentMaster (
		java.lang.Integer id,
		java.math.BigDecimal replacementValue) {

		this.setId(id);
		this.setReplacementValue(replacementValue);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String equipmentName;
	private java.lang.String modelName;
	private java.lang.String serialNo;
	private java.lang.String make;
	private java.lang.String warrantyDetails;
	private java.lang.String technicalSpecifications;
	private java.lang.String contactNoSalesService;
	private java.lang.String entryNo;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.util.Date warrentyStartDate;
	private java.util.Date warrentyEndDate;
	private java.util.Date dateOfInstallation;
	private java.lang.String supplyOrderNo;
	private java.lang.String sourceOfSupply;
	private java.lang.Integer preventiveCycle;
	private java.lang.Integer preventiveCompletedCycle;
	private java.lang.String rejectionDetail;
	private java.math.BigDecimal replacementValue;
	private java.lang.String warrentyStatus;
	private java.lang.String preventiveStatus;
	private java.lang.String checklistStatus;
	private java.util.Date equipmentDetailDate;
	private java.lang.String warrantyType;
	private java.lang.Integer depreciation;

	// many to one
	private jkt.hms.masters.business.PrqAssetDetails asset;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasStoreSupplier supplier;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasStoreItem item;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasManufacturer manufacturer;
	private jkt.hms.masters.business.StoreGrnT grnT;
	private jkt.hms.masters.business.MmMasRequestStatus equipStatus;

	// collections
	private java.util.Set<jkt.hms.masters.business.HesEquipmentAssessories> hesEquipmentAssessories;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="equipment_id"
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
	 * Return the value associated with the column: equipment_name
	 */
	public java.lang.String getEquipmentName () {
		return equipmentName;
	}

	/**
	 * Set the value related to the column: equipment_name
	 * @param equipmentName the equipment_name value
	 */
	public void setEquipmentName (java.lang.String equipmentName) {
		this.equipmentName = equipmentName;
	}



	/**
	 * Return the value associated with the column: model_name
	 */
	public java.lang.String getModelName () {
		return modelName;
	}

	/**
	 * Set the value related to the column: model_name
	 * @param modelName the model_name value
	 */
	public void setModelName (java.lang.String modelName) {
		this.modelName = modelName;
	}



	/**
	 * Return the value associated with the column: serial_no
	 */
	public java.lang.String getSerialNo () {
		return serialNo;
	}

	/**
	 * Set the value related to the column: serial_no
	 * @param serialNo the serial_no value
	 */
	public void setSerialNo (java.lang.String serialNo) {
		this.serialNo = serialNo;
	}



	/**
	 * Return the value associated with the column: make
	 */
	public java.lang.String getMake () {
		return make;
	}

	/**
	 * Set the value related to the column: make
	 * @param make the make value
	 */
	public void setMake (java.lang.String make) {
		this.make = make;
	}



	/**
	 * Return the value associated with the column: warranty_details
	 */
	public java.lang.String getWarrantyDetails () {
		return warrantyDetails;
	}

	/**
	 * Set the value related to the column: warranty_details
	 * @param warrantyDetails the warranty_details value
	 */
	public void setWarrantyDetails (java.lang.String warrantyDetails) {
		this.warrantyDetails = warrantyDetails;
	}



	/**
	 * Return the value associated with the column: technical_specifications
	 */
	public java.lang.String getTechnicalSpecifications () {
		return technicalSpecifications;
	}

	/**
	 * Set the value related to the column: technical_specifications
	 * @param technicalSpecifications the technical_specifications value
	 */
	public void setTechnicalSpecifications (java.lang.String technicalSpecifications) {
		this.technicalSpecifications = technicalSpecifications;
	}



	/**
	 * Return the value associated with the column: contact_no_sales_service
	 */
	public java.lang.String getContactNoSalesService () {
		return contactNoSalesService;
	}

	/**
	 * Set the value related to the column: contact_no_sales_service
	 * @param contactNoSalesService the contact_no_sales_service value
	 */
	public void setContactNoSalesService (java.lang.String contactNoSalesService) {
		this.contactNoSalesService = contactNoSalesService;
	}



	/**
	 * Return the value associated with the column: entry_no
	 */
	public java.lang.String getEntryNo () {
		return entryNo;
	}

	/**
	 * Set the value related to the column: entry_no
	 * @param entryNo the entry_no value
	 */
	public void setEntryNo (java.lang.String entryNo) {
		this.entryNo = entryNo;
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
	 * Return the value associated with the column: warrenty_start_date
	 */
	public java.util.Date getWarrentyStartDate () {
		return warrentyStartDate;
	}

	/**
	 * Set the value related to the column: warrenty_start_date
	 * @param warrentyStartDate the warrenty_start_date value
	 */
	public void setWarrentyStartDate (java.util.Date warrentyStartDate) {
		this.warrentyStartDate = warrentyStartDate;
	}



	/**
	 * Return the value associated with the column: warrenty_end_date
	 */
	public java.util.Date getWarrentyEndDate () {
		return warrentyEndDate;
	}

	/**
	 * Set the value related to the column: warrenty_end_date
	 * @param warrentyEndDate the warrenty_end_date value
	 */
	public void setWarrentyEndDate (java.util.Date warrentyEndDate) {
		this.warrentyEndDate = warrentyEndDate;
	}



	/**
	 * Return the value associated with the column: date_of_installation
	 */
	public java.util.Date getDateOfInstallation () {
		return dateOfInstallation;
	}

	/**
	 * Set the value related to the column: date_of_installation
	 * @param dateOfInstallation the date_of_installation value
	 */
	public void setDateOfInstallation (java.util.Date dateOfInstallation) {
		this.dateOfInstallation = dateOfInstallation;
	}



	/**
	 * Return the value associated with the column: supply_order_no
	 */
	public java.lang.String getSupplyOrderNo () {
		return supplyOrderNo;
	}

	/**
	 * Set the value related to the column: supply_order_no
	 * @param supplyOrderNo the supply_order_no value
	 */
	public void setSupplyOrderNo (java.lang.String supplyOrderNo) {
		this.supplyOrderNo = supplyOrderNo;
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
	 * Return the value associated with the column: preventive_cycle
	 */
	public java.lang.Integer getPreventiveCycle () {
		return preventiveCycle;
	}

	/**
	 * Set the value related to the column: preventive_cycle
	 * @param preventiveCycle the preventive_cycle value
	 */
	public void setPreventiveCycle (java.lang.Integer preventiveCycle) {
		this.preventiveCycle = preventiveCycle;
	}



	/**
	 * Return the value associated with the column: preventive_completed_cycle
	 */
	public java.lang.Integer getPreventiveCompletedCycle () {
		return preventiveCompletedCycle;
	}

	/**
	 * Set the value related to the column: preventive_completed_cycle
	 * @param preventiveCompletedCycle the preventive_completed_cycle value
	 */
	public void setPreventiveCompletedCycle (java.lang.Integer preventiveCompletedCycle) {
		this.preventiveCompletedCycle = preventiveCompletedCycle;
	}



	/**
	 * Return the value associated with the column: rejection_detail
	 */
	public java.lang.String getRejectionDetail () {
		return rejectionDetail;
	}

	/**
	 * Set the value related to the column: rejection_detail
	 * @param rejectionDetail the rejection_detail value
	 */
	public void setRejectionDetail (java.lang.String rejectionDetail) {
		this.rejectionDetail = rejectionDetail;
	}



	/**
	 * Return the value associated with the column: replacement_value
	 */
	public java.math.BigDecimal getReplacementValue () {
		return replacementValue;
	}

	/**
	 * Set the value related to the column: replacement_value
	 * @param replacementValue the replacement_value value
	 */
	public void setReplacementValue (java.math.BigDecimal replacementValue) {
		this.replacementValue = replacementValue;
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
	 * Return the value associated with the column: preventive_status
	 */
	public java.lang.String getPreventiveStatus () {
		return preventiveStatus;
	}

	/**
	 * Set the value related to the column: preventive_status
	 * @param preventiveStatus the preventive_status value
	 */
	public void setPreventiveStatus (java.lang.String preventiveStatus) {
		this.preventiveStatus = preventiveStatus;
	}



	/**
	 * Return the value associated with the column: checklist_status
	 */
	public java.lang.String getChecklistStatus () {
		return checklistStatus;
	}

	/**
	 * Set the value related to the column: checklist_status
	 * @param checklistStatus the checklist_status value
	 */
	public void setChecklistStatus (java.lang.String checklistStatus) {
		this.checklistStatus = checklistStatus;
	}



	/**
	 * Return the value associated with the column: equipment_detail_date
	 */
	public java.util.Date getEquipmentDetailDate () {
		return equipmentDetailDate;
	}

	/**
	 * Set the value related to the column: equipment_detail_date
	 * @param equipmentDetailDate the equipment_detail_date value
	 */
	public void setEquipmentDetailDate (java.util.Date equipmentDetailDate) {
		this.equipmentDetailDate = equipmentDetailDate;
	}



	/**
	 * Return the value associated with the column: warranty_type
	 */
	public java.lang.String getWarrantyType () {
		return warrantyType;
	}

	/**
	 * Set the value related to the column: warranty_type
	 * @param warrantyType the warranty_type value
	 */
	public void setWarrantyType (java.lang.String warrantyType) {
		this.warrantyType = warrantyType;
	}



	/**
	 * Return the value associated with the column: depreciation
	 */
	public java.lang.Integer getDepreciation () {
		return depreciation;
	}

	/**
	 * Set the value related to the column: depreciation
	 * @param depreciation the depreciation value
	 */
	public void setDepreciation (java.lang.Integer depreciation) {
		this.depreciation = depreciation;
	}



	/**
	 * Return the value associated with the column: asset_id
	 */
	public jkt.hms.masters.business.PrqAssetDetails getAsset () {
		return asset;
	}

	/**
	 * Set the value related to the column: asset_id
	 * @param asset the asset_id value
	 */
	public void setAsset (jkt.hms.masters.business.PrqAssetDetails asset) {
		this.asset = asset;
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
	 * Return the value associated with the column: grn_t_id
	 */
	public jkt.hms.masters.business.StoreGrnT getGrnT () {
		return grnT;
	}

	/**
	 * Set the value related to the column: grn_t_id
	 * @param grnT the grn_t_id value
	 */
	public void setGrnT (jkt.hms.masters.business.StoreGrnT grnT) {
		this.grnT = grnT;
	}



	/**
	 * Return the value associated with the column: equip_status
	 */
	public jkt.hms.masters.business.MmMasRequestStatus getEquipStatus () {
		return equipStatus;
	}

	/**
	 * Set the value related to the column: equip_status
	 * @param equipStatus the equip_status value
	 */
	public void setEquipStatus (jkt.hms.masters.business.MmMasRequestStatus equipStatus) {
		this.equipStatus = equipStatus;
	}



	/**
	 * Return the value associated with the column: HesEquipmentAssessories
	 */
	public java.util.Set<jkt.hms.masters.business.HesEquipmentAssessories> getHesEquipmentAssessories () {
		return hesEquipmentAssessories;
	}

	/**
	 * Set the value related to the column: HesEquipmentAssessories
	 * @param hesEquipmentAssessories the HesEquipmentAssessories value
	 */
	public void setHesEquipmentAssessories (java.util.Set<jkt.hms.masters.business.HesEquipmentAssessories> hesEquipmentAssessories) {
		this.hesEquipmentAssessories = hesEquipmentAssessories;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HesEquipmentMaster)) return false;
		else {
			jkt.hms.masters.business.HesEquipmentMaster hesEquipmentMaster = (jkt.hms.masters.business.HesEquipmentMaster) obj;
			if (null == this.getId() || null == hesEquipmentMaster.getId()) return false;
			else return (this.getId().equals(hesEquipmentMaster.getId()));
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
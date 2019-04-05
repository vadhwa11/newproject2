package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the store_amc_m table. Do not
 * modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * 
 * @hibernate.class table="store_amc_m"
 */

public abstract class BaseStoreAmcM implements Serializable {

	public static String REF = "StoreAmcM";
	public static String PROP_EQUIPMENT_DEPT = "EquipmentDept";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_SUPPORT_END_DATE = "SupportEndDate";
	public static String PROP_WARRANTY_END_DATE = "WarrantyEndDate";
	public static String PROP_SUPPORT_START_DATE = "SupportStartDate";
	public static String PROP_ITEM = "Item";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_CRV_NO = "CrvNo";
	public static String PROP_COST_OF_EQUIPMENT = "CostOfEquipment";
	public static String PROP_SERIAL_NO = "SerialNo";
	public static String PROP_TOT_RECEIVED_QTY = "TotReceivedQty";
	public static String PROP_WARRANTY_START_DATE = "WarrantyStartDate";
	public static String PROP_FIRST_AMC_START_DATE = "FirstAmcStartDate";
	public static String PROP_SUPPLY_ORDER_NO = "SupplyOrderNo";
	public static String PROP_ENTRY_NO = "EntryNo";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_ENTRY_DATE = "EntryDate";
	public static String PROP_DATE_OF_INSTALLATION = "DateOfInstallation";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHAG_TIME = "LastChagTime";

	// constructors
	public BaseStoreAmcM() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreAmcM(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String entryNo;
	private java.util.Date entryDate;
	private java.lang.String serialNo;
	private java.lang.Integer hospitalId;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChagTime;
	private java.util.Date firstAmcStartDate;
	private java.lang.String supplyOrderNo;
	private java.lang.String crvNo;
	private java.math.BigDecimal costOfEquipment;
	private java.util.Date dateOfInstallation;
	private java.util.Date warrantyStartDate;
	private java.util.Date warrantyEndDate;
	private java.util.Date supportStartDate;
	private java.util.Date supportEndDate;
	private java.math.BigDecimal totReceivedQty;

	// many to one
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasDepartment equipmentDept;
	private jkt.hms.masters.business.MasStoreItem item;

	// collections
	private java.util.Set<jkt.hms.masters.business.StoreAmcT> storeAmcTs;

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
	 * Return the value associated with the column: entry_no
	 */
	public java.lang.String getEntryNo() {
		return entryNo;
	}

	/**
	 * Set the value related to the column: entry_no
	 * 
	 * @param entryNo
	 *            the entry_no value
	 */
	public void setEntryNo(java.lang.String entryNo) {
		this.entryNo = entryNo;
	}

	/**
	 * Return the value associated with the column: entry_date
	 */
	public java.util.Date getEntryDate() {
		return entryDate;
	}

	/**
	 * Set the value related to the column: entry_date
	 * 
	 * @param entryDate
	 *            the entry_date value
	 */
	public void setEntryDate(java.util.Date entryDate) {
		this.entryDate = entryDate;
	}

	/**
	 * Return the value associated with the column: serial_no
	 */
	public java.lang.String getSerialNo() {
		return serialNo;
	}

	/**
	 * Set the value related to the column: serial_no
	 * 
	 * @param serialNo
	 *            the serial_no value
	 */
	public void setSerialNo(java.lang.String serialNo) {
		this.serialNo = serialNo;
	}

	/**
	 * Return the value associated with the column: hospital_id
	 */
	public java.lang.Integer getHospitalId() {
		return hospitalId;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * 
	 * @param hospitalId
	 *            the hospital_id value
	 */
	public void setHospitalId(java.lang.Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus() {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * 
	 * @param status
	 *            the status value
	 */
	public void setStatus(java.lang.String status) {
		this.status = status;
	}

	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.String getLastChgBy() {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * 
	 * @param lastChgBy
	 *            the last_chg_by value
	 */
	public void setLastChgBy(java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
	}

	/**
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate() {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * 
	 * @param lastChgDate
	 *            the last_chg_date value
	 */
	public void setLastChgDate(java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}

	/**
	 * Return the value associated with the column: last_chag_time
	 */
	public java.lang.String getLastChagTime() {
		return lastChagTime;
	}

	/**
	 * Set the value related to the column: last_chag_time
	 * 
	 * @param lastChagTime
	 *            the last_chag_time value
	 */
	public void setLastChagTime(java.lang.String lastChagTime) {
		this.lastChagTime = lastChagTime;
	}

	/**
	 * Return the value associated with the column: first_amc_start_date
	 */
	public java.util.Date getFirstAmcStartDate() {
		return firstAmcStartDate;
	}

	/**
	 * Set the value related to the column: first_amc_start_date
	 * 
	 * @param firstAmcStartDate
	 *            the first_amc_start_date value
	 */
	public void setFirstAmcStartDate(java.util.Date firstAmcStartDate) {
		this.firstAmcStartDate = firstAmcStartDate;
	}

	/**
	 * Return the value associated with the column: supply_order_no
	 */
	public java.lang.String getSupplyOrderNo() {
		return supplyOrderNo;
	}

	/**
	 * Set the value related to the column: supply_order_no
	 * 
	 * @param supplyOrderNo
	 *            the supply_order_no value
	 */
	public void setSupplyOrderNo(java.lang.String supplyOrderNo) {
		this.supplyOrderNo = supplyOrderNo;
	}

	/**
	 * Return the value associated with the column: crv_no
	 */
	public java.lang.String getCrvNo() {
		return crvNo;
	}

	/**
	 * Set the value related to the column: crv_no
	 * 
	 * @param crvNo
	 *            the crv_no value
	 */
	public void setCrvNo(java.lang.String crvNo) {
		this.crvNo = crvNo;
	}

	/**
	 * Return the value associated with the column: cost_of_equipment
	 */
	public java.math.BigDecimal getCostOfEquipment() {
		return costOfEquipment;
	}

	/**
	 * Set the value related to the column: cost_of_equipment
	 * 
	 * @param costOfEquipment
	 *            the cost_of_equipment value
	 */
	public void setCostOfEquipment(java.math.BigDecimal costOfEquipment) {
		this.costOfEquipment = costOfEquipment;
	}

	/**
	 * Return the value associated with the column: date_of_installation
	 */
	public java.util.Date getDateOfInstallation() {
		return dateOfInstallation;
	}

	/**
	 * Set the value related to the column: date_of_installation
	 * 
	 * @param dateOfInstallation
	 *            the date_of_installation value
	 */
	public void setDateOfInstallation(java.util.Date dateOfInstallation) {
		this.dateOfInstallation = dateOfInstallation;
	}

	/**
	 * Return the value associated with the column: warranty_start_date
	 */
	public java.util.Date getWarrantyStartDate() {
		return warrantyStartDate;
	}

	/**
	 * Set the value related to the column: warranty_start_date
	 * 
	 * @param warrantyStartDate
	 *            the warranty_start_date value
	 */
	public void setWarrantyStartDate(java.util.Date warrantyStartDate) {
		this.warrantyStartDate = warrantyStartDate;
	}

	/**
	 * Return the value associated with the column: warranty_end_date
	 */
	public java.util.Date getWarrantyEndDate() {
		return warrantyEndDate;
	}

	/**
	 * Set the value related to the column: warranty_end_date
	 * 
	 * @param warrantyEndDate
	 *            the warranty_end_date value
	 */
	public void setWarrantyEndDate(java.util.Date warrantyEndDate) {
		this.warrantyEndDate = warrantyEndDate;
	}

	/**
	 * Return the value associated with the column: support_start_date
	 */
	public java.util.Date getSupportStartDate() {
		return supportStartDate;
	}

	/**
	 * Set the value related to the column: support_start_date
	 * 
	 * @param supportStartDate
	 *            the support_start_date value
	 */
	public void setSupportStartDate(java.util.Date supportStartDate) {
		this.supportStartDate = supportStartDate;
	}

	/**
	 * Return the value associated with the column: support_end_date
	 */
	public java.util.Date getSupportEndDate() {
		return supportEndDate;
	}

	/**
	 * Set the value related to the column: support_end_date
	 * 
	 * @param supportEndDate
	 *            the support_end_date value
	 */
	public void setSupportEndDate(java.util.Date supportEndDate) {
		this.supportEndDate = supportEndDate;
	}

	/**
	 * Return the value associated with the column: tot_received_qty
	 */
	public java.math.BigDecimal getTotReceivedQty() {
		return totReceivedQty;
	}

	/**
	 * Set the value related to the column: tot_received_qty
	 * 
	 * @param totReceivedQty
	 *            the tot_received_qty value
	 */
	public void setTotReceivedQty(java.math.BigDecimal totReceivedQty) {
		this.totReceivedQty = totReceivedQty;
	}

	/**
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment() {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * 
	 * @param department
	 *            the department_id value
	 */
	public void setDepartment(jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}

	/**
	 * Return the value associated with the column: equipment_dept_id
	 */
	public jkt.hms.masters.business.MasDepartment getEquipmentDept() {
		return equipmentDept;
	}

	/**
	 * Set the value related to the column: equipment_dept_id
	 * 
	 * @param equipmentDept
	 *            the equipment_dept_id value
	 */
	public void setEquipmentDept(
			jkt.hms.masters.business.MasDepartment equipmentDept) {
		this.equipmentDept = equipmentDept;
	}

	/**
	 * Return the value associated with the column: item_id
	 */
	public jkt.hms.masters.business.MasStoreItem getItem() {
		return item;
	}

	/**
	 * Set the value related to the column: item_id
	 * 
	 * @param item
	 *            the item_id value
	 */
	public void setItem(jkt.hms.masters.business.MasStoreItem item) {
		this.item = item;
	}

	/**
	 * Return the value associated with the column: StoreAmcTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreAmcT> getStoreAmcTs() {
		return storeAmcTs;
	}

	/**
	 * Set the value related to the column: StoreAmcTs
	 * 
	 * @param storeAmcTs
	 *            the StoreAmcTs value
	 */
	public void setStoreAmcTs(
			java.util.Set<jkt.hms.masters.business.StoreAmcT> storeAmcTs) {
		this.storeAmcTs = storeAmcTs;
	}

	public void addToStoreAmcTs(jkt.hms.masters.business.StoreAmcT storeAmcT) {
		if (null == getStoreAmcTs())
			setStoreAmcTs(new java.util.TreeSet<jkt.hms.masters.business.StoreAmcT>());
		getStoreAmcTs().add(storeAmcT);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreAmcM))
			return false;
		else {
			jkt.hms.masters.business.StoreAmcM storeAmcM = (jkt.hms.masters.business.StoreAmcM) obj;
			if (null == this.getId() || null == storeAmcM.getId())
				return false;
			else
				return (this.getId().equals(storeAmcM.getId()));
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
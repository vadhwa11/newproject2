package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the store_repair_civil_firm
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="store_repair_civil_firm"
 */

public abstract class BaseStoreRepairCivilFirm implements Serializable {

	public static String REF = "StoreRepairCivilFirm";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_REPAIR_NO = "RepairNo";
	public static String PROP_ITEM = "Item";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_CRV_NO = "CrvNo";
	public static String PROP_BLR_BER_CERTIFICATE = "BlrBerCertificate";
	public static String PROP_NO_OF_TIME_OUTORDER = "NoOfTimeOutorder";
	public static String PROP_CONDITION_OF_ITEM = "ConditionOfItem";
	public static String PROP_REASON_FOR_RECOMMEND = "ReasonForRecommend";
	public static String PROP_COST_OF_REPAIR = "CostOfRepair";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_QTY = "Qty";
	public static String PROP_LAST_COST_OF_REPAIR = "LastCostOfRepair";
	public static String PROP_QTY_REPAIR = "QtyRepair";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_COST_OF_EQUIPMENT = "CostOfEquipment";
	public static String PROP_SERIAL_NO = "SerialNo";
	public static String PROP_REPAIR_BREAKDOWN = "RepairBreakdown";
	public static String PROP_NATURE_OF_REPAIR = "NatureOfRepair";
	public static String PROP_SOURCE_OF_RECEIPT = "SourceOfReceipt";
	public static String PROP_REPAIR_DATE = "RepairDate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_COMPARATIVE_STAT_OF_QUOTATION = "ComparativeStatOfQuotation";
	public static String PROP_REASONABLE_OF_REPAIR_COST = "ReasonableOfRepairCost";
	public static String PROP_ID = "Id";

	// constructors
	public BaseStoreRepairCivilFirm() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreRepairCivilFirm(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String blrBerCertificate;
	private java.lang.String comparativeStatOfQuotation;
	private java.lang.String conditionOfItem;
	private java.math.BigDecimal costOfEquipment;
	private java.lang.String costOfRepair;
	private java.lang.String crvNo;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String lastCostOfRepair;
	private java.lang.String natureOfRepair;
	private java.lang.String noOfTimeOutorder;
	private java.lang.Integer qty;
	private java.lang.Integer qtyRepair;
	private java.lang.String reasonForRecommend;
	private java.math.BigDecimal reasonableOfRepairCost;
	private java.lang.String repairBreakdown;
	private java.util.Date repairDate;
	private java.lang.String repairNo;
	private java.lang.String serialNo;
	private java.lang.String sourceOfReceipt;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasStoreItem item;

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
	 * Return the value associated with the column: blr_ber_certificate
	 */
	public java.lang.String getBlrBerCertificate() {
		return blrBerCertificate;
	}

	/**
	 * Set the value related to the column: blr_ber_certificate
	 * 
	 * @param blrBerCertificate
	 *            the blr_ber_certificate value
	 */
	public void setBlrBerCertificate(java.lang.String blrBerCertificate) {
		this.blrBerCertificate = blrBerCertificate;
	}

	/**
	 * Return the value associated with the column:
	 * comparative_stat_of_quotation
	 */
	public java.lang.String getComparativeStatOfQuotation() {
		return comparativeStatOfQuotation;
	}

	/**
	 * Set the value related to the column: comparative_stat_of_quotation
	 * 
	 * @param comparativeStatOfQuotation
	 *            the comparative_stat_of_quotation value
	 */
	public void setComparativeStatOfQuotation(
			java.lang.String comparativeStatOfQuotation) {
		this.comparativeStatOfQuotation = comparativeStatOfQuotation;
	}

	/**
	 * Return the value associated with the column: condition_of_item
	 */
	public java.lang.String getConditionOfItem() {
		return conditionOfItem;
	}

	/**
	 * Set the value related to the column: condition_of_item
	 * 
	 * @param conditionOfItem
	 *            the condition_of_item value
	 */
	public void setConditionOfItem(java.lang.String conditionOfItem) {
		this.conditionOfItem = conditionOfItem;
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
	 * Return the value associated with the column: cost_of_repair
	 */
	public java.lang.String getCostOfRepair() {
		return costOfRepair;
	}

	/**
	 * Set the value related to the column: cost_of_repair
	 * 
	 * @param costOfRepair
	 *            the cost_of_repair value
	 */
	public void setCostOfRepair(java.lang.String costOfRepair) {
		this.costOfRepair = costOfRepair;
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
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime() {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * 
	 * @param lastChgTime
	 *            the last_chg_time value
	 */
	public void setLastChgTime(java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}

	/**
	 * Return the value associated with the column: last_cost_of_repair
	 */
	public java.lang.String getLastCostOfRepair() {
		return lastCostOfRepair;
	}

	/**
	 * Set the value related to the column: last_cost_of_repair
	 * 
	 * @param lastCostOfRepair
	 *            the last_cost_of_repair value
	 */
	public void setLastCostOfRepair(java.lang.String lastCostOfRepair) {
		this.lastCostOfRepair = lastCostOfRepair;
	}

	/**
	 * Return the value associated with the column: nature_of_repair
	 */
	public java.lang.String getNatureOfRepair() {
		return natureOfRepair;
	}

	/**
	 * Set the value related to the column: nature_of_repair
	 * 
	 * @param natureOfRepair
	 *            the nature_of_repair value
	 */
	public void setNatureOfRepair(java.lang.String natureOfRepair) {
		this.natureOfRepair = natureOfRepair;
	}

	/**
	 * Return the value associated with the column: no_of_time_outorder
	 */
	public java.lang.String getNoOfTimeOutorder() {
		return noOfTimeOutorder;
	}

	/**
	 * Set the value related to the column: no_of_time_outorder
	 * 
	 * @param noOfTimeOutorder
	 *            the no_of_time_outorder value
	 */
	public void setNoOfTimeOutorder(java.lang.String noOfTimeOutorder) {
		this.noOfTimeOutorder = noOfTimeOutorder;
	}

	/**
	 * Return the value associated with the column: qty
	 */
	public java.lang.Integer getQty() {
		return qty;
	}

	/**
	 * Set the value related to the column: qty
	 * 
	 * @param qty
	 *            the qty value
	 */
	public void setQty(java.lang.Integer qty) {
		this.qty = qty;
	}

	/**
	 * Return the value associated with the column: qty_repair
	 */
	public java.lang.Integer getQtyRepair() {
		return qtyRepair;
	}

	/**
	 * Set the value related to the column: qty_repair
	 * 
	 * @param qtyRepair
	 *            the qty_repair value
	 */
	public void setQtyRepair(java.lang.Integer qtyRepair) {
		this.qtyRepair = qtyRepair;
	}

	/**
	 * Return the value associated with the column: reason_for_recommend
	 */
	public java.lang.String getReasonForRecommend() {
		return reasonForRecommend;
	}

	/**
	 * Set the value related to the column: reason_for_recommend
	 * 
	 * @param reasonForRecommend
	 *            the reason_for_recommend value
	 */
	public void setReasonForRecommend(java.lang.String reasonForRecommend) {
		this.reasonForRecommend = reasonForRecommend;
	}

	/**
	 * Return the value associated with the column: reasonable_of_repair_cost
	 */
	public java.math.BigDecimal getReasonableOfRepairCost() {
		return reasonableOfRepairCost;
	}

	/**
	 * Set the value related to the column: reasonable_of_repair_cost
	 * 
	 * @param reasonableOfRepairCost
	 *            the reasonable_of_repair_cost value
	 */
	public void setReasonableOfRepairCost(
			java.math.BigDecimal reasonableOfRepairCost) {
		this.reasonableOfRepairCost = reasonableOfRepairCost;
	}

	/**
	 * Return the value associated with the column: repair_breakdown
	 */
	public java.lang.String getRepairBreakdown() {
		return repairBreakdown;
	}

	/**
	 * Set the value related to the column: repair_breakdown
	 * 
	 * @param repairBreakdown
	 *            the repair_breakdown value
	 */
	public void setRepairBreakdown(java.lang.String repairBreakdown) {
		this.repairBreakdown = repairBreakdown;
	}

	/**
	 * Return the value associated with the column: repair_date
	 */
	public java.util.Date getRepairDate() {
		return repairDate;
	}

	/**
	 * Set the value related to the column: repair_date
	 * 
	 * @param repairDate
	 *            the repair_date value
	 */
	public void setRepairDate(java.util.Date repairDate) {
		this.repairDate = repairDate;
	}

	/**
	 * Return the value associated with the column: repair_no
	 */
	public java.lang.String getRepairNo() {
		return repairNo;
	}

	/**
	 * Set the value related to the column: repair_no
	 * 
	 * @param repairNo
	 *            the repair_no value
	 */
	public void setRepairNo(java.lang.String repairNo) {
		this.repairNo = repairNo;
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
	 * Return the value associated with the column: source_of_receipt
	 */
	public java.lang.String getSourceOfReceipt() {
		return sourceOfReceipt;
	}

	/**
	 * Set the value related to the column: source_of_receipt
	 * 
	 * @param sourceOfReceipt
	 *            the source_of_receipt value
	 */
	public void setSourceOfReceipt(java.lang.String sourceOfReceipt) {
		this.sourceOfReceipt = sourceOfReceipt;
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
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital() {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * 
	 * @param hospital
	 *            the hospital_id value
	 */
	public void setHospital(jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
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

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreRepairCivilFirm))
			return false;
		else {
			jkt.hms.masters.business.StoreRepairCivilFirm storeRepairCivilFirm = (jkt.hms.masters.business.StoreRepairCivilFirm) obj;
			if (null == this.getId() || null == storeRepairCivilFirm.getId())
				return false;
			else
				return (this.getId().equals(storeRepairCivilFirm.getId()));
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
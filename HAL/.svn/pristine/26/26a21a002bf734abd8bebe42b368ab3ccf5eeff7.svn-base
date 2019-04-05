package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the store_quater_return_t
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="store_quater_return_t"
 */

public abstract class BaseStoreQuaterReturnT implements Serializable {

	public static String REF = "StoreQuaterReturnT";
	public static String PROP_LOCAL_DEPOT = "LocalDepot";
	public static String PROP_ISSUE_DEPOT = "IssueDepot";
	public static String PROP_COST = "Cost";
	public static String PROP_RECCOMEND_REPAIR = "ReccomendRepair";
	public static String PROP_QTY_REC = "QtyRec";
	public static String PROP_ITEM = "Item";
	public static String PROP_DEALER_REPAIR_SATISFY = "DealerRepairSatisfy";
	public static String PROP_QUATER_RETURN_M = "QuaterReturnM";
	public static String PROP_AT_NO = "AtNo";
	public static String PROP_AT_DATE = "AtDate";
	public static String PROP_EQUIPMENT_DEFECT = "EquipmentDefect";
	public static String PROP_SERVICE_MANUAL_RECEIVED = "ServiceManualReceived";
	public static String PROP_ISSUE_DATE = "IssueDate";
	public static String PROP_SL_NO = "SlNo";
	public static String PROP_PRESENT_FITNESS_STATE = "PresentFitnessState";
	public static String PROP_SPARES_RECEIVED = "SparesReceived";
	public static String PROP_MANUFACTURER_ID = "ManufacturerId";
	public static String PROP_SUPPLIER_NAME_IV_IRNO = "SupplierNameIvIrno";
	public static String PROP_UNDER_WARRANTY = "UnderWarranty";
	public static String PROP_ID = "Id";
	public static String PROP_EXP_ITEM_AVAILABLE = "ExpItemAvailable";

	// constructors
	public BaseStoreQuaterReturnT() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreQuaterReturnT(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseStoreQuaterReturnT(java.lang.Integer id,
			jkt.hms.masters.business.StoreQuaterReturnM quaterReturnM,
			jkt.hms.masters.business.MasStoreItem item, java.lang.Integer slNo,
			java.lang.String supplierNameIvIrno) {

		this.setId(id);
		this.setQuaterReturnM(quaterReturnM);
		this.setItem(item);
		this.setSlNo(slNo);
		this.setSupplierNameIvIrno(supplierNameIvIrno);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer slNo;
	private java.lang.String atNo;
	private java.util.Date atDate;
	private java.math.BigDecimal cost;
	private java.lang.String supplierNameIvIrno;
	private java.math.BigDecimal qtyRec;
	private java.util.Date issueDate;
	private java.lang.Integer manufacturerId;
	private java.lang.String localDepot;
	private java.lang.String presentFitnessState;
	private java.lang.String expItemAvailable;
	private java.lang.String serviceManualReceived;
	private java.lang.String sparesReceived;
	private java.lang.String equipmentDefect;
	private java.lang.String underWarranty;
	private java.lang.String dealerRepairSatisfy;
	private java.lang.String reccomendRepair;

	// many to one
	private jkt.hms.masters.business.StoreQuaterReturnM quaterReturnM;
	private jkt.hms.masters.business.MasStoreAirForceDepot issueDepot;
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
	 * Return the value associated with the column: sl_no
	 */
	public java.lang.Integer getSlNo() {
		return slNo;
	}

	/**
	 * Set the value related to the column: sl_no
	 * 
	 * @param slNo
	 *            the sl_no value
	 */
	public void setSlNo(java.lang.Integer slNo) {
		this.slNo = slNo;
	}

	/**
	 * Return the value associated with the column: at_no
	 */
	public java.lang.String getAtNo() {
		return atNo;
	}

	/**
	 * Set the value related to the column: at_no
	 * 
	 * @param atNo
	 *            the at_no value
	 */
	public void setAtNo(java.lang.String atNo) {
		this.atNo = atNo;
	}

	/**
	 * Return the value associated with the column: at_date
	 */
	public java.util.Date getAtDate() {
		return atDate;
	}

	/**
	 * Set the value related to the column: at_date
	 * 
	 * @param atDate
	 *            the at_date value
	 */
	public void setAtDate(java.util.Date atDate) {
		this.atDate = atDate;
	}

	/**
	 * Return the value associated with the column: cost
	 */
	public java.math.BigDecimal getCost() {
		return cost;
	}

	/**
	 * Set the value related to the column: cost
	 * 
	 * @param cost
	 *            the cost value
	 */
	public void setCost(java.math.BigDecimal cost) {
		this.cost = cost;
	}

	/**
	 * Return the value associated with the column: supplier_name_iv_irno
	 */
	public java.lang.String getSupplierNameIvIrno() {
		return supplierNameIvIrno;
	}

	/**
	 * Set the value related to the column: supplier_name_iv_irno
	 * 
	 * @param supplierNameIvIrno
	 *            the supplier_name_iv_irno value
	 */
	public void setSupplierNameIvIrno(java.lang.String supplierNameIvIrno) {
		this.supplierNameIvIrno = supplierNameIvIrno;
	}

	/**
	 * Return the value associated with the column: qty_rec
	 */
	public java.math.BigDecimal getQtyRec() {
		return qtyRec;
	}

	/**
	 * Set the value related to the column: qty_rec
	 * 
	 * @param qtyRec
	 *            the qty_rec value
	 */
	public void setQtyRec(java.math.BigDecimal qtyRec) {
		this.qtyRec = qtyRec;
	}

	/**
	 * Return the value associated with the column: issue_date
	 */
	public java.util.Date getIssueDate() {
		return issueDate;
	}

	/**
	 * Set the value related to the column: issue_date
	 * 
	 * @param issueDate
	 *            the issue_date value
	 */
	public void setIssueDate(java.util.Date issueDate) {
		this.issueDate = issueDate;
	}

	/**
	 * Return the value associated with the column: manufacturer_id
	 */
	public java.lang.Integer getManufacturerId() {
		return manufacturerId;
	}

	/**
	 * Set the value related to the column: manufacturer_id
	 * 
	 * @param manufacturerId
	 *            the manufacturer_id value
	 */
	public void setManufacturerId(java.lang.Integer manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	/**
	 * Return the value associated with the column: local_depot
	 */
	public java.lang.String getLocalDepot() {
		return localDepot;
	}

	/**
	 * Set the value related to the column: local_depot
	 * 
	 * @param localDepot
	 *            the local_depot value
	 */
	public void setLocalDepot(java.lang.String localDepot) {
		this.localDepot = localDepot;
	}

	/**
	 * Return the value associated with the column: present_fitness_state
	 */
	public java.lang.String getPresentFitnessState() {
		return presentFitnessState;
	}

	/**
	 * Set the value related to the column: present_fitness_state
	 * 
	 * @param presentFitnessState
	 *            the present_fitness_state value
	 */
	public void setPresentFitnessState(java.lang.String presentFitnessState) {
		this.presentFitnessState = presentFitnessState;
	}

	/**
	 * Return the value associated with the column: exp_item_available
	 */
	public java.lang.String getExpItemAvailable() {
		return expItemAvailable;
	}

	/**
	 * Set the value related to the column: exp_item_available
	 * 
	 * @param expItemAvailable
	 *            the exp_item_available value
	 */
	public void setExpItemAvailable(java.lang.String expItemAvailable) {
		this.expItemAvailable = expItemAvailable;
	}

	/**
	 * Return the value associated with the column: service_manual_received
	 */
	public java.lang.String getServiceManualReceived() {
		return serviceManualReceived;
	}

	/**
	 * Set the value related to the column: service_manual_received
	 * 
	 * @param serviceManualReceived
	 *            the service_manual_received value
	 */
	public void setServiceManualReceived(java.lang.String serviceManualReceived) {
		this.serviceManualReceived = serviceManualReceived;
	}

	/**
	 * Return the value associated with the column: spares_received
	 */
	public java.lang.String getSparesReceived() {
		return sparesReceived;
	}

	/**
	 * Set the value related to the column: spares_received
	 * 
	 * @param sparesReceived
	 *            the spares_received value
	 */
	public void setSparesReceived(java.lang.String sparesReceived) {
		this.sparesReceived = sparesReceived;
	}

	/**
	 * Return the value associated with the column: equipment_defect
	 */
	public java.lang.String getEquipmentDefect() {
		return equipmentDefect;
	}

	/**
	 * Set the value related to the column: equipment_defect
	 * 
	 * @param equipmentDefect
	 *            the equipment_defect value
	 */
	public void setEquipmentDefect(java.lang.String equipmentDefect) {
		this.equipmentDefect = equipmentDefect;
	}

	/**
	 * Return the value associated with the column: under_warranty
	 */
	public java.lang.String getUnderWarranty() {
		return underWarranty;
	}

	/**
	 * Set the value related to the column: under_warranty
	 * 
	 * @param underWarranty
	 *            the under_warranty value
	 */
	public void setUnderWarranty(java.lang.String underWarranty) {
		this.underWarranty = underWarranty;
	}

	/**
	 * Return the value associated with the column: dealer_repair_satisfy
	 */
	public java.lang.String getDealerRepairSatisfy() {
		return dealerRepairSatisfy;
	}

	/**
	 * Set the value related to the column: dealer_repair_satisfy
	 * 
	 * @param dealerRepairSatisfy
	 *            the dealer_repair_satisfy value
	 */
	public void setDealerRepairSatisfy(java.lang.String dealerRepairSatisfy) {
		this.dealerRepairSatisfy = dealerRepairSatisfy;
	}

	/**
	 * Return the value associated with the column: reccomend_repair
	 */
	public java.lang.String getReccomendRepair() {
		return reccomendRepair;
	}

	/**
	 * Set the value related to the column: reccomend_repair
	 * 
	 * @param reccomendRepair
	 *            the reccomend_repair value
	 */
	public void setReccomendRepair(java.lang.String reccomendRepair) {
		this.reccomendRepair = reccomendRepair;
	}

	/**
	 * Return the value associated with the column: quater_return_m_id
	 */
	public jkt.hms.masters.business.StoreQuaterReturnM getQuaterReturnM() {
		return quaterReturnM;
	}

	/**
	 * Set the value related to the column: quater_return_m_id
	 * 
	 * @param quaterReturnM
	 *            the quater_return_m_id value
	 */
	public void setQuaterReturnM(
			jkt.hms.masters.business.StoreQuaterReturnM quaterReturnM) {
		this.quaterReturnM = quaterReturnM;
	}

	/**
	 * Return the value associated with the column: issue_depot_id
	 */
	public jkt.hms.masters.business.MasStoreAirForceDepot getIssueDepot() {
		return issueDepot;
	}

	/**
	 * Set the value related to the column: issue_depot_id
	 * 
	 * @param issueDepot
	 *            the issue_depot_id value
	 */
	public void setIssueDepot(
			jkt.hms.masters.business.MasStoreAirForceDepot issueDepot) {
		this.issueDepot = issueDepot;
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
		if (!(obj instanceof jkt.hms.masters.business.StoreQuaterReturnT))
			return false;
		else {
			jkt.hms.masters.business.StoreQuaterReturnT storeQuaterReturnT = (jkt.hms.masters.business.StoreQuaterReturnT) obj;
			if (null == this.getId() || null == storeQuaterReturnT.getId())
				return false;
			else
				return (this.getId().equals(storeQuaterReturnT.getId()));
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
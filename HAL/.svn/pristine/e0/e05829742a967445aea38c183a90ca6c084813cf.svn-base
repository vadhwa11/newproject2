package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hes_equipment_amc_details_entry table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hes_equipment_amc_details_entry"
 */

public abstract class BaseHesEquipmentAmcDetailsEntry  implements Serializable {

	public static String REF = "HesEquipmentAmcDetailsEntry";
	public static String PROP_PREVENTIVE_COMPLETED_CYCLE = "PreventiveCompletedCycle";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_DATE_OF_INSTALLATION = "DateOfInstallation";
	public static String PROP_EPUIPMENT = "Epuipment";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_ADV_BILL_NO = "AdvBillNo";
	public static String PROP_AMC_WARRENTY_START_DATE = "AmcWarrentyStartDate";
	public static String PROP_PREVENTIVE_CYCLE = "PreventiveCycle";
	public static String PROP_STATUS = "Status";
	public static String PROP_ADV_BILL_AMOUNT = "AdvBillAmount";
	public static String PROP_ADV_BILL_DATE = "AdvBillDate";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_BALANCE_BILL_DATE = "BalanceBillDate";
	public static String PROP_AMC_WARRENTY_END_DATE = "AmcWarrentyEndDate";
	public static String PROP_BALANCE_BILL_NO = "BalanceBillNo";
	public static String PROP_SERIAL_NO = "SerialNo";
	public static String PROP_SUPPLIER_GROUP = "SupplierGroup";
	public static String PROP_ID = "Id";
	public static String PROP_COST_OF_AMC = "CostOfAmc";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_BALANCE_BILL_AMOUNT = "BalanceBillAmount";


	// constructors
	public BaseHesEquipmentAmcDetailsEntry () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHesEquipmentAmcDetailsEntry (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseHesEquipmentAmcDetailsEntry (
		java.lang.Integer id,
		jkt.hms.masters.business.HesEquipmentMaster epuipment,
		jkt.hms.masters.business.MasDepartment department,
		jkt.hms.masters.business.MasStoreSupplierGroup supplierGroup) {

		this.setId(id);
		this.setEpuipment(epuipment);
		this.setDepartment(department);
		this.setSupplierGroup(supplierGroup);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String serialNo;
	private java.util.Date dateOfInstallation;
	private java.util.Date amcWarrentyStartDate;
	private java.util.Date amcWarrentyEndDate;
	private java.lang.String remarks;
	private java.math.BigDecimal costOfAmc;
	private java.lang.String advBillNo;
	private java.util.Date advBillDate;
	private java.lang.Integer advBillAmount;
	private java.lang.String balanceBillNo;
	private java.util.Date balanceBillDate;
	private java.lang.Integer balanceBillAmount;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.Integer preventiveCycle;
	private java.lang.Integer preventiveCompletedCycle;

	// many to one
	private jkt.hms.masters.business.HesEquipmentMaster epuipment;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasStoreSupplierGroup supplierGroup;

	// collections
	private java.util.Set<jkt.hms.masters.business.MmServiceRequest> mmServiceRequests;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="amc_id"
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
	 * Return the value associated with the column: amc_warrenty_start_date
	 */
	public java.util.Date getAmcWarrentyStartDate () {
		return amcWarrentyStartDate;
	}

	/**
	 * Set the value related to the column: amc_warrenty_start_date
	 * @param amcWarrentyStartDate the amc_warrenty_start_date value
	 */
	public void setAmcWarrentyStartDate (java.util.Date amcWarrentyStartDate) {
		this.amcWarrentyStartDate = amcWarrentyStartDate;
	}



	/**
	 * Return the value associated with the column: amc_warrenty_end_date
	 */
	public java.util.Date getAmcWarrentyEndDate () {
		return amcWarrentyEndDate;
	}

	/**
	 * Set the value related to the column: amc_warrenty_end_date
	 * @param amcWarrentyEndDate the amc_warrenty_end_date value
	 */
	public void setAmcWarrentyEndDate (java.util.Date amcWarrentyEndDate) {
		this.amcWarrentyEndDate = amcWarrentyEndDate;
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
	 * Return the value associated with the column: cost_of_amc
	 */
	public java.math.BigDecimal getCostOfAmc () {
		return costOfAmc;
	}

	/**
	 * Set the value related to the column: cost_of_amc
	 * @param costOfAmc the cost_of_amc value
	 */
	public void setCostOfAmc (java.math.BigDecimal costOfAmc) {
		this.costOfAmc = costOfAmc;
	}



	/**
	 * Return the value associated with the column: adv_bill_no
	 */
	public java.lang.String getAdvBillNo () {
		return advBillNo;
	}

	/**
	 * Set the value related to the column: adv_bill_no
	 * @param advBillNo the adv_bill_no value
	 */
	public void setAdvBillNo (java.lang.String advBillNo) {
		this.advBillNo = advBillNo;
	}



	/**
	 * Return the value associated with the column: adv_bill_date
	 */
	public java.util.Date getAdvBillDate () {
		return advBillDate;
	}

	/**
	 * Set the value related to the column: adv_bill_date
	 * @param advBillDate the adv_bill_date value
	 */
	public void setAdvBillDate (java.util.Date advBillDate) {
		this.advBillDate = advBillDate;
	}



	/**
	 * Return the value associated with the column: adv_bill_amount
	 */
	public java.lang.Integer getAdvBillAmount () {
		return advBillAmount;
	}

	/**
	 * Set the value related to the column: adv_bill_amount
	 * @param advBillAmount the adv_bill_amount value
	 */
	public void setAdvBillAmount (java.lang.Integer advBillAmount) {
		this.advBillAmount = advBillAmount;
	}



	/**
	 * Return the value associated with the column: balance_bill_no
	 */
	public java.lang.String getBalanceBillNo () {
		return balanceBillNo;
	}

	/**
	 * Set the value related to the column: balance_bill_no
	 * @param balanceBillNo the balance_bill_no value
	 */
	public void setBalanceBillNo (java.lang.String balanceBillNo) {
		this.balanceBillNo = balanceBillNo;
	}



	/**
	 * Return the value associated with the column: balance_bill_date
	 */
	public java.util.Date getBalanceBillDate () {
		return balanceBillDate;
	}

	/**
	 * Set the value related to the column: balance_bill_date
	 * @param balanceBillDate the balance_bill_date value
	 */
	public void setBalanceBillDate (java.util.Date balanceBillDate) {
		this.balanceBillDate = balanceBillDate;
	}



	/**
	 * Return the value associated with the column: balance_bill_amount
	 */
	public java.lang.Integer getBalanceBillAmount () {
		return balanceBillAmount;
	}

	/**
	 * Set the value related to the column: balance_bill_amount
	 * @param balanceBillAmount the balance_bill_amount value
	 */
	public void setBalanceBillAmount (java.lang.Integer balanceBillAmount) {
		this.balanceBillAmount = balanceBillAmount;
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
	 * Return the value associated with the column: epuipment_id
	 */
	public jkt.hms.masters.business.HesEquipmentMaster getEpuipment () {
		return epuipment;
	}

	/**
	 * Set the value related to the column: epuipment_id
	 * @param epuipment the epuipment_id value
	 */
	public void setEpuipment (jkt.hms.masters.business.HesEquipmentMaster epuipment) {
		this.epuipment = epuipment;
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
	 * Return the value associated with the column: supplier_group_id
	 */
	public jkt.hms.masters.business.MasStoreSupplierGroup getSupplierGroup () {
		return supplierGroup;
	}

	/**
	 * Set the value related to the column: supplier_group_id
	 * @param supplierGroup the supplier_group_id value
	 */
	public void setSupplierGroup (jkt.hms.masters.business.MasStoreSupplierGroup supplierGroup) {
		this.supplierGroup = supplierGroup;
	}



	/**
	 * Return the value associated with the column: MmServiceRequests
	 */
	public java.util.Set<jkt.hms.masters.business.MmServiceRequest> getMmServiceRequests () {
		return mmServiceRequests;
	}

	/**
	 * Set the value related to the column: MmServiceRequests
	 * @param mmServiceRequests the MmServiceRequests value
	 */
	public void setMmServiceRequests (java.util.Set<jkt.hms.masters.business.MmServiceRequest> mmServiceRequests) {
		this.mmServiceRequests = mmServiceRequests;
	}

	public void addToMmServiceRequests (jkt.hms.masters.business.MmServiceRequest mmServiceRequest) {
		if (null == getMmServiceRequests()) setMmServiceRequests(new java.util.TreeSet<jkt.hms.masters.business.MmServiceRequest>());
		getMmServiceRequests().add(mmServiceRequest);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HesEquipmentAmcDetailsEntry)) return false;
		else {
			jkt.hms.masters.business.HesEquipmentAmcDetailsEntry hesEquipmentAmcDetailsEntry = (jkt.hms.masters.business.HesEquipmentAmcDetailsEntry) obj;
			if (null == this.getId() || null == hesEquipmentAmcDetailsEntry.getId()) return false;
			else return (this.getId().equals(hesEquipmentAmcDetailsEntry.getId()));
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
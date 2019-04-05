package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the store_loanin_m table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="store_loanin_m"
 */

public abstract class BaseStoreLoaninM implements Serializable {

	public static String REF = "StoreLoaninM";
	public static String PROP_LOANIN_AMOUNT = "LoaninAmount";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_UNIT = "Unit";
	public static String PROP_ROUND_OFF_VALUE = "RoundOffValue";
	public static String PROP_LOANIN_NO = "LoaninNo";
	public static String PROP_OTHER_CHARGES = "OtherCharges";
	public static String PROP_FREIGHT_DUTY = "FreightDuty";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_GRN_MASTER = "GrnMaster";
	public static String PROP_LOANIN_VALUE = "LoaninValue";
	public static String PROP_LOANIN_DATE = "LoaninDate";
	public static String PROP_PERIOD_FROM = "PeriodFrom";
	public static String PROP_INSURANCE_CHARGE = "InsuranceCharge";
	public static String PROP_CHALLAN_NO = "ChallanNo";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_OCTROI = "Octroi";
	public static String PROP_EXTN_IV_NO = "ExtnIvNo";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_PO = "Po";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_EXCISE_DUTY = "ExciseDuty";
	public static String PROP_STATUS = "Status";
	public static String PROP_SUPPLIER = "Supplier";
	public static String PROP_CUSTOM_DUTY = "CustomDuty";
	public static String PROP_ME_SCALE = "MeScale";
	public static String PROP_ID = "Id";
	public static String PROP_CHALLAN_DATE = "ChallanDate";

	// constructors
	public BaseStoreLoaninM() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreLoaninM(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseStoreLoaninM(java.lang.Integer id,
			jkt.hms.masters.business.MasHospital hospital,
			jkt.hms.masters.business.MasDepartment department,
			jkt.hms.masters.business.MasEmployee employee,
			java.lang.String loaninNo, java.util.Date loaninDate,
			java.lang.String lastChgBy, java.util.Date lastChgDate,
			java.lang.String lastChgTime) {

		this.setId(id);
		this.setHospital(hospital);
		this.setDepartment(department);
		this.setEmployee(employee);
		this.setLoaninNo(loaninNo);
		this.setLoaninDate(loaninDate);
		this.setLastChgBy(lastChgBy);
		this.setLastChgDate(lastChgDate);
		this.setLastChgTime(lastChgTime);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String loaninNo;
	private java.util.Date loaninDate;
	private java.lang.String challanNo;
	private java.util.Date challanDate;
	private java.math.BigDecimal freightDuty;
	private java.math.BigDecimal exciseDuty;
	private java.math.BigDecimal octroi;
	private java.math.BigDecimal customDuty;
	private java.math.BigDecimal insuranceCharge;
	private java.math.BigDecimal otherCharges;
	private java.math.BigDecimal loaninValue;
	private java.math.BigDecimal roundOffValue;
	private java.math.BigDecimal loaninAmount;
	private java.lang.String status;
	private java.lang.String remarks;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String extnIvNo;
	private java.lang.String periodFrom;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.StoreGrnM grnMaster;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasStoreSupplier supplier;
	private jkt.hms.masters.business.MasStoreMeScale meScale;
	private jkt.hms.masters.business.StorePoHeader po;
	private jkt.hms.masters.business.MasEmployee employee;
	private jkt.hms.masters.business.MasStoreAirForceDepot unit;

	// collections
	private java.util.Set<jkt.hms.masters.business.StoreLoaninT> storeLoaninTs;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="loanin_master_id"
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
	 * Return the value associated with the column: loanin_no
	 */
	public java.lang.String getLoaninNo() {
		return loaninNo;
	}

	/**
	 * Set the value related to the column: loanin_no
	 * 
	 * @param loaninNo
	 *            the loanin_no value
	 */
	public void setLoaninNo(java.lang.String loaninNo) {
		this.loaninNo = loaninNo;
	}

	/**
	 * Return the value associated with the column: loanin_date
	 */
	public java.util.Date getLoaninDate() {
		return loaninDate;
	}

	/**
	 * Set the value related to the column: loanin_date
	 * 
	 * @param loaninDate
	 *            the loanin_date value
	 */
	public void setLoaninDate(java.util.Date loaninDate) {
		this.loaninDate = loaninDate;
	}

	/**
	 * Return the value associated with the column: challan_no
	 */
	public java.lang.String getChallanNo() {
		return challanNo;
	}

	/**
	 * Set the value related to the column: challan_no
	 * 
	 * @param challanNo
	 *            the challan_no value
	 */
	public void setChallanNo(java.lang.String challanNo) {
		this.challanNo = challanNo;
	}

	/**
	 * Return the value associated with the column: challan_date
	 */
	public java.util.Date getChallanDate() {
		return challanDate;
	}

	/**
	 * Set the value related to the column: challan_date
	 * 
	 * @param challanDate
	 *            the challan_date value
	 */
	public void setChallanDate(java.util.Date challanDate) {
		this.challanDate = challanDate;
	}

	/**
	 * Return the value associated with the column: freight_duty
	 */
	public java.math.BigDecimal getFreightDuty() {
		return freightDuty;
	}

	/**
	 * Set the value related to the column: freight_duty
	 * 
	 * @param freightDuty
	 *            the freight_duty value
	 */
	public void setFreightDuty(java.math.BigDecimal freightDuty) {
		this.freightDuty = freightDuty;
	}

	/**
	 * Return the value associated with the column: excise_duty
	 */
	public java.math.BigDecimal getExciseDuty() {
		return exciseDuty;
	}

	/**
	 * Set the value related to the column: excise_duty
	 * 
	 * @param exciseDuty
	 *            the excise_duty value
	 */
	public void setExciseDuty(java.math.BigDecimal exciseDuty) {
		this.exciseDuty = exciseDuty;
	}

	/**
	 * Return the value associated with the column: octroi
	 */
	public java.math.BigDecimal getOctroi() {
		return octroi;
	}

	/**
	 * Set the value related to the column: octroi
	 * 
	 * @param octroi
	 *            the octroi value
	 */
	public void setOctroi(java.math.BigDecimal octroi) {
		this.octroi = octroi;
	}

	/**
	 * Return the value associated with the column: custom_duty
	 */
	public java.math.BigDecimal getCustomDuty() {
		return customDuty;
	}

	/**
	 * Set the value related to the column: custom_duty
	 * 
	 * @param customDuty
	 *            the custom_duty value
	 */
	public void setCustomDuty(java.math.BigDecimal customDuty) {
		this.customDuty = customDuty;
	}

	/**
	 * Return the value associated with the column: insurance_charge
	 */
	public java.math.BigDecimal getInsuranceCharge() {
		return insuranceCharge;
	}

	/**
	 * Set the value related to the column: insurance_charge
	 * 
	 * @param insuranceCharge
	 *            the insurance_charge value
	 */
	public void setInsuranceCharge(java.math.BigDecimal insuranceCharge) {
		this.insuranceCharge = insuranceCharge;
	}

	/**
	 * Return the value associated with the column: other_charges
	 */
	public java.math.BigDecimal getOtherCharges() {
		return otherCharges;
	}

	/**
	 * Set the value related to the column: other_charges
	 * 
	 * @param otherCharges
	 *            the other_charges value
	 */
	public void setOtherCharges(java.math.BigDecimal otherCharges) {
		this.otherCharges = otherCharges;
	}

	/**
	 * Return the value associated with the column: loanin_value
	 */
	public java.math.BigDecimal getLoaninValue() {
		return loaninValue;
	}

	/**
	 * Set the value related to the column: loanin_value
	 * 
	 * @param loaninValue
	 *            the loanin_value value
	 */
	public void setLoaninValue(java.math.BigDecimal loaninValue) {
		this.loaninValue = loaninValue;
	}

	/**
	 * Return the value associated with the column: round_off_value
	 */
	public java.math.BigDecimal getRoundOffValue() {
		return roundOffValue;
	}

	/**
	 * Set the value related to the column: round_off_value
	 * 
	 * @param roundOffValue
	 *            the round_off_value value
	 */
	public void setRoundOffValue(java.math.BigDecimal roundOffValue) {
		this.roundOffValue = roundOffValue;
	}

	/**
	 * Return the value associated with the column: loanin_amount
	 */
	public java.math.BigDecimal getLoaninAmount() {
		return loaninAmount;
	}

	/**
	 * Set the value related to the column: loanin_amount
	 * 
	 * @param loaninAmount
	 *            the loanin_amount value
	 */
	public void setLoaninAmount(java.math.BigDecimal loaninAmount) {
		this.loaninAmount = loaninAmount;
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
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks() {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * 
	 * @param remarks
	 *            the remarks value
	 */
	public void setRemarks(java.lang.String remarks) {
		this.remarks = remarks;
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
	 * Return the value associated with the column: extn_IV_no
	 */
	public java.lang.String getExtnIvNo() {
		return extnIvNo;
	}

	/**
	 * Set the value related to the column: extn_IV_no
	 * 
	 * @param extnIvNo
	 *            the extn_IV_no value
	 */
	public void setExtnIvNo(java.lang.String extnIvNo) {
		this.extnIvNo = extnIvNo;
	}

	/**
	 * Return the value associated with the column: period_from
	 */
	public java.lang.String getPeriodFrom() {
		return periodFrom;
	}

	/**
	 * Set the value related to the column: period_from
	 * 
	 * @param periodFrom
	 *            the period_from value
	 */
	public void setPeriodFrom(java.lang.String periodFrom) {
		this.periodFrom = periodFrom;
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
	 * Return the value associated with the column: grn_master_id
	 */
	public jkt.hms.masters.business.StoreGrnM getGrnMaster() {
		return grnMaster;
	}

	/**
	 * Set the value related to the column: grn_master_id
	 * 
	 * @param grnMaster
	 *            the grn_master_id value
	 */
	public void setGrnMaster(jkt.hms.masters.business.StoreGrnM grnMaster) {
		this.grnMaster = grnMaster;
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
	 * Return the value associated with the column: supplier_id
	 */
	public jkt.hms.masters.business.MasStoreSupplier getSupplier() {
		return supplier;
	}

	/**
	 * Set the value related to the column: supplier_id
	 * 
	 * @param supplier
	 *            the supplier_id value
	 */
	public void setSupplier(jkt.hms.masters.business.MasStoreSupplier supplier) {
		this.supplier = supplier;
	}

	/**
	 * Return the value associated with the column: me_scale_id
	 */
	public jkt.hms.masters.business.MasStoreMeScale getMeScale() {
		return meScale;
	}

	/**
	 * Set the value related to the column: me_scale_id
	 * 
	 * @param meScale
	 *            the me_scale_id value
	 */
	public void setMeScale(jkt.hms.masters.business.MasStoreMeScale meScale) {
		this.meScale = meScale;
	}

	/**
	 * Return the value associated with the column: po_id
	 */
	public jkt.hms.masters.business.StorePoHeader getPo() {
		return po;
	}

	/**
	 * Set the value related to the column: po_id
	 * 
	 * @param po
	 *            the po_id value
	 */
	public void setPo(jkt.hms.masters.business.StorePoHeader po) {
		this.po = po;
	}

	/**
	 * Return the value associated with the column: employee_id
	 */
	public jkt.hms.masters.business.MasEmployee getEmployee() {
		return employee;
	}

	/**
	 * Set the value related to the column: employee_id
	 * 
	 * @param employee
	 *            the employee_id value
	 */
	public void setEmployee(jkt.hms.masters.business.MasEmployee employee) {
		this.employee = employee;
	}

	/**
	 * Return the value associated with the column: unit_id
	 */
	public jkt.hms.masters.business.MasStoreAirForceDepot getUnit() {
		return unit;
	}

	/**
	 * Set the value related to the column: unit_id
	 * 
	 * @param unit
	 *            the unit_id value
	 */
	public void setUnit(jkt.hms.masters.business.MasStoreAirForceDepot unit) {
		this.unit = unit;
	}

	/**
	 * Return the value associated with the column: StoreLoaninTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreLoaninT> getStoreLoaninTs() {
		return storeLoaninTs;
	}

	/**
	 * Set the value related to the column: StoreLoaninTs
	 * 
	 * @param storeLoaninTs
	 *            the StoreLoaninTs value
	 */
	public void setStoreLoaninTs(
			java.util.Set<jkt.hms.masters.business.StoreLoaninT> storeLoaninTs) {
		this.storeLoaninTs = storeLoaninTs;
	}

	public void addToStoreLoaninTs(
			jkt.hms.masters.business.StoreLoaninT storeLoaninT) {
		if (null == getStoreLoaninTs())
			setStoreLoaninTs(new java.util.TreeSet<jkt.hms.masters.business.StoreLoaninT>());
		getStoreLoaninTs().add(storeLoaninT);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreLoaninM))
			return false;
		else {
			jkt.hms.masters.business.StoreLoaninM storeLoaninM = (jkt.hms.masters.business.StoreLoaninM) obj;
			if (null == this.getId() || null == storeLoaninM.getId())
				return false;
			else
				return (this.getId().equals(storeLoaninM.getId()));
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
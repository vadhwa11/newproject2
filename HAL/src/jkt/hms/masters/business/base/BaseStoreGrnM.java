package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the store_grn_m table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="store_grn_m"
 */

public abstract class BaseStoreGrnM  implements Serializable {

	public static String REF = "StoreGrnM";
	public static String PROP_GRN_START_NO = "GrnStartNo";
	public static String PROP_DATE_RECEIVED_SURPLUS = "DateReceivedSurplus";
	public static String PROP_ENTERED_BY = "EnteredBy";
	public static String PROP_INVOICE_DATE = "InvoiceDate";
	public static String PROP_INSPECTED_DATE = "InspectedDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_APPROVAL_DATE = "ApprovalDate";
	public static String PROP_ROUND_OFF_VALUE = "RoundOffValue";
	public static String PROP_CIV_NO = "CivNo";
	public static String PROP_HOW_RECEIVED = "HowReceived";
	public static String PROP_DISCOUNT = "Discount";
	public static String PROP_CHALLAN_NO = "ChallanNo";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DISCREPANCY_ADVISE_NO = "DiscrepancyAdviseNo";
	public static String PROP_CIV_DATE = "CivDate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_PO = "Po";
	public static String PROP_TECHNICAL_SPECIFICATION = "TechnicalSpecification";
	public static String PROP_RR_NO = "RrNo";
	public static String PROP_INVOICE_AMOUNT = "InvoiceAmount";
	public static String PROP_CUSTOM_DUTY = "CustomDuty";
	public static String PROP_TECHNICAL_DETAILS = "TechnicalDetails";
	public static String PROP_ME_SCALE = "MeScale";
	public static String PROP_ID = "Id";
	public static String PROP_GRN_DATE = "GrnDate";
	public static String PROP_GRN_NO = "GrnNo";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_TOTAL_COST = "TotalCost";
	public static String PROP_APPROVED_BY = "ApprovedBy";
	public static String PROP_AT_SO_NO = "AtSoNo";
	public static String PROP_UNIT = "Unit";
	public static String PROP_CRV_COMITTED_AMOUNT = "CrvComittedAmount";
	public static String PROP_OTHER_CHARGES = "OtherCharges";
	public static String PROP_YEAR = "Year";
	public static String PROP_FREIGHT_DUTY = "FreightDuty";
	public static String PROP_GRN_STATUS = "GrnStatus";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_INVOICE_NO = "InvoiceNo";
	public static String PROP_OTHER_UNIT = "OtherUnit";
	public static String PROP_AMC_CONTRACT = "AmcContract";
	public static String PROP_INSURANCE_CHARGE = "InsuranceCharge";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_GRN_AMOUNT = "GrnAmount";
	public static String PROP_ALLOTTED_AMOUNT = "AllottedAmount";
	public static String PROP_RC = "Rc";
	public static String PROP_OCTROI = "Octroi";
	public static String PROP_PROFORMA_DATE = "ProformaDate";
	public static String PROP_GRN_VALUE = "GrnValue";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_PROFORMA_NO = "ProformaNo";
	public static String PROP_EXCISE_DUTY = "ExciseDuty";
	public static String PROP_RECEIVE_TYPE = "ReceiveType";
	public static String PROP_INSPECTED_BY = "InspectedBy";
	public static String PROP_STATUS = "Status";
	public static String PROP_VAT = "Vat";
	public static String PROP_SUPPLIER = "Supplier";
	public static String PROP_MODE_OF_CONVEYANCE = "ModeOfConveyance";
	public static String PROP_INDENT = "Indent";
	public static String PROP_CHALLAN_DATE = "ChallanDate";


	// constructors
	public BaseStoreGrnM () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreGrnM (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseStoreGrnM (
		java.lang.Integer id,
		jkt.hms.masters.business.MasDepartment department,
		jkt.hms.masters.business.MasHospital hospital,
		java.lang.String receiveType,
		java.util.Date grnDate,
		java.lang.String status,
		java.util.Date lastChgDate,
		java.lang.String lastChgTime) {

		this.setId(id);
		this.setDepartment(department);
		this.setHospital(hospital);
		this.setReceiveType(receiveType);
		this.setGrnDate(grnDate);
		this.setStatus(status);
		this.setLastChgDate(lastChgDate);
		this.setLastChgTime(lastChgTime);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String grnNo;
	private java.lang.String receiveType;
	private java.util.Date grnDate;
	private java.lang.String howReceived;
	private java.lang.String challanNo;
	private java.util.Date challanDate;
	private java.util.Date dateReceivedSurplus;
	private java.lang.String rrNo;
	private java.lang.String modeOfConveyance;
	private java.lang.String invoiceNo;
	private java.util.Date invoiceDate;
	private java.math.BigDecimal invoiceAmount;
	private java.math.BigDecimal freightDuty;
	private java.math.BigDecimal exciseDuty;
	private java.math.BigDecimal octroi;
	private java.math.BigDecimal customDuty;
	private java.math.BigDecimal insuranceCharge;
	private java.math.BigDecimal otherCharges;
	private java.math.BigDecimal grnValue;
	private java.math.BigDecimal roundOffValue;
	private java.lang.String atSoNo;
	private java.math.BigDecimal grnAmount;
	private java.lang.String status;
	private java.lang.String remarks;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String technicalDetails;
	private java.lang.String technicalSpecification;
	private java.lang.String amcContract;
	private java.math.BigDecimal vat;
	private java.math.BigDecimal discount;
	private java.lang.String grnStartNo;
	private java.math.BigDecimal crvComittedAmount;
	private java.math.BigDecimal allottedAmount;
	private java.lang.String civNo;
	private java.util.Date civDate;
	private java.math.BigDecimal totalCost;
	private java.lang.String proformaNo;
	private java.util.Date proformaDate;
	private java.lang.String grnStatus;
	private java.util.Date inspectedDate;
	private java.util.Date approvalDate;
	private java.lang.String discrepancyAdviseNo;

	// many to one
	private jkt.hms.masters.business.MasStoreMeScale meScale;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasStoreSupplier supplier;
	private jkt.hms.masters.business.MasStoreFinancial year;
	private jkt.hms.masters.business.StorePoHeader po;
	private jkt.hms.masters.business.Users inspectedBy;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.Users enteredBy;
	private jkt.hms.masters.business.MasStoreAirForceDepot unit;
	private jkt.hms.masters.business.RcHeader rc;
	private jkt.hms.masters.business.Users approvedBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.StoreIndentM indent;
	private jkt.hms.masters.business.MasEmployee employee;
	private jkt.hms.masters.business.MasUnit otherUnit;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="grn_master_id"
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
	 * Return the value associated with the column: grn_no
	 */
	public java.lang.String getGrnNo () {
		return grnNo;
	}

	/**
	 * Set the value related to the column: grn_no
	 * @param grnNo the grn_no value
	 */
	public void setGrnNo (java.lang.String grnNo) {
		this.grnNo = grnNo;
	}



	/**
	 * Return the value associated with the column: receive_type
	 */
	public java.lang.String getReceiveType () {
		return receiveType;
	}

	/**
	 * Set the value related to the column: receive_type
	 * @param receiveType the receive_type value
	 */
	public void setReceiveType (java.lang.String receiveType) {
		this.receiveType = receiveType;
	}



	/**
	 * Return the value associated with the column: grn_date
	 */
	public java.util.Date getGrnDate () {
		return grnDate;
	}

	/**
	 * Set the value related to the column: grn_date
	 * @param grnDate the grn_date value
	 */
	public void setGrnDate (java.util.Date grnDate) {
		this.grnDate = grnDate;
	}



	/**
	 * Return the value associated with the column: how_received
	 */
	public java.lang.String getHowReceived () {
		return howReceived;
	}

	/**
	 * Set the value related to the column: how_received
	 * @param howReceived the how_received value
	 */
	public void setHowReceived (java.lang.String howReceived) {
		this.howReceived = howReceived;
	}



	/**
	 * Return the value associated with the column: challan_no
	 */
	public java.lang.String getChallanNo () {
		return challanNo;
	}

	/**
	 * Set the value related to the column: challan_no
	 * @param challanNo the challan_no value
	 */
	public void setChallanNo (java.lang.String challanNo) {
		this.challanNo = challanNo;
	}



	/**
	 * Return the value associated with the column: challan_date
	 */
	public java.util.Date getChallanDate () {
		return challanDate;
	}

	/**
	 * Set the value related to the column: challan_date
	 * @param challanDate the challan_date value
	 */
	public void setChallanDate (java.util.Date challanDate) {
		this.challanDate = challanDate;
	}



	/**
	 * Return the value associated with the column: date_received_surplus
	 */
	public java.util.Date getDateReceivedSurplus () {
		return dateReceivedSurplus;
	}

	/**
	 * Set the value related to the column: date_received_surplus
	 * @param dateReceivedSurplus the date_received_surplus value
	 */
	public void setDateReceivedSurplus (java.util.Date dateReceivedSurplus) {
		this.dateReceivedSurplus = dateReceivedSurplus;
	}



	/**
	 * Return the value associated with the column: rr_no
	 */
	public java.lang.String getRrNo () {
		return rrNo;
	}

	/**
	 * Set the value related to the column: rr_no
	 * @param rrNo the rr_no value
	 */
	public void setRrNo (java.lang.String rrNo) {
		this.rrNo = rrNo;
	}



	/**
	 * Return the value associated with the column: mode_of_conveyance
	 */
	public java.lang.String getModeOfConveyance () {
		return modeOfConveyance;
	}

	/**
	 * Set the value related to the column: mode_of_conveyance
	 * @param modeOfConveyance the mode_of_conveyance value
	 */
	public void setModeOfConveyance (java.lang.String modeOfConveyance) {
		this.modeOfConveyance = modeOfConveyance;
	}



	/**
	 * Return the value associated with the column: invoice_no
	 */
	public java.lang.String getInvoiceNo () {
		return invoiceNo;
	}

	/**
	 * Set the value related to the column: invoice_no
	 * @param invoiceNo the invoice_no value
	 */
	public void setInvoiceNo (java.lang.String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}



	/**
	 * Return the value associated with the column: invoice_date
	 */
	public java.util.Date getInvoiceDate () {
		return invoiceDate;
	}

	/**
	 * Set the value related to the column: invoice_date
	 * @param invoiceDate the invoice_date value
	 */
	public void setInvoiceDate (java.util.Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}



	/**
	 * Return the value associated with the column: invoice_amount
	 */
	public java.math.BigDecimal getInvoiceAmount () {
		return invoiceAmount;
	}

	/**
	 * Set the value related to the column: invoice_amount
	 * @param invoiceAmount the invoice_amount value
	 */
	public void setInvoiceAmount (java.math.BigDecimal invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}



	/**
	 * Return the value associated with the column: freight_duty
	 */
	public java.math.BigDecimal getFreightDuty () {
		return freightDuty;
	}

	/**
	 * Set the value related to the column: freight_duty
	 * @param freightDuty the freight_duty value
	 */
	public void setFreightDuty (java.math.BigDecimal freightDuty) {
		this.freightDuty = freightDuty;
	}



	/**
	 * Return the value associated with the column: excise_duty
	 */
	public java.math.BigDecimal getExciseDuty () {
		return exciseDuty;
	}

	/**
	 * Set the value related to the column: excise_duty
	 * @param exciseDuty the excise_duty value
	 */
	public void setExciseDuty (java.math.BigDecimal exciseDuty) {
		this.exciseDuty = exciseDuty;
	}



	/**
	 * Return the value associated with the column: octroi
	 */
	public java.math.BigDecimal getOctroi () {
		return octroi;
	}

	/**
	 * Set the value related to the column: octroi
	 * @param octroi the octroi value
	 */
	public void setOctroi (java.math.BigDecimal octroi) {
		this.octroi = octroi;
	}



	/**
	 * Return the value associated with the column: custom_duty
	 */
	public java.math.BigDecimal getCustomDuty () {
		return customDuty;
	}

	/**
	 * Set the value related to the column: custom_duty
	 * @param customDuty the custom_duty value
	 */
	public void setCustomDuty (java.math.BigDecimal customDuty) {
		this.customDuty = customDuty;
	}



	/**
	 * Return the value associated with the column: insurance_charge
	 */
	public java.math.BigDecimal getInsuranceCharge () {
		return insuranceCharge;
	}

	/**
	 * Set the value related to the column: insurance_charge
	 * @param insuranceCharge the insurance_charge value
	 */
	public void setInsuranceCharge (java.math.BigDecimal insuranceCharge) {
		this.insuranceCharge = insuranceCharge;
	}



	/**
	 * Return the value associated with the column: other_charges
	 */
	public java.math.BigDecimal getOtherCharges () {
		return otherCharges;
	}

	/**
	 * Set the value related to the column: other_charges
	 * @param otherCharges the other_charges value
	 */
	public void setOtherCharges (java.math.BigDecimal otherCharges) {
		this.otherCharges = otherCharges;
	}



	/**
	 * Return the value associated with the column: grn_value
	 */
	public java.math.BigDecimal getGrnValue () {
		return grnValue;
	}

	/**
	 * Set the value related to the column: grn_value
	 * @param grnValue the grn_value value
	 */
	public void setGrnValue (java.math.BigDecimal grnValue) {
		this.grnValue = grnValue;
	}



	/**
	 * Return the value associated with the column: round_off_value
	 */
	public java.math.BigDecimal getRoundOffValue () {
		return roundOffValue;
	}

	/**
	 * Set the value related to the column: round_off_value
	 * @param roundOffValue the round_off_value value
	 */
	public void setRoundOffValue (java.math.BigDecimal roundOffValue) {
		this.roundOffValue = roundOffValue;
	}



	/**
	 * Return the value associated with the column: at_so_no
	 */
	public java.lang.String getAtSoNo () {
		return atSoNo;
	}

	/**
	 * Set the value related to the column: at_so_no
	 * @param atSoNo the at_so_no value
	 */
	public void setAtSoNo (java.lang.String atSoNo) {
		this.atSoNo = atSoNo;
	}



	/**
	 * Return the value associated with the column: grn_amount
	 */
	public java.math.BigDecimal getGrnAmount () {
		return grnAmount;
	}

	/**
	 * Set the value related to the column: grn_amount
	 * @param grnAmount the grn_amount value
	 */
	public void setGrnAmount (java.math.BigDecimal grnAmount) {
		this.grnAmount = grnAmount;
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
	 * Return the value associated with the column: technical_details
	 */
	public java.lang.String getTechnicalDetails () {
		return technicalDetails;
	}

	/**
	 * Set the value related to the column: technical_details
	 * @param technicalDetails the technical_details value
	 */
	public void setTechnicalDetails (java.lang.String technicalDetails) {
		this.technicalDetails = technicalDetails;
	}



	/**
	 * Return the value associated with the column: technical_specification
	 */
	public java.lang.String getTechnicalSpecification () {
		return technicalSpecification;
	}

	/**
	 * Set the value related to the column: technical_specification
	 * @param technicalSpecification the technical_specification value
	 */
	public void setTechnicalSpecification (java.lang.String technicalSpecification) {
		this.technicalSpecification = technicalSpecification;
	}



	/**
	 * Return the value associated with the column: amc_contract
	 */
	public java.lang.String getAmcContract () {
		return amcContract;
	}

	/**
	 * Set the value related to the column: amc_contract
	 * @param amcContract the amc_contract value
	 */
	public void setAmcContract (java.lang.String amcContract) {
		this.amcContract = amcContract;
	}



	/**
	 * Return the value associated with the column: vat
	 */
	public java.math.BigDecimal getVat () {
		return vat;
	}

	/**
	 * Set the value related to the column: vat
	 * @param vat the vat value
	 */
	public void setVat (java.math.BigDecimal vat) {
		this.vat = vat;
	}



	/**
	 * Return the value associated with the column: discount
	 */
	public java.math.BigDecimal getDiscount () {
		return discount;
	}

	/**
	 * Set the value related to the column: discount
	 * @param discount the discount value
	 */
	public void setDiscount (java.math.BigDecimal discount) {
		this.discount = discount;
	}



	/**
	 * Return the value associated with the column: grn_start_no
	 */
	public java.lang.String getGrnStartNo () {
		return grnStartNo;
	}

	/**
	 * Set the value related to the column: grn_start_no
	 * @param grnStartNo the grn_start_no value
	 */
	public void setGrnStartNo (java.lang.String grnStartNo) {
		this.grnStartNo = grnStartNo;
	}



	/**
	 * Return the value associated with the column: crv_comitted_amount
	 */
	public java.math.BigDecimal getCrvComittedAmount () {
		return crvComittedAmount;
	}

	/**
	 * Set the value related to the column: crv_comitted_amount
	 * @param crvComittedAmount the crv_comitted_amount value
	 */
	public void setCrvComittedAmount (java.math.BigDecimal crvComittedAmount) {
		this.crvComittedAmount = crvComittedAmount;
	}



	/**
	 * Return the value associated with the column: allotted_amount
	 */
	public java.math.BigDecimal getAllottedAmount () {
		return allottedAmount;
	}

	/**
	 * Set the value related to the column: allotted_amount
	 * @param allottedAmount the allotted_amount value
	 */
	public void setAllottedAmount (java.math.BigDecimal allottedAmount) {
		this.allottedAmount = allottedAmount;
	}



	/**
	 * Return the value associated with the column: civ_no
	 */
	public java.lang.String getCivNo () {
		return civNo;
	}

	/**
	 * Set the value related to the column: civ_no
	 * @param civNo the civ_no value
	 */
	public void setCivNo (java.lang.String civNo) {
		this.civNo = civNo;
	}



	/**
	 * Return the value associated with the column: civ_date
	 */
	public java.util.Date getCivDate () {
		return civDate;
	}

	/**
	 * Set the value related to the column: civ_date
	 * @param civDate the civ_date value
	 */
	public void setCivDate (java.util.Date civDate) {
		this.civDate = civDate;
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
	 * Return the value associated with the column: ProformaNo
	 */
	public java.lang.String getProformaNo () {
		return proformaNo;
	}

	/**
	 * Set the value related to the column: ProformaNo
	 * @param proformaNo the ProformaNo value
	 */
	public void setProformaNo (java.lang.String proformaNo) {
		this.proformaNo = proformaNo;
	}



	/**
	 * Return the value associated with the column: ProformaDate
	 */
	public java.util.Date getProformaDate () {
		return proformaDate;
	}

	/**
	 * Set the value related to the column: ProformaDate
	 * @param proformaDate the ProformaDate value
	 */
	public void setProformaDate (java.util.Date proformaDate) {
		this.proformaDate = proformaDate;
	}



	/**
	 * Return the value associated with the column: grn_status
	 */
	public java.lang.String getGrnStatus () {
		return grnStatus;
	}

	/**
	 * Set the value related to the column: grn_status
	 * @param grnStatus the grn_status value
	 */
	public void setGrnStatus (java.lang.String grnStatus) {
		this.grnStatus = grnStatus;
	}



	/**
	 * Return the value associated with the column: inspected_date
	 */
	public java.util.Date getInspectedDate () {
		return inspectedDate;
	}

	/**
	 * Set the value related to the column: inspected_date
	 * @param inspectedDate the inspected_date value
	 */
	public void setInspectedDate (java.util.Date inspectedDate) {
		this.inspectedDate = inspectedDate;
	}



	/**
	 * Return the value associated with the column: approval_date
	 */
	public java.util.Date getApprovalDate () {
		return approvalDate;
	}

	/**
	 * Set the value related to the column: approval_date
	 * @param approvalDate the approval_date value
	 */
	public void setApprovalDate (java.util.Date approvalDate) {
		this.approvalDate = approvalDate;
	}



	/**
	 * Return the value associated with the column: discrepancy_advise_no
	 */
	public java.lang.String getDiscrepancyAdviseNo () {
		return discrepancyAdviseNo;
	}

	/**
	 * Set the value related to the column: discrepancy_advise_no
	 * @param discrepancyAdviseNo the discrepancy_advise_no value
	 */
	public void setDiscrepancyAdviseNo (java.lang.String discrepancyAdviseNo) {
		this.discrepancyAdviseNo = discrepancyAdviseNo;
	}



	/**
	 * Return the value associated with the column: me_scale_id
	 */
	public jkt.hms.masters.business.MasStoreMeScale getMeScale () {
		return meScale;
	}

	/**
	 * Set the value related to the column: me_scale_id
	 * @param meScale the me_scale_id value
	 */
	public void setMeScale (jkt.hms.masters.business.MasStoreMeScale meScale) {
		this.meScale = meScale;
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
	 * Return the value associated with the column: year_id
	 */
	public jkt.hms.masters.business.MasStoreFinancial getYear () {
		return year;
	}

	/**
	 * Set the value related to the column: year_id
	 * @param year the year_id value
	 */
	public void setYear (jkt.hms.masters.business.MasStoreFinancial year) {
		this.year = year;
	}



	/**
	 * Return the value associated with the column: po_id
	 */
	public jkt.hms.masters.business.StorePoHeader getPo () {
		return po;
	}

	/**
	 * Set the value related to the column: po_id
	 * @param po the po_id value
	 */
	public void setPo (jkt.hms.masters.business.StorePoHeader po) {
		this.po = po;
	}



	/**
	 * Return the value associated with the column: inspected_by
	 */
	public jkt.hms.masters.business.Users getInspectedBy () {
		return inspectedBy;
	}

	/**
	 * Set the value related to the column: inspected_by
	 * @param inspectedBy the inspected_by value
	 */
	public void setInspectedBy (jkt.hms.masters.business.Users inspectedBy) {
		this.inspectedBy = inspectedBy;
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
	 * Return the value associated with the column: entered_by
	 */
	public jkt.hms.masters.business.Users getEnteredBy () {
		return enteredBy;
	}

	/**
	 * Set the value related to the column: entered_by
	 * @param enteredBy the entered_by value
	 */
	public void setEnteredBy (jkt.hms.masters.business.Users enteredBy) {
		this.enteredBy = enteredBy;
	}



	/**
	 * Return the value associated with the column: unit_id
	 */
	public jkt.hms.masters.business.MasStoreAirForceDepot getUnit () {
		return unit;
	}

	/**
	 * Set the value related to the column: unit_id
	 * @param unit the unit_id value
	 */
	public void setUnit (jkt.hms.masters.business.MasStoreAirForceDepot unit) {
		this.unit = unit;
	}



	/**
	 * Return the value associated with the column: rc_id
	 */
	public jkt.hms.masters.business.RcHeader getRc () {
		return rc;
	}

	/**
	 * Set the value related to the column: rc_id
	 * @param rc the rc_id value
	 */
	public void setRc (jkt.hms.masters.business.RcHeader rc) {
		this.rc = rc;
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
	 * Return the value associated with the column: indent_id
	 */
	public jkt.hms.masters.business.StoreIndentM getIndent () {
		return indent;
	}

	/**
	 * Set the value related to the column: indent_id
	 * @param indent the indent_id value
	 */
	public void setIndent (jkt.hms.masters.business.StoreIndentM indent) {
		this.indent = indent;
	}



	/**
	 * Return the value associated with the column: employee_id
	 */
	public jkt.hms.masters.business.MasEmployee getEmployee () {
		return employee;
	}

	/**
	 * Set the value related to the column: employee_id
	 * @param employee the employee_id value
	 */
	public void setEmployee (jkt.hms.masters.business.MasEmployee employee) {
		this.employee = employee;
	}



	/**
	 * Return the value associated with the column: other_unit
	 */
	public jkt.hms.masters.business.MasUnit getOtherUnit () {
		return otherUnit;
	}

	/**
	 * Set the value related to the column: other_unit
	 * @param otherUnit the other_unit value
	 */
	public void setOtherUnit (jkt.hms.masters.business.MasUnit otherUnit) {
		this.otherUnit = otherUnit;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreGrnM)) return false;
		else {
			jkt.hms.masters.business.StoreGrnM storeGrnM = (jkt.hms.masters.business.StoreGrnM) obj;
			if (null == this.getId() || null == storeGrnM.getId()) return false;
			else return (this.getId().equals(storeGrnM.getId()));
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
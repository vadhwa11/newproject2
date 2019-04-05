package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the store_fy_document_no table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="store_fy_document_no"
 */

public abstract class BaseStoreFyDocumentNo  implements Serializable {

	public static String REF = "StoreFyDocumentNo";
	public static String PROP_MEDICINE_RETURN_NO = "MedicineReturnNo";
	public static String PROP_GRN_START_NO = "GrnStartNo";
	public static String PROP_DEMAND_START_NO = "DemandStartNo";
	public static String PROP_DEFECT_ENTRY_NO = "DefectEntryNo";
	public static String PROP_MMF_NO = "MmfNo";
	public static String PROP_IN_INDENT_NO = "InIndentNo";
	public static String PROP_DISPOSAL_ENTRY_NO = "DisposalEntryNo";
	public static String PROP_ISSUE_OTHER_UNITS_NO = "IssueOtherUnitsNo";
	public static String PROP_LOANIN_NO = "LoaninNo";
	public static String PROP_ADJUSTMENT_START_NO = "AdjustmentStartNo";
	public static String PROP_ISSUE_IN_PATIENT_RETURN_START_NO = "IssueInPatientReturnStartNo";
	public static String PROP_PO_NO = "PoNo";
	public static String PROP_MMF_START_NO = "MmfStartNo";
	public static String PROP_DEPT_CONSUM_NO = "DeptConsumNo";
	public static String PROP_SOC_INDENT_START_NO = "SocIndentStartNo";
	public static String PROP_LOANIN_START_NO = "LoaninStartNo";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_IN_INDENT_START_NO = "InIndentStartNo";
	public static String PROP_ISSUE_WARD_NO = "IssueWardNo";
	public static String PROP_ISSUE_DEPT_START_NO = "IssueDeptStartNo";
	public static String PROP_MMF_INDENT_START_NO = "MmfIndentStartNo";
	public static String PROP_ISSUE_LOANOUT_NO = "IssueLoanoutNo";
	public static String PROP_QUOTATION_REC_NO = "QuotationRecNo";
	public static String PROP_BALANCE_NO = "BalanceNo";
	public static String PROP_ISSUE_OTAFU_START_NO = "IssueOtafuStartNo";
	public static String PROP_DEMAND_NO = "DemandNo";
	public static String PROP_PATIENT_RETURN_NO = "PatientReturnNo";
	public static String PROP_ID = "Id";
	public static String PROP_BOO_START_NO = "BooStartNo";
	public static String PROP_M_P_R_NO = "MPRNo";
	public static String PROP_WARD_RETURN_NO = "WardReturnNo";
	public static String PROP_PROFORMA_B_ENTRY_NO = "ProformaBEntryNo";
	public static String PROP_GRN_NO = "GrnNo";
	public static String PROP_VENDOR_RETURN_START_NO = "VendorReturnStartNo";
	public static String PROP_ISUUE_LOANOUT_START_NO = "IsuueLoanoutStartNo";
	public static String PROP_OPD_RETURN_NO = "OpdReturnNo";
	public static String PROP_ISSUE_OTHER_UNITS_START_NO = "IssueOtherUnitsStartNo";
	public static String PROP_VENDOR_RETURN_NO = "VendorReturnNo";
	public static String PROP_DEFECT_ENTRY_START_NO = "DefectEntryStartNo";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_INDENT_TO_SOC_START_NO = "IndentToSocStartNo";
	public static String PROP_BOO_NO = "BooNo";
	public static String PROP_TENDER_NO = "TenderNo";
	public static String PROP_ISSUE_IN_PATIENT_START_NO = "IssueInPatientStartNo";
	public static String PROP_ISSUE_IN_PATIENT_NO = "IssueInPatientNo";
	public static String PROP_MMF_INDENT_NO = "MmfIndentNo";
	public static String PROP_PO_START_NO = "PoStartNo";
	public static String PROP_SOC_INDENT_NO = "SocIndentNo";
	public static String PROP_ISSUE_OTAFU_NO = "IssueOtafuNo";
	public static String PROP_INDENT_TO_DEPOT_START_NO = "IndentToDepotStartNo";
	public static String PROP_DEPOT_INDENT_NO = "DepotIndentNo";
	public static String PROP_INDENT_TO_DEPOT_NO = "IndentToDepotNo";
	public static String PROP_ISSUE_DEPT_NO = "IssueDeptNo";
	public static String PROP_SAMPLE_TESTING_ENTRY_NO = "SampleTestingEntryNo";
	public static String PROP_DEPOT_INDENT_START_NO = "DepotIndentStartNo";
	public static String PROP_QUOTATION_REQ_NO = "QuotationReqNo";
	public static String PROP_QUOTATION_REC_START_NO = "QuotationRecStartNo";
	public static String PROP_DISPOSAL_ENTRY_START_NO = "DisposalEntryStartNo";
	public static String PROP_WORK_ORDER_NO = "WorkOrderNo";
	public static String PROP_QUOTATION_REQ_START_NO = "QuotationReqStartNo";
	public static String PROP_BALANCE_START_NO = "BalanceStartNo";
	public static String PROP_WORK_ORDER_START_NO = "WorkOrderStartNo";
	public static String PROP_ISSUE_IN_PATIENT_RETURN_NO = "IssueInPatientReturnNo";
	public static String PROP_INDENT_TO_SOC_NO = "IndentToSocNo";
	public static String PROP_ISSUE_DEPT_RETURN_NO = "IssueDeptReturnNo";
	public static String PROP_ISSUE_DEPT_RETURN_START_NO = "IssueDeptReturnStartNo";
	public static String PROP_ADJUSTMENT_NO = "AdjustmentNo";
	public static String PROP_OPD_ISSUE_NO = "OpdIssueNo";
	public static String PROP_PO_INDENT_NO = "PoIndentNo";
	public static String PROP_PO_INDENT_START_NO = "PoIndentStartNo";


	// constructors
	public BaseStoreFyDocumentNo () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreFyDocumentNo (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String poIndentStartNo;
	private java.lang.String poIndentNo;
	private java.lang.String poStartNo;
	private java.lang.String poNo;
	private java.lang.String mmfIndentStartNo;
	private java.lang.String mmfIndentNo;
	private java.lang.String grnStartNo;
	private java.lang.String grnNo;
	private java.lang.String vendorReturnStartNo;
	private java.lang.String vendorReturnNo;
	private java.lang.String issueDeptStartNo;
	private java.lang.String issueDeptNo;
	private java.lang.String issueDeptReturnStartNo;
	private java.lang.String issueDeptReturnNo;
	private java.lang.String issueInPatientStartNo;
	private java.lang.Integer issueInPatientNo;
	private java.lang.String issueInPatientReturnStartNo;
	private java.lang.String issueInPatientReturnNo;
	private java.lang.String quotationReqStartNo;
	private java.lang.String quotationReqNo;
	private java.lang.String quotationRecStartNo;
	private java.lang.String quotationRecNo;
	private java.lang.String inIndentStartNo;
	private java.lang.String inIndentNo;
	private java.lang.String depotIndentStartNo;
	private java.lang.String depotIndentNo;
	private java.lang.String socIndentStartNo;
	private java.lang.String socIndentNo;
	private java.lang.Integer issueWardNo;
	private java.lang.String loaninStartNo;
	private java.lang.String loaninNo;
	private java.lang.String wardReturnNo;
	private java.lang.String patientReturnNo;
	private java.lang.String adjustmentNo;
	private java.lang.String adjustmentStartNo;
	private java.lang.String mmfNo;
	private java.lang.String mmfStartNo;
	private java.lang.String balanceNo;
	private java.lang.String balanceStartNo;
	private java.lang.String demandNo;
	private java.lang.String demandStartNo;
	private java.lang.String booStartNo;
	private java.lang.String booNo;
	private java.lang.String opdIssueNo;
	private java.lang.String opdReturnNo;
	private java.lang.String issueOtafuStartNo;
	private java.lang.String issueOtafuNo;
	private java.lang.String isuueLoanoutStartNo;
	private java.lang.String issueLoanoutNo;
	private java.lang.String issueOtherUnitsNo;
	private java.lang.String issueOtherUnitsStartNo;
	private java.lang.String indentToDepotStartNo;
	private java.lang.String indentToDepotNo;
	private java.lang.String indentToSocStartNo;
	private java.lang.String indentToSocNo;
	private java.lang.String workOrderStartNo;
	private java.lang.String workOrderNo;
	private java.lang.String disposalEntryStartNo;
	private java.lang.String disposalEntryNo;
	private java.lang.String defectEntryStartNo;
	private java.lang.String defectEntryNo;
	private java.lang.String sampleTestingEntryNo;
	private java.lang.String tenderNo;
	private java.lang.String deptConsumNo;
	private java.lang.String mPRNo;
	private java.lang.String medicineReturnNo;
	private java.lang.String proformaBEntryNo;

	// many to one
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasHospital hospital;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="id"
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
	 * Return the value associated with the column: po_indent_start_no
	 */
	public java.lang.String getPoIndentStartNo () {
		return poIndentStartNo;
	}

	/**
	 * Set the value related to the column: po_indent_start_no
	 * @param poIndentStartNo the po_indent_start_no value
	 */
	public void setPoIndentStartNo (java.lang.String poIndentStartNo) {
		this.poIndentStartNo = poIndentStartNo;
	}



	/**
	 * Return the value associated with the column: po_indent_no
	 */
	public java.lang.String getPoIndentNo () {
		return poIndentNo;
	}

	/**
	 * Set the value related to the column: po_indent_no
	 * @param poIndentNo the po_indent_no value
	 */
	public void setPoIndentNo (java.lang.String poIndentNo) {
		this.poIndentNo = poIndentNo;
	}



	/**
	 * Return the value associated with the column: po_start_no
	 */
	public java.lang.String getPoStartNo () {
		return poStartNo;
	}

	/**
	 * Set the value related to the column: po_start_no
	 * @param poStartNo the po_start_no value
	 */
	public void setPoStartNo (java.lang.String poStartNo) {
		this.poStartNo = poStartNo;
	}



	/**
	 * Return the value associated with the column: po_no
	 */
	public java.lang.String getPoNo () {
		return poNo;
	}

	/**
	 * Set the value related to the column: po_no
	 * @param poNo the po_no value
	 */
	public void setPoNo (java.lang.String poNo) {
		this.poNo = poNo;
	}



	/**
	 * Return the value associated with the column: mmf_indent_start_no
	 */
	public java.lang.String getMmfIndentStartNo () {
		return mmfIndentStartNo;
	}

	/**
	 * Set the value related to the column: mmf_indent_start_no
	 * @param mmfIndentStartNo the mmf_indent_start_no value
	 */
	public void setMmfIndentStartNo (java.lang.String mmfIndentStartNo) {
		this.mmfIndentStartNo = mmfIndentStartNo;
	}



	/**
	 * Return the value associated with the column: mmf_indent_no
	 */
	public java.lang.String getMmfIndentNo () {
		return mmfIndentNo;
	}

	/**
	 * Set the value related to the column: mmf_indent_no
	 * @param mmfIndentNo the mmf_indent_no value
	 */
	public void setMmfIndentNo (java.lang.String mmfIndentNo) {
		this.mmfIndentNo = mmfIndentNo;
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
	 * Return the value associated with the column: vendor_return_start_no
	 */
	public java.lang.String getVendorReturnStartNo () {
		return vendorReturnStartNo;
	}

	/**
	 * Set the value related to the column: vendor_return_start_no
	 * @param vendorReturnStartNo the vendor_return_start_no value
	 */
	public void setVendorReturnStartNo (java.lang.String vendorReturnStartNo) {
		this.vendorReturnStartNo = vendorReturnStartNo;
	}



	/**
	 * Return the value associated with the column: vendor_return_no
	 */
	public java.lang.String getVendorReturnNo () {
		return vendorReturnNo;
	}

	/**
	 * Set the value related to the column: vendor_return_no
	 * @param vendorReturnNo the vendor_return_no value
	 */
	public void setVendorReturnNo (java.lang.String vendorReturnNo) {
		this.vendorReturnNo = vendorReturnNo;
	}



	/**
	 * Return the value associated with the column: issue_dept_start_no
	 */
	public java.lang.String getIssueDeptStartNo () {
		return issueDeptStartNo;
	}

	/**
	 * Set the value related to the column: issue_dept_start_no
	 * @param issueDeptStartNo the issue_dept_start_no value
	 */
	public void setIssueDeptStartNo (java.lang.String issueDeptStartNo) {
		this.issueDeptStartNo = issueDeptStartNo;
	}



	/**
	 * Return the value associated with the column: issue_dept_no
	 */
	public java.lang.String getIssueDeptNo () {
		return issueDeptNo;
	}

	/**
	 * Set the value related to the column: issue_dept_no
	 * @param issueDeptNo the issue_dept_no value
	 */
	public void setIssueDeptNo (java.lang.String issueDeptNo) {
		this.issueDeptNo = issueDeptNo;
	}



	/**
	 * Return the value associated with the column: issue_dept_return_start_no
	 */
	public java.lang.String getIssueDeptReturnStartNo () {
		return issueDeptReturnStartNo;
	}

	/**
	 * Set the value related to the column: issue_dept_return_start_no
	 * @param issueDeptReturnStartNo the issue_dept_return_start_no value
	 */
	public void setIssueDeptReturnStartNo (java.lang.String issueDeptReturnStartNo) {
		this.issueDeptReturnStartNo = issueDeptReturnStartNo;
	}



	/**
	 * Return the value associated with the column: issue_dept_return_no
	 */
	public java.lang.String getIssueDeptReturnNo () {
		return issueDeptReturnNo;
	}

	/**
	 * Set the value related to the column: issue_dept_return_no
	 * @param issueDeptReturnNo the issue_dept_return_no value
	 */
	public void setIssueDeptReturnNo (java.lang.String issueDeptReturnNo) {
		this.issueDeptReturnNo = issueDeptReturnNo;
	}



	/**
	 * Return the value associated with the column: issue_in_patient_start_no
	 */
	public java.lang.String getIssueInPatientStartNo () {
		return issueInPatientStartNo;
	}

	/**
	 * Set the value related to the column: issue_in_patient_start_no
	 * @param issueInPatientStartNo the issue_in_patient_start_no value
	 */
	public void setIssueInPatientStartNo (java.lang.String issueInPatientStartNo) {
		this.issueInPatientStartNo = issueInPatientStartNo;
	}



	/**
	 * Return the value associated with the column: issue_in_patient_no
	 */
	public java.lang.Integer getIssueInPatientNo () {
		return issueInPatientNo;
	}

	/**
	 * Set the value related to the column: issue_in_patient_no
	 * @param issueInPatientNo the issue_in_patient_no value
	 */
	public void setIssueInPatientNo (java.lang.Integer issueInPatientNo) {
		this.issueInPatientNo = issueInPatientNo;
	}



	/**
	 * Return the value associated with the column: issue_in_patient_return_start
	 */
	public java.lang.String getIssueInPatientReturnStartNo () {
		return issueInPatientReturnStartNo;
	}

	/**
	 * Set the value related to the column: issue_in_patient_return_start
	 * @param issueInPatientReturnStartNo the issue_in_patient_return_start value
	 */
	public void setIssueInPatientReturnStartNo (java.lang.String issueInPatientReturnStartNo) {
		this.issueInPatientReturnStartNo = issueInPatientReturnStartNo;
	}



	/**
	 * Return the value associated with the column: issue_in_patient_return_no
	 */
	public java.lang.String getIssueInPatientReturnNo () {
		return issueInPatientReturnNo;
	}

	/**
	 * Set the value related to the column: issue_in_patient_return_no
	 * @param issueInPatientReturnNo the issue_in_patient_return_no value
	 */
	public void setIssueInPatientReturnNo (java.lang.String issueInPatientReturnNo) {
		this.issueInPatientReturnNo = issueInPatientReturnNo;
	}



	/**
	 * Return the value associated with the column: quotation_req_start_no
	 */
	public java.lang.String getQuotationReqStartNo () {
		return quotationReqStartNo;
	}

	/**
	 * Set the value related to the column: quotation_req_start_no
	 * @param quotationReqStartNo the quotation_req_start_no value
	 */
	public void setQuotationReqStartNo (java.lang.String quotationReqStartNo) {
		this.quotationReqStartNo = quotationReqStartNo;
	}



	/**
	 * Return the value associated with the column: quotation_req_no
	 */
	public java.lang.String getQuotationReqNo () {
		return quotationReqNo;
	}

	/**
	 * Set the value related to the column: quotation_req_no
	 * @param quotationReqNo the quotation_req_no value
	 */
	public void setQuotationReqNo (java.lang.String quotationReqNo) {
		this.quotationReqNo = quotationReqNo;
	}



	/**
	 * Return the value associated with the column: quotation_rec_start_no
	 */
	public java.lang.String getQuotationRecStartNo () {
		return quotationRecStartNo;
	}

	/**
	 * Set the value related to the column: quotation_rec_start_no
	 * @param quotationRecStartNo the quotation_rec_start_no value
	 */
	public void setQuotationRecStartNo (java.lang.String quotationRecStartNo) {
		this.quotationRecStartNo = quotationRecStartNo;
	}



	/**
	 * Return the value associated with the column: quotation_rec_no
	 */
	public java.lang.String getQuotationRecNo () {
		return quotationRecNo;
	}

	/**
	 * Set the value related to the column: quotation_rec_no
	 * @param quotationRecNo the quotation_rec_no value
	 */
	public void setQuotationRecNo (java.lang.String quotationRecNo) {
		this.quotationRecNo = quotationRecNo;
	}



	/**
	 * Return the value associated with the column: In_Indent_Start_No
	 */
	public java.lang.String getInIndentStartNo () {
		return inIndentStartNo;
	}

	/**
	 * Set the value related to the column: In_Indent_Start_No
	 * @param inIndentStartNo the In_Indent_Start_No value
	 */
	public void setInIndentStartNo (java.lang.String inIndentStartNo) {
		this.inIndentStartNo = inIndentStartNo;
	}



	/**
	 * Return the value associated with the column: In_Indent_No
	 */
	public java.lang.String getInIndentNo () {
		return inIndentNo;
	}

	/**
	 * Set the value related to the column: In_Indent_No
	 * @param inIndentNo the In_Indent_No value
	 */
	public void setInIndentNo (java.lang.String inIndentNo) {
		this.inIndentNo = inIndentNo;
	}



	/**
	 * Return the value associated with the column: depot_indent_start_no
	 */
	public java.lang.String getDepotIndentStartNo () {
		return depotIndentStartNo;
	}

	/**
	 * Set the value related to the column: depot_indent_start_no
	 * @param depotIndentStartNo the depot_indent_start_no value
	 */
	public void setDepotIndentStartNo (java.lang.String depotIndentStartNo) {
		this.depotIndentStartNo = depotIndentStartNo;
	}



	/**
	 * Return the value associated with the column: depot_indent_no
	 */
	public java.lang.String getDepotIndentNo () {
		return depotIndentNo;
	}

	/**
	 * Set the value related to the column: depot_indent_no
	 * @param depotIndentNo the depot_indent_no value
	 */
	public void setDepotIndentNo (java.lang.String depotIndentNo) {
		this.depotIndentNo = depotIndentNo;
	}



	/**
	 * Return the value associated with the column: soc_indent_start_no
	 */
	public java.lang.String getSocIndentStartNo () {
		return socIndentStartNo;
	}

	/**
	 * Set the value related to the column: soc_indent_start_no
	 * @param socIndentStartNo the soc_indent_start_no value
	 */
	public void setSocIndentStartNo (java.lang.String socIndentStartNo) {
		this.socIndentStartNo = socIndentStartNo;
	}



	/**
	 * Return the value associated with the column: soc_indent_no
	 */
	public java.lang.String getSocIndentNo () {
		return socIndentNo;
	}

	/**
	 * Set the value related to the column: soc_indent_no
	 * @param socIndentNo the soc_indent_no value
	 */
	public void setSocIndentNo (java.lang.String socIndentNo) {
		this.socIndentNo = socIndentNo;
	}



	/**
	 * Return the value associated with the column: issue_ward_no
	 */
	public java.lang.Integer getIssueWardNo () {
		return issueWardNo;
	}

	/**
	 * Set the value related to the column: issue_ward_no
	 * @param issueWardNo the issue_ward_no value
	 */
	public void setIssueWardNo (java.lang.Integer issueWardNo) {
		this.issueWardNo = issueWardNo;
	}



	/**
	 * Return the value associated with the column: loanin_start_no
	 */
	public java.lang.String getLoaninStartNo () {
		return loaninStartNo;
	}

	/**
	 * Set the value related to the column: loanin_start_no
	 * @param loaninStartNo the loanin_start_no value
	 */
	public void setLoaninStartNo (java.lang.String loaninStartNo) {
		this.loaninStartNo = loaninStartNo;
	}



	/**
	 * Return the value associated with the column: loanin_no
	 */
	public java.lang.String getLoaninNo () {
		return loaninNo;
	}

	/**
	 * Set the value related to the column: loanin_no
	 * @param loaninNo the loanin_no value
	 */
	public void setLoaninNo (java.lang.String loaninNo) {
		this.loaninNo = loaninNo;
	}



	/**
	 * Return the value associated with the column: ward_return_no
	 */
	public java.lang.String getWardReturnNo () {
		return wardReturnNo;
	}

	/**
	 * Set the value related to the column: ward_return_no
	 * @param wardReturnNo the ward_return_no value
	 */
	public void setWardReturnNo (java.lang.String wardReturnNo) {
		this.wardReturnNo = wardReturnNo;
	}



	/**
	 * Return the value associated with the column: patient_return_no
	 */
	public java.lang.String getPatientReturnNo () {
		return patientReturnNo;
	}

	/**
	 * Set the value related to the column: patient_return_no
	 * @param patientReturnNo the patient_return_no value
	 */
	public void setPatientReturnNo (java.lang.String patientReturnNo) {
		this.patientReturnNo = patientReturnNo;
	}



	/**
	 * Return the value associated with the column: adjustment_no
	 */
	public java.lang.String getAdjustmentNo () {
		return adjustmentNo;
	}

	/**
	 * Set the value related to the column: adjustment_no
	 * @param adjustmentNo the adjustment_no value
	 */
	public void setAdjustmentNo (java.lang.String adjustmentNo) {
		this.adjustmentNo = adjustmentNo;
	}



	/**
	 * Return the value associated with the column: adjustment_start_no
	 */
	public java.lang.String getAdjustmentStartNo () {
		return adjustmentStartNo;
	}

	/**
	 * Set the value related to the column: adjustment_start_no
	 * @param adjustmentStartNo the adjustment_start_no value
	 */
	public void setAdjustmentStartNo (java.lang.String adjustmentStartNo) {
		this.adjustmentStartNo = adjustmentStartNo;
	}



	/**
	 * Return the value associated with the column: mmf_no
	 */
	public java.lang.String getMmfNo () {
		return mmfNo;
	}

	/**
	 * Set the value related to the column: mmf_no
	 * @param mmfNo the mmf_no value
	 */
	public void setMmfNo (java.lang.String mmfNo) {
		this.mmfNo = mmfNo;
	}



	/**
	 * Return the value associated with the column: mmf_start_no
	 */
	public java.lang.String getMmfStartNo () {
		return mmfStartNo;
	}

	/**
	 * Set the value related to the column: mmf_start_no
	 * @param mmfStartNo the mmf_start_no value
	 */
	public void setMmfStartNo (java.lang.String mmfStartNo) {
		this.mmfStartNo = mmfStartNo;
	}



	/**
	 * Return the value associated with the column: balance_no
	 */
	public java.lang.String getBalanceNo () {
		return balanceNo;
	}

	/**
	 * Set the value related to the column: balance_no
	 * @param balanceNo the balance_no value
	 */
	public void setBalanceNo (java.lang.String balanceNo) {
		this.balanceNo = balanceNo;
	}



	/**
	 * Return the value associated with the column: balance_start_no
	 */
	public java.lang.String getBalanceStartNo () {
		return balanceStartNo;
	}

	/**
	 * Set the value related to the column: balance_start_no
	 * @param balanceStartNo the balance_start_no value
	 */
	public void setBalanceStartNo (java.lang.String balanceStartNo) {
		this.balanceStartNo = balanceStartNo;
	}



	/**
	 * Return the value associated with the column: demand_no
	 */
	public java.lang.String getDemandNo () {
		return demandNo;
	}

	/**
	 * Set the value related to the column: demand_no
	 * @param demandNo the demand_no value
	 */
	public void setDemandNo (java.lang.String demandNo) {
		this.demandNo = demandNo;
	}



	/**
	 * Return the value associated with the column: demand_start_no
	 */
	public java.lang.String getDemandStartNo () {
		return demandStartNo;
	}

	/**
	 * Set the value related to the column: demand_start_no
	 * @param demandStartNo the demand_start_no value
	 */
	public void setDemandStartNo (java.lang.String demandStartNo) {
		this.demandStartNo = demandStartNo;
	}



	/**
	 * Return the value associated with the column: boo_start_no
	 */
	public java.lang.String getBooStartNo () {
		return booStartNo;
	}

	/**
	 * Set the value related to the column: boo_start_no
	 * @param booStartNo the boo_start_no value
	 */
	public void setBooStartNo (java.lang.String booStartNo) {
		this.booStartNo = booStartNo;
	}



	/**
	 * Return the value associated with the column: boo_no
	 */
	public java.lang.String getBooNo () {
		return booNo;
	}

	/**
	 * Set the value related to the column: boo_no
	 * @param booNo the boo_no value
	 */
	public void setBooNo (java.lang.String booNo) {
		this.booNo = booNo;
	}



	/**
	 * Return the value associated with the column: opd_issue_no
	 */
	public java.lang.String getOpdIssueNo () {
		return opdIssueNo;
	}

	/**
	 * Set the value related to the column: opd_issue_no
	 * @param opdIssueNo the opd_issue_no value
	 */
	public void setOpdIssueNo (java.lang.String opdIssueNo) {
		this.opdIssueNo = opdIssueNo;
	}



	/**
	 * Return the value associated with the column: opd_return_no
	 */
	public java.lang.String getOpdReturnNo () {
		return opdReturnNo;
	}

	/**
	 * Set the value related to the column: opd_return_no
	 * @param opdReturnNo the opd_return_no value
	 */
	public void setOpdReturnNo (java.lang.String opdReturnNo) {
		this.opdReturnNo = opdReturnNo;
	}



	/**
	 * Return the value associated with the column: issue_OTAFU_start_no
	 */
	public java.lang.String getIssueOtafuStartNo () {
		return issueOtafuStartNo;
	}

	/**
	 * Set the value related to the column: issue_OTAFU_start_no
	 * @param issueOtafuStartNo the issue_OTAFU_start_no value
	 */
	public void setIssueOtafuStartNo (java.lang.String issueOtafuStartNo) {
		this.issueOtafuStartNo = issueOtafuStartNo;
	}



	/**
	 * Return the value associated with the column: issue_OTAFU_no
	 */
	public java.lang.String getIssueOtafuNo () {
		return issueOtafuNo;
	}

	/**
	 * Set the value related to the column: issue_OTAFU_no
	 * @param issueOtafuNo the issue_OTAFU_no value
	 */
	public void setIssueOtafuNo (java.lang.String issueOtafuNo) {
		this.issueOtafuNo = issueOtafuNo;
	}



	/**
	 * Return the value associated with the column: isuue_loanout_start_no
	 */
	public java.lang.String getIsuueLoanoutStartNo () {
		return isuueLoanoutStartNo;
	}

	/**
	 * Set the value related to the column: isuue_loanout_start_no
	 * @param isuueLoanoutStartNo the isuue_loanout_start_no value
	 */
	public void setIsuueLoanoutStartNo (java.lang.String isuueLoanoutStartNo) {
		this.isuueLoanoutStartNo = isuueLoanoutStartNo;
	}



	/**
	 * Return the value associated with the column: issue_loanout_no
	 */
	public java.lang.String getIssueLoanoutNo () {
		return issueLoanoutNo;
	}

	/**
	 * Set the value related to the column: issue_loanout_no
	 * @param issueLoanoutNo the issue_loanout_no value
	 */
	public void setIssueLoanoutNo (java.lang.String issueLoanoutNo) {
		this.issueLoanoutNo = issueLoanoutNo;
	}



	/**
	 * Return the value associated with the column: issue_other_units_no
	 */
	public java.lang.String getIssueOtherUnitsNo () {
		return issueOtherUnitsNo;
	}

	/**
	 * Set the value related to the column: issue_other_units_no
	 * @param issueOtherUnitsNo the issue_other_units_no value
	 */
	public void setIssueOtherUnitsNo (java.lang.String issueOtherUnitsNo) {
		this.issueOtherUnitsNo = issueOtherUnitsNo;
	}



	/**
	 * Return the value associated with the column: issue_other_units_start_no
	 */
	public java.lang.String getIssueOtherUnitsStartNo () {
		return issueOtherUnitsStartNo;
	}

	/**
	 * Set the value related to the column: issue_other_units_start_no
	 * @param issueOtherUnitsStartNo the issue_other_units_start_no value
	 */
	public void setIssueOtherUnitsStartNo (java.lang.String issueOtherUnitsStartNo) {
		this.issueOtherUnitsStartNo = issueOtherUnitsStartNo;
	}



	/**
	 * Return the value associated with the column: indent_to_depot_start_no
	 */
	public java.lang.String getIndentToDepotStartNo () {
		return indentToDepotStartNo;
	}

	/**
	 * Set the value related to the column: indent_to_depot_start_no
	 * @param indentToDepotStartNo the indent_to_depot_start_no value
	 */
	public void setIndentToDepotStartNo (java.lang.String indentToDepotStartNo) {
		this.indentToDepotStartNo = indentToDepotStartNo;
	}



	/**
	 * Return the value associated with the column: indent_to_depot_no
	 */
	public java.lang.String getIndentToDepotNo () {
		return indentToDepotNo;
	}

	/**
	 * Set the value related to the column: indent_to_depot_no
	 * @param indentToDepotNo the indent_to_depot_no value
	 */
	public void setIndentToDepotNo (java.lang.String indentToDepotNo) {
		this.indentToDepotNo = indentToDepotNo;
	}



	/**
	 * Return the value associated with the column: indent_to_soc_start_no
	 */
	public java.lang.String getIndentToSocStartNo () {
		return indentToSocStartNo;
	}

	/**
	 * Set the value related to the column: indent_to_soc_start_no
	 * @param indentToSocStartNo the indent_to_soc_start_no value
	 */
	public void setIndentToSocStartNo (java.lang.String indentToSocStartNo) {
		this.indentToSocStartNo = indentToSocStartNo;
	}



	/**
	 * Return the value associated with the column: indent_to_soc_no
	 */
	public java.lang.String getIndentToSocNo () {
		return indentToSocNo;
	}

	/**
	 * Set the value related to the column: indent_to_soc_no
	 * @param indentToSocNo the indent_to_soc_no value
	 */
	public void setIndentToSocNo (java.lang.String indentToSocNo) {
		this.indentToSocNo = indentToSocNo;
	}



	/**
	 * Return the value associated with the column: work_order_start_no
	 */
	public java.lang.String getWorkOrderStartNo () {
		return workOrderStartNo;
	}

	/**
	 * Set the value related to the column: work_order_start_no
	 * @param workOrderStartNo the work_order_start_no value
	 */
	public void setWorkOrderStartNo (java.lang.String workOrderStartNo) {
		this.workOrderStartNo = workOrderStartNo;
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
	 * Return the value associated with the column: disposal_entry_start_no
	 */
	public java.lang.String getDisposalEntryStartNo () {
		return disposalEntryStartNo;
	}

	/**
	 * Set the value related to the column: disposal_entry_start_no
	 * @param disposalEntryStartNo the disposal_entry_start_no value
	 */
	public void setDisposalEntryStartNo (java.lang.String disposalEntryStartNo) {
		this.disposalEntryStartNo = disposalEntryStartNo;
	}



	/**
	 * Return the value associated with the column: disposal_entry_no
	 */
	public java.lang.String getDisposalEntryNo () {
		return disposalEntryNo;
	}

	/**
	 * Set the value related to the column: disposal_entry_no
	 * @param disposalEntryNo the disposal_entry_no value
	 */
	public void setDisposalEntryNo (java.lang.String disposalEntryNo) {
		this.disposalEntryNo = disposalEntryNo;
	}



	/**
	 * Return the value associated with the column: defect_entry_start_no
	 */
	public java.lang.String getDefectEntryStartNo () {
		return defectEntryStartNo;
	}

	/**
	 * Set the value related to the column: defect_entry_start_no
	 * @param defectEntryStartNo the defect_entry_start_no value
	 */
	public void setDefectEntryStartNo (java.lang.String defectEntryStartNo) {
		this.defectEntryStartNo = defectEntryStartNo;
	}



	/**
	 * Return the value associated with the column: defect_entry_no
	 */
	public java.lang.String getDefectEntryNo () {
		return defectEntryNo;
	}

	/**
	 * Set the value related to the column: defect_entry_no
	 * @param defectEntryNo the defect_entry_no value
	 */
	public void setDefectEntryNo (java.lang.String defectEntryNo) {
		this.defectEntryNo = defectEntryNo;
	}



	/**
	 * Return the value associated with the column: sample_entry_no
	 */
	public java.lang.String getSampleTestingEntryNo () {
		return sampleTestingEntryNo;
	}

	/**
	 * Set the value related to the column: sample_entry_no
	 * @param sampleTestingEntryNo the sample_entry_no value
	 */
	public void setSampleTestingEntryNo (java.lang.String sampleTestingEntryNo) {
		this.sampleTestingEntryNo = sampleTestingEntryNo;
	}



	/**
	 * Return the value associated with the column: tender_no
	 */
	public java.lang.String getTenderNo () {
		return tenderNo;
	}

	/**
	 * Set the value related to the column: tender_no
	 * @param tenderNo the tender_no value
	 */
	public void setTenderNo (java.lang.String tenderNo) {
		this.tenderNo = tenderNo;
	}



	/**
	 * Return the value associated with the column: dept_consum_no
	 */
	public java.lang.String getDeptConsumNo () {
		return deptConsumNo;
	}

	/**
	 * Set the value related to the column: dept_consum_no
	 * @param deptConsumNo the dept_consum_no value
	 */
	public void setDeptConsumNo (java.lang.String deptConsumNo) {
		this.deptConsumNo = deptConsumNo;
	}



	/**
	 * Return the value associated with the column: mpr_no
	 */
	public java.lang.String getMPRNo () {
		return mPRNo;
	}

	/**
	 * Set the value related to the column: mpr_no
	 * @param mPRNo the mpr_no value
	 */
	public void setMPRNo (java.lang.String mPRNo) {
		this.mPRNo = mPRNo;
	}



	/**
	 * Return the value associated with the column: MEDICINE_RETURN_NO
	 */
	public java.lang.String getMedicineReturnNo () {
		return medicineReturnNo;
	}

	/**
	 * Set the value related to the column: MEDICINE_RETURN_NO
	 * @param medicineReturnNo the MEDICINE_RETURN_NO value
	 */
	public void setMedicineReturnNo (java.lang.String medicineReturnNo) {
		this.medicineReturnNo = medicineReturnNo;
	}



	/**
	 * Return the value associated with the column: PROFORMAB_ENTRY_NO
	 */
	public java.lang.String getProformaBEntryNo () {
		return proformaBEntryNo;
	}

	/**
	 * Set the value related to the column: PROFORMAB_ENTRY_NO
	 * @param proformaBEntryNo the PROFORMAB_ENTRY_NO value
	 */
	public void setProformaBEntryNo (java.lang.String proformaBEntryNo) {
		this.proformaBEntryNo = proformaBEntryNo;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreFyDocumentNo)) return false;
		else {
			jkt.hms.masters.business.StoreFyDocumentNo storeFyDocumentNo = (jkt.hms.masters.business.StoreFyDocumentNo) obj;
			if (null == this.getId() || null == storeFyDocumentNo.getId()) return false;
			else return (this.getId().equals(storeFyDocumentNo.getId()));
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
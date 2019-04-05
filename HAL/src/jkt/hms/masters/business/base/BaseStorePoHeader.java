package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the store_po_header table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="store_po_header"
 */

public abstract class BaseStorePoHeader  implements Serializable {

	public static String REF = "StorePoHeader";
	public static String PROP_PROPOSAL_DATE = "ProposalDate";
	public static String PROP_PAY_TERMS = "PayTerms";
	public static String PROP_PO_NUMBER = "PoNumber";
	public static String PROP_STOCKIST = "Stockist";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_SIGNING_AUTHORITY = "SigningAuthority";
	public static String PROP_GROUP = "Group";
	public static String PROP_PO_TIME = "PoTime";
	public static String PROP_RECEIVED_STATUS = "ReceivedStatus";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_GRN_MASTER = "GrnMaster";
	public static String PROP_ITEM_TYPE = "ItemType";
	public static String PROP_TENDER = "Tender";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_CODEHEAD = "Codehead";
	public static String PROP_PROPOSAL_ID = "ProposalId";
	public static String PROP_DELIVERY_DATE = "DeliveryDate";
	public static String PROP_FLAG = "Flag";
	public static String PROP_FILENO = "Fileno";
	public static String PROP_FINANCIAL_YEAR = "FinancialYear";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_QUOTATION = "Quotation";
	public static String PROP_NET_AMOUNT = "NetAmount";
	public static String PROP_PO_DATE = "PoDate";
	public static String PROP_TAX_TERM = "TaxTerm";
	public static String PROP_PROPOSAL_NO = "ProposalNo";
	public static String PROP_QUOTATION_DATE = "QuotationDate";
	public static String PROP_DELIVERY_TERMS = "DeliveryTerms";
	public static String PROP_TELEPHONE_NO = "TelephoneNo";
	public static String PROP_APPROVAL_AUTHORITY = "ApprovalAuthority";
	public static String PROP_STATUS = "Status";
	public static String PROP_CATEGORY = "Category";
	public static String PROP_SUPPLIER = "Supplier";
	public static String PROP_APP_VIDE = "AppVide";
	public static String PROP_ID = "Id";
	public static String PROP_DELIVERY_SCHEDULE = "DeliverySchedule";
	public static String PROP_PROPOSAL_APPROVAL_DATE = "ProposalApprovalDate";
	public static String PROP_REFERENCE = "Reference";
	public static String PROP_MPR_APPROVAL_DATE = "MprApprovalDate";


	// constructors
	public BaseStorePoHeader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStorePoHeader (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date poDate;
	private java.lang.String poTime;
	private java.util.Date deliveryDate;
	private java.math.BigDecimal netAmount;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String remarks;
	private java.lang.String payTerms;
	private java.lang.String status;
	private java.util.Date quotationDate;
	private java.lang.String deliveryTerms;
	private java.lang.String poNumber;
	private java.lang.String approvalAuthority;
	private java.lang.String signingAuthority;
	private java.lang.String flag;
	private java.lang.Integer proposalId;
	private java.lang.String fileno;
	private java.lang.String appVide;
	private java.lang.String reference;
	private java.lang.String category;
	private java.lang.String telephoneNo;
	private java.lang.String codehead;
	private java.lang.String itemType;
	private java.lang.String receivedStatus;
	private java.util.Date mprApprovalDate;
	private java.lang.String proposalNo;
	private java.util.Date proposalDate;
	private java.util.Date proposalApprovalDate;
	private java.lang.String deliverySchedule;
	private java.lang.String taxTerm;

	// many to one
	private jkt.hms.masters.business.MasStoreSupplier stockist;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.StoreQuotationRequestM quotation;
	private jkt.hms.masters.business.StoreGrnM grnMaster;
	private jkt.hms.masters.business.MasStoreSupplier supplier;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasStoreGroup group;
	private jkt.hms.masters.business.StoreTenderM tender;
	private jkt.hms.masters.business.MasStoreFinancial financialYear;

	// collections
	private java.util.Set<jkt.hms.masters.business.StorePoDetail> storePoDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="po_id"
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
	 * Return the value associated with the column: po_date
	 */
	public java.util.Date getPoDate () {
		return poDate;
	}

	/**
	 * Set the value related to the column: po_date
	 * @param poDate the po_date value
	 */
	public void setPoDate (java.util.Date poDate) {
		this.poDate = poDate;
	}



	/**
	 * Return the value associated with the column: po_time
	 */
	public java.lang.String getPoTime () {
		return poTime;
	}

	/**
	 * Set the value related to the column: po_time
	 * @param poTime the po_time value
	 */
	public void setPoTime (java.lang.String poTime) {
		this.poTime = poTime;
	}



	/**
	 * Return the value associated with the column: delivery_date
	 */
	public java.util.Date getDeliveryDate () {
		return deliveryDate;
	}

	/**
	 * Set the value related to the column: delivery_date
	 * @param deliveryDate the delivery_date value
	 */
	public void setDeliveryDate (java.util.Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}



	/**
	 * Return the value associated with the column: net_amount
	 */
	public java.math.BigDecimal getNetAmount () {
		return netAmount;
	}

	/**
	 * Set the value related to the column: net_amount
	 * @param netAmount the net_amount value
	 */
	public void setNetAmount (java.math.BigDecimal netAmount) {
		this.netAmount = netAmount;
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
	 * Return the value associated with the column: pay_terms
	 */
	public java.lang.String getPayTerms () {
		return payTerms;
	}

	/**
	 * Set the value related to the column: pay_terms
	 * @param payTerms the pay_terms value
	 */
	public void setPayTerms (java.lang.String payTerms) {
		this.payTerms = payTerms;
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
	 * Return the value associated with the column: quotation_date
	 */
	public java.util.Date getQuotationDate () {
		return quotationDate;
	}

	/**
	 * Set the value related to the column: quotation_date
	 * @param quotationDate the quotation_date value
	 */
	public void setQuotationDate (java.util.Date quotationDate) {
		this.quotationDate = quotationDate;
	}



	/**
	 * Return the value associated with the column: delivery_terms
	 */
	public java.lang.String getDeliveryTerms () {
		return deliveryTerms;
	}

	/**
	 * Set the value related to the column: delivery_terms
	 * @param deliveryTerms the delivery_terms value
	 */
	public void setDeliveryTerms (java.lang.String deliveryTerms) {
		this.deliveryTerms = deliveryTerms;
	}



	/**
	 * Return the value associated with the column: po_number
	 */
	public java.lang.String getPoNumber () {
		return poNumber;
	}

	/**
	 * Set the value related to the column: po_number
	 * @param poNumber the po_number value
	 */
	public void setPoNumber (java.lang.String poNumber) {
		this.poNumber = poNumber;
	}



	/**
	 * Return the value associated with the column: approval_authority
	 */
	public java.lang.String getApprovalAuthority () {
		return approvalAuthority;
	}

	/**
	 * Set the value related to the column: approval_authority
	 * @param approvalAuthority the approval_authority value
	 */
	public void setApprovalAuthority (java.lang.String approvalAuthority) {
		this.approvalAuthority = approvalAuthority;
	}



	/**
	 * Return the value associated with the column: signing_authority
	 */
	public java.lang.String getSigningAuthority () {
		return signingAuthority;
	}

	/**
	 * Set the value related to the column: signing_authority
	 * @param signingAuthority the signing_authority value
	 */
	public void setSigningAuthority (java.lang.String signingAuthority) {
		this.signingAuthority = signingAuthority;
	}



	/**
	 * Return the value associated with the column: flag
	 */
	public java.lang.String getFlag () {
		return flag;
	}

	/**
	 * Set the value related to the column: flag
	 * @param flag the flag value
	 */
	public void setFlag (java.lang.String flag) {
		this.flag = flag;
	}



	/**
	 * Return the value associated with the column: proposal_id
	 */
	public java.lang.Integer getProposalId () {
		return proposalId;
	}

	/**
	 * Set the value related to the column: proposal_id
	 * @param proposalId the proposal_id value
	 */
	public void setProposalId (java.lang.Integer proposalId) {
		this.proposalId = proposalId;
	}



	/**
	 * Return the value associated with the column: fileno
	 */
	public java.lang.String getFileno () {
		return fileno;
	}

	/**
	 * Set the value related to the column: fileno
	 * @param fileno the fileno value
	 */
	public void setFileno (java.lang.String fileno) {
		this.fileno = fileno;
	}



	/**
	 * Return the value associated with the column: app_vide
	 */
	public java.lang.String getAppVide () {
		return appVide;
	}

	/**
	 * Set the value related to the column: app_vide
	 * @param appVide the app_vide value
	 */
	public void setAppVide (java.lang.String appVide) {
		this.appVide = appVide;
	}



	/**
	 * Return the value associated with the column: REFERENCE
	 */
	public java.lang.String getReference () {
		return reference;
	}

	/**
	 * Set the value related to the column: REFERENCE
	 * @param reference the REFERENCE value
	 */
	public void setReference (java.lang.String reference) {
		this.reference = reference;
	}



	/**
	 * Return the value associated with the column: CATEGORY
	 */
	public java.lang.String getCategory () {
		return category;
	}

	/**
	 * Set the value related to the column: CATEGORY
	 * @param category the CATEGORY value
	 */
	public void setCategory (java.lang.String category) {
		this.category = category;
	}



	/**
	 * Return the value associated with the column: TELEPHONE_NO
	 */
	public java.lang.String getTelephoneNo () {
		return telephoneNo;
	}

	/**
	 * Set the value related to the column: TELEPHONE_NO
	 * @param telephoneNo the TELEPHONE_NO value
	 */
	public void setTelephoneNo (java.lang.String telephoneNo) {
		this.telephoneNo = telephoneNo;
	}



	/**
	 * Return the value associated with the column: CODEHEAD
	 */
	public java.lang.String getCodehead () {
		return codehead;
	}

	/**
	 * Set the value related to the column: CODEHEAD
	 * @param codehead the CODEHEAD value
	 */
	public void setCodehead (java.lang.String codehead) {
		this.codehead = codehead;
	}



	/**
	 * Return the value associated with the column: Item_type
	 */
	public java.lang.String getItemType () {
		return itemType;
	}

	/**
	 * Set the value related to the column: Item_type
	 * @param itemType the Item_type value
	 */
	public void setItemType (java.lang.String itemType) {
		this.itemType = itemType;
	}



	/**
	 * Return the value associated with the column: received_status
	 */
	public java.lang.String getReceivedStatus () {
		return receivedStatus;
	}

	/**
	 * Set the value related to the column: received_status
	 * @param receivedStatus the received_status value
	 */
	public void setReceivedStatus (java.lang.String receivedStatus) {
		this.receivedStatus = receivedStatus;
	}



	/**
	 * Return the value associated with the column: mpr_approval_date
	 */
	public java.util.Date getMprApprovalDate () {
		return mprApprovalDate;
	}

	/**
	 * Set the value related to the column: mpr_approval_date
	 * @param mprApprovalDate the mpr_approval_date value
	 */
	public void setMprApprovalDate (java.util.Date mprApprovalDate) {
		this.mprApprovalDate = mprApprovalDate;
	}



	/**
	 * Return the value associated with the column: proposal_no
	 */
	public java.lang.String getProposalNo () {
		return proposalNo;
	}

	/**
	 * Set the value related to the column: proposal_no
	 * @param proposalNo the proposal_no value
	 */
	public void setProposalNo (java.lang.String proposalNo) {
		this.proposalNo = proposalNo;
	}



	/**
	 * Return the value associated with the column: proposal_date
	 */
	public java.util.Date getProposalDate () {
		return proposalDate;
	}

	/**
	 * Set the value related to the column: proposal_date
	 * @param proposalDate the proposal_date value
	 */
	public void setProposalDate (java.util.Date proposalDate) {
		this.proposalDate = proposalDate;
	}



	/**
	 * Return the value associated with the column: proposal_approval_date
	 */
	public java.util.Date getProposalApprovalDate () {
		return proposalApprovalDate;
	}

	/**
	 * Set the value related to the column: proposal_approval_date
	 * @param proposalApprovalDate the proposal_approval_date value
	 */
	public void setProposalApprovalDate (java.util.Date proposalApprovalDate) {
		this.proposalApprovalDate = proposalApprovalDate;
	}



	/**
	 * Return the value associated with the column: delivery_schedule
	 */
	public java.lang.String getDeliverySchedule () {
		return deliverySchedule;
	}

	/**
	 * Set the value related to the column: delivery_schedule
	 * @param deliverySchedule the delivery_schedule value
	 */
	public void setDeliverySchedule (java.lang.String deliverySchedule) {
		this.deliverySchedule = deliverySchedule;
	}



	/**
	 * Return the value associated with the column: tax_term
	 */
	public java.lang.String getTaxTerm () {
		return taxTerm;
	}

	/**
	 * Set the value related to the column: tax_term
	 * @param taxTerm the tax_term value
	 */
	public void setTaxTerm (java.lang.String taxTerm) {
		this.taxTerm = taxTerm;
	}



	/**
	 * Return the value associated with the column: stockist_id
	 */
	public jkt.hms.masters.business.MasStoreSupplier getStockist () {
		return stockist;
	}

	/**
	 * Set the value related to the column: stockist_id
	 * @param stockist the stockist_id value
	 */
	public void setStockist (jkt.hms.masters.business.MasStoreSupplier stockist) {
		this.stockist = stockist;
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
	 * Return the value associated with the column: quotation_id
	 */
	public jkt.hms.masters.business.StoreQuotationRequestM getQuotation () {
		return quotation;
	}

	/**
	 * Set the value related to the column: quotation_id
	 * @param quotation the quotation_id value
	 */
	public void setQuotation (jkt.hms.masters.business.StoreQuotationRequestM quotation) {
		this.quotation = quotation;
	}



	/**
	 * Return the value associated with the column: grn_master_id
	 */
	public jkt.hms.masters.business.StoreGrnM getGrnMaster () {
		return grnMaster;
	}

	/**
	 * Set the value related to the column: grn_master_id
	 * @param grnMaster the grn_master_id value
	 */
	public void setGrnMaster (jkt.hms.masters.business.StoreGrnM grnMaster) {
		this.grnMaster = grnMaster;
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
	 * Return the value associated with the column: group_id
	 */
	public jkt.hms.masters.business.MasStoreGroup getGroup () {
		return group;
	}

	/**
	 * Set the value related to the column: group_id
	 * @param group the group_id value
	 */
	public void setGroup (jkt.hms.masters.business.MasStoreGroup group) {
		this.group = group;
	}



	/**
	 * Return the value associated with the column: tender_id
	 */
	public jkt.hms.masters.business.StoreTenderM getTender () {
		return tender;
	}

	/**
	 * Set the value related to the column: tender_id
	 * @param tender the tender_id value
	 */
	public void setTender (jkt.hms.masters.business.StoreTenderM tender) {
		this.tender = tender;
	}



	/**
	 * Return the value associated with the column: financial_year
	 */
	public jkt.hms.masters.business.MasStoreFinancial getFinancialYear () {
		return financialYear;
	}

	/**
	 * Set the value related to the column: financial_year
	 * @param financialYear the financial_year value
	 */
	public void setFinancialYear (jkt.hms.masters.business.MasStoreFinancial financialYear) {
		this.financialYear = financialYear;
	}



	/**
	 * Return the value associated with the column: StorePoDetails
	 */
	public java.util.Set<jkt.hms.masters.business.StorePoDetail> getStorePoDetails () {
		return storePoDetails;
	}

	/**
	 * Set the value related to the column: StorePoDetails
	 * @param storePoDetails the StorePoDetails value
	 */
	public void setStorePoDetails (java.util.Set<jkt.hms.masters.business.StorePoDetail> storePoDetails) {
		this.storePoDetails = storePoDetails;
	}

	public void addToStorePoDetails (jkt.hms.masters.business.StorePoDetail storePoDetail) {
		if (null == getStorePoDetails()) setStorePoDetails(new java.util.TreeSet<jkt.hms.masters.business.StorePoDetail>());
		getStorePoDetails().add(storePoDetail);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.StorePoHeader)) return false;
		else {
			jkt.hms.masters.business.StorePoHeader storePoHeader = (jkt.hms.masters.business.StorePoHeader) obj;
			if (null == this.getId() || null == storePoHeader.getId()) return false;
			else return (this.getId().equals(storePoHeader.getId()));
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
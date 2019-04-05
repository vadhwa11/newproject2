package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the referral_patient_billing table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="referral_patient_billing"
 */

public abstract class BaseReferralPatientBilling  implements Serializable {

	public static String REF = "ReferralPatientBilling";
	public static String PROP_ERP_UPLOADING_DATE = "ErpUploadingDate";
	public static String PROP_ERP_POSTING_DATE = "ErpPostingDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_NET_AMOUNT = "NetAmount";
	public static String PROP_CHECK_NO = "CheckNo";
	public static String PROP_TAX_AMOUNT = "TaxAmount";
	public static String PROP_HR_REMARKS = "HrRemarks";
	public static String PROP_REFERRAL_DETAILS = "ReferralDetails";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_TOTAL_BILL_AMT = "TotalBillAmt";
	public static String PROP_APPROVAL_STATUS = "ApprovalStatus";
	public static String PROP_ID = "Id";
	public static String PROP_FINANCE_REMARKS = "FinanceRemarks";
	public static String PROP_BILL_DATE = "BillDate";
	public static String PROP_GM_REMARKS = "GmRemarks";
	public static String PROP_CHECK_DATE = "CheckDate";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ADMIN_BILL_AMT = "AdminBillAmt";
	public static String PROP_ADMIN_REMARKS = "AdminRemarks";
	public static String PROP_CHECK_AMOUNT = "CheckAmount";
	public static String PROP_BILL_NO = "BillNo";


	// constructors
	public BaseReferralPatientBilling () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseReferralPatientBilling (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String billNo;
	private java.util.Date billDate;
	private java.math.BigDecimal totalBillAmt;
	private java.math.BigDecimal adminBillAmt;
	private java.lang.String adminRemarks;
	private java.lang.String hrRemarks;
	private java.lang.String financeRemarks;
	private java.lang.String gmRemarks;
	private java.lang.String approvalStatus;
	private java.lang.String checkNo;
	private java.util.Date checkDate;
	private java.math.BigDecimal checkAmount;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.math.BigDecimal netAmount;
	private java.math.BigDecimal taxAmount;
	private java.util.Date erpPostingDate;
	private java.util.Date erpUploadingDate;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.ReferralPatientDetails referralDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
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
	 * Return the value associated with the column: bill_no
	 */
	public java.lang.String getBillNo () {
		return billNo;
	}

	/**
	 * Set the value related to the column: bill_no
	 * @param billNo the bill_no value
	 */
	public void setBillNo (java.lang.String billNo) {
		this.billNo = billNo;
	}



	/**
	 * Return the value associated with the column: bill_date
	 */
	public java.util.Date getBillDate () {
		return billDate;
	}

	/**
	 * Set the value related to the column: bill_date
	 * @param billDate the bill_date value
	 */
	public void setBillDate (java.util.Date billDate) {
		this.billDate = billDate;
	}



	/**
	 * Return the value associated with the column: total_bill_amt
	 */
	public java.math.BigDecimal getTotalBillAmt () {
		return totalBillAmt;
	}

	/**
	 * Set the value related to the column: total_bill_amt
	 * @param totalBillAmt the total_bill_amt value
	 */
	public void setTotalBillAmt (java.math.BigDecimal totalBillAmt) {
		this.totalBillAmt = totalBillAmt;
	}



	/**
	 * Return the value associated with the column: admin_bill_amt
	 */
	public java.math.BigDecimal getAdminBillAmt () {
		return adminBillAmt;
	}

	/**
	 * Set the value related to the column: admin_bill_amt
	 * @param adminBillAmt the admin_bill_amt value
	 */
	public void setAdminBillAmt (java.math.BigDecimal adminBillAmt) {
		this.adminBillAmt = adminBillAmt;
	}



	/**
	 * Return the value associated with the column: admin_remarks
	 */
	public java.lang.String getAdminRemarks () {
		return adminRemarks;
	}

	/**
	 * Set the value related to the column: admin_remarks
	 * @param adminRemarks the admin_remarks value
	 */
	public void setAdminRemarks (java.lang.String adminRemarks) {
		this.adminRemarks = adminRemarks;
	}



	/**
	 * Return the value associated with the column: hr_remarks
	 */
	public java.lang.String getHrRemarks () {
		return hrRemarks;
	}

	/**
	 * Set the value related to the column: hr_remarks
	 * @param hrRemarks the hr_remarks value
	 */
	public void setHrRemarks (java.lang.String hrRemarks) {
		this.hrRemarks = hrRemarks;
	}



	/**
	 * Return the value associated with the column: finance_remarks
	 */
	public java.lang.String getFinanceRemarks () {
		return financeRemarks;
	}

	/**
	 * Set the value related to the column: finance_remarks
	 * @param financeRemarks the finance_remarks value
	 */
	public void setFinanceRemarks (java.lang.String financeRemarks) {
		this.financeRemarks = financeRemarks;
	}



	/**
	 * Return the value associated with the column: gm_remarks
	 */
	public java.lang.String getGmRemarks () {
		return gmRemarks;
	}

	/**
	 * Set the value related to the column: gm_remarks
	 * @param gmRemarks the gm_remarks value
	 */
	public void setGmRemarks (java.lang.String gmRemarks) {
		this.gmRemarks = gmRemarks;
	}



	/**
	 * Return the value associated with the column: approval_status
	 */
	public java.lang.String getApprovalStatus () {
		return approvalStatus;
	}

	/**
	 * Set the value related to the column: approval_status
	 * @param approvalStatus the approval_status value
	 */
	public void setApprovalStatus (java.lang.String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}



	/**
	 * Return the value associated with the column: check_no
	 */
	public java.lang.String getCheckNo () {
		return checkNo;
	}

	/**
	 * Set the value related to the column: check_no
	 * @param checkNo the check_no value
	 */
	public void setCheckNo (java.lang.String checkNo) {
		this.checkNo = checkNo;
	}



	/**
	 * Return the value associated with the column: check_date
	 */
	public java.util.Date getCheckDate () {
		return checkDate;
	}

	/**
	 * Set the value related to the column: check_date
	 * @param checkDate the check_date value
	 */
	public void setCheckDate (java.util.Date checkDate) {
		this.checkDate = checkDate;
	}



	/**
	 * Return the value associated with the column: check_amount
	 */
	public java.math.BigDecimal getCheckAmount () {
		return checkAmount;
	}

	/**
	 * Set the value related to the column: check_amount
	 * @param checkAmount the check_amount value
	 */
	public void setCheckAmount (java.math.BigDecimal checkAmount) {
		this.checkAmount = checkAmount;
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
	 * Return the value associated with the column: tax_amount
	 */
	public java.math.BigDecimal getTaxAmount () {
		return taxAmount;
	}

	/**
	 * Set the value related to the column: tax_amount
	 * @param taxAmount the tax_amount value
	 */
	public void setTaxAmount (java.math.BigDecimal taxAmount) {
		this.taxAmount = taxAmount;
	}



	/**
	 * Return the value associated with the column: erp_posting_date
	 */
	public java.util.Date getErpPostingDate () {
		return erpPostingDate;
	}

	/**
	 * Set the value related to the column: erp_posting_date
	 * @param erpPostingDate the erp_posting_date value
	 */
	public void setErpPostingDate (java.util.Date erpPostingDate) {
		this.erpPostingDate = erpPostingDate;
	}



	/**
	 * Return the value associated with the column: erp_uploading_date
	 */
	public java.util.Date getErpUploadingDate () {
		return erpUploadingDate;
	}

	/**
	 * Set the value related to the column: erp_uploading_date
	 * @param erpUploadingDate the erp_uploading_date value
	 */
	public void setErpUploadingDate (java.util.Date erpUploadingDate) {
		this.erpUploadingDate = erpUploadingDate;
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
	 * Return the value associated with the column: referral_details_id
	 */
	public jkt.hms.masters.business.ReferralPatientDetails getReferralDetails () {
		return referralDetails;
	}

	/**
	 * Set the value related to the column: referral_details_id
	 * @param referralDetails the referral_details_id value
	 */
	public void setReferralDetails (jkt.hms.masters.business.ReferralPatientDetails referralDetails) {
		this.referralDetails = referralDetails;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.ReferralPatientBilling)) return false;
		else {
			jkt.hms.masters.business.ReferralPatientBilling referralPatientBilling = (jkt.hms.masters.business.ReferralPatientBilling) obj;
			if (null == this.getId() || null == referralPatientBilling.getId()) return false;
			else return (this.getId().equals(referralPatientBilling.getId()));
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
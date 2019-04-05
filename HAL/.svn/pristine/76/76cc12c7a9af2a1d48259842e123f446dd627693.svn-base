package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_minor_work_detail
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="mas_minor_work_detail"
 */

public abstract class BaseMasMinorWorkDetail implements Serializable {

	public static String REF = "MasMinorWorkDetail";
	public static String PROP_ADMIN_NAME = "AdminName";
	public static String PROP_MINOR_WORK_DETAIL_TIME = "MinorWorkDetailTime";
	public static String PROP_ADMIN_APPROVAL_TIME = "AdminApprovalTime";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_COMPLETION_TIME = "CompletionTime";
	public static String PROP_MINOR_WORK_DETAIL_REMARKS = "MinorWorkDetailRemarks";
	public static String PROP_ALLOTMENT_AMOUNT = "AllotmentAmount";
	public static String PROP_MINOR_WORK_DETAIL_NO = "MinorWorkDetailNo";
	public static String PROP_ADMIN_APPROVAL_DATE = "AdminApprovalDate";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_AUTHORITY = "Authority";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_BALANCE = "Balance";
	public static String PROP_MINOR_WORK_DETAIL_ESTIMATED_COST = "MinorWorkDetailEstimatedCost";
	public static String PROP_DEPARTMENT_NAME = "DepartmentName";
	public static String PROP_PDC = "Pdc";
	public static String PROP_PROPOSAL_ID = "ProposalId";
	public static String PROP_COMPLETION_DATE = "CompletionDate";
	public static String PROP_FINANCIAL_YEAR = "FinancialYear";
	public static String PROP_MINOR_WORK_DETAIL = "MinorWorkDetail";
	public static String PROP_PROPOSAL_NO = "ProposalNo";
	public static String PROP_TOTAL_EXPENDITURE = "TotalExpenditure";
	public static String PROP_STATUS = "Status";
	public static String PROP_DATE_OF_COSTING_RECEIVED = "DateOfCostingReceived";
	public static String PROP_USER_COMMENTS = "UserComments";
	public static String PROP_ADMIN_APPROVAL_NO = "AdminApprovalNo";
	public static String PROP_ESTIMATED_DATE = "EstimatedDate";
	public static String PROP_ID = "Id";
	public static String PROP_WORK_TYPE = "WorkType";
	public static String PROP_MINOR_WORK_DETAIL_DATE = "MinorWorkDetailDate";
	public static String PROP_WORK_CATEGORY_ID = "WorkCategoryId";

	// constructors
	public BaseMasMinorWorkDetail() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasMinorWorkDetail(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseMasMinorWorkDetail(java.lang.Integer id,
			jkt.hms.masters.business.MasWorkType workType,
			java.lang.String lastChgBy, java.util.Date lastChgDate,
			java.lang.String lastChgTime, java.lang.String proposalNo) {

		this.setId(id);
		this.setWorkType(workType);
		this.setLastChgBy(lastChgBy);
		this.setLastChgDate(lastChgDate);
		this.setLastChgTime(lastChgTime);
		this.setProposalNo(proposalNo);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String minorWorkDetailNo;
	private java.util.Date minorWorkDetailDate;
	private java.lang.String minorWorkDetailTime;
	private java.lang.String workCategoryId;
	private java.lang.String minorWorkDetail;
	private java.lang.String minorWorkDetailEstimatedCost;
	private java.lang.String minorWorkDetailRemarks;
	private java.lang.String financialYear;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String adminApprovalNo;
	private java.util.Date adminApprovalDate;
	private java.lang.String adminApprovalTime;
	private java.lang.Integer pdc;
	private java.util.Date estimatedDate;
	private java.lang.String adminName;
	private java.util.Date completionDate;
	private java.lang.String completionTime;
	private java.lang.String status;
	private java.lang.String proposalNo;
	private java.lang.String departmentName;
	private java.lang.String userComments;
	private java.lang.Integer allotmentAmount;
	private java.lang.Integer totalExpenditure;
	private java.lang.Integer balance;
	private java.lang.Integer proposalId;
	private java.util.Date dateOfCostingReceived;
	private java.lang.String authority;

	// many to one
	private jkt.hms.masters.business.MasWorkType workType;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="minor_work_detail_id"
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
	 * Return the value associated with the column: minor_work_detail_no
	 */
	public java.lang.String getMinorWorkDetailNo() {
		return minorWorkDetailNo;
	}

	/**
	 * Set the value related to the column: minor_work_detail_no
	 * 
	 * @param minorWorkDetailNo
	 *            the minor_work_detail_no value
	 */
	public void setMinorWorkDetailNo(java.lang.String minorWorkDetailNo) {
		this.minorWorkDetailNo = minorWorkDetailNo;
	}

	/**
	 * Return the value associated with the column: minor_work_detail_date
	 */
	public java.util.Date getMinorWorkDetailDate() {
		return minorWorkDetailDate;
	}

	/**
	 * Set the value related to the column: minor_work_detail_date
	 * 
	 * @param minorWorkDetailDate
	 *            the minor_work_detail_date value
	 */
	public void setMinorWorkDetailDate(java.util.Date minorWorkDetailDate) {
		this.minorWorkDetailDate = minorWorkDetailDate;
	}

	/**
	 * Return the value associated with the column: minor_work_detail_time
	 */
	public java.lang.String getMinorWorkDetailTime() {
		return minorWorkDetailTime;
	}

	/**
	 * Set the value related to the column: minor_work_detail_time
	 * 
	 * @param minorWorkDetailTime
	 *            the minor_work_detail_time value
	 */
	public void setMinorWorkDetailTime(java.lang.String minorWorkDetailTime) {
		this.minorWorkDetailTime = minorWorkDetailTime;
	}

	/**
	 * Return the value associated with the column: work_category_id
	 */
	public java.lang.String getWorkCategoryId() {
		return workCategoryId;
	}

	/**
	 * Set the value related to the column: work_category_id
	 * 
	 * @param workCategoryId
	 *            the work_category_id value
	 */
	public void setWorkCategoryId(java.lang.String workCategoryId) {
		this.workCategoryId = workCategoryId;
	}

	/**
	 * Return the value associated with the column: minor_work_detail
	 */
	public java.lang.String getMinorWorkDetail() {
		return minorWorkDetail;
	}

	/**
	 * Set the value related to the column: minor_work_detail
	 * 
	 * @param minorWorkDetail
	 *            the minor_work_detail value
	 */
	public void setMinorWorkDetail(java.lang.String minorWorkDetail) {
		this.minorWorkDetail = minorWorkDetail;
	}

	/**
	 * Return the value associated with the column:
	 * minor_work_detail_estimated_cost
	 */
	public java.lang.String getMinorWorkDetailEstimatedCost() {
		return minorWorkDetailEstimatedCost;
	}

	/**
	 * Set the value related to the column: minor_work_detail_estimated_cost
	 * 
	 * @param minorWorkDetailEstimatedCost
	 *            the minor_work_detail_estimated_cost value
	 */
	public void setMinorWorkDetailEstimatedCost(
			java.lang.String minorWorkDetailEstimatedCost) {
		this.minorWorkDetailEstimatedCost = minorWorkDetailEstimatedCost;
	}

	/**
	 * Return the value associated with the column: minor_work_detail_remarks
	 */
	public java.lang.String getMinorWorkDetailRemarks() {
		return minorWorkDetailRemarks;
	}

	/**
	 * Set the value related to the column: minor_work_detail_remarks
	 * 
	 * @param minorWorkDetailRemarks
	 *            the minor_work_detail_remarks value
	 */
	public void setMinorWorkDetailRemarks(
			java.lang.String minorWorkDetailRemarks) {
		this.minorWorkDetailRemarks = minorWorkDetailRemarks;
	}

	/**
	 * Return the value associated with the column: financial_year
	 */
	public java.lang.String getFinancialYear() {
		return financialYear;
	}

	/**
	 * Set the value related to the column: financial_year
	 * 
	 * @param financialYear
	 *            the financial_year value
	 */
	public void setFinancialYear(java.lang.String financialYear) {
		this.financialYear = financialYear;
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
	 * Return the value associated with the column: admin_approval_no
	 */
	public java.lang.String getAdminApprovalNo() {
		return adminApprovalNo;
	}

	/**
	 * Set the value related to the column: admin_approval_no
	 * 
	 * @param adminApprovalNo
	 *            the admin_approval_no value
	 */
	public void setAdminApprovalNo(java.lang.String adminApprovalNo) {
		this.adminApprovalNo = adminApprovalNo;
	}

	/**
	 * Return the value associated with the column: admin_approval_date
	 */
	public java.util.Date getAdminApprovalDate() {
		return adminApprovalDate;
	}

	/**
	 * Set the value related to the column: admin_approval_date
	 * 
	 * @param adminApprovalDate
	 *            the admin_approval_date value
	 */
	public void setAdminApprovalDate(java.util.Date adminApprovalDate) {
		this.adminApprovalDate = adminApprovalDate;
	}

	/**
	 * Return the value associated with the column: admin_approval_time
	 */
	public java.lang.String getAdminApprovalTime() {
		return adminApprovalTime;
	}

	/**
	 * Set the value related to the column: admin_approval_time
	 * 
	 * @param adminApprovalTime
	 *            the admin_approval_time value
	 */
	public void setAdminApprovalTime(java.lang.String adminApprovalTime) {
		this.adminApprovalTime = adminApprovalTime;
	}

	/**
	 * Return the value associated with the column: pdc
	 */
	public java.lang.Integer getPdc() {
		return pdc;
	}

	/**
	 * Set the value related to the column: pdc
	 * 
	 * @param pdc
	 *            the pdc value
	 */
	public void setPdc(java.lang.Integer pdc) {
		this.pdc = pdc;
	}

	/**
	 * Return the value associated with the column: estimated_date
	 */
	public java.util.Date getEstimatedDate() {
		return estimatedDate;
	}

	/**
	 * Set the value related to the column: estimated_date
	 * 
	 * @param estimatedDate
	 *            the estimated_date value
	 */
	public void setEstimatedDate(java.util.Date estimatedDate) {
		this.estimatedDate = estimatedDate;
	}

	/**
	 * Return the value associated with the column: admin_name
	 */
	public java.lang.String getAdminName() {
		return adminName;
	}

	/**
	 * Set the value related to the column: admin_name
	 * 
	 * @param adminName
	 *            the admin_name value
	 */
	public void setAdminName(java.lang.String adminName) {
		this.adminName = adminName;
	}

	/**
	 * Return the value associated with the column: completion_date
	 */
	public java.util.Date getCompletionDate() {
		return completionDate;
	}

	/**
	 * Set the value related to the column: completion_date
	 * 
	 * @param completionDate
	 *            the completion_date value
	 */
	public void setCompletionDate(java.util.Date completionDate) {
		this.completionDate = completionDate;
	}

	/**
	 * Return the value associated with the column: completion_time
	 */
	public java.lang.String getCompletionTime() {
		return completionTime;
	}

	/**
	 * Set the value related to the column: completion_time
	 * 
	 * @param completionTime
	 *            the completion_time value
	 */
	public void setCompletionTime(java.lang.String completionTime) {
		this.completionTime = completionTime;
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
	 * Return the value associated with the column: proposal_no
	 */
	public java.lang.String getProposalNo() {
		return proposalNo;
	}

	/**
	 * Set the value related to the column: proposal_no
	 * 
	 * @param proposalNo
	 *            the proposal_no value
	 */
	public void setProposalNo(java.lang.String proposalNo) {
		this.proposalNo = proposalNo;
	}

	/**
	 * Return the value associated with the column: department_name
	 */
	public java.lang.String getDepartmentName() {
		return departmentName;
	}

	/**
	 * Set the value related to the column: department_name
	 * 
	 * @param departmentName
	 *            the department_name value
	 */
	public void setDepartmentName(java.lang.String departmentName) {
		this.departmentName = departmentName;
	}

	/**
	 * Return the value associated with the column: user_comments
	 */
	public java.lang.String getUserComments() {
		return userComments;
	}

	/**
	 * Set the value related to the column: user_comments
	 * 
	 * @param userComments
	 *            the user_comments value
	 */
	public void setUserComments(java.lang.String userComments) {
		this.userComments = userComments;
	}

	/**
	 * Return the value associated with the column: allotment_amount
	 */
	public java.lang.Integer getAllotmentAmount() {
		return allotmentAmount;
	}

	/**
	 * Set the value related to the column: allotment_amount
	 * 
	 * @param allotmentAmount
	 *            the allotment_amount value
	 */
	public void setAllotmentAmount(java.lang.Integer allotmentAmount) {
		this.allotmentAmount = allotmentAmount;
	}

	/**
	 * Return the value associated with the column: total_expenditure
	 */
	public java.lang.Integer getTotalExpenditure() {
		return totalExpenditure;
	}

	/**
	 * Set the value related to the column: total_expenditure
	 * 
	 * @param totalExpenditure
	 *            the total_expenditure value
	 */
	public void setTotalExpenditure(java.lang.Integer totalExpenditure) {
		this.totalExpenditure = totalExpenditure;
	}

	/**
	 * Return the value associated with the column: balance
	 */
	public java.lang.Integer getBalance() {
		return balance;
	}

	/**
	 * Set the value related to the column: balance
	 * 
	 * @param balance
	 *            the balance value
	 */
	public void setBalance(java.lang.Integer balance) {
		this.balance = balance;
	}

	/**
	 * Return the value associated with the column: proposal_id
	 */
	public java.lang.Integer getProposalId() {
		return proposalId;
	}

	/**
	 * Set the value related to the column: proposal_id
	 * 
	 * @param proposalId
	 *            the proposal_id value
	 */
	public void setProposalId(java.lang.Integer proposalId) {
		this.proposalId = proposalId;
	}

	/**
	 * Return the value associated with the column: date_of_costing_received
	 */
	public java.util.Date getDateOfCostingReceived() {
		return dateOfCostingReceived;
	}

	/**
	 * Set the value related to the column: date_of_costing_received
	 * 
	 * @param dateOfCostingReceived
	 *            the date_of_costing_received value
	 */
	public void setDateOfCostingReceived(java.util.Date dateOfCostingReceived) {
		this.dateOfCostingReceived = dateOfCostingReceived;
	}

	/**
	 * Return the value associated with the column: authority
	 */
	public java.lang.String getAuthority() {
		return authority;
	}

	/**
	 * Set the value related to the column: authority
	 * 
	 * @param authority
	 *            the authority value
	 */
	public void setAuthority(java.lang.String authority) {
		this.authority = authority;
	}

	/**
	 * Return the value associated with the column: work_type_id
	 */
	public jkt.hms.masters.business.MasWorkType getWorkType() {
		return workType;
	}

	/**
	 * Set the value related to the column: work_type_id
	 * 
	 * @param workType
	 *            the work_type_id value
	 */
	public void setWorkType(jkt.hms.masters.business.MasWorkType workType) {
		this.workType = workType;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MasMinorWorkDetail))
			return false;
		else {
			jkt.hms.masters.business.MasMinorWorkDetail masMinorWorkDetail = (jkt.hms.masters.business.MasMinorWorkDetail) obj;
			if (null == this.getId() || null == masMinorWorkDetail.getId())
				return false;
			else
				return (this.getId().equals(masMinorWorkDetail.getId()));
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
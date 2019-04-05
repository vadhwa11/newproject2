package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_minor_work_proposal
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="mas_minor_work_proposal"
 */

public abstract class BaseMasMinorWorkProposal implements Serializable {

	public static String REF = "MasMinorWorkProposal";
	public static String PROP_ESTIMATED_COST = "EstimatedCost";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_MINOR_WORK_DETAIL = "MinorWorkDetail";
	public static String PROP_JUSTIFICATION = "Justification";
	public static String PROP_STATUS = "Status";
	public static String PROP_MINOR_WORK_PROPOSAL_DATE = "MinorWorkProposalDate";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_CANCELLATION_REASON = "CancellationReason";
	public static String PROP_AUTHORITY = "Authority";
	public static String PROP_ID = "Id";
	public static String PROP_MINOR_WORK_PROPOSAL_NO = "MinorWorkProposalNo";
	public static String PROP_WORK_TYPE = "WorkType";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_WORK_CATEGORY_ID = "WorkCategoryId";

	// constructors
	public BaseMasMinorWorkProposal() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasMinorWorkProposal(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseMasMinorWorkProposal(java.lang.Integer id,
			jkt.hms.masters.business.MasDepartment department,
			jkt.hms.masters.business.MasWorkType workType,
			java.lang.String workCategoryId, java.lang.String lastChgBy,
			java.util.Date lastChgDate, java.lang.String lastChgTime) {

		this.setId(id);
		this.setDepartment(department);
		this.setWorkType(workType);
		this.setWorkCategoryId(workCategoryId);
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
	private java.lang.String minorWorkProposalNo;
	private java.util.Date minorWorkProposalDate;
	private java.lang.String workCategoryId;
	private java.lang.String minorWorkDetail;
	private java.lang.String justification;
	private java.lang.String cancellationReason;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;
	private java.lang.String estimatedCost;
	private java.lang.String authority;

	// many to one
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasWorkType workType;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="minor_work_proposal_id"
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
	 * Return the value associated with the column: minor_work_proposal_no
	 */
	public java.lang.String getMinorWorkProposalNo() {
		return minorWorkProposalNo;
	}

	/**
	 * Set the value related to the column: minor_work_proposal_no
	 * 
	 * @param minorWorkProposalNo
	 *            the minor_work_proposal_no value
	 */
	public void setMinorWorkProposalNo(java.lang.String minorWorkProposalNo) {
		this.minorWorkProposalNo = minorWorkProposalNo;
	}

	/**
	 * Return the value associated with the column: minor_work_proposal_date
	 */
	public java.util.Date getMinorWorkProposalDate() {
		return minorWorkProposalDate;
	}

	/**
	 * Set the value related to the column: minor_work_proposal_date
	 * 
	 * @param minorWorkProposalDate
	 *            the minor_work_proposal_date value
	 */
	public void setMinorWorkProposalDate(java.util.Date minorWorkProposalDate) {
		this.minorWorkProposalDate = minorWorkProposalDate;
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
	 * Return the value associated with the column: justification
	 */
	public java.lang.String getJustification() {
		return justification;
	}

	/**
	 * Set the value related to the column: justification
	 * 
	 * @param justification
	 *            the justification value
	 */
	public void setJustification(java.lang.String justification) {
		this.justification = justification;
	}

	/**
	 * Return the value associated with the column: cancellation_reason
	 */
	public java.lang.String getCancellationReason() {
		return cancellationReason;
	}

	/**
	 * Set the value related to the column: cancellation_reason
	 * 
	 * @param cancellationReason
	 *            the cancellation_reason value
	 */
	public void setCancellationReason(java.lang.String cancellationReason) {
		this.cancellationReason = cancellationReason;
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
	 * Return the value associated with the column: estimated_cost
	 */
	public java.lang.String getEstimatedCost() {
		return estimatedCost;
	}

	/**
	 * Set the value related to the column: estimated_cost
	 * 
	 * @param estimatedCost
	 *            the estimated_cost value
	 */
	public void setEstimatedCost(java.lang.String estimatedCost) {
		this.estimatedCost = estimatedCost;
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
		if (!(obj instanceof jkt.hms.masters.business.MasMinorWorkProposal))
			return false;
		else {
			jkt.hms.masters.business.MasMinorWorkProposal masMinorWorkProposal = (jkt.hms.masters.business.MasMinorWorkProposal) obj;
			if (null == this.getId() || null == masMinorWorkProposal.getId())
				return false;
			else
				return (this.getId().equals(masMinorWorkProposal.getId()));
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
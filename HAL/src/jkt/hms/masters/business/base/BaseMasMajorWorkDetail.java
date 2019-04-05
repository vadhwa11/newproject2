package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_major_work_detail
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="mas_major_work_detail"
 */

public abstract class BaseMasMajorWorkDetail implements Serializable {

	public static String REF = "MasMajorWorkDetail";
	public static String PROP_MAJOR_WORK_BOO_ASSEMBLED_ON = "MajorWorkBooAssembledOn";
	public static String PROP_LAST_CHANGED_DATE = "LastChangedDate";
	public static String PROP_MAJOR_WORK_FUND_REALESED_ON = "MajorWorkFundRealesedOn";
	public static String PROP_TYPE = "Type";
	public static String PROP_MAJOR_WORK_DETAIL = "MajorWorkDetail";
	public static String PROP_MAJOR_WORK_PDC = "MajorWorkPdc";
	public static String PROP_MAJOR_WORK_BPS_SENTFOR_AES_LETTER = "MajorWorkBpsSentforAesLetter";
	public static String PROP_MAJOR_WORK_WEEK = "MajorWorkWeek";
	public static String PROP_MAJOR_WORK_TENDER_COMPLETED_DATE = "MajorWorkTenderCompletedDate";
	public static String PROP_LAST_CHANGED_TIME = "LastChangedTime";
	public static String PROP_MAJOR_WORK_COMPLETED_ON = "MajorWorkCompletedOn";
	public static String PROP_STATUS_OF_RECORD = "StatusOfRecord";
	public static String PROP_MAJOR_WORK_PRESIDING_OFFICE = "MajorWorkPresidingOffice";
	public static String PROP_MAJOR_WORK_PROJECT_OFFICER = "MajorWorkProjectOfficer";
	public static String PROP_MAJOR_WORK_TENDER_ISSUED_ON = "MajorWorkTenderIssuedOn";
	public static String PROP_MAJOR_WORK_TO_BE_COMPLETE = "MajorWorkToBeComplete";
	public static String PROP_LAST_CHANGED_BY = "LastChangedBy";
	public static String PROP_MAJOR_WORK_ADMIN_APPROVAL_FWD_DATE = "MajorWorkAdminApprovalFwdDate";
	public static String PROP_MAJOR_WORK_COMMENCED_ON = "MajorWorkCommencedOn";
	public static String PROP_MAJOR_WORK_FUND_REALESE_AUTH = "MajorWorkFundRealeseAuth";
	public static String PROP_MAJOR_WORK_DETAIL_REMARKS = "MajorWorkDetailRemarks";
	public static String PROP_DEPARTMENT_NAME = "DepartmentName";
	public static String PROP_MAJOR_WORK_ESTIMATED_COST = "MajorWorkEstimatedCost";
	public static String PROP_MAJOR_WORK_HRO_DATE = "MajorWorkHroDate";
	public static String PROP_MAJOR_WORK_BPS_SENTFOR = "MajorWorkBpsSentfor";
	public static String PROP_MAJOR_WORK_ADMIN_APPROVAL_NO = "MajorWorkAdminApprovalNo";
	public static String PROP_RECEIVED_DATE = "ReceivedDate";
	public static String PROP_MAJOR_WORK_DETAIL_STATUS = "MajorWorkDetailStatus";
	public static String PROP_MAJOR_WORK_PROGRESS_REMARKS = "MajorWorkProgressRemarks";
	public static String PROP_MAJOR_WORK_COMPLETION_ON = "MajorWorkCompletionOn";
	public static String PROP_WORK_CATEGORY_NAME = "WorkCategoryName";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_MAJOR_WORK_DETAIL_NO = "MajorWorkDetailNo";
	public static String PROP_MAJOR_WORK_ADMIN_APPROVAL_DATE = "MajorWorkAdminApprovalDate";
	public static String PROP_MAJOR_WORK_REVISED_PD = "MajorWorkRevisedPd";
	public static String PROP_MAJOR_WORK_AES_RECEIVE_ON = "MajorWorkAesReceiveOn";
	public static String PROP_MAJOR_WORK_ADMIN_APPROVAL_FWD_LETTER = "MajorWorkAdminApprovalFwdLetter";
	public static String PROP_MAJOR_WORK_DETAIL_DATE = "MajorWorkDetailDate";
	public static String PROP_MAJOR_WORK_TENDER_ACTION_INHAND = "MajorWorkTenderActionInhand";
	public static String PROP_MAJOR_WORK_HRO_NO = "MajorWorkHroNo";
	public static String PROP_ID = "Id";
	public static String PROP_WORK_TYPE = "WorkType";
	public static String PROP_PENDING_SCRUITANY_AT = "PendingScruitanyAt";
	public static String PROP_PENDING_SCRUTANY_DATE = "PendingScrutanyDate";
	public static String PROP_MAJOR_WORK_PROGRESS_PERCENTAGE = "MajorWorkProgressPercentage";
	public static String PROP_MAJOR_WORK_DETAIL_TIME = "MajorWorkDetailTime";

	// constructors
	public BaseMasMajorWorkDetail() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasMajorWorkDetail(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String majorWorkDetailNo;
	private java.util.Date majorWorkDetailDate;
	private java.lang.String majorWorkDetailTime;
	private java.lang.String workCategoryName;
	private java.lang.String majorWorkDetail;
	private java.lang.String majorWorkDetailRemarks;
	private java.lang.String lastChangedBy;
	private java.util.Date lastChangedDate;
	private java.lang.String lastChangedTime;
	private java.lang.String majorWorkHroNo;
	private java.util.Date majorWorkHroDate;
	private java.util.Date majorWorkBooAssembledOn;
	private java.util.Date majorWorkToBeComplete;
	private java.lang.String majorWorkPresidingOffice;
	private java.util.Date majorWorkCompletedOn;
	private java.lang.String majorWorkBpsSentforAesLetter;
	private java.util.Date majorWorkBpsSentfor;
	private java.util.Date majorWorkAesReceiveOn;
	private java.lang.String majorWorkEstimatedCost;
	private java.lang.String majorWorkAdminApprovalNo;
	private java.util.Date majorWorkAdminApprovalDate;
	private java.lang.String majorWorkAdminApprovalFwdLetter;
	private java.util.Date majorWorkAdminApprovalFwdDate;
	private java.lang.String majorWorkFundRealeseAuth;
	private java.util.Date majorWorkFundRealesedOn;
	private java.lang.Integer majorWorkWeek;
	private java.util.Date majorWorkPdc;
	private java.util.Date majorWorkRevisedPd;
	private java.lang.String majorWorkTenderActionInhand;
	private java.util.Date majorWorkTenderIssuedOn;
	private java.util.Date majorWorkTenderCompletedDate;
	private java.lang.String majorWorkProjectOfficer;
	private java.math.BigDecimal majorWorkProgressPercentage;
	private java.lang.String majorWorkProgressRemarks;
	private java.util.Date majorWorkCompletionOn;
	private java.util.Date majorWorkCommencedOn;
	private java.lang.String type;
	private java.lang.String pendingScruitanyAt;
	private java.util.Date pendingScrutanyDate;
	private java.util.Date receivedDate;
	private java.lang.String departmentName;
	private java.lang.String statusOfRecord;

	// many to one
	private jkt.hms.masters.business.MasEmployee employee;
	private jkt.hms.masters.business.MasWorkType workType;
	private jkt.hms.masters.business.MajorWorkStatus majorWorkDetailStatus;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="major_work_detail_id"
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
	 * Return the value associated with the column: major_work_detail_no
	 */
	public java.lang.String getMajorWorkDetailNo() {
		return majorWorkDetailNo;
	}

	/**
	 * Set the value related to the column: major_work_detail_no
	 * 
	 * @param majorWorkDetailNo
	 *            the major_work_detail_no value
	 */
	public void setMajorWorkDetailNo(java.lang.String majorWorkDetailNo) {
		this.majorWorkDetailNo = majorWorkDetailNo;
	}

	/**
	 * Return the value associated with the column: major_work_detail_date
	 */
	public java.util.Date getMajorWorkDetailDate() {
		return majorWorkDetailDate;
	}

	/**
	 * Set the value related to the column: major_work_detail_date
	 * 
	 * @param majorWorkDetailDate
	 *            the major_work_detail_date value
	 */
	public void setMajorWorkDetailDate(java.util.Date majorWorkDetailDate) {
		this.majorWorkDetailDate = majorWorkDetailDate;
	}

	/**
	 * Return the value associated with the column: major_work_detail_time
	 */
	public java.lang.String getMajorWorkDetailTime() {
		return majorWorkDetailTime;
	}

	/**
	 * Set the value related to the column: major_work_detail_time
	 * 
	 * @param majorWorkDetailTime
	 *            the major_work_detail_time value
	 */
	public void setMajorWorkDetailTime(java.lang.String majorWorkDetailTime) {
		this.majorWorkDetailTime = majorWorkDetailTime;
	}

	/**
	 * Return the value associated with the column: work_category_name
	 */
	public java.lang.String getWorkCategoryName() {
		return workCategoryName;
	}

	/**
	 * Set the value related to the column: work_category_name
	 * 
	 * @param workCategoryName
	 *            the work_category_name value
	 */
	public void setWorkCategoryName(java.lang.String workCategoryName) {
		this.workCategoryName = workCategoryName;
	}

	/**
	 * Return the value associated with the column: major_work_detail
	 */
	public java.lang.String getMajorWorkDetail() {
		return majorWorkDetail;
	}

	/**
	 * Set the value related to the column: major_work_detail
	 * 
	 * @param majorWorkDetail
	 *            the major_work_detail value
	 */
	public void setMajorWorkDetail(java.lang.String majorWorkDetail) {
		this.majorWorkDetail = majorWorkDetail;
	}

	/**
	 * Return the value associated with the column: major_work_detail_remarks
	 */
	public java.lang.String getMajorWorkDetailRemarks() {
		return majorWorkDetailRemarks;
	}

	/**
	 * Set the value related to the column: major_work_detail_remarks
	 * 
	 * @param majorWorkDetailRemarks
	 *            the major_work_detail_remarks value
	 */
	public void setMajorWorkDetailRemarks(
			java.lang.String majorWorkDetailRemarks) {
		this.majorWorkDetailRemarks = majorWorkDetailRemarks;
	}

	/**
	 * Return the value associated with the column: last_changed_by
	 */
	public java.lang.String getLastChangedBy() {
		return lastChangedBy;
	}

	/**
	 * Set the value related to the column: last_changed_by
	 * 
	 * @param lastChangedBy
	 *            the last_changed_by value
	 */
	public void setLastChangedBy(java.lang.String lastChangedBy) {
		this.lastChangedBy = lastChangedBy;
	}

	/**
	 * Return the value associated with the column: last_changed_date
	 */
	public java.util.Date getLastChangedDate() {
		return lastChangedDate;
	}

	/**
	 * Set the value related to the column: last_changed_date
	 * 
	 * @param lastChangedDate
	 *            the last_changed_date value
	 */
	public void setLastChangedDate(java.util.Date lastChangedDate) {
		this.lastChangedDate = lastChangedDate;
	}

	/**
	 * Return the value associated with the column: last_changed_time
	 */
	public java.lang.String getLastChangedTime() {
		return lastChangedTime;
	}

	/**
	 * Set the value related to the column: last_changed_time
	 * 
	 * @param lastChangedTime
	 *            the last_changed_time value
	 */
	public void setLastChangedTime(java.lang.String lastChangedTime) {
		this.lastChangedTime = lastChangedTime;
	}

	/**
	 * Return the value associated with the column: major_work_hro_no
	 */
	public java.lang.String getMajorWorkHroNo() {
		return majorWorkHroNo;
	}

	/**
	 * Set the value related to the column: major_work_hro_no
	 * 
	 * @param majorWorkHroNo
	 *            the major_work_hro_no value
	 */
	public void setMajorWorkHroNo(java.lang.String majorWorkHroNo) {
		this.majorWorkHroNo = majorWorkHroNo;
	}

	/**
	 * Return the value associated with the column: major_work_hro_date
	 */
	public java.util.Date getMajorWorkHroDate() {
		return majorWorkHroDate;
	}

	/**
	 * Set the value related to the column: major_work_hro_date
	 * 
	 * @param majorWorkHroDate
	 *            the major_work_hro_date value
	 */
	public void setMajorWorkHroDate(java.util.Date majorWorkHroDate) {
		this.majorWorkHroDate = majorWorkHroDate;
	}

	/**
	 * Return the value associated with the column: major_work_Boo_assembled_on
	 */
	public java.util.Date getMajorWorkBooAssembledOn() {
		return majorWorkBooAssembledOn;
	}

	/**
	 * Set the value related to the column: major_work_Boo_assembled_on
	 * 
	 * @param majorWorkBooAssembledOn
	 *            the major_work_Boo_assembled_on value
	 */
	public void setMajorWorkBooAssembledOn(
			java.util.Date majorWorkBooAssembledOn) {
		this.majorWorkBooAssembledOn = majorWorkBooAssembledOn;
	}

	/**
	 * Return the value associated with the column: major_work_to_be_complete
	 */
	public java.util.Date getMajorWorkToBeComplete() {
		return majorWorkToBeComplete;
	}

	/**
	 * Set the value related to the column: major_work_to_be_complete
	 * 
	 * @param majorWorkToBeComplete
	 *            the major_work_to_be_complete value
	 */
	public void setMajorWorkToBeComplete(java.util.Date majorWorkToBeComplete) {
		this.majorWorkToBeComplete = majorWorkToBeComplete;
	}

	/**
	 * Return the value associated with the column: major_work_presiding_office
	 */
	public java.lang.String getMajorWorkPresidingOffice() {
		return majorWorkPresidingOffice;
	}

	/**
	 * Set the value related to the column: major_work_presiding_office
	 * 
	 * @param majorWorkPresidingOffice
	 *            the major_work_presiding_office value
	 */
	public void setMajorWorkPresidingOffice(
			java.lang.String majorWorkPresidingOffice) {
		this.majorWorkPresidingOffice = majorWorkPresidingOffice;
	}

	/**
	 * Return the value associated with the column: major_work_completed_on
	 */
	public java.util.Date getMajorWorkCompletedOn() {
		return majorWorkCompletedOn;
	}

	/**
	 * Set the value related to the column: major_work_completed_on
	 * 
	 * @param majorWorkCompletedOn
	 *            the major_work_completed_on value
	 */
	public void setMajorWorkCompletedOn(java.util.Date majorWorkCompletedOn) {
		this.majorWorkCompletedOn = majorWorkCompletedOn;
	}

	/**
	 * Return the value associated with the column:
	 * major_work_bps_sentfor_aes_letter
	 */
	public java.lang.String getMajorWorkBpsSentforAesLetter() {
		return majorWorkBpsSentforAesLetter;
	}

	/**
	 * Set the value related to the column: major_work_bps_sentfor_aes_letter
	 * 
	 * @param majorWorkBpsSentforAesLetter
	 *            the major_work_bps_sentfor_aes_letter value
	 */
	public void setMajorWorkBpsSentforAesLetter(
			java.lang.String majorWorkBpsSentforAesLetter) {
		this.majorWorkBpsSentforAesLetter = majorWorkBpsSentforAesLetter;
	}

	/**
	 * Return the value associated with the column: major_work_bps_sentfor
	 */
	public java.util.Date getMajorWorkBpsSentfor() {
		return majorWorkBpsSentfor;
	}

	/**
	 * Set the value related to the column: major_work_bps_sentfor
	 * 
	 * @param majorWorkBpsSentfor
	 *            the major_work_bps_sentfor value
	 */
	public void setMajorWorkBpsSentfor(java.util.Date majorWorkBpsSentfor) {
		this.majorWorkBpsSentfor = majorWorkBpsSentfor;
	}

	/**
	 * Return the value associated with the column: major_work_aes_receive_on
	 */
	public java.util.Date getMajorWorkAesReceiveOn() {
		return majorWorkAesReceiveOn;
	}

	/**
	 * Set the value related to the column: major_work_aes_receive_on
	 * 
	 * @param majorWorkAesReceiveOn
	 *            the major_work_aes_receive_on value
	 */
	public void setMajorWorkAesReceiveOn(java.util.Date majorWorkAesReceiveOn) {
		this.majorWorkAesReceiveOn = majorWorkAesReceiveOn;
	}

	/**
	 * Return the value associated with the column: major_work_estimated_cost
	 */
	public java.lang.String getMajorWorkEstimatedCost() {
		return majorWorkEstimatedCost;
	}

	/**
	 * Set the value related to the column: major_work_estimated_cost
	 * 
	 * @param majorWorkEstimatedCost
	 *            the major_work_estimated_cost value
	 */
	public void setMajorWorkEstimatedCost(
			java.lang.String majorWorkEstimatedCost) {
		this.majorWorkEstimatedCost = majorWorkEstimatedCost;
	}

	/**
	 * Return the value associated with the column: major_work_admin_approval_no
	 */
	public java.lang.String getMajorWorkAdminApprovalNo() {
		return majorWorkAdminApprovalNo;
	}

	/**
	 * Set the value related to the column: major_work_admin_approval_no
	 * 
	 * @param majorWorkAdminApprovalNo
	 *            the major_work_admin_approval_no value
	 */
	public void setMajorWorkAdminApprovalNo(
			java.lang.String majorWorkAdminApprovalNo) {
		this.majorWorkAdminApprovalNo = majorWorkAdminApprovalNo;
	}

	/**
	 * Return the value associated with the column:
	 * major_work_admin_approval_date
	 */
	public java.util.Date getMajorWorkAdminApprovalDate() {
		return majorWorkAdminApprovalDate;
	}

	/**
	 * Set the value related to the column: major_work_admin_approval_date
	 * 
	 * @param majorWorkAdminApprovalDate
	 *            the major_work_admin_approval_date value
	 */
	public void setMajorWorkAdminApprovalDate(
			java.util.Date majorWorkAdminApprovalDate) {
		this.majorWorkAdminApprovalDate = majorWorkAdminApprovalDate;
	}

	/**
	 * Return the value associated with the column:
	 * major_work_admin_approval_fwd_letter
	 */
	public java.lang.String getMajorWorkAdminApprovalFwdLetter() {
		return majorWorkAdminApprovalFwdLetter;
	}

	/**
	 * Set the value related to the column: major_work_admin_approval_fwd_letter
	 * 
	 * @param majorWorkAdminApprovalFwdLetter
	 *            the major_work_admin_approval_fwd_letter value
	 */
	public void setMajorWorkAdminApprovalFwdLetter(
			java.lang.String majorWorkAdminApprovalFwdLetter) {
		this.majorWorkAdminApprovalFwdLetter = majorWorkAdminApprovalFwdLetter;
	}

	/**
	 * Return the value associated with the column:
	 * major_work_admin_approval_fwd_date
	 */
	public java.util.Date getMajorWorkAdminApprovalFwdDate() {
		return majorWorkAdminApprovalFwdDate;
	}

	/**
	 * Set the value related to the column: major_work_admin_approval_fwd_date
	 * 
	 * @param majorWorkAdminApprovalFwdDate
	 *            the major_work_admin_approval_fwd_date value
	 */
	public void setMajorWorkAdminApprovalFwdDate(
			java.util.Date majorWorkAdminApprovalFwdDate) {
		this.majorWorkAdminApprovalFwdDate = majorWorkAdminApprovalFwdDate;
	}

	/**
	 * Return the value associated with the column: major_work_fund_realese_auth
	 */
	public java.lang.String getMajorWorkFundRealeseAuth() {
		return majorWorkFundRealeseAuth;
	}

	/**
	 * Set the value related to the column: major_work_fund_realese_auth
	 * 
	 * @param majorWorkFundRealeseAuth
	 *            the major_work_fund_realese_auth value
	 */
	public void setMajorWorkFundRealeseAuth(
			java.lang.String majorWorkFundRealeseAuth) {
		this.majorWorkFundRealeseAuth = majorWorkFundRealeseAuth;
	}

	/**
	 * Return the value associated with the column: major_work_fund_realesed_on
	 */
	public java.util.Date getMajorWorkFundRealesedOn() {
		return majorWorkFundRealesedOn;
	}

	/**
	 * Set the value related to the column: major_work_fund_realesed_on
	 * 
	 * @param majorWorkFundRealesedOn
	 *            the major_work_fund_realesed_on value
	 */
	public void setMajorWorkFundRealesedOn(
			java.util.Date majorWorkFundRealesedOn) {
		this.majorWorkFundRealesedOn = majorWorkFundRealesedOn;
	}

	/**
	 * Return the value associated with the column: major_work_week
	 */
	public java.lang.Integer getMajorWorkWeek() {
		return majorWorkWeek;
	}

	/**
	 * Set the value related to the column: major_work_week
	 * 
	 * @param majorWorkWeek
	 *            the major_work_week value
	 */
	public void setMajorWorkWeek(java.lang.Integer majorWorkWeek) {
		this.majorWorkWeek = majorWorkWeek;
	}

	/**
	 * Return the value associated with the column: major_work_pdc
	 */
	public java.util.Date getMajorWorkPdc() {
		return majorWorkPdc;
	}

	/**
	 * Set the value related to the column: major_work_pdc
	 * 
	 * @param majorWorkPdc
	 *            the major_work_pdc value
	 */
	public void setMajorWorkPdc(java.util.Date majorWorkPdc) {
		this.majorWorkPdc = majorWorkPdc;
	}

	/**
	 * Return the value associated with the column: major_work_revised_pd
	 */
	public java.util.Date getMajorWorkRevisedPd() {
		return majorWorkRevisedPd;
	}

	/**
	 * Set the value related to the column: major_work_revised_pd
	 * 
	 * @param majorWorkRevisedPd
	 *            the major_work_revised_pd value
	 */
	public void setMajorWorkRevisedPd(java.util.Date majorWorkRevisedPd) {
		this.majorWorkRevisedPd = majorWorkRevisedPd;
	}

	/**
	 * Return the value associated with the column:
	 * major_work_tender_action_inhand
	 */
	public java.lang.String getMajorWorkTenderActionInhand() {
		return majorWorkTenderActionInhand;
	}

	/**
	 * Set the value related to the column: major_work_tender_action_inhand
	 * 
	 * @param majorWorkTenderActionInhand
	 *            the major_work_tender_action_inhand value
	 */
	public void setMajorWorkTenderActionInhand(
			java.lang.String majorWorkTenderActionInhand) {
		this.majorWorkTenderActionInhand = majorWorkTenderActionInhand;
	}

	/**
	 * Return the value associated with the column: major_work_tender_issued_on
	 */
	public java.util.Date getMajorWorkTenderIssuedOn() {
		return majorWorkTenderIssuedOn;
	}

	/**
	 * Set the value related to the column: major_work_tender_issued_on
	 * 
	 * @param majorWorkTenderIssuedOn
	 *            the major_work_tender_issued_on value
	 */
	public void setMajorWorkTenderIssuedOn(
			java.util.Date majorWorkTenderIssuedOn) {
		this.majorWorkTenderIssuedOn = majorWorkTenderIssuedOn;
	}

	/**
	 * Return the value associated with the column:
	 * major_work_tender_completed_date
	 */
	public java.util.Date getMajorWorkTenderCompletedDate() {
		return majorWorkTenderCompletedDate;
	}

	/**
	 * Set the value related to the column: major_work_tender_completed_date
	 * 
	 * @param majorWorkTenderCompletedDate
	 *            the major_work_tender_completed_date value
	 */
	public void setMajorWorkTenderCompletedDate(
			java.util.Date majorWorkTenderCompletedDate) {
		this.majorWorkTenderCompletedDate = majorWorkTenderCompletedDate;
	}

	/**
	 * Return the value associated with the column: major_work_project_officer
	 */
	public java.lang.String getMajorWorkProjectOfficer() {
		return majorWorkProjectOfficer;
	}

	/**
	 * Set the value related to the column: major_work_project_officer
	 * 
	 * @param majorWorkProjectOfficer
	 *            the major_work_project_officer value
	 */
	public void setMajorWorkProjectOfficer(
			java.lang.String majorWorkProjectOfficer) {
		this.majorWorkProjectOfficer = majorWorkProjectOfficer;
	}

	/**
	 * Return the value associated with the column:
	 * major_work_progress_percentage
	 */
	public java.math.BigDecimal getMajorWorkProgressPercentage() {
		return majorWorkProgressPercentage;
	}

	/**
	 * Set the value related to the column: major_work_progress_percentage
	 * 
	 * @param majorWorkProgressPercentage
	 *            the major_work_progress_percentage value
	 */
	public void setMajorWorkProgressPercentage(
			java.math.BigDecimal majorWorkProgressPercentage) {
		this.majorWorkProgressPercentage = majorWorkProgressPercentage;
	}

	/**
	 * Return the value associated with the column: major_work_progress_remarks
	 */
	public java.lang.String getMajorWorkProgressRemarks() {
		return majorWorkProgressRemarks;
	}

	/**
	 * Set the value related to the column: major_work_progress_remarks
	 * 
	 * @param majorWorkProgressRemarks
	 *            the major_work_progress_remarks value
	 */
	public void setMajorWorkProgressRemarks(
			java.lang.String majorWorkProgressRemarks) {
		this.majorWorkProgressRemarks = majorWorkProgressRemarks;
	}

	/**
	 * Return the value associated with the column: major_work_completion_on
	 */
	public java.util.Date getMajorWorkCompletionOn() {
		return majorWorkCompletionOn;
	}

	/**
	 * Set the value related to the column: major_work_completion_on
	 * 
	 * @param majorWorkCompletionOn
	 *            the major_work_completion_on value
	 */
	public void setMajorWorkCompletionOn(java.util.Date majorWorkCompletionOn) {
		this.majorWorkCompletionOn = majorWorkCompletionOn;
	}

	/**
	 * Return the value associated with the column: major_work_commenced_on
	 */
	public java.util.Date getMajorWorkCommencedOn() {
		return majorWorkCommencedOn;
	}

	/**
	 * Set the value related to the column: major_work_commenced_on
	 * 
	 * @param majorWorkCommencedOn
	 *            the major_work_commenced_on value
	 */
	public void setMajorWorkCommencedOn(java.util.Date majorWorkCommencedOn) {
		this.majorWorkCommencedOn = majorWorkCommencedOn;
	}

	/**
	 * Return the value associated with the column: type
	 */
	public java.lang.String getType() {
		return type;
	}

	/**
	 * Set the value related to the column: type
	 * 
	 * @param type
	 *            the type value
	 */
	public void setType(java.lang.String type) {
		this.type = type;
	}

	/**
	 * Return the value associated with the column: pending_scruitany_at
	 */
	public java.lang.String getPendingScruitanyAt() {
		return pendingScruitanyAt;
	}

	/**
	 * Set the value related to the column: pending_scruitany_at
	 * 
	 * @param pendingScruitanyAt
	 *            the pending_scruitany_at value
	 */
	public void setPendingScruitanyAt(java.lang.String pendingScruitanyAt) {
		this.pendingScruitanyAt = pendingScruitanyAt;
	}

	/**
	 * Return the value associated with the column: pending_scrutany_date
	 */
	public java.util.Date getPendingScrutanyDate() {
		return pendingScrutanyDate;
	}

	/**
	 * Set the value related to the column: pending_scrutany_date
	 * 
	 * @param pendingScrutanyDate
	 *            the pending_scrutany_date value
	 */
	public void setPendingScrutanyDate(java.util.Date pendingScrutanyDate) {
		this.pendingScrutanyDate = pendingScrutanyDate;
	}

	/**
	 * Return the value associated with the column: received_date
	 */
	public java.util.Date getReceivedDate() {
		return receivedDate;
	}

	/**
	 * Set the value related to the column: received_date
	 * 
	 * @param receivedDate
	 *            the received_date value
	 */
	public void setReceivedDate(java.util.Date receivedDate) {
		this.receivedDate = receivedDate;
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
	 * Return the value associated with the column: status_of_record
	 */
	public java.lang.String getStatusOfRecord() {
		return statusOfRecord;
	}

	/**
	 * Set the value related to the column: status_of_record
	 * 
	 * @param statusOfRecord
	 *            the status_of_record value
	 */
	public void setStatusOfRecord(java.lang.String statusOfRecord) {
		this.statusOfRecord = statusOfRecord;
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

	/**
	 * Return the value associated with the column: major_work_detail_status
	 */
	public jkt.hms.masters.business.MajorWorkStatus getMajorWorkDetailStatus() {
		return majorWorkDetailStatus;
	}

	/**
	 * Set the value related to the column: major_work_detail_status
	 * 
	 * @param majorWorkDetailStatus
	 *            the major_work_detail_status value
	 */
	public void setMajorWorkDetailStatus(
			jkt.hms.masters.business.MajorWorkStatus majorWorkDetailStatus) {
		this.majorWorkDetailStatus = majorWorkDetailStatus;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MasMajorWorkDetail))
			return false;
		else {
			jkt.hms.masters.business.MasMajorWorkDetail masMajorWorkDetail = (jkt.hms.masters.business.MasMajorWorkDetail) obj;
			if (null == this.getId() || null == masMajorWorkDetail.getId())
				return false;
			else
				return (this.getId().equals(masMajorWorkDetail.getId()));
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
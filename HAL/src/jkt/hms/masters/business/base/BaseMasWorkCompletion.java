package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_work_completion
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="mas_work_completion"
 */

public abstract class BaseMasWorkCompletion implements Serializable {

	public static String REF = "MasWorkCompletion";
	public static String PROP_PDC = "pdc";
	public static String PROP_COST_OF_ITEMS = "CostOfItems";
	public static String PROP_ALLOCATED_TO = "AllocatedTo";
	public static String PROP_LST_CHANGED_BY = "LstChangedBy";
	public static String PROP_COMPLETION_DATE = "CompletionDate";
	public static String PROP_COMPLETION_TIME = "CompletionTime";
	public static String PROP_MAN_HRS_SPENT = "ManHrsSpent";
	public static String PROP_TOTAL_COST = "TotalCost";
	public static String PROP_DOCKET_NO = "DocketNo";
	public static String PROP_COMPLAINT_ATTENDED_TIME = "ComplaintAttendedTime";
	public static String PROP_LST_CHANGED_TIME = "LstChangedTime";
	public static String PROP_STATUS = "Status";
	public static String PROP_COMPLAINT_ATTEDNDED_DATE = "ComplaintAttedndedDate";
	public static String PROP_ID = "Id";
	public static String PROP_COMPLAINT = "Complaint";
	public static String PROP_LST_CHANGED_DATE = "LstChangedDate";
	public static String PROP_ADMIN_REMARKS = "AdminRemarks";

	// constructors
	public BaseMasWorkCompletion() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasWorkCompletion(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date completionDate;
	private java.lang.String completionTime;
	private java.lang.String allocatedTo;
	private java.lang.String manHrsSpent;
	private java.math.BigDecimal costOfItems;
	private java.math.BigDecimal totalCost;
	private java.lang.String docketNo;
	private java.lang.String adminRemarks;
	private java.lang.String lstChangedBy;
	private java.util.Date lstChangedDate;
	private java.lang.String lstChangedTime;
	private java.lang.String status;
	private java.util.Date complaintAttedndedDate;
	private java.lang.String complaintAttendedTime;
	private java.util.Date pdc;

	// many to one
	private jkt.hms.masters.business.MasComplaintRegister complaint;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="work_completion_id"
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
	 * Return the value associated with the column: allocated_to
	 */
	public java.lang.String getAllocatedTo() {
		return allocatedTo;
	}

	/**
	 * Set the value related to the column: allocated_to
	 * 
	 * @param allocatedTo
	 *            the allocated_to value
	 */
	public void setAllocatedTo(java.lang.String allocatedTo) {
		this.allocatedTo = allocatedTo;
	}

	/**
	 * Return the value associated with the column: man_hrs_spent
	 */
	public java.lang.String getManHrsSpent() {
		return manHrsSpent;
	}

	/**
	 * Set the value related to the column: man_hrs_spent
	 * 
	 * @param manHrsSpent
	 *            the man_hrs_spent value
	 */
	public void setManHrsSpent(java.lang.String manHrsSpent) {
		this.manHrsSpent = manHrsSpent;
	}

	/**
	 * Return the value associated with the column: cost_of_items
	 */
	public java.math.BigDecimal getCostOfItems() {
		return costOfItems;
	}

	/**
	 * Set the value related to the column: cost_of_items
	 * 
	 * @param costOfItems
	 *            the cost_of_items value
	 */
	public void setCostOfItems(java.math.BigDecimal costOfItems) {
		this.costOfItems = costOfItems;
	}

	/**
	 * Return the value associated with the column: total_cost
	 */
	public java.math.BigDecimal getTotalCost() {
		return totalCost;
	}

	/**
	 * Set the value related to the column: total_cost
	 * 
	 * @param totalCost
	 *            the total_cost value
	 */
	public void setTotalCost(java.math.BigDecimal totalCost) {
		this.totalCost = totalCost;
	}

	/**
	 * Return the value associated with the column: docket_no
	 */
	public java.lang.String getDocketNo() {
		return docketNo;
	}

	/**
	 * Set the value related to the column: docket_no
	 * 
	 * @param docketNo
	 *            the docket_no value
	 */
	public void setDocketNo(java.lang.String docketNo) {
		this.docketNo = docketNo;
	}

	/**
	 * Return the value associated with the column: admin_remarks
	 */
	public java.lang.String getAdminRemarks() {
		return adminRemarks;
	}

	/**
	 * Set the value related to the column: admin_remarks
	 * 
	 * @param adminRemarks
	 *            the admin_remarks value
	 */
	public void setAdminRemarks(java.lang.String adminRemarks) {
		this.adminRemarks = adminRemarks;
	}

	/**
	 * Return the value associated with the column: lst_changed_by
	 */
	public java.lang.String getLstChangedBy() {
		return lstChangedBy;
	}

	/**
	 * Set the value related to the column: lst_changed_by
	 * 
	 * @param lstChangedBy
	 *            the lst_changed_by value
	 */
	public void setLstChangedBy(java.lang.String lstChangedBy) {
		this.lstChangedBy = lstChangedBy;
	}

	/**
	 * Return the value associated with the column: lst_changed_date
	 */
	public java.util.Date getLstChangedDate() {
		return lstChangedDate;
	}

	/**
	 * Set the value related to the column: lst_changed_date
	 * 
	 * @param lstChangedDate
	 *            the lst_changed_date value
	 */
	public void setLstChangedDate(java.util.Date lstChangedDate) {
		this.lstChangedDate = lstChangedDate;
	}

	/**
	 * Return the value associated with the column: lst_changed_time
	 */
	public java.lang.String getLstChangedTime() {
		return lstChangedTime;
	}

	/**
	 * Set the value related to the column: lst_changed_time
	 * 
	 * @param lstChangedTime
	 *            the lst_changed_time value
	 */
	public void setLstChangedTime(java.lang.String lstChangedTime) {
		this.lstChangedTime = lstChangedTime;
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
	 * Return the value associated with the column: complaint_attednded_date
	 */
	public java.util.Date getComplaintAttedndedDate() {
		return complaintAttedndedDate;
	}

	/**
	 * Set the value related to the column: complaint_attednded_date
	 * 
	 * @param complaintAttedndedDate
	 *            the complaint_attednded_date value
	 */
	public void setComplaintAttedndedDate(java.util.Date complaintAttedndedDate) {
		this.complaintAttedndedDate = complaintAttedndedDate;
	}

	/**
	 * Return the value associated with the column: complaint_attended_time
	 */
	public java.lang.String getComplaintAttendedTime() {
		return complaintAttendedTime;
	}

	/**
	 * Set the value related to the column: complaint_attended_time
	 * 
	 * @param complaintAttendedTime
	 *            the complaint_attended_time value
	 */
	public void setComplaintAttendedTime(java.lang.String complaintAttendedTime) {
		this.complaintAttendedTime = complaintAttendedTime;
	}

	/**
	 * Return the value associated with the column: pdc
	 */
	public java.util.Date getPdc() {
		return pdc;
	}

	/**
	 * Set the value related to the column: pdc
	 * 
	 * @param pdc
	 *            the pdc value
	 */
	public void setPdc(java.util.Date pdc) {
		this.pdc = pdc;
	}

	/**
	 * Return the value associated with the column: complaint_register_id
	 */
	public jkt.hms.masters.business.MasComplaintRegister getComplaint() {
		return complaint;
	}

	/**
	 * Set the value related to the column: complaint_register_id
	 * 
	 * @param complaint
	 *            the complaint_register_id value
	 */
	public void setComplaint(
			jkt.hms.masters.business.MasComplaintRegister complaint) {
		this.complaint = complaint;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MasWorkCompletion))
			return false;
		else {
			jkt.hms.masters.business.MasWorkCompletion masWorkCompletion = (jkt.hms.masters.business.MasWorkCompletion) obj;
			if (null == this.getId() || null == masWorkCompletion.getId())
				return false;
			else
				return (this.getId().equals(masWorkCompletion.getId()));
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
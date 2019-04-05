package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the store_internal_indent_m table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="store_internal_indent_m"
 */

public abstract class BaseStoreInternalIndentM  implements Serializable {

	public static String REF = "StoreInternalIndentM";
	public static String PROP_TO_STORE = "ToStore";
	public static String PROP_DISPENSARY_LP = "DispensaryLp";
	public static String PROP_REQUESTED_BY = "RequestedBy";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_APPROVED_BY = "ApprovedBy";
	public static String PROP_DEMAND_DATE = "DemandDate";
	public static String PROP_APPROVAL_REMARKS = "ApprovalRemarks";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_APPROVAL_DATE = "ApprovalDate";
	public static String PROP_DEMAND_NO = "DemandNo";
	public static String PROP_STATUS = "Status";
	public static String PROP_RECEIVED_STATUS = "ReceivedStatus";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_CREATED_BY = "CreatedBy";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT = "Department";


	// constructors
	public BaseStoreInternalIndentM () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreInternalIndentM (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date approvalDate;
	private java.lang.String approvalRemarks;
	private java.util.Date demandDate;
	private java.lang.String demandNo;
	private java.lang.String dispensaryLp;
	private java.util.Date lastChgDate;
	private java.lang.String receivedStatus;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasEmployee approvedBy;
	private jkt.hms.masters.business.Users createdBy;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasEmployee employee;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasEmployee requestedBy;
	private jkt.hms.masters.business.MasDepartment toStore;

	// collections
	private java.util.Set<jkt.hms.masters.business.StoreInternalIndentT> storeInternalIndentTs;
	private java.util.Set<jkt.hms.masters.business.StoreIssueM> storeIssueMsByRequestNo;
	private java.util.Set<jkt.hms.masters.business.StoreIssueM> storeIssueMsByToDepot;



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
	 * Return the value associated with the column: approval_remarks
	 */
	public java.lang.String getApprovalRemarks () {
		return approvalRemarks;
	}

	/**
	 * Set the value related to the column: approval_remarks
	 * @param approvalRemarks the approval_remarks value
	 */
	public void setApprovalRemarks (java.lang.String approvalRemarks) {
		this.approvalRemarks = approvalRemarks;
	}



	/**
	 * Return the value associated with the column: demand_date
	 */
	public java.util.Date getDemandDate () {
		return demandDate;
	}

	/**
	 * Set the value related to the column: demand_date
	 * @param demandDate the demand_date value
	 */
	public void setDemandDate (java.util.Date demandDate) {
		this.demandDate = demandDate;
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
	 * Return the value associated with the column: dispensary_lp
	 */
	public java.lang.String getDispensaryLp () {
		return dispensaryLp;
	}

	/**
	 * Set the value related to the column: dispensary_lp
	 * @param dispensaryLp the dispensary_lp value
	 */
	public void setDispensaryLp (java.lang.String dispensaryLp) {
		this.dispensaryLp = dispensaryLp;
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
	 * Return the value associated with the column: approved_by
	 */
	public jkt.hms.masters.business.MasEmployee getApprovedBy () {
		return approvedBy;
	}

	/**
	 * Set the value related to the column: approved_by
	 * @param approvedBy the approved_by value
	 */
	public void setApprovedBy (jkt.hms.masters.business.MasEmployee approvedBy) {
		this.approvedBy = approvedBy;
	}



	/**
	 * Return the value associated with the column: created_by
	 */
	public jkt.hms.masters.business.Users getCreatedBy () {
		return createdBy;
	}

	/**
	 * Set the value related to the column: created_by
	 * @param createdBy the created_by value
	 */
	public void setCreatedBy (jkt.hms.masters.business.Users createdBy) {
		this.createdBy = createdBy;
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
	 * Return the value associated with the column: requested_by
	 */
	public jkt.hms.masters.business.MasEmployee getRequestedBy () {
		return requestedBy;
	}

	/**
	 * Set the value related to the column: requested_by
	 * @param requestedBy the requested_by value
	 */
	public void setRequestedBy (jkt.hms.masters.business.MasEmployee requestedBy) {
		this.requestedBy = requestedBy;
	}



	/**
	 * Return the value associated with the column: to_store
	 */
	public jkt.hms.masters.business.MasDepartment getToStore () {
		return toStore;
	}

	/**
	 * Set the value related to the column: to_store
	 * @param toStore the to_store value
	 */
	public void setToStore (jkt.hms.masters.business.MasDepartment toStore) {
		this.toStore = toStore;
	}



	/**
	 * Return the value associated with the column: StoreInternalIndentTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreInternalIndentT> getStoreInternalIndentTs () {
		return storeInternalIndentTs;
	}

	/**
	 * Set the value related to the column: StoreInternalIndentTs
	 * @param storeInternalIndentTs the StoreInternalIndentTs value
	 */
	public void setStoreInternalIndentTs (java.util.Set<jkt.hms.masters.business.StoreInternalIndentT> storeInternalIndentTs) {
		this.storeInternalIndentTs = storeInternalIndentTs;
	}

	public void addToStoreInternalIndentTs (jkt.hms.masters.business.StoreInternalIndentT storeInternalIndentT) {
		if (null == getStoreInternalIndentTs()) setStoreInternalIndentTs(new java.util.TreeSet<jkt.hms.masters.business.StoreInternalIndentT>());
		getStoreInternalIndentTs().add(storeInternalIndentT);
	}



	/**
	 * Return the value associated with the column: StoreIssueMsByRequestNo
	 */
	public java.util.Set<jkt.hms.masters.business.StoreIssueM> getStoreIssueMsByRequestNo () {
		return storeIssueMsByRequestNo;
	}

	/**
	 * Set the value related to the column: StoreIssueMsByRequestNo
	 * @param storeIssueMsByRequestNo the StoreIssueMsByRequestNo value
	 */
	public void setStoreIssueMsByRequestNo (java.util.Set<jkt.hms.masters.business.StoreIssueM> storeIssueMsByRequestNo) {
		this.storeIssueMsByRequestNo = storeIssueMsByRequestNo;
	}

	public void addToStoreIssueMsByRequestNo (jkt.hms.masters.business.StoreIssueM storeIssueM) {
		if (null == getStoreIssueMsByRequestNo()) setStoreIssueMsByRequestNo(new java.util.TreeSet<jkt.hms.masters.business.StoreIssueM>());
		getStoreIssueMsByRequestNo().add(storeIssueM);
	}



	/**
	 * Return the value associated with the column: StoreIssueMsByToDepot
	 */
	public java.util.Set<jkt.hms.masters.business.StoreIssueM> getStoreIssueMsByToDepot () {
		return storeIssueMsByToDepot;
	}

	/**
	 * Set the value related to the column: StoreIssueMsByToDepot
	 * @param storeIssueMsByToDepot the StoreIssueMsByToDepot value
	 */
	public void setStoreIssueMsByToDepot (java.util.Set<jkt.hms.masters.business.StoreIssueM> storeIssueMsByToDepot) {
		this.storeIssueMsByToDepot = storeIssueMsByToDepot;
	}

	public void addToStoreIssueMsByToDepot (jkt.hms.masters.business.StoreIssueM storeIssueM) {
		if (null == getStoreIssueMsByToDepot()) setStoreIssueMsByToDepot(new java.util.TreeSet<jkt.hms.masters.business.StoreIssueM>());
		getStoreIssueMsByToDepot().add(storeIssueM);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreInternalIndentM)) return false;
		else {
			jkt.hms.masters.business.StoreInternalIndentM storeInternalIndentM = (jkt.hms.masters.business.StoreInternalIndentM) obj;
			if (null == this.getId() || null == storeInternalIndentM.getId()) return false;
			else return (this.getId().equals(storeInternalIndentM.getId()));
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
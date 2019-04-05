package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the rc_request_header table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="rc_request_header"
 */

public abstract class BaseRcRequestHeader  implements Serializable {

	public static String REF = "RcRequestHeader";
	public static String PROP_FINANCIAL = "Financial";
	public static String PROP_REQUEST_DATE = "RequestDate";
	public static String PROP_WARDS = "Wards";
	public static String PROP_RC_HEADER = "RcHeader";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_REQESTED_BY = "ReqestedBy";
	public static String PROP_APPROVED_BY = "ApprovedBy";
	public static String PROP_APPROVAL_REMARKS = "ApprovalRemarks";
	public static String PROP_APPROVAL_DATE = "ApprovalDate";
	public static String PROP_STATUS = "Status";
	public static String PROP_TO_DEPARTMENT = "ToDepartment";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_REQUEST_NO = "RequestNo";
	public static String PROP_RECEIVED_SATUS = "ReceivedSatus";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT = "Department";


	// constructors
	public BaseRcRequestHeader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseRcRequestHeader (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String requestNo;
	private java.util.Date requestDate;
	private java.lang.String status;
	private java.lang.String wards;
	private java.lang.String approvalRemarks;
	private java.util.Date approvalDate;
	private java.util.Date lastChgDate;
	private java.lang.String receivedSatus;

	// many to one
	private jkt.hms.masters.business.MasDepartment toDepartment;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasEmployee approvedBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasStoreFinancial financial;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.Users reqestedBy;
	private jkt.hms.masters.business.RcHeader rcHeader;



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
	 * Return the value associated with the column: request_no
	 */
	public java.lang.String getRequestNo () {
		return requestNo;
	}

	/**
	 * Set the value related to the column: request_no
	 * @param requestNo the request_no value
	 */
	public void setRequestNo (java.lang.String requestNo) {
		this.requestNo = requestNo;
	}



	/**
	 * Return the value associated with the column: request_date
	 */
	public java.util.Date getRequestDate () {
		return requestDate;
	}

	/**
	 * Set the value related to the column: request_date
	 * @param requestDate the request_date value
	 */
	public void setRequestDate (java.util.Date requestDate) {
		this.requestDate = requestDate;
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
	 * Return the value associated with the column: wards
	 */
	public java.lang.String getWards () {
		return wards;
	}

	/**
	 * Set the value related to the column: wards
	 * @param wards the wards value
	 */
	public void setWards (java.lang.String wards) {
		this.wards = wards;
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
	 * Return the value associated with the column: received_satus
	 */
	public java.lang.String getReceivedSatus () {
		return receivedSatus;
	}

	/**
	 * Set the value related to the column: received_satus
	 * @param receivedSatus the received_satus value
	 */
	public void setReceivedSatus (java.lang.String receivedSatus) {
		this.receivedSatus = receivedSatus;
	}



	/**
	 * Return the value associated with the column: to_department
	 */
	public jkt.hms.masters.business.MasDepartment getToDepartment () {
		return toDepartment;
	}

	/**
	 * Set the value related to the column: to_department
	 * @param toDepartment the to_department value
	 */
	public void setToDepartment (jkt.hms.masters.business.MasDepartment toDepartment) {
		this.toDepartment = toDepartment;
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
	 * Return the value associated with the column: financial_id
	 */
	public jkt.hms.masters.business.MasStoreFinancial getFinancial () {
		return financial;
	}

	/**
	 * Set the value related to the column: financial_id
	 * @param financial the financial_id value
	 */
	public void setFinancial (jkt.hms.masters.business.MasStoreFinancial financial) {
		this.financial = financial;
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
	 * Return the value associated with the column: reqested_by
	 */
	public jkt.hms.masters.business.Users getReqestedBy () {
		return reqestedBy;
	}

	/**
	 * Set the value related to the column: reqested_by
	 * @param reqestedBy the reqested_by value
	 */
	public void setReqestedBy (jkt.hms.masters.business.Users reqestedBy) {
		this.reqestedBy = reqestedBy;
	}



	/**
	 * Return the value associated with the column: rc_header_id
	 */
	public jkt.hms.masters.business.RcHeader getRcHeader () {
		return rcHeader;
	}

	/**
	 * Set the value related to the column: rc_header_id
	 * @param rcHeader the rc_header_id value
	 */
	public void setRcHeader (jkt.hms.masters.business.RcHeader rcHeader) {
		this.rcHeader = rcHeader;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.RcRequestHeader)) return false;
		else {
			jkt.hms.masters.business.RcRequestHeader rcRequestHeader = (jkt.hms.masters.business.RcRequestHeader) obj;
			if (null == this.getId() || null == rcRequestHeader.getId()) return false;
			else return (this.getId().equals(rcRequestHeader.getId()));
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
package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the store_loanout_expend_m table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="store_loanout_expend_m"
 */

public abstract class BaseStoreLoanoutExpendM  implements Serializable {

	public static String REF = "StoreLoanoutExpendM";
	public static String PROP_ISSUE_TYPE = "IssueType";
	public static String PROP_ISSUE_NO = "IssueNo";
	public static String PROP_ISSUE_DATE = "IssueDate";
	public static String PROP_REQUEST_DATE = "RequestDate";
	public static String PROP_STATUS = "Status";
	public static String PROP_DOC_NO = "DocNo";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DECLARED_VIDE = "DeclaredVide";
	public static String PROP_AUTHORITY_FOR_ISSUE = "AuthorityForIssue";
	public static String PROP_CONSINEES_DEMAND_NO = "ConsineesDemandNo";
	public static String PROP_REMARKS = "Remarks";


	// constructors
	public BaseStoreLoanoutExpendM () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreLoanoutExpendM (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseStoreLoanoutExpendM (
		java.lang.Integer id,
		jkt.hms.masters.business.MasDepartment department,
		jkt.hms.masters.business.MasHospital hospital,
		java.lang.String issueType,
		java.lang.String issueNo,
		java.util.Date issueDate) {

		this.setId(id);
		this.setDepartment(department);
		this.setHospital(hospital);
		this.setIssueType(issueType);
		this.setIssueNo(issueNo);
		this.setIssueDate(issueDate);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String issueType;
	private java.lang.String issueNo;
	private java.util.Date issueDate;
	private java.util.Date requestDate;
	private java.lang.String status;
	private java.lang.String docNo;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String declaredVide;
	private java.lang.String authorityForIssue;
	private java.lang.String consineesDemandNo;
	private java.lang.String remarks;

	// many to one
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasDepartment toStore;
	private jkt.hms.masters.business.StoreInternalIndentM requestNo;
	private jkt.hms.masters.business.MasEmployee requestBy;
	private jkt.hms.masters.business.MasEmployee approvedBy;
	private jkt.hms.masters.business.MasEmployee issuedBy;
	private jkt.hms.masters.business.MasStoreAirForceDepot toUnit;
	private jkt.hms.masters.business.StoreInternalIndentM toDepot;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.MasUnit otafu;

	// collections
	private java.util.Set storeLoanoutExpendTs;



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
	 * Return the value associated with the column: issue_type
	 */
	public java.lang.String getIssueType () {
		return issueType;
	}

	/**
	 * Set the value related to the column: issue_type
	 * @param issueType the issue_type value
	 */
	public void setIssueType (java.lang.String issueType) {
		this.issueType = issueType;
	}



	/**
	 * Return the value associated with the column: issue_no
	 */
	public java.lang.String getIssueNo () {
		return issueNo;
	}

	/**
	 * Set the value related to the column: issue_no
	 * @param issueNo the issue_no value
	 */
	public void setIssueNo (java.lang.String issueNo) {
		this.issueNo = issueNo;
	}



	/**
	 * Return the value associated with the column: issue_date
	 */
	public java.util.Date getIssueDate () {
		return issueDate;
	}

	/**
	 * Set the value related to the column: issue_date
	 * @param issueDate the issue_date value
	 */
	public void setIssueDate (java.util.Date issueDate) {
		this.issueDate = issueDate;
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
	 * Return the value associated with the column: doc_no
	 */
	public java.lang.String getDocNo () {
		return docNo;
	}

	/**
	 * Set the value related to the column: doc_no
	 * @param docNo the doc_no value
	 */
	public void setDocNo (java.lang.String docNo) {
		this.docNo = docNo;
	}



	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.String getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
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
	 * Return the value associated with the column: DECLARED_VIDE
	 */
	public java.lang.String getDeclaredVide () {
		return declaredVide;
	}

	/**
	 * Set the value related to the column: DECLARED_VIDE
	 * @param declaredVide the DECLARED_VIDE value
	 */
	public void setDeclaredVide (java.lang.String declaredVide) {
		this.declaredVide = declaredVide;
	}



	/**
	 * Return the value associated with the column: AUTHORITY_FOR_ISSUE
	 */
	public java.lang.String getAuthorityForIssue () {
		return authorityForIssue;
	}

	/**
	 * Set the value related to the column: AUTHORITY_FOR_ISSUE
	 * @param authorityForIssue the AUTHORITY_FOR_ISSUE value
	 */
	public void setAuthorityForIssue (java.lang.String authorityForIssue) {
		this.authorityForIssue = authorityForIssue;
	}



	/**
	 * Return the value associated with the column: CONSINEES_DEMAND_NO
	 */
	public java.lang.String getConsineesDemandNo () {
		return consineesDemandNo;
	}

	/**
	 * Set the value related to the column: CONSINEES_DEMAND_NO
	 * @param consineesDemandNo the CONSINEES_DEMAND_NO value
	 */
	public void setConsineesDemandNo (java.lang.String consineesDemandNo) {
		this.consineesDemandNo = consineesDemandNo;
	}



	/**
	 * Return the value associated with the column: REMARKS
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: REMARKS
	 * @param remarks the REMARKS value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
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
	 * Return the value associated with the column: request_no
	 */
	public jkt.hms.masters.business.StoreInternalIndentM getRequestNo () {
		return requestNo;
	}

	/**
	 * Set the value related to the column: request_no
	 * @param requestNo the request_no value
	 */
	public void setRequestNo (jkt.hms.masters.business.StoreInternalIndentM requestNo) {
		this.requestNo = requestNo;
	}



	/**
	 * Return the value associated with the column: request_by
	 */
	public jkt.hms.masters.business.MasEmployee getRequestBy () {
		return requestBy;
	}

	/**
	 * Set the value related to the column: request_by
	 * @param requestBy the request_by value
	 */
	public void setRequestBy (jkt.hms.masters.business.MasEmployee requestBy) {
		this.requestBy = requestBy;
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
	 * Return the value associated with the column: issued_by
	 */
	public jkt.hms.masters.business.MasEmployee getIssuedBy () {
		return issuedBy;
	}

	/**
	 * Set the value related to the column: issued_by
	 * @param issuedBy the issued_by value
	 */
	public void setIssuedBy (jkt.hms.masters.business.MasEmployee issuedBy) {
		this.issuedBy = issuedBy;
	}



	/**
	 * Return the value associated with the column: to_unit
	 */
	public jkt.hms.masters.business.MasStoreAirForceDepot getToUnit () {
		return toUnit;
	}

	/**
	 * Set the value related to the column: to_unit
	 * @param toUnit the to_unit value
	 */
	public void setToUnit (jkt.hms.masters.business.MasStoreAirForceDepot toUnit) {
		this.toUnit = toUnit;
	}



	/**
	 * Return the value associated with the column: to_depot
	 */
	public jkt.hms.masters.business.StoreInternalIndentM getToDepot () {
		return toDepot;
	}

	/**
	 * Set the value related to the column: to_depot
	 * @param toDepot the to_depot value
	 */
	public void setToDepot (jkt.hms.masters.business.StoreInternalIndentM toDepot) {
		this.toDepot = toDepot;
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
	 * Return the value associated with the column: hin_id
	 */
	public jkt.hms.masters.business.Patient getHin () {
		return hin;
	}

	/**
	 * Set the value related to the column: hin_id
	 * @param hin the hin_id value
	 */
	public void setHin (jkt.hms.masters.business.Patient hin) {
		this.hin = hin;
	}



	/**
	 * Return the value associated with the column: otafu
	 */
	public jkt.hms.masters.business.MasUnit getOtafu () {
		return otafu;
	}

	/**
	 * Set the value related to the column: otafu
	 * @param otafu the otafu value
	 */
	public void setOtafu (jkt.hms.masters.business.MasUnit otafu) {
		this.otafu = otafu;
	}



	/**
	 * Return the value associated with the column: StoreLoanoutExpendTs
	 */
	public java.util.Set getStoreLoanoutExpendTs () {
		return storeLoanoutExpendTs;
	}

	/**
	 * Set the value related to the column: StoreLoanoutExpendTs
	 * @param storeLoanoutExpendTs the StoreLoanoutExpendTs value
	 */
	public void setStoreLoanoutExpendTs (java.util.Set storeLoanoutExpendTs) {
		this.storeLoanoutExpendTs = storeLoanoutExpendTs;
	}

	public void addToStoreLoanoutExpendTs (jkt.hms.masters.business.StoreLoanoutExpendT storeLoanoutExpendT) {
		if (null == getStoreLoanoutExpendTs()) setStoreLoanoutExpendTs(new java.util.HashSet());
		getStoreLoanoutExpendTs().add(storeLoanoutExpendT);
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreLoanoutExpendM)) return false;
		else {
			jkt.hms.masters.business.StoreLoanoutExpendM storeLoanoutExpendM = (jkt.hms.masters.business.StoreLoanoutExpendM) obj;
			if (null == this.getId() || null == storeLoanoutExpendM.getId()) return false;
			else return (this.getId().equals(storeLoanoutExpendM.getId()));
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
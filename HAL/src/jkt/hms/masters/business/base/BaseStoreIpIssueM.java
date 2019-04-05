package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the store_ip_issue_m table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="store_ip_issue_m"
 */

public abstract class BaseStoreIpIssueM  implements Serializable {

	public static String REF = "StoreIpIssueM";
	public static String PROP_TODATE = "Todate";
	public static String PROP_AD_NO = "AdNo";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ISSUE_TYPE = "IssueType";
	public static String PROP_IP_ISSUE_DATE = "IpIssueDate";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_IP_ISSUE_NO = "IpIssueNo";
	public static String PROP_FROMDATE = "Fromdate";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_HIN = "Hin";
	public static String PROP_IP_ISSUE_TIME = "IpIssueTime";


	// constructors
	public BaseStoreIpIssueM () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreIpIssueM (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String issueType;
	private java.lang.String adNo;
	private java.lang.String ipIssueNo;
	private java.util.Date ipIssueDate;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.util.Date fromdate;
	private java.util.Date todate;
	private java.lang.String ipIssueTime;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.Inpatient inpatient;

	// collections
	private java.util.Set<jkt.hms.masters.business.StoreIpIssueT> storeIpIssueTs;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="ip_issue_id"
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
	 * Return the value associated with the column: ad_no
	 */
	public java.lang.String getAdNo () {
		return adNo;
	}

	/**
	 * Set the value related to the column: ad_no
	 * @param adNo the ad_no value
	 */
	public void setAdNo (java.lang.String adNo) {
		this.adNo = adNo;
	}



	/**
	 * Return the value associated with the column: ip_issue_no
	 */
	public java.lang.String getIpIssueNo () {
		return ipIssueNo;
	}

	/**
	 * Set the value related to the column: ip_issue_no
	 * @param ipIssueNo the ip_issue_no value
	 */
	public void setIpIssueNo (java.lang.String ipIssueNo) {
		this.ipIssueNo = ipIssueNo;
	}



	/**
	 * Return the value associated with the column: ip_issue_date
	 */
	public java.util.Date getIpIssueDate () {
		return ipIssueDate;
	}

	/**
	 * Set the value related to the column: ip_issue_date
	 * @param ipIssueDate the ip_issue_date value
	 */
	public void setIpIssueDate (java.util.Date ipIssueDate) {
		this.ipIssueDate = ipIssueDate;
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
	 * Return the value associated with the column: fromdate
	 */
	public java.util.Date getFromdate () {
		return fromdate;
	}

	/**
	 * Set the value related to the column: fromdate
	 * @param fromdate the fromdate value
	 */
	public void setFromdate (java.util.Date fromdate) {
		this.fromdate = fromdate;
	}



	/**
	 * Return the value associated with the column: todate
	 */
	public java.util.Date getTodate () {
		return todate;
	}

	/**
	 * Set the value related to the column: todate
	 * @param todate the todate value
	 */
	public void setTodate (java.util.Date todate) {
		this.todate = todate;
	}



	/**
	 * Return the value associated with the column: IP_ISSUE_TIME
	 */
	public java.lang.String getIpIssueTime () {
		return ipIssueTime;
	}

	/**
	 * Set the value related to the column: IP_ISSUE_TIME
	 * @param ipIssueTime the IP_ISSUE_TIME value
	 */
	public void setIpIssueTime (java.lang.String ipIssueTime) {
		this.ipIssueTime = ipIssueTime;
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
	 * Return the value associated with the column: INPATIENT_ID
	 */
	public jkt.hms.masters.business.Inpatient getInpatient () {
		return inpatient;
	}

	/**
	 * Set the value related to the column: INPATIENT_ID
	 * @param inpatient the INPATIENT_ID value
	 */
	public void setInpatient (jkt.hms.masters.business.Inpatient inpatient) {
		this.inpatient = inpatient;
	}



	/**
	 * Return the value associated with the column: StoreIpIssueTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreIpIssueT> getStoreIpIssueTs () {
		return storeIpIssueTs;
	}

	/**
	 * Set the value related to the column: StoreIpIssueTs
	 * @param storeIpIssueTs the StoreIpIssueTs value
	 */
	public void setStoreIpIssueTs (java.util.Set<jkt.hms.masters.business.StoreIpIssueT> storeIpIssueTs) {
		this.storeIpIssueTs = storeIpIssueTs;
	}

	public void addToStoreIpIssueTs (jkt.hms.masters.business.StoreIpIssueT storeIpIssueT) {
		if (null == getStoreIpIssueTs()) setStoreIpIssueTs(new java.util.TreeSet<jkt.hms.masters.business.StoreIpIssueT>());
		getStoreIpIssueTs().add(storeIpIssueT);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreIpIssueM)) return false;
		else {
			jkt.hms.masters.business.StoreIpIssueM storeIpIssueM = (jkt.hms.masters.business.StoreIpIssueM) obj;
			if (null == this.getId() || null == storeIpIssueM.getId()) return false;
			else return (this.getId().equals(storeIpIssueM.getId()));
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
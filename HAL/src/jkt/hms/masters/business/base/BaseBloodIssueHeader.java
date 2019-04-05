package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the blood_issue_header table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="blood_issue_header"
 */

public abstract class BaseBloodIssueHeader implements Serializable {

	public static String REF = "BloodIssueHeader";
	public static String PROP_MONTHLY_NO = "MonthlyNo";
	public static String PROP_ISSUE_DATE = "IssueDate";
	public static String PROP_SCREENING_HD = "ScreeningHd";
	public static String PROP_AHG = "Ahg";
	public static String PROP_RECEIVED_BY = "ReceivedBy";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ALB = "Alb";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_BLOOD_GROUP = "BloodGroup";
	public static String PROP_SAL_RT = "SalRt";
	public static String PROP_SAL = "Sal";
	public static String PROP_ID = "Id";
	public static String PROP_ISSUED_BY = "IssuedBy";
	public static String PROP_ISSUE_TIME = "IssueTime";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_HIN = "Hin";
	public static String PROP_MATCHED_BY = "MatchedBy";

	// constructors
	public BaseBloodIssueHeader() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBloodIssueHeader(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String monthlyNo;
	private java.util.Date issueDate;
	private java.lang.String issueTime;
	private java.lang.String salRt;
	private java.lang.String sal;
	private java.lang.String ahg;
	private java.lang.String alb;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.BloodSampleScreeningHeader screeningHd;
	private jkt.hms.masters.business.MasBloodGroup bloodGroup;
	private jkt.hms.masters.business.MasEmployee receivedBy;
	private jkt.hms.masters.business.MasEmployee issuedBy;
	private jkt.hms.masters.business.MasEmployee matchedBy;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.Inpatient inpatient;

	// collections
	private java.util.Set<jkt.hms.masters.business.BloodIssueDetail> bloodIssueDetails;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="id"
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
	 * Return the value associated with the column: monthly_no
	 */
	public java.lang.String getMonthlyNo() {
		return monthlyNo;
	}

	/**
	 * Set the value related to the column: monthly_no
	 * 
	 * @param monthlyNo
	 *            the monthly_no value
	 */
	public void setMonthlyNo(java.lang.String monthlyNo) {
		this.monthlyNo = monthlyNo;
	}

	/**
	 * Return the value associated with the column: issue_date
	 */
	public java.util.Date getIssueDate() {
		return issueDate;
	}

	/**
	 * Set the value related to the column: issue_date
	 * 
	 * @param issueDate
	 *            the issue_date value
	 */
	public void setIssueDate(java.util.Date issueDate) {
		this.issueDate = issueDate;
	}

	/**
	 * Return the value associated with the column: issue_time
	 */
	public java.lang.String getIssueTime() {
		return issueTime;
	}

	/**
	 * Set the value related to the column: issue_time
	 * 
	 * @param issueTime
	 *            the issue_time value
	 */
	public void setIssueTime(java.lang.String issueTime) {
		this.issueTime = issueTime;
	}

	/**
	 * Return the value associated with the column: sal_rt
	 */
	public java.lang.String getSalRt() {
		return salRt;
	}

	/**
	 * Set the value related to the column: sal_rt
	 * 
	 * @param salRt
	 *            the sal_rt value
	 */
	public void setSalRt(java.lang.String salRt) {
		this.salRt = salRt;
	}

	/**
	 * Return the value associated with the column: sal
	 */
	public java.lang.String getSal() {
		return sal;
	}

	/**
	 * Set the value related to the column: sal
	 * 
	 * @param sal
	 *            the sal value
	 */
	public void setSal(java.lang.String sal) {
		this.sal = sal;
	}

	/**
	 * Return the value associated with the column: ahg
	 */
	public java.lang.String getAhg() {
		return ahg;
	}

	/**
	 * Set the value related to the column: ahg
	 * 
	 * @param ahg
	 *            the ahg value
	 */
	public void setAhg(java.lang.String ahg) {
		this.ahg = ahg;
	}

	/**
	 * Return the value associated with the column: alb
	 */
	public java.lang.String getAlb() {
		return alb;
	}

	/**
	 * Set the value related to the column: alb
	 * 
	 * @param alb
	 *            the alb value
	 */
	public void setAlb(java.lang.String alb) {
		this.alb = alb;
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
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital() {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * 
	 * @param hospital
	 *            the hospital_id value
	 */
	public void setHospital(jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
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
	 * Return the value associated with the column: screening_hd_id
	 */
	public jkt.hms.masters.business.BloodSampleScreeningHeader getScreeningHd() {
		return screeningHd;
	}

	/**
	 * Set the value related to the column: screening_hd_id
	 * 
	 * @param screeningHd
	 *            the screening_hd_id value
	 */
	public void setScreeningHd(
			jkt.hms.masters.business.BloodSampleScreeningHeader screeningHd) {
		this.screeningHd = screeningHd;
	}

	/**
	 * Return the value associated with the column: blood_group_id
	 */
	public jkt.hms.masters.business.MasBloodGroup getBloodGroup() {
		return bloodGroup;
	}

	/**
	 * Set the value related to the column: blood_group_id
	 * 
	 * @param bloodGroup
	 *            the blood_group_id value
	 */
	public void setBloodGroup(jkt.hms.masters.business.MasBloodGroup bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	/**
	 * Return the value associated with the column: received_by
	 */
	public jkt.hms.masters.business.MasEmployee getReceivedBy() {
		return receivedBy;
	}

	/**
	 * Set the value related to the column: received_by
	 * 
	 * @param receivedBy
	 *            the received_by value
	 */
	public void setReceivedBy(jkt.hms.masters.business.MasEmployee receivedBy) {
		this.receivedBy = receivedBy;
	}

	/**
	 * Return the value associated with the column: issued_by
	 */
	public jkt.hms.masters.business.MasEmployee getIssuedBy() {
		return issuedBy;
	}

	/**
	 * Set the value related to the column: issued_by
	 * 
	 * @param issuedBy
	 *            the issued_by value
	 */
	public void setIssuedBy(jkt.hms.masters.business.MasEmployee issuedBy) {
		this.issuedBy = issuedBy;
	}

	/**
	 * Return the value associated with the column: matched_by
	 */
	public jkt.hms.masters.business.MasEmployee getMatchedBy() {
		return matchedBy;
	}

	/**
	 * Set the value related to the column: matched_by
	 * 
	 * @param matchedBy
	 *            the matched_by value
	 */
	public void setMatchedBy(jkt.hms.masters.business.MasEmployee matchedBy) {
		this.matchedBy = matchedBy;
	}

	/**
	 * Return the value associated with the column: hin_id
	 */
	public jkt.hms.masters.business.Patient getHin() {
		return hin;
	}

	/**
	 * Set the value related to the column: hin_id
	 * 
	 * @param hin
	 *            the hin_id value
	 */
	public void setHin(jkt.hms.masters.business.Patient hin) {
		this.hin = hin;
	}

	/**
	 * Return the value associated with the column: inpatient_id
	 */
	public jkt.hms.masters.business.Inpatient getInpatient() {
		return inpatient;
	}

	/**
	 * Set the value related to the column: inpatient_id
	 * 
	 * @param inpatient
	 *            the inpatient_id value
	 */
	public void setInpatient(jkt.hms.masters.business.Inpatient inpatient) {
		this.inpatient = inpatient;
	}

	/**
	 * Return the value associated with the column: BloodIssueDetails
	 */
	public java.util.Set<jkt.hms.masters.business.BloodIssueDetail> getBloodIssueDetails() {
		return bloodIssueDetails;
	}

	/**
	 * Set the value related to the column: BloodIssueDetails
	 * 
	 * @param bloodIssueDetails
	 *            the BloodIssueDetails value
	 */
	public void setBloodIssueDetails(
			java.util.Set<jkt.hms.masters.business.BloodIssueDetail> bloodIssueDetails) {
		this.bloodIssueDetails = bloodIssueDetails;
	}

	public void addToBloodIssueDetails(
			jkt.hms.masters.business.BloodIssueDetail bloodIssueDetail) {
		if (null == getBloodIssueDetails())
			setBloodIssueDetails(new java.util.TreeSet<jkt.hms.masters.business.BloodIssueDetail>());
		getBloodIssueDetails().add(bloodIssueDetail);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.BloodIssueHeader))
			return false;
		else {
			jkt.hms.masters.business.BloodIssueHeader bloodIssueHeader = (jkt.hms.masters.business.BloodIssueHeader) obj;
			if (null == this.getId() || null == bloodIssueHeader.getId())
				return false;
			else
				return (this.getId().equals(bloodIssueHeader.getId()));
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
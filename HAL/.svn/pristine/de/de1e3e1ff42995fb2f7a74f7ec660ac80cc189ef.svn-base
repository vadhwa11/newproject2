package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_case_type table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="mas_case_type"
 */

public abstract class BaseMasCaseType implements Serializable {

	public static String REF = "MasCaseType";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_CASE_TYPE_CODE = "CaseTypeCode";
	public static String PROP_ID = "Id";
	public static String PROP_CASE_TYPE_NAME = "CaseTypeName";

	// constructors
	public BaseMasCaseType() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasCaseType(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String caseTypeCode;
	private java.lang.String caseTypeName;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// collections
	private java.util.Set<jkt.hms.masters.business.Visit> visits;
	private java.util.Set<jkt.hms.masters.business.Inpatient> inpatients;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="case_type_id"
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
	 * Return the value associated with the column: case_type_code
	 */
	public java.lang.String getCaseTypeCode() {
		return caseTypeCode;
	}

	/**
	 * Set the value related to the column: case_type_code
	 * 
	 * @param caseTypeCode
	 *            the case_type_code value
	 */
	public void setCaseTypeCode(java.lang.String caseTypeCode) {
		this.caseTypeCode = caseTypeCode;
	}

	/**
	 * Return the value associated with the column: case_type_name
	 */
	public java.lang.String getCaseTypeName() {
		return caseTypeName;
	}

	/**
	 * Set the value related to the column: case_type_name
	 * 
	 * @param caseTypeName
	 *            the case_type_name value
	 */
	public void setCaseTypeName(java.lang.String caseTypeName) {
		this.caseTypeName = caseTypeName;
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
	 * Return the value associated with the column: Visits
	 */
	public java.util.Set<jkt.hms.masters.business.Visit> getVisits() {
		return visits;
	}

	/**
	 * Set the value related to the column: Visits
	 * 
	 * @param visits
	 *            the Visits value
	 */
	public void setVisits(java.util.Set<jkt.hms.masters.business.Visit> visits) {
		this.visits = visits;
	}

	public void addToVisits(jkt.hms.masters.business.Visit visit) {
		if (null == getVisits())
			setVisits(new java.util.TreeSet<jkt.hms.masters.business.Visit>());
		getVisits().add(visit);
	}

	/**
	 * Return the value associated with the column: Inpatients
	 */
	public java.util.Set<jkt.hms.masters.business.Inpatient> getInpatients() {
		return inpatients;
	}

	/**
	 * Set the value related to the column: Inpatients
	 * 
	 * @param inpatients
	 *            the Inpatients value
	 */
	public void setInpatients(
			java.util.Set<jkt.hms.masters.business.Inpatient> inpatients) {
		this.inpatients = inpatients;
	}

	public void addToInpatients(jkt.hms.masters.business.Inpatient inpatient) {
		if (null == getInpatients())
			setInpatients(new java.util.TreeSet<jkt.hms.masters.business.Inpatient>());
		getInpatients().add(inpatient);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MasCaseType))
			return false;
		else {
			jkt.hms.masters.business.MasCaseType masCaseType = (jkt.hms.masters.business.MasCaseType) obj;
			if (null == this.getId() || null == masCaseType.getId())
				return false;
			else
				return (this.getId().equals(masCaseType.getId()));
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
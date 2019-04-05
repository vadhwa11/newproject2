package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the work_load_entry table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="work_load_entry"
 */

public abstract class BaseWorkLoadEntry implements Serializable {

	public static String REF = "WorkLoadEntry";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ENTRY_NO = "EntryNo";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ENTRY_DATE = "EntryDate";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_ID = "Id";

	// constructors
	public BaseWorkLoadEntry() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseWorkLoadEntry(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String entryNo;
	private java.util.Date entryDate;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;

	// collections
	private java.util.Set<jkt.hms.masters.business.WorkLoadEntryDetail> workLoadEntryDetails;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="work_load_id"
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
	 * Return the value associated with the column: entry_no
	 */
	public java.lang.String getEntryNo() {
		return entryNo;
	}

	/**
	 * Set the value related to the column: entry_no
	 * 
	 * @param entryNo
	 *            the entry_no value
	 */
	public void setEntryNo(java.lang.String entryNo) {
		this.entryNo = entryNo;
	}

	/**
	 * Return the value associated with the column: entry_date
	 */
	public java.util.Date getEntryDate() {
		return entryDate;
	}

	/**
	 * Set the value related to the column: entry_date
	 * 
	 * @param entryDate
	 *            the entry_date value
	 */
	public void setEntryDate(java.util.Date entryDate) {
		this.entryDate = entryDate;
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
	 * Return the value associated with the column: WorkLoadEntryDetails
	 */
	public java.util.Set<jkt.hms.masters.business.WorkLoadEntryDetail> getWorkLoadEntryDetails() {
		return workLoadEntryDetails;
	}

	/**
	 * Set the value related to the column: WorkLoadEntryDetails
	 * 
	 * @param workLoadEntryDetails
	 *            the WorkLoadEntryDetails value
	 */
	public void setWorkLoadEntryDetails(
			java.util.Set<jkt.hms.masters.business.WorkLoadEntryDetail> workLoadEntryDetails) {
		this.workLoadEntryDetails = workLoadEntryDetails;
	}

	public void addToWorkLoadEntryDetails(
			jkt.hms.masters.business.WorkLoadEntryDetail workLoadEntryDetail) {
		if (null == getWorkLoadEntryDetails())
			setWorkLoadEntryDetails(new java.util.TreeSet<jkt.hms.masters.business.WorkLoadEntryDetail>());
		getWorkLoadEntryDetails().add(workLoadEntryDetail);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.WorkLoadEntry))
			return false;
		else {
			jkt.hms.masters.business.WorkLoadEntry workLoadEntry = (jkt.hms.masters.business.WorkLoadEntry) obj;
			if (null == this.getId() || null == workLoadEntry.getId())
				return false;
			else
				return (this.getId().equals(workLoadEntry.getId()));
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
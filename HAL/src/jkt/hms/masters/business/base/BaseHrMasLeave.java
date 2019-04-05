package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_mas_leave table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_mas_leave"
 */

public abstract class BaseHrMasLeave  implements Serializable {

	public static String REF = "HrMasLeave";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_COMPANY = "Company";
	public static String PROP_DESCRIPTION = "Description";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";


	// constructors
	public BaseHrMasLeave () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrMasLeave (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String description;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.Integer company;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;

	// collections
	private java.util.Set<jkt.hms.masters.business.HrMasLeaveTypeBackup> hrMasLeaveTypeBackups;
	private java.util.Set<jkt.hms.masters.business.HrMasLeaveTypeNew> hrMasLeaveTypeNews;
	private java.util.Set<jkt.hms.masters.business.HrMasLeaveType> hrMasLeaveTypes;
	private java.util.Set<jkt.hms.masters.business.HrMasLeaveTypeHistory> hrMasLeaveTypeHistories;



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
	 * Return the value associated with the column: description
	 */
	public java.lang.String getDescription () {
		return description;
	}

	/**
	 * Set the value related to the column: description
	 * @param description the description value
	 */
	public void setDescription (java.lang.String description) {
		this.description = description;
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
	 * Return the value associated with the column: company_id
	 */
	public java.lang.Integer getCompany () {
		return company;
	}

	/**
	 * Set the value related to the column: company_id
	 * @param company the company_id value
	 */
	public void setCompany (java.lang.Integer company) {
		this.company = company;
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
	 * Return the value associated with the column: HrMasLeaveTypeBackups
	 */
	public java.util.Set<jkt.hms.masters.business.HrMasLeaveTypeBackup> getHrMasLeaveTypeBackups () {
		return hrMasLeaveTypeBackups;
	}

	/**
	 * Set the value related to the column: HrMasLeaveTypeBackups
	 * @param hrMasLeaveTypeBackups the HrMasLeaveTypeBackups value
	 */
	public void setHrMasLeaveTypeBackups (java.util.Set<jkt.hms.masters.business.HrMasLeaveTypeBackup> hrMasLeaveTypeBackups) {
		this.hrMasLeaveTypeBackups = hrMasLeaveTypeBackups;
	}

	public void addToHrMasLeaveTypeBackups (jkt.hms.masters.business.HrMasLeaveTypeBackup hrMasLeaveTypeBackup) {
		if (null == getHrMasLeaveTypeBackups()) setHrMasLeaveTypeBackups(new java.util.TreeSet<jkt.hms.masters.business.HrMasLeaveTypeBackup>());
		getHrMasLeaveTypeBackups().add(hrMasLeaveTypeBackup);
	}



	/**
	 * Return the value associated with the column: HrMasLeaveTypeNews
	 */
	public java.util.Set<jkt.hms.masters.business.HrMasLeaveTypeNew> getHrMasLeaveTypeNews () {
		return hrMasLeaveTypeNews;
	}

	/**
	 * Set the value related to the column: HrMasLeaveTypeNews
	 * @param hrMasLeaveTypeNews the HrMasLeaveTypeNews value
	 */
	public void setHrMasLeaveTypeNews (java.util.Set<jkt.hms.masters.business.HrMasLeaveTypeNew> hrMasLeaveTypeNews) {
		this.hrMasLeaveTypeNews = hrMasLeaveTypeNews;
	}

	public void addToHrMasLeaveTypeNews (jkt.hms.masters.business.HrMasLeaveTypeNew hrMasLeaveTypeNew) {
		if (null == getHrMasLeaveTypeNews()) setHrMasLeaveTypeNews(new java.util.TreeSet<jkt.hms.masters.business.HrMasLeaveTypeNew>());
		getHrMasLeaveTypeNews().add(hrMasLeaveTypeNew);
	}



	/**
	 * Return the value associated with the column: HrMasLeaveTypes
	 */
	public java.util.Set<jkt.hms.masters.business.HrMasLeaveType> getHrMasLeaveTypes () {
		return hrMasLeaveTypes;
	}

	/**
	 * Set the value related to the column: HrMasLeaveTypes
	 * @param hrMasLeaveTypes the HrMasLeaveTypes value
	 */
	public void setHrMasLeaveTypes (java.util.Set<jkt.hms.masters.business.HrMasLeaveType> hrMasLeaveTypes) {
		this.hrMasLeaveTypes = hrMasLeaveTypes;
	}

	public void addToHrMasLeaveTypes (jkt.hms.masters.business.HrMasLeaveType hrMasLeaveType) {
		if (null == getHrMasLeaveTypes()) setHrMasLeaveTypes(new java.util.TreeSet<jkt.hms.masters.business.HrMasLeaveType>());
		getHrMasLeaveTypes().add(hrMasLeaveType);
	}



	/**
	 * Return the value associated with the column: HrMasLeaveTypeHistories
	 */
	public java.util.Set<jkt.hms.masters.business.HrMasLeaveTypeHistory> getHrMasLeaveTypeHistories () {
		return hrMasLeaveTypeHistories;
	}

	/**
	 * Set the value related to the column: HrMasLeaveTypeHistories
	 * @param hrMasLeaveTypeHistories the HrMasLeaveTypeHistories value
	 */
	public void setHrMasLeaveTypeHistories (java.util.Set<jkt.hms.masters.business.HrMasLeaveTypeHistory> hrMasLeaveTypeHistories) {
		this.hrMasLeaveTypeHistories = hrMasLeaveTypeHistories;
	}

	public void addToHrMasLeaveTypeHistories (jkt.hms.masters.business.HrMasLeaveTypeHistory hrMasLeaveTypeHistory) {
		if (null == getHrMasLeaveTypeHistories()) setHrMasLeaveTypeHistories(new java.util.TreeSet<jkt.hms.masters.business.HrMasLeaveTypeHistory>());
		getHrMasLeaveTypeHistories().add(hrMasLeaveTypeHistory);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HrMasLeave)) return false;
		else {
			jkt.hms.masters.business.HrMasLeave hrMasLeave = (jkt.hms.masters.business.HrMasLeave) obj;
			if (null == this.getId() || null == hrMasLeave.getId()) return false;
			else return (this.getId().equals(hrMasLeave.getId()));
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
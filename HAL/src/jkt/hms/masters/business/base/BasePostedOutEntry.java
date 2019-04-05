package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the posted_out_entry table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="posted_out_entry"
 */

public abstract class BasePostedOutEntry  implements Serializable {

	public static String REF = "PostedOutEntry";
	public static String PROP_SORS = "Sors";
	public static String PROP_POR_SLNO = "PorSlno";
	public static String PROP_LST_CHANGED_BY = "LstChangedBy";
	public static String PROP_POSTED_TYPE = "PostedType";
	public static String PROP_ENTRY_NO = "EntryNo";
	public static String PROP_UNIT_POSTED_TO = "UnitPostedTo";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_LST_CHANGED_TIME = "LstChangedTime";
	public static String PROP_STATUS = "Status";
	public static String PROP_DATE = "Date";
	public static String PROP_AUTHORITY = "Authority";
	public static String PROP_ID = "Id";
	public static String PROP_CLEARENCE_COMPLETED = "ClearenceCompleted";
	public static String PROP_APPRAISAL_REPORT = "AppraisalReport";
	public static String PROP_LST_CHANGED_DATE = "LstChangedDate";


	// constructors
	public BasePostedOutEntry () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePostedOutEntry (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String postedType;
	private java.lang.String authority;
	private java.util.Date date;
	private java.util.Date sors;
	private java.lang.String porSlno;
	private java.lang.String remarks;
	private java.util.Date appraisalReport;
	private java.lang.String lstChangedBy;
	private java.util.Date lstChangedDate;
	private java.lang.String lstChangedTime;
	private java.lang.String status;
	private java.lang.String entryNo;
	private java.util.Date clearenceCompleted;

	// many to one
	private jkt.hms.masters.business.MasUnit unitPostedTo;
	private jkt.hms.masters.business.MasEmployee employee;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="posted_out_id"
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
	 * Return the value associated with the column: posted_type
	 */
	public java.lang.String getPostedType () {
		return postedType;
	}

	/**
	 * Set the value related to the column: posted_type
	 * @param postedType the posted_type value
	 */
	public void setPostedType (java.lang.String postedType) {
		this.postedType = postedType;
	}



	/**
	 * Return the value associated with the column: authority
	 */
	public java.lang.String getAuthority () {
		return authority;
	}

	/**
	 * Set the value related to the column: authority
	 * @param authority the authority value
	 */
	public void setAuthority (java.lang.String authority) {
		this.authority = authority;
	}



	/**
	 * Return the value associated with the column: date
	 */
	public java.util.Date getDate () {
		return date;
	}

	/**
	 * Set the value related to the column: date
	 * @param date the date value
	 */
	public void setDate (java.util.Date date) {
		this.date = date;
	}



	/**
	 * Return the value associated with the column: sors
	 */
	public java.util.Date getSors () {
		return sors;
	}

	/**
	 * Set the value related to the column: sors
	 * @param sors the sors value
	 */
	public void setSors (java.util.Date sors) {
		this.sors = sors;
	}



	/**
	 * Return the value associated with the column: por_SlNo
	 */
	public java.lang.String getPorSlno () {
		return porSlno;
	}

	/**
	 * Set the value related to the column: por_SlNo
	 * @param porSlno the por_SlNo value
	 */
	public void setPorSlno (java.lang.String porSlno) {
		this.porSlno = porSlno;
	}



	/**
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * @param remarks the remarks value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
	}



	/**
	 * Return the value associated with the column: appraisal_report
	 */
	public java.util.Date getAppraisalReport () {
		return appraisalReport;
	}

	/**
	 * Set the value related to the column: appraisal_report
	 * @param appraisalReport the appraisal_report value
	 */
	public void setAppraisalReport (java.util.Date appraisalReport) {
		this.appraisalReport = appraisalReport;
	}



	/**
	 * Return the value associated with the column: lst_changed_by
	 */
	public java.lang.String getLstChangedBy () {
		return lstChangedBy;
	}

	/**
	 * Set the value related to the column: lst_changed_by
	 * @param lstChangedBy the lst_changed_by value
	 */
	public void setLstChangedBy (java.lang.String lstChangedBy) {
		this.lstChangedBy = lstChangedBy;
	}



	/**
	 * Return the value associated with the column: lst_changed_date
	 */
	public java.util.Date getLstChangedDate () {
		return lstChangedDate;
	}

	/**
	 * Set the value related to the column: lst_changed_date
	 * @param lstChangedDate the lst_changed_date value
	 */
	public void setLstChangedDate (java.util.Date lstChangedDate) {
		this.lstChangedDate = lstChangedDate;
	}



	/**
	 * Return the value associated with the column: lst_changed_time
	 */
	public java.lang.String getLstChangedTime () {
		return lstChangedTime;
	}

	/**
	 * Set the value related to the column: lst_changed_time
	 * @param lstChangedTime the lst_changed_time value
	 */
	public void setLstChangedTime (java.lang.String lstChangedTime) {
		this.lstChangedTime = lstChangedTime;
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
	 * Return the value associated with the column: entry_no
	 */
	public java.lang.String getEntryNo () {
		return entryNo;
	}

	/**
	 * Set the value related to the column: entry_no
	 * @param entryNo the entry_no value
	 */
	public void setEntryNo (java.lang.String entryNo) {
		this.entryNo = entryNo;
	}



	/**
	 * Return the value associated with the column: clearence_completed
	 */
	public java.util.Date getClearenceCompleted () {
		return clearenceCompleted;
	}

	/**
	 * Set the value related to the column: clearence_completed
	 * @param clearenceCompleted the clearence_completed value
	 */
	public void setClearenceCompleted (java.util.Date clearenceCompleted) {
		this.clearenceCompleted = clearenceCompleted;
	}



	/**
	 * Return the value associated with the column: unit_posted_to
	 */
	public jkt.hms.masters.business.MasUnit getUnitPostedTo () {
		return unitPostedTo;
	}

	/**
	 * Set the value related to the column: unit_posted_to
	 * @param unitPostedTo the unit_posted_to value
	 */
	public void setUnitPostedTo (jkt.hms.masters.business.MasUnit unitPostedTo) {
		this.unitPostedTo = unitPostedTo;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PostedOutEntry)) return false;
		else {
			jkt.hms.masters.business.PostedOutEntry postedOutEntry = (jkt.hms.masters.business.PostedOutEntry) obj;
			if (null == this.getId() || null == postedOutEntry.getId()) return false;
			else return (this.getId().equals(postedOutEntry.getId()));
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
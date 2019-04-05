package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mm_mas_request_status table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mm_mas_request_status"
 */

public abstract class BaseMmMasRequestStatus  implements Serializable {

	public static String REF = "MmMasRequestStatus";
	public static String PROP_STATUS_CODE = "StatusCode";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_STATUS_NAME = "StatusName";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseMmMasRequestStatus () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMmMasRequestStatus (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseMmMasRequestStatus (
		java.lang.Integer id,
		java.lang.String status) {

		this.setId(id);
		this.setStatus(status);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String statusCode;
	private java.lang.String statusName;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;

	// collections
	private java.util.Set<jkt.hms.masters.business.IpdHandTakeOver> ipdHandTakeOvers;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="org.hibernate.id.IncrementGenerator"
     *  column="status_id"
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
	 * Return the value associated with the column: status_code
	 */
	public java.lang.String getStatusCode () {
		return statusCode;
	}

	/**
	 * Set the value related to the column: status_code
	 * @param statusCode the status_code value
	 */
	public void setStatusCode (java.lang.String statusCode) {
		this.statusCode = statusCode;
	}



	/**
	 * Return the value associated with the column: status_name
	 */
	public java.lang.String getStatusName () {
		return statusName;
	}

	/**
	 * Set the value related to the column: status_name
	 * @param statusName the status_name value
	 */
	public void setStatusName (java.lang.String statusName) {
		this.statusName = statusName;
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
	 * Return the value associated with the column: IpdHandTakeOvers
	 */
	public java.util.Set<jkt.hms.masters.business.IpdHandTakeOver> getIpdHandTakeOvers () {
		return ipdHandTakeOvers;
	}

	/**
	 * Set the value related to the column: IpdHandTakeOvers
	 * @param ipdHandTakeOvers the IpdHandTakeOvers value
	 */
	public void setIpdHandTakeOvers (java.util.Set<jkt.hms.masters.business.IpdHandTakeOver> ipdHandTakeOvers) {
		this.ipdHandTakeOvers = ipdHandTakeOvers;
	}

	public void addToIpdHandTakeOvers (jkt.hms.masters.business.IpdHandTakeOver ipdHandTakeOver) {
		if (null == getIpdHandTakeOvers()) setIpdHandTakeOvers(new java.util.TreeSet<jkt.hms.masters.business.IpdHandTakeOver>());
		getIpdHandTakeOvers().add(ipdHandTakeOver);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MmMasRequestStatus)) return false;
		else {
			jkt.hms.masters.business.MmMasRequestStatus mmMasRequestStatus = (jkt.hms.masters.business.MmMasRequestStatus) obj;
			if (null == this.getId() || null == mmMasRequestStatus.getId()) return false;
			else return (this.getId().equals(mmMasRequestStatus.getId()));
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
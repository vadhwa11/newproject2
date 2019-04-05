package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_priority_codes table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_priority_codes"
 */

public abstract class BaseMasPriorityCodes  implements Serializable {

	public static String REF = "MasPriorityCodes";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_CODES_CODE = "CodesCode";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_CODES_NAME = "CodesName";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseMasPriorityCodes () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasPriorityCodes (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String codesCode;
	private java.lang.String codesName;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;

	// collections
	private java.util.Set<jkt.hms.masters.business.MmServiceRequest> mmServiceRequests;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="codes_id"
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
	 * Return the value associated with the column: codes_code
	 */
	public java.lang.String getCodesCode () {
		return codesCode;
	}

	/**
	 * Set the value related to the column: codes_code
	 * @param codesCode the codes_code value
	 */
	public void setCodesCode (java.lang.String codesCode) {
		this.codesCode = codesCode;
	}



	/**
	 * Return the value associated with the column: codes_name
	 */
	public java.lang.String getCodesName () {
		return codesName;
	}

	/**
	 * Set the value related to the column: codes_name
	 * @param codesName the codes_name value
	 */
	public void setCodesName (java.lang.String codesName) {
		this.codesName = codesName;
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
	 * Return the value associated with the column: MmServiceRequests
	 */
	public java.util.Set<jkt.hms.masters.business.MmServiceRequest> getMmServiceRequests () {
		return mmServiceRequests;
	}

	/**
	 * Set the value related to the column: MmServiceRequests
	 * @param mmServiceRequests the MmServiceRequests value
	 */
	public void setMmServiceRequests (java.util.Set<jkt.hms.masters.business.MmServiceRequest> mmServiceRequests) {
		this.mmServiceRequests = mmServiceRequests;
	}

	public void addToMmServiceRequests (jkt.hms.masters.business.MmServiceRequest mmServiceRequest) {
		if (null == getMmServiceRequests()) setMmServiceRequests(new java.util.TreeSet<jkt.hms.masters.business.MmServiceRequest>());
		getMmServiceRequests().add(mmServiceRequest);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasPriorityCodes)) return false;
		else {
			jkt.hms.masters.business.MasPriorityCodes masPriorityCodes = (jkt.hms.masters.business.MasPriorityCodes) obj;
			if (null == this.getId() || null == masPriorityCodes.getId()) return false;
			else return (this.getId().equals(masPriorityCodes.getId()));
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
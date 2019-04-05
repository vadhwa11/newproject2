package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_session table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_session"
 */

public abstract class BaseMasSession  implements Serializable {

	public static String REF = "MasSession";
	public static String PROP_STATUS = "Status";
	public static String PROP_SESSION_NAME = "SessionName";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_TO_TIME = "ToTime";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_FROM_TIME = "FromTime";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseMasSession () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasSession (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String fromTime;
	private java.lang.String toTime;
	private java.lang.String sessionName;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;

	// collections
	private java.util.Set<jkt.hms.masters.business.AppSetup> appSetups;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="org.hibernate.id.IncrementGenerator"
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
	 * Return the value associated with the column: from_time
	 */
	public java.lang.String getFromTime () {
		return fromTime;
	}

	/**
	 * Set the value related to the column: from_time
	 * @param fromTime the from_time value
	 */
	public void setFromTime (java.lang.String fromTime) {
		this.fromTime = fromTime;
	}



	/**
	 * Return the value associated with the column: to_time
	 */
	public java.lang.String getToTime () {
		return toTime;
	}

	/**
	 * Set the value related to the column: to_time
	 * @param toTime the to_time value
	 */
	public void setToTime (java.lang.String toTime) {
		this.toTime = toTime;
	}



	/**
	 * Return the value associated with the column: session_name
	 */
	public java.lang.String getSessionName () {
		return sessionName;
	}

	/**
	 * Set the value related to the column: session_name
	 * @param sessionName the session_name value
	 */
	public void setSessionName (java.lang.String sessionName) {
		this.sessionName = sessionName;
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
	 * Return the value associated with the column: AppSetups
	 */
	public java.util.Set<jkt.hms.masters.business.AppSetup> getAppSetups () {
		return appSetups;
	}

	/**
	 * Set the value related to the column: AppSetups
	 * @param appSetups the AppSetups value
	 */
	public void setAppSetups (java.util.Set<jkt.hms.masters.business.AppSetup> appSetups) {
		this.appSetups = appSetups;
	}

	public void addToAppSetups (jkt.hms.masters.business.AppSetup appSetup) {
		if (null == getAppSetups()) setAppSetups(new java.util.TreeSet<jkt.hms.masters.business.AppSetup>());
		getAppSetups().add(appSetup);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasSession)) return false;
		else {
			jkt.hms.masters.business.MasSession masSession = (jkt.hms.masters.business.MasSession) obj;
			if (null == this.getId() || null == masSession.getId()) return false;
			else return (this.getId().equals(masSession.getId()));
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
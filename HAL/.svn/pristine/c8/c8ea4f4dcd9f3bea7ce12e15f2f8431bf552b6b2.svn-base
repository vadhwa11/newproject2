package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the PHYSIO_VISIT_ENTRY_DETAIL table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="PHYSIO_VISIT_ENTRY_DETAIL"
 */

public abstract class BasePhysioVisitEntryDetail  implements Serializable {

	public static String REF = "PhysioVisitEntryDetail";
	public static String PROP_THARAPY = "Tharapy";
	public static String PROP_NEXT_APP_DATE = "NextAppDate";
	public static String PROP_DURATION = "Duration";
	public static String PROP_SITTING_TIME = "SittingTime";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_TIME_BEGIN = "TimeBegin";
	public static String PROP_ID = "Id";
	public static String PROP_FREQUENCY = "Frequency";
	public static String PROP_NEXT_APP_TIME = "NextAppTime";
	public static String PROP_TIME_COMPLETE = "TimeComplete";
	public static String PROP_VISIT_ENTRY_HEADER = "VisitEntryHeader";
	public static String PROP_NO_OF_DAYS = "NoOfDays";


	// constructors
	public BasePhysioVisitEntryDetail () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePhysioVisitEntryDetail (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String duration;
	private java.lang.Integer noOfDays;
	private java.lang.String timeBegin;
	private java.lang.String timeComplete;
	private java.lang.String sittingTime;
	private java.util.Date nextAppDate;
	private java.lang.String nextAppTime;
	private java.lang.String remarks;

	// many to one
	private jkt.hms.masters.business.MasTherapyType tharapy;
	private jkt.hms.masters.business.MasFrequency frequency;
	private jkt.hms.masters.business.PhysioVisitEntryHeader visitEntryHeader;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="VISIT_ENTRY_DETAIL_ID"
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
	 * Return the value associated with the column: duration
	 */
	public java.lang.String getDuration () {
		return duration;
	}

	/**
	 * Set the value related to the column: duration
	 * @param duration the duration value
	 */
	public void setDuration (java.lang.String duration) {
		this.duration = duration;
	}



	/**
	 * Return the value associated with the column: no_of_days
	 */
	public java.lang.Integer getNoOfDays () {
		return noOfDays;
	}

	/**
	 * Set the value related to the column: no_of_days
	 * @param noOfDays the no_of_days value
	 */
	public void setNoOfDays (java.lang.Integer noOfDays) {
		this.noOfDays = noOfDays;
	}



	/**
	 * Return the value associated with the column: time_begin
	 */
	public java.lang.String getTimeBegin () {
		return timeBegin;
	}

	/**
	 * Set the value related to the column: time_begin
	 * @param timeBegin the time_begin value
	 */
	public void setTimeBegin (java.lang.String timeBegin) {
		this.timeBegin = timeBegin;
	}



	/**
	 * Return the value associated with the column: time_complete
	 */
	public java.lang.String getTimeComplete () {
		return timeComplete;
	}

	/**
	 * Set the value related to the column: time_complete
	 * @param timeComplete the time_complete value
	 */
	public void setTimeComplete (java.lang.String timeComplete) {
		this.timeComplete = timeComplete;
	}



	/**
	 * Return the value associated with the column: sitting_time
	 */
	public java.lang.String getSittingTime () {
		return sittingTime;
	}

	/**
	 * Set the value related to the column: sitting_time
	 * @param sittingTime the sitting_time value
	 */
	public void setSittingTime (java.lang.String sittingTime) {
		this.sittingTime = sittingTime;
	}



	/**
	 * Return the value associated with the column: next_app_date
	 */
	public java.util.Date getNextAppDate () {
		return nextAppDate;
	}

	/**
	 * Set the value related to the column: next_app_date
	 * @param nextAppDate the next_app_date value
	 */
	public void setNextAppDate (java.util.Date nextAppDate) {
		this.nextAppDate = nextAppDate;
	}



	/**
	 * Return the value associated with the column: next_app_time
	 */
	public java.lang.String getNextAppTime () {
		return nextAppTime;
	}

	/**
	 * Set the value related to the column: next_app_time
	 * @param nextAppTime the next_app_time value
	 */
	public void setNextAppTime (java.lang.String nextAppTime) {
		this.nextAppTime = nextAppTime;
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
	 * Return the value associated with the column: tharapy_id
	 */
	public jkt.hms.masters.business.MasTherapyType getTharapy () {
		return tharapy;
	}

	/**
	 * Set the value related to the column: tharapy_id
	 * @param tharapy the tharapy_id value
	 */
	public void setTharapy (jkt.hms.masters.business.MasTherapyType tharapy) {
		this.tharapy = tharapy;
	}



	/**
	 * Return the value associated with the column: frequency_id
	 */
	public jkt.hms.masters.business.MasFrequency getFrequency () {
		return frequency;
	}

	/**
	 * Set the value related to the column: frequency_id
	 * @param frequency the frequency_id value
	 */
	public void setFrequency (jkt.hms.masters.business.MasFrequency frequency) {
		this.frequency = frequency;
	}



	/**
	 * Return the value associated with the column: visit_entry_header_id
	 */
	public jkt.hms.masters.business.PhysioVisitEntryHeader getVisitEntryHeader () {
		return visitEntryHeader;
	}

	/**
	 * Set the value related to the column: visit_entry_header_id
	 * @param visitEntryHeader the visit_entry_header_id value
	 */
	public void setVisitEntryHeader (jkt.hms.masters.business.PhysioVisitEntryHeader visitEntryHeader) {
		this.visitEntryHeader = visitEntryHeader;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PhysioVisitEntryDetail)) return false;
		else {
			jkt.hms.masters.business.PhysioVisitEntryDetail physioVisitEntryDetail = (jkt.hms.masters.business.PhysioVisitEntryDetail) obj;
			if (null == this.getId() || null == physioVisitEntryDetail.getId()) return false;
			else return (this.getId().equals(physioVisitEntryDetail.getId()));
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
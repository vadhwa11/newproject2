package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the app_setup table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="app_setup"
 */

public abstract class BaseAppSetup  implements Serializable {

	public static String REF = "AppSetup";
	public static String PROP_START_TOKEN = "StartToken";
	public static String PROP_VALID_FROM = "ValidFrom";
	public static String PROP_DEPT = "Dept";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_PERCENTAGE_FOR_SLOTS = "PercentageForSlots";
	public static String PROP_SLOT_DURATION = "SlotDuration";
	public static String PROP_DAY_OF_WEEK = "DayOfWeek";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_BREAK_TO_TIME = "BreakToTime";
	public static String PROP_SESSION = "Session";
	public static String PROP_TO_TIME = "ToTime";
	public static String PROP_TOTAL_ONLINE_TOKEN = "TotalOnlineToken";
	public static String PROP_DAYS = "Days";
	public static String PROP_MAX_NO_OF_DAYS = "MaxNoOfDays";
	public static String PROP_FROM_TIME = "FromTime";
	public static String PROP_VALID_TO = "ValidTo";
	public static String PROP_START_TIME = "StartTime";
	public static String PROP_BEFORE_TIME = "BeforeTime";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DOCTOR = "Doctor";
	public static String PROP_TIME_TAKEN = "TimeTaken";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_NO_OF_DOCTOR = "NoOfDoctor";
	public static String PROP_BREAK_FROM_TIME = "BreakFromTime";
	public static String PROP_TOTAL_TOKEN = "TotalToken";
	public static String PROP_MIN_NO_OF_DAYS = "MinNoOfDays";
	public static String PROP_ID = "Id";
	public static String PROP_END_TIME = "EndTime";
	public static String PROP_BREAK_TO_TIME3 = "BreakToTime3";
	public static String PROP_TOTAL_INTERVAL = "TotalInterval";
	public static String PROP_BREAK_TO_TIME2 = "BreakToTime2";
	public static String PROP_BREAK_FROM_TIME2 = "BreakFromTime2";
	public static String PROP_BREAK_FROM_TIME3 = "BreakFromTime3";


	// constructors
	public BaseAppSetup () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAppSetup (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer noOfDoctor;
	private java.lang.String fromTime;
	private java.lang.String toTime;
	private java.lang.String slotDuration;
	private java.lang.Integer percentageForSlots;
	private java.lang.String breakFromTime;
	private java.lang.Integer maxNoOfDays;
	private java.lang.Integer minNoOfDays;
	private java.lang.String beforeTime;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String days;
	private java.lang.String breakToTime;
	private java.util.Date validFrom;
	private java.util.Date validTo;
	private java.lang.Integer dayOfWeek;
	private java.lang.String breakFromTime2;
	private java.lang.String breakFromTime3;
	private java.lang.String breakToTime2;
	private java.lang.String breakToTime3;
	private java.lang.Integer totalToken;
	private java.lang.Integer totalInterval;
	private java.lang.Integer startToken;
	private java.lang.Integer totalOnlineToken;
	private java.lang.Integer timeTaken;
	private java.lang.String startTime;
	private java.lang.String endTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasSession session;
	private jkt.hms.masters.business.MasDepartment dept;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasEmployee doctor;



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
	 * Return the value associated with the column: no_of_doctor
	 */
	public java.lang.Integer getNoOfDoctor () {
		return noOfDoctor;
	}

	/**
	 * Set the value related to the column: no_of_doctor
	 * @param noOfDoctor the no_of_doctor value
	 */
	public void setNoOfDoctor (java.lang.Integer noOfDoctor) {
		this.noOfDoctor = noOfDoctor;
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
	 * Return the value associated with the column: slot_duration
	 */
	public java.lang.String getSlotDuration () {
		return slotDuration;
	}

	/**
	 * Set the value related to the column: slot_duration
	 * @param slotDuration the slot_duration value
	 */
	public void setSlotDuration (java.lang.String slotDuration) {
		this.slotDuration = slotDuration;
	}



	/**
	 * Return the value associated with the column: percentage_for_slots
	 */
	public java.lang.Integer getPercentageForSlots () {
		return percentageForSlots;
	}

	/**
	 * Set the value related to the column: percentage_for_slots
	 * @param percentageForSlots the percentage_for_slots value
	 */
	public void setPercentageForSlots (java.lang.Integer percentageForSlots) {
		this.percentageForSlots = percentageForSlots;
	}



	/**
	 * Return the value associated with the column: break_from_time
	 */
	public java.lang.String getBreakFromTime () {
		return breakFromTime;
	}

	/**
	 * Set the value related to the column: break_from_time
	 * @param breakFromTime the break_from_time value
	 */
	public void setBreakFromTime (java.lang.String breakFromTime) {
		this.breakFromTime = breakFromTime;
	}



	/**
	 * Return the value associated with the column: max_no_of_days
	 */
	public java.lang.Integer getMaxNoOfDays () {
		return maxNoOfDays;
	}

	/**
	 * Set the value related to the column: max_no_of_days
	 * @param maxNoOfDays the max_no_of_days value
	 */
	public void setMaxNoOfDays (java.lang.Integer maxNoOfDays) {
		this.maxNoOfDays = maxNoOfDays;
	}



	/**
	 * Return the value associated with the column: min_no_of_days
	 */
	public java.lang.Integer getMinNoOfDays () {
		return minNoOfDays;
	}

	/**
	 * Set the value related to the column: min_no_of_days
	 * @param minNoOfDays the min_no_of_days value
	 */
	public void setMinNoOfDays (java.lang.Integer minNoOfDays) {
		this.minNoOfDays = minNoOfDays;
	}



	/**
	 * Return the value associated with the column: before_time
	 */
	public java.lang.String getBeforeTime () {
		return beforeTime;
	}

	/**
	 * Set the value related to the column: before_time
	 * @param beforeTime the before_time value
	 */
	public void setBeforeTime (java.lang.String beforeTime) {
		this.beforeTime = beforeTime;
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
	 * Return the value associated with the column: days
	 */
	public java.lang.String getDays () {
		return days;
	}

	/**
	 * Set the value related to the column: days
	 * @param days the days value
	 */
	public void setDays (java.lang.String days) {
		this.days = days;
	}



	/**
	 * Return the value associated with the column: break_to_time
	 */
	public java.lang.String getBreakToTime () {
		return breakToTime;
	}

	/**
	 * Set the value related to the column: break_to_time
	 * @param breakToTime the break_to_time value
	 */
	public void setBreakToTime (java.lang.String breakToTime) {
		this.breakToTime = breakToTime;
	}



	/**
	 * Return the value associated with the column: valid_from
	 */
	public java.util.Date getValidFrom () {
		return validFrom;
	}

	/**
	 * Set the value related to the column: valid_from
	 * @param validFrom the valid_from value
	 */
	public void setValidFrom (java.util.Date validFrom) {
		this.validFrom = validFrom;
	}



	/**
	 * Return the value associated with the column: valid_to
	 */
	public java.util.Date getValidTo () {
		return validTo;
	}

	/**
	 * Set the value related to the column: valid_to
	 * @param validTo the valid_to value
	 */
	public void setValidTo (java.util.Date validTo) {
		this.validTo = validTo;
	}



	/**
	 * Return the value associated with the column: day_Of_Week
	 */
	public java.lang.Integer getDayOfWeek () {
		return dayOfWeek;
	}

	/**
	 * Set the value related to the column: day_Of_Week
	 * @param dayOfWeek the day_Of_Week value
	 */
	public void setDayOfWeek (java.lang.Integer dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}



	/**
	 * Return the value associated with the column: break_from_time2
	 */
	public java.lang.String getBreakFromTime2 () {
		return breakFromTime2;
	}

	/**
	 * Set the value related to the column: break_from_time2
	 * @param breakFromTime2 the break_from_time2 value
	 */
	public void setBreakFromTime2 (java.lang.String breakFromTime2) {
		this.breakFromTime2 = breakFromTime2;
	}



	/**
	 * Return the value associated with the column: break_from_time3
	 */
	public java.lang.String getBreakFromTime3 () {
		return breakFromTime3;
	}

	/**
	 * Set the value related to the column: break_from_time3
	 * @param breakFromTime3 the break_from_time3 value
	 */
	public void setBreakFromTime3 (java.lang.String breakFromTime3) {
		this.breakFromTime3 = breakFromTime3;
	}



	/**
	 * Return the value associated with the column: break_to_time2
	 */
	public java.lang.String getBreakToTime2 () {
		return breakToTime2;
	}

	/**
	 * Set the value related to the column: break_to_time2
	 * @param breakToTime2 the break_to_time2 value
	 */
	public void setBreakToTime2 (java.lang.String breakToTime2) {
		this.breakToTime2 = breakToTime2;
	}



	/**
	 * Return the value associated with the column: break_to_time3
	 */
	public java.lang.String getBreakToTime3 () {
		return breakToTime3;
	}

	/**
	 * Set the value related to the column: break_to_time3
	 * @param breakToTime3 the break_to_time3 value
	 */
	public void setBreakToTime3 (java.lang.String breakToTime3) {
		this.breakToTime3 = breakToTime3;
	}



	/**
	 * Return the value associated with the column: total_token
	 */
	public java.lang.Integer getTotalToken () {
		return totalToken;
	}

	/**
	 * Set the value related to the column: total_token
	 * @param totalToken the total_token value
	 */
	public void setTotalToken (java.lang.Integer totalToken) {
		this.totalToken = totalToken;
	}



	/**
	 * Return the value associated with the column: total_interval
	 */
	public java.lang.Integer getTotalInterval () {
		return totalInterval;
	}

	/**
	 * Set the value related to the column: total_interval
	 * @param totalInterval the total_interval value
	 */
	public void setTotalInterval (java.lang.Integer totalInterval) {
		this.totalInterval = totalInterval;
	}



	/**
	 * Return the value associated with the column: start_token
	 */
	public java.lang.Integer getStartToken () {
		return startToken;
	}

	/**
	 * Set the value related to the column: start_token
	 * @param startToken the start_token value
	 */
	public void setStartToken (java.lang.Integer startToken) {
		this.startToken = startToken;
	}



	/**
	 * Return the value associated with the column: total_online_token
	 */
	public java.lang.Integer getTotalOnlineToken () {
		return totalOnlineToken;
	}

	/**
	 * Set the value related to the column: total_online_token
	 * @param totalOnlineToken the total_online_token value
	 */
	public void setTotalOnlineToken (java.lang.Integer totalOnlineToken) {
		this.totalOnlineToken = totalOnlineToken;
	}



	/**
	 * Return the value associated with the column: time_taken
	 */
	public java.lang.Integer getTimeTaken () {
		return timeTaken;
	}

	/**
	 * Set the value related to the column: time_taken
	 * @param timeTaken the time_taken value
	 */
	public void setTimeTaken (java.lang.Integer timeTaken) {
		this.timeTaken = timeTaken;
	}



	/**
	 * Return the value associated with the column: start_time
	 */
	public java.lang.String getStartTime () {
		return startTime;
	}

	/**
	 * Set the value related to the column: start_time
	 * @param startTime the start_time value
	 */
	public void setStartTime (java.lang.String startTime) {
		this.startTime = startTime;
	}



	/**
	 * Return the value associated with the column: end_time
	 */
	public java.lang.String getEndTime () {
		return endTime;
	}

	/**
	 * Set the value related to the column: end_time
	 * @param endTime the end_time value
	 */
	public void setEndTime (java.lang.String endTime) {
		this.endTime = endTime;
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
	 * Return the value associated with the column: session_id
	 */
	public jkt.hms.masters.business.MasSession getSession () {
		return session;
	}

	/**
	 * Set the value related to the column: session_id
	 * @param session the session_id value
	 */
	public void setSession (jkt.hms.masters.business.MasSession session) {
		this.session = session;
	}



	/**
	 * Return the value associated with the column: dept_id
	 */
	public jkt.hms.masters.business.MasDepartment getDept () {
		return dept;
	}

	/**
	 * Set the value related to the column: dept_id
	 * @param dept the dept_id value
	 */
	public void setDept (jkt.hms.masters.business.MasDepartment dept) {
		this.dept = dept;
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
	 * Return the value associated with the column: doctor_id
	 */
	public jkt.hms.masters.business.MasEmployee getDoctor () {
		return doctor;
	}

	/**
	 * Set the value related to the column: doctor_id
	 * @param doctor the doctor_id value
	 */
	public void setDoctor (jkt.hms.masters.business.MasEmployee doctor) {
		this.doctor = doctor;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.AppSetup)) return false;
		else {
			jkt.hms.masters.business.AppSetup appSetup = (jkt.hms.masters.business.AppSetup) obj;
			if (null == this.getId() || null == appSetup.getId()) return false;
			else return (this.getId().equals(appSetup.getId()));
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
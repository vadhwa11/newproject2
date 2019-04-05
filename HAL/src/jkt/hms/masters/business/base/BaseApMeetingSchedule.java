package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the ap_meeting_schedule
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="ap_meeting_schedule"
 */

public abstract class BaseApMeetingSchedule implements Serializable {

	public static String REF = "ApMeetingSchedule";
	public static String PROP_ACTUAL_MEETING_DATE = "ActualMeetingDate";
	public static String PROP_MEETING_NO = "MeetingNo";
	public static String PROP_PROPOSED_TIME_FROM = "ProposedTimeFrom";
	public static String PROP_ACTUAL_TIME_TO = "ActualTimeTo";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_PROPOSED_DATE = "ProposedDate";
	public static String PROP_OTHER_ATTENDEES_EMP = "OtherAttendeesEmp";
	public static String PROP_CHAIRED_BY = "ChairedBy";
	public static String PROP_STATUS = "Status";
	public static String PROP_PROPOSED_TIME_TO = "ProposedTimeTo";
	public static String PROP_MEETING_TITLE = "MeetingTitle";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_VENUE = "Venue";
	public static String PROP_OTHER_ATTENDEES = "OtherAttendees";
	public static String PROP_ACTUAL_CHAIRED_BY = "ActualChairedBy";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ACTUAL_TIME_FROM = "ActualTimeFrom";

	// constructors
	public BaseApMeetingSchedule() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseApMeetingSchedule(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date proposedDate;
	private java.lang.String proposedTimeFrom;
	private java.lang.String proposedTimeTo;
	private java.lang.String venue;
	private java.lang.String meetingTitle;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String otherAttendees;
	private java.lang.String meetingNo;
	private java.util.Date actualMeetingDate;
	private java.lang.String actualTimeFrom;
	private java.lang.String actualTimeTo;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasEmployee chairedBy;
	private jkt.hms.masters.business.MasEmployee otherAttendeesEmp;
	private jkt.hms.masters.business.MasEmployee actualChairedBy;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="ap_meeting_schedule_id"
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
	 * Return the value associated with the column: proposed_date
	 */
	public java.util.Date getProposedDate() {
		return proposedDate;
	}

	/**
	 * Set the value related to the column: proposed_date
	 * 
	 * @param proposedDate
	 *            the proposed_date value
	 */
	public void setProposedDate(java.util.Date proposedDate) {
		this.proposedDate = proposedDate;
	}

	/**
	 * Return the value associated with the column: proposed_time_from
	 */
	public java.lang.String getProposedTimeFrom() {
		return proposedTimeFrom;
	}

	/**
	 * Set the value related to the column: proposed_time_from
	 * 
	 * @param proposedTimeFrom
	 *            the proposed_time_from value
	 */
	public void setProposedTimeFrom(java.lang.String proposedTimeFrom) {
		this.proposedTimeFrom = proposedTimeFrom;
	}

	/**
	 * Return the value associated with the column: proposed_time_to
	 */
	public java.lang.String getProposedTimeTo() {
		return proposedTimeTo;
	}

	/**
	 * Set the value related to the column: proposed_time_to
	 * 
	 * @param proposedTimeTo
	 *            the proposed_time_to value
	 */
	public void setProposedTimeTo(java.lang.String proposedTimeTo) {
		this.proposedTimeTo = proposedTimeTo;
	}

	/**
	 * Return the value associated with the column: venue
	 */
	public java.lang.String getVenue() {
		return venue;
	}

	/**
	 * Set the value related to the column: venue
	 * 
	 * @param venue
	 *            the venue value
	 */
	public void setVenue(java.lang.String venue) {
		this.venue = venue;
	}

	/**
	 * Return the value associated with the column: meeting_title
	 */
	public java.lang.String getMeetingTitle() {
		return meetingTitle;
	}

	/**
	 * Set the value related to the column: meeting_title
	 * 
	 * @param meetingTitle
	 *            the meeting_title value
	 */
	public void setMeetingTitle(java.lang.String meetingTitle) {
		this.meetingTitle = meetingTitle;
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
	 * Return the value associated with the column: other_attandees
	 */
	public java.lang.String getOtherAttendees() {
		return otherAttendees;
	}

	/**
	 * Set the value related to the column: other_attandees
	 * 
	 * @param otherAttendees
	 *            the other_attandees value
	 */
	public void setOtherAttendees(java.lang.String otherAttendees) {
		this.otherAttendees = otherAttendees;
	}

	/**
	 * Return the value associated with the column: meeting_no
	 */
	public java.lang.String getMeetingNo() {
		return meetingNo;
	}

	/**
	 * Set the value related to the column: meeting_no
	 * 
	 * @param meetingNo
	 *            the meeting_no value
	 */
	public void setMeetingNo(java.lang.String meetingNo) {
		this.meetingNo = meetingNo;
	}

	/**
	 * Return the value associated with the column: actual_date
	 */
	public java.util.Date getActualMeetingDate() {
		return actualMeetingDate;
	}

	/**
	 * Set the value related to the column: actual_date
	 * 
	 * @param actualMeetingDate
	 *            the actual_date value
	 */
	public void setActualMeetingDate(java.util.Date actualMeetingDate) {
		this.actualMeetingDate = actualMeetingDate;
	}

	/**
	 * Return the value associated with the column: actual_time_from
	 */
	public java.lang.String getActualTimeFrom() {
		return actualTimeFrom;
	}

	/**
	 * Set the value related to the column: actual_time_from
	 * 
	 * @param actualTimeFrom
	 *            the actual_time_from value
	 */
	public void setActualTimeFrom(java.lang.String actualTimeFrom) {
		this.actualTimeFrom = actualTimeFrom;
	}

	/**
	 * Return the value associated with the column: actual_time_to
	 */
	public java.lang.String getActualTimeTo() {
		return actualTimeTo;
	}

	/**
	 * Set the value related to the column: actual_time_to
	 * 
	 * @param actualTimeTo
	 *            the actual_time_to value
	 */
	public void setActualTimeTo(java.lang.String actualTimeTo) {
		this.actualTimeTo = actualTimeTo;
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
	 * Return the value associated with the column: chaired_by_id
	 */
	public jkt.hms.masters.business.MasEmployee getChairedBy() {
		return chairedBy;
	}

	/**
	 * Set the value related to the column: chaired_by_id
	 * 
	 * @param chairedBy
	 *            the chaired_by_id value
	 */
	public void setChairedBy(jkt.hms.masters.business.MasEmployee chairedBy) {
		this.chairedBy = chairedBy;
	}

	/**
	 * Return the value associated with the column: other_attandees_employee
	 */
	public jkt.hms.masters.business.MasEmployee getOtherAttendeesEmp() {
		return otherAttendeesEmp;
	}

	/**
	 * Set the value related to the column: other_attandees_employee
	 * 
	 * @param otherAttendeesEmp
	 *            the other_attandees_employee value
	 */
	public void setOtherAttendeesEmp(
			jkt.hms.masters.business.MasEmployee otherAttendeesEmp) {
		this.otherAttendeesEmp = otherAttendeesEmp;
	}

	/**
	 * Return the value associated with the column: actual_chaired_by
	 */
	public jkt.hms.masters.business.MasEmployee getActualChairedBy() {
		return actualChairedBy;
	}

	/**
	 * Set the value related to the column: actual_chaired_by
	 * 
	 * @param actualChairedBy
	 *            the actual_chaired_by value
	 */
	public void setActualChairedBy(
			jkt.hms.masters.business.MasEmployee actualChairedBy) {
		this.actualChairedBy = actualChairedBy;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.ApMeetingSchedule))
			return false;
		else {
			jkt.hms.masters.business.ApMeetingSchedule apMeetingSchedule = (jkt.hms.masters.business.ApMeetingSchedule) obj;
			if (null == this.getId() || null == apMeetingSchedule.getId())
				return false;
			else
				return (this.getId().equals(apMeetingSchedule.getId()));
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
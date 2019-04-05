package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the ap_meeting_agenda table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="ap_meeting_agenda"
 */

public abstract class BaseApMeetingAgenda implements Serializable {

	public static String REF = "ApMeetingAgenda";
	public static String PROP_STATUS = "Status";
	public static String PROP_AGENDA_REQUEST = "AgendaRequest";
	public static String PROP_ID = "Id";
	public static String PROP_MEETING = "Meeting";

	// constructors
	public BaseApMeetingAgenda() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseApMeetingAgenda(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.ApAgendaRequest agendaRequest;
	private jkt.hms.masters.business.ApMeetingSchedule meeting;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="ap_meeting_agenda_id"
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
	 * Return the value associated with the column: agenda_request_id
	 */
	public jkt.hms.masters.business.ApAgendaRequest getAgendaRequest() {
		return agendaRequest;
	}

	/**
	 * Set the value related to the column: agenda_request_id
	 * 
	 * @param agendaRequest
	 *            the agenda_request_id value
	 */
	public void setAgendaRequest(
			jkt.hms.masters.business.ApAgendaRequest agendaRequest) {
		this.agendaRequest = agendaRequest;
	}

	/**
	 * Return the value associated with the column: meeting_id
	 */
	public jkt.hms.masters.business.ApMeetingSchedule getMeeting() {
		return meeting;
	}

	/**
	 * Set the value related to the column: meeting_id
	 * 
	 * @param meeting
	 *            the meeting_id value
	 */
	public void setMeeting(jkt.hms.masters.business.ApMeetingSchedule meeting) {
		this.meeting = meeting;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.ApMeetingAgenda))
			return false;
		else {
			jkt.hms.masters.business.ApMeetingAgenda apMeetingAgenda = (jkt.hms.masters.business.ApMeetingAgenda) obj;
			if (null == this.getId() || null == apMeetingAgenda.getId())
				return false;
			else
				return (this.getId().equals(apMeetingAgenda.getId()));
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
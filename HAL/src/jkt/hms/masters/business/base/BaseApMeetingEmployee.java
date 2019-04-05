package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the ap_meeting_employee
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="ap_meeting_employee"
 */

public abstract class BaseApMeetingEmployee implements Serializable {

	public static String REF = "ApMeetingEmployee";
	public static String PROP_PRESENCE_STATUS = "PresenceStatus";
	public static String PROP_EMP = "Emp";
	public static String PROP_MEETING = "Meeting";
	public static String PROP_ID = "Id";

	// constructors
	public BaseApMeetingEmployee() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseApMeetingEmployee(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String presenceStatus;

	// many to one
	private jkt.hms.masters.business.MasEmployee emp;
	private jkt.hms.masters.business.ApMeetingSchedule meeting;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="meeting_employee_id"
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
	 * Return the value associated with the column: presence_status
	 */
	public java.lang.String getPresenceStatus() {
		return presenceStatus;
	}

	/**
	 * Set the value related to the column: presence_status
	 * 
	 * @param presenceStatus
	 *            the presence_status value
	 */
	public void setPresenceStatus(java.lang.String presenceStatus) {
		this.presenceStatus = presenceStatus;
	}

	/**
	 * Return the value associated with the column: emp_id
	 */
	public jkt.hms.masters.business.MasEmployee getEmp() {
		return emp;
	}

	/**
	 * Set the value related to the column: emp_id
	 * 
	 * @param emp
	 *            the emp_id value
	 */
	public void setEmp(jkt.hms.masters.business.MasEmployee emp) {
		this.emp = emp;
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
		if (!(obj instanceof jkt.hms.masters.business.ApMeetingEmployee))
			return false;
		else {
			jkt.hms.masters.business.ApMeetingEmployee apMeetingEmployee = (jkt.hms.masters.business.ApMeetingEmployee) obj;
			if (null == this.getId() || null == apMeetingEmployee.getId())
				return false;
			else
				return (this.getId().equals(apMeetingEmployee.getId()));
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
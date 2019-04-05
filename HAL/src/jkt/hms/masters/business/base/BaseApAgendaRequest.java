package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the ap_agenda_request table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="ap_agenda_request"
 */

public abstract class BaseApAgendaRequest implements Serializable {

	public static String REF = "ApAgendaRequest";
	public static String PROP_ACTION_BY = "ActionBy";
	public static String PROP_AGENDA_DATE = "AgendaDate";
	public static String PROP_AGENDA_DETAIL = "AgendaDetail";
	public static String PROP_EMP_ID = "EmpId";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_AGENDA_POINT = "AgendaPoint";
	public static String PROP_MOM_ID = "MomId";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_DECISION_IN_MEETING = "DecisionInMeeting";
	public static String PROP_ID = "Id";
	public static String PROP_ACTION_TO = "ActionTo";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DEPARTMENT_ID = "DepartmentId";

	// constructors
	public BaseApAgendaRequest() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseApAgendaRequest(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String agendaPoint;
	private java.lang.String status;
	private java.lang.String momId;
	private java.util.Date agendaDate;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String decisionInMeeting;
	private java.lang.String actionBy;
	private java.lang.String actionTo;
	private java.lang.String agendaDetail;

	// many to one
	private jkt.hms.masters.business.MasEmployee empId;
	private jkt.hms.masters.business.MasDepartment departmentId;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="ap_agenda_request_id"
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
	 * Return the value associated with the column: agenda_point
	 */
	public java.lang.String getAgendaPoint() {
		return agendaPoint;
	}

	/**
	 * Set the value related to the column: agenda_point
	 * 
	 * @param agendaPoint
	 *            the agenda_point value
	 */
	public void setAgendaPoint(java.lang.String agendaPoint) {
		this.agendaPoint = agendaPoint;
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
	 * Return the value associated with the column: mom_id
	 */
	public java.lang.String getMomId() {
		return momId;
	}

	/**
	 * Set the value related to the column: mom_id
	 * 
	 * @param momId
	 *            the mom_id value
	 */
	public void setMomId(java.lang.String momId) {
		this.momId = momId;
	}

	/**
	 * Return the value associated with the column: agenda_date
	 */
	public java.util.Date getAgendaDate() {
		return agendaDate;
	}

	/**
	 * Set the value related to the column: agenda_date
	 * 
	 * @param agendaDate
	 *            the agenda_date value
	 */
	public void setAgendaDate(java.util.Date agendaDate) {
		this.agendaDate = agendaDate;
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
	 * Return the value associated with the column: decision_in_meeting
	 */
	public java.lang.String getDecisionInMeeting() {
		return decisionInMeeting;
	}

	/**
	 * Set the value related to the column: decision_in_meeting
	 * 
	 * @param decisionInMeeting
	 *            the decision_in_meeting value
	 */
	public void setDecisionInMeeting(java.lang.String decisionInMeeting) {
		this.decisionInMeeting = decisionInMeeting;
	}

	/**
	 * Return the value associated with the column: action_by
	 */
	public java.lang.String getActionBy() {
		return actionBy;
	}

	/**
	 * Set the value related to the column: action_by
	 * 
	 * @param actionBy
	 *            the action_by value
	 */
	public void setActionBy(java.lang.String actionBy) {
		this.actionBy = actionBy;
	}

	/**
	 * Return the value associated with the column: action_to
	 */
	public java.lang.String getActionTo() {
		return actionTo;
	}

	/**
	 * Set the value related to the column: action_to
	 * 
	 * @param actionTo
	 *            the action_to value
	 */
	public void setActionTo(java.lang.String actionTo) {
		this.actionTo = actionTo;
	}

	/**
	 * Return the value associated with the column: agenda_detail
	 */
	public java.lang.String getAgendaDetail() {
		return agendaDetail;
	}

	/**
	 * Set the value related to the column: agenda_detail
	 * 
	 * @param agendaDetail
	 *            the agenda_detail value
	 */
	public void setAgendaDetail(java.lang.String agendaDetail) {
		this.agendaDetail = agendaDetail;
	}

	/**
	 * Return the value associated with the column: emp_id
	 */
	public jkt.hms.masters.business.MasEmployee getEmpId() {
		return empId;
	}

	/**
	 * Set the value related to the column: emp_id
	 * 
	 * @param empId
	 *            the emp_id value
	 */
	public void setEmpId(jkt.hms.masters.business.MasEmployee empId) {
		this.empId = empId;
	}

	/**
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartmentId() {
		return departmentId;
	}

	/**
	 * Set the value related to the column: department_id
	 * 
	 * @param departmentId
	 *            the department_id value
	 */
	public void setDepartmentId(
			jkt.hms.masters.business.MasDepartment departmentId) {
		this.departmentId = departmentId;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.ApAgendaRequest))
			return false;
		else {
			jkt.hms.masters.business.ApAgendaRequest apAgendaRequest = (jkt.hms.masters.business.ApAgendaRequest) obj;
			if (null == this.getId() || null == apAgendaRequest.getId())
				return false;
			else
				return (this.getId().equals(apAgendaRequest.getId()));
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
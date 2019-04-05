package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * mas_agenda_point_for_work_services table. Do not modify this class because it
 * will be overwritten if the configuration file related to this class is
 * modified.
 * 
 * @hibernate.class table="mas_agenda_point_for_work_services"
 */

public abstract class BaseMasAgendaPointForWorkServices implements Serializable {

	public static String REF = "MasAgendaPointForWorkServices";
	public static String PROP_AGENA_REMARKS = "AgenaRemarks";
	public static String PROP_STATUS = "Status";
	public static String PROP_MOM_NO = "MomNo";
	public static String PROP_AGENDA_DATE = "AgendaDate";
	public static String PROP_AGENDA_SUMMARY = "AgendaSummary";
	public static String PROP_ATTENDEES = "Attendees";
	public static String PROP_AGENDA_TIME = "AgendaTime";
	public static String PROP_LST_CHG_BY = "LstChgBy";
	public static String PROP_MINTS_BY = "MintsBy";
	public static String PROP_MOM_DATE = "MomDate";
	public static String PROP_AGENDA_NO = "AgendaNo";
	public static String PROP_CHAIRED_BY = "ChairedBy";
	public static String PROP_ACTUAL_STARTED_TIME = "ActualStartedTime";
	public static String PROP_DEPARTMENT_NAME = "DepartmentName";
	public static String PROP_AGENDA_TYPE = "AgendaType";
	public static String PROP_ABSENTEES = "Absentees";
	public static String PROP_AGENDA_PLACE = "AgendaPlace";
	public static String PROP_ENDING_TIME = "EndingTime";
	public static String PROP_RESOURSE_PATH = "ResoursePath";
	public static String PROP_ID = "Id";
	public static String PROP_ACTUAL_ENDED_TIME = "ActualEndedTime";
	public static String PROP_STARTING_TIME = "StartingTime";

	// constructors
	public BaseMasAgendaPointForWorkServices() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasAgendaPointForWorkServices(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String agendaNo;
	private java.util.Date agendaDate;
	private java.lang.String agendaTime;
	private java.lang.String agendaType;
	private java.lang.String agendaPlace;
	private java.lang.String startingTime;
	private java.lang.String endingTime;
	private java.lang.String agendaSummary;
	private java.lang.String status;
	private java.lang.String lstChgBy;
	private java.lang.String departmentName;
	private java.lang.String momNo;
	private java.util.Date momDate;
	private java.lang.String attendees;
	private java.lang.String absentees;
	private java.lang.String actualStartedTime;
	private java.lang.String actualEndedTime;
	private java.lang.String chairedBy;
	private java.lang.String mintsBy;
	private java.lang.String resoursePath;
	private java.lang.String agenaRemarks;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="id"
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
	 * Return the value associated with the column: agenda_no
	 */
	public java.lang.String getAgendaNo() {
		return agendaNo;
	}

	/**
	 * Set the value related to the column: agenda_no
	 * 
	 * @param agendaNo
	 *            the agenda_no value
	 */
	public void setAgendaNo(java.lang.String agendaNo) {
		this.agendaNo = agendaNo;
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
	 * Return the value associated with the column: agenda_time
	 */
	public java.lang.String getAgendaTime() {
		return agendaTime;
	}

	/**
	 * Set the value related to the column: agenda_time
	 * 
	 * @param agendaTime
	 *            the agenda_time value
	 */
	public void setAgendaTime(java.lang.String agendaTime) {
		this.agendaTime = agendaTime;
	}

	/**
	 * Return the value associated with the column: agenda_type
	 */
	public java.lang.String getAgendaType() {
		return agendaType;
	}

	/**
	 * Set the value related to the column: agenda_type
	 * 
	 * @param agendaType
	 *            the agenda_type value
	 */
	public void setAgendaType(java.lang.String agendaType) {
		this.agendaType = agendaType;
	}

	/**
	 * Return the value associated with the column: agenda_place
	 */
	public java.lang.String getAgendaPlace() {
		return agendaPlace;
	}

	/**
	 * Set the value related to the column: agenda_place
	 * 
	 * @param agendaPlace
	 *            the agenda_place value
	 */
	public void setAgendaPlace(java.lang.String agendaPlace) {
		this.agendaPlace = agendaPlace;
	}

	/**
	 * Return the value associated with the column: starting_time
	 */
	public java.lang.String getStartingTime() {
		return startingTime;
	}

	/**
	 * Set the value related to the column: starting_time
	 * 
	 * @param startingTime
	 *            the starting_time value
	 */
	public void setStartingTime(java.lang.String startingTime) {
		this.startingTime = startingTime;
	}

	/**
	 * Return the value associated with the column: ending_time
	 */
	public java.lang.String getEndingTime() {
		return endingTime;
	}

	/**
	 * Set the value related to the column: ending_time
	 * 
	 * @param endingTime
	 *            the ending_time value
	 */
	public void setEndingTime(java.lang.String endingTime) {
		this.endingTime = endingTime;
	}

	/**
	 * Return the value associated with the column: agenda_summary
	 */
	public java.lang.String getAgendaSummary() {
		return agendaSummary;
	}

	/**
	 * Set the value related to the column: agenda_summary
	 * 
	 * @param agendaSummary
	 *            the agenda_summary value
	 */
	public void setAgendaSummary(java.lang.String agendaSummary) {
		this.agendaSummary = agendaSummary;
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
	 * Return the value associated with the column: lst_chg_by
	 */
	public java.lang.String getLstChgBy() {
		return lstChgBy;
	}

	/**
	 * Set the value related to the column: lst_chg_by
	 * 
	 * @param lstChgBy
	 *            the lst_chg_by value
	 */
	public void setLstChgBy(java.lang.String lstChgBy) {
		this.lstChgBy = lstChgBy;
	}

	/**
	 * Return the value associated with the column: department_name
	 */
	public java.lang.String getDepartmentName() {
		return departmentName;
	}

	/**
	 * Set the value related to the column: department_name
	 * 
	 * @param departmentName
	 *            the department_name value
	 */
	public void setDepartmentName(java.lang.String departmentName) {
		this.departmentName = departmentName;
	}

	/**
	 * Return the value associated with the column: mom_no
	 */
	public java.lang.String getMomNo() {
		return momNo;
	}

	/**
	 * Set the value related to the column: mom_no
	 * 
	 * @param momNo
	 *            the mom_no value
	 */
	public void setMomNo(java.lang.String momNo) {
		this.momNo = momNo;
	}

	/**
	 * Return the value associated with the column: mom_date
	 */
	public java.util.Date getMomDate() {
		return momDate;
	}

	/**
	 * Set the value related to the column: mom_date
	 * 
	 * @param momDate
	 *            the mom_date value
	 */
	public void setMomDate(java.util.Date momDate) {
		this.momDate = momDate;
	}

	/**
	 * Return the value associated with the column: attendees
	 */
	public java.lang.String getAttendees() {
		return attendees;
	}

	/**
	 * Set the value related to the column: attendees
	 * 
	 * @param attendees
	 *            the attendees value
	 */
	public void setAttendees(java.lang.String attendees) {
		this.attendees = attendees;
	}

	/**
	 * Return the value associated with the column: absentees
	 */
	public java.lang.String getAbsentees() {
		return absentees;
	}

	/**
	 * Set the value related to the column: absentees
	 * 
	 * @param absentees
	 *            the absentees value
	 */
	public void setAbsentees(java.lang.String absentees) {
		this.absentees = absentees;
	}

	/**
	 * Return the value associated with the column: actual_started_time
	 */
	public java.lang.String getActualStartedTime() {
		return actualStartedTime;
	}

	/**
	 * Set the value related to the column: actual_started_time
	 * 
	 * @param actualStartedTime
	 *            the actual_started_time value
	 */
	public void setActualStartedTime(java.lang.String actualStartedTime) {
		this.actualStartedTime = actualStartedTime;
	}

	/**
	 * Return the value associated with the column: actual_ended_time
	 */
	public java.lang.String getActualEndedTime() {
		return actualEndedTime;
	}

	/**
	 * Set the value related to the column: actual_ended_time
	 * 
	 * @param actualEndedTime
	 *            the actual_ended_time value
	 */
	public void setActualEndedTime(java.lang.String actualEndedTime) {
		this.actualEndedTime = actualEndedTime;
	}

	/**
	 * Return the value associated with the column: chaired_by
	 */
	public java.lang.String getChairedBy() {
		return chairedBy;
	}

	/**
	 * Set the value related to the column: chaired_by
	 * 
	 * @param chairedBy
	 *            the chaired_by value
	 */
	public void setChairedBy(java.lang.String chairedBy) {
		this.chairedBy = chairedBy;
	}

	/**
	 * Return the value associated with the column: mints_by
	 */
	public java.lang.String getMintsBy() {
		return mintsBy;
	}

	/**
	 * Set the value related to the column: mints_by
	 * 
	 * @param mintsBy
	 *            the mints_by value
	 */
	public void setMintsBy(java.lang.String mintsBy) {
		this.mintsBy = mintsBy;
	}

	/**
	 * Return the value associated with the column: resourse_path
	 */
	public java.lang.String getResoursePath() {
		return resoursePath;
	}

	/**
	 * Set the value related to the column: resourse_path
	 * 
	 * @param resoursePath
	 *            the resourse_path value
	 */
	public void setResoursePath(java.lang.String resoursePath) {
		this.resoursePath = resoursePath;
	}

	/**
	 * Return the value associated with the column: agena_remarks
	 */
	public java.lang.String getAgenaRemarks() {
		return agenaRemarks;
	}

	/**
	 * Set the value related to the column: agena_remarks
	 * 
	 * @param agenaRemarks
	 *            the agena_remarks value
	 */
	public void setAgenaRemarks(java.lang.String agenaRemarks) {
		this.agenaRemarks = agenaRemarks;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MasAgendaPointForWorkServices))
			return false;
		else {
			jkt.hms.masters.business.MasAgendaPointForWorkServices masAgendaPointForWorkServices = (jkt.hms.masters.business.MasAgendaPointForWorkServices) obj;
			if (null == this.getId()
					|| null == masAgendaPointForWorkServices.getId())
				return false;
			else
				return (this.getId().equals(masAgendaPointForWorkServices
						.getId()));
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
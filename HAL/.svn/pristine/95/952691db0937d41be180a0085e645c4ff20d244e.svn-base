package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the MEETING_HELD_AGENCIES table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="MEETING_HELD_AGENCIES"
 */

public abstract class BaseMeetingHeldAgencies  implements Serializable {

	public static String REF = "MeetingHeldAgencies";
	public static String PROP_DECISION_IMPLEMENT_ACTION = "DecisionImplementAction";
	public static String PROP_PARTICULAR_OF_MEETING = "ParticularOfMeeting";
	public static String PROP_SUMMARY_DECISION_TAKEN = "SummaryDecisionTaken";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_ID = "Id";
	public static String PROP_SUBJECT_DISCUSSED_MEETING = "SubjectDiscussedMeeting";
	public static String PROP_DEPARTMENT_ID = "DepartmentId";
	public static String PROP_DATE_OF_MEETING = "DateOfMeeting";


	// constructors
	public BaseMeetingHeldAgencies () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMeetingHeldAgencies (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String particularOfMeeting;
	private java.util.Date dateOfMeeting;
	private java.lang.String subjectDiscussedMeeting;
	private java.lang.String decisionImplementAction;
	private java.lang.String summaryDecisionTaken;
	private java.lang.String remarks;

	// many to one
	private jkt.hms.masters.business.MasDepartment departmentId;
	private jkt.hms.masters.business.MasHospital hospitalId;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="ID"
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
	 * Return the value associated with the column: PARTICULAR_OF_MEETING
	 */
	public java.lang.String getParticularOfMeeting () {
		return particularOfMeeting;
	}

	/**
	 * Set the value related to the column: PARTICULAR_OF_MEETING
	 * @param particularOfMeeting the PARTICULAR_OF_MEETING value
	 */
	public void setParticularOfMeeting (java.lang.String particularOfMeeting) {
		this.particularOfMeeting = particularOfMeeting;
	}



	/**
	 * Return the value associated with the column: DATE_OF_MEETING
	 */
	public java.util.Date getDateOfMeeting () {
		return dateOfMeeting;
	}

	/**
	 * Set the value related to the column: DATE_OF_MEETING
	 * @param dateOfMeeting the DATE_OF_MEETING value
	 */
	public void setDateOfMeeting (java.util.Date dateOfMeeting) {
		this.dateOfMeeting = dateOfMeeting;
	}



	/**
	 * Return the value associated with the column: SUBJECT_DISCUSSED_MEETING
	 */
	public java.lang.String getSubjectDiscussedMeeting () {
		return subjectDiscussedMeeting;
	}

	/**
	 * Set the value related to the column: SUBJECT_DISCUSSED_MEETING
	 * @param subjectDiscussedMeeting the SUBJECT_DISCUSSED_MEETING value
	 */
	public void setSubjectDiscussedMeeting (java.lang.String subjectDiscussedMeeting) {
		this.subjectDiscussedMeeting = subjectDiscussedMeeting;
	}



	/**
	 * Return the value associated with the column: DECISION_IMPLEMENT_ACTION
	 */
	public java.lang.String getDecisionImplementAction () {
		return decisionImplementAction;
	}

	/**
	 * Set the value related to the column: DECISION_IMPLEMENT_ACTION
	 * @param decisionImplementAction the DECISION_IMPLEMENT_ACTION value
	 */
	public void setDecisionImplementAction (java.lang.String decisionImplementAction) {
		this.decisionImplementAction = decisionImplementAction;
	}



	/**
	 * Return the value associated with the column: SUMMARY_DECISION_TAKEN
	 */
	public java.lang.String getSummaryDecisionTaken () {
		return summaryDecisionTaken;
	}

	/**
	 * Set the value related to the column: SUMMARY_DECISION_TAKEN
	 * @param summaryDecisionTaken the SUMMARY_DECISION_TAKEN value
	 */
	public void setSummaryDecisionTaken (java.lang.String summaryDecisionTaken) {
		this.summaryDecisionTaken = summaryDecisionTaken;
	}



	/**
	 * Return the value associated with the column: REMARKS
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: REMARKS
	 * @param remarks the REMARKS value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
	}



	/**
	 * Return the value associated with the column: DEPARTMENT_ID
	 */
	public jkt.hms.masters.business.MasDepartment getDepartmentId () {
		return departmentId;
	}

	/**
	 * Set the value related to the column: DEPARTMENT_ID
	 * @param departmentId the DEPARTMENT_ID value
	 */
	public void setDepartmentId (jkt.hms.masters.business.MasDepartment departmentId) {
		this.departmentId = departmentId;
	}



	/**
	 * Return the value associated with the column: HOSPITAL_ID
	 */
	public jkt.hms.masters.business.MasHospital getHospitalId () {
		return hospitalId;
	}

	/**
	 * Set the value related to the column: HOSPITAL_ID
	 * @param hospitalId the HOSPITAL_ID value
	 */
	public void setHospitalId (jkt.hms.masters.business.MasHospital hospitalId) {
		this.hospitalId = hospitalId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MeetingHeldAgencies)) return false;
		else {
			jkt.hms.masters.business.MeetingHeldAgencies meetingHeldAgencies = (jkt.hms.masters.business.MeetingHeldAgencies) obj;
			if (null == this.getId() || null == meetingHeldAgencies.getId()) return false;
			else return (this.getId().equals(meetingHeldAgencies.getId()));
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
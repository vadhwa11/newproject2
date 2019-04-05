package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hrorderly_leavechoice table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hrorderly_leavechoice"
 */

public abstract class BaseHrorderlyLeavechoice  implements Serializable {

	public static String REF = "HrorderlyLeavechoice";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LEAVE_CHOICE1 = "LeaveChoice1";
	public static String PROP_LEAVE_CHOICE_REMARKS = "LeaveChoiceRemarks";
	public static String PROP_LEAVE_CHOICE2 = "LeaveChoice2";
	public static String PROP_SIGNATURE = "Signature";
	public static String PROP_LC_APPROVED_STATUS = "LcApprovedStatus";
	public static String PROP_YEAR = "Year";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_EMPLOYEE_ID = "EmployeeId";


	// constructors
	public BaseHrorderlyLeavechoice () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrorderlyLeavechoice (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseHrorderlyLeavechoice (
		java.lang.Integer id,
		jkt.hms.masters.business.MasEmployee employeeId,
		java.lang.String year,
		java.lang.String leaveChoice1,
		java.lang.String leaveChoice2,
		java.lang.String status,
		java.lang.String lastChgBy,
		java.lang.String lastChgTime,
		java.util.Date lastChgDate) {

		this.setId(id);
		this.setEmployeeId(employeeId);
		this.setYear(year);
		this.setLeaveChoice1(leaveChoice1);
		this.setLeaveChoice2(leaveChoice2);
		this.setStatus(status);
		this.setLastChgBy(lastChgBy);
		this.setLastChgTime(lastChgTime);
		this.setLastChgDate(lastChgDate);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String signature;
	private java.lang.String leaveChoiceRemarks;
	private java.lang.String year;
	private java.lang.String leaveChoice1;
	private java.lang.String leaveChoice2;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.lang.String lastChgTime;
	private java.util.Date lastChgDate;
	private java.lang.String lcApprovedStatus;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasEmployee employeeId;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
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
	 * Return the value associated with the column: signature
	 */
	public java.lang.String getSignature () {
		return signature;
	}

	/**
	 * Set the value related to the column: signature
	 * @param signature the signature value
	 */
	public void setSignature (java.lang.String signature) {
		this.signature = signature;
	}



	/**
	 * Return the value associated with the column: leave_choice_remarks
	 */
	public java.lang.String getLeaveChoiceRemarks () {
		return leaveChoiceRemarks;
	}

	/**
	 * Set the value related to the column: leave_choice_remarks
	 * @param leaveChoiceRemarks the leave_choice_remarks value
	 */
	public void setLeaveChoiceRemarks (java.lang.String leaveChoiceRemarks) {
		this.leaveChoiceRemarks = leaveChoiceRemarks;
	}



	/**
	 * Return the value associated with the column: year
	 */
	public java.lang.String getYear () {
		return year;
	}

	/**
	 * Set the value related to the column: year
	 * @param year the year value
	 */
	public void setYear (java.lang.String year) {
		this.year = year;
	}



	/**
	 * Return the value associated with the column: leave_choice1
	 */
	public java.lang.String getLeaveChoice1 () {
		return leaveChoice1;
	}

	/**
	 * Set the value related to the column: leave_choice1
	 * @param leaveChoice1 the leave_choice1 value
	 */
	public void setLeaveChoice1 (java.lang.String leaveChoice1) {
		this.leaveChoice1 = leaveChoice1;
	}



	/**
	 * Return the value associated with the column: leave_choice2
	 */
	public java.lang.String getLeaveChoice2 () {
		return leaveChoice2;
	}

	/**
	 * Set the value related to the column: leave_choice2
	 * @param leaveChoice2 the leave_choice2 value
	 */
	public void setLeaveChoice2 (java.lang.String leaveChoice2) {
		this.leaveChoice2 = leaveChoice2;
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
	public java.lang.String getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
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
	 * Return the value associated with the column: lc_approved_status
	 */
	public java.lang.String getLcApprovedStatus () {
		return lcApprovedStatus;
	}

	/**
	 * Set the value related to the column: lc_approved_status
	 * @param lcApprovedStatus the lc_approved_status value
	 */
	public void setLcApprovedStatus (java.lang.String lcApprovedStatus) {
		this.lcApprovedStatus = lcApprovedStatus;
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
	 * Return the value associated with the column: employee_id
	 */
	public jkt.hms.masters.business.MasEmployee getEmployeeId () {
		return employeeId;
	}

	/**
	 * Set the value related to the column: employee_id
	 * @param employeeId the employee_id value
	 */
	public void setEmployeeId (jkt.hms.masters.business.MasEmployee employeeId) {
		this.employeeId = employeeId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HrorderlyLeavechoice)) return false;
		else {
			jkt.hms.masters.business.HrorderlyLeavechoice hrorderlyLeavechoice = (jkt.hms.masters.business.HrorderlyLeavechoice) obj;
			if (null == this.getId() || null == hrorderlyLeavechoice.getId()) return false;
			else return (this.getId().equals(hrorderlyLeavechoice.getId()));
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
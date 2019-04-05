package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the smq_vacation table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="smq_vacation"
 */

public abstract class BaseSmqVacation implements Serializable {

	public static String REF = "SmqVacation";
	public static String PROP_VACATION_TYPE = "VacationType";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_VACATION_DATE = "VacationDate";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_MAINTENANCE = "Maintenance";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_VACATION_NO = "VacationNo";
	public static String PROP_ALLOTMENT = "Allotment";
	public static String PROP_VACATION_TIME = "VacationTime";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_ID = "Id";

	// constructors
	public BaseSmqVacation() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSmqVacation(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseSmqVacation(java.lang.Integer id,
			jkt.hms.masters.business.MasHospital hospital,
			jkt.hms.masters.business.MasDepartment department,
			java.lang.String vacationNo, java.util.Date vacationDate,
			java.lang.String vacationTime, java.lang.String vacationType,
			java.lang.String lastChgBy, java.util.Date lastChgDate,
			java.lang.String lastChgTime) {

		this.setId(id);
		this.setHospital(hospital);
		this.setDepartment(department);
		this.setVacationNo(vacationNo);
		this.setVacationDate(vacationDate);
		this.setVacationTime(vacationTime);
		this.setVacationType(vacationType);
		this.setLastChgBy(lastChgBy);
		this.setLastChgDate(lastChgDate);
		this.setLastChgTime(lastChgTime);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String vacationNo;
	private java.util.Date vacationDate;
	private java.lang.String vacationTime;
	private java.lang.String remarks;
	private java.lang.String maintenance;
	private java.lang.String vacationType;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.AccomAllotment allotment;

	// collections
	private java.util.Set<jkt.hms.masters.business.RelegationProcess> relegationProcesss;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="vacation_id"
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
	 * Return the value associated with the column: vacation_no
	 */
	public java.lang.String getVacationNo() {
		return vacationNo;
	}

	/**
	 * Set the value related to the column: vacation_no
	 * 
	 * @param vacationNo
	 *            the vacation_no value
	 */
	public void setVacationNo(java.lang.String vacationNo) {
		this.vacationNo = vacationNo;
	}

	/**
	 * Return the value associated with the column: vacation_date
	 */
	public java.util.Date getVacationDate() {
		return vacationDate;
	}

	/**
	 * Set the value related to the column: vacation_date
	 * 
	 * @param vacationDate
	 *            the vacation_date value
	 */
	public void setVacationDate(java.util.Date vacationDate) {
		this.vacationDate = vacationDate;
	}

	/**
	 * Return the value associated with the column: vacation_time
	 */
	public java.lang.String getVacationTime() {
		return vacationTime;
	}

	/**
	 * Set the value related to the column: vacation_time
	 * 
	 * @param vacationTime
	 *            the vacation_time value
	 */
	public void setVacationTime(java.lang.String vacationTime) {
		this.vacationTime = vacationTime;
	}

	/**
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks() {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * 
	 * @param remarks
	 *            the remarks value
	 */
	public void setRemarks(java.lang.String remarks) {
		this.remarks = remarks;
	}

	/**
	 * Return the value associated with the column: maintenance
	 */
	public java.lang.String getMaintenance() {
		return maintenance;
	}

	/**
	 * Set the value related to the column: maintenance
	 * 
	 * @param maintenance
	 *            the maintenance value
	 */
	public void setMaintenance(java.lang.String maintenance) {
		this.maintenance = maintenance;
	}

	/**
	 * Return the value associated with the column: vacation_type
	 */
	public java.lang.String getVacationType() {
		return vacationType;
	}

	/**
	 * Set the value related to the column: vacation_type
	 * 
	 * @param vacationType
	 *            the vacation_type value
	 */
	public void setVacationType(java.lang.String vacationType) {
		this.vacationType = vacationType;
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
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital() {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * 
	 * @param hospital
	 *            the hospital_id value
	 */
	public void setHospital(jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}

	/**
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment() {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * 
	 * @param department
	 *            the department_id value
	 */
	public void setDepartment(jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}

	/**
	 * Return the value associated with the column: allotment_id
	 */
	public jkt.hms.masters.business.AccomAllotment getAllotment() {
		return allotment;
	}

	/**
	 * Set the value related to the column: allotment_id
	 * 
	 * @param allotment
	 *            the allotment_id value
	 */
	public void setAllotment(jkt.hms.masters.business.AccomAllotment allotment) {
		this.allotment = allotment;
	}

	/**
	 * Return the value associated with the column: RelegationProcesss
	 */
	public java.util.Set<jkt.hms.masters.business.RelegationProcess> getRelegationProcesss() {
		return relegationProcesss;
	}

	/**
	 * Set the value related to the column: RelegationProcesss
	 * 
	 * @param relegationProcesss
	 *            the RelegationProcesss value
	 */
	public void setRelegationProcesss(
			java.util.Set<jkt.hms.masters.business.RelegationProcess> relegationProcesss) {
		this.relegationProcesss = relegationProcesss;
	}

	public void addToRelegationProcesss(
			jkt.hms.masters.business.RelegationProcess relegationProcess) {
		if (null == getRelegationProcesss())
			setRelegationProcesss(new java.util.TreeSet<jkt.hms.masters.business.RelegationProcess>());
		getRelegationProcesss().add(relegationProcess);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.SmqVacation))
			return false;
		else {
			jkt.hms.masters.business.SmqVacation smqVacation = (jkt.hms.masters.business.SmqVacation) obj;
			if (null == this.getId() || null == smqVacation.getId())
				return false;
			else
				return (this.getId().equals(smqVacation.getId()));
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
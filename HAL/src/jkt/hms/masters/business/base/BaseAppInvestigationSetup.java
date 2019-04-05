package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the app_investigation_setup
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="app_investigation_setup"
 */

public abstract class BaseAppInvestigationSetup implements Serializable {

	public static String REF = "AppInvestigationSetup";
	public static String PROP_EQUIPMENT = "Equipment";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_PERCENTAGE_FOR_SLOTS = "PercentageForSlots";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_SLOT_DURATION = "SlotDuration";
	public static String PROP_BREAK_FROM_TIME = "BreakFromTime";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_BREAK_TO_TIME = "BreakToTime";
	public static String PROP_TO_TIME = "ToTime";
	public static String PROP_MAX_NO_OF_DAYS = "MaxNoOfDays";
	public static String PROP_MIN_NO_OF_DAYS = "MinNoOfDays";
	public static String PROP_DAYS = "Days";
	public static String PROP_FROM_TIME = "FromTime";
	public static String PROP_ID = "Id";
	public static String PROP_NO_OF_EQUIPMENTS = "NoOfEquipments";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";

	// constructors
	public BaseAppInvestigationSetup() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAppInvestigationSetup(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String fromTime;
	private java.lang.String toTime;
	private java.lang.String slotDuration;
	private java.lang.String breakFromTime;
	private java.lang.String breakToTime;
	private java.lang.Integer percentageForSlots;
	private java.lang.Integer maxNoOfDays;
	private java.lang.Integer minNoOfDays;
	private java.lang.String days;
	private java.lang.String lastChgBy;
	private java.lang.String lastChgTime;
	private java.util.Date lastChgDate;
	private java.lang.Integer noOfEquipments;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.AppEquipmentMaster equipment;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="app_investigation_id"
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
	 * Return the value associated with the column: from_time
	 */
	public java.lang.String getFromTime() {
		return fromTime;
	}

	/**
	 * Set the value related to the column: from_time
	 * 
	 * @param fromTime
	 *            the from_time value
	 */
	public void setFromTime(java.lang.String fromTime) {
		this.fromTime = fromTime;
	}

	/**
	 * Return the value associated with the column: to_time
	 */
	public java.lang.String getToTime() {
		return toTime;
	}

	/**
	 * Set the value related to the column: to_time
	 * 
	 * @param toTime
	 *            the to_time value
	 */
	public void setToTime(java.lang.String toTime) {
		this.toTime = toTime;
	}

	/**
	 * Return the value associated with the column: slot_duration
	 */
	public java.lang.String getSlotDuration() {
		return slotDuration;
	}

	/**
	 * Set the value related to the column: slot_duration
	 * 
	 * @param slotDuration
	 *            the slot_duration value
	 */
	public void setSlotDuration(java.lang.String slotDuration) {
		this.slotDuration = slotDuration;
	}

	/**
	 * Return the value associated with the column: break_from_time
	 */
	public java.lang.String getBreakFromTime() {
		return breakFromTime;
	}

	/**
	 * Set the value related to the column: break_from_time
	 * 
	 * @param breakFromTime
	 *            the break_from_time value
	 */
	public void setBreakFromTime(java.lang.String breakFromTime) {
		this.breakFromTime = breakFromTime;
	}

	/**
	 * Return the value associated with the column: break_to_time
	 */
	public java.lang.String getBreakToTime() {
		return breakToTime;
	}

	/**
	 * Set the value related to the column: break_to_time
	 * 
	 * @param breakToTime
	 *            the break_to_time value
	 */
	public void setBreakToTime(java.lang.String breakToTime) {
		this.breakToTime = breakToTime;
	}

	/**
	 * Return the value associated with the column: percentage_for_slots
	 */
	public java.lang.Integer getPercentageForSlots() {
		return percentageForSlots;
	}

	/**
	 * Set the value related to the column: percentage_for_slots
	 * 
	 * @param percentageForSlots
	 *            the percentage_for_slots value
	 */
	public void setPercentageForSlots(java.lang.Integer percentageForSlots) {
		this.percentageForSlots = percentageForSlots;
	}

	/**
	 * Return the value associated with the column: max_no_of_days
	 */
	public java.lang.Integer getMaxNoOfDays() {
		return maxNoOfDays;
	}

	/**
	 * Set the value related to the column: max_no_of_days
	 * 
	 * @param maxNoOfDays
	 *            the max_no_of_days value
	 */
	public void setMaxNoOfDays(java.lang.Integer maxNoOfDays) {
		this.maxNoOfDays = maxNoOfDays;
	}

	/**
	 * Return the value associated with the column: min_no_of_days
	 */
	public java.lang.Integer getMinNoOfDays() {
		return minNoOfDays;
	}

	/**
	 * Set the value related to the column: min_no_of_days
	 * 
	 * @param minNoOfDays
	 *            the min_no_of_days value
	 */
	public void setMinNoOfDays(java.lang.Integer minNoOfDays) {
		this.minNoOfDays = minNoOfDays;
	}

	/**
	 * Return the value associated with the column: days
	 */
	public java.lang.String getDays() {
		return days;
	}

	/**
	 * Set the value related to the column: days
	 * 
	 * @param days
	 *            the days value
	 */
	public void setDays(java.lang.String days) {
		this.days = days;
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
	 * Return the value associated with the column: no_of_equipments
	 */
	public java.lang.Integer getNoOfEquipments() {
		return noOfEquipments;
	}

	/**
	 * Set the value related to the column: no_of_equipments
	 * 
	 * @param noOfEquipments
	 *            the no_of_equipments value
	 */
	public void setNoOfEquipments(java.lang.Integer noOfEquipments) {
		this.noOfEquipments = noOfEquipments;
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
	 * Return the value associated with the column: equipment_id
	 */
	public jkt.hms.masters.business.AppEquipmentMaster getEquipment() {
		return equipment;
	}

	/**
	 * Set the value related to the column: equipment_id
	 * 
	 * @param equipment
	 *            the equipment_id value
	 */
	public void setEquipment(
			jkt.hms.masters.business.AppEquipmentMaster equipment) {
		this.equipment = equipment;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.AppInvestigationSetup))
			return false;
		else {
			jkt.hms.masters.business.AppInvestigationSetup appInvestigationSetup = (jkt.hms.masters.business.AppInvestigationSetup) obj;
			if (null == this.getId() || null == appInvestigationSetup.getId())
				return false;
			else
				return (this.getId().equals(appInvestigationSetup.getId()));
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
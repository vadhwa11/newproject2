package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the opd_holiday table. Do not
 * modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * 
 * @hibernate.class table="opd_holiday"
 */

public abstract class BaseOpdHoliday implements Serializable {

	public static String REF = "OpdHoliday";
	public static String PROP_STATUS = "Status";
	public static String PROP_HOLIDAY_CODE = "HolidayCode";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_HOLIDAY_DATE = "HolidayDate";
	public static String PROP_ID = "Id";
	public static String PROP_HOLIDAY_NAME = "HolidayName";

	// constructors
	public BaseOpdHoliday() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdHoliday(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String holidayName;
	private java.lang.String holidayCode;
	private java.util.Date holidayDate;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="holiday_id"
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
	 * Return the value associated with the column: holiday_name
	 */
	public java.lang.String getHolidayName() {
		return holidayName;
	}

	/**
	 * Set the value related to the column: holiday_name
	 * 
	 * @param holidayName
	 *            the holiday_name value
	 */
	public void setHolidayName(java.lang.String holidayName) {
		this.holidayName = holidayName;
	}

	/**
	 * Return the value associated with the column: holiday_code
	 */
	public java.lang.String getHolidayCode() {
		return holidayCode;
	}

	/**
	 * Set the value related to the column: holiday_code
	 * 
	 * @param holidayCode
	 *            the holiday_code value
	 */
	public void setHolidayCode(java.lang.String holidayCode) {
		this.holidayCode = holidayCode;
	}

	/**
	 * Return the value associated with the column: holiday_date
	 */
	public java.util.Date getHolidayDate() {
		return holidayDate;
	}

	/**
	 * Set the value related to the column: holiday_date
	 * 
	 * @param holidayDate
	 *            the holiday_date value
	 */
	public void setHolidayDate(java.util.Date holidayDate) {
		this.holidayDate = holidayDate;
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

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.OpdHoliday))
			return false;
		else {
			jkt.hms.masters.business.OpdHoliday opdHoliday = (jkt.hms.masters.business.OpdHoliday) obj;
			if (null == this.getId() || null == opdHoliday.getId())
				return false;
			else
				return (this.getId().equals(opdHoliday.getId()));
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
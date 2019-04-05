package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_holidaycalendar table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_holidaycalendar"
 */

public abstract class BaseHolidaycalendar  implements Serializable {

	public static String REF = "Holidaycalendar";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_HOLIDAY_LIST_YEAR = "HolidayListYear";
	public static String PROP_HOLIDAY_DATE = "HolidayDate";
	public static String PROP_RH = "Rh";
	public static String PROP_TITLE = "Title";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";


	// constructors
	public BaseHolidaycalendar () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHolidaycalendar (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String title;
	private java.util.Date holidayDate;
	private java.lang.String rh;
	private java.lang.String holidayListYear;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
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
	 * Return the value associated with the column: title
	 */
	public java.lang.String getTitle () {
		return title;
	}

	/**
	 * Set the value related to the column: title
	 * @param title the title value
	 */
	public void setTitle (java.lang.String title) {
		this.title = title;
	}



	/**
	 * Return the value associated with the column: holiday_date
	 */
	public java.util.Date getHolidayDate () {
		return holidayDate;
	}

	/**
	 * Set the value related to the column: holiday_date
	 * @param holidayDate the holiday_date value
	 */
	public void setHolidayDate (java.util.Date holidayDate) {
		this.holidayDate = holidayDate;
	}



	/**
	 * Return the value associated with the column: rh
	 */
	public java.lang.String getRh () {
		return rh;
	}

	/**
	 * Set the value related to the column: rh
	 * @param rh the rh value
	 */
	public void setRh (java.lang.String rh) {
		this.rh = rh;
	}



	/**
	 * Return the value associated with the column: holiday_list_year
	 */
	public java.lang.String getHolidayListYear () {
		return holidayListYear;
	}

	/**
	 * Set the value related to the column: holiday_list_year
	 * @param holidayListYear the holiday_list_year value
	 */
	public void setHolidayListYear (java.lang.String holidayListYear) {
		this.holidayListYear = holidayListYear;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.Holidaycalendar)) return false;
		else {
			jkt.hms.masters.business.Holidaycalendar holidaycalendar = (jkt.hms.masters.business.Holidaycalendar) obj;
			if (null == this.getId() || null == holidaycalendar.getId()) return false;
			else return (this.getId().equals(holidaycalendar.getId()));
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
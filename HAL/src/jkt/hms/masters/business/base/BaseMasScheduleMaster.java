package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_schedule_master table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_schedule_master"
 */

public abstract class BaseMasScheduleMaster  implements Serializable {

	public static String REF = "MasScheduleMaster";
	public static String PROP_STATUS = "Status";
	public static String PROP_SCHEDULE_DESCRIPTION = "ScheduleDescription";
	public static String PROP_SCHEDULE_GROUP = "ScheduleGroup";
	public static String PROP_ID = "Id";
	public static String PROP_SCHEDULE_CODE = "ScheduleCode";


	// constructors
	public BaseMasScheduleMaster () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasScheduleMaster (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer scheduleCode;
	private java.lang.String scheduleDescription;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.FaMasAccountGroup scheduleGroup;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="schedule_id"
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
	 * Return the value associated with the column: schedule_code
	 */
	public java.lang.Integer getScheduleCode () {
		return scheduleCode;
	}

	/**
	 * Set the value related to the column: schedule_code
	 * @param scheduleCode the schedule_code value
	 */
	public void setScheduleCode (java.lang.Integer scheduleCode) {
		this.scheduleCode = scheduleCode;
	}



	/**
	 * Return the value associated with the column: schedule_description
	 */
	public java.lang.String getScheduleDescription () {
		return scheduleDescription;
	}

	/**
	 * Set the value related to the column: schedule_description
	 * @param scheduleDescription the schedule_description value
	 */
	public void setScheduleDescription (java.lang.String scheduleDescription) {
		this.scheduleDescription = scheduleDescription;
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
	 * Return the value associated with the column: schedule_group
	 */
	public jkt.hms.masters.business.FaMasAccountGroup getScheduleGroup () {
		return scheduleGroup;
	}

	/**
	 * Set the value related to the column: schedule_group
	 * @param scheduleGroup the schedule_group value
	 */
	public void setScheduleGroup (jkt.hms.masters.business.FaMasAccountGroup scheduleGroup) {
		this.scheduleGroup = scheduleGroup;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasScheduleMaster)) return false;
		else {
			jkt.hms.masters.business.MasScheduleMaster masScheduleMaster = (jkt.hms.masters.business.MasScheduleMaster) obj;
			if (null == this.getId() || null == masScheduleMaster.getId()) return false;
			else return (this.getId().equals(masScheduleMaster.getId()));
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
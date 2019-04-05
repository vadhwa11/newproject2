package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the store_boo table. Do not
 * modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * 
 * @hibernate.class table="store_boo"
 */

public abstract class BaseStoreBoo implements Serializable {

	public static String REF = "StoreBoo";
	public static String PROP_STATUS = "Status";
	public static String PROP_BOO_DATE = "BooDate";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_COMMAND_RANK = "CommandRank";
	public static String PROP_HRO_SL_NO = "HroSlNo";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_BOO_NO = "BooNo";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_PRESIDING_OFF = "PresidingOff";
	public static String PROP_PRESIDING_OFF_RANK = "PresidingOffRank";
	public static String PROP_OFFICER_IC_RANK = "OfficerIcRank";
	public static String PROP_COMMAND = "Command";
	public static String PROP_ATTENDENT_NAME = "AttendentName";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_HRO_DATE = "HroDate";
	public static String PROP_OFFICER_IC = "OfficerIc";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_ID = "Id";
	public static String PROP_GRN_NO = "GrnNo";

	// constructors
	public BaseStoreBoo() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreBoo(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseStoreBoo(java.lang.Integer id,
			jkt.hms.masters.business.MasHospital hospital,
			jkt.hms.masters.business.MasRank commandRank,
			jkt.hms.masters.business.MasEmployee command,
			java.lang.String booNo, java.util.Date booDate,
			java.lang.String grnNo, java.lang.String hroSlNo,
			java.util.Date hroDate, java.lang.String status,
			java.lang.String lastChgBy, java.util.Date lastChgDate,
			java.lang.String lastChgTime) {

		this.setId(id);
		this.setHospital(hospital);
		this.setCommandRank(commandRank);
		this.setCommand(command);
		this.setBooNo(booNo);
		this.setBooDate(booDate);
		this.setGrnNo(grnNo);
		this.setHroSlNo(hroSlNo);
		this.setHroDate(hroDate);
		this.setStatus(status);
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
	private java.lang.String attendentName;
	private java.util.Date booDate;
	private java.lang.String booNo;
	private java.lang.String grnNo;
	private java.util.Date hroDate;
	private java.lang.String hroSlNo;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String remarks;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasEmployee command;
	private jkt.hms.masters.business.MasRank commandRank;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasEmployee officerIc;
	private jkt.hms.masters.business.MasRank officerIcRank;
	private jkt.hms.masters.business.MasEmployee presidingOff;
	private jkt.hms.masters.business.MasRank presidingOffRank;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="boo_id"
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
	 * Return the value associated with the column: attendent_name
	 */
	public java.lang.String getAttendentName() {
		return attendentName;
	}

	/**
	 * Set the value related to the column: attendent_name
	 * 
	 * @param attendentName
	 *            the attendent_name value
	 */
	public void setAttendentName(java.lang.String attendentName) {
		this.attendentName = attendentName;
	}

	/**
	 * Return the value associated with the column: boo_date
	 */
	public java.util.Date getBooDate() {
		return booDate;
	}

	/**
	 * Set the value related to the column: boo_date
	 * 
	 * @param booDate
	 *            the boo_date value
	 */
	public void setBooDate(java.util.Date booDate) {
		this.booDate = booDate;
	}

	/**
	 * Return the value associated with the column: boo_no
	 */
	public java.lang.String getBooNo() {
		return booNo;
	}

	/**
	 * Set the value related to the column: boo_no
	 * 
	 * @param booNo
	 *            the boo_no value
	 */
	public void setBooNo(java.lang.String booNo) {
		this.booNo = booNo;
	}

	/**
	 * Return the value associated with the column: grn_no
	 */
	public java.lang.String getGrnNo() {
		return grnNo;
	}

	/**
	 * Set the value related to the column: grn_no
	 * 
	 * @param grnNo
	 *            the grn_no value
	 */
	public void setGrnNo(java.lang.String grnNo) {
		this.grnNo = grnNo;
	}

	/**
	 * Return the value associated with the column: hro_date
	 */
	public java.util.Date getHroDate() {
		return hroDate;
	}

	/**
	 * Set the value related to the column: hro_date
	 * 
	 * @param hroDate
	 *            the hro_date value
	 */
	public void setHroDate(java.util.Date hroDate) {
		this.hroDate = hroDate;
	}

	/**
	 * Return the value associated with the column: hro_sl_no
	 */
	public java.lang.String getHroSlNo() {
		return hroSlNo;
	}

	/**
	 * Set the value related to the column: hro_sl_no
	 * 
	 * @param hroSlNo
	 *            the hro_sl_no value
	 */
	public void setHroSlNo(java.lang.String hroSlNo) {
		this.hroSlNo = hroSlNo;
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
	 * Return the value associated with the column: command_id
	 */
	public jkt.hms.masters.business.MasEmployee getCommand() {
		return command;
	}

	/**
	 * Set the value related to the column: command_id
	 * 
	 * @param command
	 *            the command_id value
	 */
	public void setCommand(jkt.hms.masters.business.MasEmployee command) {
		this.command = command;
	}

	/**
	 * Return the value associated with the column: command_rank_id
	 */
	public jkt.hms.masters.business.MasRank getCommandRank() {
		return commandRank;
	}

	/**
	 * Set the value related to the column: command_rank_id
	 * 
	 * @param commandRank
	 *            the command_rank_id value
	 */
	public void setCommandRank(jkt.hms.masters.business.MasRank commandRank) {
		this.commandRank = commandRank;
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
	 * Return the value associated with the column: officer_ic_id
	 */
	public jkt.hms.masters.business.MasEmployee getOfficerIc() {
		return officerIc;
	}

	/**
	 * Set the value related to the column: officer_ic_id
	 * 
	 * @param officerIc
	 *            the officer_ic_id value
	 */
	public void setOfficerIc(jkt.hms.masters.business.MasEmployee officerIc) {
		this.officerIc = officerIc;
	}

	/**
	 * Return the value associated with the column: officer_ic_rank
	 */
	public jkt.hms.masters.business.MasRank getOfficerIcRank() {
		return officerIcRank;
	}

	/**
	 * Set the value related to the column: officer_ic_rank
	 * 
	 * @param officerIcRank
	 *            the officer_ic_rank value
	 */
	public void setOfficerIcRank(jkt.hms.masters.business.MasRank officerIcRank) {
		this.officerIcRank = officerIcRank;
	}

	/**
	 * Return the value associated with the column: presiding_off_id
	 */
	public jkt.hms.masters.business.MasEmployee getPresidingOff() {
		return presidingOff;
	}

	/**
	 * Set the value related to the column: presiding_off_id
	 * 
	 * @param presidingOff
	 *            the presiding_off_id value
	 */
	public void setPresidingOff(
			jkt.hms.masters.business.MasEmployee presidingOff) {
		this.presidingOff = presidingOff;
	}

	/**
	 * Return the value associated with the column: presiding_off_rank
	 */
	public jkt.hms.masters.business.MasRank getPresidingOffRank() {
		return presidingOffRank;
	}

	/**
	 * Set the value related to the column: presiding_off_rank
	 * 
	 * @param presidingOffRank
	 *            the presiding_off_rank value
	 */
	public void setPresidingOffRank(
			jkt.hms.masters.business.MasRank presidingOffRank) {
		this.presidingOffRank = presidingOffRank;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreBoo))
			return false;
		else {
			jkt.hms.masters.business.StoreBoo storeBoo = (jkt.hms.masters.business.StoreBoo) obj;
			if (null == this.getId() || null == storeBoo.getId())
				return false;
			else
				return (this.getId().equals(storeBoo.getId()));
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
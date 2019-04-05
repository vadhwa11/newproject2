package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the store_indent_soc_tracker
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="store_indent_soc_tracker"
 */

public abstract class BaseStoreIndentSocTracker implements Serializable {

	public static String REF = "StoreIndentSocTracker";
	public static String PROP_DATE_OF_SOC = "DateOfSoc";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_FORWARD_AIRHQ_TO_DGAFMS = "ForwardAirhqToDgafms";
	public static String PROP_SR_NO_AT_AIRHQ = "SrNoAtAirhq";
	public static String PROP_ITEM = "Item";
	public static String PROP_FORWARD_TO_TC = "ForwardToTc";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_PRESENT_STATUS = "PresentStatus";
	public static String PROP_FORWARD_TC_TO_AIRHQ = "ForwardTcToAirhq";
	public static String PROP_INDENT = "Indent";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_ID = "Id";

	// constructors
	public BaseStoreIndentSocTracker() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreIndentSocTracker(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseStoreIndentSocTracker(java.lang.Integer id,
			jkt.hms.masters.business.MasHospital hospital,
			jkt.hms.masters.business.MasDepartment department,
			jkt.hms.masters.business.StoreIndentM indent) {

		this.setId(id);
		this.setHospital(hospital);
		this.setDepartment(department);
		this.setIndent(indent);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date dateOfSoc;
	private java.lang.String presentStatus;
	private java.lang.String forwardToTc;
	private java.lang.String srNoAtAirhq;
	private java.lang.String forwardTcToAirhq;
	private java.lang.String forwardAirhqToDgafms;
	private java.lang.String remarks;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.StoreIndentM indent;
	private jkt.hms.masters.business.MasStoreItem item;

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
	 * Return the value associated with the column: date_of_soc
	 */
	public java.util.Date getDateOfSoc() {
		return dateOfSoc;
	}

	/**
	 * Set the value related to the column: date_of_soc
	 * 
	 * @param dateOfSoc
	 *            the date_of_soc value
	 */
	public void setDateOfSoc(java.util.Date dateOfSoc) {
		this.dateOfSoc = dateOfSoc;
	}

	/**
	 * Return the value associated with the column: present_status
	 */
	public java.lang.String getPresentStatus() {
		return presentStatus;
	}

	/**
	 * Set the value related to the column: present_status
	 * 
	 * @param presentStatus
	 *            the present_status value
	 */
	public void setPresentStatus(java.lang.String presentStatus) {
		this.presentStatus = presentStatus;
	}

	/**
	 * Return the value associated with the column: forward_to_tc
	 */
	public java.lang.String getForwardToTc() {
		return forwardToTc;
	}

	/**
	 * Set the value related to the column: forward_to_tc
	 * 
	 * @param forwardToTc
	 *            the forward_to_tc value
	 */
	public void setForwardToTc(java.lang.String forwardToTc) {
		this.forwardToTc = forwardToTc;
	}

	/**
	 * Return the value associated with the column: sr_no_at_airhq
	 */
	public java.lang.String getSrNoAtAirhq() {
		return srNoAtAirhq;
	}

	/**
	 * Set the value related to the column: sr_no_at_airhq
	 * 
	 * @param srNoAtAirhq
	 *            the sr_no_at_airhq value
	 */
	public void setSrNoAtAirhq(java.lang.String srNoAtAirhq) {
		this.srNoAtAirhq = srNoAtAirhq;
	}

	/**
	 * Return the value associated with the column: forward_tc_to_airhq
	 */
	public java.lang.String getForwardTcToAirhq() {
		return forwardTcToAirhq;
	}

	/**
	 * Set the value related to the column: forward_tc_to_airhq
	 * 
	 * @param forwardTcToAirhq
	 *            the forward_tc_to_airhq value
	 */
	public void setForwardTcToAirhq(java.lang.String forwardTcToAirhq) {
		this.forwardTcToAirhq = forwardTcToAirhq;
	}

	/**
	 * Return the value associated with the column: forward_airhq_to_dgafms
	 */
	public java.lang.String getForwardAirhqToDgafms() {
		return forwardAirhqToDgafms;
	}

	/**
	 * Set the value related to the column: forward_airhq_to_dgafms
	 * 
	 * @param forwardAirhqToDgafms
	 *            the forward_airhq_to_dgafms value
	 */
	public void setForwardAirhqToDgafms(java.lang.String forwardAirhqToDgafms) {
		this.forwardAirhqToDgafms = forwardAirhqToDgafms;
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
	 * Return the value associated with the column: indent_id
	 */
	public jkt.hms.masters.business.StoreIndentM getIndent() {
		return indent;
	}

	/**
	 * Set the value related to the column: indent_id
	 * 
	 * @param indent
	 *            the indent_id value
	 */
	public void setIndent(jkt.hms.masters.business.StoreIndentM indent) {
		this.indent = indent;
	}

	/**
	 * Return the value associated with the column: item_id
	 */
	public jkt.hms.masters.business.MasStoreItem getItem() {
		return item;
	}

	/**
	 * Set the value related to the column: item_id
	 * 
	 * @param item
	 *            the item_id value
	 */
	public void setItem(jkt.hms.masters.business.MasStoreItem item) {
		this.item = item;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreIndentSocTracker))
			return false;
		else {
			jkt.hms.masters.business.StoreIndentSocTracker storeIndentSocTracker = (jkt.hms.masters.business.StoreIndentSocTracker) obj;
			if (null == this.getId() || null == storeIndentSocTracker.getId())
				return false;
			else
				return (this.getId().equals(storeIndentSocTracker.getId()));
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
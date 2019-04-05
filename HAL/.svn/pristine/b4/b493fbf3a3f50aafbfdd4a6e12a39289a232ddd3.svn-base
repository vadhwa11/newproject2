package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the md_general_covering_hd
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="md_general_covering_hd"
 */

public abstract class BaseMdGeneralCoveringHd implements Serializable {

	public static String REF = "MdGeneralCoveringHd";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_DISPATCH = "Dispatch";
	public static String PROP_DISPATCH_DATE = "DispatchDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_TO1 = "To1";
	public static String PROP_ENTRY_NO = "EntryNo";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_FROM1 = "From1";
	public static String PROP_ENTRY_DATE = "EntryDate";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_ID = "Id";

	// constructors
	public BaseMdGeneralCoveringHd() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMdGeneralCoveringHd(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String entryNo;
	private java.util.Date entryDate;
	private java.lang.String from1;
	private java.lang.String to1;
	private java.util.Date dispatchDate;
	private java.lang.String dispatch;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;

	// collections
	private java.util.Set<jkt.hms.masters.business.MdGeneralCoveringDt> mdGeneralCoveringDts;

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
	 * Return the value associated with the column: entry_no
	 */
	public java.lang.String getEntryNo() {
		return entryNo;
	}

	/**
	 * Set the value related to the column: entry_no
	 * 
	 * @param entryNo
	 *            the entry_no value
	 */
	public void setEntryNo(java.lang.String entryNo) {
		this.entryNo = entryNo;
	}

	/**
	 * Return the value associated with the column: entry_date
	 */
	public java.util.Date getEntryDate() {
		return entryDate;
	}

	/**
	 * Set the value related to the column: entry_date
	 * 
	 * @param entryDate
	 *            the entry_date value
	 */
	public void setEntryDate(java.util.Date entryDate) {
		this.entryDate = entryDate;
	}

	/**
	 * Return the value associated with the column: from1
	 */
	public java.lang.String getFrom1() {
		return from1;
	}

	/**
	 * Set the value related to the column: from1
	 * 
	 * @param from1
	 *            the from1 value
	 */
	public void setFrom1(java.lang.String from1) {
		this.from1 = from1;
	}

	/**
	 * Return the value associated with the column: to1
	 */
	public java.lang.String getTo1() {
		return to1;
	}

	/**
	 * Set the value related to the column: to1
	 * 
	 * @param to1
	 *            the to1 value
	 */
	public void setTo1(java.lang.String to1) {
		this.to1 = to1;
	}

	/**
	 * Return the value associated with the column: dispatch_date
	 */
	public java.util.Date getDispatchDate() {
		return dispatchDate;
	}

	/**
	 * Set the value related to the column: dispatch_date
	 * 
	 * @param dispatchDate
	 *            the dispatch_date value
	 */
	public void setDispatchDate(java.util.Date dispatchDate) {
		this.dispatchDate = dispatchDate;
	}

	/**
	 * Return the value associated with the column: dispatch
	 */
	public java.lang.String getDispatch() {
		return dispatch;
	}

	/**
	 * Set the value related to the column: dispatch
	 * 
	 * @param dispatch
	 *            the dispatch value
	 */
	public void setDispatch(java.lang.String dispatch) {
		this.dispatch = dispatch;
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
	 * Return the value associated with the column: MdGeneralCoveringDts
	 */
	public java.util.Set<jkt.hms.masters.business.MdGeneralCoveringDt> getMdGeneralCoveringDts() {
		return mdGeneralCoveringDts;
	}

	/**
	 * Set the value related to the column: MdGeneralCoveringDts
	 * 
	 * @param mdGeneralCoveringDts
	 *            the MdGeneralCoveringDts value
	 */
	public void setMdGeneralCoveringDts(
			java.util.Set<jkt.hms.masters.business.MdGeneralCoveringDt> mdGeneralCoveringDts) {
		this.mdGeneralCoveringDts = mdGeneralCoveringDts;
	}

	public void addToMdGeneralCoveringDts(
			jkt.hms.masters.business.MdGeneralCoveringDt mdGeneralCoveringDt) {
		if (null == getMdGeneralCoveringDts())
			setMdGeneralCoveringDts(new java.util.TreeSet<jkt.hms.masters.business.MdGeneralCoveringDt>());
		getMdGeneralCoveringDts().add(mdGeneralCoveringDt);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MdGeneralCoveringHd))
			return false;
		else {
			jkt.hms.masters.business.MdGeneralCoveringHd mdGeneralCoveringHd = (jkt.hms.masters.business.MdGeneralCoveringHd) obj;
			if (null == this.getId() || null == mdGeneralCoveringHd.getId())
				return false;
			else
				return (this.getId().equals(mdGeneralCoveringHd.getId()));
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
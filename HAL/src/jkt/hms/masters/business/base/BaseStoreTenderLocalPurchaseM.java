package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * store_tender_local_purchase_m table. Do not modify this class because it will
 * be overwritten if the configuration file related to this class is modified.
 * 
 * @hibernate.class table="store_tender_local_purchase_m"
 */

public abstract class BaseStoreTenderLocalPurchaseM implements Serializable {

	public static String REF = "StoreTenderLocalPurchaseM";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_TENDER = "Tender";
	public static String PROP_NOTE_DATE = "NoteDate";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_OIC = "Oic";
	public static String PROP_PERIOD = "Period";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_NOTE_NO = "NoteNo";
	public static String PROP_ID = "Id";

	// constructors
	public BaseStoreTenderLocalPurchaseM() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreTenderLocalPurchaseM(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer noteNo;
	private java.util.Date noteDate;
	private java.lang.String period;
	private java.lang.String remarks;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasEmployee oic;
	private jkt.hms.masters.business.StoreTenderM tender;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;

	// collections
	private java.util.Set<jkt.hms.masters.business.StoreTenderLocalPurchaseT> storeTenderLocalPurchaseTs;

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
	 * Return the value associated with the column: note_no
	 */
	public java.lang.Integer getNoteNo() {
		return noteNo;
	}

	/**
	 * Set the value related to the column: note_no
	 * 
	 * @param noteNo
	 *            the note_no value
	 */
	public void setNoteNo(java.lang.Integer noteNo) {
		this.noteNo = noteNo;
	}

	/**
	 * Return the value associated with the column: note_date
	 */
	public java.util.Date getNoteDate() {
		return noteDate;
	}

	/**
	 * Set the value related to the column: note_date
	 * 
	 * @param noteDate
	 *            the note_date value
	 */
	public void setNoteDate(java.util.Date noteDate) {
		this.noteDate = noteDate;
	}

	/**
	 * Return the value associated with the column: period
	 */
	public java.lang.String getPeriod() {
		return period;
	}

	/**
	 * Set the value related to the column: period
	 * 
	 * @param period
	 *            the period value
	 */
	public void setPeriod(java.lang.String period) {
		this.period = period;
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
	 * Return the value associated with the column: oic_id
	 */
	public jkt.hms.masters.business.MasEmployee getOic() {
		return oic;
	}

	/**
	 * Set the value related to the column: oic_id
	 * 
	 * @param oic
	 *            the oic_id value
	 */
	public void setOic(jkt.hms.masters.business.MasEmployee oic) {
		this.oic = oic;
	}

	/**
	 * Return the value associated with the column: tender_id
	 */
	public jkt.hms.masters.business.StoreTenderM getTender() {
		return tender;
	}

	/**
	 * Set the value related to the column: tender_id
	 * 
	 * @param tender
	 *            the tender_id value
	 */
	public void setTender(jkt.hms.masters.business.StoreTenderM tender) {
		this.tender = tender;
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
	 * Return the value associated with the column: dept_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment() {
		return department;
	}

	/**
	 * Set the value related to the column: dept_id
	 * 
	 * @param department
	 *            the dept_id value
	 */
	public void setDepartment(jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}

	/**
	 * Return the value associated with the column: StoreTenderLocalPurchaseTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreTenderLocalPurchaseT> getStoreTenderLocalPurchaseTs() {
		return storeTenderLocalPurchaseTs;
	}

	/**
	 * Set the value related to the column: StoreTenderLocalPurchaseTs
	 * 
	 * @param storeTenderLocalPurchaseTs
	 *            the StoreTenderLocalPurchaseTs value
	 */
	public void setStoreTenderLocalPurchaseTs(
			java.util.Set<jkt.hms.masters.business.StoreTenderLocalPurchaseT> storeTenderLocalPurchaseTs) {
		this.storeTenderLocalPurchaseTs = storeTenderLocalPurchaseTs;
	}

	public void addToStoreTenderLocalPurchaseTs(
			jkt.hms.masters.business.StoreTenderLocalPurchaseT storeTenderLocalPurchaseT) {
		if (null == getStoreTenderLocalPurchaseTs())
			setStoreTenderLocalPurchaseTs(new java.util.TreeSet<jkt.hms.masters.business.StoreTenderLocalPurchaseT>());
		getStoreTenderLocalPurchaseTs().add(storeTenderLocalPurchaseT);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreTenderLocalPurchaseM))
			return false;
		else {
			jkt.hms.masters.business.StoreTenderLocalPurchaseM storeTenderLocalPurchaseM = (jkt.hms.masters.business.StoreTenderLocalPurchaseM) obj;
			if (null == this.getId()
					|| null == storeTenderLocalPurchaseM.getId())
				return false;
			else
				return (this.getId().equals(storeTenderLocalPurchaseM.getId()));
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
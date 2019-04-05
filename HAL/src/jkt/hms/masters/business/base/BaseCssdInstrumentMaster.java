package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the cssd_instrument_master
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="cssd_instrument_master"
 */

public abstract class BaseCssdInstrumentMaster implements Serializable {

	public static String REF = "CssdInstrumentMaster";
	public static String PROP_STATUS = "Status";
	public static String PROP_INSTRUMENT_NAME = "InstrumentName";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_INSTRUMENT_CODE = "InstrumentCode";

	// constructors
	public BaseCssdInstrumentMaster() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCssdInstrumentMaster(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCssdInstrumentMaster(java.lang.Integer id,
			jkt.hms.masters.business.MasDepartment department,
			java.lang.String instrumentCode, java.lang.String instrumentName,
			java.lang.String lastChgTime) {

		this.setId(id);
		this.setDepartment(department);
		this.setInstrumentCode(instrumentCode);
		this.setInstrumentName(instrumentName);
		this.setLastChgTime(lastChgTime);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String instrumentCode;
	private java.lang.String instrumentName;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasDepartment department;

	// collections
	private java.util.Set<jkt.hms.masters.business.CssdAutoclaveRequestT> cssdAutoclaveRequestTs;
	private java.util.Set<jkt.hms.masters.business.CssdAutoclaveEntryT> cssdAutoclaveEntryTs;
	private java.util.Set<jkt.hms.masters.business.CssdAutoclaveReceiptT> cssdAutoclaveReceiptTs;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="instrument_id"
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
	 * Return the value associated with the column: instrument_code
	 */
	public java.lang.String getInstrumentCode() {
		return instrumentCode;
	}

	/**
	 * Set the value related to the column: instrument_code
	 * 
	 * @param instrumentCode
	 *            the instrument_code value
	 */
	public void setInstrumentCode(java.lang.String instrumentCode) {
		this.instrumentCode = instrumentCode;
	}

	/**
	 * Return the value associated with the column: instrument_name
	 */
	public java.lang.String getInstrumentName() {
		return instrumentName;
	}

	/**
	 * Set the value related to the column: instrument_name
	 * 
	 * @param instrumentName
	 *            the instrument_name value
	 */
	public void setInstrumentName(java.lang.String instrumentName) {
		this.instrumentName = instrumentName;
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
	 * Return the value associated with the column: CssdAutoclaveRequestTs
	 */
	public java.util.Set<jkt.hms.masters.business.CssdAutoclaveRequestT> getCssdAutoclaveRequestTs() {
		return cssdAutoclaveRequestTs;
	}

	/**
	 * Set the value related to the column: CssdAutoclaveRequestTs
	 * 
	 * @param cssdAutoclaveRequestTs
	 *            the CssdAutoclaveRequestTs value
	 */
	public void setCssdAutoclaveRequestTs(
			java.util.Set<jkt.hms.masters.business.CssdAutoclaveRequestT> cssdAutoclaveRequestTs) {
		this.cssdAutoclaveRequestTs = cssdAutoclaveRequestTs;
	}

	public void addToCssdAutoclaveRequestTs(
			jkt.hms.masters.business.CssdAutoclaveRequestT cssdAutoclaveRequestT) {
		if (null == getCssdAutoclaveRequestTs())
			setCssdAutoclaveRequestTs(new java.util.TreeSet<jkt.hms.masters.business.CssdAutoclaveRequestT>());
		getCssdAutoclaveRequestTs().add(cssdAutoclaveRequestT);
	}

	/**
	 * Return the value associated with the column: CssdAutoclaveEntryTs
	 */
	public java.util.Set<jkt.hms.masters.business.CssdAutoclaveEntryT> getCssdAutoclaveEntryTs() {
		return cssdAutoclaveEntryTs;
	}

	/**
	 * Set the value related to the column: CssdAutoclaveEntryTs
	 * 
	 * @param cssdAutoclaveEntryTs
	 *            the CssdAutoclaveEntryTs value
	 */
	public void setCssdAutoclaveEntryTs(
			java.util.Set<jkt.hms.masters.business.CssdAutoclaveEntryT> cssdAutoclaveEntryTs) {
		this.cssdAutoclaveEntryTs = cssdAutoclaveEntryTs;
	}

	public void addToCssdAutoclaveEntryTs(
			jkt.hms.masters.business.CssdAutoclaveEntryT cssdAutoclaveEntryT) {
		if (null == getCssdAutoclaveEntryTs())
			setCssdAutoclaveEntryTs(new java.util.TreeSet<jkt.hms.masters.business.CssdAutoclaveEntryT>());
		getCssdAutoclaveEntryTs().add(cssdAutoclaveEntryT);
	}

	/**
	 * Return the value associated with the column: CssdAutoclaveReceiptTs
	 */
	public java.util.Set<jkt.hms.masters.business.CssdAutoclaveReceiptT> getCssdAutoclaveReceiptTs() {
		return cssdAutoclaveReceiptTs;
	}

	/**
	 * Set the value related to the column: CssdAutoclaveReceiptTs
	 * 
	 * @param cssdAutoclaveReceiptTs
	 *            the CssdAutoclaveReceiptTs value
	 */
	public void setCssdAutoclaveReceiptTs(
			java.util.Set<jkt.hms.masters.business.CssdAutoclaveReceiptT> cssdAutoclaveReceiptTs) {
		this.cssdAutoclaveReceiptTs = cssdAutoclaveReceiptTs;
	}

	public void addToCssdAutoclaveReceiptTs(
			jkt.hms.masters.business.CssdAutoclaveReceiptT cssdAutoclaveReceiptT) {
		if (null == getCssdAutoclaveReceiptTs())
			setCssdAutoclaveReceiptTs(new java.util.TreeSet<jkt.hms.masters.business.CssdAutoclaveReceiptT>());
		getCssdAutoclaveReceiptTs().add(cssdAutoclaveReceiptT);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.CssdInstrumentMaster))
			return false;
		else {
			jkt.hms.masters.business.CssdInstrumentMaster cssdInstrumentMaster = (jkt.hms.masters.business.CssdInstrumentMaster) obj;
			if (null == this.getId() || null == cssdInstrumentMaster.getId())
				return false;
			else
				return (this.getId().equals(cssdInstrumentMaster.getId()));
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
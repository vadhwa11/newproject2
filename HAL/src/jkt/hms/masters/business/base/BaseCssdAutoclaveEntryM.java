package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the cssd_autoclave_entry_m
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="cssd_autoclave_entry_m"
 */

public abstract class BaseCssdAutoclaveEntryM implements Serializable {

	public static String REF = "CssdAutoclaveEntryM";
	public static String PROP_ENTRY_BY = "EntryBy";
	public static String PROP_ENTRY_NO = "EntryNo";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_TEMPERATURE = "Temperature";
	public static String PROP_STERILIZATION_TYPE = "SterilizationType";
	public static String PROP_ENTRY_DATE = "EntryDate";
	public static String PROP_CYCLE_NO = "CycleNo";
	public static String PROP_TOTAL_TIME = "TotalTime";
	public static String PROP_ENTRY_STATUS = "EntryStatus";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LOT_NO = "LotNo";
	public static String PROP_ID = "Id";
	public static String PROP_CHEMICAL_INDICATOR = "ChemicalIndicator";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_PRESSURE = "Pressure";
	public static String PROP_ENTRY_TIME = "EntryTime";

	// constructors
	public BaseCssdAutoclaveEntryM() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCssdAutoclaveEntryM(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCssdAutoclaveEntryM(java.lang.Integer id,
			jkt.hms.masters.business.MasEmployee entryBy,
			java.lang.String entryNo, java.util.Date entryDate,
			java.lang.String entryTime, java.lang.String lotNo,
			java.lang.String entryStatus, java.lang.String sterilizationType,
			java.lang.String chemicalIndicator) {

		this.setId(id);
		this.setEntryBy(entryBy);
		this.setEntryNo(entryNo);
		this.setEntryDate(entryDate);
		this.setEntryTime(entryTime);
		this.setLotNo(lotNo);
		this.setEntryStatus(entryStatus);
		this.setSterilizationType(sterilizationType);
		this.setChemicalIndicator(chemicalIndicator);
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
	private java.lang.String entryTime;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String lotNo;
	private java.lang.String entryStatus;
	private java.lang.String sterilizationType;
	private java.lang.String chemicalIndicator;
	private java.lang.String temperature;
	private java.lang.String pressure;
	private java.lang.String totalTime;
	private java.lang.String cycleNo;

	// many to one
	private jkt.hms.masters.business.MasEmployee entryBy;

	// collections
	private java.util.Set<jkt.hms.masters.business.CssdAutoclaveEntryT> cssdAutoclaveEntryTs;
	private java.util.Set<jkt.hms.masters.business.CssdAutoclaveReceiptT> cssdAutoclaveReceiptTs;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="entry_id"
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
	 * Return the value associated with the column: entry_time
	 */
	public java.lang.String getEntryTime() {
		return entryTime;
	}

	/**
	 * Set the value related to the column: entry_time
	 * 
	 * @param entryTime
	 *            the entry_time value
	 */
	public void setEntryTime(java.lang.String entryTime) {
		this.entryTime = entryTime;
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
	 * Return the value associated with the column: lot_no
	 */
	public java.lang.String getLotNo() {
		return lotNo;
	}

	/**
	 * Set the value related to the column: lot_no
	 * 
	 * @param lotNo
	 *            the lot_no value
	 */
	public void setLotNo(java.lang.String lotNo) {
		this.lotNo = lotNo;
	}

	/**
	 * Return the value associated with the column: entry_status
	 */
	public java.lang.String getEntryStatus() {
		return entryStatus;
	}

	/**
	 * Set the value related to the column: entry_status
	 * 
	 * @param entryStatus
	 *            the entry_status value
	 */
	public void setEntryStatus(java.lang.String entryStatus) {
		this.entryStatus = entryStatus;
	}

	/**
	 * Return the value associated with the column: sterilization_type
	 */
	public java.lang.String getSterilizationType() {
		return sterilizationType;
	}

	/**
	 * Set the value related to the column: sterilization_type
	 * 
	 * @param sterilizationType
	 *            the sterilization_type value
	 */
	public void setSterilizationType(java.lang.String sterilizationType) {
		this.sterilizationType = sterilizationType;
	}

	/**
	 * Return the value associated with the column: chemical_indicator
	 */
	public java.lang.String getChemicalIndicator() {
		return chemicalIndicator;
	}

	/**
	 * Set the value related to the column: chemical_indicator
	 * 
	 * @param chemicalIndicator
	 *            the chemical_indicator value
	 */
	public void setChemicalIndicator(java.lang.String chemicalIndicator) {
		this.chemicalIndicator = chemicalIndicator;
	}

	/**
	 * Return the value associated with the column: temperature
	 */
	public java.lang.String getTemperature() {
		return temperature;
	}

	/**
	 * Set the value related to the column: temperature
	 * 
	 * @param temperature
	 *            the temperature value
	 */
	public void setTemperature(java.lang.String temperature) {
		this.temperature = temperature;
	}

	/**
	 * Return the value associated with the column: pressure
	 */
	public java.lang.String getPressure() {
		return pressure;
	}

	/**
	 * Set the value related to the column: pressure
	 * 
	 * @param pressure
	 *            the pressure value
	 */
	public void setPressure(java.lang.String pressure) {
		this.pressure = pressure;
	}

	/**
	 * Return the value associated with the column: total_time
	 */
	public java.lang.String getTotalTime() {
		return totalTime;
	}

	/**
	 * Set the value related to the column: total_time
	 * 
	 * @param totalTime
	 *            the total_time value
	 */
	public void setTotalTime(java.lang.String totalTime) {
		this.totalTime = totalTime;
	}

	/**
	 * Return the value associated with the column: cycle_no
	 */
	public java.lang.String getCycleNo() {
		return cycleNo;
	}

	/**
	 * Set the value related to the column: cycle_no
	 * 
	 * @param cycleNo
	 *            the cycle_no value
	 */
	public void setCycleNo(java.lang.String cycleNo) {
		this.cycleNo = cycleNo;
	}

	/**
	 * Return the value associated with the column: entry_by
	 */
	public jkt.hms.masters.business.MasEmployee getEntryBy() {
		return entryBy;
	}

	/**
	 * Set the value related to the column: entry_by
	 * 
	 * @param entryBy
	 *            the entry_by value
	 */
	public void setEntryBy(jkt.hms.masters.business.MasEmployee entryBy) {
		this.entryBy = entryBy;
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
		if (!(obj instanceof jkt.hms.masters.business.CssdAutoclaveEntryM))
			return false;
		else {
			jkt.hms.masters.business.CssdAutoclaveEntryM cssdAutoclaveEntryM = (jkt.hms.masters.business.CssdAutoclaveEntryM) obj;
			if (null == this.getId() || null == cssdAutoclaveEntryM.getId())
				return false;
			else
				return (this.getId().equals(cssdAutoclaveEntryM.getId()));
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
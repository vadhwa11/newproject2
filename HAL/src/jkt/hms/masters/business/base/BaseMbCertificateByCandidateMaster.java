package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * mb_certificate_by_candidate_master table. Do not modify this class because it
 * will be overwritten if the configuration file related to this class is
 * modified.
 * 
 * @hibernate.class table="mb_certificate_by_candidate_master"
 */

public abstract class BaseMbCertificateByCandidateMaster implements
		Serializable {

	public static String REF = "MbCertificateByCandidateMaster";
	public static String PROP_NAME = "Name";
	public static String PROP_STATUS = "Status";
	public static String PROP_PLACE = "Place";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_OPT_REPORT_APPEAL_EXAMINATION = "OptReportAppealExamination";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_CHEST_NO = "ChestNo";
	public static String PROP_ENTRY_NO = "EntryNo";
	public static String PROP_ID = "Id";
	public static String PROP_ENTRY_DATE = "EntryDate";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_BATCH_NO = "BatchNo";

	// constructors
	public BaseMbCertificateByCandidateMaster() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMbCertificateByCandidateMaster(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer entryNo;
	private java.util.Date entryDate;
	private java.lang.String batchNo;
	private java.lang.String chestNo;
	private java.lang.String name;
	private java.lang.String place;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String optReportAppealExamination;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native"
	 *               column="certificate_by_candidate_master_id"
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
	public java.lang.Integer getEntryNo() {
		return entryNo;
	}

	/**
	 * Set the value related to the column: entry_no
	 * 
	 * @param entryNo
	 *            the entry_no value
	 */
	public void setEntryNo(java.lang.Integer entryNo) {
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
	 * Return the value associated with the column: batch_no
	 */
	public java.lang.String getBatchNo() {
		return batchNo;
	}

	/**
	 * Set the value related to the column: batch_no
	 * 
	 * @param batchNo
	 *            the batch_no value
	 */
	public void setBatchNo(java.lang.String batchNo) {
		this.batchNo = batchNo;
	}

	/**
	 * Return the value associated with the column: chest_no
	 */
	public java.lang.String getChestNo() {
		return chestNo;
	}

	/**
	 * Set the value related to the column: chest_no
	 * 
	 * @param chestNo
	 *            the chest_no value
	 */
	public void setChestNo(java.lang.String chestNo) {
		this.chestNo = chestNo;
	}

	/**
	 * Return the value associated with the column: name
	 */
	public java.lang.String getName() {
		return name;
	}

	/**
	 * Set the value related to the column: name
	 * 
	 * @param name
	 *            the name value
	 */
	public void setName(java.lang.String name) {
		this.name = name;
	}

	/**
	 * Return the value associated with the column: place
	 */
	public java.lang.String getPlace() {
		return place;
	}

	/**
	 * Set the value related to the column: place
	 * 
	 * @param place
	 *            the place value
	 */
	public void setPlace(java.lang.String place) {
		this.place = place;
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
	 * Return the value associated with the column:
	 * opt_report_appeal_examination
	 */
	public java.lang.String getOptReportAppealExamination() {
		return optReportAppealExamination;
	}

	/**
	 * Set the value related to the column: opt_report_appeal_examination
	 * 
	 * @param optReportAppealExamination
	 *            the opt_report_appeal_examination value
	 */
	public void setOptReportAppealExamination(
			java.lang.String optReportAppealExamination) {
		this.optReportAppealExamination = optReportAppealExamination;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MbCertificateByCandidateMaster))
			return false;
		else {
			jkt.hms.masters.business.MbCertificateByCandidateMaster mbCertificateByCandidateMaster = (jkt.hms.masters.business.MbCertificateByCandidateMaster) obj;
			if (null == this.getId()
					|| null == mbCertificateByCandidateMaster.getId())
				return false;
			else
				return (this.getId().equals(mbCertificateByCandidateMaster
						.getId()));
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
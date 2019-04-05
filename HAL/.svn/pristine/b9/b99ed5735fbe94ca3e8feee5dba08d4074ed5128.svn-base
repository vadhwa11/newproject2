package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * mb_result_of_appeal_medicalboard_master table. Do not modify this class
 * because it will be overwritten if the configuration file related to this
 * class is modified.
 * 
 * @hibernate.class table="mb_result_of_appeal_medicalboard_master"
 */

public abstract class BaseMbResultOfAppealMedicalboardMaster implements
		Serializable {

	public static String REF = "MbResultOfAppealMedicalboardMaster";
	public static String PROP_NAME = "Name";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_APPEAL_MEDICALBOARD_EXAMINATION = "AppealMedicalboardExamination";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_CHEST_NO = "ChestNo";
	public static String PROP_ENTRY_NO = "EntryNo";
	public static String PROP_ID = "Id";
	public static String PROP_ENTRY_DATE = "EntryDate";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_BATCH_NO = "BatchNo";

	// constructors
	public BaseMbResultOfAppealMedicalboardMaster() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMbResultOfAppealMedicalboardMaster(java.lang.Integer id) {
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
	private java.lang.String appealMedicalboardExamination;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// collections
	private java.util.Set<jkt.hms.masters.business.MbResultOfAppealMedicalboardUnfitExpl> mbResultOfAppealMedicalboardUnfitExpls;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native"
	 *               column="result_of_appeal_medicalboard_master_id"
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
	 * Return the value associated with the column:
	 * appeal_medicalboard_examination
	 */
	public java.lang.String getAppealMedicalboardExamination() {
		return appealMedicalboardExamination;
	}

	/**
	 * Set the value related to the column: appeal_medicalboard_examination
	 * 
	 * @param appealMedicalboardExamination
	 *            the appeal_medicalboard_examination value
	 */
	public void setAppealMedicalboardExamination(
			java.lang.String appealMedicalboardExamination) {
		this.appealMedicalboardExamination = appealMedicalboardExamination;
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
	 * MbResultOfAppealMedicalboardUnfitExpls
	 */
	public java.util.Set<jkt.hms.masters.business.MbResultOfAppealMedicalboardUnfitExpl> getMbResultOfAppealMedicalboardUnfitExpls() {
		return mbResultOfAppealMedicalboardUnfitExpls;
	}

	/**
	 * Set the value related to the column:
	 * MbResultOfAppealMedicalboardUnfitExpls
	 * 
	 * @param mbResultOfAppealMedicalboardUnfitExpls
	 *            the MbResultOfAppealMedicalboardUnfitExpls value
	 */
	public void setMbResultOfAppealMedicalboardUnfitExpls(
			java.util.Set<jkt.hms.masters.business.MbResultOfAppealMedicalboardUnfitExpl> mbResultOfAppealMedicalboardUnfitExpls) {
		this.mbResultOfAppealMedicalboardUnfitExpls = mbResultOfAppealMedicalboardUnfitExpls;
	}

	public void addToMbResultOfAppealMedicalboardUnfitExpls(
			jkt.hms.masters.business.MbResultOfAppealMedicalboardUnfitExpl mbResultOfAppealMedicalboardUnfitExpl) {
		if (null == getMbResultOfAppealMedicalboardUnfitExpls())
			setMbResultOfAppealMedicalboardUnfitExpls(new java.util.TreeSet<jkt.hms.masters.business.MbResultOfAppealMedicalboardUnfitExpl>());
		getMbResultOfAppealMedicalboardUnfitExpls().add(
				mbResultOfAppealMedicalboardUnfitExpl);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MbResultOfAppealMedicalboardMaster))
			return false;
		else {
			jkt.hms.masters.business.MbResultOfAppealMedicalboardMaster mbResultOfAppealMedicalboardMaster = (jkt.hms.masters.business.MbResultOfAppealMedicalboardMaster) obj;
			if (null == this.getId()
					|| null == mbResultOfAppealMedicalboardMaster.getId())
				return false;
			else
				return (this.getId().equals(mbResultOfAppealMedicalboardMaster
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
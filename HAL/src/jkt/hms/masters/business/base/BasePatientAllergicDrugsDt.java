package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the patient_allergic_drugs_dt
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="patient_allergic_drugs_dt"
 */

public abstract class BasePatientAllergicDrugsDt implements Serializable {

	public static String REF = "PatientAllergicDrugsDt";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_PATIENT_ALLERGIC_DRUGS_HD = "PatientAllergicDrugsHd";
	public static String PROP_ITEM = "Item";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_SPECIAL_INSTRUCTION = "SpecialInstruction";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ID = "Id";

	// constructors
	public BasePatientAllergicDrugsDt() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePatientAllergicDrugsDt(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String specialInstruction;
	private java.lang.Integer lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.PatientAllergicDrugsHd patientAllergicDrugsHd;
	private jkt.hms.masters.business.MasStoreItem item;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native"
	 *               column="patient_allergic_drugs_dt_id"
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
	 * Return the value associated with the column: special_Instruction
	 */
	public java.lang.String getSpecialInstruction() {
		return specialInstruction;
	}

	/**
	 * Set the value related to the column: special_Instruction
	 * 
	 * @param specialInstruction
	 *            the special_Instruction value
	 */
	public void setSpecialInstruction(java.lang.String specialInstruction) {
		this.specialInstruction = specialInstruction;
	}

	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.Integer getLastChgBy() {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * 
	 * @param lastChgBy
	 *            the last_chg_by value
	 */
	public void setLastChgBy(java.lang.Integer lastChgBy) {
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
	 * Return the value associated with the column: patient_allergic_drugs_hd_id
	 */
	public jkt.hms.masters.business.PatientAllergicDrugsHd getPatientAllergicDrugsHd() {
		return patientAllergicDrugsHd;
	}

	/**
	 * Set the value related to the column: patient_allergic_drugs_hd_id
	 * 
	 * @param patientAllergicDrugsHd
	 *            the patient_allergic_drugs_hd_id value
	 */
	public void setPatientAllergicDrugsHd(
			jkt.hms.masters.business.PatientAllergicDrugsHd patientAllergicDrugsHd) {
		this.patientAllergicDrugsHd = patientAllergicDrugsHd;
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
		if (!(obj instanceof jkt.hms.masters.business.PatientAllergicDrugsDt))
			return false;
		else {
			jkt.hms.masters.business.PatientAllergicDrugsDt patientAllergicDrugsDt = (jkt.hms.masters.business.PatientAllergicDrugsDt) obj;
			if (null == this.getId() || null == patientAllergicDrugsDt.getId())
				return false;
			else
				return (this.getId().equals(patientAllergicDrugsDt.getId()));
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
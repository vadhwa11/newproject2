package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the sil_dil_status table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="sil_dil_status"
 */

public abstract class BaseSilDilStatus implements Serializable {

	public static String REF = "SilDilStatus";
	public static String PROP_ICD = "Icd";
	public static String PROP_PLACED_BY = "PlacedBy";
	public static String PROP_SIL_DIL_REMARKS = "sil_dil_Remarks";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_CONDITION_STATUS = "ConditionStatus";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_TREATMENT = "Treatment";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_NOK = "Nok";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_INPATIENT = "Inpatient";

	// constructors
	public BaseSilDilStatus() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSilDilStatus(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String treatment;
	private java.lang.String remarks;
	private java.lang.String sil_dil_Remarks;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgBy;
	private java.lang.String lastChgTime;
	private java.lang.String conditionStatus;
	private java.lang.String nok;

	// many to one
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasIcd icd;
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.MasEmployee placedBy;

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
	 * Return the value associated with the column: treatment
	 */
	public java.lang.String getTreatment() {
		return treatment;
	}

	/**
	 * Set the value related to the column: treatment
	 * 
	 * @param treatment
	 *            the treatment value
	 */
	public void setTreatment(java.lang.String treatment) {
		this.treatment = treatment;
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
	 * Return the value associated with the column: sil_dil_remarks
	 */
	public java.lang.String getSil_dil_Remarks() {
		return sil_dil_Remarks;
	}

	/**
	 * Set the value related to the column: sil_dil_remarks
	 * 
	 * @param sil_dil_Remarks
	 *            the sil_dil_remarks value
	 */
	public void setSil_dil_Remarks(java.lang.String sil_dil_Remarks) {
		this.sil_dil_Remarks = sil_dil_Remarks;
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
	 * Return the value associated with the column: condition_status
	 */
	public java.lang.String getConditionStatus() {
		return conditionStatus;
	}

	/**
	 * Set the value related to the column: condition_status
	 * 
	 * @param conditionStatus
	 *            the condition_status value
	 */
	public void setConditionStatus(java.lang.String conditionStatus) {
		this.conditionStatus = conditionStatus;
	}

	/**
	 * Return the value associated with the column: nok
	 */
	public java.lang.String getNok() {
		return nok;
	}

	/**
	 * Set the value related to the column: nok
	 * 
	 * @param nok
	 *            the nok value
	 */
	public void setNok(java.lang.String nok) {
		this.nok = nok;
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
	 * Return the value associated with the column: icd_id
	 */
	public jkt.hms.masters.business.MasIcd getIcd() {
		return icd;
	}

	/**
	 * Set the value related to the column: icd_id
	 * 
	 * @param icd
	 *            the icd_id value
	 */
	public void setIcd(jkt.hms.masters.business.MasIcd icd) {
		this.icd = icd;
	}

	/**
	 * Return the value associated with the column: inpatient_id
	 */
	public jkt.hms.masters.business.Inpatient getInpatient() {
		return inpatient;
	}

	/**
	 * Set the value related to the column: inpatient_id
	 * 
	 * @param inpatient
	 *            the inpatient_id value
	 */
	public void setInpatient(jkt.hms.masters.business.Inpatient inpatient) {
		this.inpatient = inpatient;
	}

	/**
	 * Return the value associated with the column: placed_by
	 */
	public jkt.hms.masters.business.MasEmployee getPlacedBy() {
		return placedBy;
	}

	/**
	 * Set the value related to the column: placed_by
	 * 
	 * @param placedBy
	 *            the placed_by value
	 */
	public void setPlacedBy(jkt.hms.masters.business.MasEmployee placedBy) {
		this.placedBy = placedBy;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.SilDilStatus))
			return false;
		else {
			jkt.hms.masters.business.SilDilStatus silDilStatus = (jkt.hms.masters.business.SilDilStatus) obj;
			if (null == this.getId() || null == silDilStatus.getId())
				return false;
			else
				return (this.getId().equals(silDilStatus.getId()));
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
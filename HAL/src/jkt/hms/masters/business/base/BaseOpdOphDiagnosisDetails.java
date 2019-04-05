package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the opd_oph_diagnosis_details
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="opd_oph_diagnosis_details"
 */

public abstract class BaseOpdOphDiagnosisDetails implements Serializable {

	public static String REF = "OpdOphDiagnosisDetails";
	public static String PROP_FREQUENCY = "Frequency";
	public static String PROP_DRUG_TYPE = "DrugType";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_EYE = "Eye";
	public static String PROP_MEDICINE = "Medicine";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_OPH_DIAGNOSIS_HEADER = "OphDiagnosisHeader";
	public static String PROP_ID = "Id";

	// constructors
	public BaseOpdOphDiagnosisDetails() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdOphDiagnosisDetails(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String medicine;
	private java.lang.String drugType;
	private java.lang.String eye;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasFrequency frequency;
	private jkt.hms.masters.business.OpdOphDiagnosisHeader ophDiagnosisHeader;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="oph_diagnosis_details_id"
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
	 * Return the value associated with the column: medicine
	 */
	public java.lang.String getMedicine() {
		return medicine;
	}

	/**
	 * Set the value related to the column: medicine
	 * 
	 * @param medicine
	 *            the medicine value
	 */
	public void setMedicine(java.lang.String medicine) {
		this.medicine = medicine;
	}

	/**
	 * Return the value associated with the column: drug_type
	 */
	public java.lang.String getDrugType() {
		return drugType;
	}

	/**
	 * Set the value related to the column: drug_type
	 * 
	 * @param drugType
	 *            the drug_type value
	 */
	public void setDrugType(java.lang.String drugType) {
		this.drugType = drugType;
	}

	/**
	 * Return the value associated with the column: eye
	 */
	public java.lang.String getEye() {
		return eye;
	}

	/**
	 * Set the value related to the column: eye
	 * 
	 * @param eye
	 *            the eye value
	 */
	public void setEye(java.lang.String eye) {
		this.eye = eye;
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
	 * Return the value associated with the column: frequency_id
	 */
	public jkt.hms.masters.business.MasFrequency getFrequency() {
		return frequency;
	}

	/**
	 * Set the value related to the column: frequency_id
	 * 
	 * @param frequency
	 *            the frequency_id value
	 */
	public void setFrequency(jkt.hms.masters.business.MasFrequency frequency) {
		this.frequency = frequency;
	}

	/**
	 * Return the value associated with the column: oph_diagnosis_header_id
	 */
	public jkt.hms.masters.business.OpdOphDiagnosisHeader getOphDiagnosisHeader() {
		return ophDiagnosisHeader;
	}

	/**
	 * Set the value related to the column: oph_diagnosis_header_id
	 * 
	 * @param ophDiagnosisHeader
	 *            the oph_diagnosis_header_id value
	 */
	public void setOphDiagnosisHeader(
			jkt.hms.masters.business.OpdOphDiagnosisHeader ophDiagnosisHeader) {
		this.ophDiagnosisHeader = ophDiagnosisHeader;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.OpdOphDiagnosisDetails))
			return false;
		else {
			jkt.hms.masters.business.OpdOphDiagnosisDetails opdOphDiagnosisDetails = (jkt.hms.masters.business.OpdOphDiagnosisDetails) obj;
			if (null == this.getId() || null == opdOphDiagnosisDetails.getId())
				return false;
			else
				return (this.getId().equals(opdOphDiagnosisDetails.getId()));
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
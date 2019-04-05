package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ECG_RECORD_REGISTER table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ECG_RECORD_REGISTER"
 */

public abstract class BaseEcgRecordRegister  implements Serializable {

	public static String REF = "EcgRecordRegister";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_VALIDATE_BY_DOCTOR = "ValidateByDoctor";
	public static String PROP_VISIT = "Visit";
	public static String PROP_ECG_TYPE = "EcgType";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_DIAGNOSIS = "Diagnosis";
	public static String PROP_ECG_DATE = "EcgDate";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_HIN = "Hin";
	public static String PROP_ECG_TIME = "EcgTime";


	// constructors
	public BaseEcgRecordRegister () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseEcgRecordRegister (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date ecgDate;
	private java.lang.String ecgTime;
	private java.lang.String remarks;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String diagnosis;

	// many to one
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.MasEcgType ecgType;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.MasEmployee validateByDoctor;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="ECG_RECORD_REGISTER_ID"
     */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: ECG_DATE
	 */
	public java.util.Date getEcgDate () {
		return ecgDate;
	}

	/**
	 * Set the value related to the column: ECG_DATE
	 * @param ecgDate the ECG_DATE value
	 */
	public void setEcgDate (java.util.Date ecgDate) {
		this.ecgDate = ecgDate;
	}



	/**
	 * Return the value associated with the column: ECG_TIME
	 */
	public java.lang.String getEcgTime () {
		return ecgTime;
	}

	/**
	 * Set the value related to the column: ECG_TIME
	 * @param ecgTime the ECG_TIME value
	 */
	public void setEcgTime (java.lang.String ecgTime) {
		this.ecgTime = ecgTime;
	}



	/**
	 * Return the value associated with the column: REMARKS
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: REMARKS
	 * @param remarks the REMARKS value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
	}



	/**
	 * Return the value associated with the column: LAST_CHG_DATE
	 */
	public java.util.Date getLastChgDate () {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: LAST_CHG_DATE
	 * @param lastChgDate the LAST_CHG_DATE value
	 */
	public void setLastChgDate (java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}



	/**
	 * Return the value associated with the column: LAST_CHG_TIME
	 */
	public java.lang.String getLastChgTime () {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: LAST_CHG_TIME
	 * @param lastChgTime the LAST_CHG_TIME value
	 */
	public void setLastChgTime (java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}



	/**
	 * Return the value associated with the column: DIAGNOSIS
	 */
	public java.lang.String getDiagnosis () {
		return diagnosis;
	}

	/**
	 * Set the value related to the column: DIAGNOSIS
	 * @param diagnosis the DIAGNOSIS value
	 */
	public void setDiagnosis (java.lang.String diagnosis) {
		this.diagnosis = diagnosis;
	}



	/**
	 * Return the value associated with the column: VISIT_ID
	 */
	public jkt.hms.masters.business.Visit getVisit () {
		return visit;
	}

	/**
	 * Set the value related to the column: VISIT_ID
	 * @param visit the VISIT_ID value
	 */
	public void setVisit (jkt.hms.masters.business.Visit visit) {
		this.visit = visit;
	}



	/**
	 * Return the value associated with the column: ECG_TYPE_ID
	 */
	public jkt.hms.masters.business.MasEcgType getEcgType () {
		return ecgType;
	}

	/**
	 * Set the value related to the column: ECG_TYPE_ID
	 * @param ecgType the ECG_TYPE_ID value
	 */
	public void setEcgType (jkt.hms.masters.business.MasEcgType ecgType) {
		this.ecgType = ecgType;
	}



	/**
	 * Return the value associated with the column: HIN_ID
	 */
	public jkt.hms.masters.business.Patient getHin () {
		return hin;
	}

	/**
	 * Set the value related to the column: HIN_ID
	 * @param hin the HIN_ID value
	 */
	public void setHin (jkt.hms.masters.business.Patient hin) {
		this.hin = hin;
	}



	/**
	 * Return the value associated with the column: VALIDATE_BY_DOCTOR
	 */
	public jkt.hms.masters.business.MasEmployee getValidateByDoctor () {
		return validateByDoctor;
	}

	/**
	 * Set the value related to the column: VALIDATE_BY_DOCTOR
	 * @param validateByDoctor the VALIDATE_BY_DOCTOR value
	 */
	public void setValidateByDoctor (jkt.hms.masters.business.MasEmployee validateByDoctor) {
		this.validateByDoctor = validateByDoctor;
	}



	/**
	 * Return the value associated with the column: LAST_CHG_BY
	 */
	public jkt.hms.masters.business.Users getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: LAST_CHG_BY
	 * @param lastChgBy the LAST_CHG_BY value
	 */
	public void setLastChgBy (jkt.hms.masters.business.Users lastChgBy) {
		this.lastChgBy = lastChgBy;
	}



	/**
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital () {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * @param hospital the hospital_id value
	 */
	public void setHospital (jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.EcgRecordRegister)) return false;
		else {
			jkt.hms.masters.business.EcgRecordRegister ecgRecordRegister = (jkt.hms.masters.business.EcgRecordRegister) obj;
			if (null == this.getId() || null == ecgRecordRegister.getId()) return false;
			else return (this.getId().equals(ecgRecordRegister.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}
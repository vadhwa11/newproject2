package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the md_special_investigation_hd table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="md_special_investigation_hd"
 */

public abstract class BaseMdSpecialInvestigationHd  implements Serializable {

	public static String REF = "MdSpecialInvestigationHd";
	public static String PROP_SPECIAL_DATE = "SpecialDate";
	public static String PROP_ICD = "Icd";
	public static String PROP_APPOINTMNET_TIME = "AppointmnetTime";
	public static String PROP_WORKING_DIAGNOSIS = "WorkingDiagnosis";
	public static String PROP_YEARLY_NO = "YearlyNo";
	public static String PROP_APPOINTMENT_DATE = "AppointmentDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_SUGGEST_TO = "SuggestTo";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ID = "Id";
	public static String PROP_REFERRED_TO = "ReferredTo";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_HIN = "Hin";
	public static String PROP_INPATIENT = "Inpatient";


	// constructors
	public BaseMdSpecialInvestigationHd () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMdSpecialInvestigationHd (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String yearlyNo;
	private java.util.Date specialDate;
	private java.util.Date appointmentDate;
	private java.lang.String appointmnetTime;
	private java.lang.String workingDiagnosis;
	private java.lang.String suggestTo;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasReference referredTo;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasIcd icd;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.Patient hin;

	// collections
	private java.util.Set<jkt.hms.masters.business.MdSpecialInvestigationDt> mdSpecialInvestigationDts;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="id"
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
	 * Return the value associated with the column: yearly_no
	 */
	public java.lang.String getYearlyNo () {
		return yearlyNo;
	}

	/**
	 * Set the value related to the column: yearly_no
	 * @param yearlyNo the yearly_no value
	 */
	public void setYearlyNo (java.lang.String yearlyNo) {
		this.yearlyNo = yearlyNo;
	}



	/**
	 * Return the value associated with the column: SPECIAL_DATE
	 */
	public java.util.Date getSpecialDate () {
		return specialDate;
	}

	/**
	 * Set the value related to the column: SPECIAL_DATE
	 * @param specialDate the SPECIAL_DATE value
	 */
	public void setSpecialDate (java.util.Date specialDate) {
		this.specialDate = specialDate;
	}



	/**
	 * Return the value associated with the column: appointment_date
	 */
	public java.util.Date getAppointmentDate () {
		return appointmentDate;
	}

	/**
	 * Set the value related to the column: appointment_date
	 * @param appointmentDate the appointment_date value
	 */
	public void setAppointmentDate (java.util.Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}



	/**
	 * Return the value associated with the column: appointmnet_time
	 */
	public java.lang.String getAppointmnetTime () {
		return appointmnetTime;
	}

	/**
	 * Set the value related to the column: appointmnet_time
	 * @param appointmnetTime the appointmnet_time value
	 */
	public void setAppointmnetTime (java.lang.String appointmnetTime) {
		this.appointmnetTime = appointmnetTime;
	}



	/**
	 * Return the value associated with the column: working_diagnosis
	 */
	public java.lang.String getWorkingDiagnosis () {
		return workingDiagnosis;
	}

	/**
	 * Set the value related to the column: working_diagnosis
	 * @param workingDiagnosis the working_diagnosis value
	 */
	public void setWorkingDiagnosis (java.lang.String workingDiagnosis) {
		this.workingDiagnosis = workingDiagnosis;
	}



	/**
	 * Return the value associated with the column: suggest_to
	 */
	public java.lang.String getSuggestTo () {
		return suggestTo;
	}

	/**
	 * Set the value related to the column: suggest_to
	 * @param suggestTo the suggest_to value
	 */
	public void setSuggestTo (java.lang.String suggestTo) {
		this.suggestTo = suggestTo;
	}



	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * @param status the status value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
	}



	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.String getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
	}



	/**
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate () {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * @param lastChgDate the last_chg_date value
	 */
	public void setLastChgDate (java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}



	/**
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime () {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * @param lastChgTime the last_chg_time value
	 */
	public void setLastChgTime (java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}



	/**
	 * Return the value associated with the column: referred_to
	 */
	public jkt.hms.masters.business.MasReference getReferredTo () {
		return referredTo;
	}

	/**
	 * Set the value related to the column: referred_to
	 * @param referredTo the referred_to value
	 */
	public void setReferredTo (jkt.hms.masters.business.MasReference referredTo) {
		this.referredTo = referredTo;
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



	/**
	 * Return the value associated with the column: icd_id
	 */
	public jkt.hms.masters.business.MasIcd getIcd () {
		return icd;
	}

	/**
	 * Set the value related to the column: icd_id
	 * @param icd the icd_id value
	 */
	public void setIcd (jkt.hms.masters.business.MasIcd icd) {
		this.icd = icd;
	}



	/**
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment () {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * @param department the department_id value
	 */
	public void setDepartment (jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}



	/**
	 * Return the value associated with the column: inpatient_id
	 */
	public jkt.hms.masters.business.Inpatient getInpatient () {
		return inpatient;
	}

	/**
	 * Set the value related to the column: inpatient_id
	 * @param inpatient the inpatient_id value
	 */
	public void setInpatient (jkt.hms.masters.business.Inpatient inpatient) {
		this.inpatient = inpatient;
	}



	/**
	 * Return the value associated with the column: hin_id
	 */
	public jkt.hms.masters.business.Patient getHin () {
		return hin;
	}

	/**
	 * Set the value related to the column: hin_id
	 * @param hin the hin_id value
	 */
	public void setHin (jkt.hms.masters.business.Patient hin) {
		this.hin = hin;
	}



	/**
	 * Return the value associated with the column: MdSpecialInvestigationDts
	 */
	public java.util.Set<jkt.hms.masters.business.MdSpecialInvestigationDt> getMdSpecialInvestigationDts () {
		return mdSpecialInvestigationDts;
	}

	/**
	 * Set the value related to the column: MdSpecialInvestigationDts
	 * @param mdSpecialInvestigationDts the MdSpecialInvestigationDts value
	 */
	public void setMdSpecialInvestigationDts (java.util.Set<jkt.hms.masters.business.MdSpecialInvestigationDt> mdSpecialInvestigationDts) {
		this.mdSpecialInvestigationDts = mdSpecialInvestigationDts;
	}

	public void addToMdSpecialInvestigationDts (jkt.hms.masters.business.MdSpecialInvestigationDt mdSpecialInvestigationDt) {
		if (null == getMdSpecialInvestigationDts()) setMdSpecialInvestigationDts(new java.util.TreeSet<jkt.hms.masters.business.MdSpecialInvestigationDt>());
		getMdSpecialInvestigationDts().add(mdSpecialInvestigationDt);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MdSpecialInvestigationHd)) return false;
		else {
			jkt.hms.masters.business.MdSpecialInvestigationHd mdSpecialInvestigationHd = (jkt.hms.masters.business.MdSpecialInvestigationHd) obj;
			if (null == this.getId() || null == mdSpecialInvestigationHd.getId()) return false;
			else return (this.getId().equals(mdSpecialInvestigationHd.getId()));
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
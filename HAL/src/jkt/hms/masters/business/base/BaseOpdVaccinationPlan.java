package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_vaccination_plan table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_vaccination_plan"
 */

public abstract class BaseOpdVaccinationPlan  implements Serializable {

	public static String REF = "OpdVaccinationPlan";
	public static String PROP_VACCIN = "Vaccin";
	public static String PROP_VACCIN_DATE = "VaccinDate";
	public static String PROP_SUB_CENTRE = "SubCentre";
	public static String PROP_VACCINE_SOURCE = "VaccineSource";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_VACCINE_PLACE = "VaccinePlace";
	public static String PROP_VISIT = "Visit";
	public static String PROP_DOB = "Dob";
	public static String PROP_VACINATION_TYPE = "VacinationType";
	public static String PROP_INJ_APPOINT_DT = "InjAppointDt";
	public static String PROP_VACCIN_TO_DATE = "vaccinToDate";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ID = "Id";
	public static String PROP_VACCIN_COMPLETE_DATE = "VaccinCompleteDate";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_HIN = "Hin";


	// constructors
	public BaseOpdVaccinationPlan () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdVaccinationPlan (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String vacinationType;
	private java.util.Date dob;
	private java.util.Date vaccinDate;
	private java.util.Date vaccinCompleteDate;
	private java.util.Date vaccinToDate;
	private java.lang.String remarks;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;
	private java.lang.String vaccinePlace;
	private java.lang.String vaccineSource;

	// many to one
	private jkt.hms.masters.business.MasHospital subCentre;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.MasVaccineItem vaccin;
	private jkt.hms.masters.business.InjAppointmentDetails injAppointDt;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="opd_vaccination_plan"
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
	 * Return the value associated with the column: vacination_type
	 */
	public java.lang.String getVacinationType () {
		return vacinationType;
	}

	/**
	 * Set the value related to the column: vacination_type
	 * @param vacinationType the vacination_type value
	 */
	public void setVacinationType (java.lang.String vacinationType) {
		this.vacinationType = vacinationType;
	}



	/**
	 * Return the value associated with the column: dob
	 */
	public java.util.Date getDob () {
		return dob;
	}

	/**
	 * Set the value related to the column: dob
	 * @param dob the dob value
	 */
	public void setDob (java.util.Date dob) {
		this.dob = dob;
	}



	/**
	 * Return the value associated with the column: vaccin_date
	 */
	public java.util.Date getVaccinDate () {
		return vaccinDate;
	}

	/**
	 * Set the value related to the column: vaccin_date
	 * @param vaccinDate the vaccin_date value
	 */
	public void setVaccinDate (java.util.Date vaccinDate) {
		this.vaccinDate = vaccinDate;
	}



	/**
	 * Return the value associated with the column: vaccin_complete_date
	 */
	public java.util.Date getVaccinCompleteDate () {
		return vaccinCompleteDate;
	}

	/**
	 * Set the value related to the column: vaccin_complete_date
	 * @param vaccinCompleteDate the vaccin_complete_date value
	 */
	public void setVaccinCompleteDate (java.util.Date vaccinCompleteDate) {
		this.vaccinCompleteDate = vaccinCompleteDate;
	}



	/**
	 * Return the value associated with the column: vaccin_to_date
	 */
	public java.util.Date getVaccinToDate () {
		return vaccinToDate;
	}

	/**
	 * Set the value related to the column: vaccin_to_date
	 * @param vaccinToDate the vaccin_to_date value
	 */
	public void setVaccinToDate (java.util.Date vaccinToDate) {
		this.vaccinToDate = vaccinToDate;
	}



	/**
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * @param remarks the remarks value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
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
	 * Return the value associated with the column: vaccine_place
	 */
	public java.lang.String getVaccinePlace () {
		return vaccinePlace;
	}

	/**
	 * Set the value related to the column: vaccine_place
	 * @param vaccinePlace the vaccine_place value
	 */
	public void setVaccinePlace (java.lang.String vaccinePlace) {
		this.vaccinePlace = vaccinePlace;
	}



	/**
	 * Return the value associated with the column: vaccine_source
	 */
	public java.lang.String getVaccineSource () {
		return vaccineSource;
	}

	/**
	 * Set the value related to the column: vaccine_source
	 * @param vaccineSource the vaccine_source value
	 */
	public void setVaccineSource (java.lang.String vaccineSource) {
		this.vaccineSource = vaccineSource;
	}



	/**
	 * Return the value associated with the column: sub_centre_id
	 */
	public jkt.hms.masters.business.MasHospital getSubCentre () {
		return subCentre;
	}

	/**
	 * Set the value related to the column: sub_centre_id
	 * @param subCentre the sub_centre_id value
	 */
	public void setSubCentre (jkt.hms.masters.business.MasHospital subCentre) {
		this.subCentre = subCentre;
	}



	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public jkt.hms.masters.business.Users getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
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



	/**
	 * Return the value associated with the column: visit_id
	 */
	public jkt.hms.masters.business.Visit getVisit () {
		return visit;
	}

	/**
	 * Set the value related to the column: visit_id
	 * @param visit the visit_id value
	 */
	public void setVisit (jkt.hms.masters.business.Visit visit) {
		this.visit = visit;
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
	 * Return the value associated with the column: vaccin_id
	 */
	public jkt.hms.masters.business.MasVaccineItem getVaccin () {
		return vaccin;
	}

	/**
	 * Set the value related to the column: vaccin_id
	 * @param vaccin the vaccin_id value
	 */
	public void setVaccin (jkt.hms.masters.business.MasVaccineItem vaccin) {
		this.vaccin = vaccin;
	}



	/**
	 * Return the value associated with the column: inj_appoint_dt
	 */
	public jkt.hms.masters.business.InjAppointmentDetails getInjAppointDt () {
		return injAppointDt;
	}

	/**
	 * Set the value related to the column: inj_appoint_dt
	 * @param injAppointDt the inj_appoint_dt value
	 */
	public void setInjAppointDt (jkt.hms.masters.business.InjAppointmentDetails injAppointDt) {
		this.injAppointDt = injAppointDt;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OpdVaccinationPlan)) return false;
		else {
			jkt.hms.masters.business.OpdVaccinationPlan opdVaccinationPlan = (jkt.hms.masters.business.OpdVaccinationPlan) obj;
			if (null == this.getId() || null == opdVaccinationPlan.getId()) return false;
			else return (this.getId().equals(opdVaccinationPlan.getId()));
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
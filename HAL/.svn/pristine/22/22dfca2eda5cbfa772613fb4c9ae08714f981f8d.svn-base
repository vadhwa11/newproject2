package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the pre_anesthesia_consult_doctor_dt table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="pre_anesthesia_consult_doctor_dt"
 */

public abstract class BasePreAnesthesiaConsultDoctorDt  implements Serializable {

	public static String REF = "PreAnesthesiaConsultDoctorDt";
	public static String PROP_CONSULTED_DOCTOR = "ConsultedDoctor";
	public static String PROP_STATUS = "Status";
	public static String PROP_OPD_PATIENT_DETAILS = "OpdPatientDetails";
	public static String PROP_CONSULT_TIME = "ConsultTime";
	public static String PROP_REFERRAL_NOTES = "ReferralNotes";
	public static String PROP_ID = "Id";
	public static String PROP_DOCTOR_ADVICE = "DoctorAdvice";
	public static String PROP_CONSULTATION_REC_BY = "ConsultationRecBy";
	public static String PROP_CONSULTED_DEPARTMENT = "ConsultedDepartment";
	public static String PROP_CONSULT_DATE = "ConsultDate";
	public static String PROP_CONSULT_DOCTOR_ID_HD = "ConsultDoctorIdHd";


	// constructors
	public BasePreAnesthesiaConsultDoctorDt () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePreAnesthesiaConsultDoctorDt (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date consultDate;
	private java.lang.String consultTime;
	private java.lang.String doctorAdvice;
	private java.lang.String referralNotes;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.PreAnesthesiaConsultDoctorHd consultDoctorIdHd;
	private jkt.hms.masters.business.MasEmployee consultationRecBy;
	private jkt.hms.masters.business.MasDepartment consultedDepartment;
	private jkt.hms.masters.business.MasEmployee consultedDoctor;
	private jkt.hms.masters.business.OpdPatientDetails opdPatientDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="consult_doctor_id_dt"
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
	 * Return the value associated with the column: consult_date
	 */
	public java.util.Date getConsultDate () {
		return consultDate;
	}

	/**
	 * Set the value related to the column: consult_date
	 * @param consultDate the consult_date value
	 */
	public void setConsultDate (java.util.Date consultDate) {
		this.consultDate = consultDate;
	}



	/**
	 * Return the value associated with the column: consult_time
	 */
	public java.lang.String getConsultTime () {
		return consultTime;
	}

	/**
	 * Set the value related to the column: consult_time
	 * @param consultTime the consult_time value
	 */
	public void setConsultTime (java.lang.String consultTime) {
		this.consultTime = consultTime;
	}



	/**
	 * Return the value associated with the column: doctor_advice
	 */
	public java.lang.String getDoctorAdvice () {
		return doctorAdvice;
	}

	/**
	 * Set the value related to the column: doctor_advice
	 * @param doctorAdvice the doctor_advice value
	 */
	public void setDoctorAdvice (java.lang.String doctorAdvice) {
		this.doctorAdvice = doctorAdvice;
	}



	/**
	 * Return the value associated with the column: referral_notes
	 */
	public java.lang.String getReferralNotes () {
		return referralNotes;
	}

	/**
	 * Set the value related to the column: referral_notes
	 * @param referralNotes the referral_notes value
	 */
	public void setReferralNotes (java.lang.String referralNotes) {
		this.referralNotes = referralNotes;
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
	 * Return the value associated with the column: consult_doctor_id_hd
	 */
	public jkt.hms.masters.business.PreAnesthesiaConsultDoctorHd getConsultDoctorIdHd () {
		return consultDoctorIdHd;
	}

	/**
	 * Set the value related to the column: consult_doctor_id_hd
	 * @param consultDoctorIdHd the consult_doctor_id_hd value
	 */
	public void setConsultDoctorIdHd (jkt.hms.masters.business.PreAnesthesiaConsultDoctorHd consultDoctorIdHd) {
		this.consultDoctorIdHd = consultDoctorIdHd;
	}



	/**
	 * Return the value associated with the column: consultation_rec_by
	 */
	public jkt.hms.masters.business.MasEmployee getConsultationRecBy () {
		return consultationRecBy;
	}

	/**
	 * Set the value related to the column: consultation_rec_by
	 * @param consultationRecBy the consultation_rec_by value
	 */
	public void setConsultationRecBy (jkt.hms.masters.business.MasEmployee consultationRecBy) {
		this.consultationRecBy = consultationRecBy;
	}



	/**
	 * Return the value associated with the column: consulted_department
	 */
	public jkt.hms.masters.business.MasDepartment getConsultedDepartment () {
		return consultedDepartment;
	}

	/**
	 * Set the value related to the column: consulted_department
	 * @param consultedDepartment the consulted_department value
	 */
	public void setConsultedDepartment (jkt.hms.masters.business.MasDepartment consultedDepartment) {
		this.consultedDepartment = consultedDepartment;
	}



	/**
	 * Return the value associated with the column: consulted_doctor
	 */
	public jkt.hms.masters.business.MasEmployee getConsultedDoctor () {
		return consultedDoctor;
	}

	/**
	 * Set the value related to the column: consulted_doctor
	 * @param consultedDoctor the consulted_doctor value
	 */
	public void setConsultedDoctor (jkt.hms.masters.business.MasEmployee consultedDoctor) {
		this.consultedDoctor = consultedDoctor;
	}



	/**
	 * Return the value associated with the column: opd_patient_details_id
	 */
	public jkt.hms.masters.business.OpdPatientDetails getOpdPatientDetails () {
		return opdPatientDetails;
	}

	/**
	 * Set the value related to the column: opd_patient_details_id
	 * @param opdPatientDetails the opd_patient_details_id value
	 */
	public void setOpdPatientDetails (jkt.hms.masters.business.OpdPatientDetails opdPatientDetails) {
		this.opdPatientDetails = opdPatientDetails;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PreAnesthesiaConsultDoctorDt)) return false;
		else {
			jkt.hms.masters.business.PreAnesthesiaConsultDoctorDt preAnesthesiaConsultDoctorDt = (jkt.hms.masters.business.PreAnesthesiaConsultDoctorDt) obj;
			if (null == this.getId() || null == preAnesthesiaConsultDoctorDt.getId()) return false;
			else return (this.getId().equals(preAnesthesiaConsultDoctorDt.getId()));
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
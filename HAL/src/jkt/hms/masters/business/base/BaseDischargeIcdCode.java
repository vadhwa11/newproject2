package jkt.hms.masters.business.base;

import java.io.Serializable;
import java.util.Date;

import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.MasIcd;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.business.Visit;


/**
 * This is an object that contains data related to the discharge_icd_code table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="discharge_icd_code"
 */

public abstract class BaseDischargeIcdCode  implements Serializable {

	public BaseDischargeIcdCode(BaseDischargeIcdCode bdic) {
		super();
		this.addEditDate = bdic.addEditDate;
		this.addEditTime = bdic.addEditTime;
		this.status = bdic.status;
		this.z03 = bdic.z03;
		this.z09 = bdic.z09;
		this.diagnosisStatus = bdic.diagnosisStatus;
		this.icd = bdic.icd;
		this.inpatient = bdic.inpatient;
		this.addEditBy = bdic.addEditBy;
		this.visit = bdic.visit;
		this.hin = bdic.hin;
	}



	public static String REF = "DischargeIcdCode";
	public static String PROP_ICD = "Icd";
	public static String PROP_Z09 = "Z09";
	public static String PROP_VISIT = "Visit";
	public static String PROP_ADD_EDIT_DATE = "AddEditDate";
	public static String PROP_STATUS = "Status";
	public static String PROP_OPD_PATIENT_DETAILS = "OpdPatientDetails";
	public static String PROP_ADD_EDIT_BY = "AddEditBy";
	public static String PROP_DIAGNOSIS_STATUS = "DiagnosisStatus";
	public static String PROP_ID = "Id";
	public static String PROP_ADD_EDIT_TIME = "AddEditTime";
	public static String PROP_Z03 = "Z03";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_HIN = "Hin";


	// constructors
	public BaseDischargeIcdCode () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDischargeIcdCode (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date addEditDate;
	private java.lang.String addEditTime;
	private java.lang.String status;
	private java.lang.String z03;
	private java.lang.String z09;
	private java.lang.String diagnosisStatus;

	// many to one
	private jkt.hms.masters.business.MasIcd icd;
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.Users addEditBy;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.OpdPatientDetails opdPatientDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="discharge_icd_code_id"
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
	 * Return the value associated with the column: add_edit_date
	 */
	public java.util.Date getAddEditDate () {
		return addEditDate;
	}

	/**
	 * Set the value related to the column: add_edit_date
	 * @param addEditDate the add_edit_date value
	 */
	public void setAddEditDate (java.util.Date addEditDate) {
		this.addEditDate = addEditDate;
	}



	/**
	 * Return the value associated with the column: add_edit_time
	 */
	public java.lang.String getAddEditTime () {
		return addEditTime;
	}

	/**
	 * Set the value related to the column: add_edit_time
	 * @param addEditTime the add_edit_time value
	 */
	public void setAddEditTime (java.lang.String addEditTime) {
		this.addEditTime = addEditTime;
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
	 * Return the value associated with the column: z03
	 */
	public java.lang.String getZ03 () {
		return z03;
	}

	/**
	 * Set the value related to the column: z03
	 * @param z03 the z03 value
	 */
	public void setZ03 (java.lang.String z03) {
		this.z03 = z03;
	}



	/**
	 * Return the value associated with the column: z09
	 */
	public java.lang.String getZ09 () {
		return z09;
	}

	/**
	 * Set the value related to the column: z09
	 * @param z09 the z09 value
	 */
	public void setZ09 (java.lang.String z09) {
		this.z09 = z09;
	}



	/**
	 * Return the value associated with the column: diagnosis_status
	 */
	public java.lang.String getDiagnosisStatus () {
		return diagnosisStatus;
	}

	/**
	 * Set the value related to the column: diagnosis_status
	 * @param diagnosisStatus the diagnosis_status value
	 */
	public void setDiagnosisStatus (java.lang.String diagnosisStatus) {
		this.diagnosisStatus = diagnosisStatus;
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
	 * Return the value associated with the column: add_edit_by_id
	 */
	public jkt.hms.masters.business.Users getAddEditBy () {
		return addEditBy;
	}

	/**
	 * Set the value related to the column: add_edit_by_id
	 * @param addEditBy the add_edit_by_id value
	 */
	public void setAddEditBy (jkt.hms.masters.business.Users addEditBy) {
		this.addEditBy = addEditBy;
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
		if (!(obj instanceof jkt.hms.masters.business.DischargeIcdCode)) return false;
		else {
			jkt.hms.masters.business.DischargeIcdCode dischargeIcdCode = (jkt.hms.masters.business.DischargeIcdCode) obj;
			if (null == this.getId() || null == dischargeIcdCode.getId()) return false;
			else return (this.getId().equals(dischargeIcdCode.getId()));
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
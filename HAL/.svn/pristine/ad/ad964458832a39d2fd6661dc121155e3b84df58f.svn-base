package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the MAS_MEDICAL_EXAM_FAMILY_HIS table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="MAS_MEDICAL_EXAM_FAMILY_HIS"
 */

public abstract class BaseMasMedicalExamFamilyHis  implements Serializable {

	public static String REF = "MasMedicalExamFamilyHis";
	public static String PROP_PATIENT_FAMILY_HISTORY = "PatientFamilyHistory";
	public static String PROP_ID = "Id";
	public static String PROP_HIN = "Hin";
	public static String PROP_MAS_MEDICAL_EXAM_REPORT = "MasMedicalExamReport";


	// constructors
	public BaseMasMedicalExamFamilyHis () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasMedicalExamFamilyHis (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// many to one
	private jkt.hms.masters.business.PatientFamilyHistory patientFamilyHistory;
	private jkt.hms.masters.business.MasMedicalExaminationReportOnEntry masMedicalExamReport;
	private jkt.hms.masters.business.Patient hin;



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
	 * Return the value associated with the column: patient_family_history
	 */
	public jkt.hms.masters.business.PatientFamilyHistory getPatientFamilyHistory () {
		return patientFamilyHistory;
	}

	/**
	 * Set the value related to the column: patient_family_history
	 * @param patientFamilyHistory the patient_family_history value
	 */
	public void setPatientFamilyHistory (jkt.hms.masters.business.PatientFamilyHistory patientFamilyHistory) {
		this.patientFamilyHistory = patientFamilyHistory;
	}



	/**
	 * Return the value associated with the column: mas_medical_exam_report
	 */
	public jkt.hms.masters.business.MasMedicalExaminationReportOnEntry getMasMedicalExamReport () {
		return masMedicalExamReport;
	}

	/**
	 * Set the value related to the column: mas_medical_exam_report
	 * @param masMedicalExamReport the mas_medical_exam_report value
	 */
	public void setMasMedicalExamReport (jkt.hms.masters.business.MasMedicalExaminationReportOnEntry masMedicalExamReport) {
		this.masMedicalExamReport = masMedicalExamReport;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasMedicalExamFamilyHis)) return false;
		else {
			jkt.hms.masters.business.MasMedicalExamFamilyHis masMedicalExamFamilyHis = (jkt.hms.masters.business.MasMedicalExamFamilyHis) obj;
			if (null == this.getId() || null == masMedicalExamFamilyHis.getId()) return false;
			else return (this.getId().equals(masMedicalExamFamilyHis.getId()));
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
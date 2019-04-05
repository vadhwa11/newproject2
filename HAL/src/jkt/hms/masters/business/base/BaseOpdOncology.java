package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the opd_oncology table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="opd_oncology"
 */

public abstract class BaseOpdOncology implements Serializable {

	public static String REF = "OpdOncology";
	public static String PROP_STATUS = "Status";
	public static String PROP_OPD_DATE = "OpdDate";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_RT = "Rt";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_STAGE_B = "StageB";
	public static String PROP_SURGERY_ONCO = "SurgeryOnco";
	public static String PROP_OPD_TIME = "OpdTime";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_STAGE_NOR = "StageNor";
	public static String PROP_HIN = "Hin";
	public static String PROP_MEDICAL_ONCO = "MedicalOnco";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_VISIT = "Visit";
	public static String PROP_STAGE_A = "StageA";
	public static String PROP_STAGE_T = "StageT";
	public static String PROP_STAGE_M = "StageM";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_STAGE_N = "StageN";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_ID = "Id";

	// constructors
	public BaseOpdOncology() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdOncology(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String stageT;
	private java.lang.String stageN;
	private java.lang.String stageM;
	private java.lang.String stageNor;
	private java.lang.String stageA;
	private java.lang.String stageB;
	private java.lang.String medicalOnco;
	private java.lang.String surgeryOnco;
	private java.lang.String rt;
	private java.lang.String remarks;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.util.Date opdDate;
	private java.lang.String opdTime;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.Patient hin;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="opd_oncology_id"
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
	 * Return the value associated with the column: stage_t
	 */
	public java.lang.String getStageT() {
		return stageT;
	}

	/**
	 * Set the value related to the column: stage_t
	 * 
	 * @param stageT
	 *            the stage_t value
	 */
	public void setStageT(java.lang.String stageT) {
		this.stageT = stageT;
	}

	/**
	 * Return the value associated with the column: stage_n
	 */
	public java.lang.String getStageN() {
		return stageN;
	}

	/**
	 * Set the value related to the column: stage_n
	 * 
	 * @param stageN
	 *            the stage_n value
	 */
	public void setStageN(java.lang.String stageN) {
		this.stageN = stageN;
	}

	/**
	 * Return the value associated with the column: stage_m
	 */
	public java.lang.String getStageM() {
		return stageM;
	}

	/**
	 * Set the value related to the column: stage_m
	 * 
	 * @param stageM
	 *            the stage_m value
	 */
	public void setStageM(java.lang.String stageM) {
		this.stageM = stageM;
	}

	/**
	 * Return the value associated with the column: stage_nor
	 */
	public java.lang.String getStageNor() {
		return stageNor;
	}

	/**
	 * Set the value related to the column: stage_nor
	 * 
	 * @param stageNor
	 *            the stage_nor value
	 */
	public void setStageNor(java.lang.String stageNor) {
		this.stageNor = stageNor;
	}

	/**
	 * Return the value associated with the column: stage_a
	 */
	public java.lang.String getStageA() {
		return stageA;
	}

	/**
	 * Set the value related to the column: stage_a
	 * 
	 * @param stageA
	 *            the stage_a value
	 */
	public void setStageA(java.lang.String stageA) {
		this.stageA = stageA;
	}

	/**
	 * Return the value associated with the column: stage_b
	 */
	public java.lang.String getStageB() {
		return stageB;
	}

	/**
	 * Set the value related to the column: stage_b
	 * 
	 * @param stageB
	 *            the stage_b value
	 */
	public void setStageB(java.lang.String stageB) {
		this.stageB = stageB;
	}

	/**
	 * Return the value associated with the column: medical_onco
	 */
	public java.lang.String getMedicalOnco() {
		return medicalOnco;
	}

	/**
	 * Set the value related to the column: medical_onco
	 * 
	 * @param medicalOnco
	 *            the medical_onco value
	 */
	public void setMedicalOnco(java.lang.String medicalOnco) {
		this.medicalOnco = medicalOnco;
	}

	/**
	 * Return the value associated with the column: surgery_onco
	 */
	public java.lang.String getSurgeryOnco() {
		return surgeryOnco;
	}

	/**
	 * Set the value related to the column: surgery_onco
	 * 
	 * @param surgeryOnco
	 *            the surgery_onco value
	 */
	public void setSurgeryOnco(java.lang.String surgeryOnco) {
		this.surgeryOnco = surgeryOnco;
	}

	/**
	 * Return the value associated with the column: rt
	 */
	public java.lang.String getRt() {
		return rt;
	}

	/**
	 * Set the value related to the column: rt
	 * 
	 * @param rt
	 *            the rt value
	 */
	public void setRt(java.lang.String rt) {
		this.rt = rt;
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
	 * Return the value associated with the column: opd_date
	 */
	public java.util.Date getOpdDate() {
		return opdDate;
	}

	/**
	 * Set the value related to the column: opd_date
	 * 
	 * @param opdDate
	 *            the opd_date value
	 */
	public void setOpdDate(java.util.Date opdDate) {
		this.opdDate = opdDate;
	}

	/**
	 * Return the value associated with the column: opd_time
	 */
	public java.lang.String getOpdTime() {
		return opdTime;
	}

	/**
	 * Set the value related to the column: opd_time
	 * 
	 * @param opdTime
	 *            the opd_time value
	 */
	public void setOpdTime(java.lang.String opdTime) {
		this.opdTime = opdTime;
	}

	/**
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital() {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * 
	 * @param hospital
	 *            the hospital_id value
	 */
	public void setHospital(jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
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
	 * Return the value associated with the column: visit_id
	 */
	public jkt.hms.masters.business.Visit getVisit() {
		return visit;
	}

	/**
	 * Set the value related to the column: visit_id
	 * 
	 * @param visit
	 *            the visit_id value
	 */
	public void setVisit(jkt.hms.masters.business.Visit visit) {
		this.visit = visit;
	}

	/**
	 * Return the value associated with the column: hin_id
	 */
	public jkt.hms.masters.business.Patient getHin() {
		return hin;
	}

	/**
	 * Set the value related to the column: hin_id
	 * 
	 * @param hin
	 *            the hin_id value
	 */
	public void setHin(jkt.hms.masters.business.Patient hin) {
		this.hin = hin;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.OpdOncology))
			return false;
		else {
			jkt.hms.masters.business.OpdOncology opdOncology = (jkt.hms.masters.business.OpdOncology) obj;
			if (null == this.getId() || null == opdOncology.getId())
				return false;
			else
				return (this.getId().equals(opdOncology.getId()));
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
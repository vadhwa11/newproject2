package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * opd_oncosurgery_case_sheet table. Do not modify this class because it will be
 * overwritten if the configuration file related to this class is modified.
 * 
 * @hibernate.class table="opd_oncosurgery_case_sheet"
 */

public abstract class BaseOpdOncosurgeryCaseSheet implements Serializable {

	public static String REF = "OpdOncosurgeryCaseSheet";
	public static String PROP_STATUS = "Status";
	public static String PROP_OPERATION_DATE_PROCEDURE = "OperationDateProcedure";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_OTHERS = "Others";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_CITY_SCAN = "CityScan";
	public static String PROP_HPE = "Hpe";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_TUMOUR = "Tumour";
	public static String PROP_HIN = "Hin";
	public static String PROP_OPERATION_FINDINGS_OTHERS = "OperationFindingsOthers";
	public static String PROP_BIOPSY_NO = "BiopsyNo";
	public static String PROP_VISIT = "Visit";
	public static String PROP_FANC_NO = "FancNo";
	public static String PROP_CLINICAL_DIAGNOSIS = "ClinicalDiagnosis";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_METS = "Mets";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LX = "Lx";
	public static String PROP_ID = "Id";

	// constructors
	public BaseOpdOncosurgeryCaseSheet() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdOncosurgeryCaseSheet(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String fancNo;
	private java.lang.String cityScan;
	private java.lang.String others;
	private java.lang.String biopsyNo;
	private java.lang.String clinicalDiagnosis;
	private java.lang.String tumour;
	private java.lang.String lx;
	private java.lang.String mets;
	private java.lang.String operationFindingsOthers;
	private java.lang.String operationDateProcedure;
	private java.lang.String hpe;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.Patient hin;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native"
	 *               column="opd_oncosurgery_case_sheet_id"
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
	 * Return the value associated with the column: fanc_no
	 */
	public java.lang.String getFancNo() {
		return fancNo;
	}

	/**
	 * Set the value related to the column: fanc_no
	 * 
	 * @param fancNo
	 *            the fanc_no value
	 */
	public void setFancNo(java.lang.String fancNo) {
		this.fancNo = fancNo;
	}

	/**
	 * Return the value associated with the column: city_scan
	 */
	public java.lang.String getCityScan() {
		return cityScan;
	}

	/**
	 * Set the value related to the column: city_scan
	 * 
	 * @param cityScan
	 *            the city_scan value
	 */
	public void setCityScan(java.lang.String cityScan) {
		this.cityScan = cityScan;
	}

	/**
	 * Return the value associated with the column: others
	 */
	public java.lang.String getOthers() {
		return others;
	}

	/**
	 * Set the value related to the column: others
	 * 
	 * @param others
	 *            the others value
	 */
	public void setOthers(java.lang.String others) {
		this.others = others;
	}

	/**
	 * Return the value associated with the column: biopsy_no
	 */
	public java.lang.String getBiopsyNo() {
		return biopsyNo;
	}

	/**
	 * Set the value related to the column: biopsy_no
	 * 
	 * @param biopsyNo
	 *            the biopsy_no value
	 */
	public void setBiopsyNo(java.lang.String biopsyNo) {
		this.biopsyNo = biopsyNo;
	}

	/**
	 * Return the value associated with the column: clinical_diagnosis
	 */
	public java.lang.String getClinicalDiagnosis() {
		return clinicalDiagnosis;
	}

	/**
	 * Set the value related to the column: clinical_diagnosis
	 * 
	 * @param clinicalDiagnosis
	 *            the clinical_diagnosis value
	 */
	public void setClinicalDiagnosis(java.lang.String clinicalDiagnosis) {
		this.clinicalDiagnosis = clinicalDiagnosis;
	}

	/**
	 * Return the value associated with the column: tumour
	 */
	public java.lang.String getTumour() {
		return tumour;
	}

	/**
	 * Set the value related to the column: tumour
	 * 
	 * @param tumour
	 *            the tumour value
	 */
	public void setTumour(java.lang.String tumour) {
		this.tumour = tumour;
	}

	/**
	 * Return the value associated with the column: lx
	 */
	public java.lang.String getLx() {
		return lx;
	}

	/**
	 * Set the value related to the column: lx
	 * 
	 * @param lx
	 *            the lx value
	 */
	public void setLx(java.lang.String lx) {
		this.lx = lx;
	}

	/**
	 * Return the value associated with the column: mets
	 */
	public java.lang.String getMets() {
		return mets;
	}

	/**
	 * Set the value related to the column: mets
	 * 
	 * @param mets
	 *            the mets value
	 */
	public void setMets(java.lang.String mets) {
		this.mets = mets;
	}

	/**
	 * Return the value associated with the column: operation_findings_others
	 */
	public java.lang.String getOperationFindingsOthers() {
		return operationFindingsOthers;
	}

	/**
	 * Set the value related to the column: operation_findings_others
	 * 
	 * @param operationFindingsOthers
	 *            the operation_findings_others value
	 */
	public void setOperationFindingsOthers(
			java.lang.String operationFindingsOthers) {
		this.operationFindingsOthers = operationFindingsOthers;
	}

	/**
	 * Return the value associated with the column: operation_date_Procedure
	 */
	public java.lang.String getOperationDateProcedure() {
		return operationDateProcedure;
	}

	/**
	 * Set the value related to the column: operation_date_Procedure
	 * 
	 * @param operationDateProcedure
	 *            the operation_date_Procedure value
	 */
	public void setOperationDateProcedure(
			java.lang.String operationDateProcedure) {
		this.operationDateProcedure = operationDateProcedure;
	}

	/**
	 * Return the value associated with the column: hpe
	 */
	public java.lang.String getHpe() {
		return hpe;
	}

	/**
	 * Set the value related to the column: hpe
	 * 
	 * @param hpe
	 *            the hpe value
	 */
	public void setHpe(java.lang.String hpe) {
		this.hpe = hpe;
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
		if (!(obj instanceof jkt.hms.masters.business.OpdOncosurgeryCaseSheet))
			return false;
		else {
			jkt.hms.masters.business.OpdOncosurgeryCaseSheet opdOncosurgeryCaseSheet = (jkt.hms.masters.business.OpdOncosurgeryCaseSheet) obj;
			if (null == this.getId() || null == opdOncosurgeryCaseSheet.getId())
				return false;
			else
				return (this.getId().equals(opdOncosurgeryCaseSheet.getId()));
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
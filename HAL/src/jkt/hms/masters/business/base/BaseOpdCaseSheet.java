package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the opd_case_sheet table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="opd_case_sheet"
 */

public abstract class BaseOpdCaseSheet implements Serializable {

	public static String REF = "OpdCaseSheet";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_HEIGHT_IN_CM_FATHER = "HeightInCmFather";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DOB = "Dob";
	public static String PROP_WT = "Wt";
	public static String PROP_BMI = "Bmi";
	public static String PROP_VISIT = "Visit";
	public static String PROP_OFC = "Ofc";
	public static String PROP_HEIGHT_IN_CM_CHILD = "HeightInCmChild";
	public static String PROP_HT = "Ht";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_CLINICAL_NOTE = "ClinicalNote";
	public static String PROP_HEIGHT_IN_CM_MOTHER = "HeightInCmMother";
	public static String PROP_TH_PERCENTILE = "ThPercentile";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_RR = "Rr";
	public static String PROP_HIN = "Hin";
	public static String PROP_AGE = "Age";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_REFERED_BY = "ReferedBy";
	public static String PROP_RD_PERCENTILE = "RdPercentile";
	public static String PROP_ID = "Id";
	public static String PROP_HC = "Hc";

	// constructors
	public BaseOpdCaseSheet() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdCaseSheet(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String clinicalNote;
	private java.util.Date dob;
	private java.lang.Float heightInCmFather;
	private java.lang.Float heightInCmMother;
	private java.lang.Float heightInCmChild;
	private java.lang.String age;
	private java.lang.Float rdPercentile;
	private java.lang.Float thPercentile;
	private java.lang.String remarks;
	private java.lang.Integer lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;
	private java.lang.Integer ht;
	private java.lang.Integer wt;
	private java.lang.Integer hc;
	private java.lang.Float bmi;
	private java.lang.Float ofc;
	private java.lang.Float rr;

	// many to one
	private jkt.hms.masters.business.MasEmployee referedBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.Patient hin;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="opd_case_sheet_id"
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
	 * Return the value associated with the column: clinical_note
	 */
	public java.lang.String getClinicalNote() {
		return clinicalNote;
	}

	/**
	 * Set the value related to the column: clinical_note
	 * 
	 * @param clinicalNote
	 *            the clinical_note value
	 */
	public void setClinicalNote(java.lang.String clinicalNote) {
		this.clinicalNote = clinicalNote;
	}

	/**
	 * Return the value associated with the column: dob
	 */
	public java.util.Date getDob() {
		return dob;
	}

	/**
	 * Set the value related to the column: dob
	 * 
	 * @param dob
	 *            the dob value
	 */
	public void setDob(java.util.Date dob) {
		this.dob = dob;
	}

	/**
	 * Return the value associated with the column: height_in_cm_father
	 */
	public java.lang.Float getHeightInCmFather() {
		return heightInCmFather;
	}

	/**
	 * Set the value related to the column: height_in_cm_father
	 * 
	 * @param heightInCmFather
	 *            the height_in_cm_father value
	 */
	public void setHeightInCmFather(java.lang.Float heightInCmFather) {
		this.heightInCmFather = heightInCmFather;
	}

	/**
	 * Return the value associated with the column: height_in_cm_mother
	 */
	public java.lang.Float getHeightInCmMother() {
		return heightInCmMother;
	}

	/**
	 * Set the value related to the column: height_in_cm_mother
	 * 
	 * @param heightInCmMother
	 *            the height_in_cm_mother value
	 */
	public void setHeightInCmMother(java.lang.Float heightInCmMother) {
		this.heightInCmMother = heightInCmMother;
	}

	/**
	 * Return the value associated with the column: height_in_cm_child
	 */
	public java.lang.Float getHeightInCmChild() {
		return heightInCmChild;
	}

	/**
	 * Set the value related to the column: height_in_cm_child
	 * 
	 * @param heightInCmChild
	 *            the height_in_cm_child value
	 */
	public void setHeightInCmChild(java.lang.Float heightInCmChild) {
		this.heightInCmChild = heightInCmChild;
	}

	/**
	 * Return the value associated with the column: age
	 */
	public java.lang.String getAge() {
		return age;
	}

	/**
	 * Set the value related to the column: age
	 * 
	 * @param age
	 *            the age value
	 */
	public void setAge(java.lang.String age) {
		this.age = age;
	}

	/**
	 * Return the value associated with the column: rd_percentile
	 */
	public java.lang.Float getRdPercentile() {
		return rdPercentile;
	}

	/**
	 * Set the value related to the column: rd_percentile
	 * 
	 * @param rdPercentile
	 *            the rd_percentile value
	 */
	public void setRdPercentile(java.lang.Float rdPercentile) {
		this.rdPercentile = rdPercentile;
	}

	/**
	 * Return the value associated with the column: th_percentile
	 */
	public java.lang.Float getThPercentile() {
		return thPercentile;
	}

	/**
	 * Set the value related to the column: th_percentile
	 * 
	 * @param thPercentile
	 *            the th_percentile value
	 */
	public void setThPercentile(java.lang.Float thPercentile) {
		this.thPercentile = thPercentile;
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
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.Integer getLastChgBy() {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * 
	 * @param lastChgBy
	 *            the last_chg_by value
	 */
	public void setLastChgBy(java.lang.Integer lastChgBy) {
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
	 * Return the value associated with the column: ht
	 */
	public java.lang.Integer getHt() {
		return ht;
	}

	/**
	 * Set the value related to the column: ht
	 * 
	 * @param ht
	 *            the ht value
	 */
	public void setHt(java.lang.Integer ht) {
		this.ht = ht;
	}

	/**
	 * Return the value associated with the column: wt
	 */
	public java.lang.Integer getWt() {
		return wt;
	}

	/**
	 * Set the value related to the column: wt
	 * 
	 * @param wt
	 *            the wt value
	 */
	public void setWt(java.lang.Integer wt) {
		this.wt = wt;
	}

	/**
	 * Return the value associated with the column: hc
	 */
	public java.lang.Integer getHc() {
		return hc;
	}

	/**
	 * Set the value related to the column: hc
	 * 
	 * @param hc
	 *            the hc value
	 */
	public void setHc(java.lang.Integer hc) {
		this.hc = hc;
	}

	/**
	 * Return the value associated with the column: bmi
	 */
	public java.lang.Float getBmi() {
		return bmi;
	}

	/**
	 * Set the value related to the column: bmi
	 * 
	 * @param bmi
	 *            the bmi value
	 */
	public void setBmi(java.lang.Float bmi) {
		this.bmi = bmi;
	}

	/**
	 * Return the value associated with the column: ofc
	 */
	public java.lang.Float getOfc() {
		return ofc;
	}

	/**
	 * Set the value related to the column: ofc
	 * 
	 * @param ofc
	 *            the ofc value
	 */
	public void setOfc(java.lang.Float ofc) {
		this.ofc = ofc;
	}

	/**
	 * Return the value associated with the column: rr
	 */
	public java.lang.Float getRr() {
		return rr;
	}

	/**
	 * Set the value related to the column: rr
	 * 
	 * @param rr
	 *            the rr value
	 */
	public void setRr(java.lang.Float rr) {
		this.rr = rr;
	}

	/**
	 * Return the value associated with the column: refered_by
	 */
	public jkt.hms.masters.business.MasEmployee getReferedBy() {
		return referedBy;
	}

	/**
	 * Set the value related to the column: refered_by
	 * 
	 * @param referedBy
	 *            the refered_by value
	 */
	public void setReferedBy(jkt.hms.masters.business.MasEmployee referedBy) {
		this.referedBy = referedBy;
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
		if (!(obj instanceof jkt.hms.masters.business.OpdCaseSheet))
			return false;
		else {
			jkt.hms.masters.business.OpdCaseSheet opdCaseSheet = (jkt.hms.masters.business.OpdCaseSheet) obj;
			if (null == this.getId() || null == opdCaseSheet.getId())
				return false;
			else
				return (this.getId().equals(opdCaseSheet.getId()));
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
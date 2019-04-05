package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_gastro_enterology_endoscopy table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_gastro_enterology_endoscopy"
 */

public abstract class BaseOpdGastroEnterologyEndoscopy  implements Serializable {

	public static String REF = "OpdGastroEnterologyEndoscopy";
	public static String PROP_ESOPHAGUS = "Esophagus";
	public static String PROP_IMPRESSION = "Impression";
	public static String PROP_FINAL_DIAGNOSIS = "FinalDiagnosis";
	public static String PROP_DUODENUM = "Duodenum";
	public static String PROP_REPORT_NO = "ReportNo";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_BIOPSY = "Biopsy";
	public static String PROP_VISIT = "Visit";
	public static String PROP_GASTRIC_ANTUM_FOR_HPYLORI = "GastricAntumForHpylori";
	public static String PROP_STATUS = "Status";
	public static String PROP_OTHERS_REMARKS = "OthersRemarks";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_REPORT_DATE = "ReportDate";
	public static String PROP_REFERRED_BY = "ReferredBy";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_HIN = "Hin";
	public static String PROP_STOMACH = "Stomach";


	// constructors
	public BaseOpdGastroEnterologyEndoscopy () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdGastroEnterologyEndoscopy (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date reportDate;
	private java.lang.String esophagus;
	private java.lang.String stomach;
	private java.lang.String duodenum;
	private java.lang.String biopsy;
	private java.lang.String gastricAntumForHpylori;
	private java.lang.String othersRemarks;
	private java.lang.String impression;
	private java.lang.String finalDiagnosis;
	private java.lang.Integer lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;
	private java.lang.String reportNo;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.MasEmployee referredBy;
	private jkt.hms.masters.business.Patient hin;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="opd_gastro_id"
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
	 * Return the value associated with the column: report_date
	 */
	public java.util.Date getReportDate () {
		return reportDate;
	}

	/**
	 * Set the value related to the column: report_date
	 * @param reportDate the report_date value
	 */
	public void setReportDate (java.util.Date reportDate) {
		this.reportDate = reportDate;
	}



	/**
	 * Return the value associated with the column: esophagus
	 */
	public java.lang.String getEsophagus () {
		return esophagus;
	}

	/**
	 * Set the value related to the column: esophagus
	 * @param esophagus the esophagus value
	 */
	public void setEsophagus (java.lang.String esophagus) {
		this.esophagus = esophagus;
	}



	/**
	 * Return the value associated with the column: stomach
	 */
	public java.lang.String getStomach () {
		return stomach;
	}

	/**
	 * Set the value related to the column: stomach
	 * @param stomach the stomach value
	 */
	public void setStomach (java.lang.String stomach) {
		this.stomach = stomach;
	}



	/**
	 * Return the value associated with the column: duodenum
	 */
	public java.lang.String getDuodenum () {
		return duodenum;
	}

	/**
	 * Set the value related to the column: duodenum
	 * @param duodenum the duodenum value
	 */
	public void setDuodenum (java.lang.String duodenum) {
		this.duodenum = duodenum;
	}



	/**
	 * Return the value associated with the column: biopsy
	 */
	public java.lang.String getBiopsy () {
		return biopsy;
	}

	/**
	 * Set the value related to the column: biopsy
	 * @param biopsy the biopsy value
	 */
	public void setBiopsy (java.lang.String biopsy) {
		this.biopsy = biopsy;
	}



	/**
	 * Return the value associated with the column: gastric_antum_for_HPylori
	 */
	public java.lang.String getGastricAntumForHpylori () {
		return gastricAntumForHpylori;
	}

	/**
	 * Set the value related to the column: gastric_antum_for_HPylori
	 * @param gastricAntumForHpylori the gastric_antum_for_HPylori value
	 */
	public void setGastricAntumForHpylori (java.lang.String gastricAntumForHpylori) {
		this.gastricAntumForHpylori = gastricAntumForHpylori;
	}



	/**
	 * Return the value associated with the column: others_remarks
	 */
	public java.lang.String getOthersRemarks () {
		return othersRemarks;
	}

	/**
	 * Set the value related to the column: others_remarks
	 * @param othersRemarks the others_remarks value
	 */
	public void setOthersRemarks (java.lang.String othersRemarks) {
		this.othersRemarks = othersRemarks;
	}



	/**
	 * Return the value associated with the column: impression
	 */
	public java.lang.String getImpression () {
		return impression;
	}

	/**
	 * Set the value related to the column: impression
	 * @param impression the impression value
	 */
	public void setImpression (java.lang.String impression) {
		this.impression = impression;
	}



	/**
	 * Return the value associated with the column: final_diagnosis
	 */
	public java.lang.String getFinalDiagnosis () {
		return finalDiagnosis;
	}

	/**
	 * Set the value related to the column: final_diagnosis
	 * @param finalDiagnosis the final_diagnosis value
	 */
	public void setFinalDiagnosis (java.lang.String finalDiagnosis) {
		this.finalDiagnosis = finalDiagnosis;
	}



	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.Integer getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (java.lang.Integer lastChgBy) {
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
	 * Return the value associated with the column: reportNo
	 */
	public java.lang.String getReportNo () {
		return reportNo;
	}

	/**
	 * Set the value related to the column: reportNo
	 * @param reportNo the reportNo value
	 */
	public void setReportNo (java.lang.String reportNo) {
		this.reportNo = reportNo;
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
	 * Return the value associated with the column: referred_by
	 */
	public jkt.hms.masters.business.MasEmployee getReferredBy () {
		return referredBy;
	}

	/**
	 * Set the value related to the column: referred_by
	 * @param referredBy the referred_by value
	 */
	public void setReferredBy (jkt.hms.masters.business.MasEmployee referredBy) {
		this.referredBy = referredBy;
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
		if (!(obj instanceof jkt.hms.masters.business.OpdGastroEnterologyEndoscopy)) return false;
		else {
			jkt.hms.masters.business.OpdGastroEnterologyEndoscopy opdGastroEnterologyEndoscopy = (jkt.hms.masters.business.OpdGastroEnterologyEndoscopy) obj;
			if (null == this.getId() || null == opdGastroEnterologyEndoscopy.getId()) return false;
			else return (this.getId().equals(opdGastroEnterologyEndoscopy.getId()));
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
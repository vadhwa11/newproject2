package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the opd_gravidagram_htn
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="opd_gravidagram_htn"
 */

public abstract class BaseOpdGravidagramHtn implements Serializable {

	public static String REF = "OpdGravidagramHtn";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_GRAVIDAGRAM_HTN_DATE = "GravidagramHtnDate";
	public static String PROP_ABDO_GIRTH = "AbdoGirth";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_FETUS_FHS = "FetusFhs";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_HAEMAT_BIOCHEM_INVESTIGATIONS = "HaematBiochemInvestigations";
	public static String PROP_HIN = "Hin";
	public static String PROP_USG_AFI = "UsgAfi";
	public static String PROP_WT_KG = "WtKg";
	public static String PROP_VISIT = "Visit";
	public static String PROP_BP_AM = "BpAm";
	public static String PROP_FUNDAL_HT = "FundalHt";
	public static String PROP_POG_WEEKS = "PogWeeks";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_POG_DAYS = "PogDays";
	public static String PROP_U_ALB = "UAlb";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_BP_PM = "BpPm";
	public static String PROP_ID = "Id";
	public static String PROP_FETUS_DFFMC = "FetusDffmc";
	public static String PROP_NST = "Nst";

	// constructors
	public BaseOpdGravidagramHtn() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdGravidagramHtn(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date gravidagramHtnDate;
	private java.lang.String pogWeeks;
	private java.lang.String pogDays;
	private java.lang.String bpAm;
	private java.lang.String bpPm;
	private java.lang.String fetusDffmc;
	private java.lang.String fetusFhs;
	private java.lang.String fundalHt;
	private java.lang.String abdoGirth;
	private java.lang.String wtKg;
	private java.lang.String uAlb;
	private java.lang.String usgAfi;
	private java.lang.String nst;
	private java.lang.String haematBiochemInvestigations;
	private java.lang.Integer lastChgBy;
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
	 * @hibernate.id generator-class="native" column="opd_gravidagram_htn_id"
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
	 * Return the value associated with the column: gravidagram_htn_date
	 */
	public java.util.Date getGravidagramHtnDate() {
		return gravidagramHtnDate;
	}

	/**
	 * Set the value related to the column: gravidagram_htn_date
	 * 
	 * @param gravidagramHtnDate
	 *            the gravidagram_htn_date value
	 */
	public void setGravidagramHtnDate(java.util.Date gravidagramHtnDate) {
		this.gravidagramHtnDate = gravidagramHtnDate;
	}

	/**
	 * Return the value associated with the column: pog_weeks
	 */
	public java.lang.String getPogWeeks() {
		return pogWeeks;
	}

	/**
	 * Set the value related to the column: pog_weeks
	 * 
	 * @param pogWeeks
	 *            the pog_weeks value
	 */
	public void setPogWeeks(java.lang.String pogWeeks) {
		this.pogWeeks = pogWeeks;
	}

	/**
	 * Return the value associated with the column: pog_days
	 */
	public java.lang.String getPogDays() {
		return pogDays;
	}

	/**
	 * Set the value related to the column: pog_days
	 * 
	 * @param pogDays
	 *            the pog_days value
	 */
	public void setPogDays(java.lang.String pogDays) {
		this.pogDays = pogDays;
	}

	/**
	 * Return the value associated with the column: bp_am
	 */
	public java.lang.String getBpAm() {
		return bpAm;
	}

	/**
	 * Set the value related to the column: bp_am
	 * 
	 * @param bpAm
	 *            the bp_am value
	 */
	public void setBpAm(java.lang.String bpAm) {
		this.bpAm = bpAm;
	}

	/**
	 * Return the value associated with the column: bp_pm
	 */
	public java.lang.String getBpPm() {
		return bpPm;
	}

	/**
	 * Set the value related to the column: bp_pm
	 * 
	 * @param bpPm
	 *            the bp_pm value
	 */
	public void setBpPm(java.lang.String bpPm) {
		this.bpPm = bpPm;
	}

	/**
	 * Return the value associated with the column: fetus_dffmc
	 */
	public java.lang.String getFetusDffmc() {
		return fetusDffmc;
	}

	/**
	 * Set the value related to the column: fetus_dffmc
	 * 
	 * @param fetusDffmc
	 *            the fetus_dffmc value
	 */
	public void setFetusDffmc(java.lang.String fetusDffmc) {
		this.fetusDffmc = fetusDffmc;
	}

	/**
	 * Return the value associated with the column: fetus_fhs
	 */
	public java.lang.String getFetusFhs() {
		return fetusFhs;
	}

	/**
	 * Set the value related to the column: fetus_fhs
	 * 
	 * @param fetusFhs
	 *            the fetus_fhs value
	 */
	public void setFetusFhs(java.lang.String fetusFhs) {
		this.fetusFhs = fetusFhs;
	}

	/**
	 * Return the value associated with the column: fundal_ht
	 */
	public java.lang.String getFundalHt() {
		return fundalHt;
	}

	/**
	 * Set the value related to the column: fundal_ht
	 * 
	 * @param fundalHt
	 *            the fundal_ht value
	 */
	public void setFundalHt(java.lang.String fundalHt) {
		this.fundalHt = fundalHt;
	}

	/**
	 * Return the value associated with the column: abdo_girth
	 */
	public java.lang.String getAbdoGirth() {
		return abdoGirth;
	}

	/**
	 * Set the value related to the column: abdo_girth
	 * 
	 * @param abdoGirth
	 *            the abdo_girth value
	 */
	public void setAbdoGirth(java.lang.String abdoGirth) {
		this.abdoGirth = abdoGirth;
	}

	/**
	 * Return the value associated with the column: wt_kg
	 */
	public java.lang.String getWtKg() {
		return wtKg;
	}

	/**
	 * Set the value related to the column: wt_kg
	 * 
	 * @param wtKg
	 *            the wt_kg value
	 */
	public void setWtKg(java.lang.String wtKg) {
		this.wtKg = wtKg;
	}

	/**
	 * Return the value associated with the column: u_alb
	 */
	public java.lang.String getUAlb() {
		return uAlb;
	}

	/**
	 * Set the value related to the column: u_alb
	 * 
	 * @param uAlb
	 *            the u_alb value
	 */
	public void setUAlb(java.lang.String uAlb) {
		this.uAlb = uAlb;
	}

	/**
	 * Return the value associated with the column: usg_afi
	 */
	public java.lang.String getUsgAfi() {
		return usgAfi;
	}

	/**
	 * Set the value related to the column: usg_afi
	 * 
	 * @param usgAfi
	 *            the usg_afi value
	 */
	public void setUsgAfi(java.lang.String usgAfi) {
		this.usgAfi = usgAfi;
	}

	/**
	 * Return the value associated with the column: nst
	 */
	public java.lang.String getNst() {
		return nst;
	}

	/**
	 * Set the value related to the column: nst
	 * 
	 * @param nst
	 *            the nst value
	 */
	public void setNst(java.lang.String nst) {
		this.nst = nst;
	}

	/**
	 * Return the value associated with the column:
	 * haemat_biochem_investigations
	 */
	public java.lang.String getHaematBiochemInvestigations() {
		return haematBiochemInvestigations;
	}

	/**
	 * Set the value related to the column: haemat_biochem_investigations
	 * 
	 * @param haematBiochemInvestigations
	 *            the haemat_biochem_investigations value
	 */
	public void setHaematBiochemInvestigations(
			java.lang.String haematBiochemInvestigations) {
		this.haematBiochemInvestigations = haematBiochemInvestigations;
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
		if (!(obj instanceof jkt.hms.masters.business.OpdGravidagramHtn))
			return false;
		else {
			jkt.hms.masters.business.OpdGravidagramHtn opdGravidagramHtn = (jkt.hms.masters.business.OpdGravidagramHtn) obj;
			if (null == this.getId() || null == opdGravidagramHtn.getId())
				return false;
			else
				return (this.getId().equals(opdGravidagramHtn.getId()));
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
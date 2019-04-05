package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * opd_gravidagram_gestational_diabities_one table. Do not modify this class
 * because it will be overwritten if the configuration file related to this
 * class is modified.
 * 
 * @hibernate.class table="opd_gravidagram_gestational_diabities_one"
 */

public abstract class BaseOpdGravidagramGestationalDiabitiesOne implements
		Serializable {

	public static String REF = "OpdGravidagramGestationalDiabitiesOne";
	public static String PROP_STATUS = "Status";
	public static String PROP_GCT_FASTING = "GctFasting";
	public static String PROP_GCT_REMARKS = "GctRemarks";
	public static String PROP_PARTY = "Party";
	public static String PROP_GCT_VALUE = "GctValue";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_HEIGHT = "Height";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_PRESENT_PREGNANCY = "PresentPregnancy";
	public static String PROP_VISIT = "Visit";
	public static String PROP_BMI = "Bmi";
	public static String PROP_OGTT_DATE = "OgttDate";
	public static String PROP_LMP = "Lmp";
	public static String PROP_OGTT_REMARKS = "OgttRemarks";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_GCT_DATE = "GctDate";
	public static String PROP_OGTT_POG = "OgttPog";
	public static String PROP_OGTT_VALUE = "OgttValue";
	public static String PROP_GCT_POG = "GctPog";
	public static String PROP_GRAVIDAGRAM_GESTATIONAL_DIABITIES_ONE_DATE = "GravidagramGestationalDiabitiesOneDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HIN = "Hin";
	public static String PROP_RISK_FACTORS = "RiskFactors";
	public static String PROP_OGTT_FASTING = "OgttFasting";
	public static String PROP_FAMILY_HO_DM = "FamilyHoDm";
	public static String PROP_WEIGHT = "Weight";
	public static String PROP_PREV_PREGNANCY = "PrevPregnancy";
	public static String PROP_EDD = "Edd";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_PMC = "Pmc";
	public static String PROP_ID = "Id";

	// constructors
	public BaseOpdGravidagramGestationalDiabitiesOne() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdGravidagramGestationalDiabitiesOne(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date gravidagramGestationalDiabitiesOneDate;
	private java.util.Date lmp;
	private java.util.Date edd;
	private java.lang.String party;
	private java.lang.String pmc;
	private java.lang.String riskFactors;
	private java.lang.String prevPregnancy;
	private java.lang.String presentPregnancy;
	private java.util.Date gctDate;
	private java.lang.String gctPog;
	private java.lang.String gctValue;
	private java.lang.String gctFasting;
	private java.lang.String gctRemarks;
	private java.util.Date ogttDate;
	private java.lang.String ogttPog;
	private java.lang.String ogttValue;
	private java.lang.String ogttFasting;
	private java.lang.String ogttRemarks;
	private java.lang.String familyHoDm;
	private java.lang.Integer height;
	private java.lang.Integer weight;
	private java.lang.String bmi;
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
	 * @hibernate.id generator-class="native"
	 *               column="opd_gravidagram_gestational_diabities_one_id"
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
	 * Return the value associated with the column:
	 * gravidagram_gestational_diabities_one_date
	 */
	public java.util.Date getGravidagramGestationalDiabitiesOneDate() {
		return gravidagramGestationalDiabitiesOneDate;
	}

	/**
	 * Set the value related to the column:
	 * gravidagram_gestational_diabities_one_date
	 * 
	 * @param gravidagramGestationalDiabitiesOneDate
	 *            the gravidagram_gestational_diabities_one_date value
	 */
	public void setGravidagramGestationalDiabitiesOneDate(
			java.util.Date gravidagramGestationalDiabitiesOneDate) {
		this.gravidagramGestationalDiabitiesOneDate = gravidagramGestationalDiabitiesOneDate;
	}

	/**
	 * Return the value associated with the column: lmp
	 */
	public java.util.Date getLmp() {
		return lmp;
	}

	/**
	 * Set the value related to the column: lmp
	 * 
	 * @param lmp
	 *            the lmp value
	 */
	public void setLmp(java.util.Date lmp) {
		this.lmp = lmp;
	}

	/**
	 * Return the value associated with the column: edd
	 */
	public java.util.Date getEdd() {
		return edd;
	}

	/**
	 * Set the value related to the column: edd
	 * 
	 * @param edd
	 *            the edd value
	 */
	public void setEdd(java.util.Date edd) {
		this.edd = edd;
	}

	/**
	 * Return the value associated with the column: party
	 */
	public java.lang.String getParty() {
		return party;
	}

	/**
	 * Set the value related to the column: party
	 * 
	 * @param party
	 *            the party value
	 */
	public void setParty(java.lang.String party) {
		this.party = party;
	}

	/**
	 * Return the value associated with the column: pmc
	 */
	public java.lang.String getPmc() {
		return pmc;
	}

	/**
	 * Set the value related to the column: pmc
	 * 
	 * @param pmc
	 *            the pmc value
	 */
	public void setPmc(java.lang.String pmc) {
		this.pmc = pmc;
	}

	/**
	 * Return the value associated with the column: risk_factors
	 */
	public java.lang.String getRiskFactors() {
		return riskFactors;
	}

	/**
	 * Set the value related to the column: risk_factors
	 * 
	 * @param riskFactors
	 *            the risk_factors value
	 */
	public void setRiskFactors(java.lang.String riskFactors) {
		this.riskFactors = riskFactors;
	}

	/**
	 * Return the value associated with the column: prev_pregnancy
	 */
	public java.lang.String getPrevPregnancy() {
		return prevPregnancy;
	}

	/**
	 * Set the value related to the column: prev_pregnancy
	 * 
	 * @param prevPregnancy
	 *            the prev_pregnancy value
	 */
	public void setPrevPregnancy(java.lang.String prevPregnancy) {
		this.prevPregnancy = prevPregnancy;
	}

	/**
	 * Return the value associated with the column: present_pregnancy
	 */
	public java.lang.String getPresentPregnancy() {
		return presentPregnancy;
	}

	/**
	 * Set the value related to the column: present_pregnancy
	 * 
	 * @param presentPregnancy
	 *            the present_pregnancy value
	 */
	public void setPresentPregnancy(java.lang.String presentPregnancy) {
		this.presentPregnancy = presentPregnancy;
	}

	/**
	 * Return the value associated with the column: gct_date
	 */
	public java.util.Date getGctDate() {
		return gctDate;
	}

	/**
	 * Set the value related to the column: gct_date
	 * 
	 * @param gctDate
	 *            the gct_date value
	 */
	public void setGctDate(java.util.Date gctDate) {
		this.gctDate = gctDate;
	}

	/**
	 * Return the value associated with the column: gct_pog
	 */
	public java.lang.String getGctPog() {
		return gctPog;
	}

	/**
	 * Set the value related to the column: gct_pog
	 * 
	 * @param gctPog
	 *            the gct_pog value
	 */
	public void setGctPog(java.lang.String gctPog) {
		this.gctPog = gctPog;
	}

	/**
	 * Return the value associated with the column: gct_value
	 */
	public java.lang.String getGctValue() {
		return gctValue;
	}

	/**
	 * Set the value related to the column: gct_value
	 * 
	 * @param gctValue
	 *            the gct_value value
	 */
	public void setGctValue(java.lang.String gctValue) {
		this.gctValue = gctValue;
	}

	/**
	 * Return the value associated with the column: gct_fasting
	 */
	public java.lang.String getGctFasting() {
		return gctFasting;
	}

	/**
	 * Set the value related to the column: gct_fasting
	 * 
	 * @param gctFasting
	 *            the gct_fasting value
	 */
	public void setGctFasting(java.lang.String gctFasting) {
		this.gctFasting = gctFasting;
	}

	/**
	 * Return the value associated with the column: gct_remarks
	 */
	public java.lang.String getGctRemarks() {
		return gctRemarks;
	}

	/**
	 * Set the value related to the column: gct_remarks
	 * 
	 * @param gctRemarks
	 *            the gct_remarks value
	 */
	public void setGctRemarks(java.lang.String gctRemarks) {
		this.gctRemarks = gctRemarks;
	}

	/**
	 * Return the value associated with the column: ogtt_date
	 */
	public java.util.Date getOgttDate() {
		return ogttDate;
	}

	/**
	 * Set the value related to the column: ogtt_date
	 * 
	 * @param ogttDate
	 *            the ogtt_date value
	 */
	public void setOgttDate(java.util.Date ogttDate) {
		this.ogttDate = ogttDate;
	}

	/**
	 * Return the value associated with the column: ogtt_pog
	 */
	public java.lang.String getOgttPog() {
		return ogttPog;
	}

	/**
	 * Set the value related to the column: ogtt_pog
	 * 
	 * @param ogttPog
	 *            the ogtt_pog value
	 */
	public void setOgttPog(java.lang.String ogttPog) {
		this.ogttPog = ogttPog;
	}

	/**
	 * Return the value associated with the column: ogtt_value
	 */
	public java.lang.String getOgttValue() {
		return ogttValue;
	}

	/**
	 * Set the value related to the column: ogtt_value
	 * 
	 * @param ogttValue
	 *            the ogtt_value value
	 */
	public void setOgttValue(java.lang.String ogttValue) {
		this.ogttValue = ogttValue;
	}

	/**
	 * Return the value associated with the column: ogtt_fasting
	 */
	public java.lang.String getOgttFasting() {
		return ogttFasting;
	}

	/**
	 * Set the value related to the column: ogtt_fasting
	 * 
	 * @param ogttFasting
	 *            the ogtt_fasting value
	 */
	public void setOgttFasting(java.lang.String ogttFasting) {
		this.ogttFasting = ogttFasting;
	}

	/**
	 * Return the value associated with the column: ogtt_remarks
	 */
	public java.lang.String getOgttRemarks() {
		return ogttRemarks;
	}

	/**
	 * Set the value related to the column: ogtt_remarks
	 * 
	 * @param ogttRemarks
	 *            the ogtt_remarks value
	 */
	public void setOgttRemarks(java.lang.String ogttRemarks) {
		this.ogttRemarks = ogttRemarks;
	}

	/**
	 * Return the value associated with the column: family_ho_dm
	 */
	public java.lang.String getFamilyHoDm() {
		return familyHoDm;
	}

	/**
	 * Set the value related to the column: family_ho_dm
	 * 
	 * @param familyHoDm
	 *            the family_ho_dm value
	 */
	public void setFamilyHoDm(java.lang.String familyHoDm) {
		this.familyHoDm = familyHoDm;
	}

	/**
	 * Return the value associated with the column: height
	 */
	public java.lang.Integer getHeight() {
		return height;
	}

	/**
	 * Set the value related to the column: height
	 * 
	 * @param height
	 *            the height value
	 */
	public void setHeight(java.lang.Integer height) {
		this.height = height;
	}

	/**
	 * Return the value associated with the column: weight
	 */
	public java.lang.Integer getWeight() {
		return weight;
	}

	/**
	 * Set the value related to the column: weight
	 * 
	 * @param weight
	 *            the weight value
	 */
	public void setWeight(java.lang.Integer weight) {
		this.weight = weight;
	}

	/**
	 * Return the value associated with the column: bmi
	 */
	public java.lang.String getBmi() {
		return bmi;
	}

	/**
	 * Set the value related to the column: bmi
	 * 
	 * @param bmi
	 *            the bmi value
	 */
	public void setBmi(java.lang.String bmi) {
		this.bmi = bmi;
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
		if (!(obj instanceof jkt.hms.masters.business.OpdGravidagramGestationalDiabitiesOne))
			return false;
		else {
			jkt.hms.masters.business.OpdGravidagramGestationalDiabitiesOne opdGravidagramGestationalDiabitiesOne = (jkt.hms.masters.business.OpdGravidagramGestationalDiabitiesOne) obj;
			if (null == this.getId()
					|| null == opdGravidagramGestationalDiabitiesOne.getId())
				return false;
			else
				return (this.getId()
						.equals(opdGravidagramGestationalDiabitiesOne.getId()));
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
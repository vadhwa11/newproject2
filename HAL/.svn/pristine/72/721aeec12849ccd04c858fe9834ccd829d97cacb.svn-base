package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the opd_gynaecology table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="opd_gynaecology"
 */

public abstract class BaseOpdGynaecology implements Serializable {

	public static String REF = "OpdGynaecology";
	public static String PROP_GALACTORRHOEA = "Galactorrhoea";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_HYPOMENORRHOEA = "Hypomenorrhoea";
	public static String PROP_OTHERS = "Others";
	public static String PROP_ACNE = "Acne";
	public static String PROP_AWARENESS_FERTILE_PERIOD = "AwarenessFertilePeriod";
	public static String PROP_HEIGHT = "Height";
	public static String PROP_FREQUENCY_COITUS_WK = "FrequencyCoitusWk";
	public static String PROP_PRESENT_MC = "PresentMc";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_HISRSUTISM = "Hisrsutism";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_OTHER_SYSTEMS = "OtherSystems";
	public static String PROP_VISIT = "Visit";
	public static String PROP_PIGMENTATION = "Pigmentation";
	public static String PROP_OBESITY = "Obesity";
	public static String PROP_PAST_MEDICAL_HISTORY = "PastMedicalHistory";
	public static String PROP_PRIMARY_INFERTILITY = "PrimaryInfertility";
	public static String PROP_PRURITIS_VULVAE = "PruritisVulvae";
	public static String PROP_PAST_MC = "PastMc";
	public static String PROP_PMP1 = "Pmp1";
	public static String PROP_LEUCORRHOEA = "Leucorrhoea";
	public static String PROP_LMP = "Lmp";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_OLIGOMENORRHOEA = "Oligomenorrhoea";
	public static String PROP_PMP2 = "Pmp2";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_BACKACHE = "Backache";
	public static String PROP_HIN = "Hin";
	public static String PROP_PAST_SURGICAL_HISTORY = "PastSurgicalHistory";
	public static String PROP_SECONDARY_INFERTILITY = "SecondaryInfertility";
	public static String PROP_OBSTETRIC_HISTORY = "ObstetricHistory";
	public static String PROP_WEIGHT = "Weight";
	public static String PROP_MENARCHY = "Menarchy";
	public static String PROP_GYNAECOLOGICAL_EXAMINATION = "GynaecologicalExamination";
	public static String PROP_DYSMENORRHOEA = "Dysmenorrhoea";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_CONCEIVE = "Conceive";
	public static String PROP_FAMILY_HISTORY = "FamilyHistory";
	public static String PROP_HAIR_DISTRIBUTION = "HairDistribution";
	public static String PROP_DYSPAREUNIA = "Dyspareunia";
	public static String PROP_ID = "Id";
	public static String PROP_GALACTORRHOEA_TEXT = "GalactorrhoeaText";
	public static String PROP_BREAST_DEVELOPMENT = "BreastDevelopment";

	// constructors
	public BaseOpdGynaecology() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdGynaecology(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Float menarchy;
	private java.lang.String pastMc;
	private java.lang.String presentMc;
	private java.lang.String lmp;
	private java.lang.String pmp1;
	private java.lang.String pmp2;
	private java.lang.String obstetricHistory;
	private java.lang.String dyspareunia;
	private java.lang.String awarenessFertilePeriod;
	private java.lang.String frequencyCoitusWk;
	private java.lang.Float primaryInfertility;
	private java.lang.Float secondaryInfertility;
	private java.lang.Float hypomenorrhoea;
	private java.lang.Float oligomenorrhoea;
	private java.lang.Float galactorrhoea;
	private java.lang.String conceive;
	private java.lang.String galactorrhoeaText;
	private java.lang.Float hisrsutism;
	private java.lang.String leucorrhoea;
	private java.lang.String pruritisVulvae;
	private java.lang.String backache;
	private java.lang.String dysmenorrhoea;
	private java.lang.String pastMedicalHistory;
	private java.lang.String pastSurgicalHistory;
	private java.lang.String familyHistory;
	private java.lang.Float height;
	private java.lang.Float weight;
	private java.lang.String obesity;
	private java.lang.String acne;
	private java.lang.String hairDistribution;
	private java.lang.String breastDevelopment;
	private java.lang.String pigmentation;
	private java.lang.String others;
	private java.lang.String otherSystems;
	private java.lang.String gynaecologicalExamination;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.Patient hin;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="opd_gynaecology_id"
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
	 * Return the value associated with the column: menarchy
	 */
	public java.lang.Float getMenarchy() {
		return menarchy;
	}

	/**
	 * Set the value related to the column: menarchy
	 * 
	 * @param menarchy
	 *            the menarchy value
	 */
	public void setMenarchy(java.lang.Float menarchy) {
		this.menarchy = menarchy;
	}

	/**
	 * Return the value associated with the column: past_mc
	 */
	public java.lang.String getPastMc() {
		return pastMc;
	}

	/**
	 * Set the value related to the column: past_mc
	 * 
	 * @param pastMc
	 *            the past_mc value
	 */
	public void setPastMc(java.lang.String pastMc) {
		this.pastMc = pastMc;
	}

	/**
	 * Return the value associated with the column: present_mc
	 */
	public java.lang.String getPresentMc() {
		return presentMc;
	}

	/**
	 * Set the value related to the column: present_mc
	 * 
	 * @param presentMc
	 *            the present_mc value
	 */
	public void setPresentMc(java.lang.String presentMc) {
		this.presentMc = presentMc;
	}

	/**
	 * Return the value associated with the column: lmp
	 */
	public java.lang.String getLmp() {
		return lmp;
	}

	/**
	 * Set the value related to the column: lmp
	 * 
	 * @param lmp
	 *            the lmp value
	 */
	public void setLmp(java.lang.String lmp) {
		this.lmp = lmp;
	}

	/**
	 * Return the value associated with the column: pmp1
	 */
	public java.lang.String getPmp1() {
		return pmp1;
	}

	/**
	 * Set the value related to the column: pmp1
	 * 
	 * @param pmp1
	 *            the pmp1 value
	 */
	public void setPmp1(java.lang.String pmp1) {
		this.pmp1 = pmp1;
	}

	/**
	 * Return the value associated with the column: pmp2
	 */
	public java.lang.String getPmp2() {
		return pmp2;
	}

	/**
	 * Set the value related to the column: pmp2
	 * 
	 * @param pmp2
	 *            the pmp2 value
	 */
	public void setPmp2(java.lang.String pmp2) {
		this.pmp2 = pmp2;
	}

	/**
	 * Return the value associated with the column: obstetric_history
	 */
	public java.lang.String getObstetricHistory() {
		return obstetricHistory;
	}

	/**
	 * Set the value related to the column: obstetric_history
	 * 
	 * @param obstetricHistory
	 *            the obstetric_history value
	 */
	public void setObstetricHistory(java.lang.String obstetricHistory) {
		this.obstetricHistory = obstetricHistory;
	}

	/**
	 * Return the value associated with the column: dyspareunia
	 */
	public java.lang.String getDyspareunia() {
		return dyspareunia;
	}

	/**
	 * Set the value related to the column: dyspareunia
	 * 
	 * @param dyspareunia
	 *            the dyspareunia value
	 */
	public void setDyspareunia(java.lang.String dyspareunia) {
		this.dyspareunia = dyspareunia;
	}

	/**
	 * Return the value associated with the column: awareness_fertile_period
	 */
	public java.lang.String getAwarenessFertilePeriod() {
		return awarenessFertilePeriod;
	}

	/**
	 * Set the value related to the column: awareness_fertile_period
	 * 
	 * @param awarenessFertilePeriod
	 *            the awareness_fertile_period value
	 */
	public void setAwarenessFertilePeriod(
			java.lang.String awarenessFertilePeriod) {
		this.awarenessFertilePeriod = awarenessFertilePeriod;
	}

	/**
	 * Return the value associated with the column: frequency_coitus_wk
	 */
	public java.lang.String getFrequencyCoitusWk() {
		return frequencyCoitusWk;
	}

	/**
	 * Set the value related to the column: frequency_coitus_wk
	 * 
	 * @param frequencyCoitusWk
	 *            the frequency_coitus_wk value
	 */
	public void setFrequencyCoitusWk(java.lang.String frequencyCoitusWk) {
		this.frequencyCoitusWk = frequencyCoitusWk;
	}

	/**
	 * Return the value associated with the column: primary_infertility
	 */
	public java.lang.Float getPrimaryInfertility() {
		return primaryInfertility;
	}

	/**
	 * Set the value related to the column: primary_infertility
	 * 
	 * @param primaryInfertility
	 *            the primary_infertility value
	 */
	public void setPrimaryInfertility(java.lang.Float primaryInfertility) {
		this.primaryInfertility = primaryInfertility;
	}

	/**
	 * Return the value associated with the column: secondary_infertility
	 */
	public java.lang.Float getSecondaryInfertility() {
		return secondaryInfertility;
	}

	/**
	 * Set the value related to the column: secondary_infertility
	 * 
	 * @param secondaryInfertility
	 *            the secondary_infertility value
	 */
	public void setSecondaryInfertility(java.lang.Float secondaryInfertility) {
		this.secondaryInfertility = secondaryInfertility;
	}

	/**
	 * Return the value associated with the column: hypomenorrhoea
	 */
	public java.lang.Float getHypomenorrhoea() {
		return hypomenorrhoea;
	}

	/**
	 * Set the value related to the column: hypomenorrhoea
	 * 
	 * @param hypomenorrhoea
	 *            the hypomenorrhoea value
	 */
	public void setHypomenorrhoea(java.lang.Float hypomenorrhoea) {
		this.hypomenorrhoea = hypomenorrhoea;
	}

	/**
	 * Return the value associated with the column: oligomenorrhoea
	 */
	public java.lang.Float getOligomenorrhoea() {
		return oligomenorrhoea;
	}

	/**
	 * Set the value related to the column: oligomenorrhoea
	 * 
	 * @param oligomenorrhoea
	 *            the oligomenorrhoea value
	 */
	public void setOligomenorrhoea(java.lang.Float oligomenorrhoea) {
		this.oligomenorrhoea = oligomenorrhoea;
	}

	/**
	 * Return the value associated with the column: galactorrhoea
	 */
	public java.lang.Float getGalactorrhoea() {
		return galactorrhoea;
	}

	/**
	 * Set the value related to the column: galactorrhoea
	 * 
	 * @param galactorrhoea
	 *            the galactorrhoea value
	 */
	public void setGalactorrhoea(java.lang.Float galactorrhoea) {
		this.galactorrhoea = galactorrhoea;
	}

	/**
	 * Return the value associated with the column: conceive
	 */
	public java.lang.String getConceive() {
		return conceive;
	}

	/**
	 * Set the value related to the column: conceive
	 * 
	 * @param conceive
	 *            the conceive value
	 */
	public void setConceive(java.lang.String conceive) {
		this.conceive = conceive;
	}

	/**
	 * Return the value associated with the column: galactorrhoea_text
	 */
	public java.lang.String getGalactorrhoeaText() {
		return galactorrhoeaText;
	}

	/**
	 * Set the value related to the column: galactorrhoea_text
	 * 
	 * @param galactorrhoeaText
	 *            the galactorrhoea_text value
	 */
	public void setGalactorrhoeaText(java.lang.String galactorrhoeaText) {
		this.galactorrhoeaText = galactorrhoeaText;
	}

	/**
	 * Return the value associated with the column: hisrsutism
	 */
	public java.lang.Float getHisrsutism() {
		return hisrsutism;
	}

	/**
	 * Set the value related to the column: hisrsutism
	 * 
	 * @param hisrsutism
	 *            the hisrsutism value
	 */
	public void setHisrsutism(java.lang.Float hisrsutism) {
		this.hisrsutism = hisrsutism;
	}

	/**
	 * Return the value associated with the column: leucorrhoea
	 */
	public java.lang.String getLeucorrhoea() {
		return leucorrhoea;
	}

	/**
	 * Set the value related to the column: leucorrhoea
	 * 
	 * @param leucorrhoea
	 *            the leucorrhoea value
	 */
	public void setLeucorrhoea(java.lang.String leucorrhoea) {
		this.leucorrhoea = leucorrhoea;
	}

	/**
	 * Return the value associated with the column: pruritis_vulvae
	 */
	public java.lang.String getPruritisVulvae() {
		return pruritisVulvae;
	}

	/**
	 * Set the value related to the column: pruritis_vulvae
	 * 
	 * @param pruritisVulvae
	 *            the pruritis_vulvae value
	 */
	public void setPruritisVulvae(java.lang.String pruritisVulvae) {
		this.pruritisVulvae = pruritisVulvae;
	}

	/**
	 * Return the value associated with the column: Backache
	 */
	public java.lang.String getBackache() {
		return backache;
	}

	/**
	 * Set the value related to the column: Backache
	 * 
	 * @param backache
	 *            the Backache value
	 */
	public void setBackache(java.lang.String backache) {
		this.backache = backache;
	}

	/**
	 * Return the value associated with the column: Dysmenorrhoea
	 */
	public java.lang.String getDysmenorrhoea() {
		return dysmenorrhoea;
	}

	/**
	 * Set the value related to the column: Dysmenorrhoea
	 * 
	 * @param dysmenorrhoea
	 *            the Dysmenorrhoea value
	 */
	public void setDysmenorrhoea(java.lang.String dysmenorrhoea) {
		this.dysmenorrhoea = dysmenorrhoea;
	}

	/**
	 * Return the value associated with the column: past_medical_history
	 */
	public java.lang.String getPastMedicalHistory() {
		return pastMedicalHistory;
	}

	/**
	 * Set the value related to the column: past_medical_history
	 * 
	 * @param pastMedicalHistory
	 *            the past_medical_history value
	 */
	public void setPastMedicalHistory(java.lang.String pastMedicalHistory) {
		this.pastMedicalHistory = pastMedicalHistory;
	}

	/**
	 * Return the value associated with the column: past_surgical_history
	 */
	public java.lang.String getPastSurgicalHistory() {
		return pastSurgicalHistory;
	}

	/**
	 * Set the value related to the column: past_surgical_history
	 * 
	 * @param pastSurgicalHistory
	 *            the past_surgical_history value
	 */
	public void setPastSurgicalHistory(java.lang.String pastSurgicalHistory) {
		this.pastSurgicalHistory = pastSurgicalHistory;
	}

	/**
	 * Return the value associated with the column: family_history
	 */
	public java.lang.String getFamilyHistory() {
		return familyHistory;
	}

	/**
	 * Set the value related to the column: family_history
	 * 
	 * @param familyHistory
	 *            the family_history value
	 */
	public void setFamilyHistory(java.lang.String familyHistory) {
		this.familyHistory = familyHistory;
	}

	/**
	 * Return the value associated with the column: height
	 */
	public java.lang.Float getHeight() {
		return height;
	}

	/**
	 * Set the value related to the column: height
	 * 
	 * @param height
	 *            the height value
	 */
	public void setHeight(java.lang.Float height) {
		this.height = height;
	}

	/**
	 * Return the value associated with the column: weight
	 */
	public java.lang.Float getWeight() {
		return weight;
	}

	/**
	 * Set the value related to the column: weight
	 * 
	 * @param weight
	 *            the weight value
	 */
	public void setWeight(java.lang.Float weight) {
		this.weight = weight;
	}

	/**
	 * Return the value associated with the column: obesity
	 */
	public java.lang.String getObesity() {
		return obesity;
	}

	/**
	 * Set the value related to the column: obesity
	 * 
	 * @param obesity
	 *            the obesity value
	 */
	public void setObesity(java.lang.String obesity) {
		this.obesity = obesity;
	}

	/**
	 * Return the value associated with the column: acne
	 */
	public java.lang.String getAcne() {
		return acne;
	}

	/**
	 * Set the value related to the column: acne
	 * 
	 * @param acne
	 *            the acne value
	 */
	public void setAcne(java.lang.String acne) {
		this.acne = acne;
	}

	/**
	 * Return the value associated with the column: hair_distribution
	 */
	public java.lang.String getHairDistribution() {
		return hairDistribution;
	}

	/**
	 * Set the value related to the column: hair_distribution
	 * 
	 * @param hairDistribution
	 *            the hair_distribution value
	 */
	public void setHairDistribution(java.lang.String hairDistribution) {
		this.hairDistribution = hairDistribution;
	}

	/**
	 * Return the value associated with the column: breast_development
	 */
	public java.lang.String getBreastDevelopment() {
		return breastDevelopment;
	}

	/**
	 * Set the value related to the column: breast_development
	 * 
	 * @param breastDevelopment
	 *            the breast_development value
	 */
	public void setBreastDevelopment(java.lang.String breastDevelopment) {
		this.breastDevelopment = breastDevelopment;
	}

	/**
	 * Return the value associated with the column: pigmentation
	 */
	public java.lang.String getPigmentation() {
		return pigmentation;
	}

	/**
	 * Set the value related to the column: pigmentation
	 * 
	 * @param pigmentation
	 *            the pigmentation value
	 */
	public void setPigmentation(java.lang.String pigmentation) {
		this.pigmentation = pigmentation;
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
	 * Return the value associated with the column: other_systems
	 */
	public java.lang.String getOtherSystems() {
		return otherSystems;
	}

	/**
	 * Set the value related to the column: other_systems
	 * 
	 * @param otherSystems
	 *            the other_systems value
	 */
	public void setOtherSystems(java.lang.String otherSystems) {
		this.otherSystems = otherSystems;
	}

	/**
	 * Return the value associated with the column: gynaecological_examination
	 */
	public java.lang.String getGynaecologicalExamination() {
		return gynaecologicalExamination;
	}

	/**
	 * Set the value related to the column: gynaecological_examination
	 * 
	 * @param gynaecologicalExamination
	 *            the gynaecological_examination value
	 */
	public void setGynaecologicalExamination(
			java.lang.String gynaecologicalExamination) {
		this.gynaecologicalExamination = gynaecologicalExamination;
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
	 * Return the value associated with the column: inpatient_id
	 */
	public jkt.hms.masters.business.Inpatient getInpatient() {
		return inpatient;
	}

	/**
	 * Set the value related to the column: inpatient_id
	 * 
	 * @param inpatient
	 *            the inpatient_id value
	 */
	public void setInpatient(jkt.hms.masters.business.Inpatient inpatient) {
		this.inpatient = inpatient;
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
		if (!(obj instanceof jkt.hms.masters.business.OpdGynaecology))
			return false;
		else {
			jkt.hms.masters.business.OpdGynaecology opdGynaecology = (jkt.hms.masters.business.OpdGynaecology) obj;
			if (null == this.getId() || null == opdGynaecology.getId())
				return false;
			else
				return (this.getId().equals(opdGynaecology.getId()));
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
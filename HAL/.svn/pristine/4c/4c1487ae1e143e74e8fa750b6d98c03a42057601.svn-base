package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the opd_urology table. Do not
 * modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * 
 * @hibernate.class table="opd_urology"
 */

public abstract class BaseOpdUrology implements Serializable {

	public static String REF = "OpdUrology";
	public static String PROP_STATUS = "Status";
	public static String PROP_OVERFLOW_INCONTINENCE = "OverflowIncontinence";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_L_HESITANVY = "LHesitanvy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_CHYLURIA_CHECK = "ChyluriaCheck";
	public static String PROP_L_FREQUENCY = "LFrequency";
	public static String PROP_DYSURIA_PAIN = "DysuriaPain";
	public static String PROP_PREMATUREEJACULATION = "Prematureejaculation";
	public static String PROP_L_URGE_INCON = "LUrgeIncon";
	public static String PROP_VISIT = "Visit";
	public static String PROP_STRESS_INCONTINENCE = "StressIncontinence";
	public static String PROP_L_NOCTURIA = "LNocturia";
	public static String PROP_L_SENSE_COM_EVA = "LSenseComEva";
	public static String PROP_CALCULARIA = "Calcularia";
	public static String PROP_HAE_TOTAL = "HaeTotal";
	public static String PROP_ACUTE_URINARY = "AcuteUrinary";
	public static String PROP_URETERIC_LEFT = "UretericLeft";
	public static String PROP_CALCULARIA_CHECK = "CalculariaCheck";
	public static String PROP_CHYLURIA = "Chyluria";
	public static String PROP_PERINAL_RECTAL = "PerinalRectal";
	public static String PROP_HYPOGASTRIC_PAIN = "HypogastricPain";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_BONE_PAIN = "BonePain";
	public static String PROP_HAEMOSPERMIA = "Haemospermia";
	public static String PROP_ERECTILE_DYSFUNCTION = "ErectileDysfunction";
	public static String PROP_L_INTERMITTENCY = "LIntermittency";
	public static String PROP_URGE_INCONTINENCE = "UrgeIncontinence";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ERECTILE_DYSFUNCTION_CHECK = "ErectileDysfunctionCheck";
	public static String PROP_HIN = "Hin";
	public static String PROP_HAE_TERIMINAL = "HaeTeriminal";
	public static String PROP_ACUTE_URINARY_CHECK = "AcuteUrinaryCheck";
	public static String PROP_ANEJACULATION_EJACULATION = "AnejaculationEjaculation";
	public static String PROP_TOTAL_INCONTINENCE = "TotalIncontinence";
	public static String PROP_L_STRAINING = "LStraining";
	public static String PROP_L_DRIBBLING = "LDribbling";
	public static String PROP_HAE_INITIAL = "HaeInitial";
	public static String PROP_L_URGENCY = "LUrgency";
	public static String PROP_SYMPTOMME = "Symptomme";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_HAE_CLOTS = "HaeClots";
	public static String PROP_URETERIC_RIGHT = "UretericRight";
	public static String PROP_ID = "Id";
	public static String PROP_RETROGRADE_EJACULATION = "RetrogradeEjaculation";

	// constructors
	public BaseOpdUrology() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdUrology(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String symptomme;
	private java.lang.String haeTotal;
	private java.lang.String haeTeriminal;
	private java.lang.String haeInitial;
	private java.lang.String haeClots;
	private java.lang.String uretericLeft;
	private java.lang.String uretericRight;
	private java.lang.String hypogastricPain;
	private java.lang.String bonePain;
	private java.lang.String dysuriaPain;
	private java.lang.String perinalRectal;
	private java.lang.String lFrequency;
	private java.lang.String lHesitanvy;
	private java.lang.String lNocturia;
	private java.lang.String lStraining;
	private java.lang.String lUrgency;
	private java.lang.String lSenseComEva;
	private java.lang.String lUrgeIncon;
	private java.lang.String lIntermittency;
	private java.lang.String lDribbling;
	private java.lang.String calculariaCheck;
	private java.lang.String calcularia;
	private java.lang.String chyluriaCheck;
	private java.lang.String chyluria;
	private java.lang.String erectileDysfunctionCheck;
	private java.lang.String erectileDysfunction;
	private java.lang.String haemospermia;
	private java.lang.String prematureejaculation;
	private java.lang.String retrogradeEjaculation;
	private java.lang.String anejaculationEjaculation;
	private java.lang.String stressIncontinence;
	private java.lang.String urgeIncontinence;
	private java.lang.String totalIncontinence;
	private java.lang.String overflowIncontinence;
	private java.lang.String acuteUrinaryCheck;
	private java.lang.String acuteUrinary;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.Patient hin;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="opd_urology_id"
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
	 * Return the value associated with the column: Symptomme
	 */
	public java.lang.String getSymptomme() {
		return symptomme;
	}

	/**
	 * Set the value related to the column: Symptomme
	 * 
	 * @param symptomme
	 *            the Symptomme value
	 */
	public void setSymptomme(java.lang.String symptomme) {
		this.symptomme = symptomme;
	}

	/**
	 * Return the value associated with the column: hae_total
	 */
	public java.lang.String getHaeTotal() {
		return haeTotal;
	}

	/**
	 * Set the value related to the column: hae_total
	 * 
	 * @param haeTotal
	 *            the hae_total value
	 */
	public void setHaeTotal(java.lang.String haeTotal) {
		this.haeTotal = haeTotal;
	}

	/**
	 * Return the value associated with the column: hae_teriminal
	 */
	public java.lang.String getHaeTeriminal() {
		return haeTeriminal;
	}

	/**
	 * Set the value related to the column: hae_teriminal
	 * 
	 * @param haeTeriminal
	 *            the hae_teriminal value
	 */
	public void setHaeTeriminal(java.lang.String haeTeriminal) {
		this.haeTeriminal = haeTeriminal;
	}

	/**
	 * Return the value associated with the column: hae_initial
	 */
	public java.lang.String getHaeInitial() {
		return haeInitial;
	}

	/**
	 * Set the value related to the column: hae_initial
	 * 
	 * @param haeInitial
	 *            the hae_initial value
	 */
	public void setHaeInitial(java.lang.String haeInitial) {
		this.haeInitial = haeInitial;
	}

	/**
	 * Return the value associated with the column: hae_clots
	 */
	public java.lang.String getHaeClots() {
		return haeClots;
	}

	/**
	 * Set the value related to the column: hae_clots
	 * 
	 * @param haeClots
	 *            the hae_clots value
	 */
	public void setHaeClots(java.lang.String haeClots) {
		this.haeClots = haeClots;
	}

	/**
	 * Return the value associated with the column: ureteric_left
	 */
	public java.lang.String getUretericLeft() {
		return uretericLeft;
	}

	/**
	 * Set the value related to the column: ureteric_left
	 * 
	 * @param uretericLeft
	 *            the ureteric_left value
	 */
	public void setUretericLeft(java.lang.String uretericLeft) {
		this.uretericLeft = uretericLeft;
	}

	/**
	 * Return the value associated with the column: ureteric_right
	 */
	public java.lang.String getUretericRight() {
		return uretericRight;
	}

	/**
	 * Set the value related to the column: ureteric_right
	 * 
	 * @param uretericRight
	 *            the ureteric_right value
	 */
	public void setUretericRight(java.lang.String uretericRight) {
		this.uretericRight = uretericRight;
	}

	/**
	 * Return the value associated with the column: hypogastric_pain
	 */
	public java.lang.String getHypogastricPain() {
		return hypogastricPain;
	}

	/**
	 * Set the value related to the column: hypogastric_pain
	 * 
	 * @param hypogastricPain
	 *            the hypogastric_pain value
	 */
	public void setHypogastricPain(java.lang.String hypogastricPain) {
		this.hypogastricPain = hypogastricPain;
	}

	/**
	 * Return the value associated with the column: bone_pain
	 */
	public java.lang.String getBonePain() {
		return bonePain;
	}

	/**
	 * Set the value related to the column: bone_pain
	 * 
	 * @param bonePain
	 *            the bone_pain value
	 */
	public void setBonePain(java.lang.String bonePain) {
		this.bonePain = bonePain;
	}

	/**
	 * Return the value associated with the column: dysuria_pain
	 */
	public java.lang.String getDysuriaPain() {
		return dysuriaPain;
	}

	/**
	 * Set the value related to the column: dysuria_pain
	 * 
	 * @param dysuriaPain
	 *            the dysuria_pain value
	 */
	public void setDysuriaPain(java.lang.String dysuriaPain) {
		this.dysuriaPain = dysuriaPain;
	}

	/**
	 * Return the value associated with the column: perinal_rectal
	 */
	public java.lang.String getPerinalRectal() {
		return perinalRectal;
	}

	/**
	 * Set the value related to the column: perinal_rectal
	 * 
	 * @param perinalRectal
	 *            the perinal_rectal value
	 */
	public void setPerinalRectal(java.lang.String perinalRectal) {
		this.perinalRectal = perinalRectal;
	}

	/**
	 * Return the value associated with the column: l_frequency
	 */
	public java.lang.String getLFrequency() {
		return lFrequency;
	}

	/**
	 * Set the value related to the column: l_frequency
	 * 
	 * @param lFrequency
	 *            the l_frequency value
	 */
	public void setLFrequency(java.lang.String lFrequency) {
		this.lFrequency = lFrequency;
	}

	/**
	 * Return the value associated with the column: l_hesitanvy
	 */
	public java.lang.String getLHesitanvy() {
		return lHesitanvy;
	}

	/**
	 * Set the value related to the column: l_hesitanvy
	 * 
	 * @param lHesitanvy
	 *            the l_hesitanvy value
	 */
	public void setLHesitanvy(java.lang.String lHesitanvy) {
		this.lHesitanvy = lHesitanvy;
	}

	/**
	 * Return the value associated with the column: l_nocturia
	 */
	public java.lang.String getLNocturia() {
		return lNocturia;
	}

	/**
	 * Set the value related to the column: l_nocturia
	 * 
	 * @param lNocturia
	 *            the l_nocturia value
	 */
	public void setLNocturia(java.lang.String lNocturia) {
		this.lNocturia = lNocturia;
	}

	/**
	 * Return the value associated with the column: l_straining
	 */
	public java.lang.String getLStraining() {
		return lStraining;
	}

	/**
	 * Set the value related to the column: l_straining
	 * 
	 * @param lStraining
	 *            the l_straining value
	 */
	public void setLStraining(java.lang.String lStraining) {
		this.lStraining = lStraining;
	}

	/**
	 * Return the value associated with the column: l_urgency
	 */
	public java.lang.String getLUrgency() {
		return lUrgency;
	}

	/**
	 * Set the value related to the column: l_urgency
	 * 
	 * @param lUrgency
	 *            the l_urgency value
	 */
	public void setLUrgency(java.lang.String lUrgency) {
		this.lUrgency = lUrgency;
	}

	/**
	 * Return the value associated with the column: l_sense_com_eva
	 */
	public java.lang.String getLSenseComEva() {
		return lSenseComEva;
	}

	/**
	 * Set the value related to the column: l_sense_com_eva
	 * 
	 * @param lSenseComEva
	 *            the l_sense_com_eva value
	 */
	public void setLSenseComEva(java.lang.String lSenseComEva) {
		this.lSenseComEva = lSenseComEva;
	}

	/**
	 * Return the value associated with the column: l_urge_incon
	 */
	public java.lang.String getLUrgeIncon() {
		return lUrgeIncon;
	}

	/**
	 * Set the value related to the column: l_urge_incon
	 * 
	 * @param lUrgeIncon
	 *            the l_urge_incon value
	 */
	public void setLUrgeIncon(java.lang.String lUrgeIncon) {
		this.lUrgeIncon = lUrgeIncon;
	}

	/**
	 * Return the value associated with the column: l_intermittency
	 */
	public java.lang.String getLIntermittency() {
		return lIntermittency;
	}

	/**
	 * Set the value related to the column: l_intermittency
	 * 
	 * @param lIntermittency
	 *            the l_intermittency value
	 */
	public void setLIntermittency(java.lang.String lIntermittency) {
		this.lIntermittency = lIntermittency;
	}

	/**
	 * Return the value associated with the column: l_dribbling
	 */
	public java.lang.String getLDribbling() {
		return lDribbling;
	}

	/**
	 * Set the value related to the column: l_dribbling
	 * 
	 * @param lDribbling
	 *            the l_dribbling value
	 */
	public void setLDribbling(java.lang.String lDribbling) {
		this.lDribbling = lDribbling;
	}

	/**
	 * Return the value associated with the column: calcularia_check
	 */
	public java.lang.String getCalculariaCheck() {
		return calculariaCheck;
	}

	/**
	 * Set the value related to the column: calcularia_check
	 * 
	 * @param calculariaCheck
	 *            the calcularia_check value
	 */
	public void setCalculariaCheck(java.lang.String calculariaCheck) {
		this.calculariaCheck = calculariaCheck;
	}

	/**
	 * Return the value associated with the column: calcularia
	 */
	public java.lang.String getCalcularia() {
		return calcularia;
	}

	/**
	 * Set the value related to the column: calcularia
	 * 
	 * @param calcularia
	 *            the calcularia value
	 */
	public void setCalcularia(java.lang.String calcularia) {
		this.calcularia = calcularia;
	}

	/**
	 * Return the value associated with the column: chyluria_check
	 */
	public java.lang.String getChyluriaCheck() {
		return chyluriaCheck;
	}

	/**
	 * Set the value related to the column: chyluria_check
	 * 
	 * @param chyluriaCheck
	 *            the chyluria_check value
	 */
	public void setChyluriaCheck(java.lang.String chyluriaCheck) {
		this.chyluriaCheck = chyluriaCheck;
	}

	/**
	 * Return the value associated with the column: chyluria
	 */
	public java.lang.String getChyluria() {
		return chyluria;
	}

	/**
	 * Set the value related to the column: chyluria
	 * 
	 * @param chyluria
	 *            the chyluria value
	 */
	public void setChyluria(java.lang.String chyluria) {
		this.chyluria = chyluria;
	}

	/**
	 * Return the value associated with the column: erectile_dysfunction_check
	 */
	public java.lang.String getErectileDysfunctionCheck() {
		return erectileDysfunctionCheck;
	}

	/**
	 * Set the value related to the column: erectile_dysfunction_check
	 * 
	 * @param erectileDysfunctionCheck
	 *            the erectile_dysfunction_check value
	 */
	public void setErectileDysfunctionCheck(
			java.lang.String erectileDysfunctionCheck) {
		this.erectileDysfunctionCheck = erectileDysfunctionCheck;
	}

	/**
	 * Return the value associated with the column: erectile_dysfunction
	 */
	public java.lang.String getErectileDysfunction() {
		return erectileDysfunction;
	}

	/**
	 * Set the value related to the column: erectile_dysfunction
	 * 
	 * @param erectileDysfunction
	 *            the erectile_dysfunction value
	 */
	public void setErectileDysfunction(java.lang.String erectileDysfunction) {
		this.erectileDysfunction = erectileDysfunction;
	}

	/**
	 * Return the value associated with the column: haemospermia
	 */
	public java.lang.String getHaemospermia() {
		return haemospermia;
	}

	/**
	 * Set the value related to the column: haemospermia
	 * 
	 * @param haemospermia
	 *            the haemospermia value
	 */
	public void setHaemospermia(java.lang.String haemospermia) {
		this.haemospermia = haemospermia;
	}

	/**
	 * Return the value associated with the column: prematureejaculation
	 */
	public java.lang.String getPrematureejaculation() {
		return prematureejaculation;
	}

	/**
	 * Set the value related to the column: prematureejaculation
	 * 
	 * @param prematureejaculation
	 *            the prematureejaculation value
	 */
	public void setPrematureejaculation(java.lang.String prematureejaculation) {
		this.prematureejaculation = prematureejaculation;
	}

	/**
	 * Return the value associated with the column: retrograde_ejaculation
	 */
	public java.lang.String getRetrogradeEjaculation() {
		return retrogradeEjaculation;
	}

	/**
	 * Set the value related to the column: retrograde_ejaculation
	 * 
	 * @param retrogradeEjaculation
	 *            the retrograde_ejaculation value
	 */
	public void setRetrogradeEjaculation(java.lang.String retrogradeEjaculation) {
		this.retrogradeEjaculation = retrogradeEjaculation;
	}

	/**
	 * Return the value associated with the column: anejaculation_ejaculation
	 */
	public java.lang.String getAnejaculationEjaculation() {
		return anejaculationEjaculation;
	}

	/**
	 * Set the value related to the column: anejaculation_ejaculation
	 * 
	 * @param anejaculationEjaculation
	 *            the anejaculation_ejaculation value
	 */
	public void setAnejaculationEjaculation(
			java.lang.String anejaculationEjaculation) {
		this.anejaculationEjaculation = anejaculationEjaculation;
	}

	/**
	 * Return the value associated with the column: stress_incontinence
	 */
	public java.lang.String getStressIncontinence() {
		return stressIncontinence;
	}

	/**
	 * Set the value related to the column: stress_incontinence
	 * 
	 * @param stressIncontinence
	 *            the stress_incontinence value
	 */
	public void setStressIncontinence(java.lang.String stressIncontinence) {
		this.stressIncontinence = stressIncontinence;
	}

	/**
	 * Return the value associated with the column: urge_incontinence
	 */
	public java.lang.String getUrgeIncontinence() {
		return urgeIncontinence;
	}

	/**
	 * Set the value related to the column: urge_incontinence
	 * 
	 * @param urgeIncontinence
	 *            the urge_incontinence value
	 */
	public void setUrgeIncontinence(java.lang.String urgeIncontinence) {
		this.urgeIncontinence = urgeIncontinence;
	}

	/**
	 * Return the value associated with the column: total_incontinence
	 */
	public java.lang.String getTotalIncontinence() {
		return totalIncontinence;
	}

	/**
	 * Set the value related to the column: total_incontinence
	 * 
	 * @param totalIncontinence
	 *            the total_incontinence value
	 */
	public void setTotalIncontinence(java.lang.String totalIncontinence) {
		this.totalIncontinence = totalIncontinence;
	}

	/**
	 * Return the value associated with the column: overflow_incontinence
	 */
	public java.lang.String getOverflowIncontinence() {
		return overflowIncontinence;
	}

	/**
	 * Set the value related to the column: overflow_incontinence
	 * 
	 * @param overflowIncontinence
	 *            the overflow_incontinence value
	 */
	public void setOverflowIncontinence(java.lang.String overflowIncontinence) {
		this.overflowIncontinence = overflowIncontinence;
	}

	/**
	 * Return the value associated with the column: acute_urinary_check
	 */
	public java.lang.String getAcuteUrinaryCheck() {
		return acuteUrinaryCheck;
	}

	/**
	 * Set the value related to the column: acute_urinary_check
	 * 
	 * @param acuteUrinaryCheck
	 *            the acute_urinary_check value
	 */
	public void setAcuteUrinaryCheck(java.lang.String acuteUrinaryCheck) {
		this.acuteUrinaryCheck = acuteUrinaryCheck;
	}

	/**
	 * Return the value associated with the column: acute_urinary
	 */
	public java.lang.String getAcuteUrinary() {
		return acuteUrinary;
	}

	/**
	 * Set the value related to the column: acute_urinary
	 * 
	 * @param acuteUrinary
	 *            the acute_urinary value
	 */
	public void setAcuteUrinary(java.lang.String acuteUrinary) {
		this.acuteUrinary = acuteUrinary;
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
		if (!(obj instanceof jkt.hms.masters.business.OpdUrology))
			return false;
		else {
			jkt.hms.masters.business.OpdUrology opdUrology = (jkt.hms.masters.business.OpdUrology) obj;
			if (null == this.getId() || null == opdUrology.getId())
				return false;
			else
				return (this.getId().equals(opdUrology.getId()));
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
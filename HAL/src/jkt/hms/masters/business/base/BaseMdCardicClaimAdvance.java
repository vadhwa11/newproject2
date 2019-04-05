package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the md_cardic_claim_advance table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="md_cardic_claim_advance"
 */

public abstract class BaseMdCardicClaimAdvance  implements Serializable {

	public static String REF = "MdCardicClaimAdvance";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_COPY2 = "Copy2";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_SUGEST_TO = "SugestTo";
	public static String PROP_EX_POST = "ExPost";
	public static String PROP_SPECIALIST_NAME = "SpecialistName";
	public static String PROP_REFFERED_TO = "RefferedTo";
	public static String PROP_IDENTIFICATION_MARK = "IdentificationMark";
	public static String PROP_RETIREMENT_DATE = "RetirementDate";
	public static String PROP_UNIT_TO = "UnitTo";
	public static String PROP_DGMS_TO = "DgmsTo";
	public static String PROP_TREATMENT_DETAIL = "TreatmentDetail";
	public static String PROP_IS1 = "Is1";
	public static String PROP_QUALIFYING_AMOUNT = "QualifyingAmount";
	public static String PROP_PAYABLE_TO = "PayableTo";
	public static String PROP_CGHS_RATE = "CghsRate";
	public static String PROP_ENTRY_DATE = "EntryDate";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_WORKING_DIAGNOSIS = "WorkingDiagnosis";
	public static String PROP_BASIC_PAY = "BasicPay";
	public static String PROP_UNIT_DISPATCH_DATE = "UnitDispatchDate";
	public static String PROP_PAYABLE_TO_NAME = "PayableToName";
	public static String PROP_COPY1 = "Copy1";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_DIAGNOSIS = "Diagnosis";
	public static String PROP_PAO = "Pao";
	public static String PROP_ADVANCE_AMOUNT = "AdvanceAmount";
	public static String PROP_HIN = "Hin";
	public static String PROP_CGHS_CODE = "CghsCode";
	public static String PROP_CDA_NAME = "CdaName";
	public static String PROP_DGMS_DISPATCH_DATE = "DgmsDispatchDate";
	public static String PROP_CIVIL_HOSPITAL = "CivilHospital";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ENTRY_NO = "EntryNo";
	public static String PROP_IS2 = "Is2";
	public static String PROP_COPY3 = "Copy3";
	public static String PROP_ID = "Id";


	// constructors
	public BaseMdCardicClaimAdvance () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMdCardicClaimAdvance (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String entryNo;
	private java.util.Date entryDate;
	private java.math.BigDecimal advanceAmount;
	private java.math.BigDecimal qualifyingAmount;
	private java.lang.String workingDiagnosis;
	private java.lang.String cdaName;
	private java.lang.String cghsCode;
	private java.lang.String is1;
	private java.math.BigDecimal is2;
	private java.util.Date retirementDate;
	private java.math.BigDecimal basicPay;
	private java.lang.String identificationMark;
	private java.lang.String dgmsTo;
	private java.util.Date dgmsDispatchDate;
	private java.lang.String copy1;
	private java.lang.String copy2;
	private java.lang.String copy3;
	private java.util.Date unitDispatchDate;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String cghsRate;
	private java.lang.String exPost;
	private java.lang.String pao;
	private java.lang.String payableToName;
	private java.lang.String sugestTo;
	private java.lang.String civilHospital;

	// many to one
	private jkt.hms.masters.business.MasChargeCode treatmentDetail;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasReference payableTo;
	private jkt.hms.masters.business.MasReference refferedTo;
	private jkt.hms.masters.business.MasIcd diagnosis;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasUnit unitTo;
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.MasEmployee specialistName;
	private jkt.hms.masters.business.Patient hin;

	// collections
	private java.util.Set<jkt.hms.masters.business.MdCardicContingentBillHd> mdCardicContingentBillHds;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
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
	 * Return the value associated with the column: entry_no
	 */
	public java.lang.String getEntryNo () {
		return entryNo;
	}

	/**
	 * Set the value related to the column: entry_no
	 * @param entryNo the entry_no value
	 */
	public void setEntryNo (java.lang.String entryNo) {
		this.entryNo = entryNo;
	}



	/**
	 * Return the value associated with the column: entry_date
	 */
	public java.util.Date getEntryDate () {
		return entryDate;
	}

	/**
	 * Set the value related to the column: entry_date
	 * @param entryDate the entry_date value
	 */
	public void setEntryDate (java.util.Date entryDate) {
		this.entryDate = entryDate;
	}



	/**
	 * Return the value associated with the column: advance_amount
	 */
	public java.math.BigDecimal getAdvanceAmount () {
		return advanceAmount;
	}

	/**
	 * Set the value related to the column: advance_amount
	 * @param advanceAmount the advance_amount value
	 */
	public void setAdvanceAmount (java.math.BigDecimal advanceAmount) {
		this.advanceAmount = advanceAmount;
	}



	/**
	 * Return the value associated with the column: qualifying_amount
	 */
	public java.math.BigDecimal getQualifyingAmount () {
		return qualifyingAmount;
	}

	/**
	 * Set the value related to the column: qualifying_amount
	 * @param qualifyingAmount the qualifying_amount value
	 */
	public void setQualifyingAmount (java.math.BigDecimal qualifyingAmount) {
		this.qualifyingAmount = qualifyingAmount;
	}



	/**
	 * Return the value associated with the column: working_diagnosis
	 */
	public java.lang.String getWorkingDiagnosis () {
		return workingDiagnosis;
	}

	/**
	 * Set the value related to the column: working_diagnosis
	 * @param workingDiagnosis the working_diagnosis value
	 */
	public void setWorkingDiagnosis (java.lang.String workingDiagnosis) {
		this.workingDiagnosis = workingDiagnosis;
	}



	/**
	 * Return the value associated with the column: cda_name
	 */
	public java.lang.String getCdaName () {
		return cdaName;
	}

	/**
	 * Set the value related to the column: cda_name
	 * @param cdaName the cda_name value
	 */
	public void setCdaName (java.lang.String cdaName) {
		this.cdaName = cdaName;
	}



	/**
	 * Return the value associated with the column: cghs_code
	 */
	public java.lang.String getCghsCode () {
		return cghsCode;
	}

	/**
	 * Set the value related to the column: cghs_code
	 * @param cghsCode the cghs_code value
	 */
	public void setCghsCode (java.lang.String cghsCode) {
		this.cghsCode = cghsCode;
	}



	/**
	 * Return the value associated with the column: is1
	 */
	public java.lang.String getIs1 () {
		return is1;
	}

	/**
	 * Set the value related to the column: is1
	 * @param is1 the is1 value
	 */
	public void setIs1 (java.lang.String is1) {
		this.is1 = is1;
	}



	/**
	 * Return the value associated with the column: is2
	 */
	public java.math.BigDecimal getIs2 () {
		return is2;
	}

	/**
	 * Set the value related to the column: is2
	 * @param is2 the is2 value
	 */
	public void setIs2 (java.math.BigDecimal is2) {
		this.is2 = is2;
	}



	/**
	 * Return the value associated with the column: retirement_date
	 */
	public java.util.Date getRetirementDate () {
		return retirementDate;
	}

	/**
	 * Set the value related to the column: retirement_date
	 * @param retirementDate the retirement_date value
	 */
	public void setRetirementDate (java.util.Date retirementDate) {
		this.retirementDate = retirementDate;
	}



	/**
	 * Return the value associated with the column: basic_pay
	 */
	public java.math.BigDecimal getBasicPay () {
		return basicPay;
	}

	/**
	 * Set the value related to the column: basic_pay
	 * @param basicPay the basic_pay value
	 */
	public void setBasicPay (java.math.BigDecimal basicPay) {
		this.basicPay = basicPay;
	}



	/**
	 * Return the value associated with the column: identification_mark
	 */
	public java.lang.String getIdentificationMark () {
		return identificationMark;
	}

	/**
	 * Set the value related to the column: identification_mark
	 * @param identificationMark the identification_mark value
	 */
	public void setIdentificationMark (java.lang.String identificationMark) {
		this.identificationMark = identificationMark;
	}



	/**
	 * Return the value associated with the column: dgms_to
	 */
	public java.lang.String getDgmsTo () {
		return dgmsTo;
	}

	/**
	 * Set the value related to the column: dgms_to
	 * @param dgmsTo the dgms_to value
	 */
	public void setDgmsTo (java.lang.String dgmsTo) {
		this.dgmsTo = dgmsTo;
	}



	/**
	 * Return the value associated with the column: dgms_dispatch_date
	 */
	public java.util.Date getDgmsDispatchDate () {
		return dgmsDispatchDate;
	}

	/**
	 * Set the value related to the column: dgms_dispatch_date
	 * @param dgmsDispatchDate the dgms_dispatch_date value
	 */
	public void setDgmsDispatchDate (java.util.Date dgmsDispatchDate) {
		this.dgmsDispatchDate = dgmsDispatchDate;
	}



	/**
	 * Return the value associated with the column: copy1
	 */
	public java.lang.String getCopy1 () {
		return copy1;
	}

	/**
	 * Set the value related to the column: copy1
	 * @param copy1 the copy1 value
	 */
	public void setCopy1 (java.lang.String copy1) {
		this.copy1 = copy1;
	}



	/**
	 * Return the value associated with the column: copy2
	 */
	public java.lang.String getCopy2 () {
		return copy2;
	}

	/**
	 * Set the value related to the column: copy2
	 * @param copy2 the copy2 value
	 */
	public void setCopy2 (java.lang.String copy2) {
		this.copy2 = copy2;
	}



	/**
	 * Return the value associated with the column: copy3
	 */
	public java.lang.String getCopy3 () {
		return copy3;
	}

	/**
	 * Set the value related to the column: copy3
	 * @param copy3 the copy3 value
	 */
	public void setCopy3 (java.lang.String copy3) {
		this.copy3 = copy3;
	}



	/**
	 * Return the value associated with the column: unit_dispatch_date
	 */
	public java.util.Date getUnitDispatchDate () {
		return unitDispatchDate;
	}

	/**
	 * Set the value related to the column: unit_dispatch_date
	 * @param unitDispatchDate the unit_dispatch_date value
	 */
	public void setUnitDispatchDate (java.util.Date unitDispatchDate) {
		this.unitDispatchDate = unitDispatchDate;
	}



	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.String getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (java.lang.String lastChgBy) {
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
	 * Return the value associated with the column: cghs_rate
	 */
	public java.lang.String getCghsRate () {
		return cghsRate;
	}

	/**
	 * Set the value related to the column: cghs_rate
	 * @param cghsRate the cghs_rate value
	 */
	public void setCghsRate (java.lang.String cghsRate) {
		this.cghsRate = cghsRate;
	}



	/**
	 * Return the value associated with the column: ex_post
	 */
	public java.lang.String getExPost () {
		return exPost;
	}

	/**
	 * Set the value related to the column: ex_post
	 * @param exPost the ex_post value
	 */
	public void setExPost (java.lang.String exPost) {
		this.exPost = exPost;
	}



	/**
	 * Return the value associated with the column: pao
	 */
	public java.lang.String getPao () {
		return pao;
	}

	/**
	 * Set the value related to the column: pao
	 * @param pao the pao value
	 */
	public void setPao (java.lang.String pao) {
		this.pao = pao;
	}



	/**
	 * Return the value associated with the column: payable_to_name
	 */
	public java.lang.String getPayableToName () {
		return payableToName;
	}

	/**
	 * Set the value related to the column: payable_to_name
	 * @param payableToName the payable_to_name value
	 */
	public void setPayableToName (java.lang.String payableToName) {
		this.payableToName = payableToName;
	}



	/**
	 * Return the value associated with the column: suggest_to
	 */
	public java.lang.String getSugestTo () {
		return sugestTo;
	}

	/**
	 * Set the value related to the column: suggest_to
	 * @param sugestTo the suggest_to value
	 */
	public void setSugestTo (java.lang.String sugestTo) {
		this.sugestTo = sugestTo;
	}



	/**
	 * Return the value associated with the column: civil_hospital_name
	 */
	public java.lang.String getCivilHospital () {
		return civilHospital;
	}

	/**
	 * Set the value related to the column: civil_hospital_name
	 * @param civilHospital the civil_hospital_name value
	 */
	public void setCivilHospital (java.lang.String civilHospital) {
		this.civilHospital = civilHospital;
	}



	/**
	 * Return the value associated with the column: treatment_detail
	 */
	public jkt.hms.masters.business.MasChargeCode getTreatmentDetail () {
		return treatmentDetail;
	}

	/**
	 * Set the value related to the column: treatment_detail
	 * @param treatmentDetail the treatment_detail value
	 */
	public void setTreatmentDetail (jkt.hms.masters.business.MasChargeCode treatmentDetail) {
		this.treatmentDetail = treatmentDetail;
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
	 * Return the value associated with the column: payable_to
	 */
	public jkt.hms.masters.business.MasReference getPayableTo () {
		return payableTo;
	}

	/**
	 * Set the value related to the column: payable_to
	 * @param payableTo the payable_to value
	 */
	public void setPayableTo (jkt.hms.masters.business.MasReference payableTo) {
		this.payableTo = payableTo;
	}



	/**
	 * Return the value associated with the column: reffered_to
	 */
	public jkt.hms.masters.business.MasReference getRefferedTo () {
		return refferedTo;
	}

	/**
	 * Set the value related to the column: reffered_to
	 * @param refferedTo the reffered_to value
	 */
	public void setRefferedTo (jkt.hms.masters.business.MasReference refferedTo) {
		this.refferedTo = refferedTo;
	}



	/**
	 * Return the value associated with the column: diagnosis_id
	 */
	public jkt.hms.masters.business.MasIcd getDiagnosis () {
		return diagnosis;
	}

	/**
	 * Set the value related to the column: diagnosis_id
	 * @param diagnosis the diagnosis_id value
	 */
	public void setDiagnosis (jkt.hms.masters.business.MasIcd diagnosis) {
		this.diagnosis = diagnosis;
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
	 * Return the value associated with the column: unit_to
	 */
	public jkt.hms.masters.business.MasUnit getUnitTo () {
		return unitTo;
	}

	/**
	 * Set the value related to the column: unit_to
	 * @param unitTo the unit_to value
	 */
	public void setUnitTo (jkt.hms.masters.business.MasUnit unitTo) {
		this.unitTo = unitTo;
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
	 * Return the value associated with the column: specialist_name
	 */
	public jkt.hms.masters.business.MasEmployee getSpecialistName () {
		return specialistName;
	}

	/**
	 * Set the value related to the column: specialist_name
	 * @param specialistName the specialist_name value
	 */
	public void setSpecialistName (jkt.hms.masters.business.MasEmployee specialistName) {
		this.specialistName = specialistName;
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
	 * Return the value associated with the column: MdCardicContingentBillHds
	 */
	public java.util.Set<jkt.hms.masters.business.MdCardicContingentBillHd> getMdCardicContingentBillHds () {
		return mdCardicContingentBillHds;
	}

	/**
	 * Set the value related to the column: MdCardicContingentBillHds
	 * @param mdCardicContingentBillHds the MdCardicContingentBillHds value
	 */
	public void setMdCardicContingentBillHds (java.util.Set<jkt.hms.masters.business.MdCardicContingentBillHd> mdCardicContingentBillHds) {
		this.mdCardicContingentBillHds = mdCardicContingentBillHds;
	}

	public void addToMdCardicContingentBillHds (jkt.hms.masters.business.MdCardicContingentBillHd mdCardicContingentBillHd) {
		if (null == getMdCardicContingentBillHds()) setMdCardicContingentBillHds(new java.util.TreeSet<jkt.hms.masters.business.MdCardicContingentBillHd>());
		getMdCardicContingentBillHds().add(mdCardicContingentBillHd);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MdCardicClaimAdvance)) return false;
		else {
			jkt.hms.masters.business.MdCardicClaimAdvance mdCardicClaimAdvance = (jkt.hms.masters.business.MdCardicClaimAdvance) obj;
			if (null == this.getId() || null == mdCardicClaimAdvance.getId()) return false;
			else return (this.getId().equals(mdCardicClaimAdvance.getId()));
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
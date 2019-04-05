package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the pension_data_sheet table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="pension_data_sheet"
 */

public abstract class BasePensionDataSheet implements Serializable {

	public static String REF = "PensionDataSheet";
	public static String PROP_NATIONALITY_CODE_SPOUSE = "NationalityCodeSpouse";
	public static String PROP_NATURE_OF_PENSION = "NatureOfPension";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_BSR_CODE_OF_LINK_BANK = "BsrCodeOfLinkBank";
	public static String PROP_PERSONNEL = "Personnel";
	public static String PROP_AGE_SPOUSE = "AgeSpouse";
	public static String PROP_PAY_CODE = "PayCode";
	public static String PROP_LAST_PAY_REDUCED = "LastPayReduced";
	public static String PROP_FORMER_SERVICE_COUNTED = "FormerServiceCounted";
	public static String PROP_INTEREST_ON_RDR_DEMAND = "InterestOnRdrDemand";
	public static String PROP_AC_OTHER_THEN_RDR_HEAD = "AcOtherThenRdrHead";
	public static String PROP_MEDICAL_ALLOWANCE = "MedicalAllowance";
	public static String PROP_PAY_GROUP = "PayGroup";
	public static String PROP_INTEREST_PAYABLE = "InterestPayable";
	public static String PROP_MON_AVE = "MonAve";
	public static String PROP_ORGANISATION_CODE = "OrganisationCode";
	public static String PROP_SPOUSE_ALIVE = "SpouseAlive";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_AC_OF_RDR_HEAD = "AcOfRdrHead";
	public static String PROP_DATE_OF_RECEIPT = "DateOfReceipt";
	public static String PROP_LAST_PAY_DRAWN = "LastPayDrawn";
	public static String PROP_PDA_CODE = "PdaCode";
	public static String PROP_RELATION = "Relation";
	public static String PROP_AMOUNT_COMM = "AmountComm";
	public static String PROP_PAY_IN_PAY_BAND_SCALE = "PayInPayBandScale";
	public static String PROP_NATIONALITY_CODE = "NationalityCode";
	public static String PROP_MARRIED_BEFORE_RETIREMENT = "MarriedBeforeRetirement";
	public static String PROP_DPDO_CODE = "DpdoCode";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_PDA_STATION = "PdaStation";
	public static String PROP_BSR_CODE_OF_BANK_BRANCH = "BsrCodeOfBankBranch";
	public static String PROP_PDA_STATE_CODE = "PdaStateCode";
	public static String PROP_NP_MS_PAY = "NpMsPay";
	public static String PROP_RETIREMENT = "Retirement";
	public static String PROP_NAME_OF_SPOUSE = "NameOfSpouse";
	public static String PROP_ORG_GROUP = "OrgGroup";
	public static String PROP_HAVING_HANDICAPPED_CHILD = "HavingHandicappedChild";
	public static String PROP_GPF_NO = "GpfNo";
	public static String PROP_CDR_NO = "CdrNo";
	public static String PROP_PENSIONERS_STATE_CODE = "PensionersStateCode";
	public static String PROP_BANK_SUB_TRY_CODE = "BankSubTryCode";
	public static String PROP_PAY_BAND_CODE = "PayBandCode";
	public static String PROP_LINK_BANK = "LinkBank";
	public static String PROP_WEIGHTAGE_ALLOWED = "WeightageAllowed";
	public static String PROP_AGE_LOAD = "AgeLoad";
	public static String PROP_FRACTION_COMM = "FractionComm";
	public static String PROP_GAL_AWARD = "GalAward";
	public static String PROP_GRADE_PAY = "GradePay";
	public static String PROP_HEAD_OFFICE_ADDRESS = "HeadOfficeAddress";
	public static String PROP_BANK_BRANCH = "BankBranch";
	public static String PROP_ID = "Id";
	public static String PROP_NAME_OF_HANDICAPPED_CHILD = "NameOfHandicappedChild";

	// constructors
	public BasePensionDataSheet() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePensionDataSheet(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String organisationCode;
	private java.lang.String orgGroup;
	private java.lang.String gpfNo;
	private java.lang.String headOfficeAddress;
	private java.lang.String nationalityCode;
	private java.lang.String retirement;
	private java.lang.String natureOfPension;
	private java.lang.String formerServiceCounted;
	private java.lang.String weightageAllowed;
	private java.lang.String medicalAllowance;
	private java.lang.String payGroup;
	private java.lang.String payCode;
	private java.lang.String payBandCode;
	private java.lang.String payInPayBandScale;
	private java.lang.String gradePay;
	private java.lang.String npMsPay;
	private java.util.Date lastPayDrawn;
	private java.lang.Integer monAve;
	private java.lang.String galAward;
	private java.lang.String lastPayReduced;
	private java.lang.String acOfRdrHead;
	private java.lang.String acOtherThenRdrHead;
	private java.lang.String interestOnRdrDemand;
	private java.lang.String interestPayable;
	private java.util.Date dateOfReceipt;
	private java.lang.Integer fractionComm;
	private java.math.BigDecimal amountComm;
	private java.lang.Integer ageLoad;
	private java.lang.String marriedBeforeRetirement;
	private java.lang.String spouseAlive;
	private java.lang.String nameOfSpouse;
	private java.util.Date ageSpouse;
	private java.lang.String pdaCode;
	private java.lang.String dpdoCode;
	private java.lang.String pdaStation;
	private java.lang.String pdaStateCode;
	private java.lang.String bankSubTryCode;
	private java.lang.String linkBank;
	private java.lang.String bankBranch;
	private java.lang.String bsrCodeOfLinkBank;
	private java.lang.String bsrCodeOfBankBranch;
	private java.lang.String pensionersStateCode;
	private java.lang.String havingHandicappedChild;
	private java.lang.String nameOfHandicappedChild;
	private java.lang.String cdrNo;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String nationalityCodeSpouse;

	// many to one
	private jkt.hms.masters.business.MasPersonnelDetails personnel;
	private jkt.hms.masters.business.MasRelation relation;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="id"
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
	 * Return the value associated with the column: organisation_code
	 */
	public java.lang.String getOrganisationCode() {
		return organisationCode;
	}

	/**
	 * Set the value related to the column: organisation_code
	 * 
	 * @param organisationCode
	 *            the organisation_code value
	 */
	public void setOrganisationCode(java.lang.String organisationCode) {
		this.organisationCode = organisationCode;
	}

	/**
	 * Return the value associated with the column: org_group
	 */
	public java.lang.String getOrgGroup() {
		return orgGroup;
	}

	/**
	 * Set the value related to the column: org_group
	 * 
	 * @param orgGroup
	 *            the org_group value
	 */
	public void setOrgGroup(java.lang.String orgGroup) {
		this.orgGroup = orgGroup;
	}

	/**
	 * Return the value associated with the column: gpf_no
	 */
	public java.lang.String getGpfNo() {
		return gpfNo;
	}

	/**
	 * Set the value related to the column: gpf_no
	 * 
	 * @param gpfNo
	 *            the gpf_no value
	 */
	public void setGpfNo(java.lang.String gpfNo) {
		this.gpfNo = gpfNo;
	}

	/**
	 * Return the value associated with the column: head_office_address
	 */
	public java.lang.String getHeadOfficeAddress() {
		return headOfficeAddress;
	}

	/**
	 * Set the value related to the column: head_office_address
	 * 
	 * @param headOfficeAddress
	 *            the head_office_address value
	 */
	public void setHeadOfficeAddress(java.lang.String headOfficeAddress) {
		this.headOfficeAddress = headOfficeAddress;
	}

	/**
	 * Return the value associated with the column: nationality_code
	 */
	public java.lang.String getNationalityCode() {
		return nationalityCode;
	}

	/**
	 * Set the value related to the column: nationality_code
	 * 
	 * @param nationalityCode
	 *            the nationality_code value
	 */
	public void setNationalityCode(java.lang.String nationalityCode) {
		this.nationalityCode = nationalityCode;
	}

	/**
	 * Return the value associated with the column: retirement
	 */
	public java.lang.String getRetirement() {
		return retirement;
	}

	/**
	 * Set the value related to the column: retirement
	 * 
	 * @param retirement
	 *            the retirement value
	 */
	public void setRetirement(java.lang.String retirement) {
		this.retirement = retirement;
	}

	/**
	 * Return the value associated with the column: nature_of_pension
	 */
	public java.lang.String getNatureOfPension() {
		return natureOfPension;
	}

	/**
	 * Set the value related to the column: nature_of_pension
	 * 
	 * @param natureOfPension
	 *            the nature_of_pension value
	 */
	public void setNatureOfPension(java.lang.String natureOfPension) {
		this.natureOfPension = natureOfPension;
	}

	/**
	 * Return the value associated with the column: former_service_counted
	 */
	public java.lang.String getFormerServiceCounted() {
		return formerServiceCounted;
	}

	/**
	 * Set the value related to the column: former_service_counted
	 * 
	 * @param formerServiceCounted
	 *            the former_service_counted value
	 */
	public void setFormerServiceCounted(java.lang.String formerServiceCounted) {
		this.formerServiceCounted = formerServiceCounted;
	}

	/**
	 * Return the value associated with the column: weightage_allowed
	 */
	public java.lang.String getWeightageAllowed() {
		return weightageAllowed;
	}

	/**
	 * Set the value related to the column: weightage_allowed
	 * 
	 * @param weightageAllowed
	 *            the weightage_allowed value
	 */
	public void setWeightageAllowed(java.lang.String weightageAllowed) {
		this.weightageAllowed = weightageAllowed;
	}

	/**
	 * Return the value associated with the column: medical_allowance
	 */
	public java.lang.String getMedicalAllowance() {
		return medicalAllowance;
	}

	/**
	 * Set the value related to the column: medical_allowance
	 * 
	 * @param medicalAllowance
	 *            the medical_allowance value
	 */
	public void setMedicalAllowance(java.lang.String medicalAllowance) {
		this.medicalAllowance = medicalAllowance;
	}

	/**
	 * Return the value associated with the column: pay_group
	 */
	public java.lang.String getPayGroup() {
		return payGroup;
	}

	/**
	 * Set the value related to the column: pay_group
	 * 
	 * @param payGroup
	 *            the pay_group value
	 */
	public void setPayGroup(java.lang.String payGroup) {
		this.payGroup = payGroup;
	}

	/**
	 * Return the value associated with the column: pay_code
	 */
	public java.lang.String getPayCode() {
		return payCode;
	}

	/**
	 * Set the value related to the column: pay_code
	 * 
	 * @param payCode
	 *            the pay_code value
	 */
	public void setPayCode(java.lang.String payCode) {
		this.payCode = payCode;
	}

	/**
	 * Return the value associated with the column: pay_band_code
	 */
	public java.lang.String getPayBandCode() {
		return payBandCode;
	}

	/**
	 * Set the value related to the column: pay_band_code
	 * 
	 * @param payBandCode
	 *            the pay_band_code value
	 */
	public void setPayBandCode(java.lang.String payBandCode) {
		this.payBandCode = payBandCode;
	}

	/**
	 * Return the value associated with the column: pay_in_pay_band_scale
	 */
	public java.lang.String getPayInPayBandScale() {
		return payInPayBandScale;
	}

	/**
	 * Set the value related to the column: pay_in_pay_band_scale
	 * 
	 * @param payInPayBandScale
	 *            the pay_in_pay_band_scale value
	 */
	public void setPayInPayBandScale(java.lang.String payInPayBandScale) {
		this.payInPayBandScale = payInPayBandScale;
	}

	/**
	 * Return the value associated with the column: grade_pay
	 */
	public java.lang.String getGradePay() {
		return gradePay;
	}

	/**
	 * Set the value related to the column: grade_pay
	 * 
	 * @param gradePay
	 *            the grade_pay value
	 */
	public void setGradePay(java.lang.String gradePay) {
		this.gradePay = gradePay;
	}

	/**
	 * Return the value associated with the column: np_ms_pay
	 */
	public java.lang.String getNpMsPay() {
		return npMsPay;
	}

	/**
	 * Set the value related to the column: np_ms_pay
	 * 
	 * @param npMsPay
	 *            the np_ms_pay value
	 */
	public void setNpMsPay(java.lang.String npMsPay) {
		this.npMsPay = npMsPay;
	}

	/**
	 * Return the value associated with the column: last_pay_drawn
	 */
	public java.util.Date getLastPayDrawn() {
		return lastPayDrawn;
	}

	/**
	 * Set the value related to the column: last_pay_drawn
	 * 
	 * @param lastPayDrawn
	 *            the last_pay_drawn value
	 */
	public void setLastPayDrawn(java.util.Date lastPayDrawn) {
		this.lastPayDrawn = lastPayDrawn;
	}

	/**
	 * Return the value associated with the column: mon_ave
	 */
	public java.lang.Integer getMonAve() {
		return monAve;
	}

	/**
	 * Set the value related to the column: mon_ave
	 * 
	 * @param monAve
	 *            the mon_ave value
	 */
	public void setMonAve(java.lang.Integer monAve) {
		this.monAve = monAve;
	}

	/**
	 * Return the value associated with the column: gal_award
	 */
	public java.lang.String getGalAward() {
		return galAward;
	}

	/**
	 * Set the value related to the column: gal_award
	 * 
	 * @param galAward
	 *            the gal_award value
	 */
	public void setGalAward(java.lang.String galAward) {
		this.galAward = galAward;
	}

	/**
	 * Return the value associated with the column: last_pay_reduced
	 */
	public java.lang.String getLastPayReduced() {
		return lastPayReduced;
	}

	/**
	 * Set the value related to the column: last_pay_reduced
	 * 
	 * @param lastPayReduced
	 *            the last_pay_reduced value
	 */
	public void setLastPayReduced(java.lang.String lastPayReduced) {
		this.lastPayReduced = lastPayReduced;
	}

	/**
	 * Return the value associated with the column: ac_of_rdr_head
	 */
	public java.lang.String getAcOfRdrHead() {
		return acOfRdrHead;
	}

	/**
	 * Set the value related to the column: ac_of_rdr_head
	 * 
	 * @param acOfRdrHead
	 *            the ac_of_rdr_head value
	 */
	public void setAcOfRdrHead(java.lang.String acOfRdrHead) {
		this.acOfRdrHead = acOfRdrHead;
	}

	/**
	 * Return the value associated with the column: ac_other_then_rdr_head
	 */
	public java.lang.String getAcOtherThenRdrHead() {
		return acOtherThenRdrHead;
	}

	/**
	 * Set the value related to the column: ac_other_then_rdr_head
	 * 
	 * @param acOtherThenRdrHead
	 *            the ac_other_then_rdr_head value
	 */
	public void setAcOtherThenRdrHead(java.lang.String acOtherThenRdrHead) {
		this.acOtherThenRdrHead = acOtherThenRdrHead;
	}

	/**
	 * Return the value associated with the column: interest_on_rdr_demand
	 */
	public java.lang.String getInterestOnRdrDemand() {
		return interestOnRdrDemand;
	}

	/**
	 * Set the value related to the column: interest_on_rdr_demand
	 * 
	 * @param interestOnRdrDemand
	 *            the interest_on_rdr_demand value
	 */
	public void setInterestOnRdrDemand(java.lang.String interestOnRdrDemand) {
		this.interestOnRdrDemand = interestOnRdrDemand;
	}

	/**
	 * Return the value associated with the column: interest_payable
	 */
	public java.lang.String getInterestPayable() {
		return interestPayable;
	}

	/**
	 * Set the value related to the column: interest_payable
	 * 
	 * @param interestPayable
	 *            the interest_payable value
	 */
	public void setInterestPayable(java.lang.String interestPayable) {
		this.interestPayable = interestPayable;
	}

	/**
	 * Return the value associated with the column: date_of_receipt
	 */
	public java.util.Date getDateOfReceipt() {
		return dateOfReceipt;
	}

	/**
	 * Set the value related to the column: date_of_receipt
	 * 
	 * @param dateOfReceipt
	 *            the date_of_receipt value
	 */
	public void setDateOfReceipt(java.util.Date dateOfReceipt) {
		this.dateOfReceipt = dateOfReceipt;
	}

	/**
	 * Return the value associated with the column: fraction_comm
	 */
	public java.lang.Integer getFractionComm() {
		return fractionComm;
	}

	/**
	 * Set the value related to the column: fraction_comm
	 * 
	 * @param fractionComm
	 *            the fraction_comm value
	 */
	public void setFractionComm(java.lang.Integer fractionComm) {
		this.fractionComm = fractionComm;
	}

	/**
	 * Return the value associated with the column: amount_comm
	 */
	public java.math.BigDecimal getAmountComm() {
		return amountComm;
	}

	/**
	 * Set the value related to the column: amount_comm
	 * 
	 * @param amountComm
	 *            the amount_comm value
	 */
	public void setAmountComm(java.math.BigDecimal amountComm) {
		this.amountComm = amountComm;
	}

	/**
	 * Return the value associated with the column: age_load
	 */
	public java.lang.Integer getAgeLoad() {
		return ageLoad;
	}

	/**
	 * Set the value related to the column: age_load
	 * 
	 * @param ageLoad
	 *            the age_load value
	 */
	public void setAgeLoad(java.lang.Integer ageLoad) {
		this.ageLoad = ageLoad;
	}

	/**
	 * Return the value associated with the column: married_before_retirement
	 */
	public java.lang.String getMarriedBeforeRetirement() {
		return marriedBeforeRetirement;
	}

	/**
	 * Set the value related to the column: married_before_retirement
	 * 
	 * @param marriedBeforeRetirement
	 *            the married_before_retirement value
	 */
	public void setMarriedBeforeRetirement(
			java.lang.String marriedBeforeRetirement) {
		this.marriedBeforeRetirement = marriedBeforeRetirement;
	}

	/**
	 * Return the value associated with the column: spouse_alive
	 */
	public java.lang.String getSpouseAlive() {
		return spouseAlive;
	}

	/**
	 * Set the value related to the column: spouse_alive
	 * 
	 * @param spouseAlive
	 *            the spouse_alive value
	 */
	public void setSpouseAlive(java.lang.String spouseAlive) {
		this.spouseAlive = spouseAlive;
	}

	/**
	 * Return the value associated with the column: name_of_spouse
	 */
	public java.lang.String getNameOfSpouse() {
		return nameOfSpouse;
	}

	/**
	 * Set the value related to the column: name_of_spouse
	 * 
	 * @param nameOfSpouse
	 *            the name_of_spouse value
	 */
	public void setNameOfSpouse(java.lang.String nameOfSpouse) {
		this.nameOfSpouse = nameOfSpouse;
	}

	/**
	 * Return the value associated with the column: age_spouse
	 */
	public java.util.Date getAgeSpouse() {
		return ageSpouse;
	}

	/**
	 * Set the value related to the column: age_spouse
	 * 
	 * @param ageSpouse
	 *            the age_spouse value
	 */
	public void setAgeSpouse(java.util.Date ageSpouse) {
		this.ageSpouse = ageSpouse;
	}

	/**
	 * Return the value associated with the column: pda_code
	 */
	public java.lang.String getPdaCode() {
		return pdaCode;
	}

	/**
	 * Set the value related to the column: pda_code
	 * 
	 * @param pdaCode
	 *            the pda_code value
	 */
	public void setPdaCode(java.lang.String pdaCode) {
		this.pdaCode = pdaCode;
	}

	/**
	 * Return the value associated with the column: dpdo_code
	 */
	public java.lang.String getDpdoCode() {
		return dpdoCode;
	}

	/**
	 * Set the value related to the column: dpdo_code
	 * 
	 * @param dpdoCode
	 *            the dpdo_code value
	 */
	public void setDpdoCode(java.lang.String dpdoCode) {
		this.dpdoCode = dpdoCode;
	}

	/**
	 * Return the value associated with the column: pda_station
	 */
	public java.lang.String getPdaStation() {
		return pdaStation;
	}

	/**
	 * Set the value related to the column: pda_station
	 * 
	 * @param pdaStation
	 *            the pda_station value
	 */
	public void setPdaStation(java.lang.String pdaStation) {
		this.pdaStation = pdaStation;
	}

	/**
	 * Return the value associated with the column: pda_state_code
	 */
	public java.lang.String getPdaStateCode() {
		return pdaStateCode;
	}

	/**
	 * Set the value related to the column: pda_state_code
	 * 
	 * @param pdaStateCode
	 *            the pda_state_code value
	 */
	public void setPdaStateCode(java.lang.String pdaStateCode) {
		this.pdaStateCode = pdaStateCode;
	}

	/**
	 * Return the value associated with the column: bank_sub_try_code
	 */
	public java.lang.String getBankSubTryCode() {
		return bankSubTryCode;
	}

	/**
	 * Set the value related to the column: bank_sub_try_code
	 * 
	 * @param bankSubTryCode
	 *            the bank_sub_try_code value
	 */
	public void setBankSubTryCode(java.lang.String bankSubTryCode) {
		this.bankSubTryCode = bankSubTryCode;
	}

	/**
	 * Return the value associated with the column: link_bank
	 */
	public java.lang.String getLinkBank() {
		return linkBank;
	}

	/**
	 * Set the value related to the column: link_bank
	 * 
	 * @param linkBank
	 *            the link_bank value
	 */
	public void setLinkBank(java.lang.String linkBank) {
		this.linkBank = linkBank;
	}

	/**
	 * Return the value associated with the column: bank_branch
	 */
	public java.lang.String getBankBranch() {
		return bankBranch;
	}

	/**
	 * Set the value related to the column: bank_branch
	 * 
	 * @param bankBranch
	 *            the bank_branch value
	 */
	public void setBankBranch(java.lang.String bankBranch) {
		this.bankBranch = bankBranch;
	}

	/**
	 * Return the value associated with the column: bsr_code_of_link_bank
	 */
	public java.lang.String getBsrCodeOfLinkBank() {
		return bsrCodeOfLinkBank;
	}

	/**
	 * Set the value related to the column: bsr_code_of_link_bank
	 * 
	 * @param bsrCodeOfLinkBank
	 *            the bsr_code_of_link_bank value
	 */
	public void setBsrCodeOfLinkBank(java.lang.String bsrCodeOfLinkBank) {
		this.bsrCodeOfLinkBank = bsrCodeOfLinkBank;
	}

	/**
	 * Return the value associated with the column: bsr_code_of_bank_branch
	 */
	public java.lang.String getBsrCodeOfBankBranch() {
		return bsrCodeOfBankBranch;
	}

	/**
	 * Set the value related to the column: bsr_code_of_bank_branch
	 * 
	 * @param bsrCodeOfBankBranch
	 *            the bsr_code_of_bank_branch value
	 */
	public void setBsrCodeOfBankBranch(java.lang.String bsrCodeOfBankBranch) {
		this.bsrCodeOfBankBranch = bsrCodeOfBankBranch;
	}

	/**
	 * Return the value associated with the column: pensioners_state_code
	 */
	public java.lang.String getPensionersStateCode() {
		return pensionersStateCode;
	}

	/**
	 * Set the value related to the column: pensioners_state_code
	 * 
	 * @param pensionersStateCode
	 *            the pensioners_state_code value
	 */
	public void setPensionersStateCode(java.lang.String pensionersStateCode) {
		this.pensionersStateCode = pensionersStateCode;
	}

	/**
	 * Return the value associated with the column: having_handicapped_child
	 */
	public java.lang.String getHavingHandicappedChild() {
		return havingHandicappedChild;
	}

	/**
	 * Set the value related to the column: having_handicapped_child
	 * 
	 * @param havingHandicappedChild
	 *            the having_handicapped_child value
	 */
	public void setHavingHandicappedChild(
			java.lang.String havingHandicappedChild) {
		this.havingHandicappedChild = havingHandicappedChild;
	}

	/**
	 * Return the value associated with the column: name_of_handicapped_child
	 */
	public java.lang.String getNameOfHandicappedChild() {
		return nameOfHandicappedChild;
	}

	/**
	 * Set the value related to the column: name_of_handicapped_child
	 * 
	 * @param nameOfHandicappedChild
	 *            the name_of_handicapped_child value
	 */
	public void setNameOfHandicappedChild(
			java.lang.String nameOfHandicappedChild) {
		this.nameOfHandicappedChild = nameOfHandicappedChild;
	}

	/**
	 * Return the value associated with the column: cdr_no
	 */
	public java.lang.String getCdrNo() {
		return cdrNo;
	}

	/**
	 * Set the value related to the column: cdr_no
	 * 
	 * @param cdrNo
	 *            the cdr_no value
	 */
	public void setCdrNo(java.lang.String cdrNo) {
		this.cdrNo = cdrNo;
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
	 * Return the value associated with the column: nationality_code_spouse
	 */
	public java.lang.String getNationalityCodeSpouse() {
		return nationalityCodeSpouse;
	}

	/**
	 * Set the value related to the column: nationality_code_spouse
	 * 
	 * @param nationalityCodeSpouse
	 *            the nationality_code_spouse value
	 */
	public void setNationalityCodeSpouse(java.lang.String nationalityCodeSpouse) {
		this.nationalityCodeSpouse = nationalityCodeSpouse;
	}

	/**
	 * Return the value associated with the column: personnel_id
	 */
	public jkt.hms.masters.business.MasPersonnelDetails getPersonnel() {
		return personnel;
	}

	/**
	 * Set the value related to the column: personnel_id
	 * 
	 * @param personnel
	 *            the personnel_id value
	 */
	public void setPersonnel(
			jkt.hms.masters.business.MasPersonnelDetails personnel) {
		this.personnel = personnel;
	}

	/**
	 * Return the value associated with the column: relation_id
	 */
	public jkt.hms.masters.business.MasRelation getRelation() {
		return relation;
	}

	/**
	 * Set the value related to the column: relation_id
	 * 
	 * @param relation
	 *            the relation_id value
	 */
	public void setRelation(jkt.hms.masters.business.MasRelation relation) {
		this.relation = relation;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.PensionDataSheet))
			return false;
		else {
			jkt.hms.masters.business.PensionDataSheet pensionDataSheet = (jkt.hms.masters.business.PensionDataSheet) obj;
			if (null == this.getId() || null == pensionDataSheet.getId())
				return false;
			else
				return (this.getId().equals(pensionDataSheet.getId()));
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
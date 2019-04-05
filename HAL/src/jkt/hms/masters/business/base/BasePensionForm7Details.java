package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the pension_form7_details
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="pension_form7_details"
 */

public abstract class BasePensionForm7Details implements Serializable {

	public static String REF = "PensionForm7Details";
	public static String PROP_GRATUITY_PERIOD = "GratuityPeriod";
	public static String PROP_PLACE_OF_PAYMENT = "PlaceOfPayment";
	public static String PROP_FAMILY_PENSION = "FamilyPension";
	public static String PROP_PENSION_DATE = "PensionDate";
	public static String PROP_DUES_REFERRED = "DuesReferred";
	public static String PROP_QUALIFYING_PENSION = "QualifyingPension";
	public static String PROP_TOTAL = "Total";
	public static String PROP_PERSONNEL = "Personnel";
	public static String PROP_EMOL_RECKONING_GRATUITY = "EmolReckoningGratuity";
	public static String PROP_DEFICIENCIES = "Deficiencies";
	public static String PROP_SUSPENSION_PERIOD = "SuspensionPeriod";
	public static String PROP_LICENCE_FEE = "LicenceFee";
	public static String PROP_DUES_ASSESSMENT = "DuesAssessment";
	public static String PROP_FORM5_DATE = "Form5Date";
	public static String PROP_GRATUITY_RECIEVED_CIVIL_SERVICE = "GratuityRecievedCivilService";
	public static String PROP_INTERRUPTION_IN_SERVICE = "InterruptionInService";
	public static String PROP_PROPOSED_AMOUNT = "ProposedAmount";
	public static String PROP_ACCOUNT_HEAD_PENSION_GRATUTITY_DEBIT = "AccountHeadPensionGratutityDebit";
	public static String PROP_NOMINATION_FOR_GRATUITY = "NominationForGratuity";
	public static String PROP_PROPOSED_GRATUITY = "ProposedGratuity";
	public static String PROP_OTHER_SERVICE = "OtherService";
	public static String PROP_ID = "Id";
	public static String PROP_GRATUITY_RECIEVED_MILITARY = "GratuityRecievedMilitary";
	public static String PROP_NO_DEMAND_CERTIFICATE = "NoDemandCertificate";

	// constructors
	public BasePensionForm7Details() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePensionForm7Details(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String gratuityPeriod;
	private java.lang.String gratuityRecievedMilitary;
	private java.lang.String gratuityRecievedCivilService;
	private java.util.Date noDemandCertificate;
	private java.util.Date qualifyingPension;
	private java.util.Date duesAssessment;
	private java.lang.String deficiencies;
	private java.lang.String interruptionInService;
	private java.lang.String suspensionPeriod;
	private java.lang.String otherService;
	private java.lang.String total;
	private java.util.Date form5Date;
	private java.math.BigDecimal proposedGratuity;
	private java.util.Date pensionDate;
	private java.math.BigDecimal proposedAmount;
	private java.math.BigDecimal licenceFee;
	private java.math.BigDecimal duesReferred;
	private java.lang.String nominationForGratuity;
	private java.lang.String familyPension;
	private java.lang.String placeOfPayment;
	private java.lang.String accountHeadPensionGratutityDebit;
	private java.lang.String emolReckoningGratuity;

	// many to one
	private jkt.hms.masters.business.MasPersonnelDetails personnel;

	// collections
	private java.util.Set<jkt.hms.masters.business.PensionForm7EmolumentsDetail> pensionForm7EmolumentsDetails;

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
	 * Return the value associated with the column: gratuity_period
	 */
	public java.lang.String getGratuityPeriod() {
		return gratuityPeriod;
	}

	/**
	 * Set the value related to the column: gratuity_period
	 * 
	 * @param gratuityPeriod
	 *            the gratuity_period value
	 */
	public void setGratuityPeriod(java.lang.String gratuityPeriod) {
		this.gratuityPeriod = gratuityPeriod;
	}

	/**
	 * Return the value associated with the column: gratuity_recieved_military
	 */
	public java.lang.String getGratuityRecievedMilitary() {
		return gratuityRecievedMilitary;
	}

	/**
	 * Set the value related to the column: gratuity_recieved_military
	 * 
	 * @param gratuityRecievedMilitary
	 *            the gratuity_recieved_military value
	 */
	public void setGratuityRecievedMilitary(
			java.lang.String gratuityRecievedMilitary) {
		this.gratuityRecievedMilitary = gratuityRecievedMilitary;
	}

	/**
	 * Return the value associated with the column:
	 * gratuity_recieved_civil_service
	 */
	public java.lang.String getGratuityRecievedCivilService() {
		return gratuityRecievedCivilService;
	}

	/**
	 * Set the value related to the column: gratuity_recieved_civil_service
	 * 
	 * @param gratuityRecievedCivilService
	 *            the gratuity_recieved_civil_service value
	 */
	public void setGratuityRecievedCivilService(
			java.lang.String gratuityRecievedCivilService) {
		this.gratuityRecievedCivilService = gratuityRecievedCivilService;
	}

	/**
	 * Return the value associated with the column: no_demand_certificate
	 */
	public java.util.Date getNoDemandCertificate() {
		return noDemandCertificate;
	}

	/**
	 * Set the value related to the column: no_demand_certificate
	 * 
	 * @param noDemandCertificate
	 *            the no_demand_certificate value
	 */
	public void setNoDemandCertificate(java.util.Date noDemandCertificate) {
		this.noDemandCertificate = noDemandCertificate;
	}

	/**
	 * Return the value associated with the column: qualifying_pension
	 */
	public java.util.Date getQualifyingPension() {
		return qualifyingPension;
	}

	/**
	 * Set the value related to the column: qualifying_pension
	 * 
	 * @param qualifyingPension
	 *            the qualifying_pension value
	 */
	public void setQualifyingPension(java.util.Date qualifyingPension) {
		this.qualifyingPension = qualifyingPension;
	}

	/**
	 * Return the value associated with the column: dues_assessment
	 */
	public java.util.Date getDuesAssessment() {
		return duesAssessment;
	}

	/**
	 * Set the value related to the column: dues_assessment
	 * 
	 * @param duesAssessment
	 *            the dues_assessment value
	 */
	public void setDuesAssessment(java.util.Date duesAssessment) {
		this.duesAssessment = duesAssessment;
	}

	/**
	 * Return the value associated with the column: deficiencies
	 */
	public java.lang.String getDeficiencies() {
		return deficiencies;
	}

	/**
	 * Set the value related to the column: deficiencies
	 * 
	 * @param deficiencies
	 *            the deficiencies value
	 */
	public void setDeficiencies(java.lang.String deficiencies) {
		this.deficiencies = deficiencies;
	}

	/**
	 * Return the value associated with the column: interruption_in_service
	 */
	public java.lang.String getInterruptionInService() {
		return interruptionInService;
	}

	/**
	 * Set the value related to the column: interruption_in_service
	 * 
	 * @param interruptionInService
	 *            the interruption_in_service value
	 */
	public void setInterruptionInService(java.lang.String interruptionInService) {
		this.interruptionInService = interruptionInService;
	}

	/**
	 * Return the value associated with the column: suspension_period
	 */
	public java.lang.String getSuspensionPeriod() {
		return suspensionPeriod;
	}

	/**
	 * Set the value related to the column: suspension_period
	 * 
	 * @param suspensionPeriod
	 *            the suspension_period value
	 */
	public void setSuspensionPeriod(java.lang.String suspensionPeriod) {
		this.suspensionPeriod = suspensionPeriod;
	}

	/**
	 * Return the value associated with the column: other_service
	 */
	public java.lang.String getOtherService() {
		return otherService;
	}

	/**
	 * Set the value related to the column: other_service
	 * 
	 * @param otherService
	 *            the other_service value
	 */
	public void setOtherService(java.lang.String otherService) {
		this.otherService = otherService;
	}

	/**
	 * Return the value associated with the column: total
	 */
	public java.lang.String getTotal() {
		return total;
	}

	/**
	 * Set the value related to the column: total
	 * 
	 * @param total
	 *            the total value
	 */
	public void setTotal(java.lang.String total) {
		this.total = total;
	}

	/**
	 * Return the value associated with the column: form5_date
	 */
	public java.util.Date getForm5Date() {
		return form5Date;
	}

	/**
	 * Set the value related to the column: form5_date
	 * 
	 * @param form5Date
	 *            the form5_date value
	 */
	public void setForm5Date(java.util.Date form5Date) {
		this.form5Date = form5Date;
	}

	/**
	 * Return the value associated with the column: proposed_gratuity
	 */
	public java.math.BigDecimal getProposedGratuity() {
		return proposedGratuity;
	}

	/**
	 * Set the value related to the column: proposed_gratuity
	 * 
	 * @param proposedGratuity
	 *            the proposed_gratuity value
	 */
	public void setProposedGratuity(java.math.BigDecimal proposedGratuity) {
		this.proposedGratuity = proposedGratuity;
	}

	/**
	 * Return the value associated with the column: pension_date
	 */
	public java.util.Date getPensionDate() {
		return pensionDate;
	}

	/**
	 * Set the value related to the column: pension_date
	 * 
	 * @param pensionDate
	 *            the pension_date value
	 */
	public void setPensionDate(java.util.Date pensionDate) {
		this.pensionDate = pensionDate;
	}

	/**
	 * Return the value associated with the column: proposed_amount
	 */
	public java.math.BigDecimal getProposedAmount() {
		return proposedAmount;
	}

	/**
	 * Set the value related to the column: proposed_amount
	 * 
	 * @param proposedAmount
	 *            the proposed_amount value
	 */
	public void setProposedAmount(java.math.BigDecimal proposedAmount) {
		this.proposedAmount = proposedAmount;
	}

	/**
	 * Return the value associated with the column: licence_fee
	 */
	public java.math.BigDecimal getLicenceFee() {
		return licenceFee;
	}

	/**
	 * Set the value related to the column: licence_fee
	 * 
	 * @param licenceFee
	 *            the licence_fee value
	 */
	public void setLicenceFee(java.math.BigDecimal licenceFee) {
		this.licenceFee = licenceFee;
	}

	/**
	 * Return the value associated with the column: dues_referred
	 */
	public java.math.BigDecimal getDuesReferred() {
		return duesReferred;
	}

	/**
	 * Set the value related to the column: dues_referred
	 * 
	 * @param duesReferred
	 *            the dues_referred value
	 */
	public void setDuesReferred(java.math.BigDecimal duesReferred) {
		this.duesReferred = duesReferred;
	}

	/**
	 * Return the value associated with the column: nomination_for_gratuity
	 */
	public java.lang.String getNominationForGratuity() {
		return nominationForGratuity;
	}

	/**
	 * Set the value related to the column: nomination_for_gratuity
	 * 
	 * @param nominationForGratuity
	 *            the nomination_for_gratuity value
	 */
	public void setNominationForGratuity(java.lang.String nominationForGratuity) {
		this.nominationForGratuity = nominationForGratuity;
	}

	/**
	 * Return the value associated with the column: family_pension
	 */
	public java.lang.String getFamilyPension() {
		return familyPension;
	}

	/**
	 * Set the value related to the column: family_pension
	 * 
	 * @param familyPension
	 *            the family_pension value
	 */
	public void setFamilyPension(java.lang.String familyPension) {
		this.familyPension = familyPension;
	}

	/**
	 * Return the value associated with the column: place_of_payment
	 */
	public java.lang.String getPlaceOfPayment() {
		return placeOfPayment;
	}

	/**
	 * Set the value related to the column: place_of_payment
	 * 
	 * @param placeOfPayment
	 *            the place_of_payment value
	 */
	public void setPlaceOfPayment(java.lang.String placeOfPayment) {
		this.placeOfPayment = placeOfPayment;
	}

	/**
	 * Return the value associated with the column:
	 * account_head_pension_gratutity_debit
	 */
	public java.lang.String getAccountHeadPensionGratutityDebit() {
		return accountHeadPensionGratutityDebit;
	}

	/**
	 * Set the value related to the column: account_head_pension_gratutity_debit
	 * 
	 * @param accountHeadPensionGratutityDebit
	 *            the account_head_pension_gratutity_debit value
	 */
	public void setAccountHeadPensionGratutityDebit(
			java.lang.String accountHeadPensionGratutityDebit) {
		this.accountHeadPensionGratutityDebit = accountHeadPensionGratutityDebit;
	}

	/**
	 * Return the value associated with the column: emol_reckoning_gratuity
	 */
	public java.lang.String getEmolReckoningGratuity() {
		return emolReckoningGratuity;
	}

	/**
	 * Set the value related to the column: emol_reckoning_gratuity
	 * 
	 * @param emolReckoningGratuity
	 *            the emol_reckoning_gratuity value
	 */
	public void setEmolReckoningGratuity(java.lang.String emolReckoningGratuity) {
		this.emolReckoningGratuity = emolReckoningGratuity;
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
	 * Return the value associated with the column:
	 * PensionForm7EmolumentsDetails
	 */
	public java.util.Set<jkt.hms.masters.business.PensionForm7EmolumentsDetail> getPensionForm7EmolumentsDetails() {
		return pensionForm7EmolumentsDetails;
	}

	/**
	 * Set the value related to the column: PensionForm7EmolumentsDetails
	 * 
	 * @param pensionForm7EmolumentsDetails
	 *            the PensionForm7EmolumentsDetails value
	 */
	public void setPensionForm7EmolumentsDetails(
			java.util.Set<jkt.hms.masters.business.PensionForm7EmolumentsDetail> pensionForm7EmolumentsDetails) {
		this.pensionForm7EmolumentsDetails = pensionForm7EmolumentsDetails;
	}

	public void addToPensionForm7EmolumentsDetails(
			jkt.hms.masters.business.PensionForm7EmolumentsDetail pensionForm7EmolumentsDetail) {
		if (null == getPensionForm7EmolumentsDetails())
			setPensionForm7EmolumentsDetails(new java.util.TreeSet<jkt.hms.masters.business.PensionForm7EmolumentsDetail>());
		getPensionForm7EmolumentsDetails().add(pensionForm7EmolumentsDetail);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.PensionForm7Details))
			return false;
		else {
			jkt.hms.masters.business.PensionForm7Details pensionForm7Details = (jkt.hms.masters.business.PensionForm7Details) obj;
			if (null == this.getId() || null == pensionForm7Details.getId())
				return false;
			else
				return (this.getId().equals(pensionForm7Details.getId()));
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
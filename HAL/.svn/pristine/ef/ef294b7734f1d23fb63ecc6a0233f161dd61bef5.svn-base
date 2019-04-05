package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the pension_retirement_entry
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="pension_retirement_entry"
 */

public abstract class BasePensionRetirementEntry implements Serializable {

	public static String REF = "PensionRetirementEntry";
	public static String PROP_APPLICATION_DATE = "ApplicationDate";
	public static String PROP_DEATH_CUM_RETIREMENT_GRATUITY = "DeathCumRetirementGratuity";
	public static String PROP_FAMILY_PENSION = "FamilyPension";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_SUBSTANTIVE_APPOINTMENT = "SubstantiveAppointment";
	public static String PROP_GRATUITY_PENSION_RECIEVED = "GratuityPensionRecieved";
	public static String PROP_SUSPENSION_DEGRADATION = "SuspensionDegradation";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_PERSONNEL = "Personnel";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_INVOLVE_IN_INQUIRY = "InvolveInInquiry";
	public static String PROP_HEAD_OFFICE_OPINION = "HeadOfficeOpinion";
	public static String PROP_ID = "Id";

	// constructors
	public BasePensionRetirementEntry() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePensionRetirementEntry(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String substantiveAppointment;
	private java.lang.String deathCumRetirementGratuity;
	private java.lang.String familyPension;
	private java.util.Date applicationDate;
	private java.lang.String involveInInquiry;
	private java.lang.String suspensionDegradation;
	private java.lang.String gratuityPensionRecieved;
	private java.lang.String remarks;
	private java.lang.String headOfficeOpinion;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasPersonnelDetails personnel;

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
	 * Return the value associated with the column: substantive_appointment
	 */
	public java.lang.String getSubstantiveAppointment() {
		return substantiveAppointment;
	}

	/**
	 * Set the value related to the column: substantive_appointment
	 * 
	 * @param substantiveAppointment
	 *            the substantive_appointment value
	 */
	public void setSubstantiveAppointment(
			java.lang.String substantiveAppointment) {
		this.substantiveAppointment = substantiveAppointment;
	}

	/**
	 * Return the value associated with the column:
	 * death_cum_retirement_gratuity
	 */
	public java.lang.String getDeathCumRetirementGratuity() {
		return deathCumRetirementGratuity;
	}

	/**
	 * Set the value related to the column: death_cum_retirement_gratuity
	 * 
	 * @param deathCumRetirementGratuity
	 *            the death_cum_retirement_gratuity value
	 */
	public void setDeathCumRetirementGratuity(
			java.lang.String deathCumRetirementGratuity) {
		this.deathCumRetirementGratuity = deathCumRetirementGratuity;
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
	 * Return the value associated with the column: application_date
	 */
	public java.util.Date getApplicationDate() {
		return applicationDate;
	}

	/**
	 * Set the value related to the column: application_date
	 * 
	 * @param applicationDate
	 *            the application_date value
	 */
	public void setApplicationDate(java.util.Date applicationDate) {
		this.applicationDate = applicationDate;
	}

	/**
	 * Return the value associated with the column: involve_in_inquiry
	 */
	public java.lang.String getInvolveInInquiry() {
		return involveInInquiry;
	}

	/**
	 * Set the value related to the column: involve_in_inquiry
	 * 
	 * @param involveInInquiry
	 *            the involve_in_inquiry value
	 */
	public void setInvolveInInquiry(java.lang.String involveInInquiry) {
		this.involveInInquiry = involveInInquiry;
	}

	/**
	 * Return the value associated with the column: suspension_degradation
	 */
	public java.lang.String getSuspensionDegradation() {
		return suspensionDegradation;
	}

	/**
	 * Set the value related to the column: suspension_degradation
	 * 
	 * @param suspensionDegradation
	 *            the suspension_degradation value
	 */
	public void setSuspensionDegradation(java.lang.String suspensionDegradation) {
		this.suspensionDegradation = suspensionDegradation;
	}

	/**
	 * Return the value associated with the column: gratuity_pension_recieved
	 */
	public java.lang.String getGratuityPensionRecieved() {
		return gratuityPensionRecieved;
	}

	/**
	 * Set the value related to the column: gratuity_pension_recieved
	 * 
	 * @param gratuityPensionRecieved
	 *            the gratuity_pension_recieved value
	 */
	public void setGratuityPensionRecieved(
			java.lang.String gratuityPensionRecieved) {
		this.gratuityPensionRecieved = gratuityPensionRecieved;
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
	 * Return the value associated with the column: head_office_opinion
	 */
	public java.lang.String getHeadOfficeOpinion() {
		return headOfficeOpinion;
	}

	/**
	 * Set the value related to the column: head_office_opinion
	 * 
	 * @param headOfficeOpinion
	 *            the head_office_opinion value
	 */
	public void setHeadOfficeOpinion(java.lang.String headOfficeOpinion) {
		this.headOfficeOpinion = headOfficeOpinion;
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

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.PensionRetirementEntry))
			return false;
		else {
			jkt.hms.masters.business.PensionRetirementEntry pensionRetirementEntry = (jkt.hms.masters.business.PensionRetirementEntry) obj;
			if (null == this.getId() || null == pensionRetirementEntry.getId())
				return false;
			else
				return (this.getId().equals(pensionRetirementEntry.getId()));
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
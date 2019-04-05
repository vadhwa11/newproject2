package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_company table. Do not
 * modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * 
 * @hibernate.class table="mas_company"
 */

public abstract class BaseMasCompany implements Serializable {

	public static String REF = "MasCompany";
	public static String PROP_STATUS = "Status";
	public static String PROP_COMPANY_CODE = "CompanyCode";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_COORDINATOR_CODE = "CoordinatorCode";
	public static String PROP_TELEPHONE = "Telephone";
	public static String PROP_CONTACT_PERSON = "ContactPerson";
	public static String PROP_PATIENT_STATUS = "PatientStatus";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ID = "Id";
	public static String PROP_PATIENT_TYPE = "PatientType";
	public static String PROP_COMPANY_NAME = "CompanyName";

	// constructors
	public BaseMasCompany() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasCompany(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String companyCode;
	private java.lang.String companyName;
	private java.lang.String coordinatorCode;
	private java.lang.String patientStatus;
	private java.lang.String contactPerson;
	private java.lang.String telephone;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasPatientType patientType;

	// collections
	private java.util.Set<jkt.hms.masters.business.MasDiscount> masDiscounts;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="company_id"
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
	 * Return the value associated with the column: company_code
	 */
	public java.lang.String getCompanyCode() {
		return companyCode;
	}

	/**
	 * Set the value related to the column: company_code
	 * 
	 * @param companyCode
	 *            the company_code value
	 */
	public void setCompanyCode(java.lang.String companyCode) {
		this.companyCode = companyCode;
	}

	/**
	 * Return the value associated with the column: company_name
	 */
	public java.lang.String getCompanyName() {
		return companyName;
	}

	/**
	 * Set the value related to the column: company_name
	 * 
	 * @param companyName
	 *            the company_name value
	 */
	public void setCompanyName(java.lang.String companyName) {
		this.companyName = companyName;
	}

	/**
	 * Return the value associated with the column: coordinator_code
	 */
	public java.lang.String getCoordinatorCode() {
		return coordinatorCode;
	}

	/**
	 * Set the value related to the column: coordinator_code
	 * 
	 * @param coordinatorCode
	 *            the coordinator_code value
	 */
	public void setCoordinatorCode(java.lang.String coordinatorCode) {
		this.coordinatorCode = coordinatorCode;
	}

	/**
	 * Return the value associated with the column: patient_status
	 */
	public java.lang.String getPatientStatus() {
		return patientStatus;
	}

	/**
	 * Set the value related to the column: patient_status
	 * 
	 * @param patientStatus
	 *            the patient_status value
	 */
	public void setPatientStatus(java.lang.String patientStatus) {
		this.patientStatus = patientStatus;
	}

	/**
	 * Return the value associated with the column: contact_person
	 */
	public java.lang.String getContactPerson() {
		return contactPerson;
	}

	/**
	 * Set the value related to the column: contact_person
	 * 
	 * @param contactPerson
	 *            the contact_person value
	 */
	public void setContactPerson(java.lang.String contactPerson) {
		this.contactPerson = contactPerson;
	}

	/**
	 * Return the value associated with the column: telephone
	 */
	public java.lang.String getTelephone() {
		return telephone;
	}

	/**
	 * Set the value related to the column: telephone
	 * 
	 * @param telephone
	 *            the telephone value
	 */
	public void setTelephone(java.lang.String telephone) {
		this.telephone = telephone;
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
	 * Return the value associated with the column: patient_type_id
	 */
	public jkt.hms.masters.business.MasPatientType getPatientType() {
		return patientType;
	}

	/**
	 * Set the value related to the column: patient_type_id
	 * 
	 * @param patientType
	 *            the patient_type_id value
	 */
	public void setPatientType(
			jkt.hms.masters.business.MasPatientType patientType) {
		this.patientType = patientType;
	}

	/**
	 * Return the value associated with the column: MasDiscounts
	 */
	public java.util.Set<jkt.hms.masters.business.MasDiscount> getMasDiscounts() {
		return masDiscounts;
	}

	/**
	 * Set the value related to the column: MasDiscounts
	 * 
	 * @param masDiscounts
	 *            the MasDiscounts value
	 */
	public void setMasDiscounts(
			java.util.Set<jkt.hms.masters.business.MasDiscount> masDiscounts) {
		this.masDiscounts = masDiscounts;
	}

	public void addToMasDiscounts(
			jkt.hms.masters.business.MasDiscount masDiscount) {
		if (null == getMasDiscounts())
			setMasDiscounts(new java.util.TreeSet<jkt.hms.masters.business.MasDiscount>());
		getMasDiscounts().add(masDiscount);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MasCompany))
			return false;
		else {
			jkt.hms.masters.business.MasCompany masCompany = (jkt.hms.masters.business.MasCompany) obj;
			if (null == this.getId() || null == masCompany.getId())
				return false;
			else
				return (this.getId().equals(masCompany.getId()));
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
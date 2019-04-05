package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the birthdeathreg table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="birthdeathreg"
 */

public abstract class BaseBirthdeathreg implements Serializable {

	public static String REF = "Birthdeathreg";
	public static String PROP_DOD = "Dod";
	public static String PROP_NO_OF_COPIES = "NoOfCopies";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_DOB = "Dob";
	public static String PROP_ADDRESS_DEATH = "AddressDeath";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_TIME = "Time";
	public static String PROP_EMP = "Emp";
	public static String PROP_DATE_OF_ISSUE = "DateOfIssue";
	public static String PROP_ADDRESS_PERMANENT = "AddressPermanent";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_BDTYPE = "Bdtype";
	public static String PROP_AMOUNT = "Amount";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_EXPIRY_DETAILS = "ExpiryDetails";
	public static String PROP_MNAME = "Mname";
	public static String PROP_NAME = "Name";
	public static String PROP_FNAME = "Fname";
	public static String PROP_ID = "Id";
	public static String PROP_ADMINISTRATIVE_SEX = "AdministrativeSex";
	public static String PROP_HIN = "Hin";
	public static String PROP_DOR = "Dor";
	public static String PROP_REGNO = "Regno";

	// constructors
	public BaseBirthdeathreg() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBirthdeathreg(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String regno;
	private java.lang.String name;
	private java.lang.String fname;
	private java.lang.String mname;
	private java.util.Date dob;
	private java.util.Date dor;
	private java.lang.String bdtype;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.util.Date dod;
	private java.util.Date dateOfIssue;
	private java.lang.String remarks;
	private java.lang.String addressDeath;
	private java.lang.String addressPermanent;
	private java.lang.Integer amount;
	private java.lang.Integer noOfCopies;
	private java.lang.String time;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.MasEmployee emp;
	private jkt.hms.masters.business.ExpiryDetails expiryDetails;
	private jkt.hms.masters.business.MasAdministrativeSex administrativeSex;
	private jkt.hms.masters.business.Patient hin;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="birthdeath_id"
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
	 * Return the value associated with the column: Regno
	 */
	public java.lang.String getRegno() {
		return regno;
	}

	/**
	 * Set the value related to the column: Regno
	 * 
	 * @param regno
	 *            the Regno value
	 */
	public void setRegno(java.lang.String regno) {
		this.regno = regno;
	}

	/**
	 * Return the value associated with the column: Name
	 */
	public java.lang.String getName() {
		return name;
	}

	/**
	 * Set the value related to the column: Name
	 * 
	 * @param name
	 *            the Name value
	 */
	public void setName(java.lang.String name) {
		this.name = name;
	}

	/**
	 * Return the value associated with the column: fname
	 */
	public java.lang.String getFname() {
		return fname;
	}

	/**
	 * Set the value related to the column: fname
	 * 
	 * @param fname
	 *            the fname value
	 */
	public void setFname(java.lang.String fname) {
		this.fname = fname;
	}

	/**
	 * Return the value associated with the column: mname
	 */
	public java.lang.String getMname() {
		return mname;
	}

	/**
	 * Set the value related to the column: mname
	 * 
	 * @param mname
	 *            the mname value
	 */
	public void setMname(java.lang.String mname) {
		this.mname = mname;
	}

	/**
	 * Return the value associated with the column: DOB
	 */
	public java.util.Date getDob() {
		return dob;
	}

	/**
	 * Set the value related to the column: DOB
	 * 
	 * @param dob
	 *            the DOB value
	 */
	public void setDob(java.util.Date dob) {
		this.dob = dob;
	}

	/**
	 * Return the value associated with the column: DOR
	 */
	public java.util.Date getDor() {
		return dor;
	}

	/**
	 * Set the value related to the column: DOR
	 * 
	 * @param dor
	 *            the DOR value
	 */
	public void setDor(java.util.Date dor) {
		this.dor = dor;
	}

	/**
	 * Return the value associated with the column: bdtype
	 */
	public java.lang.String getBdtype() {
		return bdtype;
	}

	/**
	 * Set the value related to the column: bdtype
	 * 
	 * @param bdtype
	 *            the bdtype value
	 */
	public void setBdtype(java.lang.String bdtype) {
		this.bdtype = bdtype;
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
	 * Return the value associated with the column: DOD
	 */
	public java.util.Date getDod() {
		return dod;
	}

	/**
	 * Set the value related to the column: DOD
	 * 
	 * @param dod
	 *            the DOD value
	 */
	public void setDod(java.util.Date dod) {
		this.dod = dod;
	}

	/**
	 * Return the value associated with the column: date_of_issue
	 */
	public java.util.Date getDateOfIssue() {
		return dateOfIssue;
	}

	/**
	 * Set the value related to the column: date_of_issue
	 * 
	 * @param dateOfIssue
	 *            the date_of_issue value
	 */
	public void setDateOfIssue(java.util.Date dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
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
	 * Return the value associated with the column: address_death
	 */
	public java.lang.String getAddressDeath() {
		return addressDeath;
	}

	/**
	 * Set the value related to the column: address_death
	 * 
	 * @param addressDeath
	 *            the address_death value
	 */
	public void setAddressDeath(java.lang.String addressDeath) {
		this.addressDeath = addressDeath;
	}

	/**
	 * Return the value associated with the column: address_permanent
	 */
	public java.lang.String getAddressPermanent() {
		return addressPermanent;
	}

	/**
	 * Set the value related to the column: address_permanent
	 * 
	 * @param addressPermanent
	 *            the address_permanent value
	 */
	public void setAddressPermanent(java.lang.String addressPermanent) {
		this.addressPermanent = addressPermanent;
	}

	/**
	 * Return the value associated with the column: amount
	 */
	public java.lang.Integer getAmount() {
		return amount;
	}

	/**
	 * Set the value related to the column: amount
	 * 
	 * @param amount
	 *            the amount value
	 */
	public void setAmount(java.lang.Integer amount) {
		this.amount = amount;
	}

	/**
	 * Return the value associated with the column: no_of_copies
	 */
	public java.lang.Integer getNoOfCopies() {
		return noOfCopies;
	}

	/**
	 * Set the value related to the column: no_of_copies
	 * 
	 * @param noOfCopies
	 *            the no_of_copies value
	 */
	public void setNoOfCopies(java.lang.Integer noOfCopies) {
		this.noOfCopies = noOfCopies;
	}

	/**
	 * Return the value associated with the column: time
	 */
	public java.lang.String getTime() {
		return time;
	}

	/**
	 * Set the value related to the column: time
	 * 
	 * @param time
	 *            the time value
	 */
	public void setTime(java.lang.String time) {
		this.time = time;
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
	 * Return the value associated with the column: emp_id
	 */
	public jkt.hms.masters.business.MasEmployee getEmp() {
		return emp;
	}

	/**
	 * Set the value related to the column: emp_id
	 * 
	 * @param emp
	 *            the emp_id value
	 */
	public void setEmp(jkt.hms.masters.business.MasEmployee emp) {
		this.emp = emp;
	}

	/**
	 * Return the value associated with the column: expiry_details_id
	 */
	public jkt.hms.masters.business.ExpiryDetails getExpiryDetails() {
		return expiryDetails;
	}

	/**
	 * Set the value related to the column: expiry_details_id
	 * 
	 * @param expiryDetails
	 *            the expiry_details_id value
	 */
	public void setExpiryDetails(
			jkt.hms.masters.business.ExpiryDetails expiryDetails) {
		this.expiryDetails = expiryDetails;
	}

	/**
	 * Return the value associated with the column: administrative_sex_id
	 */
	public jkt.hms.masters.business.MasAdministrativeSex getAdministrativeSex() {
		return administrativeSex;
	}

	/**
	 * Set the value related to the column: administrative_sex_id
	 * 
	 * @param administrativeSex
	 *            the administrative_sex_id value
	 */
	public void setAdministrativeSex(
			jkt.hms.masters.business.MasAdministrativeSex administrativeSex) {
		this.administrativeSex = administrativeSex;
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
		if (!(obj instanceof jkt.hms.masters.business.Birthdeathreg))
			return false;
		else {
			jkt.hms.masters.business.Birthdeathreg birthdeathreg = (jkt.hms.masters.business.Birthdeathreg) obj;
			if (null == this.getId() || null == birthdeathreg.getId())
				return false;
			else
				return (this.getId().equals(birthdeathreg.getId()));
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
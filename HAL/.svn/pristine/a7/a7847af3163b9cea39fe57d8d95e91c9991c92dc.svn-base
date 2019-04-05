package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the expiry_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="expiry_details"
 */

public abstract class BaseExpiryDetails  implements Serializable {

	public static String REF = "ExpiryDetails";
	public static String PROP_S_DEATH_CAUSE_TEXT = "SDeathCauseText";
	public static String PROP_DEATH_CERTIFICATE_NO = "DeathCertificateNo";
	public static String PROP_WARD = "Ward";
	public static String PROP_INFORMANT_NAME = "InformantName";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_ADD_EDIT_DATE = "AddEditDate";
	public static String PROP_C_DEATH_CAUSE_TEXT = "CDeathCauseText";
	public static String PROP_ID_MARKS2 = "IdMarks2";
	public static String PROP_INFORMANT_RELATION = "InformantRelation";
	public static String PROP_ID_MARKS1 = "IdMarks1";
	public static String PROP_PALCE_OF_DEATH = "palceOfDeath";
	public static String PROP_ADD_EDIT_BY = "AddEditBy";
	public static String PROP_ADD_EDIT_TIME = "AddEditTime";
	public static String PROP_INFORMANT_BLOCK = "InformantBlock";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_EXPIRY_TIME = "ExpiryTime";
	public static String PROP_INFORMANT_ADDRESS = "InformantAddress";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_INFORMANT_STATE = "InformantState";
	public static String PROP_D_DEATH_CAUSE = "DDeathCause";
	public static String PROP_CONSEQUENCE_OF = "ConsequenceOf";
	public static String PROP_C_DEATH_CAUSE = "CDeathCause";
	public static String PROP_INFORMANT_COUNTRY = "InformantCountry";
	public static String PROP_EXPIRY_DATE = "ExpiryDate";
	public static String PROP_INFORMANT_DISTRICT = "InformantDistrict";
	public static String PROP_ID = "Id";
	public static String PROP_D_DEATH_CAUSE_TEXT = "DDeathCauseText";
	public static String PROP_CAUSE_OF_DEATH = "causeOfDeath";
	public static String PROP_S_DEATH_CAUSE = "SDeathCause";
	public static String PROP_HIN = "Hin";
	public static String PROP_DEATH_CERTIFICATE_TAKEN_BY = "DeathCertificateTakenBy";
	public static String PROP_BED = "Bed";


	// constructors
	public BaseExpiryDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseExpiryDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String deathCertificateNo;
	private java.lang.String informantName;
	private java.lang.String informantAddress;
	private java.lang.String deathCertificateTakenBy;
	private java.util.Date expiryDate;
	private java.lang.String expiryTime;
	private java.util.Date addEditDate;
	private java.lang.String addEditTime;
	private java.lang.String palceOfDeath;
	private java.lang.String causeOfDeath;
	private java.lang.String dDeathCauseText;
	private java.lang.String sDeathCauseText;
	private java.lang.String cDeathCauseText;
	private java.lang.String consequenceOf;
	private java.lang.String idMarks1;
	private java.lang.String idMarks2;
	private java.lang.String remarks;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasBlock informantBlock;
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.Users addEditBy;
	private jkt.hms.masters.business.MasDistrict informantDistrict;
	private jkt.hms.masters.business.MasRelation informantRelation;
	private jkt.hms.masters.business.MasState informantState;
	private jkt.hms.masters.business.MasBed bed;
	private jkt.hms.masters.business.MasCountry informantCountry;
	private jkt.hms.masters.business.MasDeathCause dDeathCause;
	private jkt.hms.masters.business.MasDeathCause cDeathCause;
	private jkt.hms.masters.business.MasDeathCause sDeathCause;
	private jkt.hms.masters.business.MasDepartment ward;
	private jkt.hms.masters.business.Patient hin;

	// collections
	private java.util.Set<jkt.hms.masters.business.Birthdeathreg> birthdeathreg;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="expiry_details_id"
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
	 * Return the value associated with the column: death_certificate_no
	 */
	public java.lang.String getDeathCertificateNo () {
		return deathCertificateNo;
	}

	/**
	 * Set the value related to the column: death_certificate_no
	 * @param deathCertificateNo the death_certificate_no value
	 */
	public void setDeathCertificateNo (java.lang.String deathCertificateNo) {
		this.deathCertificateNo = deathCertificateNo;
	}



	/**
	 * Return the value associated with the column: informant_name
	 */
	public java.lang.String getInformantName () {
		return informantName;
	}

	/**
	 * Set the value related to the column: informant_name
	 * @param informantName the informant_name value
	 */
	public void setInformantName (java.lang.String informantName) {
		this.informantName = informantName;
	}



	/**
	 * Return the value associated with the column: informant_address
	 */
	public java.lang.String getInformantAddress () {
		return informantAddress;
	}

	/**
	 * Set the value related to the column: informant_address
	 * @param informantAddress the informant_address value
	 */
	public void setInformantAddress (java.lang.String informantAddress) {
		this.informantAddress = informantAddress;
	}



	/**
	 * Return the value associated with the column: death_certificate_taken_by
	 */
	public java.lang.String getDeathCertificateTakenBy () {
		return deathCertificateTakenBy;
	}

	/**
	 * Set the value related to the column: death_certificate_taken_by
	 * @param deathCertificateTakenBy the death_certificate_taken_by value
	 */
	public void setDeathCertificateTakenBy (java.lang.String deathCertificateTakenBy) {
		this.deathCertificateTakenBy = deathCertificateTakenBy;
	}



	/**
	 * Return the value associated with the column: expiry_date
	 */
	public java.util.Date getExpiryDate () {
		return expiryDate;
	}

	/**
	 * Set the value related to the column: expiry_date
	 * @param expiryDate the expiry_date value
	 */
	public void setExpiryDate (java.util.Date expiryDate) {
		this.expiryDate = expiryDate;
	}



	/**
	 * Return the value associated with the column: expiry_time
	 */
	public java.lang.String getExpiryTime () {
		return expiryTime;
	}

	/**
	 * Set the value related to the column: expiry_time
	 * @param expiryTime the expiry_time value
	 */
	public void setExpiryTime (java.lang.String expiryTime) {
		this.expiryTime = expiryTime;
	}



	/**
	 * Return the value associated with the column: add_edit_date
	 */
	public java.util.Date getAddEditDate () {
		return addEditDate;
	}

	/**
	 * Set the value related to the column: add_edit_date
	 * @param addEditDate the add_edit_date value
	 */
	public void setAddEditDate (java.util.Date addEditDate) {
		this.addEditDate = addEditDate;
	}



	/**
	 * Return the value associated with the column: add_edit_time
	 */
	public java.lang.String getAddEditTime () {
		return addEditTime;
	}

	/**
	 * Set the value related to the column: add_edit_time
	 * @param addEditTime the add_edit_time value
	 */
	public void setAddEditTime (java.lang.String addEditTime) {
		this.addEditTime = addEditTime;
	}



	/**
	 * Return the value associated with the column: place_of_death
	 */
	public java.lang.String getPalceOfDeath () {
		return palceOfDeath;
	}

	/**
	 * Set the value related to the column: place_of_death
	 * @param palceOfDeath the place_of_death value
	 */
	public void setPalceOfDeath (java.lang.String palceOfDeath) {
		this.palceOfDeath = palceOfDeath;
	}



	/**
	 * Return the value associated with the column: CAUSE_OF_DEATH
	 */
	public java.lang.String getCauseOfDeath () {
		return causeOfDeath;
	}

	/**
	 * Set the value related to the column: CAUSE_OF_DEATH
	 * @param causeOfDeath the CAUSE_OF_DEATH value
	 */
	public void setCauseOfDeath (java.lang.String causeOfDeath) {
		this.causeOfDeath = causeOfDeath;
	}



	/**
	 * Return the value associated with the column: d_death_cause_text
	 */
	public java.lang.String getDDeathCauseText () {
		return dDeathCauseText;
	}

	/**
	 * Set the value related to the column: d_death_cause_text
	 * @param dDeathCauseText the d_death_cause_text value
	 */
	public void setDDeathCauseText (java.lang.String dDeathCauseText) {
		this.dDeathCauseText = dDeathCauseText;
	}



	/**
	 * Return the value associated with the column: s_death_cause_text
	 */
	public java.lang.String getSDeathCauseText () {
		return sDeathCauseText;
	}

	/**
	 * Set the value related to the column: s_death_cause_text
	 * @param sDeathCauseText the s_death_cause_text value
	 */
	public void setSDeathCauseText (java.lang.String sDeathCauseText) {
		this.sDeathCauseText = sDeathCauseText;
	}



	/**
	 * Return the value associated with the column: c_death_cause_text
	 */
	public java.lang.String getCDeathCauseText () {
		return cDeathCauseText;
	}

	/**
	 * Set the value related to the column: c_death_cause_text
	 * @param cDeathCauseText the c_death_cause_text value
	 */
	public void setCDeathCauseText (java.lang.String cDeathCauseText) {
		this.cDeathCauseText = cDeathCauseText;
	}



	/**
	 * Return the value associated with the column: consequence_of
	 */
	public java.lang.String getConsequenceOf () {
		return consequenceOf;
	}

	/**
	 * Set the value related to the column: consequence_of
	 * @param consequenceOf the consequence_of value
	 */
	public void setConsequenceOf (java.lang.String consequenceOf) {
		this.consequenceOf = consequenceOf;
	}



	/**
	 * Return the value associated with the column: id_marks1
	 */
	public java.lang.String getIdMarks1 () {
		return idMarks1;
	}

	/**
	 * Set the value related to the column: id_marks1
	 * @param idMarks1 the id_marks1 value
	 */
	public void setIdMarks1 (java.lang.String idMarks1) {
		this.idMarks1 = idMarks1;
	}



	/**
	 * Return the value associated with the column: id_marks2
	 */
	public java.lang.String getIdMarks2 () {
		return idMarks2;
	}

	/**
	 * Set the value related to the column: id_marks2
	 * @param idMarks2 the id_marks2 value
	 */
	public void setIdMarks2 (java.lang.String idMarks2) {
		this.idMarks2 = idMarks2;
	}



	/**
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * @param remarks the remarks value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
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
	 * Return the value associated with the column: informant_block_id
	 */
	public jkt.hms.masters.business.MasBlock getInformantBlock () {
		return informantBlock;
	}

	/**
	 * Set the value related to the column: informant_block_id
	 * @param informantBlock the informant_block_id value
	 */
	public void setInformantBlock (jkt.hms.masters.business.MasBlock informantBlock) {
		this.informantBlock = informantBlock;
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
	 * Return the value associated with the column: add_edit_by_id
	 */
	public jkt.hms.masters.business.Users getAddEditBy () {
		return addEditBy;
	}

	/**
	 * Set the value related to the column: add_edit_by_id
	 * @param addEditBy the add_edit_by_id value
	 */
	public void setAddEditBy (jkt.hms.masters.business.Users addEditBy) {
		this.addEditBy = addEditBy;
	}



	/**
	 * Return the value associated with the column: informant_district_id
	 */
	public jkt.hms.masters.business.MasDistrict getInformantDistrict () {
		return informantDistrict;
	}

	/**
	 * Set the value related to the column: informant_district_id
	 * @param informantDistrict the informant_district_id value
	 */
	public void setInformantDistrict (jkt.hms.masters.business.MasDistrict informantDistrict) {
		this.informantDistrict = informantDistrict;
	}



	/**
	 * Return the value associated with the column: informant_relation_id
	 */
	public jkt.hms.masters.business.MasRelation getInformantRelation () {
		return informantRelation;
	}

	/**
	 * Set the value related to the column: informant_relation_id
	 * @param informantRelation the informant_relation_id value
	 */
	public void setInformantRelation (jkt.hms.masters.business.MasRelation informantRelation) {
		this.informantRelation = informantRelation;
	}



	/**
	 * Return the value associated with the column: informant_state_id
	 */
	public jkt.hms.masters.business.MasState getInformantState () {
		return informantState;
	}

	/**
	 * Set the value related to the column: informant_state_id
	 * @param informantState the informant_state_id value
	 */
	public void setInformantState (jkt.hms.masters.business.MasState informantState) {
		this.informantState = informantState;
	}



	/**
	 * Return the value associated with the column: bed_id
	 */
	public jkt.hms.masters.business.MasBed getBed () {
		return bed;
	}

	/**
	 * Set the value related to the column: bed_id
	 * @param bed the bed_id value
	 */
	public void setBed (jkt.hms.masters.business.MasBed bed) {
		this.bed = bed;
	}



	/**
	 * Return the value associated with the column: informant_country_id
	 */
	public jkt.hms.masters.business.MasCountry getInformantCountry () {
		return informantCountry;
	}

	/**
	 * Set the value related to the column: informant_country_id
	 * @param informantCountry the informant_country_id value
	 */
	public void setInformantCountry (jkt.hms.masters.business.MasCountry informantCountry) {
		this.informantCountry = informantCountry;
	}



	/**
	 * Return the value associated with the column: d_death_cause_id
	 */
	public jkt.hms.masters.business.MasDeathCause getDDeathCause () {
		return dDeathCause;
	}

	/**
	 * Set the value related to the column: d_death_cause_id
	 * @param dDeathCause the d_death_cause_id value
	 */
	public void setDDeathCause (jkt.hms.masters.business.MasDeathCause dDeathCause) {
		this.dDeathCause = dDeathCause;
	}



	/**
	 * Return the value associated with the column: c_death_cause_id
	 */
	public jkt.hms.masters.business.MasDeathCause getCDeathCause () {
		return cDeathCause;
	}

	/**
	 * Set the value related to the column: c_death_cause_id
	 * @param cDeathCause the c_death_cause_id value
	 */
	public void setCDeathCause (jkt.hms.masters.business.MasDeathCause cDeathCause) {
		this.cDeathCause = cDeathCause;
	}



	/**
	 * Return the value associated with the column: s_death_cause_id
	 */
	public jkt.hms.masters.business.MasDeathCause getSDeathCause () {
		return sDeathCause;
	}

	/**
	 * Set the value related to the column: s_death_cause_id
	 * @param sDeathCause the s_death_cause_id value
	 */
	public void setSDeathCause (jkt.hms.masters.business.MasDeathCause sDeathCause) {
		this.sDeathCause = sDeathCause;
	}



	/**
	 * Return the value associated with the column: ward_id
	 */
	public jkt.hms.masters.business.MasDepartment getWard () {
		return ward;
	}

	/**
	 * Set the value related to the column: ward_id
	 * @param ward the ward_id value
	 */
	public void setWard (jkt.hms.masters.business.MasDepartment ward) {
		this.ward = ward;
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
	 * Return the value associated with the column: Birthdeathreg
	 */
	public java.util.Set<jkt.hms.masters.business.Birthdeathreg> getBirthdeathreg () {
		return birthdeathreg;
	}

	/**
	 * Set the value related to the column: Birthdeathreg
	 * @param birthdeathreg the Birthdeathreg value
	 */
	public void setBirthdeathreg (java.util.Set<jkt.hms.masters.business.Birthdeathreg> birthdeathreg) {
		this.birthdeathreg = birthdeathreg;
	}

	public void addToBirthdeathreg (jkt.hms.masters.business.Birthdeathreg birthdeathreg) {
		if (null == getBirthdeathreg()) setBirthdeathreg(new java.util.TreeSet<jkt.hms.masters.business.Birthdeathreg>());
		getBirthdeathreg().add(birthdeathreg);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.ExpiryDetails)) return false;
		else {
			jkt.hms.masters.business.ExpiryDetails expiryDetails = (jkt.hms.masters.business.ExpiryDetails) obj;
			if (null == this.getId() || null == expiryDetails.getId()) return false;
			else return (this.getId().equals(expiryDetails.getId()));
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
package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mis_notifiable table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mis_notifiable"
 */

public abstract class BaseMisNotifiable  implements Serializable {

	public static String REF = "MisNotifiable";
	public static String PROP_ICD = "Icd";
	public static String PROP_NOTIFIABLE_DATE = "NotifiableDate";
	public static String PROP_DISINFECTION = "Disinfection";
	public static String PROP_DATE_ON_SET_DATE = "DateOnSetDate";
	public static String PROP_CLINICAL = "Clinical";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_CONTACT = "Contact";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_DESIGNATION_OF_QUATERS = "DesignationOfQuaters";
	public static String PROP_DATE_OF_PREVENTIVE = "DateOfPreventive";
	public static String PROP_GENERAL_REMARKS = "GeneralRemarks";
	public static String PROP_SUSPECTED_SOURCE = "SuspectedSource";
	public static String PROP_MEASURES_OF_CONTROL = "MeasuresOfControl";
	public static String PROP_BACTERIOLOGICAL = "Bacteriological";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_HIN = "Hin";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_DATE_OF_REPORTING_SICK = "DateOfReportingSick";


	// constructors
	public BaseMisNotifiable () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMisNotifiable (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date notifiableDate;
	private java.util.Date dateOnSetDate;
	private java.lang.String designationOfQuaters;
	private java.util.Date dateOfReportingSick;
	private java.lang.String suspectedSource;
	private java.lang.String measuresOfControl;
	private java.lang.String contact;
	private java.util.Date dateOfPreventive;
	private java.lang.String generalRemarks;
	private java.lang.String disinfection;
	private java.lang.String bacteriological;
	private java.lang.String clinical;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasIcd icd;
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.Patient hin;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="notifiable_id"
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
	 * Return the value associated with the column: notifiable_date
	 */
	public java.util.Date getNotifiableDate () {
		return notifiableDate;
	}

	/**
	 * Set the value related to the column: notifiable_date
	 * @param notifiableDate the notifiable_date value
	 */
	public void setNotifiableDate (java.util.Date notifiableDate) {
		this.notifiableDate = notifiableDate;
	}



	/**
	 * Return the value associated with the column: date_on_set_date
	 */
	public java.util.Date getDateOnSetDate () {
		return dateOnSetDate;
	}

	/**
	 * Set the value related to the column: date_on_set_date
	 * @param dateOnSetDate the date_on_set_date value
	 */
	public void setDateOnSetDate (java.util.Date dateOnSetDate) {
		this.dateOnSetDate = dateOnSetDate;
	}



	/**
	 * Return the value associated with the column: designation_of_quaters
	 */
	public java.lang.String getDesignationOfQuaters () {
		return designationOfQuaters;
	}

	/**
	 * Set the value related to the column: designation_of_quaters
	 * @param designationOfQuaters the designation_of_quaters value
	 */
	public void setDesignationOfQuaters (java.lang.String designationOfQuaters) {
		this.designationOfQuaters = designationOfQuaters;
	}



	/**
	 * Return the value associated with the column: date_of_reporting_sick
	 */
	public java.util.Date getDateOfReportingSick () {
		return dateOfReportingSick;
	}

	/**
	 * Set the value related to the column: date_of_reporting_sick
	 * @param dateOfReportingSick the date_of_reporting_sick value
	 */
	public void setDateOfReportingSick (java.util.Date dateOfReportingSick) {
		this.dateOfReportingSick = dateOfReportingSick;
	}



	/**
	 * Return the value associated with the column: suspected_source
	 */
	public java.lang.String getSuspectedSource () {
		return suspectedSource;
	}

	/**
	 * Set the value related to the column: suspected_source
	 * @param suspectedSource the suspected_source value
	 */
	public void setSuspectedSource (java.lang.String suspectedSource) {
		this.suspectedSource = suspectedSource;
	}



	/**
	 * Return the value associated with the column: measures_of_control
	 */
	public java.lang.String getMeasuresOfControl () {
		return measuresOfControl;
	}

	/**
	 * Set the value related to the column: measures_of_control
	 * @param measuresOfControl the measures_of_control value
	 */
	public void setMeasuresOfControl (java.lang.String measuresOfControl) {
		this.measuresOfControl = measuresOfControl;
	}



	/**
	 * Return the value associated with the column: contact
	 */
	public java.lang.String getContact () {
		return contact;
	}

	/**
	 * Set the value related to the column: contact
	 * @param contact the contact value
	 */
	public void setContact (java.lang.String contact) {
		this.contact = contact;
	}



	/**
	 * Return the value associated with the column: date_of_preventive
	 */
	public java.util.Date getDateOfPreventive () {
		return dateOfPreventive;
	}

	/**
	 * Set the value related to the column: date_of_preventive
	 * @param dateOfPreventive the date_of_preventive value
	 */
	public void setDateOfPreventive (java.util.Date dateOfPreventive) {
		this.dateOfPreventive = dateOfPreventive;
	}



	/**
	 * Return the value associated with the column: general_remarks
	 */
	public java.lang.String getGeneralRemarks () {
		return generalRemarks;
	}

	/**
	 * Set the value related to the column: general_remarks
	 * @param generalRemarks the general_remarks value
	 */
	public void setGeneralRemarks (java.lang.String generalRemarks) {
		this.generalRemarks = generalRemarks;
	}



	/**
	 * Return the value associated with the column: DISINFECTION
	 */
	public java.lang.String getDisinfection () {
		return disinfection;
	}

	/**
	 * Set the value related to the column: DISINFECTION
	 * @param disinfection the DISINFECTION value
	 */
	public void setDisinfection (java.lang.String disinfection) {
		this.disinfection = disinfection;
	}



	/**
	 * Return the value associated with the column: BACTERIOLOGICAL
	 */
	public java.lang.String getBacteriological () {
		return bacteriological;
	}

	/**
	 * Set the value related to the column: BACTERIOLOGICAL
	 * @param bacteriological the BACTERIOLOGICAL value
	 */
	public void setBacteriological (java.lang.String bacteriological) {
		this.bacteriological = bacteriological;
	}



	/**
	 * Return the value associated with the column: CLINICAL
	 */
	public java.lang.String getClinical () {
		return clinical;
	}

	/**
	 * Set the value related to the column: CLINICAL
	 * @param clinical the CLINICAL value
	 */
	public void setClinical (java.lang.String clinical) {
		this.clinical = clinical;
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
	 * Return the value associated with the column: icd_id
	 */
	public jkt.hms.masters.business.MasIcd getIcd () {
		return icd;
	}

	/**
	 * Set the value related to the column: icd_id
	 * @param icd the icd_id value
	 */
	public void setIcd (jkt.hms.masters.business.MasIcd icd) {
		this.icd = icd;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MisNotifiable)) return false;
		else {
			jkt.hms.masters.business.MisNotifiable misNotifiable = (jkt.hms.masters.business.MisNotifiable) obj;
			if (null == this.getId() || null == misNotifiable.getId()) return false;
			else return (this.getId().equals(misNotifiable.getId()));
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
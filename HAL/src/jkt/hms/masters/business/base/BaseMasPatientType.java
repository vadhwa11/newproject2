package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_patient_type table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_patient_type"
 */

public abstract class BaseMasPatientType  implements Serializable {

	public static String REF = "MasPatientType";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_PATIENT_TYPE_NAME = "PatientTypeName";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_PATIENT_TYPE_CODE = "PatientTypeCode";


	// constructors
	public BaseMasPatientType () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasPatientType (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String patientTypeCode;
	private java.lang.String patientTypeName;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// collections
	private java.util.Set<jkt.hms.masters.business.MasCompany> masCompanies;
	private java.util.Set<jkt.hms.masters.business.MasDiscount> masDiscounts;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="org.hibernate.id.IncrementGenerator"
     *  column="patient_type_id"
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
	 * Return the value associated with the column: patient_type_code
	 */
	public java.lang.String getPatientTypeCode () {
		return patientTypeCode;
	}

	/**
	 * Set the value related to the column: patient_type_code
	 * @param patientTypeCode the patient_type_code value
	 */
	public void setPatientTypeCode (java.lang.String patientTypeCode) {
		this.patientTypeCode = patientTypeCode;
	}



	/**
	 * Return the value associated with the column: patient_type_name
	 */
	public java.lang.String getPatientTypeName () {
		return patientTypeName;
	}

	/**
	 * Set the value related to the column: patient_type_name
	 * @param patientTypeName the patient_type_name value
	 */
	public void setPatientTypeName (java.lang.String patientTypeName) {
		this.patientTypeName = patientTypeName;
	}



	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * @param status the status value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
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
	 * Return the value associated with the column: MasCompanies
	 */
	public java.util.Set<jkt.hms.masters.business.MasCompany> getMasCompanies () {
		return masCompanies;
	}

	/**
	 * Set the value related to the column: MasCompanies
	 * @param masCompanies the MasCompanies value
	 */
	public void setMasCompanies (java.util.Set<jkt.hms.masters.business.MasCompany> masCompanies) {
		this.masCompanies = masCompanies;
	}

	public void addToMasCompanies (jkt.hms.masters.business.MasCompany masCompany) {
		if (null == getMasCompanies()) setMasCompanies(new java.util.TreeSet<jkt.hms.masters.business.MasCompany>());
		getMasCompanies().add(masCompany);
	}



	/**
	 * Return the value associated with the column: MasDiscounts
	 */
	public java.util.Set<jkt.hms.masters.business.MasDiscount> getMasDiscounts () {
		return masDiscounts;
	}

	/**
	 * Set the value related to the column: MasDiscounts
	 * @param masDiscounts the MasDiscounts value
	 */
	public void setMasDiscounts (java.util.Set<jkt.hms.masters.business.MasDiscount> masDiscounts) {
		this.masDiscounts = masDiscounts;
	}

	public void addToMasDiscounts (jkt.hms.masters.business.MasDiscount masDiscount) {
		if (null == getMasDiscounts()) setMasDiscounts(new java.util.TreeSet<jkt.hms.masters.business.MasDiscount>());
		getMasDiscounts().add(masDiscount);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasPatientType)) return false;
		else {
			jkt.hms.masters.business.MasPatientType masPatientType = (jkt.hms.masters.business.MasPatientType) obj;
			if (null == this.getId() || null == masPatientType.getId()) return false;
			else return (this.getId().equals(masPatientType.getId()));
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
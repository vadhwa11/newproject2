package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_relation table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_relation"
 */

public abstract class BaseMasRelation  implements Serializable {

	public static String REF = "MasRelation";
	public static String PROP_STATUS = "Status";
	public static String PROP_RELATION_NAME = "RelationName";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_RELATION_CODE = "RelationCode";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HIC_CODE = "HicCode";
	public static String PROP_NEW_RELATION_NAME = "NewRelationName";
	public static String PROP_ID = "Id";
	public static String PROP_NEW_RELATION_CODE = "NewRelationCode";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseMasRelation () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasRelation (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseMasRelation (
		java.lang.Integer id,
		java.lang.String status) {

		this.setId(id);
		this.setStatus(status);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String relationCode;
	private java.lang.String relationName;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String hicCode;
	private java.lang.String newRelationCode;
	private java.lang.String newRelationName;

	// collections
	private java.util.Set<jkt.hms.masters.business.Patient> patientsByNextOfKinRelation;
	private java.util.Set<jkt.hms.masters.business.Patient> patientsByRelation;
	private java.util.Set<jkt.hms.masters.business.AttachInpatient> attachInpatients;
	private java.util.Set<jkt.hms.masters.business.MasEmployeeDependent> masEmployeeDependents;
	private java.util.Set<jkt.hms.masters.business.ExpiryDetails> expiryDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="relation_id"
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
	 * Return the value associated with the column: relation_code
	 */
	public java.lang.String getRelationCode () {
		return relationCode;
	}

	/**
	 * Set the value related to the column: relation_code
	 * @param relationCode the relation_code value
	 */
	public void setRelationCode (java.lang.String relationCode) {
		this.relationCode = relationCode;
	}



	/**
	 * Return the value associated with the column: relation_name
	 */
	public java.lang.String getRelationName () {
		return relationName;
	}

	/**
	 * Set the value related to the column: relation_name
	 * @param relationName the relation_name value
	 */
	public void setRelationName (java.lang.String relationName) {
		this.relationName = relationName;
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
	 * Return the value associated with the column: hic_code
	 */
	public java.lang.String getHicCode () {
		return hicCode;
	}

	/**
	 * Set the value related to the column: hic_code
	 * @param hicCode the hic_code value
	 */
	public void setHicCode (java.lang.String hicCode) {
		this.hicCode = hicCode;
	}



	/**
	 * Return the value associated with the column: new_relation_code
	 */
	public java.lang.String getNewRelationCode () {
		return newRelationCode;
	}

	/**
	 * Set the value related to the column: new_relation_code
	 * @param newRelationCode the new_relation_code value
	 */
	public void setNewRelationCode (java.lang.String newRelationCode) {
		this.newRelationCode = newRelationCode;
	}



	/**
	 * Return the value associated with the column: new_relation_name
	 */
	public java.lang.String getNewRelationName () {
		return newRelationName;
	}

	/**
	 * Set the value related to the column: new_relation_name
	 * @param newRelationName the new_relation_name value
	 */
	public void setNewRelationName (java.lang.String newRelationName) {
		this.newRelationName = newRelationName;
	}



	/**
	 * Return the value associated with the column: PatientsByNextOfKinRelation
	 */
	public java.util.Set<jkt.hms.masters.business.Patient> getPatientsByNextOfKinRelation () {
		return patientsByNextOfKinRelation;
	}

	/**
	 * Set the value related to the column: PatientsByNextOfKinRelation
	 * @param patientsByNextOfKinRelation the PatientsByNextOfKinRelation value
	 */
	public void setPatientsByNextOfKinRelation (java.util.Set<jkt.hms.masters.business.Patient> patientsByNextOfKinRelation) {
		this.patientsByNextOfKinRelation = patientsByNextOfKinRelation;
	}

	public void addToPatientsByNextOfKinRelation (jkt.hms.masters.business.Patient patient) {
		if (null == getPatientsByNextOfKinRelation()) setPatientsByNextOfKinRelation(new java.util.TreeSet<jkt.hms.masters.business.Patient>());
		getPatientsByNextOfKinRelation().add(patient);
	}



	/**
	 * Return the value associated with the column: PatientsByRelation
	 */
	public java.util.Set<jkt.hms.masters.business.Patient> getPatientsByRelation () {
		return patientsByRelation;
	}

	/**
	 * Set the value related to the column: PatientsByRelation
	 * @param patientsByRelation the PatientsByRelation value
	 */
	public void setPatientsByRelation (java.util.Set<jkt.hms.masters.business.Patient> patientsByRelation) {
		this.patientsByRelation = patientsByRelation;
	}

	public void addToPatientsByRelation (jkt.hms.masters.business.Patient patient) {
		if (null == getPatientsByRelation()) setPatientsByRelation(new java.util.TreeSet<jkt.hms.masters.business.Patient>());
		getPatientsByRelation().add(patient);
	}



	/**
	 * Return the value associated with the column: AttachInpatients
	 */
	public java.util.Set<jkt.hms.masters.business.AttachInpatient> getAttachInpatients () {
		return attachInpatients;
	}

	/**
	 * Set the value related to the column: AttachInpatients
	 * @param attachInpatients the AttachInpatients value
	 */
	public void setAttachInpatients (java.util.Set<jkt.hms.masters.business.AttachInpatient> attachInpatients) {
		this.attachInpatients = attachInpatients;
	}

	public void addToAttachInpatients (jkt.hms.masters.business.AttachInpatient attachInpatient) {
		if (null == getAttachInpatients()) setAttachInpatients(new java.util.TreeSet<jkt.hms.masters.business.AttachInpatient>());
		getAttachInpatients().add(attachInpatient);
	}



	/**
	 * Return the value associated with the column: MasEmployeeDependents
	 */
	public java.util.Set<jkt.hms.masters.business.MasEmployeeDependent> getMasEmployeeDependents () {
		return masEmployeeDependents;
	}

	/**
	 * Set the value related to the column: MasEmployeeDependents
	 * @param masEmployeeDependents the MasEmployeeDependents value
	 */
	public void setMasEmployeeDependents (java.util.Set<jkt.hms.masters.business.MasEmployeeDependent> masEmployeeDependents) {
		this.masEmployeeDependents = masEmployeeDependents;
	}

	public void addToMasEmployeeDependents (jkt.hms.masters.business.MasEmployeeDependent masEmployeeDependent) {
		if (null == getMasEmployeeDependents()) setMasEmployeeDependents(new java.util.TreeSet<jkt.hms.masters.business.MasEmployeeDependent>());
		getMasEmployeeDependents().add(masEmployeeDependent);
	}



	/**
	 * Return the value associated with the column: ExpiryDetails
	 */
	public java.util.Set<jkt.hms.masters.business.ExpiryDetails> getExpiryDetails () {
		return expiryDetails;
	}

	/**
	 * Set the value related to the column: ExpiryDetails
	 * @param expiryDetails the ExpiryDetails value
	 */
	public void setExpiryDetails (java.util.Set<jkt.hms.masters.business.ExpiryDetails> expiryDetails) {
		this.expiryDetails = expiryDetails;
	}

	public void addToExpiryDetails (jkt.hms.masters.business.ExpiryDetails expiryDetails) {
		if (null == getExpiryDetails()) setExpiryDetails(new java.util.TreeSet<jkt.hms.masters.business.ExpiryDetails>());
		getExpiryDetails().add(expiryDetails);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasRelation)) return false;
		else {
			jkt.hms.masters.business.MasRelation masRelation = (jkt.hms.masters.business.MasRelation) obj;
			if (null == this.getId() || null == masRelation.getId()) return false;
			else return (this.getId().equals(masRelation.getId()));
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
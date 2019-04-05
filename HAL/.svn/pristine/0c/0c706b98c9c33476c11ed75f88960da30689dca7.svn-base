package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the OPD_DIFFERENTIAL_DISEASE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="OPD_DIFFERENTIAL_DISEASE"
 */

public abstract class BaseOpdDifferentialDisease  implements Serializable {

	public static String REF = "OpdDifferentialDisease";
	public static String PROP_INVESTIGATION = "Investigation";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_STATUS = "Status";
	public static String PROP_SYNONYMS = "Synonyms";
	public static String PROP_OTHER_ADVICE = "OtherAdvice";
	public static String PROP_DIFFERENTIAL_DISEASE_NAME = "DifferentialDiseaseName";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_SURGERY = "Surgery";
	public static String PROP_TREATMENTS = "Treatments";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_SIGN_SYMPTOMS = "SignSymptoms";
	public static String PROP_DRUGS = "Drugs";


	// constructors
	public BaseOpdDifferentialDisease () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdDifferentialDisease (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String differentialDiseaseName;
	private java.lang.String synonyms;
	private java.lang.String signSymptoms;
	private java.lang.String investigation;
	private java.lang.String treatments;
	private java.lang.String drugs;
	private java.lang.String surgery;
	private java.lang.String otherAdvice;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.OpdMasSymptom hospital;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="DIFFERENTIAL_DISEASE_ID"
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
	 * Return the value associated with the column: DIFFERENTIAL_DISEASE_NAME
	 */
	public java.lang.String getDifferentialDiseaseName () {
		return differentialDiseaseName;
	}

	/**
	 * Set the value related to the column: DIFFERENTIAL_DISEASE_NAME
	 * @param differentialDiseaseName the DIFFERENTIAL_DISEASE_NAME value
	 */
	public void setDifferentialDiseaseName (java.lang.String differentialDiseaseName) {
		this.differentialDiseaseName = differentialDiseaseName;
	}



	/**
	 * Return the value associated with the column: SYNONYMS
	 */
	public java.lang.String getSynonyms () {
		return synonyms;
	}

	/**
	 * Set the value related to the column: SYNONYMS
	 * @param synonyms the SYNONYMS value
	 */
	public void setSynonyms (java.lang.String synonyms) {
		this.synonyms = synonyms;
	}



	/**
	 * Return the value associated with the column: SIGN_SYMPTOMS
	 */
	public java.lang.String getSignSymptoms () {
		return signSymptoms;
	}

	/**
	 * Set the value related to the column: SIGN_SYMPTOMS
	 * @param signSymptoms the SIGN_SYMPTOMS value
	 */
	public void setSignSymptoms (java.lang.String signSymptoms) {
		this.signSymptoms = signSymptoms;
	}



	/**
	 * Return the value associated with the column: INVESTIGATION
	 */
	public java.lang.String getInvestigation () {
		return investigation;
	}

	/**
	 * Set the value related to the column: INVESTIGATION
	 * @param investigation the INVESTIGATION value
	 */
	public void setInvestigation (java.lang.String investigation) {
		this.investigation = investigation;
	}



	/**
	 * Return the value associated with the column: TREATMENTS
	 */
	public java.lang.String getTreatments () {
		return treatments;
	}

	/**
	 * Set the value related to the column: TREATMENTS
	 * @param treatments the TREATMENTS value
	 */
	public void setTreatments (java.lang.String treatments) {
		this.treatments = treatments;
	}



	/**
	 * Return the value associated with the column: DRUGS
	 */
	public java.lang.String getDrugs () {
		return drugs;
	}

	/**
	 * Set the value related to the column: DRUGS
	 * @param drugs the DRUGS value
	 */
	public void setDrugs (java.lang.String drugs) {
		this.drugs = drugs;
	}



	/**
	 * Return the value associated with the column: SURGERY
	 */
	public java.lang.String getSurgery () {
		return surgery;
	}

	/**
	 * Set the value related to the column: SURGERY
	 * @param surgery the SURGERY value
	 */
	public void setSurgery (java.lang.String surgery) {
		this.surgery = surgery;
	}



	/**
	 * Return the value associated with the column: OTHER_ADVICE
	 */
	public java.lang.String getOtherAdvice () {
		return otherAdvice;
	}

	/**
	 * Set the value related to the column: OTHER_ADVICE
	 * @param otherAdvice the OTHER_ADVICE value
	 */
	public void setOtherAdvice (java.lang.String otherAdvice) {
		this.otherAdvice = otherAdvice;
	}



	/**
	 * Return the value associated with the column: LAST_CHG_DATE
	 */
	public java.util.Date getLastChgDate () {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: LAST_CHG_DATE
	 * @param lastChgDate the LAST_CHG_DATE value
	 */
	public void setLastChgDate (java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}



	/**
	 * Return the value associated with the column: LAST_CHG_TIME
	 */
	public java.lang.String getLastChgTime () {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: LAST_CHG_TIME
	 * @param lastChgTime the LAST_CHG_TIME value
	 */
	public void setLastChgTime (java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}



	/**
	 * Return the value associated with the column: STATUS
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: STATUS
	 * @param status the STATUS value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
	}



	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public jkt.hms.masters.business.Users getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (jkt.hms.masters.business.Users lastChgBy) {
		this.lastChgBy = lastChgBy;
	}



	/**
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.OpdMasSymptom getHospital () {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * @param hospital the hospital_id value
	 */
	public void setHospital (jkt.hms.masters.business.OpdMasSymptom hospital) {
		this.hospital = hospital;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OpdDifferentialDisease)) return false;
		else {
			jkt.hms.masters.business.OpdDifferentialDisease opdDifferentialDisease = (jkt.hms.masters.business.OpdDifferentialDisease) obj;
			if (null == this.getId() || null == opdDifferentialDisease.getId()) return false;
			else return (this.getId().equals(opdDifferentialDisease.getId()));
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
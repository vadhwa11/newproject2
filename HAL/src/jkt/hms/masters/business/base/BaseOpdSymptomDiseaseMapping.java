package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the OPD_SYMPTOM_DISEASE_MAPPING table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="OPD_SYMPTOM_DISEASE_MAPPING"
 */

public abstract class BaseOpdSymptomDiseaseMapping  implements Serializable {

	public static String REF = "OpdSymptomDiseaseMapping";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_DIFFERENTIAL_DISEASE = "DifferentialDisease";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_SYMPTOM = "Symptom";


	// constructors
	public BaseOpdSymptomDiseaseMapping () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdSymptomDiseaseMapping (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.OpdMasSymptom symptom;
	private jkt.hms.masters.business.OpdDifferentialDisease differentialDisease;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="SYMPTOM_DISEASE_ID"
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
	 * Return the value associated with the column: SYMPTOM_ID
	 */
	public jkt.hms.masters.business.OpdMasSymptom getSymptom () {
		return symptom;
	}

	/**
	 * Set the value related to the column: SYMPTOM_ID
	 * @param symptom the SYMPTOM_ID value
	 */
	public void setSymptom (jkt.hms.masters.business.OpdMasSymptom symptom) {
		this.symptom = symptom;
	}



	/**
	 * Return the value associated with the column: DIFFERENTIAL_DISEASE_ID
	 */
	public jkt.hms.masters.business.OpdDifferentialDisease getDifferentialDisease () {
		return differentialDisease;
	}

	/**
	 * Set the value related to the column: DIFFERENTIAL_DISEASE_ID
	 * @param differentialDisease the DIFFERENTIAL_DISEASE_ID value
	 */
	public void setDifferentialDisease (jkt.hms.masters.business.OpdDifferentialDisease differentialDisease) {
		this.differentialDisease = differentialDisease;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OpdSymptomDiseaseMapping)) return false;
		else {
			jkt.hms.masters.business.OpdSymptomDiseaseMapping opdSymptomDiseaseMapping = (jkt.hms.masters.business.OpdSymptomDiseaseMapping) obj;
			if (null == this.getId() || null == opdSymptomDiseaseMapping.getId()) return false;
			else return (this.getId().equals(opdSymptomDiseaseMapping.getId()));
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
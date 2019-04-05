package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SYMPTOM_MEDICATION table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="SYMPTOM_MEDICATION"
 */

public abstract class BaseSymptomMedication  implements Serializable {

	public static String REF = "SymptomMedication";
	public static String PROP_MEDICATION = "Medication";
	public static String PROP_ID = "Id";
	public static String PROP_GEN = "Gen";
	public static String PROP_SYMPTOM = "Symptom";


	// constructors
	public BaseSymptomMedication () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSymptomMedication (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String medication;
	private java.lang.String gen;

	// many to one
	private jkt.hms.masters.business.Symptom symptom;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="id"
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
	 * Return the value associated with the column: Medication
	 */
	public java.lang.String getMedication () {
		return medication;
	}

	/**
	 * Set the value related to the column: Medication
	 * @param medication the Medication value
	 */
	public void setMedication (java.lang.String medication) {
		this.medication = medication;
	}



	/**
	 * Return the value associated with the column: gen
	 */
	public java.lang.String getGen () {
		return gen;
	}

	/**
	 * Set the value related to the column: gen
	 * @param gen the gen value
	 */
	public void setGen (java.lang.String gen) {
		this.gen = gen;
	}



	/**
	 * Return the value associated with the column: main_complaint_id
	 */
	public jkt.hms.masters.business.Symptom getSymptom () {
		return symptom;
	}

	/**
	 * Set the value related to the column: main_complaint_id
	 * @param symptom the main_complaint_id value
	 */
	public void setSymptom (jkt.hms.masters.business.Symptom symptom) {
		this.symptom = symptom;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.SymptomMedication)) return false;
		else {
			jkt.hms.masters.business.SymptomMedication symptomMedication = (jkt.hms.masters.business.SymptomMedication) obj;
			if (null == this.getId() || null == symptomMedication.getId()) return false;
			else return (this.getId().equals(symptomMedication.getId()));
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
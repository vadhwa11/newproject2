package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SYMPTOM_RELATED_NAME table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="SYMPTOM_RELATED_NAME"
 */

public abstract class BaseSymptomRelatedName  implements Serializable {

	public static String REF = "SymptomRelatedName";
	public static String PROP_SYMPTOM_NAME = "SymptomName";
	public static String PROP_ID = "Id";
	public static String PROP_SYMPTOM = "Symptom";


	// constructors
	public BaseSymptomRelatedName () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSymptomRelatedName (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String symptomName;

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
	 * Return the value associated with the column: Symp_names
	 */
	public java.lang.String getSymptomName () {
		return symptomName;
	}

	/**
	 * Set the value related to the column: Symp_names
	 * @param symptomName the Symp_names value
	 */
	public void setSymptomName (java.lang.String symptomName) {
		this.symptomName = symptomName;
	}



	/**
	 * Return the value associated with the column: main_symp_id
	 */
	public jkt.hms.masters.business.Symptom getSymptom () {
		return symptom;
	}

	/**
	 * Set the value related to the column: main_symp_id
	 * @param symptom the main_symp_id value
	 */
	public void setSymptom (jkt.hms.masters.business.Symptom symptom) {
		this.symptom = symptom;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.SymptomRelatedName)) return false;
		else {
			jkt.hms.masters.business.SymptomRelatedName symptomRelatedName = (jkt.hms.masters.business.SymptomRelatedName) obj;
			if (null == this.getId() || null == symptomRelatedName.getId()) return false;
			else return (this.getId().equals(symptomRelatedName.getId()));
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
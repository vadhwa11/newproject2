package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SYMPTOM_DESC table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="SYMPTOM_DESC"
 */

public abstract class BaseSymptomDesc  implements Serializable {

	public static String REF = "SymptomDesc";
	public static String PROP_DESCRIPTION = "Description";
	public static String PROP_ID = "Id";
	public static String PROP_SYMPTOM = "Symptom";


	// constructors
	public BaseSymptomDesc () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSymptomDesc (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String description;

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
	 * Return the value associated with the column: Description
	 */
	public java.lang.String getDescription () {
		return description;
	}

	/**
	 * Set the value related to the column: Description
	 * @param description the Description value
	 */
	public void setDescription (java.lang.String description) {
		this.description = description;
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
		if (!(obj instanceof jkt.hms.masters.business.SymptomDesc)) return false;
		else {
			jkt.hms.masters.business.SymptomDesc symptomDesc = (jkt.hms.masters.business.SymptomDesc) obj;
			if (null == this.getId() || null == symptomDesc.getId()) return false;
			else return (this.getId().equals(symptomDesc.getId()));
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
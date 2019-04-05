package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SYMPTOM_SUB_COMPLAINS table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="SYMPTOM_SUB_COMPLAINS"
 */

public abstract class BaseSymptomSubComplains  implements Serializable {

	public static String REF = "SymptomSubComplains";
	public static String PROP_ID = "Id";
	public static String PROP_SUB_SYMPTOM_NAME = "SubSymptomName";
	public static String PROP_CODE = "Code";
	public static String PROP_SYMPTOM = "Symptom";


	// constructors
	public BaseSymptomSubComplains () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSymptomSubComplains (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String subSymptomName;
	private java.lang.Integer code;

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
	 * Return the value associated with the column: symptom
	 */
	public java.lang.String getSubSymptomName () {
		return subSymptomName;
	}

	/**
	 * Set the value related to the column: symptom
	 * @param subSymptomName the symptom value
	 */
	public void setSubSymptomName (java.lang.String subSymptomName) {
		this.subSymptomName = subSymptomName;
	}



	/**
	 * Return the value associated with the column: code
	 */
	public java.lang.Integer getCode () {
		return code;
	}

	/**
	 * Set the value related to the column: code
	 * @param code the code value
	 */
	public void setCode (java.lang.Integer code) {
		this.code = code;
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
		if (!(obj instanceof jkt.hms.masters.business.SymptomSubComplains)) return false;
		else {
			jkt.hms.masters.business.SymptomSubComplains symptomSubComplains = (jkt.hms.masters.business.SymptomSubComplains) obj;
			if (null == this.getId() || null == symptomSubComplains.getId()) return false;
			else return (this.getId().equals(symptomSubComplains.getId()));
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
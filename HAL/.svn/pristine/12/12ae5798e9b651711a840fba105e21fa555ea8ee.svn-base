package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SYMPTOM_CAUSE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="SYMPTOM_CAUSE"
 */

public abstract class BaseSymptomCause  implements Serializable {

	public static String REF = "SymptomCause";
	public static String PROP_ID = "Id";
	public static String PROP_MAIN_OTHER = "MainOther";
	public static String PROP_SYMPTOM = "Symptom";
	public static String PROP_CAUSE = "Cause";


	// constructors
	public BaseSymptomCause () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSymptomCause (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String mainOther;
	private java.lang.String cause;

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
	 * Return the value associated with the column: main_other
	 */
	public java.lang.String getMainOther () {
		return mainOther;
	}

	/**
	 * Set the value related to the column: main_other
	 * @param mainOther the main_other value
	 */
	public void setMainOther (java.lang.String mainOther) {
		this.mainOther = mainOther;
	}



	/**
	 * Return the value associated with the column: cause
	 */
	public java.lang.String getCause () {
		return cause;
	}

	/**
	 * Set the value related to the column: cause
	 * @param cause the cause value
	 */
	public void setCause (java.lang.String cause) {
		this.cause = cause;
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
		if (!(obj instanceof jkt.hms.masters.business.SymptomCause)) return false;
		else {
			jkt.hms.masters.business.SymptomCause symptomCause = (jkt.hms.masters.business.SymptomCause) obj;
			if (null == this.getId() || null == symptomCause.getId()) return false;
			else return (this.getId().equals(symptomCause.getId()));
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
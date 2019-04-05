package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the DIFFERENTIAL_DIAGNOSIS_TEMP table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="DIFFERENTIAL_DIAGNOSIS_TEMP"
 */

public abstract class BaseDifferentialDiagnosisTemp  implements Serializable {

	public static String REF = "DifferentialDiagnosisTemp";
	public static String PROP_LABEL_TERM = "LabelTerm";
	public static String PROP_TERM_ID = "TermId";
	public static String PROP_CONDITION_TERM = "ConditionTerm";
	public static String PROP_ATTRIB_TERM = "AttribTerm";
	public static String PROP_ATTRIB_ID = "AttribId";
	public static String PROP_ID = "Id";
	public static String PROP_CONDITION_ID = "ConditionId";


	// constructors
	public BaseDifferentialDiagnosisTemp () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDifferentialDiagnosisTemp (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer termId;
	private java.lang.String labelTerm;
	private java.lang.Integer attribId;
	private java.lang.String attribTerm;
	private java.lang.Integer conditionId;
	private java.lang.String conditionTerm;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="ID"
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
	 * Return the value associated with the column: TERM_ID
	 */
	public java.lang.Integer getTermId () {
		return termId;
	}

	/**
	 * Set the value related to the column: TERM_ID
	 * @param termId the TERM_ID value
	 */
	public void setTermId (java.lang.Integer termId) {
		this.termId = termId;
	}



	/**
	 * Return the value associated with the column: LABEL_TERM
	 */
	public java.lang.String getLabelTerm () {
		return labelTerm;
	}

	/**
	 * Set the value related to the column: LABEL_TERM
	 * @param labelTerm the LABEL_TERM value
	 */
	public void setLabelTerm (java.lang.String labelTerm) {
		this.labelTerm = labelTerm;
	}



	/**
	 * Return the value associated with the column: ATTRIB_ID
	 */
	public java.lang.Integer getAttribId () {
		return attribId;
	}

	/**
	 * Set the value related to the column: ATTRIB_ID
	 * @param attribId the ATTRIB_ID value
	 */
	public void setAttribId (java.lang.Integer attribId) {
		this.attribId = attribId;
	}



	/**
	 * Return the value associated with the column: ATTRIB_TERM
	 */
	public java.lang.String getAttribTerm () {
		return attribTerm;
	}

	/**
	 * Set the value related to the column: ATTRIB_TERM
	 * @param attribTerm the ATTRIB_TERM value
	 */
	public void setAttribTerm (java.lang.String attribTerm) {
		this.attribTerm = attribTerm;
	}



	/**
	 * Return the value associated with the column: CONDITION_ID
	 */
	public java.lang.Integer getConditionId () {
		return conditionId;
	}

	/**
	 * Set the value related to the column: CONDITION_ID
	 * @param conditionId the CONDITION_ID value
	 */
	public void setConditionId (java.lang.Integer conditionId) {
		this.conditionId = conditionId;
	}



	/**
	 * Return the value associated with the column: CONDITION_TERM
	 */
	public java.lang.String getConditionTerm () {
		return conditionTerm;
	}

	/**
	 * Set the value related to the column: CONDITION_TERM
	 * @param conditionTerm the CONDITION_TERM value
	 */
	public void setConditionTerm (java.lang.String conditionTerm) {
		this.conditionTerm = conditionTerm;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.DifferentialDiagnosisTemp)) return false;
		else {
			jkt.hms.masters.business.DifferentialDiagnosisTemp differentialDiagnosisTemp = (jkt.hms.masters.business.DifferentialDiagnosisTemp) obj;
			if (null == this.getId() || null == differentialDiagnosisTemp.getId()) return false;
			else return (this.getId().equals(differentialDiagnosisTemp.getId()));
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
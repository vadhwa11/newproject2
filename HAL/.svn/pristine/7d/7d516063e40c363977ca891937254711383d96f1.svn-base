package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the FATAL_DETAIL table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="FATAL_DETAIL"
 */

public abstract class BaseFatalDetail  implements Serializable {

	public static String REF = "FatalDetail";
	public static String PROP_FATAL_HEADER_ID = "FatalHeaderId";
	public static String PROP_CONDITION_TO_DEATH = "ConditionToDeath";
	public static String PROP_ID = "Id";
	public static String PROP_DUE_CONSEQUENCE = "DueConsequence";
	public static String PROP_OTHER_CONDITION = "OtherCondition";


	// constructors
	public BaseFatalDetail () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFatalDetail (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String conditionToDeath;
	private java.lang.String dueConsequence;
	private java.lang.String otherCondition;

	// many to one
	private jkt.hms.masters.business.FatalDocumentHeader fatalHeaderId;



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
	 * Return the value associated with the column: CONDITION_TO_DEATH
	 */
	public java.lang.String getConditionToDeath () {
		return conditionToDeath;
	}

	/**
	 * Set the value related to the column: CONDITION_TO_DEATH
	 * @param conditionToDeath the CONDITION_TO_DEATH value
	 */
	public void setConditionToDeath (java.lang.String conditionToDeath) {
		this.conditionToDeath = conditionToDeath;
	}



	/**
	 * Return the value associated with the column: DUE_CONSEQUENCE
	 */
	public java.lang.String getDueConsequence () {
		return dueConsequence;
	}

	/**
	 * Set the value related to the column: DUE_CONSEQUENCE
	 * @param dueConsequence the DUE_CONSEQUENCE value
	 */
	public void setDueConsequence (java.lang.String dueConsequence) {
		this.dueConsequence = dueConsequence;
	}



	/**
	 * Return the value associated with the column: OTHER_CONDITION
	 */
	public java.lang.String getOtherCondition () {
		return otherCondition;
	}

	/**
	 * Set the value related to the column: OTHER_CONDITION
	 * @param otherCondition the OTHER_CONDITION value
	 */
	public void setOtherCondition (java.lang.String otherCondition) {
		this.otherCondition = otherCondition;
	}



	/**
	 * Return the value associated with the column: FATAL_HEADER_ID
	 */
	public jkt.hms.masters.business.FatalDocumentHeader getFatalHeaderId () {
		return fatalHeaderId;
	}

	/**
	 * Set the value related to the column: FATAL_HEADER_ID
	 * @param fatalHeaderId the FATAL_HEADER_ID value
	 */
	public void setFatalHeaderId (jkt.hms.masters.business.FatalDocumentHeader fatalHeaderId) {
		this.fatalHeaderId = fatalHeaderId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.FatalDetail)) return false;
		else {
			jkt.hms.masters.business.FatalDetail fatalDetail = (jkt.hms.masters.business.FatalDetail) obj;
			if (null == this.getId() || null == fatalDetail.getId()) return false;
			else return (this.getId().equals(fatalDetail.getId()));
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
package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the AVIATION_INVEST_RESULT table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="AVIATION_INVEST_RESULT"
 */

public abstract class BaseAviationInvestResult  implements Serializable {

	public static String REF = "AviationInvestResult";
	public static String PROP_RESULT = "Result";
	public static String PROP_AV_MEDICAL_EXAM_MA_MO = "AvMedicalExamMaMo";
	public static String PROP_DG_MAS_INVESTIGATION = "DgMasInvestigation";
	public static String PROP_ID = "Id";
	public static String PROP_REFER_TO_M_H = "ReferToMH";


	// constructors
	public BaseAviationInvestResult () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAviationInvestResult (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String result;
	private java.lang.String referToMH;

	// many to one
	private jkt.hms.masters.business.DgMasInvestigation dgMasInvestigation;
	private jkt.hms.masters.business.AvMedicalExamMaMo avMedicalExamMaMo;



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
	 * Return the value associated with the column: result
	 */
	public java.lang.String getResult () {
		return result;
	}

	/**
	 * Set the value related to the column: result
	 * @param result the result value
	 */
	public void setResult (java.lang.String result) {
		this.result = result;
	}



	/**
	 * Return the value associated with the column: REFER_TO_MH
	 */
	public java.lang.String getReferToMH () {
		return referToMH;
	}

	/**
	 * Set the value related to the column: REFER_TO_MH
	 * @param referToMH the REFER_TO_MH value
	 */
	public void setReferToMH (java.lang.String referToMH) {
		this.referToMH = referToMH;
	}



	/**
	 * Return the value associated with the column: INVESTIGATION_ID
	 */
	public jkt.hms.masters.business.DgMasInvestigation getDgMasInvestigation () {
		return dgMasInvestigation;
	}

	/**
	 * Set the value related to the column: INVESTIGATION_ID
	 * @param dgMasInvestigation the INVESTIGATION_ID value
	 */
	public void setDgMasInvestigation (jkt.hms.masters.business.DgMasInvestigation dgMasInvestigation) {
		this.dgMasInvestigation = dgMasInvestigation;
	}



	/**
	 * Return the value associated with the column: AV_MED_EXAM_ID
	 */
	public jkt.hms.masters.business.AvMedicalExamMaMo getAvMedicalExamMaMo () {
		return avMedicalExamMaMo;
	}

	/**
	 * Set the value related to the column: AV_MED_EXAM_ID
	 * @param avMedicalExamMaMo the AV_MED_EXAM_ID value
	 */
	public void setAvMedicalExamMaMo (jkt.hms.masters.business.AvMedicalExamMaMo avMedicalExamMaMo) {
		this.avMedicalExamMaMo = avMedicalExamMaMo;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.AviationInvestResult)) return false;
		else {
			jkt.hms.masters.business.AviationInvestResult aviationInvestResult = (jkt.hms.masters.business.AviationInvestResult) obj;
			if (null == this.getId() || null == aviationInvestResult.getId()) return false;
			else return (this.getId().equals(aviationInvestResult.getId()));
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
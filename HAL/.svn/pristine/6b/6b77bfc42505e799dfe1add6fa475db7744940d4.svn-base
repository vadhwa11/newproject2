package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the patient_investigation_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="patient_investigation_details"
 */

public abstract class BasePatientInvestigationDetails  implements Serializable {

	public static String REF = "PatientInvestigationDetails";
	public static String PROP_INVESTIGATION_HEADER = "InvestigationHeader";
	public static String PROP_QUANTITY = "Quantity";
	public static String PROP_CHARGE_CODE = "ChargeCode";
	public static String PROP_REFER_TO_MH = "ReferToMh";
	public static String PROP_ID = "Id";
	public static String PROP_CLINICAL_NOTES = "ClinicalNotes";


	// constructors
	public BasePatientInvestigationDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePatientInvestigationDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer quantity;
	private java.lang.String clinicalNotes;
	private java.lang.String referToMh;

	// many to one
	private jkt.hms.masters.business.MasChargeCode chargeCode;
	private jkt.hms.masters.business.PatientInvestigationHeader investigationHeader;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="investigation_detail_id"
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
	 * Return the value associated with the column: quantity
	 */
	public java.lang.Integer getQuantity () {
		return quantity;
	}

	/**
	 * Set the value related to the column: quantity
	 * @param quantity the quantity value
	 */
	public void setQuantity (java.lang.Integer quantity) {
		this.quantity = quantity;
	}



	/**
	 * Return the value associated with the column: clinical_notes
	 */
	public java.lang.String getClinicalNotes () {
		return clinicalNotes;
	}

	/**
	 * Set the value related to the column: clinical_notes
	 * @param clinicalNotes the clinical_notes value
	 */
	public void setClinicalNotes (java.lang.String clinicalNotes) {
		this.clinicalNotes = clinicalNotes;
	}



	/**
	 * Return the value associated with the column: refer_to_mh
	 */
	public java.lang.String getReferToMh () {
		return referToMh;
	}

	/**
	 * Set the value related to the column: refer_to_mh
	 * @param referToMh the refer_to_mh value
	 */
	public void setReferToMh (java.lang.String referToMh) {
		this.referToMh = referToMh;
	}



	/**
	 * Return the value associated with the column: charge_code_id
	 */
	public jkt.hms.masters.business.MasChargeCode getChargeCode () {
		return chargeCode;
	}

	/**
	 * Set the value related to the column: charge_code_id
	 * @param chargeCode the charge_code_id value
	 */
	public void setChargeCode (jkt.hms.masters.business.MasChargeCode chargeCode) {
		this.chargeCode = chargeCode;
	}



	/**
	 * Return the value associated with the column: investigation_header_id
	 */
	public jkt.hms.masters.business.PatientInvestigationHeader getInvestigationHeader () {
		return investigationHeader;
	}

	/**
	 * Set the value related to the column: investigation_header_id
	 * @param investigationHeader the investigation_header_id value
	 */
	public void setInvestigationHeader (jkt.hms.masters.business.PatientInvestigationHeader investigationHeader) {
		this.investigationHeader = investigationHeader;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PatientInvestigationDetails)) return false;
		else {
			jkt.hms.masters.business.PatientInvestigationDetails patientInvestigationDetails = (jkt.hms.masters.business.PatientInvestigationDetails) obj;
			if (null == this.getId() || null == patientInvestigationDetails.getId()) return false;
			else return (this.getId().equals(patientInvestigationDetails.getId()));
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
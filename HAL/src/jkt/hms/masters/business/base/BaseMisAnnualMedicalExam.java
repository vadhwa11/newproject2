package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mis_annual_medical_exam table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mis_annual_medical_exam"
 */

public abstract class BaseMisAnnualMedicalExam  implements Serializable {

	public static String REF = "MisAnnualMedicalExam";
	public static String PROP_AME_CODE = "AmeCode";
	public static String PROP_AME_NAME = "AmeName";
	public static String PROP_AME_DURATION = "AmeDuration";
	public static String PROP_AME_DESCRIPTION = "AmeDescription";
	public static String PROP_STATUS = "Status";


	// constructors
	public BaseMisAnnualMedicalExam () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMisAnnualMedicalExam (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String ameCode;
	private java.lang.String ameName;
	private java.lang.String ameDuration;
	private java.lang.String ameDescription;
	private java.lang.String status;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="ame_id"
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
	 * Return the value associated with the column: ame_code
	 */
	public java.lang.String getAmeCode () {
		return ameCode;
	}

	/**
	 * Set the value related to the column: ame_code
	 * @param ameCode the ame_code value
	 */
	public void setAmeCode (java.lang.String ameCode) {
		this.ameCode = ameCode;
	}



	/**
	 * Return the value associated with the column: ame_name
	 */
	public java.lang.String getAmeName () {
		return ameName;
	}

	/**
	 * Set the value related to the column: ame_name
	 * @param ameName the ame_name value
	 */
	public void setAmeName (java.lang.String ameName) {
		this.ameName = ameName;
	}



	/**
	 * Return the value associated with the column: ame_duration
	 */
	public java.lang.String getAmeDuration () {
		return ameDuration;
	}

	/**
	 * Set the value related to the column: ame_duration
	 * @param ameDuration the ame_duration value
	 */
	public void setAmeDuration (java.lang.String ameDuration) {
		this.ameDuration = ameDuration;
	}



	/**
	 * Return the value associated with the column: ame_description
	 */
	public java.lang.String getAmeDescription () {
		return ameDescription;
	}

	/**
	 * Set the value related to the column: ame_description
	 * @param ameDescription the ame_description value
	 */
	public void setAmeDescription (java.lang.String ameDescription) {
		this.ameDescription = ameDescription;
	}



	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * @param status the status value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MisAnnualMedicalExam)) return false;
		else {
			jkt.hms.masters.business.MisAnnualMedicalExam misAnnualMedicalExam = (jkt.hms.masters.business.MisAnnualMedicalExam) obj;
			if (null == this.getId() || null == misAnnualMedicalExam.getId()) return false;
			else return (this.getId().equals(misAnnualMedicalExam.getId()));
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
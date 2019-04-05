package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_physiotherapy_treatment table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_physiotherapy_treatment"
 */

public abstract class BaseMasPhysiotherapyTreatment  implements Serializable {

	public static String REF = "MasPhysiotherapyTreatment";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_TREATMENT_NAME = "TreatmentName";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_TREATMENT_CODE = "TreatmentCode";


	// constructors
	public BaseMasPhysiotherapyTreatment () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasPhysiotherapyTreatment (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String treatmentCode;
	private java.lang.String treatmentName;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="treartment_id"
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
	 * Return the value associated with the column: treatment_code
	 */
	public java.lang.String getTreatmentCode () {
		return treatmentCode;
	}

	/**
	 * Set the value related to the column: treatment_code
	 * @param treatmentCode the treatment_code value
	 */
	public void setTreatmentCode (java.lang.String treatmentCode) {
		this.treatmentCode = treatmentCode;
	}



	/**
	 * Return the value associated with the column: treatment_name
	 */
	public java.lang.String getTreatmentName () {
		return treatmentName;
	}

	/**
	 * Set the value related to the column: treatment_name
	 * @param treatmentName the treatment_name value
	 */
	public void setTreatmentName (java.lang.String treatmentName) {
		this.treatmentName = treatmentName;
	}



	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.String getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
	}



	/**
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate () {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * @param lastChgDate the last_chg_date value
	 */
	public void setLastChgDate (java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}



	/**
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime () {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * @param lastChgTime the last_chg_time value
	 */
	public void setLastChgTime (java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
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



	/**
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital () {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * @param hospital the hospital_id value
	 */
	public void setHospital (jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasPhysiotherapyTreatment)) return false;
		else {
			jkt.hms.masters.business.MasPhysiotherapyTreatment masPhysiotherapyTreatment = (jkt.hms.masters.business.MasPhysiotherapyTreatment) obj;
			if (null == this.getId() || null == masPhysiotherapyTreatment.getId()) return false;
			else return (this.getId().equals(masPhysiotherapyTreatment.getId()));
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
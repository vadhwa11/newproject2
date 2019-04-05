package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SHO_ADMISSION_DEATH table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="SHO_ADMISSION_DEATH"
 */

public abstract class BaseShoAdmissionDeath  implements Serializable {

	public static String REF = "ShoAdmissionDeath";
	public static String PROP_NO_OF_AD = "NoOfAd";
	public static String PROP_RELATION = "Relation";
	public static String PROP_CATEGORY = "Category";
	public static String PROP_DIAGNOSIS = "Diagnosis";
	public static String PROP_ADMISSION_DATE = "AdmissionDate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_DATE = "LastDate";
	public static String PROP_SL_NO = "SlNo";
	public static String PROP_AVG = "Avg";
	public static String PROP_RATE = "Rate";
	public static String PROP_NO_OF_D = "NoOfD";


	// constructors
	public BaseShoAdmissionDeath () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseShoAdmissionDeath (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseShoAdmissionDeath (
		java.lang.Integer id,
		java.lang.String category,
		java.lang.String noOfAd,
		java.lang.String noOfD,
		java.lang.String avg,
		java.lang.String rate) {

		this.setId(id);
		this.setCategory(category);
		this.setNoOfAd(noOfAd);
		this.setNoOfD(noOfD);
		this.setAvg(avg);
		this.setRate(rate);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer slNo;
	private java.util.Date admissionDate;
	private java.util.Date lastDate;
	private java.lang.String category;
	private java.lang.String noOfAd;
	private java.lang.String noOfD;
	private java.lang.String avg;
	private java.lang.String rate;

	// many to one
	private jkt.hms.masters.business.MasIcd diagnosis;
	private jkt.hms.masters.business.MasRelation relation;
	private jkt.hms.masters.business.MasHospital hospital;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="ADMISSION_DEATH_ID"
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
	 * Return the value associated with the column: SL_NO
	 */
	public java.lang.Integer getSlNo () {
		return slNo;
	}

	/**
	 * Set the value related to the column: SL_NO
	 * @param slNo the SL_NO value
	 */
	public void setSlNo (java.lang.Integer slNo) {
		this.slNo = slNo;
	}



	/**
	 * Return the value associated with the column: ADMISSION_DATE
	 */
	public java.util.Date getAdmissionDate () {
		return admissionDate;
	}

	/**
	 * Set the value related to the column: ADMISSION_DATE
	 * @param admissionDate the ADMISSION_DATE value
	 */
	public void setAdmissionDate (java.util.Date admissionDate) {
		this.admissionDate = admissionDate;
	}



	/**
	 * Return the value associated with the column: LAST_DATE
	 */
	public java.util.Date getLastDate () {
		return lastDate;
	}

	/**
	 * Set the value related to the column: LAST_DATE
	 * @param lastDate the LAST_DATE value
	 */
	public void setLastDate (java.util.Date lastDate) {
		this.lastDate = lastDate;
	}



	/**
	 * Return the value associated with the column: CATEGORY
	 */
	public java.lang.String getCategory () {
		return category;
	}

	/**
	 * Set the value related to the column: CATEGORY
	 * @param category the CATEGORY value
	 */
	public void setCategory (java.lang.String category) {
		this.category = category;
	}



	/**
	 * Return the value associated with the column: NO_OF_AD
	 */
	public java.lang.String getNoOfAd () {
		return noOfAd;
	}

	/**
	 * Set the value related to the column: NO_OF_AD
	 * @param noOfAd the NO_OF_AD value
	 */
	public void setNoOfAd (java.lang.String noOfAd) {
		this.noOfAd = noOfAd;
	}



	/**
	 * Return the value associated with the column: NO_OF_D
	 */
	public java.lang.String getNoOfD () {
		return noOfD;
	}

	/**
	 * Set the value related to the column: NO_OF_D
	 * @param noOfD the NO_OF_D value
	 */
	public void setNoOfD (java.lang.String noOfD) {
		this.noOfD = noOfD;
	}



	/**
	 * Return the value associated with the column: AVG
	 */
	public java.lang.String getAvg () {
		return avg;
	}

	/**
	 * Set the value related to the column: AVG
	 * @param avg the AVG value
	 */
	public void setAvg (java.lang.String avg) {
		this.avg = avg;
	}



	/**
	 * Return the value associated with the column: RATE
	 */
	public java.lang.String getRate () {
		return rate;
	}

	/**
	 * Set the value related to the column: RATE
	 * @param rate the RATE value
	 */
	public void setRate (java.lang.String rate) {
		this.rate = rate;
	}



	/**
	 * Return the value associated with the column: ICD_ID
	 */
	public jkt.hms.masters.business.MasIcd getDiagnosis () {
		return diagnosis;
	}

	/**
	 * Set the value related to the column: ICD_ID
	 * @param diagnosis the ICD_ID value
	 */
	public void setDiagnosis (jkt.hms.masters.business.MasIcd diagnosis) {
		this.diagnosis = diagnosis;
	}



	/**
	 * Return the value associated with the column: RELATION_ID
	 */
	public jkt.hms.masters.business.MasRelation getRelation () {
		return relation;
	}

	/**
	 * Set the value related to the column: RELATION_ID
	 * @param relation the RELATION_ID value
	 */
	public void setRelation (jkt.hms.masters.business.MasRelation relation) {
		this.relation = relation;
	}



	/**
	 * Return the value associated with the column: HOSPITAL_ID
	 */
	public jkt.hms.masters.business.MasHospital getHospital () {
		return hospital;
	}

	/**
	 * Set the value related to the column: HOSPITAL_ID
	 * @param hospital the HOSPITAL_ID value
	 */
	public void setHospital (jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.ShoAdmissionDeath)) return false;
		else {
			jkt.hms.masters.business.ShoAdmissionDeath shoAdmissionDeath = (jkt.hms.masters.business.ShoAdmissionDeath) obj;
			if (null == this.getId() || null == shoAdmissionDeath.getId()) return false;
			else return (this.getId().equals(shoAdmissionDeath.getId()));
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
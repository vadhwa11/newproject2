package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the referral_clarrification_header table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="referral_clarrification_header"
 */

public abstract class BaseReferralClarrificationHeader  implements Serializable {

	public static String REF = "ReferralClarrificationHeader";
	public static String PROP_GENERATED_BY = "GeneratedBy";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_IMPANELED_REMARKS = "ImpaneledRemarks";
	public static String PROP_CLARIFICATION_REMARKS = "ClarificationRemarks";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_GENERATION_DATE = "GenerationDate";
	public static String PROP_ID = "Id";
	public static String PROP_CLARIFICATION_NO = "ClarificationNo";
	public static String PROP_REFERRAL_HEADER = "ReferralHeader";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseReferralClarrificationHeader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseReferralClarrificationHeader (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String clarificationNo;
	private java.lang.String clarificationRemarks;
	private java.lang.String impaneledRemarks;
	private java.util.Date generationDate;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users generatedBy;
	private jkt.hms.masters.business.ReferralPatientHeader referralHeader;
	private jkt.hms.masters.business.Users lastChgBy;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
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
	 * Return the value associated with the column: clarification_no
	 */
	public java.lang.String getClarificationNo () {
		return clarificationNo;
	}

	/**
	 * Set the value related to the column: clarification_no
	 * @param clarificationNo the clarification_no value
	 */
	public void setClarificationNo (java.lang.String clarificationNo) {
		this.clarificationNo = clarificationNo;
	}



	/**
	 * Return the value associated with the column: clarification_remarks
	 */
	public java.lang.String getClarificationRemarks () {
		return clarificationRemarks;
	}

	/**
	 * Set the value related to the column: clarification_remarks
	 * @param clarificationRemarks the clarification_remarks value
	 */
	public void setClarificationRemarks (java.lang.String clarificationRemarks) {
		this.clarificationRemarks = clarificationRemarks;
	}



	/**
	 * Return the value associated with the column: impaneled_remarks
	 */
	public java.lang.String getImpaneledRemarks () {
		return impaneledRemarks;
	}

	/**
	 * Set the value related to the column: impaneled_remarks
	 * @param impaneledRemarks the impaneled_remarks value
	 */
	public void setImpaneledRemarks (java.lang.String impaneledRemarks) {
		this.impaneledRemarks = impaneledRemarks;
	}



	/**
	 * Return the value associated with the column: generation_date
	 */
	public java.util.Date getGenerationDate () {
		return generationDate;
	}

	/**
	 * Set the value related to the column: generation_date
	 * @param generationDate the generation_date value
	 */
	public void setGenerationDate (java.util.Date generationDate) {
		this.generationDate = generationDate;
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
	 * Return the value associated with the column: generated_by
	 */
	public jkt.hms.masters.business.Users getGeneratedBy () {
		return generatedBy;
	}

	/**
	 * Set the value related to the column: generated_by
	 * @param generatedBy the generated_by value
	 */
	public void setGeneratedBy (jkt.hms.masters.business.Users generatedBy) {
		this.generatedBy = generatedBy;
	}



	/**
	 * Return the value associated with the column: referral_header_id
	 */
	public jkt.hms.masters.business.ReferralPatientHeader getReferralHeader () {
		return referralHeader;
	}

	/**
	 * Set the value related to the column: referral_header_id
	 * @param referralHeader the referral_header_id value
	 */
	public void setReferralHeader (jkt.hms.masters.business.ReferralPatientHeader referralHeader) {
		this.referralHeader = referralHeader;
	}



	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public jkt.hms.masters.business.Users getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (jkt.hms.masters.business.Users lastChgBy) {
		this.lastChgBy = lastChgBy;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.ReferralClarrificationHeader)) return false;
		else {
			jkt.hms.masters.business.ReferralClarrificationHeader referralClarrificationHeader = (jkt.hms.masters.business.ReferralClarrificationHeader) obj;
			if (null == this.getId() || null == referralClarrificationHeader.getId()) return false;
			else return (this.getId().equals(referralClarrificationHeader.getId()));
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
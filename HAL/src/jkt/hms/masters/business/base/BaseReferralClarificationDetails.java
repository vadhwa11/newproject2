package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the referral_clarification_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="referral_clarification_details"
 */

public abstract class BaseReferralClarificationDetails  implements Serializable {

	public static String REF = "ReferralClarificationDetails";
	public static String PROP_CLARIFICATION_HEADER = "ClarificationHeader";
	public static String PROP_ID = "Id";
	public static String PROP_REFERRAL_BILLING = "ReferralBilling";


	// constructors
	public BaseReferralClarificationDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseReferralClarificationDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// many to one
	private jkt.hms.masters.business.ReferralPatientBilling referralBilling;
	private jkt.hms.masters.business.ReferralClarrificationHeader clarificationHeader;



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
	 * Return the value associated with the column: referral_billing_id
	 */
	public jkt.hms.masters.business.ReferralPatientBilling getReferralBilling () {
		return referralBilling;
	}

	/**
	 * Set the value related to the column: referral_billing_id
	 * @param referralBilling the referral_billing_id value
	 */
	public void setReferralBilling (jkt.hms.masters.business.ReferralPatientBilling referralBilling) {
		this.referralBilling = referralBilling;
	}



	/**
	 * Return the value associated with the column: clarification_header_id
	 */
	public jkt.hms.masters.business.ReferralClarrificationHeader getClarificationHeader () {
		return clarificationHeader;
	}

	/**
	 * Set the value related to the column: clarification_header_id
	 * @param clarificationHeader the clarification_header_id value
	 */
	public void setClarificationHeader (jkt.hms.masters.business.ReferralClarrificationHeader clarificationHeader) {
		this.clarificationHeader = clarificationHeader;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.ReferralClarificationDetails)) return false;
		else {
			jkt.hms.masters.business.ReferralClarificationDetails referralClarificationDetails = (jkt.hms.masters.business.ReferralClarificationDetails) obj;
			if (null == this.getId() || null == referralClarificationDetails.getId()) return false;
			else return (this.getId().equals(referralClarificationDetails.getId()));
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
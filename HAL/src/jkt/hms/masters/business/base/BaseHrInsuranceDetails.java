package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_insurance_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_insurance_details"
 */

public abstract class BaseHrInsuranceDetails  implements Serializable {

	public static String REF = "HrInsuranceDetails";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_AMOUNT = "Amount";
	public static String PROP_PREMIUM = "Premium";
	public static String PROP_INSURANCE_TYPE = "InsuranceType";
	public static String PROP_DATE = "Date";
	public static String PROP_COVER = "Cover";
	public static String PROP_NEXT_PREMIUM_DATE = "NextPremiumDate";
	public static String PROP_ID = "Id";
	public static String PROP_DISCRIPTION = "Discription";
	public static String PROP_INSURANCE_NAME = "InsuranceName";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LOCATION = "Location";


	// constructors
	public BaseHrInsuranceDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrInsuranceDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String insuranceName;
	private java.lang.String discription;
	private java.util.Date date;
	private java.lang.String cover;
	private java.math.BigDecimal premium;
	private java.math.BigDecimal amount;
	private java.util.Date nextPremiumDate;
	private java.lang.String status;
	private java.util.Date lastChgDate;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.HrMasInsurance insuranceType;
	private jkt.hms.masters.business.MasHospital location;



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
	 * Return the value associated with the column: insurance_name
	 */
	public java.lang.String getInsuranceName () {
		return insuranceName;
	}

	/**
	 * Set the value related to the column: insurance_name
	 * @param insuranceName the insurance_name value
	 */
	public void setInsuranceName (java.lang.String insuranceName) {
		this.insuranceName = insuranceName;
	}



	/**
	 * Return the value associated with the column: discription
	 */
	public java.lang.String getDiscription () {
		return discription;
	}

	/**
	 * Set the value related to the column: discription
	 * @param discription the discription value
	 */
	public void setDiscription (java.lang.String discription) {
		this.discription = discription;
	}



	/**
	 * Return the value associated with the column: date
	 */
	public java.util.Date getDate () {
		return date;
	}

	/**
	 * Set the value related to the column: date
	 * @param date the date value
	 */
	public void setDate (java.util.Date date) {
		this.date = date;
	}



	/**
	 * Return the value associated with the column: cover
	 */
	public java.lang.String getCover () {
		return cover;
	}

	/**
	 * Set the value related to the column: cover
	 * @param cover the cover value
	 */
	public void setCover (java.lang.String cover) {
		this.cover = cover;
	}



	/**
	 * Return the value associated with the column: premium
	 */
	public java.math.BigDecimal getPremium () {
		return premium;
	}

	/**
	 * Set the value related to the column: premium
	 * @param premium the premium value
	 */
	public void setPremium (java.math.BigDecimal premium) {
		this.premium = premium;
	}



	/**
	 * Return the value associated with the column: amount
	 */
	public java.math.BigDecimal getAmount () {
		return amount;
	}

	/**
	 * Set the value related to the column: amount
	 * @param amount the amount value
	 */
	public void setAmount (java.math.BigDecimal amount) {
		this.amount = amount;
	}



	/**
	 * Return the value associated with the column: next_premium_date
	 */
	public java.util.Date getNextPremiumDate () {
		return nextPremiumDate;
	}

	/**
	 * Set the value related to the column: next_premium_date
	 * @param nextPremiumDate the next_premium_date value
	 */
	public void setNextPremiumDate (java.util.Date nextPremiumDate) {
		this.nextPremiumDate = nextPremiumDate;
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



	/**
	 * Return the value associated with the column: insurance_type_id
	 */
	public jkt.hms.masters.business.HrMasInsurance getInsuranceType () {
		return insuranceType;
	}

	/**
	 * Set the value related to the column: insurance_type_id
	 * @param insuranceType the insurance_type_id value
	 */
	public void setInsuranceType (jkt.hms.masters.business.HrMasInsurance insuranceType) {
		this.insuranceType = insuranceType;
	}



	/**
	 * Return the value associated with the column: location_id
	 */
	public jkt.hms.masters.business.MasHospital getLocation () {
		return location;
	}

	/**
	 * Set the value related to the column: location_id
	 * @param location the location_id value
	 */
	public void setLocation (jkt.hms.masters.business.MasHospital location) {
		this.location = location;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HrInsuranceDetails)) return false;
		else {
			jkt.hms.masters.business.HrInsuranceDetails hrInsuranceDetails = (jkt.hms.masters.business.HrInsuranceDetails) obj;
			if (null == this.getId() || null == hrInsuranceDetails.getId()) return false;
			else return (this.getId().equals(hrInsuranceDetails.getId()));
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
package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_mas_insurance table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_mas_insurance"
 */

public abstract class BaseHrMasInsurance  implements Serializable {

	public static String REF = "HrMasInsurance";
	public static String PROP_STATUS = "Status";
	public static String PROP_INSURANCE_CODE = "InsuranceCode";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_COMPANY = "Company";
	public static String PROP_INSURANCE_TYPE = "InsuranceType";
	public static String PROP_ID = "Id";
	public static String PROP_INSURANCE_NAME = "InsuranceName";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";


	// constructors
	public BaseHrMasInsurance () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrMasInsurance (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String insuranceCode;
	private java.lang.String insuranceName;
	private java.lang.String insuranceType;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasHospital company;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="insurance_id"
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
	 * Return the value associated with the column: insurance_code
	 */
	public java.lang.String getInsuranceCode () {
		return insuranceCode;
	}

	/**
	 * Set the value related to the column: insurance_code
	 * @param insuranceCode the insurance_code value
	 */
	public void setInsuranceCode (java.lang.String insuranceCode) {
		this.insuranceCode = insuranceCode;
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
	 * Return the value associated with the column: insurance_type
	 */
	public java.lang.String getInsuranceType () {
		return insuranceType;
	}

	/**
	 * Set the value related to the column: insurance_type
	 * @param insuranceType the insurance_type value
	 */
	public void setInsuranceType (java.lang.String insuranceType) {
		this.insuranceType = insuranceType;
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
	 * Return the value associated with the column: company_id
	 */
	public jkt.hms.masters.business.MasHospital getCompany () {
		return company;
	}

	/**
	 * Set the value related to the column: company_id
	 * @param company the company_id value
	 */
	public void setCompany (jkt.hms.masters.business.MasHospital company) {
		this.company = company;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HrMasInsurance)) return false;
		else {
			jkt.hms.masters.business.HrMasInsurance hrMasInsurance = (jkt.hms.masters.business.HrMasInsurance) obj;
			if (null == this.getId() || null == hrMasInsurance.getId()) return false;
			else return (this.getId().equals(hrMasInsurance.getId()));
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
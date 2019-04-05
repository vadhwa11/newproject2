package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_mas_itax_surcharge table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_mas_itax_surcharge"
 */

public abstract class BaseHrMasItaxSurcharge  implements Serializable {

	public static String REF = "HrMasItaxSurcharge";
	public static String PROP_STATUS = "Status";
	public static String PROP_MIN_TAX_SAL = "MinTaxSal";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HR_MAS_SURCHARGE = "HrMasSurcharge";
	public static String PROP_UPPER_LIMIT = "UpperLimit";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_FINANCIAL_YEAR = "FinancialYear";
	public static String PROP_SURCHARGE_BASE = "SurchargeBase";
	public static String PROP_PERCENT_TWO = "PercentTwo";
	public static String PROP_LOWER_LIMIT = "LowerLimit";
	public static String PROP_ID = "Id";
	public static String PROP_PERCENT_ONE = "PercentOne";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";


	// constructors
	public BaseHrMasItaxSurcharge () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrMasItaxSurcharge (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String surchargeBase;
	private java.math.BigDecimal lowerLimit;
	private java.math.BigDecimal upperLimit;
	private java.math.BigDecimal percentOne;
	private java.math.BigDecimal percentTwo;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;
	private java.math.BigDecimal minTaxSal;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasStoreFinancial financialYear;
	private jkt.hms.masters.business.HrMasSurcharge hrMasSurcharge;



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
	 * Return the value associated with the column: surcharge_base
	 */
	public java.lang.String getSurchargeBase () {
		return surchargeBase;
	}

	/**
	 * Set the value related to the column: surcharge_base
	 * @param surchargeBase the surcharge_base value
	 */
	public void setSurchargeBase (java.lang.String surchargeBase) {
		this.surchargeBase = surchargeBase;
	}



	/**
	 * Return the value associated with the column: lower_limit
	 */
	public java.math.BigDecimal getLowerLimit () {
		return lowerLimit;
	}

	/**
	 * Set the value related to the column: lower_limit
	 * @param lowerLimit the lower_limit value
	 */
	public void setLowerLimit (java.math.BigDecimal lowerLimit) {
		this.lowerLimit = lowerLimit;
	}



	/**
	 * Return the value associated with the column: upper_limit
	 */
	public java.math.BigDecimal getUpperLimit () {
		return upperLimit;
	}

	/**
	 * Set the value related to the column: upper_limit
	 * @param upperLimit the upper_limit value
	 */
	public void setUpperLimit (java.math.BigDecimal upperLimit) {
		this.upperLimit = upperLimit;
	}



	/**
	 * Return the value associated with the column: percent_one
	 */
	public java.math.BigDecimal getPercentOne () {
		return percentOne;
	}

	/**
	 * Set the value related to the column: percent_one
	 * @param percentOne the percent_one value
	 */
	public void setPercentOne (java.math.BigDecimal percentOne) {
		this.percentOne = percentOne;
	}



	/**
	 * Return the value associated with the column: percent_two
	 */
	public java.math.BigDecimal getPercentTwo () {
		return percentTwo;
	}

	/**
	 * Set the value related to the column: percent_two
	 * @param percentTwo the percent_two value
	 */
	public void setPercentTwo (java.math.BigDecimal percentTwo) {
		this.percentTwo = percentTwo;
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
	 * Return the value associated with the column: minTaxSal
	 */
	public java.math.BigDecimal getMinTaxSal () {
		return minTaxSal;
	}

	/**
	 * Set the value related to the column: minTaxSal
	 * @param minTaxSal the minTaxSal value
	 */
	public void setMinTaxSal (java.math.BigDecimal minTaxSal) {
		this.minTaxSal = minTaxSal;
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
	 * Return the value associated with the column: financial_year_id
	 */
	public jkt.hms.masters.business.MasStoreFinancial getFinancialYear () {
		return financialYear;
	}

	/**
	 * Set the value related to the column: financial_year_id
	 * @param financialYear the financial_year_id value
	 */
	public void setFinancialYear (jkt.hms.masters.business.MasStoreFinancial financialYear) {
		this.financialYear = financialYear;
	}



	/**
	 * Return the value associated with the column: hr_mas_surcharge_id
	 */
	public jkt.hms.masters.business.HrMasSurcharge getHrMasSurcharge () {
		return hrMasSurcharge;
	}

	/**
	 * Set the value related to the column: hr_mas_surcharge_id
	 * @param hrMasSurcharge the hr_mas_surcharge_id value
	 */
	public void setHrMasSurcharge (jkt.hms.masters.business.HrMasSurcharge hrMasSurcharge) {
		this.hrMasSurcharge = hrMasSurcharge;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HrMasItaxSurcharge)) return false;
		else {
			jkt.hms.masters.business.HrMasItaxSurcharge hrMasItaxSurcharge = (jkt.hms.masters.business.HrMasItaxSurcharge) obj;
			if (null == this.getId() || null == hrMasItaxSurcharge.getId()) return false;
			else return (this.getId().equals(hrMasItaxSurcharge.getId()));
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
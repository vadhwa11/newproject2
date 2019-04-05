package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_mas_itax_slab table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_mas_itax_slab"
 */

public abstract class BaseHrMasItaxSlab  implements Serializable {

	public static String REF = "HrMasItaxSlab";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_FINANCIAL_YEAR = "FinancialYear";
	public static String PROP_TAX_RATE = "TaxRate";
	public static String PROP_LOWER_LIMIT = "LowerLimit";
	public static String PROP_CITIZEN = "Citizen";
	public static String PROP_ID = "Id";
	public static String PROP_UPPER_LIMIT = "UpperLimit";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";


	// constructors
	public BaseHrMasItaxSlab () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrMasItaxSlab (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.math.BigDecimal lowerLimit;
	private java.math.BigDecimal upperLimit;
	private java.math.BigDecimal taxRate;
	private java.lang.String citizen;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasStoreFinancial financialYear;



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
	 * Return the value associated with the column: tax_rate
	 */
	public java.math.BigDecimal getTaxRate () {
		return taxRate;
	}

	/**
	 * Set the value related to the column: tax_rate
	 * @param taxRate the tax_rate value
	 */
	public void setTaxRate (java.math.BigDecimal taxRate) {
		this.taxRate = taxRate;
	}



	/**
	 * Return the value associated with the column: citizen
	 */
	public java.lang.String getCitizen () {
		return citizen;
	}

	/**
	 * Set the value related to the column: citizen
	 * @param citizen the citizen value
	 */
	public void setCitizen (java.lang.String citizen) {
		this.citizen = citizen;
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
	 * Return the value associated with the column: financial_year
	 */
	public jkt.hms.masters.business.MasStoreFinancial getFinancialYear () {
		return financialYear;
	}

	/**
	 * Set the value related to the column: financial_year
	 * @param financialYear the financial_year value
	 */
	public void setFinancialYear (jkt.hms.masters.business.MasStoreFinancial financialYear) {
		this.financialYear = financialYear;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HrMasItaxSlab)) return false;
		else {
			jkt.hms.masters.business.HrMasItaxSlab hrMasItaxSlab = (jkt.hms.masters.business.HrMasItaxSlab) obj;
			if (null == this.getId() || null == hrMasItaxSlab.getId()) return false;
			else return (this.getId().equals(hrMasItaxSlab.getId()));
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
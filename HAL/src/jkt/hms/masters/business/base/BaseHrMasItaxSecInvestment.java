package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_mas_itax_sec_investment table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_mas_itax_sec_investment"
 */

public abstract class BaseHrMasItaxSecInvestment  implements Serializable {

	public static String REF = "HrMasItaxSecInvestment";
	public static String PROP_STATUS = "Status";
	public static String PROP_INVESTMENT_TYPE = "InvestmentType";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_MONTHLY_DEPENDENT = "MonthlyDependent";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_BENEFIT_PERCENT = "BenefitPercent";
	public static String PROP_FINANCIAL_YEAR = "FinancialYear";
	public static String PROP_HR_MAS_ITAX_EXEMPTION = "HrMasItaxExemption";
	public static String PROP_BASIC_DEPENDENT = "BasicDependent";
	public static String PROP_ID = "Id";
	public static String PROP_MAX_AMOUNT = "MaxAmount";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";


	// constructors
	public BaseHrMasItaxSecInvestment () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrMasItaxSecInvestment (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.math.BigDecimal maxAmount;
	private java.math.BigDecimal benefitPercent;
	private java.lang.String basicDependent;
	private java.lang.String monthlyDependent;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasStoreFinancial financialYear;
	private jkt.hms.masters.business.HrMasItaxExemption hrMasItaxExemption;
	private jkt.hms.masters.business.HrMasInvestmentType investmentType;



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
	 * Return the value associated with the column: max_amount
	 */
	public java.math.BigDecimal getMaxAmount () {
		return maxAmount;
	}

	/**
	 * Set the value related to the column: max_amount
	 * @param maxAmount the max_amount value
	 */
	public void setMaxAmount (java.math.BigDecimal maxAmount) {
		this.maxAmount = maxAmount;
	}



	/**
	 * Return the value associated with the column: benefit_percent
	 */
	public java.math.BigDecimal getBenefitPercent () {
		return benefitPercent;
	}

	/**
	 * Set the value related to the column: benefit_percent
	 * @param benefitPercent the benefit_percent value
	 */
	public void setBenefitPercent (java.math.BigDecimal benefitPercent) {
		this.benefitPercent = benefitPercent;
	}



	/**
	 * Return the value associated with the column: basic_dependent
	 */
	public java.lang.String getBasicDependent () {
		return basicDependent;
	}

	/**
	 * Set the value related to the column: basic_dependent
	 * @param basicDependent the basic_dependent value
	 */
	public void setBasicDependent (java.lang.String basicDependent) {
		this.basicDependent = basicDependent;
	}



	/**
	 * Return the value associated with the column: monthly_dependent
	 */
	public java.lang.String getMonthlyDependent () {
		return monthlyDependent;
	}

	/**
	 * Set the value related to the column: monthly_dependent
	 * @param monthlyDependent the monthly_dependent value
	 */
	public void setMonthlyDependent (java.lang.String monthlyDependent) {
		this.monthlyDependent = monthlyDependent;
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
	 * Return the value associated with the column: hr_mas_itax_exemption_id
	 */
	public jkt.hms.masters.business.HrMasItaxExemption getHrMasItaxExemption () {
		return hrMasItaxExemption;
	}

	/**
	 * Set the value related to the column: hr_mas_itax_exemption_id
	 * @param hrMasItaxExemption the hr_mas_itax_exemption_id value
	 */
	public void setHrMasItaxExemption (jkt.hms.masters.business.HrMasItaxExemption hrMasItaxExemption) {
		this.hrMasItaxExemption = hrMasItaxExemption;
	}



	/**
	 * Return the value associated with the column: investment_type_id
	 */
	public jkt.hms.masters.business.HrMasInvestmentType getInvestmentType () {
		return investmentType;
	}

	/**
	 * Set the value related to the column: investment_type_id
	 * @param investmentType the investment_type_id value
	 */
	public void setInvestmentType (jkt.hms.masters.business.HrMasInvestmentType investmentType) {
		this.investmentType = investmentType;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HrMasItaxSecInvestment)) return false;
		else {
			jkt.hms.masters.business.HrMasItaxSecInvestment hrMasItaxSecInvestment = (jkt.hms.masters.business.HrMasItaxSecInvestment) obj;
			if (null == this.getId() || null == hrMasItaxSecInvestment.getId()) return false;
			else return (this.getId().equals(hrMasItaxSecInvestment.getId()));
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
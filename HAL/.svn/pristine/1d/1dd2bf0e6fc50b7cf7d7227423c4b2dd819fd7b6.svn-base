package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_store_financial table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_store_financial"
 */

public abstract class BaseMasStoreFinancial  implements Serializable {

	public static String REF = "MasStoreFinancial";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_END_DATE = "EndDate";
	public static String PROP_START_DATE = "StartDate";
	public static String PROP_FINANCIAL_YEAR = "FinancialYear";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_YEAR_DESCRIPTION = "YearDescription";


	// constructors
	public BaseMasStoreFinancial () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasStoreFinancial (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date startDate;
	private java.util.Date endDate;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String financialYear;
	private java.lang.String yearDescription;




	// collections
	private java.util.Set<jkt.hms.masters.business.MasStoreBudget> masStoreBudgets;
	private java.util.Set<jkt.hms.masters.business.HrItaxHeader> hrItaxHeaders;

	private java.util.Set<jkt.hms.masters.business.HrMasItaxExemption> hrMasItaxExemptions;
	private java.util.Set<jkt.hms.masters.business.HrEmployeeInvestment> hrEmployeeInvestments;
	private java.util.Set<jkt.hms.masters.business.HrItaxCalculate> hrItaxCalculates;
	private java.util.Set<jkt.hms.masters.business.HrEmployeeOtherEarning> hrEmployeeOtherEarnings;
	private java.util.Set<jkt.hms.masters.business.HrMasItaxSlab> hrMasItaxSlabs;




	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="financial_id"
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
	 * Return the value associated with the column: start_date
	 */
	public java.util.Date getStartDate () {
		return startDate;
	}

	/**
	 * Set the value related to the column: start_date
	 * @param startDate the start_date value
	 */
	public void setStartDate (java.util.Date startDate) {
		this.startDate = startDate;
	}



	/**
	 * Return the value associated with the column: end_date
	 */
	public java.util.Date getEndDate () {
		return endDate;
	}

	/**
	 * Set the value related to the column: end_date
	 * @param endDate the end_date value
	 */
	public void setEndDate (java.util.Date endDate) {
		this.endDate = endDate;
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

	public java.lang.String getYearDescription() {
		return yearDescription;
	}

	public void setYearDescription(java.lang.String yearDescription) {
		this.yearDescription = yearDescription;
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
	 * Return the value associated with the column: financial_year
	 */
	public java.lang.String getFinancialYear () {
		return financialYear;
	}

	/**
	 * Set the value related to the column: financial_year
	 * @param financialYear the financial_year value
	 */
	public void setFinancialYear (java.lang.String financialYear) {
		this.financialYear = financialYear;
	}


	public java.util.Set<jkt.hms.masters.business.HrItaxHeader> getHrItaxHeaders() {
		return hrItaxHeaders;
	}

	public void setHrItaxHeaders(
			java.util.Set<jkt.hms.masters.business.HrItaxHeader> hrItaxHeaders) {
		this.hrItaxHeaders = hrItaxHeaders;
	}

	public java.util.Set<jkt.hms.masters.business.HrMasItaxExemption> getHrMasItaxExemptions() {
		return hrMasItaxExemptions;
	}

	public void setHrMasItaxExemptions(
			java.util.Set<jkt.hms.masters.business.HrMasItaxExemption> hrMasItaxExemptions) {
		this.hrMasItaxExemptions = hrMasItaxExemptions;
	}

	public java.util.Set<jkt.hms.masters.business.HrEmployeeInvestment> getHrEmployeeInvestments() {
		return hrEmployeeInvestments;
	}

	public void setHrEmployeeInvestments(
			java.util.Set<jkt.hms.masters.business.HrEmployeeInvestment> hrEmployeeInvestments) {
		this.hrEmployeeInvestments = hrEmployeeInvestments;
	}

	public java.util.Set<jkt.hms.masters.business.HrItaxCalculate> getHrItaxCalculates() {
		return hrItaxCalculates;
	}

	public void setHrItaxCalculates(
			java.util.Set<jkt.hms.masters.business.HrItaxCalculate> hrItaxCalculates) {
		this.hrItaxCalculates = hrItaxCalculates;
	}

	public java.util.Set<jkt.hms.masters.business.HrEmployeeOtherEarning> getHrEmployeeOtherEarnings() {
		return hrEmployeeOtherEarnings;
	}

	public void setHrEmployeeOtherEarnings(
			java.util.Set<jkt.hms.masters.business.HrEmployeeOtherEarning> hrEmployeeOtherEarnings) {
		this.hrEmployeeOtherEarnings = hrEmployeeOtherEarnings;
	}

	public java.util.Set<jkt.hms.masters.business.HrMasItaxSlab> getHrMasItaxSlabs() {
		return hrMasItaxSlabs;
	}

	public void setHrMasItaxSlabs(
			java.util.Set<jkt.hms.masters.business.HrMasItaxSlab> hrMasItaxSlabs) {
		this.hrMasItaxSlabs = hrMasItaxSlabs;
	}

	/**
	 * Return the value associated with the column: MasStoreBudgets
	 */
	public java.util.Set<jkt.hms.masters.business.MasStoreBudget> getMasStoreBudgets () {
		return masStoreBudgets;
	}

	/**
	 * Set the value related to the column: MasStoreBudgets
	 * @param masStoreBudgets the MasStoreBudgets value
	 */
	public void setMasStoreBudgets (java.util.Set<jkt.hms.masters.business.MasStoreBudget> masStoreBudgets) {
		this.masStoreBudgets = masStoreBudgets;
	}

	public void addToMasStoreBudgets (jkt.hms.masters.business.MasStoreBudget masStoreBudget) {
		if (null == getMasStoreBudgets()) setMasStoreBudgets(new java.util.TreeSet<jkt.hms.masters.business.MasStoreBudget>());
		getMasStoreBudgets().add(masStoreBudget);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasStoreFinancial)) return false;
		else {
			jkt.hms.masters.business.MasStoreFinancial masStoreFinancial = (jkt.hms.masters.business.MasStoreFinancial) obj;
			if (null == this.getId() || null == masStoreFinancial.getId()) return false;
			else return (this.getId().equals(masStoreFinancial.getId()));
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
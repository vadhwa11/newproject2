package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_mas_financial_year table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_mas_financial_year"
 */

public abstract class BaseHrMasFinancialYear  implements Serializable {

	public static String REF = "HrMasFinancialYear";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_YEAR_TO_DATE = "YearToDate";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_FINANCIAL_YEAR = "FinancialYear";
	public static String PROP_YEAR_DESCRIPTION = "YearDescription";
	public static String PROP_YEAR_FROM_DATE = "YearFromDate";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";


	// constructors
	public BaseHrMasFinancialYear () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrMasFinancialYear (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String yearDescription;
	private java.util.Date yearFromDate;
	private java.util.Date yearToDate;
	private java.lang.String financialYear;
	private java.lang.String status;
	private java.lang.Integer lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// collections
	private java.util.Set<jkt.hms.masters.business.HrMasItaxExemption> hrMasItaxExemptions;
	private java.util.Set<jkt.hms.masters.business.HrEmployeeInvestment> hrEmployeeInvestments;
	private java.util.Set<jkt.hms.masters.business.HrItaxHeader> hrItaxHeaders;
	private java.util.Set<jkt.hms.masters.business.HrItaxCalculate> hrItaxCalculates;
	private java.util.Set<jkt.hms.masters.business.HrEmployeeOtherEarning> hrEmployeeOtherEarnings;
	private java.util.Set<jkt.hms.masters.business.HrMasItaxSlab> hrMasItaxSlabs;
	private java.util.Set<jkt.hms.masters.business.FaAccountOpening> faAccountOpenings;
	private java.util.Set<jkt.hms.masters.business.FaVoucherHeader> faVoucherHeaders;
	private java.util.Set<jkt.hms.masters.business.HrMasItaxSecInvestment> hrMasItaxSecInvestments;
	private java.util.Set<jkt.hms.masters.business.HrMasItaxSurcharge> hrMasItaxSurcharges;



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
	 * Return the value associated with the column: year_description
	 */
	public java.lang.String getYearDescription () {
		return yearDescription;
	}

	/**
	 * Set the value related to the column: year_description
	 * @param yearDescription the year_description value
	 */
	public void setYearDescription (java.lang.String yearDescription) {
		this.yearDescription = yearDescription;
	}



	/**
	 * Return the value associated with the column: year_from_date
	 */
	public java.util.Date getYearFromDate () {
		return yearFromDate;
	}

	/**
	 * Set the value related to the column: year_from_date
	 * @param yearFromDate the year_from_date value
	 */
	public void setYearFromDate (java.util.Date yearFromDate) {
		this.yearFromDate = yearFromDate;
	}



	/**
	 * Return the value associated with the column: year_to_date
	 */
	public java.util.Date getYearToDate () {
		return yearToDate;
	}

	/**
	 * Set the value related to the column: year_to_date
	 * @param yearToDate the year_to_date value
	 */
	public void setYearToDate (java.util.Date yearToDate) {
		this.yearToDate = yearToDate;
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
	public java.lang.Integer getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (java.lang.Integer lastChgBy) {
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
	 * Return the value associated with the column: HrMasItaxExemptions
	 */
	public java.util.Set<jkt.hms.masters.business.HrMasItaxExemption> getHrMasItaxExemptions () {
		return hrMasItaxExemptions;
	}

	/**
	 * Set the value related to the column: HrMasItaxExemptions
	 * @param hrMasItaxExemptions the HrMasItaxExemptions value
	 */
	public void setHrMasItaxExemptions (java.util.Set<jkt.hms.masters.business.HrMasItaxExemption> hrMasItaxExemptions) {
		this.hrMasItaxExemptions = hrMasItaxExemptions;
	}

	public void addToHrMasItaxExemptions (jkt.hms.masters.business.HrMasItaxExemption hrMasItaxExemption) {
		if (null == getHrMasItaxExemptions()) setHrMasItaxExemptions(new java.util.TreeSet<jkt.hms.masters.business.HrMasItaxExemption>());
		getHrMasItaxExemptions().add(hrMasItaxExemption);
	}



	/**
	 * Return the value associated with the column: HrEmployeeInvestments
	 */
	public java.util.Set<jkt.hms.masters.business.HrEmployeeInvestment> getHrEmployeeInvestments () {
		return hrEmployeeInvestments;
	}

	/**
	 * Set the value related to the column: HrEmployeeInvestments
	 * @param hrEmployeeInvestments the HrEmployeeInvestments value
	 */
	public void setHrEmployeeInvestments (java.util.Set<jkt.hms.masters.business.HrEmployeeInvestment> hrEmployeeInvestments) {
		this.hrEmployeeInvestments = hrEmployeeInvestments;
	}

	public void addToHrEmployeeInvestments (jkt.hms.masters.business.HrEmployeeInvestment hrEmployeeInvestment) {
		if (null == getHrEmployeeInvestments()) setHrEmployeeInvestments(new java.util.TreeSet<jkt.hms.masters.business.HrEmployeeInvestment>());
		getHrEmployeeInvestments().add(hrEmployeeInvestment);
	}



	/**
	 * Return the value associated with the column: HrItaxHeaders
	 */
	public java.util.Set<jkt.hms.masters.business.HrItaxHeader> getHrItaxHeaders () {
		return hrItaxHeaders;
	}

	/**
	 * Set the value related to the column: HrItaxHeaders
	 * @param hrItaxHeaders the HrItaxHeaders value
	 */
	public void setHrItaxHeaders (java.util.Set<jkt.hms.masters.business.HrItaxHeader> hrItaxHeaders) {
		this.hrItaxHeaders = hrItaxHeaders;
	}

	public void addToHrItaxHeaders (jkt.hms.masters.business.HrItaxHeader hrItaxHeader) {
		if (null == getHrItaxHeaders()) setHrItaxHeaders(new java.util.TreeSet<jkt.hms.masters.business.HrItaxHeader>());
		getHrItaxHeaders().add(hrItaxHeader);
	}



	/**
	 * Return the value associated with the column: HrItaxCalculates
	 */
	public java.util.Set<jkt.hms.masters.business.HrItaxCalculate> getHrItaxCalculates () {
		return hrItaxCalculates;
	}

	/**
	 * Set the value related to the column: HrItaxCalculates
	 * @param hrItaxCalculates the HrItaxCalculates value
	 */
	public void setHrItaxCalculates (java.util.Set<jkt.hms.masters.business.HrItaxCalculate> hrItaxCalculates) {
		this.hrItaxCalculates = hrItaxCalculates;
	}

	public void addToHrItaxCalculates (jkt.hms.masters.business.HrItaxCalculate hrItaxCalculate) {
		if (null == getHrItaxCalculates()) setHrItaxCalculates(new java.util.TreeSet<jkt.hms.masters.business.HrItaxCalculate>());
		getHrItaxCalculates().add(hrItaxCalculate);
	}



	/**
	 * Return the value associated with the column: HrEmployeeOtherEarnings
	 */
	public java.util.Set<jkt.hms.masters.business.HrEmployeeOtherEarning> getHrEmployeeOtherEarnings () {
		return hrEmployeeOtherEarnings;
	}

	/**
	 * Set the value related to the column: HrEmployeeOtherEarnings
	 * @param hrEmployeeOtherEarnings the HrEmployeeOtherEarnings value
	 */
	public void setHrEmployeeOtherEarnings (java.util.Set<jkt.hms.masters.business.HrEmployeeOtherEarning> hrEmployeeOtherEarnings) {
		this.hrEmployeeOtherEarnings = hrEmployeeOtherEarnings;
	}

	public void addToHrEmployeeOtherEarnings (jkt.hms.masters.business.HrEmployeeOtherEarning hrEmployeeOtherEarning) {
		if (null == getHrEmployeeOtherEarnings()) setHrEmployeeOtherEarnings(new java.util.TreeSet<jkt.hms.masters.business.HrEmployeeOtherEarning>());
		getHrEmployeeOtherEarnings().add(hrEmployeeOtherEarning);
	}



	/**
	 * Return the value associated with the column: HrMasItaxSlabs
	 */
	public java.util.Set<jkt.hms.masters.business.HrMasItaxSlab> getHrMasItaxSlabs () {
		return hrMasItaxSlabs;
	}

	/**
	 * Set the value related to the column: HrMasItaxSlabs
	 * @param hrMasItaxSlabs the HrMasItaxSlabs value
	 */
	public void setHrMasItaxSlabs (java.util.Set<jkt.hms.masters.business.HrMasItaxSlab> hrMasItaxSlabs) {
		this.hrMasItaxSlabs = hrMasItaxSlabs;
	}

	public void addToHrMasItaxSlabs (jkt.hms.masters.business.HrMasItaxSlab hrMasItaxSlab) {
		if (null == getHrMasItaxSlabs()) setHrMasItaxSlabs(new java.util.TreeSet<jkt.hms.masters.business.HrMasItaxSlab>());
		getHrMasItaxSlabs().add(hrMasItaxSlab);
	}



	/**
	 * Return the value associated with the column: FaAccountOpenings
	 */
	public java.util.Set<jkt.hms.masters.business.FaAccountOpening> getFaAccountOpenings () {
		return faAccountOpenings;
	}

	/**
	 * Set the value related to the column: FaAccountOpenings
	 * @param faAccountOpenings the FaAccountOpenings value
	 */
	public void setFaAccountOpenings (java.util.Set<jkt.hms.masters.business.FaAccountOpening> faAccountOpenings) {
		this.faAccountOpenings = faAccountOpenings;
	}

	public void addToFaAccountOpenings (jkt.hms.masters.business.FaAccountOpening faAccountOpening) {
		if (null == getFaAccountOpenings()) setFaAccountOpenings(new java.util.TreeSet<jkt.hms.masters.business.FaAccountOpening>());
		getFaAccountOpenings().add(faAccountOpening);
	}



	/**
	 * Return the value associated with the column: FaVoucherHeaders
	 */
	public java.util.Set<jkt.hms.masters.business.FaVoucherHeader> getFaVoucherHeaders () {
		return faVoucherHeaders;
	}

	/**
	 * Set the value related to the column: FaVoucherHeaders
	 * @param faVoucherHeaders the FaVoucherHeaders value
	 */
	public void setFaVoucherHeaders (java.util.Set<jkt.hms.masters.business.FaVoucherHeader> faVoucherHeaders) {
		this.faVoucherHeaders = faVoucherHeaders;
	}

	public void addToFaVoucherHeaders (jkt.hms.masters.business.FaVoucherHeader faVoucherHeader) {
		if (null == getFaVoucherHeaders()) setFaVoucherHeaders(new java.util.TreeSet<jkt.hms.masters.business.FaVoucherHeader>());
		getFaVoucherHeaders().add(faVoucherHeader);
	}



	/**
	 * Return the value associated with the column: HrMasItaxSecInvestments
	 */
	public java.util.Set<jkt.hms.masters.business.HrMasItaxSecInvestment> getHrMasItaxSecInvestments () {
		return hrMasItaxSecInvestments;
	}

	/**
	 * Set the value related to the column: HrMasItaxSecInvestments
	 * @param hrMasItaxSecInvestments the HrMasItaxSecInvestments value
	 */
	public void setHrMasItaxSecInvestments (java.util.Set<jkt.hms.masters.business.HrMasItaxSecInvestment> hrMasItaxSecInvestments) {
		this.hrMasItaxSecInvestments = hrMasItaxSecInvestments;
	}

	public void addToHrMasItaxSecInvestments (jkt.hms.masters.business.HrMasItaxSecInvestment hrMasItaxSecInvestment) {
		if (null == getHrMasItaxSecInvestments()) setHrMasItaxSecInvestments(new java.util.TreeSet<jkt.hms.masters.business.HrMasItaxSecInvestment>());
		getHrMasItaxSecInvestments().add(hrMasItaxSecInvestment);
	}



	/**
	 * Return the value associated with the column: HrMasItaxSurcharges
	 */
	public java.util.Set<jkt.hms.masters.business.HrMasItaxSurcharge> getHrMasItaxSurcharges () {
		return hrMasItaxSurcharges;
	}

	/**
	 * Set the value related to the column: HrMasItaxSurcharges
	 * @param hrMasItaxSurcharges the HrMasItaxSurcharges value
	 */
	public void setHrMasItaxSurcharges (java.util.Set<jkt.hms.masters.business.HrMasItaxSurcharge> hrMasItaxSurcharges) {
		this.hrMasItaxSurcharges = hrMasItaxSurcharges;
	}

	public void addToHrMasItaxSurcharges (jkt.hms.masters.business.HrMasItaxSurcharge hrMasItaxSurcharge) {
		if (null == getHrMasItaxSurcharges()) setHrMasItaxSurcharges(new java.util.TreeSet<jkt.hms.masters.business.HrMasItaxSurcharge>());
		getHrMasItaxSurcharges().add(hrMasItaxSurcharge);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HrMasFinancialYear)) return false;
		else {
			jkt.hms.masters.business.HrMasFinancialYear hrMasFinancialYear = (jkt.hms.masters.business.HrMasFinancialYear) obj;
			if (null == this.getId() || null == hrMasFinancialYear.getId()) return false;
			else return (this.getId().equals(hrMasFinancialYear.getId()));
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
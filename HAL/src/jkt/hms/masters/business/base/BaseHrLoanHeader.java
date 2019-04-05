package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_loan_header table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_loan_header"
 */

public abstract class BaseHrLoanHeader  implements Serializable {

	public static String REF = "HrLoanHeader";
	public static String PROP_BALANCE_LOAN = "BalanceLoan";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_LOAN_INTEREST_DATE = "LoanInterestDate";
	public static String PROP_MONTHLY_INSTALL = "MonthlyInstall";
	public static String PROP_LOAN_PERIOD = "LoanPeriod";
	public static String PROP_LOAN_STATUS = "LoanStatus";
	public static String PROP_STATUS = "Status";
	public static String PROP_LOAN = "Loan";
	public static String PROP_LOAN_INTEREST = "LoanInterest";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LOAN_DATE = "LoanDate";
	public static String PROP_DEDUCT_FROM = "DeductFrom";
	public static String PROP_LAST_PAYMENT_DATE = "LastPaymentDate";
	public static String PROP_ID = "Id";
	public static String PROP_LOAN_C_AMOUNT = "LoanCAmount";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_LOAN_P_AMOUNT = "LoanPAmount";


	// constructors
	public BaseHrLoanHeader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrLoanHeader (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date loanDate;
	private java.math.BigDecimal loanPAmount;
	private java.lang.Float loanInterest;
	private java.math.BigDecimal monthlyInstall;
	private java.math.BigDecimal loanCAmount;
	private java.lang.Integer loanPeriod;
	private java.lang.String deductFrom;
	private java.lang.String loanStatus;
	private java.util.Date loanInterestDate;
	private java.lang.String lastChgTime;
	private java.util.Date lastChgDate;
	private java.lang.String status;
	private java.util.Date lastPaymentDate;
	private java.math.BigDecimal balanceLoan;

	// many to one
	private jkt.hms.masters.business.HrMasLoan loan;
	private jkt.hms.masters.business.MasEmployee employee;
	private jkt.hms.masters.business.Users lastChgBy;

	// collections
	private java.util.Set<jkt.hms.masters.business.HrLoanDetail> hrLoanDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="loan_header_id"
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
	 * Return the value associated with the column: loan_date
	 */
	public java.util.Date getLoanDate () {
		return loanDate;
	}

	/**
	 * Set the value related to the column: loan_date
	 * @param loanDate the loan_date value
	 */
	public void setLoanDate (java.util.Date loanDate) {
		this.loanDate = loanDate;
	}



	/**
	 * Return the value associated with the column: loan_p_amount
	 */
	public java.math.BigDecimal getLoanPAmount () {
		return loanPAmount;
	}

	/**
	 * Set the value related to the column: loan_p_amount
	 * @param loanPAmount the loan_p_amount value
	 */
	public void setLoanPAmount (java.math.BigDecimal loanPAmount) {
		this.loanPAmount = loanPAmount;
	}



	/**
	 * Return the value associated with the column: loan_interest
	 */
	public java.lang.Float getLoanInterest () {
		return loanInterest;
	}

	/**
	 * Set the value related to the column: loan_interest
	 * @param loanInterest the loan_interest value
	 */
	public void setLoanInterest (java.lang.Float loanInterest) {
		this.loanInterest = loanInterest;
	}



	/**
	 * Return the value associated with the column: monthly_install
	 */
	public java.math.BigDecimal getMonthlyInstall () {
		return monthlyInstall;
	}

	/**
	 * Set the value related to the column: monthly_install
	 * @param monthlyInstall the monthly_install value
	 */
	public void setMonthlyInstall (java.math.BigDecimal monthlyInstall) {
		this.monthlyInstall = monthlyInstall;
	}



	/**
	 * Return the value associated with the column: loan_c_amount
	 */
	public java.math.BigDecimal getLoanCAmount () {
		return loanCAmount;
	}

	/**
	 * Set the value related to the column: loan_c_amount
	 * @param loanCAmount the loan_c_amount value
	 */
	public void setLoanCAmount (java.math.BigDecimal loanCAmount) {
		this.loanCAmount = loanCAmount;
	}



	/**
	 * Return the value associated with the column: loan_period
	 */
	public java.lang.Integer getLoanPeriod () {
		return loanPeriod;
	}

	/**
	 * Set the value related to the column: loan_period
	 * @param loanPeriod the loan_period value
	 */
	public void setLoanPeriod (java.lang.Integer loanPeriod) {
		this.loanPeriod = loanPeriod;
	}



	/**
	 * Return the value associated with the column: deduct_from
	 */
	public java.lang.String getDeductFrom () {
		return deductFrom;
	}

	/**
	 * Set the value related to the column: deduct_from
	 * @param deductFrom the deduct_from value
	 */
	public void setDeductFrom (java.lang.String deductFrom) {
		this.deductFrom = deductFrom;
	}



	/**
	 * Return the value associated with the column: loan_status
	 */
	public java.lang.String getLoanStatus () {
		return loanStatus;
	}

	/**
	 * Set the value related to the column: loan_status
	 * @param loanStatus the loan_status value
	 */
	public void setLoanStatus (java.lang.String loanStatus) {
		this.loanStatus = loanStatus;
	}



	/**
	 * Return the value associated with the column: loan_interest_date
	 */
	public java.util.Date getLoanInterestDate () {
		return loanInterestDate;
	}

	/**
	 * Set the value related to the column: loan_interest_date
	 * @param loanInterestDate the loan_interest_date value
	 */
	public void setLoanInterestDate (java.util.Date loanInterestDate) {
		this.loanInterestDate = loanInterestDate;
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
	 * Return the value associated with the column: last_payment_date
	 */
	public java.util.Date getLastPaymentDate () {
		return lastPaymentDate;
	}

	/**
	 * Set the value related to the column: last_payment_date
	 * @param lastPaymentDate the last_payment_date value
	 */
	public void setLastPaymentDate (java.util.Date lastPaymentDate) {
		this.lastPaymentDate = lastPaymentDate;
	}



	/**
	 * Return the value associated with the column: balanceLoan
	 */
	public java.math.BigDecimal getBalanceLoan () {
		return balanceLoan;
	}

	/**
	 * Set the value related to the column: balanceLoan
	 * @param balanceLoan the balanceLoan value
	 */
	public void setBalanceLoan (java.math.BigDecimal balanceLoan) {
		this.balanceLoan = balanceLoan;
	}



	/**
	 * Return the value associated with the column: loan_id
	 */
	public jkt.hms.masters.business.HrMasLoan getLoan () {
		return loan;
	}

	/**
	 * Set the value related to the column: loan_id
	 * @param loan the loan_id value
	 */
	public void setLoan (jkt.hms.masters.business.HrMasLoan loan) {
		this.loan = loan;
	}



	/**
	 * Return the value associated with the column: employee_id
	 */
	public jkt.hms.masters.business.MasEmployee getEmployee () {
		return employee;
	}

	/**
	 * Set the value related to the column: employee_id
	 * @param employee the employee_id value
	 */
	public void setEmployee (jkt.hms.masters.business.MasEmployee employee) {
		this.employee = employee;
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
	 * Return the value associated with the column: HrLoanDetails
	 */
	public java.util.Set<jkt.hms.masters.business.HrLoanDetail> getHrLoanDetails () {
		return hrLoanDetails;
	}

	/**
	 * Set the value related to the column: HrLoanDetails
	 * @param hrLoanDetails the HrLoanDetails value
	 */
	public void setHrLoanDetails (java.util.Set<jkt.hms.masters.business.HrLoanDetail> hrLoanDetails) {
		this.hrLoanDetails = hrLoanDetails;
	}

	public void addToHrLoanDetails (jkt.hms.masters.business.HrLoanDetail hrLoanDetail) {
		if (null == getHrLoanDetails()) setHrLoanDetails(new java.util.TreeSet<jkt.hms.masters.business.HrLoanDetail>());
		getHrLoanDetails().add(hrLoanDetail);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HrLoanHeader)) return false;
		else {
			jkt.hms.masters.business.HrLoanHeader hrLoanHeader = (jkt.hms.masters.business.HrLoanHeader) obj;
			if (null == this.getId() || null == hrLoanHeader.getId()) return false;
			else return (this.getId().equals(hrLoanHeader.getId()));
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
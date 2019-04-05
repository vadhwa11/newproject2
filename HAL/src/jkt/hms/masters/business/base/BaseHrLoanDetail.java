package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_loan_detail table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_loan_detail"
 */

public abstract class BaseHrLoanDetail  implements Serializable {

	public static String REF = "HrLoanDetail";
	public static String PROP_INSTALL_DATE = "InstallDate";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_P_PAID = "PPaid";
	public static String PROP_BALANCE_LOAN = "BalanceLoan";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LOAN_HEADER = "LoanHeader";
	public static String PROP_INSTALL_AMOUNT = "InstallAmount";
	public static String PROP_ID = "Id";
	public static String PROP_INTEREST_PAID = "InterestPaid";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_REMARK = "Remark";


	// constructors
	public BaseHrLoanDetail () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrLoanDetail (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.math.BigDecimal balanceLoan;
	private java.util.Date installDate;
	private java.math.BigDecimal installAmount;
	private java.math.BigDecimal interestPaid;
	private java.math.BigDecimal pPaid;
	private java.lang.String remark;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.HrLoanHeader loanHeader;
	private jkt.hms.masters.business.Users lastChgBy;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="loan_detail_id"
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
	 * Return the value associated with the column: balance_loan
	 */
	public java.math.BigDecimal getBalanceLoan () {
		return balanceLoan;
	}

	/**
	 * Set the value related to the column: balance_loan
	 * @param balanceLoan the balance_loan value
	 */
	public void setBalanceLoan (java.math.BigDecimal balanceLoan) {
		this.balanceLoan = balanceLoan;
	}



	/**
	 * Return the value associated with the column: install_date
	 */
	public java.util.Date getInstallDate () {
		return installDate;
	}

	/**
	 * Set the value related to the column: install_date
	 * @param installDate the install_date value
	 */
	public void setInstallDate (java.util.Date installDate) {
		this.installDate = installDate;
	}



	/**
	 * Return the value associated with the column: install_amount
	 */
	public java.math.BigDecimal getInstallAmount () {
		return installAmount;
	}

	/**
	 * Set the value related to the column: install_amount
	 * @param installAmount the install_amount value
	 */
	public void setInstallAmount (java.math.BigDecimal installAmount) {
		this.installAmount = installAmount;
	}



	/**
	 * Return the value associated with the column: interest_paid
	 */
	public java.math.BigDecimal getInterestPaid () {
		return interestPaid;
	}

	/**
	 * Set the value related to the column: interest_paid
	 * @param interestPaid the interest_paid value
	 */
	public void setInterestPaid (java.math.BigDecimal interestPaid) {
		this.interestPaid = interestPaid;
	}



	/**
	 * Return the value associated with the column: p_paid
	 */
	public java.math.BigDecimal getPPaid () {
		return pPaid;
	}

	/**
	 * Set the value related to the column: p_paid
	 * @param pPaid the p_paid value
	 */
	public void setPPaid (java.math.BigDecimal pPaid) {
		this.pPaid = pPaid;
	}



	/**
	 * Return the value associated with the column: remark
	 */
	public java.lang.String getRemark () {
		return remark;
	}

	/**
	 * Set the value related to the column: remark
	 * @param remark the remark value
	 */
	public void setRemark (java.lang.String remark) {
		this.remark = remark;
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
	 * Return the value associated with the column: loan_header_id
	 */
	public jkt.hms.masters.business.HrLoanHeader getLoanHeader () {
		return loanHeader;
	}

	/**
	 * Set the value related to the column: loan_header_id
	 * @param loanHeader the loan_header_id value
	 */
	public void setLoanHeader (jkt.hms.masters.business.HrLoanHeader loanHeader) {
		this.loanHeader = loanHeader;
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
		if (!(obj instanceof jkt.hms.masters.business.HrLoanDetail)) return false;
		else {
			jkt.hms.masters.business.HrLoanDetail hrLoanDetail = (jkt.hms.masters.business.HrLoanDetail) obj;
			if (null == this.getId() || null == hrLoanDetail.getId()) return false;
			else return (this.getId().equals(hrLoanDetail.getId()));
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
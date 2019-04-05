package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the account_group_transac table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="account_group_transac"
 */

public abstract class BaseAccountGroupTransac  implements Serializable {

	public static String REF = "AccountGroupTransac";
	public static String PROP_ACCOUNT_GROUP = "AccountGroup";
	public static String PROP_OP_BALANCE_CR = "OpBalanceCr";
	public static String PROP_FINANCIAL_YEAR = "FinancialYear";
	public static String PROP_CL_BALANCE_CR = "ClBalanceCr";
	public static String PROP_TRANSACTION_DATE = "TransactionDate";
	public static String PROP_YTD_AMOUNT_DR = "YtdAmountDr";
	public static String PROP_ID = "Id";
	public static String PROP_YTD_AMOUNT_CR = "YtdAmountCr";
	public static String PROP_TRANSACTION_TIME = "TransactionTime";
	public static String PROP_CENTRE = "Centre";
	public static String PROP_CL_BALANCE_DR = "ClBalanceDr";
	public static String PROP_OP_BALANCE_DR = "OpBalanceDr";


	// constructors
	public BaseAccountGroupTransac () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAccountGroupTransac (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date transactionDate;
	private java.lang.String transactionTime;
	private java.math.BigDecimal ytdAmountDr;
	private java.math.BigDecimal ytdAmountCr;
	private java.math.BigDecimal opBalanceDr;
	private java.math.BigDecimal opBalanceCr;
	private java.math.BigDecimal clBalanceDr;
	private java.math.BigDecimal clBalanceCr;

	// many to one
	private jkt.hms.masters.business.FaMasAccountGroup accountGroup;
	private jkt.hms.masters.business.MasHospital centre;
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
	 * Return the value associated with the column: transaction_date
	 */
	public java.util.Date getTransactionDate () {
		return transactionDate;
	}

	/**
	 * Set the value related to the column: transaction_date
	 * @param transactionDate the transaction_date value
	 */
	public void setTransactionDate (java.util.Date transactionDate) {
		this.transactionDate = transactionDate;
	}



	/**
	 * Return the value associated with the column: transaction_time
	 */
	public java.lang.String getTransactionTime () {
		return transactionTime;
	}

	/**
	 * Set the value related to the column: transaction_time
	 * @param transactionTime the transaction_time value
	 */
	public void setTransactionTime (java.lang.String transactionTime) {
		this.transactionTime = transactionTime;
	}



	/**
	 * Return the value associated with the column: ytd_amount_dr
	 */
	public java.math.BigDecimal getYtdAmountDr () {
		return ytdAmountDr;
	}

	/**
	 * Set the value related to the column: ytd_amount_dr
	 * @param ytdAmountDr the ytd_amount_dr value
	 */
	public void setYtdAmountDr (java.math.BigDecimal ytdAmountDr) {
		this.ytdAmountDr = ytdAmountDr;
	}



	/**
	 * Return the value associated with the column: ytd_amount_cr
	 */
	public java.math.BigDecimal getYtdAmountCr () {
		return ytdAmountCr;
	}

	/**
	 * Set the value related to the column: ytd_amount_cr
	 * @param ytdAmountCr the ytd_amount_cr value
	 */
	public void setYtdAmountCr (java.math.BigDecimal ytdAmountCr) {
		this.ytdAmountCr = ytdAmountCr;
	}



	/**
	 * Return the value associated with the column: op_balance_dr
	 */
	public java.math.BigDecimal getOpBalanceDr () {
		return opBalanceDr;
	}

	/**
	 * Set the value related to the column: op_balance_dr
	 * @param opBalanceDr the op_balance_dr value
	 */
	public void setOpBalanceDr (java.math.BigDecimal opBalanceDr) {
		this.opBalanceDr = opBalanceDr;
	}



	/**
	 * Return the value associated with the column: op_balance_cr
	 */
	public java.math.BigDecimal getOpBalanceCr () {
		return opBalanceCr;
	}

	/**
	 * Set the value related to the column: op_balance_cr
	 * @param opBalanceCr the op_balance_cr value
	 */
	public void setOpBalanceCr (java.math.BigDecimal opBalanceCr) {
		this.opBalanceCr = opBalanceCr;
	}



	/**
	 * Return the value associated with the column: cl_balance_dr
	 */
	public java.math.BigDecimal getClBalanceDr () {
		return clBalanceDr;
	}

	/**
	 * Set the value related to the column: cl_balance_dr
	 * @param clBalanceDr the cl_balance_dr value
	 */
	public void setClBalanceDr (java.math.BigDecimal clBalanceDr) {
		this.clBalanceDr = clBalanceDr;
	}



	/**
	 * Return the value associated with the column: cl_balance_cr
	 */
	public java.math.BigDecimal getClBalanceCr () {
		return clBalanceCr;
	}

	/**
	 * Set the value related to the column: cl_balance_cr
	 * @param clBalanceCr the cl_balance_cr value
	 */
	public void setClBalanceCr (java.math.BigDecimal clBalanceCr) {
		this.clBalanceCr = clBalanceCr;
	}



	/**
	 * Return the value associated with the column: group_id
	 */
	public jkt.hms.masters.business.FaMasAccountGroup getAccountGroup () {
		return accountGroup;
	}

	/**
	 * Set the value related to the column: group_id
	 * @param accountGroup the group_id value
	 */
	public void setAccountGroup (jkt.hms.masters.business.FaMasAccountGroup accountGroup) {
		this.accountGroup = accountGroup;
	}



	/**
	 * Return the value associated with the column: location_id
	 */
	public jkt.hms.masters.business.MasHospital getCentre () {
		return centre;
	}

	/**
	 * Set the value related to the column: location_id
	 * @param centre the location_id value
	 */
	public void setCentre (jkt.hms.masters.business.MasHospital centre) {
		this.centre = centre;
	}



	/**
	 * Return the value associated with the column: f_year_id
	 */
	public jkt.hms.masters.business.MasStoreFinancial getFinancialYear () {
		return financialYear;
	}

	/**
	 * Set the value related to the column: f_year_id
	 * @param financialYear the f_year_id value
	 */
	public void setFinancialYear (jkt.hms.masters.business.MasStoreFinancial financialYear) {
		this.financialYear = financialYear;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.AccountGroupTransac)) return false;
		else {
			jkt.hms.masters.business.AccountGroupTransac accountGroupTransac = (jkt.hms.masters.business.AccountGroupTransac) obj;
			if (null == this.getId() || null == accountGroupTransac.getId()) return false;
			else return (this.getId().equals(accountGroupTransac.getId()));
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
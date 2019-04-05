package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the fa_branch_account_master table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="fa_branch_account_master"
 */

public abstract class BaseFaBranchAccountMaster  implements Serializable {

	public static String REF = "FaBranchAccountMaster";
	public static String PROP_YTD_BALANCE_CR = "YtdBalanceCr";
	public static String PROP_BRANCH = "Branch";
	public static String PROP_OP_BALANCE_CR = "OpBalanceCr";
	public static String PROP_CL_BALANCE_CR = "ClBalanceCr";
	public static String PROP_ACCOUNT = "Account";
	public static String PROP_ID = "Id";
	public static String PROP_YTD_BALANCE_DR = "YtdBalanceDr";
	public static String PROP_SUB_LEDGER = "SubLedger";
	public static String PROP_CL_BALANCE_DR = "ClBalanceDr";
	public static String PROP_OP_BALANCE_DR = "OpBalanceDr";


	// constructors
	public BaseFaBranchAccountMaster () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFaBranchAccountMaster (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.math.BigDecimal opBalanceDr;
	private java.math.BigDecimal opBalanceCr;
	private java.math.BigDecimal ytdBalanceDr;
	private java.math.BigDecimal ytdBalanceCr;
	private java.math.BigDecimal clBalanceDr;
	private java.math.BigDecimal clBalanceCr;

	// many to one
	private jkt.hms.masters.business.FaMasAccount account;
	private jkt.hms.masters.business.FaMasSubLed subLedger;
	/*private jkt.hms.masters.business.MasBranch branch;*/



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="branch_account_id"
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
	 * Return the value associated with the column: ytd_balance_dr
	 */
	public java.math.BigDecimal getYtdBalanceDr () {
		return ytdBalanceDr;
	}

	/**
	 * Set the value related to the column: ytd_balance_dr
	 * @param ytdBalanceDr the ytd_balance_dr value
	 */
	public void setYtdBalanceDr (java.math.BigDecimal ytdBalanceDr) {
		this.ytdBalanceDr = ytdBalanceDr;
	}



	/**
	 * Return the value associated with the column: ytd_balance_cr
	 */
	public java.math.BigDecimal getYtdBalanceCr () {
		return ytdBalanceCr;
	}

	/**
	 * Set the value related to the column: ytd_balance_cr
	 * @param ytdBalanceCr the ytd_balance_cr value
	 */
	public void setYtdBalanceCr (java.math.BigDecimal ytdBalanceCr) {
		this.ytdBalanceCr = ytdBalanceCr;
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
	 * Return the value associated with the column: account_id
	 */
	public jkt.hms.masters.business.FaMasAccount getAccount () {
		return account;
	}

	/**
	 * Set the value related to the column: account_id
	 * @param account the account_id value
	 */
	public void setAccount (jkt.hms.masters.business.FaMasAccount account) {
		this.account = account;
	}



	/**
	 * Return the value associated with the column: sub_ledger_id
	 */
	public jkt.hms.masters.business.FaMasSubLed getSubLedger () {
		return subLedger;
	}

	/**
	 * Set the value related to the column: sub_ledger_id
	 * @param subLedger the sub_ledger_id value
	 */
	public void setSubLedger (jkt.hms.masters.business.FaMasSubLed subLedger) {
		this.subLedger = subLedger;
	}



	/**
	 * Return the value associated with the column: branch_id
	 */
	/*public jkt.hms.masters.business.MasBranch getBranch () {
		return branch;
	}*/

	/**
	 * Set the value related to the column: branch_id
	 * @param branch the branch_id value
	 */
	/*public void setBranch (jkt.hms.masters.business.MasBranch branch) {
		this.branch = branch;
	}*/




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.FaBranchAccountMaster)) return false;
		else {
			jkt.hms.masters.business.FaBranchAccountMaster faBranchAccountMaster = (jkt.hms.masters.business.FaBranchAccountMaster) obj;
			if (null == this.getId() || null == faBranchAccountMaster.getId()) return false;
			else return (this.getId().equals(faBranchAccountMaster.getId()));
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
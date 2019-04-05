package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the budget_expense_entry_detail table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="budget_expense_entry_detail"
 */

public abstract class BaseBudgetExpenseEntryDetail  implements Serializable {

	public static String REF = "BudgetExpenseEntryDetail";
	public static String PROP_AMOUNT_ALLOTTED = "AmountAllotted";
	public static String PROP_BUDGET_EXPENSE_ENTRY_HEADER = "budgetExpenseEntryHeader";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_ID = "Id";
	public static String PROP_DETAIL_DATE = "DetailDate";
	public static String PROP_BALANCE = "Balance";
	public static String PROP_EXPENDED_AMOUNT = "ExpendedAmount";


	// constructors
	public BaseBudgetExpenseEntryDetail () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBudgetExpenseEntryDetail (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date detailDate;
	private java.lang.Integer amountAllotted;
	private java.lang.Integer expendedAmount;
	private java.lang.Integer balance;
	private java.lang.String remarks;

	// many to one
	private jkt.hms.masters.business.BudgetExpenseEntryHeader budgetExpenseEntryHeader;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="budget_expense_entry_detail_id"
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
	 * Return the value associated with the column: detail_date
	 */
	public java.util.Date getDetailDate () {
		return detailDate;
	}

	/**
	 * Set the value related to the column: detail_date
	 * @param detailDate the detail_date value
	 */
	public void setDetailDate (java.util.Date detailDate) {
		this.detailDate = detailDate;
	}



	/**
	 * Return the value associated with the column: amount_allotted
	 */
	public java.lang.Integer getAmountAllotted () {
		return amountAllotted;
	}

	/**
	 * Set the value related to the column: amount_allotted
	 * @param amountAllotted the amount_allotted value
	 */
	public void setAmountAllotted (java.lang.Integer amountAllotted) {
		this.amountAllotted = amountAllotted;
	}



	/**
	 * Return the value associated with the column: expended_amount
	 */
	public java.lang.Integer getExpendedAmount () {
		return expendedAmount;
	}

	/**
	 * Set the value related to the column: expended_amount
	 * @param expendedAmount the expended_amount value
	 */
	public void setExpendedAmount (java.lang.Integer expendedAmount) {
		this.expendedAmount = expendedAmount;
	}



	/**
	 * Return the value associated with the column: balance
	 */
	public java.lang.Integer getBalance () {
		return balance;
	}

	/**
	 * Set the value related to the column: balance
	 * @param balance the balance value
	 */
	public void setBalance (java.lang.Integer balance) {
		this.balance = balance;
	}



	/**
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * @param remarks the remarks value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
	}



	/**
	 * Return the value associated with the column: budgetexpenseentryheader_id
	 */
	public jkt.hms.masters.business.BudgetExpenseEntryHeader getBudgetExpenseEntryHeader () {
		return budgetExpenseEntryHeader;
	}

	/**
	 * Set the value related to the column: budgetexpenseentryheader_id
	 * @param budgetExpenseEntryHeader the budgetexpenseentryheader_id value
	 */
	public void setBudgetExpenseEntryHeader (jkt.hms.masters.business.BudgetExpenseEntryHeader budgetExpenseEntryHeader) {
		this.budgetExpenseEntryHeader = budgetExpenseEntryHeader;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.BudgetExpenseEntryDetail)) return false;
		else {
			jkt.hms.masters.business.BudgetExpenseEntryDetail budgetExpenseEntryDetail = (jkt.hms.masters.business.BudgetExpenseEntryDetail) obj;
			if (null == this.getId() || null == budgetExpenseEntryDetail.getId()) return false;
			else return (this.getId().equals(budgetExpenseEntryDetail.getId()));
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
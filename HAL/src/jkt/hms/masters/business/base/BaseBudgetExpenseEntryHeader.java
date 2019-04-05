package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the budget_expense_entry_header table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="budget_expense_entry_header"
 */

public abstract class BaseBudgetExpenseEntryHeader  implements Serializable {

	public static String REF = "BudgetExpenseEntryHeader";
	public static String PROP_BUDGET_FOR_YEAR = "BudgetForYear";
	public static String PROP_BUDGET_DETAILS = "BudgetDetails";
	public static String PROP_CODE_HEAD = "CodeHead";
	public static String PROP_ID = "Id";
	public static String PROP_MAJOR_CODE_HEAD = "MajorCodeHead";
	public static String PROP_ALLOTTED_AMOUNT = "allottedAmount";


	// constructors
	public BaseBudgetExpenseEntryHeader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBudgetExpenseEntryHeader (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer allottedAmount;
	private java.lang.String budgetDetails;
	private java.lang.String budgetForYear;
	private java.lang.String codeHead;
	private java.lang.String majorCodeHead;

	// collections
	private java.util.Set<jkt.hms.masters.business.BudgetExpenseEntryDetail> budgetxpenseEntryDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="budgetexpenseentryheader_id"
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
	 * Return the value associated with the column: allotted_amount
	 */
	public java.lang.Integer getAllottedAmount () {
		return allottedAmount;
	}

	/**
	 * Set the value related to the column: allotted_amount
	 * @param allottedAmount the allotted_amount value
	 */
	public void setAllottedAmount (java.lang.Integer allottedAmount) {
		this.allottedAmount = allottedAmount;
	}



	/**
	 * Return the value associated with the column: budget_details
	 */
	public java.lang.String getBudgetDetails () {
		return budgetDetails;
	}

	/**
	 * Set the value related to the column: budget_details
	 * @param budgetDetails the budget_details value
	 */
	public void setBudgetDetails (java.lang.String budgetDetails) {
		this.budgetDetails = budgetDetails;
	}



	/**
	 * Return the value associated with the column: budget_for_year
	 */
	public java.lang.String getBudgetForYear () {
		return budgetForYear;
	}

	/**
	 * Set the value related to the column: budget_for_year
	 * @param budgetForYear the budget_for_year value
	 */
	public void setBudgetForYear (java.lang.String budgetForYear) {
		this.budgetForYear = budgetForYear;
	}



	/**
	 * Return the value associated with the column: code_head
	 */
	public java.lang.String getCodeHead () {
		return codeHead;
	}

	/**
	 * Set the value related to the column: code_head
	 * @param codeHead the code_head value
	 */
	public void setCodeHead (java.lang.String codeHead) {
		this.codeHead = codeHead;
	}



	/**
	 * Return the value associated with the column: major_code_head
	 */
	public java.lang.String getMajorCodeHead () {
		return majorCodeHead;
	}

	/**
	 * Set the value related to the column: major_code_head
	 * @param majorCodeHead the major_code_head value
	 */
	public void setMajorCodeHead (java.lang.String majorCodeHead) {
		this.majorCodeHead = majorCodeHead;
	}



	/**
	 * Return the value associated with the column: BudgetxpenseEntryDetails
	 */
	public java.util.Set<jkt.hms.masters.business.BudgetExpenseEntryDetail> getBudgetxpenseEntryDetails () {
		return budgetxpenseEntryDetails;
	}

	/**
	 * Set the value related to the column: BudgetxpenseEntryDetails
	 * @param budgetxpenseEntryDetails the BudgetxpenseEntryDetails value
	 */
	public void setBudgetxpenseEntryDetails (java.util.Set<jkt.hms.masters.business.BudgetExpenseEntryDetail> budgetxpenseEntryDetails) {
		this.budgetxpenseEntryDetails = budgetxpenseEntryDetails;
	}

	public void addToBudgetxpenseEntryDetails (jkt.hms.masters.business.BudgetExpenseEntryDetail budgetExpenseEntryDetail) {
		if (null == getBudgetxpenseEntryDetails()) setBudgetxpenseEntryDetails(new java.util.TreeSet<jkt.hms.masters.business.BudgetExpenseEntryDetail>());
		getBudgetxpenseEntryDetails().add(budgetExpenseEntryDetail);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.BudgetExpenseEntryHeader)) return false;
		else {
			jkt.hms.masters.business.BudgetExpenseEntryHeader budgetExpenseEntryHeader = (jkt.hms.masters.business.BudgetExpenseEntryHeader) obj;
			if (null == this.getId() || null == budgetExpenseEntryHeader.getId()) return false;
			else return (this.getId().equals(budgetExpenseEntryHeader.getId()));
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
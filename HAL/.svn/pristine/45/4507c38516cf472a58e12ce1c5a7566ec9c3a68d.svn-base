package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_store_budget_t table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="mas_store_budget_t"
 */

public abstract class BaseMasStoreBudgetT implements Serializable {

	public static String REF = "MasStoreBudgetT";
	public static String PROP_ADDITIONAL_AMOUNT = "AdditionalAmount";
	public static String PROP_PROJECT_AMOUNT = "ProjectAmount";
	public static String PROP_AUTHORITY_LETTER_NO = "AuthorityLetterNo";
	public static String PROP_ID = "Id";
	public static String PROP_BUDGETED_AMOUNT = "BudgetedAmount";
	public static String PROP_SR_NO = "SrNo";
	public static String PROP_BUDGET = "Budget";
	public static String PROP_ADDED_DATE = "AddedDate";

	// constructors
	public BaseMasStoreBudgetT() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasStoreBudgetT(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer srNo;
	private java.lang.String authorityLetterNo;
	private java.math.BigDecimal projectAmount;
	private java.math.BigDecimal budgetedAmount;
	private java.math.BigDecimal additionalAmount;
	private java.util.Date addedDate;

	// many to one
	private jkt.hms.masters.business.MasStoreBudget budget;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="id"
	 */
	public java.lang.Integer getId() {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * 
	 * @param id
	 *            the new ID
	 */
	public void setId(java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}

	/**
	 * Return the value associated with the column: sr_no
	 */
	public java.lang.Integer getSrNo() {
		return srNo;
	}

	/**
	 * Set the value related to the column: sr_no
	 * 
	 * @param srNo
	 *            the sr_no value
	 */
	public void setSrNo(java.lang.Integer srNo) {
		this.srNo = srNo;
	}

	/**
	 * Return the value associated with the column: authority_letter_no
	 */
	public java.lang.String getAuthorityLetterNo() {
		return authorityLetterNo;
	}

	/**
	 * Set the value related to the column: authority_letter_no
	 * 
	 * @param authorityLetterNo
	 *            the authority_letter_no value
	 */
	public void setAuthorityLetterNo(java.lang.String authorityLetterNo) {
		this.authorityLetterNo = authorityLetterNo;
	}

	/**
	 * Return the value associated with the column: project_amount
	 */
	public java.math.BigDecimal getProjectAmount() {
		return projectAmount;
	}

	/**
	 * Set the value related to the column: project_amount
	 * 
	 * @param projectAmount
	 *            the project_amount value
	 */
	public void setProjectAmount(java.math.BigDecimal projectAmount) {
		this.projectAmount = projectAmount;
	}

	/**
	 * Return the value associated with the column: budgeted_amount
	 */
	public java.math.BigDecimal getBudgetedAmount() {
		return budgetedAmount;
	}

	/**
	 * Set the value related to the column: budgeted_amount
	 * 
	 * @param budgetedAmount
	 *            the budgeted_amount value
	 */
	public void setBudgetedAmount(java.math.BigDecimal budgetedAmount) {
		this.budgetedAmount = budgetedAmount;
	}

	/**
	 * Return the value associated with the column: additional_amount
	 */
	public java.math.BigDecimal getAdditionalAmount() {
		return additionalAmount;
	}

	/**
	 * Set the value related to the column: additional_amount
	 * 
	 * @param additionalAmount
	 *            the additional_amount value
	 */
	public void setAdditionalAmount(java.math.BigDecimal additionalAmount) {
		this.additionalAmount = additionalAmount;
	}

	/**
	 * Return the value associated with the column: added_date
	 */
	public java.util.Date getAddedDate() {
		return addedDate;
	}

	/**
	 * Set the value related to the column: added_date
	 * 
	 * @param addedDate
	 *            the added_date value
	 */
	public void setAddedDate(java.util.Date addedDate) {
		this.addedDate = addedDate;
	}

	/**
	 * Return the value associated with the column: budget_id
	 */
	public jkt.hms.masters.business.MasStoreBudget getBudget() {
		return budget;
	}

	/**
	 * Set the value related to the column: budget_id
	 * 
	 * @param budget
	 *            the budget_id value
	 */
	public void setBudget(jkt.hms.masters.business.MasStoreBudget budget) {
		this.budget = budget;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MasStoreBudgetT))
			return false;
		else {
			jkt.hms.masters.business.MasStoreBudgetT masStoreBudgetT = (jkt.hms.masters.business.MasStoreBudgetT) obj;
			if (null == this.getId() || null == masStoreBudgetT.getId())
				return false;
			else
				return (this.getId().equals(masStoreBudgetT.getId()));
		}
	}

	public int hashCode() {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId())
				return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":"
						+ this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}

	public String toString() {
		return super.toString();
	}

}
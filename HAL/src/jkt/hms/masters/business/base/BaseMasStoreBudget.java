package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_store_budget table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_store_budget"
 */

public abstract class BaseMasStoreBudget  implements Serializable {

	public static String REF = "MasStoreBudget";
	public static String PROP_FINANCIAL = "Financial";
	public static String PROP_BUDGET_CODE = "BudgetCode";
	public static String PROP_UTILIZED_AMOUNT = "UtilizedAmount";
	public static String PROP_PO_COMITTED_AMOUNT = "PoComittedAmount";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_SPEND_AMOUNT = "SpendAmount";
	public static String PROP_CRV_COMITTED_AMOUNT = "CrvComittedAmount";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_TOTAL_ALLOCATED_AMOUNT = "TotalAllocatedAmount";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_BALANCE_AMOUNT = "BalanceAmount";


	// constructors
	public BaseMasStoreBudget () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasStoreBudget (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseMasStoreBudget (
		java.lang.Integer id,
		jkt.hms.masters.business.MasDepartment department) {

		this.setId(id);
		this.setDepartment(department);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String budgetCode;
	private java.math.BigDecimal utilizedAmount;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.math.BigDecimal totalAllocatedAmount;
	private java.math.BigDecimal crvComittedAmount;
	private java.math.BigDecimal poComittedAmount;
	private java.math.BigDecimal balanceAmount;
	private java.math.BigDecimal spendAmount;

	// many to one
	private jkt.hms.masters.business.MasStoreFinancial financial;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasHospital hospital;

	// collections
	private java.util.Set<jkt.hms.masters.business.MasStoreBudgetT> masStoreBudgetTs;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="budget_id"
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
	 * Return the value associated with the column: budget_code
	 */
	public java.lang.String getBudgetCode () {
		return budgetCode;
	}

	/**
	 * Set the value related to the column: budget_code
	 * @param budgetCode the budget_code value
	 */
	public void setBudgetCode (java.lang.String budgetCode) {
		this.budgetCode = budgetCode;
	}



	/**
	 * Return the value associated with the column: utilized_amount
	 */
	public java.math.BigDecimal getUtilizedAmount () {
		return utilizedAmount;
	}

	/**
	 * Set the value related to the column: utilized_amount
	 * @param utilizedAmount the utilized_amount value
	 */
	public void setUtilizedAmount (java.math.BigDecimal utilizedAmount) {
		this.utilizedAmount = utilizedAmount;
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
	 * Return the value associated with the column: total_allocated_amount
	 */
	public java.math.BigDecimal getTotalAllocatedAmount () {
		return totalAllocatedAmount;
	}

	/**
	 * Set the value related to the column: total_allocated_amount
	 * @param totalAllocatedAmount the total_allocated_amount value
	 */
	public void setTotalAllocatedAmount (java.math.BigDecimal totalAllocatedAmount) {
		this.totalAllocatedAmount = totalAllocatedAmount;
	}



	/**
	 * Return the value associated with the column: crv_comitted_amount
	 */
	public java.math.BigDecimal getCrvComittedAmount () {
		return crvComittedAmount;
	}

	/**
	 * Set the value related to the column: crv_comitted_amount
	 * @param crvComittedAmount the crv_comitted_amount value
	 */
	public void setCrvComittedAmount (java.math.BigDecimal crvComittedAmount) {
		this.crvComittedAmount = crvComittedAmount;
	}



	/**
	 * Return the value associated with the column: po_comitted_amount
	 */
	public java.math.BigDecimal getPoComittedAmount () {
		return poComittedAmount;
	}

	/**
	 * Set the value related to the column: po_comitted_amount
	 * @param poComittedAmount the po_comitted_amount value
	 */
	public void setPoComittedAmount (java.math.BigDecimal poComittedAmount) {
		this.poComittedAmount = poComittedAmount;
	}



	/**
	 * Return the value associated with the column: balance_amount
	 */
	public java.math.BigDecimal getBalanceAmount () {
		return balanceAmount;
	}

	/**
	 * Set the value related to the column: balance_amount
	 * @param balanceAmount the balance_amount value
	 */
	public void setBalanceAmount (java.math.BigDecimal balanceAmount) {
		this.balanceAmount = balanceAmount;
	}



	/**
	 * Return the value associated with the column: spend_amount
	 */
	public java.math.BigDecimal getSpendAmount () {
		return spendAmount;
	}

	/**
	 * Set the value related to the column: spend_amount
	 * @param spendAmount the spend_amount value
	 */
	public void setSpendAmount (java.math.BigDecimal spendAmount) {
		this.spendAmount = spendAmount;
	}



	/**
	 * Return the value associated with the column: financial_id
	 */
	public jkt.hms.masters.business.MasStoreFinancial getFinancial () {
		return financial;
	}

	/**
	 * Set the value related to the column: financial_id
	 * @param financial the financial_id value
	 */
	public void setFinancial (jkt.hms.masters.business.MasStoreFinancial financial) {
		this.financial = financial;
	}



	/**
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment () {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * @param department the department_id value
	 */
	public void setDepartment (jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}



	/**
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital () {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * @param hospital the hospital_id value
	 */
	public void setHospital (jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}



	/**
	 * Return the value associated with the column: MasStoreBudgetTs
	 */
	public java.util.Set<jkt.hms.masters.business.MasStoreBudgetT> getMasStoreBudgetTs () {
		return masStoreBudgetTs;
	}

	/**
	 * Set the value related to the column: MasStoreBudgetTs
	 * @param masStoreBudgetTs the MasStoreBudgetTs value
	 */
	public void setMasStoreBudgetTs (java.util.Set<jkt.hms.masters.business.MasStoreBudgetT> masStoreBudgetTs) {
		this.masStoreBudgetTs = masStoreBudgetTs;
	}

	public void addToMasStoreBudgetTs (jkt.hms.masters.business.MasStoreBudgetT masStoreBudgetT) {
		if (null == getMasStoreBudgetTs()) setMasStoreBudgetTs(new java.util.TreeSet<jkt.hms.masters.business.MasStoreBudgetT>());
		getMasStoreBudgetTs().add(masStoreBudgetT);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasStoreBudget)) return false;
		else {
			jkt.hms.masters.business.MasStoreBudget masStoreBudget = (jkt.hms.masters.business.MasStoreBudget) obj;
			if (null == this.getId() || null == masStoreBudget.getId()) return false;
			else return (this.getId().equals(masStoreBudget.getId()));
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
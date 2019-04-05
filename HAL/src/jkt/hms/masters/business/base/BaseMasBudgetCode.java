package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_budget_code table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_budget_code"
 */

public abstract class BaseMasBudgetCode  implements Serializable {

	public static String REF = "MasBudgetCode";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHANGE_BY = "LastChangeBy";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHANGE_DATE = "LastChangeDate";
	public static String PROP_LAST_CHANGE_TIME = "LastChangeTime";
	public static String PROP_BUDGET_CODE_NAME = "BudgetCodeName";
	public static String PROP_BUDGET_CODE_CODE = "BudgetCodeCode";


	// constructors
	public BaseMasBudgetCode () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasBudgetCode (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseMasBudgetCode (
		java.lang.Integer id,
		java.lang.String status) {

		this.setId(id);
		this.setStatus(status);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String budgetCodeCode;
	private java.lang.String budgetCodeName;
	private java.lang.String lastChangeBy;
	private java.util.Date lastChangeDate;
	private java.lang.String lastChangeTime;
	private java.lang.String status;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="budget_code_id"
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
	 * Return the value associated with the column: budget_code_code
	 */
	public java.lang.String getBudgetCodeCode () {
		return budgetCodeCode;
	}

	/**
	 * Set the value related to the column: budget_code_code
	 * @param budgetCodeCode the budget_code_code value
	 */
	public void setBudgetCodeCode (java.lang.String budgetCodeCode) {
		this.budgetCodeCode = budgetCodeCode;
	}



	/**
	 * Return the value associated with the column: budget_code_name
	 */
	public java.lang.String getBudgetCodeName () {
		return budgetCodeName;
	}

	/**
	 * Set the value related to the column: budget_code_name
	 * @param budgetCodeName the budget_code_name value
	 */
	public void setBudgetCodeName (java.lang.String budgetCodeName) {
		this.budgetCodeName = budgetCodeName;
	}



	/**
	 * Return the value associated with the column: last_change_by
	 */
	public java.lang.String getLastChangeBy () {
		return lastChangeBy;
	}

	/**
	 * Set the value related to the column: last_change_by
	 * @param lastChangeBy the last_change_by value
	 */
	public void setLastChangeBy (java.lang.String lastChangeBy) {
		this.lastChangeBy = lastChangeBy;
	}



	/**
	 * Return the value associated with the column: last_change_date
	 */
	public java.util.Date getLastChangeDate () {
		return lastChangeDate;
	}

	/**
	 * Set the value related to the column: last_change_date
	 * @param lastChangeDate the last_change_date value
	 */
	public void setLastChangeDate (java.util.Date lastChangeDate) {
		this.lastChangeDate = lastChangeDate;
	}



	/**
	 * Return the value associated with the column: last_change_time
	 */
	public java.lang.String getLastChangeTime () {
		return lastChangeTime;
	}

	/**
	 * Set the value related to the column: last_change_time
	 * @param lastChangeTime the last_change_time value
	 */
	public void setLastChangeTime (java.lang.String lastChangeTime) {
		this.lastChangeTime = lastChangeTime;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasBudgetCode)) return false;
		else {
			jkt.hms.masters.business.MasBudgetCode masBudgetCode = (jkt.hms.masters.business.MasBudgetCode) obj;
			if (null == this.getId() || null == masBudgetCode.getId()) return false;
			else return (this.getId().equals(masBudgetCode.getId()));
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
package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_employee_investment table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_employee_investment"
 */

public abstract class BaseHrEmployeeInvestment  implements Serializable {

	public static String REF = "HrEmployeeInvestment";
	public static String PROP_SEC_INVEST = "SecInvest";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_INV_DATE = "InvDate";
	public static String PROP_EMP = "Emp";
	public static String PROP_INV_AMOUNT = "InvAmount";
	public static String PROP_INV_YEAR = "InvYear";
	public static String PROP_ID = "Id";
	public static String PROP_DOCUMENT_SUBMITTED = "DocumentSubmitted";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";


	// constructors
	public BaseHrEmployeeInvestment () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrEmployeeInvestment (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.math.BigDecimal invAmount;
	private java.util.Date invDate;
	private java.lang.String documentSubmitted;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasStoreFinancial invYear;
	private jkt.hms.masters.business.MasEmployee emp;
	private jkt.hms.masters.business.HrMasItaxSecInvestment secInvest;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
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
	 * Return the value associated with the column: inv_amount
	 */
	public java.math.BigDecimal getInvAmount () {
		return invAmount;
	}

	/**
	 * Set the value related to the column: inv_amount
	 * @param invAmount the inv_amount value
	 */
	public void setInvAmount (java.math.BigDecimal invAmount) {
		this.invAmount = invAmount;
	}



	/**
	 * Return the value associated with the column: inv_date
	 */
	public java.util.Date getInvDate () {
		return invDate;
	}

	/**
	 * Set the value related to the column: inv_date
	 * @param invDate the inv_date value
	 */
	public void setInvDate (java.util.Date invDate) {
		this.invDate = invDate;
	}



	/**
	 * Return the value associated with the column: document_submitted
	 */
	public java.lang.String getDocumentSubmitted () {
		return documentSubmitted;
	}

	/**
	 * Set the value related to the column: document_submitted
	 * @param documentSubmitted the document_submitted value
	 */
	public void setDocumentSubmitted (java.lang.String documentSubmitted) {
		this.documentSubmitted = documentSubmitted;
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
	 * Return the value associated with the column: inv_year
	 */
	public jkt.hms.masters.business.MasStoreFinancial getInvYear () {
		return invYear;
	}

	/**
	 * Set the value related to the column: inv_year
	 * @param invYear the inv_year value
	 */
	public void setInvYear (jkt.hms.masters.business.MasStoreFinancial invYear) {
		this.invYear = invYear;
	}



	/**
	 * Return the value associated with the column: emp_id
	 */
	public jkt.hms.masters.business.MasEmployee getEmp () {
		return emp;
	}

	/**
	 * Set the value related to the column: emp_id
	 * @param emp the emp_id value
	 */
	public void setEmp (jkt.hms.masters.business.MasEmployee emp) {
		this.emp = emp;
	}



	/**
	 * Return the value associated with the column: sec_invest_id
	 */
	public jkt.hms.masters.business.HrMasItaxSecInvestment getSecInvest () {
		return secInvest;
	}

	/**
	 * Set the value related to the column: sec_invest_id
	 * @param secInvest the sec_invest_id value
	 */
	public void setSecInvest (jkt.hms.masters.business.HrMasItaxSecInvestment secInvest) {
		this.secInvest = secInvest;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HrEmployeeInvestment)) return false;
		else {
			jkt.hms.masters.business.HrEmployeeInvestment hrEmployeeInvestment = (jkt.hms.masters.business.HrEmployeeInvestment) obj;
			if (null == this.getId() || null == hrEmployeeInvestment.getId()) return false;
			else return (this.getId().equals(hrEmployeeInvestment.getId()));
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
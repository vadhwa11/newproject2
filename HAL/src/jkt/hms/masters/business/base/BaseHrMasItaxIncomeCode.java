package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_mas_itax_income_code table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_mas_itax_income_code"
 */

public abstract class BaseHrMasItaxIncomeCode  implements Serializable {

	public static String REF = "HrMasItaxIncomeCode";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_INCOME_CODE = "IncomeCode";
	public static String PROP_INCOME_DESC = "IncomeDesc";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";


	// constructors
	public BaseHrMasItaxIncomeCode () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrMasItaxIncomeCode (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String incomeCode;
	private java.lang.String incomeDesc;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// collections
	private java.util.Set<jkt.hms.masters.business.HrEmployeeOtherEarning> hrEmployeeOtherEarnings;



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
	 * Return the value associated with the column: income_code
	 */
	public java.lang.String getIncomeCode () {
		return incomeCode;
	}

	/**
	 * Set the value related to the column: income_code
	 * @param incomeCode the income_code value
	 */
	public void setIncomeCode (java.lang.String incomeCode) {
		this.incomeCode = incomeCode;
	}



	/**
	 * Return the value associated with the column: income_desc
	 */
	public java.lang.String getIncomeDesc () {
		return incomeDesc;
	}

	/**
	 * Set the value related to the column: income_desc
	 * @param incomeDesc the income_desc value
	 */
	public void setIncomeDesc (java.lang.String incomeDesc) {
		this.incomeDesc = incomeDesc;
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
	 * Return the value associated with the column: HrEmployeeOtherEarnings
	 */
	public java.util.Set<jkt.hms.masters.business.HrEmployeeOtherEarning> getHrEmployeeOtherEarnings () {
		return hrEmployeeOtherEarnings;
	}

	/**
	 * Set the value related to the column: HrEmployeeOtherEarnings
	 * @param hrEmployeeOtherEarnings the HrEmployeeOtherEarnings value
	 */
	public void setHrEmployeeOtherEarnings (java.util.Set<jkt.hms.masters.business.HrEmployeeOtherEarning> hrEmployeeOtherEarnings) {
		this.hrEmployeeOtherEarnings = hrEmployeeOtherEarnings;
	}

	public void addToHrEmployeeOtherEarnings (jkt.hms.masters.business.HrEmployeeOtherEarning hrEmployeeOtherEarning) {
		if (null == getHrEmployeeOtherEarnings()) setHrEmployeeOtherEarnings(new java.util.TreeSet<jkt.hms.masters.business.HrEmployeeOtherEarning>());
		getHrEmployeeOtherEarnings().add(hrEmployeeOtherEarning);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HrMasItaxIncomeCode)) return false;
		else {
			jkt.hms.masters.business.HrMasItaxIncomeCode hrMasItaxIncomeCode = (jkt.hms.masters.business.HrMasItaxIncomeCode) obj;
			if (null == this.getId() || null == hrMasItaxIncomeCode.getId()) return false;
			else return (this.getId().equals(hrMasItaxIncomeCode.getId()));
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
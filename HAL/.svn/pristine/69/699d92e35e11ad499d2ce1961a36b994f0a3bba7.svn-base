package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_mas_loan table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_mas_loan"
 */

public abstract class BaseHrMasLoan  implements Serializable {

	public static String REF = "HrMasLoan";
	public static String PROP_LOAN_DESCRIPTION = "LoanDescription";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LOAN_CODE = "LoanCode";
	public static String PROP_INTEREST_PERCENT = "InterestPercent";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_MAX_AMOUNT = "MaxAmount";


	// constructors
	public BaseHrMasLoan () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrMasLoan (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String loanCode;
	private java.lang.String loanDescription;
	private java.math.BigDecimal maxAmount;
	private java.lang.Float interestPercent;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="loan_id"
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
	 * Return the value associated with the column: loan_code
	 */
	public java.lang.String getLoanCode () {
		return loanCode;
	}

	/**
	 * Set the value related to the column: loan_code
	 * @param loanCode the loan_code value
	 */
	public void setLoanCode (java.lang.String loanCode) {
		this.loanCode = loanCode;
	}



	/**
	 * Return the value associated with the column: loan_description
	 */
	public java.lang.String getLoanDescription () {
		return loanDescription;
	}

	/**
	 * Set the value related to the column: loan_description
	 * @param loanDescription the loan_description value
	 */
	public void setLoanDescription (java.lang.String loanDescription) {
		this.loanDescription = loanDescription;
	}



	/**
	 * Return the value associated with the column: max_amount
	 */
	public java.math.BigDecimal getMaxAmount () {
		return maxAmount;
	}

	/**
	 * Set the value related to the column: max_amount
	 * @param maxAmount the max_amount value
	 */
	public void setMaxAmount (java.math.BigDecimal maxAmount) {
		this.maxAmount = maxAmount;
	}



	/**
	 * Return the value associated with the column: interest_percent
	 */
	public java.lang.Float getInterestPercent () {
		return interestPercent;
	}

	/**
	 * Set the value related to the column: interest_percent
	 * @param interestPercent the interest_percent value
	 */
	public void setInterestPercent (java.lang.Float interestPercent) {
		this.interestPercent = interestPercent;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HrMasLoan)) return false;
		else {
			jkt.hms.masters.business.HrMasLoan hrMasLoan = (jkt.hms.masters.business.HrMasLoan) obj;
			if (null == this.getId() || null == hrMasLoan.getId()) return false;
			else return (this.getId().equals(hrMasLoan.getId()));
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
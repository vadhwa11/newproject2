package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the fa_account_opening table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="fa_account_opening"
 */

public abstract class BaseFaAccountOpening  implements Serializable {

	public static String REF = "FaAccountOpening";
	public static String PROP_STATUS = "Status";
	public static String PROP_ACCOUNT = "Account";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_OPENING_DATE = "OpeningDate";
	public static String PROP_SUB_LEDGER = "SubLedger";
	public static String PROP_F_YEAR = "FYear";
	public static String PROP_OPENING_AMT_DR = "OpeningAmtDr";
	public static String PROP_OPENING_AMT_CR = "OpeningAmtCr";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ID = "Id";
	public static String PROP_OPENING_NO = "OpeningNo";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";


	// constructors
	public BaseFaAccountOpening () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFaAccountOpening (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String openingNo;
	private java.util.Date openingDate;
	private java.math.BigDecimal openingAmtCr;
	private java.math.BigDecimal openingAmtDr;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.FaMasAccount account;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.FaMasSubLed subLedger;
	private jkt.hms.masters.business.HrMasFinancialYear fYear;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="opening_id"
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
	 * Return the value associated with the column: opening_no
	 */
	public java.lang.String getOpeningNo () {
		return openingNo;
	}

	/**
	 * Set the value related to the column: opening_no
	 * @param openingNo the opening_no value
	 */
	public void setOpeningNo (java.lang.String openingNo) {
		this.openingNo = openingNo;
	}



	/**
	 * Return the value associated with the column: opening_date
	 */
	public java.util.Date getOpeningDate () {
		return openingDate;
	}

	/**
	 * Set the value related to the column: opening_date
	 * @param openingDate the opening_date value
	 */
	public void setOpeningDate (java.util.Date openingDate) {
		this.openingDate = openingDate;
	}



	/**
	 * Return the value associated with the column: opening_amt_cr
	 */
	public java.math.BigDecimal getOpeningAmtCr () {
		return openingAmtCr;
	}

	/**
	 * Set the value related to the column: opening_amt_cr
	 * @param openingAmtCr the opening_amt_cr value
	 */
	public void setOpeningAmtCr (java.math.BigDecimal openingAmtCr) {
		this.openingAmtCr = openingAmtCr;
	}



	/**
	 * Return the value associated with the column: opening_amt_dr
	 */
	public java.math.BigDecimal getOpeningAmtDr () {
		return openingAmtDr;
	}

	/**
	 * Set the value related to the column: opening_amt_dr
	 * @param openingAmtDr the opening_amt_dr value
	 */
	public void setOpeningAmtDr (java.math.BigDecimal openingAmtDr) {
		this.openingAmtDr = openingAmtDr;
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
	 * Return the value associated with the column: financial_year_id
	 */
	public jkt.hms.masters.business.HrMasFinancialYear getFYear () {
		return fYear;
	}

	/**
	 * Set the value related to the column: financial_year_id
	 * @param fYear the financial_year_id value
	 */
	public void setFYear (jkt.hms.masters.business.HrMasFinancialYear fYear) {
		this.fYear = fYear;
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
		if (!(obj instanceof jkt.hms.masters.business.FaAccountOpening)) return false;
		else {
			jkt.hms.masters.business.FaAccountOpening faAccountOpening = (jkt.hms.masters.business.FaAccountOpening) obj;
			if (null == this.getId() || null == faAccountOpening.getId()) return false;
			else return (this.getId().equals(faAccountOpening.getId()));
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
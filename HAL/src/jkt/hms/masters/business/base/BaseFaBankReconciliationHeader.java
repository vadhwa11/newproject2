package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the fa_bank_reconciliation_header table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="fa_bank_reconciliation_header"
 */

public abstract class BaseFaBankReconciliationHeader  implements Serializable {

	public static String REF = "FaBankReconciliationHeader";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ACCOUNT = "Account";
	public static String PROP_DIFF_AMT = "DiffAmt";
	public static String PROP_RECONCILIATION_DATE = "ReconciliationDate";
	public static String PROP_DR_BLNC_AS_PER_COMPANY = "DrBlncAsPerCompany";
	public static String PROP_CR_BLNC_AS_PER_COMPANY = "CrBlncAsPerCompany";
	public static String PROP_DR_BLNC_AS_PER_BANK = "DrBlncAsPerBank";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_CR_BLNC_AS_PER_BANK = "CrBlncAsPerBank";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";


	// constructors
	public BaseFaBankReconciliationHeader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFaBankReconciliationHeader (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date reconciliationDate;
	private java.math.BigDecimal drBlncAsPerCompany;
	private java.math.BigDecimal crBlncAsPerCompany;
	private java.math.BigDecimal drBlncAsPerBank;
	private java.math.BigDecimal crBlncAsPerBank;
	private java.math.BigDecimal diffAmt;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.FaMasAccount account;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;

	// collections
	private java.util.Set<jkt.hms.masters.business.FaBankReconciliationDetails> faBankReconciliationDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="bank_reconciliation_header_id"
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
	 * Return the value associated with the column: reconciliation_date
	 */
	public java.util.Date getReconciliationDate () {
		return reconciliationDate;
	}

	/**
	 * Set the value related to the column: reconciliation_date
	 * @param reconciliationDate the reconciliation_date value
	 */
	public void setReconciliationDate (java.util.Date reconciliationDate) {
		this.reconciliationDate = reconciliationDate;
	}



	/**
	 * Return the value associated with the column: dr_blnc_as_per_company
	 */
	public java.math.BigDecimal getDrBlncAsPerCompany () {
		return drBlncAsPerCompany;
	}

	/**
	 * Set the value related to the column: dr_blnc_as_per_company
	 * @param drBlncAsPerCompany the dr_blnc_as_per_company value
	 */
	public void setDrBlncAsPerCompany (java.math.BigDecimal drBlncAsPerCompany) {
		this.drBlncAsPerCompany = drBlncAsPerCompany;
	}



	/**
	 * Return the value associated with the column: cr_blnc_as_per_company
	 */
	public java.math.BigDecimal getCrBlncAsPerCompany () {
		return crBlncAsPerCompany;
	}

	/**
	 * Set the value related to the column: cr_blnc_as_per_company
	 * @param crBlncAsPerCompany the cr_blnc_as_per_company value
	 */
	public void setCrBlncAsPerCompany (java.math.BigDecimal crBlncAsPerCompany) {
		this.crBlncAsPerCompany = crBlncAsPerCompany;
	}



	/**
	 * Return the value associated with the column: dr_blnc_as_per_bank
	 */
	public java.math.BigDecimal getDrBlncAsPerBank () {
		return drBlncAsPerBank;
	}

	/**
	 * Set the value related to the column: dr_blnc_as_per_bank
	 * @param drBlncAsPerBank the dr_blnc_as_per_bank value
	 */
	public void setDrBlncAsPerBank (java.math.BigDecimal drBlncAsPerBank) {
		this.drBlncAsPerBank = drBlncAsPerBank;
	}



	/**
	 * Return the value associated with the column: cr_blnc_as_per_bank
	 */
	public java.math.BigDecimal getCrBlncAsPerBank () {
		return crBlncAsPerBank;
	}

	/**
	 * Set the value related to the column: cr_blnc_as_per_bank
	 * @param crBlncAsPerBank the cr_blnc_as_per_bank value
	 */
	public void setCrBlncAsPerBank (java.math.BigDecimal crBlncAsPerBank) {
		this.crBlncAsPerBank = crBlncAsPerBank;
	}



	/**
	 * Return the value associated with the column: diff_amt
	 */
	public java.math.BigDecimal getDiffAmt () {
		return diffAmt;
	}

	/**
	 * Set the value related to the column: diff_amt
	 * @param diffAmt the diff_amt value
	 */
	public void setDiffAmt (java.math.BigDecimal diffAmt) {
		this.diffAmt = diffAmt;
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
	 * Return the value associated with the column: FaBankReconciliationDetails
	 */
	public java.util.Set<jkt.hms.masters.business.FaBankReconciliationDetails> getFaBankReconciliationDetails () {
		return faBankReconciliationDetails;
	}

	/**
	 * Set the value related to the column: FaBankReconciliationDetails
	 * @param faBankReconciliationDetails the FaBankReconciliationDetails value
	 */
	public void setFaBankReconciliationDetails (java.util.Set<jkt.hms.masters.business.FaBankReconciliationDetails> faBankReconciliationDetails) {
		this.faBankReconciliationDetails = faBankReconciliationDetails;
	}

	public void addToFaBankReconciliationDetails (jkt.hms.masters.business.FaBankReconciliationDetails faBankReconciliationDetails) {
		if (null == getFaBankReconciliationDetails()) setFaBankReconciliationDetails(new java.util.TreeSet<jkt.hms.masters.business.FaBankReconciliationDetails>());
		getFaBankReconciliationDetails().add(faBankReconciliationDetails);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.FaBankReconciliationHeader)) return false;
		else {
			jkt.hms.masters.business.FaBankReconciliationHeader faBankReconciliationHeader = (jkt.hms.masters.business.FaBankReconciliationHeader) obj;
			if (null == this.getId() || null == faBankReconciliationHeader.getId()) return false;
			else return (this.getId().equals(faBankReconciliationHeader.getId()));
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
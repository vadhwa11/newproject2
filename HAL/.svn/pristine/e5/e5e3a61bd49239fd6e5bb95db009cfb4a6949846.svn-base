package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the fa_cheque_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="fa_cheque_details"
 */

public abstract class BaseFaChequeDetails  implements Serializable {

	public static String REF = "FaChequeDetails";
	public static String PROP_CHEQUE_NO_FROM = "ChequeNoFrom";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_BANK = "Bank";
	public static String PROP_ISSUE_DATE = "IssueDate";
	public static String PROP_CHEQUE_NO_TO = "ChequeNoTo";
	public static String PROP_CHEQUE_BOOK_NO = "ChequeBookNo";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_NO_OF_CHEQUE = "NoOfCheque";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LOCATION = "Location";


	// constructors
	public BaseFaChequeDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFaChequeDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String chequeBookNo;
	private java.util.Date issueDate;
	private java.lang.Integer noOfCheque;
	private java.lang.String chequeNoFrom;
	private java.lang.String chequeNoTo;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasBankMaster bank;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasHospital location;

	// collections
	private java.util.Set<jkt.hms.masters.business.FaChequeCancel> faChequeCancels;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="cheque_details_id"
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
	 * Return the value associated with the column: cheque_book_no
	 */
	public java.lang.String getChequeBookNo () {
		return chequeBookNo;
	}

	/**
	 * Set the value related to the column: cheque_book_no
	 * @param chequeBookNo the cheque_book_no value
	 */
	public void setChequeBookNo (java.lang.String chequeBookNo) {
		this.chequeBookNo = chequeBookNo;
	}



	/**
	 * Return the value associated with the column: issue_date
	 */
	public java.util.Date getIssueDate () {
		return issueDate;
	}

	/**
	 * Set the value related to the column: issue_date
	 * @param issueDate the issue_date value
	 */
	public void setIssueDate (java.util.Date issueDate) {
		this.issueDate = issueDate;
	}



	/**
	 * Return the value associated with the column: no_of_cheque
	 */
	public java.lang.Integer getNoOfCheque () {
		return noOfCheque;
	}

	/**
	 * Set the value related to the column: no_of_cheque
	 * @param noOfCheque the no_of_cheque value
	 */
	public void setNoOfCheque (java.lang.Integer noOfCheque) {
		this.noOfCheque = noOfCheque;
	}



	/**
	 * Return the value associated with the column: cheque_no_from
	 */
	public java.lang.String getChequeNoFrom () {
		return chequeNoFrom;
	}

	/**
	 * Set the value related to the column: cheque_no_from
	 * @param chequeNoFrom the cheque_no_from value
	 */
	public void setChequeNoFrom (java.lang.String chequeNoFrom) {
		this.chequeNoFrom = chequeNoFrom;
	}



	/**
	 * Return the value associated with the column: cheque_no_to
	 */
	public java.lang.String getChequeNoTo () {
		return chequeNoTo;
	}

	/**
	 * Set the value related to the column: cheque_no_to
	 * @param chequeNoTo the cheque_no_to value
	 */
	public void setChequeNoTo (java.lang.String chequeNoTo) {
		this.chequeNoTo = chequeNoTo;
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
	 * Return the value associated with the column: bank_id
	 */
	public jkt.hms.masters.business.MasBankMaster getBank () {
		return bank;
	}

	/**
	 * Set the value related to the column: bank_id
	 * @param bank the bank_id value
	 */
	public void setBank (jkt.hms.masters.business.MasBankMaster bank) {
		this.bank = bank;
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
	 * Return the value associated with the column: location_id
	 */
	public jkt.hms.masters.business.MasHospital getLocation () {
		return location;
	}

	/**
	 * Set the value related to the column: location_id
	 * @param location the location_id value
	 */
	public void setLocation (jkt.hms.masters.business.MasHospital location) {
		this.location = location;
	}



	/**
	 * Return the value associated with the column: FaChequeCancels
	 */
	public java.util.Set<jkt.hms.masters.business.FaChequeCancel> getFaChequeCancels () {
		return faChequeCancels;
	}

	/**
	 * Set the value related to the column: FaChequeCancels
	 * @param faChequeCancels the FaChequeCancels value
	 */
	public void setFaChequeCancels (java.util.Set<jkt.hms.masters.business.FaChequeCancel> faChequeCancels) {
		this.faChequeCancels = faChequeCancels;
	}

	public void addToFaChequeCancels (jkt.hms.masters.business.FaChequeCancel faChequeCancel) {
		if (null == getFaChequeCancels()) setFaChequeCancels(new java.util.TreeSet<jkt.hms.masters.business.FaChequeCancel>());
		getFaChequeCancels().add(faChequeCancel);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.FaChequeDetails)) return false;
		else {
			jkt.hms.masters.business.FaChequeDetails faChequeDetails = (jkt.hms.masters.business.FaChequeDetails) obj;
			if (null == this.getId() || null == faChequeDetails.getId()) return false;
			else return (this.getId().equals(faChequeDetails.getId()));
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
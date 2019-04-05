package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the fa_mas_fd_register table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="fa_mas_fd_register"
 */

public abstract class BaseFaMasFdRegister  implements Serializable {

	public static String REF = "FaMasFdRegister";
	public static String PROP_AMOUNT = "Amount";
	public static String PROP_DATE_OF_MATURITY = "DateOfMaturity";
	public static String PROP_BANK = "Bank";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_LOCATION = "Location";
	public static String PROP_RATE_OF_INTEREST = "RateOfInterest";
	public static String PROP_NO_OF_DAYS = "NoOfDays";
	public static String PROP_STATUS = "Status";
	public static String PROP_FDR_NO = "FdrNo";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_DATE_OF_ISSUE = "DateOfIssue";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseFaMasFdRegister () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFaMasFdRegister (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String fdrNo;
	private java.util.Date dateOfIssue;
	private java.util.Date dateOfMaturity;
	private java.math.BigDecimal amount;
	private java.math.BigDecimal rateOfInterest;
	private java.lang.Integer noOfDays;
	private java.lang.String remarks;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasBankMaster bank;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital location;



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
	 * Return the value associated with the column: fdr_no
	 */
	public java.lang.String getFdrNo () {
		return fdrNo;
	}

	/**
	 * Set the value related to the column: fdr_no
	 * @param fdrNo the fdr_no value
	 */
	public void setFdrNo (java.lang.String fdrNo) {
		this.fdrNo = fdrNo;
	}



	/**
	 * Return the value associated with the column: date_of_issue
	 */
	public java.util.Date getDateOfIssue () {
		return dateOfIssue;
	}

	/**
	 * Set the value related to the column: date_of_issue
	 * @param dateOfIssue the date_of_issue value
	 */
	public void setDateOfIssue (java.util.Date dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}



	/**
	 * Return the value associated with the column: date_of_maturity
	 */
	public java.util.Date getDateOfMaturity () {
		return dateOfMaturity;
	}

	/**
	 * Set the value related to the column: date_of_maturity
	 * @param dateOfMaturity the date_of_maturity value
	 */
	public void setDateOfMaturity (java.util.Date dateOfMaturity) {
		this.dateOfMaturity = dateOfMaturity;
	}



	/**
	 * Return the value associated with the column: amount
	 */
	public java.math.BigDecimal getAmount () {
		return amount;
	}

	/**
	 * Set the value related to the column: amount
	 * @param amount the amount value
	 */
	public void setAmount (java.math.BigDecimal amount) {
		this.amount = amount;
	}



	/**
	 * Return the value associated with the column: rate_of_interest
	 */
	public java.math.BigDecimal getRateOfInterest () {
		return rateOfInterest;
	}

	/**
	 * Set the value related to the column: rate_of_interest
	 * @param rateOfInterest the rate_of_interest value
	 */
	public void setRateOfInterest (java.math.BigDecimal rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}



	/**
	 * Return the value associated with the column: no_of_days
	 */
	public java.lang.Integer getNoOfDays () {
		return noOfDays;
	}

	/**
	 * Set the value related to the column: no_of_days
	 * @param noOfDays the no_of_days value
	 */
	public void setNoOfDays (java.lang.Integer noOfDays) {
		this.noOfDays = noOfDays;
	}



	/**
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * @param remarks the remarks value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.FaMasFdRegister)) return false;
		else {
			jkt.hms.masters.business.FaMasFdRegister faMasFdRegister = (jkt.hms.masters.business.FaMasFdRegister) obj;
			if (null == this.getId() || null == faMasFdRegister.getId()) return false;
			else return (this.getId().equals(faMasFdRegister.getId()));
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
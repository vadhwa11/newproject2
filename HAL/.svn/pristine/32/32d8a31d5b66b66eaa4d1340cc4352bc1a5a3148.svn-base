package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the pension_emoluments table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="pension_emoluments"
 */

public abstract class BasePensionEmoluments implements Serializable {

	public static String REF = "PensionEmoluments";
	public static String PROP_BASIC_PAY = "BasicPay";
	public static String PROP_GRADE_PAY = "GradePay";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_STAGN = "Stagn";
	public static String PROP_OTHERS = "Others";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_PERSONNEL = "Personnel";
	public static String PROP_FROM_DATE = "FromDate";
	public static String PROP_DP = "Dp";
	public static String PROP_RANK_PAY = "RankPay";
	public static String PROP_TOTAL_EMOLUMENTS = "TotalEmoluments";
	public static String PROP_NPA = "Npa";
	public static String PROP_DA = "Da";
	public static String PROP_NO_OF_MONTHS = "NoOfMonths";
	public static String PROP_TO_DATE = "ToDate";
	public static String PROP_ID = "Id";

	// constructors
	public BasePensionEmoluments() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePensionEmoluments(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date fromDate;
	private java.util.Date toDate;
	private java.math.BigDecimal basicPay;
	private java.math.BigDecimal gradePay;
	private java.math.BigDecimal stagn;
	private java.math.BigDecimal rankPay;
	private java.math.BigDecimal dp;
	private java.math.BigDecimal npa;
	private java.math.BigDecimal others;
	private java.math.BigDecimal da;
	private java.lang.Integer noOfMonths;
	private java.math.BigDecimal totalEmoluments;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasPersonnelDetails personnel;

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
	 * Return the value associated with the column: from_date
	 */
	public java.util.Date getFromDate() {
		return fromDate;
	}

	/**
	 * Set the value related to the column: from_date
	 * 
	 * @param fromDate
	 *            the from_date value
	 */
	public void setFromDate(java.util.Date fromDate) {
		this.fromDate = fromDate;
	}

	/**
	 * Return the value associated with the column: to_date
	 */
	public java.util.Date getToDate() {
		return toDate;
	}

	/**
	 * Set the value related to the column: to_date
	 * 
	 * @param toDate
	 *            the to_date value
	 */
	public void setToDate(java.util.Date toDate) {
		this.toDate = toDate;
	}

	/**
	 * Return the value associated with the column: basic_pay
	 */
	public java.math.BigDecimal getBasicPay() {
		return basicPay;
	}

	/**
	 * Set the value related to the column: basic_pay
	 * 
	 * @param basicPay
	 *            the basic_pay value
	 */
	public void setBasicPay(java.math.BigDecimal basicPay) {
		this.basicPay = basicPay;
	}

	/**
	 * Return the value associated with the column: stagn
	 */
	public java.math.BigDecimal getStagn() {
		return stagn;
	}

	/**
	 * Set the value related to the column: stagn
	 * 
	 * @param stagn
	 *            the stagn value
	 */
	public void setStagn(java.math.BigDecimal stagn) {
		this.stagn = stagn;
	}

	/**
	 * Return the value associated with the column: rank_pay
	 */
	public java.math.BigDecimal getRankPay() {
		return rankPay;
	}

	/**
	 * Set the value related to the column: rank_pay
	 * 
	 * @param rankPay
	 *            the rank_pay value
	 */
	public void setRankPay(java.math.BigDecimal rankPay) {
		this.rankPay = rankPay;
	}

	/**
	 * Return the value associated with the column: dp
	 */
	public java.math.BigDecimal getDp() {
		return dp;
	}

	/**
	 * Set the value related to the column: dp
	 * 
	 * @param dp
	 *            the dp value
	 */
	public void setDp(java.math.BigDecimal dp) {
		this.dp = dp;
	}

	/**
	 * Return the value associated with the column: npa
	 */
	public java.math.BigDecimal getNpa() {
		return npa;
	}

	/**
	 * Set the value related to the column: npa
	 * 
	 * @param npa
	 *            the npa value
	 */
	public void setNpa(java.math.BigDecimal npa) {
		this.npa = npa;
	}

	/**
	 * Return the value associated with the column: others
	 */
	public java.math.BigDecimal getOthers() {
		return others;
	}

	/**
	 * Set the value related to the column: others
	 * 
	 * @param others
	 *            the others value
	 */
	public void setOthers(java.math.BigDecimal others) {
		this.others = others;
	}

	/**
	 * Return the value associated with the column: da
	 */
	public java.math.BigDecimal getDa() {
		return da;
	}

	/**
	 * Set the value related to the column: da
	 * 
	 * @param da
	 *            the da value
	 */
	public void setDa(java.math.BigDecimal da) {
		this.da = da;
	}

	/**
	 * Return the value associated with the column: no_of_months
	 */
	public java.lang.Integer getNoOfMonths() {
		return noOfMonths;
	}

	/**
	 * Set the value related to the column: no_of_months
	 * 
	 * @param noOfMonths
	 *            the no_of_months value
	 */
	public void setNoOfMonths(java.lang.Integer noOfMonths) {
		this.noOfMonths = noOfMonths;
	}

	/**
	 * Return the value associated with the column: total_emoluments
	 */
	public java.math.BigDecimal getTotalEmoluments() {
		return totalEmoluments;
	}

	/**
	 * Set the value related to the column: total_emoluments
	 * 
	 * @param totalEmoluments
	 *            the total_emoluments value
	 */
	public void setTotalEmoluments(java.math.BigDecimal totalEmoluments) {
		this.totalEmoluments = totalEmoluments;
	}

	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.String getLastChgBy() {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * 
	 * @param lastChgBy
	 *            the last_chg_by value
	 */
	public void setLastChgBy(java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
	}

	/**
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate() {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * 
	 * @param lastChgDate
	 *            the last_chg_date value
	 */
	public void setLastChgDate(java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}

	/**
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime() {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * 
	 * @param lastChgTime
	 *            the last_chg_time value
	 */
	public void setLastChgTime(java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}

	/**
	 * Return the value associated with the column: personnel_id
	 */
	public jkt.hms.masters.business.MasPersonnelDetails getPersonnel() {
		return personnel;
	}

	/**
	 * Set the value related to the column: personnel_id
	 * 
	 * @param personnel
	 *            the personnel_id value
	 */
	public void setPersonnel(
			jkt.hms.masters.business.MasPersonnelDetails personnel) {
		this.personnel = personnel;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.PensionEmoluments))
			return false;
		else {
			jkt.hms.masters.business.PensionEmoluments pensionEmoluments = (jkt.hms.masters.business.PensionEmoluments) obj;
			if (null == this.getId() || null == pensionEmoluments.getId())
				return false;
			else
				return (this.getId().equals(pensionEmoluments.getId()));
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

	public java.math.BigDecimal getGradePay() {
		return gradePay;
	}

	public void setGradePay(java.math.BigDecimal gradePay) {
		this.gradePay = gradePay;
	}

}
package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the pension_form8_entry
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="pension_form8_entry"
 */

public abstract class BasePensionForm8Entry implements Serializable {

	public static String REF = "PensionForm8Entry";
	public static String PROP_OVER_PAYMENT = "OverPayment";
	public static String PROP_AMOUNT_OF_GRATUITY = "AmountOfGratuity";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_BALANCE_OF_HOUSE = "BalanceOfHouse";
	public static String PROP_FILE_NO = "FileNo";
	public static String PROP_AMOUNT_OF_LICENCE_FEE = "AmountOfLicenceFee";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_PERSONNEL = "Personnel";
	public static String PROP_DATE = "Date";
	public static String PROP_INCOME_TAX_DEDUCTIBLE = "IncomeTaxDeductible";
	public static String PROP_ARREARS_OF_LICENCE_FEE = "ArrearsOfLicenceFee";
	public static String PROP_ID = "Id";
	public static String PROP_OTHER_ASSESSED_DUES = "OtherAssessedDues";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_TOTAL = "Total";

	// constructors
	public BasePensionForm8Entry() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePensionForm8Entry(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String fileNo;
	private java.util.Date date;
	private java.math.BigDecimal balanceOfHouse;
	private java.math.BigDecimal overPayment;
	private java.math.BigDecimal incomeTaxDeductible;
	private java.math.BigDecimal arrearsOfLicenceFee;
	private java.math.BigDecimal amountOfLicenceFee;
	private java.math.BigDecimal otherAssessedDues;
	private java.math.BigDecimal amountOfGratuity;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.math.BigDecimal total;

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
	 * Return the value associated with the column: file_no
	 */
	public java.lang.String getFileNo() {
		return fileNo;
	}

	/**
	 * Set the value related to the column: file_no
	 * 
	 * @param fileNo
	 *            the file_no value
	 */
	public void setFileNo(java.lang.String fileNo) {
		this.fileNo = fileNo;
	}

	/**
	 * Return the value associated with the column: date
	 */
	public java.util.Date getDate() {
		return date;
	}

	/**
	 * Set the value related to the column: date
	 * 
	 * @param date
	 *            the date value
	 */
	public void setDate(java.util.Date date) {
		this.date = date;
	}

	/**
	 * Return the value associated with the column: balance_of_house
	 */
	public java.math.BigDecimal getBalanceOfHouse() {
		return balanceOfHouse;
	}

	/**
	 * Set the value related to the column: balance_of_house
	 * 
	 * @param balanceOfHouse
	 *            the balance_of_house value
	 */
	public void setBalanceOfHouse(java.math.BigDecimal balanceOfHouse) {
		this.balanceOfHouse = balanceOfHouse;
	}

	/**
	 * Return the value associated with the column: over_payment
	 */
	public java.math.BigDecimal getOverPayment() {
		return overPayment;
	}

	/**
	 * Set the value related to the column: over_payment
	 * 
	 * @param overPayment
	 *            the over_payment value
	 */
	public void setOverPayment(java.math.BigDecimal overPayment) {
		this.overPayment = overPayment;
	}

	/**
	 * Return the value associated with the column: income_tax_deductible
	 */
	public java.math.BigDecimal getIncomeTaxDeductible() {
		return incomeTaxDeductible;
	}

	/**
	 * Set the value related to the column: income_tax_deductible
	 * 
	 * @param incomeTaxDeductible
	 *            the income_tax_deductible value
	 */
	public void setIncomeTaxDeductible(java.math.BigDecimal incomeTaxDeductible) {
		this.incomeTaxDeductible = incomeTaxDeductible;
	}

	/**
	 * Return the value associated with the column: arrears_of_licence_fee
	 */
	public java.math.BigDecimal getArrearsOfLicenceFee() {
		return arrearsOfLicenceFee;
	}

	/**
	 * Set the value related to the column: arrears_of_licence_fee
	 * 
	 * @param arrearsOfLicenceFee
	 *            the arrears_of_licence_fee value
	 */
	public void setArrearsOfLicenceFee(java.math.BigDecimal arrearsOfLicenceFee) {
		this.arrearsOfLicenceFee = arrearsOfLicenceFee;
	}

	/**
	 * Return the value associated with the column: amount_of_licence_fee
	 */
	public java.math.BigDecimal getAmountOfLicenceFee() {
		return amountOfLicenceFee;
	}

	/**
	 * Set the value related to the column: amount_of_licence_fee
	 * 
	 * @param amountOfLicenceFee
	 *            the amount_of_licence_fee value
	 */
	public void setAmountOfLicenceFee(java.math.BigDecimal amountOfLicenceFee) {
		this.amountOfLicenceFee = amountOfLicenceFee;
	}

	/**
	 * Return the value associated with the column: other_assessed_dues
	 */
	public java.math.BigDecimal getOtherAssessedDues() {
		return otherAssessedDues;
	}

	/**
	 * Set the value related to the column: other_assessed_dues
	 * 
	 * @param otherAssessedDues
	 *            the other_assessed_dues value
	 */
	public void setOtherAssessedDues(java.math.BigDecimal otherAssessedDues) {
		this.otherAssessedDues = otherAssessedDues;
	}

	/**
	 * Return the value associated with the column: amount_of_gratuity
	 */
	public java.math.BigDecimal getAmountOfGratuity() {
		return amountOfGratuity;
	}

	/**
	 * Set the value related to the column: amount_of_gratuity
	 * 
	 * @param amountOfGratuity
	 *            the amount_of_gratuity value
	 */
	public void setAmountOfGratuity(java.math.BigDecimal amountOfGratuity) {
		this.amountOfGratuity = amountOfGratuity;
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
	 * Return the value associated with the column: total
	 */
	public java.math.BigDecimal getTotal() {
		return total;
	}

	/**
	 * Set the value related to the column: total
	 * 
	 * @param total
	 *            the total value
	 */
	public void setTotal(java.math.BigDecimal total) {
		this.total = total;
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
		if (!(obj instanceof jkt.hms.masters.business.PensionForm8Entry))
			return false;
		else {
			jkt.hms.masters.business.PensionForm8Entry pensionForm8Entry = (jkt.hms.masters.business.PensionForm8Entry) obj;
			if (null == this.getId() || null == pensionForm8Entry.getId())
				return false;
			else
				return (this.getId().equals(pensionForm8Entry.getId()));
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

}
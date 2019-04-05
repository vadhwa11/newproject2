package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * pension_form7_emoluments_detail table. Do not modify this class because it
 * will be overwritten if the configuration file related to this class is
 * modified.
 * 
 * @hibernate.class table="pension_form7_emoluments_detail"
 */

public abstract class BasePensionForm7EmolumentsDetail implements Serializable {

	public static String REF = "PensionForm7EmolumentsDetail";
	public static String PROP_FORM7 = "Form7";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_NO_OF_MONTHS = "NoOfMonths";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_PERSONEL_PAY = "PersonelPay";
	public static String PROP_PAY = "Pay";
	public static String PROP_TO_DATE = "ToDate";
	public static String PROP_AVERAGE_EMOLUMENTS = "AverageEmoluments";
	public static String PROP_ID = "Id";
	public static String PROP_PERSONNEL = "Personnel";
	public static String PROP_FROM_DATE = "FromDate";

	// constructors
	public BasePensionForm7EmolumentsDetail() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePensionForm7EmolumentsDetail(java.lang.Integer id) {
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
	private java.math.BigDecimal pay;
	private java.lang.Integer noOfMonths;
	private java.math.BigDecimal personelPay;
	private java.math.BigDecimal averageEmoluments;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.PensionForm7Details form7;
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
	 * Return the value associated with the column: pay
	 */
	public java.math.BigDecimal getPay() {
		return pay;
	}

	/**
	 * Set the value related to the column: pay
	 * 
	 * @param pay
	 *            the pay value
	 */
	public void setPay(java.math.BigDecimal pay) {
		this.pay = pay;
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
	 * Return the value associated with the column: personel_pay
	 */
	public java.math.BigDecimal getPersonelPay() {
		return personelPay;
	}

	/**
	 * Set the value related to the column: personel_pay
	 * 
	 * @param personelPay
	 *            the personel_pay value
	 */
	public void setPersonelPay(java.math.BigDecimal personelPay) {
		this.personelPay = personelPay;
	}

	/**
	 * Return the value associated with the column: average_emoluments
	 */
	public java.math.BigDecimal getAverageEmoluments() {
		return averageEmoluments;
	}

	/**
	 * Set the value related to the column: average_emoluments
	 * 
	 * @param averageEmoluments
	 *            the average_emoluments value
	 */
	public void setAverageEmoluments(java.math.BigDecimal averageEmoluments) {
		this.averageEmoluments = averageEmoluments;
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
	 * Return the value associated with the column: form7_id
	 */
	public jkt.hms.masters.business.PensionForm7Details getForm7() {
		return form7;
	}

	/**
	 * Set the value related to the column: form7_id
	 * 
	 * @param form7
	 *            the form7_id value
	 */
	public void setForm7(jkt.hms.masters.business.PensionForm7Details form7) {
		this.form7 = form7;
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
		if (!(obj instanceof jkt.hms.masters.business.PensionForm7EmolumentsDetail))
			return false;
		else {
			jkt.hms.masters.business.PensionForm7EmolumentsDetail pensionForm7EmolumentsDetail = (jkt.hms.masters.business.PensionForm7EmolumentsDetail) obj;
			if (null == this.getId()
					|| null == pensionForm7EmolumentsDetail.getId())
				return false;
			else
				return (this.getId().equals(pensionForm7EmolumentsDetail
						.getId()));
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
package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_mas_bonus table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_mas_bonus"
 */

public abstract class BaseHrMasBonus  implements Serializable {

	public static String REF = "HrMasBonus";
	public static String PROP_BONUS_TYPE = "BonusType";
	public static String PROP_DESCRIPTION = "Description";
	public static String PROP_FIXED_AMOUNT = "FixedAmount";
	public static String PROP_DUE_DATE = "DueDate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_BONUS_CODE = "BonusCode";
	public static String PROP_PAYMENT_FREQUENCY = "PaymentFrequency";
	public static String PROP_FROM_DATE = "FromDate";
	public static String PROP_BONUS_RATE = "BonusRate";
	public static String PROP_STATUS = "Status";
	public static String PROP_TO_DATE = "ToDate";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_GRADE = "Grade";
	public static String PROP_MAX_BASIC = "MaxBasic";
	public static String PROP_TAXABLE = "Taxable";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseHrMasBonus () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrMasBonus (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String bonusCode;
	private java.lang.String description;
	private java.lang.String bonusType;
	private java.lang.String paymentFrequency;
	private java.util.Date fromDate;
	private java.util.Date toDate;
	private java.util.Date dueDate;
	private java.math.BigDecimal fixedAmount;
	private java.math.BigDecimal maxBasic;
	private java.lang.Float bonusRate;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;
	private java.lang.String taxable;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasGrade grade;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="bonus_id"
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
	 * Return the value associated with the column: bonus_code
	 */
	public java.lang.String getBonusCode () {
		return bonusCode;
	}

	/**
	 * Set the value related to the column: bonus_code
	 * @param bonusCode the bonus_code value
	 */
	public void setBonusCode (java.lang.String bonusCode) {
		this.bonusCode = bonusCode;
	}



	/**
	 * Return the value associated with the column: description
	 */
	public java.lang.String getDescription () {
		return description;
	}

	/**
	 * Set the value related to the column: description
	 * @param description the description value
	 */
	public void setDescription (java.lang.String description) {
		this.description = description;
	}



	/**
	 * Return the value associated with the column: bonus_type
	 */
	public java.lang.String getBonusType () {
		return bonusType;
	}

	/**
	 * Set the value related to the column: bonus_type
	 * @param bonusType the bonus_type value
	 */
	public void setBonusType (java.lang.String bonusType) {
		this.bonusType = bonusType;
	}



	/**
	 * Return the value associated with the column: payment_frequency
	 */
	public java.lang.String getPaymentFrequency () {
		return paymentFrequency;
	}

	/**
	 * Set the value related to the column: payment_frequency
	 * @param paymentFrequency the payment_frequency value
	 */
	public void setPaymentFrequency (java.lang.String paymentFrequency) {
		this.paymentFrequency = paymentFrequency;
	}



	/**
	 * Return the value associated with the column: from_date
	 */
	public java.util.Date getFromDate () {
		return fromDate;
	}

	/**
	 * Set the value related to the column: from_date
	 * @param fromDate the from_date value
	 */
	public void setFromDate (java.util.Date fromDate) {
		this.fromDate = fromDate;
	}



	/**
	 * Return the value associated with the column: to_date
	 */
	public java.util.Date getToDate () {
		return toDate;
	}

	/**
	 * Set the value related to the column: to_date
	 * @param toDate the to_date value
	 */
	public void setToDate (java.util.Date toDate) {
		this.toDate = toDate;
	}



	/**
	 * Return the value associated with the column: due_date
	 */
	public java.util.Date getDueDate () {
		return dueDate;
	}

	/**
	 * Set the value related to the column: due_date
	 * @param dueDate the due_date value
	 */
	public void setDueDate (java.util.Date dueDate) {
		this.dueDate = dueDate;
	}



	/**
	 * Return the value associated with the column: fixed_amount
	 */
	public java.math.BigDecimal getFixedAmount () {
		return fixedAmount;
	}

	/**
	 * Set the value related to the column: fixed_amount
	 * @param fixedAmount the fixed_amount value
	 */
	public void setFixedAmount (java.math.BigDecimal fixedAmount) {
		this.fixedAmount = fixedAmount;
	}



	/**
	 * Return the value associated with the column: max_basic
	 */
	public java.math.BigDecimal getMaxBasic () {
		return maxBasic;
	}

	/**
	 * Set the value related to the column: max_basic
	 * @param maxBasic the max_basic value
	 */
	public void setMaxBasic (java.math.BigDecimal maxBasic) {
		this.maxBasic = maxBasic;
	}



	/**
	 * Return the value associated with the column: bonus_rate
	 */
	public java.lang.Float getBonusRate () {
		return bonusRate;
	}

	/**
	 * Set the value related to the column: bonus_rate
	 * @param bonusRate the bonus_rate value
	 */
	public void setBonusRate (java.lang.Float bonusRate) {
		this.bonusRate = bonusRate;
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
	 * Return the value associated with the column: taxable
	 */
	public java.lang.String getTaxable () {
		return taxable;
	}

	/**
	 * Set the value related to the column: taxable
	 * @param taxable the taxable value
	 */
	public void setTaxable (java.lang.String taxable) {
		this.taxable = taxable;
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



	/**
	 * Return the value associated with the column: grade_id
	 */
	public jkt.hms.masters.business.MasGrade getGrade () {
		return grade;
	}

	/**
	 * Set the value related to the column: grade_id
	 * @param grade the grade_id value
	 */
	public void setGrade (jkt.hms.masters.business.MasGrade grade) {
		this.grade = grade;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HrMasBonus)) return false;
		else {
			jkt.hms.masters.business.HrMasBonus hrMasBonus = (jkt.hms.masters.business.HrMasBonus) obj;
			if (null == this.getId() || null == hrMasBonus.getId()) return false;
			else return (this.getId().equals(hrMasBonus.getId()));
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
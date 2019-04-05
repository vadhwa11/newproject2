package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the hr_mas_pay_element table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_mas_pay_element"
 */

public abstract class BaseHrMasPayElement  implements Serializable {

	public static String REF = "HrMasPayElement";
	public static String PROP_PAY_ELEMENT_CODE = "PayElementCode";
	public static String PROP_BASIC_MULTIPLIER = "BasicMultiplier";
	public static String PROP_REIMB_ELEMENT = "ReimbElement";
	public static String PROP_STATUS_DATE = "StatusDate";
	public static String PROP_PREVAILING_PERCENTAGE = "PrevailingPercentage";
	public static String PROP_PF_DEPENDENT = "PfDependent";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_EFFECTIVE_DATE = "EffectiveDate";
	public static String PROP_CTC_HEADING = "CtcHeading";
	public static String PROP_BASIC_DEPENDENT = "BasicDependent";
	public static String PROP_PAY_ELEMENT_STATUS = "PayElementStatus";
	public static String PROP_TAXABLE_ELEMENT = "TaxableElement";
	public static String PROP_STATUS = "Status";
	public static String PROP_PERCENTAGE = "Percentage";
	public static String PROP_PAY_ELEMENT_DESC = "PayElementDesc";
	public static String PROP_OT_CALCULATION = "OtCalculation";
	public static String PROP_ARREAR_ELEMENT = "ArrearElement";
	public static String PROP_SHOW_IN_PAYSLIP = "ShowInPayslip";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ID = "Id";
	public static String PROP_MAX_AMOUNT = "MaxAmount";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_PAY_ELEMENT_TYPE = "PayElementType";


	// constructors
	public BaseHrMasPayElement () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrMasPayElement (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String payElementCode;
	private java.lang.String payElementDesc;
	private java.lang.String payElementType;
	private java.util.Date effectiveDate;
	private java.lang.String taxableElement;
	private java.lang.String otCalculation;
	private java.lang.String arrearElement;
	private java.lang.String reimbElement;
	private java.lang.String basicDependent;
	private java.lang.String prevailingPercentage;
	private java.lang.String pfDependent;
	private java.lang.String payElementStatus;
	private java.util.Date statusDate;
	private java.lang.Float basicMultiplier;
	private java.lang.Float percentage;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;
	private java.math.BigDecimal maxAmount;
	private java.lang.String ctcHeading;
	private java.lang.String showInPayslip;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="pay_element_id"
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
	 * Return the value associated with the column: pay_element_code
	 */
	public java.lang.String getPayElementCode () {
		return payElementCode;
	}

	/**
	 * Set the value related to the column: pay_element_code
	 * @param payElementCode the pay_element_code value
	 */
	public void setPayElementCode (java.lang.String payElementCode) {
		this.payElementCode = payElementCode;
	}



	/**
	 * Return the value associated with the column: pay_element_desc
	 */
	public java.lang.String getPayElementDesc () {
		return payElementDesc;
	}

	/**
	 * Set the value related to the column: pay_element_desc
	 * @param payElementDesc the pay_element_desc value
	 */
	public void setPayElementDesc (java.lang.String payElementDesc) {
		this.payElementDesc = payElementDesc;
	}



	/**
	 * Return the value associated with the column: pay_element_type
	 */
	public java.lang.String getPayElementType () {
		return payElementType;
	}

	/**
	 * Set the value related to the column: pay_element_type
	 * @param payElementType the pay_element_type value
	 */
	public void setPayElementType (java.lang.String payElementType) {
		this.payElementType = payElementType;
	}



	/**
	 * Return the value associated with the column: effective_date
	 */
	public java.util.Date getEffectiveDate () {
		return effectiveDate;
	}

	/**
	 * Set the value related to the column: effective_date
	 * @param effectiveDate the effective_date value
	 */
	public void setEffectiveDate (java.util.Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}



	/**
	 * Return the value associated with the column: taxable_element
	 */
	public java.lang.String getTaxableElement () {
		return taxableElement;
	}

	/**
	 * Set the value related to the column: taxable_element
	 * @param taxableElement the taxable_element value
	 */
	public void setTaxableElement (java.lang.String taxableElement) {
		this.taxableElement = taxableElement;
	}



	/**
	 * Return the value associated with the column: ot_calculation
	 */
	public java.lang.String getOtCalculation () {
		return otCalculation;
	}

	/**
	 * Set the value related to the column: ot_calculation
	 * @param otCalculation the ot_calculation value
	 */
	public void setOtCalculation (java.lang.String otCalculation) {
		this.otCalculation = otCalculation;
	}



	/**
	 * Return the value associated with the column: arrear_element
	 */
	public java.lang.String getArrearElement () {
		return arrearElement;
	}

	/**
	 * Set the value related to the column: arrear_element
	 * @param arrearElement the arrear_element value
	 */
	public void setArrearElement (java.lang.String arrearElement) {
		this.arrearElement = arrearElement;
	}



	/**
	 * Return the value associated with the column: reimb_element
	 */
	public java.lang.String getReimbElement () {
		return reimbElement;
	}

	/**
	 * Set the value related to the column: reimb_element
	 * @param reimbElement the reimb_element value
	 */
	public void setReimbElement (java.lang.String reimbElement) {
		this.reimbElement = reimbElement;
	}



	/**
	 * Return the value associated with the column: basic_dependent
	 */
	public java.lang.String getBasicDependent () {
		return basicDependent;
	}

	/**
	 * Set the value related to the column: basic_dependent
	 * @param basicDependent the basic_dependent value
	 */
	public void setBasicDependent (java.lang.String basicDependent) {
		this.basicDependent = basicDependent;
	}



	/**
	 * Return the value associated with the column: prevailing_percentage
	 */
	public java.lang.String getPrevailingPercentage () {
		return prevailingPercentage;
	}

	/**
	 * Set the value related to the column: prevailing_percentage
	 * @param prevailingPercentage the prevailing_percentage value
	 */
	public void setPrevailingPercentage (java.lang.String prevailingPercentage) {
		this.prevailingPercentage = prevailingPercentage;
	}



	/**
	 * Return the value associated with the column: pf_dependent
	 */
	public java.lang.String getPfDependent () {
		return pfDependent;
	}

	/**
	 * Set the value related to the column: pf_dependent
	 * @param pfDependent the pf_dependent value
	 */
	public void setPfDependent (java.lang.String pfDependent) {
		this.pfDependent = pfDependent;
	}



	/**
	 * Return the value associated with the column: pay_element_status
	 */
	public java.lang.String getPayElementStatus () {
		return payElementStatus;
	}

	/**
	 * Set the value related to the column: pay_element_status
	 * @param payElementStatus the pay_element_status value
	 */
	public void setPayElementStatus (java.lang.String payElementStatus) {
		this.payElementStatus = payElementStatus;
	}



	/**
	 * Return the value associated with the column: status_date
	 */
	public java.util.Date getStatusDate () {
		return statusDate;
	}

	/**
	 * Set the value related to the column: status_date
	 * @param statusDate the status_date value
	 */
	public void setStatusDate (java.util.Date statusDate) {
		this.statusDate = statusDate;
	}



	/**
	 * Return the value associated with the column: basic_multiplier
	 */
	public java.lang.Float getBasicMultiplier () {
		return basicMultiplier;
	}

	/**
	 * Set the value related to the column: basic_multiplier
	 * @param basicMultiplier the basic_multiplier value
	 */
	public void setBasicMultiplier (java.lang.Float basicMultiplier) {
		this.basicMultiplier = basicMultiplier;
	}



	/**
	 * Return the value associated with the column: percentage
	 */
	public java.lang.Float getPercentage () {
		return percentage;
	}

	/**
	 * Set the value related to the column: percentage
	 * @param percentage the percentage value
	 */
	public void setPercentage (java.lang.Float percentage) {
		this.percentage = percentage;
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
	 * Return the value associated with the column: ctc_heading
	 */
	public java.lang.String getCtcHeading () {
		return ctcHeading;
	}

	/**
	 * Set the value related to the column: ctc_heading
	 * @param ctcHeading the ctc_heading value
	 */
	public void setCtcHeading (java.lang.String ctcHeading) {
		this.ctcHeading = ctcHeading;
	}



	/**
	 * Return the value associated with the column: show_in_payslip
	 */
	public java.lang.String getShowInPayslip () {
		return showInPayslip;
	}

	/**
	 * Set the value related to the column: show_in_payslip
	 * @param showInPayslip the show_in_payslip value
	 */
	public void setShowInPayslip (java.lang.String showInPayslip) {
		this.showInPayslip = showInPayslip;
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
		if (!(obj instanceof jkt.hms.masters.business.HrMasPayElement)) return false;
		else {
			jkt.hms.masters.business.HrMasPayElement hrMasPayElement = (jkt.hms.masters.business.HrMasPayElement) obj;
			if (null == this.getId() || null == hrMasPayElement.getId()) return false;
			else return (this.getId().equals(hrMasPayElement.getId()));
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
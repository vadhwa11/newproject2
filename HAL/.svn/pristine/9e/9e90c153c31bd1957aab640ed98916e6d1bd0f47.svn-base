package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the fa_mas_sub_led table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="fa_mas_sub_led"
 */

public abstract class BaseFaMasSubLed  implements Serializable {

	public static String REF = "FaMasSubLed";
	public static String PROP_STATUS = "Status";
	public static String PROP_SUB_LED_TYPE = "SubLedType";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ACCOUNT = "Account";
	public static String PROP_SUB_LED_DESC = "SubLedDesc";
	public static String PROP_OP_BALANCE_CR = "OpBalanceCr";
	public static String PROP_SUB_LED_CODE = "SubLedCode";
	public static String PROP_OP_BALANCE_DR = "OpBalanceDr";
	public static String PROP_F_YEAR = "FYear";
	public static String PROP_YTD_AMOUNT_DR = "YtdAmountDr";
	public static String PROP_CENTRE = "Centre";
	public static String PROP_CL_BALANCE_DR = "ClBalanceDr";
	public static String PROP_CL_BALANCE_CR = "ClBalanceCr";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_ACC_CODE = "AccCode";
	public static String PROP_YTD_AMOUNT_CR = "YtdAmountCr";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";


	// constructors
	public BaseFaMasSubLed () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFaMasSubLed (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String subLedCode;
	private java.lang.String subLedDesc;
	private java.lang.Integer accCode;
	private java.math.BigDecimal ytdAmountDr;
	private java.math.BigDecimal ytdAmountCr;
	private java.math.BigDecimal opBalanceDr;
	private java.math.BigDecimal opBalanceCr;
	private java.math.BigDecimal clBalanceDr;
	private java.math.BigDecimal clBalanceCr;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String subLedType;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.FaMasAccount account;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasStoreFinancial fYear;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasHospital centre;

	// collections
	private java.util.Set<jkt.hms.masters.business.MasChargeCode> masChargeCodes;
	private java.util.Set<jkt.hms.masters.business.FaVoucherDetails> faVoucherDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="sub_led_id"
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
	 * Return the value associated with the column: sub_led_code
	 */
	public java.lang.String getSubLedCode () {
		return subLedCode;
	}

	/**
	 * Set the value related to the column: sub_led_code
	 * @param subLedCode the sub_led_code value
	 */
	public void setSubLedCode (java.lang.String subLedCode) {
		this.subLedCode = subLedCode;
	}



	/**
	 * Return the value associated with the column: sub_led_desc
	 */
	public java.lang.String getSubLedDesc () {
		return subLedDesc;
	}

	/**
	 * Set the value related to the column: sub_led_desc
	 * @param subLedDesc the sub_led_desc value
	 */
	public void setSubLedDesc (java.lang.String subLedDesc) {
		this.subLedDesc = subLedDesc;
	}



	/**
	 * Return the value associated with the column: acc_code
	 */
	public java.lang.Integer getAccCode () {
		return accCode;
	}

	/**
	 * Set the value related to the column: acc_code
	 * @param accCode the acc_code value
	 */
	public void setAccCode (java.lang.Integer accCode) {
		this.accCode = accCode;
	}



	/**
	 * Return the value associated with the column: ytd_amount_dr
	 */
	public java.math.BigDecimal getYtdAmountDr () {
		return ytdAmountDr;
	}

	/**
	 * Set the value related to the column: ytd_amount_dr
	 * @param ytdAmountDr the ytd_amount_dr value
	 */
	public void setYtdAmountDr (java.math.BigDecimal ytdAmountDr) {
		this.ytdAmountDr = ytdAmountDr;
	}



	/**
	 * Return the value associated with the column: ytd_amount_cr
	 */
	public java.math.BigDecimal getYtdAmountCr () {
		return ytdAmountCr;
	}

	/**
	 * Set the value related to the column: ytd_amount_cr
	 * @param ytdAmountCr the ytd_amount_cr value
	 */
	public void setYtdAmountCr (java.math.BigDecimal ytdAmountCr) {
		this.ytdAmountCr = ytdAmountCr;
	}



	/**
	 * Return the value associated with the column: op_balance_dr
	 */
	public java.math.BigDecimal getOpBalanceDr () {
		return opBalanceDr;
	}

	/**
	 * Set the value related to the column: op_balance_dr
	 * @param opBalanceDr the op_balance_dr value
	 */
	public void setOpBalanceDr (java.math.BigDecimal opBalanceDr) {
		this.opBalanceDr = opBalanceDr;
	}



	/**
	 * Return the value associated with the column: op_balance_cr
	 */
	public java.math.BigDecimal getOpBalanceCr () {
		return opBalanceCr;
	}

	/**
	 * Set the value related to the column: op_balance_cr
	 * @param opBalanceCr the op_balance_cr value
	 */
	public void setOpBalanceCr (java.math.BigDecimal opBalanceCr) {
		this.opBalanceCr = opBalanceCr;
	}



	/**
	 * Return the value associated with the column: cl_balance_dr
	 */
	public java.math.BigDecimal getClBalanceDr () {
		return clBalanceDr;
	}

	/**
	 * Set the value related to the column: cl_balance_dr
	 * @param clBalanceDr the cl_balance_dr value
	 */
	public void setClBalanceDr (java.math.BigDecimal clBalanceDr) {
		this.clBalanceDr = clBalanceDr;
	}



	/**
	 * Return the value associated with the column: cl_balance_cr
	 */
	public java.math.BigDecimal getClBalanceCr () {
		return clBalanceCr;
	}

	/**
	 * Set the value related to the column: cl_balance_cr
	 * @param clBalanceCr the cl_balance_cr value
	 */
	public void setClBalanceCr (java.math.BigDecimal clBalanceCr) {
		this.clBalanceCr = clBalanceCr;
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
	 * Return the value associated with the column: sub_led_type
	 */
	public java.lang.String getSubLedType () {
		return subLedType;
	}

	/**
	 * Set the value related to the column: sub_led_type
	 * @param subLedType the sub_led_type value
	 */
	public void setSubLedType (java.lang.String subLedType) {
		this.subLedType = subLedType;
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
	 * Return the value associated with the column: f_year_id
	 */
	public jkt.hms.masters.business.MasStoreFinancial getFYear () {
		return fYear;
	}

	/**
	 * Set the value related to the column: f_year_id
	 * @param fYear the f_year_id value
	 */
	public void setFYear (jkt.hms.masters.business.MasStoreFinancial fYear) {
		this.fYear = fYear;
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
	 * Return the value associated with the column: centre_id
	 */
	public jkt.hms.masters.business.MasHospital getCentre () {
		return centre;
	}

	/**
	 * Set the value related to the column: centre_id
	 * @param centre the centre_id value
	 */
	public void setCentre (jkt.hms.masters.business.MasHospital centre) {
		this.centre = centre;
	}



	/**
	 * Return the value associated with the column: MasChargeCodes
	 */
	public java.util.Set<jkt.hms.masters.business.MasChargeCode> getMasChargeCodes () {
		return masChargeCodes;
	}

	/**
	 * Set the value related to the column: MasChargeCodes
	 * @param masChargeCodes the MasChargeCodes value
	 */
	public void setMasChargeCodes (java.util.Set<jkt.hms.masters.business.MasChargeCode> masChargeCodes) {
		this.masChargeCodes = masChargeCodes;
	}

	public void addToMasChargeCodes (jkt.hms.masters.business.MasChargeCode masChargeCode) {
		if (null == getMasChargeCodes()) setMasChargeCodes(new java.util.TreeSet<jkt.hms.masters.business.MasChargeCode>());
		getMasChargeCodes().add(masChargeCode);
	}



	/**
	 * Return the value associated with the column: FaVoucherDetails
	 */
	public java.util.Set<jkt.hms.masters.business.FaVoucherDetails> getFaVoucherDetails () {
		return faVoucherDetails;
	}

	/**
	 * Set the value related to the column: FaVoucherDetails
	 * @param faVoucherDetails the FaVoucherDetails value
	 */
	public void setFaVoucherDetails (java.util.Set<jkt.hms.masters.business.FaVoucherDetails> faVoucherDetails) {
		this.faVoucherDetails = faVoucherDetails;
	}

	public void addToFaVoucherDetails (jkt.hms.masters.business.FaVoucherDetails faVoucherDetails) {
		if (null == getFaVoucherDetails()) setFaVoucherDetails(new java.util.TreeSet<jkt.hms.masters.business.FaVoucherDetails>());
		getFaVoucherDetails().add(faVoucherDetails);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.FaMasSubLed)) return false;
		else {
			jkt.hms.masters.business.FaMasSubLed faMasSubLed = (jkt.hms.masters.business.FaMasSubLed) obj;
			if (null == this.getId() || null == faMasSubLed.getId()) return false;
			else return (this.getId().equals(faMasSubLed.getId()));
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
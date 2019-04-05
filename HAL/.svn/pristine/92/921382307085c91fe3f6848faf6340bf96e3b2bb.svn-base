package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the bl_charge_slip_detail
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="bl_charge_slip_detail"
 */

public abstract class BaseBlChargeSlipDetail implements Serializable {

	public static String REF = "BlChargeSlipDetail";
	public static String PROP_STATUS = "Status";
	public static String PROP_CHARGE_CODE = "ChargeCode";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DIS = "Dis";
	public static String PROP_AMT = "Amt";
	public static String PROP_NET_AMT = "NetAmt";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_CHARGE_SLIP_MAIN = "ChargeSlipMain";
	public static String PROP_QUANTITY = "Quantity";
	public static String PROP_ID = "Id";
	public static String PROP_RATE = "Rate";

	// constructors
	public BaseBlChargeSlipDetail() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBlChargeSlipDetail(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer quantity;
	private java.math.BigDecimal amt;
	private java.math.BigDecimal dis;
	private java.math.BigDecimal netAmt;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;
	private java.math.BigDecimal rate;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.BlChargeSlipMain chargeSlipMain;
	private jkt.hms.masters.business.MasChargeCode chargeCode;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="charge_slip_detail_id"
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
	 * Return the value associated with the column: quantity
	 */
	public java.lang.Integer getQuantity() {
		return quantity;
	}

	/**
	 * Set the value related to the column: quantity
	 * 
	 * @param quantity
	 *            the quantity value
	 */
	public void setQuantity(java.lang.Integer quantity) {
		this.quantity = quantity;
	}

	/**
	 * Return the value associated with the column: amt
	 */
	public java.math.BigDecimal getAmt() {
		return amt;
	}

	/**
	 * Set the value related to the column: amt
	 * 
	 * @param amt
	 *            the amt value
	 */
	public void setAmt(java.math.BigDecimal amt) {
		this.amt = amt;
	}

	/**
	 * Return the value associated with the column: dis
	 */
	public java.math.BigDecimal getDis() {
		return dis;
	}

	/**
	 * Set the value related to the column: dis
	 * 
	 * @param dis
	 *            the dis value
	 */
	public void setDis(java.math.BigDecimal dis) {
		this.dis = dis;
	}

	/**
	 * Return the value associated with the column: net_amt
	 */
	public java.math.BigDecimal getNetAmt() {
		return netAmt;
	}

	/**
	 * Set the value related to the column: net_amt
	 * 
	 * @param netAmt
	 *            the net_amt value
	 */
	public void setNetAmt(java.math.BigDecimal netAmt) {
		this.netAmt = netAmt;
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
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus() {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * 
	 * @param status
	 *            the status value
	 */
	public void setStatus(java.lang.String status) {
		this.status = status;
	}

	/**
	 * Return the value associated with the column: rate
	 */
	public java.math.BigDecimal getRate() {
		return rate;
	}

	/**
	 * Set the value related to the column: rate
	 * 
	 * @param rate
	 *            the rate value
	 */
	public void setRate(java.math.BigDecimal rate) {
		this.rate = rate;
	}

	/**
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital() {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * 
	 * @param hospital
	 *            the hospital_id value
	 */
	public void setHospital(jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}

	/**
	 * Return the value associated with the column: charge_slip_main_id
	 */
	public jkt.hms.masters.business.BlChargeSlipMain getChargeSlipMain() {
		return chargeSlipMain;
	}

	/**
	 * Set the value related to the column: charge_slip_main_id
	 * 
	 * @param chargeSlipMain
	 *            the charge_slip_main_id value
	 */
	public void setChargeSlipMain(
			jkt.hms.masters.business.BlChargeSlipMain chargeSlipMain) {
		this.chargeSlipMain = chargeSlipMain;
	}

	/**
	 * Return the value associated with the column: charge_code_id
	 */
	public jkt.hms.masters.business.MasChargeCode getChargeCode() {
		return chargeCode;
	}

	/**
	 * Set the value related to the column: charge_code_id
	 * 
	 * @param chargeCode
	 *            the charge_code_id value
	 */
	public void setChargeCode(jkt.hms.masters.business.MasChargeCode chargeCode) {
		this.chargeCode = chargeCode;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.BlChargeSlipDetail))
			return false;
		else {
			jkt.hms.masters.business.BlChargeSlipDetail blChargeSlipDetail = (jkt.hms.masters.business.BlChargeSlipDetail) obj;
			if (null == this.getId() || null == blChargeSlipDetail.getId())
				return false;
			else
				return (this.getId().equals(blChargeSlipDetail.getId()));
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
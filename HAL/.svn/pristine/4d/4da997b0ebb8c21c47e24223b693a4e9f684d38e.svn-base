package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the fa_cheque_cancel table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="fa_cheque_cancel"
 */

public abstract class BaseFaChequeCancel  implements Serializable {

	public static String REF = "FaChequeCancel";
	public static String PROP_STATUS = "Status";
	public static String PROP_REASON_FOR_CANCLE = "ReasonForCancle";
	public static String PROP_VOUCHER_HEADER = "VoucherHeader";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_BANK = "Bank";
	public static String PROP_CANCEL_DATE = "CancelDate";
	public static String PROP_CHEQUE_DETAILS = "ChequeDetails";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LOCATION = "Location";


	// constructors
	public BaseFaChequeCancel () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFaChequeCancel (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date cancelDate;
	private java.lang.String status;
	private java.lang.String reasonForCancle;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasBankMaster bank;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.FaVoucherHeader voucherHeader;
	private jkt.hms.masters.business.FaChequeDetails chequeDetails;
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
	 * Return the value associated with the column: cancel_date
	 */
	public java.util.Date getCancelDate () {
		return cancelDate;
	}

	/**
	 * Set the value related to the column: cancel_date
	 * @param cancelDate the cancel_date value
	 */
	public void setCancelDate (java.util.Date cancelDate) {
		this.cancelDate = cancelDate;
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
	 * Return the value associated with the column: reason_for_cancle
	 */
	public java.lang.String getReasonForCancle () {
		return reasonForCancle;
	}

	/**
	 * Set the value related to the column: reason_for_cancle
	 * @param reasonForCancle the reason_for_cancle value
	 */
	public void setReasonForCancle (java.lang.String reasonForCancle) {
		this.reasonForCancle = reasonForCancle;
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
	 * Return the value associated with the column: voucher_header_id
	 */
	public jkt.hms.masters.business.FaVoucherHeader getVoucherHeader () {
		return voucherHeader;
	}

	/**
	 * Set the value related to the column: voucher_header_id
	 * @param voucherHeader the voucher_header_id value
	 */
	public void setVoucherHeader (jkt.hms.masters.business.FaVoucherHeader voucherHeader) {
		this.voucherHeader = voucherHeader;
	}



	/**
	 * Return the value associated with the column: cheque_details_id
	 */
	public jkt.hms.masters.business.FaChequeDetails getChequeDetails () {
		return chequeDetails;
	}

	/**
	 * Set the value related to the column: cheque_details_id
	 * @param chequeDetails the cheque_details_id value
	 */
	public void setChequeDetails (jkt.hms.masters.business.FaChequeDetails chequeDetails) {
		this.chequeDetails = chequeDetails;
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
		if (!(obj instanceof jkt.hms.masters.business.FaChequeCancel)) return false;
		else {
			jkt.hms.masters.business.FaChequeCancel faChequeCancel = (jkt.hms.masters.business.FaChequeCancel) obj;
			if (null == this.getId() || null == faChequeCancel.getId()) return false;
			else return (this.getId().equals(faChequeCancel.getId()));
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
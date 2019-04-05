package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the bl_receipt_header table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="bl_receipt_header"
 */

public abstract class BaseBlReceiptHeader  implements Serializable {

	public static String REF = "BlReceiptHeader";
	public static String PROP_STATUS = "Status";
	public static String PROP_IP_FINAL_BILL_ID = "IpFinalBillId";
	public static String PROP_CHANGED_BY = "ChangedBy";
	public static String PROP_RECEIPT_TIME = "ReceiptTime";
	public static String PROP_AMOUNT = "Amount";
	public static String PROP_HIN = "Hin";
	public static String PROP_OP_BILL_HEADER = "OpBillHeader";
	public static String PROP_RECEIPT_TYPE = "ReceiptType";
	public static String PROP_REMAINING_CREDIT = "RemainingCredit";
	public static String PROP_DISPENSING_HEADER_ID = "DispensingHeaderId";
	public static String PROP_PACKAGE_BILL_ID = "PackageBillId";
	public static String PROP_CHARITY_AMT = "CharityAmt";
	public static String PROP_CHARGE_SLIP_MAIN = "ChargeSlipMain";
	public static String PROP_ROUND_OFF = "RoundOff";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_TRANSFER = "Transfer";
	public static String PROP_RECEIPT_NO = "ReceiptNo";
	public static String PROP_OPD_PATIENT_DETAIL = "OpdPatientDetail";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ID = "Id";
	public static String PROP_RECEIPT_DATE = "ReceiptDate";
	public static String PROP_TOTAL_RCD_AMT = "TotalRcdAmt";


	// constructors
	public BaseBlReceiptHeader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBlReceiptHeader (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseBlReceiptHeader (
		java.lang.Integer id,
		jkt.hms.masters.business.Users changedBy,
		jkt.hms.masters.business.MasHospital hospital,
		java.lang.String receiptNo,
		java.util.Date receiptDate) {

		this.setId(id);
		this.setChangedBy(changedBy);
		this.setHospital(hospital);
		this.setReceiptNo(receiptNo);
		this.setReceiptDate(receiptDate);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String receiptNo;
	private java.lang.String receiptType;
	private java.math.BigDecimal amount;
	private java.util.Date receiptDate;
	private java.lang.String receiptTime;
	private java.lang.Integer dispensingHeaderId;
	private java.lang.Integer ipFinalBillId;
	private java.math.BigDecimal charityAmt;
	private java.math.BigDecimal roundOff;
	private java.lang.Integer packageBillId;
	private java.lang.String status;
	private java.math.BigDecimal remainingCredit;
	private java.math.BigDecimal totalRcdAmt;

	// many to one
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.Users changedBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.OpdPatientDetails opdPatientDetail;
	private jkt.hms.masters.business.BlOpBillHeader opBillHeader;
	private jkt.hms.masters.business.Transfer transfer;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.BlChargeSlipMain chargeSlipMain;

	// collections
	private java.util.Set<jkt.hms.masters.business.BlReceiptDetails> blReceiptDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="receipt_header_id"
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
	 * Return the value associated with the column: receipt_no
	 */
	public java.lang.String getReceiptNo () {
		return receiptNo;
	}

	/**
	 * Set the value related to the column: receipt_no
	 * @param receiptNo the receipt_no value
	 */
	public void setReceiptNo (java.lang.String receiptNo) {
		this.receiptNo = receiptNo;
	}



	/**
	 * Return the value associated with the column: receipt_type
	 */
	public java.lang.String getReceiptType () {
		return receiptType;
	}

	/**
	 * Set the value related to the column: receipt_type
	 * @param receiptType the receipt_type value
	 */
	public void setReceiptType (java.lang.String receiptType) {
		this.receiptType = receiptType;
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
	 * Return the value associated with the column: receipt_date
	 */
	public java.util.Date getReceiptDate () {
		return receiptDate;
	}

	/**
	 * Set the value related to the column: receipt_date
	 * @param receiptDate the receipt_date value
	 */
	public void setReceiptDate (java.util.Date receiptDate) {
		this.receiptDate = receiptDate;
	}



	/**
	 * Return the value associated with the column: receipt_time
	 */
	public java.lang.String getReceiptTime () {
		return receiptTime;
	}

	/**
	 * Set the value related to the column: receipt_time
	 * @param receiptTime the receipt_time value
	 */
	public void setReceiptTime (java.lang.String receiptTime) {
		this.receiptTime = receiptTime;
	}



	/**
	 * Return the value associated with the column: dispensing_header_id
	 */
	public java.lang.Integer getDispensingHeaderId () {
		return dispensingHeaderId;
	}

	/**
	 * Set the value related to the column: dispensing_header_id
	 * @param dispensingHeaderId the dispensing_header_id value
	 */
	public void setDispensingHeaderId (java.lang.Integer dispensingHeaderId) {
		this.dispensingHeaderId = dispensingHeaderId;
	}



	/**
	 * Return the value associated with the column: ip_final_bill_id
	 */
	public java.lang.Integer getIpFinalBillId () {
		return ipFinalBillId;
	}

	/**
	 * Set the value related to the column: ip_final_bill_id
	 * @param ipFinalBillId the ip_final_bill_id value
	 */
	public void setIpFinalBillId (java.lang.Integer ipFinalBillId) {
		this.ipFinalBillId = ipFinalBillId;
	}



	/**
	 * Return the value associated with the column: charity_amt
	 */
	public java.math.BigDecimal getCharityAmt () {
		return charityAmt;
	}

	/**
	 * Set the value related to the column: charity_amt
	 * @param charityAmt the charity_amt value
	 */
	public void setCharityAmt (java.math.BigDecimal charityAmt) {
		this.charityAmt = charityAmt;
	}



	/**
	 * Return the value associated with the column: round_off
	 */
	public java.math.BigDecimal getRoundOff () {
		return roundOff;
	}

	/**
	 * Set the value related to the column: round_off
	 * @param roundOff the round_off value
	 */
	public void setRoundOff (java.math.BigDecimal roundOff) {
		this.roundOff = roundOff;
	}



	/**
	 * Return the value associated with the column: package_bill_id
	 */
	public java.lang.Integer getPackageBillId () {
		return packageBillId;
	}

	/**
	 * Set the value related to the column: package_bill_id
	 * @param packageBillId the package_bill_id value
	 */
	public void setPackageBillId (java.lang.Integer packageBillId) {
		this.packageBillId = packageBillId;
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
	 * Return the value associated with the column: remaining_credit
	 */
	public java.math.BigDecimal getRemainingCredit () {
		return remainingCredit;
	}

	/**
	 * Set the value related to the column: remaining_credit
	 * @param remainingCredit the remaining_credit value
	 */
	public void setRemainingCredit (java.math.BigDecimal remainingCredit) {
		this.remainingCredit = remainingCredit;
	}



	/**
	 * Return the value associated with the column: total_rcd_amt
	 */
	public java.math.BigDecimal getTotalRcdAmt () {
		return totalRcdAmt;
	}

	/**
	 * Set the value related to the column: total_rcd_amt
	 * @param totalRcdAmt the total_rcd_amt value
	 */
	public void setTotalRcdAmt (java.math.BigDecimal totalRcdAmt) {
		this.totalRcdAmt = totalRcdAmt;
	}



	/**
	 * Return the value associated with the column: inpatient_id
	 */
	public jkt.hms.masters.business.Inpatient getInpatient () {
		return inpatient;
	}

	/**
	 * Set the value related to the column: inpatient_id
	 * @param inpatient the inpatient_id value
	 */
	public void setInpatient (jkt.hms.masters.business.Inpatient inpatient) {
		this.inpatient = inpatient;
	}



	/**
	 * Return the value associated with the column: changed_by
	 */
	public jkt.hms.masters.business.Users getChangedBy () {
		return changedBy;
	}

	/**
	 * Set the value related to the column: changed_by
	 * @param changedBy the changed_by value
	 */
	public void setChangedBy (jkt.hms.masters.business.Users changedBy) {
		this.changedBy = changedBy;
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
	 * Return the value associated with the column: opd_patient_detail_id
	 */
	public jkt.hms.masters.business.OpdPatientDetails getOpdPatientDetail () {
		return opdPatientDetail;
	}

	/**
	 * Set the value related to the column: opd_patient_detail_id
	 * @param opdPatientDetail the opd_patient_detail_id value
	 */
	public void setOpdPatientDetail (jkt.hms.masters.business.OpdPatientDetails opdPatientDetail) {
		this.opdPatientDetail = opdPatientDetail;
	}



	/**
	 * Return the value associated with the column: op_bill_header_id
	 */
	public jkt.hms.masters.business.BlOpBillHeader getOpBillHeader () {
		return opBillHeader;
	}

	/**
	 * Set the value related to the column: op_bill_header_id
	 * @param opBillHeader the op_bill_header_id value
	 */
	public void setOpBillHeader (jkt.hms.masters.business.BlOpBillHeader opBillHeader) {
		this.opBillHeader = opBillHeader;
	}



	/**
	 * Return the value associated with the column: transfer_id
	 */
	public jkt.hms.masters.business.Transfer getTransfer () {
		return transfer;
	}

	/**
	 * Set the value related to the column: transfer_id
	 * @param transfer the transfer_id value
	 */
	public void setTransfer (jkt.hms.masters.business.Transfer transfer) {
		this.transfer = transfer;
	}



	/**
	 * Return the value associated with the column: hin_id
	 */
	public jkt.hms.masters.business.Patient getHin () {
		return hin;
	}

	/**
	 * Set the value related to the column: hin_id
	 * @param hin the hin_id value
	 */
	public void setHin (jkt.hms.masters.business.Patient hin) {
		this.hin = hin;
	}



	/**
	 * Return the value associated with the column: charge_slip_main_id
	 */
	public jkt.hms.masters.business.BlChargeSlipMain getChargeSlipMain () {
		return chargeSlipMain;
	}

	/**
	 * Set the value related to the column: charge_slip_main_id
	 * @param chargeSlipMain the charge_slip_main_id value
	 */
	public void setChargeSlipMain (jkt.hms.masters.business.BlChargeSlipMain chargeSlipMain) {
		this.chargeSlipMain = chargeSlipMain;
	}



	/**
	 * Return the value associated with the column: BlReceiptDetails
	 */
	public java.util.Set<jkt.hms.masters.business.BlReceiptDetails> getBlReceiptDetails () {
		return blReceiptDetails;
	}

	/**
	 * Set the value related to the column: BlReceiptDetails
	 * @param blReceiptDetails the BlReceiptDetails value
	 */
	public void setBlReceiptDetails (java.util.Set<jkt.hms.masters.business.BlReceiptDetails> blReceiptDetails) {
		this.blReceiptDetails = blReceiptDetails;
	}

	public void addToBlReceiptDetails (jkt.hms.masters.business.BlReceiptDetails blReceiptDetails) {
		if (null == getBlReceiptDetails()) setBlReceiptDetails(new java.util.TreeSet<jkt.hms.masters.business.BlReceiptDetails>());
		getBlReceiptDetails().add(blReceiptDetails);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.BlReceiptHeader)) return false;
		else {
			jkt.hms.masters.business.BlReceiptHeader blReceiptHeader = (jkt.hms.masters.business.BlReceiptHeader) obj;
			if (null == this.getId() || null == blReceiptHeader.getId()) return false;
			else return (this.getId().equals(blReceiptHeader.getId()));
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
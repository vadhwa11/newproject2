package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ame_lmc_header table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ame_lmc_header"
 */

public abstract class BaseAmeLmcHeader  implements Serializable {

	public static String REF = "AmeLmcHeader";
	public static String PROP_STATUS = "Status";
	public static String PROP_FWD_LETTER_DATE = "FwdLetterDate";
	public static String PROP_AME = "Ame";
	public static String PROP_RECEIPT_LETTER_DATE = "ReceiptLetterDate";
	public static String PROP_FWD_LETTER_NO = "FwdLetterNo";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_ID = "Id";
	public static String PROP_RECEIPT_LETTER_NO = "ReceiptLetterNo";


	// constructors
	public BaseAmeLmcHeader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAmeLmcHeader (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date fwdLetterDate;
	private java.lang.String fwdLetterNo;
	private java.util.Date receiptLetterDate;
	private java.lang.String receiptLetterNo;
	private java.lang.String remarks;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.AnnualMediacalExamination ame;



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
	 * Return the value associated with the column: fwd_letter_date
	 */
	public java.util.Date getFwdLetterDate () {
		return fwdLetterDate;
	}

	/**
	 * Set the value related to the column: fwd_letter_date
	 * @param fwdLetterDate the fwd_letter_date value
	 */
	public void setFwdLetterDate (java.util.Date fwdLetterDate) {
		this.fwdLetterDate = fwdLetterDate;
	}



	/**
	 * Return the value associated with the column: fwd_letter_no
	 */
	public java.lang.String getFwdLetterNo () {
		return fwdLetterNo;
	}

	/**
	 * Set the value related to the column: fwd_letter_no
	 * @param fwdLetterNo the fwd_letter_no value
	 */
	public void setFwdLetterNo (java.lang.String fwdLetterNo) {
		this.fwdLetterNo = fwdLetterNo;
	}



	/**
	 * Return the value associated with the column: receipt_letter_date
	 */
	public java.util.Date getReceiptLetterDate () {
		return receiptLetterDate;
	}

	/**
	 * Set the value related to the column: receipt_letter_date
	 * @param receiptLetterDate the receipt_letter_date value
	 */
	public void setReceiptLetterDate (java.util.Date receiptLetterDate) {
		this.receiptLetterDate = receiptLetterDate;
	}



	/**
	 * Return the value associated with the column: receipt_letter_no
	 */
	public java.lang.String getReceiptLetterNo () {
		return receiptLetterNo;
	}

	/**
	 * Set the value related to the column: receipt_letter_no
	 * @param receiptLetterNo the receipt_letter_no value
	 */
	public void setReceiptLetterNo (java.lang.String receiptLetterNo) {
		this.receiptLetterNo = receiptLetterNo;
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
	 * Return the value associated with the column: ame_id
	 */
	public jkt.hms.masters.business.AnnualMediacalExamination getAme () {
		return ame;
	}

	/**
	 * Set the value related to the column: ame_id
	 * @param ame the ame_id value
	 */
	public void setAme (jkt.hms.masters.business.AnnualMediacalExamination ame) {
		this.ame = ame;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.AmeLmcHeader)) return false;
		else {
			jkt.hms.masters.business.AmeLmcHeader ameLmcHeader = (jkt.hms.masters.business.AmeLmcHeader) obj;
			if (null == this.getId() || null == ameLmcHeader.getId()) return false;
			else return (this.getId().equals(ameLmcHeader.getId()));
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
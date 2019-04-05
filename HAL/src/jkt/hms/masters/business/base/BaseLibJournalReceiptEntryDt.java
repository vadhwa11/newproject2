package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * lib_journal_receipt_entry_dt table. Do not modify this class because it will
 * be overwritten if the configuration file related to this class is modified.
 * 
 * @hibernate.class table="lib_journal_receipt_entry_dt"
 */

public abstract class BaseLibJournalReceiptEntryDt implements Serializable {

	public static String REF = "LibJournalReceiptEntryDt";
	public static String PROP_STATUS_DT = "StatusDt";
	public static String PROP_SUBJECT = "Subject";
	public static String PROP_SR_NO = "SrNo";
	public static String PROP_ID = "Id";
	public static String PROP_RECEIPT = "Receipt";
	public static String PROP_BOOK = "Book";
	public static String PROP_QUANTITY = "Quantity";

	// constructors
	public BaseLibJournalReceiptEntryDt() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseLibJournalReceiptEntryDt(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer srNo;
	private java.lang.String subject;
	private java.lang.Integer quantity;
	private java.lang.String statusDt;

	// many to one
	private jkt.hms.masters.business.MasBook book;
	private jkt.hms.masters.business.LibJournalReceiptEntryHd receipt;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="receipt_dt_id"
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
	 * Return the value associated with the column: sr_no
	 */
	public java.lang.Integer getSrNo() {
		return srNo;
	}

	/**
	 * Set the value related to the column: sr_no
	 * 
	 * @param srNo
	 *            the sr_no value
	 */
	public void setSrNo(java.lang.Integer srNo) {
		this.srNo = srNo;
	}

	/**
	 * Return the value associated with the column: subject
	 */
	public java.lang.String getSubject() {
		return subject;
	}

	/**
	 * Set the value related to the column: subject
	 * 
	 * @param subject
	 *            the subject value
	 */
	public void setSubject(java.lang.String subject) {
		this.subject = subject;
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
	 * Return the value associated with the column: status_dt
	 */
	public java.lang.String getStatusDt() {
		return statusDt;
	}

	/**
	 * Set the value related to the column: status_dt
	 * 
	 * @param statusDt
	 *            the status_dt value
	 */
	public void setStatusDt(java.lang.String statusDt) {
		this.statusDt = statusDt;
	}

	/**
	 * Return the value associated with the column: book_id
	 */
	public jkt.hms.masters.business.MasBook getBook() {
		return book;
	}

	/**
	 * Set the value related to the column: book_id
	 * 
	 * @param book
	 *            the book_id value
	 */
	public void setBook(jkt.hms.masters.business.MasBook book) {
		this.book = book;
	}

	/**
	 * Return the value associated with the column: receipt_id
	 */
	public jkt.hms.masters.business.LibJournalReceiptEntryHd getReceipt() {
		return receipt;
	}

	/**
	 * Set the value related to the column: receipt_id
	 * 
	 * @param receipt
	 *            the receipt_id value
	 */
	public void setReceipt(
			jkt.hms.masters.business.LibJournalReceiptEntryHd receipt) {
		this.receipt = receipt;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.LibJournalReceiptEntryDt))
			return false;
		else {
			jkt.hms.masters.business.LibJournalReceiptEntryDt libJournalReceiptEntryDt = (jkt.hms.masters.business.LibJournalReceiptEntryDt) obj;
			if (null == this.getId()
					|| null == libJournalReceiptEntryDt.getId())
				return false;
			else
				return (this.getId().equals(libJournalReceiptEntryDt.getId()));
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
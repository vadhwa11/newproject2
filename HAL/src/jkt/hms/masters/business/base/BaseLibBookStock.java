package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the lib_book_stock table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="lib_book_stock"
 */

public abstract class BaseLibBookStock implements Serializable {

	public static String REF = "LibBookStock";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_OPEN_BALANCE_DATE = "OpenBalanceDate";
	public static String PROP_COST = "Cost";
	public static String PROP_RECEIPT_QTY = "ReceiptQty";
	public static String PROP_OPEN_BALANCE_QTY = "OpenBalanceQty";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ADJUST_QTY = "AdjustQty";
	public static String PROP_BOOK = "Book";
	public static String PROP_ISSUE_QTY = "IssueQty";
	public static String PROP_CLOSING_STOCK_QTY = "ClosingStockQty";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_RETURN_QTY = "ReturnQty";
	public static String PROP_ID = "Id";

	// constructors
	public BaseLibBookStock() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseLibBookStock(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date openBalanceDate;
	private java.lang.Integer openBalanceQty;
	private java.lang.Integer receiptQty;
	private java.lang.Integer issueQty;
	private java.lang.Integer returnQty;
	private java.lang.Integer adjustQty;
	private java.lang.Integer closingStockQty;
	private java.math.BigDecimal cost;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasBook book;

	// collections
	private java.util.Set<jkt.hms.masters.business.LibBookStockTakingDt> libBookStockTakingDts;

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
	 * Return the value associated with the column: open_balance_date
	 */
	public java.util.Date getOpenBalanceDate() {
		return openBalanceDate;
	}

	/**
	 * Set the value related to the column: open_balance_date
	 * 
	 * @param openBalanceDate
	 *            the open_balance_date value
	 */
	public void setOpenBalanceDate(java.util.Date openBalanceDate) {
		this.openBalanceDate = openBalanceDate;
	}

	/**
	 * Return the value associated with the column: open_balance_qty
	 */
	public java.lang.Integer getOpenBalanceQty() {
		return openBalanceQty;
	}

	/**
	 * Set the value related to the column: open_balance_qty
	 * 
	 * @param openBalanceQty
	 *            the open_balance_qty value
	 */
	public void setOpenBalanceQty(java.lang.Integer openBalanceQty) {
		this.openBalanceQty = openBalanceQty;
	}

	/**
	 * Return the value associated with the column: receipt_qty
	 */
	public java.lang.Integer getReceiptQty() {
		return receiptQty;
	}

	/**
	 * Set the value related to the column: receipt_qty
	 * 
	 * @param receiptQty
	 *            the receipt_qty value
	 */
	public void setReceiptQty(java.lang.Integer receiptQty) {
		this.receiptQty = receiptQty;
	}

	/**
	 * Return the value associated with the column: issue_qty
	 */
	public java.lang.Integer getIssueQty() {
		return issueQty;
	}

	/**
	 * Set the value related to the column: issue_qty
	 * 
	 * @param issueQty
	 *            the issue_qty value
	 */
	public void setIssueQty(java.lang.Integer issueQty) {
		this.issueQty = issueQty;
	}

	/**
	 * Return the value associated with the column: return_qty
	 */
	public java.lang.Integer getReturnQty() {
		return returnQty;
	}

	/**
	 * Set the value related to the column: return_qty
	 * 
	 * @param returnQty
	 *            the return_qty value
	 */
	public void setReturnQty(java.lang.Integer returnQty) {
		this.returnQty = returnQty;
	}

	/**
	 * Return the value associated with the column: adjust_qty
	 */
	public java.lang.Integer getAdjustQty() {
		return adjustQty;
	}

	/**
	 * Set the value related to the column: adjust_qty
	 * 
	 * @param adjustQty
	 *            the adjust_qty value
	 */
	public void setAdjustQty(java.lang.Integer adjustQty) {
		this.adjustQty = adjustQty;
	}

	/**
	 * Return the value associated with the column: closing_stock_qty
	 */
	public java.lang.Integer getClosingStockQty() {
		return closingStockQty;
	}

	/**
	 * Set the value related to the column: closing_stock_qty
	 * 
	 * @param closingStockQty
	 *            the closing_stock_qty value
	 */
	public void setClosingStockQty(java.lang.Integer closingStockQty) {
		this.closingStockQty = closingStockQty;
	}

	/**
	 * Return the value associated with the column: cost
	 */
	public java.math.BigDecimal getCost() {
		return cost;
	}

	/**
	 * Set the value related to the column: cost
	 * 
	 * @param cost
	 *            the cost value
	 */
	public void setCost(java.math.BigDecimal cost) {
		this.cost = cost;
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
	 * Return the value associated with the column: LibBookStockTakingDts
	 */
	public java.util.Set<jkt.hms.masters.business.LibBookStockTakingDt> getLibBookStockTakingDts() {
		return libBookStockTakingDts;
	}

	/**
	 * Set the value related to the column: LibBookStockTakingDts
	 * 
	 * @param libBookStockTakingDts
	 *            the LibBookStockTakingDts value
	 */
	public void setLibBookStockTakingDts(
			java.util.Set<jkt.hms.masters.business.LibBookStockTakingDt> libBookStockTakingDts) {
		this.libBookStockTakingDts = libBookStockTakingDts;
	}

	public void addToLibBookStockTakingDts(
			jkt.hms.masters.business.LibBookStockTakingDt libBookStockTakingDt) {
		if (null == getLibBookStockTakingDts())
			setLibBookStockTakingDts(new java.util.TreeSet<jkt.hms.masters.business.LibBookStockTakingDt>());
		getLibBookStockTakingDts().add(libBookStockTakingDt);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.LibBookStock))
			return false;
		else {
			jkt.hms.masters.business.LibBookStock libBookStock = (jkt.hms.masters.business.LibBookStock) obj;
			if (null == this.getId() || null == libBookStock.getId())
				return false;
			else
				return (this.getId().equals(libBookStock.getId()));
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
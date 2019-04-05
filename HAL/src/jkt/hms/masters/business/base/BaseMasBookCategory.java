package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_book_category table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="mas_book_category"
 */

public abstract class BaseMasBookCategory implements Serializable {

	public static String REF = "MasBookCategory";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_BOOK_CATEGORY_CODE = "BookCategoryCode";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_BOOK_CATEGORY_NAME = "BookCategoryName";
	public static String PROP_ID = "Id";

	// constructors
	public BaseMasBookCategory() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasBookCategory(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String bookCategoryCode;
	private java.lang.String bookCategoryName;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// collections
	private java.util.Set<jkt.hms.masters.business.MasBookClass> masBookClasss;
	private java.util.Set<jkt.hms.masters.business.MasBook> masBooks;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="book_category_id"
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
	 * Return the value associated with the column: book_category_code
	 */
	public java.lang.String getBookCategoryCode() {
		return bookCategoryCode;
	}

	/**
	 * Set the value related to the column: book_category_code
	 * 
	 * @param bookCategoryCode
	 *            the book_category_code value
	 */
	public void setBookCategoryCode(java.lang.String bookCategoryCode) {
		this.bookCategoryCode = bookCategoryCode;
	}

	/**
	 * Return the value associated with the column: book_category_name
	 */
	public java.lang.String getBookCategoryName() {
		return bookCategoryName;
	}

	/**
	 * Set the value related to the column: book_category_name
	 * 
	 * @param bookCategoryName
	 *            the book_category_name value
	 */
	public void setBookCategoryName(java.lang.String bookCategoryName) {
		this.bookCategoryName = bookCategoryName;
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
	 * Return the value associated with the column: MasBookClasss
	 */
	public java.util.Set<jkt.hms.masters.business.MasBookClass> getMasBookClasss() {
		return masBookClasss;
	}

	/**
	 * Set the value related to the column: MasBookClasss
	 * 
	 * @param masBookClasss
	 *            the MasBookClasss value
	 */
	public void setMasBookClasss(
			java.util.Set<jkt.hms.masters.business.MasBookClass> masBookClasss) {
		this.masBookClasss = masBookClasss;
	}

	public void addToMasBookClasss(
			jkt.hms.masters.business.MasBookClass masBookClass) {
		if (null == getMasBookClasss())
			setMasBookClasss(new java.util.TreeSet<jkt.hms.masters.business.MasBookClass>());
		getMasBookClasss().add(masBookClass);
	}

	/**
	 * Return the value associated with the column: MasBooks
	 */
	public java.util.Set<jkt.hms.masters.business.MasBook> getMasBooks() {
		return masBooks;
	}

	/**
	 * Set the value related to the column: MasBooks
	 * 
	 * @param masBooks
	 *            the MasBooks value
	 */
	public void setMasBooks(
			java.util.Set<jkt.hms.masters.business.MasBook> masBooks) {
		this.masBooks = masBooks;
	}

	public void addToMasBooks(jkt.hms.masters.business.MasBook masBook) {
		if (null == getMasBooks())
			setMasBooks(new java.util.TreeSet<jkt.hms.masters.business.MasBook>());
		getMasBooks().add(masBook);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MasBookCategory))
			return false;
		else {
			jkt.hms.masters.business.MasBookCategory masBookCategory = (jkt.hms.masters.business.MasBookCategory) obj;
			if (null == this.getId() || null == masBookCategory.getId())
				return false;
			else
				return (this.getId().equals(masBookCategory.getId()));
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
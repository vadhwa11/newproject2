package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_book_sub_class table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="mas_book_sub_class"
 */

public abstract class BaseMasBookSubClass implements Serializable {

	public static String REF = "MasBookSubClass";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_SUB_CLASS_CODE = "SubClassCode";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_SUB_CLASS_NAME = "SubClassName";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_BOOK_CLASS = "BookClass";
	public static String PROP_ID = "Id";

	// constructors
	public BaseMasBookSubClass() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasBookSubClass(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String subClassCode;
	private java.lang.String subClassName;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasBookClass bookClass;

	// collections
	private java.util.Set<jkt.hms.masters.business.MasBook> masBooks;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="book_sub_class_id"
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
	 * Return the value associated with the column: sub_class_code
	 */
	public java.lang.String getSubClassCode() {
		return subClassCode;
	}

	/**
	 * Set the value related to the column: sub_class_code
	 * 
	 * @param subClassCode
	 *            the sub_class_code value
	 */
	public void setSubClassCode(java.lang.String subClassCode) {
		this.subClassCode = subClassCode;
	}

	/**
	 * Return the value associated with the column: sub_class_name
	 */
	public java.lang.String getSubClassName() {
		return subClassName;
	}

	/**
	 * Set the value related to the column: sub_class_name
	 * 
	 * @param subClassName
	 *            the sub_class_name value
	 */
	public void setSubClassName(java.lang.String subClassName) {
		this.subClassName = subClassName;
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
	 * Return the value associated with the column: book_class_id
	 */
	public jkt.hms.masters.business.MasBookClass getBookClass() {
		return bookClass;
	}

	/**
	 * Set the value related to the column: book_class_id
	 * 
	 * @param bookClass
	 *            the book_class_id value
	 */
	public void setBookClass(jkt.hms.masters.business.MasBookClass bookClass) {
		this.bookClass = bookClass;
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
		if (!(obj instanceof jkt.hms.masters.business.MasBookSubClass))
			return false;
		else {
			jkt.hms.masters.business.MasBookSubClass masBookSubClass = (jkt.hms.masters.business.MasBookSubClass) obj;
			if (null == this.getId() || null == masBookSubClass.getId())
				return false;
			else
				return (this.getId().equals(masBookSubClass.getId()));
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
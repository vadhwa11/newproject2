package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_book_class table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="mas_book_class"
 */

public abstract class BaseMasBookClass implements Serializable {

	public static String REF = "MasBookClass";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_CLASS_NAME = "ClassName";
	public static String PROP_ID = "Id";
	public static String PROP_BOOK_CATEGORY = "BookCategory";
	public static String PROP_CLASS_CODE = "ClassCode";

	// constructors
	public BaseMasBookClass() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasBookClass(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String classCode;
	private java.lang.String className;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasBookCategory bookCategory;

	// collections
	private java.util.Set<jkt.hms.masters.business.MasBookSubClass> masBookSubClasss;
	private java.util.Set<jkt.hms.masters.business.MasBook> masBooks;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="book_class_id"
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
	 * Return the value associated with the column: class_code
	 */
	public java.lang.String getClassCode() {
		return classCode;
	}

	/**
	 * Set the value related to the column: class_code
	 * 
	 * @param classCode
	 *            the class_code value
	 */
	public void setClassCode(java.lang.String classCode) {
		this.classCode = classCode;
	}

	/**
	 * Return the value associated with the column: class_name
	 */
	public java.lang.String getClassName() {
		return className;
	}

	/**
	 * Set the value related to the column: class_name
	 * 
	 * @param className
	 *            the class_name value
	 */
	public void setClassName(java.lang.String className) {
		this.className = className;
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
	 * Return the value associated with the column: book_category_id
	 */
	public jkt.hms.masters.business.MasBookCategory getBookCategory() {
		return bookCategory;
	}

	/**
	 * Set the value related to the column: book_category_id
	 * 
	 * @param bookCategory
	 *            the book_category_id value
	 */
	public void setBookCategory(
			jkt.hms.masters.business.MasBookCategory bookCategory) {
		this.bookCategory = bookCategory;
	}

	/**
	 * Return the value associated with the column: MasBookSubClasss
	 */
	public java.util.Set<jkt.hms.masters.business.MasBookSubClass> getMasBookSubClasss() {
		return masBookSubClasss;
	}

	/**
	 * Set the value related to the column: MasBookSubClasss
	 * 
	 * @param masBookSubClasss
	 *            the MasBookSubClasss value
	 */
	public void setMasBookSubClasss(
			java.util.Set<jkt.hms.masters.business.MasBookSubClass> masBookSubClasss) {
		this.masBookSubClasss = masBookSubClasss;
	}

	public void addToMasBookSubClasss(
			jkt.hms.masters.business.MasBookSubClass masBookSubClass) {
		if (null == getMasBookSubClasss())
			setMasBookSubClasss(new java.util.TreeSet<jkt.hms.masters.business.MasBookSubClass>());
		getMasBookSubClasss().add(masBookSubClass);
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
		if (!(obj instanceof jkt.hms.masters.business.MasBookClass))
			return false;
		else {
			jkt.hms.masters.business.MasBookClass masBookClass = (jkt.hms.masters.business.MasBookClass) obj;
			if (null == this.getId() || null == masBookClass.getId())
				return false;
			else
				return (this.getId().equals(masBookClass.getId()));
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
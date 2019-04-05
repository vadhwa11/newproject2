package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_book table. Do not
 * modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * 
 * @hibernate.class table="mas_book"
 */

public abstract class BaseMasBook implements Serializable {

	public static String REF = "MasBook";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_PUBLISHER = "Publisher";
	public static String PROP_BOOK_NO = "BookNo";
	public static String PROP_YEAR_PUBLICATION = "YearPublication";
	public static String PROP_BOOK_SUB_CLASS = "BookSubClass";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_TYPES = "Types";
	public static String PROP_BOOK_CATEGORY = "BookCategory";
	public static String PROP_EDITION = "Edition";
	public static String PROP_PRICE = "Price";
	public static String PROP_AUTHOR_NAME = "AuthorName";
	public static String PROP_PAGES = "Pages";
	public static String PROP_VOLUME = "Volume";
	public static String PROP_BOOK_CLASS = "BookClass";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_ID = "Id";
	public static String PROP_PURCHASE_DATE = "PurchaseDate";
	public static String PROP_LOCATION = "Location";
	public static String PROP_BOOK_NAME = "BookName";

	// constructors
	public BaseMasBook() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasBook(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String bookNo;
	private java.lang.String bookName;
	private java.lang.String authorName;
	private java.lang.String yearPublication;
	private java.util.Date purchaseDate;
	private java.lang.String types;
	private java.lang.String edition;
	private java.lang.String location;
	private java.lang.String volume;
	private java.lang.String pages;
	private java.math.BigDecimal price;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasPublisher publisher;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasBookSubClass bookSubClass;
	private jkt.hms.masters.business.MasBookClass bookClass;
	private jkt.hms.masters.business.MasBookCategory bookCategory;

	// collections
	private java.util.Set<jkt.hms.masters.business.MlSupplyorderDetail> mlSupplyorderDetails;
	private java.util.Set<jkt.hms.masters.business.LibCrvDt> libCrvDts;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="book_id"
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
	 * Return the value associated with the column: book_no
	 */
	public java.lang.String getBookNo() {
		return bookNo;
	}

	/**
	 * Set the value related to the column: book_no
	 * 
	 * @param bookNo
	 *            the book_no value
	 */
	public void setBookNo(java.lang.String bookNo) {
		this.bookNo = bookNo;
	}

	/**
	 * Return the value associated with the column: book_name
	 */
	public java.lang.String getBookName() {
		return bookName;
	}

	/**
	 * Set the value related to the column: book_name
	 * 
	 * @param bookName
	 *            the book_name value
	 */
	public void setBookName(java.lang.String bookName) {
		this.bookName = bookName;
	}

	/**
	 * Return the value associated with the column: author_name
	 */
	public java.lang.String getAuthorName() {
		return authorName;
	}

	/**
	 * Set the value related to the column: author_name
	 * 
	 * @param authorName
	 *            the author_name value
	 */
	public void setAuthorName(java.lang.String authorName) {
		this.authorName = authorName;
	}

	/**
	 * Return the value associated with the column: year_publication
	 */
	public java.lang.String getYearPublication() {
		return yearPublication;
	}

	/**
	 * Set the value related to the column: year_publication
	 * 
	 * @param yearPublication
	 *            the year_publication value
	 */
	public void setYearPublication(java.lang.String yearPublication) {
		this.yearPublication = yearPublication;
	}

	/**
	 * Return the value associated with the column: purchase_date
	 */
	public java.util.Date getPurchaseDate() {
		return purchaseDate;
	}

	/**
	 * Set the value related to the column: purchase_date
	 * 
	 * @param purchaseDate
	 *            the purchase_date value
	 */
	public void setPurchaseDate(java.util.Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	/**
	 * Return the value associated with the column: types
	 */
	public java.lang.String getTypes() {
		return types;
	}

	/**
	 * Set the value related to the column: types
	 * 
	 * @param types
	 *            the types value
	 */
	public void setTypes(java.lang.String types) {
		this.types = types;
	}

	/**
	 * Return the value associated with the column: edition
	 */
	public java.lang.String getEdition() {
		return edition;
	}

	/**
	 * Set the value related to the column: edition
	 * 
	 * @param edition
	 *            the edition value
	 */
	public void setEdition(java.lang.String edition) {
		this.edition = edition;
	}

	/**
	 * Return the value associated with the column: location
	 */
	public java.lang.String getLocation() {
		return location;
	}

	/**
	 * Set the value related to the column: location
	 * 
	 * @param location
	 *            the location value
	 */
	public void setLocation(java.lang.String location) {
		this.location = location;
	}

	/**
	 * Return the value associated with the column: volume
	 */
	public java.lang.String getVolume() {
		return volume;
	}

	/**
	 * Set the value related to the column: volume
	 * 
	 * @param volume
	 *            the volume value
	 */
	public void setVolume(java.lang.String volume) {
		this.volume = volume;
	}

	/**
	 * Return the value associated with the column: pages
	 */
	public java.lang.String getPages() {
		return pages;
	}

	/**
	 * Set the value related to the column: pages
	 * 
	 * @param pages
	 *            the pages value
	 */
	public void setPages(java.lang.String pages) {
		this.pages = pages;
	}

	/**
	 * Return the value associated with the column: price
	 */
	public java.math.BigDecimal getPrice() {
		return price;
	}

	/**
	 * Set the value related to the column: price
	 * 
	 * @param price
	 *            the price value
	 */
	public void setPrice(java.math.BigDecimal price) {
		this.price = price;
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
	 * Return the value associated with the column: publisher_id
	 */
	public jkt.hms.masters.business.MasPublisher getPublisher() {
		return publisher;
	}

	/**
	 * Set the value related to the column: publisher_id
	 * 
	 * @param publisher
	 *            the publisher_id value
	 */
	public void setPublisher(jkt.hms.masters.business.MasPublisher publisher) {
		this.publisher = publisher;
	}

	/**
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment() {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * 
	 * @param department
	 *            the department_id value
	 */
	public void setDepartment(jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}

	/**
	 * Return the value associated with the column: book_sub_class_id
	 */
	public jkt.hms.masters.business.MasBookSubClass getBookSubClass() {
		return bookSubClass;
	}

	/**
	 * Set the value related to the column: book_sub_class_id
	 * 
	 * @param bookSubClass
	 *            the book_sub_class_id value
	 */
	public void setBookSubClass(
			jkt.hms.masters.business.MasBookSubClass bookSubClass) {
		this.bookSubClass = bookSubClass;
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
	 * Return the value associated with the column: MlSupplyorderDetails
	 */
	public java.util.Set<jkt.hms.masters.business.MlSupplyorderDetail> getMlSupplyorderDetails() {
		return mlSupplyorderDetails;
	}

	/**
	 * Set the value related to the column: MlSupplyorderDetails
	 * 
	 * @param mlSupplyorderDetails
	 *            the MlSupplyorderDetails value
	 */
	public void setMlSupplyorderDetails(
			java.util.Set<jkt.hms.masters.business.MlSupplyorderDetail> mlSupplyorderDetails) {
		this.mlSupplyorderDetails = mlSupplyorderDetails;
	}

	public void addToMlSupplyorderDetails(
			jkt.hms.masters.business.MlSupplyorderDetail mlSupplyorderDetail) {
		if (null == getMlSupplyorderDetails())
			setMlSupplyorderDetails(new java.util.TreeSet<jkt.hms.masters.business.MlSupplyorderDetail>());
		getMlSupplyorderDetails().add(mlSupplyorderDetail);
	}

	/**
	 * Return the value associated with the column: LibCrvDts
	 */
	public java.util.Set<jkt.hms.masters.business.LibCrvDt> getLibCrvDts() {
		return libCrvDts;
	}

	/**
	 * Set the value related to the column: LibCrvDts
	 * 
	 * @param libCrvDts
	 *            the LibCrvDts value
	 */
	public void setLibCrvDts(
			java.util.Set<jkt.hms.masters.business.LibCrvDt> libCrvDts) {
		this.libCrvDts = libCrvDts;
	}

	public void addToLibCrvDts(jkt.hms.masters.business.LibCrvDt libCrvDt) {
		if (null == getLibCrvDts())
			setLibCrvDts(new java.util.TreeSet<jkt.hms.masters.business.LibCrvDt>());
		getLibCrvDts().add(libCrvDt);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MasBook))
			return false;
		else {
			jkt.hms.masters.business.MasBook masBook = (jkt.hms.masters.business.MasBook) obj;
			if (null == this.getId() || null == masBook.getId())
				return false;
			else
				return (this.getId().equals(masBook.getId()));
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
package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the ml_supplyorder_detail
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="ml_supplyorder_detail"
 */

public abstract class BaseMlSupplyorderDetail implements Serializable {

	public static String REF = "MlSupplyorderDetail";
	public static String PROP_EDITION = "Edition";
	public static String PROP_PUBLISHER = "Publisher";
	public static String PROP_COST = "Cost";
	public static String PROP_AUTHOR = "Author";
	public static String PROP_SUPPLY_HEADER = "SupplyHeader";
	public static String PROP_PUBLICATION_YEAR = "PublicationYear";
	public static String PROP_SERIAL_NO = "SerialNo";
	public static String PROP_ID = "Id";
	public static String PROP_BOOK = "Book";

	// constructors
	public BaseMlSupplyorderDetail() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMlSupplyorderDetail(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer serialNo;
	private java.lang.String author;
	private java.lang.String publicationYear;
	private java.math.BigDecimal cost;
	private java.lang.String edition;

	// many to one
	private jkt.hms.masters.business.MasPublisher publisher;
	private jkt.hms.masters.business.MlSupplyorderHeader supplyHeader;
	private jkt.hms.masters.business.MasBook book;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="supply_detail_id"
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
	 * Return the value associated with the column: serial_no
	 */
	public java.lang.Integer getSerialNo() {
		return serialNo;
	}

	/**
	 * Set the value related to the column: serial_no
	 * 
	 * @param serialNo
	 *            the serial_no value
	 */
	public void setSerialNo(java.lang.Integer serialNo) {
		this.serialNo = serialNo;
	}

	/**
	 * Return the value associated with the column: author
	 */
	public java.lang.String getAuthor() {
		return author;
	}

	/**
	 * Set the value related to the column: author
	 * 
	 * @param author
	 *            the author value
	 */
	public void setAuthor(java.lang.String author) {
		this.author = author;
	}

	/**
	 * Return the value associated with the column: publication_year
	 */
	public java.lang.String getPublicationYear() {
		return publicationYear;
	}

	/**
	 * Set the value related to the column: publication_year
	 * 
	 * @param publicationYear
	 *            the publication_year value
	 */
	public void setPublicationYear(java.lang.String publicationYear) {
		this.publicationYear = publicationYear;
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
	 * Return the value associated with the column: supply_header_id
	 */
	public jkt.hms.masters.business.MlSupplyorderHeader getSupplyHeader() {
		return supplyHeader;
	}

	/**
	 * Set the value related to the column: supply_header_id
	 * 
	 * @param supplyHeader
	 *            the supply_header_id value
	 */
	public void setSupplyHeader(
			jkt.hms.masters.business.MlSupplyorderHeader supplyHeader) {
		this.supplyHeader = supplyHeader;
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

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MlSupplyorderDetail))
			return false;
		else {
			jkt.hms.masters.business.MlSupplyorderDetail mlSupplyorderDetail = (jkt.hms.masters.business.MlSupplyorderDetail) obj;
			if (null == this.getId() || null == mlSupplyorderDetail.getId())
				return false;
			else
				return (this.getId().equals(mlSupplyorderDetail.getId()));
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
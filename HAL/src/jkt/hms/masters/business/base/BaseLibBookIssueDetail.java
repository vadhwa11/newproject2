package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the lib_book_issue_detail
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="lib_book_issue_detail"
 */

public abstract class BaseLibBookIssueDetail implements Serializable {

	public static String REF = "LibBookIssueDetail";
	public static String PROP_STATUS = "Status";
	public static String PROP_ISSUE_HD = "IssueHd";
	public static String PROP_ID = "Id";
	public static String PROP_BOOK = "Book";
	public static String PROP_QUANTITY = "Quantity";

	// constructors
	public BaseLibBookIssueDetail() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseLibBookIssueDetail(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer quantity;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.LibBookIssueHeader issueHd;
	private jkt.hms.masters.business.MasBook book;

	// collections
	private java.util.Set<jkt.hms.masters.business.LibBookReturnDt> libBookReturnDts;

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
	 * Return the value associated with the column: issue_hd_id
	 */
	public jkt.hms.masters.business.LibBookIssueHeader getIssueHd() {
		return issueHd;
	}

	/**
	 * Set the value related to the column: issue_hd_id
	 * 
	 * @param issueHd
	 *            the issue_hd_id value
	 */
	public void setIssueHd(jkt.hms.masters.business.LibBookIssueHeader issueHd) {
		this.issueHd = issueHd;
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
	 * Return the value associated with the column: LibBookReturnDts
	 */
	public java.util.Set<jkt.hms.masters.business.LibBookReturnDt> getLibBookReturnDts() {
		return libBookReturnDts;
	}

	/**
	 * Set the value related to the column: LibBookReturnDts
	 * 
	 * @param libBookReturnDts
	 *            the LibBookReturnDts value
	 */
	public void setLibBookReturnDts(
			java.util.Set<jkt.hms.masters.business.LibBookReturnDt> libBookReturnDts) {
		this.libBookReturnDts = libBookReturnDts;
	}

	public void addToLibBookReturnDts(
			jkt.hms.masters.business.LibBookReturnDt libBookReturnDt) {
		if (null == getLibBookReturnDts())
			setLibBookReturnDts(new java.util.TreeSet<jkt.hms.masters.business.LibBookReturnDt>());
		getLibBookReturnDts().add(libBookReturnDt);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.LibBookIssueDetail))
			return false;
		else {
			jkt.hms.masters.business.LibBookIssueDetail libBookIssueDetail = (jkt.hms.masters.business.LibBookIssueDetail) obj;
			if (null == this.getId() || null == libBookIssueDetail.getId())
				return false;
			else
				return (this.getId().equals(libBookIssueDetail.getId()));
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
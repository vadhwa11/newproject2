package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the lib_book_stock_taking_dt
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="lib_book_stock_taking_dt"
 */

public abstract class BaseLibBookStockTakingDt implements Serializable {

	public static String REF = "LibBookStockTakingDt";
	public static String PROP_BOOK_SOCK = "BookSock";
	public static String PROP_SOCK_TAKING_HD = "SockTakingHd";
	public static String PROP_STRIKE_CHARGE = "StrikeCharge";
	public static String PROP_SR_NO = "SrNo";
	public static String PROP_ID = "Id";

	// constructors
	public BaseLibBookStockTakingDt() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseLibBookStockTakingDt(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String strikeCharge;
	private java.lang.Integer srNo;

	// many to one
	private jkt.hms.masters.business.LibBookStock bookSock;
	private jkt.hms.masters.business.LibBookStockTakingHd sockTakingHd;

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
	 * Return the value associated with the column: strike_charge
	 */
	public java.lang.String getStrikeCharge() {
		return strikeCharge;
	}

	/**
	 * Set the value related to the column: strike_charge
	 * 
	 * @param strikeCharge
	 *            the strike_charge value
	 */
	public void setStrikeCharge(java.lang.String strikeCharge) {
		this.strikeCharge = strikeCharge;
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
	 * Return the value associated with the column: book_sock_id
	 */
	public jkt.hms.masters.business.LibBookStock getBookSock() {
		return bookSock;
	}

	/**
	 * Set the value related to the column: book_sock_id
	 * 
	 * @param bookSock
	 *            the book_sock_id value
	 */
	public void setBookSock(jkt.hms.masters.business.LibBookStock bookSock) {
		this.bookSock = bookSock;
	}

	/**
	 * Return the value associated with the column: sock_taking_hd_id
	 */
	public jkt.hms.masters.business.LibBookStockTakingHd getSockTakingHd() {
		return sockTakingHd;
	}

	/**
	 * Set the value related to the column: sock_taking_hd_id
	 * 
	 * @param sockTakingHd
	 *            the sock_taking_hd_id value
	 */
	public void setSockTakingHd(
			jkt.hms.masters.business.LibBookStockTakingHd sockTakingHd) {
		this.sockTakingHd = sockTakingHd;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.LibBookStockTakingDt))
			return false;
		else {
			jkt.hms.masters.business.LibBookStockTakingDt libBookStockTakingDt = (jkt.hms.masters.business.LibBookStockTakingDt) obj;
			if (null == this.getId() || null == libBookStockTakingDt.getId())
				return false;
			else
				return (this.getId().equals(libBookStockTakingDt.getId()));
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
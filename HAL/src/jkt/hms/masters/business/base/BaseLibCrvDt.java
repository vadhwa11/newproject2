package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the lib_crv_dt table. Do not
 * modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * 
 * @hibernate.class table="lib_crv_dt"
 */

public abstract class BaseLibCrvDt implements Serializable {

	public static String REF = "LibCrvDt";
	public static String PROP_STATUS = "Status";
	public static String PROP_AMOUNT = "Amount";
	public static String PROP_PRICE = "Price";
	public static String PROP_PAGE_NO = "PageNo";
	public static String PROP_DISCOUNT = "Discount";
	public static String PROP_VOLUME = "Volume";
	public static String PROP_ID = "Id";
	public static String PROP_BOOK = "Book";
	public static String PROP_QUANTITY = "Quantity";
	public static String PROP_CRV_HD = "CrvHd";
	public static String PROP_TAX = "Tax";

	// constructors
	public BaseLibCrvDt() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseLibCrvDt(java.lang.Integer id) {
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
	private java.math.BigDecimal discount;
	private java.math.BigDecimal tax;
	private java.math.BigDecimal amount;
	private java.math.BigDecimal price;
	private java.lang.Integer pageNo;
	private java.math.BigDecimal volume;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasBook book;
	private jkt.hms.masters.business.LibCrvHd crvHd;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="crv_dt_id"
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
	 * Return the value associated with the column: discount
	 */
	public java.math.BigDecimal getDiscount() {
		return discount;
	}

	/**
	 * Set the value related to the column: discount
	 * 
	 * @param discount
	 *            the discount value
	 */
	public void setDiscount(java.math.BigDecimal discount) {
		this.discount = discount;
	}

	/**
	 * Return the value associated with the column: tax
	 */
	public java.math.BigDecimal getTax() {
		return tax;
	}

	/**
	 * Set the value related to the column: tax
	 * 
	 * @param tax
	 *            the tax value
	 */
	public void setTax(java.math.BigDecimal tax) {
		this.tax = tax;
	}

	/**
	 * Return the value associated with the column: amount
	 */
	public java.math.BigDecimal getAmount() {
		return amount;
	}

	/**
	 * Set the value related to the column: amount
	 * 
	 * @param amount
	 *            the amount value
	 */
	public void setAmount(java.math.BigDecimal amount) {
		this.amount = amount;
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
	 * Return the value associated with the column: page_no
	 */
	public java.lang.Integer getPageNo() {
		return pageNo;
	}

	/**
	 * Set the value related to the column: page_no
	 * 
	 * @param pageNo
	 *            the page_no value
	 */
	public void setPageNo(java.lang.Integer pageNo) {
		this.pageNo = pageNo;
	}

	/**
	 * Return the value associated with the column: volume
	 */
	public java.math.BigDecimal getVolume() {
		return volume;
	}

	/**
	 * Set the value related to the column: volume
	 * 
	 * @param volume
	 *            the volume value
	 */
	public void setVolume(java.math.BigDecimal volume) {
		this.volume = volume;
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
	 * Return the value associated with the column: crv_hd_id
	 */
	public jkt.hms.masters.business.LibCrvHd getCrvHd() {
		return crvHd;
	}

	/**
	 * Set the value related to the column: crv_hd_id
	 * 
	 * @param crvHd
	 *            the crv_hd_id value
	 */
	public void setCrvHd(jkt.hms.masters.business.LibCrvHd crvHd) {
		this.crvHd = crvHd;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.LibCrvDt))
			return false;
		else {
			jkt.hms.masters.business.LibCrvDt libCrvDt = (jkt.hms.masters.business.LibCrvDt) obj;
			if (null == this.getId() || null == libCrvDt.getId())
				return false;
			else
				return (this.getId().equals(libCrvDt.getId()));
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
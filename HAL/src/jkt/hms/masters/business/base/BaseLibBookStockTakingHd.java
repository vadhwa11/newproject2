package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the lib_book_stock_taking_hd
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="lib_book_stock_taking_hd"
 */

public abstract class BaseLibBookStockTakingHd implements Serializable {

	public static String REF = "LibBookStockTakingHd";
	public static String PROP_SOCK_TAKIN_DATE = "SockTakinDate";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_STOCK_TAKING_NO = "StockTakingNo";
	public static String PROP_ID = "Id";

	// constructors
	public BaseLibBookStockTakingHd() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseLibBookStockTakingHd(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String stockTakingNo;
	private java.util.Date sockTakinDate;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;

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
	 * Return the value associated with the column: stock_taking_no
	 */
	public java.lang.String getStockTakingNo() {
		return stockTakingNo;
	}

	/**
	 * Set the value related to the column: stock_taking_no
	 * 
	 * @param stockTakingNo
	 *            the stock_taking_no value
	 */
	public void setStockTakingNo(java.lang.String stockTakingNo) {
		this.stockTakingNo = stockTakingNo;
	}

	/**
	 * Return the value associated with the column: sock_takin_date
	 */
	public java.util.Date getSockTakinDate() {
		return sockTakinDate;
	}

	/**
	 * Set the value related to the column: sock_takin_date
	 * 
	 * @param sockTakinDate
	 *            the sock_takin_date value
	 */
	public void setSockTakinDate(java.util.Date sockTakinDate) {
		this.sockTakinDate = sockTakinDate;
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
		if (!(obj instanceof jkt.hms.masters.business.LibBookStockTakingHd))
			return false;
		else {
			jkt.hms.masters.business.LibBookStockTakingHd libBookStockTakingHd = (jkt.hms.masters.business.LibBookStockTakingHd) obj;
			if (null == this.getId() || null == libBookStockTakingHd.getId())
				return false;
			else
				return (this.getId().equals(libBookStockTakingHd.getId()));
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
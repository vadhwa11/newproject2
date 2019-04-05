package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the store_supply_order_entry
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="store_supply_order_entry"
 */

public abstract class BaseStoreSupplyOrderEntry implements Serializable {

	public static String REF = "StoreSupplyOrderEntry";
	public static String PROP_CRV_DATE = "CrvDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_QTY = "Qty";
	public static String PROP_SUPPLY_ORDER_DATE = "SupplyOrderDate";
	public static String PROP_INDENT_TYPE = "IndentType";
	public static String PROP_EXPIRY_DATE = "ExpiryDate";
	public static String PROP_CRV_NO = "CrvNo";
	public static String PROP_SUPPLIER = "Supplier";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ITEM = "Item";
	public static String PROP_ENCLOSURE_NO = "EnclosureNo";
	public static String PROP_SERIAL_NO = "SerialNo";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_BATCH_NO = "BatchNo";
	public static String PROP_INDENT = "Indent";
	public static String PROP_SUPPLY_ORDER_NO = "SupplyOrderNo";
	public static String PROP_DATE_OF_RECEIPT = "DateOfReceipt";
	public static String PROP_RATE = "Rate";
	public static String PROP_MANUFACTURING_DATE = "ManufacturingDate";

	// constructors
	public BaseStoreSupplyOrderEntry() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreSupplyOrderEntry(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseStoreSupplyOrderEntry(java.lang.Integer id,
			java.lang.String indentType) {

		this.setId(id);
		this.setIndentType(indentType);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer serialNo;
	private java.math.BigDecimal qty;
	private java.lang.String supplyOrderNo;
	private java.util.Date supplyOrderDate;
	private java.math.BigDecimal rate;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String indentType;
	private java.util.Date dateOfReceipt;
	private java.lang.String batchNo;
	private java.util.Date manufacturingDate;
	private java.util.Date expiryDate;
	private java.lang.String crvNo;
	private java.util.Date crvDate;
	private java.lang.String enclosureNo;

	// many to one
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.StoreIndentM indent;
	private jkt.hms.masters.business.MasStoreSupplier supplier;
	private jkt.hms.masters.business.MasStoreItem item;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native"
	 *               column="store_supply_order_entry_id"
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
	 * Return the value associated with the column: qty
	 */
	public java.math.BigDecimal getQty() {
		return qty;
	}

	/**
	 * Set the value related to the column: qty
	 * 
	 * @param qty
	 *            the qty value
	 */
	public void setQty(java.math.BigDecimal qty) {
		this.qty = qty;
	}

	/**
	 * Return the value associated with the column: supply_order_no
	 */
	public java.lang.String getSupplyOrderNo() {
		return supplyOrderNo;
	}

	/**
	 * Set the value related to the column: supply_order_no
	 * 
	 * @param supplyOrderNo
	 *            the supply_order_no value
	 */
	public void setSupplyOrderNo(java.lang.String supplyOrderNo) {
		this.supplyOrderNo = supplyOrderNo;
	}

	/**
	 * Return the value associated with the column: supply_order_date
	 */
	public java.util.Date getSupplyOrderDate() {
		return supplyOrderDate;
	}

	/**
	 * Set the value related to the column: supply_order_date
	 * 
	 * @param supplyOrderDate
	 *            the supply_order_date value
	 */
	public void setSupplyOrderDate(java.util.Date supplyOrderDate) {
		this.supplyOrderDate = supplyOrderDate;
	}

	/**
	 * Return the value associated with the column: rate
	 */
	public java.math.BigDecimal getRate() {
		return rate;
	}

	/**
	 * Set the value related to the column: rate
	 * 
	 * @param rate
	 *            the rate value
	 */
	public void setRate(java.math.BigDecimal rate) {
		this.rate = rate;
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
	 * Return the value associated with the column: indent_type
	 */
	public java.lang.String getIndentType() {
		return indentType;
	}

	/**
	 * Set the value related to the column: indent_type
	 * 
	 * @param indentType
	 *            the indent_type value
	 */
	public void setIndentType(java.lang.String indentType) {
		this.indentType = indentType;
	}

	/**
	 * Return the value associated with the column: date_of_receipt
	 */
	public java.util.Date getDateOfReceipt() {
		return dateOfReceipt;
	}

	/**
	 * Set the value related to the column: date_of_receipt
	 * 
	 * @param dateOfReceipt
	 *            the date_of_receipt value
	 */
	public void setDateOfReceipt(java.util.Date dateOfReceipt) {
		this.dateOfReceipt = dateOfReceipt;
	}

	/**
	 * Return the value associated with the column: batch_no
	 */
	public java.lang.String getBatchNo() {
		return batchNo;
	}

	/**
	 * Set the value related to the column: batch_no
	 * 
	 * @param batchNo
	 *            the batch_no value
	 */
	public void setBatchNo(java.lang.String batchNo) {
		this.batchNo = batchNo;
	}

	/**
	 * Return the value associated with the column: manufacturing_date
	 */
	public java.util.Date getManufacturingDate() {
		return manufacturingDate;
	}

	/**
	 * Set the value related to the column: manufacturing_date
	 * 
	 * @param manufacturingDate
	 *            the manufacturing_date value
	 */
	public void setManufacturingDate(java.util.Date manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}

	/**
	 * Return the value associated with the column: expiry_date
	 */
	public java.util.Date getExpiryDate() {
		return expiryDate;
	}

	/**
	 * Set the value related to the column: expiry_date
	 * 
	 * @param expiryDate
	 *            the expiry_date value
	 */
	public void setExpiryDate(java.util.Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	/**
	 * Return the value associated with the column: crv_no
	 */
	public java.lang.String getCrvNo() {
		return crvNo;
	}

	/**
	 * Set the value related to the column: crv_no
	 * 
	 * @param crvNo
	 *            the crv_no value
	 */
	public void setCrvNo(java.lang.String crvNo) {
		this.crvNo = crvNo;
	}

	/**
	 * Return the value associated with the column: crv_date
	 */
	public java.util.Date getCrvDate() {
		return crvDate;
	}

	/**
	 * Set the value related to the column: crv_date
	 * 
	 * @param crvDate
	 *            the crv_date value
	 */
	public void setCrvDate(java.util.Date crvDate) {
		this.crvDate = crvDate;
	}

	/**
	 * Return the value associated with the column: enclosure_no
	 */
	public java.lang.String getEnclosureNo() {
		return enclosureNo;
	}

	/**
	 * Set the value related to the column: enclosure_no
	 * 
	 * @param enclosureNo
	 *            the enclosure_no value
	 */
	public void setEnclosureNo(java.lang.String enclosureNo) {
		this.enclosureNo = enclosureNo;
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
	 * Return the value associated with the column: indent_id
	 */
	public jkt.hms.masters.business.StoreIndentM getIndent() {
		return indent;
	}

	/**
	 * Set the value related to the column: indent_id
	 * 
	 * @param indent
	 *            the indent_id value
	 */
	public void setIndent(jkt.hms.masters.business.StoreIndentM indent) {
		this.indent = indent;
	}

	/**
	 * Return the value associated with the column: supplier_id
	 */
	public jkt.hms.masters.business.MasStoreSupplier getSupplier() {
		return supplier;
	}

	/**
	 * Set the value related to the column: supplier_id
	 * 
	 * @param supplier
	 *            the supplier_id value
	 */
	public void setSupplier(jkt.hms.masters.business.MasStoreSupplier supplier) {
		this.supplier = supplier;
	}

	/**
	 * Return the value associated with the column: item_id
	 */
	public jkt.hms.masters.business.MasStoreItem getItem() {
		return item;
	}

	/**
	 * Set the value related to the column: item_id
	 * 
	 * @param item
	 *            the item_id value
	 */
	public void setItem(jkt.hms.masters.business.MasStoreItem item) {
		this.item = item;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreSupplyOrderEntry))
			return false;
		else {
			jkt.hms.masters.business.StoreSupplyOrderEntry storeSupplyOrderEntry = (jkt.hms.masters.business.StoreSupplyOrderEntry) obj;
			if (null == this.getId() || null == storeSupplyOrderEntry.getId())
				return false;
			else
				return (this.getId().equals(storeSupplyOrderEntry.getId()));
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
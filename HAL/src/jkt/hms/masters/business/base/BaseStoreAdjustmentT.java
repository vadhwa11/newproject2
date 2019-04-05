package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the store_adjustment_t table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="store_adjustment_t"
 */

public abstract class BaseStoreAdjustmentT implements Serializable {

	public static String REF = "StoreAdjustmentT";
	public static String PROP_BATCH_NO = "BatchNo";
	public static String PROP_SL_NO = "SlNo";
	public static String PROP_BRAND = "Brand";
	public static String PROP_ITEM = "Item";
	public static String PROP_ADJUST = "Adjust";
	public static String PROP_EXPIRY_DATE = "ExpiryDate";
	public static String PROP_ADJUST_QTY = "AdjustQty";
	public static String PROP_ID = "Id";

	// constructors
	public BaseStoreAdjustmentT() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreAdjustmentT(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer slNo;
	private java.lang.String batchNo;
	private java.util.Date expiryDate;
	private java.math.BigDecimal adjustQty;

	// many to one
	private jkt.hms.masters.business.StoreAdjustmentM adjust;
	private jkt.hms.masters.business.MasStoreBrand brand;
	private jkt.hms.masters.business.MasStoreItem item;

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
	 * Return the value associated with the column: sl_no
	 */
	public java.lang.Integer getSlNo() {
		return slNo;
	}

	/**
	 * Set the value related to the column: sl_no
	 * 
	 * @param slNo
	 *            the sl_no value
	 */
	public void setSlNo(java.lang.Integer slNo) {
		this.slNo = slNo;
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
	 * Return the value associated with the column: adjust_qty
	 */
	public java.math.BigDecimal getAdjustQty() {
		return adjustQty;
	}

	/**
	 * Set the value related to the column: adjust_qty
	 * 
	 * @param adjustQty
	 *            the adjust_qty value
	 */
	public void setAdjustQty(java.math.BigDecimal adjustQty) {
		this.adjustQty = adjustQty;
	}

	/**
	 * Return the value associated with the column: adjust_id
	 */
	public jkt.hms.masters.business.StoreAdjustmentM getAdjust() {
		return adjust;
	}

	/**
	 * Set the value related to the column: adjust_id
	 * 
	 * @param adjust
	 *            the adjust_id value
	 */
	public void setAdjust(jkt.hms.masters.business.StoreAdjustmentM adjust) {
		this.adjust = adjust;
	}

	/**
	 * Return the value associated with the column: brand_id
	 */
	public jkt.hms.masters.business.MasStoreBrand getBrand() {
		return brand;
	}

	/**
	 * Set the value related to the column: brand_id
	 * 
	 * @param brand
	 *            the brand_id value
	 */
	public void setBrand(jkt.hms.masters.business.MasStoreBrand brand) {
		this.brand = brand;
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
		if (!(obj instanceof jkt.hms.masters.business.StoreAdjustmentT))
			return false;
		else {
			jkt.hms.masters.business.StoreAdjustmentT storeAdjustmentT = (jkt.hms.masters.business.StoreAdjustmentT) obj;
			if (null == this.getId() || null == storeAdjustmentT.getId())
				return false;
			else
				return (this.getId().equals(storeAdjustmentT.getId()));
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
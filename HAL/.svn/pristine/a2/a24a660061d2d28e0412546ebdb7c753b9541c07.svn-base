package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the store_grn_return_t table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="store_grn_return_t"
 */

public abstract class BaseStoreGrnReturnT implements Serializable {

	public static String REF = "StoreGrnReturnT";
	public static String PROP_GRN_RETURN = "GrnReturn";
	public static String PROP_BATCH_NO = "BatchNo";
	public static String PROP_UNIT_RATE = "UnitRate";
	public static String PROP_BRAND = "Brand";
	public static String PROP_ITEM = "Item";
	public static String PROP_EXPIRY_DATE = "ExpiryDate";
	public static String PROP_SR_NO = "SrNo";
	public static String PROP_RETURN_QTY = "ReturnQty";
	public static String PROP_RETURN_AMOUNT = "ReturnAmount";
	public static String PROP_ID = "Id";
	public static String PROP_TAX = "Tax";

	// constructors
	public BaseStoreGrnReturnT() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreGrnReturnT(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseStoreGrnReturnT(java.lang.Integer id,
			jkt.hms.masters.business.StoreGrnReturnM grnReturn) {

		this.setId(id);
		this.setGrnReturn(grnReturn);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Short srNo;
	private java.math.BigDecimal returnQty;
	private java.math.BigDecimal unitRate;
	private java.math.BigDecimal tax;
	private java.lang.String batchNo;
	private java.util.Date expiryDate;
	private java.math.BigDecimal returnAmount;

	// many to one
	private jkt.hms.masters.business.MasStoreBrand brand;
	private jkt.hms.masters.business.StoreGrnReturnM grnReturn;
	private jkt.hms.masters.business.MasStoreItem item;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="transaction_id"
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
	 * Return the value associated with the column: sr_no
	 */
	public java.lang.Short getSrNo() {
		return srNo;
	}

	/**
	 * Set the value related to the column: sr_no
	 * 
	 * @param srNo
	 *            the sr_no value
	 */
	public void setSrNo(java.lang.Short srNo) {
		this.srNo = srNo;
	}

	/**
	 * Return the value associated with the column: return_qty
	 */
	public java.math.BigDecimal getReturnQty() {
		return returnQty;
	}

	/**
	 * Set the value related to the column: return_qty
	 * 
	 * @param returnQty
	 *            the return_qty value
	 */
	public void setReturnQty(java.math.BigDecimal returnQty) {
		this.returnQty = returnQty;
	}

	/**
	 * Return the value associated with the column: unit_rate
	 */
	public java.math.BigDecimal getUnitRate() {
		return unitRate;
	}

	/**
	 * Set the value related to the column: unit_rate
	 * 
	 * @param unitRate
	 *            the unit_rate value
	 */
	public void setUnitRate(java.math.BigDecimal unitRate) {
		this.unitRate = unitRate;
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
	 * Return the value associated with the column: return_amount
	 */
	public java.math.BigDecimal getReturnAmount() {
		return returnAmount;
	}

	/**
	 * Set the value related to the column: return_amount
	 * 
	 * @param returnAmount
	 *            the return_amount value
	 */
	public void setReturnAmount(java.math.BigDecimal returnAmount) {
		this.returnAmount = returnAmount;
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
	 * Return the value associated with the column: grn_return_id
	 */
	public jkt.hms.masters.business.StoreGrnReturnM getGrnReturn() {
		return grnReturn;
	}

	/**
	 * Set the value related to the column: grn_return_id
	 * 
	 * @param grnReturn
	 *            the grn_return_id value
	 */
	public void setGrnReturn(jkt.hms.masters.business.StoreGrnReturnM grnReturn) {
		this.grnReturn = grnReturn;
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
		if (!(obj instanceof jkt.hms.masters.business.StoreGrnReturnT))
			return false;
		else {
			jkt.hms.masters.business.StoreGrnReturnT storeGrnReturnT = (jkt.hms.masters.business.StoreGrnReturnT) obj;
			if (null == this.getId() || null == storeGrnReturnT.getId())
				return false;
			else
				return (this.getId().equals(storeGrnReturnT.getId()));
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
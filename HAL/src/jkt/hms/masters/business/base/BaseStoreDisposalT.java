package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the store_disposal_t table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="store_disposal_t"
 */

public abstract class BaseStoreDisposalT implements Serializable {

	public static String REF = "StoreDisposalT";
	public static String PROP_QTY = "Qty";
	public static String PROP_COST = "Cost";
	public static String PROP_ITEM = "Item";
	public static String PROP_DISPOSAL_M = "DisposalM";
	public static String PROP_SR_NO = "SrNo";
	public static String PROP_SERIAL_NO = "SerialNo";
	public static String PROP_ID = "Id";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_RV_NO = "RvNo";

	// constructors
	public BaseStoreDisposalT() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreDisposalT(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseStoreDisposalT(java.lang.Integer id,
			jkt.hms.masters.business.StoreDisposalM disposalM,
			jkt.hms.masters.business.MasStoreItem item, java.lang.Integer srNo,
			java.math.BigDecimal qty, java.math.BigDecimal cost) {

		this.setId(id);
		this.setDisposalM(disposalM);
		this.setItem(item);
		this.setSrNo(srNo);
		this.setQty(qty);
		this.setCost(cost);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer srNo;
	private java.lang.String serialNo;
	private java.math.BigDecimal qty;
	private java.math.BigDecimal cost;
	private java.lang.String rvNo;
	private java.lang.String remarks;

	// many to one
	private jkt.hms.masters.business.StoreDisposalM disposalM;
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
	 * Return the value associated with the column: serial_no
	 */
	public java.lang.String getSerialNo() {
		return serialNo;
	}

	/**
	 * Set the value related to the column: serial_no
	 * 
	 * @param serialNo
	 *            the serial_no value
	 */
	public void setSerialNo(java.lang.String serialNo) {
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
	 * Return the value associated with the column: rv_no
	 */
	public java.lang.String getRvNo() {
		return rvNo;
	}

	/**
	 * Set the value related to the column: rv_no
	 * 
	 * @param rvNo
	 *            the rv_no value
	 */
	public void setRvNo(java.lang.String rvNo) {
		this.rvNo = rvNo;
	}

	/**
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks() {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * 
	 * @param remarks
	 *            the remarks value
	 */
	public void setRemarks(java.lang.String remarks) {
		this.remarks = remarks;
	}

	/**
	 * Return the value associated with the column: disposal_m_id
	 */
	public jkt.hms.masters.business.StoreDisposalM getDisposalM() {
		return disposalM;
	}

	/**
	 * Set the value related to the column: disposal_m_id
	 * 
	 * @param disposalM
	 *            the disposal_m_id value
	 */
	public void setDisposalM(jkt.hms.masters.business.StoreDisposalM disposalM) {
		this.disposalM = disposalM;
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
		if (!(obj instanceof jkt.hms.masters.business.StoreDisposalT))
			return false;
		else {
			jkt.hms.masters.business.StoreDisposalT storeDisposalT = (jkt.hms.masters.business.StoreDisposalT) obj;
			if (null == this.getId() || null == storeDisposalT.getId())
				return false;
			else
				return (this.getId().equals(storeDisposalT.getId()));
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
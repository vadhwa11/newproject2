package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the store_tender_t table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="store_tender_t"
 */

public abstract class BaseStoreTenderT implements Serializable {

	public static String REF = "StoreTenderT";
	public static String PROP_TENDER_M = "TenderM";
	public static String PROP_ITEM = "Item";
	public static String PROP_SR_NO = "SrNo";
	public static String PROP_TENDER_QTY = "TenderQty";
	public static String PROP_ID = "Id";
	public static String PROP_QTY_IN_MMF = "QtyInMmf";

	// constructors
	public BaseStoreTenderT() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreTenderT(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer srNo;
	private java.math.BigDecimal tenderQty;
	private java.math.BigDecimal qtyInMmf;

	// many to one
	private jkt.hms.masters.business.StoreTenderM tenderM;
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
	 * Return the value associated with the column: tender_qty
	 */
	public java.math.BigDecimal getTenderQty() {
		return tenderQty;
	}

	/**
	 * Set the value related to the column: tender_qty
	 * 
	 * @param tenderQty
	 *            the tender_qty value
	 */
	public void setTenderQty(java.math.BigDecimal tenderQty) {
		this.tenderQty = tenderQty;
	}

	/**
	 * Return the value associated with the column: qty_in_mmf
	 */
	public java.math.BigDecimal getQtyInMmf() {
		return qtyInMmf;
	}

	/**
	 * Set the value related to the column: qty_in_mmf
	 * 
	 * @param qtyInMmf
	 *            the qty_in_mmf value
	 */
	public void setQtyInMmf(java.math.BigDecimal qtyInMmf) {
		this.qtyInMmf = qtyInMmf;
	}

	/**
	 * Return the value associated with the column: tender_m_id
	 */
	public jkt.hms.masters.business.StoreTenderM getTenderM() {
		return tenderM;
	}

	/**
	 * Set the value related to the column: tender_m_id
	 * 
	 * @param tenderM
	 *            the tender_m_id value
	 */
	public void setTenderM(jkt.hms.masters.business.StoreTenderM tenderM) {
		this.tenderM = tenderM;
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
		if (!(obj instanceof jkt.hms.masters.business.StoreTenderT))
			return false;
		else {
			jkt.hms.masters.business.StoreTenderT storeTenderT = (jkt.hms.masters.business.StoreTenderT) obj;
			if (null == this.getId() || null == storeTenderT.getId())
				return false;
			else
				return (this.getId().equals(storeTenderT.getId()));
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
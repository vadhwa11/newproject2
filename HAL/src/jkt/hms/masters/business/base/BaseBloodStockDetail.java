package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the blood_stock_detail table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="blood_stock_detail"
 */

public abstract class BaseBloodStockDetail implements Serializable {

	public static String REF = "BloodStockDetail";
	public static String PROP_QTY = "Qty";
	public static String PROP_BLOOD_BAG_NO = "BloodBagNo";
	public static String PROP_STOCK_MAIN = "StockMain";
	public static String PROP_COMPONENT = "Component";
	public static String PROP_BLOOD_ISSUED = "BloodIssued";
	public static String PROP_ID = "Id";

	// constructors
	public BaseBloodStockDetail() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBloodStockDetail(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String bloodBagNo;
	private java.lang.Integer qty;
	private java.lang.String bloodIssued;

	// many to one
	private jkt.hms.masters.business.BloodMasComponent component;
	private jkt.hms.masters.business.BloodStockMain stockMain;

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
	 * Return the value associated with the column: blood_bag_no
	 */
	public java.lang.String getBloodBagNo() {
		return bloodBagNo;
	}

	/**
	 * Set the value related to the column: blood_bag_no
	 * 
	 * @param bloodBagNo
	 *            the blood_bag_no value
	 */
	public void setBloodBagNo(java.lang.String bloodBagNo) {
		this.bloodBagNo = bloodBagNo;
	}

	/**
	 * Return the value associated with the column: qty
	 */
	public java.lang.Integer getQty() {
		return qty;
	}

	/**
	 * Set the value related to the column: qty
	 * 
	 * @param qty
	 *            the qty value
	 */
	public void setQty(java.lang.Integer qty) {
		this.qty = qty;
	}

	/**
	 * Return the value associated with the column: blood_issued
	 */
	public java.lang.String getBloodIssued() {
		return bloodIssued;
	}

	/**
	 * Set the value related to the column: blood_issued
	 * 
	 * @param bloodIssued
	 *            the blood_issued value
	 */
	public void setBloodIssued(java.lang.String bloodIssued) {
		this.bloodIssued = bloodIssued;
	}

	/**
	 * Return the value associated with the column: component_id
	 */
	public jkt.hms.masters.business.BloodMasComponent getComponent() {
		return component;
	}

	/**
	 * Set the value related to the column: component_id
	 * 
	 * @param component
	 *            the component_id value
	 */
	public void setComponent(
			jkt.hms.masters.business.BloodMasComponent component) {
		this.component = component;
	}

	/**
	 * Return the value associated with the column: stock_main_id
	 */
	public jkt.hms.masters.business.BloodStockMain getStockMain() {
		return stockMain;
	}

	/**
	 * Set the value related to the column: stock_main_id
	 * 
	 * @param stockMain
	 *            the stock_main_id value
	 */
	public void setStockMain(jkt.hms.masters.business.BloodStockMain stockMain) {
		this.stockMain = stockMain;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.BloodStockDetail))
			return false;
		else {
			jkt.hms.masters.business.BloodStockDetail bloodStockDetail = (jkt.hms.masters.business.BloodStockDetail) obj;
			if (null == this.getId() || null == bloodStockDetail.getId())
				return false;
			else
				return (this.getId().equals(bloodStockDetail.getId()));
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
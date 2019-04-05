package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the IPD_DRUG_CONSUMPTION table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="IPD_DRUG_CONSUMPTION"
 */

public abstract class BaseIpdDrugConsumption  implements Serializable {

	public static String REF = "IpdDrugConsumption";
	public static String PROP_STOCK_QTY = "StockQty";
	public static String PROP_QTY_CONSUMED = "QtyConsumed";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_CONSUMPTION_DATE = "ConsumptionDate";
	public static String PROP_EXPIRY_DATE = "ExpiryDate";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ITEM = "Item";
	public static String PROP_BATCH_STOCK = "BatchStock";
	public static String PROP_CONSUMPTION_TIME = "ConsumptionTime";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DEPARTMENT = "Department";


	// constructors
	public BaseIpdDrugConsumption () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseIpdDrugConsumption (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date consumptionDate;
	private java.lang.String consumptionTime;
	private java.math.BigDecimal qtyConsumed;
	private java.math.BigDecimal stockQty;
	private java.util.Date expiryDate;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.StoreItemBatchStock batchStock;
	private jkt.hms.masters.business.MasStoreItem item;
	private jkt.hms.masters.business.MasDepartment department;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="ipd_drug_consumption_id"
     */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: Consumption_date
	 */
	public java.util.Date getConsumptionDate () {
		return consumptionDate;
	}

	/**
	 * Set the value related to the column: Consumption_date
	 * @param consumptionDate the Consumption_date value
	 */
	public void setConsumptionDate (java.util.Date consumptionDate) {
		this.consumptionDate = consumptionDate;
	}



	/**
	 * Return the value associated with the column: consumption_time
	 */
	public java.lang.String getConsumptionTime () {
		return consumptionTime;
	}

	/**
	 * Set the value related to the column: consumption_time
	 * @param consumptionTime the consumption_time value
	 */
	public void setConsumptionTime (java.lang.String consumptionTime) {
		this.consumptionTime = consumptionTime;
	}



	/**
	 * Return the value associated with the column: qty_consumed
	 */
	public java.math.BigDecimal getQtyConsumed () {
		return qtyConsumed;
	}

	/**
	 * Set the value related to the column: qty_consumed
	 * @param qtyConsumed the qty_consumed value
	 */
	public void setQtyConsumed (java.math.BigDecimal qtyConsumed) {
		this.qtyConsumed = qtyConsumed;
	}



	/**
	 * Return the value associated with the column: stock_qty
	 */
	public java.math.BigDecimal getStockQty () {
		return stockQty;
	}

	/**
	 * Set the value related to the column: stock_qty
	 * @param stockQty the stock_qty value
	 */
	public void setStockQty (java.math.BigDecimal stockQty) {
		this.stockQty = stockQty;
	}



	/**
	 * Return the value associated with the column: expiry_date
	 */
	public java.util.Date getExpiryDate () {
		return expiryDate;
	}

	/**
	 * Set the value related to the column: expiry_date
	 * @param expiryDate the expiry_date value
	 */
	public void setExpiryDate (java.util.Date expiryDate) {
		this.expiryDate = expiryDate;
	}



	/**
	 * Return the value associated with the column: LAST_CHG_DATE
	 */
	public java.util.Date getLastChgDate () {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: LAST_CHG_DATE
	 * @param lastChgDate the LAST_CHG_DATE value
	 */
	public void setLastChgDate (java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}



	/**
	 * Return the value associated with the column: LAST_CHG_TIME
	 */
	public java.lang.String getLastChgTime () {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: LAST_CHG_TIME
	 * @param lastChgTime the LAST_CHG_TIME value
	 */
	public void setLastChgTime (java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}



	/**
	 * Return the value associated with the column: HOSPITAL_ID
	 */
	public jkt.hms.masters.business.MasHospital getHospital () {
		return hospital;
	}

	/**
	 * Set the value related to the column: HOSPITAL_ID
	 * @param hospital the HOSPITAL_ID value
	 */
	public void setHospital (jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}



	/**
	 * Return the value associated with the column: LAST_CHG_BY
	 */
	public jkt.hms.masters.business.Users getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: LAST_CHG_BY
	 * @param lastChgBy the LAST_CHG_BY value
	 */
	public void setLastChgBy (jkt.hms.masters.business.Users lastChgBy) {
		this.lastChgBy = lastChgBy;
	}



	/**
	 * Return the value associated with the column: BATCH_STOCK_ID
	 */
	public jkt.hms.masters.business.StoreItemBatchStock getBatchStock () {
		return batchStock;
	}

	/**
	 * Set the value related to the column: BATCH_STOCK_ID
	 * @param batchStock the BATCH_STOCK_ID value
	 */
	public void setBatchStock (jkt.hms.masters.business.StoreItemBatchStock batchStock) {
		this.batchStock = batchStock;
	}



	/**
	 * Return the value associated with the column: item_id
	 */
	public jkt.hms.masters.business.MasStoreItem getItem () {
		return item;
	}

	/**
	 * Set the value related to the column: item_id
	 * @param item the item_id value
	 */
	public void setItem (jkt.hms.masters.business.MasStoreItem item) {
		this.item = item;
	}



	/**
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment () {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * @param department the department_id value
	 */
	public void setDepartment (jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.IpdDrugConsumption)) return false;
		else {
			jkt.hms.masters.business.IpdDrugConsumption ipdDrugConsumption = (jkt.hms.masters.business.IpdDrugConsumption) obj;
			if (null == this.getId() || null == ipdDrugConsumption.getId()) return false;
			else return (this.getId().equals(ipdDrugConsumption.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}
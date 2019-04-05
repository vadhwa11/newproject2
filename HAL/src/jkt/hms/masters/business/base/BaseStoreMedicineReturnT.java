package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the STORE_MEDICINE_RETURN_T table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="STORE_MEDICINE_RETURN_T"
 */

public abstract class BaseStoreMedicineReturnT  implements Serializable {

	public static String REF = "StoreMedicineReturnT";
	public static String PROP_BATCH_NO = "BatchNo";
	public static String PROP_RETURN_M = "ReturnM";
	public static String PROP_BRAND = "Brand";
	public static String PROP_MANUFACTUREING_DATE = "ManufactureingDate";
	public static String PROP_ITEM = "Item";
	public static String PROP_EXPIRY_DATE = "ExpiryDate";
	public static String PROP_MANUFACTURED_BY = "ManufacturedBy";
	public static String PROP_SR_NO = "SrNo";
	public static String PROP_RETURN_QTY = "ReturnQty";
	public static String PROP_ID = "Id";


	// constructors
	public BaseStoreMedicineReturnT () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreMedicineReturnT (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseStoreMedicineReturnT (
		java.lang.Integer id,
		jkt.hms.masters.business.MasStoreBrand brand,
		jkt.hms.masters.business.MasStoreItem item) {

		this.setId(id);
		this.setBrand(brand);
		this.setItem(item);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer srNo;
	private java.util.Date manufactureingDate;
	private java.util.Date expiryDate;
	private java.math.BigDecimal returnQty;
	private java.lang.String batchNo;

	// many to one
	private jkt.hms.masters.business.StoreMedicineReturnM returnM;
	private jkt.hms.masters.business.MasStoreBrand brand;
	private jkt.hms.masters.business.MasStoreItem item;
	private jkt.hms.masters.business.MasManufacturer manufacturedBy;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="id"
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
	 * Return the value associated with the column: SR_NO
	 */
	public java.lang.Integer getSrNo () {
		return srNo;
	}

	/**
	 * Set the value related to the column: SR_NO
	 * @param srNo the SR_NO value
	 */
	public void setSrNo (java.lang.Integer srNo) {
		this.srNo = srNo;
	}



	/**
	 * Return the value associated with the column: MANUFACTUREING_DATE
	 */
	public java.util.Date getManufactureingDate () {
		return manufactureingDate;
	}

	/**
	 * Set the value related to the column: MANUFACTUREING_DATE
	 * @param manufactureingDate the MANUFACTUREING_DATE value
	 */
	public void setManufactureingDate (java.util.Date manufactureingDate) {
		this.manufactureingDate = manufactureingDate;
	}



	/**
	 * Return the value associated with the column: EXPIRY_DATE
	 */
	public java.util.Date getExpiryDate () {
		return expiryDate;
	}

	/**
	 * Set the value related to the column: EXPIRY_DATE
	 * @param expiryDate the EXPIRY_DATE value
	 */
	public void setExpiryDate (java.util.Date expiryDate) {
		this.expiryDate = expiryDate;
	}



	/**
	 * Return the value associated with the column: RETURN_QTY
	 */
	public java.math.BigDecimal getReturnQty () {
		return returnQty;
	}

	/**
	 * Set the value related to the column: RETURN_QTY
	 * @param returnQty the RETURN_QTY value
	 */
	public void setReturnQty (java.math.BigDecimal returnQty) {
		this.returnQty = returnQty;
	}



	/**
	 * Return the value associated with the column: batch_no
	 */
	public java.lang.String getBatchNo () {
		return batchNo;
	}

	/**
	 * Set the value related to the column: batch_no
	 * @param batchNo the batch_no value
	 */
	public void setBatchNo (java.lang.String batchNo) {
		this.batchNo = batchNo;
	}



	/**
	 * Return the value associated with the column: return_m_id
	 */
	public jkt.hms.masters.business.StoreMedicineReturnM getReturnM () {
		return returnM;
	}

	/**
	 * Set the value related to the column: return_m_id
	 * @param returnM the return_m_id value
	 */
	public void setReturnM (jkt.hms.masters.business.StoreMedicineReturnM returnM) {
		this.returnM = returnM;
	}



	/**
	 * Return the value associated with the column: brand_id
	 */
	public jkt.hms.masters.business.MasStoreBrand getBrand () {
		return brand;
	}

	/**
	 * Set the value related to the column: brand_id
	 * @param brand the brand_id value
	 */
	public void setBrand (jkt.hms.masters.business.MasStoreBrand brand) {
		this.brand = brand;
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
	 * Return the value associated with the column: manufacturer
	 */
	public jkt.hms.masters.business.MasManufacturer getManufacturedBy () {
		return manufacturedBy;
	}

	/**
	 * Set the value related to the column: manufacturer
	 * @param manufacturedBy the manufacturer value
	 */
	public void setManufacturedBy (jkt.hms.masters.business.MasManufacturer manufacturedBy) {
		this.manufacturedBy = manufacturedBy;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreMedicineReturnT)) return false;
		else {
			jkt.hms.masters.business.StoreMedicineReturnT storeMedicineReturnT = (jkt.hms.masters.business.StoreMedicineReturnT) obj;
			if (null == this.getId() || null == storeMedicineReturnT.getId()) return false;
			else return (this.getId().equals(storeMedicineReturnT.getId()));
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
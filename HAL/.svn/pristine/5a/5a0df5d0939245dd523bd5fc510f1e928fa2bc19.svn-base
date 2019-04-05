package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the STORE_SAMPLE_TESTING_DETAIL table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="STORE_SAMPLE_TESTING_DETAIL"
 */

public abstract class BaseStoreSampleTestingDetail  implements Serializable {

	public static String REF = "StoreSampleTestingDetail";
	public static String PROP_BATCH_NO = "BatchNo";
	public static String PROP_RECEIVED_FROM = "ReceivedFrom";
	public static String PROP_DEFECT_QTY = "DefectQty";
	public static String PROP_BRAND = "Brand";
	public static String PROP_ITEM = "Item";
	public static String PROP_EXPIRY_DATE = "ExpiryDate";
	public static String PROP_MANUFACTURED_BY = "ManufacturedBy";
	public static String PROP_MANUFACTURERING_DATE = "ManufactureringDate";
	public static String PROP_SR_NO = "SrNo";
	public static String PROP_STORE_SAMPLE_ENTRY = "StoreSampleEntry";
	public static String PROP_ID = "Id";
	public static String PROP_SOURCE_OF_SUPPLY = "SourceOfSupply";


	// constructors
	public BaseStoreSampleTestingDetail () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreSampleTestingDetail (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseStoreSampleTestingDetail (
		java.lang.Integer id,
		jkt.hms.masters.business.MasStoreBrand brand,
		jkt.hms.masters.business.MasStoreItem item,
		java.lang.Integer srNo,
		java.math.BigDecimal defectQty) {

		this.setId(id);
		this.setBrand(brand);
		this.setItem(item);
		this.setSrNo(srNo);
		this.setDefectQty(defectQty);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer srNo;
	private java.util.Date expiryDate;
	private java.math.BigDecimal defectQty;
	private java.lang.String receivedFrom;
	private java.util.Date manufactureringDate;
	private java.lang.String sourceOfSupply;

	// many to one
	private jkt.hms.masters.business.StoreSampleTestingEntry storeSampleEntry;
	private jkt.hms.masters.business.MasStoreBrand brand;
	private jkt.hms.masters.business.MasStoreItem item;
	private jkt.hms.masters.business.MasManufacturer manufacturedBy;
	private jkt.hms.masters.business.StoreItemBatchStock batchNo;



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
	 * Return the value associated with the column: DEFECT_QTY
	 */
	public java.math.BigDecimal getDefectQty () {
		return defectQty;
	}

	/**
	 * Set the value related to the column: DEFECT_QTY
	 * @param defectQty the DEFECT_QTY value
	 */
	public void setDefectQty (java.math.BigDecimal defectQty) {
		this.defectQty = defectQty;
	}



	/**
	 * Return the value associated with the column: RECEIVED_FROM
	 */
	public java.lang.String getReceivedFrom () {
		return receivedFrom;
	}

	/**
	 * Set the value related to the column: RECEIVED_FROM
	 * @param receivedFrom the RECEIVED_FROM value
	 */
	public void setReceivedFrom (java.lang.String receivedFrom) {
		this.receivedFrom = receivedFrom;
	}



	/**
	 * Return the value associated with the column: MANUFACTUREING_DATE
	 */
	public java.util.Date getManufactureringDate () {
		return manufactureringDate;
	}

	/**
	 * Set the value related to the column: MANUFACTUREING_DATE
	 * @param manufactureringDate the MANUFACTUREING_DATE value
	 */
	public void setManufactureringDate (java.util.Date manufactureringDate) {
		this.manufactureringDate = manufactureringDate;
	}



	/**
	 * Return the value associated with the column: SOURCE_OF_SUPPLY
	 */
	public java.lang.String getSourceOfSupply () {
		return sourceOfSupply;
	}

	/**
	 * Set the value related to the column: SOURCE_OF_SUPPLY
	 * @param sourceOfSupply the SOURCE_OF_SUPPLY value
	 */
	public void setSourceOfSupply (java.lang.String sourceOfSupply) {
		this.sourceOfSupply = sourceOfSupply;
	}



	/**
	 * Return the value associated with the column: DEFECT_M_ID
	 */
	public jkt.hms.masters.business.StoreSampleTestingEntry getStoreSampleEntry () {
		return storeSampleEntry;
	}

	/**
	 * Set the value related to the column: DEFECT_M_ID
	 * @param storeSampleEntry the DEFECT_M_ID value
	 */
	public void setStoreSampleEntry (jkt.hms.masters.business.StoreSampleTestingEntry storeSampleEntry) {
		this.storeSampleEntry = storeSampleEntry;
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
	 * Return the value associated with the column: manufactured_by
	 */
	public jkt.hms.masters.business.MasManufacturer getManufacturedBy () {
		return manufacturedBy;
	}

	/**
	 * Set the value related to the column: manufactured_by
	 * @param manufacturedBy the manufactured_by value
	 */
	public void setManufacturedBy (jkt.hms.masters.business.MasManufacturer manufacturedBy) {
		this.manufacturedBy = manufacturedBy;
	}



	/**
	 * Return the value associated with the column: batch_no
	 */
	public jkt.hms.masters.business.StoreItemBatchStock getBatchNo () {
		return batchNo;
	}

	/**
	 * Set the value related to the column: batch_no
	 * @param batchNo the batch_no value
	 */
	public void setBatchNo (jkt.hms.masters.business.StoreItemBatchStock batchNo) {
		this.batchNo = batchNo;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreSampleTestingDetail)) return false;
		else {
			jkt.hms.masters.business.StoreSampleTestingDetail storeSampleTestingDetail = (jkt.hms.masters.business.StoreSampleTestingDetail) obj;
			if (null == this.getId() || null == storeSampleTestingDetail.getId()) return false;
			else return (this.getId().equals(storeSampleTestingDetail.getId()));
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
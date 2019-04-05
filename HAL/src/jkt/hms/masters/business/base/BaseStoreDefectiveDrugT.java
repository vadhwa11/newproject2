package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the store_defective_drug_t table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="store_defective_drug_t"
 */

public abstract class BaseStoreDefectiveDrugT  implements Serializable {

	public static String REF = "StoreDefectiveDrugT";
	public static String PROP_DISPOSAL_INSTRUCTIONS = "DisposalInstructions";
	public static String PROP_BRAND = "Brand";
	public static String PROP_MANUFACTURED_BY = "ManufacturedBy";
	public static String PROP_DATE_OF_DISPOSAL = "DateOfDisposal";
	public static String PROP_RECEIVED_FROM = "ReceivedFrom";
	public static String PROP_DEFECT_M = "DefectM";
	public static String PROP_EXPIRY_DATE = "ExpiryDate";
	public static String PROP_DEFECT_QTY = "DefectQty";
	public static String PROP_ITEM = "Item";
	public static String PROP_DISPOSAL = "Disposal";
	public static String PROP_MANUFACTURERING_DATE = "ManufactureringDate";
	public static String PROP_AUTHORITY = "Authority";
	public static String PROP_ID = "Id";
	public static String PROP_BATCH_NO = "BatchNo";
	public static String PROP_SR_NO = "SrNo";


	// constructors
	public BaseStoreDefectiveDrugT () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreDefectiveDrugT (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseStoreDefectiveDrugT (
		java.lang.Integer id,
		jkt.hms.masters.business.MasStoreItem item,
		java.lang.Integer srNo,
		java.math.BigDecimal defectQty,
		java.lang.String authority,
		java.lang.String disposalInstructions) {

		this.setId(id);
		this.setItem(item);
		this.setSrNo(srNo);
		this.setDefectQty(defectQty);
		this.setAuthority(authority);
		this.setDisposalInstructions(disposalInstructions);
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
	private java.lang.String disposal;
	private java.util.Date dateOfDisposal;
	private java.lang.String authority;
	private java.lang.String disposalInstructions;

	// many to one
	private jkt.hms.masters.business.StoreDefectiveDrugM defectM;
	private jkt.hms.masters.business.MasStoreBrand brand;
	private jkt.hms.masters.business.MasStoreItem item;
	private jkt.hms.masters.business.MasManufacturer manufacturedBy;
	private jkt.hms.masters.business.StoreItemBatchStock batchNo;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
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
	 * Return the value associated with the column: sr_no
	 */
	public java.lang.Integer getSrNo () {
		return srNo;
	}

	/**
	 * Set the value related to the column: sr_no
	 * @param srNo the sr_no value
	 */
	public void setSrNo (java.lang.Integer srNo) {
		this.srNo = srNo;
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
	 * Return the value associated with the column: defect_qty
	 */
	public java.math.BigDecimal getDefectQty () {
		return defectQty;
	}

	/**
	 * Set the value related to the column: defect_qty
	 * @param defectQty the defect_qty value
	 */
	public void setDefectQty (java.math.BigDecimal defectQty) {
		this.defectQty = defectQty;
	}



	/**
	 * Return the value associated with the column: received_from
	 */
	public java.lang.String getReceivedFrom () {
		return receivedFrom;
	}

	/**
	 * Set the value related to the column: received_from
	 * @param receivedFrom the received_from value
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
	 * Return the value associated with the column: DISPOSAL
	 */
	public java.lang.String getDisposal () {
		return disposal;
	}

	/**
	 * Set the value related to the column: DISPOSAL
	 * @param disposal the DISPOSAL value
	 */
	public void setDisposal (java.lang.String disposal) {
		this.disposal = disposal;
	}



	/**
	 * Return the value associated with the column: DATE_OF_DISPOSAL
	 */
	public java.util.Date getDateOfDisposal () {
		return dateOfDisposal;
	}

	/**
	 * Set the value related to the column: DATE_OF_DISPOSAL
	 * @param dateOfDisposal the DATE_OF_DISPOSAL value
	 */
	public void setDateOfDisposal (java.util.Date dateOfDisposal) {
		this.dateOfDisposal = dateOfDisposal;
	}



	/**
	 * Return the value associated with the column: authority
	 */
	public java.lang.String getAuthority () {
		return authority;
	}

	/**
	 * Set the value related to the column: authority
	 * @param authority the authority value
	 */
	public void setAuthority (java.lang.String authority) {
		this.authority = authority;
	}



	/**
	 * Return the value associated with the column: DISPOSAL_INSTRUCTIONS
	 */
	public java.lang.String getDisposalInstructions () {
		return disposalInstructions;
	}

	/**
	 * Set the value related to the column: DISPOSAL_INSTRUCTIONS
	 * @param disposalInstructions the DISPOSAL_INSTRUCTIONS value
	 */
	public void setDisposalInstructions (java.lang.String disposalInstructions) {
		this.disposalInstructions = disposalInstructions;
	}



	/**
	 * Return the value associated with the column: defect_m_id
	 */
	public jkt.hms.masters.business.StoreDefectiveDrugM getDefectM () {
		return defectM;
	}

	/**
	 * Set the value related to the column: defect_m_id
	 * @param defectM the defect_m_id value
	 */
	public void setDefectM (jkt.hms.masters.business.StoreDefectiveDrugM defectM) {
		this.defectM = defectM;
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
		if (!(obj instanceof jkt.hms.masters.business.StoreDefectiveDrugT)) return false;
		else {
			jkt.hms.masters.business.StoreDefectiveDrugT storeDefectiveDrugT = (jkt.hms.masters.business.StoreDefectiveDrugT) obj;
			if (null == this.getId() || null == storeDefectiveDrugT.getId()) return false;
			else return (this.getId().equals(storeDefectiveDrugT.getId()));
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
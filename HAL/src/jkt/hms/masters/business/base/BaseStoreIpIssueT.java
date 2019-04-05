package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the store_ip_issue_t table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="store_ip_issue_t"
 */

public abstract class BaseStoreIpIssueT  implements Serializable {

	public static String REF = "StoreIpIssueT";
	public static String PROP_BRAND = "Brand";
	public static String PROP_EXPIRY_DATE = "ExpiryDate";
	public static String PROP_BATCH = "Batch";
	public static String PROP_AMOUNT = "Amount";
	public static String PROP_ITEM = "Item";
	public static String PROP_ID = "Id";
	public static String PROP_IP_ISSUE = "IpIssue";
	public static String PROP_QTY_ISSUED = "QtyIssued";
	public static String PROP_BATCH_NO = "BatchNo";
	public static String PROP_PRESCRIPTION_DETAIL = "PrescriptionDetail";
	public static String PROP_RATE = "Rate";


	// constructors
	public BaseStoreIpIssueT () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreIpIssueT (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String batchNo;
	private java.util.Date expiryDate;
	private java.math.BigDecimal qtyIssued;
	private java.math.BigDecimal rate;
	private java.math.BigDecimal amount;

	// many to one
	private jkt.hms.masters.business.StoreIpIssueM ipIssue;
	private jkt.hms.masters.business.MasStoreBrand brand;
	private jkt.hms.masters.business.MasStoreItem item;
	private jkt.hms.masters.business.StoreItemBatchStock batch;
	private jkt.hms.masters.business.PatientPrescriptionDetails prescriptionDetail;



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
	 * Return the value associated with the column: qty_issued
	 */
	public java.math.BigDecimal getQtyIssued () {
		return qtyIssued;
	}

	/**
	 * Set the value related to the column: qty_issued
	 * @param qtyIssued the qty_issued value
	 */
	public void setQtyIssued (java.math.BigDecimal qtyIssued) {
		this.qtyIssued = qtyIssued;
	}



	/**
	 * Return the value associated with the column: rate
	 */
	public java.math.BigDecimal getRate () {
		return rate;
	}

	/**
	 * Set the value related to the column: rate
	 * @param rate the rate value
	 */
	public void setRate (java.math.BigDecimal rate) {
		this.rate = rate;
	}



	/**
	 * Return the value associated with the column: amount
	 */
	public java.math.BigDecimal getAmount () {
		return amount;
	}

	/**
	 * Set the value related to the column: amount
	 * @param amount the amount value
	 */
	public void setAmount (java.math.BigDecimal amount) {
		this.amount = amount;
	}



	/**
	 * Return the value associated with the column: ip_issue_id
	 */
	public jkt.hms.masters.business.StoreIpIssueM getIpIssue () {
		return ipIssue;
	}

	/**
	 * Set the value related to the column: ip_issue_id
	 * @param ipIssue the ip_issue_id value
	 */
	public void setIpIssue (jkt.hms.masters.business.StoreIpIssueM ipIssue) {
		this.ipIssue = ipIssue;
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
	 * Return the value associated with the column: BATCH_ID
	 */
	public jkt.hms.masters.business.StoreItemBatchStock getBatch () {
		return batch;
	}

	/**
	 * Set the value related to the column: BATCH_ID
	 * @param batch the BATCH_ID value
	 */
	public void setBatch (jkt.hms.masters.business.StoreItemBatchStock batch) {
		this.batch = batch;
	}



	/**
	 * Return the value associated with the column: PRESCRIPTION_DETAIL_ID
	 */
	public jkt.hms.masters.business.PatientPrescriptionDetails getPrescriptionDetail () {
		return prescriptionDetail;
	}

	/**
	 * Set the value related to the column: PRESCRIPTION_DETAIL_ID
	 * @param prescriptionDetail the PRESCRIPTION_DETAIL_ID value
	 */
	public void setPrescriptionDetail (jkt.hms.masters.business.PatientPrescriptionDetails prescriptionDetail) {
		this.prescriptionDetail = prescriptionDetail;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreIpIssueT)) return false;
		else {
			jkt.hms.masters.business.StoreIpIssueT storeIpIssueT = (jkt.hms.masters.business.StoreIpIssueT) obj;
			if (null == this.getId() || null == storeIpIssueT.getId()) return false;
			else return (this.getId().equals(storeIpIssueT.getId()));
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
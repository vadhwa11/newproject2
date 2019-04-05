package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the store_quotation_receipt_m
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="store_quotation_receipt_m"
 */

public abstract class BaseStoreQuotationReceiptM implements Serializable {

	public static String REF = "StoreQuotationReceiptM";
	public static String PROP_STATUS = "Status";
	public static String PROP_DELIVERY_TERMS = "DeliveryTerms";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ENCODED_TIME = "EncodedTime";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_QUOTATION_NO = "QuotationNo";
	public static String PROP_PAYMENT_TERMS = "PaymentTerms";
	public static String PROP_QUOTATION_REQUEST_ID = "QuotationRequestId";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_ENCODED_BY = "EncodedBy";
	public static String PROP_SUPPLIER = "Supplier";
	public static String PROP_QUOTATION_DATE = "QuotationDate";
	public static String PROP_QUOTATION_TYPE = "QuotationType";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_ID = "Id";
	public static String PROP_ENCODED_DATE = "EncodedDate";

	// constructors
	public BaseStoreQuotationReceiptM() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreQuotationReceiptM(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String quotationRequestId;
	private java.lang.String quotationNo;
	private java.util.Date quotationDate;
	private java.lang.String quotationType;
	private java.lang.String deliveryTerms;
	private java.lang.String paymentTerms;
	private java.lang.String remarks;
	private java.lang.String status;
	private java.lang.String encodedBy;
	private java.util.Date encodedDate;
	private java.lang.String encodedTime;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasStoreSupplier supplier;

	// collections
	private java.util.Set<jkt.hms.masters.business.StoreQuotationReceiptT> storeQuotationReceiptTs;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="master_id"
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
	 * Return the value associated with the column: quotation_request_id
	 */
	public java.lang.String getQuotationRequestId() {
		return quotationRequestId;
	}

	/**
	 * Set the value related to the column: quotation_request_id
	 * 
	 * @param quotationRequestId
	 *            the quotation_request_id value
	 */
	public void setQuotationRequestId(java.lang.String quotationRequestId) {
		this.quotationRequestId = quotationRequestId;
	}

	/**
	 * Return the value associated with the column: quotation_no
	 */
	public java.lang.String getQuotationNo() {
		return quotationNo;
	}

	/**
	 * Set the value related to the column: quotation_no
	 * 
	 * @param quotationNo
	 *            the quotation_no value
	 */
	public void setQuotationNo(java.lang.String quotationNo) {
		this.quotationNo = quotationNo;
	}

	/**
	 * Return the value associated with the column: quotation_date
	 */
	public java.util.Date getQuotationDate() {
		return quotationDate;
	}

	/**
	 * Set the value related to the column: quotation_date
	 * 
	 * @param quotationDate
	 *            the quotation_date value
	 */
	public void setQuotationDate(java.util.Date quotationDate) {
		this.quotationDate = quotationDate;
	}

	/**
	 * Return the value associated with the column: quotation_type
	 */
	public java.lang.String getQuotationType() {
		return quotationType;
	}

	/**
	 * Set the value related to the column: quotation_type
	 * 
	 * @param quotationType
	 *            the quotation_type value
	 */
	public void setQuotationType(java.lang.String quotationType) {
		this.quotationType = quotationType;
	}

	/**
	 * Return the value associated with the column: delivery_terms
	 */
	public java.lang.String getDeliveryTerms() {
		return deliveryTerms;
	}

	/**
	 * Set the value related to the column: delivery_terms
	 * 
	 * @param deliveryTerms
	 *            the delivery_terms value
	 */
	public void setDeliveryTerms(java.lang.String deliveryTerms) {
		this.deliveryTerms = deliveryTerms;
	}

	/**
	 * Return the value associated with the column: payment_terms
	 */
	public java.lang.String getPaymentTerms() {
		return paymentTerms;
	}

	/**
	 * Set the value related to the column: payment_terms
	 * 
	 * @param paymentTerms
	 *            the payment_terms value
	 */
	public void setPaymentTerms(java.lang.String paymentTerms) {
		this.paymentTerms = paymentTerms;
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
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus() {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * 
	 * @param status
	 *            the status value
	 */
	public void setStatus(java.lang.String status) {
		this.status = status;
	}

	/**
	 * Return the value associated with the column: encoded_by
	 */
	public java.lang.String getEncodedBy() {
		return encodedBy;
	}

	/**
	 * Set the value related to the column: encoded_by
	 * 
	 * @param encodedBy
	 *            the encoded_by value
	 */
	public void setEncodedBy(java.lang.String encodedBy) {
		this.encodedBy = encodedBy;
	}

	/**
	 * Return the value associated with the column: encoded_date
	 */
	public java.util.Date getEncodedDate() {
		return encodedDate;
	}

	/**
	 * Set the value related to the column: encoded_date
	 * 
	 * @param encodedDate
	 *            the encoded_date value
	 */
	public void setEncodedDate(java.util.Date encodedDate) {
		this.encodedDate = encodedDate;
	}

	/**
	 * Return the value associated with the column: encoded_time
	 */
	public java.lang.String getEncodedTime() {
		return encodedTime;
	}

	/**
	 * Set the value related to the column: encoded_time
	 * 
	 * @param encodedTime
	 *            the encoded_time value
	 */
	public void setEncodedTime(java.lang.String encodedTime) {
		this.encodedTime = encodedTime;
	}

	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.String getLastChgBy() {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * 
	 * @param lastChgBy
	 *            the last_chg_by value
	 */
	public void setLastChgBy(java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
	}

	/**
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate() {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * 
	 * @param lastChgDate
	 *            the last_chg_date value
	 */
	public void setLastChgDate(java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}

	/**
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime() {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * 
	 * @param lastChgTime
	 *            the last_chg_time value
	 */
	public void setLastChgTime(java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}

	/**
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment() {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * 
	 * @param department
	 *            the department_id value
	 */
	public void setDepartment(jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}

	/**
	 * Return the value associated with the column: supplier_id
	 */
	public jkt.hms.masters.business.MasStoreSupplier getSupplier() {
		return supplier;
	}

	/**
	 * Set the value related to the column: supplier_id
	 * 
	 * @param supplier
	 *            the supplier_id value
	 */
	public void setSupplier(jkt.hms.masters.business.MasStoreSupplier supplier) {
		this.supplier = supplier;
	}

	/**
	 * Return the value associated with the column: StoreQuotationReceiptTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreQuotationReceiptT> getStoreQuotationReceiptTs() {
		return storeQuotationReceiptTs;
	}

	/**
	 * Set the value related to the column: StoreQuotationReceiptTs
	 * 
	 * @param storeQuotationReceiptTs
	 *            the StoreQuotationReceiptTs value
	 */
	public void setStoreQuotationReceiptTs(
			java.util.Set<jkt.hms.masters.business.StoreQuotationReceiptT> storeQuotationReceiptTs) {
		this.storeQuotationReceiptTs = storeQuotationReceiptTs;
	}

	public void addToStoreQuotationReceiptTs(
			jkt.hms.masters.business.StoreQuotationReceiptT storeQuotationReceiptT) {
		if (null == getStoreQuotationReceiptTs())
			setStoreQuotationReceiptTs(new java.util.TreeSet<jkt.hms.masters.business.StoreQuotationReceiptT>());
		getStoreQuotationReceiptTs().add(storeQuotationReceiptT);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreQuotationReceiptM))
			return false;
		else {
			jkt.hms.masters.business.StoreQuotationReceiptM storeQuotationReceiptM = (jkt.hms.masters.business.StoreQuotationReceiptM) obj;
			if (null == this.getId() || null == storeQuotationReceiptM.getId())
				return false;
			else
				return (this.getId().equals(storeQuotationReceiptM.getId()));
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
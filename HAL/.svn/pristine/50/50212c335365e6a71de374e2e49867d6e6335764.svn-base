package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * store_item_log_transaction table. Do not modify this class because it will be
 * overwritten if the configuration file related to this class is modified.
 * 
 * @hibernate.class table="store_item_log_transaction"
 */

public abstract class BaseStoreItemLogTransaction implements Serializable {

	public static String REF = "StoreItemLogTransaction";
	public static String PROP_DOCUMENT_FLAG = "DocumentFlag";
	public static String PROP_ITEM = "Item";
	public static String PROP_TO_DEPARTMENT_ID = "ToDepartmentId";
	public static String PROP_BATCH_NO = "BatchNo";
	public static String PROP_UNIT_ID = "UnitId";
	public static String PROP_SUPPLIER = "Supplier";
	public static String PROP_DOCUMENT_NO = "DocumentNo";
	public static String PROP_BATCH_DATE = "BatchDate";
	public static String PROP_DOC_TYPE = "DocType";
	public static String PROP_PATIENT_NAME = "PatientName";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_ID = "Id";
	public static String PROP_QUANTITY = "Quantity";
	public static String PROP_RATE = "Rate";

	// constructors
	public BaseStoreItemLogTransaction() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreItemLogTransaction(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date batchDate;
	private java.lang.String batchNo;
	private java.lang.String docType;
	private java.math.BigDecimal quantity;
	private java.math.BigDecimal rate;
	private java.lang.Integer unitId;
	private java.lang.String documentNo;
	private java.lang.Short documentFlag;
	private java.lang.Integer toDepartmentId;
	private java.lang.String patientName;

	// many to one
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasStoreSupplier supplier;
	private jkt.hms.masters.business.MasStoreItem item;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="tran_log_id"
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
	 * Return the value associated with the column: batch_date
	 */
	public java.util.Date getBatchDate() {
		return batchDate;
	}

	/**
	 * Set the value related to the column: batch_date
	 * 
	 * @param batchDate
	 *            the batch_date value
	 */
	public void setBatchDate(java.util.Date batchDate) {
		this.batchDate = batchDate;
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
	 * Return the value associated with the column: doc_type
	 */
	public java.lang.String getDocType() {
		return docType;
	}

	/**
	 * Set the value related to the column: doc_type
	 * 
	 * @param docType
	 *            the doc_type value
	 */
	public void setDocType(java.lang.String docType) {
		this.docType = docType;
	}

	/**
	 * Return the value associated with the column: quantity
	 */
	public java.math.BigDecimal getQuantity() {
		return quantity;
	}

	/**
	 * Set the value related to the column: quantity
	 * 
	 * @param quantity
	 *            the quantity value
	 */
	public void setQuantity(java.math.BigDecimal quantity) {
		this.quantity = quantity;
	}

	/**
	 * Return the value associated with the column: rate
	 */
	public java.math.BigDecimal getRate() {
		return rate;
	}

	/**
	 * Set the value related to the column: rate
	 * 
	 * @param rate
	 *            the rate value
	 */
	public void setRate(java.math.BigDecimal rate) {
		this.rate = rate;
	}

	/**
	 * Return the value associated with the column: unit_id
	 */
	public java.lang.Integer getUnitId() {
		return unitId;
	}

	/**
	 * Set the value related to the column: unit_id
	 * 
	 * @param unitId
	 *            the unit_id value
	 */
	public void setUnitId(java.lang.Integer unitId) {
		this.unitId = unitId;
	}

	/**
	 * Return the value associated with the column: document_no
	 */
	public java.lang.String getDocumentNo() {
		return documentNo;
	}

	/**
	 * Set the value related to the column: document_no
	 * 
	 * @param documentNo
	 *            the document_no value
	 */
	public void setDocumentNo(java.lang.String documentNo) {
		this.documentNo = documentNo;
	}

	/**
	 * Return the value associated with the column: document_flag
	 */
	public java.lang.Short getDocumentFlag() {
		return documentFlag;
	}

	/**
	 * Set the value related to the column: document_flag
	 * 
	 * @param documentFlag
	 *            the document_flag value
	 */
	public void setDocumentFlag(java.lang.Short documentFlag) {
		this.documentFlag = documentFlag;
	}

	/**
	 * Return the value associated with the column: to_department_id
	 */
	public java.lang.Integer getToDepartmentId() {
		return toDepartmentId;
	}

	/**
	 * Set the value related to the column: to_department_id
	 * 
	 * @param toDepartmentId
	 *            the to_department_id value
	 */
	public void setToDepartmentId(java.lang.Integer toDepartmentId) {
		this.toDepartmentId = toDepartmentId;
	}

	/**
	 * Return the value associated with the column: patient_name
	 */
	public java.lang.String getPatientName() {
		return patientName;
	}

	/**
	 * Set the value related to the column: patient_name
	 * 
	 * @param patientName
	 *            the patient_name value
	 */
	public void setPatientName(java.lang.String patientName) {
		this.patientName = patientName;
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
		if (!(obj instanceof jkt.hms.masters.business.StoreItemLogTransaction))
			return false;
		else {
			jkt.hms.masters.business.StoreItemLogTransaction storeItemLogTransaction = (jkt.hms.masters.business.StoreItemLogTransaction) obj;
			if (null == this.getId() || null == storeItemLogTransaction.getId())
				return false;
			else
				return (this.getId().equals(storeItemLogTransaction.getId()));
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
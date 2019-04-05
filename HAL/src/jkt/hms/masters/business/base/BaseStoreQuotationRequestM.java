package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the store_quotation_request_m table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="store_quotation_request_m"
 */

public abstract class BaseStoreQuotationRequestM  implements Serializable {

	public static String REF = "StoreQuotationRequestM";
	public static String PROP_MPR_HEADER = "MprHeader";
	public static String PROP_ENCODED_TIME = "EncodedTime";
	public static String PROP_REQUEST_DATE = "RequestDate";
	public static String PROP_DUE_DATE = "DueDate";
	public static String PROP_DELIVERY_INSTRUCTION = "DeliveryInstruction";
	public static String PROP_ENCODED_DATE = "EncodedDate";
	public static String PROP_ENCODED_BY = "EncodedBy";
	public static String PROP_YEAR = "Year";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_SUPPLIER = "Supplier";
	public static String PROP_REQUEST_NO = "RequestNo";
	public static String PROP_PREPARED_BY = "PreparedBy";
	public static String PROP_EXPECTED_DELIVERY_DATE = "ExpectedDeliveryDate";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_REQUEST_TYPE = "RequestType";


	// constructors
	public BaseStoreQuotationRequestM () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreQuotationRequestM (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String deliveryInstruction;
	private java.util.Date dueDate;
	private java.lang.String encodedBy;
	private java.util.Date encodedDate;
	private java.lang.String encodedTime;
	private java.util.Date expectedDeliveryDate;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.util.Date requestDate;
	private java.lang.String requestNo;
	private java.lang.String requestType;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.StoreMaterialPurchaseReqM mprHeader;
	private jkt.hms.masters.business.Users preparedBy;
	private jkt.hms.masters.business.MasStoreSupplier supplier;
	private jkt.hms.masters.business.MasStoreFinancial year;

	// collections
	private java.util.Set<jkt.hms.masters.business.StoreQuotationRequestT> storeQuotationRequestTs;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="master_id"
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
	 * Return the value associated with the column: delivery_instruction
	 */
	public java.lang.String getDeliveryInstruction () {
		return deliveryInstruction;
	}

	/**
	 * Set the value related to the column: delivery_instruction
	 * @param deliveryInstruction the delivery_instruction value
	 */
	public void setDeliveryInstruction (java.lang.String deliveryInstruction) {
		this.deliveryInstruction = deliveryInstruction;
	}



	/**
	 * Return the value associated with the column: due_date
	 */
	public java.util.Date getDueDate () {
		return dueDate;
	}

	/**
	 * Set the value related to the column: due_date
	 * @param dueDate the due_date value
	 */
	public void setDueDate (java.util.Date dueDate) {
		this.dueDate = dueDate;
	}



	/**
	 * Return the value associated with the column: encoded_by
	 */
	public java.lang.String getEncodedBy () {
		return encodedBy;
	}

	/**
	 * Set the value related to the column: encoded_by
	 * @param encodedBy the encoded_by value
	 */
	public void setEncodedBy (java.lang.String encodedBy) {
		this.encodedBy = encodedBy;
	}



	/**
	 * Return the value associated with the column: encoded_date
	 */
	public java.util.Date getEncodedDate () {
		return encodedDate;
	}

	/**
	 * Set the value related to the column: encoded_date
	 * @param encodedDate the encoded_date value
	 */
	public void setEncodedDate (java.util.Date encodedDate) {
		this.encodedDate = encodedDate;
	}



	/**
	 * Return the value associated with the column: encoded_time
	 */
	public java.lang.String getEncodedTime () {
		return encodedTime;
	}

	/**
	 * Set the value related to the column: encoded_time
	 * @param encodedTime the encoded_time value
	 */
	public void setEncodedTime (java.lang.String encodedTime) {
		this.encodedTime = encodedTime;
	}



	/**
	 * Return the value associated with the column: expected_delivery_date
	 */
	public java.util.Date getExpectedDeliveryDate () {
		return expectedDeliveryDate;
	}

	/**
	 * Set the value related to the column: expected_delivery_date
	 * @param expectedDeliveryDate the expected_delivery_date value
	 */
	public void setExpectedDeliveryDate (java.util.Date expectedDeliveryDate) {
		this.expectedDeliveryDate = expectedDeliveryDate;
	}



	/**
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate () {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * @param lastChgDate the last_chg_date value
	 */
	public void setLastChgDate (java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}



	/**
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime () {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * @param lastChgTime the last_chg_time value
	 */
	public void setLastChgTime (java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}



	/**
	 * Return the value associated with the column: request_date
	 */
	public java.util.Date getRequestDate () {
		return requestDate;
	}

	/**
	 * Set the value related to the column: request_date
	 * @param requestDate the request_date value
	 */
	public void setRequestDate (java.util.Date requestDate) {
		this.requestDate = requestDate;
	}



	/**
	 * Return the value associated with the column: request_no
	 */
	public java.lang.String getRequestNo () {
		return requestNo;
	}

	/**
	 * Set the value related to the column: request_no
	 * @param requestNo the request_no value
	 */
	public void setRequestNo (java.lang.String requestNo) {
		this.requestNo = requestNo;
	}



	/**
	 * Return the value associated with the column: request_type
	 */
	public java.lang.String getRequestType () {
		return requestType;
	}

	/**
	 * Set the value related to the column: request_type
	 * @param requestType the request_type value
	 */
	public void setRequestType (java.lang.String requestType) {
		this.requestType = requestType;
	}



	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * @param status the status value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
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



	/**
	 * Return the value associated with the column: mpr_header_id
	 */
	public jkt.hms.masters.business.StoreMaterialPurchaseReqM getMprHeader () {
		return mprHeader;
	}

	/**
	 * Set the value related to the column: mpr_header_id
	 * @param mprHeader the mpr_header_id value
	 */
	public void setMprHeader (jkt.hms.masters.business.StoreMaterialPurchaseReqM mprHeader) {
		this.mprHeader = mprHeader;
	}



	/**
	 * Return the value associated with the column: prepared_by
	 */
	public jkt.hms.masters.business.Users getPreparedBy () {
		return preparedBy;
	}

	/**
	 * Set the value related to the column: prepared_by
	 * @param preparedBy the prepared_by value
	 */
	public void setPreparedBy (jkt.hms.masters.business.Users preparedBy) {
		this.preparedBy = preparedBy;
	}



	/**
	 * Return the value associated with the column: supplier_id
	 */
	public jkt.hms.masters.business.MasStoreSupplier getSupplier () {
		return supplier;
	}

	/**
	 * Set the value related to the column: supplier_id
	 * @param supplier the supplier_id value
	 */
	public void setSupplier (jkt.hms.masters.business.MasStoreSupplier supplier) {
		this.supplier = supplier;
	}



	/**
	 * Return the value associated with the column: year_id
	 */
	public jkt.hms.masters.business.MasStoreFinancial getYear () {
		return year;
	}

	/**
	 * Set the value related to the column: year_id
	 * @param year the year_id value
	 */
	public void setYear (jkt.hms.masters.business.MasStoreFinancial year) {
		this.year = year;
	}



	/**
	 * Return the value associated with the column: StoreQuotationRequestTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreQuotationRequestT> getStoreQuotationRequestTs () {
		return storeQuotationRequestTs;
	}

	/**
	 * Set the value related to the column: StoreQuotationRequestTs
	 * @param storeQuotationRequestTs the StoreQuotationRequestTs value
	 */
	public void setStoreQuotationRequestTs (java.util.Set<jkt.hms.masters.business.StoreQuotationRequestT> storeQuotationRequestTs) {
		this.storeQuotationRequestTs = storeQuotationRequestTs;
	}

	public void addToStoreQuotationRequestTs (jkt.hms.masters.business.StoreQuotationRequestT storeQuotationRequestT) {
		if (null == getStoreQuotationRequestTs()) setStoreQuotationRequestTs(new java.util.TreeSet<jkt.hms.masters.business.StoreQuotationRequestT>());
		getStoreQuotationRequestTs().add(storeQuotationRequestT);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreQuotationRequestM)) return false;
		else {
			jkt.hms.masters.business.StoreQuotationRequestM storeQuotationRequestM = (jkt.hms.masters.business.StoreQuotationRequestM) obj;
			if (null == this.getId() || null == storeQuotationRequestM.getId()) return false;
			else return (this.getId().equals(storeQuotationRequestM.getId()));
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
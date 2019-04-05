package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_unit_of_measurement
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="mas_unit_of_measurement"
 */

public abstract class BaseMasUnitOfMeasurement implements Serializable {

	public static String REF = "MasUnitOfMeasurement";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_UNIT_OF_MEASUREMENT_CODE = "UnitOfMeasurementCode";
	public static String PROP_UNIT_OF_MEASUREMENT_NAME = "UnitOfMeasurementName";
	public static String PROP_ID = "Id";

	// constructors
	public BaseMasUnitOfMeasurement() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasUnitOfMeasurement(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String unitOfMeasurementCode;
	private java.lang.String unitOfMeasurementName;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// collections
	private java.util.Set<jkt.hms.masters.business.StoreSupplyOrderEntry> storeSupplyOrderEntries;
	private java.util.Set<jkt.hms.masters.business.StoreGrnT> storeGrnTs;
	private java.util.Set<jkt.hms.masters.business.MasChargeCode> masChargeCodes;
	private java.util.Set<jkt.hms.masters.business.StoreLoaninT> storeLoaninTs;
	private java.util.Set<jkt.hms.masters.business.StoreQuotationRequestT> storeQuotationRequestTs;
	private java.util.Set<jkt.hms.masters.business.StoreQuotationReceiptT> storeQuotationReceiptTs;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="unit_of_measurement_id"
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
	 * Return the value associated with the column: unit_of_measurement_code
	 */
	public java.lang.String getUnitOfMeasurementCode() {
		return unitOfMeasurementCode;
	}

	/**
	 * Set the value related to the column: unit_of_measurement_code
	 * 
	 * @param unitOfMeasurementCode
	 *            the unit_of_measurement_code value
	 */
	public void setUnitOfMeasurementCode(java.lang.String unitOfMeasurementCode) {
		this.unitOfMeasurementCode = unitOfMeasurementCode;
	}

	/**
	 * Return the value associated with the column: unit_of_measurement_name
	 */
	public java.lang.String getUnitOfMeasurementName() {
		return unitOfMeasurementName;
	}

	/**
	 * Set the value related to the column: unit_of_measurement_name
	 * 
	 * @param unitOfMeasurementName
	 *            the unit_of_measurement_name value
	 */
	public void setUnitOfMeasurementName(java.lang.String unitOfMeasurementName) {
		this.unitOfMeasurementName = unitOfMeasurementName;
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
	 * Return the value associated with the column: StoreSupplyOrderEntries
	 */
	public java.util.Set<jkt.hms.masters.business.StoreSupplyOrderEntry> getStoreSupplyOrderEntries() {
		return storeSupplyOrderEntries;
	}

	/**
	 * Set the value related to the column: StoreSupplyOrderEntries
	 * 
	 * @param storeSupplyOrderEntries
	 *            the StoreSupplyOrderEntries value
	 */
	public void setStoreSupplyOrderEntries(
			java.util.Set<jkt.hms.masters.business.StoreSupplyOrderEntry> storeSupplyOrderEntries) {
		this.storeSupplyOrderEntries = storeSupplyOrderEntries;
	}

	public void addToStoreSupplyOrderEntries(
			jkt.hms.masters.business.StoreSupplyOrderEntry storeSupplyOrderEntry) {
		if (null == getStoreSupplyOrderEntries())
			setStoreSupplyOrderEntries(new java.util.TreeSet<jkt.hms.masters.business.StoreSupplyOrderEntry>());
		getStoreSupplyOrderEntries().add(storeSupplyOrderEntry);
	}

	/**
	 * Return the value associated with the column: StoreGrnTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreGrnT> getStoreGrnTs() {
		return storeGrnTs;
	}

	/**
	 * Set the value related to the column: StoreGrnTs
	 * 
	 * @param storeGrnTs
	 *            the StoreGrnTs value
	 */
	public void setStoreGrnTs(
			java.util.Set<jkt.hms.masters.business.StoreGrnT> storeGrnTs) {
		this.storeGrnTs = storeGrnTs;
	}

	public void addToStoreGrnTs(jkt.hms.masters.business.StoreGrnT storeGrnT) {
		if (null == getStoreGrnTs())
			setStoreGrnTs(new java.util.TreeSet<jkt.hms.masters.business.StoreGrnT>());
		getStoreGrnTs().add(storeGrnT);
	}

	/**
	 * Return the value associated with the column: MasChargeCodes
	 */
	public java.util.Set<jkt.hms.masters.business.MasChargeCode> getMasChargeCodes() {
		return masChargeCodes;
	}

	/**
	 * Set the value related to the column: MasChargeCodes
	 * 
	 * @param masChargeCodes
	 *            the MasChargeCodes value
	 */
	public void setMasChargeCodes(
			java.util.Set<jkt.hms.masters.business.MasChargeCode> masChargeCodes) {
		this.masChargeCodes = masChargeCodes;
	}

	public void addToMasChargeCodes(
			jkt.hms.masters.business.MasChargeCode masChargeCode) {
		if (null == getMasChargeCodes())
			setMasChargeCodes(new java.util.TreeSet<jkt.hms.masters.business.MasChargeCode>());
		getMasChargeCodes().add(masChargeCode);
	}

	/**
	 * Return the value associated with the column: StoreLoaninTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreLoaninT> getStoreLoaninTs() {
		return storeLoaninTs;
	}

	/**
	 * Set the value related to the column: StoreLoaninTs
	 * 
	 * @param storeLoaninTs
	 *            the StoreLoaninTs value
	 */
	public void setStoreLoaninTs(
			java.util.Set<jkt.hms.masters.business.StoreLoaninT> storeLoaninTs) {
		this.storeLoaninTs = storeLoaninTs;
	}

	public void addToStoreLoaninTs(
			jkt.hms.masters.business.StoreLoaninT storeLoaninT) {
		if (null == getStoreLoaninTs())
			setStoreLoaninTs(new java.util.TreeSet<jkt.hms.masters.business.StoreLoaninT>());
		getStoreLoaninTs().add(storeLoaninT);
	}

	/**
	 * Return the value associated with the column: StoreQuotationRequestTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreQuotationRequestT> getStoreQuotationRequestTs() {
		return storeQuotationRequestTs;
	}

	/**
	 * Set the value related to the column: StoreQuotationRequestTs
	 * 
	 * @param storeQuotationRequestTs
	 *            the StoreQuotationRequestTs value
	 */
	public void setStoreQuotationRequestTs(
			java.util.Set<jkt.hms.masters.business.StoreQuotationRequestT> storeQuotationRequestTs) {
		this.storeQuotationRequestTs = storeQuotationRequestTs;
	}

	public void addToStoreQuotationRequestTs(
			jkt.hms.masters.business.StoreQuotationRequestT storeQuotationRequestT) {
		if (null == getStoreQuotationRequestTs())
			setStoreQuotationRequestTs(new java.util.TreeSet<jkt.hms.masters.business.StoreQuotationRequestT>());
		getStoreQuotationRequestTs().add(storeQuotationRequestT);
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
		if (!(obj instanceof jkt.hms.masters.business.MasUnitOfMeasurement))
			return false;
		else {
			jkt.hms.masters.business.MasUnitOfMeasurement masUnitOfMeasurement = (jkt.hms.masters.business.MasUnitOfMeasurement) obj;
			if (null == this.getId() || null == masUnitOfMeasurement.getId())
				return false;
			else
				return (this.getId().equals(masUnitOfMeasurement.getId()));
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
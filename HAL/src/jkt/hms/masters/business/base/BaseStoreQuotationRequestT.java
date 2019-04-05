package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the store_quotation_request_t table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="store_quotation_request_t"
 */

public abstract class BaseStoreQuotationRequestT  implements Serializable {

	public static String REF = "StoreQuotationRequestT";
	public static String PROP_UNIT_OF_MEASUREMENT = "UnitOfMeasurement";
	public static String PROP_MANUFACTURER = "Manufacturer";
	public static String PROP_ITEM = "Item";
	public static String PROP_SERIAL_NO = "SerialNo";
	public static String PROP_MPR_DETAILS = "MprDetails";
	public static String PROP_ID = "Id";
	public static String PROP_MASTER = "Master";
	public static String PROP_REQUESTED_QTY = "RequestedQty";


	// constructors
	public BaseStoreQuotationRequestT () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreQuotationRequestT (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer serialNo;
	private java.math.BigDecimal requestedQty;

	// many to one
	private jkt.hms.masters.business.MasStoreItem item;
	private jkt.hms.masters.business.StoreQuotationRequestM master;
	private jkt.hms.masters.business.MasManufacturer manufacturer;
	private jkt.hms.masters.business.MasUnitOfMeasurement unitOfMeasurement;
	private jkt.hms.masters.business.StoreMaterialPurchaseReqT mprDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="transaction_id"
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
	 * Return the value associated with the column: serial_no
	 */
	public java.lang.Integer getSerialNo () {
		return serialNo;
	}

	/**
	 * Set the value related to the column: serial_no
	 * @param serialNo the serial_no value
	 */
	public void setSerialNo (java.lang.Integer serialNo) {
		this.serialNo = serialNo;
	}



	/**
	 * Return the value associated with the column: requested_qty
	 */
	public java.math.BigDecimal getRequestedQty () {
		return requestedQty;
	}

	/**
	 * Set the value related to the column: requested_qty
	 * @param requestedQty the requested_qty value
	 */
	public void setRequestedQty (java.math.BigDecimal requestedQty) {
		this.requestedQty = requestedQty;
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
	 * Return the value associated with the column: master_id
	 */
	public jkt.hms.masters.business.StoreQuotationRequestM getMaster () {
		return master;
	}

	/**
	 * Set the value related to the column: master_id
	 * @param master the master_id value
	 */
	public void setMaster (jkt.hms.masters.business.StoreQuotationRequestM master) {
		this.master = master;
	}



	/**
	 * Return the value associated with the column: manufacturer_id
	 */
	public jkt.hms.masters.business.MasManufacturer getManufacturer () {
		return manufacturer;
	}

	/**
	 * Set the value related to the column: manufacturer_id
	 * @param manufacturer the manufacturer_id value
	 */
	public void setManufacturer (jkt.hms.masters.business.MasManufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}



	/**
	 * Return the value associated with the column: unit_of_measurement_id
	 */
	public jkt.hms.masters.business.MasUnitOfMeasurement getUnitOfMeasurement () {
		return unitOfMeasurement;
	}

	/**
	 * Set the value related to the column: unit_of_measurement_id
	 * @param unitOfMeasurement the unit_of_measurement_id value
	 */
	public void setUnitOfMeasurement (jkt.hms.masters.business.MasUnitOfMeasurement unitOfMeasurement) {
		this.unitOfMeasurement = unitOfMeasurement;
	}



	/**
	 * Return the value associated with the column: mpr_details_id
	 */
	public jkt.hms.masters.business.StoreMaterialPurchaseReqT getMprDetails () {
		return mprDetails;
	}

	/**
	 * Set the value related to the column: mpr_details_id
	 * @param mprDetails the mpr_details_id value
	 */
	public void setMprDetails (jkt.hms.masters.business.StoreMaterialPurchaseReqT mprDetails) {
		this.mprDetails = mprDetails;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreQuotationRequestT)) return false;
		else {
			jkt.hms.masters.business.StoreQuotationRequestT storeQuotationRequestT = (jkt.hms.masters.business.StoreQuotationRequestT) obj;
			if (null == this.getId() || null == storeQuotationRequestT.getId()) return false;
			else return (this.getId().equals(storeQuotationRequestT.getId()));
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
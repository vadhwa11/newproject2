package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the store_work_order_t table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="store_work_order_t"
 */

public abstract class BaseStoreWorkOrderT  implements Serializable {

	public static String REF = "StoreWorkOrderT";
	public static String PROP_PARTICULAR_EQUP_RV = "ParticularEqupRv";
	public static String PROP_QUANTITY = "Quantity";
	public static String PROP_ITEM = "Item";
	public static String PROP_SERIAL_NO = "SerialNo";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_ID = "Id";
	public static String PROP_WORK_ORDER_M = "WorkOrderM";
	public static String PROP_SR_NO = "SrNo";
	public static String PROP_NATURE_OF_WORK = "NatureOfWork";


	// constructors
	public BaseStoreWorkOrderT () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreWorkOrderT (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String srNo;
	private java.lang.String serialNo;
	private java.lang.Integer quantity;
	private java.lang.String natureOfWork;
	private java.lang.String remarks;
	private java.lang.String particularEqupRv;

	// many to one
	private jkt.hms.masters.business.MasStoreItem item;
	private jkt.hms.masters.business.StoreWorkOrderM workOrderM;



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
	 * Return the value associated with the column: sr_no
	 */
	public java.lang.String getSrNo () {
		return srNo;
	}

	/**
	 * Set the value related to the column: sr_no
	 * @param srNo the sr_no value
	 */
	public void setSrNo (java.lang.String srNo) {
		this.srNo = srNo;
	}



	/**
	 * Return the value associated with the column: serial_no
	 */
	public java.lang.String getSerialNo () {
		return serialNo;
	}

	/**
	 * Set the value related to the column: serial_no
	 * @param serialNo the serial_no value
	 */
	public void setSerialNo (java.lang.String serialNo) {
		this.serialNo = serialNo;
	}



	/**
	 * Return the value associated with the column: quantity
	 */
	public java.lang.Integer getQuantity () {
		return quantity;
	}

	/**
	 * Set the value related to the column: quantity
	 * @param quantity the quantity value
	 */
	public void setQuantity (java.lang.Integer quantity) {
		this.quantity = quantity;
	}



	/**
	 * Return the value associated with the column: nature_of_work
	 */
	public java.lang.String getNatureOfWork () {
		return natureOfWork;
	}

	/**
	 * Set the value related to the column: nature_of_work
	 * @param natureOfWork the nature_of_work value
	 */
	public void setNatureOfWork (java.lang.String natureOfWork) {
		this.natureOfWork = natureOfWork;
	}



	/**
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * @param remarks the remarks value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
	}



	/**
	 * Return the value associated with the column: particular_equp_rv
	 */
	public java.lang.String getParticularEqupRv () {
		return particularEqupRv;
	}

	/**
	 * Set the value related to the column: particular_equp_rv
	 * @param particularEqupRv the particular_equp_rv value
	 */
	public void setParticularEqupRv (java.lang.String particularEqupRv) {
		this.particularEqupRv = particularEqupRv;
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
	 * Return the value associated with the column: work_order_m_id
	 */
	public jkt.hms.masters.business.StoreWorkOrderM getWorkOrderM () {
		return workOrderM;
	}

	/**
	 * Set the value related to the column: work_order_m_id
	 * @param workOrderM the work_order_m_id value
	 */
	public void setWorkOrderM (jkt.hms.masters.business.StoreWorkOrderM workOrderM) {
		this.workOrderM = workOrderM;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreWorkOrderT)) return false;
		else {
			jkt.hms.masters.business.StoreWorkOrderT storeWorkOrderT = (jkt.hms.masters.business.StoreWorkOrderT) obj;
			if (null == this.getId() || null == storeWorkOrderT.getId()) return false;
			else return (this.getId().equals(storeWorkOrderT.getId()));
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
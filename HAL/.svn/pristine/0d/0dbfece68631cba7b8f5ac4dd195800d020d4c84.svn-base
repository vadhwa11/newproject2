package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the store_condemnation_t table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="store_condemnation_t"
 */

public abstract class BaseStoreCondemnationT  implements Serializable {

	public static String REF = "StoreCondemnationT";
	public static String PROP_QTY = "Qty";
	public static String PROP_ITEM = "Item";
	public static String PROP_CONDEM_M = "CondemM";
	public static String PROP_REASON_FOR_SENTENCE = "ReasonForSentence";
	public static String PROP_SERIAL_NO = "SerialNo";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_ID = "Id";
	public static String PROP_PART_NO = "PartNo";
	public static String PROP_SR_NO = "SrNo";


	// constructors
	public BaseStoreCondemnationT () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreCondemnationT (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseStoreCondemnationT (
		java.lang.Integer id,
		jkt.hms.masters.business.StoreCondemnationM condemM,
		jkt.hms.masters.business.MasStoreItem item,
		java.lang.Integer srNo,
		java.lang.String serialNo,
		java.lang.Integer qty,
		java.lang.String reasonForSentence,
		java.lang.String remarks) {

		this.setId(id);
		this.setCondemM(condemM);
		this.setItem(item);
		this.setSrNo(srNo);
		this.setSerialNo(serialNo);
		this.setQty(qty);
		this.setReasonForSentence(reasonForSentence);
		this.setRemarks(remarks);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer srNo;
	private java.lang.String serialNo;
	private java.lang.String partNo;
	private java.lang.Integer qty;
	private java.lang.String reasonForSentence;
	private java.lang.String remarks;

	// many to one
	private jkt.hms.masters.business.StoreCondemnationM condemM;
	private jkt.hms.masters.business.MasStoreItem item;



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
	 * Return the value associated with the column: part_no
	 */
	public java.lang.String getPartNo () {
		return partNo;
	}

	/**
	 * Set the value related to the column: part_no
	 * @param partNo the part_no value
	 */
	public void setPartNo (java.lang.String partNo) {
		this.partNo = partNo;
	}



	/**
	 * Return the value associated with the column: qty
	 */
	public java.lang.Integer getQty () {
		return qty;
	}

	/**
	 * Set the value related to the column: qty
	 * @param qty the qty value
	 */
	public void setQty (java.lang.Integer qty) {
		this.qty = qty;
	}



	/**
	 * Return the value associated with the column: reason_for_sentence
	 */
	public java.lang.String getReasonForSentence () {
		return reasonForSentence;
	}

	/**
	 * Set the value related to the column: reason_for_sentence
	 * @param reasonForSentence the reason_for_sentence value
	 */
	public void setReasonForSentence (java.lang.String reasonForSentence) {
		this.reasonForSentence = reasonForSentence;
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
	 * Return the value associated with the column: condem_m_id
	 */
	public jkt.hms.masters.business.StoreCondemnationM getCondemM () {
		return condemM;
	}

	/**
	 * Set the value related to the column: condem_m_id
	 * @param condemM the condem_m_id value
	 */
	public void setCondemM (jkt.hms.masters.business.StoreCondemnationM condemM) {
		this.condemM = condemM;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreCondemnationT)) return false;
		else {
			jkt.hms.masters.business.StoreCondemnationT storeCondemnationT = (jkt.hms.masters.business.StoreCondemnationT) obj;
			if (null == this.getId() || null == storeCondemnationT.getId()) return false;
			else return (this.getId().equals(storeCondemnationT.getId()));
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
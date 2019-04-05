package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the cssd_autoclave_entry_t
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="cssd_autoclave_entry_t"
 */

public abstract class BaseCssdAutoclaveEntryT implements Serializable {

	public static String REF = "CssdAutoclaveEntryT";
	public static String PROP_RECEIPT_STATUS = "ReceiptStatus";
	public static String PROP_QTY = "Qty";
	public static String PROP_ENTRY_M = "EntryM";
	public static String PROP_MATERIAL = "Material";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_ID = "Id";
	public static String PROP_REQUEST = "Request";
	public static String PROP_INSTRUMENT = "Instrument";

	// constructors
	public BaseCssdAutoclaveEntryT() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCssdAutoclaveEntryT(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCssdAutoclaveEntryT(java.lang.Integer id,
			jkt.hms.masters.business.CssdAutoclaveRequestM request,
			jkt.hms.masters.business.CssdInstrumentMaster instrument,
			jkt.hms.masters.business.CssdAutoclaveEntryM entryM,
			jkt.hms.masters.business.CssdMaterialMaster material,
			java.lang.Integer qty, java.lang.String receiptStatus) {

		this.setId(id);
		this.setRequest(request);
		this.setInstrument(instrument);
		this.setEntryM(entryM);
		this.setMaterial(material);
		this.setQty(qty);
		this.setReceiptStatus(receiptStatus);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer qty;
	private java.lang.String remarks;
	private java.lang.String receiptStatus;

	// many to one
	private jkt.hms.masters.business.CssdAutoclaveRequestM request;
	private jkt.hms.masters.business.CssdInstrumentMaster instrument;
	private jkt.hms.masters.business.CssdAutoclaveEntryM entryM;
	private jkt.hms.masters.business.CssdMaterialMaster material;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="id"
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
	 * Return the value associated with the column: qty
	 */
	public java.lang.Integer getQty() {
		return qty;
	}

	/**
	 * Set the value related to the column: qty
	 * 
	 * @param qty
	 *            the qty value
	 */
	public void setQty(java.lang.Integer qty) {
		this.qty = qty;
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
	 * Return the value associated with the column: receipt_status
	 */
	public java.lang.String getReceiptStatus() {
		return receiptStatus;
	}

	/**
	 * Set the value related to the column: receipt_status
	 * 
	 * @param receiptStatus
	 *            the receipt_status value
	 */
	public void setReceiptStatus(java.lang.String receiptStatus) {
		this.receiptStatus = receiptStatus;
	}

	/**
	 * Return the value associated with the column: request_id
	 */
	public jkt.hms.masters.business.CssdAutoclaveRequestM getRequest() {
		return request;
	}

	/**
	 * Set the value related to the column: request_id
	 * 
	 * @param request
	 *            the request_id value
	 */
	public void setRequest(
			jkt.hms.masters.business.CssdAutoclaveRequestM request) {
		this.request = request;
	}

	/**
	 * Return the value associated with the column: instrument_id
	 */
	public jkt.hms.masters.business.CssdInstrumentMaster getInstrument() {
		return instrument;
	}

	/**
	 * Set the value related to the column: instrument_id
	 * 
	 * @param instrument
	 *            the instrument_id value
	 */
	public void setInstrument(
			jkt.hms.masters.business.CssdInstrumentMaster instrument) {
		this.instrument = instrument;
	}

	/**
	 * Return the value associated with the column: entry_m_id
	 */
	public jkt.hms.masters.business.CssdAutoclaveEntryM getEntryM() {
		return entryM;
	}

	/**
	 * Set the value related to the column: entry_m_id
	 * 
	 * @param entryM
	 *            the entry_m_id value
	 */
	public void setEntryM(jkt.hms.masters.business.CssdAutoclaveEntryM entryM) {
		this.entryM = entryM;
	}

	/**
	 * Return the value associated with the column: material_id
	 */
	public jkt.hms.masters.business.CssdMaterialMaster getMaterial() {
		return material;
	}

	/**
	 * Set the value related to the column: material_id
	 * 
	 * @param material
	 *            the material_id value
	 */
	public void setMaterial(jkt.hms.masters.business.CssdMaterialMaster material) {
		this.material = material;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.CssdAutoclaveEntryT))
			return false;
		else {
			jkt.hms.masters.business.CssdAutoclaveEntryT cssdAutoclaveEntryT = (jkt.hms.masters.business.CssdAutoclaveEntryT) obj;
			if (null == this.getId() || null == cssdAutoclaveEntryT.getId())
				return false;
			else
				return (this.getId().equals(cssdAutoclaveEntryT.getId()));
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
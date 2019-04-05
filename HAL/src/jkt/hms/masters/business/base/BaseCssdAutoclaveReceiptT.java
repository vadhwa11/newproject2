package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the cssd_autoclave_receipt_t
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="cssd_autoclave_receipt_t"
 */

public abstract class BaseCssdAutoclaveReceiptT implements Serializable {

	public static String REF = "CssdAutoclaveReceiptT";
	public static String PROP_QTY = "Qty";
	public static String PROP_RESULT = "Result";
	public static String PROP_ENTRY_M = "EntryM";
	public static String PROP_RECALL_STATUS = "RecallStatus";
	public static String PROP_RECEIPT_M = "ReceiptM";
	public static String PROP_MATERIAL = "Material";
	public static String PROP_ID = "Id";
	public static String PROP_INTEGRATOR = "Integrator";
	public static String PROP_INSTRUMENT = "Instrument";

	// constructors
	public BaseCssdAutoclaveReceiptT() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCssdAutoclaveReceiptT(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCssdAutoclaveReceiptT(java.lang.Integer id,
			jkt.hms.masters.business.CssdInstrumentMaster instrument,
			jkt.hms.masters.business.CssdAutoclaveEntryM entryM,
			jkt.hms.masters.business.CssdMaterialMaster material,
			java.lang.Integer qty, java.lang.String integrator,
			java.lang.String recallStatus) {

		this.setId(id);
		this.setInstrument(instrument);
		this.setEntryM(entryM);
		this.setMaterial(material);
		this.setQty(qty);
		this.setIntegrator(integrator);
		this.setRecallStatus(recallStatus);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer qty;
	private java.lang.String integrator;
	private java.lang.String result;
	private java.lang.String recallStatus;

	// many to one
	private jkt.hms.masters.business.CssdAutoclaveReceiptM receiptM;
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
	 * Return the value associated with the column: integrator
	 */
	public java.lang.String getIntegrator() {
		return integrator;
	}

	/**
	 * Set the value related to the column: integrator
	 * 
	 * @param integrator
	 *            the integrator value
	 */
	public void setIntegrator(java.lang.String integrator) {
		this.integrator = integrator;
	}

	/**
	 * Return the value associated with the column: result
	 */
	public java.lang.String getResult() {
		return result;
	}

	/**
	 * Set the value related to the column: result
	 * 
	 * @param result
	 *            the result value
	 */
	public void setResult(java.lang.String result) {
		this.result = result;
	}

	/**
	 * Return the value associated with the column: recall_status
	 */
	public java.lang.String getRecallStatus() {
		return recallStatus;
	}

	/**
	 * Set the value related to the column: recall_status
	 * 
	 * @param recallStatus
	 *            the recall_status value
	 */
	public void setRecallStatus(java.lang.String recallStatus) {
		this.recallStatus = recallStatus;
	}

	/**
	 * Return the value associated with the column: receipt_m_id
	 */
	public jkt.hms.masters.business.CssdAutoclaveReceiptM getReceiptM() {
		return receiptM;
	}

	/**
	 * Set the value related to the column: receipt_m_id
	 * 
	 * @param receiptM
	 *            the receipt_m_id value
	 */
	public void setReceiptM(
			jkt.hms.masters.business.CssdAutoclaveReceiptM receiptM) {
		this.receiptM = receiptM;
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
		if (!(obj instanceof jkt.hms.masters.business.CssdAutoclaveReceiptT))
			return false;
		else {
			jkt.hms.masters.business.CssdAutoclaveReceiptT cssdAutoclaveReceiptT = (jkt.hms.masters.business.CssdAutoclaveReceiptT) obj;
			if (null == this.getId() || null == cssdAutoclaveReceiptT.getId())
				return false;
			else
				return (this.getId().equals(cssdAutoclaveReceiptT.getId()));
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
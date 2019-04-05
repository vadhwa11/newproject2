package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the patient_prescription_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="patient_prescription_details"
 */

public abstract class BasePatientPrescriptionDetails  implements Serializable {

	public static String REF = "PatientPrescriptionDetails";
	public static String PROP_DETAIL_STATUS = "DetailStatus";
	public static String PROP_NIS_NO = "NisNo";
	public static String PROP_TYPE = "Type";
	public static String PROP_INJECTION_STATUS = "InjectionStatus";
	public static String PROP_RC_HEADER = "RcHeader";
	public static String PROP_ISSUED_STATUS = "IssuedStatus";
	public static String PROP_PRESCRIPTION = "Prescription";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_CT = "Ct";
	public static String PROP_INSTRUCTION = "Instruction";
	public static String PROP_NURSING_STATUS = "NursingStatus";
	public static String PROP_BATCH_EXPIRY_DATE = "BatchExpiryDate";
	public static String PROP_ITEM = "Item";
	public static String PROP_SO_ITEM = "SoItem";
	public static String PROP_SO_QTY = "SoQty";
	public static String PROP_OT_STAGE = "OtStage";
	public static String PROP_H_L7_FLAG = "HL7Flag";
	public static String PROP_FREQUENCY = "Frequency";
	public static String PROP_ROUTE = "Route";
	public static String PROP_ITEM_STOP_STATUS = "ItemStopStatus";
	public static String PROP_SO_ID = "SoId";
	public static String PROP_NIP_NO = "NipNo";
	public static String PROP_ITEM_STOP_DATE = "ItemStopDate";
	public static String PROP_INJ_GIVEN_QTY = "InjGivenQty";
	public static String PROP_LO_QTY = "LoQty";
	public static String PROP_NO_OF_DAYS = "NoOfDays";
	public static String PROP_ITEM_STOP_BY = "ItemStopBy";
	public static String PROP_GIVEN_QTY = "GivenQty";
	public static String PROP_LO_ITEM = "LoItem";
	public static String PROP_LO_ID = "LoId";
	public static String PROP_RC_QTY = "RcQty";
	public static String PROP_DOSAGE = "Dosage";
	public static String PROP_ID = "Id";
	public static String PROP_REMAINING_QTY = "RemainingQty";
	public static String PROP_QTY_BALANCE = "QtyBalance";
	public static String PROP_QTY_ISSUED = "QtyIssued";
	public static String PROP_TOTAL = "Total";


	// constructors
	public BasePatientPrescriptionDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePatientPrescriptionDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String dosage;
	private java.lang.Integer noOfDays;
	private java.lang.Integer total;
	private java.lang.String type;
	private java.lang.String instruction;
	private java.lang.String remarks;
	private java.lang.String detailStatus;
	private java.lang.Integer qtyIssued;
	private java.lang.Integer qtyBalance;
	private java.lang.String route;
	private java.lang.String soItem;
	private java.lang.String soId;
	private java.lang.Integer soQty;
	private java.lang.String loItem;
	private java.lang.String loId;
	private java.lang.Integer loQty;
	private java.lang.Integer givenQty;
	private java.lang.String injectionStatus;
	private java.lang.Integer injGivenQty;
	private java.lang.String ct;
	private java.lang.String issuedStatus;
	private java.lang.String nursingStatus;
	private java.lang.String itemStopStatus;
	private java.util.Date itemStopDate;
	private java.lang.String hL7Flag;
	private java.lang.Integer rcQty;
	private java.lang.String nisNo;
	private java.lang.String nipNo;
	private java.lang.String otStage;
	private java.lang.String batchExpiryDate;
	private java.math.BigDecimal remainingQty;

	// many to one
	private jkt.hms.masters.business.MasFrequency frequency;
	private jkt.hms.masters.business.MasStoreItem item;
	private jkt.hms.masters.business.PatientPrescriptionHeader prescription;
	private jkt.hms.masters.business.RcHeader rcHeader;
	private jkt.hms.masters.business.MasEmployee itemStopBy;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
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
	 * Return the value associated with the column: dosage
	 */
	public java.lang.String getDosage () {
		return dosage;
	}

	/**
	 * Set the value related to the column: dosage
	 * @param dosage the dosage value
	 */
	public void setDosage (java.lang.String dosage) {
		this.dosage = dosage;
	}



	/**
	 * Return the value associated with the column: no_of_days
	 */
	public java.lang.Integer getNoOfDays () {
		return noOfDays;
	}

	/**
	 * Set the value related to the column: no_of_days
	 * @param noOfDays the no_of_days value
	 */
	public void setNoOfDays (java.lang.Integer noOfDays) {
		this.noOfDays = noOfDays;
	}



	/**
	 * Return the value associated with the column: total
	 */
	public java.lang.Integer getTotal () {
		return total;
	}

	/**
	 * Set the value related to the column: total
	 * @param total the total value
	 */
	public void setTotal (java.lang.Integer total) {
		this.total = total;
	}



	/**
	 * Return the value associated with the column: type
	 */
	public java.lang.String getType () {
		return type;
	}

	/**
	 * Set the value related to the column: type
	 * @param type the type value
	 */
	public void setType (java.lang.String type) {
		this.type = type;
	}



	/**
	 * Return the value associated with the column: instruction
	 */
	public java.lang.String getInstruction () {
		return instruction;
	}

	/**
	 * Set the value related to the column: instruction
	 * @param instruction the instruction value
	 */
	public void setInstruction (java.lang.String instruction) {
		this.instruction = instruction;
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
	 * Return the value associated with the column: detail_status
	 */
	public java.lang.String getDetailStatus () {
		return detailStatus;
	}

	/**
	 * Set the value related to the column: detail_status
	 * @param detailStatus the detail_status value
	 */
	public void setDetailStatus (java.lang.String detailStatus) {
		this.detailStatus = detailStatus;
	}



	/**
	 * Return the value associated with the column: qty_issued
	 */
	public java.lang.Integer getQtyIssued () {
		return qtyIssued;
	}

	/**
	 * Set the value related to the column: qty_issued
	 * @param qtyIssued the qty_issued value
	 */
	public void setQtyIssued (java.lang.Integer qtyIssued) {
		this.qtyIssued = qtyIssued;
	}



	/**
	 * Return the value associated with the column: qty_balance
	 */
	public java.lang.Integer getQtyBalance () {
		return qtyBalance;
	}

	/**
	 * Set the value related to the column: qty_balance
	 * @param qtyBalance the qty_balance value
	 */
	public void setQtyBalance (java.lang.Integer qtyBalance) {
		this.qtyBalance = qtyBalance;
	}



	/**
	 * Return the value associated with the column: ROUTE
	 */
	public java.lang.String getRoute () {
		return route;
	}

	/**
	 * Set the value related to the column: ROUTE
	 * @param route the ROUTE value
	 */
	public void setRoute (java.lang.String route) {
		this.route = route;
	}



	/**
	 * Return the value associated with the column: SO_ITEM
	 */
	public java.lang.String getSoItem () {
		return soItem;
	}

	/**
	 * Set the value related to the column: SO_ITEM
	 * @param soItem the SO_ITEM value
	 */
	public void setSoItem (java.lang.String soItem) {
		this.soItem = soItem;
	}



	/**
	 * Return the value associated with the column: SO_ID
	 */
	public java.lang.String getSoId () {
		return soId;
	}

	/**
	 * Set the value related to the column: SO_ID
	 * @param soId the SO_ID value
	 */
	public void setSoId (java.lang.String soId) {
		this.soId = soId;
	}



	/**
	 * Return the value associated with the column: SO_QTY
	 */
	public java.lang.Integer getSoQty () {
		return soQty;
	}

	/**
	 * Set the value related to the column: SO_QTY
	 * @param soQty the SO_QTY value
	 */
	public void setSoQty (java.lang.Integer soQty) {
		this.soQty = soQty;
	}



	/**
	 * Return the value associated with the column: LO_ITEM
	 */
	public java.lang.String getLoItem () {
		return loItem;
	}

	/**
	 * Set the value related to the column: LO_ITEM
	 * @param loItem the LO_ITEM value
	 */
	public void setLoItem (java.lang.String loItem) {
		this.loItem = loItem;
	}



	/**
	 * Return the value associated with the column: LO_ID
	 */
	public java.lang.String getLoId () {
		return loId;
	}

	/**
	 * Set the value related to the column: LO_ID
	 * @param loId the LO_ID value
	 */
	public void setLoId (java.lang.String loId) {
		this.loId = loId;
	}



	/**
	 * Return the value associated with the column: LO_QTY
	 */
	public java.lang.Integer getLoQty () {
		return loQty;
	}

	/**
	 * Set the value related to the column: LO_QTY
	 * @param loQty the LO_QTY value
	 */
	public void setLoQty (java.lang.Integer loQty) {
		this.loQty = loQty;
	}



	/**
	 * Return the value associated with the column: GIVEN_QTY
	 */
	public java.lang.Integer getGivenQty () {
		return givenQty;
	}

	/**
	 * Set the value related to the column: GIVEN_QTY
	 * @param givenQty the GIVEN_QTY value
	 */
	public void setGivenQty (java.lang.Integer givenQty) {
		this.givenQty = givenQty;
	}



	/**
	 * Return the value associated with the column: injection_status
	 */
	public java.lang.String getInjectionStatus () {
		return injectionStatus;
	}

	/**
	 * Set the value related to the column: injection_status
	 * @param injectionStatus the injection_status value
	 */
	public void setInjectionStatus (java.lang.String injectionStatus) {
		this.injectionStatus = injectionStatus;
	}



	/**
	 * Return the value associated with the column: inj_given_qty
	 */
	public java.lang.Integer getInjGivenQty () {
		return injGivenQty;
	}

	/**
	 * Set the value related to the column: inj_given_qty
	 * @param injGivenQty the inj_given_qty value
	 */
	public void setInjGivenQty (java.lang.Integer injGivenQty) {
		this.injGivenQty = injGivenQty;
	}



	/**
	 * Return the value associated with the column: CT
	 */
	public java.lang.String getCt () {
		return ct;
	}

	/**
	 * Set the value related to the column: CT
	 * @param ct the CT value
	 */
	public void setCt (java.lang.String ct) {
		this.ct = ct;
	}



	/**
	 * Return the value associated with the column: issued_status
	 */
	public java.lang.String getIssuedStatus () {
		return issuedStatus;
	}

	/**
	 * Set the value related to the column: issued_status
	 * @param issuedStatus the issued_status value
	 */
	public void setIssuedStatus (java.lang.String issuedStatus) {
		this.issuedStatus = issuedStatus;
	}



	/**
	 * Return the value associated with the column: nursing_status
	 */
	public java.lang.String getNursingStatus () {
		return nursingStatus;
	}

	/**
	 * Set the value related to the column: nursing_status
	 * @param nursingStatus the nursing_status value
	 */
	public void setNursingStatus (java.lang.String nursingStatus) {
		this.nursingStatus = nursingStatus;
	}



	/**
	 * Return the value associated with the column: item_stop_status
	 */
	public java.lang.String getItemStopStatus () {
		return itemStopStatus;
	}

	/**
	 * Set the value related to the column: item_stop_status
	 * @param itemStopStatus the item_stop_status value
	 */
	public void setItemStopStatus (java.lang.String itemStopStatus) {
		this.itemStopStatus = itemStopStatus;
	}



	/**
	 * Return the value associated with the column: item_stop_date
	 */
	public java.util.Date getItemStopDate () {
		return itemStopDate;
	}

	/**
	 * Set the value related to the column: item_stop_date
	 * @param itemStopDate the item_stop_date value
	 */
	public void setItemStopDate (java.util.Date itemStopDate) {
		this.itemStopDate = itemStopDate;
	}



	/**
	 * Return the value associated with the column: HL7_flag
	 */
	public java.lang.String getHL7Flag () {
		return hL7Flag;
	}

	/**
	 * Set the value related to the column: HL7_flag
	 * @param hL7Flag the HL7_flag value
	 */
	public void setHL7Flag (java.lang.String hL7Flag) {
		this.hL7Flag = hL7Flag;
	}



	/**
	 * Return the value associated with the column: rc_qty
	 */
	public java.lang.Integer getRcQty () {
		return rcQty;
	}

	/**
	 * Set the value related to the column: rc_qty
	 * @param rcQty the rc_qty value
	 */
	public void setRcQty (java.lang.Integer rcQty) {
		this.rcQty = rcQty;
	}



	/**
	 * Return the value associated with the column: nis_no
	 */
	public java.lang.String getNisNo () {
		return nisNo;
	}

	/**
	 * Set the value related to the column: nis_no
	 * @param nisNo the nis_no value
	 */
	public void setNisNo (java.lang.String nisNo) {
		this.nisNo = nisNo;
	}



	/**
	 * Return the value associated with the column: nip_no
	 */
	public java.lang.String getNipNo () {
		return nipNo;
	}

	/**
	 * Set the value related to the column: nip_no
	 * @param nipNo the nip_no value
	 */
	public void setNipNo (java.lang.String nipNo) {
		this.nipNo = nipNo;
	}



	/**
	 * Return the value associated with the column: ot_stage
	 */
	public java.lang.String getOtStage () {
		return otStage;
	}

	/**
	 * Set the value related to the column: ot_stage
	 * @param otStage the ot_stage value
	 */
	public void setOtStage (java.lang.String otStage) {
		this.otStage = otStage;
	}



	/**
	 * Return the value associated with the column: batch_expiry_date
	 */
	public java.lang.String getBatchExpiryDate () {
		return batchExpiryDate;
	}

	/**
	 * Set the value related to the column: batch_expiry_date
	 * @param batchExpiryDate the batch_expiry_date value
	 */
	public void setBatchExpiryDate (java.lang.String batchExpiryDate) {
		this.batchExpiryDate = batchExpiryDate;
	}



	/**
	 * Return the value associated with the column: remaining_qty
	 */
	public java.math.BigDecimal getRemainingQty () {
		return remainingQty;
	}

	/**
	 * Set the value related to the column: remaining_qty
	 * @param remainingQty the remaining_qty value
	 */
	public void setRemainingQty (java.math.BigDecimal remainingQty) {
		this.remainingQty = remainingQty;
	}



	/**
	 * Return the value associated with the column: frequency_id
	 */
	public jkt.hms.masters.business.MasFrequency getFrequency () {
		return frequency;
	}

	/**
	 * Set the value related to the column: frequency_id
	 * @param frequency the frequency_id value
	 */
	public void setFrequency (jkt.hms.masters.business.MasFrequency frequency) {
		this.frequency = frequency;
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
	 * Return the value associated with the column: prescription_id
	 */
	public jkt.hms.masters.business.PatientPrescriptionHeader getPrescription () {
		return prescription;
	}

	/**
	 * Set the value related to the column: prescription_id
	 * @param prescription the prescription_id value
	 */
	public void setPrescription (jkt.hms.masters.business.PatientPrescriptionHeader prescription) {
		this.prescription = prescription;
	}



	/**
	 * Return the value associated with the column: rc_header_id
	 */
	public jkt.hms.masters.business.RcHeader getRcHeader () {
		return rcHeader;
	}

	/**
	 * Set the value related to the column: rc_header_id
	 * @param rcHeader the rc_header_id value
	 */
	public void setRcHeader (jkt.hms.masters.business.RcHeader rcHeader) {
		this.rcHeader = rcHeader;
	}



	/**
	 * Return the value associated with the column: item_stop_by
	 */
	public jkt.hms.masters.business.MasEmployee getItemStopBy () {
		return itemStopBy;
	}

	/**
	 * Set the value related to the column: item_stop_by
	 * @param itemStopBy the item_stop_by value
	 */
	public void setItemStopBy (jkt.hms.masters.business.MasEmployee itemStopBy) {
		this.itemStopBy = itemStopBy;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PatientPrescriptionDetails)) return false;
		else {
			jkt.hms.masters.business.PatientPrescriptionDetails patientPrescriptionDetails = (jkt.hms.masters.business.PatientPrescriptionDetails) obj;
			if (null == this.getId() || null == patientPrescriptionDetails.getId()) return false;
			else return (this.getId().equals(patientPrescriptionDetails.getId()));
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
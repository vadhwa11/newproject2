package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the dg_orderdt table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="dg_orderdt"
 */

public abstract class BaseDgOrderdt  implements Serializable {

	public static String REF = "DgOrderdt";
	public static String PROP_INVESTIGATION = "Investigation";
	public static String PROP_ORDER_STATUS = "OrderStatus";
	public static String PROP_CREATEDBY = "Createdby";
	public static String PROP_MAIN_CHARGECODE = "MainChargecode";
	public static String PROP_APPOINTMENT_DATE = "AppointmentDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_CREATEDON = "Createdon";
	public static String PROP_OT_REMARKS = "OtRemarks";
	public static String PROP_BILLING_STATUS = "BillingStatus";
	public static String PROP_CHARGE_COST = "ChargeCost";
	public static String PROP_HL7_FLAG = "Hl7Flag";
	public static String PROP_SUB_CHARGEID = "SubChargeid";
	public static String PROP_MSG_SENT = "MsgSent";
	public static String PROP_BILL = "Bill";
	public static String PROP_ORDER_QTY = "OrderQty";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_CHARGE_CODE = "ChargeCode";
	public static String PROP_ORDERHD = "Orderhd";
	public static String PROP_OT_STAGE = "OtStage";
	public static String PROP_REFER_TO_MH = "ReferToMh";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_INVESTIGATION_TO_MH = "InvestigationToMh";


	// constructors
	public BaseDgOrderdt () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDgOrderdt (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.math.BigDecimal chargeCost;
	private java.lang.Integer orderQty;
	private java.lang.String orderStatus;
	private java.lang.String createdby;
	private java.util.Date createdon;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String investigationToMh;
	private java.lang.String referToMh;
	private java.util.Date appointmentDate;
	private java.lang.String hl7Flag;
	private java.lang.String billingStatus;
	private java.lang.String msgSent;
	private java.lang.String otRemarks;
	private java.lang.String otStage;

	// many to one
	private jkt.hms.masters.business.MasChargeCode chargeCode;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasMainChargecode mainChargecode;
	private jkt.hms.masters.business.DgMasInvestigation investigation;
	private jkt.hms.masters.business.DgOrderhd orderhd;
	private jkt.hms.masters.business.BlOpBillHeader bill;
	private jkt.hms.masters.business.MasSubChargecode subChargeid;

	// collections
	private java.util.Set<jkt.hms.masters.business.DgSampleCollectionDetails> dgSampleCollectionDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="orderdt_id"
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
	 * Return the value associated with the column: charge_cost
	 */
	public java.math.BigDecimal getChargeCost () {
		return chargeCost;
	}

	/**
	 * Set the value related to the column: charge_cost
	 * @param chargeCost the charge_cost value
	 */
	public void setChargeCost (java.math.BigDecimal chargeCost) {
		this.chargeCost = chargeCost;
	}



	/**
	 * Return the value associated with the column: order_qty
	 */
	public java.lang.Integer getOrderQty () {
		return orderQty;
	}

	/**
	 * Set the value related to the column: order_qty
	 * @param orderQty the order_qty value
	 */
	public void setOrderQty (java.lang.Integer orderQty) {
		this.orderQty = orderQty;
	}



	/**
	 * Return the value associated with the column: order_status
	 */
	public java.lang.String getOrderStatus () {
		return orderStatus;
	}

	/**
	 * Set the value related to the column: order_status
	 * @param orderStatus the order_status value
	 */
	public void setOrderStatus (java.lang.String orderStatus) {
		this.orderStatus = orderStatus;
	}



	/**
	 * Return the value associated with the column: CREATEDBY
	 */
	public java.lang.String getCreatedby () {
		return createdby;
	}

	/**
	 * Set the value related to the column: CREATEDBY
	 * @param createdby the CREATEDBY value
	 */
	public void setCreatedby (java.lang.String createdby) {
		this.createdby = createdby;
	}



	/**
	 * Return the value associated with the column: CREATEDON
	 */
	public java.util.Date getCreatedon () {
		return createdon;
	}

	/**
	 * Set the value related to the column: CREATEDON
	 * @param createdon the CREATEDON value
	 */
	public void setCreatedon (java.util.Date createdon) {
		this.createdon = createdon;
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
	 * Return the value associated with the column: investigation_to_mh
	 */
	public java.lang.String getInvestigationToMh () {
		return investigationToMh;
	}

	/**
	 * Set the value related to the column: investigation_to_mh
	 * @param investigationToMh the investigation_to_mh value
	 */
	public void setInvestigationToMh (java.lang.String investigationToMh) {
		this.investigationToMh = investigationToMh;
	}



	/**
	 * Return the value associated with the column: refer_to_mh
	 */
	public java.lang.String getReferToMh () {
		return referToMh;
	}

	/**
	 * Set the value related to the column: refer_to_mh
	 * @param referToMh the refer_to_mh value
	 */
	public void setReferToMh (java.lang.String referToMh) {
		this.referToMh = referToMh;
	}



	/**
	 * Return the value associated with the column: appointment_date
	 */
	public java.util.Date getAppointmentDate () {
		return appointmentDate;
	}

	/**
	 * Set the value related to the column: appointment_date
	 * @param appointmentDate the appointment_date value
	 */
	public void setAppointmentDate (java.util.Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}



	/**
	 * Return the value associated with the column: HL7_flag
	 */
	public java.lang.String getHl7Flag () {
		return hl7Flag;
	}

	/**
	 * Set the value related to the column: HL7_flag
	 * @param hl7Flag the HL7_flag value
	 */
	public void setHl7Flag (java.lang.String hl7Flag) {
		this.hl7Flag = hl7Flag;
	}



	/**
	 * Return the value associated with the column: billing_status
	 */
	public java.lang.String getBillingStatus () {
		return billingStatus;
	}

	/**
	 * Set the value related to the column: billing_status
	 * @param billingStatus the billing_status value
	 */
	public void setBillingStatus (java.lang.String billingStatus) {
		this.billingStatus = billingStatus;
	}



	/**
	 * Return the value associated with the column: msg_sent
	 */
	public java.lang.String getMsgSent () {
		return msgSent;
	}

	/**
	 * Set the value related to the column: msg_sent
	 * @param msgSent the msg_sent value
	 */
	public void setMsgSent (java.lang.String msgSent) {
		this.msgSent = msgSent;
	}



	/**
	 * Return the value associated with the column: ot_remarks
	 */
	public java.lang.String getOtRemarks () {
		return otRemarks;
	}

	/**
	 * Set the value related to the column: ot_remarks
	 * @param otRemarks the ot_remarks value
	 */
	public void setOtRemarks (java.lang.String otRemarks) {
		this.otRemarks = otRemarks;
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
	 * Return the value associated with the column: charge_code_id
	 */
	public jkt.hms.masters.business.MasChargeCode getChargeCode () {
		return chargeCode;
	}

	/**
	 * Set the value related to the column: charge_code_id
	 * @param chargeCode the charge_code_id value
	 */
	public void setChargeCode (jkt.hms.masters.business.MasChargeCode chargeCode) {
		this.chargeCode = chargeCode;
	}



	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public jkt.hms.masters.business.Users getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (jkt.hms.masters.business.Users lastChgBy) {
		this.lastChgBy = lastChgBy;
	}



	/**
	 * Return the value associated with the column: main_chargecode_id
	 */
	public jkt.hms.masters.business.MasMainChargecode getMainChargecode () {
		return mainChargecode;
	}

	/**
	 * Set the value related to the column: main_chargecode_id
	 * @param mainChargecode the main_chargecode_id value
	 */
	public void setMainChargecode (jkt.hms.masters.business.MasMainChargecode mainChargecode) {
		this.mainChargecode = mainChargecode;
	}



	/**
	 * Return the value associated with the column: investigation_id
	 */
	public jkt.hms.masters.business.DgMasInvestigation getInvestigation () {
		return investigation;
	}

	/**
	 * Set the value related to the column: investigation_id
	 * @param investigation the investigation_id value
	 */
	public void setInvestigation (jkt.hms.masters.business.DgMasInvestigation investigation) {
		this.investigation = investigation;
	}



	/**
	 * Return the value associated with the column: orderhd_id
	 */
	public jkt.hms.masters.business.DgOrderhd getOrderhd () {
		return orderhd;
	}

	/**
	 * Set the value related to the column: orderhd_id
	 * @param orderhd the orderhd_id value
	 */
	public void setOrderhd (jkt.hms.masters.business.DgOrderhd orderhd) {
		this.orderhd = orderhd;
	}



	/**
	 * Return the value associated with the column: bill_id
	 */
	public jkt.hms.masters.business.BlOpBillHeader getBill () {
		return bill;
	}

	/**
	 * Set the value related to the column: bill_id
	 * @param bill the bill_id value
	 */
	public void setBill (jkt.hms.masters.business.BlOpBillHeader bill) {
		this.bill = bill;
	}



	/**
	 * Return the value associated with the column: sub_chargeid
	 */
	public jkt.hms.masters.business.MasSubChargecode getSubChargeid () {
		return subChargeid;
	}

	/**
	 * Set the value related to the column: sub_chargeid
	 * @param subChargeid the sub_chargeid value
	 */
	public void setSubChargeid (jkt.hms.masters.business.MasSubChargecode subChargeid) {
		this.subChargeid = subChargeid;
	}



	/**
	 * Return the value associated with the column: DgSampleCollectionDetails
	 */
	public java.util.Set<jkt.hms.masters.business.DgSampleCollectionDetails> getDgSampleCollectionDetails () {
		return dgSampleCollectionDetails;
	}

	/**
	 * Set the value related to the column: DgSampleCollectionDetails
	 * @param dgSampleCollectionDetails the DgSampleCollectionDetails value
	 */
	public void setDgSampleCollectionDetails (java.util.Set<jkt.hms.masters.business.DgSampleCollectionDetails> dgSampleCollectionDetails) {
		this.dgSampleCollectionDetails = dgSampleCollectionDetails;
	}

	public void addToDgSampleCollectionDetails (jkt.hms.masters.business.DgSampleCollectionDetails dgSampleCollectionDetails) {
		if (null == getDgSampleCollectionDetails()) setDgSampleCollectionDetails(new java.util.TreeSet<jkt.hms.masters.business.DgSampleCollectionDetails>());
		getDgSampleCollectionDetails().add(dgSampleCollectionDetails);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.DgOrderdt)) return false;
		else {
			jkt.hms.masters.business.DgOrderdt dgOrderdt = (jkt.hms.masters.business.DgOrderdt) obj;
			if (null == this.getId() || null == dgOrderdt.getId()) return false;
			else return (this.getId().equals(dgOrderdt.getId()));
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
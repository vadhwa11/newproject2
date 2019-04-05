package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the dg_sample_collection_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="dg_sample_collection_details"
 */

public abstract class BaseDgSampleCollectionDetails  implements Serializable {

	public static String REF = "DgSampleCollectionDetails";
	public static String PROP_MAINCHARGE = "Maincharge";
	public static String PROP_INVESTIGATION = "Investigation";
	public static String PROP_ORDER_STATUS = "OrderStatus";
	public static String PROP_VALIDATED = "Validated";
	public static String PROP_QUANTITY = "Quantity";
	public static String PROP_ORDERDT = "Orderdt";
	public static String PROP_DIAG_NO = "DiagNo";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_SAMPLE = "Sample";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_REJECTED = "Rejected";
	public static String PROP_SAMPLE_COLLECTION_HEADER = "SampleCollectionHeader";
	public static String PROP_SAMPLE_NO = "SampleNo";
	public static String PROP_COLLECTED = "Collected";
	public static String PROP_SAMPLE_COLL_DATETIME = "SampleCollDatetime";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_CHARGE_CODE = "ChargeCode";
	public static String PROP_SUBCHARGE = "Subcharge";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_COLLECTED_BY = "CollectedBy";
	public static String PROP_REASON = "Reason";


	// constructors
	public BaseDgSampleCollectionDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDgSampleCollectionDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String collected;
	private java.lang.String orderStatus;
	private java.lang.String remarks;
	private java.lang.String lastChgBy;
	private java.lang.String lastChgTime;
	private java.util.Date lastChgDate;
	private java.lang.String sampleNo;
	private java.lang.String validated;
	private java.lang.String reason;
	private java.lang.String diagNo;
	private java.util.Date sampleCollDatetime;
	private java.lang.String quantity;
	private java.lang.String rejected;
	private java.lang.String empanelledStatus;

	// many to one
	private jkt.hms.masters.business.MasSubChargecode subcharge;
	private jkt.hms.masters.business.DgSampleCollectionHeader sampleCollectionHeader;
	private jkt.hms.masters.business.MasMainChargecode maincharge;
	private jkt.hms.masters.business.MasChargeCode chargeCode;
	private jkt.hms.masters.business.MasSample sample;
	private jkt.hms.masters.business.DgMasInvestigation investigation;
	private jkt.hms.masters.business.MasEmployee collectedBy;
	private jkt.hms.masters.business.DgOrderdt orderdt;
	private jkt.hms.masters.business.Users lastChangeBy;
	// collections
	private java.util.Set<jkt.hms.masters.business.DgResultEntryDetail> dgResultEntryDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="sample_collection_details_id"
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
	 * Return the value associated with the column: collected
	 */
	public java.lang.String getCollected () {
		return collected;
	}

	/**
	 * Set the value related to the column: collected
	 * @param collected the collected value
	 */
	public void setCollected (java.lang.String collected) {
		this.collected = collected;
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
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.String getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
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
	 * Return the value associated with the column: sample_no
	 */
	public java.lang.String getSampleNo () {
		return sampleNo;
	}

	/**
	 * Set the value related to the column: sample_no
	 * @param sampleNo the sample_no value
	 */
	public void setSampleNo (java.lang.String sampleNo) {
		this.sampleNo = sampleNo;
	}



	/**
	 * Return the value associated with the column: validated
	 */
	public java.lang.String getValidated () {
		return validated;
	}

	/**
	 * Set the value related to the column: validated
	 * @param validated the validated value
	 */
	public void setValidated (java.lang.String validated) {
		this.validated = validated;
	}



	/**
	 * Return the value associated with the column: reason
	 */
	public java.lang.String getReason () {
		return reason;
	}

	/**
	 * Set the value related to the column: reason
	 * @param reason the reason value
	 */
	public void setReason (java.lang.String reason) {
		this.reason = reason;
	}



	/**
	 * Return the value associated with the column: diag_no
	 */
	public java.lang.String getDiagNo () {
		return diagNo;
	}

	/**
	 * Set the value related to the column: diag_no
	 * @param diagNo the diag_no value
	 */
	public void setDiagNo (java.lang.String diagNo) {
		this.diagNo = diagNo;
	}



	/**
	 * Return the value associated with the column: sample_coll_datetime
	 */
	public java.util.Date getSampleCollDatetime () {
		return sampleCollDatetime;
	}

	/**
	 * Set the value related to the column: sample_coll_datetime
	 * @param sampleCollDatetime the sample_coll_datetime value
	 */
	public void setSampleCollDatetime (java.util.Date sampleCollDatetime) {
		this.sampleCollDatetime = sampleCollDatetime;
	}



	/**
	 * Return the value associated with the column: quantity
	 */
	public java.lang.String getQuantity () {
		return quantity;
	}

	/**
	 * Set the value related to the column: quantity
	 * @param quantity the quantity value
	 */
	public void setQuantity (java.lang.String quantity) {
		this.quantity = quantity;
	}



	/**
	 * Return the value associated with the column: rejected
	 */
	public java.lang.String getRejected () {
		return rejected;
	}

	/**
	 * Set the value related to the column: rejected
	 * @param rejected the rejected value
	 */
	public void setRejected (java.lang.String rejected) {
		this.rejected = rejected;
	}



	/**
	 * Return the value associated with the column: subcharge
	 */
	public jkt.hms.masters.business.MasSubChargecode getSubcharge () {
		return subcharge;
	}

	/**
	 * Set the value related to the column: subcharge
	 * @param subcharge the subcharge value
	 */
	public void setSubcharge (jkt.hms.masters.business.MasSubChargecode subcharge) {
		this.subcharge = subcharge;
	}



	/**
	 * Return the value associated with the column: sample_collection_header_id
	 */
	public jkt.hms.masters.business.DgSampleCollectionHeader getSampleCollectionHeader () {
		return sampleCollectionHeader;
	}

	/**
	 * Set the value related to the column: sample_collection_header_id
	 * @param sampleCollectionHeader the sample_collection_header_id value
	 */
	public void setSampleCollectionHeader (jkt.hms.masters.business.DgSampleCollectionHeader sampleCollectionHeader) {
		this.sampleCollectionHeader = sampleCollectionHeader;
	}



	/**
	 * Return the value associated with the column: maincharge
	 */
	public jkt.hms.masters.business.MasMainChargecode getMaincharge () {
		return maincharge;
	}

	/**
	 * Set the value related to the column: maincharge
	 * @param maincharge the maincharge value
	 */
	public void setMaincharge (jkt.hms.masters.business.MasMainChargecode maincharge) {
		this.maincharge = maincharge;
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
	 * Return the value associated with the column: sample_id
	 */
	public jkt.hms.masters.business.MasSample getSample () {
		return sample;
	}

	/**
	 * Set the value related to the column: sample_id
	 * @param sample the sample_id value
	 */
	public void setSample (jkt.hms.masters.business.MasSample sample) {
		this.sample = sample;
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
	 * Return the value associated with the column: collected_by
	 */
	public jkt.hms.masters.business.MasEmployee getCollectedBy () {
		return collectedBy;
	}

	/**
	 * Set the value related to the column: collected_by
	 * @param collectedBy the collected_by value
	 */
	public void setCollectedBy (jkt.hms.masters.business.MasEmployee collectedBy) {
		this.collectedBy = collectedBy;
	}



	/**
	 * Return the value associated with the column: orderdt_id
	 */
	public jkt.hms.masters.business.DgOrderdt getOrderdt () {
		return orderdt;
	}

	/**
	 * Set the value related to the column: orderdt_id
	 * @param orderdt the orderdt_id value
	 */
	public void setOrderdt (jkt.hms.masters.business.DgOrderdt orderdt) {
		this.orderdt = orderdt;
	}



	/**
	 * Return the value associated with the column: DgResultEntryDetails
	 */
	public java.util.Set<jkt.hms.masters.business.DgResultEntryDetail> getDgResultEntryDetails () {
		return dgResultEntryDetails;
	}

	/**
	 * Set the value related to the column: DgResultEntryDetails
	 * @param dgResultEntryDetails the DgResultEntryDetails value
	 */
	public void setDgResultEntryDetails (java.util.Set<jkt.hms.masters.business.DgResultEntryDetail> dgResultEntryDetails) {
		this.dgResultEntryDetails = dgResultEntryDetails;
	}

	public void addToDgResultEntryDetails (jkt.hms.masters.business.DgResultEntryDetail dgResultEntryDetail) {
		if (null == getDgResultEntryDetails()) setDgResultEntryDetails(new java.util.TreeSet<jkt.hms.masters.business.DgResultEntryDetail>());
		getDgResultEntryDetails().add(dgResultEntryDetail);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.DgSampleCollectionDetails)) return false;
		else {
			jkt.hms.masters.business.DgSampleCollectionDetails dgSampleCollectionDetails = (jkt.hms.masters.business.DgSampleCollectionDetails) obj;
			if (null == this.getId() || null == dgSampleCollectionDetails.getId()) return false;
			else return (this.getId().equals(dgSampleCollectionDetails.getId()));
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

	public jkt.hms.masters.business.Users getLastChangeBy() {
		return lastChangeBy;
	}

	public void setLastChangeBy(jkt.hms.masters.business.Users lastChangeBy) {
		this.lastChangeBy = lastChangeBy;
	}

	public java.lang.String getEmpanelledStatus() {
		return empanelledStatus;
	}

	public void setEmpanelledStatus(java.lang.String empanelledStatus) {
		this.empanelledStatus = empanelledStatus;
	}


}
package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the dg_mas_investigation table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="dg_mas_investigation"
 */

public abstract class BaseDgMasInvestigation  implements Serializable {

	public static String REF = "DgMasInvestigation";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_CONFIDENTIAL = "Confidential";
	public static String PROP_APPEAR_IN_DISCHARGE_SUMMARY = "AppearInDischargeSummary";
	public static String PROP_SUB_CHARGECODE = "SubChargecode";
	public static String PROP_MIN_NORMAL_VALUE = "MinNormalValue";
	public static String PROP_TEST_ORDER_NO = "TestOrderNo";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_CHARGE_CODE = "ChargeCode";
	public static String PROP_APPOINTMENT_REQUIRED = "AppointmentRequired";
	public static String PROP_BLOOD_BANK_SCREEN_TEST = "BloodBankScreenTest";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_CONTAINER = "Container";
	public static String PROP_EQUIPMENT = "Equipment";
	public static String PROP_QUANTITY = "Quantity";
	public static String PROP_MAIN_CHARGECODE = "MainChargecode";
	public static String PROP_NORMAL_VALUE = "NormalValue";
	public static String PROP_SAMPLE = "Sample";
	public static String PROP_MAX_NORMAL_VALUE = "MaxNormalValue";
	public static String PROP_INVESTIGATION_TYPE = "InvestigationType";
	public static String PROP_UOM = "Uom";
	public static String PROP_STATUS = "Status";
	public static String PROP_INVESTIGATION_NAME = "InvestigationName";
	public static String PROP_NUMERIC_OR_STRING = "NumericOrString";
	public static String PROP_MULTIPLE_RESULTS = "MultipleResults";
	public static String PROP_HIC_CODE = "HicCode";
	public static String PROP_INSTRUCTIONS = "Instructions";
	public static String PROP_ID = "Id";
	public static String PROP_BLOOD_REACTION_TEST = "BloodReactionTest";


	// constructors
	public BaseDgMasInvestigation () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDgMasInvestigation (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String investigationName;
	private java.lang.String status;
	private java.lang.String confidential;
	private java.lang.String appearInDischargeSummary;
	private java.lang.String investigationType;
	private java.lang.String multipleResults;
	private java.lang.String quantity;
	private java.lang.String normalValue;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String appointmentRequired;
	private java.lang.String maxNormalValue;
	private java.lang.String minNormalValue;
	private java.lang.Integer testOrderNo;
	private java.lang.String numericOrString;
	private java.lang.String hicCode;
	private java.lang.String bloodReactionTest;
	private java.lang.String bloodBankScreenTest;
	private java.lang.String instructions;

	// many to one
	private jkt.hms.masters.business.MasChargeCode chargeCode;
	private jkt.hms.masters.business.MasMainChargecode mainChargecode;
	private jkt.hms.masters.business.DgUom uom;
	private jkt.hms.masters.business.MasSubChargecode subChargecode;
	private jkt.hms.masters.business.MasSample sample;
	private jkt.hms.masters.business.AppEquipmentMaster equipment;
	private jkt.hms.masters.business.DgMasCollection container;

	// collections
	private java.util.Set<jkt.hms.masters.business.DgSubMasInvestigation> dgSubMasInvestigations;
	private java.util.Set<jkt.hms.masters.business.DgSampleCollectionDetails> dgSampleCollectionDetails;
	private java.util.Set<jkt.hms.masters.business.DgResultEntryDetail> dgResultEntryDetails;
	private java.util.Set<jkt.hms.masters.business.DgTemplate> dgTemplates;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="assigned"
     *  column="investigation_id"
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
	 * Return the value associated with the column: investigation_name
	 */
	public java.lang.String getInvestigationName () {
		return investigationName;
	}

	/**
	 * Set the value related to the column: investigation_name
	 * @param investigationName the investigation_name value
	 */
	public void setInvestigationName (java.lang.String investigationName) {
		this.investigationName = investigationName;
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
	 * Return the value associated with the column: confidential
	 */
	public java.lang.String getConfidential () {
		return confidential;
	}

	/**
	 * Set the value related to the column: confidential
	 * @param confidential the confidential value
	 */
	public void setConfidential (java.lang.String confidential) {
		this.confidential = confidential;
	}



	/**
	 * Return the value associated with the column: appear_in_discharge_summary
	 */
	public java.lang.String getAppearInDischargeSummary () {
		return appearInDischargeSummary;
	}

	/**
	 * Set the value related to the column: appear_in_discharge_summary
	 * @param appearInDischargeSummary the appear_in_discharge_summary value
	 */
	public void setAppearInDischargeSummary (java.lang.String appearInDischargeSummary) {
		this.appearInDischargeSummary = appearInDischargeSummary;
	}



	/**
	 * Return the value associated with the column: investigation_type
	 */
	public java.lang.String getInvestigationType () {
		return investigationType;
	}

	/**
	 * Set the value related to the column: investigation_type
	 * @param investigationType the investigation_type value
	 */
	public void setInvestigationType (java.lang.String investigationType) {
		this.investigationType = investigationType;
	}



	/**
	 * Return the value associated with the column: multiple_results
	 */
	public java.lang.String getMultipleResults () {
		return multipleResults;
	}

	/**
	 * Set the value related to the column: multiple_results
	 * @param multipleResults the multiple_results value
	 */
	public void setMultipleResults (java.lang.String multipleResults) {
		this.multipleResults = multipleResults;
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
	 * Return the value associated with the column: normal_value
	 */
	public java.lang.String getNormalValue () {
		return normalValue;
	}

	/**
	 * Set the value related to the column: normal_value
	 * @param normalValue the normal_value value
	 */
	public void setNormalValue (java.lang.String normalValue) {
		this.normalValue = normalValue;
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
	 * Return the value associated with the column: appointment_required
	 */
	public java.lang.String getAppointmentRequired () {
		return appointmentRequired;
	}

	/**
	 * Set the value related to the column: appointment_required
	 * @param appointmentRequired the appointment_required value
	 */
	public void setAppointmentRequired (java.lang.String appointmentRequired) {
		this.appointmentRequired = appointmentRequired;
	}



	/**
	 * Return the value associated with the column: max_normal_value
	 */
	public java.lang.String getMaxNormalValue () {
		return maxNormalValue;
	}

	/**
	 * Set the value related to the column: max_normal_value
	 * @param maxNormalValue the max_normal_value value
	 */
	public void setMaxNormalValue (java.lang.String maxNormalValue) {
		this.maxNormalValue = maxNormalValue;
	}



	/**
	 * Return the value associated with the column: min_normal_value
	 */
	public java.lang.String getMinNormalValue () {
		return minNormalValue;
	}

	/**
	 * Set the value related to the column: min_normal_value
	 * @param minNormalValue the min_normal_value value
	 */
	public void setMinNormalValue (java.lang.String minNormalValue) {
		this.minNormalValue = minNormalValue;
	}



	/**
	 * Return the value associated with the column: test_order_no
	 */
	public java.lang.Integer getTestOrderNo () {
		return testOrderNo;
	}

	/**
	 * Set the value related to the column: test_order_no
	 * @param testOrderNo the test_order_no value
	 */
	public void setTestOrderNo (java.lang.Integer testOrderNo) {
		this.testOrderNo = testOrderNo;
	}



	/**
	 * Return the value associated with the column: numeric_or_string
	 */
	public java.lang.String getNumericOrString () {
		return numericOrString;
	}

	/**
	 * Set the value related to the column: numeric_or_string
	 * @param numericOrString the numeric_or_string value
	 */
	public void setNumericOrString (java.lang.String numericOrString) {
		this.numericOrString = numericOrString;
	}



	/**
	 * Return the value associated with the column: hic_code
	 */
	public java.lang.String getHicCode () {
		return hicCode;
	}

	/**
	 * Set the value related to the column: hic_code
	 * @param hicCode the hic_code value
	 */
	public void setHicCode (java.lang.String hicCode) {
		this.hicCode = hicCode;
	}



	/**
	 * Return the value associated with the column: blood_reaction_test
	 */
	public java.lang.String getBloodReactionTest () {
		return bloodReactionTest;
	}

	/**
	 * Set the value related to the column: blood_reaction_test
	 * @param bloodReactionTest the blood_reaction_test value
	 */
	public void setBloodReactionTest (java.lang.String bloodReactionTest) {
		this.bloodReactionTest = bloodReactionTest;
	}



	/**
	 * Return the value associated with the column: blood_bank_screen_test
	 */
	public java.lang.String getBloodBankScreenTest () {
		return bloodBankScreenTest;
	}

	/**
	 * Set the value related to the column: blood_bank_screen_test
	 * @param bloodBankScreenTest the blood_bank_screen_test value
	 */
	public void setBloodBankScreenTest (java.lang.String bloodBankScreenTest) {
		this.bloodBankScreenTest = bloodBankScreenTest;
	}



	/**
	 * Return the value associated with the column: instructions
	 */
	public java.lang.String getInstructions () {
		return instructions;
	}

	/**
	 * Set the value related to the column: instructions
	 * @param instructions the instructions value
	 */
	public void setInstructions (java.lang.String instructions) {
		this.instructions = instructions;
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
	 * Return the value associated with the column: uom_id
	 */
	public jkt.hms.masters.business.DgUom getUom () {
		return uom;
	}

	/**
	 * Set the value related to the column: uom_id
	 * @param uom the uom_id value
	 */
	public void setUom (jkt.hms.masters.business.DgUom uom) {
		this.uom = uom;
	}



	/**
	 * Return the value associated with the column: sub_chargecode_id
	 */
	public jkt.hms.masters.business.MasSubChargecode getSubChargecode () {
		return subChargecode;
	}

	/**
	 * Set the value related to the column: sub_chargecode_id
	 * @param subChargecode the sub_chargecode_id value
	 */
	public void setSubChargecode (jkt.hms.masters.business.MasSubChargecode subChargecode) {
		this.subChargecode = subChargecode;
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
	 * Return the value associated with the column: equipment_id
	 */
	public jkt.hms.masters.business.AppEquipmentMaster getEquipment () {
		return equipment;
	}

	/**
	 * Set the value related to the column: equipment_id
	 * @param equipment the equipment_id value
	 */
	public void setEquipment (jkt.hms.masters.business.AppEquipmentMaster equipment) {
		this.equipment = equipment;
	}



	/**
	 * Return the value associated with the column: collection_id
	 */
	public jkt.hms.masters.business.DgMasCollection getContainer () {
		return container;
	}

	/**
	 * Set the value related to the column: collection_id
	 * @param container the collection_id value
	 */
	public void setContainer (jkt.hms.masters.business.DgMasCollection container) {
		this.container = container;
	}



	/**
	 * Return the value associated with the column: DgSubMasInvestigations
	 */
	public java.util.Set<jkt.hms.masters.business.DgSubMasInvestigation> getDgSubMasInvestigations () {
		return dgSubMasInvestigations;
	}

	/**
	 * Set the value related to the column: DgSubMasInvestigations
	 * @param dgSubMasInvestigations the DgSubMasInvestigations value
	 */
	public void setDgSubMasInvestigations (java.util.Set<jkt.hms.masters.business.DgSubMasInvestigation> dgSubMasInvestigations) {
		this.dgSubMasInvestigations = dgSubMasInvestigations;
	}

	public void addToDgSubMasInvestigations (jkt.hms.masters.business.DgSubMasInvestigation dgSubMasInvestigation) {
		if (null == getDgSubMasInvestigations()) setDgSubMasInvestigations(new java.util.TreeSet<jkt.hms.masters.business.DgSubMasInvestigation>());
		getDgSubMasInvestigations().add(dgSubMasInvestigation);
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



	/**
	 * Return the value associated with the column: DgTemplates
	 */
	public java.util.Set<jkt.hms.masters.business.DgTemplate> getDgTemplates () {
		return dgTemplates;
	}

	/**
	 * Set the value related to the column: DgTemplates
	 * @param dgTemplates the DgTemplates value
	 */
	public void setDgTemplates (java.util.Set<jkt.hms.masters.business.DgTemplate> dgTemplates) {
		this.dgTemplates = dgTemplates;
	}

	public void addToDgTemplates (jkt.hms.masters.business.DgTemplate dgTemplate) {
		if (null == getDgTemplates()) setDgTemplates(new java.util.TreeSet<jkt.hms.masters.business.DgTemplate>());
		getDgTemplates().add(dgTemplate);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.DgMasInvestigation)) return false;
		else {
			jkt.hms.masters.business.DgMasInvestigation dgMasInvestigation = (jkt.hms.masters.business.DgMasInvestigation) obj;
			if (null == this.getId() || null == dgMasInvestigation.getId()) return false;
			else return (this.getId().equals(dgMasInvestigation.getId()));
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
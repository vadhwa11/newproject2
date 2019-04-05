package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the dg_sub_mas_investigation
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="dg_sub_mas_investigation"
 */

public abstract class BaseDgSubMasInvestigation implements Serializable {

	public static String REF = "DgSubMasInvestigation";
	public static String PROP_INVESTIGATION = "Investigation";
	public static String PROP_MAIN_CHARGECODE = "MainChargecode";
	public static String PROP_COMPARISON_TYPE = "ComparisonType";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_SAMPLE = "Sample";
	public static String PROP_SUB_INVESTIGATION_CODE = "SubInvestigationCode";
	public static String PROP_UOM = "Uom";
	public static String PROP_SUB_CHARGECODE = "SubChargecode";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ORDER_NO = "OrderNo";
	public static String PROP_CHARGE_CODE = "ChargeCode";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_SUB_INVESTIGATION_NAME = "SubInvestigationName";
	public static String PROP_RESULT_TYPE = "ResultType";

	// constructors
	public BaseDgSubMasInvestigation() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDgSubMasInvestigation(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String subInvestigationCode;
	private java.lang.String subInvestigationName;
	private java.lang.String status;
	private java.lang.Integer orderNo;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String resultType;
	private java.lang.String comparisonType;

	// many to one
	private jkt.hms.masters.business.MasMainChargecode mainChargecode;
	private jkt.hms.masters.business.MasChargeCode chargeCode;
	private jkt.hms.masters.business.MasSubChargecode subChargecode;
	private jkt.hms.masters.business.MasSample sample;
	private jkt.hms.masters.business.DgUom uom;
	private jkt.hms.masters.business.DgMasInvestigation investigation;

	// collections
	private java.util.Set<jkt.hms.masters.business.DgNormalValue> dgNormalValues;
	private java.util.Set<jkt.hms.masters.business.DgResultEntryDetail> dgResultEntryDetails;
	private java.util.Set<jkt.hms.masters.business.DgFixedValue> dgFixedValues;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="sub_investigation_id"
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
	 * Return the value associated with the column: sub_investigation_code
	 */
	public java.lang.String getSubInvestigationCode() {
		return subInvestigationCode;
	}

	/**
	 * Set the value related to the column: sub_investigation_code
	 * 
	 * @param subInvestigationCode
	 *            the sub_investigation_code value
	 */
	public void setSubInvestigationCode(java.lang.String subInvestigationCode) {
		this.subInvestigationCode = subInvestigationCode;
	}

	/**
	 * Return the value associated with the column: sub_investigation_name
	 */
	public java.lang.String getSubInvestigationName() {
		return subInvestigationName;
	}

	/**
	 * Set the value related to the column: sub_investigation_name
	 * 
	 * @param subInvestigationName
	 *            the sub_investigation_name value
	 */
	public void setSubInvestigationName(java.lang.String subInvestigationName) {
		this.subInvestigationName = subInvestigationName;
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
	 * Return the value associated with the column: order_no
	 */
	public java.lang.Integer getOrderNo() {
		return orderNo;
	}

	/**
	 * Set the value related to the column: order_no
	 * 
	 * @param orderNo
	 *            the order_no value
	 */
	public void setOrderNo(java.lang.Integer orderNo) {
		this.orderNo = orderNo;
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
	 * Return the value associated with the column: result_type
	 */
	public java.lang.String getResultType() {
		return resultType;
	}

	/**
	 * Set the value related to the column: result_type
	 * 
	 * @param resultType
	 *            the result_type value
	 */
	public void setResultType(java.lang.String resultType) {
		this.resultType = resultType;
	}

	/**
	 * Return the value associated with the column: comparison_type
	 */
	public java.lang.String getComparisonType() {
		return comparisonType;
	}

	/**
	 * Set the value related to the column: comparison_type
	 * 
	 * @param comparisonType
	 *            the comparison_type value
	 */
	public void setComparisonType(java.lang.String comparisonType) {
		this.comparisonType = comparisonType;
	}

	/**
	 * Return the value associated with the column: main_chargecode_id
	 */
	public jkt.hms.masters.business.MasMainChargecode getMainChargecode() {
		return mainChargecode;
	}

	/**
	 * Set the value related to the column: main_chargecode_id
	 * 
	 * @param mainChargecode
	 *            the main_chargecode_id value
	 */
	public void setMainChargecode(
			jkt.hms.masters.business.MasMainChargecode mainChargecode) {
		this.mainChargecode = mainChargecode;
	}

	/**
	 * Return the value associated with the column: charge_code_id
	 */
	public jkt.hms.masters.business.MasChargeCode getChargeCode() {
		return chargeCode;
	}

	/**
	 * Set the value related to the column: charge_code_id
	 * 
	 * @param chargeCode
	 *            the charge_code_id value
	 */
	public void setChargeCode(jkt.hms.masters.business.MasChargeCode chargeCode) {
		this.chargeCode = chargeCode;
	}

	/**
	 * Return the value associated with the column: sub_chargecode_id
	 */
	public jkt.hms.masters.business.MasSubChargecode getSubChargecode() {
		return subChargecode;
	}

	/**
	 * Set the value related to the column: sub_chargecode_id
	 * 
	 * @param subChargecode
	 *            the sub_chargecode_id value
	 */
	public void setSubChargecode(
			jkt.hms.masters.business.MasSubChargecode subChargecode) {
		this.subChargecode = subChargecode;
	}

	/**
	 * Return the value associated with the column: sample_id
	 */
	public jkt.hms.masters.business.MasSample getSample() {
		return sample;
	}

	/**
	 * Set the value related to the column: sample_id
	 * 
	 * @param sample
	 *            the sample_id value
	 */
	public void setSample(jkt.hms.masters.business.MasSample sample) {
		this.sample = sample;
	}

	/**
	 * Return the value associated with the column: uom_id
	 */
	public jkt.hms.masters.business.DgUom getUom() {
		return uom;
	}

	/**
	 * Set the value related to the column: uom_id
	 * 
	 * @param uom
	 *            the uom_id value
	 */
	public void setUom(jkt.hms.masters.business.DgUom uom) {
		this.uom = uom;
	}

	/**
	 * Return the value associated with the column: investigation_id
	 */
	public jkt.hms.masters.business.DgMasInvestigation getInvestigation() {
		return investigation;
	}

	/**
	 * Set the value related to the column: investigation_id
	 * 
	 * @param investigation
	 *            the investigation_id value
	 */
	public void setInvestigation(
			jkt.hms.masters.business.DgMasInvestigation investigation) {
		this.investigation = investigation;
	}

	/**
	 * Return the value associated with the column: DgNormalValues
	 */
	public java.util.Set<jkt.hms.masters.business.DgNormalValue> getDgNormalValues() {
		return dgNormalValues;
	}

	/**
	 * Set the value related to the column: DgNormalValues
	 * 
	 * @param dgNormalValues
	 *            the DgNormalValues value
	 */
	public void setDgNormalValues(
			java.util.Set<jkt.hms.masters.business.DgNormalValue> dgNormalValues) {
		this.dgNormalValues = dgNormalValues;
	}

	public void addToDgNormalValues(
			jkt.hms.masters.business.DgNormalValue dgNormalValue) {
		if (null == getDgNormalValues())
			setDgNormalValues(new java.util.TreeSet<jkt.hms.masters.business.DgNormalValue>());
		getDgNormalValues().add(dgNormalValue);
	}

	/**
	 * Return the value associated with the column: DgResultEntryDetails
	 */
	public java.util.Set<jkt.hms.masters.business.DgResultEntryDetail> getDgResultEntryDetails() {
		return dgResultEntryDetails;
	}

	/**
	 * Set the value related to the column: DgResultEntryDetails
	 * 
	 * @param dgResultEntryDetails
	 *            the DgResultEntryDetails value
	 */
	public void setDgResultEntryDetails(
			java.util.Set<jkt.hms.masters.business.DgResultEntryDetail> dgResultEntryDetails) {
		this.dgResultEntryDetails = dgResultEntryDetails;
	}

	public void addToDgResultEntryDetails(
			jkt.hms.masters.business.DgResultEntryDetail dgResultEntryDetail) {
		if (null == getDgResultEntryDetails())
			setDgResultEntryDetails(new java.util.TreeSet<jkt.hms.masters.business.DgResultEntryDetail>());
		getDgResultEntryDetails().add(dgResultEntryDetail);
	}

	/**
	 * Return the value associated with the column: DgFixedValues
	 */
	public java.util.Set<jkt.hms.masters.business.DgFixedValue> getDgFixedValues() {
		return dgFixedValues;
	}

	/**
	 * Set the value related to the column: DgFixedValues
	 * 
	 * @param dgFixedValues
	 *            the DgFixedValues value
	 */
	public void setDgFixedValues(
			java.util.Set<jkt.hms.masters.business.DgFixedValue> dgFixedValues) {
		this.dgFixedValues = dgFixedValues;
	}

	public void addToDgFixedValues(
			jkt.hms.masters.business.DgFixedValue dgFixedValue) {
		if (null == getDgFixedValues())
			setDgFixedValues(new java.util.TreeSet<jkt.hms.masters.business.DgFixedValue>());
		getDgFixedValues().add(dgFixedValue);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.DgSubMasInvestigation))
			return false;
		else {
			jkt.hms.masters.business.DgSubMasInvestigation dgSubMasInvestigation = (jkt.hms.masters.business.DgSubMasInvestigation) obj;
			if (null == this.getId() || null == dgSubMasInvestigation.getId())
				return false;
			else
				return (this.getId().equals(dgSubMasInvestigation.getId()));
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
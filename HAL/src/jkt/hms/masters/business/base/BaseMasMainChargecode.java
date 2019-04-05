package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_main_chargecode
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="mas_main_chargecode"
 */

public abstract class BaseMasMainChargecode implements Serializable {

	public static String REF = "MasMainChargecode";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_MAIN_CHARGECODE_NAME = "MainChargecodeName";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_MAIN_CHARGECODE_CODE = "MainChargecodeCode";
	public static String PROP_MAINCHARGE_TYPE = "MainchargeType";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_ID = "Id";

	// constructors
	public BaseMasMainChargecode() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasMainChargecode(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String mainChargecodeCode;
	private java.lang.String mainChargecodeName;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String mainchargeType;

	// many to one
	private jkt.hms.masters.business.MasDepartment department;

	// collections
	private java.util.Set<jkt.hms.masters.business.DgOrderdt> dgOrderdts;
	private java.util.Set<jkt.hms.masters.business.DgSubMasInvestigation> dgSubMasInvestigations;
	private java.util.Set<jkt.hms.masters.business.DgMasInvestigation> dgMasInvestigations;
	private java.util.Set<jkt.hms.masters.business.DiagParam> diagParams;
	private java.util.Set<jkt.hms.masters.business.MasDiscount> masDiscounts;
	private java.util.Set<jkt.hms.masters.business.DgSampleCollectionDetails> dgSampleCollectionDetails;
	private java.util.Set<jkt.hms.masters.business.MasSubChargecode> masSubChargecodes;
	private java.util.Set<jkt.hms.masters.business.MasChargeCode> masChargeCodes;
	private java.util.Set<jkt.hms.masters.business.DgResultEntryHeader> dgResultEntryHeaders;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="main_chargecode_id"
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
	 * Return the value associated with the column: main_chargecode_code
	 */
	public java.lang.String getMainChargecodeCode() {
		return mainChargecodeCode;
	}

	/**
	 * Set the value related to the column: main_chargecode_code
	 * 
	 * @param mainChargecodeCode
	 *            the main_chargecode_code value
	 */
	public void setMainChargecodeCode(java.lang.String mainChargecodeCode) {
		this.mainChargecodeCode = mainChargecodeCode;
	}

	/**
	 * Return the value associated with the column: main_chargecode_name
	 */
	public java.lang.String getMainChargecodeName() {
		return mainChargecodeName;
	}

	/**
	 * Set the value related to the column: main_chargecode_name
	 * 
	 * @param mainChargecodeName
	 *            the main_chargecode_name value
	 */
	public void setMainChargecodeName(java.lang.String mainChargecodeName) {
		this.mainChargecodeName = mainChargecodeName;
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
	 * Return the value associated with the column: maincharge_type
	 */
	public java.lang.String getMainchargeType() {
		return mainchargeType;
	}

	/**
	 * Set the value related to the column: maincharge_type
	 * 
	 * @param mainchargeType
	 *            the maincharge_type value
	 */
	public void setMainchargeType(java.lang.String mainchargeType) {
		this.mainchargeType = mainchargeType;
	}

	/**
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment() {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * 
	 * @param department
	 *            the department_id value
	 */
	public void setDepartment(jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}

	/**
	 * Return the value associated with the column: DgOrderdts
	 */
	public java.util.Set<jkt.hms.masters.business.DgOrderdt> getDgOrderdts() {
		return dgOrderdts;
	}

	/**
	 * Set the value related to the column: DgOrderdts
	 * 
	 * @param dgOrderdts
	 *            the DgOrderdts value
	 */
	public void setDgOrderdts(
			java.util.Set<jkt.hms.masters.business.DgOrderdt> dgOrderdts) {
		this.dgOrderdts = dgOrderdts;
	}

	public void addToDgOrderdts(jkt.hms.masters.business.DgOrderdt dgOrderdt) {
		if (null == getDgOrderdts())
			setDgOrderdts(new java.util.TreeSet<jkt.hms.masters.business.DgOrderdt>());
		getDgOrderdts().add(dgOrderdt);
	}

	/**
	 * Return the value associated with the column: DgSubMasInvestigations
	 */
	public java.util.Set<jkt.hms.masters.business.DgSubMasInvestigation> getDgSubMasInvestigations() {
		return dgSubMasInvestigations;
	}

	/**
	 * Set the value related to the column: DgSubMasInvestigations
	 * 
	 * @param dgSubMasInvestigations
	 *            the DgSubMasInvestigations value
	 */
	public void setDgSubMasInvestigations(
			java.util.Set<jkt.hms.masters.business.DgSubMasInvestigation> dgSubMasInvestigations) {
		this.dgSubMasInvestigations = dgSubMasInvestigations;
	}

	public void addToDgSubMasInvestigations(
			jkt.hms.masters.business.DgSubMasInvestigation dgSubMasInvestigation) {
		if (null == getDgSubMasInvestigations())
			setDgSubMasInvestigations(new java.util.TreeSet<jkt.hms.masters.business.DgSubMasInvestigation>());
		getDgSubMasInvestigations().add(dgSubMasInvestigation);
	}

	/**
	 * Return the value associated with the column: DgMasInvestigations
	 */
	public java.util.Set<jkt.hms.masters.business.DgMasInvestigation> getDgMasInvestigations() {
		return dgMasInvestigations;
	}

	/**
	 * Set the value related to the column: DgMasInvestigations
	 * 
	 * @param dgMasInvestigations
	 *            the DgMasInvestigations value
	 */
	public void setDgMasInvestigations(
			java.util.Set<jkt.hms.masters.business.DgMasInvestigation> dgMasInvestigations) {
		this.dgMasInvestigations = dgMasInvestigations;
	}

	public void addToDgMasInvestigations(
			jkt.hms.masters.business.DgMasInvestigation dgMasInvestigation) {
		if (null == getDgMasInvestigations())
			setDgMasInvestigations(new java.util.TreeSet<jkt.hms.masters.business.DgMasInvestigation>());
		getDgMasInvestigations().add(dgMasInvestigation);
	}

	/**
	 * Return the value associated with the column: DiagParams
	 */
	public java.util.Set<jkt.hms.masters.business.DiagParam> getDiagParams() {
		return diagParams;
	}

	/**
	 * Set the value related to the column: DiagParams
	 * 
	 * @param diagParams
	 *            the DiagParams value
	 */
	public void setDiagParams(
			java.util.Set<jkt.hms.masters.business.DiagParam> diagParams) {
		this.diagParams = diagParams;
	}

	public void addToDiagParams(jkt.hms.masters.business.DiagParam diagParam) {
		if (null == getDiagParams())
			setDiagParams(new java.util.TreeSet<jkt.hms.masters.business.DiagParam>());
		getDiagParams().add(diagParam);
	}

	/**
	 * Return the value associated with the column: MasDiscounts
	 */
	public java.util.Set<jkt.hms.masters.business.MasDiscount> getMasDiscounts() {
		return masDiscounts;
	}

	/**
	 * Set the value related to the column: MasDiscounts
	 * 
	 * @param masDiscounts
	 *            the MasDiscounts value
	 */
	public void setMasDiscounts(
			java.util.Set<jkt.hms.masters.business.MasDiscount> masDiscounts) {
		this.masDiscounts = masDiscounts;
	}

	public void addToMasDiscounts(
			jkt.hms.masters.business.MasDiscount masDiscount) {
		if (null == getMasDiscounts())
			setMasDiscounts(new java.util.TreeSet<jkt.hms.masters.business.MasDiscount>());
		getMasDiscounts().add(masDiscount);
	}

	/**
	 * Return the value associated with the column: DgSampleCollectionDetails
	 */
	public java.util.Set<jkt.hms.masters.business.DgSampleCollectionDetails> getDgSampleCollectionDetails() {
		return dgSampleCollectionDetails;
	}

	/**
	 * Set the value related to the column: DgSampleCollectionDetails
	 * 
	 * @param dgSampleCollectionDetails
	 *            the DgSampleCollectionDetails value
	 */
	public void setDgSampleCollectionDetails(
			java.util.Set<jkt.hms.masters.business.DgSampleCollectionDetails> dgSampleCollectionDetails) {
		this.dgSampleCollectionDetails = dgSampleCollectionDetails;
	}

	public void addToDgSampleCollectionDetails(
			jkt.hms.masters.business.DgSampleCollectionDetails dgSampleCollectionDetails) {
		if (null == getDgSampleCollectionDetails())
			setDgSampleCollectionDetails(new java.util.TreeSet<jkt.hms.masters.business.DgSampleCollectionDetails>());
		getDgSampleCollectionDetails().add(dgSampleCollectionDetails);
	}

	/**
	 * Return the value associated with the column: MasSubChargecodes
	 */
	public java.util.Set<jkt.hms.masters.business.MasSubChargecode> getMasSubChargecodes() {
		return masSubChargecodes;
	}

	/**
	 * Set the value related to the column: MasSubChargecodes
	 * 
	 * @param masSubChargecodes
	 *            the MasSubChargecodes value
	 */
	public void setMasSubChargecodes(
			java.util.Set<jkt.hms.masters.business.MasSubChargecode> masSubChargecodes) {
		this.masSubChargecodes = masSubChargecodes;
	}

	public void addToMasSubChargecodes(
			jkt.hms.masters.business.MasSubChargecode masSubChargecode) {
		if (null == getMasSubChargecodes())
			setMasSubChargecodes(new java.util.TreeSet<jkt.hms.masters.business.MasSubChargecode>());
		getMasSubChargecodes().add(masSubChargecode);
	}

	/**
	 * Return the value associated with the column: MasChargeCodes
	 */
	public java.util.Set<jkt.hms.masters.business.MasChargeCode> getMasChargeCodes() {
		return masChargeCodes;
	}

	/**
	 * Set the value related to the column: MasChargeCodes
	 * 
	 * @param masChargeCodes
	 *            the MasChargeCodes value
	 */
	public void setMasChargeCodes(
			java.util.Set<jkt.hms.masters.business.MasChargeCode> masChargeCodes) {
		this.masChargeCodes = masChargeCodes;
	}

	public void addToMasChargeCodes(
			jkt.hms.masters.business.MasChargeCode masChargeCode) {
		if (null == getMasChargeCodes())
			setMasChargeCodes(new java.util.TreeSet<jkt.hms.masters.business.MasChargeCode>());
		getMasChargeCodes().add(masChargeCode);
	}

	/**
	 * Return the value associated with the column: DgResultEntryHeaders
	 */
	public java.util.Set<jkt.hms.masters.business.DgResultEntryHeader> getDgResultEntryHeaders() {
		return dgResultEntryHeaders;
	}

	/**
	 * Set the value related to the column: DgResultEntryHeaders
	 * 
	 * @param dgResultEntryHeaders
	 *            the DgResultEntryHeaders value
	 */
	public void setDgResultEntryHeaders(
			java.util.Set<jkt.hms.masters.business.DgResultEntryHeader> dgResultEntryHeaders) {
		this.dgResultEntryHeaders = dgResultEntryHeaders;
	}

	public void addToDgResultEntryHeaders(
			jkt.hms.masters.business.DgResultEntryHeader dgResultEntryHeader) {
		if (null == getDgResultEntryHeaders())
			setDgResultEntryHeaders(new java.util.TreeSet<jkt.hms.masters.business.DgResultEntryHeader>());
		getDgResultEntryHeaders().add(dgResultEntryHeader);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MasMainChargecode))
			return false;
		else {
			jkt.hms.masters.business.MasMainChargecode masMainChargecode = (jkt.hms.masters.business.MasMainChargecode) obj;
			if (null == this.getId() || null == masMainChargecode.getId())
				return false;
			else
				return (this.getId().equals(masMainChargecode.getId()));
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
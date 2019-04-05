package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * md_cardic_contingent_bill_hd table. Do not modify this class because it will
 * be overwritten if the configuration file related to this class is modified.
 * 
 * @hibernate.class table="md_cardic_contingent_bill_hd"
 */

public abstract class BaseMdCardicContingentBillHd implements Serializable {

	public static String REF = "MdCardicContingentBillHd";
	public static String PROP_RECEIVED_RS = "ReceivedRs";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_REIMBURSE_RS = "ReimburseRs";
	public static String PROP_TOTAL_RS = "TotalRs";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_HIN = "Hin";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_CGHS_RATES = "CghsRates";
	public static String PROP_CARDIC_ADVANCE = "CardicAdvance";
	public static String PROP_CGHS_CODE = "CghsCode";
	public static String PROP_IS1 = "Is1";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ENTRY_NO = "EntryNo";
	public static String PROP_QUALIFYING_AMOUNT = "QualifyingAmount";
	public static String PROP_PAYABLE_TO = "PayableTo";
	public static String PROP_ENTRY_DATE = "EntryDate";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_IS2 = "Is2";
	public static String PROP_ID = "Id";

	// constructors
	public BaseMdCardicContingentBillHd() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMdCardicContingentBillHd(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String entryNo;
	private java.util.Date entryDate;
	private java.math.BigDecimal qualifyingAmount;
	private java.lang.String payableTo;
	private java.lang.String cghsCode;
	private java.lang.String is1;
	private java.lang.String cghsRates;
	private java.math.BigDecimal is2;
	private java.math.BigDecimal receivedRs;
	private java.math.BigDecimal totalRs;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.math.BigDecimal reimburseRs;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.MdCardicClaimAdvance cardicAdvance;
	private jkt.hms.masters.business.Patient hin;

	// collections
	private java.util.Set<jkt.hms.masters.business.MdCardicContingentBillDt> mdCardicContingentBillDts;
	private java.util.Set<jkt.hms.masters.business.MdBillMovement> mdBillMovements;

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
	 * Return the value associated with the column: entry_no
	 */
	public java.lang.String getEntryNo() {
		return entryNo;
	}

	/**
	 * Set the value related to the column: entry_no
	 * 
	 * @param entryNo
	 *            the entry_no value
	 */
	public void setEntryNo(java.lang.String entryNo) {
		this.entryNo = entryNo;
	}

	/**
	 * Return the value associated with the column: entry_date
	 */
	public java.util.Date getEntryDate() {
		return entryDate;
	}

	/**
	 * Set the value related to the column: entry_date
	 * 
	 * @param entryDate
	 *            the entry_date value
	 */
	public void setEntryDate(java.util.Date entryDate) {
		this.entryDate = entryDate;
	}

	/**
	 * Return the value associated with the column: qualifying_amount
	 */
	public java.math.BigDecimal getQualifyingAmount() {
		return qualifyingAmount;
	}

	/**
	 * Set the value related to the column: qualifying_amount
	 * 
	 * @param qualifyingAmount
	 *            the qualifying_amount value
	 */
	public void setQualifyingAmount(java.math.BigDecimal qualifyingAmount) {
		this.qualifyingAmount = qualifyingAmount;
	}

	/**
	 * Return the value associated with the column: payable_to
	 */
	public java.lang.String getPayableTo() {
		return payableTo;
	}

	/**
	 * Set the value related to the column: payable_to
	 * 
	 * @param payableTo
	 *            the payable_to value
	 */
	public void setPayableTo(java.lang.String payableTo) {
		this.payableTo = payableTo;
	}

	/**
	 * Return the value associated with the column: cghs_code
	 */
	public java.lang.String getCghsCode() {
		return cghsCode;
	}

	/**
	 * Set the value related to the column: cghs_code
	 * 
	 * @param cghsCode
	 *            the cghs_code value
	 */
	public void setCghsCode(java.lang.String cghsCode) {
		this.cghsCode = cghsCode;
	}

	/**
	 * Return the value associated with the column: is1
	 */
	public java.lang.String getIs1() {
		return is1;
	}

	/**
	 * Set the value related to the column: is1
	 * 
	 * @param is1
	 *            the is1 value
	 */
	public void setIs1(java.lang.String is1) {
		this.is1 = is1;
	}

	/**
	 * Return the value associated with the column: cghs_rates
	 */
	public java.lang.String getCghsRates() {
		return cghsRates;
	}

	/**
	 * Set the value related to the column: cghs_rates
	 * 
	 * @param cghsRates
	 *            the cghs_rates value
	 */
	public void setCghsRates(java.lang.String cghsRates) {
		this.cghsRates = cghsRates;
	}

	/**
	 * Return the value associated with the column: is2
	 */
	public java.math.BigDecimal getIs2() {
		return is2;
	}

	/**
	 * Set the value related to the column: is2
	 * 
	 * @param is2
	 *            the is2 value
	 */
	public void setIs2(java.math.BigDecimal is2) {
		this.is2 = is2;
	}

	/**
	 * Return the value associated with the column: received_rs
	 */
	public java.math.BigDecimal getReceivedRs() {
		return receivedRs;
	}

	/**
	 * Set the value related to the column: received_rs
	 * 
	 * @param receivedRs
	 *            the received_rs value
	 */
	public void setReceivedRs(java.math.BigDecimal receivedRs) {
		this.receivedRs = receivedRs;
	}

	/**
	 * Return the value associated with the column: total_rs
	 */
	public java.math.BigDecimal getTotalRs() {
		return totalRs;
	}

	/**
	 * Set the value related to the column: total_rs
	 * 
	 * @param totalRs
	 *            the total_rs value
	 */
	public void setTotalRs(java.math.BigDecimal totalRs) {
		this.totalRs = totalRs;
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
	 * Return the value associated with the column: reimburse_rs
	 */
	public java.math.BigDecimal getReimburseRs() {
		return reimburseRs;
	}

	/**
	 * Set the value related to the column: reimburse_rs
	 * 
	 * @param reimburseRs
	 *            the reimburse_rs value
	 */
	public void setReimburseRs(java.math.BigDecimal reimburseRs) {
		this.reimburseRs = reimburseRs;
	}

	/**
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital() {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * 
	 * @param hospital
	 *            the hospital_id value
	 */
	public void setHospital(jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
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
	 * Return the value associated with the column: inpatient_id
	 */
	public jkt.hms.masters.business.Inpatient getInpatient() {
		return inpatient;
	}

	/**
	 * Set the value related to the column: inpatient_id
	 * 
	 * @param inpatient
	 *            the inpatient_id value
	 */
	public void setInpatient(jkt.hms.masters.business.Inpatient inpatient) {
		this.inpatient = inpatient;
	}

	/**
	 * Return the value associated with the column: cardic_advance_id
	 */
	public jkt.hms.masters.business.MdCardicClaimAdvance getCardicAdvance() {
		return cardicAdvance;
	}

	/**
	 * Set the value related to the column: cardic_advance_id
	 * 
	 * @param cardicAdvance
	 *            the cardic_advance_id value
	 */
	public void setCardicAdvance(
			jkt.hms.masters.business.MdCardicClaimAdvance cardicAdvance) {
		this.cardicAdvance = cardicAdvance;
	}

	/**
	 * Return the value associated with the column: hin_id
	 */
	public jkt.hms.masters.business.Patient getHin() {
		return hin;
	}

	/**
	 * Set the value related to the column: hin_id
	 * 
	 * @param hin
	 *            the hin_id value
	 */
	public void setHin(jkt.hms.masters.business.Patient hin) {
		this.hin = hin;
	}

	/**
	 * Return the value associated with the column: MdCardicContingentBillDts
	 */
	public java.util.Set<jkt.hms.masters.business.MdCardicContingentBillDt> getMdCardicContingentBillDts() {
		return mdCardicContingentBillDts;
	}

	/**
	 * Set the value related to the column: MdCardicContingentBillDts
	 * 
	 * @param mdCardicContingentBillDts
	 *            the MdCardicContingentBillDts value
	 */
	public void setMdCardicContingentBillDts(
			java.util.Set<jkt.hms.masters.business.MdCardicContingentBillDt> mdCardicContingentBillDts) {
		this.mdCardicContingentBillDts = mdCardicContingentBillDts;
	}

	public void addToMdCardicContingentBillDts(
			jkt.hms.masters.business.MdCardicContingentBillDt mdCardicContingentBillDt) {
		if (null == getMdCardicContingentBillDts())
			setMdCardicContingentBillDts(new java.util.TreeSet<jkt.hms.masters.business.MdCardicContingentBillDt>());
		getMdCardicContingentBillDts().add(mdCardicContingentBillDt);
	}

	/**
	 * Return the value associated with the column: MdBillMovements
	 */
	public java.util.Set<jkt.hms.masters.business.MdBillMovement> getMdBillMovements() {
		return mdBillMovements;
	}

	/**
	 * Set the value related to the column: MdBillMovements
	 * 
	 * @param mdBillMovements
	 *            the MdBillMovements value
	 */
	public void setMdBillMovements(
			java.util.Set<jkt.hms.masters.business.MdBillMovement> mdBillMovements) {
		this.mdBillMovements = mdBillMovements;
	}

	public void addToMdBillMovements(
			jkt.hms.masters.business.MdBillMovement mdBillMovement) {
		if (null == getMdBillMovements())
			setMdBillMovements(new java.util.TreeSet<jkt.hms.masters.business.MdBillMovement>());
		getMdBillMovements().add(mdBillMovement);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MdCardicContingentBillHd))
			return false;
		else {
			jkt.hms.masters.business.MdCardicContingentBillHd mdCardicContingentBillHd = (jkt.hms.masters.business.MdCardicContingentBillHd) obj;
			if (null == this.getId()
					|| null == mdCardicContingentBillHd.getId())
				return false;
			else
				return (this.getId().equals(mdCardicContingentBillHd.getId()));
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
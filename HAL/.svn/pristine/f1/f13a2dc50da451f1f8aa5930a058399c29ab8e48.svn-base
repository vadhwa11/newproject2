package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the md_contigent_medical_bill_hd table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="md_contigent_medical_bill_hd"
 */

public abstract class BaseMdContigentMedicalBillHd  implements Serializable {

	public static String REF = "MdContigentMedicalBillHd";
	public static String PROP_WORKING_DIAGNOSIS = "WorkingDiagnosis";
	public static String PROP_CLAIM_TYPE = "ClaimType";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_SUBMISSION_DATE = "SubmissionDate";
	public static String PROP_PAYABLE_TO = "PayableTo";
	public static String PROP_BILL_NO = "BillNo";
	public static String PROP_AMOUNT = "Amount";
	public static String PROP_DISPATCH_STATUS = "DispatchStatus";
	public static String PROP_ENTRY_NO = "EntryNo";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_QUALIFYING_AMOUNT = "QualifyingAmount";
	public static String PROP_ENTRY_DATE = "EntryDate";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_CGHS_RATE = "CghsRate";
	public static String PROP_FWT_DATE = "FwtDate";
	public static String PROP_RECEIVED_RS = "ReceivedRs";
	public static String PROP_ACCOUNT_OFFICER = "AccountOfficer";
	public static String PROP_CGHS_CODE = "CghsCode";
	public static String PROP_ID = "Id";
	public static String PROP_BILL_DATE = "BillDate";
	public static String PROP_HIN = "Hin";
	public static String PROP_FWT_TO = "FwtTo";


	// constructors
	public BaseMdContigentMedicalBillHd () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMdContigentMedicalBillHd (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String entryNo;
	private java.util.Date entryDate;
	private java.lang.String claimType;
	private java.lang.String billNo;
	private java.util.Date billDate;
	private java.math.BigDecimal amount;
	private java.math.BigDecimal qualifyingAmount;
	private java.lang.String workingDiagnosis;
	private java.lang.String payableTo;
	private java.lang.String accountOfficer;
	private java.util.Date submissionDate;
	private java.math.BigDecimal receivedRs;
	private java.util.Date fwtDate;
	private java.lang.String dispatchStatus;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String cghsCode;
	private java.math.BigDecimal cghsRate;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MdMasAuthority fwtTo;
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.MasEmployee employee;

	// collections
	private java.util.Set<jkt.hms.masters.business.MdGeneralCoveringDt> mdGeneralCoveringDts;
	private java.util.Set<jkt.hms.masters.business.MdCoveringLetterUnitDt> mdCoveringLetterUnitDts;
	private java.util.Set<jkt.hms.masters.business.MdContigentMedicalBillDt> mdContigentMedicalBillDts;



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
	 * Return the value associated with the column: entry_no
	 */
	public java.lang.String getEntryNo () {
		return entryNo;
	}

	/**
	 * Set the value related to the column: entry_no
	 * @param entryNo the entry_no value
	 */
	public void setEntryNo (java.lang.String entryNo) {
		this.entryNo = entryNo;
	}



	/**
	 * Return the value associated with the column: entry_date
	 */
	public java.util.Date getEntryDate () {
		return entryDate;
	}

	/**
	 * Set the value related to the column: entry_date
	 * @param entryDate the entry_date value
	 */
	public void setEntryDate (java.util.Date entryDate) {
		this.entryDate = entryDate;
	}



	/**
	 * Return the value associated with the column: claim_type
	 */
	public java.lang.String getClaimType () {
		return claimType;
	}

	/**
	 * Set the value related to the column: claim_type
	 * @param claimType the claim_type value
	 */
	public void setClaimType (java.lang.String claimType) {
		this.claimType = claimType;
	}



	/**
	 * Return the value associated with the column: bill_no
	 */
	public java.lang.String getBillNo () {
		return billNo;
	}

	/**
	 * Set the value related to the column: bill_no
	 * @param billNo the bill_no value
	 */
	public void setBillNo (java.lang.String billNo) {
		this.billNo = billNo;
	}



	/**
	 * Return the value associated with the column: bill_date
	 */
	public java.util.Date getBillDate () {
		return billDate;
	}

	/**
	 * Set the value related to the column: bill_date
	 * @param billDate the bill_date value
	 */
	public void setBillDate (java.util.Date billDate) {
		this.billDate = billDate;
	}



	/**
	 * Return the value associated with the column: amount
	 */
	public java.math.BigDecimal getAmount () {
		return amount;
	}

	/**
	 * Set the value related to the column: amount
	 * @param amount the amount value
	 */
	public void setAmount (java.math.BigDecimal amount) {
		this.amount = amount;
	}



	/**
	 * Return the value associated with the column: qualifying_amount
	 */
	public java.math.BigDecimal getQualifyingAmount () {
		return qualifyingAmount;
	}

	/**
	 * Set the value related to the column: qualifying_amount
	 * @param qualifyingAmount the qualifying_amount value
	 */
	public void setQualifyingAmount (java.math.BigDecimal qualifyingAmount) {
		this.qualifyingAmount = qualifyingAmount;
	}



	/**
	 * Return the value associated with the column: working_diagnosis
	 */
	public java.lang.String getWorkingDiagnosis () {
		return workingDiagnosis;
	}

	/**
	 * Set the value related to the column: working_diagnosis
	 * @param workingDiagnosis the working_diagnosis value
	 */
	public void setWorkingDiagnosis (java.lang.String workingDiagnosis) {
		this.workingDiagnosis = workingDiagnosis;
	}



	/**
	 * Return the value associated with the column: payable_to
	 */
	public java.lang.String getPayableTo () {
		return payableTo;
	}

	/**
	 * Set the value related to the column: payable_to
	 * @param payableTo the payable_to value
	 */
	public void setPayableTo (java.lang.String payableTo) {
		this.payableTo = payableTo;
	}



	/**
	 * Return the value associated with the column: account_officer
	 */
	public java.lang.String getAccountOfficer () {
		return accountOfficer;
	}

	/**
	 * Set the value related to the column: account_officer
	 * @param accountOfficer the account_officer value
	 */
	public void setAccountOfficer (java.lang.String accountOfficer) {
		this.accountOfficer = accountOfficer;
	}



	/**
	 * Return the value associated with the column: submission_date
	 */
	public java.util.Date getSubmissionDate () {
		return submissionDate;
	}

	/**
	 * Set the value related to the column: submission_date
	 * @param submissionDate the submission_date value
	 */
	public void setSubmissionDate (java.util.Date submissionDate) {
		this.submissionDate = submissionDate;
	}



	/**
	 * Return the value associated with the column: received_rs
	 */
	public java.math.BigDecimal getReceivedRs () {
		return receivedRs;
	}

	/**
	 * Set the value related to the column: received_rs
	 * @param receivedRs the received_rs value
	 */
	public void setReceivedRs (java.math.BigDecimal receivedRs) {
		this.receivedRs = receivedRs;
	}



	/**
	 * Return the value associated with the column: fwt_date
	 */
	public java.util.Date getFwtDate () {
		return fwtDate;
	}

	/**
	 * Set the value related to the column: fwt_date
	 * @param fwtDate the fwt_date value
	 */
	public void setFwtDate (java.util.Date fwtDate) {
		this.fwtDate = fwtDate;
	}



	/**
	 * Return the value associated with the column: dispatch_status
	 */
	public java.lang.String getDispatchStatus () {
		return dispatchStatus;
	}

	/**
	 * Set the value related to the column: dispatch_status
	 * @param dispatchStatus the dispatch_status value
	 */
	public void setDispatchStatus (java.lang.String dispatchStatus) {
		this.dispatchStatus = dispatchStatus;
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
	 * Return the value associated with the column: cghs_code
	 */
	public java.lang.String getCghsCode () {
		return cghsCode;
	}

	/**
	 * Set the value related to the column: cghs_code
	 * @param cghsCode the cghs_code value
	 */
	public void setCghsCode (java.lang.String cghsCode) {
		this.cghsCode = cghsCode;
	}



	/**
	 * Return the value associated with the column: cghs_rate
	 */
	public java.math.BigDecimal getCghsRate () {
		return cghsRate;
	}

	/**
	 * Set the value related to the column: cghs_rate
	 * @param cghsRate the cghs_rate value
	 */
	public void setCghsRate (java.math.BigDecimal cghsRate) {
		this.cghsRate = cghsRate;
	}



	/**
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital () {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * @param hospital the hospital_id value
	 */
	public void setHospital (jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}



	/**
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment () {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * @param department the department_id value
	 */
	public void setDepartment (jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}



	/**
	 * Return the value associated with the column: fwt_to
	 */
	public jkt.hms.masters.business.MdMasAuthority getFwtTo () {
		return fwtTo;
	}

	/**
	 * Set the value related to the column: fwt_to
	 * @param fwtTo the fwt_to value
	 */
	public void setFwtTo (jkt.hms.masters.business.MdMasAuthority fwtTo) {
		this.fwtTo = fwtTo;
	}



	/**
	 * Return the value associated with the column: inpatient_id
	 */
	public jkt.hms.masters.business.Inpatient getInpatient () {
		return inpatient;
	}

	/**
	 * Set the value related to the column: inpatient_id
	 * @param inpatient the inpatient_id value
	 */
	public void setInpatient (jkt.hms.masters.business.Inpatient inpatient) {
		this.inpatient = inpatient;
	}



	/**
	 * Return the value associated with the column: hin_id
	 */
	public jkt.hms.masters.business.Patient getHin () {
		return hin;
	}

	/**
	 * Set the value related to the column: hin_id
	 * @param hin the hin_id value
	 */
	public void setHin (jkt.hms.masters.business.Patient hin) {
		this.hin = hin;
	}



	/**
	 * Return the value associated with the column: employee_id
	 */
	public jkt.hms.masters.business.MasEmployee getEmployee () {
		return employee;
	}

	/**
	 * Set the value related to the column: employee_id
	 * @param employee the employee_id value
	 */
	public void setEmployee (jkt.hms.masters.business.MasEmployee employee) {
		this.employee = employee;
	}



	/**
	 * Return the value associated with the column: MdGeneralCoveringDts
	 */
	public java.util.Set<jkt.hms.masters.business.MdGeneralCoveringDt> getMdGeneralCoveringDts () {
		return mdGeneralCoveringDts;
	}

	/**
	 * Set the value related to the column: MdGeneralCoveringDts
	 * @param mdGeneralCoveringDts the MdGeneralCoveringDts value
	 */
	public void setMdGeneralCoveringDts (java.util.Set<jkt.hms.masters.business.MdGeneralCoveringDt> mdGeneralCoveringDts) {
		this.mdGeneralCoveringDts = mdGeneralCoveringDts;
	}

	public void addToMdGeneralCoveringDts (jkt.hms.masters.business.MdGeneralCoveringDt mdGeneralCoveringDt) {
		if (null == getMdGeneralCoveringDts()) setMdGeneralCoveringDts(new java.util.TreeSet<jkt.hms.masters.business.MdGeneralCoveringDt>());
		getMdGeneralCoveringDts().add(mdGeneralCoveringDt);
	}



	/**
	 * Return the value associated with the column: MdCoveringLetterUnitDts
	 */
	public java.util.Set<jkt.hms.masters.business.MdCoveringLetterUnitDt> getMdCoveringLetterUnitDts () {
		return mdCoveringLetterUnitDts;
	}

	/**
	 * Set the value related to the column: MdCoveringLetterUnitDts
	 * @param mdCoveringLetterUnitDts the MdCoveringLetterUnitDts value
	 */
	public void setMdCoveringLetterUnitDts (java.util.Set<jkt.hms.masters.business.MdCoveringLetterUnitDt> mdCoveringLetterUnitDts) {
		this.mdCoveringLetterUnitDts = mdCoveringLetterUnitDts;
	}

	public void addToMdCoveringLetterUnitDts (jkt.hms.masters.business.MdCoveringLetterUnitDt mdCoveringLetterUnitDt) {
		if (null == getMdCoveringLetterUnitDts()) setMdCoveringLetterUnitDts(new java.util.TreeSet<jkt.hms.masters.business.MdCoveringLetterUnitDt>());
		getMdCoveringLetterUnitDts().add(mdCoveringLetterUnitDt);
	}



	/**
	 * Return the value associated with the column: MdContigentMedicalBillDts
	 */
	public java.util.Set<jkt.hms.masters.business.MdContigentMedicalBillDt> getMdContigentMedicalBillDts () {
		return mdContigentMedicalBillDts;
	}

	/**
	 * Set the value related to the column: MdContigentMedicalBillDts
	 * @param mdContigentMedicalBillDts the MdContigentMedicalBillDts value
	 */
	public void setMdContigentMedicalBillDts (java.util.Set<jkt.hms.masters.business.MdContigentMedicalBillDt> mdContigentMedicalBillDts) {
		this.mdContigentMedicalBillDts = mdContigentMedicalBillDts;
	}

	public void addToMdContigentMedicalBillDts (jkt.hms.masters.business.MdContigentMedicalBillDt mdContigentMedicalBillDt) {
		if (null == getMdContigentMedicalBillDts()) setMdContigentMedicalBillDts(new java.util.TreeSet<jkt.hms.masters.business.MdContigentMedicalBillDt>());
		getMdContigentMedicalBillDts().add(mdContigentMedicalBillDt);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MdContigentMedicalBillHd)) return false;
		else {
			jkt.hms.masters.business.MdContigentMedicalBillHd mdContigentMedicalBillHd = (jkt.hms.masters.business.MdContigentMedicalBillHd) obj;
			if (null == this.getId() || null == mdContigentMedicalBillHd.getId()) return false;
			else return (this.getId().equals(mdContigentMedicalBillHd.getId()));
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
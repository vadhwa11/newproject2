package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ipd_medicine_issue_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ipd_medicine_issue_details"
 */

public abstract class BaseIpdMedicineIssueDetails  implements Serializable {

	public static String REF = "IpdMedicineIssueDetails";
	public static String PROP_DOSE = "Dose";
	public static String PROP_ISSUE_DATE = "IssueDate";
	public static String PROP_ISSUED = "Issued";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_IPD_MEDICINE_ISSUE_HEADER = "IpdMedicineIssueHeader";
	public static String PROP_BATCH_STOCK = "BatchStock";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_ID = "Id";
	public static String PROP_PATIENT_PRESCRIPTION_DETAILS = "PatientPrescriptionDetails";
	public static String PROP_ISSUE_TIME = "IssueTime";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseIpdMedicineIssueDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseIpdMedicineIssueDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date issueDate;
	private java.lang.String issueTime;
	private java.lang.String dose;
	private java.lang.String issued;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String remarks;

	// many to one
	private jkt.hms.masters.business.StoreItemBatchStock batchStock;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.PatientPrescriptionDetails patientPrescriptionDetails;
	private jkt.hms.masters.business.IpdMedicineIssueHeader ipdMedicineIssueHeader;



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
	 * Return the value associated with the column: issue_date
	 */
	public java.util.Date getIssueDate () {
		return issueDate;
	}

	/**
	 * Set the value related to the column: issue_date
	 * @param issueDate the issue_date value
	 */
	public void setIssueDate (java.util.Date issueDate) {
		this.issueDate = issueDate;
	}



	/**
	 * Return the value associated with the column: issue_time
	 */
	public java.lang.String getIssueTime () {
		return issueTime;
	}

	/**
	 * Set the value related to the column: issue_time
	 * @param issueTime the issue_time value
	 */
	public void setIssueTime (java.lang.String issueTime) {
		this.issueTime = issueTime;
	}



	/**
	 * Return the value associated with the column: dose
	 */
	public java.lang.String getDose () {
		return dose;
	}

	/**
	 * Set the value related to the column: dose
	 * @param dose the dose value
	 */
	public void setDose (java.lang.String dose) {
		this.dose = dose;
	}



	/**
	 * Return the value associated with the column: issued
	 */
	public java.lang.String getIssued () {
		return issued;
	}

	/**
	 * Set the value related to the column: issued
	 * @param issued the issued value
	 */
	public void setIssued (java.lang.String issued) {
		this.issued = issued;
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
	 * Return the value associated with the column: batch_stock_id
	 */
	public jkt.hms.masters.business.StoreItemBatchStock getBatchStock () {
		return batchStock;
	}

	/**
	 * Set the value related to the column: batch_stock_id
	 * @param batchStock the batch_stock_id value
	 */
	public void setBatchStock (jkt.hms.masters.business.StoreItemBatchStock batchStock) {
		this.batchStock = batchStock;
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
	 * Return the value associated with the column: patient_prescription_details_id
	 */
	public jkt.hms.masters.business.PatientPrescriptionDetails getPatientPrescriptionDetails () {
		return patientPrescriptionDetails;
	}

	/**
	 * Set the value related to the column: patient_prescription_details_id
	 * @param patientPrescriptionDetails the patient_prescription_details_id value
	 */
	public void setPatientPrescriptionDetails (jkt.hms.masters.business.PatientPrescriptionDetails patientPrescriptionDetails) {
		this.patientPrescriptionDetails = patientPrescriptionDetails;
	}



	/**
	 * Return the value associated with the column: ipd_medicine_issue_header_id
	 */
	public jkt.hms.masters.business.IpdMedicineIssueHeader getIpdMedicineIssueHeader () {
		return ipdMedicineIssueHeader;
	}

	/**
	 * Set the value related to the column: ipd_medicine_issue_header_id
	 * @param ipdMedicineIssueHeader the ipd_medicine_issue_header_id value
	 */
	public void setIpdMedicineIssueHeader (jkt.hms.masters.business.IpdMedicineIssueHeader ipdMedicineIssueHeader) {
		this.ipdMedicineIssueHeader = ipdMedicineIssueHeader;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.IpdMedicineIssueDetails)) return false;
		else {
			jkt.hms.masters.business.IpdMedicineIssueDetails ipdMedicineIssueDetails = (jkt.hms.masters.business.IpdMedicineIssueDetails) obj;
			if (null == this.getId() || null == ipdMedicineIssueDetails.getId()) return false;
			else return (this.getId().equals(ipdMedicineIssueDetails.getId()));
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
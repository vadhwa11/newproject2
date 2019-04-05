package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ipd_medicine_issue_header table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ipd_medicine_issue_header"
 */

public abstract class BaseIpdMedicineIssueHeader  implements Serializable {

	public static String REF = "IpdMedicineIssueHeader";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ISSUED_QUANTITY = "IssuedQuantity";
	public static String PROP_ID = "Id";
	public static String PROP_PATIENT_PRESCRIPTION_DETAILS = "PatientPrescriptionDetails";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseIpdMedicineIssueHeader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseIpdMedicineIssueHeader (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer issuedQuantity;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.PatientPrescriptionDetails patientPrescriptionDetails;

	// collections
	private java.util.Set<jkt.hms.masters.business.IpdMedicineIssueDetails> ipdMedicineIssueDetails;



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
	 * Return the value associated with the column: issued_quantity
	 */
	public java.lang.Integer getIssuedQuantity () {
		return issuedQuantity;
	}

	/**
	 * Set the value related to the column: issued_quantity
	 * @param issuedQuantity the issued_quantity value
	 */
	public void setIssuedQuantity (java.lang.Integer issuedQuantity) {
		this.issuedQuantity = issuedQuantity;
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
	 * Return the value associated with the column: IpdMedicineIssueDetails
	 */
	public java.util.Set<jkt.hms.masters.business.IpdMedicineIssueDetails> getIpdMedicineIssueDetails () {
		return ipdMedicineIssueDetails;
	}

	/**
	 * Set the value related to the column: IpdMedicineIssueDetails
	 * @param ipdMedicineIssueDetails the IpdMedicineIssueDetails value
	 */
	public void setIpdMedicineIssueDetails (java.util.Set<jkt.hms.masters.business.IpdMedicineIssueDetails> ipdMedicineIssueDetails) {
		this.ipdMedicineIssueDetails = ipdMedicineIssueDetails;
	}

	public void addToIpdMedicineIssueDetails (jkt.hms.masters.business.IpdMedicineIssueDetails ipdMedicineIssueDetails) {
		if (null == getIpdMedicineIssueDetails()) setIpdMedicineIssueDetails(new java.util.TreeSet<jkt.hms.masters.business.IpdMedicineIssueDetails>());
		getIpdMedicineIssueDetails().add(ipdMedicineIssueDetails);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.IpdMedicineIssueHeader)) return false;
		else {
			jkt.hms.masters.business.IpdMedicineIssueHeader ipdMedicineIssueHeader = (jkt.hms.masters.business.IpdMedicineIssueHeader) obj;
			if (null == this.getId() || null == ipdMedicineIssueHeader.getId()) return false;
			else return (this.getId().equals(ipdMedicineIssueHeader.getId()));
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
package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the pending_prescription_detail table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="pending_prescription_detail"
 */

public abstract class BasePendingPrescriptionDetail  implements Serializable {

	public static String REF = "PendingPrescriptionDetail";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ITEM = "Item";
	public static String PROP_DEPT = "Dept";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_PRESCRIPTION = "Prescription";
	public static String PROP_ID = "Id";
	public static String PROP_PATIENT_PRESCRIPTION_DETAILS = "PatientPrescriptionDetails";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BasePendingPrescriptionDetail () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePendingPrescriptionDetail (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BasePendingPrescriptionDetail (
		java.lang.Integer id,
		jkt.hms.masters.business.MasHospital hospital,
		jkt.hms.masters.business.MasDepartment dept,
		jkt.hms.masters.business.MasStoreItem item,
		jkt.hms.masters.business.PatientPrescriptionDetails patientPrescriptionDetails,
		jkt.hms.masters.business.PatientPrescriptionHeader prescription,
		java.lang.String status,
		java.lang.String lastChgBy,
		java.lang.String lastChgTime,
		java.util.Date lastChgDate) {

		this.setId(id);
		this.setHospital(hospital);
		this.setDept(dept);
		this.setItem(item);
		this.setPatientPrescriptionDetails(patientPrescriptionDetails);
		this.setPrescription(prescription);
		this.setStatus(status);
		this.setLastChgBy(lastChgBy);
		this.setLastChgTime(lastChgTime);
		this.setLastChgDate(lastChgDate);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.lang.String lastChgTime;
	private java.util.Date lastChgDate;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment dept;
	private jkt.hms.masters.business.MasStoreItem item;
	private jkt.hms.masters.business.PatientPrescriptionDetails patientPrescriptionDetails;
	private jkt.hms.masters.business.PatientPrescriptionHeader prescription;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="pres_detail_id"
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
	 * Return the value associated with the column: dept_id
	 */
	public jkt.hms.masters.business.MasDepartment getDept () {
		return dept;
	}

	/**
	 * Set the value related to the column: dept_id
	 * @param dept the dept_id value
	 */
	public void setDept (jkt.hms.masters.business.MasDepartment dept) {
		this.dept = dept;
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
	 * Return the value associated with the column: id
	 */
	public jkt.hms.masters.business.PatientPrescriptionDetails getPatientPrescriptionDetails () {
		return patientPrescriptionDetails;
	}

	/**
	 * Set the value related to the column: id
	 * @param patientPrescriptionDetails the id value
	 */
	public void setPatientPrescriptionDetails (jkt.hms.masters.business.PatientPrescriptionDetails patientPrescriptionDetails) {
		this.patientPrescriptionDetails = patientPrescriptionDetails;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PendingPrescriptionDetail)) return false;
		else {
			jkt.hms.masters.business.PendingPrescriptionDetail pendingPrescriptionDetail = (jkt.hms.masters.business.PendingPrescriptionDetail) obj;
			if (null == this.getId() || null == pendingPrescriptionDetail.getId()) return false;
			else return (this.getId().equals(pendingPrescriptionDetail.getId()));
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
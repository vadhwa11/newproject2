package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * ot_specimen_dispatch_entry table. Do not modify this class because it will be
 * overwritten if the configuration file related to this class is modified.
 * 
 * @hibernate.class table="ot_specimen_dispatch_entry"
 */

public abstract class BaseOtSpecimenDispatchEntry implements Serializable {

	public static String REF = "OtSpecimenDispatchEntry";
	public static String PROP_ENTRY_NO = "EntryNo";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_TISSUE_ORGAN = "TissueOrgan";
	public static String PROP_VISIT = "Visit";
	public static String PROP_OT_SPECIMEN_DISPATCH_ENTRY_DATE = "OtSpecimenDispatchEntryDate";
	public static String PROP_TIME_OF_DISPATCH = "TimeOfDispatch";
	public static String PROP_SPECIMEN_RECEIVED_BY = "SpecimenReceivedBy";
	public static String PROP_EXAMINATION_REQUIRED = "ExaminationRequired";
	public static String PROP_OT_BOOKING = "OtBooking";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_HIN = "Hin";
	public static String PROP_SPECIMEN_DISPATCHED_BY = "SpecimenDispatchedBy";
	public static String PROP_CLINICAL_NOTES = "ClinicalNotes";

	// constructors
	public BaseOtSpecimenDispatchEntry() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOtSpecimenDispatchEntry(java.lang.Integer id) {
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
	private java.util.Date otSpecimenDispatchEntryDate;
	private java.lang.String tissueOrgan;
	private java.lang.String clinicalNotes;
	private java.lang.String examinationRequired;
	private java.lang.String timeOfDispatch;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.OtBooking otBooking;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasEmployee specimenDispatchedBy;
	private jkt.hms.masters.business.MasEmployee specimenReceivedBy;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.Patient hin;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native"
	 *               column="ot_specimen_dispatch_entry_id"
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
	 * Return the value associated with the column:
	 * ot_specimen_dispatch_entry_date
	 */
	public java.util.Date getOtSpecimenDispatchEntryDate() {
		return otSpecimenDispatchEntryDate;
	}

	/**
	 * Set the value related to the column: ot_specimen_dispatch_entry_date
	 * 
	 * @param otSpecimenDispatchEntryDate
	 *            the ot_specimen_dispatch_entry_date value
	 */
	public void setOtSpecimenDispatchEntryDate(
			java.util.Date otSpecimenDispatchEntryDate) {
		this.otSpecimenDispatchEntryDate = otSpecimenDispatchEntryDate;
	}

	/**
	 * Return the value associated with the column: tissue_organ
	 */
	public java.lang.String getTissueOrgan() {
		return tissueOrgan;
	}

	/**
	 * Set the value related to the column: tissue_organ
	 * 
	 * @param tissueOrgan
	 *            the tissue_organ value
	 */
	public void setTissueOrgan(java.lang.String tissueOrgan) {
		this.tissueOrgan = tissueOrgan;
	}

	/**
	 * Return the value associated with the column: clinical_notes
	 */
	public java.lang.String getClinicalNotes() {
		return clinicalNotes;
	}

	/**
	 * Set the value related to the column: clinical_notes
	 * 
	 * @param clinicalNotes
	 *            the clinical_notes value
	 */
	public void setClinicalNotes(java.lang.String clinicalNotes) {
		this.clinicalNotes = clinicalNotes;
	}

	/**
	 * Return the value associated with the column: examination_required
	 */
	public java.lang.String getExaminationRequired() {
		return examinationRequired;
	}

	/**
	 * Set the value related to the column: examination_required
	 * 
	 * @param examinationRequired
	 *            the examination_required value
	 */
	public void setExaminationRequired(java.lang.String examinationRequired) {
		this.examinationRequired = examinationRequired;
	}

	/**
	 * Return the value associated with the column: time_of_dispatch
	 */
	public java.lang.String getTimeOfDispatch() {
		return timeOfDispatch;
	}

	/**
	 * Set the value related to the column: time_of_dispatch
	 * 
	 * @param timeOfDispatch
	 *            the time_of_dispatch value
	 */
	public void setTimeOfDispatch(java.lang.String timeOfDispatch) {
		this.timeOfDispatch = timeOfDispatch;
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
	 * Return the value associated with the column: ot_booking_id
	 */
	public jkt.hms.masters.business.OtBooking getOtBooking() {
		return otBooking;
	}

	/**
	 * Set the value related to the column: ot_booking_id
	 * 
	 * @param otBooking
	 *            the ot_booking_id value
	 */
	public void setOtBooking(jkt.hms.masters.business.OtBooking otBooking) {
		this.otBooking = otBooking;
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
	 * Return the value associated with the column: specimen_dispatched_by
	 */
	public jkt.hms.masters.business.MasEmployee getSpecimenDispatchedBy() {
		return specimenDispatchedBy;
	}

	/**
	 * Set the value related to the column: specimen_dispatched_by
	 * 
	 * @param specimenDispatchedBy
	 *            the specimen_dispatched_by value
	 */
	public void setSpecimenDispatchedBy(
			jkt.hms.masters.business.MasEmployee specimenDispatchedBy) {
		this.specimenDispatchedBy = specimenDispatchedBy;
	}

	/**
	 * Return the value associated with the column: specimen_received_by
	 */
	public jkt.hms.masters.business.MasEmployee getSpecimenReceivedBy() {
		return specimenReceivedBy;
	}

	/**
	 * Set the value related to the column: specimen_received_by
	 * 
	 * @param specimenReceivedBy
	 *            the specimen_received_by value
	 */
	public void setSpecimenReceivedBy(
			jkt.hms.masters.business.MasEmployee specimenReceivedBy) {
		this.specimenReceivedBy = specimenReceivedBy;
	}

	/**
	 * Return the value associated with the column: visit_id
	 */
	public jkt.hms.masters.business.Visit getVisit() {
		return visit;
	}

	/**
	 * Set the value related to the column: visit_id
	 * 
	 * @param visit
	 *            the visit_id value
	 */
	public void setVisit(jkt.hms.masters.business.Visit visit) {
		this.visit = visit;
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

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.OtSpecimenDispatchEntry))
			return false;
		else {
			jkt.hms.masters.business.OtSpecimenDispatchEntry otSpecimenDispatchEntry = (jkt.hms.masters.business.OtSpecimenDispatchEntry) obj;
			if (null == this.getId() || null == otSpecimenDispatchEntry.getId())
				return false;
			else
				return (this.getId().equals(otSpecimenDispatchEntry.getId()));
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
package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the ot_human_body_disposal
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="ot_human_body_disposal"
 */

public abstract class BaseOtHumanBodyDisposal implements Serializable {

	public static String REF = "OtHumanBodyDisposal";
	public static String PROP_ENTRY_NO = "EntryNo";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_DISPATCH_DATE = "DispatchDate";
	public static String PROP_TISSUE_ORGAN = "TissueOrgan";
	public static String PROP_TIME_OF_DISPATCH = "TimeOfDispatch";
	public static String PROP_SPECIMEN_RECIEVED_BY = "SpecimenRecievedBy";
	public static String PROP_OT_BOOKING = "OtBooking";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAS_CHG_BY = "LasChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_CLINICAL_NOTES = "ClinicalNotes";
	public static String PROP_HIN = "Hin";
	public static String PROP_SPECIMEN_DISPATCHED_BY = "SpecimenDispatchedBy";

	// constructors
	public BaseOtHumanBodyDisposal() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOtHumanBodyDisposal(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String tissueOrgan;
	private java.lang.Integer entryNo;
	private java.lang.String clinicalNotes;
	private java.lang.String timeOfDispatch;
	private java.lang.String lasChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.util.Date dispatchDate;

	// many to one
	private jkt.hms.masters.business.MasEmployee specimenRecievedBy;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.MasDepartment specimenDispatchedBy;
	private jkt.hms.masters.business.OtBooking otBooking;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="disposal_id"
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
	 * Return the value associated with the column: entry_no
	 */
	public java.lang.Integer getEntryNo() {
		return entryNo;
	}

	/**
	 * Set the value related to the column: entry_no
	 * 
	 * @param entryNo
	 *            the entry_no value
	 */
	public void setEntryNo(java.lang.Integer entryNo) {
		this.entryNo = entryNo;
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
	 * Return the value associated with the column: las_chg_by
	 */
	public java.lang.String getLasChgBy() {
		return lasChgBy;
	}

	/**
	 * Set the value related to the column: las_chg_by
	 * 
	 * @param lasChgBy
	 *            the las_chg_by value
	 */
	public void setLasChgBy(java.lang.String lasChgBy) {
		this.lasChgBy = lasChgBy;
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
	 * Return the value associated with the column: dispatch_date
	 */
	public java.util.Date getDispatchDate() {
		return dispatchDate;
	}

	/**
	 * Set the value related to the column: dispatch_date
	 * 
	 * @param dispatchDate
	 *            the dispatch_date value
	 */
	public void setDispatchDate(java.util.Date dispatchDate) {
		this.dispatchDate = dispatchDate;
	}

	/**
	 * Return the value associated with the column: specimen_recieved_by
	 */
	public jkt.hms.masters.business.MasEmployee getSpecimenRecievedBy() {
		return specimenRecievedBy;
	}

	/**
	 * Set the value related to the column: specimen_recieved_by
	 * 
	 * @param specimenRecievedBy
	 *            the specimen_recieved_by value
	 */
	public void setSpecimenRecievedBy(
			jkt.hms.masters.business.MasEmployee specimenRecievedBy) {
		this.specimenRecievedBy = specimenRecievedBy;
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
	 * Return the value associated with the column: specimen_dispatched_by
	 */
	public jkt.hms.masters.business.MasDepartment getSpecimenDispatchedBy() {
		return specimenDispatchedBy;
	}

	/**
	 * Set the value related to the column: specimen_dispatched_by
	 * 
	 * @param specimenDispatchedBy
	 *            the specimen_dispatched_by value
	 */
	public void setSpecimenDispatchedBy(
			jkt.hms.masters.business.MasDepartment specimenDispatchedBy) {
		this.specimenDispatchedBy = specimenDispatchedBy;
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

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.OtHumanBodyDisposal))
			return false;
		else {
			jkt.hms.masters.business.OtHumanBodyDisposal otHumanBodyDisposal = (jkt.hms.masters.business.OtHumanBodyDisposal) obj;
			if (null == this.getId() || null == otHumanBodyDisposal.getId())
				return false;
			else
				return (this.getId().equals(otHumanBodyDisposal.getId()));
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
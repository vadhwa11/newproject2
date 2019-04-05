package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * ot_procedure_notes_entry_header table. Do not modify this class because it
 * will be overwritten if the configuration file related to this class is
 * modified.
 * 
 * @hibernate.class table="ot_procedure_notes_entry_header"
 */

public abstract class BaseOtProcedureNotesEntryHeader implements Serializable {

	public static String REF = "OtProcedureNotesEntryHeader";
	public static String PROP_YEARLY_SERIAL_NO = "YearlySerialNo";
	public static String PROP_MONTHLY_SERIAL_NO = "MonthlySerialNo";
	public static String PROP_PRE_OP_ORDERS = "PreOpOrders";
	public static String PROP_SURGERY_FROM_TIME = "SurgeryFromTime";
	public static String PROP_FINDINGS_N_PROCEDURES = "FindingsNProcedures";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ANAESTHESIA = "Anaesthesia";
	public static String PROP_SURGERY_TO_TIME = "SurgeryToTime";
	public static String PROP_VISIT = "Visit";
	public static String PROP_OT_BOOKING = "OtBooking";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_DATE = "Date";
	public static String PROP_ANAESTHESIA_VALUE = "AnaesthesiaValue";
	public static String PROP_ID = "Id";
	public static String PROP_POST_OP_ORDERS = "PostOpOrders";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_HIN = "Hin";

	// constructors
	public BaseOtProcedureNotesEntryHeader() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOtProcedureNotesEntryHeader(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date date;
	private java.lang.String surgeryToTime;
	private java.lang.String surgeryFromTime;
	private java.lang.String preOpOrders;
	private java.lang.String findingsNProcedures;
	private java.lang.String postOpOrders;
	private java.lang.String lastChgBy;
	private java.lang.String lastChgTime;
	private java.util.Date lastChgDate;
	private java.lang.String yearlySerialNo;
	private java.lang.String monthlySerialNo;
	private java.lang.String anaesthesiaValue;

	// many to one
	private jkt.hms.masters.business.MasAnesthesia anaesthesia;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.OtBooking otBooking;

	// collections
	private java.util.Set<jkt.hms.masters.business.OtProcedureNotesEntryDetail> otProcedureNotesEntryDetails;

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
	 * Return the value associated with the column: date
	 */
	public java.util.Date getDate() {
		return date;
	}

	/**
	 * Set the value related to the column: date
	 * 
	 * @param date
	 *            the date value
	 */
	public void setDate(java.util.Date date) {
		this.date = date;
	}

	/**
	 * Return the value associated with the column: surgery_to_time
	 */
	public java.lang.String getSurgeryToTime() {
		return surgeryToTime;
	}

	/**
	 * Set the value related to the column: surgery_to_time
	 * 
	 * @param surgeryToTime
	 *            the surgery_to_time value
	 */
	public void setSurgeryToTime(java.lang.String surgeryToTime) {
		this.surgeryToTime = surgeryToTime;
	}

	/**
	 * Return the value associated with the column: surgery_from_time
	 */
	public java.lang.String getSurgeryFromTime() {
		return surgeryFromTime;
	}

	/**
	 * Set the value related to the column: surgery_from_time
	 * 
	 * @param surgeryFromTime
	 *            the surgery_from_time value
	 */
	public void setSurgeryFromTime(java.lang.String surgeryFromTime) {
		this.surgeryFromTime = surgeryFromTime;
	}

	/**
	 * Return the value associated with the column: pre_op_orders
	 */
	public java.lang.String getPreOpOrders() {
		return preOpOrders;
	}

	/**
	 * Set the value related to the column: pre_op_orders
	 * 
	 * @param preOpOrders
	 *            the pre_op_orders value
	 */
	public void setPreOpOrders(java.lang.String preOpOrders) {
		this.preOpOrders = preOpOrders;
	}

	/**
	 * Return the value associated with the column: findings_n_procedures
	 */
	public java.lang.String getFindingsNProcedures() {
		return findingsNProcedures;
	}

	/**
	 * Set the value related to the column: findings_n_procedures
	 * 
	 * @param findingsNProcedures
	 *            the findings_n_procedures value
	 */
	public void setFindingsNProcedures(java.lang.String findingsNProcedures) {
		this.findingsNProcedures = findingsNProcedures;
	}

	/**
	 * Return the value associated with the column: post_op_orders
	 */
	public java.lang.String getPostOpOrders() {
		return postOpOrders;
	}

	/**
	 * Set the value related to the column: post_op_orders
	 * 
	 * @param postOpOrders
	 *            the post_op_orders value
	 */
	public void setPostOpOrders(java.lang.String postOpOrders) {
		this.postOpOrders = postOpOrders;
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
	 * Return the value associated with the column: yearly_serial_no
	 */
	public java.lang.String getYearlySerialNo() {
		return yearlySerialNo;
	}

	/**
	 * Set the value related to the column: yearly_serial_no
	 * 
	 * @param yearlySerialNo
	 *            the yearly_serial_no value
	 */
	public void setYearlySerialNo(java.lang.String yearlySerialNo) {
		this.yearlySerialNo = yearlySerialNo;
	}

	/**
	 * Return the value associated with the column: monthly_serial_no
	 */
	public java.lang.String getMonthlySerialNo() {
		return monthlySerialNo;
	}

	/**
	 * Set the value related to the column: monthly_serial_no
	 * 
	 * @param monthlySerialNo
	 *            the monthly_serial_no value
	 */
	public void setMonthlySerialNo(java.lang.String monthlySerialNo) {
		this.monthlySerialNo = monthlySerialNo;
	}

	/**
	 * Return the value associated with the column: anaesthesia_value
	 */
	public java.lang.String getAnaesthesiaValue() {
		return anaesthesiaValue;
	}

	/**
	 * Set the value related to the column: anaesthesia_value
	 * 
	 * @param anaesthesiaValue
	 *            the anaesthesia_value value
	 */
	public void setAnaesthesiaValue(java.lang.String anaesthesiaValue) {
		this.anaesthesiaValue = anaesthesiaValue;
	}

	/**
	 * Return the value associated with the column: anaesthesia_id
	 */
	public jkt.hms.masters.business.MasAnesthesia getAnaesthesia() {
		return anaesthesia;
	}

	/**
	 * Set the value related to the column: anaesthesia_id
	 * 
	 * @param anaesthesia
	 *            the anaesthesia_id value
	 */
	public void setAnaesthesia(
			jkt.hms.masters.business.MasAnesthesia anaesthesia) {
		this.anaesthesia = anaesthesia;
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
	 * Return the value associated with the column: OtProcedureNotesEntryDetails
	 */
	public java.util.Set<jkt.hms.masters.business.OtProcedureNotesEntryDetail> getOtProcedureNotesEntryDetails() {
		return otProcedureNotesEntryDetails;
	}

	/**
	 * Set the value related to the column: OtProcedureNotesEntryDetails
	 * 
	 * @param otProcedureNotesEntryDetails
	 *            the OtProcedureNotesEntryDetails value
	 */
	public void setOtProcedureNotesEntryDetails(
			java.util.Set<jkt.hms.masters.business.OtProcedureNotesEntryDetail> otProcedureNotesEntryDetails) {
		this.otProcedureNotesEntryDetails = otProcedureNotesEntryDetails;
	}

	public void addToOtProcedureNotesEntryDetails(
			jkt.hms.masters.business.OtProcedureNotesEntryDetail otProcedureNotesEntryDetail) {
		if (null == getOtProcedureNotesEntryDetails())
			setOtProcedureNotesEntryDetails(new java.util.TreeSet<jkt.hms.masters.business.OtProcedureNotesEntryDetail>());
		getOtProcedureNotesEntryDetails().add(otProcedureNotesEntryDetail);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.OtProcedureNotesEntryHeader))
			return false;
		else {
			jkt.hms.masters.business.OtProcedureNotesEntryHeader otProcedureNotesEntryHeader = (jkt.hms.masters.business.OtProcedureNotesEntryHeader) obj;
			if (null == this.getId()
					|| null == otProcedureNotesEntryHeader.getId())
				return false;
			else
				return (this.getId()
						.equals(otProcedureNotesEntryHeader.getId()));
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
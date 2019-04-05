package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ot_booking table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ot_booking"
 */

public abstract class BaseOtBooking  implements Serializable {

	public static String REF = "OtBooking";
	public static String PROP_LAST_CHGD_TIME = "LastChgdTime";
	public static String PROP_OT_PRE_ANESTHESIA_STATUS = "OtPreAnesthesiaStatus";
	public static String PROP_POST_OP_NOTES_ANAESTHESIA_STATUS = "PostOpNotesAnaesthesiaStatus";
	public static String PROP_LAST_CHGD_DATE = "LastChgdDate";
	public static String PROP_POST_OP_NOTES_SURGERY_STATUS = "PostOpNotesSurgeryStatus";
	public static String PROP_OT_PRE_ANESTHESIA_DETAILS = "OtPreAnesthesiaDetails";
	public static String PROP_LAST_CHGD_BY = "LastChgdBy";
	public static String PROP_BOOKING_TYPE = "BookingType";
	public static String PROP_ORDER_NO = "OrderNo";
	public static String PROP_ADDITIONAL_NOTES = "AdditionalNotes";
	public static String PROP_CHARGE_CODE = "ChargeCode";
	public static String PROP_SURGERY_TIME = "SurgeryTime";
	public static String PROP_SURGERY_DATE = "SurgeryDate";
	public static String PROP_SL_NO = "SlNo";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_CANCEL_REMARKS = "CancelRemarks";
	public static String PROP_BOOKED_BY = "BookedBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_OT_REMARKS = "OtRemarks";
	public static String PROP_SPECIMEN_DISPATCH_ENTRY_STATUS = "SpecimenDispatchEntryStatus";
	public static String PROP_VISIT = "Visit";
	public static String PROP_SURGERY_STATUS = "SurgeryStatus";
	public static String PROP_SURGERY_DONE_STATUS = "SurgeryDoneStatus";
	public static String PROP_OT = "Ot";
	public static String PROP_SURGERY_END_TIME = "SurgeryEndTime";
	public static String PROP_OT_BOOKING_STATUS = "OtBookingStatus";
	public static String PROP_OT_POST_ANETHESIA_STATUS = "OtPostAnethesiaStatus";
	public static String PROP_OPD_SURSERY_HEADER = "OpdSurseryHeader";
	public static String PROP_ID = "Id";
	public static String PROP_HIN = "Hin";
	public static String PROP_BED = "Bed";
	public static String PROP_BODY_PARTS_DISPOSAL_STATUS = "BodyPartsDisposalStatus";
	public static String PROP_SURGERY_START_TIME = "SurgeryStartTime";


	// constructors
	public BaseOtBooking () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOtBooking (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date surgeryDate;
	private java.lang.String surgeryTime;
	private java.util.Date lastChgdDate;
	private java.lang.String lastChgdTime;
	private java.lang.Integer orderNo;
	private java.lang.String otBookingStatus;
	private java.lang.Integer slNo;
	private java.lang.String bookingType;
	private java.lang.String postOpNotesAnaesthesiaStatus;
	private java.lang.String postOpNotesSurgeryStatus;
	private java.lang.String specimenDispatchEntryStatus;
	private java.lang.String surgeryDoneStatus;
	private java.lang.String bodyPartsDisposalStatus;
	private java.lang.String surgeryStatus;
	private java.lang.String otPostAnethesiaStatus;
	private java.lang.String surgeryStartTime;
	private java.lang.String surgeryEndTime;
	private java.lang.String cancelRemarks;
	private java.lang.String otRemarks;
	private java.lang.String otPreAnesthesiaStatus;
	private java.lang.String additionalNotes;

	// many to one
	private jkt.hms.masters.business.MasChargeCode chargeCode;
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.MasOt ot;
	private jkt.hms.masters.business.OtPreAnesthesiaDetails otPreAnesthesiaDetails;
	private jkt.hms.masters.business.MasEmployee bookedBy;
	private jkt.hms.masters.business.OpdSurgeryHeader opdSurseryHeader;
	private jkt.hms.masters.business.Users lastChgdBy;
	private jkt.hms.masters.business.MasBed bed;

	// collections
	private java.util.Set<jkt.hms.masters.business.OtPreAnaesthesiaProcNotesMain> otPreAnaesthesiaProcNotesMains;
	private java.util.Set<jkt.hms.masters.business.OtBookSurgeon> otBookSurgeons;
	private java.util.Set<jkt.hms.masters.business.OtBookingDt> otBookingDt;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="booking_id"
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
	 * Return the value associated with the column: surgery_date
	 */
	public java.util.Date getSurgeryDate () {
		return surgeryDate;
	}

	/**
	 * Set the value related to the column: surgery_date
	 * @param surgeryDate the surgery_date value
	 */
	public void setSurgeryDate (java.util.Date surgeryDate) {
		this.surgeryDate = surgeryDate;
	}



	/**
	 * Return the value associated with the column: surgery_time
	 */
	public java.lang.String getSurgeryTime () {
		return surgeryTime;
	}

	/**
	 * Set the value related to the column: surgery_time
	 * @param surgeryTime the surgery_time value
	 */
	public void setSurgeryTime (java.lang.String surgeryTime) {
		this.surgeryTime = surgeryTime;
	}



	/**
	 * Return the value associated with the column: last_chgd_date
	 */
	public java.util.Date getLastChgdDate () {
		return lastChgdDate;
	}

	/**
	 * Set the value related to the column: last_chgd_date
	 * @param lastChgdDate the last_chgd_date value
	 */
	public void setLastChgdDate (java.util.Date lastChgdDate) {
		this.lastChgdDate = lastChgdDate;
	}



	/**
	 * Return the value associated with the column: last_chgd_time
	 */
	public java.lang.String getLastChgdTime () {
		return lastChgdTime;
	}

	/**
	 * Set the value related to the column: last_chgd_time
	 * @param lastChgdTime the last_chgd_time value
	 */
	public void setLastChgdTime (java.lang.String lastChgdTime) {
		this.lastChgdTime = lastChgdTime;
	}



	/**
	 * Return the value associated with the column: order_no
	 */
	public java.lang.Integer getOrderNo () {
		return orderNo;
	}

	/**
	 * Set the value related to the column: order_no
	 * @param orderNo the order_no value
	 */
	public void setOrderNo (java.lang.Integer orderNo) {
		this.orderNo = orderNo;
	}



	/**
	 * Return the value associated with the column: ot_booking_status
	 */
	public java.lang.String getOtBookingStatus () {
		return otBookingStatus;
	}

	/**
	 * Set the value related to the column: ot_booking_status
	 * @param otBookingStatus the ot_booking_status value
	 */
	public void setOtBookingStatus (java.lang.String otBookingStatus) {
		this.otBookingStatus = otBookingStatus;
	}



	/**
	 * Return the value associated with the column: sl_no
	 */
	public java.lang.Integer getSlNo () {
		return slNo;
	}

	/**
	 * Set the value related to the column: sl_no
	 * @param slNo the sl_no value
	 */
	public void setSlNo (java.lang.Integer slNo) {
		this.slNo = slNo;
	}



	/**
	 * Return the value associated with the column: booking_type
	 */
	public java.lang.String getBookingType () {
		return bookingType;
	}

	/**
	 * Set the value related to the column: booking_type
	 * @param bookingType the booking_type value
	 */
	public void setBookingType (java.lang.String bookingType) {
		this.bookingType = bookingType;
	}



	/**
	 * Return the value associated with the column: post_op_notes_anaesthesia_status
	 */
	public java.lang.String getPostOpNotesAnaesthesiaStatus () {
		return postOpNotesAnaesthesiaStatus;
	}

	/**
	 * Set the value related to the column: post_op_notes_anaesthesia_status
	 * @param postOpNotesAnaesthesiaStatus the post_op_notes_anaesthesia_status value
	 */
	public void setPostOpNotesAnaesthesiaStatus (java.lang.String postOpNotesAnaesthesiaStatus) {
		this.postOpNotesAnaesthesiaStatus = postOpNotesAnaesthesiaStatus;
	}



	/**
	 * Return the value associated with the column: post_op_notes_surgery_status
	 */
	public java.lang.String getPostOpNotesSurgeryStatus () {
		return postOpNotesSurgeryStatus;
	}

	/**
	 * Set the value related to the column: post_op_notes_surgery_status
	 * @param postOpNotesSurgeryStatus the post_op_notes_surgery_status value
	 */
	public void setPostOpNotesSurgeryStatus (java.lang.String postOpNotesSurgeryStatus) {
		this.postOpNotesSurgeryStatus = postOpNotesSurgeryStatus;
	}



	/**
	 * Return the value associated with the column: specimen_dispatch_entry_status
	 */
	public java.lang.String getSpecimenDispatchEntryStatus () {
		return specimenDispatchEntryStatus;
	}

	/**
	 * Set the value related to the column: specimen_dispatch_entry_status
	 * @param specimenDispatchEntryStatus the specimen_dispatch_entry_status value
	 */
	public void setSpecimenDispatchEntryStatus (java.lang.String specimenDispatchEntryStatus) {
		this.specimenDispatchEntryStatus = specimenDispatchEntryStatus;
	}



	/**
	 * Return the value associated with the column: surgery_done_status
	 */
	public java.lang.String getSurgeryDoneStatus () {
		return surgeryDoneStatus;
	}

	/**
	 * Set the value related to the column: surgery_done_status
	 * @param surgeryDoneStatus the surgery_done_status value
	 */
	public void setSurgeryDoneStatus (java.lang.String surgeryDoneStatus) {
		this.surgeryDoneStatus = surgeryDoneStatus;
	}



	/**
	 * Return the value associated with the column: body_parts_disposal_status
	 */
	public java.lang.String getBodyPartsDisposalStatus () {
		return bodyPartsDisposalStatus;
	}

	/**
	 * Set the value related to the column: body_parts_disposal_status
	 * @param bodyPartsDisposalStatus the body_parts_disposal_status value
	 */
	public void setBodyPartsDisposalStatus (java.lang.String bodyPartsDisposalStatus) {
		this.bodyPartsDisposalStatus = bodyPartsDisposalStatus;
	}



	/**
	 * Return the value associated with the column: surgery_status
	 */
	public java.lang.String getSurgeryStatus () {
		return surgeryStatus;
	}

	/**
	 * Set the value related to the column: surgery_status
	 * @param surgeryStatus the surgery_status value
	 */
	public void setSurgeryStatus (java.lang.String surgeryStatus) {
		this.surgeryStatus = surgeryStatus;
	}



	/**
	 * Return the value associated with the column: ot_post_anethesia_status
	 */
	public java.lang.String getOtPostAnethesiaStatus () {
		return otPostAnethesiaStatus;
	}

	/**
	 * Set the value related to the column: ot_post_anethesia_status
	 * @param otPostAnethesiaStatus the ot_post_anethesia_status value
	 */
	public void setOtPostAnethesiaStatus (java.lang.String otPostAnethesiaStatus) {
		this.otPostAnethesiaStatus = otPostAnethesiaStatus;
	}



	/**
	 * Return the value associated with the column: surgery_start_time
	 */
	public java.lang.String getSurgeryStartTime () {
		return surgeryStartTime;
	}

	/**
	 * Set the value related to the column: surgery_start_time
	 * @param surgeryStartTime the surgery_start_time value
	 */
	public void setSurgeryStartTime (java.lang.String surgeryStartTime) {
		this.surgeryStartTime = surgeryStartTime;
	}



	/**
	 * Return the value associated with the column: surgery_end_time
	 */
	public java.lang.String getSurgeryEndTime () {
		return surgeryEndTime;
	}

	/**
	 * Set the value related to the column: surgery_end_time
	 * @param surgeryEndTime the surgery_end_time value
	 */
	public void setSurgeryEndTime (java.lang.String surgeryEndTime) {
		this.surgeryEndTime = surgeryEndTime;
	}



	/**
	 * Return the value associated with the column: cancel_remarks
	 */
	public java.lang.String getCancelRemarks () {
		return cancelRemarks;
	}

	/**
	 * Set the value related to the column: cancel_remarks
	 * @param cancelRemarks the cancel_remarks value
	 */
	public void setCancelRemarks (java.lang.String cancelRemarks) {
		this.cancelRemarks = cancelRemarks;
	}



	/**
	 * Return the value associated with the column: ot_remarks
	 */
	public java.lang.String getOtRemarks () {
		return otRemarks;
	}

	/**
	 * Set the value related to the column: ot_remarks
	 * @param otRemarks the ot_remarks value
	 */
	public void setOtRemarks (java.lang.String otRemarks) {
		this.otRemarks = otRemarks;
	}



	/**
	 * Return the value associated with the column: ot_pre_anesthesia_status
	 */
	public java.lang.String getOtPreAnesthesiaStatus () {
		return otPreAnesthesiaStatus;
	}

	/**
	 * Set the value related to the column: ot_pre_anesthesia_status
	 * @param otPreAnesthesiaStatus the ot_pre_anesthesia_status value
	 */
	public void setOtPreAnesthesiaStatus (java.lang.String otPreAnesthesiaStatus) {
		this.otPreAnesthesiaStatus = otPreAnesthesiaStatus;
	}



	/**
	 * Return the value associated with the column: additional_notes
	 */
	public java.lang.String getAdditionalNotes () {
		return additionalNotes;
	}

	/**
	 * Set the value related to the column: additional_notes
	 * @param additionalNotes the additional_notes value
	 */
	public void setAdditionalNotes (java.lang.String additionalNotes) {
		this.additionalNotes = additionalNotes;
	}



	/**
	 * Return the value associated with the column: charge_code_id
	 */
	public jkt.hms.masters.business.MasChargeCode getChargeCode () {
		return chargeCode;
	}

	/**
	 * Set the value related to the column: charge_code_id
	 * @param chargeCode the charge_code_id value
	 */
	public void setChargeCode (jkt.hms.masters.business.MasChargeCode chargeCode) {
		this.chargeCode = chargeCode;
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
	 * Return the value associated with the column: visit_id
	 */
	public jkt.hms.masters.business.Visit getVisit () {
		return visit;
	}

	/**
	 * Set the value related to the column: visit_id
	 * @param visit the visit_id value
	 */
	public void setVisit (jkt.hms.masters.business.Visit visit) {
		this.visit = visit;
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
	 * Return the value associated with the column: ot_id
	 */
	public jkt.hms.masters.business.MasOt getOt () {
		return ot;
	}

	/**
	 * Set the value related to the column: ot_id
	 * @param ot the ot_id value
	 */
	public void setOt (jkt.hms.masters.business.MasOt ot) {
		this.ot = ot;
	}



	/**
	 * Return the value associated with the column: ot_pre_anesthesia_details_id
	 */
	public jkt.hms.masters.business.OtPreAnesthesiaDetails getOtPreAnesthesiaDetails () {
		return otPreAnesthesiaDetails;
	}

	/**
	 * Set the value related to the column: ot_pre_anesthesia_details_id
	 * @param otPreAnesthesiaDetails the ot_pre_anesthesia_details_id value
	 */
	public void setOtPreAnesthesiaDetails (jkt.hms.masters.business.OtPreAnesthesiaDetails otPreAnesthesiaDetails) {
		this.otPreAnesthesiaDetails = otPreAnesthesiaDetails;
	}



	/**
	 * Return the value associated with the column: booked_by
	 */
	public jkt.hms.masters.business.MasEmployee getBookedBy () {
		return bookedBy;
	}

	/**
	 * Set the value related to the column: booked_by
	 * @param bookedBy the booked_by value
	 */
	public void setBookedBy (jkt.hms.masters.business.MasEmployee bookedBy) {
		this.bookedBy = bookedBy;
	}



	/**
	 * Return the value associated with the column: opd_sursery_header_id
	 */
	public jkt.hms.masters.business.OpdSurgeryHeader getOpdSurseryHeader () {
		return opdSurseryHeader;
	}

	/**
	 * Set the value related to the column: opd_sursery_header_id
	 * @param opdSurseryHeader the opd_sursery_header_id value
	 */
	public void setOpdSurseryHeader (jkt.hms.masters.business.OpdSurgeryHeader opdSurseryHeader) {
		this.opdSurseryHeader = opdSurseryHeader;
	}



	/**
	 * Return the value associated with the column: last_chgd_by
	 */
	public jkt.hms.masters.business.Users getLastChgdBy () {
		return lastChgdBy;
	}

	/**
	 * Set the value related to the column: last_chgd_by
	 * @param lastChgdBy the last_chgd_by value
	 */
	public void setLastChgdBy (jkt.hms.masters.business.Users lastChgdBy) {
		this.lastChgdBy = lastChgdBy;
	}



	/**
	 * Return the value associated with the column: bed_id
	 */
	public jkt.hms.masters.business.MasBed getBed () {
		return bed;
	}

	/**
	 * Set the value related to the column: bed_id
	 * @param bed the bed_id value
	 */
	public void setBed (jkt.hms.masters.business.MasBed bed) {
		this.bed = bed;
	}



	/**
	 * Return the value associated with the column: OtPreAnaesthesiaProcNotesMains
	 */
	public java.util.Set<jkt.hms.masters.business.OtPreAnaesthesiaProcNotesMain> getOtPreAnaesthesiaProcNotesMains () {
		return otPreAnaesthesiaProcNotesMains;
	}

	/**
	 * Set the value related to the column: OtPreAnaesthesiaProcNotesMains
	 * @param otPreAnaesthesiaProcNotesMains the OtPreAnaesthesiaProcNotesMains value
	 */
	public void setOtPreAnaesthesiaProcNotesMains (java.util.Set<jkt.hms.masters.business.OtPreAnaesthesiaProcNotesMain> otPreAnaesthesiaProcNotesMains) {
		this.otPreAnaesthesiaProcNotesMains = otPreAnaesthesiaProcNotesMains;
	}

	public void addToOtPreAnaesthesiaProcNotesMains (jkt.hms.masters.business.OtPreAnaesthesiaProcNotesMain otPreAnaesthesiaProcNotesMain) {
		if (null == getOtPreAnaesthesiaProcNotesMains()) setOtPreAnaesthesiaProcNotesMains(new java.util.TreeSet<jkt.hms.masters.business.OtPreAnaesthesiaProcNotesMain>());
		getOtPreAnaesthesiaProcNotesMains().add(otPreAnaesthesiaProcNotesMain);
	}



	/**
	 * Return the value associated with the column: OtBookSurgeons
	 */
	public java.util.Set<jkt.hms.masters.business.OtBookSurgeon> getOtBookSurgeons () {
		return otBookSurgeons;
	}

	/**
	 * Set the value related to the column: OtBookSurgeons
	 * @param otBookSurgeons the OtBookSurgeons value
	 */
	public void setOtBookSurgeons (java.util.Set<jkt.hms.masters.business.OtBookSurgeon> otBookSurgeons) {
		this.otBookSurgeons = otBookSurgeons;
	}

	public void addToOtBookSurgeons (jkt.hms.masters.business.OtBookSurgeon otBookSurgeon) {
		if (null == getOtBookSurgeons()) setOtBookSurgeons(new java.util.TreeSet<jkt.hms.masters.business.OtBookSurgeon>());
		getOtBookSurgeons().add(otBookSurgeon);
	}



	/**
	 * Return the value associated with the column: OtBookingDt
	 */
	public java.util.Set<jkt.hms.masters.business.OtBookingDt> getOtBookingDt () {
		return otBookingDt;
	}

	/**
	 * Set the value related to the column: OtBookingDt
	 * @param otBookingDt the OtBookingDt value
	 */
	public void setOtBookingDt (java.util.Set<jkt.hms.masters.business.OtBookingDt> otBookingDt) {
		this.otBookingDt = otBookingDt;
	}

	public void addToOtBookingDt (jkt.hms.masters.business.OtBookingDt otBookingDt) {
		if (null == getOtBookingDt()) setOtBookingDt(new java.util.TreeSet<jkt.hms.masters.business.OtBookingDt>());
		getOtBookingDt().add(otBookingDt);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OtBooking)) return false;
		else {
			jkt.hms.masters.business.OtBooking otBooking = (jkt.hms.masters.business.OtBooking) obj;
			if (null == this.getId() || null == otBooking.getId()) return false;
			else return (this.getId().equals(otBooking.getId()));
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
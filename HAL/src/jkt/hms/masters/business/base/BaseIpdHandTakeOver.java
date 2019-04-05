package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ipd_hand_take_over table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ipd_hand_take_over"
 */

public abstract class BaseIpdHandTakeOver  implements Serializable {

	public static String REF = "IpdHandTakeOver";
	public static String PROP_REMARKS_PENDING_WORK = "RemarksPendingWork";
	public static String PROP_FROM_DEPARTMENT = "FromDepartment";
	public static String PROP_REQUEST_STATUS = "RequestStatus";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ENTRY_NO = "EntryNo";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ENTRY_DATE = "EntryDate";
	public static String PROP_WARD_BED_TRANSFER_REQUIRED = "WardBedTransferRequired";
	public static String PROP_SHIFT_TIME = "ShiftTime";
	public static String PROP_HAND_BY = "HandBy";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_AUTHORISED_BY = "AuthorisedBy";
	public static String PROP_ID = "Id";
	public static String PROP_TAKE_BY = "TakeBy";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_HIN = "Hin";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_ENTRY_TIME = "EntryTime";


	// constructors
	public BaseIpdHandTakeOver () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseIpdHandTakeOver (java.lang.Integer id) {
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
	private java.lang.String shiftTime;
	private java.lang.String remarksPendingWork;
	private java.lang.String entryTime;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String wardBedTransferRequired;

	// many to one
	private jkt.hms.masters.business.MasEmployee takeBy;
	private jkt.hms.masters.business.MasEmployee handBy;
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MmMasRequestStatus requestStatus;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasEmployee authorisedBy;
	private jkt.hms.masters.business.MasDepartment fromDepartment;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.Patient hin;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="org.hibernate.id.IncrementGenerator"
     *  column="hand_take_id"
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
	 * Return the value associated with the column: shift_time
	 */
	public java.lang.String getShiftTime () {
		return shiftTime;
	}

	/**
	 * Set the value related to the column: shift_time
	 * @param shiftTime the shift_time value
	 */
	public void setShiftTime (java.lang.String shiftTime) {
		this.shiftTime = shiftTime;
	}



	/**
	 * Return the value associated with the column: remarks_pending_work
	 */
	public java.lang.String getRemarksPendingWork () {
		return remarksPendingWork;
	}

	/**
	 * Set the value related to the column: remarks_pending_work
	 * @param remarksPendingWork the remarks_pending_work value
	 */
	public void setRemarksPendingWork (java.lang.String remarksPendingWork) {
		this.remarksPendingWork = remarksPendingWork;
	}



	/**
	 * Return the value associated with the column: entry_time
	 */
	public java.lang.String getEntryTime () {
		return entryTime;
	}

	/**
	 * Set the value related to the column: entry_time
	 * @param entryTime the entry_time value
	 */
	public void setEntryTime (java.lang.String entryTime) {
		this.entryTime = entryTime;
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
	 * Return the value associated with the column: ward_bed_transfer_required
	 */
	public java.lang.String getWardBedTransferRequired () {
		return wardBedTransferRequired;
	}

	/**
	 * Set the value related to the column: ward_bed_transfer_required
	 * @param wardBedTransferRequired the ward_bed_transfer_required value
	 */
	public void setWardBedTransferRequired (java.lang.String wardBedTransferRequired) {
		this.wardBedTransferRequired = wardBedTransferRequired;
	}



	/**
	 * Return the value associated with the column: take_by
	 */
	public jkt.hms.masters.business.MasEmployee getTakeBy () {
		return takeBy;
	}

	/**
	 * Set the value related to the column: take_by
	 * @param takeBy the take_by value
	 */
	public void setTakeBy (jkt.hms.masters.business.MasEmployee takeBy) {
		this.takeBy = takeBy;
	}



	/**
	 * Return the value associated with the column: hand_by
	 */
	public jkt.hms.masters.business.MasEmployee getHandBy () {
		return handBy;
	}

	/**
	 * Set the value related to the column: hand_by
	 * @param handBy the hand_by value
	 */
	public void setHandBy (jkt.hms.masters.business.MasEmployee handBy) {
		this.handBy = handBy;
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
	 * Return the value associated with the column: request_status
	 */
	public jkt.hms.masters.business.MmMasRequestStatus getRequestStatus () {
		return requestStatus;
	}

	/**
	 * Set the value related to the column: request_status
	 * @param requestStatus the request_status value
	 */
	public void setRequestStatus (jkt.hms.masters.business.MmMasRequestStatus requestStatus) {
		this.requestStatus = requestStatus;
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
	 * Return the value associated with the column: authorised_by
	 */
	public jkt.hms.masters.business.MasEmployee getAuthorisedBy () {
		return authorisedBy;
	}

	/**
	 * Set the value related to the column: authorised_by
	 * @param authorisedBy the authorised_by value
	 */
	public void setAuthorisedBy (jkt.hms.masters.business.MasEmployee authorisedBy) {
		this.authorisedBy = authorisedBy;
	}



	/**
	 * Return the value associated with the column: from_department
	 */
	public jkt.hms.masters.business.MasDepartment getFromDepartment () {
		return fromDepartment;
	}

	/**
	 * Set the value related to the column: from_department
	 * @param fromDepartment the from_department value
	 */
	public void setFromDepartment (jkt.hms.masters.business.MasDepartment fromDepartment) {
		this.fromDepartment = fromDepartment;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.IpdHandTakeOver)) return false;
		else {
			jkt.hms.masters.business.IpdHandTakeOver ipdHandTakeOver = (jkt.hms.masters.business.IpdHandTakeOver) obj;
			if (null == this.getId() || null == ipdHandTakeOver.getId()) return false;
			else return (this.getId().equals(ipdHandTakeOver.getId()));
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
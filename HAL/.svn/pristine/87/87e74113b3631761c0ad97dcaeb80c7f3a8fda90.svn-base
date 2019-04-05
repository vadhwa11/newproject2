package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the referral_notesheet_header table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="referral_notesheet_header"
 */

public abstract class BaseReferralNotesheetHeader  implements Serializable {

	public static String REF = "ReferralNotesheetHeader";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_ID = "Id";
	public static String PROP_REFERRAL_HEADER = "ReferralHeader";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_NOTE_SHEET_NO = "NoteSheetNo";


	// constructors
	public BaseReferralNotesheetHeader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseReferralNotesheetHeader (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String noteSheetNo;
	private java.lang.String remarks;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.ReferralPatientHeader referralHeader;
	private jkt.hms.masters.business.Users lastChgBy;



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
	 * Return the value associated with the column: note_sheet_no
	 */
	public java.lang.String getNoteSheetNo () {
		return noteSheetNo;
	}

	/**
	 * Set the value related to the column: note_sheet_no
	 * @param noteSheetNo the note_sheet_no value
	 */
	public void setNoteSheetNo (java.lang.String noteSheetNo) {
		this.noteSheetNo = noteSheetNo;
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
	 * Return the value associated with the column: referral_header_id
	 */
	public jkt.hms.masters.business.ReferralPatientHeader getReferralHeader () {
		return referralHeader;
	}

	/**
	 * Set the value related to the column: referral_header_id
	 * @param referralHeader the referral_header_id value
	 */
	public void setReferralHeader (jkt.hms.masters.business.ReferralPatientHeader referralHeader) {
		this.referralHeader = referralHeader;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.ReferralNotesheetHeader)) return false;
		else {
			jkt.hms.masters.business.ReferralNotesheetHeader referralNotesheetHeader = (jkt.hms.masters.business.ReferralNotesheetHeader) obj;
			if (null == this.getId() || null == referralNotesheetHeader.getId()) return false;
			else return (this.getId().equals(referralNotesheetHeader.getId()));
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
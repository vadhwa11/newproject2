package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ot_pre_anaesthesia_proc_notes_main table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ot_pre_anaesthesia_proc_notes_main"
 */

public abstract class BaseOtPreAnaesthesiaProcNotesMain  implements Serializable {

	public static String REF = "OtPreAnaesthesiaProcNotesMain";
	public static String PROP_YEARLY_SERIAL_NO = "YearlySerialNo";
	public static String PROP_MONTHLY_SERIAL_NO = "MonthlySerialNo";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ORDER_NO = "OrderNo";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_ID = "Id";
	public static String PROP_BOOKING = "Booking";
	public static String PROP_VISIT = "Visit";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_PRE_OPERATIVE_ADVICE = "PreOperativeAdvice";
	public static String PROP_HIN = "Hin";


	// constructors
	public BaseOtPreAnaesthesiaProcNotesMain () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOtPreAnaesthesiaProcNotesMain (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String preOperativeAdvice;
	private java.lang.String remarks;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String yearlySerialNo;
	private java.lang.String monthlySerialNo;
	private java.lang.Integer orderNo;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.OtBooking booking;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.Patient hin;

	// collections
	private java.util.Set<jkt.hms.masters.business.OtPreAnaesthesiaProNotesSub> otPreAnaesthesiaProNotesSubs;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
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
	 * Return the value associated with the column: pre_operative_advice
	 */
	public java.lang.String getPreOperativeAdvice () {
		return preOperativeAdvice;
	}

	/**
	 * Set the value related to the column: pre_operative_advice
	 * @param preOperativeAdvice the pre_operative_advice value
	 */
	public void setPreOperativeAdvice (java.lang.String preOperativeAdvice) {
		this.preOperativeAdvice = preOperativeAdvice;
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
	 * Return the value associated with the column: yearly_serial_no
	 */
	public java.lang.String getYearlySerialNo () {
		return yearlySerialNo;
	}

	/**
	 * Set the value related to the column: yearly_serial_no
	 * @param yearlySerialNo the yearly_serial_no value
	 */
	public void setYearlySerialNo (java.lang.String yearlySerialNo) {
		this.yearlySerialNo = yearlySerialNo;
	}



	/**
	 * Return the value associated with the column: monthly_serial_no
	 */
	public java.lang.String getMonthlySerialNo () {
		return monthlySerialNo;
	}

	/**
	 * Set the value related to the column: monthly_serial_no
	 * @param monthlySerialNo the monthly_serial_no value
	 */
	public void setMonthlySerialNo (java.lang.String monthlySerialNo) {
		this.monthlySerialNo = monthlySerialNo;
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
	 * Return the value associated with the column: booking_id
	 */
	public jkt.hms.masters.business.OtBooking getBooking () {
		return booking;
	}

	/**
	 * Set the value related to the column: booking_id
	 * @param booking the booking_id value
	 */
	public void setBooking (jkt.hms.masters.business.OtBooking booking) {
		this.booking = booking;
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
	 * Return the value associated with the column: OtPreAnaesthesiaProNotesSubs
	 */
	public java.util.Set<jkt.hms.masters.business.OtPreAnaesthesiaProNotesSub> getOtPreAnaesthesiaProNotesSubs () {
		return otPreAnaesthesiaProNotesSubs;
	}

	/**
	 * Set the value related to the column: OtPreAnaesthesiaProNotesSubs
	 * @param otPreAnaesthesiaProNotesSubs the OtPreAnaesthesiaProNotesSubs value
	 */
	public void setOtPreAnaesthesiaProNotesSubs (java.util.Set<jkt.hms.masters.business.OtPreAnaesthesiaProNotesSub> otPreAnaesthesiaProNotesSubs) {
		this.otPreAnaesthesiaProNotesSubs = otPreAnaesthesiaProNotesSubs;
	}

	public void addToOtPreAnaesthesiaProNotesSubs (jkt.hms.masters.business.OtPreAnaesthesiaProNotesSub otPreAnaesthesiaProNotesSub) {
		if (null == getOtPreAnaesthesiaProNotesSubs()) setOtPreAnaesthesiaProNotesSubs(new java.util.TreeSet<jkt.hms.masters.business.OtPreAnaesthesiaProNotesSub>());
		getOtPreAnaesthesiaProNotesSubs().add(otPreAnaesthesiaProNotesSub);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OtPreAnaesthesiaProcNotesMain)) return false;
		else {
			jkt.hms.masters.business.OtPreAnaesthesiaProcNotesMain otPreAnaesthesiaProcNotesMain = (jkt.hms.masters.business.OtPreAnaesthesiaProcNotesMain) obj;
			if (null == this.getId() || null == otPreAnaesthesiaProcNotesMain.getId()) return false;
			else return (this.getId().equals(otPreAnaesthesiaProcNotesMain.getId()));
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
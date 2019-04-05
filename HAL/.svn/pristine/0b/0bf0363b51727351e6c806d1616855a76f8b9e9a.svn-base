package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ot_booking_dt table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ot_booking_dt"
 */

public abstract class BaseOtBookingDt  implements Serializable {

	public static String REF = "OtBookingDt";
	public static String PROP_STATUS = "Status";
	public static String PROP_OT_PRE_ANESTHESIA_DETAIL = "OtPreAnesthesiaDetail";
	public static String PROP_OT_BOOKING_HD = "OtBookingHd";
	public static String PROP_ID = "Id";


	// constructors
	public BaseOtBookingDt () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOtBookingDt (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.OtBooking otBookingHd;
	private jkt.hms.masters.business.OtPreAnesthesiaDetail otPreAnesthesiaDetail;



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
	 * Return the value associated with the column: ot_booking_hd
	 */
	public jkt.hms.masters.business.OtBooking getOtBookingHd () {
		return otBookingHd;
	}

	/**
	 * Set the value related to the column: ot_booking_hd
	 * @param otBookingHd the ot_booking_hd value
	 */
	public void setOtBookingHd (jkt.hms.masters.business.OtBooking otBookingHd) {
		this.otBookingHd = otBookingHd;
	}



	/**
	 * Return the value associated with the column: ot_pre_anesthesia_detail
	 */
	public jkt.hms.masters.business.OtPreAnesthesiaDetail getOtPreAnesthesiaDetail () {
		return otPreAnesthesiaDetail;
	}

	/**
	 * Set the value related to the column: ot_pre_anesthesia_detail
	 * @param otPreAnesthesiaDetail the ot_pre_anesthesia_detail value
	 */
	public void setOtPreAnesthesiaDetail (jkt.hms.masters.business.OtPreAnesthesiaDetail otPreAnesthesiaDetail) {
		this.otPreAnesthesiaDetail = otPreAnesthesiaDetail;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OtBookingDt)) return false;
		else {
			jkt.hms.masters.business.OtBookingDt otBookingDt = (jkt.hms.masters.business.OtBookingDt) obj;
			if (null == this.getId() || null == otBookingDt.getId()) return false;
			else return (this.getId().equals(otBookingDt.getId()));
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
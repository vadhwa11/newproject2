package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mis_frw table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mis_frw"
 */

public abstract class BaseMisFrw  implements Serializable {

	public static String REF = "MisFrw";
	public static String PROP_FRW_DATE = "FrwDate";
	public static String PROP_TODATE = "Todate";
	public static String PROP_AD_NO = "AdNo";
	public static String PROP_OTHER_HOSPITAL = "OtherHospital";
	public static String PROP_FRW_SERIAL_NO = "FrwSerialNo";
	public static String PROP_REVIEW = "review";
	public static String PROP_DISPOSED_TO = "DisposedTo";
	public static String PROP_POR = "Por";
	public static String PROP_FRW_ADDRESS = "FrwAddress";
	public static String PROP_FROMDATE = "Fromdate";
	public static String PROP_ID = "Id";
	public static String PROP_TO_DESC = "ToDesc";
	public static String PROP_TO_CLASS = "ToClass";
	public static String PROP_HIN = "Hin";
	public static String PROP_TO_UNIT = "ToUnit";
	public static String PROP_SICKLEAVE = "sickleave";


	// constructors
	public BaseMisFrw () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMisFrw (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseMisFrw (
		java.lang.Integer id,
		jkt.hms.masters.business.MasDisposedTo disposedTo,
		jkt.hms.masters.business.Patient hin,
		jkt.hms.masters.business.MasUnit toUnit) {

		this.setId(id);
		this.setDisposedTo(disposedTo);
		this.setHin(hin);
		this.setToUnit(toUnit);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date frwDate;
	private java.lang.String toDesc;
	private java.lang.String toClass;
	private java.lang.String frwSerialNo;
	private java.lang.String por;
	private java.lang.String otherHospital;
	private java.lang.String sickleave;
	private java.lang.String review;
	private java.util.Date fromdate;
	private java.util.Date todate;
	private java.lang.String frwAddress;
	private java.lang.String adNo;

	// many to one
	private jkt.hms.masters.business.MasDisposedTo disposedTo;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.MasUnit toUnit;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="frw_id"
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
	 * Return the value associated with the column: frw_date
	 */
	public java.util.Date getFrwDate () {
		return frwDate;
	}

	/**
	 * Set the value related to the column: frw_date
	 * @param frwDate the frw_date value
	 */
	public void setFrwDate (java.util.Date frwDate) {
		this.frwDate = frwDate;
	}



	/**
	 * Return the value associated with the column: to_desc
	 */
	public java.lang.String getToDesc () {
		return toDesc;
	}

	/**
	 * Set the value related to the column: to_desc
	 * @param toDesc the to_desc value
	 */
	public void setToDesc (java.lang.String toDesc) {
		this.toDesc = toDesc;
	}



	/**
	 * Return the value associated with the column: to_class
	 */
	public java.lang.String getToClass () {
		return toClass;
	}

	/**
	 * Set the value related to the column: to_class
	 * @param toClass the to_class value
	 */
	public void setToClass (java.lang.String toClass) {
		this.toClass = toClass;
	}



	/**
	 * Return the value associated with the column: frw_serial_no
	 */
	public java.lang.String getFrwSerialNo () {
		return frwSerialNo;
	}

	/**
	 * Set the value related to the column: frw_serial_no
	 * @param frwSerialNo the frw_serial_no value
	 */
	public void setFrwSerialNo (java.lang.String frwSerialNo) {
		this.frwSerialNo = frwSerialNo;
	}



	/**
	 * Return the value associated with the column: por
	 */
	public java.lang.String getPor () {
		return por;
	}

	/**
	 * Set the value related to the column: por
	 * @param por the por value
	 */
	public void setPor (java.lang.String por) {
		this.por = por;
	}



	/**
	 * Return the value associated with the column: other_hospital
	 */
	public java.lang.String getOtherHospital () {
		return otherHospital;
	}

	/**
	 * Set the value related to the column: other_hospital
	 * @param otherHospital the other_hospital value
	 */
	public void setOtherHospital (java.lang.String otherHospital) {
		this.otherHospital = otherHospital;
	}



	/**
	 * Return the value associated with the column: sickleave
	 */
	public java.lang.String getSickleave () {
		return sickleave;
	}

	/**
	 * Set the value related to the column: sickleave
	 * @param sickleave the sickleave value
	 */
	public void setSickleave (java.lang.String sickleave) {
		this.sickleave = sickleave;
	}



	/**
	 * Return the value associated with the column: review_at
	 */
	public java.lang.String getReview () {
		return review;
	}

	/**
	 * Set the value related to the column: review_at
	 * @param review the review_at value
	 */
	public void setReview (java.lang.String review) {
		this.review = review;
	}



	/**
	 * Return the value associated with the column: from_date
	 */
	public java.util.Date getFromdate () {
		return fromdate;
	}

	/**
	 * Set the value related to the column: from_date
	 * @param fromdate the from_date value
	 */
	public void setFromdate (java.util.Date fromdate) {
		this.fromdate = fromdate;
	}



	/**
	 * Return the value associated with the column: to_date
	 */
	public java.util.Date getTodate () {
		return todate;
	}

	/**
	 * Set the value related to the column: to_date
	 * @param todate the to_date value
	 */
	public void setTodate (java.util.Date todate) {
		this.todate = todate;
	}



	/**
	 * Return the value associated with the column: frw_address
	 */
	public java.lang.String getFrwAddress () {
		return frwAddress;
	}

	/**
	 * Set the value related to the column: frw_address
	 * @param frwAddress the frw_address value
	 */
	public void setFrwAddress (java.lang.String frwAddress) {
		this.frwAddress = frwAddress;
	}



	/**
	 * Return the value associated with the column: ad_no
	 */
	public java.lang.String getAdNo () {
		return adNo;
	}

	/**
	 * Set the value related to the column: ad_no
	 * @param adNo the ad_no value
	 */
	public void setAdNo (java.lang.String adNo) {
		this.adNo = adNo;
	}



	/**
	 * Return the value associated with the column: disposed_to_id
	 */
	public jkt.hms.masters.business.MasDisposedTo getDisposedTo () {
		return disposedTo;
	}

	/**
	 * Set the value related to the column: disposed_to_id
	 * @param disposedTo the disposed_to_id value
	 */
	public void setDisposedTo (jkt.hms.masters.business.MasDisposedTo disposedTo) {
		this.disposedTo = disposedTo;
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
	 * Return the value associated with the column: to_unit
	 */
	public jkt.hms.masters.business.MasUnit getToUnit () {
		return toUnit;
	}

	/**
	 * Set the value related to the column: to_unit
	 * @param toUnit the to_unit value
	 */
	public void setToUnit (jkt.hms.masters.business.MasUnit toUnit) {
		this.toUnit = toUnit;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MisFrw)) return false;
		else {
			jkt.hms.masters.business.MisFrw misFrw = (jkt.hms.masters.business.MisFrw) obj;
			if (null == this.getId() || null == misFrw.getId()) return false;
			else return (this.getId().equals(misFrw.getId()));
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
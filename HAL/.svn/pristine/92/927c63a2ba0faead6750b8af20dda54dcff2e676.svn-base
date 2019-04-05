package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_ot table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_ot"
 */

public abstract class BaseMasOt  implements Serializable {

	public static String REF = "MasOt";
	public static String PROP_OT_CODE = "OtCode";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_OT_NAME = "OtName";


	// constructors
	public BaseMasOt () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasOt (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String otCode;
	private java.lang.String otName;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.lang.String lastChgTime;
	private java.util.Date lastChgDate;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;

	// collections
	private java.util.Set<jkt.hms.masters.business.OtMasDeptDistribution> otMasDeptDistributions;
	private java.util.Set<jkt.hms.masters.business.OtBooking> otBookings;
	private java.util.Set<jkt.hms.masters.business.MasOtDistribution> masOtDistributions;
	private java.util.Set<jkt.hms.masters.business.OtBed> otBeds;
	private java.util.Set<jkt.hms.masters.business.OtAnesthesiologist> otAnesthesiologists;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="org.hibernate.id.IncrementGenerator"
     *  column="ot_id"
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
	 * Return the value associated with the column: ot_code
	 */
	public java.lang.String getOtCode () {
		return otCode;
	}

	/**
	 * Set the value related to the column: ot_code
	 * @param otCode the ot_code value
	 */
	public void setOtCode (java.lang.String otCode) {
		this.otCode = otCode;
	}



	/**
	 * Return the value associated with the column: ot_name
	 */
	public java.lang.String getOtName () {
		return otName;
	}

	/**
	 * Set the value related to the column: ot_name
	 * @param otName the ot_name value
	 */
	public void setOtName (java.lang.String otName) {
		this.otName = otName;
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
	 * Return the value associated with the column: OtMasDeptDistributions
	 */
	public java.util.Set<jkt.hms.masters.business.OtMasDeptDistribution> getOtMasDeptDistributions () {
		return otMasDeptDistributions;
	}

	/**
	 * Set the value related to the column: OtMasDeptDistributions
	 * @param otMasDeptDistributions the OtMasDeptDistributions value
	 */
	public void setOtMasDeptDistributions (java.util.Set<jkt.hms.masters.business.OtMasDeptDistribution> otMasDeptDistributions) {
		this.otMasDeptDistributions = otMasDeptDistributions;
	}

	public void addToOtMasDeptDistributions (jkt.hms.masters.business.OtMasDeptDistribution otMasDeptDistribution) {
		if (null == getOtMasDeptDistributions()) setOtMasDeptDistributions(new java.util.TreeSet<jkt.hms.masters.business.OtMasDeptDistribution>());
		getOtMasDeptDistributions().add(otMasDeptDistribution);
	}



	/**
	 * Return the value associated with the column: OtBookings
	 */
	public java.util.Set<jkt.hms.masters.business.OtBooking> getOtBookings () {
		return otBookings;
	}

	/**
	 * Set the value related to the column: OtBookings
	 * @param otBookings the OtBookings value
	 */
	public void setOtBookings (java.util.Set<jkt.hms.masters.business.OtBooking> otBookings) {
		this.otBookings = otBookings;
	}

	public void addToOtBookings (jkt.hms.masters.business.OtBooking otBooking) {
		if (null == getOtBookings()) setOtBookings(new java.util.TreeSet<jkt.hms.masters.business.OtBooking>());
		getOtBookings().add(otBooking);
	}



	/**
	 * Return the value associated with the column: MasOtDistributions
	 */
	public java.util.Set<jkt.hms.masters.business.MasOtDistribution> getMasOtDistributions () {
		return masOtDistributions;
	}

	/**
	 * Set the value related to the column: MasOtDistributions
	 * @param masOtDistributions the MasOtDistributions value
	 */
	public void setMasOtDistributions (java.util.Set<jkt.hms.masters.business.MasOtDistribution> masOtDistributions) {
		this.masOtDistributions = masOtDistributions;
	}

	public void addToMasOtDistributions (jkt.hms.masters.business.MasOtDistribution masOtDistribution) {
		if (null == getMasOtDistributions()) setMasOtDistributions(new java.util.TreeSet<jkt.hms.masters.business.MasOtDistribution>());
		getMasOtDistributions().add(masOtDistribution);
	}



	/**
	 * Return the value associated with the column: OtBeds
	 */
	public java.util.Set<jkt.hms.masters.business.OtBed> getOtBeds () {
		return otBeds;
	}

	/**
	 * Set the value related to the column: OtBeds
	 * @param otBeds the OtBeds value
	 */
	public void setOtBeds (java.util.Set<jkt.hms.masters.business.OtBed> otBeds) {
		this.otBeds = otBeds;
	}

	public void addToOtBeds (jkt.hms.masters.business.OtBed otBed) {
		if (null == getOtBeds()) setOtBeds(new java.util.TreeSet<jkt.hms.masters.business.OtBed>());
		getOtBeds().add(otBed);
	}



	/**
	 * Return the value associated with the column: OtAnesthesiologists
	 */
	public java.util.Set<jkt.hms.masters.business.OtAnesthesiologist> getOtAnesthesiologists () {
		return otAnesthesiologists;
	}

	/**
	 * Set the value related to the column: OtAnesthesiologists
	 * @param otAnesthesiologists the OtAnesthesiologists value
	 */
	public void setOtAnesthesiologists (java.util.Set<jkt.hms.masters.business.OtAnesthesiologist> otAnesthesiologists) {
		this.otAnesthesiologists = otAnesthesiologists;
	}

	public void addToOtAnesthesiologists (jkt.hms.masters.business.OtAnesthesiologist otAnesthesiologist) {
		if (null == getOtAnesthesiologists()) setOtAnesthesiologists(new java.util.TreeSet<jkt.hms.masters.business.OtAnesthesiologist>());
		getOtAnesthesiologists().add(otAnesthesiologist);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasOt)) return false;
		else {
			jkt.hms.masters.business.MasOt masOt = (jkt.hms.masters.business.MasOt) obj;
			if (null == this.getId() || null == masOt.getId()) return false;
			else return (this.getId().equals(masOt.getId()));
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
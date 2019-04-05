package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the AV_AIRCREW_LECTURE_DT table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="AV_AIRCREW_LECTURE_DT"
 */

public abstract class BaseAvAircrewLectureDt  implements Serializable {

	public static String REF = "AvAircrewLectureDt";
	public static String PROP_AIRCREW_HD_ID = "AircrewHdId";
	public static String PROP_RANK = "Rank";
	public static String PROP_S_NAME = "SName";
	public static String PROP_SERVICE_NO = "ServiceNo";
	public static String PROP_ID = "Id";
	public static String PROP_HIN = "Hin";


	// constructors
	public BaseAvAircrewLectureDt () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAvAircrewLectureDt (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String serviceNo;
	private java.lang.String sName;

	// many to one
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.MasRank rank;
	private jkt.hms.masters.business.AviAircrewMedicalLectures aircrewHdId;



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
	 * Return the value associated with the column: SERVICE_NO
	 */
	public java.lang.String getServiceNo () {
		return serviceNo;
	}

	/**
	 * Set the value related to the column: SERVICE_NO
	 * @param serviceNo the SERVICE_NO value
	 */
	public void setServiceNo (java.lang.String serviceNo) {
		this.serviceNo = serviceNo;
	}



	/**
	 * Return the value associated with the column: S_NAME
	 */
	public java.lang.String getSName () {
		return sName;
	}

	/**
	 * Set the value related to the column: S_NAME
	 * @param sName the S_NAME value
	 */
	public void setSName (java.lang.String sName) {
		this.sName = sName;
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
	 * Return the value associated with the column: rank_id
	 */
	public jkt.hms.masters.business.MasRank getRank () {
		return rank;
	}

	/**
	 * Set the value related to the column: rank_id
	 * @param rank the rank_id value
	 */
	public void setRank (jkt.hms.masters.business.MasRank rank) {
		this.rank = rank;
	}



	/**
	 * Return the value associated with the column: AIRCREW_HD_ID
	 */
	public jkt.hms.masters.business.AviAircrewMedicalLectures getAircrewHdId () {
		return aircrewHdId;
	}

	/**
	 * Set the value related to the column: AIRCREW_HD_ID
	 * @param aircrewHdId the AIRCREW_HD_ID value
	 */
	public void setAircrewHdId (jkt.hms.masters.business.AviAircrewMedicalLectures aircrewHdId) {
		this.aircrewHdId = aircrewHdId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.AvAircrewLectureDt)) return false;
		else {
			jkt.hms.masters.business.AvAircrewLectureDt avAircrewLectureDt = (jkt.hms.masters.business.AvAircrewLectureDt) obj;
			if (null == this.getId() || null == avAircrewLectureDt.getId()) return false;
			else return (this.getId().equals(avAircrewLectureDt.getId()));
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
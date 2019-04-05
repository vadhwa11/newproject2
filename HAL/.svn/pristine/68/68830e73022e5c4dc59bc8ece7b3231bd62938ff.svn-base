package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the av_grid_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="av_grid_details"
 */

public abstract class BaseAvGridDetails  implements Serializable {

	public static String REF = "AvGridDetails";
	public static String PROP_GRID_TYPE = "GridType";
	public static String PROP_NAME = "Name";
	public static String PROP_RESULT = "Result";
	public static String PROP_ENCL_USED = "EnclUsed";
	public static String PROP_CREW_STATION_SEATING = "CrewStationSeating";
	public static String PROP_RANK = "Rank";
	public static String PROP_SERVICE_NO = "ServiceNo";
	public static String PROP_ENCLOSURS_DETAIL = "EnclosursDetail";
	public static String PROP_AV_ACCIDENT = "AvAccident";
	public static String PROP_ID = "Id";


	// constructors
	public BaseAvGridDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAvGridDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String serviceNo;
	private java.lang.String name;
	private java.lang.String crewStationSeating;
	private java.lang.String result;
	private java.lang.String enclUsed;
	private java.lang.String enclosursDetail;
	private java.lang.String gridType;

	// many to one
	private jkt.hms.masters.business.AvAccident avAccident;
	private jkt.hms.masters.business.MasRank rank;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="detail_id"
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
	 * Return the value associated with the column: service_no
	 */
	public java.lang.String getServiceNo () {
		return serviceNo;
	}

	/**
	 * Set the value related to the column: service_no
	 * @param serviceNo the service_no value
	 */
	public void setServiceNo (java.lang.String serviceNo) {
		this.serviceNo = serviceNo;
	}



	/**
	 * Return the value associated with the column: name
	 */
	public java.lang.String getName () {
		return name;
	}

	/**
	 * Set the value related to the column: name
	 * @param name the name value
	 */
	public void setName (java.lang.String name) {
		this.name = name;
	}



	/**
	 * Return the value associated with the column: crew_station_seating
	 */
	public java.lang.String getCrewStationSeating () {
		return crewStationSeating;
	}

	/**
	 * Set the value related to the column: crew_station_seating
	 * @param crewStationSeating the crew_station_seating value
	 */
	public void setCrewStationSeating (java.lang.String crewStationSeating) {
		this.crewStationSeating = crewStationSeating;
	}



	/**
	 * Return the value associated with the column: result
	 */
	public java.lang.String getResult () {
		return result;
	}

	/**
	 * Set the value related to the column: result
	 * @param result the result value
	 */
	public void setResult (java.lang.String result) {
		this.result = result;
	}



	/**
	 * Return the value associated with the column: encl_used
	 */
	public java.lang.String getEnclUsed () {
		return enclUsed;
	}

	/**
	 * Set the value related to the column: encl_used
	 * @param enclUsed the encl_used value
	 */
	public void setEnclUsed (java.lang.String enclUsed) {
		this.enclUsed = enclUsed;
	}



	/**
	 * Return the value associated with the column: enclosurs_detail
	 */
	public java.lang.String getEnclosursDetail () {
		return enclosursDetail;
	}

	/**
	 * Set the value related to the column: enclosurs_detail
	 * @param enclosursDetail the enclosurs_detail value
	 */
	public void setEnclosursDetail (java.lang.String enclosursDetail) {
		this.enclosursDetail = enclosursDetail;
	}



	/**
	 * Return the value associated with the column: grid_type
	 */
	public java.lang.String getGridType () {
		return gridType;
	}

	/**
	 * Set the value related to the column: grid_type
	 * @param gridType the grid_type value
	 */
	public void setGridType (java.lang.String gridType) {
		this.gridType = gridType;
	}



	/**
	 * Return the value associated with the column: av_accident_id
	 */
	public jkt.hms.masters.business.AvAccident getAvAccident () {
		return avAccident;
	}

	/**
	 * Set the value related to the column: av_accident_id
	 * @param avAccident the av_accident_id value
	 */
	public void setAvAccident (jkt.hms.masters.business.AvAccident avAccident) {
		this.avAccident = avAccident;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.AvGridDetails)) return false;
		else {
			jkt.hms.masters.business.AvGridDetails avGridDetails = (jkt.hms.masters.business.AvGridDetails) obj;
			if (null == this.getId() || null == avGridDetails.getId()) return false;
			else return (this.getId().equals(avGridDetails.getId()));
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
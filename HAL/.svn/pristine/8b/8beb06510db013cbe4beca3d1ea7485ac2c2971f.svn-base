package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the MAS_IDEAL_WEIGHT table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="MAS_IDEAL_WEIGHT"
 */

public abstract class BaseMasIdealWeight  implements Serializable {

	public static String REF = "MasIdealWeight";
	public static String PROP_SD = "SD";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_WEIGHT = "Weight";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_GENDER = "Gender";
	public static String PROP_TO_AGE = "ToAge";
	public static String PROP_FROM_AGE = "FromAge";
	public static String PROP_HEIGHT = "Height";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_GENDER_ID = "GenderId";


	// constructors
	public BaseMasIdealWeight () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasIdealWeight (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer genderId;
	private java.lang.Integer height;
	private java.lang.String fromAge;
	private java.lang.String toAge;
	private java.lang.Integer weight;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;
	private java.lang.String sD;

	// many to one
	private jkt.hms.masters.business.MasAdministrativeSex gender;
	private jkt.hms.masters.business.Users lastChgBy;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="IDEAL_WEIGHT_ID"
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
	 * Return the value associated with the column: GENDER_ID
	 */
	public java.lang.Integer getGenderId () {
		return genderId;
	}

	/**
	 * Set the value related to the column: GENDER_ID
	 * @param genderId the GENDER_ID value
	 */
	public void setGenderId (java.lang.Integer genderId) {
		this.genderId = genderId;
	}



	/**
	 * Return the value associated with the column: HEIGHT
	 */
	public java.lang.Integer getHeight () {
		return height;
	}

	/**
	 * Set the value related to the column: HEIGHT
	 * @param height the HEIGHT value
	 */
	public void setHeight (java.lang.Integer height) {
		this.height = height;
	}



	/**
	 * Return the value associated with the column: from_age
	 */
	public java.lang.String getFromAge () {
		return fromAge;
	}

	/**
	 * Set the value related to the column: from_age
	 * @param fromAge the from_age value
	 */
	public void setFromAge (java.lang.String fromAge) {
		this.fromAge = fromAge;
	}



	/**
	 * Return the value associated with the column: to_age
	 */
	public java.lang.String getToAge () {
		return toAge;
	}

	/**
	 * Set the value related to the column: to_age
	 * @param toAge the to_age value
	 */
	public void setToAge (java.lang.String toAge) {
		this.toAge = toAge;
	}



	/**
	 * Return the value associated with the column: WEIGHT
	 */
	public java.lang.Integer getWeight () {
		return weight;
	}

	/**
	 * Set the value related to the column: WEIGHT
	 * @param weight the WEIGHT value
	 */
	public void setWeight (java.lang.Integer weight) {
		this.weight = weight;
	}



	/**
	 * Return the value associated with the column: LAST_CHG_DATE
	 */
	public java.util.Date getLastChgDate () {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: LAST_CHG_DATE
	 * @param lastChgDate the LAST_CHG_DATE value
	 */
	public void setLastChgDate (java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}



	/**
	 * Return the value associated with the column: LAST_CHG_TIME
	 */
	public java.lang.String getLastChgTime () {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: LAST_CHG_TIME
	 * @param lastChgTime the LAST_CHG_TIME value
	 */
	public void setLastChgTime (java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}



	/**
	 * Return the value associated with the column: STATUS
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: STATUS
	 * @param status the STATUS value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
	}



	/**
	 * Return the value associated with the column: SD
	 */
	public java.lang.String getSD () {
		return sD;
	}

	/**
	 * Set the value related to the column: SD
	 * @param sD the SD value
	 */
	public void setSD (java.lang.String sD) {
		this.sD = sD;
	}



	/**
	 * Return the value associated with the column: gender_id
	 */
	public jkt.hms.masters.business.MasAdministrativeSex getGender () {
		return gender;
	}

	/**
	 * Set the value related to the column: gender_id
	 * @param gender the gender_id value
	 */
	public void setGender (jkt.hms.masters.business.MasAdministrativeSex gender) {
		this.gender = gender;
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
		if (!(obj instanceof jkt.hms.masters.business.MasIdealWeight)) return false;
		else {
			jkt.hms.masters.business.MasIdealWeight masIdealWeight = (jkt.hms.masters.business.MasIdealWeight) obj;
			if (null == this.getId() || null == masIdealWeight.getId()) return false;
			else return (this.getId().equals(masIdealWeight.getId()));
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
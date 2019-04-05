package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the AV_PILOT_REGISTRATION_DT table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="AV_PILOT_REGISTRATION_DT"
 */

public abstract class BaseAvPilotRegistrationDt  implements Serializable {

	public static String REF = "AvPilotRegistrationDt";
	public static String PROP_DATE_OF_LAST_ME = "DateOfLastMe";
	public static String PROP_CATEGORY = "Category";
	public static String PROP_AGE = "Age";
	public static String PROP_RANK = "Rank";
	public static String PROP_SERVICE_NO = "ServiceNo";
	public static String PROP_FULL_NAME = "FullName";
	public static String PROP_ID = "Id";
	public static String PROP_AV_PILOT_REGISTRATION_HD = "AvPilotRegistrationHd";
	public static String PROP_HIN = "Hin";


	// constructors
	public BaseAvPilotRegistrationDt () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAvPilotRegistrationDt (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String serviceNo;
	private java.lang.String fullName;
	private java.lang.String age;
	private java.util.Date dateOfLastMe;

	// many to one
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.MasRank rank;
	private jkt.hms.masters.business.Category category;
	private jkt.hms.masters.business.AvPilotRegistrationHd avPilotRegistrationHd;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="ID"
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
	 * Return the value associated with the column: FULL_NAME
	 */
	public java.lang.String getFullName () {
		return fullName;
	}

	/**
	 * Set the value related to the column: FULL_NAME
	 * @param fullName the FULL_NAME value
	 */
	public void setFullName (java.lang.String fullName) {
		this.fullName = fullName;
	}



	/**
	 * Return the value associated with the column: AGE
	 */
	public java.lang.String getAge () {
		return age;
	}

	/**
	 * Set the value related to the column: AGE
	 * @param age the AGE value
	 */
	public void setAge (java.lang.String age) {
		this.age = age;
	}



	/**
	 * Return the value associated with the column: DATE_OF_LAST_ME
	 */
	public java.util.Date getDateOfLastMe () {
		return dateOfLastMe;
	}

	/**
	 * Set the value related to the column: DATE_OF_LAST_ME
	 * @param dateOfLastMe the DATE_OF_LAST_ME value
	 */
	public void setDateOfLastMe (java.util.Date dateOfLastMe) {
		this.dateOfLastMe = dateOfLastMe;
	}



	/**
	 * Return the value associated with the column: HIN_ID
	 */
	public jkt.hms.masters.business.Patient getHin () {
		return hin;
	}

	/**
	 * Set the value related to the column: HIN_ID
	 * @param hin the HIN_ID value
	 */
	public void setHin (jkt.hms.masters.business.Patient hin) {
		this.hin = hin;
	}



	/**
	 * Return the value associated with the column: RANK_ID
	 */
	public jkt.hms.masters.business.MasRank getRank () {
		return rank;
	}

	/**
	 * Set the value related to the column: RANK_ID
	 * @param rank the RANK_ID value
	 */
	public void setRank (jkt.hms.masters.business.MasRank rank) {
		this.rank = rank;
	}



	/**
	 * Return the value associated with the column: CATEGORY_ID
	 */
	public jkt.hms.masters.business.Category getCategory () {
		return category;
	}

	/**
	 * Set the value related to the column: CATEGORY_ID
	 * @param category the CATEGORY_ID value
	 */
	public void setCategory (jkt.hms.masters.business.Category category) {
		this.category = category;
	}



	/**
	 * Return the value associated with the column: AV_PILOT_REGISTRATION_HD_ID
	 */
	public jkt.hms.masters.business.AvPilotRegistrationHd getAvPilotRegistrationHd () {
		return avPilotRegistrationHd;
	}

	/**
	 * Set the value related to the column: AV_PILOT_REGISTRATION_HD_ID
	 * @param avPilotRegistrationHd the AV_PILOT_REGISTRATION_HD_ID value
	 */
	public void setAvPilotRegistrationHd (jkt.hms.masters.business.AvPilotRegistrationHd avPilotRegistrationHd) {
		this.avPilotRegistrationHd = avPilotRegistrationHd;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.AvPilotRegistrationDt)) return false;
		else {
			jkt.hms.masters.business.AvPilotRegistrationDt avPilotRegistrationDt = (jkt.hms.masters.business.AvPilotRegistrationDt) obj;
			if (null == this.getId() || null == avPilotRegistrationDt.getId()) return false;
			else return (this.getId().equals(avPilotRegistrationDt.getId()));
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
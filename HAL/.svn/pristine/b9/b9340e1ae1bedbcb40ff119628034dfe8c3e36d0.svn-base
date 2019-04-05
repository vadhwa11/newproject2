package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SHO_INDUSTRIAL_DISEASE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="SHO_INDUSTRIAL_DISEASE"
 */

public abstract class BaseShoIndustrialDisease  implements Serializable {

	public static String REF = "ShoIndustrialDisease";
	public static String PROP_PARTICULAR = "Particular";
	public static String PROP_RECREATION = "Recreation";
	public static String PROP_ACTION = "Action";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_CURRENT_DATE = "CurrentDate";
	public static String PROP_ID = "Id";
	public static String PROP_MORAL = "Moral";
	public static String PROP_LAST_UPDATED_DATE = "LastUpdatedDate";
	public static String PROP_NO_OF_CASES = "NoOfCases";


	// constructors
	public BaseShoIndustrialDisease () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseShoIndustrialDisease (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String particular;
	private java.lang.String noOfCases;
	private java.lang.String action;
	private java.lang.String recreation;
	private java.lang.String moral;
	private java.util.Date currentDate;
	private java.util.Date lastUpdatedDate;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="INDUSTRIAL_ID"
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
	 * Return the value associated with the column: PARTICULAR
	 */
	public java.lang.String getParticular () {
		return particular;
	}

	/**
	 * Set the value related to the column: PARTICULAR
	 * @param particular the PARTICULAR value
	 */
	public void setParticular (java.lang.String particular) {
		this.particular = particular;
	}



	/**
	 * Return the value associated with the column: NO_OF_CASES
	 */
	public java.lang.String getNoOfCases () {
		return noOfCases;
	}

	/**
	 * Set the value related to the column: NO_OF_CASES
	 * @param noOfCases the NO_OF_CASES value
	 */
	public void setNoOfCases (java.lang.String noOfCases) {
		this.noOfCases = noOfCases;
	}



	/**
	 * Return the value associated with the column: ACTION
	 */
	public java.lang.String getAction () {
		return action;
	}

	/**
	 * Set the value related to the column: ACTION
	 * @param action the ACTION value
	 */
	public void setAction (java.lang.String action) {
		this.action = action;
	}



	/**
	 * Return the value associated with the column: RECREATION
	 */
	public java.lang.String getRecreation () {
		return recreation;
	}

	/**
	 * Set the value related to the column: RECREATION
	 * @param recreation the RECREATION value
	 */
	public void setRecreation (java.lang.String recreation) {
		this.recreation = recreation;
	}



	/**
	 * Return the value associated with the column: MORAL
	 */
	public java.lang.String getMoral () {
		return moral;
	}

	/**
	 * Set the value related to the column: MORAL
	 * @param moral the MORAL value
	 */
	public void setMoral (java.lang.String moral) {
		this.moral = moral;
	}



	/**
	 * Return the value associated with the column: CURRENT_DATE
	 */
	public java.util.Date getCurrentDate () {
		return currentDate;
	}

	/**
	 * Set the value related to the column: CURRENT_DATE
	 * @param currentDate the CURRENT_DATE value
	 */
	public void setCurrentDate (java.util.Date currentDate) {
		this.currentDate = currentDate;
	}



	/**
	 * Return the value associated with the column: LAST_UPDATED_DATE
	 */
	public java.util.Date getLastUpdatedDate () {
		return lastUpdatedDate;
	}

	/**
	 * Set the value related to the column: LAST_UPDATED_DATE
	 * @param lastUpdatedDate the LAST_UPDATED_DATE value
	 */
	public void setLastUpdatedDate (java.util.Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}



	/**
	 * Return the value associated with the column: HOSPITAL_ID
	 */
	public jkt.hms.masters.business.MasHospital getHospital () {
		return hospital;
	}

	/**
	 * Set the value related to the column: HOSPITAL_ID
	 * @param hospital the HOSPITAL_ID value
	 */
	public void setHospital (jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.ShoIndustrialDisease)) return false;
		else {
			jkt.hms.masters.business.ShoIndustrialDisease shoIndustrialDisease = (jkt.hms.masters.business.ShoIndustrialDisease) obj;
			if (null == this.getId() || null == shoIndustrialDisease.getId()) return false;
			else return (this.getId().equals(shoIndustrialDisease.getId()));
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
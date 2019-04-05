package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_ward_impanneled_hospital table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_ward_impanneled_hospital"
 */

public abstract class BaseMasWardImpanneledHospital  implements Serializable {

	public static String REF = "MasWardImpanneledHospital";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_WARD_NAME = "WardName";
	public static String PROP_IMPANNELED_HOSPITAL = "ImpanneledHospital";


	// constructors
	public BaseMasWardImpanneledHospital () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasWardImpanneledHospital (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String wardName;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasImpanneledHospital impanneledHospital;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="ward_impanneled_hospital_id"
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
	 * Return the value associated with the column: ward_name
	 */
	public java.lang.String getWardName () {
		return wardName;
	}

	/**
	 * Set the value related to the column: ward_name
	 * @param wardName the ward_name value
	 */
	public void setWardName (java.lang.String wardName) {
		this.wardName = wardName;
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
	 * Return the value associated with the column: impanneled_hospital_id
	 */
	public jkt.hms.masters.business.MasImpanneledHospital getImpanneledHospital () {
		return impanneledHospital;
	}

	/**
	 * Set the value related to the column: impanneled_hospital_id
	 * @param impanneledHospital the impanneled_hospital_id value
	 */
	public void setImpanneledHospital (jkt.hms.masters.business.MasImpanneledHospital impanneledHospital) {
		this.impanneledHospital = impanneledHospital;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasWardImpanneledHospital)) return false;
		else {
			jkt.hms.masters.business.MasWardImpanneledHospital masWardImpanneledHospital = (jkt.hms.masters.business.MasWardImpanneledHospital) obj;
			if (null == this.getId() || null == masWardImpanneledHospital.getId()) return false;
			else return (this.getId().equals(masWardImpanneledHospital.getId()));
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
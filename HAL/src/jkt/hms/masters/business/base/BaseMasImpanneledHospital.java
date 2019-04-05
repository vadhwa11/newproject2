package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_impanneled_hospital table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_impanneled_hospital"
 */

public abstract class BaseMasImpanneledHospital  implements Serializable {

	public static String REF = "MasImpanneledHospital";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ADDRESS = "Address";
	public static String PROP_IMPANNELED_HOSPITAL_NAME = "ImpanneledHospitalName";
	public static String PROP_ID = "Id";
	public static String PROP_IMPANNELED_HOSPITAL_CODE = "ImpanneledHospitalCode";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseMasImpanneledHospital () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasImpanneledHospital (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseMasImpanneledHospital (
		java.lang.Integer id,
		java.lang.String status) {

		this.setId(id);
		this.setStatus(status);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String impanneledHospitalCode;
	private java.lang.String impanneledHospitalName;
	private java.lang.String status;
	private java.lang.String address;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="org.hibernate.id.IncrementGenerator"
     *  column="impanneled_hospital_id"
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
	 * Return the value associated with the column: impanneled_hospital_code
	 */
	public java.lang.String getImpanneledHospitalCode () {
		return impanneledHospitalCode;
	}

	/**
	 * Set the value related to the column: impanneled_hospital_code
	 * @param impanneledHospitalCode the impanneled_hospital_code value
	 */
	public void setImpanneledHospitalCode (java.lang.String impanneledHospitalCode) {
		this.impanneledHospitalCode = impanneledHospitalCode;
	}



	/**
	 * Return the value associated with the column: impanneled_hospital_name
	 */
	public java.lang.String getImpanneledHospitalName () {
		return impanneledHospitalName;
	}

	/**
	 * Set the value related to the column: impanneled_hospital_name
	 * @param impanneledHospitalName the impanneled_hospital_name value
	 */
	public void setImpanneledHospitalName (java.lang.String impanneledHospitalName) {
		this.impanneledHospitalName = impanneledHospitalName;
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
	 * Return the value associated with the column: address
	 */
	public java.lang.String getAddress () {
		return address;
	}

	/**
	 * Set the value related to the column: address
	 * @param address the address value
	 */
	public void setAddress (java.lang.String address) {
		this.address = address;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasImpanneledHospital)) return false;
		else {
			jkt.hms.masters.business.MasImpanneledHospital masImpanneledHospital = (jkt.hms.masters.business.MasImpanneledHospital) obj;
			if (null == this.getId() || null == masImpanneledHospital.getId()) return false;
			else return (this.getId().equals(masImpanneledHospital.getId()));
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
package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_mas_surcharge table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_mas_surcharge"
 */

public abstract class BaseHrMasSurcharge  implements Serializable {

	public static String REF = "HrMasSurcharge";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_SURCHARGE_CODE = "SurchargeCode";
	public static String PROP_ID = "Id";
	public static String PROP_SURCHARGE_DESCRIPTION = "SurchargeDescription";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";


	// constructors
	public BaseHrMasSurcharge () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrMasSurcharge (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String surchargeCode;
	private java.lang.String surchargeDescription;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// collections
	private java.util.Set<jkt.hms.masters.business.HrMasItaxSurcharge> hrMasItaxSurcharges;



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
	 * Return the value associated with the column: surcharge_code
	 */
	public java.lang.String getSurchargeCode () {
		return surchargeCode;
	}

	/**
	 * Set the value related to the column: surcharge_code
	 * @param surchargeCode the surcharge_code value
	 */
	public void setSurchargeCode (java.lang.String surchargeCode) {
		this.surchargeCode = surchargeCode;
	}



	/**
	 * Return the value associated with the column: surcharge_description
	 */
	public java.lang.String getSurchargeDescription () {
		return surchargeDescription;
	}

	/**
	 * Set the value related to the column: surcharge_description
	 * @param surchargeDescription the surcharge_description value
	 */
	public void setSurchargeDescription (java.lang.String surchargeDescription) {
		this.surchargeDescription = surchargeDescription;
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
	 * Return the value associated with the column: HrMasItaxSurcharges
	 */
	public java.util.Set<jkt.hms.masters.business.HrMasItaxSurcharge> getHrMasItaxSurcharges () {
		return hrMasItaxSurcharges;
	}

	/**
	 * Set the value related to the column: HrMasItaxSurcharges
	 * @param hrMasItaxSurcharges the HrMasItaxSurcharges value
	 */
	public void setHrMasItaxSurcharges (java.util.Set<jkt.hms.masters.business.HrMasItaxSurcharge> hrMasItaxSurcharges) {
		this.hrMasItaxSurcharges = hrMasItaxSurcharges;
	}

	public void addToHrMasItaxSurcharges (jkt.hms.masters.business.HrMasItaxSurcharge hrMasItaxSurcharge) {
		if (null == getHrMasItaxSurcharges()) setHrMasItaxSurcharges(new java.util.TreeSet<jkt.hms.masters.business.HrMasItaxSurcharge>());
		getHrMasItaxSurcharges().add(hrMasItaxSurcharge);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HrMasSurcharge)) return false;
		else {
			jkt.hms.masters.business.HrMasSurcharge hrMasSurcharge = (jkt.hms.masters.business.HrMasSurcharge) obj;
			if (null == this.getId() || null == hrMasSurcharge.getId()) return false;
			else return (this.getId().equals(hrMasSurcharge.getId()));
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
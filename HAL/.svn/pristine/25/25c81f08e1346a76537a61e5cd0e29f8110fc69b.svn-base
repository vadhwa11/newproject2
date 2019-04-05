package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_parameter table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_parameter"
 */

public abstract class BaseMasParameter  implements Serializable {

	public static String REF = "MasParameter";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_YEARLY = "Yearly";
	public static String PROP_CONTINUOUS = "Continuous";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_MONTHLY = "Monthly";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_SUB_CHARGE = "SubCharge";
	public static String PROP_SERVICE_STATUS = "ServiceStatus";


	// constructors
	public BaseMasParameter () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasParameter (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String monthly;
	private java.lang.String yearly;
	private java.lang.String continuous;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasServiceStatus serviceStatus;
	private jkt.hms.masters.business.MasSubChargecode subCharge;
	private jkt.hms.masters.business.MasHospital hospital;



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
	 * Return the value associated with the column: monthly
	 */
	public java.lang.String getMonthly () {
		return monthly;
	}

	/**
	 * Set the value related to the column: monthly
	 * @param monthly the monthly value
	 */
	public void setMonthly (java.lang.String monthly) {
		this.monthly = monthly;
	}



	/**
	 * Return the value associated with the column: yearly
	 */
	public java.lang.String getYearly () {
		return yearly;
	}

	/**
	 * Set the value related to the column: yearly
	 * @param yearly the yearly value
	 */
	public void setYearly (java.lang.String yearly) {
		this.yearly = yearly;
	}



	/**
	 * Return the value associated with the column: continuous
	 */
	public java.lang.String getContinuous () {
		return continuous;
	}

	/**
	 * Set the value related to the column: continuous
	 * @param continuous the continuous value
	 */
	public void setContinuous (java.lang.String continuous) {
		this.continuous = continuous;
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
	 * Return the value associated with the column: service_status_id
	 */
	public jkt.hms.masters.business.MasServiceStatus getServiceStatus () {
		return serviceStatus;
	}

	/**
	 * Set the value related to the column: service_status_id
	 * @param serviceStatus the service_status_id value
	 */
	public void setServiceStatus (jkt.hms.masters.business.MasServiceStatus serviceStatus) {
		this.serviceStatus = serviceStatus;
	}



	/**
	 * Return the value associated with the column: sub_charge_id
	 */
	public jkt.hms.masters.business.MasSubChargecode getSubCharge () {
		return subCharge;
	}

	/**
	 * Set the value related to the column: sub_charge_id
	 * @param subCharge the sub_charge_id value
	 */
	public void setSubCharge (jkt.hms.masters.business.MasSubChargecode subCharge) {
		this.subCharge = subCharge;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasParameter)) return false;
		else {
			jkt.hms.masters.business.MasParameter masParameter = (jkt.hms.masters.business.MasParameter) obj;
			if (null == this.getId() || null == masParameter.getId()) return false;
			else return (this.getId().equals(masParameter.getId()));
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
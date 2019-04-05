package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_trade table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_trade"
 */

public abstract class BaseMasTrade  implements Serializable {

	public static String REF = "MasTrade";
	public static String PROP_STATUS = "Status";
	public static String PROP_TRADE_NAME = "TradeName";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_SERVICE_TYPE = "ServiceType";
	public static String PROP_HIC_CODE = "HicCode";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseMasTrade () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasTrade (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String tradeName;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String hicCode;

	// many to one
	private jkt.hms.masters.business.MasServiceType serviceType;

	// collections
	private java.util.Set<jkt.hms.masters.business.MasEmployee> masEmployees;
	private java.util.Set<jkt.hms.masters.business.Patient> patients;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="trade_id"
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
	 * Return the value associated with the column: trade_name
	 */
	public java.lang.String getTradeName () {
		return tradeName;
	}

	/**
	 * Set the value related to the column: trade_name
	 * @param tradeName the trade_name value
	 */
	public void setTradeName (java.lang.String tradeName) {
		this.tradeName = tradeName;
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
	 * Return the value associated with the column: hic_code
	 */
	public java.lang.String getHicCode () {
		return hicCode;
	}

	/**
	 * Set the value related to the column: hic_code
	 * @param hicCode the hic_code value
	 */
	public void setHicCode (java.lang.String hicCode) {
		this.hicCode = hicCode;
	}



	/**
	 * Return the value associated with the column: service_type_id
	 */
	public jkt.hms.masters.business.MasServiceType getServiceType () {
		return serviceType;
	}

	/**
	 * Set the value related to the column: service_type_id
	 * @param serviceType the service_type_id value
	 */
	public void setServiceType (jkt.hms.masters.business.MasServiceType serviceType) {
		this.serviceType = serviceType;
	}



	/**
	 * Return the value associated with the column: MasEmployees
	 */
	public java.util.Set<jkt.hms.masters.business.MasEmployee> getMasEmployees () {
		return masEmployees;
	}

	/**
	 * Set the value related to the column: MasEmployees
	 * @param masEmployees the MasEmployees value
	 */
	public void setMasEmployees (java.util.Set<jkt.hms.masters.business.MasEmployee> masEmployees) {
		this.masEmployees = masEmployees;
	}

	public void addToMasEmployees (jkt.hms.masters.business.MasEmployee masEmployee) {
		if (null == getMasEmployees()) setMasEmployees(new java.util.TreeSet<jkt.hms.masters.business.MasEmployee>());
		getMasEmployees().add(masEmployee);
	}



	/**
	 * Return the value associated with the column: Patients
	 */
	public java.util.Set<jkt.hms.masters.business.Patient> getPatients () {
		return patients;
	}

	/**
	 * Set the value related to the column: Patients
	 * @param patients the Patients value
	 */
	public void setPatients (java.util.Set<jkt.hms.masters.business.Patient> patients) {
		this.patients = patients;
	}

	public void addToPatients (jkt.hms.masters.business.Patient patient) {
		if (null == getPatients()) setPatients(new java.util.TreeSet<jkt.hms.masters.business.Patient>());
		getPatients().add(patient);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasTrade)) return false;
		else {
			jkt.hms.masters.business.MasTrade masTrade = (jkt.hms.masters.business.MasTrade) obj;
			if (null == this.getId() || null == masTrade.getId()) return false;
			else return (this.getId().equals(masTrade.getId()));
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
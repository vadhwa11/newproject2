package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_unit table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_unit"
 */

public abstract class BaseMasUnit  implements Serializable {

	public static String REF = "MasUnit";
	public static String PROP_STATION = "Station";
	public static String PROP_UNIT_NAME = "UnitName";
	public static String PROP_STATUS = "Status";
	public static String PROP_LOCAL_UNIT = "LocalUnit";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_UNIT_ADDRESS = "UnitAddress";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HIC_CODE = "HicCode";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DEPENDENT_UNIT = "DependentUnit";


	// constructors
	public BaseMasUnit () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasUnit (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String unitName;
	private java.lang.String unitAddress;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String localUnit;
	private java.lang.String dependentUnit;
	private java.lang.String hicCode;

	// many to one
	private jkt.hms.masters.business.MasStation station;

	// collections
	private java.util.Set<jkt.hms.masters.business.StoreIssueM> storeIssueMs;
	private java.util.Set<jkt.hms.masters.business.MasEmployee> masEmployees;
	private java.util.Set<jkt.hms.masters.business.EmpAfmsfDet> empAfmsfDets;
	private java.util.Set<jkt.hms.masters.business.Patient> patients;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="unit_id"
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
	 * Return the value associated with the column: unit_name
	 */
	public java.lang.String getUnitName () {
		return unitName;
	}

	/**
	 * Set the value related to the column: unit_name
	 * @param unitName the unit_name value
	 */
	public void setUnitName (java.lang.String unitName) {
		this.unitName = unitName;
	}



	/**
	 * Return the value associated with the column: unit_address
	 */
	public java.lang.String getUnitAddress () {
		return unitAddress;
	}

	/**
	 * Set the value related to the column: unit_address
	 * @param unitAddress the unit_address value
	 */
	public void setUnitAddress (java.lang.String unitAddress) {
		this.unitAddress = unitAddress;
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
	 * Return the value associated with the column: local_unit
	 */
	public java.lang.String getLocalUnit () {
		return localUnit;
	}

	/**
	 * Set the value related to the column: local_unit
	 * @param localUnit the local_unit value
	 */
	public void setLocalUnit (java.lang.String localUnit) {
		this.localUnit = localUnit;
	}



	/**
	 * Return the value associated with the column: dependent_unit
	 */
	public java.lang.String getDependentUnit () {
		return dependentUnit;
	}

	/**
	 * Set the value related to the column: dependent_unit
	 * @param dependentUnit the dependent_unit value
	 */
	public void setDependentUnit (java.lang.String dependentUnit) {
		this.dependentUnit = dependentUnit;
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
	 * Return the value associated with the column: station_id
	 */
	public jkt.hms.masters.business.MasStation getStation () {
		return station;
	}

	/**
	 * Set the value related to the column: station_id
	 * @param station the station_id value
	 */
	public void setStation (jkt.hms.masters.business.MasStation station) {
		this.station = station;
	}



	/**
	 * Return the value associated with the column: StoreIssueMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreIssueM> getStoreIssueMs () {
		return storeIssueMs;
	}

	/**
	 * Set the value related to the column: StoreIssueMs
	 * @param storeIssueMs the StoreIssueMs value
	 */
	public void setStoreIssueMs (java.util.Set<jkt.hms.masters.business.StoreIssueM> storeIssueMs) {
		this.storeIssueMs = storeIssueMs;
	}

	public void addToStoreIssueMs (jkt.hms.masters.business.StoreIssueM storeIssueM) {
		if (null == getStoreIssueMs()) setStoreIssueMs(new java.util.TreeSet<jkt.hms.masters.business.StoreIssueM>());
		getStoreIssueMs().add(storeIssueM);
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
	 * Return the value associated with the column: EmpAfmsfDets
	 */
	public java.util.Set<jkt.hms.masters.business.EmpAfmsfDet> getEmpAfmsfDets () {
		return empAfmsfDets;
	}

	/**
	 * Set the value related to the column: EmpAfmsfDets
	 * @param empAfmsfDets the EmpAfmsfDets value
	 */
	public void setEmpAfmsfDets (java.util.Set<jkt.hms.masters.business.EmpAfmsfDet> empAfmsfDets) {
		this.empAfmsfDets = empAfmsfDets;
	}

	public void addToEmpAfmsfDets (jkt.hms.masters.business.EmpAfmsfDet empAfmsfDet) {
		if (null == getEmpAfmsfDets()) setEmpAfmsfDets(new java.util.TreeSet<jkt.hms.masters.business.EmpAfmsfDet>());
		getEmpAfmsfDets().add(empAfmsfDet);
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
		if (!(obj instanceof jkt.hms.masters.business.MasUnit)) return false;
		else {
			jkt.hms.masters.business.MasUnit masUnit = (jkt.hms.masters.business.MasUnit) obj;
			if (null == this.getId() || null == masUnit.getId()) return false;
			else return (this.getId().equals(masUnit.getId()));
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
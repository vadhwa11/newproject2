package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_rank table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_rank"
 */

public abstract class BaseMasRank  implements Serializable {

	public static String REF = "MasRank";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_RANK_CATEGORY = "RankCategory";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_SERVICE_TYPE = "ServiceType";
	public static String PROP_HIC_CODE = "HicCode";
	public static String PROP_ID = "Id";
	public static String PROP_RANK_NAME = "RankName";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_RANK_CODE = "RankCode";
	public static String PROP_SERVICE_STATUS = "ServiceStatus";


	// constructors
	public BaseMasRank () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasRank (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String rankCode;
	private java.lang.String rankName;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String hicCode;

	// many to one
	private jkt.hms.masters.business.MasRankCategory rankCategory;
	private jkt.hms.masters.business.MasServiceType serviceType;
	private jkt.hms.masters.business.MasServiceStatus serviceStatus;

	// collections
	private java.util.Set<jkt.hms.masters.business.StoreBoo> storeBoosByCommandRank;
	private java.util.Set<jkt.hms.masters.business.StoreBoo> storeBoosByPresidingOffRank;
	private java.util.Set<jkt.hms.masters.business.StoreBoo> storeBoosByOfficerIcRank;
	private java.util.Set<jkt.hms.masters.business.MasEmployee> masEmployees;
	private java.util.Set<jkt.hms.masters.business.StoreBooMember> storeBooMembers;
	private java.util.Set<jkt.hms.masters.business.EmpAfmsfDet> empAfmsfDets;
	private java.util.Set<jkt.hms.masters.business.Patient> patients;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="rank_id"
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
	 * Return the value associated with the column: rank_code
	 */
	public java.lang.String getRankCode () {
		return rankCode;
	}

	/**
	 * Set the value related to the column: rank_code
	 * @param rankCode the rank_code value
	 */
	public void setRankCode (java.lang.String rankCode) {
		this.rankCode = rankCode;
	}



	/**
	 * Return the value associated with the column: rank_name
	 */
	public java.lang.String getRankName () {
		return rankName;
	}

	/**
	 * Set the value related to the column: rank_name
	 * @param rankName the rank_name value
	 */
	public void setRankName (java.lang.String rankName) {
		this.rankName = rankName;
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
	 * Return the value associated with the column: rank_category_id
	 */
	public jkt.hms.masters.business.MasRankCategory getRankCategory () {
		return rankCategory;
	}

	/**
	 * Set the value related to the column: rank_category_id
	 * @param rankCategory the rank_category_id value
	 */
	public void setRankCategory (jkt.hms.masters.business.MasRankCategory rankCategory) {
		this.rankCategory = rankCategory;
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
	 * Return the value associated with the column: StoreBoosByCommandRank
	 */
	public java.util.Set<jkt.hms.masters.business.StoreBoo> getStoreBoosByCommandRank () {
		return storeBoosByCommandRank;
	}

	/**
	 * Set the value related to the column: StoreBoosByCommandRank
	 * @param storeBoosByCommandRank the StoreBoosByCommandRank value
	 */
	public void setStoreBoosByCommandRank (java.util.Set<jkt.hms.masters.business.StoreBoo> storeBoosByCommandRank) {
		this.storeBoosByCommandRank = storeBoosByCommandRank;
	}

	public void addToStoreBoosByCommandRank (jkt.hms.masters.business.StoreBoo storeBoo) {
		if (null == getStoreBoosByCommandRank()) setStoreBoosByCommandRank(new java.util.TreeSet<jkt.hms.masters.business.StoreBoo>());
		getStoreBoosByCommandRank().add(storeBoo);
	}



	/**
	 * Return the value associated with the column: StoreBoosByPresidingOffRank
	 */
	public java.util.Set<jkt.hms.masters.business.StoreBoo> getStoreBoosByPresidingOffRank () {
		return storeBoosByPresidingOffRank;
	}

	/**
	 * Set the value related to the column: StoreBoosByPresidingOffRank
	 * @param storeBoosByPresidingOffRank the StoreBoosByPresidingOffRank value
	 */
	public void setStoreBoosByPresidingOffRank (java.util.Set<jkt.hms.masters.business.StoreBoo> storeBoosByPresidingOffRank) {
		this.storeBoosByPresidingOffRank = storeBoosByPresidingOffRank;
	}

	public void addToStoreBoosByPresidingOffRank (jkt.hms.masters.business.StoreBoo storeBoo) {
		if (null == getStoreBoosByPresidingOffRank()) setStoreBoosByPresidingOffRank(new java.util.TreeSet<jkt.hms.masters.business.StoreBoo>());
		getStoreBoosByPresidingOffRank().add(storeBoo);
	}



	/**
	 * Return the value associated with the column: StoreBoosByOfficerIcRank
	 */
	public java.util.Set<jkt.hms.masters.business.StoreBoo> getStoreBoosByOfficerIcRank () {
		return storeBoosByOfficerIcRank;
	}

	/**
	 * Set the value related to the column: StoreBoosByOfficerIcRank
	 * @param storeBoosByOfficerIcRank the StoreBoosByOfficerIcRank value
	 */
	public void setStoreBoosByOfficerIcRank (java.util.Set<jkt.hms.masters.business.StoreBoo> storeBoosByOfficerIcRank) {
		this.storeBoosByOfficerIcRank = storeBoosByOfficerIcRank;
	}

	public void addToStoreBoosByOfficerIcRank (jkt.hms.masters.business.StoreBoo storeBoo) {
		if (null == getStoreBoosByOfficerIcRank()) setStoreBoosByOfficerIcRank(new java.util.TreeSet<jkt.hms.masters.business.StoreBoo>());
		getStoreBoosByOfficerIcRank().add(storeBoo);
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
	 * Return the value associated with the column: StoreBooMembers
	 */
	public java.util.Set<jkt.hms.masters.business.StoreBooMember> getStoreBooMembers () {
		return storeBooMembers;
	}

	/**
	 * Set the value related to the column: StoreBooMembers
	 * @param storeBooMembers the StoreBooMembers value
	 */
	public void setStoreBooMembers (java.util.Set<jkt.hms.masters.business.StoreBooMember> storeBooMembers) {
		this.storeBooMembers = storeBooMembers;
	}

	public void addToStoreBooMembers (jkt.hms.masters.business.StoreBooMember storeBooMember) {
		if (null == getStoreBooMembers()) setStoreBooMembers(new java.util.TreeSet<jkt.hms.masters.business.StoreBooMember>());
		getStoreBooMembers().add(storeBooMember);
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
		if (!(obj instanceof jkt.hms.masters.business.MasRank)) return false;
		else {
			jkt.hms.masters.business.MasRank masRank = (jkt.hms.masters.business.MasRank) obj;
			if (null == this.getId() || null == masRank.getId()) return false;
			else return (this.getId().equals(masRank.getId()));
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
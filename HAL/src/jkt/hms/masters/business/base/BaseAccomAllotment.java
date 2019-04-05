package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the accom_allotment table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="accom_allotment"
 */

public abstract class BaseAccomAllotment  implements Serializable {

	public static String REF = "AccomAllotment";
	public static String PROP_ALLOTMENT_NO = "AllotmentNo";
	public static String PROP_ALLOTMENT_DATE = "AllotmentDate";
	public static String PROP_HO_TO_DATE = "HoToDate";
	public static String PROP_ALLOTMENT_TIME = "AllotmentTime";
	public static String PROP_ALLOTMENT_TYPE = "AllotmentType";
	public static String PROP_RETENTION_DATE = "RetentionDate";
	public static String PROP_PHYSICAL_DATE = "PhysicalDate";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_ALLOT_TYPE = "AllotType";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseAccomAllotment () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAccomAllotment (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseAccomAllotment (
		java.lang.Integer id,
		jkt.hms.masters.business.MasHospital hospital,
		jkt.hms.masters.business.MasDepartment department,
		java.lang.String allotmentNo,
		java.util.Date allotmentDate,
		java.lang.String lastChgBy,
		java.util.Date lastChgDate,
		java.lang.String lastChgTime) {

		this.setId(id);
		this.setHospital(hospital);
		this.setDepartment(department);
		this.setAllotmentNo(allotmentNo);
		this.setAllotmentDate(allotmentDate);
		this.setLastChgBy(lastChgBy);
		this.setLastChgDate(lastChgDate);
		this.setLastChgTime(lastChgTime);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String allotmentNo;
	private java.util.Date allotmentDate;
	private java.util.Date hoToDate;
	private java.lang.String allotmentTime;
	private java.lang.String allotmentType;
	private java.util.Date retentionDate;
	private java.util.Date physicalDate;
	private java.lang.String remarks;
	private java.lang.String allotType;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasPool pool;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasSmq smq;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.AccomRegistration accom;
	private jkt.hms.masters.business.MasRank rank;
	private jkt.hms.masters.business.MasCarGarage masCarGarage;

	// collections
	private java.util.Set smqVacations;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="allotment_id"
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
	 * Return the value associated with the column: allotment_no
	 */
	public java.lang.String getAllotmentNo () {
		return allotmentNo;
	}

	/**
	 * Set the value related to the column: allotment_no
	 * @param allotmentNo the allotment_no value
	 */
	public void setAllotmentNo (java.lang.String allotmentNo) {
		this.allotmentNo = allotmentNo;
	}



	/**
	 * Return the value associated with the column: allotment_date
	 */
	public java.util.Date getAllotmentDate () {
		return allotmentDate;
	}

	/**
	 * Set the value related to the column: allotment_date
	 * @param allotmentDate the allotment_date value
	 */
	public void setAllotmentDate (java.util.Date allotmentDate) {
		this.allotmentDate = allotmentDate;
	}



	/**
	 * Return the value associated with the column: ho_to_date
	 */
	public java.util.Date getHoToDate () {
		return hoToDate;
	}

	/**
	 * Set the value related to the column: ho_to_date
	 * @param hoToDate the ho_to_date value
	 */
	public void setHoToDate (java.util.Date hoToDate) {
		this.hoToDate = hoToDate;
	}



	/**
	 * Return the value associated with the column: allotment_time
	 */
	public java.lang.String getAllotmentTime () {
		return allotmentTime;
	}

	/**
	 * Set the value related to the column: allotment_time
	 * @param allotmentTime the allotment_time value
	 */
	public void setAllotmentTime (java.lang.String allotmentTime) {
		this.allotmentTime = allotmentTime;
	}



	/**
	 * Return the value associated with the column: allotment_type
	 */
	public java.lang.String getAllotmentType () {
		return allotmentType;
	}

	/**
	 * Set the value related to the column: allotment_type
	 * @param allotmentType the allotment_type value
	 */
	public void setAllotmentType (java.lang.String allotmentType) {
		this.allotmentType = allotmentType;
	}



	/**
	 * Return the value associated with the column: retention_date
	 */
	public java.util.Date getRetentionDate () {
		return retentionDate;
	}

	/**
	 * Set the value related to the column: retention_date
	 * @param retentionDate the retention_date value
	 */
	public void setRetentionDate (java.util.Date retentionDate) {
		this.retentionDate = retentionDate;
	}



	/**
	 * Return the value associated with the column: physical_date
	 */
	public java.util.Date getPhysicalDate () {
		return physicalDate;
	}

	/**
	 * Set the value related to the column: physical_date
	 * @param physicalDate the physical_date value
	 */
	public void setPhysicalDate (java.util.Date physicalDate) {
		this.physicalDate = physicalDate;
	}



	/**
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * @param remarks the remarks value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
	}



	/**
	 * Return the value associated with the column: allot_type
	 */
	public java.lang.String getAllotType () {
		return allotType;
	}

	/**
	 * Set the value related to the column: allot_type
	 * @param allotType the allot_type value
	 */
	public void setAllotType (java.lang.String allotType) {
		this.allotType = allotType;
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
	 * Return the value associated with the column: pool_id
	 */
	public jkt.hms.masters.business.MasPool getPool () {
		return pool;
	}

	/**
	 * Set the value related to the column: pool_id
	 * @param pool the pool_id value
	 */
	public void setPool (jkt.hms.masters.business.MasPool pool) {
		this.pool = pool;
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



	/**
	 * Return the value associated with the column: smq_id
	 */
	public jkt.hms.masters.business.MasSmq getSmq () {
		return smq;
	}

	/**
	 * Set the value related to the column: smq_id
	 * @param smq the smq_id value
	 */
	public void setSmq (jkt.hms.masters.business.MasSmq smq) {
		this.smq = smq;
	}



	/**
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment () {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * @param department the department_id value
	 */
	public void setDepartment (jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}



	/**
	 * Return the value associated with the column: accom_id
	 */
	public jkt.hms.masters.business.AccomRegistration getAccom () {
		return accom;
	}

	/**
	 * Set the value related to the column: accom_id
	 * @param accom the accom_id value
	 */
	public void setAccom (jkt.hms.masters.business.AccomRegistration accom) {
		this.accom = accom;
	}



	/**
	 * Return the value associated with the column: rank_id
	 */
	public jkt.hms.masters.business.MasRank getRank () {
		return rank;
	}

	/**
	 * Set the value related to the column: rank_id
	 * @param rank the rank_id value
	 */
	public void setRank (jkt.hms.masters.business.MasRank rank) {
		this.rank = rank;
	}



	/**
	 * Return the value associated with the column: car_garage_id
	 */
	public jkt.hms.masters.business.MasCarGarage getMasCarGarage () {
		return masCarGarage;
	}

	/**
	 * Set the value related to the column: car_garage_id
	 * @param masCarGarage the car_garage_id value
	 */
	public void setMasCarGarage (jkt.hms.masters.business.MasCarGarage masCarGarage) {
		this.masCarGarage = masCarGarage;
	}



	/**
	 * Return the value associated with the column: SmqVacations
	 */
	public java.util.Set getSmqVacations () {
		return smqVacations;
	}

	/**
	 * Set the value related to the column: SmqVacations
	 * @param smqVacations the SmqVacations value
	 */
	public void setSmqVacations (java.util.Set smqVacations) {
		this.smqVacations = smqVacations;
	}

	public void addToSmqVacations (jkt.hms.masters.business.SmqVacation smqVacation) {
		if (null == getSmqVacations()) setSmqVacations(new java.util.HashSet());
		getSmqVacations().add(smqVacation);
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.AccomAllotment)) return false;
		else {
			jkt.hms.masters.business.AccomAllotment accomAllotment = (jkt.hms.masters.business.AccomAllotment) obj;
			if (null == this.getId() || null == accomAllotment.getId()) return false;
			else return (this.getId().equals(accomAllotment.getId()));
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
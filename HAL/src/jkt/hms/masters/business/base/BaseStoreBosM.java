package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the store_bos_m table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="store_bos_m"
 */

public abstract class BaseStoreBosM  implements Serializable {

	public static String REF = "StoreBosM";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_BOS_DATE = "BosDate";
	public static String PROP_ID = "Id";
	public static String PROP_BOS_NO = "BosNo";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseStoreBosM () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreBosM (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseStoreBosM (
		java.lang.Integer id,
		jkt.hms.masters.business.MasHospital hospital,
		jkt.hms.masters.business.MasDepartment department,
		java.lang.String bosNo,
		java.util.Date bosDate,
		java.lang.String status,
		java.lang.String lastChgBy,
		java.util.Date lastChgDate,
		java.lang.String lastChgTime) {

		this.setId(id);
		this.setHospital(hospital);
		this.setDepartment(department);
		this.setBosNo(bosNo);
		this.setBosDate(bosDate);
		this.setStatus(status);
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
	private java.lang.String bosNo;
	private java.util.Date bosDate;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;

	// collections
	private java.util.Set<jkt.hms.masters.business.StoreBosT> storeBosTs;
	private java.util.Set<jkt.hms.masters.business.StoreDisposalM> storeDisposalMs;



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
	 * Return the value associated with the column: bos_no
	 */
	public java.lang.String getBosNo () {
		return bosNo;
	}

	/**
	 * Set the value related to the column: bos_no
	 * @param bosNo the bos_no value
	 */
	public void setBosNo (java.lang.String bosNo) {
		this.bosNo = bosNo;
	}



	/**
	 * Return the value associated with the column: bos_date
	 */
	public java.util.Date getBosDate () {
		return bosDate;
	}

	/**
	 * Set the value related to the column: bos_date
	 * @param bosDate the bos_date value
	 */
	public void setBosDate (java.util.Date bosDate) {
		this.bosDate = bosDate;
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
	 * Return the value associated with the column: StoreBosTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreBosT> getStoreBosTs () {
		return storeBosTs;
	}

	/**
	 * Set the value related to the column: StoreBosTs
	 * @param storeBosTs the StoreBosTs value
	 */
	public void setStoreBosTs (java.util.Set<jkt.hms.masters.business.StoreBosT> storeBosTs) {
		this.storeBosTs = storeBosTs;
	}

	public void addToStoreBosTs (jkt.hms.masters.business.StoreBosT storeBosT) {
		if (null == getStoreBosTs()) setStoreBosTs(new java.util.TreeSet<jkt.hms.masters.business.StoreBosT>());
		getStoreBosTs().add(storeBosT);
	}



	/**
	 * Return the value associated with the column: StoreDisposalMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreDisposalM> getStoreDisposalMs () {
		return storeDisposalMs;
	}

	/**
	 * Set the value related to the column: StoreDisposalMs
	 * @param storeDisposalMs the StoreDisposalMs value
	 */
	public void setStoreDisposalMs (java.util.Set<jkt.hms.masters.business.StoreDisposalM> storeDisposalMs) {
		this.storeDisposalMs = storeDisposalMs;
	}

	public void addToStoreDisposalMs (jkt.hms.masters.business.StoreDisposalM storeDisposalM) {
		if (null == getStoreDisposalMs()) setStoreDisposalMs(new java.util.TreeSet<jkt.hms.masters.business.StoreDisposalM>());
		getStoreDisposalMs().add(storeDisposalM);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreBosM)) return false;
		else {
			jkt.hms.masters.business.StoreBosM storeBosM = (jkt.hms.masters.business.StoreBosM) obj;
			if (null == this.getId() || null == storeBosM.getId()) return false;
			else return (this.getId().equals(storeBosM.getId()));
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
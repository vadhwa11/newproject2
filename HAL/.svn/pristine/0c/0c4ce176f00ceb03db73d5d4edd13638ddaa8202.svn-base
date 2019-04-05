package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the store_quater_return_m
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="store_quater_return_m"
 */

public abstract class BaseStoreQuaterReturnM implements Serializable {

	public static String REF = "StoreQuaterReturnM";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_DOC_NO = "DocNo";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_DATE = "Date";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_ID = "Id";

	// constructors
	public BaseStoreQuaterReturnM() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreQuaterReturnM(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseStoreQuaterReturnM(java.lang.Integer id,
			jkt.hms.masters.business.MasHospital hospital,
			jkt.hms.masters.business.MasDepartment department,
			java.lang.Integer docNo, java.util.Date date,
			java.lang.String status, java.lang.String lastChgBy,
			java.util.Date lastChgDate, java.lang.String lastChgTime) {

		this.setId(id);
		this.setHospital(hospital);
		this.setDepartment(department);
		this.setDocNo(docNo);
		this.setDate(date);
		this.setStatus(status);
		this.setLastChgBy(lastChgBy);
		this.setLastChgDate(lastChgDate);
		this.setLastChgTime(lastChgTime);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer docNo;
	private java.util.Date date;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;

	// collections
	private java.util.Set<jkt.hms.masters.business.StoreQuaterReturnT> storeQuaterReturnTs;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="id"
	 */
	public java.lang.Integer getId() {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * 
	 * @param id
	 *            the new ID
	 */
	public void setId(java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}

	/**
	 * Return the value associated with the column: doc_no
	 */
	public java.lang.Integer getDocNo() {
		return docNo;
	}

	/**
	 * Set the value related to the column: doc_no
	 * 
	 * @param docNo
	 *            the doc_no value
	 */
	public void setDocNo(java.lang.Integer docNo) {
		this.docNo = docNo;
	}

	/**
	 * Return the value associated with the column: date
	 */
	public java.util.Date getDate() {
		return date;
	}

	/**
	 * Set the value related to the column: date
	 * 
	 * @param date
	 *            the date value
	 */
	public void setDate(java.util.Date date) {
		this.date = date;
	}

	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus() {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * 
	 * @param status
	 *            the status value
	 */
	public void setStatus(java.lang.String status) {
		this.status = status;
	}

	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.String getLastChgBy() {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * 
	 * @param lastChgBy
	 *            the last_chg_by value
	 */
	public void setLastChgBy(java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
	}

	/**
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate() {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * 
	 * @param lastChgDate
	 *            the last_chg_date value
	 */
	public void setLastChgDate(java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}

	/**
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime() {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * 
	 * @param lastChgTime
	 *            the last_chg_time value
	 */
	public void setLastChgTime(java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}

	/**
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital() {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * 
	 * @param hospital
	 *            the hospital_id value
	 */
	public void setHospital(jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}

	/**
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment() {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * 
	 * @param department
	 *            the department_id value
	 */
	public void setDepartment(jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}

	/**
	 * Return the value associated with the column: StoreQuaterReturnTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreQuaterReturnT> getStoreQuaterReturnTs() {
		return storeQuaterReturnTs;
	}

	/**
	 * Set the value related to the column: StoreQuaterReturnTs
	 * 
	 * @param storeQuaterReturnTs
	 *            the StoreQuaterReturnTs value
	 */
	public void setStoreQuaterReturnTs(
			java.util.Set<jkt.hms.masters.business.StoreQuaterReturnT> storeQuaterReturnTs) {
		this.storeQuaterReturnTs = storeQuaterReturnTs;
	}

	public void addToStoreQuaterReturnTs(
			jkt.hms.masters.business.StoreQuaterReturnT storeQuaterReturnT) {
		if (null == getStoreQuaterReturnTs())
			setStoreQuaterReturnTs(new java.util.TreeSet<jkt.hms.masters.business.StoreQuaterReturnT>());
		getStoreQuaterReturnTs().add(storeQuaterReturnT);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreQuaterReturnM))
			return false;
		else {
			jkt.hms.masters.business.StoreQuaterReturnM storeQuaterReturnM = (jkt.hms.masters.business.StoreQuaterReturnM) obj;
			if (null == this.getId() || null == storeQuaterReturnM.getId())
				return false;
			else
				return (this.getId().equals(storeQuaterReturnM.getId()));
		}
	}

	public int hashCode() {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId())
				return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":"
						+ this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}

	public String toString() {
		return super.toString();
	}

}
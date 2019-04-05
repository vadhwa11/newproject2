package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the store_balance_m table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="store_balance_m"
 */

public abstract class BaseStoreBalanceM implements Serializable {

	public static String REF = "StoreBalanceM";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_BALANCE_DATE = "BalanceDate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_ID = "Id";
	public static String PROP_APPROVED_BY = "ApprovedBy";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_BALANCE_NO = "BalanceNo";

	// constructors
	public BaseStoreBalanceM() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreBalanceM(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseStoreBalanceM(java.lang.Integer id,
			jkt.hms.masters.business.MasHospital hospital,
			jkt.hms.masters.business.MasDepartment department) {

		this.setId(id);
		this.setHospital(hospital);
		this.setDepartment(department);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String balanceNo;
	private java.util.Date balanceDate;
	private java.lang.String remarks;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasEmployee approvedBy;
	private jkt.hms.masters.business.MasDepartment department;

	// collections
	private java.util.Set<jkt.hms.masters.business.StoreBalanceT> storeBalanceTs;

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
	 * Return the value associated with the column: balance_no
	 */
	public java.lang.String getBalanceNo() {
		return balanceNo;
	}

	/**
	 * Set the value related to the column: balance_no
	 * 
	 * @param balanceNo
	 *            the balance_no value
	 */
	public void setBalanceNo(java.lang.String balanceNo) {
		this.balanceNo = balanceNo;
	}

	/**
	 * Return the value associated with the column: balance_date
	 */
	public java.util.Date getBalanceDate() {
		return balanceDate;
	}

	/**
	 * Set the value related to the column: balance_date
	 * 
	 * @param balanceDate
	 *            the balance_date value
	 */
	public void setBalanceDate(java.util.Date balanceDate) {
		this.balanceDate = balanceDate;
	}

	/**
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks() {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * 
	 * @param remarks
	 *            the remarks value
	 */
	public void setRemarks(java.lang.String remarks) {
		this.remarks = remarks;
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
	 * Return the value associated with the column: approved_by
	 */
	public jkt.hms.masters.business.MasEmployee getApprovedBy() {
		return approvedBy;
	}

	/**
	 * Set the value related to the column: approved_by
	 * 
	 * @param approvedBy
	 *            the approved_by value
	 */
	public void setApprovedBy(jkt.hms.masters.business.MasEmployee approvedBy) {
		this.approvedBy = approvedBy;
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
	 * Return the value associated with the column: StoreBalanceTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreBalanceT> getStoreBalanceTs() {
		return storeBalanceTs;
	}

	/**
	 * Set the value related to the column: StoreBalanceTs
	 * 
	 * @param storeBalanceTs
	 *            the StoreBalanceTs value
	 */
	public void setStoreBalanceTs(
			java.util.Set<jkt.hms.masters.business.StoreBalanceT> storeBalanceTs) {
		this.storeBalanceTs = storeBalanceTs;
	}

	public void addToStoreBalanceTs(
			jkt.hms.masters.business.StoreBalanceT storeBalanceT) {
		if (null == getStoreBalanceTs())
			setStoreBalanceTs(new java.util.TreeSet<jkt.hms.masters.business.StoreBalanceT>());
		getStoreBalanceTs().add(storeBalanceT);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreBalanceM))
			return false;
		else {
			jkt.hms.masters.business.StoreBalanceM storeBalanceM = (jkt.hms.masters.business.StoreBalanceM) obj;
			if (null == this.getId() || null == storeBalanceM.getId())
				return false;
			else
				return (this.getId().equals(storeBalanceM.getId()));
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
package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the store_condemnation_m table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="store_condemnation_m"
 */

public abstract class BaseStoreCondemnationM  implements Serializable {

	public static String REF = "StoreCondemnationM";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_WORK_ORDER_DATE = "WorkOrderDate";
	public static String PROP_ID = "Id";
	public static String PROP_CONDEMNATION_DATE = "CondemnationDate";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_CONDEMNATION_NO = "CondemnationNo";
	public static String PROP_WORK_ORDER = "WorkOrder";


	// constructors
	public BaseStoreCondemnationM () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreCondemnationM (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseStoreCondemnationM (
		java.lang.Integer id,
		jkt.hms.masters.business.MasHospital hospital,
		jkt.hms.masters.business.MasDepartment department,
		java.lang.String condemnationNo,
		java.util.Date condemnationDate,
		java.lang.String status,
		java.lang.String lastChgBy,
		java.util.Date lastChgDate,
		java.lang.String lastChgTime) {

		this.setId(id);
		this.setHospital(hospital);
		this.setDepartment(department);
		this.setCondemnationNo(condemnationNo);
		this.setCondemnationDate(condemnationDate);
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
	private java.lang.String condemnationNo;
	private java.util.Date condemnationDate;
	private java.util.Date workOrderDate;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.StoreWorkOrderM workOrder;
	private jkt.hms.masters.business.MasDepartment department;

	// collections
	private java.util.Set<jkt.hms.masters.business.StoreCondemnationT> storeCondemnationTs;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
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
	 * Return the value associated with the column: condemnation_no
	 */
	public java.lang.String getCondemnationNo () {
		return condemnationNo;
	}

	/**
	 * Set the value related to the column: condemnation_no
	 * @param condemnationNo the condemnation_no value
	 */
	public void setCondemnationNo (java.lang.String condemnationNo) {
		this.condemnationNo = condemnationNo;
	}



	/**
	 * Return the value associated with the column: condemnation_date
	 */
	public java.util.Date getCondemnationDate () {
		return condemnationDate;
	}

	/**
	 * Set the value related to the column: condemnation_date
	 * @param condemnationDate the condemnation_date value
	 */
	public void setCondemnationDate (java.util.Date condemnationDate) {
		this.condemnationDate = condemnationDate;
	}



	/**
	 * Return the value associated with the column: work_order_date
	 */
	public java.util.Date getWorkOrderDate () {
		return workOrderDate;
	}

	/**
	 * Set the value related to the column: work_order_date
	 * @param workOrderDate the work_order_date value
	 */
	public void setWorkOrderDate (java.util.Date workOrderDate) {
		this.workOrderDate = workOrderDate;
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
	 * Return the value associated with the column: work_order_id
	 */
	public jkt.hms.masters.business.StoreWorkOrderM getWorkOrder () {
		return workOrder;
	}

	/**
	 * Set the value related to the column: work_order_id
	 * @param workOrder the work_order_id value
	 */
	public void setWorkOrder (jkt.hms.masters.business.StoreWorkOrderM workOrder) {
		this.workOrder = workOrder;
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
	 * Return the value associated with the column: StoreCondemnationTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreCondemnationT> getStoreCondemnationTs () {
		return storeCondemnationTs;
	}

	/**
	 * Set the value related to the column: StoreCondemnationTs
	 * @param storeCondemnationTs the StoreCondemnationTs value
	 */
	public void setStoreCondemnationTs (java.util.Set<jkt.hms.masters.business.StoreCondemnationT> storeCondemnationTs) {
		this.storeCondemnationTs = storeCondemnationTs;
	}

	public void addToStoreCondemnationTs (jkt.hms.masters.business.StoreCondemnationT storeCondemnationT) {
		if (null == getStoreCondemnationTs()) setStoreCondemnationTs(new java.util.TreeSet<jkt.hms.masters.business.StoreCondemnationT>());
		getStoreCondemnationTs().add(storeCondemnationT);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreCondemnationM)) return false;
		else {
			jkt.hms.masters.business.StoreCondemnationM storeCondemnationM = (jkt.hms.masters.business.StoreCondemnationM) obj;
			if (null == this.getId() || null == storeCondemnationM.getId()) return false;
			else return (this.getId().equals(storeCondemnationM.getId()));
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
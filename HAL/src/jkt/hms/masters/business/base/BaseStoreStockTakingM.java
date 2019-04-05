package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the store_stock_taking_m table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="store_stock_taking_m"
 */

public abstract class BaseStoreStockTakingM  implements Serializable {

	public static String REF = "StoreStockTakingM";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHANGED_TIME = "LastChangedTime";
	public static String PROP_LAST_CHANGED_DATE = "LastChangedDate";
	public static String PROP_PHYSICAL_DATE = "PhysicalDate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHANGED_BY = "LastChangedBy";
	public static String PROP_APPROVED_BY = "ApprovedBy";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_STOCK_TAKING_NO = "StockTakingNo";
	public static String PROP_REASON = "Reason";


	// constructors
	public BaseStoreStockTakingM () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreStockTakingM (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date lastChangedDate;
	private java.lang.String lastChangedTime;
	private java.util.Date physicalDate;
	private java.lang.String reason;
	private java.lang.String status;
	private java.lang.String stockTakingNo;

	// many to one
	private jkt.hms.masters.business.Users approvedBy;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Users lastChangedBy;

	// collections
	private java.util.Set<jkt.hms.masters.business.StoreAdjustmentM> storeAdjustmentMs;
	private java.util.Set<jkt.hms.masters.business.StoreStockTakingT> storeStockTakingTs;



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
	 * Return the value associated with the column: last_changed_date
	 */
	public java.util.Date getLastChangedDate () {
		return lastChangedDate;
	}

	/**
	 * Set the value related to the column: last_changed_date
	 * @param lastChangedDate the last_changed_date value
	 */
	public void setLastChangedDate (java.util.Date lastChangedDate) {
		this.lastChangedDate = lastChangedDate;
	}



	/**
	 * Return the value associated with the column: last_changed_time
	 */
	public java.lang.String getLastChangedTime () {
		return lastChangedTime;
	}

	/**
	 * Set the value related to the column: last_changed_time
	 * @param lastChangedTime the last_changed_time value
	 */
	public void setLastChangedTime (java.lang.String lastChangedTime) {
		this.lastChangedTime = lastChangedTime;
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
	 * Return the value associated with the column: reason
	 */
	public java.lang.String getReason () {
		return reason;
	}

	/**
	 * Set the value related to the column: reason
	 * @param reason the reason value
	 */
	public void setReason (java.lang.String reason) {
		this.reason = reason;
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
	 * Return the value associated with the column: stock_taking_no
	 */
	public java.lang.String getStockTakingNo () {
		return stockTakingNo;
	}

	/**
	 * Set the value related to the column: stock_taking_no
	 * @param stockTakingNo the stock_taking_no value
	 */
	public void setStockTakingNo (java.lang.String stockTakingNo) {
		this.stockTakingNo = stockTakingNo;
	}



	/**
	 * Return the value associated with the column: approved_by
	 */
	public jkt.hms.masters.business.Users getApprovedBy () {
		return approvedBy;
	}

	/**
	 * Set the value related to the column: approved_by
	 * @param approvedBy the approved_by value
	 */
	public void setApprovedBy (jkt.hms.masters.business.Users approvedBy) {
		this.approvedBy = approvedBy;
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
	 * Return the value associated with the column: last_changed_by
	 */
	public jkt.hms.masters.business.Users getLastChangedBy () {
		return lastChangedBy;
	}

	/**
	 * Set the value related to the column: last_changed_by
	 * @param lastChangedBy the last_changed_by value
	 */
	public void setLastChangedBy (jkt.hms.masters.business.Users lastChangedBy) {
		this.lastChangedBy = lastChangedBy;
	}



	/**
	 * Return the value associated with the column: StoreAdjustmentMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreAdjustmentM> getStoreAdjustmentMs () {
		return storeAdjustmentMs;
	}

	/**
	 * Set the value related to the column: StoreAdjustmentMs
	 * @param storeAdjustmentMs the StoreAdjustmentMs value
	 */
	public void setStoreAdjustmentMs (java.util.Set<jkt.hms.masters.business.StoreAdjustmentM> storeAdjustmentMs) {
		this.storeAdjustmentMs = storeAdjustmentMs;
	}

	public void addToStoreAdjustmentMs (jkt.hms.masters.business.StoreAdjustmentM storeAdjustmentM) {
		if (null == getStoreAdjustmentMs()) setStoreAdjustmentMs(new java.util.TreeSet<jkt.hms.masters.business.StoreAdjustmentM>());
		getStoreAdjustmentMs().add(storeAdjustmentM);
	}



	/**
	 * Return the value associated with the column: StoreStockTakingTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreStockTakingT> getStoreStockTakingTs () {
		return storeStockTakingTs;
	}

	/**
	 * Set the value related to the column: StoreStockTakingTs
	 * @param storeStockTakingTs the StoreStockTakingTs value
	 */
	public void setStoreStockTakingTs (java.util.Set<jkt.hms.masters.business.StoreStockTakingT> storeStockTakingTs) {
		this.storeStockTakingTs = storeStockTakingTs;
	}

	public void addToStoreStockTakingTs (jkt.hms.masters.business.StoreStockTakingT storeStockTakingT) {
		if (null == getStoreStockTakingTs()) setStoreStockTakingTs(new java.util.TreeSet<jkt.hms.masters.business.StoreStockTakingT>());
		getStoreStockTakingTs().add(storeStockTakingT);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreStockTakingM)) return false;
		else {
			jkt.hms.masters.business.StoreStockTakingM storeStockTakingM = (jkt.hms.masters.business.StoreStockTakingM) obj;
			if (null == this.getId() || null == storeStockTakingM.getId()) return false;
			else return (this.getId().equals(storeStockTakingM.getId()));
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
package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the store_internal_return_m table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="store_internal_return_m"
 */

public abstract class BaseStoreInternalReturnM  implements Serializable {

	public static String REF = "StoreInternalReturnM";
	public static String PROP_LAST_CHANGED_DATE = "LastChangedDate";
	public static String PROP_FROM_DEPARTMENT = "FromDepartment";
	public static String PROP_RECEIVED_BY = "ReceivedBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_RECEIVED_DATE = "ReceivedDate";
	public static String PROP_RETURN_BY = "ReturnBy";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_RETURN_DATE = "ReturnDate";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_REFERENCE_NO = "ReferenceNo";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHANGED_TIME = "LastChangedTime";
	public static String PROP_TO_DEPARTMENT = "ToDepartment";
	public static String PROP_RETURN_NO = "ReturnNo";
	public static String PROP_ID = "Id";
	public static String PROP_TOTAL_AMT = "TotalAmt";
	public static String PROP_LAST_CHANGED_BY = "LastChangedBy";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_REASON = "Reason";


	// constructors
	public BaseStoreInternalReturnM () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreInternalReturnM (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String returnNo;
	private java.util.Date returnDate;
	private java.lang.String referenceNo;
	private java.math.BigDecimal totalAmt;
	private java.lang.String reason;
	private java.lang.String remarks;
	private java.lang.String lastChangedBy;
	private java.util.Date lastChangedDate;
	private java.lang.String lastChangedTime;
	private java.lang.String status;
	private java.util.Date receivedDate;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment toDepartment;
	private jkt.hms.masters.business.MasEmployee returnBy;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasDepartment fromDepartment;
	private jkt.hms.masters.business.MasEmployee receivedBy;
	private jkt.hms.masters.business.MasEmployee employee;

	// collections
	private java.util.Set<jkt.hms.masters.business.StoreInternalReturnT> storeInternalReturnTs;



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
	 * Return the value associated with the column: return_no
	 */
	public java.lang.String getReturnNo () {
		return returnNo;
	}

	/**
	 * Set the value related to the column: return_no
	 * @param returnNo the return_no value
	 */
	public void setReturnNo (java.lang.String returnNo) {
		this.returnNo = returnNo;
	}



	/**
	 * Return the value associated with the column: return_date
	 */
	public java.util.Date getReturnDate () {
		return returnDate;
	}

	/**
	 * Set the value related to the column: return_date
	 * @param returnDate the return_date value
	 */
	public void setReturnDate (java.util.Date returnDate) {
		this.returnDate = returnDate;
	}



	/**
	 * Return the value associated with the column: reference_no
	 */
	public java.lang.String getReferenceNo () {
		return referenceNo;
	}

	/**
	 * Set the value related to the column: reference_no
	 * @param referenceNo the reference_no value
	 */
	public void setReferenceNo (java.lang.String referenceNo) {
		this.referenceNo = referenceNo;
	}



	/**
	 * Return the value associated with the column: total_amt
	 */
	public java.math.BigDecimal getTotalAmt () {
		return totalAmt;
	}

	/**
	 * Set the value related to the column: total_amt
	 * @param totalAmt the total_amt value
	 */
	public void setTotalAmt (java.math.BigDecimal totalAmt) {
		this.totalAmt = totalAmt;
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
	 * Return the value associated with the column: last_changed_by
	 */
	public java.lang.String getLastChangedBy () {
		return lastChangedBy;
	}

	/**
	 * Set the value related to the column: last_changed_by
	 * @param lastChangedBy the last_changed_by value
	 */
	public void setLastChangedBy (java.lang.String lastChangedBy) {
		this.lastChangedBy = lastChangedBy;
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
	 * Return the value associated with the column: received_date
	 */
	public java.util.Date getReceivedDate () {
		return receivedDate;
	}

	/**
	 * Set the value related to the column: received_date
	 * @param receivedDate the received_date value
	 */
	public void setReceivedDate (java.util.Date receivedDate) {
		this.receivedDate = receivedDate;
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
	 * Return the value associated with the column: to_department_id
	 */
	public jkt.hms.masters.business.MasDepartment getToDepartment () {
		return toDepartment;
	}

	/**
	 * Set the value related to the column: to_department_id
	 * @param toDepartment the to_department_id value
	 */
	public void setToDepartment (jkt.hms.masters.business.MasDepartment toDepartment) {
		this.toDepartment = toDepartment;
	}



	/**
	 * Return the value associated with the column: return_by_id
	 */
	public jkt.hms.masters.business.MasEmployee getReturnBy () {
		return returnBy;
	}

	/**
	 * Set the value related to the column: return_by_id
	 * @param returnBy the return_by_id value
	 */
	public void setReturnBy (jkt.hms.masters.business.MasEmployee returnBy) {
		this.returnBy = returnBy;
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
	 * Return the value associated with the column: from_department_id
	 */
	public jkt.hms.masters.business.MasDepartment getFromDepartment () {
		return fromDepartment;
	}

	/**
	 * Set the value related to the column: from_department_id
	 * @param fromDepartment the from_department_id value
	 */
	public void setFromDepartment (jkt.hms.masters.business.MasDepartment fromDepartment) {
		this.fromDepartment = fromDepartment;
	}



	/**
	 * Return the value associated with the column: received_by_id
	 */
	public jkt.hms.masters.business.MasEmployee getReceivedBy () {
		return receivedBy;
	}

	/**
	 * Set the value related to the column: received_by_id
	 * @param receivedBy the received_by_id value
	 */
	public void setReceivedBy (jkt.hms.masters.business.MasEmployee receivedBy) {
		this.receivedBy = receivedBy;
	}



	/**
	 * Return the value associated with the column: employee_id
	 */
	public jkt.hms.masters.business.MasEmployee getEmployee () {
		return employee;
	}

	/**
	 * Set the value related to the column: employee_id
	 * @param employee the employee_id value
	 */
	public void setEmployee (jkt.hms.masters.business.MasEmployee employee) {
		this.employee = employee;
	}



	/**
	 * Return the value associated with the column: StoreInternalReturnTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreInternalReturnT> getStoreInternalReturnTs () {
		return storeInternalReturnTs;
	}

	/**
	 * Set the value related to the column: StoreInternalReturnTs
	 * @param storeInternalReturnTs the StoreInternalReturnTs value
	 */
	public void setStoreInternalReturnTs (java.util.Set<jkt.hms.masters.business.StoreInternalReturnT> storeInternalReturnTs) {
		this.storeInternalReturnTs = storeInternalReturnTs;
	}

	public void addToStoreInternalReturnTs (jkt.hms.masters.business.StoreInternalReturnT storeInternalReturnT) {
		if (null == getStoreInternalReturnTs()) setStoreInternalReturnTs(new java.util.TreeSet<jkt.hms.masters.business.StoreInternalReturnT>());
		getStoreInternalReturnTs().add(storeInternalReturnT);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreInternalReturnM)) return false;
		else {
			jkt.hms.masters.business.StoreInternalReturnM storeInternalReturnM = (jkt.hms.masters.business.StoreInternalReturnM) obj;
			if (null == this.getId() || null == storeInternalReturnM.getId()) return false;
			else return (this.getId().equals(storeInternalReturnM.getId()));
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
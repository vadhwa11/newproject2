package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the store_mmf_department_m table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="store_mmf_department_m"
 */

public abstract class BaseStoreMmfDepartmentM  implements Serializable {

	public static String REF = "StoreMmfDepartmentM";
	public static String PROP_CHECKED_BY = "CheckedBy";
	public static String PROP_STORE_WARD_DEPT = "StoreWardDept";
	public static String PROP_DOC_NO = "DocNo";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_APPROVED_BY = "ApprovedBy";
	public static String PROP_MMF_FOR_THE_YEAR = "MmfForTheYear";
	public static String PROP_STATUS = "Status";
	public static String PROP_MMF_STORE_TYPE = "MmfStoreType";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_PREPARED_BY = "PreparedBy";
	public static String PROP_ID = "Id";
	public static String PROP_MMF_FOR_THE_MONTH = "MmfForTheMonth";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";


	// constructors
	public BaseStoreMmfDepartmentM () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreMmfDepartmentM (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String docNo;
	private java.lang.String remarks;
	private java.lang.String preparedBy;
	private java.lang.String checkedBy;
	private java.lang.String lastChgBy;
	private java.lang.String mmfStoreType;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.Integer mmfForTheYear;
	private java.lang.Integer mmfForTheMonth;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasDepartment storeWardDept;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasEmployee approvedBy;

	// collections
	private java.util.Set<jkt.hms.masters.business.StoreMmfDepartmentT> storeMmfDepartmentTs;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
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
	 * Return the value associated with the column: doc_no
	 */
	public java.lang.String getDocNo () {
		return docNo;
	}

	/**
	 * Set the value related to the column: doc_no
	 * @param docNo the doc_no value
	 */
	public void setDocNo (java.lang.String docNo) {
		this.docNo = docNo;
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
	 * Return the value associated with the column: prepared_by
	 */
	public java.lang.String getPreparedBy () {
		return preparedBy;
	}

	/**
	 * Set the value related to the column: prepared_by
	 * @param preparedBy the prepared_by value
	 */
	public void setPreparedBy (java.lang.String preparedBy) {
		this.preparedBy = preparedBy;
	}



	/**
	 * Return the value associated with the column: checked_by
	 */
	public java.lang.String getCheckedBy () {
		return checkedBy;
	}

	/**
	 * Set the value related to the column: checked_by
	 * @param checkedBy the checked_by value
	 */
	public void setCheckedBy (java.lang.String checkedBy) {
		this.checkedBy = checkedBy;
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
	 * Return the value associated with the column: mmf_store_type
	 */
	public java.lang.String getMmfStoreType () {
		return mmfStoreType;
	}

	/**
	 * Set the value related to the column: mmf_store_type
	 * @param mmfStoreType the mmf_store_type value
	 */
	public void setMmfStoreType (java.lang.String mmfStoreType) {
		this.mmfStoreType = mmfStoreType;
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
	 * Return the value associated with the column: mmf_for_the_year
	 */
	public java.lang.Integer getMmfForTheYear () {
		return mmfForTheYear;
	}

	/**
	 * Set the value related to the column: mmf_for_the_year
	 * @param mmfForTheYear the mmf_for_the_year value
	 */
	public void setMmfForTheYear (java.lang.Integer mmfForTheYear) {
		this.mmfForTheYear = mmfForTheYear;
	}



	/**
	 * Return the value associated with the column: MONTH_FOR_MMF
	 */
	public java.lang.Integer getMmfForTheMonth () {
		return mmfForTheMonth;
	}

	/**
	 * Set the value related to the column: MONTH_FOR_MMF
	 * @param mmfForTheMonth the MONTH_FOR_MMF value
	 */
	public void setMmfForTheMonth (java.lang.Integer mmfForTheMonth) {
		this.mmfForTheMonth = mmfForTheMonth;
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
	 * Return the value associated with the column: store_ward_dept
	 */
	public jkt.hms.masters.business.MasDepartment getStoreWardDept () {
		return storeWardDept;
	}

	/**
	 * Set the value related to the column: store_ward_dept
	 * @param storeWardDept the store_ward_dept value
	 */
	public void setStoreWardDept (jkt.hms.masters.business.MasDepartment storeWardDept) {
		this.storeWardDept = storeWardDept;
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
	 * Return the value associated with the column: approved_by
	 */
	public jkt.hms.masters.business.MasEmployee getApprovedBy () {
		return approvedBy;
	}

	/**
	 * Set the value related to the column: approved_by
	 * @param approvedBy the approved_by value
	 */
	public void setApprovedBy (jkt.hms.masters.business.MasEmployee approvedBy) {
		this.approvedBy = approvedBy;
	}



	/**
	 * Return the value associated with the column: StoreMmfDepartmentTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreMmfDepartmentT> getStoreMmfDepartmentTs () {
		return storeMmfDepartmentTs;
	}

	/**
	 * Set the value related to the column: StoreMmfDepartmentTs
	 * @param storeMmfDepartmentTs the StoreMmfDepartmentTs value
	 */
	public void setStoreMmfDepartmentTs (java.util.Set<jkt.hms.masters.business.StoreMmfDepartmentT> storeMmfDepartmentTs) {
		this.storeMmfDepartmentTs = storeMmfDepartmentTs;
	}

	public void addToStoreMmfDepartmentTs (jkt.hms.masters.business.StoreMmfDepartmentT storeMmfDepartmentT) {
		if (null == getStoreMmfDepartmentTs()) setStoreMmfDepartmentTs(new java.util.TreeSet<jkt.hms.masters.business.StoreMmfDepartmentT>());
		getStoreMmfDepartmentTs().add(storeMmfDepartmentT);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreMmfDepartmentM)) return false;
		else {
			jkt.hms.masters.business.StoreMmfDepartmentM storeMmfDepartmentM = (jkt.hms.masters.business.StoreMmfDepartmentM) obj;
			if (null == this.getId() || null == storeMmfDepartmentM.getId()) return false;
			else return (this.getId().equals(storeMmfDepartmentM.getId()));
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
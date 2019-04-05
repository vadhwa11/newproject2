package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the store_material_purchase_req_m table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="store_material_purchase_req_m"
 */

public abstract class BaseStoreMaterialPurchaseReqM  implements Serializable {

	public static String REF = "StoreMaterialPurchaseReqM";
	public static String PROP_STATUS = "Status";
	public static String PROP_MPR_NO = "MprNo";
	public static String PROP_DELIVERY_SCHEDULE = "DeliverySchedule";
	public static String PROP_FINANCIAL = "Financial";
	public static String PROP_HASH_TABLE_VALUE = "HashTableValue";
	public static String PROP_PREPARED_BY = "PreparedBy";
	public static String PROP_PROJECT = "Project";
	public static String PROP_SPECIAL_NOTES = "SpecialNotes";
	public static String PROP_HASH_TABLE_QTY = "HashTableQty";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_PREPARED_DATE = "PreparedDate";
	public static String PROP_MPR_PRIORITY = "MprPriority";
	public static String PROP_MPR_DATE = "MprDate";
	public static String PROP_PROBASE = "Probase";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ID = "Id";


	// constructors
	public BaseStoreMaterialPurchaseReqM () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStoreMaterialPurchaseReqM (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String mprNo;
	private java.util.Date mprDate;
	private java.lang.String project;
	private java.math.BigDecimal hashTableValue;
	private java.math.BigDecimal hashTableQty;
	private java.util.Date preparedDate;
	private java.lang.String status;
	private java.lang.String specialNotes;
	private java.lang.String deliverySchedule;

	// many to one
	private jkt.hms.masters.business.Users preparedBy;
	private jkt.hms.masters.business.MasStoreFinancial financial;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasProposedMPR probase;
	private jkt.hms.masters.business.MprPriority mprPriority;
	private jkt.hms.masters.business.MasHospital hospital;



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
	 * Return the value associated with the column: mpr_no
	 */
	public java.lang.String getMprNo () {
		return mprNo;
	}

	/**
	 * Set the value related to the column: mpr_no
	 * @param mprNo the mpr_no value
	 */
	public void setMprNo (java.lang.String mprNo) {
		this.mprNo = mprNo;
	}



	/**
	 * Return the value associated with the column: mpr_date
	 */
	public java.util.Date getMprDate () {
		return mprDate;
	}

	/**
	 * Set the value related to the column: mpr_date
	 * @param mprDate the mpr_date value
	 */
	public void setMprDate (java.util.Date mprDate) {
		this.mprDate = mprDate;
	}



	/**
	 * Return the value associated with the column: project
	 */
	public java.lang.String getProject () {
		return project;
	}

	/**
	 * Set the value related to the column: project
	 * @param project the project value
	 */
	public void setProject (java.lang.String project) {
		this.project = project;
	}



	/**
	 * Return the value associated with the column: hash_table_value
	 */
	public java.math.BigDecimal getHashTableValue () {
		return hashTableValue;
	}

	/**
	 * Set the value related to the column: hash_table_value
	 * @param hashTableValue the hash_table_value value
	 */
	public void setHashTableValue (java.math.BigDecimal hashTableValue) {
		this.hashTableValue = hashTableValue;
	}



	/**
	 * Return the value associated with the column: hash_table_qty
	 */
	public java.math.BigDecimal getHashTableQty () {
		return hashTableQty;
	}

	/**
	 * Set the value related to the column: hash_table_qty
	 * @param hashTableQty the hash_table_qty value
	 */
	public void setHashTableQty (java.math.BigDecimal hashTableQty) {
		this.hashTableQty = hashTableQty;
	}



	/**
	 * Return the value associated with the column: prepared_date
	 */
	public java.util.Date getPreparedDate () {
		return preparedDate;
	}

	/**
	 * Set the value related to the column: prepared_date
	 * @param preparedDate the prepared_date value
	 */
	public void setPreparedDate (java.util.Date preparedDate) {
		this.preparedDate = preparedDate;
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
	 * Return the value associated with the column: special_notes
	 */
	public java.lang.String getSpecialNotes () {
		return specialNotes;
	}

	/**
	 * Set the value related to the column: special_notes
	 * @param specialNotes the special_notes value
	 */
	public void setSpecialNotes (java.lang.String specialNotes) {
		this.specialNotes = specialNotes;
	}



	/**
	 * Return the value associated with the column: delivery_schedule
	 */
	public java.lang.String getDeliverySchedule () {
		return deliverySchedule;
	}

	/**
	 * Set the value related to the column: delivery_schedule
	 * @param deliverySchedule the delivery_schedule value
	 */
	public void setDeliverySchedule (java.lang.String deliverySchedule) {
		this.deliverySchedule = deliverySchedule;
	}



	/**
	 * Return the value associated with the column: prepared_by
	 */
	public jkt.hms.masters.business.Users getPreparedBy () {
		return preparedBy;
	}

	/**
	 * Set the value related to the column: prepared_by
	 * @param preparedBy the prepared_by value
	 */
	public void setPreparedBy (jkt.hms.masters.business.Users preparedBy) {
		this.preparedBy = preparedBy;
	}



	/**
	 * Return the value associated with the column: financial_id
	 */
	public jkt.hms.masters.business.MasStoreFinancial getFinancial () {
		return financial;
	}

	/**
	 * Set the value related to the column: financial_id
	 * @param financial the financial_id value
	 */
	public void setFinancial (jkt.hms.masters.business.MasStoreFinancial financial) {
		this.financial = financial;
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
	 * Return the value associated with the column: probase_id
	 */
	public jkt.hms.masters.business.MasProposedMPR getProbase () {
		return probase;
	}

	/**
	 * Set the value related to the column: probase_id
	 * @param probase the probase_id value
	 */
	public void setProbase (jkt.hms.masters.business.MasProposedMPR probase) {
		this.probase = probase;
	}



	/**
	 * Return the value associated with the column: mpr_priority_id
	 */
	public jkt.hms.masters.business.MprPriority getMprPriority () {
		return mprPriority;
	}

	/**
	 * Set the value related to the column: mpr_priority_id
	 * @param mprPriority the mpr_priority_id value
	 */
	public void setMprPriority (jkt.hms.masters.business.MprPriority mprPriority) {
		this.mprPriority = mprPriority;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.StoreMaterialPurchaseReqM)) return false;
		else {
			jkt.hms.masters.business.StoreMaterialPurchaseReqM storeMaterialPurchaseReqM = (jkt.hms.masters.business.StoreMaterialPurchaseReqM) obj;
			if (null == this.getId() || null == storeMaterialPurchaseReqM.getId()) return false;
			else return (this.getId().equals(storeMaterialPurchaseReqM.getId()));
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
package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the ml_supplyorder_header
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="ml_supplyorder_header"
 */

public abstract class BaseMlSupplyorderHeader implements Serializable {

	public static String REF = "MlSupplyorderHeader";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_DATE = "Date";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_QUOTATION_NO = "QuotationNo";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_VENDOR = "Vendor";
	public static String PROP_QUOTATION_DATE = "QuotationDate";
	public static String PROP_SUPPLY_ORDER_NO = "SupplyOrderNo";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_ID = "Id";

	// constructors
	public BaseMlSupplyorderHeader() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMlSupplyorderHeader(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date quotationDate;
	private java.lang.String quotationNo;
	private java.util.Date date;
	private java.lang.String supplyOrderNo;
	private java.lang.String remarks;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasVendor vendor;

	// collections
	private java.util.Set<jkt.hms.masters.business.MlSupplyorderDetail> mlSupplyorderDetails;
	private java.util.Set<jkt.hms.masters.business.LibCrvHd> libCrvHds;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="supply_header_id"
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
	 * Return the value associated with the column: quotation_date
	 */
	public java.util.Date getQuotationDate() {
		return quotationDate;
	}

	/**
	 * Set the value related to the column: quotation_date
	 * 
	 * @param quotationDate
	 *            the quotation_date value
	 */
	public void setQuotationDate(java.util.Date quotationDate) {
		this.quotationDate = quotationDate;
	}

	/**
	 * Return the value associated with the column: quotation_no
	 */
	public java.lang.String getQuotationNo() {
		return quotationNo;
	}

	/**
	 * Set the value related to the column: quotation_no
	 * 
	 * @param quotationNo
	 *            the quotation_no value
	 */
	public void setQuotationNo(java.lang.String quotationNo) {
		this.quotationNo = quotationNo;
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
	 * Return the value associated with the column: supply_order_no
	 */
	public java.lang.String getSupplyOrderNo() {
		return supplyOrderNo;
	}

	/**
	 * Set the value related to the column: supply_order_no
	 * 
	 * @param supplyOrderNo
	 *            the supply_order_no value
	 */
	public void setSupplyOrderNo(java.lang.String supplyOrderNo) {
		this.supplyOrderNo = supplyOrderNo;
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
	 * Return the value associated with the column: vendor_id
	 */
	public jkt.hms.masters.business.MasVendor getVendor() {
		return vendor;
	}

	/**
	 * Set the value related to the column: vendor_id
	 * 
	 * @param vendor
	 *            the vendor_id value
	 */
	public void setVendor(jkt.hms.masters.business.MasVendor vendor) {
		this.vendor = vendor;
	}

	/**
	 * Return the value associated with the column: MlSupplyorderDetails
	 */
	public java.util.Set<jkt.hms.masters.business.MlSupplyorderDetail> getMlSupplyorderDetails() {
		return mlSupplyorderDetails;
	}

	/**
	 * Set the value related to the column: MlSupplyorderDetails
	 * 
	 * @param mlSupplyorderDetails
	 *            the MlSupplyorderDetails value
	 */
	public void setMlSupplyorderDetails(
			java.util.Set<jkt.hms.masters.business.MlSupplyorderDetail> mlSupplyorderDetails) {
		this.mlSupplyorderDetails = mlSupplyorderDetails;
	}

	public void addToMlSupplyorderDetails(
			jkt.hms.masters.business.MlSupplyorderDetail mlSupplyorderDetail) {
		if (null == getMlSupplyorderDetails())
			setMlSupplyorderDetails(new java.util.TreeSet<jkt.hms.masters.business.MlSupplyorderDetail>());
		getMlSupplyorderDetails().add(mlSupplyorderDetail);
	}

	/**
	 * Return the value associated with the column: LibCrvHds
	 */
	public java.util.Set<jkt.hms.masters.business.LibCrvHd> getLibCrvHds() {
		return libCrvHds;
	}

	/**
	 * Set the value related to the column: LibCrvHds
	 * 
	 * @param libCrvHds
	 *            the LibCrvHds value
	 */
	public void setLibCrvHds(
			java.util.Set<jkt.hms.masters.business.LibCrvHd> libCrvHds) {
		this.libCrvHds = libCrvHds;
	}

	public void addToLibCrvHds(jkt.hms.masters.business.LibCrvHd libCrvHd) {
		if (null == getLibCrvHds())
			setLibCrvHds(new java.util.TreeSet<jkt.hms.masters.business.LibCrvHd>());
		getLibCrvHds().add(libCrvHd);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MlSupplyorderHeader))
			return false;
		else {
			jkt.hms.masters.business.MlSupplyorderHeader mlSupplyorderHeader = (jkt.hms.masters.business.MlSupplyorderHeader) obj;
			if (null == this.getId() || null == mlSupplyorderHeader.getId())
				return false;
			else
				return (this.getId().equals(mlSupplyorderHeader.getId()));
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
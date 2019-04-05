package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the lib_crv_hd table. Do not
 * modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * 
 * @hibernate.class table="lib_crv_hd"
 */

public abstract class BaseLibCrvHd implements Serializable {

	public static String REF = "LibCrvHd";
	public static String PROP_STATUS = "Status";
	public static String PROP_CRV_DATE = "CrvDate";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_BILL_AMOUNT = "BillAmount";
	public static String PROP_BILL_DATE = "BillDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_SUPPLY_HEADER = "SupplyHeader";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_CRV_NO = "CrvNo";
	public static String PROP_VENDOR = "Vendor";
	public static String PROP_BILL_NO = "BillNo";
	public static String PROP_ACCESSION_NO = "AccessionNo";
	public static String PROP_SOURCE_OF_RECEIPT = "SourceOfReceipt";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_TOTAL_AMOUNT = "TotalAmount";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_ID = "Id";

	// constructors
	public BaseLibCrvHd() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseLibCrvHd(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String crvNo;
	private java.util.Date crvDate;
	private java.lang.String sourceOfReceipt;
	private java.lang.String accessionNo;
	private java.lang.String billNo;
	private java.util.Date billDate;
	private java.math.BigDecimal billAmount;
	private java.math.BigDecimal totalAmount;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MlSupplyorderHeader supplyHeader;
	private jkt.hms.masters.business.MasVendor vendor;

	// collections
	private java.util.Set<jkt.hms.masters.business.LibCrvDt> libCrvDts;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="crv_hd_id"
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
	 * Return the value associated with the column: crv_no
	 */
	public java.lang.String getCrvNo() {
		return crvNo;
	}

	/**
	 * Set the value related to the column: crv_no
	 * 
	 * @param crvNo
	 *            the crv_no value
	 */
	public void setCrvNo(java.lang.String crvNo) {
		this.crvNo = crvNo;
	}

	/**
	 * Return the value associated with the column: crv_date
	 */
	public java.util.Date getCrvDate() {
		return crvDate;
	}

	/**
	 * Set the value related to the column: crv_date
	 * 
	 * @param crvDate
	 *            the crv_date value
	 */
	public void setCrvDate(java.util.Date crvDate) {
		this.crvDate = crvDate;
	}

	/**
	 * Return the value associated with the column: source_of_receipt
	 */
	public java.lang.String getSourceOfReceipt() {
		return sourceOfReceipt;
	}

	/**
	 * Set the value related to the column: source_of_receipt
	 * 
	 * @param sourceOfReceipt
	 *            the source_of_receipt value
	 */
	public void setSourceOfReceipt(java.lang.String sourceOfReceipt) {
		this.sourceOfReceipt = sourceOfReceipt;
	}

	/**
	 * Return the value associated with the column: accession_no
	 */
	public java.lang.String getAccessionNo() {
		return accessionNo;
	}

	/**
	 * Set the value related to the column: accession_no
	 * 
	 * @param accessionNo
	 *            the accession_no value
	 */
	public void setAccessionNo(java.lang.String accessionNo) {
		this.accessionNo = accessionNo;
	}

	/**
	 * Return the value associated with the column: bill_no
	 */
	public java.lang.String getBillNo() {
		return billNo;
	}

	/**
	 * Set the value related to the column: bill_no
	 * 
	 * @param billNo
	 *            the bill_no value
	 */
	public void setBillNo(java.lang.String billNo) {
		this.billNo = billNo;
	}

	/**
	 * Return the value associated with the column: bill_date
	 */
	public java.util.Date getBillDate() {
		return billDate;
	}

	/**
	 * Set the value related to the column: bill_date
	 * 
	 * @param billDate
	 *            the bill_date value
	 */
	public void setBillDate(java.util.Date billDate) {
		this.billDate = billDate;
	}

	/**
	 * Return the value associated with the column: bill_amount
	 */
	public java.math.BigDecimal getBillAmount() {
		return billAmount;
	}

	/**
	 * Set the value related to the column: bill_amount
	 * 
	 * @param billAmount
	 *            the bill_amount value
	 */
	public void setBillAmount(java.math.BigDecimal billAmount) {
		this.billAmount = billAmount;
	}

	/**
	 * Return the value associated with the column: total_amount
	 */
	public java.math.BigDecimal getTotalAmount() {
		return totalAmount;
	}

	/**
	 * Set the value related to the column: total_amount
	 * 
	 * @param totalAmount
	 *            the total_amount value
	 */
	public void setTotalAmount(java.math.BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
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
	 * Return the value associated with the column: supply_header_id
	 */
	public jkt.hms.masters.business.MlSupplyorderHeader getSupplyHeader() {
		return supplyHeader;
	}

	/**
	 * Set the value related to the column: supply_header_id
	 * 
	 * @param supplyHeader
	 *            the supply_header_id value
	 */
	public void setSupplyHeader(
			jkt.hms.masters.business.MlSupplyorderHeader supplyHeader) {
		this.supplyHeader = supplyHeader;
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
	 * Return the value associated with the column: LibCrvDts
	 */
	public java.util.Set<jkt.hms.masters.business.LibCrvDt> getLibCrvDts() {
		return libCrvDts;
	}

	/**
	 * Set the value related to the column: LibCrvDts
	 * 
	 * @param libCrvDts
	 *            the LibCrvDts value
	 */
	public void setLibCrvDts(
			java.util.Set<jkt.hms.masters.business.LibCrvDt> libCrvDts) {
		this.libCrvDts = libCrvDts;
	}

	public void addToLibCrvDts(jkt.hms.masters.business.LibCrvDt libCrvDt) {
		if (null == getLibCrvDts())
			setLibCrvDts(new java.util.TreeSet<jkt.hms.masters.business.LibCrvDt>());
		getLibCrvDts().add(libCrvDt);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.LibCrvHd))
			return false;
		else {
			jkt.hms.masters.business.LibCrvHd libCrvHd = (jkt.hms.masters.business.LibCrvHd) obj;
			if (null == this.getId() || null == libCrvHd.getId())
				return false;
			else
				return (this.getId().equals(libCrvHd.getId()));
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
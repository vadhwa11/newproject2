package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the md_bill_movement table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="md_bill_movement"
 */

public abstract class BaseMdBillMovement implements Serializable {

	public static String REF = "MdBillMovement";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_DOCUMNET_NO = "DocumnetNo";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_CONTINGENT_HD = "ContingentHd";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_HIN = "Hin";
	public static String PROP_BILL_STATUS = "BillStatus";
	public static String PROP_CONTINGENT_DT = "ContingentDt";
	public static String PROP_FWT_DATE = "FwtDate";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_FWT_TO = "FwtTo";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_ID = "Id";

	// constructors
	public BaseMdBillMovement() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMdBillMovement(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date fwtDate;
	private java.lang.String documnetNo;
	private java.lang.String billStatus;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MdCardicContingentBillHd contingentHd;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MdMasAuthority fwtTo;
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.MdCardicContingentBillDt contingentDt;

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
	 * Return the value associated with the column: fwt_date
	 */
	public java.util.Date getFwtDate() {
		return fwtDate;
	}

	/**
	 * Set the value related to the column: fwt_date
	 * 
	 * @param fwtDate
	 *            the fwt_date value
	 */
	public void setFwtDate(java.util.Date fwtDate) {
		this.fwtDate = fwtDate;
	}

	/**
	 * Return the value associated with the column: documnet_no
	 */
	public java.lang.String getDocumnetNo() {
		return documnetNo;
	}

	/**
	 * Set the value related to the column: documnet_no
	 * 
	 * @param documnetNo
	 *            the documnet_no value
	 */
	public void setDocumnetNo(java.lang.String documnetNo) {
		this.documnetNo = documnetNo;
	}

	/**
	 * Return the value associated with the column: bill_status
	 */
	public java.lang.String getBillStatus() {
		return billStatus;
	}

	/**
	 * Set the value related to the column: bill_status
	 * 
	 * @param billStatus
	 *            the bill_status value
	 */
	public void setBillStatus(java.lang.String billStatus) {
		this.billStatus = billStatus;
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
	 * Return the value associated with the column: contingent_hd_id
	 */
	public jkt.hms.masters.business.MdCardicContingentBillHd getContingentHd() {
		return contingentHd;
	}

	/**
	 * Set the value related to the column: contingent_hd_id
	 * 
	 * @param contingentHd
	 *            the contingent_hd_id value
	 */
	public void setContingentHd(
			jkt.hms.masters.business.MdCardicContingentBillHd contingentHd) {
		this.contingentHd = contingentHd;
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
	 * Return the value associated with the column: fwt_to
	 */
	public jkt.hms.masters.business.MdMasAuthority getFwtTo() {
		return fwtTo;
	}

	/**
	 * Set the value related to the column: fwt_to
	 * 
	 * @param fwtTo
	 *            the fwt_to value
	 */
	public void setFwtTo(jkt.hms.masters.business.MdMasAuthority fwtTo) {
		this.fwtTo = fwtTo;
	}

	/**
	 * Return the value associated with the column: inpatient_id
	 */
	public jkt.hms.masters.business.Inpatient getInpatient() {
		return inpatient;
	}

	/**
	 * Set the value related to the column: inpatient_id
	 * 
	 * @param inpatient
	 *            the inpatient_id value
	 */
	public void setInpatient(jkt.hms.masters.business.Inpatient inpatient) {
		this.inpatient = inpatient;
	}

	/**
	 * Return the value associated with the column: hin_id
	 */
	public jkt.hms.masters.business.Patient getHin() {
		return hin;
	}

	/**
	 * Set the value related to the column: hin_id
	 * 
	 * @param hin
	 *            the hin_id value
	 */
	public void setHin(jkt.hms.masters.business.Patient hin) {
		this.hin = hin;
	}

	/**
	 * Return the value associated with the column: contingent_dt_id
	 */
	public jkt.hms.masters.business.MdCardicContingentBillDt getContingentDt() {
		return contingentDt;
	}

	/**
	 * Set the value related to the column: contingent_dt_id
	 * 
	 * @param contingentDt
	 *            the contingent_dt_id value
	 */
	public void setContingentDt(
			jkt.hms.masters.business.MdCardicContingentBillDt contingentDt) {
		this.contingentDt = contingentDt;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MdBillMovement))
			return false;
		else {
			jkt.hms.masters.business.MdBillMovement mdBillMovement = (jkt.hms.masters.business.MdBillMovement) obj;
			if (null == this.getId() || null == mdBillMovement.getId())
				return false;
			else
				return (this.getId().equals(mdBillMovement.getId()));
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
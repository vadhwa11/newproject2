package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the fa_emd_register table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="fa_emd_register"
 */

public abstract class BaseFaEmdRegister  implements Serializable {

	public static String REF = "FaEmdRegister";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_BANK = "Bank";
	public static String PROP_LOCATION = "Location";
	public static String PROP_ORGANIZATION = "Organization";
	public static String PROP_FROM_DATE = "FromDate";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_STATUS = "Status";
	public static String PROP_EMD_AMOUNT = "EmdAmount";
	public static String PROP_TO_DATE = "ToDate";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_DATE = "Date";
	public static String PROP_SO_NO = "SoNo";
	public static String PROP_ID = "Id";
	public static String PROP_VOUCHER_TYPE = "VoucherType";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_TENDER_NO = "TenderNo";


	// constructors
	public BaseFaEmdRegister () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFaEmdRegister (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String tenderNo;
	private java.util.Date date;
	private java.lang.String soNo;
	private java.lang.String organization;
	private java.math.BigDecimal emdAmount;
	private java.util.Date fromDate;
	private java.util.Date toDate;
	private java.lang.String status;
	private java.lang.String remarks;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String voucherType;

	// many to one
	private jkt.hms.masters.business.MasBankMaster bank;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasHospital location;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="emd_register_id"
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
	 * Return the value associated with the column: tender_no
	 */
	public java.lang.String getTenderNo () {
		return tenderNo;
	}

	/**
	 * Set the value related to the column: tender_no
	 * @param tenderNo the tender_no value
	 */
	public void setTenderNo (java.lang.String tenderNo) {
		this.tenderNo = tenderNo;
	}



	/**
	 * Return the value associated with the column: date
	 */
	public java.util.Date getDate () {
		return date;
	}

	/**
	 * Set the value related to the column: date
	 * @param date the date value
	 */
	public void setDate (java.util.Date date) {
		this.date = date;
	}



	/**
	 * Return the value associated with the column: so_no
	 */
	public java.lang.String getSoNo () {
		return soNo;
	}

	/**
	 * Set the value related to the column: so_no
	 * @param soNo the so_no value
	 */
	public void setSoNo (java.lang.String soNo) {
		this.soNo = soNo;
	}



	/**
	 * Return the value associated with the column: organization
	 */
	public java.lang.String getOrganization () {
		return organization;
	}

	/**
	 * Set the value related to the column: organization
	 * @param organization the organization value
	 */
	public void setOrganization (java.lang.String organization) {
		this.organization = organization;
	}



	/**
	 * Return the value associated with the column: emd_amount
	 */
	public java.math.BigDecimal getEmdAmount () {
		return emdAmount;
	}

	/**
	 * Set the value related to the column: emd_amount
	 * @param emdAmount the emd_amount value
	 */
	public void setEmdAmount (java.math.BigDecimal emdAmount) {
		this.emdAmount = emdAmount;
	}



	/**
	 * Return the value associated with the column: from_date
	 */
	public java.util.Date getFromDate () {
		return fromDate;
	}

	/**
	 * Set the value related to the column: from_date
	 * @param fromDate the from_date value
	 */
	public void setFromDate (java.util.Date fromDate) {
		this.fromDate = fromDate;
	}



	/**
	 * Return the value associated with the column: to_date
	 */
	public java.util.Date getToDate () {
		return toDate;
	}

	/**
	 * Set the value related to the column: to_date
	 * @param toDate the to_date value
	 */
	public void setToDate (java.util.Date toDate) {
		this.toDate = toDate;
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
	 * Return the value associated with the column: voucher_type
	 */
	public java.lang.String getVoucherType () {
		return voucherType;
	}

	/**
	 * Set the value related to the column: voucher_type
	 * @param voucherType the voucher_type value
	 */
	public void setVoucherType (java.lang.String voucherType) {
		this.voucherType = voucherType;
	}



	/**
	 * Return the value associated with the column: bank_id
	 */
	public jkt.hms.masters.business.MasBankMaster getBank () {
		return bank;
	}

	/**
	 * Set the value related to the column: bank_id
	 * @param bank the bank_id value
	 */
	public void setBank (jkt.hms.masters.business.MasBankMaster bank) {
		this.bank = bank;
	}



	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public jkt.hms.masters.business.Users getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (jkt.hms.masters.business.Users lastChgBy) {
		this.lastChgBy = lastChgBy;
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
	 * Return the value associated with the column: location_id
	 */
	public jkt.hms.masters.business.MasHospital getLocation () {
		return location;
	}

	/**
	 * Set the value related to the column: location_id
	 * @param location the location_id value
	 */
	public void setLocation (jkt.hms.masters.business.MasHospital location) {
		this.location = location;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.FaEmdRegister)) return false;
		else {
			jkt.hms.masters.business.FaEmdRegister faEmdRegister = (jkt.hms.masters.business.FaEmdRegister) obj;
			if (null == this.getId() || null == faEmdRegister.getId()) return false;
			else return (this.getId().equals(faEmdRegister.getId()));
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
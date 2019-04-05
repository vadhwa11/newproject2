package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the
 * mas_allotment_of_funds_for_minor_works table. Do not modify this class
 * because it will be overwritten if the configuration file related to this
 * class is modified.
 * 
 * @hibernate.class table="mas_allotment_of_funds_for_minor_works"
 */

public abstract class BaseMasAllotmentOfFundsForMinorWorks implements
		Serializable {

	public static String REF = "MasAllotmentOfFundsForMinorWorks";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHANGED_TIME = "LastChangedTime";
	public static String PROP_ALLOTMENT_FILE_NO = "AllotmentFileNo";
	public static String PROP_FINANCIAL_YEAR = "FinancialYear";
	public static String PROP_LAST_CHANGED_DATE = "LastChangedDate";
	public static String PROP_ALLOTMENT_FILE_DATE = "AllotmentFileDate";
	public static String PROP_ALLOTMENT_FILE_AMOUNT = "AllotmentFileAmount";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHANGED_BY = "LastChangedBy";
	public static String PROP_REMARKS = "Remarks";

	// constructors
	public BaseMasAllotmentOfFundsForMinorWorks() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasAllotmentOfFundsForMinorWorks(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String financialYear;
	private java.lang.String allotmentFileNo;
	private java.util.Date allotmentFileDate;
	private java.math.BigDecimal allotmentFileAmount;
	private java.lang.String remarks;
	private java.lang.String status;
	private java.lang.String lastChangedBy;
	private java.util.Date lastChangedDate;
	private java.lang.String lastChangedTime;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="allotment_id"
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
	 * Return the value associated with the column: financial_year
	 */
	public java.lang.String getFinancialYear() {
		return financialYear;
	}

	/**
	 * Set the value related to the column: financial_year
	 * 
	 * @param financialYear
	 *            the financial_year value
	 */
	public void setFinancialYear(java.lang.String financialYear) {
		this.financialYear = financialYear;
	}

	/**
	 * Return the value associated with the column: allotment_file_no
	 */
	public java.lang.String getAllotmentFileNo() {
		return allotmentFileNo;
	}

	/**
	 * Set the value related to the column: allotment_file_no
	 * 
	 * @param allotmentFileNo
	 *            the allotment_file_no value
	 */
	public void setAllotmentFileNo(java.lang.String allotmentFileNo) {
		this.allotmentFileNo = allotmentFileNo;
	}

	/**
	 * Return the value associated with the column: allotment_file_date
	 */
	public java.util.Date getAllotmentFileDate() {
		return allotmentFileDate;
	}

	/**
	 * Set the value related to the column: allotment_file_date
	 * 
	 * @param allotmentFileDate
	 *            the allotment_file_date value
	 */
	public void setAllotmentFileDate(java.util.Date allotmentFileDate) {
		this.allotmentFileDate = allotmentFileDate;
	}

	/**
	 * Return the value associated with the column: allotment_file_amount
	 */
	public java.math.BigDecimal getAllotmentFileAmount() {
		return allotmentFileAmount;
	}

	/**
	 * Set the value related to the column: allotment_file_amount
	 * 
	 * @param allotmentFileAmount
	 *            the allotment_file_amount value
	 */
	public void setAllotmentFileAmount(java.math.BigDecimal allotmentFileAmount) {
		this.allotmentFileAmount = allotmentFileAmount;
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
	 * Return the value associated with the column: last_changed_by
	 */
	public java.lang.String getLastChangedBy() {
		return lastChangedBy;
	}

	/**
	 * Set the value related to the column: last_changed_by
	 * 
	 * @param lastChangedBy
	 *            the last_changed_by value
	 */
	public void setLastChangedBy(java.lang.String lastChangedBy) {
		this.lastChangedBy = lastChangedBy;
	}

	/**
	 * Return the value associated with the column: last_changed_date
	 */
	public java.util.Date getLastChangedDate() {
		return lastChangedDate;
	}

	/**
	 * Set the value related to the column: last_changed_date
	 * 
	 * @param lastChangedDate
	 *            the last_changed_date value
	 */
	public void setLastChangedDate(java.util.Date lastChangedDate) {
		this.lastChangedDate = lastChangedDate;
	}

	/**
	 * Return the value associated with the column: last_changed_time
	 */
	public java.lang.String getLastChangedTime() {
		return lastChangedTime;
	}

	/**
	 * Set the value related to the column: last_changed_time
	 * 
	 * @param lastChangedTime
	 *            the last_changed_time value
	 */
	public void setLastChangedTime(java.lang.String lastChangedTime) {
		this.lastChangedTime = lastChangedTime;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MasAllotmentOfFundsForMinorWorks))
			return false;
		else {
			jkt.hms.masters.business.MasAllotmentOfFundsForMinorWorks masAllotmentOfFundsForMinorWorks = (jkt.hms.masters.business.MasAllotmentOfFundsForMinorWorks) obj;
			if (null == this.getId()
					|| null == masAllotmentOfFundsForMinorWorks.getId())
				return false;
			else
				return (this.getId().equals(masAllotmentOfFundsForMinorWorks
						.getId()));
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
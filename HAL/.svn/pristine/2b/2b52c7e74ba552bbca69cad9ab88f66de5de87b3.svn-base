package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_mas_itax_exemption table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_mas_itax_exemption"
 */

public abstract class BaseHrMasItaxExemption  implements Serializable {

	public static String REF = "HrMasItaxExemption";
	public static String PROP_STATUS = "Status";
	public static String PROP_MINIMUM_AMT = "MinimumAmt";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_MAXIMUM_AMT = "MaximumAmt";
	public static String PROP_EXEMPTION_BASE = "ExemptionBase";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_SECTION_DESC = "SectionDesc";
	public static String PROP_FINANCIAL_YEAR = "FinancialYear";
	public static String PROP_EXEMPTION_PERCENTAGE = "ExemptionPercentage";
	public static String PROP_SECTION_CODE = "SectionCode";
	public static String PROP_ID = "Id";
	public static String PROP_MAX_EXEMPTION = "MaxExemption";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";


	// constructors
	public BaseHrMasItaxExemption () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrMasItaxExemption (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String sectionCode;
	private java.math.BigDecimal maximumAmt;
	private java.math.BigDecimal exemptionPercentage;
	private java.lang.String exemptionBase;
	private java.math.BigDecimal minimumAmt;
	private java.math.BigDecimal maxExemption;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;
	private java.lang.String sectionDesc;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasStoreFinancial financialYear;



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
	 * Return the value associated with the column: section_code
	 */
	public java.lang.String getSectionCode () {
		return sectionCode;
	}

	/**
	 * Set the value related to the column: section_code
	 * @param sectionCode the section_code value
	 */
	public void setSectionCode (java.lang.String sectionCode) {
		this.sectionCode = sectionCode;
	}



	/**
	 * Return the value associated with the column: maximum_amt
	 */
	public java.math.BigDecimal getMaximumAmt () {
		return maximumAmt;
	}

	/**
	 * Set the value related to the column: maximum_amt
	 * @param maximumAmt the maximum_amt value
	 */
	public void setMaximumAmt (java.math.BigDecimal maximumAmt) {
		this.maximumAmt = maximumAmt;
	}



	/**
	 * Return the value associated with the column: exemption_percentage
	 */
	public java.math.BigDecimal getExemptionPercentage () {
		return exemptionPercentage;
	}

	/**
	 * Set the value related to the column: exemption_percentage
	 * @param exemptionPercentage the exemption_percentage value
	 */
	public void setExemptionPercentage (java.math.BigDecimal exemptionPercentage) {
		this.exemptionPercentage = exemptionPercentage;
	}



	/**
	 * Return the value associated with the column: exemption_base
	 */
	public java.lang.String getExemptionBase () {
		return exemptionBase;
	}

	/**
	 * Set the value related to the column: exemption_base
	 * @param exemptionBase the exemption_base value
	 */
	public void setExemptionBase (java.lang.String exemptionBase) {
		this.exemptionBase = exemptionBase;
	}



	/**
	 * Return the value associated with the column: minimum_amt
	 */
	public java.math.BigDecimal getMinimumAmt () {
		return minimumAmt;
	}

	/**
	 * Set the value related to the column: minimum_amt
	 * @param minimumAmt the minimum_amt value
	 */
	public void setMinimumAmt (java.math.BigDecimal minimumAmt) {
		this.minimumAmt = minimumAmt;
	}



	/**
	 * Return the value associated with the column: max_exemption
	 */
	public java.math.BigDecimal getMaxExemption () {
		return maxExemption;
	}

	/**
	 * Set the value related to the column: max_exemption
	 * @param maxExemption the max_exemption value
	 */
	public void setMaxExemption (java.math.BigDecimal maxExemption) {
		this.maxExemption = maxExemption;
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
	 * Return the value associated with the column: section_desc
	 */
	public java.lang.String getSectionDesc () {
		return sectionDesc;
	}

	/**
	 * Set the value related to the column: section_desc
	 * @param sectionDesc the section_desc value
	 */
	public void setSectionDesc (java.lang.String sectionDesc) {
		this.sectionDesc = sectionDesc;
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
	 * Return the value associated with the column: financial_year
	 */
	public jkt.hms.masters.business.MasStoreFinancial getFinancialYear () {
		return financialYear;
	}

	/**
	 * Set the value related to the column: financial_year
	 * @param financialYear the financial_year value
	 */
	public void setFinancialYear (jkt.hms.masters.business.MasStoreFinancial financialYear) {
		this.financialYear = financialYear;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.HrMasItaxExemption)) return false;
		else {
			jkt.hms.masters.business.HrMasItaxExemption hrMasItaxExemption = (jkt.hms.masters.business.HrMasItaxExemption) obj;
			if (null == this.getId() || null == hrMasItaxExemption.getId()) return false;
			else return (this.getId().equals(hrMasItaxExemption.getId()));
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
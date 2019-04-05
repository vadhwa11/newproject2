package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the hr_mas_reimbersement table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="hr_mas_reimbersement"
 */

public abstract class BaseHrMasReimbersement  implements Serializable {

	public static String REF = "HrMasReimbersement";
	public static String PROP_STATUS = "Status";
	public static String PROP_REIMB_DESC = "ReimbDesc";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_REIMB_CODE = "ReimbCode";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_TAXABLE = "Taxable";
	public static String PROP_CARRY_FORWARD = "CarryForward";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_MAX_AMOUNT = "MaxAmount";
	public static String PROP_MAX_TAX_EXEMPTION = "MaxTaxExemption";


	// constructors
	public BaseHrMasReimbersement () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseHrMasReimbersement (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String reimbCode;
	private java.lang.String reimbDesc;
	private java.math.BigDecimal maxAmount;
	private java.lang.String taxable;
	private java.math.BigDecimal maxTaxExemption;
	private java.lang.String carryForward;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="reimb_id"
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
	 * Return the value associated with the column: reimb_code
	 */
	public java.lang.String getReimbCode () {
		return reimbCode;
	}

	/**
	 * Set the value related to the column: reimb_code
	 * @param reimbCode the reimb_code value
	 */
	public void setReimbCode (java.lang.String reimbCode) {
		this.reimbCode = reimbCode;
	}



	/**
	 * Return the value associated with the column: reimb_desc
	 */
	public java.lang.String getReimbDesc () {
		return reimbDesc;
	}

	/**
	 * Set the value related to the column: reimb_desc
	 * @param reimbDesc the reimb_desc value
	 */
	public void setReimbDesc (java.lang.String reimbDesc) {
		this.reimbDesc = reimbDesc;
	}



	/**
	 * Return the value associated with the column: max_amount
	 */
	public java.math.BigDecimal getMaxAmount () {
		return maxAmount;
	}

	/**
	 * Set the value related to the column: max_amount
	 * @param maxAmount the max_amount value
	 */
	public void setMaxAmount (java.math.BigDecimal maxAmount) {
		this.maxAmount = maxAmount;
	}



	/**
	 * Return the value associated with the column: taxable
	 */
	public java.lang.String getTaxable () {
		return taxable;
	}

	/**
	 * Set the value related to the column: taxable
	 * @param taxable the taxable value
	 */
	public void setTaxable (java.lang.String taxable) {
		this.taxable = taxable;
	}



	/**
	 * Return the value associated with the column: max_tax_exemption
	 */
	public java.math.BigDecimal getMaxTaxExemption () {
		return maxTaxExemption;
	}

	/**
	 * Set the value related to the column: max_tax_exemption
	 * @param maxTaxExemption the max_tax_exemption value
	 */
	public void setMaxTaxExemption (java.math.BigDecimal maxTaxExemption) {
		this.maxTaxExemption = maxTaxExemption;
	}



	/**
	 * Return the value associated with the column: carry_forward
	 */
	public java.lang.String getCarryForward () {
		return carryForward;
	}

	/**
	 * Set the value related to the column: carry_forward
	 * @param carryForward the carry_forward value
	 */
	public void setCarryForward (java.lang.String carryForward) {
		this.carryForward = carryForward;
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
		if (!(obj instanceof jkt.hms.masters.business.HrMasReimbersement)) return false;
		else {
			jkt.hms.masters.business.HrMasReimbersement hrMasReimbersement = (jkt.hms.masters.business.HrMasReimbersement) obj;
			if (null == this.getId() || null == hrMasReimbersement.getId()) return false;
			else return (this.getId().equals(hrMasReimbersement.getId()));
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
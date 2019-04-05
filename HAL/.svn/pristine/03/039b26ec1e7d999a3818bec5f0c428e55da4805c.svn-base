package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_icd table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_icd"
 */

public abstract class BaseMasIcd  implements Serializable {

	public static String REF = "MasIcd";
	public static String PROP_ICD_SUB_CATEGORY = "IcdSubCategory";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ICD_CAUSE = "IcdCause";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ICD_CODE = "IcdCode";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ICD_NAME = "IcdName";


	// constructors
	public BaseMasIcd () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasIcd (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String icdCode;
	private java.lang.String icdName;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasIcdcausegrp icdCause;
	private jkt.hms.masters.business.MasIcdSubCategory icdSubCategory;

	// collections
	private java.util.Set<jkt.hms.masters.business.DischargeIcdCode> dischargeIcdCodes;
	private java.util.Set<jkt.hms.masters.business.MisNotifiable> misNotifiables;
	private java.util.Set<jkt.hms.masters.business.Inpatient> inpatients;
	private java.util.Set<jkt.hms.masters.business.SilDilStatus> silDilStatus;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="icd_id"
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
	 * Return the value associated with the column: icd_code
	 */
	public java.lang.String getIcdCode () {
		return icdCode;
	}

	/**
	 * Set the value related to the column: icd_code
	 * @param icdCode the icd_code value
	 */
	public void setIcdCode (java.lang.String icdCode) {
		this.icdCode = icdCode;
	}



	/**
	 * Return the value associated with the column: icd_name
	 */
	public java.lang.String getIcdName () {
		return icdName;
	}

	/**
	 * Set the value related to the column: icd_name
	 * @param icdName the icd_name value
	 */
	public void setIcdName (java.lang.String icdName) {
		this.icdName = icdName;
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
	 * Return the value associated with the column: icd_cause_id
	 */
	public jkt.hms.masters.business.MasIcdcausegrp getIcdCause () {
		return icdCause;
	}

	/**
	 * Set the value related to the column: icd_cause_id
	 * @param icdCause the icd_cause_id value
	 */
	public void setIcdCause (jkt.hms.masters.business.MasIcdcausegrp icdCause) {
		this.icdCause = icdCause;
	}



	/**
	 * Return the value associated with the column: icd_sub_category_id
	 */
	public jkt.hms.masters.business.MasIcdSubCategory getIcdSubCategory () {
		return icdSubCategory;
	}

	/**
	 * Set the value related to the column: icd_sub_category_id
	 * @param icdSubCategory the icd_sub_category_id value
	 */
	public void setIcdSubCategory (jkt.hms.masters.business.MasIcdSubCategory icdSubCategory) {
		this.icdSubCategory = icdSubCategory;
	}



	/**
	 * Return the value associated with the column: DischargeIcdCodes
	 */
	public java.util.Set<jkt.hms.masters.business.DischargeIcdCode> getDischargeIcdCodes () {
		return dischargeIcdCodes;
	}

	/**
	 * Set the value related to the column: DischargeIcdCodes
	 * @param dischargeIcdCodes the DischargeIcdCodes value
	 */
	public void setDischargeIcdCodes (java.util.Set<jkt.hms.masters.business.DischargeIcdCode> dischargeIcdCodes) {
		this.dischargeIcdCodes = dischargeIcdCodes;
	}

	public void addToDischargeIcdCodes (jkt.hms.masters.business.DischargeIcdCode dischargeIcdCode) {
		if (null == getDischargeIcdCodes()) setDischargeIcdCodes(new java.util.TreeSet<jkt.hms.masters.business.DischargeIcdCode>());
		getDischargeIcdCodes().add(dischargeIcdCode);
	}



	/**
	 * Return the value associated with the column: MisNotifiables
	 */
	public java.util.Set<jkt.hms.masters.business.MisNotifiable> getMisNotifiables () {
		return misNotifiables;
	}

	/**
	 * Set the value related to the column: MisNotifiables
	 * @param misNotifiables the MisNotifiables value
	 */
	public void setMisNotifiables (java.util.Set<jkt.hms.masters.business.MisNotifiable> misNotifiables) {
		this.misNotifiables = misNotifiables;
	}

	public void addToMisNotifiables (jkt.hms.masters.business.MisNotifiable misNotifiable) {
		if (null == getMisNotifiables()) setMisNotifiables(new java.util.TreeSet<jkt.hms.masters.business.MisNotifiable>());
		getMisNotifiables().add(misNotifiable);
	}



	/**
	 * Return the value associated with the column: Inpatients
	 */
	public java.util.Set<jkt.hms.masters.business.Inpatient> getInpatients () {
		return inpatients;
	}

	/**
	 * Set the value related to the column: Inpatients
	 * @param inpatients the Inpatients value
	 */
	public void setInpatients (java.util.Set<jkt.hms.masters.business.Inpatient> inpatients) {
		this.inpatients = inpatients;
	}

	public void addToInpatients (jkt.hms.masters.business.Inpatient inpatient) {
		if (null == getInpatients()) setInpatients(new java.util.TreeSet<jkt.hms.masters.business.Inpatient>());
		getInpatients().add(inpatient);
	}



	/**
	 * Return the value associated with the column: SilDilStatus
	 */
	public java.util.Set<jkt.hms.masters.business.SilDilStatus> getSilDilStatus () {
		return silDilStatus;
	}

	/**
	 * Set the value related to the column: SilDilStatus
	 * @param silDilStatus the SilDilStatus value
	 */
	public void setSilDilStatus (java.util.Set<jkt.hms.masters.business.SilDilStatus> silDilStatus) {
		this.silDilStatus = silDilStatus;
	}

	public void addToSilDilStatus (jkt.hms.masters.business.SilDilStatus silDilStatus) {
		if (null == getSilDilStatus()) setSilDilStatus(new java.util.TreeSet<jkt.hms.masters.business.SilDilStatus>());
		getSilDilStatus().add(silDilStatus);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasIcd)) return false;
		else {
			jkt.hms.masters.business.MasIcd masIcd = (jkt.hms.masters.business.MasIcd) obj;
			if (null == this.getId() || null == masIcd.getId()) return false;
			else return (this.getId().equals(masIcd.getId()));
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
package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the IPD_KIT_ISSUE_HEADER table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="IPD_KIT_ISSUE_HEADER"
 */

public abstract class BaseIpdKitIssueHeader  implements Serializable {

	public static String REF = "IpdKitIssueHeader";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_TEMPLATE = "Template";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_HIN = "Hin";
	public static String PROP_INPATIENT = "Inpatient";


	// constructors
	public BaseIpdKitIssueHeader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseIpdKitIssueHeader (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.KitIssueMasterTemplateM template;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasHospital hospital;

	// collections
	private java.util.Set<jkt.hms.masters.business.IpdKitIssueDetails> ipdKitIssueDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="IPD_KIT_ISSUE_HEADER_ID"
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
	 * Return the value associated with the column: LAST_CHG_DATE
	 */
	public java.util.Date getLastChgDate () {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: LAST_CHG_DATE
	 * @param lastChgDate the LAST_CHG_DATE value
	 */
	public void setLastChgDate (java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}



	/**
	 * Return the value associated with the column: LAST_CHG_TIME
	 */
	public java.lang.String getLastChgTime () {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: LAST_CHG_TIME
	 * @param lastChgTime the LAST_CHG_TIME value
	 */
	public void setLastChgTime (java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}



	/**
	 * Return the value associated with the column: inpatient_id
	 */
	public jkt.hms.masters.business.Inpatient getInpatient () {
		return inpatient;
	}

	/**
	 * Set the value related to the column: inpatient_id
	 * @param inpatient the inpatient_id value
	 */
	public void setInpatient (jkt.hms.masters.business.Inpatient inpatient) {
		this.inpatient = inpatient;
	}



	/**
	 * Return the value associated with the column: hin_id
	 */
	public jkt.hms.masters.business.Patient getHin () {
		return hin;
	}

	/**
	 * Set the value related to the column: hin_id
	 * @param hin the hin_id value
	 */
	public void setHin (jkt.hms.masters.business.Patient hin) {
		this.hin = hin;
	}



	/**
	 * Return the value associated with the column: template_id
	 */
	public jkt.hms.masters.business.KitIssueMasterTemplateM getTemplate () {
		return template;
	}

	/**
	 * Set the value related to the column: template_id
	 * @param template the template_id value
	 */
	public void setTemplate (jkt.hms.masters.business.KitIssueMasterTemplateM template) {
		this.template = template;
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



	/**
	 * Return the value associated with the column: IpdKitIssueDetails
	 */
	public java.util.Set<jkt.hms.masters.business.IpdKitIssueDetails> getIpdKitIssueDetails () {
		return ipdKitIssueDetails;
	}

	/**
	 * Set the value related to the column: IpdKitIssueDetails
	 * @param ipdKitIssueDetails the IpdKitIssueDetails value
	 */
	public void setIpdKitIssueDetails (java.util.Set<jkt.hms.masters.business.IpdKitIssueDetails> ipdKitIssueDetails) {
		this.ipdKitIssueDetails = ipdKitIssueDetails;
	}

	public void addToIpdKitIssueDetails (jkt.hms.masters.business.IpdKitIssueDetails ipdKitIssueDetails) {
		if (null == getIpdKitIssueDetails()) setIpdKitIssueDetails(new java.util.TreeSet<jkt.hms.masters.business.IpdKitIssueDetails>());
		getIpdKitIssueDetails().add(ipdKitIssueDetails);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.IpdKitIssueHeader)) return false;
		else {
			jkt.hms.masters.business.IpdKitIssueHeader ipdKitIssueHeader = (jkt.hms.masters.business.IpdKitIssueHeader) obj;
			if (null == this.getId() || null == ipdKitIssueHeader.getId()) return false;
			else return (this.getId().equals(ipdKitIssueHeader.getId()));
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
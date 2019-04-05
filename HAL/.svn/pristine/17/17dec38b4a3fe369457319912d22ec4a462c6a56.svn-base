package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the nursingcare_setup table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="nursingcare_setup"
 */

public abstract class BaseNursingcareSetup  implements Serializable {

	public static String REF = "NursingcareSetup";
	public static String PROP_AD_NO = "AdNo";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_NO_OF_DAYS = "NoOfDays";
	public static String PROP_STOP = "stop";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_NURSING = "Nursing";
	public static String PROP_DURATION = "Duration";
	public static String PROP_ID = "Id";
	public static String PROP_FREQUENCY = "Frequency";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_HIN = "Hin";


	// constructors
	public BaseNursingcareSetup () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseNursingcareSetup (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String adNo;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String remarks;
	private java.lang.String duration;
	private java.lang.Integer noOfDays;
	private java.lang.String stop;

	// many to one
	private jkt.hms.masters.business.MasFrequency frequency;
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.MasNursingCare nursing;
	private jkt.hms.masters.business.MasDepartment department;

	// collections
	private java.util.Set<jkt.hms.masters.business.Ipdcaredetail> ipdcaredetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="nursingcare_setup_id"
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
	 * Return the value associated with the column: ad_no
	 */
	public java.lang.String getAdNo () {
		return adNo;
	}

	/**
	 * Set the value related to the column: ad_no
	 * @param adNo the ad_no value
	 */
	public void setAdNo (java.lang.String adNo) {
		this.adNo = adNo;
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
	 * Return the value associated with the column: duration
	 */
	public java.lang.String getDuration () {
		return duration;
	}

	/**
	 * Set the value related to the column: duration
	 * @param duration the duration value
	 */
	public void setDuration (java.lang.String duration) {
		this.duration = duration;
	}



	/**
	 * Return the value associated with the column: no_of_days
	 */
	public java.lang.Integer getNoOfDays () {
		return noOfDays;
	}

	/**
	 * Set the value related to the column: no_of_days
	 * @param noOfDays the no_of_days value
	 */
	public void setNoOfDays (java.lang.Integer noOfDays) {
		this.noOfDays = noOfDays;
	}



	/**
	 * Return the value associated with the column: stop
	 */
	public java.lang.String getStop () {
		return stop;
	}

	/**
	 * Set the value related to the column: stop
	 * @param stop the stop value
	 */
	public void setStop (java.lang.String stop) {
		this.stop = stop;
	}



	/**
	 * Return the value associated with the column: frequency_id
	 */
	public jkt.hms.masters.business.MasFrequency getFrequency () {
		return frequency;
	}

	/**
	 * Set the value related to the column: frequency_id
	 * @param frequency the frequency_id value
	 */
	public void setFrequency (jkt.hms.masters.business.MasFrequency frequency) {
		this.frequency = frequency;
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
	 * Return the value associated with the column: nursing_id
	 */
	public jkt.hms.masters.business.MasNursingCare getNursing () {
		return nursing;
	}

	/**
	 * Set the value related to the column: nursing_id
	 * @param nursing the nursing_id value
	 */
	public void setNursing (jkt.hms.masters.business.MasNursingCare nursing) {
		this.nursing = nursing;
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
	 * Return the value associated with the column: Ipdcaredetails
	 */
	public java.util.Set<jkt.hms.masters.business.Ipdcaredetail> getIpdcaredetails () {
		return ipdcaredetails;
	}

	/**
	 * Set the value related to the column: Ipdcaredetails
	 * @param ipdcaredetails the Ipdcaredetails value
	 */
	public void setIpdcaredetails (java.util.Set<jkt.hms.masters.business.Ipdcaredetail> ipdcaredetails) {
		this.ipdcaredetails = ipdcaredetails;
	}

	public void addToIpdcaredetails (jkt.hms.masters.business.Ipdcaredetail ipdcaredetail) {
		if (null == getIpdcaredetails()) setIpdcaredetails(new java.util.TreeSet<jkt.hms.masters.business.Ipdcaredetail>());
		getIpdcaredetails().add(ipdcaredetail);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.NursingcareSetup)) return false;
		else {
			jkt.hms.masters.business.NursingcareSetup nursingcareSetup = (jkt.hms.masters.business.NursingcareSetup) obj;
			if (null == this.getId() || null == nursingcareSetup.getId()) return false;
			else return (this.getId().equals(nursingcareSetup.getId()));
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
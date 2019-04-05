package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ipdcaredetail table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ipdcaredetail"
 */

public abstract class BaseIpdcaredetail  implements Serializable {

	public static String REF = "Ipdcaredetail";
	public static String PROP_AD_NO = "AdNo";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_CARE3_TIME = "Care3Time";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_CARE6_TIME = "Care6Time";
	public static String PROP_CARE12 = "Care12";
	public static String PROP_CARE12_TIME = "Care12Time";
	public static String PROP_CARE10 = "Care10";
	public static String PROP_CARE2_TIME = "Care2Time";
	public static String PROP_CARE11 = "Care11";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_CARE8_TIME = "Care8Time";
	public static String PROP_DATE_OF_CARE = "DateOfCare";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_CARE10_TIME = "Care10Time";
	public static String PROP_CARE5_TIME = "Care5Time";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_CARE7_TIME = "Care7Time";
	public static String PROP_CARE11_TIME = "Care11Time";
	public static String PROP_NURSINGCARE_SETUP = "NursingcareSetup";
	public static String PROP_CARE9 = "Care9";
	public static String PROP_CARE9_TIME = "Care9Time";
	public static String PROP_CARE4 = "Care4";
	public static String PROP_CARE3 = "Care3";
	public static String PROP_ID = "Id";
	public static String PROP_CARE2 = "Care2";
	public static String PROP_CARE1 = "Care1";
	public static String PROP_CARE1_TIME = "Care1Time";
	public static String PROP_CARE8 = "Care8";
	public static String PROP_HIN = "Hin";
	public static String PROP_CARE7 = "Care7";
	public static String PROP_CARE6 = "Care6";
	public static String PROP_CARE5 = "Care5";
	public static String PROP_CARE4_TIME = "Care4Time";


	// constructors
	public BaseIpdcaredetail () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseIpdcaredetail (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String adNo;
	private java.util.Date dateOfCare;
	private java.lang.String care1;
	private java.lang.String care1Time;
	private java.lang.String care2;
	private java.lang.String care2Time;
	private java.lang.String care3;
	private java.lang.String care3Time;
	private java.lang.String care4;
	private java.lang.String care4Time;
	private java.lang.String care5;
	private java.lang.String care5Time;
	private java.lang.String care6;
	private java.lang.String care6Time;
	private java.lang.String care7;
	private java.lang.String care7Time;
	private java.lang.String care8;
	private java.lang.String care8Time;
	private java.lang.String care9;
	private java.lang.String care9Time;
	private java.lang.String care10;
	private java.lang.String care10Time;
	private java.lang.String care11;
	private java.lang.String care11Time;
	private java.lang.String care12;
	private java.lang.String care12Time;
	private java.lang.String remarks;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.NursingcareSetup nursingcareSetup;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="caredetail_id"
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
	 * Return the value associated with the column: date_of_care
	 */
	public java.util.Date getDateOfCare () {
		return dateOfCare;
	}

	/**
	 * Set the value related to the column: date_of_care
	 * @param dateOfCare the date_of_care value
	 */
	public void setDateOfCare (java.util.Date dateOfCare) {
		this.dateOfCare = dateOfCare;
	}



	/**
	 * Return the value associated with the column: care1
	 */
	public java.lang.String getCare1 () {
		return care1;
	}

	/**
	 * Set the value related to the column: care1
	 * @param care1 the care1 value
	 */
	public void setCare1 (java.lang.String care1) {
		this.care1 = care1;
	}



	/**
	 * Return the value associated with the column: care1_time
	 */
	public java.lang.String getCare1Time () {
		return care1Time;
	}

	/**
	 * Set the value related to the column: care1_time
	 * @param care1Time the care1_time value
	 */
	public void setCare1Time (java.lang.String care1Time) {
		this.care1Time = care1Time;
	}



	/**
	 * Return the value associated with the column: care2
	 */
	public java.lang.String getCare2 () {
		return care2;
	}

	/**
	 * Set the value related to the column: care2
	 * @param care2 the care2 value
	 */
	public void setCare2 (java.lang.String care2) {
		this.care2 = care2;
	}



	/**
	 * Return the value associated with the column: care2_time
	 */
	public java.lang.String getCare2Time () {
		return care2Time;
	}

	/**
	 * Set the value related to the column: care2_time
	 * @param care2Time the care2_time value
	 */
	public void setCare2Time (java.lang.String care2Time) {
		this.care2Time = care2Time;
	}



	/**
	 * Return the value associated with the column: care3
	 */
	public java.lang.String getCare3 () {
		return care3;
	}

	/**
	 * Set the value related to the column: care3
	 * @param care3 the care3 value
	 */
	public void setCare3 (java.lang.String care3) {
		this.care3 = care3;
	}



	/**
	 * Return the value associated with the column: care3_time
	 */
	public java.lang.String getCare3Time () {
		return care3Time;
	}

	/**
	 * Set the value related to the column: care3_time
	 * @param care3Time the care3_time value
	 */
	public void setCare3Time (java.lang.String care3Time) {
		this.care3Time = care3Time;
	}



	/**
	 * Return the value associated with the column: care4
	 */
	public java.lang.String getCare4 () {
		return care4;
	}

	/**
	 * Set the value related to the column: care4
	 * @param care4 the care4 value
	 */
	public void setCare4 (java.lang.String care4) {
		this.care4 = care4;
	}



	/**
	 * Return the value associated with the column: care4_time
	 */
	public java.lang.String getCare4Time () {
		return care4Time;
	}

	/**
	 * Set the value related to the column: care4_time
	 * @param care4Time the care4_time value
	 */
	public void setCare4Time (java.lang.String care4Time) {
		this.care4Time = care4Time;
	}



	/**
	 * Return the value associated with the column: care5
	 */
	public java.lang.String getCare5 () {
		return care5;
	}

	/**
	 * Set the value related to the column: care5
	 * @param care5 the care5 value
	 */
	public void setCare5 (java.lang.String care5) {
		this.care5 = care5;
	}



	/**
	 * Return the value associated with the column: care5_time
	 */
	public java.lang.String getCare5Time () {
		return care5Time;
	}

	/**
	 * Set the value related to the column: care5_time
	 * @param care5Time the care5_time value
	 */
	public void setCare5Time (java.lang.String care5Time) {
		this.care5Time = care5Time;
	}



	/**
	 * Return the value associated with the column: care6
	 */
	public java.lang.String getCare6 () {
		return care6;
	}

	/**
	 * Set the value related to the column: care6
	 * @param care6 the care6 value
	 */
	public void setCare6 (java.lang.String care6) {
		this.care6 = care6;
	}



	/**
	 * Return the value associated with the column: care6_time
	 */
	public java.lang.String getCare6Time () {
		return care6Time;
	}

	/**
	 * Set the value related to the column: care6_time
	 * @param care6Time the care6_time value
	 */
	public void setCare6Time (java.lang.String care6Time) {
		this.care6Time = care6Time;
	}



	/**
	 * Return the value associated with the column: care7
	 */
	public java.lang.String getCare7 () {
		return care7;
	}

	/**
	 * Set the value related to the column: care7
	 * @param care7 the care7 value
	 */
	public void setCare7 (java.lang.String care7) {
		this.care7 = care7;
	}



	/**
	 * Return the value associated with the column: care7_time
	 */
	public java.lang.String getCare7Time () {
		return care7Time;
	}

	/**
	 * Set the value related to the column: care7_time
	 * @param care7Time the care7_time value
	 */
	public void setCare7Time (java.lang.String care7Time) {
		this.care7Time = care7Time;
	}



	/**
	 * Return the value associated with the column: care8
	 */
	public java.lang.String getCare8 () {
		return care8;
	}

	/**
	 * Set the value related to the column: care8
	 * @param care8 the care8 value
	 */
	public void setCare8 (java.lang.String care8) {
		this.care8 = care8;
	}



	/**
	 * Return the value associated with the column: care8_time
	 */
	public java.lang.String getCare8Time () {
		return care8Time;
	}

	/**
	 * Set the value related to the column: care8_time
	 * @param care8Time the care8_time value
	 */
	public void setCare8Time (java.lang.String care8Time) {
		this.care8Time = care8Time;
	}



	/**
	 * Return the value associated with the column: care9
	 */
	public java.lang.String getCare9 () {
		return care9;
	}

	/**
	 * Set the value related to the column: care9
	 * @param care9 the care9 value
	 */
	public void setCare9 (java.lang.String care9) {
		this.care9 = care9;
	}



	/**
	 * Return the value associated with the column: care9_time
	 */
	public java.lang.String getCare9Time () {
		return care9Time;
	}

	/**
	 * Set the value related to the column: care9_time
	 * @param care9Time the care9_time value
	 */
	public void setCare9Time (java.lang.String care9Time) {
		this.care9Time = care9Time;
	}



	/**
	 * Return the value associated with the column: care10
	 */
	public java.lang.String getCare10 () {
		return care10;
	}

	/**
	 * Set the value related to the column: care10
	 * @param care10 the care10 value
	 */
	public void setCare10 (java.lang.String care10) {
		this.care10 = care10;
	}



	/**
	 * Return the value associated with the column: care10_time
	 */
	public java.lang.String getCare10Time () {
		return care10Time;
	}

	/**
	 * Set the value related to the column: care10_time
	 * @param care10Time the care10_time value
	 */
	public void setCare10Time (java.lang.String care10Time) {
		this.care10Time = care10Time;
	}



	/**
	 * Return the value associated with the column: care11
	 */
	public java.lang.String getCare11 () {
		return care11;
	}

	/**
	 * Set the value related to the column: care11
	 * @param care11 the care11 value
	 */
	public void setCare11 (java.lang.String care11) {
		this.care11 = care11;
	}



	/**
	 * Return the value associated with the column: care11_time
	 */
	public java.lang.String getCare11Time () {
		return care11Time;
	}

	/**
	 * Set the value related to the column: care11_time
	 * @param care11Time the care11_time value
	 */
	public void setCare11Time (java.lang.String care11Time) {
		this.care11Time = care11Time;
	}



	/**
	 * Return the value associated with the column: care12
	 */
	public java.lang.String getCare12 () {
		return care12;
	}

	/**
	 * Set the value related to the column: care12
	 * @param care12 the care12 value
	 */
	public void setCare12 (java.lang.String care12) {
		this.care12 = care12;
	}



	/**
	 * Return the value associated with the column: care12_time
	 */
	public java.lang.String getCare12Time () {
		return care12Time;
	}

	/**
	 * Set the value related to the column: care12_time
	 * @param care12Time the care12_time value
	 */
	public void setCare12Time (java.lang.String care12Time) {
		this.care12Time = care12Time;
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
	 * Return the value associated with the column: nursingcare_setup_id
	 */
	public jkt.hms.masters.business.NursingcareSetup getNursingcareSetup () {
		return nursingcareSetup;
	}

	/**
	 * Set the value related to the column: nursingcare_setup_id
	 * @param nursingcareSetup the nursingcare_setup_id value
	 */
	public void setNursingcareSetup (jkt.hms.masters.business.NursingcareSetup nursingcareSetup) {
		this.nursingcareSetup = nursingcareSetup;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.Ipdcaredetail)) return false;
		else {
			jkt.hms.masters.business.Ipdcaredetail ipdcaredetail = (jkt.hms.masters.business.Ipdcaredetail) obj;
			if (null == this.getId() || null == ipdcaredetail.getId()) return false;
			else return (this.getId().equals(ipdcaredetail.getId()));
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
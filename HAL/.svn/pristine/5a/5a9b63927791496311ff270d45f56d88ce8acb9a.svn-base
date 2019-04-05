package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the FAMILY_PLANNING table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="FAMILY_PLANNING"
 */

public abstract class BaseFamilyPlanning  implements Serializable {

	public static String REF = "FamilyPlanning";
	public static String PROP_HUSBAND_AGE = "HusbandAge";
	public static String PROP_PLAN_TIME = "PlanTime";
	public static String PROP_RELIGION = "Religion";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_DOCTOR_NAME = "DoctorName";
	public static String PROP_YEAR_NO = "YearNo";
	public static String PROP_HUSBAND_EDUCATION = "HusbandEducation";
	public static String PROP_WIFE_EDUCATION = "WifeEducation";
	public static String PROP_MONTH_NO = "MonthNo";
	public static String PROP_VISIT = "Visit";
	public static String PROP_MO = "Mo";
	public static String PROP_REGISTRATION_NO = "RegistrationNo";
	public static String PROP_STATUS = "Status";
	public static String PROP_FAMILY_PLANNING = "FamilyPlanning";
	public static String PROP_PLAN_DATE = "PlanDate";
	public static String PROP_NO_OF_CHILD = "NoOfChild";
	public static String PROP_HOSPITAL_NAME = "HospitalName";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_WIFE_AGE = "WifeAge";
	public static String PROP_ADDRESS = "Address";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_HIN = "Hin";


	// constructors
	public BaseFamilyPlanning () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFamilyPlanning (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer yearNo;
	private java.lang.Integer monthNo;
	private java.lang.String familyPlanning;
	private java.lang.String registrationNo;
	private java.util.Date planDate;
	private java.lang.String planTime;
	private java.lang.String husbandAge;
	private java.lang.String wifeAge;
	private java.lang.String husbandEducation;
	private java.lang.String wifeEducation;
	private java.lang.Integer noOfChild;
	private java.lang.String doctorName;
	private java.lang.String hospitalName;
	private java.lang.String address;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasReligion religion;
	private jkt.hms.masters.business.MasEmployee mo;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="FAMILY_PLANNING_ID"
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
	 * Return the value associated with the column: YEAR_NO
	 */
	public java.lang.Integer getYearNo () {
		return yearNo;
	}

	/**
	 * Set the value related to the column: YEAR_NO
	 * @param yearNo the YEAR_NO value
	 */
	public void setYearNo (java.lang.Integer yearNo) {
		this.yearNo = yearNo;
	}



	/**
	 * Return the value associated with the column: MONTH_NO
	 */
	public java.lang.Integer getMonthNo () {
		return monthNo;
	}

	/**
	 * Set the value related to the column: MONTH_NO
	 * @param monthNo the MONTH_NO value
	 */
	public void setMonthNo (java.lang.Integer monthNo) {
		this.monthNo = monthNo;
	}



	/**
	 * Return the value associated with the column: FAMILY_PLANNING
	 */
	public java.lang.String getFamilyPlanning () {
		return familyPlanning;
	}

	/**
	 * Set the value related to the column: FAMILY_PLANNING
	 * @param familyPlanning the FAMILY_PLANNING value
	 */
	public void setFamilyPlanning (java.lang.String familyPlanning) {
		this.familyPlanning = familyPlanning;
	}



	/**
	 * Return the value associated with the column: REGISTRATION_NO
	 */
	public java.lang.String getRegistrationNo () {
		return registrationNo;
	}

	/**
	 * Set the value related to the column: REGISTRATION_NO
	 * @param registrationNo the REGISTRATION_NO value
	 */
	public void setRegistrationNo (java.lang.String registrationNo) {
		this.registrationNo = registrationNo;
	}



	/**
	 * Return the value associated with the column: PLAN_DATE
	 */
	public java.util.Date getPlanDate () {
		return planDate;
	}

	/**
	 * Set the value related to the column: PLAN_DATE
	 * @param planDate the PLAN_DATE value
	 */
	public void setPlanDate (java.util.Date planDate) {
		this.planDate = planDate;
	}



	/**
	 * Return the value associated with the column: PLAN_TIME
	 */
	public java.lang.String getPlanTime () {
		return planTime;
	}

	/**
	 * Set the value related to the column: PLAN_TIME
	 * @param planTime the PLAN_TIME value
	 */
	public void setPlanTime (java.lang.String planTime) {
		this.planTime = planTime;
	}



	/**
	 * Return the value associated with the column: HUSBAND_AGE
	 */
	public java.lang.String getHusbandAge () {
		return husbandAge;
	}

	/**
	 * Set the value related to the column: HUSBAND_AGE
	 * @param husbandAge the HUSBAND_AGE value
	 */
	public void setHusbandAge (java.lang.String husbandAge) {
		this.husbandAge = husbandAge;
	}



	/**
	 * Return the value associated with the column: WIFE_AGE
	 */
	public java.lang.String getWifeAge () {
		return wifeAge;
	}

	/**
	 * Set the value related to the column: WIFE_AGE
	 * @param wifeAge the WIFE_AGE value
	 */
	public void setWifeAge (java.lang.String wifeAge) {
		this.wifeAge = wifeAge;
	}



	/**
	 * Return the value associated with the column: HUSBAND_EDUCATION
	 */
	public java.lang.String getHusbandEducation () {
		return husbandEducation;
	}

	/**
	 * Set the value related to the column: HUSBAND_EDUCATION
	 * @param husbandEducation the HUSBAND_EDUCATION value
	 */
	public void setHusbandEducation (java.lang.String husbandEducation) {
		this.husbandEducation = husbandEducation;
	}



	/**
	 * Return the value associated with the column: WIFE_EDUCATION
	 */
	public java.lang.String getWifeEducation () {
		return wifeEducation;
	}

	/**
	 * Set the value related to the column: WIFE_EDUCATION
	 * @param wifeEducation the WIFE_EDUCATION value
	 */
	public void setWifeEducation (java.lang.String wifeEducation) {
		this.wifeEducation = wifeEducation;
	}



	/**
	 * Return the value associated with the column: NO_OF_CHILD
	 */
	public java.lang.Integer getNoOfChild () {
		return noOfChild;
	}

	/**
	 * Set the value related to the column: NO_OF_CHILD
	 * @param noOfChild the NO_OF_CHILD value
	 */
	public void setNoOfChild (java.lang.Integer noOfChild) {
		this.noOfChild = noOfChild;
	}



	/**
	 * Return the value associated with the column: DOCTOR_NAME
	 */
	public java.lang.String getDoctorName () {
		return doctorName;
	}

	/**
	 * Set the value related to the column: DOCTOR_NAME
	 * @param doctorName the DOCTOR_NAME value
	 */
	public void setDoctorName (java.lang.String doctorName) {
		this.doctorName = doctorName;
	}



	/**
	 * Return the value associated with the column: HOSPITAL_NAME
	 */
	public java.lang.String getHospitalName () {
		return hospitalName;
	}

	/**
	 * Set the value related to the column: HOSPITAL_NAME
	 * @param hospitalName the HOSPITAL_NAME value
	 */
	public void setHospitalName (java.lang.String hospitalName) {
		this.hospitalName = hospitalName;
	}



	/**
	 * Return the value associated with the column: ADDRESS
	 */
	public java.lang.String getAddress () {
		return address;
	}

	/**
	 * Set the value related to the column: ADDRESS
	 * @param address the ADDRESS value
	 */
	public void setAddress (java.lang.String address) {
		this.address = address;
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
	 * Return the value associated with the column: STATUS
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: STATUS
	 * @param status the STATUS value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
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
	 * Return the value associated with the column: visit_id
	 */
	public jkt.hms.masters.business.Visit getVisit () {
		return visit;
	}

	/**
	 * Set the value related to the column: visit_id
	 * @param visit the visit_id value
	 */
	public void setVisit (jkt.hms.masters.business.Visit visit) {
		this.visit = visit;
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
	 * Return the value associated with the column: RELIGION_ID
	 */
	public jkt.hms.masters.business.MasReligion getReligion () {
		return religion;
	}

	/**
	 * Set the value related to the column: RELIGION_ID
	 * @param religion the RELIGION_ID value
	 */
	public void setReligion (jkt.hms.masters.business.MasReligion religion) {
		this.religion = religion;
	}



	/**
	 * Return the value associated with the column: MO_ID
	 */
	public jkt.hms.masters.business.MasEmployee getMo () {
		return mo;
	}

	/**
	 * Set the value related to the column: MO_ID
	 * @param mo the MO_ID value
	 */
	public void setMo (jkt.hms.masters.business.MasEmployee mo) {
		this.mo = mo;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.FamilyPlanning)) return false;
		else {
			jkt.hms.masters.business.FamilyPlanning familyPlanning = (jkt.hms.masters.business.FamilyPlanning) obj;
			if (null == this.getId() || null == familyPlanning.getId()) return false;
			else return (this.getId().equals(familyPlanning.getId()));
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
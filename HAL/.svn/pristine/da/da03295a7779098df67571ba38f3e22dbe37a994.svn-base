package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the patient_diet_indoor_detail table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="patient_diet_indoor_detail"
 */

public abstract class BasePatientDietIndoorDetail  implements Serializable {

	public static String REF = "PatientDietIndoorDetail";
	public static String PROP_EVENING_TEA = "EveningTea";
	public static String PROP_LUNCH_TIME = "LunchTime";
	public static String PROP_DINNER_TIME = "DinnerTime";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_MN = "MN";
	public static String PROP_LUNCH = "Lunch";
	public static String PROP_ENTRY_DATE = "EntryDate";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_DINNER = "Dinner";
	public static String PROP_ID = "Id";
	public static String PROP_DIET_ID = "DietId";
	public static String PROP_SPECIAL_INST = "SpecialInst";
	public static String PROP_DIET = "Diet";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_HIN = "Hin";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_BREAKFAST_TIME = "BreakfastTime";
	public static String PROP_BED = "Bed";
	public static String PROP_MORNING_TEA_BREAD = "MorningTeaBread";


	// constructors
	public BasePatientDietIndoorDetail () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePatientDietIndoorDetail (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date entryDate;
	private java.lang.String breakfastTime;
	private java.lang.String lunchTime;
	private java.lang.String dinnerTime;
	private java.lang.String morningTeaBread;
	private java.lang.String lunch;
	private java.lang.String eveningTea;
	private java.lang.String dinner;
	private java.lang.String lastChgBy;
	private java.lang.Integer mN;
	private java.lang.String specialInst;
	private java.lang.String diet;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasDiet dietId;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.MasBed bed;



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
	 * Return the value associated with the column: entry_date
	 */
	public java.util.Date getEntryDate () {
		return entryDate;
	}

	/**
	 * Set the value related to the column: entry_date
	 * @param entryDate the entry_date value
	 */
	public void setEntryDate (java.util.Date entryDate) {
		this.entryDate = entryDate;
	}



	/**
	 * Return the value associated with the column: breakfast_time
	 */
	public java.lang.String getBreakfastTime () {
		return breakfastTime;
	}

	/**
	 * Set the value related to the column: breakfast_time
	 * @param breakfastTime the breakfast_time value
	 */
	public void setBreakfastTime (java.lang.String breakfastTime) {
		this.breakfastTime = breakfastTime;
	}



	/**
	 * Return the value associated with the column: lunch_time
	 */
	public java.lang.String getLunchTime () {
		return lunchTime;
	}

	/**
	 * Set the value related to the column: lunch_time
	 * @param lunchTime the lunch_time value
	 */
	public void setLunchTime (java.lang.String lunchTime) {
		this.lunchTime = lunchTime;
	}



	/**
	 * Return the value associated with the column: dinner_time
	 */
	public java.lang.String getDinnerTime () {
		return dinnerTime;
	}

	/**
	 * Set the value related to the column: dinner_time
	 * @param dinnerTime the dinner_time value
	 */
	public void setDinnerTime (java.lang.String dinnerTime) {
		this.dinnerTime = dinnerTime;
	}



	/**
	 * Return the value associated with the column: morning_tea_bread
	 */
	public java.lang.String getMorningTeaBread () {
		return morningTeaBread;
	}

	/**
	 * Set the value related to the column: morning_tea_bread
	 * @param morningTeaBread the morning_tea_bread value
	 */
	public void setMorningTeaBread (java.lang.String morningTeaBread) {
		this.morningTeaBread = morningTeaBread;
	}



	/**
	 * Return the value associated with the column: lunch
	 */
	public java.lang.String getLunch () {
		return lunch;
	}

	/**
	 * Set the value related to the column: lunch
	 * @param lunch the lunch value
	 */
	public void setLunch (java.lang.String lunch) {
		this.lunch = lunch;
	}



	/**
	 * Return the value associated with the column: evening_tea
	 */
	public java.lang.String getEveningTea () {
		return eveningTea;
	}

	/**
	 * Set the value related to the column: evening_tea
	 * @param eveningTea the evening_tea value
	 */
	public void setEveningTea (java.lang.String eveningTea) {
		this.eveningTea = eveningTea;
	}



	/**
	 * Return the value associated with the column: dinner
	 */
	public java.lang.String getDinner () {
		return dinner;
	}

	/**
	 * Set the value related to the column: dinner
	 * @param dinner the dinner value
	 */
	public void setDinner (java.lang.String dinner) {
		this.dinner = dinner;
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
	 * Return the value associated with the column: m_n
	 */
	public java.lang.Integer getMN () {
		return mN;
	}

	/**
	 * Set the value related to the column: m_n
	 * @param mN the m_n value
	 */
	public void setMN (java.lang.Integer mN) {
		this.mN = mN;
	}



	/**
	 * Return the value associated with the column: special_inst
	 */
	public java.lang.String getSpecialInst () {
		return specialInst;
	}

	/**
	 * Set the value related to the column: special_inst
	 * @param specialInst the special_inst value
	 */
	public void setSpecialInst (java.lang.String specialInst) {
		this.specialInst = specialInst;
	}



	/**
	 * Return the value associated with the column: diet
	 */
	public java.lang.String getDiet () {
		return diet;
	}

	/**
	 * Set the value related to the column: diet
	 * @param diet the diet value
	 */
	public void setDiet (java.lang.String diet) {
		this.diet = diet;
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
	 * Return the value associated with the column: diet_id
	 */
	public jkt.hms.masters.business.MasDiet getDietId () {
		return dietId;
	}

	/**
	 * Set the value related to the column: diet_id
	 * @param dietId the diet_id value
	 */
	public void setDietId (jkt.hms.masters.business.MasDiet dietId) {
		this.dietId = dietId;
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
	 * Return the value associated with the column: bed_id
	 */
	public jkt.hms.masters.business.MasBed getBed () {
		return bed;
	}

	/**
	 * Set the value related to the column: bed_id
	 * @param bed the bed_id value
	 */
	public void setBed (jkt.hms.masters.business.MasBed bed) {
		this.bed = bed;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PatientDietIndoorDetail)) return false;
		else {
			jkt.hms.masters.business.PatientDietIndoorDetail patientDietIndoorDetail = (jkt.hms.masters.business.PatientDietIndoorDetail) obj;
			if (null == this.getId() || null == patientDietIndoorDetail.getId()) return false;
			else return (this.getId().equals(patientDietIndoorDetail.getId()));
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
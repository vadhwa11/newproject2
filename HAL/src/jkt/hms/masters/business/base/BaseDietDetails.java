package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the diet_details table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="diet_details"
 */

public abstract class BaseDietDetails implements Serializable {

	public static String REF = "DietDetails";
	public static String PROP_STATUS = "Status";
	public static String PROP_PATIENT_CONDITION = "PatientCondition";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_THERAPEUTIC_DIET = "TherapeuticDiet";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_HIN = "Hin";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_DIET_DATE = "DietDate";
	public static String PROP_DIET_COMBINATION = "DietCombination";
	public static String PROP_DIET_TYPE = "DietType";
	public static String PROP_DIET_CATEGORY = "DietCategory";
	public static String PROP_DIET = "Diet";
	public static String PROP_PATIENT_CATEGORY = "PatientCategory";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_ID = "Id";

	// constructors
	public BaseDietDetails() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDietDetails(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String patientCondition;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String patientCategory;
	private java.lang.String dietCategory;
	private java.util.Date dietDate;

	// many to one
	private jkt.hms.masters.business.MasDiet diet;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasDiet therapeuticDiet;
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.MasDietType dietType;
	private jkt.hms.masters.business.MasDietCombination dietCombination;
	private jkt.hms.masters.business.Patient hin;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="diet_details_id"
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
	 * Return the value associated with the column: patient_condition
	 */
	public java.lang.String getPatientCondition() {
		return patientCondition;
	}

	/**
	 * Set the value related to the column: patient_condition
	 * 
	 * @param patientCondition
	 *            the patient_condition value
	 */
	public void setPatientCondition(java.lang.String patientCondition) {
		this.patientCondition = patientCondition;
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
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.String getLastChgBy() {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * 
	 * @param lastChgBy
	 *            the last_chg_by value
	 */
	public void setLastChgBy(java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
	}

	/**
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate() {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * 
	 * @param lastChgDate
	 *            the last_chg_date value
	 */
	public void setLastChgDate(java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}

	/**
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime() {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * 
	 * @param lastChgTime
	 *            the last_chg_time value
	 */
	public void setLastChgTime(java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}

	/**
	 * Return the value associated with the column: patient_category
	 */
	public java.lang.String getPatientCategory() {
		return patientCategory;
	}

	/**
	 * Set the value related to the column: patient_category
	 * 
	 * @param patientCategory
	 *            the patient_category value
	 */
	public void setPatientCategory(java.lang.String patientCategory) {
		this.patientCategory = patientCategory;
	}

	/**
	 * Return the value associated with the column: diet_category
	 */
	public java.lang.String getDietCategory() {
		return dietCategory;
	}

	/**
	 * Set the value related to the column: diet_category
	 * 
	 * @param dietCategory
	 *            the diet_category value
	 */
	public void setDietCategory(java.lang.String dietCategory) {
		this.dietCategory = dietCategory;
	}

	/**
	 * Return the value associated with the column: diet_date
	 */
	public java.util.Date getDietDate() {
		return dietDate;
	}

	/**
	 * Set the value related to the column: diet_date
	 * 
	 * @param dietDate
	 *            the diet_date value
	 */
	public void setDietDate(java.util.Date dietDate) {
		this.dietDate = dietDate;
	}

	/**
	 * Return the value associated with the column: diet_id
	 */
	public jkt.hms.masters.business.MasDiet getDiet() {
		return diet;
	}

	/**
	 * Set the value related to the column: diet_id
	 * 
	 * @param diet
	 *            the diet_id value
	 */
	public void setDiet(jkt.hms.masters.business.MasDiet diet) {
		this.diet = diet;
	}

	/**
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital() {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * 
	 * @param hospital
	 *            the hospital_id value
	 */
	public void setHospital(jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}

	/**
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment() {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * 
	 * @param department
	 *            the department_id value
	 */
	public void setDepartment(jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}

	/**
	 * Return the value associated with the column: therapeutic_diet_id
	 */
	public jkt.hms.masters.business.MasDiet getTherapeuticDiet() {
		return therapeuticDiet;
	}

	/**
	 * Set the value related to the column: therapeutic_diet_id
	 * 
	 * @param therapeuticDiet
	 *            the therapeutic_diet_id value
	 */
	public void setTherapeuticDiet(
			jkt.hms.masters.business.MasDiet therapeuticDiet) {
		this.therapeuticDiet = therapeuticDiet;
	}

	/**
	 * Return the value associated with the column: inpatient_id
	 */
	public jkt.hms.masters.business.Inpatient getInpatient() {
		return inpatient;
	}

	/**
	 * Set the value related to the column: inpatient_id
	 * 
	 * @param inpatient
	 *            the inpatient_id value
	 */
	public void setInpatient(jkt.hms.masters.business.Inpatient inpatient) {
		this.inpatient = inpatient;
	}

	/**
	 * Return the value associated with the column: diet_type_id
	 */
	public jkt.hms.masters.business.MasDietType getDietType() {
		return dietType;
	}

	/**
	 * Set the value related to the column: diet_type_id
	 * 
	 * @param dietType
	 *            the diet_type_id value
	 */
	public void setDietType(jkt.hms.masters.business.MasDietType dietType) {
		this.dietType = dietType;
	}

	/**
	 * Return the value associated with the column: diet_combination_id
	 */
	public jkt.hms.masters.business.MasDietCombination getDietCombination() {
		return dietCombination;
	}

	/**
	 * Set the value related to the column: diet_combination_id
	 * 
	 * @param dietCombination
	 *            the diet_combination_id value
	 */
	public void setDietCombination(
			jkt.hms.masters.business.MasDietCombination dietCombination) {
		this.dietCombination = dietCombination;
	}

	/**
	 * Return the value associated with the column: hin_id
	 */
	public jkt.hms.masters.business.Patient getHin() {
		return hin;
	}

	/**
	 * Set the value related to the column: hin_id
	 * 
	 * @param hin
	 *            the hin_id value
	 */
	public void setHin(jkt.hms.masters.business.Patient hin) {
		this.hin = hin;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.DietDetails))
			return false;
		else {
			jkt.hms.masters.business.DietDetails dietDetails = (jkt.hms.masters.business.DietDetails) obj;
			if (null == this.getId() || null == dietDetails.getId())
				return false;
			else
				return (this.getId().equals(dietDetails.getId()));
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
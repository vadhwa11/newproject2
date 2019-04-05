package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the diet_daily_summary table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="diet_daily_summary"
 */

public abstract class BaseDietDailySummary implements Serializable {

	public static String REF = "DietDailySummary";
	public static String PROP_NIGHT_DUTY_PERSONS = "NightDutyPersons";
	public static String PROP_DEMAND_DATE = "DemandDate";
	public static String PROP_TRANSFER_IN_OFFICER = "TransferInOfficer";
	public static String PROP_DIET_SUMMARY_DATE = "DietSummaryDate";
	public static String PROP_DEATH_OTHER = "DeathOther";
	public static String PROP_CHANGED_BY = "ChangedBy";
	public static String PROP_DEATH_OFFICER = "DeathOfficer";
	public static String PROP_TOTAL_PATIENTS = "TotalPatients";
	public static String PROP_OTHER_DIET = "OtherDiet";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_DICHARGE_OFFICER = "DichargeOfficer";
	public static String PROP_REMAINING_OTHER = "RemainingOther";
	public static String PROP_DISCHARGE_OTHER = "DischargeOther";
	public static String PROP_CHANGED_TIME = "ChangedTime";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_MEDICAL_OFFICER = "MedicalOfficer";
	public static String PROP_REMAINING_OFFICER = "RemainingOfficer";
	public static String PROP_TRANSFER_OUT_OFFICER = "TransferOutOfficer";
	public static String PROP_LIME_SUGAR_PATIENTS = "LimeSugarPatients";
	public static String PROP_CHANGED_DATE = "ChangedDate";
	public static String PROP_SEPCIAL_DIET = "SepcialDiet";
	public static String PROP_TRANSFER_OUT_OTHER = "TransferOutOther";
	public static String PROP_ID = "Id";
	public static String PROP_TRANSFER_IN_OTHER = "TransferInOther";
	public static String PROP_FOR_DATE = "ForDate";

	// constructors
	public BaseDietDailySummary() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDietDailySummary(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer limeSugarPatients;
	private java.lang.Integer nightDutyPersons;
	private java.lang.Integer transferInOfficer;
	private java.lang.Integer transferInOther;
	private java.lang.Integer transferOutOfficer;
	private java.lang.Integer transferOutOther;
	private java.lang.Integer dichargeOfficer;
	private java.lang.Integer dischargeOther;
	private java.lang.Integer deathOfficer;
	private java.lang.Integer deathOther;
	private java.lang.Integer remainingOfficer;
	private java.lang.Integer remainingOther;
	private java.lang.Integer totalPatients;
	private java.util.Date dietSummaryDate;
	private java.lang.String changedBy;
	private java.util.Date changedDate;
	private java.lang.String changedTime;
	private java.util.Date demandDate;
	private java.util.Date forDate;
	private java.lang.String otherDiet;
	private java.lang.String sepcialDiet;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasEmployee medicalOfficer;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="daily_diet_summary_id"
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
	 * Return the value associated with the column: lime_sugar_patients
	 */
	public java.lang.Integer getLimeSugarPatients() {
		return limeSugarPatients;
	}

	/**
	 * Set the value related to the column: lime_sugar_patients
	 * 
	 * @param limeSugarPatients
	 *            the lime_sugar_patients value
	 */
	public void setLimeSugarPatients(java.lang.Integer limeSugarPatients) {
		this.limeSugarPatients = limeSugarPatients;
	}

	/**
	 * Return the value associated with the column: night_duty_persons
	 */
	public java.lang.Integer getNightDutyPersons() {
		return nightDutyPersons;
	}

	/**
	 * Set the value related to the column: night_duty_persons
	 * 
	 * @param nightDutyPersons
	 *            the night_duty_persons value
	 */
	public void setNightDutyPersons(java.lang.Integer nightDutyPersons) {
		this.nightDutyPersons = nightDutyPersons;
	}

	/**
	 * Return the value associated with the column: transfer_in_officer
	 */
	public java.lang.Integer getTransferInOfficer() {
		return transferInOfficer;
	}

	/**
	 * Set the value related to the column: transfer_in_officer
	 * 
	 * @param transferInOfficer
	 *            the transfer_in_officer value
	 */
	public void setTransferInOfficer(java.lang.Integer transferInOfficer) {
		this.transferInOfficer = transferInOfficer;
	}

	/**
	 * Return the value associated with the column: transfer_in_other
	 */
	public java.lang.Integer getTransferInOther() {
		return transferInOther;
	}

	/**
	 * Set the value related to the column: transfer_in_other
	 * 
	 * @param transferInOther
	 *            the transfer_in_other value
	 */
	public void setTransferInOther(java.lang.Integer transferInOther) {
		this.transferInOther = transferInOther;
	}

	/**
	 * Return the value associated with the column: transfer_out_officer
	 */
	public java.lang.Integer getTransferOutOfficer() {
		return transferOutOfficer;
	}

	/**
	 * Set the value related to the column: transfer_out_officer
	 * 
	 * @param transferOutOfficer
	 *            the transfer_out_officer value
	 */
	public void setTransferOutOfficer(java.lang.Integer transferOutOfficer) {
		this.transferOutOfficer = transferOutOfficer;
	}

	/**
	 * Return the value associated with the column: transfer_out_other
	 */
	public java.lang.Integer getTransferOutOther() {
		return transferOutOther;
	}

	/**
	 * Set the value related to the column: transfer_out_other
	 * 
	 * @param transferOutOther
	 *            the transfer_out_other value
	 */
	public void setTransferOutOther(java.lang.Integer transferOutOther) {
		this.transferOutOther = transferOutOther;
	}

	/**
	 * Return the value associated with the column: dicharge_officer
	 */
	public java.lang.Integer getDichargeOfficer() {
		return dichargeOfficer;
	}

	/**
	 * Set the value related to the column: dicharge_officer
	 * 
	 * @param dichargeOfficer
	 *            the dicharge_officer value
	 */
	public void setDichargeOfficer(java.lang.Integer dichargeOfficer) {
		this.dichargeOfficer = dichargeOfficer;
	}

	/**
	 * Return the value associated with the column: discharge_other
	 */
	public java.lang.Integer getDischargeOther() {
		return dischargeOther;
	}

	/**
	 * Set the value related to the column: discharge_other
	 * 
	 * @param dischargeOther
	 *            the discharge_other value
	 */
	public void setDischargeOther(java.lang.Integer dischargeOther) {
		this.dischargeOther = dischargeOther;
	}

	/**
	 * Return the value associated with the column: death_officer
	 */
	public java.lang.Integer getDeathOfficer() {
		return deathOfficer;
	}

	/**
	 * Set the value related to the column: death_officer
	 * 
	 * @param deathOfficer
	 *            the death_officer value
	 */
	public void setDeathOfficer(java.lang.Integer deathOfficer) {
		this.deathOfficer = deathOfficer;
	}

	/**
	 * Return the value associated with the column: death_other
	 */
	public java.lang.Integer getDeathOther() {
		return deathOther;
	}

	/**
	 * Set the value related to the column: death_other
	 * 
	 * @param deathOther
	 *            the death_other value
	 */
	public void setDeathOther(java.lang.Integer deathOther) {
		this.deathOther = deathOther;
	}

	/**
	 * Return the value associated with the column: remaining_officer
	 */
	public java.lang.Integer getRemainingOfficer() {
		return remainingOfficer;
	}

	/**
	 * Set the value related to the column: remaining_officer
	 * 
	 * @param remainingOfficer
	 *            the remaining_officer value
	 */
	public void setRemainingOfficer(java.lang.Integer remainingOfficer) {
		this.remainingOfficer = remainingOfficer;
	}

	/**
	 * Return the value associated with the column: remaining_other
	 */
	public java.lang.Integer getRemainingOther() {
		return remainingOther;
	}

	/**
	 * Set the value related to the column: remaining_other
	 * 
	 * @param remainingOther
	 *            the remaining_other value
	 */
	public void setRemainingOther(java.lang.Integer remainingOther) {
		this.remainingOther = remainingOther;
	}

	/**
	 * Return the value associated with the column: total_patients
	 */
	public java.lang.Integer getTotalPatients() {
		return totalPatients;
	}

	/**
	 * Set the value related to the column: total_patients
	 * 
	 * @param totalPatients
	 *            the total_patients value
	 */
	public void setTotalPatients(java.lang.Integer totalPatients) {
		this.totalPatients = totalPatients;
	}

	/**
	 * Return the value associated with the column: diet_summary_date
	 */
	public java.util.Date getDietSummaryDate() {
		return dietSummaryDate;
	}

	/**
	 * Set the value related to the column: diet_summary_date
	 * 
	 * @param dietSummaryDate
	 *            the diet_summary_date value
	 */
	public void setDietSummaryDate(java.util.Date dietSummaryDate) {
		this.dietSummaryDate = dietSummaryDate;
	}

	/**
	 * Return the value associated with the column: changed_by
	 */
	public java.lang.String getChangedBy() {
		return changedBy;
	}

	/**
	 * Set the value related to the column: changed_by
	 * 
	 * @param changedBy
	 *            the changed_by value
	 */
	public void setChangedBy(java.lang.String changedBy) {
		this.changedBy = changedBy;
	}

	/**
	 * Return the value associated with the column: changed_date
	 */
	public java.util.Date getChangedDate() {
		return changedDate;
	}

	/**
	 * Set the value related to the column: changed_date
	 * 
	 * @param changedDate
	 *            the changed_date value
	 */
	public void setChangedDate(java.util.Date changedDate) {
		this.changedDate = changedDate;
	}

	/**
	 * Return the value associated with the column: changed_time
	 */
	public java.lang.String getChangedTime() {
		return changedTime;
	}

	/**
	 * Set the value related to the column: changed_time
	 * 
	 * @param changedTime
	 *            the changed_time value
	 */
	public void setChangedTime(java.lang.String changedTime) {
		this.changedTime = changedTime;
	}

	/**
	 * Return the value associated with the column: demand_date
	 */
	public java.util.Date getDemandDate() {
		return demandDate;
	}

	/**
	 * Set the value related to the column: demand_date
	 * 
	 * @param demandDate
	 *            the demand_date value
	 */
	public void setDemandDate(java.util.Date demandDate) {
		this.demandDate = demandDate;
	}

	/**
	 * Return the value associated with the column: for_date
	 */
	public java.util.Date getForDate() {
		return forDate;
	}

	/**
	 * Set the value related to the column: for_date
	 * 
	 * @param forDate
	 *            the for_date value
	 */
	public void setForDate(java.util.Date forDate) {
		this.forDate = forDate;
	}

	/**
	 * Return the value associated with the column: other_diet
	 */
	public java.lang.String getOtherDiet() {
		return otherDiet;
	}

	/**
	 * Set the value related to the column: other_diet
	 * 
	 * @param otherDiet
	 *            the other_diet value
	 */
	public void setOtherDiet(java.lang.String otherDiet) {
		this.otherDiet = otherDiet;
	}

	/**
	 * Return the value associated with the column: special_diet
	 */
	public java.lang.String getSepcialDiet() {
		return sepcialDiet;
	}

	/**
	 * Set the value related to the column: special_diet
	 * 
	 * @param sepcialDiet
	 *            the special_diet value
	 */
	public void setSepcialDiet(java.lang.String sepcialDiet) {
		this.sepcialDiet = sepcialDiet;
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
	 * Return the value associated with the column: medical_officer_id
	 */
	public jkt.hms.masters.business.MasEmployee getMedicalOfficer() {
		return medicalOfficer;
	}

	/**
	 * Set the value related to the column: medical_officer_id
	 * 
	 * @param medicalOfficer
	 *            the medical_officer_id value
	 */
	public void setMedicalOfficer(
			jkt.hms.masters.business.MasEmployee medicalOfficer) {
		this.medicalOfficer = medicalOfficer;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.DietDailySummary))
			return false;
		else {
			jkt.hms.masters.business.DietDailySummary dietDailySummary = (jkt.hms.masters.business.DietDailySummary) obj;
			if (null == this.getId() || null == dietDailySummary.getId())
				return false;
			else
				return (this.getId().equals(dietDailySummary.getId()));
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
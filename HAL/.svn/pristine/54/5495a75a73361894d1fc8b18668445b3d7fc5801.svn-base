package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the WORKLOAD_MONTHLY table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="WORKLOAD_MONTHLY"
 */

public abstract class BaseWorkloadMonthly  implements Serializable {

	public static String REF = "WorkloadMonthly";
	public static String PROP_OFFRS_GD = "OffrsGd";
	public static String PROP_TOTAL_POPULATION = "TotalPopulation";
	public static String PROP_OFFRS_AIRCREW = "OffrsAircrew";
	public static String PROP_ADMISSION_TOTAL = "AdmissionTotal";
	public static String PROP_DSC = "Dsc";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_AIRMEN_CREW = "AirmenCrew";
	public static String PROP_AIRMEN_OTHER = "AirmenOther";
	public static String PROP_TOTAL_SICK_REPORT = "TotalSickReport";
	public static String PROP_MISC_MED_EXAMS = "MiscMedExams";
	public static String PROP_REFERRALS_ALL = "ReferralsAll";
	public static String PROP_MISC_MED_BOARDS = "MiscMedBoards";
	public static String PROP_ADM_SERVICE_PERS = "AdmServicePers";
	public static String PROP_ID = "Id";
	public static String PROP_REFERRALS_RATE_POPULATION = "ReferralsRatePopulation";
	public static String PROP_ADMISSION_RATE_POPULATION = "AdmissionRatePopulation";
	public static String PROP_UNIT_ID = "UnitId";
	public static String PROP_NCS = "Ncs";


	// constructors
	public BaseWorkloadMonthly () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseWorkloadMonthly (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer totalPopulation;
	private java.lang.Integer offrsAircrew;
	private java.lang.Integer offrsGd;
	private java.lang.Integer airmenCrew;
	private java.lang.Integer airmenOther;
	private java.lang.Integer ncs;
	private java.lang.Integer dsc;
	private java.lang.Integer totalSickReport;
	private java.lang.String admissionRatePopulation;
	private java.lang.String admServicePers;
	private java.lang.Integer admissionTotal;
	private java.lang.Integer referralsAll;
	private java.lang.String referralsRatePopulation;
	private java.lang.Integer miscMedBoards;
	private java.lang.Integer miscMedExams;

	// many to one
	private jkt.hms.masters.business.MasHospital hospitalId;
	private jkt.hms.masters.business.MasUnit unitId;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="WORKLOAD_ID"
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
	 * Return the value associated with the column: TOTAL_POPULATION
	 */
	public java.lang.Integer getTotalPopulation () {
		return totalPopulation;
	}

	/**
	 * Set the value related to the column: TOTAL_POPULATION
	 * @param totalPopulation the TOTAL_POPULATION value
	 */
	public void setTotalPopulation (java.lang.Integer totalPopulation) {
		this.totalPopulation = totalPopulation;
	}



	/**
	 * Return the value associated with the column: OFFRS_AIRCREW
	 */
	public java.lang.Integer getOffrsAircrew () {
		return offrsAircrew;
	}

	/**
	 * Set the value related to the column: OFFRS_AIRCREW
	 * @param offrsAircrew the OFFRS_AIRCREW value
	 */
	public void setOffrsAircrew (java.lang.Integer offrsAircrew) {
		this.offrsAircrew = offrsAircrew;
	}



	/**
	 * Return the value associated with the column: OFFRS_GD
	 */
	public java.lang.Integer getOffrsGd () {
		return offrsGd;
	}

	/**
	 * Set the value related to the column: OFFRS_GD
	 * @param offrsGd the OFFRS_GD value
	 */
	public void setOffrsGd (java.lang.Integer offrsGd) {
		this.offrsGd = offrsGd;
	}



	/**
	 * Return the value associated with the column: AIRMEN_CREW
	 */
	public java.lang.Integer getAirmenCrew () {
		return airmenCrew;
	}

	/**
	 * Set the value related to the column: AIRMEN_CREW
	 * @param airmenCrew the AIRMEN_CREW value
	 */
	public void setAirmenCrew (java.lang.Integer airmenCrew) {
		this.airmenCrew = airmenCrew;
	}



	/**
	 * Return the value associated with the column: AIRMEN_OTHER
	 */
	public java.lang.Integer getAirmenOther () {
		return airmenOther;
	}

	/**
	 * Set the value related to the column: AIRMEN_OTHER
	 * @param airmenOther the AIRMEN_OTHER value
	 */
	public void setAirmenOther (java.lang.Integer airmenOther) {
		this.airmenOther = airmenOther;
	}



	/**
	 * Return the value associated with the column: NCS
	 */
	public java.lang.Integer getNcs () {
		return ncs;
	}

	/**
	 * Set the value related to the column: NCS
	 * @param ncs the NCS value
	 */
	public void setNcs (java.lang.Integer ncs) {
		this.ncs = ncs;
	}



	/**
	 * Return the value associated with the column: DSC
	 */
	public java.lang.Integer getDsc () {
		return dsc;
	}

	/**
	 * Set the value related to the column: DSC
	 * @param dsc the DSC value
	 */
	public void setDsc (java.lang.Integer dsc) {
		this.dsc = dsc;
	}



	/**
	 * Return the value associated with the column: TOTAL_SICK_REPORT
	 */
	public java.lang.Integer getTotalSickReport () {
		return totalSickReport;
	}

	/**
	 * Set the value related to the column: TOTAL_SICK_REPORT
	 * @param totalSickReport the TOTAL_SICK_REPORT value
	 */
	public void setTotalSickReport (java.lang.Integer totalSickReport) {
		this.totalSickReport = totalSickReport;
	}



	/**
	 * Return the value associated with the column: ADMISSION_RATE_POPULATION
	 */
	public java.lang.String getAdmissionRatePopulation () {
		return admissionRatePopulation;
	}

	/**
	 * Set the value related to the column: ADMISSION_RATE_POPULATION
	 * @param admissionRatePopulation the ADMISSION_RATE_POPULATION value
	 */
	public void setAdmissionRatePopulation (java.lang.String admissionRatePopulation) {
		this.admissionRatePopulation = admissionRatePopulation;
	}



	/**
	 * Return the value associated with the column: ADM_SERVICE_PERS
	 */
	public java.lang.String getAdmServicePers () {
		return admServicePers;
	}

	/**
	 * Set the value related to the column: ADM_SERVICE_PERS
	 * @param admServicePers the ADM_SERVICE_PERS value
	 */
	public void setAdmServicePers (java.lang.String admServicePers) {
		this.admServicePers = admServicePers;
	}



	/**
	 * Return the value associated with the column: ADMISSION_TOTAL
	 */
	public java.lang.Integer getAdmissionTotal () {
		return admissionTotal;
	}

	/**
	 * Set the value related to the column: ADMISSION_TOTAL
	 * @param admissionTotal the ADMISSION_TOTAL value
	 */
	public void setAdmissionTotal (java.lang.Integer admissionTotal) {
		this.admissionTotal = admissionTotal;
	}



	/**
	 * Return the value associated with the column: REFERRALS_ALL
	 */
	public java.lang.Integer getReferralsAll () {
		return referralsAll;
	}

	/**
	 * Set the value related to the column: REFERRALS_ALL
	 * @param referralsAll the REFERRALS_ALL value
	 */
	public void setReferralsAll (java.lang.Integer referralsAll) {
		this.referralsAll = referralsAll;
	}



	/**
	 * Return the value associated with the column: REFERRALS_RATE_POPULATION
	 */
	public java.lang.String getReferralsRatePopulation () {
		return referralsRatePopulation;
	}

	/**
	 * Set the value related to the column: REFERRALS_RATE_POPULATION
	 * @param referralsRatePopulation the REFERRALS_RATE_POPULATION value
	 */
	public void setReferralsRatePopulation (java.lang.String referralsRatePopulation) {
		this.referralsRatePopulation = referralsRatePopulation;
	}



	/**
	 * Return the value associated with the column: MISC_MED_BOARDS
	 */
	public java.lang.Integer getMiscMedBoards () {
		return miscMedBoards;
	}

	/**
	 * Set the value related to the column: MISC_MED_BOARDS
	 * @param miscMedBoards the MISC_MED_BOARDS value
	 */
	public void setMiscMedBoards (java.lang.Integer miscMedBoards) {
		this.miscMedBoards = miscMedBoards;
	}



	/**
	 * Return the value associated with the column: MISC_MED_EXAMS
	 */
	public java.lang.Integer getMiscMedExams () {
		return miscMedExams;
	}

	/**
	 * Set the value related to the column: MISC_MED_EXAMS
	 * @param miscMedExams the MISC_MED_EXAMS value
	 */
	public void setMiscMedExams (java.lang.Integer miscMedExams) {
		this.miscMedExams = miscMedExams;
	}



	/**
	 * Return the value associated with the column: HOSPITAL_ID
	 */
	public jkt.hms.masters.business.MasHospital getHospitalId () {
		return hospitalId;
	}

	/**
	 * Set the value related to the column: HOSPITAL_ID
	 * @param hospitalId the HOSPITAL_ID value
	 */
	public void setHospitalId (jkt.hms.masters.business.MasHospital hospitalId) {
		this.hospitalId = hospitalId;
	}



	/**
	 * Return the value associated with the column: UNIT_ID
	 */
	public jkt.hms.masters.business.MasUnit getUnitId () {
		return unitId;
	}

	/**
	 * Set the value related to the column: UNIT_ID
	 * @param unitId the UNIT_ID value
	 */
	public void setUnitId (jkt.hms.masters.business.MasUnit unitId) {
		this.unitId = unitId;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.WorkloadMonthly)) return false;
		else {
			jkt.hms.masters.business.WorkloadMonthly workloadMonthly = (jkt.hms.masters.business.WorkloadMonthly) obj;
			if (null == this.getId() || null == workloadMonthly.getId()) return false;
			else return (this.getId().equals(workloadMonthly.getId()));
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
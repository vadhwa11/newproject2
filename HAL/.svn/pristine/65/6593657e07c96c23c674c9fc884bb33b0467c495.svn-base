package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SHO_MONTHLY_WORK_LOAD table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="SHO_MONTHLY_WORK_LOAD"
 */

public abstract class BaseShoMonthlyWorkLoad  implements Serializable {

	public static String REF = "ShoMonthlyWorkLoad";
	public static String PROP_SERVICE_PERSON = "ServicePerson";
	public static String PROP_TOTAL_POPULATION = "TotalPopulation";
	public static String PROP_LAST_CHANGED_DATE = "LastChangedDate";
	public static String PROP_POPULATION_ALL = "PopulationAll";
	public static String PROP_DSC = "Dsc";
	public static String PROP_TOTAL_SICK = "TotalSick";
	public static String PROP_POPULATION_SICK = "PopulationSick";
	public static String PROP_WORK_LOAD_ID = "WorkLoadId";
	public static String PROP_ALL_FAMLIES = "AllFamlies";
	public static String PROP_MONTH = "Month";
	public static String PROP_UNIT = "Unit";
	public static String PROP_MEDICAL_EXAM = "MedicalExam";
	public static String PROP_LAST_CHANGED_TIME = "LastChangedTime";
	public static String PROP_LAST_CHANGED_BY = "LastChangedBy";
	public static String PROP_FAMLIES = "Famlies";
	public static String PROP_NCS = "Ncs";
	public static String PROP_POPULATION_SERVICE_PERSON = "PopulationServicePerson";
	public static String PROP_AIRMEN_AIRCREW = "AirmenAircrew";
	public static String PROP_AIRMEN_OTHERS = "AirmenOthers";
	public static String PROP_ALL_PERSON = "AllPerson";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_MEDCAL_BOARD = "MedcalBoard";
	public static String PROP_OFF_GD = "OffGd";
	public static String PROP_ID = "Id";
	public static String PROP_OFF_AIRCREW = "OffAircrew";
	public static String PROP_TOTAL = "Total";


	// constructors
	public BaseShoMonthlyWorkLoad () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseShoMonthlyWorkLoad (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseShoMonthlyWorkLoad (
		java.lang.Integer id,
		java.lang.Integer workLoadId) {

		this.setId(id);
		this.setWorkLoadId(workLoadId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer workLoadId;
	private java.lang.String totalPopulation;
	private java.lang.String offAircrew;
	private java.lang.String offGd;
	private java.lang.String airmenAircrew;
	private java.lang.String airmenOthers;
	private java.lang.String ncs;
	private java.lang.String dsc;
	private java.lang.String allFamlies;
	private java.lang.String totalSick;
	private java.lang.String populationSick;
	private java.lang.String servicePerson;
	private java.lang.String famlies;
	private java.lang.String total;
	private java.lang.String populationServicePerson;
	private java.lang.String allPerson;
	private java.lang.String populationAll;
	private java.lang.String medcalBoard;
	private java.lang.String medicalExam;
	private java.lang.String lastChangedBy;
	private java.lang.String lastChangedDate;
	private java.lang.String lastChangedTime;
	private java.lang.String month;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasUnit unit;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="work_load_id"
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
	 * Return the value associated with the column: WORK_LOAD_ID
	 */
	public java.lang.Integer getWorkLoadId () {
		return workLoadId;
	}

	/**
	 * Set the value related to the column: WORK_LOAD_ID
	 * @param workLoadId the WORK_LOAD_ID value
	 */
	public void setWorkLoadId (java.lang.Integer workLoadId) {
		this.workLoadId = workLoadId;
	}



	/**
	 * Return the value associated with the column: TOTAL_POPULATION
	 */
	public java.lang.String getTotalPopulation () {
		return totalPopulation;
	}

	/**
	 * Set the value related to the column: TOTAL_POPULATION
	 * @param totalPopulation the TOTAL_POPULATION value
	 */
	public void setTotalPopulation (java.lang.String totalPopulation) {
		this.totalPopulation = totalPopulation;
	}



	/**
	 * Return the value associated with the column: OFF_AIRCREW
	 */
	public java.lang.String getOffAircrew () {
		return offAircrew;
	}

	/**
	 * Set the value related to the column: OFF_AIRCREW
	 * @param offAircrew the OFF_AIRCREW value
	 */
	public void setOffAircrew (java.lang.String offAircrew) {
		this.offAircrew = offAircrew;
	}



	/**
	 * Return the value associated with the column: OFF_GD
	 */
	public java.lang.String getOffGd () {
		return offGd;
	}

	/**
	 * Set the value related to the column: OFF_GD
	 * @param offGd the OFF_GD value
	 */
	public void setOffGd (java.lang.String offGd) {
		this.offGd = offGd;
	}



	/**
	 * Return the value associated with the column: AIRMEN_AIRCREW
	 */
	public java.lang.String getAirmenAircrew () {
		return airmenAircrew;
	}

	/**
	 * Set the value related to the column: AIRMEN_AIRCREW
	 * @param airmenAircrew the AIRMEN_AIRCREW value
	 */
	public void setAirmenAircrew (java.lang.String airmenAircrew) {
		this.airmenAircrew = airmenAircrew;
	}



	/**
	 * Return the value associated with the column: AIRMEN_OTHERS
	 */
	public java.lang.String getAirmenOthers () {
		return airmenOthers;
	}

	/**
	 * Set the value related to the column: AIRMEN_OTHERS
	 * @param airmenOthers the AIRMEN_OTHERS value
	 */
	public void setAirmenOthers (java.lang.String airmenOthers) {
		this.airmenOthers = airmenOthers;
	}



	/**
	 * Return the value associated with the column: NCS
	 */
	public java.lang.String getNcs () {
		return ncs;
	}

	/**
	 * Set the value related to the column: NCS
	 * @param ncs the NCS value
	 */
	public void setNcs (java.lang.String ncs) {
		this.ncs = ncs;
	}



	/**
	 * Return the value associated with the column: DSC
	 */
	public java.lang.String getDsc () {
		return dsc;
	}

	/**
	 * Set the value related to the column: DSC
	 * @param dsc the DSC value
	 */
	public void setDsc (java.lang.String dsc) {
		this.dsc = dsc;
	}



	/**
	 * Return the value associated with the column: ALL_FAMLIES
	 */
	public java.lang.String getAllFamlies () {
		return allFamlies;
	}

	/**
	 * Set the value related to the column: ALL_FAMLIES
	 * @param allFamlies the ALL_FAMLIES value
	 */
	public void setAllFamlies (java.lang.String allFamlies) {
		this.allFamlies = allFamlies;
	}



	/**
	 * Return the value associated with the column: TOTAL_SICK
	 */
	public java.lang.String getTotalSick () {
		return totalSick;
	}

	/**
	 * Set the value related to the column: TOTAL_SICK
	 * @param totalSick the TOTAL_SICK value
	 */
	public void setTotalSick (java.lang.String totalSick) {
		this.totalSick = totalSick;
	}



	/**
	 * Return the value associated with the column: POPULATION_SICK
	 */
	public java.lang.String getPopulationSick () {
		return populationSick;
	}

	/**
	 * Set the value related to the column: POPULATION_SICK
	 * @param populationSick the POPULATION_SICK value
	 */
	public void setPopulationSick (java.lang.String populationSick) {
		this.populationSick = populationSick;
	}



	/**
	 * Return the value associated with the column: SERVICE_PERSON
	 */
	public java.lang.String getServicePerson () {
		return servicePerson;
	}

	/**
	 * Set the value related to the column: SERVICE_PERSON
	 * @param servicePerson the SERVICE_PERSON value
	 */
	public void setServicePerson (java.lang.String servicePerson) {
		this.servicePerson = servicePerson;
	}



	/**
	 * Return the value associated with the column: FAMLIES
	 */
	public java.lang.String getFamlies () {
		return famlies;
	}

	/**
	 * Set the value related to the column: FAMLIES
	 * @param famlies the FAMLIES value
	 */
	public void setFamlies (java.lang.String famlies) {
		this.famlies = famlies;
	}



	/**
	 * Return the value associated with the column: TOTAL
	 */
	public java.lang.String getTotal () {
		return total;
	}

	/**
	 * Set the value related to the column: TOTAL
	 * @param total the TOTAL value
	 */
	public void setTotal (java.lang.String total) {
		this.total = total;
	}



	/**
	 * Return the value associated with the column: POPULATION_SERVICE_PERSON
	 */
	public java.lang.String getPopulationServicePerson () {
		return populationServicePerson;
	}

	/**
	 * Set the value related to the column: POPULATION_SERVICE_PERSON
	 * @param populationServicePerson the POPULATION_SERVICE_PERSON value
	 */
	public void setPopulationServicePerson (java.lang.String populationServicePerson) {
		this.populationServicePerson = populationServicePerson;
	}



	/**
	 * Return the value associated with the column: ALL_PERSON
	 */
	public java.lang.String getAllPerson () {
		return allPerson;
	}

	/**
	 * Set the value related to the column: ALL_PERSON
	 * @param allPerson the ALL_PERSON value
	 */
	public void setAllPerson (java.lang.String allPerson) {
		this.allPerson = allPerson;
	}



	/**
	 * Return the value associated with the column: POPULATION_ALL
	 */
	public java.lang.String getPopulationAll () {
		return populationAll;
	}

	/**
	 * Set the value related to the column: POPULATION_ALL
	 * @param populationAll the POPULATION_ALL value
	 */
	public void setPopulationAll (java.lang.String populationAll) {
		this.populationAll = populationAll;
	}



	/**
	 * Return the value associated with the column: MEDCAL_BOARD
	 */
	public java.lang.String getMedcalBoard () {
		return medcalBoard;
	}

	/**
	 * Set the value related to the column: MEDCAL_BOARD
	 * @param medcalBoard the MEDCAL_BOARD value
	 */
	public void setMedcalBoard (java.lang.String medcalBoard) {
		this.medcalBoard = medcalBoard;
	}



	/**
	 * Return the value associated with the column: MEDICAL_EXAM
	 */
	public java.lang.String getMedicalExam () {
		return medicalExam;
	}

	/**
	 * Set the value related to the column: MEDICAL_EXAM
	 * @param medicalExam the MEDICAL_EXAM value
	 */
	public void setMedicalExam (java.lang.String medicalExam) {
		this.medicalExam = medicalExam;
	}



	/**
	 * Return the value associated with the column: LAST_CHANGED_BY
	 */
	public java.lang.String getLastChangedBy () {
		return lastChangedBy;
	}

	/**
	 * Set the value related to the column: LAST_CHANGED_BY
	 * @param lastChangedBy the LAST_CHANGED_BY value
	 */
	public void setLastChangedBy (java.lang.String lastChangedBy) {
		this.lastChangedBy = lastChangedBy;
	}



	/**
	 * Return the value associated with the column: LAST_CHANGED_DATE
	 */
	public java.lang.String getLastChangedDate () {
		return lastChangedDate;
	}

	/**
	 * Set the value related to the column: LAST_CHANGED_DATE
	 * @param lastChangedDate the LAST_CHANGED_DATE value
	 */
	public void setLastChangedDate (java.lang.String lastChangedDate) {
		this.lastChangedDate = lastChangedDate;
	}



	/**
	 * Return the value associated with the column: LAST_CHANGED_TIME
	 */
	public java.lang.String getLastChangedTime () {
		return lastChangedTime;
	}

	/**
	 * Set the value related to the column: LAST_CHANGED_TIME
	 * @param lastChangedTime the LAST_CHANGED_TIME value
	 */
	public void setLastChangedTime (java.lang.String lastChangedTime) {
		this.lastChangedTime = lastChangedTime;
	}



	/**
	 * Return the value associated with the column: MONTH
	 */
	public java.lang.String getMonth () {
		return month;
	}

	/**
	 * Set the value related to the column: MONTH
	 * @param month the MONTH value
	 */
	public void setMonth (java.lang.String month) {
		this.month = month;
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
	 * Return the value associated with the column: unit_id
	 */
	public jkt.hms.masters.business.MasUnit getUnit () {
		return unit;
	}

	/**
	 * Set the value related to the column: unit_id
	 * @param unit the unit_id value
	 */
	public void setUnit (jkt.hms.masters.business.MasUnit unit) {
		this.unit = unit;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.ShoMonthlyWorkLoad)) return false;
		else {
			jkt.hms.masters.business.ShoMonthlyWorkLoad shoMonthlyWorkLoad = (jkt.hms.masters.business.ShoMonthlyWorkLoad) obj;
			if (null == this.getId() || null == shoMonthlyWorkLoad.getId()) return false;
			else return (this.getId().equals(shoMonthlyWorkLoad.getId()));
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
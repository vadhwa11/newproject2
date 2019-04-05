package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the AVI_CASUALTY_AIR_EVACUATION table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="AVI_CASUALTY_AIR_EVACUATION"
 */

public abstract class BaseAviCasualtyAirEvacuation  implements Serializable {

	public static String REF = "AviCasualtyAirEvacuation";
	public static String PROP_COMMAND = "Command";
	public static String PROP_CONDITION = "Condition";
	public static String PROP_DATE_CASUALTY_ARRIVAL = "DateCasualtyArrival";
	public static String PROP_DIFFCULTIES = "Diffculties";
	public static String PROP_AGE = "Age";
	public static String PROP_RADIO_FOR_TABLE = "RadioForTable";
	public static String PROP_TRADE = "Trade";
	public static String PROP_RANK = "Rank";
	public static String PROP_AIRCRAFT_TYPE = "AircraftType";
	public static String PROP_CLINICAL = "Clinical";
	public static String PROP_CONDITION_STATUS = "ConditionStatus";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_SERVICE_TYPE = "ServiceType";
	public static String PROP_HIN_NO = "HinNo";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_LAST_NAME = "LastName";
	public static String PROP_UNIT = "Unit";
	public static String PROP_STATION = "Station";
	public static String PROP_RECORD_OFFICE = "RecordOffice";
	public static String PROP_TIME_CASUALTY = "TimeCasualty";
	public static String PROP_ENROUTE_HOLDING_UNIT = "EnrouteHoldingUnit";
	public static String PROP_TIME_CASUALTY_ARRIVAL = "TimeCasualtyArrival";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_DIAGNOSIS = "Diagnosis";
	public static String PROP_DURATION_HOLDING = "DurationHolding";
	public static String PROP_FIRST_NAME = "FirstName";
	public static String PROP_CASUALTY_AIR_EVACUATION_TIME = "CasualtyAirEvacuationTime";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_CASUALTY = "Casualty";
	public static String PROP_DATE_CONDITION = "DateCondition";
	public static String PROP_CASUALTY_AIR_EVACUATION_DATE = "CasualtyAirEvacuationDate";
	public static String PROP_TOTAL_DURATION = "TotalDuration";
	public static String PROP_SERVICE_NO = "ServiceNo";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_DATE_CASUALTY = "DateCasualty";
	public static String PROP_SERVICE_STATUS = "ServiceStatus";
	public static String PROP_SECTION = "Section";
	public static String PROP_STATUS = "Status";
	public static String PROP_MIDDLE_NAME = "MiddleName";
	public static String PROP_TIME_CONDITION = "TimeCondition";
	public static String PROP_DISPOSAL = "Disposal";
	public static String PROP_GENDER = "Gender";
	public static String PROP_ID = "Id";
	public static String PROP_TOTAL_SERVICE = "TotalService";
	public static String PROP_HIN = "Hin";


	// constructors
	public BaseAviCasualtyAirEvacuation () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAviCasualtyAirEvacuation (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String serviceNo;
	private java.util.Date casualtyAirEvacuationDate;
	private java.lang.String casualtyAirEvacuationTime;
	private java.lang.String firstName;
	private java.lang.String middleName;
	private java.lang.String lastName;
	private java.lang.Integer totalService;
	private java.lang.String age;
	private java.util.Date dateCasualtyArrival;
	private java.lang.String timeCasualtyArrival;
	private java.lang.String clinical;
	private java.lang.String diagnosis;
	private java.lang.String condition;
	private java.util.Date dateCondition;
	private java.lang.String timeCondition;
	private java.lang.String casualty;
	private java.util.Date dateCasualty;
	private java.lang.String timeCasualty;
	private java.lang.String diffculties;
	private java.lang.String disposal;
	private java.lang.String remarks;
	private java.lang.String radioForTable;
	private java.lang.Integer totalDuration;
	private java.lang.Integer durationHolding;
	private java.lang.String status;
	private java.lang.String lastChgTime;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgBy;
	private java.lang.String conditionStatus;
	private java.lang.String hinNo;
	private java.lang.String station;

	// many to one
	private jkt.hms.masters.business.MasRank rank;
	private jkt.hms.masters.business.MasUnit unit;
	private jkt.hms.masters.business.MasTrade trade;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasAdministrativeSex gender;
	private jkt.hms.masters.business.MasAircraftType aircraftType;
	private jkt.hms.masters.business.MasUnit enrouteHoldingUnit;
	private jkt.hms.masters.business.MasServiceType serviceType;
	private jkt.hms.masters.business.MasServiceStatus serviceStatus;
	private jkt.hms.masters.business.MasSection section;
	private jkt.hms.masters.business.MasCommand command;
	private jkt.hms.masters.business.MasRecordOfficeAddress recordOffice;
	private jkt.hms.masters.business.Patient hin;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="CASUALTY_AIR_EVACUATION_ID"
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
	 * Return the value associated with the column: SERVICE_NO
	 */
	public java.lang.String getServiceNo () {
		return serviceNo;
	}

	/**
	 * Set the value related to the column: SERVICE_NO
	 * @param serviceNo the SERVICE_NO value
	 */
	public void setServiceNo (java.lang.String serviceNo) {
		this.serviceNo = serviceNo;
	}



	/**
	 * Return the value associated with the column: CASUALTY_AIR_EVACUATION_DATE
	 */
	public java.util.Date getCasualtyAirEvacuationDate () {
		return casualtyAirEvacuationDate;
	}

	/**
	 * Set the value related to the column: CASUALTY_AIR_EVACUATION_DATE
	 * @param casualtyAirEvacuationDate the CASUALTY_AIR_EVACUATION_DATE value
	 */
	public void setCasualtyAirEvacuationDate (java.util.Date casualtyAirEvacuationDate) {
		this.casualtyAirEvacuationDate = casualtyAirEvacuationDate;
	}



	/**
	 * Return the value associated with the column: CASUALTY_AIR_EVACUATION_TIME
	 */
	public java.lang.String getCasualtyAirEvacuationTime () {
		return casualtyAirEvacuationTime;
	}

	/**
	 * Set the value related to the column: CASUALTY_AIR_EVACUATION_TIME
	 * @param casualtyAirEvacuationTime the CASUALTY_AIR_EVACUATION_TIME value
	 */
	public void setCasualtyAirEvacuationTime (java.lang.String casualtyAirEvacuationTime) {
		this.casualtyAirEvacuationTime = casualtyAirEvacuationTime;
	}



	/**
	 * Return the value associated with the column: FIRST_NAME
	 */
	public java.lang.String getFirstName () {
		return firstName;
	}

	/**
	 * Set the value related to the column: FIRST_NAME
	 * @param firstName the FIRST_NAME value
	 */
	public void setFirstName (java.lang.String firstName) {
		this.firstName = firstName;
	}



	/**
	 * Return the value associated with the column: MIDDLE_NAME
	 */
	public java.lang.String getMiddleName () {
		return middleName;
	}

	/**
	 * Set the value related to the column: MIDDLE_NAME
	 * @param middleName the MIDDLE_NAME value
	 */
	public void setMiddleName (java.lang.String middleName) {
		this.middleName = middleName;
	}



	/**
	 * Return the value associated with the column: LAST_NAME
	 */
	public java.lang.String getLastName () {
		return lastName;
	}

	/**
	 * Set the value related to the column: LAST_NAME
	 * @param lastName the LAST_NAME value
	 */
	public void setLastName (java.lang.String lastName) {
		this.lastName = lastName;
	}



	/**
	 * Return the value associated with the column: TOTAL_SERVICE
	 */
	public java.lang.Integer getTotalService () {
		return totalService;
	}

	/**
	 * Set the value related to the column: TOTAL_SERVICE
	 * @param totalService the TOTAL_SERVICE value
	 */
	public void setTotalService (java.lang.Integer totalService) {
		this.totalService = totalService;
	}



	/**
	 * Return the value associated with the column: AGE
	 */
	public java.lang.String getAge () {
		return age;
	}

	/**
	 * Set the value related to the column: AGE
	 * @param age the AGE value
	 */
	public void setAge (java.lang.String age) {
		this.age = age;
	}



	/**
	 * Return the value associated with the column: DATE_CASUALTY_ARRIVAL
	 */
	public java.util.Date getDateCasualtyArrival () {
		return dateCasualtyArrival;
	}

	/**
	 * Set the value related to the column: DATE_CASUALTY_ARRIVAL
	 * @param dateCasualtyArrival the DATE_CASUALTY_ARRIVAL value
	 */
	public void setDateCasualtyArrival (java.util.Date dateCasualtyArrival) {
		this.dateCasualtyArrival = dateCasualtyArrival;
	}



	/**
	 * Return the value associated with the column: TIME_CASUALTY_ARRIVAL
	 */
	public java.lang.String getTimeCasualtyArrival () {
		return timeCasualtyArrival;
	}

	/**
	 * Set the value related to the column: TIME_CASUALTY_ARRIVAL
	 * @param timeCasualtyArrival the TIME_CASUALTY_ARRIVAL value
	 */
	public void setTimeCasualtyArrival (java.lang.String timeCasualtyArrival) {
		this.timeCasualtyArrival = timeCasualtyArrival;
	}



	/**
	 * Return the value associated with the column: CLINICAL
	 */
	public java.lang.String getClinical () {
		return clinical;
	}

	/**
	 * Set the value related to the column: CLINICAL
	 * @param clinical the CLINICAL value
	 */
	public void setClinical (java.lang.String clinical) {
		this.clinical = clinical;
	}



	/**
	 * Return the value associated with the column: DIAGNOSIS
	 */
	public java.lang.String getDiagnosis () {
		return diagnosis;
	}

	/**
	 * Set the value related to the column: DIAGNOSIS
	 * @param diagnosis the DIAGNOSIS value
	 */
	public void setDiagnosis (java.lang.String diagnosis) {
		this.diagnosis = diagnosis;
	}



	/**
	 * Return the value associated with the column: CONDITION
	 */
	public java.lang.String getCondition () {
		return condition;
	}

	/**
	 * Set the value related to the column: CONDITION
	 * @param condition the CONDITION value
	 */
	public void setCondition (java.lang.String condition) {
		this.condition = condition;
	}



	/**
	 * Return the value associated with the column: DATE_CONDITION
	 */
	public java.util.Date getDateCondition () {
		return dateCondition;
	}

	/**
	 * Set the value related to the column: DATE_CONDITION
	 * @param dateCondition the DATE_CONDITION value
	 */
	public void setDateCondition (java.util.Date dateCondition) {
		this.dateCondition = dateCondition;
	}



	/**
	 * Return the value associated with the column: TIME_CONDITION
	 */
	public java.lang.String getTimeCondition () {
		return timeCondition;
	}

	/**
	 * Set the value related to the column: TIME_CONDITION
	 * @param timeCondition the TIME_CONDITION value
	 */
	public void setTimeCondition (java.lang.String timeCondition) {
		this.timeCondition = timeCondition;
	}



	/**
	 * Return the value associated with the column: CASUALTY
	 */
	public java.lang.String getCasualty () {
		return casualty;
	}

	/**
	 * Set the value related to the column: CASUALTY
	 * @param casualty the CASUALTY value
	 */
	public void setCasualty (java.lang.String casualty) {
		this.casualty = casualty;
	}



	/**
	 * Return the value associated with the column: DATE_CASUALTY
	 */
	public java.util.Date getDateCasualty () {
		return dateCasualty;
	}

	/**
	 * Set the value related to the column: DATE_CASUALTY
	 * @param dateCasualty the DATE_CASUALTY value
	 */
	public void setDateCasualty (java.util.Date dateCasualty) {
		this.dateCasualty = dateCasualty;
	}



	/**
	 * Return the value associated with the column: TIME_CASUALTY
	 */
	public java.lang.String getTimeCasualty () {
		return timeCasualty;
	}

	/**
	 * Set the value related to the column: TIME_CASUALTY
	 * @param timeCasualty the TIME_CASUALTY value
	 */
	public void setTimeCasualty (java.lang.String timeCasualty) {
		this.timeCasualty = timeCasualty;
	}



	/**
	 * Return the value associated with the column: DIFFCULTIES
	 */
	public java.lang.String getDiffculties () {
		return diffculties;
	}

	/**
	 * Set the value related to the column: DIFFCULTIES
	 * @param diffculties the DIFFCULTIES value
	 */
	public void setDiffculties (java.lang.String diffculties) {
		this.diffculties = diffculties;
	}



	/**
	 * Return the value associated with the column: DISPOSAL
	 */
	public java.lang.String getDisposal () {
		return disposal;
	}

	/**
	 * Set the value related to the column: DISPOSAL
	 * @param disposal the DISPOSAL value
	 */
	public void setDisposal (java.lang.String disposal) {
		this.disposal = disposal;
	}



	/**
	 * Return the value associated with the column: REMARKS
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: REMARKS
	 * @param remarks the REMARKS value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
	}



	/**
	 * Return the value associated with the column: RADIO_FOR_TABLE
	 */
	public java.lang.String getRadioForTable () {
		return radioForTable;
	}

	/**
	 * Set the value related to the column: RADIO_FOR_TABLE
	 * @param radioForTable the RADIO_FOR_TABLE value
	 */
	public void setRadioForTable (java.lang.String radioForTable) {
		this.radioForTable = radioForTable;
	}



	/**
	 * Return the value associated with the column: TOTAL_DURATION
	 */
	public java.lang.Integer getTotalDuration () {
		return totalDuration;
	}

	/**
	 * Set the value related to the column: TOTAL_DURATION
	 * @param totalDuration the TOTAL_DURATION value
	 */
	public void setTotalDuration (java.lang.Integer totalDuration) {
		this.totalDuration = totalDuration;
	}



	/**
	 * Return the value associated with the column: DURATION_HOLDING
	 */
	public java.lang.Integer getDurationHolding () {
		return durationHolding;
	}

	/**
	 * Set the value related to the column: DURATION_HOLDING
	 * @param durationHolding the DURATION_HOLDING value
	 */
	public void setDurationHolding (java.lang.Integer durationHolding) {
		this.durationHolding = durationHolding;
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
	 * Return the value associated with the column: LAST_CHG_BY
	 */
	public java.lang.String getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: LAST_CHG_BY
	 * @param lastChgBy the LAST_CHG_BY value
	 */
	public void setLastChgBy (java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
	}



	/**
	 * Return the value associated with the column: CONDITION_STATUS
	 */
	public java.lang.String getConditionStatus () {
		return conditionStatus;
	}

	/**
	 * Set the value related to the column: CONDITION_STATUS
	 * @param conditionStatus the CONDITION_STATUS value
	 */
	public void setConditionStatus (java.lang.String conditionStatus) {
		this.conditionStatus = conditionStatus;
	}



	/**
	 * Return the value associated with the column: hin_no
	 */
	public java.lang.String getHinNo () {
		return hinNo;
	}

	/**
	 * Set the value related to the column: hin_no
	 * @param hinNo the hin_no value
	 */
	public void setHinNo (java.lang.String hinNo) {
		this.hinNo = hinNo;
	}



	/**
	 * Return the value associated with the column: station
	 */
	public java.lang.String getStation () {
		return station;
	}

	/**
	 * Set the value related to the column: station
	 * @param station the station value
	 */
	public void setStation (java.lang.String station) {
		this.station = station;
	}



	/**
	 * Return the value associated with the column: RANK_ID
	 */
	public jkt.hms.masters.business.MasRank getRank () {
		return rank;
	}

	/**
	 * Set the value related to the column: RANK_ID
	 * @param rank the RANK_ID value
	 */
	public void setRank (jkt.hms.masters.business.MasRank rank) {
		this.rank = rank;
	}



	/**
	 * Return the value associated with the column: UNIT_ID
	 */
	public jkt.hms.masters.business.MasUnit getUnit () {
		return unit;
	}

	/**
	 * Set the value related to the column: UNIT_ID
	 * @param unit the UNIT_ID value
	 */
	public void setUnit (jkt.hms.masters.business.MasUnit unit) {
		this.unit = unit;
	}



	/**
	 * Return the value associated with the column: TRADE_ID
	 */
	public jkt.hms.masters.business.MasTrade getTrade () {
		return trade;
	}

	/**
	 * Set the value related to the column: TRADE_ID
	 * @param trade the TRADE_ID value
	 */
	public void setTrade (jkt.hms.masters.business.MasTrade trade) {
		this.trade = trade;
	}



	/**
	 * Return the value associated with the column: HOSPITAL_ID
	 */
	public jkt.hms.masters.business.MasHospital getHospital () {
		return hospital;
	}

	/**
	 * Set the value related to the column: HOSPITAL_ID
	 * @param hospital the HOSPITAL_ID value
	 */
	public void setHospital (jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}



	/**
	 * Return the value associated with the column: DEPARTMENT_ID
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment () {
		return department;
	}

	/**
	 * Set the value related to the column: DEPARTMENT_ID
	 * @param department the DEPARTMENT_ID value
	 */
	public void setDepartment (jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}



	/**
	 * Return the value associated with the column: GENDER_ID
	 */
	public jkt.hms.masters.business.MasAdministrativeSex getGender () {
		return gender;
	}

	/**
	 * Set the value related to the column: GENDER_ID
	 * @param gender the GENDER_ID value
	 */
	public void setGender (jkt.hms.masters.business.MasAdministrativeSex gender) {
		this.gender = gender;
	}



	/**
	 * Return the value associated with the column: AIRCRAFT_TYPE_ID
	 */
	public jkt.hms.masters.business.MasAircraftType getAircraftType () {
		return aircraftType;
	}

	/**
	 * Set the value related to the column: AIRCRAFT_TYPE_ID
	 * @param aircraftType the AIRCRAFT_TYPE_ID value
	 */
	public void setAircraftType (jkt.hms.masters.business.MasAircraftType aircraftType) {
		this.aircraftType = aircraftType;
	}



	/**
	 * Return the value associated with the column: ENROUTE_HOLDING_UNIT
	 */
	public jkt.hms.masters.business.MasUnit getEnrouteHoldingUnit () {
		return enrouteHoldingUnit;
	}

	/**
	 * Set the value related to the column: ENROUTE_HOLDING_UNIT
	 * @param enrouteHoldingUnit the ENROUTE_HOLDING_UNIT value
	 */
	public void setEnrouteHoldingUnit (jkt.hms.masters.business.MasUnit enrouteHoldingUnit) {
		this.enrouteHoldingUnit = enrouteHoldingUnit;
	}



	/**
	 * Return the value associated with the column: service_type_id
	 */
	public jkt.hms.masters.business.MasServiceType getServiceType () {
		return serviceType;
	}

	/**
	 * Set the value related to the column: service_type_id
	 * @param serviceType the service_type_id value
	 */
	public void setServiceType (jkt.hms.masters.business.MasServiceType serviceType) {
		this.serviceType = serviceType;
	}



	/**
	 * Return the value associated with the column: service_status_id
	 */
	public jkt.hms.masters.business.MasServiceStatus getServiceStatus () {
		return serviceStatus;
	}

	/**
	 * Set the value related to the column: service_status_id
	 * @param serviceStatus the service_status_id value
	 */
	public void setServiceStatus (jkt.hms.masters.business.MasServiceStatus serviceStatus) {
		this.serviceStatus = serviceStatus;
	}



	/**
	 * Return the value associated with the column: section_id
	 */
	public jkt.hms.masters.business.MasSection getSection () {
		return section;
	}

	/**
	 * Set the value related to the column: section_id
	 * @param section the section_id value
	 */
	public void setSection (jkt.hms.masters.business.MasSection section) {
		this.section = section;
	}



	/**
	 * Return the value associated with the column: command_id
	 */
	public jkt.hms.masters.business.MasCommand getCommand () {
		return command;
	}

	/**
	 * Set the value related to the column: command_id
	 * @param command the command_id value
	 */
	public void setCommand (jkt.hms.masters.business.MasCommand command) {
		this.command = command;
	}



	/**
	 * Return the value associated with the column: RECORD_OFFICE_ID
	 */
	public jkt.hms.masters.business.MasRecordOfficeAddress getRecordOffice () {
		return recordOffice;
	}

	/**
	 * Set the value related to the column: RECORD_OFFICE_ID
	 * @param recordOffice the RECORD_OFFICE_ID value
	 */
	public void setRecordOffice (jkt.hms.masters.business.MasRecordOfficeAddress recordOffice) {
		this.recordOffice = recordOffice;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.AviCasualtyAirEvacuation)) return false;
		else {
			jkt.hms.masters.business.AviCasualtyAirEvacuation aviCasualtyAirEvacuation = (jkt.hms.masters.business.AviCasualtyAirEvacuation) obj;
			if (null == this.getId() || null == aviCasualtyAirEvacuation.getId()) return false;
			else return (this.getId().equals(aviCasualtyAirEvacuation.getId()));
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
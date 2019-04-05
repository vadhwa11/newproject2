package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SHO_FAMILY_WELFARE_ACTIVITIES table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="SHO_FAMILY_WELFARE_ACTIVITIES"
 */

public abstract class BaseShoFamilyWelfareActivities  implements Serializable {

	public static String REF = "ShoFamilyWelfareActivities";
	public static String PROP_TOTAL_POPULATION = "TotalPopulation";
	public static String PROP_A_ORAL_PILLS = "AOralPills";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_T_ORAL_PILLS = "TOralPills";
	public static String PROP_NATIONAL_PULSE = "NationalPulse";
	public static String PROP_N_P_REMARKS = "NPRemarks";
	public static String PROP_D_V_REMARKS = "DVRemarks";
	public static String PROP_STATUS = "Status";
	public static String PROP_T_STERILZATION = "TSterilzation";
	public static String PROP_HEALTH_TALKS = "HealthTalks";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_DOOR_VISITS = "DoorVisits";
	public static String PROP_A_IUDS = "AIuds";
	public static String PROP_T_IUDS = "TIuds";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_DATE = "LastDate";
	public static String PROP_WEL_FARE_DATE = "WelFareDate";
	public static String PROP_T_CC = "TCc";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_H_T_REMARKS = "HTRemarks";
	public static String PROP_A_STERILZATION = "ASterilzation";
	public static String PROP_A_CC = "ACc";


	// constructors
	public BaseShoFamilyWelfareActivities () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseShoFamilyWelfareActivities (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseShoFamilyWelfareActivities (
		java.lang.Integer id,
		java.lang.String tSterilzation,
		java.lang.String tIuds,
		java.lang.String tCc,
		java.lang.String tOralPills,
		java.lang.String aSterilzation,
		java.lang.String aIuds,
		java.lang.String aCc,
		java.lang.String aOralPills,
		java.lang.String doorVisits,
		java.lang.String dVRemarks,
		java.lang.String healthTalks,
		java.lang.String hTRemarks,
		java.lang.String nationalPulse,
		java.lang.String nPRemarks,
		java.lang.String totalPopulation) {

		this.setId(id);
		this.setTSterilzation(tSterilzation);
		this.setTIuds(tIuds);
		this.setTCc(tCc);
		this.setTOralPills(tOralPills);
		this.setASterilzation(aSterilzation);
		this.setAIuds(aIuds);
		this.setACc(aCc);
		this.setAOralPills(aOralPills);
		this.setDoorVisits(doorVisits);
		this.setDVRemarks(dVRemarks);
		this.setHealthTalks(healthTalks);
		this.setHTRemarks(hTRemarks);
		this.setNationalPulse(nationalPulse);
		this.setNPRemarks(nPRemarks);
		this.setTotalPopulation(totalPopulation);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date welFareDate;
	private java.util.Date lastDate;
	private java.lang.String tSterilzation;
	private java.lang.String tIuds;
	private java.lang.String tCc;
	private java.lang.String tOralPills;
	private java.lang.String aSterilzation;
	private java.lang.String aIuds;
	private java.lang.String aCc;
	private java.lang.String aOralPills;
	private java.lang.String doorVisits;
	private java.lang.String dVRemarks;
	private java.lang.String healthTalks;
	private java.lang.String hTRemarks;
	private java.lang.String nationalPulse;
	private java.lang.String nPRemarks;
	private java.lang.String totalPopulation;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="FAMILY_WELFARE_ACTIVITIES_ID"
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
	 * Return the value associated with the column: WELFARE_DATE
	 */
	public java.util.Date getWelFareDate () {
		return welFareDate;
	}

	/**
	 * Set the value related to the column: WELFARE_DATE
	 * @param welFareDate the WELFARE_DATE value
	 */
	public void setWelFareDate (java.util.Date welFareDate) {
		this.welFareDate = welFareDate;
	}



	/**
	 * Return the value associated with the column: LAST_DATE
	 */
	public java.util.Date getLastDate () {
		return lastDate;
	}

	/**
	 * Set the value related to the column: LAST_DATE
	 * @param lastDate the LAST_DATE value
	 */
	public void setLastDate (java.util.Date lastDate) {
		this.lastDate = lastDate;
	}



	/**
	 * Return the value associated with the column: T_STERILZATION
	 */
	public java.lang.String getTSterilzation () {
		return tSterilzation;
	}

	/**
	 * Set the value related to the column: T_STERILZATION
	 * @param tSterilzation the T_STERILZATION value
	 */
	public void setTSterilzation (java.lang.String tSterilzation) {
		this.tSterilzation = tSterilzation;
	}



	/**
	 * Return the value associated with the column: T_IUDS
	 */
	public java.lang.String getTIuds () {
		return tIuds;
	}

	/**
	 * Set the value related to the column: T_IUDS
	 * @param tIuds the T_IUDS value
	 */
	public void setTIuds (java.lang.String tIuds) {
		this.tIuds = tIuds;
	}



	/**
	 * Return the value associated with the column: T_CC
	 */
	public java.lang.String getTCc () {
		return tCc;
	}

	/**
	 * Set the value related to the column: T_CC
	 * @param tCc the T_CC value
	 */
	public void setTCc (java.lang.String tCc) {
		this.tCc = tCc;
	}



	/**
	 * Return the value associated with the column: T_ORAL_PILLS
	 */
	public java.lang.String getTOralPills () {
		return tOralPills;
	}

	/**
	 * Set the value related to the column: T_ORAL_PILLS
	 * @param tOralPills the T_ORAL_PILLS value
	 */
	public void setTOralPills (java.lang.String tOralPills) {
		this.tOralPills = tOralPills;
	}



	/**
	 * Return the value associated with the column: A_STERILZATION
	 */
	public java.lang.String getASterilzation () {
		return aSterilzation;
	}

	/**
	 * Set the value related to the column: A_STERILZATION
	 * @param aSterilzation the A_STERILZATION value
	 */
	public void setASterilzation (java.lang.String aSterilzation) {
		this.aSterilzation = aSterilzation;
	}



	/**
	 * Return the value associated with the column: A_IUDS
	 */
	public java.lang.String getAIuds () {
		return aIuds;
	}

	/**
	 * Set the value related to the column: A_IUDS
	 * @param aIuds the A_IUDS value
	 */
	public void setAIuds (java.lang.String aIuds) {
		this.aIuds = aIuds;
	}



	/**
	 * Return the value associated with the column: A_CC
	 */
	public java.lang.String getACc () {
		return aCc;
	}

	/**
	 * Set the value related to the column: A_CC
	 * @param aCc the A_CC value
	 */
	public void setACc (java.lang.String aCc) {
		this.aCc = aCc;
	}



	/**
	 * Return the value associated with the column: A_ORAL_PILLS
	 */
	public java.lang.String getAOralPills () {
		return aOralPills;
	}

	/**
	 * Set the value related to the column: A_ORAL_PILLS
	 * @param aOralPills the A_ORAL_PILLS value
	 */
	public void setAOralPills (java.lang.String aOralPills) {
		this.aOralPills = aOralPills;
	}



	/**
	 * Return the value associated with the column: DOOR_VISITS
	 */
	public java.lang.String getDoorVisits () {
		return doorVisits;
	}

	/**
	 * Set the value related to the column: DOOR_VISITS
	 * @param doorVisits the DOOR_VISITS value
	 */
	public void setDoorVisits (java.lang.String doorVisits) {
		this.doorVisits = doorVisits;
	}



	/**
	 * Return the value associated with the column: D_V_REMARKS
	 */
	public java.lang.String getDVRemarks () {
		return dVRemarks;
	}

	/**
	 * Set the value related to the column: D_V_REMARKS
	 * @param dVRemarks the D_V_REMARKS value
	 */
	public void setDVRemarks (java.lang.String dVRemarks) {
		this.dVRemarks = dVRemarks;
	}



	/**
	 * Return the value associated with the column: HEALTH_TALKS
	 */
	public java.lang.String getHealthTalks () {
		return healthTalks;
	}

	/**
	 * Set the value related to the column: HEALTH_TALKS
	 * @param healthTalks the HEALTH_TALKS value
	 */
	public void setHealthTalks (java.lang.String healthTalks) {
		this.healthTalks = healthTalks;
	}



	/**
	 * Return the value associated with the column: H_T_REMARKS
	 */
	public java.lang.String getHTRemarks () {
		return hTRemarks;
	}

	/**
	 * Set the value related to the column: H_T_REMARKS
	 * @param hTRemarks the H_T_REMARKS value
	 */
	public void setHTRemarks (java.lang.String hTRemarks) {
		this.hTRemarks = hTRemarks;
	}



	/**
	 * Return the value associated with the column: NATIONAL_PLUSE
	 */
	public java.lang.String getNationalPulse () {
		return nationalPulse;
	}

	/**
	 * Set the value related to the column: NATIONAL_PLUSE
	 * @param nationalPulse the NATIONAL_PLUSE value
	 */
	public void setNationalPulse (java.lang.String nationalPulse) {
		this.nationalPulse = nationalPulse;
	}



	/**
	 * Return the value associated with the column: N_P_REMARKS
	 */
	public java.lang.String getNPRemarks () {
		return nPRemarks;
	}

	/**
	 * Set the value related to the column: N_P_REMARKS
	 * @param nPRemarks the N_P_REMARKS value
	 */
	public void setNPRemarks (java.lang.String nPRemarks) {
		this.nPRemarks = nPRemarks;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.ShoFamilyWelfareActivities)) return false;
		else {
			jkt.hms.masters.business.ShoFamilyWelfareActivities shoFamilyWelfareActivities = (jkt.hms.masters.business.ShoFamilyWelfareActivities) obj;
			if (null == this.getId() || null == shoFamilyWelfareActivities.getId()) return false;
			else return (this.getId().equals(shoFamilyWelfareActivities.getId()));
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
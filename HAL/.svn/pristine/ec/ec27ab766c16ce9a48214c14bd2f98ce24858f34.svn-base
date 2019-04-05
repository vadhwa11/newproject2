package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SHO_ACCOMMODATION table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="SHO_ACCOMMODATION"
 */

public abstract class BaseShoAccommodation  implements Serializable {

	public static String REF = "ShoAccommodation";
	public static String PROP_DSC_MARRIED_D = "DscMarriedD";
	public static String PROP_DSC_MARRIED_E = "DscMarriedE";
	public static String PROP_VENTILATION = "Ventilation";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_COOLING_ARRANGEMENT = "CoolingArrangement";
	public static String PROP_UNIT = "Unit";
	public static String PROP_NCS_MARRIED_D = "NcsMarriedD";
	public static String PROP_NCS_MARRIED_E = "NcsMarriedE";
	public static String PROP_HEATING_ARRANGEMENT = "HeatingArrangement";
	public static String PROP_AIRMEN_SINGLE_E = "AirmenSingleE";
	public static String PROP_AIRMEN_SINGLE_D = "AirmenSingleD";
	public static String PROP_CURRENT_DATE = "CurrentDate";
	public static String PROP_DSC_SINGLE_D = "DscSingleD";
	public static String PROP_DSC_SINGLE_E = "DscSingleE";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_OFFICER_SINGLE_E = "OfficerSingleE";
	public static String PROP_OFFICER_SINGLE_D = "OfficerSingleD";
	public static String PROP_LIGHTING_ARRANGEMENT = "LightingArrangement";
	public static String PROP_OFFICER_MARRIED_E = "OfficerMarriedE";
	public static String PROP_OFFICER_MARRIED_D = "OfficerMarriedD";
	public static String PROP_NCS_SINGLE_D = "NcsSingleD";
	public static String PROP_AIRMEN_MARRIED_D = "AirmenMarriedD";
	public static String PROP_ID = "Id";
	public static String PROP_NCS_SINGLE_E = "NcsSingleE";
	public static String PROP_AIRMEN_MARRIED_E = "AirmenMarriedE";


	// constructors
	public BaseShoAccommodation () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseShoAccommodation (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String officerSingleE;
	private java.lang.String officerSingleD;
	private java.lang.String officerMarriedE;
	private java.lang.String officerMarriedD;
	private java.lang.String airmenSingleE;
	private java.lang.String airmenSingleD;
	private java.lang.String airmenMarriedE;
	private java.lang.String airmenMarriedD;
	private java.lang.String ncsSingleE;
	private java.lang.String ncsSingleD;
	private java.lang.String ncsMarriedE;
	private java.lang.String ncsMarriedD;
	private java.lang.String dscSingleE;
	private java.lang.String dscSingleD;
	private java.lang.String dscMarriedE;
	private java.lang.String dscMarriedD;
	private java.lang.String lightingArrangement;
	private java.lang.String ventilation;
	private java.lang.String coolingArrangement;
	private java.lang.String heatingArrangement;
	private java.lang.String remarks;
	private java.util.Date currentDate;

	// many to one
	private jkt.hms.masters.business.MasUnit unit;
	private jkt.hms.masters.business.MasHospital hospital;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="ACCOMMODATION_ID"
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
	 * Return the value associated with the column: OFFICER_SINGLE_E
	 */
	public java.lang.String getOfficerSingleE () {
		return officerSingleE;
	}

	/**
	 * Set the value related to the column: OFFICER_SINGLE_E
	 * @param officerSingleE the OFFICER_SINGLE_E value
	 */
	public void setOfficerSingleE (java.lang.String officerSingleE) {
		this.officerSingleE = officerSingleE;
	}



	/**
	 * Return the value associated with the column: OFFICER_SINGLE_D
	 */
	public java.lang.String getOfficerSingleD () {
		return officerSingleD;
	}

	/**
	 * Set the value related to the column: OFFICER_SINGLE_D
	 * @param officerSingleD the OFFICER_SINGLE_D value
	 */
	public void setOfficerSingleD (java.lang.String officerSingleD) {
		this.officerSingleD = officerSingleD;
	}



	/**
	 * Return the value associated with the column: OFFICER_MARRIED_E
	 */
	public java.lang.String getOfficerMarriedE () {
		return officerMarriedE;
	}

	/**
	 * Set the value related to the column: OFFICER_MARRIED_E
	 * @param officerMarriedE the OFFICER_MARRIED_E value
	 */
	public void setOfficerMarriedE (java.lang.String officerMarriedE) {
		this.officerMarriedE = officerMarriedE;
	}



	/**
	 * Return the value associated with the column: OFFICER_MARRIED_D
	 */
	public java.lang.String getOfficerMarriedD () {
		return officerMarriedD;
	}

	/**
	 * Set the value related to the column: OFFICER_MARRIED_D
	 * @param officerMarriedD the OFFICER_MARRIED_D value
	 */
	public void setOfficerMarriedD (java.lang.String officerMarriedD) {
		this.officerMarriedD = officerMarriedD;
	}



	/**
	 * Return the value associated with the column: AIRMEN_SINGLE_E
	 */
	public java.lang.String getAirmenSingleE () {
		return airmenSingleE;
	}

	/**
	 * Set the value related to the column: AIRMEN_SINGLE_E
	 * @param airmenSingleE the AIRMEN_SINGLE_E value
	 */
	public void setAirmenSingleE (java.lang.String airmenSingleE) {
		this.airmenSingleE = airmenSingleE;
	}



	/**
	 * Return the value associated with the column: AIRMEN_SINGLE_D
	 */
	public java.lang.String getAirmenSingleD () {
		return airmenSingleD;
	}

	/**
	 * Set the value related to the column: AIRMEN_SINGLE_D
	 * @param airmenSingleD the AIRMEN_SINGLE_D value
	 */
	public void setAirmenSingleD (java.lang.String airmenSingleD) {
		this.airmenSingleD = airmenSingleD;
	}



	/**
	 * Return the value associated with the column: AIRMEN_MARRIED_E
	 */
	public java.lang.String getAirmenMarriedE () {
		return airmenMarriedE;
	}

	/**
	 * Set the value related to the column: AIRMEN_MARRIED_E
	 * @param airmenMarriedE the AIRMEN_MARRIED_E value
	 */
	public void setAirmenMarriedE (java.lang.String airmenMarriedE) {
		this.airmenMarriedE = airmenMarriedE;
	}



	/**
	 * Return the value associated with the column: AIRMEN_MARRIED_D
	 */
	public java.lang.String getAirmenMarriedD () {
		return airmenMarriedD;
	}

	/**
	 * Set the value related to the column: AIRMEN_MARRIED_D
	 * @param airmenMarriedD the AIRMEN_MARRIED_D value
	 */
	public void setAirmenMarriedD (java.lang.String airmenMarriedD) {
		this.airmenMarriedD = airmenMarriedD;
	}



	/**
	 * Return the value associated with the column: NCS_SINGLE_E
	 */
	public java.lang.String getNcsSingleE () {
		return ncsSingleE;
	}

	/**
	 * Set the value related to the column: NCS_SINGLE_E
	 * @param ncsSingleE the NCS_SINGLE_E value
	 */
	public void setNcsSingleE (java.lang.String ncsSingleE) {
		this.ncsSingleE = ncsSingleE;
	}



	/**
	 * Return the value associated with the column: NCS_SINGLE_D
	 */
	public java.lang.String getNcsSingleD () {
		return ncsSingleD;
	}

	/**
	 * Set the value related to the column: NCS_SINGLE_D
	 * @param ncsSingleD the NCS_SINGLE_D value
	 */
	public void setNcsSingleD (java.lang.String ncsSingleD) {
		this.ncsSingleD = ncsSingleD;
	}



	/**
	 * Return the value associated with the column: NCS_MARRIED_E
	 */
	public java.lang.String getNcsMarriedE () {
		return ncsMarriedE;
	}

	/**
	 * Set the value related to the column: NCS_MARRIED_E
	 * @param ncsMarriedE the NCS_MARRIED_E value
	 */
	public void setNcsMarriedE (java.lang.String ncsMarriedE) {
		this.ncsMarriedE = ncsMarriedE;
	}



	/**
	 * Return the value associated with the column: NCS_MARRIED_D
	 */
	public java.lang.String getNcsMarriedD () {
		return ncsMarriedD;
	}

	/**
	 * Set the value related to the column: NCS_MARRIED_D
	 * @param ncsMarriedD the NCS_MARRIED_D value
	 */
	public void setNcsMarriedD (java.lang.String ncsMarriedD) {
		this.ncsMarriedD = ncsMarriedD;
	}



	/**
	 * Return the value associated with the column: DSC_SINGLE_E
	 */
	public java.lang.String getDscSingleE () {
		return dscSingleE;
	}

	/**
	 * Set the value related to the column: DSC_SINGLE_E
	 * @param dscSingleE the DSC_SINGLE_E value
	 */
	public void setDscSingleE (java.lang.String dscSingleE) {
		this.dscSingleE = dscSingleE;
	}



	/**
	 * Return the value associated with the column: DSC_SINGLE_D
	 */
	public java.lang.String getDscSingleD () {
		return dscSingleD;
	}

	/**
	 * Set the value related to the column: DSC_SINGLE_D
	 * @param dscSingleD the DSC_SINGLE_D value
	 */
	public void setDscSingleD (java.lang.String dscSingleD) {
		this.dscSingleD = dscSingleD;
	}



	/**
	 * Return the value associated with the column: DSC_MARRIED_E
	 */
	public java.lang.String getDscMarriedE () {
		return dscMarriedE;
	}

	/**
	 * Set the value related to the column: DSC_MARRIED_E
	 * @param dscMarriedE the DSC_MARRIED_E value
	 */
	public void setDscMarriedE (java.lang.String dscMarriedE) {
		this.dscMarriedE = dscMarriedE;
	}



	/**
	 * Return the value associated with the column: DSC_MARRIED_D
	 */
	public java.lang.String getDscMarriedD () {
		return dscMarriedD;
	}

	/**
	 * Set the value related to the column: DSC_MARRIED_D
	 * @param dscMarriedD the DSC_MARRIED_D value
	 */
	public void setDscMarriedD (java.lang.String dscMarriedD) {
		this.dscMarriedD = dscMarriedD;
	}



	/**
	 * Return the value associated with the column: LIGHTING_ARRANGEMENT
	 */
	public java.lang.String getLightingArrangement () {
		return lightingArrangement;
	}

	/**
	 * Set the value related to the column: LIGHTING_ARRANGEMENT
	 * @param lightingArrangement the LIGHTING_ARRANGEMENT value
	 */
	public void setLightingArrangement (java.lang.String lightingArrangement) {
		this.lightingArrangement = lightingArrangement;
	}



	/**
	 * Return the value associated with the column: VENTILATION
	 */
	public java.lang.String getVentilation () {
		return ventilation;
	}

	/**
	 * Set the value related to the column: VENTILATION
	 * @param ventilation the VENTILATION value
	 */
	public void setVentilation (java.lang.String ventilation) {
		this.ventilation = ventilation;
	}



	/**
	 * Return the value associated with the column: COOLING_ARRANGEMENT
	 */
	public java.lang.String getCoolingArrangement () {
		return coolingArrangement;
	}

	/**
	 * Set the value related to the column: COOLING_ARRANGEMENT
	 * @param coolingArrangement the COOLING_ARRANGEMENT value
	 */
	public void setCoolingArrangement (java.lang.String coolingArrangement) {
		this.coolingArrangement = coolingArrangement;
	}



	/**
	 * Return the value associated with the column: HEATING_ARRANGEMENT
	 */
	public java.lang.String getHeatingArrangement () {
		return heatingArrangement;
	}

	/**
	 * Set the value related to the column: HEATING_ARRANGEMENT
	 * @param heatingArrangement the HEATING_ARRANGEMENT value
	 */
	public void setHeatingArrangement (java.lang.String heatingArrangement) {
		this.heatingArrangement = heatingArrangement;
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
	 * Return the value associated with the column: CURRENT_DATE
	 */
	public java.util.Date getCurrentDate () {
		return currentDate;
	}

	/**
	 * Set the value related to the column: CURRENT_DATE
	 * @param currentDate the CURRENT_DATE value
	 */
	public void setCurrentDate (java.util.Date currentDate) {
		this.currentDate = currentDate;
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
		if (!(obj instanceof jkt.hms.masters.business.ShoAccommodation)) return false;
		else {
			jkt.hms.masters.business.ShoAccommodation shoAccommodation = (jkt.hms.masters.business.ShoAccommodation) obj;
			if (null == this.getId() || null == shoAccommodation.getId()) return false;
			else return (this.getId().equals(shoAccommodation.getId()));
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
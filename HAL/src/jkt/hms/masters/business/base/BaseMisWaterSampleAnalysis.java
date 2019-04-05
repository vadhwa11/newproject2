package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the MIS_WATER_SAMPLE_ANALYSIS table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="MIS_WATER_SAMPLE_ANALYSIS"
 */

public abstract class BaseMisWaterSampleAnalysis  implements Serializable {

	public static String REF = "MisWaterSampleAnalysis";
	public static String PROP_SAMPLE_WATER_FROM = "SampleWaterFrom";
	public static String PROP_DEPTH_OF_WATER = "DepthOfWater";
	public static String PROP_DEPTH_OF_SURFACE = "DepthOfSurface";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_NATURE_AND_SOURCE_OF_WATER = "NatureAndSourceOfWater";
	public static String PROP_PRESENT_METEOROLOGICAL = "PresentMeteorological";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_DATE_HOUR_OF_SAMPLING = "DateHourOfSampling";
	public static String PROP_COVERING = "Covering";
	public static String PROP_COPING = "Coping";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_CLARIFICATION = "Clarification";
	public static String PROP_CHLORINATION_CARRIED_OUT_CPWD = "ChlorinationCarriedOutCpwd";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_STORED_SURFACE_WATER = "StoredSurfaceWater";
	public static String PROP_STAINING = "Staining";
	public static String PROP_NATURE_OF_EXAIM_REQRD = "NatureOfExaimReqrd";
	public static String PROP_STRATA_PENETRATED = "StrataPenetrated";
	public static String PROP_STATUS = "Status";
	public static String PROP_SOFTENING = "Softening";
	public static String PROP_BOILING = "Boiling";
	public static String PROP_ID = "Id";
	public static String PROP_RAISING_WATER = "RaisingWater";
	public static String PROP_GEOLOGICAL_STRATA = "GeologicalStrata";
	public static String PROP_NATURE_AND_DISTANCE = "NatureAndDistance";


	// constructors
	public BaseMisWaterSampleAnalysis () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMisWaterSampleAnalysis (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String natureAndDistance;
	private java.lang.String sampleWaterFrom;
	private java.lang.String natureOfExaimReqrd;
	private java.lang.String dateHourOfSampling;
	private java.lang.String natureAndSourceOfWater;
	private java.lang.String geologicalStrata;
	private java.lang.String depthOfWater;
	private java.lang.String depthOfSurface;
	private java.lang.String staining;
	private java.lang.String coping;
	private java.lang.String strataPenetrated;
	private java.lang.String covering;
	private java.lang.String raisingWater;
	private java.lang.String storedSurfaceWater;
	private java.lang.String presentMeteorological;
	private java.lang.String clarification;
	private java.lang.String boiling;
	private java.lang.String softening;
	private java.lang.String chlorinationCarriedOutCpwd;
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
     *  column="WSA_ID"
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
	 * Return the value associated with the column: NATURE_AND_DISTANCE
	 */
	public java.lang.String getNatureAndDistance () {
		return natureAndDistance;
	}

	/**
	 * Set the value related to the column: NATURE_AND_DISTANCE
	 * @param natureAndDistance the NATURE_AND_DISTANCE value
	 */
	public void setNatureAndDistance (java.lang.String natureAndDistance) {
		this.natureAndDistance = natureAndDistance;
	}



	/**
	 * Return the value associated with the column: SAMPLE_WATER_FROM
	 */
	public java.lang.String getSampleWaterFrom () {
		return sampleWaterFrom;
	}

	/**
	 * Set the value related to the column: SAMPLE_WATER_FROM
	 * @param sampleWaterFrom the SAMPLE_WATER_FROM value
	 */
	public void setSampleWaterFrom (java.lang.String sampleWaterFrom) {
		this.sampleWaterFrom = sampleWaterFrom;
	}



	/**
	 * Return the value associated with the column: NATURE_OF_EXAIM_REQRD
	 */
	public java.lang.String getNatureOfExaimReqrd () {
		return natureOfExaimReqrd;
	}

	/**
	 * Set the value related to the column: NATURE_OF_EXAIM_REQRD
	 * @param natureOfExaimReqrd the NATURE_OF_EXAIM_REQRD value
	 */
	public void setNatureOfExaimReqrd (java.lang.String natureOfExaimReqrd) {
		this.natureOfExaimReqrd = natureOfExaimReqrd;
	}



	/**
	 * Return the value associated with the column: DATE_HOUR_OF_SAMPLING
	 */
	public java.lang.String getDateHourOfSampling () {
		return dateHourOfSampling;
	}

	/**
	 * Set the value related to the column: DATE_HOUR_OF_SAMPLING
	 * @param dateHourOfSampling the DATE_HOUR_OF_SAMPLING value
	 */
	public void setDateHourOfSampling (java.lang.String dateHourOfSampling) {
		this.dateHourOfSampling = dateHourOfSampling;
	}



	/**
	 * Return the value associated with the column: NATURE_AND_SOURCE_OF_WATER
	 */
	public java.lang.String getNatureAndSourceOfWater () {
		return natureAndSourceOfWater;
	}

	/**
	 * Set the value related to the column: NATURE_AND_SOURCE_OF_WATER
	 * @param natureAndSourceOfWater the NATURE_AND_SOURCE_OF_WATER value
	 */
	public void setNatureAndSourceOfWater (java.lang.String natureAndSourceOfWater) {
		this.natureAndSourceOfWater = natureAndSourceOfWater;
	}



	/**
	 * Return the value associated with the column: GEOLOGICAL_STRATA
	 */
	public java.lang.String getGeologicalStrata () {
		return geologicalStrata;
	}

	/**
	 * Set the value related to the column: GEOLOGICAL_STRATA
	 * @param geologicalStrata the GEOLOGICAL_STRATA value
	 */
	public void setGeologicalStrata (java.lang.String geologicalStrata) {
		this.geologicalStrata = geologicalStrata;
	}



	/**
	 * Return the value associated with the column: DEPTH_OF_WATER
	 */
	public java.lang.String getDepthOfWater () {
		return depthOfWater;
	}

	/**
	 * Set the value related to the column: DEPTH_OF_WATER
	 * @param depthOfWater the DEPTH_OF_WATER value
	 */
	public void setDepthOfWater (java.lang.String depthOfWater) {
		this.depthOfWater = depthOfWater;
	}



	/**
	 * Return the value associated with the column: DEPTH_OF_SURFACE
	 */
	public java.lang.String getDepthOfSurface () {
		return depthOfSurface;
	}

	/**
	 * Set the value related to the column: DEPTH_OF_SURFACE
	 * @param depthOfSurface the DEPTH_OF_SURFACE value
	 */
	public void setDepthOfSurface (java.lang.String depthOfSurface) {
		this.depthOfSurface = depthOfSurface;
	}



	/**
	 * Return the value associated with the column: STAINING
	 */
	public java.lang.String getStaining () {
		return staining;
	}

	/**
	 * Set the value related to the column: STAINING
	 * @param staining the STAINING value
	 */
	public void setStaining (java.lang.String staining) {
		this.staining = staining;
	}



	/**
	 * Return the value associated with the column: COPING
	 */
	public java.lang.String getCoping () {
		return coping;
	}

	/**
	 * Set the value related to the column: COPING
	 * @param coping the COPING value
	 */
	public void setCoping (java.lang.String coping) {
		this.coping = coping;
	}



	/**
	 * Return the value associated with the column: STRATA_PENETRATED
	 */
	public java.lang.String getStrataPenetrated () {
		return strataPenetrated;
	}

	/**
	 * Set the value related to the column: STRATA_PENETRATED
	 * @param strataPenetrated the STRATA_PENETRATED value
	 */
	public void setStrataPenetrated (java.lang.String strataPenetrated) {
		this.strataPenetrated = strataPenetrated;
	}



	/**
	 * Return the value associated with the column: COVERING
	 */
	public java.lang.String getCovering () {
		return covering;
	}

	/**
	 * Set the value related to the column: COVERING
	 * @param covering the COVERING value
	 */
	public void setCovering (java.lang.String covering) {
		this.covering = covering;
	}



	/**
	 * Return the value associated with the column: RAISING_WATER
	 */
	public java.lang.String getRaisingWater () {
		return raisingWater;
	}

	/**
	 * Set the value related to the column: RAISING_WATER
	 * @param raisingWater the RAISING_WATER value
	 */
	public void setRaisingWater (java.lang.String raisingWater) {
		this.raisingWater = raisingWater;
	}



	/**
	 * Return the value associated with the column: STORED_SURFACE_WATER
	 */
	public java.lang.String getStoredSurfaceWater () {
		return storedSurfaceWater;
	}

	/**
	 * Set the value related to the column: STORED_SURFACE_WATER
	 * @param storedSurfaceWater the STORED_SURFACE_WATER value
	 */
	public void setStoredSurfaceWater (java.lang.String storedSurfaceWater) {
		this.storedSurfaceWater = storedSurfaceWater;
	}



	/**
	 * Return the value associated with the column: PRESENT_METEOROLOGICAL
	 */
	public java.lang.String getPresentMeteorological () {
		return presentMeteorological;
	}

	/**
	 * Set the value related to the column: PRESENT_METEOROLOGICAL
	 * @param presentMeteorological the PRESENT_METEOROLOGICAL value
	 */
	public void setPresentMeteorological (java.lang.String presentMeteorological) {
		this.presentMeteorological = presentMeteorological;
	}



	/**
	 * Return the value associated with the column: CLARIFICATION
	 */
	public java.lang.String getClarification () {
		return clarification;
	}

	/**
	 * Set the value related to the column: CLARIFICATION
	 * @param clarification the CLARIFICATION value
	 */
	public void setClarification (java.lang.String clarification) {
		this.clarification = clarification;
	}



	/**
	 * Return the value associated with the column: BOILING
	 */
	public java.lang.String getBoiling () {
		return boiling;
	}

	/**
	 * Set the value related to the column: BOILING
	 * @param boiling the BOILING value
	 */
	public void setBoiling (java.lang.String boiling) {
		this.boiling = boiling;
	}



	/**
	 * Return the value associated with the column: SOFTENING
	 */
	public java.lang.String getSoftening () {
		return softening;
	}

	/**
	 * Set the value related to the column: SOFTENING
	 * @param softening the SOFTENING value
	 */
	public void setSoftening (java.lang.String softening) {
		this.softening = softening;
	}



	/**
	 * Return the value associated with the column: CHLORINATION_CARRIED_OUT_CPWD
	 */
	public java.lang.String getChlorinationCarriedOutCpwd () {
		return chlorinationCarriedOutCpwd;
	}

	/**
	 * Set the value related to the column: CHLORINATION_CARRIED_OUT_CPWD
	 * @param chlorinationCarriedOutCpwd the CHLORINATION_CARRIED_OUT_CPWD value
	 */
	public void setChlorinationCarriedOutCpwd (java.lang.String chlorinationCarriedOutCpwd) {
		this.chlorinationCarriedOutCpwd = chlorinationCarriedOutCpwd;
	}



	/**
	 * Return the value associated with the column: STATUS
	 */
	public java.lang.String  getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: STATUS
	 * @param status the STATUS value
	 */
	public void setStatus (java.lang.String  status) {
		this.status = status;
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
		if (!(obj instanceof jkt.hms.masters.business.MisWaterSampleAnalysis)) return false;
		else {
			jkt.hms.masters.business.MisWaterSampleAnalysis misWaterSampleAnalysis = (jkt.hms.masters.business.MisWaterSampleAnalysis) obj;
			if (null == this.getId() || null == misWaterSampleAnalysis.getId()) return false;
			else return (this.getId().equals(misWaterSampleAnalysis.getId()));
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
package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SHO_SCHOOL_HEALTH table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="SHO_SCHOOL_HEALTH"
 */

public abstract class BaseShoSchoolHealth  implements Serializable {

	public static String REF = "ShoSchoolHealth";
	public static String PROP_SCHOOL_INSPECTION_DATE = "SchoolInspectionDate";
	public static String PROP_TA_CHILDREN = "taChildren";
	public static String PROP_ACTION_TAKEN = "ActionTaken";
	public static String PROP_DENTAL_CARRIED = "DentalCarried";
	public static String PROP_HEPATITIS_CHILDREN = "hepatitisChildren";
	public static String PROP_PULSE_POLIO_CHILDREN = "PulsePolioChildren";
	public static String PROP_DT_CHILDREN = "dtChildren";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_TT_CHILDREN = "ttChildren";
	public static String PROP_DPT_CHILDREN = "dptChildren";
	public static String PROP_LAST_UPDATED_DATE = "LastUpdatedDate";
	public static String PROP_UNIT = "Unit";
	public static String PROP_ANAEMIA = "Anaemia";
	public static String PROP_NO_OF_CHILDREN = "NoOfChildren";
	public static String PROP_BCG_CHILDREN = "BcgChildren";
	public static String PROP_OPV_CHILDREN = "opvChildren";
	public static String PROP_ID = "Id";
	public static String PROP_DEFECT_OF_CHILDREN = "DefectOfChildren";
	public static String PROP_MEASLES_CHILDREN = "measlesChildren";
	public static String PROP_WAX_EAR = "WaxEar";
	public static String PROP_REFRACTIVE_ERROR = "RefractiveError";


	// constructors
	public BaseShoSchoolHealth () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseShoSchoolHealth (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date schoolInspectionDate;
	private java.util.Date lastUpdatedDate;
	private java.lang.String noOfChildren;
	private java.lang.String defectOfChildren;
	private java.lang.String dentalCarried;
	private java.lang.String refractiveError;
	private java.lang.String anaemia;
	private java.lang.String waxEar;
	private java.lang.String actionTaken;
	private java.lang.String bcgChildren;
	private java.lang.String opvChildren;
	private java.lang.String dptChildren;
	private java.lang.String measlesChildren;
	private java.lang.String dtChildren;
	private java.lang.String taChildren;
	private java.lang.String ttChildren;
	private java.lang.String hepatitisChildren;
	private java.lang.String pulsePolioChildren;

	// many to one
	private jkt.hms.masters.business.MasUnit unit;
	private jkt.hms.masters.business.MasHospital hospital;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="SCHOOL_HEALTH_ID"
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
	 * Return the value associated with the column: SCHOOL_INSPECTION_DATE
	 */
	public java.util.Date getSchoolInspectionDate () {
		return schoolInspectionDate;
	}

	/**
	 * Set the value related to the column: SCHOOL_INSPECTION_DATE
	 * @param schoolInspectionDate the SCHOOL_INSPECTION_DATE value
	 */
	public void setSchoolInspectionDate (java.util.Date schoolInspectionDate) {
		this.schoolInspectionDate = schoolInspectionDate;
	}



	/**
	 * Return the value associated with the column: LAST_UPDATED_DATE
	 */
	public java.util.Date getLastUpdatedDate () {
		return lastUpdatedDate;
	}

	/**
	 * Set the value related to the column: LAST_UPDATED_DATE
	 * @param lastUpdatedDate the LAST_UPDATED_DATE value
	 */
	public void setLastUpdatedDate (java.util.Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}



	/**
	 * Return the value associated with the column: NO_OF_CHILDREN
	 */
	public java.lang.String getNoOfChildren () {
		return noOfChildren;
	}

	/**
	 * Set the value related to the column: NO_OF_CHILDREN
	 * @param noOfChildren the NO_OF_CHILDREN value
	 */
	public void setNoOfChildren (java.lang.String noOfChildren) {
		this.noOfChildren = noOfChildren;
	}



	/**
	 * Return the value associated with the column: DEFECT_OF_CHILDREN
	 */
	public java.lang.String getDefectOfChildren () {
		return defectOfChildren;
	}

	/**
	 * Set the value related to the column: DEFECT_OF_CHILDREN
	 * @param defectOfChildren the DEFECT_OF_CHILDREN value
	 */
	public void setDefectOfChildren (java.lang.String defectOfChildren) {
		this.defectOfChildren = defectOfChildren;
	}



	/**
	 * Return the value associated with the column: DENTAL_CARRIED
	 */
	public java.lang.String getDentalCarried () {
		return dentalCarried;
	}

	/**
	 * Set the value related to the column: DENTAL_CARRIED
	 * @param dentalCarried the DENTAL_CARRIED value
	 */
	public void setDentalCarried (java.lang.String dentalCarried) {
		this.dentalCarried = dentalCarried;
	}



	/**
	 * Return the value associated with the column: REFRACTIVE_ERROR
	 */
	public java.lang.String getRefractiveError () {
		return refractiveError;
	}

	/**
	 * Set the value related to the column: REFRACTIVE_ERROR
	 * @param refractiveError the REFRACTIVE_ERROR value
	 */
	public void setRefractiveError (java.lang.String refractiveError) {
		this.refractiveError = refractiveError;
	}



	/**
	 * Return the value associated with the column: ANAEMIA
	 */
	public java.lang.String getAnaemia () {
		return anaemia;
	}

	/**
	 * Set the value related to the column: ANAEMIA
	 * @param anaemia the ANAEMIA value
	 */
	public void setAnaemia (java.lang.String anaemia) {
		this.anaemia = anaemia;
	}



	/**
	 * Return the value associated with the column: WAX_EAR
	 */
	public java.lang.String getWaxEar () {
		return waxEar;
	}

	/**
	 * Set the value related to the column: WAX_EAR
	 * @param waxEar the WAX_EAR value
	 */
	public void setWaxEar (java.lang.String waxEar) {
		this.waxEar = waxEar;
	}



	/**
	 * Return the value associated with the column: ACTION_TAKEN
	 */
	public java.lang.String getActionTaken () {
		return actionTaken;
	}

	/**
	 * Set the value related to the column: ACTION_TAKEN
	 * @param actionTaken the ACTION_TAKEN value
	 */
	public void setActionTaken (java.lang.String actionTaken) {
		this.actionTaken = actionTaken;
	}



	/**
	 * Return the value associated with the column: BCG_CHILDREN
	 */
	public java.lang.String getBcgChildren () {
		return bcgChildren;
	}

	/**
	 * Set the value related to the column: BCG_CHILDREN
	 * @param bcgChildren the BCG_CHILDREN value
	 */
	public void setBcgChildren (java.lang.String bcgChildren) {
		this.bcgChildren = bcgChildren;
	}



	/**
	 * Return the value associated with the column: OPV_CHILDREN
	 */
	public java.lang.String getOpvChildren () {
		return opvChildren;
	}

	/**
	 * Set the value related to the column: OPV_CHILDREN
	 * @param opvChildren the OPV_CHILDREN value
	 */
	public void setOpvChildren (java.lang.String opvChildren) {
		this.opvChildren = opvChildren;
	}



	/**
	 * Return the value associated with the column: DPT_CHILDREN
	 */
	public java.lang.String getDptChildren () {
		return dptChildren;
	}

	/**
	 * Set the value related to the column: DPT_CHILDREN
	 * @param dptChildren the DPT_CHILDREN value
	 */
	public void setDptChildren (java.lang.String dptChildren) {
		this.dptChildren = dptChildren;
	}



	/**
	 * Return the value associated with the column: MEASLES_CHILDREN
	 */
	public java.lang.String getMeaslesChildren () {
		return measlesChildren;
	}

	/**
	 * Set the value related to the column: MEASLES_CHILDREN
	 * @param measlesChildren the MEASLES_CHILDREN value
	 */
	public void setMeaslesChildren (java.lang.String measlesChildren) {
		this.measlesChildren = measlesChildren;
	}



	/**
	 * Return the value associated with the column: DT_CHILDREN
	 */
	public java.lang.String getDtChildren () {
		return dtChildren;
	}

	/**
	 * Set the value related to the column: DT_CHILDREN
	 * @param dtChildren the DT_CHILDREN value
	 */
	public void setDtChildren (java.lang.String dtChildren) {
		this.dtChildren = dtChildren;
	}



	/**
	 * Return the value associated with the column: TA_CHILDREN
	 */
	public java.lang.String getTaChildren () {
		return taChildren;
	}

	/**
	 * Set the value related to the column: TA_CHILDREN
	 * @param taChildren the TA_CHILDREN value
	 */
	public void setTaChildren (java.lang.String taChildren) {
		this.taChildren = taChildren;
	}



	/**
	 * Return the value associated with the column: TT_CHILDREN
	 */
	public java.lang.String getTtChildren () {
		return ttChildren;
	}

	/**
	 * Set the value related to the column: TT_CHILDREN
	 * @param ttChildren the TT_CHILDREN value
	 */
	public void setTtChildren (java.lang.String ttChildren) {
		this.ttChildren = ttChildren;
	}



	/**
	 * Return the value associated with the column: HEPATITIS_CHILDREN
	 */
	public java.lang.String getHepatitisChildren () {
		return hepatitisChildren;
	}

	/**
	 * Set the value related to the column: HEPATITIS_CHILDREN
	 * @param hepatitisChildren the HEPATITIS_CHILDREN value
	 */
	public void setHepatitisChildren (java.lang.String hepatitisChildren) {
		this.hepatitisChildren = hepatitisChildren;
	}



	/**
	 * Return the value associated with the column: PULSE_POLIO_CHILDREN
	 */
	public java.lang.String getPulsePolioChildren () {
		return pulsePolioChildren;
	}

	/**
	 * Set the value related to the column: PULSE_POLIO_CHILDREN
	 * @param pulsePolioChildren the PULSE_POLIO_CHILDREN value
	 */
	public void setPulsePolioChildren (java.lang.String pulsePolioChildren) {
		this.pulsePolioChildren = pulsePolioChildren;
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
		if (!(obj instanceof jkt.hms.masters.business.ShoSchoolHealth)) return false;
		else {
			jkt.hms.masters.business.ShoSchoolHealth shoSchoolHealth = (jkt.hms.masters.business.ShoSchoolHealth) obj;
			if (null == this.getId() || null == shoSchoolHealth.getId()) return false;
			else return (this.getId().equals(shoSchoolHealth.getId()));
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
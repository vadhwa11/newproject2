package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SANITARY_ROUND table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="SANITARY_ROUND"
 */

public abstract class BaseSanitaryRound  implements Serializable {

	public static String REF = "SanitaryRound";
	public static String PROP_SANITARY_PLACE = "SanitaryPlace";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_SANITARY_ROUND_DATE = "SanitaryRoundDate";
	public static String PROP_REMARKS_BY_SHO = "RemarksBySho";
	public static String PROP_SUGGESTION = "Suggestion";
	public static String PROP_REMARKS_BY_OFFICER_IN_CHARGE = "RemarksByOfficerInCharge";
	public static String PROP_REMARKS_BY_CADMO = "RemarksByCadmo";
	public static String PROP_SANITARY_AREA = "SanitaryArea";
	public static String PROP_OBSERVATION = "Observation";
	public static String PROP_REMARKS_BY_STD_CDR_AOC = "RemarksByStdCdrAoc";
	public static String PROP_REMARKS_BY_SR_MEDOFFICER = "RemarksBySrMedofficer";
	public static String PROP_ROUND_TYPE = "RoundType";
	public static String PROP_STATUS = "Status";
	public static String PROP_CLASSIFICATION = "Classification";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT_ID = "DepartmentId";
	public static String PROP_HIN_ID = "HinId";


	// constructors
	public BaseSanitaryRound () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSanitaryRound (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String classification;
	private java.lang.String observation;
	private java.lang.String remarksByCadmo;
	private java.lang.String remarksByOfficerInCharge;
	private java.lang.String remarksBySho;
	private java.lang.String remarksBySrMedofficer;
	private java.lang.String remarksByStdCdrAoc;
	private java.lang.String roundType;
	private java.lang.String sanitaryArea;
	private java.lang.String sanitaryPlace;
	private java.util.Date sanitaryRoundDate;
	private java.lang.String status;
	private java.lang.String suggestion;

	// many to one
	private jkt.hms.masters.business.MasDepartment departmentId;
	private jkt.hms.masters.business.Patient hinId;
	private jkt.hms.masters.business.MasHospital hospitalId;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="ID"
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
	 * Return the value associated with the column: CLASSIFICATION
	 */
	public java.lang.String getClassification () {
		return classification;
	}

	/**
	 * Set the value related to the column: CLASSIFICATION
	 * @param classification the CLASSIFICATION value
	 */
	public void setClassification (java.lang.String classification) {
		this.classification = classification;
	}



	/**
	 * Return the value associated with the column: OBSERVATION
	 */
	public java.lang.String getObservation () {
		return observation;
	}

	/**
	 * Set the value related to the column: OBSERVATION
	 * @param observation the OBSERVATION value
	 */
	public void setObservation (java.lang.String observation) {
		this.observation = observation;
	}



	/**
	 * Return the value associated with the column: REMARKS_BY_CADMO
	 */
	public java.lang.String getRemarksByCadmo () {
		return remarksByCadmo;
	}

	/**
	 * Set the value related to the column: REMARKS_BY_CADMO
	 * @param remarksByCadmo the REMARKS_BY_CADMO value
	 */
	public void setRemarksByCadmo (java.lang.String remarksByCadmo) {
		this.remarksByCadmo = remarksByCadmo;
	}



	/**
	 * Return the value associated with the column: REMARKS_BY_OFFICER_IN_CHARGE
	 */
	public java.lang.String getRemarksByOfficerInCharge () {
		return remarksByOfficerInCharge;
	}

	/**
	 * Set the value related to the column: REMARKS_BY_OFFICER_IN_CHARGE
	 * @param remarksByOfficerInCharge the REMARKS_BY_OFFICER_IN_CHARGE value
	 */
	public void setRemarksByOfficerInCharge (java.lang.String remarksByOfficerInCharge) {
		this.remarksByOfficerInCharge = remarksByOfficerInCharge;
	}



	/**
	 * Return the value associated with the column: REMARKS_BY_SHO
	 */
	public java.lang.String getRemarksBySho () {
		return remarksBySho;
	}

	/**
	 * Set the value related to the column: REMARKS_BY_SHO
	 * @param remarksBySho the REMARKS_BY_SHO value
	 */
	public void setRemarksBySho (java.lang.String remarksBySho) {
		this.remarksBySho = remarksBySho;
	}



	/**
	 * Return the value associated with the column: REMARKS_BY_SR_MEDOFFICER
	 */
	public java.lang.String getRemarksBySrMedofficer () {
		return remarksBySrMedofficer;
	}

	/**
	 * Set the value related to the column: REMARKS_BY_SR_MEDOFFICER
	 * @param remarksBySrMedofficer the REMARKS_BY_SR_MEDOFFICER value
	 */
	public void setRemarksBySrMedofficer (java.lang.String remarksBySrMedofficer) {
		this.remarksBySrMedofficer = remarksBySrMedofficer;
	}



	/**
	 * Return the value associated with the column: REMARKS_BY_STD_CDR_AOC
	 */
	public java.lang.String getRemarksByStdCdrAoc () {
		return remarksByStdCdrAoc;
	}

	/**
	 * Set the value related to the column: REMARKS_BY_STD_CDR_AOC
	 * @param remarksByStdCdrAoc the REMARKS_BY_STD_CDR_AOC value
	 */
	public void setRemarksByStdCdrAoc (java.lang.String remarksByStdCdrAoc) {
		this.remarksByStdCdrAoc = remarksByStdCdrAoc;
	}



	/**
	 * Return the value associated with the column: ROUND_TYPE
	 */
	public java.lang.String getRoundType () {
		return roundType;
	}

	/**
	 * Set the value related to the column: ROUND_TYPE
	 * @param roundType the ROUND_TYPE value
	 */
	public void setRoundType (java.lang.String roundType) {
		this.roundType = roundType;
	}



	/**
	 * Return the value associated with the column: SANITARY_AREA
	 */
	public java.lang.String getSanitaryArea () {
		return sanitaryArea;
	}

	/**
	 * Set the value related to the column: SANITARY_AREA
	 * @param sanitaryArea the SANITARY_AREA value
	 */
	public void setSanitaryArea (java.lang.String sanitaryArea) {
		this.sanitaryArea = sanitaryArea;
	}



	/**
	 * Return the value associated with the column: SANITARY_PLACE
	 */
	public java.lang.String getSanitaryPlace () {
		return sanitaryPlace;
	}

	/**
	 * Set the value related to the column: SANITARY_PLACE
	 * @param sanitaryPlace the SANITARY_PLACE value
	 */
	public void setSanitaryPlace (java.lang.String sanitaryPlace) {
		this.sanitaryPlace = sanitaryPlace;
	}



	/**
	 * Return the value associated with the column: SANITARY_ROUND_DATE
	 */
	public java.util.Date getSanitaryRoundDate () {
		return sanitaryRoundDate;
	}

	/**
	 * Set the value related to the column: SANITARY_ROUND_DATE
	 * @param sanitaryRoundDate the SANITARY_ROUND_DATE value
	 */
	public void setSanitaryRoundDate (java.util.Date sanitaryRoundDate) {
		this.sanitaryRoundDate = sanitaryRoundDate;
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
	 * Return the value associated with the column: SUGGESTION
	 */
	public java.lang.String getSuggestion () {
		return suggestion;
	}

	/**
	 * Set the value related to the column: SUGGESTION
	 * @param suggestion the SUGGESTION value
	 */
	public void setSuggestion (java.lang.String suggestion) {
		this.suggestion = suggestion;
	}



	/**
	 * Return the value associated with the column: DEPARTMENT_ID
	 */
	public jkt.hms.masters.business.MasDepartment getDepartmentId () {
		return departmentId;
	}

	/**
	 * Set the value related to the column: DEPARTMENT_ID
	 * @param departmentId the DEPARTMENT_ID value
	 */
	public void setDepartmentId (jkt.hms.masters.business.MasDepartment departmentId) {
		this.departmentId = departmentId;
	}



	/**
	 * Return the value associated with the column: HIN_ID
	 */
	public jkt.hms.masters.business.Patient getHinId () {
		return hinId;
	}

	/**
	 * Set the value related to the column: HIN_ID
	 * @param hinId the HIN_ID value
	 */
	public void setHinId (jkt.hms.masters.business.Patient hinId) {
		this.hinId = hinId;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.SanitaryRound)) return false;
		else {
			jkt.hms.masters.business.SanitaryRound sanitaryRound = (jkt.hms.masters.business.SanitaryRound) obj;
			if (null == this.getId() || null == sanitaryRound.getId()) return false;
			else return (this.getId().equals(sanitaryRound.getId()));
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
package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the opd_vaccin_mst table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="opd_vaccin_mst"
 */

public abstract class BaseOpdVaccinMst  implements Serializable {

	public static String REF = "OpdVaccinMst";
	public static String PROP_DOSE = "Dose";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_VACCIN_CODE = "VaccinCode";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_MAS_STORE_ITEM = "MasStoreItem";
	public static String PROP_VACCIN_DURATION = "VaccinDuration";
	public static String PROP_GENDER = "Gender";
	public static String PROP_VACCIN_TO_DAYS = "VaccinToDays";
	public static String PROP_ID = "Id";
	public static String PROP_VACCIN_TYPE = "VaccinType";
	public static String PROP_VACCIN_NAME = "VaccinName";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_SR_NO = "SrNo";


	// constructors
	public BaseOpdVaccinMst () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOpdVaccinMst (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String vaccinCode;
	private java.lang.String vaccinName;
	private java.lang.Integer vaccinDuration;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.Integer dose;
	private java.lang.Integer vaccinToDays;
	private java.lang.Integer srNo;
	private java.lang.String vaccinType;

	// many to one
	private jkt.hms.masters.business.MasStoreItem masStoreItem;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasAdministrativeSex gender;

	// collections
	private java.util.Set<jkt.hms.masters.business.OpdVaccinationPlan> opdVaccinationPlans;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="vaccin_id"
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
	 * Return the value associated with the column: vaccin_code
	 */
	public java.lang.String getVaccinCode () {
		return vaccinCode;
	}

	/**
	 * Set the value related to the column: vaccin_code
	 * @param vaccinCode the vaccin_code value
	 */
	public void setVaccinCode (java.lang.String vaccinCode) {
		this.vaccinCode = vaccinCode;
	}



	/**
	 * Return the value associated with the column: vaccin_name
	 */
	public java.lang.String getVaccinName () {
		return vaccinName;
	}

	/**
	 * Set the value related to the column: vaccin_name
	 * @param vaccinName the vaccin_name value
	 */
	public void setVaccinName (java.lang.String vaccinName) {
		this.vaccinName = vaccinName;
	}



	/**
	 * Return the value associated with the column: vaccin_duration
	 */
	public java.lang.Integer getVaccinDuration () {
		return vaccinDuration;
	}

	/**
	 * Set the value related to the column: vaccin_duration
	 * @param vaccinDuration the vaccin_duration value
	 */
	public void setVaccinDuration (java.lang.Integer vaccinDuration) {
		this.vaccinDuration = vaccinDuration;
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
	 * Return the value associated with the column: dose
	 */
	public java.lang.Integer getDose () {
		return dose;
	}

	/**
	 * Set the value related to the column: dose
	 * @param dose the dose value
	 */
	public void setDose (java.lang.Integer dose) {
		this.dose = dose;
	}



	/**
	 * Return the value associated with the column: vaccin_to_days
	 */
	public java.lang.Integer getVaccinToDays () {
		return vaccinToDays;
	}

	/**
	 * Set the value related to the column: vaccin_to_days
	 * @param vaccinToDays the vaccin_to_days value
	 */
	public void setVaccinToDays (java.lang.Integer vaccinToDays) {
		this.vaccinToDays = vaccinToDays;
	}



	/**
	 * Return the value associated with the column: sr_no
	 */
	public java.lang.Integer getSrNo () {
		return srNo;
	}

	/**
	 * Set the value related to the column: sr_no
	 * @param srNo the sr_no value
	 */
	public void setSrNo (java.lang.Integer srNo) {
		this.srNo = srNo;
	}



	/**
	 * Return the value associated with the column: vaccin_type
	 */
	public java.lang.String getVaccinType () {
		return vaccinType;
	}

	/**
	 * Set the value related to the column: vaccin_type
	 * @param vaccinType the vaccin_type value
	 */
	public void setVaccinType (java.lang.String vaccinType) {
		this.vaccinType = vaccinType;
	}



	/**
	 * Return the value associated with the column: mas_store_item_id
	 */
	public jkt.hms.masters.business.MasStoreItem getMasStoreItem () {
		return masStoreItem;
	}

	/**
	 * Set the value related to the column: mas_store_item_id
	 * @param masStoreItem the mas_store_item_id value
	 */
	public void setMasStoreItem (jkt.hms.masters.business.MasStoreItem masStoreItem) {
		this.masStoreItem = masStoreItem;
	}



	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public jkt.hms.masters.business.Users getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (jkt.hms.masters.business.Users lastChgBy) {
		this.lastChgBy = lastChgBy;
	}



	/**
	 * Return the value associated with the column: gender_id
	 */
	public jkt.hms.masters.business.MasAdministrativeSex getGender () {
		return gender;
	}

	/**
	 * Set the value related to the column: gender_id
	 * @param gender the gender_id value
	 */
	public void setGender (jkt.hms.masters.business.MasAdministrativeSex gender) {
		this.gender = gender;
	}



	/**
	 * Return the value associated with the column: OpdVaccinationPlans
	 */
	public java.util.Set<jkt.hms.masters.business.OpdVaccinationPlan> getOpdVaccinationPlans () {
		return opdVaccinationPlans;
	}

	/**
	 * Set the value related to the column: OpdVaccinationPlans
	 * @param opdVaccinationPlans the OpdVaccinationPlans value
	 */
	public void setOpdVaccinationPlans (java.util.Set<jkt.hms.masters.business.OpdVaccinationPlan> opdVaccinationPlans) {
		this.opdVaccinationPlans = opdVaccinationPlans;
	}

	public void addToOpdVaccinationPlans (jkt.hms.masters.business.OpdVaccinationPlan opdVaccinationPlan) {
		if (null == getOpdVaccinationPlans()) setOpdVaccinationPlans(new java.util.TreeSet<jkt.hms.masters.business.OpdVaccinationPlan>());
		getOpdVaccinationPlans().add(opdVaccinationPlan);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.OpdVaccinMst)) return false;
		else {
			jkt.hms.masters.business.OpdVaccinMst opdVaccinMst = (jkt.hms.masters.business.OpdVaccinMst) obj;
			if (null == this.getId() || null == opdVaccinMst.getId()) return false;
			else return (this.getId().equals(opdVaccinMst.getId()));
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
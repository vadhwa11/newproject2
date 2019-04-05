package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the PREVENTABLE_DISEASE_ENTRY table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="PREVENTABLE_DISEASE_ENTRY"
 */

public abstract class BasePreventableDiseaseEntry  implements Serializable {

	public static String REF = "PreventableDiseaseEntry";
	public static String PROP_FLYING_ACCIDENT = "FlyingAccident";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_GAMES_ACCIDENT = "GamesAccident";
	public static String PROP_MECHANICAL_TRANSPORT_ACCIDENT = "MechanicalTransportAccident";
	public static String PROP_PREVENT_DATE = "PreventDate";
	public static String PROP_PREVENTABLE_DISEASE_NAME = "PreventableDiseaseName";
	public static String PROP_REASON_FOR_INCREASE_IN_ACC = "ReasonForIncreaseInAcc";
	public static String PROP_HOSPITAL_ID = "Hospital_Id";
	public static String PROP_PRESENT_QUARTER = "PresentQuarter";
	public static String PROP_LAST_QUARTER = "LastQuarter";
	public static String PROP_ID = "Id";
	public static String PROP_TWO_WHEELER_ACCIDENT = "TwoWheelerAccident";
	public static String PROP_OTHER_ACCIDENT = "OtherAccident";


	// constructors
	public BasePreventableDiseaseEntry () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePreventableDiseaseEntry (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String preventableDiseaseName;
	private java.lang.Integer presentQuarter;
	private java.lang.Integer lastQuarter;
	private java.lang.String remarks;
	private java.lang.String flyingAccident;
	private java.lang.String gamesAccident;
	private java.lang.String twoWheelerAccident;
	private java.lang.String mechanicalTransportAccident;
	private java.lang.String otherAccident;
	private java.lang.String reasonForIncreaseInAcc;
	private java.util.Date preventDate;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital_Id;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="PREVENTABLE_DISEASE_ID"
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
	 * Return the value associated with the column: PREVENTABLE_DISEASE_NAME
	 */
	public java.lang.String getPreventableDiseaseName () {
		return preventableDiseaseName;
	}

	/**
	 * Set the value related to the column: PREVENTABLE_DISEASE_NAME
	 * @param preventableDiseaseName the PREVENTABLE_DISEASE_NAME value
	 */
	public void setPreventableDiseaseName (java.lang.String preventableDiseaseName) {
		this.preventableDiseaseName = preventableDiseaseName;
	}



	/**
	 * Return the value associated with the column: PRESENT_QUARTER
	 */
	public java.lang.Integer getPresentQuarter () {
		return presentQuarter;
	}

	/**
	 * Set the value related to the column: PRESENT_QUARTER
	 * @param presentQuarter the PRESENT_QUARTER value
	 */
	public void setPresentQuarter (java.lang.Integer presentQuarter) {
		this.presentQuarter = presentQuarter;
	}



	/**
	 * Return the value associated with the column: LAST_QUARTER
	 */
	public java.lang.Integer getLastQuarter () {
		return lastQuarter;
	}

	/**
	 * Set the value related to the column: LAST_QUARTER
	 * @param lastQuarter the LAST_QUARTER value
	 */
	public void setLastQuarter (java.lang.Integer lastQuarter) {
		this.lastQuarter = lastQuarter;
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
	 * Return the value associated with the column: FLYING_ACCIDENT
	 */
	public java.lang.String getFlyingAccident () {
		return flyingAccident;
	}

	/**
	 * Set the value related to the column: FLYING_ACCIDENT
	 * @param flyingAccident the FLYING_ACCIDENT value
	 */
	public void setFlyingAccident (java.lang.String flyingAccident) {
		this.flyingAccident = flyingAccident;
	}



	/**
	 * Return the value associated with the column: GAMES_ACCIDENT
	 */
	public java.lang.String getGamesAccident () {
		return gamesAccident;
	}

	/**
	 * Set the value related to the column: GAMES_ACCIDENT
	 * @param gamesAccident the GAMES_ACCIDENT value
	 */
	public void setGamesAccident (java.lang.String gamesAccident) {
		this.gamesAccident = gamesAccident;
	}



	/**
	 * Return the value associated with the column: TWO_WHEELER_ACCIDENT
	 */
	public java.lang.String getTwoWheelerAccident () {
		return twoWheelerAccident;
	}

	/**
	 * Set the value related to the column: TWO_WHEELER_ACCIDENT
	 * @param twoWheelerAccident the TWO_WHEELER_ACCIDENT value
	 */
	public void setTwoWheelerAccident (java.lang.String twoWheelerAccident) {
		this.twoWheelerAccident = twoWheelerAccident;
	}



	/**
	 * Return the value associated with the column: MECHANICAL_TRANSPORT_ACCIDENT
	 */
	public java.lang.String getMechanicalTransportAccident () {
		return mechanicalTransportAccident;
	}

	/**
	 * Set the value related to the column: MECHANICAL_TRANSPORT_ACCIDENT
	 * @param mechanicalTransportAccident the MECHANICAL_TRANSPORT_ACCIDENT value
	 */
	public void setMechanicalTransportAccident (java.lang.String mechanicalTransportAccident) {
		this.mechanicalTransportAccident = mechanicalTransportAccident;
	}



	/**
	 * Return the value associated with the column: OTHER_ACCIDENT
	 */
	public java.lang.String getOtherAccident () {
		return otherAccident;
	}

	/**
	 * Set the value related to the column: OTHER_ACCIDENT
	 * @param otherAccident the OTHER_ACCIDENT value
	 */
	public void setOtherAccident (java.lang.String otherAccident) {
		this.otherAccident = otherAccident;
	}



	/**
	 * Return the value associated with the column: REASON_FOR_INCREASE_IN_ACC
	 */
	public java.lang.String getReasonForIncreaseInAcc () {
		return reasonForIncreaseInAcc;
	}

	/**
	 * Set the value related to the column: REASON_FOR_INCREASE_IN_ACC
	 * @param reasonForIncreaseInAcc the REASON_FOR_INCREASE_IN_ACC value
	 */
	public void setReasonForIncreaseInAcc (java.lang.String reasonForIncreaseInAcc) {
		this.reasonForIncreaseInAcc = reasonForIncreaseInAcc;
	}



	/**
	 * Return the value associated with the column: PREVENT_DATE
	 */
	public java.util.Date getPreventDate () {
		return preventDate;
	}

	/**
	 * Set the value related to the column: PREVENT_DATE
	 * @param preventDate the PREVENT_DATE value
	 */
	public void setPreventDate (java.util.Date preventDate) {
		this.preventDate = preventDate;
	}



	/**
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital_Id () {
		return hospital_Id;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * @param hospital_Id the hospital_id value
	 */
	public void setHospital_Id (jkt.hms.masters.business.MasHospital hospital_Id) {
		this.hospital_Id = hospital_Id;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PreventableDiseaseEntry)) return false;
		else {
			jkt.hms.masters.business.PreventableDiseaseEntry preventableDiseaseEntry = (jkt.hms.masters.business.PreventableDiseaseEntry) obj;
			if (null == this.getId() || null == preventableDiseaseEntry.getId()) return false;
			else return (this.getId().equals(preventableDiseaseEntry.getId()));
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
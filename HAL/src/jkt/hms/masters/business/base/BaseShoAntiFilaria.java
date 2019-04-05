package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SHO_ANTI_FILARIA table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="SHO_ANTI_FILARIA"
 */

public abstract class BaseShoAntiFilaria  implements Serializable {

	public static String REF = "ShoAntiFilaria";
	public static String PROP_FLY_PROOFING = "FlyProofing";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_FREQUENCY_OF_INSECTICIDE = "FrequencyOfInsecticide";
	public static String PROP_CURRENT_DATE = "CurrentDate";
	public static String PROP_ID = "Id";
	public static String PROP_DISPOSAL_OF_REFUSE = "DisposalOfRefuse";
	public static String PROP_LAST_UPDATED_DATE = "LastUpdatedDate";
	public static String PROP_ANTI_FILARIA_ID = "AntiFilariaId";


	// constructors
	public BaseShoAntiFilaria () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseShoAntiFilaria (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseShoAntiFilaria (
		java.lang.Integer id,
		java.lang.Integer antiFilariaId) {

		this.setId(id);
		this.setAntiFilariaId(antiFilariaId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer antiFilariaId;
	private java.util.Date currentDate;
	private java.util.Date lastUpdatedDate;
	private java.lang.String flyProofing;
	private java.lang.String disposalOfRefuse;
	private java.lang.String frequencyOfInsecticide;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="ANTI_FILARIA_ID"
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
	 * Return the value associated with the column: ANTI_FILARIA_ID
	 */
	public java.lang.Integer getAntiFilariaId () {
		return antiFilariaId;
	}

	/**
	 * Set the value related to the column: ANTI_FILARIA_ID
	 * @param antiFilariaId the ANTI_FILARIA_ID value
	 */
	public void setAntiFilariaId (java.lang.Integer antiFilariaId) {
		this.antiFilariaId = antiFilariaId;
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
	 * Return the value associated with the column: FLY_PROOFING
	 */
	public java.lang.String getFlyProofing () {
		return flyProofing;
	}

	/**
	 * Set the value related to the column: FLY_PROOFING
	 * @param flyProofing the FLY_PROOFING value
	 */
	public void setFlyProofing (java.lang.String flyProofing) {
		this.flyProofing = flyProofing;
	}



	/**
	 * Return the value associated with the column: DISPOSAL_OF_REFUSE
	 */
	public java.lang.String getDisposalOfRefuse () {
		return disposalOfRefuse;
	}

	/**
	 * Set the value related to the column: DISPOSAL_OF_REFUSE
	 * @param disposalOfRefuse the DISPOSAL_OF_REFUSE value
	 */
	public void setDisposalOfRefuse (java.lang.String disposalOfRefuse) {
		this.disposalOfRefuse = disposalOfRefuse;
	}



	/**
	 * Return the value associated with the column: FREQUENCY_OF_INSECTICIDE
	 */
	public java.lang.String getFrequencyOfInsecticide () {
		return frequencyOfInsecticide;
	}

	/**
	 * Set the value related to the column: FREQUENCY_OF_INSECTICIDE
	 * @param frequencyOfInsecticide the FREQUENCY_OF_INSECTICIDE value
	 */
	public void setFrequencyOfInsecticide (java.lang.String frequencyOfInsecticide) {
		this.frequencyOfInsecticide = frequencyOfInsecticide;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.ShoAntiFilaria)) return false;
		else {
			jkt.hms.masters.business.ShoAntiFilaria shoAntiFilaria = (jkt.hms.masters.business.ShoAntiFilaria) obj;
			if (null == this.getId() || null == shoAntiFilaria.getId()) return false;
			else return (this.getId().equals(shoAntiFilaria.getId()));
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
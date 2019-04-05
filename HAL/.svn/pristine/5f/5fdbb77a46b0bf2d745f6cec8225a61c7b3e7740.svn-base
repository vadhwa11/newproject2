package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SHO_OFFICER_DETAILS table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="SHO_OFFICER_DETAILS"
 */

public abstract class BaseShoOfficerDetails  implements Serializable {

	public static String REF = "ShoOfficerDetails";
	public static String PROP_MULTI_BACILLARY = "MultiBacillary";
	public static String PROP_OTHER_VIRAL = "OtherViral";
	public static String PROP_AIRMEN_GLAUCOMA = "AirmenGlaucoma";
	public static String PROP_FAMILY_GLAUCOMA = "FamilyGlaucoma";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_SERVICEMEN_GLAUCOMA = "ServicemenGlaucoma";
	public static String PROP_AIRMEN_CATARACT = "AirmenCataract";
	public static String PROP_LAST_UPDATED_DATE = "LastUpdatedDate";
	public static String PROP_OFFICER_CATARACT = "OfficerCataract";
	public static String PROP_UNIT = "Unit";
	public static String PROP_FAMILY_CATARACT = "FamilyCataract";
	public static String PROP_TOTAL_DOSES = "TotalDoses";
	public static String PROP_OFFICER_GLAUCOMA = "OfficerGlaucoma";
	public static String PROP_NO_OF_DOG_BITE = "NoOfDogBite";
	public static String PROP_CURRENT_DATE = "CurrentDate";
	public static String PROP_SERVICEMEN_CATARACT = "ServicemenCataract";
	public static String PROP_ID = "Id";
	public static String PROP_PAUCI_BACILLARY = "PauciBacillary";
	public static String PROP_HEPATITIS_VIRAL = "HepatitisViral";


	// constructors
	public BaseShoOfficerDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseShoOfficerDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date currentDate;
	private java.util.Date lastUpdatedDate;
	private java.lang.String officerCataract;
	private java.lang.String officerGlaucoma;
	private java.lang.String airmenCataract;
	private java.lang.String airmenGlaucoma;
	private java.lang.String familyCataract;
	private java.lang.String familyGlaucoma;
	private java.lang.String servicemenCataract;
	private java.lang.String servicemenGlaucoma;
	private java.lang.String multiBacillary;
	private java.lang.String pauciBacillary;
	private java.lang.String hepatitisViral;
	private java.lang.String otherViral;
	private java.lang.String noOfDogBite;
	private java.lang.String totalDoses;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasUnit unit;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="OFFICER_ID"
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
	 * Return the value associated with the column: OFFICER_CATARACT
	 */
	public java.lang.String getOfficerCataract () {
		return officerCataract;
	}

	/**
	 * Set the value related to the column: OFFICER_CATARACT
	 * @param officerCataract the OFFICER_CATARACT value
	 */
	public void setOfficerCataract (java.lang.String officerCataract) {
		this.officerCataract = officerCataract;
	}



	/**
	 * Return the value associated with the column: OFFICER_GLAUCOMA
	 */
	public java.lang.String getOfficerGlaucoma () {
		return officerGlaucoma;
	}

	/**
	 * Set the value related to the column: OFFICER_GLAUCOMA
	 * @param officerGlaucoma the OFFICER_GLAUCOMA value
	 */
	public void setOfficerGlaucoma (java.lang.String officerGlaucoma) {
		this.officerGlaucoma = officerGlaucoma;
	}



	/**
	 * Return the value associated with the column: AIRMEN_CATARACT
	 */
	public java.lang.String getAirmenCataract () {
		return airmenCataract;
	}

	/**
	 * Set the value related to the column: AIRMEN_CATARACT
	 * @param airmenCataract the AIRMEN_CATARACT value
	 */
	public void setAirmenCataract (java.lang.String airmenCataract) {
		this.airmenCataract = airmenCataract;
	}



	/**
	 * Return the value associated with the column: AIRMEN_GLAUCOMA
	 */
	public java.lang.String getAirmenGlaucoma () {
		return airmenGlaucoma;
	}

	/**
	 * Set the value related to the column: AIRMEN_GLAUCOMA
	 * @param airmenGlaucoma the AIRMEN_GLAUCOMA value
	 */
	public void setAirmenGlaucoma (java.lang.String airmenGlaucoma) {
		this.airmenGlaucoma = airmenGlaucoma;
	}



	/**
	 * Return the value associated with the column: FAMILY_CATARACT
	 */
	public java.lang.String getFamilyCataract () {
		return familyCataract;
	}

	/**
	 * Set the value related to the column: FAMILY_CATARACT
	 * @param familyCataract the FAMILY_CATARACT value
	 */
	public void setFamilyCataract (java.lang.String familyCataract) {
		this.familyCataract = familyCataract;
	}



	/**
	 * Return the value associated with the column: FAMILY_GLAUCOMA
	 */
	public java.lang.String getFamilyGlaucoma () {
		return familyGlaucoma;
	}

	/**
	 * Set the value related to the column: FAMILY_GLAUCOMA
	 * @param familyGlaucoma the FAMILY_GLAUCOMA value
	 */
	public void setFamilyGlaucoma (java.lang.String familyGlaucoma) {
		this.familyGlaucoma = familyGlaucoma;
	}



	/**
	 * Return the value associated with the column: SERVICEMEN_CATARACT
	 */
	public java.lang.String getServicemenCataract () {
		return servicemenCataract;
	}

	/**
	 * Set the value related to the column: SERVICEMEN_CATARACT
	 * @param servicemenCataract the SERVICEMEN_CATARACT value
	 */
	public void setServicemenCataract (java.lang.String servicemenCataract) {
		this.servicemenCataract = servicemenCataract;
	}



	/**
	 * Return the value associated with the column: SERVICEMEN_GLAUCOMA
	 */
	public java.lang.String getServicemenGlaucoma () {
		return servicemenGlaucoma;
	}

	/**
	 * Set the value related to the column: SERVICEMEN_GLAUCOMA
	 * @param servicemenGlaucoma the SERVICEMEN_GLAUCOMA value
	 */
	public void setServicemenGlaucoma (java.lang.String servicemenGlaucoma) {
		this.servicemenGlaucoma = servicemenGlaucoma;
	}



	/**
	 * Return the value associated with the column: MULTI_BACILLARY
	 */
	public java.lang.String getMultiBacillary () {
		return multiBacillary;
	}

	/**
	 * Set the value related to the column: MULTI_BACILLARY
	 * @param multiBacillary the MULTI_BACILLARY value
	 */
	public void setMultiBacillary (java.lang.String multiBacillary) {
		this.multiBacillary = multiBacillary;
	}



	/**
	 * Return the value associated with the column: PAUCI_BACILLARY
	 */
	public java.lang.String getPauciBacillary () {
		return pauciBacillary;
	}

	/**
	 * Set the value related to the column: PAUCI_BACILLARY
	 * @param pauciBacillary the PAUCI_BACILLARY value
	 */
	public void setPauciBacillary (java.lang.String pauciBacillary) {
		this.pauciBacillary = pauciBacillary;
	}



	/**
	 * Return the value associated with the column: HEPATITIS_VIRAL
	 */
	public java.lang.String getHepatitisViral () {
		return hepatitisViral;
	}

	/**
	 * Set the value related to the column: HEPATITIS_VIRAL
	 * @param hepatitisViral the HEPATITIS_VIRAL value
	 */
	public void setHepatitisViral (java.lang.String hepatitisViral) {
		this.hepatitisViral = hepatitisViral;
	}



	/**
	 * Return the value associated with the column: OTHER_VIRAL
	 */
	public java.lang.String getOtherViral () {
		return otherViral;
	}

	/**
	 * Set the value related to the column: OTHER_VIRAL
	 * @param otherViral the OTHER_VIRAL value
	 */
	public void setOtherViral (java.lang.String otherViral) {
		this.otherViral = otherViral;
	}



	/**
	 * Return the value associated with the column: NO_OF_DOG_BITE
	 */
	public java.lang.String getNoOfDogBite () {
		return noOfDogBite;
	}

	/**
	 * Set the value related to the column: NO_OF_DOG_BITE
	 * @param noOfDogBite the NO_OF_DOG_BITE value
	 */
	public void setNoOfDogBite (java.lang.String noOfDogBite) {
		this.noOfDogBite = noOfDogBite;
	}



	/**
	 * Return the value associated with the column: TOTAL_DOSES
	 */
	public java.lang.String getTotalDoses () {
		return totalDoses;
	}

	/**
	 * Set the value related to the column: TOTAL_DOSES
	 * @param totalDoses the TOTAL_DOSES value
	 */
	public void setTotalDoses (java.lang.String totalDoses) {
		this.totalDoses = totalDoses;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.ShoOfficerDetails)) return false;
		else {
			jkt.hms.masters.business.ShoOfficerDetails shoOfficerDetails = (jkt.hms.masters.business.ShoOfficerDetails) obj;
			if (null == this.getId() || null == shoOfficerDetails.getId()) return false;
			else return (this.getId().equals(shoOfficerDetails.getId()));
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
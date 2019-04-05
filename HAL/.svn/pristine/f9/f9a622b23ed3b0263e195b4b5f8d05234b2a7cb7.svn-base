package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the FWC_GROWTH_CHART table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="FWC_GROWTH_CHART"
 */

public abstract class BaseFwcGrowthChart  implements Serializable {

	public static String REF = "FwcGrowthChart";
	public static String PROP_STATUS = "Status";
	public static String PROP_AGE = "Age";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_EXPECTED_BMI_FOR_AGE = "ExpectedBmiForAge";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_EXPECTED_HEIGHT_FOR_AGE = "ExpectedHeightForAge";
	public static String PROP_ID = "Id";
	public static String PROP_EXPECTED_WEIGHT_FOR_AGE = "ExpectedWeightForAge";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ADMINISTRATIVE_SEX = "AdministrativeSex";


	// constructors
	public BaseFwcGrowthChart () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFwcGrowthChart (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String age;
	private java.lang.String expectedWeightForAge;
	private java.lang.String expectedHeightForAge;
	private java.lang.String expectedBmiForAge;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasAdministrativeSex administrativeSex;
	private jkt.hms.masters.business.MasHospital hospital;



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
	 * Return the value associated with the column: EXPECTED_WEIGHT_FOR_AGE
	 */
	public java.lang.String getExpectedWeightForAge () {
		return expectedWeightForAge;
	}

	/**
	 * Set the value related to the column: EXPECTED_WEIGHT_FOR_AGE
	 * @param expectedWeightForAge the EXPECTED_WEIGHT_FOR_AGE value
	 */
	public void setExpectedWeightForAge (java.lang.String expectedWeightForAge) {
		this.expectedWeightForAge = expectedWeightForAge;
	}



	/**
	 * Return the value associated with the column: EXPECTED_HEIGHT_FOR_AGE
	 */
	public java.lang.String getExpectedHeightForAge () {
		return expectedHeightForAge;
	}

	/**
	 * Set the value related to the column: EXPECTED_HEIGHT_FOR_AGE
	 * @param expectedHeightForAge the EXPECTED_HEIGHT_FOR_AGE value
	 */
	public void setExpectedHeightForAge (java.lang.String expectedHeightForAge) {
		this.expectedHeightForAge = expectedHeightForAge;
	}



	/**
	 * Return the value associated with the column: EXPECTED_BMI_FOR_AGE
	 */
	public java.lang.String getExpectedBmiForAge () {
		return expectedBmiForAge;
	}

	/**
	 * Set the value related to the column: EXPECTED_BMI_FOR_AGE
	 * @param expectedBmiForAge the EXPECTED_BMI_FOR_AGE value
	 */
	public void setExpectedBmiForAge (java.lang.String expectedBmiForAge) {
		this.expectedBmiForAge = expectedBmiForAge;
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
	 * Return the value associated with the column: ADMINISTRATIVE_SEX_ID
	 */
	public jkt.hms.masters.business.MasAdministrativeSex getAdministrativeSex () {
		return administrativeSex;
	}

	/**
	 * Set the value related to the column: ADMINISTRATIVE_SEX_ID
	 * @param administrativeSex the ADMINISTRATIVE_SEX_ID value
	 */
	public void setAdministrativeSex (jkt.hms.masters.business.MasAdministrativeSex administrativeSex) {
		this.administrativeSex = administrativeSex;
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
		if (!(obj instanceof jkt.hms.masters.business.FwcGrowthChart)) return false;
		else {
			jkt.hms.masters.business.FwcGrowthChart fwcGrowthChart = (jkt.hms.masters.business.FwcGrowthChart) obj;
			if (null == this.getId() || null == fwcGrowthChart.getId()) return false;
			else return (this.getId().equals(fwcGrowthChart.getId()));
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
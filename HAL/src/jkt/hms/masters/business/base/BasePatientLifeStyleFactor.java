package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the PATIENT_LIFE_STYLE_FACTOR table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="PATIENT_LIFE_STYLE_FACTOR"
 */

public abstract class BasePatientLifeStyleFactor  implements Serializable {

	public static String REF = "PatientLifeStyleFactor";
	public static String PROP_QUANTITY = "Quantity";
	public static String PROP_HABIT = "Habit";
	public static String PROP_DURATION_UNIT = "DurationUnit";
	public static String PROP_DURATION = "Duration";
	public static String PROP_HIN_NO = "HinNo";
	public static String PROP_START_AGE = "StartAge";
	public static String PROP_ID = "Id";
	public static String PROP_QUIT = "Quit";
	public static String PROP_HIN = "Hin";
	public static String PROP_QUIT_AGE = "QuitAge";


	// constructors
	public BasePatientLifeStyleFactor () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePatientLifeStyleFactor (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String habit;
	private java.lang.String quantity;
	private java.lang.Integer duration;
	private java.lang.String durationUnit;
	private java.lang.Integer startAge;
	private java.lang.String quit;
	private java.lang.Integer quitAge;
	private java.lang.String hinNo;

	// many to one
	private jkt.hms.masters.business.Patient hin;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="LIFE_STYLE_FACTOR_ID"
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
	 * Return the value associated with the column: HABIT
	 */
	public java.lang.String getHabit () {
		return habit;
	}

	/**
	 * Set the value related to the column: HABIT
	 * @param habit the HABIT value
	 */
	public void setHabit (java.lang.String habit) {
		this.habit = habit;
	}



	/**
	 * Return the value associated with the column: QUANTITY
	 */
	public java.lang.String getQuantity () {
		return quantity;
	}

	/**
	 * Set the value related to the column: QUANTITY
	 * @param quantity the QUANTITY value
	 */
	public void setQuantity (java.lang.String quantity) {
		this.quantity = quantity;
	}



	/**
	 * Return the value associated with the column: DURATION
	 */
	public java.lang.Integer getDuration () {
		return duration;
	}

	/**
	 * Set the value related to the column: DURATION
	 * @param duration the DURATION value
	 */
	public void setDuration (java.lang.Integer duration) {
		this.duration = duration;
	}



	/**
	 * Return the value associated with the column: DURATION_UNIT
	 */
	public java.lang.String getDurationUnit () {
		return durationUnit;
	}

	/**
	 * Set the value related to the column: DURATION_UNIT
	 * @param durationUnit the DURATION_UNIT value
	 */
	public void setDurationUnit (java.lang.String durationUnit) {
		this.durationUnit = durationUnit;
	}



	/**
	 * Return the value associated with the column: START_AGE
	 */
	public java.lang.Integer getStartAge () {
		return startAge;
	}

	/**
	 * Set the value related to the column: START_AGE
	 * @param startAge the START_AGE value
	 */
	public void setStartAge (java.lang.Integer startAge) {
		this.startAge = startAge;
	}



	/**
	 * Return the value associated with the column: QUIT
	 */
	public java.lang.String getQuit () {
		return quit;
	}

	/**
	 * Set the value related to the column: QUIT
	 * @param quit the QUIT value
	 */
	public void setQuit (java.lang.String quit) {
		this.quit = quit;
	}



	/**
	 * Return the value associated with the column: QUIT_AGE
	 */
	public java.lang.Integer getQuitAge () {
		return quitAge;
	}

	/**
	 * Set the value related to the column: QUIT_AGE
	 * @param quitAge the QUIT_AGE value
	 */
	public void setQuitAge (java.lang.Integer quitAge) {
		this.quitAge = quitAge;
	}



	/**
	 * Return the value associated with the column: HIN_NO
	 */
	public java.lang.String getHinNo () {
		return hinNo;
	}

	/**
	 * Set the value related to the column: HIN_NO
	 * @param hinNo the HIN_NO value
	 */
	public void setHinNo (java.lang.String hinNo) {
		this.hinNo = hinNo;
	}



	/**
	 * Return the value associated with the column: hin_id
	 */
	public jkt.hms.masters.business.Patient getHin () {
		return hin;
	}

	/**
	 * Set the value related to the column: hin_id
	 * @param hin the hin_id value
	 */
	public void setHin (jkt.hms.masters.business.Patient hin) {
		this.hin = hin;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.PatientLifeStyleFactor)) return false;
		else {
			jkt.hms.masters.business.PatientLifeStyleFactor patientLifeStyleFactor = (jkt.hms.masters.business.PatientLifeStyleFactor) obj;
			if (null == this.getId() || null == patientLifeStyleFactor.getId()) return false;
			else return (this.getId().equals(patientLifeStyleFactor.getId()));
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
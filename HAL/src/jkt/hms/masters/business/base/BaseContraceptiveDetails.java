package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the CONTRACEPTIVE_DETAILS table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="CONTRACEPTIVE_DETAILS"
 */

public abstract class BaseContraceptiveDetails  implements Serializable {

	public static String REF = "ContraceptiveDetails";
	public static String PROP_CONTRACEPTIVE = "Contraceptive";
	public static String PROP_DURATION_UNIT = "DurationUnit";
	public static String PROP_DURATION = "Duration";
	public static String PROP_HIN_NO = "HinNo";
	public static String PROP_ID = "Id";
	public static String PROP_HIN = "Hin";


	// constructors
	public BaseContraceptiveDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseContraceptiveDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String contraceptive;
	private java.lang.Integer duration;
	private java.lang.String durationUnit;
	private java.lang.String hinNo;

	// many to one
	private jkt.hms.masters.business.Patient hin;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="CONTRACEPTIVE_DETAILS_ID"
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
	 * Return the value associated with the column: CONTRACEPTIVE
	 */
	public java.lang.String getContraceptive () {
		return contraceptive;
	}

	/**
	 * Set the value related to the column: CONTRACEPTIVE
	 * @param contraceptive the CONTRACEPTIVE value
	 */
	public void setContraceptive (java.lang.String contraceptive) {
		this.contraceptive = contraceptive;
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
		if (!(obj instanceof jkt.hms.masters.business.ContraceptiveDetails)) return false;
		else {
			jkt.hms.masters.business.ContraceptiveDetails contraceptiveDetails = (jkt.hms.masters.business.ContraceptiveDetails) obj;
			if (null == this.getId() || null == contraceptiveDetails.getId()) return false;
			else return (this.getId().equals(contraceptiveDetails.getId()));
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
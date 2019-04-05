package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the PATIENT_GYNE_DETAILS table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="PATIENT_GYNE_DETAILS"
 */

public abstract class BasePatientGyneDetails  implements Serializable {

	public static String REF = "PatientGyneDetails";
	public static String PROP_BREAST_FEEDING_DURATION = "BreastFeedingDuration";
	public static String PROP_OBSTETRIC_NOT_APPLICABLE = "ObstetricNotApplicable";
	public static String PROP_MENSTRUAL_STATUS = "MenstrualStatus";
	public static String PROP_LMP = "Lmp";
	public static String PROP_HIN_NO = "HinNo";
	public static String PROP_MENSTRUAL_ABNORMALITIES = "MenstrualAbnormalities";
	public static String PROP_LACTATING = "Lactating";
	public static String PROP_MENSTRUAL_CYCLE = "MenstrualCycle";
	public static String PROP_PARA = "Para";
	public static String PROP_DYSMENORRHEA = "Dysmenorrhea";
	public static String PROP_BREAST_FEEDING = "BreastFeeding";
	public static String PROP_LAST_DELIVERY_AGE = "LastDeliveryAge";
	public static String PROP_MENSTRUAL_FLOW = "MenstrualFlow";
	public static String PROP_GRAVIDA = "Gravida";
	public static String PROP_MENOPAUSE_AGE = "MenopauseAge";
	public static String PROP_CHILDREN = "Children";
	public static String PROP_FIRST_DELIVERY_AGE = "FirstDeliveryAge";
	public static String PROP_MOLAR_PREGNENCY = "MolarPregnency";
	public static String PROP_MENSTRUAL_HISTORY_UNKNOWN = "MenstrualHistoryUnknown";
	public static String PROP_LMP_UNKNOWN = "LmpUnknown";
	public static String PROP_ABORTIONS = "Abortions";
	public static String PROP_ID = "Id";
	public static String PROP_OBSTETRIC_HISTORY_UNKNOWN = "ObstetricHistoryUnknown";
	public static String PROP_HIN = "Hin";
	public static String PROP_MENARCHE_AGE = "MenarcheAge";
	public static String PROP_PREGNENT = "Pregnent";


	// constructors
	public BasePatientGyneDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePatientGyneDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String menstrualHistoryUnknown;
	private java.lang.String menstrualStatus;
	private java.util.Date lmp;
	private java.lang.String lmpUnknown;
	private java.lang.String menarcheAge;
	private java.lang.String menopauseAge;
	private java.lang.String menstrualCycle;
	private java.lang.String menstrualFlow;
	private java.lang.String dysmenorrhea;
	private java.lang.String menstrualAbnormalities;
	private java.lang.String obstetricHistoryUnknown;
	private java.lang.String obstetricNotApplicable;
	private java.lang.Integer gravida;
	private java.lang.Integer para;
	private java.lang.Integer abortions;
	private java.lang.Integer children;
	private java.lang.String pregnent;
	private java.lang.String lactating;
	private java.lang.String firstDeliveryAge;
	private java.lang.String lastDeliveryAge;
	private java.lang.String breastFeeding;
	private java.lang.String breastFeedingDuration;
	private java.lang.String molarPregnency;
	private java.lang.String hinNo;

	// many to one
	private jkt.hms.masters.business.Patient hin;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="GYNE_DETAILS_ID"
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
	 * Return the value associated with the column: MENSTRUAL_HISTORY_UNKNOWN
	 */
	public java.lang.String getMenstrualHistoryUnknown () {
		return menstrualHistoryUnknown;
	}

	/**
	 * Set the value related to the column: MENSTRUAL_HISTORY_UNKNOWN
	 * @param menstrualHistoryUnknown the MENSTRUAL_HISTORY_UNKNOWN value
	 */
	public void setMenstrualHistoryUnknown (java.lang.String menstrualHistoryUnknown) {
		this.menstrualHistoryUnknown = menstrualHistoryUnknown;
	}



	/**
	 * Return the value associated with the column: MENSTRUAL_STATUS
	 */
	public java.lang.String getMenstrualStatus () {
		return menstrualStatus;
	}

	/**
	 * Set the value related to the column: MENSTRUAL_STATUS
	 * @param menstrualStatus the MENSTRUAL_STATUS value
	 */
	public void setMenstrualStatus (java.lang.String menstrualStatus) {
		this.menstrualStatus = menstrualStatus;
	}



	/**
	 * Return the value associated with the column: LMP
	 */
	public java.util.Date getLmp () {
		return lmp;
	}

	/**
	 * Set the value related to the column: LMP
	 * @param lmp the LMP value
	 */
	public void setLmp (java.util.Date lmp) {
		this.lmp = lmp;
	}



	/**
	 * Return the value associated with the column: LMP_UNKNOWN
	 */
	public java.lang.String getLmpUnknown () {
		return lmpUnknown;
	}

	/**
	 * Set the value related to the column: LMP_UNKNOWN
	 * @param lmpUnknown the LMP_UNKNOWN value
	 */
	public void setLmpUnknown (java.lang.String lmpUnknown) {
		this.lmpUnknown = lmpUnknown;
	}



	/**
	 * Return the value associated with the column: MENARCHE_AGE
	 */
	public java.lang.String getMenarcheAge () {
		return menarcheAge;
	}

	/**
	 * Set the value related to the column: MENARCHE_AGE
	 * @param menarcheAge the MENARCHE_AGE value
	 */
	public void setMenarcheAge (java.lang.String menarcheAge) {
		this.menarcheAge = menarcheAge;
	}



	/**
	 * Return the value associated with the column: MENOPAUSE_AGE
	 */
	public java.lang.String getMenopauseAge () {
		return menopauseAge;
	}

	/**
	 * Set the value related to the column: MENOPAUSE_AGE
	 * @param menopauseAge the MENOPAUSE_AGE value
	 */
	public void setMenopauseAge (java.lang.String menopauseAge) {
		this.menopauseAge = menopauseAge;
	}



	/**
	 * Return the value associated with the column: MENSTRUAL_CYCLE
	 */
	public java.lang.String getMenstrualCycle () {
		return menstrualCycle;
	}

	/**
	 * Set the value related to the column: MENSTRUAL_CYCLE
	 * @param menstrualCycle the MENSTRUAL_CYCLE value
	 */
	public void setMenstrualCycle (java.lang.String menstrualCycle) {
		this.menstrualCycle = menstrualCycle;
	}



	/**
	 * Return the value associated with the column: MENSTRUAL_FLOW
	 */
	public java.lang.String getMenstrualFlow () {
		return menstrualFlow;
	}

	/**
	 * Set the value related to the column: MENSTRUAL_FLOW
	 * @param menstrualFlow the MENSTRUAL_FLOW value
	 */
	public void setMenstrualFlow (java.lang.String menstrualFlow) {
		this.menstrualFlow = menstrualFlow;
	}



	/**
	 * Return the value associated with the column: DYSMENORRHEA
	 */
	public java.lang.String getDysmenorrhea () {
		return dysmenorrhea;
	}

	/**
	 * Set the value related to the column: DYSMENORRHEA
	 * @param dysmenorrhea the DYSMENORRHEA value
	 */
	public void setDysmenorrhea (java.lang.String dysmenorrhea) {
		this.dysmenorrhea = dysmenorrhea;
	}



	/**
	 * Return the value associated with the column: MENSTRUAL_ABNORMALITIES
	 */
	public java.lang.String getMenstrualAbnormalities () {
		return menstrualAbnormalities;
	}

	/**
	 * Set the value related to the column: MENSTRUAL_ABNORMALITIES
	 * @param menstrualAbnormalities the MENSTRUAL_ABNORMALITIES value
	 */
	public void setMenstrualAbnormalities (java.lang.String menstrualAbnormalities) {
		this.menstrualAbnormalities = menstrualAbnormalities;
	}



	/**
	 * Return the value associated with the column: OBSTETRIC_HISTORY_UNKNOWN
	 */
	public java.lang.String getObstetricHistoryUnknown () {
		return obstetricHistoryUnknown;
	}

	/**
	 * Set the value related to the column: OBSTETRIC_HISTORY_UNKNOWN
	 * @param obstetricHistoryUnknown the OBSTETRIC_HISTORY_UNKNOWN value
	 */
	public void setObstetricHistoryUnknown (java.lang.String obstetricHistoryUnknown) {
		this.obstetricHistoryUnknown = obstetricHistoryUnknown;
	}



	/**
	 * Return the value associated with the column: OBSTETRIC_NOT_APPLICABLE
	 */
	public java.lang.String getObstetricNotApplicable () {
		return obstetricNotApplicable;
	}

	/**
	 * Set the value related to the column: OBSTETRIC_NOT_APPLICABLE
	 * @param obstetricNotApplicable the OBSTETRIC_NOT_APPLICABLE value
	 */
	public void setObstetricNotApplicable (java.lang.String obstetricNotApplicable) {
		this.obstetricNotApplicable = obstetricNotApplicable;
	}



	/**
	 * Return the value associated with the column: GRAVIDA
	 */
	public java.lang.Integer getGravida () {
		return gravida;
	}

	/**
	 * Set the value related to the column: GRAVIDA
	 * @param gravida the GRAVIDA value
	 */
	public void setGravida (java.lang.Integer gravida) {
		this.gravida = gravida;
	}



	/**
	 * Return the value associated with the column: PARA
	 */
	public java.lang.Integer getPara () {
		return para;
	}

	/**
	 * Set the value related to the column: PARA
	 * @param para the PARA value
	 */
	public void setPara (java.lang.Integer para) {
		this.para = para;
	}



	/**
	 * Return the value associated with the column: ABORTIONS
	 */
	public java.lang.Integer getAbortions () {
		return abortions;
	}

	/**
	 * Set the value related to the column: ABORTIONS
	 * @param abortions the ABORTIONS value
	 */
	public void setAbortions (java.lang.Integer abortions) {
		this.abortions = abortions;
	}



	/**
	 * Return the value associated with the column: CHILDREN
	 */
	public java.lang.Integer getChildren () {
		return children;
	}

	/**
	 * Set the value related to the column: CHILDREN
	 * @param children the CHILDREN value
	 */
	public void setChildren (java.lang.Integer children) {
		this.children = children;
	}



	/**
	 * Return the value associated with the column: PREGNENT
	 */
	public java.lang.String getPregnent () {
		return pregnent;
	}

	/**
	 * Set the value related to the column: PREGNENT
	 * @param pregnent the PREGNENT value
	 */
	public void setPregnent (java.lang.String pregnent) {
		this.pregnent = pregnent;
	}



	/**
	 * Return the value associated with the column: LACTATING
	 */
	public java.lang.String getLactating () {
		return lactating;
	}

	/**
	 * Set the value related to the column: LACTATING
	 * @param lactating the LACTATING value
	 */
	public void setLactating (java.lang.String lactating) {
		this.lactating = lactating;
	}



	/**
	 * Return the value associated with the column: FIRST_DELIVERY_AGE
	 */
	public java.lang.String getFirstDeliveryAge () {
		return firstDeliveryAge;
	}

	/**
	 * Set the value related to the column: FIRST_DELIVERY_AGE
	 * @param firstDeliveryAge the FIRST_DELIVERY_AGE value
	 */
	public void setFirstDeliveryAge (java.lang.String firstDeliveryAge) {
		this.firstDeliveryAge = firstDeliveryAge;
	}



	/**
	 * Return the value associated with the column: LAST_DELIVERY_AGE
	 */
	public java.lang.String getLastDeliveryAge () {
		return lastDeliveryAge;
	}

	/**
	 * Set the value related to the column: LAST_DELIVERY_AGE
	 * @param lastDeliveryAge the LAST_DELIVERY_AGE value
	 */
	public void setLastDeliveryAge (java.lang.String lastDeliveryAge) {
		this.lastDeliveryAge = lastDeliveryAge;
	}



	/**
	 * Return the value associated with the column: BREAST_FEEDING
	 */
	public java.lang.String getBreastFeeding () {
		return breastFeeding;
	}

	/**
	 * Set the value related to the column: BREAST_FEEDING
	 * @param breastFeeding the BREAST_FEEDING value
	 */
	public void setBreastFeeding (java.lang.String breastFeeding) {
		this.breastFeeding = breastFeeding;
	}



	/**
	 * Return the value associated with the column: BREAST_FEEDING_DURATION
	 */
	public java.lang.String getBreastFeedingDuration () {
		return breastFeedingDuration;
	}

	/**
	 * Set the value related to the column: BREAST_FEEDING_DURATION
	 * @param breastFeedingDuration the BREAST_FEEDING_DURATION value
	 */
	public void setBreastFeedingDuration (java.lang.String breastFeedingDuration) {
		this.breastFeedingDuration = breastFeedingDuration;
	}



	/**
	 * Return the value associated with the column: MOLAR_PREGNENCY
	 */
	public java.lang.String getMolarPregnency () {
		return molarPregnency;
	}

	/**
	 * Set the value related to the column: MOLAR_PREGNENCY
	 * @param molarPregnency the MOLAR_PREGNENCY value
	 */
	public void setMolarPregnency (java.lang.String molarPregnency) {
		this.molarPregnency = molarPregnency;
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
		if (!(obj instanceof jkt.hms.masters.business.PatientGyneDetails)) return false;
		else {
			jkt.hms.masters.business.PatientGyneDetails patientGyneDetails = (jkt.hms.masters.business.PatientGyneDetails) obj;
			if (null == this.getId() || null == patientGyneDetails.getId()) return false;
			else return (this.getId().equals(patientGyneDetails.getId()));
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
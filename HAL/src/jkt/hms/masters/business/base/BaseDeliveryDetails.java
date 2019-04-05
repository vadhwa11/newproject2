package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the delivery_details table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="delivery_details"
 */

public abstract class BaseDeliveryDetails  implements Serializable {

	public static String REF = "DeliveryDetails";
	public static String PROP_CONDUCTED_BY = "ConductedBy";
	public static String PROP_AD_NO = "AdNo";
	public static String PROP_DELIVERY_DURATION = "DeliveryDuration";
	public static String PROP_STAGE_FIVE_COMPLICATIONS = "StageFiveComplications";
	public static String PROP_TREATMENT = "Treatment";
	public static String PROP_OTHER_REMARKS = "OtherRemarks";
	public static String PROP_ADDITIONAL_NOTES = "AdditionalNotes";
	public static String PROP_PLACENTA = "Placenta";
	public static String PROP_GESTATION = "Gestation";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_AUGMENTATION = "Augmentation";
	public static String PROP_STAGE_THREE = "StageThree";
	public static String PROP_RUPTURE_UTERUS = "RuptureUterus";
	public static String PROP_OTHER_DETAILS = "OtherDetails";
	public static String PROP_COMPLICATIONS = "Complications";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_DATE_OF_LABOR = "DateOfLabor";
	public static String PROP_PERINEAL_TEARS = "PerinealTears";
	public static String PROP_MOTHERS_CONDITION = "MothersCondition";
	public static String PROP_ANAESTHESIA = "Anaesthesia";
	public static String PROP_INDUCTION = "Induction";
	public static String PROP_LACTATION = "Lactation";
	public static String PROP_EPISIOTOMY = "Episiotomy";
	public static String PROP_TIME_OF_LABOR = "TimeOfLabor";
	public static String PROP_DELIVERY_TYPE = "DeliveryType";
	public static String PROP_PERINUM = "Perinum";
	public static String PROP_ASSISTED_BY = "AssistedBy";
	public static String PROP_BP = "Bp";
	public static String PROP_PUPERIUM = "Puperium";
	public static String PROP_BLEEDING = "Bleeding";
	public static String PROP_SUTURE_MATERIAL = "SutureMaterial";
	public static String PROP_ID = "Id";
	public static String PROP_PULSE = "Pulse";
	public static String PROP_BLOOD_LOSS = "BloodLoss";
	public static String PROP_HIN = "Hin";
	public static String PROP_BLOOD_TRANSFUSION = "BloodTransfusion";
	public static String PROP_STATE_OF_UTERUS = "StateOfUterus";
	public static String PROP_DELIVERY_SUB_TYPE = "DeliverySubType";


	// constructors
	public BaseDeliveryDetails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDeliveryDetails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseDeliveryDetails (
		java.lang.Integer id,
		jkt.hms.masters.business.MasHospital hospital,
		jkt.hms.masters.business.Patient hin) {

		this.setId(id);
		this.setHospital(hospital);
		this.setHin(hin);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer adNo;
	private java.lang.String additionalNotes;
	private java.lang.String anaesthesia;
	private java.lang.String augmentation;
	private java.lang.String bleeding;
	private java.lang.String bloodLoss;
	private java.lang.String bloodTransfusion;
	private java.lang.Integer bp;
	private java.lang.String complications;
	private java.util.Date dateOfLabor;
	private java.lang.String deliveryDuration;
	private java.lang.String deliverySubType;
	private java.lang.String deliveryType;
	private java.lang.String episiotomy;
	private java.lang.String gestation;
	private java.lang.String induction;
	private java.lang.String lactation;
	private java.lang.String mothersCondition;
	private java.lang.String otherDetails;
	private java.lang.String otherRemarks;
	private java.lang.String perinealTears;
	private java.lang.Integer perinum;
	private java.lang.String placenta;
	private java.lang.Integer pulse;
	private java.lang.String puperium;
	private java.lang.String ruptureUterus;
	private java.lang.String stageFiveComplications;
	private java.lang.String stageThree;
	private java.lang.String stateOfUterus;
	private java.lang.String sutureMaterial;
	private java.lang.String timeOfLabor;
	private java.lang.String treatment;

	// many to one
	private jkt.hms.masters.business.MasEmployee assistedBy;
	private jkt.hms.masters.business.MasEmployee conductedBy;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Inpatient inpatient;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="delivery_id"
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
	 * Return the value associated with the column: ad_no
	 */
	public java.lang.Integer getAdNo () {
		return adNo;
	}

	/**
	 * Set the value related to the column: ad_no
	 * @param adNo the ad_no value
	 */
	public void setAdNo (java.lang.Integer adNo) {
		this.adNo = adNo;
	}



	/**
	 * Return the value associated with the column: additional_notes
	 */
	public java.lang.String getAdditionalNotes () {
		return additionalNotes;
	}

	/**
	 * Set the value related to the column: additional_notes
	 * @param additionalNotes the additional_notes value
	 */
	public void setAdditionalNotes (java.lang.String additionalNotes) {
		this.additionalNotes = additionalNotes;
	}



	/**
	 * Return the value associated with the column: anaesthesia
	 */
	public java.lang.String getAnaesthesia () {
		return anaesthesia;
	}

	/**
	 * Set the value related to the column: anaesthesia
	 * @param anaesthesia the anaesthesia value
	 */
	public void setAnaesthesia (java.lang.String anaesthesia) {
		this.anaesthesia = anaesthesia;
	}



	/**
	 * Return the value associated with the column: augmentation
	 */
	public java.lang.String getAugmentation () {
		return augmentation;
	}

	/**
	 * Set the value related to the column: augmentation
	 * @param augmentation the augmentation value
	 */
	public void setAugmentation (java.lang.String augmentation) {
		this.augmentation = augmentation;
	}



	/**
	 * Return the value associated with the column: bleeding
	 */
	public java.lang.String getBleeding () {
		return bleeding;
	}

	/**
	 * Set the value related to the column: bleeding
	 * @param bleeding the bleeding value
	 */
	public void setBleeding (java.lang.String bleeding) {
		this.bleeding = bleeding;
	}



	/**
	 * Return the value associated with the column: blood_loss
	 */
	public java.lang.String getBloodLoss () {
		return bloodLoss;
	}

	/**
	 * Set the value related to the column: blood_loss
	 * @param bloodLoss the blood_loss value
	 */
	public void setBloodLoss (java.lang.String bloodLoss) {
		this.bloodLoss = bloodLoss;
	}



	/**
	 * Return the value associated with the column: blood_transfusion
	 */
	public java.lang.String getBloodTransfusion () {
		return bloodTransfusion;
	}

	/**
	 * Set the value related to the column: blood_transfusion
	 * @param bloodTransfusion the blood_transfusion value
	 */
	public void setBloodTransfusion (java.lang.String bloodTransfusion) {
		this.bloodTransfusion = bloodTransfusion;
	}



	/**
	 * Return the value associated with the column: bp
	 */
	public java.lang.Integer getBp () {
		return bp;
	}

	/**
	 * Set the value related to the column: bp
	 * @param bp the bp value
	 */
	public void setBp (java.lang.Integer bp) {
		this.bp = bp;
	}



	/**
	 * Return the value associated with the column: complications
	 */
	public java.lang.String getComplications () {
		return complications;
	}

	/**
	 * Set the value related to the column: complications
	 * @param complications the complications value
	 */
	public void setComplications (java.lang.String complications) {
		this.complications = complications;
	}



	/**
	 * Return the value associated with the column: date_of_labor
	 */
	public java.util.Date getDateOfLabor () {
		return dateOfLabor;
	}

	/**
	 * Set the value related to the column: date_of_labor
	 * @param dateOfLabor the date_of_labor value
	 */
	public void setDateOfLabor (java.util.Date dateOfLabor) {
		this.dateOfLabor = dateOfLabor;
	}



	/**
	 * Return the value associated with the column: delivery_duration
	 */
	public java.lang.String getDeliveryDuration () {
		return deliveryDuration;
	}

	/**
	 * Set the value related to the column: delivery_duration
	 * @param deliveryDuration the delivery_duration value
	 */
	public void setDeliveryDuration (java.lang.String deliveryDuration) {
		this.deliveryDuration = deliveryDuration;
	}



	/**
	 * Return the value associated with the column: delivery_sub_type
	 */
	public java.lang.String getDeliverySubType () {
		return deliverySubType;
	}

	/**
	 * Set the value related to the column: delivery_sub_type
	 * @param deliverySubType the delivery_sub_type value
	 */
	public void setDeliverySubType (java.lang.String deliverySubType) {
		this.deliverySubType = deliverySubType;
	}



	/**
	 * Return the value associated with the column: delivery_type
	 */
	public java.lang.String getDeliveryType () {
		return deliveryType;
	}

	/**
	 * Set the value related to the column: delivery_type
	 * @param deliveryType the delivery_type value
	 */
	public void setDeliveryType (java.lang.String deliveryType) {
		this.deliveryType = deliveryType;
	}



	/**
	 * Return the value associated with the column: episiotomy
	 */
	public java.lang.String getEpisiotomy () {
		return episiotomy;
	}

	/**
	 * Set the value related to the column: episiotomy
	 * @param episiotomy the episiotomy value
	 */
	public void setEpisiotomy (java.lang.String episiotomy) {
		this.episiotomy = episiotomy;
	}



	/**
	 * Return the value associated with the column: gestation
	 */
	public java.lang.String getGestation () {
		return gestation;
	}

	/**
	 * Set the value related to the column: gestation
	 * @param gestation the gestation value
	 */
	public void setGestation (java.lang.String gestation) {
		this.gestation = gestation;
	}



	/**
	 * Return the value associated with the column: induction
	 */
	public java.lang.String getInduction () {
		return induction;
	}

	/**
	 * Set the value related to the column: induction
	 * @param induction the induction value
	 */
	public void setInduction (java.lang.String induction) {
		this.induction = induction;
	}



	/**
	 * Return the value associated with the column: lactation
	 */
	public java.lang.String getLactation () {
		return lactation;
	}

	/**
	 * Set the value related to the column: lactation
	 * @param lactation the lactation value
	 */
	public void setLactation (java.lang.String lactation) {
		this.lactation = lactation;
	}



	/**
	 * Return the value associated with the column: mothers_condition
	 */
	public java.lang.String getMothersCondition () {
		return mothersCondition;
	}

	/**
	 * Set the value related to the column: mothers_condition
	 * @param mothersCondition the mothers_condition value
	 */
	public void setMothersCondition (java.lang.String mothersCondition) {
		this.mothersCondition = mothersCondition;
	}



	/**
	 * Return the value associated with the column: other_details
	 */
	public java.lang.String getOtherDetails () {
		return otherDetails;
	}

	/**
	 * Set the value related to the column: other_details
	 * @param otherDetails the other_details value
	 */
	public void setOtherDetails (java.lang.String otherDetails) {
		this.otherDetails = otherDetails;
	}



	/**
	 * Return the value associated with the column: other_remarks
	 */
	public java.lang.String getOtherRemarks () {
		return otherRemarks;
	}

	/**
	 * Set the value related to the column: other_remarks
	 * @param otherRemarks the other_remarks value
	 */
	public void setOtherRemarks (java.lang.String otherRemarks) {
		this.otherRemarks = otherRemarks;
	}



	/**
	 * Return the value associated with the column: perineal_tears
	 */
	public java.lang.String getPerinealTears () {
		return perinealTears;
	}

	/**
	 * Set the value related to the column: perineal_tears
	 * @param perinealTears the perineal_tears value
	 */
	public void setPerinealTears (java.lang.String perinealTears) {
		this.perinealTears = perinealTears;
	}



	/**
	 * Return the value associated with the column: perinum
	 */
	public java.lang.Integer getPerinum () {
		return perinum;
	}

	/**
	 * Set the value related to the column: perinum
	 * @param perinum the perinum value
	 */
	public void setPerinum (java.lang.Integer perinum) {
		this.perinum = perinum;
	}



	/**
	 * Return the value associated with the column: placenta
	 */
	public java.lang.String getPlacenta () {
		return placenta;
	}

	/**
	 * Set the value related to the column: placenta
	 * @param placenta the placenta value
	 */
	public void setPlacenta (java.lang.String placenta) {
		this.placenta = placenta;
	}



	/**
	 * Return the value associated with the column: pulse
	 */
	public java.lang.Integer getPulse () {
		return pulse;
	}

	/**
	 * Set the value related to the column: pulse
	 * @param pulse the pulse value
	 */
	public void setPulse (java.lang.Integer pulse) {
		this.pulse = pulse;
	}



	/**
	 * Return the value associated with the column: puperium
	 */
	public java.lang.String getPuperium () {
		return puperium;
	}

	/**
	 * Set the value related to the column: puperium
	 * @param puperium the puperium value
	 */
	public void setPuperium (java.lang.String puperium) {
		this.puperium = puperium;
	}



	/**
	 * Return the value associated with the column: rupture_uterus
	 */
	public java.lang.String getRuptureUterus () {
		return ruptureUterus;
	}

	/**
	 * Set the value related to the column: rupture_uterus
	 * @param ruptureUterus the rupture_uterus value
	 */
	public void setRuptureUterus (java.lang.String ruptureUterus) {
		this.ruptureUterus = ruptureUterus;
	}



	/**
	 * Return the value associated with the column: stage_five_complications
	 */
	public java.lang.String getStageFiveComplications () {
		return stageFiveComplications;
	}

	/**
	 * Set the value related to the column: stage_five_complications
	 * @param stageFiveComplications the stage_five_complications value
	 */
	public void setStageFiveComplications (java.lang.String stageFiveComplications) {
		this.stageFiveComplications = stageFiveComplications;
	}



	/**
	 * Return the value associated with the column: stage_three
	 */
	public java.lang.String getStageThree () {
		return stageThree;
	}

	/**
	 * Set the value related to the column: stage_three
	 * @param stageThree the stage_three value
	 */
	public void setStageThree (java.lang.String stageThree) {
		this.stageThree = stageThree;
	}



	/**
	 * Return the value associated with the column: state_of_uterus
	 */
	public java.lang.String getStateOfUterus () {
		return stateOfUterus;
	}

	/**
	 * Set the value related to the column: state_of_uterus
	 * @param stateOfUterus the state_of_uterus value
	 */
	public void setStateOfUterus (java.lang.String stateOfUterus) {
		this.stateOfUterus = stateOfUterus;
	}



	/**
	 * Return the value associated with the column: suture_material
	 */
	public java.lang.String getSutureMaterial () {
		return sutureMaterial;
	}

	/**
	 * Set the value related to the column: suture_material
	 * @param sutureMaterial the suture_material value
	 */
	public void setSutureMaterial (java.lang.String sutureMaterial) {
		this.sutureMaterial = sutureMaterial;
	}



	/**
	 * Return the value associated with the column: time_of_labor
	 */
	public java.lang.String getTimeOfLabor () {
		return timeOfLabor;
	}

	/**
	 * Set the value related to the column: time_of_labor
	 * @param timeOfLabor the time_of_labor value
	 */
	public void setTimeOfLabor (java.lang.String timeOfLabor) {
		this.timeOfLabor = timeOfLabor;
	}



	/**
	 * Return the value associated with the column: treatment
	 */
	public java.lang.String getTreatment () {
		return treatment;
	}

	/**
	 * Set the value related to the column: treatment
	 * @param treatment the treatment value
	 */
	public void setTreatment (java.lang.String treatment) {
		this.treatment = treatment;
	}



	/**
	 * Return the value associated with the column: assisted_by
	 */
	public jkt.hms.masters.business.MasEmployee getAssistedBy () {
		return assistedBy;
	}

	/**
	 * Set the value related to the column: assisted_by
	 * @param assistedBy the assisted_by value
	 */
	public void setAssistedBy (jkt.hms.masters.business.MasEmployee assistedBy) {
		this.assistedBy = assistedBy;
	}



	/**
	 * Return the value associated with the column: conducted_by
	 */
	public jkt.hms.masters.business.MasEmployee getConductedBy () {
		return conductedBy;
	}

	/**
	 * Set the value related to the column: conducted_by
	 * @param conductedBy the conducted_by value
	 */
	public void setConductedBy (jkt.hms.masters.business.MasEmployee conductedBy) {
		this.conductedBy = conductedBy;
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



	/**
	 * Return the value associated with the column: inpatient_id
	 */
	public jkt.hms.masters.business.Inpatient getInpatient () {
		return inpatient;
	}

	/**
	 * Set the value related to the column: inpatient_id
	 * @param inpatient the inpatient_id value
	 */
	public void setInpatient (jkt.hms.masters.business.Inpatient inpatient) {
		this.inpatient = inpatient;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.DeliveryDetails)) return false;
		else {
			jkt.hms.masters.business.DeliveryDetails deliveryDetails = (jkt.hms.masters.business.DeliveryDetails) obj;
			if (null == this.getId() || null == deliveryDetails.getId()) return false;
			else return (this.getId().equals(deliveryDetails.getId()));
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
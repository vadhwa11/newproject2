package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the ipdclinical table. Do not
 * modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * 
 * @hibernate.class table="ipdclinical"
 */

public abstract class BaseIpdclinical implements Serializable {

	public static String REF = "Ipdclinical";
	public static String PROP_ENEMA = "Enema";
	public static String PROP_PREOP = "Preop";
	public static String PROP_SILDILREMARKS = "Sildilremarks";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_USERID = "Userid";
	public static String PROP_VOM = "Vom";
	public static String PROP_PREOPPREMARKS = "Preoppremarks";
	public static String PROP_TREATMENT = "Treatment";
	public static String PROP_BACKCARE = "Backcare";
	public static String PROP_ENEMAREMARKS = "Enemaremarks";
	public static String PROP_BP = "Bp";
	public static String PROP_MOUTHREMARKS = "Mouthremarks";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_IV = "Iv";
	public static String PROP_NEBULIZATION = "Nebulization";
	public static String PROP_DRESSING = "Dressing";
	public static String PROP_BACKREMARKS = "Backremarks";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_IPDVISITTIME = "Ipdvisittime";
	public static String PROP_TRACHEOSTOMY = "Tracheostomy";
	public static String PROP_HIN = "Hin";
	public static String PROP_NEEDLEPRICKEDREMARKS = "Needleprickedremarks";
	public static String PROP_NEBULIZATIONREMARKS = "Nebulizationremarks";
	public static String PROP_MOUTH = "Mouth";
	public static String PROP_HAIRREMARKS = "Hairremarks";
	public static String PROP_HAIR = "Hair";
	public static String PROP_RYLES = "Ryles";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_INTAKE = "Intake";
	public static String PROP_POSTOPREMARKS = "Postopremarks";
	public static String PROP_RYLESREMARKS = "Rylesremarks";
	public static String PROP_PULSE = "Pulse";
	public static String PROP_FOOTREMARKS = "Footremarks";
	public static String PROP_FEEDINGREMARKS = "Feedingremarks";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_TEMPERATURE = "Temperature";
	public static String PROP_DRESSINGREMARKS = "Dressingremarks";
	public static String PROP_FEEDING = "Feeding";
	public static String PROP_CATHEFERREMARKS = "Catheferremarks";
	public static String PROP_PTR = "Ptr";
	public static String PROP_STOOL = "Stool";
	public static String PROP_SPONGEBATH = "Spongebath";
	public static String PROP_FOOT = "Foot";
	public static String PROP_TRACHEOSTOMYREMARKS = "Tracheostomyremarks";
	public static String PROP_ORAL = "Oral";
	public static String PROP_STEAM = "Steam";
	public static String PROP_NEEDLEPRICKD = "Needleprickd";
	public static String PROP_SILDIL = "Sildil";
	public static String PROP_STEAMREMARKS = "Steamremarks";
	public static String PROP_AD_NO = "AdNo";
	public static String PROP_POSTOP = "Postop";
	public static String PROP_IPDTYPE = "Ipdtype";
	public static String PROP_CATHEFER = "Cathefer";
	public static String PROP_RESPIRATION = "Respiration";
	public static String PROP_SPONGEREMARKS = "Spongeremarks";
	public static String PROP_IPDVISITDATE = "Ipdvisitdate";
	public static String PROP_OUTPUT = "Output";
	public static String PROP_INPUT = "Input";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_WEIGHT = "Weight";
	public static String PROP_URINE = "Urine";
	public static String PROP_ID = "Id";

	// constructors
	public BaseIpdclinical() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseIpdclinical(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date ipdvisitdate;
	private java.lang.String ipdvisittime;
	private java.lang.String adNo;
	private java.lang.String backcare;
	private java.lang.String backremarks;
	private java.lang.String spongebath;
	private java.lang.String spongeremarks;
	private java.lang.String mouth;
	private java.lang.String mouthremarks;
	private java.lang.String steam;
	private java.lang.String steamremarks;
	private java.lang.String foot;
	private java.lang.String footremarks;
	private java.lang.String nebulization;
	private java.lang.String nebulizationremarks;
	private java.lang.String hair;
	private java.lang.String hairremarks;
	private java.lang.String tracheostomy;
	private java.lang.String tracheostomyremarks;
	private java.lang.String cathefer;
	private java.lang.String catheferremarks;
	private java.lang.String ryles;
	private java.lang.String rylesremarks;
	private java.lang.String postop;
	private java.lang.String postopremarks;
	private java.lang.String preop;
	private java.lang.String preoppremarks;
	private java.lang.String enema;
	private java.lang.String enemaremarks;
	private java.lang.String feeding;
	private java.lang.String feedingremarks;
	private java.lang.String dressing;
	private java.lang.String dressingremarks;
	private java.lang.String sildil;
	private java.lang.String sildilremarks;
	private java.lang.String needleprickd;
	private java.lang.String needleprickedremarks;
	private java.lang.String temperature;
	private java.lang.String respiration;
	private java.lang.String pulse;
	private java.lang.String bp;
	private java.lang.String input;
	private java.lang.String output;
	private java.lang.String weight;
	private java.lang.String treatment;
	private java.lang.String ptr;
	private java.lang.String intake;
	private java.lang.String iv;
	private java.lang.String oral;
	private java.lang.String urine;
	private java.lang.String stool;
	private java.lang.String vom;
	private java.lang.String remarks;
	private java.lang.String ipdtype;
	private java.lang.String userid;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.Patient hin;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="ipdvisit_id"
	 */
	public java.lang.Integer getId() {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * 
	 * @param id
	 *            the new ID
	 */
	public void setId(java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}

	/**
	 * Return the value associated with the column: ipdvisitdate
	 */
	public java.util.Date getIpdvisitdate() {
		return ipdvisitdate;
	}

	/**
	 * Set the value related to the column: ipdvisitdate
	 * 
	 * @param ipdvisitdate
	 *            the ipdvisitdate value
	 */
	public void setIpdvisitdate(java.util.Date ipdvisitdate) {
		this.ipdvisitdate = ipdvisitdate;
	}

	/**
	 * Return the value associated with the column: ipdvisittime
	 */
	public java.lang.String getIpdvisittime() {
		return ipdvisittime;
	}

	/**
	 * Set the value related to the column: ipdvisittime
	 * 
	 * @param ipdvisittime
	 *            the ipdvisittime value
	 */
	public void setIpdvisittime(java.lang.String ipdvisittime) {
		this.ipdvisittime = ipdvisittime;
	}

	/**
	 * Return the value associated with the column: ad_no
	 */
	public java.lang.String getAdNo() {
		return adNo;
	}

	/**
	 * Set the value related to the column: ad_no
	 * 
	 * @param adNo
	 *            the ad_no value
	 */
	public void setAdNo(java.lang.String adNo) {
		this.adNo = adNo;
	}

	/**
	 * Return the value associated with the column: backcare
	 */
	public java.lang.String getBackcare() {
		return backcare;
	}

	/**
	 * Set the value related to the column: backcare
	 * 
	 * @param backcare
	 *            the backcare value
	 */
	public void setBackcare(java.lang.String backcare) {
		this.backcare = backcare;
	}

	/**
	 * Return the value associated with the column: backremarks
	 */
	public java.lang.String getBackremarks() {
		return backremarks;
	}

	/**
	 * Set the value related to the column: backremarks
	 * 
	 * @param backremarks
	 *            the backremarks value
	 */
	public void setBackremarks(java.lang.String backremarks) {
		this.backremarks = backremarks;
	}

	/**
	 * Return the value associated with the column: spongebath
	 */
	public java.lang.String getSpongebath() {
		return spongebath;
	}

	/**
	 * Set the value related to the column: spongebath
	 * 
	 * @param spongebath
	 *            the spongebath value
	 */
	public void setSpongebath(java.lang.String spongebath) {
		this.spongebath = spongebath;
	}

	/**
	 * Return the value associated with the column: spongeremarks
	 */
	public java.lang.String getSpongeremarks() {
		return spongeremarks;
	}

	/**
	 * Set the value related to the column: spongeremarks
	 * 
	 * @param spongeremarks
	 *            the spongeremarks value
	 */
	public void setSpongeremarks(java.lang.String spongeremarks) {
		this.spongeremarks = spongeremarks;
	}

	/**
	 * Return the value associated with the column: mouth
	 */
	public java.lang.String getMouth() {
		return mouth;
	}

	/**
	 * Set the value related to the column: mouth
	 * 
	 * @param mouth
	 *            the mouth value
	 */
	public void setMouth(java.lang.String mouth) {
		this.mouth = mouth;
	}

	/**
	 * Return the value associated with the column: mouthremarks
	 */
	public java.lang.String getMouthremarks() {
		return mouthremarks;
	}

	/**
	 * Set the value related to the column: mouthremarks
	 * 
	 * @param mouthremarks
	 *            the mouthremarks value
	 */
	public void setMouthremarks(java.lang.String mouthremarks) {
		this.mouthremarks = mouthremarks;
	}

	/**
	 * Return the value associated with the column: steam
	 */
	public java.lang.String getSteam() {
		return steam;
	}

	/**
	 * Set the value related to the column: steam
	 * 
	 * @param steam
	 *            the steam value
	 */
	public void setSteam(java.lang.String steam) {
		this.steam = steam;
	}

	/**
	 * Return the value associated with the column: steamremarks
	 */
	public java.lang.String getSteamremarks() {
		return steamremarks;
	}

	/**
	 * Set the value related to the column: steamremarks
	 * 
	 * @param steamremarks
	 *            the steamremarks value
	 */
	public void setSteamremarks(java.lang.String steamremarks) {
		this.steamremarks = steamremarks;
	}

	/**
	 * Return the value associated with the column: foot
	 */
	public java.lang.String getFoot() {
		return foot;
	}

	/**
	 * Set the value related to the column: foot
	 * 
	 * @param foot
	 *            the foot value
	 */
	public void setFoot(java.lang.String foot) {
		this.foot = foot;
	}

	/**
	 * Return the value associated with the column: footremarks
	 */
	public java.lang.String getFootremarks() {
		return footremarks;
	}

	/**
	 * Set the value related to the column: footremarks
	 * 
	 * @param footremarks
	 *            the footremarks value
	 */
	public void setFootremarks(java.lang.String footremarks) {
		this.footremarks = footremarks;
	}

	/**
	 * Return the value associated with the column: nebulization
	 */
	public java.lang.String getNebulization() {
		return nebulization;
	}

	/**
	 * Set the value related to the column: nebulization
	 * 
	 * @param nebulization
	 *            the nebulization value
	 */
	public void setNebulization(java.lang.String nebulization) {
		this.nebulization = nebulization;
	}

	/**
	 * Return the value associated with the column: nebulizationremarks
	 */
	public java.lang.String getNebulizationremarks() {
		return nebulizationremarks;
	}

	/**
	 * Set the value related to the column: nebulizationremarks
	 * 
	 * @param nebulizationremarks
	 *            the nebulizationremarks value
	 */
	public void setNebulizationremarks(java.lang.String nebulizationremarks) {
		this.nebulizationremarks = nebulizationremarks;
	}

	/**
	 * Return the value associated with the column: hair
	 */
	public java.lang.String getHair() {
		return hair;
	}

	/**
	 * Set the value related to the column: hair
	 * 
	 * @param hair
	 *            the hair value
	 */
	public void setHair(java.lang.String hair) {
		this.hair = hair;
	}

	/**
	 * Return the value associated with the column: hairremarks
	 */
	public java.lang.String getHairremarks() {
		return hairremarks;
	}

	/**
	 * Set the value related to the column: hairremarks
	 * 
	 * @param hairremarks
	 *            the hairremarks value
	 */
	public void setHairremarks(java.lang.String hairremarks) {
		this.hairremarks = hairremarks;
	}

	/**
	 * Return the value associated with the column: tracheostomy
	 */
	public java.lang.String getTracheostomy() {
		return tracheostomy;
	}

	/**
	 * Set the value related to the column: tracheostomy
	 * 
	 * @param tracheostomy
	 *            the tracheostomy value
	 */
	public void setTracheostomy(java.lang.String tracheostomy) {
		this.tracheostomy = tracheostomy;
	}

	/**
	 * Return the value associated with the column: tracheostomyremarks
	 */
	public java.lang.String getTracheostomyremarks() {
		return tracheostomyremarks;
	}

	/**
	 * Set the value related to the column: tracheostomyremarks
	 * 
	 * @param tracheostomyremarks
	 *            the tracheostomyremarks value
	 */
	public void setTracheostomyremarks(java.lang.String tracheostomyremarks) {
		this.tracheostomyremarks = tracheostomyremarks;
	}

	/**
	 * Return the value associated with the column: cathefer
	 */
	public java.lang.String getCathefer() {
		return cathefer;
	}

	/**
	 * Set the value related to the column: cathefer
	 * 
	 * @param cathefer
	 *            the cathefer value
	 */
	public void setCathefer(java.lang.String cathefer) {
		this.cathefer = cathefer;
	}

	/**
	 * Return the value associated with the column: catheferremarks
	 */
	public java.lang.String getCatheferremarks() {
		return catheferremarks;
	}

	/**
	 * Set the value related to the column: catheferremarks
	 * 
	 * @param catheferremarks
	 *            the catheferremarks value
	 */
	public void setCatheferremarks(java.lang.String catheferremarks) {
		this.catheferremarks = catheferremarks;
	}

	/**
	 * Return the value associated with the column: ryles
	 */
	public java.lang.String getRyles() {
		return ryles;
	}

	/**
	 * Set the value related to the column: ryles
	 * 
	 * @param ryles
	 *            the ryles value
	 */
	public void setRyles(java.lang.String ryles) {
		this.ryles = ryles;
	}

	/**
	 * Return the value associated with the column: rylesremarks
	 */
	public java.lang.String getRylesremarks() {
		return rylesremarks;
	}

	/**
	 * Set the value related to the column: rylesremarks
	 * 
	 * @param rylesremarks
	 *            the rylesremarks value
	 */
	public void setRylesremarks(java.lang.String rylesremarks) {
		this.rylesremarks = rylesremarks;
	}

	/**
	 * Return the value associated with the column: postop
	 */
	public java.lang.String getPostop() {
		return postop;
	}

	/**
	 * Set the value related to the column: postop
	 * 
	 * @param postop
	 *            the postop value
	 */
	public void setPostop(java.lang.String postop) {
		this.postop = postop;
	}

	/**
	 * Return the value associated with the column: postopremarks
	 */
	public java.lang.String getPostopremarks() {
		return postopremarks;
	}

	/**
	 * Set the value related to the column: postopremarks
	 * 
	 * @param postopremarks
	 *            the postopremarks value
	 */
	public void setPostopremarks(java.lang.String postopremarks) {
		this.postopremarks = postopremarks;
	}

	/**
	 * Return the value associated with the column: preop
	 */
	public java.lang.String getPreop() {
		return preop;
	}

	/**
	 * Set the value related to the column: preop
	 * 
	 * @param preop
	 *            the preop value
	 */
	public void setPreop(java.lang.String preop) {
		this.preop = preop;
	}

	/**
	 * Return the value associated with the column: preoppremarks
	 */
	public java.lang.String getPreoppremarks() {
		return preoppremarks;
	}

	/**
	 * Set the value related to the column: preoppremarks
	 * 
	 * @param preoppremarks
	 *            the preoppremarks value
	 */
	public void setPreoppremarks(java.lang.String preoppremarks) {
		this.preoppremarks = preoppremarks;
	}

	/**
	 * Return the value associated with the column: enema
	 */
	public java.lang.String getEnema() {
		return enema;
	}

	/**
	 * Set the value related to the column: enema
	 * 
	 * @param enema
	 *            the enema value
	 */
	public void setEnema(java.lang.String enema) {
		this.enema = enema;
	}

	/**
	 * Return the value associated with the column: enemaremarks
	 */
	public java.lang.String getEnemaremarks() {
		return enemaremarks;
	}

	/**
	 * Set the value related to the column: enemaremarks
	 * 
	 * @param enemaremarks
	 *            the enemaremarks value
	 */
	public void setEnemaremarks(java.lang.String enemaremarks) {
		this.enemaremarks = enemaremarks;
	}

	/**
	 * Return the value associated with the column: feeding
	 */
	public java.lang.String getFeeding() {
		return feeding;
	}

	/**
	 * Set the value related to the column: feeding
	 * 
	 * @param feeding
	 *            the feeding value
	 */
	public void setFeeding(java.lang.String feeding) {
		this.feeding = feeding;
	}

	/**
	 * Return the value associated with the column: feedingremarks
	 */
	public java.lang.String getFeedingremarks() {
		return feedingremarks;
	}

	/**
	 * Set the value related to the column: feedingremarks
	 * 
	 * @param feedingremarks
	 *            the feedingremarks value
	 */
	public void setFeedingremarks(java.lang.String feedingremarks) {
		this.feedingremarks = feedingremarks;
	}

	/**
	 * Return the value associated with the column: dressing
	 */
	public java.lang.String getDressing() {
		return dressing;
	}

	/**
	 * Set the value related to the column: dressing
	 * 
	 * @param dressing
	 *            the dressing value
	 */
	public void setDressing(java.lang.String dressing) {
		this.dressing = dressing;
	}

	/**
	 * Return the value associated with the column: dressingremarks
	 */
	public java.lang.String getDressingremarks() {
		return dressingremarks;
	}

	/**
	 * Set the value related to the column: dressingremarks
	 * 
	 * @param dressingremarks
	 *            the dressingremarks value
	 */
	public void setDressingremarks(java.lang.String dressingremarks) {
		this.dressingremarks = dressingremarks;
	}

	/**
	 * Return the value associated with the column: sildil
	 */
	public java.lang.String getSildil() {
		return sildil;
	}

	/**
	 * Set the value related to the column: sildil
	 * 
	 * @param sildil
	 *            the sildil value
	 */
	public void setSildil(java.lang.String sildil) {
		this.sildil = sildil;
	}

	/**
	 * Return the value associated with the column: sildilremarks
	 */
	public java.lang.String getSildilremarks() {
		return sildilremarks;
	}

	/**
	 * Set the value related to the column: sildilremarks
	 * 
	 * @param sildilremarks
	 *            the sildilremarks value
	 */
	public void setSildilremarks(java.lang.String sildilremarks) {
		this.sildilremarks = sildilremarks;
	}

	/**
	 * Return the value associated with the column: needleprickd
	 */
	public java.lang.String getNeedleprickd() {
		return needleprickd;
	}

	/**
	 * Set the value related to the column: needleprickd
	 * 
	 * @param needleprickd
	 *            the needleprickd value
	 */
	public void setNeedleprickd(java.lang.String needleprickd) {
		this.needleprickd = needleprickd;
	}

	/**
	 * Return the value associated with the column: needleprickedremarks
	 */
	public java.lang.String getNeedleprickedremarks() {
		return needleprickedremarks;
	}

	/**
	 * Set the value related to the column: needleprickedremarks
	 * 
	 * @param needleprickedremarks
	 *            the needleprickedremarks value
	 */
	public void setNeedleprickedremarks(java.lang.String needleprickedremarks) {
		this.needleprickedremarks = needleprickedremarks;
	}

	/**
	 * Return the value associated with the column: temperature
	 */
	public java.lang.String getTemperature() {
		return temperature;
	}

	/**
	 * Set the value related to the column: temperature
	 * 
	 * @param temperature
	 *            the temperature value
	 */
	public void setTemperature(java.lang.String temperature) {
		this.temperature = temperature;
	}

	/**
	 * Return the value associated with the column: respiration
	 */
	public java.lang.String getRespiration() {
		return respiration;
	}

	/**
	 * Set the value related to the column: respiration
	 * 
	 * @param respiration
	 *            the respiration value
	 */
	public void setRespiration(java.lang.String respiration) {
		this.respiration = respiration;
	}

	/**
	 * Return the value associated with the column: pulse
	 */
	public java.lang.String getPulse() {
		return pulse;
	}

	/**
	 * Set the value related to the column: pulse
	 * 
	 * @param pulse
	 *            the pulse value
	 */
	public void setPulse(java.lang.String pulse) {
		this.pulse = pulse;
	}

	/**
	 * Return the value associated with the column: bp
	 */
	public java.lang.String getBp() {
		return bp;
	}

	/**
	 * Set the value related to the column: bp
	 * 
	 * @param bp
	 *            the bp value
	 */
	public void setBp(java.lang.String bp) {
		this.bp = bp;
	}

	/**
	 * Return the value associated with the column: input
	 */
	public java.lang.String getInput() {
		return input;
	}

	/**
	 * Set the value related to the column: input
	 * 
	 * @param input
	 *            the input value
	 */
	public void setInput(java.lang.String input) {
		this.input = input;
	}

	/**
	 * Return the value associated with the column: output
	 */
	public java.lang.String getOutput() {
		return output;
	}

	/**
	 * Set the value related to the column: output
	 * 
	 * @param output
	 *            the output value
	 */
	public void setOutput(java.lang.String output) {
		this.output = output;
	}

	/**
	 * Return the value associated with the column: weight
	 */
	public java.lang.String getWeight() {
		return weight;
	}

	/**
	 * Set the value related to the column: weight
	 * 
	 * @param weight
	 *            the weight value
	 */
	public void setWeight(java.lang.String weight) {
		this.weight = weight;
	}

	/**
	 * Return the value associated with the column: treatment
	 */
	public java.lang.String getTreatment() {
		return treatment;
	}

	/**
	 * Set the value related to the column: treatment
	 * 
	 * @param treatment
	 *            the treatment value
	 */
	public void setTreatment(java.lang.String treatment) {
		this.treatment = treatment;
	}

	/**
	 * Return the value associated with the column: ptr
	 */
	public java.lang.String getPtr() {
		return ptr;
	}

	/**
	 * Set the value related to the column: ptr
	 * 
	 * @param ptr
	 *            the ptr value
	 */
	public void setPtr(java.lang.String ptr) {
		this.ptr = ptr;
	}

	/**
	 * Return the value associated with the column: intake
	 */
	public java.lang.String getIntake() {
		return intake;
	}

	/**
	 * Set the value related to the column: intake
	 * 
	 * @param intake
	 *            the intake value
	 */
	public void setIntake(java.lang.String intake) {
		this.intake = intake;
	}

	/**
	 * Return the value associated with the column: iv
	 */
	public java.lang.String getIv() {
		return iv;
	}

	/**
	 * Set the value related to the column: iv
	 * 
	 * @param iv
	 *            the iv value
	 */
	public void setIv(java.lang.String iv) {
		this.iv = iv;
	}

	/**
	 * Return the value associated with the column: oral
	 */
	public java.lang.String getOral() {
		return oral;
	}

	/**
	 * Set the value related to the column: oral
	 * 
	 * @param oral
	 *            the oral value
	 */
	public void setOral(java.lang.String oral) {
		this.oral = oral;
	}

	/**
	 * Return the value associated with the column: urine
	 */
	public java.lang.String getUrine() {
		return urine;
	}

	/**
	 * Set the value related to the column: urine
	 * 
	 * @param urine
	 *            the urine value
	 */
	public void setUrine(java.lang.String urine) {
		this.urine = urine;
	}

	/**
	 * Return the value associated with the column: stool
	 */
	public java.lang.String getStool() {
		return stool;
	}

	/**
	 * Set the value related to the column: stool
	 * 
	 * @param stool
	 *            the stool value
	 */
	public void setStool(java.lang.String stool) {
		this.stool = stool;
	}

	/**
	 * Return the value associated with the column: vom
	 */
	public java.lang.String getVom() {
		return vom;
	}

	/**
	 * Set the value related to the column: vom
	 * 
	 * @param vom
	 *            the vom value
	 */
	public void setVom(java.lang.String vom) {
		this.vom = vom;
	}

	/**
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks() {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * 
	 * @param remarks
	 *            the remarks value
	 */
	public void setRemarks(java.lang.String remarks) {
		this.remarks = remarks;
	}

	/**
	 * Return the value associated with the column: ipdtype
	 */
	public java.lang.String getIpdtype() {
		return ipdtype;
	}

	/**
	 * Set the value related to the column: ipdtype
	 * 
	 * @param ipdtype
	 *            the ipdtype value
	 */
	public void setIpdtype(java.lang.String ipdtype) {
		this.ipdtype = ipdtype;
	}

	/**
	 * Return the value associated with the column: userid
	 */
	public java.lang.String getUserid() {
		return userid;
	}

	/**
	 * Set the value related to the column: userid
	 * 
	 * @param userid
	 *            the userid value
	 */
	public void setUserid(java.lang.String userid) {
		this.userid = userid;
	}

	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.String getLastChgBy() {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * 
	 * @param lastChgBy
	 *            the last_chg_by value
	 */
	public void setLastChgBy(java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
	}

	/**
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate() {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * 
	 * @param lastChgDate
	 *            the last_chg_date value
	 */
	public void setLastChgDate(java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}

	/**
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime() {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * 
	 * @param lastChgTime
	 *            the last_chg_time value
	 */
	public void setLastChgTime(java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}

	/**
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital() {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * 
	 * @param hospital
	 *            the hospital_id value
	 */
	public void setHospital(jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}

	/**
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment() {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * 
	 * @param department
	 *            the department_id value
	 */
	public void setDepartment(jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}

	/**
	 * Return the value associated with the column: hin_id
	 */
	public jkt.hms.masters.business.Patient getHin() {
		return hin;
	}

	/**
	 * Set the value related to the column: hin_id
	 * 
	 * @param hin
	 *            the hin_id value
	 */
	public void setHin(jkt.hms.masters.business.Patient hin) {
		this.hin = hin;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.Ipdclinical))
			return false;
		else {
			jkt.hms.masters.business.Ipdclinical ipdclinical = (jkt.hms.masters.business.Ipdclinical) obj;
			if (null == this.getId() || null == ipdclinical.getId())
				return false;
			else
				return (this.getId().equals(ipdclinical.getId()));
		}
	}

	public int hashCode() {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId())
				return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":"
						+ this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}

	public String toString() {
		return super.toString();
	}

}
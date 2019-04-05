package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the MLC_CASE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="MLC_CASE"
 */

public abstract class BaseMlcCase  implements Serializable {

	public static String REF = "MlcCase";
	public static String PROP_CONSTABLE_NO = "ConstableNo";
	public static String PROP_INJURY_DESCRIPTION = "InjuryDescription";
	public static String PROP_SENT_DATE = "SentDate";
	public static String PROP_INJURY_NOMENCLATURE = "InjuryNomenclature";
	public static String PROP_ITEM_DEPOSITED = "ItemDeposited";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_MLC_NO = "MlcNo";
	public static String PROP_NATURE_OF_MLC = "NatureOfMlc";
	public static String PROP_ITEM_DETAILS = "ItemDetails";
	public static String PROP_POLICE_DOCKET_NO = "PoliceDocketNo";
	public static String PROP_WEAPON_USED = "WeaponUsed";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_ARRIVAL_DATE = "ArrivalDate";
	public static String PROP_KIT_DEPOSITED = "KitDeposited";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_INPATIENT = "Inpatient";
	public static String PROP_ARRIVAL_TIME = "ArrivalTime";
	public static String PROP_POLICE_STATION = "PoliceStation";
	public static String PROP_BROUGHT_BY = "BroughtBy";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_VISIT = "Visit";
	public static String PROP_TYPE_OF_INJURY = "TypeOfInjury";
	public static String PROP_INJURY_NATURE = "InjuryNature";
	public static String PROP_DISPOSAL = "Disposal";
	public static String PROP_SENT_TIME = "SentTime";
	public static String PROP_INJURY_POSITION_HISTORY = "InjuryPositionHistory";
	public static String PROP_CASE_SUMMARY = "CaseSummary";
	public static String PROP_ID = "Id";
	public static String PROP_CONSTABLE_NAME = "ConstableName";
	public static String PROP_AGENCY_INFORMED = "AgencyInformed";
	public static String PROP_HIN = "Hin";
	public static String PROP_ID_MARK1 = "IdMark1";
	public static String PROP_ID_MARK2 = "IdMark2";


	// constructors
	public BaseMlcCase () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMlcCase (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String mlcNo;
	private java.util.Date arrivalDate;
	private java.lang.String arrivalTime;
	private java.lang.String natureOfMlc;
	private java.lang.String typeOfInjury;
	private java.lang.String policeDocketNo;
	private java.lang.String constableName;
	private java.lang.String constableNo;
	private java.lang.String idMark1;
	private java.lang.String idMark2;
	private java.lang.String itemDeposited;
	private java.lang.String itemDetails;
	private java.lang.String kitDeposited;
	private java.lang.String injuryPositionHistory;
	private java.lang.String injuryNomenclature;
	private java.lang.String weaponUsed;
	private java.lang.String policeStation;
	private java.util.Date sentDate;
	private java.lang.String sentTime;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String caseSummary;
	private java.lang.String injuryDescription;
	private java.lang.String broughtBy;
	private java.lang.String agencyInformed;
	private java.lang.String disposal;

	// many to one
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.Visit visit;
	private jkt.hms.masters.business.Inpatient inpatient;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasInjuryNature injuryNature;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="mlc_id"
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
	 * Return the value associated with the column: MLC_NO
	 */
	public java.lang.String getMlcNo () {
		return mlcNo;
	}

	/**
	 * Set the value related to the column: MLC_NO
	 * @param mlcNo the MLC_NO value
	 */
	public void setMlcNo (java.lang.String mlcNo) {
		this.mlcNo = mlcNo;
	}



	/**
	 * Return the value associated with the column: ARRIVAL_DATE
	 */
	public java.util.Date getArrivalDate () {
		return arrivalDate;
	}

	/**
	 * Set the value related to the column: ARRIVAL_DATE
	 * @param arrivalDate the ARRIVAL_DATE value
	 */
	public void setArrivalDate (java.util.Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}



	/**
	 * Return the value associated with the column: ARRIVAL_TIME
	 */
	public java.lang.String getArrivalTime () {
		return arrivalTime;
	}

	/**
	 * Set the value related to the column: ARRIVAL_TIME
	 * @param arrivalTime the ARRIVAL_TIME value
	 */
	public void setArrivalTime (java.lang.String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}



	/**
	 * Return the value associated with the column: NATURE_OF_MLC
	 */
	public java.lang.String getNatureOfMlc () {
		return natureOfMlc;
	}

	/**
	 * Set the value related to the column: NATURE_OF_MLC
	 * @param natureOfMlc the NATURE_OF_MLC value
	 */
	public void setNatureOfMlc (java.lang.String natureOfMlc) {
		this.natureOfMlc = natureOfMlc;
	}



	/**
	 * Return the value associated with the column: TYPE_OF_INJURY
	 */
	public java.lang.String getTypeOfInjury () {
		return typeOfInjury;
	}

	/**
	 * Set the value related to the column: TYPE_OF_INJURY
	 * @param typeOfInjury the TYPE_OF_INJURY value
	 */
	public void setTypeOfInjury (java.lang.String typeOfInjury) {
		this.typeOfInjury = typeOfInjury;
	}



	/**
	 * Return the value associated with the column: POLICE_DOCKET_NO
	 */
	public java.lang.String getPoliceDocketNo () {
		return policeDocketNo;
	}

	/**
	 * Set the value related to the column: POLICE_DOCKET_NO
	 * @param policeDocketNo the POLICE_DOCKET_NO value
	 */
	public void setPoliceDocketNo (java.lang.String policeDocketNo) {
		this.policeDocketNo = policeDocketNo;
	}



	/**
	 * Return the value associated with the column: CONSTABLE_NAME
	 */
	public java.lang.String getConstableName () {
		return constableName;
	}

	/**
	 * Set the value related to the column: CONSTABLE_NAME
	 * @param constableName the CONSTABLE_NAME value
	 */
	public void setConstableName (java.lang.String constableName) {
		this.constableName = constableName;
	}



	/**
	 * Return the value associated with the column: CONSTABLE_NO
	 */
	public java.lang.String getConstableNo () {
		return constableNo;
	}

	/**
	 * Set the value related to the column: CONSTABLE_NO
	 * @param constableNo the CONSTABLE_NO value
	 */
	public void setConstableNo (java.lang.String constableNo) {
		this.constableNo = constableNo;
	}



	/**
	 * Return the value associated with the column: ID_MARK1
	 */
	public java.lang.String getIdMark1 () {
		return idMark1;
	}

	/**
	 * Set the value related to the column: ID_MARK1
	 * @param idMark1 the ID_MARK1 value
	 */
	public void setIdMark1 (java.lang.String idMark1) {
		this.idMark1 = idMark1;
	}



	/**
	 * Return the value associated with the column: ID_MARK2
	 */
	public java.lang.String getIdMark2 () {
		return idMark2;
	}

	/**
	 * Set the value related to the column: ID_MARK2
	 * @param idMark2 the ID_MARK2 value
	 */
	public void setIdMark2 (java.lang.String idMark2) {
		this.idMark2 = idMark2;
	}



	/**
	 * Return the value associated with the column: ITEM_DEPOSITED
	 */
	public java.lang.String getItemDeposited () {
		return itemDeposited;
	}

	/**
	 * Set the value related to the column: ITEM_DEPOSITED
	 * @param itemDeposited the ITEM_DEPOSITED value
	 */
	public void setItemDeposited (java.lang.String itemDeposited) {
		this.itemDeposited = itemDeposited;
	}



	/**
	 * Return the value associated with the column: ITEM_DETAILS
	 */
	public java.lang.String getItemDetails () {
		return itemDetails;
	}

	/**
	 * Set the value related to the column: ITEM_DETAILS
	 * @param itemDetails the ITEM_DETAILS value
	 */
	public void setItemDetails (java.lang.String itemDetails) {
		this.itemDetails = itemDetails;
	}



	/**
	 * Return the value associated with the column: KIT_DEPOSITED
	 */
	public java.lang.String getKitDeposited () {
		return kitDeposited;
	}

	/**
	 * Set the value related to the column: KIT_DEPOSITED
	 * @param kitDeposited the KIT_DEPOSITED value
	 */
	public void setKitDeposited (java.lang.String kitDeposited) {
		this.kitDeposited = kitDeposited;
	}



	/**
	 * Return the value associated with the column: INJURY_POSITION_HISTORY
	 */
	public java.lang.String getInjuryPositionHistory () {
		return injuryPositionHistory;
	}

	/**
	 * Set the value related to the column: INJURY_POSITION_HISTORY
	 * @param injuryPositionHistory the INJURY_POSITION_HISTORY value
	 */
	public void setInjuryPositionHistory (java.lang.String injuryPositionHistory) {
		this.injuryPositionHistory = injuryPositionHistory;
	}



	/**
	 * Return the value associated with the column: INJURY_NOMENCLATURE
	 */
	public java.lang.String getInjuryNomenclature () {
		return injuryNomenclature;
	}

	/**
	 * Set the value related to the column: INJURY_NOMENCLATURE
	 * @param injuryNomenclature the INJURY_NOMENCLATURE value
	 */
	public void setInjuryNomenclature (java.lang.String injuryNomenclature) {
		this.injuryNomenclature = injuryNomenclature;
	}



	/**
	 * Return the value associated with the column: WEAPON_USED
	 */
	public java.lang.String getWeaponUsed () {
		return weaponUsed;
	}

	/**
	 * Set the value related to the column: WEAPON_USED
	 * @param weaponUsed the WEAPON_USED value
	 */
	public void setWeaponUsed (java.lang.String weaponUsed) {
		this.weaponUsed = weaponUsed;
	}



	/**
	 * Return the value associated with the column: POLICE_STATION
	 */
	public java.lang.String getPoliceStation () {
		return policeStation;
	}

	/**
	 * Set the value related to the column: POLICE_STATION
	 * @param policeStation the POLICE_STATION value
	 */
	public void setPoliceStation (java.lang.String policeStation) {
		this.policeStation = policeStation;
	}



	/**
	 * Return the value associated with the column: SENT_DATE
	 */
	public java.util.Date getSentDate () {
		return sentDate;
	}

	/**
	 * Set the value related to the column: SENT_DATE
	 * @param sentDate the SENT_DATE value
	 */
	public void setSentDate (java.util.Date sentDate) {
		this.sentDate = sentDate;
	}



	/**
	 * Return the value associated with the column: SENT_TIME
	 */
	public java.lang.String getSentTime () {
		return sentTime;
	}

	/**
	 * Set the value related to the column: SENT_TIME
	 * @param sentTime the SENT_TIME value
	 */
	public void setSentTime (java.lang.String sentTime) {
		this.sentTime = sentTime;
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
	 * Return the value associated with the column: case_summary
	 */
	public java.lang.String getCaseSummary () {
		return caseSummary;
	}

	/**
	 * Set the value related to the column: case_summary
	 * @param caseSummary the case_summary value
	 */
	public void setCaseSummary (java.lang.String caseSummary) {
		this.caseSummary = caseSummary;
	}



	/**
	 * Return the value associated with the column: injury_description
	 */
	public java.lang.String getInjuryDescription () {
		return injuryDescription;
	}

	/**
	 * Set the value related to the column: injury_description
	 * @param injuryDescription the injury_description value
	 */
	public void setInjuryDescription (java.lang.String injuryDescription) {
		this.injuryDescription = injuryDescription;
	}



	/**
	 * Return the value associated with the column: brought_by
	 */
	public java.lang.String getBroughtBy () {
		return broughtBy;
	}

	/**
	 * Set the value related to the column: brought_by
	 * @param broughtBy the brought_by value
	 */
	public void setBroughtBy (java.lang.String broughtBy) {
		this.broughtBy = broughtBy;
	}



	/**
	 * Return the value associated with the column: agency_informed
	 */
	public java.lang.String getAgencyInformed () {
		return agencyInformed;
	}

	/**
	 * Set the value related to the column: agency_informed
	 * @param agencyInformed the agency_informed value
	 */
	public void setAgencyInformed (java.lang.String agencyInformed) {
		this.agencyInformed = agencyInformed;
	}



	/**
	 * Return the value associated with the column: disposal
	 */
	public java.lang.String getDisposal () {
		return disposal;
	}

	/**
	 * Set the value related to the column: disposal
	 * @param disposal the disposal value
	 */
	public void setDisposal (java.lang.String disposal) {
		this.disposal = disposal;
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
	 * Return the value associated with the column: visit_id
	 */
	public jkt.hms.masters.business.Visit getVisit () {
		return visit;
	}

	/**
	 * Set the value related to the column: visit_id
	 * @param visit the visit_id value
	 */
	public void setVisit (jkt.hms.masters.business.Visit visit) {
		this.visit = visit;
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
	 * Return the value associated with the column: NATURE_OF_INJURY_ID
	 */
	public jkt.hms.masters.business.MasInjuryNature getInjuryNature () {
		return injuryNature;
	}

	/**
	 * Set the value related to the column: NATURE_OF_INJURY_ID
	 * @param injuryNature the NATURE_OF_INJURY_ID value
	 */
	public void setInjuryNature (jkt.hms.masters.business.MasInjuryNature injuryNature) {
		this.injuryNature = injuryNature;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MlcCase)) return false;
		else {
			jkt.hms.masters.business.MlcCase mlcCase = (jkt.hms.masters.business.MlcCase) obj;
			if (null == this.getId() || null == mlcCase.getId()) return false;
			else return (this.getId().equals(mlcCase.getId()));
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
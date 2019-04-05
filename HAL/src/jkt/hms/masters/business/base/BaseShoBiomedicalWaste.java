package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the SHO_BIOMEDICAL_WASTE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="SHO_BIOMEDICAL_WASTE"
 */

public abstract class BaseShoBiomedicalWaste  implements Serializable {

	public static String REF = "ShoBiomedicalWaste";
	public static String PROP_MAY_CAT_SEVEN = "MayCatSeven";
	public static String PROP_SHREDDER = "Shredder";
	public static String PROP_APR_CAT_FIVE = "AprCatFive";
	public static String PROP_NOV_CAT_EIGHT = "NovCatEight";
	public static String PROP_DEC_CAT_EIGHT = "DecCatEight";
	public static String PROP_NOV_CAT_ONE_THREE = "NovCatOneThree";
	public static String PROP_SEP_CAT_NINE_TEN = "SepCatNineTen";
	public static String PROP_SEP_CAT_EIGHT = "SepCatEight";
	public static String PROP_AUG_CAT_SIX = "AugCatSix";
	public static String PROP_AUG_CAT_FIVE = "AugCatFive";
	public static String PROP_FEB_CAT_SIX = "FebCatSix";
	public static String PROP_JUN_CAT_EIGHT = "JunCatEight";
	public static String PROP_NOV_CAT_FIVE = "NovCatFive";
	public static String PROP_OCT_CAT_EIGHT = "OctCatEight";
	public static String PROP_NEEDLE_DESTROYER = "NeedleDestroyer";
	public static String PROP_JUN_CAT_NINE_TEN = "JunCatNineTen";
	public static String PROP_KNOWLEDGE_ATTITUDE = "KnowledgeAttitude";
	public static String PROP_JAN_CAT_FIVE = "JanCatFive";
	public static String PROP_MAR_CAT_FOUR = "MarCatFour";
	public static String PROP_DEC_CAT_ONE_THREE = "DecCatOneThree";
	public static String PROP_MODE_OF_TRANSPORTATION = "ModeOfTransportation";
	public static String PROP_ADDRESS_OF_FACILITY = "AddressOfFacility";
	public static String PROP_FEB_CAT_FOUR = "FebCatFour";
	public static String PROP_FEB_CAT_EIGHT = "FebCatEight";
	public static String PROP_DEC_CAT_SIX = "DecCatSix";
	public static String PROP_TOTAL_CAT_FIVE = "TotalCatFive";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_MAR_CAT_SIX = "MarCatSix";
	public static String PROP_AUG_CAT_SEVEN = "AugCatSeven";
	public static String PROP_COMMAND_ZONE = "CommandZone";
	public static String PROP_SEP_CAT_FOUR = "SepCatFour";
	public static String PROP_DEC_CAT_NINE_TEN = "DecCatNineTen";
	public static String PROP_TOTAL_CAT_SEVEN = "TotalCatSeven";
	public static String PROP_TOTAL_CAT_ONE_THREE = "TotalCatOneThree";
	public static String PROP_BRIEF_DETAIL = "BriefDetail";
	public static String PROP_FEB_CAT_FIVE = "FebCatFive";
	public static String PROP_JUL_CAT_SIX = "JulCatSix";
	public static String PROP_OPERATOR_NAME = "OperatorName";
	public static String PROP_OCT_CAT_SEVEN = "OctCatSeven";
	public static String PROP_APR_CAT_NINE_TEN = "AprCatNineTen";
	public static String PROP_HYDROCLAVE = "Hydroclave";
	public static String PROP_AUTOCLAVE = "Autoclave";
	public static String PROP_OCT_CAT_FIVE = "OctCatFive";
	public static String PROP_MAR_CAT_NINE_TEN = "MarCatNineTen";
	public static String PROP_DEC_CAT_FOUR = "DecCatFour";
	public static String PROP_JUL_CAT_FIVE = "JulCatFive";
	public static String PROP_MICROWAVE = "Microwave";
	public static String PROP_OFFSITE = "Offsite";
	public static String PROP_USE_OF_PRESONEL = "UseOfPresonel";
	public static String PROP_FINAL_OBSERVATION = "FinalObservation";
	public static String PROP_APR_CAT_FOUR = "AprCatFour";
	public static String PROP_SEP_CAT_FIVE = "SepCatFive";
	public static String PROP_INCINERATOR = "Incinerator";
	public static String PROP_MAY_CAT_FOUR = "MayCatFour";
	public static String PROP_BIOMEDICAL_ID = "BiomedicalId";
	public static String PROP_APR_CAT_ONE_THREE = "AprCatOneThree";
	public static String PROP_JUL_CAT_NINE_TEN = "JulCatNineTen";
	public static String PROP_MAR_CAT_EIGHT = "MarCatEight";
	public static String PROP_APR_CAT_SIX = "AprCatSix";
	public static String PROP_MAY_CAT_NINE_TEN = "MayCatNineTen";
	public static String PROP_MAY_CAT_ONE_THREE = "MayCatOneThree";
	public static String PROP_JAN_CAT_ONE_THREE = "JanCatOneThree";
	public static String PROP_JAN_CAT_EIGHT = "JanCatEight";
	public static String PROP_OCT_CAT_SIX = "OctCatSix";
	public static String PROP_NOV_CAT_SEVEN = "NovCatSeven";
	public static String PROP_TOTAL_CAT_EIGHT = "TotalCatEight";
	public static String PROP_OCT_CAT_NINE_TEN = "OctCatNineTen";
	public static String PROP_COMMANDING_OFFICER_NAME = "CommandingOfficerName";
	public static String PROP_AUTHORISED_PERSON_NAME = "AuthorisedPersonName";
	public static String PROP_MAY_CAT_FIVE = "MayCatFive";
	public static String PROP_NOV_CAT_SIX = "NovCatSix";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_AUG_CAT_NINE_TEN = "AugCatNineTen";
	public static String PROP_JAN_CAT_SEVEN = "JanCatSeven";
	public static String PROP_JAN_CAT_NINE_TEN = "JanCatNineTen";
	public static String PROP_MAY_CAT_EIGHT = "MayCatEight";
	public static String PROP_TOTAL_CAT_FOUR = "TotalCatFour";
	public static String PROP_FEB_CAT_NINE_TEN = "FebCatNineTen";
	public static String PROP_TOTAL_CAT_SIX = "TotalCatSix";
	public static String PROP_NOV_CAT_NINE_TEN = "NovCatNineTen";
	public static String PROP_APR_CAT_EIGHT = "AprCatEight";
	public static String PROP_JAN_CAT_SIX = "JanCatSix";
	public static String PROP_MAR_CAT_ONE_THREE = "MarCatOneThree";
	public static String PROP_JUL_CAT_FOUR = "JulCatFour";
	public static String PROP_MAR_CAT_SEVEN = "MarCatSeven";
	public static String PROP_DEC_CAT_SEVEN = "DecCatSeven";
	public static String PROP_FEB_CAT_ONE_THREE = "FebCatOneThree";
	public static String PROP_OCT_CAT_FOUR = "OctCatFour";
	public static String PROP_FEB_CAT_SEVEN = "FebCatSeven";
	public static String PROP_NAME_OF_INSTITUTION = "NameOfInstitution";
	public static String PROP_SEP_CAT_SIX = "SepCatSix";
	public static String PROP_JUN_CAT_SEVEN = "JunCatSeven";
	public static String PROP_MAR_CAT_FIVE = "MarCatFive";
	public static String PROP_JUN_CAT_FIVE = "JunCatFive";
	public static String PROP_JAN_CAT_FOUR = "JanCatFour";
	public static String PROP_JUL_CAT_ONE_THREE = "JulCatOneThree";
	public static String PROP_SEP_CAT_ONE_THREE = "SepCatOneThree";
	public static String PROP_JUN_CAT_SIX = "JunCatSix";
	public static String PROP_DEC_CAT_FIVE = "DecCatFive";
	public static String PROP_JUN_CAT_ONE_THREE = "JunCatOneThree";
	public static String PROP_NOV_CAT_FOUR = "NovCatFour";
	public static String PROP_DEEP_BURIAL = "DeepBurial";
	public static String PROP_TOTAL_CAT_NINE_TEN = "TotalCatNineTen";
	public static String PROP_JUL_CAT_SEVEN = "JulCatSeven";
	public static String PROP_OTHER_FORM_OF_HANDLING = "OtherFormOfHandling";
	public static String PROP_JUN_CAT_FOUR = "JunCatFour";
	public static String PROP_OCT_CAT_ONE_THREE = "OctCatOneThree";
	public static String PROP_COLLECTION_STORAGE = "CollectionStorage";
	public static String PROP_AUG_CAT_EIGHT = "AugCatEight";
	public static String PROP_AUG_CAT_FOUR = "AugCatFour";
	public static String PROP_APR_CAT_SEVEN = "AprCatSeven";
	public static String PROP_AUG_CAT_ONE_THREE = "AugCatOneThree";
	public static String PROP_SEP_CAT_SEVEN = "SepCatSeven";
	public static String PROP_MAY_CAT_SIX = "MayCatSix";
	public static String PROP_DATE_OF_INSPECTION = "DateOfInspection";
	public static String PROP_JUL_CAT_EIGHT = "JulCatEight";


	// constructors
	public BaseShoBiomedicalWaste () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseShoBiomedicalWaste (java.lang.Integer biomedicalId) {
		this.setBiomedicalId(biomedicalId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer biomedicalId;

	// fields
	private java.lang.String authorisedPersonName;
	private java.lang.String commandZone;
	private java.util.Date dateOfInspection;
	private java.lang.String commandingOfficerName;
	private java.lang.String briefDetail;
	private java.lang.String offsite;
	private java.lang.String operatorName;
	private java.lang.String addressOfFacility;
	private java.lang.String janCatOneThree;
	private java.lang.String janCatFour;
	private java.lang.String janCatFive;
	private java.lang.String janCatSix;
	private java.lang.String janCatSeven;
	private java.lang.String janCatEight;
	private java.lang.String janCatNineTen;
	private java.lang.String febCatOneThree;
	private java.lang.String febCatFour;
	private java.lang.String febCatFive;
	private java.lang.String febCatSix;
	private java.lang.String febCatSeven;
	private java.lang.String febCatEight;
	private java.lang.String febCatNineTen;
	private java.lang.String marCatOneThree;
	private java.lang.String marCatFour;
	private java.lang.String marCatFive;
	private java.lang.String marCatSix;
	private java.lang.String marCatSeven;
	private java.lang.String marCatEight;
	private java.lang.String marCatNineTen;
	private java.lang.String aprCatOneThree;
	private java.lang.String aprCatFour;
	private java.lang.String aprCatFive;
	private java.lang.String aprCatSix;
	private java.lang.String aprCatSeven;
	private java.lang.String aprCatEight;
	private java.lang.String aprCatNineTen;
	private java.lang.String mayCatOneThree;
	private java.lang.String mayCatFour;
	private java.lang.String mayCatFive;
	private java.lang.String mayCatSix;
	private java.lang.String mayCatSeven;
	private java.lang.String mayCatEight;
	private java.lang.String mayCatNineTen;
	private java.lang.String junCatOneThree;
	private java.lang.String junCatFour;
	private java.lang.String junCatFive;
	private java.lang.String junCatSix;
	private java.lang.String junCatSeven;
	private java.lang.String junCatEight;
	private java.lang.String junCatNineTen;
	private java.lang.String julCatOneThree;
	private java.lang.String julCatFour;
	private java.lang.String julCatFive;
	private java.lang.String julCatSix;
	private java.lang.String julCatSeven;
	private java.lang.String julCatEight;
	private java.lang.String julCatNineTen;
	private java.lang.String augCatOneThree;
	private java.lang.String augCatFour;
	private java.lang.String augCatFive;
	private java.lang.String augCatSix;
	private java.lang.String augCatSeven;
	private java.lang.String augCatEight;
	private java.lang.String augCatNineTen;
	private java.lang.String sepCatOneThree;
	private java.lang.String sepCatFour;
	private java.lang.String sepCatFive;
	private java.lang.String sepCatSix;
	private java.lang.String sepCatSeven;
	private java.lang.String sepCatEight;
	private java.lang.String sepCatNineTen;
	private java.lang.String octCatOneThree;
	private java.lang.String octCatFour;
	private java.lang.String octCatFive;
	private java.lang.String octCatSix;
	private java.lang.String octCatSeven;
	private java.lang.String octCatEight;
	private java.lang.String octCatNineTen;
	private java.lang.String novCatOneThree;
	private java.lang.String novCatFour;
	private java.lang.String novCatFive;
	private java.lang.String novCatSix;
	private java.lang.String novCatSeven;
	private java.lang.String novCatEight;
	private java.lang.String novCatNineTen;
	private java.lang.String decCatOneThree;
	private java.lang.String decCatFour;
	private java.lang.String decCatFive;
	private java.lang.String decCatSix;
	private java.lang.String decCatSeven;
	private java.lang.String decCatEight;
	private java.lang.String decCatNineTen;
	private java.lang.String totalCatOneThree;
	private java.lang.String totalCatFour;
	private java.lang.String totalCatFive;
	private java.lang.String totalCatSix;
	private java.lang.String totalCatSeven;
	private java.lang.String totalCatEight;
	private java.lang.String totalCatNineTen;
	private java.lang.String collectionStorage;
	private java.lang.String modeOfTransportation;
	private java.lang.String knowledgeAttitude;
	private java.lang.String useOfPresonel;
	private java.lang.String incinerator;
	private java.lang.String deepBurial;
	private java.lang.String microwave;
	private java.lang.String autoclave;
	private java.lang.String hydroclave;
	private java.lang.String shredder;
	private java.lang.String needleDestroyer;
	private java.lang.String otherFormOfHandling;
	private java.lang.String remarks;
	private java.lang.String finalObservation;
	private java.lang.String nameOfInstitution;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="BIOMEDICAL_ID"
     */
	public java.lang.Integer getBiomedicalId () {
		return biomedicalId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param biomedicalId the new ID
	 */
	public void setBiomedicalId (java.lang.Integer biomedicalId) {
		this.biomedicalId = biomedicalId;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: AUTHORISED_PERSON_NAME
	 */
	public java.lang.String getAuthorisedPersonName () {
		return authorisedPersonName;
	}

	/**
	 * Set the value related to the column: AUTHORISED_PERSON_NAME
	 * @param authorisedPersonName the AUTHORISED_PERSON_NAME value
	 */
	public void setAuthorisedPersonName (java.lang.String authorisedPersonName) {
		this.authorisedPersonName = authorisedPersonName;
	}



	/**
	 * Return the value associated with the column: COMMAND_ZONE
	 */
	public java.lang.String getCommandZone () {
		return commandZone;
	}

	/**
	 * Set the value related to the column: COMMAND_ZONE
	 * @param commandZone the COMMAND_ZONE value
	 */
	public void setCommandZone (java.lang.String commandZone) {
		this.commandZone = commandZone;
	}



	/**
	 * Return the value associated with the column: DATE_OF_INSPECTION
	 */
	public java.util.Date getDateOfInspection () {
		return dateOfInspection;
	}

	/**
	 * Set the value related to the column: DATE_OF_INSPECTION
	 * @param dateOfInspection the DATE_OF_INSPECTION value
	 */
	public void setDateOfInspection (java.util.Date dateOfInspection) {
		this.dateOfInspection = dateOfInspection;
	}



	/**
	 * Return the value associated with the column: COMMANDING_OFFICER_NAME
	 */
	public java.lang.String getCommandingOfficerName () {
		return commandingOfficerName;
	}

	/**
	 * Set the value related to the column: COMMANDING_OFFICER_NAME
	 * @param commandingOfficerName the COMMANDING_OFFICER_NAME value
	 */
	public void setCommandingOfficerName (java.lang.String commandingOfficerName) {
		this.commandingOfficerName = commandingOfficerName;
	}



	/**
	 * Return the value associated with the column: BRIEF_DETAIL
	 */
	public java.lang.String getBriefDetail () {
		return briefDetail;
	}

	/**
	 * Set the value related to the column: BRIEF_DETAIL
	 * @param briefDetail the BRIEF_DETAIL value
	 */
	public void setBriefDetail (java.lang.String briefDetail) {
		this.briefDetail = briefDetail;
	}



	/**
	 * Return the value associated with the column: OFFSITE
	 */
	public java.lang.String getOffsite () {
		return offsite;
	}

	/**
	 * Set the value related to the column: OFFSITE
	 * @param offsite the OFFSITE value
	 */
	public void setOffsite (java.lang.String offsite) {
		this.offsite = offsite;
	}



	/**
	 * Return the value associated with the column: OPERATOR_NAME
	 */
	public java.lang.String getOperatorName () {
		return operatorName;
	}

	/**
	 * Set the value related to the column: OPERATOR_NAME
	 * @param operatorName the OPERATOR_NAME value
	 */
	public void setOperatorName (java.lang.String operatorName) {
		this.operatorName = operatorName;
	}



	/**
	 * Return the value associated with the column: ADDRESS_OF_FACILITY
	 */
	public java.lang.String getAddressOfFacility () {
		return addressOfFacility;
	}

	/**
	 * Set the value related to the column: ADDRESS_OF_FACILITY
	 * @param addressOfFacility the ADDRESS_OF_FACILITY value
	 */
	public void setAddressOfFacility (java.lang.String addressOfFacility) {
		this.addressOfFacility = addressOfFacility;
	}



	/**
	 * Return the value associated with the column: JAN_CAT_ONE_THREE
	 */
	public java.lang.String getJanCatOneThree () {
		return janCatOneThree;
	}

	/**
	 * Set the value related to the column: JAN_CAT_ONE_THREE
	 * @param janCatOneThree the JAN_CAT_ONE_THREE value
	 */
	public void setJanCatOneThree (java.lang.String janCatOneThree) {
		this.janCatOneThree = janCatOneThree;
	}



	/**
	 * Return the value associated with the column: JAN_CAT_FOUR
	 */
	public java.lang.String getJanCatFour () {
		return janCatFour;
	}

	/**
	 * Set the value related to the column: JAN_CAT_FOUR
	 * @param janCatFour the JAN_CAT_FOUR value
	 */
	public void setJanCatFour (java.lang.String janCatFour) {
		this.janCatFour = janCatFour;
	}



	/**
	 * Return the value associated with the column: JAN_CAT_FIVE
	 */
	public java.lang.String getJanCatFive () {
		return janCatFive;
	}

	/**
	 * Set the value related to the column: JAN_CAT_FIVE
	 * @param janCatFive the JAN_CAT_FIVE value
	 */
	public void setJanCatFive (java.lang.String janCatFive) {
		this.janCatFive = janCatFive;
	}



	/**
	 * Return the value associated with the column: JAN_CAT_SIX
	 */
	public java.lang.String getJanCatSix () {
		return janCatSix;
	}

	/**
	 * Set the value related to the column: JAN_CAT_SIX
	 * @param janCatSix the JAN_CAT_SIX value
	 */
	public void setJanCatSix (java.lang.String janCatSix) {
		this.janCatSix = janCatSix;
	}



	/**
	 * Return the value associated with the column: JAN_CAT_SEVEN
	 */
	public java.lang.String getJanCatSeven () {
		return janCatSeven;
	}

	/**
	 * Set the value related to the column: JAN_CAT_SEVEN
	 * @param janCatSeven the JAN_CAT_SEVEN value
	 */
	public void setJanCatSeven (java.lang.String janCatSeven) {
		this.janCatSeven = janCatSeven;
	}



	/**
	 * Return the value associated with the column: JAN_CAT_EIGHT
	 */
	public java.lang.String getJanCatEight () {
		return janCatEight;
	}

	/**
	 * Set the value related to the column: JAN_CAT_EIGHT
	 * @param janCatEight the JAN_CAT_EIGHT value
	 */
	public void setJanCatEight (java.lang.String janCatEight) {
		this.janCatEight = janCatEight;
	}



	/**
	 * Return the value associated with the column: JAN_CAT_NINE_TEN
	 */
	public java.lang.String getJanCatNineTen () {
		return janCatNineTen;
	}

	/**
	 * Set the value related to the column: JAN_CAT_NINE_TEN
	 * @param janCatNineTen the JAN_CAT_NINE_TEN value
	 */
	public void setJanCatNineTen (java.lang.String janCatNineTen) {
		this.janCatNineTen = janCatNineTen;
	}



	/**
	 * Return the value associated with the column: FEB_CAT_ONE_THREE
	 */
	public java.lang.String getFebCatOneThree () {
		return febCatOneThree;
	}

	/**
	 * Set the value related to the column: FEB_CAT_ONE_THREE
	 * @param febCatOneThree the FEB_CAT_ONE_THREE value
	 */
	public void setFebCatOneThree (java.lang.String febCatOneThree) {
		this.febCatOneThree = febCatOneThree;
	}



	/**
	 * Return the value associated with the column: FEB_CAT_FOUR
	 */
	public java.lang.String getFebCatFour () {
		return febCatFour;
	}

	/**
	 * Set the value related to the column: FEB_CAT_FOUR
	 * @param febCatFour the FEB_CAT_FOUR value
	 */
	public void setFebCatFour (java.lang.String febCatFour) {
		this.febCatFour = febCatFour;
	}



	/**
	 * Return the value associated with the column: FEB_CAT_FIVE
	 */
	public java.lang.String getFebCatFive () {
		return febCatFive;
	}

	/**
	 * Set the value related to the column: FEB_CAT_FIVE
	 * @param febCatFive the FEB_CAT_FIVE value
	 */
	public void setFebCatFive (java.lang.String febCatFive) {
		this.febCatFive = febCatFive;
	}



	/**
	 * Return the value associated with the column: FEB_CAT_SIX
	 */
	public java.lang.String getFebCatSix () {
		return febCatSix;
	}

	/**
	 * Set the value related to the column: FEB_CAT_SIX
	 * @param febCatSix the FEB_CAT_SIX value
	 */
	public void setFebCatSix (java.lang.String febCatSix) {
		this.febCatSix = febCatSix;
	}



	/**
	 * Return the value associated with the column: FEB_CAT_SEVEN
	 */
	public java.lang.String getFebCatSeven () {
		return febCatSeven;
	}

	/**
	 * Set the value related to the column: FEB_CAT_SEVEN
	 * @param febCatSeven the FEB_CAT_SEVEN value
	 */
	public void setFebCatSeven (java.lang.String febCatSeven) {
		this.febCatSeven = febCatSeven;
	}



	/**
	 * Return the value associated with the column: FEB_CAT_EIGHT
	 */
	public java.lang.String getFebCatEight () {
		return febCatEight;
	}

	/**
	 * Set the value related to the column: FEB_CAT_EIGHT
	 * @param febCatEight the FEB_CAT_EIGHT value
	 */
	public void setFebCatEight (java.lang.String febCatEight) {
		this.febCatEight = febCatEight;
	}



	/**
	 * Return the value associated with the column: FEB_CAT_NINE_TEN
	 */
	public java.lang.String getFebCatNineTen () {
		return febCatNineTen;
	}

	/**
	 * Set the value related to the column: FEB_CAT_NINE_TEN
	 * @param febCatNineTen the FEB_CAT_NINE_TEN value
	 */
	public void setFebCatNineTen (java.lang.String febCatNineTen) {
		this.febCatNineTen = febCatNineTen;
	}



	/**
	 * Return the value associated with the column: MAR_CAT_ONE_THREE
	 */
	public java.lang.String getMarCatOneThree () {
		return marCatOneThree;
	}

	/**
	 * Set the value related to the column: MAR_CAT_ONE_THREE
	 * @param marCatOneThree the MAR_CAT_ONE_THREE value
	 */
	public void setMarCatOneThree (java.lang.String marCatOneThree) {
		this.marCatOneThree = marCatOneThree;
	}



	/**
	 * Return the value associated with the column: MAR_CAT_FOUR
	 */
	public java.lang.String getMarCatFour () {
		return marCatFour;
	}

	/**
	 * Set the value related to the column: MAR_CAT_FOUR
	 * @param marCatFour the MAR_CAT_FOUR value
	 */
	public void setMarCatFour (java.lang.String marCatFour) {
		this.marCatFour = marCatFour;
	}



	/**
	 * Return the value associated with the column: MAR_CAT_FIVE
	 */
	public java.lang.String getMarCatFive () {
		return marCatFive;
	}

	/**
	 * Set the value related to the column: MAR_CAT_FIVE
	 * @param marCatFive the MAR_CAT_FIVE value
	 */
	public void setMarCatFive (java.lang.String marCatFive) {
		this.marCatFive = marCatFive;
	}



	/**
	 * Return the value associated with the column: MAR_CAT_SIX
	 */
	public java.lang.String getMarCatSix () {
		return marCatSix;
	}

	/**
	 * Set the value related to the column: MAR_CAT_SIX
	 * @param marCatSix the MAR_CAT_SIX value
	 */
	public void setMarCatSix (java.lang.String marCatSix) {
		this.marCatSix = marCatSix;
	}



	/**
	 * Return the value associated with the column: MAR_CAT_SEVEN
	 */
	public java.lang.String getMarCatSeven () {
		return marCatSeven;
	}

	/**
	 * Set the value related to the column: MAR_CAT_SEVEN
	 * @param marCatSeven the MAR_CAT_SEVEN value
	 */
	public void setMarCatSeven (java.lang.String marCatSeven) {
		this.marCatSeven = marCatSeven;
	}



	/**
	 * Return the value associated with the column: MAR_CAT_EIGHT
	 */
	public java.lang.String getMarCatEight () {
		return marCatEight;
	}

	/**
	 * Set the value related to the column: MAR_CAT_EIGHT
	 * @param marCatEight the MAR_CAT_EIGHT value
	 */
	public void setMarCatEight (java.lang.String marCatEight) {
		this.marCatEight = marCatEight;
	}



	/**
	 * Return the value associated with the column: MAR_CAT_NINE_TEN
	 */
	public java.lang.String getMarCatNineTen () {
		return marCatNineTen;
	}

	/**
	 * Set the value related to the column: MAR_CAT_NINE_TEN
	 * @param marCatNineTen the MAR_CAT_NINE_TEN value
	 */
	public void setMarCatNineTen (java.lang.String marCatNineTen) {
		this.marCatNineTen = marCatNineTen;
	}



	/**
	 * Return the value associated with the column: APR_CAT_ONE_THREE
	 */
	public java.lang.String getAprCatOneThree () {
		return aprCatOneThree;
	}

	/**
	 * Set the value related to the column: APR_CAT_ONE_THREE
	 * @param aprCatOneThree the APR_CAT_ONE_THREE value
	 */
	public void setAprCatOneThree (java.lang.String aprCatOneThree) {
		this.aprCatOneThree = aprCatOneThree;
	}



	/**
	 * Return the value associated with the column: APR_CAT_FOUR
	 */
	public java.lang.String getAprCatFour () {
		return aprCatFour;
	}

	/**
	 * Set the value related to the column: APR_CAT_FOUR
	 * @param aprCatFour the APR_CAT_FOUR value
	 */
	public void setAprCatFour (java.lang.String aprCatFour) {
		this.aprCatFour = aprCatFour;
	}



	/**
	 * Return the value associated with the column: APR_CAT_FIVE
	 */
	public java.lang.String getAprCatFive () {
		return aprCatFive;
	}

	/**
	 * Set the value related to the column: APR_CAT_FIVE
	 * @param aprCatFive the APR_CAT_FIVE value
	 */
	public void setAprCatFive (java.lang.String aprCatFive) {
		this.aprCatFive = aprCatFive;
	}



	/**
	 * Return the value associated with the column: APR_CAT_SIX
	 */
	public java.lang.String getAprCatSix () {
		return aprCatSix;
	}

	/**
	 * Set the value related to the column: APR_CAT_SIX
	 * @param aprCatSix the APR_CAT_SIX value
	 */
	public void setAprCatSix (java.lang.String aprCatSix) {
		this.aprCatSix = aprCatSix;
	}



	/**
	 * Return the value associated with the column: APR_CAT_SEVEN
	 */
	public java.lang.String getAprCatSeven () {
		return aprCatSeven;
	}

	/**
	 * Set the value related to the column: APR_CAT_SEVEN
	 * @param aprCatSeven the APR_CAT_SEVEN value
	 */
	public void setAprCatSeven (java.lang.String aprCatSeven) {
		this.aprCatSeven = aprCatSeven;
	}



	/**
	 * Return the value associated with the column: APR_CAT_EIGHT
	 */
	public java.lang.String getAprCatEight () {
		return aprCatEight;
	}

	/**
	 * Set the value related to the column: APR_CAT_EIGHT
	 * @param aprCatEight the APR_CAT_EIGHT value
	 */
	public void setAprCatEight (java.lang.String aprCatEight) {
		this.aprCatEight = aprCatEight;
	}



	/**
	 * Return the value associated with the column: APR_CAT_NINE_TEN
	 */
	public java.lang.String getAprCatNineTen () {
		return aprCatNineTen;
	}

	/**
	 * Set the value related to the column: APR_CAT_NINE_TEN
	 * @param aprCatNineTen the APR_CAT_NINE_TEN value
	 */
	public void setAprCatNineTen (java.lang.String aprCatNineTen) {
		this.aprCatNineTen = aprCatNineTen;
	}



	/**
	 * Return the value associated with the column: MAY_CAT_ONE_THREE
	 */
	public java.lang.String getMayCatOneThree () {
		return mayCatOneThree;
	}

	/**
	 * Set the value related to the column: MAY_CAT_ONE_THREE
	 * @param mayCatOneThree the MAY_CAT_ONE_THREE value
	 */
	public void setMayCatOneThree (java.lang.String mayCatOneThree) {
		this.mayCatOneThree = mayCatOneThree;
	}



	/**
	 * Return the value associated with the column: MAY_CAT_FOUR
	 */
	public java.lang.String getMayCatFour () {
		return mayCatFour;
	}

	/**
	 * Set the value related to the column: MAY_CAT_FOUR
	 * @param mayCatFour the MAY_CAT_FOUR value
	 */
	public void setMayCatFour (java.lang.String mayCatFour) {
		this.mayCatFour = mayCatFour;
	}



	/**
	 * Return the value associated with the column: MAY_CAT_FIVE
	 */
	public java.lang.String getMayCatFive () {
		return mayCatFive;
	}

	/**
	 * Set the value related to the column: MAY_CAT_FIVE
	 * @param mayCatFive the MAY_CAT_FIVE value
	 */
	public void setMayCatFive (java.lang.String mayCatFive) {
		this.mayCatFive = mayCatFive;
	}



	/**
	 * Return the value associated with the column: MAY_CAT_SIX
	 */
	public java.lang.String getMayCatSix () {
		return mayCatSix;
	}

	/**
	 * Set the value related to the column: MAY_CAT_SIX
	 * @param mayCatSix the MAY_CAT_SIX value
	 */
	public void setMayCatSix (java.lang.String mayCatSix) {
		this.mayCatSix = mayCatSix;
	}



	/**
	 * Return the value associated with the column: MAY_CAT_SEVEN
	 */
	public java.lang.String getMayCatSeven () {
		return mayCatSeven;
	}

	/**
	 * Set the value related to the column: MAY_CAT_SEVEN
	 * @param mayCatSeven the MAY_CAT_SEVEN value
	 */
	public void setMayCatSeven (java.lang.String mayCatSeven) {
		this.mayCatSeven = mayCatSeven;
	}



	/**
	 * Return the value associated with the column: MAY_CAT_EIGHT
	 */
	public java.lang.String getMayCatEight () {
		return mayCatEight;
	}

	/**
	 * Set the value related to the column: MAY_CAT_EIGHT
	 * @param mayCatEight the MAY_CAT_EIGHT value
	 */
	public void setMayCatEight (java.lang.String mayCatEight) {
		this.mayCatEight = mayCatEight;
	}



	/**
	 * Return the value associated with the column: MAY_CAT_NINE_TEN
	 */
	public java.lang.String getMayCatNineTen () {
		return mayCatNineTen;
	}

	/**
	 * Set the value related to the column: MAY_CAT_NINE_TEN
	 * @param mayCatNineTen the MAY_CAT_NINE_TEN value
	 */
	public void setMayCatNineTen (java.lang.String mayCatNineTen) {
		this.mayCatNineTen = mayCatNineTen;
	}



	/**
	 * Return the value associated with the column: JUN_CAT_ONE_THREE
	 */
	public java.lang.String getJunCatOneThree () {
		return junCatOneThree;
	}

	/**
	 * Set the value related to the column: JUN_CAT_ONE_THREE
	 * @param junCatOneThree the JUN_CAT_ONE_THREE value
	 */
	public void setJunCatOneThree (java.lang.String junCatOneThree) {
		this.junCatOneThree = junCatOneThree;
	}



	/**
	 * Return the value associated with the column: JUN_CAT_FOUR
	 */
	public java.lang.String getJunCatFour () {
		return junCatFour;
	}

	/**
	 * Set the value related to the column: JUN_CAT_FOUR
	 * @param junCatFour the JUN_CAT_FOUR value
	 */
	public void setJunCatFour (java.lang.String junCatFour) {
		this.junCatFour = junCatFour;
	}



	/**
	 * Return the value associated with the column: JUN_CAT_FIVE
	 */
	public java.lang.String getJunCatFive () {
		return junCatFive;
	}

	/**
	 * Set the value related to the column: JUN_CAT_FIVE
	 * @param junCatFive the JUN_CAT_FIVE value
	 */
	public void setJunCatFive (java.lang.String junCatFive) {
		this.junCatFive = junCatFive;
	}



	/**
	 * Return the value associated with the column: JUN_CAT_SIX
	 */
	public java.lang.String getJunCatSix () {
		return junCatSix;
	}

	/**
	 * Set the value related to the column: JUN_CAT_SIX
	 * @param junCatSix the JUN_CAT_SIX value
	 */
	public void setJunCatSix (java.lang.String junCatSix) {
		this.junCatSix = junCatSix;
	}



	/**
	 * Return the value associated with the column: JUN_CAT_SEVEN
	 */
	public java.lang.String getJunCatSeven () {
		return junCatSeven;
	}

	/**
	 * Set the value related to the column: JUN_CAT_SEVEN
	 * @param junCatSeven the JUN_CAT_SEVEN value
	 */
	public void setJunCatSeven (java.lang.String junCatSeven) {
		this.junCatSeven = junCatSeven;
	}



	/**
	 * Return the value associated with the column: JUN_CAT_EIGHT
	 */
	public java.lang.String getJunCatEight () {
		return junCatEight;
	}

	/**
	 * Set the value related to the column: JUN_CAT_EIGHT
	 * @param junCatEight the JUN_CAT_EIGHT value
	 */
	public void setJunCatEight (java.lang.String junCatEight) {
		this.junCatEight = junCatEight;
	}



	/**
	 * Return the value associated with the column: JUN_CAT_NINE_TEN
	 */
	public java.lang.String getJunCatNineTen () {
		return junCatNineTen;
	}

	/**
	 * Set the value related to the column: JUN_CAT_NINE_TEN
	 * @param junCatNineTen the JUN_CAT_NINE_TEN value
	 */
	public void setJunCatNineTen (java.lang.String junCatNineTen) {
		this.junCatNineTen = junCatNineTen;
	}



	/**
	 * Return the value associated with the column: JUL_CAT_ONE_THREE
	 */
	public java.lang.String getJulCatOneThree () {
		return julCatOneThree;
	}

	/**
	 * Set the value related to the column: JUL_CAT_ONE_THREE
	 * @param julCatOneThree the JUL_CAT_ONE_THREE value
	 */
	public void setJulCatOneThree (java.lang.String julCatOneThree) {
		this.julCatOneThree = julCatOneThree;
	}



	/**
	 * Return the value associated with the column: JUL_CAT_FOUR
	 */
	public java.lang.String getJulCatFour () {
		return julCatFour;
	}

	/**
	 * Set the value related to the column: JUL_CAT_FOUR
	 * @param julCatFour the JUL_CAT_FOUR value
	 */
	public void setJulCatFour (java.lang.String julCatFour) {
		this.julCatFour = julCatFour;
	}



	/**
	 * Return the value associated with the column: JUL_CAT_FIVE
	 */
	public java.lang.String getJulCatFive () {
		return julCatFive;
	}

	/**
	 * Set the value related to the column: JUL_CAT_FIVE
	 * @param julCatFive the JUL_CAT_FIVE value
	 */
	public void setJulCatFive (java.lang.String julCatFive) {
		this.julCatFive = julCatFive;
	}



	/**
	 * Return the value associated with the column: JUL_CAT_SIX
	 */
	public java.lang.String getJulCatSix () {
		return julCatSix;
	}

	/**
	 * Set the value related to the column: JUL_CAT_SIX
	 * @param julCatSix the JUL_CAT_SIX value
	 */
	public void setJulCatSix (java.lang.String julCatSix) {
		this.julCatSix = julCatSix;
	}



	/**
	 * Return the value associated with the column: JUL_CAT_SEVEN
	 */
	public java.lang.String getJulCatSeven () {
		return julCatSeven;
	}

	/**
	 * Set the value related to the column: JUL_CAT_SEVEN
	 * @param julCatSeven the JUL_CAT_SEVEN value
	 */
	public void setJulCatSeven (java.lang.String julCatSeven) {
		this.julCatSeven = julCatSeven;
	}



	/**
	 * Return the value associated with the column: JUL_CAT_EIGHT
	 */
	public java.lang.String getJulCatEight () {
		return julCatEight;
	}

	/**
	 * Set the value related to the column: JUL_CAT_EIGHT
	 * @param julCatEight the JUL_CAT_EIGHT value
	 */
	public void setJulCatEight (java.lang.String julCatEight) {
		this.julCatEight = julCatEight;
	}



	/**
	 * Return the value associated with the column: JUL_CAT_NINE_TEN
	 */
	public java.lang.String getJulCatNineTen () {
		return julCatNineTen;
	}

	/**
	 * Set the value related to the column: JUL_CAT_NINE_TEN
	 * @param julCatNineTen the JUL_CAT_NINE_TEN value
	 */
	public void setJulCatNineTen (java.lang.String julCatNineTen) {
		this.julCatNineTen = julCatNineTen;
	}



	/**
	 * Return the value associated with the column: AUG_CAT_ONE_THREE
	 */
	public java.lang.String getAugCatOneThree () {
		return augCatOneThree;
	}

	/**
	 * Set the value related to the column: AUG_CAT_ONE_THREE
	 * @param augCatOneThree the AUG_CAT_ONE_THREE value
	 */
	public void setAugCatOneThree (java.lang.String augCatOneThree) {
		this.augCatOneThree = augCatOneThree;
	}



	/**
	 * Return the value associated with the column: AUG_CAT_FOUR
	 */
	public java.lang.String getAugCatFour () {
		return augCatFour;
	}

	/**
	 * Set the value related to the column: AUG_CAT_FOUR
	 * @param augCatFour the AUG_CAT_FOUR value
	 */
	public void setAugCatFour (java.lang.String augCatFour) {
		this.augCatFour = augCatFour;
	}



	/**
	 * Return the value associated with the column: AUG_CAT_FIVE
	 */
	public java.lang.String getAugCatFive () {
		return augCatFive;
	}

	/**
	 * Set the value related to the column: AUG_CAT_FIVE
	 * @param augCatFive the AUG_CAT_FIVE value
	 */
	public void setAugCatFive (java.lang.String augCatFive) {
		this.augCatFive = augCatFive;
	}



	/**
	 * Return the value associated with the column: AUG_CAT_SIX
	 */
	public java.lang.String getAugCatSix () {
		return augCatSix;
	}

	/**
	 * Set the value related to the column: AUG_CAT_SIX
	 * @param augCatSix the AUG_CAT_SIX value
	 */
	public void setAugCatSix (java.lang.String augCatSix) {
		this.augCatSix = augCatSix;
	}



	/**
	 * Return the value associated with the column: AUG_CAT_SEVEN
	 */
	public java.lang.String getAugCatSeven () {
		return augCatSeven;
	}

	/**
	 * Set the value related to the column: AUG_CAT_SEVEN
	 * @param augCatSeven the AUG_CAT_SEVEN value
	 */
	public void setAugCatSeven (java.lang.String augCatSeven) {
		this.augCatSeven = augCatSeven;
	}



	/**
	 * Return the value associated with the column: AUG_CAT_EIGHT
	 */
	public java.lang.String getAugCatEight () {
		return augCatEight;
	}

	/**
	 * Set the value related to the column: AUG_CAT_EIGHT
	 * @param augCatEight the AUG_CAT_EIGHT value
	 */
	public void setAugCatEight (java.lang.String augCatEight) {
		this.augCatEight = augCatEight;
	}



	/**
	 * Return the value associated with the column: AUG_CAT_NINE_TEN
	 */
	public java.lang.String getAugCatNineTen () {
		return augCatNineTen;
	}

	/**
	 * Set the value related to the column: AUG_CAT_NINE_TEN
	 * @param augCatNineTen the AUG_CAT_NINE_TEN value
	 */
	public void setAugCatNineTen (java.lang.String augCatNineTen) {
		this.augCatNineTen = augCatNineTen;
	}



	/**
	 * Return the value associated with the column: SEP_CAT_ONE_THREE
	 */
	public java.lang.String getSepCatOneThree () {
		return sepCatOneThree;
	}

	/**
	 * Set the value related to the column: SEP_CAT_ONE_THREE
	 * @param sepCatOneThree the SEP_CAT_ONE_THREE value
	 */
	public void setSepCatOneThree (java.lang.String sepCatOneThree) {
		this.sepCatOneThree = sepCatOneThree;
	}



	/**
	 * Return the value associated with the column: SEP_CAT_FOUR
	 */
	public java.lang.String getSepCatFour () {
		return sepCatFour;
	}

	/**
	 * Set the value related to the column: SEP_CAT_FOUR
	 * @param sepCatFour the SEP_CAT_FOUR value
	 */
	public void setSepCatFour (java.lang.String sepCatFour) {
		this.sepCatFour = sepCatFour;
	}



	/**
	 * Return the value associated with the column: SEP_CAT_FIVE
	 */
	public java.lang.String getSepCatFive () {
		return sepCatFive;
	}

	/**
	 * Set the value related to the column: SEP_CAT_FIVE
	 * @param sepCatFive the SEP_CAT_FIVE value
	 */
	public void setSepCatFive (java.lang.String sepCatFive) {
		this.sepCatFive = sepCatFive;
	}



	/**
	 * Return the value associated with the column: SEP_CAT_SIX
	 */
	public java.lang.String getSepCatSix () {
		return sepCatSix;
	}

	/**
	 * Set the value related to the column: SEP_CAT_SIX
	 * @param sepCatSix the SEP_CAT_SIX value
	 */
	public void setSepCatSix (java.lang.String sepCatSix) {
		this.sepCatSix = sepCatSix;
	}



	/**
	 * Return the value associated with the column: SEP_CAT_SEVEN
	 */
	public java.lang.String getSepCatSeven () {
		return sepCatSeven;
	}

	/**
	 * Set the value related to the column: SEP_CAT_SEVEN
	 * @param sepCatSeven the SEP_CAT_SEVEN value
	 */
	public void setSepCatSeven (java.lang.String sepCatSeven) {
		this.sepCatSeven = sepCatSeven;
	}



	/**
	 * Return the value associated with the column: SEP_CAT_EIGHT
	 */
	public java.lang.String getSepCatEight () {
		return sepCatEight;
	}

	/**
	 * Set the value related to the column: SEP_CAT_EIGHT
	 * @param sepCatEight the SEP_CAT_EIGHT value
	 */
	public void setSepCatEight (java.lang.String sepCatEight) {
		this.sepCatEight = sepCatEight;
	}



	/**
	 * Return the value associated with the column: SEP_CAT_NINE_TEN
	 */
	public java.lang.String getSepCatNineTen () {
		return sepCatNineTen;
	}

	/**
	 * Set the value related to the column: SEP_CAT_NINE_TEN
	 * @param sepCatNineTen the SEP_CAT_NINE_TEN value
	 */
	public void setSepCatNineTen (java.lang.String sepCatNineTen) {
		this.sepCatNineTen = sepCatNineTen;
	}



	/**
	 * Return the value associated with the column: OCT_CAT_ONE_THREE
	 */
	public java.lang.String getOctCatOneThree () {
		return octCatOneThree;
	}

	/**
	 * Set the value related to the column: OCT_CAT_ONE_THREE
	 * @param octCatOneThree the OCT_CAT_ONE_THREE value
	 */
	public void setOctCatOneThree (java.lang.String octCatOneThree) {
		this.octCatOneThree = octCatOneThree;
	}



	/**
	 * Return the value associated with the column: OCT_CAT_FOUR
	 */
	public java.lang.String getOctCatFour () {
		return octCatFour;
	}

	/**
	 * Set the value related to the column: OCT_CAT_FOUR
	 * @param octCatFour the OCT_CAT_FOUR value
	 */
	public void setOctCatFour (java.lang.String octCatFour) {
		this.octCatFour = octCatFour;
	}



	/**
	 * Return the value associated with the column: OCT_CAT_FIVE
	 */
	public java.lang.String getOctCatFive () {
		return octCatFive;
	}

	/**
	 * Set the value related to the column: OCT_CAT_FIVE
	 * @param octCatFive the OCT_CAT_FIVE value
	 */
	public void setOctCatFive (java.lang.String octCatFive) {
		this.octCatFive = octCatFive;
	}



	/**
	 * Return the value associated with the column: OCT_CAT_SIX
	 */
	public java.lang.String getOctCatSix () {
		return octCatSix;
	}

	/**
	 * Set the value related to the column: OCT_CAT_SIX
	 * @param octCatSix the OCT_CAT_SIX value
	 */
	public void setOctCatSix (java.lang.String octCatSix) {
		this.octCatSix = octCatSix;
	}



	/**
	 * Return the value associated with the column: OCT_CAT_SEVEN
	 */
	public java.lang.String getOctCatSeven () {
		return octCatSeven;
	}

	/**
	 * Set the value related to the column: OCT_CAT_SEVEN
	 * @param octCatSeven the OCT_CAT_SEVEN value
	 */
	public void setOctCatSeven (java.lang.String octCatSeven) {
		this.octCatSeven = octCatSeven;
	}



	/**
	 * Return the value associated with the column: OCT_CAT_EIGHT
	 */
	public java.lang.String getOctCatEight () {
		return octCatEight;
	}

	/**
	 * Set the value related to the column: OCT_CAT_EIGHT
	 * @param octCatEight the OCT_CAT_EIGHT value
	 */
	public void setOctCatEight (java.lang.String octCatEight) {
		this.octCatEight = octCatEight;
	}



	/**
	 * Return the value associated with the column: OCT_CAT_NINE_TEN
	 */
	public java.lang.String getOctCatNineTen () {
		return octCatNineTen;
	}

	/**
	 * Set the value related to the column: OCT_CAT_NINE_TEN
	 * @param octCatNineTen the OCT_CAT_NINE_TEN value
	 */
	public void setOctCatNineTen (java.lang.String octCatNineTen) {
		this.octCatNineTen = octCatNineTen;
	}



	/**
	 * Return the value associated with the column: NOV_CAT_ONE_THREE
	 */
	public java.lang.String getNovCatOneThree () {
		return novCatOneThree;
	}

	/**
	 * Set the value related to the column: NOV_CAT_ONE_THREE
	 * @param novCatOneThree the NOV_CAT_ONE_THREE value
	 */
	public void setNovCatOneThree (java.lang.String novCatOneThree) {
		this.novCatOneThree = novCatOneThree;
	}



	/**
	 * Return the value associated with the column: NOV_CAT_FOUR
	 */
	public java.lang.String getNovCatFour () {
		return novCatFour;
	}

	/**
	 * Set the value related to the column: NOV_CAT_FOUR
	 * @param novCatFour the NOV_CAT_FOUR value
	 */
	public void setNovCatFour (java.lang.String novCatFour) {
		this.novCatFour = novCatFour;
	}



	/**
	 * Return the value associated with the column: NOV_CAT_FIVE
	 */
	public java.lang.String getNovCatFive () {
		return novCatFive;
	}

	/**
	 * Set the value related to the column: NOV_CAT_FIVE
	 * @param novCatFive the NOV_CAT_FIVE value
	 */
	public void setNovCatFive (java.lang.String novCatFive) {
		this.novCatFive = novCatFive;
	}



	/**
	 * Return the value associated with the column: NOV_CAT_SIX
	 */
	public java.lang.String getNovCatSix () {
		return novCatSix;
	}

	/**
	 * Set the value related to the column: NOV_CAT_SIX
	 * @param novCatSix the NOV_CAT_SIX value
	 */
	public void setNovCatSix (java.lang.String novCatSix) {
		this.novCatSix = novCatSix;
	}



	/**
	 * Return the value associated with the column: NOV_CAT_SEVEN
	 */
	public java.lang.String getNovCatSeven () {
		return novCatSeven;
	}

	/**
	 * Set the value related to the column: NOV_CAT_SEVEN
	 * @param novCatSeven the NOV_CAT_SEVEN value
	 */
	public void setNovCatSeven (java.lang.String novCatSeven) {
		this.novCatSeven = novCatSeven;
	}



	/**
	 * Return the value associated with the column: NOV_CAT_EIGHT
	 */
	public java.lang.String getNovCatEight () {
		return novCatEight;
	}

	/**
	 * Set the value related to the column: NOV_CAT_EIGHT
	 * @param novCatEight the NOV_CAT_EIGHT value
	 */
	public void setNovCatEight (java.lang.String novCatEight) {
		this.novCatEight = novCatEight;
	}



	/**
	 * Return the value associated with the column: NOV_CAT_NINE_TEN
	 */
	public java.lang.String getNovCatNineTen () {
		return novCatNineTen;
	}

	/**
	 * Set the value related to the column: NOV_CAT_NINE_TEN
	 * @param novCatNineTen the NOV_CAT_NINE_TEN value
	 */
	public void setNovCatNineTen (java.lang.String novCatNineTen) {
		this.novCatNineTen = novCatNineTen;
	}



	/**
	 * Return the value associated with the column: DEC_CAT_ONE_THREE
	 */
	public java.lang.String getDecCatOneThree () {
		return decCatOneThree;
	}

	/**
	 * Set the value related to the column: DEC_CAT_ONE_THREE
	 * @param decCatOneThree the DEC_CAT_ONE_THREE value
	 */
	public void setDecCatOneThree (java.lang.String decCatOneThree) {
		this.decCatOneThree = decCatOneThree;
	}



	/**
	 * Return the value associated with the column: DEC_CAT_FOUR
	 */
	public java.lang.String getDecCatFour () {
		return decCatFour;
	}

	/**
	 * Set the value related to the column: DEC_CAT_FOUR
	 * @param decCatFour the DEC_CAT_FOUR value
	 */
	public void setDecCatFour (java.lang.String decCatFour) {
		this.decCatFour = decCatFour;
	}



	/**
	 * Return the value associated with the column: DEC_CAT_FIVE
	 */
	public java.lang.String getDecCatFive () {
		return decCatFive;
	}

	/**
	 * Set the value related to the column: DEC_CAT_FIVE
	 * @param decCatFive the DEC_CAT_FIVE value
	 */
	public void setDecCatFive (java.lang.String decCatFive) {
		this.decCatFive = decCatFive;
	}



	/**
	 * Return the value associated with the column: DEC_CAT_SIX
	 */
	public java.lang.String getDecCatSix () {
		return decCatSix;
	}

	/**
	 * Set the value related to the column: DEC_CAT_SIX
	 * @param decCatSix the DEC_CAT_SIX value
	 */
	public void setDecCatSix (java.lang.String decCatSix) {
		this.decCatSix = decCatSix;
	}



	/**
	 * Return the value associated with the column: DEC_CAT_SEVEN
	 */
	public java.lang.String getDecCatSeven () {
		return decCatSeven;
	}

	/**
	 * Set the value related to the column: DEC_CAT_SEVEN
	 * @param decCatSeven the DEC_CAT_SEVEN value
	 */
	public void setDecCatSeven (java.lang.String decCatSeven) {
		this.decCatSeven = decCatSeven;
	}



	/**
	 * Return the value associated with the column: DEC_CAT_EIGHT
	 */
	public java.lang.String getDecCatEight () {
		return decCatEight;
	}

	/**
	 * Set the value related to the column: DEC_CAT_EIGHT
	 * @param decCatEight the DEC_CAT_EIGHT value
	 */
	public void setDecCatEight (java.lang.String decCatEight) {
		this.decCatEight = decCatEight;
	}



	/**
	 * Return the value associated with the column: DEC_CAT_NINE_TEN
	 */
	public java.lang.String getDecCatNineTen () {
		return decCatNineTen;
	}

	/**
	 * Set the value related to the column: DEC_CAT_NINE_TEN
	 * @param decCatNineTen the DEC_CAT_NINE_TEN value
	 */
	public void setDecCatNineTen (java.lang.String decCatNineTen) {
		this.decCatNineTen = decCatNineTen;
	}



	/**
	 * Return the value associated with the column: TOTAL_CAT_ONE_THREE
	 */
	public java.lang.String getTotalCatOneThree () {
		return totalCatOneThree;
	}

	/**
	 * Set the value related to the column: TOTAL_CAT_ONE_THREE
	 * @param totalCatOneThree the TOTAL_CAT_ONE_THREE value
	 */
	public void setTotalCatOneThree (java.lang.String totalCatOneThree) {
		this.totalCatOneThree = totalCatOneThree;
	}



	/**
	 * Return the value associated with the column: TOTAL_CAT_FOUR
	 */
	public java.lang.String getTotalCatFour () {
		return totalCatFour;
	}

	/**
	 * Set the value related to the column: TOTAL_CAT_FOUR
	 * @param totalCatFour the TOTAL_CAT_FOUR value
	 */
	public void setTotalCatFour (java.lang.String totalCatFour) {
		this.totalCatFour = totalCatFour;
	}



	/**
	 * Return the value associated with the column: TOTAL_CAT_FIVE
	 */
	public java.lang.String getTotalCatFive () {
		return totalCatFive;
	}

	/**
	 * Set the value related to the column: TOTAL_CAT_FIVE
	 * @param totalCatFive the TOTAL_CAT_FIVE value
	 */
	public void setTotalCatFive (java.lang.String totalCatFive) {
		this.totalCatFive = totalCatFive;
	}



	/**
	 * Return the value associated with the column: TOTAL_CAT_SIX
	 */
	public java.lang.String getTotalCatSix () {
		return totalCatSix;
	}

	/**
	 * Set the value related to the column: TOTAL_CAT_SIX
	 * @param totalCatSix the TOTAL_CAT_SIX value
	 */
	public void setTotalCatSix (java.lang.String totalCatSix) {
		this.totalCatSix = totalCatSix;
	}



	/**
	 * Return the value associated with the column: TOTAL_CAT_SEVEN
	 */
	public java.lang.String getTotalCatSeven () {
		return totalCatSeven;
	}

	/**
	 * Set the value related to the column: TOTAL_CAT_SEVEN
	 * @param totalCatSeven the TOTAL_CAT_SEVEN value
	 */
	public void setTotalCatSeven (java.lang.String totalCatSeven) {
		this.totalCatSeven = totalCatSeven;
	}



	/**
	 * Return the value associated with the column: TOTAL_CAT_EIGHT
	 */
	public java.lang.String getTotalCatEight () {
		return totalCatEight;
	}

	/**
	 * Set the value related to the column: TOTAL_CAT_EIGHT
	 * @param totalCatEight the TOTAL_CAT_EIGHT value
	 */
	public void setTotalCatEight (java.lang.String totalCatEight) {
		this.totalCatEight = totalCatEight;
	}



	/**
	 * Return the value associated with the column: TOTAL_CAT_NINE_TEN
	 */
	public java.lang.String getTotalCatNineTen () {
		return totalCatNineTen;
	}

	/**
	 * Set the value related to the column: TOTAL_CAT_NINE_TEN
	 * @param totalCatNineTen the TOTAL_CAT_NINE_TEN value
	 */
	public void setTotalCatNineTen (java.lang.String totalCatNineTen) {
		this.totalCatNineTen = totalCatNineTen;
	}



	/**
	 * Return the value associated with the column: COLLECTION_STORAGE
	 */
	public java.lang.String getCollectionStorage () {
		return collectionStorage;
	}

	/**
	 * Set the value related to the column: COLLECTION_STORAGE
	 * @param collectionStorage the COLLECTION_STORAGE value
	 */
	public void setCollectionStorage (java.lang.String collectionStorage) {
		this.collectionStorage = collectionStorage;
	}



	/**
	 * Return the value associated with the column: MODE_OF_TRANSPORTATION
	 */
	public java.lang.String getModeOfTransportation () {
		return modeOfTransportation;
	}

	/**
	 * Set the value related to the column: MODE_OF_TRANSPORTATION
	 * @param modeOfTransportation the MODE_OF_TRANSPORTATION value
	 */
	public void setModeOfTransportation (java.lang.String modeOfTransportation) {
		this.modeOfTransportation = modeOfTransportation;
	}



	/**
	 * Return the value associated with the column: KNOWLEDGE_ATTITUDE
	 */
	public java.lang.String getKnowledgeAttitude () {
		return knowledgeAttitude;
	}

	/**
	 * Set the value related to the column: KNOWLEDGE_ATTITUDE
	 * @param knowledgeAttitude the KNOWLEDGE_ATTITUDE value
	 */
	public void setKnowledgeAttitude (java.lang.String knowledgeAttitude) {
		this.knowledgeAttitude = knowledgeAttitude;
	}



	/**
	 * Return the value associated with the column: USE_OF_PRESONEL
	 */
	public java.lang.String getUseOfPresonel () {
		return useOfPresonel;
	}

	/**
	 * Set the value related to the column: USE_OF_PRESONEL
	 * @param useOfPresonel the USE_OF_PRESONEL value
	 */
	public void setUseOfPresonel (java.lang.String useOfPresonel) {
		this.useOfPresonel = useOfPresonel;
	}



	/**
	 * Return the value associated with the column: INCINERATOR
	 */
	public java.lang.String getIncinerator () {
		return incinerator;
	}

	/**
	 * Set the value related to the column: INCINERATOR
	 * @param incinerator the INCINERATOR value
	 */
	public void setIncinerator (java.lang.String incinerator) {
		this.incinerator = incinerator;
	}



	/**
	 * Return the value associated with the column: DEEP_BURIAL
	 */
	public java.lang.String getDeepBurial () {
		return deepBurial;
	}

	/**
	 * Set the value related to the column: DEEP_BURIAL
	 * @param deepBurial the DEEP_BURIAL value
	 */
	public void setDeepBurial (java.lang.String deepBurial) {
		this.deepBurial = deepBurial;
	}



	/**
	 * Return the value associated with the column: MICROWAVE
	 */
	public java.lang.String getMicrowave () {
		return microwave;
	}

	/**
	 * Set the value related to the column: MICROWAVE
	 * @param microwave the MICROWAVE value
	 */
	public void setMicrowave (java.lang.String microwave) {
		this.microwave = microwave;
	}



	/**
	 * Return the value associated with the column: AUTOCLAVE
	 */
	public java.lang.String getAutoclave () {
		return autoclave;
	}

	/**
	 * Set the value related to the column: AUTOCLAVE
	 * @param autoclave the AUTOCLAVE value
	 */
	public void setAutoclave (java.lang.String autoclave) {
		this.autoclave = autoclave;
	}



	/**
	 * Return the value associated with the column: HYDROCLAVE
	 */
	public java.lang.String getHydroclave () {
		return hydroclave;
	}

	/**
	 * Set the value related to the column: HYDROCLAVE
	 * @param hydroclave the HYDROCLAVE value
	 */
	public void setHydroclave (java.lang.String hydroclave) {
		this.hydroclave = hydroclave;
	}



	/**
	 * Return the value associated with the column: SHREDDER
	 */
	public java.lang.String getShredder () {
		return shredder;
	}

	/**
	 * Set the value related to the column: SHREDDER
	 * @param shredder the SHREDDER value
	 */
	public void setShredder (java.lang.String shredder) {
		this.shredder = shredder;
	}



	/**
	 * Return the value associated with the column: NEEDLE_DESTROYER
	 */
	public java.lang.String getNeedleDestroyer () {
		return needleDestroyer;
	}

	/**
	 * Set the value related to the column: NEEDLE_DESTROYER
	 * @param needleDestroyer the NEEDLE_DESTROYER value
	 */
	public void setNeedleDestroyer (java.lang.String needleDestroyer) {
		this.needleDestroyer = needleDestroyer;
	}



	/**
	 * Return the value associated with the column: OTHER_FORM_OF_HANDLING
	 */
	public java.lang.String getOtherFormOfHandling () {
		return otherFormOfHandling;
	}

	/**
	 * Set the value related to the column: OTHER_FORM_OF_HANDLING
	 * @param otherFormOfHandling the OTHER_FORM_OF_HANDLING value
	 */
	public void setOtherFormOfHandling (java.lang.String otherFormOfHandling) {
		this.otherFormOfHandling = otherFormOfHandling;
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
	 * Return the value associated with the column: FINAL_OBSERVATION
	 */
	public java.lang.String getFinalObservation () {
		return finalObservation;
	}

	/**
	 * Set the value related to the column: FINAL_OBSERVATION
	 * @param finalObservation the FINAL_OBSERVATION value
	 */
	public void setFinalObservation (java.lang.String finalObservation) {
		this.finalObservation = finalObservation;
	}



	/**
	 * Return the value associated with the column: NAME_OF_INSTITUTION
	 */
	public java.lang.String getNameOfInstitution () {
		return nameOfInstitution;
	}

	/**
	 * Set the value related to the column: NAME_OF_INSTITUTION
	 * @param nameOfInstitution the NAME_OF_INSTITUTION value
	 */
	public void setNameOfInstitution (java.lang.String nameOfInstitution) {
		this.nameOfInstitution = nameOfInstitution;
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
		if (!(obj instanceof jkt.hms.masters.business.ShoBiomedicalWaste)) return false;
		else {
			jkt.hms.masters.business.ShoBiomedicalWaste shoBiomedicalWaste = (jkt.hms.masters.business.ShoBiomedicalWaste) obj;
			if (null == this.getBiomedicalId() || null == shoBiomedicalWaste.getBiomedicalId()) return false;
			else return (this.getBiomedicalId().equals(shoBiomedicalWaste.getBiomedicalId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getBiomedicalId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getBiomedicalId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}
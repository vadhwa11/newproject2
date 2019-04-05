package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the FOOD_HANDLER table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="FOOD_HANDLER"
 */

public abstract class BaseFoodHandler  implements Serializable {

	public static String REF = "FoodHandler";
	public static String PROP_SKIN = "Skin";
	public static String PROP_TRADE = "Trade";
	public static String PROP_MESS = "Mess";
	public static String PROP_NAILS_HAIR = "NailsHair";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_FH_DATE = "FhDate";
	public static String PROP_IMMUNIZATION = "Immunization";
	public static String PROP_NAME = "Name";
	public static String PROP_STOOL_TEST = "stoolTest";
	public static String PROP_GENERAL_EXAM = "GeneralExam";
	public static String PROP_DEWORMING_STATUS = "DewormingStatus";
	public static String PROP_REMARKS_FFI = "RemarksFfi";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT_ID = "DepartmentId";
	public static String PROP_SER_PASS_NO = "SerPassNo";
	public static String PROP_HIN_ID = "HinId";


	// constructors
	public BaseFoodHandler () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseFoodHandler (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String mess;
	private java.lang.String generalExam;
	private java.lang.String nailsHair;
	private java.lang.String skin;
	private java.lang.String dewormingStatus;
	private java.lang.String remarksFfi;
	private java.lang.String name;
	private java.lang.String serPassNo;
	private java.lang.String immunization;
	private java.lang.String stoolTest;
	private java.util.Date fhDate;

	// many to one
	private jkt.hms.masters.business.Patient hinId;
	private jkt.hms.masters.business.MasHospital hospitalId;
	private jkt.hms.masters.business.MasDepartment departmentId;
	private jkt.hms.masters.business.MasTrade trade;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="FOOD_HANDLER_ID"
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
	 * Return the value associated with the column: MESS
	 */
	public java.lang.String getMess () {
		return mess;
	}

	/**
	 * Set the value related to the column: MESS
	 * @param mess the MESS value
	 */
	public void setMess (java.lang.String mess) {
		this.mess = mess;
	}



	/**
	 * Return the value associated with the column: GENERAL_EXAM
	 */
	public java.lang.String getGeneralExam () {
		return generalExam;
	}

	/**
	 * Set the value related to the column: GENERAL_EXAM
	 * @param generalExam the GENERAL_EXAM value
	 */
	public void setGeneralExam (java.lang.String generalExam) {
		this.generalExam = generalExam;
	}



	/**
	 * Return the value associated with the column: NAILS_HAIR
	 */
	public java.lang.String getNailsHair () {
		return nailsHair;
	}

	/**
	 * Set the value related to the column: NAILS_HAIR
	 * @param nailsHair the NAILS_HAIR value
	 */
	public void setNailsHair (java.lang.String nailsHair) {
		this.nailsHair = nailsHair;
	}



	/**
	 * Return the value associated with the column: SKIN
	 */
	public java.lang.String getSkin () {
		return skin;
	}

	/**
	 * Set the value related to the column: SKIN
	 * @param skin the SKIN value
	 */
	public void setSkin (java.lang.String skin) {
		this.skin = skin;
	}



	/**
	 * Return the value associated with the column: DEWORMING_STATUS
	 */
	public java.lang.String getDewormingStatus () {
		return dewormingStatus;
	}

	/**
	 * Set the value related to the column: DEWORMING_STATUS
	 * @param dewormingStatus the DEWORMING_STATUS value
	 */
	public void setDewormingStatus (java.lang.String dewormingStatus) {
		this.dewormingStatus = dewormingStatus;
	}



	/**
	 * Return the value associated with the column: REMARKS_FFI
	 */
	public java.lang.String getRemarksFfi () {
		return remarksFfi;
	}

	/**
	 * Set the value related to the column: REMARKS_FFI
	 * @param remarksFfi the REMARKS_FFI value
	 */
	public void setRemarksFfi (java.lang.String remarksFfi) {
		this.remarksFfi = remarksFfi;
	}



	/**
	 * Return the value associated with the column: NAME
	 */
	public java.lang.String getName () {
		return name;
	}

	/**
	 * Set the value related to the column: NAME
	 * @param name the NAME value
	 */
	public void setName (java.lang.String name) {
		this.name = name;
	}



	/**
	 * Return the value associated with the column: SER_PASS_NO
	 */
	public java.lang.String getSerPassNo () {
		return serPassNo;
	}

	/**
	 * Set the value related to the column: SER_PASS_NO
	 * @param serPassNo the SER_PASS_NO value
	 */
	public void setSerPassNo (java.lang.String serPassNo) {
		this.serPassNo = serPassNo;
	}



	/**
	 * Return the value associated with the column: IMMUNIZATION
	 */
	public java.lang.String getImmunization () {
		return immunization;
	}

	/**
	 * Set the value related to the column: IMMUNIZATION
	 * @param immunization the IMMUNIZATION value
	 */
	public void setImmunization (java.lang.String immunization) {
		this.immunization = immunization;
	}



	/**
	 * Return the value associated with the column: Stool_Test
	 */
	public java.lang.String getStoolTest () {
		return stoolTest;
	}

	/**
	 * Set the value related to the column: Stool_Test
	 * @param stoolTest the Stool_Test value
	 */
	public void setStoolTest (java.lang.String stoolTest) {
		this.stoolTest = stoolTest;
	}



	/**
	 * Return the value associated with the column: FH_DATE
	 */
	public java.util.Date getFhDate () {
		return fhDate;
	}

	/**
	 * Set the value related to the column: FH_DATE
	 * @param fhDate the FH_DATE value
	 */
	public void setFhDate (java.util.Date fhDate) {
		this.fhDate = fhDate;
	}



	/**
	 * Return the value associated with the column: HIN_ID
	 */
	public jkt.hms.masters.business.Patient getHinId () {
		return hinId;
	}

	/**
	 * Set the value related to the column: HIN_ID
	 * @param hinId the HIN_ID value
	 */
	public void setHinId (jkt.hms.masters.business.Patient hinId) {
		this.hinId = hinId;
	}



	/**
	 * Return the value associated with the column: HOSPITAL_ID
	 */
	public jkt.hms.masters.business.MasHospital getHospitalId () {
		return hospitalId;
	}

	/**
	 * Set the value related to the column: HOSPITAL_ID
	 * @param hospitalId the HOSPITAL_ID value
	 */
	public void setHospitalId (jkt.hms.masters.business.MasHospital hospitalId) {
		this.hospitalId = hospitalId;
	}



	/**
	 * Return the value associated with the column: DEPARTMENT_ID
	 */
	public jkt.hms.masters.business.MasDepartment getDepartmentId () {
		return departmentId;
	}

	/**
	 * Set the value related to the column: DEPARTMENT_ID
	 * @param departmentId the DEPARTMENT_ID value
	 */
	public void setDepartmentId (jkt.hms.masters.business.MasDepartment departmentId) {
		this.departmentId = departmentId;
	}



	/**
	 * Return the value associated with the column: TRADE_ID
	 */
	public jkt.hms.masters.business.MasTrade getTrade () {
		return trade;
	}

	/**
	 * Set the value related to the column: TRADE_ID
	 * @param trade the TRADE_ID value
	 */
	public void setTrade (jkt.hms.masters.business.MasTrade trade) {
		this.trade = trade;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.FoodHandler)) return false;
		else {
			jkt.hms.masters.business.FoodHandler foodHandler = (jkt.hms.masters.business.FoodHandler) obj;
			if (null == this.getId() || null == foodHandler.getId()) return false;
			else return (this.getId().equals(foodHandler.getId()));
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
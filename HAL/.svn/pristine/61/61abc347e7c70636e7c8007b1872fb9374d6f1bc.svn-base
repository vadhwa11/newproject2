package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the AVI_FLYING_CLOTHING_INSPECTION table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="AVI_FLYING_CLOTHING_INSPECTION"
 */

public abstract class BaseAviFlyingClothingInspection  implements Serializable {

	public static String REF = "AviFlyingClothingInspection";
	public static String PROP_AGE = "Age";
	public static String PROP_RANK = "Rank";
	public static String PROP_TRADE = "Trade";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_MASK_DATE = "MaskDate";
	public static String PROP_LAST_NAME = "LastName";
	public static String PROP_UNIT = "Unit";
	public static String PROP_HELMET_DATE = "HelmetDate";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_OTHER_REMARKS = "OtherRemarks";
	public static String PROP_HELMET_REMARKS = "HelmetRemarks";
	public static String PROP_FIRST_NAME = "FirstName";
	public static String PROP_OTHER_STATUS = "OtherStatus";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_SEX = "Sex";
	public static String PROP_FLYING_DATE = "FlyingDate";
	public static String PROP_SERVICE_NO = "ServiceNo";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_HELMET_STATUS = "HelmetStatus";
	public static String PROP_ANTI_G_SUIT_REMARKS = "AntiGSuitRemarks";
	public static String PROP_INSPECTED_BY = "InspectedBy";
	public static String PROP_STATUS = "Status";
	public static String PROP_MASK_REMARKS = "MaskRemarks";
	public static String PROP_MIDDLE_NAME = "MiddleName";
	public static String PROP_ANTI_G_SUIT_STATUS = "AntiGSuitStatus";
	public static String PROP_ANTI_G_SUIT_DATE = "AntiGSuitDate";
	public static String PROP_MASK_STATUS = "MaskStatus";
	public static String PROP_OTHER_DATE = "OtherDate";
	public static String PROP_ID = "Id";
	public static String PROP_HIN = "Hin";


	// constructors
	public BaseAviFlyingClothingInspection () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAviFlyingClothingInspection (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date flyingDate;
	private java.lang.String serviceNo;
	private java.lang.String firstName;
	private java.lang.String middleName;
	private java.lang.String lastName;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String lastChgBy;
	private java.lang.String maskStatus;
	private java.util.Date maskDate;
	private java.lang.String maskRemarks;
	private java.lang.String helmetStatus;
	private java.util.Date helmetDate;
	private java.lang.String helmetRemarks;
	private java.lang.String antiGSuitStatus;
	private java.util.Date antiGSuitDate;
	private java.lang.String antiGSuitRemarks;
	private java.lang.String otherStatus;
	private java.util.Date otherDate;
	private java.lang.String otherRemarks;
	private java.lang.String age;

	// many to one
	private jkt.hms.masters.business.MasRank rank;
	private jkt.hms.masters.business.MasUnit unit;
	private jkt.hms.masters.business.MasTrade trade;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.Patient hin;
	private jkt.hms.masters.business.MasEmployee inspectedBy;
	private jkt.hms.masters.business.MasAdministrativeSex sex;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="FLYING_ID"
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
	 * Return the value associated with the column: FLYING_DATE
	 */
	public java.util.Date getFlyingDate () {
		return flyingDate;
	}

	/**
	 * Set the value related to the column: FLYING_DATE
	 * @param flyingDate the FLYING_DATE value
	 */
	public void setFlyingDate (java.util.Date flyingDate) {
		this.flyingDate = flyingDate;
	}



	/**
	 * Return the value associated with the column: SERVICE_NO
	 */
	public java.lang.String getServiceNo () {
		return serviceNo;
	}

	/**
	 * Set the value related to the column: SERVICE_NO
	 * @param serviceNo the SERVICE_NO value
	 */
	public void setServiceNo (java.lang.String serviceNo) {
		this.serviceNo = serviceNo;
	}



	/**
	 * Return the value associated with the column: FIRST_NAME
	 */
	public java.lang.String getFirstName () {
		return firstName;
	}

	/**
	 * Set the value related to the column: FIRST_NAME
	 * @param firstName the FIRST_NAME value
	 */
	public void setFirstName (java.lang.String firstName) {
		this.firstName = firstName;
	}



	/**
	 * Return the value associated with the column: MIDDLE_NAME
	 */
	public java.lang.String getMiddleName () {
		return middleName;
	}

	/**
	 * Set the value related to the column: MIDDLE_NAME
	 * @param middleName the MIDDLE_NAME value
	 */
	public void setMiddleName (java.lang.String middleName) {
		this.middleName = middleName;
	}



	/**
	 * Return the value associated with the column: LAST_NAME
	 */
	public java.lang.String getLastName () {
		return lastName;
	}

	/**
	 * Set the value related to the column: LAST_NAME
	 * @param lastName the LAST_NAME value
	 */
	public void setLastName (java.lang.String lastName) {
		this.lastName = lastName;
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
	 * Return the value associated with the column: MASK_STATUS
	 */
	public java.lang.String getMaskStatus () {
		return maskStatus;
	}

	/**
	 * Set the value related to the column: MASK_STATUS
	 * @param maskStatus the MASK_STATUS value
	 */
	public void setMaskStatus (java.lang.String maskStatus) {
		this.maskStatus = maskStatus;
	}



	/**
	 * Return the value associated with the column: MASK_DATE
	 */
	public java.util.Date getMaskDate () {
		return maskDate;
	}

	/**
	 * Set the value related to the column: MASK_DATE
	 * @param maskDate the MASK_DATE value
	 */
	public void setMaskDate (java.util.Date maskDate) {
		this.maskDate = maskDate;
	}



	/**
	 * Return the value associated with the column: MASK_REMARKS
	 */
	public java.lang.String getMaskRemarks () {
		return maskRemarks;
	}

	/**
	 * Set the value related to the column: MASK_REMARKS
	 * @param maskRemarks the MASK_REMARKS value
	 */
	public void setMaskRemarks (java.lang.String maskRemarks) {
		this.maskRemarks = maskRemarks;
	}



	/**
	 * Return the value associated with the column: HELMET_STATUS
	 */
	public java.lang.String getHelmetStatus () {
		return helmetStatus;
	}

	/**
	 * Set the value related to the column: HELMET_STATUS
	 * @param helmetStatus the HELMET_STATUS value
	 */
	public void setHelmetStatus (java.lang.String helmetStatus) {
		this.helmetStatus = helmetStatus;
	}



	/**
	 * Return the value associated with the column: HELMET_DATE
	 */
	public java.util.Date getHelmetDate () {
		return helmetDate;
	}

	/**
	 * Set the value related to the column: HELMET_DATE
	 * @param helmetDate the HELMET_DATE value
	 */
	public void setHelmetDate (java.util.Date helmetDate) {
		this.helmetDate = helmetDate;
	}



	/**
	 * Return the value associated with the column: HELMET_REMARKS
	 */
	public java.lang.String getHelmetRemarks () {
		return helmetRemarks;
	}

	/**
	 * Set the value related to the column: HELMET_REMARKS
	 * @param helmetRemarks the HELMET_REMARKS value
	 */
	public void setHelmetRemarks (java.lang.String helmetRemarks) {
		this.helmetRemarks = helmetRemarks;
	}



	/**
	 * Return the value associated with the column: ANTI_G_SUIT_STATUS
	 */
	public java.lang.String getAntiGSuitStatus () {
		return antiGSuitStatus;
	}

	/**
	 * Set the value related to the column: ANTI_G_SUIT_STATUS
	 * @param antiGSuitStatus the ANTI_G_SUIT_STATUS value
	 */
	public void setAntiGSuitStatus (java.lang.String antiGSuitStatus) {
		this.antiGSuitStatus = antiGSuitStatus;
	}



	/**
	 * Return the value associated with the column: ANTI_G_SUIT_DATE
	 */
	public java.util.Date getAntiGSuitDate () {
		return antiGSuitDate;
	}

	/**
	 * Set the value related to the column: ANTI_G_SUIT_DATE
	 * @param antiGSuitDate the ANTI_G_SUIT_DATE value
	 */
	public void setAntiGSuitDate (java.util.Date antiGSuitDate) {
		this.antiGSuitDate = antiGSuitDate;
	}



	/**
	 * Return the value associated with the column: ANTI_G_SUIT_REMARKS
	 */
	public java.lang.String getAntiGSuitRemarks () {
		return antiGSuitRemarks;
	}

	/**
	 * Set the value related to the column: ANTI_G_SUIT_REMARKS
	 * @param antiGSuitRemarks the ANTI_G_SUIT_REMARKS value
	 */
	public void setAntiGSuitRemarks (java.lang.String antiGSuitRemarks) {
		this.antiGSuitRemarks = antiGSuitRemarks;
	}



	/**
	 * Return the value associated with the column: OTHER_STATUS
	 */
	public java.lang.String getOtherStatus () {
		return otherStatus;
	}

	/**
	 * Set the value related to the column: OTHER_STATUS
	 * @param otherStatus the OTHER_STATUS value
	 */
	public void setOtherStatus (java.lang.String otherStatus) {
		this.otherStatus = otherStatus;
	}



	/**
	 * Return the value associated with the column: OTHER_DATE
	 */
	public java.util.Date getOtherDate () {
		return otherDate;
	}

	/**
	 * Set the value related to the column: OTHER_DATE
	 * @param otherDate the OTHER_DATE value
	 */
	public void setOtherDate (java.util.Date otherDate) {
		this.otherDate = otherDate;
	}



	/**
	 * Return the value associated with the column: OTHER_REMARKS
	 */
	public java.lang.String getOtherRemarks () {
		return otherRemarks;
	}

	/**
	 * Set the value related to the column: OTHER_REMARKS
	 * @param otherRemarks the OTHER_REMARKS value
	 */
	public void setOtherRemarks (java.lang.String otherRemarks) {
		this.otherRemarks = otherRemarks;
	}



	/**
	 * Return the value associated with the column: age
	 */
	public java.lang.String getAge () {
		return age;
	}

	/**
	 * Set the value related to the column: age
	 * @param age the age value
	 */
	public void setAge (java.lang.String age) {
		this.age = age;
	}



	/**
	 * Return the value associated with the column: RANK_ID
	 */
	public jkt.hms.masters.business.MasRank getRank () {
		return rank;
	}

	/**
	 * Set the value related to the column: RANK_ID
	 * @param rank the RANK_ID value
	 */
	public void setRank (jkt.hms.masters.business.MasRank rank) {
		this.rank = rank;
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
	 * Return the value associated with the column: DEPARTMENT_ID
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment () {
		return department;
	}

	/**
	 * Set the value related to the column: DEPARTMENT_ID
	 * @param department the DEPARTMENT_ID value
	 */
	public void setDepartment (jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
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
	 * Return the value associated with the column: INSPECTED_BY
	 */
	public jkt.hms.masters.business.MasEmployee getInspectedBy () {
		return inspectedBy;
	}

	/**
	 * Set the value related to the column: INSPECTED_BY
	 * @param inspectedBy the INSPECTED_BY value
	 */
	public void setInspectedBy (jkt.hms.masters.business.MasEmployee inspectedBy) {
		this.inspectedBy = inspectedBy;
	}



	/**
	 * Return the value associated with the column: sex_id
	 */
	public jkt.hms.masters.business.MasAdministrativeSex getSex () {
		return sex;
	}

	/**
	 * Set the value related to the column: sex_id
	 * @param sex the sex_id value
	 */
	public void setSex (jkt.hms.masters.business.MasAdministrativeSex sex) {
		this.sex = sex;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.AviFlyingClothingInspection)) return false;
		else {
			jkt.hms.masters.business.AviFlyingClothingInspection aviFlyingClothingInspection = (jkt.hms.masters.business.AviFlyingClothingInspection) obj;
			if (null == this.getId() || null == aviFlyingClothingInspection.getId()) return false;
			else return (this.getId().equals(aviFlyingClothingInspection.getId()));
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
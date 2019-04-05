package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the blood_test_entry_header
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="blood_test_entry_header"
 */

public abstract class BaseBloodTestEntryHeader implements Serializable {

	public static String REF = "BloodTestEntryHeader";
	public static String PROP_TYPE = "Type";
	public static String PROP_SEX = "Sex";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_UNIT = "Unit";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_HIN = "Hin";
	public static String PROP_SERIAL_NO = "SerialNo";
	public static String PROP_AGE = "Age";
	public static String PROP_TEST_DATE = "TestDate";
	public static String PROP_RELATION = "Relation";
	public static String PROP_RANK = "Rank";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_RECEIVED_BY = "ReceivedBy";
	public static String PROP_NAME = "Name";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_ID = "Id";
	public static String PROP_TELE_NO = "TeleNo";

	// constructors
	public BaseBloodTestEntryHeader() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBloodTestEntryHeader(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String serialNo;
	private java.util.Date testDate;
	private java.lang.String name;
	private java.lang.String type;
	private java.lang.String age;
	private java.lang.String teleNo;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasAdministrativeSex sex;
	private jkt.hms.masters.business.MasUnit unit;
	private jkt.hms.masters.business.MasRelation relation;
	private jkt.hms.masters.business.MasRank rank;
	private jkt.hms.masters.business.MasEmployee receivedBy;
	private jkt.hms.masters.business.Patient hin;

	// collections
	private java.util.Set<jkt.hms.masters.business.BloodTestEntryDetail> bloodTestEntryDetails;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="id"
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
	 * Return the value associated with the column: serial_no
	 */
	public java.lang.String getSerialNo() {
		return serialNo;
	}

	/**
	 * Set the value related to the column: serial_no
	 * 
	 * @param serialNo
	 *            the serial_no value
	 */
	public void setSerialNo(java.lang.String serialNo) {
		this.serialNo = serialNo;
	}

	/**
	 * Return the value associated with the column: test_date
	 */
	public java.util.Date getTestDate() {
		return testDate;
	}

	/**
	 * Set the value related to the column: test_date
	 * 
	 * @param testDate
	 *            the test_date value
	 */
	public void setTestDate(java.util.Date testDate) {
		this.testDate = testDate;
	}

	/**
	 * Return the value associated with the column: name
	 */
	public java.lang.String getName() {
		return name;
	}

	/**
	 * Set the value related to the column: name
	 * 
	 * @param name
	 *            the name value
	 */
	public void setName(java.lang.String name) {
		this.name = name;
	}

	/**
	 * Return the value associated with the column: type
	 */
	public java.lang.String getType() {
		return type;
	}

	/**
	 * Set the value related to the column: type
	 * 
	 * @param type
	 *            the type value
	 */
	public void setType(java.lang.String type) {
		this.type = type;
	}

	/**
	 * Return the value associated with the column: age
	 */
	public java.lang.String getAge() {
		return age;
	}

	/**
	 * Set the value related to the column: age
	 * 
	 * @param age
	 *            the age value
	 */
	public void setAge(java.lang.String age) {
		this.age = age;
	}

	/**
	 * Return the value associated with the column: tele_no
	 */
	public java.lang.String getTeleNo() {
		return teleNo;
	}

	/**
	 * Set the value related to the column: tele_no
	 * 
	 * @param teleNo
	 *            the tele_no value
	 */
	public void setTeleNo(java.lang.String teleNo) {
		this.teleNo = teleNo;
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
	 * Return the value associated with the column: sex_id
	 */
	public jkt.hms.masters.business.MasAdministrativeSex getSex() {
		return sex;
	}

	/**
	 * Set the value related to the column: sex_id
	 * 
	 * @param sex
	 *            the sex_id value
	 */
	public void setSex(jkt.hms.masters.business.MasAdministrativeSex sex) {
		this.sex = sex;
	}

	/**
	 * Return the value associated with the column: unit_id
	 */
	public jkt.hms.masters.business.MasUnit getUnit() {
		return unit;
	}

	/**
	 * Set the value related to the column: unit_id
	 * 
	 * @param unit
	 *            the unit_id value
	 */
	public void setUnit(jkt.hms.masters.business.MasUnit unit) {
		this.unit = unit;
	}

	/**
	 * Return the value associated with the column: relation_id
	 */
	public jkt.hms.masters.business.MasRelation getRelation() {
		return relation;
	}

	/**
	 * Set the value related to the column: relation_id
	 * 
	 * @param relation
	 *            the relation_id value
	 */
	public void setRelation(jkt.hms.masters.business.MasRelation relation) {
		this.relation = relation;
	}

	/**
	 * Return the value associated with the column: rank_id
	 */
	public jkt.hms.masters.business.MasRank getRank() {
		return rank;
	}

	/**
	 * Set the value related to the column: rank_id
	 * 
	 * @param rank
	 *            the rank_id value
	 */
	public void setRank(jkt.hms.masters.business.MasRank rank) {
		this.rank = rank;
	}

	/**
	 * Return the value associated with the column: received_by
	 */
	public jkt.hms.masters.business.MasEmployee getReceivedBy() {
		return receivedBy;
	}

	/**
	 * Set the value related to the column: received_by
	 * 
	 * @param receivedBy
	 *            the received_by value
	 */
	public void setReceivedBy(jkt.hms.masters.business.MasEmployee receivedBy) {
		this.receivedBy = receivedBy;
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

	/**
	 * Return the value associated with the column: BloodTestEntryDetails
	 */
	public java.util.Set<jkt.hms.masters.business.BloodTestEntryDetail> getBloodTestEntryDetails() {
		return bloodTestEntryDetails;
	}

	/**
	 * Set the value related to the column: BloodTestEntryDetails
	 * 
	 * @param bloodTestEntryDetails
	 *            the BloodTestEntryDetails value
	 */
	public void setBloodTestEntryDetails(
			java.util.Set<jkt.hms.masters.business.BloodTestEntryDetail> bloodTestEntryDetails) {
		this.bloodTestEntryDetails = bloodTestEntryDetails;
	}

	public void addToBloodTestEntryDetails(
			jkt.hms.masters.business.BloodTestEntryDetail bloodTestEntryDetail) {
		if (null == getBloodTestEntryDetails())
			setBloodTestEntryDetails(new java.util.TreeSet<jkt.hms.masters.business.BloodTestEntryDetail>());
		getBloodTestEntryDetails().add(bloodTestEntryDetail);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.BloodTestEntryHeader))
			return false;
		else {
			jkt.hms.masters.business.BloodTestEntryHeader bloodTestEntryHeader = (jkt.hms.masters.business.BloodTestEntryHeader) obj;
			if (null == this.getId() || null == bloodTestEntryHeader.getId())
				return false;
			else
				return (this.getId().equals(bloodTestEntryHeader.getId()));
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
package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the attach_inpatient table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="attach_inpatient"
 */

public abstract class BaseAttachInpatient implements Serializable {

	public static String REF = "AttachInpatient";
	public static String PROP_STATUS = "Status";
	public static String PROP_SEX = "Sex";
	public static String PROP_AD_NO = "AdNo";
	public static String PROP_NAME_OF_ATTACHED = "NameOfAttached";
	public static String PROP_ATTACH_TIME = "AttachTime";
	public static String PROP_HIN = "Hin";
	public static String PROP_AGE = "Age";
	public static String PROP_BED = "Bed";
	public static String PROP_ADD_EDIT_BY = "AddEditBy";
	public static String PROP_DISCHARGE_DATE = "DischargeDate";
	public static String PROP_WARD = "Ward";
	public static String PROP_RELATION = "Relation";
	public static String PROP_DIET_TYPE = "DietType";
	public static String PROP_DISCHARGE_TRANSFER = "DischargeTransfer";
	public static String PROP_DIET = "Diet";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ID = "Id";
	public static String PROP_ATTACH_DATE = "AttachDate";

	// constructors
	public BaseAttachInpatient() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAttachInpatient(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String adNo;
	private java.lang.String nameOfAttached;
	private java.lang.String age;
	private java.lang.String dietType;
	private java.util.Date attachDate;
	private java.lang.String attachTime;
	private java.util.Date dischargeDate;
	private java.lang.String dischargeTransfer;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasDiet diet;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasAdministrativeSex sex;
	private jkt.hms.masters.business.MasBed bed;
	private jkt.hms.masters.business.MasRelation relation;
	private jkt.hms.masters.business.Users addEditBy;
	private jkt.hms.masters.business.MasDepartment ward;
	private jkt.hms.masters.business.Patient hin;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="attach_id"
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
	 * Return the value associated with the column: name_of_attached
	 */
	public java.lang.String getNameOfAttached() {
		return nameOfAttached;
	}

	/**
	 * Set the value related to the column: name_of_attached
	 * 
	 * @param nameOfAttached
	 *            the name_of_attached value
	 */
	public void setNameOfAttached(java.lang.String nameOfAttached) {
		this.nameOfAttached = nameOfAttached;
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
	 * Return the value associated with the column: diet_type
	 */
	public java.lang.String getDietType() {
		return dietType;
	}

	/**
	 * Set the value related to the column: diet_type
	 * 
	 * @param dietType
	 *            the diet_type value
	 */
	public void setDietType(java.lang.String dietType) {
		this.dietType = dietType;
	}

	/**
	 * Return the value associated with the column: attach_date
	 */
	public java.util.Date getAttachDate() {
		return attachDate;
	}

	/**
	 * Set the value related to the column: attach_date
	 * 
	 * @param attachDate
	 *            the attach_date value
	 */
	public void setAttachDate(java.util.Date attachDate) {
		this.attachDate = attachDate;
	}

	/**
	 * Return the value associated with the column: attach_time
	 */
	public java.lang.String getAttachTime() {
		return attachTime;
	}

	/**
	 * Set the value related to the column: attach_time
	 * 
	 * @param attachTime
	 *            the attach_time value
	 */
	public void setAttachTime(java.lang.String attachTime) {
		this.attachTime = attachTime;
	}

	/**
	 * Return the value associated with the column: discharge_date
	 */
	public java.util.Date getDischargeDate() {
		return dischargeDate;
	}

	/**
	 * Set the value related to the column: discharge_date
	 * 
	 * @param dischargeDate
	 *            the discharge_date value
	 */
	public void setDischargeDate(java.util.Date dischargeDate) {
		this.dischargeDate = dischargeDate;
	}

	/**
	 * Return the value associated with the column: discharge_transfer
	 */
	public java.lang.String getDischargeTransfer() {
		return dischargeTransfer;
	}

	/**
	 * Set the value related to the column: discharge_transfer
	 * 
	 * @param dischargeTransfer
	 *            the discharge_transfer value
	 */
	public void setDischargeTransfer(java.lang.String dischargeTransfer) {
		this.dischargeTransfer = dischargeTransfer;
	}

	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus() {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * 
	 * @param status
	 *            the status value
	 */
	public void setStatus(java.lang.String status) {
		this.status = status;
	}

	/**
	 * Return the value associated with the column: diet_id
	 */
	public jkt.hms.masters.business.MasDiet getDiet() {
		return diet;
	}

	/**
	 * Set the value related to the column: diet_id
	 * 
	 * @param diet
	 *            the diet_id value
	 */
	public void setDiet(jkt.hms.masters.business.MasDiet diet) {
		this.diet = diet;
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
	 * Return the value associated with the column: bed_id
	 */
	public jkt.hms.masters.business.MasBed getBed() {
		return bed;
	}

	/**
	 * Set the value related to the column: bed_id
	 * 
	 * @param bed
	 *            the bed_id value
	 */
	public void setBed(jkt.hms.masters.business.MasBed bed) {
		this.bed = bed;
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
	 * Return the value associated with the column: add_edit_by_id
	 */
	public jkt.hms.masters.business.Users getAddEditBy() {
		return addEditBy;
	}

	/**
	 * Set the value related to the column: add_edit_by_id
	 * 
	 * @param addEditBy
	 *            the add_edit_by_id value
	 */
	public void setAddEditBy(jkt.hms.masters.business.Users addEditBy) {
		this.addEditBy = addEditBy;
	}

	/**
	 * Return the value associated with the column: ward_id
	 */
	public jkt.hms.masters.business.MasDepartment getWard() {
		return ward;
	}

	/**
	 * Set the value related to the column: ward_id
	 * 
	 * @param ward
	 *            the ward_id value
	 */
	public void setWard(jkt.hms.masters.business.MasDepartment ward) {
		this.ward = ward;
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
		if (!(obj instanceof jkt.hms.masters.business.AttachInpatient))
			return false;
		else {
			jkt.hms.masters.business.AttachInpatient attachInpatient = (jkt.hms.masters.business.AttachInpatient) obj;
			if (null == this.getId() || null == attachInpatient.getId())
				return false;
			else
				return (this.getId().equals(attachInpatient.getId()));
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
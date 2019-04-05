package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the car_diary_entry table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="car_diary_entry"
 */

public abstract class BaseCarDiaryEntry implements Serializable {

	public static String REF = "CarDiaryEntry";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_TO_PLACE = "ToPlace";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_SPECIFICATION_OF_DUTY = "SpecificationOfDuty";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_TOTAL_KM = "TotalKm";
	public static String PROP_FROM_PLACE = "FromPlace";
	public static String PROP_ENTRY_NO = "EntryNo";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ENTRY_DATE = "EntryDate";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_ID = "Id";

	// constructors
	public BaseCarDiaryEntry() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCarDiaryEntry(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCarDiaryEntry(java.lang.Integer id,
			jkt.hms.masters.business.MasHospital hospital,
			jkt.hms.masters.business.MasDepartment department) {

		this.setId(id);
		this.setHospital(hospital);
		this.setDepartment(department);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String entryNo;
	private java.util.Date entryDate;
	private java.lang.String specificationOfDuty;
	private java.lang.String fromPlace;
	private java.lang.String toPlace;
	private java.math.BigDecimal totalKm;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="car_diary_id"
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
	 * Return the value associated with the column: entry_no
	 */
	public java.lang.String getEntryNo() {
		return entryNo;
	}

	/**
	 * Set the value related to the column: entry_no
	 * 
	 * @param entryNo
	 *            the entry_no value
	 */
	public void setEntryNo(java.lang.String entryNo) {
		this.entryNo = entryNo;
	}

	/**
	 * Return the value associated with the column: entry_date
	 */
	public java.util.Date getEntryDate() {
		return entryDate;
	}

	/**
	 * Set the value related to the column: entry_date
	 * 
	 * @param entryDate
	 *            the entry_date value
	 */
	public void setEntryDate(java.util.Date entryDate) {
		this.entryDate = entryDate;
	}

	/**
	 * Return the value associated with the column: specification_of_duty
	 */
	public java.lang.String getSpecificationOfDuty() {
		return specificationOfDuty;
	}

	/**
	 * Set the value related to the column: specification_of_duty
	 * 
	 * @param specificationOfDuty
	 *            the specification_of_duty value
	 */
	public void setSpecificationOfDuty(java.lang.String specificationOfDuty) {
		this.specificationOfDuty = specificationOfDuty;
	}

	/**
	 * Return the value associated with the column: from_place
	 */
	public java.lang.String getFromPlace() {
		return fromPlace;
	}

	/**
	 * Set the value related to the column: from_place
	 * 
	 * @param fromPlace
	 *            the from_place value
	 */
	public void setFromPlace(java.lang.String fromPlace) {
		this.fromPlace = fromPlace;
	}

	/**
	 * Return the value associated with the column: to_place
	 */
	public java.lang.String getToPlace() {
		return toPlace;
	}

	/**
	 * Set the value related to the column: to_place
	 * 
	 * @param toPlace
	 *            the to_place value
	 */
	public void setToPlace(java.lang.String toPlace) {
		this.toPlace = toPlace;
	}

	/**
	 * Return the value associated with the column: total_km
	 */
	public java.math.BigDecimal getTotalKm() {
		return totalKm;
	}

	/**
	 * Set the value related to the column: total_km
	 * 
	 * @param totalKm
	 *            the total_km value
	 */
	public void setTotalKm(java.math.BigDecimal totalKm) {
		this.totalKm = totalKm;
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

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.CarDiaryEntry))
			return false;
		else {
			jkt.hms.masters.business.CarDiaryEntry carDiaryEntry = (jkt.hms.masters.business.CarDiaryEntry) obj;
			if (null == this.getId() || null == carDiaryEntry.getId())
				return false;
			else
				return (this.getId().equals(carDiaryEntry.getId()));
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
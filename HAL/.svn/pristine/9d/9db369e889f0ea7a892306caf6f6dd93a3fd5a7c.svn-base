package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the app_equipment_master
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="app_equipment_master"
 */

public abstract class BaseAppEquipmentMaster implements Serializable {

	public static String REF = "AppEquipmentMaster";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_EQUIPMENT_STATUS = "EquipmentStatus";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_EQUIPMENT_NAME = "EquipmentName";
	public static String PROP_HOSPITAL_ID = "HospitalId";
	public static String PROP_ID = "Id";
	public static String PROP_NO_OF_EQUIPMENTS = "NoOfEquipments";
	public static String PROP_EQUIPMENT_CODE = "EquipmentCode";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";

	// constructors
	public BaseAppEquipmentMaster() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAppEquipmentMaster(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String equipmentCode;
	private java.lang.String equipmentName;
	private java.lang.String lastChgBy;
	private java.lang.String lastChgTime;
	private java.util.Date lastChgDate;
	private java.lang.Integer hospitalId;
	private java.lang.String equipmentStatus;
	private java.lang.Integer noOfEquipments;

	// many to one
	private jkt.hms.masters.business.MasDepartment department;

	// collections
	private java.util.Set<jkt.hms.masters.business.AppInvestigationSetup> appInvestigationSetups;
	private java.util.Set<jkt.hms.masters.business.DgMasInvestigation> dgMasInvestigations;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="equipment_id"
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
	 * Return the value associated with the column: equipment_code
	 */
	public java.lang.String getEquipmentCode() {
		return equipmentCode;
	}

	/**
	 * Set the value related to the column: equipment_code
	 * 
	 * @param equipmentCode
	 *            the equipment_code value
	 */
	public void setEquipmentCode(java.lang.String equipmentCode) {
		this.equipmentCode = equipmentCode;
	}

	/**
	 * Return the value associated with the column: equipment_name
	 */
	public java.lang.String getEquipmentName() {
		return equipmentName;
	}

	/**
	 * Set the value related to the column: equipment_name
	 * 
	 * @param equipmentName
	 *            the equipment_name value
	 */
	public void setEquipmentName(java.lang.String equipmentName) {
		this.equipmentName = equipmentName;
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
	 * Return the value associated with the column: hospital_id
	 */
	public java.lang.Integer getHospitalId() {
		return hospitalId;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * 
	 * @param hospitalId
	 *            the hospital_id value
	 */
	public void setHospitalId(java.lang.Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	/**
	 * Return the value associated with the column: equipment_status
	 */
	public java.lang.String getEquipmentStatus() {
		return equipmentStatus;
	}

	/**
	 * Set the value related to the column: equipment_status
	 * 
	 * @param equipmentStatus
	 *            the equipment_status value
	 */
	public void setEquipmentStatus(java.lang.String equipmentStatus) {
		this.equipmentStatus = equipmentStatus;
	}

	/**
	 * Return the value associated with the column: no_of_equipments
	 */
	public java.lang.Integer getNoOfEquipments() {
		return noOfEquipments;
	}

	/**
	 * Set the value related to the column: no_of_equipments
	 * 
	 * @param noOfEquipments
	 *            the no_of_equipments value
	 */
	public void setNoOfEquipments(java.lang.Integer noOfEquipments) {
		this.noOfEquipments = noOfEquipments;
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
	 * Return the value associated with the column: AppInvestigationSetups
	 */
	public java.util.Set<jkt.hms.masters.business.AppInvestigationSetup> getAppInvestigationSetups() {
		return appInvestigationSetups;
	}

	/**
	 * Set the value related to the column: AppInvestigationSetups
	 * 
	 * @param appInvestigationSetups
	 *            the AppInvestigationSetups value
	 */
	public void setAppInvestigationSetups(
			java.util.Set<jkt.hms.masters.business.AppInvestigationSetup> appInvestigationSetups) {
		this.appInvestigationSetups = appInvestigationSetups;
	}

	public void addToAppInvestigationSetups(
			jkt.hms.masters.business.AppInvestigationSetup appInvestigationSetup) {
		if (null == getAppInvestigationSetups())
			setAppInvestigationSetups(new java.util.TreeSet<jkt.hms.masters.business.AppInvestigationSetup>());
		getAppInvestigationSetups().add(appInvestigationSetup);
	}

	/**
	 * Return the value associated with the column: DgMasInvestigations
	 */
	public java.util.Set<jkt.hms.masters.business.DgMasInvestigation> getDgMasInvestigations() {
		return dgMasInvestigations;
	}

	/**
	 * Set the value related to the column: DgMasInvestigations
	 * 
	 * @param dgMasInvestigations
	 *            the DgMasInvestigations value
	 */
	public void setDgMasInvestigations(
			java.util.Set<jkt.hms.masters.business.DgMasInvestigation> dgMasInvestigations) {
		this.dgMasInvestigations = dgMasInvestigations;
	}

	public void addToDgMasInvestigations(
			jkt.hms.masters.business.DgMasInvestigation dgMasInvestigation) {
		if (null == getDgMasInvestigations())
			setDgMasInvestigations(new java.util.TreeSet<jkt.hms.masters.business.DgMasInvestigation>());
		getDgMasInvestigations().add(dgMasInvestigation);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.AppEquipmentMaster))
			return false;
		else {
			jkt.hms.masters.business.AppEquipmentMaster appEquipmentMaster = (jkt.hms.masters.business.AppEquipmentMaster) obj;
			if (null == this.getId() || null == appEquipmentMaster.getId())
				return false;
			else
				return (this.getId().equals(appEquipmentMaster.getId()));
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
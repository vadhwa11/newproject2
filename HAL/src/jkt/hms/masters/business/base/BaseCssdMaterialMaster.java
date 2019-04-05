package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the cssd_material_master
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="cssd_material_master"
 */

public abstract class BaseCssdMaterialMaster implements Serializable {

	public static String REF = "CssdMaterialMaster";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_MATERIAL_CODE = "MaterialCode";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_MATERIAL_NAME = "MaterialName";

	// constructors
	public BaseCssdMaterialMaster() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCssdMaterialMaster(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCssdMaterialMaster(java.lang.Integer id,
			jkt.hms.masters.business.MasDepartment department,
			java.lang.String materialCode, java.lang.String materialName,
			java.lang.String lastChgTime) {

		this.setId(id);
		this.setDepartment(department);
		this.setMaterialCode(materialCode);
		this.setMaterialName(materialName);
		this.setLastChgTime(lastChgTime);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String materialCode;
	private java.lang.String materialName;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasDepartment department;

	// collections
	private java.util.Set<jkt.hms.masters.business.CssdAutoclaveRequestT> cssdAutoclaveRequestTs;
	private java.util.Set<jkt.hms.masters.business.CssdMaterialStockT> cssdMaterialStockTs;
	private java.util.Set<jkt.hms.masters.business.CssdAutoclaveEntryT> cssdAutoclaveEntryTs;
	private java.util.Set<jkt.hms.masters.business.CssdAutoclaveReceiptT> cssdAutoclaveReceiptTs;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="material_id"
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
	 * Return the value associated with the column: material_code
	 */
	public java.lang.String getMaterialCode() {
		return materialCode;
	}

	/**
	 * Set the value related to the column: material_code
	 * 
	 * @param materialCode
	 *            the material_code value
	 */
	public void setMaterialCode(java.lang.String materialCode) {
		this.materialCode = materialCode;
	}

	/**
	 * Return the value associated with the column: material_name
	 */
	public java.lang.String getMaterialName() {
		return materialName;
	}

	/**
	 * Set the value related to the column: material_name
	 * 
	 * @param materialName
	 *            the material_name value
	 */
	public void setMaterialName(java.lang.String materialName) {
		this.materialName = materialName;
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
	 * Return the value associated with the column: CssdAutoclaveRequestTs
	 */
	public java.util.Set<jkt.hms.masters.business.CssdAutoclaveRequestT> getCssdAutoclaveRequestTs() {
		return cssdAutoclaveRequestTs;
	}

	/**
	 * Set the value related to the column: CssdAutoclaveRequestTs
	 * 
	 * @param cssdAutoclaveRequestTs
	 *            the CssdAutoclaveRequestTs value
	 */
	public void setCssdAutoclaveRequestTs(
			java.util.Set<jkt.hms.masters.business.CssdAutoclaveRequestT> cssdAutoclaveRequestTs) {
		this.cssdAutoclaveRequestTs = cssdAutoclaveRequestTs;
	}

	public void addToCssdAutoclaveRequestTs(
			jkt.hms.masters.business.CssdAutoclaveRequestT cssdAutoclaveRequestT) {
		if (null == getCssdAutoclaveRequestTs())
			setCssdAutoclaveRequestTs(new java.util.TreeSet<jkt.hms.masters.business.CssdAutoclaveRequestT>());
		getCssdAutoclaveRequestTs().add(cssdAutoclaveRequestT);
	}

	/**
	 * Return the value associated with the column: CssdMaterialStockTs
	 */
	public java.util.Set<jkt.hms.masters.business.CssdMaterialStockT> getCssdMaterialStockTs() {
		return cssdMaterialStockTs;
	}

	/**
	 * Set the value related to the column: CssdMaterialStockTs
	 * 
	 * @param cssdMaterialStockTs
	 *            the CssdMaterialStockTs value
	 */
	public void setCssdMaterialStockTs(
			java.util.Set<jkt.hms.masters.business.CssdMaterialStockT> cssdMaterialStockTs) {
		this.cssdMaterialStockTs = cssdMaterialStockTs;
	}

	public void addToCssdMaterialStockTs(
			jkt.hms.masters.business.CssdMaterialStockT cssdMaterialStockT) {
		if (null == getCssdMaterialStockTs())
			setCssdMaterialStockTs(new java.util.TreeSet<jkt.hms.masters.business.CssdMaterialStockT>());
		getCssdMaterialStockTs().add(cssdMaterialStockT);
	}

	/**
	 * Return the value associated with the column: CssdAutoclaveEntryTs
	 */
	public java.util.Set<jkt.hms.masters.business.CssdAutoclaveEntryT> getCssdAutoclaveEntryTs() {
		return cssdAutoclaveEntryTs;
	}

	/**
	 * Set the value related to the column: CssdAutoclaveEntryTs
	 * 
	 * @param cssdAutoclaveEntryTs
	 *            the CssdAutoclaveEntryTs value
	 */
	public void setCssdAutoclaveEntryTs(
			java.util.Set<jkt.hms.masters.business.CssdAutoclaveEntryT> cssdAutoclaveEntryTs) {
		this.cssdAutoclaveEntryTs = cssdAutoclaveEntryTs;
	}

	public void addToCssdAutoclaveEntryTs(
			jkt.hms.masters.business.CssdAutoclaveEntryT cssdAutoclaveEntryT) {
		if (null == getCssdAutoclaveEntryTs())
			setCssdAutoclaveEntryTs(new java.util.TreeSet<jkt.hms.masters.business.CssdAutoclaveEntryT>());
		getCssdAutoclaveEntryTs().add(cssdAutoclaveEntryT);
	}

	/**
	 * Return the value associated with the column: CssdAutoclaveReceiptTs
	 */
	public java.util.Set<jkt.hms.masters.business.CssdAutoclaveReceiptT> getCssdAutoclaveReceiptTs() {
		return cssdAutoclaveReceiptTs;
	}

	/**
	 * Set the value related to the column: CssdAutoclaveReceiptTs
	 * 
	 * @param cssdAutoclaveReceiptTs
	 *            the CssdAutoclaveReceiptTs value
	 */
	public void setCssdAutoclaveReceiptTs(
			java.util.Set<jkt.hms.masters.business.CssdAutoclaveReceiptT> cssdAutoclaveReceiptTs) {
		this.cssdAutoclaveReceiptTs = cssdAutoclaveReceiptTs;
	}

	public void addToCssdAutoclaveReceiptTs(
			jkt.hms.masters.business.CssdAutoclaveReceiptT cssdAutoclaveReceiptT) {
		if (null == getCssdAutoclaveReceiptTs())
			setCssdAutoclaveReceiptTs(new java.util.TreeSet<jkt.hms.masters.business.CssdAutoclaveReceiptT>());
		getCssdAutoclaveReceiptTs().add(cssdAutoclaveReceiptT);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.CssdMaterialMaster))
			return false;
		else {
			jkt.hms.masters.business.CssdMaterialMaster cssdMaterialMaster = (jkt.hms.masters.business.CssdMaterialMaster) obj;
			if (null == this.getId() || null == cssdMaterialMaster.getId())
				return false;
			else
				return (this.getId().equals(cssdMaterialMaster.getId()));
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
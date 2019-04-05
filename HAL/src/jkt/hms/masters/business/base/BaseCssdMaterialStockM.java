package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the cssd_material_stock_m
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="cssd_material_stock_m"
 */

public abstract class BaseCssdMaterialStockM implements Serializable {

	public static String REF = "CssdMaterialStockM";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ENTRY_NO = "EntryNo";
	public static String PROP_ID = "Id";
	public static String PROP_APPROVED_BY = "ApprovedBy";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";

	// constructors
	public BaseCssdMaterialStockM() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCssdMaterialStockM(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCssdMaterialStockM(java.lang.Integer id,
			jkt.hms.masters.business.MasEmployee approvedBy,
			jkt.hms.masters.business.MasDepartment department,
			java.lang.String entryNo) {

		this.setId(id);
		this.setApprovedBy(approvedBy);
		this.setDepartment(department);
		this.setEntryNo(entryNo);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String entryNo;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasEmployee approvedBy;
	private jkt.hms.masters.business.MasDepartment department;

	// collections
	private java.util.Set<jkt.hms.masters.business.CssdMaterialStockT> cssdMaterialStockTs;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="stock_id"
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
	 * Return the value associated with the column: approved_by
	 */
	public jkt.hms.masters.business.MasEmployee getApprovedBy() {
		return approvedBy;
	}

	/**
	 * Set the value related to the column: approved_by
	 * 
	 * @param approvedBy
	 *            the approved_by value
	 */
	public void setApprovedBy(jkt.hms.masters.business.MasEmployee approvedBy) {
		this.approvedBy = approvedBy;
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

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.CssdMaterialStockM))
			return false;
		else {
			jkt.hms.masters.business.CssdMaterialStockM cssdMaterialStockM = (jkt.hms.masters.business.CssdMaterialStockM) obj;
			if (null == this.getId() || null == cssdMaterialStockM.getId())
				return false;
			else
				return (this.getId().equals(cssdMaterialStockM.getId()));
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
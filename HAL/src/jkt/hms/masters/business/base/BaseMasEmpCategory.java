package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the mas_emp_category table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="mas_emp_category"
 */

public abstract class BaseMasEmpCategory implements Serializable {

	public static String REF = "MasEmpCategory";
	public static String PROP_STATUS = "Status";
	public static String PROP_EMP_CATEGORY_CODE = "EmpCategoryCode";
	public static String PROP_EMP_CATEGORY_NAME = "EmpCategoryName";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_ID = "Id";

	// constructors
	public BaseMasEmpCategory() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasEmpCategory(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String empCategoryCode;
	private java.lang.String empCategoryName;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;

	// collections
	private java.util.Set<jkt.hms.masters.business.MasEmployee> masEmployees;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="emp_category_id"
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
	 * Return the value associated with the column: emp_category_code
	 */
	public java.lang.String getEmpCategoryCode() {
		return empCategoryCode;
	}

	/**
	 * Set the value related to the column: emp_category_code
	 * 
	 * @param empCategoryCode
	 *            the emp_category_code value
	 */
	public void setEmpCategoryCode(java.lang.String empCategoryCode) {
		this.empCategoryCode = empCategoryCode;
	}

	/**
	 * Return the value associated with the column: emp_category_name
	 */
	public java.lang.String getEmpCategoryName() {
		return empCategoryName;
	}

	/**
	 * Set the value related to the column: emp_category_name
	 * 
	 * @param empCategoryName
	 *            the emp_category_name value
	 */
	public void setEmpCategoryName(java.lang.String empCategoryName) {
		this.empCategoryName = empCategoryName;
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
	 * Return the value associated with the column: MasEmployees
	 */
	public java.util.Set<jkt.hms.masters.business.MasEmployee> getMasEmployees() {
		return masEmployees;
	}

	/**
	 * Set the value related to the column: MasEmployees
	 * 
	 * @param masEmployees
	 *            the MasEmployees value
	 */
	public void setMasEmployees(
			java.util.Set<jkt.hms.masters.business.MasEmployee> masEmployees) {
		this.masEmployees = masEmployees;
	}

	public void addToMasEmployees(
			jkt.hms.masters.business.MasEmployee masEmployee) {
		if (null == getMasEmployees())
			setMasEmployees(new java.util.TreeSet<jkt.hms.masters.business.MasEmployee>());
		getMasEmployees().add(masEmployee);
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MasEmpCategory))
			return false;
		else {
			jkt.hms.masters.business.MasEmpCategory masEmpCategory = (jkt.hms.masters.business.MasEmpCategory) obj;
			if (null == this.getId() || null == masEmpCategory.getId())
				return false;
			else
				return (this.getId().equals(masEmpCategory.getId()));
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
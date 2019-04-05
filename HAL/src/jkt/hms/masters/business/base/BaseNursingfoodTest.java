package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the nursingfood_test table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="nursingfood_test"
 */

public abstract class BaseNursingfoodTest implements Serializable {

	public static String REF = "NursingfoodTest";
	public static String PROP_FOODDATE = "Fooddate";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_FOODTIME = "Foodtime";
	public static String PROP_FOODSTATUS = "Foodstatus";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_TESTEDBY = "Testedby";
	public static String PROP_FOODNAME = "Foodname";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_ID = "Id";
	public static String PROP_REMARKS = "Remarks";

	// constructors
	public BaseNursingfoodTest() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseNursingfoodTest(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String foodname;
	private java.lang.String foodstatus;
	private java.util.Date fooddate;
	private java.lang.String foodtime;
	private java.lang.String remarks;
	private java.lang.String testedby;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;

	// many to one
	private jkt.hms.masters.business.MasDepartment department;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="foodtest_id"
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
	 * Return the value associated with the column: foodname
	 */
	public java.lang.String getFoodname() {
		return foodname;
	}

	/**
	 * Set the value related to the column: foodname
	 * 
	 * @param foodname
	 *            the foodname value
	 */
	public void setFoodname(java.lang.String foodname) {
		this.foodname = foodname;
	}

	/**
	 * Return the value associated with the column: foodstatus
	 */
	public java.lang.String getFoodstatus() {
		return foodstatus;
	}

	/**
	 * Set the value related to the column: foodstatus
	 * 
	 * @param foodstatus
	 *            the foodstatus value
	 */
	public void setFoodstatus(java.lang.String foodstatus) {
		this.foodstatus = foodstatus;
	}

	/**
	 * Return the value associated with the column: fooddate
	 */
	public java.util.Date getFooddate() {
		return fooddate;
	}

	/**
	 * Set the value related to the column: fooddate
	 * 
	 * @param fooddate
	 *            the fooddate value
	 */
	public void setFooddate(java.util.Date fooddate) {
		this.fooddate = fooddate;
	}

	/**
	 * Return the value associated with the column: foodtime
	 */
	public java.lang.String getFoodtime() {
		return foodtime;
	}

	/**
	 * Set the value related to the column: foodtime
	 * 
	 * @param foodtime
	 *            the foodtime value
	 */
	public void setFoodtime(java.lang.String foodtime) {
		this.foodtime = foodtime;
	}

	/**
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks() {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * 
	 * @param remarks
	 *            the remarks value
	 */
	public void setRemarks(java.lang.String remarks) {
		this.remarks = remarks;
	}

	/**
	 * Return the value associated with the column: testedby
	 */
	public java.lang.String getTestedby() {
		return testedby;
	}

	/**
	 * Set the value related to the column: testedby
	 * 
	 * @param testedby
	 *            the testedby value
	 */
	public void setTestedby(java.lang.String testedby) {
		this.testedby = testedby;
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

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.NursingfoodTest))
			return false;
		else {
			jkt.hms.masters.business.NursingfoodTest nursingfoodTest = (jkt.hms.masters.business.NursingfoodTest) obj;
			if (null == this.getId() || null == nursingfoodTest.getId())
				return false;
			else
				return (this.getId().equals(nursingfoodTest.getId()));
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
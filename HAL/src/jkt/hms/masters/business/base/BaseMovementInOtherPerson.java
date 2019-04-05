package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the movement_in_other_person
 * table. Do not modify this class because it will be overwritten if the
 * configuration file related to this class is modified.
 * 
 * @hibernate.class table="movement_in_other_person"
 */

public abstract class BaseMovementInOtherPerson implements Serializable {

	public static String REF = "MovementInOtherPerson";
	public static String PROP_MOVEMENT_IN_STATUS = "MovementInStatus";
	public static String PROP_RANK = "Rank";
	public static String PROP_TRADE = "Trade";
	public static String PROP_SERVICE_NO = "ServiceNo";
	public static String PROP_SUFFIX = "Suffix";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_SERVICE_TYPE = "ServiceType";
	public static String PROP_EMP_STATUS = "EmpStatus";
	public static String PROP_PREFIX = "Prefix";
	public static String PROP_LAST_NAME = "LastName";
	public static String PROP_EMPLOYEE_CODE = "EmployeeCode";
	public static String PROP_TITLE = "Title";
	public static String PROP_MOVEMENT_OUT_STATUS = "MovementOutStatus";
	public static String PROP_STATUS = "Status";
	public static String PROP_CATEGORY = "Category";
	public static String PROP_MIDDLE_NAME = "MiddleName";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_GRADE = "Grade";
	public static String PROP_PRESENT_UNIT = "PresentUnit";
	public static String PROP_FIRST_NAME = "FirstName";
	public static String PROP_ID = "Id";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";

	// constructors
	public BaseMovementInOtherPerson() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMovementInOtherPerson(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String prefix;
	private java.lang.String suffix;
	private java.lang.String serviceNo;
	private java.lang.String firstName;
	private java.lang.String middleName;
	private java.lang.String lastName;
	private java.lang.String movementInStatus;
	private java.lang.String movementOutStatus;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String employeeCode;

	// many to one
	private jkt.hms.masters.business.MasEmpCategory category;
	private jkt.hms.masters.business.MasGrade grade;
	private jkt.hms.masters.business.MasEmpStatus empStatus;
	private jkt.hms.masters.business.MasTrade trade;
	private jkt.hms.masters.business.MasUnit presentUnit;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasServiceType serviceType;
	private jkt.hms.masters.business.MasRank rank;
	private jkt.hms.masters.business.MasTitle title;

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
	 * Return the value associated with the column: prefix
	 */
	public java.lang.String getPrefix() {
		return prefix;
	}

	/**
	 * Set the value related to the column: prefix
	 * 
	 * @param prefix
	 *            the prefix value
	 */
	public void setPrefix(java.lang.String prefix) {
		this.prefix = prefix;
	}

	/**
	 * Return the value associated with the column: suffix
	 */
	public java.lang.String getSuffix() {
		return suffix;
	}

	/**
	 * Set the value related to the column: suffix
	 * 
	 * @param suffix
	 *            the suffix value
	 */
	public void setSuffix(java.lang.String suffix) {
		this.suffix = suffix;
	}

	/**
	 * Return the value associated with the column: service_no
	 */
	public java.lang.String getServiceNo() {
		return serviceNo;
	}

	/**
	 * Set the value related to the column: service_no
	 * 
	 * @param serviceNo
	 *            the service_no value
	 */
	public void setServiceNo(java.lang.String serviceNo) {
		this.serviceNo = serviceNo;
	}

	/**
	 * Return the value associated with the column: first_name
	 */
	public java.lang.String getFirstName() {
		return firstName;
	}

	/**
	 * Set the value related to the column: first_name
	 * 
	 * @param firstName
	 *            the first_name value
	 */
	public void setFirstName(java.lang.String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Return the value associated with the column: middle_name
	 */
	public java.lang.String getMiddleName() {
		return middleName;
	}

	/**
	 * Set the value related to the column: middle_name
	 * 
	 * @param middleName
	 *            the middle_name value
	 */
	public void setMiddleName(java.lang.String middleName) {
		this.middleName = middleName;
	}

	/**
	 * Return the value associated with the column: last_name
	 */
	public java.lang.String getLastName() {
		return lastName;
	}

	/**
	 * Set the value related to the column: last_name
	 * 
	 * @param lastName
	 *            the last_name value
	 */
	public void setLastName(java.lang.String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Return the value associated with the column: movement_in_status
	 */
	public java.lang.String getMovementInStatus() {
		return movementInStatus;
	}

	/**
	 * Set the value related to the column: movement_in_status
	 * 
	 * @param movementInStatus
	 *            the movement_in_status value
	 */
	public void setMovementInStatus(java.lang.String movementInStatus) {
		this.movementInStatus = movementInStatus;
	}

	/**
	 * Return the value associated with the column: movement_out_status
	 */
	public java.lang.String getMovementOutStatus() {
		return movementOutStatus;
	}

	/**
	 * Set the value related to the column: movement_out_status
	 * 
	 * @param movementOutStatus
	 *            the movement_out_status value
	 */
	public void setMovementOutStatus(java.lang.String movementOutStatus) {
		this.movementOutStatus = movementOutStatus;
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
	 * Return the value associated with the column: employee_code
	 */
	public java.lang.String getEmployeeCode() {
		return employeeCode;
	}

	/**
	 * Set the value related to the column: employee_code
	 * 
	 * @param employeeCode
	 *            the employee_code value
	 */
	public void setEmployeeCode(java.lang.String employeeCode) {
		this.employeeCode = employeeCode;
	}

	/**
	 * Return the value associated with the column: Category
	 */
	public jkt.hms.masters.business.MasEmpCategory getCategory() {
		return category;
	}

	/**
	 * Set the value related to the column: Category
	 * 
	 * @param category
	 *            the Category value
	 */
	public void setCategory(jkt.hms.masters.business.MasEmpCategory category) {
		this.category = category;
	}

	/**
	 * Return the value associated with the column: grade
	 */
	public jkt.hms.masters.business.MasGrade getGrade() {
		return grade;
	}

	/**
	 * Set the value related to the column: grade
	 * 
	 * @param grade
	 *            the grade value
	 */
	public void setGrade(jkt.hms.masters.business.MasGrade grade) {
		this.grade = grade;
	}

	/**
	 * Return the value associated with the column: emp_status
	 */
	public jkt.hms.masters.business.MasEmpStatus getEmpStatus() {
		return empStatus;
	}

	/**
	 * Set the value related to the column: emp_status
	 * 
	 * @param empStatus
	 *            the emp_status value
	 */
	public void setEmpStatus(jkt.hms.masters.business.MasEmpStatus empStatus) {
		this.empStatus = empStatus;
	}

	/**
	 * Return the value associated with the column: trade
	 */
	public jkt.hms.masters.business.MasTrade getTrade() {
		return trade;
	}

	/**
	 * Set the value related to the column: trade
	 * 
	 * @param trade
	 *            the trade value
	 */
	public void setTrade(jkt.hms.masters.business.MasTrade trade) {
		this.trade = trade;
	}

	/**
	 * Return the value associated with the column: present_unit
	 */
	public jkt.hms.masters.business.MasUnit getPresentUnit() {
		return presentUnit;
	}

	/**
	 * Set the value related to the column: present_unit
	 * 
	 * @param presentUnit
	 *            the present_unit value
	 */
	public void setPresentUnit(jkt.hms.masters.business.MasUnit presentUnit) {
		this.presentUnit = presentUnit;
	}

	/**
	 * Return the value associated with the column: department
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment() {
		return department;
	}

	/**
	 * Set the value related to the column: department
	 * 
	 * @param department
	 *            the department value
	 */
	public void setDepartment(jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}

	/**
	 * Return the value associated with the column: service_type
	 */
	public jkt.hms.masters.business.MasServiceType getServiceType() {
		return serviceType;
	}

	/**
	 * Set the value related to the column: service_type
	 * 
	 * @param serviceType
	 *            the service_type value
	 */
	public void setServiceType(
			jkt.hms.masters.business.MasServiceType serviceType) {
		this.serviceType = serviceType;
	}

	/**
	 * Return the value associated with the column: rank
	 */
	public jkt.hms.masters.business.MasRank getRank() {
		return rank;
	}

	/**
	 * Set the value related to the column: rank
	 * 
	 * @param rank
	 *            the rank value
	 */
	public void setRank(jkt.hms.masters.business.MasRank rank) {
		this.rank = rank;
	}

	/**
	 * Return the value associated with the column: title
	 */
	public jkt.hms.masters.business.MasTitle getTitle() {
		return title;
	}

	/**
	 * Set the value related to the column: title
	 * 
	 * @param title
	 *            the title value
	 */
	public void setTitle(jkt.hms.masters.business.MasTitle title) {
		this.title = title;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.MovementInOtherPerson))
			return false;
		else {
			jkt.hms.masters.business.MovementInOtherPerson movementInOtherPerson = (jkt.hms.masters.business.MovementInOtherPerson) obj;
			if (null == this.getId() || null == movementInOtherPerson.getId())
				return false;
			else
				return (this.getId().equals(movementInOtherPerson.getId()));
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
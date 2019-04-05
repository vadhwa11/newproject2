package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the employee_dependent table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="employee_dependent"
 */

public abstract class BaseEmployeeDependent implements Serializable {

	public static String REF = "EmployeeDependent";
	public static String PROP_DEPENDENT_NAME = "DependentName";
	public static String PROP_JOB_TYPE = "JobType";
	public static String PROP_CITY = "City";
	public static String PROP_ZIPCODE = "Zipcode";
	public static String PROP_COUNTY = "County";
	public static String PROP_DEPENDENT_CODE = "DependentCode";
	public static String PROP_EDUCATION_DETAIL = "EducationDetail";
	public static String PROP_ADDRESS = "Address";
	public static String PROP_LAST_CHANGED_BY = "LastChangedBy";
	public static String PROP_DIVISON_CODE = "DivisonCode";
	public static String PROP_EMPLOYEE_SEQUENCE_ID = "EmployeeSequenceId";
	public static String PROP_DATE_OF_BIRTH = "DateOfBirth";
	public static String PROP_GENDER = "Gender";
	public static String PROP_MARITIAL_STATUS = "MaritialStatus";
	public static String PROP_DEPENDENT_STATE = "DependentState";
	public static String PROP_DEPARTMENT_STATUS = "DepartmentStatus";
	public static String PROP_DEPENDENT_EMPLOYEE_NAME = "DependentEmployeeName";
	public static String PROP_LAST_CHANGE_DATE_TIME = "LastChangeDateTime";
	public static String PROP_COMPANY_CODE = "CompanyCode";
	public static String PROP_ELIGIBILITY = "Eligibility";
	public static String PROP_RELATION = "Relation";
	public static String PROP_PHONE_NUMBER = "PhoneNumber";
	public static String PROP_OCCUPATION = "Occupation";
	public static String PROP_DEPENDENT_AGE = "DependentAge";
	public static String PROP_ID = "Id";

	// constructors
	public BaseEmployeeDependent() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseEmployeeDependent(java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String companyCode;
	private java.lang.String divisonCode;
	private java.lang.String dependentCode;
	private java.lang.String dependentName;
	private java.util.Date dateOfBirth;
	private java.lang.String gender;
	private java.lang.String relation;
	private java.lang.String dependentEmployeeName;
	private java.lang.String address;
	private java.lang.String city;
	private java.lang.String dependentState;
	private java.lang.String county;
	private java.lang.String zipcode;
	private java.lang.String phoneNumber;
	private java.lang.String lastChangedBy;
	private java.util.Date lastChangeDateTime;
	private java.lang.Integer dependentAge;
	private java.lang.String maritialStatus;
	private java.lang.String educationDetail;
	private java.lang.String departmentStatus;
	private java.lang.String occupation;
	private java.lang.Integer eligibility;
	private java.lang.String jobType;
	private java.lang.Integer employeeSequenceId;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="employee_dependent_id"
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
	 * Return the value associated with the column: company_code
	 */
	public java.lang.String getCompanyCode() {
		return companyCode;
	}

	/**
	 * Set the value related to the column: company_code
	 * 
	 * @param companyCode
	 *            the company_code value
	 */
	public void setCompanyCode(java.lang.String companyCode) {
		this.companyCode = companyCode;
	}

	/**
	 * Return the value associated with the column: divison_code
	 */
	public java.lang.String getDivisonCode() {
		return divisonCode;
	}

	/**
	 * Set the value related to the column: divison_code
	 * 
	 * @param divisonCode
	 *            the divison_code value
	 */
	public void setDivisonCode(java.lang.String divisonCode) {
		this.divisonCode = divisonCode;
	}

	/**
	 * Return the value associated with the column: dependent_code
	 */
	public java.lang.String getDependentCode() {
		return dependentCode;
	}

	/**
	 * Set the value related to the column: dependent_code
	 * 
	 * @param dependentCode
	 *            the dependent_code value
	 */
	public void setDependentCode(java.lang.String dependentCode) {
		this.dependentCode = dependentCode;
	}

	/**
	 * Return the value associated with the column: dependent_name
	 */
	public java.lang.String getDependentName() {
		return dependentName;
	}

	/**
	 * Set the value related to the column: dependent_name
	 * 
	 * @param dependentName
	 *            the dependent_name value
	 */
	public void setDependentName(java.lang.String dependentName) {
		this.dependentName = dependentName;
	}

	/**
	 * Return the value associated with the column: date_of_birth
	 */
	public java.util.Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * Set the value related to the column: date_of_birth
	 * 
	 * @param dateOfBirth
	 *            the date_of_birth value
	 */
	public void setDateOfBirth(java.util.Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * Return the value associated with the column: gender
	 */
	public java.lang.String getGender() {
		return gender;
	}

	/**
	 * Set the value related to the column: gender
	 * 
	 * @param gender
	 *            the gender value
	 */
	public void setGender(java.lang.String gender) {
		this.gender = gender;
	}

	/**
	 * Return the value associated with the column: relation
	 */
	public java.lang.String getRelation() {
		return relation;
	}

	/**
	 * Set the value related to the column: relation
	 * 
	 * @param relation
	 *            the relation value
	 */
	public void setRelation(java.lang.String relation) {
		this.relation = relation;
	}

	/**
	 * Return the value associated with the column: dependent_employee_name
	 */
	public java.lang.String getDependentEmployeeName() {
		return dependentEmployeeName;
	}

	/**
	 * Set the value related to the column: dependent_employee_name
	 * 
	 * @param dependentEmployeeName
	 *            the dependent_employee_name value
	 */
	public void setDependentEmployeeName(java.lang.String dependentEmployeeName) {
		this.dependentEmployeeName = dependentEmployeeName;
	}

	/**
	 * Return the value associated with the column: address
	 */
	public java.lang.String getAddress() {
		return address;
	}

	/**
	 * Set the value related to the column: address
	 * 
	 * @param address
	 *            the address value
	 */
	public void setAddress(java.lang.String address) {
		this.address = address;
	}

	/**
	 * Return the value associated with the column: city
	 */
	public java.lang.String getCity() {
		return city;
	}

	/**
	 * Set the value related to the column: city
	 * 
	 * @param city
	 *            the city value
	 */
	public void setCity(java.lang.String city) {
		this.city = city;
	}

	/**
	 * Return the value associated with the column: dependent_state
	 */
	public java.lang.String getDependentState() {
		return dependentState;
	}

	/**
	 * Set the value related to the column: dependent_state
	 * 
	 * @param dependentState
	 *            the dependent_state value
	 */
	public void setDependentState(java.lang.String dependentState) {
		this.dependentState = dependentState;
	}

	/**
	 * Return the value associated with the column: county
	 */
	public java.lang.String getCounty() {
		return county;
	}

	/**
	 * Set the value related to the column: county
	 * 
	 * @param county
	 *            the county value
	 */
	public void setCounty(java.lang.String county) {
		this.county = county;
	}

	/**
	 * Return the value associated with the column: zipcode
	 */
	public java.lang.String getZipcode() {
		return zipcode;
	}

	/**
	 * Set the value related to the column: zipcode
	 * 
	 * @param zipcode
	 *            the zipcode value
	 */
	public void setZipcode(java.lang.String zipcode) {
		this.zipcode = zipcode;
	}

	/**
	 * Return the value associated with the column: phone_number
	 */
	public java.lang.String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Set the value related to the column: phone_number
	 * 
	 * @param phoneNumber
	 *            the phone_number value
	 */
	public void setPhoneNumber(java.lang.String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Return the value associated with the column: last_changed_by
	 */
	public java.lang.String getLastChangedBy() {
		return lastChangedBy;
	}

	/**
	 * Set the value related to the column: last_changed_by
	 * 
	 * @param lastChangedBy
	 *            the last_changed_by value
	 */
	public void setLastChangedBy(java.lang.String lastChangedBy) {
		this.lastChangedBy = lastChangedBy;
	}

	/**
	 * Return the value associated with the column: last_change_date_time
	 */
	public java.util.Date getLastChangeDateTime() {
		return lastChangeDateTime;
	}

	/**
	 * Set the value related to the column: last_change_date_time
	 * 
	 * @param lastChangeDateTime
	 *            the last_change_date_time value
	 */
	public void setLastChangeDateTime(java.util.Date lastChangeDateTime) {
		this.lastChangeDateTime = lastChangeDateTime;
	}

	/**
	 * Return the value associated with the column: dependent_age
	 */
	public java.lang.Integer getDependentAge() {
		return dependentAge;
	}

	/**
	 * Set the value related to the column: dependent_age
	 * 
	 * @param dependentAge
	 *            the dependent_age value
	 */
	public void setDependentAge(java.lang.Integer dependentAge) {
		this.dependentAge = dependentAge;
	}

	/**
	 * Return the value associated with the column: maritial_status
	 */
	public java.lang.String getMaritialStatus() {
		return maritialStatus;
	}

	/**
	 * Set the value related to the column: maritial_status
	 * 
	 * @param maritialStatus
	 *            the maritial_status value
	 */
	public void setMaritialStatus(java.lang.String maritialStatus) {
		this.maritialStatus = maritialStatus;
	}

	/**
	 * Return the value associated with the column: education_detail
	 */
	public java.lang.String getEducationDetail() {
		return educationDetail;
	}

	/**
	 * Set the value related to the column: education_detail
	 * 
	 * @param educationDetail
	 *            the education_detail value
	 */
	public void setEducationDetail(java.lang.String educationDetail) {
		this.educationDetail = educationDetail;
	}

	/**
	 * Return the value associated with the column: department_status
	 */
	public java.lang.String getDepartmentStatus() {
		return departmentStatus;
	}

	/**
	 * Set the value related to the column: department_status
	 * 
	 * @param departmentStatus
	 *            the department_status value
	 */
	public void setDepartmentStatus(java.lang.String departmentStatus) {
		this.departmentStatus = departmentStatus;
	}

	/**
	 * Return the value associated with the column: occupation
	 */
	public java.lang.String getOccupation() {
		return occupation;
	}

	/**
	 * Set the value related to the column: occupation
	 * 
	 * @param occupation
	 *            the occupation value
	 */
	public void setOccupation(java.lang.String occupation) {
		this.occupation = occupation;
	}

	/**
	 * Return the value associated with the column: eligibility
	 */
	public java.lang.Integer getEligibility() {
		return eligibility;
	}

	/**
	 * Set the value related to the column: eligibility
	 * 
	 * @param eligibility
	 *            the eligibility value
	 */
	public void setEligibility(java.lang.Integer eligibility) {
		this.eligibility = eligibility;
	}

	/**
	 * Return the value associated with the column: job_type
	 */
	public java.lang.String getJobType() {
		return jobType;
	}

	/**
	 * Set the value related to the column: job_type
	 * 
	 * @param jobType
	 *            the job_type value
	 */
	public void setJobType(java.lang.String jobType) {
		this.jobType = jobType;
	}

	/**
	 * Return the value associated with the column: employee_sequence_id
	 */
	public java.lang.Integer getEmployeeSequenceId() {
		return employeeSequenceId;
	}

	/**
	 * Set the value related to the column: employee_sequence_id
	 * 
	 * @param employeeSequenceId
	 *            the employee_sequence_id value
	 */
	public void setEmployeeSequenceId(java.lang.Integer employeeSequenceId) {
		this.employeeSequenceId = employeeSequenceId;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.EmployeeDependent))
			return false;
		else {
			jkt.hms.masters.business.EmployeeDependent employeeDependent = (jkt.hms.masters.business.EmployeeDependent) obj;
			if (null == this.getId() || null == employeeDependent.getId())
				return false;
			else
				return (this.getId().equals(employeeDependent.getId()));
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
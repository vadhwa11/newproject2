package jkt.hms.masters.business.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the employee_master table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 * 
 * @hibernate.class table="employee_master"
 */

public abstract class BaseEmployeeMaster implements Serializable {

	public static String REF = "EmployeeMaster";
	public static String PROP_ACCOUNT_HEAD = "AccountHead";
	public static String PROP_ROOM = "Room";
	public static String PROP_CONS_STAT = "ConsStat";
	public static String PROP_PERMANENT_STATE = "PermanentState";
	public static String PROP_PERMANENT_PHONE_NO = "PermanentPhoneNo";
	public static String PROP_GRADE = "Grade";
	public static String PROP_FIRST_NAME = "FirstName";
	public static String PROP_ACCOMODATION_TYPE = "AccomodationType";
	public static String PROP_APPOINTMENT_DATE = "AppointmentDate";
	public static String PROP_DIRECT_CODE = "DirectCode";
	public static String PROP_BLOOD_TYPE = "BloodType";
	public static String PROP_EMPLOYEE_CLASS = "EmployeeClass";
	public static String PROP_EMPLOYEE_SEQUENCE_ID = "EmployeeSequenceId";
	public static String PROP_CURRENT_ZIP_CODE = "CurrentZipCode";
	public static String PROP_TITLE_NAME = "TitleName";
	public static String PROP_BANK_ACCOUNT_CODE = "BankAccountCode";
	public static String PROP_EMPLOYEE_PHOTO = "EmployeePhoto";
	public static String PROP_BADGE_CODE = "BadgeCode";
	public static String PROP_TELEPHONE_NO_RESIDENCE = "TelephoneNoResidence";
	public static String PROP_EMPLOYEE_STATUS_ID = "EmployeeStatusId";
	public static String PROP_EMPLOYEE_CODE = "EmployeeCode";
	public static String PROP_EMPLOYEE_CATEGORY_ID = "EmployeeCategoryId";
	public static String PROP_NICK_NAME = "NickName";
	public static String PROP_JOIN_DATE = "JoinDate";
	public static String PROP_BANK_CODE = "BankCode";
	public static String PROP_LOC_CODE = "LocCode";
	public static String PROP_COMPANY_CODE = "CompanyCode";
	public static String PROP_AUTHORISER = "Authoriser";
	public static String PROP_CURRENT_STATE = "CurrentState";
	public static String PROP_STATUS_EFFECTIVE_FROM_DATE = "StatusEffectiveFromDate";
	public static String PROP_PHIC_NO = "PhicNo";
	public static String PROP_SELF_REFERENCE_CODE = "SelfReferenceCode";
	public static String PROP_PERMANENT_CITY = "PermanentCity";
	public static String PROP_MIDDLE_NAME = "MiddleName";
	public static String PROP_FLAGE_CLOTH_MAT = "FlageClothMat";
	public static String PROP_CURRENT_CITY = "CurrentCity";
	public static String PROP_SSS_NO = "SssNo";
	public static String PROP_COST_CODE = "CostCode";
	public static String PROP_DEPARTMENT_TYPE_ID = "DepartmentTypeId";
	public static String PROP_PF_ACCOUNT_CODE = "PfAccountCode";
	public static String PROP_PERMANENT_COUNTRY = "PermanentCountry";
	public static String PROP_STATUS_RMK = "StatusRmk";
	public static String PROP_CELL_NO_EMERGENCY = "CellNoEmergency";
	public static String PROP_CURRENT_ADDRESS = "CurrentAddress";
	public static String PROP_NAME_EMERGENCY = "NameEmergency";
	public static String PROP_CURRENT_COUNTRY = "CurrentCountry";
	public static String PROP_TELEPHONE_NO_EMERGENCY = "TelephoneNoEmergency";
	public static String PROP_DOC_SPEC = "DocSpec";
	public static String PROP_CUR_CODE = "CurCode";
	public static String PROP_PAY_REVISION = "PayRevision";
	public static String PROP_LAST_CHANGE_BY = "LastChangeBy";
	public static String PROP_APPLICATION_CODE = "ApplicationCode";
	public static String PROP_CURRENT_PHONE_NO = "CurrentPhoneNo";
	public static String PROP_TELEPHONE_NO_OFFICE = "TelephoneNoOffice";
	public static String PROP_GUEST = "Guest";
	public static String PROP_EXTENSION_NO_OFFICE = "ExtensionNoOffice";
	public static String PROP_PERMANENT_ADDRESS = "PermanentAddress";
	public static String PROP_LV_FLEXIBILITY = "LvFlexibility";
	public static String PROP_LAST_CHANGE_DATE_TIME = "LastChangeDateTime";
	public static String PROP_EMAIL = "Email";
	public static String PROP_DIVISION_ID = "DivisionId";
	public static String PROP_WEBSITE_URL = "WebsiteUrl";
	public static String PROP_JOB_ID = "JobId";
	public static String PROP_SECTION_CODE = "SectionCode";
	public static String PROP_PERMANENT_ZIP_CODE = "PermanentZipCode";
	public static String PROP_EMPLOYEE_TYPE = "EmployeeType";
	public static String PROP_ID = "Id";
	public static String PROP_LAST_NAME = "LastName";

	// constructors
	public BaseEmployeeMaster() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseEmployeeMaster(java.lang.Integer id) {
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
	private java.lang.Integer divisionId;
	private java.lang.String employeeCode;
	private java.lang.String badgeCode;
	private java.lang.String titleName;
	private java.lang.String firstName;
	private java.lang.String lastName;
	private java.lang.String middleName;
	private java.lang.String nickName;
	private java.lang.String employeePhoto;
	private java.lang.Integer jobId;
	private java.lang.String directCode;
	private java.lang.Integer departmentTypeId;
	private java.lang.String locCode;
	private java.lang.String selfReferenceCode;
	private java.util.Date appointmentDate;
	private java.lang.Integer employeeStatusId;
	private java.util.Date statusEffectiveFromDate;
	private java.lang.String statusRmk;
	private java.lang.String accomodationType;
	private java.lang.String nameEmergency;
	private java.lang.String telephoneNoEmergency;
	private java.lang.String cellNoEmergency;
	private java.lang.String telephoneNoResidence;
	private java.lang.String email;
	private java.lang.String websiteUrl;
	private java.lang.String telephoneNoOffice;
	private java.lang.String extensionNoOffice;
	private java.lang.String bankCode;
	private java.lang.String accountHead;
	private java.lang.String costCode;
	private java.lang.String flageClothMat;
	private java.lang.Integer payRevision;
	private java.lang.String curCode;
	private java.util.Date lastChangeDateTime;
	private java.lang.String grade;
	private java.util.Date joinDate;
	private java.lang.String bankAccountCode;
	private java.lang.String pfAccountCode;
	private java.lang.Integer employeeCategoryId;
	private java.lang.String permanentAddress;
	private java.lang.String permanentCity;
	private java.lang.String permanentState;
	private java.lang.String permanentCountry;
	private java.lang.String permanentZipCode;
	private java.lang.String permanentPhoneNo;
	private java.lang.String lastChangeBy;
	private java.lang.Integer employeeSequenceId;
	private java.lang.String currentAddress;
	private java.lang.String currentCity;
	private java.lang.String currentState;
	private java.lang.String currentCountry;
	private java.lang.String currentZipCode;
	private java.lang.String currentPhoneNo;
	private java.lang.String guest;
	private java.lang.String applicationCode;
	private java.lang.String room;
	private java.lang.String sectionCode;
	private java.lang.String phicNo;
	private java.lang.String sssNo;
	private java.lang.String bloodType;
	private java.lang.String employeeType;
	private java.lang.String consStat;
	private java.lang.String docSpec;
	private java.lang.String employeeClass;
	private java.lang.Integer authoriser;
	private java.lang.Integer lvFlexibility;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="native" column="employee_id"
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
	 * Return the value associated with the column: division_id
	 */
	public java.lang.Integer getDivisionId() {
		return divisionId;
	}

	/**
	 * Set the value related to the column: division_id
	 * 
	 * @param divisionId
	 *            the division_id value
	 */
	public void setDivisionId(java.lang.Integer divisionId) {
		this.divisionId = divisionId;
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
	 * Return the value associated with the column: badge_code
	 */
	public java.lang.String getBadgeCode() {
		return badgeCode;
	}

	/**
	 * Set the value related to the column: badge_code
	 * 
	 * @param badgeCode
	 *            the badge_code value
	 */
	public void setBadgeCode(java.lang.String badgeCode) {
		this.badgeCode = badgeCode;
	}

	/**
	 * Return the value associated with the column: title_name
	 */
	public java.lang.String getTitleName() {
		return titleName;
	}

	/**
	 * Set the value related to the column: title_name
	 * 
	 * @param titleName
	 *            the title_name value
	 */
	public void setTitleName(java.lang.String titleName) {
		this.titleName = titleName;
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
	 * Return the value associated with the column: nick_name
	 */
	public java.lang.String getNickName() {
		return nickName;
	}

	/**
	 * Set the value related to the column: nick_name
	 * 
	 * @param nickName
	 *            the nick_name value
	 */
	public void setNickName(java.lang.String nickName) {
		this.nickName = nickName;
	}

	/**
	 * Return the value associated with the column: employee_photo
	 */
	public java.lang.String getEmployeePhoto() {
		return employeePhoto;
	}

	/**
	 * Set the value related to the column: employee_photo
	 * 
	 * @param employeePhoto
	 *            the employee_photo value
	 */
	public void setEmployeePhoto(java.lang.String employeePhoto) {
		this.employeePhoto = employeePhoto;
	}

	/**
	 * Return the value associated with the column: job_id
	 */
	public java.lang.Integer getJobId() {
		return jobId;
	}

	/**
	 * Set the value related to the column: job_id
	 * 
	 * @param jobId
	 *            the job_id value
	 */
	public void setJobId(java.lang.Integer jobId) {
		this.jobId = jobId;
	}

	/**
	 * Return the value associated with the column: direct_code
	 */
	public java.lang.String getDirectCode() {
		return directCode;
	}

	/**
	 * Set the value related to the column: direct_code
	 * 
	 * @param directCode
	 *            the direct_code value
	 */
	public void setDirectCode(java.lang.String directCode) {
		this.directCode = directCode;
	}

	/**
	 * Return the value associated with the column: department_type_id
	 */
	public java.lang.Integer getDepartmentTypeId() {
		return departmentTypeId;
	}

	/**
	 * Set the value related to the column: department_type_id
	 * 
	 * @param departmentTypeId
	 *            the department_type_id value
	 */
	public void setDepartmentTypeId(java.lang.Integer departmentTypeId) {
		this.departmentTypeId = departmentTypeId;
	}

	/**
	 * Return the value associated with the column: loc_code
	 */
	public java.lang.String getLocCode() {
		return locCode;
	}

	/**
	 * Set the value related to the column: loc_code
	 * 
	 * @param locCode
	 *            the loc_code value
	 */
	public void setLocCode(java.lang.String locCode) {
		this.locCode = locCode;
	}

	/**
	 * Return the value associated with the column: self_reference_code
	 */
	public java.lang.String getSelfReferenceCode() {
		return selfReferenceCode;
	}

	/**
	 * Set the value related to the column: self_reference_code
	 * 
	 * @param selfReferenceCode
	 *            the self_reference_code value
	 */
	public void setSelfReferenceCode(java.lang.String selfReferenceCode) {
		this.selfReferenceCode = selfReferenceCode;
	}

	/**
	 * Return the value associated with the column: appointment_date
	 */
	public java.util.Date getAppointmentDate() {
		return appointmentDate;
	}

	/**
	 * Set the value related to the column: appointment_date
	 * 
	 * @param appointmentDate
	 *            the appointment_date value
	 */
	public void setAppointmentDate(java.util.Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	/**
	 * Return the value associated with the column: employee_status_id
	 */
	public java.lang.Integer getEmployeeStatusId() {
		return employeeStatusId;
	}

	/**
	 * Set the value related to the column: employee_status_id
	 * 
	 * @param employeeStatusId
	 *            the employee_status_id value
	 */
	public void setEmployeeStatusId(java.lang.Integer employeeStatusId) {
		this.employeeStatusId = employeeStatusId;
	}

	/**
	 * Return the value associated with the column: status_effective_from_date
	 */
	public java.util.Date getStatusEffectiveFromDate() {
		return statusEffectiveFromDate;
	}

	/**
	 * Set the value related to the column: status_effective_from_date
	 * 
	 * @param statusEffectiveFromDate
	 *            the status_effective_from_date value
	 */
	public void setStatusEffectiveFromDate(
			java.util.Date statusEffectiveFromDate) {
		this.statusEffectiveFromDate = statusEffectiveFromDate;
	}

	/**
	 * Return the value associated with the column: status_rmk
	 */
	public java.lang.String getStatusRmk() {
		return statusRmk;
	}

	/**
	 * Set the value related to the column: status_rmk
	 * 
	 * @param statusRmk
	 *            the status_rmk value
	 */
	public void setStatusRmk(java.lang.String statusRmk) {
		this.statusRmk = statusRmk;
	}

	/**
	 * Return the value associated with the column: accomodation_type
	 */
	public java.lang.String getAccomodationType() {
		return accomodationType;
	}

	/**
	 * Set the value related to the column: accomodation_type
	 * 
	 * @param accomodationType
	 *            the accomodation_type value
	 */
	public void setAccomodationType(java.lang.String accomodationType) {
		this.accomodationType = accomodationType;
	}

	/**
	 * Return the value associated with the column: name_emergency
	 */
	public java.lang.String getNameEmergency() {
		return nameEmergency;
	}

	/**
	 * Set the value related to the column: name_emergency
	 * 
	 * @param nameEmergency
	 *            the name_emergency value
	 */
	public void setNameEmergency(java.lang.String nameEmergency) {
		this.nameEmergency = nameEmergency;
	}

	/**
	 * Return the value associated with the column: telephone_no_emergency
	 */
	public java.lang.String getTelephoneNoEmergency() {
		return telephoneNoEmergency;
	}

	/**
	 * Set the value related to the column: telephone_no_emergency
	 * 
	 * @param telephoneNoEmergency
	 *            the telephone_no_emergency value
	 */
	public void setTelephoneNoEmergency(java.lang.String telephoneNoEmergency) {
		this.telephoneNoEmergency = telephoneNoEmergency;
	}

	/**
	 * Return the value associated with the column: cell_no_emergency
	 */
	public java.lang.String getCellNoEmergency() {
		return cellNoEmergency;
	}

	/**
	 * Set the value related to the column: cell_no_emergency
	 * 
	 * @param cellNoEmergency
	 *            the cell_no_emergency value
	 */
	public void setCellNoEmergency(java.lang.String cellNoEmergency) {
		this.cellNoEmergency = cellNoEmergency;
	}

	/**
	 * Return the value associated with the column: telephone_no_residence
	 */
	public java.lang.String getTelephoneNoResidence() {
		return telephoneNoResidence;
	}

	/**
	 * Set the value related to the column: telephone_no_residence
	 * 
	 * @param telephoneNoResidence
	 *            the telephone_no_residence value
	 */
	public void setTelephoneNoResidence(java.lang.String telephoneNoResidence) {
		this.telephoneNoResidence = telephoneNoResidence;
	}

	/**
	 * Return the value associated with the column: email
	 */
	public java.lang.String getEmail() {
		return email;
	}

	/**
	 * Set the value related to the column: email
	 * 
	 * @param email
	 *            the email value
	 */
	public void setEmail(java.lang.String email) {
		this.email = email;
	}

	/**
	 * Return the value associated with the column: website_url
	 */
	public java.lang.String getWebsiteUrl() {
		return websiteUrl;
	}

	/**
	 * Set the value related to the column: website_url
	 * 
	 * @param websiteUrl
	 *            the website_url value
	 */
	public void setWebsiteUrl(java.lang.String websiteUrl) {
		this.websiteUrl = websiteUrl;
	}

	/**
	 * Return the value associated with the column: telephone_no_office
	 */
	public java.lang.String getTelephoneNoOffice() {
		return telephoneNoOffice;
	}

	/**
	 * Set the value related to the column: telephone_no_office
	 * 
	 * @param telephoneNoOffice
	 *            the telephone_no_office value
	 */
	public void setTelephoneNoOffice(java.lang.String telephoneNoOffice) {
		this.telephoneNoOffice = telephoneNoOffice;
	}

	/**
	 * Return the value associated with the column: extension_no_office
	 */
	public java.lang.String getExtensionNoOffice() {
		return extensionNoOffice;
	}

	/**
	 * Set the value related to the column: extension_no_office
	 * 
	 * @param extensionNoOffice
	 *            the extension_no_office value
	 */
	public void setExtensionNoOffice(java.lang.String extensionNoOffice) {
		this.extensionNoOffice = extensionNoOffice;
	}

	/**
	 * Return the value associated with the column: bank_code
	 */
	public java.lang.String getBankCode() {
		return bankCode;
	}

	/**
	 * Set the value related to the column: bank_code
	 * 
	 * @param bankCode
	 *            the bank_code value
	 */
	public void setBankCode(java.lang.String bankCode) {
		this.bankCode = bankCode;
	}

	/**
	 * Return the value associated with the column: account_head
	 */
	public java.lang.String getAccountHead() {
		return accountHead;
	}

	/**
	 * Set the value related to the column: account_head
	 * 
	 * @param accountHead
	 *            the account_head value
	 */
	public void setAccountHead(java.lang.String accountHead) {
		this.accountHead = accountHead;
	}

	/**
	 * Return the value associated with the column: cost_code
	 */
	public java.lang.String getCostCode() {
		return costCode;
	}

	/**
	 * Set the value related to the column: cost_code
	 * 
	 * @param costCode
	 *            the cost_code value
	 */
	public void setCostCode(java.lang.String costCode) {
		this.costCode = costCode;
	}

	/**
	 * Return the value associated with the column: flage_cloth_mat
	 */
	public java.lang.String getFlageClothMat() {
		return flageClothMat;
	}

	/**
	 * Set the value related to the column: flage_cloth_mat
	 * 
	 * @param flageClothMat
	 *            the flage_cloth_mat value
	 */
	public void setFlageClothMat(java.lang.String flageClothMat) {
		this.flageClothMat = flageClothMat;
	}

	/**
	 * Return the value associated with the column: pay_revision
	 */
	public java.lang.Integer getPayRevision() {
		return payRevision;
	}

	/**
	 * Set the value related to the column: pay_revision
	 * 
	 * @param payRevision
	 *            the pay_revision value
	 */
	public void setPayRevision(java.lang.Integer payRevision) {
		this.payRevision = payRevision;
	}

	/**
	 * Return the value associated with the column: cur_code
	 */
	public java.lang.String getCurCode() {
		return curCode;
	}

	/**
	 * Set the value related to the column: cur_code
	 * 
	 * @param curCode
	 *            the cur_code value
	 */
	public void setCurCode(java.lang.String curCode) {
		this.curCode = curCode;
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
	 * Return the value associated with the column: grade
	 */
	public java.lang.String getGrade() {
		return grade;
	}

	/**
	 * Set the value related to the column: grade
	 * 
	 * @param grade
	 *            the grade value
	 */
	public void setGrade(java.lang.String grade) {
		this.grade = grade;
	}

	/**
	 * Return the value associated with the column: join_date
	 */
	public java.util.Date getJoinDate() {
		return joinDate;
	}

	/**
	 * Set the value related to the column: join_date
	 * 
	 * @param joinDate
	 *            the join_date value
	 */
	public void setJoinDate(java.util.Date joinDate) {
		this.joinDate = joinDate;
	}

	/**
	 * Return the value associated with the column: bank_account_code
	 */
	public java.lang.String getBankAccountCode() {
		return bankAccountCode;
	}

	/**
	 * Set the value related to the column: bank_account_code
	 * 
	 * @param bankAccountCode
	 *            the bank_account_code value
	 */
	public void setBankAccountCode(java.lang.String bankAccountCode) {
		this.bankAccountCode = bankAccountCode;
	}

	/**
	 * Return the value associated with the column: pf_account_code
	 */
	public java.lang.String getPfAccountCode() {
		return pfAccountCode;
	}

	/**
	 * Set the value related to the column: pf_account_code
	 * 
	 * @param pfAccountCode
	 *            the pf_account_code value
	 */
	public void setPfAccountCode(java.lang.String pfAccountCode) {
		this.pfAccountCode = pfAccountCode;
	}

	/**
	 * Return the value associated with the column: employee_category_id
	 */
	public java.lang.Integer getEmployeeCategoryId() {
		return employeeCategoryId;
	}

	/**
	 * Set the value related to the column: employee_category_id
	 * 
	 * @param employeeCategoryId
	 *            the employee_category_id value
	 */
	public void setEmployeeCategoryId(java.lang.Integer employeeCategoryId) {
		this.employeeCategoryId = employeeCategoryId;
	}

	/**
	 * Return the value associated with the column: permanent_address
	 */
	public java.lang.String getPermanentAddress() {
		return permanentAddress;
	}

	/**
	 * Set the value related to the column: permanent_address
	 * 
	 * @param permanentAddress
	 *            the permanent_address value
	 */
	public void setPermanentAddress(java.lang.String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	/**
	 * Return the value associated with the column: permanent_city
	 */
	public java.lang.String getPermanentCity() {
		return permanentCity;
	}

	/**
	 * Set the value related to the column: permanent_city
	 * 
	 * @param permanentCity
	 *            the permanent_city value
	 */
	public void setPermanentCity(java.lang.String permanentCity) {
		this.permanentCity = permanentCity;
	}

	/**
	 * Return the value associated with the column: permanent_state
	 */
	public java.lang.String getPermanentState() {
		return permanentState;
	}

	/**
	 * Set the value related to the column: permanent_state
	 * 
	 * @param permanentState
	 *            the permanent_state value
	 */
	public void setPermanentState(java.lang.String permanentState) {
		this.permanentState = permanentState;
	}

	/**
	 * Return the value associated with the column: permanent_country
	 */
	public java.lang.String getPermanentCountry() {
		return permanentCountry;
	}

	/**
	 * Set the value related to the column: permanent_country
	 * 
	 * @param permanentCountry
	 *            the permanent_country value
	 */
	public void setPermanentCountry(java.lang.String permanentCountry) {
		this.permanentCountry = permanentCountry;
	}

	/**
	 * Return the value associated with the column: permanent_zip_code
	 */
	public java.lang.String getPermanentZipCode() {
		return permanentZipCode;
	}

	/**
	 * Set the value related to the column: permanent_zip_code
	 * 
	 * @param permanentZipCode
	 *            the permanent_zip_code value
	 */
	public void setPermanentZipCode(java.lang.String permanentZipCode) {
		this.permanentZipCode = permanentZipCode;
	}

	/**
	 * Return the value associated with the column: permanent_phone_no
	 */
	public java.lang.String getPermanentPhoneNo() {
		return permanentPhoneNo;
	}

	/**
	 * Set the value related to the column: permanent_phone_no
	 * 
	 * @param permanentPhoneNo
	 *            the permanent_phone_no value
	 */
	public void setPermanentPhoneNo(java.lang.String permanentPhoneNo) {
		this.permanentPhoneNo = permanentPhoneNo;
	}

	/**
	 * Return the value associated with the column: last_change_by
	 */
	public java.lang.String getLastChangeBy() {
		return lastChangeBy;
	}

	/**
	 * Set the value related to the column: last_change_by
	 * 
	 * @param lastChangeBy
	 *            the last_change_by value
	 */
	public void setLastChangeBy(java.lang.String lastChangeBy) {
		this.lastChangeBy = lastChangeBy;
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

	/**
	 * Return the value associated with the column: current_address
	 */
	public java.lang.String getCurrentAddress() {
		return currentAddress;
	}

	/**
	 * Set the value related to the column: current_address
	 * 
	 * @param currentAddress
	 *            the current_address value
	 */
	public void setCurrentAddress(java.lang.String currentAddress) {
		this.currentAddress = currentAddress;
	}

	/**
	 * Return the value associated with the column: current_city
	 */
	public java.lang.String getCurrentCity() {
		return currentCity;
	}

	/**
	 * Set the value related to the column: current_city
	 * 
	 * @param currentCity
	 *            the current_city value
	 */
	public void setCurrentCity(java.lang.String currentCity) {
		this.currentCity = currentCity;
	}

	/**
	 * Return the value associated with the column: current_state
	 */
	public java.lang.String getCurrentState() {
		return currentState;
	}

	/**
	 * Set the value related to the column: current_state
	 * 
	 * @param currentState
	 *            the current_state value
	 */
	public void setCurrentState(java.lang.String currentState) {
		this.currentState = currentState;
	}

	/**
	 * Return the value associated with the column: current_country
	 */
	public java.lang.String getCurrentCountry() {
		return currentCountry;
	}

	/**
	 * Set the value related to the column: current_country
	 * 
	 * @param currentCountry
	 *            the current_country value
	 */
	public void setCurrentCountry(java.lang.String currentCountry) {
		this.currentCountry = currentCountry;
	}

	/**
	 * Return the value associated with the column: current_zip_code
	 */
	public java.lang.String getCurrentZipCode() {
		return currentZipCode;
	}

	/**
	 * Set the value related to the column: current_zip_code
	 * 
	 * @param currentZipCode
	 *            the current_zip_code value
	 */
	public void setCurrentZipCode(java.lang.String currentZipCode) {
		this.currentZipCode = currentZipCode;
	}

	/**
	 * Return the value associated with the column: current_phone_no
	 */
	public java.lang.String getCurrentPhoneNo() {
		return currentPhoneNo;
	}

	/**
	 * Set the value related to the column: current_phone_no
	 * 
	 * @param currentPhoneNo
	 *            the current_phone_no value
	 */
	public void setCurrentPhoneNo(java.lang.String currentPhoneNo) {
		this.currentPhoneNo = currentPhoneNo;
	}

	/**
	 * Return the value associated with the column: guest
	 */
	public java.lang.String getGuest() {
		return guest;
	}

	/**
	 * Set the value related to the column: guest
	 * 
	 * @param guest
	 *            the guest value
	 */
	public void setGuest(java.lang.String guest) {
		this.guest = guest;
	}

	/**
	 * Return the value associated with the column: application_code
	 */
	public java.lang.String getApplicationCode() {
		return applicationCode;
	}

	/**
	 * Set the value related to the column: application_code
	 * 
	 * @param applicationCode
	 *            the application_code value
	 */
	public void setApplicationCode(java.lang.String applicationCode) {
		this.applicationCode = applicationCode;
	}

	/**
	 * Return the value associated with the column: room
	 */
	public java.lang.String getRoom() {
		return room;
	}

	/**
	 * Set the value related to the column: room
	 * 
	 * @param room
	 *            the room value
	 */
	public void setRoom(java.lang.String room) {
		this.room = room;
	}

	/**
	 * Return the value associated with the column: section_code
	 */
	public java.lang.String getSectionCode() {
		return sectionCode;
	}

	/**
	 * Set the value related to the column: section_code
	 * 
	 * @param sectionCode
	 *            the section_code value
	 */
	public void setSectionCode(java.lang.String sectionCode) {
		this.sectionCode = sectionCode;
	}

	/**
	 * Return the value associated with the column: phic_no
	 */
	public java.lang.String getPhicNo() {
		return phicNo;
	}

	/**
	 * Set the value related to the column: phic_no
	 * 
	 * @param phicNo
	 *            the phic_no value
	 */
	public void setPhicNo(java.lang.String phicNo) {
		this.phicNo = phicNo;
	}

	/**
	 * Return the value associated with the column: sss_no
	 */
	public java.lang.String getSssNo() {
		return sssNo;
	}

	/**
	 * Set the value related to the column: sss_no
	 * 
	 * @param sssNo
	 *            the sss_no value
	 */
	public void setSssNo(java.lang.String sssNo) {
		this.sssNo = sssNo;
	}

	/**
	 * Return the value associated with the column: blood_type
	 */
	public java.lang.String getBloodType() {
		return bloodType;
	}

	/**
	 * Set the value related to the column: blood_type
	 * 
	 * @param bloodType
	 *            the blood_type value
	 */
	public void setBloodType(java.lang.String bloodType) {
		this.bloodType = bloodType;
	}

	/**
	 * Return the value associated with the column: employee_type
	 */
	public java.lang.String getEmployeeType() {
		return employeeType;
	}

	/**
	 * Set the value related to the column: employee_type
	 * 
	 * @param employeeType
	 *            the employee_type value
	 */
	public void setEmployeeType(java.lang.String employeeType) {
		this.employeeType = employeeType;
	}

	/**
	 * Return the value associated with the column: cons_stat
	 */
	public java.lang.String getConsStat() {
		return consStat;
	}

	/**
	 * Set the value related to the column: cons_stat
	 * 
	 * @param consStat
	 *            the cons_stat value
	 */
	public void setConsStat(java.lang.String consStat) {
		this.consStat = consStat;
	}

	/**
	 * Return the value associated with the column: doc_spec
	 */
	public java.lang.String getDocSpec() {
		return docSpec;
	}

	/**
	 * Set the value related to the column: doc_spec
	 * 
	 * @param docSpec
	 *            the doc_spec value
	 */
	public void setDocSpec(java.lang.String docSpec) {
		this.docSpec = docSpec;
	}

	/**
	 * Return the value associated with the column: employee_class
	 */
	public java.lang.String getEmployeeClass() {
		return employeeClass;
	}

	/**
	 * Set the value related to the column: employee_class
	 * 
	 * @param employeeClass
	 *            the employee_class value
	 */
	public void setEmployeeClass(java.lang.String employeeClass) {
		this.employeeClass = employeeClass;
	}

	/**
	 * Return the value associated with the column: authoriser
	 */
	public java.lang.Integer getAuthoriser() {
		return authoriser;
	}

	/**
	 * Set the value related to the column: authoriser
	 * 
	 * @param authoriser
	 *            the authoriser value
	 */
	public void setAuthoriser(java.lang.Integer authoriser) {
		this.authoriser = authoriser;
	}

	/**
	 * Return the value associated with the column: lv_flexibility
	 */
	public java.lang.Integer getLvFlexibility() {
		return lvFlexibility;
	}

	/**
	 * Set the value related to the column: lv_flexibility
	 * 
	 * @param lvFlexibility
	 *            the lv_flexibility value
	 */
	public void setLvFlexibility(java.lang.Integer lvFlexibility) {
		this.lvFlexibility = lvFlexibility;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof jkt.hms.masters.business.EmployeeMaster))
			return false;
		else {
			jkt.hms.masters.business.EmployeeMaster employeeMaster = (jkt.hms.masters.business.EmployeeMaster) obj;
			if (null == this.getId() || null == employeeMaster.getId())
				return false;
			else
				return (this.getId().equals(employeeMaster.getId()));
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
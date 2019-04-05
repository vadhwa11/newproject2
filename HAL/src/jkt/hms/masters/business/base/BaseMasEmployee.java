package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_employee table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_employee"
 */

public abstract class BaseMasEmployee  implements Serializable {

	public static String REF = "MasEmployee";
	public static String PROP_TRADE = "Trade";
	public static String PROP_COMMUNICATION = "Communication";
	public static String PROP_MONEY_DRAWN_FROM = "MoneyDrawnFrom";
	public static String PROP_LAST_NAME = "LastName";
	public static String PROP_BANK_NAME = "BankName";
	public static String PROP_EMPLOYEE_PHOTO = "EmployeePhoto";
	public static String PROP_PER_STATE = "PerState";
	public static String PROP_BANK_ACCOUNT_CODE = "BankAccountCode";
	public static String PROP_URL = "Url";
	public static String PROP_CLASSIFICATION = "Classification";
	public static String PROP_EMPLOYEE_STATUS = "EmployeeStatus";
	public static String PROP_CONTRACT_DATE = "ContractDate";
	public static String PROP_LOCAL_DISTRICT = "LocalDistrict";
	public static String PROP_RATION_DRAWN_FROM = "RationDrawnFrom";
	public static String PROP_RANK_CATEGORY = "RankCategory";
	public static String PROP_ACCOUNT_NO = "AccountNo";
	public static String PROP_P_F_NO = "PFNo";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_LIVING_IN_OUT = "LivingInOut";
	public static String PROP_TORS = "Tors";
	public static String PROP_LOCAL_STATE = "LocalState";
	public static String PROP_EMP_CATEGORY = "EmpCategory";
	public static String PROP_DATE_OF_BIRTH = "DateOfBirth";
	public static String PROP_BANK_ACCOUNT_NUMBER = "BankAccountNumber";
	public static String PROP_P_A_N_NO = "PANNo";
	public static String PROP_EMAIL = "Email";
	public static String PROP_COST_CENTER = "CostCenter";
	public static String PROP_ARRIVAL_COMPLETED = "ArrivalCompleted";
	public static String PROP_AADHAR_CARD = "AadharCard";
	public static String PROP_HAL_JOIN_DATE = "HalJoinDate";
	public static String PROP_DESIGNATION = "Designation";
	public static String PROP_TEL_NO_RESIDENCE = "TelNoResidence";
	public static String PROP_LOCAL_ADDRESS = "LocalAddress";
	public static String PROP_EMPLOYEE_TYPE = "EmployeeType";
	public static String PROP_AUTHORIZED_FOR_HIGH_VALUE_MEDICINE = "AuthorizedForHighValueMedicine";
	public static String PROP_PASSWORD = "Password";
	public static String PROP_REMARKS = "Remarks";
	public static String PROP_ARRIVAL_REPORT = "ArrivalReport";
	public static String PROP_JOB_CODE = "JobCode";
	public static String PROP_EXTENSION_DATE = "ExtensionDate";
	public static String PROP_UNIT = "Unit";
	public static String PROP_LIVING_IN_DATE = "LivingInDate";
	public static String PROP_FIRST_NAME = "FirstName";
	public static String PROP_PER_COUNTRY = "PerCountry";
	public static String PROP_CURRENT_DIVISION_JOIN_DATE = "CurrentDivisionJoinDate";
	public static String PROP_POSTED_UNIT = "PostedUnit";
	public static String PROP_TITLE = "Title";
	public static String PROP_MIDDLE_NAME = "MiddleName";
	public static String PROP_RANK = "Rank";
	public static String PROP_VIDE = "Vide";
	public static String PROP_ROOM_NO = "RoomNo";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_SERVICE_TYPE = "ServiceType";
	public static String PROP_TEL_NO_EMERGENCY = "TelNoEmergency";
	public static String PROP_DUTY_EXEMPTION_TO = "DutyExemptionTo";
	public static String PROP_DISCIPLINE_REMARKS = "DisciplineRemarks";
	public static String PROP_POR_SL_NO = "PorSlNo";
	public static String PROP_ON_PRC = "OnPrc";
	public static String PROP_JOIN_DATE = "JoinDate";
	public static String PROP_SUFFIX = "Suffix";
	public static String PROP_ACCOUNT_HEAD = "AccountHead";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_PREFIX = "Prefix";
	public static String PROP_LOCAL_COUNTRY = "LocalCountry";
	public static String PROP_EMPLOYEE_CODE = "EmployeeCode";
	public static String PROP_BLOOD_GROUP = "BloodGroup";
	public static String PROP_GENDER = "Gender";
	public static String PROP_POSTED_DATE = "PostedDate";
	public static String PROP_ID = "Id";
	public static String PROP_MOVEMENT_IN_STATUS = "MovementInStatus";
	public static String PROP_LIVING_OUT_DATE = "LivingOutDate";
	public static String PROP_AGE = "Age";
	public static String PROP_PER_DISTRICT = "PerDistrict";
	public static String PROP_MESS = "Mess";
	public static String PROP_RATION_MONEY_DRAWN = "RationMoneyDrawn";
	public static String PROP_MOVEMENT_OUT_STATUS = "MovementOutStatus";
	public static String PROP_TEL_NO_OFFICE = "TelNoOffice";
	public static String PROP_LOCAL_UNIT = "LocalUnit";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_DUTY_EXEMPTION_FROM = "DutyExemptionFrom";
	public static String PROP_GRADE = "Grade";
	public static String PROP_BANK_CODE = "BankCode";
	public static String PROP_MARITAL_STATUS = "MaritalStatus";
	public static String PROP_POSTED_OUT = "PostedOut";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_DATE_OF_MARRIAGE = "DateOfMarriage";
	public static String PROP_DEPENDENT_UNIT = "DependentUnit";
	public static String PROP_PER_ADDRESS = "PerAddress";
	public static String PROP_SERVICE_NO = "ServiceNo";
	public static String PROP_APPOINTMENT_DATE = "AppointmentDate";
	public static String PROP_LEAVE_CHOICE1 = "LeaveChoice1";
	public static String PROP_SPECIALITY = "Speciality";
	public static String PROP_LEAVE_CHOICE2 = "LeaveChoice2";
	public static String PROP_DEPARTMENT_NO = "DepartmentNo";
	public static String PROP_DISCIPLINE_PENDING = "DisciplinePending";
	public static String PROP_STATUS = "Status";
	public static String PROP_CONSULTATION_ROOM = "ConsultationRoom";
	public static String PROP_DIVISION = "Division";
	public static String PROP_CELL_NO_EMERGENCY = "CellNoEmergency";
	public static String PROP_EPH_ISN = "EphIsn";


	// constructors
	public BaseMasEmployee () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasEmployee (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String password;
	private java.util.Date arrivalCompleted;
	private java.lang.String employeeCode;
	private java.lang.String firstName;
	private java.lang.String lastName;
	private java.lang.String middleName;
	private java.lang.String employeePhoto;
	private java.lang.String jobCode;
	private java.util.Date appointmentDate;
	private java.lang.String telNoEmergency;
	private java.lang.String cellNoEmergency;
	private java.lang.String telNoResidence;
	private java.lang.String email;
	private java.lang.String url;
	private java.lang.String telNoOffice;
	private java.lang.String bankCode;
	private java.lang.String accountHead;
	private java.util.Date joinDate;
	private java.lang.String bankAccountCode;
	private java.lang.String status;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String bankAccountNumber;
	private java.lang.String serviceNo;
	private java.lang.String consultationRoom;
	private java.lang.String designation;
	private java.lang.String leaveChoice1;
	private java.lang.String leaveChoice2;
	private java.lang.String vide;
	private java.util.Date postedDate;
	private java.util.Date tors;
	private java.lang.String porSlNo;
	private java.lang.String livingInOut;
	private java.util.Date livingInDate;
	private java.util.Date livingOutDate;
	private java.lang.String rationMoneyDrawn;
	private java.util.Date rationDrawnFrom;
	private java.util.Date moneyDrawnFrom;
	private java.lang.String onPrc;
	private java.lang.String arrivalReport;
	private java.util.Date dutyExemptionFrom;
	private java.util.Date dutyExemptionTo;
	private java.lang.String disciplinePending;
	private java.lang.String disciplineRemarks;
	private java.lang.String movementInStatus;
	private java.lang.String movementOutStatus;
	private java.lang.String suffix;
	private java.lang.String prefix;
	private java.util.Date dateOfBirth;
	private java.util.Date dateOfMarriage;
	private java.lang.String localAddress;
	private java.lang.Integer roomNo;
	private java.lang.String age;
	private java.lang.String aadharCard;
	private java.lang.String departmentNo;
	private java.lang.String perAddress;
	private java.util.Date halJoinDate;
	private java.util.Date currentDivisionJoinDate;
	private java.lang.String authorizedForHighValueMedicine;
	private java.lang.String communication;
	private java.lang.String remarks;
	private java.util.Date contractDate;
	private java.util.Date extensionDate;
	private java.lang.Integer ephIsn;
	private java.lang.String pFNo;
	private java.lang.String pANNo;
	private java.lang.String accountNo;
	private java.lang.String bankName;

	// many to one
	private jkt.hms.masters.business.MasServiceType serviceType;
	private jkt.hms.masters.business.MasUnit postedUnit;
	private jkt.hms.masters.business.MasRank rank;
	private jkt.hms.masters.business.HrSpecialistMaster speciality;
	private jkt.hms.masters.business.MasCountry perCountry;
	private jkt.hms.masters.business.MasDistrict localDistrict;
	private jkt.hms.masters.business.MasTrade trade;
	private jkt.hms.masters.business.MasRankCategory rankCategory;
	private jkt.hms.masters.business.MasGrade grade;
	private jkt.hms.masters.business.MasDistrict perDistrict;
	private jkt.hms.masters.business.HrorderlyClassificationMaster classification;
	private jkt.hms.masters.business.MasUnit unit;
	private jkt.hms.masters.business.MasBloodGroup bloodGroup;
	private jkt.hms.masters.business.MasEmpCategory empCategory;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasCostCenter costCenter;
	private jkt.hms.masters.business.HrorderlyMessMaster mess;
	private jkt.hms.masters.business.MasTitle title;
	private jkt.hms.masters.business.MasDivision division;
	private jkt.hms.masters.business.MasAdministrativeSex gender;
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasUnit localUnit;
	private jkt.hms.masters.business.MasState localState;
	private jkt.hms.masters.business.MasState perState;
	private jkt.hms.masters.business.MasEmployeeType employeeType;
	private jkt.hms.masters.business.MasCountry localCountry;
	private jkt.hms.masters.business.MasUnit dependentUnit;
	private jkt.hms.masters.business.MasEmpStatus employeeStatus;
	private jkt.hms.masters.business.PostedOutEntry postedOut;
	private jkt.hms.masters.business.MasMaritalStatus maritalStatus;

	// collections
	private java.util.Set<jkt.hms.masters.business.Discharge> discharges;
	private java.util.Set<jkt.hms.masters.business.StoreBoo> storeBoosByOfficerIc;
	private java.util.Set<jkt.hms.masters.business.StoreBoo> storeBoosByPresidingOff;
	private java.util.Set<jkt.hms.masters.business.StoreBoo> storeBoosByCommand;
	private java.util.Set<jkt.hms.masters.business.MlcCase> mlcCases;
	private java.util.Set<jkt.hms.masters.business.StoreBalanceM> storeBalanceMs;
	private java.util.Set<jkt.hms.masters.business.Birthdeathreg> birthdeathregs;
	private java.util.Set<jkt.hms.masters.business.StoreGrnReturnM> storeGrnReturnMsByApprovedBy;
	private java.util.Set<jkt.hms.masters.business.StoreGrnReturnM> storeGrnReturnMsByReturnBy;
	private java.util.Set<jkt.hms.masters.business.StoreIssueM> storeIssueMsByApprovedBy;
	private java.util.Set<jkt.hms.masters.business.StoreIssueM> storeIssueMsByIssuedBy;
	private java.util.Set<jkt.hms.masters.business.StoreIssueM> storeIssueMsByRequestBy;
	private java.util.Set<jkt.hms.masters.business.Users> users;
	private java.util.Set<jkt.hms.masters.business.MasDiscount> masDiscounts;
	private java.util.Set<jkt.hms.masters.business.StoreMmfDepartmentM> storeMmfDepartmentMs;
	private java.util.Set<jkt.hms.masters.business.MasEmployeeDependent> masEmployeeDependents;
	private java.util.Set<jkt.hms.masters.business.StoreBooMember> storeBooMembers;
	private java.util.Set<jkt.hms.masters.business.StoreInternalReturnM> storeInternalReturnMsByReturnBy;
	private java.util.Set<jkt.hms.masters.business.StoreInternalReturnM> storeInternalReturnMsByReceivedBy;
	private java.util.Set<jkt.hms.masters.business.EmpAfmsfDet> empAfmsfDets;
	private java.util.Set<jkt.hms.masters.business.StoreTenderLocalPurchaseM> storeTenderLocalPurchaseMs;
	private java.util.Set<jkt.hms.masters.business.StoreTenderCommHodRecom> storeTenderCommHodRecoms;
	private java.util.Set<jkt.hms.masters.business.StoreOpPatientIssueM> storeOpPatientIssueMs;
	private java.util.Set<jkt.hms.masters.business.DgOrderhd> dgOrderhds;
	private java.util.Set<jkt.hms.masters.business.StoreSetup> storeSetups;
	private java.util.Set<jkt.hms.masters.business.StoreGrnM> storeGrnMs;
	private java.util.Set<jkt.hms.masters.business.StoreIssueT> storeIssueTs;
	private java.util.Set<jkt.hms.masters.business.StoreInternalIndentM> storeInternalIndentMsByApprovedBy;
	private java.util.Set<jkt.hms.masters.business.StoreInternalIndentM> storeInternalIndentMsByRequestedBy;
	private java.util.Set<jkt.hms.masters.business.Inpatient> inpatients;
	private java.util.Set<jkt.hms.masters.business.Visit> visits;
	private java.util.Set<jkt.hms.masters.business.StoreLoaninM> storeLoaninMs;
	private java.util.Set<jkt.hms.masters.business.Transfer> transfers;
	private java.util.Set<jkt.hms.masters.business.SilDilStatus> silDilStatus;
	private java.util.Set<jkt.hms.masters.business.MasEmployeeDepartment> masEmployeeDepartments;
	private java.util.Set<jkt.hms.masters.business.HrEmployeePayStructure> payStructure;
	private java.util.Set<jkt.hms.masters.business.HrEmployeePayElements> payElements;
	private java.util.Set<jkt.hms.masters.business.HrItaxCalculate> itaxCalculate;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="employee_id"
     */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: password
	 */
	public java.lang.String getPassword () {
		return password;
	}

	/**
	 * Set the value related to the column: password
	 * @param password the password value
	 */
	public void setPassword (java.lang.String password) {
		this.password = password;
	}



	/**
	 * Return the value associated with the column: arrival_completed
	 */
	public java.util.Date getArrivalCompleted () {
		return arrivalCompleted;
	}

	/**
	 * Set the value related to the column: arrival_completed
	 * @param arrivalCompleted the arrival_completed value
	 */
	public void setArrivalCompleted (java.util.Date arrivalCompleted) {
		this.arrivalCompleted = arrivalCompleted;
	}



	/**
	 * Return the value associated with the column: employee_code
	 */
	public java.lang.String getEmployeeCode () {
		return employeeCode;
	}

	/**
	 * Set the value related to the column: employee_code
	 * @param employeeCode the employee_code value
	 */
	public void setEmployeeCode (java.lang.String employeeCode) {
		this.employeeCode = employeeCode;
	}



	/**
	 * Return the value associated with the column: first_name
	 */
	public java.lang.String getFirstName () {
		return firstName;
	}

	/**
	 * Set the value related to the column: first_name
	 * @param firstName the first_name value
	 */
	public void setFirstName (java.lang.String firstName) {
		this.firstName = firstName;
	}



	/**
	 * Return the value associated with the column: last_name
	 */
	public java.lang.String getLastName () {
		return lastName;
	}

	/**
	 * Set the value related to the column: last_name
	 * @param lastName the last_name value
	 */
	public void setLastName (java.lang.String lastName) {
		this.lastName = lastName;
	}



	/**
	 * Return the value associated with the column: middle_name
	 */
	public java.lang.String getMiddleName () {
		return middleName;
	}

	/**
	 * Set the value related to the column: middle_name
	 * @param middleName the middle_name value
	 */
	public void setMiddleName (java.lang.String middleName) {
		this.middleName = middleName;
	}



	/**
	 * Return the value associated with the column: employee_photo
	 */
	public java.lang.String getEmployeePhoto () {
		return employeePhoto;
	}

	/**
	 * Set the value related to the column: employee_photo
	 * @param employeePhoto the employee_photo value
	 */
	public void setEmployeePhoto (java.lang.String employeePhoto) {
		this.employeePhoto = employeePhoto;
	}



	/**
	 * Return the value associated with the column: job_code
	 */
	public java.lang.String getJobCode () {
		return jobCode;
	}

	/**
	 * Set the value related to the column: job_code
	 * @param jobCode the job_code value
	 */
	public void setJobCode (java.lang.String jobCode) {
		this.jobCode = jobCode;
	}



	/**
	 * Return the value associated with the column: appointment_date
	 */
	public java.util.Date getAppointmentDate () {
		return appointmentDate;
	}

	/**
	 * Set the value related to the column: appointment_date
	 * @param appointmentDate the appointment_date value
	 */
	public void setAppointmentDate (java.util.Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}



	/**
	 * Return the value associated with the column: tel_no_emergency
	 */
	public java.lang.String getTelNoEmergency () {
		return telNoEmergency;
	}

	/**
	 * Set the value related to the column: tel_no_emergency
	 * @param telNoEmergency the tel_no_emergency value
	 */
	public void setTelNoEmergency (java.lang.String telNoEmergency) {
		this.telNoEmergency = telNoEmergency;
	}



	/**
	 * Return the value associated with the column: cell_no_emergency
	 */
	public java.lang.String getCellNoEmergency () {
		return cellNoEmergency;
	}

	/**
	 * Set the value related to the column: cell_no_emergency
	 * @param cellNoEmergency the cell_no_emergency value
	 */
	public void setCellNoEmergency (java.lang.String cellNoEmergency) {
		this.cellNoEmergency = cellNoEmergency;
	}



	/**
	 * Return the value associated with the column: tel_no_residence
	 */
	public java.lang.String getTelNoResidence () {
		return telNoResidence;
	}

	/**
	 * Set the value related to the column: tel_no_residence
	 * @param telNoResidence the tel_no_residence value
	 */
	public void setTelNoResidence (java.lang.String telNoResidence) {
		this.telNoResidence = telNoResidence;
	}



	/**
	 * Return the value associated with the column: email
	 */
	public java.lang.String getEmail () {
		return email;
	}

	/**
	 * Set the value related to the column: email
	 * @param email the email value
	 */
	public void setEmail (java.lang.String email) {
		this.email = email;
	}



	/**
	 * Return the value associated with the column: url
	 */
	public java.lang.String getUrl () {
		return url;
	}

	/**
	 * Set the value related to the column: url
	 * @param url the url value
	 */
	public void setUrl (java.lang.String url) {
		this.url = url;
	}



	/**
	 * Return the value associated with the column: tel_no_office
	 */
	public java.lang.String getTelNoOffice () {
		return telNoOffice;
	}

	/**
	 * Set the value related to the column: tel_no_office
	 * @param telNoOffice the tel_no_office value
	 */
	public void setTelNoOffice (java.lang.String telNoOffice) {
		this.telNoOffice = telNoOffice;
	}



	/**
	 * Return the value associated with the column: bank_code
	 */
	public java.lang.String getBankCode () {
		return bankCode;
	}

	/**
	 * Set the value related to the column: bank_code
	 * @param bankCode the bank_code value
	 */
	public void setBankCode (java.lang.String bankCode) {
		this.bankCode = bankCode;
	}



	/**
	 * Return the value associated with the column: account_head
	 */
	public java.lang.String getAccountHead () {
		return accountHead;
	}

	/**
	 * Set the value related to the column: account_head
	 * @param accountHead the account_head value
	 */
	public void setAccountHead (java.lang.String accountHead) {
		this.accountHead = accountHead;
	}



	/**
	 * Return the value associated with the column: join_date
	 */
	public java.util.Date getJoinDate () {
		return joinDate;
	}

	/**
	 * Set the value related to the column: join_date
	 * @param joinDate the join_date value
	 */
	public void setJoinDate (java.util.Date joinDate) {
		this.joinDate = joinDate;
	}



	/**
	 * Return the value associated with the column: bank_account_code
	 */
	public java.lang.String getBankAccountCode () {
		return bankAccountCode;
	}

	/**
	 * Set the value related to the column: bank_account_code
	 * @param bankAccountCode the bank_account_code value
	 */
	public void setBankAccountCode (java.lang.String bankAccountCode) {
		this.bankAccountCode = bankAccountCode;
	}



	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * @param status the status value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
	}



	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public java.lang.String getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (java.lang.String lastChgBy) {
		this.lastChgBy = lastChgBy;
	}



	/**
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate () {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * @param lastChgDate the last_chg_date value
	 */
	public void setLastChgDate (java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}



	/**
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime () {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * @param lastChgTime the last_chg_time value
	 */
	public void setLastChgTime (java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}



	/**
	 * Return the value associated with the column: bank_account_number
	 */
	public java.lang.String getBankAccountNumber () {
		return bankAccountNumber;
	}

	/**
	 * Set the value related to the column: bank_account_number
	 * @param bankAccountNumber the bank_account_number value
	 */
	public void setBankAccountNumber (java.lang.String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}



	/**
	 * Return the value associated with the column: service_no
	 */
	public java.lang.String getServiceNo () {
		return serviceNo;
	}

	/**
	 * Set the value related to the column: service_no
	 * @param serviceNo the service_no value
	 */
	public void setServiceNo (java.lang.String serviceNo) {
		this.serviceNo = serviceNo;
	}



	/**
	 * Return the value associated with the column: consultation_room
	 */
	public java.lang.String getConsultationRoom () {
		return consultationRoom;
	}

	/**
	 * Set the value related to the column: consultation_room
	 * @param consultationRoom the consultation_room value
	 */
	public void setConsultationRoom (java.lang.String consultationRoom) {
		this.consultationRoom = consultationRoom;
	}



	/**
	 * Return the value associated with the column: designation
	 */
	public java.lang.String getDesignation () {
		return designation;
	}

	/**
	 * Set the value related to the column: designation
	 * @param designation the designation value
	 */
	public void setDesignation (java.lang.String designation) {
		this.designation = designation;
	}



	/**
	 * Return the value associated with the column: leave_choice1
	 */
	public java.lang.String getLeaveChoice1 () {
		return leaveChoice1;
	}

	/**
	 * Set the value related to the column: leave_choice1
	 * @param leaveChoice1 the leave_choice1 value
	 */
	public void setLeaveChoice1 (java.lang.String leaveChoice1) {
		this.leaveChoice1 = leaveChoice1;
	}



	/**
	 * Return the value associated with the column: leave_choice2
	 */
	public java.lang.String getLeaveChoice2 () {
		return leaveChoice2;
	}

	/**
	 * Set the value related to the column: leave_choice2
	 * @param leaveChoice2 the leave_choice2 value
	 */
	public void setLeaveChoice2 (java.lang.String leaveChoice2) {
		this.leaveChoice2 = leaveChoice2;
	}



	/**
	 * Return the value associated with the column: vide
	 */
	public java.lang.String getVide () {
		return vide;
	}

	/**
	 * Set the value related to the column: vide
	 * @param vide the vide value
	 */
	public void setVide (java.lang.String vide) {
		this.vide = vide;
	}



	/**
	 * Return the value associated with the column: postedDate
	 */
	public java.util.Date getPostedDate () {
		return postedDate;
	}

	/**
	 * Set the value related to the column: postedDate
	 * @param postedDate the postedDate value
	 */
	public void setPostedDate (java.util.Date postedDate) {
		this.postedDate = postedDate;
	}



	/**
	 * Return the value associated with the column: tors
	 */
	public java.util.Date getTors () {
		return tors;
	}

	/**
	 * Set the value related to the column: tors
	 * @param tors the tors value
	 */
	public void setTors (java.util.Date tors) {
		this.tors = tors;
	}



	/**
	 * Return the value associated with the column: porSlNo
	 */
	public java.lang.String getPorSlNo () {
		return porSlNo;
	}

	/**
	 * Set the value related to the column: porSlNo
	 * @param porSlNo the porSlNo value
	 */
	public void setPorSlNo (java.lang.String porSlNo) {
		this.porSlNo = porSlNo;
	}



	/**
	 * Return the value associated with the column: livingInOut
	 */
	public java.lang.String getLivingInOut () {
		return livingInOut;
	}

	/**
	 * Set the value related to the column: livingInOut
	 * @param livingInOut the livingInOut value
	 */
	public void setLivingInOut (java.lang.String livingInOut) {
		this.livingInOut = livingInOut;
	}



	/**
	 * Return the value associated with the column: living_in_date
	 */
	public java.util.Date getLivingInDate () {
		return livingInDate;
	}

	/**
	 * Set the value related to the column: living_in_date
	 * @param livingInDate the living_in_date value
	 */
	public void setLivingInDate (java.util.Date livingInDate) {
		this.livingInDate = livingInDate;
	}



	/**
	 * Return the value associated with the column: living_out_date
	 */
	public java.util.Date getLivingOutDate () {
		return livingOutDate;
	}

	/**
	 * Set the value related to the column: living_out_date
	 * @param livingOutDate the living_out_date value
	 */
	public void setLivingOutDate (java.util.Date livingOutDate) {
		this.livingOutDate = livingOutDate;
	}



	/**
	 * Return the value associated with the column: ration_money_drawn
	 */
	public java.lang.String getRationMoneyDrawn () {
		return rationMoneyDrawn;
	}

	/**
	 * Set the value related to the column: ration_money_drawn
	 * @param rationMoneyDrawn the ration_money_drawn value
	 */
	public void setRationMoneyDrawn (java.lang.String rationMoneyDrawn) {
		this.rationMoneyDrawn = rationMoneyDrawn;
	}



	/**
	 * Return the value associated with the column: ration_drawn_from
	 */
	public java.util.Date getRationDrawnFrom () {
		return rationDrawnFrom;
	}

	/**
	 * Set the value related to the column: ration_drawn_from
	 * @param rationDrawnFrom the ration_drawn_from value
	 */
	public void setRationDrawnFrom (java.util.Date rationDrawnFrom) {
		this.rationDrawnFrom = rationDrawnFrom;
	}



	/**
	 * Return the value associated with the column: money_drawn_from
	 */
	public java.util.Date getMoneyDrawnFrom () {
		return moneyDrawnFrom;
	}

	/**
	 * Set the value related to the column: money_drawn_from
	 * @param moneyDrawnFrom the money_drawn_from value
	 */
	public void setMoneyDrawnFrom (java.util.Date moneyDrawnFrom) {
		this.moneyDrawnFrom = moneyDrawnFrom;
	}



	/**
	 * Return the value associated with the column: on_prc
	 */
	public java.lang.String getOnPrc () {
		return onPrc;
	}

	/**
	 * Set the value related to the column: on_prc
	 * @param onPrc the on_prc value
	 */
	public void setOnPrc (java.lang.String onPrc) {
		this.onPrc = onPrc;
	}



	/**
	 * Return the value associated with the column: arrival_report
	 */
	public java.lang.String getArrivalReport () {
		return arrivalReport;
	}

	/**
	 * Set the value related to the column: arrival_report
	 * @param arrivalReport the arrival_report value
	 */
	public void setArrivalReport (java.lang.String arrivalReport) {
		this.arrivalReport = arrivalReport;
	}



	/**
	 * Return the value associated with the column: duty_exemption_from
	 */
	public java.util.Date getDutyExemptionFrom () {
		return dutyExemptionFrom;
	}

	/**
	 * Set the value related to the column: duty_exemption_from
	 * @param dutyExemptionFrom the duty_exemption_from value
	 */
	public void setDutyExemptionFrom (java.util.Date dutyExemptionFrom) {
		this.dutyExemptionFrom = dutyExemptionFrom;
	}



	/**
	 * Return the value associated with the column: duty_exemption_to
	 */
	public java.util.Date getDutyExemptionTo () {
		return dutyExemptionTo;
	}

	/**
	 * Set the value related to the column: duty_exemption_to
	 * @param dutyExemptionTo the duty_exemption_to value
	 */
	public void setDutyExemptionTo (java.util.Date dutyExemptionTo) {
		this.dutyExemptionTo = dutyExemptionTo;
	}



	/**
	 * Return the value associated with the column: discipline_pending
	 */
	public java.lang.String getDisciplinePending () {
		return disciplinePending;
	}

	/**
	 * Set the value related to the column: discipline_pending
	 * @param disciplinePending the discipline_pending value
	 */
	public void setDisciplinePending (java.lang.String disciplinePending) {
		this.disciplinePending = disciplinePending;
	}



	/**
	 * Return the value associated with the column: discipline_remarks
	 */
	public java.lang.String getDisciplineRemarks () {
		return disciplineRemarks;
	}

	/**
	 * Set the value related to the column: discipline_remarks
	 * @param disciplineRemarks the discipline_remarks value
	 */
	public void setDisciplineRemarks (java.lang.String disciplineRemarks) {
		this.disciplineRemarks = disciplineRemarks;
	}



	/**
	 * Return the value associated with the column: movement_in_status
	 */
	public java.lang.String getMovementInStatus () {
		return movementInStatus;
	}

	/**
	 * Set the value related to the column: movement_in_status
	 * @param movementInStatus the movement_in_status value
	 */
	public void setMovementInStatus (java.lang.String movementInStatus) {
		this.movementInStatus = movementInStatus;
	}



	/**
	 * Return the value associated with the column: movement_out_status
	 */
	public java.lang.String getMovementOutStatus () {
		return movementOutStatus;
	}

	/**
	 * Set the value related to the column: movement_out_status
	 * @param movementOutStatus the movement_out_status value
	 */
	public void setMovementOutStatus (java.lang.String movementOutStatus) {
		this.movementOutStatus = movementOutStatus;
	}



	/**
	 * Return the value associated with the column: suffix
	 */
	public java.lang.String getSuffix () {
		return suffix;
	}

	/**
	 * Set the value related to the column: suffix
	 * @param suffix the suffix value
	 */
	public void setSuffix (java.lang.String suffix) {
		this.suffix = suffix;
	}



	/**
	 * Return the value associated with the column: prefix
	 */
	public java.lang.String getPrefix () {
		return prefix;
	}

	/**
	 * Set the value related to the column: prefix
	 * @param prefix the prefix value
	 */
	public void setPrefix (java.lang.String prefix) {
		this.prefix = prefix;
	}



	/**
	 * Return the value associated with the column: date_of_birth
	 */
	public java.util.Date getDateOfBirth () {
		return dateOfBirth;
	}

	/**
	 * Set the value related to the column: date_of_birth
	 * @param dateOfBirth the date_of_birth value
	 */
	public void setDateOfBirth (java.util.Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}



	/**
	 * Return the value associated with the column: date_of_marriage
	 */
	public java.util.Date getDateOfMarriage () {
		return dateOfMarriage;
	}

	/**
	 * Set the value related to the column: date_of_marriage
	 * @param dateOfMarriage the date_of_marriage value
	 */
	public void setDateOfMarriage (java.util.Date dateOfMarriage) {
		this.dateOfMarriage = dateOfMarriage;
	}



	/**
	 * Return the value associated with the column: local_address
	 */
	public java.lang.String getLocalAddress () {
		return localAddress;
	}

	/**
	 * Set the value related to the column: local_address
	 * @param localAddress the local_address value
	 */
	public void setLocalAddress (java.lang.String localAddress) {
		this.localAddress = localAddress;
	}



	/**
	 * Return the value associated with the column: ROOM_NO
	 */
	public java.lang.Integer getRoomNo () {
		return roomNo;
	}

	/**
	 * Set the value related to the column: ROOM_NO
	 * @param roomNo the ROOM_NO value
	 */
	public void setRoomNo (java.lang.Integer roomNo) {
		this.roomNo = roomNo;
	}



	/**
	 * Return the value associated with the column: age
	 */
	public java.lang.String getAge () {
		return age;
	}

	/**
	 * Set the value related to the column: age
	 * @param age the age value
	 */
	public void setAge (java.lang.String age) {
		this.age = age;
	}



	/**
	 * Return the value associated with the column: aadhar_card
	 */
	public java.lang.String getAadharCard () {
		return aadharCard;
	}

	/**
	 * Set the value related to the column: aadhar_card
	 * @param aadharCard the aadhar_card value
	 */
	public void setAadharCard (java.lang.String aadharCard) {
		this.aadharCard = aadharCard;
	}



	/**
	 * Return the value associated with the column: department_no
	 */
	public java.lang.String getDepartmentNo () {
		return departmentNo;
	}

	/**
	 * Set the value related to the column: department_no
	 * @param departmentNo the department_no value
	 */
	public void setDepartmentNo (java.lang.String departmentNo) {
		this.departmentNo = departmentNo;
	}



	/**
	 * Return the value associated with the column: per_address
	 */
	public java.lang.String getPerAddress () {
		return perAddress;
	}

	/**
	 * Set the value related to the column: per_address
	 * @param perAddress the per_address value
	 */
	public void setPerAddress (java.lang.String perAddress) {
		this.perAddress = perAddress;
	}



	/**
	 * Return the value associated with the column: hal_join_date
	 */
	public java.util.Date getHalJoinDate () {
		return halJoinDate;
	}

	/**
	 * Set the value related to the column: hal_join_date
	 * @param halJoinDate the hal_join_date value
	 */
	public void setHalJoinDate (java.util.Date halJoinDate) {
		this.halJoinDate = halJoinDate;
	}



	/**
	 * Return the value associated with the column: current_division_join_date
	 */
	public java.util.Date getCurrentDivisionJoinDate () {
		return currentDivisionJoinDate;
	}

	/**
	 * Set the value related to the column: current_division_join_date
	 * @param currentDivisionJoinDate the current_division_join_date value
	 */
	public void setCurrentDivisionJoinDate (java.util.Date currentDivisionJoinDate) {
		this.currentDivisionJoinDate = currentDivisionJoinDate;
	}



	/**
	 * Return the value associated with the column: authorized_for_high_value_medicine
	 */
	public java.lang.String getAuthorizedForHighValueMedicine () {
		return authorizedForHighValueMedicine;
	}

	/**
	 * Set the value related to the column: authorized_for_high_value_medicine
	 * @param authorizedForHighValueMedicine the authorized_for_high_value_medicine value
	 */
	public void setAuthorizedForHighValueMedicine (java.lang.String authorizedForHighValueMedicine) {
		this.authorizedForHighValueMedicine = authorizedForHighValueMedicine;
	}



	/**
	 * Return the value associated with the column: communication
	 */
	public java.lang.String getCommunication () {
		return communication;
	}

	/**
	 * Set the value related to the column: communication
	 * @param communication the communication value
	 */
	public void setCommunication (java.lang.String communication) {
		this.communication = communication;
	}



	/**
	 * Return the value associated with the column: remarks
	 */
	public java.lang.String getRemarks () {
		return remarks;
	}

	/**
	 * Set the value related to the column: remarks
	 * @param remarks the remarks value
	 */
	public void setRemarks (java.lang.String remarks) {
		this.remarks = remarks;
	}



	/**
	 * Return the value associated with the column: contract_date
	 */
	public java.util.Date getContractDate () {
		return contractDate;
	}

	/**
	 * Set the value related to the column: contract_date
	 * @param contractDate the contract_date value
	 */
	public void setContractDate (java.util.Date contractDate) {
		this.contractDate = contractDate;
	}



	/**
	 * Return the value associated with the column: extension_date
	 */
	public java.util.Date getExtensionDate () {
		return extensionDate;
	}

	/**
	 * Set the value related to the column: extension_date
	 * @param extensionDate the extension_date value
	 */
	public void setExtensionDate (java.util.Date extensionDate) {
		this.extensionDate = extensionDate;
	}



	/**
	 * Return the value associated with the column: EPH_ISN
	 */
	public java.lang.Integer getEphIsn () {
		return ephIsn;
	}

	/**
	 * Set the value related to the column: EPH_ISN
	 * @param ephIsn the EPH_ISN value
	 */
	public void setEphIsn (java.lang.Integer ephIsn) {
		this.ephIsn = ephIsn;
	}



	/**
	 * Return the value associated with the column: pf_no
	 */
	public java.lang.String getPFNo () {
		return pFNo;
	}

	/**
	 * Set the value related to the column: pf_no
	 * @param pFNo the pf_no value
	 */
	public void setPFNo (java.lang.String pFNo) {
		this.pFNo = pFNo;
	}



	/**
	 * Return the value associated with the column: pan_no
	 */
	public java.lang.String getPANNo () {
		return pANNo;
	}

	/**
	 * Set the value related to the column: pan_no
	 * @param pANNo the pan_no value
	 */
	public void setPANNo (java.lang.String pANNo) {
		this.pANNo = pANNo;
	}



	/**
	 * Return the value associated with the column: account_no
	 */
	public java.lang.String getAccountNo () {
		return accountNo;
	}

	/**
	 * Set the value related to the column: account_no
	 * @param accountNo the account_no value
	 */
	public void setAccountNo (java.lang.String accountNo) {
		this.accountNo = accountNo;
	}



	/**
	 * Return the value associated with the column: bank_name
	 */
	public java.lang.String getBankName () {
		return bankName;
	}

	/**
	 * Set the value related to the column: bank_name
	 * @param bankName the bank_name value
	 */
	public void setBankName (java.lang.String bankName) {
		this.bankName = bankName;
	}



	/**
	 * Return the value associated with the column: service_type_id
	 */
	public jkt.hms.masters.business.MasServiceType getServiceType () {
		return serviceType;
	}

	/**
	 * Set the value related to the column: service_type_id
	 * @param serviceType the service_type_id value
	 */
	public void setServiceType (jkt.hms.masters.business.MasServiceType serviceType) {
		this.serviceType = serviceType;
	}



	/**
	 * Return the value associated with the column: posted_unit_id
	 */
	public jkt.hms.masters.business.MasUnit getPostedUnit () {
		return postedUnit;
	}

	/**
	 * Set the value related to the column: posted_unit_id
	 * @param postedUnit the posted_unit_id value
	 */
	public void setPostedUnit (jkt.hms.masters.business.MasUnit postedUnit) {
		this.postedUnit = postedUnit;
	}



	/**
	 * Return the value associated with the column: rank_id
	 */
	public jkt.hms.masters.business.MasRank getRank () {
		return rank;
	}

	/**
	 * Set the value related to the column: rank_id
	 * @param rank the rank_id value
	 */
	public void setRank (jkt.hms.masters.business.MasRank rank) {
		this.rank = rank;
	}



	/**
	 * Return the value associated with the column: speciality_id
	 */
	public jkt.hms.masters.business.HrSpecialistMaster getSpeciality () {
		return speciality;
	}

	/**
	 * Set the value related to the column: speciality_id
	 * @param speciality the speciality_id value
	 */
	public void setSpeciality (jkt.hms.masters.business.HrSpecialistMaster speciality) {
		this.speciality = speciality;
	}



	/**
	 * Return the value associated with the column: per_country_id
	 */
	public jkt.hms.masters.business.MasCountry getPerCountry () {
		return perCountry;
	}

	/**
	 * Set the value related to the column: per_country_id
	 * @param perCountry the per_country_id value
	 */
	public void setPerCountry (jkt.hms.masters.business.MasCountry perCountry) {
		this.perCountry = perCountry;
	}



	/**
	 * Return the value associated with the column: local_district_id
	 */
	public jkt.hms.masters.business.MasDistrict getLocalDistrict () {
		return localDistrict;
	}

	/**
	 * Set the value related to the column: local_district_id
	 * @param localDistrict the local_district_id value
	 */
	public void setLocalDistrict (jkt.hms.masters.business.MasDistrict localDistrict) {
		this.localDistrict = localDistrict;
	}



	/**
	 * Return the value associated with the column: trade_id
	 */
	public jkt.hms.masters.business.MasTrade getTrade () {
		return trade;
	}

	/**
	 * Set the value related to the column: trade_id
	 * @param trade the trade_id value
	 */
	public void setTrade (jkt.hms.masters.business.MasTrade trade) {
		this.trade = trade;
	}



	/**
	 * Return the value associated with the column: rank_category_id
	 */
	public jkt.hms.masters.business.MasRankCategory getRankCategory () {
		return rankCategory;
	}

	/**
	 * Set the value related to the column: rank_category_id
	 * @param rankCategory the rank_category_id value
	 */
	public void setRankCategory (jkt.hms.masters.business.MasRankCategory rankCategory) {
		this.rankCategory = rankCategory;
	}



	/**
	 * Return the value associated with the column: grade_id
	 */
	public jkt.hms.masters.business.MasGrade getGrade () {
		return grade;
	}

	/**
	 * Set the value related to the column: grade_id
	 * @param grade the grade_id value
	 */
	public void setGrade (jkt.hms.masters.business.MasGrade grade) {
		this.grade = grade;
	}



	/**
	 * Return the value associated with the column: per_district_id
	 */
	public jkt.hms.masters.business.MasDistrict getPerDistrict () {
		return perDistrict;
	}

	/**
	 * Set the value related to the column: per_district_id
	 * @param perDistrict the per_district_id value
	 */
	public void setPerDistrict (jkt.hms.masters.business.MasDistrict perDistrict) {
		this.perDistrict = perDistrict;
	}



	/**
	 * Return the value associated with the column: classification_id
	 */
	public jkt.hms.masters.business.HrorderlyClassificationMaster getClassification () {
		return classification;
	}

	/**
	 * Set the value related to the column: classification_id
	 * @param classification the classification_id value
	 */
	public void setClassification (jkt.hms.masters.business.HrorderlyClassificationMaster classification) {
		this.classification = classification;
	}



	/**
	 * Return the value associated with the column: unit_id
	 */
	public jkt.hms.masters.business.MasUnit getUnit () {
		return unit;
	}

	/**
	 * Set the value related to the column: unit_id
	 * @param unit the unit_id value
	 */
	public void setUnit (jkt.hms.masters.business.MasUnit unit) {
		this.unit = unit;
	}



	/**
	 * Return the value associated with the column: blood_group_id
	 */
	public jkt.hms.masters.business.MasBloodGroup getBloodGroup () {
		return bloodGroup;
	}

	/**
	 * Set the value related to the column: blood_group_id
	 * @param bloodGroup the blood_group_id value
	 */
	public void setBloodGroup (jkt.hms.masters.business.MasBloodGroup bloodGroup) {
		this.bloodGroup = bloodGroup;
	}



	/**
	 * Return the value associated with the column: emp_category_id
	 */
	public jkt.hms.masters.business.MasEmpCategory getEmpCategory () {
		return empCategory;
	}

	/**
	 * Set the value related to the column: emp_category_id
	 * @param empCategory the emp_category_id value
	 */
	public void setEmpCategory (jkt.hms.masters.business.MasEmpCategory empCategory) {
		this.empCategory = empCategory;
	}



	/**
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment () {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * @param department the department_id value
	 */
	public void setDepartment (jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}



	/**
	 * Return the value associated with the column: cost_center_id
	 */
	public jkt.hms.masters.business.MasCostCenter getCostCenter () {
		return costCenter;
	}

	/**
	 * Set the value related to the column: cost_center_id
	 * @param costCenter the cost_center_id value
	 */
	public void setCostCenter (jkt.hms.masters.business.MasCostCenter costCenter) {
		this.costCenter = costCenter;
	}



	/**
	 * Return the value associated with the column: mess_id
	 */
	public jkt.hms.masters.business.HrorderlyMessMaster getMess () {
		return mess;
	}

	/**
	 * Set the value related to the column: mess_id
	 * @param mess the mess_id value
	 */
	public void setMess (jkt.hms.masters.business.HrorderlyMessMaster mess) {
		this.mess = mess;
	}



	/**
	 * Return the value associated with the column: title_id
	 */
	public jkt.hms.masters.business.MasTitle getTitle () {
		return title;
	}

	/**
	 * Set the value related to the column: title_id
	 * @param title the title_id value
	 */
	public void setTitle (jkt.hms.masters.business.MasTitle title) {
		this.title = title;
	}



	/**
	 * Return the value associated with the column: division_id
	 */
	public jkt.hms.masters.business.MasDivision getDivision () {
		return division;
	}

	/**
	 * Set the value related to the column: division_id
	 * @param division the division_id value
	 */
	public void setDivision (jkt.hms.masters.business.MasDivision division) {
		this.division = division;
	}



	/**
	 * Return the value associated with the column: gender_id
	 */
	public jkt.hms.masters.business.MasAdministrativeSex getGender () {
		return gender;
	}

	/**
	 * Set the value related to the column: gender_id
	 * @param gender the gender_id value
	 */
	public void setGender (jkt.hms.masters.business.MasAdministrativeSex gender) {
		this.gender = gender;
	}



	/**
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital () {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * @param hospital the hospital_id value
	 */
	public void setHospital (jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}



	/**
	 * Return the value associated with the column: local_unit
	 */
	public jkt.hms.masters.business.MasUnit getLocalUnit () {
		return localUnit;
	}

	/**
	 * Set the value related to the column: local_unit
	 * @param localUnit the local_unit value
	 */
	public void setLocalUnit (jkt.hms.masters.business.MasUnit localUnit) {
		this.localUnit = localUnit;
	}



	/**
	 * Return the value associated with the column: local_state_id
	 */
	public jkt.hms.masters.business.MasState getLocalState () {
		return localState;
	}

	/**
	 * Set the value related to the column: local_state_id
	 * @param localState the local_state_id value
	 */
	public void setLocalState (jkt.hms.masters.business.MasState localState) {
		this.localState = localState;
	}



	/**
	 * Return the value associated with the column: per_state_id
	 */
	public jkt.hms.masters.business.MasState getPerState () {
		return perState;
	}

	/**
	 * Set the value related to the column: per_state_id
	 * @param perState the per_state_id value
	 */
	public void setPerState (jkt.hms.masters.business.MasState perState) {
		this.perState = perState;
	}



	/**
	 * Return the value associated with the column: employee_type_id
	 */
	public jkt.hms.masters.business.MasEmployeeType getEmployeeType () {
		return employeeType;
	}

	/**
	 * Set the value related to the column: employee_type_id
	 * @param employeeType the employee_type_id value
	 */
	public void setEmployeeType (jkt.hms.masters.business.MasEmployeeType employeeType) {
		this.employeeType = employeeType;
	}



	/**
	 * Return the value associated with the column: local_country_id
	 */
	public jkt.hms.masters.business.MasCountry getLocalCountry () {
		return localCountry;
	}

	/**
	 * Set the value related to the column: local_country_id
	 * @param localCountry the local_country_id value
	 */
	public void setLocalCountry (jkt.hms.masters.business.MasCountry localCountry) {
		this.localCountry = localCountry;
	}



	/**
	 * Return the value associated with the column: dependent_unit
	 */
	public jkt.hms.masters.business.MasUnit getDependentUnit () {
		return dependentUnit;
	}

	/**
	 * Set the value related to the column: dependent_unit
	 * @param dependentUnit the dependent_unit value
	 */
	public void setDependentUnit (jkt.hms.masters.business.MasUnit dependentUnit) {
		this.dependentUnit = dependentUnit;
	}



	/**
	 * Return the value associated with the column: employee_status_id
	 */
	public jkt.hms.masters.business.MasEmpStatus getEmployeeStatus () {
		return employeeStatus;
	}

	/**
	 * Set the value related to the column: employee_status_id
	 * @param employeeStatus the employee_status_id value
	 */
	public void setEmployeeStatus (jkt.hms.masters.business.MasEmpStatus employeeStatus) {
		this.employeeStatus = employeeStatus;
	}



	/**
	 * Return the value associated with the column: posted_out_id
	 */
	public jkt.hms.masters.business.PostedOutEntry getPostedOut () {
		return postedOut;
	}

	/**
	 * Set the value related to the column: posted_out_id
	 * @param postedOut the posted_out_id value
	 */
	public void setPostedOut (jkt.hms.masters.business.PostedOutEntry postedOut) {
		this.postedOut = postedOut;
	}



	/**
	 * Return the value associated with the column: marital_status_id
	 */
	public jkt.hms.masters.business.MasMaritalStatus getMaritalStatus () {
		return maritalStatus;
	}

	/**
	 * Set the value related to the column: marital_status_id
	 * @param maritalStatus the marital_status_id value
	 */
	public void setMaritalStatus (jkt.hms.masters.business.MasMaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}



	/**
	 * Return the value associated with the column: Discharges
	 */
	public java.util.Set<jkt.hms.masters.business.Discharge> getDischarges () {
		return discharges;
	}

	/**
	 * Set the value related to the column: Discharges
	 * @param discharges the Discharges value
	 */
	public void setDischarges (java.util.Set<jkt.hms.masters.business.Discharge> discharges) {
		this.discharges = discharges;
	}

	public void addToDischarges (jkt.hms.masters.business.Discharge discharge) {
		if (null == getDischarges()) setDischarges(new java.util.TreeSet<jkt.hms.masters.business.Discharge>());
		getDischarges().add(discharge);
	}



	/**
	 * Return the value associated with the column: StoreBoosByOfficerIc
	 */
	public java.util.Set<jkt.hms.masters.business.StoreBoo> getStoreBoosByOfficerIc () {
		return storeBoosByOfficerIc;
	}

	/**
	 * Set the value related to the column: StoreBoosByOfficerIc
	 * @param storeBoosByOfficerIc the StoreBoosByOfficerIc value
	 */
	public void setStoreBoosByOfficerIc (java.util.Set<jkt.hms.masters.business.StoreBoo> storeBoosByOfficerIc) {
		this.storeBoosByOfficerIc = storeBoosByOfficerIc;
	}

	public void addToStoreBoosByOfficerIc (jkt.hms.masters.business.StoreBoo storeBoo) {
		if (null == getStoreBoosByOfficerIc()) setStoreBoosByOfficerIc(new java.util.TreeSet<jkt.hms.masters.business.StoreBoo>());
		getStoreBoosByOfficerIc().add(storeBoo);
	}



	/**
	 * Return the value associated with the column: StoreBoosByPresidingOff
	 */
	public java.util.Set<jkt.hms.masters.business.StoreBoo> getStoreBoosByPresidingOff () {
		return storeBoosByPresidingOff;
	}

	/**
	 * Set the value related to the column: StoreBoosByPresidingOff
	 * @param storeBoosByPresidingOff the StoreBoosByPresidingOff value
	 */
	public void setStoreBoosByPresidingOff (java.util.Set<jkt.hms.masters.business.StoreBoo> storeBoosByPresidingOff) {
		this.storeBoosByPresidingOff = storeBoosByPresidingOff;
	}

	public void addToStoreBoosByPresidingOff (jkt.hms.masters.business.StoreBoo storeBoo) {
		if (null == getStoreBoosByPresidingOff()) setStoreBoosByPresidingOff(new java.util.TreeSet<jkt.hms.masters.business.StoreBoo>());
		getStoreBoosByPresidingOff().add(storeBoo);
	}



	/**
	 * Return the value associated with the column: StoreBoosByCommand
	 */
	public java.util.Set<jkt.hms.masters.business.StoreBoo> getStoreBoosByCommand () {
		return storeBoosByCommand;
	}

	/**
	 * Set the value related to the column: StoreBoosByCommand
	 * @param storeBoosByCommand the StoreBoosByCommand value
	 */
	public void setStoreBoosByCommand (java.util.Set<jkt.hms.masters.business.StoreBoo> storeBoosByCommand) {
		this.storeBoosByCommand = storeBoosByCommand;
	}

	public void addToStoreBoosByCommand (jkt.hms.masters.business.StoreBoo storeBoo) {
		if (null == getStoreBoosByCommand()) setStoreBoosByCommand(new java.util.TreeSet<jkt.hms.masters.business.StoreBoo>());
		getStoreBoosByCommand().add(storeBoo);
	}



	/**
	 * Return the value associated with the column: MlcCases
	 */
	public java.util.Set<jkt.hms.masters.business.MlcCase> getMlcCases () {
		return mlcCases;
	}

	/**
	 * Set the value related to the column: MlcCases
	 * @param mlcCases the MlcCases value
	 */
	public void setMlcCases (java.util.Set<jkt.hms.masters.business.MlcCase> mlcCases) {
		this.mlcCases = mlcCases;
	}

	public void addToMlcCases (jkt.hms.masters.business.MlcCase mlcCase) {
		if (null == getMlcCases()) setMlcCases(new java.util.TreeSet<jkt.hms.masters.business.MlcCase>());
		getMlcCases().add(mlcCase);
	}



	/**
	 * Return the value associated with the column: StoreBalanceMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreBalanceM> getStoreBalanceMs () {
		return storeBalanceMs;
	}

	/**
	 * Set the value related to the column: StoreBalanceMs
	 * @param storeBalanceMs the StoreBalanceMs value
	 */
	public void setStoreBalanceMs (java.util.Set<jkt.hms.masters.business.StoreBalanceM> storeBalanceMs) {
		this.storeBalanceMs = storeBalanceMs;
	}

	public void addToStoreBalanceMs (jkt.hms.masters.business.StoreBalanceM storeBalanceM) {
		if (null == getStoreBalanceMs()) setStoreBalanceMs(new java.util.TreeSet<jkt.hms.masters.business.StoreBalanceM>());
		getStoreBalanceMs().add(storeBalanceM);
	}



	/**
	 * Return the value associated with the column: Birthdeathregs
	 */
	public java.util.Set<jkt.hms.masters.business.Birthdeathreg> getBirthdeathregs () {
		return birthdeathregs;
	}

	/**
	 * Set the value related to the column: Birthdeathregs
	 * @param birthdeathregs the Birthdeathregs value
	 */
	public void setBirthdeathregs (java.util.Set<jkt.hms.masters.business.Birthdeathreg> birthdeathregs) {
		this.birthdeathregs = birthdeathregs;
	}

	public void addToBirthdeathregs (jkt.hms.masters.business.Birthdeathreg birthdeathreg) {
		if (null == getBirthdeathregs()) setBirthdeathregs(new java.util.TreeSet<jkt.hms.masters.business.Birthdeathreg>());
		getBirthdeathregs().add(birthdeathreg);
	}



	/**
	 * Return the value associated with the column: StoreGrnReturnMsByApprovedBy
	 */
	public java.util.Set<jkt.hms.masters.business.StoreGrnReturnM> getStoreGrnReturnMsByApprovedBy () {
		return storeGrnReturnMsByApprovedBy;
	}

	/**
	 * Set the value related to the column: StoreGrnReturnMsByApprovedBy
	 * @param storeGrnReturnMsByApprovedBy the StoreGrnReturnMsByApprovedBy value
	 */
	public void setStoreGrnReturnMsByApprovedBy (java.util.Set<jkt.hms.masters.business.StoreGrnReturnM> storeGrnReturnMsByApprovedBy) {
		this.storeGrnReturnMsByApprovedBy = storeGrnReturnMsByApprovedBy;
	}

	public void addToStoreGrnReturnMsByApprovedBy (jkt.hms.masters.business.StoreGrnReturnM storeGrnReturnM) {
		if (null == getStoreGrnReturnMsByApprovedBy()) setStoreGrnReturnMsByApprovedBy(new java.util.TreeSet<jkt.hms.masters.business.StoreGrnReturnM>());
		getStoreGrnReturnMsByApprovedBy().add(storeGrnReturnM);
	}



	/**
	 * Return the value associated with the column: StoreGrnReturnMsByReturnBy
	 */
	public java.util.Set<jkt.hms.masters.business.StoreGrnReturnM> getStoreGrnReturnMsByReturnBy () {
		return storeGrnReturnMsByReturnBy;
	}

	/**
	 * Set the value related to the column: StoreGrnReturnMsByReturnBy
	 * @param storeGrnReturnMsByReturnBy the StoreGrnReturnMsByReturnBy value
	 */
	public void setStoreGrnReturnMsByReturnBy (java.util.Set<jkt.hms.masters.business.StoreGrnReturnM> storeGrnReturnMsByReturnBy) {
		this.storeGrnReturnMsByReturnBy = storeGrnReturnMsByReturnBy;
	}

	public void addToStoreGrnReturnMsByReturnBy (jkt.hms.masters.business.StoreGrnReturnM storeGrnReturnM) {
		if (null == getStoreGrnReturnMsByReturnBy()) setStoreGrnReturnMsByReturnBy(new java.util.TreeSet<jkt.hms.masters.business.StoreGrnReturnM>());
		getStoreGrnReturnMsByReturnBy().add(storeGrnReturnM);
	}



	/**
	 * Return the value associated with the column: StoreIssueMsByApprovedBy
	 */
	public java.util.Set<jkt.hms.masters.business.StoreIssueM> getStoreIssueMsByApprovedBy () {
		return storeIssueMsByApprovedBy;
	}

	/**
	 * Set the value related to the column: StoreIssueMsByApprovedBy
	 * @param storeIssueMsByApprovedBy the StoreIssueMsByApprovedBy value
	 */
	public void setStoreIssueMsByApprovedBy (java.util.Set<jkt.hms.masters.business.StoreIssueM> storeIssueMsByApprovedBy) {
		this.storeIssueMsByApprovedBy = storeIssueMsByApprovedBy;
	}

	public void addToStoreIssueMsByApprovedBy (jkt.hms.masters.business.StoreIssueM storeIssueM) {
		if (null == getStoreIssueMsByApprovedBy()) setStoreIssueMsByApprovedBy(new java.util.TreeSet<jkt.hms.masters.business.StoreIssueM>());
		getStoreIssueMsByApprovedBy().add(storeIssueM);
	}



	/**
	 * Return the value associated with the column: StoreIssueMsByIssuedBy
	 */
	public java.util.Set<jkt.hms.masters.business.StoreIssueM> getStoreIssueMsByIssuedBy () {
		return storeIssueMsByIssuedBy;
	}

	/**
	 * Set the value related to the column: StoreIssueMsByIssuedBy
	 * @param storeIssueMsByIssuedBy the StoreIssueMsByIssuedBy value
	 */
	public void setStoreIssueMsByIssuedBy (java.util.Set<jkt.hms.masters.business.StoreIssueM> storeIssueMsByIssuedBy) {
		this.storeIssueMsByIssuedBy = storeIssueMsByIssuedBy;
	}

	public void addToStoreIssueMsByIssuedBy (jkt.hms.masters.business.StoreIssueM storeIssueM) {
		if (null == getStoreIssueMsByIssuedBy()) setStoreIssueMsByIssuedBy(new java.util.TreeSet<jkt.hms.masters.business.StoreIssueM>());
		getStoreIssueMsByIssuedBy().add(storeIssueM);
	}



	/**
	 * Return the value associated with the column: StoreIssueMsByRequestBy
	 */
	public java.util.Set<jkt.hms.masters.business.StoreIssueM> getStoreIssueMsByRequestBy () {
		return storeIssueMsByRequestBy;
	}

	/**
	 * Set the value related to the column: StoreIssueMsByRequestBy
	 * @param storeIssueMsByRequestBy the StoreIssueMsByRequestBy value
	 */
	public void setStoreIssueMsByRequestBy (java.util.Set<jkt.hms.masters.business.StoreIssueM> storeIssueMsByRequestBy) {
		this.storeIssueMsByRequestBy = storeIssueMsByRequestBy;
	}

	public void addToStoreIssueMsByRequestBy (jkt.hms.masters.business.StoreIssueM storeIssueM) {
		if (null == getStoreIssueMsByRequestBy()) setStoreIssueMsByRequestBy(new java.util.TreeSet<jkt.hms.masters.business.StoreIssueM>());
		getStoreIssueMsByRequestBy().add(storeIssueM);
	}



	/**
	 * Return the value associated with the column: Users
	 */
	public java.util.Set<jkt.hms.masters.business.Users> getUsers () {
		return users;
	}

	/**
	 * Set the value related to the column: Users
	 * @param users the Users value
	 */
	public void setUsers (java.util.Set<jkt.hms.masters.business.Users> users) {
		this.users = users;
	}

	public void addToUsers (jkt.hms.masters.business.Users users) {
		if (null == getUsers()) setUsers(new java.util.TreeSet<jkt.hms.masters.business.Users>());
		getUsers().add(users);
	}



	/**
	 * Return the value associated with the column: MasDiscounts
	 */
	public java.util.Set<jkt.hms.masters.business.MasDiscount> getMasDiscounts () {
		return masDiscounts;
	}

	/**
	 * Set the value related to the column: MasDiscounts
	 * @param masDiscounts the MasDiscounts value
	 */
	public void setMasDiscounts (java.util.Set<jkt.hms.masters.business.MasDiscount> masDiscounts) {
		this.masDiscounts = masDiscounts;
	}

	public void addToMasDiscounts (jkt.hms.masters.business.MasDiscount masDiscount) {
		if (null == getMasDiscounts()) setMasDiscounts(new java.util.TreeSet<jkt.hms.masters.business.MasDiscount>());
		getMasDiscounts().add(masDiscount);
	}



	/**
	 * Return the value associated with the column: StoreMmfDepartmentMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreMmfDepartmentM> getStoreMmfDepartmentMs () {
		return storeMmfDepartmentMs;
	}

	/**
	 * Set the value related to the column: StoreMmfDepartmentMs
	 * @param storeMmfDepartmentMs the StoreMmfDepartmentMs value
	 */
	public void setStoreMmfDepartmentMs (java.util.Set<jkt.hms.masters.business.StoreMmfDepartmentM> storeMmfDepartmentMs) {
		this.storeMmfDepartmentMs = storeMmfDepartmentMs;
	}

	public void addToStoreMmfDepartmentMs (jkt.hms.masters.business.StoreMmfDepartmentM storeMmfDepartmentM) {
		if (null == getStoreMmfDepartmentMs()) setStoreMmfDepartmentMs(new java.util.TreeSet<jkt.hms.masters.business.StoreMmfDepartmentM>());
		getStoreMmfDepartmentMs().add(storeMmfDepartmentM);
	}



	/**
	 * Return the value associated with the column: MasEmployeeDependents
	 */
	public java.util.Set<jkt.hms.masters.business.MasEmployeeDependent> getMasEmployeeDependents () {
		return masEmployeeDependents;
	}

	/**
	 * Set the value related to the column: MasEmployeeDependents
	 * @param masEmployeeDependents the MasEmployeeDependents value
	 */
	public void setMasEmployeeDependents (java.util.Set<jkt.hms.masters.business.MasEmployeeDependent> masEmployeeDependents) {
		this.masEmployeeDependents = masEmployeeDependents;
	}

	public void addToMasEmployeeDependents (jkt.hms.masters.business.MasEmployeeDependent masEmployeeDependent) {
		if (null == getMasEmployeeDependents()) setMasEmployeeDependents(new java.util.TreeSet<jkt.hms.masters.business.MasEmployeeDependent>());
		getMasEmployeeDependents().add(masEmployeeDependent);
	}



	/**
	 * Return the value associated with the column: StoreBooMembers
	 */
	public java.util.Set<jkt.hms.masters.business.StoreBooMember> getStoreBooMembers () {
		return storeBooMembers;
	}

	/**
	 * Set the value related to the column: StoreBooMembers
	 * @param storeBooMembers the StoreBooMembers value
	 */
	public void setStoreBooMembers (java.util.Set<jkt.hms.masters.business.StoreBooMember> storeBooMembers) {
		this.storeBooMembers = storeBooMembers;
	}

	public void addToStoreBooMembers (jkt.hms.masters.business.StoreBooMember storeBooMember) {
		if (null == getStoreBooMembers()) setStoreBooMembers(new java.util.TreeSet<jkt.hms.masters.business.StoreBooMember>());
		getStoreBooMembers().add(storeBooMember);
	}



	/**
	 * Return the value associated with the column: StoreInternalReturnMsByReturnBy
	 */
	public java.util.Set<jkt.hms.masters.business.StoreInternalReturnM> getStoreInternalReturnMsByReturnBy () {
		return storeInternalReturnMsByReturnBy;
	}

	/**
	 * Set the value related to the column: StoreInternalReturnMsByReturnBy
	 * @param storeInternalReturnMsByReturnBy the StoreInternalReturnMsByReturnBy value
	 */
	public void setStoreInternalReturnMsByReturnBy (java.util.Set<jkt.hms.masters.business.StoreInternalReturnM> storeInternalReturnMsByReturnBy) {
		this.storeInternalReturnMsByReturnBy = storeInternalReturnMsByReturnBy;
	}

	public void addToStoreInternalReturnMsByReturnBy (jkt.hms.masters.business.StoreInternalReturnM storeInternalReturnM) {
		if (null == getStoreInternalReturnMsByReturnBy()) setStoreInternalReturnMsByReturnBy(new java.util.TreeSet<jkt.hms.masters.business.StoreInternalReturnM>());
		getStoreInternalReturnMsByReturnBy().add(storeInternalReturnM);
	}



	/**
	 * Return the value associated with the column: StoreInternalReturnMsByReceivedBy
	 */
	public java.util.Set<jkt.hms.masters.business.StoreInternalReturnM> getStoreInternalReturnMsByReceivedBy () {
		return storeInternalReturnMsByReceivedBy;
	}

	/**
	 * Set the value related to the column: StoreInternalReturnMsByReceivedBy
	 * @param storeInternalReturnMsByReceivedBy the StoreInternalReturnMsByReceivedBy value
	 */
	public void setStoreInternalReturnMsByReceivedBy (java.util.Set<jkt.hms.masters.business.StoreInternalReturnM> storeInternalReturnMsByReceivedBy) {
		this.storeInternalReturnMsByReceivedBy = storeInternalReturnMsByReceivedBy;
	}

	public void addToStoreInternalReturnMsByReceivedBy (jkt.hms.masters.business.StoreInternalReturnM storeInternalReturnM) {
		if (null == getStoreInternalReturnMsByReceivedBy()) setStoreInternalReturnMsByReceivedBy(new java.util.TreeSet<jkt.hms.masters.business.StoreInternalReturnM>());
		getStoreInternalReturnMsByReceivedBy().add(storeInternalReturnM);
	}



	/**
	 * Return the value associated with the column: EmpAfmsfDets
	 */
	public java.util.Set<jkt.hms.masters.business.EmpAfmsfDet> getEmpAfmsfDets () {
		return empAfmsfDets;
	}

	/**
	 * Set the value related to the column: EmpAfmsfDets
	 * @param empAfmsfDets the EmpAfmsfDets value
	 */
	public void setEmpAfmsfDets (java.util.Set<jkt.hms.masters.business.EmpAfmsfDet> empAfmsfDets) {
		this.empAfmsfDets = empAfmsfDets;
	}

	public void addToEmpAfmsfDets (jkt.hms.masters.business.EmpAfmsfDet empAfmsfDet) {
		if (null == getEmpAfmsfDets()) setEmpAfmsfDets(new java.util.TreeSet<jkt.hms.masters.business.EmpAfmsfDet>());
		getEmpAfmsfDets().add(empAfmsfDet);
	}



	/**
	 * Return the value associated with the column: StoreTenderLocalPurchaseMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreTenderLocalPurchaseM> getStoreTenderLocalPurchaseMs () {
		return storeTenderLocalPurchaseMs;
	}

	/**
	 * Set the value related to the column: StoreTenderLocalPurchaseMs
	 * @param storeTenderLocalPurchaseMs the StoreTenderLocalPurchaseMs value
	 */
	public void setStoreTenderLocalPurchaseMs (java.util.Set<jkt.hms.masters.business.StoreTenderLocalPurchaseM> storeTenderLocalPurchaseMs) {
		this.storeTenderLocalPurchaseMs = storeTenderLocalPurchaseMs;
	}

	public void addToStoreTenderLocalPurchaseMs (jkt.hms.masters.business.StoreTenderLocalPurchaseM storeTenderLocalPurchaseM) {
		if (null == getStoreTenderLocalPurchaseMs()) setStoreTenderLocalPurchaseMs(new java.util.TreeSet<jkt.hms.masters.business.StoreTenderLocalPurchaseM>());
		getStoreTenderLocalPurchaseMs().add(storeTenderLocalPurchaseM);
	}



	/**
	 * Return the value associated with the column: StoreTenderCommHodRecoms
	 */
	public java.util.Set<jkt.hms.masters.business.StoreTenderCommHodRecom> getStoreTenderCommHodRecoms () {
		return storeTenderCommHodRecoms;
	}

	/**
	 * Set the value related to the column: StoreTenderCommHodRecoms
	 * @param storeTenderCommHodRecoms the StoreTenderCommHodRecoms value
	 */
	public void setStoreTenderCommHodRecoms (java.util.Set<jkt.hms.masters.business.StoreTenderCommHodRecom> storeTenderCommHodRecoms) {
		this.storeTenderCommHodRecoms = storeTenderCommHodRecoms;
	}

	public void addToStoreTenderCommHodRecoms (jkt.hms.masters.business.StoreTenderCommHodRecom storeTenderCommHodRecom) {
		if (null == getStoreTenderCommHodRecoms()) setStoreTenderCommHodRecoms(new java.util.TreeSet<jkt.hms.masters.business.StoreTenderCommHodRecom>());
		getStoreTenderCommHodRecoms().add(storeTenderCommHodRecom);
	}



	/**
	 * Return the value associated with the column: StoreOpPatientIssueMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreOpPatientIssueM> getStoreOpPatientIssueMs () {
		return storeOpPatientIssueMs;
	}

	/**
	 * Set the value related to the column: StoreOpPatientIssueMs
	 * @param storeOpPatientIssueMs the StoreOpPatientIssueMs value
	 */
	public void setStoreOpPatientIssueMs (java.util.Set<jkt.hms.masters.business.StoreOpPatientIssueM> storeOpPatientIssueMs) {
		this.storeOpPatientIssueMs = storeOpPatientIssueMs;
	}

	public void addToStoreOpPatientIssueMs (jkt.hms.masters.business.StoreOpPatientIssueM storeOpPatientIssueM) {
		if (null == getStoreOpPatientIssueMs()) setStoreOpPatientIssueMs(new java.util.TreeSet<jkt.hms.masters.business.StoreOpPatientIssueM>());
		getStoreOpPatientIssueMs().add(storeOpPatientIssueM);
	}



	/**
	 * Return the value associated with the column: DgOrderhds
	 */
	public java.util.Set<jkt.hms.masters.business.DgOrderhd> getDgOrderhds () {
		return dgOrderhds;
	}

	/**
	 * Set the value related to the column: DgOrderhds
	 * @param dgOrderhds the DgOrderhds value
	 */
	public void setDgOrderhds (java.util.Set<jkt.hms.masters.business.DgOrderhd> dgOrderhds) {
		this.dgOrderhds = dgOrderhds;
	}

	public void addToDgOrderhds (jkt.hms.masters.business.DgOrderhd dgOrderhd) {
		if (null == getDgOrderhds()) setDgOrderhds(new java.util.TreeSet<jkt.hms.masters.business.DgOrderhd>());
		getDgOrderhds().add(dgOrderhd);
	}



	/**
	 * Return the value associated with the column: StoreSetups
	 */
	public java.util.Set<jkt.hms.masters.business.StoreSetup> getStoreSetups () {
		return storeSetups;
	}

	/**
	 * Set the value related to the column: StoreSetups
	 * @param storeSetups the StoreSetups value
	 */
	public void setStoreSetups (java.util.Set<jkt.hms.masters.business.StoreSetup> storeSetups) {
		this.storeSetups = storeSetups;
	}

	public void addToStoreSetups (jkt.hms.masters.business.StoreSetup storeSetup) {
		if (null == getStoreSetups()) setStoreSetups(new java.util.TreeSet<jkt.hms.masters.business.StoreSetup>());
		getStoreSetups().add(storeSetup);
	}



	/**
	 * Return the value associated with the column: StoreGrnMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreGrnM> getStoreGrnMs () {
		return storeGrnMs;
	}

	/**
	 * Set the value related to the column: StoreGrnMs
	 * @param storeGrnMs the StoreGrnMs value
	 */
	public void setStoreGrnMs (java.util.Set<jkt.hms.masters.business.StoreGrnM> storeGrnMs) {
		this.storeGrnMs = storeGrnMs;
	}

	public void addToStoreGrnMs (jkt.hms.masters.business.StoreGrnM storeGrnM) {
		if (null == getStoreGrnMs()) setStoreGrnMs(new java.util.TreeSet<jkt.hms.masters.business.StoreGrnM>());
		getStoreGrnMs().add(storeGrnM);
	}



	/**
	 * Return the value associated with the column: StoreIssueTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreIssueT> getStoreIssueTs () {
		return storeIssueTs;
	}

	/**
	 * Set the value related to the column: StoreIssueTs
	 * @param storeIssueTs the StoreIssueTs value
	 */
	public void setStoreIssueTs (java.util.Set<jkt.hms.masters.business.StoreIssueT> storeIssueTs) {
		this.storeIssueTs = storeIssueTs;
	}

	public void addToStoreIssueTs (jkt.hms.masters.business.StoreIssueT storeIssueT) {
		if (null == getStoreIssueTs()) setStoreIssueTs(new java.util.TreeSet<jkt.hms.masters.business.StoreIssueT>());
		getStoreIssueTs().add(storeIssueT);
	}



	/**
	 * Return the value associated with the column: StoreInternalIndentMsByApprovedBy
	 */
	public java.util.Set<jkt.hms.masters.business.StoreInternalIndentM> getStoreInternalIndentMsByApprovedBy () {
		return storeInternalIndentMsByApprovedBy;
	}

	/**
	 * Set the value related to the column: StoreInternalIndentMsByApprovedBy
	 * @param storeInternalIndentMsByApprovedBy the StoreInternalIndentMsByApprovedBy value
	 */
	public void setStoreInternalIndentMsByApprovedBy (java.util.Set<jkt.hms.masters.business.StoreInternalIndentM> storeInternalIndentMsByApprovedBy) {
		this.storeInternalIndentMsByApprovedBy = storeInternalIndentMsByApprovedBy;
	}

	public void addToStoreInternalIndentMsByApprovedBy (jkt.hms.masters.business.StoreInternalIndentM storeInternalIndentM) {
		if (null == getStoreInternalIndentMsByApprovedBy()) setStoreInternalIndentMsByApprovedBy(new java.util.TreeSet<jkt.hms.masters.business.StoreInternalIndentM>());
		getStoreInternalIndentMsByApprovedBy().add(storeInternalIndentM);
	}



	/**
	 * Return the value associated with the column: StoreInternalIndentMsByRequestedBy
	 */
	public java.util.Set<jkt.hms.masters.business.StoreInternalIndentM> getStoreInternalIndentMsByRequestedBy () {
		return storeInternalIndentMsByRequestedBy;
	}

	/**
	 * Set the value related to the column: StoreInternalIndentMsByRequestedBy
	 * @param storeInternalIndentMsByRequestedBy the StoreInternalIndentMsByRequestedBy value
	 */
	public void setStoreInternalIndentMsByRequestedBy (java.util.Set<jkt.hms.masters.business.StoreInternalIndentM> storeInternalIndentMsByRequestedBy) {
		this.storeInternalIndentMsByRequestedBy = storeInternalIndentMsByRequestedBy;
	}

	public void addToStoreInternalIndentMsByRequestedBy (jkt.hms.masters.business.StoreInternalIndentM storeInternalIndentM) {
		if (null == getStoreInternalIndentMsByRequestedBy()) setStoreInternalIndentMsByRequestedBy(new java.util.TreeSet<jkt.hms.masters.business.StoreInternalIndentM>());
		getStoreInternalIndentMsByRequestedBy().add(storeInternalIndentM);
	}



	/**
	 * Return the value associated with the column: Inpatients
	 */
	public java.util.Set<jkt.hms.masters.business.Inpatient> getInpatients () {
		return inpatients;
	}

	/**
	 * Set the value related to the column: Inpatients
	 * @param inpatients the Inpatients value
	 */
	public void setInpatients (java.util.Set<jkt.hms.masters.business.Inpatient> inpatients) {
		this.inpatients = inpatients;
	}

	public void addToInpatients (jkt.hms.masters.business.Inpatient inpatient) {
		if (null == getInpatients()) setInpatients(new java.util.TreeSet<jkt.hms.masters.business.Inpatient>());
		getInpatients().add(inpatient);
	}



	/**
	 * Return the value associated with the column: Visits
	 */
	public java.util.Set<jkt.hms.masters.business.Visit> getVisits () {
		return visits;
	}

	/**
	 * Set the value related to the column: Visits
	 * @param visits the Visits value
	 */
	public void setVisits (java.util.Set<jkt.hms.masters.business.Visit> visits) {
		this.visits = visits;
	}

	public void addToVisits (jkt.hms.masters.business.Visit visit) {
		if (null == getVisits()) setVisits(new java.util.TreeSet<jkt.hms.masters.business.Visit>());
		getVisits().add(visit);
	}



	/**
	 * Return the value associated with the column: StoreLoaninMs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreLoaninM> getStoreLoaninMs () {
		return storeLoaninMs;
	}

	/**
	 * Set the value related to the column: StoreLoaninMs
	 * @param storeLoaninMs the StoreLoaninMs value
	 */
	public void setStoreLoaninMs (java.util.Set<jkt.hms.masters.business.StoreLoaninM> storeLoaninMs) {
		this.storeLoaninMs = storeLoaninMs;
	}

	public void addToStoreLoaninMs (jkt.hms.masters.business.StoreLoaninM storeLoaninM) {
		if (null == getStoreLoaninMs()) setStoreLoaninMs(new java.util.TreeSet<jkt.hms.masters.business.StoreLoaninM>());
		getStoreLoaninMs().add(storeLoaninM);
	}



	/**
	 * Return the value associated with the column: Transfers
	 */
	public java.util.Set<jkt.hms.masters.business.Transfer> getTransfers () {
		return transfers;
	}

	/**
	 * Set the value related to the column: Transfers
	 * @param transfers the Transfers value
	 */
	public void setTransfers (java.util.Set<jkt.hms.masters.business.Transfer> transfers) {
		this.transfers = transfers;
	}

	public void addToTransfers (jkt.hms.masters.business.Transfer transfer) {
		if (null == getTransfers()) setTransfers(new java.util.TreeSet<jkt.hms.masters.business.Transfer>());
		getTransfers().add(transfer);
	}



	/**
	 * Return the value associated with the column: SilDilStatus
	 */
	public java.util.Set<jkt.hms.masters.business.SilDilStatus> getSilDilStatus () {
		return silDilStatus;
	}

	/**
	 * Set the value related to the column: SilDilStatus
	 * @param silDilStatus the SilDilStatus value
	 */
	public void setSilDilStatus (java.util.Set<jkt.hms.masters.business.SilDilStatus> silDilStatus) {
		this.silDilStatus = silDilStatus;
	}

	public void addToSilDilStatus (jkt.hms.masters.business.SilDilStatus silDilStatus) {
		if (null == getSilDilStatus()) setSilDilStatus(new java.util.TreeSet<jkt.hms.masters.business.SilDilStatus>());
		getSilDilStatus().add(silDilStatus);
	}



	/**
	 * Return the value associated with the column: MasEmployeeDepartments
	 */
	public java.util.Set<jkt.hms.masters.business.MasEmployeeDepartment> getMasEmployeeDepartments () {
		return masEmployeeDepartments;
	}

	/**
	 * Set the value related to the column: MasEmployeeDepartments
	 * @param masEmployeeDepartments the MasEmployeeDepartments value
	 */
	public void setMasEmployeeDepartments (java.util.Set<jkt.hms.masters.business.MasEmployeeDepartment> masEmployeeDepartments) {
		this.masEmployeeDepartments = masEmployeeDepartments;
	}

	public void addToMasEmployeeDepartments (jkt.hms.masters.business.MasEmployeeDepartment masEmployeeDepartment) {
		if (null == getMasEmployeeDepartments()) setMasEmployeeDepartments(new java.util.TreeSet<jkt.hms.masters.business.MasEmployeeDepartment>());
		getMasEmployeeDepartments().add(masEmployeeDepartment);
	}



	/**
	 * Return the value associated with the column: PayStructure
	 */
	public java.util.Set<jkt.hms.masters.business.HrEmployeePayStructure> getPayStructure () {
		return payStructure;
	}

	/**
	 * Set the value related to the column: PayStructure
	 * @param payStructure the PayStructure value
	 */
	public void setPayStructure (java.util.Set<jkt.hms.masters.business.HrEmployeePayStructure> payStructure) {
		this.payStructure = payStructure;
	}

	public void addToPayStructure (jkt.hms.masters.business.HrEmployeePayStructure hrEmployeePayStructure) {
		if (null == getPayStructure()) setPayStructure(new java.util.TreeSet<jkt.hms.masters.business.HrEmployeePayStructure>());
		getPayStructure().add(hrEmployeePayStructure);
	}



	/**
	 * Return the value associated with the column: PayElements
	 */
	public java.util.Set<jkt.hms.masters.business.HrEmployeePayElements> getPayElements () {
		return payElements;
	}

	/**
	 * Set the value related to the column: PayElements
	 * @param payElements the PayElements value
	 */
	public void setPayElements (java.util.Set<jkt.hms.masters.business.HrEmployeePayElements> payElements) {
		this.payElements = payElements;
	}

	public void addToPayElements (jkt.hms.masters.business.HrEmployeePayElements hrEmployeePayElements) {
		if (null == getPayElements()) setPayElements(new java.util.TreeSet<jkt.hms.masters.business.HrEmployeePayElements>());
		getPayElements().add(hrEmployeePayElements);
	}



	/**
	 * Return the value associated with the column: ItaxCalculate
	 */
	public java.util.Set<jkt.hms.masters.business.HrItaxCalculate> getItaxCalculate () {
		return itaxCalculate;
	}

	/**
	 * Set the value related to the column: ItaxCalculate
	 * @param itaxCalculate the ItaxCalculate value
	 */
	public void setItaxCalculate (java.util.Set<jkt.hms.masters.business.HrItaxCalculate> itaxCalculate) {
		this.itaxCalculate = itaxCalculate;
	}

	public void addToItaxCalculate (jkt.hms.masters.business.HrItaxCalculate hrItaxCalculate) {
		if (null == getItaxCalculate()) setItaxCalculate(new java.util.TreeSet<jkt.hms.masters.business.HrItaxCalculate>());
		getItaxCalculate().add(hrItaxCalculate);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasEmployee)) return false;
		else {
			jkt.hms.masters.business.MasEmployee masEmployee = (jkt.hms.masters.business.MasEmployee) obj;
			if (null == this.getId() || null == masEmployee.getId()) return false;
			else return (this.getId().equals(masEmployee.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}
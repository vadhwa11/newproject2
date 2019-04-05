package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the users table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="users"
 */

public abstract class BaseUsers  implements Serializable {

	public static String REF = "Users";
	public static String PROP_STATUS = "Status";
	public static String PROP_LOGIN_NAME = "LoginName";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_USER_NAME = "UserName";
	public static String PROP_FIRST_NAME = "FirstName";
	public static String PROP_RESET_REQ_ON = "ResetReqOn";
	public static String PROP_RESET_COMPLETE_ON = "ResetCompleteOn";
	public static String PROP_STATUS_S_H_A1 = "StatusSHA1";
	public static String PROP_EMAIL_ADDRESS = "EmailAddress";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_RESET_FLAG = "ResetFlag";
	public static String PROP_RESET_COUNT = "ResetCount";
	public static String PROP_LAST_NAME = "LastName";
	public static String PROP_ID = "Id";
	public static String PROP_COUNT_USER = "CountUser";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_PASSWORD = "Password";


	// constructors
	public BaseUsers () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseUsers (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseUsers (
		java.lang.Integer id,
		java.lang.String loginName,
		java.lang.String userName,
		java.lang.String password,
		java.lang.String status,
		java.lang.String firstName,
		java.lang.String lastName) {

		this.setId(id);
		this.setLoginName(loginName);
		this.setUserName(userName);
		this.setPassword(password);
		this.setStatus(status);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer countUser;
	private java.lang.String loginName;
	private java.lang.String userName;
	private java.lang.String password;
	private java.lang.String status;
	private java.lang.String statusSHA1;
	private java.lang.String lastChgBy;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String emailAddress;
	private java.lang.String firstName;
	private java.lang.String lastName;
	private java.lang.String resetFlag;
	private java.util.Date resetCompleteOn;
	private java.util.Date resetReqOn;
	private java.lang.Integer resetCount;

	// many to one
	private jkt.hms.masters.business.MasEmployee employee;

	// collections
	private java.util.Set<jkt.hms.masters.business.UserUsergroupHospital> userUsergroupHospitals;
	private java.util.Set<jkt.hms.masters.business.Visit> visits;
	private java.util.Set<jkt.hms.masters.business.Discharge> discharges;
	private java.util.Set<jkt.hms.masters.business.DischargeIcdCode> dischargeIcdCodes;
	private java.util.Set<jkt.hms.masters.business.Patient> patients;
	private java.util.Set<jkt.hms.masters.business.AttachInpatient> attachInpatients;
	private java.util.Set<jkt.hms.masters.business.UserDepartment> userDepartments;
	private java.util.Set<jkt.hms.masters.business.BlReceipt> blReceipts;
	private java.util.Set<jkt.hms.masters.business.BlOpBillMain> blOpBillMains;
	private java.util.Set<jkt.hms.masters.business.UserStatusHospital> userStatusHospitals;
	private java.util.Set<jkt.hms.masters.business.UserUsergroupApplication> userUsergroupApplications;
	private java.util.Set<jkt.hms.masters.business.ExpiryDetails> expiryDetails;
	private java.util.Set<jkt.hms.masters.business.UserHospitalDepartment> userHospitalDepartments;
	private java.util.Set<jkt.hms.masters.business.Transfer> transfers;
	private java.util.Set<jkt.hms.masters.business.UserHospitalRole> userHospitalRoles;
	private java.util.Set<jkt.hms.masters.business.Inpatient> inpatients;
	private java.util.Set<jkt.hms.masters.business.MlcCase> mlcCases;
	private java.util.Set<jkt.hms.masters.business.BlOpBillDetail> blOpBillDetails;
	private java.util.Set<jkt.hms.masters.business.UserAccessrightsHospital> userAccessrightsHospitals;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="user_id"
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
	 * Return the value associated with the column: count_user
	 */
	public java.lang.Integer getCountUser () {
		return countUser;
	}

	/**
	 * Set the value related to the column: count_user
	 * @param countUser the count_user value
	 */
	public void setCountUser (java.lang.Integer countUser) {
		this.countUser = countUser;
	}



	/**
	 * Return the value associated with the column: login_name
	 */
	public java.lang.String getLoginName () {
		return loginName;
	}

	/**
	 * Set the value related to the column: login_name
	 * @param loginName the login_name value
	 */
	public void setLoginName (java.lang.String loginName) {
		this.loginName = loginName;
	}



	/**
	 * Return the value associated with the column: user_name
	 */
	public java.lang.String getUserName () {
		return userName;
	}

	/**
	 * Set the value related to the column: user_name
	 * @param userName the user_name value
	 */
	public void setUserName (java.lang.String userName) {
		this.userName = userName;
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
	 * Return the value associated with the column: status_sha1
	 */
	public java.lang.String getStatusSHA1 () {
		return statusSHA1;
	}

	/**
	 * Set the value related to the column: status_sha1
	 * @param statusSHA1 the status_sha1 value
	 */
	public void setStatusSHA1 (java.lang.String statusSHA1) {
		this.statusSHA1 = statusSHA1;
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
	 * Return the value associated with the column: email_address
	 */
	public java.lang.String getEmailAddress () {
		return emailAddress;
	}

	/**
	 * Set the value related to the column: email_address
	 * @param emailAddress the email_address value
	 */
	public void setEmailAddress (java.lang.String emailAddress) {
		this.emailAddress = emailAddress;
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
	 * Return the value associated with the column: reset_flag
	 */
	public java.lang.String getResetFlag () {
		return resetFlag;
	}

	/**
	 * Set the value related to the column: reset_flag
	 * @param resetFlag the reset_flag value
	 */
	public void setResetFlag (java.lang.String resetFlag) {
		this.resetFlag = resetFlag;
	}



	/**
	 * Return the value associated with the column: reset_complete_on
	 */
	public java.util.Date getResetCompleteOn () {
		return resetCompleteOn;
	}

	/**
	 * Set the value related to the column: reset_complete_on
	 * @param resetCompleteOn the reset_complete_on value
	 */
	public void setResetCompleteOn (java.util.Date resetCompleteOn) {
		this.resetCompleteOn = resetCompleteOn;
	}



	/**
	 * Return the value associated with the column: reset_req_on
	 */
	public java.util.Date getResetReqOn () {
		return resetReqOn;
	}

	/**
	 * Set the value related to the column: reset_req_on
	 * @param resetReqOn the reset_req_on value
	 */
	public void setResetReqOn (java.util.Date resetReqOn) {
		this.resetReqOn = resetReqOn;
	}



	/**
	 * Return the value associated with the column: reset_count
	 */
	public java.lang.Integer getResetCount () {
		return resetCount;
	}

	/**
	 * Set the value related to the column: reset_count
	 * @param resetCount the reset_count value
	 */
	public void setResetCount (java.lang.Integer resetCount) {
		this.resetCount = resetCount;
	}



	/**
	 * Return the value associated with the column: employee_id
	 */
	public jkt.hms.masters.business.MasEmployee getEmployee () {
		return employee;
	}

	/**
	 * Set the value related to the column: employee_id
	 * @param employee the employee_id value
	 */
	public void setEmployee (jkt.hms.masters.business.MasEmployee employee) {
		this.employee = employee;
	}



	/**
	 * Return the value associated with the column: UserUsergroupHospitals
	 */
	public java.util.Set<jkt.hms.masters.business.UserUsergroupHospital> getUserUsergroupHospitals () {
		return userUsergroupHospitals;
	}

	/**
	 * Set the value related to the column: UserUsergroupHospitals
	 * @param userUsergroupHospitals the UserUsergroupHospitals value
	 */
	public void setUserUsergroupHospitals (java.util.Set<jkt.hms.masters.business.UserUsergroupHospital> userUsergroupHospitals) {
		this.userUsergroupHospitals = userUsergroupHospitals;
	}

	public void addToUserUsergroupHospitals (jkt.hms.masters.business.UserUsergroupHospital userUsergroupHospital) {
		if (null == getUserUsergroupHospitals()) setUserUsergroupHospitals(new java.util.TreeSet<jkt.hms.masters.business.UserUsergroupHospital>());
		getUserUsergroupHospitals().add(userUsergroupHospital);
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
	 * Return the value associated with the column: DischargeIcdCodes
	 */
	public java.util.Set<jkt.hms.masters.business.DischargeIcdCode> getDischargeIcdCodes () {
		return dischargeIcdCodes;
	}

	/**
	 * Set the value related to the column: DischargeIcdCodes
	 * @param dischargeIcdCodes the DischargeIcdCodes value
	 */
	public void setDischargeIcdCodes (java.util.Set<jkt.hms.masters.business.DischargeIcdCode> dischargeIcdCodes) {
		this.dischargeIcdCodes = dischargeIcdCodes;
	}

	public void addToDischargeIcdCodes (jkt.hms.masters.business.DischargeIcdCode dischargeIcdCode) {
		if (null == getDischargeIcdCodes()) setDischargeIcdCodes(new java.util.TreeSet<jkt.hms.masters.business.DischargeIcdCode>());
		getDischargeIcdCodes().add(dischargeIcdCode);
	}



	/**
	 * Return the value associated with the column: Patients
	 */
	public java.util.Set<jkt.hms.masters.business.Patient> getPatients () {
		return patients;
	}

	/**
	 * Set the value related to the column: Patients
	 * @param patients the Patients value
	 */
	public void setPatients (java.util.Set<jkt.hms.masters.business.Patient> patients) {
		this.patients = patients;
	}

	public void addToPatients (jkt.hms.masters.business.Patient patient) {
		if (null == getPatients()) setPatients(new java.util.TreeSet<jkt.hms.masters.business.Patient>());
		getPatients().add(patient);
	}



	/**
	 * Return the value associated with the column: AttachInpatients
	 */
	public java.util.Set<jkt.hms.masters.business.AttachInpatient> getAttachInpatients () {
		return attachInpatients;
	}

	/**
	 * Set the value related to the column: AttachInpatients
	 * @param attachInpatients the AttachInpatients value
	 */
	public void setAttachInpatients (java.util.Set<jkt.hms.masters.business.AttachInpatient> attachInpatients) {
		this.attachInpatients = attachInpatients;
	}

	public void addToAttachInpatients (jkt.hms.masters.business.AttachInpatient attachInpatient) {
		if (null == getAttachInpatients()) setAttachInpatients(new java.util.TreeSet<jkt.hms.masters.business.AttachInpatient>());
		getAttachInpatients().add(attachInpatient);
	}



	/**
	 * Return the value associated with the column: UserDepartments
	 */
	public java.util.Set<jkt.hms.masters.business.UserDepartment> getUserDepartments () {
		return userDepartments;
	}

	/**
	 * Set the value related to the column: UserDepartments
	 * @param userDepartments the UserDepartments value
	 */
	public void setUserDepartments (java.util.Set<jkt.hms.masters.business.UserDepartment> userDepartments) {
		this.userDepartments = userDepartments;
	}

	public void addToUserDepartments (jkt.hms.masters.business.UserDepartment userDepartment) {
		if (null == getUserDepartments()) setUserDepartments(new java.util.TreeSet<jkt.hms.masters.business.UserDepartment>());
		getUserDepartments().add(userDepartment);
	}



	/**
	 * Return the value associated with the column: BlReceipts
	 */
	public java.util.Set<jkt.hms.masters.business.BlReceipt> getBlReceipts () {
		return blReceipts;
	}

	/**
	 * Set the value related to the column: BlReceipts
	 * @param blReceipts the BlReceipts value
	 */
	public void setBlReceipts (java.util.Set<jkt.hms.masters.business.BlReceipt> blReceipts) {
		this.blReceipts = blReceipts;
	}

	public void addToBlReceipts (jkt.hms.masters.business.BlReceipt blReceipt) {
		if (null == getBlReceipts()) setBlReceipts(new java.util.TreeSet<jkt.hms.masters.business.BlReceipt>());
		getBlReceipts().add(blReceipt);
	}



	/**
	 * Return the value associated with the column: BlOpBillMains
	 */
	public java.util.Set<jkt.hms.masters.business.BlOpBillMain> getBlOpBillMains () {
		return blOpBillMains;
	}

	/**
	 * Set the value related to the column: BlOpBillMains
	 * @param blOpBillMains the BlOpBillMains value
	 */
	public void setBlOpBillMains (java.util.Set<jkt.hms.masters.business.BlOpBillMain> blOpBillMains) {
		this.blOpBillMains = blOpBillMains;
	}

	public void addToBlOpBillMains (jkt.hms.masters.business.BlOpBillMain blOpBillMain) {
		if (null == getBlOpBillMains()) setBlOpBillMains(new java.util.TreeSet<jkt.hms.masters.business.BlOpBillMain>());
		getBlOpBillMains().add(blOpBillMain);
	}



	/**
	 * Return the value associated with the column: UserStatusHospitals
	 */
	public java.util.Set<jkt.hms.masters.business.UserStatusHospital> getUserStatusHospitals () {
		return userStatusHospitals;
	}

	/**
	 * Set the value related to the column: UserStatusHospitals
	 * @param userStatusHospitals the UserStatusHospitals value
	 */
	public void setUserStatusHospitals (java.util.Set<jkt.hms.masters.business.UserStatusHospital> userStatusHospitals) {
		this.userStatusHospitals = userStatusHospitals;
	}

	public void addToUserStatusHospitals (jkt.hms.masters.business.UserStatusHospital userStatusHospital) {
		if (null == getUserStatusHospitals()) setUserStatusHospitals(new java.util.TreeSet<jkt.hms.masters.business.UserStatusHospital>());
		getUserStatusHospitals().add(userStatusHospital);
	}



	/**
	 * Return the value associated with the column: UserUsergroupApplications
	 */
	public java.util.Set<jkt.hms.masters.business.UserUsergroupApplication> getUserUsergroupApplications () {
		return userUsergroupApplications;
	}

	/**
	 * Set the value related to the column: UserUsergroupApplications
	 * @param userUsergroupApplications the UserUsergroupApplications value
	 */
	public void setUserUsergroupApplications (java.util.Set<jkt.hms.masters.business.UserUsergroupApplication> userUsergroupApplications) {
		this.userUsergroupApplications = userUsergroupApplications;
	}

	public void addToUserUsergroupApplications (jkt.hms.masters.business.UserUsergroupApplication userUsergroupApplication) {
		if (null == getUserUsergroupApplications()) setUserUsergroupApplications(new java.util.TreeSet<jkt.hms.masters.business.UserUsergroupApplication>());
		getUserUsergroupApplications().add(userUsergroupApplication);
	}



	/**
	 * Return the value associated with the column: ExpiryDetails
	 */
	public java.util.Set<jkt.hms.masters.business.ExpiryDetails> getExpiryDetails () {
		return expiryDetails;
	}

	/**
	 * Set the value related to the column: ExpiryDetails
	 * @param expiryDetails the ExpiryDetails value
	 */
	public void setExpiryDetails (java.util.Set<jkt.hms.masters.business.ExpiryDetails> expiryDetails) {
		this.expiryDetails = expiryDetails;
	}

	public void addToExpiryDetails (jkt.hms.masters.business.ExpiryDetails expiryDetails) {
		if (null == getExpiryDetails()) setExpiryDetails(new java.util.TreeSet<jkt.hms.masters.business.ExpiryDetails>());
		getExpiryDetails().add(expiryDetails);
	}



	/**
	 * Return the value associated with the column: UserHospitalDepartments
	 */
	public java.util.Set<jkt.hms.masters.business.UserHospitalDepartment> getUserHospitalDepartments () {
		return userHospitalDepartments;
	}

	/**
	 * Set the value related to the column: UserHospitalDepartments
	 * @param userHospitalDepartments the UserHospitalDepartments value
	 */
	public void setUserHospitalDepartments (java.util.Set<jkt.hms.masters.business.UserHospitalDepartment> userHospitalDepartments) {
		this.userHospitalDepartments = userHospitalDepartments;
	}

	public void addToUserHospitalDepartments (jkt.hms.masters.business.UserHospitalDepartment userHospitalDepartment) {
		if (null == getUserHospitalDepartments()) setUserHospitalDepartments(new java.util.TreeSet<jkt.hms.masters.business.UserHospitalDepartment>());
		getUserHospitalDepartments().add(userHospitalDepartment);
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
	 * Return the value associated with the column: UserHospitalRoles
	 */
	public java.util.Set<jkt.hms.masters.business.UserHospitalRole> getUserHospitalRoles () {
		return userHospitalRoles;
	}

	/**
	 * Set the value related to the column: UserHospitalRoles
	 * @param userHospitalRoles the UserHospitalRoles value
	 */
	public void setUserHospitalRoles (java.util.Set<jkt.hms.masters.business.UserHospitalRole> userHospitalRoles) {
		this.userHospitalRoles = userHospitalRoles;
	}

	public void addToUserHospitalRoles (jkt.hms.masters.business.UserHospitalRole userHospitalRole) {
		if (null == getUserHospitalRoles()) setUserHospitalRoles(new java.util.TreeSet<jkt.hms.masters.business.UserHospitalRole>());
		getUserHospitalRoles().add(userHospitalRole);
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
	 * Return the value associated with the column: BlOpBillDetails
	 */
	public java.util.Set<jkt.hms.masters.business.BlOpBillDetail> getBlOpBillDetails () {
		return blOpBillDetails;
	}

	/**
	 * Set the value related to the column: BlOpBillDetails
	 * @param blOpBillDetails the BlOpBillDetails value
	 */
	public void setBlOpBillDetails (java.util.Set<jkt.hms.masters.business.BlOpBillDetail> blOpBillDetails) {
		this.blOpBillDetails = blOpBillDetails;
	}

	public void addToBlOpBillDetails (jkt.hms.masters.business.BlOpBillDetail blOpBillDetail) {
		if (null == getBlOpBillDetails()) setBlOpBillDetails(new java.util.TreeSet<jkt.hms.masters.business.BlOpBillDetail>());
		getBlOpBillDetails().add(blOpBillDetail);
	}



	/**
	 * Return the value associated with the column: UserAccessrightsHospitals
	 */
	public java.util.Set<jkt.hms.masters.business.UserAccessrightsHospital> getUserAccessrightsHospitals () {
		return userAccessrightsHospitals;
	}

	/**
	 * Set the value related to the column: UserAccessrightsHospitals
	 * @param userAccessrightsHospitals the UserAccessrightsHospitals value
	 */
	public void setUserAccessrightsHospitals (java.util.Set<jkt.hms.masters.business.UserAccessrightsHospital> userAccessrightsHospitals) {
		this.userAccessrightsHospitals = userAccessrightsHospitals;
	}

	public void addToUserAccessrightsHospitals (jkt.hms.masters.business.UserAccessrightsHospital userAccessrightsHospital) {
		if (null == getUserAccessrightsHospitals()) setUserAccessrightsHospitals(new java.util.TreeSet<jkt.hms.masters.business.UserAccessrightsHospital>());
		getUserAccessrightsHospitals().add(userAccessrightsHospital);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.Users)) return false;
		else {
			jkt.hms.masters.business.Users users = (jkt.hms.masters.business.Users) obj;
			if (null == this.getId() || null == users.getId()) return false;
			else return (this.getId().equals(users.getId()));
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